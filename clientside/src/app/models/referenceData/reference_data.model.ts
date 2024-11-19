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
export class ReferenceDataModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'referenceType',
		'code',
		'description',
		'associatedValues',
		'filter',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'referenceType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ReferenceDataModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ReferenceDataModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Reference type from Reference Header - Type.
	 */
	referenceType: string;

	/**
	 * Alpha numeric code. The value of this field is saved in the entity field which refers to it..
	 */
	code: string;

	/**
	 * Multi-language description in JSON format..
	 */
	description: string;

	/**
	 * Associated values in JSON format. This is an additional configuration related to the reference code..
	 */
	associatedValues: string;

	/**
	 * The order of lookup display  within the same Type. .
	 */
	sequence: number;

	/**
	 * It is used to filter the data based on external reference.
	 */
	filter: string;



	modelPropGroups: { [s: string]: Group } = ReferenceDataModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'referenceType',
				// % protected region % [Set displayName for Reference Type here] off begin
				displayName: 'Reference Type',
				// % protected region % [Set displayName for Reference Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Reference Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Reference Type here] end
				// % protected region % [Set isSensitive for Reference Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reference Type here] end
				// % protected region % [Set readonly for Reference Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reference Type here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Reference Type here] off begin
					// % protected region % [Add other validators for Reference Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Reference Type here] off begin
				// % protected region % [Add any additional model attribute properties for Reference Type here] end
			},
			{
				name: 'code',
				// % protected region % [Set displayName for Code here] off begin
				displayName: 'Code',
				// % protected region % [Set displayName for Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Code here] end
				// % protected region % [Set isSensitive for Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Code here] end
				// % protected region % [Set readonly for Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Code here] off begin
					// % protected region % [Add other validators for Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Code here] off begin
				// % protected region % [Add any additional model attribute properties for Code here] end
			},
			{
				name: 'description',
				// % protected region % [Set displayName for Description here] off begin
				displayName: 'Description',
				// % protected region % [Set displayName for Description here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Description here] off begin
				elementType: ElementType.TEXTAREA,
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
				name: 'associatedValues',
				// % protected region % [Set displayName for Associated Values here] off begin
				displayName: 'Associated Values',
				// % protected region % [Set displayName for Associated Values here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Associated Values here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Associated Values here] end
				// % protected region % [Set isSensitive for Associated Values here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Associated Values here] end
				// % protected region % [Set readonly for Associated Values here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Associated Values here] end
				validators: [
					// % protected region % [Add other validators for Associated Values here] off begin
					// % protected region % [Add other validators for Associated Values here] end
				],
				// % protected region % [Add any additional model attribute properties for Associated Values here] off begin
				// % protected region % [Add any additional model attribute properties for Associated Values here] end
			},
			{
				name: 'sequence',
				// % protected region % [Set displayName for Sequence here] off begin
				displayName: 'Sequence',
				// % protected region % [Set displayName for Sequence here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Sequence here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Sequence here] end
				// % protected region % [Set isSensitive for Sequence here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sequence here] end
				// % protected region % [Set readonly for Sequence here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sequence here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Sequence here] off begin
					// % protected region % [Add other validators for Sequence here] end
				],
				// % protected region % [Add any additional model attribute properties for Sequence here] off begin
				// % protected region % [Add any additional model attribute properties for Sequence here] end
			},
			{
				name: 'filter',
				// % protected region % [Set displayName for Filter here] off begin
				displayName: 'Filter',
				// % protected region % [Set displayName for Filter here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Filter here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Filter here] end
				// % protected region % [Set isSensitive for Filter here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Filter here] end
				// % protected region % [Set readonly for Filter here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Filter here] end
				validators: [
					// % protected region % [Add other validators for Filter here] off begin
					// % protected region % [Add other validators for Filter here] end
				],
				// % protected region % [Add any additional model attribute properties for Filter here] off begin
				// % protected region % [Add any additional model attribute properties for Filter here] end
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
				case 'referenceType':
					break;
				case 'code':
					break;
				case 'description':
					break;
				case 'associatedValues':
					break;
				case 'filter':
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
	static deepParse(data: string | { [K in keyof ReferenceDataModel]?: ReferenceDataModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ReferenceDataModel(data);
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
	 * `let referenceDataModel = new ReferenceDataModel(data);`
	 *
	 * @param data The input data to be initialised as the ReferenceDataModel,
	 *    it is expected as a JSON string or as a nullable ReferenceDataModel.
	 */
	constructor(data?: string | Partial<ReferenceDataModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ReferenceDataModel>
				: data;

			this.referenceType = json.referenceType;
			this.code = json.code;
			this.description = json.description;
			this.associatedValues = json.associatedValues;
			this.sequence = json.sequence;
			this.filter = json.filter;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			referenceType: this.referenceType,
			code: this.code,
			description: this.description,
			associatedValues: this.associatedValues,
			sequence: this.sequence,
			filter: this.filter,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ReferenceDataModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ReferenceDataModel {
		let newModelJson = this.toJSON();

		if (updates.referenceType) {
			newModelJson.referenceType = updates.referenceType;
		}

		if (updates.code) {
			newModelJson.code = updates.code;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.associatedValues) {
			newModelJson.associatedValues = updates.associatedValues;
		}

		if (updates.sequence) {
			newModelJson.sequence = updates.sequence;
		}

		if (updates.filter) {
			newModelJson.filter = updates.filter;
		}

		return new ReferenceDataModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ReferenceDataModel)) {
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
