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
public class PurchaseRequisitionStockDetailEntity extends AbstractEntity {

	public PurchaseRequisitionStockDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PurchaseOrderStockDetailsOneMany = new EntityReference();
			PurchaseOrderStockDetailsOneMany.entityName = "PurchaseOrderStockDetail";
			PurchaseOrderStockDetailsOneMany.oppositeName = "PurchaseRequisitionStockDetail";
			PurchaseOrderStockDetailsOneMany.name = "PurchaseOrderStockDetails";
			PurchaseOrderStockDetailsOneMany.optional = true;
			PurchaseOrderStockDetailsOneMany.type = "One";
			PurchaseOrderStockDetailsOneMany.oppositeType = "Many";

		References.add(PurchaseOrderStockDetailsOneMany);

		var PurchaseRequisitionOneMany = new EntityReference();
			PurchaseRequisitionOneMany.entityName = "PurchaseRequisition";
			PurchaseRequisitionOneMany.oppositeName = "PurchaseRequisition";
			PurchaseRequisitionOneMany.name = "PurchaseRequisitionStockDetails";
			PurchaseRequisitionOneMany.optional = true;
			PurchaseRequisitionOneMany.type = "One";
			PurchaseRequisitionOneMany.oppositeType = "Many";

		References.add(PurchaseRequisitionOneMany);

		var StockCatalogueOneMany = new EntityReference();
			StockCatalogueOneMany.entityName = "StockCatalogue";
			StockCatalogueOneMany.oppositeName = "StockCatalogue";
			StockCatalogueOneMany.name = "PurchaseRequisitionStockDetails";
			StockCatalogueOneMany.optional = true;
			StockCatalogueOneMany.type = "One";
			StockCatalogueOneMany.oppositeType = "Many";

		References.add(StockCatalogueOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for SOH here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SOH here] end
	private Double soh;

	// % protected region % [Modify attribute annotation for Max Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Max Level here] end
	private Double maxLevel;

	// % protected region % [Modify attribute annotation for Quantity Requested here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Requested here] end
	private Double quantityRequested;

	// % protected region % [Modify attribute annotation for UOP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UOP here] end
	private String uop;

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Total Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Price here] end
	private Double totalPrice;

	// % protected region % [Modify attribute annotation for Item Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Status here] end
	private String itemStatus;

	// % protected region % [Modify attribute annotation for Quantity Ordered here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Ordered here] end
	private Double quantityOrdered;

	// % protected region % [Modify attribute annotation for Quantity Received here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Received here] end
	private Double quantityReceived;

	// % protected region % [Modify attribute annotation for Quantity Returned here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity Returned here] end
	private Double quantityReturned;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for Remaining Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Remaining Quantity here] end
	private Double remainingQuantity;

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

	private Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private PurchaseRequisitionEntity purchaseRequisition;

	private StockCatalogueEntity stockCatalogue;

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
	 * Similar to {@link this#addPurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity) {
		addPurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Add a new PurchaseOrderStockDetailEntity to purchaseOrderStockDetails in this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.purchaseOrderStockDetails.contains(entity)) {
			purchaseOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setPurchaseRequisitionStockDetail(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities) {
		addPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of PurchaseOrderStockDetailEntity to Purchase Order Stock Details in this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void removePurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity) {
		this.removePurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given PurchaseOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseRequisitionStockDetail(false);
		}
		this.purchaseOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 */
	public void removePurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities) {
		this.removePurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void setPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities) {
		setPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseOrderStockDetails();
		this.purchaseOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.setPurchaseRequisitionStockDetail(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseOrderStockDetails() {
		this.unsetPurchaseOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Purchase Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.unsetPurchaseRequisitionStockDetail(false));
		}
		this.purchaseOrderStockDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPurchaseRequisition(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be set to this entity
	 */
	public void setPurchaseRequisition(@NonNull PurchaseRequisitionEntity entity) {
		setPurchaseRequisition(entity, true);
	}

	/**
	 * Set or update the purchaseRequisition in this entity with single PurchaseRequisitionEntity.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be set or updated to purchaseRequisition
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseRequisition(@NonNull PurchaseRequisitionEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseRequisition here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseRequisition here] end

		if (sameAsFormer(this.purchaseRequisition, entity)) {
			return;
		}

		if (this.purchaseRequisition != null) {
			this.purchaseRequisition.removePurchaseRequisitionStockDetails(this, false);
		}
		this.purchaseRequisition = entity;
		if (reverseAdd) {
			this.purchaseRequisition.addPurchaseRequisitionStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchaseRequisition incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchaseRequisition incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisition(boolean)} but default to true.
	 */
	public void unsetPurchaseRequisition() {
		this.unsetPurchaseRequisition(true);
	}

	/**
	 * Remove Purchase Requisition in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchaseRequisition(boolean reverse) {
		if (reverse && this.purchaseRequisition != null) {
			this.purchaseRequisition.removePurchaseRequisitionStockDetails(this, false);
		}
		this.purchaseRequisition = null;
	}
	/**
	 * Similar to {@link this#setStockCatalogue(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogue(@NonNull StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update the stockCatalogue in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogue
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(@NonNull StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.removePurchaseRequisitionStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addPurchaseRequisitionStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogue(boolean)} but default to true.
	 */
	public void unsetStockCatalogue() {
		this.unsetStockCatalogue(true);
	}

	/**
	 * Remove Stock Catalogue in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogue(boolean reverse) {
		if (reverse && this.stockCatalogue != null) {
			this.stockCatalogue.removePurchaseRequisitionStockDetails(this, false);
		}
		this.stockCatalogue = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
