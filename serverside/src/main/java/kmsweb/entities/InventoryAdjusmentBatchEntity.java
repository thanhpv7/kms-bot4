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
import kmsweb.dtos.InventoryAdjusmentBatchEntityDto;
import kmsweb.entities.listeners.InventoryAdjusmentBatchEntityListener;
import kmsweb.serializers.InventoryAdjusmentBatchSerializer;
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
@EntityListeners({InventoryAdjusmentBatchEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InventoryAdjusmentBatchSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InventoryAdjusmentBatchEntity extends AbstractEntity {

	/**
	 * Takes a InventoryAdjusmentBatchEntityDto and converts it into a InventoryAdjusmentBatchEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param inventoryAdjusmentBatchEntityDto
	 */
	public InventoryAdjusmentBatchEntity(InventoryAdjusmentBatchEntityDto inventoryAdjusmentBatchEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (inventoryAdjusmentBatchEntityDto.getId() != null) {
			this.setId(inventoryAdjusmentBatchEntityDto.getId());
		}

		if (inventoryAdjusmentBatchEntityDto.getItemLineNumber() != null) {
			this.setItemLineNumber(inventoryAdjusmentBatchEntityDto.getItemLineNumber());
		}

		if (inventoryAdjusmentBatchEntityDto.getTransactionNumber() != null) {
			this.setTransactionNumber(inventoryAdjusmentBatchEntityDto.getTransactionNumber());
		}

		if (inventoryAdjusmentBatchEntityDto.getTransactionDate() != null) {
			this.setTransactionDate(inventoryAdjusmentBatchEntityDto.getTransactionDate());
		}

		if (inventoryAdjusmentBatchEntityDto.getBatchNo() != null) {
			this.setBatchNo(inventoryAdjusmentBatchEntityDto.getBatchNo());
		}

		if (inventoryAdjusmentBatchEntityDto.getExpirationDate() != null) {
			this.setExpirationDate(inventoryAdjusmentBatchEntityDto.getExpirationDate());
		}

		if (inventoryAdjusmentBatchEntityDto.getBatchQtyUomTransaction() != null) {
			this.setBatchQtyUomTransaction(inventoryAdjusmentBatchEntityDto.getBatchQtyUomTransaction());
		}

		if (inventoryAdjusmentBatchEntityDto.getUomTransaction() != null) {
			this.setUomTransaction(inventoryAdjusmentBatchEntityDto.getUomTransaction());
		}

		if (inventoryAdjusmentBatchEntityDto.getBatchQtyUoi() != null) {
			this.setBatchQtyUoi(inventoryAdjusmentBatchEntityDto.getBatchQtyUoi());
		}

		if (inventoryAdjusmentBatchEntityDto.getUoi() != null) {
			this.setUoi(inventoryAdjusmentBatchEntityDto.getUoi());
		}

		if (inventoryAdjusmentBatchEntityDto.getBatchItemNotes() != null) {
			this.setBatchItemNotes(inventoryAdjusmentBatchEntityDto.getBatchItemNotes());
		}

		if (inventoryAdjusmentBatchEntityDto.getInventoryAdjustmentItem() != null) {
			this.setInventoryAdjustmentItem(inventoryAdjusmentBatchEntityDto.getInventoryAdjustmentItem());
		}

		if (inventoryAdjusmentBatchEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(inventoryAdjusmentBatchEntityDto.getStockCatalogue());
		}

		if (inventoryAdjusmentBatchEntityDto.getWarehouse() != null) {
			this.setWarehouse(inventoryAdjusmentBatchEntityDto.getWarehouse());
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

	// % protected region % [Modify attribute annotation for Batch No here] off begin
	@CsvBindByName(column = "BATCH_NO", required = false)
	@Nullable
	@Column(name = "batch_no")
	@Schema(description = "The Batch No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch No here] end
	private String batchNo;

	// % protected region % [Modify attribute annotation for Expiration Date here] off begin
	@CsvCustomBindByName(column = "EXPIRATION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "expiration_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Expiration Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Expiration Date here] end
	private OffsetDateTime expirationDate;

	// % protected region % [Modify attribute annotation for Batch Qty Uom Transaction here] off begin
	@CsvBindByName(column = "BATCH_QTY_UOM_TRANSACTION", required = false)
	@Nullable
	@Column(name = "batch_qty_uom_transaction")
	@Schema(description = "The Batch Qty Uom Transaction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch Qty Uom Transaction here] end
	private Double batchQtyUomTransaction;

	// % protected region % [Modify attribute annotation for Uom Transaction here] off begin
	@CsvBindByName(column = "UOM_TRANSACTION", required = false)
	@Nullable
	@Column(name = "uom_transaction")
	@Schema(description = "The Uom Transaction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uom Transaction here] end
	private String uomTransaction;

	// % protected region % [Modify attribute annotation for Batch Qty Uoi here] off begin
	@CsvBindByName(column = "BATCH_QTY_UOI", required = false)
	@Nullable
	@Column(name = "batch_qty_uoi")
	@Schema(description = "The Batch Qty Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch Qty Uoi here] end
	private Double batchQtyUoi;

	// % protected region % [Modify attribute annotation for Uoi here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uoi here] end
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

	// % protected region % [Update the annotation for Inventory Adjustment Item here] off begin
	@Schema(description = "The Inventory Adjustment Item entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Adjustment Item here] end
	private InventoryAdjustmentItemEntity inventoryAdjustmentItem;

	// % protected region % [Update the annotation for inventoryAdjustmentItemId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_ADJUSTMENT_ITEM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for inventoryAdjustmentItemId here] end
	private UUID inventoryAdjustmentItemId;

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
	 * Similar to {@link this#setInventoryAdjustmentItem(InventoryAdjustmentItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be set to this entity
	 */
	public void setInventoryAdjustmentItem(@NotNull InventoryAdjustmentItemEntity entity) {
		setInventoryAdjustmentItem(entity, true);
	}

	/**
	 * Set or update the inventoryAdjustmentItem in this entity with single InventoryAdjustmentItemEntity.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be set or updated to inventoryAdjustmentItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInventoryAdjustmentItem(@NotNull InventoryAdjustmentItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInventoryAdjustmentItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInventoryAdjustmentItem here] end

		if (sameAsFormer(this.inventoryAdjustmentItem, entity)) {
			return;
		}

		if (this.inventoryAdjustmentItem != null) {
			this.inventoryAdjustmentItem.removeInventoryAdjusmentBatchs(this, false);
		}
		this.inventoryAdjustmentItem = entity;
		if (reverseAdd) {
			this.inventoryAdjustmentItem.addInventoryAdjusmentBatchs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInventoryAdjustmentItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInventoryAdjustmentItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustmentItem(boolean)} but default to true.
	 */
	public void unsetInventoryAdjustmentItem() {
		this.unsetInventoryAdjustmentItem(true);
	}

	/**
	 * Remove Inventory Adjustment Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInventoryAdjustmentItem(boolean reverse) {
		if (reverse && this.inventoryAdjustmentItem != null) {
			this.inventoryAdjustmentItem.removeInventoryAdjusmentBatchs(this, false);
		}
		this.inventoryAdjustmentItem = null;
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
			this.stockCatalogue.removeInventoryAdjusmentBatchs(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addInventoryAdjusmentBatchs(this, false);
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
			this.stockCatalogue.removeInventoryAdjusmentBatchs(this, false);
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
			this.warehouse.removeInventoryAdjusmentBatchs(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addInventoryAdjusmentBatchs(this, false);
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
			this.warehouse.removeInventoryAdjusmentBatchs(this, false);
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
		return "ITEM_LINE_NUMBER,TRANSACTION_NUMBER,TRANSACTION_DATE,BATCH_NO,EXPIRATION_DATE,BATCH_QTY_UOM_TRANSACTION,UOM_TRANSACTION,BATCH_QTY_UOI,UOI,BATCH_ITEM_NOTES,INVENTORY_ADJUSTMENT_ITEM_ID,STOCK_CATALOGUE_ID,WAREHOUSE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<InventoryAdjustmentItemEntity> inventoryAdjustmentItemRelation = Optional.ofNullable(this.inventoryAdjustmentItem);
		inventoryAdjustmentItemRelation.ifPresent(entity -> this.inventoryAdjustmentItemId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object inventoryAdjusmentBatch) {
		if (this == inventoryAdjusmentBatch) {
			return true;
		}
		if (inventoryAdjusmentBatch == null || this.getClass() != inventoryAdjusmentBatch.getClass()) {
			return false;
		}
		if (!super.equals(inventoryAdjusmentBatch)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InventoryAdjusmentBatchEntity that = (InventoryAdjusmentBatchEntity) inventoryAdjusmentBatch;
		return
			Objects.equals(this.itemLineNumber, that.itemLineNumber) &&
			Objects.equals(this.transactionNumber, that.transactionNumber) &&
			Objects.equals(
			     this.transactionDate != null ? this.transactionDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.transactionDate != null ? that.transactionDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.batchNo, that.batchNo) &&
			Objects.equals(
			     this.expirationDate != null ? this.expirationDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.expirationDate != null ? that.expirationDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.batchQtyUomTransaction, that.batchQtyUomTransaction) &&
			Objects.equals(this.uomTransaction, that.uomTransaction) &&
			Objects.equals(this.batchQtyUoi, that.batchQtyUoi) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.batchItemNotes, that.batchItemNotes) &&
			Objects.equals(this.inventoryAdjustmentItemId, that.inventoryAdjustmentItemId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
