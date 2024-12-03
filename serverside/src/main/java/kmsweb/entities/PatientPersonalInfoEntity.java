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
import kmsweb.dtos.PatientPersonalInfoEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.PatientPersonalInfoEntityListener;
import kmsweb.serializers.PatientPersonalInfoSerializer;
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
@EntityListeners({PatientPersonalInfoEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientPersonalInfoSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientPersonalInfoEntity extends AbstractEntity {

	/**
	 * Takes a PatientPersonalInfoEntityDto and converts it into a PatientPersonalInfoEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientPersonalInfoEntityDto
	 */
	public PatientPersonalInfoEntity(PatientPersonalInfoEntityDto patientPersonalInfoEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientPersonalInfoEntityDto.getId() != null) {
			this.setId(patientPersonalInfoEntityDto.getId());
		}

		if (patientPersonalInfoEntityDto.getReligion() != null) {
			this.setReligion(patientPersonalInfoEntityDto.getReligion());
		}

		if (patientPersonalInfoEntityDto.getNationality() != null) {
			this.setNationality(patientPersonalInfoEntityDto.getNationality());
		}

		if (patientPersonalInfoEntityDto.getEthnicity() != null) {
			this.setEthnicity(patientPersonalInfoEntityDto.getEthnicity());
		}

		if (patientPersonalInfoEntityDto.getBloodType() != null) {
			this.setBloodType(patientPersonalInfoEntityDto.getBloodType());
		}

		if (patientPersonalInfoEntityDto.getRhesus() != null) {
			this.setRhesus(patientPersonalInfoEntityDto.getRhesus());
		}

		if (patientPersonalInfoEntityDto.getIdNumber() != null) {
			this.setIdNumber(patientPersonalInfoEntityDto.getIdNumber());
		}

		if (patientPersonalInfoEntityDto.getOccupation() != null) {
			this.setOccupation(patientPersonalInfoEntityDto.getOccupation());
		}

		if (patientPersonalInfoEntityDto.getExternalPatient() != null) {
			this.setExternalPatient(patientPersonalInfoEntityDto.getExternalPatient());
		}

		if (patientPersonalInfoEntityDto.getIsDead() != null) {
			this.setIsDead(patientPersonalInfoEntityDto.getIsDead());
		}

		if (patientPersonalInfoEntityDto.getExternalNotes() != null) {
			this.setExternalNotes(patientPersonalInfoEntityDto.getExternalNotes());
		}

		if (patientPersonalInfoEntityDto.getOtherIDNumber() != null) {
			this.setOtherIDNumber(patientPersonalInfoEntityDto.getOtherIDNumber());
		}

		if (patientPersonalInfoEntityDto.getPatientGeneralInformation() != null) {
			this.setPatientGeneralInformation(patientPersonalInfoEntityDto.getPatientGeneralInformation());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Religion here] off begin
	@CsvBindByName(column = "RELIGION", required = false)
	@Nullable
	@Column(name = "religion")
	@Schema(description = "The Religion of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Religion here] end
	private String religion;

	// % protected region % [Modify attribute annotation for Nationality here] off begin
	@CsvBindByName(column = "NATIONALITY", required = false)
	@Nullable
	@Column(name = "nationality")
	@Schema(description = "The Nationality of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nationality here] end
	private String nationality;

	// % protected region % [Modify attribute annotation for Ethnicity here] off begin
	@CsvBindByName(column = "ETHNICITY", required = false)
	@Nullable
	@Column(name = "ethnicity")
	@Schema(description = "The Ethnicity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ethnicity here] end
	private String ethnicity;

	// % protected region % [Modify attribute annotation for Blood Type here] off begin
	@CsvCustomBindByName(column = "BLOOD_TYPE", required = false, converter = BloodTypeEnumConverter.class)
	@Nullable
	@Column(name = "blood_type")
	@Schema(description = "The Blood Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Blood Type here] end
	private BloodTypeEnum bloodType;

	// % protected region % [Modify attribute annotation for Rhesus here] off begin
	@CsvCustomBindByName(column = "RHESUS", required = false, converter = RhesusEnumConverter.class)
	@Nullable
	@Column(name = "rhesus")
	@Schema(description = "The Rhesus of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Rhesus here] end
	private RhesusEnum rhesus;

	// % protected region % [Modify attribute annotation for ID Number here] off begin
	@CsvBindByName(column = "ID_NUMBER", required = false)
	@Nullable
	@Column(name = "id_number")
	@Schema(description = "The ID Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ID Number here] end
	private String idNumber;

	// % protected region % [Modify attribute annotation for Occupation here] off begin
	@CsvBindByName(column = "OCCUPATION", required = false)
	@Nullable
	@Column(name = "occupation")
	@Schema(description = "The Occupation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Occupation here] end
	private String occupation;

	// % protected region % [Modify attribute annotation for External Patient here] off begin
	@CsvBindByName(column = "EXTERNAL_PATIENT", required = false)
	@Nullable
	@Column(name = "external_patient")
	@Schema(description = "The External Patient of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for External Patient here] end
	private Boolean externalPatient = false ;

	// % protected region % [Modify attribute annotation for Is Dead here] off begin
	@CsvBindByName(column = "IS_DEAD", required = false)
	@Nullable
	@Column(name = "is_dead")
	@Schema(description = "The Is Dead of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Dead here] end
	private Boolean isDead = false ;

	// % protected region % [Modify attribute annotation for External Notes here] off begin
	@CsvBindByName(column = "EXTERNAL_NOTES", required = false)
	@Nullable
	@Lob
	@Column(name = "external_notes")
	@Schema(description = "The External Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for External Notes here] end
	private String externalNotes;

	// % protected region % [Modify attribute annotation for Other ID Number here] off begin
	@CsvBindByName(column = "OTHER_ID_NUMBER", required = false)
	@Nullable
	@Column(name = "other_id_number")
	@Schema(description = "The Other ID Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other ID Number here] end
	private String otherIDNumber;

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
			this.patientGeneralInformation.unsetPatientPersonalInformation(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientPersonalInformation(this, false);
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
			this.patientGeneralInformation.unsetPatientPersonalInformation();
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
		return "RELIGION,NATIONALITY,ETHNICITY,BLOOD_TYPE,RHESUS,ID_NUMBER,OCCUPATION,EXTERNAL_PATIENT,IS_DEAD,EXTERNAL_NOTES,OTHER_ID_NUMBER,PATIENT_GENERAL_INFORMATION_ID,ID";
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
	public boolean equals(Object patientPersonalInfo) {
		if (this == patientPersonalInfo) {
			return true;
		}
		if (patientPersonalInfo == null || this.getClass() != patientPersonalInfo.getClass()) {
			return false;
		}
		if (!super.equals(patientPersonalInfo)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientPersonalInfoEntity that = (PatientPersonalInfoEntity) patientPersonalInfo;
		return
			Objects.equals(this.religion, that.religion) &&
			Objects.equals(this.nationality, that.nationality) &&
			Objects.equals(this.ethnicity, that.ethnicity) &&
			Objects.equals(this.bloodType, that.bloodType) &&
			Objects.equals(this.rhesus, that.rhesus) &&
			Objects.equals(this.idNumber, that.idNumber) &&
			Objects.equals(this.occupation, that.occupation) &&
			Objects.equals(this.externalPatient, that.externalPatient) &&
			Objects.equals(this.isDead, that.isDead) &&
			Objects.equals(this.externalNotes, that.externalNotes) &&
			Objects.equals(this.otherIDNumber, that.otherIDNumber) &&
			Objects.equals(this.patientGeneralInformationId, that.patientGeneralInformationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
