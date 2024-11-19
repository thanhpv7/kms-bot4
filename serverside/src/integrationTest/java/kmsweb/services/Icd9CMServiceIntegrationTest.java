/*
 * @bot-written
 *
 * WARNING AND NOTICE
 * Any access, download, storage, and/or use of this source code is subject to the terms and conditions of the
 * Full Software Licence as accepted by you before being granted access to this source code and other materials,
 * the terms of which can be accessed on the Codebots website at https://codebots.com/full-software-licence. Any
 * commercial use in contravention of the terms of the Full Software Licence may be pursued by Codebots through
 * licence termination and further legal action, and be required to indemnify Codebots for any loss or damage,
 * including interest and costs. You are deemed to have accepted the terms of the Full Software Licence on any
 * access, download, storage, and/or use of this source code.
 *
 * BOT WARNING
 * This file is bot-written.
 * Any changes out side of "protected regions" will be lost next time the bot makes any changes.
 */

package kmsweb.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;
import kmsweb.SpringTestConfiguration;
import kmsweb.configs.security.helpers.AnonymousHelper;
import kmsweb.entities.Icd9CMEntity;
import kmsweb.repositories.Icd9CMRepository;
import kmsweb.utils.Icd9CMFactory;
import kmsweb.utils.DatabasePopulators.Icd9CMDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.repositories.auditing.AuditingRepository;

import javax.validation.Validator;

import java.util.*;
import java.util.stream.Collectors;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
// % protected region % [Add any additional class annotations here] off begin
// % protected region % [Add any additional class annotations here] end
public class Icd9CMServiceIntegrationTest {

	@Autowired
	private Icd9CMRepository icd9CMRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private Icd9CMService icd9CMService;

	private final Icd9CMFactory icd9CMFactory = new Icd9CMFactory();

