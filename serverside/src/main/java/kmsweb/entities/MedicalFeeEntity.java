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
import kmsweb.dtos.MedicalFeeEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.MedicalFeeEntityListener;
import kmsweb.serializers.MedicalFeeSerializer;
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
@EntityListeners({MedicalFeeEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicalFeeSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicalFeeEntity extends AbstractEntity {

	/**
	 * Takes a MedicalFeeEntityDto and converts it into a MedicalFeeEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicalFeeEntityDto
	 */
	public MedicalFeeEntity(MedicalFeeEntityDto medicalFeeEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicalFeeEntityDto.getId() != null) {
			this.setId(medicalFeeEntityDto.getId());
		}

		if (medicalFeeEntityDto.getTariffType() != null) {
			this.setTariffType(medicalFeeEntityDto.getTariffType());
		}

		if (medicalFeeEntityDto.getTariffCode() != null) {
			this.setTariffCode(medicalFeeEntityDto.getTariffCode());
		}

		if (medicalFeeEntityDto.getName() != null) {
			this.setName(medicalFeeEntityDto.getName());
		}

		if (medicalFeeEntityDto.getPharmacyTransactionType() != null) {
			this.setPharmacyTransactionType(medicalFeeEntityDto.getPharmacyTransactionType());
		}

		if (medicalFeeEntityDto.getPharmacyTransactionNumber() != null) {
			this.setPharmacyTransactionNumber(medicalFeeEntityDto.getPharmacyTransactionNumber());
		}

		if (medicalFeeEntityDto.getMedicationTransactionNumber() != null) {
			this.setMedicationTransactionNumber(medicalFeeEntityDto.getMedicationTransactionNumber());
		}

		if (medicalFeeEntityDto.getTransactionDate() != null) {
			this.setTransactionDate(medicalFeeEntityDto.getTransactionDate());
		}

		if (medicalFeeEntityDto.getQuantity() != null) {
			this.setQuantity(medicalFeeEntityDto.getQuantity());
		}

		if (medicalFeeEntityDto.getUnit() != null) {
			this.setUnit(medicalFeeEntityDto.getUnit());
		}

		if (medicalFeeEntityDto.getUnitPrice() != null) {
			this.setUnitPrice(medicalFeeEntityDto.getUnitPrice());
		}

		if (medicalFeeEntityDto.getHospitalPrice() != null) {
			this.setHospitalPrice(medicalFeeEntityDto.getHospitalPrice());
		}

		if (medicalFeeEntityDto.getOtherComponentPrice() != null) {
			this.setOtherComponentPrice(medicalFeeEntityDto.getOtherComponentPrice());
		}

		if (medicalFeeEntityDto.getMedicalStaffCode() != null) {
			this.setMedicalStaffCode(medicalFeeEntityDto.getMedicalStaffCode());
		}

		if (medicalFeeEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(medicalFeeEntityDto.getTreatmentClass());
		}

		if (medicalFeeEntityDto.getNotes() != null) {
			this.setNotes(medicalFeeEntityDto.getNotes());
		}

		if (medicalFeeEntityDto.getMedicalFeeStatus() != null) {
			this.setMedicalFeeStatus(medicalFeeEntityDto.getMedicalFeeStatus());
		}

		if (medicalFeeEntityDto.getInventoryRoundingValue() != null) {
			this.setInventoryRoundingValue(medicalFeeEntityDto.getInventoryRoundingValue());
		}

		if (medicalFeeEntityDto.getInvoiceItems() != null) {
			this.setInvoiceItems(medicalFeeEntityDto.getInvoiceItems());
		}

		if (medicalFeeEntityDto.getMedicalFeeItemComponents() != null) {
			this.setMedicalFeeItemComponents(medicalFeeEntityDto.getMedicalFeeItemComponents());
		}

		if (medicalFeeEntityDto.getRegistration() != null) {
			this.setRegistration(medicalFeeEntityDto.getRegistration());
		}

		if (medicalFeeEntityDto.getWarehouse() != null) {
			this.setWarehouse(medicalFeeEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Tariff Type here] off begin
	@CsvCustomBindByName(column = "TARIFF_TYPE", required = false, converter = TariffTypeEnumConverter.class)
	@Nullable
	@Column(name = "tariff_type")
	@Schema(description = "The Tariff Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Tariff Type here] end
	private TariffTypeEnum tariffType;

	// % protected region % [Modify attribute annotation for Tariff Code here] off begin
	@CsvBindByName(column = "TARIFF_CODE", required = false)
	@Nullable
	@Column(name = "tariff_code")
	@Schema(description = "The Tariff Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@CsvBindByName(column = "NAME", required = false)
	@Nullable
	@Column(name = "name")
	@Schema(description = "The Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for Pharmacy Transaction Type here] off begin
	@CsvCustomBindByName(column = "PHARMACY_TRANSACTION_TYPE", required = false, converter = PharmacyTypeEnumConverter.class)
	@Nullable
	@Column(name = "pharmacy_transaction_type")
	@Schema(description = "The Pharmacy Transaction Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Pharmacy Transaction Type here] end
	private PharmacyTypeEnum pharmacyTransactionType;

	// % protected region % [Modify attribute annotation for Pharmacy Transaction Number here] off begin
	@CsvBindByName(column = "PHARMACY_TRANSACTION_NUMBER", required = false)
	@Nullable
	@Column(name = "pharmacy_transaction_number")
	@Schema(description = "The Pharmacy Transaction Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pharmacy Transaction Number here] end
	private String pharmacyTransactionNumber;

	// % protected region % [Modify attribute annotation for Medication Transaction Number here] off begin
	@CsvBindByName(column = "MEDICATION_TRANSACTION_NUMBER", required = false)
	@Nullable
	@Column(name = "medication_transaction_number")
	@Schema(description = "The Medication Transaction Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medication Transaction Number here] end
	private String medicationTransactionNumber;

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin

	@CsvCustomBindByName(column = "TRANSACTION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "transaction_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Transaction Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Quantity here] off begin
	@CsvBindByName(column = "QUANTITY", required = false)
	@Nullable
	@Column(name = "quantity")
	@Schema(description = "The Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity here] end
	private Double quantity;

	// % protected region % [Modify attribute annotation for Unit here] off begin
	@CsvBindByName(column = "UNIT", required = false)
	@Nullable
	@Column(name = "unit")
	@Schema(description = "The Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit here] end
	private String unit;

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@CsvBindByName(column = "UNIT_PRICE", required = false)
	@Nullable
	@Column(name = "unit_price")
	@Schema(description = "The Unit Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Hospital Price here] off begin
	@CsvBindByName(column = "HOSPITAL_PRICE", required = false)
	@Nullable
	@Column(name = "hospital_price")
	@Schema(description = "The Hospital Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Price here] end
	private Double hospitalPrice;

	// % protected region % [Modify attribute annotation for Other Component Price here] off begin
	@CsvBindByName(column = "OTHER_COMPONENT_PRICE", required = false)
	@Nullable
	@Column(name = "other_component_price")
	@Schema(description = "The Other Component Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Component Price here] end
	private Double otherComponentPrice;

	// % protected region % [Modify attribute annotation for Medical Staff Code here] off begin
	@CsvBindByName(column = "MEDICAL_STAFF_CODE", required = false)
	@Nullable
	@Column(name = "medical_staff_code")
	@Schema(description = "The Medical Staff Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medical Staff Code here] end
	private String medicalStaffCode;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@CsvBindByName(column = "TREATMENT_CLASS", required = false)
	@Nullable
	@Column(name = "treatment_class")
	@Schema(description = "The Treatment Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for medical fee status here] off begin
	@CsvCustomBindByName(column = "MEDICAL_FEE_STATUS", required = false, converter = MedicalFeeStatusEnumConverter.class)
	@Nullable
	@Column(name = "medical_fee_status")
	@Schema(description = "The medical fee status of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for medical fee status here] end
	private MedicalFeeStatusEnum medicalFeeStatus;

	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] off begin
	@CsvBindByName(column = "INVENTORY_ROUNDING_VALUE", required = false)
	@Nullable
	@Column(name = "inventory_rounding_value")
	@Schema(description = "The Inventory Rounding Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] end
	private Double inventoryRoundingValue;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Invoice Items here] off begin
	@Schema(description = "The Invoice Item entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalFee", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Items here] end
	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	// % protected region % [Update the annotation for invoiceItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceItemsIds here] end
	private Set<UUID> invoiceItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medical Fee Item Components here] off begin
	@Schema(description = "The Medical Fee Item Component entities that are related to this entity.")
	@OneToMany(mappedBy = "medicalFee", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Fee Item Components here] end
	private Set<MedicalFeeItemComponentEntity> medicalFeeItemComponents = new HashSet<>();

	// % protected region % [Update the annotation for medicalFeeItemComponentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_FEE_ITEM_COMPONENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicalFeeItemComponentsIds here] end
	private Set<UUID> medicalFeeItemComponentsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

	// % protected region % [Update the annotation for Warehouse here] off begin
	@Schema(description = "The Warehouse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse here] end
	private WarehouseEntity warehouse;

	// % protected region % [Update the annotation for warehouseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for warehouseId here] end
	private UUID warehouseId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NotNull InvoiceItemEntity entity) {
		addInvoiceItems(entity, true);
	}

	/**
	 * Add a new InvoiceItemEntity to invoiceItems in this entity.
	 *
	 * @param entity the given InvoiceItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverseAdd) {
		if (!this.invoiceItems.contains(entity)) {
			invoiceItems.add(entity);
			if (reverseAdd) {
				entity.setMedicalFee(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		addInvoiceItems(entities, true);
	}

	/**
	 * Add a new collection of InvoiceItemEntity to Invoice Items in this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be set to this entity
	 */
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NotNull InvoiceItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalFee(false);
		}
		this.invoiceItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 */
	public void removeInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		this.removeInvoiceItems(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemEntity to be set to this entity
	 */
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NotNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceItems();
		this.invoiceItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.setMedicalFee(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceItems() {
		this.unsetInvoiceItems(true);
	}

	/**
	 * Remove all the entities in Invoice Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceItems(boolean doReverse) {
		if (doReverse) {
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.unsetMedicalFee(false));
		}
		this.invoiceItems.clear();
	}

/**
	 * Similar to {@link this#addMedicalFeeItemComponents(MedicalFeeItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity to be added to this entity
	 */
	public void addMedicalFeeItemComponents(@NotNull MedicalFeeItemComponentEntity entity) {
		addMedicalFeeItemComponents(entity, true);
	}

	/**
	 * Add a new MedicalFeeItemComponentEntity to medicalFeeItemComponents in this entity.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicalFeeItemComponents(@NonNull MedicalFeeItemComponentEntity entity, boolean reverseAdd) {
		if (!this.medicalFeeItemComponents.contains(entity)) {
			medicalFeeItemComponents.add(entity);
			if (reverseAdd) {
				entity.setMedicalFee(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicalFeeItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be added to this entity
	 */
	public void addMedicalFeeItemComponents(@NotNull Collection<MedicalFeeItemComponentEntity> entities) {
		addMedicalFeeItemComponents(entities, true);
	}

	/**
	 * Add a new collection of MedicalFeeItemComponentEntity to Medical Fee Item Components in this entity.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicalFeeItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicalFeeItemComponents(MedicalFeeItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity to be set to this entity
	 */
	public void removeMedicalFeeItemComponents(@NotNull MedicalFeeItemComponentEntity entity) {
		this.removeMedicalFeeItemComponents(entity, true);
	}

	/**
	 * Remove the given MedicalFeeItemComponentEntity from this entity.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalFeeItemComponents(@NotNull MedicalFeeItemComponentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicalFee(false);
		}
		this.medicalFeeItemComponents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicalFeeItemComponents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be removed to this entity
	 */
	public void removeMedicalFeeItemComponents(@NotNull Collection<MedicalFeeItemComponentEntity> entities) {
		this.removeMedicalFeeItemComponents(entities, true);
	}

	/**
	 * Remove the given collection of MedicalFeeItemComponentEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicalFeeItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicalFeeItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to be set to this entity
	 */
	public void setMedicalFeeItemComponents(@NotNull Collection<MedicalFeeItemComponentEntity> entities) {
		setMedicalFeeItemComponents(entities, true);
	}

	/**
	 * Replace the current entities in Medical Fee Item Components with the given ones.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalFeeItemComponents(@NotNull Collection<MedicalFeeItemComponentEntity> entities, boolean reverseAdd) {

		this.unsetMedicalFeeItemComponents();
		this.medicalFeeItemComponents = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicalFeeItemComponents.forEach(medicalFeeItemComponentsEntity -> medicalFeeItemComponentsEntity.setMedicalFee(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicalFeeItemComponents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicalFeeItemComponents() {
		this.unsetMedicalFeeItemComponents(true);
	}

	/**
	 * Remove all the entities in Medical Fee Item Components from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicalFeeItemComponents(boolean doReverse) {
		if (doReverse) {
			this.medicalFeeItemComponents.forEach(medicalFeeItemComponentsEntity -> medicalFeeItemComponentsEntity.unsetMedicalFee(false));
		}
		this.medicalFeeItemComponents.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NotNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.removeMedicalFees(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addMedicalFees(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove Registration in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.removeMedicalFees(this, false);
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setWarehouse(@NotNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NotNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] end

		if (sameAsFormer(this.warehouse, entity)) {
			return;
		}

		if (this.warehouse != null) {
			this.warehouse.removeMedicalFees(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addMedicalFees(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetWarehouse(boolean)} but default to true.
	 */
	public void unsetWarehouse() {
		this.unsetWarehouse(true);
	}

	/**
	 * Remove Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetWarehouse(boolean reverse) {
		if (reverse && this.warehouse != null) {
			this.warehouse.removeMedicalFees(this, false);
		}
		this.warehouse = null;
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
		return "TARIFF_TYPE,TARIFF_CODE,NAME,PHARMACY_TRANSACTION_TYPE,PHARMACY_TRANSACTION_NUMBER,MEDICATION_TRANSACTION_NUMBER,TRANSACTION_DATE,QUANTITY,UNIT,UNIT_PRICE,HOSPITAL_PRICE,OTHER_COMPONENT_PRICE,MEDICAL_STAFF_CODE,TREATMENT_CLASS,NOTES,MEDICAL_FEE_STATUS,INVENTORY_ROUNDING_VALUE,REGISTRATION_ID,WAREHOUSE_ID,INVOICE_ITEMS_IDS,MEDICAL_FEE_ITEM_COMPONENTS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.invoiceItemsIds = new HashSet<>();
		for (InvoiceItemEntity invoiceItems: this.invoiceItems) {
			this.invoiceItemsIds.add(invoiceItems.getId());
		}

		this.medicalFeeItemComponentsIds = new HashSet<>();
		for (MedicalFeeItemComponentEntity medicalFeeItemComponents: this.medicalFeeItemComponents) {
			this.medicalFeeItemComponentsIds.add(medicalFeeItemComponents.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicalFee) {
		if (this == medicalFee) {
			return true;
		}
		if (medicalFee == null || this.getClass() != medicalFee.getClass()) {
			return false;
		}
		if (!super.equals(medicalFee)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicalFeeEntity that = (MedicalFeeEntity) medicalFee;
		return
			Objects.equals(this.tariffType, that.tariffType) &&
			Objects.equals(this.tariffCode, that.tariffCode) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.pharmacyTransactionType, that.pharmacyTransactionType) &&
			Objects.equals(this.pharmacyTransactionNumber, that.pharmacyTransactionNumber) &&
			Objects.equals(this.medicationTransactionNumber, that.medicationTransactionNumber) &&
			Objects.equals(
			     this.transactionDate != null ? this.transactionDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.transactionDate != null ? that.transactionDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.quantity, that.quantity) &&
			Objects.equals(this.unit, that.unit) &&
			Objects.equals(this.unitPrice, that.unitPrice) &&
			Objects.equals(this.hospitalPrice, that.hospitalPrice) &&
			Objects.equals(this.otherComponentPrice, that.otherComponentPrice) &&
			Objects.equals(this.medicalStaffCode, that.medicalStaffCode) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.medicalFeeStatus, that.medicalFeeStatus) &&
			Objects.equals(this.inventoryRoundingValue, that.inventoryRoundingValue) &&
			Objects.equals(this.invoiceItemsIds, that.invoiceItemsIds) &&
			Objects.equals(this.medicalFeeItemComponentsIds, that.medicalFeeItemComponentsIds) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
