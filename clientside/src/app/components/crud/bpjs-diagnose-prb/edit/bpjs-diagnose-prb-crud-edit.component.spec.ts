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
	getBpjsDiagnosePRBCollectionModels,
	getCountBpjsDiagnosePRBModels,
	getBpjsDiagnosePRBModelWithId
} from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.selector';
import { BpjsDiagnosePRBCrudModule } from '../bpjs-diagnose-prb-crud.module';
import { BpjsDiagnosePRBCrudEditComponent } from './bpjs-diagnose-prb-crud-edit.component';
import {
	BpjsDiagnosePRBModelState,
	initialState as initialBpjsDiagnosePRBModelState
} from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.state';
import { BpjsDiagnosePRBDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-prb-data-factory';
import { BpjsDiagnosePRBModel } from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model';
import { CrudTileMode } from '../bpjs-diagnose-prb-crud.component';
import { getBpjsDiagnoseModelWithId } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { getBpjsDiagnoseCollectionModels } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import { BpjsDiagnoseModel } from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import { BpjsDiagnoseDataFactory } from 'src/app/lib/utils/factories/bpjs-diagnose-data-factory';
import { getBpjsDoctorMappingModelWithId } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { getBpjsDoctorMappingCollectionModels } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model.selector';
import { BpjsDoctorMappingModel } from 'src/app/models/bpjsDoctorMapping/bpjs_doctor_mapping.model';
import { BpjsDoctorMappingDataFactory } from 'src/app/lib/utils/factories/bpjs-doctor-mapping-data-factory';
import { getBpjsPRBModelWithId } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { getBpjsPRBCollectionModels } from 'src/app/models/bpjsPRB/bpjs_prb.model.selector';
import { BpjsPRBModel } from 'src/app/models/bpjsPRB/bpjs_prb.model';
import { BpjsPRBDataFactory } from 'src/app/lib/utils/factories/bpjs-prb-data-factory';
import { getDailyCareCPPTModelWithId } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import { getDailyCareCPPTCollectionModels } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import { DailyCareCPPTModel } from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import { DailyCareCPPTDataFactory } from 'src/app/lib/utils/factories/daily-care-cppt-data-factory';
import { getDiagnosesAndProceduresModelWithId } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { getDiagnosesAndProceduresCollectionModels } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import { DiagnosesAndProceduresModel } from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import { DiagnosesAndProceduresDataFactory } from 'src/app/lib/utils/factories/diagnoses-and-procedures-data-factory';
import { getDiagnosisExaminationRecordModelWithId } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import { getDiagnosisExaminationRecordCollectionModels } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import { DiagnosisExaminationRecordModel } from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model';
import { DiagnosisExaminationRecordDataFactory } from 'src/app/lib/utils/factories/diagnosis-examination-record-data-factory';
import { getDiagnosisNandaModelWithId } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { getDiagnosisNandaCollectionModels } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import { DiagnosisNandaModel } from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import { DiagnosisNandaDataFactory } from 'src/app/lib/utils/factories/diagnosis-nanda-data-factory';
import { getIcd10ModelWithId } from 'src/app/models/icd10/icd_10.model.selector';
import { getIcd10CollectionModels } from 'src/app/models/icd10/icd_10.model.selector';
import { Icd10Model } from 'src/app/models/icd10/icd_10.model';
import { Icd10DataFactory } from 'src/app/lib/utils/factories/icd-10-data-factory';
import { getIcd9CMModelWithId } from 'src/app/models/icd9CM/icd_9_cm.model.selector';
import { getIcd9CMCollectionModels } from 'src/app/models/icd9CM/icd_9_cm.model.selector';
import { Icd9CMModel } from 'src/app/models/icd9CM/icd_9_cm.model';
import { Icd9CMDataFactory } from 'src/app/lib/utils/factories/icd-9-cm-data-factory';
import { getInvoiceModelWithId } from 'src/app/models/invoice/invoice.model.selector';
import { getInvoiceCollectionModels } from 'src/app/models/invoice/invoice.model.selector';
import { InvoiceModel } from 'src/app/models/invoice/invoice.model';
import { InvoiceDataFactory } from 'src/app/lib/utils/factories/invoice-data-factory';
import { getMedicalCertificateDischargeResumeModelWithId } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import { getMedicalCertificateDischargeResumeCollectionModels } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import { MedicalCertificateDischargeResumeModel } from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import { MedicalCertificateDischargeResumeDataFactory } from 'src/app/lib/utils/factories/medical-certificate-discharge-resume-data-factory';
import { getPostOperativeDetailsModelWithId } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { getPostOperativeDetailsCollectionModels } from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import { PostOperativeDetailsModel } from 'src/app/models/postOperativeDetails/post_operative_details.model';
import { PostOperativeDetailsDataFactory } from 'src/app/lib/utils/factories/post-operative-details-data-factory';
import { getPreoperativeRecordsModelWithId } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { getPreoperativeRecordsCollectionModels } from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import { PreoperativeRecordsModel } from 'src/app/models/preoperativeRecords/preoperative_records.model';
import { PreoperativeRecordsDataFactory } from 'src/app/lib/utils/factories/preoperative-records-data-factory';
import { getRegistrationModelWithId } from 'src/app/models/registration/registration.model.selector';
import { getRegistrationCollectionModels } from 'src/app/models/registration/registration.model.selector';
import { RegistrationModel } from 'src/app/models/registration/registration.model';
import { RegistrationDataFactory } from 'src/app/lib/utils/factories/registration-data-factory';

describe('BPJS Diagnose PRB CRUD Edit component tests', () => {
	let fixture: ComponentFixture<BpjsDiagnosePRBCrudEditComponent>
	let component: BpjsDiagnosePRBCrudEditComponent;

	let bpjsDiagnosePRBModelState: BpjsDiagnosePRBModelState;

	let store: MockStore<{ model: BpjsDiagnosePRBModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let bpjsDiagnosePRBCountBehaviorSubject: BehaviorSubject<number>;
	let bpjsDiagnosePRBModelsBehaviorSubject: BehaviorSubject<BpjsDiagnosePRBModel[]>;
	let bpjsDiagnoseModelsBehaviorSubject: BehaviorSubject<BpjsDiagnoseModel[]>;
	let bpjsDoctorMappingModelsBehaviorSubject: BehaviorSubject<BpjsDoctorMappingModel[]>;
	let bpjsPRBModelsBehaviorSubject: BehaviorSubject<BpjsPRBModel[]>;
	let dailyCareCPPTModelsBehaviorSubject: BehaviorSubject<DailyCareCPPTModel[]>;
	let diagnosesAndProceduresModelsBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel[]>;
	let diagnosisExaminationRecordModelsBehaviorSubject: BehaviorSubject<DiagnosisExaminationRecordModel[]>;
	let diagnosisNandaModelsBehaviorSubject: BehaviorSubject<DiagnosisNandaModel[]>;
	let icd10ModelsBehaviorSubject: BehaviorSubject<Icd10Model[]>;
	let icd9CMModelsBehaviorSubject: BehaviorSubject<Icd9CMModel[]>;
	let invoiceModelsBehaviorSubject: BehaviorSubject<InvoiceModel[]>;
	let medicalCertificateDischargeResumeModelsBehaviorSubject: BehaviorSubject<MedicalCertificateDischargeResumeModel[]>;
	let postOperativeDetailsModelsBehaviorSubject: BehaviorSubject<PostOperativeDetailsModel[]>;
	let preoperativeRecordsModelsBehaviorSubject: BehaviorSubject<PreoperativeRecordsModel[]>;
	let registrationModelsBehaviorSubject: BehaviorSubject<RegistrationModel[]>;

	const bpjsDiagnosePRBFactory: BpjsDiagnosePRBDataFactory = new BpjsDiagnosePRBDataFactory();
	const defaultBpjsDiagnosePRBCount: number = 10;
	const defaultBpjsDiagnosePRBEntities: BpjsDiagnosePRBModel[] = bpjsDiagnosePRBFactory.createAll(defaultBpjsDiagnosePRBCount);

	const bpjsDiagnoseFactory: BpjsDiagnoseDataFactory = new BpjsDiagnoseDataFactory();
	const defaultBpjsDiagnoseCount: number = 10;
	const defaultBpjsDiagnoseEntities: BpjsDiagnoseModel[] = bpjsDiagnoseFactory.createAll(defaultBpjsDiagnoseCount);

	const bpjsDoctorMappingFactory: BpjsDoctorMappingDataFactory = new BpjsDoctorMappingDataFactory();
	const defaultBpjsDoctorMappingCount: number = 10;
	const defaultBpjsDoctorMappingEntities: BpjsDoctorMappingModel[] = bpjsDoctorMappingFactory.createAll(defaultBpjsDoctorMappingCount);

	const bpjsPRBFactory: BpjsPRBDataFactory = new BpjsPRBDataFactory();
	const defaultBpjsPRBCount: number = 10;
	const defaultBpjsPRBEntities: BpjsPRBModel[] = bpjsPRBFactory.createAll(defaultBpjsPRBCount);

	const dailyCareCPPTFactory: DailyCareCPPTDataFactory = new DailyCareCPPTDataFactory();
	const defaultDailyCareCPPTCount: number = 10;
	const defaultDailyCareCPPTEntities: DailyCareCPPTModel[] = dailyCareCPPTFactory.createAll(defaultDailyCareCPPTCount);

	const diagnosesAndProceduresFactory: DiagnosesAndProceduresDataFactory = new DiagnosesAndProceduresDataFactory();
	const defaultDiagnosesAndProceduresCount: number = 10;
	const defaultDiagnosesAndProceduresEntities: DiagnosesAndProceduresModel[] = diagnosesAndProceduresFactory.createAll(defaultDiagnosesAndProceduresCount);

	const diagnosisExaminationRecordFactory: DiagnosisExaminationRecordDataFactory = new DiagnosisExaminationRecordDataFactory();
	const defaultDiagnosisExaminationRecordCount: number = 10;
	const defaultDiagnosisExaminationRecordEntities: DiagnosisExaminationRecordModel[] = diagnosisExaminationRecordFactory.createAll(defaultDiagnosisExaminationRecordCount);

	const diagnosisNandaFactory: DiagnosisNandaDataFactory = new DiagnosisNandaDataFactory();
	const defaultDiagnosisNandaCount: number = 10;
	const defaultDiagnosisNandaEntities: DiagnosisNandaModel[] = diagnosisNandaFactory.createAll(defaultDiagnosisNandaCount);

	const icd10Factory: Icd10DataFactory = new Icd10DataFactory();
	const defaultIcd10Count: number = 10;
	const defaultIcd10Entities: Icd10Model[] = icd10Factory.createAll(defaultIcd10Count);

	const icd9CMFactory: Icd9CMDataFactory = new Icd9CMDataFactory();
	const defaultIcd9CMCount: number = 10;
	const defaultIcd9CMEntities: Icd9CMModel[] = icd9CMFactory.createAll(defaultIcd9CMCount);

	const invoiceFactory: InvoiceDataFactory = new InvoiceDataFactory();
	const defaultInvoiceCount: number = 10;
	const defaultInvoiceEntities: InvoiceModel[] = invoiceFactory.createAll(defaultInvoiceCount);

	const medicalCertificateDischargeResumeFactory: MedicalCertificateDischargeResumeDataFactory = new MedicalCertificateDischargeResumeDataFactory();
	const defaultMedicalCertificateDischargeResumeCount: number = 10;
	const defaultMedicalCertificateDischargeResumeEntities: MedicalCertificateDischargeResumeModel[] = medicalCertificateDischargeResumeFactory.createAll(defaultMedicalCertificateDischargeResumeCount);

	const postOperativeDetailsFactory: PostOperativeDetailsDataFactory = new PostOperativeDetailsDataFactory();
	const defaultPostOperativeDetailsCount: number = 10;
	const defaultPostOperativeDetailsEntities: PostOperativeDetailsModel[] = postOperativeDetailsFactory.createAll(defaultPostOperativeDetailsCount);

	const preoperativeRecordsFactory: PreoperativeRecordsDataFactory = new PreoperativeRecordsDataFactory();
	const defaultPreoperativeRecordsCount: number = 10;
	const defaultPreoperativeRecordsEntities: PreoperativeRecordsModel[] = preoperativeRecordsFactory.createAll(defaultPreoperativeRecordsCount);

	const registrationFactory: RegistrationDataFactory = new RegistrationDataFactory();
	const defaultRegistrationCount: number = 10;
	const defaultRegistrationEntities: RegistrationModel[] = registrationFactory.createAll(defaultRegistrationCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let bpjsDiagnosePRBWithId: BpjsDiagnosePRBModel = defaultBpjsDiagnosePRBEntities[0];
	let bpjsDiagnosePRBModelWithIdBehaviorSubject: BehaviorSubject<BpjsDiagnosePRBModel>;

	bpjsDiagnosePRBWithId.diagnosesAndProcedures = defaultDiagnosesAndProceduresEntities[0];
	bpjsDiagnosePRBWithId.diagnosesAndProceduresId = bpjsDiagnosePRBWithId.diagnosesAndProcedures.id;
	let diagnosesAndProceduresWithIdBehaviorSubject: BehaviorSubject<DiagnosesAndProceduresModel>;

	bpjsDiagnosePRBWithId.bpjsPRBs = defaultBpjsPRBEntities;
	bpjsDiagnosePRBWithId.bpjsPRBsIds = bpjsDiagnosePRBWithId.bpjsPRBs.map(bpjsPRBs => bpjsPRBs.id);


	const routerState: RouterState = {
		url: 'bpjs-diagnose-prb-crud',
		urls: ['bpjs-diagnose-prb-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: BpjsDiagnosePRBModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		bpjsDiagnosePRBModelState = initialBpjsDiagnosePRBModelState;
		store.setState({model: bpjsDiagnosePRBModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		bpjsDiagnosePRBCountBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnosePRBCount);

		// selectors for all references
		bpjsDiagnosePRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnosePRBEntities);
		bpjsDiagnoseModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDiagnoseEntities);
		bpjsDoctorMappingModelsBehaviorSubject = new BehaviorSubject(defaultBpjsDoctorMappingEntities);
		bpjsPRBModelsBehaviorSubject = new BehaviorSubject(defaultBpjsPRBEntities);
		dailyCareCPPTModelsBehaviorSubject = new BehaviorSubject(defaultDailyCareCPPTEntities);
		diagnosesAndProceduresModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosesAndProceduresEntities);
		diagnosisExaminationRecordModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisExaminationRecordEntities);
		diagnosisNandaModelsBehaviorSubject = new BehaviorSubject(defaultDiagnosisNandaEntities);
		icd10ModelsBehaviorSubject = new BehaviorSubject(defaultIcd10Entities);
		icd9CMModelsBehaviorSubject = new BehaviorSubject(defaultIcd9CMEntities);
		invoiceModelsBehaviorSubject = new BehaviorSubject(defaultInvoiceEntities);
		medicalCertificateDischargeResumeModelsBehaviorSubject = new BehaviorSubject(defaultMedicalCertificateDischargeResumeEntities);
		postOperativeDetailsModelsBehaviorSubject = new BehaviorSubject(defaultPostOperativeDetailsEntities);
		preoperativeRecordsModelsBehaviorSubject = new BehaviorSubject(defaultPreoperativeRecordsEntities);
		registrationModelsBehaviorSubject = new BehaviorSubject(defaultRegistrationEntities);

		// selectors for target entity and its related entity
		bpjsDiagnosePRBModelWithIdBehaviorSubject = new BehaviorSubject(bpjsDiagnosePRBWithId);
		diagnosesAndProceduresWithIdBehaviorSubject = new BehaviorSubject(bpjsDiagnosePRBWithId.diagnosesAndProcedures);

		spyOn(store, 'select')
			.withArgs(getCountBpjsDiagnosePRBModels).and.returnValue(bpjsDiagnosePRBCountBehaviorSubject)
			.withArgs(getBpjsDiagnosePRBModelWithId, bpjsDiagnosePRBWithId.id).and.returnValue(bpjsDiagnosePRBModelWithIdBehaviorSubject)
			.withArgs(getBpjsDiagnosePRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnosePRBModelsBehaviorSubject)
			.withArgs(getBpjsDiagnoseCollectionModels, jasmine.any(String)).and.returnValue(bpjsDiagnoseModelsBehaviorSubject)
			.withArgs(getBpjsDoctorMappingCollectionModels, jasmine.any(String)).and.returnValue(bpjsDoctorMappingModelsBehaviorSubject)
			.withArgs(getBpjsPRBCollectionModels, jasmine.any(String)).and.returnValue(bpjsPRBModelsBehaviorSubject)
			.withArgs(getDailyCareCPPTCollectionModels, jasmine.any(String)).and.returnValue(dailyCareCPPTModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresCollectionModels, jasmine.any(String)).and.returnValue(diagnosesAndProceduresModelsBehaviorSubject)
			.withArgs(getDiagnosisExaminationRecordCollectionModels, jasmine.any(String)).and.returnValue(diagnosisExaminationRecordModelsBehaviorSubject)
			.withArgs(getDiagnosisNandaCollectionModels, jasmine.any(String)).and.returnValue(diagnosisNandaModelsBehaviorSubject)
			.withArgs(getIcd10CollectionModels, jasmine.any(String)).and.returnValue(icd10ModelsBehaviorSubject)
			.withArgs(getIcd9CMCollectionModels, jasmine.any(String)).and.returnValue(icd9CMModelsBehaviorSubject)
			.withArgs(getInvoiceCollectionModels, jasmine.any(String)).and.returnValue(invoiceModelsBehaviorSubject)
			.withArgs(getMedicalCertificateDischargeResumeCollectionModels, jasmine.any(String)).and.returnValue(medicalCertificateDischargeResumeModelsBehaviorSubject)
			.withArgs(getPostOperativeDetailsCollectionModels, jasmine.any(String)).and.returnValue(postOperativeDetailsModelsBehaviorSubject)
			.withArgs(getPreoperativeRecordsCollectionModels, jasmine.any(String)).and.returnValue(preoperativeRecordsModelsBehaviorSubject)
			.withArgs(getRegistrationCollectionModels, jasmine.any(String)).and.returnValue(registrationModelsBehaviorSubject)
			.withArgs(getDiagnosesAndProceduresModelWithId, bpjsDiagnosePRBWithId.diagnosesAndProceduresId).and.returnValue(diagnosesAndProceduresWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				BpjsDiagnosePRBCrudModule,
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

			fixture = TestBed.createComponent(BpjsDiagnosePRBCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new BpjsDiagnosePRBModel();
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
	it ('Renders the BPJS Diagnose PRB CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Diagnoses and Procedures relation.
	*
	* The button should only exist if diagnosesAndProceduresMultiCrudActive is true
	*/
	it ('Renders Diagnoses and Procedures Add Entity button in create mode', fakeAsync(() => {
		const diagnosesAndProceduresButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosesAndProceduresDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!diagnosesAndProceduresButton).toEqual(component.diagnosesAndProceduresMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Diagnoses and Procedures', fakeAsync(() => {
		const diagnosesAndProceduresButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosesAndProceduresDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosesAndProceduresButton).toEqual(component.diagnosesAndProceduresMultiCrudActive);

		if (component.diagnosesAndProceduresMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialDiagnosesAndProceduresRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosesAndProceduresDisplayName + ' from Model')).length;

			diagnosesAndProceduresButton.nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosesAndProceduresRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosesAndProceduresDisplayName + ' from Model')).length;

			expect(actualDiagnosesAndProceduresRemoveButtonCount).toEqual(initialDiagnosesAndProceduresRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Diagnoses and Procedures button', () => {
		const diagnosesAndProceduresButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosesAndProceduresDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosesAndProceduresButton).toEqual(component.diagnosesAndProceduresMultiCrudActive);

		if (component.diagnosesAndProceduresMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			diagnosesAndProceduresButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialDiagnosesAndProceduresRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosesAndProceduresDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialDiagnosesAndProceduresRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualDiagnosesAndProceduresRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosesAndProceduresDisplayName + ' from Model'));

			expect(actualDiagnosesAndProceduresRemoveButtons.length).toEqual(initialDiagnosesAndProceduresRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Diagnoses and Procedures button when one has already been added', () => {

		const diagnosesAndProceduresButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosesAndProceduresDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!diagnosesAndProceduresButton).toEqual(component.diagnosesAndProceduresMultiCrudActive);

		if (component.diagnosesAndProceduresMultiCrudActive) {
			diagnosesAndProceduresButton.nativeElement.click();
			fixture.detectChanges();

			const updateddiagnosesAndProceduresButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.diagnosesAndProceduresDisplayName + ' to Model'));

			expect(updateddiagnosesAndProceduresButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Diagnoses and Procedures entities from model when loading in edit mode', () => {
		component.targetModel = bpjsDiagnosePRBWithId;
		component.targetModelId = bpjsDiagnosePRBWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.diagnosesAndProceduresMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const diagnosesAndProceduresRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.diagnosesAndProceduresDisplayName + ' from Model')).length;

			expect(diagnosesAndProceduresRemoveButtonCount).toEqual(1);
		}
	});

	/**
	* Checks that the status of the add model button matches the multi entity status for the BPJS PRBs relation.
	*
	* The button should only exist if bpjsPRBsMultiCrudActive is true
	*/
	it ('Renders BPJS PRBs Add Entity button in create mode', fakeAsync(() => {
		const bpjsPRBsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBsDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!bpjsPRBsButton).toEqual(component.bpjsPRBsMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new BPJS PRBs', fakeAsync(() => {
		const bpjsPRBsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPRBsButton).toEqual(component.bpjsPRBsMultiCrudActive);

		if (component.bpjsPRBsMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialBpjsPRBsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBsDisplayName + ' from Model')).length;

			bpjsPRBsButton.nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPRBsRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBsDisplayName + ' from Model')).length;

			expect(actualBpjsPRBsRemoveButtonCount).toEqual(initialBpjsPRBsRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove BPJS PRBs button', () => {
		const bpjsPRBsButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPRBsButton).toEqual(component.bpjsPRBsMultiCrudActive);

		if (component.bpjsPRBsMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			bpjsPRBsButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialBpjsPRBsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBsDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialBpjsPRBsRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualBpjsPRBsRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBsDisplayName + ' from Model'));

			expect(actualBpjsPRBsRemoveButtons.length).toEqual(initialBpjsPRBsRemoveButtons.length - 1);
		}
	});

	it ('should not disable the add BPJS PRBs button when one has already been added', () => {

		const bpjsPRBsButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBsDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!bpjsPRBsButton).toEqual(component.bpjsPRBsMultiCrudActive);

		if (component.bpjsPRBsMultiCrudActive) {
			bpjsPRBsButton.nativeElement.click();
			fixture.detectChanges();

			const updatedbpjsPRBsButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.bpjsPRBsDisplayName + ' to Model'));

			expect(updatedbpjsPRBsButton.nativeElement.disabled).toBe(false);
		}
	});

	it ('renders related BPJS PRBs entities from model when loading in edit mode', () => {
		component.targetModel = bpjsDiagnosePRBWithId;
		component.targetModelId = bpjsDiagnosePRBWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.bpjsPRBsMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const bpjsPRBsRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.bpjsPRBsDisplayName + ' from Model')).length;

			expect(bpjsPRBsRemoveButtonCount).toEqual(bpjsDiagnosePRBWithId.bpjsPRBs.length);
		}
	});

});