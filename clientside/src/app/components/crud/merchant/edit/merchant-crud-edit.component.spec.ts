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
	getMerchantCollectionModels,
	getCountMerchantModels,
	getMerchantModelWithId
} from 'src/app/models/merchant/merchant.model.selector';
import { MerchantCrudModule } from '../merchant-crud.module';
import { MerchantCrudEditComponent } from './merchant-crud-edit.component';
import {
	MerchantModelState,
	initialState as initialMerchantModelState
} from 'src/app/models/merchant/merchant.model.state';
import { MerchantDataFactory } from 'src/app/lib/utils/factories/merchant-data-factory';
import { MerchantModel } from 'src/app/models/merchant/merchant.model';
import { CrudTileMode } from '../merchant-crud.component';
import { getCashReceiptModelWithId } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { getCashReceiptCollectionModels } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { CashReceiptModel } from 'src/app/models/cashReceipt/cash_receipt.model';
import { CashReceiptDataFactory } from 'src/app/lib/utils/factories/cash-receipt-data-factory';
import { getMerchantSurchargeAndFeeModelWithId } from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model.selector';
import { getMerchantSurchargeAndFeeCollectionModels } from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model.selector';
import { MerchantSurchargeAndFeeModel } from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model';
import { MerchantSurchargeAndFeeDataFactory } from 'src/app/lib/utils/factories/merchant-surcharge-and-fee-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getRetailPharmacyInvoiceModelWithId } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { getRetailPharmacyInvoiceCollectionModels } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model.selector';
import { RetailPharmacyInvoiceModel } from 'src/app/models/retailPharmacyInvoice/retail_pharmacy_invoice.model';
import { RetailPharmacyInvoiceDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-invoice-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('Merchant CRUD Edit component tests', () => {
	let fixture: ComponentFixture<MerchantCrudEditComponent>
	let component: MerchantCrudEditComponent;

	let merchantModelState: MerchantModelState;

	let store: MockStore<{ model: MerchantModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let merchantCountBehaviorSubject: BehaviorSubject<number>;
	let merchantModelsBehaviorSubject: BehaviorSubject<MerchantModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let merchantSurchargeAndFeeModelsBehaviorSubject: BehaviorSubject<MerchantSurchargeAndFeeModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let retailPharmacyInvoiceModelsBehaviorSubject: BehaviorSubject<RetailPharmacyInvoiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const merchantFactory: MerchantDataFactory = new MerchantDataFactory();
	const defaultMerchantCount: number = 10;
	const defaultMerchantEntities: MerchantModel[] = merchantFactory.createAll(defaultMerchantCount);

	const cashReceiptFactory: CashReceiptDataFactory = new CashReceiptDataFactory();
	const defaultCashReceiptCount: number = 10;
	const defaultCashReceiptEntities: CashReceiptModel[] = cashReceiptFactory.createAll(defaultCashReceiptCount);

	const merchantSurchargeAndFeeFactory: MerchantSurchargeAndFeeDataFactory = new MerchantSurchargeAndFeeDataFactory();
	const defaultMerchantSurchargeAndFeeCount: number = 10;
	const defaultMerchantSurchargeAndFeeEntities: MerchantSurchargeAndFeeModel[] = merchantSurchargeAndFeeFactory.createAll(defaultMerchantSurchargeAndFeeCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const retailPharmacyInvoiceFactory: RetailPharmacyInvoiceDataFactory = new RetailPharmacyInvoiceDataFactory();
	const defaultRetailPharmacyInvoiceCount: number = 10;
	const defaultRetailPharmacyInvoiceEntities: RetailPharmacyInvoiceModel[] = retailPharmacyInvoiceFactory.createAll(defaultRetailPharmacyInvoiceCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let merchantWithId: MerchantModel = defaultMerchantEntities[0];
	let merchantModelWithIdBehaviorSubject: BehaviorSubject<MerchantModel>;

	merchantWithId.cashReceipts = defaultCashReceiptEntities;
	merchantWithId.cashReceiptsIds = merchantWithId.cashReceipts.map(cashReceipts => cashReceipts.id);

	merchantWithId.merchantSurchargeAndFees = defaultMerchantSurchargeAndFeeEntities;
	merchantWithId.merchantSurchargeAndFeesIds = merchantWithId.merchantSurchargeAndFees.map(merchantSurchargeAndFees => merchantSurchargeAndFees.id);


	const routerState: RouterState = {
		url: 'merchant-crud',
		urls: ['merchant-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: MerchantModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		merchantModelState = initialMerchantModelState;
		store.setState({model: merchantModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		merchantCountBehaviorSubject = new BehaviorSubject(defaultMerchantCount);

		// selectors for all references
		merchantModelsBehaviorSubject = new BehaviorSubject(defaultMerchantEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		merchantSurchargeAndFeeModelsBehaviorSubject = new BehaviorSubject(defaultMerchantSurchargeAndFeeEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		retailPharmacyInvoiceModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyInvoiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		merchantModelWithIdBehaviorSubject = new BehaviorSubject(merchantWithId);

		spyOn(store, 'select')
			.withArgs(getCountMerchantModels).and.returnValue(merchantCountBehaviorSubject)
			.withArgs(getMerchantModelWithId, merchantWithId.id).and.returnValue(merchantModelWithIdBehaviorSubject)
			.withArgs(getMerchantCollectionModels, jasmine.any(String)).and.returnValue(merchantModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getMerchantSurchargeAndFeeCollectionModels, jasmine.any(String)).and.returnValue(merchantSurchargeAndFeeModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getRetailPharmacyInvoiceCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyInvoiceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				MerchantCrudModule,
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

			fixture = TestBed.createComponent(MerchantCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new MerchantModel();
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
	it ('Renders the Merchant CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Cash Receipts relation.
	*
	* The button should only exist if cashReceiptsMultiCrudActive is true
	*/
	it ('Renders Cash Receipts Add Entity button in create mode', fakeAsync(() => {
		const cashReceiptsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!cashReceiptsButton).toEqual(component.cashReceiptsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Cash Receipts', fakeAsync(() => {
		const cashReceiptsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashReceiptsButton).toEqual(component.cashReceiptsMultiCrudActive);

		if (component.cashReceiptsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialCashReceiptsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model')).length;

			cashReceiptsButton.nativeElement.click();
			fixture.detectChanges();

			const actualCashReceiptsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model')).length;

			expect(actualCashReceiptsRemoveButtonCount).toEqual(initialCashReceiptsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Cash Receipts button', () => {
		const cashReceiptsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashReceiptsButton).toEqual(component.cashReceiptsMultiCrudActive);

		if (component.cashReceiptsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			cashReceiptsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialCashReceiptsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialCashReceiptsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualCashReceiptsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model'));

			expect(actualCashReceiptsRemoveButtons.length).toEqual(initialCashReceiptsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Cash Receipts button when one has already been added', () => {

		const cashReceiptsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!cashReceiptsButton).toEqual(component.cashReceiptsMultiCrudActive);

		if (component.cashReceiptsMultiCrudActive) {
			cashReceiptsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedcashReceiptsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.cashReceiptsDisplayName + ' to Model'));

			expect(updatedcashReceiptsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Cash Receipts entities from model when loading in edit mode', () => {
		component.targetModel = merchantWithId;
		component.targetModelId = merchantWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.cashReceiptsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const cashReceiptsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.cashReceiptsDisplayName + ' from Model')).length;

			expect(cashReceiptsRemoveButtonCount).toEqual(merchantWithId.cashReceipts.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Merchant Surcharge and Fees relation.
	*
	* The button should only exist if merchantSurchargeAndFeesMultiCrudActive is true
	*/
	it ('Renders Merchant Surcharge and Fees Add Entity button in create mode', fakeAsync(() => {
		const merchantSurchargeAndFeesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantSurchargeAndFeesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!merchantSurchargeAndFeesButton).toEqual(component.merchantSurchargeAndFeesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Merchant Surcharge and Fees', fakeAsync(() => {
		const merchantSurchargeAndFeesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantSurchargeAndFeesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!merchantSurchargeAndFeesButton).toEqual(component.merchantSurchargeAndFeesMultiCrudActive);

		if (component.merchantSurchargeAndFeesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMerchantSurchargeAndFeesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantSurchargeAndFeesDisplayName + ' from Model')).length;

			merchantSurchargeAndFeesButton.nativeElement.click();
			fixture.detectChanges();

			const actualMerchantSurchargeAndFeesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantSurchargeAndFeesDisplayName + ' from Model')).length;

			expect(actualMerchantSurchargeAndFeesRemoveButtonCount).toEqual(initialMerchantSurchargeAndFeesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Merchant Surcharge and Fees button', () => {
		const merchantSurchargeAndFeesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantSurchargeAndFeesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!merchantSurchargeAndFeesButton).toEqual(component.merchantSurchargeAndFeesMultiCrudActive);

		if (component.merchantSurchargeAndFeesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			merchantSurchargeAndFeesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMerchantSurchargeAndFeesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantSurchargeAndFeesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMerchantSurchargeAndFeesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMerchantSurchargeAndFeesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantSurchargeAndFeesDisplayName + ' from Model'));

			expect(actualMerchantSurchargeAndFeesRemoveButtons.length).toEqual(initialMerchantSurchargeAndFeesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Merchant Surcharge and Fees button when one has already been added', () => {

		const merchantSurchargeAndFeesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantSurchargeAndFeesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!merchantSurchargeAndFeesButton).toEqual(component.merchantSurchargeAndFeesMultiCrudActive);

		if (component.merchantSurchargeAndFeesMultiCrudActive) {
			merchantSurchargeAndFeesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmerchantSurchargeAndFeesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.merchantSurchargeAndFeesDisplayName + ' to Model'));

			expect(updatedmerchantSurchargeAndFeesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Merchant Surcharge and Fees entities from model when loading in edit mode', () => {
		component.targetModel = merchantWithId;
		component.targetModelId = merchantWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.merchantSurchargeAndFeesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const merchantSurchargeAndFeesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.merchantSurchargeAndFeesDisplayName + ' from Model')).length;

			expect(merchantSurchargeAndFeesRemoveButtonCount).toEqual(merchantWithId.merchantSurchargeAndFees.length);
		}
	});

});
