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
import kmsweb.entities.DiagnosisNandaEntity;
import kmsweb.repositories.DiagnosisNandaRepository;
import kmsweb.utils.DiagnosisNandaFactory;
import kmsweb.utils.DatabasePopulators.DiagnosisNandaDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.utils.MedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import kmsweb.repositories.OperatingTheaterMedicalExaminationRecordRepository;
import kmsweb.utils.OperatingTheaterMedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.OperatingTheaterMedicalExaminationRecordDatabasePopulator;
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
public class DiagnosisNandaServiceIntegrationTest {

	@Autowired
	private DiagnosisNandaRepository diagnosisNandaRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private DiagnosisNandaService diagnosisNandaService;

	private final DiagnosisNandaFactory diagnosisNandaFactory = new DiagnosisNandaFactory();

	@Autowired
	private DiagnosisNandaDatabasePopulator diagnosisNandaDatabasePopulator;

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();

	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	@Autowired
	private MedicalExaminationRecordDatabasePopulator medicalExaminationRecordDatabasePopulator;

	private final MedicalExaminationRecordFactory medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();

	@Autowired
	private OperatingTheaterMedicalExaminationRecordRepository operatingTheaterMedicalExaminationRecordRepository;

	@Autowired
	private OperatingTheaterMedicalExaminationRecordDatabasePopulator operatingTheaterMedicalExaminationRecordDatabasePopulator;

	private final OperatingTheaterMedicalExaminationRecordFactory operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		diagnosisNandaService = new DiagnosisNandaService(
			diagnosesAndProceduresRepository,
			medicalExaminationRecordRepository,
			operatingTheaterMedicalExaminationRecordRepository,
			validator,
			auditRepository,
			diagnosisNandaRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewDiagnosisNandaEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		DiagnosisNandaEntity diagnosisNandaEntity = diagnosisNandaFactory.getObject(false, false);

		DiagnosisNandaEntity updatedEntity = diagnosisNandaService.updateOldData(diagnosisNandaEntity);
		Assertions.assertEquals(diagnosisNandaEntity, updatedEntity);
	}


	@Test
	public void updateOldDataWithExistingDiagnosisNandaEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisNandaEntity diagnosisNandaEntity;
			DiagnosisNandaEntity entityWithUpdatedValues;

