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
import {RegistrationModel} from '../registration/registration.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class DiagnosticExaminationResultsModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'result',
		'sampleNo',
		'repeated',
		'status',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'result',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'DiagnosticExaminationResultsModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return DiagnosticExaminationResultsModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	result: string;

	/**
	 * .
	 */
	outsideRange: boolean = false;

	/**
	 * .
	 */
	low: number;

	/**
	 * .
	 */
	high: number;

	/**
	 * .
	 */
	unit: string;

	/**
	 * .
	 */
	sampleNo: string;

	/**
	 * .
	 */
	sampleType: string;

	/**
	 * for repeat status.
	 */
	repeated: boolean = false;

	/**
	 * status.
	 */
	status: string;

	examinationItemId: string;

	examinationItem: ExaminationItemModel;

	registrationId: string;

	registration: RegistrationModel;

	modelPropGroups: { [s: string]: Group } = DiagnosticExaminationResultsModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'result',
				// % protected region % [Set displayName for Result here] off begin
				displayName: 'Result',
				// % protected region % [Set displayName for Result here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Result here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Result here] end
				// % protected region % [Set isSensitive for Result here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Result here] end
				// % protected region % [Set readonly for Result here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Result here] end
				validators: [
					Validators.maxLength(1000),
					// % protected region % [Add other validators for Result here] off begin
					// % protected region % [Add other validators for Result here] end
				],
				// % protected region % [Add any additional model attribute properties for Result here] off begin
				// % protected region % [Add any additional model attribute properties for Result here] end
			},
			{
				name: 'outsideRange',
				// % protected region % [Set displayName for Outside Range here] off begin
				displayName: 'Outside Range',
				// % protected region % [Set displayName for Outside Range here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Outside Range here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Outside Range here] end
				// % protected region % [Set isSensitive for Outside Range here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Outside Range here] end
				// % protected region % [Set readonly for Outside Range here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Outside Range here] end
				validators: [
					// % protected region % [Add other validators for Outside Range here] off begin
					// % protected region % [Add other validators for Outside Range here] end
				],
				// % protected region % [Add any additional model attribute properties for Outside Range here] off begin
				// % protected region % [Add any additional model attribute properties for Outside Range here] end
			},
			{
				name: 'low',
				// % protected region % [Set displayName for Low here] off begin
				displayName: 'Low',
				// % protected region % [Set displayName for Low here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Low here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Low here] end
				// % protected region % [Set isSensitive for Low here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Low here] end
				// % protected region % [Set readonly for Low here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Low here] end
				validators: [
					// % protected region % [Add other validators for Low here] off begin
					// % protected region % [Add other validators for Low here] end
				],
				// % protected region % [Add any additional model attribute properties for Low here] off begin
				// % protected region % [Add any additional model attribute properties for Low here] end
			},
			{
				name: 'high',
				// % protected region % [Set displayName for High here] off begin
				displayName: 'High',
				// % protected region % [Set displayName for High here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for High here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for High here] end
				// % protected region % [Set isSensitive for High here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for High here] end
				// % protected region % [Set readonly for High here] off begin
				readOnly: false,
				// % protected region % [Set readonly for High here] end
				validators: [
					// % protected region % [Add other validators for High here] off begin
					// % protected region % [Add other validators for High here] end
				],
				// % protected region % [Add any additional model attribute properties for High here] off begin
				// % protected region % [Add any additional model attribute properties for High here] end
			},
			{
				name: 'unit',
				// % protected region % [Set displayName for Unit here] off begin
				displayName: 'Unit',
				// % protected region % [Set displayName for Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Unit here] end
				// % protected region % [Set isSensitive for Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit here] end
				// % protected region % [Set readonly for Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit here] end
				validators: [
					// % protected region % [Add other validators for Unit here] off begin
					// % protected region % [Add other validators for Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Unit here] end
			},
			{
				name: 'sampleNo',
				// % protected region % [Set displayName for Sample No here] off begin
				displayName: 'Sample No',
				// % protected region % [Set displayName for Sample No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sample No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sample No here] end
				// % protected region % [Set isSensitive for Sample No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sample No here] end
				// % protected region % [Set readonly for Sample No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sample No here] end
				validators: [
					// % protected region % [Add other validators for Sample No here] off begin
					// % protected region % [Add other validators for Sample No here] end
				],
				// % protected region % [Add any additional model attribute properties for Sample No here] off begin
				// % protected region % [Add any additional model attribute properties for Sample No here] end
			},
			{
				name: 'sampleType',
				// % protected region % [Set displayName for Sample Type here] off begin
				displayName: 'Sample Type',
				// % protected region % [Set displayName for Sample Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sample Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sample Type here] end
				// % protected region % [Set isSensitive for Sample Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sample Type here] end
				// % protected region % [Set readonly for Sample Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sample Type here] end
				validators: [
					// % protected region % [Add other validators for Sample Type here] off begin
					// % protected region % [Add other validators for Sample Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Sample Type here] off begin
				// % protected region % [Add any additional model attribute properties for Sample Type here] end
			},
			{
				name: 'repeated',
				// % protected region % [Set displayName for repeated here] off begin
				displayName: 'repeated',
				// % protected region % [Set displayName for repeated here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for repeated here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for repeated here] end
				// % protected region % [Set isSensitive for repeated here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for repeated here] end
				// % protected region % [Set readonly for repeated here] off begin
				readOnly: false,
				// % protected region % [Set readonly for repeated here] end
				validators: [
					// % protected region % [Add other validators for repeated here] off begin
					// % protected region % [Add other validators for repeated here] end
				],
				// % protected region % [Add any additional model attribute properties for repeated here] off begin
				// % protected region % [Add any additional model attribute properties for repeated here] end
			},
			{
				name: 'status',
				// % protected region % [Set displayName for status here] off begin
				displayName: 'status',
				// % protected region % [Set displayName for status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for status here] end
				// % protected region % [Set isSensitive for status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for status here] end
				// % protected region % [Set readonly for status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for status here] end
				validators: [
					// % protected region % [Add other validators for status here] off begin
					// % protected region % [Add other validators for status here] end
				],
				// % protected region % [Add any additional model attribute properties for status here] off begin
				// % protected region % [Add any additional model attribute properties for status here] end
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
				id: 'examinationItem',
				type: ModelRelationType.ONE,
				name: 'examinationItemId',
				// % protected region % [Customise your label for Examination Item here] off begin
				label: 'Examination Item',
				// % protected region % [Customise your label for Examination Item here] end
				entityName: 'ExaminationItemModel',
				// % protected region % [Customise your display name for Examination Item here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemCode',
				// % protected region % [Customise your display name for Examination Item here] end
				validators: [
					// % protected region % [Add other validators for Examination Item here] off begin
					// % protected region % [Add other validators for Examination Item here] end
				],
				// % protected region % [Add any additional field for relation Examination Item here] off begin
				// % protected region % [Add any additional field for relation Examination Item here] end
			},
			{
				id: 'registration',
				type: ModelRelationType.ONE,
				name: 'registrationId',
				// % protected region % [Customise your label for Registration here] off begin
				label: 'Registration',
				// % protected region % [Customise your label for Registration here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registration here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registration here] end
				validators: [
					// % protected region % [Add other validators for Registration here] off begin
					// % protected region % [Add other validators for Registration here] end
				],
				// % protected region % [Add any additional field for relation Registration here] off begin
				// % protected region % [Add any additional field for relation Registration here] end
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
				case 'result':
					break;
				case 'sampleNo':
					break;
				case 'repeated':
					break;
				case 'status':
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
	static deepParse(data: string | { [K in keyof DiagnosticExaminationResultsModel]?: DiagnosticExaminationResultsModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new DiagnosticExaminationResultsModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.examinationItem) {
			currentModel.examinationItemId = json.examinationItem.id;
			returned = _.union(returned, ExaminationItemModel.deepParse(json.examinationItem));
		}

		// Incoming one to many
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let diagnosticExaminationResultsModel = new DiagnosticExaminationResultsModel(data);`
	 *
	 * @param data The input data to be initialised as the DiagnosticExaminationResultsModel,
	 *    it is expected as a JSON string or as a nullable DiagnosticExaminationResultsModel.
	 */
	constructor(data?: string | Partial<DiagnosticExaminationResultsModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<DiagnosticExaminationResultsModel>
				: data;

			this.result = json.result;
			this.outsideRange = json.outsideRange;
			this.low = json.low;
			this.high = json.high;
			this.unit = json.unit;
			this.sampleNo = json.sampleNo;
			this.sampleType = json.sampleType;
			this.repeated = json.repeated;
			this.status = json.status;
			this.examinationItemId = json.examinationItemId;
			this.examinationItem = json.examinationItem;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			result: this.result,
			outsideRange: this.outsideRange,
			low: this.low,
			high: this.high,
			unit: this.unit,
			sampleNo: this.sampleNo,
			sampleType: this.sampleType,
			repeated: this.repeated,
			status: this.status,
			examinationItemId: this.examinationItemId,
			registrationId: this.registrationId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		DiagnosticExaminationResultsModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): DiagnosticExaminationResultsModel {
		let newModelJson = this.toJSON();

		if (updates.result) {
			newModelJson.result = updates.result;
		}

		if (updates.outsideRange) {
			newModelJson.outsideRange = updates.outsideRange;
		}

		if (updates.low) {
			newModelJson.low = updates.low;
		}

		if (updates.high) {
			newModelJson.high = updates.high;
		}

		if (updates.unit) {
			newModelJson.unit = updates.unit;
		}

		if (updates.sampleNo) {
			newModelJson.sampleNo = updates.sampleNo;
		}

		if (updates.sampleType) {
			newModelJson.sampleType = updates.sampleType;
		}

		if (updates.repeated) {
			newModelJson.repeated = updates.repeated;
		}

		if (updates.status) {
			newModelJson.status = updates.status;
		}

		if (updates.examinationItemId) {
			newModelJson.examinationItemId = updates.examinationItemId;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		return new DiagnosticExaminationResultsModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof DiagnosticExaminationResultsModel)) {
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
			'examinationItemId',
			'examinationItem',
			'registrationId',
			'registration',
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
		if (!this.examinationItem) {
			this.examinationItemId = null;
		} else {
			this.examinationItemId = this.examinationItem.id;
		}

		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
