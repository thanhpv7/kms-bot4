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
import * as modelAction from 'src/app/models/registration/registration.model.action';
import {RegistrationModelState, RegistrationModelAudit} from 'src/app/models/registration/registration.model.state';
import {RegistrationModel} from 'src/app/models/registration/registration.model';
import {
	getRegistrationModelAuditsByEntityId,
	getRegistrationModelWithId,
	getCountRegistrationModels,
} from 'src/app/models/registration/registration.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsPRBDetailModel} from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model';
import * as bpjsPRBDetailModelAction from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.action';
import {
	getBpjsPRBDetailCollectionModels, getBpjsPRBDetailModelWithId,
} from 'src/app/models/bpjsPRBDetail/bpjs_prb_detail.model.selector';
import {BpjsPcareRegistrationsModel} from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import * as bpjsPcareRegistrationsModelAction from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.action';
import {
	getBpjsPcareRegistrationsCollectionModels, getBpjsPcareRegistrationsModelWithId,
} from 'src/app/models/bpjsPcareRegistrations/bpjs_pcare_registrations.model.selector';
import {BpjsSEPModel} from 'src/app/models/bpjsSEP/bpjs_sep.model';
import * as bpjsSEPModelAction from 'src/app/models/bpjsSEP/bpjs_sep.model.action';
import {
	getBpjsSEPCollectionModels, getBpjsSEPModelWithId,
} from 'src/app/models/bpjsSEP/bpjs_sep.model.selector';
import {BedFacilityModel} from 'src/app/models/bedFacility/bed_facility.model';
import * as bedFacilityModelAction from 'src/app/models/bedFacility/bed_facility.model.action';
import {
	getBedFacilityCollectionModels, getBedFacilityModelWithId,
} from 'src/app/models/bedFacility/bed_facility.model.selector';
import {BedReserveModel} from 'src/app/models/bedReserve/bed_reserve.model';
import * as bedReserveModelAction from 'src/app/models/bedReserve/bed_reserve.model.action';
import {
	getBedReserveCollectionModels, getBedReserveModelWithId,
} from 'src/app/models/bedReserve/bed_reserve.model.selector';
import {DiagnosesAndProceduresModel} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import * as diagnosesAndProceduresModelAction from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.action';
import {
	getDiagnosesAndProceduresCollectionModels, getDiagnosesAndProceduresModelWithId,
} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import {DiagnosticExaminationResultsModel} from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model';
import * as diagnosticExaminationResultsModelAction from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.action';
import {
	getDiagnosticExaminationResultsCollectionModels, getDiagnosticExaminationResultsModelWithId,
} from 'src/app/models/diagnosticExaminationResults/diagnostic_examination_results.model.selector';
import {DiagnosticStaffExaminationSummaryModel} from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model';
import * as diagnosticStaffExaminationSummaryModelAction from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.action';
import {
	getDiagnosticStaffExaminationSummaryCollectionModels, getDiagnosticStaffExaminationSummaryModelWithId,
} from 'src/app/models/diagnosticStaffExaminationSummary/diagnostic_staff_examination_summary.model.selector';
import {ExaminationItemModel} from 'src/app/models/examinationItem/examination_item.model';
import * as examinationItemModelAction from 'src/app/models/examinationItem/examination_item.model.action';
import {
	getExaminationItemCollectionModels, getExaminationItemModelWithId,
} from 'src/app/models/examinationItem/examination_item.model.selector';
import {FluidBalanceDetailModel} from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model';
import * as fluidBalanceDetailModelAction from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.action';
import {
	getFluidBalanceDetailCollectionModels, getFluidBalanceDetailModelWithId,
} from 'src/app/models/fluidBalanceDetail/fluid_balance_detail.model.selector';
import {HealthFacilityModel} from 'src/app/models/healthFacility/health_facility.model';
import * as healthFacilityModelAction from 'src/app/models/healthFacility/health_facility.model.action';
import {
	getHealthFacilityCollectionModels, getHealthFacilityModelWithId,
} from 'src/app/models/healthFacility/health_facility.model.selector';
import {InformedConsentModel} from 'src/app/models/informedConsent/informed_consent.model';
import * as informedConsentModelAction from 'src/app/models/informedConsent/informed_consent.model.action';
import {
	getInformedConsentCollectionModels, getInformedConsentModelWithId,
} from 'src/app/models/informedConsent/informed_consent.model.selector';
import {InvoiceItemModel} from 'src/app/models/invoiceItem/invoice_item.model';
import * as invoiceItemModelAction from 'src/app/models/invoiceItem/invoice_item.model.action';
import {
	getInvoiceItemCollectionModels, getInvoiceItemModelWithId,
} from 'src/app/models/invoiceItem/invoice_item.model.selector';
import {MedicalCertificateDischargeResumeModel} from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import * as medicalCertificateDischargeResumeModelAction from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.action';
import {
	getMedicalCertificateDischargeResumeCollectionModels, getMedicalCertificateDischargeResumeModelWithId,
} from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import {MedicalCertificateBirthModel} from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model';
import * as medicalCertificateBirthModelAction from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.action';
import {
	getMedicalCertificateBirthCollectionModels, getMedicalCertificateBirthModelWithId,
} from 'src/app/models/medicalCertificateBirth/medical_certificate_birth.model.selector';
import {MedicalCertificateHospitalizationModel} from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model';
import * as medicalCertificateHospitalizationModelAction from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.action';
import {
	getMedicalCertificateHospitalizationCollectionModels, getMedicalCertificateHospitalizationModelWithId,
} from 'src/app/models/medicalCertificateHospitalization/medical_certificate_hospitalization.model.selector';
import {MedicalCertificateMedicalAttendanceModel} from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model';
import * as medicalCertificateMedicalAttendanceModelAction from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.action';
import {
	getMedicalCertificateMedicalAttendanceCollectionModels, getMedicalCertificateMedicalAttendanceModelWithId,
} from 'src/app/models/medicalCertificateMedicalAttendance/medical_certificate_medical_attendance.model.selector';
import {MedicalCertificateMentalHealthModel} from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model';
import * as medicalCertificateMentalHealthModelAction from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.action';
import {
	getMedicalCertificateMentalHealthCollectionModels, getMedicalCertificateMentalHealthModelWithId,
} from 'src/app/models/medicalCertificateMentalHealth/medical_certificate_mental_health.model.selector';
import {MedicalCertificatePhysicalHealthModel} from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model';
import * as medicalCertificatePhysicalHealthModelAction from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.action';
import {
	getMedicalCertificatePhysicalHealthCollectionModels, getMedicalCertificatePhysicalHealthModelWithId,
} from 'src/app/models/medicalCertificatePhysicalHealth/medical_certificate_physical_health.model.selector';
import {MedicalCertificateRestrictedWorkModel} from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model';
import * as medicalCertificateRestrictedWorkModelAction from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.action';
import {
	getMedicalCertificateRestrictedWorkCollectionModels, getMedicalCertificateRestrictedWorkModelWithId,
} from 'src/app/models/medicalCertificateRestrictedWork/medical_certificate_restricted_work.model.selector';
import {MedicalCertificateSickLeaveModel} from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model';
import * as medicalCertificateSickLeaveModelAction from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.action';
import {
	getMedicalCertificateSickLeaveCollectionModels, getMedicalCertificateSickLeaveModelWithId,
} from 'src/app/models/medicalCertificateSickLeave/medical_certificate_sick_leave.model.selector';
import {MedicalExaminationRecordModel} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import * as medicalExaminationRecordModelAction from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.action';
import {
	getMedicalExaminationRecordCollectionModels, getMedicalExaminationRecordModelWithId,
} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import {MedicalFeeModel} from 'src/app/models/medicalFee/medical_fee.model';
import * as medicalFeeModelAction from 'src/app/models/medicalFee/medical_fee.model.action';
import {
	getMedicalFeeCollectionModels, getMedicalFeeModelWithId,
} from 'src/app/models/medicalFee/medical_fee.model.selector';
import {MedicationHeaderModel} from 'src/app/models/medicationHeader/medication_header.model';
import * as medicationHeaderModelAction from 'src/app/models/medicationHeader/medication_header.model.action';
import {
	getMedicationHeaderCollectionModels, getMedicationHeaderModelWithId,
} from 'src/app/models/medicationHeader/medication_header.model.selector';
import {PcareExaminationModel} from 'src/app/models/pcareExamination/pcare_examination.model';
import * as pcareExaminationModelAction from 'src/app/models/pcareExamination/pcare_examination.model.action';
import {
	getPcareExaminationCollectionModels, getPcareExaminationModelWithId,
} from 'src/app/models/pcareExamination/pcare_examination.model.selector';
import {PatientVisitModel} from 'src/app/models/patientVisit/patient_visit.model';
import * as patientVisitModelAction from 'src/app/models/patientVisit/patient_visit.model.action';
import {
	getPatientVisitCollectionModels, getPatientVisitModelWithId,
} from 'src/app/models/patientVisit/patient_visit.model.selector';
import {PatientVitalInformationModel} from 'src/app/models/patientVitalInformation/patient_vital_information.model';
import * as patientVitalInformationModelAction from 'src/app/models/patientVitalInformation/patient_vital_information.model.action';
import {
	getPatientVitalInformationCollectionModels, getPatientVitalInformationModelWithId,
} from 'src/app/models/patientVitalInformation/patient_vital_information.model.selector';
import {PrescriptionHeaderModel} from 'src/app/models/prescriptionHeader/prescription_header.model';
import * as prescriptionHeaderModelAction from 'src/app/models/prescriptionHeader/prescription_header.model.action';
import {
	getPrescriptionHeaderCollectionModels, getPrescriptionHeaderModelWithId,
} from 'src/app/models/prescriptionHeader/prescription_header.model.selector';
import {SepModel} from 'src/app/models/sep/sep.model';
import * as sepModelAction from 'src/app/models/sep/sep.model.action';
import {
	getSepCollectionModels, getSepModelWithId,
} from 'src/app/models/sep/sep.model.selector';
import {SampleCollectionInformationModel} from 'src/app/models/sampleCollectionInformation/sample_collection_information.model';
import * as sampleCollectionInformationModelAction from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.action';
import {
	getSampleCollectionInformationCollectionModels, getSampleCollectionInformationModelWithId,
} from 'src/app/models/sampleCollectionInformation/sample_collection_information.model.selector';
import {ServiceModel} from 'src/app/models/service/service.model';
import * as serviceModelAction from 'src/app/models/service/service.model.action';
import {
	getServiceCollectionModels, getServiceModelWithId,
} from 'src/app/models/service/service.model.selector';
import {StaffModel} from 'src/app/models/staff/staff.model';
import * as staffModelAction from 'src/app/models/staff/staff.model.action';
import {
	getStaffCollectionModels, getStaffModelWithId,
} from 'src/app/models/staff/staff.model.selector';
import {VaccinationOrderModel} from 'src/app/models/vaccinationOrder/vaccination_order.model';
import * as vaccinationOrderModelAction from 'src/app/models/vaccinationOrder/vaccination_order.model.action';
import {
	getVaccinationOrderCollectionModels, getVaccinationOrderModelWithId,
} from 'src/app/models/vaccinationOrder/vaccination_order.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../registration-admin-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-registration-admin-crud-edit',
	templateUrl: './registration-admin-crud-edit.component.html',
	styleUrls: [
		'./registration-admin-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class AdminRegistrationCrudEditComponent
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
	collectionId: string = '91096a56-b194-4f29-82ea-718263d4a45f';
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
	registrationAudits$: Observable<RegistrationModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and BPJS PRB Detail here] off begin
	bpjsPRBDetailMultiCrudActive: boolean = false;
	bpjsPRBDetailDisplayName = 'BPJS PRB Detail';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and BPJS PRB Detail here] end
	bpjsPRBDetailOppositeRelation = 'registration';
	bpjsPRBDetailRelations: ModelRelation[] = this.bpjsPRBDetailMultiCrudActive ? BpjsPRBDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsPRBDetailOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and BPJS Pcare Registrations here] off begin
	bpjsPcareRegistrationsMultiCrudActive: boolean = false;
	bpjsPcareRegistrationsDisplayName = 'BPJS Pcare Registrations';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and BPJS Pcare Registrations here] end
	bpjsPcareRegistrationsOppositeRelation = 'registration';
	bpjsPcareRegistrationsRelations: ModelRelation[] = this.bpjsPcareRegistrationsMultiCrudActive ? BpjsPcareRegistrationsModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsPcareRegistrationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and BPJS SEP here] off begin
	bpjsSEPMultiCrudActive: boolean = false;
	bpjsSEPDisplayName = 'BPJS SEP';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and BPJS SEP here] end
	bpjsSEPOppositeRelation = 'registration';
	bpjsSEPRelations: ModelRelation[] = this.bpjsSEPMultiCrudActive ? BpjsSEPModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsSEPOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate  Discharge Resume here] off begin
	medicalCertificateDischargeResumeMultiCrudActive: boolean = false;
	medicalCertificateDischargeResumeDisplayName = 'Medical Certificate  Discharge Resume';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate  Discharge Resume here] end
	medicalCertificateDischargeResumeOppositeRelation = 'registration';
	medicalCertificateDischargeResumeRelations: ModelRelation[] = this.medicalCertificateDischargeResumeMultiCrudActive ? MedicalCertificateDischargeResumeModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateDischargeResumeOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Birth here] off begin
	medicalCertificateBirthMultiCrudActive: boolean = false;
	medicalCertificateBirthDisplayName = 'Medical Certificate Birth';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Birth here] end
	medicalCertificateBirthOppositeRelation = 'registration';
	medicalCertificateBirthRelations: ModelRelation[] = this.medicalCertificateBirthMultiCrudActive ? MedicalCertificateBirthModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateBirthOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Hospitalization here] off begin
	medicalCertificateHospitalizationMultiCrudActive: boolean = false;
	medicalCertificateHospitalizationDisplayName = 'Medical Certificate Hospitalization';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Hospitalization here] end
	medicalCertificateHospitalizationOppositeRelation = 'registration';
	medicalCertificateHospitalizationRelations: ModelRelation[] = this.medicalCertificateHospitalizationMultiCrudActive ? MedicalCertificateHospitalizationModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateHospitalizationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Medical Attendance here] off begin
	medicalCertificateMedicalAttendanceMultiCrudActive: boolean = false;
	medicalCertificateMedicalAttendanceDisplayName = 'Medical Certificate Medical Attendance';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Medical Attendance here] end
	medicalCertificateMedicalAttendanceOppositeRelation = 'registration';
	medicalCertificateMedicalAttendanceRelations: ModelRelation[] = this.medicalCertificateMedicalAttendanceMultiCrudActive ? MedicalCertificateMedicalAttendanceModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateMedicalAttendanceOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Mental Health here] off begin
	medicalCertificateMentalHealthMultiCrudActive: boolean = false;
	medicalCertificateMentalHealthDisplayName = 'Medical Certificate Mental Health';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Mental Health here] end
	medicalCertificateMentalHealthOppositeRelation = 'registration';
	medicalCertificateMentalHealthRelations: ModelRelation[] = this.medicalCertificateMentalHealthMultiCrudActive ? MedicalCertificateMentalHealthModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateMentalHealthOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Physical Health here] off begin
	medicalCertificatePhysicalHealthMultiCrudActive: boolean = false;
	medicalCertificatePhysicalHealthDisplayName = 'Medical Certificate Physical Health';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Physical Health here] end
	medicalCertificatePhysicalHealthOppositeRelation = 'registration';
	medicalCertificatePhysicalHealthRelations: ModelRelation[] = this.medicalCertificatePhysicalHealthMultiCrudActive ? MedicalCertificatePhysicalHealthModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificatePhysicalHealthOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Restricted Work here] off begin
	medicalCertificateRestrictedWorkMultiCrudActive: boolean = false;
	medicalCertificateRestrictedWorkDisplayName = 'Medical Certificate Restricted Work';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Restricted Work here] end
	medicalCertificateRestrictedWorkOppositeRelation = 'registration';
	medicalCertificateRestrictedWorkRelations: ModelRelation[] = this.medicalCertificateRestrictedWorkMultiCrudActive ? MedicalCertificateRestrictedWorkModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateRestrictedWorkOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Sick Leave here] off begin
	medicalCertificateSickLeaveMultiCrudActive: boolean = false;
	medicalCertificateSickLeaveDisplayName = 'Medical Certificate Sick Leave';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Certificate Sick Leave here] end
	medicalCertificateSickLeaveOppositeRelation = 'registration';
	medicalCertificateSickLeaveRelations: ModelRelation[] = this.medicalCertificateSickLeaveMultiCrudActive ? MedicalCertificateSickLeaveModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalCertificateSickLeaveOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Examination Record here] off begin
	medicalExaminationRecordMultiCrudActive: boolean = false;
	medicalExaminationRecordDisplayName = 'Medical Examination Record';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Examination Record here] end
	medicalExaminationRecordOppositeRelation = 'registration';
	medicalExaminationRecordRelations: ModelRelation[] = this.medicalExaminationRecordMultiCrudActive ? MedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalExaminationRecordOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and PCare Examination here] off begin
	pcareExaminationMultiCrudActive: boolean = false;
	pcareExaminationDisplayName = 'PCare Examination';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and PCare Examination here] end
	pcareExaminationOppositeRelation = 'registration';
	pcareExaminationRelations: ModelRelation[] = this.pcareExaminationMultiCrudActive ? PcareExaminationModel.getRelations()
		.map(relation => {
			if (relation.id === this.pcareExaminationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and SEP here] off begin
	sepMultiCrudActive: boolean = false;
	sepDisplayName = 'SEP';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and SEP here] end
	sepOppositeRelation = 'registration';
	sepRelations: ModelRelation[] = this.sepMultiCrudActive ? SepModel.getRelations()
		.map(relation => {
			if (relation.id === this.sepOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Diagnostic Staff Examination Summary and Registration here] off begin
	diagnosticStaffExaminationSummaryMultiCrudActive: boolean = false;
	diagnosticStaffExaminationSummaryDisplayName = 'Diagnostic Staff Examination Summary';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Diagnostic Staff Examination Summary and Registration here] end
	diagnosticStaffExaminationSummaryOppositeRelation = 'registration';
	diagnosticStaffExaminationSummaryRelations: ModelRelation[] = this.diagnosticStaffExaminationSummaryMultiCrudActive ? DiagnosticStaffExaminationSummaryModel.getRelations()
		.map(relation => {
			if (relation.id === this.diagnosticStaffExaminationSummaryOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Admission ICD 10 and Admission ICD 10 here] off begin
	admissionICD10MultiCrudActive: boolean = false;
	admissionICD10DisplayName = 'Admission ICD 10';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Admission ICD 10 and Admission ICD 10 here] end
	admissionICD10OppositeRelation = 'admissionICD10';
	admissionICD10Relations: ModelRelation[] = this.admissionICD10MultiCrudActive ? DiagnosesAndProceduresModel.getRelations()
		.map(relation => {
			if (relation.id === this.admissionICD10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Admission ICD 9 CM and Admission ICD 9 CM here] off begin
	admissionICD9CMMultiCrudActive: boolean = false;
	admissionICD9CMDisplayName = 'Admission ICD 9 CM';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Admission ICD 9 CM and Admission ICD 9 CM here] end
	admissionICD9CMOppositeRelation = 'admissionICD9CM';
	admissionICD9CMRelations: ModelRelation[] = this.admissionICD9CMMultiCrudActive ? DiagnosesAndProceduresModel.getRelations()
		.map(relation => {
			if (relation.id === this.admissionICD9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Dismissal Referring Facility and Dismissal Referring Facility here] off begin
	dismissalReferringFacilityMultiCrudActive: boolean = false;
	dismissalReferringFacilityDisplayName = 'Dismissal Referring Facility';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Dismissal Referring Facility and Dismissal Referring Facility here] end
	dismissalReferringFacilityOppositeRelation = 'dismissalReferringFacility';
	dismissalReferringFacilityRelations: ModelRelation[] = this.dismissalReferringFacilityMultiCrudActive ? HealthFacilityModel.getRelations()
		.map(relation => {
			if (relation.id === this.dismissalReferringFacilityOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Dismissal Referring Staff and Dismissal Referring Staff here] off begin
	dismissalReferringStaffMultiCrudActive: boolean = false;
	dismissalReferringStaffDisplayName = 'Dismissal Referring Staff';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Dismissal Referring Staff and Dismissal Referring Staff here] end
	dismissalReferringStaffOppositeRelation = 'dismissalReferringStaff';
	dismissalReferringStaffRelations: ModelRelation[] = this.dismissalReferringStaffMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.dismissalReferringStaffOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Referring Unit and Referring Unit here] off begin
	referringUnitMultiCrudActive: boolean = false;
	referringUnitDisplayName = 'Referring Unit';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Referring Unit and Referring Unit here] end
	referringUnitOppositeRelation = 'referringUnit';
	referringUnitRelations: ModelRelation[] = this.referringUnitMultiCrudActive ? ServiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.referringUnitOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Referring facility and Referring facility here] off begin
	referringFacilityMultiCrudActive: boolean = false;
	referringFacilityDisplayName = 'Referring facility';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Referring facility and Referring facility here] end
	referringFacilityOppositeRelation = 'referringFacility';
	referringFacilityRelations: ModelRelation[] = this.referringFacilityMultiCrudActive ? HealthFacilityModel.getRelations()
		.map(relation => {
			if (relation.id === this.referringFacilityOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Registrations here] off begin
	bedFacilityMultiCrudActive: boolean = false;
	bedFacilityDisplayName = 'Bed Facility';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Bed Facility and Registrations here] end
	bedFacilityOppositeRelation = 'registrations';
	bedFacilityRelations: ModelRelation[] = this.bedFacilityMultiCrudActive ? BedFacilityModel.getRelations()
		.map(relation => {
			if (relation.id === this.bedFacilityOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Registrations here] off begin
	patientVisitMultiCrudActive: boolean = false;
	patientVisitDisplayName = 'Patient Visit';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Patient Visit and Registrations here] end
	patientVisitOppositeRelation = 'registrations';
	patientVisitRelations: ModelRelation[] = this.patientVisitMultiCrudActive ? PatientVisitModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientVisitOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Registrations here] off begin
	serviceMultiCrudActive: boolean = false;
	serviceDisplayName = 'Service';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service and Registrations here] end
	serviceOppositeRelation = 'registrations';
	serviceRelations: ModelRelation[] = this.serviceMultiCrudActive ? ServiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.serviceOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Registrations here] off begin
	staffMultiCrudActive: boolean = false;
	staffDisplayName = 'Staff';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Staff and Registrations here] end
	staffOppositeRelation = 'registrations';
	staffRelations: ModelRelation[] = this.staffMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.staffOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Requested By and Requested By here] off begin
	requestedByMultiCrudActive: boolean = false;
	requestedByDisplayName = 'Requested By';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Requested By and Requested By here] end
	requestedByOppositeRelation = 'requestedBy';
	requestedByRelations: ModelRelation[] = this.requestedByMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.requestedByOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Bed Reserves here] off begin
	bedReservesMultiCrudActive: boolean = false;
	bedReservesDisplayName = 'Bed Reserves';
	bedReservesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Bed Reserves here] end
	bedReservesOppositeRelation = 'registration';
	bedReservesRelations: ModelRelation[] = this.bedReservesMultiCrudActive ? BedReserveModel.getRelations()
		.map(relation => {
			if (relation.id === this.bedReservesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Diagnostic Examination Results here] off begin
	diagnosticExaminationResultsMultiCrudActive: boolean = false;
	diagnosticExaminationResultsDisplayName = 'Diagnostic Examination Results';
	diagnosticExaminationResultsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Diagnostic Examination Results here] end
	diagnosticExaminationResultsOppositeRelation = 'registration';
	diagnosticExaminationResultsRelations: ModelRelation[] = this.diagnosticExaminationResultsMultiCrudActive ? DiagnosticExaminationResultsModel.getRelations()
		.map(relation => {
			if (relation.id === this.diagnosticExaminationResultsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Fluid Balance Details here] off begin
	fluidBalanceDetailsMultiCrudActive: boolean = false;
	fluidBalanceDetailsDisplayName = 'Fluid Balance Details';
	fluidBalanceDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Fluid Balance Details here] end
	fluidBalanceDetailsOppositeRelation = 'registration';
	fluidBalanceDetailsRelations: ModelRelation[] = this.fluidBalanceDetailsMultiCrudActive ? FluidBalanceDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.fluidBalanceDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Informed Consents here] off begin
	informedConsentsMultiCrudActive: boolean = false;
	informedConsentsDisplayName = 'Informed Consents';
	informedConsentsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Informed Consents here] end
	informedConsentsOppositeRelation = 'registration';
	informedConsentsRelations: ModelRelation[] = this.informedConsentsMultiCrudActive ? InformedConsentModel.getRelations()
		.map(relation => {
			if (relation.id === this.informedConsentsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service Number and Invoice Items here] off begin
	invoiceItemsMultiCrudActive: boolean = false;
	invoiceItemsDisplayName = 'Invoice Items';
	invoiceItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Service Number and Invoice Items here] end
	invoiceItemsOppositeRelation = 'serviceNumber';
	invoiceItemsRelations: ModelRelation[] = this.invoiceItemsMultiCrudActive ? InvoiceItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoiceItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Fees here] off begin
	medicalFeesMultiCrudActive: boolean = false;
	medicalFeesDisplayName = 'Medical Fees';
	medicalFeesCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Fees here] end
	medicalFeesOppositeRelation = 'registration';
	medicalFeesRelations: ModelRelation[] = this.medicalFeesMultiCrudActive ? MedicalFeeModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalFeesOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medication Headers here] off begin
	medicationHeadersMultiCrudActive: boolean = false;
	medicationHeadersDisplayName = 'Medication Headers';
	medicationHeadersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medication Headers here] end
	medicationHeadersOppositeRelation = 'registration';
	medicationHeadersRelations: ModelRelation[] = this.medicationHeadersMultiCrudActive ? MedicationHeaderModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicationHeadersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Patient Vital Informations here] off begin
	patientVitalInformationsMultiCrudActive: boolean = false;
	patientVitalInformationsDisplayName = 'Patient Vital Informations';
	patientVitalInformationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Patient Vital Informations here] end
	patientVitalInformationsOppositeRelation = 'registration';
	patientVitalInformationsRelations: ModelRelation[] = this.patientVitalInformationsMultiCrudActive ? PatientVitalInformationModel.getRelations()
		.map(relation => {
			if (relation.id === this.patientVitalInformationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Prescription Headers here] off begin
	prescriptionHeadersMultiCrudActive: boolean = false;
	prescriptionHeadersDisplayName = 'Prescription Headers';
	prescriptionHeadersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Prescription Headers here] end
	prescriptionHeadersOppositeRelation = 'registration';
	prescriptionHeadersRelations: ModelRelation[] = this.prescriptionHeadersMultiCrudActive ? PrescriptionHeaderModel.getRelations()
		.map(relation => {
			if (relation.id === this.prescriptionHeadersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Sample Collection Informations here] off begin
	sampleCollectionInformationsMultiCrudActive: boolean = false;
	sampleCollectionInformationsDisplayName = 'Sample Collection Informations';
	sampleCollectionInformationsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Sample Collection Informations here] end
	sampleCollectionInformationsOppositeRelation = 'registration';
	sampleCollectionInformationsRelations: ModelRelation[] = this.sampleCollectionInformationsMultiCrudActive ? SampleCollectionInformationModel.getRelations()
		.map(relation => {
			if (relation.id === this.sampleCollectionInformationsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Vaccination Orders here] off begin
	vaccinationOrdersMultiCrudActive: boolean = false;
	vaccinationOrdersDisplayName = 'Vaccination Orders';
	vaccinationOrdersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Vaccination Orders here] end
	vaccinationOrdersOppositeRelation = 'registration';
	vaccinationOrdersRelations: ModelRelation[] = this.vaccinationOrdersMultiCrudActive ? VaccinationOrderModel.getRelations()
		.map(relation => {
			if (relation.id === this.vaccinationOrdersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Examination Items and Registrations here] off begin
	examinationItemsMultiCrudActive: boolean = false;
	examinationItemsDisplayName = 'Examination Items';
	examinationItemsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Examination Items and Registrations here] end
	examinationItemsOppositeRelation = 'registrations';
	examinationItemsRelations: ModelRelation[] = this.examinationItemsMultiCrudActive ? ExaminationItemModel.getRelations()
		.map(relation => {
			if (relation.id === this.examinationItemsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = RegistrationModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = RegistrationModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = RegistrationModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'bpjsPRBDetail' && this.bpjsPRBDetailMultiCrudActive) {
					exp.fields = BpjsPRBDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsPcareRegistrations' && this.bpjsPcareRegistrationsMultiCrudActive) {
					exp.fields = BpjsPcareRegistrationsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsSEP' && this.bpjsSEPMultiCrudActive) {
					exp.fields = BpjsSEPModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateDischargeResume' && this.medicalCertificateDischargeResumeMultiCrudActive) {
					exp.fields = MedicalCertificateDischargeResumeModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateBirth' && this.medicalCertificateBirthMultiCrudActive) {
					exp.fields = MedicalCertificateBirthModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateHospitalization' && this.medicalCertificateHospitalizationMultiCrudActive) {
					exp.fields = MedicalCertificateHospitalizationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateMedicalAttendance' && this.medicalCertificateMedicalAttendanceMultiCrudActive) {
					exp.fields = MedicalCertificateMedicalAttendanceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateMentalHealth' && this.medicalCertificateMentalHealthMultiCrudActive) {
					exp.fields = MedicalCertificateMentalHealthModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificatePhysicalHealth' && this.medicalCertificatePhysicalHealthMultiCrudActive) {
					exp.fields = MedicalCertificatePhysicalHealthModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateRestrictedWork' && this.medicalCertificateRestrictedWorkMultiCrudActive) {
					exp.fields = MedicalCertificateRestrictedWorkModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalCertificateSickLeave' && this.medicalCertificateSickLeaveMultiCrudActive) {
					exp.fields = MedicalCertificateSickLeaveModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalExaminationRecord' && this.medicalExaminationRecordMultiCrudActive) {
					exp.fields = MedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'pcareExamination' && this.pcareExaminationMultiCrudActive) {
					exp.fields = PcareExaminationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'sep' && this.sepMultiCrudActive) {
					exp.fields = SepModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'diagnosticStaffExaminationSummary' && this.diagnosticStaffExaminationSummaryMultiCrudActive) {
					exp.fields = DiagnosticStaffExaminationSummaryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'admissionICD10' && this.admissionICD10MultiCrudActive) {
					exp.fields = DiagnosesAndProceduresModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'admissionICD9CM' && this.admissionICD9CMMultiCrudActive) {
					exp.fields = DiagnosesAndProceduresModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'dismissalReferringFacility' && this.dismissalReferringFacilityMultiCrudActive) {
					exp.fields = HealthFacilityModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'dismissalReferringStaff' && this.dismissalReferringStaffMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'referringUnit' && this.referringUnitMultiCrudActive) {
					exp.fields = ServiceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'referringFacility' && this.referringFacilityMultiCrudActive) {
					exp.fields = HealthFacilityModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bedFacility' && this.bedFacilityMultiCrudActive) {
					exp.fields = BedFacilityModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientVisit' && this.patientVisitMultiCrudActive) {
					exp.fields = PatientVisitModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'service' && this.serviceMultiCrudActive) {
					exp.fields = ServiceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'staff' && this.staffMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'requestedBy' && this.requestedByMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bedReserves' && this.bedReservesMultiCrudActive) {
					exp.fields = BedReserveModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'diagnosticExaminationResults' && this.diagnosticExaminationResultsMultiCrudActive) {
					exp.fields = DiagnosticExaminationResultsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'fluidBalanceDetails' && this.fluidBalanceDetailsMultiCrudActive) {
					exp.fields = FluidBalanceDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'informedConsents' && this.informedConsentsMultiCrudActive) {
					exp.fields = InformedConsentModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoiceItems' && this.invoiceItemsMultiCrudActive) {
					exp.fields = InvoiceItemModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalFees' && this.medicalFeesMultiCrudActive) {
					exp.fields = MedicalFeeModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicationHeaders' && this.medicationHeadersMultiCrudActive) {
					exp.fields = MedicationHeaderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'patientVitalInformations' && this.patientVitalInformationsMultiCrudActive) {
					exp.fields = PatientVitalInformationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'prescriptionHeaders' && this.prescriptionHeadersMultiCrudActive) {
					exp.fields = PrescriptionHeaderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'sampleCollectionInformations' && this.sampleCollectionInformationsMultiCrudActive) {
					exp.fields = SampleCollectionInformationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'vaccinationOrders' && this.vaccinationOrdersMultiCrudActive) {
					exp.fields = VaccinationOrderModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'examinationItems' && this.examinationItemsMultiCrudActive) {
					exp.fields = ExaminationItemModel.getProps().map(prop => {
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
	targetModel: RegistrationModel;

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
		private readonly store: Store<{ model: RegistrationModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountRegistrationModels).subscribe(count => {
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

			this.targetModel = new RegistrationModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.registrationAudits$ = this.store.select(getRegistrationModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<RegistrationModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.RegistrationAction(
			modelAction.RegistrationModelActionTypes.FETCH_REGISTRATION,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getRegistrationModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new RegistrationModel(model);
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

			if (this.routerState.queryParams.listPage) {
				extras.queryParams = {listPage: this.routerState.queryParams.listPage};
			}

			const commands = [];

			commands.push('admin');
			commands.push('entities');
			commands.push('registration');

			if (tileMode !== CrudTileMode.List) {
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

		this.store.dispatch(new modelAction.RegistrationAction(
			modelAction.RegistrationModelActionTypes.FETCH_REGISTRATION_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<RegistrationModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.diagnosticStaffExaminationSummaryMultiCrudActive || this.bpjsPRBDetailMultiCrudActive || this.bpjsPcareRegistrationsMultiCrudActive || this.bpjsSEPMultiCrudActive || this.medicalCertificateDischargeResumeMultiCrudActive || this.medicalCertificateBirthMultiCrudActive || this.medicalCertificateHospitalizationMultiCrudActive || this.medicalCertificateMedicalAttendanceMultiCrudActive || this.medicalCertificateMentalHealthMultiCrudActive || this.medicalCertificatePhysicalHealthMultiCrudActive || this.medicalCertificateRestrictedWorkMultiCrudActive || this.medicalCertificateSickLeaveMultiCrudActive || this.medicalExaminationRecordMultiCrudActive || this.pcareExaminationMultiCrudActive || this.sepMultiCrudActive || this.admissionICD10MultiCrudActive || this.admissionICD9CMMultiCrudActive || this.dismissalReferringFacilityMultiCrudActive || this.dismissalReferringStaffMultiCrudActive || this.referringUnitMultiCrudActive || this.referringFacilityMultiCrudActive || this.bedFacilityMultiCrudActive || this.patientVisitMultiCrudActive || this.serviceMultiCrudActive || this.staffMultiCrudActive || this.requestedByMultiCrudActive || this.bedReservesMultiCrudActive || this.diagnosticExaminationResultsMultiCrudActive || this.fluidBalanceDetailsMultiCrudActive || this.informedConsentsMultiCrudActive || this.invoiceItemsMultiCrudActive || this.medicalFeesMultiCrudActive || this.medicationHeadersMultiCrudActive || this.patientVitalInformationsMultiCrudActive || this.prescriptionHeadersMultiCrudActive || this.sampleCollectionInformationsMultiCrudActive || this.vaccinationOrdersMultiCrudActive || this.examinationItemsMultiCrudActive,
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
					new modelAction.RegistrationAction(
						modelAction.RegistrationModelActionTypes.COUNT_REGISTRATIONS,
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

			this.store.dispatch(new modelAction.RegistrationAction(
				modelAction.RegistrationModelActionTypes.CREATE_REGISTRATION,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<RegistrationModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.diagnosticStaffExaminationSummaryMultiCrudActive || this.bpjsPRBDetailMultiCrudActive || this.bpjsPcareRegistrationsMultiCrudActive || this.bpjsSEPMultiCrudActive || this.medicalCertificateDischargeResumeMultiCrudActive || this.medicalCertificateBirthMultiCrudActive || this.medicalCertificateHospitalizationMultiCrudActive || this.medicalCertificateMedicalAttendanceMultiCrudActive || this.medicalCertificateMentalHealthMultiCrudActive || this.medicalCertificatePhysicalHealthMultiCrudActive || this.medicalCertificateRestrictedWorkMultiCrudActive || this.medicalCertificateSickLeaveMultiCrudActive || this.medicalExaminationRecordMultiCrudActive || this.pcareExaminationMultiCrudActive || this.sepMultiCrudActive || this.admissionICD10MultiCrudActive || this.admissionICD9CMMultiCrudActive || this.dismissalReferringFacilityMultiCrudActive || this.dismissalReferringStaffMultiCrudActive || this.referringUnitMultiCrudActive || this.referringFacilityMultiCrudActive || this.bedFacilityMultiCrudActive || this.patientVisitMultiCrudActive || this.serviceMultiCrudActive || this.staffMultiCrudActive || this.requestedByMultiCrudActive || this.bedReservesMultiCrudActive || this.diagnosticExaminationResultsMultiCrudActive || this.fluidBalanceDetailsMultiCrudActive || this.informedConsentsMultiCrudActive || this.invoiceItemsMultiCrudActive || this.medicalFeesMultiCrudActive || this.medicationHeadersMultiCrudActive || this.patientVitalInformationsMultiCrudActive || this.prescriptionHeadersMultiCrudActive || this.sampleCollectionInformationsMultiCrudActive || this.vaccinationOrdersMultiCrudActive || this.examinationItemsMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.RegistrationAction(
					modelAction.RegistrationModelActionTypes.FETCH_REGISTRATION,
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

			this.store.dispatch(new modelAction.RegistrationAction(
				modelAction.RegistrationModelActionTypes.UPDATE_REGISTRATION,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: RegistrationModel = new RegistrationModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getRegistrationModelWithId, this.targetModelId).subscribe(model => {
					let differences = new RegistrationModel(model).difference(updatedModel);

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
			if (event.entityName === this.diagnosticStaffExaminationSummaryDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosticStaffExaminationSummaryModel.getProps(), this.diagnosticStaffExaminationSummaryRelations, this.isViewOnly),
					new DiagnosticStaffExaminationSummaryModel(),
					DiagnosticStaffExaminationSummaryModel,
					this.diagnosticStaffExaminationSummaryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosticStaffExaminationSummaryRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsPRBDetailDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPRBDetailModel.getProps(), this.bpjsPRBDetailRelations, this.isViewOnly),
					new BpjsPRBDetailModel(),
					BpjsPRBDetailModel,
					this.bpjsPRBDetailDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPRBDetailRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsPcareRegistrationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPcareRegistrationsModel.getProps(), this.bpjsPcareRegistrationsRelations, this.isViewOnly),
					new BpjsPcareRegistrationsModel(),
					BpjsPcareRegistrationsModel,
					this.bpjsPcareRegistrationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPcareRegistrationsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsSEPDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsSEPModel.getProps(), this.bpjsSEPRelations, this.isViewOnly),
					new BpjsSEPModel(),
					BpjsSEPModel,
					this.bpjsSEPDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsSEPRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateDischargeResumeDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateDischargeResumeModel.getProps(), this.medicalCertificateDischargeResumeRelations, this.isViewOnly),
					new MedicalCertificateDischargeResumeModel(),
					MedicalCertificateDischargeResumeModel,
					this.medicalCertificateDischargeResumeDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateDischargeResumeRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateBirthDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateBirthModel.getProps(), this.medicalCertificateBirthRelations, this.isViewOnly),
					new MedicalCertificateBirthModel(),
					MedicalCertificateBirthModel,
					this.medicalCertificateBirthDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateBirthRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateHospitalizationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateHospitalizationModel.getProps(), this.medicalCertificateHospitalizationRelations, this.isViewOnly),
					new MedicalCertificateHospitalizationModel(),
					MedicalCertificateHospitalizationModel,
					this.medicalCertificateHospitalizationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateHospitalizationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateMedicalAttendanceDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateMedicalAttendanceModel.getProps(), this.medicalCertificateMedicalAttendanceRelations, this.isViewOnly),
					new MedicalCertificateMedicalAttendanceModel(),
					MedicalCertificateMedicalAttendanceModel,
					this.medicalCertificateMedicalAttendanceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateMedicalAttendanceRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateMentalHealthDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateMentalHealthModel.getProps(), this.medicalCertificateMentalHealthRelations, this.isViewOnly),
					new MedicalCertificateMentalHealthModel(),
					MedicalCertificateMentalHealthModel,
					this.medicalCertificateMentalHealthDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateMentalHealthRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificatePhysicalHealthDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificatePhysicalHealthModel.getProps(), this.medicalCertificatePhysicalHealthRelations, this.isViewOnly),
					new MedicalCertificatePhysicalHealthModel(),
					MedicalCertificatePhysicalHealthModel,
					this.medicalCertificatePhysicalHealthDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificatePhysicalHealthRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateRestrictedWorkDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateRestrictedWorkModel.getProps(), this.medicalCertificateRestrictedWorkRelations, this.isViewOnly),
					new MedicalCertificateRestrictedWorkModel(),
					MedicalCertificateRestrictedWorkModel,
					this.medicalCertificateRestrictedWorkDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateRestrictedWorkRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalCertificateSickLeaveDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateSickLeaveModel.getProps(), this.medicalCertificateSickLeaveRelations, this.isViewOnly),
					new MedicalCertificateSickLeaveModel(),
					MedicalCertificateSickLeaveModel,
					this.medicalCertificateSickLeaveDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateSickLeaveRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalExaminationRecordDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalExaminationRecordModel.getProps(), this.medicalExaminationRecordRelations, this.isViewOnly),
					new MedicalExaminationRecordModel(),
					MedicalExaminationRecordModel,
					this.medicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalExaminationRecordRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.pcareExaminationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PcareExaminationModel.getProps(), this.pcareExaminationRelations, this.isViewOnly),
					new PcareExaminationModel(),
					PcareExaminationModel,
					this.pcareExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.pcareExaminationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.sepDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SepModel.getProps(), this.sepRelations, this.isViewOnly),
					new SepModel(),
					SepModel,
					this.sepDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.sepRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.admissionICD10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.admissionICD10Relations, this.isViewOnly),
					new DiagnosesAndProceduresModel(),
					DiagnosesAndProceduresModel,
					this.admissionICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.admissionICD10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.admissionICD9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.admissionICD9CMRelations, this.isViewOnly),
					new DiagnosesAndProceduresModel(),
					DiagnosesAndProceduresModel,
					this.admissionICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.admissionICD9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.dismissalReferringFacilityDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(HealthFacilityModel.getProps(), this.dismissalReferringFacilityRelations, this.isViewOnly),
					new HealthFacilityModel(),
					HealthFacilityModel,
					this.dismissalReferringFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dismissalReferringFacilityRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.dismissalReferringStaffDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.dismissalReferringStaffRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.dismissalReferringStaffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dismissalReferringStaffRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.referringUnitDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceModel.getProps(), this.referringUnitRelations, this.isViewOnly),
					new ServiceModel(),
					ServiceModel,
					this.referringUnitDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.referringUnitRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.referringFacilityDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(HealthFacilityModel.getProps(), this.referringFacilityRelations, this.isViewOnly),
					new HealthFacilityModel(),
					HealthFacilityModel,
					this.referringFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.referringFacilityRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bedFacilityDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BedFacilityModel.getProps(), this.bedFacilityRelations, this.isViewOnly),
					new BedFacilityModel(),
					BedFacilityModel,
					this.bedFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bedFacilityRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientVisitDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitModel.getProps(), this.patientVisitRelations, this.isViewOnly),
					new PatientVisitModel(),
					PatientVisitModel,
					this.patientVisitDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.serviceDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceModel.getProps(), this.serviceRelations, this.isViewOnly),
					new ServiceModel(),
					ServiceModel,
					this.serviceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.serviceRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.staffDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.staffRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.staffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.staffRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.requestedByDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.requestedByRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.requestedByDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.requestedByRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bedReservesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BedReserveModel.getProps(), this.bedReservesRelations, this.isViewOnly),
					new BedReserveModel(),
					BedReserveModel,
					this.bedReservesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bedReservesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.diagnosticExaminationResultsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosticExaminationResultsModel.getProps(), this.diagnosticExaminationResultsRelations, this.isViewOnly),
					new DiagnosticExaminationResultsModel(),
					DiagnosticExaminationResultsModel,
					this.diagnosticExaminationResultsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosticExaminationResultsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.fluidBalanceDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(FluidBalanceDetailModel.getProps(), this.fluidBalanceDetailsRelations, this.isViewOnly),
					new FluidBalanceDetailModel(),
					FluidBalanceDetailModel,
					this.fluidBalanceDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.fluidBalanceDetailsRelations,
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

			if (event.entityName === this.invoiceItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoiceItemModel.getProps(), this.invoiceItemsRelations, this.isViewOnly),
					new InvoiceItemModel(),
					InvoiceItemModel,
					this.invoiceItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoiceItemsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalFeesDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalFeeModel.getProps(), this.medicalFeesRelations, this.isViewOnly),
					new MedicalFeeModel(),
					MedicalFeeModel,
					this.medicalFeesDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalFeesRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicationHeadersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicationHeaderModel.getProps(), this.medicationHeadersRelations, this.isViewOnly),
					new MedicationHeaderModel(),
					MedicationHeaderModel,
					this.medicationHeadersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicationHeadersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.patientVitalInformationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVitalInformationModel.getProps(), this.patientVitalInformationsRelations, this.isViewOnly),
					new PatientVitalInformationModel(),
					PatientVitalInformationModel,
					this.patientVitalInformationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVitalInformationsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.prescriptionHeadersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PrescriptionHeaderModel.getProps(), this.prescriptionHeadersRelations, this.isViewOnly),
					new PrescriptionHeaderModel(),
					PrescriptionHeaderModel,
					this.prescriptionHeadersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.prescriptionHeadersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.sampleCollectionInformationsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SampleCollectionInformationModel.getProps(), this.sampleCollectionInformationsRelations, this.isViewOnly),
					new SampleCollectionInformationModel(),
					SampleCollectionInformationModel,
					this.sampleCollectionInformationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.sampleCollectionInformationsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.vaccinationOrdersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(VaccinationOrderModel.getProps(), this.vaccinationOrdersRelations, this.isViewOnly),
					new VaccinationOrderModel(),
					VaccinationOrderModel,
					this.vaccinationOrdersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.vaccinationOrdersRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.examinationItemsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ExaminationItemModel.getProps(), this.examinationItemsRelations, this.isViewOnly),
					new ExaminationItemModel(),
					ExaminationItemModel,
					this.examinationItemsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.examinationItemsRelations,
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
		this.modelProperties = RegistrationModel.getProps();
		this.modelRelations = RegistrationModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'diagnosticStaffExaminationSummary';
		}).hideElement = this.diagnosticStaffExaminationSummaryMultiCrudActive || this.modelRelations.find(rel => rel.id === 'diagnosticStaffExaminationSummary').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsPRBDetail';
		}).hideElement = this.bpjsPRBDetailMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsPRBDetail').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsPcareRegistrations';
		}).hideElement = this.bpjsPcareRegistrationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsPcareRegistrations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsSEP';
		}).hideElement = this.bpjsSEPMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsSEP').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateDischargeResume';
		}).hideElement = this.medicalCertificateDischargeResumeMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateDischargeResume').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateBirth';
		}).hideElement = this.medicalCertificateBirthMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateBirth').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateHospitalization';
		}).hideElement = this.medicalCertificateHospitalizationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateHospitalization').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateMedicalAttendance';
		}).hideElement = this.medicalCertificateMedicalAttendanceMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateMedicalAttendance').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateMentalHealth';
		}).hideElement = this.medicalCertificateMentalHealthMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateMentalHealth').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificatePhysicalHealth';
		}).hideElement = this.medicalCertificatePhysicalHealthMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificatePhysicalHealth').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateRestrictedWork';
		}).hideElement = this.medicalCertificateRestrictedWorkMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateRestrictedWork').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalCertificateSickLeave';
		}).hideElement = this.medicalCertificateSickLeaveMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalCertificateSickLeave').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalExaminationRecord';
		}).hideElement = this.medicalExaminationRecordMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalExaminationRecord').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'pcareExamination';
		}).hideElement = this.pcareExaminationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'pcareExamination').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'sep';
		}).hideElement = this.sepMultiCrudActive || this.modelRelations.find(rel => rel.id === 'sep').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'admissionICD10';
		}).hideElement = this.admissionICD10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'admissionICD10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'admissionICD9CM';
		}).hideElement = this.admissionICD9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'admissionICD9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'dismissalReferringFacility';
		}).hideElement = this.dismissalReferringFacilityMultiCrudActive || this.modelRelations.find(rel => rel.id === 'dismissalReferringFacility').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'dismissalReferringStaff';
		}).hideElement = this.dismissalReferringStaffMultiCrudActive || this.modelRelations.find(rel => rel.id === 'dismissalReferringStaff').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'referringUnit';
		}).hideElement = this.referringUnitMultiCrudActive || this.modelRelations.find(rel => rel.id === 'referringUnit').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'referringFacility';
		}).hideElement = this.referringFacilityMultiCrudActive || this.modelRelations.find(rel => rel.id === 'referringFacility').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bedFacility';
		}).hideElement = this.bedFacilityMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bedFacility').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientVisit';
		}).hideElement = this.patientVisitMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientVisit').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'service';
		}).hideElement = this.serviceMultiCrudActive || this.modelRelations.find(rel => rel.id === 'service').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'staff';
		}).hideElement = this.staffMultiCrudActive || this.modelRelations.find(rel => rel.id === 'staff').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'requestedBy';
		}).hideElement = this.requestedByMultiCrudActive || this.modelRelations.find(rel => rel.id === 'requestedBy').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bedReserves';
		}).hideElement = this.bedReservesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bedReserves').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'diagnosticExaminationResults';
		}).hideElement = this.diagnosticExaminationResultsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'diagnosticExaminationResults').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'fluidBalanceDetails';
		}).hideElement = this.fluidBalanceDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'fluidBalanceDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'informedConsents';
		}).hideElement = this.informedConsentsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'informedConsents').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoiceItems';
		}).hideElement = this.invoiceItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoiceItems').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalFees';
		}).hideElement = this.medicalFeesMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalFees').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicationHeaders';
		}).hideElement = this.medicationHeadersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicationHeaders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'patientVitalInformations';
		}).hideElement = this.patientVitalInformationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'patientVitalInformations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'prescriptionHeaders';
		}).hideElement = this.prescriptionHeadersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'prescriptionHeaders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'sampleCollectionInformations';
		}).hideElement = this.sampleCollectionInformationsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'sampleCollectionInformations').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'vaccinationOrders';
		}).hideElement = this.vaccinationOrdersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'vaccinationOrders').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'examinationItems';
		}).hideElement = this.examinationItemsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'examinationItems').hideElement;

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
		if (this.diagnosticStaffExaminationSummaryMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.diagnosticStaffExaminationSummaryDisplayName, many: false});
		}

		if (this.bpjsPRBDetailMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsPRBDetailDisplayName, many: false});
		}

		if (this.bpjsPcareRegistrationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsPcareRegistrationsDisplayName, many: false});
		}

		if (this.bpjsSEPMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsSEPDisplayName, many: false});
		}

		if (this.medicalCertificateDischargeResumeMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateDischargeResumeDisplayName, many: false});
		}

		if (this.medicalCertificateBirthMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateBirthDisplayName, many: false});
		}

		if (this.medicalCertificateHospitalizationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateHospitalizationDisplayName, many: false});
		}

		if (this.medicalCertificateMedicalAttendanceMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateMedicalAttendanceDisplayName, many: false});
		}

		if (this.medicalCertificateMentalHealthMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateMentalHealthDisplayName, many: false});
		}

		if (this.medicalCertificatePhysicalHealthMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificatePhysicalHealthDisplayName, many: false});
		}

		if (this.medicalCertificateRestrictedWorkMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateRestrictedWorkDisplayName, many: false});
		}

		if (this.medicalCertificateSickLeaveMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalCertificateSickLeaveDisplayName, many: false});
		}

		if (this.medicalExaminationRecordMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalExaminationRecordDisplayName, many: false});
		}

		if (this.pcareExaminationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.pcareExaminationDisplayName, many: false});
		}

		if (this.sepMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.sepDisplayName, many: false});
		}

		if (this.admissionICD10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.admissionICD10DisplayName, many: false});
		}

		if (this.admissionICD9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.admissionICD9CMDisplayName, many: false});
		}

		if (this.dismissalReferringFacilityMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.dismissalReferringFacilityDisplayName, many: false});
		}

		if (this.dismissalReferringStaffMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.dismissalReferringStaffDisplayName, many: false});
		}

		if (this.referringUnitMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.referringUnitDisplayName, many: false});
		}

		if (this.referringFacilityMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.referringFacilityDisplayName, many: false});
		}

		if (this.bedFacilityMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bedFacilityDisplayName, many: false});
		}

		if (this.patientVisitMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientVisitDisplayName, many: false});
		}

		if (this.serviceMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.serviceDisplayName, many: false});
		}

		if (this.staffMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.staffDisplayName, many: false});
		}

		if (this.requestedByMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.requestedByDisplayName, many: false});
		}

		if (this.bedReservesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bedReservesDisplayName, many: true});
			this.store.dispatch(new bedReserveModelAction.BedReserveAction(
				bedReserveModelAction.BedReserveModelActionTypes.INITIALISE_BED_RESERVE_COLLECTION_STATE,
				{
					collectionId: this.bedReservesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getBedReserveCollectionModels, this.bedReservesCollectionId).subscribe(models => {
				models.forEach(bedReserves => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(BedReserveModel.getProps(), this.bedReservesRelations, this.isViewOnly),
						bedReserves,
						BedReserveModel,
						this.bedReservesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.bedReservesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.diagnosticExaminationResultsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.diagnosticExaminationResultsDisplayName, many: true});
			this.store.dispatch(new diagnosticExaminationResultsModelAction.DiagnosticExaminationResultsAction(
				diagnosticExaminationResultsModelAction.DiagnosticExaminationResultsModelActionTypes.INITIALISE_DIAGNOSTIC_EXAMINATION_RESULTS_COLLECTION_STATE,
				{
					collectionId: this.diagnosticExaminationResultsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosticExaminationResultsCollectionModels, this.diagnosticExaminationResultsCollectionId).subscribe(models => {
				models.forEach(diagnosticExaminationResults => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DiagnosticExaminationResultsModel.getProps(), this.diagnosticExaminationResultsRelations, this.isViewOnly),
						diagnosticExaminationResults,
						DiagnosticExaminationResultsModel,
						this.diagnosticExaminationResultsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.diagnosticExaminationResultsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.fluidBalanceDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.fluidBalanceDetailsDisplayName, many: true});
			this.store.dispatch(new fluidBalanceDetailModelAction.FluidBalanceDetailAction(
				fluidBalanceDetailModelAction.FluidBalanceDetailModelActionTypes.INITIALISE_FLUID_BALANCE_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.fluidBalanceDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getFluidBalanceDetailCollectionModels, this.fluidBalanceDetailsCollectionId).subscribe(models => {
				models.forEach(fluidBalanceDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(FluidBalanceDetailModel.getProps(), this.fluidBalanceDetailsRelations, this.isViewOnly),
						fluidBalanceDetails,
						FluidBalanceDetailModel,
						this.fluidBalanceDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.fluidBalanceDetailsRelations,
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

		if (this.invoiceItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoiceItemsDisplayName, many: true});
			this.store.dispatch(new invoiceItemModelAction.InvoiceItemAction(
				invoiceItemModelAction.InvoiceItemModelActionTypes.INITIALISE_INVOICE_ITEM_COLLECTION_STATE,
				{
					collectionId: this.invoiceItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoiceItemCollectionModels, this.invoiceItemsCollectionId).subscribe(models => {
				models.forEach(invoiceItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InvoiceItemModel.getProps(), this.invoiceItemsRelations, this.isViewOnly),
						invoiceItems,
						InvoiceItemModel,
						this.invoiceItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.invoiceItemsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicalFeesMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalFeesDisplayName, many: true});
			this.store.dispatch(new medicalFeeModelAction.MedicalFeeAction(
				medicalFeeModelAction.MedicalFeeModelActionTypes.INITIALISE_MEDICAL_FEE_COLLECTION_STATE,
				{
					collectionId: this.medicalFeesCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalFeeCollectionModels, this.medicalFeesCollectionId).subscribe(models => {
				models.forEach(medicalFees => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalFeeModel.getProps(), this.medicalFeesRelations, this.isViewOnly),
						medicalFees,
						MedicalFeeModel,
						this.medicalFeesDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicalFeesRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.medicationHeadersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicationHeadersDisplayName, many: true});
			this.store.dispatch(new medicationHeaderModelAction.MedicationHeaderAction(
				medicationHeaderModelAction.MedicationHeaderModelActionTypes.INITIALISE_MEDICATION_HEADER_COLLECTION_STATE,
				{
					collectionId: this.medicationHeadersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicationHeaderCollectionModels, this.medicationHeadersCollectionId).subscribe(models => {
				models.forEach(medicationHeaders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicationHeaderModel.getProps(), this.medicationHeadersRelations, this.isViewOnly),
						medicationHeaders,
						MedicationHeaderModel,
						this.medicationHeadersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.medicationHeadersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.patientVitalInformationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.patientVitalInformationsDisplayName, many: true});
			this.store.dispatch(new patientVitalInformationModelAction.PatientVitalInformationAction(
				patientVitalInformationModelAction.PatientVitalInformationModelActionTypes.INITIALISE_PATIENT_VITAL_INFORMATION_COLLECTION_STATE,
				{
					collectionId: this.patientVitalInformationsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientVitalInformationCollectionModels, this.patientVitalInformationsCollectionId).subscribe(models => {
				models.forEach(patientVitalInformations => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PatientVitalInformationModel.getProps(), this.patientVitalInformationsRelations, this.isViewOnly),
						patientVitalInformations,
						PatientVitalInformationModel,
						this.patientVitalInformationsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.patientVitalInformationsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.prescriptionHeadersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.prescriptionHeadersDisplayName, many: true});
			this.store.dispatch(new prescriptionHeaderModelAction.PrescriptionHeaderAction(
				prescriptionHeaderModelAction.PrescriptionHeaderModelActionTypes.INITIALISE_PRESCRIPTION_HEADER_COLLECTION_STATE,
				{
					collectionId: this.prescriptionHeadersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPrescriptionHeaderCollectionModels, this.prescriptionHeadersCollectionId).subscribe(models => {
				models.forEach(prescriptionHeaders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PrescriptionHeaderModel.getProps(), this.prescriptionHeadersRelations, this.isViewOnly),
						prescriptionHeaders,
						PrescriptionHeaderModel,
						this.prescriptionHeadersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.prescriptionHeadersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.sampleCollectionInformationsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.sampleCollectionInformationsDisplayName, many: true});
			this.store.dispatch(new sampleCollectionInformationModelAction.SampleCollectionInformationAction(
				sampleCollectionInformationModelAction.SampleCollectionInformationModelActionTypes.INITIALISE_SAMPLE_COLLECTION_INFORMATION_COLLECTION_STATE,
				{
					collectionId: this.sampleCollectionInformationsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getSampleCollectionInformationCollectionModels, this.sampleCollectionInformationsCollectionId).subscribe(models => {
				models.forEach(sampleCollectionInformations => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(SampleCollectionInformationModel.getProps(), this.sampleCollectionInformationsRelations, this.isViewOnly),
						sampleCollectionInformations,
						SampleCollectionInformationModel,
						this.sampleCollectionInformationsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.sampleCollectionInformationsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.vaccinationOrdersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.vaccinationOrdersDisplayName, many: true});
			this.store.dispatch(new vaccinationOrderModelAction.VaccinationOrderAction(
				vaccinationOrderModelAction.VaccinationOrderModelActionTypes.INITIALISE_VACCINATION_ORDER_COLLECTION_STATE,
				{
					collectionId: this.vaccinationOrdersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getVaccinationOrderCollectionModels, this.vaccinationOrdersCollectionId).subscribe(models => {
				models.forEach(vaccinationOrders => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(VaccinationOrderModel.getProps(), this.vaccinationOrdersRelations, this.isViewOnly),
						vaccinationOrders,
						VaccinationOrderModel,
						this.vaccinationOrdersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.vaccinationOrdersRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.examinationItemsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.examinationItemsDisplayName, many: true});
			this.store.dispatch(new examinationItemModelAction.ExaminationItemAction(
				examinationItemModelAction.ExaminationItemModelActionTypes.INITIALISE_EXAMINATION_ITEM_COLLECTION_STATE,
				{
					collectionId: this.examinationItemsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getExaminationItemCollectionModels, this.examinationItemsCollectionId).subscribe(models => {
				models.forEach(examinationItems => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(ExaminationItemModel.getProps(), this.examinationItemsRelations, this.isViewOnly),
						examinationItems,
						ExaminationItemModel,
						this.examinationItemsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.examinationItemsRelations,
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
		if (this.targetModel.bpjsPRBDetail && this.targetModel.bpjsPRBDetail.id && this.bpjsPRBDetailMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsPRBDetailModel,
				this.bpjsPRBDetailOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsPRBDetail.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsPRBDetailModelWithId, this.targetModel.bpjsPRBDetailId).subscribe(bpjsPRBDetail => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPRBDetailModel.getProps(), this.bpjsPRBDetailRelations, this.isViewOnly),
					bpjsPRBDetail,
					BpjsPRBDetailModel,
					this.bpjsPRBDetailDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPRBDetailRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsPcareRegistrations && this.targetModel.bpjsPcareRegistrations.id && this.bpjsPcareRegistrationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsPcareRegistrationsModel,
				this.bpjsPcareRegistrationsOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsPcareRegistrations.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsPcareRegistrationsModelWithId, this.targetModel.bpjsPcareRegistrationsId).subscribe(bpjsPcareRegistrations => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsPcareRegistrationsModel.getProps(), this.bpjsPcareRegistrationsRelations, this.isViewOnly),
					bpjsPcareRegistrations,
					BpjsPcareRegistrationsModel,
					this.bpjsPcareRegistrationsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsPcareRegistrationsRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsSEP && this.targetModel.bpjsSEP.id && this.bpjsSEPMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsSEPModel,
				this.bpjsSEPOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsSEP.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsSEPModelWithId, this.targetModel.bpjsSEPId).subscribe(bpjsSEP => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsSEPModel.getProps(), this.bpjsSEPRelations, this.isViewOnly),
					bpjsSEP,
					BpjsSEPModel,
					this.bpjsSEPDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsSEPRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalCertificateDischargeResume && this.targetModel.medicalCertificateDischargeResume.id && this.medicalCertificateDischargeResumeMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateDischargeResumeModel,
				this.medicalCertificateDischargeResumeOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalCertificateDischargeResume.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateDischargeResumeModelWithId, this.targetModel.medicalCertificateDischargeResumeId).subscribe(medicalCertificateDischargeResume => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateDischargeResumeModel.getProps(), this.medicalCertificateDischargeResumeRelations, this.isViewOnly),
					medicalCertificateDischargeResume,
					MedicalCertificateDischargeResumeModel,
					this.medicalCertificateDischargeResumeDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateDischargeResumeRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalCertificateBirth && this.targetModel.medicalCertificateBirth.id && this.medicalCertificateBirthMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateBirthModel,
				this.medicalCertificateBirthOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalCertificateBirth.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateBirthModelWithId, this.targetModel.medicalCertificateBirthId).subscribe(medicalCertificateBirth => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateBirthModel.getProps(), this.medicalCertificateBirthRelations, this.isViewOnly),
					medicalCertificateBirth,
					MedicalCertificateBirthModel,
					this.medicalCertificateBirthDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateBirthRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalCertificateHospitalization && this.targetModel.medicalCertificateHospitalization.id && this.medicalCertificateHospitalizationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateHospitalizationModel,
				this.medicalCertificateHospitalizationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalCertificateHospitalization.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateHospitalizationModelWithId, this.targetModel.medicalCertificateHospitalizationId).subscribe(medicalCertificateHospitalization => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateHospitalizationModel.getProps(), this.medicalCertificateHospitalizationRelations, this.isViewOnly),
					medicalCertificateHospitalization,
					MedicalCertificateHospitalizationModel,
					this.medicalCertificateHospitalizationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateHospitalizationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalCertificateMedicalAttendance && this.targetModel.medicalCertificateMedicalAttendance.id && this.medicalCertificateMedicalAttendanceMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateMedicalAttendanceModel,
				this.medicalCertificateMedicalAttendanceOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalCertificateMedicalAttendance.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateMedicalAttendanceModelWithId, this.targetModel.medicalCertificateMedicalAttendanceId).subscribe(medicalCertificateMedicalAttendance => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateMedicalAttendanceModel.getProps(), this.medicalCertificateMedicalAttendanceRelations, this.isViewOnly),
					medicalCertificateMedicalAttendance,
					MedicalCertificateMedicalAttendanceModel,
					this.medicalCertificateMedicalAttendanceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateMedicalAttendanceRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalCertificateMentalHealth && this.targetModel.medicalCertificateMentalHealth.id && this.medicalCertificateMentalHealthMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateMentalHealthModel,
				this.medicalCertificateMentalHealthOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalCertificateMentalHealth.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateMentalHealthModelWithId, this.targetModel.medicalCertificateMentalHealthId).subscribe(medicalCertificateMentalHealth => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateMentalHealthModel.getProps(), this.medicalCertificateMentalHealthRelations, this.isViewOnly),
					medicalCertificateMentalHealth,
					MedicalCertificateMentalHealthModel,
					this.medicalCertificateMentalHealthDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateMentalHealthRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalCertificatePhysicalHealth && this.targetModel.medicalCertificatePhysicalHealth.id && this.medicalCertificatePhysicalHealthMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificatePhysicalHealthModel,
				this.medicalCertificatePhysicalHealthOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalCertificatePhysicalHealth.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificatePhysicalHealthModelWithId, this.targetModel.medicalCertificatePhysicalHealthId).subscribe(medicalCertificatePhysicalHealth => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificatePhysicalHealthModel.getProps(), this.medicalCertificatePhysicalHealthRelations, this.isViewOnly),
					medicalCertificatePhysicalHealth,
					MedicalCertificatePhysicalHealthModel,
					this.medicalCertificatePhysicalHealthDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificatePhysicalHealthRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalCertificateRestrictedWork && this.targetModel.medicalCertificateRestrictedWork.id && this.medicalCertificateRestrictedWorkMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateRestrictedWorkModel,
				this.medicalCertificateRestrictedWorkOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalCertificateRestrictedWork.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateRestrictedWorkModelWithId, this.targetModel.medicalCertificateRestrictedWorkId).subscribe(medicalCertificateRestrictedWork => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateRestrictedWorkModel.getProps(), this.medicalCertificateRestrictedWorkRelations, this.isViewOnly),
					medicalCertificateRestrictedWork,
					MedicalCertificateRestrictedWorkModel,
					this.medicalCertificateRestrictedWorkDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateRestrictedWorkRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalCertificateSickLeave && this.targetModel.medicalCertificateSickLeave.id && this.medicalCertificateSickLeaveMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateSickLeaveModel,
				this.medicalCertificateSickLeaveOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalCertificateSickLeave.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateSickLeaveModelWithId, this.targetModel.medicalCertificateSickLeaveId).subscribe(medicalCertificateSickLeave => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateSickLeaveModel.getProps(), this.medicalCertificateSickLeaveRelations, this.isViewOnly),
					medicalCertificateSickLeave,
					MedicalCertificateSickLeaveModel,
					this.medicalCertificateSickLeaveDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalCertificateSickLeaveRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalExaminationRecord && this.targetModel.medicalExaminationRecord.id && this.medicalExaminationRecordMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalExaminationRecordModel,
				this.medicalExaminationRecordOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalExaminationRecord.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalExaminationRecordModelWithId, this.targetModel.medicalExaminationRecordId).subscribe(medicalExaminationRecord => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalExaminationRecordModel.getProps(), this.medicalExaminationRecordRelations, this.isViewOnly),
					medicalExaminationRecord,
					MedicalExaminationRecordModel,
					this.medicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalExaminationRecordRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.pcareExamination && this.targetModel.pcareExamination.id && this.pcareExaminationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PcareExaminationModel,
				this.pcareExaminationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.pcareExamination.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPcareExaminationModelWithId, this.targetModel.pcareExaminationId).subscribe(pcareExamination => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PcareExaminationModel.getProps(), this.pcareExaminationRelations, this.isViewOnly),
					pcareExamination,
					PcareExaminationModel,
					this.pcareExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.pcareExaminationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.sep && this.targetModel.sep.id && this.sepMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SepModel,
				this.sepOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.sep.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getSepModelWithId, this.targetModel.sepId).subscribe(sep => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(SepModel.getProps(), this.sepRelations, this.isViewOnly),
					sep,
					SepModel,
					this.sepDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.sepRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.diagnosticStaffExaminationSummary && this.targetModel.diagnosticStaffExaminationSummary.id && this.diagnosticStaffExaminationSummaryMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosticStaffExaminationSummaryModel,
				this.diagnosticStaffExaminationSummaryOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.diagnosticStaffExaminationSummary.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosticStaffExaminationSummaryModelWithId, this.targetModel.diagnosticStaffExaminationSummaryId).subscribe(diagnosticStaffExaminationSummary => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosticStaffExaminationSummaryModel.getProps(), this.diagnosticStaffExaminationSummaryRelations, this.isViewOnly),
					diagnosticStaffExaminationSummary,
					DiagnosticStaffExaminationSummaryModel,
					this.diagnosticStaffExaminationSummaryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosticStaffExaminationSummaryRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.admissionICD10 && this.targetModel.admissionICD10.id && this.admissionICD10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosesAndProceduresModel,
				this.admissionICD10OppositeRelation,
				this.collectionId,
				1,
				this.targetModel.admissionICD10.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosesAndProceduresModelWithId, this.targetModel.admissionICD10Id).subscribe(admissionICD10 => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.admissionICD10Relations, this.isViewOnly),
					admissionICD10,
					DiagnosesAndProceduresModel,
					this.admissionICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.admissionICD10Relations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.admissionICD9CM && this.targetModel.admissionICD9CM.id && this.admissionICD9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosesAndProceduresModel,
				this.admissionICD9CMOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.admissionICD9CM.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosesAndProceduresModelWithId, this.targetModel.admissionICD9CMId).subscribe(admissionICD9CM => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosesAndProceduresModel.getProps(), this.admissionICD9CMRelations, this.isViewOnly),
					admissionICD9CM,
					DiagnosesAndProceduresModel,
					this.admissionICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.admissionICD9CMRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.dismissalReferringFacility && this.targetModel.dismissalReferringFacility.id && this.dismissalReferringFacilityMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				HealthFacilityModel,
				this.dismissalReferringFacilityOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.dismissalReferringFacility.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getHealthFacilityModelWithId, this.targetModel.dismissalReferringFacilityId).subscribe(dismissalReferringFacility => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(HealthFacilityModel.getProps(), this.dismissalReferringFacilityRelations, this.isViewOnly),
					dismissalReferringFacility,
					HealthFacilityModel,
					this.dismissalReferringFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dismissalReferringFacilityRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.dismissalReferringStaff && this.targetModel.dismissalReferringStaff.id && this.dismissalReferringStaffMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.dismissalReferringStaffOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.dismissalReferringStaff.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.dismissalReferringStaffId).subscribe(dismissalReferringStaff => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.dismissalReferringStaffRelations, this.isViewOnly),
					dismissalReferringStaff,
					StaffModel,
					this.dismissalReferringStaffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dismissalReferringStaffRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.referringUnit && this.targetModel.referringUnit.id && this.referringUnitMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ServiceModel,
				this.referringUnitOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.referringUnit.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getServiceModelWithId, this.targetModel.referringUnitId).subscribe(referringUnit => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceModel.getProps(), this.referringUnitRelations, this.isViewOnly),
					referringUnit,
					ServiceModel,
					this.referringUnitDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.referringUnitRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.referringFacility && this.targetModel.referringFacility.id && this.referringFacilityMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				HealthFacilityModel,
				this.referringFacilityOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.referringFacility.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getHealthFacilityModelWithId, this.targetModel.referringFacilityId).subscribe(referringFacility => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(HealthFacilityModel.getProps(), this.referringFacilityRelations, this.isViewOnly),
					referringFacility,
					HealthFacilityModel,
					this.referringFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.referringFacilityRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bedFacility && this.targetModel.bedFacility.id && this.bedFacilityMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BedFacilityModel,
				this.bedFacilityOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bedFacility.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBedFacilityModelWithId, this.targetModel.bedFacilityId).subscribe(bedFacility => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BedFacilityModel.getProps(), this.bedFacilityRelations, this.isViewOnly),
					bedFacility,
					BedFacilityModel,
					this.bedFacilityDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bedFacilityRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.patientVisit && this.targetModel.patientVisit.id && this.patientVisitMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientVisitModel,
				this.patientVisitOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.patientVisit.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getPatientVisitModelWithId, this.targetModel.patientVisitId).subscribe(patientVisit => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PatientVisitModel.getProps(), this.patientVisitRelations, this.isViewOnly),
					patientVisit,
					PatientVisitModel,
					this.patientVisitDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.patientVisitRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.service && this.targetModel.service.id && this.serviceMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ServiceModel,
				this.serviceOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.service.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getServiceModelWithId, this.targetModel.serviceId).subscribe(service => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ServiceModel.getProps(), this.serviceRelations, this.isViewOnly),
					service,
					ServiceModel,
					this.serviceDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.serviceRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.staff && this.targetModel.staff.id && this.staffMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.staffOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.staff.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.staffId).subscribe(staff => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.staffRelations, this.isViewOnly),
					staff,
					StaffModel,
					this.staffDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.staffRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.requestedBy && this.targetModel.requestedBy.id && this.requestedByMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.requestedByOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.requestedBy.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.requestedById).subscribe(requestedBy => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.requestedByRelations, this.isViewOnly),
					requestedBy,
					StaffModel,
					this.requestedByDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.requestedByRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bedReservesIds && this.targetModel.bedReservesIds.length > 0 && this.bedReservesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BedReserveModel,
				this.bedReservesOppositeRelation,
				this.bedReservesCollectionId,
				this.targetModel.bedReservesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.diagnosticExaminationResultsIds && this.targetModel.diagnosticExaminationResultsIds.length > 0 && this.diagnosticExaminationResultsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosticExaminationResultsModel,
				this.diagnosticExaminationResultsOppositeRelation,
				this.diagnosticExaminationResultsCollectionId,
				this.targetModel.diagnosticExaminationResultsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.fluidBalanceDetailsIds && this.targetModel.fluidBalanceDetailsIds.length > 0 && this.fluidBalanceDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				FluidBalanceDetailModel,
				this.fluidBalanceDetailsOppositeRelation,
				this.fluidBalanceDetailsCollectionId,
				this.targetModel.fluidBalanceDetailsIds.length,
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

		if (this.targetModel.invoiceItemsIds && this.targetModel.invoiceItemsIds.length > 0 && this.invoiceItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoiceItemModel,
				this.invoiceItemsOppositeRelation,
				this.invoiceItemsCollectionId,
				this.targetModel.invoiceItemsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicalFeesIds && this.targetModel.medicalFeesIds.length > 0 && this.medicalFeesMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalFeeModel,
				this.medicalFeesOppositeRelation,
				this.medicalFeesCollectionId,
				this.targetModel.medicalFeesIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.medicationHeadersIds && this.targetModel.medicationHeadersIds.length > 0 && this.medicationHeadersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicationHeaderModel,
				this.medicationHeadersOppositeRelation,
				this.medicationHeadersCollectionId,
				this.targetModel.medicationHeadersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.patientVitalInformationsIds && this.targetModel.patientVitalInformationsIds.length > 0 && this.patientVitalInformationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PatientVitalInformationModel,
				this.patientVitalInformationsOppositeRelation,
				this.patientVitalInformationsCollectionId,
				this.targetModel.patientVitalInformationsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.prescriptionHeadersIds && this.targetModel.prescriptionHeadersIds.length > 0 && this.prescriptionHeadersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PrescriptionHeaderModel,
				this.prescriptionHeadersOppositeRelation,
				this.prescriptionHeadersCollectionId,
				this.targetModel.prescriptionHeadersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.sampleCollectionInformationsIds && this.targetModel.sampleCollectionInformationsIds.length > 0 && this.sampleCollectionInformationsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				SampleCollectionInformationModel,
				this.sampleCollectionInformationsOppositeRelation,
				this.sampleCollectionInformationsCollectionId,
				this.targetModel.sampleCollectionInformationsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.vaccinationOrdersIds && this.targetModel.vaccinationOrdersIds.length > 0 && this.vaccinationOrdersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				VaccinationOrderModel,
				this.vaccinationOrdersOppositeRelation,
				this.vaccinationOrdersCollectionId,
				this.targetModel.vaccinationOrdersIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.examinationItemsIds && this.targetModel.examinationItemsIds.length > 0 && this.examinationItemsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ExaminationItemModel,
				this.examinationItemsOppositeRelation,
				this.examinationItemsCollectionId,
				this.targetModel.examinationItemsIds.length,
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
	addAdditionalEntitiesToModel(model: RegistrationModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): RegistrationModel {
		let updatedModel: RegistrationModel = new RegistrationModel(model);

		if (this.diagnosticStaffExaminationSummaryMultiCrudActive) {
			updatedModel.diagnosticStaffExaminationSummary = event.additionalEntities.diagnosticStaffExaminationSummary ? event.additionalEntities.diagnosticStaffExaminationSummary : undefined;

			if (!updatedModel.diagnosticStaffExaminationSummary && event.payload) {
				event.payload.diagnosticStaffExaminationSummaryId = null;
			}
		} else if (event.payload?.diagnosticStaffExaminationSummaryId !== undefined) {
			event.payload.diagnosticStaffExaminationSummary = null;
			updatedModel.diagnosticStaffExaminationSummary = null;
		}

		if (this.bpjsPRBDetailMultiCrudActive) {
			updatedModel.bpjsPRBDetail = event.additionalEntities.bpjsPRBDetail ? event.additionalEntities.bpjsPRBDetail : undefined;

			if (!updatedModel.bpjsPRBDetail && event.payload) {
				event.payload.bpjsPRBDetailId = null;
			}
		} else if (event.payload?.bpjsPRBDetailId !== undefined) {
			event.payload.bpjsPRBDetail = null;
			updatedModel.bpjsPRBDetail = null;
		}

		if (this.bpjsPcareRegistrationsMultiCrudActive) {
			updatedModel.bpjsPcareRegistrations = event.additionalEntities.bpjsPcareRegistrations ? event.additionalEntities.bpjsPcareRegistrations : undefined;

			if (!updatedModel.bpjsPcareRegistrations && event.payload) {
				event.payload.bpjsPcareRegistrationsId = null;
			}
		} else if (event.payload?.bpjsPcareRegistrationsId !== undefined) {
			event.payload.bpjsPcareRegistrations = null;
			updatedModel.bpjsPcareRegistrations = null;
		}

		if (this.bpjsSEPMultiCrudActive) {
			updatedModel.bpjsSEP = event.additionalEntities.bpjsSEP ? event.additionalEntities.bpjsSEP : undefined;

			if (!updatedModel.bpjsSEP && event.payload) {
				event.payload.bpjsSEPId = null;
			}
		} else if (event.payload?.bpjsSEPId !== undefined) {
			event.payload.bpjsSEP = null;
			updatedModel.bpjsSEP = null;
		}

		if (this.medicalCertificateDischargeResumeMultiCrudActive) {
			updatedModel.medicalCertificateDischargeResume = event.additionalEntities.medicalCertificateDischargeResume ? event.additionalEntities.medicalCertificateDischargeResume : undefined;

			if (!updatedModel.medicalCertificateDischargeResume && event.payload) {
				event.payload.medicalCertificateDischargeResumeId = null;
			}
		} else if (event.payload?.medicalCertificateDischargeResumeId !== undefined) {
			event.payload.medicalCertificateDischargeResume = null;
			updatedModel.medicalCertificateDischargeResume = null;
		}

		if (this.medicalCertificateBirthMultiCrudActive) {
			updatedModel.medicalCertificateBirth = event.additionalEntities.medicalCertificateBirth ? event.additionalEntities.medicalCertificateBirth : undefined;

			if (!updatedModel.medicalCertificateBirth && event.payload) {
				event.payload.medicalCertificateBirthId = null;
			}
		} else if (event.payload?.medicalCertificateBirthId !== undefined) {
			event.payload.medicalCertificateBirth = null;
			updatedModel.medicalCertificateBirth = null;
		}

		if (this.medicalCertificateHospitalizationMultiCrudActive) {
			updatedModel.medicalCertificateHospitalization = event.additionalEntities.medicalCertificateHospitalization ? event.additionalEntities.medicalCertificateHospitalization : undefined;

			if (!updatedModel.medicalCertificateHospitalization && event.payload) {
				event.payload.medicalCertificateHospitalizationId = null;
			}
		} else if (event.payload?.medicalCertificateHospitalizationId !== undefined) {
			event.payload.medicalCertificateHospitalization = null;
			updatedModel.medicalCertificateHospitalization = null;
		}

		if (this.medicalCertificateMedicalAttendanceMultiCrudActive) {
			updatedModel.medicalCertificateMedicalAttendance = event.additionalEntities.medicalCertificateMedicalAttendance ? event.additionalEntities.medicalCertificateMedicalAttendance : undefined;

			if (!updatedModel.medicalCertificateMedicalAttendance && event.payload) {
				event.payload.medicalCertificateMedicalAttendanceId = null;
			}
		} else if (event.payload?.medicalCertificateMedicalAttendanceId !== undefined) {
			event.payload.medicalCertificateMedicalAttendance = null;
			updatedModel.medicalCertificateMedicalAttendance = null;
		}

		if (this.medicalCertificateMentalHealthMultiCrudActive) {
			updatedModel.medicalCertificateMentalHealth = event.additionalEntities.medicalCertificateMentalHealth ? event.additionalEntities.medicalCertificateMentalHealth : undefined;

			if (!updatedModel.medicalCertificateMentalHealth && event.payload) {
				event.payload.medicalCertificateMentalHealthId = null;
			}
		} else if (event.payload?.medicalCertificateMentalHealthId !== undefined) {
			event.payload.medicalCertificateMentalHealth = null;
			updatedModel.medicalCertificateMentalHealth = null;
		}

		if (this.medicalCertificatePhysicalHealthMultiCrudActive) {
			updatedModel.medicalCertificatePhysicalHealth = event.additionalEntities.medicalCertificatePhysicalHealth ? event.additionalEntities.medicalCertificatePhysicalHealth : undefined;

			if (!updatedModel.medicalCertificatePhysicalHealth && event.payload) {
				event.payload.medicalCertificatePhysicalHealthId = null;
			}
		} else if (event.payload?.medicalCertificatePhysicalHealthId !== undefined) {
			event.payload.medicalCertificatePhysicalHealth = null;
			updatedModel.medicalCertificatePhysicalHealth = null;
		}

		if (this.medicalCertificateRestrictedWorkMultiCrudActive) {
			updatedModel.medicalCertificateRestrictedWork = event.additionalEntities.medicalCertificateRestrictedWork ? event.additionalEntities.medicalCertificateRestrictedWork : undefined;

			if (!updatedModel.medicalCertificateRestrictedWork && event.payload) {
				event.payload.medicalCertificateRestrictedWorkId = null;
			}
		} else if (event.payload?.medicalCertificateRestrictedWorkId !== undefined) {
			event.payload.medicalCertificateRestrictedWork = null;
			updatedModel.medicalCertificateRestrictedWork = null;
		}

		if (this.medicalCertificateSickLeaveMultiCrudActive) {
			updatedModel.medicalCertificateSickLeave = event.additionalEntities.medicalCertificateSickLeave ? event.additionalEntities.medicalCertificateSickLeave : undefined;

			if (!updatedModel.medicalCertificateSickLeave && event.payload) {
				event.payload.medicalCertificateSickLeaveId = null;
			}
		} else if (event.payload?.medicalCertificateSickLeaveId !== undefined) {
			event.payload.medicalCertificateSickLeave = null;
			updatedModel.medicalCertificateSickLeave = null;
		}

		if (this.medicalExaminationRecordMultiCrudActive) {
			updatedModel.medicalExaminationRecord = event.additionalEntities.medicalExaminationRecord ? event.additionalEntities.medicalExaminationRecord : undefined;

			if (!updatedModel.medicalExaminationRecord && event.payload) {
				event.payload.medicalExaminationRecordId = null;
			}
		} else if (event.payload?.medicalExaminationRecordId !== undefined) {
			event.payload.medicalExaminationRecord = null;
			updatedModel.medicalExaminationRecord = null;
		}

		if (this.pcareExaminationMultiCrudActive) {
			updatedModel.pcareExamination = event.additionalEntities.pcareExamination ? event.additionalEntities.pcareExamination : undefined;

			if (!updatedModel.pcareExamination && event.payload) {
				event.payload.pcareExaminationId = null;
			}
		} else if (event.payload?.pcareExaminationId !== undefined) {
			event.payload.pcareExamination = null;
			updatedModel.pcareExamination = null;
		}

		if (this.sepMultiCrudActive) {
			updatedModel.sep = event.additionalEntities.sep ? event.additionalEntities.sep : undefined;

			if (!updatedModel.sep && event.payload) {
				event.payload.sepId = null;
			}
		} else if (event.payload?.sepId !== undefined) {
			event.payload.sep = null;
			updatedModel.sep = null;
		}

		if (this.admissionICD10MultiCrudActive) {
			updatedModel.admissionICD10 = event.additionalEntities.admissionICD10 ? event.additionalEntities.admissionICD10 : undefined;

			if (!updatedModel.admissionICD10 && event.payload) {
				event.payload.admissionICD10Id = null;
			}
		} else if (event.payload?.admissionICD10Id !== undefined) {
			event.payload.admissionICD10 = null;
			updatedModel.admissionICD10 = null;
		}

		if (this.admissionICD9CMMultiCrudActive) {
			updatedModel.admissionICD9CM = event.additionalEntities.admissionICD9CM ? event.additionalEntities.admissionICD9CM : undefined;

			if (!updatedModel.admissionICD9CM && event.payload) {
				event.payload.admissionICD9CMId = null;
			}
		} else if (event.payload?.admissionICD9CMId !== undefined) {
			event.payload.admissionICD9CM = null;
			updatedModel.admissionICD9CM = null;
		}

		if (this.dismissalReferringFacilityMultiCrudActive) {
			updatedModel.dismissalReferringFacility = event.additionalEntities.dismissalReferringFacility ? event.additionalEntities.dismissalReferringFacility : undefined;

			if (!updatedModel.dismissalReferringFacility && event.payload) {
				event.payload.dismissalReferringFacilityId = null;
			}
		} else if (event.payload?.dismissalReferringFacilityId !== undefined) {
			event.payload.dismissalReferringFacility = null;
			updatedModel.dismissalReferringFacility = null;
		}

		if (this.dismissalReferringStaffMultiCrudActive) {
			updatedModel.dismissalReferringStaff = event.additionalEntities.dismissalReferringStaff ? event.additionalEntities.dismissalReferringStaff : undefined;

			if (!updatedModel.dismissalReferringStaff && event.payload) {
				event.payload.dismissalReferringStaffId = null;
			}
		} else if (event.payload?.dismissalReferringStaffId !== undefined) {
			event.payload.dismissalReferringStaff = null;
			updatedModel.dismissalReferringStaff = null;
		}

		if (this.referringUnitMultiCrudActive) {
			updatedModel.referringUnit = event.additionalEntities.referringUnit ? event.additionalEntities.referringUnit : undefined;

			if (!updatedModel.referringUnit && event.payload) {
				event.payload.referringUnitId = null;
			}
		} else if (event.payload?.referringUnitId !== undefined) {
			event.payload.referringUnit = null;
			updatedModel.referringUnit = null;
		}

		if (this.referringFacilityMultiCrudActive) {
			updatedModel.referringFacility = event.additionalEntities.referringFacility ? event.additionalEntities.referringFacility : undefined;

			if (!updatedModel.referringFacility && event.payload) {
				event.payload.referringFacilityId = null;
			}
		} else if (event.payload?.referringFacilityId !== undefined) {
			event.payload.referringFacility = null;
			updatedModel.referringFacility = null;
		}

		if (this.bedFacilityMultiCrudActive) {
			updatedModel.bedFacility = event.additionalEntities.bedFacility ? event.additionalEntities.bedFacility : undefined;

			if (!updatedModel.bedFacility && event.payload) {
				event.payload.bedFacilityId = null;
			}
		} else if (event.payload?.bedFacilityId !== undefined) {
			event.payload.bedFacility = null;
			updatedModel.bedFacility = null;
		}

		if (this.patientVisitMultiCrudActive) {
			updatedModel.patientVisit = event.additionalEntities.patientVisit ? event.additionalEntities.patientVisit : undefined;

			if (!updatedModel.patientVisit && event.payload) {
				event.payload.patientVisitId = null;
			}
		} else if (event.payload?.patientVisitId !== undefined) {
			event.payload.patientVisit = null;
			updatedModel.patientVisit = null;
		}

		if (this.serviceMultiCrudActive) {
			updatedModel.service = event.additionalEntities.service ? event.additionalEntities.service : undefined;

			if (!updatedModel.service && event.payload) {
				event.payload.serviceId = null;
			}
		} else if (event.payload?.serviceId !== undefined) {
			event.payload.service = null;
			updatedModel.service = null;
		}

		if (this.staffMultiCrudActive) {
			updatedModel.staff = event.additionalEntities.staff ? event.additionalEntities.staff : undefined;

			if (!updatedModel.staff && event.payload) {
				event.payload.staffId = null;
			}
		} else if (event.payload?.staffId !== undefined) {
			event.payload.staff = null;
			updatedModel.staff = null;
		}

		if (this.requestedByMultiCrudActive) {
			updatedModel.requestedBy = event.additionalEntities.requestedBy ? event.additionalEntities.requestedBy : undefined;

			if (!updatedModel.requestedBy && event.payload) {
				event.payload.requestedById = null;
			}
		} else if (event.payload?.requestedById !== undefined) {
			event.payload.requestedBy = null;
			updatedModel.requestedBy = null;
		}

		updatedModel.bedReserves = [];
		if (this.bedReservesMultiCrudActive) {
			if (event.additionalEntities.bedReserves) {
				event.additionalEntities.bedReserves.forEach(entity => {
					updatedModel.bedReserves.push(entity);
				});
			}

			if (!updatedModel.bedReserves.length) {
				updatedModel.bedReservesIds = [];
			}
		}
		updatedModel.diagnosticExaminationResults = [];
		if (this.diagnosticExaminationResultsMultiCrudActive) {
			if (event.additionalEntities.diagnosticExaminationResults) {
				event.additionalEntities.diagnosticExaminationResults.forEach(entity => {
					updatedModel.diagnosticExaminationResults.push(entity);
				});
			}

			if (!updatedModel.diagnosticExaminationResults.length) {
				updatedModel.diagnosticExaminationResultsIds = [];
			}
		}
		updatedModel.fluidBalanceDetails = [];
		if (this.fluidBalanceDetailsMultiCrudActive) {
			if (event.additionalEntities.fluidBalanceDetails) {
				event.additionalEntities.fluidBalanceDetails.forEach(entity => {
					updatedModel.fluidBalanceDetails.push(entity);
				});
			}

			if (!updatedModel.fluidBalanceDetails.length) {
				updatedModel.fluidBalanceDetailsIds = [];
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
		updatedModel.invoiceItems = [];
		if (this.invoiceItemsMultiCrudActive) {
			if (event.additionalEntities.invoiceItems) {
				event.additionalEntities.invoiceItems.forEach(entity => {
					updatedModel.invoiceItems.push(entity);
				});
			}

			if (!updatedModel.invoiceItems.length) {
				updatedModel.invoiceItemsIds = [];
			}
		}
		updatedModel.medicalFees = [];
		if (this.medicalFeesMultiCrudActive) {
			if (event.additionalEntities.medicalFees) {
				event.additionalEntities.medicalFees.forEach(entity => {
					updatedModel.medicalFees.push(entity);
				});
			}

			if (!updatedModel.medicalFees.length) {
				updatedModel.medicalFeesIds = [];
			}
		}
		updatedModel.medicationHeaders = [];
		if (this.medicationHeadersMultiCrudActive) {
			if (event.additionalEntities.medicationHeaders) {
				event.additionalEntities.medicationHeaders.forEach(entity => {
					updatedModel.medicationHeaders.push(entity);
				});
			}

			if (!updatedModel.medicationHeaders.length) {
				updatedModel.medicationHeadersIds = [];
			}
		}
		updatedModel.patientVitalInformations = [];
		if (this.patientVitalInformationsMultiCrudActive) {
			if (event.additionalEntities.patientVitalInformations) {
				event.additionalEntities.patientVitalInformations.forEach(entity => {
					updatedModel.patientVitalInformations.push(entity);
				});
			}

			if (!updatedModel.patientVitalInformations.length) {
				updatedModel.patientVitalInformationsIds = [];
			}
		}
		updatedModel.prescriptionHeaders = [];
		if (this.prescriptionHeadersMultiCrudActive) {
			if (event.additionalEntities.prescriptionHeaders) {
				event.additionalEntities.prescriptionHeaders.forEach(entity => {
					updatedModel.prescriptionHeaders.push(entity);
				});
			}

			if (!updatedModel.prescriptionHeaders.length) {
				updatedModel.prescriptionHeadersIds = [];
			}
		}
		updatedModel.sampleCollectionInformations = [];
		if (this.sampleCollectionInformationsMultiCrudActive) {
			if (event.additionalEntities.sampleCollectionInformations) {
				event.additionalEntities.sampleCollectionInformations.forEach(entity => {
					updatedModel.sampleCollectionInformations.push(entity);
				});
			}

			if (!updatedModel.sampleCollectionInformations.length) {
				updatedModel.sampleCollectionInformationsIds = [];
			}
		}
		updatedModel.vaccinationOrders = [];
		if (this.vaccinationOrdersMultiCrudActive) {
			if (event.additionalEntities.vaccinationOrders) {
				event.additionalEntities.vaccinationOrders.forEach(entity => {
					updatedModel.vaccinationOrders.push(entity);
				});
			}

			if (!updatedModel.vaccinationOrders.length) {
				updatedModel.vaccinationOrdersIds = [];
			}
		}
		updatedModel.examinationItems = [];
		if (this.examinationItemsMultiCrudActive) {
			if (event.additionalEntities.examinationItems) {
				event.additionalEntities.examinationItems.forEach(entity => {
					updatedModel.examinationItems.push(entity);
				});
			}

			if (!updatedModel.examinationItems.length) {
				updatedModel.examinationItemsIds = [];
			}
		}

		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
