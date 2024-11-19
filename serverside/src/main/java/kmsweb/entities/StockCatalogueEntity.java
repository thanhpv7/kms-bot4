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
import kmsweb.dtos.StockCatalogueEntityDto;
import kmsweb.entities.listeners.StockCatalogueEntityListener;
import kmsweb.serializers.StockCatalogueSerializer;
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

import java.util.*;
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
@EntityListeners({StockCatalogueEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = StockCatalogueSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"stock_code"}, name = "stock_code"),
	}
)
public class StockCatalogueEntity extends AbstractEntity {

	/**
	 * Takes a StockCatalogueEntityDto and converts it into a StockCatalogueEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param stockCatalogueEntityDto
	 */
	public StockCatalogueEntity(StockCatalogueEntityDto stockCatalogueEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (stockCatalogueEntityDto.getId() != null) {
			this.setId(stockCatalogueEntityDto.getId());
		}

		if (stockCatalogueEntityDto.getTrackable() != null) {
			this.setTrackable(stockCatalogueEntityDto.getTrackable());
		}

		if (stockCatalogueEntityDto.getStockCode() != null) {
			this.setStockCode(stockCatalogueEntityDto.getStockCode());
		}

		if (stockCatalogueEntityDto.getStockName() != null) {
			this.setStockName(stockCatalogueEntityDto.getStockName());
		}

		if (stockCatalogueEntityDto.getDescription() != null) {
			this.setDescription(stockCatalogueEntityDto.getDescription());
		}

		if (stockCatalogueEntityDto.getWeight() != null) {
			this.setWeight(stockCatalogueEntityDto.getWeight());
		}

		if (stockCatalogueEntityDto.getWeightUnit() != null) {
			this.setWeightUnit(stockCatalogueEntityDto.getWeightUnit());
		}

		if (stockCatalogueEntityDto.getVolume() != null) {
			this.setVolume(stockCatalogueEntityDto.getVolume());
		}

		if (stockCatalogueEntityDto.getVolumeUnit() != null) {
			this.setVolumeUnit(stockCatalogueEntityDto.getVolumeUnit());
		}

		if (stockCatalogueEntityDto.getStockGroup() != null) {
			this.setStockGroup(stockCatalogueEntityDto.getStockGroup());
		}

		if (stockCatalogueEntityDto.getStockCategory() != null) {
			this.setStockCategory(stockCatalogueEntityDto.getStockCategory());
		}

		if (stockCatalogueEntityDto.getApprovalStatus() != null) {
			this.setApprovalStatus(stockCatalogueEntityDto.getApprovalStatus());
		}

		if (stockCatalogueEntityDto.getApprovedBy() != null) {
			this.setApprovedBy(stockCatalogueEntityDto.getApprovedBy());
		}

		if (stockCatalogueEntityDto.getApprovalDate() != null) {
			this.setApprovalDate(stockCatalogueEntityDto.getApprovalDate());
		}

		if (stockCatalogueEntityDto.getApprovalNotes() != null) {
			this.setApprovalNotes(stockCatalogueEntityDto.getApprovalNotes());
		}

		if (stockCatalogueEntityDto.getQuantityPerPack() != null) {
			this.setQuantityPerPack(stockCatalogueEntityDto.getQuantityPerPack());
		}

		if (stockCatalogueEntityDto.getUoi() != null) {
			this.setUoi(stockCatalogueEntityDto.getUoi());
		}

		if (stockCatalogueEntityDto.getLastBuyingPriceVATExcludeCurrency() != null) {
			this.setLastBuyingPriceVATExcludeCurrency(stockCatalogueEntityDto.getLastBuyingPriceVATExcludeCurrency());
		}

		if (stockCatalogueEntityDto.getLastBuyingPriceVATExcludePrice() != null) {
			this.setLastBuyingPriceVATExcludePrice(stockCatalogueEntityDto.getLastBuyingPriceVATExcludePrice());
		}

		if (stockCatalogueEntityDto.getLastBuyingPriceVATIncludeCurrency() != null) {
			this.setLastBuyingPriceVATIncludeCurrency(stockCatalogueEntityDto.getLastBuyingPriceVATIncludeCurrency());
		}

		if (stockCatalogueEntityDto.getLastBuyingPriceVATIncludePrice() != null) {
			this.setLastBuyingPriceVATIncludePrice(stockCatalogueEntityDto.getLastBuyingPriceVATIncludePrice());
		}

		if (stockCatalogueEntityDto.getMedicalType() != null) {
			this.setMedicalType(stockCatalogueEntityDto.getMedicalType());
		}

		if (stockCatalogueEntityDto.getStockCategoryVATExcluded() != null) {
			this.setStockCategoryVATExcluded(stockCatalogueEntityDto.getStockCategoryVATExcluded());
		}

		if (stockCatalogueEntityDto.getStockCategoryVATIncluded() != null) {
			this.setStockCategoryVATIncluded(stockCatalogueEntityDto.getStockCategoryVATIncluded());
		}

		if (stockCatalogueEntityDto.getOnHandQty() != null) {
			this.setOnHandQty(stockCatalogueEntityDto.getOnHandQty());
		}

		if (stockCatalogueEntityDto.getAverageCost() != null) {
			this.setAverageCost(stockCatalogueEntityDto.getAverageCost());
		}

		if (stockCatalogueEntityDto.getTotalCost() != null) {
			this.setTotalCost(stockCatalogueEntityDto.getTotalCost());
		}

		if (stockCatalogueEntityDto.getSalesAccount() != null) {
			this.setSalesAccount(stockCatalogueEntityDto.getSalesAccount());
		}

		if (stockCatalogueEntityDto.getInventoryAccount() != null) {
			this.setInventoryAccount(stockCatalogueEntityDto.getInventoryAccount());
		}

		if (stockCatalogueEntityDto.getPurchaseAccount() != null) {
			this.setPurchaseAccount(stockCatalogueEntityDto.getPurchaseAccount());
		}

		if (stockCatalogueEntityDto.getLupSupplierName() != null) {
			this.setLupSupplierName(stockCatalogueEntityDto.getLupSupplierName());
		}

		if (stockCatalogueEntityDto.getLupUnitPrice() != null) {
			this.setLupUnitPrice(stockCatalogueEntityDto.getLupUnitPrice());
		}

		if (stockCatalogueEntityDto.getLupDiscount() != null) {
			this.setLupDiscount(stockCatalogueEntityDto.getLupDiscount());
		}

		if (stockCatalogueEntityDto.getLupItemPrice() != null) {
			this.setLupItemPrice(stockCatalogueEntityDto.getLupItemPrice());
		}

		if (stockCatalogueEntityDto.getLupLastPurchaseDate() != null) {
			this.setLupLastPurchaseDate(stockCatalogueEntityDto.getLupLastPurchaseDate());
		}

		if (stockCatalogueEntityDto.getLppSupplierName() != null) {
			this.setLppSupplierName(stockCatalogueEntityDto.getLppSupplierName());
		}

		if (stockCatalogueEntityDto.getLppUnitPrice() != null) {
			this.setLppUnitPrice(stockCatalogueEntityDto.getLppUnitPrice());
		}

		if (stockCatalogueEntityDto.getLppDiscount() != null) {
			this.setLppDiscount(stockCatalogueEntityDto.getLppDiscount());
		}

		if (stockCatalogueEntityDto.getLppItemPrice() != null) {
			this.setLppItemPrice(stockCatalogueEntityDto.getLppItemPrice());
		}

		if (stockCatalogueEntityDto.getLppLastPurchaseDate() != null) {
			this.setLppLastPurchaseDate(stockCatalogueEntityDto.getLppLastPurchaseDate());
		}

		if (stockCatalogueEntityDto.getBatchStockBalancesCatalogue() != null) {
			this.setBatchStockBalancesCatalogue(stockCatalogueEntityDto.getBatchStockBalancesCatalogue());
		}

		if (stockCatalogueEntityDto.getBatchStockBalances() != null) {
			this.setBatchStockBalances(stockCatalogueEntityDto.getBatchStockBalances());
		}

		if (stockCatalogueEntityDto.getBatchStockTransactionDetails() != null) {
			this.setBatchStockTransactionDetails(stockCatalogueEntityDto.getBatchStockTransactionDetails());
		}

		if (stockCatalogueEntityDto.getCatalogueUOMs() != null) {
			this.setCatalogueUOMs(stockCatalogueEntityDto.getCatalogueUOMs());
		}

		if (stockCatalogueEntityDto.getCompoundPrescriptionItems() != null) {
			this.setCompoundPrescriptionItems(stockCatalogueEntityDto.getCompoundPrescriptionItems());
		}

		if (stockCatalogueEntityDto.getGoodsReceiveNoteBatchs() != null) {
			this.setGoodsReceiveNoteBatchs(stockCatalogueEntityDto.getGoodsReceiveNoteBatchs());
		}

		if (stockCatalogueEntityDto.getGoodsReceiveNoteItems() != null) {
			this.setGoodsReceiveNoteItems(stockCatalogueEntityDto.getGoodsReceiveNoteItems());
		}

		if (stockCatalogueEntityDto.getInternalOrderStockDetails() != null) {
			this.setInternalOrderStockDetails(stockCatalogueEntityDto.getInternalOrderStockDetails());
		}

		if (stockCatalogueEntityDto.getInventoryAdjusmentBatchs() != null) {
			this.setInventoryAdjusmentBatchs(stockCatalogueEntityDto.getInventoryAdjusmentBatchs());
		}

		if (stockCatalogueEntityDto.getInventoryAdjustmentItems() != null) {
			this.setInventoryAdjustmentItems(stockCatalogueEntityDto.getInventoryAdjustmentItems());
		}

		if (stockCatalogueEntityDto.getInventoryBatchCorrectionItems() != null) {
			this.setInventoryBatchCorrectionItems(stockCatalogueEntityDto.getInventoryBatchCorrectionItems());
		}

		if (stockCatalogueEntityDto.getMedicationItems() != null) {
			this.setMedicationItems(stockCatalogueEntityDto.getMedicationItems());
		}

		if (stockCatalogueEntityDto.getPrescriptionItem() != null) {
			this.setPrescriptionItem(stockCatalogueEntityDto.getPrescriptionItem());
		}

		if (stockCatalogueEntityDto.getPurchaseOrderStockDetails() != null) {
			this.setPurchaseOrderStockDetails(stockCatalogueEntityDto.getPurchaseOrderStockDetails());
		}

		if (stockCatalogueEntityDto.getPurchaseRequisitionStockDetails() != null) {
			this.setPurchaseRequisitionStockDetails(stockCatalogueEntityDto.getPurchaseRequisitionStockDetails());
		}

		if (stockCatalogueEntityDto.getRetailPharmacyStockDetails() != null) {
			this.setRetailPharmacyStockDetails(stockCatalogueEntityDto.getRetailPharmacyStockDetails());
		}

		if (stockCatalogueEntityDto.getReturnSupplierStockDetails() != null) {
			this.setReturnSupplierStockDetails(stockCatalogueEntityDto.getReturnSupplierStockDetails());
		}

		if (stockCatalogueEntityDto.getStockCatalogueMedical() != null) {
			this.setStockCatalogueMedical(stockCatalogueEntityDto.getStockCatalogueMedical());
		}

		if (stockCatalogueEntityDto.getStockCatalogueNonMedical() != null) {
			this.setStockCatalogueNonMedical(stockCatalogueEntityDto.getStockCatalogueNonMedical());
		}

		if (stockCatalogueEntityDto.getStockControls() != null) {
			this.setStockControls(stockCatalogueEntityDto.getStockControls());
		}

		if (stockCatalogueEntityDto.getStockTransactionDetails() != null) {
			this.setStockTransactionDetails(stockCatalogueEntityDto.getStockTransactionDetails());
		}

		if (stockCatalogueEntityDto.getStockTransactionPerDateTypes() != null) {
			this.setStockTransactionPerDateTypes(stockCatalogueEntityDto.getStockTransactionPerDateTypes());
		}

		if (stockCatalogueEntityDto.getStockTransactionPerDates() != null) {
			this.setStockTransactionPerDates(stockCatalogueEntityDto.getStockTransactionPerDates());
		}

		if (stockCatalogueEntityDto.getSupplierProductDetails() != null) {
			this.setSupplierProductDetails(stockCatalogueEntityDto.getSupplierProductDetails());
		}

		if (stockCatalogueEntityDto.getTransferOrderStockDetails() != null) {
			this.setTransferOrderStockDetails(stockCatalogueEntityDto.getTransferOrderStockDetails());
		}

		if (stockCatalogueEntityDto.getVaccinationOrderDetails() != null) {
			this.setVaccinationOrderDetails(stockCatalogueEntityDto.getVaccinationOrderDetails());
		}

		if (stockCatalogueEntityDto.getWarehouseInitialStockS() != null) {
			this.setWarehouseInitialStockS(stockCatalogueEntityDto.getWarehouseInitialStockS());
		}

		if (stockCatalogueEntityDto.getWarehouseInventories() != null) {
			this.setWarehouseInventories(stockCatalogueEntityDto.getWarehouseInventories());
		}

		if (stockCatalogueEntityDto.getBpjsDrugGenericPRB() != null) {
			this.setBpjsDrugGenericPRB(stockCatalogueEntityDto.getBpjsDrugGenericPRB());
		}

		if (stockCatalogueEntityDto.getBpjsPcareDPHO() != null) {
			this.setBpjsPcareDPHO(stockCatalogueEntityDto.getBpjsPcareDPHO());
		}

		if (stockCatalogueEntityDto.getWarehouse() != null) {
			this.setWarehouse(stockCatalogueEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Trackable here] off begin
	@CsvBindByName(column = "TRACKABLE", required = false)
	@Nullable
	@Column(name = "trackable")
	@Schema(description = "The Trackable of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Trackable here] end
	private Boolean trackable = false ;

	// % protected region % [Modify attribute annotation for Stock Code here] off begin
	@CsvBindByName(column = "STOCK_CODE", required = false)
	@Nullable
	@Column(name = "stock_code")
	@Schema(description = "The Stock Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stock Code here] end
	private String stockCode;

	// % protected region % [Modify attribute annotation for Stock Name here] off begin
	@CsvBindByName(column = "STOCK_NAME", required = false)
	@Nullable
	@Column(name = "stock_name")
	@Schema(description = "The Stock Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stock Name here] end
	private String stockName;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@CsvBindByName(column = "WEIGHT", required = false)
	@Nullable
	@Column(name = "weight")
	@Schema(description = "The Weight of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Weight Unit here] off begin
	@CsvBindByName(column = "WEIGHT_UNIT", required = false)
	@Nullable
	@Column(name = "weight_unit")
	@Schema(description = "The Weight Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Unit here] end
	private String weightUnit;

	// % protected region % [Modify attribute annotation for Volume here] off begin
	@CsvBindByName(column = "VOLUME", required = false)
	@Nullable
	@Column(name = "volume")
	@Schema(description = "The Volume of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Volume here] end
	private Double volume;

	// % protected region % [Modify attribute annotation for Volume Unit here] off begin
	@CsvBindByName(column = "VOLUME_UNIT", required = false)
	@Nullable
	@Column(name = "volume_unit")
	@Schema(description = "The Volume Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Volume Unit here] end
	private String volumeUnit;

	// % protected region % [Modify attribute annotation for Stock Group here] off begin
	@CsvBindByName(column = "STOCK_GROUP", required = false)
	@Nullable
	@Column(name = "stock_group")
	@Schema(description = "The Stock Group of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stock Group here] end
	private String stockGroup;

	// % protected region % [Modify attribute annotation for Stock Category here] off begin
	@CsvBindByName(column = "STOCK_CATEGORY", required = false)
	@Nullable
	@Column(name = "stock_category")
	@Schema(description = "The Stock Category of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stock Category here] end
	private String stockCategory;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@CsvBindByName(column = "APPROVAL_STATUS", required = false)
	@Nullable
	@Column(name = "approval_status")
	@Schema(description = "The Approval Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Approved By here] off begin
	@CsvBindByName(column = "APPROVED_BY", required = false)
	@Nullable
	@Column(name = "approved_by")
	@Schema(description = "The Approved By of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approved By here] end
	private String approvedBy;

	// % protected region % [Modify attribute annotation for Approval Date here] off begin
	@CsvCustomBindByName(column = "APPROVAL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "approval_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Approval Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Date here] end
	private OffsetDateTime approvalDate;

	// % protected region % [Modify attribute annotation for Approval Notes here] off begin
	@CsvBindByName(column = "APPROVAL_NOTES", required = false)
	@Nullable
	@Column(name = "approval_notes")
	@Schema(description = "The Approval Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Notes here] end
	private String approvalNotes;

	// % protected region % [Modify attribute annotation for Quantity Per Pack here] off begin
	@CsvBindByName(column = "QUANTITY_PER_PACK", required = false)
	@Nullable
	@Column(name = "quantity_per_pack")
	@Schema(description = "The Quantity Per Pack of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity Per Pack here] end
	private Integer quantityPerPack;

	// % protected region % [Modify attribute annotation for UOI here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The UOI of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for UOI here] end
	private String uoi;

	// % protected region % [Modify attribute annotation for Last Buying Price VAT exclude Currency here] off begin
	@CsvBindByName(column = "LAST_BUYING_PRICE_VAT_EXCLUDE_CURRENCY", required = false)
	@Nullable
	@Column(name = "last_buying_price_vat_exclude_currency")
	@Schema(description = "The Last Buying Price VAT exclude Currency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Buying Price VAT exclude Currency here] end
	private String lastBuyingPriceVATExcludeCurrency;

	// % protected region % [Modify attribute annotation for Last Buying Price VAT exclude Price here] off begin
	@CsvBindByName(column = "LAST_BUYING_PRICE_VAT_EXCLUDE_PRICE", required = false)
	@Nullable
	@Column(name = "last_buying_price_vat_exclude_price")
	@Schema(description = "The Last Buying Price VAT exclude Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Buying Price VAT exclude Price here] end
	private Double lastBuyingPriceVATExcludePrice;

	// % protected region % [Modify attribute annotation for Last Buying Price VAT include Currency here] off begin
	@CsvBindByName(column = "LAST_BUYING_PRICE_VAT_INCLUDE_CURRENCY", required = false)
	@Nullable
	@Column(name = "last_buying_price_vat_include_currency")
	@Schema(description = "The Last Buying Price VAT include Currency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Buying Price VAT include Currency here] end
	private String lastBuyingPriceVATIncludeCurrency;

	// % protected region % [Modify attribute annotation for Last Buying Price VAT include Price here] off begin
	@CsvBindByName(column = "LAST_BUYING_PRICE_VAT_INCLUDE_PRICE", required = false)
	@Nullable
	@Column(name = "last_buying_price_vat_include_price")
	@Schema(description = "The Last Buying Price VAT include Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Last Buying Price VAT include Price here] end
	private Double lastBuyingPriceVATIncludePrice;

	// % protected region % [Modify attribute annotation for Medical Type here] off begin
	@CsvBindByName(column = "MEDICAL_TYPE", required = false)
	@Nullable
	@Column(name = "medical_type")
	@Schema(description = "The Medical Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Medical Type here] end
	private Boolean medicalType = false ;

	// % protected region % [Modify attribute annotation for Stock Category VAT Excluded here] off begin
	@CsvBindByName(column = "STOCK_CATEGORY_VAT_EXCLUDED", required = false)
	@Nullable
	@Column(name = "stock_category_vat_excluded")
	@Schema(description = "The Stock Category VAT Excluded of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stock Category VAT Excluded here] end
	private String stockCategoryVATExcluded;

	// % protected region % [Modify attribute annotation for Stock Category VAT Included here] off begin
	@CsvBindByName(column = "STOCK_CATEGORY_VAT_INCLUDED", required = false)
	@Nullable
	@Column(name = "stock_category_vat_included")
	@Schema(description = "The Stock Category VAT Included of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Stock Category VAT Included here] end
	private String stockCategoryVATIncluded;

	// % protected region % [Modify attribute annotation for On Hand Qty here] off begin
	@CsvBindByName(column = "ON_HAND_QTY", required = false)
	@Nullable
	@Column(name = "on_hand_qty")
	@Schema(description = "The On Hand Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for On Hand Qty here] end
	private Double onHandQty;

	// % protected region % [Modify attribute annotation for Average Cost here] off begin
	@CsvBindByName(column = "AVERAGE_COST", required = false)
	@Nullable
	@Column(name = "average_cost")
	@Schema(description = "The Average Cost of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Average Cost here] end
	private Double averageCost;

	// % protected region % [Modify attribute annotation for Total Cost here] off begin
	@CsvBindByName(column = "TOTAL_COST", required = false)
	@Nullable
	@Column(name = "total_cost")
	@Schema(description = "The Total Cost of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Cost here] end
	private Double totalCost;

	// % protected region % [Modify attribute annotation for Sales Account here] off begin
	@CsvBindByName(column = "SALES_ACCOUNT", required = false)
	@Nullable
	@Column(name = "sales_account")
	@Schema(description = "The Sales Account of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sales Account here] end
	private String salesAccount;

	// % protected region % [Modify attribute annotation for Inventory Account here] off begin
	@CsvBindByName(column = "INVENTORY_ACCOUNT", required = false)
	@Nullable
	@Column(name = "inventory_account")
	@Schema(description = "The Inventory Account of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inventory Account here] end
	private String inventoryAccount;

	// % protected region % [Modify attribute annotation for Purchase Account here] off begin
	@CsvBindByName(column = "PURCHASE_ACCOUNT", required = false)
	@Nullable
	@Column(name = "purchase_account")
	@Schema(description = "The Purchase Account of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Purchase Account here] end
	private String purchaseAccount;

	// % protected region % [Modify attribute annotation for Lup Supplier Name here] off begin
	@CsvBindByName(column = "LUP_SUPPLIER_NAME", required = false)
	@Nullable
	@Column(name = "lup_supplier_name")
	@Schema(description = "The Lup Supplier Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lup Supplier Name here] end
	private String lupSupplierName;

	// % protected region % [Modify attribute annotation for Lup Unit Price here] off begin
	@CsvBindByName(column = "LUP_UNIT_PRICE", required = false)
	@Nullable
	@Column(name = "lup_unit_price")
	@Schema(description = "The Lup Unit Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lup Unit Price here] end
	private Double lupUnitPrice;

	// % protected region % [Modify attribute annotation for Lup Discount here] off begin
	@CsvBindByName(column = "LUP_DISCOUNT", required = false)
	@Nullable
	@Column(name = "lup_discount")
	@Schema(description = "The Lup Discount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lup Discount here] end
	private Double lupDiscount;

	// % protected region % [Modify attribute annotation for Lup Item Price here] off begin
	@CsvBindByName(column = "LUP_ITEM_PRICE", required = false)
	@Nullable
	@Column(name = "lup_item_price")
	@Schema(description = "The Lup Item Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lup Item Price here] end
	private Double lupItemPrice;

	// % protected region % [Modify attribute annotation for Lup Last Purchase Date here] off begin
	@CsvCustomBindByName(column = "LUP_LAST_PURCHASE_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "lup_last_purchase_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Lup Last Purchase Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lup Last Purchase Date here] end
	private OffsetDateTime lupLastPurchaseDate;

	// % protected region % [Modify attribute annotation for Lpp Supplier Name here] off begin
	@CsvBindByName(column = "LPP_SUPPLIER_NAME", required = false)
	@Nullable
	@Column(name = "lpp_supplier_name")
	@Schema(description = "The Lpp Supplier Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lpp Supplier Name here] end
	private String lppSupplierName;

	// % protected region % [Modify attribute annotation for Lpp Unit Price here] off begin
	@CsvBindByName(column = "LPP_UNIT_PRICE", required = false)
	@Nullable
	@Column(name = "lpp_unit_price")
	@Schema(description = "The Lpp Unit Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lpp Unit Price here] end
	private Double lppUnitPrice;

	// % protected region % [Modify attribute annotation for Lpp Discount here] off begin
	@CsvBindByName(column = "LPP_DISCOUNT", required = false)
	@Nullable
	@Column(name = "lpp_discount")
	@Schema(description = "The Lpp Discount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lpp Discount here] end
	private Double lppDiscount;

	// % protected region % [Modify attribute annotation for Lpp Item Price here] off begin
	@CsvBindByName(column = "LPP_ITEM_PRICE", required = false)
	@Nullable
	@Column(name = "lpp_item_price")
	@Schema(description = "The Lpp Item Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lpp Item Price here] end
	private Double lppItemPrice;

	// % protected region % [Modify attribute annotation for Lpp Last Purchase Date here] off begin
	@CsvCustomBindByName(column = "LPP_LAST_PURCHASE_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "lpp_last_purchase_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Lpp Last Purchase Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Lpp Last Purchase Date here] end
	private OffsetDateTime lppLastPurchaseDate;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Batch Stock Balances Catalogue here] off begin
	@Schema(description = "The Batch Stock Balance entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Batch Stock Balances Catalogue here] end
	private Set<BatchStockBalanceEntity> batchStockBalancesCatalogue = new HashSet<>();

	// % protected region % [Update the annotation for batchStockBalancesCatalogueIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BATCH_STOCK_BALANCES_CATALOGUE_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for batchStockBalancesCatalogueIds here] end
	private Set<UUID> batchStockBalancesCatalogueIds = new HashSet<>();

	// % protected region % [Update the annotation for Batch Stock Balances here] off begin
	@Schema(description = "The Batch Stock Balance Per Date entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Batch Stock Balances here] end
	private Set<BatchStockBalancePerDateEntity> batchStockBalances = new HashSet<>();

	// % protected region % [Update the annotation for batchStockBalancesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BATCH_STOCK_BALANCES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for batchStockBalancesIds here] end
	private Set<UUID> batchStockBalancesIds = new HashSet<>();

	// % protected region % [Update the annotation for Batch Stock Transaction Details here] off begin
	@Schema(description = "The Batch Stock Transaction Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Batch Stock Transaction Details here] end
	private Set<BatchStockTransactionDetailEntity> batchStockTransactionDetails = new HashSet<>();

	// % protected region % [Update the annotation for batchStockTransactionDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BATCH_STOCK_TRANSACTION_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for batchStockTransactionDetailsIds here] end
	private Set<UUID> batchStockTransactionDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Catalogue UOMs here] off begin
	@Schema(description = "The Catalogue UOM entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Catalogue UOMs here] end
	private Set<CatalogueUOMEntity> catalogueUOMs = new HashSet<>();

	// % protected region % [Update the annotation for catalogueUOMsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CATALOGUE_UOMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for catalogueUOMsIds here] end
	private Set<UUID> catalogueUOMsIds = new HashSet<>();

	// % protected region % [Update the annotation for Compound Prescription Items here] off begin
	@Schema(description = "The Compound Prescription Item entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Compound Prescription Items here] end
	private Set<CompoundPrescriptionItemEntity> compoundPrescriptionItems = new HashSet<>();

	// % protected region % [Update the annotation for compoundPrescriptionItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "COMPOUND_PRESCRIPTION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for compoundPrescriptionItemsIds here] end
	private Set<UUID> compoundPrescriptionItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Goods Receive Note Batchs here] off begin
	@Schema(description = "The Goods Receive Note Batch entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Goods Receive Note Batchs here] end
	private Set<GoodsReceiveNoteBatchEntity> goodsReceiveNoteBatchs = new HashSet<>();

	// % protected region % [Update the annotation for goodsReceiveNoteBatchsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "GOODS_RECEIVE_NOTE_BATCHS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for goodsReceiveNoteBatchsIds here] end
	private Set<UUID> goodsReceiveNoteBatchsIds = new HashSet<>();

	// % protected region % [Update the annotation for Goods Receive Note Items here] off begin
	@Schema(description = "The Goods Receive Note Item entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Goods Receive Note Items here] end
	private Set<GoodsReceiveNoteItemEntity> goodsReceiveNoteItems = new HashSet<>();

	// % protected region % [Update the annotation for goodsReceiveNoteItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "GOODS_RECEIVE_NOTE_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for goodsReceiveNoteItemsIds here] end
	private Set<UUID> goodsReceiveNoteItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Internal Order Stock Details here] off begin
	@Schema(description = "The Internal Order Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Internal Order Stock Details here] end
	private Set<InternalOrderStockDetailEntity> internalOrderStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for internalOrderStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INTERNAL_ORDER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for internalOrderStockDetailsIds here] end
	private Set<UUID> internalOrderStockDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Inventory Adjusment Batchs here] off begin
	@Schema(description = "The Inventory Adjusment Batch entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Adjusment Batchs here] end
	private Set<InventoryAdjusmentBatchEntity> inventoryAdjusmentBatchs = new HashSet<>();

	// % protected region % [Update the annotation for inventoryAdjusmentBatchsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_ADJUSMENT_BATCHS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for inventoryAdjusmentBatchsIds here] end
	private Set<UUID> inventoryAdjusmentBatchsIds = new HashSet<>();

	// % protected region % [Update the annotation for Inventory Adjustment Items here] off begin
	@Schema(description = "The Inventory Adjustment Item entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Adjustment Items here] end
	private Set<InventoryAdjustmentItemEntity> inventoryAdjustmentItems = new HashSet<>();

	// % protected region % [Update the annotation for inventoryAdjustmentItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_ADJUSTMENT_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for inventoryAdjustmentItemsIds here] end
	private Set<UUID> inventoryAdjustmentItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Inventory Batch Correction Items here] off begin
	@Schema(description = "The Inventory Batch Correction Item entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Batch Correction Items here] end
	private Set<InventoryBatchCorrectionItemEntity> inventoryBatchCorrectionItems = new HashSet<>();

	// % protected region % [Update the annotation for inventoryBatchCorrectionItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_BATCH_CORRECTION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for inventoryBatchCorrectionItemsIds here] end
	private Set<UUID> inventoryBatchCorrectionItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Medication Items here] off begin
	@Schema(description = "The Medication Item entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Items here] end
	private Set<MedicationItemEntity> medicationItems = new HashSet<>();

	// % protected region % [Update the annotation for medicationItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for medicationItemsIds here] end
	private Set<UUID> medicationItemsIds = new HashSet<>();

	// % protected region % [Update the annotation for Prescription Item here] off begin
	@Schema(description = "The Prescription Item entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogueId", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Prescription Item here] end
	private Set<PrescriptionItemEntity> prescriptionItem = new HashSet<>();

	// % protected region % [Update the annotation for prescriptionItemIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRESCRIPTION_ITEM_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for prescriptionItemIds here] end
	private Set<UUID> prescriptionItemIds = new HashSet<>();

	// % protected region % [Update the annotation for Purchase Order Stock Details here] off begin
	@Schema(description = "The Purchase Order Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Order Stock Details here] end
	private Set<PurchaseOrderStockDetailEntity> purchaseOrderStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for purchaseOrderStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_ORDER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for purchaseOrderStockDetailsIds here] end
	private Set<UUID> purchaseOrderStockDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Purchase Requisition Stock Details here] off begin
	@Schema(description = "The Purchase Requisition Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Purchase Requisition Stock Details here] end
	private Set<PurchaseRequisitionStockDetailEntity> purchaseRequisitionStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for purchaseRequisitionStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PURCHASE_REQUISITION_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for purchaseRequisitionStockDetailsIds here] end
	private Set<UUID> purchaseRequisitionStockDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Retail Pharmacy Stock Details here] off begin
	@Schema(description = "The Retail Pharmacy Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Retail Pharmacy Stock Details here] end
	private Set<RetailPharmacyStockDetailEntity> retailPharmacyStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for retailPharmacyStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETAIL_PHARMACY_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for retailPharmacyStockDetailsIds here] end
	private Set<UUID> retailPharmacyStockDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Return Supplier Stock Details here] off begin
	@Schema(description = "The Return Supplier Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Return Supplier Stock Details here] end
	private Set<ReturnSupplierStockDetailEntity> returnSupplierStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for returnSupplierStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "RETURN_SUPPLIER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for returnSupplierStockDetailsIds here] end
	private Set<UUID> returnSupplierStockDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Stock Catalogue Medical  here] off begin
	@Schema(description = "The Catalogue Medical  entities that are related to this entity.")
	@OneToOne(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Catalogue Medical  here] end
	private CatalogueMedicalEntity stockCatalogueMedical;

	// % protected region % [Update the annotation for stockCatalogueMedicalId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_CATALOGUE_MEDICAL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for stockCatalogueMedicalId here] end
	private UUID stockCatalogueMedicalId;

	// % protected region % [Update the annotation for Stock Catalogue Non Medical here] off begin
	@Schema(description = "The Catalogue Non Medical entities that are related to this entity.")
	@OneToOne(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Catalogue Non Medical here] end
	private CatalogueNonMedicalEntity stockCatalogueNonMedical;

	// % protected region % [Update the annotation for stockCatalogueNonMedicalId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_CATALOGUE_NON_MEDICAL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for stockCatalogueNonMedicalId here] end
	private UUID stockCatalogueNonMedicalId;

	// % protected region % [Update the annotation for Stock Controls here] off begin
	@Schema(description = "The Stock Control entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Controls here] end
	private Set<StockControlEntity> stockControls = new HashSet<>();

	// % protected region % [Update the annotation for stockControlsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_CONTROLS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for stockControlsIds here] end
	private Set<UUID> stockControlsIds = new HashSet<>();

	// % protected region % [Update the annotation for Stock Transaction Details here] off begin
	@Schema(description = "The Stock Transaction Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Transaction Details here] end
	private Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();

	// % protected region % [Update the annotation for stockTransactionDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_TRANSACTION_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for stockTransactionDetailsIds here] end
	private Set<UUID> stockTransactionDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Stock Transaction Per Date Types here] off begin
	@Schema(description = "The Stock Transaction Per Date Type entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Transaction Per Date Types here] end
	private Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();

	// % protected region % [Update the annotation for stockTransactionPerDateTypesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_TRANSACTION_PER_DATE_TYPES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for stockTransactionPerDateTypesIds here] end
	private Set<UUID> stockTransactionPerDateTypesIds = new HashSet<>();

	// % protected region % [Update the annotation for Stock Transaction Per Dates here] off begin
	@Schema(description = "The Stock Transaction Per Date entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Transaction Per Dates here] end
	private Set<StockTransactionPerDateEntity> stockTransactionPerDates = new HashSet<>();

	// % protected region % [Update the annotation for stockTransactionPerDatesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_TRANSACTION_PER_DATES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for stockTransactionPerDatesIds here] end
	private Set<UUID> stockTransactionPerDatesIds = new HashSet<>();

	// % protected region % [Update the annotation for Supplier Product Details here] off begin
	@Schema(description = "The Supplier Product Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Supplier Product Details here] end
	private Set<SupplierProductDetailEntity> supplierProductDetails = new HashSet<>();

	// % protected region % [Update the annotation for supplierProductDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "SUPPLIER_PRODUCT_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for supplierProductDetailsIds here] end
	private Set<UUID> supplierProductDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Transfer Order Stock Details here] off begin
	@Schema(description = "The Transfer Order Stock Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Transfer Order Stock Details here] end
	private Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();

	// % protected region % [Update the annotation for transferOrderStockDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TRANSFER_ORDER_STOCK_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for transferOrderStockDetailsIds here] end
	private Set<UUID> transferOrderStockDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Vaccination Order Details here] off begin
	@Schema(description = "The Vaccination Order Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Vaccination Order Details here] end
	private Set<VaccinationOrderDetailEntity> vaccinationOrderDetails = new HashSet<>();

	// % protected region % [Update the annotation for vaccinationOrderDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "VACCINATION_ORDER_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for vaccinationOrderDetailsIds here] end
	private Set<UUID> vaccinationOrderDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Warehouse Initial Stock s here] off begin
	@Schema(description = "The Warehouse Initial Stock  entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse Initial Stock s here] end
	private Set<WarehouseInitialStockEntity> warehouseInitialStockS = new HashSet<>();

	// % protected region % [Update the annotation for warehouseInitialStockSIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_INITIAL_STOCK_S_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for warehouseInitialStockSIds here] end
	private Set<UUID> warehouseInitialStockSIds = new HashSet<>();

	// % protected region % [Update the annotation for Warehouse Inventories here] off begin
	@Schema(description = "The Warehouse Inventory entities that are related to this entity.")
	@OneToMany(mappedBy = "stockCatalogue", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse Inventories here] end
	private Set<WarehouseInventoryEntity> warehouseInventories = new HashSet<>();

	// % protected region % [Update the annotation for warehouseInventoriesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_INVENTORIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for warehouseInventoriesIds here] end
	private Set<UUID> warehouseInventoriesIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS Drug Generic PRB here] off begin
	@Schema(description = "The BPJS Drug Generic PRB entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Drug Generic PRB here] end
	private BpjsDrugGenericPRBEntity bpjsDrugGenericPRB;

	// % protected region % [Update the annotation for bpjsDrugGenericPRBId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_DRUG_GENERIC_PRB_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsDrugGenericPRBId here] end
	private UUID bpjsDrugGenericPRBId;

	// % protected region % [Update the annotation for BPJS Pcare DPHO here] off begin
	@Schema(description = "The BPJS Pcare DPHO entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Pcare DPHO here] end
	private BpjsPcareDPHOEntity bpjsPcareDPHO;

	// % protected region % [Update the annotation for bpjsPcareDPHOId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PCARE_DPHO_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsPcareDPHOId here] end
	private UUID bpjsPcareDPHOId;

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

/**
	 * Similar to {@link this#addBatchStockBalancesCatalogue(BatchStockBalanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalanceEntity to be added to this entity
	 */
	public void addBatchStockBalancesCatalogue(@NotNull BatchStockBalanceEntity entity) {
		addBatchStockBalancesCatalogue(entity, true);
	}

	/**
	 * Add a new BatchStockBalanceEntity to batchStockBalancesCatalogue in this entity.
	 *
	 * @param entity the given BatchStockBalanceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBatchStockBalancesCatalogue(@NonNull BatchStockBalanceEntity entity, boolean reverseAdd) {
		if (!this.batchStockBalancesCatalogue.contains(entity)) {
			batchStockBalancesCatalogue.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBatchStockBalancesCatalogue(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be added to this entity
	 */
	public void addBatchStockBalancesCatalogue(@NotNull Collection<BatchStockBalanceEntity> entities) {
		addBatchStockBalancesCatalogue(entities, true);
	}

	/**
	 * Add a new collection of BatchStockBalanceEntity to Batch Stock Balances Catalogue in this entity.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBatchStockBalancesCatalogue(@NonNull Collection<BatchStockBalanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBatchStockBalancesCatalogue(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBatchStockBalancesCatalogue(BatchStockBalanceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalanceEntity to be set to this entity
	 */
	public void removeBatchStockBalancesCatalogue(@NotNull BatchStockBalanceEntity entity) {
		this.removeBatchStockBalancesCatalogue(entity, true);
	}

	/**
	 * Remove the given BatchStockBalanceEntity from this entity.
	 *
	 * @param entity the given BatchStockBalanceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBatchStockBalancesCatalogue(@NotNull BatchStockBalanceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.batchStockBalancesCatalogue.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBatchStockBalancesCatalogue(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be removed to this entity
	 */
	public void removeBatchStockBalancesCatalogue(@NotNull Collection<BatchStockBalanceEntity> entities) {
		this.removeBatchStockBalancesCatalogue(entities, true);
	}

	/**
	 * Remove the given collection of BatchStockBalanceEntity from  to this entity.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBatchStockBalancesCatalogue(@NonNull Collection<BatchStockBalanceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBatchStockBalancesCatalogue(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBatchStockBalancesCatalogue(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to be set to this entity
	 */
	public void setBatchStockBalancesCatalogue(@NotNull Collection<BatchStockBalanceEntity> entities) {
		setBatchStockBalancesCatalogue(entities, true);
	}

	/**
	 * Replace the current entities in Batch Stock Balances Catalogue with the given ones.
	 *
	 * @param entities the given collection of BatchStockBalanceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBatchStockBalancesCatalogue(@NotNull Collection<BatchStockBalanceEntity> entities, boolean reverseAdd) {

		this.unsetBatchStockBalancesCatalogue();
		this.batchStockBalancesCatalogue = new HashSet<>(entities);
		if (reverseAdd) {
			this.batchStockBalancesCatalogue.forEach(batchStockBalancesCatalogueEntity -> batchStockBalancesCatalogueEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBatchStockBalancesCatalogue(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBatchStockBalancesCatalogue() {
		this.unsetBatchStockBalancesCatalogue(true);
	}

	/**
	 * Remove all the entities in Batch Stock Balances Catalogue from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBatchStockBalancesCatalogue(boolean doReverse) {
		if (doReverse) {
			this.batchStockBalancesCatalogue.forEach(batchStockBalancesCatalogueEntity -> batchStockBalancesCatalogueEntity.unsetStockCatalogue(false));
		}
		this.batchStockBalancesCatalogue.clear();
	}

/**
	 * Similar to {@link this#addBatchStockBalances(BatchStockBalancePerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity to be added to this entity
	 */
	public void addBatchStockBalances(@NotNull BatchStockBalancePerDateEntity entity) {
		addBatchStockBalances(entity, true);
	}

	/**
	 * Add a new BatchStockBalancePerDateEntity to batchStockBalances in this entity.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBatchStockBalances(@NonNull BatchStockBalancePerDateEntity entity, boolean reverseAdd) {
		if (!this.batchStockBalances.contains(entity)) {
			batchStockBalances.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBatchStockBalances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be added to this entity
	 */
	public void addBatchStockBalances(@NotNull Collection<BatchStockBalancePerDateEntity> entities) {
		addBatchStockBalances(entities, true);
	}

	/**
	 * Add a new collection of BatchStockBalancePerDateEntity to Batch Stock Balances in this entity.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBatchStockBalances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBatchStockBalances(BatchStockBalancePerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity to be set to this entity
	 */
	public void removeBatchStockBalances(@NotNull BatchStockBalancePerDateEntity entity) {
		this.removeBatchStockBalances(entity, true);
	}

	/**
	 * Remove the given BatchStockBalancePerDateEntity from this entity.
	 *
	 * @param entity the given BatchStockBalancePerDateEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBatchStockBalances(@NotNull BatchStockBalancePerDateEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.batchStockBalances.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBatchStockBalances(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be removed to this entity
	 */
	public void removeBatchStockBalances(@NotNull Collection<BatchStockBalancePerDateEntity> entities) {
		this.removeBatchStockBalances(entities, true);
	}

	/**
	 * Remove the given collection of BatchStockBalancePerDateEntity from  to this entity.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBatchStockBalances(@NonNull Collection<BatchStockBalancePerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBatchStockBalances(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBatchStockBalances(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to be set to this entity
	 */
	public void setBatchStockBalances(@NotNull Collection<BatchStockBalancePerDateEntity> entities) {
		setBatchStockBalances(entities, true);
	}

	/**
	 * Replace the current entities in Batch Stock Balances with the given ones.
	 *
	 * @param entities the given collection of BatchStockBalancePerDateEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBatchStockBalances(@NotNull Collection<BatchStockBalancePerDateEntity> entities, boolean reverseAdd) {

		this.unsetBatchStockBalances();
		this.batchStockBalances = new HashSet<>(entities);
		if (reverseAdd) {
			this.batchStockBalances.forEach(batchStockBalancesEntity -> batchStockBalancesEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBatchStockBalances(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBatchStockBalances() {
		this.unsetBatchStockBalances(true);
	}

	/**
	 * Remove all the entities in Batch Stock Balances from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBatchStockBalances(boolean doReverse) {
		if (doReverse) {
			this.batchStockBalances.forEach(batchStockBalancesEntity -> batchStockBalancesEntity.unsetStockCatalogue(false));
		}
		this.batchStockBalances.clear();
	}

/**
	 * Similar to {@link this#addBatchStockTransactionDetails(BatchStockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity to be added to this entity
	 */
	public void addBatchStockTransactionDetails(@NotNull BatchStockTransactionDetailEntity entity) {
		addBatchStockTransactionDetails(entity, true);
	}

	/**
	 * Add a new BatchStockTransactionDetailEntity to batchStockTransactionDetails in this entity.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBatchStockTransactionDetails(@NonNull BatchStockTransactionDetailEntity entity, boolean reverseAdd) {
		if (!this.batchStockTransactionDetails.contains(entity)) {
			batchStockTransactionDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBatchStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be added to this entity
	 */
	public void addBatchStockTransactionDetails(@NotNull Collection<BatchStockTransactionDetailEntity> entities) {
		addBatchStockTransactionDetails(entities, true);
	}

	/**
	 * Add a new collection of BatchStockTransactionDetailEntity to Batch Stock Transaction Details in this entity.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBatchStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBatchStockTransactionDetails(BatchStockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity to be set to this entity
	 */
	public void removeBatchStockTransactionDetails(@NotNull BatchStockTransactionDetailEntity entity) {
		this.removeBatchStockTransactionDetails(entity, true);
	}

	/**
	 * Remove the given BatchStockTransactionDetailEntity from this entity.
	 *
	 * @param entity the given BatchStockTransactionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBatchStockTransactionDetails(@NotNull BatchStockTransactionDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.batchStockTransactionDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBatchStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be removed to this entity
	 */
	public void removeBatchStockTransactionDetails(@NotNull Collection<BatchStockTransactionDetailEntity> entities) {
		this.removeBatchStockTransactionDetails(entities, true);
	}

	/**
	 * Remove the given collection of BatchStockTransactionDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBatchStockTransactionDetails(@NonNull Collection<BatchStockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBatchStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBatchStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to be set to this entity
	 */
	public void setBatchStockTransactionDetails(@NotNull Collection<BatchStockTransactionDetailEntity> entities) {
		setBatchStockTransactionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Batch Stock Transaction Details with the given ones.
	 *
	 * @param entities the given collection of BatchStockTransactionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBatchStockTransactionDetails(@NotNull Collection<BatchStockTransactionDetailEntity> entities, boolean reverseAdd) {

		this.unsetBatchStockTransactionDetails();
		this.batchStockTransactionDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.batchStockTransactionDetails.forEach(batchStockTransactionDetailsEntity -> batchStockTransactionDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBatchStockTransactionDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBatchStockTransactionDetails() {
		this.unsetBatchStockTransactionDetails(true);
	}

	/**
	 * Remove all the entities in Batch Stock Transaction Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBatchStockTransactionDetails(boolean doReverse) {
		if (doReverse) {
			this.batchStockTransactionDetails.forEach(batchStockTransactionDetailsEntity -> batchStockTransactionDetailsEntity.unsetStockCatalogue(false));
		}
		this.batchStockTransactionDetails.clear();
	}

/**
	 * Similar to {@link this#addCatalogueUOMs(CatalogueUOMEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CatalogueUOMEntity to be added to this entity
	 */
	public void addCatalogueUOMs(@NotNull CatalogueUOMEntity entity) {
		addCatalogueUOMs(entity, true);
	}

	/**
	 * Add a new CatalogueUOMEntity to catalogueUOMs in this entity.
	 *
	 * @param entity the given CatalogueUOMEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCatalogueUOMs(@NonNull CatalogueUOMEntity entity, boolean reverseAdd) {
		if (!this.catalogueUOMs.contains(entity)) {
			catalogueUOMs.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCatalogueUOMs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be added to this entity
	 */
	public void addCatalogueUOMs(@NotNull Collection<CatalogueUOMEntity> entities) {
		addCatalogueUOMs(entities, true);
	}

	/**
	 * Add a new collection of CatalogueUOMEntity to Catalogue UOMs in this entity.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCatalogueUOMs(@NonNull Collection<CatalogueUOMEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCatalogueUOMs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCatalogueUOMs(CatalogueUOMEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CatalogueUOMEntity to be set to this entity
	 */
	public void removeCatalogueUOMs(@NotNull CatalogueUOMEntity entity) {
		this.removeCatalogueUOMs(entity, true);
	}

	/**
	 * Remove the given CatalogueUOMEntity from this entity.
	 *
	 * @param entity the given CatalogueUOMEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCatalogueUOMs(@NotNull CatalogueUOMEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.catalogueUOMs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCatalogueUOMs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be removed to this entity
	 */
	public void removeCatalogueUOMs(@NotNull Collection<CatalogueUOMEntity> entities) {
		this.removeCatalogueUOMs(entities, true);
	}

	/**
	 * Remove the given collection of CatalogueUOMEntity from  to this entity.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCatalogueUOMs(@NonNull Collection<CatalogueUOMEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCatalogueUOMs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCatalogueUOMs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to be set to this entity
	 */
	public void setCatalogueUOMs(@NotNull Collection<CatalogueUOMEntity> entities) {
		setCatalogueUOMs(entities, true);
	}

	/**
	 * Replace the current entities in Catalogue UOMs with the given ones.
	 *
	 * @param entities the given collection of CatalogueUOMEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCatalogueUOMs(@NotNull Collection<CatalogueUOMEntity> entities, boolean reverseAdd) {

		this.unsetCatalogueUOMs();
		this.catalogueUOMs = new HashSet<>(entities);
		if (reverseAdd) {
			this.catalogueUOMs.forEach(catalogueUOMsEntity -> catalogueUOMsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCatalogueUOMs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCatalogueUOMs() {
		this.unsetCatalogueUOMs(true);
	}

	/**
	 * Remove all the entities in Catalogue UOMs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCatalogueUOMs(boolean doReverse) {
		if (doReverse) {
			this.catalogueUOMs.forEach(catalogueUOMsEntity -> catalogueUOMsEntity.unsetStockCatalogue(false));
		}
		this.catalogueUOMs.clear();
	}

/**
	 * Similar to {@link this#addCompoundPrescriptionItems(CompoundPrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be added to this entity
	 */
	public void addCompoundPrescriptionItems(@NotNull CompoundPrescriptionItemEntity entity) {
		addCompoundPrescriptionItems(entity, true);
	}

	/**
	 * Add a new CompoundPrescriptionItemEntity to compoundPrescriptionItems in this entity.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCompoundPrescriptionItems(@NonNull CompoundPrescriptionItemEntity entity, boolean reverseAdd) {
		if (!this.compoundPrescriptionItems.contains(entity)) {
			compoundPrescriptionItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCompoundPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be added to this entity
	 */
	public void addCompoundPrescriptionItems(@NotNull Collection<CompoundPrescriptionItemEntity> entities) {
		addCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Add a new collection of CompoundPrescriptionItemEntity to Compound Prescription Items in this entity.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCompoundPrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCompoundPrescriptionItems(CompoundPrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be set to this entity
	 */
	public void removeCompoundPrescriptionItems(@NotNull CompoundPrescriptionItemEntity entity) {
		this.removeCompoundPrescriptionItems(entity, true);
	}

	/**
	 * Remove the given CompoundPrescriptionItemEntity from this entity.
	 *
	 * @param entity the given CompoundPrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCompoundPrescriptionItems(@NotNull CompoundPrescriptionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.compoundPrescriptionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCompoundPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be removed to this entity
	 */
	public void removeCompoundPrescriptionItems(@NotNull Collection<CompoundPrescriptionItemEntity> entities) {
		this.removeCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Remove the given collection of CompoundPrescriptionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCompoundPrescriptionItems(@NonNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCompoundPrescriptionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCompoundPrescriptionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to be set to this entity
	 */
	public void setCompoundPrescriptionItems(@NotNull Collection<CompoundPrescriptionItemEntity> entities) {
		setCompoundPrescriptionItems(entities, true);
	}

	/**
	 * Replace the current entities in Compound Prescription Items with the given ones.
	 *
	 * @param entities the given collection of CompoundPrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCompoundPrescriptionItems(@NotNull Collection<CompoundPrescriptionItemEntity> entities, boolean reverseAdd) {

		this.unsetCompoundPrescriptionItems();
		this.compoundPrescriptionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.compoundPrescriptionItems.forEach(compoundPrescriptionItemsEntity -> compoundPrescriptionItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCompoundPrescriptionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCompoundPrescriptionItems() {
		this.unsetCompoundPrescriptionItems(true);
	}

	/**
	 * Remove all the entities in Compound Prescription Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCompoundPrescriptionItems(boolean doReverse) {
		if (doReverse) {
			this.compoundPrescriptionItems.forEach(compoundPrescriptionItemsEntity -> compoundPrescriptionItemsEntity.unsetStockCatalogue(false));
		}
		this.compoundPrescriptionItems.clear();
	}

/**
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NotNull GoodsReceiveNoteBatchEntity entity) {
		addGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteBatchEntity to goodsReceiveNoteBatchs in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull GoodsReceiveNoteBatchEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteBatchs.contains(entity)) {
			goodsReceiveNoteBatchs.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteBatchs(@NotNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		addGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteBatchEntity to Goods Receive Note Batchs in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(GoodsReceiveNoteBatchEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NotNull GoodsReceiveNoteBatchEntity entity) {
		this.removeGoodsReceiveNoteBatchs(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteBatchEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteBatchEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NotNull GoodsReceiveNoteBatchEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.goodsReceiveNoteBatchs.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteBatchs(@NotNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		this.removeGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteBatchEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteBatchs(@NonNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteBatchs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteBatchs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteBatchs(@NotNull Collection<GoodsReceiveNoteBatchEntity> entities) {
		setGoodsReceiveNoteBatchs(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Batchs with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteBatchEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteBatchs(@NotNull Collection<GoodsReceiveNoteBatchEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteBatchs();
		this.goodsReceiveNoteBatchs = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteBatchs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteBatchs() {
		this.unsetGoodsReceiveNoteBatchs(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Batchs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteBatchs(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteBatchs.forEach(goodsReceiveNoteBatchsEntity -> goodsReceiveNoteBatchsEntity.unsetStockCatalogue(false));
		}
		this.goodsReceiveNoteBatchs.clear();
	}

/**
	 * Similar to {@link this#addGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NotNull GoodsReceiveNoteItemEntity entity) {
		addGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Add a new GoodsReceiveNoteItemEntity to goodsReceiveNoteItems in this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addGoodsReceiveNoteItems(@NonNull GoodsReceiveNoteItemEntity entity, boolean reverseAdd) {
		if (!this.goodsReceiveNoteItems.contains(entity)) {
			goodsReceiveNoteItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 */
	public void addGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities) {
		addGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Add a new collection of GoodsReceiveNoteItemEntity to Goods Receive Note Items in this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(GoodsReceiveNoteItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NotNull GoodsReceiveNoteItemEntity entity) {
		this.removeGoodsReceiveNoteItems(entity, true);
	}

	/**
	 * Remove the given GoodsReceiveNoteItemEntity from this entity.
	 *
	 * @param entity the given GoodsReceiveNoteItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeGoodsReceiveNoteItems(@NotNull GoodsReceiveNoteItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.goodsReceiveNoteItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 */
	public void removeGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities) {
		this.removeGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Remove the given collection of GoodsReceiveNoteItemEntity from  to this entity.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeGoodsReceiveNoteItems(@NonNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeGoodsReceiveNoteItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setGoodsReceiveNoteItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to be set to this entity
	 */
	public void setGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities) {
		setGoodsReceiveNoteItems(entities, true);
	}

	/**
	 * Replace the current entities in Goods Receive Note Items with the given ones.
	 *
	 * @param entities the given collection of GoodsReceiveNoteItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setGoodsReceiveNoteItems(@NotNull Collection<GoodsReceiveNoteItemEntity> entities, boolean reverseAdd) {

		this.unsetGoodsReceiveNoteItems();
		this.goodsReceiveNoteItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetGoodsReceiveNoteItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetGoodsReceiveNoteItems() {
		this.unsetGoodsReceiveNoteItems(true);
	}

	/**
	 * Remove all the entities in Goods Receive Note Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetGoodsReceiveNoteItems(boolean doReverse) {
		if (doReverse) {
			this.goodsReceiveNoteItems.forEach(goodsReceiveNoteItemsEntity -> goodsReceiveNoteItemsEntity.unsetStockCatalogue(false));
		}
		this.goodsReceiveNoteItems.clear();
	}

/**
	 * Similar to {@link this#addInternalOrderStockDetails(InternalOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be added to this entity
	 */
	public void addInternalOrderStockDetails(@NotNull InternalOrderStockDetailEntity entity) {
		addInternalOrderStockDetails(entity, true);
	}

	/**
	 * Add a new InternalOrderStockDetailEntity to internalOrderStockDetails in this entity.
	 *
	 * @param entity the given InternalOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.internalOrderStockDetails.contains(entity)) {
			internalOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be added to this entity
	 */
	public void addInternalOrderStockDetails(@NotNull Collection<InternalOrderStockDetailEntity> entities) {
		addInternalOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of InternalOrderStockDetailEntity to Internal Order Stock Details in this entity.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInternalOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInternalOrderStockDetails(InternalOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be set to this entity
	 */
	public void removeInternalOrderStockDetails(@NotNull InternalOrderStockDetailEntity entity) {
		this.removeInternalOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given InternalOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInternalOrderStockDetails(@NotNull InternalOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.internalOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be removed to this entity
	 */
	public void removeInternalOrderStockDetails(@NotNull Collection<InternalOrderStockDetailEntity> entities) {
		this.removeInternalOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of InternalOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInternalOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be set to this entity
	 */
	public void setInternalOrderStockDetails(@NotNull Collection<InternalOrderStockDetailEntity> entities) {
		setInternalOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Internal Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInternalOrderStockDetails(@NotNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetInternalOrderStockDetails();
		this.internalOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.internalOrderStockDetails.forEach(internalOrderStockDetailsEntity -> internalOrderStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInternalOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInternalOrderStockDetails() {
		this.unsetInternalOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Internal Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInternalOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.internalOrderStockDetails.forEach(internalOrderStockDetailsEntity -> internalOrderStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.internalOrderStockDetails.clear();
	}

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
				entity.setStockCatalogue(this, false);
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
			entity.unsetStockCatalogue(false);
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
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.setStockCatalogue(this, false));
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
			this.inventoryAdjusmentBatchs.forEach(inventoryAdjusmentBatchsEntity -> inventoryAdjusmentBatchsEntity.unsetStockCatalogue(false));
		}
		this.inventoryAdjusmentBatchs.clear();
	}

/**
	 * Similar to {@link this#addInventoryAdjustmentItems(InventoryAdjustmentItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be added to this entity
	 */
	public void addInventoryAdjustmentItems(@NotNull InventoryAdjustmentItemEntity entity) {
		addInventoryAdjustmentItems(entity, true);
	}

	/**
	 * Add a new InventoryAdjustmentItemEntity to inventoryAdjustmentItems in this entity.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjustmentItems(@NonNull InventoryAdjustmentItemEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjustmentItems.contains(entity)) {
			inventoryAdjustmentItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be added to this entity
	 */
	public void addInventoryAdjustmentItems(@NotNull Collection<InventoryAdjustmentItemEntity> entities) {
		addInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjustmentItemEntity to Inventory Adjustment Items in this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjustmentItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustmentItems(InventoryAdjustmentItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be set to this entity
	 */
	public void removeInventoryAdjustmentItems(@NotNull InventoryAdjustmentItemEntity entity) {
		this.removeInventoryAdjustmentItems(entity, true);
	}

	/**
	 * Remove the given InventoryAdjustmentItemEntity from this entity.
	 *
	 * @param entity the given InventoryAdjustmentItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjustmentItems(@NotNull InventoryAdjustmentItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.inventoryAdjustmentItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be removed to this entity
	 */
	public void removeInventoryAdjustmentItems(@NotNull Collection<InventoryAdjustmentItemEntity> entities) {
		this.removeInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjustmentItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjustmentItems(@NonNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjustmentItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjustmentItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to be set to this entity
	 */
	public void setInventoryAdjustmentItems(@NotNull Collection<InventoryAdjustmentItemEntity> entities) {
		setInventoryAdjustmentItems(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjustment Items with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjustmentItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjustmentItems(@NotNull Collection<InventoryAdjustmentItemEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjustmentItems();
		this.inventoryAdjustmentItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjustmentItems.forEach(inventoryAdjustmentItemsEntity -> inventoryAdjustmentItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustmentItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjustmentItems() {
		this.unsetInventoryAdjustmentItems(true);
	}

	/**
	 * Remove all the entities in Inventory Adjustment Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjustmentItems(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjustmentItems.forEach(inventoryAdjustmentItemsEntity -> inventoryAdjustmentItemsEntity.unsetStockCatalogue(false));
		}
		this.inventoryAdjustmentItems.clear();
	}

/**
	 * Similar to {@link this#addInventoryBatchCorrectionItems(InventoryBatchCorrectionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be added to this entity
	 */
	public void addInventoryBatchCorrectionItems(@NotNull InventoryBatchCorrectionItemEntity entity) {
		addInventoryBatchCorrectionItems(entity, true);
	}

	/**
	 * Add a new InventoryBatchCorrectionItemEntity to inventoryBatchCorrectionItems in this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryBatchCorrectionItems(@NonNull InventoryBatchCorrectionItemEntity entity, boolean reverseAdd) {
		if (!this.inventoryBatchCorrectionItems.contains(entity)) {
			inventoryBatchCorrectionItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be added to this entity
	 */
	public void addInventoryBatchCorrectionItems(@NotNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		addInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Add a new collection of InventoryBatchCorrectionItemEntity to Inventory Batch Correction Items in this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryBatchCorrectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrectionItems(InventoryBatchCorrectionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be set to this entity
	 */
	public void removeInventoryBatchCorrectionItems(@NotNull InventoryBatchCorrectionItemEntity entity) {
		this.removeInventoryBatchCorrectionItems(entity, true);
	}

	/**
	 * Remove the given InventoryBatchCorrectionItemEntity from this entity.
	 *
	 * @param entity the given InventoryBatchCorrectionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryBatchCorrectionItems(@NotNull InventoryBatchCorrectionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.inventoryBatchCorrectionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be removed to this entity
	 */
	public void removeInventoryBatchCorrectionItems(@NotNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		this.removeInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Remove the given collection of InventoryBatchCorrectionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryBatchCorrectionItems(@NonNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryBatchCorrectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryBatchCorrectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to be set to this entity
	 */
	public void setInventoryBatchCorrectionItems(@NotNull Collection<InventoryBatchCorrectionItemEntity> entities) {
		setInventoryBatchCorrectionItems(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Batch Correction Items with the given ones.
	 *
	 * @param entities the given collection of InventoryBatchCorrectionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryBatchCorrectionItems(@NotNull Collection<InventoryBatchCorrectionItemEntity> entities, boolean reverseAdd) {

		this.unsetInventoryBatchCorrectionItems();
		this.inventoryBatchCorrectionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryBatchCorrectionItems.forEach(inventoryBatchCorrectionItemsEntity -> inventoryBatchCorrectionItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryBatchCorrectionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryBatchCorrectionItems() {
		this.unsetInventoryBatchCorrectionItems(true);
	}

	/**
	 * Remove all the entities in Inventory Batch Correction Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryBatchCorrectionItems(boolean doReverse) {
		if (doReverse) {
			this.inventoryBatchCorrectionItems.forEach(inventoryBatchCorrectionItemsEntity -> inventoryBatchCorrectionItemsEntity.unsetStockCatalogue(false));
		}
		this.inventoryBatchCorrectionItems.clear();
	}

/**
	 * Similar to {@link this#addMedicationItems(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be added to this entity
	 */
	public void addMedicationItems(@NotNull MedicationItemEntity entity) {
		addMedicationItems(entity, true);
	}

	/**
	 * Add a new MedicationItemEntity to medicationItems in this entity.
	 *
	 * @param entity the given MedicationItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMedicationItems(@NonNull MedicationItemEntity entity, boolean reverseAdd) {
		if (!this.medicationItems.contains(entity)) {
			medicationItems.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMedicationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationItemEntity to be added to this entity
	 */
	public void addMedicationItems(@NotNull Collection<MedicationItemEntity> entities) {
		addMedicationItems(entities, true);
	}

	/**
	 * Add a new collection of MedicationItemEntity to Medication Items in this entity.
	 *
	 * @param entities the given collection of MedicationItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMedicationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMedicationItems(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be set to this entity
	 */
	public void removeMedicationItems(@NotNull MedicationItemEntity entity) {
		this.removeMedicationItems(entity, true);
	}

	/**
	 * Remove the given MedicationItemEntity from this entity.
	 *
	 * @param entity the given MedicationItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMedicationItems(@NotNull MedicationItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.medicationItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMedicationItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicationItemEntity to be removed to this entity
	 */
	public void removeMedicationItems(@NotNull Collection<MedicationItemEntity> entities) {
		this.removeMedicationItems(entities, true);
	}

	/**
	 * Remove the given collection of MedicationItemEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicationItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMedicationItems(@NonNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMedicationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMedicationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicationItemEntity to be set to this entity
	 */
	public void setMedicationItems(@NotNull Collection<MedicationItemEntity> entities) {
		setMedicationItems(entities, true);
	}

	/**
	 * Replace the current entities in Medication Items with the given ones.
	 *
	 * @param entities the given collection of MedicationItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMedicationItems(@NotNull Collection<MedicationItemEntity> entities, boolean reverseAdd) {

		this.unsetMedicationItems();
		this.medicationItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMedicationItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMedicationItems() {
		this.unsetMedicationItems(true);
	}

	/**
	 * Remove all the entities in Medication Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMedicationItems(boolean doReverse) {
		if (doReverse) {
			this.medicationItems.forEach(medicationItemsEntity -> medicationItemsEntity.unsetStockCatalogue(false));
		}
		this.medicationItems.clear();
	}

/**
	 * Similar to {@link this#addPrescriptionItem(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be added to this entity
	 */
	public void addPrescriptionItem(@NotNull PrescriptionItemEntity entity) {
		addPrescriptionItem(entity, true);
	}

	/**
	 * Add a new PrescriptionItemEntity to prescriptionItem in this entity.
	 *
	 * @param entity the given PrescriptionItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPrescriptionItem(@NonNull PrescriptionItemEntity entity, boolean reverseAdd) {
		if (!this.prescriptionItem.contains(entity)) {
			prescriptionItem.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogueId(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPrescriptionItem(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 */
	public void addPrescriptionItem(@NotNull Collection<PrescriptionItemEntity> entities) {
		addPrescriptionItem(entities, true);
	}

	/**
	 * Add a new collection of PrescriptionItemEntity to Prescription Item in this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPrescriptionItem(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPrescriptionItem(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePrescriptionItem(PrescriptionItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PrescriptionItemEntity to be set to this entity
	 */
	public void removePrescriptionItem(@NotNull PrescriptionItemEntity entity) {
		this.removePrescriptionItem(entity, true);
	}

	/**
	 * Remove the given PrescriptionItemEntity from this entity.
	 *
	 * @param entity the given PrescriptionItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePrescriptionItem(@NotNull PrescriptionItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogueId(false);
		}
		this.prescriptionItem.remove(entity);
	}

	/**
	 * Similar to {@link this#removePrescriptionItem(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 */
	public void removePrescriptionItem(@NotNull Collection<PrescriptionItemEntity> entities) {
		this.removePrescriptionItem(entities, true);
	}

	/**
	 * Remove the given collection of PrescriptionItemEntity from  to this entity.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePrescriptionItem(@NonNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePrescriptionItem(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPrescriptionItem(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to be set to this entity
	 */
	public void setPrescriptionItem(@NotNull Collection<PrescriptionItemEntity> entities) {
		setPrescriptionItem(entities, true);
	}

	/**
	 * Replace the current entities in Prescription Item with the given ones.
	 *
	 * @param entities the given collection of PrescriptionItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPrescriptionItem(@NotNull Collection<PrescriptionItemEntity> entities, boolean reverseAdd) {

		this.unsetPrescriptionItem();
		this.prescriptionItem = new HashSet<>(entities);
		if (reverseAdd) {
			this.prescriptionItem.forEach(prescriptionItemEntity -> prescriptionItemEntity.setStockCatalogueId(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPrescriptionItem(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPrescriptionItem() {
		this.unsetPrescriptionItem(true);
	}

	/**
	 * Remove all the entities in Prescription Item from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPrescriptionItem(boolean doReverse) {
		if (doReverse) {
			this.prescriptionItem.forEach(prescriptionItemEntity -> prescriptionItemEntity.unsetStockCatalogueId(false));
		}
		this.prescriptionItem.clear();
	}

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
				entity.setStockCatalogue(this, false);
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
			entity.unsetStockCatalogue(false);
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
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.setStockCatalogue(this, false));
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
			this.purchaseOrderStockDetails.forEach(purchaseOrderStockDetailsEntity -> purchaseOrderStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.purchaseOrderStockDetails.clear();
	}

/**
	 * Similar to {@link this#addPurchaseRequisitionStockDetails(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be added to this entity
	 */
	public void addPurchaseRequisitionStockDetails(@NotNull PurchaseRequisitionStockDetailEntity entity) {
		addPurchaseRequisitionStockDetails(entity, true);
	}

	/**
	 * Add a new PurchaseRequisitionStockDetailEntity to purchaseRequisitionStockDetails in this entity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull PurchaseRequisitionStockDetailEntity entity, boolean reverseAdd) {
		if (!this.purchaseRequisitionStockDetails.contains(entity)) {
			purchaseRequisitionStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be added to this entity
	 */
	public void addPurchaseRequisitionStockDetails(@NotNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		addPurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Add a new collection of PurchaseRequisitionStockDetailEntity to Purchase Requisition Stock Details in this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPurchaseRequisitionStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitionStockDetails(PurchaseRequisitionStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void removePurchaseRequisitionStockDetails(@NotNull PurchaseRequisitionStockDetailEntity entity) {
		this.removePurchaseRequisitionStockDetails(entity, true);
	}

	/**
	 * Remove the given PurchaseRequisitionStockDetailEntity from this entity.
	 *
	 * @param entity the given PurchaseRequisitionStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePurchaseRequisitionStockDetails(@NotNull PurchaseRequisitionStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.purchaseRequisitionStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removePurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be removed to this entity
	 */
	public void removePurchaseRequisitionStockDetails(@NotNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		this.removePurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of PurchaseRequisitionStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePurchaseRequisitionStockDetails(@NonNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePurchaseRequisitionStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPurchaseRequisitionStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to be set to this entity
	 */
	public void setPurchaseRequisitionStockDetails(@NotNull Collection<PurchaseRequisitionStockDetailEntity> entities) {
		setPurchaseRequisitionStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Purchase Requisition Stock Details with the given ones.
	 *
	 * @param entities the given collection of PurchaseRequisitionStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPurchaseRequisitionStockDetails(@NotNull Collection<PurchaseRequisitionStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetPurchaseRequisitionStockDetails();
		this.purchaseRequisitionStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.purchaseRequisitionStockDetails.forEach(purchaseRequisitionStockDetailsEntity -> purchaseRequisitionStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPurchaseRequisitionStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPurchaseRequisitionStockDetails() {
		this.unsetPurchaseRequisitionStockDetails(true);
	}

	/**
	 * Remove all the entities in Purchase Requisition Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPurchaseRequisitionStockDetails(boolean doReverse) {
		if (doReverse) {
			this.purchaseRequisitionStockDetails.forEach(purchaseRequisitionStockDetailsEntity -> purchaseRequisitionStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.purchaseRequisitionStockDetails.clear();
	}

/**
	 * Similar to {@link this#addRetailPharmacyStockDetails(RetailPharmacyStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be added to this entity
	 */
	public void addRetailPharmacyStockDetails(@NotNull RetailPharmacyStockDetailEntity entity) {
		addRetailPharmacyStockDetails(entity, true);
	}

	/**
	 * Add a new RetailPharmacyStockDetailEntity to retailPharmacyStockDetails in this entity.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRetailPharmacyStockDetails(@NonNull RetailPharmacyStockDetailEntity entity, boolean reverseAdd) {
		if (!this.retailPharmacyStockDetails.contains(entity)) {
			retailPharmacyStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRetailPharmacyStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be added to this entity
	 */
	public void addRetailPharmacyStockDetails(@NotNull Collection<RetailPharmacyStockDetailEntity> entities) {
		addRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Add a new collection of RetailPharmacyStockDetailEntity to Retail Pharmacy Stock Details in this entity.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRetailPharmacyStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRetailPharmacyStockDetails(RetailPharmacyStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be set to this entity
	 */
	public void removeRetailPharmacyStockDetails(@NotNull RetailPharmacyStockDetailEntity entity) {
		this.removeRetailPharmacyStockDetails(entity, true);
	}

	/**
	 * Remove the given RetailPharmacyStockDetailEntity from this entity.
	 *
	 * @param entity the given RetailPharmacyStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRetailPharmacyStockDetails(@NotNull RetailPharmacyStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.retailPharmacyStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRetailPharmacyStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be removed to this entity
	 */
	public void removeRetailPharmacyStockDetails(@NotNull Collection<RetailPharmacyStockDetailEntity> entities) {
		this.removeRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of RetailPharmacyStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRetailPharmacyStockDetails(@NonNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRetailPharmacyStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRetailPharmacyStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to be set to this entity
	 */
	public void setRetailPharmacyStockDetails(@NotNull Collection<RetailPharmacyStockDetailEntity> entities) {
		setRetailPharmacyStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Retail Pharmacy Stock Details with the given ones.
	 *
	 * @param entities the given collection of RetailPharmacyStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRetailPharmacyStockDetails(@NotNull Collection<RetailPharmacyStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetRetailPharmacyStockDetails();
		this.retailPharmacyStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.retailPharmacyStockDetails.forEach(retailPharmacyStockDetailsEntity -> retailPharmacyStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRetailPharmacyStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRetailPharmacyStockDetails() {
		this.unsetRetailPharmacyStockDetails(true);
	}

	/**
	 * Remove all the entities in Retail Pharmacy Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRetailPharmacyStockDetails(boolean doReverse) {
		if (doReverse) {
			this.retailPharmacyStockDetails.forEach(retailPharmacyStockDetailsEntity -> retailPharmacyStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.retailPharmacyStockDetails.clear();
	}

/**
	 * Similar to {@link this#addReturnSupplierStockDetails(ReturnSupplierStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be added to this entity
	 */
	public void addReturnSupplierStockDetails(@NotNull ReturnSupplierStockDetailEntity entity) {
		addReturnSupplierStockDetails(entity, true);
	}

	/**
	 * Add a new ReturnSupplierStockDetailEntity to returnSupplierStockDetails in this entity.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addReturnSupplierStockDetails(@NonNull ReturnSupplierStockDetailEntity entity, boolean reverseAdd) {
		if (!this.returnSupplierStockDetails.contains(entity)) {
			returnSupplierStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be added to this entity
	 */
	public void addReturnSupplierStockDetails(@NotNull Collection<ReturnSupplierStockDetailEntity> entities) {
		addReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Add a new collection of ReturnSupplierStockDetailEntity to Return Supplier Stock Details in this entity.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addReturnSupplierStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeReturnSupplierStockDetails(ReturnSupplierStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be set to this entity
	 */
	public void removeReturnSupplierStockDetails(@NotNull ReturnSupplierStockDetailEntity entity) {
		this.removeReturnSupplierStockDetails(entity, true);
	}

	/**
	 * Remove the given ReturnSupplierStockDetailEntity from this entity.
	 *
	 * @param entity the given ReturnSupplierStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeReturnSupplierStockDetails(@NotNull ReturnSupplierStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.returnSupplierStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be removed to this entity
	 */
	public void removeReturnSupplierStockDetails(@NotNull Collection<ReturnSupplierStockDetailEntity> entities) {
		this.removeReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of ReturnSupplierStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeReturnSupplierStockDetails(@NonNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeReturnSupplierStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setReturnSupplierStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to be set to this entity
	 */
	public void setReturnSupplierStockDetails(@NotNull Collection<ReturnSupplierStockDetailEntity> entities) {
		setReturnSupplierStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Return Supplier Stock Details with the given ones.
	 *
	 * @param entities the given collection of ReturnSupplierStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setReturnSupplierStockDetails(@NotNull Collection<ReturnSupplierStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetReturnSupplierStockDetails();
		this.returnSupplierStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.returnSupplierStockDetails.forEach(returnSupplierStockDetailsEntity -> returnSupplierStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetReturnSupplierStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetReturnSupplierStockDetails() {
		this.unsetReturnSupplierStockDetails(true);
	}

	/**
	 * Remove all the entities in Return Supplier Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetReturnSupplierStockDetails(boolean doReverse) {
		if (doReverse) {
			this.returnSupplierStockDetails.forEach(returnSupplierStockDetailsEntity -> returnSupplierStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.returnSupplierStockDetails.clear();
	}

	/**
	 * Similar to {@link this#setStockCatalogueMedical(CatalogueMedicalEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogueMedical(@NotNull CatalogueMedicalEntity entity) {
		setStockCatalogueMedical(entity, true);
	}

	/**
	 * Set or update stockCatalogueMedical with the given CatalogueMedicalEntity.
	 *
	 * @param entity the StockCatalogueEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogueMedical(@NotNull CatalogueMedicalEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueMedical here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueMedical here] end

		if (sameAsFormer(this.stockCatalogueMedical, entity)) {
			return;
		}

		if (this.stockCatalogueMedical != null) {
			this.stockCatalogueMedical.unsetStockCatalogue();
		}

		this.stockCatalogueMedical = entity;

		if (reverseAdd) {
			this.stockCatalogueMedical.setStockCatalogue(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueMedical outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueMedical outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogueMedical(boolean)} but default to true.
	 */
	public void unsetStockCatalogueMedical() {
		this.unsetStockCatalogueMedical(true);
	}

	/**
	 * Remove the CatalogueMedicalEntity in Stock Catalogue Medical  from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogueMedical(boolean reverse) {
		if (reverse && this.stockCatalogueMedical != null) {
			this.stockCatalogueMedical.unsetStockCatalogue(false);
		}
		this.stockCatalogueMedical = null;
	}

	/**
	 * Similar to {@link this#setStockCatalogueNonMedical(CatalogueNonMedicalEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogueNonMedical(@NotNull CatalogueNonMedicalEntity entity) {
		setStockCatalogueNonMedical(entity, true);
	}

	/**
	 * Set or update stockCatalogueNonMedical with the given CatalogueNonMedicalEntity.
	 *
	 * @param entity the StockCatalogueEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogueNonMedical(@NotNull CatalogueNonMedicalEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueNonMedical here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogueNonMedical here] end

		if (sameAsFormer(this.stockCatalogueNonMedical, entity)) {
			return;
		}

		if (this.stockCatalogueNonMedical != null) {
			this.stockCatalogueNonMedical.unsetStockCatalogue();
		}

		this.stockCatalogueNonMedical = entity;

		if (reverseAdd) {
			this.stockCatalogueNonMedical.setStockCatalogue(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueNonMedical outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogueNonMedical outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogueNonMedical(boolean)} but default to true.
	 */
	public void unsetStockCatalogueNonMedical() {
		this.unsetStockCatalogueNonMedical(true);
	}

	/**
	 * Remove the CatalogueNonMedicalEntity in Stock Catalogue Non Medical from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogueNonMedical(boolean reverse) {
		if (reverse && this.stockCatalogueNonMedical != null) {
			this.stockCatalogueNonMedical.unsetStockCatalogue(false);
		}
		this.stockCatalogueNonMedical = null;
	}

/**
	 * Similar to {@link this#addStockControls(StockControlEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockControlEntity to be added to this entity
	 */
	public void addStockControls(@NotNull StockControlEntity entity) {
		addStockControls(entity, true);
	}

	/**
	 * Add a new StockControlEntity to stockControls in this entity.
	 *
	 * @param entity the given StockControlEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockControls(@NonNull StockControlEntity entity, boolean reverseAdd) {
		if (!this.stockControls.contains(entity)) {
			stockControls.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockControls(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockControlEntity to be added to this entity
	 */
	public void addStockControls(@NotNull Collection<StockControlEntity> entities) {
		addStockControls(entities, true);
	}

	/**
	 * Add a new collection of StockControlEntity to Stock Controls in this entity.
	 *
	 * @param entities the given collection of StockControlEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockControls(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockControls(StockControlEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockControlEntity to be set to this entity
	 */
	public void removeStockControls(@NotNull StockControlEntity entity) {
		this.removeStockControls(entity, true);
	}

	/**
	 * Remove the given StockControlEntity from this entity.
	 *
	 * @param entity the given StockControlEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockControls(@NotNull StockControlEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.stockControls.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockControls(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockControlEntity to be removed to this entity
	 */
	public void removeStockControls(@NotNull Collection<StockControlEntity> entities) {
		this.removeStockControls(entities, true);
	}

	/**
	 * Remove the given collection of StockControlEntity from  to this entity.
	 *
	 * @param entities the given collection of StockControlEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockControls(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockControls(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockControlEntity to be set to this entity
	 */
	public void setStockControls(@NotNull Collection<StockControlEntity> entities) {
		setStockControls(entities, true);
	}

	/**
	 * Replace the current entities in Stock Controls with the given ones.
	 *
	 * @param entities the given collection of StockControlEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockControls(@NotNull Collection<StockControlEntity> entities, boolean reverseAdd) {

		this.unsetStockControls();
		this.stockControls = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockControls.forEach(stockControlsEntity -> stockControlsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockControls(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockControls() {
		this.unsetStockControls(true);
	}

	/**
	 * Remove all the entities in Stock Controls from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockControls(boolean doReverse) {
		if (doReverse) {
			this.stockControls.forEach(stockControlsEntity -> stockControlsEntity.unsetStockCatalogue(false));
		}
		this.stockControls.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NotNull StockTransactionDetailEntity entity) {
		addStockTransactionDetails(entity, true);
	}

	/**
	 * Add a new StockTransactionDetailEntity to stockTransactionDetails in this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionDetails(@NonNull StockTransactionDetailEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionDetails.contains(entity)) {
			stockTransactionDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NotNull Collection<StockTransactionDetailEntity> entities) {
		addStockTransactionDetails(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionDetailEntity to Stock Transaction Details in this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be set to this entity
	 */
	public void removeStockTransactionDetails(@NotNull StockTransactionDetailEntity entity) {
		this.removeStockTransactionDetails(entity, true);
	}

	/**
	 * Remove the given StockTransactionDetailEntity from this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionDetails(@NotNull StockTransactionDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.stockTransactionDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 */
	public void removeStockTransactionDetails(@NotNull Collection<StockTransactionDetailEntity> entities) {
		this.removeStockTransactionDetails(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be set to this entity
	 */
	public void setStockTransactionDetails(@NotNull Collection<StockTransactionDetailEntity> entities) {
		setStockTransactionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Details with the given ones.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionDetails(@NotNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionDetails();
		this.stockTransactionDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionDetails() {
		this.unsetStockTransactionDetails(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionDetails(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.unsetStockCatalogue(false));
		}
		this.stockTransactionDetails.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NotNull StockTransactionPerDateTypeEntity entity) {
		addStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Add a new StockTransactionPerDateTypeEntity to stockTransactionPerDateTypes in this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionPerDateTypes.contains(entity)) {
			stockTransactionPerDateTypes.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NotNull Collection<StockTransactionPerDateTypeEntity> entities) {
		addStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionPerDateTypeEntity to Stock Transaction Per Date Types in this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NotNull StockTransactionPerDateTypeEntity entity) {
		this.removeStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Remove the given StockTransactionPerDateTypeEntity from this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionPerDateTypes(@NotNull StockTransactionPerDateTypeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.stockTransactionPerDateTypes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NotNull Collection<StockTransactionPerDateTypeEntity> entities) {
		this.removeStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionPerDateTypeEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void setStockTransactionPerDateTypes(@NotNull Collection<StockTransactionPerDateTypeEntity> entities) {
		setStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Per Date Types with the given ones.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionPerDateTypes(@NotNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionPerDateTypes();
		this.stockTransactionPerDateTypes = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionPerDateTypes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionPerDateTypes() {
		this.unsetStockTransactionPerDateTypes(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Per Date Types from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionPerDateTypes(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.unsetStockCatalogue(false));
		}
		this.stockTransactionPerDateTypes.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionPerDates(StockTransactionPerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateEntity to be added to this entity
	 */
	public void addStockTransactionPerDates(@NotNull StockTransactionPerDateEntity entity) {
		addStockTransactionPerDates(entity, true);
	}

	/**
	 * Add a new StockTransactionPerDateEntity to stockTransactionPerDates in this entity.
	 *
	 * @param entity the given StockTransactionPerDateEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionPerDates(@NonNull StockTransactionPerDateEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionPerDates.contains(entity)) {
			stockTransactionPerDates.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionPerDates(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be added to this entity
	 */
	public void addStockTransactionPerDates(@NotNull Collection<StockTransactionPerDateEntity> entities) {
		addStockTransactionPerDates(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionPerDateEntity to Stock Transaction Per Dates in this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionPerDates(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDates(StockTransactionPerDateEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateEntity to be set to this entity
	 */
	public void removeStockTransactionPerDates(@NotNull StockTransactionPerDateEntity entity) {
		this.removeStockTransactionPerDates(entity, true);
	}

	/**
	 * Remove the given StockTransactionPerDateEntity from this entity.
	 *
	 * @param entity the given StockTransactionPerDateEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionPerDates(@NotNull StockTransactionPerDateEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.stockTransactionPerDates.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDates(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be removed to this entity
	 */
	public void removeStockTransactionPerDates(@NotNull Collection<StockTransactionPerDateEntity> entities) {
		this.removeStockTransactionPerDates(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionPerDateEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionPerDates(@NonNull Collection<StockTransactionPerDateEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionPerDates(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionPerDates(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to be set to this entity
	 */
	public void setStockTransactionPerDates(@NotNull Collection<StockTransactionPerDateEntity> entities) {
		setStockTransactionPerDates(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Per Dates with the given ones.
	 *
	 * @param entities the given collection of StockTransactionPerDateEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionPerDates(@NotNull Collection<StockTransactionPerDateEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionPerDates();
		this.stockTransactionPerDates = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionPerDates.forEach(stockTransactionPerDatesEntity -> stockTransactionPerDatesEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionPerDates(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionPerDates() {
		this.unsetStockTransactionPerDates(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Per Dates from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionPerDates(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionPerDates.forEach(stockTransactionPerDatesEntity -> stockTransactionPerDatesEntity.unsetStockCatalogue(false));
		}
		this.stockTransactionPerDates.clear();
	}

/**
	 * Similar to {@link this#addSupplierProductDetails(SupplierProductDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierProductDetailEntity to be added to this entity
	 */
	public void addSupplierProductDetails(@NotNull SupplierProductDetailEntity entity) {
		addSupplierProductDetails(entity, true);
	}

	/**
	 * Add a new SupplierProductDetailEntity to supplierProductDetails in this entity.
	 *
	 * @param entity the given SupplierProductDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSupplierProductDetails(@NonNull SupplierProductDetailEntity entity, boolean reverseAdd) {
		if (!this.supplierProductDetails.contains(entity)) {
			supplierProductDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be added to this entity
	 */
	public void addSupplierProductDetails(@NotNull Collection<SupplierProductDetailEntity> entities) {
		addSupplierProductDetails(entities, true);
	}

	/**
	 * Add a new collection of SupplierProductDetailEntity to Supplier Product Details in this entity.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSupplierProductDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSupplierProductDetails(SupplierProductDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierProductDetailEntity to be set to this entity
	 */
	public void removeSupplierProductDetails(@NotNull SupplierProductDetailEntity entity) {
		this.removeSupplierProductDetails(entity, true);
	}

	/**
	 * Remove the given SupplierProductDetailEntity from this entity.
	 *
	 * @param entity the given SupplierProductDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSupplierProductDetails(@NotNull SupplierProductDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.supplierProductDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be removed to this entity
	 */
	public void removeSupplierProductDetails(@NotNull Collection<SupplierProductDetailEntity> entities) {
		this.removeSupplierProductDetails(entities, true);
	}

	/**
	 * Remove the given collection of SupplierProductDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSupplierProductDetails(@NonNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSupplierProductDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSupplierProductDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to be set to this entity
	 */
	public void setSupplierProductDetails(@NotNull Collection<SupplierProductDetailEntity> entities) {
		setSupplierProductDetails(entities, true);
	}

	/**
	 * Replace the current entities in Supplier Product Details with the given ones.
	 *
	 * @param entities the given collection of SupplierProductDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSupplierProductDetails(@NotNull Collection<SupplierProductDetailEntity> entities, boolean reverseAdd) {

		this.unsetSupplierProductDetails();
		this.supplierProductDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.supplierProductDetails.forEach(supplierProductDetailsEntity -> supplierProductDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSupplierProductDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSupplierProductDetails() {
		this.unsetSupplierProductDetails(true);
	}

	/**
	 * Remove all the entities in Supplier Product Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSupplierProductDetails(boolean doReverse) {
		if (doReverse) {
			this.supplierProductDetails.forEach(supplierProductDetailsEntity -> supplierProductDetailsEntity.unsetStockCatalogue(false));
		}
		this.supplierProductDetails.clear();
	}

/**
	 * Similar to {@link this#addTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NotNull TransferOrderStockDetailEntity entity) {
		addTransferOrderStockDetails(entity, true);
	}

	/**
	 * Add a new TransferOrderStockDetailEntity to transferOrderStockDetails in this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.transferOrderStockDetails.contains(entity)) {
			transferOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities) {
		addTransferOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of TransferOrderStockDetailEntity to Transfer Order Stock Details in this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be set to this entity
	 */
	public void removeTransferOrderStockDetails(@NotNull TransferOrderStockDetailEntity entity) {
		this.removeTransferOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given TransferOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTransferOrderStockDetails(@NotNull TransferOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.transferOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 */
	public void removeTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities) {
		this.removeTransferOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of TransferOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be set to this entity
	 */
	public void setTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities) {
		setTransferOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Transfer Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTransferOrderStockDetails(@NotNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetTransferOrderStockDetails();
		this.transferOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTransferOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTransferOrderStockDetails() {
		this.unsetTransferOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Transfer Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTransferOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.unsetStockCatalogue(false));
		}
		this.transferOrderStockDetails.clear();
	}

/**
	 * Similar to {@link this#addVaccinationOrderDetails(VaccinationOrderDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be added to this entity
	 */
	public void addVaccinationOrderDetails(@NotNull VaccinationOrderDetailEntity entity) {
		addVaccinationOrderDetails(entity, true);
	}

	/**
	 * Add a new VaccinationOrderDetailEntity to vaccinationOrderDetails in this entity.
	 *
	 * @param entity the given VaccinationOrderDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVaccinationOrderDetails(@NonNull VaccinationOrderDetailEntity entity, boolean reverseAdd) {
		if (!this.vaccinationOrderDetails.contains(entity)) {
			vaccinationOrderDetails.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be added to this entity
	 */
	public void addVaccinationOrderDetails(@NotNull Collection<VaccinationOrderDetailEntity> entities) {
		addVaccinationOrderDetails(entities, true);
	}

	/**
	 * Add a new collection of VaccinationOrderDetailEntity to Vaccination Order Details in this entity.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVaccinationOrderDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVaccinationOrderDetails(VaccinationOrderDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be set to this entity
	 */
	public void removeVaccinationOrderDetails(@NotNull VaccinationOrderDetailEntity entity) {
		this.removeVaccinationOrderDetails(entity, true);
	}

	/**
	 * Remove the given VaccinationOrderDetailEntity from this entity.
	 *
	 * @param entity the given VaccinationOrderDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVaccinationOrderDetails(@NotNull VaccinationOrderDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.vaccinationOrderDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be removed to this entity
	 */
	public void removeVaccinationOrderDetails(@NotNull Collection<VaccinationOrderDetailEntity> entities) {
		this.removeVaccinationOrderDetails(entities, true);
	}

	/**
	 * Remove the given collection of VaccinationOrderDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVaccinationOrderDetails(@NonNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVaccinationOrderDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVaccinationOrderDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to be set to this entity
	 */
	public void setVaccinationOrderDetails(@NotNull Collection<VaccinationOrderDetailEntity> entities) {
		setVaccinationOrderDetails(entities, true);
	}

	/**
	 * Replace the current entities in Vaccination Order Details with the given ones.
	 *
	 * @param entities the given collection of VaccinationOrderDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVaccinationOrderDetails(@NotNull Collection<VaccinationOrderDetailEntity> entities, boolean reverseAdd) {

		this.unsetVaccinationOrderDetails();
		this.vaccinationOrderDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.vaccinationOrderDetails.forEach(vaccinationOrderDetailsEntity -> vaccinationOrderDetailsEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVaccinationOrderDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVaccinationOrderDetails() {
		this.unsetVaccinationOrderDetails(true);
	}

	/**
	 * Remove all the entities in Vaccination Order Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVaccinationOrderDetails(boolean doReverse) {
		if (doReverse) {
			this.vaccinationOrderDetails.forEach(vaccinationOrderDetailsEntity -> vaccinationOrderDetailsEntity.unsetStockCatalogue(false));
		}
		this.vaccinationOrderDetails.clear();
	}

/**
	 * Similar to {@link this#addWarehouseInitialStockS(WarehouseInitialStockEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be added to this entity
	 */
	public void addWarehouseInitialStockS(@NotNull WarehouseInitialStockEntity entity) {
		addWarehouseInitialStockS(entity, true);
	}

	/**
	 * Add a new WarehouseInitialStockEntity to warehouseInitialStockS in this entity.
	 *
	 * @param entity the given WarehouseInitialStockEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity, boolean reverseAdd) {
		if (!this.warehouseInitialStockS.contains(entity)) {
			warehouseInitialStockS.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be added to this entity
	 */
	public void addWarehouseInitialStockS(@NotNull Collection<WarehouseInitialStockEntity> entities) {
		addWarehouseInitialStockS(entities, true);
	}

	/**
	 * Add a new collection of WarehouseInitialStockEntity to Warehouse Initial Stock s in this entity.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addWarehouseInitialStockS(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeWarehouseInitialStockS(WarehouseInitialStockEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be set to this entity
	 */
	public void removeWarehouseInitialStockS(@NotNull WarehouseInitialStockEntity entity) {
		this.removeWarehouseInitialStockS(entity, true);
	}

	/**
	 * Remove the given WarehouseInitialStockEntity from this entity.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeWarehouseInitialStockS(@NotNull WarehouseInitialStockEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.warehouseInitialStockS.remove(entity);
	}

	/**
	 * Similar to {@link this#removeWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be removed to this entity
	 */
	public void removeWarehouseInitialStockS(@NotNull Collection<WarehouseInitialStockEntity> entities) {
		this.removeWarehouseInitialStockS(entities, true);
	}

	/**
	 * Remove the given collection of WarehouseInitialStockEntity from  to this entity.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeWarehouseInitialStockS(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be set to this entity
	 */
	public void setWarehouseInitialStockS(@NotNull Collection<WarehouseInitialStockEntity> entities) {
		setWarehouseInitialStockS(entities, true);
	}

	/**
	 * Replace the current entities in Warehouse Initial Stock s with the given ones.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setWarehouseInitialStockS(@NotNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {

		this.unsetWarehouseInitialStockS();
		this.warehouseInitialStockS = new HashSet<>(entities);
		if (reverseAdd) {
			this.warehouseInitialStockS.forEach(warehouseInitialStockSEntity -> warehouseInitialStockSEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetWarehouseInitialStockS(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetWarehouseInitialStockS() {
		this.unsetWarehouseInitialStockS(true);
	}

	/**
	 * Remove all the entities in Warehouse Initial Stock s from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetWarehouseInitialStockS(boolean doReverse) {
		if (doReverse) {
			this.warehouseInitialStockS.forEach(warehouseInitialStockSEntity -> warehouseInitialStockSEntity.unsetStockCatalogue(false));
		}
		this.warehouseInitialStockS.clear();
	}

/**
	 * Similar to {@link this#addWarehouseInventories(WarehouseInventoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInventoryEntity to be added to this entity
	 */
	public void addWarehouseInventories(@NotNull WarehouseInventoryEntity entity) {
		addWarehouseInventories(entity, true);
	}

	/**
	 * Add a new WarehouseInventoryEntity to warehouseInventories in this entity.
	 *
	 * @param entity the given WarehouseInventoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addWarehouseInventories(@NonNull WarehouseInventoryEntity entity, boolean reverseAdd) {
		if (!this.warehouseInventories.contains(entity)) {
			warehouseInventories.add(entity);
			if (reverseAdd) {
				entity.setStockCatalogue(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be added to this entity
	 */
	public void addWarehouseInventories(@NotNull Collection<WarehouseInventoryEntity> entities) {
		addWarehouseInventories(entities, true);
	}

	/**
	 * Add a new collection of WarehouseInventoryEntity to Warehouse Inventories in this entity.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addWarehouseInventories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeWarehouseInventories(WarehouseInventoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInventoryEntity to be set to this entity
	 */
	public void removeWarehouseInventories(@NotNull WarehouseInventoryEntity entity) {
		this.removeWarehouseInventories(entity, true);
	}

	/**
	 * Remove the given WarehouseInventoryEntity from this entity.
	 *
	 * @param entity the given WarehouseInventoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeWarehouseInventories(@NotNull WarehouseInventoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetStockCatalogue(false);
		}
		this.warehouseInventories.remove(entity);
	}

	/**
	 * Similar to {@link this#removeWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be removed to this entity
	 */
	public void removeWarehouseInventories(@NotNull Collection<WarehouseInventoryEntity> entities) {
		this.removeWarehouseInventories(entities, true);
	}

	/**
	 * Remove the given collection of WarehouseInventoryEntity from  to this entity.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeWarehouseInventories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be set to this entity
	 */
	public void setWarehouseInventories(@NotNull Collection<WarehouseInventoryEntity> entities) {
		setWarehouseInventories(entities, true);
	}

	/**
	 * Replace the current entities in Warehouse Inventories with the given ones.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setWarehouseInventories(@NotNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {

		this.unsetWarehouseInventories();
		this.warehouseInventories = new HashSet<>(entities);
		if (reverseAdd) {
			this.warehouseInventories.forEach(warehouseInventoriesEntity -> warehouseInventoriesEntity.setStockCatalogue(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetWarehouseInventories(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetWarehouseInventories() {
		this.unsetWarehouseInventories(true);
	}

	/**
	 * Remove all the entities in Warehouse Inventories from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetWarehouseInventories(boolean doReverse) {
		if (doReverse) {
			this.warehouseInventories.forEach(warehouseInventoriesEntity -> warehouseInventoriesEntity.unsetStockCatalogue(false));
		}
		this.warehouseInventories.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBpjsDrugGenericPRB(BpjsDrugGenericPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set to this entity
	 */
	public void setBpjsDrugGenericPRB(BpjsDrugGenericPRBEntity entity) {
		setBpjsDrugGenericPRB(entity, true);
	}

	/**
	 * Set or update the bpjsDrugGenericPRB in this entity with single BpjsDrugGenericPRBEntity.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set or updated to bpjsDrugGenericPRB
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDrugGenericPRB(BpjsDrugGenericPRBEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDrugGenericPRB here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDrugGenericPRB here] end

		if (sameAsFormer(this.bpjsDrugGenericPRB, entity)) {
			return;
		}

		if (this.bpjsDrugGenericPRB != null) {
			this.bpjsDrugGenericPRB.unsetStockCatalogue(false);
		}

		this.bpjsDrugGenericPRB = entity;
		if (reverseAdd) {
			this.bpjsDrugGenericPRB.setStockCatalogue(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDrugGenericPRB incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDrugGenericPRB incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDrugGenericPRB(boolean)} but default to true.
	 */
	public void unsetBpjsDrugGenericPRB() {
		this.unsetBpjsDrugGenericPRB(true);
	}

	/**
	 * Remove the BpjsDrugGenericPRBEntity of bpjsDrugGenericPRB from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDrugGenericPRB(boolean reverse) {
		if (reverse && this.bpjsDrugGenericPRB != null) {
			this.bpjsDrugGenericPRB.unsetStockCatalogue();
		}
		this.bpjsDrugGenericPRB = null;
	}
	/**
	 * Similar to {@link this#setBpjsPcareDPHO(BpjsPcareDPHOEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPcareDPHOEntity to be set to this entity
	 */
	public void setBpjsPcareDPHO(BpjsPcareDPHOEntity entity) {
		setBpjsPcareDPHO(entity, true);
	}

	/**
	 * Set or update the bpjsPcareDPHO in this entity with single BpjsPcareDPHOEntity.
	 *
	 * @param entity the given BpjsPcareDPHOEntity to be set or updated to bpjsPcareDPHO
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPcareDPHO(BpjsPcareDPHOEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareDPHO here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareDPHO here] end

		if (sameAsFormer(this.bpjsPcareDPHO, entity)) {
			return;
		}

		if (this.bpjsPcareDPHO != null) {
			this.bpjsPcareDPHO.unsetStockCatalogue(false);
		}

		this.bpjsPcareDPHO = entity;
		if (reverseAdd) {
			this.bpjsPcareDPHO.setStockCatalogue(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareDPHO incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareDPHO incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsPcareDPHO(boolean)} but default to true.
	 */
	public void unsetBpjsPcareDPHO() {
		this.unsetBpjsPcareDPHO(true);
	}

	/**
	 * Remove the BpjsPcareDPHOEntity of bpjsPcareDPHO from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsPcareDPHO(boolean reverse) {
		if (reverse && this.bpjsPcareDPHO != null) {
			this.bpjsPcareDPHO.unsetStockCatalogue();
		}
		this.bpjsPcareDPHO = null;
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
			this.warehouse.removeStockCatalogues(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addStockCatalogues(this, false);
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
			this.warehouse.removeStockCatalogues(this, false);
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
		return "TRACKABLE,STOCK_CODE,STOCK_NAME,DESCRIPTION,WEIGHT,WEIGHT_UNIT,VOLUME,VOLUME_UNIT,STOCK_GROUP,STOCK_CATEGORY,APPROVAL_STATUS,APPROVED_BY,APPROVAL_DATE,APPROVAL_NOTES,QUANTITY_PER_PACK,UOI,LAST_BUYING_PRICE_VAT_EXCLUDE_CURRENCY,LAST_BUYING_PRICE_VAT_EXCLUDE_PRICE,LAST_BUYING_PRICE_VAT_INCLUDE_CURRENCY,LAST_BUYING_PRICE_VAT_INCLUDE_PRICE,MEDICAL_TYPE,STOCK_CATEGORY_VAT_EXCLUDED,STOCK_CATEGORY_VAT_INCLUDED,ON_HAND_QTY,AVERAGE_COST,TOTAL_COST,SALES_ACCOUNT,INVENTORY_ACCOUNT,PURCHASE_ACCOUNT,LUP_SUPPLIER_NAME,LUP_UNIT_PRICE,LUP_DISCOUNT,LUP_ITEM_PRICE,LUP_LAST_PURCHASE_DATE,LPP_SUPPLIER_NAME,LPP_UNIT_PRICE,LPP_DISCOUNT,LPP_ITEM_PRICE,LPP_LAST_PURCHASE_DATE,BPJS_DRUG_GENERIC_PRB_ID,BPJS_PCARE_DPHO_ID,WAREHOUSE_ID,BATCH_STOCK_BALANCES_CATALOGUE_IDS,BATCH_STOCK_BALANCES_IDS,BATCH_STOCK_TRANSACTION_DETAILS_IDS,CATALOGUE_UOMS_IDS,COMPOUND_PRESCRIPTION_ITEMS_IDS,GOODS_RECEIVE_NOTE_BATCHS_IDS,GOODS_RECEIVE_NOTE_ITEMS_IDS,INTERNAL_ORDER_STOCK_DETAILS_IDS,INVENTORY_ADJUSMENT_BATCHS_IDS,INVENTORY_ADJUSTMENT_ITEMS_IDS,INVENTORY_BATCH_CORRECTION_ITEMS_IDS,MEDICATION_ITEMS_IDS,PRESCRIPTION_ITEM_IDS,PURCHASE_ORDER_STOCK_DETAILS_IDS,PURCHASE_REQUISITION_STOCK_DETAILS_IDS,RETAIL_PHARMACY_STOCK_DETAILS_IDS,RETURN_SUPPLIER_STOCK_DETAILS_IDS,STOCK_CATALOGUE_MEDICAL_ID,STOCK_CATALOGUE_NON_MEDICAL_ID,STOCK_CONTROLS_IDS,STOCK_TRANSACTION_DETAILS_IDS,STOCK_TRANSACTION_PER_DATE_TYPES_IDS,STOCK_TRANSACTION_PER_DATES_IDS,SUPPLIER_PRODUCT_DETAILS_IDS,TRANSFER_ORDER_STOCK_DETAILS_IDS,VACCINATION_ORDER_DETAILS_IDS,WAREHOUSE_INITIAL_STOCK_S_IDS,WAREHOUSE_INVENTORIES_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<BpjsDrugGenericPRBEntity> bpjsDrugGenericPRBRelation = Optional.ofNullable(this.bpjsDrugGenericPRB);
		bpjsDrugGenericPRBRelation.ifPresent(entity -> this.bpjsDrugGenericPRBId = entity.getId());

		Optional<BpjsPcareDPHOEntity> bpjsPcareDPHORelation = Optional.ofNullable(this.bpjsPcareDPHO);
		bpjsPcareDPHORelation.ifPresent(entity -> this.bpjsPcareDPHOId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.batchStockBalancesCatalogueIds = new HashSet<>();
		for (BatchStockBalanceEntity batchStockBalancesCatalogue: this.batchStockBalancesCatalogue) {
			this.batchStockBalancesCatalogueIds.add(batchStockBalancesCatalogue.getId());
		}

		this.batchStockBalancesIds = new HashSet<>();
		for (BatchStockBalancePerDateEntity batchStockBalances: this.batchStockBalances) {
			this.batchStockBalancesIds.add(batchStockBalances.getId());
		}

		this.batchStockTransactionDetailsIds = new HashSet<>();
		for (BatchStockTransactionDetailEntity batchStockTransactionDetails: this.batchStockTransactionDetails) {
			this.batchStockTransactionDetailsIds.add(batchStockTransactionDetails.getId());
		}

		this.catalogueUOMsIds = new HashSet<>();
		for (CatalogueUOMEntity catalogueUOMs: this.catalogueUOMs) {
			this.catalogueUOMsIds.add(catalogueUOMs.getId());
		}

		this.compoundPrescriptionItemsIds = new HashSet<>();
		for (CompoundPrescriptionItemEntity compoundPrescriptionItems: this.compoundPrescriptionItems) {
			this.compoundPrescriptionItemsIds.add(compoundPrescriptionItems.getId());
		}

		this.goodsReceiveNoteBatchsIds = new HashSet<>();
		for (GoodsReceiveNoteBatchEntity goodsReceiveNoteBatchs: this.goodsReceiveNoteBatchs) {
			this.goodsReceiveNoteBatchsIds.add(goodsReceiveNoteBatchs.getId());
		}

		this.goodsReceiveNoteItemsIds = new HashSet<>();
		for (GoodsReceiveNoteItemEntity goodsReceiveNoteItems: this.goodsReceiveNoteItems) {
			this.goodsReceiveNoteItemsIds.add(goodsReceiveNoteItems.getId());
		}

		this.internalOrderStockDetailsIds = new HashSet<>();
		for (InternalOrderStockDetailEntity internalOrderStockDetails: this.internalOrderStockDetails) {
			this.internalOrderStockDetailsIds.add(internalOrderStockDetails.getId());
		}

		this.inventoryAdjusmentBatchsIds = new HashSet<>();
		for (InventoryAdjusmentBatchEntity inventoryAdjusmentBatchs: this.inventoryAdjusmentBatchs) {
			this.inventoryAdjusmentBatchsIds.add(inventoryAdjusmentBatchs.getId());
		}

		this.inventoryAdjustmentItemsIds = new HashSet<>();
		for (InventoryAdjustmentItemEntity inventoryAdjustmentItems: this.inventoryAdjustmentItems) {
			this.inventoryAdjustmentItemsIds.add(inventoryAdjustmentItems.getId());
		}

		this.inventoryBatchCorrectionItemsIds = new HashSet<>();
		for (InventoryBatchCorrectionItemEntity inventoryBatchCorrectionItems: this.inventoryBatchCorrectionItems) {
			this.inventoryBatchCorrectionItemsIds.add(inventoryBatchCorrectionItems.getId());
		}

		this.medicationItemsIds = new HashSet<>();
		for (MedicationItemEntity medicationItems: this.medicationItems) {
			this.medicationItemsIds.add(medicationItems.getId());
		}

		this.prescriptionItemIds = new HashSet<>();
		for (PrescriptionItemEntity prescriptionItem: this.prescriptionItem) {
			this.prescriptionItemIds.add(prescriptionItem.getId());
		}

		this.purchaseOrderStockDetailsIds = new HashSet<>();
		for (PurchaseOrderStockDetailEntity purchaseOrderStockDetails: this.purchaseOrderStockDetails) {
			this.purchaseOrderStockDetailsIds.add(purchaseOrderStockDetails.getId());
		}

		this.purchaseRequisitionStockDetailsIds = new HashSet<>();
		for (PurchaseRequisitionStockDetailEntity purchaseRequisitionStockDetails: this.purchaseRequisitionStockDetails) {
			this.purchaseRequisitionStockDetailsIds.add(purchaseRequisitionStockDetails.getId());
		}

		this.retailPharmacyStockDetailsIds = new HashSet<>();
		for (RetailPharmacyStockDetailEntity retailPharmacyStockDetails: this.retailPharmacyStockDetails) {
			this.retailPharmacyStockDetailsIds.add(retailPharmacyStockDetails.getId());
		}

		this.returnSupplierStockDetailsIds = new HashSet<>();
		for (ReturnSupplierStockDetailEntity returnSupplierStockDetails: this.returnSupplierStockDetails) {
			this.returnSupplierStockDetailsIds.add(returnSupplierStockDetails.getId());
		}

		Optional<CatalogueMedicalEntity> stockCatalogueMedicalRelation = Optional.ofNullable(this.stockCatalogueMedical);
		stockCatalogueMedicalRelation.ifPresent(entity -> this.stockCatalogueMedicalId = entity.getId());

		Optional<CatalogueNonMedicalEntity> stockCatalogueNonMedicalRelation = Optional.ofNullable(this.stockCatalogueNonMedical);
		stockCatalogueNonMedicalRelation.ifPresent(entity -> this.stockCatalogueNonMedicalId = entity.getId());

		this.stockControlsIds = new HashSet<>();
		for (StockControlEntity stockControls: this.stockControls) {
			this.stockControlsIds.add(stockControls.getId());
		}

		this.stockTransactionDetailsIds = new HashSet<>();
		for (StockTransactionDetailEntity stockTransactionDetails: this.stockTransactionDetails) {
			this.stockTransactionDetailsIds.add(stockTransactionDetails.getId());
		}

		this.stockTransactionPerDateTypesIds = new HashSet<>();
		for (StockTransactionPerDateTypeEntity stockTransactionPerDateTypes: this.stockTransactionPerDateTypes) {
			this.stockTransactionPerDateTypesIds.add(stockTransactionPerDateTypes.getId());
		}

		this.stockTransactionPerDatesIds = new HashSet<>();
		for (StockTransactionPerDateEntity stockTransactionPerDates: this.stockTransactionPerDates) {
			this.stockTransactionPerDatesIds.add(stockTransactionPerDates.getId());
		}

		this.supplierProductDetailsIds = new HashSet<>();
		for (SupplierProductDetailEntity supplierProductDetails: this.supplierProductDetails) {
			this.supplierProductDetailsIds.add(supplierProductDetails.getId());
		}

		this.transferOrderStockDetailsIds = new HashSet<>();
		for (TransferOrderStockDetailEntity transferOrderStockDetails: this.transferOrderStockDetails) {
			this.transferOrderStockDetailsIds.add(transferOrderStockDetails.getId());
		}

		this.vaccinationOrderDetailsIds = new HashSet<>();
		for (VaccinationOrderDetailEntity vaccinationOrderDetails: this.vaccinationOrderDetails) {
			this.vaccinationOrderDetailsIds.add(vaccinationOrderDetails.getId());
		}

		this.warehouseInitialStockSIds = new HashSet<>();
		for (WarehouseInitialStockEntity warehouseInitialStockS: this.warehouseInitialStockS) {
			this.warehouseInitialStockSIds.add(warehouseInitialStockS.getId());
		}

		this.warehouseInventoriesIds = new HashSet<>();
		for (WarehouseInventoryEntity warehouseInventories: this.warehouseInventories) {
			this.warehouseInventoriesIds.add(warehouseInventories.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object stockCatalogue) {
		if (this == stockCatalogue) {
			return true;
		}
		if (stockCatalogue == null || this.getClass() != stockCatalogue.getClass()) {
			return false;
		}
		if (!super.equals(stockCatalogue)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		StockCatalogueEntity that = (StockCatalogueEntity) stockCatalogue;
		return
			Objects.equals(this.trackable, that.trackable) &&
			Objects.equals(this.stockCode, that.stockCode) &&
			Objects.equals(this.stockName, that.stockName) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.weight, that.weight) &&
			Objects.equals(this.weightUnit, that.weightUnit) &&
			Objects.equals(this.volume, that.volume) &&
			Objects.equals(this.volumeUnit, that.volumeUnit) &&
			Objects.equals(this.stockGroup, that.stockGroup) &&
			Objects.equals(this.stockCategory, that.stockCategory) &&
			Objects.equals(this.approvalStatus, that.approvalStatus) &&
			Objects.equals(this.approvedBy, that.approvedBy) &&
			Objects.equals(
			     this.approvalDate != null ? this.approvalDate.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.approvalDate != null ? that.approvalDate.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.approvalNotes, that.approvalNotes) &&
			Objects.equals(this.quantityPerPack, that.quantityPerPack) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.lastBuyingPriceVATExcludeCurrency, that.lastBuyingPriceVATExcludeCurrency) &&
			Objects.equals(this.lastBuyingPriceVATExcludePrice, that.lastBuyingPriceVATExcludePrice) &&
			Objects.equals(this.lastBuyingPriceVATIncludeCurrency, that.lastBuyingPriceVATIncludeCurrency) &&
			Objects.equals(this.lastBuyingPriceVATIncludePrice, that.lastBuyingPriceVATIncludePrice) &&
			Objects.equals(this.medicalType, that.medicalType) &&
			Objects.equals(this.stockCategoryVATExcluded, that.stockCategoryVATExcluded) &&
			Objects.equals(this.stockCategoryVATIncluded, that.stockCategoryVATIncluded) &&
			Objects.equals(this.onHandQty, that.onHandQty) &&
			Objects.equals(this.averageCost, that.averageCost) &&
			Objects.equals(this.totalCost, that.totalCost) &&
			Objects.equals(this.salesAccount, that.salesAccount) &&
			Objects.equals(this.inventoryAccount, that.inventoryAccount) &&
			Objects.equals(this.purchaseAccount, that.purchaseAccount) &&
			Objects.equals(this.lupSupplierName, that.lupSupplierName) &&
			Objects.equals(this.lupUnitPrice, that.lupUnitPrice) &&
			Objects.equals(this.lupDiscount, that.lupDiscount) &&
			Objects.equals(this.lupItemPrice, that.lupItemPrice) &&
			Objects.equals(
			     this.lupLastPurchaseDate != null ? this.lupLastPurchaseDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.lupLastPurchaseDate != null ? that.lupLastPurchaseDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.lppSupplierName, that.lppSupplierName) &&
			Objects.equals(this.lppUnitPrice, that.lppUnitPrice) &&
			Objects.equals(this.lppDiscount, that.lppDiscount) &&
			Objects.equals(this.lppItemPrice, that.lppItemPrice) &&
			Objects.equals(
			     this.lppLastPurchaseDate != null ? this.lppLastPurchaseDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.lppLastPurchaseDate != null ? that.lppLastPurchaseDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.batchStockBalancesCatalogueIds, that.batchStockBalancesCatalogueIds) &&
			Objects.equals(this.batchStockBalancesIds, that.batchStockBalancesIds) &&
			Objects.equals(this.batchStockTransactionDetailsIds, that.batchStockTransactionDetailsIds) &&
			Objects.equals(this.catalogueUOMsIds, that.catalogueUOMsIds) &&
			Objects.equals(this.compoundPrescriptionItemsIds, that.compoundPrescriptionItemsIds) &&
			Objects.equals(this.goodsReceiveNoteBatchsIds, that.goodsReceiveNoteBatchsIds) &&
			Objects.equals(this.goodsReceiveNoteItemsIds, that.goodsReceiveNoteItemsIds) &&
			Objects.equals(this.internalOrderStockDetailsIds, that.internalOrderStockDetailsIds) &&
			Objects.equals(this.inventoryAdjusmentBatchsIds, that.inventoryAdjusmentBatchsIds) &&
			Objects.equals(this.inventoryAdjustmentItemsIds, that.inventoryAdjustmentItemsIds) &&
			Objects.equals(this.inventoryBatchCorrectionItemsIds, that.inventoryBatchCorrectionItemsIds) &&
			Objects.equals(this.medicationItemsIds, that.medicationItemsIds) &&
			Objects.equals(this.prescriptionItemIds, that.prescriptionItemIds) &&
			Objects.equals(this.purchaseOrderStockDetailsIds, that.purchaseOrderStockDetailsIds) &&
			Objects.equals(this.purchaseRequisitionStockDetailsIds, that.purchaseRequisitionStockDetailsIds) &&
			Objects.equals(this.retailPharmacyStockDetailsIds, that.retailPharmacyStockDetailsIds) &&
			Objects.equals(this.returnSupplierStockDetailsIds, that.returnSupplierStockDetailsIds) &&
			Objects.equals(this.stockCatalogueMedicalId, that.stockCatalogueMedicalId) &&
			Objects.equals(this.stockCatalogueNonMedicalId, that.stockCatalogueNonMedicalId) &&
			Objects.equals(this.stockControlsIds, that.stockControlsIds) &&
			Objects.equals(this.stockTransactionDetailsIds, that.stockTransactionDetailsIds) &&
			Objects.equals(this.stockTransactionPerDateTypesIds, that.stockTransactionPerDateTypesIds) &&
			Objects.equals(this.stockTransactionPerDatesIds, that.stockTransactionPerDatesIds) &&
			Objects.equals(this.supplierProductDetailsIds, that.supplierProductDetailsIds) &&
			Objects.equals(this.transferOrderStockDetailsIds, that.transferOrderStockDetailsIds) &&
			Objects.equals(this.vaccinationOrderDetailsIds, that.vaccinationOrderDetailsIds) &&
			Objects.equals(this.warehouseInitialStockSIds, that.warehouseInitialStockSIds) &&
			Objects.equals(this.warehouseInventoriesIds, that.warehouseInventoriesIds) &&
			Objects.equals(this.bpjsDrugGenericPRBId, that.bpjsDrugGenericPRBId) &&
			Objects.equals(this.bpjsPcareDPHOId, that.bpjsPcareDPHOId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
