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
import kmsweb.entities.MedicalRecordInitialChecklistEntity;
import kmsweb.repositories.MedicalRecordInitialChecklistRepository;
import kmsweb.utils.MedicalRecordInitialChecklistFactory;
import kmsweb.utils.DatabasePopulators.MedicalRecordInitialChecklistDatabasePopulator;
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
public class MedicalRecordInitialChecklistServiceIntegrationTest {

	@Autowired
	private MedicalRecordInitialChecklistRepository medicalRecordInitialChecklistRepository;

	@Autowired
	private AuditingRepository auditRepository;

	@Autowired
	private Validator validator;

	// Not autowired as we instantiate this in beforeEach
	private MedicalRecordInitialChecklistService medicalRecordInitialChecklistService;

	private final MedicalRecordInitialChecklistFactory medicalRecordInitialChecklistFactory = new MedicalRecordInitialChecklistFactory();

	@Autowired
	private MedicalRecordInitialChecklistDatabasePopulator medicalRecordInitialChecklistDatabasePopulator;

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
		medicalRecordInitialChecklistService = new MedicalRecordInitialChecklistService(
			medicalExaminationRecordRepository,
			validator,
			auditRepository,
			medicalRecordInitialChecklistRepository
		);

		// % protected region % [Add any additional logic to beforeEach here] off begin
		// % protected region % [Add any additional logic to beforeEach here] end
	}

	@Test
	public void updateOldDataWithNewMedicalRecordInitialChecklistEntityWithoutReferences_ShouldNotCauseChangesToEntity() throws Exception {
		MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(false, false);

		MedicalRecordInitialChecklistEntity updatedEntity = medicalRecordInitialChecklistService.updateOldData(medicalRecordInitialChecklistEntity);
		Assertions.assertEquals(medicalRecordInitialChecklistEntity, updatedEntity);
	}

	@Test
	public void updateOldDataWithNewMedicalRecordInitialChecklistEntityAndNullBooleanAttribute_ShouldUpdateNullBooleanToFalse() throws Exception {
		MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(false, false);

		medicalRecordInitialChecklistEntity.setOutVitalSign(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOutVitalSign());

		medicalRecordInitialChecklistEntity.setOutAnamnesis(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOutAnamnesis());

		medicalRecordInitialChecklistEntity.setOutPhysicalExamination(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOutPhysicalExamination());

		medicalRecordInitialChecklistEntity.setOutDiagnosis(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOutDiagnosis());

		medicalRecordInitialChecklistEntity.setOutDismissalType(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOutDismissalType());

		medicalRecordInitialChecklistEntity.setOutDismissalDateAndTime(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOutDismissalDateAndTime());

		medicalRecordInitialChecklistEntity.setInpVitalSign(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpVitalSign());

		medicalRecordInitialChecklistEntity.setInpDailyCareDoctorNotes(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDailyCareDoctorNotes());

		medicalRecordInitialChecklistEntity.setInpDailyCareDoctorNotesNA(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDailyCareDoctorNotesNA());

		medicalRecordInitialChecklistEntity.setInpDailyCareNursingNotes(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDailyCareNursingNotes());

		medicalRecordInitialChecklistEntity.setInpDailyCareNursingNotesNA(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDailyCareNursingNotesNA());

		medicalRecordInitialChecklistEntity.setInpDailyCareProgressNotes(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDailyCareProgressNotes());

		medicalRecordInitialChecklistEntity.setInpDailyCareProgressNotesNA(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDailyCareProgressNotesNA());

		medicalRecordInitialChecklistEntity.setInpDismissalDiagnosis(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDismissalDiagnosis());

		medicalRecordInitialChecklistEntity.setInpDismissalType(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDismissalType());

		medicalRecordInitialChecklistEntity.setInpDismissalDateAndTime(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDismissalDateAndTime());

		medicalRecordInitialChecklistEntity.setInpDismissalCondition(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getInpDismissalCondition());

		medicalRecordInitialChecklistEntity.setDrAdmissionDiagnosis(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrAdmissionDiagnosis());

		medicalRecordInitialChecklistEntity.setDrObservationDoctorNotes(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrObservationDoctorNotes());

		medicalRecordInitialChecklistEntity.setDrObservationDoctorNotesNA(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrObservationDoctorNotesNA());

		medicalRecordInitialChecklistEntity.setDrObservationNursingNotes(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrObservationNursingNotes());

		medicalRecordInitialChecklistEntity.setDrObservationNursingNotesNA(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrObservationNursingNotesNA());

		medicalRecordInitialChecklistEntity.setDrObservationProgressNotes(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrObservationProgressNotes());

		medicalRecordInitialChecklistEntity.setDrObservationProgressNotesNA(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrObservationProgressNotesNA());

		medicalRecordInitialChecklistEntity.setDrDismissalDiagnosis(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrDismissalDiagnosis());

		medicalRecordInitialChecklistEntity.setDrDismissalType(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrDismissalType());

		medicalRecordInitialChecklistEntity.setDrDismissalDateAndTime(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDrDismissalDateAndTime());

		medicalRecordInitialChecklistEntity.setOtPreOperativeDiagnosis(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtPreOperativeDiagnosis());

		medicalRecordInitialChecklistEntity.setOtPreOperativeNotesSurgery(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtPreOperativeNotesSurgery());

		medicalRecordInitialChecklistEntity.setOtPreOperativeNotesAnaesthesiology(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtPreOperativeNotesAnaesthesiology());

		medicalRecordInitialChecklistEntity.setOtIntraOperativeNotesSurgery(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtIntraOperativeNotesSurgery());

		medicalRecordInitialChecklistEntity.setOtIntraOperativeNotesAnaesthesiology(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtIntraOperativeNotesAnaesthesiology());

		medicalRecordInitialChecklistEntity.setOtPostOperativeNotesSurgery(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtPostOperativeNotesSurgery());

		medicalRecordInitialChecklistEntity.setOtPostOperativeNotesAnaesthesiology(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtPostOperativeNotesAnaesthesiology());

		medicalRecordInitialChecklistEntity.setOtPostOperativeDiagnosis(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtPostOperativeDiagnosis());

		medicalRecordInitialChecklistEntity.setOtDismissalType(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtDismissalType());

		medicalRecordInitialChecklistEntity.setOtDismissalDateAndTime(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getOtDismissalDateAndTime());

		medicalRecordInitialChecklistEntity.setDsResponsibleStaff(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDsResponsibleStaff());

		medicalRecordInitialChecklistEntity.setDsInterpretation(null);
		Assertions.assertNull(medicalRecordInitialChecklistEntity.getDsInterpretation());


		MedicalRecordInitialChecklistEntity updatedEntity = medicalRecordInitialChecklistService.updateOldData(medicalRecordInitialChecklistEntity);

		// Asserting not null first removes the potential for a null pointer exception if the update hasn't worked.
		Assertions.assertNotNull(updatedEntity.getOutVitalSign());
		Assertions.assertFalse(updatedEntity.getOutVitalSign());

		Assertions.assertNotNull(updatedEntity.getOutAnamnesis());
		Assertions.assertFalse(updatedEntity.getOutAnamnesis());

		Assertions.assertNotNull(updatedEntity.getOutPhysicalExamination());
		Assertions.assertFalse(updatedEntity.getOutPhysicalExamination());

		Assertions.assertNotNull(updatedEntity.getOutDiagnosis());
		Assertions.assertFalse(updatedEntity.getOutDiagnosis());

		Assertions.assertNotNull(updatedEntity.getOutDismissalType());
		Assertions.assertFalse(updatedEntity.getOutDismissalType());

		Assertions.assertNotNull(updatedEntity.getOutDismissalDateAndTime());
		Assertions.assertFalse(updatedEntity.getOutDismissalDateAndTime());

		Assertions.assertNotNull(updatedEntity.getInpVitalSign());
		Assertions.assertFalse(updatedEntity.getInpVitalSign());

		Assertions.assertNotNull(updatedEntity.getInpDailyCareDoctorNotes());
		Assertions.assertFalse(updatedEntity.getInpDailyCareDoctorNotes());

		Assertions.assertNotNull(updatedEntity.getInpDailyCareDoctorNotesNA());
		Assertions.assertFalse(updatedEntity.getInpDailyCareDoctorNotesNA());

		Assertions.assertNotNull(updatedEntity.getInpDailyCareNursingNotes());
		Assertions.assertFalse(updatedEntity.getInpDailyCareNursingNotes());

		Assertions.assertNotNull(updatedEntity.getInpDailyCareNursingNotesNA());
		Assertions.assertFalse(updatedEntity.getInpDailyCareNursingNotesNA());

		Assertions.assertNotNull(updatedEntity.getInpDailyCareProgressNotes());
		Assertions.assertFalse(updatedEntity.getInpDailyCareProgressNotes());

		Assertions.assertNotNull(updatedEntity.getInpDailyCareProgressNotesNA());
		Assertions.assertFalse(updatedEntity.getInpDailyCareProgressNotesNA());

		Assertions.assertNotNull(updatedEntity.getInpDismissalDiagnosis());
		Assertions.assertFalse(updatedEntity.getInpDismissalDiagnosis());

		Assertions.assertNotNull(updatedEntity.getInpDismissalType());
		Assertions.assertFalse(updatedEntity.getInpDismissalType());

		Assertions.assertNotNull(updatedEntity.getInpDismissalDateAndTime());
		Assertions.assertFalse(updatedEntity.getInpDismissalDateAndTime());

		Assertions.assertNotNull(updatedEntity.getInpDismissalCondition());
		Assertions.assertFalse(updatedEntity.getInpDismissalCondition());

		Assertions.assertNotNull(updatedEntity.getDrAdmissionDiagnosis());
		Assertions.assertFalse(updatedEntity.getDrAdmissionDiagnosis());

		Assertions.assertNotNull(updatedEntity.getDrObservationDoctorNotes());
		Assertions.assertFalse(updatedEntity.getDrObservationDoctorNotes());

		Assertions.assertNotNull(updatedEntity.getDrObservationDoctorNotesNA());
		Assertions.assertFalse(updatedEntity.getDrObservationDoctorNotesNA());

		Assertions.assertNotNull(updatedEntity.getDrObservationNursingNotes());
		Assertions.assertFalse(updatedEntity.getDrObservationNursingNotes());

		Assertions.assertNotNull(updatedEntity.getDrObservationNursingNotesNA());
		Assertions.assertFalse(updatedEntity.getDrObservationNursingNotesNA());

		Assertions.assertNotNull(updatedEntity.getDrObservationProgressNotes());
		Assertions.assertFalse(updatedEntity.getDrObservationProgressNotes());

		Assertions.assertNotNull(updatedEntity.getDrObservationProgressNotesNA());
		Assertions.assertFalse(updatedEntity.getDrObservationProgressNotesNA());

		Assertions.assertNotNull(updatedEntity.getDrDismissalDiagnosis());
		Assertions.assertFalse(updatedEntity.getDrDismissalDiagnosis());

		Assertions.assertNotNull(updatedEntity.getDrDismissalType());
		Assertions.assertFalse(updatedEntity.getDrDismissalType());

		Assertions.assertNotNull(updatedEntity.getDrDismissalDateAndTime());
		Assertions.assertFalse(updatedEntity.getDrDismissalDateAndTime());

		Assertions.assertNotNull(updatedEntity.getOtPreOperativeDiagnosis());
		Assertions.assertFalse(updatedEntity.getOtPreOperativeDiagnosis());

		Assertions.assertNotNull(updatedEntity.getOtPreOperativeNotesSurgery());
		Assertions.assertFalse(updatedEntity.getOtPreOperativeNotesSurgery());

		Assertions.assertNotNull(updatedEntity.getOtPreOperativeNotesAnaesthesiology());
		Assertions.assertFalse(updatedEntity.getOtPreOperativeNotesAnaesthesiology());

		Assertions.assertNotNull(updatedEntity.getOtIntraOperativeNotesSurgery());
		Assertions.assertFalse(updatedEntity.getOtIntraOperativeNotesSurgery());

		Assertions.assertNotNull(updatedEntity.getOtIntraOperativeNotesAnaesthesiology());
		Assertions.assertFalse(updatedEntity.getOtIntraOperativeNotesAnaesthesiology());

		Assertions.assertNotNull(updatedEntity.getOtPostOperativeNotesSurgery());
		Assertions.assertFalse(updatedEntity.getOtPostOperativeNotesSurgery());

		Assertions.assertNotNull(updatedEntity.getOtPostOperativeNotesAnaesthesiology());
		Assertions.assertFalse(updatedEntity.getOtPostOperativeNotesAnaesthesiology());

		Assertions.assertNotNull(updatedEntity.getOtPostOperativeDiagnosis());
		Assertions.assertFalse(updatedEntity.getOtPostOperativeDiagnosis());

		Assertions.assertNotNull(updatedEntity.getOtDismissalType());
		Assertions.assertFalse(updatedEntity.getOtDismissalType());

		Assertions.assertNotNull(updatedEntity.getOtDismissalDateAndTime());
		Assertions.assertFalse(updatedEntity.getOtDismissalDateAndTime());

		Assertions.assertNotNull(updatedEntity.getDsResponsibleStaff());
		Assertions.assertFalse(updatedEntity.getDsResponsibleStaff());

		Assertions.assertNotNull(updatedEntity.getDsInterpretation());
		Assertions.assertFalse(updatedEntity.getDsInterpretation());

	}

	@Test
	public void updateOldDataWithExistingMedicalRecordInitialChecklistEntity_ShouldUpdateEntityToNewState() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity;
			MedicalRecordInitialChecklistEntity entityWithUpdatedValues;

			try {
				medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(false, false);
				medicalRecordInitialChecklistDatabasePopulator.populateRelatedEntitiesInDatabase(medicalRecordInitialChecklistEntity, true, true, false);
				// we don't need to worry about populating the related entities for the entity with updated values.  This is because
				// this entity is not being saved, so validation for required relations will not be run and does not impact the test run
				entityWithUpdatedValues = medicalRecordInitialChecklistFactory.getObject(false, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.create(medicalRecordInitialChecklistEntity);

			// Setting the id of the entity with updated attributes to equal the original entity we saved ensures
			// that we will enter the update path of updateOldData
			entityWithUpdatedValues.setId(medicalRecordInitialChecklistEntity.getId());

			MedicalRecordInitialChecklistEntity updatedEntity = medicalRecordInitialChecklistService.updateOldData(entityWithUpdatedValues);
			Assertions.assertEquals(entityWithUpdatedValues, updatedEntity);
		});
	}

	@Test
	public void updateOldDataWithMedicalRecordInitialChecklistEntityWithNonExistentId_ShouldThrowException() throws Exception {
		MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(false, false);
		medicalRecordInitialChecklistEntity.setId(UUID.randomUUID());

		// As we haven't created an entity with the ID we have specified for this entity, we expect
		// an exception to be thrown, as it will enter the `if (entity.getId() != null) {}` path and
		// hopefully throw an exception
		Assertions.assertThrows(ResponseStatusException.class, () -> {
			medicalRecordInitialChecklistService.updateOldData(medicalRecordInitialChecklistEntity);
		});
	}

	@Test
	public void updateOldDataWhenRemovingMedicalRecordInitialChecklistEntityReferences_ShouldRemoveReferenceEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity;
			MedicalRecordInitialChecklistEntity updatedMedicalRecordInitialChecklistEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;

			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(true, false);
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
			medicalExaminationRecordEntity = medicalRecordInitialChecklistEntity.getMedicalExaminationRecord();
			try {
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalExaminationRecordEntity, true, true, true);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				return;
			}
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.save(medicalExaminationRecordEntity);
			medicalRecordInitialChecklistEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());


			medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.create(medicalRecordInitialChecklistEntity);

			// Before we move on, checking that the relations exist ensures that we are actually
			// testing removal of reference entities
			Assertions.assertNotNull(medicalRecordInitialChecklistEntity.getMedicalExaminationRecord());
			medicalRecordInitialChecklistEntity.setMedicalExaminationRecordId(null);
			medicalRecordInitialChecklistEntity.unsetMedicalExaminationRecord();


			updatedMedicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.updateOldData(medicalRecordInitialChecklistEntity);

			Assertions.assertNull(updatedMedicalRecordInitialChecklistEntity.getMedicalExaminationRecord());

		});
	}

	@Test
	public void updateOldDataWithMedicalRecordInitialChecklistEntityReferenceIds_ShouldAddReferencesToEntity() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity;
			MedicalRecordInitialChecklistEntity updatedMedicalRecordInitialChecklistEntity;

			MedicalExaminationRecordEntity medicalExaminationRecordEntity;


			try {
				/*
					We create the references as part of creating the object by setting
					includeReferences to true.  This cuts down the additional code from creating
					reference entities, which could be extensive if there are multiple references
				 */
				medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(true, false);
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
				medicalExaminationRecordDatabasePopulator.populateRelatedEntitiesInDatabase(medicalRecordInitialChecklistEntity.getMedicalExaminationRecord(), true, true, true);
			} catch (Exception e) {
				Assertions.fail("Failed to populate the Medical Examination Record relation for this test: " + e.getCause());
				return;
			}
			// Don't need to worry about the possibility of the get() method here throwing an exception, because assuming the repository save method
			// executes successfully, the get method will always produce an Optional object which contains the entity
			medicalExaminationRecordEntity = medicalExaminationRecordRepository.findById(medicalExaminationRecordRepository.save(medicalRecordInitialChecklistEntity.getMedicalExaminationRecord()).getId()).get();
			medicalRecordInitialChecklistEntity.unsetMedicalExaminationRecord();
			medicalRecordInitialChecklistEntity.setMedicalExaminationRecordId(medicalExaminationRecordEntity.getId());

			// running updateOldData at this point will populate all of the related entities into the parent entity.  As we have already
			// set all of the related entity ids, this should fetch all the entities which we created in the previous part of this test
			updatedMedicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.updateOldData(medicalRecordInitialChecklistEntity);

			/*
				The process of saving the entities in 1:1 relations or the ones side of 1:M relations can lead to inconsistensies in the base entity
				which is saved as part of the related entity.  This is because the reverse relation may be created with a reference to a different
				entity if the reverse relation is required, as the base entity has not been created so can't be used.  We are only interested in the
				related entity itself at the moment, so we need to unset the reverse relation to see if the entities are the same otherwise.
			*/
			medicalExaminationRecordEntity.unsetMedicalRecordInitialChecklist(false);
			updatedMedicalRecordInitialChecklistEntity.getMedicalExaminationRecord().unsetMedicalRecordInitialChecklist(false);
			Assertions.assertEquals(medicalExaminationRecordEntity, updatedMedicalRecordInitialChecklistEntity.getMedicalExaminationRecord());

		});
	}

	@Test
	public void whenCreateMedicalRecordInitialChecklistEntity_ThenEntityIsCreated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity;
			Optional<MedicalRecordInitialChecklistEntity> fetchedMedicalRecordInitialChecklistEntity;

			try {
				medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(false, false);
				medicalRecordInitialChecklistDatabasePopulator.populateRelatedEntitiesInDatabase(medicalRecordInitialChecklistEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.create(medicalRecordInitialChecklistEntity);

			fetchedMedicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.findById(medicalRecordInitialChecklistEntity.getId());

			Assertions.assertTrue(fetchedMedicalRecordInitialChecklistEntity.isPresent());
			// We do this because the expected entity has the ids set, but an entity fetched from the database will have the related entity set,
			// but not the id.  As we expect the entities to match, we need to populate the transient id fields in the entity
			fetchedMedicalRecordInitialChecklistEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(medicalRecordInitialChecklistEntity, fetchedMedicalRecordInitialChecklistEntity.get());
		});
	}

	@Test
	public void whenUpdateMedicalRecordInitialChecklistEntity_ThenEntityIsUpdated() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity;
			MedicalRecordInitialChecklistEntity updatedMedicalRecordInitialChecklistEntity;
			Optional<MedicalRecordInitialChecklistEntity> fetchedMedicalRecordInitialChecklistEntity;

			try {
				medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(false, false);
				medicalRecordInitialChecklistDatabasePopulator.populateRelatedEntitiesInDatabase(medicalRecordInitialChecklistEntity, true, true, false);
				updatedMedicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(false, false);
				medicalRecordInitialChecklistDatabasePopulator.populateRelatedEntitiesInDatabase(updatedMedicalRecordInitialChecklistEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.create(medicalRecordInitialChecklistEntity);

			updatedMedicalRecordInitialChecklistEntity.setId(medicalRecordInitialChecklistEntity.getId());
			// The milliseconds of the created Datetime in this test can get slightly out of sync,
			// as it is rounded when it is saved in the database.  This causes instability in this
			// test if we don't set the created date of the updated entity before updating it
			updatedMedicalRecordInitialChecklistEntity.setCreated(medicalRecordInitialChecklistEntity.getCreated());

			updatedMedicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.update(updatedMedicalRecordInitialChecklistEntity);

			fetchedMedicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.findById(medicalRecordInitialChecklistEntity.getId());

			Assertions.assertTrue(fetchedMedicalRecordInitialChecklistEntity.isPresent());
			// reasoning for running this method is the same as the reasoning in whenCreateMedicalRecordInitialChecklistEntity_ThenEntityIsCreated
			fetchedMedicalRecordInitialChecklistEntity.get().addRelationEntitiesToIdSet();
			Assertions.assertEquals(updatedMedicalRecordInitialChecklistEntity, fetchedMedicalRecordInitialChecklistEntity.get());
		});
	}

	@Test
	public void whenDeleteMedicalRecordInitialChecklistEntity_ThenEntityIsDeleted() {
		AnonymousHelper.runAnonymously(() -> {
			MedicalRecordInitialChecklistEntity medicalRecordInitialChecklistEntity;
			Optional<MedicalRecordInitialChecklistEntity> fetchedMedicalRecordInitialChecklistEntity;

			try {
				medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistFactory.getObject(false, false);
				// With deletion test, we don't need to do anything else regarding relations once we have completed this step
				// This is because we don't need to fetch an entity and check equality, as we are checking for deletion.  Therefore,
				// the purpose of running this in this test is so that the serverside validation does not stop the entity creation
				medicalRecordInitialChecklistDatabasePopulator.populateRelatedEntitiesInDatabase(medicalRecordInitialChecklistEntity, true, true, false);
			} catch (Exception e) {
				Assertions.fail("Factory failed to create the required entities for this test: " + e.getCause());
				// No point continuing on with the test if creating the entities has failed, as the
				// following code will either fail or not give us any meaningful information about
				// the state of the application
				return;
			}

			medicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.create(medicalRecordInitialChecklistEntity);

			medicalRecordInitialChecklistService.deleteById(medicalRecordInitialChecklistEntity.getId());
			fetchedMedicalRecordInitialChecklistEntity = medicalRecordInitialChecklistService.findById(medicalRecordInitialChecklistEntity.getId());

			Assertions.assertTrue(fetchedMedicalRecordInitialChecklistEntity.isEmpty());
		});
	}

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
}
