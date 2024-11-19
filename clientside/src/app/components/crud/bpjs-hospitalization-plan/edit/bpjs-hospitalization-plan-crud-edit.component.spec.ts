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
	getBpjsHospitalizationPlanCollectionModels,
	getCountBpjsHospitalizationPlanModels,
	getBpjsHospitalizationPlanModelWithId
} from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { BpjsHospitalizationPlanCrudModule } from '../bpjs-hospitalization-plan-crud.module';
import { BpjsHospitalizationPlanCrudEditComponent } from './bpjs-hospitalization-plan-crud-edit.component';
import {
	BpjsHospitalizationPlanModelState,
	initialState as initialBpjsHospitalizationPlanModelState
} from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.state';
import { BpjsHospitalizationPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-hospitalization-plan-data-factory';
import { BpjsHospitalizationPlanModel } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import { CrudTileMode } from '../bpjs-hospitalization-plan-crud.component';
import { getBpjsAccidentMasterModelWithId } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import { getBpjsAccidentMasterCollectionModels } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model.selector';
import { BpjsAccidentMasterModel } from 'src/app/models/bpjsAccidentMaster/bpjs_accident_master.model';
import { BpjsAccidentMasterDataFactory } from 'src/app/lib/utils/factories/bpjs-accident-master-data-factory';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getBpjsControlPlanModelWithId } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import { getBpjsControlPlanCollectionModels } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model.selector';
import { BpjsControlPlanModel } from 'src/app/models/bpjsControlPlan/bpjs_control_plan.model';
import { BpjsControlPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-control-plan-data-factory';
import { getBpjsDoctorMappingModelWithId } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-doctor-mapping-data-factory';
import { getBpjsJasaRaharjaModelWithId } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { getBpjsJasaRaharjaCollectionModels } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { BpjsJasaRaharjaModel } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model';
import { BpjsJasaRaharjaDataFactory } from 'src/app/lib/utils/factories/bpjs-jasa-raharja-data-factory';
import { getBpjsPRBModelWithId } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { getBpjsPRBCollectionModels } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { BpjsPRBModel } from 'src/app/models/bpjsPRB/bpjs_prb.model';
import { BpjsPRBDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-data-factory';
import { getBpjsPatientReferralModelWithId } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { getBpjsPatientReferralCollectionModels } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { BpjsPatientReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-patient-referral-data-factory';
import { getBpjsSEPModelWithId } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { getBpjsSEPCollectionModels } from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import { BpjsSEPModel } from 'src/app/models/bpjsSEP/bpjs_sep.model';
import { BpjsSEPDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-data-factory';
import { getBpjsSEPSubmissionModelWithId } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import { getBpjsSEPSubmissionCollectionModels } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model.selector';
import { BpjsSEPSubmissionModel } from 'src/app/models/bpjsSEPSubmission/bpjs_sep_submission.model';
import { BpjsSEPSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-sep-submission-data-factory';
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
import { getServiceModelWithId } from 'src/app/models/service/service.model.selector';
import { getServiceCollectionModels } from 'src/app/models/service/service.model.selector';
import { ServiceModel } from 'src/app/models/service/service.model';
import { ServiceDataFactory } from 'src/app/lib/utils/factories/service-data-factory';
import { getStaffModelWithId } from 'src/app/models/staff/staff.model.selector';
import { getStaffCollectionModels } from 'src/app/models/staff/staff.model.selector';
import { StaffModel } from 'src/app/models/staff/staff.model';
import { StaffDataFactory } from 'src/app/lib/utils/factories/staff-data-factory';

describe('BPJS Hospitalization Plan CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsHospitalizationPlanCrudEditComponent>
	let component: BpjsHospitalizationPlanCrudEditComponent;

	let bpjsHospitalizationPlanModelState: BpjsHospitalizationPlanModelState;

	let store: MockStore<{ model: BpjsHospitalizationPlanModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsHospitalizationPlanCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsHospitalizationPlanModelsBehaviorSubject: BehaviorSubject<BpjsHospitalizationPlanModel[]>;
	let bpjsAccidentMasterModelsBehaviorSubject: BehaviorSubject<BpjsAccidentMasterModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsControlPlanModelsBehaviorSubject: BehaviorSubject<BpjsControlPlanModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsJasaRaharjaModelsBehaviorSubject: BehaviorSubject<BpjsJasaRaharjaModel[]>;
	let bpjsPRBModelsBehaviorSubject: BehaviorSubject<BpjsPRBModel[]>;
	let bpjsPatientReferralModelsBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel[]>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bpjsSEPSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsSEPSubmissionModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;
	let staffModelsBehaviorSubject: BehaviorSubject<StaffModel[]>;

	const bpjsHospitalizationPlanFactory: BpjsHospitalizationPlanDataFactory = new BpjsHospitalizationPlanDataFactory();
	const defaultBpjsHospitalizationPlanCount: number = 10;
	const defaultBpjsHospitalizationPlanEntities: BpjsHospitalizationPlanModel[] = bpjsHospitalizationPlanFactory.createAll(defaultBpjsHospitalizationPlanCount);

	const bpjsAccidentMasterFactory: BpjsAccidentMasterDataFactory = new BpjsAccidentMasterDataFactory();
	const defaultBpjsAccidentMasterCount: number = 10;
	const defaultBpjsAccidentMasterEntities: BpjsAccidentMasterModel[] = bpjsAccidentMasterFactory.createAll(defaultBpjsAccidentMasterCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsControlPlanFactory: BpjsControlPlanDataFactory = new BpjsControlPlanDataFactory();
	const defaultBpjsControlPlanCount: number = 10;
	const defaultBpjsControlPlanEntities: BpjsControlPlanModel[] = bpjsControlPlanFactory.createAll(defaultBpjsControlPlanCount);

	const bpjsDoctorMappingFactory: BpjsDoctorMappingDataFactory = new BpjsDoctorMappingDataFactory();
	const defaultBpjsDoctorMappingCount: number = 10;
	const defaultBpjsDoctorMappingEntities: BpjsDoctorMappingModel[] = bpjsDoctorMappingFactory.createAll(defaultBpjsDoctorMappingCount);

	const bpjsJasaRaharjaFactory: BpjsJasaRaharjaDataFactory = new BpjsJasaRaharjaDataFactory();
	const defaultBpjsJasaRaharjaCount: number = 10;
	const defaultBpjsJasaRaharjaEntities: BpjsJasaRaharjaModel[] = bpjsJasaRaharjaFactory.createAll(defaultBpjsJasaRaharjaCount);

	const bpjsPRBFactory: BpjsPRBDataFactory = new BpjsPRBDataFactory();
	const defaultBpjsPRBCount: number = 10;
	const defaultBpjsPRBEntities: BpjsPRBModel[] = bpjsPRBFactory.createAll(defaultBpjsPRBCount);

	const bpjsPatientReferralFactory: BpjsPatientReferralDataFactory = new BpjsPatientReferralDataFactory();
	const defaultBpjsPatientReferralCount: number = 10;
	const defaultBpjsPatientReferralEntities: BpjsPatientReferralModel[] = bpjsPatientReferralFactory.createAll(defaultBpjsPatientReferralCount);

	const bpjsSEPFactory: BpjsSEPDataFactory = new BpjsSEPDataFactory();
	const defaultBpjsSEPCount: number = 10;
	const defaultBpjsSEPEntities: BpjsSEPModel[] = bpjsSEPFactory.createAll(defaultBpjsSEPCount);

	const bpjsSEPSubmissionFactory: BpjsSEPSubmissionDataFactory = new BpjsSEPSubmissionDataFactory();
	const defaultBpjsSEPSubmissionCount: number = 10;
	const defaultBpjsSEPSubmissionEntities: BpjsSEPSubmissionModel[] = bpjsSEPSubmissionFactory.createAll(defaultBpjsSEPSubmissionCount);

	const bpjsServiceMappingFactory: BpjsServiceMappingDataFactory = new BpjsServiceMappingDataFactory();
	const defaultBpjsServiceMappingCount: number = 10;
	const defaultBpjsServiceMappingEntities: BpjsServiceMappingModel[] = bpjsServiceMappingFactory.createAll(defaultBpjsServiceMappingCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentBPJSFactory: PatientPaymentBPJSDataFactory = new PatientPaymentBPJSDataFactory();
	const defaultPatientPaymentBPJSCount: number = 10;
	const defaultPatientPaymentBPJSEntities: PatientPaymentBPJSModel[] = patientPaymentBPJSFactory.createAll(defaultPatientPaymentBPJSCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);

	const staffFactory: StaffDataFactory = new StaffDataFactory();
	const defaultStaffCount: number = 10;
	const defaultStaffEntities: StaffModel[] = staffFactory.createAll(defaultStaffCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsHospitalizationPlanWithId: BpjsHospitalizationPlanModel = defaultBpjsHospitalizationPlanEntities[0];
	let bpjsHospitalizationPlanModelWithIdBehaviorSubject: BehaviorSubject<BpjsHospitalizationPlanModel>;

	bpjsHospitalizationPlanWithId.patientPaymentBPJS = defaultPatientPaymentBPJSEntities[0];
	bpjsHospitalizationPlanWithId.patientPaymentBPJSId = bpjsHospitalizationPlanWithId.patientPaymentBPJS.id;
	let patientPaymentBPJSWithIdBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel>;

	bpjsHospitalizationPlanWithId.bpjsDoctorMapping = defaultBpjsDoctorMappingEntities[0];
	bpjsHospitalizationPlanWithId.bpjsDoctorMappingId = bpjsHospitalizationPlanWithId.bpjsDoctorMapping.id;
	let bpjsDoctorMappingWithIdBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel>;

	bpjsHospitalizationPlanWithId.bpjsServiceMapping = defaultBpjsServiceMappingEntities[0];
	bpjsHospitalizationPlanWithId.bpjsServiceMappingId = bpjsHospitalizationPlanWithId.bpjsServiceMapping.id;
	let bpjsServiceMappingWithIdBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel>;


	const routerState: RouterState = {
		url: 'bpjs-hospitalization-plan-crud',
		urls: ['bpjs-hospitalization-plan-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsHospitalizationPlanModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsHospitalizationPlanModelState = initialBpjsHospitalizationPlanModelState;
		store.setState({model: bpjsHospitalizationPlanModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsHospitalizationPlanCountBehaviorSubject = new BehaviorSubject(defaultBpjsHospitalizationPlanCount);

		// selectors for all references
		bpjsHospitalizationPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHospitalizationPlanEntities);
		bpjsAccidentMasterModelsBehaviorSubject = new BehaviorSubject(defaultBpjsAccidentMasterEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsControlPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsControlPlanEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsJasaRaharjaModelsBehaviorSubject = new BehaviorSubject(defaultBpjsJasaRaharjaEntities);
		bpjsPRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBEntities);
		bpjsPatientReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralEntities);
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bpjsSEPSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPSubmissionEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);
		staffModelsBehaviorSubject = new BehaviorSubject(defaultStaffEntities);

		// selectors for target entity and its related entity
		bpjsHospitalizationPlanModelWithIdBehaviorSubject = new BehaviorSubject(bpjsHospitalizationPlanWithId);
		patientPaymentBPJSWithIdBehaviorSubject = new BehaviorSubject(bpjsHospitalizationPlanWithId.patientPaymentBPJS);
		bpjsDoctorMappingWithIdBehaviorSubject = new BehaviorSubject(bpjsHospitalizationPlanWithId.bpjsDoctorMapping);
		bpjsServiceMappingWithIdBehaviorSubject = new BehaviorSubject(bpjsHospitalizationPlanWithId.bpjsServiceMapping);

		spyOn(store, 'select')
			.withArgs(getCountBpjsHospitalizationPlanModels).and.returnValue(bpjsHospitalizationPlanCountBehaviorSubject)
			.withArgs(getBpjsHospitalizationPlanModelWithId, bpjsHospitalizationPlanWithId.id).and.returnValue(bpjsHospitalizationPlanModelWithIdBehaviorSubject)
			.withArgs(getBpjsHospitalizationPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsHospitalizationPlanModelsBehaviorSubject)
			.withArgs(getBpjsAccidentMasterCollectionModels, jasmine.any(String)).and.returnValue(bpjsAccidentMasterModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsControlPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsControlPlanModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsJasaRaharjaCollectionModels, jasmine.any(String)).and.returnValue(bpjsJasaRaharjaModelsBehaviorSubject)
			.withArgs(getBpjsPRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBModelsBehaviorSubject)
			.withArgs(getBpjsPatientReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsPatientReferralModelsBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBpjsSEPSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getStaffCollectionModels, jasmine.any(String)).and.returnValue(staffModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSModelWithId, bpjsHospitalizationPlanWithId.patientPaymentBPJSId).and.returnValue(patientPaymentBPJSWithIdBehaviorSubject)
			.withArgs(getBpjsDoctorMappingModelWithId, bpjsHospitalizationPlanWithId.bpjsDoctorMappingId).and.returnValue(bpjsDoctorMappingWithIdBehaviorSubject)
			.withArgs(getBpjsServiceMappingModelWithId, bpjsHospitalizationPlanWithId.bpjsServiceMappingId).and.returnValue(bpjsServiceMappingWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsHospitalizationPlanCrudModule,
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

			fixture = TestBed.createComponent(BpjsHospitalizationPlanCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsHospitalizationPlanModel();
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
	it ('Renders the BPJS Hospitalization Plan CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Patient Payment BPJS relation.
	*
	* The button should only exist if patientPaymentBPJSMultiCrudActive is true
	*/
	it ('Renders Patient Payment BPJS Add Entity button in create mode', fakeAsync(() => {
		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient Payment BPJS', fakeAsync(() => {
		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);

		if (component.patientPaymentBPJSMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientPaymentBPJSRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model')).length;

			patientPaymentBPJSButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentBPJSRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model')).length;

			expect(actualPatientPaymentBPJSRemoveButtonCount).toEqual(initialPatientPaymentBPJSRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient Payment BPJS button', () => {
		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);

		if (component.patientPaymentBPJSMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientPaymentBPJSButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientPaymentBPJSRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientPaymentBPJSRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientPaymentBPJSRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model'));

			expect(actualPatientPaymentBPJSRemoveButtons.length).toEqual(initialPatientPaymentBPJSRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient Payment BPJS button when one has already been added', () => {

		const patientPaymentBPJSButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientPaymentBPJSButton).toEqual(component.patientPaymentBPJSMultiCrudActive);

		if (component.patientPaymentBPJSMultiCrudActive) {
			patientPaymentBPJSButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientPaymentBPJSButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientPaymentBPJSDisplayName + ' to Model'));

			expect(updatedpatientPaymentBPJSButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient Payment BPJS entities from model when loading in edit mode', () => {
		component.targetModel = bpjsHospitalizationPlanWithId;
		component.targetModelId = bpjsHospitalizationPlanWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientPaymentBPJSMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientPaymentBPJSRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientPaymentBPJSDisplayName + ' from Model')).length;

			expect(patientPaymentBPJSRemoveButtonCount).toEqual(1);
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
		component.targetModel = bpjsHospitalizationPlanWithId;
		component.targetModelId = bpjsHospitalizationPlanWithId.id;
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

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Service Mapping relation.
	*
	* The button should only exist if bpjsServiceMappingMultiCrudActive is true
	*/
	it ('Renders BPJS Service Mapping Add Entity button in create mode', fakeAsync(() => {
		const bpjsServiceMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsServiceMappingButton).toEqual(component.bpjsServiceMappingMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Service Mapping', fakeAsync(() => {
		const bpjsServiceMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsServiceMappingButton).toEqual(component.bpjsServiceMappingMultiCrudActive);

		if (component.bpjsServiceMappingMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsServiceMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model')).length;

			bpjsServiceMappingButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsServiceMappingRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model')).length;

			expect(actualBpjsServiceMappingRemoveButtonCount).toEqual(initialBpjsServiceMappingRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Service Mapping button', () => {
		const bpjsServiceMappingButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsServiceMappingButton).toEqual(component.bpjsServiceMappingMultiCrudActive);

		if (component.bpjsServiceMappingMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsServiceMappingButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsServiceMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsServiceMappingRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsServiceMappingRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model'));

			expect(actualBpjsServiceMappingRemoveButtons.length).toEqual(initialBpjsServiceMappingRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Service Mapping button when one has already been added', () => {

		const bpjsServiceMappingButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsServiceMappingButton).toEqual(component.bpjsServiceMappingMultiCrudActive);

		if (component.bpjsServiceMappingMultiCrudActive) {
			bpjsServiceMappingButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsServiceMappingButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsServiceMappingDisplayName + ' to Model'));

			expect(updatedbpjsServiceMappingButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Service Mapping entities from model when loading in edit mode', () => {
		component.targetModel = bpjsHospitalizationPlanWithId;
		component.targetModelId = bpjsHospitalizationPlanWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsServiceMappingMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsServiceMappingRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsServiceMappingDisplayName + ' from Model')).length;

			expect(bpjsServiceMappingRemoveButtonCount).toEqual(1);
		}
	});

});
