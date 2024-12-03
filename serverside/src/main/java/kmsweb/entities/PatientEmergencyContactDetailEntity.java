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
import kmsweb.dtos.PatientEmergencyContactDetailEntityDto;
import kmsweb.entities.listeners.PatientEmergencyContactDetailEntityListener;
import kmsweb.serializers.PatientEmergencyContactDetailSerializer;
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
@EntityListeners({PatientEmergencyContactDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientEmergencyContactDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientEmergencyContactDetailEntity extends AbstractEntity {

	/**
	 * Takes a PatientEmergencyContactDetailEntityDto and converts it into a PatientEmergencyContactDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientEmergencyContactDetailEntityDto
	 */
	public PatientEmergencyContactDetailEntity(PatientEmergencyContactDetailEntityDto patientEmergencyContactDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientEmergencyContactDetailEntityDto.getId() != null) {
			this.setId(patientEmergencyContactDetailEntityDto.getId());
		}

		if (patientEmergencyContactDetailEntityDto.getTitle() != null) {
			this.setTitle(patientEmergencyContactDetailEntityDto.getTitle());
		}

		if (patientEmergencyContactDetailEntityDto.getGivenName() != null) {
			this.setGivenName(patientEmergencyContactDetailEntityDto.getGivenName());
		}

		if (patientEmergencyContactDetailEntityDto.getLastName() != null) {
			this.setLastName(patientEmergencyContactDetailEntityDto.getLastName());
		}

		if (patientEmergencyContactDetailEntityDto.getRelationship() != null) {
			this.setRelationship(patientEmergencyContactDetailEntityDto.getRelationship());
		}

		if (patientEmergencyContactDetailEntityDto.getDateOfBirth() != null) {
			this.setDateOfBirth(patientEmergencyContactDetailEntityDto.getDateOfBirth());
		}

		if (patientEmergencyContactDetailEntityDto.getAddress() != null) {
			this.setAddress(patientEmergencyContactDetailEntityDto.getAddress());
		}

		if (patientEmergencyContactDetailEntityDto.getHomePhoneNo() != null) {
			this.setHomePhoneNo(patientEmergencyContactDetailEntityDto.getHomePhoneNo());
		}

		if (patientEmergencyContactDetailEntityDto.getMobilePhoneNo() != null) {
			this.setMobilePhoneNo(patientEmergencyContactDetailEntityDto.getMobilePhoneNo());
		}

		if (patientEmergencyContactDetailEntityDto.getOfficePhoneNo() != null) {
			this.setOfficePhoneNo(patientEmergencyContactDetailEntityDto.getOfficePhoneNo());
		}

		if (patientEmergencyContactDetailEntityDto.getExtensionNo() != null) {
			this.setExtensionNo(patientEmergencyContactDetailEntityDto.getExtensionNo());
		}

		if (patientEmergencyContactDetailEntityDto.getEmailAddress() != null) {
			this.setEmailAddress(patientEmergencyContactDetailEntityDto.getEmailAddress());
		}

		if (patientEmergencyContactDetailEntityDto.getIdCard() != null) {
			this.setIdCard(patientEmergencyContactDetailEntityDto.getIdCard());
		}

		if (patientEmergencyContactDetailEntityDto.getPatientGeneralInformation() != null) {
			this.setPatientGeneralInformation(patientEmergencyContactDetailEntityDto.getPatientGeneralInformation());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Title here] off begin
	@CsvBindByName(column = "TITLE", required = false)
	@Nullable
	@Column(name = "title")
	@Schema(description = "The Title of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Title here] end
	private String title;

	// % protected region % [Modify attribute annotation for Given Name here] off begin
	@CsvBindByName(column = "GIVEN_NAME", required = false)
	@Nullable
	@Column(name = "given_name")
	@Schema(description = "The Given Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Given Name here] end
	private String givenName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@CsvBindByName(column = "LAST_NAME", required = false)
	@Nullable
	@Column(name = "last_name")
	@Schema(description = "The Last Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

	// % protected region % [Modify attribute annotation for Relationship here] off begin
	@CsvBindByName(column = "RELATIONSHIP", required = false)
	@Nullable
	@Column(name = "relationship")
	@Schema(description = "The Relationship of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Relationship here] end
	private String relationship;

	// % protected region % [Modify attribute annotation for Date Of Birth here] off begin

	@CsvCustomBindByName(column = "DATE_OF_BIRTH", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "date_of_birth")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Date Of Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Date Of Birth here] end
	private OffsetDateTime dateOfBirth;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@CsvBindByName(column = "ADDRESS", required = false)
	@Nullable
	@Column(name = "address")
	@Schema(description = "The Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for Home Phone No here] off begin
	@CsvBindByName(column = "HOME_PHONE_NO", required = false)
	@Nullable
	@Column(name = "home_phone_no")
	@Schema(description = "The Home Phone No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Home Phone No here] end
	private String homePhoneNo;

	// % protected region % [Modify attribute annotation for Mobile Phone No here] off begin
	@CsvBindByName(column = "MOBILE_PHONE_NO", required = false)
	@Nullable
	@Column(name = "mobile_phone_no")
	@Schema(description = "The Mobile Phone No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Mobile Phone No here] end
	private String mobilePhoneNo;

	// % protected region % [Modify attribute annotation for Office Phone No here] off begin
	@CsvBindByName(column = "OFFICE_PHONE_NO", required = false)
	@Nullable
	@Column(name = "office_phone_no")
	@Schema(description = "The Office Phone No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Office Phone No here] end
	private String officePhoneNo;

	// % protected region % [Modify attribute annotation for Extension No here] off begin
	@CsvBindByName(column = "EXTENSION_NO", required = false)
	@Nullable
	@Column(name = "extension_no")
	@Schema(description = "The Extension No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Extension No here] end
	private String extensionNo;

	// % protected region % [Modify attribute annotation for Email Address here] off begin
	@CsvBindByName(column = "EMAIL_ADDRESS", required = false)
	@Nullable
	@Column(name = "email_address")
	@Schema(description = "The Email Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email Address here] end
	private String emailAddress;

	// % protected region % [Modify attribute annotation for ID Card here] off begin
	@CsvBindByName(column = "ID_CARD", required = false)
	@Nullable
	@Column(name = "id_card")
	@Schema(description = "The ID Card of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for ID Card here] end
	private String idCard;

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
			this.patientGeneralInformation.unsetPatientEmergencyContactDetail(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientEmergencyContactDetail(this, false);
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
			this.patientGeneralInformation.unsetPatientEmergencyContactDetail();
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
		return "TITLE,GIVEN_NAME,LAST_NAME,RELATIONSHIP,DATE_OF_BIRTH,ADDRESS,HOME_PHONE_NO,MOBILE_PHONE_NO,OFFICE_PHONE_NO,EXTENSION_NO,EMAIL_ADDRESS,ID_CARD,PATIENT_GENERAL_INFORMATION_ID,ID";
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
	public boolean equals(Object patientEmergencyContactDetail) {
		if (this == patientEmergencyContactDetail) {
			return true;
		}
		if (patientEmergencyContactDetail == null || this.getClass() != patientEmergencyContactDetail.getClass()) {
			return false;
		}
		if (!super.equals(patientEmergencyContactDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientEmergencyContactDetailEntity that = (PatientEmergencyContactDetailEntity) patientEmergencyContactDetail;
		return
			Objects.equals(this.title, that.title) &&
			Objects.equals(this.givenName, that.givenName) &&
			Objects.equals(this.lastName, that.lastName) &&
			Objects.equals(this.relationship, that.relationship) &&
			Objects.equals(
			     this.dateOfBirth != null ? this.dateOfBirth.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dateOfBirth != null ? that.dateOfBirth.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.address, that.address) &&
			Objects.equals(this.homePhoneNo, that.homePhoneNo) &&
			Objects.equals(this.mobilePhoneNo, that.mobilePhoneNo) &&
			Objects.equals(this.officePhoneNo, that.officePhoneNo) &&
			Objects.equals(this.extensionNo, that.extensionNo) &&
			Objects.equals(this.emailAddress, that.emailAddress) &&
			Objects.equals(this.idCard, that.idCard) &&
			Objects.equals(this.patientGeneralInformationId, that.patientGeneralInformationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
