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
import {StaffModel} from '../staff/staff.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PatientConsentModel extends AbstractModel {
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
		'consentDateTime',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PatientConsentModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientConsentModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Consent Date And Time.
	 */
	consentDateTime: Date;

	/**
	 * .
	 */
	consentOnPaymentTerms: string;

	/**
	 * .
	 */
	consentOnRightsAndObligations: string;

	/**
	 * .
	 */
	consentOnHospitalRegulations: string;

	/**
	 * .
	 */
	needInterpreter: string;

	/**
	 * .
	 */
	needReligiousCounselor: string;

	/**
	 * Diagnostic Support Results Released to Insurer.
	 */
	dgsResultsReleasedToInsurer: string;

	/**
	 * Diagnostic Support Results Released to Students.
	 */
	dgsResultsReleasedToStudents: string;

	/**
	 * .
	 */
	recordReleasedToFamilyMember: string;

	/**
	 * .
	 */
	recordReleasedToCertainHealthFacilities: string;

	/**
	 * .
	 */
	staffSignature: string;

	/**
	 * .
	 */
	consentingPartySignature: string;

	/**
	 * .
	 */
	consentingPartyType: string;

	/**
	 * .
	 */
	consentingPartyName: string;

	/**
	 * .
	 */
	readAndSignSatusehat: boolean = false;

	/**
	 * .
	 */
	informationReleasedToSatusehat: string;

	/**
	 * .
	 */
	emrReleasedToSatusehat: string;

	patientGeneralInfoId: string;

	patientGeneralInfo: PatientGeneralInfoModel;

	staffId: string;

	staff: StaffModel;

	modelPropGroups: { [s: string]: Group } = PatientConsentModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'consentDateTime',
				// % protected region % [Set displayName for Consent Date Time here] off begin
				displayName: 'Consent Date Time',
				// % protected region % [Set displayName for Consent Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Consent Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Consent Date Time here] end
				// % protected region % [Set isSensitive for Consent Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consent Date Time here] end
				// % protected region % [Set readonly for Consent Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consent Date Time here] end
				validators: [
					// % protected region % [Add other validators for Consent Date Time here] off begin
					// % protected region % [Add other validators for Consent Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Consent Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Consent Date Time here] end
			},
			{
				name: 'consentOnPaymentTerms',
				// % protected region % [Set displayName for Consent On Payment Terms here] off begin
				displayName: 'Consent On Payment Terms',
				// % protected region % [Set displayName for Consent On Payment Terms here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consent On Payment Terms here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consent On Payment Terms here] end
				// % protected region % [Set isSensitive for Consent On Payment Terms here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consent On Payment Terms here] end
				// % protected region % [Set readonly for Consent On Payment Terms here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consent On Payment Terms here] end
				validators: [
					// % protected region % [Add other validators for Consent On Payment Terms here] off begin
					// % protected region % [Add other validators for Consent On Payment Terms here] end
				],
				// % protected region % [Add any additional model attribute properties for Consent On Payment Terms here] off begin
				// % protected region % [Add any additional model attribute properties for Consent On Payment Terms here] end
			},
			{
				name: 'consentOnRightsAndObligations',
				// % protected region % [Set displayName for Consent On Rights And Obligations here] off begin
				displayName: 'Consent On Rights And Obligations',
				// % protected region % [Set displayName for Consent On Rights And Obligations here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consent On Rights And Obligations here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consent On Rights And Obligations here] end
				// % protected region % [Set isSensitive for Consent On Rights And Obligations here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consent On Rights And Obligations here] end
				// % protected region % [Set readonly for Consent On Rights And Obligations here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consent On Rights And Obligations here] end
				validators: [
					// % protected region % [Add other validators for Consent On Rights And Obligations here] off begin
					// % protected region % [Add other validators for Consent On Rights And Obligations here] end
				],
				// % protected region % [Add any additional model attribute properties for Consent On Rights And Obligations here] off begin
				// % protected region % [Add any additional model attribute properties for Consent On Rights And Obligations here] end
			},
			{
				name: 'consentOnHospitalRegulations',
				// % protected region % [Set displayName for Consent On Hospital Regulations here] off begin
				displayName: 'Consent On Hospital Regulations',
				// % protected region % [Set displayName for Consent On Hospital Regulations here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consent On Hospital Regulations here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consent On Hospital Regulations here] end
				// % protected region % [Set isSensitive for Consent On Hospital Regulations here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consent On Hospital Regulations here] end
				// % protected region % [Set readonly for Consent On Hospital Regulations here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consent On Hospital Regulations here] end
				validators: [
					// % protected region % [Add other validators for Consent On Hospital Regulations here] off begin
					// % protected region % [Add other validators for Consent On Hospital Regulations here] end
				],
				// % protected region % [Add any additional model attribute properties for Consent On Hospital Regulations here] off begin
				// % protected region % [Add any additional model attribute properties for Consent On Hospital Regulations here] end
			},
			{
				name: 'needInterpreter',
				// % protected region % [Set displayName for Need Interpreter here] off begin
				displayName: 'Need Interpreter',
				// % protected region % [Set displayName for Need Interpreter here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Need Interpreter here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Need Interpreter here] end
				// % protected region % [Set isSensitive for Need Interpreter here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Need Interpreter here] end
				// % protected region % [Set readonly for Need Interpreter here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Need Interpreter here] end
				validators: [
					// % protected region % [Add other validators for Need Interpreter here] off begin
					// % protected region % [Add other validators for Need Interpreter here] end
				],
				// % protected region % [Add any additional model attribute properties for Need Interpreter here] off begin
				// % protected region % [Add any additional model attribute properties for Need Interpreter here] end
			},
			{
				name: 'needReligiousCounselor',
				// % protected region % [Set displayName for Need Religious Counselor here] off begin
				displayName: 'Need Religious Counselor',
				// % protected region % [Set displayName for Need Religious Counselor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Need Religious Counselor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Need Religious Counselor here] end
				// % protected region % [Set isSensitive for Need Religious Counselor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Need Religious Counselor here] end
				// % protected region % [Set readonly for Need Religious Counselor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Need Religious Counselor here] end
				validators: [
					// % protected region % [Add other validators for Need Religious Counselor here] off begin
					// % protected region % [Add other validators for Need Religious Counselor here] end
				],
				// % protected region % [Add any additional model attribute properties for Need Religious Counselor here] off begin
				// % protected region % [Add any additional model attribute properties for Need Religious Counselor here] end
			},
			{
				name: 'dgsResultsReleasedToInsurer',
				// % protected region % [Set displayName for Dgs Results Released To Insurer here] off begin
				displayName: 'Dgs Results Released To Insurer',
				// % protected region % [Set displayName for Dgs Results Released To Insurer here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dgs Results Released To Insurer here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dgs Results Released To Insurer here] end
				// % protected region % [Set isSensitive for Dgs Results Released To Insurer here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dgs Results Released To Insurer here] end
				// % protected region % [Set readonly for Dgs Results Released To Insurer here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dgs Results Released To Insurer here] end
				validators: [
					// % protected region % [Add other validators for Dgs Results Released To Insurer here] off begin
					// % protected region % [Add other validators for Dgs Results Released To Insurer here] end
				],
				// % protected region % [Add any additional model attribute properties for Dgs Results Released To Insurer here] off begin
				// % protected region % [Add any additional model attribute properties for Dgs Results Released To Insurer here] end
			},
			{
				name: 'dgsResultsReleasedToStudents',
				// % protected region % [Set displayName for Dgs Results Released To Students here] off begin
				displayName: 'Dgs Results Released To Students',
				// % protected region % [Set displayName for Dgs Results Released To Students here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dgs Results Released To Students here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dgs Results Released To Students here] end
				// % protected region % [Set isSensitive for Dgs Results Released To Students here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dgs Results Released To Students here] end
				// % protected region % [Set readonly for Dgs Results Released To Students here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dgs Results Released To Students here] end
				validators: [
					// % protected region % [Add other validators for Dgs Results Released To Students here] off begin
					// % protected region % [Add other validators for Dgs Results Released To Students here] end
				],
				// % protected region % [Add any additional model attribute properties for Dgs Results Released To Students here] off begin
				// % protected region % [Add any additional model attribute properties for Dgs Results Released To Students here] end
			},
			{
				name: 'recordReleasedToFamilyMember',
				// % protected region % [Set displayName for Record Released To Family Member here] off begin
				displayName: 'Record Released To Family Member',
				// % protected region % [Set displayName for Record Released To Family Member here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Record Released To Family Member here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Record Released To Family Member here] end
				// % protected region % [Set isSensitive for Record Released To Family Member here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Record Released To Family Member here] end
				// % protected region % [Set readonly for Record Released To Family Member here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Record Released To Family Member here] end
				validators: [
					// % protected region % [Add other validators for Record Released To Family Member here] off begin
					// % protected region % [Add other validators for Record Released To Family Member here] end
				],
				// % protected region % [Add any additional model attribute properties for Record Released To Family Member here] off begin
				// % protected region % [Add any additional model attribute properties for Record Released To Family Member here] end
			},
			{
				name: 'recordReleasedToCertainHealthFacilities',
				// % protected region % [Set displayName for Record Released To Certain Health Facilities here] off begin
				displayName: 'Record Released To Certain Health Facilities',
				// % protected region % [Set displayName for Record Released To Certain Health Facilities here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Record Released To Certain Health Facilities here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Record Released To Certain Health Facilities here] end
				// % protected region % [Set isSensitive for Record Released To Certain Health Facilities here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Record Released To Certain Health Facilities here] end
				// % protected region % [Set readonly for Record Released To Certain Health Facilities here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Record Released To Certain Health Facilities here] end
				validators: [
					// % protected region % [Add other validators for Record Released To Certain Health Facilities here] off begin
					// % protected region % [Add other validators for Record Released To Certain Health Facilities here] end
				],
				// % protected region % [Add any additional model attribute properties for Record Released To Certain Health Facilities here] off begin
				// % protected region % [Add any additional model attribute properties for Record Released To Certain Health Facilities here] end
			},
			{
				name: 'staffSignature',
				// % protected region % [Set displayName for Staff Signature here] off begin
				displayName: 'Staff Signature',
				// % protected region % [Set displayName for Staff Signature here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Staff Signature here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Staff Signature here] end
				// % protected region % [Set isSensitive for Staff Signature here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Staff Signature here] end
				// % protected region % [Set readonly for Staff Signature here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Staff Signature here] end
				validators: [
					// % protected region % [Add other validators for Staff Signature here] off begin
					// % protected region % [Add other validators for Staff Signature here] end
				],
				// % protected region % [Add any additional model attribute properties for Staff Signature here] off begin
				// % protected region % [Add any additional model attribute properties for Staff Signature here] end
			},
			{
				name: 'consentingPartySignature',
				// % protected region % [Set displayName for Consenting Party Signature here] off begin
				displayName: 'Consenting Party Signature',
				// % protected region % [Set displayName for Consenting Party Signature here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consenting Party Signature here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Consenting Party Signature here] end
				// % protected region % [Set isSensitive for Consenting Party Signature here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consenting Party Signature here] end
				// % protected region % [Set readonly for Consenting Party Signature here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consenting Party Signature here] end
				validators: [
					// % protected region % [Add other validators for Consenting Party Signature here] off begin
					// % protected region % [Add other validators for Consenting Party Signature here] end
				],
				// % protected region % [Add any additional model attribute properties for Consenting Party Signature here] off begin
				// % protected region % [Add any additional model attribute properties for Consenting Party Signature here] end
			},
			{
				name: 'consentingPartyType',
				// % protected region % [Set displayName for Consenting Party Type here] off begin
				displayName: 'Consenting Party Type',
				// % protected region % [Set displayName for Consenting Party Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consenting Party Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consenting Party Type here] end
				// % protected region % [Set isSensitive for Consenting Party Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consenting Party Type here] end
				// % protected region % [Set readonly for Consenting Party Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consenting Party Type here] end
				validators: [
					// % protected region % [Add other validators for Consenting Party Type here] off begin
					// % protected region % [Add other validators for Consenting Party Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Consenting Party Type here] off begin
				// % protected region % [Add any additional model attribute properties for Consenting Party Type here] end
			},
			{
				name: 'consentingPartyName',
				// % protected region % [Set displayName for Consenting Party Name here] off begin
				displayName: 'Consenting Party Name',
				// % protected region % [Set displayName for Consenting Party Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consenting Party Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consenting Party Name here] end
				// % protected region % [Set isSensitive for Consenting Party Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consenting Party Name here] end
				// % protected region % [Set readonly for Consenting Party Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consenting Party Name here] end
				validators: [
					// % protected region % [Add other validators for Consenting Party Name here] off begin
					// % protected region % [Add other validators for Consenting Party Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Consenting Party Name here] off begin
				// % protected region % [Add any additional model attribute properties for Consenting Party Name here] end
			},
			{
				name: 'readAndSignSatusehat',
				// % protected region % [Set displayName for Read And Sign Satusehat here] off begin
				displayName: 'Read And Sign Satusehat',
				// % protected region % [Set displayName for Read And Sign Satusehat here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Read And Sign Satusehat here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Read And Sign Satusehat here] end
				// % protected region % [Set isSensitive for Read And Sign Satusehat here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Read And Sign Satusehat here] end
				// % protected region % [Set readonly for Read And Sign Satusehat here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Read And Sign Satusehat here] end
				validators: [
					// % protected region % [Add other validators for Read And Sign Satusehat here] off begin
					// % protected region % [Add other validators for Read And Sign Satusehat here] end
				],
				// % protected region % [Add any additional model attribute properties for Read And Sign Satusehat here] off begin
				// % protected region % [Add any additional model attribute properties for Read And Sign Satusehat here] end
			},
			{
				name: 'informationReleasedToSatusehat',
				// % protected region % [Set displayName for Information Released To Satusehat here] off begin
				displayName: 'Information Released To Satusehat',
				// % protected region % [Set displayName for Information Released To Satusehat here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Information Released To Satusehat here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Information Released To Satusehat here] end
				// % protected region % [Set isSensitive for Information Released To Satusehat here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Information Released To Satusehat here] end
				// % protected region % [Set readonly for Information Released To Satusehat here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Information Released To Satusehat here] end
				validators: [
					// % protected region % [Add other validators for Information Released To Satusehat here] off begin
					// % protected region % [Add other validators for Information Released To Satusehat here] end
				],
				// % protected region % [Add any additional model attribute properties for Information Released To Satusehat here] off begin
				// % protected region % [Add any additional model attribute properties for Information Released To Satusehat here] end
			},
			{
				name: 'emrReleasedToSatusehat',
				// % protected region % [Set displayName for Emr Released To Satusehat here] off begin
				displayName: 'Emr Released To Satusehat',
				// % protected region % [Set displayName for Emr Released To Satusehat here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Emr Released To Satusehat here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Emr Released To Satusehat here] end
				// % protected region % [Set isSensitive for Emr Released To Satusehat here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Emr Released To Satusehat here] end
				// % protected region % [Set readonly for Emr Released To Satusehat here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Emr Released To Satusehat here] end
				validators: [
					// % protected region % [Add other validators for Emr Released To Satusehat here] off begin
					// % protected region % [Add other validators for Emr Released To Satusehat here] end
				],
				// % protected region % [Add any additional model attribute properties for Emr Released To Satusehat here] off begin
				// % protected region % [Add any additional model attribute properties for Emr Released To Satusehat here] end
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
			{
				id: 'staff',
				type: ModelRelationType.ONE,
				name: 'staffId',
				// % protected region % [Customise your label for Staff here] off begin
				label: 'Staff',
				// % protected region % [Customise your label for Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Staff here] end
				validators: [
					// % protected region % [Add other validators for Staff here] off begin
					// % protected region % [Add other validators for Staff here] end
				],
				// % protected region % [Add any additional field for relation Staff here] off begin
				// % protected region % [Add any additional field for relation Staff here] end
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
	static deepParse(data: string | { [K in keyof PatientConsentModel]?: PatientConsentModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientConsentModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.patientGeneralInfo) {
			currentModel.patientGeneralInfoId = json.patientGeneralInfo.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInfo));
		}

		// Incoming one to many
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let patientConsentModel = new PatientConsentModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientConsentModel,
	 *    it is expected as a JSON string or as a nullable PatientConsentModel.
	 */
	constructor(data?: string | Partial<PatientConsentModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientConsentModel>
				: data;

			if (json.consentDateTime) {
				this.consentDateTime = new Date(json.consentDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.consentDateTime = json.consentDateTime;
			}
			this.consentOnPaymentTerms = json.consentOnPaymentTerms;
			this.consentOnRightsAndObligations = json.consentOnRightsAndObligations;
			this.consentOnHospitalRegulations = json.consentOnHospitalRegulations;
			this.needInterpreter = json.needInterpreter;
			this.needReligiousCounselor = json.needReligiousCounselor;
			this.dgsResultsReleasedToInsurer = json.dgsResultsReleasedToInsurer;
			this.dgsResultsReleasedToStudents = json.dgsResultsReleasedToStudents;
			this.recordReleasedToFamilyMember = json.recordReleasedToFamilyMember;
			this.recordReleasedToCertainHealthFacilities = json.recordReleasedToCertainHealthFacilities;
			this.staffSignature = json.staffSignature;
			this.consentingPartySignature = json.consentingPartySignature;
			this.consentingPartyType = json.consentingPartyType;
			this.consentingPartyName = json.consentingPartyName;
			this.readAndSignSatusehat = json.readAndSignSatusehat;
			this.informationReleasedToSatusehat = json.informationReleasedToSatusehat;
			this.emrReleasedToSatusehat = json.emrReleasedToSatusehat;
			this.patientGeneralInfoId = json.patientGeneralInfoId;
			this.patientGeneralInfo = json.patientGeneralInfo;
			this.staffId = json.staffId;
			this.staff = json.staff;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			consentDateTime: this.consentDateTime,
			consentOnPaymentTerms: this.consentOnPaymentTerms,
			consentOnRightsAndObligations: this.consentOnRightsAndObligations,
			consentOnHospitalRegulations: this.consentOnHospitalRegulations,
			needInterpreter: this.needInterpreter,
			needReligiousCounselor: this.needReligiousCounselor,
			dgsResultsReleasedToInsurer: this.dgsResultsReleasedToInsurer,
			dgsResultsReleasedToStudents: this.dgsResultsReleasedToStudents,
			recordReleasedToFamilyMember: this.recordReleasedToFamilyMember,
			recordReleasedToCertainHealthFacilities: this.recordReleasedToCertainHealthFacilities,
			staffSignature: this.staffSignature,
			consentingPartySignature: this.consentingPartySignature,
			consentingPartyType: this.consentingPartyType,
			consentingPartyName: this.consentingPartyName,
			readAndSignSatusehat: this.readAndSignSatusehat,
			informationReleasedToSatusehat: this.informationReleasedToSatusehat,
			emrReleasedToSatusehat: this.emrReleasedToSatusehat,
			patientGeneralInfoId: this.patientGeneralInfoId,
			staffId: this.staffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientConsentModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientConsentModel {
		let newModelJson = this.toJSON();

		if (updates.consentDateTime) {
			newModelJson.consentDateTime = updates.consentDateTime;
		}

		if (updates.consentOnPaymentTerms) {
			newModelJson.consentOnPaymentTerms = updates.consentOnPaymentTerms;
		}

		if (updates.consentOnRightsAndObligations) {
			newModelJson.consentOnRightsAndObligations = updates.consentOnRightsAndObligations;
		}

		if (updates.consentOnHospitalRegulations) {
			newModelJson.consentOnHospitalRegulations = updates.consentOnHospitalRegulations;
		}

		if (updates.needInterpreter) {
			newModelJson.needInterpreter = updates.needInterpreter;
		}

		if (updates.needReligiousCounselor) {
			newModelJson.needReligiousCounselor = updates.needReligiousCounselor;
		}

		if (updates.dgsResultsReleasedToInsurer) {
			newModelJson.dgsResultsReleasedToInsurer = updates.dgsResultsReleasedToInsurer;
		}

		if (updates.dgsResultsReleasedToStudents) {
			newModelJson.dgsResultsReleasedToStudents = updates.dgsResultsReleasedToStudents;
		}

		if (updates.recordReleasedToFamilyMember) {
			newModelJson.recordReleasedToFamilyMember = updates.recordReleasedToFamilyMember;
		}

		if (updates.recordReleasedToCertainHealthFacilities) {
			newModelJson.recordReleasedToCertainHealthFacilities = updates.recordReleasedToCertainHealthFacilities;
		}

		if (updates.staffSignature) {
			newModelJson.staffSignature = updates.staffSignature;
		}

		if (updates.consentingPartySignature) {
			newModelJson.consentingPartySignature = updates.consentingPartySignature;
		}

		if (updates.consentingPartyType) {
			newModelJson.consentingPartyType = updates.consentingPartyType;
		}

		if (updates.consentingPartyName) {
			newModelJson.consentingPartyName = updates.consentingPartyName;
		}

		if (updates.readAndSignSatusehat) {
			newModelJson.readAndSignSatusehat = updates.readAndSignSatusehat;
		}

		if (updates.informationReleasedToSatusehat) {
			newModelJson.informationReleasedToSatusehat = updates.informationReleasedToSatusehat;
		}

		if (updates.emrReleasedToSatusehat) {
			newModelJson.emrReleasedToSatusehat = updates.emrReleasedToSatusehat;
		}

		if (updates.patientGeneralInfoId) {
			newModelJson.patientGeneralInfoId = updates.patientGeneralInfoId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		return new PatientConsentModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientConsentModel)) {
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
			'staffId',
			'staff',
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

		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
