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
import {InsuranceBenefitPlanModel} from '../insuranceBenefitPlan/insurance_benefit_plan.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class InsuranceProviderModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'providerCode',
		'providerName',
		'providerType',
		'benefitProvider',
		'expiryDate',
		'expiringDate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'providerCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InsuranceProviderModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InsuranceProviderModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Provider/Insurance Number (Max Length: 50).
	 */
	providerCode: string;

	/**
	 * Provider/Insurance Name (Max Length: 250).
	 */
	providerName: string;

	/**
	 * Provider Type,  get the Code from Reference Data where Type=PROVIDER_TYPE. (Max Length: 20).
	 */
	providerType: string;

	/**
	 * Benefit Provider,  get the Code from Reference Data where Type=BENEFIT_PROVIDER. (Max Length: 20).
	 */
	benefitProvider: string;

	/**
	 * First Name of Contact (Max Length: 250).
	 */
	firstName: string;

	/**
	 * Last Name of Contact (Max Length: 250).
	 */
	lastName: string;

	/**
	 * Phone Number of Contact (Max Length: 50).
	 */
	phoneNumber: string;

	/**
	 * Mobile Phone Number of Contact (Max Length: 50)).
	 */
	mobilePhoneNumber: string;

	/**
	 * Email of Contact (Max Length: 250).
	 */
	email: string;

	/**
	 * Expiry Date of Health Insurance Provider.
	 */
	expiryDate: Date;

	/**
	 * Expiring Date of Health Insurance Provider.
	 */
	expiringDate: Date;

	/**
	 * Created Date of Health Insurance Provider.
	 */
	createdDate: Date;

	/**
	 * Detail of Health Insurance Provider information (Max Length: 500).
	 */
	notes: string;

	insuranceBenefitPlansIds: string[] = [];

	insuranceBenefitPlans: InsuranceBenefitPlanModel[];

	modelPropGroups: { [s: string]: Group } = InsuranceProviderModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'providerCode',
				// % protected region % [Set displayName for Provider Code here] off begin
				displayName: 'Provider Code',
				// % protected region % [Set displayName for Provider Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Provider Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Provider Code here] end
				// % protected region % [Set isSensitive for Provider Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Provider Code here] end
				// % protected region % [Set readonly for Provider Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Provider Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Provider Code here] off begin
					// % protected region % [Add other validators for Provider Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Provider Code here] off begin
				// % protected region % [Add any additional model attribute properties for Provider Code here] end
			},
			{
				name: 'providerName',
				// % protected region % [Set displayName for Provider Name here] off begin
				displayName: 'Provider Name',
				// % protected region % [Set displayName for Provider Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Provider Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Provider Name here] end
				// % protected region % [Set isSensitive for Provider Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Provider Name here] end
				// % protected region % [Set readonly for Provider Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Provider Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Provider Name here] off begin
					// % protected region % [Add other validators for Provider Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Provider Name here] off begin
				// % protected region % [Add any additional model attribute properties for Provider Name here] end
			},
			{
				name: 'providerType',
				// % protected region % [Set displayName for Provider Type here] off begin
				displayName: 'Provider Type',
				// % protected region % [Set displayName for Provider Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Provider Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Provider Type here] end
				// % protected region % [Set isSensitive for Provider Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Provider Type here] end
				// % protected region % [Set readonly for Provider Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Provider Type here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Provider Type here] off begin
					// % protected region % [Add other validators for Provider Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Provider Type here] off begin
				// % protected region % [Add any additional model attribute properties for Provider Type here] end
			},
			{
				name: 'benefitProvider',
				// % protected region % [Set displayName for Benefit Provider here] off begin
				displayName: 'Benefit Provider',
				// % protected region % [Set displayName for Benefit Provider here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Benefit Provider here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Benefit Provider here] end
				// % protected region % [Set isSensitive for Benefit Provider here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Benefit Provider here] end
				// % protected region % [Set readonly for Benefit Provider here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Benefit Provider here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Benefit Provider here] off begin
					// % protected region % [Add other validators for Benefit Provider here] end
				],
				// % protected region % [Add any additional model attribute properties for Benefit Provider here] off begin
				// % protected region % [Add any additional model attribute properties for Benefit Provider here] end
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
					Validators.required,
					CustomValidators.nonEmptyString(),
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
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Last Name here] off begin
					// % protected region % [Add other validators for Last Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Name here] off begin
				// % protected region % [Add any additional model attribute properties for Last Name here] end
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
				name: 'expiryDate',
				// % protected region % [Set displayName for Expiry Date here] off begin
				displayName: 'Expiry Date',
				// % protected region % [Set displayName for Expiry Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Expiry Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Expiry Date here] end
				// % protected region % [Set isSensitive for Expiry Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Expiry Date here] end
				// % protected region % [Set readonly for Expiry Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Expiry Date here] end
				validators: [
					// % protected region % [Add other validators for Expiry Date here] off begin
					// % protected region % [Add other validators for Expiry Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Expiry Date here] off begin
				// % protected region % [Add any additional model attribute properties for Expiry Date here] end
			},
			{
				name: 'expiringDate',
				// % protected region % [Set displayName for Expiring Date here] off begin
				displayName: 'Expiring Date',
				// % protected region % [Set displayName for Expiring Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Expiring Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Expiring Date here] end
				// % protected region % [Set isSensitive for Expiring Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Expiring Date here] end
				// % protected region % [Set readonly for Expiring Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Expiring Date here] end
				validators: [
					// % protected region % [Add other validators for Expiring Date here] off begin
					// % protected region % [Add other validators for Expiring Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Expiring Date here] off begin
				// % protected region % [Add any additional model attribute properties for Expiring Date here] end
			},
			{
				name: 'createdDate',
				// % protected region % [Set displayName for Created Date here] off begin
				displayName: 'Created Date',
				// % protected region % [Set displayName for Created Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Created Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Created Date here] end
				// % protected region % [Set isSensitive for Created Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Created Date here] end
				// % protected region % [Set readonly for Created Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Created Date here] end
				validators: [
					// % protected region % [Add other validators for Created Date here] off begin
					// % protected region % [Add other validators for Created Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Created Date here] off begin
				// % protected region % [Add any additional model attribute properties for Created Date here] end
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
				id: 'insuranceBenefitPlans',
				type: ModelRelationType.MANY,
				name: 'insuranceBenefitPlansIds',
				// % protected region % [Customise your 1-1 or 1-M label for Insurance Benefit Plans here] off begin
				label: 'Insurance Benefit Plans',
				// % protected region % [Customise your 1-1 or 1-M label for Insurance Benefit Plans here] end
				entityName: 'InsuranceBenefitPlanModel',
				// % protected region % [Customise your display name for Insurance Benefit Plans here] off begin
				displayName: 'benefitPlanNo',
				// % protected region % [Customise your display name for Insurance Benefit Plans here] end
				validators: [
					// % protected region % [Add other validators for Insurance Benefit Plans here] off begin
					// % protected region % [Add other validators for Insurance Benefit Plans here] end
				],
				// % protected region % [Add any additional field for relation Insurance Benefit Plans here] off begin
				// % protected region % [Add any additional field for relation Insurance Benefit Plans here] end
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
				case 'providerCode':
					break;
				case 'providerName':
					break;
				case 'providerType':
					break;
				case 'benefitProvider':
					break;
				case 'expiryDate':
					break;
				case 'expiringDate':
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
	static deepParse(data: string | { [K in keyof InsuranceProviderModel]?: InsuranceProviderModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InsuranceProviderModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.insuranceBenefitPlans) {
			currentModel.insuranceBenefitPlansIds = json.insuranceBenefitPlans.map(model => model.id);
			returned = _.union(returned, _.flatten(json.insuranceBenefitPlans.map(model => InsuranceBenefitPlanModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let insuranceProviderModel = new InsuranceProviderModel(data);`
	 *
	 * @param data The input data to be initialised as the InsuranceProviderModel,
	 *    it is expected as a JSON string or as a nullable InsuranceProviderModel.
	 */
	constructor(data?: string | Partial<InsuranceProviderModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InsuranceProviderModel>
				: data;

			this.providerCode = json.providerCode;
			this.providerName = json.providerName;
			this.providerType = json.providerType;
			this.benefitProvider = json.benefitProvider;
			this.firstName = json.firstName;
			this.lastName = json.lastName;
			this.phoneNumber = json.phoneNumber;
			this.mobilePhoneNumber = json.mobilePhoneNumber;
			this.email = json.email;
			if (json.expiryDate) {
				this.expiryDate = new Date(json.expiryDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.expiryDate = json.expiryDate;
			}
			if (json.expiringDate) {
				this.expiringDate = new Date(json.expiringDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.expiringDate = json.expiringDate;
			}
			if (json.createdDate) {
				this.createdDate = new Date(json.createdDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.createdDate = json.createdDate;
			}
			this.notes = json.notes;
			this.insuranceBenefitPlansIds = json.insuranceBenefitPlansIds;
			this.insuranceBenefitPlans = json.insuranceBenefitPlans;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			providerCode: this.providerCode,
			providerName: this.providerName,
			providerType: this.providerType,
			benefitProvider: this.benefitProvider,
			firstName: this.firstName,
			lastName: this.lastName,
			phoneNumber: this.phoneNumber,
			mobilePhoneNumber: this.mobilePhoneNumber,
			email: this.email,
			expiryDate: this.expiryDate,
			expiringDate: this.expiringDate,
			createdDate: this.createdDate,
			notes: this.notes,
			insuranceBenefitPlansIds: this.insuranceBenefitPlansIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InsuranceProviderModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InsuranceProviderModel {
		let newModelJson = this.toJSON();

		if (updates.providerCode) {
			newModelJson.providerCode = updates.providerCode;
		}

		if (updates.providerName) {
			newModelJson.providerName = updates.providerName;
		}

		if (updates.providerType) {
			newModelJson.providerType = updates.providerType;
		}

		if (updates.benefitProvider) {
			newModelJson.benefitProvider = updates.benefitProvider;
		}

		if (updates.firstName) {
			newModelJson.firstName = updates.firstName;
		}

		if (updates.lastName) {
			newModelJson.lastName = updates.lastName;
		}

		if (updates.phoneNumber) {
			newModelJson.phoneNumber = updates.phoneNumber;
		}

		if (updates.mobilePhoneNumber) {
			newModelJson.mobilePhoneNumber = updates.mobilePhoneNumber;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.expiryDate) {
			newModelJson.expiryDate = updates.expiryDate;
		}

		if (updates.expiringDate) {
			newModelJson.expiringDate = updates.expiringDate;
		}

		if (updates.createdDate) {
			newModelJson.createdDate = updates.createdDate;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.insuranceBenefitPlansIds) {
			newModelJson.insuranceBenefitPlansIds = updates.insuranceBenefitPlansIds;
		}

		return new InsuranceProviderModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InsuranceProviderModel)) {
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
			'insuranceBenefitPlansIds',
			'insuranceBenefitPlans',
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
