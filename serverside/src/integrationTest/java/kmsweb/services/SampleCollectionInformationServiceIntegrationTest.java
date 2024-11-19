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
import kmsweb.entities.SampleCollectionInformationEntity;
import kmsweb.repositories.SampleCollectionInformationRepository;
import kmsweb.utils.SampleCollectionInformationFactory;
import kmsweb.utils.DatabasePopulators.SampleCollectionInformationDatabasePopulator;
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.repositories.DiagnosisExaminationRecordRepository;
import kmsweb.utils.DiagnosisExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.DiagnosisExaminationRecordDatabasePopulator;
import kmsweb.entities.RegistrationEntity;
import kmsweb.repositories.RegistrationRepository;
import kmsweb.utils.RegistrationFactory;
import kmsweb.utils.DatabasePopulators.RegistrationDatabasePopulator;
import kmsweb.entities.SampleCollectionItemsEntity;
import kmsweb.repositories.SampleCollectionItemsRepository;
import kmsweb.utils.SampleCollectionItemsFactory;
import kmsweb.utils.DatabasePopulators.SampleCollectionItemsDatabasePopulator;
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
public class SampleCollectionInformationServiceIntegrationTest {

	@Autowired
	private SampleCollectionInformationRepository sampleCollectionInformationRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private SampleCollectionInformationService sampleCollectionInformationService;

	private final SampleCollectionInformationFactory sampleCollectionInformationFactory = new SampleCollectionInformationFactory();

	@Autowired
	private SampleCollectionInformationDatabasePopulator sampleCollectionInformationDatabasePopulator;

	@Autowired
	private DiagnosisExaminationRecordRepository diagnosisExaminationRecordRepository;

	@Autowired
	private DiagnosisExaminationRecordDatabasePopulator diagnosisExaminationRecordDatabasePopulator;

	private final DiagnosisExaminationRecordFactory diagnosisExaminationRecordFactory = new DiagnosisExaminationRecordFactory();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private RegistrationDatabasePopulator registrationDatabasePopulator;

	private final RegistrationFactory registrationFactory = new RegistrationFactory();

	@Autowired
	private SampleCollectionItemsRepository sampleCollectionItemsRepository;

	@Autowired
	private SampleCollectionItemsDatabasePopulator sampleCollectionItemsDatabasePopulator;

