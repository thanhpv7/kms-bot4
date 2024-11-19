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
	getBpjsPRBCollectionModels,
	getCountBpjsPRBModels,
	getBpjsPRBModelWithId
} from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { BpjsPRBCrudModule } from '../bpjs-prb-crud.module';
import { BpjsPRBCrudEditComponent } from './bpjs-prb-crud-edit.component';
import {
	BpjsPRBModelState,
	initialState as initialBpjsPRBModelState
} from 'src/app/models/bpjsPRB/bpjs_prb.model.state';
import { BpjsPRBDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-data-factory';
import { BpjsPRBModel } from 'src/app/models/bpjsPRB/bpjs_prb.model';
import { CrudTileMode } from '../bpjs-prb-crud.component';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getBpjsControlPlanModelWithId } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import { getBpjsControlPlanCollectionModels } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import { BpjsControlPlanModel } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model';
import { BpjsControlPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-control-plan-data-factory';
import { getBpjsDiagnosePRBModelWithId } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.selector';
import { getBpjsDiagnosePRBCollectionModels } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.selector';
import { BpjsDiagnosePRBModel } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model';
import { BpjsDiagnosePRBDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-prb-data-factory';
import { getBpjsDoctorMappingModelWithId } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-doctor-mapping-data-factory';
import { getBpjsHospitalizationPlanModelWithId } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { getBpjsHospitalizationPlanCollectionModels } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { BpjsHospitalizationPlanModel } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import { BpjsHospitalizationPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-hospitalization-plan-data-factory';
import { getDiagnosesAndProceduresModelWithId } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { getDiagnosesAndProceduresCollectionModels } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { DiagnosesAndProceduresDataFactory } from 'src/app/lib/utils/factories/diagnoses-and-procedures-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('BPJS PRB CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsPRBCrudEditComponent>
	let component: BpjsPRBCrudEditComponent;

	let bpjsPRBModelState: BpjsPRBModelState;

	let store: MockStore<{ model: BpjsPRBModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsPRBCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsPRBModelsBehaviorSubject: BehaviorSubject<BpjsPRBModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsControlPlanModelsBehaviorSubject: BehaviorSubject<BpjsControlPlanModel[]>;
	let bpjsDiagnosePRBModelsBehaviorSubject: BehaviorSubject<BpjsDiagnosePRBModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsHospitalizationPlanModelsBehaviorSubject: BehaviorSubject<BpjsHospitalizationPlanModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const bpjsPRBFactory: BpjsPRBDataFactory = new BpjsPRBDataFactory();
	const defaultBpjsPRBCount: number = 10;
	const defaultBpjsPRBEntities: BpjsPRBModel[] = bpjsPRBFactory.createAll(defaultBpjsPRBCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsControlPlanFactory: BpjsControlPlanDataFactory = new BpjsControlPlanDataFactory();
	const defaultBpjsControlPlanCount: number = 10;
	const defaultBpjsControlPlanEntities: BpjsControlPlanModel[] = bpjsControlPlanFactory.createAll(defaultBpjsControlPlanCount);

	const bpjsDiagnosePRBFactory: BpjsDiagnosePRBDataFactory = new BpjsDiagnosePRBDataFactory();
	const defaultBpjsDiagnosePRBCount: number = 10;
	const defaultBpjsDiagnosePRBEntities: BpjsDiagnosePRBModel[] = bpjsDiagnosePRBFactory.createAll(defaultBpjsDiagnosePRBCount);

	const bpjsDoctorMappingFactory: BpjsDoctorMappingDataFactory = new BpjsDoctorMappingDataFactory();
	const defaultBpjsDoctorMappingCount: number = 10;
	const defaultBpjsDoctorMappingEntities: BpjsDoctorMappingModel[] = bpjsDoctorMappingFactory.createAll(defaultBpjsDoctorMappingCount);

	const bpjsHospitalizationPlanFactory: BpjsHospitalizationPlanDataFactory = new BpjsHospitalizationPlanDataFactory();
	const defaultBpjsHospitalizationPlanCount: number = 10;
	const defaultBpjsHospitalizationPlanEntities: BpjsHospitalizationPlanModel[] = bpjsHospitalizationPlanFactory.createAll(defaultBpjsHospitalizationPlanCount);

	const diagnosesAndProceduresFactory: DiagnosesAndProceduresDataFactory = new DiagnosesAndProceduresDataFactory();
	const defaultDiagnosesAndProceduresCount: number = 10;
	const defaultDiagnosesAndProceduresEntities: DiagnosesAndProceduresModel[] = diagnosesAndProceduresFactory.createAll(defaultDiagnosesAndProceduresCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsPRBWithId: BpjsPRBModel = defaultBpjsPRBEntities[0];
	let bpjsPRBModelWithIdBehaviorSubject: BehaviorSubject<BpjsPRBModel>;

	bpjsPRBWithId.bpjsDiagnosePRB = defaultBpjsDiagnosePRBEntities[0];
	bpjsPRBWithId.bpjsDiagnosePRBId = bpjsPRBWithId.bpjsDiagnosePRB.id;
	let bpjsDiagnosePRBWithIdBehaviorSubject: BehaviorSubject<BpjsDiagnosePRBModel>;

	bpjsPRBWithId.bpjsDoctorMapping = defaultBpjsDoctorMappingEntities[0];
	bpjsPRBWithId.bpjsDoctorMappingId = bpjsPRBWithId.bpjsDoctorMapping.id;
	let bpjsDoctorMappingWithIdBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel>;


	const routerState: RouterState = {
		url: 'bpjs-prb-crud',
		urls: ['bpjs-prb-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsPRBModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsPRBModelState = initialBpjsPRBModelState;
		store.setState({model: bpjsPRBModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsPRBCountBehaviorSubject = new BehaviorSubject(defaultBpjsPRBCount);

		// selectors for all references
		bpjsPRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsControlPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsControlPlanEntities);
		bpjsDiagnosePRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnosePRBEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsHospitalizationPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHospitalizationPlanEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		bpjsPRBModelWithIdBehaviorSubject = new BehaviorSubject(bpjsPRBWithId);
		bpjsDiagnosePRBWithIdBehaviorSubject = new BehaviorSubject(bpjsPRBWithId.bpjsDiagnosePRB);
		bpjsDoctorMappingWithIdBehaviorSubject = new BehaviorSubject(bpjsPRBWithId.bpjsDoctorMapping);

		spyOn(store, 'select')
			.withArgs(getCountBpjsPRBModels).and.returnValue(bpjsPRBCountBehaviorSubject)
			.withArgs(getBpjsPRBModelWithId, bpjsPRBWithId.id).and.returnValue(bpjsPRBModelWithIdBehaviorSubject)
			.withArgs(getBpjsPRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsControlPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsControlPlanModelsBehaviorSubject)
			.withArgs(getBpjsDiagnosePRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnosePRBModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsHospitalizationPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsHospitalizationPlanModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getBpjsDiagnosePRBModelWithId, bpjsPRBWithId.bpjsDiagnosePRBId).and.returnValue(bpjsDiagnosePRBWithIdBehaviorSubject)
			.withArgs(getBpjsDoctorMappingModelWithId, bpjsPRBWithId.bpjsDoctorMappingId).and.returnValue(bpjsDoctorMappingWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsPRBCrudModule,
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

			fixture = TestBed.createComponent(BpjsPRBCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsPRBModel();
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
	it ('Renders the BPJS PRB CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the BPJS Diagnose PRB relation.
	*
	* The button should only exist if bpjsDiagnosePRBMultiCrudActive is true
	*/
	it ('Renders BPJS Diagnose PRB Add Entity button in create mode', fakeAsync(() => {
		const bpjsDiagnosePRBButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDiagnosePRBButton).toEqual(component.bpjsDiagnosePRBMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Diagnose PRB', fakeAsync(() => {
		const bpjsDiagnosePRBButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnosePRBButton).toEqual(component.bpjsDiagnosePRBMultiCrudActive);

		if (component.bpjsDiagnosePRBMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDiagnosePRBRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model')).length;

			bpjsDiagnosePRBButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnosePRBRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model')).length;

			expect(actualBpjsDiagnosePRBRemoveButtonCount).toEqual(initialBpjsDiagnosePRBRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Diagnose PRB button', () => {
		const bpjsDiagnosePRBButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnosePRBButton).toEqual(component.bpjsDiagnosePRBMultiCrudActive);

		if (component.bpjsDiagnosePRBMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDiagnosePRBButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDiagnosePRBRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDiagnosePRBRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnosePRBRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model'));

			expect(actualBpjsDiagnosePRBRemoveButtons.length).toEqual(initialBpjsDiagnosePRBRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Diagnose PRB button when one has already been added', () => {

		const bpjsDiagnosePRBButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnosePRBButton).toEqual(component.bpjsDiagnosePRBMultiCrudActive);

		if (component.bpjsDiagnosePRBMultiCrudActive) {
			bpjsDiagnosePRBButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDiagnosePRBButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnosePRBDisplayName + ' to Model'));

			expect(updatedbpjsDiagnosePRBButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Diagnose PRB entities from model when loading in edit mode', () => {
		component.targetModel = bpjsPRBWithId;
		component.targetModelId = bpjsPRBWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDiagnosePRBMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDiagnosePRBRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnosePRBDisplayName + ' from Model')).length;

			expect(bpjsDiagnosePRBRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Doctor Mapping relation.
	*
	* The button should only exist if bpjsDoctorMappingMultiCrudActive is true
	*/
	it ('Renders BPJS Doctor Mapping Add Entity button in create mode', fakeAsync(() => {
		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Doctor Mapping', fakeAsync(() => {
		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);

		if (component.bpjsDoctorMappingMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDoctorMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model')).length;

			bpjsDoctorMappingButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDoctorMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model')).length;

			expect(actualBpjsDoctorMappingRemoveButtonCount).toEqual(initialBpjsDoctorMappingRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Doctor Mapping button', () => {
		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);

		if (component.bpjsDoctorMappingMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDoctorMappingButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDoctorMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDoctorMappingRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDoctorMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model'));

			expect(actualBpjsDoctorMappingRemoveButtons.length).toEqual(initialBpjsDoctorMappingRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Doctor Mapping button when one has already been added', () => {

		const bpjsDoctorMappingButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDoctorMappingButton).toEqual(component.bpjsDoctorMappingMultiCrudActive);

		if (component.bpjsDoctorMappingMultiCrudActive) {
			bpjsDoctorMappingButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDoctorMappingButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDoctorMappingDisplayName + ' to Model'));

			expect(updatedbpjsDoctorMappingButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Doctor Mapping entities from model when loading in edit mode', () => {
		component.targetModel = bpjsPRBWithId;
		component.targetModelId = bpjsPRBWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDoctorMappingMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDoctorMappingRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDoctorMappingDisplayName + ' from Model')).length;

			expect(bpjsDoctorMappingRemoveButtonCount).toEqual(1);
		}
	});

});
