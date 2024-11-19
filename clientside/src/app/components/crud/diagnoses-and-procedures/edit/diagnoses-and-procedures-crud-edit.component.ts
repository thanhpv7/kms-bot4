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
import * as modelAction from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.action';
import {DiagnosesAndProceduresModelState, DiagnosesAndProceduresModelAudit} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.state';
import {DiagnosesAndProceduresModel} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model';
import {
	getDiagnosesAndProceduresModelAuditsByEntityId,
	getDiagnosesAndProceduresModelWithId,
	getCountDiagnosesAndProceduresModels,
} from 'src/app/models/diagnosesAndProcedures/diagnoses_and_procedures.model.selector';
import {getRouterState} from 'src/app/models/model.selector';
import {BpjsDiagnoseModel} from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model';
import * as bpjsDiagnoseModelAction from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.action';
import {
	getBpjsDiagnoseCollectionModels, getBpjsDiagnoseModelWithId,
} from 'src/app/models/bpjsDiagnose/bpjs_diagnose.model.selector';
import {BpjsDiagnosePRBModel} from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model';
import * as bpjsDiagnosePRBModelAction from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.action';
import {
	getBpjsDiagnosePRBCollectionModels, getBpjsDiagnosePRBModelWithId,
} from 'src/app/models/bpjsDiagnosePRB/bpjs_diagnose_prb.model.selector';
import {DailyCareCPPTModel} from 'src/app/models/dailyCareCPPT/daily_care_cppt.model';
import * as dailyCareCPPTModelAction from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.action';
import {
	getDailyCareCPPTCollectionModels, getDailyCareCPPTModelWithId,
} from 'src/app/models/dailyCareCPPT/daily_care_cppt.model.selector';
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
import {Icd10Model} from 'src/app/models/icd10/icd_10.model';
import * as icd10ModelAction from 'src/app/models/icd10/icd_10.model.action';
import {
	getIcd10CollectionModels, getIcd10ModelWithId,
} from 'src/app/models/icd10/icd_10.model.selector';
import {Icd9CMModel} from 'src/app/models/icd9CM/icd_9_cm.model';
import * as icd9CMModelAction from 'src/app/models/icd9CM/icd_9_cm.model.action';
import {
	getIcd9CMCollectionModels, getIcd9CMModelWithId,
} from 'src/app/models/icd9CM/icd_9_cm.model.selector';
import {InvoiceModel} from 'src/app/models/invoice/invoice.model';
import * as invoiceModelAction from 'src/app/models/invoice/invoice.model.action';
import {
	getInvoiceCollectionModels, getInvoiceModelWithId,
} from 'src/app/models/invoice/invoice.model.selector';
import {MedicalCertificateDischargeResumeModel} from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import * as medicalCertificateDischargeResumeModelAction from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.action';
import {
	getMedicalCertificateDischargeResumeCollectionModels, getMedicalCertificateDischargeResumeModelWithId,
} from 'src/app/models/medicalCertificateDischargeResume/medical_certificate_discharge_resume.model.selector';
import {PostOperativeDetailsModel} from 'src/app/models/postOperativeDetails/post_operative_details.model';
import * as postOperativeDetailsModelAction from 'src/app/models/postOperativeDetails/post_operative_details.model.action';
import {
	getPostOperativeDetailsCollectionModels, getPostOperativeDetailsModelWithId,
} from 'src/app/models/postOperativeDetails/post_operative_details.model.selector';
import {PreoperativeRecordsModel} from 'src/app/models/preoperativeRecords/preoperative_records.model';
import * as preoperativeRecordsModelAction from 'src/app/models/preoperativeRecords/preoperative_records.model.action';
import {
	getPreoperativeRecordsCollectionModels, getPreoperativeRecordsModelWithId,
} from 'src/app/models/preoperativeRecords/preoperative_records.model.selector';
import {RegistrationModel} from 'src/app/models/registration/registration.model';
import * as registrationModelAction from 'src/app/models/registration/registration.model.action';
import {
	getRegistrationCollectionModels, getRegistrationModelWithId,
} from 'src/app/models/registration/registration.model.selector';
import {RouterState} from 'src/app/models/model.state';
import {PassableStateConfig, QueryOperation, QueryParams, Where, Expand} from 'src/app/lib/services/http/interfaces';
import {createReactiveFormFromModel, fetchPrepareReferenceRequirements, getNewModelProperties, multiCrudExtraEntityAction, PrepareReferenceRequirements} from 'src/app/lib/models/model-utils';
import {CrudTileMode} from '../diagnoses-and-procedures-crud.component';
import {v4 as uuidv4} from 'uuid';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

// % protected region % [Add any additional definitions here] off begin
// % protected region % [Add any additional definitions here] end

