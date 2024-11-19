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
import kmsweb.dtos.InvoiceItemEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.InvoiceItemEntityListener;
import kmsweb.serializers.InvoiceItemSerializer;
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
@EntityListeners({InvoiceItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InvoiceItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InvoiceItemEntity extends AbstractEntity {

	/**
	 * Takes a InvoiceItemEntityDto and converts it into a InvoiceItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param invoiceItemEntityDto
	 */
	public InvoiceItemEntity(InvoiceItemEntityDto invoiceItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (invoiceItemEntityDto.getId() != null) {
			this.setId(invoiceItemEntityDto.getId());
		}

		if (invoiceItemEntityDto.getTransactionDate() != null) {
			this.setTransactionDate(invoiceItemEntityDto.getTransactionDate());
		}

		if (invoiceItemEntityDto.getTariffCode() != null) {
			this.setTariffCode(invoiceItemEntityDto.getTariffCode());
		}

		if (invoiceItemEntityDto.getTariffType() != null) {
			this.setTariffType(invoiceItemEntityDto.getTariffType());
		}

		if (invoiceItemEntityDto.getName() != null) {
			this.setName(invoiceItemEntityDto.getName());
		}

		if (invoiceItemEntityDto.getMedicalStaffCode() != null) {
			this.setMedicalStaffCode(invoiceItemEntityDto.getMedicalStaffCode());
		}

		if (invoiceItemEntityDto.getPrice() != null) {
			this.setPrice(invoiceItemEntityDto.getPrice());
		}

		if (invoiceItemEntityDto.getHospitalPrice() != null) {
			this.setHospitalPrice(invoiceItemEntityDto.getHospitalPrice());
		}

		if (invoiceItemEntityDto.getTotalOtherComponentPrice() != null) {
			this.setTotalOtherComponentPrice(invoiceItemEntityDto.getTotalOtherComponentPrice());
		}

		if (invoiceItemEntityDto.getQuantity() != null) {
			this.setQuantity(invoiceItemEntityDto.getQuantity());
		}

		if (invoiceItemEntityDto.getUnit() != null) {
			this.setUnit(invoiceItemEntityDto.getUnit());
		}

		if (invoiceItemEntityDto.getDiscount() != null) {
			this.setDiscount(invoiceItemEntityDto.getDiscount());
		}

		if (invoiceItemEntityDto.getTax() != null) {
			this.setTax(invoiceItemEntityDto.getTax());
		}

		if (invoiceItemEntityDto.getItemTotal() != null) {
			this.setItemTotal(invoiceItemEntityDto.getItemTotal());
		}

		if (invoiceItemEntityDto.getTreatmentClass() != null) {
			this.setTreatmentClass(invoiceItemEntityDto.getTreatmentClass());
		}

		if (invoiceItemEntityDto.getNotes() != null) {
			this.setNotes(invoiceItemEntityDto.getNotes());
		}

		if (invoiceItemEntityDto.getInvoiceItemComponents() != null) {
			this.setInvoiceItemComponents(invoiceItemEntityDto.getInvoiceItemComponents());
		}

		if (invoiceItemEntityDto.getInvoice() != null) {
			this.setInvoice(invoiceItemEntityDto.getInvoice());
		}

		if (invoiceItemEntityDto.getMedicalFee() != null) {
			this.setMedicalFee(invoiceItemEntityDto.getMedicalFee());
		}

		if (invoiceItemEntityDto.getMedicationHeader() != null) {
			this.setMedicationHeader(invoiceItemEntityDto.getMedicationHeader());
		}

		if (invoiceItemEntityDto.getPrescription() != null) {
			this.setPrescription(invoiceItemEntityDto.getPrescription());
		}

		if (invoiceItemEntityDto.getRetailPharmacyInvoice() != null) {
			this.setRetailPharmacyInvoice(invoiceItemEntityDto.getRetailPharmacyInvoice());
		}

		if (invoiceItemEntityDto.getServiceNumber() != null) {
			this.setServiceNumber(invoiceItemEntityDto.getServiceNumber());
		}

		if (invoiceItemEntityDto.getTariffSchema() != null) {
			this.setTariffSchema(invoiceItemEntityDto.getTariffSchema());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin
	@CsvCustomBindByName(column = "TRANSACTION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "transaction_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Transaction Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Tariff Code here] off begin
	@CsvBindByName(column = "TARIFF_CODE", required = false)
	@Nullable
	@Column(name = "tariff_code")
	@Schema(description = "The Tariff Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for Tariff Type here] off begin
	@CsvCustomBindByName(column = "TARIFF_TYPE", required = false, converter = TariffTypeEnumConverter.class)
	@Nullable
	@Column(name = "tariff_type")
	@Schema(description = "The Tariff Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Tariff Type here] end
	private TariffTypeEnum tariffType;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@CsvBindByName(column = "NAME", required = false)
	@Nullable
	@Column(name = "name")
	@Schema(description = "The Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for Medical Staff Code here] off begin
	@CsvBindByName(column = "MEDICAL_STAFF_CODE", required = false)
	@Nullable
	@Column(name = "medical_staff_code")
	@Schema(description = "The Medical Staff Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medical Staff Code here] end
	private String medicalStaffCode;

	// % protected region % [Modify attribute annotation for Price here] off begin
	@CsvBindByName(column = "PRICE", required = false)
	@Nullable
	@Column(name = "price")
	@Schema(description = "The Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Hospital Price here] off begin
	@CsvBindByName(column = "HOSPITAL_PRICE", required = false)
	@Nullable
	@Column(name = "hospital_price")
	@Schema(description = "The Hospital Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Price here] end
	private Double hospitalPrice;

	// % protected region % [Modify attribute annotation for Total Other Component Price here] off begin
	@CsvBindByName(column = "TOTAL_OTHER_COMPONENT_PRICE", required = false)
	@Nullable
	@Column(name = "total_other_component_price")
	@Schema(description = "The Total Other Component Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Other Component Price here] end
	private Double totalOtherComponentPrice;

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

	// % protected region % [Modify attribute annotation for Discount here] off begin
	@CsvBindByName(column = "DISCOUNT", required = false)
	@Nullable
	@Column(name = "discount")
	@Schema(description = "The Discount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discount here] end
	private Double discount;

	// % protected region % [Modify attribute annotation for Tax here] off begin
	@CsvBindByName(column = "TAX", required = false)
	@Nullable
	@Column(name = "tax")
	@Schema(description = "The Tax of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax here] end
	private Boolean tax = false ;

	// % protected region % [Modify attribute annotation for Item Total here] off begin
	@CsvBindByName(column = "ITEM_TOTAL", required = false)
	@Nullable
	@Column(name = "item_total")
	@Schema(description = "The Item Total of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Total here] end
	private Double itemTotal;

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
	@Length(message = "Length must be less than or equal to 500", max = 500)
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

	// % protected region % [Update the annotation for Invoice Item Components here] off begin
	@Schema(description = "The Invoice Item Component entities that are related to this entity.")
	@OneToMany(mappedBy = "invoiceItem", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Item Components here] end
	private Set<InvoiceItemComponentEntity> invoiceItemComponents = new HashSet<>();

	// % protected region % [Update the annotation for invoiceItemComponentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ITEM_COMPONENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceItemComponentsIds here] end
	private Set<UUID> invoiceItemComponentsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Invoice here] off begin
	@Schema(description = "The Invoice entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice here] end
	private InvoiceEntity invoice;

	// % protected region % [Update the annotation for invoiceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for invoiceId here] end
	private UUID invoiceId;

	// % protected region % [Update the annotation for Medical Fee here] off begin
	@Schema(description = "The Medical Fee entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Fee here] end
	private MedicalFeeEntity medicalFee;

	// % protected region % [Update the annotation for medicalFeeId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_FEE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalFeeId here] end
	private UUID medicalFeeId;

	// % protected region % [Update the annotation for Medication Header here] off begin
	@Schema(description = "The Medication Header entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Header here] end
	private MedicationHeaderEntity medicationHeader;

	// % protected region % [Update the annotation for medicationHeaderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_HEADER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicationHeaderId here] end
	private UUID medicationHeaderId;

	// % protected region % [Update the annotation for Prescription here] off begin
	@Schema(description = "The Prescription entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription here] end
	private PrescriptionHeaderEntity prescription;

	// % protected region % [Update the annotation for prescriptionId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for prescriptionId here] end
	private UUID prescriptionId;

	// % protected region % [Update the annotation for Retail Pharmacy Invoice here] off begin
	@Schema(description = "The Retail Pharmacy Invoice entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Retail Pharmacy Invoice here] end
	private RetailPharmacyInvoiceEntity retailPharmacyInvoice;

	// % protected region % [Update the annotation for retailPharmacyInvoiceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETAIL_PHARMACY_INVOICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for retailPharmacyInvoiceId here] end
	private UUID retailPharmacyInvoiceId;

	// % protected region % [Update the annotation for Service Number here] off begin
	@Schema(description = "The Service Number entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Service Number here] end
	private RegistrationEntity serviceNumber;

	// % protected region % [Update the annotation for serviceNumberId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SERVICE_NUMBER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for serviceNumberId here] end
	private UUID serviceNumberId;

	// % protected region % [Update the annotation for Tariff Schema here] off begin
	@Schema(description = "The Tariff Schema entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Schema here] end
	private TariffSchemaEntity tariffSchema;

	// % protected region % [Update the annotation for tariffSchemaId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_SCHEMA_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for tariffSchemaId here] end
	private UUID tariffSchemaId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addInvoiceItemComponents(InvoiceItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be added to this entity
	 */
	public void addInvoiceItemComponents(@NotNull InvoiceItemComponentEntity entity) {
		addInvoiceItemComponents(entity, true);
	}

	/**
	 * Add a new InvoiceItemComponentEntity to invoiceItemComponents in this entity.
	 *
	 * @param entity the given InvoiceItemComponentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoiceItemComponents(@NonNull InvoiceItemComponentEntity entity, boolean reverseAdd) {
		if (!this.invoiceItemComponents.contains(entity)) {
			invoiceItemComponents.add(entity);
			if (reverseAdd) {
				entity.setInvoiceItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoiceItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be added to this entity
	 */
	public void addInvoiceItemComponents(@NotNull Collection<InvoiceItemComponentEntity> entities) {
		addInvoiceItemComponents(entities, true);
	}

	/**
	 * Add a new collection of InvoiceItemComponentEntity to Invoice Item Components in this entity.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoiceItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoiceItemComponents(InvoiceItemComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be set to this entity
	 */
	public void removeInvoiceItemComponents(@NotNull InvoiceItemComponentEntity entity) {
		this.removeInvoiceItemComponents(entity, true);
	}

	/**
	 * Remove the given InvoiceItemComponentEntity from this entity.
	 *
	 * @param entity the given InvoiceItemComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItemComponents(@NotNull InvoiceItemComponentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInvoiceItem(false);
		}
		this.invoiceItemComponents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoiceItemComponents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be removed to this entity
	 */
	public void removeInvoiceItemComponents(@NotNull Collection<InvoiceItemComponentEntity> entities) {
		this.removeInvoiceItemComponents(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceItemComponentEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoiceItemComponents(@NonNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoiceItemComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoiceItemComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to be set to this entity
	 */
	public void setInvoiceItemComponents(@NotNull Collection<InvoiceItemComponentEntity> entities) {
		setInvoiceItemComponents(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Item Components with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItemComponents(@NotNull Collection<InvoiceItemComponentEntity> entities, boolean reverseAdd) {

		this.unsetInvoiceItemComponents();
		this.invoiceItemComponents = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoiceItemComponents.forEach(invoiceItemComponentsEntity -> invoiceItemComponentsEntity.setInvoiceItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoiceItemComponents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoiceItemComponents() {
		this.unsetInvoiceItemComponents(true);
	}

	/**
	 * Remove all the entities in Invoice Item Components from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoiceItemComponents(boolean doReverse) {
		if (doReverse) {
			this.invoiceItemComponents.forEach(invoiceItemComponentsEntity -> invoiceItemComponentsEntity.unsetInvoiceItem(false));
		}
		this.invoiceItemComponents.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setInvoice(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void setInvoice(@NotNull InvoiceEntity entity) {
		setInvoice(entity, true);
	}

	/**
	 * Set or update the invoice in this entity with single InvoiceEntity.
	 *
	 * @param entity the given InvoiceEntity to be set or updated to invoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoice(@NotNull InvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] end

		if (sameAsFormer(this.invoice, entity)) {
			return;
		}

		if (this.invoice != null) {
			this.invoice.removeInvoiceItems(this, false);
		}
		this.invoice = entity;
		if (reverseAdd) {
			this.invoice.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInvoice(boolean)} but default to true.
	 */
	public void unsetInvoice() {
		this.unsetInvoice(true);
	}

	/**
	 * Remove Invoice in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoice(boolean reverse) {
		if (reverse && this.invoice != null) {
			this.invoice.removeInvoiceItems(this, false);
		}
		this.invoice = null;
	}
	/**
	 * Similar to {@link this#setMedicalFee(MedicalFeeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalFeeEntity to be set to this entity
	 */
	public void setMedicalFee(@NotNull MedicalFeeEntity entity) {
		setMedicalFee(entity, true);
	}

	/**
	 * Set or update the medicalFee in this entity with single MedicalFeeEntity.
	 *
	 * @param entity the given MedicalFeeEntity to be set or updated to medicalFee
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalFee(@NotNull MedicalFeeEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalFee here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalFee here] end

		if (sameAsFormer(this.medicalFee, entity)) {
			return;
		}

		if (this.medicalFee != null) {
			this.medicalFee.removeInvoiceItems(this, false);
		}
		this.medicalFee = entity;
		if (reverseAdd) {
			this.medicalFee.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalFee incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalFee incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalFee(boolean)} but default to true.
	 */
	public void unsetMedicalFee() {
		this.unsetMedicalFee(true);
	}

	/**
	 * Remove Medical Fee in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalFee(boolean reverse) {
		if (reverse && this.medicalFee != null) {
			this.medicalFee.removeInvoiceItems(this, false);
		}
		this.medicalFee = null;
	}
	/**
	 * Similar to {@link this#setMedicationHeader(MedicationHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be set to this entity
	 */
	public void setMedicationHeader(@NotNull MedicationHeaderEntity entity) {
		setMedicationHeader(entity, true);
	}

	/**
	 * Set or update the medicationHeader in this entity with single MedicationHeaderEntity.
	 *
	 * @param entity the given MedicationHeaderEntity to be set or updated to medicationHeader
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationHeader(@NotNull MedicationHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationHeader here] end

		if (sameAsFormer(this.medicationHeader, entity)) {
			return;
		}

		if (this.medicationHeader != null) {
			this.medicationHeader.removeInvoiceItems(this, false);
		}
		this.medicationHeader = entity;
		if (reverseAdd) {
			this.medicationHeader.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationHeader incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationHeader(boolean)} but default to true.
	 */
	public void unsetMedicationHeader() {
		this.unsetMedicationHeader(true);
	}

	/**
	 * Remove Medication Header in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationHeader(boolean reverse) {
		if (reverse && this.medicationHeader != null) {
			this.medicationHeader.removeInvoiceItems(this, false);
		}
		this.medicationHeader = null;
	}
	/**
	 * Similar to {@link this#setPrescription(PrescriptionHeaderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set to this entity
	 */
	public void setPrescription(@NotNull PrescriptionHeaderEntity entity) {
		setPrescription(entity, true);
	}

	/**
	 * Set or update the prescription in this entity with single PrescriptionHeaderEntity.
	 *
	 * @param entity the given PrescriptionHeaderEntity to be set or updated to prescription
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrescription(@NotNull PrescriptionHeaderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrescription here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrescription here] end

		if (sameAsFormer(this.prescription, entity)) {
			return;
		}

		if (this.prescription != null) {
			this.prescription.removeInvoiceItems(this, false);
		}
		this.prescription = entity;
		if (reverseAdd) {
			this.prescription.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrescription incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrescription incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPrescription(boolean)} but default to true.
	 */
	public void unsetPrescription() {
		this.unsetPrescription(true);
	}

	/**
	 * Remove Prescription in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrescription(boolean reverse) {
		if (reverse && this.prescription != null) {
			this.prescription.removeInvoiceItems(this, false);
		}
		this.prescription = null;
	}
	/**
	 * Similar to {@link this#setRetailPharmacyInvoice(RetailPharmacyInvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set to this entity
	 */
	public void setRetailPharmacyInvoice(@NotNull RetailPharmacyInvoiceEntity entity) {
		setRetailPharmacyInvoice(entity, true);
	}

	/**
	 * Set or update the retailPharmacyInvoice in this entity with single RetailPharmacyInvoiceEntity.
	 *
	 * @param entity the given RetailPharmacyInvoiceEntity to be set or updated to retailPharmacyInvoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacyInvoice(@NotNull RetailPharmacyInvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacyInvoice here] end

		if (sameAsFormer(this.retailPharmacyInvoice, entity)) {
			return;
		}

		if (this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.removeInvoiceItems(this, false);
		}
		this.retailPharmacyInvoice = entity;
		if (reverseAdd) {
			this.retailPharmacyInvoice.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacyInvoice incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacyInvoice(boolean)} but default to true.
	 */
	public void unsetRetailPharmacyInvoice() {
		this.unsetRetailPharmacyInvoice(true);
	}

	/**
	 * Remove Retail Pharmacy Invoice in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRetailPharmacyInvoice(boolean reverse) {
		if (reverse && this.retailPharmacyInvoice != null) {
			this.retailPharmacyInvoice.removeInvoiceItems(this, false);
		}
		this.retailPharmacyInvoice = null;
	}
	/**
	 * Similar to {@link this#setServiceNumber(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setServiceNumber(@NotNull RegistrationEntity entity) {
		setServiceNumber(entity, true);
	}

	/**
	 * Set or update the serviceNumber in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to serviceNumber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setServiceNumber(@NotNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setServiceNumber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setServiceNumber here] end

		if (sameAsFormer(this.serviceNumber, entity)) {
			return;
		}

		if (this.serviceNumber != null) {
			this.serviceNumber.removeInvoiceItems(this, false);
		}
		this.serviceNumber = entity;
		if (reverseAdd) {
			this.serviceNumber.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setServiceNumber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setServiceNumber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetServiceNumber(boolean)} but default to true.
	 */
	public void unsetServiceNumber() {
		this.unsetServiceNumber(true);
	}

	/**
	 * Remove Service Number in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetServiceNumber(boolean reverse) {
		if (reverse && this.serviceNumber != null) {
			this.serviceNumber.removeInvoiceItems(this, false);
		}
		this.serviceNumber = null;
	}
	/**
	 * Similar to {@link this#setTariffSchema(TariffSchemaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffSchemaEntity to be set to this entity
	 */
	public void setTariffSchema(@NotNull TariffSchemaEntity entity) {
		setTariffSchema(entity, true);
	}

	/**
	 * Set or update the tariffSchema in this entity with single TariffSchemaEntity.
	 *
	 * @param entity the given TariffSchemaEntity to be set or updated to tariffSchema
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTariffSchema(@NotNull TariffSchemaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTariffSchema here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTariffSchema here] end

		if (sameAsFormer(this.tariffSchema, entity)) {
			return;
		}

		if (this.tariffSchema != null) {
			this.tariffSchema.removeInvoiceItems(this, false);
		}
		this.tariffSchema = entity;
		if (reverseAdd) {
			this.tariffSchema.addInvoiceItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTariffSchema incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTariffSchema incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTariffSchema(boolean)} but default to true.
	 */
	public void unsetTariffSchema() {
		this.unsetTariffSchema(true);
	}

	/**
	 * Remove Tariff Schema in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTariffSchema(boolean reverse) {
		if (reverse && this.tariffSchema != null) {
			this.tariffSchema.removeInvoiceItems(this, false);
		}
		this.tariffSchema = null;
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
		return "TRANSACTION_DATE,TARIFF_CODE,TARIFF_TYPE,NAME,MEDICAL_STAFF_CODE,PRICE,HOSPITAL_PRICE,TOTAL_OTHER_COMPONENT_PRICE,QUANTITY,UNIT,DISCOUNT,TAX,ITEM_TOTAL,TREATMENT_CLASS,NOTES,INVOICE_ID,MEDICAL_FEE_ID,MEDICATION_HEADER_ID,PRESCRIPTION_ID,RETAIL_PHARMACY_INVOICE_ID,SERVICE_NUMBER_ID,TARIFF_SCHEMA_ID,INVOICE_ITEM_COMPONENTS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<InvoiceEntity> invoiceRelation = Optional.ofNullable(this.invoice);
		invoiceRelation.ifPresent(entity -> this.invoiceId = entity.getId());

		Optional<MedicalFeeEntity> medicalFeeRelation = Optional.ofNullable(this.medicalFee);
		medicalFeeRelation.ifPresent(entity -> this.medicalFeeId = entity.getId());

		Optional<MedicationHeaderEntity> medicationHeaderRelation = Optional.ofNullable(this.medicationHeader);
		medicationHeaderRelation.ifPresent(entity -> this.medicationHeaderId = entity.getId());

		Optional<PrescriptionHeaderEntity> prescriptionRelation = Optional.ofNullable(this.prescription);
		prescriptionRelation.ifPresent(entity -> this.prescriptionId = entity.getId());

		Optional<RetailPharmacyInvoiceEntity> retailPharmacyInvoiceRelation = Optional.ofNullable(this.retailPharmacyInvoice);
		retailPharmacyInvoiceRelation.ifPresent(entity -> this.retailPharmacyInvoiceId = entity.getId());

		Optional<RegistrationEntity> serviceNumberRelation = Optional.ofNullable(this.serviceNumber);
		serviceNumberRelation.ifPresent(entity -> this.serviceNumberId = entity.getId());

		Optional<TariffSchemaEntity> tariffSchemaRelation = Optional.ofNullable(this.tariffSchema);
		tariffSchemaRelation.ifPresent(entity -> this.tariffSchemaId = entity.getId());

		this.invoiceItemComponentsIds = new HashSet<>();
		for (InvoiceItemComponentEntity invoiceItemComponents: this.invoiceItemComponents) {
			this.invoiceItemComponentsIds.add(invoiceItemComponents.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object invoiceItem) {
		if (this == invoiceItem) {
			return true;
		}
		if (invoiceItem == null || this.getClass() != invoiceItem.getClass()) {
			return false;
		}
		if (!super.equals(invoiceItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InvoiceItemEntity that = (InvoiceItemEntity) invoiceItem;
		return
			Objects.equals(
			     this.transactionDate != null ? this.transactionDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.transactionDate != null ? that.transactionDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.tariffCode, that.tariffCode) &&
			Objects.equals(this.tariffType, that.tariffType) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.medicalStaffCode, that.medicalStaffCode) &&
			Objects.equals(this.price, that.price) &&
			Objects.equals(this.hospitalPrice, that.hospitalPrice) &&
			Objects.equals(this.totalOtherComponentPrice, that.totalOtherComponentPrice) &&
			Objects.equals(this.quantity, that.quantity) &&
			Objects.equals(this.unit, that.unit) &&
			Objects.equals(this.discount, that.discount) &&
			Objects.equals(this.tax, that.tax) &&
			Objects.equals(this.itemTotal, that.itemTotal) &&
			Objects.equals(this.treatmentClass, that.treatmentClass) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.invoiceItemComponentsIds, that.invoiceItemComponentsIds) &&
			Objects.equals(this.invoiceId, that.invoiceId) &&
			Objects.equals(this.medicalFeeId, that.medicalFeeId) &&
			Objects.equals(this.medicationHeaderId, that.medicationHeaderId) &&
			Objects.equals(this.prescriptionId, that.prescriptionId) &&
			Objects.equals(this.retailPharmacyInvoiceId, that.retailPharmacyInvoiceId) &&
			Objects.equals(this.serviceNumberId, that.serviceNumberId) &&
			Objects.equals(this.tariffSchemaId, that.tariffSchemaId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
