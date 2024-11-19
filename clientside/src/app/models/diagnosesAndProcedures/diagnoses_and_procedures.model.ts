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
import {FormGroup, Validators} from '@angular/forms';
import {Group, AbstractModel, ModelProperty, ModelPropertyType, ModelRelation, ModelRelationType} from '../../lib/models/abstract.model';
import {BpjsDiagnoseModel} from '../bpjsDiagnose/bpjs_diagnose.model';
import {BpjsDiagnosePRBModel} from '../bpjsDiagnosePRB/bpjs_diagnose_prb.model';
import {DailyCareCPPTModel} from '../dailyCareCPPT/daily_care_cppt.model';
import {DiagnosisExaminationRecordModel} from '../diagnosisExaminationRecord/diagnosis_examination_record.model';
import {DiagnosisNandaModel} from '../diagnosisNanda/diagnosis_nanda.model';
import {Icd10Model} from '../icd10/icd_10.model';
import {Icd9CMModel} from '../icd9CM/icd_9_cm.model';
import {InvoiceModel} from '../invoice/invoice.model';
import {MedicalCertificateDischargeResumeModel} from '../medicalCertificateDischargeResume/medical_certificate_discharge_resume.model';
import {PostOperativeDetailsModel} from '../postOperativeDetails/post_operative_details.model';
import {PreoperativeRecordsModel} from '../preoperativeRecords/preoperative_records.model';
import {RegistrationModel} from '../registration/registration.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class DiagnosesAndProceduresModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'itemType',
		'itemCode',
		'description',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'itemType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'DiagnosesAndProceduresModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return DiagnosesAndProceduresModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Fixed Optio0n to trigger detail fields. Options: ICD 10, ICD 9 CM.
	 */
	itemType: string;

	/**
	 * Code (Max Length: 20).
	 */
	itemCode: string;

	/**
	 * International Disease Name (max Length: 500).
	 */
	description: string;

	/**
	 * Max Length: 5000.
	 */
	notes: string;

	masterICD10Id: string;

	masterICD10: Icd10Model;

	masterICD9CMId: string;

	masterICD9CM: Icd9CMModel;

	bpjsDiagnoseId: string;

	bpjsDiagnose: BpjsDiagnoseModel;

	bpjsDiagnosePRBId: string;

	bpjsDiagnosePRB: BpjsDiagnosePRBModel;

	admissionICD10Ids: string[] = [];

	admissionICD10: RegistrationModel[];

	admissionICD9CMIds: string[] = [];

	admissionICD9CM: RegistrationModel[];

	cpptICD10Ids: string[] = [];

	cpptICD10: DailyCareCPPTModel[];

	cpptICD9CMIds: string[] = [];

	cpptICD9CM: DailyCareCPPTModel[];

	dischargeICD10Ids: string[] = [];

	dischargeICD10: MedicalCertificateDischargeResumeModel[];

	dischargeICD9CMIds: string[] = [];

	dischargeICD9CM: MedicalCertificateDischargeResumeModel[];

	icd10Ids: string[] = [];

	icd10: DiagnosisExaminationRecordModel[];

	icd9CMIds: string[] = [];

	icd9CM: DiagnosisExaminationRecordModel[];

	invoicesICD10Ids: string[] = [];

	invoicesICD10: InvoiceModel[];

	invoicesICD9CMIds: string[] = [];

	invoicesICD9CM: InvoiceModel[];

	postOperativeICD10Ids: string[] = [];

	postOperativeICD10: PostOperativeDetailsModel[];

	postOperativeICD9CMIds: string[] = [];

	postOperativeICD9CM: PostOperativeDetailsModel[];

	preSurgeryICD10Ids: string[] = [];

	preSurgeryICD10: PreoperativeRecordsModel[];

	preSurgeryICD9CMIds: string[] = [];

	preSurgeryICD9CM: PreoperativeRecordsModel[];

	diagnosisNandasIds: string[] = [];

	diagnosisNandas: DiagnosisNandaModel[];

	modelPropGroups: { [s: string]: Group } = DiagnosesAndProceduresModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'itemType',
				// % protected region % [Set displayName for Item Type here] off begin
				displayName: 'Item Type',
				// % protected region % [Set displayName for Item Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Item Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Item Type here] end
				// % protected region % [Set isSensitive for Item Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Item Type here] end
				// % protected region % [Set readonly for Item Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Item Type here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Item Type here] off begin
					// % protected region % [Add other validators for Item Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Item Type here] off begin
				// % protected region % [Add any additional model attribute properties for Item Type here] end
			},
			{
				name: 'itemCode',
				// % protected region % [Set displayName for Item Code here] off begin
				displayName: 'Item Code',
				// % protected region % [Set displayName for Item Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Item Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Item Code here] end
				// % protected region % [Set isSensitive for Item Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Item Code here] end
				// % protected region % [Set readonly for Item Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Item Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Item Code here] off begin
					// % protected region % [Add other validators for Item Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Item Code here] off begin
				// % protected region % [Add any additional model attribute properties for Item Code here] end
			},
			{
				name: 'description',
				// % protected region % [Set displayName for Description here] off begin
				displayName: 'Description',
				// % protected region % [Set displayName for Description here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Description here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Description here] end
				// % protected region % [Set isSensitive for Description here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Description here] end
				// % protected region % [Set readonly for Description here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Description here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Description here] off begin
					// % protected region % [Add other validators for Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Description here] off begin
				// % protected region % [Add any additional model attribute properties for Description here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Notes here] end
				// % protected region % [Set isSensitive for Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Notes here] end
				// % protected region % [Set readonly for Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Notes here] end
				validators: [
					// % protected region % [Add other validators for Notes here] off begin
					// % protected region % [Add other validators for Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Notes here] end
			},
			// % protected region % [Add any additional class field names here] off begin
			// % protected region % [Add any additional class field names here] end
		]);
	}

	/**
	 * The relations of the entity
	 */
	static getRelations(): ModelRelation[] {
		return super.getRelations().concat([
			{
				id: 'admissionICD10',
				type: ModelRelationType.MANY,
				name: 'admissionICD10Ids',
				// % protected region % [Customise your 1-1 or 1-M label for Admission ICD 10 here] off begin
				label: 'Admission ICD 10',
				// % protected region % [Customise your 1-1 or 1-M label for Admission ICD 10 here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Admission ICD 10 here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Admission ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for Admission ICD 10 here] off begin
					// % protected region % [Add other validators for Admission ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation Admission ICD 10 here] off begin
				// % protected region % [Add any additional field for relation Admission ICD 10 here] end
			},
			{
				id: 'admissionICD9CM',
				type: ModelRelationType.MANY,
				name: 'admissionICD9CMIds',
				// % protected region % [Customise your 1-1 or 1-M label for Admission ICD 9 CM here] off begin
				label: 'Admission ICD 9 CM',
				// % protected region % [Customise your 1-1 or 1-M label for Admission ICD 9 CM here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Admission ICD 9 CM here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Admission ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for Admission ICD 9 CM here] off begin
					// % protected region % [Add other validators for Admission ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation Admission ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation Admission ICD 9 CM here] end
			},
			{
				id: 'cpptICD10',
				type: ModelRelationType.MANY,
				name: 'cpptICD10Ids',
				// % protected region % [Customise your 1-1 or 1-M label for CPPT ICD 10 here] off begin
				label: 'CPPT ICD 10',
				// % protected region % [Customise your 1-1 or 1-M label for CPPT ICD 10 here] end
				entityName: 'DailyCareCPPTModel',
				// % protected region % [Customise your display name for CPPT ICD 10 here] off begin
				displayName: 'subjective',
				// % protected region % [Customise your display name for CPPT ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for CPPT ICD 10 here] off begin
					// % protected region % [Add other validators for CPPT ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation CPPT ICD 10 here] off begin
				// % protected region % [Add any additional field for relation CPPT ICD 10 here] end
			},
			{
				id: 'cpptICD9CM',
				type: ModelRelationType.MANY,
				name: 'cpptICD9CMIds',
				// % protected region % [Customise your 1-1 or 1-M label for CPPT ICD 9 CM here] off begin
				label: 'CPPT ICD 9 CM',
				// % protected region % [Customise your 1-1 or 1-M label for CPPT ICD 9 CM here] end
				entityName: 'DailyCareCPPTModel',
				// % protected region % [Customise your display name for CPPT ICD 9 CM here] off begin
				displayName: 'subjective',
				// % protected region % [Customise your display name for CPPT ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for CPPT ICD 9 CM here] off begin
					// % protected region % [Add other validators for CPPT ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation CPPT ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation CPPT ICD 9 CM here] end
			},
			{
				id: 'diagnosisNandas',
				type: ModelRelationType.MANY,
				name: 'diagnosisNandasIds',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnosis Nandas here] off begin
				label: 'Diagnosis Nandas',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnosis Nandas here] end
				entityName: 'DiagnosisNandaModel',
				// % protected region % [Customise your display name for Diagnosis Nandas here] off begin
				displayName: 'nursingNotes',
				// % protected region % [Customise your display name for Diagnosis Nandas here] end
				validators: [
					// % protected region % [Add other validators for Diagnosis Nandas here] off begin
					// % protected region % [Add other validators for Diagnosis Nandas here] end
				],
				// % protected region % [Add any additional field for relation Diagnosis Nandas here] off begin
				// % protected region % [Add any additional field for relation Diagnosis Nandas here] end
			},
			{
				id: 'dischargeICD10',
				type: ModelRelationType.MANY,
				name: 'dischargeICD10Ids',
				// % protected region % [Customise your 1-1 or 1-M label for Discharge ICD 10 here] off begin
				label: 'Discharge ICD 10',
				// % protected region % [Customise your 1-1 or 1-M label for Discharge ICD 10 here] end
				entityName: 'MedicalCertificateDischargeResumeModel',
				// % protected region % [Customise your display name for Discharge ICD 10 here] off begin
				displayName: 'admissionDateTime',
				// % protected region % [Customise your display name for Discharge ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for Discharge ICD 10 here] off begin
					// % protected region % [Add other validators for Discharge ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation Discharge ICD 10 here] off begin
				// % protected region % [Add any additional field for relation Discharge ICD 10 here] end
			},
			{
				id: 'dischargeICD9CM',
				type: ModelRelationType.MANY,
				name: 'dischargeICD9CMIds',
				// % protected region % [Customise your 1-1 or 1-M label for Discharge ICD 9 CM here] off begin
				label: 'Discharge ICD 9 CM',
				// % protected region % [Customise your 1-1 or 1-M label for Discharge ICD 9 CM here] end
				entityName: 'MedicalCertificateDischargeResumeModel',
				// % protected region % [Customise your display name for Discharge ICD 9 CM here] off begin
				displayName: 'admissionDateTime',
				// % protected region % [Customise your display name for Discharge ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for Discharge ICD 9 CM here] off begin
					// % protected region % [Add other validators for Discharge ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation Discharge ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation Discharge ICD 9 CM here] end
			},
			{
				id: 'icd10',
				type: ModelRelationType.MANY,
				name: 'icd10Ids',
				// % protected region % [Customise your 1-1 or 1-M label for ICD 10 here] off begin
				label: 'ICD 10',
				// % protected region % [Customise your 1-1 or 1-M label for ICD 10 here] end
				entityName: 'DiagnosisExaminationRecordModel',
				// % protected region % [Customise your display name for ICD 10 here] off begin
				displayName: 'diagnosisSequence',
				// % protected region % [Customise your display name for ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for ICD 10 here] off begin
					// % protected region % [Add other validators for ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation ICD 10 here] off begin
				// % protected region % [Add any additional field for relation ICD 10 here] end
			},
			{
				id: 'icd9CM',
				type: ModelRelationType.MANY,
				name: 'icd9CMIds',
				// % protected region % [Customise your 1-1 or 1-M label for ICD 9 CM here] off begin
				label: 'ICD 9 CM',
				// % protected region % [Customise your 1-1 or 1-M label for ICD 9 CM here] end
				entityName: 'DiagnosisExaminationRecordModel',
				// % protected region % [Customise your display name for ICD 9 CM here] off begin
				displayName: 'diagnosisSequence',
				// % protected region % [Customise your display name for ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for ICD 9 CM here] off begin
					// % protected region % [Add other validators for ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation ICD 9 CM here] end
			},
			{
				id: 'invoicesICD10',
				type: ModelRelationType.MANY,
				name: 'invoicesICD10Ids',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices ICD 10 here] off begin
				label: 'Invoices ICD 10',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices ICD 10 here] end
				entityName: 'InvoiceModel',
				// % protected region % [Customise your display name for Invoices ICD 10 here] off begin
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Invoices ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for Invoices ICD 10 here] off begin
					// % protected region % [Add other validators for Invoices ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation Invoices ICD 10 here] off begin
				// % protected region % [Add any additional field for relation Invoices ICD 10 here] end
			},
			{
				id: 'invoicesICD9CM',
				type: ModelRelationType.MANY,
				name: 'invoicesICD9CMIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices ICD 9 CM here] off begin
				label: 'Invoices ICD 9 CM',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices ICD 9 CM here] end
				entityName: 'InvoiceModel',
				// % protected region % [Customise your display name for Invoices ICD 9 CM here] off begin
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Invoices ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for Invoices ICD 9 CM here] off begin
					// % protected region % [Add other validators for Invoices ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation Invoices ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation Invoices ICD 9 CM here] end
			},
			{
				id: 'masterICD10',
				type: ModelRelationType.ONE,
				name: 'masterICD10Id',
				// % protected region % [Customise your 1-1 or 1-M label for Master ICD 10 here] off begin
				label: 'Master ICD 10',
				// % protected region % [Customise your 1-1 or 1-M label for Master ICD 10 here] end
				entityName: 'Icd10Model',
				// % protected region % [Customise your display name for Master ICD 10 here] off begin
				displayName: 'classificationDisease',
				// % protected region % [Customise your display name for Master ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for Master ICD 10 here] off begin
					// % protected region % [Add other validators for Master ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation Master ICD 10 here] off begin
				// % protected region % [Add any additional field for relation Master ICD 10 here] end
			},
			{
				id: 'masterICD9CM',
				type: ModelRelationType.ONE,
				name: 'masterICD9CMId',
				// % protected region % [Customise your 1-1 or 1-M label for Master ICD 9 CM here] off begin
				label: 'Master ICD 9 CM',
				// % protected region % [Customise your 1-1 or 1-M label for Master ICD 9 CM here] end
				entityName: 'Icd9CMModel',
				// % protected region % [Customise your display name for Master ICD 9 CM here] off begin
				displayName: 'topProcedure',
				// % protected region % [Customise your display name for Master ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for Master ICD 9 CM here] off begin
					// % protected region % [Add other validators for Master ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation Master ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation Master ICD 9 CM here] end
			},
			{
				id: 'postOperativeICD10',
				type: ModelRelationType.MANY,
				name: 'postOperativeICD10Ids',
				// % protected region % [Customise your 1-1 or 1-M label for Post Operative ICD 10 here] off begin
				label: 'Post Operative ICD 10',
				// % protected region % [Customise your 1-1 or 1-M label for Post Operative ICD 10 here] end
				entityName: 'PostOperativeDetailsModel',
				// % protected region % [Customise your display name for Post Operative ICD 10 here] off begin
				displayName: 'recoveryStartDateTime',
				// % protected region % [Customise your display name for Post Operative ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for Post Operative ICD 10 here] off begin
					// % protected region % [Add other validators for Post Operative ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation Post Operative ICD 10 here] off begin
				// % protected region % [Add any additional field for relation Post Operative ICD 10 here] end
			},
			{
				id: 'postOperativeICD9CM',
				type: ModelRelationType.MANY,
				name: 'postOperativeICD9CMIds',
				// % protected region % [Customise your 1-1 or 1-M label for Post Operative ICD 9 CM here] off begin
				label: 'Post Operative ICD 9 CM',
				// % protected region % [Customise your 1-1 or 1-M label for Post Operative ICD 9 CM here] end
				entityName: 'PostOperativeDetailsModel',
				// % protected region % [Customise your display name for Post Operative ICD 9 CM here] off begin
				displayName: 'recoveryStartDateTime',
				// % protected region % [Customise your display name for Post Operative ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for Post Operative ICD 9 CM here] off begin
					// % protected region % [Add other validators for Post Operative ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation Post Operative ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation Post Operative ICD 9 CM here] end
			},
			{
				id: 'preSurgeryICD10',
				type: ModelRelationType.MANY,
				name: 'preSurgeryICD10Ids',
				// % protected region % [Customise your 1-1 or 1-M label for Pre Surgery ICD 10 here] off begin
				label: 'Pre Surgery ICD 10',
				// % protected region % [Customise your 1-1 or 1-M label for Pre Surgery ICD 10 here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Pre Surgery ICD 10 here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Pre Surgery ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for Pre Surgery ICD 10 here] off begin
					// % protected region % [Add other validators for Pre Surgery ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation Pre Surgery ICD 10 here] off begin
				// % protected region % [Add any additional field for relation Pre Surgery ICD 10 here] end
			},
			{
				id: 'preSurgeryICD9CM',
				type: ModelRelationType.MANY,
				name: 'preSurgeryICD9CMIds',
				// % protected region % [Customise your 1-1 or 1-M label for Pre Surgery ICD 9 CM here] off begin
				label: 'Pre Surgery ICD 9 CM',
				// % protected region % [Customise your 1-1 or 1-M label for Pre Surgery ICD 9 CM here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Pre Surgery ICD 9 CM here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Pre Surgery ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for Pre Surgery ICD 9 CM here] off begin
					// % protected region % [Add other validators for Pre Surgery ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation Pre Surgery ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation Pre Surgery ICD 9 CM here] end
			},
			{
				id: 'bpjsDiagnose',
				type: ModelRelationType.ONE,
				name: 'bpjsDiagnoseId',
				// % protected region % [Customise your label for BPJS Diagnose here] off begin
				label: 'BPJS Diagnose',
				// % protected region % [Customise your label for BPJS Diagnose here] end
				entityName: 'BpjsDiagnoseModel',
				// % protected region % [Customise your display name for BPJS Diagnose here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Diagnose here] end
				validators: [
					// % protected region % [Add other validators for BPJS Diagnose here] off begin
					// % protected region % [Add other validators for BPJS Diagnose here] end
				],
				// % protected region % [Add any additional field for relation BPJS Diagnose here] off begin
				// % protected region % [Add any additional field for relation BPJS Diagnose here] end
			},
			{
				id: 'bpjsDiagnosePRB',
				type: ModelRelationType.ONE,
				name: 'bpjsDiagnosePRBId',
				// % protected region % [Customise your label for BPJS Diagnose PRB here] off begin
				label: 'BPJS Diagnose PRB',
				// % protected region % [Customise your label for BPJS Diagnose PRB here] end
				entityName: 'BpjsDiagnosePRBModel',
				// % protected region % [Customise your display name for BPJS Diagnose PRB here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Diagnose PRB here] end
				validators: [
					// % protected region % [Add other validators for BPJS Diagnose PRB here] off begin
					// % protected region % [Add other validators for BPJS Diagnose PRB here] end
				],
				// % protected region % [Add any additional field for relation BPJS Diagnose PRB here] off begin
				// % protected region % [Add any additional field for relation BPJS Diagnose PRB here] end
			},
		]);
	}

	/**
	 * Convert the form group to the query conditions
	 */
	static convertFilterToCondition(formGroup: FormGroup): Where[][] {
		let conditions: Where[][] = [];

		// % protected region % [Overide the default convertFilterToCondition here] off begin
		Object.keys(formGroup.value).forEach((key) => {
			switch (key) {
				case 'itemType':
					break;
				case 'itemCode':
					break;
				case 'description':
					break;
				case 'created':
					const created = formGroup.value[key];
					// is the range of date
					if (created instanceof Array) {
						conditions.push([
							{
								path: key,
								operation: QueryOperation.GREATER_THAN_OR_EQUAL,
								value: created[0]
							}
						]);
						conditions.push([
							{
								path: key,
								operation: QueryOperation.LESS_THAN_OR_EQUAL,
								value: created[1]
							}
						]);
					}
			}
		});
		// % protected region % [Overide the default convertFilterToCondition here] end


		return conditions;
	}

	/**
	 * Convert a nested JSON object into an array of flatten objects.
	 */
	static deepParse(data: string | { [K in keyof DiagnosesAndProceduresModel]?: DiagnosesAndProceduresModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new DiagnosesAndProceduresModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.masterICD10) {
			currentModel.masterICD10Id = json.masterICD10.id;
			returned = _.union(returned, Icd10Model.deepParse(json.masterICD10));
		}

		// Outgoing one to one
		if (json.masterICD9CM) {
			currentModel.masterICD9CMId = json.masterICD9CM.id;
			returned = _.union(returned, Icd9CMModel.deepParse(json.masterICD9CM));
		}

		// Incoming one to one
		if (json.bpjsDiagnose) {
			currentModel.bpjsDiagnoseId = json.bpjsDiagnose.id;
			returned = _.union(returned, BpjsDiagnoseModel.deepParse(json.bpjsDiagnose));
		}

		// Incoming one to one
		if (json.bpjsDiagnosePRB) {
			currentModel.bpjsDiagnosePRBId = json.bpjsDiagnosePRB.id;
			returned = _.union(returned, BpjsDiagnosePRBModel.deepParse(json.bpjsDiagnosePRB));
		}

		// Outgoing one to many
		if (json.admissionICD10) {
			currentModel.admissionICD10Ids = json.admissionICD10.map(model => model.id);
			returned = _.union(returned, _.flatten(json.admissionICD10.map(model => RegistrationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.admissionICD9CM) {
			currentModel.admissionICD9CMIds = json.admissionICD9CM.map(model => model.id);
			returned = _.union(returned, _.flatten(json.admissionICD9CM.map(model => RegistrationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.cpptICD10) {
			currentModel.cpptICD10Ids = json.cpptICD10.map(model => model.id);
			returned = _.union(returned, _.flatten(json.cpptICD10.map(model => DailyCareCPPTModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.cpptICD9CM) {
			currentModel.cpptICD9CMIds = json.cpptICD9CM.map(model => model.id);
			returned = _.union(returned, _.flatten(json.cpptICD9CM.map(model => DailyCareCPPTModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.dischargeICD10) {
			currentModel.dischargeICD10Ids = json.dischargeICD10.map(model => model.id);
			returned = _.union(returned, _.flatten(json.dischargeICD10.map(model => MedicalCertificateDischargeResumeModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.dischargeICD9CM) {
			currentModel.dischargeICD9CMIds = json.dischargeICD9CM.map(model => model.id);
			returned = _.union(returned, _.flatten(json.dischargeICD9CM.map(model => MedicalCertificateDischargeResumeModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.icd10) {
			currentModel.icd10Ids = json.icd10.map(model => model.id);
			returned = _.union(returned, _.flatten(json.icd10.map(model => DiagnosisExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.icd9CM) {
			currentModel.icd9CMIds = json.icd9CM.map(model => model.id);
			returned = _.union(returned, _.flatten(json.icd9CM.map(model => DiagnosisExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoicesICD10) {
			currentModel.invoicesICD10Ids = json.invoicesICD10.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoicesICD10.map(model => InvoiceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoicesICD9CM) {
			currentModel.invoicesICD9CMIds = json.invoicesICD9CM.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoicesICD9CM.map(model => InvoiceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.postOperativeICD10) {
			currentModel.postOperativeICD10Ids = json.postOperativeICD10.map(model => model.id);
			returned = _.union(returned, _.flatten(json.postOperativeICD10.map(model => PostOperativeDetailsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.postOperativeICD9CM) {
			currentModel.postOperativeICD9CMIds = json.postOperativeICD9CM.map(model => model.id);
			returned = _.union(returned, _.flatten(json.postOperativeICD9CM.map(model => PostOperativeDetailsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.preSurgeryICD10) {
			currentModel.preSurgeryICD10Ids = json.preSurgeryICD10.map(model => model.id);
			returned = _.union(returned, _.flatten(json.preSurgeryICD10.map(model => PreoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.preSurgeryICD9CM) {
			currentModel.preSurgeryICD9CMIds = json.preSurgeryICD9CM.map(model => model.id);
			returned = _.union(returned, _.flatten(json.preSurgeryICD9CM.map(model => PreoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing many to many
		if (json.diagnosisNandas) {
			currentModel.diagnosisNandasIds = json.diagnosisNandas.map(model => model.id);
			returned = _.union(returned, _.flatten(json.diagnosisNandas.map(model => DiagnosisNandaModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let diagnosesAndProceduresModel = new DiagnosesAndProceduresModel(data);`
	 *
	 * @param data The input data to be initialised as the DiagnosesAndProceduresModel,
	 *    it is expected as a JSON string or as a nullable DiagnosesAndProceduresModel.
	 */
	constructor(data?: string | Partial<DiagnosesAndProceduresModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<DiagnosesAndProceduresModel>
				: data;

			this.itemType = json.itemType;
			this.itemCode = json.itemCode;
			this.description = json.description;
			this.notes = json.notes;
			this.masterICD10Id = json.masterICD10Id;
			this.masterICD10 = json.masterICD10;
			this.masterICD9CMId = json.masterICD9CMId;
			this.masterICD9CM = json.masterICD9CM;
			this.bpjsDiagnoseId = json.bpjsDiagnoseId;
			this.bpjsDiagnose = json.bpjsDiagnose;
			this.bpjsDiagnosePRBId = json.bpjsDiagnosePRBId;
			this.bpjsDiagnosePRB = json.bpjsDiagnosePRB;
			this.admissionICD10Ids = json.admissionICD10Ids;
			this.admissionICD10 = json.admissionICD10;
			this.admissionICD9CMIds = json.admissionICD9CMIds;
			this.admissionICD9CM = json.admissionICD9CM;
			this.cpptICD10Ids = json.cpptICD10Ids;
			this.cpptICD10 = json.cpptICD10;
			this.cpptICD9CMIds = json.cpptICD9CMIds;
			this.cpptICD9CM = json.cpptICD9CM;
			this.dischargeICD10Ids = json.dischargeICD10Ids;
			this.dischargeICD10 = json.dischargeICD10;
			this.dischargeICD9CMIds = json.dischargeICD9CMIds;
			this.dischargeICD9CM = json.dischargeICD9CM;
			this.icd10Ids = json.icd10Ids;
			this.icd10 = json.icd10;
			this.icd9CMIds = json.icd9CMIds;
			this.icd9CM = json.icd9CM;
			this.invoicesICD10Ids = json.invoicesICD10Ids;
			this.invoicesICD10 = json.invoicesICD10;
			this.invoicesICD9CMIds = json.invoicesICD9CMIds;
			this.invoicesICD9CM = json.invoicesICD9CM;
			this.postOperativeICD10Ids = json.postOperativeICD10Ids;
			this.postOperativeICD10 = json.postOperativeICD10;
			this.postOperativeICD9CMIds = json.postOperativeICD9CMIds;
			this.postOperativeICD9CM = json.postOperativeICD9CM;
			this.preSurgeryICD10Ids = json.preSurgeryICD10Ids;
			this.preSurgeryICD10 = json.preSurgeryICD10;
			this.preSurgeryICD9CMIds = json.preSurgeryICD9CMIds;
			this.preSurgeryICD9CM = json.preSurgeryICD9CM;
			this.diagnosisNandasIds = json.diagnosisNandasIds;
			this.diagnosisNandas = json.diagnosisNandas;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			itemType: this.itemType,
			itemCode: this.itemCode,
			description: this.description,
			notes: this.notes,
			masterICD10Id: this.masterICD10Id,
			masterICD9CMId: this.masterICD9CMId,
			bpjsDiagnoseId: this.bpjsDiagnoseId,
			bpjsDiagnosePRBId: this.bpjsDiagnosePRBId,
			admissionICD10Ids: this.admissionICD10Ids,
			admissionICD9CMIds: this.admissionICD9CMIds,
			cpptICD10Ids: this.cpptICD10Ids,
			cpptICD9CMIds: this.cpptICD9CMIds,
			dischargeICD10Ids: this.dischargeICD10Ids,
			dischargeICD9CMIds: this.dischargeICD9CMIds,
			icd10Ids: this.icd10Ids,
			icd9CMIds: this.icd9CMIds,
			invoicesICD10Ids: this.invoicesICD10Ids,
			invoicesICD9CMIds: this.invoicesICD9CMIds,
			postOperativeICD10Ids: this.postOperativeICD10Ids,
			postOperativeICD9CMIds: this.postOperativeICD9CMIds,
			preSurgeryICD10Ids: this.preSurgeryICD10Ids,
			preSurgeryICD9CMIds: this.preSurgeryICD9CMIds,
			diagnosisNandasIds: this.diagnosisNandasIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		DiagnosesAndProceduresModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): DiagnosesAndProceduresModel {
		let newModelJson = this.toJSON();

		if (updates.itemType) {
			newModelJson.itemType = updates.itemType;
		}

		if (updates.itemCode) {
			newModelJson.itemCode = updates.itemCode;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.masterICD10Id) {
			newModelJson.masterICD10Id = updates.masterICD10Id;
		}

		if (updates.masterICD9CMId) {
			newModelJson.masterICD9CMId = updates.masterICD9CMId;
		}

		if (updates.bpjsDiagnoseId) {
			newModelJson.bpjsDiagnoseId = updates.bpjsDiagnoseId;
		}

		if (updates.bpjsDiagnosePRBId) {
			newModelJson.bpjsDiagnosePRBId = updates.bpjsDiagnosePRBId;
		}

		if (updates.admissionICD10Ids) {
			newModelJson.admissionICD10Ids = updates.admissionICD10Ids;
		}

		if (updates.admissionICD9CMIds) {
			newModelJson.admissionICD9CMIds = updates.admissionICD9CMIds;
		}

		if (updates.cpptICD10Ids) {
			newModelJson.cpptICD10Ids = updates.cpptICD10Ids;
		}

		if (updates.cpptICD9CMIds) {
			newModelJson.cpptICD9CMIds = updates.cpptICD9CMIds;
		}

		if (updates.dischargeICD10Ids) {
			newModelJson.dischargeICD10Ids = updates.dischargeICD10Ids;
		}

		if (updates.dischargeICD9CMIds) {
			newModelJson.dischargeICD9CMIds = updates.dischargeICD9CMIds;
		}

		if (updates.icd10Ids) {
			newModelJson.icd10Ids = updates.icd10Ids;
		}

		if (updates.icd9CMIds) {
			newModelJson.icd9CMIds = updates.icd9CMIds;
		}

		if (updates.invoicesICD10Ids) {
			newModelJson.invoicesICD10Ids = updates.invoicesICD10Ids;
		}

		if (updates.invoicesICD9CMIds) {
			newModelJson.invoicesICD9CMIds = updates.invoicesICD9CMIds;
		}

		if (updates.postOperativeICD10Ids) {
			newModelJson.postOperativeICD10Ids = updates.postOperativeICD10Ids;
		}

		if (updates.postOperativeICD9CMIds) {
			newModelJson.postOperativeICD9CMIds = updates.postOperativeICD9CMIds;
		}

		if (updates.preSurgeryICD10Ids) {
			newModelJson.preSurgeryICD10Ids = updates.preSurgeryICD10Ids;
		}

		if (updates.preSurgeryICD9CMIds) {
			newModelJson.preSurgeryICD9CMIds = updates.preSurgeryICD9CMIds;
		}

		if (updates.diagnosisNandasIds) {
			newModelJson.diagnosisNandasIds = updates.diagnosisNandasIds;
		}

		return new DiagnosesAndProceduresModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof DiagnosesAndProceduresModel)) {
			return {};
		}

		const diff = {};

		for (const key of _.keys(this)) {
			const thisValue = this[key];
			const otherValue = other[key];

			// Handle dates differently
			if (thisValue instanceof Date) {
				let thisDate = (thisValue) ? thisValue.getTime() : null;
				let otherDate = (otherValue) ? otherValue.getTime() : null;

				if (thisDate !== otherDate) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			'masterICD10Id',
			'masterICD10',
			'masterICD9CMId',
			'masterICD9CM',
			'bpjsDiagnoseId',
			'bpjsDiagnose',
			'bpjsDiagnosePRBId',
			'bpjsDiagnosePRB',
			'admissionICD10Ids',
			'admissionICD10',
			'admissionICD9CMIds',
			'admissionICD9CM',
			'cpptICD10Ids',
			'cpptICD10',
			'cpptICD9CMIds',
			'cpptICD9CM',
			'dischargeICD10Ids',
			'dischargeICD10',
			'dischargeICD9CMIds',
			'dischargeICD9CM',
			'icd10Ids',
			'icd10',
			'icd9CMIds',
			'icd9CM',
			'invoicesICD10Ids',
			'invoicesICD10',
			'invoicesICD9CMIds',
			'invoicesICD9CM',
			'postOperativeICD10Ids',
			'postOperativeICD10',
			'postOperativeICD9CMIds',
			'postOperativeICD9CM',
			'preSurgeryICD10Ids',
			'preSurgeryICD10',
			'preSurgeryICD9CMIds',
			'preSurgeryICD9CM',
			'diagnosisNandasIds',
			'diagnosisNandas',
			// % protected region % [Add any other fields to omit here] off begin
			// % protected region % [Add any other fields to omit here] end
		]);
	}

	/**
	 * Sets the relation ID parameters to be based on the ID's of the associated entities.
	 * 
	 * Fetching entities is based on the object, but updating relations is based on the id, so we need to
	 * make sure that they match
	 */
	syncRelations() {
		if (!this.masterICD10) {
			this.masterICD10Id = null;
		} else {
			this.masterICD10Id = this.masterICD10.id;
		}

		if (!this.masterICD9CM) {
			this.masterICD9CMId = null;
		} else {
			this.masterICD9CMId = this.masterICD9CM.id;
		}

		if (!this.bpjsDiagnose) {
			this.bpjsDiagnoseId = null;
		} else {
			this.bpjsDiagnoseId = this.bpjsDiagnose.id;
		}

		if (!this.bpjsDiagnosePRB) {
			this.bpjsDiagnosePRBId = null;
		} else {
			this.bpjsDiagnosePRBId = this.bpjsDiagnosePRB.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
