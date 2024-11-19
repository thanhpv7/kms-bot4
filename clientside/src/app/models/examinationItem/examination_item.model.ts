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
import {DiagnosticExaminationResultsModel} from '../diagnosticExaminationResults/diagnostic_examination_results.model';
import {ExaminationGroupModel} from '../examinationGroup/examination_group.model';
import {ExaminationItemDetailModel} from '../examinationItemDetail/examination_item_detail.model';
import {McuPackageItemModel} from '../mcuPackageItem/mcu_package_item.model';
import {RegistrationModel} from '../registration/registration.model';
import {ServiceItemModel} from '../serviceItem/service_item.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class ExaminationItemModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'itemCode',
		'description',
		'examinationLevel',
		'examinationType',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'itemCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ExaminationItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ExaminationItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Identifier of diagnostic item  (Max Length: 50).
	 */
	itemCode: string;

	/**
	 * Name of diagnostic  item (Max Length: 250).
	 */
	description: string;

	/**
	 * Sample, get the Code from Reference Data where Type=DIAG_EXAM_SAMPLE. (Max Length: 20).
	 */
	sample: string;

	/**
	 * Examination Level, get the Code from Reference Data where Type=DIAG_EXAM_LEVEL. (Max Length: 20).
	 */
	examinationLevel: string;

	/**
	 * Examination Type, get the Code from Reference Data where Type=DIAG_EXAM_TYPE. (Max Length: 20).
	 */
	examinationType: string;

	examinationGroupId: string;

	examinationGroup: ExaminationGroupModel;

	serviceItemId: string;

	serviceItem: ServiceItemModel;

	diagnosticExaminationResultsIds: string[] = [];

	diagnosticExaminationResults: DiagnosticExaminationResultsModel[];

	examinationItemDetailsIds: string[] = [];

	examinationItemDetails: ExaminationItemDetailModel[];

	examinationItemOfMCUItemIds: string[] = [];

	examinationItemOfMCUItem: McuPackageItemModel[];

	registrationsIds: string[] = [];

	registrations: RegistrationModel[];

	modelPropGroups: { [s: string]: Group } = ExaminationItemModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'itemCode',
				// % protected region % [Set displayName for Item Code here] off begin
				displayName: 'Item Code',
				// % protected region % [Set displayName for Item Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Item Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Item Code here] end
				// % protected region % [Set isSensitive for Item Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Item Code here] end
				// % protected region % [Set readonly for Item Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Item Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Item Code here] off begin
					// % protected region % [Add other validators for Item Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Item Code here] off begin
				// % protected region % [Add any additional model attribute properties for Item Code here] end
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
				name: 'sample',
				// % protected region % [Set displayName for Sample here] off begin
				displayName: 'Sample',
				// % protected region % [Set displayName for Sample here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sample here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sample here] end
				// % protected region % [Set isSensitive for Sample here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sample here] end
				// % protected region % [Set readonly for Sample here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sample here] end
				validators: [
					// % protected region % [Add other validators for Sample here] off begin
					// % protected region % [Add other validators for Sample here] end
				],
				// % protected region % [Add any additional model attribute properties for Sample here] off begin
				// % protected region % [Add any additional model attribute properties for Sample here] end
			},
			{
				name: 'examinationLevel',
				// % protected region % [Set displayName for Examination Level here] off begin
				displayName: 'Examination Level',
				// % protected region % [Set displayName for Examination Level here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Examination Level here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Examination Level here] end
				// % protected region % [Set isSensitive for Examination Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Examination Level here] end
				// % protected region % [Set readonly for Examination Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Examination Level here] end
				validators: [
					// % protected region % [Add other validators for Examination Level here] off begin
					// % protected region % [Add other validators for Examination Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Examination Level here] off begin
				// % protected region % [Add any additional model attribute properties for Examination Level here] end
			},
			{
				name: 'examinationType',
				// % protected region % [Set displayName for Examination Type here] off begin
				displayName: 'Examination Type',
				// % protected region % [Set displayName for Examination Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Examination Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Examination Type here] end
				// % protected region % [Set isSensitive for Examination Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Examination Type here] end
				// % protected region % [Set readonly for Examination Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Examination Type here] end
				validators: [
					// % protected region % [Add other validators for Examination Type here] off begin
					// % protected region % [Add other validators for Examination Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Examination Type here] off begin
				// % protected region % [Add any additional model attribute properties for Examination Type here] end
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
				id: 'diagnosticExaminationResults',
				type: ModelRelationType.MANY,
				name: 'diagnosticExaminationResultsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnostic Examination Results here] off begin
				label: 'Diagnostic Examination Results',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnostic Examination Results here] end
				entityName: 'DiagnosticExaminationResultsModel',
				// % protected region % [Customise your display name for Diagnostic Examination Results here] off begin
				displayName: 'result',
				// % protected region % [Customise your display name for Diagnostic Examination Results here] end
				validators: [
					// % protected region % [Add other validators for Diagnostic Examination Results here] off begin
					// % protected region % [Add other validators for Diagnostic Examination Results here] end
				],
				// % protected region % [Add any additional field for relation Diagnostic Examination Results here] off begin
				// % protected region % [Add any additional field for relation Diagnostic Examination Results here] end
			},
			{
				id: 'examinationItemDetails',
				type: ModelRelationType.MANY,
				name: 'examinationItemDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Examination Item Details here] off begin
				label: 'Examination Item Details',
				// % protected region % [Customise your 1-1 or 1-M label for Examination Item Details here] end
				entityName: 'ExaminationItemDetailModel',
				// % protected region % [Customise your display name for Examination Item Details here] off begin
				displayName: 'ageMinimum',
				// % protected region % [Customise your display name for Examination Item Details here] end
				validators: [
					// % protected region % [Add other validators for Examination Item Details here] off begin
					// % protected region % [Add other validators for Examination Item Details here] end
				],
				// % protected region % [Add any additional field for relation Examination Item Details here] off begin
				// % protected region % [Add any additional field for relation Examination Item Details here] end
			},
			{
				id: 'examinationItemOfMCUItem',
				type: ModelRelationType.MANY,
				name: 'examinationItemOfMCUItemIds',
				// % protected region % [Customise your 1-1 or 1-M label for Examination Item of MCU Item here] off begin
				label: 'Examination Item of MCU Item',
				// % protected region % [Customise your 1-1 or 1-M label for Examination Item of MCU Item here] end
				entityName: 'McuPackageItemModel',
				// % protected region % [Customise your display name for Examination Item of MCU Item here] off begin
				displayName: 'itemCode',
				// % protected region % [Customise your display name for Examination Item of MCU Item here] end
				validators: [
					// % protected region % [Add other validators for Examination Item of MCU Item here] off begin
					// % protected region % [Add other validators for Examination Item of MCU Item here] end
				],
				// % protected region % [Add any additional field for relation Examination Item of MCU Item here] off begin
				// % protected region % [Add any additional field for relation Examination Item of MCU Item here] end
			},
			{
				id: 'registrations',
				type: ModelRelationType.MANY,
				name: 'registrationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Registrations here] off begin
				label: 'Registrations',
				// % protected region % [Customise your 1-1 or 1-M label for Registrations here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registrations here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registrations here] end
				validators: [
					// % protected region % [Add other validators for Registrations here] off begin
					// % protected region % [Add other validators for Registrations here] end
				],
				// % protected region % [Add any additional field for relation Registrations here] off begin
				// % protected region % [Add any additional field for relation Registrations here] end
			},
			{
				id: 'examinationGroup',
				type: ModelRelationType.ONE,
				name: 'examinationGroupId',
				// % protected region % [Customise your label for Examination Group here] off begin
				label: 'Examination Group',
				// % protected region % [Customise your label for Examination Group here] end
				entityName: 'ExaminationGroupModel',
				// % protected region % [Customise your display name for Examination Group here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'diagnosticGroupCode',
				// % protected region % [Customise your display name for Examination Group here] end
				validators: [
					// % protected region % [Add other validators for Examination Group here] off begin
					// % protected region % [Add other validators for Examination Group here] end
				],
				// % protected region % [Add any additional field for relation Examination Group here] off begin
				// % protected region % [Add any additional field for relation Examination Group here] end
			},
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
				case 'itemCode':
					break;
				case 'description':
					break;
				case 'examinationLevel':
					break;
				case 'examinationType':
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
	static deepParse(data: string | { [K in keyof ExaminationItemModel]?: ExaminationItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ExaminationItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.examinationGroup) {
			currentModel.examinationGroupId = json.examinationGroup.id;
			returned = _.union(returned, ExaminationGroupModel.deepParse(json.examinationGroup));
		}

		// Incoming one to many
		if (json.serviceItem) {
			currentModel.serviceItemId = json.serviceItem.id;
			returned = _.union(returned, ServiceItemModel.deepParse(json.serviceItem));
		}

		// Outgoing one to many
		if (json.diagnosticExaminationResults) {
			currentModel.diagnosticExaminationResultsIds = json.diagnosticExaminationResults.map(model => model.id);
			returned = _.union(returned, _.flatten(json.diagnosticExaminationResults.map(model => DiagnosticExaminationResultsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.examinationItemDetails) {
			currentModel.examinationItemDetailsIds = json.examinationItemDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.examinationItemDetails.map(model => ExaminationItemDetailModel.deepParse(model))));
		}
		// Outgoing many to many
		if (json.examinationItemOfMCUItem) {
			currentModel.examinationItemOfMCUItemIds = json.examinationItemOfMCUItem.map(model => model.id);
			returned = _.union(returned, _.flatten(json.examinationItemOfMCUItem.map(model => McuPackageItemModel.deepParse(model))));
		}
		// Outgoing many to many
		if (json.registrations) {
			currentModel.registrationsIds = json.registrations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.registrations.map(model => RegistrationModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let examinationItemModel = new ExaminationItemModel(data);`
	 *
	 * @param data The input data to be initialised as the ExaminationItemModel,
	 *    it is expected as a JSON string or as a nullable ExaminationItemModel.
	 */
	constructor(data?: string | Partial<ExaminationItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ExaminationItemModel>
				: data;

			this.itemCode = json.itemCode;
			this.description = json.description;
			this.sample = json.sample;
			this.examinationLevel = json.examinationLevel;
			this.examinationType = json.examinationType;
			this.examinationGroupId = json.examinationGroupId;
			this.examinationGroup = json.examinationGroup;
			this.serviceItemId = json.serviceItemId;
			this.serviceItem = json.serviceItem;
			this.diagnosticExaminationResultsIds = json.diagnosticExaminationResultsIds;
			this.diagnosticExaminationResults = json.diagnosticExaminationResults;
			this.examinationItemDetailsIds = json.examinationItemDetailsIds;
			this.examinationItemDetails = json.examinationItemDetails;
			this.examinationItemOfMCUItemIds = json.examinationItemOfMCUItemIds;
			this.examinationItemOfMCUItem = json.examinationItemOfMCUItem;
			this.registrationsIds = json.registrationsIds;
			this.registrations = json.registrations;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			itemCode: this.itemCode,
			description: this.description,
			sample: this.sample,
			examinationLevel: this.examinationLevel,
			examinationType: this.examinationType,
			examinationGroupId: this.examinationGroupId,
			serviceItemId: this.serviceItemId,
			diagnosticExaminationResultsIds: this.diagnosticExaminationResultsIds,
			examinationItemDetailsIds: this.examinationItemDetailsIds,
			examinationItemOfMCUItemIds: this.examinationItemOfMCUItemIds,
			registrationsIds: this.registrationsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ExaminationItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ExaminationItemModel {
		let newModelJson = this.toJSON();

		if (updates.itemCode) {
			newModelJson.itemCode = updates.itemCode;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.sample) {
			newModelJson.sample = updates.sample;
		}

		if (updates.examinationLevel) {
			newModelJson.examinationLevel = updates.examinationLevel;
		}

		if (updates.examinationType) {
			newModelJson.examinationType = updates.examinationType;
		}

		if (updates.examinationGroupId) {
			newModelJson.examinationGroupId = updates.examinationGroupId;
		}

		if (updates.serviceItemId) {
			newModelJson.serviceItemId = updates.serviceItemId;
		}

		if (updates.diagnosticExaminationResultsIds) {
			newModelJson.diagnosticExaminationResultsIds = updates.diagnosticExaminationResultsIds;
		}

		if (updates.examinationItemDetailsIds) {
			newModelJson.examinationItemDetailsIds = updates.examinationItemDetailsIds;
		}

		if (updates.examinationItemOfMCUItemIds) {
			newModelJson.examinationItemOfMCUItemIds = updates.examinationItemOfMCUItemIds;
		}

		if (updates.registrationsIds) {
			newModelJson.registrationsIds = updates.registrationsIds;
		}

		return new ExaminationItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ExaminationItemModel)) {
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
			'examinationGroupId',
			'examinationGroup',
			'serviceItemId',
			'serviceItem',
			'diagnosticExaminationResultsIds',
			'diagnosticExaminationResults',
			'examinationItemDetailsIds',
			'examinationItemDetails',
			'examinationItemOfMCUItemIds',
			'examinationItemOfMCUItem',
			'registrationsIds',
			'registrations',
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
		if (!this.examinationGroup) {
			this.examinationGroupId = null;
		} else {
			this.examinationGroupId = this.examinationGroup.id;
		}

		if (!this.serviceItem) {
			this.serviceItemId = null;
		} else {
			this.serviceItemId = this.serviceItem.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
