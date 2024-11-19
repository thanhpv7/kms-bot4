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
import {PatientGeneralInfoModel} from '../patientGeneralInfo/patient_general_info.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PatientEmploymentDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'employeeID',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PatientEmploymentDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientEmploymentDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Employee ID (Max Length: 50).
	 */
	employeeID: string;

	/**
	 * Universal ID (Max Length: 50).
	 */
	universalID: string;

	/**
	 * Employee Type, get from Reference Type: EMPLOYEE_TYPE (Max Length: 20).
	 */
	employeeType: string;

	/**
	 * employee status onsite, get from Reference Type: ONSITE_STATUS (Max Length: 20).
	 */
	onsiteStatus: string;

	/**
	 * Occupational Type, get from Reference Type: OCCUP_TYPE (Max Length: 20).
	 */
	occupationalType: string;

	/**
	 * Dependant ID.
	 */
	dependantID: string;

	/**
	 * Dependant Type, get from Reference Type: DEPEND_TYPE (Max Length: 20).
	 */
	dependantType: string;

	/**
	 * Person ID of patient who is sponsor of patient it self, refer to Patient General Info (Max Level: 50).
	 */
	sponsor: string;

	/**
	 * Relationship between patient with Sponsor, get from Reference Type: PATIENT_RELATION (Max Length: 20).
	 */
	relationship: string;

	/**
	 * Company, get from Reference Type: COMPANY (Max Length: 20).
	 */
	company: string;

	/**
	 * Medical Staff who did treatment to patient.
	 */
	medicalStaffCode: string;

	/**
	 * Department, get from Reference Type: DEPARTMENT (Max Length: 20).
	 */
	department: string;

	/**
	 * Position, get from Reference Type: POSITION (Max Length: 20).
	 */
	position: string;

	/**
	 * Cost Center, get from Reference Type: COST_CENTER (Max Length: 20).
	 */
	costCenter: string;

	/**
	 * District, get from Reference Type: DISTRICT (Max Length: 20).
	 */
	district: string;

	/**
	 * Designated Work Place, get from Reference Type: DESIGN_WORKPLACE (Max Length: 20).
	 */
	designatedWorkPlace: string;

	/**
	 * Bureau No (Max Length: 50).
	 */
	bureauNo: string;

	/**
	 * Industry No (Max Length: 50).
	 */
	industryNo: string;

	/**
	 * Employment Start Date.
	 */
	employmentStartDate: Date;

	/**
	 * Passport No (Max Length: 50).
	 */
	passportNo: string;

	/**
	 * .
	 */
	name: string;

	/**
	 * Passport Country, get from Reference Type: PASS_COUNTRY (Max Length: 20).
	 */
	passportCountry: string;

	/**
	 * Postal Address (Max Length: 500).
	 */
	postalAddress: string;

	/**
	 * Forwarding Address (Max Length: 500).
	 */
	forwardingAddress: string;

	/**
	 * Legal Disability, get from Reference Type: LEGAL_DISABTL (Max Length: 20).
	 */
	legalDIsability: string;

	/**
	 * Legal Disability Notes (Max Length: 500).
	 */
	legalDisabilityNotes: string;

	/**
	 * Worker Insurance, get from Reference Type: WORKER_INSRN (Max Length: 20).
	 */
	workerInsurance: string;

	/**
	 * Worker Insurance No (Max Length: 50).
	 */
	workerInsuranceNo: string;

	patientGeneralInfoId: string;

	patientGeneralInfo: PatientGeneralInfoModel;

	modelPropGroups: { [s: string]: Group } = PatientEmploymentDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'employeeID',
				// % protected region % [Set displayName for Employee ID here] off begin
				displayName: 'Employee ID',
				// % protected region % [Set displayName for Employee ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Employee ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Employee ID here] end
				// % protected region % [Set isSensitive for Employee ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Employee ID here] end
				// % protected region % [Set readonly for Employee ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Employee ID here] end
				validators: [
					// % protected region % [Add other validators for Employee ID here] off begin
					// % protected region % [Add other validators for Employee ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Employee ID here] off begin
				// % protected region % [Add any additional model attribute properties for Employee ID here] end
			},
			{
				name: 'universalID',
				// % protected region % [Set displayName for Universal ID here] off begin
				displayName: 'Universal ID',
				// % protected region % [Set displayName for Universal ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Universal ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Universal ID here] end
				// % protected region % [Set isSensitive for Universal ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Universal ID here] end
				// % protected region % [Set readonly for Universal ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Universal ID here] end
				validators: [
					// % protected region % [Add other validators for Universal ID here] off begin
					// % protected region % [Add other validators for Universal ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Universal ID here] off begin
				// % protected region % [Add any additional model attribute properties for Universal ID here] end
			},
			{
				name: 'employeeType',
				// % protected region % [Set displayName for Employee Type here] off begin
				displayName: 'Employee Type',
				// % protected region % [Set displayName for Employee Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Employee Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Employee Type here] end
				// % protected region % [Set isSensitive for Employee Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Employee Type here] end
				// % protected region % [Set readonly for Employee Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Employee Type here] end
				validators: [
					// % protected region % [Add other validators for Employee Type here] off begin
					// % protected region % [Add other validators for Employee Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Employee Type here] off begin
				// % protected region % [Add any additional model attribute properties for Employee Type here] end
			},
			{
				name: 'onsiteStatus',
				// % protected region % [Set displayName for Onsite Status here] off begin
				displayName: 'Onsite Status',
				// % protected region % [Set displayName for Onsite Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Onsite Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Onsite Status here] end
				// % protected region % [Set isSensitive for Onsite Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Onsite Status here] end
				// % protected region % [Set readonly for Onsite Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Onsite Status here] end
				validators: [
					// % protected region % [Add other validators for Onsite Status here] off begin
					// % protected region % [Add other validators for Onsite Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Onsite Status here] off begin
				// % protected region % [Add any additional model attribute properties for Onsite Status here] end
			},
			{
				name: 'occupationalType',
				// % protected region % [Set displayName for Occupational Type here] off begin
				displayName: 'Occupational Type',
				// % protected region % [Set displayName for Occupational Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Occupational Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Occupational Type here] end
				// % protected region % [Set isSensitive for Occupational Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Occupational Type here] end
				// % protected region % [Set readonly for Occupational Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Occupational Type here] end
				validators: [
					// % protected region % [Add other validators for Occupational Type here] off begin
					// % protected region % [Add other validators for Occupational Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Occupational Type here] off begin
				// % protected region % [Add any additional model attribute properties for Occupational Type here] end
			},
			{
				name: 'dependantID',
				// % protected region % [Set displayName for Dependant ID here] off begin
				displayName: 'Dependant ID',
				// % protected region % [Set displayName for Dependant ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dependant ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dependant ID here] end
				// % protected region % [Set isSensitive for Dependant ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dependant ID here] end
				// % protected region % [Set readonly for Dependant ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dependant ID here] end
				validators: [
					// % protected region % [Add other validators for Dependant ID here] off begin
					// % protected region % [Add other validators for Dependant ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Dependant ID here] off begin
				// % protected region % [Add any additional model attribute properties for Dependant ID here] end
			},
			{
				name: 'dependantType',
				// % protected region % [Set displayName for Dependant Type here] off begin
				displayName: 'Dependant Type',
				// % protected region % [Set displayName for Dependant Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dependant Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dependant Type here] end
				// % protected region % [Set isSensitive for Dependant Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dependant Type here] end
				// % protected region % [Set readonly for Dependant Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dependant Type here] end
				validators: [
					// % protected region % [Add other validators for Dependant Type here] off begin
					// % protected region % [Add other validators for Dependant Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Dependant Type here] off begin
				// % protected region % [Add any additional model attribute properties for Dependant Type here] end
			},
			{
				name: 'sponsor',
				// % protected region % [Set displayName for Sponsor here] off begin
				displayName: 'Sponsor',
				// % protected region % [Set displayName for Sponsor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sponsor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sponsor here] end
				// % protected region % [Set isSensitive for Sponsor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sponsor here] end
				// % protected region % [Set readonly for Sponsor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sponsor here] end
				validators: [
					// % protected region % [Add other validators for Sponsor here] off begin
					// % protected region % [Add other validators for Sponsor here] end
				],
				// % protected region % [Add any additional model attribute properties for Sponsor here] off begin
				// % protected region % [Add any additional model attribute properties for Sponsor here] end
			},
			{
				name: 'relationship',
				// % protected region % [Set displayName for Relationship here] off begin
				displayName: 'Relationship',
				// % protected region % [Set displayName for Relationship here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Relationship here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Relationship here] end
				// % protected region % [Set isSensitive for Relationship here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Relationship here] end
				// % protected region % [Set readonly for Relationship here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Relationship here] end
				validators: [
					// % protected region % [Add other validators for Relationship here] off begin
					// % protected region % [Add other validators for Relationship here] end
				],
				// % protected region % [Add any additional model attribute properties for Relationship here] off begin
				// % protected region % [Add any additional model attribute properties for Relationship here] end
			},
			{
				name: 'company',
				// % protected region % [Set displayName for Company here] off begin
				displayName: 'Company',
				// % protected region % [Set displayName for Company here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Company here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Company here] end
				// % protected region % [Set isSensitive for Company here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Company here] end
				// % protected region % [Set readonly for Company here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Company here] end
				validators: [
					// % protected region % [Add other validators for Company here] off begin
					// % protected region % [Add other validators for Company here] end
				],
				// % protected region % [Add any additional model attribute properties for Company here] off begin
				// % protected region % [Add any additional model attribute properties for Company here] end
			},
			{
				name: 'medicalStaffCode',
				// % protected region % [Set displayName for Medical Staff Code here] off begin
				displayName: 'Medical Staff Code',
				// % protected region % [Set displayName for Medical Staff Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Medical Staff Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Medical Staff Code here] end
				// % protected region % [Set isSensitive for Medical Staff Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medical Staff Code here] end
				// % protected region % [Set readonly for Medical Staff Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medical Staff Code here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff Code here] off begin
					// % protected region % [Add other validators for Medical Staff Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Medical Staff Code here] off begin
				// % protected region % [Add any additional model attribute properties for Medical Staff Code here] end
			},
			{
				name: 'department',
				// % protected region % [Set displayName for Department here] off begin
				displayName: 'Department',
				// % protected region % [Set displayName for Department here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Department here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Department here] end
				// % protected region % [Set isSensitive for Department here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Department here] end
				// % protected region % [Set readonly for Department here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Department here] end
				validators: [
					// % protected region % [Add other validators for Department here] off begin
					// % protected region % [Add other validators for Department here] end
				],
				// % protected region % [Add any additional model attribute properties for Department here] off begin
				// % protected region % [Add any additional model attribute properties for Department here] end
			},
			{
				name: 'position',
				// % protected region % [Set displayName for Position here] off begin
				displayName: 'Position',
				// % protected region % [Set displayName for Position here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Position here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Position here] end
				// % protected region % [Set isSensitive for Position here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Position here] end
				// % protected region % [Set readonly for Position here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Position here] end
				validators: [
					// % protected region % [Add other validators for Position here] off begin
					// % protected region % [Add other validators for Position here] end
				],
				// % protected region % [Add any additional model attribute properties for Position here] off begin
				// % protected region % [Add any additional model attribute properties for Position here] end
			},
			{
				name: 'costCenter',
				// % protected region % [Set displayName for Cost Center here] off begin
				displayName: 'Cost Center',
				// % protected region % [Set displayName for Cost Center here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Cost Center here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Cost Center here] end
				// % protected region % [Set isSensitive for Cost Center here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cost Center here] end
				// % protected region % [Set readonly for Cost Center here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cost Center here] end
				validators: [
					// % protected region % [Add other validators for Cost Center here] off begin
					// % protected region % [Add other validators for Cost Center here] end
				],
				// % protected region % [Add any additional model attribute properties for Cost Center here] off begin
				// % protected region % [Add any additional model attribute properties for Cost Center here] end
			},
			{
				name: 'district',
				// % protected region % [Set displayName for District here] off begin
				displayName: 'District',
				// % protected region % [Set displayName for District here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for District here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for District here] end
				// % protected region % [Set isSensitive for District here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for District here] end
				// % protected region % [Set readonly for District here] off begin
				readOnly: false,
				// % protected region % [Set readonly for District here] end
				validators: [
					// % protected region % [Add other validators for District here] off begin
					// % protected region % [Add other validators for District here] end
				],
				// % protected region % [Add any additional model attribute properties for District here] off begin
				// % protected region % [Add any additional model attribute properties for District here] end
			},
			{
				name: 'designatedWorkPlace',
				// % protected region % [Set displayName for Designated Work Place here] off begin
				displayName: 'Designated Work Place',
				// % protected region % [Set displayName for Designated Work Place here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Designated Work Place here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Designated Work Place here] end
				// % protected region % [Set isSensitive for Designated Work Place here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Designated Work Place here] end
				// % protected region % [Set readonly for Designated Work Place here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Designated Work Place here] end
				validators: [
					// % protected region % [Add other validators for Designated Work Place here] off begin
					// % protected region % [Add other validators for Designated Work Place here] end
				],
				// % protected region % [Add any additional model attribute properties for Designated Work Place here] off begin
				// % protected region % [Add any additional model attribute properties for Designated Work Place here] end
			},
			{
				name: 'bureauNo',
				// % protected region % [Set displayName for Bureau No here] off begin
				displayName: 'Bureau No',
				// % protected region % [Set displayName for Bureau No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bureau No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bureau No here] end
				// % protected region % [Set isSensitive for Bureau No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bureau No here] end
				// % protected region % [Set readonly for Bureau No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bureau No here] end
				validators: [
					// % protected region % [Add other validators for Bureau No here] off begin
					// % protected region % [Add other validators for Bureau No here] end
				],
				// % protected region % [Add any additional model attribute properties for Bureau No here] off begin
				// % protected region % [Add any additional model attribute properties for Bureau No here] end
			},
			{
				name: 'industryNo',
				// % protected region % [Set displayName for Industry No here] off begin
				displayName: 'Industry No',
				// % protected region % [Set displayName for Industry No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Industry No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Industry No here] end
				// % protected region % [Set isSensitive for Industry No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Industry No here] end
				// % protected region % [Set readonly for Industry No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Industry No here] end
				validators: [
					// % protected region % [Add other validators for Industry No here] off begin
					// % protected region % [Add other validators for Industry No here] end
				],
				// % protected region % [Add any additional model attribute properties for Industry No here] off begin
				// % protected region % [Add any additional model attribute properties for Industry No here] end
			},
			{
				name: 'employmentStartDate',
				// % protected region % [Set displayName for Employment Start Date here] off begin
				displayName: 'Employment Start Date',
				// % protected region % [Set displayName for Employment Start Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Employment Start Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Employment Start Date here] end
				// % protected region % [Set isSensitive for Employment Start Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Employment Start Date here] end
				// % protected region % [Set readonly for Employment Start Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Employment Start Date here] end
				validators: [
					// % protected region % [Add other validators for Employment Start Date here] off begin
					// % protected region % [Add other validators for Employment Start Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Employment Start Date here] off begin
				// % protected region % [Add any additional model attribute properties for Employment Start Date here] end
			},
			{
				name: 'passportNo',
				// % protected region % [Set displayName for Passport No here] off begin
				displayName: 'Passport No',
				// % protected region % [Set displayName for Passport No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Passport No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Passport No here] end
				// % protected region % [Set isSensitive for Passport No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Passport No here] end
				// % protected region % [Set readonly for Passport No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Passport No here] end
				validators: [
					// % protected region % [Add other validators for Passport No here] off begin
					// % protected region % [Add other validators for Passport No here] end
				],
				// % protected region % [Add any additional model attribute properties for Passport No here] off begin
				// % protected region % [Add any additional model attribute properties for Passport No here] end
			},
			{
				name: 'name',
				// % protected region % [Set displayName for Name here] off begin
				displayName: 'Name',
				// % protected region % [Set displayName for Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Name here] end
				// % protected region % [Set isSensitive for Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Name here] end
				// % protected region % [Set readonly for Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Name here] end
				validators: [
					// % protected region % [Add other validators for Name here] off begin
					// % protected region % [Add other validators for Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Name here] off begin
				// % protected region % [Add any additional model attribute properties for Name here] end
			},
			{
				name: 'passportCountry',
				// % protected region % [Set displayName for Passport Country here] off begin
				displayName: 'Passport Country',
				// % protected region % [Set displayName for Passport Country here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Passport Country here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Passport Country here] end
				// % protected region % [Set isSensitive for Passport Country here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Passport Country here] end
				// % protected region % [Set readonly for Passport Country here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Passport Country here] end
				validators: [
					// % protected region % [Add other validators for Passport Country here] off begin
					// % protected region % [Add other validators for Passport Country here] end
				],
				// % protected region % [Add any additional model attribute properties for Passport Country here] off begin
				// % protected region % [Add any additional model attribute properties for Passport Country here] end
			},
			{
				name: 'postalAddress',
				// % protected region % [Set displayName for Postal Address here] off begin
				displayName: 'Postal Address',
				// % protected region % [Set displayName for Postal Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Postal Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Postal Address here] end
				// % protected region % [Set isSensitive for Postal Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Postal Address here] end
				// % protected region % [Set readonly for Postal Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Postal Address here] end
				validators: [
					// % protected region % [Add other validators for Postal Address here] off begin
					// % protected region % [Add other validators for Postal Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Postal Address here] off begin
				// % protected region % [Add any additional model attribute properties for Postal Address here] end
			},
			{
				name: 'forwardingAddress',
				// % protected region % [Set displayName for Forwarding Address here] off begin
				displayName: 'Forwarding Address',
				// % protected region % [Set displayName for Forwarding Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Forwarding Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Forwarding Address here] end
				// % protected region % [Set isSensitive for Forwarding Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Forwarding Address here] end
				// % protected region % [Set readonly for Forwarding Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Forwarding Address here] end
				validators: [
					// % protected region % [Add other validators for Forwarding Address here] off begin
					// % protected region % [Add other validators for Forwarding Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Forwarding Address here] off begin
				// % protected region % [Add any additional model attribute properties for Forwarding Address here] end
			},
			{
				name: 'legalDIsability',
				// % protected region % [Set displayName for Legal DIsability here] off begin
				displayName: 'Legal DIsability',
				// % protected region % [Set displayName for Legal DIsability here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Legal DIsability here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Legal DIsability here] end
				// % protected region % [Set isSensitive for Legal DIsability here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Legal DIsability here] end
				// % protected region % [Set readonly for Legal DIsability here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Legal DIsability here] end
				validators: [
					// % protected region % [Add other validators for Legal DIsability here] off begin
					// % protected region % [Add other validators for Legal DIsability here] end
				],
				// % protected region % [Add any additional model attribute properties for Legal DIsability here] off begin
				// % protected region % [Add any additional model attribute properties for Legal DIsability here] end
			},
			{
				name: 'legalDisabilityNotes',
				// % protected region % [Set displayName for Legal Disability Notes here] off begin
				displayName: 'Legal Disability Notes',
				// % protected region % [Set displayName for Legal Disability Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Legal Disability Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Legal Disability Notes here] end
				// % protected region % [Set isSensitive for Legal Disability Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Legal Disability Notes here] end
				// % protected region % [Set readonly for Legal Disability Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Legal Disability Notes here] end
				validators: [
					// % protected region % [Add other validators for Legal Disability Notes here] off begin
					// % protected region % [Add other validators for Legal Disability Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Legal Disability Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Legal Disability Notes here] end
			},
			{
				name: 'workerInsurance',
				// % protected region % [Set displayName for Worker Insurance here] off begin
				displayName: 'Worker Insurance',
				// % protected region % [Set displayName for Worker Insurance here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Worker Insurance here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Worker Insurance here] end
				// % protected region % [Set isSensitive for Worker Insurance here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Worker Insurance here] end
				// % protected region % [Set readonly for Worker Insurance here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Worker Insurance here] end
				validators: [
					// % protected region % [Add other validators for Worker Insurance here] off begin
					// % protected region % [Add other validators for Worker Insurance here] end
				],
				// % protected region % [Add any additional model attribute properties for Worker Insurance here] off begin
				// % protected region % [Add any additional model attribute properties for Worker Insurance here] end
			},
			{
				name: 'workerInsuranceNo',
				// % protected region % [Set displayName for Worker Insurance No here] off begin
				displayName: 'Worker Insurance No',
				// % protected region % [Set displayName for Worker Insurance No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Worker Insurance No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Worker Insurance No here] end
				// % protected region % [Set isSensitive for Worker Insurance No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Worker Insurance No here] end
				// % protected region % [Set readonly for Worker Insurance No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Worker Insurance No here] end
				validators: [
					// % protected region % [Add other validators for Worker Insurance No here] off begin
					// % protected region % [Add other validators for Worker Insurance No here] end
				],
				// % protected region % [Add any additional model attribute properties for Worker Insurance No here] off begin
				// % protected region % [Add any additional model attribute properties for Worker Insurance No here] end
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
				id: 'patientGeneralInfo',
				type: ModelRelationType.ONE,
				name: 'patientGeneralInfoId',
				// % protected region % [Customise your label for Patient General Info here] off begin
				label: 'Patient General Info',
				// % protected region % [Customise your label for Patient General Info here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient General Info here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient General Info here] end
				validators: [
					// % protected region % [Add other validators for Patient General Info here] off begin
					// % protected region % [Add other validators for Patient General Info here] end
				],
				// % protected region % [Add any additional field for relation Patient General Info here] off begin
				// % protected region % [Add any additional field for relation Patient General Info here] end
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
	static deepParse(data: string | { [K in keyof PatientEmploymentDetailModel]?: PatientEmploymentDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientEmploymentDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.patientGeneralInfo) {
			currentModel.patientGeneralInfoId = json.patientGeneralInfo.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInfo));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let patientEmploymentDetailModel = new PatientEmploymentDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientEmploymentDetailModel,
	 *    it is expected as a JSON string or as a nullable PatientEmploymentDetailModel.
	 */
	constructor(data?: string | Partial<PatientEmploymentDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientEmploymentDetailModel>
				: data;

			this.employeeID = json.employeeID;
			this.universalID = json.universalID;
			this.employeeType = json.employeeType;
			this.onsiteStatus = json.onsiteStatus;
			this.occupationalType = json.occupationalType;
			this.dependantID = json.dependantID;
			this.dependantType = json.dependantType;
			this.sponsor = json.sponsor;
			this.relationship = json.relationship;
			this.company = json.company;
			this.medicalStaffCode = json.medicalStaffCode;
			this.department = json.department;
			this.position = json.position;
			this.costCenter = json.costCenter;
			this.district = json.district;
			this.designatedWorkPlace = json.designatedWorkPlace;
			this.bureauNo = json.bureauNo;
			this.industryNo = json.industryNo;
			if (json.employmentStartDate) {
				this.employmentStartDate = new Date(json.employmentStartDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.employmentStartDate = json.employmentStartDate;
			}
			this.passportNo = json.passportNo;
			this.name = json.name;
			this.passportCountry = json.passportCountry;
			this.postalAddress = json.postalAddress;
			this.forwardingAddress = json.forwardingAddress;
			this.legalDIsability = json.legalDIsability;
			this.legalDisabilityNotes = json.legalDisabilityNotes;
			this.workerInsurance = json.workerInsurance;
			this.workerInsuranceNo = json.workerInsuranceNo;
			this.patientGeneralInfoId = json.patientGeneralInfoId;
			this.patientGeneralInfo = json.patientGeneralInfo;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			employeeID: this.employeeID,
			universalID: this.universalID,
			employeeType: this.employeeType,
			onsiteStatus: this.onsiteStatus,
			occupationalType: this.occupationalType,
			dependantID: this.dependantID,
			dependantType: this.dependantType,
			sponsor: this.sponsor,
			relationship: this.relationship,
			company: this.company,
			medicalStaffCode: this.medicalStaffCode,
			department: this.department,
			position: this.position,
			costCenter: this.costCenter,
			district: this.district,
			designatedWorkPlace: this.designatedWorkPlace,
			bureauNo: this.bureauNo,
			industryNo: this.industryNo,
			employmentStartDate: this.employmentStartDate,
			passportNo: this.passportNo,
			name: this.name,
			passportCountry: this.passportCountry,
			postalAddress: this.postalAddress,
			forwardingAddress: this.forwardingAddress,
			legalDIsability: this.legalDIsability,
			legalDisabilityNotes: this.legalDisabilityNotes,
			workerInsurance: this.workerInsurance,
			workerInsuranceNo: this.workerInsuranceNo,
			patientGeneralInfoId: this.patientGeneralInfoId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientEmploymentDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientEmploymentDetailModel {
		let newModelJson = this.toJSON();

		if (updates.employeeID) {
			newModelJson.employeeID = updates.employeeID;
		}

		if (updates.universalID) {
			newModelJson.universalID = updates.universalID;
		}

		if (updates.employeeType) {
			newModelJson.employeeType = updates.employeeType;
		}

		if (updates.onsiteStatus) {
			newModelJson.onsiteStatus = updates.onsiteStatus;
		}

		if (updates.occupationalType) {
			newModelJson.occupationalType = updates.occupationalType;
		}

		if (updates.dependantID) {
			newModelJson.dependantID = updates.dependantID;
		}

		if (updates.dependantType) {
			newModelJson.dependantType = updates.dependantType;
		}

		if (updates.sponsor) {
			newModelJson.sponsor = updates.sponsor;
		}

		if (updates.relationship) {
			newModelJson.relationship = updates.relationship;
		}

		if (updates.company) {
			newModelJson.company = updates.company;
		}

		if (updates.medicalStaffCode) {
			newModelJson.medicalStaffCode = updates.medicalStaffCode;
		}

		if (updates.department) {
			newModelJson.department = updates.department;
		}

		if (updates.position) {
			newModelJson.position = updates.position;
		}

		if (updates.costCenter) {
			newModelJson.costCenter = updates.costCenter;
		}

		if (updates.district) {
			newModelJson.district = updates.district;
		}

		if (updates.designatedWorkPlace) {
			newModelJson.designatedWorkPlace = updates.designatedWorkPlace;
		}

		if (updates.bureauNo) {
			newModelJson.bureauNo = updates.bureauNo;
		}

		if (updates.industryNo) {
			newModelJson.industryNo = updates.industryNo;
		}

		if (updates.employmentStartDate) {
			newModelJson.employmentStartDate = updates.employmentStartDate;
		}

		if (updates.passportNo) {
			newModelJson.passportNo = updates.passportNo;
		}

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.passportCountry) {
			newModelJson.passportCountry = updates.passportCountry;
		}

		if (updates.postalAddress) {
			newModelJson.postalAddress = updates.postalAddress;
		}

		if (updates.forwardingAddress) {
			newModelJson.forwardingAddress = updates.forwardingAddress;
		}

		if (updates.legalDIsability) {
			newModelJson.legalDIsability = updates.legalDIsability;
		}

		if (updates.legalDisabilityNotes) {
			newModelJson.legalDisabilityNotes = updates.legalDisabilityNotes;
		}

		if (updates.workerInsurance) {
			newModelJson.workerInsurance = updates.workerInsurance;
		}

		if (updates.workerInsuranceNo) {
			newModelJson.workerInsuranceNo = updates.workerInsuranceNo;
		}

		if (updates.patientGeneralInfoId) {
			newModelJson.patientGeneralInfoId = updates.patientGeneralInfoId;
		}

		return new PatientEmploymentDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientEmploymentDetailModel)) {
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
			'patientGeneralInfoId',
			'patientGeneralInfo',
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
		if (!this.patientGeneralInfo) {
			this.patientGeneralInfoId = null;
		} else {
			this.patientGeneralInfoId = this.patientGeneralInfo.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
