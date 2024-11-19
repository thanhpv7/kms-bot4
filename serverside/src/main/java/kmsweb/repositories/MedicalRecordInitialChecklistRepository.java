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
package kmsweb.repositories;

import kmsweb.entities.MedicalRecordInitialChecklistEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface MedicalRecordInitialChecklistRepository extends AbstractRepository<MedicalRecordInitialChecklistEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Out Vital Sign.
	 *
	 * @param outVitalSign the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Vital Sign
	 */
	List<MedicalRecordInitialChecklistEntity> findByOutVitalSign(@NotNull Boolean outVitalSign);
	/**
	 * Return an entity or a list of entities that have the given attribute Out Anamnesis.
	 *
	 * @param outAnamnesis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Anamnesis
	 */
	List<MedicalRecordInitialChecklistEntity> findByOutAnamnesis(@NotNull Boolean outAnamnesis);
	/**
	 * Return an entity or a list of entities that have the given attribute Out Physical Examination.
	 *
	 * @param outPhysicalExamination the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Physical Examination
	 */
	List<MedicalRecordInitialChecklistEntity> findByOutPhysicalExamination(@NotNull Boolean outPhysicalExamination);
	/**
	 * Return an entity or a list of entities that have the given attribute Out Diagnosis.
	 *
	 * @param outDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Diagnosis
	 */
	List<MedicalRecordInitialChecklistEntity> findByOutDiagnosis(@NotNull Boolean outDiagnosis);
	/**
	 * Return an entity or a list of entities that have the given attribute Out Dismissal Type.
	 *
	 * @param outDismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Out Dismissal Type
	 */
	List<MedicalRecordInitialChecklistEntity> findByOutDismissalType(@NotNull Boolean outDismissalType);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Vital Sign.
	 *
	 * @param inpVitalSign the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Vital Sign
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpVitalSign(@NotNull Boolean inpVitalSign);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Doctor Notes.
	 *
	 * @param inpDailyCareDoctorNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Doctor Notes
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpDailyCareDoctorNotes(@NotNull Boolean inpDailyCareDoctorNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Doctor Notes NA.
	 *
	 * @param inpDailyCareDoctorNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Doctor Notes NA
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpDailyCareDoctorNotesNA(@NotNull Boolean inpDailyCareDoctorNotesNA);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Nursing Notes.
	 *
	 * @param inpDailyCareNursingNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Nursing Notes
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpDailyCareNursingNotes(@NotNull Boolean inpDailyCareNursingNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Nursing Notes NA.
	 *
	 * @param inpDailyCareNursingNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Nursing Notes NA
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpDailyCareNursingNotesNA(@NotNull Boolean inpDailyCareNursingNotesNA);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Progress Notes.
	 *
	 * @param inpDailyCareProgressNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Progress Notes
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpDailyCareProgressNotes(@NotNull Boolean inpDailyCareProgressNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Daily Care Progress Notes NA.
	 *
	 * @param inpDailyCareProgressNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Daily Care Progress Notes NA
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpDailyCareProgressNotesNA(@NotNull Boolean inpDailyCareProgressNotesNA);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Dismissal Diagnosis.
	 *
	 * @param inpDismissalDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Dismissal Diagnosis
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpDismissalDiagnosis(@NotNull Boolean inpDismissalDiagnosis);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Dismissal Type.
	 *
	 * @param inpDismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Dismissal Type
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpDismissalType(@NotNull Boolean inpDismissalType);
	/**
	 * Return an entity or a list of entities that have the given attribute Inp Dismissal Condition.
	 *
	 * @param inpDismissalCondition the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Inp Dismissal Condition
	 */
	List<MedicalRecordInitialChecklistEntity> findByInpDismissalCondition(@NotNull Boolean inpDismissalCondition);
	/**
	 * Return an entity or a list of entities that have the given attribute DR Admission Diagnosis.
	 *
	 * @param drAdmissionDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Admission Diagnosis
	 */
	List<MedicalRecordInitialChecklistEntity> findByDrAdmissionDiagnosis(@NotNull Boolean drAdmissionDiagnosis);
	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Doctor Notes.
	 *
	 * @param drObservationDoctorNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Doctor Notes
	 */
	List<MedicalRecordInitialChecklistEntity> findByDrObservationDoctorNotes(@NotNull Boolean drObservationDoctorNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Doctor Notes NA.
	 *
	 * @param drObservationDoctorNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Doctor Notes NA
	 */
	List<MedicalRecordInitialChecklistEntity> findByDrObservationDoctorNotesNA(@NotNull Boolean drObservationDoctorNotesNA);
	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Nursing Notes.
	 *
	 * @param drObservationNursingNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Nursing Notes
	 */
	List<MedicalRecordInitialChecklistEntity> findByDrObservationNursingNotes(@NotNull Boolean drObservationNursingNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Nursing Notes NA.
	 *
	 * @param drObservationNursingNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Nursing Notes NA
	 */
	List<MedicalRecordInitialChecklistEntity> findByDrObservationNursingNotesNA(@NotNull Boolean drObservationNursingNotesNA);
	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Progress Notes.
	 *
	 * @param drObservationProgressNotes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Progress Notes
	 */
	List<MedicalRecordInitialChecklistEntity> findByDrObservationProgressNotes(@NotNull Boolean drObservationProgressNotes);
	/**
	 * Return an entity or a list of entities that have the given attribute DR Observation Progress Notes NA.
	 *
	 * @param drObservationProgressNotesNA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Observation Progress Notes NA
	 */
	List<MedicalRecordInitialChecklistEntity> findByDrObservationProgressNotesNA(@NotNull Boolean drObservationProgressNotesNA);
	/**
	 * Return an entity or a list of entities that have the given attribute DR Dismissal Diagnosis.
	 *
	 * @param drDismissalDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Dismissal Diagnosis
	 */
	List<MedicalRecordInitialChecklistEntity> findByDrDismissalDiagnosis(@NotNull Boolean drDismissalDiagnosis);
	/**
	 * Return an entity or a list of entities that have the given attribute DR Dismissal Type.
	 *
	 * @param drDismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DR Dismissal Type
	 */
	List<MedicalRecordInitialChecklistEntity> findByDrDismissalType(@NotNull Boolean drDismissalType);
	/**
	 * Return an entity or a list of entities that have the given attribute OT Pre Operative Diagnosis.
	 *
	 * @param otPreOperativeDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Pre Operative Diagnosis
	 */
	List<MedicalRecordInitialChecklistEntity> findByOtPreOperativeDiagnosis(@NotNull Boolean otPreOperativeDiagnosis);
	/**
	 * Return an entity or a list of entities that have the given attribute OT Pre Operative Notes Surgery.
	 *
	 * @param otPreOperativeNotesSurgery the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Pre Operative Notes Surgery
	 */
	List<MedicalRecordInitialChecklistEntity> findByOtPreOperativeNotesSurgery(@NotNull Boolean otPreOperativeNotesSurgery);
	/**
	 * Return an entity or a list of entities that have the given attribute OT Pre Operative Notes Anaesthesiology.
	 *
	 * @param otPreOperativeNotesAnaesthesiology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Pre Operative Notes Anaesthesiology
	 */
	List<MedicalRecordInitialChecklistEntity> findByOtPreOperativeNotesAnaesthesiology(@NotNull Boolean otPreOperativeNotesAnaesthesiology);
	/**
	 * Return an entity or a list of entities that have the given attribute OT Intra Operative Notes Surgery.
	 *
	 * @param otIntraOperativeNotesSurgery the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Intra Operative Notes Surgery
	 */
	List<MedicalRecordInitialChecklistEntity> findByOtIntraOperativeNotesSurgery(@NotNull Boolean otIntraOperativeNotesSurgery);
	/**
	 * Return an entity or a list of entities that have the given attribute OT Intra Operative Notes Anaesthesiology.
	 *
	 * @param otIntraOperativeNotesAnaesthesiology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Intra Operative Notes Anaesthesiology
	 */
	List<MedicalRecordInitialChecklistEntity> findByOtIntraOperativeNotesAnaesthesiology(@NotNull Boolean otIntraOperativeNotesAnaesthesiology);
	/**
	 * Return an entity or a list of entities that have the given attribute OT Post Operative Notes Surgery.
	 *
	 * @param otPostOperativeNotesSurgery the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Post Operative Notes Surgery
	 */
	List<MedicalRecordInitialChecklistEntity> findByOtPostOperativeNotesSurgery(@NotNull Boolean otPostOperativeNotesSurgery);
	/**
	 * Return an entity or a list of entities that have the given attribute OT Post Operative Notes Anaesthesiology.
	 *
	 * @param otPostOperativeNotesAnaesthesiology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Post Operative Notes Anaesthesiology
	 */
	List<MedicalRecordInitialChecklistEntity> findByOtPostOperativeNotesAnaesthesiology(@NotNull Boolean otPostOperativeNotesAnaesthesiology);
	/**
	 * Return an entity or a list of entities that have the given attribute OT Post Operative Diagnosis.
	 *
	 * @param otPostOperativeDiagnosis the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Post Operative Diagnosis
	 */
	List<MedicalRecordInitialChecklistEntity> findByOtPostOperativeDiagnosis(@NotNull Boolean otPostOperativeDiagnosis);
	/**
	 * Return an entity or a list of entities that have the given attribute OT Dismissal Type.
	 *
	 * @param otDismissalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute OT Dismissal Type
	 */
	List<MedicalRecordInitialChecklistEntity> findByOtDismissalType(@NotNull Boolean otDismissalType);
	/**
	 * Return an entity or a list of entities that have the given attribute DS Responsible Staff.
	 *
	 * @param dsResponsibleStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DS Responsible Staff
	 */
	List<MedicalRecordInitialChecklistEntity> findByDsResponsibleStaff(@NotNull Boolean dsResponsibleStaff);
	/**
	 * Return an entity or a list of entities that have the given attribute DS Interpretation.
	 *
	 * @param dsInterpretation the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute DS Interpretation
	 */
	List<MedicalRecordInitialChecklistEntity> findByDsInterpretation(@NotNull Boolean dsInterpretation);
	/**
	 * Return an entity or a list of entities that have the given attribute Notes.
	 *
	 * @param notes the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Notes
	 */
	List<MedicalRecordInitialChecklistEntity> findByNotes(@NotNull String notes);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicalRecordInitialChecklistEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<MedicalRecordInitialChecklistEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}