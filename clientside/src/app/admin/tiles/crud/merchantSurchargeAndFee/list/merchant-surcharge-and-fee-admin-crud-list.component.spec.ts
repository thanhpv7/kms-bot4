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

import {DebugElement} from '@angular/core';
import {waitForAsync, TestBed} from '@angular/core/testing';
import {By} from '@angular/platform-browser';
import {Store} from '@ngrx/store';
import {MockStore, provideMockStore} from '@ngrx/store/testing';
import {BehaviorSubject} from 'rxjs';
import {RouterState} from 'src/app/models/model.state';
import {AdminMerchantSurchargeAndFeeCrudListComponent} from './merchant-surcharge-and-fee-admin-crud-list.component';
import {MerchantSurchargeAndFeeDataFactory} from 'src/app/lib/utils/factories/merchant-surcharge-and-fee-data-factory';
import {MerchantSurchargeAndFeeModel} from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model';
import {AdminMerchantSurchargeAndFeeCrudModule} from '../merchant-surcharge-and-fee-admin-crud.module';
import {
	MerchantSurchargeAndFeeModelState,
	initialState as initialMerchantSurchargeAndFeeModelState
} from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model.state';
import {getRouterState} from 'src/app/models/model.selector';
import {
	getMerchantSurchargeAndFeeCollectionCount,
	getMerchantSurchargeAndFeeCollectionModels
} from 'src/app/models/merchantSurchargeAndFee/merchant_surcharge_and_fee.model.selector';
import {ActivatedRouteStub} from 'src/app/../testing/helpers/activated-route-stub';
import {ActivatedRoute} from '@angular/router';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import {CookieService} from 'ngx-cookie-service';
import { ModalDialogService, ModalDialogInstanceService } from '@preeco-privacy/ngx-modal-dialog';
import { IconPosition } from 'src/app/lib/components/button/button.component';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

function collectionActions(canCreate: boolean) {
	return [
		{
			label: 'Create',
			icon: 'create',
			iconPos: IconPosition.TOP,
			showIcon: true,
			isAdditional: false,
			disableOption: () => !canCreate
		},
	];
}

function itemActions(canEdit: boolean, canDelete: boolean) {
	return [
		{
			label: 'View',
			icon: 'look',
			iconPos: IconPosition.TOP,
			showIcon: true,
			isAdditional: false
		},
		{
			label: 'Edit',
			icon: 'edit',
			iconPos: IconPosition.TOP,
			showIcon: true,
			isAdditional: false,
			disableOption: () => !canEdit
		},
		{
			label: 'delete',
			icon: 'bin-delete',
			iconPos: IconPosition.TOP,
			showIcon: true,
			isAdditional: false,
			disableOption: () => !canDelete
		},
	];
}

/**
 * Define the tests for the crud tile component
 */
