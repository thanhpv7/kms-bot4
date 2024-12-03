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
import {ApplyToEnum, applyToEnumArray} from '../../enums/apply-to.enum';
import {ServiceItemAssignmentModel} from '../serviceItemAssignment/service_item_assignment.model';
import {TariffPackageItemModel} from '../tariffPackageItem/tariff_package_item.model';
import {TariffPackageServiceAssignmentModel} from '../tariffPackageServiceAssignment/tariff_package_service_assignment.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class TariffPackageModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'tariffPackageName',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'tariffPackageCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'TariffPackageModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return TariffPackageModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	tariffPackageCode: string;

	/**
	 * .
	 */
	tariffPackageName: string;

	/**
	 * .
	 */
	tariffPackageClassification: string;

	/**
	 * Sales Account.
	 */
	coaSell: string;

	/**
	 * .
	 */
	tariffPackageDescription: string;

	/**
	 * .
	 */
	applyToAllServices: boolean = false;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=7, example=Sally}.
	 */
	applyTo: ApplyToEnum;

	serviceItemAssignmentsIds: string[] = [];

	serviceItemAssignments: ServiceItemAssignmentModel[];

	tariffPackageItemsIds: string[] = [];

	tariffPackageItems: TariffPackageItemModel[];

	tariffPackageServiceAssignmentsIds: string[] = [];

	tariffPackageServiceAssignments: TariffPackageServiceAssignmentModel[];

	modelPropGroups: { [s: string]: Group } = TariffPackageModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'tariffPackageCode',
				// % protected region % [Set displayName for Tariff Package Code here] off begin
				displayName: 'Tariff Package Code',
				// % protected region % [Set displayName for Tariff Package Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tariff Package Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tariff Package Code here] end
				// % protected region % [Set isSensitive for Tariff Package Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff Package Code here] end
				// % protected region % [Set readonly for Tariff Package Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff Package Code here] end
				validators: [
					// % protected region % [Add other validators for Tariff Package Code here] off begin
					// % protected region % [Add other validators for Tariff Package Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Package Code here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Package Code here] end
			},
			{
				name: 'tariffPackageName',
				// % protected region % [Set displayName for Tariff Package Name here] off begin
				displayName: 'Tariff Package Name',
				// % protected region % [Set displayName for Tariff Package Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tariff Package Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tariff Package Name here] end
				// % protected region % [Set isSensitive for Tariff Package Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff Package Name here] end
				// % protected region % [Set readonly for Tariff Package Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff Package Name here] end
				validators: [
					// % protected region % [Add other validators for Tariff Package Name here] off begin
					// % protected region % [Add other validators for Tariff Package Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Package Name here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Package Name here] end
			},
			{
				name: 'tariffPackageClassification',
				// % protected region % [Set displayName for Tariff Package Classification here] off begin
				displayName: 'Tariff Package Classification',
				// % protected region % [Set displayName for Tariff Package Classification here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tariff Package Classification here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tariff Package Classification here] end
				// % protected region % [Set isSensitive for Tariff Package Classification here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff Package Classification here] end
				// % protected region % [Set readonly for Tariff Package Classification here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff Package Classification here] end
				validators: [
					// % protected region % [Add other validators for Tariff Package Classification here] off begin
					// % protected region % [Add other validators for Tariff Package Classification here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Package Classification here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Package Classification here] end
			},
			{
				name: 'coaSell',
				// % protected region % [Set displayName for COA Sell here] off begin
				displayName: 'COA Sell',
				// % protected region % [Set displayName for COA Sell here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for COA Sell here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for COA Sell here] end
				// % protected region % [Set isSensitive for COA Sell here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for COA Sell here] end
				// % protected region % [Set readonly for COA Sell here] off begin
				readOnly: false,
				// % protected region % [Set readonly for COA Sell here] end
				validators: [
					// % protected region % [Add other validators for COA Sell here] off begin
					// % protected region % [Add other validators for COA Sell here] end
				],
				// % protected region % [Add any additional model attribute properties for COA Sell here] off begin
				// % protected region % [Add any additional model attribute properties for COA Sell here] end
			},
			{
				name: 'tariffPackageDescription',
				// % protected region % [Set displayName for Tariff Package Description here] off begin
				displayName: 'Tariff Package Description',
				// % protected region % [Set displayName for Tariff Package Description here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tariff Package Description here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tariff Package Description here] end
				// % protected region % [Set isSensitive for Tariff Package Description here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tariff Package Description here] end
				// % protected region % [Set readonly for Tariff Package Description here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tariff Package Description here] end
				validators: [
					// % protected region % [Add other validators for Tariff Package Description here] off begin
					// % protected region % [Add other validators for Tariff Package Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Tariff Package Description here] off begin
				// % protected region % [Add any additional model attribute properties for Tariff Package Description here] end
			},
			{
				name: 'applyTo',
				// % protected region % [Set displayName for Apply To here] off begin
				displayName: 'Apply To',
				// % protected region % [Set displayName for Apply To here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: applyToEnumArray,
				// % protected region % [Set display element type for Apply To here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Apply To here] end
				// % protected region % [Set isSensitive for Apply To here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Apply To here] end
				// % protected region % [Set readonly for Apply To here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Apply To here] end
				validators: [
					// % protected region % [Add other validators for Apply To here] off begin
					// % protected region % [Add other validators for Apply To here] end
				],
				// % protected region % [Add any additional model attribute properties for Apply To here] off begin
				// % protected region % [Add any additional model attribute properties for Apply To here] end
			},
			{
				name: 'applyToAllServices',
				// % protected region % [Set displayName for Apply To All Services here] off begin
				displayName: 'Apply To All Services',
				// % protected region % [Set displayName for Apply To All Services here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Apply To All Services here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Apply To All Services here] end
				// % protected region % [Set isSensitive for Apply To All Services here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Apply To All Services here] end
				// % protected region % [Set readonly for Apply To All Services here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Apply To All Services here] end
				validators: [
					// % protected region % [Add other validators for Apply To All Services here] off begin
					// % protected region % [Add other validators for Apply To All Services here] end
				],
				// % protected region % [Add any additional model attribute properties for Apply To All Services here] off begin
				// % protected region % [Add any additional model attribute properties for Apply To All Services here] end
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
				id: 'serviceItemAssignments',
				type: ModelRelationType.MANY,
				name: 'serviceItemAssignmentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Service Item Assignments here] off begin
				label: 'Service Item Assignments',
				// % protected region % [Customise your 1-1 or 1-M label for Service Item Assignments here] end
				entityName: 'ServiceItemAssignmentModel',
				// % protected region % [Customise your display name for Service Item Assignments here] off begin
				displayName: 'assignCode',
				// % protected region % [Customise your display name for Service Item Assignments here] end
				validators: [
					// % protected region % [Add other validators for Service Item Assignments here] off begin
					// % protected region % [Add other validators for Service Item Assignments here] end
				],
				// % protected region % [Add any additional field for relation Service Item Assignments here] off begin
				// % protected region % [Add any additional field for relation Service Item Assignments here] end
			},
			{
				id: 'tariffPackageItems',
				type: ModelRelationType.MANY,
				name: 'tariffPackageItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Package Items here] off begin
				label: 'Tariff Package Items',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Package Items here] end
				entityName: 'TariffPackageItemModel',
				// % protected region % [Customise your display name for Tariff Package Items here] off begin
				displayName: 'tariffType',
				// % protected region % [Customise your display name for Tariff Package Items here] end
				validators: [
					// % protected region % [Add other validators for Tariff Package Items here] off begin
					// % protected region % [Add other validators for Tariff Package Items here] end
				],
				// % protected region % [Add any additional field for relation Tariff Package Items here] off begin
				// % protected region % [Add any additional field for relation Tariff Package Items here] end
			},
			{
				id: 'tariffPackageServiceAssignments',
				type: ModelRelationType.MANY,
				name: 'tariffPackageServiceAssignmentsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Package Service Assignments here] off begin
				label: 'Tariff Package Service Assignments',
				// % protected region % [Customise your 1-1 or 1-M label for Tariff Package Service Assignments here] end
				entityName: 'TariffPackageServiceAssignmentModel',
				// % protected region % [Customise your display name for Tariff Package Service Assignments here] off begin
				displayName: 'assignCode',
				// % protected region % [Customise your display name for Tariff Package Service Assignments here] end
				validators: [
					// % protected region % [Add other validators for Tariff Package Service Assignments here] off begin
					// % protected region % [Add other validators for Tariff Package Service Assignments here] end
				],
				// % protected region % [Add any additional field for relation Tariff Package Service Assignments here] off begin
				// % protected region % [Add any additional field for relation Tariff Package Service Assignments here] end
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
				case 'tariffPackageName':
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
	static deepParse(data: string | { [K in keyof TariffPackageModel]?: TariffPackageModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new TariffPackageModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.serviceItemAssignments) {
			currentModel.serviceItemAssignmentsIds = json.serviceItemAssignments.map(model => model.id);
			returned = _.union(returned, _.flatten(json.serviceItemAssignments.map(model => ServiceItemAssignmentModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.tariffPackageItems) {
			currentModel.tariffPackageItemsIds = json.tariffPackageItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.tariffPackageItems.map(model => TariffPackageItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.tariffPackageServiceAssignments) {
			currentModel.tariffPackageServiceAssignmentsIds = json.tariffPackageServiceAssignments.map(model => model.id);
			returned = _.union(returned, _.flatten(json.tariffPackageServiceAssignments.map(model => TariffPackageServiceAssignmentModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let tariffPackageModel = new TariffPackageModel(data);`
	 *
	 * @param data The input data to be initialised as the TariffPackageModel,
	 *    it is expected as a JSON string or as a nullable TariffPackageModel.
	 */
	constructor(data?: string | Partial<TariffPackageModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<TariffPackageModel>
				: data;

			this.tariffPackageCode = json.tariffPackageCode;
			this.tariffPackageName = json.tariffPackageName;
			this.tariffPackageClassification = json.tariffPackageClassification;
			this.coaSell = json.coaSell;
			this.tariffPackageDescription = json.tariffPackageDescription;
			this.applyTo = json.applyTo;
			this.applyToAllServices = json.applyToAllServices;
			this.applyTo = json.applyTo;
			this.serviceItemAssignmentsIds = json.serviceItemAssignmentsIds;
			this.serviceItemAssignments = json.serviceItemAssignments;
			this.tariffPackageItemsIds = json.tariffPackageItemsIds;
			this.tariffPackageItems = json.tariffPackageItems;
			this.tariffPackageServiceAssignmentsIds = json.tariffPackageServiceAssignmentsIds;
			this.tariffPackageServiceAssignments = json.tariffPackageServiceAssignments;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			tariffPackageCode: this.tariffPackageCode,
			tariffPackageName: this.tariffPackageName,
			tariffPackageClassification: this.tariffPackageClassification,
			coaSell: this.coaSell,
			tariffPackageDescription: this.tariffPackageDescription,
			applyTo: this.applyTo,
			applyToAllServices: this.applyToAllServices,
			serviceItemAssignmentsIds: this.serviceItemAssignmentsIds,
			tariffPackageItemsIds: this.tariffPackageItemsIds,
			tariffPackageServiceAssignmentsIds: this.tariffPackageServiceAssignmentsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		TariffPackageModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): TariffPackageModel {
		let newModelJson = this.toJSON();

		if (updates.tariffPackageCode) {
			newModelJson.tariffPackageCode = updates.tariffPackageCode;
		}

		if (updates.tariffPackageName) {
			newModelJson.tariffPackageName = updates.tariffPackageName;
		}

		if (updates.tariffPackageClassification) {
			newModelJson.tariffPackageClassification = updates.tariffPackageClassification;
		}

		if (updates.coaSell) {
			newModelJson.coaSell = updates.coaSell;
		}

		if (updates.tariffPackageDescription) {
			newModelJson.tariffPackageDescription = updates.tariffPackageDescription;
		}

		if (updates.applyTo) {
			newModelJson.applyTo = updates.applyTo;
		}

		if (updates.applyToAllServices) {
			newModelJson.applyToAllServices = updates.applyToAllServices;
		}

		if (updates.applyTo) {
			newModelJson.applyTo = updates.applyTo;
		}

		if (updates.serviceItemAssignmentsIds) {
			newModelJson.serviceItemAssignmentsIds = updates.serviceItemAssignmentsIds;
		}

		if (updates.tariffPackageItemsIds) {
			newModelJson.tariffPackageItemsIds = updates.tariffPackageItemsIds;
		}

		if (updates.tariffPackageServiceAssignmentsIds) {
			newModelJson.tariffPackageServiceAssignmentsIds = updates.tariffPackageServiceAssignmentsIds;
		}

		return new TariffPackageModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof TariffPackageModel)) {
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
			'serviceItemAssignmentsIds',
			'serviceItemAssignments',
			'tariffPackageItemsIds',
			'tariffPackageItems',
			'tariffPackageServiceAssignmentsIds',
			'tariffPackageServiceAssignments',
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
