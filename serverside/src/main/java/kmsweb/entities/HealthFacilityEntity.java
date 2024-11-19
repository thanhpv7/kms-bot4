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
import kmsweb.dtos.HealthFacilityEntityDto;
import kmsweb.entities.listeners.HealthFacilityEntityListener;
import kmsweb.serializers.HealthFacilitySerializer;
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
@EntityListeners({HealthFacilityEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = HealthFacilitySerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"health_facility_id"}, name = "health_facility_id"),
	}
)
public class HealthFacilityEntity extends AbstractEntity {

	/**
	 * Takes a HealthFacilityEntityDto and converts it into a HealthFacilityEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param healthFacilityEntityDto
	 */
	public HealthFacilityEntity(HealthFacilityEntityDto healthFacilityEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (healthFacilityEntityDto.getId() != null) {
			this.setId(healthFacilityEntityDto.getId());
		}

		if (healthFacilityEntityDto.getHealthFacilityID() != null) {
			this.setHealthFacilityID(healthFacilityEntityDto.getHealthFacilityID());
		}

		if (healthFacilityEntityDto.getHealthFacilityName() != null) {
			this.setHealthFacilityName(healthFacilityEntityDto.getHealthFacilityName());
		}

		if (healthFacilityEntityDto.getAddress() != null) {
			this.setAddress(healthFacilityEntityDto.getAddress());
		}

		if (healthFacilityEntityDto.getCity() != null) {
			this.setCity(healthFacilityEntityDto.getCity());
		}

		if (healthFacilityEntityDto.getPostCode() != null) {
			this.setPostCode(healthFacilityEntityDto.getPostCode());
		}

		if (healthFacilityEntityDto.getProvince() != null) {
			this.setProvince(healthFacilityEntityDto.getProvince());
		}

		if (healthFacilityEntityDto.getCountry() != null) {
			this.setCountry(healthFacilityEntityDto.getCountry());
		}

		if (healthFacilityEntityDto.getPhoneNumber() != null) {
			this.setPhoneNumber(healthFacilityEntityDto.getPhoneNumber());
		}

		if (healthFacilityEntityDto.getMobilePhoneNumber() != null) {
			this.setMobilePhoneNumber(healthFacilityEntityDto.getMobilePhoneNumber());
		}

		if (healthFacilityEntityDto.getWebsite() != null) {
			this.setWebsite(healthFacilityEntityDto.getWebsite());
		}

		if (healthFacilityEntityDto.getEmail() != null) {
			this.setEmail(healthFacilityEntityDto.getEmail());
		}

		if (healthFacilityEntityDto.getSalutation() != null) {
			this.setSalutation(healthFacilityEntityDto.getSalutation());
		}

		if (healthFacilityEntityDto.getFirstName() != null) {
			this.setFirstName(healthFacilityEntityDto.getFirstName());
		}

		if (healthFacilityEntityDto.getLastName() != null) {
			this.setLastName(healthFacilityEntityDto.getLastName());
		}

		if (healthFacilityEntityDto.getPhoneNumberPOC() != null) {
			this.setPhoneNumberPOC(healthFacilityEntityDto.getPhoneNumberPOC());
		}

		if (healthFacilityEntityDto.getMobilePhoneNumberPOC() != null) {
			this.setMobilePhoneNumberPOC(healthFacilityEntityDto.getMobilePhoneNumberPOC());
		}

		if (healthFacilityEntityDto.getEmailPOC() != null) {
			this.setEmailPOC(healthFacilityEntityDto.getEmailPOC());
		}

		if (healthFacilityEntityDto.getHealthFacilityType() != null) {
			this.setHealthFacilityType(healthFacilityEntityDto.getHealthFacilityType());
		}

		if (healthFacilityEntityDto.getDismissalReferringFacility() != null) {
			this.setDismissalReferringFacility(healthFacilityEntityDto.getDismissalReferringFacility());
		}

		if (healthFacilityEntityDto.getReferringFacility() != null) {
			this.setReferringFacility(healthFacilityEntityDto.getReferringFacility());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Health Facility ID here] off begin
	@CsvBindByName(column = "HEALTH_FACILITY_ID", required = true)
	@NotNull(message = "Health Facility ID must not be empty")
	@Column(name = "health_facility_id")
	@Schema(description = "The Health Facility ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Health Facility ID here] end
	private String healthFacilityID;

	// % protected region % [Modify attribute annotation for Health Facility Name here] off begin
	@CsvBindByName(column = "HEALTH_FACILITY_NAME", required = true)
	@NotNull(message = "Health Facility Name must not be empty")
	@Column(name = "health_facility_name")
	@Schema(description = "The Health Facility Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Health Facility Name here] end
	private String healthFacilityName;

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

	// % protected region % [Modify attribute annotation for Post Code here] off begin
	@CsvBindByName(column = "POST_CODE", required = false)
	@Nullable
	@Column(name = "post_code")
	@Schema(description = "The Post Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Post Code here] end
	private String postCode;

	// % protected region % [Modify attribute annotation for Province here] off begin
	@CsvBindByName(column = "PROVINCE", required = false)
	@Nullable
	@Column(name = "province")
	@Schema(description = "The Province of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Province here] end
	private String province;

	// % protected region % [Modify attribute annotation for Country here] off begin
	@CsvBindByName(column = "COUNTRY", required = false)
	@Nullable
	@Column(name = "country")
	@Schema(description = "The Country of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Country here] end
	private String country;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@CsvBindByName(column = "PHONE_NUMBER", required = false)
	@Nullable
	@Column(name = "phone_number")
	@Schema(description = "The Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Mobile Phone Number here] off begin
	@CsvBindByName(column = "MOBILE_PHONE_NUMBER", required = false)
	@Nullable
	@Column(name = "mobile_phone_number")
	@Schema(description = "The Mobile Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Mobile Phone Number here] end
	private String mobilePhoneNumber;

	// % protected region % [Modify attribute annotation for website here] off begin
	@CsvBindByName(column = "WEBSITE", required = false)
	@Nullable
	@Column(name = "website")
	@Schema(description = "The website of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for website here] end
	private String website;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@CsvBindByName(column = "EMAIL", required = false)
	@Nullable
	@Column(name = "email")
	@Schema(description = "The Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Salutation here] off begin
	@CsvBindByName(column = "SALUTATION", required = false)
	@Nullable
	@Column(name = "salutation")
	@Schema(description = "The Salutation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Salutation here] end
	private String salutation;

	// % protected region % [Modify attribute annotation for First Name here] off begin
	@CsvBindByName(column = "FIRST_NAME", required = false)
	@Nullable
	@Column(name = "first_name")
	@Schema(description = "The First Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for First Name here] end
	private String firstName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@CsvBindByName(column = "LAST_NAME", required = false)
	@Nullable
	@Column(name = "last_name")
	@Schema(description = "The Last Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

	// % protected region % [Modify attribute annotation for Phone Number POC here] off begin
	@CsvBindByName(column = "PHONE_NUMBER_POC", required = false)
	@Nullable
	@Column(name = "phone_number_poc")
	@Schema(description = "The Phone Number POC of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Phone Number POC here] end
	private String phoneNumberPOC;

	// % protected region % [Modify attribute annotation for Mobile Phone Number POC here] off begin
	@CsvBindByName(column = "MOBILE_PHONE_NUMBER_POC", required = false)
	@Nullable
	@Column(name = "mobile_phone_number_poc")
	@Schema(description = "The Mobile Phone Number POC of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Mobile Phone Number POC here] end
	private String mobilePhoneNumberPOC;

	// % protected region % [Modify attribute annotation for Email POC here] off begin
	@CsvBindByName(column = "EMAIL_POC", required = false)
	@Nullable
	@Column(name = "email_poc")
	@Schema(description = "The Email POC of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email POC here] end
	private String emailPOC;

	// % protected region % [Modify attribute annotation for Health Facility Type here] off begin
	@CsvBindByName(column = "HEALTH_FACILITY_TYPE", required = false)
	@Nullable
	@Column(name = "health_facility_type")
	@Schema(description = "The Health Facility Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Health Facility Type here] end
	private String healthFacilityType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Dismissal Referring Facility here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToMany(mappedBy = "dismissalReferringFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Dismissal Referring Facility here] end
	private Set<RegistrationEntity> dismissalReferringFacility = new HashSet<>();

	// % protected region % [Update the annotation for dismissalReferringFacilityIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "DISMISSAL_REFERRING_FACILITY_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for dismissalReferringFacilityIds here] end
	private Set<UUID> dismissalReferringFacilityIds = new HashSet<>();

	// % protected region % [Update the annotation for Referring facility here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToMany(mappedBy = "referringFacility", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Referring facility here] end
	private Set<RegistrationEntity> referringFacility = new HashSet<>();

	// % protected region % [Update the annotation for referringFacilityIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "REFERRING_FACILITY_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for referringFacilityIds here] end
	private Set<UUID> referringFacilityIds = new HashSet<>();

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
	 * Similar to {@link this#addDismissalReferringFacility(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addDismissalReferringFacility(@NotNull RegistrationEntity entity) {
		addDismissalReferringFacility(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to dismissalReferringFacility in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDismissalReferringFacility(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.dismissalReferringFacility.contains(entity)) {
			dismissalReferringFacility.add(entity);
			if (reverseAdd) {
				entity.setDismissalReferringFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDismissalReferringFacility(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addDismissalReferringFacility(@NotNull Collection<RegistrationEntity> entities) {
		addDismissalReferringFacility(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Dismissal Referring Facility in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDismissalReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDismissalReferringFacility(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDismissalReferringFacility(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeDismissalReferringFacility(@NotNull RegistrationEntity entity) {
		this.removeDismissalReferringFacility(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDismissalReferringFacility(@NotNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDismissalReferringFacility(false);
		}
		this.dismissalReferringFacility.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDismissalReferringFacility(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeDismissalReferringFacility(@NotNull Collection<RegistrationEntity> entities) {
		this.removeDismissalReferringFacility(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDismissalReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDismissalReferringFacility(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDismissalReferringFacility(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setDismissalReferringFacility(@NotNull Collection<RegistrationEntity> entities) {
		setDismissalReferringFacility(entities, true);
	}

	/**
	 * Replace the current entities in Dismissal Referring Facility with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDismissalReferringFacility(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetDismissalReferringFacility();
		this.dismissalReferringFacility = new HashSet<>(entities);
		if (reverseAdd) {
			this.dismissalReferringFacility.forEach(dismissalReferringFacilityEntity -> dismissalReferringFacilityEntity.setDismissalReferringFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDismissalReferringFacility(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDismissalReferringFacility() {
		this.unsetDismissalReferringFacility(true);
	}

	/**
	 * Remove all the entities in Dismissal Referring Facility from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDismissalReferringFacility(boolean doReverse) {
		if (doReverse) {
			this.dismissalReferringFacility.forEach(dismissalReferringFacilityEntity -> dismissalReferringFacilityEntity.unsetDismissalReferringFacility(false));
		}
		this.dismissalReferringFacility.clear();
	}

/**
	 * Similar to {@link this#addReferringFacility(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addReferringFacility(@NotNull RegistrationEntity entity) {
		addReferringFacility(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to referringFacility in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReferringFacility(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.referringFacility.contains(entity)) {
			referringFacility.add(entity);
			if (reverseAdd) {
				entity.setReferringFacility(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReferringFacility(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addReferringFacility(@NotNull Collection<RegistrationEntity> entities) {
		addReferringFacility(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Referring facility in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReferringFacility(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReferringFacility(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeReferringFacility(@NotNull RegistrationEntity entity) {
		this.removeReferringFacility(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReferringFacility(@NotNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetReferringFacility(false);
		}
		this.referringFacility.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReferringFacility(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeReferringFacility(@NotNull Collection<RegistrationEntity> entities) {
		this.removeReferringFacility(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReferringFacility(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReferringFacility(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReferringFacility(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setReferringFacility(@NotNull Collection<RegistrationEntity> entities) {
		setReferringFacility(entities, true);
	}

	/**
	 * Replace the current entities in Referring facility with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReferringFacility(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetReferringFacility();
		this.referringFacility = new HashSet<>(entities);
		if (reverseAdd) {
			this.referringFacility.forEach(referringFacilityEntity -> referringFacilityEntity.setReferringFacility(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReferringFacility(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReferringFacility() {
		this.unsetReferringFacility(true);
	}

	/**
	 * Remove all the entities in Referring facility from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReferringFacility(boolean doReverse) {
		if (doReverse) {
			this.referringFacility.forEach(referringFacilityEntity -> referringFacilityEntity.unsetReferringFacility(false));
		}
		this.referringFacility.clear();
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
		return "HEALTH_FACILITY_ID,HEALTH_FACILITY_NAME,ADDRESS,CITY,POST_CODE,PROVINCE,COUNTRY,PHONE_NUMBER,MOBILE_PHONE_NUMBER,WEBSITE,EMAIL,SALUTATION,FIRST_NAME,LAST_NAME,PHONE_NUMBER_POC,MOBILE_PHONE_NUMBER_POC,EMAIL_POC,HEALTH_FACILITY_TYPE,DISMISSAL_REFERRING_FACILITY_IDS,REFERRING_FACILITY_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.dismissalReferringFacilityIds = new HashSet<>();
		for (RegistrationEntity dismissalReferringFacility: this.dismissalReferringFacility) {
			this.dismissalReferringFacilityIds.add(dismissalReferringFacility.getId());
		}

		this.referringFacilityIds = new HashSet<>();
		for (RegistrationEntity referringFacility: this.referringFacility) {
			this.referringFacilityIds.add(referringFacility.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object healthFacility) {
		if (this == healthFacility) {
			return true;
		}
		if (healthFacility == null || this.getClass() != healthFacility.getClass()) {
			return false;
		}
		if (!super.equals(healthFacility)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		HealthFacilityEntity that = (HealthFacilityEntity) healthFacility;
		return
			Objects.equals(this.healthFacilityID, that.healthFacilityID) &&
			Objects.equals(this.healthFacilityName, that.healthFacilityName) &&
			Objects.equals(this.address, that.address) &&
			Objects.equals(this.city, that.city) &&
			Objects.equals(this.postCode, that.postCode) &&
			Objects.equals(this.province, that.province) &&
			Objects.equals(this.country, that.country) &&
			Objects.equals(this.phoneNumber, that.phoneNumber) &&
			Objects.equals(this.mobilePhoneNumber, that.mobilePhoneNumber) &&
			Objects.equals(this.website, that.website) &&
			Objects.equals(this.email, that.email) &&
			Objects.equals(this.salutation, that.salutation) &&
			Objects.equals(this.firstName, that.firstName) &&
			Objects.equals(this.lastName, that.lastName) &&
			Objects.equals(this.phoneNumberPOC, that.phoneNumberPOC) &&
			Objects.equals(this.mobilePhoneNumberPOC, that.mobilePhoneNumberPOC) &&
			Objects.equals(this.emailPOC, that.emailPOC) &&
			Objects.equals(this.healthFacilityType, that.healthFacilityType) &&
			Objects.equals(this.dismissalReferringFacilityIds, that.dismissalReferringFacilityIds) &&
			Objects.equals(this.referringFacilityIds, that.referringFacilityIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
