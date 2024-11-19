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
import {NewbornDetailModel} from '../newbornDetail/newborn_detail.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class VitalSignsModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'time',
		'hr',
		'rr',
		'temprature',
		'o2Saturation',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'time',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'VitalSignsModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return VitalSignsModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	time: string;

	/**
	 * .
	 */
	hr: string;

	/**
	 * .
	 */
	rr: string;

	/**
	 * .
	 */
	temprature: string;

	/**
	 * .
	 */
	o2Saturation: string;

	/**
	 * .
	 */
	remarks: string;

	newbornDetailId: string;

	newbornDetail: NewbornDetailModel;

	modelPropGroups: { [s: string]: Group } = VitalSignsModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'time',
				// % protected region % [Set displayName for Time here] off begin
				displayName: 'Time',
				// % protected region % [Set displayName for Time here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Time here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Time here] end
				// % protected region % [Set isSensitive for Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Time here] end
				// % protected region % [Set readonly for Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Time here] end
				validators: [
					// % protected region % [Add other validators for Time here] off begin
					// % protected region % [Add other validators for Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Time here] off begin
				// % protected region % [Add any additional model attribute properties for Time here] end
			},
			{
				name: 'hr',
				// % protected region % [Set displayName for HR here] off begin
				displayName: 'HR',
				// % protected region % [Set displayName for HR here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for HR here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for HR here] end
				// % protected region % [Set isSensitive for HR here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for HR here] end
				// % protected region % [Set readonly for HR here] off begin
				readOnly: false,
				// % protected region % [Set readonly for HR here] end
				validators: [
					// % protected region % [Add other validators for HR here] off begin
					// % protected region % [Add other validators for HR here] end
				],
				// % protected region % [Add any additional model attribute properties for HR here] off begin
				// % protected region % [Add any additional model attribute properties for HR here] end
			},
			{
				name: 'rr',
				// % protected region % [Set displayName for RR here] off begin
				displayName: 'RR',
				// % protected region % [Set displayName for RR here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for RR here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for RR here] end
				// % protected region % [Set isSensitive for RR here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for RR here] end
				// % protected region % [Set readonly for RR here] off begin
				readOnly: false,
				// % protected region % [Set readonly for RR here] end
				validators: [
					// % protected region % [Add other validators for RR here] off begin
					// % protected region % [Add other validators for RR here] end
				],
				// % protected region % [Add any additional model attribute properties for RR here] off begin
				// % protected region % [Add any additional model attribute properties for RR here] end
			},
			{
				name: 'temprature',
				// % protected region % [Set displayName for Temprature here] off begin
				displayName: 'Temprature',
				// % protected region % [Set displayName for Temprature here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Temprature here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Temprature here] end
				// % protected region % [Set isSensitive for Temprature here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Temprature here] end
				// % protected region % [Set readonly for Temprature here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Temprature here] end
				validators: [
					// % protected region % [Add other validators for Temprature here] off begin
					// % protected region % [Add other validators for Temprature here] end
				],
				// % protected region % [Add any additional model attribute properties for Temprature here] off begin
				// % protected region % [Add any additional model attribute properties for Temprature here] end
			},
			{
				name: 'o2Saturation',
				// % protected region % [Set displayName for O2 Saturation here] off begin
				displayName: 'O2 Saturation',
				// % protected region % [Set displayName for O2 Saturation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for O2 Saturation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for O2 Saturation here] end
				// % protected region % [Set isSensitive for O2 Saturation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for O2 Saturation here] end
				// % protected region % [Set readonly for O2 Saturation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for O2 Saturation here] end
				validators: [
					// % protected region % [Add other validators for O2 Saturation here] off begin
					// % protected region % [Add other validators for O2 Saturation here] end
				],
				// % protected region % [Add any additional model attribute properties for O2 Saturation here] off begin
				// % protected region % [Add any additional model attribute properties for O2 Saturation here] end
			},
			{
				name: 'remarks',
				// % protected region % [Set displayName for Remarks here] off begin
				displayName: 'Remarks',
				// % protected region % [Set displayName for Remarks here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Remarks here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Remarks here] end
				// % protected region % [Set isSensitive for Remarks here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Remarks here] end
				// % protected region % [Set readonly for Remarks here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Remarks here] end
				validators: [
					// % protected region % [Add other validators for Remarks here] off begin
					// % protected region % [Add other validators for Remarks here] end
				],
				// % protected region % [Add any additional model attribute properties for Remarks here] off begin
				// % protected region % [Add any additional model attribute properties for Remarks here] end
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
				id: 'newbornDetail',
				type: ModelRelationType.ONE,
				name: 'newbornDetailId',
				// % protected region % [Customise your label for Newborn Detail here] off begin
				label: 'Newborn Detail',
				// % protected region % [Customise your label for Newborn Detail here] end
				entityName: 'NewbornDetailModel',
				// % protected region % [Customise your display name for Newborn Detail here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'newbornFirstName',
				// % protected region % [Customise your display name for Newborn Detail here] end
				validators: [
					// % protected region % [Add other validators for Newborn Detail here] off begin
					// % protected region % [Add other validators for Newborn Detail here] end
				],
				// % protected region % [Add any additional field for relation Newborn Detail here] off begin
				// % protected region % [Add any additional field for relation Newborn Detail here] end
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
				case 'time':
					break;
				case 'hr':
					break;
				case 'rr':
					break;
				case 'temprature':
					break;
				case 'o2Saturation':
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
	static deepParse(data: string | { [K in keyof VitalSignsModel]?: VitalSignsModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new VitalSignsModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.newbornDetail) {
			currentModel.newbornDetailId = json.newbornDetail.id;
			returned = _.union(returned, NewbornDetailModel.deepParse(json.newbornDetail));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let vitalSignsModel = new VitalSignsModel(data);`
	 *
	 * @param data The input data to be initialised as the VitalSignsModel,
	 *    it is expected as a JSON string or as a nullable VitalSignsModel.
	 */
	constructor(data?: string | Partial<VitalSignsModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<VitalSignsModel>
				: data;

			this.time = json.time;
			this.hr = json.hr;
			this.rr = json.rr;
			this.temprature = json.temprature;
			this.o2Saturation = json.o2Saturation;
			this.remarks = json.remarks;
			this.newbornDetailId = json.newbornDetailId;
			this.newbornDetail = json.newbornDetail;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			time: this.time,
			hr: this.hr,
			rr: this.rr,
			temprature: this.temprature,
			o2Saturation: this.o2Saturation,
			remarks: this.remarks,
			newbornDetailId: this.newbornDetailId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		VitalSignsModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): VitalSignsModel {
		let newModelJson = this.toJSON();

		if (updates.time) {
			newModelJson.time = updates.time;
		}

		if (updates.hr) {
			newModelJson.hr = updates.hr;
		}

		if (updates.rr) {
			newModelJson.rr = updates.rr;
		}

		if (updates.temprature) {
			newModelJson.temprature = updates.temprature;
		}

		if (updates.o2Saturation) {
			newModelJson.o2Saturation = updates.o2Saturation;
		}

		if (updates.remarks) {
			newModelJson.remarks = updates.remarks;
		}

		if (updates.newbornDetailId) {
			newModelJson.newbornDetailId = updates.newbornDetailId;
		}

		return new VitalSignsModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof VitalSignsModel)) {
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
			'newbornDetailId',
			'newbornDetail',
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
		if (!this.newbornDetail) {
			this.newbornDetailId = null;
		} else {
			this.newbornDetailId = this.newbornDetail.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
