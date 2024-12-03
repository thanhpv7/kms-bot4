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
import kmsweb.dtos.ReturnSupplierStockDetailEntityDto;
import kmsweb.entities.listeners.ReturnSupplierStockDetailEntityListener;
import kmsweb.serializers.ReturnSupplierStockDetailSerializer;
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
@EntityListeners({ReturnSupplierStockDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ReturnSupplierStockDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class ReturnSupplierStockDetailEntity extends AbstractEntity {

	/**
	 * Takes a ReturnSupplierStockDetailEntityDto and converts it into a ReturnSupplierStockDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param returnSupplierStockDetailEntityDto
	 */
	public ReturnSupplierStockDetailEntity(ReturnSupplierStockDetailEntityDto returnSupplierStockDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (returnSupplierStockDetailEntityDto.getId() != null) {
			this.setId(returnSupplierStockDetailEntityDto.getId());
		}

		if (returnSupplierStockDetailEntityDto.getPrice() != null) {
			this.setPrice(returnSupplierStockDetailEntityDto.getPrice());
		}

		if (returnSupplierStockDetailEntityDto.getAvailableQuantityReturned() != null) {
			this.setAvailableQuantityReturned(returnSupplierStockDetailEntityDto.getAvailableQuantityReturned());
		}

		if (returnSupplierStockDetailEntityDto.getUop() != null) {
			this.setUop(returnSupplierStockDetailEntityDto.getUop());
		}

		if (returnSupplierStockDetailEntityDto.getDiscountInPercent() != null) {
			this.setDiscountInPercent(returnSupplierStockDetailEntityDto.getDiscountInPercent());
		}

		if (returnSupplierStockDetailEntityDto.getDiscountValue() != null) {
			this.setDiscountValue(returnSupplierStockDetailEntityDto.getDiscountValue());
		}

		if (returnSupplierStockDetailEntityDto.getTaxable() != null) {
			this.setTaxable(returnSupplierStockDetailEntityDto.getTaxable());
		}

		if (returnSupplierStockDetailEntityDto.getItemPrice() != null) {
			this.setItemPrice(returnSupplierStockDetailEntityDto.getItemPrice());
		}

		if (returnSupplierStockDetailEntityDto.getAvailableQuantity() != null) {
			this.setAvailableQuantity(returnSupplierStockDetailEntityDto.getAvailableQuantity());
		}

		if (returnSupplierStockDetailEntityDto.getQuantityOrdered() != null) {
			this.setQuantityOrdered(returnSupplierStockDetailEntityDto.getQuantityOrdered());
		}

		if (returnSupplierStockDetailEntityDto.getQuantityReceived() != null) {
			this.setQuantityReceived(returnSupplierStockDetailEntityDto.getQuantityReceived());
		}

		if (returnSupplierStockDetailEntityDto.getPreviousQuantityReturned() != null) {
			this.setPreviousQuantityReturned(returnSupplierStockDetailEntityDto.getPreviousQuantityReturned());
		}

		if (returnSupplierStockDetailEntityDto.getItemNotes() != null) {
			this.setItemNotes(returnSupplierStockDetailEntityDto.getItemNotes());
		}

		if (returnSupplierStockDetailEntityDto.getReturnSupplier() != null) {
			this.setReturnSupplier(returnSupplierStockDetailEntityDto.getReturnSupplier());
		}

		if (returnSupplierStockDetailEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(returnSupplierStockDetailEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Price here] off begin
	@CsvBindByName(column = "PRICE", required = false)
	@Nullable
	@Column(name = "price")
	@Schema(description = "The Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Available Quantity Returned here] off begin
	@CsvBindByName(column = "AVAILABLE_QUANTITY_RETURNED", required = false)
	@Nullable
	@Column(name = "available_quantity_returned")
	@Schema(description = "The Available Quantity Returned of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Available Quantity Returned here] end
	private Double availableQuantityReturned;

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

	// % protected region % [Modify attribute annotation for Available Quantity here] off begin
	@CsvBindByName(column = "AVAILABLE_QUANTITY", required = false)
	@Nullable
	@Column(name = "available_quantity")
	@Schema(description = "The Available Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Available Quantity here] end
	private Double availableQuantity;

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

	// % protected region % [Modify attribute annotation for Previous Quantity Returned here] off begin
	@CsvBindByName(column = "PREVIOUS_QUANTITY_RETURNED", required = false)
	@Nullable
	@Column(name = "previous_quantity_returned")
	@Schema(description = "The Previous Quantity Returned of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Previous Quantity Returned here] end
	private Double previousQuantityReturned;

	// % protected region % [Modify attribute annotation for Item Notes here] off begin
	@CsvBindByName(column = "ITEM_NOTES", required = false)
	@Nullable
	@Column(name = "item_notes")
	@Schema(description = "The Item Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Item Notes here] end
	private String itemNotes;

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

	// % protected region % [Update the annotation for Return Supplier here] off begin
	@Schema(description = "The Return Supplier entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Return Supplier here] end
	private ReturnSupplierEntity returnSupplier;

	// % protected region % [Update the annotation for returnSupplierId here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETURN_SUPPLIER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for returnSupplierId here] end
	private UUID returnSupplierId;

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
	 * Similar to {@link this#setReturnSupplier(ReturnSupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierEntity to be set to this entity
	 */
	public void setReturnSupplier(@NotNull ReturnSupplierEntity entity) {
		setReturnSupplier(entity, true);
	}

	/**
	 * Set or update the returnSupplier in this entity with single ReturnSupplierEntity.
	 *
	 * @param entity the given ReturnSupplierEntity to be set or updated to returnSupplier
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setReturnSupplier(@NotNull ReturnSupplierEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setReturnSupplier here] off begin
		// % protected region % [Add any additional logic here before the main logic for setReturnSupplier here] end

		if (sameAsFormer(this.returnSupplier, entity)) {
			return;
		}

		if (this.returnSupplier != null) {
			this.returnSupplier.removeReturnSupplierStockDetails(this, false);
		}
		this.returnSupplier = entity;
		if (reverseAdd) {
			this.returnSupplier.addReturnSupplierStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setReturnSupplier incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setReturnSupplier incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetReturnSupplier(boolean)} but default to true.
	 */
	public void unsetReturnSupplier() {
		this.unsetReturnSupplier(true);
	}

	/**
	 * Remove Return Supplier in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetReturnSupplier(boolean reverse) {
		if (reverse && this.returnSupplier != null) {
			this.returnSupplier.removeReturnSupplierStockDetails(this, false);
		}
		this.returnSupplier = null;
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
			this.stockCatalogue.removeReturnSupplierStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addReturnSupplierStockDetails(this, false);
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
			this.stockCatalogue.removeReturnSupplierStockDetails(this, false);
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
		return "PRICE,AVAILABLE_QUANTITY_RETURNED,UOP,DISCOUNT_IN_PERCENT,DISCOUNT_VALUE,TAXABLE,ITEM_PRICE,AVAILABLE_QUANTITY,QUANTITY_ORDERED,QUANTITY_RECEIVED,PREVIOUS_QUANTITY_RETURNED,ITEM_NOTES,RETURN_SUPPLIER_ID,STOCK_CATALOGUE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<ReturnSupplierEntity> returnSupplierRelation = Optional.ofNullable(this.returnSupplier);
		returnSupplierRelation.ifPresent(entity -> this.returnSupplierId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object returnSupplierStockDetail) {
		if (this == returnSupplierStockDetail) {
			return true;
		}
		if (returnSupplierStockDetail == null || this.getClass() != returnSupplierStockDetail.getClass()) {
			return false;
		}
		if (!super.equals(returnSupplierStockDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ReturnSupplierStockDetailEntity that = (ReturnSupplierStockDetailEntity) returnSupplierStockDetail;
		return
			Objects.equals(this.price, that.price) &&
			Objects.equals(this.availableQuantityReturned, that.availableQuantityReturned) &&
			Objects.equals(this.uop, that.uop) &&
			Objects.equals(this.discountInPercent, that.discountInPercent) &&
			Objects.equals(this.discountValue, that.discountValue) &&
			Objects.equals(this.taxable, that.taxable) &&
			Objects.equals(this.itemPrice, that.itemPrice) &&
			Objects.equals(this.availableQuantity, that.availableQuantity) &&
			Objects.equals(this.quantityOrdered, that.quantityOrdered) &&
			Objects.equals(this.quantityReceived, that.quantityReceived) &&
			Objects.equals(this.previousQuantityReturned, that.previousQuantityReturned) &&
			Objects.equals(this.itemNotes, that.itemNotes) &&
			Objects.equals(this.returnSupplierId, that.returnSupplierId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
