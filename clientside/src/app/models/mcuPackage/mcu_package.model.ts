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
import {McuPackageItemModel} from '../mcuPackageItem/mcu_package_item.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class McuPackageModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'mcuPackageCode',
		'description',
		'packageType',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'mcuPackageCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'McuPackageModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return McuPackageModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * MCU Package Code (Max Length: 50).
	 */
	mcuPackageCode: string;

	/**
	 * Name of MCU Package (Max Length: 250).
	 */
	description: string;

	/**
	 * Package Type, get the Code from Reference Data where Type=MCU_PKG_TYPE. (Max Length: 20).
	 */
	packageType: string;

	/**
	 * Sequence of MCU Package to be ordered on Registration/list.
	 */
	sequence: number;

	mcuPackageItemsIds: string[] = [];

	mcuPackageItems: McuPackageItemModel[];

	modelPropGroups: { [s: string]: Group } = McuPackageModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'mcuPackageCode',
				// % protected region % [Set displayName for MCU Package Code here] off begin
				displayName: 'MCU Package Code',
				// % protected region % [Set displayName for MCU Package Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for MCU Package Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for MCU Package Code here] end
				// % protected region % [Set isSensitive for MCU Package Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for MCU Package Code here] end
				// % protected region % [Set readonly for MCU Package Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for MCU Package Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for MCU Package Code here] off begin
					// % protected region % [Add other validators for MCU Package Code here] end
				],
				// % protected region % [Add any additional model attribute properties for MCU Package Code here] off begin
				// % protected region % [Add any additional model attribute properties for MCU Package Code here] end
			},
			{
				name: 'description',
				// % protected region % [Set displayName for Description here] off begin
				displayName: 'Description',
				// % protected region % [Set displayName for Description here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Description here] off begin
				elementType: ElementType.INPUT,
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
				name: 'packageType',
				// % protected region % [Set displayName for Package Type here] off begin
				displayName: 'Package Type',
				// % protected region % [Set displayName for Package Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Package Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Package Type here] end
				// % protected region % [Set isSensitive for Package Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Package Type here] end
				// % protected region % [Set readonly for Package Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Package Type here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Package Type here] off begin
					// % protected region % [Add other validators for Package Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Package Type here] off begin
				// % protected region % [Add any additional model attribute properties for Package Type here] end
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
					// % protected region % [Add other validators for Sequence here] off begin
					// % protected region % [Add other validators for Sequence here] end
				],
				// % protected region % [Add any additional model attribute properties for Sequence here] off begin
				// % protected region % [Add any additional model attribute properties for Sequence here] end
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
				id: 'mcuPackageItems',
				type: ModelRelationType.MANY,
				name: 'mcuPackageItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for MCU Package Items here] off begin
				label: 'MCU Package Items',
				// % protected region % [Customise your 1-1 or 1-M label for MCU Package Items here] end
				entityName: 'McuPackageItemModel',
				// % protected region % [Customise your display name for MCU Package Items here] off begin
				displayName: 'itemCode',
				// % protected region % [Customise your display name for MCU Package Items here] end
				validators: [
					// % protected region % [Add other validators for MCU Package Items here] off begin
					// % protected region % [Add other validators for MCU Package Items here] end
				],
				// % protected region % [Add any additional field for relation MCU Package Items here] off begin
				// % protected region % [Add any additional field for relation MCU Package Items here] end
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
				case 'mcuPackageCode':
					break;
				case 'description':
					break;
				case 'packageType':
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
	static deepParse(data: string | { [K in keyof McuPackageModel]?: McuPackageModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new McuPackageModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.mcuPackageItems) {
			currentModel.mcuPackageItemsIds = json.mcuPackageItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.mcuPackageItems.map(model => McuPackageItemModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let mcuPackageModel = new McuPackageModel(data);`
	 *
	 * @param data The input data to be initialised as the McuPackageModel,
	 *    it is expected as a JSON string or as a nullable McuPackageModel.
	 */
	constructor(data?: string | Partial<McuPackageModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<McuPackageModel>
				: data;

			this.mcuPackageCode = json.mcuPackageCode;
			this.description = json.description;
			this.packageType = json.packageType;
			this.sequence = json.sequence;
			this.mcuPackageItemsIds = json.mcuPackageItemsIds;
			this.mcuPackageItems = json.mcuPackageItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			mcuPackageCode: this.mcuPackageCode,
			description: this.description,
			packageType: this.packageType,
			sequence: this.sequence,
			mcuPackageItemsIds: this.mcuPackageItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		McuPackageModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): McuPackageModel {
		let newModelJson = this.toJSON();

		if (updates.mcuPackageCode) {
			newModelJson.mcuPackageCode = updates.mcuPackageCode;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.packageType) {
			newModelJson.packageType = updates.packageType;
		}

		if (updates.sequence) {
			newModelJson.sequence = updates.sequence;
		}

		if (updates.mcuPackageItemsIds) {
			newModelJson.mcuPackageItemsIds = updates.mcuPackageItemsIds;
		}

		return new McuPackageModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof McuPackageModel)) {
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
			'mcuPackageItemsIds',
			'mcuPackageItems',
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
