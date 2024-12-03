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
import kmsweb.dtos.TransferOrderStockDetailEntityDto;
import kmsweb.entities.listeners.TransferOrderStockDetailEntityListener;
import kmsweb.serializers.TransferOrderStockDetailSerializer;
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
@EntityListeners({TransferOrderStockDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TransferOrderStockDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TransferOrderStockDetailEntity extends AbstractEntity {

	/**
	 * Takes a TransferOrderStockDetailEntityDto and converts it into a TransferOrderStockDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param transferOrderStockDetailEntityDto
	 */
	public TransferOrderStockDetailEntity(TransferOrderStockDetailEntityDto transferOrderStockDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (transferOrderStockDetailEntityDto.getId() != null) {
			this.setId(transferOrderStockDetailEntityDto.getId());
		}

		if (transferOrderStockDetailEntityDto.getItemNumber() != null) {
			this.setItemNumber(transferOrderStockDetailEntityDto.getItemNumber());
		}

		if (transferOrderStockDetailEntityDto.getSourceAvailableQuantity() != null) {
			this.setSourceAvailableQuantity(transferOrderStockDetailEntityDto.getSourceAvailableQuantity());
		}

		if (transferOrderStockDetailEntityDto.getDestinationSOH() != null) {
			this.setDestinationSOH(transferOrderStockDetailEntityDto.getDestinationSOH());
		}

		if (transferOrderStockDetailEntityDto.getQuantityOrdered() != null) {
			this.setQuantityOrdered(transferOrderStockDetailEntityDto.getQuantityOrdered());
		}

		if (transferOrderStockDetailEntityDto.getUom() != null) {
			this.setUom(transferOrderStockDetailEntityDto.getUom());
		}

		if (transferOrderStockDetailEntityDto.getTransactionStatus() != null) {
			this.setTransactionStatus(transferOrderStockDetailEntityDto.getTransactionStatus());
		}

		if (transferOrderStockDetailEntityDto.getQuantityIssued() != null) {
			this.setQuantityIssued(transferOrderStockDetailEntityDto.getQuantityIssued());
		}

		if (transferOrderStockDetailEntityDto.getQuantityReceived() != null) {
			this.setQuantityReceived(transferOrderStockDetailEntityDto.getQuantityReceived());
		}

		if (transferOrderStockDetailEntityDto.getSourceMinLevel() != null) {
			this.setSourceMinLevel(transferOrderStockDetailEntityDto.getSourceMinLevel());
		}

		if (transferOrderStockDetailEntityDto.getDestinationMaxLevel() != null) {
			this.setDestinationMaxLevel(transferOrderStockDetailEntityDto.getDestinationMaxLevel());
		}

		if (transferOrderStockDetailEntityDto.getQuantityTransferred() != null) {
			this.setQuantityTransferred(transferOrderStockDetailEntityDto.getQuantityTransferred());
		}

		if (transferOrderStockDetailEntityDto.getQuantityFulfilled() != null) {
			this.setQuantityFulfilled(transferOrderStockDetailEntityDto.getQuantityFulfilled());
		}

		if (transferOrderStockDetailEntityDto.getOrderDateTime() != null) {
			this.setOrderDateTime(transferOrderStockDetailEntityDto.getOrderDateTime());
		}

		if (transferOrderStockDetailEntityDto.getItemNotes() != null) {
			this.setItemNotes(transferOrderStockDetailEntityDto.getItemNotes());
		}

		if (transferOrderStockDetailEntityDto.getInventoryRoundingValue() != null) {
			this.setInventoryRoundingValue(transferOrderStockDetailEntityDto.getInventoryRoundingValue());
		}

		if (transferOrderStockDetailEntityDto.getStaff() != null) {
			this.setStaff(transferOrderStockDetailEntityDto.getStaff());
		}

		if (transferOrderStockDetailEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(transferOrderStockDetailEntityDto.getStockCatalogue());
		}

		if (transferOrderStockDetailEntityDto.getTransferOrder() != null) {
			this.setTransferOrder(transferOrderStockDetailEntityDto.getTransferOrder());
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

	// % protected region % [Modify attribute annotation for Destination SOH here] off begin
	@CsvBindByName(column = "DESTINATION_SOH", required = false)
	@Nullable
	@Column(name = "destination_soh")
	@Schema(description = "The Destination SOH of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Destination SOH here] end
	private Double destinationSOH;

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

	// % protected region % [Modify attribute annotation for Destination Max Level here] off begin
	@CsvBindByName(column = "DESTINATION_MAX_LEVEL", required = false)
	@Nullable
	@Column(name = "destination_max_level")
	@Schema(description = "The Destination Max Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Destination Max Level here] end
	private Double destinationMaxLevel;

	// % protected region % [Modify attribute annotation for Quantity Transferred here] off begin
	@CsvBindByName(column = "QUANTITY_TRANSFERRED", required = false)
	@Nullable
	@Column(name = "quantity_transferred")
	@Schema(description = "The Quantity Transferred of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Transferred here] end
	private Double quantityTransferred;

	// % protected region % [Modify attribute annotation for Quantity Fulfilled here] off begin
	@CsvBindByName(column = "QUANTITY_FULFILLED", required = false)
	@Nullable
	@Column(name = "quantity_fulfilled")
	@Schema(description = "The Quantity Fulfilled of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Fulfilled here] end
	private Double quantityFulfilled;

	// % protected region % [Modify attribute annotation for Order Date Time here] off begin

	@CsvCustomBindByName(column = "ORDER_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "order_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Order Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Order Date Time here] end
	private OffsetDateTime orderDateTime;

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

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Staff here] end
	private StaffEntity staff;

	// % protected region % [Update the annotation for staffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for staffId here] end
	private UUID staffId;

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

	// % protected region % [Update the annotation for Transfer Order here] off begin
	@Schema(description = "The Transfer Order entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Transfer Order here] end
	private TransferOrderEntity transferOrder;

	// % protected region % [Update the annotation for transferOrderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TRANSFER_ORDER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for transferOrderId here] end
	private UUID transferOrderId;

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
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NotNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeTransferOrderStockDetails(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addTransferOrderStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeTransferOrderStockDetails(this, false);
		}
		this.staff = null;
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
			this.stockCatalogue.removeTransferOrderStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addTransferOrderStockDetails(this, false);
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
			this.stockCatalogue.removeTransferOrderStockDetails(this, false);
		}
		this.stockCatalogue = null;
	}
	/**
	 * Similar to {@link this#setTransferOrder(TransferOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderEntity to be set to this entity
	 */
	public void setTransferOrder(@NotNull TransferOrderEntity entity) {
		setTransferOrder(entity, true);
	}

	/**
	 * Set or update the transferOrder in this entity with single TransferOrderEntity.
	 *
	 * @param entity the given TransferOrderEntity to be set or updated to transferOrder
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTransferOrder(@NotNull TransferOrderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTransferOrder here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTransferOrder here] end

		if (sameAsFormer(this.transferOrder, entity)) {
			return;
		}

		if (this.transferOrder != null) {
			this.transferOrder.removeTransferOrderStockDetails(this, false);
		}
		this.transferOrder = entity;
		if (reverseAdd) {
			this.transferOrder.addTransferOrderStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTransferOrder incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTransferOrder incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTransferOrder(boolean)} but default to true.
	 */
	public void unsetTransferOrder() {
		this.unsetTransferOrder(true);
	}

	/**
	 * Remove Transfer Order in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTransferOrder(boolean reverse) {
		if (reverse && this.transferOrder != null) {
			this.transferOrder.removeTransferOrderStockDetails(this, false);
		}
		this.transferOrder = null;
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
		return "ITEM_NUMBER,SOURCE_AVAILABLE_QUANTITY,DESTINATION_SOH,QUANTITY_ORDERED,UOM,TRANSACTION_STATUS,QUANTITY_ISSUED,QUANTITY_RECEIVED,SOURCE_MIN_LEVEL,DESTINATION_MAX_LEVEL,QUANTITY_TRANSFERRED,QUANTITY_FULFILLED,ORDER_DATE_TIME,ITEM_NOTES,INVENTORY_ROUNDING_VALUE,STAFF_ID,STOCK_CATALOGUE_ID,TRANSFER_ORDER_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		Optional<TransferOrderEntity> transferOrderRelation = Optional.ofNullable(this.transferOrder);
		transferOrderRelation.ifPresent(entity -> this.transferOrderId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object transferOrderStockDetail) {
		if (this == transferOrderStockDetail) {
			return true;
		}
		if (transferOrderStockDetail == null || this.getClass() != transferOrderStockDetail.getClass()) {
			return false;
		}
		if (!super.equals(transferOrderStockDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TransferOrderStockDetailEntity that = (TransferOrderStockDetailEntity) transferOrderStockDetail;
		return
			Objects.equals(this.itemNumber, that.itemNumber) &&
			Objects.equals(this.sourceAvailableQuantity, that.sourceAvailableQuantity) &&
			Objects.equals(this.destinationSOH, that.destinationSOH) &&
			Objects.equals(this.quantityOrdered, that.quantityOrdered) &&
			Objects.equals(this.uom, that.uom) &&
			Objects.equals(this.transactionStatus, that.transactionStatus) &&
			Objects.equals(this.quantityIssued, that.quantityIssued) &&
			Objects.equals(this.quantityReceived, that.quantityReceived) &&
			Objects.equals(this.sourceMinLevel, that.sourceMinLevel) &&
			Objects.equals(this.destinationMaxLevel, that.destinationMaxLevel) &&
			Objects.equals(this.quantityTransferred, that.quantityTransferred) &&
			Objects.equals(this.quantityFulfilled, that.quantityFulfilled) &&
			Objects.equals(
			     this.orderDateTime != null ? this.orderDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.orderDateTime != null ? that.orderDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.itemNotes, that.itemNotes) &&
			Objects.equals(this.inventoryRoundingValue, that.inventoryRoundingValue) &&
			Objects.equals(this.staffId, that.staffId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId) &&
			Objects.equals(this.transferOrderId, that.transferOrderId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
