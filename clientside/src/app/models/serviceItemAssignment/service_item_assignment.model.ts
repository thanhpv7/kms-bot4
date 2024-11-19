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
import {ServiceItemModel} from '../serviceItem/service_item.model';
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
export class ServiceItemAssignmentModel extends AbstractModel {
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
		'assignCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ServiceItemAssignmentModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ServiceItemAssignmentModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Refer to assignment code Section or Service, based on Apply To. The reference refers to: Reference Code if the Apply To is SECTION, or Service entity if the Apply To is SERVICE.
	 */
	assignCode: string;

	serviceItemId: string;

	serviceItem: ServiceItemModel;

	tariffPackageId: string;

	tariffPackage: TariffPackageModel;

	modelPropGroups: { [s: string]: Group } = ServiceItemAssignmentModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'assignCode',
				// % protected region % [Set displayName for Assign Code here] off begin
				displayName: 'Assign Code',
				// % protected region % [Set displayName for Assign Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Assign Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Assign Code here] end
				// % protected region % [Set isSensitive for Assign Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Assign Code here] end
				// % protected region % [Set readonly for Assign Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Assign Code here] end
				validators: [
					// % protected region % [Add other validators for Assign Code here] off begin
					// % protected region % [Add other validators for Assign Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Assign Code here] off begin
				// % protected region % [Add any additional model attribute properties for Assign Code here] end
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
				id: 'serviceItem',
				type: ModelRelationType.ONE,
				name: 'serviceItemId',
				// % protected region % [Customise your label for Service Item here] off begin
				label: 'Service Item',
				// % protected region % [Customise your label for Service Item here] end
				entityName: 'ServiceItemModel',
				// % protected region % [Customise your display name for Service Item here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'serviceItemCode',
				// % protected region % [Customise your display name for Service Item here] end
				validators: [
					// % protected region % [Add other validators for Service Item here] off begin
					// % protected region % [Add other validators for Service Item here] end
				],
				// % protected region % [Add any additional field for relation Service Item here] off begin
				// % protected region % [Add any additional field for relation Service Item here] end
			},
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
	static deepParse(data: string | { [K in keyof ServiceItemAssignmentModel]?: ServiceItemAssignmentModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ServiceItemAssignmentModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.serviceItem) {
			currentModel.serviceItemId = json.serviceItem.id;
			returned = _.union(returned, ServiceItemModel.deepParse(json.serviceItem));
		}

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
	 * `let serviceItemAssignmentModel = new ServiceItemAssignmentModel(data);`
	 *
	 * @param data The input data to be initialised as the ServiceItemAssignmentModel,
	 *    it is expected as a JSON string or as a nullable ServiceItemAssignmentModel.
	 */
	constructor(data?: string | Partial<ServiceItemAssignmentModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ServiceItemAssignmentModel>
				: data;

			this.assignCode = json.assignCode;
			this.serviceItemId = json.serviceItemId;
			this.serviceItem = json.serviceItem;
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
			assignCode: this.assignCode,
			serviceItemId: this.serviceItemId,
			tariffPackageId: this.tariffPackageId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ServiceItemAssignmentModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ServiceItemAssignmentModel {
		let newModelJson = this.toJSON();

		if (updates.assignCode) {
			newModelJson.assignCode = updates.assignCode;
		}

		if (updates.serviceItemId) {
			newModelJson.serviceItemId = updates.serviceItemId;
		}

		if (updates.tariffPackageId) {
			newModelJson.tariffPackageId = updates.tariffPackageId;
		}

		return new ServiceItemAssignmentModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ServiceItemAssignmentModel)) {
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
			'serviceItemId',
			'serviceItem',
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
		if (!this.serviceItem) {
			this.serviceItemId = null;
		} else {
			this.serviceItemId = this.serviceItem.id;
		}

		if (!this.tariffPackage) {
			this.tariffPackageId = null;
		} else {
			this.tariffPackageId = this.tariffPackage.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
