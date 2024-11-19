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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.PurchaseOrderStockDetailEntityDto;
import kmsweb.entities.listeners.PurchaseOrderStockDetailEntityListener;
import kmsweb.serializers.PurchaseOrderStockDetailSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({PurchaseOrderStockDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PurchaseOrderStockDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PurchaseOrderStockDetailEntity extends AbstractEntity {

	/**
	 * Takes a PurchaseOrderStockDetailEntityDto and converts it into a PurchaseOrderStockDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param purchaseOrderStockDetailEntityDto
	 */
	public PurchaseOrderStockDetailEntity(PurchaseOrderStockDetailEntityDto purchaseOrderStockDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (purchaseOrderStockDetailEntityDto.getId() != null) {
			this.setId(purchaseOrderStockDetailEntityDto.getId());
		}

		if (purchaseOrderStockDetailEntityDto.getUnitPrice() != null) {
			this.setUnitPrice(purchaseOrderStockDetailEntityDto.getUnitPrice());
		}

		if (purchaseOrderStockDetailEntityDto.getQuantityOrdered() != null) {
			this.setQuantityOrdered(purchaseOrderStockDetailEntityDto.getQuantityOrdered());
		}

		if (purchaseOrderStockDetailEntityDto.getUop() != null) {
			this.setUop(purchaseOrderStockDetailEntityDto.getUop());
		}

		if (purchaseOrderStockDetailEntityDto.getDiscountInPercent() != null) {
			this.setDiscountInPercent(purchaseOrderStockDetailEntityDto.getDiscountInPercent());
		}

		if (purchaseOrderStockDetailEntityDto.getDiscountValue() != null) {
			this.setDiscountValue(purchaseOrderStockDetailEntityDto.getDiscountValue());
		}

		if (purchaseOrderStockDetailEntityDto.getTaxable() != null) {
			this.setTaxable(purchaseOrderStockDetailEntityDto.getTaxable());
		}

		if (purchaseOrderStockDetailEntityDto.getItemPrice() != null) {
			this.setItemPrice(purchaseOrderStockDetailEntityDto.getItemPrice());
		}

		if (purchaseOrderStockDetailEntityDto.getItemStatus() != null) {
			this.setItemStatus(purchaseOrderStockDetailEntityDto.getItemStatus());
		}

		if (purchaseOrderStockDetailEntityDto.getSoh() != null) {
			this.setSoh(purchaseOrderStockDetailEntityDto.getSoh());
		}

		if (purchaseOrderStockDetailEntityDto.getMaxLevel() != null) {
			this.setMaxLevel(purchaseOrderStockDetailEntityDto.getMaxLevel());
		}

		if (purchaseOrderStockDetailEntityDto.getQuantityReceived() != null) {
			this.setQuantityReceived(purchaseOrderStockDetailEntityDto.getQuantityReceived());
		}

		if (purchaseOrderStockDetailEntityDto.getQuantityReturned() != null) {
			this.setQuantityReturned(purchaseOrderStockDetailEntityDto.getQuantityReturned());
		}

		if (purchaseOrderStockDetailEntityDto.getItemNotes() != null) {
			this.setItemNotes(purchaseOrderStockDetailEntityDto.getItemNotes());
		}

		if (purchaseOrderStockDetailEntityDto.getRemainingQuantity() != null) {
			this.setRemainingQuantity(purchaseOrderStockDetailEntityDto.getRemainingQuantity());
		}

		if (purchaseOrderStockDetailEntityDto.getGoodsReceiveNoteItems() != null) {
			this.setGoodsReceiveNoteItems(purchaseOrderStockDetailEntityDto.getGoodsReceiveNoteItems());
		}

		if (purchaseOrderStockDetailEntityDto.getPurchaseOrder() != null) {
			this.setPurchaseOrder(purchaseOrderStockDetailEntityDto.getPurchaseOrder());
		}

		if (purchaseOrderStockDetailEntityDto.getPurchaseRequisitionStockDetail() != null) {
			this.setPurchaseRequisitionStockDetail(purchaseOrderStockDetailEntityDto.getPurchaseRequisitionStockDetail());
		}

		if (purchaseOrderStockDetailEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(purchaseOrderStockDetailEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@CsvBindByName(column = "UNIT_PRICE", required = false)
	@Nullable
	@Column(name = "unit_price")
	@Schema(description = "The Unit Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Quantity Ordered here] off begin
	@CsvBindByName(column = "QUANTITY_ORDERED", required = false)
	@Nullable
	@Column(name = "quantity_ordered")
	@Schema(description = "The Quantity Ordered of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Ordered here] end
	private Double quantityOrdered;

	// % protected region % [Modify attribute annotation for UOP here] off begin
	@CsvBindByName(column = "UOP", required = false)
	@Nullable
	@Column(name = "uop")
	@Schema(description = "The UOP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOP here] end
	private String uop;

	// % protected region % [Modify attribute annotation for Discount In Percent here] off begin
	@CsvBindByName(column = "DISCOUNT_IN_PERCENT", required = false)
	@Nullable
	@Column(name = "discount_in_percent")
	@Schema(description = "The Discount In Percent of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discount In Percent here] end
	private Boolean discountInPercent = false ;

	// % protected region % [Modify attribute annotation for Discount Value here] off begin
	@CsvBindByName(column = "DISCOUNT_VALUE", required = false)
	@Nullable
	@Column(name = "discount_value")
	@Schema(description = "The Discount Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discount Value here] end
	private Double discountValue;

	// % protected region % [Modify attribute annotation for Taxable here] off begin
	@CsvBindByName(column = "TAXABLE", required = false)
	@Nullable
	@Column(name = "taxable")
	@Schema(description = "The Taxable of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Taxable here] end
	private Boolean taxable = false ;

	// % protected region % [Modify attribute annotation for Item Price here] off begin
	@CsvBindByName(column = "ITEM_PRICE", required = false)
	@Nullable
	@Column(name = "item_price")
	@Schema(description = "The Item Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Price here] end
	private Double itemPrice;

	// % protected region % [Modify attribute annotation for Item Status here] off begin
	@CsvBindByName(column = "ITEM_STATUS", required = false)
	@Nullable
	@Column(name = "item_status")
	@Schema(description = "The Item Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Status here] end
	private String itemStatus;

	// % protected region % [Modify attribute annotation for SOH here] off begin
	@CsvBindByName(column = "SOH", required = false)
	@Nullable
	@Column(name = "soh")
	@Schema(description = "The SOH of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SOH here] end
	private Double soh;

	// % protected region % [Modify attribute annotation for Max Level here] off begin
	@CsvBindByName(column = "MAX_LEVEL", required = false)
	@Nullable
	@Column(name = "max_level")
	@Schema(description = "The Max Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Max Level here] end
	private Double maxLevel;

	// % protected region % [Modify attribute annotation for Quantity Received here] off begin
	@CsvBindByName(column = "QUANTITY_RECEIVED", required = false)
	@Nullable
	@Column(name = "quantity_received")
	@Schema(description = "The Quantity Received of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Received here] end
	private Double quantityReceived;

	// % protected region % [Modify attribute annotation for Quantity Returned here] off begin
	@CsvBindByName(column = "QUANTITY_RETURNED", required = false)
	@Nullable
	@Column(name = "quantity_returned")
	@Schema(description = "The Quantity Returned of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Returned here] end
	private Double quantityReturned;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@CsvBindByName(column = "ITEM_NOTES", required = false)
	@Nullable
	@Column(name = "item_notes")
	@Schema(description = "The Item Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for Remaining Quantity here] off begin
	@CsvBindByName(column = "REMAINING_QUANTITY", required = false)
	@Nullable
	@Column(name = "remaining_quantity")
	@Schema(description = "The Remaining Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Remaining Quantity here] end
	private Double remainingQuantity;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Goods Receive Note Items here] off begin
	@Schema(description = "The Goods Receive Note Item entities that are related to this entity.")
	@OneToMany(mappedBy = "purchaseOrderStockDetail", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Goods Receive Note Items here] end
	private Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItems = new HashSet<>();

	// % protected region % [Update the annotation for goodsReceiveNoteItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "GOODS_RECEIVE_NOTE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for goodsReceiveNoteItemsIds here] end
	private Set<UUID> goodsReceiveNoteItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Purchase Order here] off begin
	@Schema(description = "The Purchase Order entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Order here] end
	private PurchaseOrderEntity purchaseOrder;

	// % protected region % [Update the annotation for purchaseOrderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_ORDER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for purchaseOrderId here] end
	private UUID purchaseOrderId;

	// % protected region % [Update the annotation for Purchase Requisition Stock Detail here] off begin
	@Schema(description = "The Purchase Requisition Stock Detail entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Requisition Stock Detail here] end
	private PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetail;

	// % protected region % [Update the annotation for purchaseRequisitionStockDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_REQUISITION_STOCK_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for purchaseRequisitionStockDetailId here] end
	private UUID purchaseRequisitionStockDetailId;

	// % protected region % [Update the annotation for Stock Catalogue here] off begin
	@Schema(description = "The Stock Catalogue entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Catalogue here] end
	private StockCatalogueEntity stockCatalogue;

	// % protected region % [Update the annotation for stockCatalogueId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_CATALOGUE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for stockCatalogueId here] end
	private UUID stockCatalogueId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NotNull GoodsReceiveNoteItemEntity entity) {
		addGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteItemEntity to goodsReceiveNoteItems in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteItems.contains(entity)) {
			goodsReceiveNoteItems.add(entity);
			if (reverseAdd) {
				entity.setPurchaseOrderStockDetail(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities) {
		addGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteItemEntity to Goods Receive Note Items in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NotNull GoodsReceiveNoteItemEntity entity) {
		this.removeGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteItemEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteItems(@NotNull GoodsReceiveNoteItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseOrderStockDetail(false);
		}
		this.goodsReceiveNoteItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities) {
		this.removeGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteItemEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities) {
		setGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Items with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteItems();
		this.goodsReceiveNoteItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.setPurchaseOrderStockDetail(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteItems() {
		this.unsetGoodsReceiveNoteItems(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteItems(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.unsetPurchaseOrderStockDetail(false));
		}
		this.goodsReceiveNoteItems.clear();
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
	public void setPurchaseOrder(@NotNull PurchaseOrderEntity entity) {
		setPurchaseOrder(entity, true);
	}

	/**
	 * Set or update the purchaseOrder in this entity with single PurchaseOrderEntity.
	 *
	 * @param entity the given PurchaseOrderEntity to be set or updated to purchaseOrder
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseOrder(@NotNull PurchaseOrderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrder here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrder here] end

		if (sameAsFormer(this.purchaseOrder, entity)) {
			return;
		}

		if (this.purchaseOrder != null) {
			this.purchaseOrder.removePurchaseOrderStockDetails(this, false);
		}
		this.purchaseOrder = entity;
		if (reverseAdd) {
			this.purchaseOrder.addPurchaseOrderStockDetails(this, false);
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
			this.purchaseOrder.removePurchaseOrderStockDetails(this, false);
		}
		this.purchaseOrder = null;
	}
	/**
	 * Similar to {@link this#setPurchaseRequisitionStockDetail(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void setPurchaseRequisitionStockDetail(@NotNull PurchaseRequisitionStockDetailEntity entity) {
		setPurchaseRequisitionStockDetail(entity, true);
	}

	/**
	 * Set or update the purchaseRequisitionStockDetail in this entity with single PurchaseRequisitionStockDetailEntity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be set or updated to purchaseRequisitionStockDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseRequisitionStockDetail(@NotNull PurchaseRequisitionStockDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseRequisitionStockDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseRequisitionStockDetail here] end

		if (sameAsFormer(this.purchaseRequisitionStockDetail, entity)) {
			return;
		}

		if (this.purchaseRequisitionStockDetail != null) {
			this.purchaseRequisitionStockDetail.removePurchaseOrderStockDetails(this, false);
		}
		this.purchaseRequisitionStockDetail = entity;
		if (reverseAdd) {
			this.purchaseRequisitionStockDetail.addPurchaseOrderStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchaseRequisitionStockDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchaseRequisitionStockDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitionStockDetail(boolean)} but default to true.
	 */
	public void unsetPurchaseRequisitionStockDetail() {
		this.unsetPurchaseRequisitionStockDetail(true);
	}

	/**
	 * Remove Purchase Requisition Stock Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchaseRequisitionStockDetail(boolean reverse) {
		if (reverse && this.purchaseRequisitionStockDetail != null) {
			this.purchaseRequisitionStockDetail.removePurchaseOrderStockDetails(this, false);
		}
		this.purchaseRequisitionStockDetail = null;
	}
	/**
	 * Similar to {@link this#setStockCatalogue(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update the stockCatalogue in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogue
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.removePurchaseOrderStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addPurchaseOrderStockDetails(this, false);
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
			this.stockCatalogue.removePurchaseOrderStockDetails(this, false);
		}
		this.stockCatalogue = null;
	}

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "UNIT_PRICE,QUANTITY_ORDERED,UOP,DISCOUNT_IN_PERCENT,DISCOUNT_VALUE,TAXABLE,ITEM_PRICE,ITEM_STATUS,SOH,MAX_LEVEL,QUANTITY_RECEIVED,QUANTITY_RETURNED,ITEM_NOTES,REMAINING_QUANTITY,PURCHASE_ORDER_ID,PURCHASE_REQUISITION_STOCK_DETAIL_ID,STOCK_CATALOGUE_ID,GOODS_RECEIVE_NOTE_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<PurchaseOrderEntity> purchaseOrderRelation = Optional.ofNullable(this.purchaseOrder);
		purchaseOrderRelation.ifPresent(entity -> this.purchaseOrderId = entity.getId());

		Optional<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetailRelation = Optional.ofNullable(this.purchaseRequisitionStockDetail);
		purchaseRequisitionStockDetailRelation.ifPresent(entity -> this.purchaseRequisitionStockDetailId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		this.goodsReceiveNoteItemsIds = new HashSet<>();
		for (GoodsReceiveNoteItemEntity goodsReceiveNoteItems: this.goodsReceiveNoteItems) {
			this.goodsReceiveNoteItemsIds.add(goodsReceiveNoteItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object purchaseOrderStockDetail) {
		if (this == purchaseOrderStockDetail) {
			return true;
		}
		if (purchaseOrderStockDetail == null || this.getClass() != purchaseOrderStockDetail.getClass()) {
			return false;
		}
		if (!super.equals(purchaseOrderStockDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PurchaseOrderStockDetailEntity that = (PurchaseOrderStockDetailEntity) purchaseOrderStockDetail;
		return
			Objects.equals(this.unitPrice, that.unitPrice) &&
			Objects.equals(this.quantityOrdered, that.quantityOrdered) &&
			Objects.equals(this.uop, that.uop) &&
			Objects.equals(this.discountInPercent, that.discountInPercent) &&
			Objects.equals(this.discountValue, that.discountValue) &&
			Objects.equals(this.taxable, that.taxable) &&
			Objects.equals(this.itemPrice, that.itemPrice) &&
			Objects.equals(this.itemStatus, that.itemStatus) &&
			Objects.equals(this.soh, that.soh) &&
			Objects.equals(this.maxLevel, that.maxLevel) &&
			Objects.equals(this.quantityReceived, that.quantityReceived) &&
			Objects.equals(this.quantityReturned, that.quantityReturned) &&
			Objects.equals(this.itemNotes, that.itemNotes) &&
			Objects.equals(this.remainingQuantity, that.remainingQuantity) &&
			Objects.equals(this.goodsReceiveNoteItemsIds, that.goodsReceiveNoteItemsIds) &&
			Objects.equals(this.purchaseOrderId, that.purchaseOrderId) &&
			Objects.equals(this.purchaseRequisitionStockDetailId, that.purchaseRequisitionStockDetailId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
