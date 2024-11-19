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
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsINACBGModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'healthFacilityCode',
		'healthFacilityName',
		'address',
		'stateProvince',
		'cityRegency',
		'regional',
		'hospitalClass',
		'inacbgTariff1',
		'inacbgTariff2',
		'additionalUpgradeVIP',
		'payplanID',
		'paymentPlanCode',
		'tariffCode',
		'url',
		'username',
		'password',
		'secretKey',
		'coderID',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'healthFacilityCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsINACBGModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsINACBGModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Hospital Setup.
	 */
	healthFacilityCode: string;

	/**
	 * Hospital Setup.
	 */
	healthFacilityName: string;

	/**
	 * Hospital Setup.
	 */
	address: string;

	/**
	 * Hospital Setup, State or Province.
	 */
	stateProvince: string;

	/**
	 * Hospital Setup, City or Regency.
	 */
	cityRegency: string;

	/**
	 * Hospital Setup.
	 */
	regional: string;

	/**
	 * Hospital Setup.
	 */
	hospitalClass: string;

	/**
	 * Hospital Setup.
	 */
	inacbgTariff1: string;

	/**
	 * Hospital Setup.
	 */
	inacbgTariff2: string;

	/**
	 * .
	 */
	additionalUpgradeVIP: string;

	/**
	 * Payplan.
	 */
	payplanID: string;

	/**
	 * Payplan.
	 */
	paymentPlanCode: string;

	/**
	 * Payplan.
	 */
	tariffCode: string;

	/**
	 * Interoperability.
	 */
	url: string;

	/**
	 * Interoperability.
	 */
	username: string;

	/**
	 * Interoperability.
	 */
	password: string;

	/**
	 * Interoperability.
	 */
	secretKey: string;

	/**
	 * Interoperability.
	 */
	coderID: string;



	modelPropGroups: { [s: string]: Group } = BpjsINACBGModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'healthFacilityCode',
				// % protected region % [Set displayName for Health Facility Code here] off begin
				displayName: 'Health Facility Code',
				// % protected region % [Set displayName for Health Facility Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Health Facility Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Health Facility Code here] end
				// % protected region % [Set isSensitive for Health Facility Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Health Facility Code here] end
				// % protected region % [Set readonly for Health Facility Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Health Facility Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(25),
					// % protected region % [Add other validators for Health Facility Code here] off begin
					// % protected region % [Add other validators for Health Facility Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Health Facility Code here] off begin
				// % protected region % [Add any additional model attribute properties for Health Facility Code here] end
			},
			{
				name: 'healthFacilityName',
				// % protected region % [Set displayName for Health Facility Name here] off begin
				displayName: 'Health Facility Name',
				// % protected region % [Set displayName for Health Facility Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Health Facility Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Health Facility Name here] end
				// % protected region % [Set isSensitive for Health Facility Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Health Facility Name here] end
				// % protected region % [Set readonly for Health Facility Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Health Facility Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for Health Facility Name here] off begin
					// % protected region % [Add other validators for Health Facility Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Health Facility Name here] off begin
				// % protected region % [Add any additional model attribute properties for Health Facility Name here] end
			},
			{
				name: 'address',
				// % protected region % [Set displayName for Address here] off begin
				displayName: 'Address',
				// % protected region % [Set displayName for Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Address here] end
				// % protected region % [Set isSensitive for Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Address here] end
				// % protected region % [Set readonly for Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Address here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Address here] off begin
					// % protected region % [Add other validators for Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Address here] off begin
				// % protected region % [Add any additional model attribute properties for Address here] end
			},
			{
				name: 'stateProvince',
				// % protected region % [Set displayName for State Province here] off begin
				displayName: 'State Province',
				// % protected region % [Set displayName for State Province here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for State Province here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for State Province here] end
				// % protected region % [Set isSensitive for State Province here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for State Province here] end
				// % protected region % [Set readonly for State Province here] off begin
				readOnly: false,
				// % protected region % [Set readonly for State Province here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(50),
					// % protected region % [Add other validators for State Province here] off begin
					// % protected region % [Add other validators for State Province here] end
				],
				// % protected region % [Add any additional model attribute properties for State Province here] off begin
				// % protected region % [Add any additional model attribute properties for State Province here] end
			},
			{
				name: 'cityRegency',
				// % protected region % [Set displayName for City Regency here] off begin
				displayName: 'City Regency',
				// % protected region % [Set displayName for City Regency here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for City Regency here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for City Regency here] end
				// % protected region % [Set isSensitive for City Regency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for City Regency here] end
				// % protected region % [Set readonly for City Regency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for City Regency here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(50),
					// % protected region % [Add other validators for City Regency here] off begin
					// % protected region % [Add other validators for City Regency here] end
				],
				// % protected region % [Add any additional model attribute properties for City Regency here] off begin
				// % protected region % [Add any additional model attribute properties for City Regency here] end
			},
			{
				name: 'regional',
				// % protected region % [Set displayName for Regional here] off begin
				displayName: 'Regional',
				// % protected region % [Set displayName for Regional here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Regional here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Regional here] end
				// % protected region % [Set isSensitive for Regional here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Regional here] end
				// % protected region % [Set readonly for Regional here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Regional here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(50),
					// % protected region % [Add other validators for Regional here] off begin
					// % protected region % [Add other validators for Regional here] end
				],
				// % protected region % [Add any additional model attribute properties for Regional here] off begin
				// % protected region % [Add any additional model attribute properties for Regional here] end
			},
			{
				name: 'hospitalClass',
				// % protected region % [Set displayName for Hospital Class here] off begin
				displayName: 'Hospital Class',
				// % protected region % [Set displayName for Hospital Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Class here] end
				// % protected region % [Set isSensitive for Hospital Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Class here] end
				// % protected region % [Set readonly for Hospital Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Class here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(25),
					// % protected region % [Add other validators for Hospital Class here] off begin
					// % protected region % [Add other validators for Hospital Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Class here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Class here] end
			},
			{
				name: 'inacbgTariff1',
				// % protected region % [Set displayName for INACBG Tariff 1 here] off begin
				displayName: 'INACBG Tariff 1',
				// % protected region % [Set displayName for INACBG Tariff 1 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for INACBG Tariff 1 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for INACBG Tariff 1 here] end
				// % protected region % [Set isSensitive for INACBG Tariff 1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for INACBG Tariff 1 here] end
				// % protected region % [Set readonly for INACBG Tariff 1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for INACBG Tariff 1 here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for INACBG Tariff 1 here] off begin
					// % protected region % [Add other validators for INACBG Tariff 1 here] end
				],
				// % protected region % [Add any additional model attribute properties for INACBG Tariff 1 here] off begin
				// % protected region % [Add any additional model attribute properties for INACBG Tariff 1 here] end
			},
			{
				name: 'inacbgTariff2',
				// % protected region % [Set displayName for INACBG Tariff 2 here] off begin
				displayName: 'INACBG Tariff 2',
				// % protected region % [Set displayName for INACBG Tariff 2 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for INACBG Tariff 2 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for INACBG Tariff 2 here] end
				// % protected region % [Set isSensitive for INACBG Tariff 2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for INACBG Tariff 2 here] end
				// % protected region % [Set readonly for INACBG Tariff 2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for INACBG Tariff 2 here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for INACBG Tariff 2 here] off begin
					// % protected region % [Add other validators for INACBG Tariff 2 here] end
				],
				// % protected region % [Add any additional model attribute properties for INACBG Tariff 2 here] off begin
				// % protected region % [Add any additional model attribute properties for INACBG Tariff 2 here] end
			},
			{
				name: 'additionalUpgradeVIP',
				// % protected region % [Set displayName for Additional Upgrade VIP here] off begin
				displayName: 'Additional Upgrade VIP',
				// % protected region % [Set displayName for Additional Upgrade VIP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Additional Upgrade VIP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Additional Upgrade VIP here] end
				// % protected region % [Set isSensitive for Additional Upgrade VIP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Additional Upgrade VIP here] end
				// % protected region % [Set readonly for Additional Upgrade VIP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Additional Upgrade VIP here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for Additional Upgrade VIP here] off begin
					// % protected region % [Add other validators for Additional Upgrade VIP here] end
				],
				// % protected region % [Add any additional model attribute properties for Additional Upgrade VIP here] off begin
				// % protected region % [Add any additional model attribute properties for Additional Upgrade VIP here] end
			},
			{
				name: 'payplanID',
				// % protected region % [Set displayName for Payplan ID here] off begin
				displayName: 'Payplan ID',
				// % protected region % [Set displayName for Payplan ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Payplan ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Payplan ID here] end
				// % protected region % [Set isSensitive for Payplan ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Payplan ID here] end
				// % protected region % [Set readonly for Payplan ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Payplan ID here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for Payplan ID here] off begin
					// % protected region % [Add other validators for Payplan ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Payplan ID here] off begin
				// % protected region % [Add any additional model attribute properties for Payplan ID here] end
			},
			{
				name: 'paymentPlanCode',
				// % protected region % [Set displayName for Payment Plan Code here] off begin
				displayName: 'Payment Plan Code',
				// % protected region % [Set displayName for Payment Plan Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Payment Plan Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Payment Plan Code here] end
				// % protected region % [Set isSensitive for Payment Plan Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Payment Plan Code here] end
				// % protected region % [Set readonly for Payment Plan Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Payment Plan Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for Payment Plan Code here] off begin
					// % protected region % [Add other validators for Payment Plan Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Payment Plan Code here] off begin
				// % protected region % [Add any additional model attribute properties for Payment Plan Code here] end
			},
			{
				name: 'tariffCode',
				// % protected region % [Set displayName for Tariff Code here] off begin
				displayName: 'Tariff Code',
				// % protected region % [Set displayName for Tariff Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tariff Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tariff Code here] end
				// % protected region % [Set isSensitive for Tariff Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff Code here] end
				// % protected region % [Set readonly for Tariff Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(50),
					// % protected region % [Add other validators for Tariff Code here] off begin
					// % protected region % [Add other validators for Tariff Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Code here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Code here] end
			},
			{
				name: 'url',
				// % protected region % [Set displayName for URL here] off begin
				displayName: 'URL',
				// % protected region % [Set displayName for URL here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for URL here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for URL here] end
				// % protected region % [Set isSensitive for URL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for URL here] end
				// % protected region % [Set readonly for URL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for URL here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for URL here] off begin
					// % protected region % [Add other validators for URL here] end
				],
				// % protected region % [Add any additional model attribute properties for URL here] off begin
				// % protected region % [Add any additional model attribute properties for URL here] end
			},
			{
				name: 'username',
				// % protected region % [Set displayName for Username here] off begin
				displayName: 'Username',
				// % protected region % [Set displayName for Username here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Username here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Username here] end
				// % protected region % [Set isSensitive for Username here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Username here] end
				// % protected region % [Set readonly for Username here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Username here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for Username here] off begin
					// % protected region % [Add other validators for Username here] end
				],
				// % protected region % [Add any additional model attribute properties for Username here] off begin
				// % protected region % [Add any additional model attribute properties for Username here] end
			},
			{
				name: 'password',
				// % protected region % [Set displayName for Password here] off begin
				displayName: 'Password',
				// % protected region % [Set displayName for Password here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Password here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Password here] end
				// % protected region % [Set isSensitive for Password here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Password here] end
				// % protected region % [Set readonly for Password here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Password here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for Password here] off begin
					// % protected region % [Add other validators for Password here] end
				],
				// % protected region % [Add any additional model attribute properties for Password here] off begin
				// % protected region % [Add any additional model attribute properties for Password here] end
			},
			{
				name: 'secretKey',
				// % protected region % [Set displayName for Secret Key here] off begin
				displayName: 'Secret Key',
				// % protected region % [Set displayName for Secret Key here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Secret Key here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Secret Key here] end
				// % protected region % [Set isSensitive for Secret Key here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Secret Key here] end
				// % protected region % [Set readonly for Secret Key here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Secret Key here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(225),
					// % protected region % [Add other validators for Secret Key here] off begin
					// % protected region % [Add other validators for Secret Key here] end
				],
				// % protected region % [Add any additional model attribute properties for Secret Key here] off begin
				// % protected region % [Add any additional model attribute properties for Secret Key here] end
			},
			{
				name: 'coderID',
				// % protected region % [Set displayName for Coder ID here] off begin
				displayName: 'Coder ID',
				// % protected region % [Set displayName for Coder ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Coder ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Coder ID here] end
				// % protected region % [Set isSensitive for Coder ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Coder ID here] end
				// % protected region % [Set readonly for Coder ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Coder ID here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(100),
					// % protected region % [Add other validators for Coder ID here] off begin
					// % protected region % [Add other validators for Coder ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Coder ID here] off begin
				// % protected region % [Add any additional model attribute properties for Coder ID here] end
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
				case 'healthFacilityCode':
					break;
				case 'healthFacilityName':
					break;
				case 'address':
					break;
				case 'stateProvince':
					break;
				case 'cityRegency':
					break;
				case 'regional':
					break;
				case 'hospitalClass':
					break;
				case 'inacbgTariff1':
					break;
				case 'inacbgTariff2':
					break;
				case 'additionalUpgradeVIP':
					break;
				case 'payplanID':
					break;
				case 'paymentPlanCode':
					break;
				case 'tariffCode':
					break;
				case 'url':
					break;
				case 'username':
					break;
				case 'password':
					break;
				case 'secretKey':
					break;
				case 'coderID':
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
	static deepParse(data: string | { [K in keyof BpjsINACBGModel]?: BpjsINACBGModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsINACBGModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsINACBGModel = new BpjsINACBGModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsINACBGModel,
	 *    it is expected as a JSON string or as a nullable BpjsINACBGModel.
	 */
	constructor(data?: string | Partial<BpjsINACBGModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsINACBGModel>
				: data;

			this.healthFacilityCode = json.healthFacilityCode;
			this.healthFacilityName = json.healthFacilityName;
			this.address = json.address;
			this.stateProvince = json.stateProvince;
			this.cityRegency = json.cityRegency;
			this.regional = json.regional;
			this.hospitalClass = json.hospitalClass;
			this.inacbgTariff1 = json.inacbgTariff1;
			this.inacbgTariff2 = json.inacbgTariff2;
			this.additionalUpgradeVIP = json.additionalUpgradeVIP;
			this.payplanID = json.payplanID;
			this.paymentPlanCode = json.paymentPlanCode;
			this.tariffCode = json.tariffCode;
			this.url = json.url;
			this.username = json.username;
			this.password = json.password;
			this.secretKey = json.secretKey;
			this.coderID = json.coderID;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			healthFacilityCode: this.healthFacilityCode,
			healthFacilityName: this.healthFacilityName,
			address: this.address,
			stateProvince: this.stateProvince,
			cityRegency: this.cityRegency,
			regional: this.regional,
			hospitalClass: this.hospitalClass,
			inacbgTariff1: this.inacbgTariff1,
			inacbgTariff2: this.inacbgTariff2,
			additionalUpgradeVIP: this.additionalUpgradeVIP,
			payplanID: this.payplanID,
			paymentPlanCode: this.paymentPlanCode,
			tariffCode: this.tariffCode,
			url: this.url,
			username: this.username,
			password: this.password,
			secretKey: this.secretKey,
			coderID: this.coderID,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsINACBGModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsINACBGModel {
		let newModelJson = this.toJSON();

		if (updates.healthFacilityCode) {
			newModelJson.healthFacilityCode = updates.healthFacilityCode;
		}

		if (updates.healthFacilityName) {
			newModelJson.healthFacilityName = updates.healthFacilityName;
		}

		if (updates.address) {
			newModelJson.address = updates.address;
		}

		if (updates.stateProvince) {
			newModelJson.stateProvince = updates.stateProvince;
		}

		if (updates.cityRegency) {
			newModelJson.cityRegency = updates.cityRegency;
		}

		if (updates.regional) {
			newModelJson.regional = updates.regional;
		}

		if (updates.hospitalClass) {
			newModelJson.hospitalClass = updates.hospitalClass;
		}

		if (updates.inacbgTariff1) {
			newModelJson.inacbgTariff1 = updates.inacbgTariff1;
		}

		if (updates.inacbgTariff2) {
			newModelJson.inacbgTariff2 = updates.inacbgTariff2;
		}

		if (updates.additionalUpgradeVIP) {
			newModelJson.additionalUpgradeVIP = updates.additionalUpgradeVIP;
		}

		if (updates.payplanID) {
			newModelJson.payplanID = updates.payplanID;
		}

		if (updates.paymentPlanCode) {
			newModelJson.paymentPlanCode = updates.paymentPlanCode;
		}

		if (updates.tariffCode) {
			newModelJson.tariffCode = updates.tariffCode;
		}

		if (updates.url) {
			newModelJson.url = updates.url;
		}

		if (updates.username) {
			newModelJson.username = updates.username;
		}

		if (updates.password) {
			newModelJson.password = updates.password;
		}

		if (updates.secretKey) {
			newModelJson.secretKey = updates.secretKey;
		}

		if (updates.coderID) {
			newModelJson.coderID = updates.coderID;
		}

		return new BpjsINACBGModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsINACBGModel)) {
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
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
