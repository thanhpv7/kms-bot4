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
	getMcuPackageCollectionModels,
	getCountMcuPackageModels,
	getMcuPackageModelWithId
} from 'src/app/models/mcuPackage/mcu_package.model.selector';
import { McuPackageCrudModule } from '../mcu-package-crud.module';
import { McuPackageCrudEditComponent } from './mcu-package-crud-edit.component';
import {
	McuPackageModelState,
	initialState as initialMcuPackageModelState
} from 'src/app/models/mcuPackage/mcu_package.model.state';
import { McuPackageDataFactory } from 'src/app/lib/utils/factories/mcu-package-data-factory';
import { McuPackageModel } from 'src/app/models/mcuPackage/mcu_package.model';
import { CrudTileMode } from '../mcu-package-crud.component';
import { getExaminationItemModelWithId } from 'src/app/models/examinationItem/examination_item.model.selector';
import { getExaminationItemCollectionModels } from 'src/app/models/examinationItem/examination_item.model.selector';
import { ExaminationItemModel } from 'src/app/models/examinationItem/examination_item.model';
import { ExaminationItemDataFactory } from 'src/app/lib/utils/factories/examination-item-data-factory';
import { getMcuPackageItemModelWithId } from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import { getMcuPackageItemCollectionModels } from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import { McuPackageItemModel } from 'src/app/models/mcuPackageItem/mcu_package_item.model';
import { McuPackageItemDataFactory } from 'src/app/lib/utils/factories/mcu-package-item-data-factory';
import { getServiceModelWithId } from 'src/app/models/service/service.model.selector';
import { getServiceCollectionModels } from 'src/app/models/service/service.model.selector';
import { ServiceModel } from 'src/app/models/service/service.model';
import { ServiceDataFactory } from 'src/app/lib/utils/factories/service-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('MCU Package CRUD Edit component tests', () => {
	let fixture: ComponentFixture<McuPackageCrudEditComponent>
	let component: McuPackageCrudEditComponent;

	let mcuPackageModelState: McuPackageModelState;

	let store: MockStore<{ model: McuPackageModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let mcuPackageCountBehaviorSubject: BehaviorSubject<number>;
	let mcuPackageModelsBehaviorSubject: BehaviorSubject<McuPackageModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let mcuPackageItemModelsBehaviorSubject: BehaviorSubject<McuPackageItemModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const mcuPackageFactory: McuPackageDataFactory = new McuPackageDataFactory();
	const defaultMcuPackageCount: number = 10;
	const defaultMcuPackageEntities: McuPackageModel[] = mcuPackageFactory.createAll(defaultMcuPackageCount);

	const examinationItemFactory: ExaminationItemDataFactory = new ExaminationItemDataFactory();
	const defaultExaminationItemCount: number = 10;
	const defaultExaminationItemEntities: ExaminationItemModel[] = examinationItemFactory.createAll(defaultExaminationItemCount);

	const mcuPackageItemFactory: McuPackageItemDataFactory = new McuPackageItemDataFactory();
	const defaultMcuPackageItemCount: number = 10;
	const defaultMcuPackageItemEntities: McuPackageItemModel[] = mcuPackageItemFactory.createAll(defaultMcuPackageItemCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let mcuPackageWithId: McuPackageModel = defaultMcuPackageEntities[0];
	let mcuPackageModelWithIdBehaviorSubject: BehaviorSubject<McuPackageModel>;

	mcuPackageWithId.mcuPackageItems = defaultMcuPackageItemEntities;
	mcuPackageWithId.mcuPackageItemsIds = mcuPackageWithId.mcuPackageItems.map(mcuPackageItems => mcuPackageItems.id);


	const routerState: RouterState = {
		url: 'mcu-package-crud',
		urls: ['mcu-package-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: McuPackageModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		mcuPackageModelState = initialMcuPackageModelState;
		store.setState({model: mcuPackageModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		mcuPackageCountBehaviorSubject = new BehaviorSubject(defaultMcuPackageCount);

		// selectors for all references
		mcuPackageModelsBehaviorSubject = new BehaviorSubject(defaultMcuPackageEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		mcuPackageItemModelsBehaviorSubject = new BehaviorSubject(defaultMcuPackageItemEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		mcuPackageModelWithIdBehaviorSubject = new BehaviorSubject(mcuPackageWithId);

		spyOn(store, 'select')
			.withArgs(getCountMcuPackageModels).and.returnValue(mcuPackageCountBehaviorSubject)
			.withArgs(getMcuPackageModelWithId, mcuPackageWithId.id).and.returnValue(mcuPackageModelWithIdBehaviorSubject)
			.withArgs(getMcuPackageCollectionModels, jasmine.any(String)).and.returnValue(mcuPackageModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getMcuPackageItemCollectionModels, jasmine.any(String)).and.returnValue(mcuPackageItemModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				McuPackageCrudModule,
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

			fixture = TestBed.createComponent(McuPackageCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new McuPackageModel();
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
	it ('Renders the MCU Package CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the MCU Package Items relation.
	*
	* The button should only exist if mcuPackageItemsMultiCrudActive is true
	*/
	it ('Renders MCU Package Items Add Entity button in create mode', fakeAsync(() => {
		const mcuPackageItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!mcuPackageItemsButton).toEqual(component.mcuPackageItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new MCU Package Items', fakeAsync(() => {
		const mcuPackageItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!mcuPackageItemsButton).toEqual(component.mcuPackageItemsMultiCrudActive);

		if (component.mcuPackageItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialMcuPackageItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model')).length;

			mcuPackageItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualMcuPackageItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model')).length;

			expect(actualMcuPackageItemsRemoveButtonCount).toEqual(initialMcuPackageItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove MCU Package Items button', () => {
		const mcuPackageItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!mcuPackageItemsButton).toEqual(component.mcuPackageItemsMultiCrudActive);

		if (component.mcuPackageItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			mcuPackageItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialMcuPackageItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialMcuPackageItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualMcuPackageItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model'));

			expect(actualMcuPackageItemsRemoveButtons.length).toEqual(initialMcuPackageItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add MCU Package Items button when one has already been added', () => {

		const mcuPackageItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!mcuPackageItemsButton).toEqual(component.mcuPackageItemsMultiCrudActive);

		if (component.mcuPackageItemsMultiCrudActive) {
			mcuPackageItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedmcuPackageItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.mcuPackageItemsDisplayName + ' to Model'));

			expect(updatedmcuPackageItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related MCU Package Items entities from model when loading in edit mode', () => {
		component.targetModel = mcuPackageWithId;
		component.targetModelId = mcuPackageWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.mcuPackageItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const mcuPackageItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.mcuPackageItemsDisplayName + ' from Model')).length;

			expect(mcuPackageItemsRemoveButtonCount).toEqual(mcuPackageWithId.mcuPackageItems.length);
		}
	});

});
