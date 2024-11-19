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
	getServiceItemCollectionModels,
	getCountServiceItemModels,
	getServiceItemModelWithId
} from 'src/app/models/serviceItem/service_item.model.selector';
import { ServiceItemCrudModule } from '../service-item-crud.module';
import { ServiceItemCrudEditComponent } from './service-item-crud-edit.component';
import {
	ServiceItemModelState,
	initialState as initialServiceItemModelState
} from 'src/app/models/serviceItem/service_item.model.state';
import { ServiceItemDataFactory } from 'src/app/lib/utils/factories/service-item-data-factory';
import { ServiceItemModel } from 'src/app/models/serviceItem/service_item.model';
import { CrudTileMode } from '../service-item-crud.component';
import { getBpjsPcarePoliModelWithId } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.selector';
import { getBpjsPcarePoliCollectionModels } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model.selector';
import { BpjsPcarePoliModel } from 'src/app/models/bpjsPcarePoli/bpjs_pcare_poli.model';
import { BpjsPcarePoliDataFactory } from 'src/app/lib/utils/factories/bpjs-pcare-poli-data-factory';
import { getBpjsServiceMappingModelWithId } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { getBpjsServiceMappingCollectionModels } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { BpjsServiceMappingModel } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import { BpjsServiceMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-service-mapping-data-factory';
import { getDiagnosticExaminationResultsModelWithId } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { getDiagnosticExaminationResultsCollectionModels } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { DiagnosticExaminationResultsModel } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model';
import { DiagnosticExaminationResultsDataFactory } from 'src/app/lib/utils/factories/diagnostic-examination-results-data-factory';
import { getDoctorScheduleModelWithId } from 'src/app/models/doctorSchedule/doctor_schedule.model.selector';
import { getDoctorScheduleCollectionModels } from 'src/app/models/doctorSchedule/doctor_schedule.model.selector';
import { DoctorScheduleModel } from 'src/app/models/doctorSchedule/doctor_schedule.model';
import { DoctorScheduleDataFactory } from 'src/app/lib/utils/factories/doctor-schedule-data-factory';
import { getExaminationGroupModelWithId } from 'src/app/models/examinationGroup/examination_group.model.selector';
import { getExaminationGroupCollectionModels } from 'src/app/models/examinationGroup/examination_group.model.selector';
import { ExaminationGroupModel } from 'src/app/models/examinationGroup/examination_group.model';
import { ExaminationGroupDataFactory } from 'src/app/lib/utils/factories/examination-group-data-factory';
import { getExaminationItemModelWithId } from 'src/app/models/examinationItem/examination_item.model.selector';
import { getExaminationItemCollectionModels } from 'src/app/models/examinationItem/examination_item.model.selector';
import { ExaminationItemModel } from 'src/app/models/examinationItem/examination_item.model';
import { ExaminationItemDataFactory } from 'src/app/lib/utils/factories/examination-item-data-factory';
import { getExaminationItemDetailModelWithId } from 'src/app/models/examinationItemDetail/examination_item_detail.model.selector';
import { getExaminationItemDetailCollectionModels } from 'src/app/models/examinationItemDetail/examination_item_detail.model.selector';
import { ExaminationItemDetailModel } from 'src/app/models/examinationItemDetail/examination_item_detail.model';
import { ExaminationItemDetailDataFactory } from 'src/app/lib/utils/factories/examination-item-detail-data-factory';
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
import { getServiceFacilityCategoryModelWithId } from 'src/app/models/serviceFacilityCategory/service_facility_category.model.selector';
import { getServiceFacilityCategoryCollectionModels } from 'src/app/models/serviceFacilityCategory/service_facility_category.model.selector';
import { ServiceFacilityCategoryModel } from 'src/app/models/serviceFacilityCategory/service_facility_category.model';
import { ServiceFacilityCategoryDataFactory } from 'src/app/lib/utils/factories/service-facility-category-data-factory';
import { getServiceItemAssignmentModelWithId } from 'src/app/models/serviceItemAssignment/service_item_assignment.model.selector';
import { getServiceItemAssignmentCollectionModels } from 'src/app/models/serviceItemAssignment/service_item_assignment.model.selector';
import { ServiceItemAssignmentModel } from 'src/app/models/serviceItemAssignment/service_item_assignment.model';
import { ServiceItemAssignmentDataFactory } from 'src/app/lib/utils/factories/service-item-assignment-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';
import { getTariffPackageModelWithId } from 'src/app/models/tariffPackage/tariff_package.model.selector';
import { getTariffPackageCollectionModels } from 'src/app/models/tariffPackage/tariff_package.model.selector';
import { TariffPackageModel } from 'src/app/models/tariffPackage/tariff_package.model';
import { TariffPackageDataFactory } from 'src/app/lib/utils/factories/tariff-package-data-factory';

describe('Service Item CRUD Edit component tests', () => {
	let fixture: ComponentFixture<ServiceItemCrudEditComponent>
	let component: ServiceItemCrudEditComponent;

	let serviceItemModelState: ServiceItemModelState;

	let store: MockStore<{ model: ServiceItemModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let serviceItemCountBehaviorSubject: BehaviorSubject<number>;
	let serviceItemModelsBehaviorSubject: BehaviorSubject<ServiceItemModel[]>;
	let bpjsPcarePoliModelsBehaviorSubject: BehaviorSubject<BpjsPcarePoliModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let diagnosticExaminationResultsModelsBehaviorSubject: BehaviorSubject<DiagnosticExaminationResultsModel[]>;
	let doctorScheduleModelsBehaviorSubject: BehaviorSubject<DoctorScheduleModel[]>;
	let examinationGroupModelsBehaviorSubject: BehaviorSubject<ExaminationGroupModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let examinationItemDetailModelsBehaviorSubject: BehaviorSubject<ExaminationItemDetailModel[]>;
	let mcuPackageItemModelsBehaviorSubject: BehaviorSubject<McuPackageItemModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let serviceFacilityCategoryModelsBehaviorSubject: BehaviorSubject<ServiceFacilityCategoryModel[]>;
	let serviceItemAssignmentModelsBehaviorSubject: BehaviorSubject<ServiceItemAssignmentModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;
	let tariffPackageModelsBehaviorSubject: BehaviorSubject<TariffPackageModel[]>;

	const serviceItemFactory: ServiceItemDataFactory = new ServiceItemDataFactory();
	const defaultServiceItemCount: number = 10;
	const defaultServiceItemEntities: ServiceItemModel[] = serviceItemFactory.createAll(defaultServiceItemCount);

	const bpjsPcarePoliFactory: BpjsPcarePoliDataFactory = new BpjsPcarePoliDataFactory();
	const defaultBpjsPcarePoliCount: number = 10;
	const defaultBpjsPcarePoliEntities: BpjsPcarePoliModel[] = bpjsPcarePoliFactory.createAll(defaultBpjsPcarePoliCount);

	const bpjsServiceMappingFactory: BpjsServiceMappingDataFactory = new BpjsServiceMappingDataFactory();
	const defaultBpjsServiceMappingCount: number = 10;
	const defaultBpjsServiceMappingEntities: BpjsServiceMappingModel[] = bpjsServiceMappingFactory.createAll(defaultBpjsServiceMappingCount);

	const diagnosticExaminationResultsFactory: DiagnosticExaminationResultsDataFactory = new DiagnosticExaminationResultsDataFactory();
	const defaultDiagnosticExaminationResultsCount: number = 10;
	const defaultDiagnosticExaminationResultsEntities: DiagnosticExaminationResultsModel[] = diagnosticExaminationResultsFactory.createAll(defaultDiagnosticExaminationResultsCount);

	const doctorScheduleFactory: DoctorScheduleDataFactory = new DoctorScheduleDataFactory();
	const defaultDoctorScheduleCount: number = 10;
	const defaultDoctorScheduleEntities: DoctorScheduleModel[] = doctorScheduleFactory.createAll(defaultDoctorScheduleCount);

	const examinationGroupFactory: ExaminationGroupDataFactory = new ExaminationGroupDataFactory();
	const defaultExaminationGroupCount: number = 10;
	const defaultExaminationGroupEntities: ExaminationGroupModel[] = examinationGroupFactory.createAll(defaultExaminationGroupCount);

	const examinationItemFactory: ExaminationItemDataFactory = new ExaminationItemDataFactory();
	const defaultExaminationItemCount: number = 10;
	const defaultExaminationItemEntities: ExaminationItemModel[] = examinationItemFactory.createAll(defaultExaminationItemCount);

	const examinationItemDetailFactory: ExaminationItemDetailDataFactory = new ExaminationItemDetailDataFactory();
	const defaultExaminationItemDetailCount: number = 10;
	const defaultExaminationItemDetailEntities: ExaminationItemDetailModel[] = examinationItemDetailFactory.createAll(defaultExaminationItemDetailCount);

	const mcuPackageItemFactory: McuPackageItemDataFactory = new McuPackageItemDataFactory();
	const defaultMcuPackageItemCount: number = 10;
	const defaultMcuPackageItemEntities: McuPackageItemModel[] = mcuPackageItemFactory.createAll(defaultMcuPackageItemCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);

	const serviceFacilityCategoryFactory: ServiceFacilityCategoryDataFactory = new ServiceFacilityCategoryDataFactory();
	const defaultServiceFacilityCategoryCount: number = 10;
	const defaultServiceFacilityCategoryEntities: ServiceFacilityCategoryModel[] = serviceFacilityCategoryFactory.createAll(defaultServiceFacilityCategoryCount);

	const serviceItemAssignmentFactory: ServiceItemAssignmentDataFactory = new ServiceItemAssignmentDataFactory();
	const defaultServiceItemAssignmentCount: number = 10;
	const defaultServiceItemAssignmentEntities: ServiceItemAssignmentModel[] = serviceItemAssignmentFactory.createAll(defaultServiceItemAssignmentCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);

	const tariffPackageFactory: TariffPackageDataFactory = new TariffPackageDataFactory();
	const defaultTariffPackageCount: number = 10;
	const defaultTariffPackageEntities: TariffPackageModel[] = tariffPackageFactory.createAll(defaultTariffPackageCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let serviceItemWithId: ServiceItemModel = defaultServiceItemEntities[0];
	let serviceItemModelWithIdBehaviorSubject: BehaviorSubject<ServiceItemModel>;

	serviceItemWithId.examinationItems = defaultExaminationItemEntities;
	serviceItemWithId.examinationItemsIds = serviceItemWithId.examinationItems.map(examinationItems => examinationItems.id);

	serviceItemWithId.serviceItemAssignments = defaultServiceItemAssignmentEntities;
	serviceItemWithId.serviceItemAssignmentsIds = serviceItemWithId.serviceItemAssignments.map(serviceItemAssignments => serviceItemAssignments.id);

	serviceItemWithId.services = defaultServiceEntities;
	serviceItemWithId.servicesIds = serviceItemWithId.services.map(services => services.id);


	const routerState: RouterState = {
		url: 'service-item-crud',
		urls: ['service-item-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: ServiceItemModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		serviceItemModelState = initialServiceItemModelState;
		store.setState({model: serviceItemModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		serviceItemCountBehaviorSubject = new BehaviorSubject(defaultServiceItemCount);

		// selectors for all references
		serviceItemModelsBehaviorSubject = new BehaviorSubject(defaultServiceItemEntities);
		bpjsPcarePoliModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPcarePoliEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		diagnosticExaminationResultsModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticExaminationResultsEntities);
		doctorScheduleModelsBehaviorSubject = new BehaviorSubject(defaultDoctorScheduleEntities);
		examinationGroupModelsBehaviorSubject = new BehaviorSubject(defaultExaminationGroupEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		examinationItemDetailModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemDetailEntities);
		mcuPackageItemModelsBehaviorSubject = new BehaviorSubject(defaultMcuPackageItemEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		serviceFacilityCategoryModelsBehaviorSubject = new BehaviorSubject(defaultServiceFacilityCategoryEntities);
		serviceItemAssignmentModelsBehaviorSubject = new BehaviorSubject(defaultServiceItemAssignmentEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);
		tariffPackageModelsBehaviorSubject = new BehaviorSubject(defaultTariffPackageEntities);

		// selectors for target entity and its related entity
		serviceItemModelWithIdBehaviorSubject = new BehaviorSubject(serviceItemWithId);

		spyOn(store, 'select')
			.withArgs(getCountServiceItemModels).and.returnValue(serviceItemCountBehaviorSubject)
			.withArgs(getServiceItemModelWithId, serviceItemWithId.id).and.returnValue(serviceItemModelWithIdBehaviorSubject)
			.withArgs(getServiceItemCollectionModels, jasmine.any(String)).and.returnValue(serviceItemModelsBehaviorSubject)
			.withArgs(getBpjsPcarePoliCollectionModels, jasmine.any(String)).and.returnValue(bpjsPcarePoliModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getDiagnosticExaminationResultsCollectionModels, jasmine.any(String)).and.returnValue(diagnosticExaminationResultsModelsBehaviorSubject)
			.withArgs(getDoctorScheduleCollectionModels, jasmine.any(String)).and.returnValue(doctorScheduleModelsBehaviorSubject)
			.withArgs(getExaminationGroupCollectionModels, jasmine.any(String)).and.returnValue(examinationGroupModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getExaminationItemDetailCollectionModels, jasmine.any(String)).and.returnValue(examinationItemDetailModelsBehaviorSubject)
			.withArgs(getMcuPackageItemCollectionModels, jasmine.any(String)).and.returnValue(mcuPackageItemModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getServiceFacilityCategoryCollectionModels, jasmine.any(String)).and.returnValue(serviceFacilityCategoryModelsBehaviorSubject)
			.withArgs(getServiceItemAssignmentCollectionModels, jasmine.any(String)).and.returnValue(serviceItemAssignmentModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getTariffPackageCollectionModels, jasmine.any(String)).and.returnValue(tariffPackageModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				ServiceItemCrudModule,
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

			fixture = TestBed.createComponent(ServiceItemCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new ServiceItemModel();
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
	it ('Renders the Service Item CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Examination Items relation.
	*
	* The button should only exist if examinationItemsMultiCrudActive is true
	*/
	it ('Renders Examination Items Add Entity button in create mode', fakeAsync(() => {
		const examinationItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!examinationItemsButton).toEqual(component.examinationItemsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Examination Items', fakeAsync(() => {
		const examinationItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!examinationItemsButton).toEqual(component.examinationItemsMultiCrudActive);

		if (component.examinationItemsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialExaminationItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model')).length;

			examinationItemsButton.nativeElement.click();
			fixture.detectChanges();

			const actualExaminationItemsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model')).length;

			expect(actualExaminationItemsRemoveButtonCount).toEqual(initialExaminationItemsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Examination Items button', () => {
		const examinationItemsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!examinationItemsButton).toEqual(component.examinationItemsMultiCrudActive);

		if (component.examinationItemsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			examinationItemsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialExaminationItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialExaminationItemsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualExaminationItemsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model'));

			expect(actualExaminationItemsRemoveButtons.length).toEqual(initialExaminationItemsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Examination Items button when one has already been added', () => {

		const examinationItemsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!examinationItemsButton).toEqual(component.examinationItemsMultiCrudActive);

		if (component.examinationItemsMultiCrudActive) {
			examinationItemsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedexaminationItemsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemsDisplayName + ' to Model'));

			expect(updatedexaminationItemsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Examination Items entities from model when loading in edit mode', () => {
		component.targetModel = serviceItemWithId;
		component.targetModelId = serviceItemWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.examinationItemsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const examinationItemsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemsDisplayName + ' from Model')).length;

			expect(examinationItemsRemoveButtonCount).toEqual(serviceItemWithId.examinationItems.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Service Item Assignments relation.
	*
	* The button should only exist if serviceItemAssignmentsMultiCrudActive is true
	*/
	it ('Renders Service Item Assignments Add Entity button in create mode', fakeAsync(() => {
		const serviceItemAssignmentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemAssignmentsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!serviceItemAssignmentsButton).toEqual(component.serviceItemAssignmentsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Service Item Assignments', fakeAsync(() => {
		const serviceItemAssignmentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemAssignmentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceItemAssignmentsButton).toEqual(component.serviceItemAssignmentsMultiCrudActive);

		if (component.serviceItemAssignmentsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialServiceItemAssignmentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemAssignmentsDisplayName + ' from Model')).length;

			serviceItemAssignmentsButton.nativeElement.click();
			fixture.detectChanges();

			const actualServiceItemAssignmentsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemAssignmentsDisplayName + ' from Model')).length;

			expect(actualServiceItemAssignmentsRemoveButtonCount).toEqual(initialServiceItemAssignmentsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Service Item Assignments button', () => {
		const serviceItemAssignmentsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemAssignmentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceItemAssignmentsButton).toEqual(component.serviceItemAssignmentsMultiCrudActive);

		if (component.serviceItemAssignmentsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			serviceItemAssignmentsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialServiceItemAssignmentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemAssignmentsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialServiceItemAssignmentsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualServiceItemAssignmentsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemAssignmentsDisplayName + ' from Model'));

			expect(actualServiceItemAssignmentsRemoveButtons.length).toEqual(initialServiceItemAssignmentsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Service Item Assignments button when one has already been added', () => {

		const serviceItemAssignmentsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemAssignmentsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!serviceItemAssignmentsButton).toEqual(component.serviceItemAssignmentsMultiCrudActive);

		if (component.serviceItemAssignmentsMultiCrudActive) {
			serviceItemAssignmentsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedserviceItemAssignmentsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.serviceItemAssignmentsDisplayName + ' to Model'));

			expect(updatedserviceItemAssignmentsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Service Item Assignments entities from model when loading in edit mode', () => {
		component.targetModel = serviceItemWithId;
		component.targetModelId = serviceItemWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.serviceItemAssignmentsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const serviceItemAssignmentsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.serviceItemAssignmentsDisplayName + ' from Model')).length;

			expect(serviceItemAssignmentsRemoveButtonCount).toEqual(serviceItemWithId.serviceItemAssignments.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Services relation.
	*
	* The button should only exist if servicesMultiCrudActive is true
	*/
	it ('Renders Services Add Entity button in create mode', fakeAsync(() => {
		const servicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!servicesButton).toEqual(component.servicesMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Services', fakeAsync(() => {
		const servicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!servicesButton).toEqual(component.servicesMultiCrudActive);

		if (component.servicesMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialServicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model')).length;

			servicesButton.nativeElement.click();
			fixture.detectChanges();

			const actualServicesRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model')).length;

			expect(actualServicesRemoveButtonCount).toEqual(initialServicesRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Services button', () => {
		const servicesButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!servicesButton).toEqual(component.servicesMultiCrudActive);

		if (component.servicesMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			servicesButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialServicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialServicesRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualServicesRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model'));

			expect(actualServicesRemoveButtons.length).toEqual(initialServicesRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Services button when one has already been added', () => {

		const servicesButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!servicesButton).toEqual(component.servicesMultiCrudActive);

		if (component.servicesMultiCrudActive) {
			servicesButton.nativeElement.click();
			fixture.detectChanges();

			const updatedservicesButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.servicesDisplayName + ' to Model'));

			expect(updatedservicesButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Services entities from model when loading in edit mode', () => {
		component.targetModel = serviceItemWithId;
		component.targetModelId = serviceItemWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.servicesMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const servicesRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.servicesDisplayName + ' from Model')).length;

			expect(servicesRemoveButtonCount).toEqual(serviceItemWithId.services.length);
		}
	});

});
