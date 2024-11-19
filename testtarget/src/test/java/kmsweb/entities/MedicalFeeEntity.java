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

import kmsweb.entities.enums.*;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class MedicalFeeEntity extends AbstractEntity {

	public MedicalFeeEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InvoiceItemsOneMany = new EntityReference();
			InvoiceItemsOneMany.entityName = "InvoiceItem";
			InvoiceItemsOneMany.oppositeName = "MedicalFee";
			InvoiceItemsOneMany.name = "InvoiceItems";
			InvoiceItemsOneMany.optional = true;
			InvoiceItemsOneMany.type = "One";
			InvoiceItemsOneMany.oppositeType = "Many";

		References.add(InvoiceItemsOneMany);

		var MedicalFeeItemComponentsOneMany = new EntityReference();
			MedicalFeeItemComponentsOneMany.entityName = "MedicalFeeItemComponent";
			MedicalFeeItemComponentsOneMany.oppositeName = "MedicalFee";
			MedicalFeeItemComponentsOneMany.name = "MedicalFeeItemComponents";
			MedicalFeeItemComponentsOneMany.optional = true;
			MedicalFeeItemComponentsOneMany.type = "One";
			MedicalFeeItemComponentsOneMany.oppositeType = "Many";

		References.add(MedicalFeeItemComponentsOneMany);

		var RegistrationOneMany = new EntityReference();
			RegistrationOneMany.entityName = "Registration";
			RegistrationOneMany.oppositeName = "Registration";
			RegistrationOneMany.name = "MedicalFees";
			RegistrationOneMany.optional = true;
			RegistrationOneMany.type = "One";
			RegistrationOneMany.oppositeType = "Many";

		References.add(RegistrationOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "MedicalFees";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Tariff Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Type here] end
	private TariffTypeEnum tariffType;

	// % protected region % [Modify attribute annotation for Tariff Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for Pharmacy Transaction Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pharmacy Transaction Type here] end
	private PharmacyTypeEnum pharmacyTransactionType;

	// % protected region % [Modify attribute annotation for Pharmacy Transaction Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pharmacy Transaction Number here] end
	private String pharmacyTransactionNumber;

	// % protected region % [Modify attribute annotation for Medication Transaction Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medication Transaction Number here] end
	private String medicationTransactionNumber;

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity here] end
	private Double quantity;

	// % protected region % [Modify attribute annotation for Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit here] end
	private String unit;

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Hospital Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Price here] end
	private Double hospitalPrice;

	// % protected region % [Modify attribute annotation for Other Component Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Component Price here] end
	private Double otherComponentPrice;

	// % protected region % [Modify attribute annotation for Medical Staff Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medical Staff Code here] end
	private String medicalStaffCode;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for medical fee status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for medical fee status here] end
	private MedicalFeeStatusEnum medicalFeeStatus;

	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] end
	private Double inventoryRoundingValue;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<InvoiceItemEntity> invoiceItems = new HashSet<>();

	private Set<MedicalFeeItemComponentEntity> medicalFeeItemComponents = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private RegistrationEntity registration;

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
	public void addMedicalFeeItemComponents(@NonNull MedicalFeeItemComponentEntity entity) {
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
	public void addMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities) {
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
	public void removeMedicalFeeItemComponents(@NonNull MedicalFeeItemComponentEntity entity) {
		this.removeMedicalFeeItemComponents(entity, true);
	}

	/**
	 * Remove the given MedicalFeeItemComponentEntity from this entity.
	 *
	 * @param entity the given MedicalFeeItemComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicalFeeItemComponents(@NonNull MedicalFeeItemComponentEntity entity, boolean reverse) {
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
	public void removeMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities) {
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
	public void setMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities) {
		setMedicalFeeItemComponents(entities, true);
	}

	/**
	 * Replace the current entities in Medical Fee Item Components with the given ones.
	 *
	 * @param entities the given collection of MedicalFeeItemComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicalFeeItemComponents(@NonNull Collection<MedicalFeeItemComponentEntity> entities, boolean reverseAdd) {

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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
