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
import kmsweb.dtos.PatientContactInfoEntityDto;
import kmsweb.entities.listeners.PatientContactInfoEntityListener;
import kmsweb.serializers.PatientContactInfoSerializer;
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
@EntityListeners({PatientContactInfoEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientContactInfoSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientContactInfoEntity extends AbstractEntity {

	/**
	 * Takes a PatientContactInfoEntityDto and converts it into a PatientContactInfoEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientContactInfoEntityDto
	 */
	public PatientContactInfoEntity(PatientContactInfoEntityDto patientContactInfoEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientContactInfoEntityDto.getId() != null) {
			this.setId(patientContactInfoEntityDto.getId());
		}

		if (patientContactInfoEntityDto.getMobilePhoneNo() != null) {
			this.setMobilePhoneNo(patientContactInfoEntityDto.getMobilePhoneNo());
		}

		if (patientContactInfoEntityDto.getOfficePhoneNo() != null) {
			this.setOfficePhoneNo(patientContactInfoEntityDto.getOfficePhoneNo());
		}

		if (patientContactInfoEntityDto.getExtensionNo() != null) {
			this.setExtensionNo(patientContactInfoEntityDto.getExtensionNo());
		}

		if (patientContactInfoEntityDto.getEmailAddress() != null) {
			this.setEmailAddress(patientContactInfoEntityDto.getEmailAddress());
		}

		if (patientContactInfoEntityDto.getHomePhoneNo() != null) {
			this.setHomePhoneNo(patientContactInfoEntityDto.getHomePhoneNo());
		}

		if (patientContactInfoEntityDto.getPatientGeneralInformation() != null) {
			this.setPatientGeneralInformation(patientContactInfoEntityDto.getPatientGeneralInformation());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Modify attribute annotation for Home Phone No here] off begin
	@CsvBindByName(column = "HOME_PHONE_NO", required = false)
	@Nullable
	@Column(name = "home_phone_no")
	@Schema(description = "The Home Phone No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Home Phone No here] end
	private String homePhoneNo;

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
			this.patientGeneralInformation.unsetPatientContactInformation(false);
		}

		this.patientGeneralInformation = entity;
		if (reverseAdd) {
			this.patientGeneralInformation.setPatientContactInformation(this, false);
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
			this.patientGeneralInformation.unsetPatientContactInformation();
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
		return "MOBILE_PHONE_NO,OFFICE_PHONE_NO,EXTENSION_NO,EMAIL_ADDRESS,HOME_PHONE_NO,PATIENT_GENERAL_INFORMATION_ID,ID";
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
	public boolean equals(Object patientContactInfo) {
		if (this == patientContactInfo) {
			return true;
		}
		if (patientContactInfo == null || this.getClass() != patientContactInfo.getClass()) {
			return false;
		}
		if (!super.equals(patientContactInfo)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientContactInfoEntity that = (PatientContactInfoEntity) patientContactInfo;
		return
			Objects.equals(this.mobilePhoneNo, that.mobilePhoneNo) &&
			Objects.equals(this.officePhoneNo, that.officePhoneNo) &&
			Objects.equals(this.extensionNo, that.extensionNo) &&
			Objects.equals(this.emailAddress, that.emailAddress) &&
			Objects.equals(this.homePhoneNo, that.homePhoneNo) &&
			Objects.equals(this.patientGeneralInformationId, that.patientGeneralInformationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
