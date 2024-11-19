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
import * as modelAction from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.action';
import {MedicalExaminationRecordModelState, MedicalExaminationRecordModelAudit} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.state';
import {MedicalExaminationRecordModel} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model';
import {
	getMedicalExaminationRecordModelAuditsByEntityId,
	getMedicalExaminationRecordModelWithId,
	getCountMedicalExaminationRecordModels,
} from 'src/app/models/medicalExaminationRecord/medical_examination_record.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {AmendmentDetailModel} from 'src/app/models/amendmentDetail/amendment_detail.model';
import * as amendmentDetailModelAction from 'src/app/models/amendmentDetail/amendment_detail.model.action';
import {
	getAmendmentDetailCollectionModels, getAmendmentDetailModelWithId,
} from 'src/app/models/amendmentDetail/amendment_detail.model.selector';
import {BirthHistoryModel} from 'src/app/models/birthHistory/birth_history.model';
import * as birthHistoryModelAction from 'src/app/models/birthHistory/birth_history.model.action';
import {
	getBirthHistoryCollectionModels, getBirthHistoryModelWithId,
} from 'src/app/models/birthHistory/birth_history.model.selector';
import {BodyChartExaminationModel} from 'src/app/models/bodyChartExamination/body_chart_examination.model';
import * as bodyChartExaminationModelAction from 'src/app/models/bodyChartExamination/body_chart_examination.model.action';
import {
	getBodyChartExaminationCollectionModels, getBodyChartExaminationModelWithId,
} from 'src/app/models/bodyChartExamination/body_chart_examination.model.selector';
import {CoTreatingDoctorModel} from 'src/app/models/coTreatingDoctor/co_treating_doctor.model';
import * as coTreatingDoctorModelAction from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.action';
import {
	getCoTreatingDoctorCollectionModels, getCoTreatingDoctorModelWithId,
} from 'src/app/models/coTreatingDoctor/co_treating_doctor.model.selector';
import {DailyCareCPPTModel} from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import * as dailyCareCPPTModelAction from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.action';
import {
	getDailyCareCPPTCollectionModels, getDailyCareCPPTModelWithId,
} from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
import {DeliveryMedicalExaminationRecordModel} from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model';
import * as deliveryMedicalExaminationRecordModelAction from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.action';
import {
	getDeliveryMedicalExaminationRecordCollectionModels, getDeliveryMedicalExaminationRecordModelWithId,
} from 'src/app/models/deliveryMedicalExaminationRecord/delivery_medical_examination_record.model.selector';
import {DiagnosisExaminationRecordModel} from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model';
import * as diagnosisExaminationRecordModelAction from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.action';
import {
	getDiagnosisExaminationRecordCollectionModels, getDiagnosisExaminationRecordModelWithId,
} from 'src/app/models/diagnosisExaminationRecord/diagnosis_examination_record.model.selector';
import {DiagnosisNandaModel} from 'src/app/models/diagnosisNanda/diagnosis_nanda.model';
import * as diagnosisNandaModelAction from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.action';
import {
	getDiagnosisNandaCollectionModels, getDiagnosisNandaModelWithId,
} from 'src/app/models/diagnosisNanda/diagnosis_nanda.model.selector';
import {EntExaminationModel} from 'src/app/models/entExamination/ent_examination.model';
import * as entExaminationModelAction from 'src/app/models/entExamination/ent_examination.model.action';
import {
	getEntExaminationCollectionModels, getEntExaminationModelWithId,
} from 'src/app/models/entExamination/ent_examination.model.selector';
import {EmergencyMedicalExaminationRecordModel} from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model';
import * as emergencyMedicalExaminationRecordModelAction from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.action';
import {
	getEmergencyMedicalExaminationRecordCollectionModels, getEmergencyMedicalExaminationRecordModelWithId,
} from 'src/app/models/emergencyMedicalExaminationRecord/emergency_medical_examination_record.model.selector';
import {FormulirKonselingTesHivModel} from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model';
import * as formulirKonselingTesHivModelAction from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.action';
import {
	getFormulirKonselingTesHivCollectionModels, getFormulirKonselingTesHivModelWithId,
} from 'src/app/models/formulirKonselingTesHiv/formulir_konseling_tes_hiv.model.selector';
import {HemodialysisExaminationModel} from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model';
import * as hemodialysisExaminationModelAction from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model.action';
import {
	getHemodialysisExaminationCollectionModels, getHemodialysisExaminationModelWithId,
} from 'src/app/models/hemodialysisExamination/hemodialysis_examination.model.selector';
import {InpatientMedicalExaminationRecordModel} from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import * as inpatientMedicalExaminationRecordModelAction from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.action';
import {
	getInpatientMedicalExaminationRecordCollectionModels, getInpatientMedicalExaminationRecordModelWithId,
} from 'src/app/models/inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model.selector';
import {MedicalExaminationRecordDischargeSummaryModel} from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model';
import * as medicalExaminationRecordDischargeSummaryModelAction from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.action';
import {
	getMedicalExaminationRecordDischargeSummaryCollectionModels, getMedicalExaminationRecordDischargeSummaryModelWithId,
} from 'src/app/models/medicalExaminationRecordDischargeSummary/medical_examination_record_discharge_summary.model.selector';
import {MedicalRecordInitialChecklistModel} from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model';
import * as medicalRecordInitialChecklistModelAction from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model.action';
import {
	getMedicalRecordInitialChecklistCollectionModels, getMedicalRecordInitialChecklistModelWithId,
} from 'src/app/models/medicalRecordInitialChecklist/medical_record_initial_checklist.model.selector';
import {MedicalRecordNextVerificationChecklistModel} from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model';
import * as medicalRecordNextVerificationChecklistModelAction from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.action';
import {
	getMedicalRecordNextVerificationChecklistCollectionModels, getMedicalRecordNextVerificationChecklistModelWithId,
} from 'src/app/models/medicalRecordNextVerificationChecklist/medical_record_next_verification_checklist.model.selector';
import {NurseVitalSignMeasurementModel} from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model';
import * as nurseVitalSignMeasurementModelAction from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.action';
import {
	getNurseVitalSignMeasurementCollectionModels, getNurseVitalSignMeasurementModelWithId,
} from 'src/app/models/nurseVitalSignMeasurement/nurse_vital_sign_measurement.model.selector';
import {ObstetricAndGynecologyHistoryModel} from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model';
import * as obstetricAndGynecologyHistoryModelAction from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.action';
import {
	getObstetricAndGynecologyHistoryCollectionModels, getObstetricAndGynecologyHistoryModelWithId,
} from 'src/app/models/obstetricAndGynecologyHistory/obstetric_and_gynecology_history.model.selector';
import {OdontogramExaminationModel} from 'src/app/models/odontogramExamination/odontogram_examination.model';
import * as odontogramExaminationModelAction from 'src/app/models/odontogramExamination/odontogram_examination.model.action';
import {
	getOdontogramExaminationCollectionModels, getOdontogramExaminationModelWithId,
} from 'src/app/models/odontogramExamination/odontogram_examination.model.selector';
import {OperatingTheaterMedicalExaminationRecordModel} from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import * as operatingTheaterMedicalExaminationRecordModelAction from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.action';
import {
	getOperatingTheaterMedicalExaminationRecordCollectionModels, getOperatingTheaterMedicalExaminationRecordModelWithId,
} from 'src/app/models/operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model.selector';
import {OphthalmologyExaminationModel} from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model';
import * as ophthalmologyExaminationModelAction from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model.action';
import {
	getOphthalmologyExaminationCollectionModels, getOphthalmologyExaminationModelWithId,
} from 'src/app/models/ophthalmologyExamination/ophthalmology_examination.model.selector';
import {RegistrationModel} from 'src/app/models/registration/registration.model';
import * as registrationModelAction from 'src/app/models/registration/registration.model.action';
import {
	getRegistrationCollectionModels, getRegistrationModelWithId,
} from 'src/app/models/registration/registration.model.selector';
import {RoomTransferModel} from 'src/app/models/roomTransfer/room_transfer.model';
import * as roomTransferModelAction from 'src/app/models/roomTransfer/room_transfer.model.action';
import {
	getRoomTransferCollectionModels, getRoomTransferModelWithId,
} from 'src/app/models/roomTransfer/room_transfer.model.selector';
import {StaffModel} from 'src/app/models/staff/staff.model';
import * as staffModelAction from 'src/app/models/staff/staff.model.action';
import {
	getStaffCollectionModels, getStaffModelWithId,
} from 'src/app/models/staff/staff.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../medical-examination-record-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-medical-examination-record-crud-edit',
	templateUrl: './medical-examination-record-crud-edit.component.html',
	styleUrls: [
		'./medical-examination-record-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class MedicalExaminationRecordCrudEditComponent
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
	collectionId: string = 'cb2ae6bf-53ab-4c7f-a8d2-4dbef5efc932';
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
	medicalExaminationRecordAudits$: Observable<MedicalExaminationRecordModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Birth History here] off begin
	birthHistoryMultiCrudActive: boolean = false;
	birthHistoryDisplayName = 'Birth History';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Birth History here] end
	birthHistoryOppositeRelation = 'medicalExaminationRecord';
	birthHistoryRelations: ModelRelation[] = this.birthHistoryMultiCrudActive ? BirthHistoryModel.getRelations()
		.map(relation => {
			if (relation.id === this.birthHistoryOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Body Chart Examination here] off begin
	bodyChartExaminationMultiCrudActive: boolean = false;
	bodyChartExaminationDisplayName = 'Body Chart Examination';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Body Chart Examination here] end
	bodyChartExaminationOppositeRelation = 'medicalExaminationRecord';
	bodyChartExaminationRelations: ModelRelation[] = this.bodyChartExaminationMultiCrudActive ? BodyChartExaminationModel.getRelations()
		.map(relation => {
			if (relation.id === this.bodyChartExaminationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Delivery Medical Examination Record here] off begin
	deliveryMedicalExaminationRecordMultiCrudActive: boolean = false;
	deliveryMedicalExaminationRecordDisplayName = 'Delivery Medical Examination Record';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Delivery Medical Examination Record here] end
	deliveryMedicalExaminationRecordOppositeRelation = 'medicalExaminationRecord';
	deliveryMedicalExaminationRecordRelations: ModelRelation[] = this.deliveryMedicalExaminationRecordMultiCrudActive ? DeliveryMedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.deliveryMedicalExaminationRecordOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and ENT Examination here] off begin
	entExaminationMultiCrudActive: boolean = false;
	entExaminationDisplayName = 'ENT Examination';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and ENT Examination here] end
	entExaminationOppositeRelation = 'medicalExaminationRecord';
	entExaminationRelations: ModelRelation[] = this.entExaminationMultiCrudActive ? EntExaminationModel.getRelations()
		.map(relation => {
			if (relation.id === this.entExaminationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Emergency Medication Examination Record here] off begin
	emergencyMedicationExaminationRecordMultiCrudActive: boolean = false;
	emergencyMedicationExaminationRecordDisplayName = 'Emergency Medication Examination Record';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Emergency Medication Examination Record here] end
	emergencyMedicationExaminationRecordOppositeRelation = 'medicalExaminationRecord';
	emergencyMedicationExaminationRecordRelations: ModelRelation[] = this.emergencyMedicationExaminationRecordMultiCrudActive ? EmergencyMedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.emergencyMedicationExaminationRecordOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Formulir Konseling Tes Hiv here] off begin
	formulirKonselingTesHivMultiCrudActive: boolean = false;
	formulirKonselingTesHivDisplayName = 'Formulir Konseling Tes Hiv';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Formulir Konseling Tes Hiv here] end
	formulirKonselingTesHivOppositeRelation = 'medicalExaminationRecord';
	formulirKonselingTesHivRelations: ModelRelation[] = this.formulirKonselingTesHivMultiCrudActive ? FormulirKonselingTesHivModel.getRelations()
		.map(relation => {
			if (relation.id === this.formulirKonselingTesHivOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Hemodialysis Examination here] off begin
	hemodialysisExaminationMultiCrudActive: boolean = false;
	hemodialysisExaminationDisplayName = 'Hemodialysis Examination';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Hemodialysis Examination here] end
	hemodialysisExaminationOppositeRelation = 'medicalExaminationRecord';
	hemodialysisExaminationRelations: ModelRelation[] = this.hemodialysisExaminationMultiCrudActive ? HemodialysisExaminationModel.getRelations()
		.map(relation => {
			if (relation.id === this.hemodialysisExaminationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Medical Examination Record Discharge Summary here] off begin
	medicalExaminationRecordDischargeSummaryMultiCrudActive: boolean = false;
	medicalExaminationRecordDischargeSummaryDisplayName = 'Medical Examination Record Discharge Summary';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Medical Examination Record Discharge Summary here] end
	medicalExaminationRecordDischargeSummaryOppositeRelation = 'medicalExaminationRecord';
	medicalExaminationRecordDischargeSummaryRelations: ModelRelation[] = this.medicalExaminationRecordDischargeSummaryMultiCrudActive ? MedicalExaminationRecordDischargeSummaryModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalExaminationRecordDischargeSummaryOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Medical Record Initial Checklist here] off begin
	medicalRecordInitialChecklistMultiCrudActive: boolean = false;
	medicalRecordInitialChecklistDisplayName = 'Medical Record Initial Checklist';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Medical Record Initial Checklist here] end
	medicalRecordInitialChecklistOppositeRelation = 'medicalExaminationRecord';
	medicalRecordInitialChecklistRelations: ModelRelation[] = this.medicalRecordInitialChecklistMultiCrudActive ? MedicalRecordInitialChecklistModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalRecordInitialChecklistOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Medical Record Next Verification Checklist here] off begin
	medicalRecordNextVerificationChecklistMultiCrudActive: boolean = false;
	medicalRecordNextVerificationChecklistDisplayName = 'Medical Record Next Verification Checklist';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Medical Record Next Verification Checklist here] end
	medicalRecordNextVerificationChecklistOppositeRelation = 'medicalExaminationRecord';
	medicalRecordNextVerificationChecklistRelations: ModelRelation[] = this.medicalRecordNextVerificationChecklistMultiCrudActive ? MedicalRecordNextVerificationChecklistModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalRecordNextVerificationChecklistOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Nurse Vital Sign Measurement here] off begin
	nurseVitalSignMeasurementMultiCrudActive: boolean = false;
	nurseVitalSignMeasurementDisplayName = 'Nurse Vital Sign Measurement';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Nurse Vital Sign Measurement here] end
	nurseVitalSignMeasurementOppositeRelation = 'medicalExaminationRecord';
	nurseVitalSignMeasurementRelations: ModelRelation[] = this.nurseVitalSignMeasurementMultiCrudActive ? NurseVitalSignMeasurementModel.getRelations()
		.map(relation => {
			if (relation.id === this.nurseVitalSignMeasurementOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Obstetric And Gynecology History here] off begin
	obstetricAndGynecologyHistoryMultiCrudActive: boolean = false;
	obstetricAndGynecologyHistoryDisplayName = 'Obstetric And Gynecology History';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Obstetric And Gynecology History here] end
	obstetricAndGynecologyHistoryOppositeRelation = 'medicalExaminationRecord';
	obstetricAndGynecologyHistoryRelations: ModelRelation[] = this.obstetricAndGynecologyHistoryMultiCrudActive ? ObstetricAndGynecologyHistoryModel.getRelations()
		.map(relation => {
			if (relation.id === this.obstetricAndGynecologyHistoryOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Odontogram Examination here] off begin
	odontogramExaminationMultiCrudActive: boolean = false;
	odontogramExaminationDisplayName = 'Odontogram Examination';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Odontogram Examination here] end
	odontogramExaminationOppositeRelation = 'medicalExaminationRecord';
	odontogramExaminationRelations: ModelRelation[] = this.odontogramExaminationMultiCrudActive ? OdontogramExaminationModel.getRelations()
		.map(relation => {
			if (relation.id === this.odontogramExaminationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Operating Theater Medical Examination Record here] off begin
	operatingTheaterMedicalExaminationRecordMultiCrudActive: boolean = false;
	operatingTheaterMedicalExaminationRecordDisplayName = 'Operating Theater Medical Examination Record';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Operating Theater Medical Examination Record here] end
	operatingTheaterMedicalExaminationRecordOppositeRelation = 'medicalExaminationRecord';
	operatingTheaterMedicalExaminationRecordRelations: ModelRelation[] = this.operatingTheaterMedicalExaminationRecordMultiCrudActive ? OperatingTheaterMedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.operatingTheaterMedicalExaminationRecordOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Ophthalmology Examination here] off begin
	ophthalmologyExaminationMultiCrudActive: boolean = false;
	ophthalmologyExaminationDisplayName = 'Ophthalmology Examination';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Ophthalmology Examination here] end
	ophthalmologyExaminationOppositeRelation = 'medicalExaminationRecord';
	ophthalmologyExaminationRelations: ModelRelation[] = this.ophthalmologyExaminationMultiCrudActive ? OphthalmologyExaminationModel.getRelations()
		.map(relation => {
			if (relation.id === this.ophthalmologyExaminationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Inpatient Medical Examination Record and Medical Examination Record here] off begin
	inpatientMedicalExaminationRecordMultiCrudActive: boolean = false;
	inpatientMedicalExaminationRecordDisplayName = 'Inpatient Medical Examination Record';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Inpatient Medical Examination Record and Medical Examination Record here] end
	inpatientMedicalExaminationRecordOppositeRelation = 'medicalExaminationRecord';
	inpatientMedicalExaminationRecordRelations: ModelRelation[] = this.inpatientMedicalExaminationRecordMultiCrudActive ? InpatientMedicalExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.inpatientMedicalExaminationRecordOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Examination Record here] off begin
	registrationMultiCrudActive: boolean = false;
	registrationDisplayName = 'Registration';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Registration and Medical Examination Record here] end
	registrationOppositeRelation = 'medicalExaminationRecord';
	registrationRelations: ModelRelation[] = this.registrationMultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.registrationOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Doctor and Doctor on examination here] off begin
	doctorMultiCrudActive: boolean = false;
	doctorDisplayName = 'Doctor';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Doctor and Doctor on examination here] end
	doctorOppositeRelation = 'doctorOnExamination';
	doctorRelations: ModelRelation[] = this.doctorMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.doctorOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Transcriber and Medical Record Transcriber here] off begin
	medicalTranscriberMultiCrudActive: boolean = false;
	medicalTranscriberDisplayName = 'Medical Transcriber';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Transcriber and Medical Record Transcriber here] end
	medicalTranscriberOppositeRelation = 'medicalRecordTranscriber';
	medicalTranscriberRelations: ModelRelation[] = this.medicalTranscriberMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.medicalTranscriberOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nurse and Nurse here] off begin
	nurseMultiCrudActive: boolean = false;
	nurseDisplayName = 'Nurse';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Nurse and Nurse here] end
	nurseOppositeRelation = 'nurse';
	nurseRelations: ModelRelation[] = this.nurseMultiCrudActive ? StaffModel.getRelations()
		.map(relation => {
			if (relation.id === this.nurseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Amendment Details here] off begin
	amendmentDetailsMultiCrudActive: boolean = false;
	amendmentDetailsDisplayName = 'Amendment Details';
	amendmentDetailsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Amendment Details here] end
	amendmentDetailsOppositeRelation = 'medicalExaminationRecord';
	amendmentDetailsRelations: ModelRelation[] = this.amendmentDetailsMultiCrudActive ? AmendmentDetailModel.getRelations()
		.map(relation => {
			if (relation.id === this.amendmentDetailsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Co Treating Doctors here] off begin
	coTreatingDoctorsMultiCrudActive: boolean = false;
	coTreatingDoctorsDisplayName = 'Co Treating Doctors';
	coTreatingDoctorsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Co Treating Doctors here] end
	coTreatingDoctorsOppositeRelation = 'medicalExaminationRecord';
	coTreatingDoctorsRelations: ModelRelation[] = this.coTreatingDoctorsMultiCrudActive ? CoTreatingDoctorModel.getRelations()
		.map(relation => {
			if (relation.id === this.coTreatingDoctorsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Daily Care CPPTs here] off begin
	dailyCareCPPTsMultiCrudActive: boolean = false;
	dailyCareCPPTsDisplayName = 'Daily Care CPPTs';
	dailyCareCPPTsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Daily Care CPPTs here] end
	dailyCareCPPTsOppositeRelation = 'medicalExaminationRecord';
	dailyCareCPPTsRelations: ModelRelation[] = this.dailyCareCPPTsMultiCrudActive ? DailyCareCPPTModel.getRelations()
		.map(relation => {
			if (relation.id === this.dailyCareCPPTsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Diagnosis Examination Records here] off begin
	diagnosisExaminationRecordsMultiCrudActive: boolean = false;
	diagnosisExaminationRecordsDisplayName = 'Diagnosis Examination Records';
	diagnosisExaminationRecordsCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Diagnosis Examination Records here] end
	diagnosisExaminationRecordsOppositeRelation = 'medicalExaminationRecord';
	diagnosisExaminationRecordsRelations: ModelRelation[] = this.diagnosisExaminationRecordsMultiCrudActive ? DiagnosisExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.diagnosisExaminationRecordsOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Diagnosis Nandas here] off begin
	diagnosisNandasMultiCrudActive: boolean = false;
	diagnosisNandasDisplayName = 'Diagnosis Nandas';
	diagnosisNandasCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Diagnosis Nandas here] end
	diagnosisNandasOppositeRelation = 'medicalExaminationRecord';
	diagnosisNandasRelations: ModelRelation[] = this.diagnosisNandasMultiCrudActive ? DiagnosisNandaModel.getRelations()
		.map(relation => {
			if (relation.id === this.diagnosisNandasOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Room Transfers here] off begin
	roomTransfersMultiCrudActive: boolean = false;
	roomTransfersDisplayName = 'Room Transfers';
	roomTransfersCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Medical Examination Record and Room Transfers here] end
	roomTransfersOppositeRelation = 'medicalExaminationRecord';
	roomTransfersRelations: ModelRelation[] = this.roomTransfersMultiCrudActive ? RoomTransferModel.getRelations()
		.map(relation => {
			if (relation.id === this.roomTransfersOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = MedicalExaminationRecordModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = MedicalExaminationRecordModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = MedicalExaminationRecordModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'birthHistory' && this.birthHistoryMultiCrudActive) {
					exp.fields = BirthHistoryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bodyChartExamination' && this.bodyChartExaminationMultiCrudActive) {
					exp.fields = BodyChartExaminationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'deliveryMedicalExaminationRecord' && this.deliveryMedicalExaminationRecordMultiCrudActive) {
					exp.fields = DeliveryMedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'entExamination' && this.entExaminationMultiCrudActive) {
					exp.fields = EntExaminationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'emergencyMedicationExaminationRecord' && this.emergencyMedicationExaminationRecordMultiCrudActive) {
					exp.fields = EmergencyMedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'formulirKonselingTesHiv' && this.formulirKonselingTesHivMultiCrudActive) {
					exp.fields = FormulirKonselingTesHivModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'hemodialysisExamination' && this.hemodialysisExaminationMultiCrudActive) {
					exp.fields = HemodialysisExaminationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalExaminationRecordDischargeSummary' && this.medicalExaminationRecordDischargeSummaryMultiCrudActive) {
					exp.fields = MedicalExaminationRecordDischargeSummaryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalRecordInitialChecklist' && this.medicalRecordInitialChecklistMultiCrudActive) {
					exp.fields = MedicalRecordInitialChecklistModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalRecordNextVerificationChecklist' && this.medicalRecordNextVerificationChecklistMultiCrudActive) {
					exp.fields = MedicalRecordNextVerificationChecklistModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'nurseVitalSignMeasurement' && this.nurseVitalSignMeasurementMultiCrudActive) {
					exp.fields = NurseVitalSignMeasurementModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'obstetricAndGynecologyHistory' && this.obstetricAndGynecologyHistoryMultiCrudActive) {
					exp.fields = ObstetricAndGynecologyHistoryModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'odontogramExamination' && this.odontogramExaminationMultiCrudActive) {
					exp.fields = OdontogramExaminationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'operatingTheaterMedicalExaminationRecord' && this.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
					exp.fields = OperatingTheaterMedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'ophthalmologyExamination' && this.ophthalmologyExaminationMultiCrudActive) {
					exp.fields = OphthalmologyExaminationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'inpatientMedicalExaminationRecord' && this.inpatientMedicalExaminationRecordMultiCrudActive) {
					exp.fields = InpatientMedicalExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'registration' && this.registrationMultiCrudActive) {
					exp.fields = RegistrationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'doctor' && this.doctorMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'medicalTranscriber' && this.medicalTranscriberMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'nurse' && this.nurseMultiCrudActive) {
					exp.fields = StaffModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'amendmentDetails' && this.amendmentDetailsMultiCrudActive) {
					exp.fields = AmendmentDetailModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'coTreatingDoctors' && this.coTreatingDoctorsMultiCrudActive) {
					exp.fields = CoTreatingDoctorModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'dailyCareCPPTs' && this.dailyCareCPPTsMultiCrudActive) {
					exp.fields = DailyCareCPPTModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'diagnosisExaminationRecords' && this.diagnosisExaminationRecordsMultiCrudActive) {
					exp.fields = DiagnosisExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'diagnosisNandas' && this.diagnosisNandasMultiCrudActive) {
					exp.fields = DiagnosisNandaModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'roomTransfers' && this.roomTransfersMultiCrudActive) {
					exp.fields = RoomTransferModel.getProps().map(prop => {
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
	targetModel: MedicalExaminationRecordModel;

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
		private readonly store: Store<{ model: MedicalExaminationRecordModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountMedicalExaminationRecordModels).subscribe(count => {
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

			this.targetModel = new MedicalExaminationRecordModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.medicalExaminationRecordAudits$ = this.store.select(getMedicalExaminationRecordModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<MedicalExaminationRecordModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.MedicalExaminationRecordAction(
			modelAction.MedicalExaminationRecordModelActionTypes.FETCH_MEDICAL_EXAMINATION_RECORD,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getMedicalExaminationRecordModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new MedicalExaminationRecordModel(model);
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
				commands.push('medical-examination-record');
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

		this.store.dispatch(new modelAction.MedicalExaminationRecordAction(
			modelAction.MedicalExaminationRecordModelActionTypes.FETCH_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<MedicalExaminationRecordModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.inpatientMedicalExaminationRecordMultiCrudActive || this.registrationMultiCrudActive || this.birthHistoryMultiCrudActive || this.bodyChartExaminationMultiCrudActive || this.deliveryMedicalExaminationRecordMultiCrudActive || this.entExaminationMultiCrudActive || this.emergencyMedicationExaminationRecordMultiCrudActive || this.formulirKonselingTesHivMultiCrudActive || this.hemodialysisExaminationMultiCrudActive || this.medicalExaminationRecordDischargeSummaryMultiCrudActive || this.medicalRecordInitialChecklistMultiCrudActive || this.medicalRecordNextVerificationChecklistMultiCrudActive || this.nurseVitalSignMeasurementMultiCrudActive || this.obstetricAndGynecologyHistoryMultiCrudActive || this.odontogramExaminationMultiCrudActive || this.operatingTheaterMedicalExaminationRecordMultiCrudActive || this.ophthalmologyExaminationMultiCrudActive || this.doctorMultiCrudActive || this.medicalTranscriberMultiCrudActive || this.nurseMultiCrudActive || this.amendmentDetailsMultiCrudActive || this.coTreatingDoctorsMultiCrudActive || this.dailyCareCPPTsMultiCrudActive || this.diagnosisExaminationRecordsMultiCrudActive || this.diagnosisNandasMultiCrudActive || this.roomTransfersMultiCrudActive,
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
					new modelAction.MedicalExaminationRecordAction(
						modelAction.MedicalExaminationRecordModelActionTypes.COUNT_MEDICAL_EXAMINATION_RECORDS,
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

			this.store.dispatch(new modelAction.MedicalExaminationRecordAction(
				modelAction.MedicalExaminationRecordModelActionTypes.CREATE_MEDICAL_EXAMINATION_RECORD,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<MedicalExaminationRecordModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.inpatientMedicalExaminationRecordMultiCrudActive || this.registrationMultiCrudActive || this.birthHistoryMultiCrudActive || this.bodyChartExaminationMultiCrudActive || this.deliveryMedicalExaminationRecordMultiCrudActive || this.entExaminationMultiCrudActive || this.emergencyMedicationExaminationRecordMultiCrudActive || this.formulirKonselingTesHivMultiCrudActive || this.hemodialysisExaminationMultiCrudActive || this.medicalExaminationRecordDischargeSummaryMultiCrudActive || this.medicalRecordInitialChecklistMultiCrudActive || this.medicalRecordNextVerificationChecklistMultiCrudActive || this.nurseVitalSignMeasurementMultiCrudActive || this.obstetricAndGynecologyHistoryMultiCrudActive || this.odontogramExaminationMultiCrudActive || this.operatingTheaterMedicalExaminationRecordMultiCrudActive || this.ophthalmologyExaminationMultiCrudActive || this.doctorMultiCrudActive || this.medicalTranscriberMultiCrudActive || this.nurseMultiCrudActive || this.amendmentDetailsMultiCrudActive || this.coTreatingDoctorsMultiCrudActive || this.dailyCareCPPTsMultiCrudActive || this.diagnosisExaminationRecordsMultiCrudActive || this.diagnosisNandasMultiCrudActive || this.roomTransfersMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.MedicalExaminationRecordAction(
					modelAction.MedicalExaminationRecordModelActionTypes.FETCH_MEDICAL_EXAMINATION_RECORD,
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

			this.store.dispatch(new modelAction.MedicalExaminationRecordAction(
				modelAction.MedicalExaminationRecordModelActionTypes.UPDATE_MEDICAL_EXAMINATION_RECORD,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: MedicalExaminationRecordModel = new MedicalExaminationRecordModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getMedicalExaminationRecordModelWithId, this.targetModelId).subscribe(model => {
					let differences = new MedicalExaminationRecordModel(model).difference(updatedModel);

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
			if (event.entityName === this.inpatientMedicalExaminationRecordDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InpatientMedicalExaminationRecordModel.getProps(), this.inpatientMedicalExaminationRecordRelations, this.isViewOnly),
					new InpatientMedicalExaminationRecordModel(),
					InpatientMedicalExaminationRecordModel,
					this.inpatientMedicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.inpatientMedicalExaminationRecordRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.registrationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationModel.getProps(), this.registrationRelations, this.isViewOnly),
					new RegistrationModel(),
					RegistrationModel,
					this.registrationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.registrationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.birthHistoryDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BirthHistoryModel.getProps(), this.birthHistoryRelations, this.isViewOnly),
					new BirthHistoryModel(),
					BirthHistoryModel,
					this.birthHistoryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.birthHistoryRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bodyChartExaminationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BodyChartExaminationModel.getProps(), this.bodyChartExaminationRelations, this.isViewOnly),
					new BodyChartExaminationModel(),
					BodyChartExaminationModel,
					this.bodyChartExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bodyChartExaminationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.deliveryMedicalExaminationRecordDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DeliveryMedicalExaminationRecordModel.getProps(), this.deliveryMedicalExaminationRecordRelations, this.isViewOnly),
					new DeliveryMedicalExaminationRecordModel(),
					DeliveryMedicalExaminationRecordModel,
					this.deliveryMedicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.deliveryMedicalExaminationRecordRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.entExaminationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(EntExaminationModel.getProps(), this.entExaminationRelations, this.isViewOnly),
					new EntExaminationModel(),
					EntExaminationModel,
					this.entExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.entExaminationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.emergencyMedicationExaminationRecordDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(EmergencyMedicalExaminationRecordModel.getProps(), this.emergencyMedicationExaminationRecordRelations, this.isViewOnly),
					new EmergencyMedicalExaminationRecordModel(),
					EmergencyMedicalExaminationRecordModel,
					this.emergencyMedicationExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.emergencyMedicationExaminationRecordRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.formulirKonselingTesHivDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(FormulirKonselingTesHivModel.getProps(), this.formulirKonselingTesHivRelations, this.isViewOnly),
					new FormulirKonselingTesHivModel(),
					FormulirKonselingTesHivModel,
					this.formulirKonselingTesHivDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.formulirKonselingTesHivRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.hemodialysisExaminationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(HemodialysisExaminationModel.getProps(), this.hemodialysisExaminationRelations, this.isViewOnly),
					new HemodialysisExaminationModel(),
					HemodialysisExaminationModel,
					this.hemodialysisExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.hemodialysisExaminationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalExaminationRecordDischargeSummaryDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalExaminationRecordDischargeSummaryModel.getProps(), this.medicalExaminationRecordDischargeSummaryRelations, this.isViewOnly),
					new MedicalExaminationRecordDischargeSummaryModel(),
					MedicalExaminationRecordDischargeSummaryModel,
					this.medicalExaminationRecordDischargeSummaryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalExaminationRecordDischargeSummaryRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalRecordInitialChecklistDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalRecordInitialChecklistModel.getProps(), this.medicalRecordInitialChecklistRelations, this.isViewOnly),
					new MedicalRecordInitialChecklistModel(),
					MedicalRecordInitialChecklistModel,
					this.medicalRecordInitialChecklistDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalRecordInitialChecklistRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalRecordNextVerificationChecklistDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalRecordNextVerificationChecklistModel.getProps(), this.medicalRecordNextVerificationChecklistRelations, this.isViewOnly),
					new MedicalRecordNextVerificationChecklistModel(),
					MedicalRecordNextVerificationChecklistModel,
					this.medicalRecordNextVerificationChecklistDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalRecordNextVerificationChecklistRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.nurseVitalSignMeasurementDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(NurseVitalSignMeasurementModel.getProps(), this.nurseVitalSignMeasurementRelations, this.isViewOnly),
					new NurseVitalSignMeasurementModel(),
					NurseVitalSignMeasurementModel,
					this.nurseVitalSignMeasurementDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.nurseVitalSignMeasurementRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.obstetricAndGynecologyHistoryDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ObstetricAndGynecologyHistoryModel.getProps(), this.obstetricAndGynecologyHistoryRelations, this.isViewOnly),
					new ObstetricAndGynecologyHistoryModel(),
					ObstetricAndGynecologyHistoryModel,
					this.obstetricAndGynecologyHistoryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.obstetricAndGynecologyHistoryRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.odontogramExaminationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OdontogramExaminationModel.getProps(), this.odontogramExaminationRelations, this.isViewOnly),
					new OdontogramExaminationModel(),
					OdontogramExaminationModel,
					this.odontogramExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.odontogramExaminationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.operatingTheaterMedicalExaminationRecordDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OperatingTheaterMedicalExaminationRecordModel.getProps(), this.operatingTheaterMedicalExaminationRecordRelations, this.isViewOnly),
					new OperatingTheaterMedicalExaminationRecordModel(),
					OperatingTheaterMedicalExaminationRecordModel,
					this.operatingTheaterMedicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.operatingTheaterMedicalExaminationRecordRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.ophthalmologyExaminationDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OphthalmologyExaminationModel.getProps(), this.ophthalmologyExaminationRelations, this.isViewOnly),
					new OphthalmologyExaminationModel(),
					OphthalmologyExaminationModel,
					this.ophthalmologyExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.ophthalmologyExaminationRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.doctorDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.doctorRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.doctorDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.doctorRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.medicalTranscriberDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.medicalTranscriberRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.medicalTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalTranscriberRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.nurseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.nurseRelations, this.isViewOnly),
					new StaffModel(),
					StaffModel,
					this.nurseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.nurseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.amendmentDetailsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(AmendmentDetailModel.getProps(), this.amendmentDetailsRelations, this.isViewOnly),
					new AmendmentDetailModel(),
					AmendmentDetailModel,
					this.amendmentDetailsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.amendmentDetailsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.coTreatingDoctorsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.coTreatingDoctorsRelations, this.isViewOnly),
					new CoTreatingDoctorModel(),
					CoTreatingDoctorModel,
					this.coTreatingDoctorsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.coTreatingDoctorsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.dailyCareCPPTsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.dailyCareCPPTsRelations, this.isViewOnly),
					new DailyCareCPPTModel(),
					DailyCareCPPTModel,
					this.dailyCareCPPTsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dailyCareCPPTsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.diagnosisExaminationRecordsDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosisExaminationRecordModel.getProps(), this.diagnosisExaminationRecordsRelations, this.isViewOnly),
					new DiagnosisExaminationRecordModel(),
					DiagnosisExaminationRecordModel,
					this.diagnosisExaminationRecordsDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosisExaminationRecordsRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.diagnosisNandasDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosisNandaModel.getProps(), this.diagnosisNandasRelations, this.isViewOnly),
					new DiagnosisNandaModel(),
					DiagnosisNandaModel,
					this.diagnosisNandasDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.diagnosisNandasRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.roomTransfersDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RoomTransferModel.getProps(), this.roomTransfersRelations, this.isViewOnly),
					new RoomTransferModel(),
					RoomTransferModel,
					this.roomTransfersDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.roomTransfersRelations,
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
		this.modelProperties = MedicalExaminationRecordModel.getProps();
		this.modelRelations = MedicalExaminationRecordModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'inpatientMedicalExaminationRecord';
		}).hideElement = this.inpatientMedicalExaminationRecordMultiCrudActive || this.modelRelations.find(rel => rel.id === 'inpatientMedicalExaminationRecord').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'registration';
		}).hideElement = this.registrationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'registration').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'birthHistory';
		}).hideElement = this.birthHistoryMultiCrudActive || this.modelRelations.find(rel => rel.id === 'birthHistory').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bodyChartExamination';
		}).hideElement = this.bodyChartExaminationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bodyChartExamination').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'deliveryMedicalExaminationRecord';
		}).hideElement = this.deliveryMedicalExaminationRecordMultiCrudActive || this.modelRelations.find(rel => rel.id === 'deliveryMedicalExaminationRecord').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'entExamination';
		}).hideElement = this.entExaminationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'entExamination').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'emergencyMedicationExaminationRecord';
		}).hideElement = this.emergencyMedicationExaminationRecordMultiCrudActive || this.modelRelations.find(rel => rel.id === 'emergencyMedicationExaminationRecord').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'formulirKonselingTesHiv';
		}).hideElement = this.formulirKonselingTesHivMultiCrudActive || this.modelRelations.find(rel => rel.id === 'formulirKonselingTesHiv').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'hemodialysisExamination';
		}).hideElement = this.hemodialysisExaminationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'hemodialysisExamination').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalExaminationRecordDischargeSummary';
		}).hideElement = this.medicalExaminationRecordDischargeSummaryMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalExaminationRecordDischargeSummary').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalRecordInitialChecklist';
		}).hideElement = this.medicalRecordInitialChecklistMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalRecordInitialChecklist').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalRecordNextVerificationChecklist';
		}).hideElement = this.medicalRecordNextVerificationChecklistMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalRecordNextVerificationChecklist').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'nurseVitalSignMeasurement';
		}).hideElement = this.nurseVitalSignMeasurementMultiCrudActive || this.modelRelations.find(rel => rel.id === 'nurseVitalSignMeasurement').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'obstetricAndGynecologyHistory';
		}).hideElement = this.obstetricAndGynecologyHistoryMultiCrudActive || this.modelRelations.find(rel => rel.id === 'obstetricAndGynecologyHistory').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'odontogramExamination';
		}).hideElement = this.odontogramExaminationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'odontogramExamination').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'operatingTheaterMedicalExaminationRecord';
		}).hideElement = this.operatingTheaterMedicalExaminationRecordMultiCrudActive || this.modelRelations.find(rel => rel.id === 'operatingTheaterMedicalExaminationRecord').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'ophthalmologyExamination';
		}).hideElement = this.ophthalmologyExaminationMultiCrudActive || this.modelRelations.find(rel => rel.id === 'ophthalmologyExamination').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'doctor';
		}).hideElement = this.doctorMultiCrudActive || this.modelRelations.find(rel => rel.id === 'doctor').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'medicalTranscriber';
		}).hideElement = this.medicalTranscriberMultiCrudActive || this.modelRelations.find(rel => rel.id === 'medicalTranscriber').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'nurse';
		}).hideElement = this.nurseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'nurse').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'amendmentDetails';
		}).hideElement = this.amendmentDetailsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'amendmentDetails').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'coTreatingDoctors';
		}).hideElement = this.coTreatingDoctorsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'coTreatingDoctors').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'dailyCareCPPTs';
		}).hideElement = this.dailyCareCPPTsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'dailyCareCPPTs').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'diagnosisExaminationRecords';
		}).hideElement = this.diagnosisExaminationRecordsMultiCrudActive || this.modelRelations.find(rel => rel.id === 'diagnosisExaminationRecords').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'diagnosisNandas';
		}).hideElement = this.diagnosisNandasMultiCrudActive || this.modelRelations.find(rel => rel.id === 'diagnosisNandas').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'roomTransfers';
		}).hideElement = this.roomTransfersMultiCrudActive || this.modelRelations.find(rel => rel.id === 'roomTransfers').hideElement;

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
		if (this.inpatientMedicalExaminationRecordMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.inpatientMedicalExaminationRecordDisplayName, many: false});
		}

		if (this.registrationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.registrationDisplayName, many: false});
		}

		if (this.birthHistoryMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.birthHistoryDisplayName, many: false});
		}

		if (this.bodyChartExaminationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bodyChartExaminationDisplayName, many: false});
		}

		if (this.deliveryMedicalExaminationRecordMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.deliveryMedicalExaminationRecordDisplayName, many: false});
		}

		if (this.entExaminationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.entExaminationDisplayName, many: false});
		}

		if (this.emergencyMedicationExaminationRecordMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.emergencyMedicationExaminationRecordDisplayName, many: false});
		}

		if (this.formulirKonselingTesHivMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.formulirKonselingTesHivDisplayName, many: false});
		}

		if (this.hemodialysisExaminationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.hemodialysisExaminationDisplayName, many: false});
		}

		if (this.medicalExaminationRecordDischargeSummaryMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalExaminationRecordDischargeSummaryDisplayName, many: false});
		}

		if (this.medicalRecordInitialChecklistMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalRecordInitialChecklistDisplayName, many: false});
		}

		if (this.medicalRecordNextVerificationChecklistMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalRecordNextVerificationChecklistDisplayName, many: false});
		}

		if (this.nurseVitalSignMeasurementMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.nurseVitalSignMeasurementDisplayName, many: false});
		}

		if (this.obstetricAndGynecologyHistoryMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.obstetricAndGynecologyHistoryDisplayName, many: false});
		}

		if (this.odontogramExaminationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.odontogramExaminationDisplayName, many: false});
		}

		if (this.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.operatingTheaterMedicalExaminationRecordDisplayName, many: false});
		}

		if (this.ophthalmologyExaminationMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.ophthalmologyExaminationDisplayName, many: false});
		}

		if (this.doctorMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.doctorDisplayName, many: false});
		}

		if (this.medicalTranscriberMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.medicalTranscriberDisplayName, many: false});
		}

		if (this.nurseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.nurseDisplayName, many: false});
		}

		if (this.amendmentDetailsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.amendmentDetailsDisplayName, many: true});
			this.store.dispatch(new amendmentDetailModelAction.AmendmentDetailAction(
				amendmentDetailModelAction.AmendmentDetailModelActionTypes.INITIALISE_AMENDMENT_DETAIL_COLLECTION_STATE,
				{
					collectionId: this.amendmentDetailsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getAmendmentDetailCollectionModels, this.amendmentDetailsCollectionId).subscribe(models => {
				models.forEach(amendmentDetails => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(AmendmentDetailModel.getProps(), this.amendmentDetailsRelations, this.isViewOnly),
						amendmentDetails,
						AmendmentDetailModel,
						this.amendmentDetailsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.amendmentDetailsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.coTreatingDoctorsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.coTreatingDoctorsDisplayName, many: true});
			this.store.dispatch(new coTreatingDoctorModelAction.CoTreatingDoctorAction(
				coTreatingDoctorModelAction.CoTreatingDoctorModelActionTypes.INITIALISE_CO_TREATING_DOCTOR_COLLECTION_STATE,
				{
					collectionId: this.coTreatingDoctorsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getCoTreatingDoctorCollectionModels, this.coTreatingDoctorsCollectionId).subscribe(models => {
				models.forEach(coTreatingDoctors => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(CoTreatingDoctorModel.getProps(), this.coTreatingDoctorsRelations, this.isViewOnly),
						coTreatingDoctors,
						CoTreatingDoctorModel,
						this.coTreatingDoctorsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.coTreatingDoctorsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.dailyCareCPPTsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.dailyCareCPPTsDisplayName, many: true});
			this.store.dispatch(new dailyCareCPPTModelAction.DailyCareCPPTAction(
				dailyCareCPPTModelAction.DailyCareCPPTModelActionTypes.INITIALISE_DAILY_CARE_CPPT_COLLECTION_STATE,
				{
					collectionId: this.dailyCareCPPTsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDailyCareCPPTCollectionModels, this.dailyCareCPPTsCollectionId).subscribe(models => {
				models.forEach(dailyCareCPPTs => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.dailyCareCPPTsRelations, this.isViewOnly),
						dailyCareCPPTs,
						DailyCareCPPTModel,
						this.dailyCareCPPTsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.dailyCareCPPTsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.diagnosisExaminationRecordsMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.diagnosisExaminationRecordsDisplayName, many: true});
			this.store.dispatch(new diagnosisExaminationRecordModelAction.DiagnosisExaminationRecordAction(
				diagnosisExaminationRecordModelAction.DiagnosisExaminationRecordModelActionTypes.INITIALISE_DIAGNOSIS_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.diagnosisExaminationRecordsCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosisExaminationRecordCollectionModels, this.diagnosisExaminationRecordsCollectionId).subscribe(models => {
				models.forEach(diagnosisExaminationRecords => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DiagnosisExaminationRecordModel.getProps(), this.diagnosisExaminationRecordsRelations, this.isViewOnly),
						diagnosisExaminationRecords,
						DiagnosisExaminationRecordModel,
						this.diagnosisExaminationRecordsDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.diagnosisExaminationRecordsRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.diagnosisNandasMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.diagnosisNandasDisplayName, many: true});
			this.store.dispatch(new diagnosisNandaModelAction.DiagnosisNandaAction(
				diagnosisNandaModelAction.DiagnosisNandaModelActionTypes.INITIALISE_DIAGNOSIS_NANDA_COLLECTION_STATE,
				{
					collectionId: this.diagnosisNandasCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosisNandaCollectionModels, this.diagnosisNandasCollectionId).subscribe(models => {
				models.forEach(diagnosisNandas => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DiagnosisNandaModel.getProps(), this.diagnosisNandasRelations, this.isViewOnly),
						diagnosisNandas,
						DiagnosisNandaModel,
						this.diagnosisNandasDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.diagnosisNandasRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.roomTransfersMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.roomTransfersDisplayName, many: true});
			this.store.dispatch(new roomTransferModelAction.RoomTransferAction(
				roomTransferModelAction.RoomTransferModelActionTypes.INITIALISE_ROOM_TRANSFER_COLLECTION_STATE,
				{
					collectionId: this.roomTransfersCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRoomTransferCollectionModels, this.roomTransfersCollectionId).subscribe(models => {
				models.forEach(roomTransfers => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RoomTransferModel.getProps(), this.roomTransfersRelations, this.isViewOnly),
						roomTransfers,
						RoomTransferModel,
						this.roomTransfersDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.roomTransfersRelations,
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
		if (this.targetModel.birthHistory && this.targetModel.birthHistory.id && this.birthHistoryMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BirthHistoryModel,
				this.birthHistoryOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.birthHistory.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBirthHistoryModelWithId, this.targetModel.birthHistoryId).subscribe(birthHistory => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BirthHistoryModel.getProps(), this.birthHistoryRelations, this.isViewOnly),
					birthHistory,
					BirthHistoryModel,
					this.birthHistoryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.birthHistoryRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bodyChartExamination && this.targetModel.bodyChartExamination.id && this.bodyChartExaminationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BodyChartExaminationModel,
				this.bodyChartExaminationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bodyChartExamination.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBodyChartExaminationModelWithId, this.targetModel.bodyChartExaminationId).subscribe(bodyChartExamination => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BodyChartExaminationModel.getProps(), this.bodyChartExaminationRelations, this.isViewOnly),
					bodyChartExamination,
					BodyChartExaminationModel,
					this.bodyChartExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bodyChartExaminationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.deliveryMedicalExaminationRecord && this.targetModel.deliveryMedicalExaminationRecord.id && this.deliveryMedicalExaminationRecordMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DeliveryMedicalExaminationRecordModel,
				this.deliveryMedicalExaminationRecordOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.deliveryMedicalExaminationRecord.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getDeliveryMedicalExaminationRecordModelWithId, this.targetModel.deliveryMedicalExaminationRecordId).subscribe(deliveryMedicalExaminationRecord => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DeliveryMedicalExaminationRecordModel.getProps(), this.deliveryMedicalExaminationRecordRelations, this.isViewOnly),
					deliveryMedicalExaminationRecord,
					DeliveryMedicalExaminationRecordModel,
					this.deliveryMedicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.deliveryMedicalExaminationRecordRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.entExamination && this.targetModel.entExamination.id && this.entExaminationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				EntExaminationModel,
				this.entExaminationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.entExamination.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getEntExaminationModelWithId, this.targetModel.entExaminationId).subscribe(entExamination => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(EntExaminationModel.getProps(), this.entExaminationRelations, this.isViewOnly),
					entExamination,
					EntExaminationModel,
					this.entExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.entExaminationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.emergencyMedicationExaminationRecord && this.targetModel.emergencyMedicationExaminationRecord.id && this.emergencyMedicationExaminationRecordMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				EmergencyMedicalExaminationRecordModel,
				this.emergencyMedicationExaminationRecordOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.emergencyMedicationExaminationRecord.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getEmergencyMedicalExaminationRecordModelWithId, this.targetModel.emergencyMedicationExaminationRecordId).subscribe(emergencyMedicationExaminationRecord => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(EmergencyMedicalExaminationRecordModel.getProps(), this.emergencyMedicationExaminationRecordRelations, this.isViewOnly),
					emergencyMedicationExaminationRecord,
					EmergencyMedicalExaminationRecordModel,
					this.emergencyMedicationExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.emergencyMedicationExaminationRecordRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.formulirKonselingTesHiv && this.targetModel.formulirKonselingTesHiv.id && this.formulirKonselingTesHivMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				FormulirKonselingTesHivModel,
				this.formulirKonselingTesHivOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.formulirKonselingTesHiv.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getFormulirKonselingTesHivModelWithId, this.targetModel.formulirKonselingTesHivId).subscribe(formulirKonselingTesHiv => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(FormulirKonselingTesHivModel.getProps(), this.formulirKonselingTesHivRelations, this.isViewOnly),
					formulirKonselingTesHiv,
					FormulirKonselingTesHivModel,
					this.formulirKonselingTesHivDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.formulirKonselingTesHivRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.hemodialysisExamination && this.targetModel.hemodialysisExamination.id && this.hemodialysisExaminationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				HemodialysisExaminationModel,
				this.hemodialysisExaminationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.hemodialysisExamination.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getHemodialysisExaminationModelWithId, this.targetModel.hemodialysisExaminationId).subscribe(hemodialysisExamination => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(HemodialysisExaminationModel.getProps(), this.hemodialysisExaminationRelations, this.isViewOnly),
					hemodialysisExamination,
					HemodialysisExaminationModel,
					this.hemodialysisExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.hemodialysisExaminationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalExaminationRecordDischargeSummary && this.targetModel.medicalExaminationRecordDischargeSummary.id && this.medicalExaminationRecordDischargeSummaryMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalExaminationRecordDischargeSummaryModel,
				this.medicalExaminationRecordDischargeSummaryOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalExaminationRecordDischargeSummary.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalExaminationRecordDischargeSummaryModelWithId, this.targetModel.medicalExaminationRecordDischargeSummaryId).subscribe(medicalExaminationRecordDischargeSummary => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalExaminationRecordDischargeSummaryModel.getProps(), this.medicalExaminationRecordDischargeSummaryRelations, this.isViewOnly),
					medicalExaminationRecordDischargeSummary,
					MedicalExaminationRecordDischargeSummaryModel,
					this.medicalExaminationRecordDischargeSummaryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalExaminationRecordDischargeSummaryRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalRecordInitialChecklist && this.targetModel.medicalRecordInitialChecklist.id && this.medicalRecordInitialChecklistMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalRecordInitialChecklistModel,
				this.medicalRecordInitialChecklistOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalRecordInitialChecklist.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalRecordInitialChecklistModelWithId, this.targetModel.medicalRecordInitialChecklistId).subscribe(medicalRecordInitialChecklist => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalRecordInitialChecklistModel.getProps(), this.medicalRecordInitialChecklistRelations, this.isViewOnly),
					medicalRecordInitialChecklist,
					MedicalRecordInitialChecklistModel,
					this.medicalRecordInitialChecklistDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalRecordInitialChecklistRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalRecordNextVerificationChecklist && this.targetModel.medicalRecordNextVerificationChecklist.id && this.medicalRecordNextVerificationChecklistMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalRecordNextVerificationChecklistModel,
				this.medicalRecordNextVerificationChecklistOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalRecordNextVerificationChecklist.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalRecordNextVerificationChecklistModelWithId, this.targetModel.medicalRecordNextVerificationChecklistId).subscribe(medicalRecordNextVerificationChecklist => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalRecordNextVerificationChecklistModel.getProps(), this.medicalRecordNextVerificationChecklistRelations, this.isViewOnly),
					medicalRecordNextVerificationChecklist,
					MedicalRecordNextVerificationChecklistModel,
					this.medicalRecordNextVerificationChecklistDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalRecordNextVerificationChecklistRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.nurseVitalSignMeasurement && this.targetModel.nurseVitalSignMeasurement.id && this.nurseVitalSignMeasurementMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				NurseVitalSignMeasurementModel,
				this.nurseVitalSignMeasurementOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.nurseVitalSignMeasurement.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getNurseVitalSignMeasurementModelWithId, this.targetModel.nurseVitalSignMeasurementId).subscribe(nurseVitalSignMeasurement => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(NurseVitalSignMeasurementModel.getProps(), this.nurseVitalSignMeasurementRelations, this.isViewOnly),
					nurseVitalSignMeasurement,
					NurseVitalSignMeasurementModel,
					this.nurseVitalSignMeasurementDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.nurseVitalSignMeasurementRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.obstetricAndGynecologyHistory && this.targetModel.obstetricAndGynecologyHistory.id && this.obstetricAndGynecologyHistoryMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				ObstetricAndGynecologyHistoryModel,
				this.obstetricAndGynecologyHistoryOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.obstetricAndGynecologyHistory.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getObstetricAndGynecologyHistoryModelWithId, this.targetModel.obstetricAndGynecologyHistoryId).subscribe(obstetricAndGynecologyHistory => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(ObstetricAndGynecologyHistoryModel.getProps(), this.obstetricAndGynecologyHistoryRelations, this.isViewOnly),
					obstetricAndGynecologyHistory,
					ObstetricAndGynecologyHistoryModel,
					this.obstetricAndGynecologyHistoryDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.obstetricAndGynecologyHistoryRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.odontogramExamination && this.targetModel.odontogramExamination.id && this.odontogramExaminationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				OdontogramExaminationModel,
				this.odontogramExaminationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.odontogramExamination.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getOdontogramExaminationModelWithId, this.targetModel.odontogramExaminationId).subscribe(odontogramExamination => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OdontogramExaminationModel.getProps(), this.odontogramExaminationRelations, this.isViewOnly),
					odontogramExamination,
					OdontogramExaminationModel,
					this.odontogramExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.odontogramExaminationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.operatingTheaterMedicalExaminationRecord && this.targetModel.operatingTheaterMedicalExaminationRecord.id && this.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				OperatingTheaterMedicalExaminationRecordModel,
				this.operatingTheaterMedicalExaminationRecordOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.operatingTheaterMedicalExaminationRecord.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getOperatingTheaterMedicalExaminationRecordModelWithId, this.targetModel.operatingTheaterMedicalExaminationRecordId).subscribe(operatingTheaterMedicalExaminationRecord => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OperatingTheaterMedicalExaminationRecordModel.getProps(), this.operatingTheaterMedicalExaminationRecordRelations, this.isViewOnly),
					operatingTheaterMedicalExaminationRecord,
					OperatingTheaterMedicalExaminationRecordModel,
					this.operatingTheaterMedicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.operatingTheaterMedicalExaminationRecordRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.ophthalmologyExamination && this.targetModel.ophthalmologyExamination.id && this.ophthalmologyExaminationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				OphthalmologyExaminationModel,
				this.ophthalmologyExaminationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.ophthalmologyExamination.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getOphthalmologyExaminationModelWithId, this.targetModel.ophthalmologyExaminationId).subscribe(ophthalmologyExamination => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(OphthalmologyExaminationModel.getProps(), this.ophthalmologyExaminationRelations, this.isViewOnly),
					ophthalmologyExamination,
					OphthalmologyExaminationModel,
					this.ophthalmologyExaminationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.ophthalmologyExaminationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.inpatientMedicalExaminationRecord && this.targetModel.inpatientMedicalExaminationRecord.id && this.inpatientMedicalExaminationRecordMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InpatientMedicalExaminationRecordModel,
				this.inpatientMedicalExaminationRecordOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.inpatientMedicalExaminationRecord.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getInpatientMedicalExaminationRecordModelWithId, this.targetModel.inpatientMedicalExaminationRecordId).subscribe(inpatientMedicalExaminationRecord => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InpatientMedicalExaminationRecordModel.getProps(), this.inpatientMedicalExaminationRecordRelations, this.isViewOnly),
					inpatientMedicalExaminationRecord,
					InpatientMedicalExaminationRecordModel,
					this.inpatientMedicalExaminationRecordDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.inpatientMedicalExaminationRecordRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.registration && this.targetModel.registration.id && this.registrationMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RegistrationModel,
				this.registrationOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.registration.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getRegistrationModelWithId, this.targetModel.registrationId).subscribe(registration => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationModel.getProps(), this.registrationRelations, this.isViewOnly),
					registration,
					RegistrationModel,
					this.registrationDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.registrationRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.doctor && this.targetModel.doctor.id && this.doctorMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.doctorOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.doctor.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.doctorId).subscribe(doctor => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.doctorRelations, this.isViewOnly),
					doctor,
					StaffModel,
					this.doctorDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.doctorRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.medicalTranscriber && this.targetModel.medicalTranscriber.id && this.medicalTranscriberMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.medicalTranscriberOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.medicalTranscriber.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.medicalTranscriberId).subscribe(medicalTranscriber => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.medicalTranscriberRelations, this.isViewOnly),
					medicalTranscriber,
					StaffModel,
					this.medicalTranscriberDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.medicalTranscriberRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.nurse && this.targetModel.nurse.id && this.nurseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				StaffModel,
				this.nurseOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.nurse.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getStaffModelWithId, this.targetModel.nurseId).subscribe(nurse => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(StaffModel.getProps(), this.nurseRelations, this.isViewOnly),
					nurse,
					StaffModel,
					this.nurseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.nurseRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.amendmentDetailsIds && this.targetModel.amendmentDetailsIds.length > 0 && this.amendmentDetailsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				AmendmentDetailModel,
				this.amendmentDetailsOppositeRelation,
				this.amendmentDetailsCollectionId,
				this.targetModel.amendmentDetailsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.coTreatingDoctorsIds && this.targetModel.coTreatingDoctorsIds.length > 0 && this.coTreatingDoctorsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				CoTreatingDoctorModel,
				this.coTreatingDoctorsOppositeRelation,
				this.coTreatingDoctorsCollectionId,
				this.targetModel.coTreatingDoctorsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.dailyCareCPPTsIds && this.targetModel.dailyCareCPPTsIds.length > 0 && this.dailyCareCPPTsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DailyCareCPPTModel,
				this.dailyCareCPPTsOppositeRelation,
				this.dailyCareCPPTsCollectionId,
				this.targetModel.dailyCareCPPTsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.diagnosisExaminationRecordsIds && this.targetModel.diagnosisExaminationRecordsIds.length > 0 && this.diagnosisExaminationRecordsMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosisExaminationRecordModel,
				this.diagnosisExaminationRecordsOppositeRelation,
				this.diagnosisExaminationRecordsCollectionId,
				this.targetModel.diagnosisExaminationRecordsIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.diagnosisNandasIds && this.targetModel.diagnosisNandasIds.length > 0 && this.diagnosisNandasMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosisNandaModel,
				this.diagnosisNandasOppositeRelation,
				this.diagnosisNandasCollectionId,
				this.targetModel.diagnosisNandasIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.roomTransfersIds && this.targetModel.roomTransfersIds.length > 0 && this.roomTransfersMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RoomTransferModel,
				this.roomTransfersOppositeRelation,
				this.roomTransfersCollectionId,
				this.targetModel.roomTransfersIds.length,
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
	addAdditionalEntitiesToModel(model: MedicalExaminationRecordModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): MedicalExaminationRecordModel {
		let updatedModel: MedicalExaminationRecordModel = new MedicalExaminationRecordModel(model);

		if (this.inpatientMedicalExaminationRecordMultiCrudActive) {
			updatedModel.inpatientMedicalExaminationRecord = event.additionalEntities.inpatientMedicalExaminationRecord ? event.additionalEntities.inpatientMedicalExaminationRecord : undefined;

			if (!updatedModel.inpatientMedicalExaminationRecord && event.payload) {
				event.payload.inpatientMedicalExaminationRecordId = null;
			}
		} else if (event.payload?.inpatientMedicalExaminationRecordId !== undefined) {
			event.payload.inpatientMedicalExaminationRecord = null;
			updatedModel.inpatientMedicalExaminationRecord = null;
		}

		if (this.registrationMultiCrudActive) {
			updatedModel.registration = event.additionalEntities.registration ? event.additionalEntities.registration : undefined;

			if (!updatedModel.registration && event.payload) {
				event.payload.registrationId = null;
			}
		} else if (event.payload?.registrationId !== undefined) {
			event.payload.registration = null;
			updatedModel.registration = null;
		}

		if (this.birthHistoryMultiCrudActive) {
			updatedModel.birthHistory = event.additionalEntities.birthHistory ? event.additionalEntities.birthHistory : undefined;

			if (!updatedModel.birthHistory && event.payload) {
				event.payload.birthHistoryId = null;
			}
		} else if (event.payload?.birthHistoryId !== undefined) {
			event.payload.birthHistory = null;
			updatedModel.birthHistory = null;
		}

		if (this.bodyChartExaminationMultiCrudActive) {
			updatedModel.bodyChartExamination = event.additionalEntities.bodyChartExamination ? event.additionalEntities.bodyChartExamination : undefined;

			if (!updatedModel.bodyChartExamination && event.payload) {
				event.payload.bodyChartExaminationId = null;
			}
		} else if (event.payload?.bodyChartExaminationId !== undefined) {
			event.payload.bodyChartExamination = null;
			updatedModel.bodyChartExamination = null;
		}

		if (this.deliveryMedicalExaminationRecordMultiCrudActive) {
			updatedModel.deliveryMedicalExaminationRecord = event.additionalEntities.deliveryMedicalExaminationRecord ? event.additionalEntities.deliveryMedicalExaminationRecord : undefined;

			if (!updatedModel.deliveryMedicalExaminationRecord && event.payload) {
				event.payload.deliveryMedicalExaminationRecordId = null;
			}
		} else if (event.payload?.deliveryMedicalExaminationRecordId !== undefined) {
			event.payload.deliveryMedicalExaminationRecord = null;
			updatedModel.deliveryMedicalExaminationRecord = null;
		}

		if (this.entExaminationMultiCrudActive) {
			updatedModel.entExamination = event.additionalEntities.entExamination ? event.additionalEntities.entExamination : undefined;

			if (!updatedModel.entExamination && event.payload) {
				event.payload.entExaminationId = null;
			}
		} else if (event.payload?.entExaminationId !== undefined) {
			event.payload.entExamination = null;
			updatedModel.entExamination = null;
		}

		if (this.emergencyMedicationExaminationRecordMultiCrudActive) {
			updatedModel.emergencyMedicationExaminationRecord = event.additionalEntities.emergencyMedicationExaminationRecord ? event.additionalEntities.emergencyMedicationExaminationRecord : undefined;

			if (!updatedModel.emergencyMedicationExaminationRecord && event.payload) {
				event.payload.emergencyMedicationExaminationRecordId = null;
			}
		} else if (event.payload?.emergencyMedicationExaminationRecordId !== undefined) {
			event.payload.emergencyMedicationExaminationRecord = null;
			updatedModel.emergencyMedicationExaminationRecord = null;
		}

		if (this.formulirKonselingTesHivMultiCrudActive) {
			updatedModel.formulirKonselingTesHiv = event.additionalEntities.formulirKonselingTesHiv ? event.additionalEntities.formulirKonselingTesHiv : undefined;

			if (!updatedModel.formulirKonselingTesHiv && event.payload) {
				event.payload.formulirKonselingTesHivId = null;
			}
		} else if (event.payload?.formulirKonselingTesHivId !== undefined) {
			event.payload.formulirKonselingTesHiv = null;
			updatedModel.formulirKonselingTesHiv = null;
		}

		if (this.hemodialysisExaminationMultiCrudActive) {
			updatedModel.hemodialysisExamination = event.additionalEntities.hemodialysisExamination ? event.additionalEntities.hemodialysisExamination : undefined;

			if (!updatedModel.hemodialysisExamination && event.payload) {
				event.payload.hemodialysisExaminationId = null;
			}
		} else if (event.payload?.hemodialysisExaminationId !== undefined) {
			event.payload.hemodialysisExamination = null;
			updatedModel.hemodialysisExamination = null;
		}

		if (this.medicalExaminationRecordDischargeSummaryMultiCrudActive) {
			updatedModel.medicalExaminationRecordDischargeSummary = event.additionalEntities.medicalExaminationRecordDischargeSummary ? event.additionalEntities.medicalExaminationRecordDischargeSummary : undefined;

			if (!updatedModel.medicalExaminationRecordDischargeSummary && event.payload) {
				event.payload.medicalExaminationRecordDischargeSummaryId = null;
			}
		} else if (event.payload?.medicalExaminationRecordDischargeSummaryId !== undefined) {
			event.payload.medicalExaminationRecordDischargeSummary = null;
			updatedModel.medicalExaminationRecordDischargeSummary = null;
		}

		if (this.medicalRecordInitialChecklistMultiCrudActive) {
			updatedModel.medicalRecordInitialChecklist = event.additionalEntities.medicalRecordInitialChecklist ? event.additionalEntities.medicalRecordInitialChecklist : undefined;

			if (!updatedModel.medicalRecordInitialChecklist && event.payload) {
				event.payload.medicalRecordInitialChecklistId = null;
			}
		} else if (event.payload?.medicalRecordInitialChecklistId !== undefined) {
			event.payload.medicalRecordInitialChecklist = null;
			updatedModel.medicalRecordInitialChecklist = null;
		}

		if (this.medicalRecordNextVerificationChecklistMultiCrudActive) {
			updatedModel.medicalRecordNextVerificationChecklist = event.additionalEntities.medicalRecordNextVerificationChecklist ? event.additionalEntities.medicalRecordNextVerificationChecklist : undefined;

			if (!updatedModel.medicalRecordNextVerificationChecklist && event.payload) {
				event.payload.medicalRecordNextVerificationChecklistId = null;
			}
		} else if (event.payload?.medicalRecordNextVerificationChecklistId !== undefined) {
			event.payload.medicalRecordNextVerificationChecklist = null;
			updatedModel.medicalRecordNextVerificationChecklist = null;
		}

		if (this.nurseVitalSignMeasurementMultiCrudActive) {
			updatedModel.nurseVitalSignMeasurement = event.additionalEntities.nurseVitalSignMeasurement ? event.additionalEntities.nurseVitalSignMeasurement : undefined;

			if (!updatedModel.nurseVitalSignMeasurement && event.payload) {
				event.payload.nurseVitalSignMeasurementId = null;
			}
		} else if (event.payload?.nurseVitalSignMeasurementId !== undefined) {
			event.payload.nurseVitalSignMeasurement = null;
			updatedModel.nurseVitalSignMeasurement = null;
		}

		if (this.obstetricAndGynecologyHistoryMultiCrudActive) {
			updatedModel.obstetricAndGynecologyHistory = event.additionalEntities.obstetricAndGynecologyHistory ? event.additionalEntities.obstetricAndGynecologyHistory : undefined;

			if (!updatedModel.obstetricAndGynecologyHistory && event.payload) {
				event.payload.obstetricAndGynecologyHistoryId = null;
			}
		} else if (event.payload?.obstetricAndGynecologyHistoryId !== undefined) {
			event.payload.obstetricAndGynecologyHistory = null;
			updatedModel.obstetricAndGynecologyHistory = null;
		}

		if (this.odontogramExaminationMultiCrudActive) {
			updatedModel.odontogramExamination = event.additionalEntities.odontogramExamination ? event.additionalEntities.odontogramExamination : undefined;

			if (!updatedModel.odontogramExamination && event.payload) {
				event.payload.odontogramExaminationId = null;
			}
		} else if (event.payload?.odontogramExaminationId !== undefined) {
			event.payload.odontogramExamination = null;
			updatedModel.odontogramExamination = null;
		}

		if (this.operatingTheaterMedicalExaminationRecordMultiCrudActive) {
			updatedModel.operatingTheaterMedicalExaminationRecord = event.additionalEntities.operatingTheaterMedicalExaminationRecord ? event.additionalEntities.operatingTheaterMedicalExaminationRecord : undefined;

			if (!updatedModel.operatingTheaterMedicalExaminationRecord && event.payload) {
				event.payload.operatingTheaterMedicalExaminationRecordId = null;
			}
		} else if (event.payload?.operatingTheaterMedicalExaminationRecordId !== undefined) {
			event.payload.operatingTheaterMedicalExaminationRecord = null;
			updatedModel.operatingTheaterMedicalExaminationRecord = null;
		}

		if (this.ophthalmologyExaminationMultiCrudActive) {
			updatedModel.ophthalmologyExamination = event.additionalEntities.ophthalmologyExamination ? event.additionalEntities.ophthalmologyExamination : undefined;

			if (!updatedModel.ophthalmologyExamination && event.payload) {
				event.payload.ophthalmologyExaminationId = null;
			}
		} else if (event.payload?.ophthalmologyExaminationId !== undefined) {
			event.payload.ophthalmologyExamination = null;
			updatedModel.ophthalmologyExamination = null;
		}

		if (this.doctorMultiCrudActive) {
			updatedModel.doctor = event.additionalEntities.doctor ? event.additionalEntities.doctor : undefined;

			if (!updatedModel.doctor && event.payload) {
				event.payload.doctorId = null;
			}
		} else if (event.payload?.doctorId !== undefined) {
			event.payload.doctor = null;
			updatedModel.doctor = null;
		}

		if (this.medicalTranscriberMultiCrudActive) {
			updatedModel.medicalTranscriber = event.additionalEntities.medicalTranscriber ? event.additionalEntities.medicalTranscriber : undefined;

			if (!updatedModel.medicalTranscriber && event.payload) {
				event.payload.medicalTranscriberId = null;
			}
		} else if (event.payload?.medicalTranscriberId !== undefined) {
			event.payload.medicalTranscriber = null;
			updatedModel.medicalTranscriber = null;
		}

		if (this.nurseMultiCrudActive) {
			updatedModel.nurse = event.additionalEntities.nurse ? event.additionalEntities.nurse : undefined;

			if (!updatedModel.nurse && event.payload) {
				event.payload.nurseId = null;
			}
		} else if (event.payload?.nurseId !== undefined) {
			event.payload.nurse = null;
			updatedModel.nurse = null;
		}

		updatedModel.amendmentDetails = [];
		if (this.amendmentDetailsMultiCrudActive) {
			if (event.additionalEntities.amendmentDetails) {
				event.additionalEntities.amendmentDetails.forEach(entity => {
					updatedModel.amendmentDetails.push(entity);
				});
			}

			if (!updatedModel.amendmentDetails.length) {
				updatedModel.amendmentDetailsIds = [];
			}
		}
		updatedModel.coTreatingDoctors = [];
		if (this.coTreatingDoctorsMultiCrudActive) {
			if (event.additionalEntities.coTreatingDoctors) {
				event.additionalEntities.coTreatingDoctors.forEach(entity => {
					updatedModel.coTreatingDoctors.push(entity);
				});
			}

			if (!updatedModel.coTreatingDoctors.length) {
				updatedModel.coTreatingDoctorsIds = [];
			}
		}
		updatedModel.dailyCareCPPTs = [];
		if (this.dailyCareCPPTsMultiCrudActive) {
			if (event.additionalEntities.dailyCareCPPTs) {
				event.additionalEntities.dailyCareCPPTs.forEach(entity => {
					updatedModel.dailyCareCPPTs.push(entity);
				});
			}

			if (!updatedModel.dailyCareCPPTs.length) {
				updatedModel.dailyCareCPPTsIds = [];
			}
		}
		updatedModel.diagnosisExaminationRecords = [];
		if (this.diagnosisExaminationRecordsMultiCrudActive) {
			if (event.additionalEntities.diagnosisExaminationRecords) {
				event.additionalEntities.diagnosisExaminationRecords.forEach(entity => {
					updatedModel.diagnosisExaminationRecords.push(entity);
				});
			}

			if (!updatedModel.diagnosisExaminationRecords.length) {
				updatedModel.diagnosisExaminationRecordsIds = [];
			}
		}
		updatedModel.diagnosisNandas = [];
		if (this.diagnosisNandasMultiCrudActive) {
			if (event.additionalEntities.diagnosisNandas) {
				event.additionalEntities.diagnosisNandas.forEach(entity => {
					updatedModel.diagnosisNandas.push(entity);
				});
			}

			if (!updatedModel.diagnosisNandas.length) {
				updatedModel.diagnosisNandasIds = [];
			}
		}
		updatedModel.roomTransfers = [];
		if (this.roomTransfersMultiCrudActive) {
			if (event.additionalEntities.roomTransfers) {
				event.additionalEntities.roomTransfers.forEach(entity => {
					updatedModel.roomTransfers.push(entity);
				});
			}

			if (!updatedModel.roomTransfers.length) {
				updatedModel.roomTransfersIds = [];
			}
		}
		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
