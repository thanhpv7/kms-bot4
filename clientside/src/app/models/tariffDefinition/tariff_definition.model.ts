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
import {TariffTypeEnum, tariffTypeEnumArray} from '../../enums/tariff-type.enum';
import {TariffDefinitionOtherComponentModel} from '../tariffDefinitionOtherComponent/tariff_definition_other_component.model';
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
export class TariffDefinitionModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'tariffType',
		'tariffCode',
		'tariffPrice',
		'hospitalPrice',
		'otherComponentPrice',
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

	readonly className = 'TariffDefinitionModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TariffDefinitionModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * (Max length: 50) If [Tariff Type]=SERVICE ITEM then copy [Service Item Code] on [Service Item] entity. If [Tariff Type]=STOCK then copy [Stock Code] on [Stock Catalogue] entity. If [Tariff Type]=ROOM then copys [Bed Number] on [Bed Facility] entity.
	 */
	tariffCode: string;

	/**
	 * Total Price from Hospital Price and Other Component Price, with 2 decimal digits.
	 */
	tariffPrice: number;

	/**
	 * Hospital Price, with 2 decimal digits.
	 */
	hospitalPrice: number;

	/**
	 * Total from Price of Component on Tariff Definition Other Component entity, with 2 decimal digits.
	 */
	otherComponentPrice: number;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=2, example=Sally}.
	 */
	tariffType: TariffTypeEnum;

	priceSchemaId: string;

	priceSchema: TariffSchemaModel;

	tariffDefinitionOtherComponentsIds: string[] = [];

	tariffDefinitionOtherComponents: TariffDefinitionOtherComponentModel[];

	modelPropGroups: { [s: string]: Group } = TariffDefinitionModel.modelPropGroups;

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
					// % protected region % [Add other validators for Tariff Code here] off begin
					// % protected region % [Add other validators for Tariff Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Code here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Code here] end
			},
			{
				name: 'tariffPrice',
				// % protected region % [Set displayName for Tariff Price here] off begin
				displayName: 'Tariff Price',
				// % protected region % [Set displayName for Tariff Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Tariff Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Tariff Price here] end
				// % protected region % [Set isSensitive for Tariff Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff Price here] end
				// % protected region % [Set readonly for Tariff Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff Price here] end
				validators: [
					// % protected region % [Add other validators for Tariff Price here] off begin
					// % protected region % [Add other validators for Tariff Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Price here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Price here] end
			},
			{
				name: 'hospitalPrice',
				// % protected region % [Set displayName for Hospital Price here] off begin
				displayName: 'Hospital Price',
				// % protected region % [Set displayName for Hospital Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Hospital Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Hospital Price here] end
				// % protected region % [Set isSensitive for Hospital Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Price here] end
				// % protected region % [Set readonly for Hospital Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Price here] end
				validators: [
					// % protected region % [Add other validators for Hospital Price here] off begin
					// % protected region % [Add other validators for Hospital Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Price here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Price here] end
			},
			{
				name: 'otherComponentPrice',
				// % protected region % [Set displayName for Other Component Price here] off begin
				displayName: 'Other Component Price',
				// % protected region % [Set displayName for Other Component Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Other Component Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Other Component Price here] end
				// % protected region % [Set isSensitive for Other Component Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Component Price here] end
				// % protected region % [Set readonly for Other Component Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Component Price here] end
				validators: [
					// % protected region % [Add other validators for Other Component Price here] off begin
					// % protected region % [Add other validators for Other Component Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Component Price here] off begin
				// % protected region % [Add any additional model attribute properties for Other Component Price here] end
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
				id: 'tariffDefinitionOtherComponents',
				type: ModelRelationType.MANY,
				name: 'tariffDefinitionOtherComponentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Definition Other Components here] off begin
				label: 'Tariff Definition Other Components',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Definition Other Components here] end
				entityName: 'TariffDefinitionOtherComponentModel',
				// % protected region % [Customise your display name for Tariff Definition Other Components here] off begin
				displayName: 'price',
				// % protected region % [Customise your display name for Tariff Definition Other Components here] end
				validators: [
					// % protected region % [Add other validators for Tariff Definition Other Components here] off begin
					// % protected region % [Add other validators for Tariff Definition Other Components here] end
				],
				// % protected region % [Add any additional field for relation Tariff Definition Other Components here] off begin
				// % protected region % [Add any additional field for relation Tariff Definition Other Components here] end
			},
			{
				id: 'priceSchema',
				type: ModelRelationType.ONE,
				name: 'priceSchemaId',
				// % protected region % [Customise your label for Price Schema here] off begin
				label: 'Price Schema',
				// % protected region % [Customise your label for Price Schema here] end
				entityName: 'TariffSchemaModel',
				// % protected region % [Customise your display name for Price Schema here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'schemaCode',
				// % protected region % [Customise your display name for Price Schema here] end
				validators: [
					// % protected region % [Add other validators for Price Schema here] off begin
					// % protected region % [Add other validators for Price Schema here] end
				],
				// % protected region % [Add any additional field for relation Price Schema here] off begin
				// % protected region % [Add any additional field for relation Price Schema here] end
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
				case 'tariffCode':
					break;
				case 'tariffPrice':
					break;
				case 'hospitalPrice':
					break;
				case 'otherComponentPrice':
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
	static deepParse(data: string | { [K in keyof TariffDefinitionModel]?: TariffDefinitionModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TariffDefinitionModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.priceSchema) {
			currentModel.priceSchemaId = json.priceSchema.id;
			returned = _.union(returned, TariffSchemaModel.deepParse(json.priceSchema));
		}

		// Outgoing one to many
		if (json.tariffDefinitionOtherComponents) {
			currentModel.tariffDefinitionOtherComponentsIds = json.tariffDefinitionOtherComponents.map(model => model.id);
			returned = _.union(returned, _.flatten(json.tariffDefinitionOtherComponents.map(model => TariffDefinitionOtherComponentModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let tariffDefinitionModel = new TariffDefinitionModel(data);`
	 *
	 * @param data The input data to be initialised as the TariffDefinitionModel,
	 *    it is expected as a JSON string or as a nullable TariffDefinitionModel.
	 */
	constructor(data?: string | Partial<TariffDefinitionModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TariffDefinitionModel>
				: data;

			this.tariffType = json.tariffType;
			this.tariffCode = json.tariffCode;
			this.tariffPrice = json.tariffPrice;
			this.hospitalPrice = json.hospitalPrice;
			this.otherComponentPrice = json.otherComponentPrice;
			this.tariffType = json.tariffType;
			this.priceSchemaId = json.priceSchemaId;
			this.priceSchema = json.priceSchema;
			this.tariffDefinitionOtherComponentsIds = json.tariffDefinitionOtherComponentsIds;
			this.tariffDefinitionOtherComponents = json.tariffDefinitionOtherComponents;
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
			tariffCode: this.tariffCode,
			tariffPrice: this.tariffPrice,
			hospitalPrice: this.hospitalPrice,
			otherComponentPrice: this.otherComponentPrice,
			priceSchemaId: this.priceSchemaId,
			tariffDefinitionOtherComponentsIds: this.tariffDefinitionOtherComponentsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TariffDefinitionModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TariffDefinitionModel {
		let newModelJson = this.toJSON();

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.tariffCode) {
			newModelJson.tariffCode = updates.tariffCode;
		}

		if (updates.tariffPrice) {
			newModelJson.tariffPrice = updates.tariffPrice;
		}

		if (updates.hospitalPrice) {
			newModelJson.hospitalPrice = updates.hospitalPrice;
		}

		if (updates.otherComponentPrice) {
			newModelJson.otherComponentPrice = updates.otherComponentPrice;
		}

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.priceSchemaId) {
			newModelJson.priceSchemaId = updates.priceSchemaId;
		}

		if (updates.tariffDefinitionOtherComponentsIds) {
			newModelJson.tariffDefinitionOtherComponentsIds = updates.tariffDefinitionOtherComponentsIds;
		}

		return new TariffDefinitionModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TariffDefinitionModel)) {
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
			'priceSchemaId',
			'priceSchema',
			'tariffDefinitionOtherComponentsIds',
			'tariffDefinitionOtherComponents',
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
		if (!this.priceSchema) {
			this.priceSchemaId = null;
		} else {
			this.priceSchemaId = this.priceSchema.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