	private final SampleCollectionItemsFactory sampleCollectionItemsFactory = new SampleCollectionItemsFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		sampleCollectionInformationService = new SampleCollectionInformationService(
			diagnosisExaminationRecordRepository,
			registrationRepository,
			sampleCollectionItemsRepository,
			validator,
			auditRepository,
			sampleCollectionInformationRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewSampleCollectionInformationEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		SampleCollectionInformationEntity sampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(false, false);

		SampleCollectionInformationEntity updatedEntity = sampleCollectionInformationService.updateOldData(sampleCollectionInformationEntity);
		Assertions.assertEquals(sampleCollectionInformationEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewSampleCollectionInformationEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		SampleCollectionInformationEntity sampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(false, false);

		sampleCollectionInformationEntity.setPatientInformed(null);
		Assertions.assertNull(sampleCollectionInformationEntity.getPatientInformed());

		sampleCollectionInformationEntity.setPatientConsented(null);
		Assertions.assertNull(sampleCollectionInformationEntity.getPatientConsented());

		sampleCollectionInformationEntity.setPatientFastedEnough(null);
		Assertions.assertNull(sampleCollectionInformationEntity.getPatientFastedEnough());

		sampleCollectionInformationEntity.setMedicationTakenIn24Hours(null);
		Assertions.assertNull(sampleCollectionInformationEntity.getMedicationTakenIn24Hours());

		sampleCollectionInformationEntity.setMedicationTakenIn72Hours(null);
		Assertions.assertNull(sampleCollectionInformationEntity.getMedicationTakenIn72Hours());


		SampleCollectionInformationEntity updatedEntity = sampleCollectionInformationService.updateOldData(sampleCollectionInformationEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getPatientInformed());
		Assertions.assertFalse(updatedEntity.getPatientInformed());

		Assertions.assertNotNull(updatedEntity.getPatientConsented());
		Assertions.assertFalse(updatedEntity.getPatientConsented());

		Assertions.assertNotNull(updatedEntity.getPatientFastedEnough());
		Assertions.assertFalse(updatedEntity.getPatientFastedEnough());

		Assertions.assertNotNull(updatedEntity.getMedicationTakenIn24Hours());
		Assertions.assertFalse(updatedEntity.getMedicationTakenIn24Hours());

		Assertions.assertNotNull(updatedEntity.getMedicationTakenIn72Hours());
		Assertions.assertFalse(updatedEntity.getMedicationTakenIn72Hours());

	}

	@Test
	public void updateOldDataWithExistingSampleCollectionInformationEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionInformationEntity sampleCollectionInformationEntity;
			SampleCollectionInformationEntity entityWithUpdatedValues;

			try {
				sampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(false, false);
				sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionInformationEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = sampleCollectionInformationFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			sampleCollectionInformationEntity = sampleCollectionInformationService.create(sampleCollectionInformationEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(sampleCollectionInformationEntity.getId());

			SampleCollectionInformationEntity updatedEntity = sampleCollectionInformationService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithSampleCollectionInformationEntityWithNonExistentId_ShouldThrowException() throws Exception {
		SampleCollectionInformationEntity sampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(false, false);
		sampleCollectionInformationEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			sampleCollectionInformationService.updateOldData(sampleCollectionInformationEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingSampleCollectionInformationEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionInformationEntity sampleCollectionInformationEntity;
			SampleCollectionInformationEntity updatedSampleCollectionInformationEntity;

			DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity;

			RegistrationEntity registrationEntity;

			Set<SampleCollectionItemsEntity> sampleCollectionItemsEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				sampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(true, false);
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
			diagnosisExaminationRecordEntity = sampleCollectionInformationEntity.getDiagnosisExaminationRecord();
			try {
				diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			diagnosisExaminationRecordEntity = diagnosisExaminationRecordRepository.save(diagnosisExaminationRecordEntity);
			sampleCollectionInformationEntity.setDiagnosisExaminationRecordId(diagnosisExaminationRecordEntity.getId());

			registrationEntity = sampleCollectionInformationEntity.getRegistration();
			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(registrationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			registrationEntity = registrationRepository.save(registrationEntity);
			sampleCollectionInformationEntity.setRegistrationId(registrationEntity.getId());

			sampleCollectionItemsEntities = sampleCollectionInformationEntity.getSampleCollectionItems();
			Set<UUID> sampleCollectionItemsEntityIds = new HashSet<>();
			for (SampleCollectionItemsEntity entity : sampleCollectionItemsEntities) {
				try {
					sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				sampleCollectionItemsEntityIds.add(sampleCollectionItemsRepository.save(entity).getId());
			}
			sampleCollectionInformationEntity.setSampleCollectionItemsIds(sampleCollectionItemsEntityIds);


			sampleCollectionInformationEntity = sampleCollectionInformationService.create(sampleCollectionInformationEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(sampleCollectionInformationEntity.getDiagnosisExaminationRecord());
			sampleCollectionInformationEntity.setDiagnosisExaminationRecordId(null);
			sampleCollectionInformationEntity.unsetDiagnosisExaminationRecord();

			Assertions.assertNotNull(sampleCollectionInformationEntity.getRegistration());
			sampleCollectionInformationEntity.setRegistrationId(null);
			sampleCollectionInformationEntity.unsetRegistration();

			Assertions.assertTrue(sampleCollectionInformationEntity.getSampleCollectionItems().size() > 0);
			sampleCollectionInformationEntity.setSampleCollectionItemsIds(new HashSet<UUID>());
			sampleCollectionInformationEntity.unsetSampleCollectionItems();


			updatedSampleCollectionInformationEntity = sampleCollectionInformationService.updateOldData(sampleCollectionInformationEntity);

			Assertions.assertNull(updatedSampleCollectionInformationEntity.getDiagnosisExaminationRecord());

			Assertions.assertNull(updatedSampleCollectionInformationEntity.getRegistration());

			Assertions.assertEquals(0, updatedSampleCollectionInformationEntity.getSampleCollectionItems().size());

		});
	}

	@Test
	public void updateOldDataWithSampleCollectionInformationEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionInformationEntity sampleCollectionInformationEntity;
			SampleCollectionInformationEntity updatedSampleCollectionInformationEntity;

			DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity;

			RegistrationEntity registrationEntity;

			Set<SampleCollectionItemsEntity> sampleCollectionItemsEntities;
			Set<UUID> sampleCollectionItemsEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				sampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(true, false);
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
				diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionInformationEntity.getDiagnosisExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Diagnosis Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			diagnosisExaminationRecordEntity = diagnosisExaminationRecordRepository.findById(diagnosisExaminationRecordRepository.save(sampleCollectionInformationEntity.getDiagnosisExaminationRecord()).getId()).get();
			sampleCollectionInformationEntity.unsetDiagnosisExaminationRecord();
			sampleCollectionInformationEntity.setDiagnosisExaminationRecordId(diagnosisExaminationRecordEntity.getId());

			try {
				registrationDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionInformationEntity.getRegistration(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Registration relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			registrationEntity = registrationRepository.findById(registrationRepository.save(sampleCollectionInformationEntity.getRegistration()).getId()).get();
			sampleCollectionInformationEntity.unsetRegistration();
			sampleCollectionInformationEntity.setRegistrationId(registrationEntity.getId());

			sampleCollectionItemsEntities = new HashSet<>();
			sampleCollectionItemsEntityIds = new HashSet<>();
			for (SampleCollectionItemsEntity entity : sampleCollectionInformationEntity.getSampleCollectionItems()) {
				try {
					sampleCollectionItemsDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Sample Collection Items relation for this test: " + e.getCause());
					return;
				}
				UUID id = sampleCollectionItemsRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				sampleCollectionItemsEntities.add(sampleCollectionItemsRepository.findById(id).get());
				sampleCollectionItemsEntityIds.add(id);
			}
			sampleCollectionInformationEntity.unsetSampleCollectionItems();
			sampleCollectionInformationEntity.setSampleCollectionItemsIds(sampleCollectionItemsEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedSampleCollectionInformationEntity = sampleCollectionInformationService.updateOldData(sampleCollectionInformationEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			diagnosisExaminationRecordEntity.unsetSampleCollectionInformation(false);
			updatedSampleCollectionInformationEntity.getDiagnosisExaminationRecord().unsetSampleCollectionInformation(false);
			Assertions.assertEquals(diagnosisExaminationRecordEntity, updatedSampleCollectionInformationEntity.getDiagnosisExaminationRecord());

			registrationEntity.unsetSampleCollectionInformations(false);
			updatedSampleCollectionInformationEntity.getRegistration().unsetSampleCollectionInformations(false);
			Assertions.assertEquals(registrationEntity, updatedSampleCollectionInformationEntity.getRegistration());

			Assertions.assertEquals(sampleCollectionItemsEntities.size(), updatedSampleCollectionInformationEntity.getSampleCollectionItems().size());

		});
	}

	@Test
	public void whenCreateSampleCollectionInformationEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionInformationEntity sampleCollectionInformationEntity;
			Optional<SampleCollectionInformationEntity> fetchedSampleCollectionInformationEntity;

			try {
				sampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(false, false);
				sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionInformationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			sampleCollectionInformationEntity = sampleCollectionInformationService.create(sampleCollectionInformationEntity);

			fetchedSampleCollectionInformationEntity = sampleCollectionInformationService.findById(sampleCollectionInformationEntity.getId());

			Assertions.assertTrue(fetchedSampleCollectionInformationEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedSampleCollectionInformationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(sampleCollectionInformationEntity, fetchedSampleCollectionInformationEntity.get());
		});
	}

	@Test
	public void whenUpdateSampleCollectionInformationEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionInformationEntity sampleCollectionInformationEntity;
			SampleCollectionInformationEntity updatedSampleCollectionInformationEntity;
			Optional<SampleCollectionInformationEntity> fetchedSampleCollectionInformationEntity;

			try {
				sampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(false, false);
				sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionInformationEntity, true, true, false);
				updatedSampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(false, false);
				sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(updatedSampleCollectionInformationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			sampleCollectionInformationEntity = sampleCollectionInformationService.create(sampleCollectionInformationEntity);

			updatedSampleCollectionInformationEntity.setId(sampleCollectionInformationEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedSampleCollectionInformationEntity.setCreated(sampleCollectionInformationEntity.getCreated());

			updatedSampleCollectionInformationEntity = sampleCollectionInformationService.update(updatedSampleCollectionInformationEntity);

			fetchedSampleCollectionInformationEntity = sampleCollectionInformationService.findById(sampleCollectionInformationEntity.getId());

			Assertions.assertTrue(fetchedSampleCollectionInformationEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateSampleCollectionInformationEntity_ThenEntityIsCreated
			fetchedSampleCollectionInformationEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedSampleCollectionInformationEntity, fetchedSampleCollectionInformationEntity.get());
		});
	}

	@Test
	public void whenDeleteSampleCollectionInformationEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			SampleCollectionInformationEntity sampleCollectionInformationEntity;
			Optional<SampleCollectionInformationEntity> fetchedSampleCollectionInformationEntity;

			try {
				sampleCollectionInformationEntity = sampleCollectionInformationFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionInformationEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			sampleCollectionInformationEntity = sampleCollectionInformationService.create(sampleCollectionInformationEntity);

			sampleCollectionInformationService.deleteById(sampleCollectionInformationEntity.getId());
			fetchedSampleCollectionInformationEntity = sampleCollectionInformationService.findById(sampleCollectionInformationEntity.getId());

			Assertions.assertTrue(fetchedSampleCollectionInformationEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
