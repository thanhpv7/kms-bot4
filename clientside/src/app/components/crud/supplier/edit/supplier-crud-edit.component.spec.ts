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
	getSupplierCollectionModels,
	getCountSupplierModels,
	getSupplierModelWithId
} from 'src/app/models/supplier/supplier.model.selector';
import { SupplierCrudModule } from '../supplier-crud.module';
import { SupplierCrudEditComponent } from './supplier-crud-edit.component';
import {
	SupplierModelState,
	initialState as initialSupplierModelState
} from 'src/app/models/supplier/supplier.model.state';
import { SupplierDataFactory } from 'src/app/lib/utils/factories/supplier-data-factory';
import { SupplierModel } from 'src/app/models/supplier/supplier.model';
import { CrudTileMode } from '../supplier-crud.component';
import { getGoodsReceiveNoteModelWithId } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import { getGoodsReceiveNoteCollectionModels } from 'src/app/models/goodsReceiveNote/goods_receive_note.model.selector';
import { GoodsReceiveNoteModel } from 'src/app/models/goodsReceiveNote/goods_receive_note.model';
import { GoodsReceiveNoteDataFactory } from 'src/app/lib/utils/factories/goods-receive-note-data-factory';
import { getGoodsReceiveNoteItemModelWithId } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model.selector';
import { getGoodsReceiveNoteItemCollectionModels } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model.selector';
import { GoodsReceiveNoteItemModel } from 'src/app/models/goodsReceiveNoteItem/goods_receive_note_item.model';
import { GoodsReceiveNoteItemDataFactory } from 'src/app/lib/utils/factories/goods-receive-note-item-data-factory';
import { getPurchaseOrderModelWithId } from 'src/app/models/purchaseOrder/purchase_order.model.selector';
import { getPurchaseOrderCollectionModels } from 'src/app/models/purchaseOrder/purchase_order.model.selector';
import { PurchaseOrderModel } from 'src/app/models/purchaseOrder/purchase_order.model';
import { PurchaseOrderDataFactory } from 'src/app/lib/utils/factories/purchase-order-data-factory';
import { getPurchaseOrderStockDetailModelWithId } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model.selector';
import { getPurchaseOrderStockDetailCollectionModels } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model.selector';
import { PurchaseOrderStockDetailModel } from 'src/app/models/purchaseOrderStockDetail/purchase_order_stock_detail.model';
import { PurchaseOrderStockDetailDataFactory } from 'src/app/lib/utils/factories/purchase-order-stock-detail-data-factory';
import { getPurchaseRequisitionModelWithId } from 'src/app/models/purchaseRequisition/purchase_requisition.model.selector';
import { getPurchaseRequisitionCollectionModels } from 'src/app/models/purchaseRequisition/purchase_requisition.model.selector';
import { PurchaseRequisitionModel } from 'src/app/models/purchaseRequisition/purchase_requisition.model';
import { PurchaseRequisitionDataFactory } from 'src/app/lib/utils/factories/purchase-requisition-data-factory';
import { getPurchaseRequisitionStockDetailModelWithId } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.selector';
import { getPurchaseRequisitionStockDetailCollectionModels } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model.selector';
import { PurchaseRequisitionStockDetailModel } from 'src/app/models/purchaseRequisitionStockDetail/purchase_requisition_stock_detail.model';
import { PurchaseRequisitionStockDetailDataFactory } from 'src/app/lib/utils/factories/purchase-requisition-stock-detail-data-factory';
import { getReturnSupplierModelWithId } from 'src/app/models/returnSupplier/return_supplier.model.selector';
import { getReturnSupplierCollectionModels } from 'src/app/models/returnSupplier/return_supplier.model.selector';
import { ReturnSupplierModel } from 'src/app/models/returnSupplier/return_supplier.model';
import { ReturnSupplierDataFactory } from 'src/app/lib/utils/factories/return-supplier-data-factory';
import { getReturnSupplierStockDetailModelWithId } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model.selector';
import { getReturnSupplierStockDetailCollectionModels } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model.selector';
import { ReturnSupplierStockDetailModel } from 'src/app/models/returnSupplierStockDetail/return_supplier_stock_detail.model';
import { ReturnSupplierStockDetailDataFactory } from 'src/app/lib/utils/factories/return-supplier-stock-detail-data-factory';
import { getStockCatalogueModelWithId } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { getStockCatalogueCollectionModels } from 'src/app/models/stockCatalogue/stock_catalogue.model.selector';
import { StockCatalogueModel } from 'src/app/models/stockCatalogue/stock_catalogue.model';
import { StockCatalogueDataFactory } from 'src/app/lib/utils/factories/stock-catalogue-data-factory';
import { getSupplierBankAccountModelWithId } from 'src/app/models/supplierBankAccount/supplier_bank_account.model.selector';
import { getSupplierBankAccountCollectionModels } from 'src/app/models/supplierBankAccount/supplier_bank_account.model.selector';
import { SupplierBankAccountModel } from 'src/app/models/supplierBankAccount/supplier_bank_account.model';
import { SupplierBankAccountDataFactory } from 'src/app/lib/utils/factories/supplier-bank-account-data-factory';
import { getSupplierContactDetailModelWithId } from 'src/app/models/supplierContactDetail/supplier_contact_detail.model.selector';
import { getSupplierContactDetailCollectionModels } from 'src/app/models/supplierContactDetail/supplier_contact_detail.model.selector';
import { SupplierContactDetailModel } from 'src/app/models/supplierContactDetail/supplier_contact_detail.model';
import { SupplierContactDetailDataFactory } from 'src/app/lib/utils/factories/supplier-contact-detail-data-factory';
import { getSupplierProductDetailModelWithId } from 'src/app/models/supplierProductDetail/supplier_product_detail.model.selector';
import { getSupplierProductDetailCollectionModels } from 'src/app/models/supplierProductDetail/supplier_product_detail.model.selector';
import { SupplierProductDetailModel } from 'src/app/models/supplierProductDetail/supplier_product_detail.model';
import { SupplierProductDetailDataFactory } from 'src/app/lib/utils/factories/supplier-product-detail-data-factory';
import { getWarehouseModelWithId } from 'src/app/models/warehouse/warehouse.model.selector';
import { getWarehouseCollectionModels } from 'src/app/models/warehouse/warehouse.model.selector';
import { WarehouseModel } from 'src/app/models/warehouse/warehouse.model';
import { WarehouseDataFactory } from 'src/app/lib/utils/factories/warehouse-data-factory';

