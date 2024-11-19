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
import kmsweb.dtos.PurchaseRequisitionStockDetailEntityDto;
import kmsweb.entities.listeners.PurchaseRequisitionStockDetailEntityListener;
import kmsweb.serializers.PurchaseRequisitionStockDetailSerializer;
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
@EntityListeners({PurchaseRequisitionStockDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PurchaseRequisitionStockDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PurchaseRequisitionStockDetailEntity extends AbstractEntity {

	/**
	 * Takes a PurchaseRequisitionStockDetailEntityDto and converts it into a PurchaseRequisitionStockDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param purchaseRequisitionStockDetailEntityDto
	 */
	public PurchaseRequisitionStockDetailEntity(PurchaseRequisitionStockDetailEntityDto purchaseRequisitionStockDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (purchaseRequisitionStockDetailEntityDto.getId() != null) {
			this.setId(purchaseRequisitionStockDetailEntityDto.getId());
		}

		if (purchaseRequisitionStockDetailEntityDto.getSoh() != null) {
			this.setSoh(purchaseRequisitionStockDetailEntityDto.getSoh());
		}

		if (purchaseRequisitionStockDetailEntityDto.getMaxLevel() != null) {
			this.setMaxLevel(purchaseRequisitionStockDetailEntityDto.getMaxLevel());
		}

		if (purchaseRequisitionStockDetailEntityDto.getQuantityRequested() != null) {
			this.setQuantityRequested(purchaseRequisitionStockDetailEntityDto.getQuantityRequested());
		}

		if (purchaseRequisitionStockDetailEntityDto.getUop() != null) {
			this.setUop(purchaseRequisitionStockDetailEntityDto.getUop());
		}

		if (purchaseRequisitionStockDetailEntityDto.getUnitPrice() != null) {
			this.setUnitPrice(purchaseRequisitionStockDetailEntityDto.getUnitPrice());
		}

		if (purchaseRequisitionStockDetailEntityDto.getTotalPrice() != null) {
			this.setTotalPrice(purchaseRequisitionStockDetailEntityDto.getTotalPrice());
		}

		if (purchaseRequisitionStockDetailEntityDto.getItemStatus() != null) {
			this.setItemStatus(purchaseRequisitionStockDetailEntityDto.getItemStatus());
		}

		if (purchaseRequisitionStockDetailEntityDto.getQuantityOrdered() != null) {
			this.setQuantityOrdered(purchaseRequisitionStockDetailEntityDto.getQuantityOrdered());
		}

		if (purchaseRequisitionStockDetailEntityDto.getQuantityReceived() != null) {
			this.setQuantityReceived(purchaseRequisitionStockDetailEntityDto.getQuantityReceived());
		}

		if (purchaseRequisitionStockDetailEntityDto.getQuantityReturned() != null) {
			this.setQuantityReturned(purchaseRequisitionStockDetailEntityDto.getQuantityReturned());
		}

		if (purchaseRequisitionStockDetailEntityDto.getItemNotes() != null) {
			this.setItemNotes(purchaseRequisitionStockDetailEntityDto.getItemNotes());
		}

		if (purchaseRequisitionStockDetailEntityDto.getRemainingQuantity() != null) {
			this.setRemainingQuantity(purchaseRequisitionStockDetailEntityDto.getRemainingQuantity());
		}

		if (purchaseRequisitionStockDetailEntityDto.getPurchaseOrderStockDetails() != null) {
			this.setPurchaseOrderStockDetails(purchaseRequisitionStockDetailEntityDto.getPurchaseOrderStockDetails());
		}

		if (purchaseRequisitionStockDetailEntityDto.getPurchaseRequisition() != null) {
			this.setPurchaseRequisition(purchaseRequisitionStockDetailEntityDto.getPurchaseRequisition());
		}

		if (purchaseRequisitionStockDetailEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(purchaseRequisitionStockDetailEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	// % protected region % [Modify attribute annotation for Quantity Requested here] off begin
	@CsvBindByName(column = "QUANTITY_REQUESTED", required = false)
	@Nullable
	@Column(name = "quantity_requested")
	@Schema(description = "The Quantity Requested of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Requested here] end
	private Double quantityRequested;

	// % protected region % [Modify attribute annotation for UOP here] off begin
	@CsvBindByName(column = "UOP", required = false)
	@Nullable
	@Column(name = "uop")
	@Schema(description = "The UOP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOP here] end
	private String uop;

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@CsvBindByName(column = "UNIT_PRICE", required = false)
	@Nullable
	@Column(name = "unit_price")
	@Schema(description = "The Unit Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Total Price here] off begin
	@CsvBindByName(column = "TOTAL_PRICE", required = false)
	@Nullable
	@Column(name = "total_price")
	@Schema(description = "The Total Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Price here] end
	private Double totalPrice;

	// % protected region % [Modify attribute annotation for Item Status here] off begin
	@CsvBindByName(column = "ITEM_STATUS", required = false)
	@Nullable
	@Column(name = "item_status")
	@Schema(description = "The Item Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Status here] end
	private String itemStatus;

	// % protected region % [Modify attribute annotation for Quantity Ordered here] off begin
	@CsvBindByName(column = "QUANTITY_ORDERED", required = false)
	@Nullable
	@Column(name = "quantity_ordered")
	@Schema(description = "The Quantity Ordered of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Ordered here] end
	private Double quantityOrdered;

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

	// % protected region % [Update the annotation for Purchase Order Stock Details here] off begin
	@Schema(description = "The Purchase Order Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "purchaseRequisitionStockDetail", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Order Stock Details here] end
	private Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for purchaseOrderStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_ORDER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for purchaseOrderStockDetailsIds here] end
	private Set<UUID> purchaseOrderStockDetailsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Purchase Requisition here] off begin
	@Schema(description = "The Purchase Requisition entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Requisition here] end
	private PurchaseRequisitionEntity purchaseRequisition;

	// % protected region % [Update the annotation for purchaseRequisitionId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_REQUISITION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for purchaseRequisitionId here] end
	private UUID purchaseRequisitionId;

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
	 * Similar to {@link this#addPurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NotNull PurchaseOrderStockDetailEntity entity) {
		addPurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Add a new PurchaseOrderStockDetailEntity to purchaseOrderStockDetails in this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseOrderStockDetails(@NonNull PurchaseOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.purchaseOrderStockDetails.contains(entity)) {
			purchaseOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setPurchaseRequisitionStockDetail(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 */
	public void addPurchaseOrderStockDetails(@NotNull Collection<PurchaseOrderStockDetailEntity> entities) {
		addPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of PurchaseOrderStockDetailEntity to Purchase Order Stock Details in this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(PurchaseOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void removePurchaseOrderStockDetails(@NotNull PurchaseOrderStockDetailEntity entity) {
		this.removePurchaseOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given PurchaseOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given PurchaseOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseOrderStockDetails(@NotNull PurchaseOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPurchaseRequisitionStockDetail(false);
		}
		this.purchaseOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 */
	public void removePurchaseOrderStockDetails(@NotNull Collection<PurchaseOrderStockDetailEntity> entities) {
		this.removePurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseOrderStockDetails(@NonNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to be set to this entity
	 */
	public void setPurchaseOrderStockDetails(@NotNull Collection<PurchaseOrderStockDetailEntity> entities) {
		setPurchaseOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of PurchaseOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseOrderStockDetails(@NotNull Collection<PurchaseOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseOrderStockDetails();
		this.purchaseOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.setPurchaseRequisitionStockDetail(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseOrderStockDetails() {
		this.unsetPurchaseOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Purchase Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.unsetPurchaseRequisitionStockDetail(false));
		}
		this.purchaseOrderStockDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPurchaseRequisition(PurchaseRequisitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be set to this entity
	 */
	public void setPurchaseRequisition(@NotNull PurchaseRequisitionEntity entity) {
		setPurchaseRequisition(entity, true);
	}

	/**
	 * Set or update the purchaseRequisition in this entity with single PurchaseRequisitionEntity.
	 *
	 * @param entity the given PurchaseRequisitionEntity to be set or updated to purchaseRequisition
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPurchaseRequisition(@NotNull PurchaseRequisitionEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPurchaseRequisition here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPurchaseRequisition here] end

		if (sameAsFormer(this.purchaseRequisition, entity)) {
			return;
		}

		if (this.purchaseRequisition != null) {
			this.purchaseRequisition.removePurchaseRequisitionStockDetails(this, false);
		}
		this.purchaseRequisition = entity;
		if (reverseAdd) {
			this.purchaseRequisition.addPurchaseRequisitionStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPurchaseRequisition incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPurchaseRequisition incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisition(boolean)} but default to true.
	 */
	public void unsetPurchaseRequisition() {
		this.unsetPurchaseRequisition(true);
	}

	/**
	 * Remove Purchase Requisition in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPurchaseRequisition(boolean reverse) {
		if (reverse && this.purchaseRequisition != null) {
			this.purchaseRequisition.removePurchaseRequisitionStockDetails(this, false);
		}
		this.purchaseRequisition = null;
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
			this.stockCatalogue.removePurchaseRequisitionStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addPurchaseRequisitionStockDetails(this, false);
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
			this.stockCatalogue.removePurchaseRequisitionStockDetails(this, false);
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
		return "SOH,MAX_LEVEL,QUANTITY_REQUESTED,UOP,UNIT_PRICE,TOTAL_PRICE,ITEM_STATUS,QUANTITY_ORDERED,QUANTITY_RECEIVED,QUANTITY_RETURNED,ITEM_NOTES,REMAINING_QUANTITY,PURCHASE_REQUISITION_ID,STOCK_CATALOGUE_ID,PURCHASE_ORDER_STOCK_DETAILS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PurchaseRequisitionEntity> purchaseRequisitionRelation = Optional.ofNullable(this.purchaseRequisition);
		purchaseRequisitionRelation.ifPresent(entity -> this.purchaseRequisitionId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		this.purchaseOrderStockDetailsIds = new HashSet<>();
		for (PurchaseOrderStockDetailEntity purchaseOrderStockDetails: this.purchaseOrderStockDetails) {
			this.purchaseOrderStockDetailsIds.add(purchaseOrderStockDetails.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object purchaseRequisitionStockDetail) {
		if (this == purchaseRequisitionStockDetail) {
			return true;
		}
		if (purchaseRequisitionStockDetail == null || this.getClass() != purchaseRequisitionStockDetail.getClass()) {
			return false;
		}
		if (!super.equals(purchaseRequisitionStockDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PurchaseRequisitionStockDetailEntity that = (PurchaseRequisitionStockDetailEntity) purchaseRequisitionStockDetail;
		return
			Objects.equals(this.soh, that.soh) &&
			Objects.equals(this.maxLevel, that.maxLevel) &&
			Objects.equals(this.quantityRequested, that.quantityRequested) &&
			Objects.equals(this.uop, that.uop) &&
			Objects.equals(this.unitPrice, that.unitPrice) &&
			Objects.equals(this.totalPrice, that.totalPrice) &&
			Objects.equals(this.itemStatus, that.itemStatus) &&
			Objects.equals(this.quantityOrdered, that.quantityOrdered) &&
			Objects.equals(this.quantityReceived, that.quantityReceived) &&
			Objects.equals(this.quantityReturned, that.quantityReturned) &&
			Objects.equals(this.itemNotes, that.itemNotes) &&
			Objects.equals(this.remainingQuantity, that.remainingQuantity) &&
			Objects.equals(this.purchaseOrderStockDetailsIds, that.purchaseOrderStockDetailsIds) &&
			Objects.equals(this.purchaseRequisitionId, that.purchaseRequisitionId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
