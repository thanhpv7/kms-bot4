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
import {DateFormatEnum, dateFormatEnumArray} from '../../enums/date-format.enum';
import {NumberingTypeEnum, numberingTypeEnumArray} from '../../enums/numbering-type.enum';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class NumberingSetupModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'numberingType',
		'lastCounter',
		'counterLength',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'numberingType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'NumberingSetupModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return NumberingSetupModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Prefix (max length: 5).
	 */
	prefix: string;

	/**
	 * Sufix (max length: 50).
	 */
	sufix: string;

	/**
	 * Last Counter, start with 0.
	 */
	lastCounter: number;

	/**
	 * .
	 */
	editable: boolean = false;

	/**
	 * A flag to indicate whether the counter will be reset per-day.
	 */
	resetPerDay: boolean = false;

	/**
	 * .
	 */
	counterLength: number;

	/**
	 * Last updated date when used to generate a new number.
	 */
	lastUpdated: Date;

	/**
	 * .
	 */
	preview: string;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=4, example=Sally}.
	 */
	dateFormat: DateFormatEnum;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=2, example=Sally}.
	 */
	numberingType: NumberingTypeEnum;



	modelPropGroups: { [s: string]: Group } = NumberingSetupModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'numberingType',
				// % protected region % [Set displayName for Numbering Type here] off begin
				displayName: 'Numbering Type',
				// % protected region % [Set displayName for Numbering Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: numberingTypeEnumArray,
				// % protected region % [Set display element type for Numbering Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Numbering Type here] end
				// % protected region % [Set isSensitive for Numbering Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Numbering Type here] end
				// % protected region % [Set readonly for Numbering Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Numbering Type here] end
				validators: [
					// % protected region % [Add other validators for Numbering Type here] off begin
					// % protected region % [Add other validators for Numbering Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Numbering Type here] off begin
				// % protected region % [Add any additional model attribute properties for Numbering Type here] end
			},
			{
				name: 'prefix',
				// % protected region % [Set displayName for Prefix here] off begin
				displayName: 'Prefix',
				// % protected region % [Set displayName for Prefix here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Prefix here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Prefix here] end
				// % protected region % [Set isSensitive for Prefix here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Prefix here] end
				// % protected region % [Set readonly for Prefix here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Prefix here] end
				validators: [
					// % protected region % [Add other validators for Prefix here] off begin
					// % protected region % [Add other validators for Prefix here] end
				],
				// % protected region % [Add any additional model attribute properties for Prefix here] off begin
				// % protected region % [Add any additional model attribute properties for Prefix here] end
			},
			{
				name: 'dateFormat',
				// % protected region % [Set displayName for Date Format here] off begin
				displayName: 'Date Format',
				// % protected region % [Set displayName for Date Format here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: dateFormatEnumArray,
				// % protected region % [Set display element type for Date Format here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Date Format here] end
				// % protected region % [Set isSensitive for Date Format here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date Format here] end
				// % protected region % [Set readonly for Date Format here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date Format here] end
				validators: [
					// % protected region % [Add other validators for Date Format here] off begin
					// % protected region % [Add other validators for Date Format here] end
				],
				// % protected region % [Add any additional model attribute properties for Date Format here] off begin
				// % protected region % [Add any additional model attribute properties for Date Format here] end
			},
			{
				name: 'sufix',
				// % protected region % [Set displayName for Sufix here] off begin
				displayName: 'Sufix',
				// % protected region % [Set displayName for Sufix here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sufix here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sufix here] end
				// % protected region % [Set isSensitive for Sufix here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sufix here] end
				// % protected region % [Set readonly for Sufix here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sufix here] end
				validators: [
					// % protected region % [Add other validators for Sufix here] off begin
					// % protected region % [Add other validators for Sufix here] end
				],
				// % protected region % [Add any additional model attribute properties for Sufix here] off begin
				// % protected region % [Add any additional model attribute properties for Sufix here] end
			},
			{
				name: 'lastCounter',
				// % protected region % [Set displayName for Last Counter here] off begin
				displayName: 'Last Counter',
				// % protected region % [Set displayName for Last Counter here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Last Counter here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Last Counter here] end
				// % protected region % [Set isSensitive for Last Counter here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Counter here] end
				// % protected region % [Set readonly for Last Counter here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Counter here] end
				validators: [
					// % protected region % [Add other validators for Last Counter here] off begin
					// % protected region % [Add other validators for Last Counter here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Counter here] off begin
				// % protected region % [Add any additional model attribute properties for Last Counter here] end
			},
			{
				name: 'editable',
				// % protected region % [Set displayName for Editable here] off begin
				displayName: 'Editable',
				// % protected region % [Set displayName for Editable here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Editable here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Editable here] end
				// % protected region % [Set isSensitive for Editable here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Editable here] end
				// % protected region % [Set readonly for Editable here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Editable here] end
				validators: [
					// % protected region % [Add other validators for Editable here] off begin
					// % protected region % [Add other validators for Editable here] end
				],
				// % protected region % [Add any additional model attribute properties for Editable here] off begin
				// % protected region % [Add any additional model attribute properties for Editable here] end
			},
			{
				name: 'resetPerDay',
				// % protected region % [Set displayName for Reset per Day here] off begin
				displayName: 'Reset per Day',
				// % protected region % [Set displayName for Reset per Day here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Reset per Day here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Reset per Day here] end
				// % protected region % [Set isSensitive for Reset per Day here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reset per Day here] end
				// % protected region % [Set readonly for Reset per Day here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reset per Day here] end
				validators: [
					// % protected region % [Add other validators for Reset per Day here] off begin
					// % protected region % [Add other validators for Reset per Day here] end
				],
				// % protected region % [Add any additional model attribute properties for Reset per Day here] off begin
				// % protected region % [Add any additional model attribute properties for Reset per Day here] end
			},
			{
				name: 'counterLength',
				// % protected region % [Set displayName for Counter Length here] off begin
				displayName: 'Counter Length',
				// % protected region % [Set displayName for Counter Length here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Counter Length here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Counter Length here] end
				// % protected region % [Set isSensitive for Counter Length here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Counter Length here] end
				// % protected region % [Set readonly for Counter Length here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Counter Length here] end
				validators: [
					// % protected region % [Add other validators for Counter Length here] off begin
					// % protected region % [Add other validators for Counter Length here] end
				],
				// % protected region % [Add any additional model attribute properties for Counter Length here] off begin
				// % protected region % [Add any additional model attribute properties for Counter Length here] end
			},
			{
				name: 'lastUpdated',
				// % protected region % [Set displayName for Last Updated here] off begin
				displayName: 'Last Updated',
				// % protected region % [Set displayName for Last Updated here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Last Updated here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Last Updated here] end
				// % protected region % [Set isSensitive for Last Updated here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Updated here] end
				// % protected region % [Set readonly for Last Updated here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Updated here] end
				validators: [
					// % protected region % [Add other validators for Last Updated here] off begin
					// % protected region % [Add other validators for Last Updated here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Updated here] off begin
				// % protected region % [Add any additional model attribute properties for Last Updated here] end
			},
			{
				name: 'preview',
				// % protected region % [Set displayName for Preview here] off begin
				displayName: 'Preview',
				// % protected region % [Set displayName for Preview here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Preview here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Preview here] end
				// % protected region % [Set isSensitive for Preview here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Preview here] end
				// % protected region % [Set readonly for Preview here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Preview here] end
				validators: [
					// % protected region % [Add other validators for Preview here] off begin
					// % protected region % [Add other validators for Preview here] end
				],
				// % protected region % [Add any additional model attribute properties for Preview here] off begin
				// % protected region % [Add any additional model attribute properties for Preview here] end
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
				case 'numberingType':
					conditions.push([
						{
							path: key,
							operation: QueryOperation.EQUAL,
							value: formGroup.value[key],
						}
					]);
					break;
				case 'lastCounter':
					break;
				case 'counterLength':
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
	static deepParse(data: string | { [K in keyof NumberingSetupModel]?: NumberingSetupModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new NumberingSetupModel(data);
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
	 * `let numberingSetupModel = new NumberingSetupModel(data);`
	 *
	 * @param data The input data to be initialised as the NumberingSetupModel,
	 *    it is expected as a JSON string or as a nullable NumberingSetupModel.
	 */
	constructor(data?: string | Partial<NumberingSetupModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<NumberingSetupModel>
				: data;

			this.numberingType = json.numberingType;
			this.prefix = json.prefix;
			this.dateFormat = json.dateFormat;
			this.sufix = json.sufix;
			this.lastCounter = json.lastCounter;
			this.editable = json.editable;
			this.resetPerDay = json.resetPerDay;
			this.counterLength = json.counterLength;
			if (json.lastUpdated) {
				this.lastUpdated = new Date(json.lastUpdated);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.lastUpdated = json.lastUpdated;
			}
			this.preview = json.preview;
			this.dateFormat = json.dateFormat;
			this.numberingType = json.numberingType;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			numberingType: this.numberingType,
			prefix: this.prefix,
			dateFormat: this.dateFormat,
			sufix: this.sufix,
			lastCounter: this.lastCounter,
			editable: this.editable,
			resetPerDay: this.resetPerDay,
			counterLength: this.counterLength,
			lastUpdated: this.lastUpdated,
			preview: this.preview,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		NumberingSetupModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): NumberingSetupModel {
		let newModelJson = this.toJSON();

		if (updates.numberingType) {
			newModelJson.numberingType = updates.numberingType;
		}

		if (updates.prefix) {
			newModelJson.prefix = updates.prefix;
		}

		if (updates.dateFormat) {
			newModelJson.dateFormat = updates.dateFormat;
		}

		if (updates.sufix) {
			newModelJson.sufix = updates.sufix;
		}

		if (updates.lastCounter) {
			newModelJson.lastCounter = updates.lastCounter;
		}

		if (updates.editable) {
			newModelJson.editable = updates.editable;
		}

		if (updates.resetPerDay) {
			newModelJson.resetPerDay = updates.resetPerDay;
		}

		if (updates.counterLength) {
			newModelJson.counterLength = updates.counterLength;
		}

		if (updates.lastUpdated) {
			newModelJson.lastUpdated = updates.lastUpdated;
		}

		if (updates.preview) {
			newModelJson.preview = updates.preview;
		}

		if (updates.dateFormat) {
			newModelJson.dateFormat = updates.dateFormat;
		}

		if (updates.numberingType) {
			newModelJson.numberingType = updates.numberingType;
		}

		return new NumberingSetupModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof NumberingSetupModel)) {
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
