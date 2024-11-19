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
export class BpjsListTaskModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'kodebooking',
		'taskname',
		'taskid',
		'waktu',
		'wakturs',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'kodebooking',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsListTaskModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsListTaskModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	kodebooking: string;

	/**
	 * .
	 */
	taskname: string;

	/**
	 * .
	 */
	taskid: number;

	/**
	 * .
	 */
	waktu: string;

	/**
	 * .
	 */
	wakturs: string;



	modelPropGroups: { [s: string]: Group } = BpjsListTaskModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'kodebooking',
				// % protected region % [Set displayName for Kodebooking here] off begin
				displayName: 'Kodebooking',
				// % protected region % [Set displayName for Kodebooking here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kodebooking here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kodebooking here] end
				// % protected region % [Set isSensitive for Kodebooking here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kodebooking here] end
				// % protected region % [Set readonly for Kodebooking here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kodebooking here] end
				validators: [
					// % protected region % [Add other validators for Kodebooking here] off begin
					// % protected region % [Add other validators for Kodebooking here] end
				],
				// % protected region % [Add any additional model attribute properties for Kodebooking here] off begin
				// % protected region % [Add any additional model attribute properties for Kodebooking here] end
			},
			{
				name: 'taskname',
				// % protected region % [Set displayName for Taskname here] off begin
				displayName: 'Taskname',
				// % protected region % [Set displayName for Taskname here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Taskname here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Taskname here] end
				// % protected region % [Set isSensitive for Taskname here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Taskname here] end
				// % protected region % [Set readonly for Taskname here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Taskname here] end
				validators: [
					// % protected region % [Add other validators for Taskname here] off begin
					// % protected region % [Add other validators for Taskname here] end
				],
				// % protected region % [Add any additional model attribute properties for Taskname here] off begin
				// % protected region % [Add any additional model attribute properties for Taskname here] end
			},
			{
				name: 'taskid',
				// % protected region % [Set displayName for TaskId here] off begin
				displayName: 'TaskId',
				// % protected region % [Set displayName for TaskId here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for TaskId here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for TaskId here] end
				// % protected region % [Set isSensitive for TaskId here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for TaskId here] end
				// % protected region % [Set readonly for TaskId here] off begin
				readOnly: false,
				// % protected region % [Set readonly for TaskId here] end
				validators: [
					// % protected region % [Add other validators for TaskId here] off begin
					// % protected region % [Add other validators for TaskId here] end
				],
				// % protected region % [Add any additional model attribute properties for TaskId here] off begin
				// % protected region % [Add any additional model attribute properties for TaskId here] end
			},
			{
				name: 'waktu',
				// % protected region % [Set displayName for Waktu here] off begin
				displayName: 'Waktu',
				// % protected region % [Set displayName for Waktu here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Waktu here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Waktu here] end
				// % protected region % [Set isSensitive for Waktu here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Waktu here] end
				// % protected region % [Set readonly for Waktu here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Waktu here] end
				validators: [
					// % protected region % [Add other validators for Waktu here] off begin
					// % protected region % [Add other validators for Waktu here] end
				],
				// % protected region % [Add any additional model attribute properties for Waktu here] off begin
				// % protected region % [Add any additional model attribute properties for Waktu here] end
			},
			{
				name: 'wakturs',
				// % protected region % [Set displayName for WaktuRS here] off begin
				displayName: 'WaktuRS',
				// % protected region % [Set displayName for WaktuRS here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for WaktuRS here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for WaktuRS here] end
				// % protected region % [Set isSensitive for WaktuRS here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for WaktuRS here] end
				// % protected region % [Set readonly for WaktuRS here] off begin
				readOnly: false,
				// % protected region % [Set readonly for WaktuRS here] end
				validators: [
					// % protected region % [Add other validators for WaktuRS here] off begin
					// % protected region % [Add other validators for WaktuRS here] end
				],
				// % protected region % [Add any additional model attribute properties for WaktuRS here] off begin
				// % protected region % [Add any additional model attribute properties for WaktuRS here] end
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
				case 'kodebooking':
					break;
				case 'taskname':
					break;
				case 'taskid':
					break;
				case 'waktu':
					break;
				case 'wakturs':
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
	static deepParse(data: string | { [K in keyof BpjsListTaskModel]?: BpjsListTaskModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsListTaskModel(data);
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
	 * `let bpjsListTaskModel = new BpjsListTaskModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsListTaskModel,
	 *    it is expected as a JSON string or as a nullable BpjsListTaskModel.
	 */
	constructor(data?: string | Partial<BpjsListTaskModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsListTaskModel>
				: data;

			this.kodebooking = json.kodebooking;
			this.taskname = json.taskname;
			this.taskid = json.taskid;
			this.waktu = json.waktu;
			this.wakturs = json.wakturs;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			kodebooking: this.kodebooking,
			taskname: this.taskname,
			taskid: this.taskid,
			waktu: this.waktu,
			wakturs: this.wakturs,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsListTaskModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsListTaskModel {
		let newModelJson = this.toJSON();

		if (updates.kodebooking) {
			newModelJson.kodebooking = updates.kodebooking;
		}

		if (updates.taskname) {
			newModelJson.taskname = updates.taskname;
		}

		if (updates.taskid) {
			newModelJson.taskid = updates.taskid;
		}

		if (updates.waktu) {
			newModelJson.waktu = updates.waktu;
		}

		if (updates.wakturs) {
			newModelJson.wakturs = updates.wakturs;
		}

		return new BpjsListTaskModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsListTaskModel)) {
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
