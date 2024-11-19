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
import {ExaminationItemModel} from '../examinationItem/examination_item.model';
import {ServiceModel} from '../service/service.model';
import {ServiceItemAssignmentModel} from '../serviceItemAssignment/service_item_assignment.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class ServiceItemModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'serviceItemCode',
		'serviceItemName',
		'classification',
		'applyToAllService',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'serviceItemCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ServiceItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ServiceItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Code of Service Item (Max Length: 50).
	 */
	serviceItemCode: string;

	/**
	 * Name of Service Item (Max Length: 250).
	 */
	serviceItemName: string;

	/**
	 * Classification, get the Code from Reference Data where Type=SVC_ITEM_CLS. (Max Length: 20 chars).
	 */
	classification: string;

	/**
	 * indicator whether the service Item is available to all services.
	 */
	applyToAllService: boolean = false;

	/**
	 * .
	 */
	coaCOGS: string;

	/**
	 * .
	 */
	coaSell: string;

	/**
	 * .
	 */
	coaInventory: string;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=6, example=Sally}.
	 */
	applyTo: ApplyToEnum;

	examinationItemsIds: string[] = [];

	examinationItems: ExaminationItemModel[];

	serviceItemAssignmentsIds: string[] = [];

	serviceItemAssignments: ServiceItemAssignmentModel[];

	servicesIds: string[] = [];

	services: ServiceModel[];

	modelPropGroups: { [s: string]: Group } = ServiceItemModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'serviceItemCode',
				// % protected region % [Set displayName for Service Item Code here] off begin
				displayName: 'Service Item Code',
				// % protected region % [Set displayName for Service Item Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Service Item Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Service Item Code here] end
				// % protected region % [Set isSensitive for Service Item Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Service Item Code here] end
				// % protected region % [Set readonly for Service Item Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Service Item Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Service Item Code here] off begin
					// % protected region % [Add other validators for Service Item Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Service Item Code here] off begin
				// % protected region % [Add any additional model attribute properties for Service Item Code here] end
			},
			{
				name: 'serviceItemName',
				// % protected region % [Set displayName for Service Item Name here] off begin
				displayName: 'Service Item Name',
				// % protected region % [Set displayName for Service Item Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Service Item Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Service Item Name here] end
				// % protected region % [Set isSensitive for Service Item Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Service Item Name here] end
				// % protected region % [Set readonly for Service Item Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Service Item Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Service Item Name here] off begin
					// % protected region % [Add other validators for Service Item Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Service Item Name here] off begin
				// % protected region % [Add any additional model attribute properties for Service Item Name here] end
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
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Classification here] off begin
					// % protected region % [Add other validators for Classification here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification here] off begin
				// % protected region % [Add any additional model attribute properties for Classification here] end
			},
			{
				name: 'applyToAllService',
				// % protected region % [Set displayName for Apply to all Service here] off begin
				displayName: 'Apply to all Service',
				// % protected region % [Set displayName for Apply to all Service here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Apply to all Service here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Apply to all Service here] end
				// % protected region % [Set isSensitive for Apply to all Service here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Apply to all Service here] end
				// % protected region % [Set readonly for Apply to all Service here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Apply to all Service here] end
				validators: [
					// % protected region % [Add other validators for Apply to all Service here] off begin
					// % protected region % [Add other validators for Apply to all Service here] end
				],
				// % protected region % [Add any additional model attribute properties for Apply to all Service here] off begin
				// % protected region % [Add any additional model attribute properties for Apply to all Service here] end
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
				name: 'coaCOGS',
				// % protected region % [Set displayName for COA COGS here] off begin
				displayName: 'COA COGS',
				// % protected region % [Set displayName for COA COGS here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for COA COGS here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for COA COGS here] end
				// % protected region % [Set isSensitive for COA COGS here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for COA COGS here] end
				// % protected region % [Set readonly for COA COGS here] off begin
				readOnly: false,
				// % protected region % [Set readonly for COA COGS here] end
				validators: [
					// % protected region % [Add other validators for COA COGS here] off begin
					// % protected region % [Add other validators for COA COGS here] end
				],
				// % protected region % [Add any additional model attribute properties for COA COGS here] off begin
				// % protected region % [Add any additional model attribute properties for COA COGS here] end
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
				name: 'coaInventory',
				// % protected region % [Set displayName for COA Inventory here] off begin
				displayName: 'COA Inventory',
				// % protected region % [Set displayName for COA Inventory here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for COA Inventory here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for COA Inventory here] end
				// % protected region % [Set isSensitive for COA Inventory here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for COA Inventory here] end
				// % protected region % [Set readonly for COA Inventory here] off begin
				readOnly: false,
				// % protected region % [Set readonly for COA Inventory here] end
				validators: [
					// % protected region % [Add other validators for COA Inventory here] off begin
					// % protected region % [Add other validators for COA Inventory here] end
				],
				// % protected region % [Add any additional model attribute properties for COA Inventory here] off begin
				// % protected region % [Add any additional model attribute properties for COA Inventory here] end
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
				id: 'examinationItems',
				type: ModelRelationType.MANY,
				name: 'examinationItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Examination Items here] off begin
				label: 'Examination Items',
				// % protected region % [Customise your 1-1 or 1-M label for Examination Items here] end
				entityName: 'ExaminationItemModel',
				// % protected region % [Customise your display name for Examination Items here] off begin
				displayName: 'itemCode',
				// % protected region % [Customise your display name for Examination Items here] end
				validators: [
					// % protected region % [Add other validators for Examination Items here] off begin
					// % protected region % [Add other validators for Examination Items here] end
				],
				// % protected region % [Add any additional field for relation Examination Items here] off begin
				// % protected region % [Add any additional field for relation Examination Items here] end
			},
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
				id: 'services',
				type: ModelRelationType.MANY,
				name: 'servicesIds',
				// % protected region % [Customise your label for Services here] off begin
				label: 'Services',
				// % protected region % [Customise your label for Services here] end
				entityName: 'ServiceModel',
				// % protected region % [Customise your display name for Services here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'serviceNumber',
				// % protected region % [Customise your display name for Services here] end
				validators: [
					// % protected region % [Add other validators for Services here] off begin
					// % protected region % [Add other validators for Services here] end
				],
				// % protected region % [Add any additional field for relation Services here] off begin
				// % protected region % [Add any additional field for relation Services here] end
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
				case 'serviceItemCode':
					break;
				case 'serviceItemName':
					break;
				case 'classification':
					break;
				case 'applyToAllService':
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
	static deepParse(data: string | { [K in keyof ServiceItemModel]?: ServiceItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ServiceItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.examinationItems) {
			currentModel.examinationItemsIds = json.examinationItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.examinationItems.map(model => ExaminationItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.serviceItemAssignments) {
			currentModel.serviceItemAssignmentsIds = json.serviceItemAssignments.map(model => model.id);
			returned = _.union(returned, _.flatten(json.serviceItemAssignments.map(model => ServiceItemAssignmentModel.deepParse(model))));
		}
		// Incoming many to many
		if (json.services) {
			currentModel.servicesIds = json.services.map(model => model.id);
			returned = _.union(returned, _.flatten(json.services.map(model => ServiceModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let serviceItemModel = new ServiceItemModel(data);`
	 *
	 * @param data The input data to be initialised as the ServiceItemModel,
	 *    it is expected as a JSON string or as a nullable ServiceItemModel.
	 */
	constructor(data?: string | Partial<ServiceItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ServiceItemModel>
				: data;

			this.serviceItemCode = json.serviceItemCode;
			this.serviceItemName = json.serviceItemName;
			this.classification = json.classification;
			this.applyToAllService = json.applyToAllService;
			this.applyTo = json.applyTo;
			this.coaCOGS = json.coaCOGS;
			this.coaSell = json.coaSell;
			this.coaInventory = json.coaInventory;
			this.applyTo = json.applyTo;
			this.examinationItemsIds = json.examinationItemsIds;
			this.examinationItems = json.examinationItems;
			this.serviceItemAssignmentsIds = json.serviceItemAssignmentsIds;
			this.serviceItemAssignments = json.serviceItemAssignments;
			this.servicesIds = json.servicesIds;
			this.services = json.services;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			serviceItemCode: this.serviceItemCode,
			serviceItemName: this.serviceItemName,
			classification: this.classification,
			applyToAllService: this.applyToAllService,
			applyTo: this.applyTo,
			coaCOGS: this.coaCOGS,
			coaSell: this.coaSell,
			coaInventory: this.coaInventory,
			examinationItemsIds: this.examinationItemsIds,
			serviceItemAssignmentsIds: this.serviceItemAssignmentsIds,
			servicesIds: this.servicesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ServiceItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ServiceItemModel {
		let newModelJson = this.toJSON();

		if (updates.serviceItemCode) {
			newModelJson.serviceItemCode = updates.serviceItemCode;
		}

		if (updates.serviceItemName) {
			newModelJson.serviceItemName = updates.serviceItemName;
		}

		if (updates.classification) {
			newModelJson.classification = updates.classification;
		}

		if (updates.applyToAllService) {
			newModelJson.applyToAllService = updates.applyToAllService;
		}

		if (updates.applyTo) {
			newModelJson.applyTo = updates.applyTo;
		}

		if (updates.coaCOGS) {
			newModelJson.coaCOGS = updates.coaCOGS;
		}

		if (updates.coaSell) {
			newModelJson.coaSell = updates.coaSell;
		}

		if (updates.coaInventory) {
			newModelJson.coaInventory = updates.coaInventory;
		}

		if (updates.applyTo) {
			newModelJson.applyTo = updates.applyTo;
		}

		if (updates.examinationItemsIds) {
			newModelJson.examinationItemsIds = updates.examinationItemsIds;
		}

		if (updates.serviceItemAssignmentsIds) {
			newModelJson.serviceItemAssignmentsIds = updates.serviceItemAssignmentsIds;
		}

		if (updates.servicesIds) {
			newModelJson.servicesIds = updates.servicesIds;
		}

		return new ServiceItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ServiceItemModel)) {
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
			'examinationItemsIds',
			'examinationItems',
			'serviceItemAssignmentsIds',
			'serviceItemAssignments',
			'servicesIds',
			'services',
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
