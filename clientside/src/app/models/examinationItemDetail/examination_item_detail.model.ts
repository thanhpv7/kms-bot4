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
import {ExaminationItemModel} from '../examinationItem/examination_item.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class ExaminationItemDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'ageMinimum',
		'ageMaximum',
		'gender',
		'normalRangeLow',
		'normalRangeHigh',
		'unit',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'ageMinimum',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ExaminationItemDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ExaminationItemDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	ageMinimum: number;

	/**
	 * .
	 */
	ageMaximum: number;

	/**
	 * .
	 */
	gender: string;

	/**
	 * .
	 */
	normalRangeLow: number;

	/**
	 * .
	 */
	normalRangeHigh: number;

	/**
	 * .
	 */
	unit: string;

	/**
	 * .
	 */
	criticalValueLow: number;

	/**
	 * .
	 */
	criticalValueHigh: number;

	/**
	 * .
	 */
	ageMinUnit: string;

	/**
	 * .
	 */
	ageMaxUnit: string;

	examinationItemId: string;

	examinationItem: ExaminationItemModel;

	modelPropGroups: { [s: string]: Group } = ExaminationItemDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'ageMinimum',
				// % protected region % [Set displayName for Age Minimum here] off begin
				displayName: 'Age Minimum',
				// % protected region % [Set displayName for Age Minimum here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Age Minimum here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Age Minimum here] end
				// % protected region % [Set isSensitive for Age Minimum here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Age Minimum here] end
				// % protected region % [Set readonly for Age Minimum here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Age Minimum here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Age Minimum here] off begin
					// % protected region % [Add other validators for Age Minimum here] end
				],
				// % protected region % [Add any additional model attribute properties for Age Minimum here] off begin
				// % protected region % [Add any additional model attribute properties for Age Minimum here] end
			},
			{
				name: 'ageMaximum',
				// % protected region % [Set displayName for Age Maximum here] off begin
				displayName: 'Age Maximum',
				// % protected region % [Set displayName for Age Maximum here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Age Maximum here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Age Maximum here] end
				// % protected region % [Set isSensitive for Age Maximum here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Age Maximum here] end
				// % protected region % [Set readonly for Age Maximum here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Age Maximum here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Age Maximum here] off begin
					// % protected region % [Add other validators for Age Maximum here] end
				],
				// % protected region % [Add any additional model attribute properties for Age Maximum here] off begin
				// % protected region % [Add any additional model attribute properties for Age Maximum here] end
			},
			{
				name: 'gender',
				// % protected region % [Set displayName for Gender here] off begin
				displayName: 'Gender',
				// % protected region % [Set displayName for Gender here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gender here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gender here] end
				// % protected region % [Set isSensitive for Gender here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gender here] end
				// % protected region % [Set readonly for Gender here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gender here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Gender here] off begin
					// % protected region % [Add other validators for Gender here] end
				],
				// % protected region % [Add any additional model attribute properties for Gender here] off begin
				// % protected region % [Add any additional model attribute properties for Gender here] end
			},
			{
				name: 'normalRangeLow',
				// % protected region % [Set displayName for Normal Range Low here] off begin
				displayName: 'Normal Range Low',
				// % protected region % [Set displayName for Normal Range Low here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Normal Range Low here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Normal Range Low here] end
				// % protected region % [Set isSensitive for Normal Range Low here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Normal Range Low here] end
				// % protected region % [Set readonly for Normal Range Low here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Normal Range Low here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Normal Range Low here] off begin
					// % protected region % [Add other validators for Normal Range Low here] end
				],
				// % protected region % [Add any additional model attribute properties for Normal Range Low here] off begin
				// % protected region % [Add any additional model attribute properties for Normal Range Low here] end
			},
			{
				name: 'normalRangeHigh',
				// % protected region % [Set displayName for Normal Range High here] off begin
				displayName: 'Normal Range High',
				// % protected region % [Set displayName for Normal Range High here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Normal Range High here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Normal Range High here] end
				// % protected region % [Set isSensitive for Normal Range High here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Normal Range High here] end
				// % protected region % [Set readonly for Normal Range High here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Normal Range High here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Normal Range High here] off begin
					// % protected region % [Add other validators for Normal Range High here] end
				],
				// % protected region % [Add any additional model attribute properties for Normal Range High here] off begin
				// % protected region % [Add any additional model attribute properties for Normal Range High here] end
			},
			{
				name: 'unit',
				// % protected region % [Set displayName for Unit here] off begin
				displayName: 'Unit',
				// % protected region % [Set displayName for Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Unit here] end
				// % protected region % [Set isSensitive for Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit here] end
				// % protected region % [Set readonly for Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Unit here] off begin
					// % protected region % [Add other validators for Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Unit here] end
			},
			{
				name: 'criticalValueLow',
				// % protected region % [Set displayName for Critical Value Low here] off begin
				displayName: 'Critical Value Low',
				// % protected region % [Set displayName for Critical Value Low here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Critical Value Low here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Critical Value Low here] end
				// % protected region % [Set isSensitive for Critical Value Low here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Critical Value Low here] end
				// % protected region % [Set readonly for Critical Value Low here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Critical Value Low here] end
				validators: [
					// % protected region % [Add other validators for Critical Value Low here] off begin
					// % protected region % [Add other validators for Critical Value Low here] end
				],
				// % protected region % [Add any additional model attribute properties for Critical Value Low here] off begin
				// % protected region % [Add any additional model attribute properties for Critical Value Low here] end
			},
			{
				name: 'criticalValueHigh',
				// % protected region % [Set displayName for Critical Value High here] off begin
				displayName: 'Critical Value High',
				// % protected region % [Set displayName for Critical Value High here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Critical Value High here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Critical Value High here] end
				// % protected region % [Set isSensitive for Critical Value High here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Critical Value High here] end
				// % protected region % [Set readonly for Critical Value High here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Critical Value High here] end
				validators: [
					// % protected region % [Add other validators for Critical Value High here] off begin
					// % protected region % [Add other validators for Critical Value High here] end
				],
				// % protected region % [Add any additional model attribute properties for Critical Value High here] off begin
				// % protected region % [Add any additional model attribute properties for Critical Value High here] end
			},
			{
				name: 'ageMinUnit',
				// % protected region % [Set displayName for Age Min Unit here] off begin
				displayName: 'Age Min Unit',
				// % protected region % [Set displayName for Age Min Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Age Min Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Age Min Unit here] end
				// % protected region % [Set isSensitive for Age Min Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Age Min Unit here] end
				// % protected region % [Set readonly for Age Min Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Age Min Unit here] end
				validators: [
					// % protected region % [Add other validators for Age Min Unit here] off begin
					// % protected region % [Add other validators for Age Min Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Age Min Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Age Min Unit here] end
			},
			{
				name: 'ageMaxUnit',
				// % protected region % [Set displayName for Age Max Unit here] off begin
				displayName: 'Age Max Unit',
				// % protected region % [Set displayName for Age Max Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Age Max Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Age Max Unit here] end
				// % protected region % [Set isSensitive for Age Max Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Age Max Unit here] end
				// % protected region % [Set readonly for Age Max Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Age Max Unit here] end
				validators: [
					// % protected region % [Add other validators for Age Max Unit here] off begin
					// % protected region % [Add other validators for Age Max Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Age Max Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Age Max Unit here] end
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
				id: 'examinationItem',
				type: ModelRelationType.ONE,
				name: 'examinationItemId',
				// % protected region % [Customise your label for Examination Item here] off begin
				label: 'Examination Item',
				// % protected region % [Customise your label for Examination Item here] end
				entityName: 'ExaminationItemModel',
				// % protected region % [Customise your display name for Examination Item here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemCode',
				// % protected region % [Customise your display name for Examination Item here] end
				validators: [
					// % protected region % [Add other validators for Examination Item here] off begin
					// % protected region % [Add other validators for Examination Item here] end
				],
				// % protected region % [Add any additional field for relation Examination Item here] off begin
				// % protected region % [Add any additional field for relation Examination Item here] end
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
				case 'ageMinimum':
					break;
				case 'ageMaximum':
					break;
				case 'gender':
					break;
				case 'normalRangeLow':
					break;
				case 'normalRangeHigh':
					break;
				case 'unit':
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
	static deepParse(data: string | { [K in keyof ExaminationItemDetailModel]?: ExaminationItemDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ExaminationItemDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.examinationItem) {
			currentModel.examinationItemId = json.examinationItem.id;
			returned = _.union(returned, ExaminationItemModel.deepParse(json.examinationItem));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let examinationItemDetailModel = new ExaminationItemDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the ExaminationItemDetailModel,
	 *    it is expected as a JSON string or as a nullable ExaminationItemDetailModel.
	 */
	constructor(data?: string | Partial<ExaminationItemDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ExaminationItemDetailModel>
				: data;

			this.ageMinimum = json.ageMinimum;
			this.ageMaximum = json.ageMaximum;
			this.gender = json.gender;
			this.normalRangeLow = json.normalRangeLow;
			this.normalRangeHigh = json.normalRangeHigh;
			this.unit = json.unit;
			this.criticalValueLow = json.criticalValueLow;
			this.criticalValueHigh = json.criticalValueHigh;
			this.ageMinUnit = json.ageMinUnit;
			this.ageMaxUnit = json.ageMaxUnit;
			this.examinationItemId = json.examinationItemId;
			this.examinationItem = json.examinationItem;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			ageMinimum: this.ageMinimum,
			ageMaximum: this.ageMaximum,
			gender: this.gender,
			normalRangeLow: this.normalRangeLow,
			normalRangeHigh: this.normalRangeHigh,
			unit: this.unit,
			criticalValueLow: this.criticalValueLow,
			criticalValueHigh: this.criticalValueHigh,
			ageMinUnit: this.ageMinUnit,
			ageMaxUnit: this.ageMaxUnit,
			examinationItemId: this.examinationItemId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ExaminationItemDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ExaminationItemDetailModel {
		let newModelJson = this.toJSON();

		if (updates.ageMinimum) {
			newModelJson.ageMinimum = updates.ageMinimum;
		}

		if (updates.ageMaximum) {
			newModelJson.ageMaximum = updates.ageMaximum;
		}

		if (updates.gender) {
			newModelJson.gender = updates.gender;
		}

		if (updates.normalRangeLow) {
			newModelJson.normalRangeLow = updates.normalRangeLow;
		}

		if (updates.normalRangeHigh) {
			newModelJson.normalRangeHigh = updates.normalRangeHigh;
		}

		if (updates.unit) {
			newModelJson.unit = updates.unit;
		}

		if (updates.criticalValueLow) {
			newModelJson.criticalValueLow = updates.criticalValueLow;
		}

		if (updates.criticalValueHigh) {
			newModelJson.criticalValueHigh = updates.criticalValueHigh;
		}

		if (updates.ageMinUnit) {
			newModelJson.ageMinUnit = updates.ageMinUnit;
		}

		if (updates.ageMaxUnit) {
			newModelJson.ageMaxUnit = updates.ageMaxUnit;
		}

		if (updates.examinationItemId) {
			newModelJson.examinationItemId = updates.examinationItemId;
		}

		return new ExaminationItemDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ExaminationItemDetailModel)) {
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
			'examinationItemId',
			'examinationItem',
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
		if (!this.examinationItem) {
			this.examinationItemId = null;
		} else {
			this.examinationItemId = this.examinationItem.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
