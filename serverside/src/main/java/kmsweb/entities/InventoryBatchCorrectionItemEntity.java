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
import kmsweb.dtos.InventoryBatchCorrectionItemEntityDto;
import kmsweb.entities.listeners.InventoryBatchCorrectionItemEntityListener;
import kmsweb.serializers.InventoryBatchCorrectionItemSerializer;
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
@EntityListeners({InventoryBatchCorrectionItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InventoryBatchCorrectionItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InventoryBatchCorrectionItemEntity extends AbstractEntity {

	/**
	 * Takes a InventoryBatchCorrectionItemEntityDto and converts it into a InventoryBatchCorrectionItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param inventoryBatchCorrectionItemEntityDto
	 */
	public InventoryBatchCorrectionItemEntity(InventoryBatchCorrectionItemEntityDto inventoryBatchCorrectionItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (inventoryBatchCorrectionItemEntityDto.getId() != null) {
			this.setId(inventoryBatchCorrectionItemEntityDto.getId());
		}

		if (inventoryBatchCorrectionItemEntityDto.getItemLineNumber() != null) {
			this.setItemLineNumber(inventoryBatchCorrectionItemEntityDto.getItemLineNumber());
		}

		if (inventoryBatchCorrectionItemEntityDto.getBatchNumber() != null) {
			this.setBatchNumber(inventoryBatchCorrectionItemEntityDto.getBatchNumber());
		}

		if (inventoryBatchCorrectionItemEntityDto.getExpirationDate() != null) {
			this.setExpirationDate(inventoryBatchCorrectionItemEntityDto.getExpirationDate());
		}

		if (inventoryBatchCorrectionItemEntityDto.getUom() != null) {
			this.setUom(inventoryBatchCorrectionItemEntityDto.getUom());
		}

		if (inventoryBatchCorrectionItemEntityDto.getAvailableQtyBatch() != null) {
			this.setAvailableQtyBatch(inventoryBatchCorrectionItemEntityDto.getAvailableQtyBatch());
		}

		if (inventoryBatchCorrectionItemEntityDto.getActualQtyBatch() != null) {
			this.setActualQtyBatch(inventoryBatchCorrectionItemEntityDto.getActualQtyBatch());
		}

		if (inventoryBatchCorrectionItemEntityDto.getQtyAdjusted() != null) {
			this.setQtyAdjusted(inventoryBatchCorrectionItemEntityDto.getQtyAdjusted());
		}

		if (inventoryBatchCorrectionItemEntityDto.getItemNotes() != null) {
			this.setItemNotes(inventoryBatchCorrectionItemEntityDto.getItemNotes());
		}

		if (inventoryBatchCorrectionItemEntityDto.getUoi() != null) {
			this.setUoi(inventoryBatchCorrectionItemEntityDto.getUoi());
		}

		if (inventoryBatchCorrectionItemEntityDto.getQtyUOI() != null) {
			this.setQtyUOI(inventoryBatchCorrectionItemEntityDto.getQtyUOI());
		}

		if (inventoryBatchCorrectionItemEntityDto.getInventoryBatchCorrection() != null) {
			this.setInventoryBatchCorrection(inventoryBatchCorrectionItemEntityDto.getInventoryBatchCorrection());
		}

		if (inventoryBatchCorrectionItemEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(inventoryBatchCorrectionItemEntityDto.getStockCatalogue());
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

	// % protected region % [Modify attribute annotation for UOM here] off begin
	@CsvBindByName(column = "UOM", required = false)
	@Nullable
	@Column(name = "uom")
	@Schema(description = "The UOM of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOM here] end
	private String uom;

	// % protected region % [Modify attribute annotation for Available Qty Batch here] off begin
	@CsvBindByName(column = "AVAILABLE_QTY_BATCH", required = false)
	@Nullable
	@Column(name = "available_qty_batch")
	@Schema(description = "The Available Qty Batch of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Available Qty Batch here] end
	private Double availableQtyBatch;

	// % protected region % [Modify attribute annotation for Actual Qty Batch here] off begin
	@CsvBindByName(column = "ACTUAL_QTY_BATCH", required = false)
	@Nullable
	@Column(name = "actual_qty_batch")
	@Schema(description = "The Actual Qty Batch of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Actual Qty Batch here] end
	private Double actualQtyBatch;

	// % protected region % [Modify attribute annotation for Qty Adjusted here] off begin
	@CsvBindByName(column = "QTY_ADJUSTED", required = false)
	@Nullable
	@Column(name = "qty_adjusted")
	@Schema(description = "The Qty Adjusted of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty Adjusted here] end
	private Double qtyAdjusted;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@CsvBindByName(column = "ITEM_NOTES", required = false)
	@Nullable
	@Column(name = "item_notes")
	@Schema(description = "The Item Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Qty UOI here] off begin
	@CsvBindByName(column = "QTY_UOI", required = false)
	@Nullable
	@Column(name = "qty_uoi")
	@Schema(description = "The Qty UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty UOI here] end
	private Double qtyUOI;

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

	// % protected region % [Update the annotation for Inventory Batch Correction here] off begin
	@Schema(description = "The Inventory Batch Correction entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Batch Correction here] end
	private InventoryBatchCorrectionEntity inventoryBatchCorrection;

	// % protected region % [Update the annotation for inventoryBatchCorrectionId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_BATCH_CORRECTION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for inventoryBatchCorrectionId here] end
	private UUID inventoryBatchCorrectionId;

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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setInventoryBatchCorrection(InventoryBatchCorrectionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionEntity to be set to this entity
	 */
	public void setInventoryBatchCorrection(@NotNull InventoryBatchCorrectionEntity entity) {
		setInventoryBatchCorrection(entity, true);
	}

	/**
	 * Set or update the inventoryBatchCorrection in this entity with single InventoryBatchCorrectionEntity.
	 *
	 * @param entity the given InventoryBatchCorrectionEntity to be set or updated to inventoryBatchCorrection
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInventoryBatchCorrection(@NotNull InventoryBatchCorrectionEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInventoryBatchCorrection here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInventoryBatchCorrection here] end

		if (sameAsFormer(this.inventoryBatchCorrection, entity)) {
			return;
		}

		if (this.inventoryBatchCorrection != null) {
			this.inventoryBatchCorrection.removeInventoryBatchCorrectionItems(this, false);
		}
		this.inventoryBatchCorrection = entity;
		if (reverseAdd) {
			this.inventoryBatchCorrection.addInventoryBatchCorrectionItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInventoryBatchCorrection incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInventoryBatchCorrection incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInventoryBatchCorrection(boolean)} but default to true.
	 */
	public void unsetInventoryBatchCorrection() {
		this.unsetInventoryBatchCorrection(true);
	}

	/**
	 * Remove Inventory Batch Correction in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInventoryBatchCorrection(boolean reverse) {
		if (reverse && this.inventoryBatchCorrection != null) {
			this.inventoryBatchCorrection.removeInventoryBatchCorrectionItems(this, false);
		}
		this.inventoryBatchCorrection = null;
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
			this.stockCatalogue.removeInventoryBatchCorrectionItems(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addInventoryBatchCorrectionItems(this, false);
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
			this.stockCatalogue.removeInventoryBatchCorrectionItems(this, false);
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
		return "ITEM_LINE_NUMBER,BATCH_NUMBER,EXPIRATION_DATE,UOM,AVAILABLE_QTY_BATCH,ACTUAL_QTY_BATCH,QTY_ADJUSTED,ITEM_NOTES,UOI,QTY_UOI,INVENTORY_BATCH_CORRECTION_ID,STOCK_CATALOGUE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<InventoryBatchCorrectionEntity> inventoryBatchCorrectionRelation = Optional.ofNullable(this.inventoryBatchCorrection);
		inventoryBatchCorrectionRelation.ifPresent(entity -> this.inventoryBatchCorrectionId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object inventoryBatchCorrectionItem) {
		if (this == inventoryBatchCorrectionItem) {
			return true;
		}
		if (inventoryBatchCorrectionItem == null || this.getClass() != inventoryBatchCorrectionItem.getClass()) {
			return false;
		}
		if (!super.equals(inventoryBatchCorrectionItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InventoryBatchCorrectionItemEntity that = (InventoryBatchCorrectionItemEntity) inventoryBatchCorrectionItem;
		return
			Objects.equals(this.itemLineNumber, that.itemLineNumber) &&
			Objects.equals(this.batchNumber, that.batchNumber) &&
			Objects.equals(
			     this.expirationDate != null ? this.expirationDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.expirationDate != null ? that.expirationDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.uom, that.uom) &&
			Objects.equals(this.availableQtyBatch, that.availableQtyBatch) &&
			Objects.equals(this.actualQtyBatch, that.actualQtyBatch) &&
			Objects.equals(this.qtyAdjusted, that.qtyAdjusted) &&
			Objects.equals(this.itemNotes, that.itemNotes) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.qtyUOI, that.qtyUOI) &&
			Objects.equals(this.inventoryBatchCorrectionId, that.inventoryBatchCorrectionId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