@Component({
	selector: 'cb-diagnoses-and-procedures-crud-edit',
	templateUrl: './diagnoses-and-procedures-crud-edit.component.html',
	styleUrls: [
		'./diagnoses-and-procedures-crud-edit.component.scss',
		// % protected region % [Add any additional CSS styling here] off begin
		// % protected region % [Add any additional CSS styling here] end
	],
	// % protected region % [Add any additional component configuration here] off begin
	// % protected region % [Add any additional component configuration here] end
})
export class DiagnosesAndProceduresCrudEditComponent
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
	collectionId: string = '5c9fcfb8-1453-4986-92a1-8b320c41ec11';
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
	diagnosesAndProceduresAudits$: Observable<DiagnosesAndProceduresModelAudit[]>;

	/**
	 * Subscribe to changes in the number of entities, so that returning to crud list
	 * in single page mode can wait until the entity has been created
	 */
	creationNavigationSubscription$: Subscription = new Subscription();

	// Fields for implementing multi entity crud
	// Swap the boolean for any relation to true to activate multi entity crud
	// The display names for references can also be changed here.  This will modify the name of the group when it is shown on the crud edit page

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Diagnoses and Procedures and Master ICD 10 here] off begin
	masterICD10MultiCrudActive: boolean = false;
	masterICD10DisplayName = 'Master ICD 10';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Diagnoses and Procedures and Master ICD 10 here] end
	masterICD10OppositeRelation = 'diagnosesAndProcedures';
	masterICD10Relations: ModelRelation[] = this.masterICD10MultiCrudActive ? Icd10Model.getRelations()
		.map(relation => {
			if (relation.id === this.masterICD10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Diagnoses and Procedures and Master ICD 9 CM here] off begin
	masterICD9CMMultiCrudActive: boolean = false;
	masterICD9CMDisplayName = 'Master ICD 9 CM';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Diagnoses and Procedures and Master ICD 9 CM here] end
	masterICD9CMOppositeRelation = 'diagnosesAndProcedures';
	masterICD9CMRelations: ModelRelation[] = this.masterICD9CMMultiCrudActive ? Icd9CMModel.getRelations()
		.map(relation => {
			if (relation.id === this.masterICD9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and Diagnoses and Procedures here] off begin
	bpjsDiagnoseMultiCrudActive: boolean = false;
	bpjsDiagnoseDisplayName = 'BPJS Diagnose';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose and Diagnoses and Procedures here] end
	bpjsDiagnoseOppositeRelation = 'diagnosesAndProcedures';
	bpjsDiagnoseRelations: ModelRelation[] = this.bpjsDiagnoseMultiCrudActive ? BpjsDiagnoseModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsDiagnoseOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose PRB and Diagnoses and Procedures here] off begin
	bpjsDiagnosePRBMultiCrudActive: boolean = false;
	bpjsDiagnosePRBDisplayName = 'BPJS Diagnose PRB';
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between BPJS Diagnose PRB and Diagnoses and Procedures here] end
	bpjsDiagnosePRBOppositeRelation = 'diagnosesAndProcedures';
	bpjsDiagnosePRBRelations: ModelRelation[] = this.bpjsDiagnosePRBMultiCrudActive ? BpjsDiagnosePRBModel.getRelations()
		.map(relation => {
			if (relation.id === this.bpjsDiagnosePRBOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Admission ICD 10 and Admission ICD 10 here] off begin
	admissionICD10MultiCrudActive: boolean = false;
	admissionICD10DisplayName = 'Admission ICD 10';
	admissionICD10CollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Admission ICD 10 and Admission ICD 10 here] end
	admissionICD10OppositeRelation = 'admissionICD10';
	admissionICD10Relations: ModelRelation[] = this.admissionICD10MultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.admissionICD10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Admission ICD 9 CM and Admission ICD 9 CM here] off begin
	admissionICD9CMMultiCrudActive: boolean = false;
	admissionICD9CMDisplayName = 'Admission ICD 9 CM';
	admissionICD9CMCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Admission ICD 9 CM and Admission ICD 9 CM here] end
	admissionICD9CMOppositeRelation = 'admissionICD9CM';
	admissionICD9CMRelations: ModelRelation[] = this.admissionICD9CMMultiCrudActive ? RegistrationModel.getRelations()
		.map(relation => {
			if (relation.id === this.admissionICD9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 10 and CPPT ICD 10 here] off begin
	cpptICD10MultiCrudActive: boolean = false;
	cpptICD10DisplayName = 'CPPT ICD 10';
	cpptICD10CollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 10 and CPPT ICD 10 here] end
	cpptICD10OppositeRelation = 'icd10';
	cpptICD10Relations: ModelRelation[] = this.cpptICD10MultiCrudActive ? DailyCareCPPTModel.getRelations()
		.map(relation => {
			if (relation.id === this.cpptICD10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 9 CM and CPPT ICD 9 CM here] off begin
	cpptICD9CMMultiCrudActive: boolean = false;
	cpptICD9CMDisplayName = 'CPPT ICD 9 CM';
	cpptICD9CMCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 9 CM and CPPT ICD 9 CM here] end
	cpptICD9CMOppositeRelation = 'icd9CM';
	cpptICD9CMRelations: ModelRelation[] = this.cpptICD9CMMultiCrudActive ? DailyCareCPPTModel.getRelations()
		.map(relation => {
			if (relation.id === this.cpptICD9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Discharge ICD 10 and Discharge ICD 10 here] off begin
	dischargeICD10MultiCrudActive: boolean = false;
	dischargeICD10DisplayName = 'Discharge ICD 10';
	dischargeICD10CollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Discharge ICD 10 and Discharge ICD 10 here] end
	dischargeICD10OppositeRelation = 'dischargeICD10';
	dischargeICD10Relations: ModelRelation[] = this.dischargeICD10MultiCrudActive ? MedicalCertificateDischargeResumeModel.getRelations()
		.map(relation => {
			if (relation.id === this.dischargeICD10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Discharge ICD 9 CM and Discharge ICD 9 CM here] off begin
	dischargeICD9CMMultiCrudActive: boolean = false;
	dischargeICD9CMDisplayName = 'Discharge ICD 9 CM';
	dischargeICD9CMCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Discharge ICD 9 CM and Discharge ICD 9 CM here] end
	dischargeICD9CMOppositeRelation = 'dischargeICD9CM';
	dischargeICD9CMRelations: ModelRelation[] = this.dischargeICD9CMMultiCrudActive ? MedicalCertificateDischargeResumeModel.getRelations()
		.map(relation => {
			if (relation.id === this.dischargeICD9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 10 and ICD 10 here] off begin
	icd10MultiCrudActive: boolean = false;
	icd10DisplayName = 'ICD 10';
	icd10CollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 10 and ICD 10 here] end
	icd10OppositeRelation = 'icd10';
	icd10Relations: ModelRelation[] = this.icd10MultiCrudActive ? DiagnosisExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.icd10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 9 CM and ICD 9 CM here] off begin
	icd9CMMultiCrudActive: boolean = false;
	icd9CMDisplayName = 'ICD 9 CM';
	icd9CMCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 9 CM and ICD 9 CM here] end
	icd9CMOppositeRelation = 'icd9CM';
	icd9CMRelations: ModelRelation[] = this.icd9CMMultiCrudActive ? DiagnosisExaminationRecordModel.getRelations()
		.map(relation => {
			if (relation.id === this.icd9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 10 and Invoices ICD 10 here] off begin
	invoicesICD10MultiCrudActive: boolean = false;
	invoicesICD10DisplayName = 'Invoices ICD 10';
	invoicesICD10CollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 10 and Invoices ICD 10 here] end
	invoicesICD10OppositeRelation = 'icd10';
	invoicesICD10Relations: ModelRelation[] = this.invoicesICD10MultiCrudActive ? InvoiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoicesICD10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 9 CM and Invoices ICD 9 CM here] off begin
	invoicesICD9CMMultiCrudActive: boolean = false;
	invoicesICD9CMDisplayName = 'Invoices ICD 9 CM';
	invoicesICD9CMCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between ICD 9 CM and Invoices ICD 9 CM here] end
	invoicesICD9CMOppositeRelation = 'icd9CM';
	invoicesICD9CMRelations: ModelRelation[] = this.invoicesICD9CMMultiCrudActive ? InvoiceModel.getRelations()
		.map(relation => {
			if (relation.id === this.invoicesICD9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Post Operative ICD 10 and Post Operative ICD 10 here] off begin
	postOperativeICD10MultiCrudActive: boolean = false;
	postOperativeICD10DisplayName = 'Post Operative ICD 10';
	postOperativeICD10CollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Post Operative ICD 10 and Post Operative ICD 10 here] end
	postOperativeICD10OppositeRelation = 'postOperativeICD10';
	postOperativeICD10Relations: ModelRelation[] = this.postOperativeICD10MultiCrudActive ? PostOperativeDetailsModel.getRelations()
		.map(relation => {
			if (relation.id === this.postOperativeICD10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Post Operative ICD 9 CM and Post Operative ICD 9 CM here] off begin
	postOperativeICD9CMMultiCrudActive: boolean = false;
	postOperativeICD9CMDisplayName = 'Post Operative ICD 9 CM';
	postOperativeICD9CMCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Post Operative ICD 9 CM and Post Operative ICD 9 CM here] end
	postOperativeICD9CMOppositeRelation = 'postOperativeICD9CM';
	postOperativeICD9CMRelations: ModelRelation[] = this.postOperativeICD9CMMultiCrudActive ? PostOperativeDetailsModel.getRelations()
		.map(relation => {
			if (relation.id === this.postOperativeICD9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pre Surgery ICD 10 and Pre Surgery ICD 10 here] off begin
	preSurgeryICD10MultiCrudActive: boolean = false;
	preSurgeryICD10DisplayName = 'Pre Surgery ICD 10';
	preSurgeryICD10CollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pre Surgery ICD 10 and Pre Surgery ICD 10 here] end
	preSurgeryICD10OppositeRelation = 'preSurgeryICD10';
	preSurgeryICD10Relations: ModelRelation[] = this.preSurgeryICD10MultiCrudActive ? PreoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.preSurgeryICD10OppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pre Surgery ICD 9 CM and Pre Surgery ICD 9 CM here] off begin
	preSurgeryICD9CMMultiCrudActive: boolean = false;
	preSurgeryICD9CMDisplayName = 'Pre Surgery ICD 9 CM';
	preSurgeryICD9CMCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between Pre Surgery ICD 9 CM and Pre Surgery ICD 9 CM here] end
	preSurgeryICD9CMOppositeRelation = 'preSurgeryICD9CM';
	preSurgeryICD9CMRelations: ModelRelation[] = this.preSurgeryICD9CMMultiCrudActive ? PreoperativeRecordsModel.getRelations()
		.map(relation => {
			if (relation.id === this.preSurgeryICD9CMOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];

	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between NURSING and Diagnosis Nandas here] off begin
	diagnosisNandasMultiCrudActive: boolean = false;
	diagnosisNandasDisplayName = 'Diagnosis Nandas';
	diagnosisNandasCollectionId: string = uuidv4();
	// % protected region % [Modify the display name and the flag for enabling multi entity crud and on relation between NURSING and Diagnosis Nandas here] end
	diagnosisNandasOppositeRelation = 'nursing';
	diagnosisNandasRelations: ModelRelation[] = this.diagnosisNandasMultiCrudActive ? DiagnosisNandaModel.getRelations()
		.map(relation => {
			if (relation.id === this.diagnosisNandasOppositeRelation) {
				relation.hideElement = true;
			}
			return this.prepareSingleReferenceCollection(relation);
		}) : [];


	// % protected region % [Change your model properties here] off begin
	/**
	 * List of all property names for this entity.
	 */
	modelProperties: ModelProperty[] = DiagnosesAndProceduresModel.getProps();
	// % protected region % [Change your model properties here] end

	// % protected region % [Change your model relations here] off begin
	/**
	 * List of all relations of the model
	 */
	modelRelations: ModelRelation[] = DiagnosesAndProceduresModel.getRelations();
	// % protected region % [Change your model relations here] end

	// % protected region % [Change your default expands if required here] off begin
	/**
	 * Default references to expand
	 * In CRUD tile, default to expand all the references
	 */
	private get defaultExpands(): Expand[] {
		let expands: Expand[] = DiagnosesAndProceduresModel.getRelations().map(
			relation => {
				let exp = {
					name: relation.id,
					fields: ['id', relation.displayName],
				};

				if (relation.id === 'masterICD10' && this.masterICD10MultiCrudActive) {
					exp.fields = Icd10Model.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'masterICD9CM' && this.masterICD9CMMultiCrudActive) {
					exp.fields = Icd9CMModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsDiagnose' && this.bpjsDiagnoseMultiCrudActive) {
					exp.fields = BpjsDiagnoseModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'bpjsDiagnosePRB' && this.bpjsDiagnosePRBMultiCrudActive) {
					exp.fields = BpjsDiagnosePRBModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'admissionICD10' && this.admissionICD10MultiCrudActive) {
					exp.fields = RegistrationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'admissionICD9CM' && this.admissionICD9CMMultiCrudActive) {
					exp.fields = RegistrationModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'cpptICD10' && this.cpptICD10MultiCrudActive) {
					exp.fields = DailyCareCPPTModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'cpptICD9CM' && this.cpptICD9CMMultiCrudActive) {
					exp.fields = DailyCareCPPTModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'dischargeICD10' && this.dischargeICD10MultiCrudActive) {
					exp.fields = MedicalCertificateDischargeResumeModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'dischargeICD9CM' && this.dischargeICD9CMMultiCrudActive) {
					exp.fields = MedicalCertificateDischargeResumeModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'icd10' && this.icd10MultiCrudActive) {
					exp.fields = DiagnosisExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'icd9CM' && this.icd9CMMultiCrudActive) {
					exp.fields = DiagnosisExaminationRecordModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoicesICD10' && this.invoicesICD10MultiCrudActive) {
					exp.fields = InvoiceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'invoicesICD9CM' && this.invoicesICD9CMMultiCrudActive) {
					exp.fields = InvoiceModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'postOperativeICD10' && this.postOperativeICD10MultiCrudActive) {
					exp.fields = PostOperativeDetailsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'postOperativeICD9CM' && this.postOperativeICD9CMMultiCrudActive) {
					exp.fields = PostOperativeDetailsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'preSurgeryICD10' && this.preSurgeryICD10MultiCrudActive) {
					exp.fields = PreoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'preSurgeryICD9CM' && this.preSurgeryICD9CMMultiCrudActive) {
					exp.fields = PreoperativeRecordsModel.getProps().map(prop => {
						return prop.name;
					});
				}

				if (relation.id === 'diagnosisNandas' && this.diagnosisNandasMultiCrudActive) {
					exp.fields = DiagnosisNandaModel.getProps().map(prop => {
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
	targetModel: DiagnosesAndProceduresModel;

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
		private readonly store: Store<{ model: DiagnosesAndProceduresModelState }>,
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
		this.creationNavigationSubscription$.add(this.store.select(getCountDiagnosesAndProceduresModels).subscribe(count => {
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

			this.targetModel = new DiagnosesAndProceduresModel();

			// % protected region % [Add additional processing for Create mode after the main body here] off begin
			// % protected region % [Add additional processing for Create mode after the main body here] end
		}
		// % protected region % [Add any additional states for this.tileMode here] off begin
		// % protected region % [Add any additional states for this.tileMode here] end

		if (this.targetModelId) {
			this.diagnosesAndProceduresAudits$ = this.store.select(getDiagnosesAndProceduresModelAuditsByEntityId, this.targetModelId);
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
		const stateConfig: PassableStateConfig<DiagnosesAndProceduresModel> = {
			targetModelId: this.targetModelId,
			queryParams: {
				expands: this.defaultExpands
			}
		};

		// % protected region % [Add additional processing for state configuration here] off begin
		// % protected region % [Add additional processing for state configuration here] end

		// Fetch models
		this.store.dispatch(new modelAction.DiagnosesAndProceduresAction(
			modelAction.DiagnosesAndProceduresModelActionTypes.FETCH_DIAGNOSES_AND_PROCEDURES,
			stateConfig
		));

		this.creationNavigationSubscription$.add(this.store.select(getDiagnosesAndProceduresModelWithId, this.targetModelId)
			// % protected region % [Add any additional logic to store.select here] off begin
			// % protected region % [Add any additional logic to store.select here] end
				.subscribe(model => {

			// It's possible that after updating a relation to remove an entity, that the entity id won't be updated.
			// We need to make sure that the ids are synced before we continue
			model = new DiagnosesAndProceduresModel(model);
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
				commands.push('diagnoses-and-procedures');
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

		this.store.dispatch(new modelAction.DiagnosesAndProceduresAction(
			modelAction.DiagnosesAndProceduresModelActionTypes.FETCH_DIAGNOSES_AND_PROCEDURES_AUDITS_BY_ENTITY_ID,
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
			let stateConfig: PassableStateConfig<DiagnosesAndProceduresModel> = {
				targetModel: this.targetModel,
				collectionId: this.collectionId,
				queryParams: {
					persistRelations: this.bpjsDiagnoseMultiCrudActive || this.bpjsDiagnosePRBMultiCrudActive || this.masterICD10MultiCrudActive || this.masterICD9CMMultiCrudActive || this.admissionICD10MultiCrudActive || this.admissionICD9CMMultiCrudActive || this.cpptICD10MultiCrudActive || this.cpptICD9CMMultiCrudActive || this.dischargeICD10MultiCrudActive || this.dischargeICD9CMMultiCrudActive || this.icd10MultiCrudActive || this.icd9CMMultiCrudActive || this.invoicesICD10MultiCrudActive || this.invoicesICD9CMMultiCrudActive || this.postOperativeICD10MultiCrudActive || this.postOperativeICD9CMMultiCrudActive || this.preSurgeryICD10MultiCrudActive || this.preSurgeryICD9CMMultiCrudActive || this.diagnosisNandasMultiCrudActive,
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
					new modelAction.DiagnosesAndProceduresAction(
						modelAction.DiagnosesAndProceduresModelActionTypes.COUNT_DIAGNOSES_AND_PROCEDURESS,
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

			this.store.dispatch(new modelAction.DiagnosesAndProceduresAction(
				modelAction.DiagnosesAndProceduresModelActionTypes.CREATE_DIAGNOSES_AND_PROCEDURES,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for CreateModel here] off begin
				// % protected region % [Add any additional constructor arguments for CreateModel here] end,
				afterwardActions
			));

			// Once the creation and count actions have completed, the tile mode change will trigger, and the user will
			// be returned to the list page
		} else {
			let stateConfig: PassableStateConfig<DiagnosesAndProceduresModel> = {
				targetModel: this.targetModel,
				updates: event.payload,
				queryParams: {
					expands: this.defaultExpands,
					persistRelations: this.bpjsDiagnoseMultiCrudActive || this.bpjsDiagnosePRBMultiCrudActive || this.masterICD10MultiCrudActive || this.masterICD9CMMultiCrudActive || this.admissionICD10MultiCrudActive || this.admissionICD9CMMultiCrudActive || this.cpptICD10MultiCrudActive || this.cpptICD9CMMultiCrudActive || this.dischargeICD10MultiCrudActive || this.dischargeICD9CMMultiCrudActive || this.icd10MultiCrudActive || this.icd9CMMultiCrudActive || this.invoicesICD10MultiCrudActive || this.invoicesICD9CMMultiCrudActive || this.postOperativeICD10MultiCrudActive || this.postOperativeICD9CMMultiCrudActive || this.preSurgeryICD10MultiCrudActive || this.preSurgeryICD9CMMultiCrudActive || this.diagnosisNandasMultiCrudActive,
				},
				// % protected region % [Add any additional attributes to the edit state config here] off begin
				// % protected region % [Add any additional attributes to the edit state config here] end
			};

			let afterwardActions: NgRxAction[] = [];

			if (this.singlePageComponent) {
				this.store.dispatch(new modelAction.DiagnosesAndProceduresAction(
					modelAction.DiagnosesAndProceduresModelActionTypes.FETCH_DIAGNOSES_AND_PROCEDURES,
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

			this.store.dispatch(new modelAction.DiagnosesAndProceduresAction(
				modelAction.DiagnosesAndProceduresModelActionTypes.UPDATE_DIAGNOSES_AND_PROCEDURES,
				stateConfig,
				// % protected region % [Add any additional constructor arguments for UpdateModel here] off begin
				// % protected region % [Add any additional constructor arguments for UpdateModel here] end,
				afterwardActions
			));

			// Need to do this because dispatch cannot be waited on, so page would navigate back to list before update has completed
			if (this.singlePageComponent) {
				let updatedModel: DiagnosesAndProceduresModel = new DiagnosesAndProceduresModel(this.targetModel).applyUpdates(stateConfig.updates);

				// Whenever the updated model is updated, check that there is no differences between the expected attributes and the stored attributes
				// Once there are no differences, we can navigate back to the list page, as any updates will now be shown without reloading
				this.creationNavigationSubscription$.add(this.store.select(getDiagnosesAndProceduresModelWithId, this.targetModelId).subscribe(model => {
					let differences = new DiagnosesAndProceduresModel(model).difference(updatedModel);

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
			if (event.entityName === this.bpjsDiagnoseDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDiagnoseModel.getProps(), this.bpjsDiagnoseRelations, this.isViewOnly),
					new BpjsDiagnoseModel(),
					BpjsDiagnoseModel,
					this.bpjsDiagnoseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDiagnoseRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.bpjsDiagnosePRBDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDiagnosePRBModel.getProps(), this.bpjsDiagnosePRBRelations, this.isViewOnly),
					new BpjsDiagnosePRBModel(),
					BpjsDiagnosePRBModel,
					this.bpjsDiagnosePRBDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDiagnosePRBRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.masterICD10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(Icd10Model.getProps(), this.masterICD10Relations, this.isViewOnly),
					new Icd10Model(),
					Icd10Model,
					this.masterICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.masterICD10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.masterICD9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(Icd9CMModel.getProps(), this.masterICD9CMRelations, this.isViewOnly),
					new Icd9CMModel(),
					Icd9CMModel,
					this.masterICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.masterICD9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.admissionICD10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(RegistrationModel.getProps(), this.admissionICD10Relations, this.isViewOnly),
					new RegistrationModel(),
					RegistrationModel,
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
					createReactiveFormFromModel(RegistrationModel.getProps(), this.admissionICD9CMRelations, this.isViewOnly),
					new RegistrationModel(),
					RegistrationModel,
					this.admissionICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.admissionICD9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.cpptICD10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.cpptICD10Relations, this.isViewOnly),
					new DailyCareCPPTModel(),
					DailyCareCPPTModel,
					this.cpptICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.cpptICD10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.cpptICD9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.cpptICD9CMRelations, this.isViewOnly),
					new DailyCareCPPTModel(),
					DailyCareCPPTModel,
					this.cpptICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.cpptICD9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.dischargeICD10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateDischargeResumeModel.getProps(), this.dischargeICD10Relations, this.isViewOnly),
					new MedicalCertificateDischargeResumeModel(),
					MedicalCertificateDischargeResumeModel,
					this.dischargeICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dischargeICD10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.dischargeICD9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(MedicalCertificateDischargeResumeModel.getProps(), this.dischargeICD9CMRelations, this.isViewOnly),
					new MedicalCertificateDischargeResumeModel(),
					MedicalCertificateDischargeResumeModel,
					this.dischargeICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.dischargeICD9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.icd10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosisExaminationRecordModel.getProps(), this.icd10Relations, this.isViewOnly),
					new DiagnosisExaminationRecordModel(),
					DiagnosisExaminationRecordModel,
					this.icd10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.icd10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.icd9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(DiagnosisExaminationRecordModel.getProps(), this.icd9CMRelations, this.isViewOnly),
					new DiagnosisExaminationRecordModel(),
					DiagnosisExaminationRecordModel,
					this.icd9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.icd9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoicesICD10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoiceModel.getProps(), this.invoicesICD10Relations, this.isViewOnly),
					new InvoiceModel(),
					InvoiceModel,
					this.invoicesICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoicesICD10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.invoicesICD9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(InvoiceModel.getProps(), this.invoicesICD9CMRelations, this.isViewOnly),
					new InvoiceModel(),
					InvoiceModel,
					this.invoicesICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.invoicesICD9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.postOperativeICD10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PostOperativeDetailsModel.getProps(), this.postOperativeICD10Relations, this.isViewOnly),
					new PostOperativeDetailsModel(),
					PostOperativeDetailsModel,
					this.postOperativeICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.postOperativeICD10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.postOperativeICD9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PostOperativeDetailsModel.getProps(), this.postOperativeICD9CMRelations, this.isViewOnly),
					new PostOperativeDetailsModel(),
					PostOperativeDetailsModel,
					this.postOperativeICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.postOperativeICD9CMRelations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.preSurgeryICD10DisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.preSurgeryICD10Relations, this.isViewOnly),
					new PreoperativeRecordsModel(),
					PreoperativeRecordsModel,
					this.preSurgeryICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preSurgeryICD10Relations,
					true
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}

			if (event.entityName === this.preSurgeryICD9CMDisplayName) {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.preSurgeryICD9CMRelations, this.isViewOnly),
					new PreoperativeRecordsModel(),
					PreoperativeRecordsModel,
					this.preSurgeryICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.preSurgeryICD9CMRelations,
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
		this.modelProperties = DiagnosesAndProceduresModel.getProps();
		this.modelRelations = DiagnosesAndProceduresModel.getRelations();

		// If we are using multi crud mode for any entities, the remainder of this method will ensure that
		// any additional entities shown on the screen will not be shown as a dropdown in the base entity
		this.modelRelations.find(rel => {
			return rel.id === 'bpjsDiagnose';
		}).hideElement = this.bpjsDiagnoseMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsDiagnose').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'bpjsDiagnosePRB';
		}).hideElement = this.bpjsDiagnosePRBMultiCrudActive || this.modelRelations.find(rel => rel.id === 'bpjsDiagnosePRB').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'masterICD10';
		}).hideElement = this.masterICD10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'masterICD10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'masterICD9CM';
		}).hideElement = this.masterICD9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'masterICD9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'admissionICD10';
		}).hideElement = this.admissionICD10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'admissionICD10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'admissionICD9CM';
		}).hideElement = this.admissionICD9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'admissionICD9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'cpptICD10';
		}).hideElement = this.cpptICD10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'cpptICD10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'cpptICD9CM';
		}).hideElement = this.cpptICD9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'cpptICD9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'dischargeICD10';
		}).hideElement = this.dischargeICD10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'dischargeICD10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'dischargeICD9CM';
		}).hideElement = this.dischargeICD9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'dischargeICD9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'icd10';
		}).hideElement = this.icd10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'icd10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'icd9CM';
		}).hideElement = this.icd9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'icd9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoicesICD10';
		}).hideElement = this.invoicesICD10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoicesICD10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'invoicesICD9CM';
		}).hideElement = this.invoicesICD9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'invoicesICD9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'postOperativeICD10';
		}).hideElement = this.postOperativeICD10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'postOperativeICD10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'postOperativeICD9CM';
		}).hideElement = this.postOperativeICD9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'postOperativeICD9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'preSurgeryICD10';
		}).hideElement = this.preSurgeryICD10MultiCrudActive || this.modelRelations.find(rel => rel.id === 'preSurgeryICD10').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'preSurgeryICD9CM';
		}).hideElement = this.preSurgeryICD9CMMultiCrudActive || this.modelRelations.find(rel => rel.id === 'preSurgeryICD9CM').hideElement;

		this.modelRelations.find(rel => {
			return rel.id === 'diagnosisNandas';
		}).hideElement = this.diagnosisNandasMultiCrudActive || this.modelRelations.find(rel => rel.id === 'diagnosisNandas').hideElement;

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
		if (this.bpjsDiagnoseMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsDiagnoseDisplayName, many: false});
		}

		if (this.bpjsDiagnosePRBMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.bpjsDiagnosePRBDisplayName, many: false});
		}

		if (this.masterICD10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.masterICD10DisplayName, many: false});
		}

		if (this.masterICD9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.masterICD9CMDisplayName, many: false});
		}

		if (this.admissionICD10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.admissionICD10DisplayName, many: true});
			this.store.dispatch(new registrationModelAction.RegistrationAction(
				registrationModelAction.RegistrationModelActionTypes.INITIALISE_REGISTRATION_COLLECTION_STATE,
				{
					collectionId: this.admissionICD10CollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRegistrationCollectionModels, this.admissionICD10CollectionId).subscribe(models => {
				models.forEach(admissionICD10 => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RegistrationModel.getProps(), this.admissionICD10Relations, this.isViewOnly),
						admissionICD10,
						RegistrationModel,
						this.admissionICD10DisplayName,
						this.modelProperties,
						this.modelRelations,
						this.admissionICD10Relations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.admissionICD9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.admissionICD9CMDisplayName, many: true});
			this.store.dispatch(new registrationModelAction.RegistrationAction(
				registrationModelAction.RegistrationModelActionTypes.INITIALISE_REGISTRATION_COLLECTION_STATE,
				{
					collectionId: this.admissionICD9CMCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getRegistrationCollectionModels, this.admissionICD9CMCollectionId).subscribe(models => {
				models.forEach(admissionICD9CM => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(RegistrationModel.getProps(), this.admissionICD9CMRelations, this.isViewOnly),
						admissionICD9CM,
						RegistrationModel,
						this.admissionICD9CMDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.admissionICD9CMRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.cpptICD10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.cpptICD10DisplayName, many: true});
			this.store.dispatch(new dailyCareCPPTModelAction.DailyCareCPPTAction(
				dailyCareCPPTModelAction.DailyCareCPPTModelActionTypes.INITIALISE_DAILY_CARE_CPPT_COLLECTION_STATE,
				{
					collectionId: this.cpptICD10CollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDailyCareCPPTCollectionModels, this.cpptICD10CollectionId).subscribe(models => {
				models.forEach(cpptICD10 => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.cpptICD10Relations, this.isViewOnly),
						cpptICD10,
						DailyCareCPPTModel,
						this.cpptICD10DisplayName,
						this.modelProperties,
						this.modelRelations,
						this.cpptICD10Relations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.cpptICD9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.cpptICD9CMDisplayName, many: true});
			this.store.dispatch(new dailyCareCPPTModelAction.DailyCareCPPTAction(
				dailyCareCPPTModelAction.DailyCareCPPTModelActionTypes.INITIALISE_DAILY_CARE_CPPT_COLLECTION_STATE,
				{
					collectionId: this.cpptICD9CMCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDailyCareCPPTCollectionModels, this.cpptICD9CMCollectionId).subscribe(models => {
				models.forEach(cpptICD9CM => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DailyCareCPPTModel.getProps(), this.cpptICD9CMRelations, this.isViewOnly),
						cpptICD9CM,
						DailyCareCPPTModel,
						this.cpptICD9CMDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.cpptICD9CMRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.dischargeICD10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.dischargeICD10DisplayName, many: true});
			this.store.dispatch(new medicalCertificateDischargeResumeModelAction.MedicalCertificateDischargeResumeAction(
				medicalCertificateDischargeResumeModelAction.MedicalCertificateDischargeResumeModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_COLLECTION_STATE,
				{
					collectionId: this.dischargeICD10CollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateDischargeResumeCollectionModels, this.dischargeICD10CollectionId).subscribe(models => {
				models.forEach(dischargeICD10 => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificateDischargeResumeModel.getProps(), this.dischargeICD10Relations, this.isViewOnly),
						dischargeICD10,
						MedicalCertificateDischargeResumeModel,
						this.dischargeICD10DisplayName,
						this.modelProperties,
						this.modelRelations,
						this.dischargeICD10Relations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.dischargeICD9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.dischargeICD9CMDisplayName, many: true});
			this.store.dispatch(new medicalCertificateDischargeResumeModelAction.MedicalCertificateDischargeResumeAction(
				medicalCertificateDischargeResumeModelAction.MedicalCertificateDischargeResumeModelActionTypes.INITIALISE_MEDICAL_CERTIFICATE_DISCHARGE_RESUME_COLLECTION_STATE,
				{
					collectionId: this.dischargeICD9CMCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getMedicalCertificateDischargeResumeCollectionModels, this.dischargeICD9CMCollectionId).subscribe(models => {
				models.forEach(dischargeICD9CM => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(MedicalCertificateDischargeResumeModel.getProps(), this.dischargeICD9CMRelations, this.isViewOnly),
						dischargeICD9CM,
						MedicalCertificateDischargeResumeModel,
						this.dischargeICD9CMDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.dischargeICD9CMRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.icd10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.icd10DisplayName, many: true});
			this.store.dispatch(new diagnosisExaminationRecordModelAction.DiagnosisExaminationRecordAction(
				diagnosisExaminationRecordModelAction.DiagnosisExaminationRecordModelActionTypes.INITIALISE_DIAGNOSIS_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.icd10CollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosisExaminationRecordCollectionModels, this.icd10CollectionId).subscribe(models => {
				models.forEach(icd10 => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DiagnosisExaminationRecordModel.getProps(), this.icd10Relations, this.isViewOnly),
						icd10,
						DiagnosisExaminationRecordModel,
						this.icd10DisplayName,
						this.modelProperties,
						this.modelRelations,
						this.icd10Relations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.icd9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.icd9CMDisplayName, many: true});
			this.store.dispatch(new diagnosisExaminationRecordModelAction.DiagnosisExaminationRecordAction(
				diagnosisExaminationRecordModelAction.DiagnosisExaminationRecordModelActionTypes.INITIALISE_DIAGNOSIS_EXAMINATION_RECORD_COLLECTION_STATE,
				{
					collectionId: this.icd9CMCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getDiagnosisExaminationRecordCollectionModels, this.icd9CMCollectionId).subscribe(models => {
				models.forEach(icd9CM => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(DiagnosisExaminationRecordModel.getProps(), this.icd9CMRelations, this.isViewOnly),
						icd9CM,
						DiagnosisExaminationRecordModel,
						this.icd9CMDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.icd9CMRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.invoicesICD10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoicesICD10DisplayName, many: true});
			this.store.dispatch(new invoiceModelAction.InvoiceAction(
				invoiceModelAction.InvoiceModelActionTypes.INITIALISE_INVOICE_COLLECTION_STATE,
				{
					collectionId: this.invoicesICD10CollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoiceCollectionModels, this.invoicesICD10CollectionId).subscribe(models => {
				models.forEach(invoicesICD10 => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InvoiceModel.getProps(), this.invoicesICD10Relations, this.isViewOnly),
						invoicesICD10,
						InvoiceModel,
						this.invoicesICD10DisplayName,
						this.modelProperties,
						this.modelRelations,
						this.invoicesICD10Relations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.invoicesICD9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.invoicesICD9CMDisplayName, many: true});
			this.store.dispatch(new invoiceModelAction.InvoiceAction(
				invoiceModelAction.InvoiceModelActionTypes.INITIALISE_INVOICE_COLLECTION_STATE,
				{
					collectionId: this.invoicesICD9CMCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getInvoiceCollectionModels, this.invoicesICD9CMCollectionId).subscribe(models => {
				models.forEach(invoicesICD9CM => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(InvoiceModel.getProps(), this.invoicesICD9CMRelations, this.isViewOnly),
						invoicesICD9CM,
						InvoiceModel,
						this.invoicesICD9CMDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.invoicesICD9CMRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.postOperativeICD10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.postOperativeICD10DisplayName, many: true});
			this.store.dispatch(new postOperativeDetailsModelAction.PostOperativeDetailsAction(
				postOperativeDetailsModelAction.PostOperativeDetailsModelActionTypes.INITIALISE_POST_OPERATIVE_DETAILS_COLLECTION_STATE,
				{
					collectionId: this.postOperativeICD10CollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPostOperativeDetailsCollectionModels, this.postOperativeICD10CollectionId).subscribe(models => {
				models.forEach(postOperativeICD10 => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PostOperativeDetailsModel.getProps(), this.postOperativeICD10Relations, this.isViewOnly),
						postOperativeICD10,
						PostOperativeDetailsModel,
						this.postOperativeICD10DisplayName,
						this.modelProperties,
						this.modelRelations,
						this.postOperativeICD10Relations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.postOperativeICD9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.postOperativeICD9CMDisplayName, many: true});
			this.store.dispatch(new postOperativeDetailsModelAction.PostOperativeDetailsAction(
				postOperativeDetailsModelAction.PostOperativeDetailsModelActionTypes.INITIALISE_POST_OPERATIVE_DETAILS_COLLECTION_STATE,
				{
					collectionId: this.postOperativeICD9CMCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPostOperativeDetailsCollectionModels, this.postOperativeICD9CMCollectionId).subscribe(models => {
				models.forEach(postOperativeICD9CM => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PostOperativeDetailsModel.getProps(), this.postOperativeICD9CMRelations, this.isViewOnly),
						postOperativeICD9CM,
						PostOperativeDetailsModel,
						this.postOperativeICD9CMDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.postOperativeICD9CMRelations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.preSurgeryICD10MultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.preSurgeryICD10DisplayName, many: true});
			this.store.dispatch(new preoperativeRecordsModelAction.PreoperativeRecordsAction(
				preoperativeRecordsModelAction.PreoperativeRecordsModelActionTypes.INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE,
				{
					collectionId: this.preSurgeryICD10CollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsCollectionModels, this.preSurgeryICD10CollectionId).subscribe(models => {
				models.forEach(preSurgeryICD10 => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.preSurgeryICD10Relations, this.isViewOnly),
						preSurgeryICD10,
						PreoperativeRecordsModel,
						this.preSurgeryICD10DisplayName,
						this.modelProperties,
						this.modelRelations,
						this.preSurgeryICD10Relations,
						true
					);
					this.modelProperties = updatedProps.modelProperties;
					this.modelRelations = updatedProps.modelRelations;
				});
			}));
		}

		if (this.preSurgeryICD9CMMultiCrudActive) {
			this.defaultMultiEntityButtons.push({name: this.preSurgeryICD9CMDisplayName, many: true});
			this.store.dispatch(new preoperativeRecordsModelAction.PreoperativeRecordsAction(
				preoperativeRecordsModelAction.PreoperativeRecordsModelActionTypes.INITIALISE_PREOPERATIVE_RECORDS_COLLECTION_STATE,
				{
					collectionId: this.preSurgeryICD9CMCollectionId
				},
			));

			this.creationNavigationSubscription$.add(this.store.select(getPreoperativeRecordsCollectionModels, this.preSurgeryICD9CMCollectionId).subscribe(models => {
				models.forEach(preSurgeryICD9CM => {
					let updatedProps = getNewModelProperties(
						createReactiveFormFromModel(PreoperativeRecordsModel.getProps(), this.preSurgeryICD9CMRelations, this.isViewOnly),
						preSurgeryICD9CM,
						PreoperativeRecordsModel,
						this.preSurgeryICD9CMDisplayName,
						this.modelProperties,
						this.modelRelations,
						this.preSurgeryICD9CMRelations,
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

	}

	/**
	 * Fetches the entities for any activated multi entity crud selections, and adds groups to the form for every additional
	 * related entity.
	 *
	 * May be empty if the entity for this crud page has no related entities
	 */
	multiCrudFetchAdditionalEntities() {
		if (this.targetModel.masterICD10 && this.targetModel.masterICD10.id && this.masterICD10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				Icd10Model,
				this.masterICD10OppositeRelation,
				this.collectionId,
				1,
				this.targetModel.masterICD10.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getIcd10ModelWithId, this.targetModel.masterICD10Id).subscribe(masterICD10 => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(Icd10Model.getProps(), this.masterICD10Relations, this.isViewOnly),
					masterICD10,
					Icd10Model,
					this.masterICD10DisplayName,
					this.modelProperties,
					this.modelRelations,
					this.masterICD10Relations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.masterICD9CM && this.targetModel.masterICD9CM.id && this.masterICD9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				Icd9CMModel,
				this.masterICD9CMOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.masterICD9CM.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getIcd9CMModelWithId, this.targetModel.masterICD9CMId).subscribe(masterICD9CM => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(Icd9CMModel.getProps(), this.masterICD9CMRelations, this.isViewOnly),
					masterICD9CM,
					Icd9CMModel,
					this.masterICD9CMDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.masterICD9CMRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsDiagnose && this.targetModel.bpjsDiagnose.id && this.bpjsDiagnoseMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsDiagnoseModel,
				this.bpjsDiagnoseOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsDiagnose.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsDiagnoseModelWithId, this.targetModel.bpjsDiagnoseId).subscribe(bpjsDiagnose => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDiagnoseModel.getProps(), this.bpjsDiagnoseRelations, this.isViewOnly),
					bpjsDiagnose,
					BpjsDiagnoseModel,
					this.bpjsDiagnoseDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDiagnoseRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.bpjsDiagnosePRB && this.targetModel.bpjsDiagnosePRB.id && this.bpjsDiagnosePRBMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				BpjsDiagnosePRBModel,
				this.bpjsDiagnosePRBOppositeRelation,
				this.collectionId,
				1,
				this.targetModel.bpjsDiagnosePRB.id,
				false
			));

			this.creationNavigationSubscription$.add(this.store.select(getBpjsDiagnosePRBModelWithId, this.targetModel.bpjsDiagnosePRBId).subscribe(bpjsDiagnosePRB => {
				let updatedProps = getNewModelProperties(
					createReactiveFormFromModel(BpjsDiagnosePRBModel.getProps(), this.bpjsDiagnosePRBRelations, this.isViewOnly),
					bpjsDiagnosePRB,
					BpjsDiagnosePRBModel,
					this.bpjsDiagnosePRBDisplayName,
					this.modelProperties,
					this.modelRelations,
					this.bpjsDiagnosePRBRelations,
					false
				);
				this.modelProperties = updatedProps.modelProperties;
				this.modelRelations = updatedProps.modelRelations;
			}));
		}

		if (this.targetModel.admissionICD10Ids && this.targetModel.admissionICD10Ids.length > 0 && this.admissionICD10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RegistrationModel,
				this.admissionICD10OppositeRelation,
				this.admissionICD10CollectionId,
				this.targetModel.admissionICD10Ids.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.admissionICD9CMIds && this.targetModel.admissionICD9CMIds.length > 0 && this.admissionICD9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				RegistrationModel,
				this.admissionICD9CMOppositeRelation,
				this.admissionICD9CMCollectionId,
				this.targetModel.admissionICD9CMIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.cpptICD10Ids && this.targetModel.cpptICD10Ids.length > 0 && this.cpptICD10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DailyCareCPPTModel,
				this.cpptICD10OppositeRelation,
				this.cpptICD10CollectionId,
				this.targetModel.cpptICD10Ids.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.cpptICD9CMIds && this.targetModel.cpptICD9CMIds.length > 0 && this.cpptICD9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DailyCareCPPTModel,
				this.cpptICD9CMOppositeRelation,
				this.cpptICD9CMCollectionId,
				this.targetModel.cpptICD9CMIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.dischargeICD10Ids && this.targetModel.dischargeICD10Ids.length > 0 && this.dischargeICD10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateDischargeResumeModel,
				this.dischargeICD10OppositeRelation,
				this.dischargeICD10CollectionId,
				this.targetModel.dischargeICD10Ids.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.dischargeICD9CMIds && this.targetModel.dischargeICD9CMIds.length > 0 && this.dischargeICD9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				MedicalCertificateDischargeResumeModel,
				this.dischargeICD9CMOppositeRelation,
				this.dischargeICD9CMCollectionId,
				this.targetModel.dischargeICD9CMIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.icd10Ids && this.targetModel.icd10Ids.length > 0 && this.icd10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosisExaminationRecordModel,
				this.icd10OppositeRelation,
				this.icd10CollectionId,
				this.targetModel.icd10Ids.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.icd9CMIds && this.targetModel.icd9CMIds.length > 0 && this.icd9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				DiagnosisExaminationRecordModel,
				this.icd9CMOppositeRelation,
				this.icd9CMCollectionId,
				this.targetModel.icd9CMIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.invoicesICD10Ids && this.targetModel.invoicesICD10Ids.length > 0 && this.invoicesICD10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoiceModel,
				this.invoicesICD10OppositeRelation,
				this.invoicesICD10CollectionId,
				this.targetModel.invoicesICD10Ids.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.invoicesICD9CMIds && this.targetModel.invoicesICD9CMIds.length > 0 && this.invoicesICD9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				InvoiceModel,
				this.invoicesICD9CMOppositeRelation,
				this.invoicesICD9CMCollectionId,
				this.targetModel.invoicesICD9CMIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.postOperativeICD10Ids && this.targetModel.postOperativeICD10Ids.length > 0 && this.postOperativeICD10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PostOperativeDetailsModel,
				this.postOperativeICD10OppositeRelation,
				this.postOperativeICD10CollectionId,
				this.targetModel.postOperativeICD10Ids.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.postOperativeICD9CMIds && this.targetModel.postOperativeICD9CMIds.length > 0 && this.postOperativeICD9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PostOperativeDetailsModel,
				this.postOperativeICD9CMOppositeRelation,
				this.postOperativeICD9CMCollectionId,
				this.targetModel.postOperativeICD9CMIds.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.preSurgeryICD10Ids && this.targetModel.preSurgeryICD10Ids.length > 0 && this.preSurgeryICD10MultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PreoperativeRecordsModel,
				this.preSurgeryICD10OppositeRelation,
				this.preSurgeryICD10CollectionId,
				this.targetModel.preSurgeryICD10Ids.length,
				this.targetModel.id,
				true
			));
		}

		if (this.targetModel.preSurgeryICD9CMIds && this.targetModel.preSurgeryICD9CMIds.length > 0 && this.preSurgeryICD9CMMultiCrudActive) {
			this.store.dispatch(multiCrudExtraEntityAction(
				PreoperativeRecordsModel,
				this.preSurgeryICD9CMOppositeRelation,
				this.preSurgeryICD9CMCollectionId,
				this.targetModel.preSurgeryICD9CMIds.length,
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
	addAdditionalEntitiesToModel(model: DiagnosesAndProceduresModel, event: { isCreate: boolean, additionalEntities: any, payload?: { [s: string]: any } }): DiagnosesAndProceduresModel {
		let updatedModel: DiagnosesAndProceduresModel = new DiagnosesAndProceduresModel(model);

		if (this.bpjsDiagnoseMultiCrudActive) {
			updatedModel.bpjsDiagnose = event.additionalEntities.bpjsDiagnose ? event.additionalEntities.bpjsDiagnose : undefined;

			if (!updatedModel.bpjsDiagnose && event.payload) {
				event.payload.bpjsDiagnoseId = null;
			}
		} else if (event.payload?.bpjsDiagnoseId !== undefined) {
			event.payload.bpjsDiagnose = null;
			updatedModel.bpjsDiagnose = null;
		}

		if (this.bpjsDiagnosePRBMultiCrudActive) {
			updatedModel.bpjsDiagnosePRB = event.additionalEntities.bpjsDiagnosePRB ? event.additionalEntities.bpjsDiagnosePRB : undefined;

			if (!updatedModel.bpjsDiagnosePRB && event.payload) {
				event.payload.bpjsDiagnosePRBId = null;
			}
		} else if (event.payload?.bpjsDiagnosePRBId !== undefined) {
			event.payload.bpjsDiagnosePRB = null;
			updatedModel.bpjsDiagnosePRB = null;
		}

		if (this.masterICD10MultiCrudActive) {
			updatedModel.masterICD10 = event.additionalEntities.masterICD10 ? event.additionalEntities.masterICD10 : undefined;

			if (!updatedModel.masterICD10 && event.payload) {
				event.payload.masterICD10Id = null;
			}
		} else if (event.payload?.masterICD10Id !== undefined) {
			event.payload.masterICD10 = null;
			updatedModel.masterICD10 = null;
		}

		if (this.masterICD9CMMultiCrudActive) {
			updatedModel.masterICD9CM = event.additionalEntities.masterICD9CM ? event.additionalEntities.masterICD9CM : undefined;

			if (!updatedModel.masterICD9CM && event.payload) {
				event.payload.masterICD9CMId = null;
			}
		} else if (event.payload?.masterICD9CMId !== undefined) {
			event.payload.masterICD9CM = null;
			updatedModel.masterICD9CM = null;
		}

		updatedModel.admissionICD10 = [];
		if (this.admissionICD10MultiCrudActive) {
			if (event.additionalEntities.admissionICD10) {
				event.additionalEntities.admissionICD10.forEach(entity => {
					updatedModel.admissionICD10.push(entity);
				});
			}

			if (!updatedModel.admissionICD10.length) {
				updatedModel.admissionICD10Ids = [];
			}
		}
		updatedModel.admissionICD9CM = [];
		if (this.admissionICD9CMMultiCrudActive) {
			if (event.additionalEntities.admissionICD9CM) {
				event.additionalEntities.admissionICD9CM.forEach(entity => {
					updatedModel.admissionICD9CM.push(entity);
				});
			}

			if (!updatedModel.admissionICD9CM.length) {
				updatedModel.admissionICD9CMIds = [];
			}
		}
		updatedModel.cpptICD10 = [];
		if (this.cpptICD10MultiCrudActive) {
			if (event.additionalEntities.cpptICD10) {
				event.additionalEntities.cpptICD10.forEach(entity => {
					updatedModel.cpptICD10.push(entity);
				});
			}

			if (!updatedModel.cpptICD10.length) {
				updatedModel.cpptICD10Ids = [];
			}
		}
		updatedModel.cpptICD9CM = [];
		if (this.cpptICD9CMMultiCrudActive) {
			if (event.additionalEntities.cpptICD9CM) {
				event.additionalEntities.cpptICD9CM.forEach(entity => {
					updatedModel.cpptICD9CM.push(entity);
				});
			}

			if (!updatedModel.cpptICD9CM.length) {
				updatedModel.cpptICD9CMIds = [];
			}
		}
		updatedModel.dischargeICD10 = [];
		if (this.dischargeICD10MultiCrudActive) {
			if (event.additionalEntities.dischargeICD10) {
				event.additionalEntities.dischargeICD10.forEach(entity => {
					updatedModel.dischargeICD10.push(entity);
				});
			}

			if (!updatedModel.dischargeICD10.length) {
				updatedModel.dischargeICD10Ids = [];
			}
		}
		updatedModel.dischargeICD9CM = [];
		if (this.dischargeICD9CMMultiCrudActive) {
			if (event.additionalEntities.dischargeICD9CM) {
				event.additionalEntities.dischargeICD9CM.forEach(entity => {
					updatedModel.dischargeICD9CM.push(entity);
				});
			}

			if (!updatedModel.dischargeICD9CM.length) {
				updatedModel.dischargeICD9CMIds = [];
			}
		}
		updatedModel.icd10 = [];
		if (this.icd10MultiCrudActive) {
			if (event.additionalEntities.icd10) {
				event.additionalEntities.icd10.forEach(entity => {
					updatedModel.icd10.push(entity);
				});
			}

			if (!updatedModel.icd10.length) {
				updatedModel.icd10Ids = [];
			}
		}
		updatedModel.icd9CM = [];
		if (this.icd9CMMultiCrudActive) {
			if (event.additionalEntities.icd9CM) {
				event.additionalEntities.icd9CM.forEach(entity => {
					updatedModel.icd9CM.push(entity);
				});
			}

			if (!updatedModel.icd9CM.length) {
				updatedModel.icd9CMIds = [];
			}
		}
		updatedModel.invoicesICD10 = [];
		if (this.invoicesICD10MultiCrudActive) {
			if (event.additionalEntities.invoicesICD10) {
				event.additionalEntities.invoicesICD10.forEach(entity => {
					updatedModel.invoicesICD10.push(entity);
				});
			}

			if (!updatedModel.invoicesICD10.length) {
				updatedModel.invoicesICD10Ids = [];
			}
		}
		updatedModel.invoicesICD9CM = [];
		if (this.invoicesICD9CMMultiCrudActive) {
			if (event.additionalEntities.invoicesICD9CM) {
				event.additionalEntities.invoicesICD9CM.forEach(entity => {
					updatedModel.invoicesICD9CM.push(entity);
				});
			}

			if (!updatedModel.invoicesICD9CM.length) {
				updatedModel.invoicesICD9CMIds = [];
			}
		}
		updatedModel.postOperativeICD10 = [];
		if (this.postOperativeICD10MultiCrudActive) {
			if (event.additionalEntities.postOperativeICD10) {
				event.additionalEntities.postOperativeICD10.forEach(entity => {
					updatedModel.postOperativeICD10.push(entity);
				});
			}

			if (!updatedModel.postOperativeICD10.length) {
				updatedModel.postOperativeICD10Ids = [];
			}
		}
		updatedModel.postOperativeICD9CM = [];
		if (this.postOperativeICD9CMMultiCrudActive) {
			if (event.additionalEntities.postOperativeICD9CM) {
				event.additionalEntities.postOperativeICD9CM.forEach(entity => {
					updatedModel.postOperativeICD9CM.push(entity);
				});
			}

			if (!updatedModel.postOperativeICD9CM.length) {
				updatedModel.postOperativeICD9CMIds = [];
			}
		}
		updatedModel.preSurgeryICD10 = [];
		if (this.preSurgeryICD10MultiCrudActive) {
			if (event.additionalEntities.preSurgeryICD10) {
				event.additionalEntities.preSurgeryICD10.forEach(entity => {
					updatedModel.preSurgeryICD10.push(entity);
				});
			}

			if (!updatedModel.preSurgeryICD10.length) {
				updatedModel.preSurgeryICD10Ids = [];
			}
		}
		updatedModel.preSurgeryICD9CM = [];
		if (this.preSurgeryICD9CMMultiCrudActive) {
			if (event.additionalEntities.preSurgeryICD9CM) {
				event.additionalEntities.preSurgeryICD9CM.forEach(entity => {
					updatedModel.preSurgeryICD9CM.push(entity);
				});
			}

			if (!updatedModel.preSurgeryICD9CM.length) {
				updatedModel.preSurgeryICD9CMIds = [];
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

		return updatedModel;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
