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
import kmsweb.dtos.OperatingTheaterMedicalExaminationRecordEntityDto;
import kmsweb.entities.listeners.OperatingTheaterMedicalExaminationRecordEntityListener;
import kmsweb.serializers.OperatingTheaterMedicalExaminationRecordSerializer;
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
@EntityListeners({OperatingTheaterMedicalExaminationRecordEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = OperatingTheaterMedicalExaminationRecordSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class OperatingTheaterMedicalExaminationRecordEntity extends AbstractEntity {

	/**
	 * Takes a OperatingTheaterMedicalExaminationRecordEntityDto and converts it into a OperatingTheaterMedicalExaminationRecordEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param operatingTheaterMedicalExaminationRecordEntityDto
	 */
	public OperatingTheaterMedicalExaminationRecordEntity(OperatingTheaterMedicalExaminationRecordEntityDto operatingTheaterMedicalExaminationRecordEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (operatingTheaterMedicalExaminationRecordEntityDto.getId() != null) {
			this.setId(operatingTheaterMedicalExaminationRecordEntityDto.getId());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getHasConfirmedIdentity() != null) {
			this.setHasConfirmedIdentity(operatingTheaterMedicalExaminationRecordEntityDto.getHasConfirmedIdentity());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getAnesthesiaSafetyCheckCompleted() != null) {
			this.setAnesthesiaSafetyCheckCompleted(operatingTheaterMedicalExaminationRecordEntityDto.getAnesthesiaSafetyCheckCompleted());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getPulseOxymeterFunctioning() != null) {
			this.setPulseOxymeterFunctioning(operatingTheaterMedicalExaminationRecordEntityDto.getPulseOxymeterFunctioning());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getSiteMarked() != null) {
			this.setSiteMarked(operatingTheaterMedicalExaminationRecordEntityDto.getSiteMarked());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getHasKnownAllergy() != null) {
			this.setHasKnownAllergy(operatingTheaterMedicalExaminationRecordEntityDto.getHasKnownAllergy());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getHasDifficultAirwayRisk() != null) {
			this.setHasDifficultAirwayRisk(operatingTheaterMedicalExaminationRecordEntityDto.getHasDifficultAirwayRisk());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getHasRiskOfBloodLoss() != null) {
			this.setHasRiskOfBloodLoss(operatingTheaterMedicalExaminationRecordEntityDto.getHasRiskOfBloodLoss());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getTeamMemberIntroduced() != null) {
			this.setTeamMemberIntroduced(operatingTheaterMedicalExaminationRecordEntityDto.getTeamMemberIntroduced());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getProfessionalConfirmedPatient() != null) {
			this.setProfessionalConfirmedPatient(operatingTheaterMedicalExaminationRecordEntityDto.getProfessionalConfirmedPatient());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getAntibioticProphylaxisGiven() != null) {
			this.setAntibioticProphylaxisGiven(operatingTheaterMedicalExaminationRecordEntityDto.getAntibioticProphylaxisGiven());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getEssentialImagingDisplayed() != null) {
			this.setEssentialImagingDisplayed(operatingTheaterMedicalExaminationRecordEntityDto.getEssentialImagingDisplayed());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getWhareAreCriticalSteps() != null) {
			this.setWhareAreCriticalSteps(operatingTheaterMedicalExaminationRecordEntityDto.getWhareAreCriticalSteps());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getHowLongCaseTake() != null) {
			this.setHowLongCaseTake(operatingTheaterMedicalExaminationRecordEntityDto.getHowLongCaseTake());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getWhatIsAnticipatedBloodLoss() != null) {
			this.setWhatIsAnticipatedBloodLoss(operatingTheaterMedicalExaminationRecordEntityDto.getWhatIsAnticipatedBloodLoss());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getAnyPatientSpecificConcerns() != null) {
			this.setAnyPatientSpecificConcerns(operatingTheaterMedicalExaminationRecordEntityDto.getAnyPatientSpecificConcerns());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getSterlityBeenConfirmed() != null) {
			this.setSterlityBeenConfirmed(operatingTheaterMedicalExaminationRecordEntityDto.getSterlityBeenConfirmed());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getEquipmentIssuesAnyConcern() != null) {
			this.setEquipmentIssuesAnyConcern(operatingTheaterMedicalExaminationRecordEntityDto.getEquipmentIssuesAnyConcern());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getNameOfProcedure() != null) {
			this.setNameOfProcedure(operatingTheaterMedicalExaminationRecordEntityDto.getNameOfProcedure());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getInstrumentsNeedCountCorrect() != null) {
			this.setInstrumentsNeedCountCorrect(operatingTheaterMedicalExaminationRecordEntityDto.getInstrumentsNeedCountCorrect());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getSpecimenIsLabeled() != null) {
			this.setSpecimenIsLabeled(operatingTheaterMedicalExaminationRecordEntityDto.getSpecimenIsLabeled());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getEquipmentProblemsAddressed() != null) {
			this.setEquipmentProblemsAddressed(operatingTheaterMedicalExaminationRecordEntityDto.getEquipmentProblemsAddressed());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getKeyConcernsForRecovery() != null) {
			this.setKeyConcernsForRecovery(operatingTheaterMedicalExaminationRecordEntityDto.getKeyConcernsForRecovery());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getIntraoperativeRecords() != null) {
			this.setIntraoperativeRecords(operatingTheaterMedicalExaminationRecordEntityDto.getIntraoperativeRecords());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getPostOperativeDetails() != null) {
			this.setPostOperativeDetails(operatingTheaterMedicalExaminationRecordEntityDto.getPostOperativeDetails());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getPreoperativeRecords() != null) {
			this.setPreoperativeRecords(operatingTheaterMedicalExaminationRecordEntityDto.getPreoperativeRecords());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getNursingAnesthesiaDetail() != null) {
			this.setNursingAnesthesiaDetail(operatingTheaterMedicalExaminationRecordEntityDto.getNursingAnesthesiaDetail());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getNursingDetailSurgicalNursings() != null) {
			this.setNursingDetailSurgicalNursings(operatingTheaterMedicalExaminationRecordEntityDto.getNursingDetailSurgicalNursings());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getNursingDetailsAnesthesiaNursings() != null) {
			this.setNursingDetailsAnesthesiaNursings(operatingTheaterMedicalExaminationRecordEntityDto.getNursingDetailsAnesthesiaNursings());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getNursingSurgicalDetail() != null) {
			this.setNursingSurgicalDetail(operatingTheaterMedicalExaminationRecordEntityDto.getNursingSurgicalDetail());
		}

		if (operatingTheaterMedicalExaminationRecordEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Has Confirmed Identity here] off begin
	@CsvBindByName(column = "HAS_CONFIRMED_IDENTITY", required = false)
	@Nullable
	@Column(name = "has_confirmed_identity")
	@Schema(description = "The Has Confirmed Identity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Has Confirmed Identity here] end
	private Boolean hasConfirmedIdentity = false ;

	// % protected region % [Modify attribute annotation for Anesthesia Safety Check Completed here] off begin
	@CsvBindByName(column = "ANESTHESIA_SAFETY_CHECK_COMPLETED", required = false)
	@Nullable
	@Column(name = "anesthesia_safety_check_completed")
	@Schema(description = "The Anesthesia Safety Check Completed of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Anesthesia Safety Check Completed here] end
	private Boolean anesthesiaSafetyCheckCompleted = false ;

	// % protected region % [Modify attribute annotation for Pulse Oxymeter Functioning here] off begin
	@CsvBindByName(column = "PULSE_OXYMETER_FUNCTIONING", required = false)
	@Nullable
	@Column(name = "pulse_oxymeter_functioning")
	@Schema(description = "The Pulse Oxymeter Functioning of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pulse Oxymeter Functioning here] end
	private Boolean pulseOxymeterFunctioning = false ;

	// % protected region % [Modify attribute annotation for Site Marked here] off begin
	@CsvBindByName(column = "SITE_MARKED", required = false)
	@Nullable
	@Column(name = "site_marked")
	@Schema(description = "The Site Marked of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Site Marked here] end
	private String siteMarked;

	// % protected region % [Modify attribute annotation for Has Known Allergy here] off begin
	@CsvBindByName(column = "HAS_KNOWN_ALLERGY", required = false)
	@Nullable
	@Column(name = "has_known_allergy")
	@Schema(description = "The Has Known Allergy of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Has Known Allergy here] end
	private String hasKnownAllergy;

	// % protected region % [Modify attribute annotation for Has Difficult Airway Risk here] off begin
	@CsvBindByName(column = "HAS_DIFFICULT_AIRWAY_RISK", required = false)
	@Nullable
	@Column(name = "has_difficult_airway_risk")
	@Schema(description = "The Has Difficult Airway Risk of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Has Difficult Airway Risk here] end
	private String hasDifficultAirwayRisk;

	// % protected region % [Modify attribute annotation for Has Risk Of Blood Loss here] off begin
	@CsvBindByName(column = "HAS_RISK_OF_BLOOD_LOSS", required = false)
	@Nullable
	@Column(name = "has_risk_of_blood_loss")
	@Schema(description = "The Has Risk Of Blood Loss of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Has Risk Of Blood Loss here] end
	private String hasRiskOfBloodLoss;

	// % protected region % [Modify attribute annotation for Team Member Introduced here] off begin
	@CsvBindByName(column = "TEAM_MEMBER_INTRODUCED", required = false)
	@Nullable
	@Column(name = "team_member_introduced")
	@Schema(description = "The Team Member Introduced of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Team Member Introduced here] end
	private Boolean teamMemberIntroduced = false ;

	// % protected region % [Modify attribute annotation for Professional Confirmed Patient here] off begin
	@CsvBindByName(column = "PROFESSIONAL_CONFIRMED_PATIENT", required = false)
	@Nullable
	@Column(name = "professional_confirmed_patient")
	@Schema(description = "The Professional Confirmed Patient of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Professional Confirmed Patient here] end
	private Boolean professionalConfirmedPatient = false ;

	// % protected region % [Modify attribute annotation for Antibiotic Prophylaxis Given here] off begin
	@CsvBindByName(column = "ANTIBIOTIC_PROPHYLAXIS_GIVEN", required = false)
	@Nullable
	@Column(name = "antibiotic_prophylaxis_given")
	@Schema(description = "The Antibiotic Prophylaxis Given of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Antibiotic Prophylaxis Given here] end
	private String antibioticProphylaxisGiven;

	// % protected region % [Modify attribute annotation for Essential Imaging Displayed here] off begin
	@CsvBindByName(column = "ESSENTIAL_IMAGING_DISPLAYED", required = false)
	@Nullable
	@Column(name = "essential_imaging_displayed")
	@Schema(description = "The Essential Imaging Displayed of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Essential Imaging Displayed here] end
	private String essentialImagingDisplayed;

	// % protected region % [Modify attribute annotation for Whare Are Critical Steps here] off begin
	@CsvBindByName(column = "WHARE_ARE_CRITICAL_STEPS", required = false)
	@Nullable
	@Column(name = "whare_are_critical_steps")
	@Schema(description = "The Whare Are Critical Steps of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Whare Are Critical Steps here] end
	private Boolean whareAreCriticalSteps = false ;

	// % protected region % [Modify attribute annotation for How Long Case Take here] off begin
	@CsvBindByName(column = "HOW_LONG_CASE_TAKE", required = false)
	@Nullable
	@Column(name = "how_long_case_take")
	@Schema(description = "The How Long Case Take of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for How Long Case Take here] end
	private Boolean howLongCaseTake = false ;

	// % protected region % [Modify attribute annotation for What Is Anticipated Blood Loss here] off begin
	@CsvBindByName(column = "WHAT_IS_ANTICIPATED_BLOOD_LOSS", required = false)
	@Nullable
	@Column(name = "what_is_anticipated_blood_loss")
	@Schema(description = "The What Is Anticipated Blood Loss of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for What Is Anticipated Blood Loss here] end
	private Boolean whatIsAnticipatedBloodLoss = false ;

	// % protected region % [Modify attribute annotation for Any Patient Specific Concerns here] off begin
	@CsvBindByName(column = "ANY_PATIENT_SPECIFIC_CONCERNS", required = false)
	@Nullable
	@Column(name = "any_patient_specific_concerns")
	@Schema(description = "The Any Patient Specific Concerns of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Any Patient Specific Concerns here] end
	private Boolean anyPatientSpecificConcerns = false ;

	// % protected region % [Modify attribute annotation for Sterlity Been Confirmed here] off begin
	@CsvBindByName(column = "STERLITY_BEEN_CONFIRMED", required = false)
	@Nullable
	@Column(name = "sterlity_been_confirmed")
	@Schema(description = "The Sterlity Been Confirmed of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sterlity Been Confirmed here] end
	private Boolean sterlityBeenConfirmed = false ;

	// % protected region % [Modify attribute annotation for Equipment Issues Any Concern here] off begin
	@CsvBindByName(column = "EQUIPMENT_ISSUES_ANY_CONCERN", required = false)
	@Nullable
	@Column(name = "equipment_issues_any_concern")
	@Schema(description = "The Equipment Issues Any Concern of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Equipment Issues Any Concern here] end
	private Boolean equipmentIssuesAnyConcern = false ;

	// % protected region % [Modify attribute annotation for Name Of Procedure here] off begin
	@CsvBindByName(column = "NAME_OF_PROCEDURE", required = false)
	@Nullable
	@Column(name = "name_of_procedure")
	@Schema(description = "The Name Of Procedure of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name Of Procedure here] end
	private Boolean nameOfProcedure = false ;

	// % protected region % [Modify attribute annotation for Instruments Need Count Correct here] off begin
	@CsvBindByName(column = "INSTRUMENTS_NEED_COUNT_CORRECT", required = false)
	@Nullable
	@Column(name = "instruments_need_count_correct")
	@Schema(description = "The Instruments Need Count Correct of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Instruments Need Count Correct here] end
	private Boolean instrumentsNeedCountCorrect = false ;

	// % protected region % [Modify attribute annotation for Specimen Is Labeled here] off begin
	@CsvBindByName(column = "SPECIMEN_IS_LABELED", required = false)
	@Nullable
	@Column(name = "specimen_is_labeled")
	@Schema(description = "The Specimen Is Labeled of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Specimen Is Labeled here] end
	private Boolean specimenIsLabeled = false ;

	// % protected region % [Modify attribute annotation for Equipment Problems Addressed here] off begin
	@CsvBindByName(column = "EQUIPMENT_PROBLEMS_ADDRESSED", required = false)
	@Nullable
	@Column(name = "equipment_problems_addressed")
	@Schema(description = "The Equipment Problems Addressed of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Equipment Problems Addressed here] end
	private Boolean equipmentProblemsAddressed = false ;

	// % protected region % [Modify attribute annotation for Key Concerns For Recovery here] off begin
	@CsvBindByName(column = "KEY_CONCERNS_FOR_RECOVERY", required = false)
	@Nullable
	@Column(name = "key_concerns_for_recovery")
	@Schema(description = "The Key Concerns For Recovery of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Key Concerns For Recovery here] end
	private Boolean keyConcernsForRecovery = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Intraoperative Records here] off begin
	@Schema(description = "The Intraoperative Records entities that are related to this entity.")
	@OneToOne(mappedBy = "operatingTheaterMedicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Intraoperative Records here] end
	private IntraoperativeRecordsEntity intraoperativeRecords;

	// % protected region % [Update the annotation for intraoperativeRecordsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INTRAOPERATIVE_RECORDS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for intraoperativeRecordsId here] end
	private UUID intraoperativeRecordsId;

	// % protected region % [Update the annotation for Post Operative Details here] off begin
	@Schema(description = "The Post Operative Details entities that are related to this entity.")
	@OneToOne(mappedBy = "operatingTheaterMedicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Post Operative Details here] end
	private PostOperativeDetailsEntity postOperativeDetails;

	// % protected region % [Update the annotation for postOperativeDetailsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "POST_OPERATIVE_DETAILS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for postOperativeDetailsId here] end
	private UUID postOperativeDetailsId;

	// % protected region % [Update the annotation for Preoperative Records here] off begin
	@Schema(description = "The Preoperative Records entities that are related to this entity.")
	@OneToOne(mappedBy = "operatingTheaterMedicalExaminationRecord", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Preoperative Records here] end
	private PreoperativeRecordsEntity preoperativeRecords;

	// % protected region % [Update the annotation for preoperativeRecordsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PREOPERATIVE_RECORDS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for preoperativeRecordsId here] end
	private UUID preoperativeRecordsId;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Nursing Anesthesia Detail here] off begin
	@Schema(description = "The Nursing Anesthesia Detail entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nursing Anesthesia Detail here] end
	private DiagnosisNandaEntity nursingAnesthesiaDetail;

	// % protected region % [Update the annotation for nursingAnesthesiaDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSING_ANESTHESIA_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for nursingAnesthesiaDetailId here] end
	private UUID nursingAnesthesiaDetailId;

	// % protected region % [Update the annotation for Nursing Detail Surgical Nursings here] off begin
	@Schema(description = "The Nursing Detail Surgical Nursings entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nursing Detail Surgical Nursings here] end
	private StaffEntity nursingDetailSurgicalNursings;

	// % protected region % [Update the annotation for nursingDetailSurgicalNursingsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSING_DETAIL_SURGICAL_NURSINGS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for nursingDetailSurgicalNursingsId here] end
	private UUID nursingDetailSurgicalNursingsId;

	// % protected region % [Update the annotation for Nursing Details Anesthesia Nursings here] off begin
	@Schema(description = "The Nursing Details Anesthesia Nursings entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nursing Details Anesthesia Nursings here] end
	private StaffEntity nursingDetailsAnesthesiaNursings;

	// % protected region % [Update the annotation for nursingDetailsAnesthesiaNursingsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSING_DETAILS_ANESTHESIA_NURSINGS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for nursingDetailsAnesthesiaNursingsId here] end
	private UUID nursingDetailsAnesthesiaNursingsId;

	// % protected region % [Update the annotation for Nursing Surgical Detail here] off begin
	@Schema(description = "The Nursing Surgical Detail entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Nursing Surgical Detail here] end
	private DiagnosisNandaEntity nursingSurgicalDetail;

	// % protected region % [Update the annotation for nursingSurgicalDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "NURSING_SURGICAL_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for nursingSurgicalDetailId here] end
	private UUID nursingSurgicalDetailId;

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

	/**
	 * Similar to {@link this#setIntraoperativeRecords(IntraoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setIntraoperativeRecords(@NotNull IntraoperativeRecordsEntity entity) {
		setIntraoperativeRecords(entity, true);
	}

	/**
	 * Set or update intraoperativeRecords with the given IntraoperativeRecordsEntity.
	 *
	 * @param entity the OperatingTheaterMedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIntraoperativeRecords(@NotNull IntraoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setIntraoperativeRecords here] off begin
		// % protected region % [Add any additional logic here before the main logic for setIntraoperativeRecords here] end

		if (sameAsFormer(this.intraoperativeRecords, entity)) {
			return;
		}

		if (this.intraoperativeRecords != null) {
			this.intraoperativeRecords.unsetOperatingTheaterMedicalExaminationRecord();
		}

		this.intraoperativeRecords = entity;

		if (reverseAdd) {
			this.intraoperativeRecords.setOperatingTheaterMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setIntraoperativeRecords outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setIntraoperativeRecords outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetIntraoperativeRecords(boolean)} but default to true.
	 */
	public void unsetIntraoperativeRecords() {
		this.unsetIntraoperativeRecords(true);
	}

	/**
	 * Remove the IntraoperativeRecordsEntity in Intraoperative Records from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetIntraoperativeRecords(boolean reverse) {
		if (reverse && this.intraoperativeRecords != null) {
			this.intraoperativeRecords.unsetOperatingTheaterMedicalExaminationRecord(false);
		}
		this.intraoperativeRecords = null;
	}

	/**
	 * Similar to {@link this#setPostOperativeDetails(PostOperativeDetailsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setPostOperativeDetails(@NotNull PostOperativeDetailsEntity entity) {
		setPostOperativeDetails(entity, true);
	}

	/**
	 * Set or update postOperativeDetails with the given PostOperativeDetailsEntity.
	 *
	 * @param entity the OperatingTheaterMedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPostOperativeDetails(@NotNull PostOperativeDetailsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeDetails here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeDetails here] end

		if (sameAsFormer(this.postOperativeDetails, entity)) {
			return;
		}

		if (this.postOperativeDetails != null) {
			this.postOperativeDetails.unsetOperatingTheaterMedicalExaminationRecord();
		}

		this.postOperativeDetails = entity;

		if (reverseAdd) {
			this.postOperativeDetails.setOperatingTheaterMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPostOperativeDetails outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPostOperativeDetails outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPostOperativeDetails(boolean)} but default to true.
	 */
	public void unsetPostOperativeDetails() {
		this.unsetPostOperativeDetails(true);
	}

	/**
	 * Remove the PostOperativeDetailsEntity in Post Operative Details from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPostOperativeDetails(boolean reverse) {
		if (reverse && this.postOperativeDetails != null) {
			this.postOperativeDetails.unsetOperatingTheaterMedicalExaminationRecord(false);
		}
		this.postOperativeDetails = null;
	}

	/**
	 * Similar to {@link this#setPreoperativeRecords(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setPreoperativeRecords(@NotNull PreoperativeRecordsEntity entity) {
		setPreoperativeRecords(entity, true);
	}

	/**
	 * Set or update preoperativeRecords with the given PreoperativeRecordsEntity.
	 *
	 * @param entity the OperatingTheaterMedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreoperativeRecords(@NotNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRecords here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRecords here] end

		if (sameAsFormer(this.preoperativeRecords, entity)) {
			return;
		}

		if (this.preoperativeRecords != null) {
			this.preoperativeRecords.unsetOperatingTheaterMedicalExaminationRecord();
		}

		this.preoperativeRecords = entity;

		if (reverseAdd) {
			this.preoperativeRecords.setOperatingTheaterMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRecords outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRecords outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPreoperativeRecords(boolean)} but default to true.
	 */
	public void unsetPreoperativeRecords() {
		this.unsetPreoperativeRecords(true);
	}

	/**
	 * Remove the PreoperativeRecordsEntity in Preoperative Records from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPreoperativeRecords(boolean reverse) {
		if (reverse && this.preoperativeRecords != null) {
			this.preoperativeRecords.unsetOperatingTheaterMedicalExaminationRecord(false);
		}
		this.preoperativeRecords = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setNursingAnesthesiaDetail(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set to this entity
	 */
	public void setNursingAnesthesiaDetail(@NotNull DiagnosisNandaEntity entity) {
		setNursingAnesthesiaDetail(entity, true);
	}

	/**
	 * Set or update the nursingAnesthesiaDetail in this entity with single DiagnosisNandaEntity.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set or updated to nursingAnesthesiaDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNursingAnesthesiaDetail(@NotNull DiagnosisNandaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNursingAnesthesiaDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNursingAnesthesiaDetail here] end

		if (sameAsFormer(this.nursingAnesthesiaDetail, entity)) {
			return;
		}

		if (this.nursingAnesthesiaDetail != null) {
			this.nursingAnesthesiaDetail.removeNursingAnesthesiaDetail(this, false);
		}
		this.nursingAnesthesiaDetail = entity;
		if (reverseAdd) {
			this.nursingAnesthesiaDetail.addNursingAnesthesiaDetail(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNursingAnesthesiaDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNursingAnesthesiaDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNursingAnesthesiaDetail(boolean)} but default to true.
	 */
	public void unsetNursingAnesthesiaDetail() {
		this.unsetNursingAnesthesiaDetail(true);
	}

	/**
	 * Remove Nursing Anesthesia Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNursingAnesthesiaDetail(boolean reverse) {
		if (reverse && this.nursingAnesthesiaDetail != null) {
			this.nursingAnesthesiaDetail.removeNursingAnesthesiaDetail(this, false);
		}
		this.nursingAnesthesiaDetail = null;
	}
	/**
	 * Similar to {@link this#setNursingDetailSurgicalNursings(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setNursingDetailSurgicalNursings(@NotNull StaffEntity entity) {
		setNursingDetailSurgicalNursings(entity, true);
	}

	/**
	 * Set or update the nursingDetailSurgicalNursings in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to nursingDetailSurgicalNursings
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNursingDetailSurgicalNursings(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNursingDetailSurgicalNursings here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNursingDetailSurgicalNursings here] end

		if (sameAsFormer(this.nursingDetailSurgicalNursings, entity)) {
			return;
		}

		if (this.nursingDetailSurgicalNursings != null) {
			this.nursingDetailSurgicalNursings.removeNursingDetailSurgicalNursing(this, false);
		}
		this.nursingDetailSurgicalNursings = entity;
		if (reverseAdd) {
			this.nursingDetailSurgicalNursings.addNursingDetailSurgicalNursing(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNursingDetailSurgicalNursings incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNursingDetailSurgicalNursings incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNursingDetailSurgicalNursings(boolean)} but default to true.
	 */
	public void unsetNursingDetailSurgicalNursings() {
		this.unsetNursingDetailSurgicalNursings(true);
	}

	/**
	 * Remove Nursing Detail Surgical Nursings in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNursingDetailSurgicalNursings(boolean reverse) {
		if (reverse && this.nursingDetailSurgicalNursings != null) {
			this.nursingDetailSurgicalNursings.removeNursingDetailSurgicalNursing(this, false);
		}
		this.nursingDetailSurgicalNursings = null;
	}
	/**
	 * Similar to {@link this#setNursingDetailsAnesthesiaNursings(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setNursingDetailsAnesthesiaNursings(@NotNull StaffEntity entity) {
		setNursingDetailsAnesthesiaNursings(entity, true);
	}

	/**
	 * Set or update the nursingDetailsAnesthesiaNursings in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to nursingDetailsAnesthesiaNursings
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNursingDetailsAnesthesiaNursings(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNursingDetailsAnesthesiaNursings here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNursingDetailsAnesthesiaNursings here] end

		if (sameAsFormer(this.nursingDetailsAnesthesiaNursings, entity)) {
			return;
		}

		if (this.nursingDetailsAnesthesiaNursings != null) {
			this.nursingDetailsAnesthesiaNursings.removeNursingDetailsAnesthesiaNursing(this, false);
		}
		this.nursingDetailsAnesthesiaNursings = entity;
		if (reverseAdd) {
			this.nursingDetailsAnesthesiaNursings.addNursingDetailsAnesthesiaNursing(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNursingDetailsAnesthesiaNursings incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNursingDetailsAnesthesiaNursings incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNursingDetailsAnesthesiaNursings(boolean)} but default to true.
	 */
	public void unsetNursingDetailsAnesthesiaNursings() {
		this.unsetNursingDetailsAnesthesiaNursings(true);
	}

	/**
	 * Remove Nursing Details Anesthesia Nursings in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNursingDetailsAnesthesiaNursings(boolean reverse) {
		if (reverse && this.nursingDetailsAnesthesiaNursings != null) {
			this.nursingDetailsAnesthesiaNursings.removeNursingDetailsAnesthesiaNursing(this, false);
		}
		this.nursingDetailsAnesthesiaNursings = null;
	}
	/**
	 * Similar to {@link this#setNursingSurgicalDetail(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set to this entity
	 */
	public void setNursingSurgicalDetail(@NotNull DiagnosisNandaEntity entity) {
		setNursingSurgicalDetail(entity, true);
	}

	/**
	 * Set or update the nursingSurgicalDetail in this entity with single DiagnosisNandaEntity.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set or updated to nursingSurgicalDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNursingSurgicalDetail(@NotNull DiagnosisNandaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNursingSurgicalDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNursingSurgicalDetail here] end

		if (sameAsFormer(this.nursingSurgicalDetail, entity)) {
			return;
		}

		if (this.nursingSurgicalDetail != null) {
			this.nursingSurgicalDetail.removeNursingSurgicalDetail(this, false);
		}
		this.nursingSurgicalDetail = entity;
		if (reverseAdd) {
			this.nursingSurgicalDetail.addNursingSurgicalDetail(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNursingSurgicalDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNursingSurgicalDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNursingSurgicalDetail(boolean)} but default to true.
	 */
	public void unsetNursingSurgicalDetail() {
		this.unsetNursingSurgicalDetail(true);
	}

	/**
	 * Remove Nursing Surgical Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNursingSurgicalDetail(boolean reverse) {
		if (reverse && this.nursingSurgicalDetail != null) {
			this.nursingSurgicalDetail.removeNursingSurgicalDetail(this, false);
		}
		this.nursingSurgicalDetail = null;
	}
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
			this.medicalExaminationRecord.unsetOperatingTheaterMedicalExaminationRecord(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setOperatingTheaterMedicalExaminationRecord(this, false);
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
			this.medicalExaminationRecord.unsetOperatingTheaterMedicalExaminationRecord();
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
		return "HAS_CONFIRMED_IDENTITY,ANESTHESIA_SAFETY_CHECK_COMPLETED,PULSE_OXYMETER_FUNCTIONING,SITE_MARKED,HAS_KNOWN_ALLERGY,HAS_DIFFICULT_AIRWAY_RISK,HAS_RISK_OF_BLOOD_LOSS,TEAM_MEMBER_INTRODUCED,PROFESSIONAL_CONFIRMED_PATIENT,ANTIBIOTIC_PROPHYLAXIS_GIVEN,ESSENTIAL_IMAGING_DISPLAYED,WHARE_ARE_CRITICAL_STEPS,HOW_LONG_CASE_TAKE,WHAT_IS_ANTICIPATED_BLOOD_LOSS,ANY_PATIENT_SPECIFIC_CONCERNS,STERLITY_BEEN_CONFIRMED,EQUIPMENT_ISSUES_ANY_CONCERN,NAME_OF_PROCEDURE,INSTRUMENTS_NEED_COUNT_CORRECT,SPECIMEN_IS_LABELED,EQUIPMENT_PROBLEMS_ADDRESSED,KEY_CONCERNS_FOR_RECOVERY,NURSING_ANESTHESIA_DETAIL_ID,NURSING_DETAIL_SURGICAL_NURSINGS_ID,NURSING_DETAILS_ANESTHESIA_NURSINGS_ID,NURSING_SURGICAL_DETAIL_ID,MEDICAL_EXAMINATION_RECORD_ID,INTRAOPERATIVE_RECORDS_ID,POST_OPERATIVE_DETAILS_ID,PREOPERATIVE_RECORDS_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<DiagnosisNandaEntity> nursingAnesthesiaDetailRelation = Optional.ofNullable(this.nursingAnesthesiaDetail);
		nursingAnesthesiaDetailRelation.ifPresent(entity -> this.nursingAnesthesiaDetailId = entity.getId());

		Optional<StaffEntity> nursingDetailSurgicalNursingsRelation = Optional.ofNullable(this.nursingDetailSurgicalNursings);
		nursingDetailSurgicalNursingsRelation.ifPresent(entity -> this.nursingDetailSurgicalNursingsId = entity.getId());

		Optional<StaffEntity> nursingDetailsAnesthesiaNursingsRelation = Optional.ofNullable(this.nursingDetailsAnesthesiaNursings);
		nursingDetailsAnesthesiaNursingsRelation.ifPresent(entity -> this.nursingDetailsAnesthesiaNursingsId = entity.getId());

		Optional<DiagnosisNandaEntity> nursingSurgicalDetailRelation = Optional.ofNullable(this.nursingSurgicalDetail);
		nursingSurgicalDetailRelation.ifPresent(entity -> this.nursingSurgicalDetailId = entity.getId());

		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		Optional<IntraoperativeRecordsEntity> intraoperativeRecordsRelation = Optional.ofNullable(this.intraoperativeRecords);
		intraoperativeRecordsRelation.ifPresent(entity -> this.intraoperativeRecordsId = entity.getId());

		Optional<PostOperativeDetailsEntity> postOperativeDetailsRelation = Optional.ofNullable(this.postOperativeDetails);
		postOperativeDetailsRelation.ifPresent(entity -> this.postOperativeDetailsId = entity.getId());

		Optional<PreoperativeRecordsEntity> preoperativeRecordsRelation = Optional.ofNullable(this.preoperativeRecords);
		preoperativeRecordsRelation.ifPresent(entity -> this.preoperativeRecordsId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object operatingTheaterMedicalExaminationRecord) {
		if (this == operatingTheaterMedicalExaminationRecord) {
			return true;
		}
		if (operatingTheaterMedicalExaminationRecord == null || this.getClass() != operatingTheaterMedicalExaminationRecord.getClass()) {
			return false;
		}
		if (!super.equals(operatingTheaterMedicalExaminationRecord)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		OperatingTheaterMedicalExaminationRecordEntity that = (OperatingTheaterMedicalExaminationRecordEntity) operatingTheaterMedicalExaminationRecord;
		return
			Objects.equals(this.hasConfirmedIdentity, that.hasConfirmedIdentity) &&
			Objects.equals(this.anesthesiaSafetyCheckCompleted, that.anesthesiaSafetyCheckCompleted) &&
			Objects.equals(this.pulseOxymeterFunctioning, that.pulseOxymeterFunctioning) &&
			Objects.equals(this.siteMarked, that.siteMarked) &&
			Objects.equals(this.hasKnownAllergy, that.hasKnownAllergy) &&
			Objects.equals(this.hasDifficultAirwayRisk, that.hasDifficultAirwayRisk) &&
			Objects.equals(this.hasRiskOfBloodLoss, that.hasRiskOfBloodLoss) &&
			Objects.equals(this.teamMemberIntroduced, that.teamMemberIntroduced) &&
			Objects.equals(this.professionalConfirmedPatient, that.professionalConfirmedPatient) &&
			Objects.equals(this.antibioticProphylaxisGiven, that.antibioticProphylaxisGiven) &&
			Objects.equals(this.essentialImagingDisplayed, that.essentialImagingDisplayed) &&
			Objects.equals(this.whareAreCriticalSteps, that.whareAreCriticalSteps) &&
			Objects.equals(this.howLongCaseTake, that.howLongCaseTake) &&
			Objects.equals(this.whatIsAnticipatedBloodLoss, that.whatIsAnticipatedBloodLoss) &&
			Objects.equals(this.anyPatientSpecificConcerns, that.anyPatientSpecificConcerns) &&
			Objects.equals(this.sterlityBeenConfirmed, that.sterlityBeenConfirmed) &&
			Objects.equals(this.equipmentIssuesAnyConcern, that.equipmentIssuesAnyConcern) &&
			Objects.equals(this.nameOfProcedure, that.nameOfProcedure) &&
			Objects.equals(this.instrumentsNeedCountCorrect, that.instrumentsNeedCountCorrect) &&
			Objects.equals(this.specimenIsLabeled, that.specimenIsLabeled) &&
			Objects.equals(this.equipmentProblemsAddressed, that.equipmentProblemsAddressed) &&
			Objects.equals(this.keyConcernsForRecovery, that.keyConcernsForRecovery) &&
			Objects.equals(this.intraoperativeRecordsId, that.intraoperativeRecordsId) &&
			Objects.equals(this.postOperativeDetailsId, that.postOperativeDetailsId) &&
			Objects.equals(this.preoperativeRecordsId, that.preoperativeRecordsId) &&
			Objects.equals(this.nursingAnesthesiaDetailId, that.nursingAnesthesiaDetailId) &&
			Objects.equals(this.nursingDetailSurgicalNursingsId, that.nursingDetailSurgicalNursingsId) &&
			Objects.equals(this.nursingDetailsAnesthesiaNursingsId, that.nursingDetailsAnesthesiaNursingsId) &&
			Objects.equals(this.nursingSurgicalDetailId, that.nursingSurgicalDetailId) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
