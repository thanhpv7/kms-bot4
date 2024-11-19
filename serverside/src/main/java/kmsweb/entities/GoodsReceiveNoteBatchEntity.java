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
import kmsweb.dtos.GoodsReceiveNoteBatchEntityDto;
import kmsweb.entities.listeners.GoodsReceiveNoteBatchEntityListener;
import kmsweb.serializers.GoodsReceiveNoteBatchSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.time.*;
import java.time.temporal.ChronoUnit;
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
@EntityListeners({GoodsReceiveNoteBatchEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = GoodsReceiveNoteBatchSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class GoodsReceiveNoteBatchEntity extends AbstractEntity {

	/**
	 * Takes a GoodsReceiveNoteBatchEntityDto and converts it into a GoodsReceiveNoteBatchEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param goodsReceiveNoteBatchEntityDto
	 */
	public GoodsReceiveNoteBatchEntity(GoodsReceiveNoteBatchEntityDto goodsReceiveNoteBatchEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (goodsReceiveNoteBatchEntityDto.getId() != null) {
			this.setId(goodsReceiveNoteBatchEntityDto.getId());
		}

		if (goodsReceiveNoteBatchEntityDto.getItemLineNumber() != null) {
			this.setItemLineNumber(goodsReceiveNoteBatchEntityDto.getItemLineNumber());
		}

		if (goodsReceiveNoteBatchEntityDto.getTransactionNumber() != null) {
			this.setTransactionNumber(goodsReceiveNoteBatchEntityDto.getTransactionNumber());
		}

		if (goodsReceiveNoteBatchEntityDto.getTransactionDate() != null) {
			this.setTransactionDate(goodsReceiveNoteBatchEntityDto.getTransactionDate());
		}

		if (goodsReceiveNoteBatchEntityDto.getBatchNumber() != null) {
			this.setBatchNumber(goodsReceiveNoteBatchEntityDto.getBatchNumber());
		}

		if (goodsReceiveNoteBatchEntityDto.getExpirationDate() != null) {
			this.setExpirationDate(goodsReceiveNoteBatchEntityDto.getExpirationDate());
		}

		if (goodsReceiveNoteBatchEntityDto.getBatchQtyUOMTransaction() != null) {
			this.setBatchQtyUOMTransaction(goodsReceiveNoteBatchEntityDto.getBatchQtyUOMTransaction());
		}

		if (goodsReceiveNoteBatchEntityDto.getUomTransaction() != null) {
			this.setUomTransaction(goodsReceiveNoteBatchEntityDto.getUomTransaction());
		}

		if (goodsReceiveNoteBatchEntityDto.getBatchQtyUOI() != null) {
			this.setBatchQtyUOI(goodsReceiveNoteBatchEntityDto.getBatchQtyUOI());
		}

		if (goodsReceiveNoteBatchEntityDto.getUoi() != null) {
			this.setUoi(goodsReceiveNoteBatchEntityDto.getUoi());
		}

		if (goodsReceiveNoteBatchEntityDto.getBatchItemNotes() != null) {
			this.setBatchItemNotes(goodsReceiveNoteBatchEntityDto.getBatchItemNotes());
		}

		if (goodsReceiveNoteBatchEntityDto.getGoodsReceiveNoteItem() != null) {
			this.setGoodsReceiveNoteItem(goodsReceiveNoteBatchEntityDto.getGoodsReceiveNoteItem());
		}

		if (goodsReceiveNoteBatchEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(goodsReceiveNoteBatchEntityDto.getStockCatalogue());
		}

		if (goodsReceiveNoteBatchEntityDto.getWarehouse() != null) {
			this.setWarehouse(goodsReceiveNoteBatchEntityDto.getWarehouse());
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

	// % protected region % [Modify attribute annotation for Transaction Number here] off begin
	@CsvBindByName(column = "TRANSACTION_NUMBER", required = false)
	@Nullable
	@Column(name = "transaction_number")
	@Schema(description = "The Transaction Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Number here] end
	private String transactionNumber;

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin

	@CsvCustomBindByName(column = "TRANSACTION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "transaction_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Transaction Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Batch Number here] off begin
	@CsvBindByName(column = "BATCH_NUMBER", required = false)
	@Nullable
	@Column(name = "batch_number")
	@Schema(description = "The Batch Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch Number here] end
	private String batchNumber;

	// % protected region % [Modify attribute annotation for Expiration Date here] off begin

	@CsvCustomBindByName(column = "EXPIRATION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "expiration_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Expiration Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Expiration Date here] end
	private OffsetDateTime expirationDate;

	// % protected region % [Modify attribute annotation for Batch Qty UOM Transaction here] off begin
	@CsvBindByName(column = "BATCH_QTY_UOM_TRANSACTION", required = false)
	@Nullable
	@Column(name = "batch_qty_uom_transaction")
	@Schema(description = "The Batch Qty UOM Transaction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch Qty UOM Transaction here] end
	private Double batchQtyUOMTransaction;

	// % protected region % [Modify attribute annotation for UOM Transaction here] off begin
	@CsvBindByName(column = "UOM_TRANSACTION", required = false)
	@Nullable
	@Column(name = "uom_transaction")
	@Schema(description = "The UOM Transaction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOM Transaction here] end
	private String uomTransaction;

	// % protected region % [Modify attribute annotation for Batch Qty UOI here] off begin
	@CsvBindByName(column = "BATCH_QTY_UOI", required = false)
	@Nullable
	@Column(name = "batch_qty_uoi")
	@Schema(description = "The Batch Qty UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch Qty UOI here] end
	private Double batchQtyUOI;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Batch Item Notes here] off begin
	@CsvBindByName(column = "BATCH_ITEM_NOTES", required = false)
	@Nullable
	@Column(name = "batch_item_notes")
	@Schema(description = "The Batch Item Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch Item Notes here] end
	private String batchItemNotes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Goods Receive Note Item here] off begin
	@Schema(description = "The Goods Receive Note Item entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Goods Receive Note Item here] end
	private GoodsReceiveNoteItemEntity goodsReceiveNoteItem;

	// % protected region % [Update the annotation for goodsReceiveNoteItemId here] off begin
	@Transient
	@CsvCustomBindByName(column = "GOODS_RECEIVE_NOTE_ITEM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for goodsReceiveNoteItemId here] end
	private UUID goodsReceiveNoteItemId;

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

	// % protected region % [Update the annotation for Warehouse here] off begin
	@Schema(description = "The Warehouse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse here] end
	private WarehouseEntity warehouse;

	// % protected region % [Update the annotation for warehouseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for warehouseId here] end
	private UUID warehouseId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setGoodsReceiveNoteItem(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteItem(@NotNull GoodsReceiveNoteItemEntity entity) {
		setGoodsReceiveNoteItem(entity, true);
	}

	/**
	 * Set or update the goodsReceiveNoteItem in this entity with single GoodsReceiveNoteItemEntity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be set or updated to goodsReceiveNoteItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setGoodsReceiveNoteItem(@NotNull GoodsReceiveNoteItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNoteItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setGoodsReceiveNoteItem here] end

		if (sameAsFormer(this.goodsReceiveNoteItem, entity)) {
			return;
		}

		if (this.goodsReceiveNoteItem != null) {
			this.goodsReceiveNoteItem.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.goodsReceiveNoteItem = entity;
		if (reverseAdd) {
			this.goodsReceiveNoteItem.addGoodsReceiveNoteBatchs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNoteItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setGoodsReceiveNoteItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteItem(boolean)} but default to true.
	 */
	public void unsetGoodsReceiveNoteItem() {
		this.unsetGoodsReceiveNoteItem(true);
	}

	/**
	 * Remove Goods Receive Note Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetGoodsReceiveNoteItem(boolean reverse) {
		if (reverse && this.goodsReceiveNoteItem != null) {
			this.goodsReceiveNoteItem.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.goodsReceiveNoteItem = null;
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
			this.stockCatalogue.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addGoodsReceiveNoteBatchs(this, false);
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
			this.stockCatalogue.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.stockCatalogue = null;
	}
	/**
	 * Similar to {@link this#setWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setWarehouse(@NotNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NotNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] end

		if (sameAsFormer(this.warehouse, entity)) {
			return;
		}

		if (this.warehouse != null) {
			this.warehouse.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addGoodsReceiveNoteBatchs(this, false);
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
			this.warehouse.removeGoodsReceiveNoteBatchs(this, false);
		}
		this.warehouse = null;
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
		return "ITEM_LINE_NUMBER,TRANSACTION_NUMBER,TRANSACTION_DATE,BATCH_NUMBER,EXPIRATION_DATE,BATCH_QTY_UOM_TRANSACTION,UOM_TRANSACTION,BATCH_QTY_UOI,UOI,BATCH_ITEM_NOTES,GOODS_RECEIVE_NOTE_ITEM_ID,STOCK_CATALOGUE_ID,WAREHOUSE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<GoodsReceiveNoteItemEntity> goodsReceiveNoteItemRelation = Optional.ofNullable(this.goodsReceiveNoteItem);
		goodsReceiveNoteItemRelation.ifPresent(entity -> this.goodsReceiveNoteItemId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object goodsReceiveNoteBatch) {
		if (this == goodsReceiveNoteBatch) {
			return true;
		}
		if (goodsReceiveNoteBatch == null || this.getClass() != goodsReceiveNoteBatch.getClass()) {
			return false;
		}
		if (!super.equals(goodsReceiveNoteBatch)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		GoodsReceiveNoteBatchEntity that = (GoodsReceiveNoteBatchEntity) goodsReceiveNoteBatch;
		return
			Objects.equals(this.itemLineNumber, that.itemLineNumber) &&
			Objects.equals(this.transactionNumber, that.transactionNumber) &&
			Objects.equals(
			     this.transactionDate != null ? this.transactionDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.transactionDate != null ? that.transactionDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.batchNumber, that.batchNumber) &&
			Objects.equals(
			     this.expirationDate != null ? this.expirationDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.expirationDate != null ? that.expirationDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.batchQtyUOMTransaction, that.batchQtyUOMTransaction) &&
			Objects.equals(this.uomTransaction, that.uomTransaction) &&
			Objects.equals(this.batchQtyUOI, that.batchQtyUOI) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.batchItemNotes, that.batchItemNotes) &&
			Objects.equals(this.goodsReceiveNoteItemId, that.goodsReceiveNoteItemId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
