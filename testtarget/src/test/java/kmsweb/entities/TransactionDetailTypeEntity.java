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

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class TransactionDetailTypeEntity extends AbstractEntity {

	public TransactionDetailTypeEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InventoryAdjustmentsOneMany = new EntityReference();
			InventoryAdjustmentsOneMany.entityName = "InventoryAdjustment";
			InventoryAdjustmentsOneMany.oppositeName = "TransactionDetailType";
			InventoryAdjustmentsOneMany.name = "InventoryAdjustments";
			InventoryAdjustmentsOneMany.optional = true;
			InventoryAdjustmentsOneMany.type = "One";
			InventoryAdjustmentsOneMany.oppositeType = "Many";

		References.add(InventoryAdjustmentsOneMany);

		var StockTransactionDetailsOneMany = new EntityReference();
			StockTransactionDetailsOneMany.entityName = "StockTransactionDetail";
			StockTransactionDetailsOneMany.oppositeName = "TransactionDetailType";
			StockTransactionDetailsOneMany.name = "StockTransactionDetails";
			StockTransactionDetailsOneMany.optional = true;
			StockTransactionDetailsOneMany.type = "One";
			StockTransactionDetailsOneMany.oppositeType = "Many";

		References.add(StockTransactionDetailsOneMany);

		var StockTransactionPerDateTypesOneMany = new EntityReference();
			StockTransactionPerDateTypesOneMany.entityName = "StockTransactionPerDateType";
			StockTransactionPerDateTypesOneMany.oppositeName = "TransactionDetailType";
			StockTransactionPerDateTypesOneMany.name = "StockTransactionPerDateTypes";
			StockTransactionPerDateTypesOneMany.optional = true;
			StockTransactionPerDateTypesOneMany.type = "One";
			StockTransactionPerDateTypesOneMany.oppositeType = "Many";

		References.add(StockTransactionPerDateTypesOneMany);

		var TransactionDetailTypeMappingsOneMany = new EntityReference();
			TransactionDetailTypeMappingsOneMany.entityName = "TransactionDetailTypeMapping";
			TransactionDetailTypeMappingsOneMany.oppositeName = "TransactionDetailType";
			TransactionDetailTypeMappingsOneMany.name = "TransactionDetailTypeMappings";
			TransactionDetailTypeMappingsOneMany.optional = true;
			TransactionDetailTypeMappingsOneMany.type = "One";
			TransactionDetailTypeMappingsOneMany.oppositeType = "Many";

		References.add(TransactionDetailTypeMappingsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Transaction Detail here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Detail here] end
	private String transactionDetail;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for COA COGS here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA COGS here] end
	private String coaCOGS;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for COA Inventory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA Inventory here] end
	private String coaInventory;

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

	private Set<InventoryAdjustmentEntity> inventoryAdjustments = new HashSet<>();

	private Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();

	private Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();

	private Set<TransactionDetailTypeMappingEntity> transactionDetailTypeMappings = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	 * Similar to {@link this#addInventoryAdjustments(InventoryAdjustmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be added to this entity
	 */
	public void addInventoryAdjustments(@NonNull InventoryAdjustmentEntity entity) {
		addInventoryAdjustments(entity, true);
	}

	/**
	 * Add a new InventoryAdjustmentEntity to inventoryAdjustments in this entity.
	 *
	 * @param entity the given InventoryAdjustmentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjustments(@NonNull InventoryAdjustmentEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjustments.contains(entity)) {
			inventoryAdjustments.add(entity);
			if (reverseAdd) {
				entity.setTransactionDetailType(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjustments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be added to this entity
	 */
	public void addInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities) {
		addInventoryAdjustments(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjustmentEntity to Inventory Adjustments in this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjustments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustments(InventoryAdjustmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be set to this entity
	 */
	public void removeInventoryAdjustments(@NonNull InventoryAdjustmentEntity entity) {
		this.removeInventoryAdjustments(entity, true);
	}

	/**
	 * Remove the given InventoryAdjustmentEntity from this entity.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjustments(@NonNull InventoryAdjustmentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransactionDetailType(false);
		}
		this.inventoryAdjustments.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustments(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be removed to this entity
	 */
	public void removeInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities) {
		this.removeInventoryAdjustments(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjustmentEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjustments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjustments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be set to this entity
	 */
	public void setInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities) {
		setInventoryAdjustments(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjustments with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjustments();
		this.inventoryAdjustments = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjustments.forEach(inventoryAdjustmentsEntity -> inventoryAdjustmentsEntity.setTransactionDetailType(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustments(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjustments() {
		this.unsetInventoryAdjustments(true);
	}

	/**
	 * Remove all the entities in Inventory Adjustments from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjustments(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjustments.forEach(inventoryAdjustmentsEntity -> inventoryAdjustmentsEntity.unsetTransactionDetailType(false));
		}
		this.inventoryAdjustments.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NonNull StockTransactionDetailEntity entity) {
		addStockTransactionDetails(entity, true);
	}

	/**
	 * Add a new StockTransactionDetailEntity to stockTransactionDetails in this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionDetails(@NonNull StockTransactionDetailEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionDetails.contains(entity)) {
			stockTransactionDetails.add(entity);
			if (reverseAdd) {
				entity.setTransactionDetailType(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities) {
		addStockTransactionDetails(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionDetailEntity to Stock Transaction Details in this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be set to this entity
	 */
	public void removeStockTransactionDetails(@NonNull StockTransactionDetailEntity entity) {
		this.removeStockTransactionDetails(entity, true);
	}

	/**
	 * Remove the given StockTransactionDetailEntity from this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionDetails(@NonNull StockTransactionDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransactionDetailType(false);
		}
		this.stockTransactionDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 */
	public void removeStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities) {
		this.removeStockTransactionDetails(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be set to this entity
	 */
	public void setStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities) {
		setStockTransactionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Details with the given ones.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionDetails();
		this.stockTransactionDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.setTransactionDetailType(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionDetails() {
		this.unsetStockTransactionDetails(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionDetails(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.unsetTransactionDetailType(false));
		}
		this.stockTransactionDetails.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity) {
		addStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Add a new StockTransactionPerDateTypeEntity to stockTransactionPerDateTypes in this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionPerDateTypes.contains(entity)) {
			stockTransactionPerDateTypes.add(entity);
			if (reverseAdd) {
				entity.setTransactionDetailType(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities) {
		addStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionPerDateTypeEntity to Stock Transaction Per Date Types in this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity) {
		this.removeStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Remove the given StockTransactionPerDateTypeEntity from this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransactionDetailType(false);
		}
		this.stockTransactionPerDateTypes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities) {
		this.removeStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionPerDateTypeEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void setStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities) {
		setStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Per Date Types with the given ones.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionPerDateTypes();
		this.stockTransactionPerDateTypes = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.setTransactionDetailType(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionPerDateTypes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionPerDateTypes() {
		this.unsetStockTransactionPerDateTypes(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Per Date Types from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionPerDateTypes(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.unsetTransactionDetailType(false));
		}
		this.stockTransactionPerDateTypes.clear();
	}

/**
	 * Similar to {@link this#addTransactionDetailTypeMappings(TransactionDetailTypeMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransactionDetailTypeMappingEntity to be added to this entity
	 */
	public void addTransactionDetailTypeMappings(@NonNull TransactionDetailTypeMappingEntity entity) {
		addTransactionDetailTypeMappings(entity, true);
	}

	/**
	 * Add a new TransactionDetailTypeMappingEntity to transactionDetailTypeMappings in this entity.
	 *
	 * @param entity the given TransactionDetailTypeMappingEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTransactionDetailTypeMappings(@NonNull TransactionDetailTypeMappingEntity entity, boolean reverseAdd) {
		if (!this.transactionDetailTypeMappings.contains(entity)) {
			transactionDetailTypeMappings.add(entity);
			if (reverseAdd) {
				entity.setTransactionDetailType(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTransactionDetailTypeMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be added to this entity
	 */
	public void addTransactionDetailTypeMappings(@NonNull Collection<TransactionDetailTypeMappingEntity> entities) {
		addTransactionDetailTypeMappings(entities, true);
	}

	/**
	 * Add a new collection of TransactionDetailTypeMappingEntity to Transaction Detail Type Mappings in this entity.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTransactionDetailTypeMappings(@NonNull Collection<TransactionDetailTypeMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTransactionDetailTypeMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTransactionDetailTypeMappings(TransactionDetailTypeMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransactionDetailTypeMappingEntity to be set to this entity
	 */
	public void removeTransactionDetailTypeMappings(@NonNull TransactionDetailTypeMappingEntity entity) {
		this.removeTransactionDetailTypeMappings(entity, true);
	}

	/**
	 * Remove the given TransactionDetailTypeMappingEntity from this entity.
	 *
	 * @param entity the given TransactionDetailTypeMappingEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTransactionDetailTypeMappings(@NonNull TransactionDetailTypeMappingEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransactionDetailType(false);
		}
		this.transactionDetailTypeMappings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTransactionDetailTypeMappings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be removed to this entity
	 */
	public void removeTransactionDetailTypeMappings(@NonNull Collection<TransactionDetailTypeMappingEntity> entities) {
		this.removeTransactionDetailTypeMappings(entities, true);
	}

	/**
	 * Remove the given collection of TransactionDetailTypeMappingEntity from  to this entity.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTransactionDetailTypeMappings(@NonNull Collection<TransactionDetailTypeMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTransactionDetailTypeMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTransactionDetailTypeMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be set to this entity
	 */
	public void setTransactionDetailTypeMappings(@NonNull Collection<TransactionDetailTypeMappingEntity> entities) {
		setTransactionDetailTypeMappings(entities, true);
	}

	/**
	 * Replace the current entities in Transaction Detail Type Mappings with the given ones.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTransactionDetailTypeMappings(@NonNull Collection<TransactionDetailTypeMappingEntity> entities, boolean reverseAdd) {

		this.unsetTransactionDetailTypeMappings();
		this.transactionDetailTypeMappings = new HashSet<>(entities);
		if (reverseAdd) {
			this.transactionDetailTypeMappings.forEach(transactionDetailTypeMappingsEntity -> transactionDetailTypeMappingsEntity.setTransactionDetailType(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTransactionDetailTypeMappings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTransactionDetailTypeMappings() {
		this.unsetTransactionDetailTypeMappings(true);
	}

	/**
	 * Remove all the entities in Transaction Detail Type Mappings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTransactionDetailTypeMappings(boolean doReverse) {
		if (doReverse) {
			this.transactionDetailTypeMappings.forEach(transactionDetailTypeMappingsEntity -> transactionDetailTypeMappingsEntity.unsetTransactionDetailType(false));
		}
		this.transactionDetailTypeMappings.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
