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
import kmsweb.entities.PatientVisitPatientPaymentOthersEntity;
import kmsweb.repositories.PatientVisitPatientPaymentOthersRepository;
import kmsweb.utils.PatientVisitPatientPaymentOthersFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitPatientPaymentOthersDatabasePopulator;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.repositories.PatientVisitRepository;
import kmsweb.utils.PatientVisitFactory;
import kmsweb.utils.DatabasePopulators.PatientVisitDatabasePopulator;
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
public class PatientVisitPatientPaymentOthersServiceIntegrationTest {

	@Autowired
	private PatientVisitPatientPaymentOthersRepository patientVisitPatientPaymentOthersRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private PatientVisitPatientPaymentOthersService patientVisitPatientPaymentOthersService;

	private final PatientVisitPatientPaymentOthersFactory patientVisitPatientPaymentOthersFactory = new PatientVisitPatientPaymentOthersFactory();

	@Autowired
	private PatientVisitPatientPaymentOthersDatabasePopulator patientVisitPatientPaymentOthersDatabasePopulator;

	@Autowired
	private PatientVisitRepository patientVisitRepository;

	@Autowired
	private PatientVisitDatabasePopulator patientVisitDatabasePopulator;

	private final PatientVisitFactory patientVisitFactory = new PatientVisitFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		patientVisitPatientPaymentOthersService = new PatientVisitPatientPaymentOthersService(
			patientVisitRepository,
			validator,
			auditRepository,
			patientVisitPatientPaymentOthersRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewPatientVisitPatientPaymentOthersEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersFactory.getObject(false, false);

		PatientVisitPatientPaymentOthersEntity updatedEntity = patientVisitPatientPaymentOthersService.updateOldData(patientVisitPatientPaymentOthersEntity);
		Assertions.assertEquals(patientVisitPatientPaymentOthersEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingPatientVisitPatientPaymentOthersEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity;
			PatientVisitPatientPaymentOthersEntity entityWithUpdatedValues;

			try {
				patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersFactory.getObject(false, false);
				patientVisitPatientPaymentOthersDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentOthersEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = patientVisitPatientPaymentOthersFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.create(patientVisitPatientPaymentOthersEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(patientVisitPatientPaymentOthersEntity.getId());

			PatientVisitPatientPaymentOthersEntity updatedEntity = patientVisitPatientPaymentOthersService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithPatientVisitPatientPaymentOthersEntityWithNonExistentId_ShouldThrowException() throws Exception {
		PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersFactory.getObject(false, false);
		patientVisitPatientPaymentOthersEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			patientVisitPatientPaymentOthersService.updateOldData(patientVisitPatientPaymentOthersEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingPatientVisitPatientPaymentOthersEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity;
			PatientVisitPatientPaymentOthersEntity updatedPatientVisitPatientPaymentOthersEntity;

			PatientVisitEntity patientVisitEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersFactory.getObject(true, false);
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
			patientVisitEntity = patientVisitPatientPaymentOthersEntity.getPatientVisit();
			try {
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientVisitEntity = patientVisitRepository.save(patientVisitEntity);
			patientVisitPatientPaymentOthersEntity.setPatientVisitId(patientVisitEntity.getId());


			patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.create(patientVisitPatientPaymentOthersEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(patientVisitPatientPaymentOthersEntity.getPatientVisit());
			patientVisitPatientPaymentOthersEntity.setPatientVisitId(null);
			patientVisitPatientPaymentOthersEntity.unsetPatientVisit();


			updatedPatientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.updateOldData(patientVisitPatientPaymentOthersEntity);

			Assertions.assertNull(updatedPatientVisitPatientPaymentOthersEntity.getPatientVisit());

		});
	}

	@Test
	public void updateOldDataWithPatientVisitPatientPaymentOthersEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity;
			PatientVisitPatientPaymentOthersEntity updatedPatientVisitPatientPaymentOthersEntity;

			PatientVisitEntity patientVisitEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersFactory.getObject(true, false);
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
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentOthersEntity.getPatientVisit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Visit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientVisitEntity = patientVisitRepository.findById(patientVisitRepository.save(patientVisitPatientPaymentOthersEntity.getPatientVisit()).getId()).get();
			patientVisitPatientPaymentOthersEntity.unsetPatientVisit();
			patientVisitPatientPaymentOthersEntity.setPatientVisitId(patientVisitEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedPatientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.updateOldData(patientVisitPatientPaymentOthersEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientVisitEntity.unsetPatientVisitPatientPaymentOthers(false);
			updatedPatientVisitPatientPaymentOthersEntity.getPatientVisit().unsetPatientVisitPatientPaymentOthers(false);
			Assertions.assertEquals(patientVisitEntity, updatedPatientVisitPatientPaymentOthersEntity.getPatientVisit());

		});
	}

	@Test
	public void whenCreatePatientVisitPatientPaymentOthersEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity;
			Optional<PatientVisitPatientPaymentOthersEntity> fetchedPatientVisitPatientPaymentOthersEntity;

			try {
				patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersFactory.getObject(false, false);
				patientVisitPatientPaymentOthersDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentOthersEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.create(patientVisitPatientPaymentOthersEntity);

			fetchedPatientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.findById(patientVisitPatientPaymentOthersEntity.getId());

			Assertions.assertTrue(fetchedPatientVisitPatientPaymentOthersEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedPatientVisitPatientPaymentOthersEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(patientVisitPatientPaymentOthersEntity, fetchedPatientVisitPatientPaymentOthersEntity.get());
		});
	}

	@Test
	public void whenUpdatePatientVisitPatientPaymentOthersEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity;
			PatientVisitPatientPaymentOthersEntity updatedPatientVisitPatientPaymentOthersEntity;
			Optional<PatientVisitPatientPaymentOthersEntity> fetchedPatientVisitPatientPaymentOthersEntity;

			try {
				patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersFactory.getObject(false, false);
				patientVisitPatientPaymentOthersDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentOthersEntity, true, true, false);
				updatedPatientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersFactory.getObject(false, false);
				patientVisitPatientPaymentOthersDatabasePopulator.populateRelatedEntitiesInDatabase(updatedPatientVisitPatientPaymentOthersEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.create(patientVisitPatientPaymentOthersEntity);

			updatedPatientVisitPatientPaymentOthersEntity.setId(patientVisitPatientPaymentOthersEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedPatientVisitPatientPaymentOthersEntity.setCreated(patientVisitPatientPaymentOthersEntity.getCreated());

			updatedPatientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.update(updatedPatientVisitPatientPaymentOthersEntity);

			fetchedPatientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.findById(patientVisitPatientPaymentOthersEntity.getId());

			Assertions.assertTrue(fetchedPatientVisitPatientPaymentOthersEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreatePatientVisitPatientPaymentOthersEntity_ThenEntityIsCreated
			fetchedPatientVisitPatientPaymentOthersEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedPatientVisitPatientPaymentOthersEntity, fetchedPatientVisitPatientPaymentOthersEntity.get());
		});
	}

	@Test
	public void whenDeletePatientVisitPatientPaymentOthersEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthersEntity;
			Optional<PatientVisitPatientPaymentOthersEntity> fetchedPatientVisitPatientPaymentOthersEntity;

			try {
				patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				patientVisitPatientPaymentOthersDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitPatientPaymentOthersEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			patientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.create(patientVisitPatientPaymentOthersEntity);

			patientVisitPatientPaymentOthersService.deleteById(patientVisitPatientPaymentOthersEntity.getId());
			fetchedPatientVisitPatientPaymentOthersEntity = patientVisitPatientPaymentOthersService.findById(patientVisitPatientPaymentOthersEntity.getId());

			Assertions.assertTrue(fetchedPatientVisitPatientPaymentOthersEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