			try {
				diagnosisNandaEntity = diagnosisNandaFactory.getObject(false, false);
				diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisNandaEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = diagnosisNandaFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosisNandaEntity = diagnosisNandaService.create(diagnosisNandaEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(diagnosisNandaEntity.getId());

			DiagnosisNandaEntity updatedEntity = diagnosisNandaService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithDiagnosisNandaEntityWithNonExistentId_ShouldThrowException() throws Exception {
		DiagnosisNandaEntity diagnosisNandaEntity = diagnosisNandaFactory.getObject(false, false);
		diagnosisNandaEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			diagnosisNandaService.updateOldData(diagnosisNandaEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingDiagnosisNandaEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisNandaEntity diagnosisNandaEntity;
			DiagnosisNandaEntity updatedDiagnosisNandaEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			Set<OperatingTheaterMedicalExaminationRecordEntity> nursingAnesthesiaDetailEntities;

			Set<OperatingTheaterMedicalExaminationRecordEntity> nursingSurgicalDetailEntities;

			Set<DiagnosesAndProceduresEntity> nursingEntities;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				diagnosisNandaEntity = diagnosisNandaFactory.getObject(true, false);
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
			medicalExaminationRecordEntity = diagnosisNandaEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			diagnosisNandaEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			nursingAnesthesiaDetailEntities = diagnosisNandaEntity.getNursingAnesthesiaDetail();
			Set<UUID> nursingAnesthesiaDetailEntityIds = new HashSet<>();
			for (OperatingTheaterMedicalExaminationRecordEntity entity : nursingAnesthesiaDetailEntities) {
				try {
					operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				nursingAnesthesiaDetailEntityIds.add(operatingTheaterMedicalExaminationRecordRepository.save(entity).getId());
			}
			diagnosisNandaEntity.setNursingAnesthesiaDetailIds(nursingAnesthesiaDetailEntityIds);

			nursingSurgicalDetailEntities = diagnosisNandaEntity.getNursingSurgicalDetail();
			Set<UUID> nursingSurgicalDetailEntityIds = new HashSet<>();
			for (OperatingTheaterMedicalExaminationRecordEntity entity : nursingSurgicalDetailEntities) {
				try {
					operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				nursingSurgicalDetailEntityIds.add(operatingTheaterMedicalExaminationRecordRepository.save(entity).getId());
			}
			diagnosisNandaEntity.setNursingSurgicalDetailIds(nursingSurgicalDetailEntityIds);

			nursingEntities = diagnosisNandaEntity.getNursing();
			Set<UUID> nursingEntityIds = new HashSet<>();
			for (DiagnosesAndProceduresEntity entity : nursingEntities) {
				try {
					diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
					return;
				}
				nursingEntityIds.add(diagnosesAndProceduresRepository.save(entity).getId());
			}
			diagnosisNandaEntity.setNursingIds(nursingEntityIds);

			diagnosisNandaEntity = diagnosisNandaService.create(diagnosisNandaEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(diagnosisNandaEntity.getMedicalExaminationRecord());
			diagnosisNandaEntity.setMedicalExaminationRecordId(null);
			diagnosisNandaEntity.unsetMedicalExaminationRecord();

			Assertions.assertTrue(diagnosisNandaEntity.getNursingAnesthesiaDetail().size() > 0);
			diagnosisNandaEntity.setNursingAnesthesiaDetailIds(new HashSet<UUID>());
			diagnosisNandaEntity.unsetNursingAnesthesiaDetail();

			Assertions.assertTrue(diagnosisNandaEntity.getNursingSurgicalDetail().size() > 0);
			diagnosisNandaEntity.setNursingSurgicalDetailIds(new HashSet<UUID>());
			diagnosisNandaEntity.unsetNursingSurgicalDetail();

			Assertions.assertTrue(diagnosisNandaEntity.getNursing().size() > 0);
			diagnosisNandaEntity.setNursingIds(new HashSet<UUID>());
			diagnosisNandaEntity.unsetNursing();


			updatedDiagnosisNandaEntity = diagnosisNandaService.updateOldData(diagnosisNandaEntity);

			Assertions.assertNull(updatedDiagnosisNandaEntity.getMedicalExaminationRecord());

			Assertions.assertEquals(0, updatedDiagnosisNandaEntity.getNursingAnesthesiaDetail().size());

			Assertions.assertEquals(0, updatedDiagnosisNandaEntity.getNursingSurgicalDetail().size());

			Assertions.assertEquals(0, updatedDiagnosisNandaEntity.getNursing().size());

		});
	}

	@Test
	public void updateOldDataWithDiagnosisNandaEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisNandaEntity diagnosisNandaEntity;
			DiagnosisNandaEntity updatedDiagnosisNandaEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			Set<OperatingTheaterMedicalExaminationRecordEntity> nursingAnesthesiaDetailEntities;
			Set<UUID> nursingAnesthesiaDetailEntityIds;

			Set<OperatingTheaterMedicalExaminationRecordEntity> nursingSurgicalDetailEntities;
			Set<UUID> nursingSurgicalDetailEntityIds;

			Set<DiagnosesAndProceduresEntity> nursingEntities;
			Set<UUID> nursingEntityIds;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				diagnosisNandaEntity = diagnosisNandaFactory.getObject(true, false);
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
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisNandaEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(diagnosisNandaEntity.getMedicalExaminationRecord()).getId()).get();
			diagnosisNandaEntity.unsetMedicalExaminationRecord();
			diagnosisNandaEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			nursingAnesthesiaDetailEntities = new HashSet<>();
			nursingAnesthesiaDetailEntityIds = new HashSet<>();
			for (OperatingTheaterMedicalExaminationRecordEntity entity : diagnosisNandaEntity.getNursingAnesthesiaDetail()) {
				try {
					operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Nursing Anesthesia Detail relation for this test: " + e.getCause());
					return;
				}
				UUID id = operatingTheaterMedicalExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				nursingAnesthesiaDetailEntities.add(operatingTheaterMedicalExaminationRecordRepository.findById(id).get());
				nursingAnesthesiaDetailEntityIds.add(id);
			}
			diagnosisNandaEntity.unsetNursingAnesthesiaDetail();
			diagnosisNandaEntity.setNursingAnesthesiaDetailIds(nursingAnesthesiaDetailEntityIds);

			nursingSurgicalDetailEntities = new HashSet<>();
			nursingSurgicalDetailEntityIds = new HashSet<>();
			for (OperatingTheaterMedicalExaminationRecordEntity entity : diagnosisNandaEntity.getNursingSurgicalDetail()) {
				try {
					operatingTheaterMedicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the Nursing Surgical Detail relation for this test: " + e.getCause());
					return;
				}
				UUID id = operatingTheaterMedicalExaminationRecordRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				nursingSurgicalDetailEntities.add(operatingTheaterMedicalExaminationRecordRepository.findById(id).get());
				nursingSurgicalDetailEntityIds.add(id);
			}
			diagnosisNandaEntity.unsetNursingSurgicalDetail();
			diagnosisNandaEntity.setNursingSurgicalDetailIds(nursingSurgicalDetailEntityIds);

			nursingEntities = new HashSet<>();
			nursingEntityIds = new HashSet<>();
			for (DiagnosesAndProceduresEntity entity : diagnosisNandaEntity.getNursing()) {
				try {
					diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(entity, true, true, true);
				} catch (Exception e) {
					Assertions.fail("Failed to populate the NURSING relation for this test: " + e.getCause());
					return;
				}
				UUID id = diagnosesAndProceduresRepository.save(entity).getId();
				// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
				// executes successfully, the get method will always produce an Optional object which contains the entity
				nursingEntities.add(diagnosesAndProceduresRepository.findById(id).get());
				nursingEntityIds.add(id);
			}
			diagnosisNandaEntity.unsetNursing();
			diagnosisNandaEntity.setNursingIds(nursingEntityIds);

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedDiagnosisNandaEntity = diagnosisNandaService.updateOldData(diagnosisNandaEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicalExaminationRecordEntity.unsetDiagnosisNandas(false);
			updatedDiagnosisNandaEntity.getMedicalExaminationRecord().unsetDiagnosisNandas(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedDiagnosisNandaEntity.getMedicalExaminationRecord());

			Assertions.assertEquals(nursingAnesthesiaDetailEntities.size(), updatedDiagnosisNandaEntity.getNursingAnesthesiaDetail().size());

			Assertions.assertEquals(nursingSurgicalDetailEntities.size(), updatedDiagnosisNandaEntity.getNursingSurgicalDetail().size());

			Assertions.assertEquals(nursingEntities.size(), updatedDiagnosisNandaEntity.getNursing().size());

		});
	}

	@Test
	public void whenCreateDiagnosisNandaEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisNandaEntity diagnosisNandaEntity;
			Optional<DiagnosisNandaEntity> fetchedDiagnosisNandaEntity;

			try {
				diagnosisNandaEntity = diagnosisNandaFactory.getObject(false, false);
				diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisNandaEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosisNandaEntity = diagnosisNandaService.create(diagnosisNandaEntity);

			fetchedDiagnosisNandaEntity = diagnosisNandaService.findById(diagnosisNandaEntity.getId());

			Assertions.assertTrue(fetchedDiagnosisNandaEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedDiagnosisNandaEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(diagnosisNandaEntity, fetchedDiagnosisNandaEntity.get());
		});
	}

