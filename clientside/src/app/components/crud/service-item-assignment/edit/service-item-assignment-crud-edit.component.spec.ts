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
	getServiceItemAssignmentCollectionModels,
	getCountServiceItemAssignmentModels,
	getServiceItemAssignmentModelWithId
} from 'src/app/models/serviceItemAssignment/service_item_assignment.model.selector';
import { ServiceItemAssignmentCrudModule } from '../service-item-assignment-crud.module';
import { ServiceItemAssignmentCrudEditComponent } from './service-item-assignment-crud-edit.component';
import {
	ServiceItemAssignmentModelState,
	initialState as initialServiceItemAssignmentModelState
} from 'src/app/models/serviceItemAssignment/service_item_assignment.model.state';
import { ServiceItemAssignmentDataFactory } from 'src/app/lib/utils/factories/service-item-assignment-data-factory';
import { ServiceItemAssignmentModel } from 'src/app/models/serviceItemAssignment/service_item_assignment.model';
import { CrudTileMode } from '../service-item-assignment-crud.component';
import { getExaminationItemModelWithId } from 'src/app/models/examinationItem/examination_item.model.selector';
import { getExaminationItemCollectionModels } from 'src/app/models/examinationItem/examination_item.model.selector';
import { ExaminationItemModel } from 'src/app/models/examinationItem/examination_item.model';
import { ExaminationItemDataFactory } from 'src/app/lib/utils/factories/examination-item-data-factory';
import { getServiceModelWithId } from 'src/app/models/service/service.model.selector';
import { getServiceCollectionModels } from 'src/app/models/service/service.model.selector';
import { ServiceModel } from 'src/app/models/service/service.model';
import { ServiceDataFactory } from 'src/app/lib/utils/factories/service-data-factory';
import { getServiceItemModelWithId } from 'src/app/models/serviceItem/service_item.model.selector';
import { getServiceItemCollectionModels } from 'src/app/models/serviceItem/service_item.model.selector';
import { ServiceItemModel } from 'src/app/models/serviceItem/service_item.model';
import { ServiceItemDataFactory } from 'src/app/lib/utils/factories/service-item-data-factory';
import { getTariffPackageModelWithId } from 'src/app/models/tariffPackage/tariff_package.model.selector';
import { getTariffPackageCollectionModels } from 'src/app/models/tariffPackage/tariff_package.model.selector';
import { TariffPackageModel } from 'src/app/models/tariffPackage/tariff_package.model';
import { TariffPackageDataFactory } from 'src/app/lib/utils/factories/tariff-package-data-factory';
import { getTariffPackageItemModelWithId } from 'src/app/models/tariffPackageItem/tariff_package_item.model.selector';
import { getTariffPackageItemCollectionModels } from 'src/app/models/tariffPackageItem/tariff_package_item.model.selector';
import { TariffPackageItemModel } from 'src/app/models/tariffPackageItem/tariff_package_item.model';
import { TariffPackageItemDataFactory } from 'src/app/lib/utils/factories/tariff-package-item-data-factory';
import { getTariffPackageServiceAssignmentModelWithId } from 'src/app/models/tariffPackageServiceAssignment/tariff_package_service_assignment.model.selector';
import { getTariffPackageServiceAssignmentCollectionModels } from 'src/app/models/tariffPackageServiceAssignment/tariff_package_service_assignment.model.selector';
import { TariffPackageServiceAssignmentModel } from 'src/app/models/tariffPackageServiceAssignment/tariff_package_service_assignment.model';
import { TariffPackageServiceAssignmentDataFactory } from 'src/app/lib/utils/factories/tariff-package-service-assignment-data-factory';

