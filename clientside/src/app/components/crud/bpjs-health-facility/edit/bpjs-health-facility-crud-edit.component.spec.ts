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
	getBpjsHealthFacilityCollectionModels,
	getCountBpjsHealthFacilityModels,
	getBpjsHealthFacilityModelWithId
} from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { BpjsHealthFacilityCrudModule } from '../bpjs-health-facility-crud.module';
import { BpjsHealthFacilityCrudEditComponent } from './bpjs-health-facility-crud-edit.component';
import {
	BpjsHealthFacilityModelState,
	initialState as initialBpjsHealthFacilityModelState
} from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.state';
import { BpjsHealthFacilityDataFactory } from 'src/app/lib/utils/factories/bpjs-health-facility-data-factory';
import { BpjsHealthFacilityModel } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model';
import { CrudTileMode } from '../bpjs-health-facility-crud.component';
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
import { getBpjsFacilityListModelWithId } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.selector';
import { getBpjsFacilityListCollectionModels } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.selector';
import { BpjsFacilityListModel } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model';
import { BpjsFacilityListDataFactory } from 'src/app/lib/utils/factories/bpjs-facility-list-data-factory';
import { getBpjsPatientReferralModelWithId } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { getBpjsPatientReferralCollectionModels } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { BpjsPatientReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-patient-referral-data-factory';
import { getBpjsProcedureModelWithId } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { getBpjsProcedureCollectionModels } from 'src/app/models/bpjsProcedure/bpjs_procedure.model.selector';
import { BpjsProcedureModel } from 'src/app/models/bpjsProcedure/bpjs_procedure.model';
import { BpjsProcedureDataFactory } from 'src/app/lib/utils/factories/bpjs-procedure-data-factory';
import { getBpjsReferralSpecialistModelWithId } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.selector';
import { getBpjsReferralSpecialistCollectionModels } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.selector';
import { BpjsReferralSpecialistModel } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model';
import { BpjsReferralSpecialistDataFactory } from 'src/app/lib/utils/factories/bpjs-referral-specialist-data-factory';
import { getBpjsServiceMappingModelWithId } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { getBpjsServiceMappingCollectionModels } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model.selector';
import { BpjsServiceMappingModel } from 'src/app/models/bpjsServiceMapping/bpjs_service_mapping.model';
import { BpjsServiceMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-service-mapping-data-factory';
import { getBpjsTreatmentRoomModelWithId } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.selector';
import { getBpjsTreatmentRoomCollectionModels } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model.selector';
import { BpjsTreatmentRoomModel } from 'src/app/models/bpjsTreatmentRoom/bpjs_treatment_room.model';
import { BpjsTreatmentRoomDataFactory } from 'src/app/lib/utils/factories/bpjs-treatment-room-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPatientPaymentBPJSModelWithId } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { getPatientPaymentBPJSCollectionModels } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { PatientPaymentBPJSModel } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import { PatientPaymentBPJSDataFactory } from 'src/app/lib/utils/factories/patient-payment-bpjs-data-factory';

describe('BPJS Health Facility CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsHealthFacilityCrudEditComponent>
	let component: BpjsHealthFacilityCrudEditComponent;

	let bpjsHealthFacilityModelState: BpjsHealthFacilityModelState;

	let store: MockStore<{ model: BpjsHealthFacilityModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsHealthFacilityCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsHealthFacilityModelsBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsDismissalConditionModelsBehaviorSubject: BehaviorSubject<BpjsDismissalConditionModel[]>;
	let bpjsDismissalMappingModelsBehaviorSubject: BehaviorSubject<BpjsDismissalMappingModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsFacilityListModelsBehaviorSubject: BehaviorSubject<BpjsFacilityListModel[]>;
	let bpjsPatientReferralModelsBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel[]>;
	let bpjsProcedureModelsBehaviorSubject: BehaviorSubject<BpjsProcedureModel[]>;
	let bpjsReferralSpecialistModelsBehaviorSubject: BehaviorSubject<BpjsReferralSpecialistModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let bpjsTreatmentRoomModelsBehaviorSubject: BehaviorSubject<BpjsTreatmentRoomModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;

	const bpjsHealthFacilityFactory: BpjsHealthFacilityDataFactory = new BpjsHealthFacilityDataFactory();
	const defaultBpjsHealthFacilityCount: number = 10;
	const defaultBpjsHealthFacilityEntities: BpjsHealthFacilityModel[] = bpjsHealthFacilityFactory.createAll(defaultBpjsHealthFacilityCount);

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

	const bpjsFacilityListFactory: BpjsFacilityListDataFactory = new BpjsFacilityListDataFactory();
	const defaultBpjsFacilityListCount: number = 10;
	const defaultBpjsFacilityListEntities: BpjsFacilityListModel[] = bpjsFacilityListFactory.createAll(defaultBpjsFacilityListCount);

	const bpjsPatientReferralFactory: BpjsPatientReferralDataFactory = new BpjsPatientReferralDataFactory();
	const defaultBpjsPatientReferralCount: number = 10;
	const defaultBpjsPatientReferralEntities: BpjsPatientReferralModel[] = bpjsPatientReferralFactory.createAll(defaultBpjsPatientReferralCount);

	const bpjsProcedureFactory: BpjsProcedureDataFactory = new BpjsProcedureDataFactory();
	const defaultBpjsProcedureCount: number = 10;
	const defaultBpjsProcedureEntities: BpjsProcedureModel[] = bpjsProcedureFactory.createAll(defaultBpjsProcedureCount);

	const bpjsReferralSpecialistFactory: BpjsReferralSpecialistDataFactory = new BpjsReferralSpecialistDataFactory();
	const defaultBpjsReferralSpecialistCount: number = 10;
	const defaultBpjsReferralSpecialistEntities: BpjsReferralSpecialistModel[] = bpjsReferralSpecialistFactory.createAll(defaultBpjsReferralSpecialistCount);

	const bpjsServiceMappingFactory: BpjsServiceMappingDataFactory = new BpjsServiceMappingDataFactory();
	const defaultBpjsServiceMappingCount: number = 10;
	const defaultBpjsServiceMappingEntities: BpjsServiceMappingModel[] = bpjsServiceMappingFactory.createAll(defaultBpjsServiceMappingCount);

	const bpjsTreatmentRoomFactory: BpjsTreatmentRoomDataFactory = new BpjsTreatmentRoomDataFactory();
	const defaultBpjsTreatmentRoomCount: number = 10;
	const defaultBpjsTreatmentRoomEntities: BpjsTreatmentRoomModel[] = bpjsTreatmentRoomFactory.createAll(defaultBpjsTreatmentRoomCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentBPJSFactory: PatientPaymentBPJSDataFactory = new PatientPaymentBPJSDataFactory();
	const defaultPatientPaymentBPJSCount: number = 10;
	const defaultPatientPaymentBPJSEntities: PatientPaymentBPJSModel[] = patientPaymentBPJSFactory.createAll(defaultPatientPaymentBPJSCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsHealthFacilityWithId: BpjsHealthFacilityModel = defaultBpjsHealthFacilityEntities[0];
	let bpjsHealthFacilityModelWithIdBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel>;

	bpjsHealthFacilityWithId.bpjsClaimSubmissions = defaultBpjsClaimSubmissionEntities;
	bpjsHealthFacilityWithId.bpjsClaimSubmissionsIds = bpjsHealthFacilityWithId.bpjsClaimSubmissions.map(bpjsClaimSubmissions => bpjsClaimSubmissions.id);

	bpjsHealthFacilityWithId.bpjsFacilityLists = defaultBpjsFacilityListEntities;
	bpjsHealthFacilityWithId.bpjsFacilityListsIds = bpjsHealthFacilityWithId.bpjsFacilityLists.map(bpjsFacilityLists => bpjsFacilityLists.id);

	bpjsHealthFacilityWithId.bpjsPatientReferrals = defaultBpjsPatientReferralEntities;
	bpjsHealthFacilityWithId.bpjsPatientReferralsIds = bpjsHealthFacilityWithId.bpjsPatientReferrals.map(bpjsPatientReferrals => bpjsPatientReferrals.id);

	bpjsHealthFacilityWithId.bpjsReferralSpecialists = defaultBpjsReferralSpecialistEntities;
	bpjsHealthFacilityWithId.bpjsReferralSpecialistsIds = bpjsHealthFacilityWithId.bpjsReferralSpecialists.map(bpjsReferralSpecialists => bpjsReferralSpecialists.id);


	const routerState: RouterState = {
		url: 'bpjs-health-facility-crud',
		urls: ['bpjs-health-facility-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsHealthFacilityModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsHealthFacilityModelState = initialBpjsHealthFacilityModelState;
		store.setState({model: bpjsHealthFacilityModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsHealthFacilityCountBehaviorSubject = new BehaviorSubject(defaultBpjsHealthFacilityCount);

		// selectors for all references
		bpjsHealthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHealthFacilityEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsDismissalConditionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDismissalConditionEntities);
		bpjsDismissalMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDismissalMappingEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsFacilityListModelsBehaviorSubject = new BehaviorSubject(defaultBpjsFacilityListEntities);
		bpjsPatientReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralEntities);
		bpjsProcedureModelsBehaviorSubject = new BehaviorSubject(defaultBpjsProcedureEntities);
		bpjsReferralSpecialistModelsBehaviorSubject = new BehaviorSubject(defaultBpjsReferralSpecialistEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		bpjsTreatmentRoomModelsBehaviorSubject = new BehaviorSubject(defaultBpjsTreatmentRoomEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);

		// selectors for target entity and its related entity
		bpjsHealthFacilityModelWithIdBehaviorSubject = new BehaviorSubject(bpjsHealthFacilityWithId);

		spyOn(store, 'select')
			.withArgs(getCountBpjsHealthFacilityModels).and.returnValue(bpjsHealthFacilityCountBehaviorSubject)
			.withArgs(getBpjsHealthFacilityModelWithId, bpjsHealthFacilityWithId.id).and.returnValue(bpjsHealthFacilityModelWithIdBehaviorSubject)
			.withArgs(getBpjsHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(bpjsHealthFacilityModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsDismissalConditionCollectionModels, jasmine.any(String)).and.returnValue(bpjsDismissalConditionModelsBehaviorSubject)
			.withArgs(getBpjsDismissalMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDismissalMappingModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsFacilityListCollectionModels, jasmine.any(String)).and.returnValue(bpjsFacilityListModelsBehaviorSubject)
			.withArgs(getBpjsPatientReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsPatientReferralModelsBehaviorSubject)
			.withArgs(getBpjsProcedureCollectionModels, jasmine.any(String)).and.returnValue(bpjsProcedureModelsBehaviorSubject)
			.withArgs(getBpjsReferralSpecialistCollectionModels, jasmine.any(String)).and.returnValue(bpjsReferralSpecialistModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getBpjsTreatmentRoomCollectionModels, jasmine.any(String)).and.returnValue(bpjsTreatmentRoomModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsHealthFacilityCrudModule,
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

			fixture = TestBed.createComponent(BpjsHealthFacilityCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsHealthFacilityModel();
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
	it ('Renders the BPJS Health Facility CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the BPJS Claim Submissions relation.
	*
	* The button should only exist if bpjsClaimSubmissionsMultiCrudActive is true
	*/
	it ('Renders BPJS Claim Submissions Add Entity button in create mode', fakeAsync(() => {
		const bpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsClaimSubmissionsButton).toEqual(component.bpjsClaimSubmissionsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Claim Submissions', fakeAsync(() => {
		const bpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsClaimSubmissionsButton).toEqual(component.bpjsClaimSubmissionsMultiCrudActive);

		if (component.bpjsClaimSubmissionsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsClaimSubmissionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model')).length;

			bpjsClaimSubmissionsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsClaimSubmissionsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model')).length;

			expect(actualBpjsClaimSubmissionsRemoveButtonCount).toEqual(initialBpjsClaimSubmissionsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Claim Submissions button', () => {
		const bpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsClaimSubmissionsButton).toEqual(component.bpjsClaimSubmissionsMultiCrudActive);

		if (component.bpjsClaimSubmissionsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsClaimSubmissionsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsClaimSubmissionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsClaimSubmissionsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsClaimSubmissionsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model'));

			expect(actualBpjsClaimSubmissionsRemoveButtons.length).toEqual(initialBpjsClaimSubmissionsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add BPJS Claim Submissions button when one has already been added', () => {

		const bpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsClaimSubmissionsButton).toEqual(component.bpjsClaimSubmissionsMultiCrudActive);

		if (component.bpjsClaimSubmissionsMultiCrudActive) {
			bpjsClaimSubmissionsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsClaimSubmissionsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsClaimSubmissionsDisplayName + ' to Model'));

			expect(updatedbpjsClaimSubmissionsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related BPJS Claim Submissions entities from model when loading in edit mode', () => {
		component.targetModel = bpjsHealthFacilityWithId;
		component.targetModelId = bpjsHealthFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsClaimSubmissionsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsClaimSubmissionsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsClaimSubmissionsDisplayName + ' from Model')).length;

			expect(bpjsClaimSubmissionsRemoveButtonCount).toEqual(bpjsHealthFacilityWithId.bpjsClaimSubmissions.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Facility Lists relation.
	*
	* The button should only exist if bpjsFacilityListsMultiCrudActive is true
	*/
	it ('Renders BPJS Facility Lists Add Entity button in create mode', fakeAsync(() => {
		const bpjsFacilityListsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsFacilityListsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsFacilityListsButton).toEqual(component.bpjsFacilityListsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Facility Lists', fakeAsync(() => {
		const bpjsFacilityListsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsFacilityListsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsFacilityListsButton).toEqual(component.bpjsFacilityListsMultiCrudActive);

		if (component.bpjsFacilityListsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsFacilityListsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsFacilityListsDisplayName + ' from Model')).length;

			bpjsFacilityListsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsFacilityListsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsFacilityListsDisplayName + ' from Model')).length;

			expect(actualBpjsFacilityListsRemoveButtonCount).toEqual(initialBpjsFacilityListsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Facility Lists button', () => {
		const bpjsFacilityListsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsFacilityListsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsFacilityListsButton).toEqual(component.bpjsFacilityListsMultiCrudActive);

		if (component.bpjsFacilityListsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsFacilityListsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsFacilityListsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsFacilityListsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsFacilityListsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsFacilityListsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsFacilityListsDisplayName + ' from Model'));

			expect(actualBpjsFacilityListsRemoveButtons.length).toEqual(initialBpjsFacilityListsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add BPJS Facility Lists button when one has already been added', () => {

		const bpjsFacilityListsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsFacilityListsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsFacilityListsButton).toEqual(component.bpjsFacilityListsMultiCrudActive);

		if (component.bpjsFacilityListsMultiCrudActive) {
			bpjsFacilityListsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsFacilityListsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsFacilityListsDisplayName + ' to Model'));

			expect(updatedbpjsFacilityListsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related BPJS Facility Lists entities from model when loading in edit mode', () => {
		component.targetModel = bpjsHealthFacilityWithId;
		component.targetModelId = bpjsHealthFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsFacilityListsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsFacilityListsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsFacilityListsDisplayName + ' from Model')).length;

			expect(bpjsFacilityListsRemoveButtonCount).toEqual(bpjsHealthFacilityWithId.bpjsFacilityLists.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Patient Referrals relation.
	*
	* The button should only exist if bpjsPatientReferralsMultiCrudActive is true
	*/
	it ('Renders BPJS Patient Referrals Add Entity button in create mode', fakeAsync(() => {
		const bpjsPatientReferralsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPatientReferralsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsPatientReferralsButton).toEqual(component.bpjsPatientReferralsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Patient Referrals', fakeAsync(() => {
		const bpjsPatientReferralsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPatientReferralsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPatientReferralsButton).toEqual(component.bpjsPatientReferralsMultiCrudActive);

		if (component.bpjsPatientReferralsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsPatientReferralsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPatientReferralsDisplayName + ' from Model')).length;

			bpjsPatientReferralsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPatientReferralsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPatientReferralsDisplayName + ' from Model')).length;

			expect(actualBpjsPatientReferralsRemoveButtonCount).toEqual(initialBpjsPatientReferralsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Patient Referrals button', () => {
		const bpjsPatientReferralsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPatientReferralsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPatientReferralsButton).toEqual(component.bpjsPatientReferralsMultiCrudActive);

		if (component.bpjsPatientReferralsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsPatientReferralsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsPatientReferralsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPatientReferralsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsPatientReferralsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPatientReferralsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPatientReferralsDisplayName + ' from Model'));

			expect(actualBpjsPatientReferralsRemoveButtons.length).toEqual(initialBpjsPatientReferralsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add BPJS Patient Referrals button when one has already been added', () => {

		const bpjsPatientReferralsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPatientReferralsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPatientReferralsButton).toEqual(component.bpjsPatientReferralsMultiCrudActive);

		if (component.bpjsPatientReferralsMultiCrudActive) {
			bpjsPatientReferralsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsPatientReferralsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPatientReferralsDisplayName + ' to Model'));

			expect(updatedbpjsPatientReferralsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related BPJS Patient Referrals entities from model when loading in edit mode', () => {
		component.targetModel = bpjsHealthFacilityWithId;
		component.targetModelId = bpjsHealthFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsPatientReferralsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsPatientReferralsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPatientReferralsDisplayName + ' from Model')).length;

			expect(bpjsPatientReferralsRemoveButtonCount).toEqual(bpjsHealthFacilityWithId.bpjsPatientReferrals.length);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Referral Specialists relation.
	*
	* The button should only exist if bpjsReferralSpecialistsMultiCrudActive is true
	*/
	it ('Renders BPJS Referral Specialists Add Entity button in create mode', fakeAsync(() => {
		const bpjsReferralSpecialistsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsReferralSpecialistsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsReferralSpecialistsButton).toEqual(component.bpjsReferralSpecialistsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Referral Specialists', fakeAsync(() => {
		const bpjsReferralSpecialistsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsReferralSpecialistsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsReferralSpecialistsButton).toEqual(component.bpjsReferralSpecialistsMultiCrudActive);

		if (component.bpjsReferralSpecialistsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsReferralSpecialistsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsReferralSpecialistsDisplayName + ' from Model')).length;

			bpjsReferralSpecialistsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsReferralSpecialistsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsReferralSpecialistsDisplayName + ' from Model')).length;

			expect(actualBpjsReferralSpecialistsRemoveButtonCount).toEqual(initialBpjsReferralSpecialistsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Referral Specialists button', () => {
		const bpjsReferralSpecialistsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsReferralSpecialistsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsReferralSpecialistsButton).toEqual(component.bpjsReferralSpecialistsMultiCrudActive);

		if (component.bpjsReferralSpecialistsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsReferralSpecialistsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsReferralSpecialistsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsReferralSpecialistsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsReferralSpecialistsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsReferralSpecialistsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsReferralSpecialistsDisplayName + ' from Model'));

			expect(actualBpjsReferralSpecialistsRemoveButtons.length).toEqual(initialBpjsReferralSpecialistsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add BPJS Referral Specialists button when one has already been added', () => {

		const bpjsReferralSpecialistsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsReferralSpecialistsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsReferralSpecialistsButton).toEqual(component.bpjsReferralSpecialistsMultiCrudActive);

		if (component.bpjsReferralSpecialistsMultiCrudActive) {
			bpjsReferralSpecialistsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsReferralSpecialistsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsReferralSpecialistsDisplayName + ' to Model'));

			expect(updatedbpjsReferralSpecialistsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related BPJS Referral Specialists entities from model when loading in edit mode', () => {
		component.targetModel = bpjsHealthFacilityWithId;
		component.targetModelId = bpjsHealthFacilityWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsReferralSpecialistsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsReferralSpecialistsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsReferralSpecialistsDisplayName + ' from Model')).length;

			expect(bpjsReferralSpecialistsRemoveButtonCount).toEqual(bpjsHealthFacilityWithId.bpjsReferralSpecialists.length);
		}
	});

});
