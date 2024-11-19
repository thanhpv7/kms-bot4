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
import {RegistrationModel} from '../registration/registration.model';
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
export class InformedConsentModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'notes',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'patientFamilyGuardianName',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InformedConsentModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InformedConsentModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	patientFamilyGuardianName: string;

	/**
	 * .
	 */
	patientFamilyGuardianRelationship: string;

	/**
	 * .
	 */
	procedureToBePerformed: string;

	/**
	 * .
	 */
	consequenceOfProcedure: string;

	/**
	 * .
	 */
	consentOnProcedure: string;

	/**
	 * .
	 */
	consentDateTime: Date;

	/**
	 * .
	 */
	informingStaffSignature: string;

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
	witnessSignature1: string;

	/**
	 * .
	 */
	witnessName1: string;

	/**
	 * .
	 */
	witnessSignature2: string;

	/**
	 * .
	 */
	witnessName2: string;

	/**
	 * Notes.
	 */
	notes: string;

	accompanyingStaffId: string;

	accompanyingStaff: StaffModel;

	patientGeneralInfoId: string;

	patientGeneralInfo: PatientGeneralInfoModel;

	registrationId: string;

	registration: RegistrationModel;

	informingStaffId: string;

	informingStaff: StaffModel;

	modelPropGroups: { [s: string]: Group } = InformedConsentModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'patientFamilyGuardianName',
				// % protected region % [Set displayName for Patient Family Guardian Name here] off begin
				displayName: 'Patient Family Guardian Name',
				// % protected region % [Set displayName for Patient Family Guardian Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient Family Guardian Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient Family Guardian Name here] end
				// % protected region % [Set isSensitive for Patient Family Guardian Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Family Guardian Name here] end
				// % protected region % [Set readonly for Patient Family Guardian Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Family Guardian Name here] end
				validators: [
					// % protected region % [Add other validators for Patient Family Guardian Name here] off begin
					// % protected region % [Add other validators for Patient Family Guardian Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Family Guardian Name here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Family Guardian Name here] end
			},
			{
				name: 'patientFamilyGuardianRelationship',
				// % protected region % [Set displayName for Patient Family Guardian Relationship here] off begin
				displayName: 'Patient Family Guardian Relationship',
				// % protected region % [Set displayName for Patient Family Guardian Relationship here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient Family Guardian Relationship here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient Family Guardian Relationship here] end
				// % protected region % [Set isSensitive for Patient Family Guardian Relationship here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Family Guardian Relationship here] end
				// % protected region % [Set readonly for Patient Family Guardian Relationship here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Family Guardian Relationship here] end
				validators: [
					// % protected region % [Add other validators for Patient Family Guardian Relationship here] off begin
					// % protected region % [Add other validators for Patient Family Guardian Relationship here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Family Guardian Relationship here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Family Guardian Relationship here] end
			},
			{
				name: 'procedureToBePerformed',
				// % protected region % [Set displayName for Procedure To Be Performed here] off begin
				displayName: 'Procedure To Be Performed',
				// % protected region % [Set displayName for Procedure To Be Performed here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Procedure To Be Performed here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Procedure To Be Performed here] end
				// % protected region % [Set isSensitive for Procedure To Be Performed here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Procedure To Be Performed here] end
				// % protected region % [Set readonly for Procedure To Be Performed here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Procedure To Be Performed here] end
				validators: [
					// % protected region % [Add other validators for Procedure To Be Performed here] off begin
					// % protected region % [Add other validators for Procedure To Be Performed here] end
				],
				// % protected region % [Add any additional model attribute properties for Procedure To Be Performed here] off begin
				// % protected region % [Add any additional model attribute properties for Procedure To Be Performed here] end
			},
			{
				name: 'consequenceOfProcedure',
				// % protected region % [Set displayName for Consequence Of Procedure here] off begin
				displayName: 'Consequence Of Procedure',
				// % protected region % [Set displayName for Consequence Of Procedure here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consequence Of Procedure here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Consequence Of Procedure here] end
				// % protected region % [Set isSensitive for Consequence Of Procedure here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consequence Of Procedure here] end
				// % protected region % [Set readonly for Consequence Of Procedure here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consequence Of Procedure here] end
				validators: [
					// % protected region % [Add other validators for Consequence Of Procedure here] off begin
					// % protected region % [Add other validators for Consequence Of Procedure here] end
				],
				// % protected region % [Add any additional model attribute properties for Consequence Of Procedure here] off begin
				// % protected region % [Add any additional model attribute properties for Consequence Of Procedure here] end
			},
			{
				name: 'consentOnProcedure',
				// % protected region % [Set displayName for Consent On Procedure here] off begin
				displayName: 'Consent On Procedure',
				// % protected region % [Set displayName for Consent On Procedure here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consent On Procedure here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consent On Procedure here] end
				// % protected region % [Set isSensitive for Consent On Procedure here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consent On Procedure here] end
				// % protected region % [Set readonly for Consent On Procedure here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consent On Procedure here] end
				validators: [
					// % protected region % [Add other validators for Consent On Procedure here] off begin
					// % protected region % [Add other validators for Consent On Procedure here] end
				],
				// % protected region % [Add any additional model attribute properties for Consent On Procedure here] off begin
				// % protected region % [Add any additional model attribute properties for Consent On Procedure here] end
			},
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
				name: 'informingStaffSignature',
				// % protected region % [Set displayName for Informing Staff Signature here] off begin
				displayName: 'Informing Staff Signature',
				// % protected region % [Set displayName for Informing Staff Signature here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Informing Staff Signature here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Informing Staff Signature here] end
				// % protected region % [Set isSensitive for Informing Staff Signature here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Informing Staff Signature here] end
				// % protected region % [Set readonly for Informing Staff Signature here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Informing Staff Signature here] end
				validators: [
					// % protected region % [Add other validators for Informing Staff Signature here] off begin
					// % protected region % [Add other validators for Informing Staff Signature here] end
				],
				// % protected region % [Add any additional model attribute properties for Informing Staff Signature here] off begin
				// % protected region % [Add any additional model attribute properties for Informing Staff Signature here] end
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
				name: 'witnessSignature1',
				// % protected region % [Set displayName for Witness Signature 1 here] off begin
				displayName: 'Witness Signature 1',
				// % protected region % [Set displayName for Witness Signature 1 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Witness Signature 1 here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Witness Signature 1 here] end
				// % protected region % [Set isSensitive for Witness Signature 1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Witness Signature 1 here] end
				// % protected region % [Set readonly for Witness Signature 1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Witness Signature 1 here] end
				validators: [
					// % protected region % [Add other validators for Witness Signature 1 here] off begin
					// % protected region % [Add other validators for Witness Signature 1 here] end
				],
				// % protected region % [Add any additional model attribute properties for Witness Signature 1 here] off begin
				// % protected region % [Add any additional model attribute properties for Witness Signature 1 here] end
			},
			{
				name: 'witnessName1',
				// % protected region % [Set displayName for Witness Name 1 here] off begin
				displayName: 'Witness Name 1',
				// % protected region % [Set displayName for Witness Name 1 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Witness Name 1 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Witness Name 1 here] end
				// % protected region % [Set isSensitive for Witness Name 1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Witness Name 1 here] end
				// % protected region % [Set readonly for Witness Name 1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Witness Name 1 here] end
				validators: [
					// % protected region % [Add other validators for Witness Name 1 here] off begin
					// % protected region % [Add other validators for Witness Name 1 here] end
				],
				// % protected region % [Add any additional model attribute properties for Witness Name 1 here] off begin
				// % protected region % [Add any additional model attribute properties for Witness Name 1 here] end
			},
			{
				name: 'witnessSignature2',
				// % protected region % [Set displayName for Witness Signature 2 here] off begin
				displayName: 'Witness Signature 2',
				// % protected region % [Set displayName for Witness Signature 2 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Witness Signature 2 here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Witness Signature 2 here] end
				// % protected region % [Set isSensitive for Witness Signature 2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Witness Signature 2 here] end
				// % protected region % [Set readonly for Witness Signature 2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Witness Signature 2 here] end
				validators: [
					// % protected region % [Add other validators for Witness Signature 2 here] off begin
					// % protected region % [Add other validators for Witness Signature 2 here] end
				],
				// % protected region % [Add any additional model attribute properties for Witness Signature 2 here] off begin
				// % protected region % [Add any additional model attribute properties for Witness Signature 2 here] end
			},
			{
				name: 'witnessName2',
				// % protected region % [Set displayName for Witness Name 2 here] off begin
				displayName: 'Witness Name 2',
				// % protected region % [Set displayName for Witness Name 2 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Witness Name 2 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Witness Name 2 here] end
				// % protected region % [Set isSensitive for Witness Name 2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Witness Name 2 here] end
				// % protected region % [Set readonly for Witness Name 2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Witness Name 2 here] end
				validators: [
					// % protected region % [Add other validators for Witness Name 2 here] off begin
					// % protected region % [Add other validators for Witness Name 2 here] end
				],
				// % protected region % [Add any additional model attribute properties for Witness Name 2 here] off begin
				// % protected region % [Add any additional model attribute properties for Witness Name 2 here] end
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
				id: 'accompanyingStaff',
				type: ModelRelationType.ONE,
				name: 'accompanyingStaffId',
				// % protected region % [Customise your label for Accompanying Staff here] off begin
				label: 'Accompanying Staff',
				// % protected region % [Customise your label for Accompanying Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Accompanying Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Accompanying Staff here] end
				validators: [
					// % protected region % [Add other validators for Accompanying Staff here] off begin
					// % protected region % [Add other validators for Accompanying Staff here] end
				],
				// % protected region % [Add any additional field for relation Accompanying Staff here] off begin
				// % protected region % [Add any additional field for relation Accompanying Staff here] end
			},
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
				id: 'registration',
				type: ModelRelationType.ONE,
				name: 'registrationId',
				// % protected region % [Customise your label for Registration here] off begin
				label: 'Registration',
				// % protected region % [Customise your label for Registration here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registration here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registration here] end
				validators: [
					// % protected region % [Add other validators for Registration here] off begin
					// % protected region % [Add other validators for Registration here] end
				],
				// % protected region % [Add any additional field for relation Registration here] off begin
				// % protected region % [Add any additional field for relation Registration here] end
			},
			{
				id: 'informingStaff',
				type: ModelRelationType.ONE,
				name: 'informingStaffId',
				// % protected region % [Customise your label for Informing Staff here] off begin
				label: 'Informing Staff',
				// % protected region % [Customise your label for Informing Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Informing Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Informing Staff here] end
				validators: [
					// % protected region % [Add other validators for Informing Staff here] off begin
					// % protected region % [Add other validators for Informing Staff here] end
				],
				// % protected region % [Add any additional field for relation Informing Staff here] off begin
				// % protected region % [Add any additional field for relation Informing Staff here] end
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
				case 'notes':
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
	static deepParse(data: string | { [K in keyof InformedConsentModel]?: InformedConsentModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InformedConsentModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.accompanyingStaff) {
			currentModel.accompanyingStaffId = json.accompanyingStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.accompanyingStaff));
		}

		// Incoming one to many
		if (json.patientGeneralInfo) {
			currentModel.patientGeneralInfoId = json.patientGeneralInfo.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInfo));
		}

		// Incoming one to many
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

		// Incoming one to many
		if (json.informingStaff) {
			currentModel.informingStaffId = json.informingStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.informingStaff));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let informedConsentModel = new InformedConsentModel(data);`
	 *
	 * @param data The input data to be initialised as the InformedConsentModel,
	 *    it is expected as a JSON string or as a nullable InformedConsentModel.
	 */
	constructor(data?: string | Partial<InformedConsentModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InformedConsentModel>
				: data;

			this.patientFamilyGuardianName = json.patientFamilyGuardianName;
			this.patientFamilyGuardianRelationship = json.patientFamilyGuardianRelationship;
			this.procedureToBePerformed = json.procedureToBePerformed;
			this.consequenceOfProcedure = json.consequenceOfProcedure;
			this.consentOnProcedure = json.consentOnProcedure;
			if (json.consentDateTime) {
				this.consentDateTime = new Date(json.consentDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.consentDateTime = json.consentDateTime;
			}
			this.informingStaffSignature = json.informingStaffSignature;
			this.consentingPartySignature = json.consentingPartySignature;
			this.consentingPartyType = json.consentingPartyType;
			this.consentingPartyName = json.consentingPartyName;
			this.witnessSignature1 = json.witnessSignature1;
			this.witnessName1 = json.witnessName1;
			this.witnessSignature2 = json.witnessSignature2;
			this.witnessName2 = json.witnessName2;
			this.notes = json.notes;
			this.accompanyingStaffId = json.accompanyingStaffId;
			this.accompanyingStaff = json.accompanyingStaff;
			this.patientGeneralInfoId = json.patientGeneralInfoId;
			this.patientGeneralInfo = json.patientGeneralInfo;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.informingStaffId = json.informingStaffId;
			this.informingStaff = json.informingStaff;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			patientFamilyGuardianName: this.patientFamilyGuardianName,
			patientFamilyGuardianRelationship: this.patientFamilyGuardianRelationship,
			procedureToBePerformed: this.procedureToBePerformed,
			consequenceOfProcedure: this.consequenceOfProcedure,
			consentOnProcedure: this.consentOnProcedure,
			consentDateTime: this.consentDateTime,
			informingStaffSignature: this.informingStaffSignature,
			consentingPartySignature: this.consentingPartySignature,
			consentingPartyType: this.consentingPartyType,
			consentingPartyName: this.consentingPartyName,
			witnessSignature1: this.witnessSignature1,
			witnessName1: this.witnessName1,
			witnessSignature2: this.witnessSignature2,
			witnessName2: this.witnessName2,
			notes: this.notes,
			accompanyingStaffId: this.accompanyingStaffId,
			patientGeneralInfoId: this.patientGeneralInfoId,
			registrationId: this.registrationId,
			informingStaffId: this.informingStaffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InformedConsentModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InformedConsentModel {
		let newModelJson = this.toJSON();

		if (updates.patientFamilyGuardianName) {
			newModelJson.patientFamilyGuardianName = updates.patientFamilyGuardianName;
		}

		if (updates.patientFamilyGuardianRelationship) {
			newModelJson.patientFamilyGuardianRelationship = updates.patientFamilyGuardianRelationship;
		}

		if (updates.procedureToBePerformed) {
			newModelJson.procedureToBePerformed = updates.procedureToBePerformed;
		}

		if (updates.consequenceOfProcedure) {
			newModelJson.consequenceOfProcedure = updates.consequenceOfProcedure;
		}

		if (updates.consentOnProcedure) {
			newModelJson.consentOnProcedure = updates.consentOnProcedure;
		}

		if (updates.consentDateTime) {
			newModelJson.consentDateTime = updates.consentDateTime;
		}

		if (updates.informingStaffSignature) {
			newModelJson.informingStaffSignature = updates.informingStaffSignature;
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

		if (updates.witnessSignature1) {
			newModelJson.witnessSignature1 = updates.witnessSignature1;
		}

		if (updates.witnessName1) {
			newModelJson.witnessName1 = updates.witnessName1;
		}

		if (updates.witnessSignature2) {
			newModelJson.witnessSignature2 = updates.witnessSignature2;
		}

		if (updates.witnessName2) {
			newModelJson.witnessName2 = updates.witnessName2;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.accompanyingStaffId) {
			newModelJson.accompanyingStaffId = updates.accompanyingStaffId;
		}

		if (updates.patientGeneralInfoId) {
			newModelJson.patientGeneralInfoId = updates.patientGeneralInfoId;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.informingStaffId) {
			newModelJson.informingStaffId = updates.informingStaffId;
		}

		return new InformedConsentModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InformedConsentModel)) {
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
			'accompanyingStaffId',
			'accompanyingStaff',
			'patientGeneralInfoId',
			'patientGeneralInfo',
			'registrationId',
			'registration',
			'informingStaffId',
			'informingStaff',
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
		if (!this.accompanyingStaff) {
			this.accompanyingStaffId = null;
		} else {
			this.accompanyingStaffId = this.accompanyingStaff.id;
		}

		if (!this.patientGeneralInfo) {
			this.patientGeneralInfoId = null;
		} else {
			this.patientGeneralInfoId = this.patientGeneralInfo.id;
		}

		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

		if (!this.informingStaff) {
			this.informingStaffId = null;
		} else {
			this.informingStaffId = this.informingStaff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
