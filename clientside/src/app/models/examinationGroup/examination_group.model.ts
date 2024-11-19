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
import {ExaminationItemModel} from '../examinationItem/examination_item.model';
import {ServiceModel} from '../service/service.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class ExaminationGroupModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'diagnosticGroupCode',
		'description',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'diagnosticGroupCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ExaminationGroupModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ExaminationGroupModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Identifier of diagnostic group (Max Length: 50).
	 */
	diagnosticGroupCode: string;

	/**
	 * Name of Diagnostic Group (Max Length: 250).
	 */
	description: string;

	/**
	 * The order/sequence on displaying the examination Group.
	 */
	sequence: number;

	serviceId: string;

	service: ServiceModel;

	examinationItemsIds: string[] = [];

	examinationItems: ExaminationItemModel[];

	modelPropGroups: { [s: string]: Group } = ExaminationGroupModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'diagnosticGroupCode',
				// % protected region % [Set displayName for Diagnostic Group Code here] off begin
				displayName: 'Diagnostic Group Code',
				// % protected region % [Set displayName for Diagnostic Group Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Diagnostic Group Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Diagnostic Group Code here] end
				// % protected region % [Set isSensitive for Diagnostic Group Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diagnostic Group Code here] end
				// % protected region % [Set readonly for Diagnostic Group Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diagnostic Group Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Diagnostic Group Code here] off begin
					// % protected region % [Add other validators for Diagnostic Group Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Diagnostic Group Code here] off begin
				// % protected region % [Add any additional model attribute properties for Diagnostic Group Code here] end
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
				id: 'service',
				type: ModelRelationType.ONE,
				name: 'serviceId',
				// % protected region % [Customise your label for Service here] off begin
				label: 'Service',
				// % protected region % [Customise your label for Service here] end
				entityName: 'ServiceModel',
				// % protected region % [Customise your display name for Service here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'serviceNumber',
				// % protected region % [Customise your display name for Service here] end
				validators: [
					// % protected region % [Add other validators for Service here] off begin
					// % protected region % [Add other validators for Service here] end
				],
				// % protected region % [Add any additional field for relation Service here] off begin
				// % protected region % [Add any additional field for relation Service here] end
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
				case 'diagnosticGroupCode':
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
	static deepParse(data: string | { [K in keyof ExaminationGroupModel]?: ExaminationGroupModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ExaminationGroupModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.service) {
			currentModel.serviceId = json.service.id;
			returned = _.union(returned, ServiceModel.deepParse(json.service));
		}

		// Outgoing one to many
		if (json.examinationItems) {
			currentModel.examinationItemsIds = json.examinationItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.examinationItems.map(model => ExaminationItemModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let examinationGroupModel = new ExaminationGroupModel(data);`
	 *
	 * @param data The input data to be initialised as the ExaminationGroupModel,
	 *    it is expected as a JSON string or as a nullable ExaminationGroupModel.
	 */
	constructor(data?: string | Partial<ExaminationGroupModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ExaminationGroupModel>
				: data;

			this.diagnosticGroupCode = json.diagnosticGroupCode;
			this.description = json.description;
			this.sequence = json.sequence;
			this.serviceId = json.serviceId;
			this.service = json.service;
			this.examinationItemsIds = json.examinationItemsIds;
			this.examinationItems = json.examinationItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			diagnosticGroupCode: this.diagnosticGroupCode,
			description: this.description,
			sequence: this.sequence,
			serviceId: this.serviceId,
			examinationItemsIds: this.examinationItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ExaminationGroupModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ExaminationGroupModel {
		let newModelJson = this.toJSON();

		if (updates.diagnosticGroupCode) {
			newModelJson.diagnosticGroupCode = updates.diagnosticGroupCode;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.sequence) {
			newModelJson.sequence = updates.sequence;
		}

		if (updates.serviceId) {
			newModelJson.serviceId = updates.serviceId;
		}

		if (updates.examinationItemsIds) {
			newModelJson.examinationItemsIds = updates.examinationItemsIds;
		}

		return new ExaminationGroupModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ExaminationGroupModel)) {
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
			'serviceId',
			'service',
			'examinationItemsIds',
			'examinationItems',
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
		if (!this.service) {
			this.serviceId = null;
		} else {
			this.serviceId = this.service.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
