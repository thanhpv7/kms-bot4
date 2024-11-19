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
public class PurchaseRequisitionEntity extends AbstractEntity {

	public PurchaseRequisitionEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PurchaseRequisitionStockDetailsOneMany = new EntityReference();
			PurchaseRequisitionStockDetailsOneMany.entityName = "PurchaseRequisitionStockDetail";
			PurchaseRequisitionStockDetailsOneMany.oppositeName = "PurchaseRequisition";
			PurchaseRequisitionStockDetailsOneMany.name = "PurchaseRequisitionStockDetails";
			PurchaseRequisitionStockDetailsOneMany.optional = true;
			PurchaseRequisitionStockDetailsOneMany.type = "One";
			PurchaseRequisitionStockDetailsOneMany.oppositeType = "Many";

		References.add(PurchaseRequisitionStockDetailsOneMany);

		var PurchaseOrderOneMany = new EntityReference();
			PurchaseOrderOneMany.entityName = "PurchaseOrder";
			PurchaseOrderOneMany.oppositeName = "PurchaseOrder";
			PurchaseOrderOneMany.name = "PurchaseRequisitions";
			PurchaseOrderOneMany.optional = true;
			PurchaseOrderOneMany.type = "One";
			PurchaseOrderOneMany.oppositeType = "Many";

		References.add(PurchaseOrderOneMany);

		var SupplierOneMany = new EntityReference();
			SupplierOneMany.entityName = "Supplier";
			SupplierOneMany.oppositeName = "Supplier";
			SupplierOneMany.name = "PurchaseRequisitions";
			SupplierOneMany.optional = true;
			SupplierOneMany.type = "One";
			SupplierOneMany.oppositeType = "Many";

		References.add(SupplierOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "PurchaseRequisitions";
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

	// % protected region % [Modify attribute annotation for Purchase Requisition Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Purchase Requisition Number here] end
	private String purchaseRequisitionNumber;

	// % protected region % [Modify attribute annotation for Transaction Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Status here] end
	private String transactionStatus;

	// % protected region % [Modify attribute annotation for Reference Document here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Reference Document here] end
	private String referenceDocument;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Order Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Order Date here] end
	private OffsetDateTime orderDate;

	// % protected region % [Modify attribute annotation for Required Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Required Date here] end
	private OffsetDateTime requiredDate;

	// % protected region % [Modify attribute annotation for Total Estimation Order here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Estimation Order here] end
	private Double totalEstimationOrder;

	// % protected region % [Modify attribute annotation for Redrafting Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Redrafting Date Time here] end
	private OffsetDateTime redraftingDateTime;

	// % protected region % [Modify attribute annotation for Submission Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Submission Date Time here] end
	private OffsetDateTime submissionDateTime;

	// % protected region % [Modify attribute annotation for Approval Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approval Date Time here] end
	private OffsetDateTime approvalDateTime;

	// % protected region % [Modify attribute annotation for Rejection Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Rejection Date Time here] end
	private OffsetDateTime rejectionDateTime;

	// % protected region % [Modify attribute annotation for Voiding Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Voiding Date Time here] end
	private OffsetDateTime voidingDateTime;

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

	private Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetails = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private PurchaseOrderEntity purchaseOrder;

	private SupplierEntity supplier;

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
	 * Similar to {@link this#addPurchaseRequisitionStockDetails(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be added to this entity
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity) {
		addPurchaseRequisitionStockDetails(entity, true);
	}

	/**
	 * Add a new PurchaseRequisitionStockDetailEntity to purchaseRequisitionStockDetails in this entity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity, boolean reverseAdd) {
		if (!this.purchaseRequisitionStockDetails.contains(entity)) {
			purchaseRequisitionStockDetails.add(entity);
			if (reverseAdd) {
				entity.setPurchaseRequisition(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be added to this entity
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		addPurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Add a new collection of PurchaseRequisitionStockDetailEntity to Purchase Requisition Stock Details in this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseRequisitionStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitionStockDetails(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity) {
		this.removePurchaseRequisitionStockDetails(entity, true);
	}

	/**
	 * Remove the given PurchaseRequisitionStockDetailEntity from this entity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseRequisition(false);
		}
		this.purchaseRequisitionStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be removed to this entity
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		this.removePurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseRequisitionStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseRequisitionStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void setPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		setPurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Requisition Stock Details with the given ones.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseRequisitionStockDetails();
		this.purchaseRequisitionStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseRequisitionStockDetails.forEach(purchaseRequisitionStockDetailsEntity -> purchaseRequisitionStockDetailsEntity.setPurchaseRequisition(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitionStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseRequisitionStockDetails() {
		this.unsetPurchaseRequisitionStockDetails(true);
	}

	/**
	 * Remove all the entities in Purchase Requisition Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseRequisitionStockDetails(boolean doReverse) {
		if (doReverse) {
			this.purchaseRequisitionStockDetails.forEach(purchaseRequisitionStockDetailsEntity -> purchaseRequisitionStockDetailsEntity.unsetPurchaseRequisition(false));
		}
		this.purchaseRequisitionStockDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPurchaseOrder(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be set to this entity
	 */
	public void setPurchaseOrder(@NonNull PurchaseOrderEntity entity) {
		setPurchaseOrder(entity, true);
	}

	/**
	 * Set or update the purchaseOrder in this entity with single PurchaseOrderEntity.
	 *
	 * @param entity the given PurchaseOrderEntity to be set or updated to purchaseOrder
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseOrder(@NonNull PurchaseOrderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrder here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrder here] end

		if (sameAsFormer(this.purchaseOrder, entity)) {
			return;
		}

		if (this.purchaseOrder != null) {
			this.purchaseOrder.removePurchaseRequisitions(this, false);
		}
		this.purchaseOrder = entity;
		if (reverseAdd) {
			this.purchaseOrder.addPurchaseRequisitions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrder incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrder incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrder(boolean)} but default to true.
	 */
	public void unsetPurchaseOrder() {
		this.unsetPurchaseOrder(true);
	}

	/**
	 * Remove Purchase Order in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchaseOrder(boolean reverse) {
		if (reverse && this.purchaseOrder != null) {
			this.purchaseOrder.removePurchaseRequisitions(this, false);
		}
		this.purchaseOrder = null;
	}
	/**
	 * Similar to {@link this#setSupplier(SupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierEntity to be set to this entity
	 */
	public void setSupplier(@NonNull SupplierEntity entity) {
		setSupplier(entity, true);
	}

	/**
	 * Set or update the supplier in this entity with single SupplierEntity.
	 *
	 * @param entity the given SupplierEntity to be set or updated to supplier
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSupplier(@NonNull SupplierEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] end

		if (sameAsFormer(this.supplier, entity)) {
			return;
		}

		if (this.supplier != null) {
			this.supplier.removePurchaseRequisitions(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addPurchaseRequisitions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSupplier(boolean)} but default to true.
	 */
	public void unsetSupplier() {
		this.unsetSupplier(true);
	}

	/**
	 * Remove Supplier in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSupplier(boolean reverse) {
		if (reverse && this.supplier != null) {
			this.supplier.removePurchaseRequisitions(this, false);
		}
		this.supplier = null;
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
			this.warehouse.removePurchaseRequisitions(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addPurchaseRequisitions(this, false);
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
			this.warehouse.removePurchaseRequisitions(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
