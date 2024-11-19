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
import kmsweb.dtos.PatientCaseHistoryEntityDto;
import kmsweb.entities.listeners.PatientCaseHistoryEntityListener;
import kmsweb.serializers.PatientCaseHistorySerializer;
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
@EntityListeners({PatientCaseHistoryEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientCaseHistorySerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientCaseHistoryEntity extends AbstractEntity {

	/**
	 * Takes a PatientCaseHistoryEntityDto and converts it into a PatientCaseHistoryEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientCaseHistoryEntityDto
	 */
	public PatientCaseHistoryEntity(PatientCaseHistoryEntityDto patientCaseHistoryEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientCaseHistoryEntityDto.getId() != null) {
			this.setId(patientCaseHistoryEntityDto.getId());
		}

		if (patientCaseHistoryEntityDto.getAllergy() != null) {
			this.setAllergy(patientCaseHistoryEntityDto.getAllergy());
		}

		if (patientCaseHistoryEntityDto.getDisabilityNotes() != null) {
			this.setDisabilityNotes(patientCaseHistoryEntityDto.getDisabilityNotes());
		}

		if (patientCaseHistoryEntityDto.getHistoryOfDisease() != null) {
			this.setHistoryOfDisease(patientCaseHistoryEntityDto.getHistoryOfDisease());
		}

		if (patientCaseHistoryEntityDto.getCaseHistoryDateTime() != null) {
			this.setCaseHistoryDateTime(patientCaseHistoryEntityDto.getCaseHistoryDateTime());
		}

		if (patientCaseHistoryEntityDto.getPatientHabits() != null) {
			this.setPatientHabits(patientCaseHistoryEntityDto.getPatientHabits());
		}

		if (patientCaseHistoryEntityDto.getNutritionHIstory() != null) {
			this.setNutritionHIstory(patientCaseHistoryEntityDto.getNutritionHIstory());
		}

		if (patientCaseHistoryEntityDto.getFamilyHistory() != null) {
			this.setFamilyHistory(patientCaseHistoryEntityDto.getFamilyHistory());
		}

		if (patientCaseHistoryEntityDto.getPatientGeneralInformation() != null) {
			this.setPatientGeneralInformation(patientCaseHistoryEntityDto.getPatientGeneralInformation());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Allergy here] off begin
	@CsvBindByName(column = "ALLERGY", required = false)
	@Nullable
	@Column(name = "allergy")
	@Schema(description = "The Allergy of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Allergy here] end
	private String allergy;

	// % protected region % [Modify attribute annotation for Disability Notes here] off begin
	@CsvBindByName(column = "DISABILITY_NOTES", required = false)
	@Nullable
	@Column(name = "disability_notes")
	@Schema(description = "The Disability Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Disability Notes here] end
	private String disabilityNotes;

	// % protected region % [Modify attribute annotation for History of Disease here] off begin
	@CsvBindByName(column = "HISTORY_OF_DISEASE", required = false)
	@Nullable
	@Column(name = "history_of_disease")
	@Schema(description = "The History of Disease of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for History of Disease here] end
	private String historyOfDisease;

	// % protected region % [Modify attribute annotation for Case History Date Time here] off begin

	@CsvCustomBindByName(column = "CASE_HISTORY_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "case_history_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Case History Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Case History Date Time here] end
	private OffsetDateTime caseHistoryDateTime;

	// % protected region % [Modify attribute annotation for Patient Habits here] off begin
	@CsvBindByName(column = "PATIENT_HABITS", required = false)
	@Nullable
	@Column(name = "patient_habits")
	@Schema(description = "The Patient Habits of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Habits here] end
	private String patientHabits;

	// % protected region % [Modify attribute annotation for Nutrition HIstory here] off begin
	@CsvBindByName(column = "NUTRITION_HISTORY", required = false)
	@Nullable
	@Column(name = "nutrition_history")
	@Schema(description = "The Nutrition HIstory of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nutrition HIstory here] end
	private String nutritionHIstory;

	// % protected region % [Modify attribute annotation for Family History here] off begin
	@CsvBindByName(column = "FAMILY_HISTORY", required = false)
	@Nullable
	@Column(name = "family_history")
	@Schema(description = "The Family History of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Family History here] end
	private String familyHistory;

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

	// % protected region % [Update the annotation for Patient General Information here] off begin
	@Schema(description = "The Patient General Information entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient General Information here] end
	private PatientGeneralInfoEntity patientGeneralInformation;

	// % protected region % [Update the annotation for patientGeneralInformationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_GENERAL_INFORMATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientGeneralInformationId here] end
	private UUID patientGeneralInformationId;

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
	 * Similar to {@link this#setPatientGeneralInformation(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInformation(@NotNull PatientGeneralInfoEntity entity) {
		setPatientGeneralInformation(entity, true);
	}

	/**
	 * Set or update the patientGeneralInformation in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInformation(@NotNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] end

		if (sameAsFormer(this.patientGeneralInformation, entity)) {
			return;
		}

		if (this.patientGeneralInformation != null) {
			this.patientGeneralInformation.removePatientCaseHistories(this, false);
		}
		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.addPatientCaseHistories(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInformation(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInformation() {
		this.unsetPatientGeneralInformation(true);
	}

	/**
	 * Remove Patient General Information in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInformation(boolean reverse) {
		if (reverse && this.patientGeneralInformation != null) {
			this.patientGeneralInformation.removePatientCaseHistories(this, false);
		}
		this.patientGeneralInformation = null;
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
		return "ALLERGY,DISABILITY_NOTES,HISTORY_OF_DISEASE,CASE_HISTORY_DATE_TIME,PATIENT_HABITS,NUTRITION_HISTORY,FAMILY_HISTORY,PATIENT_GENERAL_INFORMATION_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<PatientGeneralInfoEntity> patientGeneralInformationRelation = Optional.ofNullable(this.patientGeneralInformation);
		patientGeneralInformationRelation.ifPresent(entity -> this.patientGeneralInformationId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientCaseHistory) {
		if (this == patientCaseHistory) {
			return true;
		}
		if (patientCaseHistory == null || this.getClass() != patientCaseHistory.getClass()) {
			return false;
		}
		if (!super.equals(patientCaseHistory)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientCaseHistoryEntity that = (PatientCaseHistoryEntity) patientCaseHistory;
		return
			Objects.equals(this.allergy, that.allergy) &&
			Objects.equals(this.disabilityNotes, that.disabilityNotes) &&
			Objects.equals(this.historyOfDisease, that.historyOfDisease) &&
			Objects.equals(
			     this.caseHistoryDateTime != null ? this.caseHistoryDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.caseHistoryDateTime != null ? that.caseHistoryDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.patientHabits, that.patientHabits) &&
			Objects.equals(this.nutritionHIstory, that.nutritionHIstory) &&
			Objects.equals(this.familyHistory, that.familyHistory) &&
			Objects.equals(this.patientGeneralInformationId, that.patientGeneralInformationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
