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
import kmsweb.dtos.StockTransactionDetailEntityDto;
import kmsweb.entities.listeners.StockTransactionDetailEntityListener;
import kmsweb.serializers.StockTransactionDetailSerializer;
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
@EntityListeners({StockTransactionDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = StockTransactionDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class StockTransactionDetailEntity extends AbstractEntity {

	/**
	 * Takes a StockTransactionDetailEntityDto and converts it into a StockTransactionDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param stockTransactionDetailEntityDto
	 */
	public StockTransactionDetailEntity(StockTransactionDetailEntityDto stockTransactionDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (stockTransactionDetailEntityDto.getId() != null) {
			this.setId(stockTransactionDetailEntityDto.getId());
		}

		if (stockTransactionDetailEntityDto.getTransactionNumber() != null) {
			this.setTransactionNumber(stockTransactionDetailEntityDto.getTransactionNumber());
		}

		if (stockTransactionDetailEntityDto.getTransactionDate() != null) {
			this.setTransactionDate(stockTransactionDetailEntityDto.getTransactionDate());
		}

		if (stockTransactionDetailEntityDto.getTransactionType() != null) {
			this.setTransactionType(stockTransactionDetailEntityDto.getTransactionType());
		}

		if (stockTransactionDetailEntityDto.getTransactionNotes() != null) {
			this.setTransactionNotes(stockTransactionDetailEntityDto.getTransactionNotes());
		}

		if (stockTransactionDetailEntityDto.getItemLineNumber() != null) {
			this.setItemLineNumber(stockTransactionDetailEntityDto.getItemLineNumber());
		}

		if (stockTransactionDetailEntityDto.getItemNotes() != null) {
			this.setItemNotes(stockTransactionDetailEntityDto.getItemNotes());
		}

		if (stockTransactionDetailEntityDto.getQtyUoi() != null) {
			this.setQtyUoi(stockTransactionDetailEntityDto.getQtyUoi());
		}

		if (stockTransactionDetailEntityDto.getQtyUomTransaction() != null) {
			this.setQtyUomTransaction(stockTransactionDetailEntityDto.getQtyUomTransaction());
		}

		if (stockTransactionDetailEntityDto.getTotalCost() != null) {
			this.setTotalCost(stockTransactionDetailEntityDto.getTotalCost());
		}

		if (stockTransactionDetailEntityDto.getUoi() != null) {
			this.setUoi(stockTransactionDetailEntityDto.getUoi());
		}

		if (stockTransactionDetailEntityDto.getUomTransaction() != null) {
			this.setUomTransaction(stockTransactionDetailEntityDto.getUomTransaction());
		}

		if (stockTransactionDetailEntityDto.getSourceOrderNumber() != null) {
			this.setSourceOrderNumber(stockTransactionDetailEntityDto.getSourceOrderNumber());
		}

		if (stockTransactionDetailEntityDto.getQtyTransitUoi() != null) {
			this.setQtyTransitUoi(stockTransactionDetailEntityDto.getQtyTransitUoi());
		}

		if (stockTransactionDetailEntityDto.getQtyTransitUomTransaction() != null) {
			this.setQtyTransitUomTransaction(stockTransactionDetailEntityDto.getQtyTransitUomTransaction());
		}

		if (stockTransactionDetailEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(stockTransactionDetailEntityDto.getStockCatalogue());
		}

		if (stockTransactionDetailEntityDto.getTransactionDetailType() != null) {
			this.setTransactionDetailType(stockTransactionDetailEntityDto.getTransactionDetailType());
		}

		if (stockTransactionDetailEntityDto.getWarehouse() != null) {
			this.setWarehouse(stockTransactionDetailEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Modify attribute annotation for Transaction Type here] off begin
	@CsvBindByName(column = "TRANSACTION_TYPE", required = false)
	@Nullable
	@Column(name = "transaction_type")
	@Schema(description = "The Transaction Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Type here] end
	private String transactionType;

	// % protected region % [Modify attribute annotation for Transaction Notes here] off begin
	@CsvBindByName(column = "TRANSACTION_NOTES", required = false)
	@Nullable
	@Column(name = "transaction_notes")
	@Schema(description = "The Transaction Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Notes here] end
	private String transactionNotes;

	// % protected region % [Modify attribute annotation for Item Line Number here] off begin
	@CsvBindByName(column = "ITEM_LINE_NUMBER", required = false)
	@Nullable
	@Column(name = "item_line_number")
	@Schema(description = "The Item Line Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Line Number here] end
	private Integer itemLineNumber;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@CsvBindByName(column = "ITEM_NOTES", required = false)
	@Nullable
	@Column(name = "item_notes")
	@Schema(description = "The Item Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for Qty Uoi here] off begin
	@CsvBindByName(column = "QTY_UOI", required = false)
	@Nullable
	@Column(name = "qty_uoi")
	@Schema(description = "The Qty Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty Uoi here] end
	private Double qtyUoi;

	// % protected region % [Modify attribute annotation for Qty Uom Transaction here] off begin
	@CsvBindByName(column = "QTY_UOM_TRANSACTION", required = false)
	@Nullable
	@Column(name = "qty_uom_transaction")
	@Schema(description = "The Qty Uom Transaction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty Uom Transaction here] end
	private Double qtyUomTransaction;

	// % protected region % [Modify attribute annotation for Total Cost here] off begin
	@CsvBindByName(column = "TOTAL_COST", required = false)
	@Nullable
	@Column(name = "total_cost")
	@Schema(description = "The Total Cost of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Cost here] end
	private Double totalCost;

	// % protected region % [Modify attribute annotation for Uoi here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uoi here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Uom Transaction here] off begin
	@CsvBindByName(column = "UOM_TRANSACTION", required = false)
	@Nullable
	@Column(name = "uom_transaction")
	@Schema(description = "The Uom Transaction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uom Transaction here] end
	private String uomTransaction;

	// % protected region % [Modify attribute annotation for Source Order Number here] off begin
	@CsvBindByName(column = "SOURCE_ORDER_NUMBER", required = false)
	@Nullable
	@Column(name = "source_order_number")
	@Schema(description = "The Source Order Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Source Order Number here] end
	private String sourceOrderNumber;

	// % protected region % [Modify attribute annotation for Qty Transit Uoi here] off begin
	@CsvBindByName(column = "QTY_TRANSIT_UOI", required = false)
	@Nullable
	@Column(name = "qty_transit_uoi")
	@Schema(description = "The Qty Transit Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty Transit Uoi here] end
	private Double qtyTransitUoi;

	// % protected region % [Modify attribute annotation for Qty Transit Uom Transaction here] off begin
	@CsvBindByName(column = "QTY_TRANSIT_UOM_TRANSACTION", required = false)
	@Nullable
	@Column(name = "qty_transit_uom_transaction")
	@Schema(description = "The Qty Transit Uom Transaction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty Transit Uom Transaction here] end
	private Double qtyTransitUomTransaction;

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

	// % protected region % [Update the annotation for Transaction Detail Type here] off begin
	@Schema(description = "The Transaction Detail Type entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Transaction Detail Type here] end
	private TransactionDetailTypeEntity transactionDetailType;

	// % protected region % [Update the annotation for transactionDetailTypeId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TRANSACTION_DETAIL_TYPE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for transactionDetailTypeId here] end
	private UUID transactionDetailTypeId;

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
			this.stockCatalogue.removeStockTransactionDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addStockTransactionDetails(this, false);
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
			this.stockCatalogue.removeStockTransactionDetails(this, false);
		}
		this.stockCatalogue = null;
	}
	/**
	 * Similar to {@link this#setTransactionDetailType(TransactionDetailTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransactionDetailTypeEntity to be set to this entity
	 */
	public void setTransactionDetailType(@NotNull TransactionDetailTypeEntity entity) {
		setTransactionDetailType(entity, true);
	}

	/**
	 * Set or update the transactionDetailType in this entity with single TransactionDetailTypeEntity.
	 *
	 * @param entity the given TransactionDetailTypeEntity to be set or updated to transactionDetailType
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTransactionDetailType(@NotNull TransactionDetailTypeEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTransactionDetailType here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTransactionDetailType here] end

		if (sameAsFormer(this.transactionDetailType, entity)) {
			return;
		}

		if (this.transactionDetailType != null) {
			this.transactionDetailType.removeStockTransactionDetails(this, false);
		}
		this.transactionDetailType = entity;
		if (reverseAdd) {
			this.transactionDetailType.addStockTransactionDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTransactionDetailType incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTransactionDetailType incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTransactionDetailType(boolean)} but default to true.
	 */
	public void unsetTransactionDetailType() {
		this.unsetTransactionDetailType(true);
	}

	/**
	 * Remove Transaction Detail Type in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTransactionDetailType(boolean reverse) {
		if (reverse && this.transactionDetailType != null) {
			this.transactionDetailType.removeStockTransactionDetails(this, false);
		}
		this.transactionDetailType = null;
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
			this.warehouse.removeStockTransactionDetails(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addStockTransactionDetails(this, false);
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
			this.warehouse.removeStockTransactionDetails(this, false);
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
		return "TRANSACTION_NUMBER,TRANSACTION_DATE,TRANSACTION_TYPE,TRANSACTION_NOTES,ITEM_LINE_NUMBER,ITEM_NOTES,QTY_UOI,QTY_UOM_TRANSACTION,TOTAL_COST,UOI,UOM_TRANSACTION,SOURCE_ORDER_NUMBER,QTY_TRANSIT_UOI,QTY_TRANSIT_UOM_TRANSACTION,STOCK_CATALOGUE_ID,TRANSACTION_DETAIL_TYPE_ID,WAREHOUSE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		Optional<TransactionDetailTypeEntity> transactionDetailTypeRelation = Optional.ofNullable(this.transactionDetailType);
		transactionDetailTypeRelation.ifPresent(entity -> this.transactionDetailTypeId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object stockTransactionDetail) {
		if (this == stockTransactionDetail) {
			return true;
		}
		if (stockTransactionDetail == null || this.getClass() != stockTransactionDetail.getClass()) {
			return false;
		}
		if (!super.equals(stockTransactionDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		StockTransactionDetailEntity that = (StockTransactionDetailEntity) stockTransactionDetail;
		return
			Objects.equals(this.transactionNumber, that.transactionNumber) &&
			Objects.equals(
			     this.transactionDate != null ? this.transactionDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.transactionDate != null ? that.transactionDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.transactionType, that.transactionType) &&
			Objects.equals(this.transactionNotes, that.transactionNotes) &&
			Objects.equals(this.itemLineNumber, that.itemLineNumber) &&
			Objects.equals(this.itemNotes, that.itemNotes) &&
			Objects.equals(this.qtyUoi, that.qtyUoi) &&
			Objects.equals(this.qtyUomTransaction, that.qtyUomTransaction) &&
			Objects.equals(this.totalCost, that.totalCost) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.uomTransaction, that.uomTransaction) &&
			Objects.equals(this.sourceOrderNumber, that.sourceOrderNumber) &&
			Objects.equals(this.qtyTransitUoi, that.qtyTransitUoi) &&
			Objects.equals(this.qtyTransitUomTransaction, that.qtyTransitUomTransaction) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId) &&
			Objects.equals(this.transactionDetailTypeId, that.transactionDetailTypeId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
