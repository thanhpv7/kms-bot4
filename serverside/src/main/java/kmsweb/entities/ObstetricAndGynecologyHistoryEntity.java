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
import kmsweb.dtos.ObstetricAndGynecologyHistoryEntityDto;
import kmsweb.entities.listeners.ObstetricAndGynecologyHistoryEntityListener;
import kmsweb.serializers.ObstetricAndGynecologyHistorySerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.time.*;
import java.time.temporal.ChronoUnit;
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
@EntityListeners({ObstetricAndGynecologyHistoryEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ObstetricAndGynecologyHistorySerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class ObstetricAndGynecologyHistoryEntity extends AbstractEntity {

	/**
	 * Takes a ObstetricAndGynecologyHistoryEntityDto and converts it into a ObstetricAndGynecologyHistoryEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param obstetricAndGynecologyHistoryEntityDto
	 */
	public ObstetricAndGynecologyHistoryEntity(ObstetricAndGynecologyHistoryEntityDto obstetricAndGynecologyHistoryEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (obstetricAndGynecologyHistoryEntityDto.getId() != null) {
			this.setId(obstetricAndGynecologyHistoryEntityDto.getId());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getPregnancyHistoryGravida() != null) {
			this.setPregnancyHistoryGravida(obstetricAndGynecologyHistoryEntityDto.getPregnancyHistoryGravida());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getPatientHistoryPara() != null) {
			this.setPatientHistoryPara(obstetricAndGynecologyHistoryEntityDto.getPatientHistoryPara());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getPatientHistoryAbortus() != null) {
			this.setPatientHistoryAbortus(obstetricAndGynecologyHistoryEntityDto.getPatientHistoryAbortus());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getPregnancyHistoryNotes() != null) {
			this.setPregnancyHistoryNotes(obstetricAndGynecologyHistoryEntityDto.getPregnancyHistoryNotes());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getAgeOfMenarche() != null) {
			this.setAgeOfMenarche(obstetricAndGynecologyHistoryEntityDto.getAgeOfMenarche());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getAgeOfFirstSexualContact() != null) {
			this.setAgeOfFirstSexualContact(obstetricAndGynecologyHistoryEntityDto.getAgeOfFirstSexualContact());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getStartDate() != null) {
			this.setStartDate(obstetricAndGynecologyHistoryEntityDto.getStartDate());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getEndDate() != null) {
			this.setEndDate(obstetricAndGynecologyHistoryEntityDto.getEndDate());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getApproximateBirthDate() != null) {
			this.setApproximateBirthDate(obstetricAndGynecologyHistoryEntityDto.getApproximateBirthDate());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getGestationAgeWeeks() != null) {
			this.setGestationAgeWeeks(obstetricAndGynecologyHistoryEntityDto.getGestationAgeWeeks());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getGestationAgeDays() != null) {
			this.setGestationAgeDays(obstetricAndGynecologyHistoryEntityDto.getGestationAgeDays());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getMaternityHistory() != null) {
			this.setMaternityHistory(obstetricAndGynecologyHistoryEntityDto.getMaternityHistory());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getGynecologyHistory() != null) {
			this.setGynecologyHistory(obstetricAndGynecologyHistoryEntityDto.getGynecologyHistory());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getFamilyPlanHistory() != null) {
			this.setFamilyPlanHistory(obstetricAndGynecologyHistoryEntityDto.getFamilyPlanHistory());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getOtherNotes() != null) {
			this.setOtherNotes(obstetricAndGynecologyHistoryEntityDto.getOtherNotes());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getEducationLevelOfPatient() != null) {
			this.setEducationLevelOfPatient(obstetricAndGynecologyHistoryEntityDto.getEducationLevelOfPatient());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getNameOfHusbandOrWife() != null) {
			this.setNameOfHusbandOrWife(obstetricAndGynecologyHistoryEntityDto.getNameOfHusbandOrWife());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getEducationLevelOfHusbandOrWife() != null) {
			this.setEducationLevelOfHusbandOrWife(obstetricAndGynecologyHistoryEntityDto.getEducationLevelOfHusbandOrWife());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getOccupationOfHusbandOrWife() != null) {
			this.setOccupationOfHusbandOrWife(obstetricAndGynecologyHistoryEntityDto.getOccupationOfHusbandOrWife());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getRuptureOfMembrane() != null) {
			this.setRuptureOfMembrane(obstetricAndGynecologyHistoryEntityDto.getRuptureOfMembrane());
		}

		if (obstetricAndGynecologyHistoryEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(obstetricAndGynecologyHistoryEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Pregnancy History Gravida here] off begin
	@CsvBindByName(column = "PREGNANCY_HISTORY_GRAVIDA", required = false)
	@Nullable
	@Column(name = "pregnancy_history_gravida")
	@Schema(description = "The Pregnancy History Gravida of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pregnancy History Gravida here] end
	private String pregnancyHistoryGravida;

	// % protected region % [Modify attribute annotation for Patient History Para here] off begin
	@CsvBindByName(column = "PATIENT_HISTORY_PARA", required = false)
	@Nullable
	@Column(name = "patient_history_para")
	@Schema(description = "The Patient History Para of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient History Para here] end
	private String patientHistoryPara;

	// % protected region % [Modify attribute annotation for Patient History Abortus here] off begin
	@CsvBindByName(column = "PATIENT_HISTORY_ABORTUS", required = false)
	@Nullable
	@Column(name = "patient_history_abortus")
	@Schema(description = "The Patient History Abortus of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient History Abortus here] end
	private String patientHistoryAbortus;

	// % protected region % [Modify attribute annotation for Pregnancy History Notes here] off begin
	@CsvBindByName(column = "PREGNANCY_HISTORY_NOTES", required = false)
	@Nullable
	@Column(name = "pregnancy_history_notes")
	@Schema(description = "The Pregnancy History Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pregnancy History Notes here] end
	private String pregnancyHistoryNotes;

	// % protected region % [Modify attribute annotation for Age of Menarche here] off begin
	@CsvBindByName(column = "AGE_OF_MENARCHE", required = false)
	@Nullable
	@Column(name = "age_of_menarche")
	@Schema(description = "The Age of Menarche of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Age of Menarche here] end
	private String ageOfMenarche;

	// % protected region % [Modify attribute annotation for Age of First Sexual Contact here] off begin
	@CsvBindByName(column = "AGE_OF_FIRST_SEXUAL_CONTACT", required = false)
	@Nullable
	@Column(name = "age_of_first_sexual_contact")
	@Schema(description = "The Age of First Sexual Contact of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Age of First Sexual Contact here] end
	private String ageOfFirstSexualContact;

	// % protected region % [Modify attribute annotation for Start Date here] off begin
	@CsvCustomBindByName(column = "START_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "start_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Start Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Start Date here] end
	private OffsetDateTime startDate;

	// % protected region % [Modify attribute annotation for End Date here] off begin
	@CsvCustomBindByName(column = "END_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "end_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The End Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for End Date here] end
	private OffsetDateTime endDate;

	// % protected region % [Modify attribute annotation for Approximate Birth Date here] off begin
	@CsvCustomBindByName(column = "APPROXIMATE_BIRTH_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "approximate_birth_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Approximate Birth Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approximate Birth Date here] end
	private OffsetDateTime approximateBirthDate;

	// % protected region % [Modify attribute annotation for Gestation Age Weeks here] off begin
	@CsvBindByName(column = "GESTATION_AGE_WEEKS", required = false)
	@Nullable
	@Column(name = "gestation_age_weeks")
	@Schema(description = "The Gestation Age Weeks of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gestation Age Weeks here] end
	private String gestationAgeWeeks;

	// % protected region % [Modify attribute annotation for Gestation Age Days here] off begin
	@CsvBindByName(column = "GESTATION_AGE_DAYS", required = false)
	@Nullable
	@Column(name = "gestation_age_days")
	@Schema(description = "The Gestation Age Days of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gestation Age Days here] end
	private String gestationAgeDays;

	// % protected region % [Modify attribute annotation for Maternity History here] off begin
	@CsvBindByName(column = "MATERNITY_HISTORY", required = false)
	@Nullable
	@Column(name = "maternity_history")
	@Schema(description = "The Maternity History of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Maternity History here] end
	private String maternityHistory;

	// % protected region % [Modify attribute annotation for Gynecology History here] off begin
	@CsvBindByName(column = "GYNECOLOGY_HISTORY", required = false)
	@Nullable
	@Column(name = "gynecology_history")
	@Schema(description = "The Gynecology History of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gynecology History here] end
	private String gynecologyHistory;

	// % protected region % [Modify attribute annotation for Family Plan History here] off begin
	@CsvBindByName(column = "FAMILY_PLAN_HISTORY", required = false)
	@Nullable
	@Column(name = "family_plan_history")
	@Schema(description = "The Family Plan History of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Family Plan History here] end
	private String familyPlanHistory;

	// % protected region % [Modify attribute annotation for Other Notes here] off begin
	@CsvBindByName(column = "OTHER_NOTES", required = false)
	@Nullable
	@Column(name = "other_notes")
	@Schema(description = "The Other Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Notes here] end
	private String otherNotes;

	// % protected region % [Modify attribute annotation for Education Level of Patient here] off begin
	@CsvBindByName(column = "EDUCATION_LEVEL_OF_PATIENT", required = false)
	@Nullable
	@Column(name = "education_level_of_patient")
	@Schema(description = "The Education Level of Patient of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Education Level of Patient here] end
	private String educationLevelOfPatient;

	// % protected region % [Modify attribute annotation for Name of Husband or Wife here] off begin
	@CsvBindByName(column = "NAME_OF_HUSBAND_OR_WIFE", required = false)
	@Nullable
	@Column(name = "name_of_husband_or_wife")
	@Schema(description = "The Name of Husband or Wife of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name of Husband or Wife here] end
	private String nameOfHusbandOrWife;

	// % protected region % [Modify attribute annotation for Education Level of Husband or Wife here] off begin
	@CsvBindByName(column = "EDUCATION_LEVEL_OF_HUSBAND_OR_WIFE", required = false)
	@Nullable
	@Column(name = "education_level_of_husband_or_wife")
	@Schema(description = "The Education Level of Husband or Wife of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Education Level of Husband or Wife here] end
	private String educationLevelOfHusbandOrWife;

	// % protected region % [Modify attribute annotation for Occupation of Husband or Wife here] off begin
	@CsvBindByName(column = "OCCUPATION_OF_HUSBAND_OR_WIFE", required = false)
	@Nullable
	@Column(name = "occupation_of_husband_or_wife")
	@Schema(description = "The Occupation of Husband or Wife of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Occupation of Husband or Wife here] end
	private String occupationOfHusbandOrWife;

	// % protected region % [Modify attribute annotation for Rupture Of Membrane here] off begin
	@CsvCustomBindByName(column = "RUPTURE_OF_MEMBRANE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "rupture_of_membrane")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Rupture Of Membrane of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Rupture Of Membrane here] end
	private OffsetDateTime ruptureOfMembrane;

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
			this.medicalExaminationRecord.unsetObstetricAndGynecologyHistory(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setObstetricAndGynecologyHistory(this, false);
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
			this.medicalExaminationRecord.unsetObstetricAndGynecologyHistory();
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
		return "PREGNANCY_HISTORY_GRAVIDA,PATIENT_HISTORY_PARA,PATIENT_HISTORY_ABORTUS,PREGNANCY_HISTORY_NOTES,AGE_OF_MENARCHE,AGE_OF_FIRST_SEXUAL_CONTACT,START_DATE,END_DATE,APPROXIMATE_BIRTH_DATE,GESTATION_AGE_WEEKS,GESTATION_AGE_DAYS,MATERNITY_HISTORY,GYNECOLOGY_HISTORY,FAMILY_PLAN_HISTORY,OTHER_NOTES,EDUCATION_LEVEL_OF_PATIENT,NAME_OF_HUSBAND_OR_WIFE,EDUCATION_LEVEL_OF_HUSBAND_OR_WIFE,OCCUPATION_OF_HUSBAND_OR_WIFE,RUPTURE_OF_MEMBRANE,MEDICAL_EXAMINATION_RECORD_ID,ID";
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
	public boolean equals(Object obstetricAndGynecologyHistory) {
		if (this == obstetricAndGynecologyHistory) {
			return true;
		}
		if (obstetricAndGynecologyHistory == null || this.getClass() != obstetricAndGynecologyHistory.getClass()) {
			return false;
		}
		if (!super.equals(obstetricAndGynecologyHistory)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ObstetricAndGynecologyHistoryEntity that = (ObstetricAndGynecologyHistoryEntity) obstetricAndGynecologyHistory;
		return
			Objects.equals(this.pregnancyHistoryGravida, that.pregnancyHistoryGravida) &&
			Objects.equals(this.patientHistoryPara, that.patientHistoryPara) &&
			Objects.equals(this.patientHistoryAbortus, that.patientHistoryAbortus) &&
			Objects.equals(this.pregnancyHistoryNotes, that.pregnancyHistoryNotes) &&
			Objects.equals(this.ageOfMenarche, that.ageOfMenarche) &&
			Objects.equals(this.ageOfFirstSexualContact, that.ageOfFirstSexualContact) &&
			Objects.equals(
			     this.startDate != null ? this.startDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.startDate != null ? that.startDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.endDate != null ? this.endDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.endDate != null ? that.endDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.approximateBirthDate != null ? this.approximateBirthDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.approximateBirthDate != null ? that.approximateBirthDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.gestationAgeWeeks, that.gestationAgeWeeks) &&
			Objects.equals(this.gestationAgeDays, that.gestationAgeDays) &&
			Objects.equals(this.maternityHistory, that.maternityHistory) &&
			Objects.equals(this.gynecologyHistory, that.gynecologyHistory) &&
			Objects.equals(this.familyPlanHistory, that.familyPlanHistory) &&
			Objects.equals(this.otherNotes, that.otherNotes) &&
			Objects.equals(this.educationLevelOfPatient, that.educationLevelOfPatient) &&
			Objects.equals(this.nameOfHusbandOrWife, that.nameOfHusbandOrWife) &&
			Objects.equals(this.educationLevelOfHusbandOrWife, that.educationLevelOfHusbandOrWife) &&
			Objects.equals(this.occupationOfHusbandOrWife, that.occupationOfHusbandOrWife) &&
			Objects.equals(
			     this.ruptureOfMembrane != null ? this.ruptureOfMembrane.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.ruptureOfMembrane != null ? that.ruptureOfMembrane.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
