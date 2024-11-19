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
import kmsweb.dtos.InternalOrderStockDetailEntityDto;
import kmsweb.entities.listeners.InternalOrderStockDetailEntityListener;
import kmsweb.serializers.InternalOrderStockDetailSerializer;
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
@EntityListeners({InternalOrderStockDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = InternalOrderStockDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class InternalOrderStockDetailEntity extends AbstractEntity {

	/**
	 * Takes a InternalOrderStockDetailEntityDto and converts it into a InternalOrderStockDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param internalOrderStockDetailEntityDto
	 */
	public InternalOrderStockDetailEntity(InternalOrderStockDetailEntityDto internalOrderStockDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (internalOrderStockDetailEntityDto.getId() != null) {
			this.setId(internalOrderStockDetailEntityDto.getId());
		}

		if (internalOrderStockDetailEntityDto.getItemNumber() != null) {
			this.setItemNumber(internalOrderStockDetailEntityDto.getItemNumber());
		}

		if (internalOrderStockDetailEntityDto.getSourceAvailableQuantity() != null) {
			this.setSourceAvailableQuantity(internalOrderStockDetailEntityDto.getSourceAvailableQuantity());
		}

		if (internalOrderStockDetailEntityDto.getQuantityOrdered() != null) {
			this.setQuantityOrdered(internalOrderStockDetailEntityDto.getQuantityOrdered());
		}

		if (internalOrderStockDetailEntityDto.getUom() != null) {
			this.setUom(internalOrderStockDetailEntityDto.getUom());
		}

		if (internalOrderStockDetailEntityDto.getTransactionStatus() != null) {
			this.setTransactionStatus(internalOrderStockDetailEntityDto.getTransactionStatus());
		}

		if (internalOrderStockDetailEntityDto.getQuantityIssued() != null) {
			this.setQuantityIssued(internalOrderStockDetailEntityDto.getQuantityIssued());
		}

		if (internalOrderStockDetailEntityDto.getQuantityReceived() != null) {
			this.setQuantityReceived(internalOrderStockDetailEntityDto.getQuantityReceived());
		}

		if (internalOrderStockDetailEntityDto.getSourceMinLevel() != null) {
			this.setSourceMinLevel(internalOrderStockDetailEntityDto.getSourceMinLevel());
		}

		if (internalOrderStockDetailEntityDto.getQuantityFulfilled() != null) {
			this.setQuantityFulfilled(internalOrderStockDetailEntityDto.getQuantityFulfilled());
		}

		if (internalOrderStockDetailEntityDto.getItemNotes() != null) {
			this.setItemNotes(internalOrderStockDetailEntityDto.getItemNotes());
		}

		if (internalOrderStockDetailEntityDto.getInventoryRoundingValue() != null) {
			this.setInventoryRoundingValue(internalOrderStockDetailEntityDto.getInventoryRoundingValue());
		}

		if (internalOrderStockDetailEntityDto.getInternalOrder() != null) {
			this.setInternalOrder(internalOrderStockDetailEntityDto.getInternalOrder());
		}

		if (internalOrderStockDetailEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(internalOrderStockDetailEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Item Number here] off begin
	@CsvBindByName(column = "ITEM_NUMBER", required = false)
	@Nullable
	@Column(name = "item_number")
	@Schema(description = "The Item Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Number here] end
	private Integer itemNumber;

	// % protected region % [Modify attribute annotation for Source Available Quantity here] off begin
	@CsvBindByName(column = "SOURCE_AVAILABLE_QUANTITY", required = false)
	@Nullable
	@Column(name = "source_available_quantity")
	@Schema(description = "The Source Available Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Source Available Quantity here] end
	private Double sourceAvailableQuantity;

	// % protected region % [Modify attribute annotation for Quantity Ordered here] off begin
	@CsvBindByName(column = "QUANTITY_ORDERED", required = false)
	@Nullable
	@Column(name = "quantity_ordered")
	@Schema(description = "The Quantity Ordered of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Ordered here] end
	private Double quantityOrdered;

	// % protected region % [Modify attribute annotation for uom here] off begin
	@CsvBindByName(column = "UOM", required = false)
	@Nullable
	@Column(name = "uom")
	@Schema(description = "The uom of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for uom here] end
	private String uom;

	// % protected region % [Modify attribute annotation for Transaction Status here] off begin
	@CsvBindByName(column = "TRANSACTION_STATUS", required = false)
	@Nullable
	@Column(name = "transaction_status")
	@Schema(description = "The Transaction Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Status here] end
	private String transactionStatus;

	// % protected region % [Modify attribute annotation for Quantity Issued here] off begin
	@CsvBindByName(column = "QUANTITY_ISSUED", required = false)
	@Nullable
	@Column(name = "quantity_issued")
	@Schema(description = "The Quantity Issued of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Issued here] end
	private Double quantityIssued;

	// % protected region % [Modify attribute annotation for Quantity Received here] off begin
	@CsvBindByName(column = "QUANTITY_RECEIVED", required = false)
	@Nullable
	@Column(name = "quantity_received")
	@Schema(description = "The Quantity Received of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Received here] end
	private Double quantityReceived;

	// % protected region % [Modify attribute annotation for Source Min Level here] off begin
	@CsvBindByName(column = "SOURCE_MIN_LEVEL", required = false)
	@Nullable
	@Column(name = "source_min_level")
	@Schema(description = "The Source Min Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Source Min Level here] end
	private Double sourceMinLevel;

	// % protected region % [Modify attribute annotation for Quantity Fulfilled here] off begin
	@CsvBindByName(column = "QUANTITY_FULFILLED", required = false)
	@Nullable
	@Column(name = "quantity_fulfilled")
	@Schema(description = "The Quantity Fulfilled of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Fulfilled here] end
	private Double quantityFulfilled;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@CsvBindByName(column = "ITEM_NOTES", required = false)
	@Nullable
	@Column(name = "item_notes")
	@Schema(description = "The Item Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Internal Order here] off begin
	@Schema(description = "The Internal Order entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Internal Order here] end
	private InternalOrderEntity internalOrder;

	// % protected region % [Update the annotation for internalOrderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "INTERNAL_ORDER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for internalOrderId here] end
	private UUID internalOrderId;

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
	 * Similar to {@link this#setInternalOrder(InternalOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderEntity to be set to this entity
	 */
	public void setInternalOrder(@NotNull InternalOrderEntity entity) {
		setInternalOrder(entity, true);
	}

	/**
	 * Set or update the internalOrder in this entity with single InternalOrderEntity.
	 *
	 * @param entity the given InternalOrderEntity to be set or updated to internalOrder
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInternalOrder(@NotNull InternalOrderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInternalOrder here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInternalOrder here] end

		if (sameAsFormer(this.internalOrder, entity)) {
			return;
		}

		if (this.internalOrder != null) {
			this.internalOrder.removeInternalOrderStockDetails(this, false);
		}
		this.internalOrder = entity;
		if (reverseAdd) {
			this.internalOrder.addInternalOrderStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInternalOrder incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInternalOrder incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInternalOrder(boolean)} but default to true.
	 */
	public void unsetInternalOrder() {
		this.unsetInternalOrder(true);
	}

	/**
	 * Remove Internal Order in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInternalOrder(boolean reverse) {
		if (reverse && this.internalOrder != null) {
			this.internalOrder.removeInternalOrderStockDetails(this, false);
		}
		this.internalOrder = null;
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
			this.stockCatalogue.removeInternalOrderStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addInternalOrderStockDetails(this, false);
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
			this.stockCatalogue.removeInternalOrderStockDetails(this, false);
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
		return "ITEM_NUMBER,SOURCE_AVAILABLE_QUANTITY,QUANTITY_ORDERED,UOM,TRANSACTION_STATUS,QUANTITY_ISSUED,QUANTITY_RECEIVED,SOURCE_MIN_LEVEL,QUANTITY_FULFILLED,ITEM_NOTES,INVENTORY_ROUNDING_VALUE,INTERNAL_ORDER_ID,STOCK_CATALOGUE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<InternalOrderEntity> internalOrderRelation = Optional.ofNullable(this.internalOrder);
		internalOrderRelation.ifPresent(entity -> this.internalOrderId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object internalOrderStockDetail) {
		if (this == internalOrderStockDetail) {
			return true;
		}
		if (internalOrderStockDetail == null || this.getClass() != internalOrderStockDetail.getClass()) {
			return false;
		}
		if (!super.equals(internalOrderStockDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		InternalOrderStockDetailEntity that = (InternalOrderStockDetailEntity) internalOrderStockDetail;
		return
			Objects.equals(this.itemNumber, that.itemNumber) &&
			Objects.equals(this.sourceAvailableQuantity, that.sourceAvailableQuantity) &&
			Objects.equals(this.quantityOrdered, that.quantityOrdered) &&
			Objects.equals(this.uom, that.uom) &&
			Objects.equals(this.transactionStatus, that.transactionStatus) &&
			Objects.equals(this.quantityIssued, that.quantityIssued) &&
			Objects.equals(this.quantityReceived, that.quantityReceived) &&
			Objects.equals(this.sourceMinLevel, that.sourceMinLevel) &&
			Objects.equals(this.quantityFulfilled, that.quantityFulfilled) &&
			Objects.equals(this.itemNotes, that.itemNotes) &&
			Objects.equals(this.inventoryRoundingValue, that.inventoryRoundingValue) &&
			Objects.equals(this.internalOrderId, that.internalOrderId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
