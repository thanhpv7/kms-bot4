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
import kmsweb.dtos.PatientDetailEntityDto;
import kmsweb.entities.listeners.PatientDetailEntityListener;
import kmsweb.serializers.PatientDetailSerializer;
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
@EntityListeners({PatientDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientDetailEntity extends AbstractEntity {

	/**
	 * Takes a PatientDetailEntityDto and converts it into a PatientDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientDetailEntityDto
	 */
	public PatientDetailEntity(PatientDetailEntityDto patientDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientDetailEntityDto.getId() != null) {
			this.setId(patientDetailEntityDto.getId());
		}

		if (patientDetailEntityDto.getActivePatientID() != null) {
			this.setActivePatientID(patientDetailEntityDto.getActivePatientID());
		}

		if (patientDetailEntityDto.getPatientClassification() != null) {
			this.setPatientClassification(patientDetailEntityDto.getPatientClassification());
		}

		if (patientDetailEntityDto.getPatientType() != null) {
			this.setPatientType(patientDetailEntityDto.getPatientType());
		}

		if (patientDetailEntityDto.getMaritalStatus() != null) {
			this.setMaritalStatus(patientDetailEntityDto.getMaritalStatus());
		}

		if (patientDetailEntityDto.getNotes() != null) {
			this.setNotes(patientDetailEntityDto.getNotes());
		}

		if (patientDetailEntityDto.getPatientGeneralInformation() != null) {
			this.setPatientGeneralInformation(patientDetailEntityDto.getPatientGeneralInformation());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Active Patient ID here] off begin
	@CsvBindByName(column = "ACTIVE_PATIENT_ID", required = true)
	@NotNull(message = "Active Patient ID must not be empty")
	@Column(name = "active_patient_id")
	@Schema(description = "The Active Patient ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Active Patient ID here] end
	private String activePatientID;

	// % protected region % [Modify attribute annotation for Patient Classification here] off begin
	@CsvBindByName(column = "PATIENT_CLASSIFICATION", required = false)
	@Nullable
	@Column(name = "patient_classification")
	@Schema(description = "The Patient Classification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Classification here] end
	private String patientClassification;

	// % protected region % [Modify attribute annotation for Patient Type here] off begin
	@CsvBindByName(column = "PATIENT_TYPE", required = false)
	@Nullable
	@Column(name = "patient_type")
	@Schema(description = "The Patient Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Type here] end
	private String patientType;

	// % protected region % [Modify attribute annotation for Marital Status here] off begin
	@CsvBindByName(column = "MARITAL_STATUS", required = false)
	@Nullable
	@Column(name = "marital_status")
	@Schema(description = "The Marital Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Marital Status here] end
	private String maritalStatus;

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

	// % protected region % [Update the annotation for Patient General Information here] off begin
	@Schema(description = "The Patient General Information entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
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
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity) {
		setPatientGeneralInformation(entity, true);
	}

	/**
	 * Set or update the patientGeneralInformation in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInformation(PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInformation here] end

		if (sameAsFormer(this.patientGeneralInformation, entity)) {
			return;
		}

		if (this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientDetail(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientDetail(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInformation incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInformation(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInformation() {
		this.unsetPatientGeneralInformation(true);
	}

	/**
	 * Remove the PatientGeneralInfoEntity of patientGeneralInformation from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInformation(boolean reverse) {
		if (reverse && this.patientGeneralInformation != null) {
			this.patientGeneralInformation.unsetPatientDetail();
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
		return "ACTIVE_PATIENT_ID,PATIENT_CLASSIFICATION,PATIENT_TYPE,MARITAL_STATUS,NOTES,PATIENT_GENERAL_INFORMATION_ID,ID";
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
	public boolean equals(Object patientDetail) {
		if (this == patientDetail) {
			return true;
		}
		if (patientDetail == null || this.getClass() != patientDetail.getClass()) {
			return false;
		}
		if (!super.equals(patientDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientDetailEntity that = (PatientDetailEntity) patientDetail;
		return
			Objects.equals(this.activePatientID, that.activePatientID) &&
			Objects.equals(this.patientClassification, that.patientClassification) &&
			Objects.equals(this.patientType, that.patientType) &&
			Objects.equals(this.maritalStatus, that.maritalStatus) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.patientGeneralInformationId, that.patientGeneralInformationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
