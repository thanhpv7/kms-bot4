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
export class SatuSehatConfigurationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'secretKey',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'organizationID',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'SatuSehatConfigurationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return SatuSehatConfigurationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Organization ID.
	 */
	organizationID: string;

	/**
	 * Client ID.
	 */
	clientID: string;

	/**
	 * Secret Key.
	 */
	secretKey: string;

	/**
	 * Token.
	 */
	tokenRequest: string;

	/**
	 * Base URL Satu Sehat.
	 */
	baseURL: string;



	modelPropGroups: { [s: string]: Group } = SatuSehatConfigurationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'organizationID',
				// % protected region % [Set displayName for Organization ID here] off begin
				displayName: 'Organization ID',
				// % protected region % [Set displayName for Organization ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Organization ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Organization ID here] end
				// % protected region % [Set isSensitive for Organization ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Organization ID here] end
				// % protected region % [Set readonly for Organization ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Organization ID here] end
				validators: [
					// % protected region % [Add other validators for Organization ID here] off begin
					// % protected region % [Add other validators for Organization ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Organization ID here] off begin
				// % protected region % [Add any additional model attribute properties for Organization ID here] end
			},
			{
				name: 'clientID',
				// % protected region % [Set displayName for Client ID here] off begin
				displayName: 'Client ID',
				// % protected region % [Set displayName for Client ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Client ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Client ID here] end
				// % protected region % [Set isSensitive for Client ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Client ID here] end
				// % protected region % [Set readonly for Client ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Client ID here] end
				validators: [
					Validators.maxLength(1000),
					// % protected region % [Add other validators for Client ID here] off begin
					// % protected region % [Add other validators for Client ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Client ID here] off begin
				// % protected region % [Add any additional model attribute properties for Client ID here] end
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
					Validators.maxLength(1000),
					// % protected region % [Add other validators for Secret Key here] off begin
					// % protected region % [Add other validators for Secret Key here] end
				],
				// % protected region % [Add any additional model attribute properties for Secret Key here] off begin
				// % protected region % [Add any additional model attribute properties for Secret Key here] end
			},
			{
				name: 'tokenRequest',
				// % protected region % [Set displayName for Token Request here] off begin
				displayName: 'Token Request',
				// % protected region % [Set displayName for Token Request here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Token Request here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Token Request here] end
				// % protected region % [Set isSensitive for Token Request here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Token Request here] end
				// % protected region % [Set readonly for Token Request here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Token Request here] end
				validators: [
					Validators.maxLength(1000),
					// % protected region % [Add other validators for Token Request here] off begin
					// % protected region % [Add other validators for Token Request here] end
				],
				// % protected region % [Add any additional model attribute properties for Token Request here] off begin
				// % protected region % [Add any additional model attribute properties for Token Request here] end
			},
			{
				name: 'baseURL',
				// % protected region % [Set displayName for Base URL here] off begin
				displayName: 'Base URL',
				// % protected region % [Set displayName for Base URL here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Base URL here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Base URL here] end
				// % protected region % [Set isSensitive for Base URL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Base URL here] end
				// % protected region % [Set readonly for Base URL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Base URL here] end
				validators: [
					// % protected region % [Add other validators for Base URL here] off begin
					// % protected region % [Add other validators for Base URL here] end
				],
				// % protected region % [Add any additional model attribute properties for Base URL here] off begin
				// % protected region % [Add any additional model attribute properties for Base URL here] end
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
				case 'secretKey':
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
	static deepParse(data: string | { [K in keyof SatuSehatConfigurationModel]?: SatuSehatConfigurationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new SatuSehatConfigurationModel(data);
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
	 * `let satuSehatConfigurationModel = new SatuSehatConfigurationModel(data);`
	 *
	 * @param data The input data to be initialised as the SatuSehatConfigurationModel,
	 *    it is expected as a JSON string or as a nullable SatuSehatConfigurationModel.
	 */
	constructor(data?: string | Partial<SatuSehatConfigurationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<SatuSehatConfigurationModel>
				: data;

			this.organizationID = json.organizationID;
			this.clientID = json.clientID;
			this.secretKey = json.secretKey;
			this.tokenRequest = json.tokenRequest;
			this.baseURL = json.baseURL;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			organizationID: this.organizationID,
			clientID: this.clientID,
			secretKey: this.secretKey,
			tokenRequest: this.tokenRequest,
			baseURL: this.baseURL,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		SatuSehatConfigurationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): SatuSehatConfigurationModel {
		let newModelJson = this.toJSON();

		if (updates.organizationID) {
			newModelJson.organizationID = updates.organizationID;
		}

		if (updates.clientID) {
			newModelJson.clientID = updates.clientID;
		}

		if (updates.secretKey) {
			newModelJson.secretKey = updates.secretKey;
		}

		if (updates.tokenRequest) {
			newModelJson.tokenRequest = updates.tokenRequest;
		}

		if (updates.baseURL) {
			newModelJson.baseURL = updates.baseURL;
		}

		return new SatuSehatConfigurationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof SatuSehatConfigurationModel)) {
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
