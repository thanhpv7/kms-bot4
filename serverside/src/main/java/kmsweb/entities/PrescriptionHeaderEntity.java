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
import kmsweb.dtos.PrescriptionHeaderEntityDto;
import kmsweb.entities.listeners.PrescriptionHeaderEntityListener;
import kmsweb.serializers.PrescriptionHeaderSerializer;
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
@EntityListeners({PrescriptionHeaderEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PrescriptionHeaderSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PrescriptionHeaderEntity extends AbstractEntity {

	/**
	 * Takes a PrescriptionHeaderEntityDto and converts it into a PrescriptionHeaderEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param prescriptionHeaderEntityDto
	 */
	public PrescriptionHeaderEntity(PrescriptionHeaderEntityDto prescriptionHeaderEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (prescriptionHeaderEntityDto.getId() != null) {
			this.setId(prescriptionHeaderEntityDto.getId());
		}

		if (prescriptionHeaderEntityDto.getPrescriptionNumber() != null) {
			this.setPrescriptionNumber(prescriptionHeaderEntityDto.getPrescriptionNumber());
		}

		if (prescriptionHeaderEntityDto.getPrescriptionType() != null) {
			this.setPrescriptionType(prescriptionHeaderEntityDto.getPrescriptionType());
		}

		if (prescriptionHeaderEntityDto.getQueueNo() != null) {
			this.setQueueNo(prescriptionHeaderEntityDto.getQueueNo());
		}

		if (prescriptionHeaderEntityDto.getOriginalPrescriptionNumber() != null) {
			this.setOriginalPrescriptionNumber(prescriptionHeaderEntityDto.getOriginalPrescriptionNumber());
		}

		if (prescriptionHeaderEntityDto.getPrescriptionDate() != null) {
			this.setPrescriptionDate(prescriptionHeaderEntityDto.getPrescriptionDate());
		}

		if (prescriptionHeaderEntityDto.getIsCompound() != null) {
			this.setIsCompound(prescriptionHeaderEntityDto.getIsCompound());
		}

		if (prescriptionHeaderEntityDto.getIsIteration() != null) {
			this.setIsIteration(prescriptionHeaderEntityDto.getIsIteration());
		}

		if (prescriptionHeaderEntityDto.getStatus() != null) {
			this.setStatus(prescriptionHeaderEntityDto.getStatus());
		}

		if (prescriptionHeaderEntityDto.getIsUrgent() != null) {
			this.setIsUrgent(prescriptionHeaderEntityDto.getIsUrgent());
		}

		if (prescriptionHeaderEntityDto.getRestricted() != null) {
			this.setRestricted(prescriptionHeaderEntityDto.getRestricted());
		}

		if (prescriptionHeaderEntityDto.getNotes() != null) {
			this.setNotes(prescriptionHeaderEntityDto.getNotes());
		}

		if (prescriptionHeaderEntityDto.getRevisionNo() != null) {
			this.setRevisionNo(prescriptionHeaderEntityDto.getRevisionNo());
		}

		if (prescriptionHeaderEntityDto.getCopyNo() != null) {
			this.setCopyNo(prescriptionHeaderEntityDto.getCopyNo());
		}

		if (prescriptionHeaderEntityDto.getIsInvoiced() != null) {
			this.setIsInvoiced(prescriptionHeaderEntityDto.getIsInvoiced());
		}

		if (prescriptionHeaderEntityDto.getExternalWarehouse() != null) {
			this.setExternalWarehouse(prescriptionHeaderEntityDto.getExternalWarehouse());
		}

		if (prescriptionHeaderEntityDto.getInvoiceItems() != null) {
			this.setInvoiceItems(prescriptionHeaderEntityDto.getInvoiceItems());
		}

		if (prescriptionHeaderEntityDto.getPrescriptionCompounds() != null) {
			this.setPrescriptionCompounds(prescriptionHeaderEntityDto.getPrescriptionCompounds());
		}

		if (prescriptionHeaderEntityDto.getPrescriptionItems() != null) {
			this.setPrescriptionItems(prescriptionHeaderEntityDto.getPrescriptionItems());
		}

		if (prescriptionHeaderEntityDto.getInvoice() != null) {
			this.setInvoice(prescriptionHeaderEntityDto.getInvoice());
		}

		if (prescriptionHeaderEntityDto.getRegistration() != null) {
			this.setRegistration(prescriptionHeaderEntityDto.getRegistration());
		}

		if (prescriptionHeaderEntityDto.getRequestedBy() != null) {
			this.setRequestedBy(prescriptionHeaderEntityDto.getRequestedBy());
		}

		if (prescriptionHeaderEntityDto.getWarehouse() != null) {
			this.setWarehouse(prescriptionHeaderEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Prescription Number here] off begin
	@CsvBindByName(column = "PRESCRIPTION_NUMBER", required = true)
	@NotNull(message = "Prescription Number must not be empty")
	@Column(name = "prescription_number")
	@Schema(description = "The Prescription Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Prescription Number here] end
	private String prescriptionNumber;

	// % protected region % [Modify attribute annotation for Prescription Type here] off begin
	@CsvBindByName(column = "PRESCRIPTION_TYPE", required = true)
	@NotNull(message = "Prescription Type must not be empty")
	@Column(name = "prescription_type")
	@Schema(description = "The Prescription Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Prescription Type here] end
	private String prescriptionType;

	// % protected region % [Modify attribute annotation for Queue No here] off begin
	@CsvBindByName(column = "QUEUE_NO", required = false)
	@Nullable
	@Column(name = "queue_no")
	@Schema(description = "The Queue No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Queue No here] end
	private String queueNo;

	// % protected region % [Modify attribute annotation for Original Prescription Number here] off begin
	@CsvBindByName(column = "ORIGINAL_PRESCRIPTION_NUMBER", required = false)
	@Nullable
	@Column(name = "original_prescription_number")
	@Schema(description = "The Original Prescription Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Original Prescription Number here] end
	private String originalPrescriptionNumber;

	// % protected region % [Modify attribute annotation for Prescription Date here] off begin
	@CsvCustomBindByName(column = "PRESCRIPTION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "prescription_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Prescription Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Prescription Date here] end
	private OffsetDateTime prescriptionDate;

	// % protected region % [Modify attribute annotation for Is Compound here] off begin
	@CsvBindByName(column = "IS_COMPOUND", required = false)
	@Nullable
	@Column(name = "is_compound")
	@Schema(description = "The Is Compound of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Compound here] end
	private Boolean isCompound = false ;

	// % protected region % [Modify attribute annotation for Is Iteration here] off begin
	@CsvBindByName(column = "IS_ITERATION", required = false)
	@Nullable
	@Column(name = "is_iteration")
	@Schema(description = "The Is Iteration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Iteration here] end
	private Boolean isIteration = false ;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@CsvBindByName(column = "STATUS", required = false)
	@Nullable
	@Column(name = "status")
	@Schema(description = "The Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Is Urgent here] off begin
	@CsvBindByName(column = "IS_URGENT", required = false)
	@Nullable
	@Column(name = "is_urgent")
	@Schema(description = "The Is Urgent of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Urgent here] end
	private Boolean isUrgent = false ;

	// % protected region % [Modify attribute annotation for Restricted here] off begin
	@CsvBindByName(column = "RESTRICTED", required = false)
	@Nullable
	@Column(name = "restricted")
	@Schema(description = "The Restricted of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Restricted here] end
	private Boolean restricted = false ;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Revision No here] off begin
	@CsvBindByName(column = "REVISION_NO", required = false)
	@Nullable
	@Column(name = "revision_no")
	@Schema(description = "The Revision No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Revision No here] end
	private Integer revisionNo;

	// % protected region % [Modify attribute annotation for Copy No here] off begin
	@CsvBindByName(column = "COPY_NO", required = false)
	@Nullable
	@Column(name = "copy_no")
	@Schema(description = "The Copy No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Copy No here] end
	private Integer copyNo;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Invoice Items here] off begin
	@Schema(description = "The Invoice Item entities that are related to this entity.")
	@OneToMany(mappedBy = "prescription", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice Items here] end
	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	// % protected region % [Update the annotation for invoiceItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoiceItemsIds here] end
	private Set<UUID> invoiceItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Prescription Compounds here] off begin
	@Schema(description = "The Prescription Compound entities that are related to this entity.")
	@OneToMany(mappedBy = "prescriptionHeader", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription Compounds here] end
	private Set<PrescriptionCompoundEntity> prescriptionCompounds = new HashSet<>();

	// % protected region % [Update the annotation for prescriptionCompoundsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_COMPOUNDS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for prescriptionCompoundsIds here] end
	private Set<UUID> prescriptionCompoundsIds = new HashSet<>();

	// % protected region % [Update the annotation for Prescription Items here] off begin
	@Schema(description = "The Prescription Item entities that are related to this entity.")
	@OneToMany(mappedBy = "prescription", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription Items here] end
	private Set<PrescriptionItemEntity> prescriptionItems = new HashSet<>();

	// % protected region % [Update the annotation for prescriptionItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for prescriptionItemsIds here] end
	private Set<UUID> prescriptionItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Invoice here] off begin
	@Schema(description = "The Invoice entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoice here] end
	private InvoiceEntity invoice;

	// % protected region % [Update the annotation for invoiceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for invoiceId here] end
	private UUID invoiceId;

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
				entity.setPrescription(this, false);
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
			entity.unsetPrescription(false);
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
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.setPrescription(this, false));
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
			this.invoiceItems.forEach(invoiceItemsEntity -> invoiceItemsEntity.unsetPrescription(false));
		}
		this.invoiceItems.clear();
	}

/**
	 * Similar to {@link this#addPrescriptionCompounds(PrescriptionCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be added to this entity
	 */
	public void addPrescriptionCompounds(@NotNull PrescriptionCompoundEntity entity) {
		addPrescriptionCompounds(entity, true);
	}

	/**
	 * Add a new PrescriptionCompoundEntity to prescriptionCompounds in this entity.
	 *
	 * @param entity the given PrescriptionCompoundEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrescriptionCompounds(@NonNull PrescriptionCompoundEntity entity, boolean reverseAdd) {
		if (!this.prescriptionCompounds.contains(entity)) {
			prescriptionCompounds.add(entity);
			if (reverseAdd) {
				entity.setPrescriptionHeader(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrescriptionCompounds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be added to this entity
	 */
	public void addPrescriptionCompounds(@NotNull Collection<PrescriptionCompoundEntity> entities) {
		addPrescriptionCompounds(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionCompoundEntity to Prescription Compounds in this entity.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrescriptionCompounds(@NonNull Collection<PrescriptionCompoundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrescriptionCompounds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrescriptionCompounds(PrescriptionCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be set to this entity
	 */
	public void removePrescriptionCompounds(@NotNull PrescriptionCompoundEntity entity) {
		this.removePrescriptionCompounds(entity, true);
	}

	/**
	 * Remove the given PrescriptionCompoundEntity from this entity.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionCompounds(@NotNull PrescriptionCompoundEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPrescriptionHeader(false);
		}
		this.prescriptionCompounds.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrescriptionCompounds(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be removed to this entity
	 */
	public void removePrescriptionCompounds(@NotNull Collection<PrescriptionCompoundEntity> entities) {
		this.removePrescriptionCompounds(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionCompoundEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrescriptionCompounds(@NonNull Collection<PrescriptionCompoundEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrescriptionCompounds(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrescriptionCompounds(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to be set to this entity
	 */
	public void setPrescriptionCompounds(@NotNull Collection<PrescriptionCompoundEntity> entities) {
		setPrescriptionCompounds(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Compounds with the given ones.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionCompounds(@NotNull Collection<PrescriptionCompoundEntity> entities, boolean reverseAdd) {

		this.unsetPrescriptionCompounds();
		this.prescriptionCompounds = new HashSet<>(entities);
		if (reverseAdd) {
			this.prescriptionCompounds.forEach(prescriptionCompoundsEntity -> prescriptionCompoundsEntity.setPrescriptionHeader(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrescriptionCompounds(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrescriptionCompounds() {
		this.unsetPrescriptionCompounds(true);
	}

	/**
	 * Remove all the entities in Prescription Compounds from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrescriptionCompounds(boolean doReverse) {
		if (doReverse) {
			this.prescriptionCompounds.forEach(prescriptionCompoundsEntity -> prescriptionCompoundsEntity.unsetPrescriptionHeader(false));
		}
		this.prescriptionCompounds.clear();
	}

/**
	 * Similar to {@link this#addPrescriptionItems(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be added to this entity
	 */
	public void addPrescriptionItems(@NotNull PrescriptionItemEntity entity) {
		addPrescriptionItems(entity, true);
	}

	/**
	 * Add a new PrescriptionItemEntity to prescriptionItems in this entity.
	 *
	 * @param entity the given PrescriptionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrescriptionItems(@NonNull PrescriptionItemEntity entity, boolean reverseAdd) {
		if (!this.prescriptionItems.contains(entity)) {
			prescriptionItems.add(entity);
			if (reverseAdd) {
				entity.setPrescription(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 */
	public void addPrescriptionItems(@NotNull Collection<PrescriptionItemEntity> entities) {
		addPrescriptionItems(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionItemEntity to Prescription Items in this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrescriptionItems(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be set to this entity
	 */
	public void removePrescriptionItems(@NotNull PrescriptionItemEntity entity) {
		this.removePrescriptionItems(entity, true);
	}

	/**
	 * Remove the given PrescriptionItemEntity from this entity.
	 *
	 * @param entity the given PrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionItems(@NotNull PrescriptionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPrescription(false);
		}
		this.prescriptionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrescriptionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 */
	public void removePrescriptionItems(@NotNull Collection<PrescriptionItemEntity> entities) {
		this.removePrescriptionItems(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be set to this entity
	 */
	public void setPrescriptionItems(@NotNull Collection<PrescriptionItemEntity> entities) {
		setPrescriptionItems(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Items with the given ones.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionItems(@NotNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {

		this.unsetPrescriptionItems();
		this.prescriptionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.prescriptionItems.forEach(prescriptionItemsEntity -> prescriptionItemsEntity.setPrescription(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrescriptionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrescriptionItems() {
		this.unsetPrescriptionItems(true);
	}

	/**
	 * Remove all the entities in Prescription Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrescriptionItems(boolean doReverse) {
		if (doReverse) {
			this.prescriptionItems.forEach(prescriptionItemsEntity -> prescriptionItemsEntity.unsetPrescription(false));
		}
		this.prescriptionItems.clear();
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
	public void setInvoice(InvoiceEntity entity) {
		setInvoice(entity, true);
	}

	/**
	 * Set or update the invoice in this entity with single InvoiceEntity.
	 *
	 * @param entity the given InvoiceEntity to be set or updated to invoice
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoice(InvoiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoice here] end

		if (sameAsFormer(this.invoice, entity)) {
			return;
		}

		if (this.invoice != null) {
			this.invoice.unsetPrescriptionHeader(false);
		}

		this.invoice = entity;
		if (reverseAdd) {
			this.invoice.setPrescriptionHeader(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoice incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetInvoice(boolean)} but default to true.
	 */
	public void unsetInvoice() {
		this.unsetInvoice(true);
	}

	/**
	 * Remove the InvoiceEntity of invoice from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoice(boolean reverse) {
		if (reverse && this.invoice != null) {
			this.invoice.unsetPrescriptionHeader();
		}
		this.invoice = null;
	}
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
			this.registration.removePrescriptionHeaders(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addPrescriptionHeaders(this, false);
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
			this.registration.removePrescriptionHeaders(this, false);
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
			this.requestedBy.removePrescriptionHeaders(this, false);
		}
		this.requestedBy = entity;
		if (reverseAdd) {
			this.requestedBy.addPrescriptionHeaders(this, false);
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
			this.requestedBy.removePrescriptionHeaders(this, false);
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
			this.warehouse.removePrescriptionHeaders(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addPrescriptionHeaders(this, false);
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
			this.warehouse.removePrescriptionHeaders(this, false);
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
		return "PRESCRIPTION_NUMBER,PRESCRIPTION_TYPE,QUEUE_NO,ORIGINAL_PRESCRIPTION_NUMBER,PRESCRIPTION_DATE,IS_COMPOUND,IS_ITERATION,STATUS,IS_URGENT,RESTRICTED,NOTES,REVISION_NO,COPY_NO,IS_INVOICED,EXTERNAL_WAREHOUSE,INVOICE_ID,REGISTRATION_ID,REQUESTED_BY_ID,WAREHOUSE_ID,INVOICE_ITEMS_IDS,PRESCRIPTION_COMPOUNDS_IDS,PRESCRIPTION_ITEMS_IDS,ID";
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

		this.prescriptionCompoundsIds = new HashSet<>();
		for (PrescriptionCompoundEntity prescriptionCompounds: this.prescriptionCompounds) {
			this.prescriptionCompoundsIds.add(prescriptionCompounds.getId());
		}

		this.prescriptionItemsIds = new HashSet<>();
		for (PrescriptionItemEntity prescriptionItems: this.prescriptionItems) {
			this.prescriptionItemsIds.add(prescriptionItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object prescriptionHeader) {
		if (this == prescriptionHeader) {
			return true;
		}
		if (prescriptionHeader == null || this.getClass() != prescriptionHeader.getClass()) {
			return false;
		}
		if (!super.equals(prescriptionHeader)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PrescriptionHeaderEntity that = (PrescriptionHeaderEntity) prescriptionHeader;
		return
			Objects.equals(this.prescriptionNumber, that.prescriptionNumber) &&
			Objects.equals(this.prescriptionType, that.prescriptionType) &&
			Objects.equals(this.queueNo, that.queueNo) &&
			Objects.equals(this.originalPrescriptionNumber, that.originalPrescriptionNumber) &&
			Objects.equals(
			     this.prescriptionDate != null ? this.prescriptionDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.prescriptionDate != null ? that.prescriptionDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.isCompound, that.isCompound) &&
			Objects.equals(this.isIteration, that.isIteration) &&
			Objects.equals(this.status, that.status) &&
			Objects.equals(this.isUrgent, that.isUrgent) &&
			Objects.equals(this.restricted, that.restricted) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.revisionNo, that.revisionNo) &&
			Objects.equals(this.copyNo, that.copyNo) &&
			Objects.equals(this.isInvoiced, that.isInvoiced) &&
			Objects.equals(this.externalWarehouse, that.externalWarehouse) &&
			Objects.equals(this.invoiceItemsIds, that.invoiceItemsIds) &&
			Objects.equals(this.prescriptionCompoundsIds, that.prescriptionCompoundsIds) &&
			Objects.equals(this.prescriptionItemsIds, that.prescriptionItemsIds) &&
			Objects.equals(this.invoiceId, that.invoiceId) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.requestedById, that.requestedById) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
