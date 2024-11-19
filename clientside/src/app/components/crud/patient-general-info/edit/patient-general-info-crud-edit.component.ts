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

import {Component, EventEmitter, Input, OnChanges, OnInit, OnDestroy, Output, SimpleChanges} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {Observable, Subject, Subscription} from 'rxjs';
import { ActivatedRoute, NavigationExtras } from '@angular/router';
import {debounceTime, distinctUntilChanged, map, filter} from 'rxjs/operators';
import {Store, Action as NgRxAction} from '@ngrx/store';
import * as routingAction from 'src/app/lib/routing/routing.action';
import {Group, ModelProperty, ModelRelation} from 'src/app/lib/models/abstract.model';
import * as modelAction from 'src/app/models/patientGeneralInfo/patient_general_info.model.action';
import {PatientGeneralInfoModelState, PatientGeneralInfoModelAudit} from 'src/app/models/patientGeneralInfo/patient_general_info.model.state';
import {PatientGeneralInfoModel} from 'src/app/models/patientGeneralInfo/patient_general_info.model';
import {
	getPatientGeneralInfoModelAuditsByEntityId,
	getPatientGeneralInfoModelWithId,
	getCountPatientGeneralInfoModels,
} from 'src/app/models/patientGeneralInfo/patient_general_info.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsClaimSubmissionModel} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model';
import * as bpjsClaimSubmissionModelAction from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.action';
import {
	getBpjsClaimSubmissionCollectionModels, getBpjsClaimSubmissionModelWithId,
} from 'src/app/models/bpjsClaimSubmission/bpjs_claim_submission.model.selector';
import {CashReceiptModel} from 'src/app/models/cashReceipt/cash_receipt.model';
import * as cashReceiptModelAction from 'src/app/models/cashReceipt/cash_receipt.model.action';
import {
	getCashReceiptCollectionModels, getCashReceiptModelWithId,
} from 'src/app/models/cashReceipt/cash_receipt.model.selector';
import {CashRefundModel} from 'src/app/models/cashRefund/cash_refund.model';
import * as cashRefundModelAction from 'src/app/models/cashRefund/cash_refund.model.action';
import {
	getCashRefundCollectionModels, getCashRefundModelWithId,
} from 'src/app/models/cashRefund/cash_refund.model.selector';
import {InformedConsentModel} from 'src/app/models/informedConsent/informed_consent.model';
import * as informedConsentModelAction from 'src/app/models/informedConsent/informed_consent.model.action';
import {
	getInformedConsentCollectionModels, getInformedConsentModelWithId,
} from 'src/app/models/informedConsent/informed_consent.model.selector';
import {PatientCaseHistoryModel} from 'src/app/models/patientCaseHistory/patient_case_history.model';
import * as patientCaseHistoryModelAction from 'src/app/models/patientCaseHistory/patient_case_history.model.action';
import {
	getPatientCaseHistoryCollectionModels, getPatientCaseHistoryModelWithId,
} from 'src/app/models/patientCaseHistory/patient_case_history.model.selector';
import {PatientConsentModel} from 'src/app/models/patientConsent/patient_consent.model';
import * as patientConsentModelAction from 'src/app/models/patientConsent/patient_consent.model.action';
import {
	getPatientConsentCollectionModels, getPatientConsentModelWithId,
} from 'src/app/models/patientConsent/patient_consent.model.selector';
import {PatientContactInfoModel} from 'src/app/models/patientContactInfo/patient_contact_info.model';
import * as patientContactInfoModelAction from 'src/app/models/patientContactInfo/patient_contact_info.model.action';
import {
	getPatientContactInfoCollectionModels, getPatientContactInfoModelWithId,
} from 'src/app/models/patientContactInfo/patient_contact_info.model.selector';
import {PatientDetailModel} from 'src/app/models/patientDetail/patient_detail.model';
import * as patientDetailModelAction from 'src/app/models/patientDetail/patient_detail.model.action';
import {
	getPatientDetailCollectionModels, getPatientDetailModelWithId,
} from 'src/app/models/patientDetail/patient_detail.model.selector';
import {PatientDetailAddressModel} from 'src/app/models/patientDetailAddress/patient_detail_address.model';
import * as patientDetailAddressModelAction from 'src/app/models/patientDetailAddress/patient_detail_address.model.action';
import {
	getPatientDetailAddressCollectionModels, getPatientDetailAddressModelWithId,
} from 'src/app/models/patientDetailAddress/patient_detail_address.model.selector';
import {PatientEmergencyContactDetailModel} from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model';
import * as patientEmergencyContactDetailModelAction from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.action';
import {
	getPatientEmergencyContactDetailCollectionModels, getPatientEmergencyContactDetailModelWithId,
} from 'src/app/models/patientEmergencyContactDetail/patient_emergency_contact_detail.model.selector';
import {PatientEmploymentDetailModel} from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model';
import * as patientEmploymentDetailModelAction from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.action';
import {
	getPatientEmploymentDetailCollectionModels, getPatientEmploymentDetailModelWithId,
} from 'src/app/models/patientEmploymentDetail/patient_employment_detail.model.selector';
import {PatientPaymentSelfPayingModel} from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model';
import * as patientPaymentSelfPayingModelAction from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.action';
import {
	getPatientPaymentSelfPayingCollectionModels, getPatientPaymentSelfPayingModelWithId,
} from 'src/app/models/patientPaymentSelfPaying/patient_payment_self_paying.model.selector';
import {PatientPaymentBPJSModel} from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model';
import * as patientPaymentBPJSModelAction from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.action';
import {
	getPatientPaymentBPJSCollectionModels, getPatientPaymentBPJSModelWithId,
} from 'src/app/models/patientPaymentBPJS/patient_payment_bpjs.model.selector';
import {PatientPaymentInsuranceModel} from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model';
import * as patientPaymentInsuranceModelAction from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.action';
import {
	getPatientPaymentInsuranceCollectionModels, getPatientPaymentInsuranceModelWithId,
} from 'src/app/models/patientPaymentInsurance/patient_payment_insurance.model.selector';
import {PatientPaymentOthersModel} from 'src/app/models/patientPaymentOthers/patient_payment_others.model';
import * as patientPaymentOthersModelAction from 'src/app/models/patientPaymentOthers/patient_payment_others.model.action';
import {
	getPatientPaymentOthersCollectionModels, getPatientPaymentOthersModelWithId,
} from 'src/app/models/patientPaymentOthers/patient_payment_others.model.selector';
import {PatientPersonalInfoModel} from 'src/app/models/patientPersonalInfo/patient_personal_info.model';
import * as patientPersonalInfoModelAction from 'src/app/models/patientPersonalInfo/patient_personal_info.model.action';
import {
	getPatientPersonalInfoCollectionModels, getPatientPersonalInfoModelWithId,
} from 'src/app/models/patientPersonalInfo/patient_personal_info.model.selector';
import {PatientSupportingDocumentModel} from 'src/app/models/patientSupportingDocument/patient_supporting_document.model';
import * as patientSupportingDocumentModelAction from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.action';
import {
	getPatientSupportingDocumentCollectionModels, getPatientSupportingDocumentModelWithId,
} from 'src/app/models/patientSupportingDocument/patient_supporting_document.model.selector';
import {PatientVisitModel} from 'src/app/models/patientVisit/patient_visit.model';
import * as patientVisitModelAction from 'src/app/models/patientVisit/patient_visit.model.action';
import {
	getPatientVisitCollectionModels, getPatientVisitModelWithId,
} from 'src/app/models/patientVisit/patient_visit.model.selector';
import {RetailPharmacyModel} from 'src/app/models/retailPharmacy/retail_pharmacy.model';
import * as retailPharmacyModelAction from 'src/app/models/retailPharmacy/retail_pharmacy.model.action';
import {
	getRetailPharmacyCollectionModels, getRetailPharmacyModelWithId,
} from 'src/app/models/retailPharmacy/retail_pharmacy.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../patient-general-info-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-patient-general-info-crud-edit',
	templateUrl: './patient-general-info-crud-edit.component.html',
	styleUrls: [
		'./patient-general-info-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class PatientGeneralInfoCrudEditComponent
		// % protected region % [Add any additional interfaces to implement here] off begin
		implements OnInit, OnChanges, OnDestroy
		// % protected region % [Add any additional interfaces to implement here] end
{

	/************************************************************************
	 *	   _____             __ _         ______ _      _     _
	 *  / ____|           / _(_)       |  ____(_)    | |   | |
	 * | |     ___  _ __ | |_ _  __ _  | |__   _  ___| | __| |___
	 * | |    / _ \| '_ \|  _| |/ _` | |  __| | |/ _ \ |/ _` / __|
	 * | |___| (_) | | | | | | | (_| | | |    | |  __/ | (_| \__ \
	 *  \_____\___/|_| |_|_| |_|\__, | |_|    |_|\___|_|\__,_|___/
	 *                           __/ |
	 *                          |___/
	 ************************************************************************/
	/**
	 * Whether route component
	 */
	@Input()
	singlePageComponent = false;

	/**
	 * Whether in create/edit/view mode
	 * Only used when singlePageComponent is turned on
	 * Routing will overwrite this according to the url path
	 */
	@Input()
	tileMode: CrudTileMode = CrudTileMode.Create;

	/**
	 * Id of entity to display
	 * Only used when singlePageComponent is turned on
	 */
	@Input()
	targetModelId: string;

	/**
	 * How many items are included in this page.
	 */
	@Input()
	pageSize: number = 10;

	// % protected region % [Change your collection id if required here] off begin
	/**
	 * The collection id used in the store
	 * Default to be the uuid of the tile, you could change this to custom id you want to share in different component
	 *
	 */
	@Input()
	collectionId: string = 'a1e2ccec-5d5c-4184-847d-2706d3a5d22d';
	// % protected region % [Change your collection id if required here] end

	/**
	 * Event emitter when user clicking button to change mode of tile
	 */
	@Output()
	tileModeChange: EventEmitter<{tileMode: CrudTileMode, payload?: any}> = new EventEmitter();

	/**
	 * Whether componet is view only
	 */
	get isViewOnly(): boolean {
		return this.tileMode === CrudTileMode.View;
	}

	/**
	 * Entity audits to be fetched from the server.
	 */
	patientGeneralInfoAudits$: Observable<PatientGeneralInfoModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Contact Information here] off begin
	patientContactInformationMultiCrudActive: boolean = false;
	patientContactInformationDisplayName = 'Patient Contact Information';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Contact Information here] end
	patientContactInformationOppositeRelation = 'patientGeneralInformation';
	patientContactInformationRelations: ModelRelation[] = this.patientContactInformationMultiCrudActive ? PatientContactInfoModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientContactInformationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Detail Address here] off begin
	patientDetailAddressMultiCrudActive: boolean = false;
	patientDetailAddressDisplayName = 'Patient Detail Address';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Detail Address here] end
	patientDetailAddressOppositeRelation = 'patientGeneralInformation';
	patientDetailAddressRelations: ModelRelation[] = this.patientDetailAddressMultiCrudActive ? PatientDetailAddressModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientDetailAddressOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Detail here] off begin
	patientDetailMultiCrudActive: boolean = false;
	patientDetailDisplayName = 'Patient Detail';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Detail here] end
	patientDetailOppositeRelation = 'patientGeneralInformation';
	patientDetailRelations: ModelRelation[] = this.patientDetailMultiCrudActive ? PatientDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientDetailOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Emergency Contact Detail here] off begin
	patientEmergencyContactDetailMultiCrudActive: boolean = false;
	patientEmergencyContactDetailDisplayName = 'Patient Emergency Contact Detail';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Emergency Contact Detail here] end
	patientEmergencyContactDetailOppositeRelation = 'patientGeneralInformation';
	patientEmergencyContactDetailRelations: ModelRelation[] = this.patientEmergencyContactDetailMultiCrudActive ? PatientEmergencyContactDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientEmergencyContactDetailOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Patient Employment Detail  here] off begin
	patientEmploymentDetailMultiCrudActive: boolean = false;
	patientEmploymentDetailDisplayName = 'Patient Employment Detail ';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Patient Employment Detail  here] end
	patientEmploymentDetailOppositeRelation = 'patientGeneralInfo';
	patientEmploymentDetailRelations: ModelRelation[] = this.patientEmploymentDetailMultiCrudActive ? PatientEmploymentDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientEmploymentDetailOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Patient Payment BPJS here] off begin
	patientPaymentBPJSMultiCrudActive: boolean = false;
	patientPaymentBPJSDisplayName = 'Patient Payment BPJS';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Patient Payment BPJS here] end
	patientPaymentBPJSOppositeRelation = 'patientGeneralInfo';
	patientPaymentBPJSRelations: ModelRelation[] = this.patientPaymentBPJSMultiCrudActive ? PatientPaymentBPJSModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientPaymentBPJSOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Payment Type Insurance here] off begin
	patientPaymentTypeInsuranceMultiCrudActive: boolean = false;
	patientPaymentTypeInsuranceDisplayName = 'Patient Payment Type Insurance';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Payment Type Insurance here] end
	patientPaymentTypeInsuranceOppositeRelation = 'patientGeneralInformation';
	patientPaymentTypeInsuranceRelations: ModelRelation[] = this.patientPaymentTypeInsuranceMultiCrudActive ? PatientPaymentInsuranceModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientPaymentTypeInsuranceOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Payment Type Others here] off begin
	patientPaymentTypeOthersMultiCrudActive: boolean = false;
	patientPaymentTypeOthersDisplayName = 'Patient Payment Type Others';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Payment Type Others here] end
	patientPaymentTypeOthersOppositeRelation = 'patientGeneralInformation';
	patientPaymentTypeOthersRelations: ModelRelation[] = this.patientPaymentTypeOthersMultiCrudActive ? PatientPaymentOthersModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientPaymentTypeOthersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Personal Information here] off begin
	patientPersonalInformationMultiCrudActive: boolean = false;
	patientPersonalInformationDisplayName = 'Patient Personal Information';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Personal Information here] end
	patientPersonalInformationOppositeRelation = 'patientGeneralInformation';
	patientPersonalInformationRelations: ModelRelation[] = this.patientPersonalInformationMultiCrudActive ? PatientPersonalInfoModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientPersonalInformationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Self Paying here] off begin
	patientSelfPayingMultiCrudActive: boolean = false;
	patientSelfPayingDisplayName = 'Patient Self Paying';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Self Paying here] end
	patientSelfPayingOppositeRelation = 'patientGeneralInformation';
	patientSelfPayingRelations: ModelRelation[] = this.patientSelfPayingMultiCrudActive ? PatientPaymentSelfPayingModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientSelfPayingOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and BPJS Claim Submissions here] off begin
	bpjsClaimSubmissionsMultiCrudActive: boolean = false;
	bpjsClaimSubmissionsDisplayName = 'BPJS Claim Submissions';
	bpjsClaimSubmissionsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and BPJS Claim Submissions here] end
	bpjsClaimSubmissionsOppositeRelation = 'patientGeneralInfo';
	bpjsClaimSubmissionsRelations: ModelRelation[] = this.bpjsClaimSubmissionsMultiCrudActive ? BpjsClaimSubmissionModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsClaimSubmissionsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Cash Refunds here] off begin
	cashRefundsMultiCrudActive: boolean = false;
	cashRefundsDisplayName = 'Cash Refunds';
	cashRefundsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Cash Refunds here] end
	cashRefundsOppositeRelation = 'patientGeneralInfo';
	cashRefundsRelations: ModelRelation[] = this.cashRefundsMultiCrudActive ? CashRefundModel.getRelations()
		.map(relation => {
			if (relation.id === this.cashRefundsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Informed Consents here] off begin
	informedConsentsMultiCrudActive: boolean = false;
	informedConsentsDisplayName = 'Informed Consents';
	informedConsentsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Informed Consents here] end
	informedConsentsOppositeRelation = 'patientGeneralInfo';
	informedConsentsRelations: ModelRelation[] = this.informedConsentsMultiCrudActive ? InformedConsentModel.getRelations()
		.map(relation => {
			if (relation.id === this.informedConsentsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient and Invoice Receipts here] off begin
	invoiceReceiptsMultiCrudActive: boolean = false;
	invoiceReceiptsDisplayName = 'Invoice Receipts';
	invoiceReceiptsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient and Invoice Receipts here] end
	invoiceReceiptsOppositeRelation = 'patient';
	invoiceReceiptsRelations: ModelRelation[] = this.invoiceReceiptsMultiCrudActive ? CashReceiptModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoiceReceiptsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Case Histories here] off begin
	patientCaseHistoriesMultiCrudActive: boolean = false;
	patientCaseHistoriesDisplayName = 'Patient Case Histories';
	patientCaseHistoriesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Case Histories here] end
	patientCaseHistoriesOppositeRelation = 'patientGeneralInformation';
	patientCaseHistoriesRelations: ModelRelation[] = this.patientCaseHistoriesMultiCrudActive ? PatientCaseHistoryModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientCaseHistoriesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Patient Consents here] off begin
	patientConsentsMultiCrudActive: boolean = false;
	patientConsentsDisplayName = 'Patient Consents';
	patientConsentsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Patient Consents here] end
	patientConsentsOppositeRelation = 'patientGeneralInfo';
	patientConsentsRelations: ModelRelation[] = this.patientConsentsMultiCrudActive ? PatientConsentModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientConsentsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Finalize Profiles here] off begin
	patientFinalizeProfilesMultiCrudActive: boolean = false;
	patientFinalizeProfilesDisplayName = 'Patient Finalize Profiles';
	patientFinalizeProfilesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Information and Patient Finalize Profiles here] end
	patientFinalizeProfilesOppositeRelation = 'patientGeneralInformation';
	patientFinalizeProfilesRelations: ModelRelation[] = this.patientFinalizeProfilesMultiCrudActive ? PatientSupportingDocumentModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientFinalizeProfilesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Retail Pharmacies here] off begin
	retailPharmaciesMultiCrudActive: boolean = false;
	retailPharmaciesDisplayName = 'Retail Pharmacies';
	retailPharmaciesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient General Info and Retail Pharmacies here] end
	retailPharmaciesOppositeRelation = 'patientGeneralInfo';
	retailPharmaciesRelations: ModelRelation[] = this.retailPharmaciesMultiCrudActive ? RetailPharmacyModel.getRelations()
		.map(relation => {
			if (relation.id === this.retailPharmaciesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient and Visits here] off begin
	visitsMultiCrudActive: boolean = false;
	visitsDisplayName = 'Visits';
	visitsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient and Visits here] end
	visitsOppositeRelation = 'patient';
	visitsRelations: ModelRelation[] = this.visitsMultiCrudActive ? PatientVisitModel.getRelations()
		.map(relation => {
			if (relation.id === this.visitsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = PatientGeneralInfoModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = PatientGeneralInfoModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = PatientGeneralInfoModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'patientContactInformation' && this.patientContactInformationMultiCrudActive) {
					exp.fields = PatientContactInfoModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientDetailAddress' && this.patientDetailAddressMultiCrudActive) {
					exp.fields = PatientDetailAddressModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientDetail' && this.patientDetailMultiCrudActive) {
					exp.fields = PatientDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientEmergencyContactDetail' && this.patientEmergencyContactDetailMultiCrudActive) {
					exp.fields = PatientEmergencyContactDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientEmploymentDetail' && this.patientEmploymentDetailMultiCrudActive) {
					exp.fields = PatientEmploymentDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientPaymentBPJS' && this.patientPaymentBPJSMultiCrudActive) {
					exp.fields = PatientPaymentBPJSModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientPaymentTypeInsurance' && this.patientPaymentTypeInsuranceMultiCrudActive) {
					exp.fields = PatientPaymentInsuranceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientPaymentTypeOthers' && this.patientPaymentTypeOthersMultiCrudActive) {
					exp.fields = PatientPaymentOthersModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientPersonalInformation' && this.patientPersonalInformationMultiCrudActive) {
					exp.fields = PatientPersonalInfoModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientSelfPaying' && this.patientSelfPayingMultiCrudActive) {
					exp.fields = PatientPaymentSelfPayingModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsClaimSubmissions' && this.bpjsClaimSubmissionsMultiCrudActive) {
					exp.fields = BpjsClaimSubmissionModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'cashRefunds' && this.cashRefundsMultiCrudActive) {
					exp.fields = CashRefundModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'informedConsents' && this.informedConsentsMultiCrudActive) {
					exp.fields = InformedConsentModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoiceReceipts' && this.invoiceReceiptsMultiCrudActive) {
					exp.fields = CashReceiptModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientCaseHistories' && this.patientCaseHistoriesMultiCrudActive) {
					exp.fields = PatientCaseHistoryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientConsents' && this.patientConsentsMultiCrudActive) {
					exp.fields = PatientConsentModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientFinalizeProfiles' && this.patientFinalizeProfilesMultiCrudActive) {
					exp.fields = PatientSupportingDocumentModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'retailPharmacies' && this.retailPharmaciesMultiCrudActive) {
					exp.fields = RetailPharmacyModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'visits' && this.visitsMultiCrudActive) {
					exp.fields = PatientVisitModel.getProps().map(prop => {
						return prop.name;
					});
				}

				return exp;
			}
		);
		return expands;
	}
	// % protected region % [Change your default expands if required here] end

	/**
	 * The model to be created or edited depending on what the model currently is.
	 */
	targetModel: PatientGeneralInfoModel;

	/**
	 * The form group created from the target model
	 */
	modelFormGroup: FormGroup;

	/**
	 * The current router state when this page is displayed.
	 */
	routerState: RouterState;

	/**
	 * Unsubscribe from this subscription when the crud component is destroyed
	 */
	routerStateSubscription$: Subscription;

	/**
	 * The Names of the buttons to be passed to the crud edit page for adding additional entities to the multi crud view.
	 * This requires a list of strings, where each string will become a button which sends an event back to onMultiEntityAction()
	 */
	defaultMultiEntityButtons: {name: string, many: boolean}[] = [];


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private readonly store: Store<{ model: PatientGeneralInfoModelState }>,
		private readonly routerStore: Store<{ router: RouterState }>,
		private readonly activatedRoute: ActivatedRoute,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnChanges(changes: SimpleChanges) {
		// % protected region % [Add any additional ngOnChanges logic before the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic before the main body here] end

		// % protected region % [Customise the ngOnChanges main body here] off begin
		if (changes.hasOwnProperty('tileMode') || changes.hasOwnProperty('targetModelId')) {
			this.initializeTargetModel();
		}
		// % protected region % [Customise the ngOnChanges main body here] end

		// % protected region % [Add any additional ngOnChanges logic after the main body here] off begin
		// % protected region % [Add any additional ngOnChanges logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnInit() {
		// % protected region % [Add any additional ngOnInit logic before the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before the main body here] end

		this.initialiseMultiEntityCollections();

		this.routerStateSubscription$ = this.routerStore.select(getRouterState).subscribe(routerState => {
				this.routerState = routerState;
				this.initializeTargetModel();
			}
		);

		let firstTime = true; // ensures that the user isn't instantly navigated back to the list page
		/**
		 * Tile Mode Change will not be triggered until the creation action has been dispatched and completed
		 * Subscribing in ngOnInit ensures that a count models action can be passed as an afterwards action, so the
		 * subscribed code will not be triggered until after the creation has been completed
		 */
		this.creationNavigationSubscription$.add(this.store.select(getCountPatientGeneralInfoModels).subscribe(count => {
			if (this.singlePageComponent && !firstTime) {
				this.triggerTileModeChange(CrudTileMode.List);
			}

			firstTime = false;
		}));

		// % protected region % [Add any additional ngOnInit logic after the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnDestroy() {
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic before the main body here] end

		if (this.routerStateSubscription$) {
			this.routerStateSubscription$.unsubscribe();
		}

		if (this.creationNavigationSubscription$) {
			this.creationNavigationSubscription$.unsubscribe();
		}

		// % protected region % [Add any additional ngOnDestroy logic after the main body here] off begin
		// % protected region % [Add any additional ngOnDestroy logic after the main body here] end
	}

	/**
	 * Initialize target model when input fields changed or router changed
	 */
	private initializeTargetModel() {
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic before the main body here] end

		if (!this.singlePageComponent) {
			this.initWithRouting();
		}

		// When tile mode is not defiend, reutrn directly without fetching data
		if (this.tileMode === undefined) {
			return;
		}

		this.resetPropsAndRels();
		this.prepareReferenceCollections();
		this.createReactiveForm();

		if (this.tileMode === CrudTileMode.Edit || this.tileMode === CrudTileMode.View) {
			// % protected region % [Add additional processing for View and Edit mode before the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode before the main body here] end

			this.fetchEntity();

			// % protected region % [Add additional processing for View and Edit mode after the main body here] off begin
			// % protected region % [Add additional processing for View and Edit mode after the main body here] end
		} else if (this.tileMode === CrudTileMode.Create) {
			// % protected region % [Add additional processing for Create mode before the main body here] off begin
			// % protected region % [Add additional processing for Create mode before the main body here] end

			this.targetModel = new PatientGeneralInfoModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.patientGeneralInfoAudits$ = this.store.select(getPatientGeneralInfoModelAuditsByEntityId, this.targetModelId);
		}

		// % protected region % [Add any additional initializeTargetModel logic after the main body here] off begin
		// % protected region % [Add any additional initializeTargetModel logic after the main body here] end
	}

	/**
	 * Function to initialize the component fields according to the routing
	 * Method only be invoked when routing is enabled
	 */
	private initWithRouting() {
		// % protected region % [Override the initWithRouting method body here] off begin
		this.targetModelId = this.routerState.params.id;
		if (this.routerState.urls.includes('view')) {
			this.tileMode = CrudTileMode.View;
		} else if (this.routerState.urls.includes('edit')) {
			this.tileMode = CrudTileMode.Edit;
		} else if (this.routerState.urls.includes('create')) {
			this.tileMode = CrudTileMode.Create;
		} else {
			this.tileMode = undefined;
		}
		// % protected region % [Override the initWithRouting method body here] end
	}

	/**
	 * Initialize and dispatch event to fetch data from serverside
	 */
	private fetchEntity() {
		const stateConfig: PassableStateConfig<PatientGeneralInfoModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.PatientGeneralInfoAction(
			modelAction.PatientGeneralInfoModelActionTypes.FETCH_PATIENT_GENERAL_INFO,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getPatientGeneralInfoModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new PatientGeneralInfoModel(model);
			model.syncRelations();

			this.targetModel = model;
			if (this.targetModel) {
				this.modelFormGroup.patchValue(this.targetModel);
			}

			this.multiCrudFetchAdditionalEntities();

			// % protected region % [Add additional actions after setting targetModel here] off begin
			// % protected region % [Add additional actions after setting targetModel here] end
		}));
	}

	/**
	 * This method iterates through all of the relations in the relations array and performs logic to fetch all of the entities to be shown
	 * in the dropdowns. This method does not need to be modified if you add additional entities to your crud list, as it will process all
	 * relations given to it
	 */
	private prepareReferenceCollections() {
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here before the main logic of prepareReferenceCollections] end

		let updatedRelationsArray: ModelRelation[] = [];

		this.modelRelations.forEach(relation => {
			updatedRelationsArray.push(this.prepareSingleReferenceCollection(relation));
		});

		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] off begin
		// % protected region % [Add any additional code here after the main logic of prepareReferenceCollections] end

		this.modelRelations = updatedRelationsArray;
	}

	/**
	 * Prepare the collection for a single Model Relation.  This method is called once for each relation in the modelRelations array,
	 * although there are use cases for processing other relations individually.  Calling prepareReferenceCollections within a subscription
	 * is not recommended, as it will cause a feedback loop which will require a reload to fix.  Therefore, abstracting this logic out allows
	 * for preparing reference collections for multi entity crud for 1:M relations.
	 *
	 * @param relation The relation to prepare the collection for
	 * @returns the same relation, with some additional parameters added following the creation of the collection
	 */
	prepareSingleReferenceCollection(relation: ModelRelation, uniqueCollectionId?: string) {
		let referenceRequirements: PrepareReferenceRequirements;
		referenceRequirements = fetchPrepareReferenceRequirements(relation.entityName);
		relation.stateConfig = {
			pageIndex: 0,
			pageSize: this.pageSize,
			collectionId: uniqueCollectionId ? uniqueCollectionId : this.collectionId
		} as PassableStateConfig<any>;

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.initCollectionAction,
			relation.stateConfig
		));

		this.addSearchFunction(relation,
				referenceRequirements.collectionModelsSelector,
				referenceRequirements.baseAction,
				referenceRequirements.fetchWithQueryAction);

		this.store.dispatch(new referenceRequirements.baseAction(
			referenceRequirements.fetchAllAction,
			relation.stateConfig
		));

		return relation;
	}

	/**
	 * Add the search function for each of the relations.
	 *
	 */
	private addSearchFunction(modelRelation: ModelRelation, modelSelector: any, action: new (...args: any[]) => NgRxAction, actionType: string) {
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code before the main logic of addSearchFunction here] end

		modelRelation.searchFunction = new Subject<string>();
		modelRelation.collection = this.store.select(modelSelector, this.collectionId);
		this.creationNavigationSubscription$.add(modelRelation.searchFunction.pipe(
			debounceTime(500),
			distinctUntilChanged(),
			filter(value => value != null)
		).subscribe(
			(term: string) => {
				modelRelation.stateConfig.queryParams = {
					pageSize: this.pageSize,
					pageIndex: 0,
					where: [
						[
							{
								path: modelRelation.displayName,
								operation: QueryOperation.CONTAINS,
								value: term
							}
						]
					]
				};

				// % protected region % [Add any additional logic to the search subscription before dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription before dispatch here] end

				this.store.dispatch(new action(
					actionType,
					modelRelation.stateConfig
				));

				// % protected region % [Add any additional logic to the search subscription after dispatch here] off begin
				// % protected region % [Add any additional logic to the search subscription after dispatch here] end
			}
		));

		// % protected region % [Add any additional code after the main logic of addSearchFunction here] off begin
		// % protected region % [Add any additional code after the main logic of addSearchFunction here] end
	}

	/**
	 * Chang tile mode based on action and whether using routing
	 */
	private triggerTileModeChange(tileMode: CrudTileMode, id?: string, other?: object) {
		if (this.singlePageComponent) {
			this.tileModeChange.emit({
				tileMode: tileMode,
				payload: {
					id: id,
					...other
				}
			});
		} else {
			let extras: NavigationExtras = {};


			const commands = [];

			commands.push(this.routerState.urls[0]);

			if (tileMode !== CrudTileMode.List) {
				commands.push('patient-general-info');
				commands.push(tileMode.toString());
			}

			if (id) {
				commands.push(id);
			}

			this.routerStore.dispatch(new routingAction.NavigateRoutingAction(commands, extras));
		}
	}

	/**
	 * Triggered when the user clicks on the "View History" button.
	 */
	onViewHistory() {
		// % protected region % [Add any additional onViewHistory logic before the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic before the main body here] end

		this.store.dispatch(new modelAction.PatientGeneralInfoAction(
			modelAction.PatientGeneralInfoModelActionTypes.FETCH_PATIENT_GENERAL_INFO_AUDITS_BY_ENTITY_ID,
			{
				targetModelId: this.targetModelId
			}
		));

		// % protected region % [Add any additional onViewHistory logic after the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic after the main body here] end
	}

	/**
	 * Triggered when the `Create` or `Save` button is clicked in the child create/edit view.
	 */
	onCreateOrSaveClicked(event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }) {
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic before the main body here] end

		this.targetModel = this.addAdditionalEntitiesToModel(this.targetModel, event);

		if (event.isCreate) {
			let stateConfig: PassableStateConfig<PatientGeneralInfoModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.patientContactInformationMultiCrudActive || this.patientDetailAddressMultiCrudActive || this.patientDetailMultiCrudActive || this.patientEmergencyContactDetailMultiCrudActive || this.patientEmploymentDetailMultiCrudActive || this.patientPaymentBPJSMultiCrudActive || this.patientPaymentTypeInsuranceMultiCrudActive || this.patientPaymentTypeOthersMultiCrudActive || this.patientPersonalInformationMultiCrudActive || this.patientSelfPayingMultiCrudActive || this.bpjsClaimSubmissionsMultiCrudActive || this.cashRefundsMultiCrudActive || this.informedConsentsMultiCrudActive || this.invoiceReceiptsMultiCrudActive || this.patientCaseHistoriesMultiCrudActive || this.patientConsentsMultiCrudActive || this.patientFinalizeProfilesMultiCrudActive || this.retailPharmaciesMultiCrudActive || this.visitsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the creation state config here] off begin
				// % protected region % [Add any additional attributes to the creation state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for single page creation here] off begin
					// % protected region % [Add any additional afterwards actions for single page creation here] end
					// Count the models to trigger the tile mode change, as the count will have changed after creation
					new modelAction.PatientGeneralInfoAction(
						modelAction.PatientGeneralInfoModelActionTypes.COUNT_PATIENT_GENERAL_INFOS,
						null
					)
				];
			} else {
				afterwardActions = [
					// % protected region % [Add any additional afterwards actions for creation here] off begin
					// % protected region % [Add any additional afterwards actions for creation here] end
					new routingAction.BackRoutingAction()
				];
			}

			// % protected region % [Add any additional logic before creating a new model here] off begin
			// % protected region % [Add any additional logic before creating a new model here] end

			this.store.dispatch(new modelAction.PatientGeneralInfoAction(
				modelAction.PatientGeneralInfoModelActionTypes.CREATE_PATIENT_GENERAL_INFO,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<PatientGeneralInfoModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.patientContactInformationMultiCrudActive || this.patientDetailAddressMultiCrudActive || this.patientDetailMultiCrudActive || this.patientEmergencyContactDetailMultiCrudActive || this.patientEmploymentDetailMultiCrudActive || this.patientPaymentBPJSMultiCrudActive || this.patientPaymentTypeInsuranceMultiCrudActive || this.patientPaymentTypeOthersMultiCrudActive || this.patientPersonalInformationMultiCrudActive || this.patientSelfPayingMultiCrudActive || this.bpjsClaimSubmissionsMultiCrudActive || this.cashRefundsMultiCrudActive || this.informedConsentsMultiCrudActive || this.invoiceReceiptsMultiCrudActive || this.patientCaseHistoriesMultiCrudActive || this.patientConsentsMultiCrudActive || this.patientFinalizeProfilesMultiCrudActive || this.retailPharmaciesMultiCrudActive || this.visitsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.PatientGeneralInfoAction(
					modelAction.PatientGeneralInfoModelActionTypes.FETCH_PATIENT_GENERAL_INFO,
					{
						targetModelId: this.targetModelId,
						queryParams: {
							expands: this.defaultExpands
						}
					}
				));
			} else {
				afterwardActions = [
					new routingAction.BackRoutingAction(),
					// % protected region % [Add any additional afterwards actions for updates here] off begin
					// % protected region % [Add any additional afterwards actions for updates here] end
				];
			}

			// % protected region % [Add any additional logic before update the current model here] off begin
			// % protected region % [Add any additional logic before update the current model here] end

			this.store.dispatch(new modelAction.PatientGeneralInfoAction(
				modelAction.PatientGeneralInfoModelActionTypes.UPDATE_PATIENT_GENERAL_INFO,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: PatientGeneralInfoModel = new PatientGeneralInfoModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getPatientGeneralInfoModelWithId, this.targetModelId).subscribe(model => {
					let differences = new PatientGeneralInfoModel(model).difference(updatedModel);

					// Object has been updated when differences is empty.
					// Differences excludes values such as references.  As these aren't visible on the list they do not need to be checked
					// When the user naivgates to a page which displays references, they will be fetched from the database with the correct values
					if (Object.keys(differences).length === 0) {
						this.triggerTileModeChange(CrudTileMode.List);
					}
				}));
			}
		}

		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCreateOrSaveClicked logic after the main body here] end
	}

	/**
	 * Removes form elements whose group id matches the group Id passed into the event, or adds a new
	 * group based on the entityName parameter
	 *
	 * @param event The event emitted from the base crud edit page
	 */
	onMultiEntityAction(event: { groupId: string, entityName: string, payload?: { [s: string]: any } }) {
		if (event.groupId) { // This path deletes the group with the specified id from the list
			this.modelProperties = this.modelProperties.filter(prop => {
				if (prop.group) {
					return prop.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});

			this.modelRelations = this.modelRelations.filter(relation => {
				if (relation.group) {
					return relation.group.id !== event.groupId;
				}

				// Groupless attributes should pass through no matter what, as they are not related to the additional entities
				return true;
			});
		} else {
			// This will add a new entity of the specified type to the list of props/relations
			if (event.entityName === this.patientContactInformationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientContactInfoModel.getProps(), this.patientContactInformationRelations, this.isViewOnly),
					new PatientContactInfoModel(),
					PatientContactInfoModel,
					this.patientContactInformationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientContactInformationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientDetailAddressDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientDetailAddressModel.getProps(), this.patientDetailAddressRelations, this.isViewOnly),
					new PatientDetailAddressModel(),
					PatientDetailAddressModel,
					this.patientDetailAddressDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientDetailAddressRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientDetailDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientDetailModel.getProps(), this.patientDetailRelations, this.isViewOnly),
					new PatientDetailModel(),
					PatientDetailModel,
					this.patientDetailDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientDetailRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientEmergencyContactDetailDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientEmergencyContactDetailModel.getProps(), this.patientEmergencyContactDetailRelations, this.isViewOnly),
					new PatientEmergencyContactDetailModel(),
					PatientEmergencyContactDetailModel,
					this.patientEmergencyContactDetailDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientEmergencyContactDetailRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientEmploymentDetailDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientEmploymentDetailModel.getProps(), this.patientEmploymentDetailRelations, this.isViewOnly),
					new PatientEmploymentDetailModel(),
					PatientEmploymentDetailModel,
					this.patientEmploymentDetailDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientEmploymentDetailRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientPaymentBPJSDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentBPJSModel.getProps(), this.patientPaymentBPJSRelations, this.isViewOnly),
					new PatientPaymentBPJSModel(),
					PatientPaymentBPJSModel,
					this.patientPaymentBPJSDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPaymentBPJSRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientPaymentTypeInsuranceDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentInsuranceModel.getProps(), this.patientPaymentTypeInsuranceRelations, this.isViewOnly),
					new PatientPaymentInsuranceModel(),
					PatientPaymentInsuranceModel,
					this.patientPaymentTypeInsuranceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPaymentTypeInsuranceRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientPaymentTypeOthersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentOthersModel.getProps(), this.patientPaymentTypeOthersRelations, this.isViewOnly),
					new PatientPaymentOthersModel(),
					PatientPaymentOthersModel,
					this.patientPaymentTypeOthersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPaymentTypeOthersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientPersonalInformationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPersonalInfoModel.getProps(), this.patientPersonalInformationRelations, this.isViewOnly),
					new PatientPersonalInfoModel(),
					PatientPersonalInfoModel,
					this.patientPersonalInformationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPersonalInformationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientSelfPayingDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentSelfPayingModel.getProps(), this.patientSelfPayingRelations, this.isViewOnly),
					new PatientPaymentSelfPayingModel(),
					PatientPaymentSelfPayingModel,
					this.patientSelfPayingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientSelfPayingRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsClaimSubmissionsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsClaimSubmissionModel.getProps(), this.bpjsClaimSubmissionsRelations, this.isViewOnly),
					new BpjsClaimSubmissionModel(),
					BpjsClaimSubmissionModel,
					this.bpjsClaimSubmissionsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsClaimSubmissionsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.cashRefundsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CashRefundModel.getProps(), this.cashRefundsRelations, this.isViewOnly),
					new CashRefundModel(),
					CashRefundModel,
					this.cashRefundsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.cashRefundsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.informedConsentsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InformedConsentModel.getProps(), this.informedConsentsRelations, this.isViewOnly),
					new InformedConsentModel(),
					InformedConsentModel,
					this.informedConsentsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.informedConsentsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoiceReceiptsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CashReceiptModel.getProps(), this.invoiceReceiptsRelations, this.isViewOnly),
					new CashReceiptModel(),
					CashReceiptModel,
					this.invoiceReceiptsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoiceReceiptsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientCaseHistoriesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientCaseHistoryModel.getProps(), this.patientCaseHistoriesRelations, this.isViewOnly),
					new PatientCaseHistoryModel(),
					PatientCaseHistoryModel,
					this.patientCaseHistoriesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientCaseHistoriesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientConsentsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientConsentModel.getProps(), this.patientConsentsRelations, this.isViewOnly),
					new PatientConsentModel(),
					PatientConsentModel,
					this.patientConsentsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientConsentsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientFinalizeProfilesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientSupportingDocumentModel.getProps(), this.patientFinalizeProfilesRelations, this.isViewOnly),
					new PatientSupportingDocumentModel(),
					PatientSupportingDocumentModel,
					this.patientFinalizeProfilesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientFinalizeProfilesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.retailPharmaciesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RetailPharmacyModel.getProps(), this.retailPharmaciesRelations, this.isViewOnly),
					new RetailPharmacyModel(),
					RetailPharmacyModel,
					this.retailPharmaciesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.retailPharmaciesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.visitsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitModel.getProps(), this.visitsRelations, this.isViewOnly),
					new PatientVisitModel(),
					PatientVisitModel,
					this.visitsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.visitsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			}
	}

	/**
	 * Triggered when the user switches from view mode to edit mode.
	 */
	onSwitchEdit() {
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.Edit, this.targetModelId);

		// % protected region % [Add any additional onSwitchEdit logic after the main body here] off begin
		// % protected region % [Add any additional onSwitchEdit logic after the main body here] end
	}

	/**
	 * Triggered whenever the `Cancel` of the create/edit child component is clicked.
	 */
	onCancelClicked() {
		// % protected region % [Add any additional onCancelClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic before the main body here] end

		this.triggerTileModeChange(CrudTileMode.List);

		// % protected region % [Add any additional onCancelClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic after the main body here] end
	}

	/**
	 * Create the reactive form from the input model
	 */
	createReactiveForm() {
		// % protected region % [Add any additional createReactiveForm logic before the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic before the main body here] end

		this.modelFormGroup = createReactiveFormFromModel(this.modelProperties, this.modelRelations, this.isViewOnly);

		// % protected region % [Add any additional createReactiveForm logic after the main body here] off begin
		// % protected region % [Add any additional createReactiveForm logic after the main body here] end
	}

	/**
	 * Returns the props and relations lists back to their default state.  This is called in fetchEntity to ensure that
	 * any time the entity changes these lists remain stable.  If you are adding additional entities to your crud page the
	 * placement of this method ensures that no duplicate attributes will be added on repeat runs of fetch entity
	 */
	resetPropsAndRels() {
		this.modelProperties = PatientGeneralInfoModel.getProps();
		this.modelRelations = PatientGeneralInfoModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'patientContactInformation';
		}).hideElement = this.patientContactInformationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientContactInformation').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientDetailAddress';
		}).hideElement = this.patientDetailAddressMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientDetailAddress').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientDetail';
		}).hideElement = this.patientDetailMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientDetail').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientEmergencyContactDetail';
		}).hideElement = this.patientEmergencyContactDetailMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientEmergencyContactDetail').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientEmploymentDetail';
		}).hideElement = this.patientEmploymentDetailMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientEmploymentDetail').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientPaymentBPJS';
		}).hideElement = this.patientPaymentBPJSMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientPaymentBPJS').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientPaymentTypeInsurance';
		}).hideElement = this.patientPaymentTypeInsuranceMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientPaymentTypeInsurance').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientPaymentTypeOthers';
		}).hideElement = this.patientPaymentTypeOthersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientPaymentTypeOthers').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientPersonalInformation';
		}).hideElement = this.patientPersonalInformationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientPersonalInformation').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientSelfPaying';
		}).hideElement = this.patientSelfPayingMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientSelfPaying').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsClaimSubmissions';
		}).hideElement = this.bpjsClaimSubmissionsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsClaimSubmissions').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'cashRefunds';
		}).hideElement = this.cashRefundsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'cashRefunds').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'informedConsents';
		}).hideElement = this.informedConsentsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'informedConsents').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoiceReceipts';
		}).hideElement = this.invoiceReceiptsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoiceReceipts').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientCaseHistories';
		}).hideElement = this.patientCaseHistoriesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientCaseHistories').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientConsents';
		}).hideElement = this.patientConsentsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientConsents').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientFinalizeProfiles';
		}).hideElement = this.patientFinalizeProfilesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientFinalizeProfiles').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'retailPharmacies';
		}).hideElement = this.retailPharmaciesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'retailPharmacies').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'visits';
		}).hideElement = this.visitsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'visits').hideElement;

	}

	/**
	 * Initialises the collections used for fetching the entities to display in multi entity crud for many relations.
	 * The same collection used to fetch entities for the relation dropdown cannot be reused, as we need to fetch a
	 * subset for these relations, and using the same collection will result in all entities being returned instead of the
	 * subset we are looking for.
	 *
	 * This method will only be populated if this entity has a many relation (i.e. it is the target of a 1:M relation, or is part of a
	 * M:M relation)
	 */
	initialiseMultiEntityCollections() {
		if (this.patientContactInformationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientContactInformationDisplayName, many: false});
		}

		if (this.patientDetailAddressMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientDetailAddressDisplayName, many: false});
		}

		if (this.patientDetailMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientDetailDisplayName, many: false});
		}

		if (this.patientEmergencyContactDetailMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientEmergencyContactDetailDisplayName, many: false});
		}

		if (this.patientEmploymentDetailMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientEmploymentDetailDisplayName, many: false});
		}

		if (this.patientPaymentBPJSMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientPaymentBPJSDisplayName, many: false});
		}

		if (this.patientPaymentTypeInsuranceMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientPaymentTypeInsuranceDisplayName, many: false});
		}

		if (this.patientPaymentTypeOthersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientPaymentTypeOthersDisplayName, many: false});
		}

		if (this.patientPersonalInformationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientPersonalInformationDisplayName, many: false});
		}

		if (this.patientSelfPayingMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientSelfPayingDisplayName, many: false});
		}

		if (this.bpjsClaimSubmissionsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsClaimSubmissionsDisplayName, many: true});
			this.store.dispatch(new bpjsClaimSubmissionModelAction.BpjsClaimSubmissionAction(
				bpjsClaimSubmissionModelAction.BpjsClaimSubmissionModelActionTypes.INITIALISE_BPJS_CLAIM_SUBMISSION_COLLECTION_STATE,
				{
					collectionId: this.bpjsClaimSubmissionsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsClaimSubmissionCollectionModels, this.bpjsClaimSubmissionsCollectionId).subscribe(models => {
				models.forEach(bpjsClaimSubmissions => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BpjsClaimSubmissionModel.getProps(), this.bpjsClaimSubmissionsRelations, this.isViewOnly),
						bpjsClaimSubmissions,
						BpjsClaimSubmissionModel,
						this.bpjsClaimSubmissionsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bpjsClaimSubmissionsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.cashRefundsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.cashRefundsDisplayName, many: true});
			this.store.dispatch(new cashRefundModelAction.CashRefundAction(
				cashRefundModelAction.CashRefundModelActionTypes.INITIALISE_CASH_REFUND_COLLECTION_STATE,
				{
					collectionId: this.cashRefundsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCashRefundCollectionModels, this.cashRefundsCollectionId).subscribe(models => {
				models.forEach(cashRefunds => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CashRefundModel.getProps(), this.cashRefundsRelations, this.isViewOnly),
						cashRefunds,
						CashRefundModel,
						this.cashRefundsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.cashRefundsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.informedConsentsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.informedConsentsDisplayName, many: true});
			this.store.dispatch(new informedConsentModelAction.InformedConsentAction(
				informedConsentModelAction.InformedConsentModelActionTypes.INITIALISE_INFORMED_CONSENT_COLLECTION_STATE,
				{
					collectionId: this.informedConsentsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInformedConsentCollectionModels, this.informedConsentsCollectionId).subscribe(models => {
				models.forEach(informedConsents => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InformedConsentModel.getProps(), this.informedConsentsRelations, this.isViewOnly),
						informedConsents,
						InformedConsentModel,
						this.informedConsentsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.informedConsentsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.invoiceReceiptsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoiceReceiptsDisplayName, many: true});
			this.store.dispatch(new cashReceiptModelAction.CashReceiptAction(
				cashReceiptModelAction.CashReceiptModelActionTypes.INITIALISE_CASH_RECEIPT_COLLECTION_STATE,
				{
					collectionId: this.invoiceReceiptsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCashReceiptCollectionModels, this.invoiceReceiptsCollectionId).subscribe(models => {
				models.forEach(invoiceReceipts => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CashReceiptModel.getProps(), this.invoiceReceiptsRelations, this.isViewOnly),
						invoiceReceipts,
						CashReceiptModel,
						this.invoiceReceiptsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.invoiceReceiptsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.patientCaseHistoriesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientCaseHistoriesDisplayName, many: true});
			this.store.dispatch(new patientCaseHistoryModelAction.PatientCaseHistoryAction(
				patientCaseHistoryModelAction.PatientCaseHistoryModelActionTypes.INITIALISE_PATIENT_CASE_HISTORY_COLLECTION_STATE,
				{
					collectionId: this.patientCaseHistoriesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientCaseHistoryCollectionModels, this.patientCaseHistoriesCollectionId).subscribe(models => {
				models.forEach(patientCaseHistories => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PatientCaseHistoryModel.getProps(), this.patientCaseHistoriesRelations, this.isViewOnly),
						patientCaseHistories,
						PatientCaseHistoryModel,
						this.patientCaseHistoriesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.patientCaseHistoriesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.patientConsentsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientConsentsDisplayName, many: true});
			this.store.dispatch(new patientConsentModelAction.PatientConsentAction(
				patientConsentModelAction.PatientConsentModelActionTypes.INITIALISE_PATIENT_CONSENT_COLLECTION_STATE,
				{
					collectionId: this.patientConsentsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientConsentCollectionModels, this.patientConsentsCollectionId).subscribe(models => {
				models.forEach(patientConsents => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PatientConsentModel.getProps(), this.patientConsentsRelations, this.isViewOnly),
						patientConsents,
						PatientConsentModel,
						this.patientConsentsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.patientConsentsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.patientFinalizeProfilesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientFinalizeProfilesDisplayName, many: true});
			this.store.dispatch(new patientSupportingDocumentModelAction.PatientSupportingDocumentAction(
				patientSupportingDocumentModelAction.PatientSupportingDocumentModelActionTypes.INITIALISE_PATIENT_SUPPORTING_DOCUMENT_COLLECTION_STATE,
				{
					collectionId: this.patientFinalizeProfilesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientSupportingDocumentCollectionModels, this.patientFinalizeProfilesCollectionId).subscribe(models => {
				models.forEach(patientFinalizeProfiles => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PatientSupportingDocumentModel.getProps(), this.patientFinalizeProfilesRelations, this.isViewOnly),
						patientFinalizeProfiles,
						PatientSupportingDocumentModel,
						this.patientFinalizeProfilesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.patientFinalizeProfilesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.retailPharmaciesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.retailPharmaciesDisplayName, many: true});
			this.store.dispatch(new retailPharmacyModelAction.RetailPharmacyAction(
				retailPharmacyModelAction.RetailPharmacyModelActionTypes.INITIALISE_RETAIL_PHARMACY_COLLECTION_STATE,
				{
					collectionId: this.retailPharmaciesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRetailPharmacyCollectionModels, this.retailPharmaciesCollectionId).subscribe(models => {
				models.forEach(retailPharmacies => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RetailPharmacyModel.getProps(), this.retailPharmaciesRelations, this.isViewOnly),
						retailPharmacies,
						RetailPharmacyModel,
						this.retailPharmaciesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.retailPharmaciesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.visitsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.visitsDisplayName, many: true});
			this.store.dispatch(new patientVisitModelAction.PatientVisitAction(
				patientVisitModelAction.PatientVisitModelActionTypes.INITIALISE_PATIENT_VISIT_COLLECTION_STATE,
				{
					collectionId: this.visitsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientVisitCollectionModels, this.visitsCollectionId).subscribe(models => {
				models.forEach(visits => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PatientVisitModel.getProps(), this.visitsRelations, this.isViewOnly),
						visits,
						PatientVisitModel,
						this.visitsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.visitsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

	}

	/**
	 * Fetches the entities for any activated multi entity crud selections, and adds groups to the form for every additional
	 * related entity.
	 *
	 * May be empty if the entity for this crud page has no related entities
	 */
	multiCrudFetchAdditionalEntities() {
		if (this.targetModel.patientContactInformation && this.targetModel.patientContactInformation.id && this.patientContactInformationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientContactInfoModel,
				this.patientContactInformationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientContactInformation.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientContactInfoModelWithId, this.targetModel.patientContactInformationId).subscribe(patientContactInformation => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientContactInfoModel.getProps(), this.patientContactInformationRelations, this.isViewOnly),
					patientContactInformation,
					PatientContactInfoModel,
					this.patientContactInformationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientContactInformationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientDetailAddress && this.targetModel.patientDetailAddress.id && this.patientDetailAddressMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientDetailAddressModel,
				this.patientDetailAddressOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientDetailAddress.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientDetailAddressModelWithId, this.targetModel.patientDetailAddressId).subscribe(patientDetailAddress => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientDetailAddressModel.getProps(), this.patientDetailAddressRelations, this.isViewOnly),
					patientDetailAddress,
					PatientDetailAddressModel,
					this.patientDetailAddressDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientDetailAddressRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientDetail && this.targetModel.patientDetail.id && this.patientDetailMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientDetailModel,
				this.patientDetailOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientDetail.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientDetailModelWithId, this.targetModel.patientDetailId).subscribe(patientDetail => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientDetailModel.getProps(), this.patientDetailRelations, this.isViewOnly),
					patientDetail,
					PatientDetailModel,
					this.patientDetailDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientDetailRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientEmergencyContactDetail && this.targetModel.patientEmergencyContactDetail.id && this.patientEmergencyContactDetailMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientEmergencyContactDetailModel,
				this.patientEmergencyContactDetailOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientEmergencyContactDetail.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientEmergencyContactDetailModelWithId, this.targetModel.patientEmergencyContactDetailId).subscribe(patientEmergencyContactDetail => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientEmergencyContactDetailModel.getProps(), this.patientEmergencyContactDetailRelations, this.isViewOnly),
					patientEmergencyContactDetail,
					PatientEmergencyContactDetailModel,
					this.patientEmergencyContactDetailDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientEmergencyContactDetailRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientEmploymentDetail && this.targetModel.patientEmploymentDetail.id && this.patientEmploymentDetailMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientEmploymentDetailModel,
				this.patientEmploymentDetailOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientEmploymentDetail.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientEmploymentDetailModelWithId, this.targetModel.patientEmploymentDetailId).subscribe(patientEmploymentDetail => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientEmploymentDetailModel.getProps(), this.patientEmploymentDetailRelations, this.isViewOnly),
					patientEmploymentDetail,
					PatientEmploymentDetailModel,
					this.patientEmploymentDetailDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientEmploymentDetailRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientPaymentBPJS && this.targetModel.patientPaymentBPJS.id && this.patientPaymentBPJSMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientPaymentBPJSModel,
				this.patientPaymentBPJSOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientPaymentBPJS.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientPaymentBPJSModelWithId, this.targetModel.patientPaymentBPJSId).subscribe(patientPaymentBPJS => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentBPJSModel.getProps(), this.patientPaymentBPJSRelations, this.isViewOnly),
					patientPaymentBPJS,
					PatientPaymentBPJSModel,
					this.patientPaymentBPJSDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPaymentBPJSRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientPaymentTypeInsurance && this.targetModel.patientPaymentTypeInsurance.id && this.patientPaymentTypeInsuranceMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientPaymentInsuranceModel,
				this.patientPaymentTypeInsuranceOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientPaymentTypeInsurance.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientPaymentInsuranceModelWithId, this.targetModel.patientPaymentTypeInsuranceId).subscribe(patientPaymentTypeInsurance => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentInsuranceModel.getProps(), this.patientPaymentTypeInsuranceRelations, this.isViewOnly),
					patientPaymentTypeInsurance,
					PatientPaymentInsuranceModel,
					this.patientPaymentTypeInsuranceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPaymentTypeInsuranceRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientPaymentTypeOthers && this.targetModel.patientPaymentTypeOthers.id && this.patientPaymentTypeOthersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientPaymentOthersModel,
				this.patientPaymentTypeOthersOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientPaymentTypeOthers.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientPaymentOthersModelWithId, this.targetModel.patientPaymentTypeOthersId).subscribe(patientPaymentTypeOthers => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentOthersModel.getProps(), this.patientPaymentTypeOthersRelations, this.isViewOnly),
					patientPaymentTypeOthers,
					PatientPaymentOthersModel,
					this.patientPaymentTypeOthersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPaymentTypeOthersRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientPersonalInformation && this.targetModel.patientPersonalInformation.id && this.patientPersonalInformationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientPersonalInfoModel,
				this.patientPersonalInformationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientPersonalInformation.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientPersonalInfoModelWithId, this.targetModel.patientPersonalInformationId).subscribe(patientPersonalInformation => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPersonalInfoModel.getProps(), this.patientPersonalInformationRelations, this.isViewOnly),
					patientPersonalInformation,
					PatientPersonalInfoModel,
					this.patientPersonalInformationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientPersonalInformationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientSelfPaying && this.targetModel.patientSelfPaying.id && this.patientSelfPayingMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientPaymentSelfPayingModel,
				this.patientSelfPayingOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientSelfPaying.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientPaymentSelfPayingModelWithId, this.targetModel.patientSelfPayingId).subscribe(patientSelfPaying => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientPaymentSelfPayingModel.getProps(), this.patientSelfPayingRelations, this.isViewOnly),
					patientSelfPaying,
					PatientPaymentSelfPayingModel,
					this.patientSelfPayingDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientSelfPayingRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsClaimSubmissionsIds && this.targetModel.bpjsClaimSubmissionsIds.length > 0 && this.bpjsClaimSubmissionsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsClaimSubmissionModel,
				this.bpjsClaimSubmissionsOppositeRelation,
				this.bpjsClaimSubmissionsCollectionId,
				this.targetModel.bpjsClaimSubmissionsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.cashRefundsIds && this.targetModel.cashRefundsIds.length > 0 && this.cashRefundsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CashRefundModel,
				this.cashRefundsOppositeRelation,
				this.cashRefundsCollectionId,
				this.targetModel.cashRefundsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.informedConsentsIds && this.targetModel.informedConsentsIds.length > 0 && this.informedConsentsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InformedConsentModel,
				this.informedConsentsOppositeRelation,
				this.informedConsentsCollectionId,
				this.targetModel.informedConsentsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.invoiceReceiptsIds && this.targetModel.invoiceReceiptsIds.length > 0 && this.invoiceReceiptsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CashReceiptModel,
				this.invoiceReceiptsOppositeRelation,
				this.invoiceReceiptsCollectionId,
				this.targetModel.invoiceReceiptsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.patientCaseHistoriesIds && this.targetModel.patientCaseHistoriesIds.length > 0 && this.patientCaseHistoriesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientCaseHistoryModel,
				this.patientCaseHistoriesOppositeRelation,
				this.patientCaseHistoriesCollectionId,
				this.targetModel.patientCaseHistoriesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.patientConsentsIds && this.targetModel.patientConsentsIds.length > 0 && this.patientConsentsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientConsentModel,
				this.patientConsentsOppositeRelation,
				this.patientConsentsCollectionId,
				this.targetModel.patientConsentsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.patientFinalizeProfilesIds && this.targetModel.patientFinalizeProfilesIds.length > 0 && this.patientFinalizeProfilesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientSupportingDocumentModel,
				this.patientFinalizeProfilesOppositeRelation,
				this.patientFinalizeProfilesCollectionId,
				this.targetModel.patientFinalizeProfilesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.retailPharmaciesIds && this.targetModel.retailPharmaciesIds.length > 0 && this.retailPharmaciesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RetailPharmacyModel,
				this.retailPharmaciesOppositeRelation,
				this.retailPharmaciesCollectionId,
				this.targetModel.retailPharmaciesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.visitsIds && this.targetModel.visitsIds.length > 0 && this.visitsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientVisitModel,
				this.visitsOppositeRelation,
				this.visitsCollectionId,
				this.targetModel.visitsIds.length,
				this.targetModel.id,
				true
			));
		}

	}

	/**
	 * The crud create edit page will handle all potential multi entity crud permutations by returning an
	 * `additionalEntities` parameter in its returned event.  This attribute will contain any entities which
	 * were added to the crud edit page for multi entity model.  Once this attribute has been returned, we need
	 * to process it, and transfer any additional entities from this attribute into the target model, so that these
	 * additional entities can be sent to the serverside for processing.
	 *
	 * @param model The model to inject the additional entities into.  This will usually be the targetModel attribute for this component
	 * @param event The event returned from the crud edit page when clicking create or save.  We only care about the additionalEntities param here
	 * @returns the model passed in as input, but with the entities from the additionalEntities attribute added to that model.
	 */
	addAdditionalEntitiesToModel(model: PatientGeneralInfoModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): PatientGeneralInfoModel {
		let updatedModel: PatientGeneralInfoModel = new PatientGeneralInfoModel(model);

		if (this.patientContactInformationMultiCrudActive) {
			updatedModel.patientContactInformation = event.additionalEntities.patientContactInformation ? event.additionalEntities.patientContactInformation : undefined;

			if (!updatedModel.patientContactInformation && event.payload) {
				event.payload.patientContactInformationId = null;
			}
		} else if (event.payload?.patientContactInformationId !== undefined) {
			event.payload.patientContactInformation = null;
			updatedModel.patientContactInformation = null;
		}

		if (this.patientDetailAddressMultiCrudActive) {
			updatedModel.patientDetailAddress = event.additionalEntities.patientDetailAddress ? event.additionalEntities.patientDetailAddress : undefined;

			if (!updatedModel.patientDetailAddress && event.payload) {
				event.payload.patientDetailAddressId = null;
			}
		} else if (event.payload?.patientDetailAddressId !== undefined) {
			event.payload.patientDetailAddress = null;
			updatedModel.patientDetailAddress = null;
		}

		if (this.patientDetailMultiCrudActive) {
			updatedModel.patientDetail = event.additionalEntities.patientDetail ? event.additionalEntities.patientDetail : undefined;

			if (!updatedModel.patientDetail && event.payload) {
				event.payload.patientDetailId = null;
			}
		} else if (event.payload?.patientDetailId !== undefined) {
			event.payload.patientDetail = null;
			updatedModel.patientDetail = null;
		}

		if (this.patientEmergencyContactDetailMultiCrudActive) {
			updatedModel.patientEmergencyContactDetail = event.additionalEntities.patientEmergencyContactDetail ? event.additionalEntities.patientEmergencyContactDetail : undefined;

			if (!updatedModel.patientEmergencyContactDetail && event.payload) {
				event.payload.patientEmergencyContactDetailId = null;
			}
		} else if (event.payload?.patientEmergencyContactDetailId !== undefined) {
			event.payload.patientEmergencyContactDetail = null;
			updatedModel.patientEmergencyContactDetail = null;
		}

		if (this.patientEmploymentDetailMultiCrudActive) {
			updatedModel.patientEmploymentDetail = event.additionalEntities.patientEmploymentDetail ? event.additionalEntities.patientEmploymentDetail : undefined;

			if (!updatedModel.patientEmploymentDetail && event.payload) {
				event.payload.patientEmploymentDetailId = null;
			}
		} else if (event.payload?.patientEmploymentDetailId !== undefined) {
			event.payload.patientEmploymentDetail = null;
			updatedModel.patientEmploymentDetail = null;
		}

		if (this.patientPaymentBPJSMultiCrudActive) {
			updatedModel.patientPaymentBPJS = event.additionalEntities.patientPaymentBPJS ? event.additionalEntities.patientPaymentBPJS : undefined;

			if (!updatedModel.patientPaymentBPJS && event.payload) {
				event.payload.patientPaymentBPJSId = null;
			}
		} else if (event.payload?.patientPaymentBPJSId !== undefined) {
			event.payload.patientPaymentBPJS = null;
			updatedModel.patientPaymentBPJS = null;
		}

		if (this.patientPaymentTypeInsuranceMultiCrudActive) {
			updatedModel.patientPaymentTypeInsurance = event.additionalEntities.patientPaymentTypeInsurance ? event.additionalEntities.patientPaymentTypeInsurance : undefined;

			if (!updatedModel.patientPaymentTypeInsurance && event.payload) {
				event.payload.patientPaymentTypeInsuranceId = null;
			}
		} else if (event.payload?.patientPaymentTypeInsuranceId !== undefined) {
			event.payload.patientPaymentTypeInsurance = null;
			updatedModel.patientPaymentTypeInsurance = null;
		}

		if (this.patientPaymentTypeOthersMultiCrudActive) {
			updatedModel.patientPaymentTypeOthers = event.additionalEntities.patientPaymentTypeOthers ? event.additionalEntities.patientPaymentTypeOthers : undefined;

			if (!updatedModel.patientPaymentTypeOthers && event.payload) {
				event.payload.patientPaymentTypeOthersId = null;
			}
		} else if (event.payload?.patientPaymentTypeOthersId !== undefined) {
			event.payload.patientPaymentTypeOthers = null;
			updatedModel.patientPaymentTypeOthers = null;
		}

		if (this.patientPersonalInformationMultiCrudActive) {
			updatedModel.patientPersonalInformation = event.additionalEntities.patientPersonalInformation ? event.additionalEntities.patientPersonalInformation : undefined;

			if (!updatedModel.patientPersonalInformation && event.payload) {
				event.payload.patientPersonalInformationId = null;
			}
		} else if (event.payload?.patientPersonalInformationId !== undefined) {
			event.payload.patientPersonalInformation = null;
			updatedModel.patientPersonalInformation = null;
		}

		if (this.patientSelfPayingMultiCrudActive) {
			updatedModel.patientSelfPaying = event.additionalEntities.patientSelfPaying ? event.additionalEntities.patientSelfPaying : undefined;

			if (!updatedModel.patientSelfPaying && event.payload) {
				event.payload.patientSelfPayingId = null;
			}
		} else if (event.payload?.patientSelfPayingId !== undefined) {
			event.payload.patientSelfPaying = null;
			updatedModel.patientSelfPaying = null;
		}

		updatedModel.bpjsClaimSubmissions = [];
		if (this.bpjsClaimSubmissionsMultiCrudActive) {
			if (event.additionalEntities.bpjsClaimSubmissions) {
				event.additionalEntities.bpjsClaimSubmissions.forEach(entity => {
					updatedModel.bpjsClaimSubmissions.push(entity);
				});
			}

			if (!updatedModel.bpjsClaimSubmissions.length) {
				updatedModel.bpjsClaimSubmissionsIds = [];
			}
		}
		updatedModel.cashRefunds = [];
		if (this.cashRefundsMultiCrudActive) {
			if (event.additionalEntities.cashRefunds) {
				event.additionalEntities.cashRefunds.forEach(entity => {
					updatedModel.cashRefunds.push(entity);
				});
			}

			if (!updatedModel.cashRefunds.length) {
				updatedModel.cashRefundsIds = [];
			}
		}
		updatedModel.informedConsents = [];
		if (this.informedConsentsMultiCrudActive) {
			if (event.additionalEntities.informedConsents) {
				event.additionalEntities.informedConsents.forEach(entity => {
					updatedModel.informedConsents.push(entity);
				});
			}

			if (!updatedModel.informedConsents.length) {
				updatedModel.informedConsentsIds = [];
			}
		}
		updatedModel.invoiceReceipts = [];
		if (this.invoiceReceiptsMultiCrudActive) {
			if (event.additionalEntities.invoiceReceipts) {
				event.additionalEntities.invoiceReceipts.forEach(entity => {
					updatedModel.invoiceReceipts.push(entity);
				});
			}

			if (!updatedModel.invoiceReceipts.length) {
				updatedModel.invoiceReceiptsIds = [];
			}
		}
		updatedModel.patientCaseHistories = [];
		if (this.patientCaseHistoriesMultiCrudActive) {
			if (event.additionalEntities.patientCaseHistories) {
				event.additionalEntities.patientCaseHistories.forEach(entity => {
					updatedModel.patientCaseHistories.push(entity);
				});
			}

			if (!updatedModel.patientCaseHistories.length) {
				updatedModel.patientCaseHistoriesIds = [];
			}
		}
		updatedModel.patientConsents = [];
		if (this.patientConsentsMultiCrudActive) {
			if (event.additionalEntities.patientConsents) {
				event.additionalEntities.patientConsents.forEach(entity => {
					updatedModel.patientConsents.push(entity);
				});
			}

			if (!updatedModel.patientConsents.length) {
				updatedModel.patientConsentsIds = [];
			}
		}
		updatedModel.patientFinalizeProfiles = [];
		if (this.patientFinalizeProfilesMultiCrudActive) {
			if (event.additionalEntities.patientFinalizeProfiles) {
				event.additionalEntities.patientFinalizeProfiles.forEach(entity => {
					updatedModel.patientFinalizeProfiles.push(entity);
				});
			}

			if (!updatedModel.patientFinalizeProfiles.length) {
				updatedModel.patientFinalizeProfilesIds = [];
			}
		}
		updatedModel.retailPharmacies = [];
		if (this.retailPharmaciesMultiCrudActive) {
			if (event.additionalEntities.retailPharmacies) {
				event.additionalEntities.retailPharmacies.forEach(entity => {
					updatedModel.retailPharmacies.push(entity);
				});
			}

			if (!updatedModel.retailPharmacies.length) {
				updatedModel.retailPharmaciesIds = [];
			}
		}
		updatedModel.visits = [];
		if (this.visitsMultiCrudActive) {
			if (event.additionalEntities.visits) {
				event.additionalEntities.visits.forEach(entity => {
					updatedModel.visits.push(entity);
				});
			}

			if (!updatedModel.visits.length) {
				updatedModel.visitsIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
