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
export class BpjsControlSpecialistModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'specialistCode',
		'percentage',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'specialistCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsControlSpecialistModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsControlSpecialistModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	specialistCode: string;

	/**
	 * .
	 */
	specialistName: string;

	/**
	 * .
	 */
	capacity: string;

	/**
	 * .
	 */
	totalControlPlanReferral: string;

	/**
	 * .
	 */
	percentage: string;



	modelPropGroups: { [s: string]: Group } = BpjsControlSpecialistModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'specialistCode',
				// % protected region % [Set displayName for Specialist Code here] off begin
				displayName: 'Specialist Code',
				// % protected region % [Set displayName for Specialist Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Specialist Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Specialist Code here] end
				// % protected region % [Set isSensitive for Specialist Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Specialist Code here] end
				// % protected region % [Set readonly for Specialist Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Specialist Code here] end
				validators: [
					// % protected region % [Add other validators for Specialist Code here] off begin
					// % protected region % [Add other validators for Specialist Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Specialist Code here] off begin
				// % protected region % [Add any additional model attribute properties for Specialist Code here] end
			},
			{
				name: 'specialistName',
				// % protected region % [Set displayName for Specialist Name here] off begin
				displayName: 'Specialist Name',
				// % protected region % [Set displayName for Specialist Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Specialist Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Specialist Name here] end
				// % protected region % [Set isSensitive for Specialist Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Specialist Name here] end
				// % protected region % [Set readonly for Specialist Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Specialist Name here] end
				validators: [
					// % protected region % [Add other validators for Specialist Name here] off begin
					// % protected region % [Add other validators for Specialist Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Specialist Name here] off begin
				// % protected region % [Add any additional model attribute properties for Specialist Name here] end
			},
			{
				name: 'capacity',
				// % protected region % [Set displayName for Capacity here] off begin
				displayName: 'Capacity',
				// % protected region % [Set displayName for Capacity here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Capacity here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Capacity here] end
				// % protected region % [Set isSensitive for Capacity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Capacity here] end
				// % protected region % [Set readonly for Capacity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Capacity here] end
				validators: [
					// % protected region % [Add other validators for Capacity here] off begin
					// % protected region % [Add other validators for Capacity here] end
				],
				// % protected region % [Add any additional model attribute properties for Capacity here] off begin
				// % protected region % [Add any additional model attribute properties for Capacity here] end
			},
			{
				name: 'totalControlPlanReferral',
				// % protected region % [Set displayName for Total Control Plan Referral here] off begin
				displayName: 'Total Control Plan Referral',
				// % protected region % [Set displayName for Total Control Plan Referral here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Total Control Plan Referral here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Total Control Plan Referral here] end
				// % protected region % [Set isSensitive for Total Control Plan Referral here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Control Plan Referral here] end
				// % protected region % [Set readonly for Total Control Plan Referral here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Control Plan Referral here] end
				validators: [
					// % protected region % [Add other validators for Total Control Plan Referral here] off begin
					// % protected region % [Add other validators for Total Control Plan Referral here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Control Plan Referral here] off begin
				// % protected region % [Add any additional model attribute properties for Total Control Plan Referral here] end
			},
			{
				name: 'percentage',
				// % protected region % [Set displayName for Percentage here] off begin
				displayName: 'Percentage',
				// % protected region % [Set displayName for Percentage here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Percentage here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Percentage here] end
				// % protected region % [Set isSensitive for Percentage here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Percentage here] end
				// % protected region % [Set readonly for Percentage here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Percentage here] end
				validators: [
					// % protected region % [Add other validators for Percentage here] off begin
					// % protected region % [Add other validators for Percentage here] end
				],
				// % protected region % [Add any additional model attribute properties for Percentage here] off begin
				// % protected region % [Add any additional model attribute properties for Percentage here] end
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
				case 'specialistCode':
					break;
				case 'percentage':
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
	static deepParse(data: string | { [K in keyof BpjsControlSpecialistModel]?: BpjsControlSpecialistModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsControlSpecialistModel(data);
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
	 * `let bpjsControlSpecialistModel = new BpjsControlSpecialistModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsControlSpecialistModel,
	 *    it is expected as a JSON string or as a nullable BpjsControlSpecialistModel.
	 */
	constructor(data?: string | Partial<BpjsControlSpecialistModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsControlSpecialistModel>
				: data;

			this.specialistCode = json.specialistCode;
			this.specialistName = json.specialistName;
			this.capacity = json.capacity;
			this.totalControlPlanReferral = json.totalControlPlanReferral;
			this.percentage = json.percentage;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			specialistCode: this.specialistCode,
			specialistName: this.specialistName,
			capacity: this.capacity,
			totalControlPlanReferral: this.totalControlPlanReferral,
			percentage: this.percentage,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsControlSpecialistModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsControlSpecialistModel {
		let newModelJson = this.toJSON();

		if (updates.specialistCode) {
			newModelJson.specialistCode = updates.specialistCode;
		}

		if (updates.specialistName) {
			newModelJson.specialistName = updates.specialistName;
		}

		if (updates.capacity) {
			newModelJson.capacity = updates.capacity;
		}

		if (updates.totalControlPlanReferral) {
			newModelJson.totalControlPlanReferral = updates.totalControlPlanReferral;
		}

		if (updates.percentage) {
			newModelJson.percentage = updates.percentage;
		}

		return new BpjsControlSpecialistModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsControlSpecialistModel)) {
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
