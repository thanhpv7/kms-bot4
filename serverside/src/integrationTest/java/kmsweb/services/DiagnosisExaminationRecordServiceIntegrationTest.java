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
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.repositories.DiagnosisExaminationRecordRepository;
import kmsweb.utils.DiagnosisExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.DiagnosisExaminationRecordDatabasePopulator;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.repositories.DiagnosesAndProceduresRepository;
import kmsweb.utils.DiagnosesAndProceduresFactory;
import kmsweb.utils.DatabasePopulators.DiagnosesAndProceduresDatabasePopulator;
import kmsweb.entities.DiagnosticStaffExaminationSummaryEntity;
import kmsweb.repositories.DiagnosticStaffExaminationSummaryRepository;
import kmsweb.utils.DiagnosticStaffExaminationSummaryFactory;
import kmsweb.utils.DatabasePopulators.DiagnosticStaffExaminationSummaryDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.repositories.MedicalExaminationRecordRepository;
import kmsweb.utils.MedicalExaminationRecordFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDatabasePopulator;
import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import kmsweb.repositories.MedicalExaminationRecordDischargeSummaryRepository;
import kmsweb.utils.MedicalExaminationRecordDischargeSummaryFactory;
import kmsweb.utils.DatabasePopulators.MedicalExaminationRecordDischargeSummaryDatabasePopulator;
import kmsweb.entities.SampleCollectionInformationEntity;
import kmsweb.repositories.SampleCollectionInformationRepository;
import kmsweb.utils.SampleCollectionInformationFactory;
import kmsweb.utils.DatabasePopulators.SampleCollectionInformationDatabasePopulator;
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
public class DiagnosisExaminationRecordServiceIntegrationTest {

	@Autowired
	private DiagnosisExaminationRecordRepository diagnosisExaminationRecordRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private DiagnosisExaminationRecordService diagnosisExaminationRecordService;

	private final DiagnosisExaminationRecordFactory diagnosisExaminationRecordFactory = new DiagnosisExaminationRecordFactory();

	@Autowired
	private DiagnosisExaminationRecordDatabasePopulator diagnosisExaminationRecordDatabasePopulator;

	@Autowired
	private DiagnosesAndProceduresRepository diagnosesAndProceduresRepository;

	@Autowired
	private DiagnosesAndProceduresDatabasePopulator diagnosesAndProceduresDatabasePopulator;

	private final DiagnosesAndProceduresFactory diagnosesAndProceduresFactory = new DiagnosesAndProceduresFactory();

	@Autowired
	private DiagnosticStaffExaminationSummaryRepository diagnosticStaffExaminationSummaryRepository;

	@Autowired
	private DiagnosticStaffExaminationSummaryDatabasePopulator diagnosticStaffExaminationSummaryDatabasePopulator;

	private final DiagnosticStaffExaminationSummaryFactory diagnosticStaffExaminationSummaryFactory = new DiagnosticStaffExaminationSummaryFactory();

	@Autowired
	private MedicalExaminationRecordRepository medicalExaminationRecordRepository;

	@Autowired
	private MedicalExaminationRecordDatabasePopulator medicalExaminationRecordDatabasePopulator;

	private final MedicalExaminationRecordFactory medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();

	@Autowired
	private MedicalExaminationRecordDischargeSummaryRepository medicalExaminationRecordDischargeSummaryRepository;

	@Autowired
	private MedicalExaminationRecordDischargeSummaryDatabasePopulator medicalExaminationRecordDischargeSummaryDatabasePopulator;

	private final MedicalExaminationRecordDischargeSummaryFactory medicalExaminationRecordDischargeSummaryFactory = new MedicalExaminationRecordDischargeSummaryFactory();

	@Autowired
	private SampleCollectionInformationRepository sampleCollectionInformationRepository;

	@Autowired
	private SampleCollectionInformationDatabasePopulator sampleCollectionInformationDatabasePopulator;

