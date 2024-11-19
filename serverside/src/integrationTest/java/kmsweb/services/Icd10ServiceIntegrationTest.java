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
import kmsweb.entities.Icd10Entity;
import kmsweb.repositories.Icd10Repository;
import kmsweb.utils.Icd10Factory;
import kmsweb.utils.DatabasePopulators.Icd10DatabasePopulator;
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
public class Icd10ServiceIntegrationTest {

	@Autowired
	private Icd10Repository icd10Repository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private Icd10Service icd10Service;

	private final Icd10Factory icd10Factory = new Icd10Factory();

	@Autowired
	private Icd10DatabasePopulator icd10DatabasePopulator;

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
		icd10Service = new Icd10Service(
			diagnosesAndProceduresRepository,
			validator,
			auditRepository,
			icd10Repository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewIcd10EntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		Icd10Entity icd10Entity = icd10Factory.getObject(false, false);

		Icd10Entity updatedEntity = icd10Service.updateOldData(icd10Entity);
		Assertions.assertEquals(icd10Entity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewIcd10EntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		Icd10Entity icd10Entity = icd10Factory.getObject(false, false);

		icd10Entity.setClassificationDisease(null);
		Assertions.assertNull(icd10Entity.getClassificationDisease());

		icd10Entity.setClassificationInfectious(null);
		Assertions.assertNull(icd10Entity.getClassificationInfectious());

		icd10Entity.setClassificationChronic(null);
		Assertions.assertNull(icd10Entity.getClassificationChronic());

		icd10Entity.setClassificationTopDisease(null);
		Assertions.assertNull(icd10Entity.getClassificationTopDisease());

		icd10Entity.setClassificationRestrictedCase(null);
		Assertions.assertNull(icd10Entity.getClassificationRestrictedCase());

		icd10Entity.setClassificationReportableCase(null);
		Assertions.assertNull(icd10Entity.getClassificationReportableCase());

		icd10Entity.setClassificationAcute(null);
		Assertions.assertNull(icd10Entity.getClassificationAcute());


		Icd10Entity updatedEntity = icd10Service.updateOldData(icd10Entity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getClassificationDisease());
		Assertions.assertFalse(updatedEntity.getClassificationDisease());

		Assertions.assertNotNull(updatedEntity.getClassificationInfectious());
		Assertions.assertFalse(updatedEntity.getClassificationInfectious());

		Assertions.assertNotNull(updatedEntity.getClassificationChronic());
		Assertions.assertFalse(updatedEntity.getClassificationChronic());

		Assertions.assertNotNull(updatedEntity.getClassificationTopDisease());
		Assertions.assertFalse(updatedEntity.getClassificationTopDisease());

		Assertions.assertNotNull(updatedEntity.getClassificationRestrictedCase());
		Assertions.assertFalse(updatedEntity.getClassificationRestrictedCase());

		Assertions.assertNotNull(updatedEntity.getClassificationReportableCase());
		Assertions.assertFalse(updatedEntity.getClassificationReportableCase());

		Assertions.assertNotNull(updatedEntity.getClassificationAcute());
		Assertions.assertFalse(updatedEntity.getClassificationAcute());

	}

	@Test
	public void updateOldDataWithExistingIcd10Entity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			Icd10Entity icd10Entity;
			Icd10Entity entityWithUpdatedValues;

			try {
				icd10Entity = icd10Factory.getObject(false, false);
				icd10DatabasePopulator.populateRelatedEntitiesInDatabase(icd10Entity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = icd10Factory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			icd10Entity = icd10Service.create(icd10Entity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(icd10Entity.getId());

			Icd10Entity updatedEntity = icd10Service.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithIcd10EntityWithNonExistentId_ShouldThrowException() throws Exception {
		Icd10Entity icd10Entity = icd10Factory.getObject(false, false);
		icd10Entity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			icd10Service.updateOldData(icd10Entity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingIcd10EntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			Icd10Entity icd10Entity;
			Icd10Entity updatedIcd10Entity;

			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				icd10Entity = icd10Factory.getObject(true, false);
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
			diagnosesAndProceduresEntity = icd10Entity.getDiagnosesAndProcedures();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosesAndProceduresEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			diagnosesAndProceduresEntity = diagnosesAndProceduresRepository.save(diagnosesAndProceduresEntity);
			icd10Entity.setDiagnosesAndProceduresId(diagnosesAndProceduresEntity.getId());


			icd10Entity = icd10Service.create(icd10Entity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(icd10Entity.getDiagnosesAndProcedures());
			icd10Entity.setDiagnosesAndProceduresId(null);
			icd10Entity.unsetDiagnosesAndProcedures();


			updatedIcd10Entity = icd10Service.updateOldData(icd10Entity);

			Assertions.assertNull(updatedIcd10Entity.getDiagnosesAndProcedures());

		});
	}

	@Test
	public void updateOldDataWithIcd10EntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			Icd10Entity icd10Entity;
			Icd10Entity updatedIcd10Entity;

			DiagnosesAndProceduresEntity diagnosesAndProceduresEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				icd10Entity = icd10Factory.getObject(true, false);
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
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(icd10Entity.getDiagnosesAndProcedures(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Diagnoses and Procedures relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			diagnosesAndProceduresEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(icd10Entity.getDiagnosesAndProcedures()).getId()).get();
			icd10Entity.unsetDiagnosesAndProcedures();
			icd10Entity.setDiagnosesAndProceduresId(diagnosesAndProceduresEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedIcd10Entity = icd10Service.updateOldData(icd10Entity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			diagnosesAndProceduresEntity.unsetMasterICD10(false);
			updatedIcd10Entity.getDiagnosesAndProcedures().unsetMasterICD10(false);
			Assertions.assertEquals(diagnosesAndProceduresEntity, updatedIcd10Entity.getDiagnosesAndProcedures());

		});
	}

	@Test
	public void whenCreateIcd10Entity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			Icd10Entity icd10Entity;
			Optional<Icd10Entity> fetchedIcd10Entity;

			try {
				icd10Entity = icd10Factory.getObject(false, false);
				icd10DatabasePopulator.populateRelatedEntitiesInDatabase(icd10Entity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			icd10Entity = icd10Service.create(icd10Entity);

			fetchedIcd10Entity = icd10Service.findById(icd10Entity.getId());

			Assertions.assertTrue(fetchedIcd10Entity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedIcd10Entity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(icd10Entity, fetchedIcd10Entity.get());
		});
	}

	@Test
	public void whenUpdateIcd10Entity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			Icd10Entity icd10Entity;
			Icd10Entity updatedIcd10Entity;
			Optional<Icd10Entity> fetchedIcd10Entity;

			try {
				icd10Entity = icd10Factory.getObject(false, false);
				icd10DatabasePopulator.populateRelatedEntitiesInDatabase(icd10Entity, true, true, false);
				updatedIcd10Entity = icd10Factory.getObject(false, false);
				icd10DatabasePopulator.populateRelatedEntitiesInDatabase(updatedIcd10Entity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			icd10Entity = icd10Service.create(icd10Entity);

			updatedIcd10Entity.setId(icd10Entity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedIcd10Entity.setCreated(icd10Entity.getCreated());

			updatedIcd10Entity = icd10Service.update(updatedIcd10Entity);

			fetchedIcd10Entity = icd10Service.findById(icd10Entity.getId());

			Assertions.assertTrue(fetchedIcd10Entity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateIcd10Entity_ThenEntityIsCreated
			fetchedIcd10Entity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedIcd10Entity, fetchedIcd10Entity.get());
		});
	}

	@Test
	public void whenDeleteIcd10Entity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			Icd10Entity icd10Entity;
			Optional<Icd10Entity> fetchedIcd10Entity;

			try {
				icd10Entity = icd10Factory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				icd10DatabasePopulator.populateRelatedEntitiesInDatabase(icd10Entity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			icd10Entity = icd10Service.create(icd10Entity);

			icd10Service.deleteById(icd10Entity.getId());
			fetchedIcd10Entity = icd10Service.findById(icd10Entity.getId());

			Assertions.assertTrue(fetchedIcd10Entity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
