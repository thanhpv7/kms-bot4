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
import kmsweb.dtos.InventoryAdjustmentItemEntityDto;
import kmsweb.entities.listeners.InventoryAdjustmentItemEntityListener;
import kmsweb.serializers.InventoryAdjustmentItemSerializer;
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
@EntityListeners({InventoryAdjustmentItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InventoryAdjustmentItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InventoryAdjustmentItemEntity extends AbstractEntity {

	/**
	 * Takes a InventoryAdjustmentItemEntityDto and converts it into a InventoryAdjustmentItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param inventoryAdjustmentItemEntityDto
	 */
	public InventoryAdjustmentItemEntity(InventoryAdjustmentItemEntityDto inventoryAdjustmentItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (inventoryAdjustmentItemEntityDto.getId() != null) {
			this.setId(inventoryAdjustmentItemEntityDto.getId());
		}

		if (inventoryAdjustmentItemEntityDto.getItemLineNumber() != null) {
			this.setItemLineNumber(inventoryAdjustmentItemEntityDto.getItemLineNumber());
		}

		if (inventoryAdjustmentItemEntityDto.getOriginalSOH() != null) {
			this.setOriginalSOH(inventoryAdjustmentItemEntityDto.getOriginalSOH());
		}

		if (inventoryAdjustmentItemEntityDto.getOriginalInventoryValue() != null) {
			this.setOriginalInventoryValue(inventoryAdjustmentItemEntityDto.getOriginalInventoryValue());
		}

		if (inventoryAdjustmentItemEntityDto.getQty() != null) {
			this.setQty(inventoryAdjustmentItemEntityDto.getQty());
		}

		if (inventoryAdjustmentItemEntityDto.getUom() != null) {
			this.setUom(inventoryAdjustmentItemEntityDto.getUom());
		}

		if (inventoryAdjustmentItemEntityDto.getPrice() != null) {
			this.setPrice(inventoryAdjustmentItemEntityDto.getPrice());
		}

		if (inventoryAdjustmentItemEntityDto.getTotalCost() != null) {
			this.setTotalCost(inventoryAdjustmentItemEntityDto.getTotalCost());
		}

		if (inventoryAdjustmentItemEntityDto.getAdjustedSoh() != null) {
			this.setAdjustedSoh(inventoryAdjustmentItemEntityDto.getAdjustedSoh());
		}

		if (inventoryAdjustmentItemEntityDto.getAdjustedInventoryValue() != null) {
			this.setAdjustedInventoryValue(inventoryAdjustmentItemEntityDto.getAdjustedInventoryValue());
		}

		if (inventoryAdjustmentItemEntityDto.getMinimalLevel() != null) {
			this.setMinimalLevel(inventoryAdjustmentItemEntityDto.getMinimalLevel());
		}

		if (inventoryAdjustmentItemEntityDto.getMaximalLevel() != null) {
			this.setMaximalLevel(inventoryAdjustmentItemEntityDto.getMaximalLevel());
		}

		if (inventoryAdjustmentItemEntityDto.getItemNotes() != null) {
			this.setItemNotes(inventoryAdjustmentItemEntityDto.getItemNotes());
		}

		if (inventoryAdjustmentItemEntityDto.getUoi() != null) {
			this.setUoi(inventoryAdjustmentItemEntityDto.getUoi());
		}

		if (inventoryAdjustmentItemEntityDto.getQtyUoi() != null) {
			this.setQtyUoi(inventoryAdjustmentItemEntityDto.getQtyUoi());
		}

		if (inventoryAdjustmentItemEntityDto.getPriceUoi() != null) {
			this.setPriceUoi(inventoryAdjustmentItemEntityDto.getPriceUoi());
		}

		if (inventoryAdjustmentItemEntityDto.getInventoryRoundingValue() != null) {
			this.setInventoryRoundingValue(inventoryAdjustmentItemEntityDto.getInventoryRoundingValue());
		}

		if (inventoryAdjustmentItemEntityDto.getInventoryAdjusmentBatchs() != null) {
			this.setInventoryAdjusmentBatchs(inventoryAdjustmentItemEntityDto.getInventoryAdjusmentBatchs());
		}

		if (inventoryAdjustmentItemEntityDto.getInventoryAdjustment() != null) {
			this.setInventoryAdjustment(inventoryAdjustmentItemEntityDto.getInventoryAdjustment());
		}

		if (inventoryAdjustmentItemEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(inventoryAdjustmentItemEntityDto.getStockCatalogue());
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

	// % protected region % [Modify attribute annotation for Original SOH here] off begin
	@CsvBindByName(column = "ORIGINAL_SOH", required = false)
	@Nullable
	@Column(name = "original_soh")
	@Schema(description = "The Original SOH of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Original SOH here] end
	private Double originalSOH;

	// % protected region % [Modify attribute annotation for Original Inventory Value here] off begin
	@CsvBindByName(column = "ORIGINAL_INVENTORY_VALUE", required = false)
	@Nullable
	@Column(name = "original_inventory_value")
	@Schema(description = "The Original Inventory Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Original Inventory Value here] end
	private Double originalInventoryValue;

	// % protected region % [Modify attribute annotation for Qty here] off begin
	@CsvBindByName(column = "QTY", required = false)
	@Nullable
	@Column(name = "qty")
	@Schema(description = "The Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty here] end
	private Double qty;

	// % protected region % [Modify attribute annotation for Uom here] off begin
	@CsvBindByName(column = "UOM", required = false)
	@Nullable
	@Column(name = "uom")
	@Schema(description = "The Uom of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uom here] end
	private String uom;

	// % protected region % [Modify attribute annotation for Price here] off begin
	@CsvBindByName(column = "PRICE", required = false)
	@Nullable
	@Column(name = "price")
	@Schema(description = "The Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Total Cost here] off begin
	@CsvBindByName(column = "TOTAL_COST", required = false)
	@Nullable
	@Column(name = "total_cost")
	@Schema(description = "The Total Cost of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Cost here] end
	private Double totalCost;

	// % protected region % [Modify attribute annotation for Adjusted Soh here] off begin
	@CsvBindByName(column = "ADJUSTED_SOH", required = false)
	@Nullable
	@Column(name = "adjusted_soh")
	@Schema(description = "The Adjusted Soh of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Adjusted Soh here] end
	private Double adjustedSoh;

	// % protected region % [Modify attribute annotation for Adjusted Inventory Value here] off begin
	@CsvBindByName(column = "ADJUSTED_INVENTORY_VALUE", required = false)
	@Nullable
	@Column(name = "adjusted_inventory_value")
	@Schema(description = "The Adjusted Inventory Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Adjusted Inventory Value here] end
	private Double adjustedInventoryValue;

	// % protected region % [Modify attribute annotation for Minimal Level here] off begin
	@CsvBindByName(column = "MINIMAL_LEVEL", required = false)
	@Nullable
	@Column(name = "minimal_level")
	@Schema(description = "The Minimal Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Minimal Level here] end
	private Double minimalLevel;

	// % protected region % [Modify attribute annotation for Maximal Level here] off begin
	@CsvBindByName(column = "MAXIMAL_LEVEL", required = false)
	@Nullable
	@Column(name = "maximal_level")
	@Schema(description = "The Maximal Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Maximal Level here] end
	private Double maximalLevel;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@CsvBindByName(column = "ITEM_NOTES", required = false)
	@Nullable
	@Column(name = "item_notes")
	@Schema(description = "The Item Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

	// % protected region % [Modify attribute annotation for Uoi here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uoi here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Qty Uoi here] off begin
	@CsvBindByName(column = "QTY_UOI", required = false)
	@Nullable
	@Column(name = "qty_uoi")
	@Schema(description = "The Qty Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty Uoi here] end
	private Double qtyUoi;

	// % protected region % [Modify attribute annotation for Price Uoi here] off begin
	@CsvBindByName(column = "PRICE_UOI", required = false)
	@Nullable
	@Column(name = "price_uoi")
	@Schema(description = "The Price Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price Uoi here] end
	private Double priceUoi;

	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] off begin
	@CsvBindByName(column = "INVENTORY_ROUNDING_VALUE", required = false)
	@Nullable
	@Column(name = "inventory_rounding_value")
	@Schema(description = "The Inventory Rounding Value of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inventory Rounding Value here] end
	private Double inventoryRoundingValue;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Inventory Adjusment Batchs here] off begin
	@Schema(description = "The Inventory Adjusment Batch entities that are related to this entity.")
	@OneToMany(mappedBy = "inventoryAdjustmentItem", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Adjusment Batchs here] end
	private Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();

	// % protected region % [Update the annotation for inventoryAdjusmentBatchsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_ADJUSMENT_BATCHS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for inventoryAdjusmentBatchsIds here] end
	private Set<UUID> inventoryAdjusmentBatchsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Inventory Adjustment here] off begin
	@Schema(description = "The Inventory Adjustment entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Adjustment here] end
	private InventoryAdjustmentEntity inventoryAdjustment;

	// % protected region % [Update the annotation for inventoryAdjustmentId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_ADJUSTMENT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for inventoryAdjustmentId here] end
	private UUID inventoryAdjustmentId;

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
	 * Similar to {@link this#addInventoryAdjusmentBatchs(InventoryAdjusmentBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be added to this entity
	 */
	public void addInventoryAdjusmentBatchs(@NotNull InventoryAdjusmentBatchEntity entity) {
		addInventoryAdjusmentBatchs(entity, true);
	}

	/**
	 * Add a new InventoryAdjusmentBatchEntity to inventoryAdjusmentBatchs in this entity.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjusmentBatchs(@NonNull InventoryAdjusmentBatchEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjusmentBatchs.contains(entity)) {
			inventoryAdjusmentBatchs.add(entity);
			if (reverseAdd) {
				entity.setInventoryAdjustmentItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be added to this entity
	 */
	public void addInventoryAdjusmentBatchs(@NotNull Collection<InventoryAdjusmentBatchEntity> entities) {
		addInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjusmentBatchEntity to Inventory Adjusment Batchs in this entity.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjusmentBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjusmentBatchs(InventoryAdjusmentBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be set to this entity
	 */
	public void removeInventoryAdjusmentBatchs(@NotNull InventoryAdjusmentBatchEntity entity) {
		this.removeInventoryAdjusmentBatchs(entity, true);
	}

	/**
	 * Remove the given InventoryAdjusmentBatchEntity from this entity.
	 *
	 * @param entity the given InventoryAdjusmentBatchEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjusmentBatchs(@NotNull InventoryAdjusmentBatchEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInventoryAdjustmentItem(false);
		}
		this.inventoryAdjusmentBatchs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be removed to this entity
	 */
	public void removeInventoryAdjusmentBatchs(@NotNull Collection<InventoryAdjusmentBatchEntity> entities) {
		this.removeInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjusmentBatchEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjusmentBatchs(@NonNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjusmentBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjusmentBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to be set to this entity
	 */
	public void setInventoryAdjusmentBatchs(@NotNull Collection<InventoryAdjusmentBatchEntity> entities) {
		setInventoryAdjusmentBatchs(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjusment Batchs with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjusmentBatchEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjusmentBatchs(@NotNull Collection<InventoryAdjusmentBatchEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjusmentBatchs();
		this.inventoryAdjusmentBatchs = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.setInventoryAdjustmentItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjusmentBatchs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjusmentBatchs() {
		this.unsetInventoryAdjusmentBatchs(true);
	}

	/**
	 * Remove all the entities in Inventory Adjusment Batchs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjusmentBatchs(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.unsetInventoryAdjustmentItem(false));
		}
		this.inventoryAdjusmentBatchs.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setInventoryAdjustment(InventoryAdjustmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be set to this entity
	 */
	public void setInventoryAdjustment(@NotNull InventoryAdjustmentEntity entity) {
		setInventoryAdjustment(entity, true);
	}

	/**
	 * Set or update the inventoryAdjustment in this entity with single InventoryAdjustmentEntity.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be set or updated to inventoryAdjustment
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInventoryAdjustment(@NotNull InventoryAdjustmentEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInventoryAdjustment here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInventoryAdjustment here] end

		if (sameAsFormer(this.inventoryAdjustment, entity)) {
			return;
		}

		if (this.inventoryAdjustment != null) {
			this.inventoryAdjustment.removeInventoryAdjustmentItems(this, false);
		}
		this.inventoryAdjustment = entity;
		if (reverseAdd) {
			this.inventoryAdjustment.addInventoryAdjustmentItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInventoryAdjustment incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInventoryAdjustment incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustment(boolean)} but default to true.
	 */
	public void unsetInventoryAdjustment() {
		this.unsetInventoryAdjustment(true);
	}

	/**
	 * Remove Inventory Adjustment in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInventoryAdjustment(boolean reverse) {
		if (reverse && this.inventoryAdjustment != null) {
			this.inventoryAdjustment.removeInventoryAdjustmentItems(this, false);
		}
		this.inventoryAdjustment = null;
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
			this.stockCatalogue.removeInventoryAdjustmentItems(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addInventoryAdjustmentItems(this, false);
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
			this.stockCatalogue.removeInventoryAdjustmentItems(this, false);
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
		return "ITEM_LINE_NUMBER,ORIGINAL_SOH,ORIGINAL_INVENTORY_VALUE,QTY,UOM,PRICE,TOTAL_COST,ADJUSTED_SOH,ADJUSTED_INVENTORY_VALUE,MINIMAL_LEVEL,MAXIMAL_LEVEL,ITEM_NOTES,UOI,QTY_UOI,PRICE_UOI,INVENTORY_ROUNDING_VALUE,INVENTORY_ADJUSTMENT_ID,STOCK_CATALOGUE_ID,INVENTORY_ADJUSMENT_BATCHS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<InventoryAdjustmentEntity> inventoryAdjustmentRelation = Optional.ofNullable(this.inventoryAdjustment);
		inventoryAdjustmentRelation.ifPresent(entity -> this.inventoryAdjustmentId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		this.inventoryAdjusmentBatchsIds = new HashSet<>();
		for (InventoryAdjusmentBatchEntity inventoryAdjusmentBatchs: this.inventoryAdjusmentBatchs) {
			this.inventoryAdjusmentBatchsIds.add(inventoryAdjusmentBatchs.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object inventoryAdjustmentItem) {
		if (this == inventoryAdjustmentItem) {
			return true;
		}
		if (inventoryAdjustmentItem == null || this.getClass() != inventoryAdjustmentItem.getClass()) {
			return false;
		}
		if (!super.equals(inventoryAdjustmentItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InventoryAdjustmentItemEntity that = (InventoryAdjustmentItemEntity) inventoryAdjustmentItem;
		return
			Objects.equals(this.itemLineNumber, that.itemLineNumber) &&
			Objects.equals(this.originalSOH, that.originalSOH) &&
			Objects.equals(this.originalInventoryValue, that.originalInventoryValue) &&
			Objects.equals(this.qty, that.qty) &&
			Objects.equals(this.uom, that.uom) &&
			Objects.equals(this.price, that.price) &&
			Objects.equals(this.totalCost, that.totalCost) &&
			Objects.equals(this.adjustedSoh, that.adjustedSoh) &&
			Objects.equals(this.adjustedInventoryValue, that.adjustedInventoryValue) &&
			Objects.equals(this.minimalLevel, that.minimalLevel) &&
			Objects.equals(this.maximalLevel, that.maximalLevel) &&
			Objects.equals(this.itemNotes, that.itemNotes) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.qtyUoi, that.qtyUoi) &&
			Objects.equals(this.priceUoi, that.priceUoi) &&
			Objects.equals(this.inventoryRoundingValue, that.inventoryRoundingValue) &&
			Objects.equals(this.inventoryAdjusmentBatchsIds, that.inventoryAdjusmentBatchsIds) &&
			Objects.equals(this.inventoryAdjustmentId, that.inventoryAdjustmentId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
