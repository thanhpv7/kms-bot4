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
import kmsweb.dtos.InsuranceProviderEntityDto;
import kmsweb.entities.listeners.InsuranceProviderEntityListener;
import kmsweb.serializers.InsuranceProviderSerializer;
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

import java.util.*;
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
@EntityListeners({InsuranceProviderEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InsuranceProviderSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"provider_code"}, name = "provider_code"),
	}
)
public class InsuranceProviderEntity extends AbstractEntity {

	/**
	 * Takes a InsuranceProviderEntityDto and converts it into a InsuranceProviderEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param insuranceProviderEntityDto
	 */
	public InsuranceProviderEntity(InsuranceProviderEntityDto insuranceProviderEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (insuranceProviderEntityDto.getId() != null) {
			this.setId(insuranceProviderEntityDto.getId());
		}

		if (insuranceProviderEntityDto.getProviderCode() != null) {
			this.setProviderCode(insuranceProviderEntityDto.getProviderCode());
		}

		if (insuranceProviderEntityDto.getProviderName() != null) {
			this.setProviderName(insuranceProviderEntityDto.getProviderName());
		}

		if (insuranceProviderEntityDto.getProviderType() != null) {
			this.setProviderType(insuranceProviderEntityDto.getProviderType());
		}

		if (insuranceProviderEntityDto.getBenefitProvider() != null) {
			this.setBenefitProvider(insuranceProviderEntityDto.getBenefitProvider());
		}

		if (insuranceProviderEntityDto.getFirstName() != null) {
			this.setFirstName(insuranceProviderEntityDto.getFirstName());
		}

		if (insuranceProviderEntityDto.getLastName() != null) {
			this.setLastName(insuranceProviderEntityDto.getLastName());
		}

		if (insuranceProviderEntityDto.getPhoneNumber() != null) {
			this.setPhoneNumber(insuranceProviderEntityDto.getPhoneNumber());
		}

		if (insuranceProviderEntityDto.getMobilePhoneNumber() != null) {
			this.setMobilePhoneNumber(insuranceProviderEntityDto.getMobilePhoneNumber());
		}

		if (insuranceProviderEntityDto.getEmail() != null) {
			this.setEmail(insuranceProviderEntityDto.getEmail());
		}

		if (insuranceProviderEntityDto.getExpiryDate() != null) {
			this.setExpiryDate(insuranceProviderEntityDto.getExpiryDate());
		}

		if (insuranceProviderEntityDto.getExpiringDate() != null) {
			this.setExpiringDate(insuranceProviderEntityDto.getExpiringDate());
		}

		if (insuranceProviderEntityDto.getCreatedDate() != null) {
			this.setCreatedDate(insuranceProviderEntityDto.getCreatedDate());
		}

		if (insuranceProviderEntityDto.getNotes() != null) {
			this.setNotes(insuranceProviderEntityDto.getNotes());
		}

		if (insuranceProviderEntityDto.getInsuranceBenefitPlans() != null) {
			this.setInsuranceBenefitPlans(insuranceProviderEntityDto.getInsuranceBenefitPlans());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Provider Code here] off begin
	@CsvBindByName(column = "PROVIDER_CODE", required = true)
	@NotNull(message = "Provider Code must not be empty")
	@Column(name = "provider_code")
	@Schema(description = "The Provider Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Provider Code here] end
	private String providerCode;

	// % protected region % [Modify attribute annotation for Provider Name here] off begin
	@CsvBindByName(column = "PROVIDER_NAME", required = true)
	@NotNull(message = "Provider Name must not be empty")
	@Column(name = "provider_name")
	@Schema(description = "The Provider Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Provider Name here] end
	private String providerName;

	// % protected region % [Modify attribute annotation for Provider Type here] off begin
	@CsvBindByName(column = "PROVIDER_TYPE", required = true)
	@NotNull(message = "Provider Type must not be empty")
	@Column(name = "provider_type")
	@Schema(description = "The Provider Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Provider Type here] end
	private String providerType;

	// % protected region % [Modify attribute annotation for Benefit Provider here] off begin
	@CsvBindByName(column = "BENEFIT_PROVIDER", required = true)
	@NotNull(message = "Benefit Provider must not be empty")
	@Column(name = "benefit_provider")
	@Schema(description = "The Benefit Provider of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Benefit Provider here] end
	private String benefitProvider;

	// % protected region % [Modify attribute annotation for First Name here] off begin
	@CsvBindByName(column = "FIRST_NAME", required = true)
	@NotNull(message = "First Name must not be empty")
	@Column(name = "first_name")
	@Schema(description = "The First Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for First Name here] end
	private String firstName;

	// % protected region % [Modify attribute annotation for Last Name here] off begin
	@CsvBindByName(column = "LAST_NAME", required = true)
	@NotNull(message = "Last Name must not be empty")
	@Column(name = "last_name")
	@Schema(description = "The Last Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Name here] end
	private String lastName;

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

	// % protected region % [Modify attribute annotation for Email here] off begin
	@CsvBindByName(column = "EMAIL", required = false)
	@Nullable
	@Column(name = "email")
	@Schema(description = "The Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Expiry Date here] off begin

	@CsvCustomBindByName(column = "EXPIRY_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "expiry_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Expiry Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Expiry Date here] end
	private OffsetDateTime expiryDate;

	// % protected region % [Modify attribute annotation for Expiring Date here] off begin

	@CsvCustomBindByName(column = "EXPIRING_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "expiring_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Expiring Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Expiring Date here] end
	private OffsetDateTime expiringDate;

	// % protected region % [Modify attribute annotation for Created Date here] off begin

	@CsvCustomBindByName(column = "CREATED_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "created_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Created Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Created Date here] end
	private OffsetDateTime createdDate;

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

	// % protected region % [Update the annotation for Insurance Benefit Plans here] off begin
	@Schema(description = "The Insurance Benefit Plan entities that are related to this entity.")
	@OneToMany(mappedBy = "insuranceProvider", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Insurance Benefit Plans here] end
	private Set<InsuranceBenefitPlanEntity> insuranceBenefitPlans = new HashSet<>();

	// % protected region % [Update the annotation for insuranceBenefitPlansIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INSURANCE_BENEFIT_PLANS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for insuranceBenefitPlansIds here] end
	private Set<UUID> insuranceBenefitPlansIds = new HashSet<>();

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
	 * Similar to {@link this#addInsuranceBenefitPlans(InsuranceBenefitPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be added to this entity
	 */
	public void addInsuranceBenefitPlans(@NotNull InsuranceBenefitPlanEntity entity) {
		addInsuranceBenefitPlans(entity, true);
	}

	/**
	 * Add a new InsuranceBenefitPlanEntity to insuranceBenefitPlans in this entity.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInsuranceBenefitPlans(@NonNull InsuranceBenefitPlanEntity entity, boolean reverseAdd) {
		if (!this.insuranceBenefitPlans.contains(entity)) {
			insuranceBenefitPlans.add(entity);
			if (reverseAdd) {
				entity.setInsuranceProvider(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInsuranceBenefitPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be added to this entity
	 */
	public void addInsuranceBenefitPlans(@NotNull Collection<InsuranceBenefitPlanEntity> entities) {
		addInsuranceBenefitPlans(entities, true);
	}

	/**
	 * Add a new collection of InsuranceBenefitPlanEntity to Insurance Benefit Plans in this entity.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInsuranceBenefitPlans(@NonNull Collection<InsuranceBenefitPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInsuranceBenefitPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInsuranceBenefitPlans(InsuranceBenefitPlanEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be set to this entity
	 */
	public void removeInsuranceBenefitPlans(@NotNull InsuranceBenefitPlanEntity entity) {
		this.removeInsuranceBenefitPlans(entity, true);
	}

	/**
	 * Remove the given InsuranceBenefitPlanEntity from this entity.
	 *
	 * @param entity the given InsuranceBenefitPlanEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInsuranceBenefitPlans(@NotNull InsuranceBenefitPlanEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInsuranceProvider(false);
		}
		this.insuranceBenefitPlans.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInsuranceBenefitPlans(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be removed to this entity
	 */
	public void removeInsuranceBenefitPlans(@NotNull Collection<InsuranceBenefitPlanEntity> entities) {
		this.removeInsuranceBenefitPlans(entities, true);
	}

	/**
	 * Remove the given collection of InsuranceBenefitPlanEntity from  to this entity.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInsuranceBenefitPlans(@NonNull Collection<InsuranceBenefitPlanEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInsuranceBenefitPlans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInsuranceBenefitPlans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to be set to this entity
	 */
	public void setInsuranceBenefitPlans(@NotNull Collection<InsuranceBenefitPlanEntity> entities) {
		setInsuranceBenefitPlans(entities, true);
	}

	/**
	 * Replace the current entities in Insurance Benefit Plans with the given ones.
	 *
	 * @param entities the given collection of InsuranceBenefitPlanEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInsuranceBenefitPlans(@NotNull Collection<InsuranceBenefitPlanEntity> entities, boolean reverseAdd) {

		this.unsetInsuranceBenefitPlans();
		this.insuranceBenefitPlans = new HashSet<>(entities);
		if (reverseAdd) {
			this.insuranceBenefitPlans.forEach(insuranceBenefitPlansEntity -> insuranceBenefitPlansEntity.setInsuranceProvider(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInsuranceBenefitPlans(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInsuranceBenefitPlans() {
		this.unsetInsuranceBenefitPlans(true);
	}

	/**
	 * Remove all the entities in Insurance Benefit Plans from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInsuranceBenefitPlans(boolean doReverse) {
		if (doReverse) {
			this.insuranceBenefitPlans.forEach(insuranceBenefitPlansEntity -> insuranceBenefitPlansEntity.unsetInsuranceProvider(false));
		}
		this.insuranceBenefitPlans.clear();
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
		return "PROVIDER_CODE,PROVIDER_NAME,PROVIDER_TYPE,BENEFIT_PROVIDER,FIRST_NAME,LAST_NAME,PHONE_NUMBER,MOBILE_PHONE_NUMBER,EMAIL,EXPIRY_DATE,EXPIRING_DATE,CREATED_DATE,NOTES,INSURANCE_BENEFIT_PLANS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.insuranceBenefitPlansIds = new HashSet<>();
		for (InsuranceBenefitPlanEntity insuranceBenefitPlans: this.insuranceBenefitPlans) {
			this.insuranceBenefitPlansIds.add(insuranceBenefitPlans.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object insuranceProvider) {
		if (this == insuranceProvider) {
			return true;
		}
		if (insuranceProvider == null || this.getClass() != insuranceProvider.getClass()) {
			return false;
		}
		if (!super.equals(insuranceProvider)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InsuranceProviderEntity that = (InsuranceProviderEntity) insuranceProvider;
		return
			Objects.equals(this.providerCode, that.providerCode) &&
			Objects.equals(this.providerName, that.providerName) &&
			Objects.equals(this.providerType, that.providerType) &&
			Objects.equals(this.benefitProvider, that.benefitProvider) &&
			Objects.equals(this.firstName, that.firstName) &&
			Objects.equals(this.lastName, that.lastName) &&
			Objects.equals(this.phoneNumber, that.phoneNumber) &&
			Objects.equals(this.mobilePhoneNumber, that.mobilePhoneNumber) &&
			Objects.equals(this.email, that.email) &&
			Objects.equals(
			     this.expiryDate != null ? this.expiryDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.expiryDate != null ? that.expiryDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.expiringDate != null ? this.expiringDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.expiringDate != null ? that.expiringDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.createdDate != null ? this.createdDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.createdDate != null ? that.createdDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.insuranceBenefitPlansIds, that.insuranceBenefitPlansIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