describe('Service Item Assignment CRUD Edit component tests', () => {
	let fixture: ComponentFixture<ServiceItemAssignmentCrudEditComponent>
	let component: ServiceItemAssignmentCrudEditComponent;

	let serviceItemAssignmentModelState: ServiceItemAssignmentModelState;

	let store: MockStore<{ model: ServiceItemAssignmentModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let serviceItemAssignmentCountBehaviorSubject: BehaviorSubject<number>;
	let serviceItemAssignmentModelsBehaviorSubject: BehaviorSubject<ServiceItemAssignmentModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let serviceItemModelsBehaviorSubject: BehaviorSubject<ServiceItemModel[]>;
	let tariffPackageModelsBehaviorSubject: BehaviorSubject<TariffPackageModel[]>;
	let tariffPackageItemModelsBehaviorSubject: BehaviorSubject<TariffPackageItemModel[]>;
	let tariffPackageServiceAssignmentModelsBehaviorSubject: BehaviorSubject<TariffPackageServiceAssignmentModel[]>;

	const serviceItemAssignmentFactory: ServiceItemAssignmentDataFactory = new ServiceItemAssignmentDataFactory();
	const defaultServiceItemAssignmentCount: number = 10;
	const defaultServiceItemAssignmentEntities: ServiceItemAssignmentModel[] = serviceItemAssignmentFactory.createAll(defaultServiceItemAssignmentCount);

	const examinationItemFactory: ExaminationItemDataFactory = new ExaminationItemDataFactory();
	const defaultExaminationItemCount: number = 10;
	const defaultExaminationItemEntities: ExaminationItemModel[] = examinationItemFactory.createAll(defaultExaminationItemCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);

	const serviceItemFactory: ServiceItemDataFactory = new ServiceItemDataFactory();
	const defaultServiceItemCount: number = 10;
	const defaultServiceItemEntities: ServiceItemModel[] = serviceItemFactory.createAll(defaultServiceItemCount);

	const tariffPackageFactory: TariffPackageDataFactory = new TariffPackageDataFactory();
	const defaultTariffPackageCount: number = 10;
	const defaultTariffPackageEntities: TariffPackageModel[] = tariffPackageFactory.createAll(defaultTariffPackageCount);

	const tariffPackageItemFactory: TariffPackageItemDataFactory = new TariffPackageItemDataFactory();
	const defaultTariffPackageItemCount: number = 10;
	const defaultTariffPackageItemEntities: TariffPackageItemModel[] = tariffPackageItemFactory.createAll(defaultTariffPackageItemCount);

	const tariffPackageServiceAssignmentFactory: TariffPackageServiceAssignmentDataFactory = new TariffPackageServiceAssignmentDataFactory();
	const defaultTariffPackageServiceAssignmentCount: number = 10;
	const defaultTariffPackageServiceAssignmentEntities: TariffPackageServiceAssignmentModel[] = tariffPackageServiceAssignmentFactory.createAll(defaultTariffPackageServiceAssignmentCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let serviceItemAssignmentWithId: ServiceItemAssignmentModel = defaultServiceItemAssignmentEntities[0];
	let serviceItemAssignmentModelWithIdBehaviorSubject: BehaviorSubject<ServiceItemAssignmentModel>;

	serviceItemAssignmentWithId.serviceItem = defaultServiceItemEntities[0];
	serviceItemAssignmentWithId.serviceItemId = serviceItemAssignmentWithId.serviceItem.id;
	let serviceItemWithIdBehaviorSubject: BehaviorSubject<ServiceItemModel>;

	serviceItemAssignmentWithId.tariffPackage = defaultTariffPackageEntities[0];
	serviceItemAssignmentWithId.tariffPackageId = serviceItemAssignmentWithId.tariffPackage.id;
	let tariffPackageWithIdBehaviorSubject: BehaviorSubject<TariffPackageModel>;


	const routerState: RouterState = {
		url: 'service-item-assignment-crud',
		urls: ['service-item-assignment-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: ServiceItemAssignmentModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		serviceItemAssignmentModelState = initialServiceItemAssignmentModelState;
		store.setState({model: serviceItemAssignmentModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		serviceItemAssignmentCountBehaviorSubject = new BehaviorSubject(defaultServiceItemAssignmentCount);

		// selectors for all references
		serviceItemAssignmentModelsBehaviorSubject = new BehaviorSubject(defaultServiceItemAssignmentEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		serviceItemModelsBehaviorSubject = new BehaviorSubject(defaultServiceItemEntities);
		tariffPackageModelsBehaviorSubject = new BehaviorSubject(defaultTariffPackageEntities);
		tariffPackageItemModelsBehaviorSubject = new BehaviorSubject(defaultTariffPackageItemEntities);
		tariffPackageServiceAssignmentModelsBehaviorSubject = new BehaviorSubject(defaultTariffPackageServiceAssignmentEntities);

		// selectors for target entity and its related entity
		serviceItemAssignmentModelWithIdBehaviorSubject = new BehaviorSubject(serviceItemAssignmentWithId);
		serviceItemWithIdBehaviorSubject = new BehaviorSubject(serviceItemAssignmentWithId.serviceItem);
		tariffPackageWithIdBehaviorSubject = new BehaviorSubject(serviceItemAssignmentWithId.tariffPackage);

		spyOn(store, 'select')
			.withArgs(getCountServiceItemAssignmentModels).and.returnValue(serviceItemAssignmentCountBehaviorSubject)
			.withArgs(getServiceItemAssignmentModelWithId, serviceItemAssignmentWithId.id).and.returnValue(serviceItemAssignmentModelWithIdBehaviorSubject)
			.withArgs(getServiceItemAssignmentCollectionModels, jasmine.any(String)).and.returnValue(serviceItemAssignmentModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getServiceItemCollectionModels, jasmine.any(String)).and.returnValue(serviceItemModelsBehaviorSubject)
			.withArgs(getTariffPackageCollectionModels, jasmine.any(String)).and.returnValue(tariffPackageModelsBehaviorSubject)
			.withArgs(getTariffPackageItemCollectionModels, jasmine.any(String)).and.returnValue(tariffPackageItemModelsBehaviorSubject)
			.withArgs(getTariffPackageServiceAssignmentCollectionModels, jasmine.any(String)).and.returnValue(tariffPackageServiceAssignmentModelsBehaviorSubject)
			.withArgs(getServiceItemModelWithId, serviceItemAssignmentWithId.serviceItemId).and.returnValue(serviceItemWithIdBehaviorSubject)
			.withArgs(getTariffPackageModelWithId, serviceItemAssignmentWithId.tariffPackageId).and.returnValue(tariffPackageWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				ServiceItemAssignmentCrudModule,
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

			fixture = TestBed.createComponent(ServiceItemAssignmentCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new ServiceItemAssignmentModel();
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
	it ('Renders the Service Item Assignment CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Service Item relation.
	*
	* The button should only exist if serviceItemMultiCrudActive is true
	*/
	it ('Renders Service Item Add Entity button in create mode', fakeAsync(() => {
		const serviceItemButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!serviceItemButton).toEqual(component.serviceItemMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Service Item', fakeAsync(() => {
		const serviceItemButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceItemButton).toEqual(component.serviceItemMultiCrudActive);

		if (component.serviceItemMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialServiceItemRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemDisplayName + ' from Model')).length;

			serviceItemButton.nativeElement.click();
			fixture.detectChanges();

			const actualServiceItemRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemDisplayName + ' from Model')).length;

			expect(actualServiceItemRemoveButtonCount).toEqual(initialServiceItemRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Service Item button', () => {
		const serviceItemButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceItemButton).toEqual(component.serviceItemMultiCrudActive);

		if (component.serviceItemMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			serviceItemButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialServiceItemRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialServiceItemRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualServiceItemRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemDisplayName + ' from Model'));

			expect(actualServiceItemRemoveButtons.length).toEqual(initialServiceItemRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Service Item button when one has already been added', () => {

		const serviceItemButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceItemButton).toEqual(component.serviceItemMultiCrudActive);

		if (component.serviceItemMultiCrudActive) {
			serviceItemButton.nativeElement.click();
			fixture.detectChanges();

			const updatedserviceItemButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemDisplayName + ' to Model'));

			expect(updatedserviceItemButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Service Item entities from model when loading in edit mode', () => {
		component.targetModel = serviceItemAssignmentWithId;
		component.targetModelId = serviceItemAssignmentWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.serviceItemMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const serviceItemRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemDisplayName + ' from Model')).length;

			expect(serviceItemRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Tariff Package relation.
	*
	* The button should only exist if tariffPackageMultiCrudActive is true
	*/
	it ('Renders Tariff Package Add Entity button in create mode', fakeAsync(() => {
		const tariffPackageButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffPackageDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!tariffPackageButton).toEqual(component.tariffPackageMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Tariff Package', fakeAsync(() => {
		const tariffPackageButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffPackageDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffPackageButton).toEqual(component.tariffPackageMultiCrudActive);

		if (component.tariffPackageMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialTariffPackageRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffPackageDisplayName + ' from Model')).length;

			tariffPackageButton.nativeElement.click();
			fixture.detectChanges();

			const actualTariffPackageRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffPackageDisplayName + ' from Model')).length;

			expect(actualTariffPackageRemoveButtonCount).toEqual(initialTariffPackageRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Tariff Package button', () => {
		const tariffPackageButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffPackageDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffPackageButton).toEqual(component.tariffPackageMultiCrudActive);

		if (component.tariffPackageMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			tariffPackageButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialTariffPackageRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffPackageDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialTariffPackageRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualTariffPackageRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffPackageDisplayName + ' from Model'));

			expect(actualTariffPackageRemoveButtons.length).toEqual(initialTariffPackageRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Tariff Package button when one has already been added', () => {

		const tariffPackageButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffPackageDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!tariffPackageButton).toEqual(component.tariffPackageMultiCrudActive);

		if (component.tariffPackageMultiCrudActive) {
			tariffPackageButton.nativeElement.click();
			fixture.detectChanges();

			const updatedtariffPackageButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.tariffPackageDisplayName + ' to Model'));

			expect(updatedtariffPackageButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Tariff Package entities from model when loading in edit mode', () => {
		component.targetModel = serviceItemAssignmentWithId;
		component.targetModelId = serviceItemAssignmentWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.tariffPackageMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const tariffPackageRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.tariffPackageDisplayName + ' from Model')).length;

			expect(tariffPackageRemoveButtonCount).toEqual(1);
		}
	});

});
