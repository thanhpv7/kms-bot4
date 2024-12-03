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
import kmsweb.dtos.RetailPharmacyStockDetailEntityDto;
import kmsweb.entities.listeners.RetailPharmacyStockDetailEntityListener;
import kmsweb.serializers.RetailPharmacyStockDetailSerializer;
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
@EntityListeners({RetailPharmacyStockDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = RetailPharmacyStockDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class RetailPharmacyStockDetailEntity extends AbstractEntity {

	/**
	 * Takes a RetailPharmacyStockDetailEntityDto and converts it into a RetailPharmacyStockDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param retailPharmacyStockDetailEntityDto
	 */
	public RetailPharmacyStockDetailEntity(RetailPharmacyStockDetailEntityDto retailPharmacyStockDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (retailPharmacyStockDetailEntityDto.getId() != null) {
			this.setId(retailPharmacyStockDetailEntityDto.getId());
		}

		if (retailPharmacyStockDetailEntityDto.getSupplyStockGroup() != null) {
			this.setSupplyStockGroup(retailPharmacyStockDetailEntityDto.getSupplyStockGroup());
		}

		if (retailPharmacyStockDetailEntityDto.getUoi() != null) {
			this.setUoi(retailPharmacyStockDetailEntityDto.getUoi());
		}

		if (retailPharmacyStockDetailEntityDto.getAvailableQuantity() != null) {
			this.setAvailableQuantity(retailPharmacyStockDetailEntityDto.getAvailableQuantity());
		}

		if (retailPharmacyStockDetailEntityDto.getQuantity() != null) {
			this.setQuantity(retailPharmacyStockDetailEntityDto.getQuantity());
		}

		if (retailPharmacyStockDetailEntityDto.getUnitPrice() != null) {
			this.setUnitPrice(retailPharmacyStockDetailEntityDto.getUnitPrice());
		}

		if (retailPharmacyStockDetailEntityDto.getDiscount() != null) {
			this.setDiscount(retailPharmacyStockDetailEntityDto.getDiscount());
		}

		if (retailPharmacyStockDetailEntityDto.getTaxIncluded() != null) {
			this.setTaxIncluded(retailPharmacyStockDetailEntityDto.getTaxIncluded());
		}

		if (retailPharmacyStockDetailEntityDto.getTaxAmount() != null) {
			this.setTaxAmount(retailPharmacyStockDetailEntityDto.getTaxAmount());
		}

		if (retailPharmacyStockDetailEntityDto.getTotalItemPrice() != null) {
			this.setTotalItemPrice(retailPharmacyStockDetailEntityDto.getTotalItemPrice());
		}

		if (retailPharmacyStockDetailEntityDto.getRetailPharmacy() != null) {
			this.setRetailPharmacy(retailPharmacyStockDetailEntityDto.getRetailPharmacy());
		}

		if (retailPharmacyStockDetailEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(retailPharmacyStockDetailEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Supply Stock Group here] off begin
	@CsvBindByName(column = "SUPPLY_STOCK_GROUP", required = false)
	@Nullable
	@Column(name = "supply_stock_group")
	@Schema(description = "The Supply Stock Group of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Supply Stock Group here] end
	private String supplyStockGroup;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Available Quantity here] off begin
	@CsvBindByName(column = "AVAILABLE_QUANTITY", required = false)
	@Nullable
	@Column(name = "available_quantity")
	@Schema(description = "The Available Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Available Quantity here] end
	private Double availableQuantity;

	// % protected region % [Modify attribute annotation for Quantity here] off begin
	@CsvBindByName(column = "QUANTITY", required = false)
	@Nullable
	@Column(name = "quantity")
	@Schema(description = "The Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity here] end
	private Double quantity;

	// % protected region % [Modify attribute annotation for Unit Price here] off begin
	@CsvBindByName(column = "UNIT_PRICE", required = false)
	@Nullable
	@Column(name = "unit_price")
	@Schema(description = "The Unit Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit Price here] end
	private Double unitPrice;

	// % protected region % [Modify attribute annotation for Discount here] off begin
	@CsvBindByName(column = "DISCOUNT", required = false)
	@Nullable
	@Column(name = "discount")
	@Schema(description = "The Discount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Discount here] end
	private Double discount;

	// % protected region % [Modify attribute annotation for Tax Included here] off begin
	@CsvBindByName(column = "TAX_INCLUDED", required = false)
	@Nullable
	@Column(name = "tax_included")
	@Schema(description = "The Tax Included of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Included here] end
	private Boolean taxIncluded = false ;

	// % protected region % [Modify attribute annotation for Tax Amount here] off begin
	@CsvBindByName(column = "TAX_AMOUNT", required = false)
	@Nullable
	@Column(name = "tax_amount")
	@Schema(description = "The Tax Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Amount here] end
	private Double taxAmount;

	// % protected region % [Modify attribute annotation for Total Item Price here] off begin
	@CsvBindByName(column = "TOTAL_ITEM_PRICE", required = false)
	@Nullable
	@Column(name = "total_item_price")
	@Schema(description = "The Total Item Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Item Price here] end
	private Double totalItemPrice;

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

	// % protected region % [Update the annotation for Retail Pharmacy here] off begin
	@Schema(description = "The Retail Pharmacy entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Retail Pharmacy here] end
	private RetailPharmacyEntity retailPharmacy;

	// % protected region % [Update the annotation for retailPharmacyId here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETAIL_PHARMACY_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for retailPharmacyId here] end
	private UUID retailPharmacyId;

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
	 * Similar to {@link this#setRetailPharmacy(RetailPharmacyEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyEntity to be set to this entity
	 */
	public void setRetailPharmacy(@NotNull RetailPharmacyEntity entity) {
		setRetailPharmacy(entity, true);
	}

	/**
	 * Set or update the retailPharmacy in this entity with single RetailPharmacyEntity.
	 *
	 * @param entity the given RetailPharmacyEntity to be set or updated to retailPharmacy
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRetailPharmacy(@NotNull RetailPharmacyEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacy here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRetailPharmacy here] end

		if (sameAsFormer(this.retailPharmacy, entity)) {
			return;
		}

		if (this.retailPharmacy != null) {
			this.retailPharmacy.removeRetailPharmacyStockDetails(this, false);
		}
		this.retailPharmacy = entity;
		if (reverseAdd) {
			this.retailPharmacy.addRetailPharmacyStockDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacy incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRetailPharmacy incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacy(boolean)} but default to true.
	 */
	public void unsetRetailPharmacy() {
		this.unsetRetailPharmacy(true);
	}

	/**
	 * Remove Retail Pharmacy in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRetailPharmacy(boolean reverse) {
		if (reverse && this.retailPharmacy != null) {
			this.retailPharmacy.removeRetailPharmacyStockDetails(this, false);
		}
		this.retailPharmacy = null;
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
			this.stockCatalogue.removeRetailPharmacyStockDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addRetailPharmacyStockDetails(this, false);
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
			this.stockCatalogue.removeRetailPharmacyStockDetails(this, false);
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
		return "SUPPLY_STOCK_GROUP,UOI,AVAILABLE_QUANTITY,QUANTITY,UNIT_PRICE,DISCOUNT,TAX_INCLUDED,TAX_AMOUNT,TOTAL_ITEM_PRICE,RETAIL_PHARMACY_ID,STOCK_CATALOGUE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<RetailPharmacyEntity> retailPharmacyRelation = Optional.ofNullable(this.retailPharmacy);
		retailPharmacyRelation.ifPresent(entity -> this.retailPharmacyId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object retailPharmacyStockDetail) {
		if (this == retailPharmacyStockDetail) {
			return true;
		}
		if (retailPharmacyStockDetail == null || this.getClass() != retailPharmacyStockDetail.getClass()) {
			return false;
		}
		if (!super.equals(retailPharmacyStockDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		RetailPharmacyStockDetailEntity that = (RetailPharmacyStockDetailEntity) retailPharmacyStockDetail;
		return
			Objects.equals(this.supplyStockGroup, that.supplyStockGroup) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.availableQuantity, that.availableQuantity) &&
			Objects.equals(this.quantity, that.quantity) &&
			Objects.equals(this.unitPrice, that.unitPrice) &&
			Objects.equals(this.discount, that.discount) &&
			Objects.equals(this.taxIncluded, that.taxIncluded) &&
			Objects.equals(this.taxAmount, that.taxAmount) &&
			Objects.equals(this.totalItemPrice, that.totalItemPrice) &&
			Objects.equals(this.retailPharmacyId, that.retailPharmacyId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