	@Autowired
	private Icd9CMDatabasePopulator icd9CMDatabasePopulator;

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		icd9CMService = new Icd9CMService(
			diagnosesAndProceduresRepository,
			validator,
			auditRepository,
			icd9CMRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewIcd9CMEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		Icd9CMEntity icd9CMEntity = icd9CMFactory.getObject(false, false);

		Icd9CMEntity updatedEntity = icd9CMService.updateOldData(icd9CMEntity);
		Assertions.assertEquals(icd9CMEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewIcd9CMEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		Icd9CMEntity icd9CMEntity = icd9CMFactory.getObject(false, false);

		icd9CMEntity.setTopProcedure(null);
		Assertions.assertNull(icd9CMEntity.getTopProcedure());


		Icd9CMEntity updatedEntity = icd9CMService.updateOldData(icd9CMEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getTopProcedure());
		Assertions.assertFalse(updatedEntity.getTopProcedure());

	}

	@Test
	public void updateOldDataWithExistingIcd9CMEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			Icd9CMEntity icd9CMEntity;
			Icd9CMEntity entityWithUpdatedValues;

			try {
				icd9CMEntity = icd9CMFactory.getObject(false, false);
				icd9CMDatabasePopulator.populateRelatedEntitiesInDatabase(icd9CMEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = icd9CMFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			icd9CMEntity = icd9CMService.create(icd9CMEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(icd9CMEntity.getId());

			Icd9CMEntity updatedEntity = icd9CMService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithIcd9CMEntityWithNonExistentId_ShouldThrowException() throws Exception {
		Icd9CMEntity icd9CMEntity = icd9CMFactory.getObject(false, false);
		icd9CMEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			icd9CMService.updateOldData(icd9CMEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingIcd9CMEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			Icd9CMEntity icd9CMEntity;
			Icd9CMEntity updatedIcd9CMEntity;

			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				icd9CMEntity = icd9CMFactory.getObject(true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			/*
				As this test is checking that removing a reference entity works, we need to add the
				reference entities to the database
			 */
			diagnosesAndProceduresEntity = icd9CMEntity.getDiagnosesAndProcedures();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			diagnosesAndProceduresEntity = diagnosesAndProceduresRepository.save(diagnosesAndProceduresEntity);
			icd9CMEntity.setDiagnosesAndProceduresId(diagnosesAndProceduresEntity.getId());


			icd9CMEntity = icd9CMService.create(icd9CMEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(icd9CMEntity.getDiagnosesAndProcedures());
			icd9CMEntity.setDiagnosesAndProceduresId(null);
			icd9CMEntity.unsetDiagnosesAndProcedures();


			updatedIcd9CMEntity = icd9CMService.updateOldData(icd9CMEntity);

			Assertions.assertNull(updatedIcd9CMEntity.getDiagnosesAndProcedures());

		});
	}

	@Test
	public void updateOldDataWithIcd9CMEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			Icd9CMEntity icd9CMEntity;
			Icd9CMEntity updatedIcd9CMEntity;

			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				icd9CMEntity = icd9CMFactory.getObject(true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			/*
				Expected state of the entity prior to updateOldData when trying to add a reference
				is that the reference id is set, but the reference entity is not set.  Therefore,
				we need to remove the reference entity and set the reference id, as this will set up
				the state we expect to see for this test.

				We also need to populate the required relations for all related entities, as creating any entities
				with required references will cause an error (and a subsequent test failure) if we do not
			 */
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(icd9CMEntity.getDiagnosesAndProcedures(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Diagnoses and Procedures relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			diagnosesAndProceduresEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(icd9CMEntity.getDiagnosesAndProcedures()).getId()).get();
			icd9CMEntity.unsetDiagnosesAndProcedures();
			icd9CMEntity.setDiagnosesAndProceduresId(diagnosesAndProceduresEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedIcd9CMEntity = icd9CMService.updateOldData(icd9CMEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			diagnosesAndProceduresEntity.unsetMasterICD9CM(false);
			updatedIcd9CMEntity.getDiagnosesAndProcedures().unsetMasterICD9CM(false);
			Assertions.assertEquals(diagnosesAndProceduresEntity, updatedIcd9CMEntity.getDiagnosesAndProcedures());

		});
	}

	@Test
	public void whenCreateIcd9CMEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			Icd9CMEntity icd9CMEntity;
			Optional<Icd9CMEntity> fetchedIcd9CMEntity;

			try {
				icd9CMEntity = icd9CMFactory.getObject(false, false);
				icd9CMDatabasePopulator.populateRelatedEntitiesInDatabase(icd9CMEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			icd9CMEntity = icd9CMService.create(icd9CMEntity);

			fetchedIcd9CMEntity = icd9CMService.findById(icd9CMEntity.getId());

			Assertions.assertTrue(fetchedIcd9CMEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedIcd9CMEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(icd9CMEntity, fetchedIcd9CMEntity.get());
		});
	}

	@Test
	public void whenUpdateIcd9CMEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			Icd9CMEntity icd9CMEntity;
			Icd9CMEntity updatedIcd9CMEntity;
			Optional<Icd9CMEntity> fetchedIcd9CMEntity;

			try {
				icd9CMEntity = icd9CMFactory.getObject(false, false);
				icd9CMDatabasePopulator.populateRelatedEntitiesInDatabase(icd9CMEntity, true, true, false);
				updatedIcd9CMEntity = icd9CMFactory.getObject(false, false);
				icd9CMDatabasePopulator.populateRelatedEntitiesInDatabase(updatedIcd9CMEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			icd9CMEntity = icd9CMService.create(icd9CMEntity);

			updatedIcd9CMEntity.setId(icd9CMEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedIcd9CMEntity.setCreated(icd9CMEntity.getCreated());

			updatedIcd9CMEntity = icd9CMService.update(updatedIcd9CMEntity);

			fetchedIcd9CMEntity = icd9CMService.findById(icd9CMEntity.getId());

			Assertions.assertTrue(fetchedIcd9CMEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateIcd9CMEntity_ThenEntityIsCreated
			fetchedIcd9CMEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedIcd9CMEntity, fetchedIcd9CMEntity.get());
		});
	}

	@Test
	public void whenDeleteIcd9CMEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			Icd9CMEntity icd9CMEntity;
			Optional<Icd9CMEntity> fetchedIcd9CMEntity;

			try {
				icd9CMEntity = icd9CMFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				icd9CMDatabasePopulator.populateRelatedEntitiesInDatabase(icd9CMEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			icd9CMEntity = icd9CMService.create(icd9CMEntity);

			icd9CMService.deleteById(icd9CMEntity.getId());
			fetchedIcd9CMEntity = icd9CMService.findById(icd9CMEntity.getId());

			Assertions.assertTrue(fetchedIcd9CMEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