describe('Supplier CRUD Edit component tests', () => {
	let fixture: ComponentFixture<SupplierCrudEditComponent>
	let component: SupplierCrudEditComponent;

	let supplierModelState: SupplierModelState;

	let store: MockStore<{ model: SupplierModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let supplierCountBehaviorSubject: BehaviorSubject<number>;
	let supplierModelsBehaviorSubject: BehaviorSubject<SupplierModel[]>;
	let goodsReceiveNoteModelsBehaviorSubject: BehaviorSubject<GoodsReceiveNoteModel[]>;
	let goodsReceiveNoteItemModelsBehaviorSubject: BehaviorSubject<GoodsReceiveNoteItemModel[]>;
	let purchaseOrderModelsBehaviorSubject: BehaviorSubject<PurchaseOrderModel[]>;
	let purchaseOrderStockDetailModelsBehaviorSubject: BehaviorSubject<PurchaseOrderStockDetailModel[]>;
	let purchaseRequisitionModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionModel[]>;
	let purchaseRequisitionStockDetailModelsBehaviorSubject: BehaviorSubject<PurchaseRequisitionStockDetailModel[]>;
	let returnSupplierModelsBehaviorSubject: BehaviorSubject<ReturnSupplierModel[]>;
	let returnSupplierStockDetailModelsBehaviorSubject: BehaviorSubject<ReturnSupplierStockDetailModel[]>;
	let stockCatalogueModelsBehaviorSubject: BehaviorSubject<StockCatalogueModel[]>;
	let supplierBankAccountModelsBehaviorSubject: BehaviorSubject<SupplierBankAccountModel[]>;
	let supplierContactDetailModelsBehaviorSubject: BehaviorSubject<SupplierContactDetailModel[]>;
	let supplierProductDetailModelsBehaviorSubject: BehaviorSubject<SupplierProductDetailModel[]>;
	let warehouseModelsBehaviorSubject: BehaviorSubject<WarehouseModel[]>;

	const supplierFactory: SupplierDataFactory = new SupplierDataFactory();
	const defaultSupplierCount: number = 10;
	const defaultSupplierEntities: SupplierModel[] = supplierFactory.createAll(defaultSupplierCount);

	const goodsReceiveNoteFactory: GoodsReceiveNoteDataFactory = new GoodsReceiveNoteDataFactory();
	const defaultGoodsReceiveNoteCount: number = 10;
	const defaultGoodsReceiveNoteEntities: GoodsReceiveNoteModel[] = goodsReceiveNoteFactory.createAll(defaultGoodsReceiveNoteCount);

	const goodsReceiveNoteItemFactory: GoodsReceiveNoteItemDataFactory = new GoodsReceiveNoteItemDataFactory();
	const defaultGoodsReceiveNoteItemCount: number = 10;
	const defaultGoodsReceiveNoteItemEntities: GoodsReceiveNoteItemModel[] = goodsReceiveNoteItemFactory.createAll(defaultGoodsReceiveNoteItemCount);

	const purchaseOrderFactory: PurchaseOrderDataFactory = new PurchaseOrderDataFactory();
	const defaultPurchaseOrderCount: number = 10;
	const defaultPurchaseOrderEntities: PurchaseOrderModel[] = purchaseOrderFactory.createAll(defaultPurchaseOrderCount);

	const purchaseOrderStockDetailFactory: PurchaseOrderStockDetailDataFactory = new PurchaseOrderStockDetailDataFactory();
	const defaultPurchaseOrderStockDetailCount: number = 10;
	const defaultPurchaseOrderStockDetailEntities: PurchaseOrderStockDetailModel[] = purchaseOrderStockDetailFactory.createAll(defaultPurchaseOrderStockDetailCount);

	const purchaseRequisitionFactory: PurchaseRequisitionDataFactory = new PurchaseRequisitionDataFactory();
	const defaultPurchaseRequisitionCount: number = 10;
	const defaultPurchaseRequisitionEntities: PurchaseRequisitionModel[] = purchaseRequisitionFactory.createAll(defaultPurchaseRequisitionCount);

	const purchaseRequisitionStockDetailFactory: PurchaseRequisitionStockDetailDataFactory = new PurchaseRequisitionStockDetailDataFactory();
	const defaultPurchaseRequisitionStockDetailCount: number = 10;
	const defaultPurchaseRequisitionStockDetailEntities: PurchaseRequisitionStockDetailModel[] = purchaseRequisitionStockDetailFactory.createAll(defaultPurchaseRequisitionStockDetailCount);

	const returnSupplierFactory: ReturnSupplierDataFactory = new ReturnSupplierDataFactory();
	const defaultReturnSupplierCount: number = 10;
	const defaultReturnSupplierEntities: ReturnSupplierModel[] = returnSupplierFactory.createAll(defaultReturnSupplierCount);

	const returnSupplierStockDetailFactory: ReturnSupplierStockDetailDataFactory = new ReturnSupplierStockDetailDataFactory();
	const defaultReturnSupplierStockDetailCount: number = 10;
	const defaultReturnSupplierStockDetailEntities: ReturnSupplierStockDetailModel[] = returnSupplierStockDetailFactory.createAll(defaultReturnSupplierStockDetailCount);

	const stockCatalogueFactory: StockCatalogueDataFactory = new StockCatalogueDataFactory();
	const defaultStockCatalogueCount: number = 10;
	const defaultStockCatalogueEntities: StockCatalogueModel[] = stockCatalogueFactory.createAll(defaultStockCatalogueCount);

	const supplierBankAccountFactory: SupplierBankAccountDataFactory = new SupplierBankAccountDataFactory();
	const defaultSupplierBankAccountCount: number = 10;
	const defaultSupplierBankAccountEntities: SupplierBankAccountModel[] = supplierBankAccountFactory.createAll(defaultSupplierBankAccountCount);

	const supplierContactDetailFactory: SupplierContactDetailDataFactory = new SupplierContactDetailDataFactory();
	const defaultSupplierContactDetailCount: number = 10;
	const defaultSupplierContactDetailEntities: SupplierContactDetailModel[] = supplierContactDetailFactory.createAll(defaultSupplierContactDetailCount);

	const supplierProductDetailFactory: SupplierProductDetailDataFactory = new SupplierProductDetailDataFactory();
	const defaultSupplierProductDetailCount: number = 10;
	const defaultSupplierProductDetailEntities: SupplierProductDetailModel[] = supplierProductDetailFactory.createAll(defaultSupplierProductDetailCount);

	const warehouseFactory: WarehouseDataFactory = new WarehouseDataFactory();
	const defaultWarehouseCount: number = 10;
	const defaultWarehouseEntities: WarehouseModel[] = warehouseFactory.createAll(defaultWarehouseCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let supplierWithId: SupplierModel = defaultSupplierEntities[0];
	let supplierModelWithIdBehaviorSubject: BehaviorSubject<SupplierModel>;

	supplierWithId.goodsReceiveNotes = defaultGoodsReceiveNoteEntities;
	supplierWithId.goodsReceiveNotesIds = supplierWithId.goodsReceiveNotes.map(goodsReceiveNotes => goodsReceiveNotes.id);

	supplierWithId.purchaseOrders = defaultPurchaseOrderEntities;
	supplierWithId.purchaseOrdersIds = supplierWithId.purchaseOrders.map(purchaseOrders => purchaseOrders.id);

	supplierWithId.purchaseRequisitions = defaultPurchaseRequisitionEntities;
	supplierWithId.purchaseRequisitionsIds = supplierWithId.purchaseRequisitions.map(purchaseRequisitions => purchaseRequisitions.id);

	supplierWithId.returnSuppliers = defaultReturnSupplierEntities;
	supplierWithId.returnSuppliersIds = supplierWithId.returnSuppliers.map(returnSuppliers => returnSuppliers.id);

	supplierWithId.suplierContactDetails = defaultSupplierContactDetailEntities;
	supplierWithId.suplierContactDetailsIds = supplierWithId.suplierContactDetails.map(suplierContactDetails => suplierContactDetails.id);

	supplierWithId.supplierBankAccounts = defaultSupplierBankAccountEntities;
	supplierWithId.supplierBankAccountsIds = supplierWithId.supplierBankAccounts.map(supplierBankAccounts => supplierBankAccounts.id);

	supplierWithId.supplierProductDetails = defaultSupplierProductDetailEntities;
	supplierWithId.supplierProductDetailsIds = supplierWithId.supplierProductDetails.map(supplierProductDetails => supplierProductDetails.id);


	const routerState: RouterState = {
		url: 'supplier-crud',
		urls: ['supplier-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: SupplierModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		supplierModelState = initialSupplierModelState;
		store.setState({model: supplierModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		supplierCountBehaviorSubject = new BehaviorSubject(defaultSupplierCount);

		// selectors for all references
		supplierModelsBehaviorSubject = new BehaviorSubject(defaultSupplierEntities);
		goodsReceiveNoteModelsBehaviorSubject = new BehaviorSubject(defaultGoodsReceiveNoteEntities);
		goodsReceiveNoteItemModelsBehaviorSubject = new BehaviorSubject(defaultGoodsReceiveNoteItemEntities);
		purchaseOrderModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderEntities);
		purchaseOrderStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseOrderStockDetailEntities);
		purchaseRequisitionModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionEntities);
		purchaseRequisitionStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultPurchaseRequisitionStockDetailEntities);
		returnSupplierModelsBehaviorSubject = new BehaviorSubject(defaultReturnSupplierEntities);
		returnSupplierStockDetailModelsBehaviorSubject = new BehaviorSubject(defaultReturnSupplierStockDetailEntities);
		stockCatalogueModelsBehaviorSubject = new BehaviorSubject(defaultStockCatalogueEntities);
		supplierBankAccountModelsBehaviorSubject = new BehaviorSubject(defaultSupplierBankAccountEntities);
		supplierContactDetailModelsBehaviorSubject = new BehaviorSubject(defaultSupplierContactDetailEntities);
		supplierProductDetailModelsBehaviorSubject = new BehaviorSubject(defaultSupplierProductDetailEntities);
		warehouseModelsBehaviorSubject = new BehaviorSubject(defaultWarehouseEntities);

		// selectors for target entity and its related entity
		supplierModelWithIdBehaviorSubject = new BehaviorSubject(supplierWithId);

		spyOn(store, 'select')
			.withArgs(getCountSupplierModels).and.returnValue(supplierCountBehaviorSubject)
			.withArgs(getSupplierModelWithId, supplierWithId.id).and.returnValue(supplierModelWithIdBehaviorSubject)
			.withArgs(getSupplierCollectionModels, jasmine.any(String)).and.returnValue(supplierModelsBehaviorSubject)
			.withArgs(getGoodsReceiveNoteCollectionModels, jasmine.any(String)).and.returnValue(goodsReceiveNoteModelsBehaviorSubject)
			.withArgs(getGoodsReceiveNoteItemCollectionModels, jasmine.any(String)).and.returnValue(goodsReceiveNoteItemModelsBehaviorSubject)
			.withArgs(getPurchaseOrderCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderModelsBehaviorSubject)
			.withArgs(getPurchaseOrderStockDetailCollectionModels, jasmine.any(String)).and.returnValue(purchaseOrderStockDetailModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionModelsBehaviorSubject)
			.withArgs(getPurchaseRequisitionStockDetailCollectionModels, jasmine.any(String)).and.returnValue(purchaseRequisitionStockDetailModelsBehaviorSubject)
			.withArgs(getReturnSupplierCollectionModels, jasmine.any(String)).and.returnValue(returnSupplierModelsBehaviorSubject)
			.withArgs(getReturnSupplierStockDetailCollectionModels, jasmine.any(String)).and.returnValue(returnSupplierStockDetailModelsBehaviorSubject)
			.withArgs(getStockCatalogueCollectionModels, jasmine.any(String)).and.returnValue(stockCatalogueModelsBehaviorSubject)
			.withArgs(getSupplierBankAccountCollectionModels, jasmine.any(String)).and.returnValue(supplierBankAccountModelsBehaviorSubject)
			.withArgs(getSupplierContactDetailCollectionModels, jasmine.any(String)).and.returnValue(supplierContactDetailModelsBehaviorSubject)
			.withArgs(getSupplierProductDetailCollectionModels, jasmine.any(String)).and.returnValue(supplierProductDetailModelsBehaviorSubject)
			.withArgs(getWarehouseCollectionModels, jasmine.any(String)).and.returnValue(warehouseModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				SupplierCrudModule,
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

			fixture = TestBed.createComponent(SupplierCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new SupplierModel();
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
	it ('Renders the Supplier CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Goods Receive Notes relation.
	*
	* The button should only exist if goodsReceiveNotesMultiCrudActive is true
	*/
	it ('Renders Goods Receive Notes Add Entity button in create mode', fakeAsync(() => {
		const goodsReceiveNotesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!goodsReceiveNotesButton).toEqual(component.goodsReceiveNotesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Goods Receive Notes', fakeAsync(() => {
		const goodsReceiveNotesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNotesButton).toEqual(component.goodsReceiveNotesMultiCrudActive);

		if (component.goodsReceiveNotesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialGoodsReceiveNotesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model')).length;

			goodsReceiveNotesButton.nativeElement.click();
			fixture.detectChanges();

			const actualGoodsReceiveNotesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model')).length;

			expect(actualGoodsReceiveNotesRemoveButtonCount).toEqual(initialGoodsReceiveNotesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Goods Receive Notes button', () => {
		const goodsReceiveNotesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNotesButton).toEqual(component.goodsReceiveNotesMultiCrudActive);

		if (component.goodsReceiveNotesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			goodsReceiveNotesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialGoodsReceiveNotesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialGoodsReceiveNotesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualGoodsReceiveNotesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model'));

			expect(actualGoodsReceiveNotesRemoveButtons.length).toEqual(initialGoodsReceiveNotesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Goods Receive Notes button when one has already been added', () => {

		const goodsReceiveNotesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!goodsReceiveNotesButton).toEqual(component.goodsReceiveNotesMultiCrudActive);

		if (component.goodsReceiveNotesMultiCrudActive) {
			goodsReceiveNotesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedgoodsReceiveNotesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.goodsReceiveNotesDisplayName + ' to Model'));

			expect(updatedgoodsReceiveNotesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Goods Receive Notes entities from model when loading in edit mode', () => {
		component.targetModel = supplierWithId;
		component.targetModelId = supplierWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.goodsReceiveNotesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const goodsReceiveNotesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.goodsReceiveNotesDisplayName + ' from Model')).length;

			expect(goodsReceiveNotesRemoveButtonCount).toEqual(supplierWithId.goodsReceiveNotes.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Purchase Orders relation.
	*
	* The button should only exist if purchaseOrdersMultiCrudActive is true
	*/
	it ('Renders Purchase Orders Add Entity button in create mode', fakeAsync(() => {
		const purchaseOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!purchaseOrdersButton).toEqual(component.purchaseOrdersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Purchase Orders', fakeAsync(() => {
		const purchaseOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseOrdersButton).toEqual(component.purchaseOrdersMultiCrudActive);

		if (component.purchaseOrdersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPurchaseOrdersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model')).length;

			purchaseOrdersButton.nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseOrdersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model')).length;

			expect(actualPurchaseOrdersRemoveButtonCount).toEqual(initialPurchaseOrdersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Purchase Orders button', () => {
		const purchaseOrdersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseOrdersButton).toEqual(component.purchaseOrdersMultiCrudActive);

		if (component.purchaseOrdersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			purchaseOrdersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPurchaseOrdersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPurchaseOrdersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseOrdersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model'));

			expect(actualPurchaseOrdersRemoveButtons.length).toEqual(initialPurchaseOrdersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Purchase Orders button when one has already been added', () => {

		const purchaseOrdersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseOrdersButton).toEqual(component.purchaseOrdersMultiCrudActive);

		if (component.purchaseOrdersMultiCrudActive) {
			purchaseOrdersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpurchaseOrdersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseOrdersDisplayName + ' to Model'));

			expect(updatedpurchaseOrdersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Purchase Orders entities from model when loading in edit mode', () => {
		component.targetModel = supplierWithId;
		component.targetModelId = supplierWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.purchaseOrdersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const purchaseOrdersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseOrdersDisplayName + ' from Model')).length;

			expect(purchaseOrdersRemoveButtonCount).toEqual(supplierWithId.purchaseOrders.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Purchase Requisitions relation.
	*
	* The button should only exist if purchaseRequisitionsMultiCrudActive is true
	*/
	it ('Renders Purchase Requisitions Add Entity button in create mode', fakeAsync(() => {
		const purchaseRequisitionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!purchaseRequisitionsButton).toEqual(component.purchaseRequisitionsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Purchase Requisitions', fakeAsync(() => {
		const purchaseRequisitionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseRequisitionsButton).toEqual(component.purchaseRequisitionsMultiCrudActive);

		if (component.purchaseRequisitionsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPurchaseRequisitionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model')).length;

			purchaseRequisitionsButton.nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseRequisitionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model')).length;

			expect(actualPurchaseRequisitionsRemoveButtonCount).toEqual(initialPurchaseRequisitionsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Purchase Requisitions button', () => {
		const purchaseRequisitionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseRequisitionsButton).toEqual(component.purchaseRequisitionsMultiCrudActive);

		if (component.purchaseRequisitionsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			purchaseRequisitionsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPurchaseRequisitionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPurchaseRequisitionsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPurchaseRequisitionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model'));

			expect(actualPurchaseRequisitionsRemoveButtons.length).toEqual(initialPurchaseRequisitionsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Purchase Requisitions button when one has already been added', () => {

		const purchaseRequisitionsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!purchaseRequisitionsButton).toEqual(component.purchaseRequisitionsMultiCrudActive);

		if (component.purchaseRequisitionsMultiCrudActive) {
			purchaseRequisitionsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpurchaseRequisitionsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.purchaseRequisitionsDisplayName + ' to Model'));

			expect(updatedpurchaseRequisitionsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Purchase Requisitions entities from model when loading in edit mode', () => {
		component.targetModel = supplierWithId;
		component.targetModelId = supplierWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.purchaseRequisitionsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const purchaseRequisitionsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.purchaseRequisitionsDisplayName + ' from Model')).length;

			expect(purchaseRequisitionsRemoveButtonCount).toEqual(supplierWithId.purchaseRequisitions.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Return Suppliers relation.
	*
	* The button should only exist if returnSuppliersMultiCrudActive is true
	*/
	it ('Renders Return Suppliers Add Entity button in create mode', fakeAsync(() => {
		const returnSuppliersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!returnSuppliersButton).toEqual(component.returnSuppliersMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Return Suppliers', fakeAsync(() => {
		const returnSuppliersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!returnSuppliersButton).toEqual(component.returnSuppliersMultiCrudActive);

		if (component.returnSuppliersMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialReturnSuppliersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model')).length;

			returnSuppliersButton.nativeElement.click();
			fixture.detectChanges();

			const actualReturnSuppliersRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model')).length;

			expect(actualReturnSuppliersRemoveButtonCount).toEqual(initialReturnSuppliersRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Return Suppliers button', () => {
		const returnSuppliersButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!returnSuppliersButton).toEqual(component.returnSuppliersMultiCrudActive);

		if (component.returnSuppliersMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			returnSuppliersButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialReturnSuppliersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialReturnSuppliersRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualReturnSuppliersRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model'));

			expect(actualReturnSuppliersRemoveButtons.length).toEqual(initialReturnSuppliersRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Return Suppliers button when one has already been added', () => {

		const returnSuppliersButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!returnSuppliersButton).toEqual(component.returnSuppliersMultiCrudActive);

		if (component.returnSuppliersMultiCrudActive) {
			returnSuppliersButton.nativeElement.click();
			fixture.detectChanges();

			const updatedreturnSuppliersButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.returnSuppliersDisplayName + ' to Model'));

			expect(updatedreturnSuppliersButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Return Suppliers entities from model when loading in edit mode', () => {
		component.targetModel = supplierWithId;
		component.targetModelId = supplierWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.returnSuppliersMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const returnSuppliersRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.returnSuppliersDisplayName + ' from Model')).length;

			expect(returnSuppliersRemoveButtonCount).toEqual(supplierWithId.returnSuppliers.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Suplier Contact Details relation.
	*
	* The button should only exist if suplierContactDetailsMultiCrudActive is true
	*/
	it ('Renders Suplier Contact Details Add Entity button in create mode', fakeAsync(() => {
		const suplierContactDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.suplierContactDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!suplierContactDetailsButton).toEqual(component.suplierContactDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Suplier Contact Details', fakeAsync(() => {
		const suplierContactDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.suplierContactDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!suplierContactDetailsButton).toEqual(component.suplierContactDetailsMultiCrudActive);

		if (component.suplierContactDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSuplierContactDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.suplierContactDetailsDisplayName + ' from Model')).length;

			suplierContactDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualSuplierContactDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.suplierContactDetailsDisplayName + ' from Model')).length;

			expect(actualSuplierContactDetailsRemoveButtonCount).toEqual(initialSuplierContactDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Suplier Contact Details button', () => {
		const suplierContactDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.suplierContactDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!suplierContactDetailsButton).toEqual(component.suplierContactDetailsMultiCrudActive);

		if (component.suplierContactDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			suplierContactDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSuplierContactDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.suplierContactDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSuplierContactDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSuplierContactDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.suplierContactDetailsDisplayName + ' from Model'));

			expect(actualSuplierContactDetailsRemoveButtons.length).toEqual(initialSuplierContactDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Suplier Contact Details button when one has already been added', () => {

		const suplierContactDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.suplierContactDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!suplierContactDetailsButton).toEqual(component.suplierContactDetailsMultiCrudActive);

		if (component.suplierContactDetailsMultiCrudActive) {
			suplierContactDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsuplierContactDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.suplierContactDetailsDisplayName + ' to Model'));

			expect(updatedsuplierContactDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Suplier Contact Details entities from model when loading in edit mode', () => {
		component.targetModel = supplierWithId;
		component.targetModelId = supplierWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.suplierContactDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const suplierContactDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.suplierContactDetailsDisplayName + ' from Model')).length;

			expect(suplierContactDetailsRemoveButtonCount).toEqual(supplierWithId.suplierContactDetails.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Supplier Bank Accounts relation.
	*
	* The button should only exist if supplierBankAccountsMultiCrudActive is true
	*/
	it ('Renders Supplier Bank Accounts Add Entity button in create mode', fakeAsync(() => {
		const supplierBankAccountsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierBankAccountsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!supplierBankAccountsButton).toEqual(component.supplierBankAccountsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Supplier Bank Accounts', fakeAsync(() => {
		const supplierBankAccountsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierBankAccountsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!supplierBankAccountsButton).toEqual(component.supplierBankAccountsMultiCrudActive);

		if (component.supplierBankAccountsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSupplierBankAccountsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierBankAccountsDisplayName + ' from Model')).length;

			supplierBankAccountsButton.nativeElement.click();
			fixture.detectChanges();

			const actualSupplierBankAccountsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierBankAccountsDisplayName + ' from Model')).length;

			expect(actualSupplierBankAccountsRemoveButtonCount).toEqual(initialSupplierBankAccountsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Supplier Bank Accounts button', () => {
		const supplierBankAccountsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierBankAccountsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!supplierBankAccountsButton).toEqual(component.supplierBankAccountsMultiCrudActive);

		if (component.supplierBankAccountsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			supplierBankAccountsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSupplierBankAccountsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierBankAccountsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSupplierBankAccountsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSupplierBankAccountsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierBankAccountsDisplayName + ' from Model'));

			expect(actualSupplierBankAccountsRemoveButtons.length).toEqual(initialSupplierBankAccountsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Supplier Bank Accounts button when one has already been added', () => {

		const supplierBankAccountsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierBankAccountsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!supplierBankAccountsButton).toEqual(component.supplierBankAccountsMultiCrudActive);

		if (component.supplierBankAccountsMultiCrudActive) {
			supplierBankAccountsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsupplierBankAccountsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierBankAccountsDisplayName + ' to Model'));

			expect(updatedsupplierBankAccountsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Supplier Bank Accounts entities from model when loading in edit mode', () => {
		component.targetModel = supplierWithId;
		component.targetModelId = supplierWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.supplierBankAccountsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const supplierBankAccountsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierBankAccountsDisplayName + ' from Model')).length;

			expect(supplierBankAccountsRemoveButtonCount).toEqual(supplierWithId.supplierBankAccounts.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Supplier Product Details relation.
	*
	* The button should only exist if supplierProductDetailsMultiCrudActive is true
	*/
	it ('Renders Supplier Product Details Add Entity button in create mode', fakeAsync(() => {
		const supplierProductDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!supplierProductDetailsButton).toEqual(component.supplierProductDetailsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Supplier Product Details', fakeAsync(() => {
		const supplierProductDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!supplierProductDetailsButton).toEqual(component.supplierProductDetailsMultiCrudActive);

		if (component.supplierProductDetailsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialSupplierProductDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model')).length;

			supplierProductDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const actualSupplierProductDetailsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model')).length;

			expect(actualSupplierProductDetailsRemoveButtonCount).toEqual(initialSupplierProductDetailsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Supplier Product Details button', () => {
		const supplierProductDetailsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!supplierProductDetailsButton).toEqual(component.supplierProductDetailsMultiCrudActive);

		if (component.supplierProductDetailsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			supplierProductDetailsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialSupplierProductDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialSupplierProductDetailsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualSupplierProductDetailsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model'));

			expect(actualSupplierProductDetailsRemoveButtons.length).toEqual(initialSupplierProductDetailsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Supplier Product Details button when one has already been added', () => {

		const supplierProductDetailsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!supplierProductDetailsButton).toEqual(component.supplierProductDetailsMultiCrudActive);

		if (component.supplierProductDetailsMultiCrudActive) {
			supplierProductDetailsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedsupplierProductDetailsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.supplierProductDetailsDisplayName + ' to Model'));

			expect(updatedsupplierProductDetailsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Supplier Product Details entities from model when loading in edit mode', () => {
		component.targetModel = supplierWithId;
		component.targetModelId = supplierWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.supplierProductDetailsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const supplierProductDetailsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.supplierProductDetailsDisplayName + ' from Model')).length;

			expect(supplierProductDetailsRemoveButtonCount).toEqual(supplierWithId.supplierProductDetails.length);
		}
	});

});
