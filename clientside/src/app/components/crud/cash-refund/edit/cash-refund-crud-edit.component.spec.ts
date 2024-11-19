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
	getCashRefundCollectionModels,
	getCountCashRefundModels,
	getCashRefundModelWithId
} from 'src/app/models/cashRefund/cash_refund.model.selector';
import { CashRefundCrudModule } from '../cash-refund-crud.module';
import { CashRefundCrudEditComponent } from './cash-refund-crud-edit.component';
import {
	CashRefundModelState,
	initialState as initialCashRefundModelState
} from 'src/app/models/cashRefund/cash_refund.model.state';
import { CashRefundDataFactory } from 'src/app/lib/utils/factories/cash-refund-data-factory';
import { CashRefundModel } from 'src/app/models/cashRefund/cash_refund.model';
import { CrudTileMode } from '../cash-refund-crud.component';
import { getBpjsClaimSubmissionModelWithId } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { getBpjsClaimSubmissionCollectionModels } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import { BpjsClaimSubmissionModel } from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import { BpjsClaimSubmissionDataFactory } from 'src/app/lib/utils/factories/bpjs-claim-submission-data-factory';
import { getCashReceiptModelWithId } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { getCashReceiptCollectionModels } from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import { CashReceiptModel } from 'src/app/models/cashReceipt/cash_receipt.model';
import { CashReceiptDataFactory } from 'src/app/lib/utils/factories/cash-receipt-data-factory';
import { getInformedConsentModelWithId } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { getInformedConsentCollectionModels } from 'src/app/models/informedConsent/informed_consent.model.selector';
import { InformedConsentModel } from 'src/app/models/informedConsent/informed_consent.model';
import { InformedConsentDataFactory } from 'src/app/lib/utils/factories/informed-consent-data-factory';
import { getPatientCaseHistoryModelWithId } from 'src/app/models/patientCaseHistory/patient_case_history.model.selector';
import { getPatientCaseHistoryCollectionModels } from 'src/app/models/patientCaseHistory/patient_case_history.model.selector';
import { PatientCaseHistoryModel } from 'src/app/models/patientCaseHistory/patient_case_history.model';
import { PatientCaseHistoryDataFactory } from 'src/app/lib/utils/factories/patient-case-history-data-factory';
import { getPatientConsentModelWithId } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { getPatientConsentCollectionModels } from 'src/app/models/patientConsent/patient_consent.model.selector';
import { PatientConsentModel } from 'src/app/models/patientConsent/patient_consent.model';
import { PatientConsentDataFactory } from 'src/app/lib/utils/factories/patient-consent-data-factory';
import { getPatientContactInfoModelWithId } from 'src/app/models/patientContactInfo/patient_contact_info.model.selector';
import { getPatientContactInfoCollectionModels } from 'src/app/models/patientContactInfo/patient_contact_info.model.selector';
import { PatientContactInfoModel } from 'src/app/models/patientContactInfo/patient_contact_info.model';
import { PatientContactInfoDataFactory } from 'src/app/lib/utils/factories/patient-contact-info-data-factory';
import { getPatientDetailModelWithId } from 'src/app/models/patientDetail/patient_detail.model.selector';
import { getPatientDetailCollectionModels } from 'src/app/models/patientDetail/patient_detail.model.selector';
import { PatientDetailModel } from 'src/app/models/patientDetail/patient_detail.model';
import { PatientDetailDataFactory } from 'src/app/lib/utils/factories/patient-detail-data-factory';
import { getPatientDetailAddressModelWithId } from 'src/app/models/patientDetailAddress/patient_detail_address.model.selector';
import { getPatientDetailAddressCollectionModels } from 'src/app/models/patientDetailAddress/patient_detail_address.model.selector';
import { PatientDetailAddressModel } from 'src/app/models/patientDetailAddress/patient_detail_address.model';
import { PatientDetailAddressDataFactory } from 'src/app/lib/utils/factories/patient-detail-address-data-factory';
import { getPatientEmergencyContactDetailModelWithId } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.selector';
import { getPatientEmergencyContactDetailCollectionModels } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.selector';
import { PatientEmergencyContactDetailModel } from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model';
import { PatientEmergencyContactDetailDataFactory } from 'src/app/lib/utils/factories/patient-emergency-contact-detail-data-factory';
import { getPatientEmploymentDetailModelWithId } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.selector';
import { getPatientEmploymentDetailCollectionModels } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.selector';
import { PatientEmploymentDetailModel } from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model';
import { PatientEmploymentDetailDataFactory } from 'src/app/lib/utils/factories/patient-employment-detail-data-factory';
import { getPatientGeneralInfoModelWithId } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { getPatientGeneralInfoCollectionModels } from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import { PatientGeneralInfoModel } from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import { PatientGeneralInfoDataFactory } from 'src/app/lib/utils/factories/patient-general-info-data-factory';
import { getPatientPaymentSelfPayingModelWithId } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.selector';
import { getPatientPaymentSelfPayingCollectionModels } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.selector';
import { PatientPaymentSelfPayingModel } from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model';
import { PatientPaymentSelfPayingDataFactory } from 'src/app/lib/utils/factories/patient-payment-self-paying-data-factory';
import { getPatientPaymentBPJSModelWithId } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { getPatientPaymentBPJSCollectionModels } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import { PatientPaymentBPJSModel } from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import { PatientPaymentBPJSDataFactory } from 'src/app/lib/utils/factories/patient-payment-bpjs-data-factory';
import { getPatientPaymentInsuranceModelWithId } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { getPatientPaymentInsuranceCollectionModels } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import { PatientPaymentInsuranceModel } from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model';
import { PatientPaymentInsuranceDataFactory } from 'src/app/lib/utils/factories/patient-payment-insurance-data-factory';
import { getPatientPaymentOthersModelWithId } from 'src/app/models/patientPaymentOthers/patient_payment_others.model.selector';
import { getPatientPaymentOthersCollectionModels } from 'src/app/models/patientPaymentOthers/patient_payment_others.model.selector';
import { PatientPaymentOthersModel } from 'src/app/models/patientPaymentOthers/patient_payment_others.model';
import { PatientPaymentOthersDataFactory } from 'src/app/lib/utils/factories/patient-payment-others-data-factory';
import { getPatientPersonalInfoModelWithId } from 'src/app/models/patientPersonalInfo/patient_personal_info.model.selector';
import { getPatientPersonalInfoCollectionModels } from 'src/app/models/patientPersonalInfo/patient_personal_info.model.selector';
import { PatientPersonalInfoModel } from 'src/app/models/patientPersonalInfo/patient_personal_info.model';
import { PatientPersonalInfoDataFactory } from 'src/app/lib/utils/factories/patient-personal-info-data-factory';
import { getPatientSupportingDocumentModelWithId } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.selector';
import { getPatientSupportingDocumentCollectionModels } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.selector';
import { PatientSupportingDocumentModel } from 'src/app/models/patientSupportingDocument/patient_supporting_document.model';
import { PatientSupportingDocumentDataFactory } from 'src/app/lib/utils/factories/patient-supporting-document-data-factory';
import { getPatientVisitModelWithId } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { getPatientVisitCollectionModels } from 'src/app/models/patientVisit/patient_visit.model.selector';
import { PatientVisitModel } from 'src/app/models/patientVisit/patient_visit.model';
import { PatientVisitDataFactory } from 'src/app/lib/utils/factories/patient-visit-data-factory';
import { getRetailPharmacyModelWithId } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { getRetailPharmacyCollectionModels } from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import { RetailPharmacyModel } from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import { RetailPharmacyDataFactory } from 'src/app/lib/utils/factories/retail-pharmacy-data-factory';

