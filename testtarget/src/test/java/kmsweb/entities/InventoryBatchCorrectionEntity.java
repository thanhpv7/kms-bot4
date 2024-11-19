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
public class InventoryBatchCorrectionEntity extends AbstractEntity {

	public InventoryBatchCorrectionEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InventoryBatchCorrectionItemsOneMany = new EntityReference();
			InventoryBatchCorrectionItemsOneMany.entityName = "InventoryBatchCorrectionItem";
			InventoryBatchCorrectionItemsOneMany.oppositeName = "InventoryBatchCorrection";
			InventoryBatchCorrectionItemsOneMany.name = "InventoryBatchCorrectionItems";
			InventoryBatchCorrectionItemsOneMany.optional = true;
			InventoryBatchCorrectionItemsOneMany.type = "One";
			InventoryBatchCorrectionItemsOneMany.oppositeType = "Many";

		References.add(InventoryBatchCorrectionItemsOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "InventoryBatchCorrections";
			WarehouseOneMany.optional = false;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Batch Correction Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Batch Correction Number here] end
	private String batchCorrectionNumber;

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
	private BatchCorrectionTypeEnum transactionType;

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

	private Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	 * Similar to {@link this#addInventoryBatchCorrectionItems(InventoryBatchCorrectionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be added to this entity
	 */
	public void addInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity) {
		addInventoryBatchCorrectionItems(entity, true);
	}

	/**
	 * Add a new InventoryBatchCorrectionItemEntity to inventoryBatchCorrectionItems in this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity, boolean reverseAdd) {
		if (!this.inventoryBatchCorrectionItems.contains(entity)) {
			inventoryBatchCorrectionItems.add(entity);
			if (reverseAdd) {
				entity.setInventoryBatchCorrection(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be added to this entity
	 */
	public void addInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		addInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Add a new collection of InventoryBatchCorrectionItemEntity to Inventory Batch Correction Items in this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryBatchCorrectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrectionItems(InventoryBatchCorrectionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be set to this entity
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity) {
		this.removeInventoryBatchCorrectionItems(entity, true);
	}

	/**
	 * Remove the given InventoryBatchCorrectionItemEntity from this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInventoryBatchCorrection(false);
		}
		this.inventoryBatchCorrectionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be removed to this entity
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		this.removeInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Remove the given collection of InventoryBatchCorrectionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryBatchCorrectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be set to this entity
	 */
	public void setInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		setInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Batch Correction Items with the given ones.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {

		this.unsetInventoryBatchCorrectionItems();
		this.inventoryBatchCorrectionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryBatchCorrectionItems.forEach(inventoryBatchCorrectionItemsEntity -> inventoryBatchCorrectionItemsEntity.setInventoryBatchCorrection(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryBatchCorrectionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryBatchCorrectionItems() {
		this.unsetInventoryBatchCorrectionItems(true);
	}

	/**
	 * Remove all the entities in Inventory Batch Correction Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryBatchCorrectionItems(boolean doReverse) {
		if (doReverse) {
			this.inventoryBatchCorrectionItems.forEach(inventoryBatchCorrectionItemsEntity -> inventoryBatchCorrectionItemsEntity.unsetInventoryBatchCorrection(false));
		}
		this.inventoryBatchCorrectionItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
			this.warehouse.removeInventoryBatchCorrections(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addInventoryBatchCorrections(this, false);
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
			this.warehouse.removeInventoryBatchCorrections(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
