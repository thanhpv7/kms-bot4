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
	getBpjsSpecialReferralCollectionModels,
	getCountBpjsSpecialReferralModels,
	getBpjsSpecialReferralModelWithId
} from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.selector';
import { BpjsSpecialReferralCrudModule } from '../bpjs-special-referral-crud.module';
import { BpjsSpecialReferralCrudEditComponent } from './bpjs-special-referral-crud-edit.component';
import {
	BpjsSpecialReferralModelState,
	initialState as initialBpjsSpecialReferralModelState
} from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.state';
import { BpjsSpecialReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-special-referral-data-factory';
import { BpjsSpecialReferralModel } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model';
import { CrudTileMode } from '../bpjs-special-referral-crud.component';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getBpjsDiagnoseModelWithId } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { getBpjsDiagnoseCollectionModels } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { BpjsDiagnoseModel } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import { BpjsDiagnoseDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-data-factory';
import { getBpjsPatientReferralModelWithId } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { getBpjsPatientReferralCollectionModels } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { BpjsPatientReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-patient-referral-data-factory';
import { getBpjsProcedureModelWithId } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { getBpjsProcedureCollectionModels } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { BpjsProcedureModel } from 'src/app/models/bpjsProcedure/bpjs_procedure.model';
import { BpjsProcedureDataFactory } from 'src/app/lib/utils/factories/bpjs-procedure-data-factory';
import { getDiagnosesAndProceduresModelWithId } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { getDiagnosesAndProceduresCollectionModels } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { DiagnosesAndProceduresDataFactory } from 'src/app/lib/utils/factories/diagnoses-and-procedures-data-factory';

describe('BPJS Special Referral CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsSpecialReferralCrudEditComponent>
	let component: BpjsSpecialReferralCrudEditComponent;

	let bpjsSpecialReferralModelState: BpjsSpecialReferralModelState;

	let store: MockStore<{ model: BpjsSpecialReferralModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsSpecialReferralCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsSpecialReferralModelsBehaviorSubject: BehaviorSubject<BpjsSpecialReferralModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsPatientReferralModelsBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel[]>;
	let bpjsProcedureModelsBehaviorSubject: BehaviorSubject<BpjsProcedureModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;

	const bpjsSpecialReferralFactory: BpjsSpecialReferralDataFactory = new BpjsSpecialReferralDataFactory();
	const defaultBpjsSpecialReferralCount: number = 10;
	const defaultBpjsSpecialReferralEntities: BpjsSpecialReferralModel[] = bpjsSpecialReferralFactory.createAll(defaultBpjsSpecialReferralCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsDiagnoseFactory: BpjsDiagnoseDataFactory = new BpjsDiagnoseDataFactory();
	const defaultBpjsDiagnoseCount: number = 10;
	const defaultBpjsDiagnoseEntities: BpjsDiagnoseModel[] = bpjsDiagnoseFactory.createAll(defaultBpjsDiagnoseCount);

	const bpjsPatientReferralFactory: BpjsPatientReferralDataFactory = new BpjsPatientReferralDataFactory();
	const defaultBpjsPatientReferralCount: number = 10;
	const defaultBpjsPatientReferralEntities: BpjsPatientReferralModel[] = bpjsPatientReferralFactory.createAll(defaultBpjsPatientReferralCount);

	const bpjsProcedureFactory: BpjsProcedureDataFactory = new BpjsProcedureDataFactory();
	const defaultBpjsProcedureCount: number = 10;
	const defaultBpjsProcedureEntities: BpjsProcedureModel[] = bpjsProcedureFactory.createAll(defaultBpjsProcedureCount);

	const diagnosesAndProceduresFactory: DiagnosesAndProceduresDataFactory = new DiagnosesAndProceduresDataFactory();
	const defaultDiagnosesAndProceduresCount: number = 10;
	const defaultDiagnosesAndProceduresEntities: DiagnosesAndProceduresModel[] = diagnosesAndProceduresFactory.createAll(defaultDiagnosesAndProceduresCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsSpecialReferralWithId: BpjsSpecialReferralModel = defaultBpjsSpecialReferralEntities[0];
	let bpjsSpecialReferralModelWithIdBehaviorSubject: BehaviorSubject<BpjsSpecialReferralModel>;

	bpjsSpecialReferralWithId.additionalDiagnose = defaultBpjsDiagnoseEntities[0];
	bpjsSpecialReferralWithId.additionalDiagnoseId = bpjsSpecialReferralWithId.additionalDiagnose.id;
	let additionalDiagnoseWithIdBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel>;

	bpjsSpecialReferralWithId.additionalProcedure = defaultBpjsProcedureEntities[0];
	bpjsSpecialReferralWithId.additionalProcedureId = bpjsSpecialReferralWithId.additionalProcedure.id;
	let additionalProcedureWithIdBehaviorSubject: BehaviorSubject<BpjsProcedureModel>;

	bpjsSpecialReferralWithId.primaryDiagnose = defaultBpjsDiagnoseEntities[0];
	bpjsSpecialReferralWithId.primaryDiagnoseId = bpjsSpecialReferralWithId.primaryDiagnose.id;
	let primaryDiagnoseWithIdBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel>;

	bpjsSpecialReferralWithId.primaryProcedure = defaultBpjsProcedureEntities[0];
	bpjsSpecialReferralWithId.primaryProcedureId = bpjsSpecialReferralWithId.primaryProcedure.id;
	let primaryProcedureWithIdBehaviorSubject: BehaviorSubject<BpjsProcedureModel>;


	const routerState: RouterState = {
		url: 'bpjs-special-referral-crud',
		urls: ['bpjs-special-referral-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsSpecialReferralModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsSpecialReferralModelState = initialBpjsSpecialReferralModelState;
		store.setState({model: bpjsSpecialReferralModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsSpecialReferralCountBehaviorSubject = new BehaviorSubject(defaultBpjsSpecialReferralCount);

		// selectors for all references
		bpjsSpecialReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSpecialReferralEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsPatientReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralEntities);
		bpjsProcedureModelsBehaviorSubject = new BehaviorSubject(defaultBpjsProcedureEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);

		// selectors for target entity and its related entity
		bpjsSpecialReferralModelWithIdBehaviorSubject = new BehaviorSubject(bpjsSpecialReferralWithId);
		additionalDiagnoseWithIdBehaviorSubject = new BehaviorSubject(bpjsSpecialReferralWithId.additionalDiagnose);
		additionalProcedureWithIdBehaviorSubject = new BehaviorSubject(bpjsSpecialReferralWithId.additionalProcedure);
		primaryDiagnoseWithIdBehaviorSubject = new BehaviorSubject(bpjsSpecialReferralWithId.primaryDiagnose);
		primaryProcedureWithIdBehaviorSubject = new BehaviorSubject(bpjsSpecialReferralWithId.primaryProcedure);

		spyOn(store, 'select')
			.withArgs(getCountBpjsSpecialReferralModels).and.returnValue(bpjsSpecialReferralCountBehaviorSubject)
			.withArgs(getBpjsSpecialReferralModelWithId, bpjsSpecialReferralWithId.id).and.returnValue(bpjsSpecialReferralModelWithIdBehaviorSubject)
			.withArgs(getBpjsSpecialReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsSpecialReferralModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsPatientReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsPatientReferralModelsBehaviorSubject)
			.withArgs(getBpjsProcedureCollectionModels, jasmine.any(String)).and.returnValue(bpjsProcedureModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseModelWithId, bpjsSpecialReferralWithId.additionalDiagnoseId).and.returnValue(additionalDiagnoseWithIdBehaviorSubject)
			.withArgs(getBpjsProcedureModelWithId, bpjsSpecialReferralWithId.additionalProcedureId).and.returnValue(additionalProcedureWithIdBehaviorSubject)
			.withArgs(getBpjsDiagnoseModelWithId, bpjsSpecialReferralWithId.primaryDiagnoseId).and.returnValue(primaryDiagnoseWithIdBehaviorSubject)
			.withArgs(getBpjsProcedureModelWithId, bpjsSpecialReferralWithId.primaryProcedureId).and.returnValue(primaryProcedureWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsSpecialReferralCrudModule,
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

			fixture = TestBed.createComponent(BpjsSpecialReferralCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsSpecialReferralModel();
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
	it ('Renders the BPJS Special Referral CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Additional Diagnose relation.
	*
	* The button should only exist if additionalDiagnoseMultiCrudActive is true
	*/
	it ('Renders Additional Diagnose Add Entity button in create mode', fakeAsync(() => {
		const additionalDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalDiagnoseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!additionalDiagnoseButton).toEqual(component.additionalDiagnoseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Additional Diagnose', fakeAsync(() => {
		const additionalDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!additionalDiagnoseButton).toEqual(component.additionalDiagnoseMultiCrudActive);

		if (component.additionalDiagnoseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAdditionalDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalDiagnoseDisplayName + ' from Model')).length;

			additionalDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const actualAdditionalDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalDiagnoseDisplayName + ' from Model')).length;

			expect(actualAdditionalDiagnoseRemoveButtonCount).toEqual(initialAdditionalDiagnoseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Additional Diagnose button', () => {
		const additionalDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!additionalDiagnoseButton).toEqual(component.additionalDiagnoseMultiCrudActive);

		if (component.additionalDiagnoseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			additionalDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAdditionalDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalDiagnoseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAdditionalDiagnoseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAdditionalDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalDiagnoseDisplayName + ' from Model'));

			expect(actualAdditionalDiagnoseRemoveButtons.length).toEqual(initialAdditionalDiagnoseRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Additional Diagnose button when one has already been added', () => {

		const additionalDiagnoseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!additionalDiagnoseButton).toEqual(component.additionalDiagnoseMultiCrudActive);

		if (component.additionalDiagnoseMultiCrudActive) {
			additionalDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const updatedadditionalDiagnoseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalDiagnoseDisplayName + ' to Model'));

			expect(updatedadditionalDiagnoseButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Additional Diagnose entities from model when loading in edit mode', () => {
		component.targetModel = bpjsSpecialReferralWithId;
		component.targetModelId = bpjsSpecialReferralWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.additionalDiagnoseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const additionalDiagnoseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalDiagnoseDisplayName + ' from Model')).length;

			expect(additionalDiagnoseRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Additional Procedure relation.
	*
	* The button should only exist if additionalProcedureMultiCrudActive is true
	*/
	it ('Renders Additional Procedure Add Entity button in create mode', fakeAsync(() => {
		const additionalProcedureButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalProcedureDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!additionalProcedureButton).toEqual(component.additionalProcedureMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Additional Procedure', fakeAsync(() => {
		const additionalProcedureButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalProcedureDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!additionalProcedureButton).toEqual(component.additionalProcedureMultiCrudActive);

		if (component.additionalProcedureMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialAdditionalProcedureRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalProcedureDisplayName + ' from Model')).length;

			additionalProcedureButton.nativeElement.click();
			fixture.detectChanges();

			const actualAdditionalProcedureRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalProcedureDisplayName + ' from Model')).length;

			expect(actualAdditionalProcedureRemoveButtonCount).toEqual(initialAdditionalProcedureRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Additional Procedure button', () => {
		const additionalProcedureButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalProcedureDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!additionalProcedureButton).toEqual(component.additionalProcedureMultiCrudActive);

		if (component.additionalProcedureMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			additionalProcedureButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialAdditionalProcedureRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalProcedureDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialAdditionalProcedureRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualAdditionalProcedureRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalProcedureDisplayName + ' from Model'));

			expect(actualAdditionalProcedureRemoveButtons.length).toEqual(initialAdditionalProcedureRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Additional Procedure button when one has already been added', () => {

		const additionalProcedureButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalProcedureDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!additionalProcedureButton).toEqual(component.additionalProcedureMultiCrudActive);

		if (component.additionalProcedureMultiCrudActive) {
			additionalProcedureButton.nativeElement.click();
			fixture.detectChanges();

			const updatedadditionalProcedureButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.additionalProcedureDisplayName + ' to Model'));

			expect(updatedadditionalProcedureButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Additional Procedure entities from model when loading in edit mode', () => {
		component.targetModel = bpjsSpecialReferralWithId;
		component.targetModelId = bpjsSpecialReferralWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.additionalProcedureMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const additionalProcedureRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.additionalProcedureDisplayName + ' from Model')).length;

			expect(additionalProcedureRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Primary Diagnose relation.
	*
	* The button should only exist if primaryDiagnoseMultiCrudActive is true
	*/
	it ('Renders Primary Diagnose Add Entity button in create mode', fakeAsync(() => {
		const primaryDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryDiagnoseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!primaryDiagnoseButton).toEqual(component.primaryDiagnoseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Primary Diagnose', fakeAsync(() => {
		const primaryDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!primaryDiagnoseButton).toEqual(component.primaryDiagnoseMultiCrudActive);

		if (component.primaryDiagnoseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPrimaryDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryDiagnoseDisplayName + ' from Model')).length;

			primaryDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const actualPrimaryDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryDiagnoseDisplayName + ' from Model')).length;

			expect(actualPrimaryDiagnoseRemoveButtonCount).toEqual(initialPrimaryDiagnoseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Primary Diagnose button', () => {
		const primaryDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!primaryDiagnoseButton).toEqual(component.primaryDiagnoseMultiCrudActive);

		if (component.primaryDiagnoseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			primaryDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPrimaryDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryDiagnoseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPrimaryDiagnoseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPrimaryDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryDiagnoseDisplayName + ' from Model'));

			expect(actualPrimaryDiagnoseRemoveButtons.length).toEqual(initialPrimaryDiagnoseRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Primary Diagnose button when one has already been added', () => {

		const primaryDiagnoseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!primaryDiagnoseButton).toEqual(component.primaryDiagnoseMultiCrudActive);

		if (component.primaryDiagnoseMultiCrudActive) {
			primaryDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const updatedprimaryDiagnoseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryDiagnoseDisplayName + ' to Model'));

			expect(updatedprimaryDiagnoseButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Primary Diagnose entities from model when loading in edit mode', () => {
		component.targetModel = bpjsSpecialReferralWithId;
		component.targetModelId = bpjsSpecialReferralWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.primaryDiagnoseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const primaryDiagnoseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryDiagnoseDisplayName + ' from Model')).length;

			expect(primaryDiagnoseRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the Primary Procedure relation.
	*
	* The button should only exist if primaryProcedureMultiCrudActive is true
	*/
	it ('Renders Primary Procedure Add Entity button in create mode', fakeAsync(() => {
		const primaryProcedureButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryProcedureDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!primaryProcedureButton).toEqual(component.primaryProcedureMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Primary Procedure', fakeAsync(() => {
		const primaryProcedureButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryProcedureDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!primaryProcedureButton).toEqual(component.primaryProcedureMultiCrudActive);

		if (component.primaryProcedureMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPrimaryProcedureRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryProcedureDisplayName + ' from Model')).length;

			primaryProcedureButton.nativeElement.click();
			fixture.detectChanges();

			const actualPrimaryProcedureRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryProcedureDisplayName + ' from Model')).length;

			expect(actualPrimaryProcedureRemoveButtonCount).toEqual(initialPrimaryProcedureRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Primary Procedure button', () => {
		const primaryProcedureButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryProcedureDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!primaryProcedureButton).toEqual(component.primaryProcedureMultiCrudActive);

		if (component.primaryProcedureMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			primaryProcedureButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPrimaryProcedureRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryProcedureDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPrimaryProcedureRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPrimaryProcedureRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryProcedureDisplayName + ' from Model'));

			expect(actualPrimaryProcedureRemoveButtons.length).toEqual(initialPrimaryProcedureRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Primary Procedure button when one has already been added', () => {

		const primaryProcedureButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryProcedureDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!primaryProcedureButton).toEqual(component.primaryProcedureMultiCrudActive);

		if (component.primaryProcedureMultiCrudActive) {
			primaryProcedureButton.nativeElement.click();
			fixture.detectChanges();

			const updatedprimaryProcedureButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.primaryProcedureDisplayName + ' to Model'));

			expect(updatedprimaryProcedureButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Primary Procedure entities from model when loading in edit mode', () => {
		component.targetModel = bpjsSpecialReferralWithId;
		component.targetModelId = bpjsSpecialReferralWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.primaryProcedureMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const primaryProcedureRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.primaryProcedureDisplayName + ' from Model')).length;

			expect(primaryProcedureRemoveButtonCount).toEqual(1);
		}
	});

});
