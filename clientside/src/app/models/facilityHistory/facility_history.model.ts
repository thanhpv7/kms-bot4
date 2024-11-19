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
export class FacilityHistoryModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'changeDate',
		'bedFacilityId',
		'registrationId',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'changeDate',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'FacilityHistoryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return FacilityHistoryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	changeDate: Date;

	/**
	 * .
	 */
	facilityNo: string;

	/**
	 * .
	 */
	currentQty: number;

	/**
	 * .
	 */
	changedQty: number;

	/**
	 * .
	 */
	facilityStatus: string;

	/**
	 * .
	 */
	facilityClass: string;

	/**
	 * .
	 */
	facilityType: string;

	/**
	 * .
	 */
	facilityService: string;

	/**
	 * .
	 */
	bedFacilityId: string;

	/**
	 * .
	 */
	registrationId: string;



	modelPropGroups: { [s: string]: Group } = FacilityHistoryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'changeDate',
				// % protected region % [Set displayName for Change Date here] off begin
				displayName: 'Change Date',
				// % protected region % [Set displayName for Change Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Change Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Change Date here] end
				// % protected region % [Set isSensitive for Change Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Change Date here] end
				// % protected region % [Set readonly for Change Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Change Date here] end
				validators: [
					// % protected region % [Add other validators for Change Date here] off begin
					// % protected region % [Add other validators for Change Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Change Date here] off begin
				// % protected region % [Add any additional model attribute properties for Change Date here] end
			},
			{
				name: 'facilityNo',
				// % protected region % [Set displayName for Facility No here] off begin
				displayName: 'Facility No',
				// % protected region % [Set displayName for Facility No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Facility No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Facility No here] end
				// % protected region % [Set isSensitive for Facility No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Facility No here] end
				// % protected region % [Set readonly for Facility No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Facility No here] end
				validators: [
					// % protected region % [Add other validators for Facility No here] off begin
					// % protected region % [Add other validators for Facility No here] end
				],
				// % protected region % [Add any additional model attribute properties for Facility No here] off begin
				// % protected region % [Add any additional model attribute properties for Facility No here] end
			},
			{
				name: 'currentQty',
				// % protected region % [Set displayName for Current Qty here] off begin
				displayName: 'Current Qty',
				// % protected region % [Set displayName for Current Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Current Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Current Qty here] end
				// % protected region % [Set isSensitive for Current Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Current Qty here] end
				// % protected region % [Set readonly for Current Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Current Qty here] end
				validators: [
					// % protected region % [Add other validators for Current Qty here] off begin
					// % protected region % [Add other validators for Current Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Current Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Current Qty here] end
			},
			{
				name: 'changedQty',
				// % protected region % [Set displayName for Changed Qty here] off begin
				displayName: 'Changed Qty',
				// % protected region % [Set displayName for Changed Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Changed Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Changed Qty here] end
				// % protected region % [Set isSensitive for Changed Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Changed Qty here] end
				// % protected region % [Set readonly for Changed Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Changed Qty here] end
				validators: [
					// % protected region % [Add other validators for Changed Qty here] off begin
					// % protected region % [Add other validators for Changed Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Changed Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Changed Qty here] end
			},
			{
				name: 'facilityStatus',
				// % protected region % [Set displayName for Facility Status here] off begin
				displayName: 'Facility Status',
				// % protected region % [Set displayName for Facility Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Facility Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Facility Status here] end
				// % protected region % [Set isSensitive for Facility Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Facility Status here] end
				// % protected region % [Set readonly for Facility Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Facility Status here] end
				validators: [
					// % protected region % [Add other validators for Facility Status here] off begin
					// % protected region % [Add other validators for Facility Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Facility Status here] off begin
				// % protected region % [Add any additional model attribute properties for Facility Status here] end
			},
			{
				name: 'facilityClass',
				// % protected region % [Set displayName for Facility Class here] off begin
				displayName: 'Facility Class',
				// % protected region % [Set displayName for Facility Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Facility Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Facility Class here] end
				// % protected region % [Set isSensitive for Facility Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Facility Class here] end
				// % protected region % [Set readonly for Facility Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Facility Class here] end
				validators: [
					// % protected region % [Add other validators for Facility Class here] off begin
					// % protected region % [Add other validators for Facility Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Facility Class here] off begin
				// % protected region % [Add any additional model attribute properties for Facility Class here] end
			},
			{
				name: 'facilityType',
				// % protected region % [Set displayName for Facility Type here] off begin
				displayName: 'Facility Type',
				// % protected region % [Set displayName for Facility Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Facility Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Facility Type here] end
				// % protected region % [Set isSensitive for Facility Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Facility Type here] end
				// % protected region % [Set readonly for Facility Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Facility Type here] end
				validators: [
					// % protected region % [Add other validators for Facility Type here] off begin
					// % protected region % [Add other validators for Facility Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Facility Type here] off begin
				// % protected region % [Add any additional model attribute properties for Facility Type here] end
			},
			{
				name: 'facilityService',
				// % protected region % [Set displayName for Facility Service here] off begin
				displayName: 'Facility Service',
				// % protected region % [Set displayName for Facility Service here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Facility Service here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Facility Service here] end
				// % protected region % [Set isSensitive for Facility Service here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Facility Service here] end
				// % protected region % [Set readonly for Facility Service here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Facility Service here] end
				validators: [
					// % protected region % [Add other validators for Facility Service here] off begin
					// % protected region % [Add other validators for Facility Service here] end
				],
				// % protected region % [Add any additional model attribute properties for Facility Service here] off begin
				// % protected region % [Add any additional model attribute properties for Facility Service here] end
			},
			{
				name: 'bedFacilityId',
				// % protected region % [Set displayName for Bed Facility Id here] off begin
				displayName: 'Bed Facility Id',
				// % protected region % [Set displayName for Bed Facility Id here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bed Facility Id here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bed Facility Id here] end
				// % protected region % [Set isSensitive for Bed Facility Id here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bed Facility Id here] end
				// % protected region % [Set readonly for Bed Facility Id here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bed Facility Id here] end
				validators: [
					// % protected region % [Add other validators for Bed Facility Id here] off begin
					// % protected region % [Add other validators for Bed Facility Id here] end
				],
				// % protected region % [Add any additional model attribute properties for Bed Facility Id here] off begin
				// % protected region % [Add any additional model attribute properties for Bed Facility Id here] end
			},
			{
				name: 'registrationId',
				// % protected region % [Set displayName for Registration Id here] off begin
				displayName: 'Registration Id',
				// % protected region % [Set displayName for Registration Id here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Registration Id here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Registration Id here] end
				// % protected region % [Set isSensitive for Registration Id here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Registration Id here] end
				// % protected region % [Set readonly for Registration Id here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Registration Id here] end
				validators: [
					// % protected region % [Add other validators for Registration Id here] off begin
					// % protected region % [Add other validators for Registration Id here] end
				],
				// % protected region % [Add any additional model attribute properties for Registration Id here] off begin
				// % protected region % [Add any additional model attribute properties for Registration Id here] end
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
				case 'changeDate':
					break;
				case 'bedFacilityId':
					break;
				case 'registrationId':
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
	static deepParse(data: string | { [K in keyof FacilityHistoryModel]?: FacilityHistoryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new FacilityHistoryModel(data);
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
	 * `let facilityHistoryModel = new FacilityHistoryModel(data);`
	 *
	 * @param data The input data to be initialised as the FacilityHistoryModel,
	 *    it is expected as a JSON string or as a nullable FacilityHistoryModel.
	 */
	constructor(data?: string | Partial<FacilityHistoryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<FacilityHistoryModel>
				: data;

			if (json.changeDate) {
				this.changeDate = new Date(json.changeDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.changeDate = json.changeDate;
			}
			this.facilityNo = json.facilityNo;
			this.currentQty = json.currentQty;
			this.changedQty = json.changedQty;
			this.facilityStatus = json.facilityStatus;
			this.facilityClass = json.facilityClass;
			this.facilityType = json.facilityType;
			this.facilityService = json.facilityService;
			this.bedFacilityId = json.bedFacilityId;
			this.registrationId = json.registrationId;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			changeDate: this.changeDate,
			facilityNo: this.facilityNo,
			currentQty: this.currentQty,
			changedQty: this.changedQty,
			facilityStatus: this.facilityStatus,
			facilityClass: this.facilityClass,
			facilityType: this.facilityType,
			facilityService: this.facilityService,
			bedFacilityId: this.bedFacilityId,
			registrationId: this.registrationId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		FacilityHistoryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): FacilityHistoryModel {
		let newModelJson = this.toJSON();

		if (updates.changeDate) {
			newModelJson.changeDate = updates.changeDate;
		}

		if (updates.facilityNo) {
			newModelJson.facilityNo = updates.facilityNo;
		}

		if (updates.currentQty) {
			newModelJson.currentQty = updates.currentQty;
		}

		if (updates.changedQty) {
			newModelJson.changedQty = updates.changedQty;
		}

		if (updates.facilityStatus) {
			newModelJson.facilityStatus = updates.facilityStatus;
		}

		if (updates.facilityClass) {
			newModelJson.facilityClass = updates.facilityClass;
		}

		if (updates.facilityType) {
			newModelJson.facilityType = updates.facilityType;
		}

		if (updates.facilityService) {
			newModelJson.facilityService = updates.facilityService;
		}

		if (updates.bedFacilityId) {
			newModelJson.bedFacilityId = updates.bedFacilityId;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		return new FacilityHistoryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof FacilityHistoryModel)) {
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
