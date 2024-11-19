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
import {BpjsHealthFacilityModel} from '../bpjsHealthFacility/bpjs_health_facility.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsFacilityListModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'facilityCode',
		'facilityName',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'facilityCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsFacilityListModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsFacilityListModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	facilityCode: string;

	/**
	 * .
	 */
	facilityName: string;

	bpjsHealthFacilityId: string;

	bpjsHealthFacility: BpjsHealthFacilityModel;

	modelPropGroups: { [s: string]: Group } = BpjsFacilityListModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'facilityCode',
				// % protected region % [Set displayName for Facility Code here] off begin
				displayName: 'Facility Code',
				// % protected region % [Set displayName for Facility Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Facility Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Facility Code here] end
				// % protected region % [Set isSensitive for Facility Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Facility Code here] end
				// % protected region % [Set readonly for Facility Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Facility Code here] end
				validators: [
					// % protected region % [Add other validators for Facility Code here] off begin
					// % protected region % [Add other validators for Facility Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Facility Code here] off begin
				// % protected region % [Add any additional model attribute properties for Facility Code here] end
			},
			{
				name: 'facilityName',
				// % protected region % [Set displayName for Facility Name here] off begin
				displayName: 'Facility Name',
				// % protected region % [Set displayName for Facility Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Facility Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Facility Name here] end
				// % protected region % [Set isSensitive for Facility Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Facility Name here] end
				// % protected region % [Set readonly for Facility Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Facility Name here] end
				validators: [
					// % protected region % [Add other validators for Facility Name here] off begin
					// % protected region % [Add other validators for Facility Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Facility Name here] off begin
				// % protected region % [Add any additional model attribute properties for Facility Name here] end
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
				id: 'bpjsHealthFacility',
				type: ModelRelationType.ONE,
				name: 'bpjsHealthFacilityId',
				// % protected region % [Customise your label for BPJS Health Facility here] off begin
				label: 'BPJS Health Facility',
				// % protected region % [Customise your label for BPJS Health Facility here] end
				entityName: 'BpjsHealthFacilityModel',
				// % protected region % [Customise your display name for BPJS Health Facility here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Health Facility here] end
				validators: [
					// % protected region % [Add other validators for BPJS Health Facility here] off begin
					// % protected region % [Add other validators for BPJS Health Facility here] end
				],
				// % protected region % [Add any additional field for relation BPJS Health Facility here] off begin
				// % protected region % [Add any additional field for relation BPJS Health Facility here] end
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
				case 'facilityCode':
					break;
				case 'facilityName':
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
	static deepParse(data: string | { [K in keyof BpjsFacilityListModel]?: BpjsFacilityListModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsFacilityListModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.bpjsHealthFacility) {
			currentModel.bpjsHealthFacilityId = json.bpjsHealthFacility.id;
			returned = _.union(returned, BpjsHealthFacilityModel.deepParse(json.bpjsHealthFacility));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsFacilityListModel = new BpjsFacilityListModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsFacilityListModel,
	 *    it is expected as a JSON string or as a nullable BpjsFacilityListModel.
	 */
	constructor(data?: string | Partial<BpjsFacilityListModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsFacilityListModel>
				: data;

			this.facilityCode = json.facilityCode;
			this.facilityName = json.facilityName;
			this.bpjsHealthFacilityId = json.bpjsHealthFacilityId;
			this.bpjsHealthFacility = json.bpjsHealthFacility;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			facilityCode: this.facilityCode,
			facilityName: this.facilityName,
			bpjsHealthFacilityId: this.bpjsHealthFacilityId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsFacilityListModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsFacilityListModel {
		let newModelJson = this.toJSON();

		if (updates.facilityCode) {
			newModelJson.facilityCode = updates.facilityCode;
		}

		if (updates.facilityName) {
			newModelJson.facilityName = updates.facilityName;
		}

		if (updates.bpjsHealthFacilityId) {
			newModelJson.bpjsHealthFacilityId = updates.bpjsHealthFacilityId;
		}

		return new BpjsFacilityListModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsFacilityListModel)) {
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
			'bpjsHealthFacilityId',
			'bpjsHealthFacility',
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
		if (!this.bpjsHealthFacility) {
			this.bpjsHealthFacilityId = null;
		} else {
			this.bpjsHealthFacilityId = this.bpjsHealthFacility.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
