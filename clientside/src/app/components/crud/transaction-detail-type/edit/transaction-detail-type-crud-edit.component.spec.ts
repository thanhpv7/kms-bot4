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

import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { By } from '@angular/platform-browser';
import { ComponentFixture, TestBed, waitForAsync, fakeAsync } from '@angular/core/testing';
import { CookieService } from 'ngx-cookie-service';
import { DebugElement } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Store } from '@ngrx/store';
import { MockStore, provideMockStore } from '@ngrx/store/testing';
import { ModalDialogService, ModalDialogInstanceService } from '@preeco-privacy/ngx-modal-dialog';
import { ActivatedRouteStub } from 'src/testing/helpers/activated-route-stub';
import { CommonComponentModule } from 'src/app/lib/components/common.component.module';
import { getRouterState } from 'src/app/models/model.selector';
import { RouterState } from 'src/app/models/model.state';
import { 
	getTransactionDetailTypeCollectionModels,
	getCountTransactionDetailTypeModels,
	getTransactionDetailTypeModelWithId
} from 'src/app/models/transactionDetailType/transaction_detail_type.model.selector';
import { TransactionDetailTypeCrudModule } from '../transaction-detail-type-crud.module';
import { TransactionDetailTypeCrudEditComponent } from './transaction-detail-type-crud-edit.component';
import {
	TransactionDetailTypeModelState,
	initialState as initialTransactionDetailTypeModelState
} from 'src/app/models/transactionDetailType/transaction_detail_type.model.state';
import { TransactionDetailTypeDataFactory } from 'src/app/lib/utils/factories/transaction-detail-type-data-factory';
import { TransactionDetailTypeModel } from 'src/app/models/transactionDetailType/transaction_detail_type.model';
import { CrudTileMode } from '../transaction-detail-type-crud.component';
import { getInventoryAdjustmentModelWithId } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.selector';
import { getInventoryAdjustmentCollectionModels } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model.selector';
import { InventoryAdjustmentModel } from 'src/app/models/inventoryAdjustment/inventory_adjustment.model';
import { InventoryAdjustmentDataFactory } from 'src/app/lib/utils/factories/inventory-adjustment-data-factory';
import { getInventoryAdjustmentItemModelWithId } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model.selector';
import { getInventoryAdjustmentItemCollectionModels } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model.selector';
import { InventoryAdjustmentItemModel } from 'src/app/models/inventoryAdjustmentItem/inventory_adjustment_item.model';
import { InventoryAdjustmentItemDataFactory } from 'src/app/lib/utils/factories/inventory-adjustment-item-data-factory';
import { getStockCatalogueModelWithId } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { getStockCatalogueCollectionModels } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { StockCatalogueModel } from 'src/app/models/stockCatalogue/stock_catalogue.model';
import { StockCatalogueDataFactory } from 'src/app/lib/utils/factories/stock-catalogue-data-factory';
import { getStockTransactionDetailModelWithId } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.selector';
import { getStockTransactionDetailCollectionModels } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model.selector';
import { StockTransactionDetailModel } from 'src/app/models/stockTransactionDetail/stock_transaction_detail.model';
import { StockTransactionDetailDataFactory } from 'src/app/lib/utils/factories/stock-transaction-detail-data-factory';
import { getStockTransactionPerDateTypeModelWithId } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.selector';
import { getStockTransactionPerDateTypeCollectionModels } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model.selector';
import { StockTransactionPerDateTypeModel } from 'src/app/models/stockTransactionPerDateType/stock_transaction_per_date_type.model';
import { StockTransactionPerDateTypeDataFactory } from 'src/app/lib/utils/factories/stock-transaction-per-date-type-data-factory';
import { getTransactionDetailTypeMappingModelWithId } from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model.selector';
import { getTransactionDetailTypeMappingCollectionModels } from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model.selector';
import { TransactionDetailTypeMappingModel } from 'src/app/models/transactionDetailTypeMapping/transaction_detail_type_mapping.model';
import { TransactionDetailTypeMappingDataFactory } from 'src/app/lib/utils/factories/transaction-detail-type-mapping-data-factory';
import { getWarehouseModelWithId } from 'src/app/models/warehouse/warehouse.model.selector';
import { getWarehouseCollectionModels } from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { WarehouseDataFactory } from 'src/app/lib/utils/factories/warehouse-data-factory';

