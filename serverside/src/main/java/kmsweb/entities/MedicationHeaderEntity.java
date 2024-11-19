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
import kmsweb.dtos.MedicationHeaderEntityDto;
import kmsweb.entities.listeners.MedicationHeaderEntityListener;
import kmsweb.serializers.MedicationHeaderSerializer;
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
@EntityListeners({MedicationHeaderEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicationHeaderSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicationHeaderEntity extends AbstractEntity {

	/**
	 * Takes a MedicationHeaderEntityDto and converts it into a MedicationHeaderEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicationHeaderEntityDto
	 */
	public MedicationHeaderEntity(MedicationHeaderEntityDto medicationHeaderEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicationHeaderEntityDto.getId() != null) {
			this.setId(medicationHeaderEntityDto.getId());
		}

		if (medicationHeaderEntityDto.getMedicationNumber() != null) {
			this.setMedicationNumber(medicationHeaderEntityDto.getMedicationNumber());
		}

		if (medicationHeaderEntityDto.getDispensingType() != null) {
			this.setDispensingType(medicationHeaderEntityDto.getDispensingType());
		}

		if (medicationHeaderEntityDto.getOriginalMedicationNumber() != null) {
			this.setOriginalMedicationNumber(medicationHeaderEntityDto.getOriginalMedicationNumber());
		}

		if (medicationHeaderEntityDto.getOrderDate() != null) {
			this.setOrderDate(medicationHeaderEntityDto.getOrderDate());
		}

		if (medicationHeaderEntityDto.getStatus() != null) {
			this.setStatus(medicationHeaderEntityDto.getStatus());
		}

		if (medicationHeaderEntityDto.getNotes() != null) {
			this.setNotes(medicationHeaderEntityDto.getNotes());
		}

		if (medicationHeaderEntityDto.getIsUrgent() != null) {
			this.setIsUrgent(medicationHeaderEntityDto.getIsUrgent());
		}

		if (medicationHeaderEntityDto.getIsCompound() != null) {
			this.setIsCompound(medicationHeaderEntityDto.getIsCompound());
		}

		if (medicationHeaderEntityDto.getRevisionNo() != null) {
			this.setRevisionNo(medicationHeaderEntityDto.getRevisionNo());
		}

		if (medicationHeaderEntityDto.getIsInvoiced() != null) {
			this.setIsInvoiced(medicationHeaderEntityDto.getIsInvoiced());
		}

		if (medicationHeaderEntityDto.getExternalWarehouse() != null) {
			this.setExternalWarehouse(medicationHeaderEntityDto.getExternalWarehouse());
		}

		if (medicationHeaderEntityDto.getRestricted() != null) {
			this.setRestricted(medicationHeaderEntityDto.getRestricted());
		}

		if (medicationHeaderEntityDto.getInvoiceItems() != null) {
			this.setInvoiceItems(medicationHeaderEntityDto.getInvoiceItems());
		}

		if (medicationHeaderEntityDto.getInvoice() != null) {
			this.setInvoice(medicationHeaderEntityDto.getInvoice());
		}

		if (medicationHeaderEntityDto.getMedicationCompounds() != null) {
			this.setMedicationCompounds(medicationHeaderEntityDto.getMedicationCompounds());
		}

		if (medicationHeaderEntityDto.getMedicationItems() != null) {
			this.setMedicationItems(medicationHeaderEntityDto.getMedicationItems());
		}

		if (medicationHeaderEntityDto.getRegistration() != null) {
			this.setRegistration(medicationHeaderEntityDto.getRegistration());
		}

		if (medicationHeaderEntityDto.getRequestedBy() != null) {
			this.setRequestedBy(medicationHeaderEntityDto.getRequestedBy());
		}

		if (medicationHeaderEntityDto.getWarehouse() != null) {
			this.setWarehouse(medicationHeaderEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Medication Number here] off begin
	@CsvBindByName(column = "MEDICATION_NUMBER", required = true)
	@NotNull(message = "Medication Number must not be empty")
	@Column(name = "medication_number")
	@Schema(description = "The Medication Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medication Number here] end
	private String medicationNumber;

	// % protected region % [Modify attribute annotation for Dispensing Type here] off begin
	@CsvBindByName(column = "DISPENSING_TYPE", required = true)
	@NotNull(message = "Dispensing Type must not be empty")
	@Column(name = "dispensing_type")
	@Schema(description = "The Dispensing Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dispensing Type here] end
	private String dispensingType;

	// % protected region % [Modify attribute annotation for Original Medication Number here] off begin
	@CsvBindByName(column = "ORIGINAL_MEDICATION_NUMBER", required = false)
	@Nullable
	@Column(name = "original_medication_number")
	@Schema(description = "The Original Medication Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Original Medication Number here] end
	private String originalMedicationNumber;

	// % protected region % [Modify attribute annotation for Order Date here] off begin
	@CsvCustomBindByName(column = "ORDER_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "order_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Order Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Order Date here] end
	private OffsetDateTime orderDate;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Is Urgent here] off begin
	@CsvBindByName(column = "IS_URGENT", required = false)
	@Nullable
	@Column(name = "is_urgent")
	@Schema(description = "The Is Urgent of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Urgent here] end
	private Boolean isUrgent = false ;

	// % protected region % [Modify attribute annotation for Is Compound here] off begin
	@CsvBindByName(column = "IS_COMPOUND", required = false)
	@Nullable
	@Column(name = "is_compound")
	@Schema(description = "The Is Compound of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Compound here] end
	private Boolean isCompound = false ;

	// % protected region % [Modify attribute annotation for Revision No here] off begin
	@CsvBindByName(column = "REVISION_NO", required = false)
	@Nullable
	@Column(name = "revision_no")
	@Schema(description = "The Revision No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Revision No here] end
	private Integer revisionNo;

	// % protected region % [Modify attribute annotation for Is Invoiced here] off begin
	@CsvBindByName(column = "IS_INVOICED", required = false)
	@Nullable
	@Column(name = "is_invoiced")
	@Schema(description = "The Is Invoiced of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Invoiced here] end
	private Boolean isInvoiced = false ;

	// % protected region % [Modify attribute annotation for External Warehouse here] off begin
	@CsvBindByName(column = "EXTERNAL_WAREHOUSE", required = false)
	@Nullable
	@Column(name = "external_warehouse")
	@Schema(description = "The External Warehouse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for External Warehouse here] end
	private Boolean externalWarehouse = false ;

	// % protected region % [Modify attribute annotation for Restricted here] off begin
	@CsvBindByName(column = "RESTRICTED", required = false)
	@Nullable
	@Column(name = "restricted")
	@Schema(description = "The Restricted of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Restricted here] end
	private Boolean restricted = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Invoice Items here] off begin
	@Schema(description = "The Invoice Item entities that are related to this entity.")
	@OneToMany(mappedBy = "medicationHeader", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Items here] end
	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	// % protected region % [Update the annotation for invoiceItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceItemsIds here] end
	private Set<UUID> invoiceItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoice here] off begin
	@Schema(description = "The Invoice entities that are related to this entity.")
	@OneToOne(mappedBy = "medicationHeader", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice here] end
	private InvoiceEntity invoice;

	// % protected region % [Update the annotation for invoiceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for invoiceId here] end
	private UUID invoiceId;

	// % protected region % [Update the annotation for Medication Compounds here] off begin
	@Schema(description = "The Medication Compound entities that are related to this entity.")
	@OneToMany(mappedBy = "medicationHeader", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Compounds here] end
	private Set<MedicationCompoundEntity> medicationCompounds = new HashSet<>();

	// % protected region % [Update the annotation for medicationCompoundsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_COMPOUNDS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationCompoundsIds here] end
	private Set<UUID> medicationCompoundsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medication Items here] off begin
	@Schema(description = "The Medication Item entities that are related to this entity.")
	@OneToMany(mappedBy = "medicationHeader", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Items here] end
	private Set<MedicationItemEntity> medicationItems = new HashSet<>();

	// % protected region % [Update the annotation for medicationItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationItemsIds here] end
	private Set<UUID> medicationItemsIds = new HashSet<>();

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

	// % protected region % [Update the annotation for Requested By here] off begin
	@Schema(description = "The Requested By entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Requested By here] end
	private StaffEntity requestedBy;

	// % protected region % [Update the annotation for requestedById here] off begin
	@Transient
	@CsvCustomBindByName(column = "REQUESTED_BY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for requestedById here] end
	private UUID requestedById;

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
				entity.setMedicationHeader(this, false);
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
			entity.unsetMedicationHeader(false);
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
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.setMedicationHeader(this, false));
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
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.unsetMedicationHeader(false));
		}
		this.invoiceItems.clear();
	}

	/**
	 * Similar to {@link this#setInvoice(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationHeaderEntity to be set to this entity
	 */
	public void setInvoice(@NotNull InvoiceEntity entity) {
		setInvoice(entity, true);
	}

	/**
	 * Set or update invoice with the given InvoiceEntity.
	 *
	 * @param entity the MedicationHeaderEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoice(@NotNull InvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] end

		if (sameAsFormer(this.invoice, entity)) {
			return;
		}

		if (this.invoice != null) {
			this.invoice.unsetMedicationHeader();
		}

		this.invoice = entity;

		if (reverseAdd) {
			this.invoice.setMedicationHeader(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoice outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoice outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoice(boolean)} but default to true.
	 */
	public void unsetInvoice() {
		this.unsetInvoice(true);
	}

	/**
	 * Remove the InvoiceEntity in Invoice from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoice(boolean reverse) {
		if (reverse && this.invoice != null) {
			this.invoice.unsetMedicationHeader(false);
		}
		this.invoice = null;
	}

/**
	 * Similar to {@link this#addMedicationCompounds(MedicationCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationCompoundEntity to be added to this entity
	 */
	public void addMedicationCompounds(@NotNull MedicationCompoundEntity entity) {
		addMedicationCompounds(entity, true);
	}

	/**
	 * Add a new MedicationCompoundEntity to medicationCompounds in this entity.
	 *
	 * @param entity the given MedicationCompoundEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationCompounds(@NonNull MedicationCompoundEntity entity, boolean reverseAdd) {
		if (!this.medicationCompounds.contains(entity)) {
			medicationCompounds.add(entity);
			if (reverseAdd) {
				entity.setMedicationHeader(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationCompounds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be added to this entity
	 */
	public void addMedicationCompounds(@NotNull Collection<MedicationCompoundEntity> entities) {
		addMedicationCompounds(entities, true);
	}

	/**
	 * Add a new collection of MedicationCompoundEntity to Medication Compounds in this entity.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationCompounds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationCompounds(MedicationCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationCompoundEntity to be set to this entity
	 */
	public void removeMedicationCompounds(@NotNull MedicationCompoundEntity entity) {
		this.removeMedicationCompounds(entity, true);
	}

	/**
	 * Remove the given MedicationCompoundEntity from this entity.
	 *
	 * @param entity the given MedicationCompoundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationCompounds(@NotNull MedicationCompoundEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicationHeader(false);
		}
		this.medicationCompounds.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationCompounds(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be removed to this entity
	 */
	public void removeMedicationCompounds(@NotNull Collection<MedicationCompoundEntity> entities) {
		this.removeMedicationCompounds(entities, true);
	}

	/**
	 * Remove the given collection of MedicationCompoundEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationCompounds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationCompounds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to be set to this entity
	 */
	public void setMedicationCompounds(@NotNull Collection<MedicationCompoundEntity> entities) {
		setMedicationCompounds(entities, true);
	}

	/**
	 * Replace the current entities in Medication Compounds with the given ones.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationCompounds(@NotNull Collection<MedicationCompoundEntity> entities, boolean reverseAdd) {

		this.unsetMedicationCompounds();
		this.medicationCompounds = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationCompounds.forEach(medicationCompoundsEntity -> medicationCompoundsEntity.setMedicationHeader(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationCompounds(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationCompounds() {
		this.unsetMedicationCompounds(true);
	}

	/**
	 * Remove all the entities in Medication Compounds from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationCompounds(boolean doReverse) {
		if (doReverse) {
			this.medicationCompounds.forEach(medicationCompoundsEntity -> medicationCompoundsEntity.unsetMedicationHeader(false));
		}
		this.medicationCompounds.clear();
	}

/**
	 * Similar to {@link this#addMedicationItems(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be added to this entity
	 */
	public void addMedicationItems(@NotNull MedicationItemEntity entity) {
		addMedicationItems(entity, true);
	}

	/**
	 * Add a new MedicationItemEntity to medicationItems in this entity.
	 *
	 * @param entity the given MedicationItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationItems(@NonNull MedicationItemEntity entity, boolean reverseAdd) {
		if (!this.medicationItems.contains(entity)) {
			medicationItems.add(entity);
			if (reverseAdd) {
				entity.setMedicationHeader(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationItemEntity to be added to this entity
	 */
	public void addMedicationItems(@NotNull Collection<MedicationItemEntity> entities) {
		addMedicationItems(entities, true);
	}

	/**
	 * Add a new collection of MedicationItemEntity to Medication Items in this entity.
	 *
	 * @param entities the given collection of MedicationItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationItems(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be set to this entity
	 */
	public void removeMedicationItems(@NotNull MedicationItemEntity entity) {
		this.removeMedicationItems(entity, true);
	}

	/**
	 * Remove the given MedicationItemEntity from this entity.
	 *
	 * @param entity the given MedicationItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationItems(@NotNull MedicationItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMedicationHeader(false);
		}
		this.medicationItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationItemEntity to be removed to this entity
	 */
	public void removeMedicationItems(@NotNull Collection<MedicationItemEntity> entities) {
		this.removeMedicationItems(entities, true);
	}

	/**
	 * Remove the given collection of MedicationItemEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationItemEntity to be set to this entity
	 */
	public void setMedicationItems(@NotNull Collection<MedicationItemEntity> entities) {
		setMedicationItems(entities, true);
	}

	/**
	 * Replace the current entities in Medication Items with the given ones.
	 *
	 * @param entities the given collection of MedicationItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationItems(@NotNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {

		this.unsetMedicationItems();
		this.medicationItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.setMedicationHeader(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationItems() {
		this.unsetMedicationItems(true);
	}

	/**
	 * Remove all the entities in Medication Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationItems(boolean doReverse) {
		if (doReverse) {
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.unsetMedicationHeader(false));
		}
		this.medicationItems.clear();
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
			this.registration.removeMedicationHeaders(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addMedicationHeaders(this, false);
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
			this.registration.removeMedicationHeaders(this, false);
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setRequestedBy(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setRequestedBy(@NotNull StaffEntity entity) {
		setRequestedBy(entity, true);
	}

	/**
	 * Set or update the requestedBy in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to requestedBy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRequestedBy(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRequestedBy here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRequestedBy here] end

		if (sameAsFormer(this.requestedBy, entity)) {
			return;
		}

		if (this.requestedBy != null) {
			this.requestedBy.removeMedicationHeaders(this, false);
		}
		this.requestedBy = entity;
		if (reverseAdd) {
			this.requestedBy.addMedicationHeaders(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRequestedBy incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRequestedBy incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRequestedBy(boolean)} but default to true.
	 */
	public void unsetRequestedBy() {
		this.unsetRequestedBy(true);
	}

	/**
	 * Remove Requested By in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRequestedBy(boolean reverse) {
		if (reverse && this.requestedBy != null) {
			this.requestedBy.removeMedicationHeaders(this, false);
		}
		this.requestedBy = null;
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
			this.warehouse.removeMedicationHeaders(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addMedicationHeaders(this, false);
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
			this.warehouse.removeMedicationHeaders(this, false);
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
		return "MEDICATION_NUMBER,DISPENSING_TYPE,ORIGINAL_MEDICATION_NUMBER,ORDER_DATE,STATUS,NOTES,IS_URGENT,IS_COMPOUND,REVISION_NO,IS_INVOICED,EXTERNAL_WAREHOUSE,RESTRICTED,REGISTRATION_ID,REQUESTED_BY_ID,WAREHOUSE_ID,INVOICE_ITEMS_IDS,INVOICE_ID,MEDICATION_COMPOUNDS_IDS,MEDICATION_ITEMS_IDS,ID";
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

		Optional<StaffEntity> requestedByRelation = Optional.ofNullable(this.requestedBy);
		requestedByRelation.ifPresent(entity -> this.requestedById = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.invoiceItemsIds = new HashSet<>();
		for (InvoiceItemEntity invoiceItems: this.invoiceItems) {
			this.invoiceItemsIds.add(invoiceItems.getId());
		}

		Optional<InvoiceEntity> invoiceRelation = Optional.ofNullable(this.invoice);
		invoiceRelation.ifPresent(entity -> this.invoiceId = entity.getId());

		this.medicationCompoundsIds = new HashSet<>();
		for (MedicationCompoundEntity medicationCompounds: this.medicationCompounds) {
			this.medicationCompoundsIds.add(medicationCompounds.getId());
		}

		this.medicationItemsIds = new HashSet<>();
		for (MedicationItemEntity medicationItems: this.medicationItems) {
			this.medicationItemsIds.add(medicationItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicationHeader) {
		if (this == medicationHeader) {
			return true;
		}
		if (medicationHeader == null || this.getClass() != medicationHeader.getClass()) {
			return false;
		}
		if (!super.equals(medicationHeader)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicationHeaderEntity that = (MedicationHeaderEntity) medicationHeader;
		return
			Objects.equals(this.medicationNumber, that.medicationNumber) &&
			Objects.equals(this.dispensingType, that.dispensingType) &&
			Objects.equals(this.originalMedicationNumber, that.originalMedicationNumber) &&
			Objects.equals(
			     this.orderDate != null ? this.orderDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.orderDate != null ? that.orderDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.status, that.status) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.isUrgent, that.isUrgent) &&
			Objects.equals(this.isCompound, that.isCompound) &&
			Objects.equals(this.revisionNo, that.revisionNo) &&
			Objects.equals(this.isInvoiced, that.isInvoiced) &&
			Objects.equals(this.externalWarehouse, that.externalWarehouse) &&
			Objects.equals(this.restricted, that.restricted) &&
			Objects.equals(this.invoiceItemsIds, that.invoiceItemsIds) &&
			Objects.equals(this.invoiceId, that.invoiceId) &&
			Objects.equals(this.medicationCompoundsIds, that.medicationCompoundsIds) &&
			Objects.equals(this.medicationItemsIds, that.medicationItemsIds) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.requestedById, that.requestedById) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
