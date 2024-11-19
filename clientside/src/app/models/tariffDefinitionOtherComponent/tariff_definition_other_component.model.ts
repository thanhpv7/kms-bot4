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
import {PriceComponentModel} from '../priceComponent/price_component.model';
import {TariffDefinitionModel} from '../tariffDefinition/tariff_definition.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class TariffDefinitionOtherComponentModel extends AbstractModel {
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
		'price',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'TariffDefinitionOtherComponentModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TariffDefinitionOtherComponentModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Price, with 2 decimal digits.
	 */
	price: number;

	priceComponentId: string;

	priceComponent: PriceComponentModel;

	priceDefinitionId: string;

	priceDefinition: TariffDefinitionModel;

	modelPropGroups: { [s: string]: Group } = TariffDefinitionOtherComponentModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
				id: 'priceComponent',
				type: ModelRelationType.ONE,
				name: 'priceComponentId',
				// % protected region % [Customise your label for Price Component here] off begin
				label: 'Price Component',
				// % protected region % [Customise your label for Price Component here] end
				entityName: 'PriceComponentModel',
				// % protected region % [Customise your display name for Price Component here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'componentCode',
				// % protected region % [Customise your display name for Price Component here] end
				validators: [
					// % protected region % [Add other validators for Price Component here] off begin
					// % protected region % [Add other validators for Price Component here] end
				],
				// % protected region % [Add any additional field for relation Price Component here] off begin
				// % protected region % [Add any additional field for relation Price Component here] end
			},
			{
				id: 'priceDefinition',
				type: ModelRelationType.ONE,
				name: 'priceDefinitionId',
				// % protected region % [Customise your label for Price Definition here] off begin
				label: 'Price Definition',
				// % protected region % [Customise your label for Price Definition here] end
				entityName: 'TariffDefinitionModel',
				// % protected region % [Customise your display name for Price Definition here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'tariffType',
				// % protected region % [Customise your display name for Price Definition here] end
				validators: [
					// % protected region % [Add other validators for Price Definition here] off begin
					// % protected region % [Add other validators for Price Definition here] end
				],
				// % protected region % [Add any additional field for relation Price Definition here] off begin
				// % protected region % [Add any additional field for relation Price Definition here] end
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
	static deepParse(data: string | { [K in keyof TariffDefinitionOtherComponentModel]?: TariffDefinitionOtherComponentModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TariffDefinitionOtherComponentModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.priceComponent) {
			currentModel.priceComponentId = json.priceComponent.id;
			returned = _.union(returned, PriceComponentModel.deepParse(json.priceComponent));
		}

		// Incoming one to many
		if (json.priceDefinition) {
			currentModel.priceDefinitionId = json.priceDefinition.id;
			returned = _.union(returned, TariffDefinitionModel.deepParse(json.priceDefinition));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let tariffDefinitionOtherComponentModel = new TariffDefinitionOtherComponentModel(data);`
	 *
	 * @param data The input data to be initialised as the TariffDefinitionOtherComponentModel,
	 *    it is expected as a JSON string or as a nullable TariffDefinitionOtherComponentModel.
	 */
	constructor(data?: string | Partial<TariffDefinitionOtherComponentModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TariffDefinitionOtherComponentModel>
				: data;

			this.price = json.price;
			this.priceComponentId = json.priceComponentId;
			this.priceComponent = json.priceComponent;
			this.priceDefinitionId = json.priceDefinitionId;
			this.priceDefinition = json.priceDefinition;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			price: this.price,
			priceComponentId: this.priceComponentId,
			priceDefinitionId: this.priceDefinitionId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TariffDefinitionOtherComponentModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TariffDefinitionOtherComponentModel {
		let newModelJson = this.toJSON();

		if (updates.price) {
			newModelJson.price = updates.price;
		}

		if (updates.priceComponentId) {
			newModelJson.priceComponentId = updates.priceComponentId;
		}

		if (updates.priceDefinitionId) {
			newModelJson.priceDefinitionId = updates.priceDefinitionId;
		}

		return new TariffDefinitionOtherComponentModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TariffDefinitionOtherComponentModel)) {
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
			'priceComponentId',
			'priceComponent',
			'priceDefinitionId',
			'priceDefinition',
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
		if (!this.priceComponent) {
			this.priceComponentId = null;
		} else {
			this.priceComponentId = this.priceComponent.id;
		}

		if (!this.priceDefinition) {
			this.priceDefinitionId = null;
		} else {
			this.priceDefinitionId = this.priceDefinition.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