	private final SampleCollectionInformationFactory sampleCollectionInformationFactory = new SampleCollectionInformationFactory();


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	/**
	 * Handles the logic which is required before each test run.
	 * The service is required for each test case, so we can instantiate it here instead of within each test case
	 */
	@BeforeEach
	public void beforeEach() {
		diagnosisExaminationRecordService = new DiagnosisExaminationRecordService(
			diagnosesAndProceduresRepository,
			diagnosticStaffExaminationSummaryRepository,
			medicalExaminationRecordRepository,
			medicalExaminationRecordDischargeSummaryRepository,
			sampleCollectionInformationRepository,
			validator,
			auditRepository,
			diagnosisExaminationRecordRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewDiagnosisExaminationRecordEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(false, false);

		DiagnosisExaminationRecordEntity updatedEntity = diagnosisExaminationRecordService.updateOldData(diagnosisExaminationRecordEntity);
		Assertions.assertEquals(diagnosisExaminationRecordEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewDiagnosisExaminationRecordEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(false, false);

		diagnosisExaminationRecordEntity.setNewCase(null);
		Assertions.assertNull(diagnosisExaminationRecordEntity.getNewCase());


		DiagnosisExaminationRecordEntity updatedEntity = diagnosisExaminationRecordService.updateOldData(diagnosisExaminationRecordEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getNewCase());
		Assertions.assertFalse(updatedEntity.getNewCase());

	}

	@Test
	public void updateOldDataWithExistingDiagnosisExaminationRecordEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity;
			DiagnosisExaminationRecordEntity entityWithUpdatedValues;

			try {
				diagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(false, false);
				diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = diagnosisExaminationRecordFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosisExaminationRecordEntity = diagnosisExaminationRecordService.create(diagnosisExaminationRecordEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(diagnosisExaminationRecordEntity.getId());

			DiagnosisExaminationRecordEntity updatedEntity = diagnosisExaminationRecordService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithDiagnosisExaminationRecordEntityWithNonExistentId_ShouldThrowException() throws Exception {
		DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(false, false);
		diagnosisExaminationRecordEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			diagnosisExaminationRecordService.updateOldData(diagnosisExaminationRecordEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingDiagnosisExaminationRecordEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity;
			DiagnosisExaminationRecordEntity updatedDiagnosisExaminationRecordEntity;

			DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummaryEntity;

			SampleCollectionInformationEntity sampleCollectionInformationEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;

			DiagnosesAndProceduresEntity icd10Entity;

			DiagnosesAndProceduresEntity icd9CMEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				diagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(true, false);
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
			diagnosticStaffExaminationSummaryEntity = diagnosisExaminationRecordEntity.getDiagnosticStaffExaminationSummary();
			try {
				diagnosticStaffExaminationSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosticStaffExaminationSummaryEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			diagnosticStaffExaminationSummaryEntity = diagnosticStaffExaminationSummaryRepository.save(diagnosticStaffExaminationSummaryEntity);
			diagnosisExaminationRecordEntity.setDiagnosticStaffExaminationSummaryId(diagnosticStaffExaminationSummaryEntity.getId());

			sampleCollectionInformationEntity = diagnosisExaminationRecordEntity.getSampleCollectionInformation();
			try {
				sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(sampleCollectionInformationEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			sampleCollectionInformationEntity = sampleCollectionInformationRepository.save(sampleCollectionInformationEntity);
			diagnosisExaminationRecordEntity.setSampleCollectionInformationId(sampleCollectionInformationEntity.getId());

			medicalExaminationRecordEntity = diagnosisExaminationRecordEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			diagnosisExaminationRecordEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			medicalExaminationRecordDischargeSummaryEntity = diagnosisExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary();
			try {
				medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordDischargeSummaryEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryRepository.save(medicalExaminationRecordDischargeSummaryEntity);
			diagnosisExaminationRecordEntity.setMedicalExaminationRecordDischargeSummaryId(medicalExaminationRecordDischargeSummaryEntity.getId());

			icd10Entity = diagnosisExaminationRecordEntity.getIcd10();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(icd10Entity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			icd10Entity = diagnosesAndProceduresRepository.save(icd10Entity);
			diagnosisExaminationRecordEntity.setIcd10Id(icd10Entity.getId());

			icd9CMEntity = diagnosisExaminationRecordEntity.getIcd9CM();
			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(icd9CMEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			icd9CMEntity = diagnosesAndProceduresRepository.save(icd9CMEntity);
			diagnosisExaminationRecordEntity.setIcd9CMId(icd9CMEntity.getId());


			diagnosisExaminationRecordEntity = diagnosisExaminationRecordService.create(diagnosisExaminationRecordEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(diagnosisExaminationRecordEntity.getDiagnosticStaffExaminationSummary());
			diagnosisExaminationRecordEntity.setDiagnosticStaffExaminationSummaryId(null);
			diagnosisExaminationRecordEntity.unsetDiagnosticStaffExaminationSummary();

			Assertions.assertNotNull(diagnosisExaminationRecordEntity.getSampleCollectionInformation());
			diagnosisExaminationRecordEntity.setSampleCollectionInformationId(null);
			diagnosisExaminationRecordEntity.unsetSampleCollectionInformation();

			Assertions.assertNotNull(diagnosisExaminationRecordEntity.getMedicalExaminationRecord());
			diagnosisExaminationRecordEntity.setMedicalExaminationRecordId(null);
			diagnosisExaminationRecordEntity.unsetMedicalExaminationRecord();

			Assertions.assertNotNull(diagnosisExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary());
			diagnosisExaminationRecordEntity.setMedicalExaminationRecordDischargeSummaryId(null);
			diagnosisExaminationRecordEntity.unsetMedicalExaminationRecordDischargeSummary();

			Assertions.assertNotNull(diagnosisExaminationRecordEntity.getIcd10());
			diagnosisExaminationRecordEntity.setIcd10Id(null);
			diagnosisExaminationRecordEntity.unsetIcd10();

			Assertions.assertNotNull(diagnosisExaminationRecordEntity.getIcd9CM());
			diagnosisExaminationRecordEntity.setIcd9CMId(null);
			diagnosisExaminationRecordEntity.unsetIcd9CM();


			updatedDiagnosisExaminationRecordEntity = diagnosisExaminationRecordService.updateOldData(diagnosisExaminationRecordEntity);

			Assertions.assertNull(updatedDiagnosisExaminationRecordEntity.getDiagnosticStaffExaminationSummary());

			Assertions.assertNull(updatedDiagnosisExaminationRecordEntity.getSampleCollectionInformation());

			Assertions.assertNull(updatedDiagnosisExaminationRecordEntity.getMedicalExaminationRecord());

			Assertions.assertNull(updatedDiagnosisExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary());

			Assertions.assertNull(updatedDiagnosisExaminationRecordEntity.getIcd10());

			Assertions.assertNull(updatedDiagnosisExaminationRecordEntity.getIcd9CM());

		});
	}

	@Test
	public void updateOldDataWithDiagnosisExaminationRecordEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity;
			DiagnosisExaminationRecordEntity updatedDiagnosisExaminationRecordEntity;

			DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummaryEntity;

			SampleCollectionInformationEntity sampleCollectionInformationEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummaryEntity;

			DiagnosesAndProceduresEntity icd10Entity;

			DiagnosesAndProceduresEntity icd9CMEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				diagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(true, false);
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
				diagnosticStaffExaminationSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity.getDiagnosticStaffExaminationSummary(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Diagnostic Staff Examination Summary relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			diagnosticStaffExaminationSummaryEntity = diagnosticStaffExaminationSummaryRepository.findById(diagnosticStaffExaminationSummaryRepository.save(diagnosisExaminationRecordEntity.getDiagnosticStaffExaminationSummary()).getId()).get();
			diagnosisExaminationRecordEntity.unsetDiagnosticStaffExaminationSummary();
			diagnosisExaminationRecordEntity.setDiagnosticStaffExaminationSummaryId(diagnosticStaffExaminationSummaryEntity.getId());

			try {
				sampleCollectionInformationDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity.getSampleCollectionInformation(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Sample Collection Information relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			sampleCollectionInformationEntity = sampleCollectionInformationRepository.findById(sampleCollectionInformationRepository.save(diagnosisExaminationRecordEntity.getSampleCollectionInformation()).getId()).get();
			diagnosisExaminationRecordEntity.unsetSampleCollectionInformation();
			diagnosisExaminationRecordEntity.setSampleCollectionInformationId(sampleCollectionInformationEntity.getId());

			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(diagnosisExaminationRecordEntity.getMedicalExaminationRecord()).getId()).get();
			diagnosisExaminationRecordEntity.unsetMedicalExaminationRecord();
			diagnosisExaminationRecordEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			try {
				medicalExaminationRecordDischargeSummaryDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record Discharge Summary relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordDischargeSummaryEntity = medicalExaminationRecordDischargeSummaryRepository.findById(medicalExaminationRecordDischargeSummaryRepository.save(diagnosisExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary()).getId()).get();
			diagnosisExaminationRecordEntity.unsetMedicalExaminationRecordDischargeSummary();
			diagnosisExaminationRecordEntity.setMedicalExaminationRecordDischargeSummaryId(medicalExaminationRecordDischargeSummaryEntity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity.getIcd10(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the ICD 10 relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			icd10Entity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(diagnosisExaminationRecordEntity.getIcd10()).getId()).get();
			diagnosisExaminationRecordEntity.unsetIcd10();
			diagnosisExaminationRecordEntity.setIcd10Id(icd10Entity.getId());

			try {
				diagnosesAndProceduresDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity.getIcd9CM(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the ICD 9 CM relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			icd9CMEntity = diagnosesAndProceduresRepository.findById(diagnosesAndProceduresRepository.save(diagnosisExaminationRecordEntity.getIcd9CM()).getId()).get();
			diagnosisExaminationRecordEntity.unsetIcd9CM();
			diagnosisExaminationRecordEntity.setIcd9CMId(icd9CMEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedDiagnosisExaminationRecordEntity = diagnosisExaminationRecordService.updateOldData(diagnosisExaminationRecordEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			diagnosticStaffExaminationSummaryEntity.unsetDiagnosisExaminationRecord(false);
			updatedDiagnosisExaminationRecordEntity.getDiagnosticStaffExaminationSummary().unsetDiagnosisExaminationRecord(false);
			Assertions.assertEquals(diagnosticStaffExaminationSummaryEntity, updatedDiagnosisExaminationRecordEntity.getDiagnosticStaffExaminationSummary());

			sampleCollectionInformationEntity.unsetDiagnosisExaminationRecord(false);
			updatedDiagnosisExaminationRecordEntity.getSampleCollectionInformation().unsetDiagnosisExaminationRecord(false);
			Assertions.assertEquals(sampleCollectionInformationEntity, updatedDiagnosisExaminationRecordEntity.getSampleCollectionInformation());

			medicalExaminationRecordEntity.unsetDiagnosisExaminationRecords(false);
			updatedDiagnosisExaminationRecordEntity.getMedicalExaminationRecord().unsetDiagnosisExaminationRecords(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedDiagnosisExaminationRecordEntity.getMedicalExaminationRecord());

			medicalExaminationRecordDischargeSummaryEntity.unsetDiagnosisExaminationRecords(false);
			updatedDiagnosisExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary().unsetDiagnosisExaminationRecords(false);
			Assertions.assertEquals(medicalExaminationRecordDischargeSummaryEntity, updatedDiagnosisExaminationRecordEntity.getMedicalExaminationRecordDischargeSummary());

			icd10Entity.unsetIcd10(false);
			updatedDiagnosisExaminationRecordEntity.getIcd10().unsetIcd10(false);
			Assertions.assertEquals(icd10Entity, updatedDiagnosisExaminationRecordEntity.getIcd10());

			icd9CMEntity.unsetIcd9CM(false);
			updatedDiagnosisExaminationRecordEntity.getIcd9CM().unsetIcd9CM(false);
			Assertions.assertEquals(icd9CMEntity, updatedDiagnosisExaminationRecordEntity.getIcd9CM());

		});
	}

	@Test
	public void whenCreateDiagnosisExaminationRecordEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity;
			Optional<DiagnosisExaminationRecordEntity> fetchedDiagnosisExaminationRecordEntity;

			try {
				diagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(false, false);
				diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosisExaminationRecordEntity = diagnosisExaminationRecordService.create(diagnosisExaminationRecordEntity);

			fetchedDiagnosisExaminationRecordEntity = diagnosisExaminationRecordService.findById(diagnosisExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedDiagnosisExaminationRecordEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedDiagnosisExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(diagnosisExaminationRecordEntity, fetchedDiagnosisExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenUpdateDiagnosisExaminationRecordEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity;
			DiagnosisExaminationRecordEntity updatedDiagnosisExaminationRecordEntity;
			Optional<DiagnosisExaminationRecordEntity> fetchedDiagnosisExaminationRecordEntity;

			try {
				diagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(false, false);
				diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity, true, true, false);
				updatedDiagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(false, false);
				diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(updatedDiagnosisExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosisExaminationRecordEntity = diagnosisExaminationRecordService.create(diagnosisExaminationRecordEntity);

			updatedDiagnosisExaminationRecordEntity.setId(diagnosisExaminationRecordEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedDiagnosisExaminationRecordEntity.setCreated(diagnosisExaminationRecordEntity.getCreated());

			updatedDiagnosisExaminationRecordEntity = diagnosisExaminationRecordService.update(updatedDiagnosisExaminationRecordEntity);

			fetchedDiagnosisExaminationRecordEntity = diagnosisExaminationRecordService.findById(diagnosisExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedDiagnosisExaminationRecordEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateDiagnosisExaminationRecordEntity_ThenEntityIsCreated
			fetchedDiagnosisExaminationRecordEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedDiagnosisExaminationRecordEntity, fetchedDiagnosisExaminationRecordEntity.get());
		});
	}

	@Test
	public void whenDeleteDiagnosisExaminationRecordEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			DiagnosisExaminationRecordEntity diagnosisExaminationRecordEntity;
			Optional<DiagnosisExaminationRecordEntity> fetchedDiagnosisExaminationRecordEntity;

			try {
				diagnosisExaminationRecordEntity = diagnosisExaminationRecordFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				diagnosisExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(diagnosisExaminationRecordEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			diagnosisExaminationRecordEntity = diagnosisExaminationRecordService.create(diagnosisExaminationRecordEntity);

			diagnosisExaminationRecordService.deleteById(diagnosisExaminationRecordEntity.getId());
			fetchedDiagnosisExaminationRecordEntity = diagnosisExaminationRecordService.findById(diagnosisExaminationRecordEntity.getId());

			Assertions.assertTrue(fetchedDiagnosisExaminationRecordEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
