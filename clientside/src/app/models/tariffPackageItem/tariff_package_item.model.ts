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
import {TariffPackageModel} from '../tariffPackage/tariff_package.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class TariffPackageItemModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
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

	readonly className = 'TariffPackageItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TariffPackageItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	tariffCode: string;

	/**
	 * .
	 */
	tariffName: string;

	/**
	 * .
	 */
	quantity: number;

	/**
	 * .
	 */
	unit: string;

	/**
	 * .
	 */
	modifiable: boolean = false;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=2, example=Sally}.
	 */
	tariffType: TariffTypeEnum;

	tariffPackageId: string;

	tariffPackage: TariffPackageModel;

	modelPropGroups: { [s: string]: Group } = TariffPackageItemModel.modelPropGroups;

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
				// % protected region % [Set displayName for Tariff  Code here] off begin
				displayName: 'Tariff  Code',
				// % protected region % [Set displayName for Tariff  Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tariff  Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tariff  Code here] end
				// % protected region % [Set isSensitive for Tariff  Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff  Code here] end
				// % protected region % [Set readonly for Tariff  Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff  Code here] end
				validators: [
					// % protected region % [Add other validators for Tariff  Code here] off begin
					// % protected region % [Add other validators for Tariff  Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff  Code here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff  Code here] end
			},
			{
				name: 'tariffName',
				// % protected region % [Set displayName for Tariff  Name here] off begin
				displayName: 'Tariff  Name',
				// % protected region % [Set displayName for Tariff  Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tariff  Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tariff  Name here] end
				// % protected region % [Set isSensitive for Tariff  Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff  Name here] end
				// % protected region % [Set readonly for Tariff  Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff  Name here] end
				validators: [
					// % protected region % [Add other validators for Tariff  Name here] off begin
					// % protected region % [Add other validators for Tariff  Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff  Name here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff  Name here] end
			},
			{
				name: 'quantity',
				// % protected region % [Set displayName for Quantity here] off begin
				displayName: 'Quantity',
				// % protected region % [Set displayName for Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Quantity here] end
				// % protected region % [Set isSensitive for Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Quantity here] end
				// % protected region % [Set readonly for Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Quantity here] end
				validators: [
					// % protected region % [Add other validators for Quantity here] off begin
					// % protected region % [Add other validators for Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Quantity here] end
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
					// % protected region % [Add other validators for Unit here] off begin
					// % protected region % [Add other validators for Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Unit here] end
			},
			{
				name: 'modifiable',
				// % protected region % [Set displayName for Modifiable here] off begin
				displayName: 'Modifiable',
				// % protected region % [Set displayName for Modifiable here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Modifiable here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Modifiable here] end
				// % protected region % [Set isSensitive for Modifiable here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Modifiable here] end
				// % protected region % [Set readonly for Modifiable here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Modifiable here] end
				validators: [
					// % protected region % [Add other validators for Modifiable here] off begin
					// % protected region % [Add other validators for Modifiable here] end
				],
				// % protected region % [Add any additional model attribute properties for Modifiable here] off begin
				// % protected region % [Add any additional model attribute properties for Modifiable here] end
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
				id: 'tariffPackage',
				type: ModelRelationType.ONE,
				name: 'tariffPackageId',
				// % protected region % [Customise your label for Tariff Package here] off begin
				label: 'Tariff Package',
				// % protected region % [Customise your label for Tariff Package here] end
				entityName: 'TariffPackageModel',
				// % protected region % [Customise your display name for Tariff Package here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'tariffPackageCode',
				// % protected region % [Customise your display name for Tariff Package here] end
				validators: [
					// % protected region % [Add other validators for Tariff Package here] off begin
					// % protected region % [Add other validators for Tariff Package here] end
				],
				// % protected region % [Add any additional field for relation Tariff Package here] off begin
				// % protected region % [Add any additional field for relation Tariff Package here] end
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
	static deepParse(data: string | { [K in keyof TariffPackageItemModel]?: TariffPackageItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TariffPackageItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.tariffPackage) {
			currentModel.tariffPackageId = json.tariffPackage.id;
			returned = _.union(returned, TariffPackageModel.deepParse(json.tariffPackage));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let tariffPackageItemModel = new TariffPackageItemModel(data);`
	 *
	 * @param data The input data to be initialised as the TariffPackageItemModel,
	 *    it is expected as a JSON string or as a nullable TariffPackageItemModel.
	 */
	constructor(data?: string | Partial<TariffPackageItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TariffPackageItemModel>
				: data;

			this.tariffType = json.tariffType;
			this.tariffCode = json.tariffCode;
			this.tariffName = json.tariffName;
			this.quantity = json.quantity;
			this.unit = json.unit;
			this.modifiable = json.modifiable;
			this.tariffType = json.tariffType;
			this.tariffPackageId = json.tariffPackageId;
			this.tariffPackage = json.tariffPackage;
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
			tariffName: this.tariffName,
			quantity: this.quantity,
			unit: this.unit,
			modifiable: this.modifiable,
			tariffPackageId: this.tariffPackageId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TariffPackageItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TariffPackageItemModel {
		let newModelJson = this.toJSON();

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.tariffCode) {
			newModelJson.tariffCode = updates.tariffCode;
		}

		if (updates.tariffName) {
			newModelJson.tariffName = updates.tariffName;
		}

		if (updates.quantity) {
			newModelJson.quantity = updates.quantity;
		}

		if (updates.unit) {
			newModelJson.unit = updates.unit;
		}

		if (updates.modifiable) {
			newModelJson.modifiable = updates.modifiable;
		}

		if (updates.tariffType) {
			newModelJson.tariffType = updates.tariffType;
		}

		if (updates.tariffPackageId) {
			newModelJson.tariffPackageId = updates.tariffPackageId;
		}

		return new TariffPackageItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TariffPackageItemModel)) {
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
			'tariffPackageId',
			'tariffPackage',
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
		if (!this.tariffPackage) {
			this.tariffPackageId = null;
		} else {
			this.tariffPackageId = this.tariffPackage.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
