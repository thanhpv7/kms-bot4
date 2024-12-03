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
import kmsweb.dtos.GoodsReceiveNoteItemEntityDto;
import kmsweb.entities.listeners.GoodsReceiveNoteItemEntityListener;
import kmsweb.serializers.GoodsReceiveNoteItemSerializer;
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
@EntityListeners({GoodsReceiveNoteItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = GoodsReceiveNoteItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class GoodsReceiveNoteItemEntity extends AbstractEntity {

	/**
	 * Takes a GoodsReceiveNoteItemEntityDto and converts it into a GoodsReceiveNoteItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param goodsReceiveNoteItemEntityDto
	 */
	public GoodsReceiveNoteItemEntity(GoodsReceiveNoteItemEntityDto goodsReceiveNoteItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (goodsReceiveNoteItemEntityDto.getId() != null) {
			this.setId(goodsReceiveNoteItemEntityDto.getId());
		}

		if (goodsReceiveNoteItemEntityDto.getItemLineNumber() != null) {
			this.setItemLineNumber(goodsReceiveNoteItemEntityDto.getItemLineNumber());
		}

		if (goodsReceiveNoteItemEntityDto.getUop() != null) {
			this.setUop(goodsReceiveNoteItemEntityDto.getUop());
		}

		if (goodsReceiveNoteItemEntityDto.getQtyReceived() != null) {
			this.setQtyReceived(goodsReceiveNoteItemEntityDto.getQtyReceived());
		}

		if (goodsReceiveNoteItemEntityDto.getQtyOrdered() != null) {
			this.setQtyOrdered(goodsReceiveNoteItemEntityDto.getQtyOrdered());
		}

		if (goodsReceiveNoteItemEntityDto.getPrice() != null) {
			this.setPrice(goodsReceiveNoteItemEntityDto.getPrice());
		}

		if (goodsReceiveNoteItemEntityDto.getTotalItemPrice() != null) {
			this.setTotalItemPrice(goodsReceiveNoteItemEntityDto.getTotalItemPrice());
		}

		if (goodsReceiveNoteItemEntityDto.getItemNotes() != null) {
			this.setItemNotes(goodsReceiveNoteItemEntityDto.getItemNotes());
		}

		if (goodsReceiveNoteItemEntityDto.getPrevQtyReceived() != null) {
			this.setPrevQtyReceived(goodsReceiveNoteItemEntityDto.getPrevQtyReceived());
		}

		if (goodsReceiveNoteItemEntityDto.getUoi() != null) {
			this.setUoi(goodsReceiveNoteItemEntityDto.getUoi());
		}

		if (goodsReceiveNoteItemEntityDto.getQtyReceivedUOI() != null) {
			this.setQtyReceivedUOI(goodsReceiveNoteItemEntityDto.getQtyReceivedUOI());
		}

		if (goodsReceiveNoteItemEntityDto.getPriceUOI() != null) {
			this.setPriceUOI(goodsReceiveNoteItemEntityDto.getPriceUOI());
		}

		if (goodsReceiveNoteItemEntityDto.getOnHandQtyUOP() != null) {
			this.setOnHandQtyUOP(goodsReceiveNoteItemEntityDto.getOnHandQtyUOP());
		}

		if (goodsReceiveNoteItemEntityDto.getMaxLevelUOP() != null) {
			this.setMaxLevelUOP(goodsReceiveNoteItemEntityDto.getMaxLevelUOP());
		}

		if (goodsReceiveNoteItemEntityDto.getDiscountValue() != null) {
			this.setDiscountValue(goodsReceiveNoteItemEntityDto.getDiscountValue());
		}

		if (goodsReceiveNoteItemEntityDto.getTaxValue() != null) {
			this.setTaxValue(goodsReceiveNoteItemEntityDto.getTaxValue());
		}

		if (goodsReceiveNoteItemEntityDto.getInventoryRoundingValue() != null) {
			this.setInventoryRoundingValue(goodsReceiveNoteItemEntityDto.getInventoryRoundingValue());
		}

		if (goodsReceiveNoteItemEntityDto.getDiscountInPercent() != null) {
			this.setDiscountInPercent(goodsReceiveNoteItemEntityDto.getDiscountInPercent());
		}

		if (goodsReceiveNoteItemEntityDto.getTaxInPercent() != null) {
			this.setTaxInPercent(goodsReceiveNoteItemEntityDto.getTaxInPercent());
		}

		if (goodsReceiveNoteItemEntityDto.getGoodsReceiveNoteBatchs() != null) {
			this.setGoodsReceiveNoteBatchs(goodsReceiveNoteItemEntityDto.getGoodsReceiveNoteBatchs());
		}

		if (goodsReceiveNoteItemEntityDto.getGoodsReceiveNote() != null) {
			this.setGoodsReceiveNote(goodsReceiveNoteItemEntityDto.getGoodsReceiveNote());
		}

		if (goodsReceiveNoteItemEntityDto.getPurchaseOrderStockDetail() != null) {
			this.setPurchaseOrderStockDetail(goodsReceiveNoteItemEntityDto.getPurchaseOrderStockDetail());
		}

		if (goodsReceiveNoteItemEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(goodsReceiveNoteItemEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Item Line Number here] off begin
	@CsvBindByName(column = "ITEM_LINE_NUMBER", required = false)
	@Nullable
	@Column(name = "item_line_number")
	@Schema(description = "The Item Line Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Line Number here] end
	private Integer itemLineNumber;

	// % protected region % [Modify attribute annotation for UOP here] off begin
	@CsvBindByName(column = "UOP", required = false)
	@Nullable
	@Column(name = "uop")
	@Schema(description = "The UOP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOP here] end
	private String uop;

	// % protected region % [Modify attribute annotation for Qty Received here] off begin
	@CsvBindByName(column = "QTY_RECEIVED", required = false)
	@Nullable
	@Column(name = "qty_received")
	@Schema(description = "The Qty Received of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty Received here] end
	private Double qtyReceived;

	// % protected region % [Modify attribute annotation for Qty Ordered here] off begin
	@CsvBindByName(column = "QTY_ORDERED", required = false)
	@Nullable
	@Column(name = "qty_ordered")
	@Schema(description = "The Qty Ordered of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty Ordered here] end
	private Double qtyOrdered;

	// % protected region % [Modify attribute annotation for Price here] off begin
	@CsvBindByName(column = "PRICE", required = false)
	@Nullable
	@Column(name = "price")
	@Schema(description = "The Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Total Item Price here] off begin
	@CsvBindByName(column = "TOTAL_ITEM_PRICE", required = false)
	@Nullable
	@Column(name = "total_item_price")
	@Schema(description = "The Total Item Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Item Price here] end
	private Double totalItemPrice;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@CsvBindByName(column = "ITEM_NOTES", required = false)
	@Nullable
	@Column(name = "item_notes")
	@Schema(description = "The Item Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for Prev Qty Received here] off begin
	@CsvBindByName(column = "PREV_QTY_RECEIVED", required = false)
	@Nullable
	@Column(name = "prev_qty_received")
	@Schema(description = "The Prev Qty Received of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Prev Qty Received here] end
	private Double prevQtyReceived;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Qty Received UOI here] off begin
	@CsvBindByName(column = "QTY_RECEIVED_UOI", required = false)
	@Nullable
	@Column(name = "qty_received_uoi")
	@Schema(description = "The Qty Received UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty Received UOI here] end
	private Double qtyReceivedUOI;

	// % protected region % [Modify attribute annotation for Price UOI here] off begin
	@CsvBindByName(column = "PRICE_UOI", required = false)
	@Nullable
	@Column(name = "price_uoi")
	@Schema(description = "The Price UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price UOI here] end
	private Double priceUOI;

	// % protected region % [Modify attribute annotation for On Hand Qty UOP here] off begin
	@CsvBindByName(column = "ON_HAND_QTY_UOP", required = false)
	@Nullable
	@Column(name = "on_hand_qty_uop")
	@Schema(description = "The On Hand Qty UOP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for On Hand Qty UOP here] end
	private Double onHandQtyUOP;

	// % protected region % [Modify attribute annotation for Max Level UOP here] off begin
	@CsvBindByName(column = "MAX_LEVEL_UOP", required = false)
	@Nullable
	@Column(name = "max_level_uop")
	@Schema(description = "The Max Level UOP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Max Level UOP here] end
	private Double maxLevelUOP;

	// % protected region % [Modify attribute annotation for Discount Value here] off begin
	@CsvBindByName(column = "DISCOUNT_VALUE", required = false)
	@Nullable
	@Column(name = "discount_value")
	@Schema(description = "The Discount Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discount Value here] end
	private Double discountValue;

	// % protected region % [Modify attribute annotation for Tax Value here] off begin
	@CsvBindByName(column = "TAX_VALUE", required = false)
	@Nullable
	@Column(name = "tax_value")
	@Schema(description = "The Tax Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Value here] end
	private Double taxValue;

	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] off begin
	@CsvBindByName(column = "INVENTORY_ROUNDING_VALUE", required = false)
	@Nullable
	@Column(name = "inventory_rounding_value")
	@Schema(description = "The Inventory Rounding Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] end
	private Double inventoryRoundingValue;

	// % protected region % [Modify attribute annotation for Discount In Percent here] off begin
	@CsvBindByName(column = "DISCOUNT_IN_PERCENT", required = false)
	@Nullable
	@Column(name = "discount_in_percent")
	@Schema(description = "The Discount In Percent of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discount In Percent here] end
	private Boolean discountInPercent = false ;

	// % protected region % [Modify attribute annotation for Tax In Percent here] off begin
	@CsvBindByName(column = "TAX_IN_PERCENT", required = false)
	@Nullable
	@Column(name = "tax_in_percent")
	@Schema(description = "The Tax In Percent of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax In Percent here] end
	private Boolean taxInPercent = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Goods Receive Note Batchs here] off begin
	@Schema(description = "The Goods Receive Note Batch entities that are related to this entity.")
	@OneToMany(mappedBy = "goodsReceiveNoteItem", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Goods Receive Note Batchs here] end
	private Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();

	// % protected region % [Update the annotation for goodsReceiveNoteBatchsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "GOODS_RECEIVE_NOTE_BATCHS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for goodsReceiveNoteBatchsIds here] end
	private Set<UUID> goodsReceiveNoteBatchsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Goods Receive Note here] off begin
	@Schema(description = "The Goods Receive Note entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Goods Receive Note here] end
	private GoodsReceiveNoteEntity goodsReceiveNote;

	// % protected region % [Update the annotation for goodsReceiveNoteId here] off begin
	@Transient
	@CsvCustomBindByName(column = "GOODS_RECEIVE_NOTE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for goodsReceiveNoteId here] end
	private UUID goodsReceiveNoteId;

	// % protected region % [Update the annotation for Purchase Order Stock Detail here] off begin
	@Schema(description = "The Purchase Order Stock Detail entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Order Stock Detail here] end
	private PurchaseOrderStockDetailEntity purchaseOrderStockDetail;

	// % protected region % [Update the annotation for purchaseOrderStockDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_ORDER_STOCK_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for purchaseOrderStockDetailId here] end
	private UUID purchaseOrderStockDetailId;

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
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NotNull GoodsReceiveNoteBatchEntity entity) {
		addGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteBatchEntity to goodsReceiveNoteBatchs in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteBatchs.contains(entity)) {
			goodsReceiveNoteBatchs.add(entity);
			if (reverseAdd) {
				entity.setGoodsReceiveNoteItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NotNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		addGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteBatchEntity to Goods Receive Note Batchs in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NotNull GoodsReceiveNoteBatchEntity entity) {
		this.removeGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteBatchEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NotNull GoodsReceiveNoteBatchEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetGoodsReceiveNoteItem(false);
		}
		this.goodsReceiveNoteBatchs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NotNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		this.removeGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteBatchEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteBatchs(@NotNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		setGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Batchs with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteBatchs(@NotNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteBatchs();
		this.goodsReceiveNoteBatchs = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.setGoodsReceiveNoteItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteBatchs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteBatchs() {
		this.unsetGoodsReceiveNoteBatchs(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Batchs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteBatchs(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.unsetGoodsReceiveNoteItem(false));
		}
		this.goodsReceiveNoteBatchs.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setGoodsReceiveNote(GoodsReceiveNoteEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be set to this entity
	 */
	public void setGoodsReceiveNote(@NotNull GoodsReceiveNoteEntity entity) {
		setGoodsReceiveNote(entity, true);
	}

	/**
	 * Set or update the goodsReceiveNote in this entity with single GoodsReceiveNoteEntity.
	 *
	 * @param entity the given GoodsReceiveNoteEntity to be set or updated to goodsReceiveNote
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setGoodsReceiveNote(@NotNull GoodsReceiveNoteEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNote here] off begin
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNote here] end

		if (sameAsFormer(this.goodsReceiveNote, entity)) {
			return;
		}

		if (this.goodsReceiveNote != null) {
			this.goodsReceiveNote.removeGoodsReceiveNoteItems(this, false);
		}
		this.goodsReceiveNote = entity;
		if (reverseAdd) {
			this.goodsReceiveNote.addGoodsReceiveNoteItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNote incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNote incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNote(boolean)} but default to true.
	 */
	public void unsetGoodsReceiveNote() {
		this.unsetGoodsReceiveNote(true);
	}

	/**
	 * Remove Goods Receive Note in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetGoodsReceiveNote(boolean reverse) {
		if (reverse && this.goodsReceiveNote != null) {
			this.goodsReceiveNote.removeGoodsReceiveNoteItems(this, false);
		}
		this.goodsReceiveNote = null;
	}
	/**
	 * Similar to {@link this#setPurchaseOrderStockDetail(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void setPurchaseOrderStockDetail(@NotNull PurchaseOrderStockDetailEntity entity) {
		setPurchaseOrderStockDetail(entity, true);
	}

	/**
	 * Set or update the purchaseOrderStockDetail in this entity with single PurchaseOrderStockDetailEntity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be set or updated to purchaseOrderStockDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseOrderStockDetail(@NotNull PurchaseOrderStockDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrderStockDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseOrderStockDetail here] end

		if (sameAsFormer(this.purchaseOrderStockDetail, entity)) {
			return;
		}

		if (this.purchaseOrderStockDetail != null) {
			this.purchaseOrderStockDetail.removeGoodsReceiveNoteItems(this, false);
		}
		this.purchaseOrderStockDetail = entity;
		if (reverseAdd) {
			this.purchaseOrderStockDetail.addGoodsReceiveNoteItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrderStockDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchaseOrderStockDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrderStockDetail(boolean)} but default to true.
	 */
	public void unsetPurchaseOrderStockDetail() {
		this.unsetPurchaseOrderStockDetail(true);
	}

	/**
	 * Remove Purchase Order Stock Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchaseOrderStockDetail(boolean reverse) {
		if (reverse && this.purchaseOrderStockDetail != null) {
			this.purchaseOrderStockDetail.removeGoodsReceiveNoteItems(this, false);
		}
		this.purchaseOrderStockDetail = null;
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
			this.stockCatalogue.removeGoodsReceiveNoteItems(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addGoodsReceiveNoteItems(this, false);
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
			this.stockCatalogue.removeGoodsReceiveNoteItems(this, false);
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
		return "ITEM_LINE_NUMBER,UOP,QTY_RECEIVED,QTY_ORDERED,PRICE,TOTAL_ITEM_PRICE,ITEM_NOTES,PREV_QTY_RECEIVED,UOI,QTY_RECEIVED_UOI,PRICE_UOI,ON_HAND_QTY_UOP,MAX_LEVEL_UOP,DISCOUNT_VALUE,TAX_VALUE,INVENTORY_ROUNDING_VALUE,DISCOUNT_IN_PERCENT,TAX_IN_PERCENT,GOODS_RECEIVE_NOTE_ID,PURCHASE_ORDER_STOCK_DETAIL_ID,STOCK_CATALOGUE_ID,GOODS_RECEIVE_NOTE_BATCHS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<GoodsReceiveNoteEntity> goodsReceiveNoteRelation = Optional.ofNullable(this.goodsReceiveNote);
		goodsReceiveNoteRelation.ifPresent(entity -> this.goodsReceiveNoteId = entity.getId());

		Optional<PurchaseOrderStockDetailEntity> purchaseOrderStockDetailRelation = Optional.ofNullable(this.purchaseOrderStockDetail);
		purchaseOrderStockDetailRelation.ifPresent(entity -> this.purchaseOrderStockDetailId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		this.goodsReceiveNoteBatchsIds = new HashSet<>();
		for (GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchs: this.goodsReceiveNoteBatchs) {
			this.goodsReceiveNoteBatchsIds.add(goodsReceiveNoteBatchs.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object goodsReceiveNoteItem) {
		if (this == goodsReceiveNoteItem) {
			return true;
		}
		if (goodsReceiveNoteItem == null || this.getClass() != goodsReceiveNoteItem.getClass()) {
			return false;
		}
		if (!super.equals(goodsReceiveNoteItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		GoodsReceiveNoteItemEntity that = (GoodsReceiveNoteItemEntity) goodsReceiveNoteItem;
		return
			Objects.equals(this.itemLineNumber, that.itemLineNumber) &&
			Objects.equals(this.uop, that.uop) &&
			Objects.equals(this.qtyReceived, that.qtyReceived) &&
			Objects.equals(this.qtyOrdered, that.qtyOrdered) &&
			Objects.equals(this.price, that.price) &&
			Objects.equals(this.totalItemPrice, that.totalItemPrice) &&
			Objects.equals(this.itemNotes, that.itemNotes) &&
			Objects.equals(this.prevQtyReceived, that.prevQtyReceived) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.qtyReceivedUOI, that.qtyReceivedUOI) &&
			Objects.equals(this.priceUOI, that.priceUOI) &&
			Objects.equals(this.onHandQtyUOP, that.onHandQtyUOP) &&
			Objects.equals(this.maxLevelUOP, that.maxLevelUOP) &&
			Objects.equals(this.discountValue, that.discountValue) &&
			Objects.equals(this.taxValue, that.taxValue) &&
			Objects.equals(this.inventoryRoundingValue, that.inventoryRoundingValue) &&
			Objects.equals(this.discountInPercent, that.discountInPercent) &&
			Objects.equals(this.taxInPercent, that.taxInPercent) &&
			Objects.equals(this.goodsReceiveNoteBatchsIds, that.goodsReceiveNoteBatchsIds) &&
			Objects.equals(this.goodsReceiveNoteId, that.goodsReceiveNoteId) &&
			Objects.equals(this.purchaseOrderStockDetailId, that.purchaseOrderStockDetailId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
