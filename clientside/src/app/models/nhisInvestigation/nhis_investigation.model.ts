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
export class NhisInvestigationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'gdrgCode',
		'description',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'gdrgCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'NhisInvestigationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return NhisInvestigationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	gdrgCode: string;

	/**
	 * .
	 */
	description: string;

	/**
	 * .
	 */
	category: string;

	/**
	 * .
	 */
	price: number;

	/**
	 * .
	 */
	date: Date;



	modelPropGroups: { [s: string]: Group } = NhisInvestigationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'gdrgCode',
				// % protected region % [Set displayName for GDRG Code here] off begin
				displayName: 'GDRG Code',
				// % protected region % [Set displayName for GDRG Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for GDRG Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for GDRG Code here] end
				// % protected region % [Set isSensitive for GDRG Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for GDRG Code here] end
				// % protected region % [Set readonly for GDRG Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for GDRG Code here] end
				validators: [
					// % protected region % [Add other validators for GDRG Code here] off begin
					// % protected region % [Add other validators for GDRG Code here] end
				],
				// % protected region % [Add any additional model attribute properties for GDRG Code here] off begin
				// % protected region % [Add any additional model attribute properties for GDRG Code here] end
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
					// % protected region % [Add other validators for Description here] off begin
					// % protected region % [Add other validators for Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Description here] off begin
				// % protected region % [Add any additional model attribute properties for Description here] end
			},
			{
				name: 'category',
				// % protected region % [Set displayName for Category here] off begin
				displayName: 'Category',
				// % protected region % [Set displayName for Category here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Category here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Category here] end
				// % protected region % [Set isSensitive for Category here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Category here] end
				// % protected region % [Set readonly for Category here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Category here] end
				validators: [
					// % protected region % [Add other validators for Category here] off begin
					// % protected region % [Add other validators for Category here] end
				],
				// % protected region % [Add any additional model attribute properties for Category here] off begin
				// % protected region % [Add any additional model attribute properties for Category here] end
			},
			{
				name: 'price',
				// % protected region % [Set displayName for Price here] off begin
				displayName: 'Price',
				// % protected region % [Set displayName for Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Price here] end
				// % protected region % [Set isSensitive for Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Price here] end
				// % protected region % [Set readonly for Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Price here] end
				validators: [
					// % protected region % [Add other validators for Price here] off begin
					// % protected region % [Add other validators for Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Price here] off begin
				// % protected region % [Add any additional model attribute properties for Price here] end
			},
			{
				name: 'date',
				// % protected region % [Set displayName for Date here] off begin
				displayName: 'Date',
				// % protected region % [Set displayName for Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Date here] end
				// % protected region % [Set isSensitive for Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date here] end
				// % protected region % [Set readonly for Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date here] end
				validators: [
					// % protected region % [Add other validators for Date here] off begin
					// % protected region % [Add other validators for Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Date here] off begin
				// % protected region % [Add any additional model attribute properties for Date here] end
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
				case 'gdrgCode':
					break;
				case 'description':
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
	static deepParse(data: string | { [K in keyof NhisInvestigationModel]?: NhisInvestigationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new NhisInvestigationModel(data);
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
	 * `let nhisInvestigationModel = new NhisInvestigationModel(data);`
	 *
	 * @param data The input data to be initialised as the NhisInvestigationModel,
	 *    it is expected as a JSON string or as a nullable NhisInvestigationModel.
	 */
	constructor(data?: string | Partial<NhisInvestigationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<NhisInvestigationModel>
				: data;

			this.gdrgCode = json.gdrgCode;
			this.description = json.description;
			this.category = json.category;
			this.price = json.price;
			if (json.date) {
				this.date = new Date(json.date);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.date = json.date;
			}
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			gdrgCode: this.gdrgCode,
			description: this.description,
			category: this.category,
			price: this.price,
			date: this.date,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		NhisInvestigationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): NhisInvestigationModel {
		let newModelJson = this.toJSON();

		if (updates.gdrgCode) {
			newModelJson.gdrgCode = updates.gdrgCode;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.category) {
			newModelJson.category = updates.category;
		}

		if (updates.price) {
			newModelJson.price = updates.price;
		}

		if (updates.date) {
			newModelJson.date = updates.date;
		}

		return new NhisInvestigationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof NhisInvestigationModel)) {
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
