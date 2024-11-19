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
package kmsweb.cucumber.pom.pages.admin.crud.edit;

import com.google.inject.Inject;
import kmsweb.cucumber.utils.*;
import kmsweb.entities.AbstractEntity;
import kmsweb.entities.StockCatalogueEntity;

import cucumber.runtime.java.guice.ScenarioScoped;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Stock CataloguePage is a Page POM that is associated with the admin/entities/stock-catalogue url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesStockCatalogueCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='trackable-field']")
	private WebElement trackableField;
	@FindBy(how = How.XPATH, using = "//*[@id='stockCode-field']")
	private WebElement stockCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='stockName-field']")
	private WebElement stockNameField;
	@FindBy(how = How.XPATH, using = "//*[@id='description-field']")
	private WebElement descriptionField;
	// TODO default handling dataAttribute weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='weight-field']")
	private WebElement weightField;
	@FindBy(how = How.XPATH, using = "//*[@id='weightUnit-field']")
	private WebElement weightUnitField;
	// TODO default handling dataAttribute volumeField;
	@FindBy(how = How.XPATH, using = "//*[@id='volume-field']")
	private WebElement volumeField;
	@FindBy(how = How.XPATH, using = "//*[@id='volumeUnit-field']")
	private WebElement volumeUnitField;
	@FindBy(how = How.XPATH, using = "//*[@id='stockGroup-field']")
	private WebElement stockGroupField;
	@FindBy(how = How.XPATH, using = "//*[@id='stockCategory-field']")
	private WebElement stockCategoryField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalStatus-field']")
	private WebElement approvalStatusField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvedBy-field']")
	private WebElement approvedByField;
	// TODO default handling dataAttribute approvalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalDate-field']")
	private WebElement approvalDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='approvalNotes-field']")
	private WebElement approvalNotesField;
	// TODO default handling dataAttribute quantityPerPackField;
	@FindBy(how = How.XPATH, using = "//*[@id='quantityPerPack-field']")
	private WebElement quantityPerPackField;
	@FindBy(how = How.XPATH, using = "//*[@id='uoi-field']")
	private WebElement uoiField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastBuyingPriceVATExcludeCurrency-field']")
	private WebElement lastBuyingPriceVATExcludeCurrencyField;
	// TODO default handling dataAttribute lastBuyingPriceVATExcludePriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastBuyingPriceVATExcludePrice-field']")
	private WebElement lastBuyingPriceVATExcludePriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastBuyingPriceVATIncludeCurrency-field']")
	private WebElement lastBuyingPriceVATIncludeCurrencyField;
	// TODO default handling dataAttribute lastBuyingPriceVATIncludePriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='lastBuyingPriceVATIncludePrice-field']")
	private WebElement lastBuyingPriceVATIncludePriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='medicalType-field']")
	private WebElement medicalTypeField;
	@FindBy(how = How.XPATH, using = "//*[@id='stockCategoryVATExcluded-field']")
	private WebElement stockCategoryVATExcludedField;
	@FindBy(how = How.XPATH, using = "//*[@id='stockCategoryVATIncluded-field']")
	private WebElement stockCategoryVATIncludedField;
	// TODO default handling dataAttribute onHandQtyField;
	@FindBy(how = How.XPATH, using = "//*[@id='onHandQty-field']")
	private WebElement onHandQtyField;
	// TODO default handling dataAttribute averageCostField;
	@FindBy(how = How.XPATH, using = "//*[@id='averageCost-field']")
	private WebElement averageCostField;
	// TODO default handling dataAttribute totalCostField;
	@FindBy(how = How.XPATH, using = "//*[@id='totalCost-field']")
	private WebElement totalCostField;
	@FindBy(how = How.XPATH, using = "//*[@id='salesAccount-field']")
	private WebElement salesAccountField;
	@FindBy(how = How.XPATH, using = "//*[@id='inventoryAccount-field']")
	private WebElement inventoryAccountField;
	@FindBy(how = How.XPATH, using = "//*[@id='purchaseAccount-field']")
	private WebElement purchaseAccountField;
	@FindBy(how = How.XPATH, using = "//*[@id='lupSupplierName-field']")
	private WebElement lupSupplierNameField;
	// TODO default handling dataAttribute lupUnitPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='lupUnitPrice-field']")
	private WebElement lupUnitPriceField;
	// TODO default handling dataAttribute lupDiscountField;
	@FindBy(how = How.XPATH, using = "//*[@id='lupDiscount-field']")
	private WebElement lupDiscountField;
	// TODO default handling dataAttribute lupItemPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='lupItemPrice-field']")
	private WebElement lupItemPriceField;
	// TODO default handling dataAttribute lupLastPurchaseDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='lupLastPurchaseDate-field']")
	private WebElement lupLastPurchaseDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='lppSupplierName-field']")
	private WebElement lppSupplierNameField;
	// TODO default handling dataAttribute lppUnitPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='lppUnitPrice-field']")
	private WebElement lppUnitPriceField;
	// TODO default handling dataAttribute lppDiscountField;
	@FindBy(how = How.XPATH, using = "//*[@id='lppDiscount-field']")
	private WebElement lppDiscountField;
	// TODO default handling dataAttribute lppItemPriceField;
	@FindBy(how = How.XPATH, using = "//*[@id='lppItemPrice-field']")
	private WebElement lppItemPriceField;
	// TODO default handling dataAttribute lppLastPurchaseDateField;
	@FindBy(how = How.XPATH, using = "//*[@id='lppLastPurchaseDate-field']")
	private WebElement lppLastPurchaseDateField;
	

	// Outgoing one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueMedical-field']")
	private WebElement stockCatalogueMedicalField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockCatalogueNonMedical-field']")
	private WebElement stockCatalogueNonMedicalField;

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsDrugGenericPRBId-field']")
	private WebElement bpjsDrugGenericPRBField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='bpjsPcareDPHOId-field']")
	private WebElement bpjsPcareDPHOField;

	// Outgoing one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='batchStockBalancesCatalogueIds-field']")
	private WebElement batchStockBalancesCatalogueField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='batchStockBalancesIds-field']")
	private WebElement batchStockBalancesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='batchStockTransactionDetailsIds-field']")
	private WebElement batchStockTransactionDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='catalogueUOMsIds-field']")
	private WebElement catalogueUOMsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='compoundPrescriptionItemsIds-field']")
	private WebElement compoundPrescriptionItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNoteBatchsIds-field']")
	private WebElement goodsReceiveNoteBatchsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='goodsReceiveNoteItemsIds-field']")
	private WebElement goodsReceiveNoteItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='internalOrderStockDetailsIds-field']")
	private WebElement internalOrderStockDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='inventoryAdjusmentBatchsIds-field']")
	private WebElement inventoryAdjusmentBatchsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='inventoryAdjustmentItemsIds-field']")
	private WebElement inventoryAdjustmentItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='inventoryBatchCorrectionItemsIds-field']")
	private WebElement inventoryBatchCorrectionItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicationItemsIds-field']")
	private WebElement medicationItemsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='prescriptionItemIds-field']")
	private WebElement prescriptionItemField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseOrderStockDetailsIds-field']")
	private WebElement purchaseOrderStockDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='purchaseRequisitionStockDetailsIds-field']")
	private WebElement purchaseRequisitionStockDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='retailPharmacyStockDetailsIds-field']")
	private WebElement retailPharmacyStockDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='returnSupplierStockDetailsIds-field']")
	private WebElement returnSupplierStockDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockControlsIds-field']")
	private WebElement stockControlsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockTransactionDetailsIds-field']")
	private WebElement stockTransactionDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockTransactionPerDateTypesIds-field']")
	private WebElement stockTransactionPerDateTypesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='stockTransactionPerDatesIds-field']")
	private WebElement stockTransactionPerDatesField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='supplierProductDetailsIds-field']")
	private WebElement supplierProductDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='transferOrderStockDetailsIds-field']")
	private WebElement transferOrderStockDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='vaccinationOrderDetailsIds-field']")
	private WebElement vaccinationOrderDetailsField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseInitialStockSIds-field']")
	private WebElement warehouseInitialStockSField;
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseInventoriesIds-field']")
	private WebElement warehouseInventoriesField;

	// Incoming one-to-many
	@FindBy(how = How.XPATH, using = "//ng-select[@id='warehouseId-field']")
	private WebElement warehouseField;

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesStockCatalogueCrudEditPage(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			@NonNull WebDriver webDriver,
			@NonNull Properties properties
	) {
		super(
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
			webDriver,
			properties,
			"admin/entities/stock-catalogue/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (StockCatalogueEntity) abstractEntity;
		if (entity.getTrackable()) {
			trackableField.click();
		}
		stockCodeField.sendKeys(entity.getStockCode());
		stockNameField.sendKeys(entity.getStockName());
		descriptionField.sendKeys(entity.getDescription());
		// TODO default handling for dataAttribute weightField
		weightField.sendKeys(entity.getWeight().toString());

		weightUnitField.sendKeys(entity.getWeightUnit());
		// TODO default handling for dataAttribute volumeField
		volumeField.sendKeys(entity.getVolume().toString());

		volumeUnitField.sendKeys(entity.getVolumeUnit());
		stockGroupField.sendKeys(entity.getStockGroup());
		stockCategoryField.sendKeys(entity.getStockCategory());
		approvalStatusField.sendKeys(entity.getApprovalStatus());
		approvedByField.sendKeys(entity.getApprovedBy());
		// TODO default handling for dataAttribute approvalDateField
		approvalDateField.sendKeys(entity.getApprovalDate().toString());

		approvalNotesField.sendKeys(entity.getApprovalNotes());
		// TODO default handling for dataAttribute quantityPerPackField
		quantityPerPackField.sendKeys(entity.getQuantityPerPack().toString());

		uoiField.sendKeys(entity.getUoi());
		lastBuyingPriceVATExcludeCurrencyField.sendKeys(entity.getLastBuyingPriceVATExcludeCurrency());
		// TODO default handling for dataAttribute lastBuyingPriceVATExcludePriceField
		lastBuyingPriceVATExcludePriceField.sendKeys(entity.getLastBuyingPriceVATExcludePrice().toString());

		lastBuyingPriceVATIncludeCurrencyField.sendKeys(entity.getLastBuyingPriceVATIncludeCurrency());
		// TODO default handling for dataAttribute lastBuyingPriceVATIncludePriceField
		lastBuyingPriceVATIncludePriceField.sendKeys(entity.getLastBuyingPriceVATIncludePrice().toString());

		if (entity.getMedicalType()) {
			medicalTypeField.click();
		}
		stockCategoryVATExcludedField.sendKeys(entity.getStockCategoryVATExcluded());
		stockCategoryVATIncludedField.sendKeys(entity.getStockCategoryVATIncluded());
		// TODO default handling for dataAttribute onHandQtyField
		onHandQtyField.sendKeys(entity.getOnHandQty().toString());

		// TODO default handling for dataAttribute averageCostField
		averageCostField.sendKeys(entity.getAverageCost().toString());

		// TODO default handling for dataAttribute totalCostField
		totalCostField.sendKeys(entity.getTotalCost().toString());

		salesAccountField.sendKeys(entity.getSalesAccount());
		inventoryAccountField.sendKeys(entity.getInventoryAccount());
		purchaseAccountField.sendKeys(entity.getPurchaseAccount());
		lupSupplierNameField.sendKeys(entity.getLupSupplierName());
		// TODO default handling for dataAttribute lupUnitPriceField
		lupUnitPriceField.sendKeys(entity.getLupUnitPrice().toString());

		// TODO default handling for dataAttribute lupDiscountField
		lupDiscountField.sendKeys(entity.getLupDiscount().toString());

		// TODO default handling for dataAttribute lupItemPriceField
		lupItemPriceField.sendKeys(entity.getLupItemPrice().toString());

		// TODO default handling for dataAttribute lupLastPurchaseDateField
		lupLastPurchaseDateField.sendKeys(entity.getLupLastPurchaseDate().toString());

		lppSupplierNameField.sendKeys(entity.getLppSupplierName());
		// TODO default handling for dataAttribute lppUnitPriceField
		lppUnitPriceField.sendKeys(entity.getLppUnitPrice().toString());

		// TODO default handling for dataAttribute lppDiscountField
		lppDiscountField.sendKeys(entity.getLppDiscount().toString());

		// TODO default handling for dataAttribute lppItemPriceField
		lppItemPriceField.sendKeys(entity.getLppItemPrice().toString());

		// TODO default handling for dataAttribute lppLastPurchaseDateField
		lppLastPurchaseDateField.sendKeys(entity.getLppLastPurchaseDate().toString());


		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}