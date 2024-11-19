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
	getHospitalGroupInformationCollectionModels,
	getCountHospitalGroupInformationModels,
	getHospitalGroupInformationModelWithId
} from 'src/app/models/hospitalGroupInformation/hospital_group_information.model.selector';
import { HospitalGroupInformationCrudModule } from '../hospital-group-information-crud.module';
import { HospitalGroupInformationCrudEditComponent } from './hospital-group-information-crud-edit.component';
import {
	HospitalGroupInformationModelState,
	initialState as initialHospitalGroupInformationModelState
} from 'src/app/models/hospitalGroupInformation/hospital_group_information.model.state';
import { HospitalGroupInformationDataFactory } from 'src/app/lib/utils/factories/hospital-group-information-data-factory';
import { HospitalGroupInformationModel } from 'src/app/models/hospitalGroupInformation/hospital_group_information.model';
import { CrudTileMode } from '../hospital-group-information-crud.component';
import { getHospitalBranchInformationModelWithId } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.selector';
import { getHospitalBranchInformationCollectionModels } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model.selector';
import { HospitalBranchInformationModel } from 'src/app/models/hospitalBranchInformation/hospital_branch_information.model';
import { HospitalBranchInformationDataFactory } from 'src/app/lib/utils/factories/hospital-branch-information-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('Hospital Group Information CRUD Edit component tests', () => {
	let fixture: ComponentFixture<HospitalGroupInformationCrudEditComponent>
	let component: HospitalGroupInformationCrudEditComponent;

	let hospitalGroupInformationModelState: HospitalGroupInformationModelState;

	let store: MockStore<{ model: HospitalGroupInformationModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let hospitalGroupInformationCountBehaviorSubject: BehaviorSubject<number>;
	let hospitalGroupInformationModelsBehaviorSubject: BehaviorSubject<HospitalGroupInformationModel[]>;
	let hospitalBranchInformationModelsBehaviorSubject: BehaviorSubject<HospitalBranchInformationModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const hospitalGroupInformationFactory: HospitalGroupInformationDataFactory = new HospitalGroupInformationDataFactory();
	const defaultHospitalGroupInformationCount: number = 10;
	const defaultHospitalGroupInformationEntities: HospitalGroupInformationModel[] = hospitalGroupInformationFactory.createAll(defaultHospitalGroupInformationCount);

	const hospitalBranchInformationFactory: HospitalBranchInformationDataFactory = new HospitalBranchInformationDataFactory();
	const defaultHospitalBranchInformationCount: number = 10;
	const defaultHospitalBranchInformationEntities: HospitalBranchInformationModel[] = hospitalBranchInformationFactory.createAll(defaultHospitalBranchInformationCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let hospitalGroupInformationWithId: HospitalGroupInformationModel = defaultHospitalGroupInformationEntities[0];
	let hospitalGroupInformationModelWithIdBehaviorSubject: BehaviorSubject<HospitalGroupInformationModel>;

	hospitalGroupInformationWithId.hospitalBranchInformations = defaultHospitalBranchInformationEntities;
	hospitalGroupInformationWithId.hospitalBranchInformationsIds = hospitalGroupInformationWithId.hospitalBranchInformations.map(hospitalBranchInformations => hospitalBranchInformations.id);


	const routerState: RouterState = {
		url: 'hospital-group-information-crud',
		urls: ['hospital-group-information-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: HospitalGroupInformationModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		hospitalGroupInformationModelState = initialHospitalGroupInformationModelState;
		store.setState({model: hospitalGroupInformationModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		hospitalGroupInformationCountBehaviorSubject = new BehaviorSubject(defaultHospitalGroupInformationCount);

		// selectors for all references
		hospitalGroupInformationModelsBehaviorSubject = new BehaviorSubject(defaultHospitalGroupInformationEntities);
		hospitalBranchInformationModelsBehaviorSubject = new BehaviorSubject(defaultHospitalBranchInformationEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		hospitalGroupInformationModelWithIdBehaviorSubject = new BehaviorSubject(hospitalGroupInformationWithId);

		spyOn(store, 'select')
			.withArgs(getCountHospitalGroupInformationModels).and.returnValue(hospitalGroupInformationCountBehaviorSubject)
			.withArgs(getHospitalGroupInformationModelWithId, hospitalGroupInformationWithId.id).and.returnValue(hospitalGroupInformationModelWithIdBehaviorSubject)
			.withArgs(getHospitalGroupInformationCollectionModels, jasmine.any(String)).and.returnValue(hospitalGroupInformationModelsBehaviorSubject)
			.withArgs(getHospitalBranchInformationCollectionModels, jasmine.any(String)).and.returnValue(hospitalBranchInformationModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				HospitalGroupInformationCrudModule,
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

			fixture = TestBed.createComponent(HospitalGroupInformationCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new HospitalGroupInformationModel();
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
	it ('Renders the Hospital Group Information CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Hospital Branch Informations relation.
	*
	* The button should only exist if hospitalBranchInformationsMultiCrudActive is true
	*/
	it ('Renders Hospital Branch Informations Add Entity button in create mode', fakeAsync(() => {
		const hospitalBranchInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!hospitalBranchInformationsButton).toEqual(component.hospitalBranchInformationsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Hospital Branch Informations', fakeAsync(() => {
		const hospitalBranchInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!hospitalBranchInformationsButton).toEqual(component.hospitalBranchInformationsMultiCrudActive);

		if (component.hospitalBranchInformationsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialHospitalBranchInformationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model')).length;

			hospitalBranchInformationsButton.nativeElement.click();
			fixture.detectChanges();

			const actualHospitalBranchInformationsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model')).length;

			expect(actualHospitalBranchInformationsRemoveButtonCount).toEqual(initialHospitalBranchInformationsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Hospital Branch Informations button', () => {
		const hospitalBranchInformationsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!hospitalBranchInformationsButton).toEqual(component.hospitalBranchInformationsMultiCrudActive);

		if (component.hospitalBranchInformationsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			hospitalBranchInformationsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialHospitalBranchInformationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialHospitalBranchInformationsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualHospitalBranchInformationsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model'));

			expect(actualHospitalBranchInformationsRemoveButtons.length).toEqual(initialHospitalBranchInformationsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add Hospital Branch Informations button when one has already been added', () => {

		const hospitalBranchInformationsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!hospitalBranchInformationsButton).toEqual(component.hospitalBranchInformationsMultiCrudActive);

		if (component.hospitalBranchInformationsMultiCrudActive) {
			hospitalBranchInformationsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedhospitalBranchInformationsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.hospitalBranchInformationsDisplayName + ' to Model'));

			expect(updatedhospitalBranchInformationsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related Hospital Branch Informations entities from model when loading in edit mode', () => {
		component.targetModel = hospitalGroupInformationWithId;
		component.targetModelId = hospitalGroupInformationWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.hospitalBranchInformationsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const hospitalBranchInformationsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.hospitalBranchInformationsDisplayName + ' from Model')).length;

			expect(hospitalBranchInformationsRemoveButtonCount).toEqual(hospitalGroupInformationWithId.hospitalBranchInformations.length);
		}
	});

});
