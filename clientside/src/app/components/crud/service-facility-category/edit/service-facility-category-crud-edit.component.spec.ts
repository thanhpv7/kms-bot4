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
	getServiceFacilityCategoryCollectionModels,
	getCountServiceFacilityCategoryModels,
	getServiceFacilityCategoryModelWithId
} from 'src/app/models/serviceFacilityCategory/service_facility_category.model.selector';
import { ServiceFacilityCategoryCrudModule } from '../service-facility-category-crud.module';
import { ServiceFacilityCategoryCrudEditComponent } from './service-facility-category-crud-edit.component';
import {
	ServiceFacilityCategoryModelState,
	initialState as initialServiceFacilityCategoryModelState
} from 'src/app/models/serviceFacilityCategory/service_facility_category.model.state';
import { ServiceFacilityCategoryDataFactory } from 'src/app/lib/utils/factories/service-facility-category-data-factory';
import { ServiceFacilityCategoryModel } from 'src/app/models/serviceFacilityCategory/service_facility_category.model';
import { CrudTileMode } from '../service-facility-category-crud.component';
import { getBpjsPcarePoliModelWithId } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.selector';
import { getBpjsPcarePoliCollectionModels } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.selector';
import { BpjsPcarePoliModel } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model';
import { BpjsPcarePoliDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-poli-data-factory';
import { getBpjsServiceMappingModelWithId } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { getBpjsServiceMappingCollectionModels } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { BpjsServiceMappingModel } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import { BpjsServiceMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-service-mapping-data-factory';
import { getDoctorScheduleModelWithId } from 'src/app/models/doctorSchedule/doctor_schedule.model.selector';
import { getDoctorScheduleCollectionModels } from 'src/app/models/doctorSchedule/doctor_schedule.model.selector';
import { DoctorScheduleModel } from 'src/app/models/doctorSchedule/doctor_schedule.model';
import { DoctorScheduleDataFactory } from 'src/app/lib/utils/factories/doctor-schedule-data-factory';
import { getExaminationGroupModelWithId } from 'src/app/models/examinationGroup/examination_group.model.selector';
import { getExaminationGroupCollectionModels } from 'src/app/models/examinationGroup/examination_group.model.selector';
import { ExaminationGroupModel } from 'src/app/models/examinationGroup/examination_group.model';
import { ExaminationGroupDataFactory } from 'src/app/lib/utils/factories/examination-group-data-factory';
import { getMcuPackageItemModelWithId } from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import { getMcuPackageItemCollectionModels } from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import { McuPackageItemModel } from 'src/app/models/mcuPackageItem/mcu_package_item.model';
import { McuPackageItemDataFactory } from 'src/app/lib/utils/factories/mcu-package-item-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getServiceModelWithId } from 'src/app/models/service/service.model.selector';
import { getServiceCollectionModels } from 'src/app/models/service/service.model.selector';
import { ServiceModel } from 'src/app/models/service/service.model';
import { ServiceDataFactory } from 'src/app/lib/utils/factories/service-data-factory';
import { getServiceItemModelWithId } from 'src/app/models/serviceItem/service_item.model.selector';
import { getServiceItemCollectionModels } from 'src/app/models/serviceItem/service_item.model.selector';
import { ServiceItemModel } from 'src/app/models/serviceItem/service_item.model';
import { ServiceItemDataFactory } from 'src/app/lib/utils/factories/service-item-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('Service Facility Category CRUD Edit component tests', () => {
	let fixture: ComponentFixture<ServiceFacilityCategoryCrudEditComponent>
	let component: ServiceFacilityCategoryCrudEditComponent;

	let serviceFacilityCategoryModelState: ServiceFacilityCategoryModelState;

	let store: MockStore<{ model: ServiceFacilityCategoryModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let serviceFacilityCategoryCountBehaviorSubject: BehaviorSubject<number>;
	let serviceFacilityCategoryModelsBehaviorSubject: BehaviorSubject<ServiceFacilityCategoryModel[]>;
	let bpjsPcarePoliModelsBehaviorSubject: BehaviorSubject<BpjsPcarePoliModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let doctorScheduleModelsBehaviorSubject: BehaviorSubject<DoctorScheduleModel[]>;
	let examinationGroupModelsBehaviorSubject: BehaviorSubject<ExaminationGroupModel[]>;
	let mcuPackageItemModelsBehaviorSubject: BehaviorSubject<McuPackageItemModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let serviceItemModelsBehaviorSubject: BehaviorSubject<ServiceItemModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const serviceFacilityCategoryFactory: ServiceFacilityCategoryDataFactory = new ServiceFacilityCategoryDataFactory();
	const defaultServiceFacilityCategoryCount: number = 10;
	const defaultServiceFacilityCategoryEntities: ServiceFacilityCategoryModel[] = serviceFacilityCategoryFactory.createAll(defaultServiceFacilityCategoryCount);

	const bpjsPcarePoliFactory: BpjsPcarePoliDataFactory = new BpjsPcarePoliDataFactory();
	const defaultBpjsPcarePoliCount: number = 10;
	const defaultBpjsPcarePoliEntities: BpjsPcarePoliModel[] = bpjsPcarePoliFactory.createAll(defaultBpjsPcarePoliCount);

	const bpjsServiceMappingFactory: BpjsServiceMappingDataFactory = new BpjsServiceMappingDataFactory();
	const defaultBpjsServiceMappingCount: number = 10;
	const defaultBpjsServiceMappingEntities: BpjsServiceMappingModel[] = bpjsServiceMappingFactory.createAll(defaultBpjsServiceMappingCount);

	const doctorScheduleFactory: DoctorScheduleDataFactory = new DoctorScheduleDataFactory();
	const defaultDoctorScheduleCount: number = 10;
	const defaultDoctorScheduleEntities: DoctorScheduleModel[] = doctorScheduleFactory.createAll(defaultDoctorScheduleCount);

	const examinationGroupFactory: ExaminationGroupDataFactory = new ExaminationGroupDataFactory();
	const defaultExaminationGroupCount: number = 10;
	const defaultExaminationGroupEntities: ExaminationGroupModel[] = examinationGroupFactory.createAll(defaultExaminationGroupCount);

	const mcuPackageItemFactory: McuPackageItemDataFactory = new McuPackageItemDataFactory();
	const defaultMcuPackageItemCount: number = 10;
	const defaultMcuPackageItemEntities: McuPackageItemModel[] = mcuPackageItemFactory.createAll(defaultMcuPackageItemCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);

	const serviceItemFactory: ServiceItemDataFactory = new ServiceItemDataFactory();
	const defaultServiceItemCount: number = 10;
	const defaultServiceItemEntities: ServiceItemModel[] = serviceItemFactory.createAll(defaultServiceItemCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let serviceFacilityCategoryWithId: ServiceFacilityCategoryModel = defaultServiceFacilityCategoryEntities[0];
	let serviceFacilityCategoryModelWithIdBehaviorSubject: BehaviorSubject<ServiceFacilityCategoryModel>;

	serviceFacilityCategoryWithId.service = defaultServiceEntities[0];
	serviceFacilityCategoryWithId.serviceId = serviceFacilityCategoryWithId.service.id;
	let serviceWithIdBehaviorSubject: BehaviorSubject<ServiceModel>;


	const routerState: RouterState = {
		url: 'service-facility-category-crud',
		urls: ['service-facility-category-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: ServiceFacilityCategoryModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		serviceFacilityCategoryModelState = initialServiceFacilityCategoryModelState;
		store.setState({model: serviceFacilityCategoryModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		serviceFacilityCategoryCountBehaviorSubject = new BehaviorSubject(defaultServiceFacilityCategoryCount);

		// selectors for all references
		serviceFacilityCategoryModelsBehaviorSubject = new BehaviorSubject(defaultServiceFacilityCategoryEntities);
		bpjsPcarePoliModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcarePoliEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		doctorScheduleModelsBehaviorSubject = new BehaviorSubject(defaultDoctorScheduleEntities);
		examinationGroupModelsBehaviorSubject = new BehaviorSubject(defaultExaminationGroupEntities);
		mcuPackageItemModelsBehaviorSubject = new BehaviorSubject(defaultMcuPackageItemEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		serviceItemModelsBehaviorSubject = new BehaviorSubject(defaultServiceItemEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		serviceFacilityCategoryModelWithIdBehaviorSubject = new BehaviorSubject(serviceFacilityCategoryWithId);
		serviceWithIdBehaviorSubject = new BehaviorSubject(serviceFacilityCategoryWithId.service);

		spyOn(store, 'select')
			.withArgs(getCountServiceFacilityCategoryModels).and.returnValue(serviceFacilityCategoryCountBehaviorSubject)
			.withArgs(getServiceFacilityCategoryModelWithId, serviceFacilityCategoryWithId.id).and.returnValue(serviceFacilityCategoryModelWithIdBehaviorSubject)
			.withArgs(getServiceFacilityCategoryCollectionModels, jasmine.any(String)).and.returnValue(serviceFacilityCategoryModelsBehaviorSubject)
			.withArgs(getBpjsPcarePoliCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcarePoliModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getDoctorScheduleCollectionModels, jasmine.any(String)).and.returnValue(doctorScheduleModelsBehaviorSubject)
			.withArgs(getExaminationGroupCollectionModels, jasmine.any(String)).and.returnValue(examinationGroupModelsBehaviorSubject)
			.withArgs(getMcuPackageItemCollectionModels, jasmine.any(String)).and.returnValue(mcuPackageItemModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getServiceItemCollectionModels, jasmine.any(String)).and.returnValue(serviceItemModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getServiceModelWithId, serviceFacilityCategoryWithId.serviceId).and.returnValue(serviceWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				ServiceFacilityCategoryCrudModule,
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

			fixture = TestBed.createComponent(ServiceFacilityCategoryCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new ServiceFacilityCategoryModel();
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
	it ('Renders the Service Facility Category CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Service relation.
	*
	* The button should only exist if serviceMultiCrudActive is true
	*/
	it ('Renders Service Add Entity button in create mode', fakeAsync(() => {
		const serviceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!serviceButton).toEqual(component.serviceMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Service', fakeAsync(() => {
		const serviceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceButton).toEqual(component.serviceMultiCrudActive);

		if (component.serviceMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialServiceRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model')).length;

			serviceButton.nativeElement.click();
			fixture.detectChanges();

			const actualServiceRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model')).length;

			expect(actualServiceRemoveButtonCount).toEqual(initialServiceRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Service button', () => {
		const serviceButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceButton).toEqual(component.serviceMultiCrudActive);

		if (component.serviceMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			serviceButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialServiceRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialServiceRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualServiceRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model'));

			expect(actualServiceRemoveButtons.length).toEqual(initialServiceRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Service button when one has already been added', () => {

		const serviceButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceButton).toEqual(component.serviceMultiCrudActive);

		if (component.serviceMultiCrudActive) {
			serviceButton.nativeElement.click();
			fixture.detectChanges();

			const updatedserviceButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceDisplayName + ' to Model'));

			expect(updatedserviceButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Service entities from model when loading in edit mode', () => {
		component.targetModel = serviceFacilityCategoryWithId;
		component.targetModelId = serviceFacilityCategoryWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.serviceMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const serviceRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceDisplayName + ' from Model')).length;

			expect(serviceRemoveButtonCount).toEqual(1);
		}
	});

});
