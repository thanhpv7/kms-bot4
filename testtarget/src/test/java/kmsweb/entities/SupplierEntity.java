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
public class SupplierEntity extends AbstractEntity {

	public SupplierEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var GoodsReceiveNotesOneMany = new EntityReference();
			GoodsReceiveNotesOneMany.entityName = "GoodsReceiveNote";
			GoodsReceiveNotesOneMany.oppositeName = "Supplier";
			GoodsReceiveNotesOneMany.name = "GoodsReceiveNotes";
			GoodsReceiveNotesOneMany.optional = true;
			GoodsReceiveNotesOneMany.type = "One";
			GoodsReceiveNotesOneMany.oppositeType = "Many";

		References.add(GoodsReceiveNotesOneMany);

		var PurchaseOrdersOneMany = new EntityReference();
			PurchaseOrdersOneMany.entityName = "PurchaseOrder";
			PurchaseOrdersOneMany.oppositeName = "Supplier";
			PurchaseOrdersOneMany.name = "PurchaseOrders";
			PurchaseOrdersOneMany.optional = true;
			PurchaseOrdersOneMany.type = "One";
			PurchaseOrdersOneMany.oppositeType = "Many";

		References.add(PurchaseOrdersOneMany);

		var PurchaseRequisitionsOneMany = new EntityReference();
			PurchaseRequisitionsOneMany.entityName = "PurchaseRequisition";
			PurchaseRequisitionsOneMany.oppositeName = "Supplier";
			PurchaseRequisitionsOneMany.name = "PurchaseRequisitions";
			PurchaseRequisitionsOneMany.optional = true;
			PurchaseRequisitionsOneMany.type = "One";
			PurchaseRequisitionsOneMany.oppositeType = "Many";

		References.add(PurchaseRequisitionsOneMany);

		var ReturnSuppliersOneMany = new EntityReference();
			ReturnSuppliersOneMany.entityName = "ReturnSupplier";
			ReturnSuppliersOneMany.oppositeName = "Supplier";
			ReturnSuppliersOneMany.name = "ReturnSuppliers";
			ReturnSuppliersOneMany.optional = true;
			ReturnSuppliersOneMany.type = "One";
			ReturnSuppliersOneMany.oppositeType = "Many";

		References.add(ReturnSuppliersOneMany);

		var SuplierContactDetailsOneMany = new EntityReference();
			SuplierContactDetailsOneMany.entityName = "SupplierContactDetail";
			SuplierContactDetailsOneMany.oppositeName = "Supplier";
			SuplierContactDetailsOneMany.name = "SuplierContactDetails";
			SuplierContactDetailsOneMany.optional = true;
			SuplierContactDetailsOneMany.type = "One";
			SuplierContactDetailsOneMany.oppositeType = "Many";

		References.add(SuplierContactDetailsOneMany);

		var SupplierBankAccountsOneMany = new EntityReference();
			SupplierBankAccountsOneMany.entityName = "SupplierBankAccount";
			SupplierBankAccountsOneMany.oppositeName = "Supplier";
			SupplierBankAccountsOneMany.name = "SupplierBankAccounts";
			SupplierBankAccountsOneMany.optional = true;
			SupplierBankAccountsOneMany.type = "One";
			SupplierBankAccountsOneMany.oppositeType = "Many";

		References.add(SupplierBankAccountsOneMany);

		var SupplierProductDetailsOneMany = new EntityReference();
			SupplierProductDetailsOneMany.entityName = "SupplierProductDetail";
			SupplierProductDetailsOneMany.oppositeName = "Supplier";
			SupplierProductDetailsOneMany.name = "SupplierProductDetails";
			SupplierProductDetailsOneMany.optional = true;
			SupplierProductDetailsOneMany.type = "One";
			SupplierProductDetailsOneMany.oppositeType = "Many";

		References.add(SupplierProductDetailsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Supplier Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Supplier Number here] end
	private String supplierNumber;

