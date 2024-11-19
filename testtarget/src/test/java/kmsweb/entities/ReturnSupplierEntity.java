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
public class ReturnSupplierEntity extends AbstractEntity {

	public ReturnSupplierEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ReturnSupplierStockDetailsOneMany = new EntityReference();
			ReturnSupplierStockDetailsOneMany.entityName = "ReturnSupplierStockDetail";
			ReturnSupplierStockDetailsOneMany.oppositeName = "ReturnSupplier";
			ReturnSupplierStockDetailsOneMany.name = "ReturnSupplierStockDetails";
			ReturnSupplierStockDetailsOneMany.optional = true;
			ReturnSupplierStockDetailsOneMany.type = "One";
			ReturnSupplierStockDetailsOneMany.oppositeType = "Many";

		References.add(ReturnSupplierStockDetailsOneMany);

		var PurchaseOrderOneMany = new EntityReference();
			PurchaseOrderOneMany.entityName = "PurchaseOrder";
			PurchaseOrderOneMany.oppositeName = "PurchaseOrder";
			PurchaseOrderOneMany.name = "ReturnSuppliers";
			PurchaseOrderOneMany.optional = true;
			PurchaseOrderOneMany.type = "One";
			PurchaseOrderOneMany.oppositeType = "Many";

		References.add(PurchaseOrderOneMany);

		var SupplierOneMany = new EntityReference();
			SupplierOneMany.entityName = "Supplier";
			SupplierOneMany.oppositeName = "Supplier";
			SupplierOneMany.name = "ReturnSuppliers";
			SupplierOneMany.optional = true;
			SupplierOneMany.type = "One";
			SupplierOneMany.oppositeType = "Many";

		References.add(SupplierOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "ReturnSuppliers";
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

	// % protected region % [Modify attribute annotation for Return Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Return Number here] end
	private String returnNumber;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Return Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Return Date here] end
	private OffsetDateTime returnDate;

	// % protected region % [Modify attribute annotation for Order Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Order Date here] end
	private OffsetDateTime orderDate;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Invoice Return Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Invoice Return Number here] end
	private String invoiceReturnNumber;

	// % protected region % [Modify attribute annotation for Tax Invoice Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Invoice Number here] end
	private String taxInvoiceNumber;

	// % protected region % [Modify attribute annotation for Price VAT Included here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price VAT Included here] end
	private Boolean priceVATIncluded;

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

	// % protected region % [Modify attribute annotation for Sub Total here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sub Total here] end
	private Double subTotal;

	// % protected region % [Modify attribute annotation for Extra Discount In Percentage here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Extra Discount In Percentage here] end
	private Boolean extraDiscountInPercentage;

	// % protected region % [Modify attribute annotation for Extra Discount Include Tax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Extra Discount Include Tax here] end
	private Boolean extraDiscountIncludeTax;

	// % protected region % [Modify attribute annotation for Extra Discount Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Extra Discount Value here] end
	private Double extraDiscountValue;

	// % protected region % [Modify attribute annotation for Freight Fee Include Tax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Freight Fee Include Tax here] end
	private Boolean freightFeeIncludeTax;

	// % protected region % [Modify attribute annotation for Freight Fee Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Freight Fee Value here] end
	private Double freightFeeValue;

	// % protected region % [Modify attribute annotation for Other Fee Include Tax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Fee Include Tax here] end
	private Boolean otherFeeIncludeTax;

	// % protected region % [Modify attribute annotation for Other Fee Value here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Fee Value here] end
	private Double otherFeeValue;

	// % protected region % [Modify attribute annotation for Tax Base here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Base here] end
	private Double taxBase;

	// % protected region % [Modify attribute annotation for Tax Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax Amount here] end
	private Double taxAmount;

	// % protected region % [Modify attribute annotation for Total Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Amount here] end
	private Double totalAmount;

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

	private Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetails = new HashSet<>();

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
	 * Similar to {@link this#addReturnSupplierStockDetails(ReturnSupplierStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be added to this entity
	 */
	public void addReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity) {
		addReturnSupplierStockDetails(entity, true);
	}

	/**
	 * Add a new ReturnSupplierStockDetailEntity to returnSupplierStockDetails in this entity.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity, boolean reverseAdd) {
		if (!this.returnSupplierStockDetails.contains(entity)) {
			returnSupplierStockDetails.add(entity);
			if (reverseAdd) {
				entity.setReturnSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be added to this entity
	 */
	public void addReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities) {
		addReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Add a new collection of ReturnSupplierStockDetailEntity to Return Supplier Stock Details in this entity.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReturnSupplierStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReturnSupplierStockDetails(ReturnSupplierStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be set to this entity
	 */
	public void removeReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity) {
		this.removeReturnSupplierStockDetails(entity, true);
	}

	/**
	 * Remove the given ReturnSupplierStockDetailEntity from this entity.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetReturnSupplier(false);
		}
		this.returnSupplierStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be removed to this entity
	 */
	public void removeReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities) {
		this.removeReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of ReturnSupplierStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReturnSupplierStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be set to this entity
	 */
	public void setReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities) {
		setReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Return Supplier Stock Details with the given ones.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetReturnSupplierStockDetails();
		this.returnSupplierStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.returnSupplierStockDetails.forEach(returnSupplierStockDetailsEntity -> returnSupplierStockDetailsEntity.setReturnSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReturnSupplierStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReturnSupplierStockDetails() {
		this.unsetReturnSupplierStockDetails(true);
	}

	/**
	 * Remove all the entities in Return Supplier Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReturnSupplierStockDetails(boolean doReverse) {
		if (doReverse) {
			this.returnSupplierStockDetails.forEach(returnSupplierStockDetailsEntity -> returnSupplierStockDetailsEntity.unsetReturnSupplier(false));
		}
		this.returnSupplierStockDetails.clear();
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
			this.purchaseOrder.removeReturnSuppliers(this, false);
		}
		this.purchaseOrder = entity;
		if (reverseAdd) {
			this.purchaseOrder.addReturnSuppliers(this, false);
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
			this.purchaseOrder.removeReturnSuppliers(this, false);
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
			this.supplier.removeReturnSuppliers(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addReturnSuppliers(this, false);
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
			this.supplier.removeReturnSuppliers(this, false);
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
			this.warehouse.removeReturnSuppliers(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addReturnSuppliers(this, false);
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
			this.warehouse.removeReturnSuppliers(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
