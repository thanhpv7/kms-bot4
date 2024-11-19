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
import kmsweb.dtos.EmergencyMedicalExaminationRecordEntityDto;
import kmsweb.entities.listeners.EmergencyMedicalExaminationRecordEntityListener;
import kmsweb.serializers.EmergencyMedicalExaminationRecordSerializer;
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
@EntityListeners({EmergencyMedicalExaminationRecordEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = EmergencyMedicalExaminationRecordSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class EmergencyMedicalExaminationRecordEntity extends AbstractEntity {

	/**
	 * Takes a EmergencyMedicalExaminationRecordEntityDto and converts it into a EmergencyMedicalExaminationRecordEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param emergencyMedicalExaminationRecordEntityDto
	 */
	public EmergencyMedicalExaminationRecordEntity(EmergencyMedicalExaminationRecordEntityDto emergencyMedicalExaminationRecordEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (emergencyMedicalExaminationRecordEntityDto.getId() != null) {
			this.setId(emergencyMedicalExaminationRecordEntityDto.getId());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getSurgicalOrNonSurgical() != null) {
			this.setSurgicalOrNonSurgical(emergencyMedicalExaminationRecordEntityDto.getSurgicalOrNonSurgical());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getCaseSpecification() != null) {
			this.setCaseSpecification(emergencyMedicalExaminationRecordEntityDto.getCaseSpecification());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getAccidentType() != null) {
			this.setAccidentType(emergencyMedicalExaminationRecordEntityDto.getAccidentType());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getAccidentCause() != null) {
			this.setAccidentCause(emergencyMedicalExaminationRecordEntityDto.getAccidentCause());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getEmergencyLevel() != null) {
			this.setEmergencyLevel(emergencyMedicalExaminationRecordEntityDto.getEmergencyLevel());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getDateTimeOfInstructions() != null) {
			this.setDateTimeOfInstructions(emergencyMedicalExaminationRecordEntityDto.getDateTimeOfInstructions());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getIsDoctorTakingOver() != null) {
			this.setIsDoctorTakingOver(emergencyMedicalExaminationRecordEntityDto.getIsDoctorTakingOver());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getDateTimeOfDrugAdministration() != null) {
			this.setDateTimeOfDrugAdministration(emergencyMedicalExaminationRecordEntityDto.getDateTimeOfDrugAdministration());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getIsAutopay() != null) {
			this.setIsAutopay(emergencyMedicalExaminationRecordEntityDto.getIsAutopay());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getResponseTime() != null) {
			this.setResponseTime(emergencyMedicalExaminationRecordEntityDto.getResponseTime());
		}

		if (emergencyMedicalExaminationRecordEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(emergencyMedicalExaminationRecordEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Surgical Or Non Surgical here] off begin
	@CsvBindByName(column = "SURGICAL_OR_NON_SURGICAL", required = false)
	@Nullable
	@Column(name = "surgical_or_non_surgical")
	@Schema(description = "The Surgical Or Non Surgical of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Surgical Or Non Surgical here] end
	private String surgicalOrNonSurgical;

	// % protected region % [Modify attribute annotation for Case Specification here] off begin
	@CsvBindByName(column = "CASE_SPECIFICATION", required = false)
	@Nullable
	@Column(name = "case_specification")
	@Schema(description = "The Case Specification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Case Specification here] end
	private String caseSpecification;

	// % protected region % [Modify attribute annotation for Accident Type here] off begin
	@CsvBindByName(column = "ACCIDENT_TYPE", required = false)
	@Nullable
	@Column(name = "accident_type")
	@Schema(description = "The Accident Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Accident Type here] end
	private String accidentType;

	// % protected region % [Modify attribute annotation for Accident Cause here] off begin
	@CsvBindByName(column = "ACCIDENT_CAUSE", required = false)
	@Nullable
	@Column(name = "accident_cause")
	@Schema(description = "The Accident Cause of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Accident Cause here] end
	private String accidentCause;

	// % protected region % [Modify attribute annotation for Emergency Level here] off begin
	@CsvBindByName(column = "EMERGENCY_LEVEL", required = false)
	@Nullable
	@Column(name = "emergency_level")
	@Schema(description = "The Emergency Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Emergency Level here] end
	private String emergencyLevel;

	// % protected region % [Modify attribute annotation for Date Time of Instructions here] off begin

	@CsvCustomBindByName(column = "DATE_TIME_OF_INSTRUCTIONS", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date_time_of_instructions")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date Time of Instructions of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date Time of Instructions here] end
	private OffsetDateTime dateTimeOfInstructions;

	// % protected region % [Modify attribute annotation for Is Doctor Taking Over here] off begin
	@CsvBindByName(column = "IS_DOCTOR_TAKING_OVER", required = false)
	@Nullable
	@Column(name = "is_doctor_taking_over")
	@Schema(description = "The Is Doctor Taking Over of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Doctor Taking Over here] end
	private Boolean isDoctorTakingOver = false ;

	// % protected region % [Modify attribute annotation for Date Time of Drug Administration here] off begin

	@CsvCustomBindByName(column = "DATE_TIME_OF_DRUG_ADMINISTRATION", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date_time_of_drug_administration")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date Time of Drug Administration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date Time of Drug Administration here] end
	private OffsetDateTime dateTimeOfDrugAdministration;

	// % protected region % [Modify attribute annotation for Is Autopay here] off begin
	@CsvBindByName(column = "IS_AUTOPAY", required = false)
	@Nullable
	@Column(name = "is_autopay")
	@Schema(description = "The Is Autopay of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Autopay here] end
	private Boolean isAutopay = false ;

	// % protected region % [Modify attribute annotation for Response Time here] off begin
	@CsvBindByName(column = "RESPONSE_TIME", required = false)
	@Nullable
	@Column(name = "response_time")
	@Schema(description = "The Response Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Response Time here] end
	private Integer responseTime;

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
			this.medicalExaminationRecord.unsetEmergencyMedicationExaminationRecord(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setEmergencyMedicationExaminationRecord(this, false);
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
			this.medicalExaminationRecord.unsetEmergencyMedicationExaminationRecord();
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
		return "SURGICAL_OR_NON_SURGICAL,CASE_SPECIFICATION,ACCIDENT_TYPE,ACCIDENT_CAUSE,EMERGENCY_LEVEL,DATE_TIME_OF_INSTRUCTIONS,IS_DOCTOR_TAKING_OVER,DATE_TIME_OF_DRUG_ADMINISTRATION,IS_AUTOPAY,RESPONSE_TIME,MEDICAL_EXAMINATION_RECORD_ID,ID";
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
	public boolean equals(Object emergencyMedicalExaminationRecord) {
		if (this == emergencyMedicalExaminationRecord) {
			return true;
		}
		if (emergencyMedicalExaminationRecord == null || this.getClass() != emergencyMedicalExaminationRecord.getClass()) {
			return false;
		}
		if (!super.equals(emergencyMedicalExaminationRecord)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		EmergencyMedicalExaminationRecordEntity that = (EmergencyMedicalExaminationRecordEntity) emergencyMedicalExaminationRecord;
		return
			Objects.equals(this.surgicalOrNonSurgical, that.surgicalOrNonSurgical) &&
			Objects.equals(this.caseSpecification, that.caseSpecification) &&
			Objects.equals(this.accidentType, that.accidentType) &&
			Objects.equals(this.accidentCause, that.accidentCause) &&
			Objects.equals(this.emergencyLevel, that.emergencyLevel) &&
			Objects.equals(
			     this.dateTimeOfInstructions != null ? this.dateTimeOfInstructions.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dateTimeOfInstructions != null ? that.dateTimeOfInstructions.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.isDoctorTakingOver, that.isDoctorTakingOver) &&
			Objects.equals(
			     this.dateTimeOfDrugAdministration != null ? this.dateTimeOfDrugAdministration.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dateTimeOfDrugAdministration != null ? that.dateTimeOfDrugAdministration.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.isAutopay, that.isAutopay) &&
			Objects.equals(this.responseTime, that.responseTime) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
