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
	getMerchantSurchargeAndFeeCollectionModels,
	getCountMerchantSurchargeAndFeeModels,
	getMerchantSurchargeAndFeeModelWithId
} from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model.selector';
import { MerchantSurchargeAndFeeCrudModule } from '../merchant-surcharge-and-fee-crud.module';
import { MerchantSurchargeAndFeeCrudEditComponent } from './merchant-surcharge-and-fee-crud-edit.component';
import {
	MerchantSurchargeAndFeeModelState,
	initialState as initialMerchantSurchargeAndFeeModelState
} from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model.state';
import { MerchantSurchargeAndFeeDataFactory } from 'src/app/lib/utils/factories/merchant-surcharge-and-fee-data-factory';
import { MerchantSurchargeAndFeeModel } from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model';
import { CrudTileMode } from '../merchant-surcharge-and-fee-crud.component';
import { getCashReceiptModelWithId } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { getCashReceiptCollectionModels } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { CashReceiptModel } from 'src/app/models/cashReceipt/cash_receipt.model';
import { CashReceiptDataFactory } from 'src/app/lib/utils/factories/cash-receipt-data-factory';
import { getMerchantModelWithId } from 'src/app/models/merchant/merchant.model.selector';
import { getMerchantCollectionModels } from 'src/app/models/merchant/merchant.model.selector';
import { MerchantModel } from 'src/app/models/merchant/merchant.model';
import { MerchantDataFactory } from 'src/app/lib/utils/factories/merchant-data-factory';

describe('Merchant Surcharge and Fee CRUD Edit component tests', () => {
	let fixture: ComponentFixture<MerchantSurchargeAndFeeCrudEditComponent>
	let component: MerchantSurchargeAndFeeCrudEditComponent;

	let merchantSurchargeAndFeeModelState: MerchantSurchargeAndFeeModelState;

	let store: MockStore<{ model: MerchantSurchargeAndFeeModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let merchantSurchargeAndFeeCountBehaviorSubject: BehaviorSubject<number>;
	let merchantSurchargeAndFeeModelsBehaviorSubject: BehaviorSubject<MerchantSurchargeAndFeeModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let merchantModelsBehaviorSubject: BehaviorSubject<MerchantModel[]>;

	const merchantSurchargeAndFeeFactory: MerchantSurchargeAndFeeDataFactory = new MerchantSurchargeAndFeeDataFactory();
	const defaultMerchantSurchargeAndFeeCount: number = 10;
	const defaultMerchantSurchargeAndFeeEntities: MerchantSurchargeAndFeeModel[] = merchantSurchargeAndFeeFactory.createAll(defaultMerchantSurchargeAndFeeCount);

	const cashReceiptFactory: CashReceiptDataFactory = new CashReceiptDataFactory();
	const defaultCashReceiptCount: number = 10;
	const defaultCashReceiptEntities: CashReceiptModel[] = cashReceiptFactory.createAll(defaultCashReceiptCount);

	const merchantFactory: MerchantDataFactory = new MerchantDataFactory();
	const defaultMerchantCount: number = 10;
	const defaultMerchantEntities: MerchantModel[] = merchantFactory.createAll(defaultMerchantCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let merchantSurchargeAndFeeWithId: MerchantSurchargeAndFeeModel = defaultMerchantSurchargeAndFeeEntities[0];
	let merchantSurchargeAndFeeModelWithIdBehaviorSubject: BehaviorSubject<MerchantSurchargeAndFeeModel>;

	merchantSurchargeAndFeeWithId.merchant = defaultMerchantEntities[0];
	merchantSurchargeAndFeeWithId.merchantId = merchantSurchargeAndFeeWithId.merchant.id;
	let merchantWithIdBehaviorSubject: BehaviorSubject<MerchantModel>;


	const routerState: RouterState = {
		url: 'merchant-surcharge-and-fee-crud',
		urls: ['merchant-surcharge-and-fee-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: MerchantSurchargeAndFeeModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		merchantSurchargeAndFeeModelState = initialMerchantSurchargeAndFeeModelState;
		store.setState({model: merchantSurchargeAndFeeModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		merchantSurchargeAndFeeCountBehaviorSubject = new BehaviorSubject(defaultMerchantSurchargeAndFeeCount);

		// selectors for all references
		merchantSurchargeAndFeeModelsBehaviorSubject = new BehaviorSubject(defaultMerchantSurchargeAndFeeEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		merchantModelsBehaviorSubject = new BehaviorSubject(defaultMerchantEntities);

		// selectors for target entity and its related entity
		merchantSurchargeAndFeeModelWithIdBehaviorSubject = new BehaviorSubject(merchantSurchargeAndFeeWithId);
		merchantWithIdBehaviorSubject = new BehaviorSubject(merchantSurchargeAndFeeWithId.merchant);

		spyOn(store, 'select')
			.withArgs(getCountMerchantSurchargeAndFeeModels).and.returnValue(merchantSurchargeAndFeeCountBehaviorSubject)
			.withArgs(getMerchantSurchargeAndFeeModelWithId, merchantSurchargeAndFeeWithId.id).and.returnValue(merchantSurchargeAndFeeModelWithIdBehaviorSubject)
			.withArgs(getMerchantSurchargeAndFeeCollectionModels, jasmine.any(String)).and.returnValue(merchantSurchargeAndFeeModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getMerchantCollectionModels, jasmine.any(String)).and.returnValue(merchantModelsBehaviorSubject)
			.withArgs(getMerchantModelWithId, merchantSurchargeAndFeeWithId.merchantId).and.returnValue(merchantWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				MerchantSurchargeAndFeeCrudModule,
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

			fixture = TestBed.createComponent(MerchantSurchargeAndFeeCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new MerchantSurchargeAndFeeModel();
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
	it ('Renders the Merchant Surcharge and Fee CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Merchant relation.
	*
	* The button should only exist if merchantMultiCrudActive is true
	*/
	it ('Renders Merchant Add Entity button in create mode', fakeAsync(() => {
		const merchantButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!merchantButton).toEqual(component.merchantMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Merchant', fakeAsync(() => {
		const merchantButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!merchantButton).toEqual(component.merchantMultiCrudActive);

		if (component.merchantMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMerchantRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantDisplayName + ' from Model')).length;

			merchantButton.nativeElement.click();
			fixture.detectChanges();

			const actualMerchantRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantDisplayName + ' from Model')).length;

			expect(actualMerchantRemoveButtonCount).toEqual(initialMerchantRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Merchant button', () => {
		const merchantButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!merchantButton).toEqual(component.merchantMultiCrudActive);

		if (component.merchantMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			merchantButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMerchantRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMerchantRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMerchantRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantDisplayName + ' from Model'));

			expect(actualMerchantRemoveButtons.length).toEqual(initialMerchantRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Merchant button when one has already been added', () => {

		const merchantButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!merchantButton).toEqual(component.merchantMultiCrudActive);

		if (component.merchantMultiCrudActive) {
			merchantButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmerchantButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantDisplayName + ' to Model'));

			expect(updatedmerchantButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Merchant entities from model when loading in edit mode', () => {
		component.targetModel = merchantSurchargeAndFeeWithId;
		component.targetModelId = merchantSurchargeAndFeeWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.merchantMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const merchantRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantDisplayName + ' from Model')).length;

			expect(merchantRemoveButtonCount).toEqual(1);
		}
	});

});
