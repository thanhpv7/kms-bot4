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
import kmsweb.entities.HemodialysisExaminationEntity;
import kmsweb.repositories.HemodialysisExaminationRepository;
import kmsweb.utils.HemodialysisExaminationFactory;
import kmsweb.utils.DatabasePopulators.HemodialysisExaminationDatabasePopulator;
import kmsweb.entities.HemodialysisMonitoringEntity;
import kmsweb.repositories.HemodialysisMonitoringRepository;
import kmsweb.utils.HemodialysisMonitoringFactory;
import kmsweb.utils.DatabasePopulators.HemodialysisMonitoringDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.utils.MedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDatabasePopulator;
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
public class HemodialysisExaminationServiceIntegrationTest {

	@Autowired
	private HemodialysisExaminationRepository hemodialysisExaminationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private HemodialysisExaminationService hemodialysisExaminationService;

	private final HemodialysisExaminationFactory hemodialysisExaminationFactory = new HemodialysisExaminationFactory();

	@Autowired
	private HemodialysisExaminationDatabasePopulator hemodialysisExaminationDatabasePopulator;

	@Autowired
	private HemodialysisMonitoringRepository hemodialysisMonitoringRepository;

	@Autowired
	private HemodialysisMonitoringDatabasePopulator hemodialysisMonitoringDatabasePopulator;

	private final HemodialysisMonitoringFactory hemodialysisMonitoringFactory = new HemodialysisMonitoringFactory();

	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	@Autowired
	private MedicalExaminationRecordDatabasePopulator medicalExaminationRecordDatabasePopulator;

	private final MedicalExaminationRecordFactory medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		hemodialysisExaminationService = new HemodialysisExaminationService(
			hemodialysisMonitoringRepository,
			medicalExaminationRecordRepository,
			validator,
			auditRepository,
			hemodialysisExaminationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewHemodialysisExaminationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		HemodialysisExaminationEntity hemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(false, false);

		HemodialysisExaminationEntity updatedEntity = hemodialysisExaminationService.updateOldData(hemodialysisExaminationEntity);
		Assertions.assertEquals(hemodialysisExaminationEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewHemodialysisExaminationEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		HemodialysisExaminationEntity hemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(false, false);

		hemodialysisExaminationEntity.setAntiHIV(null);
		Assertions.assertNull(hemodialysisExaminationEntity.getAntiHIV());

		hemodialysisExaminationEntity.setHbsag(null);
		Assertions.assertNull(hemodialysisExaminationEntity.getHbsag());

		hemodialysisExaminationEntity.setAntiHCV(null);
		Assertions.assertNull(hemodialysisExaminationEntity.getAntiHCV());


		HemodialysisExaminationEntity updatedEntity = hemodialysisExaminationService.updateOldData(hemodialysisExaminationEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getAntiHIV());
		Assertions.assertFalse(updatedEntity.getAntiHIV());

		Assertions.assertNotNull(updatedEntity.getHbsag());
		Assertions.assertFalse(updatedEntity.getHbsag());

		Assertions.assertNotNull(updatedEntity.getAntiHCV());
		Assertions.assertFalse(updatedEntity.getAntiHCV());

	}

	@Test
	public void updateOldDataWithExistingHemodialysisExaminationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisExaminationEntity hemodialysisExaminationEntity;
			HemodialysisExaminationEntity entityWithUpdatedValues;

			try {
				hemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(false, false);
				hemodialysisExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisExaminationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = hemodialysisExaminationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hemodialysisExaminationEntity = hemodialysisExaminationService.create(hemodialysisExaminationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(hemodialysisExaminationEntity.getId());

			HemodialysisExaminationEntity updatedEntity = hemodialysisExaminationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithHemodialysisExaminationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		HemodialysisExaminationEntity hemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(false, false);
		hemodialysisExaminationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			hemodialysisExaminationService.updateOldData(hemodialysisExaminationEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingHemodialysisExaminationEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisExaminationEntity hemodialysisExaminationEntity;
			HemodialysisExaminationEntity updatedHemodialysisExaminationEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			Set<HemodialysisMonitoringEntity> hemodialysisMonitoringsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				hemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(true, false);
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
			medicalExaminationRecordEntity = hemodialysisExaminationEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			hemodialysisExaminationEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			hemodialysisMonitoringsEntities = hemodialysisExaminationEntity.getHemodialysisMonitorings();
			Set<UUID> hemodialysisMonitoringsEntityIds = new HashSet<>();
			for (HemodialysisMonitoringEntity entity : hemodialysisMonitoringsEntities) {
				try {
					hemodialysisMonitoringDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				hemodialysisMonitoringsEntityIds.add(hemodialysisMonitoringRepository.save(entity).getId());
			}
			hemodialysisExaminationEntity.setHemodialysisMonitoringsIds(hemodialysisMonitoringsEntityIds);


			hemodialysisExaminationEntity = hemodialysisExaminationService.create(hemodialysisExaminationEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(hemodialysisExaminationEntity.getMedicalExaminationRecord());
			hemodialysisExaminationEntity.setMedicalExaminationRecordId(null);
			hemodialysisExaminationEntity.unsetMedicalExaminationRecord();

			Assertions.assertTrue(hemodialysisExaminationEntity.getHemodialysisMonitorings().size() > 0);
			hemodialysisExaminationEntity.setHemodialysisMonitoringsIds(new HashSet<UUID>());
			hemodialysisExaminationEntity.unsetHemodialysisMonitorings();


			updatedHemodialysisExaminationEntity = hemodialysisExaminationService.updateOldData(hemodialysisExaminationEntity);

			Assertions.assertNull(updatedHemodialysisExaminationEntity.getMedicalExaminationRecord());

			Assertions.assertEquals(0, updatedHemodialysisExaminationEntity.getHemodialysisMonitorings().size());

		});
	}

	@Test
	public void updateOldDataWithHemodialysisExaminationEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisExaminationEntity hemodialysisExaminationEntity;
			HemodialysisExaminationEntity updatedHemodialysisExaminationEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			Set<HemodialysisMonitoringEntity> hemodialysisMonitoringsEntities;
			Set<UUID> hemodialysisMonitoringsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				hemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(true, false);
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
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisExaminationEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(hemodialysisExaminationEntity.getMedicalExaminationRecord()).getId()).get();
			hemodialysisExaminationEntity.unsetMedicalExaminationRecord();
			hemodialysisExaminationEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			hemodialysisMonitoringsEntities = new HashSet<>();
			hemodialysisMonitoringsEntityIds = new HashSet<>();
			for (HemodialysisMonitoringEntity entity : hemodialysisExaminationEntity.getHemodialysisMonitorings()) {
				try {
					hemodialysisMonitoringDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Hemodialysis Monitorings relation for this test: " + e.getCause());
					return;
				}
				UUID id = hemodialysisMonitoringRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				hemodialysisMonitoringsEntities.add(hemodialysisMonitoringRepository.findById(id).get());
				hemodialysisMonitoringsEntityIds.add(id);
			}
			hemodialysisExaminationEntity.unsetHemodialysisMonitorings();
			hemodialysisExaminationEntity.setHemodialysisMonitoringsIds(hemodialysisMonitoringsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedHemodialysisExaminationEntity = hemodialysisExaminationService.updateOldData(hemodialysisExaminationEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicalExaminationRecordEntity.unsetHemodialysisExamination(false);
			updatedHemodialysisExaminationEntity.getMedicalExaminationRecord().unsetHemodialysisExamination(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedHemodialysisExaminationEntity.getMedicalExaminationRecord());

			Assertions.assertEquals(hemodialysisMonitoringsEntities.size(), updatedHemodialysisExaminationEntity.getHemodialysisMonitorings().size());

		});
	}

	@Test
	public void whenCreateHemodialysisExaminationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisExaminationEntity hemodialysisExaminationEntity;
			Optional<HemodialysisExaminationEntity> fetchedHemodialysisExaminationEntity;

			try {
				hemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(false, false);
				hemodialysisExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisExaminationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hemodialysisExaminationEntity = hemodialysisExaminationService.create(hemodialysisExaminationEntity);

			fetchedHemodialysisExaminationEntity = hemodialysisExaminationService.findById(hemodialysisExaminationEntity.getId());

			Assertions.assertTrue(fetchedHemodialysisExaminationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedHemodialysisExaminationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(hemodialysisExaminationEntity, fetchedHemodialysisExaminationEntity.get());
		});
	}

