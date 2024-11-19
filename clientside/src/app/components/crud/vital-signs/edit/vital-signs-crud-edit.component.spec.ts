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
	getVitalSignsCollectionModels,
	getCountVitalSignsModels,
	getVitalSignsModelWithId
} from 'src/app/models/vitalSigns/vital_signs.model.selector';
import { VitalSignsCrudModule } from '../vital-signs-crud.module';
import { VitalSignsCrudEditComponent } from './vital-signs-crud-edit.component';
import {
	VitalSignsModelState,
	initialState as initialVitalSignsModelState
} from 'src/app/models/vitalSigns/vital_signs.model.state';
import { VitalSignsDataFactory } from 'src/app/lib/utils/factories/vital-signs-data-factory';
import { VitalSignsModel } from 'src/app/models/vitalSigns/vital_signs.model';
import { CrudTileMode } from '../vital-signs-crud.component';
import { getDeliveryMedicalExaminationRecordModelWithId } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import { getDeliveryMedicalExaminationRecordCollectionModels } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import { DeliveryMedicalExaminationRecordModel } from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import { DeliveryMedicalExaminationRecordDataFactory } from 'src/app/lib/utils/factories/delivery-medical-examination-record-data-factory';
import { getNewbornDetailModelWithId } from 'src/app/models/newbornDetail/newborn_detail.model.selector';
import { getNewbornDetailCollectionModels } from 'src/app/models/newbornDetail/newborn_detail.model.selector';
import { NewbornDetailModel } from 'src/app/models/newbornDetail/newborn_detail.model';
import { NewbornDetailDataFactory } from 'src/app/lib/utils/factories/newborn-detail-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('Vital Signs CRUD Edit component tests', () => {
	let fixture: ComponentFixture<VitalSignsCrudEditComponent>
	let component: VitalSignsCrudEditComponent;

	let vitalSignsModelState: VitalSignsModelState;

	let store: MockStore<{ model: VitalSignsModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let vitalSignsCountBehaviorSubject: BehaviorSubject<number>;
	let vitalSignsModelsBehaviorSubject: BehaviorSubject<VitalSignsModel[]>;
	let deliveryMedicalExaminationRecordModelsBehaviorSubject: BehaviorSubject<DeliveryMedicalExaminationRecordModel[]>;
	let newbornDetailModelsBehaviorSubject: BehaviorSubject<NewbornDetailModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const vitalSignsFactory: VitalSignsDataFactory = new VitalSignsDataFactory();
	const defaultVitalSignsCount: number = 10;
	const defaultVitalSignsEntities: VitalSignsModel[] = vitalSignsFactory.createAll(defaultVitalSignsCount);

	const deliveryMedicalExaminationRecordFactory: DeliveryMedicalExaminationRecordDataFactory = new DeliveryMedicalExaminationRecordDataFactory();
	const defaultDeliveryMedicalExaminationRecordCount: number = 10;
	const defaultDeliveryMedicalExaminationRecordEntities: DeliveryMedicalExaminationRecordModel[] = deliveryMedicalExaminationRecordFactory.createAll(defaultDeliveryMedicalExaminationRecordCount);

	const newbornDetailFactory: NewbornDetailDataFactory = new NewbornDetailDataFactory();
	const defaultNewbornDetailCount: number = 10;
	const defaultNewbornDetailEntities: NewbornDetailModel[] = newbornDetailFactory.createAll(defaultNewbornDetailCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let vitalSignsWithId: VitalSignsModel = defaultVitalSignsEntities[0];
	let vitalSignsModelWithIdBehaviorSubject: BehaviorSubject<VitalSignsModel>;

	vitalSignsWithId.newbornDetail = defaultNewbornDetailEntities[0];
	vitalSignsWithId.newbornDetailId = vitalSignsWithId.newbornDetail.id;
	let newbornDetailWithIdBehaviorSubject: BehaviorSubject<NewbornDetailModel>;


	const routerState: RouterState = {
		url: 'vital-signs-crud',
		urls: ['vital-signs-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: VitalSignsModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		vitalSignsModelState = initialVitalSignsModelState;
		store.setState({model: vitalSignsModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		vitalSignsCountBehaviorSubject = new BehaviorSubject(defaultVitalSignsCount);

		// selectors for all references
		vitalSignsModelsBehaviorSubject = new BehaviorSubject(defaultVitalSignsEntities);
		deliveryMedicalExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDeliveryMedicalExaminationRecordEntities);
		newbornDetailModelsBehaviorSubject = new BehaviorSubject(defaultNewbornDetailEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		vitalSignsModelWithIdBehaviorSubject = new BehaviorSubject(vitalSignsWithId);
		newbornDetailWithIdBehaviorSubject = new BehaviorSubject(vitalSignsWithId.newbornDetail);

		spyOn(store, 'select')
			.withArgs(getCountVitalSignsModels).and.returnValue(vitalSignsCountBehaviorSubject)
			.withArgs(getVitalSignsModelWithId, vitalSignsWithId.id).and.returnValue(vitalSignsModelWithIdBehaviorSubject)
			.withArgs(getVitalSignsCollectionModels, jasmine.any(String)).and.returnValue(vitalSignsModelsBehaviorSubject)
			.withArgs(getDeliveryMedicalExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(deliveryMedicalExaminationRecordModelsBehaviorSubject)
			.withArgs(getNewbornDetailCollectionModels, jasmine.any(String)).and.returnValue(newbornDetailModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getNewbornDetailModelWithId, vitalSignsWithId.newbornDetailId).and.returnValue(newbornDetailWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				VitalSignsCrudModule,
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

			fixture = TestBed.createComponent(VitalSignsCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new VitalSignsModel();
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
	it ('Renders the Vital Signs CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Newborn Detail relation.
	*
	* The button should only exist if newbornDetailMultiCrudActive is true
	*/
	it ('Renders Newborn Detail Add Entity button in create mode', fakeAsync(() => {
		const newbornDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!newbornDetailButton).toEqual(component.newbornDetailMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Newborn Detail', fakeAsync(() => {
		const newbornDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!newbornDetailButton).toEqual(component.newbornDetailMultiCrudActive);

		if (component.newbornDetailMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialNewbornDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailDisplayName + ' from Model')).length;

			newbornDetailButton.nativeElement.click();
			fixture.detectChanges();

			const actualNewbornDetailRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailDisplayName + ' from Model')).length;

			expect(actualNewbornDetailRemoveButtonCount).toEqual(initialNewbornDetailRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Newborn Detail button', () => {
		const newbornDetailButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!newbornDetailButton).toEqual(component.newbornDetailMultiCrudActive);

		if (component.newbornDetailMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			newbornDetailButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialNewbornDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialNewbornDetailRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualNewbornDetailRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailDisplayName + ' from Model'));

			expect(actualNewbornDetailRemoveButtons.length).toEqual(initialNewbornDetailRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Newborn Detail button when one has already been added', () => {

		const newbornDetailButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!newbornDetailButton).toEqual(component.newbornDetailMultiCrudActive);

		if (component.newbornDetailMultiCrudActive) {
			newbornDetailButton.nativeElement.click();
			fixture.detectChanges();

			const updatednewbornDetailButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.newbornDetailDisplayName + ' to Model'));

			expect(updatednewbornDetailButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Newborn Detail entities from model when loading in edit mode', () => {
		component.targetModel = vitalSignsWithId;
		component.targetModelId = vitalSignsWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.newbornDetailMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const newbornDetailRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.newbornDetailDisplayName + ' from Model')).length;

			expect(newbornDetailRemoveButtonCount).toEqual(1);
		}
	});

});
