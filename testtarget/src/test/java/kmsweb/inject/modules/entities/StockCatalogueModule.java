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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for Stock Catalogue used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class StockCatalogueModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring StockCatalogueModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured StockCatalogueModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public StockCatalogueEntityFactory stockCatalogueEntityFactory(
			// % protected region % [Apply any additional injected arguments for stockCatalogueEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for stockCatalogueEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating StockCatalogueEntityFactory");

		// % protected region % [Apply any additional logic for stockCatalogueEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueEntityFactory before the main body here] end

		StockCatalogueEntityFactory entityFactory = new StockCatalogueEntityFactory(
				// % protected region % [Apply any additional constructor arguments for StockCatalogueEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for StockCatalogueEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for stockCatalogueEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueEntityFactory after the main body here] end

		log.trace("Created StockCatalogueEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Stock Catalogue entity with no references set.
	 */
	@Provides
	@Named("stockCatalogueEntityWithNoRef")
	public StockCatalogueEntity stockCatalogueEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for stockCatalogueEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for stockCatalogueEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type StockCatalogueEntity with no reference");

		// % protected region % [Apply any additional logic for stockCatalogueWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueWithNoRef before the main body here] end

		StockCatalogueEntity newEntity = new StockCatalogueEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Trackable here] off begin
		newEntity.setTrackable(mock.bools().get());
		// % protected region % [Add customisation for Trackable here] end
		// % protected region % [Add customisation for Stock Code here] off begin
		String randomStringforStockCode = mock
				.strings()
				.get();
		newEntity.setStockCode(randomStringforStockCode);
		// % protected region % [Add customisation for Stock Code here] end
		// % protected region % [Add customisation for Stock Name here] off begin
		String randomStringforStockName = mock
				.strings()
				.get();
		newEntity.setStockName(randomStringforStockName);
		// % protected region % [Add customisation for Stock Name here] end
		// % protected region % [Add customisation for Description here] off begin
		String randomStringforDescription = mock
				.strings()
				.get();
		newEntity.setDescription(randomStringforDescription);
		// % protected region % [Add customisation for Description here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mock.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Weight Unit here] off begin
		String randomStringforWeightUnit = mock
				.strings()
				.get();
		newEntity.setWeightUnit(randomStringforWeightUnit);
		// % protected region % [Add customisation for Weight Unit here] end
		// % protected region % [Add customisation for Volume here] off begin
		newEntity.setVolume(mock.doubles().get());
		// % protected region % [Add customisation for Volume here] end
		// % protected region % [Add customisation for Volume Unit here] off begin
		String randomStringforVolumeUnit = mock
				.strings()
				.get();
		newEntity.setVolumeUnit(randomStringforVolumeUnit);
		// % protected region % [Add customisation for Volume Unit here] end
		// % protected region % [Add customisation for Stock Group here] off begin
		String randomStringforStockGroup = mock
				.strings()
				.get();
		newEntity.setStockGroup(randomStringforStockGroup);
		// % protected region % [Add customisation for Stock Group here] end
		// % protected region % [Add customisation for Stock Category here] off begin
		String randomStringforStockCategory = mock
				.strings()
				.get();
		newEntity.setStockCategory(randomStringforStockCategory);
		// % protected region % [Add customisation for Stock Category here] end
		// % protected region % [Add customisation for Approval Status here] off begin
		String randomStringforApprovalStatus = mock
				.strings()
				.get();
		newEntity.setApprovalStatus(randomStringforApprovalStatus);
		// % protected region % [Add customisation for Approval Status here] end
		// % protected region % [Add customisation for Approved By here] off begin
		String randomStringforApprovedBy = mock
				.strings()
				.get();
		newEntity.setApprovedBy(randomStringforApprovedBy);
		// % protected region % [Add customisation for Approved By here] end
		// % protected region % [Add customisation for Approval Date here] off begin
		newEntity.setApprovalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Approval Date here] end
		// % protected region % [Add customisation for Approval Notes here] off begin
		String randomStringforApprovalNotes = mock
				.strings()
				.get();
		newEntity.setApprovalNotes(randomStringforApprovalNotes);
		// % protected region % [Add customisation for Approval Notes here] end
		// % protected region % [Add customisation for Quantity Per Pack here] off begin
		newEntity.setQuantityPerPack(mock.ints().get());
		// % protected region % [Add customisation for Quantity Per Pack here] end
		// % protected region % [Add customisation for UOI here] off begin
		String randomStringforUoi = mock
				.strings()
				.get();
		newEntity.setUoi(randomStringforUoi);
		// % protected region % [Add customisation for UOI here] end
		// % protected region % [Add customisation for Last Buying Price VAT exclude Currency here] off begin
		String randomStringforLastBuyingPriceVATExcludeCurrency = mock
				.strings()
				.get();
		newEntity.setLastBuyingPriceVATExcludeCurrency(randomStringforLastBuyingPriceVATExcludeCurrency);
		// % protected region % [Add customisation for Last Buying Price VAT exclude Currency here] end
		// % protected region % [Add customisation for Last Buying Price VAT exclude Price here] off begin
		newEntity.setLastBuyingPriceVATExcludePrice(mock.doubles().get());
		// % protected region % [Add customisation for Last Buying Price VAT exclude Price here] end
		// % protected region % [Add customisation for Last Buying Price VAT include Currency here] off begin
		String randomStringforLastBuyingPriceVATIncludeCurrency = mock
				.strings()
				.get();
		newEntity.setLastBuyingPriceVATIncludeCurrency(randomStringforLastBuyingPriceVATIncludeCurrency);
		// % protected region % [Add customisation for Last Buying Price VAT include Currency here] end
		// % protected region % [Add customisation for Last Buying Price VAT include Price here] off begin
		newEntity.setLastBuyingPriceVATIncludePrice(mock.doubles().get());
		// % protected region % [Add customisation for Last Buying Price VAT include Price here] end
		// % protected region % [Add customisation for Medical Type here] off begin
		newEntity.setMedicalType(mock.bools().get());
		// % protected region % [Add customisation for Medical Type here] end
		// % protected region % [Add customisation for Stock Category VAT Excluded here] off begin
		String randomStringforStockCategoryVATExcluded = mock
				.strings()
				.get();
		newEntity.setStockCategoryVATExcluded(randomStringforStockCategoryVATExcluded);
		// % protected region % [Add customisation for Stock Category VAT Excluded here] end
		// % protected region % [Add customisation for Stock Category VAT Included here] off begin
		String randomStringforStockCategoryVATIncluded = mock
				.strings()
				.get();
		newEntity.setStockCategoryVATIncluded(randomStringforStockCategoryVATIncluded);
		// % protected region % [Add customisation for Stock Category VAT Included here] end
		// % protected region % [Add customisation for On Hand Qty here] off begin
		newEntity.setOnHandQty(mock.doubles().get());
		// % protected region % [Add customisation for On Hand Qty here] end
		// % protected region % [Add customisation for Average Cost here] off begin
		newEntity.setAverageCost(mock.doubles().get());
		// % protected region % [Add customisation for Average Cost here] end
		// % protected region % [Add customisation for Total Cost here] off begin
		newEntity.setTotalCost(mock.doubles().get());
		// % protected region % [Add customisation for Total Cost here] end
		// % protected region % [Add customisation for Sales Account here] off begin
		String randomStringforSalesAccount = mock
				.strings()
				.get();
		newEntity.setSalesAccount(randomStringforSalesAccount);
		// % protected region % [Add customisation for Sales Account here] end
		// % protected region % [Add customisation for Inventory Account here] off begin
		String randomStringforInventoryAccount = mock
				.strings()
				.get();
		newEntity.setInventoryAccount(randomStringforInventoryAccount);
		// % protected region % [Add customisation for Inventory Account here] end
		// % protected region % [Add customisation for Purchase Account here] off begin
		String randomStringforPurchaseAccount = mock
				.strings()
				.get();
		newEntity.setPurchaseAccount(randomStringforPurchaseAccount);
		// % protected region % [Add customisation for Purchase Account here] end
		// % protected region % [Add customisation for Lup Supplier Name here] off begin
		String randomStringforLupSupplierName = mock
				.strings()
				.get();
		newEntity.setLupSupplierName(randomStringforLupSupplierName);
		// % protected region % [Add customisation for Lup Supplier Name here] end
		// % protected region % [Add customisation for Lup Unit Price here] off begin
		newEntity.setLupUnitPrice(mock.doubles().get());
		// % protected region % [Add customisation for Lup Unit Price here] end
		// % protected region % [Add customisation for Lup Discount here] off begin
		newEntity.setLupDiscount(mock.doubles().get());
		// % protected region % [Add customisation for Lup Discount here] end
		// % protected region % [Add customisation for Lup Item Price here] off begin
		newEntity.setLupItemPrice(mock.doubles().get());
		// % protected region % [Add customisation for Lup Item Price here] end
		// % protected region % [Add customisation for Lup Last Purchase Date here] off begin
		newEntity.setLupLastPurchaseDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Lup Last Purchase Date here] end
		// % protected region % [Add customisation for Lpp Supplier Name here] off begin
		String randomStringforLppSupplierName = mock
				.strings()
				.get();
		newEntity.setLppSupplierName(randomStringforLppSupplierName);
		// % protected region % [Add customisation for Lpp Supplier Name here] end
		// % protected region % [Add customisation for Lpp Unit Price here] off begin
		newEntity.setLppUnitPrice(mock.doubles().get());
		// % protected region % [Add customisation for Lpp Unit Price here] end
		// % protected region % [Add customisation for Lpp Discount here] off begin
		newEntity.setLppDiscount(mock.doubles().get());
		// % protected region % [Add customisation for Lpp Discount here] end
		// % protected region % [Add customisation for Lpp Item Price here] off begin
		newEntity.setLppItemPrice(mock.doubles().get());
		// % protected region % [Add customisation for Lpp Item Price here] end
		// % protected region % [Add customisation for Lpp Last Purchase Date here] off begin
		newEntity.setLppLastPurchaseDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Lpp Last Purchase Date here] end

		// % protected region % [Apply any additional logic for stockCatalogueWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueWithNoRef after the main body here] end

		log.trace("Created entity of type StockCatalogueEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Stock Catalogue entities with no reference at all.
	 */
	@Provides
	@Named("stockCatalogueEntitiesWithNoRef")
	public Collection<StockCatalogueEntity> stockCatalogueEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for stockCatalogueEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for stockCatalogueEntitiesWithNoRef here] end
		StockCatalogueEntityFactory stockCatalogueEntityFactory
	) {
		log.trace("Creating entities of type StockCatalogueEntity with no reference");

		// % protected region % [Apply any additional logic for stockCatalogueEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueEntitiesWithNoRef before the main body here] end

		Collection<StockCatalogueEntity> newEntities = stockCatalogueEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for stockCatalogueEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type StockCatalogueEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Stock Catalogue entity with all references set.
	 */
	@Provides
	@Named("stockCatalogueEntityWithRefs")
	public StockCatalogueEntity stockCatalogueEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for stockCatalogueEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for stockCatalogueEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type StockCatalogueEntity with references");

		// % protected region % [Apply any additional logic for stockCatalogueEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueEntityWithRefs before the main body here] end

		StockCatalogueEntity stockCatalogueEntity = injector.getInstance(Key.get(StockCatalogueEntity.class, Names.named("stockCatalogueEntityWithNoRef")));

		// % protected region % [Apply any additional logic for stockCatalogueEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueEntityWithRefs after the main body here] end

		log.trace("Created entity of type StockCatalogueEntity with references");

		return stockCatalogueEntity;
	}

	/**
	 * Return a collection of Stock Catalogue entities with all references set.
	 */
	@Provides
	@Named("stockCatalogueEntitiesWithRefs")
	public Collection<StockCatalogueEntity> stockCatalogueEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for stockCatalogueEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for stockCatalogueEntitiesWithRefs here] end
		StockCatalogueEntityFactory stockCatalogueEntityFactory
	) {
		log.trace("Creating entities of type StockCatalogueEntity with references");

		// % protected region % [Apply any additional logic for stockCatalogueEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueEntitiesWithRefs before the main body here] end

		Collection<StockCatalogueEntity> newEntities = stockCatalogueEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for stockCatalogueEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for stockCatalogueEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type StockCatalogueEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
