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
export class NhisMedicineModel extends AbstractModel {
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
		'medicineCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'NhisMedicineModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return NhisMedicineModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	medicineCode: string;

	/**
	 * .
	 */
	medicineName: string;

	/**
	 * .
	 */
	dose: number;

	/**
	 * .
	 */
	uoi: string;

	/**
	 * .
	 */
	frequency: string;

	/**
	 * .
	 */
	duration: number;

	/**
	 * .
	 */
	unitPrice: number;

	/**
	 * .
	 */
	dispensedQty: number;

	/**
	 * .
	 */
	totalCost: number;

	/**
	 * .
	 */
	serviceDate: Date;



	modelPropGroups: { [s: string]: Group } = NhisMedicineModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'medicineCode',
				// % protected region % [Set displayName for Medicine Code here] off begin
				displayName: 'Medicine Code',
				// % protected region % [Set displayName for Medicine Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Medicine Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Medicine Code here] end
				// % protected region % [Set isSensitive for Medicine Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medicine Code here] end
				// % protected region % [Set readonly for Medicine Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medicine Code here] end
				validators: [
					// % protected region % [Add other validators for Medicine Code here] off begin
					// % protected region % [Add other validators for Medicine Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Medicine Code here] off begin
				// % protected region % [Add any additional model attribute properties for Medicine Code here] end
			},
			{
				name: 'medicineName',
				// % protected region % [Set displayName for Medicine Name here] off begin
				displayName: 'Medicine Name',
				// % protected region % [Set displayName for Medicine Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Medicine Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Medicine Name here] end
				// % protected region % [Set isSensitive for Medicine Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medicine Name here] end
				// % protected region % [Set readonly for Medicine Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medicine Name here] end
				validators: [
					// % protected region % [Add other validators for Medicine Name here] off begin
					// % protected region % [Add other validators for Medicine Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Medicine Name here] off begin
				// % protected region % [Add any additional model attribute properties for Medicine Name here] end
			},
			{
				name: 'dose',
				// % protected region % [Set displayName for Dose here] off begin
				displayName: 'Dose',
				// % protected region % [Set displayName for Dose here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dose here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dose here] end
				// % protected region % [Set isSensitive for Dose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dose here] end
				// % protected region % [Set readonly for Dose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dose here] end
				validators: [
					// % protected region % [Add other validators for Dose here] off begin
					// % protected region % [Add other validators for Dose here] end
				],
				// % protected region % [Add any additional model attribute properties for Dose here] off begin
				// % protected region % [Add any additional model attribute properties for Dose here] end
			},
			{
				name: 'uoi',
				// % protected region % [Set displayName for UOI here] off begin
				displayName: 'UOI',
				// % protected region % [Set displayName for UOI here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for UOI here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for UOI here] end
				// % protected region % [Set isSensitive for UOI here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for UOI here] end
				// % protected region % [Set readonly for UOI here] off begin
				readOnly: false,
				// % protected region % [Set readonly for UOI here] end
				validators: [
					// % protected region % [Add other validators for UOI here] off begin
					// % protected region % [Add other validators for UOI here] end
				],
				// % protected region % [Add any additional model attribute properties for UOI here] off begin
				// % protected region % [Add any additional model attribute properties for UOI here] end
			},
			{
				name: 'frequency',
				// % protected region % [Set displayName for Frequency here] off begin
				displayName: 'Frequency',
				// % protected region % [Set displayName for Frequency here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Frequency here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Frequency here] end
				// % protected region % [Set isSensitive for Frequency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Frequency here] end
				// % protected region % [Set readonly for Frequency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Frequency here] end
				validators: [
					// % protected region % [Add other validators for Frequency here] off begin
					// % protected region % [Add other validators for Frequency here] end
				],
				// % protected region % [Add any additional model attribute properties for Frequency here] off begin
				// % protected region % [Add any additional model attribute properties for Frequency here] end
			},
			{
				name: 'duration',
				// % protected region % [Set displayName for Duration here] off begin
				displayName: 'Duration',
				// % protected region % [Set displayName for Duration here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Duration here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Duration here] end
				// % protected region % [Set isSensitive for Duration here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Duration here] end
				// % protected region % [Set readonly for Duration here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Duration here] end
				validators: [
					// % protected region % [Add other validators for Duration here] off begin
					// % protected region % [Add other validators for Duration here] end
				],
				// % protected region % [Add any additional model attribute properties for Duration here] off begin
				// % protected region % [Add any additional model attribute properties for Duration here] end
			},
			{
				name: 'unitPrice',
				// % protected region % [Set displayName for Unit Price here] off begin
				displayName: 'Unit Price',
				// % protected region % [Set displayName for Unit Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Unit Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Unit Price here] end
				// % protected region % [Set isSensitive for Unit Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit Price here] end
				// % protected region % [Set readonly for Unit Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit Price here] end
				validators: [
					// % protected region % [Add other validators for Unit Price here] off begin
					// % protected region % [Add other validators for Unit Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit Price here] off begin
				// % protected region % [Add any additional model attribute properties for Unit Price here] end
			},
			{
				name: 'dispensedQty',
				// % protected region % [Set displayName for Dispensed Qty here] off begin
				displayName: 'Dispensed Qty',
				// % protected region % [Set displayName for Dispensed Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dispensed Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dispensed Qty here] end
				// % protected region % [Set isSensitive for Dispensed Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dispensed Qty here] end
				// % protected region % [Set readonly for Dispensed Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dispensed Qty here] end
				validators: [
					// % protected region % [Add other validators for Dispensed Qty here] off begin
					// % protected region % [Add other validators for Dispensed Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Dispensed Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Dispensed Qty here] end
			},
			{
				name: 'totalCost',
				// % protected region % [Set displayName for Total Cost here] off begin
				displayName: 'Total Cost',
				// % protected region % [Set displayName for Total Cost here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Cost here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Cost here] end
				// % protected region % [Set isSensitive for Total Cost here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Cost here] end
				// % protected region % [Set readonly for Total Cost here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Cost here] end
				validators: [
					// % protected region % [Add other validators for Total Cost here] off begin
					// % protected region % [Add other validators for Total Cost here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Cost here] off begin
				// % protected region % [Add any additional model attribute properties for Total Cost here] end
			},
			{
				name: 'serviceDate',
				// % protected region % [Set displayName for Service Date here] off begin
				displayName: 'Service Date',
				// % protected region % [Set displayName for Service Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Service Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Service Date here] end
				// % protected region % [Set isSensitive for Service Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Service Date here] end
				// % protected region % [Set readonly for Service Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Service Date here] end
				validators: [
					// % protected region % [Add other validators for Service Date here] off begin
					// % protected region % [Add other validators for Service Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Service Date here] off begin
				// % protected region % [Add any additional model attribute properties for Service Date here] end
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
	static deepParse(data: string | { [K in keyof NhisMedicineModel]?: NhisMedicineModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new NhisMedicineModel(data);
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
	 * `let nhisMedicineModel = new NhisMedicineModel(data);`
	 *
	 * @param data The input data to be initialised as the NhisMedicineModel,
	 *    it is expected as a JSON string or as a nullable NhisMedicineModel.
	 */
	constructor(data?: string | Partial<NhisMedicineModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<NhisMedicineModel>
				: data;

			this.medicineCode = json.medicineCode;
			this.medicineName = json.medicineName;
			this.dose = json.dose;
			this.uoi = json.uoi;
			this.frequency = json.frequency;
			this.duration = json.duration;
			this.unitPrice = json.unitPrice;
			this.dispensedQty = json.dispensedQty;
			this.totalCost = json.totalCost;
			if (json.serviceDate) {
				this.serviceDate = new Date(json.serviceDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.serviceDate = json.serviceDate;
			}
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			medicineCode: this.medicineCode,
			medicineName: this.medicineName,
			dose: this.dose,
			uoi: this.uoi,
			frequency: this.frequency,
			duration: this.duration,
			unitPrice: this.unitPrice,
			dispensedQty: this.dispensedQty,
			totalCost: this.totalCost,
			serviceDate: this.serviceDate,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		NhisMedicineModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): NhisMedicineModel {
		let newModelJson = this.toJSON();

		if (updates.medicineCode) {
			newModelJson.medicineCode = updates.medicineCode;
		}

		if (updates.medicineName) {
			newModelJson.medicineName = updates.medicineName;
		}

		if (updates.dose) {
			newModelJson.dose = updates.dose;
		}

		if (updates.uoi) {
			newModelJson.uoi = updates.uoi;
		}

		if (updates.frequency) {
			newModelJson.frequency = updates.frequency;
		}

		if (updates.duration) {
			newModelJson.duration = updates.duration;
		}

		if (updates.unitPrice) {
			newModelJson.unitPrice = updates.unitPrice;
		}

		if (updates.dispensedQty) {
			newModelJson.dispensedQty = updates.dispensedQty;
		}

		if (updates.totalCost) {
			newModelJson.totalCost = updates.totalCost;
		}

		if (updates.serviceDate) {
			newModelJson.serviceDate = updates.serviceDate;
		}

		return new NhisMedicineModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof NhisMedicineModel)) {
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
