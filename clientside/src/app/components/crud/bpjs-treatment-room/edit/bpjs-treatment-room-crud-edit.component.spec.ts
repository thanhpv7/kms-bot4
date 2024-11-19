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
	getBpjsTreatmentRoomCollectionModels,
	getCountBpjsTreatmentRoomModels,
	getBpjsTreatmentRoomModelWithId
} from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.selector';
import { BpjsTreatmentRoomCrudModule } from '../bpjs-treatment-room-crud.module';
import { BpjsTreatmentRoomCrudEditComponent } from './bpjs-treatment-room-crud-edit.component';
import {
	BpjsTreatmentRoomModelState,
	initialState as initialBpjsTreatmentRoomModelState
} from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.state';
import { BpjsTreatmentRoomDataFactory } from 'src/app/lib/utils/factories/bpjs-treatment-room-data-factory';
import { BpjsTreatmentRoomModel } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model';
import { CrudTileMode } from '../bpjs-treatment-room-crud.component';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getBpjsDiagnoseModelWithId } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { getBpjsDiagnoseCollectionModels } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { BpjsDiagnoseModel } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import { BpjsDiagnoseDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-data-factory';
import { getBpjsDismissalConditionModelWithId } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.selector';
import { getBpjsDismissalConditionCollectionModels } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model.selector';
import { BpjsDismissalConditionModel } from 'src/app/models/bpjsDismissalCondition/bpjs_dismissal_condition.model';
import { BpjsDismissalConditionDataFactory } from 'src/app/lib/utils/factories/bpjs-dismissal-condition-data-factory';
import { getBpjsDismissalMappingModelWithId } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.selector';
import { getBpjsDismissalMappingCollectionModels } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model.selector';
import { BpjsDismissalMappingModel } from 'src/app/models/bpjsDismissalMapping/bpjs_dismissal_mapping.model';
import { BpjsDismissalMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-dismissal-mapping-data-factory';
import { getBpjsDoctorMappingModelWithId } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-doctor-mapping-data-factory';
import { getBpjsHealthFacilityModelWithId } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { getBpjsHealthFacilityCollectionModels } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { BpjsHealthFacilityModel } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model';
import { BpjsHealthFacilityDataFactory } from 'src/app/lib/utils/factories/bpjs-health-facility-data-factory';
import { getBpjsProcedureModelWithId } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { getBpjsProcedureCollectionModels } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { BpjsProcedureModel } from 'src/app/models/bpjsProcedure/bpjs_procedure.model';
import { BpjsProcedureDataFactory } from 'src/app/lib/utils/factories/bpjs-procedure-data-factory';
import { getBpjsServiceMappingModelWithId } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { getBpjsServiceMappingCollectionModels } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { BpjsServiceMappingModel } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import { BpjsServiceMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-service-mapping-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPatientPaymentBPJSModelWithId } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { getPatientPaymentBPJSCollectionModels } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { PatientPaymentBPJSModel } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import { PatientPaymentBPJSDataFactory } from 'src/app/lib/utils/factories/patient-payment-bpjs-data-factory';

describe('BPJS Treatment Room CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsTreatmentRoomCrudEditComponent>
	let component: BpjsTreatmentRoomCrudEditComponent;

	let bpjsTreatmentRoomModelState: BpjsTreatmentRoomModelState;

	let store: MockStore<{ model: BpjsTreatmentRoomModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsTreatmentRoomCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsTreatmentRoomModelsBehaviorSubject: BehaviorSubject<BpjsTreatmentRoomModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsDismissalConditionModelsBehaviorSubject: BehaviorSubject<BpjsDismissalConditionModel[]>;
	let bpjsDismissalMappingModelsBehaviorSubject: BehaviorSubject<BpjsDismissalMappingModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsHealthFacilityModelsBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel[]>;
	let bpjsProcedureModelsBehaviorSubject: BehaviorSubject<BpjsProcedureModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;

	const bpjsTreatmentRoomFactory: BpjsTreatmentRoomDataFactory = new BpjsTreatmentRoomDataFactory();
	const defaultBpjsTreatmentRoomCount: number = 10;
	const defaultBpjsTreatmentRoomEntities: BpjsTreatmentRoomModel[] = bpjsTreatmentRoomFactory.createAll(defaultBpjsTreatmentRoomCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsDiagnoseFactory: BpjsDiagnoseDataFactory = new BpjsDiagnoseDataFactory();
	const defaultBpjsDiagnoseCount: number = 10;
	const defaultBpjsDiagnoseEntities: BpjsDiagnoseModel[] = bpjsDiagnoseFactory.createAll(defaultBpjsDiagnoseCount);

	const bpjsDismissalConditionFactory: BpjsDismissalConditionDataFactory = new BpjsDismissalConditionDataFactory();
	const defaultBpjsDismissalConditionCount: number = 10;
	const defaultBpjsDismissalConditionEntities: BpjsDismissalConditionModel[] = bpjsDismissalConditionFactory.createAll(defaultBpjsDismissalConditionCount);

	const bpjsDismissalMappingFactory: BpjsDismissalMappingDataFactory = new BpjsDismissalMappingDataFactory();
	const defaultBpjsDismissalMappingCount: number = 10;
	const defaultBpjsDismissalMappingEntities: BpjsDismissalMappingModel[] = bpjsDismissalMappingFactory.createAll(defaultBpjsDismissalMappingCount);

	const bpjsDoctorMappingFactory: BpjsDoctorMappingDataFactory = new BpjsDoctorMappingDataFactory();
	const defaultBpjsDoctorMappingCount: number = 10;
	const defaultBpjsDoctorMappingEntities: BpjsDoctorMappingModel[] = bpjsDoctorMappingFactory.createAll(defaultBpjsDoctorMappingCount);

	const bpjsHealthFacilityFactory: BpjsHealthFacilityDataFactory = new BpjsHealthFacilityDataFactory();
	const defaultBpjsHealthFacilityCount: number = 10;
	const defaultBpjsHealthFacilityEntities: BpjsHealthFacilityModel[] = bpjsHealthFacilityFactory.createAll(defaultBpjsHealthFacilityCount);

	const bpjsProcedureFactory: BpjsProcedureDataFactory = new BpjsProcedureDataFactory();
	const defaultBpjsProcedureCount: number = 10;
	const defaultBpjsProcedureEntities: BpjsProcedureModel[] = bpjsProcedureFactory.createAll(defaultBpjsProcedureCount);

	const bpjsServiceMappingFactory: BpjsServiceMappingDataFactory = new BpjsServiceMappingDataFactory();
	const defaultBpjsServiceMappingCount: number = 10;
	const defaultBpjsServiceMappingEntities: BpjsServiceMappingModel[] = bpjsServiceMappingFactory.createAll(defaultBpjsServiceMappingCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentBPJSFactory: PatientPaymentBPJSDataFactory = new PatientPaymentBPJSDataFactory();
	const defaultPatientPaymentBPJSCount: number = 10;
	const defaultPatientPaymentBPJSEntities: PatientPaymentBPJSModel[] = patientPaymentBPJSFactory.createAll(defaultPatientPaymentBPJSCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsTreatmentRoomWithId: BpjsTreatmentRoomModel = defaultBpjsTreatmentRoomEntities[0];
	let bpjsTreatmentRoomModelWithIdBehaviorSubject: BehaviorSubject<BpjsTreatmentRoomModel>;

	bpjsTreatmentRoomWithId.bpjsClaimSubmission = defaultBpjsClaimSubmissionEntities[0];
	bpjsTreatmentRoomWithId.bpjsClaimSubmissionId = bpjsTreatmentRoomWithId.bpjsClaimSubmission.id;
	let bpjsClaimSubmissionWithIdBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel>;


	const routerState: RouterState = {
		url: 'bpjs-treatment-room-crud',
		urls: ['bpjs-treatment-room-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsTreatmentRoomModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsTreatmentRoomModelState = initialBpjsTreatmentRoomModelState;
		store.setState({model: bpjsTreatmentRoomModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsTreatmentRoomCountBehaviorSubject = new BehaviorSubject(defaultBpjsTreatmentRoomCount);

		// selectors for all references
		bpjsTreatmentRoomModelsBehaviorSubject = new BehaviorSubject(defaultBpjsTreatmentRoomEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsDismissalConditionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDismissalConditionEntities);
		bpjsDismissalMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDismissalMappingEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsHealthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHealthFacilityEntities);
		bpjsProcedureModelsBehaviorSubject = new BehaviorSubject(defaultBpjsProcedureEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);

		// selectors for target entity and its related entity
		bpjsTreatmentRoomModelWithIdBehaviorSubject = new BehaviorSubject(bpjsTreatmentRoomWithId);
		bpjsClaimSubmissionWithIdBehaviorSubject = new BehaviorSubject(bpjsTreatmentRoomWithId.bpjsClaimSubmission);

		spyOn(store, 'select')
			.withArgs(getCountBpjsTreatmentRoomModels).and.returnValue(bpjsTreatmentRoomCountBehaviorSubject)
			.withArgs(getBpjsTreatmentRoomModelWithId, bpjsTreatmentRoomWithId.id).and.returnValue(bpjsTreatmentRoomModelWithIdBehaviorSubject)
			.withArgs(getBpjsTreatmentRoomCollectionModels, jasmine.any(String)).and.returnValue(bpjsTreatmentRoomModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsDismissalConditionCollectionModels, jasmine.any(String)).and.returnValue(bpjsDismissalConditionModelsBehaviorSubject)
			.withArgs(getBpjsDismissalMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDismissalMappingModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(bpjsHealthFacilityModelsBehaviorSubject)
			.withArgs(getBpjsProcedureCollectionModels, jasmine.any(String)).and.returnValue(bpjsProcedureModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionModelWithId, bpjsTreatmentRoomWithId.bpjsClaimSubmissionId).and.returnValue(bpjsClaimSubmissionWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsTreatmentRoomCrudModule,
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

			fixture = TestBed.createComponent(BpjsTreatmentRoomCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsTreatmentRoomModel();
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
	it ('Renders the BPJS Treatment Room CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the BPJS Claim Submission relation.
	*
	* The button should only exist if bpjsClaimSubmissionMultiCrudActive is true
	*/
	it ('Renders BPJS Claim Submission Add Entity button in create mode', fakeAsync(() => {
		const bpjsClaimSubmissionButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsClaimSubmissionButton).toEqual(component.bpjsClaimSubmissionMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Claim Submission', fakeAsync(() => {
		const bpjsClaimSubmissionButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsClaimSubmissionButton).toEqual(component.bpjsClaimSubmissionMultiCrudActive);

		if (component.bpjsClaimSubmissionMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsClaimSubmissionRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionDisplayName + ' from Model')).length;

			bpjsClaimSubmissionButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsClaimSubmissionRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionDisplayName + ' from Model')).length;

			expect(actualBpjsClaimSubmissionRemoveButtonCount).toEqual(initialBpjsClaimSubmissionRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Claim Submission button', () => {
		const bpjsClaimSubmissionButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsClaimSubmissionButton).toEqual(component.bpjsClaimSubmissionMultiCrudActive);

		if (component.bpjsClaimSubmissionMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsClaimSubmissionButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsClaimSubmissionRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsClaimSubmissionRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsClaimSubmissionRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionDisplayName + ' from Model'));

			expect(actualBpjsClaimSubmissionRemoveButtons.length).toEqual(initialBpjsClaimSubmissionRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Claim Submission button when one has already been added', () => {

		const bpjsClaimSubmissionButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsClaimSubmissionButton).toEqual(component.bpjsClaimSubmissionMultiCrudActive);

		if (component.bpjsClaimSubmissionMultiCrudActive) {
			bpjsClaimSubmissionButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsClaimSubmissionButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionDisplayName + ' to Model'));

			expect(updatedbpjsClaimSubmissionButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Claim Submission entities from model when loading in edit mode', () => {
		component.targetModel = bpjsTreatmentRoomWithId;
		component.targetModelId = bpjsTreatmentRoomWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsClaimSubmissionMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsClaimSubmissionRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionDisplayName + ' from Model')).length;

			expect(bpjsClaimSubmissionRemoveButtonCount).toEqual(1);
		}
	});

});