	// % protected region % [Modify attribute annotation for Supplier Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Supplier Name here] end
	private String supplierName;

	// % protected region % [Modify attribute annotation for Tax ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tax ID here] end
	private String taxID;

	// % protected region % [Modify attribute annotation for Supply Stock Group here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Supply Stock Group here] end
	private String supplyStockGroup;

	// % protected region % [Modify attribute annotation for Adress here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Adress here] end
	private String adress;

	// % protected region % [Modify attribute annotation for Country here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Country here] end
	private String country;

	// % protected region % [Modify attribute annotation for State Province here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for State Province here] end
	private String stateProvince;

	// % protected region % [Modify attribute annotation for City here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for City here] end
	private String city;

	// % protected region % [Modify attribute annotation for Postal Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Postal Code here] end
	private String postalCode;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Other Phone Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Phone Number here] end
	private String otherPhoneNumber;

	// % protected region % [Modify attribute annotation for Fax here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Fax here] end
	private String fax;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

	// % protected region % [Modify attribute annotation for Website here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Website here] end
	private String website;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Purchase Order Hold here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Purchase Order Hold here] end
	private Boolean purchaseOrderHold;

	// % protected region % [Modify attribute annotation for Purchase Order Hold Reason here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Purchase Order Hold Reason here] end
	private String purchaseOrderHoldReason;

	// % protected region % [Modify attribute annotation for VAT Included here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for VAT Included here] end
	private Boolean vatIncluded;

	// % protected region % [Modify attribute annotation for Shipping Method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Shipping Method here] end
	private String shippingMethod;

	// % protected region % [Modify attribute annotation for Lead Time Minimum here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lead Time Minimum here] end
	private Double leadTimeMinimum;

	// % protected region % [Modify attribute annotation for Lead Time Maximum here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lead Time Maximum here] end
	private Double leadTimeMaximum;

	// % protected region % [Modify attribute annotation for Last Purchase Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Purchase Date here] end
	private OffsetDateTime lastPurchaseDate;

	// % protected region % [Modify attribute annotation for Last Purchase Order Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Purchase Order Number here] end
	private String lastPurchaseOrderNumber;

	// % protected region % [Modify attribute annotation for Lead Time Measurement here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Lead Time Measurement here] end
	private String leadTimeMeasurement;

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

	private Set<GoodsReceiveNoteEntity> goodsReceiveNotes = new HashSet<>();

	private Set<PurchaseOrderEntity> purchaseOrders = new HashSet<>();

	private Set<PurchaseRequisitionEntity> purchaseRequisitions = new HashSet<>();

	private Set<ReturnSupplierEntity> returnSuppliers = new HashSet<>();

	private Set<SupplierContactDetailEntity> suplierContactDetails = new HashSet<>();

	private Set<SupplierBankAccountEntity> supplierBankAccounts = new HashSet<>();

	private Set<SupplierProductDetailEntity> supplierProductDetails = new HashSet<>();

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
	 * Similar to {@link this#addGoodsReceiveNotes(GoodsReceiveNoteEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be added to this entity
	 */
	public void addGoodsReceiveNotes(@NonNull GoodsReceiveNoteEntity entity) {
		addGoodsReceiveNotes(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteEntity to goodsReceiveNotes in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNotes(@NonNull GoodsReceiveNoteEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNotes.contains(entity)) {
			goodsReceiveNotes.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNotes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be added to this entity
	 */
	public void addGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities) {
		addGoodsReceiveNotes(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteEntity to Goods Receive Notes in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNotes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNotes(GoodsReceiveNoteEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be set to this entity
	 */
	public void removeGoodsReceiveNotes(@NonNull GoodsReceiveNoteEntity entity) {
		this.removeGoodsReceiveNotes(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNotes(@NonNull GoodsReceiveNoteEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.goodsReceiveNotes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNotes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities) {
		this.removeGoodsReceiveNotes(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNotes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNotes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to be set to this entity
	 */
	public void setGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities) {
		setGoodsReceiveNotes(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Notes with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNotes(@NonNull Collection<GoodsReceiveNoteEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNotes();
		this.goodsReceiveNotes = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNotes.forEach(goodsReceiveNotesEntity -> goodsReceiveNotesEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNotes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNotes() {
		this.unsetGoodsReceiveNotes(true);
	}

	/**
	 * Remove all the entities in Goods Receive Notes from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNotes(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNotes.forEach(goodsReceiveNotesEntity -> goodsReceiveNotesEntity.unsetSupplier(false));
		}
		this.goodsReceiveNotes.clear();
	}

/**
	 * Similar to {@link this#addPurchaseOrders(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be added to this entity
	 */
	public void addPurchaseOrders(@NonNull PurchaseOrderEntity entity) {
		addPurchaseOrders(entity, true);
	}

	/**
	 * Add a new PurchaseOrderEntity to purchaseOrders in this entity.
	 *
	 * @param entity the given PurchaseOrderEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseOrders(@NonNull PurchaseOrderEntity entity, boolean reverseAdd) {
		if (!this.purchaseOrders.contains(entity)) {
			purchaseOrders.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be added to this entity
	 */
	public void addPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities) {
		addPurchaseOrders(entities, true);
	}

	/**
	 * Add a new collection of PurchaseOrderEntity to Purchase Orders in this entity.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseOrders(PurchaseOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderEntity to be set to this entity
	 */
	public void removePurchaseOrders(@NonNull PurchaseOrderEntity entity) {
		this.removePurchaseOrders(entity, true);
	}

	/**
	 * Remove the given PurchaseOrderEntity from this entity.
	 *
	 * @param entity the given PurchaseOrderEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseOrders(@NonNull PurchaseOrderEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.purchaseOrders.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseOrders(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be removed to this entity
	 */
	public void removePurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities) {
		this.removePurchaseOrders(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseOrderEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseOrders(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseOrders(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to be set to this entity
	 */
	public void setPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities) {
		setPurchaseOrders(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Orders with the given ones.
	 *
	 * @param entities the given collection of PurchaseOrderEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseOrders(@NonNull Collection<PurchaseOrderEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseOrders();
		this.purchaseOrders = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrders(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseOrders() {
		this.unsetPurchaseOrders(true);
	}

	/**
	 * Remove all the entities in Purchase Orders from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseOrders(boolean doReverse) {
		if (doReverse) {
			this.purchaseOrders.forEach(purchaseOrdersEntity -> purchaseOrdersEntity.unsetSupplier(false));
		}
		this.purchaseOrders.clear();
	}

/**
	 * Similar to {@link this#addPurchaseRequisitions(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be added to this entity
	 */
	public void addPurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity) {
		addPurchaseRequisitions(entity, true);
	}

	/**
	 * Add a new PurchaseRequisitionEntity to purchaseRequisitions in this entity.
	 *
	 * @param entity the given PurchaseRequisitionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity, boolean reverseAdd) {
		if (!this.purchaseRequisitions.contains(entity)) {
			purchaseRequisitions.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be added to this entity
	 */
	public void addPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities) {
		addPurchaseRequisitions(entities, true);
	}

	/**
	 * Add a new collection of PurchaseRequisitionEntity to Purchase Requisitions in this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseRequisitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitions(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be set to this entity
	 */
	public void removePurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity) {
		this.removePurchaseRequisitions(entity, true);
	}

	/**
	 * Remove the given PurchaseRequisitionEntity from this entity.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseRequisitions(@NonNull PurchaseRequisitionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.purchaseRequisitions.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be removed to this entity
	 */
	public void removePurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities) {
		this.removePurchaseRequisitions(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseRequisitionEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseRequisitions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseRequisitions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to be set to this entity
	 */
	public void setPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities) {
		setPurchaseRequisitions(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Requisitions with the given ones.
	 *
	 * @param entities the given collection of PurchaseRequisitionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseRequisitions(@NonNull Collection<PurchaseRequisitionEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseRequisitions();
		this.purchaseRequisitions = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseRequisitions() {
		this.unsetPurchaseRequisitions(true);
	}

	/**
	 * Remove all the entities in Purchase Requisitions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseRequisitions(boolean doReverse) {
		if (doReverse) {
			this.purchaseRequisitions.forEach(purchaseRequisitionsEntity -> purchaseRequisitionsEntity.unsetSupplier(false));
		}
		this.purchaseRequisitions.clear();
	}

/**
	 * Similar to {@link this#addReturnSuppliers(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be added to this entity
	 */
	public void addReturnSuppliers(@NonNull ReturnSupplierEntity entity) {
		addReturnSuppliers(entity, true);
	}

	/**
	 * Add a new ReturnSupplierEntity to returnSuppliers in this entity.
	 *
	 * @param entity the given ReturnSupplierEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReturnSuppliers(@NonNull ReturnSupplierEntity entity, boolean reverseAdd) {
		if (!this.returnSuppliers.contains(entity)) {
			returnSuppliers.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be added to this entity
	 */
	public void addReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities) {
		addReturnSuppliers(entities, true);
	}

	/**
	 * Add a new collection of ReturnSupplierEntity to Return Suppliers in this entity.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReturnSuppliers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReturnSuppliers(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be set to this entity
	 */
	public void removeReturnSuppliers(@NonNull ReturnSupplierEntity entity) {
		this.removeReturnSuppliers(entity, true);
	}

	/**
	 * Remove the given ReturnSupplierEntity from this entity.
	 *
	 * @param entity the given ReturnSupplierEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReturnSuppliers(@NonNull ReturnSupplierEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.returnSuppliers.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be removed to this entity
	 */
	public void removeReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities) {
		this.removeReturnSuppliers(entities, true);
	}

	/**
	 * Remove the given collection of ReturnSupplierEntity from  to this entity.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReturnSuppliers(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReturnSuppliers(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to be set to this entity
	 */
	public void setReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities) {
		setReturnSuppliers(entities, true);
	}

	/**
	 * Replace the current entities in Return Suppliers with the given ones.
	 *
	 * @param entities the given collection of ReturnSupplierEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReturnSuppliers(@NonNull Collection<ReturnSupplierEntity> entities, boolean reverseAdd) {

		this.unsetReturnSuppliers();
		this.returnSuppliers = new HashSet<>(entities);
		if (reverseAdd) {
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReturnSuppliers(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReturnSuppliers() {
		this.unsetReturnSuppliers(true);
	}

	/**
	 * Remove all the entities in Return Suppliers from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReturnSuppliers(boolean doReverse) {
		if (doReverse) {
			this.returnSuppliers.forEach(returnSuppliersEntity -> returnSuppliersEntity.unsetSupplier(false));
		}
		this.returnSuppliers.clear();
	}

/**
	 * Similar to {@link this#addSuplierContactDetails(SupplierContactDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierContactDetailEntity to be added to this entity
	 */
	public void addSuplierContactDetails(@NonNull SupplierContactDetailEntity entity) {
		addSuplierContactDetails(entity, true);
	}

	/**
	 * Add a new SupplierContactDetailEntity to suplierContactDetails in this entity.
	 *
	 * @param entity the given SupplierContactDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSuplierContactDetails(@NonNull SupplierContactDetailEntity entity, boolean reverseAdd) {
		if (!this.suplierContactDetails.contains(entity)) {
			suplierContactDetails.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSuplierContactDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be added to this entity
	 */
	public void addSuplierContactDetails(@NonNull Collection<SupplierContactDetailEntity> entities) {
		addSuplierContactDetails(entities, true);
	}

	/**
	 * Add a new collection of SupplierContactDetailEntity to Suplier Contact Details in this entity.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSuplierContactDetails(@NonNull Collection<SupplierContactDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSuplierContactDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSuplierContactDetails(SupplierContactDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierContactDetailEntity to be set to this entity
	 */
	public void removeSuplierContactDetails(@NonNull SupplierContactDetailEntity entity) {
		this.removeSuplierContactDetails(entity, true);
	}

	/**
	 * Remove the given SupplierContactDetailEntity from this entity.
	 *
	 * @param entity the given SupplierContactDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSuplierContactDetails(@NonNull SupplierContactDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.suplierContactDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSuplierContactDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be removed to this entity
	 */
	public void removeSuplierContactDetails(@NonNull Collection<SupplierContactDetailEntity> entities) {
		this.removeSuplierContactDetails(entities, true);
	}

	/**
	 * Remove the given collection of SupplierContactDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSuplierContactDetails(@NonNull Collection<SupplierContactDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSuplierContactDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSuplierContactDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to be set to this entity
	 */
	public void setSuplierContactDetails(@NonNull Collection<SupplierContactDetailEntity> entities) {
		setSuplierContactDetails(entities, true);
	}

	/**
	 * Replace the current entities in Suplier Contact Details with the given ones.
	 *
	 * @param entities the given collection of SupplierContactDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSuplierContactDetails(@NonNull Collection<SupplierContactDetailEntity> entities, boolean reverseAdd) {

		this.unsetSuplierContactDetails();
		this.suplierContactDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.suplierContactDetails.forEach(suplierContactDetailsEntity -> suplierContactDetailsEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSuplierContactDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSuplierContactDetails() {
		this.unsetSuplierContactDetails(true);
	}

	/**
	 * Remove all the entities in Suplier Contact Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSuplierContactDetails(boolean doReverse) {
		if (doReverse) {
			this.suplierContactDetails.forEach(suplierContactDetailsEntity -> suplierContactDetailsEntity.unsetSupplier(false));
		}
		this.suplierContactDetails.clear();
	}

/**
	 * Similar to {@link this#addSupplierBankAccounts(SupplierBankAccountEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierBankAccountEntity to be added to this entity
	 */
	public void addSupplierBankAccounts(@NonNull SupplierBankAccountEntity entity) {
		addSupplierBankAccounts(entity, true);
	}

	/**
	 * Add a new SupplierBankAccountEntity to supplierBankAccounts in this entity.
	 *
	 * @param entity the given SupplierBankAccountEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSupplierBankAccounts(@NonNull SupplierBankAccountEntity entity, boolean reverseAdd) {
		if (!this.supplierBankAccounts.contains(entity)) {
			supplierBankAccounts.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSupplierBankAccounts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be added to this entity
	 */
	public void addSupplierBankAccounts(@NonNull Collection<SupplierBankAccountEntity> entities) {
		addSupplierBankAccounts(entities, true);
	}

	/**
	 * Add a new collection of SupplierBankAccountEntity to Supplier Bank Accounts in this entity.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSupplierBankAccounts(@NonNull Collection<SupplierBankAccountEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSupplierBankAccounts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSupplierBankAccounts(SupplierBankAccountEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierBankAccountEntity to be set to this entity
	 */
	public void removeSupplierBankAccounts(@NonNull SupplierBankAccountEntity entity) {
		this.removeSupplierBankAccounts(entity, true);
	}

	/**
	 * Remove the given SupplierBankAccountEntity from this entity.
	 *
	 * @param entity the given SupplierBankAccountEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSupplierBankAccounts(@NonNull SupplierBankAccountEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.supplierBankAccounts.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSupplierBankAccounts(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be removed to this entity
	 */
	public void removeSupplierBankAccounts(@NonNull Collection<SupplierBankAccountEntity> entities) {
		this.removeSupplierBankAccounts(entities, true);
	}

	/**
	 * Remove the given collection of SupplierBankAccountEntity from  to this entity.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSupplierBankAccounts(@NonNull Collection<SupplierBankAccountEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSupplierBankAccounts(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSupplierBankAccounts(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to be set to this entity
	 */
	public void setSupplierBankAccounts(@NonNull Collection<SupplierBankAccountEntity> entities) {
		setSupplierBankAccounts(entities, true);
	}

	/**
	 * Replace the current entities in Supplier Bank Accounts with the given ones.
	 *
	 * @param entities the given collection of SupplierBankAccountEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSupplierBankAccounts(@NonNull Collection<SupplierBankAccountEntity> entities, boolean reverseAdd) {

		this.unsetSupplierBankAccounts();
		this.supplierBankAccounts = new HashSet<>(entities);
		if (reverseAdd) {
			this.supplierBankAccounts.forEach(supplierBankAccountsEntity -> supplierBankAccountsEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSupplierBankAccounts(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSupplierBankAccounts() {
		this.unsetSupplierBankAccounts(true);
	}

	/**
	 * Remove all the entities in Supplier Bank Accounts from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSupplierBankAccounts(boolean doReverse) {
		if (doReverse) {
			this.supplierBankAccounts.forEach(supplierBankAccountsEntity -> supplierBankAccountsEntity.unsetSupplier(false));
		}
		this.supplierBankAccounts.clear();
	}

/**
	 * Similar to {@link this#addSupplierProductDetails(SupplierProductDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierProductDetailEntity to be added to this entity
	 */
	public void addSupplierProductDetails(@NonNull SupplierProductDetailEntity entity) {
		addSupplierProductDetails(entity, true);
	}

	/**
	 * Add a new SupplierProductDetailEntity to supplierProductDetails in this entity.
	 *
	 * @param entity the given SupplierProductDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSupplierProductDetails(@NonNull SupplierProductDetailEntity entity, boolean reverseAdd) {
		if (!this.supplierProductDetails.contains(entity)) {
			supplierProductDetails.add(entity);
			if (reverseAdd) {
				entity.setSupplier(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be added to this entity
	 */
	public void addSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities) {
		addSupplierProductDetails(entities, true);
	}

	/**
	 * Add a new collection of SupplierProductDetailEntity to Supplier Product Details in this entity.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSupplierProductDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSupplierProductDetails(SupplierProductDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierProductDetailEntity to be set to this entity
	 */
	public void removeSupplierProductDetails(@NonNull SupplierProductDetailEntity entity) {
		this.removeSupplierProductDetails(entity, true);
	}

	/**
	 * Remove the given SupplierProductDetailEntity from this entity.
	 *
	 * @param entity the given SupplierProductDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSupplierProductDetails(@NonNull SupplierProductDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSupplier(false);
		}
		this.supplierProductDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be removed to this entity
	 */
	public void removeSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities) {
		this.removeSupplierProductDetails(entities, true);
	}

	/**
	 * Remove the given collection of SupplierProductDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSupplierProductDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be set to this entity
	 */
	public void setSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities) {
		setSupplierProductDetails(entities, true);
	}

	/**
	 * Replace the current entities in Supplier Product Details with the given ones.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {

		this.unsetSupplierProductDetails();
		this.supplierProductDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.supplierProductDetails.forEach(supplierProductDetailsEntity -> supplierProductDetailsEntity.setSupplier(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSupplierProductDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSupplierProductDetails() {
		this.unsetSupplierProductDetails(true);
	}

	/**
	 * Remove all the entities in Supplier Product Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSupplierProductDetails(boolean doReverse) {
		if (doReverse) {
			this.supplierProductDetails.forEach(supplierProductDetailsEntity -> supplierProductDetailsEntity.unsetSupplier(false));
		}
		this.supplierProductDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