describe('Merchant Surcharge and Fee Crud List Tile Component', () => {

	let fixture;
	let merchantSurchargeAndFeeCrudListComponent: AdminMerchantSurchargeAndFeeCrudListComponent;

	let store: MockStore<{ model: MerchantSurchargeAndFeeModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let merchantSurchargeAndFeeModelState: MerchantSurchargeAndFeeModelState;

	let collectionCountBehaviorSubject: BehaviorSubject<number>;
	let collectionModelsBehaviorSubject: BehaviorSubject<MerchantSurchargeAndFeeModel[]>;
	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;

	const collectionId = '12004cc2-862c-411e-bb45-3e3257f35763';
	const searchContent = 'text';

	const searchableFieldCount = MerchantSurchargeAndFeeModel.searchFields.length;

	const routerState: RouterState = {
		url: 'merchant-surcharge-and-fee-admin-crud',
		urls: ['merchant-surcharge-and-fee-admin-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	const merchantSurchargeAndFeeDataFactory = new MerchantSurchargeAndFeeDataFactory();

	const defaultDataSize = 30;
	const defaultData = merchantSurchargeAndFeeDataFactory.createAll(defaultDataSize);

	// % protected region % [Add any additional variables here] off begin
	// % protected region % [Add any additional variables here] end

	function spySelectorsInStore()  {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: MerchantSurchargeAndFeeModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		merchantSurchargeAndFeeModelState = initialMerchantSurchargeAndFeeModelState;
		store.setState({model: merchantSurchargeAndFeeModelState});

		// Create Behavior Subjects to trigger later
		collectionCountBehaviorSubject = new BehaviorSubject(defaultData.length);
		collectionModelsBehaviorSubject = new BehaviorSubject(defaultData);
		routerStateBehaviorSubject = new BehaviorSubject(routerState);

		// Create spy on select function to return value
		spyOn(store, 'select')
			.withArgs(getMerchantSurchargeAndFeeCollectionCount, collectionId).and.returnValue(collectionCountBehaviorSubject)
			.withArgs(getMerchantSurchargeAndFeeCollectionModels, collectionId).and.returnValue(collectionModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	// % protected region % [Add any additional functions here] off begin
	// % protected region % [Add any additional functions here] end

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				AdminMerchantSurchargeAndFeeCrudModule,
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

			fixture = TestBed.createComponent(AdminMerchantSurchargeAndFeeCrudListComponent);
			merchantSurchargeAndFeeCrudListComponent = fixture.debugElement.componentInstance;

		});
	}));

	afterEach(() => {
		// Need to do this since for some reason the last component queried from the fixture will be rendered on the
		// browser
		if (fixture.nativeElement instanceof HTMLElement) {
			(fixture.nativeElement as HTMLElement).remove();
		}
	});

	if (searchableFieldCount > 0) {
		it ('Reset the page index and update page count when searching', () => {
			// Check the initial state
			fixture.detectChanges();
			expect(merchantSurchargeAndFeeCrudListComponent.merchantSurchargeAndFeesCount).toBe(defaultData.length);

			// Go to next page
			const nextPageButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button'))
				.find(element => element.nativeElement.textContent.includes('Next'));

			nextPageButton.nativeElement.click();
			expect(merchantSurchargeAndFeeCrudListComponent.pageIndex).toBe(1);
			fixture.detectChanges();

			// Trigger the search function
			merchantSurchargeAndFeeCrudListComponent.onCollectionSearch(searchContent);
			fixture.detectChanges();

			// Update selector to mock search results\
			const filteredDataSize = 5;
			const filteredData = merchantSurchargeAndFeeDataFactory.createAll(filteredDataSize);

			collectionModelsBehaviorSubject.next(filteredData);
			collectionCountBehaviorSubject.next(filteredData.length);

			fixture.detectChanges();

			// Check the search item is updated
			expect(fixture.debugElement.queryAll(By.css('tr.collection__item')).length).toBe(filteredDataSize);
			expect(merchantSurchargeAndFeeCrudListComponent.merchantSurchargeAndFeesCount).toBe(filteredDataSize);
			expect(merchantSurchargeAndFeeCrudListComponent.pageIndex).toBe(0);
			// Check Pagination display correctly
			// Already the last page, and the pagination div should not be shown
			expect(fixture.debugElement.query(By.css('ul.collection__pagination'))).toBeNull();

		});

		it ('returns to the initial page after clearing the search', () => {
			fixture.detectChanges();
			expect(merchantSurchargeAndFeeCrudListComponent.merchantSurchargeAndFeesCount).toBe(defaultData.length);

			// Go to next page.  Once we have searched and cleared the text we expect to have been returned to this page
			const nextPageButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button'))
				.find(element => element.nativeElement.textContent.includes('Next'));

			nextPageButton.nativeElement.click();
			expect(merchantSurchargeAndFeeCrudListComponent.pageIndex).toBe(1);
			fixture.detectChanges();

			// Trigger the search function
			merchantSurchargeAndFeeCrudListComponent.onCollectionSearch(searchContent);
			fixture.detectChanges();

			// Check that we have been returned to the first page before we return to the previous page
			expect(merchantSurchargeAndFeeCrudListComponent.pageIndex).toBe(0);
			expect(merchantSurchargeAndFeeCrudListComponent.currentPage).toBe(1); // current page should be the page index prior to search

			// Set search text to empty string.  Should trigger the list to return to the page prior to searching
			merchantSurchargeAndFeeCrudListComponent.onCollectionSearch('');
			fixture.detectChanges();

			expect(merchantSurchargeAndFeeCrudListComponent.pageIndex).toBe(1);
		});
	}

	it ('Disables Create Button if user does not have create permissions', () => {
		const canCreate: boolean = false;
		// Set the crud list tile to allow creates
		merchantSurchargeAndFeeCrudListComponent.collectionActions = collectionActions(canCreate);
		fixture.detectChanges();

		const createButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button'))
				.find(element => element.nativeElement.textContent.includes('Create'));

		expect(createButton.attributes.disabled === 'true').not.toBe(canCreate);
	});

	it ('Allows Create if user has create permissions', () => {
		const canCreate: boolean = true;
		// Set the crud list tile to allow creates
		merchantSurchargeAndFeeCrudListComponent.collectionActions = collectionActions(canCreate);
		fixture.detectChanges();

		const createButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button'))
				.find(element => element.nativeElement.textContent.includes('Create'));

		expect(createButton.attributes.disabled === 'true').not.toBe(canCreate);
	});

	it ('Disables Edit buttons is user does not have edit permissions', () => {
		const canEdit = false;
		const canDelete = true;
		merchantSurchargeAndFeeCrudListComponent.itemActions = itemActions(canEdit, canDelete);
		fixture.detectChanges();

		const editButtons: DebugElement[] = fixture.debugElement.queryAll(By.css('button.icon-edit'));
		const deleteButtons: DebugElement[] = fixture.debugElement.queryAll(By.css('button.icon-delete'));

		editButtons.forEach(button => {
			expect(button.attributes.disabled === 'true').not.toBe(canEdit);
		});

		deleteButtons.forEach(button => {
			expect(button.attributes.disabled === 'true').not.toBe(canEdit);
		});
	});

	it ('Disables Delete buttons is user does not have delete permissions', () => {
		const canEdit = true;
		const canDelete = false;
		merchantSurchargeAndFeeCrudListComponent.itemActions = itemActions(canEdit, canDelete);
		fixture.detectChanges();

		const editButtons: DebugElement[] = fixture.debugElement.queryAll(By.css('button.icon-edit'));
		const deleteButtons: DebugElement[] = fixture.debugElement.queryAll(By.css('button.icon-delete'));

		editButtons.forEach(button => {
			expect(button.attributes.disabled === 'true').not.toBe(canEdit);
		});

		deleteButtons.forEach(button => {
			expect(button.attributes.disabled === 'true').not.toBe(canEdit);
		});
	});

	it ('Disables Edit and Delete buttons is user does not have edit or delete permissions', () => {
		const canEdit = false;
		const canDelete = false;
		merchantSurchargeAndFeeCrudListComponent.itemActions = itemActions(canEdit, canDelete);
		fixture.detectChanges();

		const editButtons: DebugElement[] = fixture.debugElement.queryAll(By.css('button.icon-edit'));
		const deleteButtons: DebugElement[] = fixture.debugElement.queryAll(By.css('button.icon-delete'));

		editButtons.forEach(button => {
			expect(button.attributes.disabled === 'true').not.toBe(canEdit);
		});

		deleteButtons.forEach(button => {
			expect(button.attributes.disabled === 'true').not.toBe(canEdit);
		});
	});

	it ('Allows Edit and delete is user has edit and delete permissions', () => {
		const canEdit = true;
		const canDelete = true;
		merchantSurchargeAndFeeCrudListComponent.itemActions = itemActions(canEdit, canDelete);
		fixture.detectChanges();

		const editButtons: DebugElement[] = fixture.debugElement.queryAll(By.css('button.icon-edit'));
		const deleteButtons: DebugElement[] = fixture.debugElement.queryAll(By.css('button.icon-delete'));

		editButtons.forEach(button => {
			expect(button.attributes.disabled === 'true').not.toBe(canEdit);
		});

		deleteButtons.forEach(button => {
			expect(button.attributes.disabled === 'true').not.toBe(canEdit);
		});
	});

	// % protected region % [Add any additional tests here] off begin
	// % protected region % [Add any additional tests here] end
});
