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

package kmsweb.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.MedicalRecordInitialChecklistEntityDto;
import kmsweb.entities.listeners.MedicalRecordInitialChecklistEntityListener;
import kmsweb.serializers.MedicalRecordInitialChecklistSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({MedicalRecordInitialChecklistEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicalRecordInitialChecklistSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicalRecordInitialChecklistEntity extends AbstractEntity {

	/**
	 * Takes a MedicalRecordInitialChecklistEntityDto and converts it into a MedicalRecordInitialChecklistEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicalRecordInitialChecklistEntityDto
	 */
	public MedicalRecordInitialChecklistEntity(MedicalRecordInitialChecklistEntityDto medicalRecordInitialChecklistEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicalRecordInitialChecklistEntityDto.getId() != null) {
			this.setId(medicalRecordInitialChecklistEntityDto.getId());
		}

		if (medicalRecordInitialChecklistEntityDto.getOutVitalSign() != null) {
			this.setOutVitalSign(medicalRecordInitialChecklistEntityDto.getOutVitalSign());
		}

		if (medicalRecordInitialChecklistEntityDto.getOutAnamnesis() != null) {
			this.setOutAnamnesis(medicalRecordInitialChecklistEntityDto.getOutAnamnesis());
		}

		if (medicalRecordInitialChecklistEntityDto.getOutPhysicalExamination() != null) {
			this.setOutPhysicalExamination(medicalRecordInitialChecklistEntityDto.getOutPhysicalExamination());
		}

		if (medicalRecordInitialChecklistEntityDto.getOutDiagnosis() != null) {
			this.setOutDiagnosis(medicalRecordInitialChecklistEntityDto.getOutDiagnosis());
		}

		if (medicalRecordInitialChecklistEntityDto.getOutDismissalType() != null) {
			this.setOutDismissalType(medicalRecordInitialChecklistEntityDto.getOutDismissalType());
		}

		if (medicalRecordInitialChecklistEntityDto.getOutDismissalDateAndTime() != null) {
			this.setOutDismissalDateAndTime(medicalRecordInitialChecklistEntityDto.getOutDismissalDateAndTime());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpVitalSign() != null) {
			this.setInpVitalSign(medicalRecordInitialChecklistEntityDto.getInpVitalSign());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDailyCareDoctorNotes() != null) {
			this.setInpDailyCareDoctorNotes(medicalRecordInitialChecklistEntityDto.getInpDailyCareDoctorNotes());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDailyCareDoctorNotesNA() != null) {
			this.setInpDailyCareDoctorNotesNA(medicalRecordInitialChecklistEntityDto.getInpDailyCareDoctorNotesNA());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDailyCareNursingNotes() != null) {
			this.setInpDailyCareNursingNotes(medicalRecordInitialChecklistEntityDto.getInpDailyCareNursingNotes());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDailyCareNursingNotesNA() != null) {
			this.setInpDailyCareNursingNotesNA(medicalRecordInitialChecklistEntityDto.getInpDailyCareNursingNotesNA());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDailyCareProgressNotes() != null) {
			this.setInpDailyCareProgressNotes(medicalRecordInitialChecklistEntityDto.getInpDailyCareProgressNotes());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDailyCareProgressNotesNA() != null) {
			this.setInpDailyCareProgressNotesNA(medicalRecordInitialChecklistEntityDto.getInpDailyCareProgressNotesNA());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDismissalDiagnosis() != null) {
			this.setInpDismissalDiagnosis(medicalRecordInitialChecklistEntityDto.getInpDismissalDiagnosis());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDismissalType() != null) {
			this.setInpDismissalType(medicalRecordInitialChecklistEntityDto.getInpDismissalType());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDismissalDateAndTime() != null) {
			this.setInpDismissalDateAndTime(medicalRecordInitialChecklistEntityDto.getInpDismissalDateAndTime());
		}

		if (medicalRecordInitialChecklistEntityDto.getInpDismissalCondition() != null) {
			this.setInpDismissalCondition(medicalRecordInitialChecklistEntityDto.getInpDismissalCondition());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrAdmissionDiagnosis() != null) {
			this.setDrAdmissionDiagnosis(medicalRecordInitialChecklistEntityDto.getDrAdmissionDiagnosis());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrObservationDoctorNotes() != null) {
			this.setDrObservationDoctorNotes(medicalRecordInitialChecklistEntityDto.getDrObservationDoctorNotes());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrObservationDoctorNotesNA() != null) {
			this.setDrObservationDoctorNotesNA(medicalRecordInitialChecklistEntityDto.getDrObservationDoctorNotesNA());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrObservationNursingNotes() != null) {
			this.setDrObservationNursingNotes(medicalRecordInitialChecklistEntityDto.getDrObservationNursingNotes());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrObservationNursingNotesNA() != null) {
			this.setDrObservationNursingNotesNA(medicalRecordInitialChecklistEntityDto.getDrObservationNursingNotesNA());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrObservationProgressNotes() != null) {
			this.setDrObservationProgressNotes(medicalRecordInitialChecklistEntityDto.getDrObservationProgressNotes());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrObservationProgressNotesNA() != null) {
			this.setDrObservationProgressNotesNA(medicalRecordInitialChecklistEntityDto.getDrObservationProgressNotesNA());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrDismissalDiagnosis() != null) {
			this.setDrDismissalDiagnosis(medicalRecordInitialChecklistEntityDto.getDrDismissalDiagnosis());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrDismissalType() != null) {
			this.setDrDismissalType(medicalRecordInitialChecklistEntityDto.getDrDismissalType());
		}

		if (medicalRecordInitialChecklistEntityDto.getDrDismissalDateAndTime() != null) {
			this.setDrDismissalDateAndTime(medicalRecordInitialChecklistEntityDto.getDrDismissalDateAndTime());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtPreOperativeDiagnosis() != null) {
			this.setOtPreOperativeDiagnosis(medicalRecordInitialChecklistEntityDto.getOtPreOperativeDiagnosis());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtPreOperativeNotesSurgery() != null) {
			this.setOtPreOperativeNotesSurgery(medicalRecordInitialChecklistEntityDto.getOtPreOperativeNotesSurgery());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtPreOperativeNotesAnaesthesiology() != null) {
			this.setOtPreOperativeNotesAnaesthesiology(medicalRecordInitialChecklistEntityDto.getOtPreOperativeNotesAnaesthesiology());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtIntraOperativeNotesSurgery() != null) {
			this.setOtIntraOperativeNotesSurgery(medicalRecordInitialChecklistEntityDto.getOtIntraOperativeNotesSurgery());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtIntraOperativeNotesAnaesthesiology() != null) {
			this.setOtIntraOperativeNotesAnaesthesiology(medicalRecordInitialChecklistEntityDto.getOtIntraOperativeNotesAnaesthesiology());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtPostOperativeNotesSurgery() != null) {
			this.setOtPostOperativeNotesSurgery(medicalRecordInitialChecklistEntityDto.getOtPostOperativeNotesSurgery());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtPostOperativeNotesAnaesthesiology() != null) {
			this.setOtPostOperativeNotesAnaesthesiology(medicalRecordInitialChecklistEntityDto.getOtPostOperativeNotesAnaesthesiology());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtPostOperativeDiagnosis() != null) {
			this.setOtPostOperativeDiagnosis(medicalRecordInitialChecklistEntityDto.getOtPostOperativeDiagnosis());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtDismissalType() != null) {
			this.setOtDismissalType(medicalRecordInitialChecklistEntityDto.getOtDismissalType());
		}

		if (medicalRecordInitialChecklistEntityDto.getOtDismissalDateAndTime() != null) {
			this.setOtDismissalDateAndTime(medicalRecordInitialChecklistEntityDto.getOtDismissalDateAndTime());
		}

		if (medicalRecordInitialChecklistEntityDto.getDsResponsibleStaff() != null) {
			this.setDsResponsibleStaff(medicalRecordInitialChecklistEntityDto.getDsResponsibleStaff());
		}

		if (medicalRecordInitialChecklistEntityDto.getDsInterpretation() != null) {
			this.setDsInterpretation(medicalRecordInitialChecklistEntityDto.getDsInterpretation());
		}

		if (medicalRecordInitialChecklistEntityDto.getNotes() != null) {
			this.setNotes(medicalRecordInitialChecklistEntityDto.getNotes());
		}

		if (medicalRecordInitialChecklistEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(medicalRecordInitialChecklistEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Out Vital Sign here] off begin
	@CsvBindByName(column = "OUT_VITAL_SIGN", required = false)
	@Nullable
	@Column(name = "out_vital_sign")
	@Schema(description = "The Out Vital Sign of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Out Vital Sign here] end
	private Boolean outVitalSign = false ;

	// % protected region % [Modify attribute annotation for Out Anamnesis here] off begin
	@CsvBindByName(column = "OUT_ANAMNESIS", required = false)
	@Nullable
	@Column(name = "out_anamnesis")
	@Schema(description = "The Out Anamnesis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Out Anamnesis here] end
	private Boolean outAnamnesis = false ;

	// % protected region % [Modify attribute annotation for Out Physical Examination here] off begin
	@CsvBindByName(column = "OUT_PHYSICAL_EXAMINATION", required = false)
	@Nullable
	@Column(name = "out_physical_examination")
	@Schema(description = "The Out Physical Examination of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Out Physical Examination here] end
	private Boolean outPhysicalExamination = false ;

	// % protected region % [Modify attribute annotation for Out Diagnosis here] off begin
	@CsvBindByName(column = "OUT_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "out_diagnosis")
	@Schema(description = "The Out Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Out Diagnosis here] end
	private Boolean outDiagnosis = false ;

	// % protected region % [Modify attribute annotation for Out Dismissal Type here] off begin
	@CsvBindByName(column = "OUT_DISMISSAL_TYPE", required = false)
	@Nullable
	@Column(name = "out_dismissal_type")
	@Schema(description = "The Out Dismissal Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Out Dismissal Type here] end
	private Boolean outDismissalType = false ;

	// % protected region % [Modify attribute annotation for Out Dismissal Date and Time here] off begin
	@CsvBindByName(column = "OUT_DISMISSAL_DATE_AND_TIME", required = false)
	@Nullable
	@Column(name = "out_dismissal_date_and_time")
	@Schema(description = "The Out Dismissal Date and Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Out Dismissal Date and Time here] end
	private Boolean outDismissalDateAndTime = false ;

	// % protected region % [Modify attribute annotation for Inp Vital Sign here] off begin
	@CsvBindByName(column = "INP_VITAL_SIGN", required = false)
	@Nullable
	@Column(name = "inp_vital_sign")
	@Schema(description = "The Inp Vital Sign of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Vital Sign here] end
	private Boolean inpVitalSign = false ;

	// % protected region % [Modify attribute annotation for Inp Daily Care Doctor Notes here] off begin
	@CsvBindByName(column = "INP_DAILY_CARE_DOCTOR_NOTES", required = false)
	@Nullable
	@Column(name = "inp_daily_care_doctor_notes")
	@Schema(description = "The Inp Daily Care Doctor Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Daily Care Doctor Notes here] end
	private Boolean inpDailyCareDoctorNotes = false ;

	// % protected region % [Modify attribute annotation for Inp Daily Care Doctor Notes NA here] off begin
	@CsvBindByName(column = "INP_DAILY_CARE_DOCTOR_NOTES_NA", required = false)
	@Nullable
	@Column(name = "inp_daily_care_doctor_notes_na")
	@Schema(description = "The Inp Daily Care Doctor Notes NA of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Daily Care Doctor Notes NA here] end
	private Boolean inpDailyCareDoctorNotesNA = false ;

	// % protected region % [Modify attribute annotation for Inp Daily Care Nursing Notes here] off begin
	@CsvBindByName(column = "INP_DAILY_CARE_NURSING_NOTES", required = false)
	@Nullable
	@Column(name = "inp_daily_care_nursing_notes")
	@Schema(description = "The Inp Daily Care Nursing Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Daily Care Nursing Notes here] end
	private Boolean inpDailyCareNursingNotes = false ;

	// % protected region % [Modify attribute annotation for Inp Daily Care Nursing Notes NA here] off begin
	@CsvBindByName(column = "INP_DAILY_CARE_NURSING_NOTES_NA", required = false)
	@Nullable
	@Column(name = "inp_daily_care_nursing_notes_na")
	@Schema(description = "The Inp Daily Care Nursing Notes NA of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Daily Care Nursing Notes NA here] end
	private Boolean inpDailyCareNursingNotesNA = false ;

	// % protected region % [Modify attribute annotation for Inp Daily Care Progress Notes here] off begin
	@CsvBindByName(column = "INP_DAILY_CARE_PROGRESS_NOTES", required = false)
	@Nullable
	@Column(name = "inp_daily_care_progress_notes")
	@Schema(description = "The Inp Daily Care Progress Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Daily Care Progress Notes here] end
	private Boolean inpDailyCareProgressNotes = false ;

	// % protected region % [Modify attribute annotation for Inp Daily Care Progress Notes NA here] off begin
	@CsvBindByName(column = "INP_DAILY_CARE_PROGRESS_NOTES_NA", required = false)
	@Nullable
	@Column(name = "inp_daily_care_progress_notes_na")
	@Schema(description = "The Inp Daily Care Progress Notes NA of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Daily Care Progress Notes NA here] end
	private Boolean inpDailyCareProgressNotesNA = false ;

	// % protected region % [Modify attribute annotation for Inp Dismissal Diagnosis here] off begin
	@CsvBindByName(column = "INP_DISMISSAL_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "inp_dismissal_diagnosis")
	@Schema(description = "The Inp Dismissal Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Dismissal Diagnosis here] end
	private Boolean inpDismissalDiagnosis = false ;

	// % protected region % [Modify attribute annotation for Inp Dismissal Type here] off begin
	@CsvBindByName(column = "INP_DISMISSAL_TYPE", required = false)
	@Nullable
	@Column(name = "inp_dismissal_type")
	@Schema(description = "The Inp Dismissal Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Dismissal Type here] end
	private Boolean inpDismissalType = false ;

	// % protected region % [Modify attribute annotation for Inp Dismissal Date and Time here] off begin
	@CsvBindByName(column = "INP_DISMISSAL_DATE_AND_TIME", required = false)
	@Nullable
	@Column(name = "inp_dismissal_date_and_time")
	@Schema(description = "The Inp Dismissal Date and Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Dismissal Date and Time here] end
	private Boolean inpDismissalDateAndTime = false ;

	// % protected region % [Modify attribute annotation for Inp Dismissal Condition here] off begin
	@CsvBindByName(column = "INP_DISMISSAL_CONDITION", required = false)
	@Nullable
	@Column(name = "inp_dismissal_condition")
	@Schema(description = "The Inp Dismissal Condition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inp Dismissal Condition here] end
	private Boolean inpDismissalCondition = false ;

	// % protected region % [Modify attribute annotation for DR Admission Diagnosis here] off begin
	@CsvBindByName(column = "DR_ADMISSION_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "dr_admission_diagnosis")
	@Schema(description = "The DR Admission Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Admission Diagnosis here] end
	private Boolean drAdmissionDiagnosis = false ;

	// % protected region % [Modify attribute annotation for DR Observation Doctor Notes here] off begin
	@CsvBindByName(column = "DR_OBSERVATION_DOCTOR_NOTES", required = false)
	@Nullable
	@Column(name = "dr_observation_doctor_notes")
	@Schema(description = "The DR Observation Doctor Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Observation Doctor Notes here] end
	private Boolean drObservationDoctorNotes = false ;

	// % protected region % [Modify attribute annotation for DR Observation Doctor Notes NA here] off begin
	@CsvBindByName(column = "DR_OBSERVATION_DOCTOR_NOTES_NA", required = false)
	@Nullable
	@Column(name = "dr_observation_doctor_notes_na")
	@Schema(description = "The DR Observation Doctor Notes NA of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Observation Doctor Notes NA here] end
	private Boolean drObservationDoctorNotesNA = false ;

	// % protected region % [Modify attribute annotation for DR Observation Nursing Notes here] off begin
	@CsvBindByName(column = "DR_OBSERVATION_NURSING_NOTES", required = false)
	@Nullable
	@Column(name = "dr_observation_nursing_notes")
	@Schema(description = "The DR Observation Nursing Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Observation Nursing Notes here] end
	private Boolean drObservationNursingNotes = false ;

	// % protected region % [Modify attribute annotation for DR Observation Nursing Notes NA here] off begin
	@CsvBindByName(column = "DR_OBSERVATION_NURSING_NOTES_NA", required = false)
	@Nullable
	@Column(name = "dr_observation_nursing_notes_na")
	@Schema(description = "The DR Observation Nursing Notes NA of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Observation Nursing Notes NA here] end
	private Boolean drObservationNursingNotesNA = false ;

	// % protected region % [Modify attribute annotation for DR Observation Progress Notes here] off begin
	@CsvBindByName(column = "DR_OBSERVATION_PROGRESS_NOTES", required = false)
	@Nullable
	@Column(name = "dr_observation_progress_notes")
	@Schema(description = "The DR Observation Progress Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Observation Progress Notes here] end
	private Boolean drObservationProgressNotes = false ;

	// % protected region % [Modify attribute annotation for DR Observation Progress Notes NA here] off begin
	@CsvBindByName(column = "DR_OBSERVATION_PROGRESS_NOTES_NA", required = false)
	@Nullable
	@Column(name = "dr_observation_progress_notes_na")
	@Schema(description = "The DR Observation Progress Notes NA of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Observation Progress Notes NA here] end
	private Boolean drObservationProgressNotesNA = false ;

	// % protected region % [Modify attribute annotation for DR Dismissal Diagnosis here] off begin
	@CsvBindByName(column = "DR_DISMISSAL_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "dr_dismissal_diagnosis")
	@Schema(description = "The DR Dismissal Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Dismissal Diagnosis here] end
	private Boolean drDismissalDiagnosis = false ;

	// % protected region % [Modify attribute annotation for DR Dismissal Type here] off begin
	@CsvBindByName(column = "DR_DISMISSAL_TYPE", required = false)
	@Nullable
	@Column(name = "dr_dismissal_type")
	@Schema(description = "The DR Dismissal Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Dismissal Type here] end
	private Boolean drDismissalType = false ;

	// % protected region % [Modify attribute annotation for DR Dismissal Date and Time here] off begin
	@CsvBindByName(column = "DR_DISMISSAL_DATE_AND_TIME", required = false)
	@Nullable
	@Column(name = "dr_dismissal_date_and_time")
	@Schema(description = "The DR Dismissal Date and Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DR Dismissal Date and Time here] end
	private Boolean drDismissalDateAndTime = false ;

	// % protected region % [Modify attribute annotation for OT Pre Operative Diagnosis here] off begin
	@CsvBindByName(column = "OT_PRE_OPERATIVE_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "ot_pre_operative_diagnosis")
	@Schema(description = "The OT Pre Operative Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Pre Operative Diagnosis here] end
	private Boolean otPreOperativeDiagnosis = false ;

	// % protected region % [Modify attribute annotation for OT Pre Operative Notes Surgery here] off begin
	@CsvBindByName(column = "OT_PRE_OPERATIVE_NOTES_SURGERY", required = false)
	@Nullable
	@Column(name = "ot_pre_operative_notes_surgery")
	@Schema(description = "The OT Pre Operative Notes Surgery of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Pre Operative Notes Surgery here] end
	private Boolean otPreOperativeNotesSurgery = false ;

	// % protected region % [Modify attribute annotation for OT Pre Operative Notes Anaesthesiology here] off begin
	@CsvBindByName(column = "OT_PRE_OPERATIVE_NOTES_ANAESTHESIOLOGY", required = false)
	@Nullable
	@Column(name = "ot_pre_operative_notes_anaesthesiology")
	@Schema(description = "The OT Pre Operative Notes Anaesthesiology of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Pre Operative Notes Anaesthesiology here] end
	private Boolean otPreOperativeNotesAnaesthesiology = false ;

	// % protected region % [Modify attribute annotation for OT Intra Operative Notes Surgery here] off begin
	@CsvBindByName(column = "OT_INTRA_OPERATIVE_NOTES_SURGERY", required = false)
	@Nullable
	@Column(name = "ot_intra_operative_notes_surgery")
	@Schema(description = "The OT Intra Operative Notes Surgery of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Intra Operative Notes Surgery here] end
	private Boolean otIntraOperativeNotesSurgery = false ;

	// % protected region % [Modify attribute annotation for OT Intra Operative Notes Anaesthesiology here] off begin
	@CsvBindByName(column = "OT_INTRA_OPERATIVE_NOTES_ANAESTHESIOLOGY", required = false)
	@Nullable
	@Column(name = "ot_intra_operative_notes_anaesthesiology")
	@Schema(description = "The OT Intra Operative Notes Anaesthesiology of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Intra Operative Notes Anaesthesiology here] end
	private Boolean otIntraOperativeNotesAnaesthesiology = false ;

	// % protected region % [Modify attribute annotation for OT Post Operative Notes Surgery here] off begin
	@CsvBindByName(column = "OT_POST_OPERATIVE_NOTES_SURGERY", required = false)
	@Nullable
	@Column(name = "ot_post_operative_notes_surgery")
	@Schema(description = "The OT Post Operative Notes Surgery of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Post Operative Notes Surgery here] end
	private Boolean otPostOperativeNotesSurgery = false ;

	// % protected region % [Modify attribute annotation for OT Post Operative Notes Anaesthesiology here] off begin
	@CsvBindByName(column = "OT_POST_OPERATIVE_NOTES_ANAESTHESIOLOGY", required = false)
	@Nullable
	@Column(name = "ot_post_operative_notes_anaesthesiology")
	@Schema(description = "The OT Post Operative Notes Anaesthesiology of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Post Operative Notes Anaesthesiology here] end
	private Boolean otPostOperativeNotesAnaesthesiology = false ;

	// % protected region % [Modify attribute annotation for OT Post Operative Diagnosis here] off begin
	@CsvBindByName(column = "OT_POST_OPERATIVE_DIAGNOSIS", required = false)
	@Nullable
	@Column(name = "ot_post_operative_diagnosis")
	@Schema(description = "The OT Post Operative Diagnosis of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Post Operative Diagnosis here] end
	private Boolean otPostOperativeDiagnosis = false ;

	// % protected region % [Modify attribute annotation for OT Dismissal Type here] off begin
	@CsvBindByName(column = "OT_DISMISSAL_TYPE", required = false)
	@Nullable
	@Column(name = "ot_dismissal_type")
	@Schema(description = "The OT Dismissal Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Dismissal Type here] end
	private Boolean otDismissalType = false ;

	// % protected region % [Modify attribute annotation for OT Dismissal Date and Time here] off begin
	@CsvBindByName(column = "OT_DISMISSAL_DATE_AND_TIME", required = false)
	@Nullable
	@Column(name = "ot_dismissal_date_and_time")
	@Schema(description = "The OT Dismissal Date and Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for OT Dismissal Date and Time here] end
	private Boolean otDismissalDateAndTime = false ;

	// % protected region % [Modify attribute annotation for DS Responsible Staff here] off begin
	@CsvBindByName(column = "DS_RESPONSIBLE_STAFF", required = false)
	@Nullable
	@Column(name = "ds_responsible_staff")
	@Schema(description = "The DS Responsible Staff of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DS Responsible Staff here] end
	private Boolean dsResponsibleStaff = false ;

	// % protected region % [Modify attribute annotation for DS Interpretation here] off begin
	@CsvBindByName(column = "DS_INTERPRETATION", required = false)
	@Nullable
	@Column(name = "ds_interpretation")
	@Schema(description = "The DS Interpretation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DS Interpretation here] end
	private Boolean dsInterpretation = false ;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record here] end
	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Update the annotation for medicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordId here] end
	private UUID medicalExaminationRecordId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetMedicalRecordInitialChecklist(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setMedicalRecordInitialChecklist(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity of medicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetMedicalRecordInitialChecklist();
		}
		this.medicalExaminationRecord = null;
	}

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "OUT_VITAL_SIGN,OUT_ANAMNESIS,OUT_PHYSICAL_EXAMINATION,OUT_DIAGNOSIS,OUT_DISMISSAL_TYPE,OUT_DISMISSAL_DATE_AND_TIME,INP_VITAL_SIGN,INP_DAILY_CARE_DOCTOR_NOTES,INP_DAILY_CARE_DOCTOR_NOTES_NA,INP_DAILY_CARE_NURSING_NOTES,INP_DAILY_CARE_NURSING_NOTES_NA,INP_DAILY_CARE_PROGRESS_NOTES,INP_DAILY_CARE_PROGRESS_NOTES_NA,INP_DISMISSAL_DIAGNOSIS,INP_DISMISSAL_TYPE,INP_DISMISSAL_DATE_AND_TIME,INP_DISMISSAL_CONDITION,DR_ADMISSION_DIAGNOSIS,DR_OBSERVATION_DOCTOR_NOTES,DR_OBSERVATION_DOCTOR_NOTES_NA,DR_OBSERVATION_NURSING_NOTES,DR_OBSERVATION_NURSING_NOTES_NA,DR_OBSERVATION_PROGRESS_NOTES,DR_OBSERVATION_PROGRESS_NOTES_NA,DR_DISMISSAL_DIAGNOSIS,DR_DISMISSAL_TYPE,DR_DISMISSAL_DATE_AND_TIME,OT_PRE_OPERATIVE_DIAGNOSIS,OT_PRE_OPERATIVE_NOTES_SURGERY,OT_PRE_OPERATIVE_NOTES_ANAESTHESIOLOGY,OT_INTRA_OPERATIVE_NOTES_SURGERY,OT_INTRA_OPERATIVE_NOTES_ANAESTHESIOLOGY,OT_POST_OPERATIVE_NOTES_SURGERY,OT_POST_OPERATIVE_NOTES_ANAESTHESIOLOGY,OT_POST_OPERATIVE_DIAGNOSIS,OT_DISMISSAL_TYPE,OT_DISMISSAL_DATE_AND_TIME,DS_RESPONSIBLE_STAFF,DS_INTERPRETATION,NOTES,MEDICAL_EXAMINATION_RECORD_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicalRecordInitialChecklist) {
		if (this == medicalRecordInitialChecklist) {
			return true;
		}
		if (medicalRecordInitialChecklist == null || this.getClass() != medicalRecordInitialChecklist.getClass()) {
			return false;
		}
		if (!super.equals(medicalRecordInitialChecklist)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicalRecordInitialChecklistEntity that = (MedicalRecordInitialChecklistEntity) medicalRecordInitialChecklist;
		return
			Objects.equals(this.outVitalSign, that.outVitalSign) &&
			Objects.equals(this.outAnamnesis, that.outAnamnesis) &&
			Objects.equals(this.outPhysicalExamination, that.outPhysicalExamination) &&
			Objects.equals(this.outDiagnosis, that.outDiagnosis) &&
			Objects.equals(this.outDismissalType, that.outDismissalType) &&
			Objects.equals(this.outDismissalDateAndTime, that.outDismissalDateAndTime) &&
			Objects.equals(this.inpVitalSign, that.inpVitalSign) &&
			Objects.equals(this.inpDailyCareDoctorNotes, that.inpDailyCareDoctorNotes) &&
			Objects.equals(this.inpDailyCareDoctorNotesNA, that.inpDailyCareDoctorNotesNA) &&
			Objects.equals(this.inpDailyCareNursingNotes, that.inpDailyCareNursingNotes) &&
			Objects.equals(this.inpDailyCareNursingNotesNA, that.inpDailyCareNursingNotesNA) &&
			Objects.equals(this.inpDailyCareProgressNotes, that.inpDailyCareProgressNotes) &&
			Objects.equals(this.inpDailyCareProgressNotesNA, that.inpDailyCareProgressNotesNA) &&
			Objects.equals(this.inpDismissalDiagnosis, that.inpDismissalDiagnosis) &&
			Objects.equals(this.inpDismissalType, that.inpDismissalType) &&
			Objects.equals(this.inpDismissalDateAndTime, that.inpDismissalDateAndTime) &&
			Objects.equals(this.inpDismissalCondition, that.inpDismissalCondition) &&
			Objects.equals(this.drAdmissionDiagnosis, that.drAdmissionDiagnosis) &&
			Objects.equals(this.drObservationDoctorNotes, that.drObservationDoctorNotes) &&
			Objects.equals(this.drObservationDoctorNotesNA, that.drObservationDoctorNotesNA) &&
			Objects.equals(this.drObservationNursingNotes, that.drObservationNursingNotes) &&
			Objects.equals(this.drObservationNursingNotesNA, that.drObservationNursingNotesNA) &&
			Objects.equals(this.drObservationProgressNotes, that.drObservationProgressNotes) &&
			Objects.equals(this.drObservationProgressNotesNA, that.drObservationProgressNotesNA) &&
			Objects.equals(this.drDismissalDiagnosis, that.drDismissalDiagnosis) &&
			Objects.equals(this.drDismissalType, that.drDismissalType) &&
			Objects.equals(this.drDismissalDateAndTime, that.drDismissalDateAndTime) &&
			Objects.equals(this.otPreOperativeDiagnosis, that.otPreOperativeDiagnosis) &&
			Objects.equals(this.otPreOperativeNotesSurgery, that.otPreOperativeNotesSurgery) &&
			Objects.equals(this.otPreOperativeNotesAnaesthesiology, that.otPreOperativeNotesAnaesthesiology) &&
			Objects.equals(this.otIntraOperativeNotesSurgery, that.otIntraOperativeNotesSurgery) &&
			Objects.equals(this.otIntraOperativeNotesAnaesthesiology, that.otIntraOperativeNotesAnaesthesiology) &&
			Objects.equals(this.otPostOperativeNotesSurgery, that.otPostOperativeNotesSurgery) &&
			Objects.equals(this.otPostOperativeNotesAnaesthesiology, that.otPostOperativeNotesAnaesthesiology) &&
			Objects.equals(this.otPostOperativeDiagnosis, that.otPostOperativeDiagnosis) &&
			Objects.equals(this.otDismissalType, that.otDismissalType) &&
			Objects.equals(this.otDismissalDateAndTime, that.otDismissalDateAndTime) &&
			Objects.equals(this.dsResponsibleStaff, that.dsResponsibleStaff) &&
			Objects.equals(this.dsInterpretation, that.dsInterpretation) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
