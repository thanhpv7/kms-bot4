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
	getExaminationItemDetailCollectionModels,
	getCountExaminationItemDetailModels,
	getExaminationItemDetailModelWithId
} from 'src/app/models/examinationItemDetail/examination_item_detail.model.selector';
import { ExaminationItemDetailCrudModule } from '../examination-item-detail-crud.module';
import { ExaminationItemDetailCrudEditComponent } from './examination-item-detail-crud-edit.component';
import {
	ExaminationItemDetailModelState,
	initialState as initialExaminationItemDetailModelState
} from 'src/app/models/examinationItemDetail/examination_item_detail.model.state';
import { ExaminationItemDetailDataFactory } from 'src/app/lib/utils/factories/examination-item-detail-data-factory';
import { ExaminationItemDetailModel } from 'src/app/models/examinationItemDetail/examination_item_detail.model';
import { CrudTileMode } from '../examination-item-detail-crud.component';
import { getDiagnosticExaminationResultsModelWithId } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { getDiagnosticExaminationResultsCollectionModels } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import { DiagnosticExaminationResultsModel } from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model';
import { DiagnosticExaminationResultsDataFactory } from 'src/app/lib/utils/factories/diagnostic-examination-results-data-factory';
import { getExaminationGroupModelWithId } from 'src/app/models/examinationGroup/examination_group.model.selector';
import { getExaminationGroupCollectionModels } from 'src/app/models/examinationGroup/examination_group.model.selector';
import { ExaminationGroupModel } from 'src/app/models/examinationGroup/examination_group.model';
import { ExaminationGroupDataFactory } from 'src/app/lib/utils/factories/examination-group-data-factory';
import { getExaminationItemModelWithId } from 'src/app/models/examinationItem/examination_item.model.selector';
import { getExaminationItemCollectionModels } from 'src/app/models/examinationItem/examination_item.model.selector';
import { ExaminationItemModel } from 'src/app/models/examinationItem/examination_item.model';
import { ExaminationItemDataFactory } from 'src/app/lib/utils/factories/examination-item-data-factory';
import { getMcuPackageItemModelWithId } from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import { getMcuPackageItemCollectionModels } from 'src/app/models/mcuPackageItem/mcu_package_item.model.selector';
import { McuPackageItemModel } from 'src/app/models/mcuPackageItem/mcu_package_item.model';
import { McuPackageItemDataFactory } from 'src/app/lib/utils/factories/mcu-package-item-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';
import { getServiceItemModelWithId } from 'src/app/models/serviceItem/service_item.model.selector';
import { getServiceItemCollectionModels } from 'src/app/models/serviceItem/service_item.model.selector';
import { ServiceItemModel } from 'src/app/models/serviceItem/service_item.model';
import { ServiceItemDataFactory } from 'src/app/lib/utils/factories/service-item-data-factory';

