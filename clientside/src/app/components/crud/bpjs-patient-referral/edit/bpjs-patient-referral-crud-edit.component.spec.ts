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
	getBpjsPatientReferralCollectionModels,
	getCountBpjsPatientReferralModels,
	getBpjsPatientReferralModelWithId
} from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.selector';
import { BpjsPatientReferralCrudModule } from '../bpjs-patient-referral-crud.module';
import { BpjsPatientReferralCrudEditComponent } from './bpjs-patient-referral-crud-edit.component';
import {
	BpjsPatientReferralModelState,
	initialState as initialBpjsPatientReferralModelState
} from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model.state';
import { BpjsPatientReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-patient-referral-data-factory';
import { BpjsPatientReferralModel } from 'src/app/models/bpjsPatientReferral/bpjs_patient_referral.model';
import { CrudTileMode } from '../bpjs-patient-referral-crud.component';
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
import { getBpjsDiagnoseModelWithId } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { getBpjsDiagnoseCollectionModels } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { BpjsDiagnoseModel } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import { BpjsDiagnoseDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-data-factory';
import { getBpjsFacilityListModelWithId } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.selector';
import { getBpjsFacilityListCollectionModels } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model.selector';
import { BpjsFacilityListModel } from 'src/app/models/bpjsFacilityList/bpjs_facility_list.model';
import { BpjsFacilityListDataFactory } from 'src/app/lib/utils/factories/bpjs-facility-list-data-factory';
import { getBpjsHealthFacilityModelWithId } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { getBpjsHealthFacilityCollectionModels } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model.selector';
import { BpjsHealthFacilityModel } from 'src/app/models/bpjsHealthFacility/bpjs_health_facility.model';
import { BpjsHealthFacilityDataFactory } from 'src/app/lib/utils/factories/bpjs-health-facility-data-factory';
import { getBpjsHospitalizationPlanModelWithId } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { getBpjsHospitalizationPlanCollectionModels } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model.selector';
import { BpjsHospitalizationPlanModel } from 'src/app/models/bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import { BpjsHospitalizationPlanDataFactory } from 'src/app/lib/utils/factories/bpjs-hospitalization-plan-data-factory';
import { getBpjsJasaRaharjaModelWithId } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { getBpjsJasaRaharjaCollectionModels } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model.selector';
import { BpjsJasaRaharjaModel } from 'src/app/models/bpjsJasaRaharja/bpjs_jasa_raharja.model';
import { BpjsJasaRaharjaDataFactory } from 'src/app/lib/utils/factories/bpjs-jasa-raharja-data-factory';
import { getBpjsReferralSpecialistModelWithId } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.selector';
import { getBpjsReferralSpecialistCollectionModels } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model.selector';
import { BpjsReferralSpecialistModel } from 'src/app/models/bpjsReferralSpecialist/bpjs_referral_specialist.model';
import { BpjsReferralSpecialistDataFactory } from 'src/app/lib/utils/factories/bpjs-referral-specialist-data-factory';
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
import { getBpjsSpecialReferralModelWithId } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.selector';
import { getBpjsSpecialReferralCollectionModels } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model.selector';
import { BpjsSpecialReferralModel } from 'src/app/models/bpjsSpecialReferral/bpjs_special_referral.model';
import { BpjsSpecialReferralDataFactory } from 'src/app/lib/utils/factories/bpjs-special-referral-data-factory';
import { getDiagnosesAndProceduresModelWithId } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { getDiagnosesAndProceduresCollectionModels } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { DiagnosesAndProceduresDataFactory } from 'src/app/lib/utils/factories/diagnoses-and-procedures-data-factory';
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

describe('BPJS Patient Referral CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsPatientReferralCrudEditComponent>
	let component: BpjsPatientReferralCrudEditComponent;

	let bpjsPatientReferralModelState: BpjsPatientReferralModelState;

	let store: MockStore<{ model: BpjsPatientReferralModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsPatientReferralCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsPatientReferralModelsBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel[]>;
	let bpjsAccidentMasterModelsBehaviorSubject: BehaviorSubject<BpjsAccidentMasterModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let bpjsControlPlanModelsBehaviorSubject: BehaviorSubject<BpjsControlPlanModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsFacilityListModelsBehaviorSubject: BehaviorSubject<BpjsFacilityListModel[]>;
	let bpjsHealthFacilityModelsBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel[]>;
	let bpjsHospitalizationPlanModelsBehaviorSubject: BehaviorSubject<BpjsHospitalizationPlanModel[]>;
	let bpjsJasaRaharjaModelsBehaviorSubject: BehaviorSubject<BpjsJasaRaharjaModel[]>;
	let bpjsReferralSpecialistModelsBehaviorSubject: BehaviorSubject<BpjsReferralSpecialistModel[]>;
	let bpjsSEPModelsBehaviorSubject: BehaviorSubject<BpjsSEPModel[]>;
	let bpjsSEPSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsSEPSubmissionModel[]>;
	let bpjsServiceMappingModelsBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel[]>;
	let bpjsSpecialReferralModelsBehaviorSubject: BehaviorSubject<BpjsSpecialReferralModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;
	let serviceModelsBehaviorSubject: BehaviorSubject<ServiceModel[]>;

	const bpjsPatientReferralFactory: BpjsPatientReferralDataFactory = new BpjsPatientReferralDataFactory();
	const defaultBpjsPatientReferralCount: number = 10;
	const defaultBpjsPatientReferralEntities: BpjsPatientReferralModel[] = bpjsPatientReferralFactory.createAll(defaultBpjsPatientReferralCount);

	const bpjsAccidentMasterFactory: BpjsAccidentMasterDataFactory = new BpjsAccidentMasterDataFactory();
	const defaultBpjsAccidentMasterCount: number = 10;
	const defaultBpjsAccidentMasterEntities: BpjsAccidentMasterModel[] = bpjsAccidentMasterFactory.createAll(defaultBpjsAccidentMasterCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const bpjsControlPlanFactory: BpjsControlPlanDataFactory = new BpjsControlPlanDataFactory();
	const defaultBpjsControlPlanCount: number = 10;
	const defaultBpjsControlPlanEntities: BpjsControlPlanModel[] = bpjsControlPlanFactory.createAll(defaultBpjsControlPlanCount);

	const bpjsDiagnoseFactory: BpjsDiagnoseDataFactory = new BpjsDiagnoseDataFactory();
	const defaultBpjsDiagnoseCount: number = 10;
	const defaultBpjsDiagnoseEntities: BpjsDiagnoseModel[] = bpjsDiagnoseFactory.createAll(defaultBpjsDiagnoseCount);

	const bpjsFacilityListFactory: BpjsFacilityListDataFactory = new BpjsFacilityListDataFactory();
	const defaultBpjsFacilityListCount: number = 10;
	const defaultBpjsFacilityListEntities: BpjsFacilityListModel[] = bpjsFacilityListFactory.createAll(defaultBpjsFacilityListCount);

	const bpjsHealthFacilityFactory: BpjsHealthFacilityDataFactory = new BpjsHealthFacilityDataFactory();
	const defaultBpjsHealthFacilityCount: number = 10;
	const defaultBpjsHealthFacilityEntities: BpjsHealthFacilityModel[] = bpjsHealthFacilityFactory.createAll(defaultBpjsHealthFacilityCount);

	const bpjsHospitalizationPlanFactory: BpjsHospitalizationPlanDataFactory = new BpjsHospitalizationPlanDataFactory();
	const defaultBpjsHospitalizationPlanCount: number = 10;
	const defaultBpjsHospitalizationPlanEntities: BpjsHospitalizationPlanModel[] = bpjsHospitalizationPlanFactory.createAll(defaultBpjsHospitalizationPlanCount);

	const bpjsJasaRaharjaFactory: BpjsJasaRaharjaDataFactory = new BpjsJasaRaharjaDataFactory();
	const defaultBpjsJasaRaharjaCount: number = 10;
	const defaultBpjsJasaRaharjaEntities: BpjsJasaRaharjaModel[] = bpjsJasaRaharjaFactory.createAll(defaultBpjsJasaRaharjaCount);

	const bpjsReferralSpecialistFactory: BpjsReferralSpecialistDataFactory = new BpjsReferralSpecialistDataFactory();
	const defaultBpjsReferralSpecialistCount: number = 10;
	const defaultBpjsReferralSpecialistEntities: BpjsReferralSpecialistModel[] = bpjsReferralSpecialistFactory.createAll(defaultBpjsReferralSpecialistCount);

	const bpjsSEPFactory: BpjsSEPDataFactory = new BpjsSEPDataFactory();
	const defaultBpjsSEPCount: number = 10;
	const defaultBpjsSEPEntities: BpjsSEPModel[] = bpjsSEPFactory.createAll(defaultBpjsSEPCount);

	const bpjsSEPSubmissionFactory: BpjsSEPSubmissionDataFactory = new BpjsSEPSubmissionDataFactory();
	const defaultBpjsSEPSubmissionCount: number = 10;
	const defaultBpjsSEPSubmissionEntities: BpjsSEPSubmissionModel[] = bpjsSEPSubmissionFactory.createAll(defaultBpjsSEPSubmissionCount);

	const bpjsServiceMappingFactory: BpjsServiceMappingDataFactory = new BpjsServiceMappingDataFactory();
	const defaultBpjsServiceMappingCount: number = 10;
	const defaultBpjsServiceMappingEntities: BpjsServiceMappingModel[] = bpjsServiceMappingFactory.createAll(defaultBpjsServiceMappingCount);

	const bpjsSpecialReferralFactory: BpjsSpecialReferralDataFactory = new BpjsSpecialReferralDataFactory();
	const defaultBpjsSpecialReferralCount: number = 10;
	const defaultBpjsSpecialReferralEntities: BpjsSpecialReferralModel[] = bpjsSpecialReferralFactory.createAll(defaultBpjsSpecialReferralCount);

	const diagnosesAndProceduresFactory: DiagnosesAndProceduresDataFactory = new DiagnosesAndProceduresDataFactory();
	const defaultDiagnosesAndProceduresCount: number = 10;
	const defaultDiagnosesAndProceduresEntities: DiagnosesAndProceduresModel[] = diagnosesAndProceduresFactory.createAll(defaultDiagnosesAndProceduresCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentBPJSFactory: PatientPaymentBPJSDataFactory = new PatientPaymentBPJSDataFactory();
	const defaultPatientPaymentBPJSCount: number = 10;
	const defaultPatientPaymentBPJSEntities: PatientPaymentBPJSModel[] = patientPaymentBPJSFactory.createAll(defaultPatientPaymentBPJSCount);

	const serviceFactory: ServiceDataFactory = new ServiceDataFactory();
	const defaultServiceCount: number = 10;
	const defaultServiceEntities: ServiceModel[] = serviceFactory.createAll(defaultServiceCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsPatientReferralWithId: BpjsPatientReferralModel = defaultBpjsPatientReferralEntities[0];
	let bpjsPatientReferralModelWithIdBehaviorSubject: BehaviorSubject<BpjsPatientReferralModel>;

	bpjsPatientReferralWithId.bpjsDiagnose = defaultBpjsDiagnoseEntities[0];
	bpjsPatientReferralWithId.bpjsDiagnoseId = bpjsPatientReferralWithId.bpjsDiagnose.id;
	let bpjsDiagnoseWithIdBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel>;

	bpjsPatientReferralWithId.bpjsHealthFacility = defaultBpjsHealthFacilityEntities[0];
	bpjsPatientReferralWithId.bpjsHealthFacilityId = bpjsPatientReferralWithId.bpjsHealthFacility.id;
	let bpjsHealthFacilityWithIdBehaviorSubject: BehaviorSubject<BpjsHealthFacilityModel>;

	bpjsPatientReferralWithId.bpjsServiceMapping = defaultBpjsServiceMappingEntities[0];
	bpjsPatientReferralWithId.bpjsServiceMappingId = bpjsPatientReferralWithId.bpjsServiceMapping.id;
	let bpjsServiceMappingWithIdBehaviorSubject: BehaviorSubject<BpjsServiceMappingModel>;

	bpjsPatientReferralWithId.patientPaymentBPJS = defaultPatientPaymentBPJSEntities[0];
	bpjsPatientReferralWithId.patientPaymentBPJSId = bpjsPatientReferralWithId.patientPaymentBPJS.id;
	let patientPaymentBPJSWithIdBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel>;


	const routerState: RouterState = {
		url: 'bpjs-patient-referral-crud',
		urls: ['bpjs-patient-referral-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsPatientReferralModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsPatientReferralModelState = initialBpjsPatientReferralModelState;
		store.setState({model: bpjsPatientReferralModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsPatientReferralCountBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralCount);

		// selectors for all references
		bpjsPatientReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPatientReferralEntities);
		bpjsAccidentMasterModelsBehaviorSubject = new BehaviorSubject(defaultBpjsAccidentMasterEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		bpjsControlPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsControlPlanEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsFacilityListModelsBehaviorSubject = new BehaviorSubject(defaultBpjsFacilityListEntities);
		bpjsHealthFacilityModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHealthFacilityEntities);
		bpjsHospitalizationPlanModelsBehaviorSubject = new BehaviorSubject(defaultBpjsHospitalizationPlanEntities);
		bpjsJasaRaharjaModelsBehaviorSubject = new BehaviorSubject(defaultBpjsJasaRaharjaEntities);
		bpjsReferralSpecialistModelsBehaviorSubject = new BehaviorSubject(defaultBpjsReferralSpecialistEntities);
		bpjsSEPModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPEntities);
		bpjsSEPSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSEPSubmissionEntities);
		bpjsServiceMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsServiceMappingEntities);
		bpjsSpecialReferralModelsBehaviorSubject = new BehaviorSubject(defaultBpjsSpecialReferralEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);
		serviceModelsBehaviorSubject = new BehaviorSubject(defaultServiceEntities);

		// selectors for target entity and its related entity
		bpjsPatientReferralModelWithIdBehaviorSubject = new BehaviorSubject(bpjsPatientReferralWithId);
		bpjsDiagnoseWithIdBehaviorSubject = new BehaviorSubject(bpjsPatientReferralWithId.bpjsDiagnose);
		bpjsHealthFacilityWithIdBehaviorSubject = new BehaviorSubject(bpjsPatientReferralWithId.bpjsHealthFacility);
		bpjsServiceMappingWithIdBehaviorSubject = new BehaviorSubject(bpjsPatientReferralWithId.bpjsServiceMapping);
		patientPaymentBPJSWithIdBehaviorSubject = new BehaviorSubject(bpjsPatientReferralWithId.patientPaymentBPJS);

		spyOn(store, 'select')
			.withArgs(getCountBpjsPatientReferralModels).and.returnValue(bpjsPatientReferralCountBehaviorSubject)
			.withArgs(getBpjsPatientReferralModelWithId, bpjsPatientReferralWithId.id).and.returnValue(bpjsPatientReferralModelWithIdBehaviorSubject)
			.withArgs(getBpjsPatientReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsPatientReferralModelsBehaviorSubject)
			.withArgs(getBpjsAccidentMasterCollectionModels, jasmine.any(String)).and.returnValue(bpjsAccidentMasterModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsControlPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsControlPlanModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsFacilityListCollectionModels, jasmine.any(String)).and.returnValue(bpjsFacilityListModelsBehaviorSubject)
			.withArgs(getBpjsHealthFacilityCollectionModels, jasmine.any(String)).and.returnValue(bpjsHealthFacilityModelsBehaviorSubject)
			.withArgs(getBpjsHospitalizationPlanCollectionModels, jasmine.any(String)).and.returnValue(bpjsHospitalizationPlanModelsBehaviorSubject)
			.withArgs(getBpjsJasaRaharjaCollectionModels, jasmine.any(String)).and.returnValue(bpjsJasaRaharjaModelsBehaviorSubject)
			.withArgs(getBpjsReferralSpecialistCollectionModels, jasmine.any(String)).and.returnValue(bpjsReferralSpecialistModelsBehaviorSubject)
			.withArgs(getBpjsSEPCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPModelsBehaviorSubject)
			.withArgs(getBpjsSEPSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsSEPSubmissionModelsBehaviorSubject)
			.withArgs(getBpjsServiceMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsServiceMappingModelsBehaviorSubject)
			.withArgs(getBpjsSpecialReferralCollectionModels, jasmine.any(String)).and.returnValue(bpjsSpecialReferralModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
			.withArgs(getServiceCollectionModels, jasmine.any(String)).and.returnValue(serviceModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseModelWithId, bpjsPatientReferralWithId.bpjsDiagnoseId).and.returnValue(bpjsDiagnoseWithIdBehaviorSubject)
			.withArgs(getBpjsHealthFacilityModelWithId, bpjsPatientReferralWithId.bpjsHealthFacilityId).and.returnValue(bpjsHealthFacilityWithIdBehaviorSubject)
			.withArgs(getBpjsServiceMappingModelWithId, bpjsPatientReferralWithId.bpjsServiceMappingId).and.returnValue(bpjsServiceMappingWithIdBehaviorSubject)
			.withArgs(getPatientPaymentBPJSModelWithId, bpjsPatientReferralWithId.patientPaymentBPJSId).and.returnValue(patientPaymentBPJSWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsPatientReferralCrudModule,
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

			fixture = TestBed.createComponent(BpjsPatientReferralCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsPatientReferralModel();
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
	it ('Renders the BPJS Patient Referral CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the BPJS Diagnose relation.
	*
	* The button should only exist if bpjsDiagnoseMultiCrudActive is true
	*/
	it ('Renders BPJS Diagnose Add Entity button in create mode', fakeAsync(() => {
		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Diagnose', fakeAsync(() => {
		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);

		if (component.bpjsDiagnoseMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model')).length;

			bpjsDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnoseRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model')).length;

			expect(actualBpjsDiagnoseRemoveButtonCount).toEqual(initialBpjsDiagnoseRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Diagnose button', () => {
		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);

		if (component.bpjsDiagnoseMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsDiagnoseRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsDiagnoseRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model'));

			expect(actualBpjsDiagnoseRemoveButtons.length).toEqual(initialBpjsDiagnoseRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Diagnose button when one has already been added', () => {

		const bpjsDiagnoseButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsDiagnoseButton).toEqual(component.bpjsDiagnoseMultiCrudActive);

		if (component.bpjsDiagnoseMultiCrudActive) {
			bpjsDiagnoseButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsDiagnoseButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsDiagnoseDisplayName + ' to Model'));

			expect(updatedbpjsDiagnoseButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Diagnose entities from model when loading in edit mode', () => {
		component.targetModel = bpjsPatientReferralWithId;
		component.targetModelId = bpjsPatientReferralWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsDiagnoseMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsDiagnoseRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsDiagnoseDisplayName + ' from Model')).length;

			expect(bpjsDiagnoseRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS Health Facility relation.
	*
	* The button should only exist if bpjsHealthFacilityMultiCrudActive is true
	*/
	it ('Renders BPJS Health Facility Add Entity button in create mode', fakeAsync(() => {
		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS Health Facility', fakeAsync(() => {
		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);

		if (component.bpjsHealthFacilityMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsHealthFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model')).length;

			bpjsHealthFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsHealthFacilityRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model')).length;

			expect(actualBpjsHealthFacilityRemoveButtonCount).toEqual(initialBpjsHealthFacilityRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS Health Facility button', () => {
		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);

		if (component.bpjsHealthFacilityMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsHealthFacilityButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsHealthFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsHealthFacilityRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsHealthFacilityRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model'));

			expect(actualBpjsHealthFacilityRemoveButtons.length).toEqual(initialBpjsHealthFacilityRemoveButtons.length - 1);
		}
	});

	it ('should disable the add BPJS Health Facility button when one has already been added', () => {

		const bpjsHealthFacilityButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsHealthFacilityButton).toEqual(component.bpjsHealthFacilityMultiCrudActive);

		if (component.bpjsHealthFacilityMultiCrudActive) {
			bpjsHealthFacilityButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsHealthFacilityButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsHealthFacilityDisplayName + ' to Model'));

			expect(updatedbpjsHealthFacilityButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related BPJS Health Facility entities from model when loading in edit mode', () => {
		component.targetModel = bpjsPatientReferralWithId;
		component.targetModelId = bpjsPatientReferralWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsHealthFacilityMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsHealthFacilityRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsHealthFacilityDisplayName + ' from Model')).length;

			expect(bpjsHealthFacilityRemoveButtonCount).toEqual(1);
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
		component.targetModel = bpjsPatientReferralWithId;
		component.targetModelId = bpjsPatientReferralWithId.id;
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
		component.targetModel = bpjsPatientReferralWithId;
		component.targetModelId = bpjsPatientReferralWithId.id;
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

});
