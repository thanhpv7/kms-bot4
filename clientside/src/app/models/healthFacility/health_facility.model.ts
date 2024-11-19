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
export class HealthFacilityModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'healthFacilityID',
		'healthFacilityName',
		'phoneNumber',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'healthFacilityID',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'HealthFacilityModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return HealthFacilityModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	healthFacilityID: string;

	/**
	 * Health Facility Name (Max Length: 250).
	 */
	healthFacilityName: string;

	/**
	 * Address (Max Length: 500).
	 */
	address: string;

	/**
	 * City (Max Length: 250).
	 */
	city: string;

	/**
	 * Post Code.
	 */
	postCode: string;

	/**
	 * Province (Max Length: 250).
	 */
	province: string;

	/**
	 * Country (Max Length: 250).
	 */
	country: string;

	/**
	 * Phone Number (Max Length: 250).
	 */
	phoneNumber: string;

	/**
	 * Mobile Phone Number (Max Length: 250).
	 */
	mobilePhoneNumber: string;

	/**
	 * website address (Max Length: 250 chars).
	 */
	website: string;

	/**
	 * Email (Max Length: 250).
	 */
	email: string;

	/**
	 * Salutation (Max Length: 250).
	 */
	salutation: string;

	/**
	 * First Name (Max Length: 250).
	 */
	firstName: string;

	/**
	 * Last Name (Max Length: 250).
	 */
	lastName: string;

	/**
	 * Phone Number POC (Max Length: 250).
	 */
	phoneNumberPOC: string;

	/**
	 * Mobile Phone Number POC (Max Length: 250).
	 */
	mobilePhoneNumberPOC: string;

	/**
	 * Email POC (Max Length: 250).
	 */
	emailPOC: string;

	/**
	 * Health Facility Type, get the Code from Reference Data where Type=HEALTH_FAC_TYPE. (Max Length: 20).
	 */
	healthFacilityType: string;

	dismissalReferringFacilityIds: string[] = [];

	dismissalReferringFacility: RegistrationModel[];

	referringFacilityIds: string[] = [];

	referringFacility: RegistrationModel[];

	modelPropGroups: { [s: string]: Group } = HealthFacilityModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'healthFacilityID',
				// % protected region % [Set displayName for Health Facility ID here] off begin
				displayName: 'Health Facility ID',
				// % protected region % [Set displayName for Health Facility ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Health Facility ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Health Facility ID here] end
				// % protected region % [Set isSensitive for Health Facility ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Health Facility ID here] end
				// % protected region % [Set readonly for Health Facility ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Health Facility ID here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Health Facility ID here] off begin
					// % protected region % [Add other validators for Health Facility ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Health Facility ID here] off begin
				// % protected region % [Add any additional model attribute properties for Health Facility ID here] end
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
				name: 'city',
				// % protected region % [Set displayName for City here] off begin
				displayName: 'City',
				// % protected region % [Set displayName for City here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for City here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for City here] end
				// % protected region % [Set isSensitive for City here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for City here] end
				// % protected region % [Set readonly for City here] off begin
				readOnly: false,
				// % protected region % [Set readonly for City here] end
				validators: [
					// % protected region % [Add other validators for City here] off begin
					// % protected region % [Add other validators for City here] end
				],
				// % protected region % [Add any additional model attribute properties for City here] off begin
				// % protected region % [Add any additional model attribute properties for City here] end
			},
			{
				name: 'postCode',
				// % protected region % [Set displayName for Post Code here] off begin
				displayName: 'Post Code',
				// % protected region % [Set displayName for Post Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Post Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Post Code here] end
				// % protected region % [Set isSensitive for Post Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Post Code here] end
				// % protected region % [Set readonly for Post Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Post Code here] end
				validators: [
					// % protected region % [Add other validators for Post Code here] off begin
					// % protected region % [Add other validators for Post Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Post Code here] off begin
				// % protected region % [Add any additional model attribute properties for Post Code here] end
			},
			{
				name: 'province',
				// % protected region % [Set displayName for Province here] off begin
				displayName: 'Province',
				// % protected region % [Set displayName for Province here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Province here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Province here] end
				// % protected region % [Set isSensitive for Province here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Province here] end
				// % protected region % [Set readonly for Province here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Province here] end
				validators: [
					// % protected region % [Add other validators for Province here] off begin
					// % protected region % [Add other validators for Province here] end
				],
				// % protected region % [Add any additional model attribute properties for Province here] off begin
				// % protected region % [Add any additional model attribute properties for Province here] end
			},
			{
				name: 'country',
				// % protected region % [Set displayName for Country here] off begin
				displayName: 'Country',
				// % protected region % [Set displayName for Country here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Country here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Country here] end
				// % protected region % [Set isSensitive for Country here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Country here] end
				// % protected region % [Set readonly for Country here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Country here] end
				validators: [
					// % protected region % [Add other validators for Country here] off begin
					// % protected region % [Add other validators for Country here] end
				],
				// % protected region % [Add any additional model attribute properties for Country here] off begin
				// % protected region % [Add any additional model attribute properties for Country here] end
			},
			{
				name: 'phoneNumber',
				// % protected region % [Set displayName for Phone Number here] off begin
				displayName: 'Phone Number',
				// % protected region % [Set displayName for Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Phone Number here] end
				// % protected region % [Set isSensitive for Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Phone Number here] end
				// % protected region % [Set readonly for Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Phone Number here] end
				validators: [
					// % protected region % [Add other validators for Phone Number here] off begin
					// % protected region % [Add other validators for Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Phone Number here] end
			},
			{
				name: 'mobilePhoneNumber',
				// % protected region % [Set displayName for Mobile Phone Number here] off begin
				displayName: 'Mobile Phone Number',
				// % protected region % [Set displayName for Mobile Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Mobile Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Mobile Phone Number here] end
				// % protected region % [Set isSensitive for Mobile Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Mobile Phone Number here] end
				// % protected region % [Set readonly for Mobile Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Mobile Phone Number here] end
				validators: [
					// % protected region % [Add other validators for Mobile Phone Number here] off begin
					// % protected region % [Add other validators for Mobile Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Mobile Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Mobile Phone Number here] end
			},
			{
				name: 'website',
				// % protected region % [Set displayName for website here] off begin
				displayName: 'website',
				// % protected region % [Set displayName for website here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for website here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for website here] end
				// % protected region % [Set isSensitive for website here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for website here] end
				// % protected region % [Set readonly for website here] off begin
				readOnly: false,
				// % protected region % [Set readonly for website here] end
				validators: [
					// % protected region % [Add other validators for website here] off begin
					// % protected region % [Add other validators for website here] end
				],
				// % protected region % [Add any additional model attribute properties for website here] off begin
				// % protected region % [Add any additional model attribute properties for website here] end
			},
			{
				name: 'email',
				// % protected region % [Set displayName for Email here] off begin
				displayName: 'Email',
				// % protected region % [Set displayName for Email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Email here] end
				// % protected region % [Set isSensitive for Email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Email here] end
				// % protected region % [Set readonly for Email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Email here] end
				validators: [
					// % protected region % [Add other validators for Email here] off begin
					// % protected region % [Add other validators for Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Email here] off begin
				// % protected region % [Add any additional model attribute properties for Email here] end
			},
			{
				name: 'salutation',
				// % protected region % [Set displayName for Salutation here] off begin
				displayName: 'Salutation',
				// % protected region % [Set displayName for Salutation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Salutation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Salutation here] end
				// % protected region % [Set isSensitive for Salutation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Salutation here] end
				// % protected region % [Set readonly for Salutation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Salutation here] end
				validators: [
					// % protected region % [Add other validators for Salutation here] off begin
					// % protected region % [Add other validators for Salutation here] end
				],
				// % protected region % [Add any additional model attribute properties for Salutation here] off begin
				// % protected region % [Add any additional model attribute properties for Salutation here] end
			},
			{
				name: 'firstName',
				// % protected region % [Set displayName for First Name here] off begin
				displayName: 'First Name',
				// % protected region % [Set displayName for First Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for First Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for First Name here] end
				// % protected region % [Set isSensitive for First Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for First Name here] end
				// % protected region % [Set readonly for First Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for First Name here] end
				validators: [
					// % protected region % [Add other validators for First Name here] off begin
					// % protected region % [Add other validators for First Name here] end
				],
				// % protected region % [Add any additional model attribute properties for First Name here] off begin
				// % protected region % [Add any additional model attribute properties for First Name here] end
			},
			{
				name: 'lastName',
				// % protected region % [Set displayName for Last Name here] off begin
				displayName: 'Last Name',
				// % protected region % [Set displayName for Last Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Last Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Last Name here] end
				// % protected region % [Set isSensitive for Last Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Name here] end
				// % protected region % [Set readonly for Last Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Name here] end
				validators: [
					// % protected region % [Add other validators for Last Name here] off begin
					// % protected region % [Add other validators for Last Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Name here] off begin
				// % protected region % [Add any additional model attribute properties for Last Name here] end
			},
			{
				name: 'phoneNumberPOC',
				// % protected region % [Set displayName for Phone Number POC here] off begin
				displayName: 'Phone Number POC',
				// % protected region % [Set displayName for Phone Number POC here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Phone Number POC here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Phone Number POC here] end
				// % protected region % [Set isSensitive for Phone Number POC here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Phone Number POC here] end
				// % protected region % [Set readonly for Phone Number POC here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Phone Number POC here] end
				validators: [
					// % protected region % [Add other validators for Phone Number POC here] off begin
					// % protected region % [Add other validators for Phone Number POC here] end
				],
				// % protected region % [Add any additional model attribute properties for Phone Number POC here] off begin
				// % protected region % [Add any additional model attribute properties for Phone Number POC here] end
			},
			{
				name: 'mobilePhoneNumberPOC',
				// % protected region % [Set displayName for Mobile Phone Number POC here] off begin
				displayName: 'Mobile Phone Number POC',
				// % protected region % [Set displayName for Mobile Phone Number POC here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Mobile Phone Number POC here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Mobile Phone Number POC here] end
				// % protected region % [Set isSensitive for Mobile Phone Number POC here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Mobile Phone Number POC here] end
				// % protected region % [Set readonly for Mobile Phone Number POC here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Mobile Phone Number POC here] end
				validators: [
					// % protected region % [Add other validators for Mobile Phone Number POC here] off begin
					// % protected region % [Add other validators for Mobile Phone Number POC here] end
				],
				// % protected region % [Add any additional model attribute properties for Mobile Phone Number POC here] off begin
				// % protected region % [Add any additional model attribute properties for Mobile Phone Number POC here] end
			},
			{
				name: 'emailPOC',
				// % protected region % [Set displayName for Email POC here] off begin
				displayName: 'Email POC',
				// % protected region % [Set displayName for Email POC here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Email POC here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Email POC here] end
				// % protected region % [Set isSensitive for Email POC here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Email POC here] end
				// % protected region % [Set readonly for Email POC here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Email POC here] end
				validators: [
					// % protected region % [Add other validators for Email POC here] off begin
					// % protected region % [Add other validators for Email POC here] end
				],
				// % protected region % [Add any additional model attribute properties for Email POC here] off begin
				// % protected region % [Add any additional model attribute properties for Email POC here] end
			},
			{
				name: 'healthFacilityType',
				// % protected region % [Set displayName for Health Facility Type here] off begin
				displayName: 'Health Facility Type',
				// % protected region % [Set displayName for Health Facility Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Health Facility Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Health Facility Type here] end
				// % protected region % [Set isSensitive for Health Facility Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Health Facility Type here] end
				// % protected region % [Set readonly for Health Facility Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Health Facility Type here] end
				validators: [
					// % protected region % [Add other validators for Health Facility Type here] off begin
					// % protected region % [Add other validators for Health Facility Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Health Facility Type here] off begin
				// % protected region % [Add any additional model attribute properties for Health Facility Type here] end
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
				id: 'dismissalReferringFacility',
				type: ModelRelationType.MANY,
				name: 'dismissalReferringFacilityIds',
				// % protected region % [Customise your 1-1 or 1-M label for Dismissal Referring Facility here] off begin
				label: 'Dismissal Referring Facility',
				// % protected region % [Customise your 1-1 or 1-M label for Dismissal Referring Facility here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Dismissal Referring Facility here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Dismissal Referring Facility here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Referring Facility here] off begin
					// % protected region % [Add other validators for Dismissal Referring Facility here] end
				],
				// % protected region % [Add any additional field for relation Dismissal Referring Facility here] off begin
				// % protected region % [Add any additional field for relation Dismissal Referring Facility here] end
			},
			{
				id: 'referringFacility',
				type: ModelRelationType.MANY,
				name: 'referringFacilityIds',
				// % protected region % [Customise your 1-1 or 1-M label for Referring facility here] off begin
				label: 'Referring facility',
				// % protected region % [Customise your 1-1 or 1-M label for Referring facility here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Referring facility here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Referring facility here] end
				validators: [
					// % protected region % [Add other validators for Referring facility here] off begin
					// % protected region % [Add other validators for Referring facility here] end
				],
				// % protected region % [Add any additional field for relation Referring facility here] off begin
				// % protected region % [Add any additional field for relation Referring facility here] end
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
				case 'healthFacilityID':
					break;
				case 'healthFacilityName':
					break;
				case 'phoneNumber':
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
	static deepParse(data: string | { [K in keyof HealthFacilityModel]?: HealthFacilityModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new HealthFacilityModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.dismissalReferringFacility) {
			currentModel.dismissalReferringFacilityIds = json.dismissalReferringFacility.map(model => model.id);
			returned = _.union(returned, _.flatten(json.dismissalReferringFacility.map(model => RegistrationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.referringFacility) {
			currentModel.referringFacilityIds = json.referringFacility.map(model => model.id);
			returned = _.union(returned, _.flatten(json.referringFacility.map(model => RegistrationModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let healthFacilityModel = new HealthFacilityModel(data);`
	 *
	 * @param data The input data to be initialised as the HealthFacilityModel,
	 *    it is expected as a JSON string or as a nullable HealthFacilityModel.
	 */
	constructor(data?: string | Partial<HealthFacilityModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<HealthFacilityModel>
				: data;

			this.healthFacilityID = json.healthFacilityID;
			this.healthFacilityName = json.healthFacilityName;
			this.address = json.address;
			this.city = json.city;
			this.postCode = json.postCode;
			this.province = json.province;
			this.country = json.country;
			this.phoneNumber = json.phoneNumber;
			this.mobilePhoneNumber = json.mobilePhoneNumber;
			this.website = json.website;
			this.email = json.email;
			this.salutation = json.salutation;
			this.firstName = json.firstName;
			this.lastName = json.lastName;
			this.phoneNumberPOC = json.phoneNumberPOC;
			this.mobilePhoneNumberPOC = json.mobilePhoneNumberPOC;
			this.emailPOC = json.emailPOC;
			this.healthFacilityType = json.healthFacilityType;
			this.dismissalReferringFacilityIds = json.dismissalReferringFacilityIds;
			this.dismissalReferringFacility = json.dismissalReferringFacility;
			this.referringFacilityIds = json.referringFacilityIds;
			this.referringFacility = json.referringFacility;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			healthFacilityID: this.healthFacilityID,
			healthFacilityName: this.healthFacilityName,
			address: this.address,
			city: this.city,
			postCode: this.postCode,
			province: this.province,
			country: this.country,
			phoneNumber: this.phoneNumber,
			mobilePhoneNumber: this.mobilePhoneNumber,
			website: this.website,
			email: this.email,
			salutation: this.salutation,
			firstName: this.firstName,
			lastName: this.lastName,
			phoneNumberPOC: this.phoneNumberPOC,
			mobilePhoneNumberPOC: this.mobilePhoneNumberPOC,
			emailPOC: this.emailPOC,
			healthFacilityType: this.healthFacilityType,
			dismissalReferringFacilityIds: this.dismissalReferringFacilityIds,
			referringFacilityIds: this.referringFacilityIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		HealthFacilityModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): HealthFacilityModel {
		let newModelJson = this.toJSON();

		if (updates.healthFacilityID) {
			newModelJson.healthFacilityID = updates.healthFacilityID;
		}

		if (updates.healthFacilityName) {
			newModelJson.healthFacilityName = updates.healthFacilityName;
		}

		if (updates.address) {
			newModelJson.address = updates.address;
		}

		if (updates.city) {
			newModelJson.city = updates.city;
		}

		if (updates.postCode) {
			newModelJson.postCode = updates.postCode;
		}

		if (updates.province) {
			newModelJson.province = updates.province;
		}

		if (updates.country) {
			newModelJson.country = updates.country;
		}

		if (updates.phoneNumber) {
			newModelJson.phoneNumber = updates.phoneNumber;
		}

		if (updates.mobilePhoneNumber) {
			newModelJson.mobilePhoneNumber = updates.mobilePhoneNumber;
		}

		if (updates.website) {
			newModelJson.website = updates.website;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.salutation) {
			newModelJson.salutation = updates.salutation;
		}

		if (updates.firstName) {
			newModelJson.firstName = updates.firstName;
		}

		if (updates.lastName) {
			newModelJson.lastName = updates.lastName;
		}

		if (updates.phoneNumberPOC) {
			newModelJson.phoneNumberPOC = updates.phoneNumberPOC;
		}

		if (updates.mobilePhoneNumberPOC) {
			newModelJson.mobilePhoneNumberPOC = updates.mobilePhoneNumberPOC;
		}

		if (updates.emailPOC) {
			newModelJson.emailPOC = updates.emailPOC;
		}

		if (updates.healthFacilityType) {
			newModelJson.healthFacilityType = updates.healthFacilityType;
		}

		if (updates.dismissalReferringFacilityIds) {
			newModelJson.dismissalReferringFacilityIds = updates.dismissalReferringFacilityIds;
		}

		if (updates.referringFacilityIds) {
			newModelJson.referringFacilityIds = updates.referringFacilityIds;
		}

		return new HealthFacilityModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof HealthFacilityModel)) {
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
			'dismissalReferringFacilityIds',
			'dismissalReferringFacility',
			'referringFacilityIds',
			'referringFacility',
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