describe('Examination Item Detail CRUD Edit component tests', () => {
	let fixture: ComponentFixture<ExaminationItemDetailCrudEditComponent>
	let component: ExaminationItemDetailCrudEditComponent;

	let examinationItemDetailModelState: ExaminationItemDetailModelState;

	let store: MockStore<{ model: ExaminationItemDetailModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let examinationItemDetailCountBehaviorSubject: BehaviorSubject<number>;
	let examinationItemDetailModelsBehaviorSubject: BehaviorSubject<ExaminationItemDetailModel[]>;
	let diagnosticExaminationResultsModelsBehaviorSubject: BehaviorSubject<DiagnosticExaminationResultsModel[]>;
	let examinationGroupModelsBehaviorSubject: BehaviorSubject<ExaminationGroupModel[]>;
	let examinationItemModelsBehaviorSubject: BehaviorSubject<ExaminationItemModel[]>;
	let mcuPackageItemModelsBehaviorSubject: BehaviorSubject<McuPackageItemModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;
	let serviceItemModelsBehaviorSubject: BehaviorSubject<ServiceItemModel[]>;

	const examinationItemDetailFactory: ExaminationItemDetailDataFactory = new ExaminationItemDetailDataFactory();
	const defaultExaminationItemDetailCount: number = 10;
	const defaultExaminationItemDetailEntities: ExaminationItemDetailModel[] = examinationItemDetailFactory.createAll(defaultExaminationItemDetailCount);

	const diagnosticExaminationResultsFactory: DiagnosticExaminationResultsDataFactory = new DiagnosticExaminationResultsDataFactory();
	const defaultDiagnosticExaminationResultsCount: number = 10;
	const defaultDiagnosticExaminationResultsEntities: DiagnosticExaminationResultsModel[] = diagnosticExaminationResultsFactory.createAll(defaultDiagnosticExaminationResultsCount);

	const examinationGroupFactory: ExaminationGroupDataFactory = new ExaminationGroupDataFactory();
	const defaultExaminationGroupCount: number = 10;
	const defaultExaminationGroupEntities: ExaminationGroupModel[] = examinationGroupFactory.createAll(defaultExaminationGroupCount);

	const examinationItemFactory: ExaminationItemDataFactory = new ExaminationItemDataFactory();
	const defaultExaminationItemCount: number = 10;
	const defaultExaminationItemEntities: ExaminationItemModel[] = examinationItemFactory.createAll(defaultExaminationItemCount);

	const mcuPackageItemFactory: McuPackageItemDataFactory = new McuPackageItemDataFactory();
	const defaultMcuPackageItemCount: number = 10;
	const defaultMcuPackageItemEntities: McuPackageItemModel[] = mcuPackageItemFactory.createAll(defaultMcuPackageItemCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);

	const serviceItemFactory: ServiceItemDataFactory = new ServiceItemDataFactory();
	const defaultServiceItemCount: number = 10;
	const defaultServiceItemEntities: ServiceItemModel[] = serviceItemFactory.createAll(defaultServiceItemCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let examinationItemDetailWithId: ExaminationItemDetailModel = defaultExaminationItemDetailEntities[0];
	let examinationItemDetailModelWithIdBehaviorSubject: BehaviorSubject<ExaminationItemDetailModel>;

	examinationItemDetailWithId.examinationItem = defaultExaminationItemEntities[0];
	examinationItemDetailWithId.examinationItemId = examinationItemDetailWithId.examinationItem.id;
	let examinationItemWithIdBehaviorSubject: BehaviorSubject<ExaminationItemModel>;


	const routerState: RouterState = {
		url: 'examination-item-detail-crud',
		urls: ['examination-item-detail-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: ExaminationItemDetailModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		examinationItemDetailModelState = initialExaminationItemDetailModelState;
		store.setState({model: examinationItemDetailModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		examinationItemDetailCountBehaviorSubject = new BehaviorSubject(defaultExaminationItemDetailCount);

		// selectors for all references
		examinationItemDetailModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemDetailEntities);
		diagnosticExaminationResultsModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosticExaminationResultsEntities);
		examinationGroupModelsBehaviorSubject = new BehaviorSubject(defaultExaminationGroupEntities);
		examinationItemModelsBehaviorSubject = new BehaviorSubject(defaultExaminationItemEntities);
		mcuPackageItemModelsBehaviorSubject = new BehaviorSubject(defaultMcuPackageItemEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);
		serviceItemModelsBehaviorSubject = new BehaviorSubject(defaultServiceItemEntities);

		// selectors for target entity and its related entity
		examinationItemDetailModelWithIdBehaviorSubject = new BehaviorSubject(examinationItemDetailWithId);
		examinationItemWithIdBehaviorSubject = new BehaviorSubject(examinationItemDetailWithId.examinationItem);

		spyOn(store, 'select')
			.withArgs(getCountExaminationItemDetailModels).and.returnValue(examinationItemDetailCountBehaviorSubject)
			.withArgs(getExaminationItemDetailModelWithId, examinationItemDetailWithId.id).and.returnValue(examinationItemDetailModelWithIdBehaviorSubject)
			.withArgs(getExaminationItemDetailCollectionModels, jasmine.any(String)).and.returnValue(examinationItemDetailModelsBehaviorSubject)
			.withArgs(getDiagnosticExaminationResultsCollectionModels, jasmine.any(String)).and.returnValue(diagnosticExaminationResultsModelsBehaviorSubject)
			.withArgs(getExaminationGroupCollectionModels, jasmine.any(String)).and.returnValue(examinationGroupModelsBehaviorSubject)
			.withArgs(getExaminationItemCollectionModels, jasmine.any(String)).and.returnValue(examinationItemModelsBehaviorSubject)
			.withArgs(getMcuPackageItemCollectionModels, jasmine.any(String)).and.returnValue(mcuPackageItemModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getServiceItemCollectionModels, jasmine.any(String)).and.returnValue(serviceItemModelsBehaviorSubject)
			.withArgs(getExaminationItemModelWithId, examinationItemDetailWithId.examinationItemId).and.returnValue(examinationItemWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				ExaminationItemDetailCrudModule,
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

			fixture = TestBed.createComponent(ExaminationItemDetailCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new ExaminationItemDetailModel();
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
	it ('Renders the Examination Item Detail CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Examination Item relation.
	*
	* The button should only exist if examinationItemMultiCrudActive is true
	*/
	it ('Renders Examination Item Add Entity button in create mode', fakeAsync(() => {
		const examinationItemButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!examinationItemButton).toEqual(component.examinationItemMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Examination Item', fakeAsync(() => {
		const examinationItemButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!examinationItemButton).toEqual(component.examinationItemMultiCrudActive);

		if (component.examinationItemMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialExaminationItemRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemDisplayName + ' from Model')).length;

			examinationItemButton.nativeElement.click();
			fixture.detectChanges();

			const actualExaminationItemRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemDisplayName + ' from Model')).length;

			expect(actualExaminationItemRemoveButtonCount).toEqual(initialExaminationItemRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Examination Item button', () => {
		const examinationItemButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!examinationItemButton).toEqual(component.examinationItemMultiCrudActive);

		if (component.examinationItemMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			examinationItemButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialExaminationItemRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialExaminationItemRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualExaminationItemRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemDisplayName + ' from Model'));

			expect(actualExaminationItemRemoveButtons.length).toEqual(initialExaminationItemRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Examination Item button when one has already been added', () => {

		const examinationItemButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!examinationItemButton).toEqual(component.examinationItemMultiCrudActive);

		if (component.examinationItemMultiCrudActive) {
			examinationItemButton.nativeElement.click();
			fixture.detectChanges();

			const updatedexaminationItemButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.examinationItemDisplayName + ' to Model'));

			expect(updatedexaminationItemButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Examination Item entities from model when loading in edit mode', () => {
		component.targetModel = examinationItemDetailWithId;
		component.targetModelId = examinationItemDetailWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.examinationItemMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const examinationItemRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.examinationItemDisplayName + ' from Model')).length;

			expect(examinationItemRemoveButtonCount).toEqual(1);
		}
	});

});