describe('Transaction Detail Type CRUD Edit component tests', () => {
	let fixture: ComponentFixture<TransactionDetailTypeCrudEditComponent>
	let component: TransactionDetailTypeCrudEditComponent;

	let transactionDetailTypeModelState: TransactionDetailTypeModelState;

	let store: MockStore<{ model: TransactionDetailTypeModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let transactionDetailTypeCountBehaviorSubject: BehaviorSubject<number>;
	let transactionDetailTypeModelsBehaviorSubject: BehaviorSubject<TransactionDetailTypeModel[]>;
	let inventoryAdjustmentModelsBehaviorSubject: BehaviorSubject<InventoryAdjustmentModel[]>;
	let inventoryAdjustmentItemModelsBehaviorSubject: BehaviorSubject<InventoryAdjustmentItemModel[]>;
	let stockCatalogueModelsBehaviorSubject: BehaviorSubject<StockCatalogueModel[]>;
	let stockTransactionDetailModelsBehaviorSubject: BehaviorSubject<StockTransactionDetailModel[]>;
	let stockTransactionPerDateTypeModelsBehaviorSubject: BehaviorSubject<StockTransactionPerDateTypeModel[]>;
	let transactionDetailTypeMappingModelsBehaviorSubject: BehaviorSubject<TransactionDetailTypeMappingModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;

	const transactionDetailTypeFactory: TransactionDetailTypeDataFactory = new TransactionDetailTypeDataFactory();
	const defaultTransactionDetailTypeCount: number = 10;
	const defaultTransactionDetailTypeEntities: TransactionDetailTypeModel[] = transactionDetailTypeFactory.createAll(defaultTransactionDetailTypeCount);

	const inventoryAdjustmentFactory: InventoryAdjustmentDataFactory = new InventoryAdjustmentDataFactory();
	const defaultInventoryAdjustmentCount: number = 10;
	const defaultInventoryAdjustmentEntities: InventoryAdjustmentModel[] = inventoryAdjustmentFactory.createAll(defaultInventoryAdjustmentCount);

	const inventoryAdjustmentItemFactory: InventoryAdjustmentItemDataFactory = new InventoryAdjustmentItemDataFactory();
	const defaultInventoryAdjustmentItemCount: number = 10;
	const defaultInventoryAdjustmentItemEntities: InventoryAdjustmentItemModel[] = inventoryAdjustmentItemFactory.createAll(defaultInventoryAdjustmentItemCount);

	const stockCatalogueFactory: StockCatalogueDataFactory = new StockCatalogueDataFactory();
	const defaultStockCatalogueCount: number = 10;
	const defaultStockCatalogueEntities: StockCatalogueModel[] = stockCatalogueFactory.createAll(defaultStockCatalogueCount);

	const stockTransactionDetailFactory: StockTransactionDetailDataFactory = new StockTransactionDetailDataFactory();
	const defaultStockTransactionDetailCount: number = 10;
	const defaultStockTransactionDetailEntities: StockTransactionDetailModel[] = stockTransactionDetailFactory.createAll(defaultStockTransactionDetailCount);

	const stockTransactionPerDateTypeFactory: StockTransactionPerDateTypeDataFactory = new StockTransactionPerDateTypeDataFactory();
	const defaultStockTransactionPerDateTypeCount: number = 10;
	const defaultStockTransactionPerDateTypeEntities: StockTransactionPerDateTypeModel[] = stockTransactionPerDateTypeFactory.createAll(defaultStockTransactionPerDateTypeCount);

	const transactionDetailTypeMappingFactory: TransactionDetailTypeMappingDataFactory = new TransactionDetailTypeMappingDataFactory();
	const defaultTransactionDetailTypeMappingCount: number = 10;
	const defaultTransactionDetailTypeMappingEntities: TransactionDetailTypeMappingModel[] = transactionDetailTypeMappingFactory.createAll(defaultTransactionDetailTypeMappingCount);

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let transactionDetailTypeWithId: TransactionDetailTypeModel = defaultTransactionDetailTypeEntities[0];
	let transactionDetailTypeModelWithIdBehaviorSubject: BehaviorSubject<TransactionDetailTypeModel>;

	transactionDetailTypeWithId.inventoryAdjustments = defaultInventoryAdjustmentEntities;
	transactionDetailTypeWithId.inventoryAdjustmentsIds = transactionDetailTypeWithId.inventoryAdjustments.map(inventoryAdjustments => inventoryAdjustments.id);

	transactionDetailTypeWithId.stockTransactionDetails = defaultStockTransactionDetailEntities;
	transactionDetailTypeWithId.stockTransactionDetailsIds = transactionDetailTypeWithId.stockTransactionDetails.map(stockTransactionDetails => stockTransactionDetails.id);

	transactionDetailTypeWithId.stockTransactionPerDateTypes = defaultStockTransactionPerDateTypeEntities;
	transactionDetailTypeWithId.stockTransactionPerDateTypesIds = transactionDetailTypeWithId.stockTransactionPerDateTypes.map(stockTransactionPerDateTypes => stockTransactionPerDateTypes.id);

	transactionDetailTypeWithId.transactionDetailTypeMappings = defaultTransactionDetailTypeMappingEntities;
	transactionDetailTypeWithId.transactionDetailTypeMappingsIds = transactionDetailTypeWithId.transactionDetailTypeMappings.map(transactionDetailTypeMappings => transactionDetailTypeMappings.id);


	const routerState: RouterState = {
		url: 'transaction-detail-type-crud',
		urls: ['transaction-detail-type-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: TransactionDetailTypeModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		transactionDetailTypeModelState = initialTransactionDetailTypeModelState;
		store.setState({model: transactionDetailTypeModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		transactionDetailTypeCountBehaviorSubject = new BehaviorSubject(defaultTransactionDetailTypeCount);

		// selectors for all references
		transactionDetailTypeModelsBehaviorSubject = new BehaviorSubject(defaultTransactionDetailTypeEntities);
		inventoryAdjustmentModelsBehaviorSubject = new BehaviorSubject(defaultInventoryAdjustmentEntities);
		inventoryAdjustmentItemModelsBehaviorSubject = new BehaviorSubject(defaultInventoryAdjustmentItemEntities);
		stockCatalogueModelsBehaviorSubject = new BehaviorSubject(defaultStockCatalogueEntities);
		stockTransactionDetailModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionDetailEntities);
		stockTransactionPerDateTypeModelsBehaviorSubject = new BehaviorSubject(defaultStockTransactionPerDateTypeEntities);
		transactionDetailTypeMappingModelsBehaviorSubject = new BehaviorSubject(defaultTransactionDetailTypeMappingEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);

		// selectors for target entity and its related entity
		transactionDetailTypeModelWithIdBehaviorSubject = new BehaviorSubject(transactionDetailTypeWithId);

		spyOn(store, 'select')
			.withArgs(getCountTransactionDetailTypeModels).and.returnValue(transactionDetailTypeCountBehaviorSubject)
			.withArgs(getTransactionDetailTypeModelWithId, transactionDetailTypeWithId.id).and.returnValue(transactionDetailTypeModelWithIdBehaviorSubject)
			.withArgs(getTransactionDetailTypeCollectionModels, jasmine.any(String)).and.returnValue(transactionDetailTypeModelsBehaviorSubject)
			.withArgs(getInventoryAdjustmentCollectionModels, jasmine.any(String)).and.returnValue(inventoryAdjustmentModelsBehaviorSubject)
			.withArgs(getInventoryAdjustmentItemCollectionModels, jasmine.any(String)).and.returnValue(inventoryAdjustmentItemModelsBehaviorSubject)
			.withArgs(getStockCatalogueCollectionModels, jasmine.any(String)).and.returnValue(stockCatalogueModelsBehaviorSubject)
			.withArgs(getStockTransactionDetailCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionDetailModelsBehaviorSubject)
			.withArgs(getStockTransactionPerDateTypeCollectionModels, jasmine.any(String)).and.returnValue(stockTransactionPerDateTypeModelsBehaviorSubject)
			.withArgs(getTransactionDetailTypeMappingCollectionModels, jasmine.any(String)).and.returnValue(transactionDetailTypeMappingModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				TransactionDetailTypeCrudModule,
				CommonComponentModule,
				FormsModule,
				ReactiveFormsModule,
			],
			providers: [
				provideMockStore(),
				{
					provide: ActivatedRoute,
					useValue: activatedRouteStub,
				},
				CookieService,
				ModalDialogService,
				ModalDialogInstanceService,
			]
		}).compileComponents().then(() => {

			spySelectorsInStore();

			fixture = TestBed.createComponent(TransactionDetailTypeCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new TransactionDetailTypeModel();
			component.createReactiveForm();
			fixture.detectChanges();


		});
	}));

	afterEach(() => {
		// Need to do this since for some reason the last component queried from the fixture will be rendered on the
		// browser
		if (fixture.nativeElement instanceof HTMLElement) {
			(fixture.nativeElement as HTMLElement).remove();
		}
		component.ngOnDestroy();
	});

	/**
	 * Checks that the component is created by the test initialisation
	 */
	it ('Renders the Transaction Detail Type CRUD Edit Component', () => {
		expect(component).toBeTruthy();
	});

	/**
	 * Checks that there are no add additional model buttons present in the component when in view mode.
	 *
	 * This test does not require checking whether multi crud is active for a given relation, as the expected outcome
	 * is identical for components with multi entity crud active and for components without it
	 */
	it ('Does not render any add entity buttons when in view mode', fakeAsync(() => {
		component.tileMode = CrudTileMode.View;
		fixture.detectChanges();

		const addEntityButtons: DebugElement[] = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'));

		expect(addEntityButtons.length).toEqual(0);
	}));

	/**
	* Checks that the status of the add model button matches the multi entity status for the Inventory Adjustments relation.
	*
	* The button should only exist if inventoryAdjustmentsMultiCrudActive is true
	*/
	it ('Renders Inventory Adjustments Add Entity button in create mode', fakeAsync(() => {
		const inventoryAdjustmentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!inventoryAdjustmentsButton).toEqual(component.inventoryAdjustmentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Inventory Adjustments', fakeAsync(() => {
		const inventoryAdjustmentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjustmentsButton).toEqual(component.inventoryAdjustmentsMultiCrudActive);

		if (component.inventoryAdjustmentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialInventoryAdjustmentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model')).length;

			inventoryAdjustmentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualInventoryAdjustmentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model')).length;

			expect(actualInventoryAdjustmentsRemoveButtonCount).toEqual(initialInventoryAdjustmentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Inventory Adjustments button', () => {
		const inventoryAdjustmentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjustmentsButton).toEqual(component.inventoryAdjustmentsMultiCrudActive);

		if (component.inventoryAdjustmentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			inventoryAdjustmentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialInventoryAdjustmentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialInventoryAdjustmentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualInventoryAdjustmentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model'));

			expect(actualInventoryAdjustmentsRemoveButtons.length).toEqual(initialInventoryAdjustmentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Inventory Adjustments button when one has already been added', () => {

		const inventoryAdjustmentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!inventoryAdjustmentsButton).toEqual(component.inventoryAdjustmentsMultiCrudActive);

		if (component.inventoryAdjustmentsMultiCrudActive) {
			inventoryAdjustmentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedinventoryAdjustmentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.inventoryAdjustmentsDisplayName + ' to Model'));

			expect(updatedinventoryAdjustmentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Inventory Adjustments entities from model when loading in edit mode', () => {
		component.targetModel = transactionDetailTypeWithId;
		component.targetModelId = transactionDetailTypeWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.inventoryAdjustmentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const inventoryAdjustmentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.inventoryAdjustmentsDisplayName + ' from Model')).length;

			expect(inventoryAdjustmentsRemoveButtonCount).toEqual(transactionDetailTypeWithId.inventoryAdjustments.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Stock Transaction Details relation.
	*
	* The button should only exist if stockTransactionDetailsMultiCrudActive is true
	*/
	it ('Renders Stock Transaction Details Add Entity button in create mode', fakeAsync(() => {
		const stockTransactionDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockTransactionDetailsButton).toEqual(component.stockTransactionDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Transaction Details', fakeAsync(() => {
		const stockTransactionDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionDetailsButton).toEqual(component.stockTransactionDetailsMultiCrudActive);

		if (component.stockTransactionDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockTransactionDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model')).length;

			stockTransactionDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model')).length;

			expect(actualStockTransactionDetailsRemoveButtonCount).toEqual(initialStockTransactionDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Transaction Details button', () => {
		const stockTransactionDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionDetailsButton).toEqual(component.stockTransactionDetailsMultiCrudActive);

		if (component.stockTransactionDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockTransactionDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockTransactionDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockTransactionDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model'));

			expect(actualStockTransactionDetailsRemoveButtons.length).toEqual(initialStockTransactionDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Stock Transaction Details button when one has already been added', () => {

		const stockTransactionDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionDetailsButton).toEqual(component.stockTransactionDetailsMultiCrudActive);

		if (component.stockTransactionDetailsMultiCrudActive) {
			stockTransactionDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockTransactionDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionDetailsDisplayName + ' to Model'));

			expect(updatedstockTransactionDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Stock Transaction Details entities from model when loading in edit mode', () => {
		component.targetModel = transactionDetailTypeWithId;
		component.targetModelId = transactionDetailTypeWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockTransactionDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockTransactionDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionDetailsDisplayName + ' from Model')).length;

			expect(stockTransactionDetailsRemoveButtonCount).toEqual(transactionDetailTypeWithId.stockTransactionDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Stock Transaction Per Date Types relation.
	*
	* The button should only exist if stockTransactionPerDateTypesMultiCrudActive is true
	*/
	it ('Renders Stock Transaction Per Date Types Add Entity button in create mode', fakeAsync(() => {
		const stockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!stockTransactionPerDateTypesButton).toEqual(component.stockTransactionPerDateTypesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Stock Transaction Per Date Types', fakeAsync(() => {
		const stockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionPerDateTypesButton).toEqual(component.stockTransactionPerDateTypesMultiCrudActive);

		if (component.stockTransactionPerDateTypesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialStockTransactionPerDateTypesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model')).length;

			stockTransactionPerDateTypesButton.nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionPerDateTypesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model')).length;

			expect(actualStockTransactionPerDateTypesRemoveButtonCount).toEqual(initialStockTransactionPerDateTypesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Stock Transaction Per Date Types button', () => {
		const stockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionPerDateTypesButton).toEqual(component.stockTransactionPerDateTypesMultiCrudActive);

		if (component.stockTransactionPerDateTypesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			stockTransactionPerDateTypesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialStockTransactionPerDateTypesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialStockTransactionPerDateTypesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualStockTransactionPerDateTypesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model'));

			expect(actualStockTransactionPerDateTypesRemoveButtons.length).toEqual(initialStockTransactionPerDateTypesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Stock Transaction Per Date Types button when one has already been added', () => {

		const stockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!stockTransactionPerDateTypesButton).toEqual(component.stockTransactionPerDateTypesMultiCrudActive);

		if (component.stockTransactionPerDateTypesMultiCrudActive) {
			stockTransactionPerDateTypesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedstockTransactionPerDateTypesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.stockTransactionPerDateTypesDisplayName + ' to Model'));

			expect(updatedstockTransactionPerDateTypesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Stock Transaction Per Date Types entities from model when loading in edit mode', () => {
		component.targetModel = transactionDetailTypeWithId;
		component.targetModelId = transactionDetailTypeWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.stockTransactionPerDateTypesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const stockTransactionPerDateTypesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.stockTransactionPerDateTypesDisplayName + ' from Model')).length;

			expect(stockTransactionPerDateTypesRemoveButtonCount).toEqual(transactionDetailTypeWithId.stockTransactionPerDateTypes.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Transaction Detail Type Mappings relation.
	*
	* The button should only exist if transactionDetailTypeMappingsMultiCrudActive is true
	*/
	it ('Renders Transaction Detail Type Mappings Add Entity button in create mode', fakeAsync(() => {
		const transactionDetailTypeMappingsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.transactionDetailTypeMappingsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!transactionDetailTypeMappingsButton).toEqual(component.transactionDetailTypeMappingsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Transaction Detail Type Mappings', fakeAsync(() => {
		const transactionDetailTypeMappingsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.transactionDetailTypeMappingsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!transactionDetailTypeMappingsButton).toEqual(component.transactionDetailTypeMappingsMultiCrudActive);

		if (component.transactionDetailTypeMappingsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialTransactionDetailTypeMappingsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transactionDetailTypeMappingsDisplayName + ' from Model')).length;

			transactionDetailTypeMappingsButton.nativeElement.click();
			fixture.detectChanges();

			const actualTransactionDetailTypeMappingsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transactionDetailTypeMappingsDisplayName + ' from Model')).length;

			expect(actualTransactionDetailTypeMappingsRemoveButtonCount).toEqual(initialTransactionDetailTypeMappingsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Transaction Detail Type Mappings button', () => {
		const transactionDetailTypeMappingsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.transactionDetailTypeMappingsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!transactionDetailTypeMappingsButton).toEqual(component.transactionDetailTypeMappingsMultiCrudActive);

		if (component.transactionDetailTypeMappingsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			transactionDetailTypeMappingsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialTransactionDetailTypeMappingsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transactionDetailTypeMappingsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialTransactionDetailTypeMappingsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualTransactionDetailTypeMappingsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transactionDetailTypeMappingsDisplayName + ' from Model'));

			expect(actualTransactionDetailTypeMappingsRemoveButtons.length).toEqual(initialTransactionDetailTypeMappingsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Transaction Detail Type Mappings button when one has already been added', () => {

		const transactionDetailTypeMappingsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.transactionDetailTypeMappingsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!transactionDetailTypeMappingsButton).toEqual(component.transactionDetailTypeMappingsMultiCrudActive);

		if (component.transactionDetailTypeMappingsMultiCrudActive) {
			transactionDetailTypeMappingsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedtransactionDetailTypeMappingsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.transactionDetailTypeMappingsDisplayName + ' to Model'));

			expect(updatedtransactionDetailTypeMappingsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Transaction Detail Type Mappings entities from model when loading in edit mode', () => {
		component.targetModel = transactionDetailTypeWithId;
		component.targetModelId = transactionDetailTypeWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.transactionDetailTypeMappingsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const transactionDetailTypeMappingsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.transactionDetailTypeMappingsDisplayName + ' from Model')).length;

			expect(transactionDetailTypeMappingsRemoveButtonCount).toEqual(transactionDetailTypeWithId.transactionDetailTypeMappings.length);
		}
	});

});
