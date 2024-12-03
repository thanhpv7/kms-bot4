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

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PrescriptionHeaderEntity extends AbstractEntity {

	public PrescriptionHeaderEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InvoiceItemsOneMany = new EntityReference();
			InvoiceItemsOneMany.entityName = "InvoiceItem";
			InvoiceItemsOneMany.oppositeName = "Prescription";
			InvoiceItemsOneMany.name = "InvoiceItems";
			InvoiceItemsOneMany.optional = true;
			InvoiceItemsOneMany.type = "One";
			InvoiceItemsOneMany.oppositeType = "Many";

		References.add(InvoiceItemsOneMany);

		var PrescriptionCompoundsOneMany = new EntityReference();
			PrescriptionCompoundsOneMany.entityName = "PrescriptionCompound";
			PrescriptionCompoundsOneMany.oppositeName = "PrescriptionHeader";
			PrescriptionCompoundsOneMany.name = "PrescriptionCompounds";
			PrescriptionCompoundsOneMany.optional = true;
			PrescriptionCompoundsOneMany.type = "One";
			PrescriptionCompoundsOneMany.oppositeType = "Many";

		References.add(PrescriptionCompoundsOneMany);

		var InvoiceOneOne = new EntityReference();
			InvoiceOneOne.entityName = "Invoice";
			InvoiceOneOne.oppositeName = "Invoice";
			InvoiceOneOne.name = "PrescriptionHeader";
			InvoiceOneOne.optional = true;
			InvoiceOneOne.type = "One";
			InvoiceOneOne.oppositeType = "One";

		References.add(InvoiceOneOne);

		var RegistrationOneMany = new EntityReference();
			RegistrationOneMany.entityName = "Registration";
			RegistrationOneMany.oppositeName = "Registration";
			RegistrationOneMany.name = "PrescriptionHeaders";
			RegistrationOneMany.optional = true;
			RegistrationOneMany.type = "One";
			RegistrationOneMany.oppositeType = "Many";

		References.add(RegistrationOneMany);

		var RequestedByOneMany = new EntityReference();
			RequestedByOneMany.entityName = "Staff";
			RequestedByOneMany.oppositeName = "RequestedBy";
			RequestedByOneMany.name = "PrescriptionHeaders";
			RequestedByOneMany.optional = true;
			RequestedByOneMany.type = "One";
			RequestedByOneMany.oppositeType = "Many";

		References.add(RequestedByOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "PrescriptionHeaders";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);

		var PrescriptionItemsOneMany = new EntityReference();
			PrescriptionItemsOneMany.entityName = "PrescriptionItem";
			PrescriptionItemsOneMany.oppositeName = "Prescription";
			PrescriptionItemsOneMany.name = "PrescriptionItems";
			PrescriptionItemsOneMany.optional = true;
			PrescriptionItemsOneMany.type = "One";
			PrescriptionItemsOneMany.oppositeType = "Many";

		References.add(PrescriptionItemsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Prescription Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Prescription Number here] end
	private String prescriptionNumber;

	// % protected region % [Modify attribute annotation for Prescription Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Prescription Type here] end
	private String prescriptionType;

	// % protected region % [Modify attribute annotation for Queue No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Queue No here] end
	private String queueNo;

	// % protected region % [Modify attribute annotation for Original Prescription Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Original Prescription Number here] end
	private String originalPrescriptionNumber;

	// % protected region % [Modify attribute annotation for Prescription Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Prescription Date here] end
	private OffsetDateTime prescriptionDate;

	// % protected region % [Modify attribute annotation for Is Compound here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Compound here] end
	private Boolean isCompound;

	// % protected region % [Modify attribute annotation for Is Iteration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Iteration here] end
	private Boolean isIteration;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Is Urgent here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Urgent here] end
	private Boolean isUrgent;

	// % protected region % [Modify attribute annotation for Restricted here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Restricted here] end
	private Boolean restricted;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Revision No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Revision No here] end
	private Integer revisionNo;

	// % protected region % [Modify attribute annotation for Copy No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Copy No here] end
	private Integer copyNo;

	// % protected region % [Modify attribute annotation for Is Invoiced here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Invoiced here] end
	private Boolean isInvoiced;

	// % protected region % [Modify attribute annotation for External Warehouse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for External Warehouse here] end
	private Boolean externalWarehouse;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InvoiceEntity invoice;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	private Set<PrescriptionCompoundEntity> prescriptionCompounds = new HashSet<>();

	private Set<PrescriptionItemEntity> prescriptionItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private RegistrationEntity registration;

	private StaffEntity requestedBy;

	private WarehouseEntity warehouse;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
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
	 * Similar to {@link this#addInvoiceItems(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be added to this entity
	 */
	public void addInvoiceItems(@NonNull InvoiceItemEntity entity) {
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
	public void addInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
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
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity) {
		this.removeInvoiceItems(entity, true);
	}

	/**
	 * Remove the given InvoiceItemEntity from this entity.
	 *
	 * @param entity the given InvoiceItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoiceItems(@NonNull InvoiceItemEntity entity, boolean reverse) {
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
	public void removeInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
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
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities) {
		setInvoiceItems(entities, true);
	}

	/**
	 * Replace the current entities in Invoice Items with the given ones.
	 *
	 * @param entities the given collection of InvoiceItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoiceItems(@NonNull Collection<InvoiceItemEntity> entities, boolean reverseAdd) {

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
	public void addPrescriptionCompounds(@NonNull PrescriptionCompoundEntity entity) {
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
	public void addPrescriptionCompounds(@NonNull Collection<PrescriptionCompoundEntity> entities) {
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
	public void removePrescriptionCompounds(@NonNull PrescriptionCompoundEntity entity) {
		this.removePrescriptionCompounds(entity, true);
	}

	/**
	 * Remove the given PrescriptionCompoundEntity from this entity.
	 *
	 * @param entity the given PrescriptionCompoundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionCompounds(@NonNull PrescriptionCompoundEntity entity, boolean reverse) {
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
	public void removePrescriptionCompounds(@NonNull Collection<PrescriptionCompoundEntity> entities) {
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
	public void setPrescriptionCompounds(@NonNull Collection<PrescriptionCompoundEntity> entities) {
		setPrescriptionCompounds(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Compounds with the given ones.
	 *
	 * @param entities the given collection of PrescriptionCompoundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionCompounds(@NonNull Collection<PrescriptionCompoundEntity> entities, boolean reverseAdd) {

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
	public void addPrescriptionItems(@NonNull PrescriptionItemEntity entity) {
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
	public void addPrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities) {
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
	public void removePrescriptionItems(@NonNull PrescriptionItemEntity entity) {
		this.removePrescriptionItems(entity, true);
	}

	/**
	 * Remove the given PrescriptionItemEntity from this entity.
	 *
	 * @param entity the given PrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionItems(@NonNull PrescriptionItemEntity entity, boolean reverse) {
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
	public void removePrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities) {
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
	public void setPrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities) {
		setPrescriptionItems(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Items with the given ones.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionItems(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {

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
	public void setRegistration(@NonNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NonNull RegistrationEntity entity, boolean reverseAdd) {
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
	public void setRequestedBy(@NonNull StaffEntity entity) {
		setRequestedBy(entity, true);
	}

	/**
	 * Set or update the requestedBy in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to requestedBy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRequestedBy(@NonNull StaffEntity entity, boolean reverseAdd) {
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
	public void setWarehouse(@NonNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NonNull WarehouseEntity entity, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