describe('Cash Refund CRUD Edit component tests', () => {
	let fixture: ComponentFixture<CashRefundCrudEditComponent>
	let component: CashRefundCrudEditComponent;

	let cashRefundModelState: CashRefundModelState;

	let store: MockStore<{ model: CashRefundModelState }>;
	let routerStore: MockStore<{router: RouterState}>;

	let routerStateBehaviorSubject: BehaviorSubject<RouterState>;
	let cashRefundCountBehaviorSubject: BehaviorSubject<number>;
	let cashRefundModelsBehaviorSubject: BehaviorSubject<CashRefundModel[]>;
	let bpjsClaimSubmissionModelsBehaviorSubject: BehaviorSubject<BpjsClaimSubmissionModel[]>;
	let cashReceiptModelsBehaviorSubject: BehaviorSubject<CashReceiptModel[]>;
	let informedConsentModelsBehaviorSubject: BehaviorSubject<InformedConsentModel[]>;
	let patientCaseHistoryModelsBehaviorSubject: BehaviorSubject<PatientCaseHistoryModel[]>;
	let patientConsentModelsBehaviorSubject: BehaviorSubject<PatientConsentModel[]>;
	let patientContactInfoModelsBehaviorSubject: BehaviorSubject<PatientContactInfoModel[]>;
	let patientDetailModelsBehaviorSubject: BehaviorSubject<PatientDetailModel[]>;
	let patientDetailAddressModelsBehaviorSubject: BehaviorSubject<PatientDetailAddressModel[]>;
	let patientEmergencyContactDetailModelsBehaviorSubject: BehaviorSubject<PatientEmergencyContactDetailModel[]>;
	let patientEmploymentDetailModelsBehaviorSubject: BehaviorSubject<PatientEmploymentDetailModel[]>;
	let patientGeneralInfoModelsBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel[]>;
	let patientPaymentSelfPayingModelsBehaviorSubject: BehaviorSubject<PatientPaymentSelfPayingModel[]>;
	let patientPaymentBPJSModelsBehaviorSubject: BehaviorSubject<PatientPaymentBPJSModel[]>;
	let patientPaymentInsuranceModelsBehaviorSubject: BehaviorSubject<PatientPaymentInsuranceModel[]>;
	let patientPaymentOthersModelsBehaviorSubject: BehaviorSubject<PatientPaymentOthersModel[]>;
	let patientPersonalInfoModelsBehaviorSubject: BehaviorSubject<PatientPersonalInfoModel[]>;
	let patientSupportingDocumentModelsBehaviorSubject: BehaviorSubject<PatientSupportingDocumentModel[]>;
	let patientVisitModelsBehaviorSubject: BehaviorSubject<PatientVisitModel[]>;
	let retailPharmacyModelsBehaviorSubject: BehaviorSubject<RetailPharmacyModel[]>;

	const cashRefundFactory: CashRefundDataFactory = new CashRefundDataFactory();
	const defaultCashRefundCount: number = 10;
	const defaultCashRefundEntities: CashRefundModel[] = cashRefundFactory.createAll(defaultCashRefundCount);

	const bpjsClaimSubmissionFactory: BpjsClaimSubmissionDataFactory = new BpjsClaimSubmissionDataFactory();
	const defaultBpjsClaimSubmissionCount: number = 10;
	const defaultBpjsClaimSubmissionEntities: BpjsClaimSubmissionModel[] = bpjsClaimSubmissionFactory.createAll(defaultBpjsClaimSubmissionCount);

	const cashReceiptFactory: CashReceiptDataFactory = new CashReceiptDataFactory();
	const defaultCashReceiptCount: number = 10;
	const defaultCashReceiptEntities: CashReceiptModel[] = cashReceiptFactory.createAll(defaultCashReceiptCount);

	const informedConsentFactory: InformedConsentDataFactory = new InformedConsentDataFactory();
	const defaultInformedConsentCount: number = 10;
	const defaultInformedConsentEntities: InformedConsentModel[] = informedConsentFactory.createAll(defaultInformedConsentCount);

	const patientCaseHistoryFactory: PatientCaseHistoryDataFactory = new PatientCaseHistoryDataFactory();
	const defaultPatientCaseHistoryCount: number = 10;
	const defaultPatientCaseHistoryEntities: PatientCaseHistoryModel[] = patientCaseHistoryFactory.createAll(defaultPatientCaseHistoryCount);

	const patientConsentFactory: PatientConsentDataFactory = new PatientConsentDataFactory();
	const defaultPatientConsentCount: number = 10;
	const defaultPatientConsentEntities: PatientConsentModel[] = patientConsentFactory.createAll(defaultPatientConsentCount);

	const patientContactInfoFactory: PatientContactInfoDataFactory = new PatientContactInfoDataFactory();
	const defaultPatientContactInfoCount: number = 10;
	const defaultPatientContactInfoEntities: PatientContactInfoModel[] = patientContactInfoFactory.createAll(defaultPatientContactInfoCount);

	const patientDetailFactory: PatientDetailDataFactory = new PatientDetailDataFactory();
	const defaultPatientDetailCount: number = 10;
	const defaultPatientDetailEntities: PatientDetailModel[] = patientDetailFactory.createAll(defaultPatientDetailCount);

	const patientDetailAddressFactory: PatientDetailAddressDataFactory = new PatientDetailAddressDataFactory();
	const defaultPatientDetailAddressCount: number = 10;
	const defaultPatientDetailAddressEntities: PatientDetailAddressModel[] = patientDetailAddressFactory.createAll(defaultPatientDetailAddressCount);

	const patientEmergencyContactDetailFactory: PatientEmergencyContactDetailDataFactory = new PatientEmergencyContactDetailDataFactory();
	const defaultPatientEmergencyContactDetailCount: number = 10;
	const defaultPatientEmergencyContactDetailEntities: PatientEmergencyContactDetailModel[] = patientEmergencyContactDetailFactory.createAll(defaultPatientEmergencyContactDetailCount);

	const patientEmploymentDetailFactory: PatientEmploymentDetailDataFactory = new PatientEmploymentDetailDataFactory();
	const defaultPatientEmploymentDetailCount: number = 10;
	const defaultPatientEmploymentDetailEntities: PatientEmploymentDetailModel[] = patientEmploymentDetailFactory.createAll(defaultPatientEmploymentDetailCount);

	const patientGeneralInfoFactory: PatientGeneralInfoDataFactory = new PatientGeneralInfoDataFactory();
	const defaultPatientGeneralInfoCount: number = 10;
	const defaultPatientGeneralInfoEntities: PatientGeneralInfoModel[] = patientGeneralInfoFactory.createAll(defaultPatientGeneralInfoCount);

	const patientPaymentSelfPayingFactory: PatientPaymentSelfPayingDataFactory = new PatientPaymentSelfPayingDataFactory();
	const defaultPatientPaymentSelfPayingCount: number = 10;
	const defaultPatientPaymentSelfPayingEntities: PatientPaymentSelfPayingModel[] = patientPaymentSelfPayingFactory.createAll(defaultPatientPaymentSelfPayingCount);

	const patientPaymentBPJSFactory: PatientPaymentBPJSDataFactory = new PatientPaymentBPJSDataFactory();
	const defaultPatientPaymentBPJSCount: number = 10;
	const defaultPatientPaymentBPJSEntities: PatientPaymentBPJSModel[] = patientPaymentBPJSFactory.createAll(defaultPatientPaymentBPJSCount);

	const patientPaymentInsuranceFactory: PatientPaymentInsuranceDataFactory = new PatientPaymentInsuranceDataFactory();
	const defaultPatientPaymentInsuranceCount: number = 10;
	const defaultPatientPaymentInsuranceEntities: PatientPaymentInsuranceModel[] = patientPaymentInsuranceFactory.createAll(defaultPatientPaymentInsuranceCount);

	const patientPaymentOthersFactory: PatientPaymentOthersDataFactory = new PatientPaymentOthersDataFactory();
	const defaultPatientPaymentOthersCount: number = 10;
	const defaultPatientPaymentOthersEntities: PatientPaymentOthersModel[] = patientPaymentOthersFactory.createAll(defaultPatientPaymentOthersCount);

	const patientPersonalInfoFactory: PatientPersonalInfoDataFactory = new PatientPersonalInfoDataFactory();
	const defaultPatientPersonalInfoCount: number = 10;
	const defaultPatientPersonalInfoEntities: PatientPersonalInfoModel[] = patientPersonalInfoFactory.createAll(defaultPatientPersonalInfoCount);

	const patientSupportingDocumentFactory: PatientSupportingDocumentDataFactory = new PatientSupportingDocumentDataFactory();
	const defaultPatientSupportingDocumentCount: number = 10;
	const defaultPatientSupportingDocumentEntities: PatientSupportingDocumentModel[] = patientSupportingDocumentFactory.createAll(defaultPatientSupportingDocumentCount);

	const patientVisitFactory: PatientVisitDataFactory = new PatientVisitDataFactory();
	const defaultPatientVisitCount: number = 10;
	const defaultPatientVisitEntities: PatientVisitModel[] = patientVisitFactory.createAll(defaultPatientVisitCount);

	const retailPharmacyFactory: RetailPharmacyDataFactory = new RetailPharmacyDataFactory();
	const defaultRetailPharmacyCount: number = 10;
	const defaultRetailPharmacyEntities: RetailPharmacyModel[] = retailPharmacyFactory.createAll(defaultRetailPharmacyCount);


	// We define the entity which is used in edit mode after all of the other entities because we can now
	// use the data already generated by the previous entity factories to populate the relations of this entity
	let cashRefundWithId: CashRefundModel = defaultCashRefundEntities[0];
	let cashRefundModelWithIdBehaviorSubject: BehaviorSubject<CashRefundModel>;

	cashRefundWithId.patientGeneralInfo = defaultPatientGeneralInfoEntities[0];
	cashRefundWithId.patientGeneralInfoId = cashRefundWithId.patientGeneralInfo.id;
	let patientGeneralInfoWithIdBehaviorSubject: BehaviorSubject<PatientGeneralInfoModel>;


	const routerState: RouterState = {
		url: 'cash-refund-crud',
		urls: ['cash-refund-crud'],
		params: {},
		queryParams: {},
		data: {},
	};

	function spySelectorsInStore() {
		// Setup the Mock Store and fake selector
		store = TestBed.inject(Store) as MockStore<{ model: CashRefundModelState }>;
		routerStore = TestBed.inject(Store) as MockStore<{ router: RouterState }>;

		cashRefundModelState = initialCashRefundModelState;
		store.setState({model: cashRefundModelState});
		routerStateBehaviorSubject = new BehaviorSubject(routerState);
		cashRefundCountBehaviorSubject = new BehaviorSubject(defaultCashRefundCount);

		// selectors for all references
		cashRefundModelsBehaviorSubject = new BehaviorSubject(defaultCashRefundEntities);
		bpjsClaimSubmissionModelsBehaviorSubject = new BehaviorSubject(defaultBpjsClaimSubmissionEntities);
		cashReceiptModelsBehaviorSubject = new BehaviorSubject(defaultCashReceiptEntities);
		informedConsentModelsBehaviorSubject = new BehaviorSubject(defaultInformedConsentEntities);
		patientCaseHistoryModelsBehaviorSubject = new BehaviorSubject(defaultPatientCaseHistoryEntities);
		patientConsentModelsBehaviorSubject = new BehaviorSubject(defaultPatientConsentEntities);
		patientContactInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientContactInfoEntities);
		patientDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientDetailEntities);
		patientDetailAddressModelsBehaviorSubject = new BehaviorSubject(defaultPatientDetailAddressEntities);
		patientEmergencyContactDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientEmergencyContactDetailEntities);
		patientEmploymentDetailModelsBehaviorSubject = new BehaviorSubject(defaultPatientEmploymentDetailEntities);
		patientGeneralInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientGeneralInfoEntities);
		patientPaymentSelfPayingModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentSelfPayingEntities);
		patientPaymentBPJSModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentBPJSEntities);
		patientPaymentInsuranceModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentInsuranceEntities);
		patientPaymentOthersModelsBehaviorSubject = new BehaviorSubject(defaultPatientPaymentOthersEntities);
		patientPersonalInfoModelsBehaviorSubject = new BehaviorSubject(defaultPatientPersonalInfoEntities);
		patientSupportingDocumentModelsBehaviorSubject = new BehaviorSubject(defaultPatientSupportingDocumentEntities);
		patientVisitModelsBehaviorSubject = new BehaviorSubject(defaultPatientVisitEntities);
		retailPharmacyModelsBehaviorSubject = new BehaviorSubject(defaultRetailPharmacyEntities);

		// selectors for target entity and its related entity
		cashRefundModelWithIdBehaviorSubject = new BehaviorSubject(cashRefundWithId);
		patientGeneralInfoWithIdBehaviorSubject = new BehaviorSubject(cashRefundWithId.patientGeneralInfo);

		spyOn(store, 'select')
			.withArgs(getCountCashRefundModels).and.returnValue(cashRefundCountBehaviorSubject)
			.withArgs(getCashRefundModelWithId, cashRefundWithId.id).and.returnValue(cashRefundModelWithIdBehaviorSubject)
			.withArgs(getCashRefundCollectionModels, jasmine.any(String)).and.returnValue(cashRefundModelsBehaviorSubject)
			.withArgs(getBpjsClaimSubmissionCollectionModels, jasmine.any(String)).and.returnValue(bpjsClaimSubmissionModelsBehaviorSubject)
			.withArgs(getCashReceiptCollectionModels, jasmine.any(String)).and.returnValue(cashReceiptModelsBehaviorSubject)
			.withArgs(getInformedConsentCollectionModels, jasmine.any(String)).and.returnValue(informedConsentModelsBehaviorSubject)
			.withArgs(getPatientCaseHistoryCollectionModels, jasmine.any(String)).and.returnValue(patientCaseHistoryModelsBehaviorSubject)
			.withArgs(getPatientConsentCollectionModels, jasmine.any(String)).and.returnValue(patientConsentModelsBehaviorSubject)
			.withArgs(getPatientContactInfoCollectionModels, jasmine.any(String)).and.returnValue(patientContactInfoModelsBehaviorSubject)
			.withArgs(getPatientDetailCollectionModels, jasmine.any(String)).and.returnValue(patientDetailModelsBehaviorSubject)
			.withArgs(getPatientDetailAddressCollectionModels, jasmine.any(String)).and.returnValue(patientDetailAddressModelsBehaviorSubject)
			.withArgs(getPatientEmergencyContactDetailCollectionModels, jasmine.any(String)).and.returnValue(patientEmergencyContactDetailModelsBehaviorSubject)
			.withArgs(getPatientEmploymentDetailCollectionModels, jasmine.any(String)).and.returnValue(patientEmploymentDetailModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoCollectionModels, jasmine.any(String)).and.returnValue(patientGeneralInfoModelsBehaviorSubject)
			.withArgs(getPatientPaymentSelfPayingCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentSelfPayingModelsBehaviorSubject)
			.withArgs(getPatientPaymentBPJSCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentBPJSModelsBehaviorSubject)
			.withArgs(getPatientPaymentInsuranceCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentInsuranceModelsBehaviorSubject)
			.withArgs(getPatientPaymentOthersCollectionModels, jasmine.any(String)).and.returnValue(patientPaymentOthersModelsBehaviorSubject)
			.withArgs(getPatientPersonalInfoCollectionModels, jasmine.any(String)).and.returnValue(patientPersonalInfoModelsBehaviorSubject)
			.withArgs(getPatientSupportingDocumentCollectionModels, jasmine.any(String)).and.returnValue(patientSupportingDocumentModelsBehaviorSubject)
			.withArgs(getPatientVisitCollectionModels, jasmine.any(String)).and.returnValue(patientVisitModelsBehaviorSubject)
			.withArgs(getRetailPharmacyCollectionModels, jasmine.any(String)).and.returnValue(retailPharmacyModelsBehaviorSubject)
			.withArgs(getPatientGeneralInfoModelWithId, cashRefundWithId.patientGeneralInfoId).and.returnValue(patientGeneralInfoWithIdBehaviorSubject)
			.withArgs(getRouterState).and.returnValue(routerStateBehaviorSubject);
	}

	beforeEach(waitForAsync (() => {

		const activatedRouteStub = new ActivatedRouteStub();

		TestBed.configureTestingModule({
			imports: [
				HttpClientTestingModule,
				CashRefundCrudModule,
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

			fixture = TestBed.createComponent(CashRefundCrudEditComponent);
			component = fixture.debugElement.componentInstance;
			component.ngOnInit();
			component.targetModel = new CashRefundModel();
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
	it ('Renders the Cash Refund CRUD Edit Component', () => {
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
	* Checks that the status of the add model button matches the multi entity status for the Patient General Info relation.
	*
	* The button should only exist if patientGeneralInfoMultiCrudActive is true
	*/
	it ('Renders Patient General Info Add Entity button in create mode', fakeAsync(() => {
		const patientGeneralInfoButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// For this test we don't need to interact with the button, as we are looking to prove that it exists and is present on the page
		// prepending the element with `!!` will turn the object into a boolean which is true if the element exists and false otherwise
		// If multi crud is off for this entity, then we expect the button to not exist, so we can check for equality with the MultiCrudActive attribute
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);
	}));


	it ('Adds a new entity to the page when clicking button to add new Patient General Info', fakeAsync(() => {
		const patientGeneralInfoButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);

		if (component.patientGeneralInfoMultiCrudActive) {
			// After clicking the add entity button, we will expect that the number of these buttons increases
			// We store this value now so that we can access it following interaction with the component
			const initialPatientGeneralInfoRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model')).length;

			patientGeneralInfoButton.nativeElement.click();
			fixture.detectChanges();

			const actualPatientGeneralInfoRemoveButtonCount = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model')).length;

			expect(actualPatientGeneralInfoRemoveButtonCount).toEqual(initialPatientGeneralInfoRemoveButtonCount + 1);
		}
	}));

	it ('Removes an additional entity from the page when clicking remove Patient General Info button', () => {
		const patientGeneralInfoButton: DebugElement = fixture.debugElement
				.queryAll(By.css('button.btn__add-entity'))
				.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);

		if (component.patientGeneralInfoMultiCrudActive) {
			// This test is examining whether clicking the remove button will remove an additional entity.
			// By default there will be no remove buttons, so first we need to add an entity so we can test removal
			patientGeneralInfoButton.nativeElement.click();
			fixture.detectChanges();

			// create an array of elements here as opposed to just getting the length (like in previous tests)
			// as we need to interact with the button in this test
			const initialPatientGeneralInfoRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model'));

			// As we have already tested that clicking the add button adds the element, we know there will be at lease one button here to click
			initialPatientGeneralInfoRemoveButtons[0].nativeElement.click();
			fixture.detectChanges();

			const actualPatientGeneralInfoRemoveButtons = fixture.debugElement
					.queryAll(By.css('button.btn__remove-entity'))
					.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model'));

			expect(actualPatientGeneralInfoRemoveButtons.length).toEqual(initialPatientGeneralInfoRemoveButtons.length - 1);
		}
	});

	it ('should disable the add Patient General Info button when one has already been added', () => {

		const patientGeneralInfoButton: DebugElement = fixture.debugElement
		.queryAll(By.css('button.btn__add-entity'))
		.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

		// Any expectations beyond this will only be run if multi crud is active for this entity
		// We can't run the test conditionally as the value we need to check by is set asyncronously during setup
		// We also don't want tests without any conditions, so adding this check here was deemed to be the cleanest option for now
		expect(!!patientGeneralInfoButton).toEqual(component.patientGeneralInfoMultiCrudActive);

		if (component.patientGeneralInfoMultiCrudActive) {
			patientGeneralInfoButton.nativeElement.click();
			fixture.detectChanges();

			const updatedpatientGeneralInfoButton: DebugElement = fixture.debugElement
					.queryAll(By.css('button.btn__add-entity'))
					.find(element => element.nativeElement.textContent.includes('Add New ' + component.patientGeneralInfoDisplayName + ' to Model'));

			expect(updatedpatientGeneralInfoButton.nativeElement.disabled).toBe(true);
		}
	});

	it ('renders related Patient General Info entities from model when loading in edit mode', () => {
		component.targetModel = cashRefundWithId;
		component.targetModelId = cashRefundWithId.id;
		component.tileMode = CrudTileMode.Edit;
		component.ngOnInit();
		component.createReactiveForm();
		component.multiCrudFetchAdditionalEntities();
		fixture.detectChanges();

		if (component.patientGeneralInfoMultiCrudActive) {
			// As there is always one remove button per additional entity, running a test against the number of remove buttons is a simple
			// and reliable method to determine how many entities of the given type are present in the crud page
			const patientGeneralInfoRemoveButtonCount = fixture.debugElement
				.queryAll(By.css('button.btn__remove-entity'))
				.filter(element => element.nativeElement.textContent.includes('Remove ' + component.patientGeneralInfoDisplayName + ' from Model')).length;

			expect(patientGeneralInfoRemoveButtonCount).toEqual(1);
		}
	});

});