	@Test
	public void whenUpdateHemodialysisExaminationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisExaminationEntity hemodialysisExaminationEntity;
			HemodialysisExaminationEntity updatedHemodialysisExaminationEntity;
			Optional<HemodialysisExaminationEntity> fetchedHemodialysisExaminationEntity;

			try {
				hemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(false, false);
				hemodialysisExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisExaminationEntity, true, true, false);
				updatedHemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(false, false);
				hemodialysisExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedHemodialysisExaminationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hemodialysisExaminationEntity = hemodialysisExaminationService.create(hemodialysisExaminationEntity);

			updatedHemodialysisExaminationEntity.setId(hemodialysisExaminationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedHemodialysisExaminationEntity.setCreated(hemodialysisExaminationEntity.getCreated());

			updatedHemodialysisExaminationEntity = hemodialysisExaminationService.update(updatedHemodialysisExaminationEntity);

			fetchedHemodialysisExaminationEntity = hemodialysisExaminationService.findById(hemodialysisExaminationEntity.getId());

			Assertions.assertTrue(fetchedHemodialysisExaminationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateHemodialysisExaminationEntity_ThenEntityIsCreated
			fetchedHemodialysisExaminationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedHemodialysisExaminationEntity, fetchedHemodialysisExaminationEntity.get());
		});
	}

	@Test
	public void whenDeleteHemodialysisExaminationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			HemodialysisExaminationEntity hemodialysisExaminationEntity;
			Optional<HemodialysisExaminationEntity> fetchedHemodialysisExaminationEntity;

			try {
				hemodialysisExaminationEntity = hemodialysisExaminationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				hemodialysisExaminationDatabasePopulator.populateRelatedEntitiesInDatabase(hemodialysisExaminationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			hemodialysisExaminationEntity = hemodialysisExaminationService.create(hemodialysisExaminationEntity);

			hemodialysisExaminationService.deleteById(hemodialysisExaminationEntity.getId());
			fetchedHemodialysisExaminationEntity = hemodialysisExaminationService.findById(hemodialysisExaminationEntity.getId());

			Assertions.assertTrue(fetchedHemodialysisExaminationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
