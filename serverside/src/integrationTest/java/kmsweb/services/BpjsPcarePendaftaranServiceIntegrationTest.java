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
import kmsweb.entities.BpjsPcarePendaftaranEntity;
import kmsweb.repositories.BpjsPcarePendaftaranRepository;
import kmsweb.utils.BpjsPcarePendaftaranFactory;
import kmsweb.utils.DatabasePopulators.BpjsPcarePendaftaranDatabasePopulator;
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
public class BpjsPcarePendaftaranServiceIntegrationTest {

	@Autowired
	private BpjsPcarePendaftaranRepository bpjsPcarePendaftaranRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private BpjsPcarePendaftaranService bpjsPcarePendaftaranService;

	private final BpjsPcarePendaftaranFactory bpjsPcarePendaftaranFactory = new BpjsPcarePendaftaranFactory();

	@Autowired
	private BpjsPcarePendaftaranDatabasePopulator bpjsPcarePendaftaranDatabasePopulator;

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
		bpjsPcarePendaftaranService = new BpjsPcarePendaftaranService(
			patientVisitRepository,
			validator,
			auditRepository,
			bpjsPcarePendaftaranRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewBpjsPcarePendaftaranEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranFactory.getObject(false, false);

		BpjsPcarePendaftaranEntity updatedEntity = bpjsPcarePendaftaranService.updateOldData(bpjsPcarePendaftaranEntity);
		Assertions.assertEquals(bpjsPcarePendaftaranEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingBpjsPcarePendaftaranEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntity;
			BpjsPcarePendaftaranEntity entityWithUpdatedValues;

			try {
				bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranFactory.getObject(false, false);
				bpjsPcarePendaftaranDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcarePendaftaranEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = bpjsPcarePendaftaranFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.create(bpjsPcarePendaftaranEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(bpjsPcarePendaftaranEntity.getId());

			BpjsPcarePendaftaranEntity updatedEntity = bpjsPcarePendaftaranService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithBpjsPcarePendaftaranEntityWithNonExistentId_ShouldThrowException() throws Exception {
		BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranFactory.getObject(false, false);
		bpjsPcarePendaftaranEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			bpjsPcarePendaftaranService.updateOldData(bpjsPcarePendaftaranEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingBpjsPcarePendaftaranEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntity;
			BpjsPcarePendaftaranEntity updatedBpjsPcarePendaftaranEntity;

			PatientVisitEntity patientVisitEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranFactory.getObject(true, false);
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
			patientVisitEntity = bpjsPcarePendaftaranEntity.getPatientVisit();
			try {
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(patientVisitEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			patientVisitEntity = patientVisitRepository.save(patientVisitEntity);
			bpjsPcarePendaftaranEntity.setPatientVisitId(patientVisitEntity.getId());


			bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.create(bpjsPcarePendaftaranEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(bpjsPcarePendaftaranEntity.getPatientVisit());
			bpjsPcarePendaftaranEntity.setPatientVisitId(null);
			bpjsPcarePendaftaranEntity.unsetPatientVisit();


			updatedBpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.updateOldData(bpjsPcarePendaftaranEntity);

			Assertions.assertNull(updatedBpjsPcarePendaftaranEntity.getPatientVisit());

		});
	}

	@Test
	public void updateOldDataWithBpjsPcarePendaftaranEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntity;
			BpjsPcarePendaftaranEntity updatedBpjsPcarePendaftaranEntity;

			PatientVisitEntity patientVisitEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranFactory.getObject(true, false);
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
				patientVisitDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcarePendaftaranEntity.getPatientVisit(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Patient Visit relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			patientVisitEntity = patientVisitRepository.findById(patientVisitRepository.save(bpjsPcarePendaftaranEntity.getPatientVisit()).getId()).get();
			bpjsPcarePendaftaranEntity.unsetPatientVisit();
			bpjsPcarePendaftaranEntity.setPatientVisitId(patientVisitEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedBpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.updateOldData(bpjsPcarePendaftaranEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			patientVisitEntity.unsetBpjsPcarePendaftarans(false);
			updatedBpjsPcarePendaftaranEntity.getPatientVisit().unsetBpjsPcarePendaftarans(false);
			Assertions.assertEquals(patientVisitEntity, updatedBpjsPcarePendaftaranEntity.getPatientVisit());

		});
	}

	@Test
	public void whenCreateBpjsPcarePendaftaranEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntity;
			Optional<BpjsPcarePendaftaranEntity> fetchedBpjsPcarePendaftaranEntity;

			try {
				bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranFactory.getObject(false, false);
				bpjsPcarePendaftaranDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcarePendaftaranEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.create(bpjsPcarePendaftaranEntity);

			fetchedBpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.findById(bpjsPcarePendaftaranEntity.getId());

			Assertions.assertTrue(fetchedBpjsPcarePendaftaranEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedBpjsPcarePendaftaranEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(bpjsPcarePendaftaranEntity, fetchedBpjsPcarePendaftaranEntity.get());
		});
	}

	@Test
	public void whenUpdateBpjsPcarePendaftaranEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntity;
			BpjsPcarePendaftaranEntity updatedBpjsPcarePendaftaranEntity;
			Optional<BpjsPcarePendaftaranEntity> fetchedBpjsPcarePendaftaranEntity;

			try {
				bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranFactory.getObject(false, false);
				bpjsPcarePendaftaranDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcarePendaftaranEntity, true, true, false);
				updatedBpjsPcarePendaftaranEntity = bpjsPcarePendaftaranFactory.getObject(false, false);
				bpjsPcarePendaftaranDatabasePopulator.populateRelatedEntitiesInDatabase(updatedBpjsPcarePendaftaranEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.create(bpjsPcarePendaftaranEntity);

			updatedBpjsPcarePendaftaranEntity.setId(bpjsPcarePendaftaranEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedBpjsPcarePendaftaranEntity.setCreated(bpjsPcarePendaftaranEntity.getCreated());

			updatedBpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.update(updatedBpjsPcarePendaftaranEntity);

			fetchedBpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.findById(bpjsPcarePendaftaranEntity.getId());

			Assertions.assertTrue(fetchedBpjsPcarePendaftaranEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateBpjsPcarePendaftaranEntity_ThenEntityIsCreated
			fetchedBpjsPcarePendaftaranEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedBpjsPcarePendaftaranEntity, fetchedBpjsPcarePendaftaranEntity.get());
		});
	}

	@Test
	public void whenDeleteBpjsPcarePendaftaranEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			BpjsPcarePendaftaranEntity bpjsPcarePendaftaranEntity;
			Optional<BpjsPcarePendaftaranEntity> fetchedBpjsPcarePendaftaranEntity;

			try {
				bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				bpjsPcarePendaftaranDatabasePopulator.populateRelatedEntitiesInDatabase(bpjsPcarePendaftaranEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			bpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.create(bpjsPcarePendaftaranEntity);

			bpjsPcarePendaftaranService.deleteById(bpjsPcarePendaftaranEntity.getId());
			fetchedBpjsPcarePendaftaranEntity = bpjsPcarePendaftaranService.findById(bpjsPcarePendaftaranEntity.getId());

			Assertions.assertTrue(fetchedBpjsPcarePendaftaranEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
