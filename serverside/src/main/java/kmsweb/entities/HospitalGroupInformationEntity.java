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
import kmsweb.dtos.HospitalGroupInformationEntityDto;
import kmsweb.entities.listeners.HospitalGroupInformationEntityListener;
import kmsweb.serializers.HospitalGroupInformationSerializer;
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

import java.util.*;
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
@EntityListeners({HospitalGroupInformationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = HospitalGroupInformationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class HospitalGroupInformationEntity extends AbstractEntity {

	/**
	 * Takes a HospitalGroupInformationEntityDto and converts it into a HospitalGroupInformationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param hospitalGroupInformationEntityDto
	 */
	public HospitalGroupInformationEntity(HospitalGroupInformationEntityDto hospitalGroupInformationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (hospitalGroupInformationEntityDto.getId() != null) {
			this.setId(hospitalGroupInformationEntityDto.getId());
		}

		if (hospitalGroupInformationEntityDto.getHospitalGroupCode() != null) {
			this.setHospitalGroupCode(hospitalGroupInformationEntityDto.getHospitalGroupCode());
		}

		if (hospitalGroupInformationEntityDto.getHospitalGroupName() != null) {
			this.setHospitalGroupName(hospitalGroupInformationEntityDto.getHospitalGroupName());
		}

		if (hospitalGroupInformationEntityDto.getHospitalGroupCorporationName() != null) {
			this.setHospitalGroupCorporationName(hospitalGroupInformationEntityDto.getHospitalGroupCorporationName());
		}

		if (hospitalGroupInformationEntityDto.getHospitalGroupDirector() != null) {
			this.setHospitalGroupDirector(hospitalGroupInformationEntityDto.getHospitalGroupDirector());
		}

		if (hospitalGroupInformationEntityDto.getOperationalLicenseNo() != null) {
			this.setOperationalLicenseNo(hospitalGroupInformationEntityDto.getOperationalLicenseNo());
		}

		if (hospitalGroupInformationEntityDto.getHospitalGroupCorporationStatus() != null) {
			this.setHospitalGroupCorporationStatus(hospitalGroupInformationEntityDto.getHospitalGroupCorporationStatus());
		}

		if (hospitalGroupInformationEntityDto.getAddress() != null) {
			this.setAddress(hospitalGroupInformationEntityDto.getAddress());
		}

		if (hospitalGroupInformationEntityDto.getCity() != null) {
			this.setCity(hospitalGroupInformationEntityDto.getCity());
		}

		if (hospitalGroupInformationEntityDto.getPostcode() != null) {
			this.setPostcode(hospitalGroupInformationEntityDto.getPostcode());
		}

		if (hospitalGroupInformationEntityDto.getPhoneNumber() != null) {
			this.setPhoneNumber(hospitalGroupInformationEntityDto.getPhoneNumber());
		}

		if (hospitalGroupInformationEntityDto.getFax() != null) {
			this.setFax(hospitalGroupInformationEntityDto.getFax());
		}

		if (hospitalGroupInformationEntityDto.getEmail() != null) {
			this.setEmail(hospitalGroupInformationEntityDto.getEmail());
		}

		if (hospitalGroupInformationEntityDto.getWebsite() != null) {
			this.setWebsite(hospitalGroupInformationEntityDto.getWebsite());
		}

		if (hospitalGroupInformationEntityDto.getContactPerson() != null) {
			this.setContactPerson(hospitalGroupInformationEntityDto.getContactPerson());
		}

		if (hospitalGroupInformationEntityDto.getContactPersonPhoneNumber() != null) {
			this.setContactPersonPhoneNumber(hospitalGroupInformationEntityDto.getContactPersonPhoneNumber());
		}

		if (hospitalGroupInformationEntityDto.getContactPersonEmail() != null) {
			this.setContactPersonEmail(hospitalGroupInformationEntityDto.getContactPersonEmail());
		}

		if (hospitalGroupInformationEntityDto.getHospitalBranchInformations() != null) {
			this.setHospitalBranchInformations(hospitalGroupInformationEntityDto.getHospitalBranchInformations());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Hospital Group Code here] off begin
	@CsvBindByName(column = "HOSPITAL_GROUP_CODE", required = true)
	@NotNull(message = "Hospital Group Code must not be empty")
	@Column(name = "hospital_group_code")
	@Schema(description = "The Hospital Group Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Group Code here] end
	private String hospitalGroupCode;

	// % protected region % [Modify attribute annotation for Hospital Group Name here] off begin
	@CsvBindByName(column = "HOSPITAL_GROUP_NAME", required = true)
	@NotNull(message = "Hospital Group Name must not be empty")
	@Column(name = "hospital_group_name")
	@Schema(description = "The Hospital Group Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Group Name here] end
	private String hospitalGroupName;

	// % protected region % [Modify attribute annotation for Hospital Group Corporation Name here] off begin
	@CsvBindByName(column = "HOSPITAL_GROUP_CORPORATION_NAME", required = true)
	@NotNull(message = "Hospital Group Corporation Name must not be empty")
	@Column(name = "hospital_group_corporation_name")
	@Schema(description = "The Hospital Group Corporation Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Group Corporation Name here] end
	private String hospitalGroupCorporationName;

	// % protected region % [Modify attribute annotation for Hospital Group Director here] off begin
	@CsvBindByName(column = "HOSPITAL_GROUP_DIRECTOR", required = true)
	@NotNull(message = "Hospital Group Director must not be empty")
	@Column(name = "hospital_group_director")
	@Schema(description = "The Hospital Group Director of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Group Director here] end
	private String hospitalGroupDirector;

	// % protected region % [Modify attribute annotation for Operational License No here] off begin
	@CsvBindByName(column = "OPERATIONAL_LICENSE_NO", required = false)
	@Nullable
	@Column(name = "operational_license_no")
	@Schema(description = "The Operational License No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Operational License No here] end
	private String operationalLicenseNo;

	// % protected region % [Modify attribute annotation for Hospital Group Corporation Status here] off begin
	@CsvBindByName(column = "HOSPITAL_GROUP_CORPORATION_STATUS", required = false)
	@Nullable
	@Column(name = "hospital_group_corporation_status")
	@Schema(description = "The Hospital Group Corporation Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Group Corporation Status here] end
	private String hospitalGroupCorporationStatus;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@CsvBindByName(column = "ADDRESS", required = true)
	@NotNull(message = "Address must not be empty")
	@Column(name = "address")
	@Schema(description = "The Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for City here] off begin
	@CsvBindByName(column = "CITY", required = false)
	@Nullable
	@Column(name = "city")
	@Schema(description = "The City of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for City here] end
	private String city;

	// % protected region % [Modify attribute annotation for Postcode here] off begin
	@CsvBindByName(column = "POSTCODE", required = false)
	@Nullable
	@Column(name = "postcode")
	@Schema(description = "The Postcode of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Postcode here] end
	private String postcode;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@CsvBindByName(column = "PHONE_NUMBER", required = false)
	@Nullable
	@Column(name = "phone_number")
	@Schema(description = "The Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Fax here] off begin
	@CsvBindByName(column = "FAX", required = false)
	@Nullable
	@Column(name = "fax")
	@Schema(description = "The Fax of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fax here] end
	private String fax;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@CsvBindByName(column = "EMAIL", required = false)
	@Nullable
	@Column(name = "email")
	@Schema(description = "The Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Website here] off begin
	@CsvBindByName(column = "WEBSITE", required = false)
	@Nullable
	@Column(name = "website")
	@Schema(description = "The Website of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Website here] end
	private String website;

	// % protected region % [Modify attribute annotation for Contact Person here] off begin
	@CsvBindByName(column = "CONTACT_PERSON", required = false)
	@Nullable
	@Column(name = "contact_person")
	@Schema(description = "The Contact Person of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Contact Person here] end
	private String contactPerson;

	// % protected region % [Modify attribute annotation for Contact Person Phone Number here] off begin
	@CsvBindByName(column = "CONTACT_PERSON_PHONE_NUMBER", required = false)
	@Nullable
	@Column(name = "contact_person_phone_number")
	@Schema(description = "The Contact Person Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Contact Person Phone Number here] end
	private String contactPersonPhoneNumber;

	// % protected region % [Modify attribute annotation for Contact Person Email here] off begin
	@CsvBindByName(column = "CONTACT_PERSON_EMAIL", required = false)
	@Nullable
	@Column(name = "contact_person_email")
	@Schema(description = "The Contact Person Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Contact Person Email here] end
	private String contactPersonEmail;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Hospital Branch Informations here] off begin
	@Schema(description = "The Hospital Branch Information entities that are related to this entity.")
	@OneToMany(mappedBy = "hospitalGroup", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Hospital Branch Informations here] end
	private Set<HospitalBranchInformationEntity> hospitalBranchInformations = new HashSet<>();

	// % protected region % [Update the annotation for hospitalBranchInformationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "HOSPITAL_BRANCH_INFORMATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for hospitalBranchInformationsIds here] end
	private Set<UUID> hospitalBranchInformationsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addHospitalBranchInformations(HospitalBranchInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be added to this entity
	 */
	public void addHospitalBranchInformations(@NotNull HospitalBranchInformationEntity entity) {
		addHospitalBranchInformations(entity, true);
	}

	/**
	 * Add a new HospitalBranchInformationEntity to hospitalBranchInformations in this entity.
	 *
	 * @param entity the given HospitalBranchInformationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addHospitalBranchInformations(@NonNull HospitalBranchInformationEntity entity, boolean reverseAdd) {
		if (!this.hospitalBranchInformations.contains(entity)) {
			hospitalBranchInformations.add(entity);
			if (reverseAdd) {
				entity.setHospitalGroup(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be added to this entity
	 */
	public void addHospitalBranchInformations(@NotNull Collection<HospitalBranchInformationEntity> entities) {
		addHospitalBranchInformations(entities, true);
	}

	/**
	 * Add a new collection of HospitalBranchInformationEntity to Hospital Branch Informations in this entity.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addHospitalBranchInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeHospitalBranchInformations(HospitalBranchInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be set to this entity
	 */
	public void removeHospitalBranchInformations(@NotNull HospitalBranchInformationEntity entity) {
		this.removeHospitalBranchInformations(entity, true);
	}

	/**
	 * Remove the given HospitalBranchInformationEntity from this entity.
	 *
	 * @param entity the given HospitalBranchInformationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeHospitalBranchInformations(@NotNull HospitalBranchInformationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetHospitalGroup(false);
		}
		this.hospitalBranchInformations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be removed to this entity
	 */
	public void removeHospitalBranchInformations(@NotNull Collection<HospitalBranchInformationEntity> entities) {
		this.removeHospitalBranchInformations(entities, true);
	}

	/**
	 * Remove the given collection of HospitalBranchInformationEntity from  to this entity.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeHospitalBranchInformations(@NonNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeHospitalBranchInformations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setHospitalBranchInformations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to be set to this entity
	 */
	public void setHospitalBranchInformations(@NotNull Collection<HospitalBranchInformationEntity> entities) {
		setHospitalBranchInformations(entities, true);
	}

	/**
	 * Replace the current entities in Hospital Branch Informations with the given ones.
	 *
	 * @param entities the given collection of HospitalBranchInformationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setHospitalBranchInformations(@NotNull Collection<HospitalBranchInformationEntity> entities, boolean reverseAdd) {

		this.unsetHospitalBranchInformations();
		this.hospitalBranchInformations = new HashSet<>(entities);
		if (reverseAdd) {
			this.hospitalBranchInformations.forEach(hospitalBranchInformationsEntity -> hospitalBranchInformationsEntity.setHospitalGroup(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetHospitalBranchInformations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetHospitalBranchInformations() {
		this.unsetHospitalBranchInformations(true);
	}

	/**
	 * Remove all the entities in Hospital Branch Informations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetHospitalBranchInformations(boolean doReverse) {
		if (doReverse) {
			this.hospitalBranchInformations.forEach(hospitalBranchInformationsEntity -> hospitalBranchInformationsEntity.unsetHospitalGroup(false));
		}
		this.hospitalBranchInformations.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "HOSPITAL_GROUP_CODE,HOSPITAL_GROUP_NAME,HOSPITAL_GROUP_CORPORATION_NAME,HOSPITAL_GROUP_DIRECTOR,OPERATIONAL_LICENSE_NO,HOSPITAL_GROUP_CORPORATION_STATUS,ADDRESS,CITY,POSTCODE,PHONE_NUMBER,FAX,EMAIL,WEBSITE,CONTACT_PERSON,CONTACT_PERSON_PHONE_NUMBER,CONTACT_PERSON_EMAIL,HOSPITAL_BRANCH_INFORMATIONS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.hospitalBranchInformationsIds = new HashSet<>();
		for (HospitalBranchInformationEntity hospitalBranchInformations: this.hospitalBranchInformations) {
			this.hospitalBranchInformationsIds.add(hospitalBranchInformations.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object hospitalGroupInformation) {
		if (this == hospitalGroupInformation) {
			return true;
		}
		if (hospitalGroupInformation == null || this.getClass() != hospitalGroupInformation.getClass()) {
			return false;
		}
		if (!super.equals(hospitalGroupInformation)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		HospitalGroupInformationEntity that = (HospitalGroupInformationEntity) hospitalGroupInformation;
		return
			Objects.equals(this.hospitalGroupCode, that.hospitalGroupCode) &&
			Objects.equals(this.hospitalGroupName, that.hospitalGroupName) &&
			Objects.equals(this.hospitalGroupCorporationName, that.hospitalGroupCorporationName) &&
			Objects.equals(this.hospitalGroupDirector, that.hospitalGroupDirector) &&
			Objects.equals(this.operationalLicenseNo, that.operationalLicenseNo) &&
			Objects.equals(this.hospitalGroupCorporationStatus, that.hospitalGroupCorporationStatus) &&
			Objects.equals(this.address, that.address) &&
			Objects.equals(this.city, that.city) &&
			Objects.equals(this.postcode, that.postcode) &&
			Objects.equals(this.phoneNumber, that.phoneNumber) &&
			Objects.equals(this.fax, that.fax) &&
			Objects.equals(this.email, that.email) &&
			Objects.equals(this.website, that.website) &&
			Objects.equals(this.contactPerson, that.contactPerson) &&
			Objects.equals(this.contactPersonPhoneNumber, that.contactPersonPhoneNumber) &&
			Objects.equals(this.contactPersonEmail, that.contactPersonEmail) &&
			Objects.equals(this.hospitalBranchInformationsIds, that.hospitalBranchInformationsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
