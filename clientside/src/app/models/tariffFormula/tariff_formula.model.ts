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
import {RoundingMethodEnum, roundingMethodEnumArray} from '../../enums/rounding-method.enum';
import {TariffTypeEnum, tariffTypeEnumArray} from '../../enums/tariff-type.enum';
import {TariffSchemaModel} from '../tariffSchema/tariff_schema.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class TariffFormulaModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'tariffType',
		'classification',
		'multiplier',
		'rounding',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'tariffType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'TariffFormulaModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TariffFormulaModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Default is 'ALL' (max len 50). If [Tariff Type]=SERVICE ITEM then copy [Service Item Classification] on [Service Item] enty. If [Tariff Type]=STOCK then [Stock Categlory] on [Stock Catalogue] enty. If [Tariff Type]=ROOM then [Department] on [Room Facility.
	 */
	classification: string;

	/**
	 * Multiplier with 2 decimal digits.
	 */
	multiplier: number;

	/**
	 * Rounding.
	 */
	rounding: number;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=6, example=Sally}.
	 */
	roundingMethod: RoundingMethodEnum;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=2, example=Sally}.
	 */
	tariffType: TariffTypeEnum;

	baseSchemaId: string;

	baseSchema: TariffSchemaModel;

	tariffSchemaId: string;

	tariffSchema: TariffSchemaModel;

	modelPropGroups: { [s: string]: Group } = TariffFormulaModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'tariffType',
				// % protected region % [Set displayName for Tariff Type here] off begin
				displayName: 'Tariff Type',
				// % protected region % [Set displayName for Tariff Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: tariffTypeEnumArray,
				// % protected region % [Set display element type for Tariff Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Tariff Type here] end
				// % protected region % [Set isSensitive for Tariff Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff Type here] end
				// % protected region % [Set readonly for Tariff Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff Type here] end
				validators: [
					// % protected region % [Add other validators for Tariff Type here] off begin
					// % protected region % [Add other validators for Tariff Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Type here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Type here] end
			},
			{
				name: 'classification',
				// % protected region % [Set displayName for Classification here] off begin
				displayName: 'Classification',
				// % protected region % [Set displayName for Classification here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Classification here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Classification here] end
				// % protected region % [Set isSensitive for Classification here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Classification here] end
				// % protected region % [Set readonly for Classification here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Classification here] end
				validators: [
					// % protected region % [Add other validators for Classification here] off begin
					// % protected region % [Add other validators for Classification here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification here] off begin
				// % protected region % [Add any additional model attribute properties for Classification here] end
			},
			{
				name: 'multiplier',
				// % protected region % [Set displayName for Multiplier here] off begin
				displayName: 'Multiplier',
				// % protected region % [Set displayName for Multiplier here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Multiplier here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Multiplier here] end
				// % protected region % [Set isSensitive for Multiplier here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Multiplier here] end
				// % protected region % [Set readonly for Multiplier here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Multiplier here] end
				validators: [
					// % protected region % [Add other validators for Multiplier here] off begin
					// % protected region % [Add other validators for Multiplier here] end
				],
				// % protected region % [Add any additional model attribute properties for Multiplier here] off begin
				// % protected region % [Add any additional model attribute properties for Multiplier here] end
			},
			{
				name: 'rounding',
				// % protected region % [Set displayName for Rounding here] off begin
				displayName: 'Rounding',
				// % protected region % [Set displayName for Rounding here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Rounding here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Rounding here] end
				// % protected region % [Set isSensitive for Rounding here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Rounding here] end
				// % protected region % [Set readonly for Rounding here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Rounding here] end
				validators: [
					// % protected region % [Add other validators for Rounding here] off begin
					// % protected region % [Add other validators for Rounding here] end
				],
				// % protected region % [Add any additional model attribute properties for Rounding here] off begin
				// % protected region % [Add any additional model attribute properties for Rounding here] end
			},
			{
				name: 'roundingMethod',
				// % protected region % [Set displayName for Rounding method here] off begin
				displayName: 'Rounding method',
				// % protected region % [Set displayName for Rounding method here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: roundingMethodEnumArray,
				// % protected region % [Set display element type for Rounding method here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Rounding method here] end
				// % protected region % [Set isSensitive for Rounding method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Rounding method here] end
				// % protected region % [Set readonly for Rounding method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Rounding method here] end
				validators: [
					// % protected region % [Add other validators for Rounding method here] off begin
					// % protected region % [Add other validators for Rounding method here] end
				],
				// % protected region % [Add any additional model attribute properties for Rounding method here] off begin
				// % protected region % [Add any additional model attribute properties for Rounding method here] end
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
				id: 'baseSchema',
				type: ModelRelationType.ONE,
				name: 'baseSchemaId',
				// % protected region % [Customise your label for Base Schema here] off begin
				label: 'Base Schema',
				// % protected region % [Customise your label for Base Schema here] end
				entityName: 'TariffSchemaModel',
				// % protected region % [Customise your display name for Base Schema here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'schemaCode',
				// % protected region % [Customise your display name for Base Schema here] end
				validators: [
					// % protected region % [Add other validators for Base Schema here] off begin
					// % protected region % [Add other validators for Base Schema here] end
				],
				// % protected region % [Add any additional field for relation Base Schema here] off begin
				// % protected region % [Add any additional field for relation Base Schema here] end
			},
			{
				id: 'tariffSchema',
				type: ModelRelationType.ONE,
				name: 'tariffSchemaId',
				// % protected region % [Customise your label for Tariff Schema here] off begin
				label: 'Tariff Schema',
				// % protected region % [Customise your label for Tariff Schema here] end
				entityName: 'TariffSchemaModel',
				// % protected region % [Customise your display name for Tariff Schema here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'schemaCode',
				// % protected region % [Customise your display name for Tariff Schema here] end
				validators: [
					// % protected region % [Add other validators for Tariff Schema here] off begin
					// % protected region % [Add other validators for Tariff Schema here] end
				],
				// % protected region % [Add any additional field for relation Tariff Schema here] off begin
				// % protected region % [Add any additional field for relation Tariff Schema here] end
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
				case 'tariffType':
					conditions.push([
						{
							path: key,
							operation: QueryOperation.EQUAL,
							value: formGroup.value[key],
						}
					]);
					break;
				case 'classification':
					break;
				case 'multiplier':
					break;
				case 'rounding':
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
	static deepParse(data: string | { [K in keyof TariffFormulaModel]?: TariffFormulaModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TariffFormulaModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.baseSchema) {
			currentModel.baseSchemaId = json.baseSchema.id;
			returned = _.union(returned, TariffSchemaModel.deepParse(json.baseSchema));
		}

		// Incoming one to many
		if (json.tariffSchema) {
			currentModel.tariffSchemaId = json.tariffSchema.id;
			returned = _.union(returned, TariffSchemaModel.deepParse(json.tariffSchema));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let tariffFormulaModel = new TariffFormulaModel(data);`
	 *
	 * @param data The input data to be initialised as the TariffFormulaModel,
	 *    it is expected as a JSON string or as a nullable TariffFormulaModel.
	 */
	constructor(data?: string | Partial<TariffFormulaModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TariffFormulaModel>
				: data;

			this.tariffType = json.tariffType;
			this.classification = json.classification;
			this.multiplier = json.multiplier;
			this.rounding = json.rounding;
			this.roundingMethod = json.roundingMethod;
			this.roundingMethod = json.roundingMethod;
			this.tariffType = json.tariffType;
			this.baseSchemaId = json.baseSchemaId;
			this.baseSchema = json.baseSchema;
			this.tariffSchemaId = json.tariffSchemaId;
			this.tariffSchema = json.tariffSchema;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			tariffType: this.tariffType,
			classification: this.classification,
			multiplier: this.multiplier,
			rounding: this.rounding,
			roundingMethod: this.roundingMethod,
			baseSchemaId: this.baseSchemaId,
			tariffSchemaId: this.tariffSchemaId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TariffFormulaModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TariffFormulaModel {
		let newModelJson = this.toJSON();

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.classification) {
			newModelJson.classification = updates.classification;
		}

		if (updates.multiplier) {
			newModelJson.multiplier = updates.multiplier;
		}

		if (updates.rounding) {
			newModelJson.rounding = updates.rounding;
		}

		if (updates.roundingMethod) {
			newModelJson.roundingMethod = updates.roundingMethod;
		}

		if (updates.roundingMethod) {
			newModelJson.roundingMethod = updates.roundingMethod;
		}

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.baseSchemaId) {
			newModelJson.baseSchemaId = updates.baseSchemaId;
		}

		if (updates.tariffSchemaId) {
			newModelJson.tariffSchemaId = updates.tariffSchemaId;
		}

		return new TariffFormulaModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TariffFormulaModel)) {
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
			'baseSchemaId',
			'baseSchema',
			'tariffSchemaId',
			'tariffSchema',
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
		if (!this.baseSchema) {
			this.baseSchemaId = null;
		} else {
			this.baseSchemaId = this.baseSchema.id;
		}

		if (!this.tariffSchema) {
			this.tariffSchemaId = null;
		} else {
			this.tariffSchemaId = this.tariffSchema.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