	@Test
	public void whenUpdateDiagnosisNandaEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisNandaEntity diagnosisNandaEntity;
			DiagnosisNandaEntity updatedDiagnosisNandaEntity;
			Optional<DiagnosisNandaEntity> fetchedDiagnosisNandaEntity;

			try {
				diagnosisNandaEntity = diagnosisNandaFactory.getObject(false, false);
				diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisNandaEntity, true, true, false);
				updatedDiagnosisNandaEntity = diagnosisNandaFactory.getObject(false, false);
				diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(updatedDiagnosisNandaEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosisNandaEntity = diagnosisNandaService.create(diagnosisNandaEntity);

			updatedDiagnosisNandaEntity.setId(diagnosisNandaEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedDiagnosisNandaEntity.setCreated(diagnosisNandaEntity.getCreated());

			updatedDiagnosisNandaEntity = diagnosisNandaService.update(updatedDiagnosisNandaEntity);

			fetchedDiagnosisNandaEntity = diagnosisNandaService.findById(diagnosisNandaEntity.getId());

			Assertions.assertTrue(fetchedDiagnosisNandaEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateDiagnosisNandaEntity_ThenEntityIsCreated
			fetchedDiagnosisNandaEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedDiagnosisNandaEntity, fetchedDiagnosisNandaEntity.get());
		});
	}

	@Test
	public void whenDeleteDiagnosisNandaEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisNandaEntity diagnosisNandaEntity;
			Optional<DiagnosisNandaEntity> fetchedDiagnosisNandaEntity;

			try {
				diagnosisNandaEntity = diagnosisNandaFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				diagnosisNandaDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisNandaEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosisNandaEntity = diagnosisNandaService.create(diagnosisNandaEntity);

			diagnosisNandaService.deleteById(diagnosisNandaEntity.getId());
			fetchedDiagnosisNandaEntity = diagnosisNandaService.findById(diagnosisNandaEntity.getId());

			Assertions.assertTrue(fetchedDiagnosisNandaEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
