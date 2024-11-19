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
public class InventoryAdjustmentEntity extends AbstractEntity {

	public InventoryAdjustmentEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InventoryAdjustmentItemsOneMany = new EntityReference();
			InventoryAdjustmentItemsOneMany.entityName = "InventoryAdjustmentItem";
			InventoryAdjustmentItemsOneMany.oppositeName = "InventoryAdjustment";
			InventoryAdjustmentItemsOneMany.name = "InventoryAdjustmentItems";
			InventoryAdjustmentItemsOneMany.optional = true;
			InventoryAdjustmentItemsOneMany.type = "One";
			InventoryAdjustmentItemsOneMany.oppositeType = "Many";

		References.add(InventoryAdjustmentItemsOneMany);

		var TransactionDetailTypeOneMany = new EntityReference();
			TransactionDetailTypeOneMany.entityName = "TransactionDetailType";
			TransactionDetailTypeOneMany.oppositeName = "TransactionDetailType";
			TransactionDetailTypeOneMany.name = "InventoryAdjustments";
			TransactionDetailTypeOneMany.optional = true;
			TransactionDetailTypeOneMany.type = "One";
			TransactionDetailTypeOneMany.oppositeType = "Many";

		References.add(TransactionDetailTypeOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "InventoryAdjustments";
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

	// % protected region % [Modify attribute annotation for Adjustment Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Adjustment Number here] end
	private String adjustmentNumber;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Transaction Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Type here] end
	private String transactionType;

	// % protected region % [Modify attribute annotation for Reference Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Reference Number here] end
	private String referenceNumber;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Void Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Void Date here] end
	private OffsetDateTime voidDate;

	// % protected region % [Modify attribute annotation for Void Reason here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Void Reason here] end
	private String voidReason;

	// % protected region % [Modify attribute annotation for Adjustment Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Adjustment Type here] end
	private String adjustmentType;

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

	private Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private TransactionDetailTypeEntity transactionDetailType;

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
	 * Similar to {@link this#addInventoryAdjustmentItems(InventoryAdjustmentItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be added to this entity
	 */
	public void addInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity) {
		addInventoryAdjustmentItems(entity, true);
	}

	/**
	 * Add a new InventoryAdjustmentItemEntity to inventoryAdjustmentItems in this entity.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjustmentItems.contains(entity)) {
			inventoryAdjustmentItems.add(entity);
			if (reverseAdd) {
				entity.setInventoryAdjustment(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be added to this entity
	 */
	public void addInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities) {
		addInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjustmentItemEntity to Inventory Adjustment Items in this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjustmentItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustmentItems(InventoryAdjustmentItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be set to this entity
	 */
	public void removeInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity) {
		this.removeInventoryAdjustmentItems(entity, true);
	}

	/**
	 * Remove the given InventoryAdjustmentItemEntity from this entity.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInventoryAdjustment(false);
		}
		this.inventoryAdjustmentItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be removed to this entity
	 */
	public void removeInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities) {
		this.removeInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjustmentItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjustmentItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be set to this entity
	 */
	public void setInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities) {
		setInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjustment Items with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjustmentItems();
		this.inventoryAdjustmentItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjustmentItems.forEach(inventoryAdjustmentItemsEntity -> inventoryAdjustmentItemsEntity.setInventoryAdjustment(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustmentItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjustmentItems() {
		this.unsetInventoryAdjustmentItems(true);
	}

	/**
	 * Remove all the entities in Inventory Adjustment Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjustmentItems(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjustmentItems.forEach(inventoryAdjustmentItemsEntity -> inventoryAdjustmentItemsEntity.unsetInventoryAdjustment(false));
		}
		this.inventoryAdjustmentItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setTransactionDetailType(TransactionDetailTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransactionDetailTypeEntity to be set to this entity
	 */
	public void setTransactionDetailType(@NonNull TransactionDetailTypeEntity entity) {
		setTransactionDetailType(entity, true);
	}

	/**
	 * Set or update the transactionDetailType in this entity with single TransactionDetailTypeEntity.
	 *
	 * @param entity the given TransactionDetailTypeEntity to be set or updated to transactionDetailType
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTransactionDetailType(@NonNull TransactionDetailTypeEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTransactionDetailType here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTransactionDetailType here] end

		if (sameAsFormer(this.transactionDetailType, entity)) {
			return;
		}

		if (this.transactionDetailType != null) {
			this.transactionDetailType.removeInventoryAdjustments(this, false);
		}
		this.transactionDetailType = entity;
		if (reverseAdd) {
			this.transactionDetailType.addInventoryAdjustments(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTransactionDetailType incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTransactionDetailType incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTransactionDetailType(boolean)} but default to true.
	 */
	public void unsetTransactionDetailType() {
		this.unsetTransactionDetailType(true);
	}

	/**
	 * Remove Transaction Detail Type in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTransactionDetailType(boolean reverse) {
		if (reverse && this.transactionDetailType != null) {
			this.transactionDetailType.removeInventoryAdjustments(this, false);
		}
		this.transactionDetailType = null;
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
			this.warehouse.removeInventoryAdjustments(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addInventoryAdjustments(this, false);
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
			this.warehouse.removeInventoryAdjustments(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
