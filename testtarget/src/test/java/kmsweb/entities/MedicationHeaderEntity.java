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
public class MedicationHeaderEntity extends AbstractEntity {

	public MedicationHeaderEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InvoiceItemsOneMany = new EntityReference();
			InvoiceItemsOneMany.entityName = "InvoiceItem";
			InvoiceItemsOneMany.oppositeName = "MedicationHeader";
			InvoiceItemsOneMany.name = "InvoiceItems";
			InvoiceItemsOneMany.optional = true;
			InvoiceItemsOneMany.type = "One";
			InvoiceItemsOneMany.oppositeType = "Many";

		References.add(InvoiceItemsOneMany);

		var InvoiceOneOne = new EntityReference();
			InvoiceOneOne.entityName = "Invoice";
			InvoiceOneOne.oppositeName = "MedicationHeader";
			InvoiceOneOne.name = "Invoice";
			InvoiceOneOne.optional = true;
			InvoiceOneOne.type = "One";
			InvoiceOneOne.oppositeType = "One";

		References.add(InvoiceOneOne);

		var MedicationCompoundsOneMany = new EntityReference();
			MedicationCompoundsOneMany.entityName = "MedicationCompound";
			MedicationCompoundsOneMany.oppositeName = "MedicationHeader";
			MedicationCompoundsOneMany.name = "MedicationCompounds";
			MedicationCompoundsOneMany.optional = true;
			MedicationCompoundsOneMany.type = "One";
			MedicationCompoundsOneMany.oppositeType = "Many";

		References.add(MedicationCompoundsOneMany);

		var RegistrationOneMany = new EntityReference();
			RegistrationOneMany.entityName = "Registration";
			RegistrationOneMany.oppositeName = "Registration";
			RegistrationOneMany.name = "MedicationHeaders";
			RegistrationOneMany.optional = true;
			RegistrationOneMany.type = "One";
			RegistrationOneMany.oppositeType = "Many";

		References.add(RegistrationOneMany);

		var RequestedByOneMany = new EntityReference();
			RequestedByOneMany.entityName = "Staff";
			RequestedByOneMany.oppositeName = "RequestedBy";
			RequestedByOneMany.name = "MedicationHeaders";
			RequestedByOneMany.optional = true;
			RequestedByOneMany.type = "One";
			RequestedByOneMany.oppositeType = "Many";

		References.add(RequestedByOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "MedicationHeaders";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);

		var MedicationItemsOneMany = new EntityReference();
			MedicationItemsOneMany.entityName = "MedicationItem";
			MedicationItemsOneMany.oppositeName = "MedicationHeader";
			MedicationItemsOneMany.name = "MedicationItems";
			MedicationItemsOneMany.optional = true;
			MedicationItemsOneMany.type = "One";
			MedicationItemsOneMany.oppositeType = "Many";

		References.add(MedicationItemsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Medication Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medication Number here] end
	private String medicationNumber;

	// % protected region % [Modify attribute annotation for Dispensing Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dispensing Type here] end
	private String dispensingType;

	// % protected region % [Modify attribute annotation for Original Medication Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Original Medication Number here] end
	private String originalMedicationNumber;

	// % protected region % [Modify attribute annotation for Order Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Order Date here] end
	private OffsetDateTime orderDate;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Is Urgent here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Urgent here] end
	private Boolean isUrgent;

	// % protected region % [Modify attribute annotation for Is Compound here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Is Compound here] end
	private Boolean isCompound;

	// % protected region % [Modify attribute annotation for Revision No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Revision No here] end
	private Integer revisionNo;

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

	// % protected region % [Modify attribute annotation for Restricted here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Restricted here] end
	private Boolean restricted;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InvoiceEntity invoice;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	private Set<MedicationCompoundEntity> medicationCompounds = new HashSet<>();

	private Set<MedicationItemEntity> medicationItems = new HashSet<>();

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
	public void setInvoice(@NonNull InvoiceEntity entity) {
		setInvoice(entity, true);
	}

	/**
	 * Set or update invoice with the given InvoiceEntity.
	 *
	 * @param entity the MedicationHeaderEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoice(@NonNull InvoiceEntity entity, boolean reverseAdd) {
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
	public void addMedicationCompounds(@NonNull MedicationCompoundEntity entity) {
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
	public void addMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities) {
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
	public void removeMedicationCompounds(@NonNull MedicationCompoundEntity entity) {
		this.removeMedicationCompounds(entity, true);
	}

	/**
	 * Remove the given MedicationCompoundEntity from this entity.
	 *
	 * @param entity the given MedicationCompoundEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationCompounds(@NonNull MedicationCompoundEntity entity, boolean reverse) {
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
	public void removeMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities) {
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
	public void setMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities) {
		setMedicationCompounds(entities, true);
	}

	/**
	 * Replace the current entities in Medication Compounds with the given ones.
	 *
	 * @param entities the given collection of MedicationCompoundEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationCompounds(@NonNull Collection<MedicationCompoundEntity> entities, boolean reverseAdd) {

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
	public void addMedicationItems(@NonNull MedicationItemEntity entity) {
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
	public void addMedicationItems(@NonNull Collection<MedicationItemEntity> entities) {
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
	public void removeMedicationItems(@NonNull MedicationItemEntity entity) {
		this.removeMedicationItems(entity, true);
	}

	/**
	 * Remove the given MedicationItemEntity from this entity.
	 *
	 * @param entity the given MedicationItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationItems(@NonNull MedicationItemEntity entity, boolean reverse) {
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
	public void removeMedicationItems(@NonNull Collection<MedicationItemEntity> entities) {
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
	public void setMedicationItems(@NonNull Collection<MedicationItemEntity> entities) {
		setMedicationItems(entities, true);
	}

	/**
	 * Replace the current entities in Medication Items with the given ones.
	 *
	 * @param entities the given collection of MedicationItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {

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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
