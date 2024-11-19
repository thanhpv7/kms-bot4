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
import {PatientGeneralInfoModel} from '../patientGeneralInfo/patient_general_info.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class CashRefundModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'refundNumber',
		'refundDate',
		'cashierLocation',
		'isvoid',
		'paymentType',
		'refundAmount',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'refundNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'CashRefundModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return CashRefundModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Refund Number (Max Length: 50).
	 */
	refundNumber: string;

	/**
	 * .
	 */
	refundDate: Date;

	/**
	 * Description (Max Length 5000).
	 */
	description: string;

	/**
	 * Cashier Location, get the Code from Reference Data where Type=CASH_LOC. (Max Length: 20).
	 */
	cashierLocation: string;

	/**
	 * Indicator of void refund.
	 */
	isvoid: boolean = false;

	/**
	 * Date and Time when the refund was voided.
	 */
	voidDateTime: Date;

	/**
	 * Payment type, get the Code from Reference Data where Type=PAY_TYPE. (Max Length: 20), exclude Ref CODE: CARD (Debit/Credit Card).
	 */
	paymentType: string;

	/**
	 * Refund Amount, with 2 decimal dgitits.
	 */
	refundAmount: number;

	/**
	 * Hospital Bank Account where the refund to patient is being transferred to, get the Code from Reference Data where Type=BANK_ACCT. (Max Length: 20).
	 */
	hospitalBankAccount: string;

	/**
	 * Reference (Max Length: 20).
	 */
	referenceNumber: string;

	patientGeneralInfoId: string;

	patientGeneralInfo: PatientGeneralInfoModel;

	modelPropGroups: { [s: string]: Group } = CashRefundModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'refundNumber',
				// % protected region % [Set displayName for Refund Number here] off begin
				displayName: 'Refund Number',
				// % protected region % [Set displayName for Refund Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Refund Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Refund Number here] end
				// % protected region % [Set isSensitive for Refund Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Refund Number here] end
				// % protected region % [Set readonly for Refund Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Refund Number here] end
				validators: [
					// % protected region % [Add other validators for Refund Number here] off begin
					// % protected region % [Add other validators for Refund Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Refund Number here] off begin
				// % protected region % [Add any additional model attribute properties for Refund Number here] end
			},
			{
				name: 'refundDate',
				// % protected region % [Set displayName for Refund Date here] off begin
				displayName: 'Refund Date',
				// % protected region % [Set displayName for Refund Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Refund Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Refund Date here] end
				// % protected region % [Set isSensitive for Refund Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Refund Date here] end
				// % protected region % [Set readonly for Refund Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Refund Date here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Refund Date here] off begin
					// % protected region % [Add other validators for Refund Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Refund Date here] off begin
				// % protected region % [Add any additional model attribute properties for Refund Date here] end
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
					Validators.maxLength(5000),
					// % protected region % [Add other validators for Description here] off begin
					// % protected region % [Add other validators for Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Description here] off begin
				// % protected region % [Add any additional model attribute properties for Description here] end
			},
			{
				name: 'cashierLocation',
				// % protected region % [Set displayName for Cashier Location here] off begin
				displayName: 'Cashier Location',
				// % protected region % [Set displayName for Cashier Location here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Cashier Location here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Cashier Location here] end
				// % protected region % [Set isSensitive for Cashier Location here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cashier Location here] end
				// % protected region % [Set readonly for Cashier Location here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cashier Location here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Cashier Location here] off begin
					// % protected region % [Add other validators for Cashier Location here] end
				],
				// % protected region % [Add any additional model attribute properties for Cashier Location here] off begin
				// % protected region % [Add any additional model attribute properties for Cashier Location here] end
			},
			{
				name: 'isvoid',
				// % protected region % [Set displayName for IsVoid here] off begin
				displayName: 'IsVoid',
				// % protected region % [Set displayName for IsVoid here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for IsVoid here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for IsVoid here] end
				// % protected region % [Set isSensitive for IsVoid here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for IsVoid here] end
				// % protected region % [Set readonly for IsVoid here] off begin
				readOnly: false,
				// % protected region % [Set readonly for IsVoid here] end
				validators: [
					// % protected region % [Add other validators for IsVoid here] off begin
					// % protected region % [Add other validators for IsVoid here] end
				],
				// % protected region % [Add any additional model attribute properties for IsVoid here] off begin
				// % protected region % [Add any additional model attribute properties for IsVoid here] end
			},
			{
				name: 'voidDateTime',
				// % protected region % [Set displayName for Void Date Time here] off begin
				displayName: 'Void Date Time',
				// % protected region % [Set displayName for Void Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Void Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Void Date Time here] end
				// % protected region % [Set isSensitive for Void Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Void Date Time here] end
				// % protected region % [Set readonly for Void Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Void Date Time here] end
				validators: [
					// % protected region % [Add other validators for Void Date Time here] off begin
					// % protected region % [Add other validators for Void Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Void Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Void Date Time here] end
			},
			{
				name: 'paymentType',
				// % protected region % [Set displayName for Payment Type here] off begin
				displayName: 'Payment Type',
				// % protected region % [Set displayName for Payment Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Payment Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Payment Type here] end
				// % protected region % [Set isSensitive for Payment Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Payment Type here] end
				// % protected region % [Set readonly for Payment Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Payment Type here] end
				validators: [
					// % protected region % [Add other validators for Payment Type here] off begin
					// % protected region % [Add other validators for Payment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Payment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Payment Type here] end
			},
			{
				name: 'refundAmount',
				// % protected region % [Set displayName for Refund Amount here] off begin
				displayName: 'Refund Amount',
				// % protected region % [Set displayName for Refund Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Refund Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Refund Amount here] end
				// % protected region % [Set isSensitive for Refund Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Refund Amount here] end
				// % protected region % [Set readonly for Refund Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Refund Amount here] end
				validators: [
					// % protected region % [Add other validators for Refund Amount here] off begin
					// % protected region % [Add other validators for Refund Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Refund Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Refund Amount here] end
			},
			{
				name: 'hospitalBankAccount',
				// % protected region % [Set displayName for Hospital Bank Account here] off begin
				displayName: 'Hospital Bank Account',
				// % protected region % [Set displayName for Hospital Bank Account here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Bank Account here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Bank Account here] end
				// % protected region % [Set isSensitive for Hospital Bank Account here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Bank Account here] end
				// % protected region % [Set readonly for Hospital Bank Account here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Bank Account here] end
				validators: [
					// % protected region % [Add other validators for Hospital Bank Account here] off begin
					// % protected region % [Add other validators for Hospital Bank Account here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Bank Account here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Bank Account here] end
			},
			{
				name: 'referenceNumber',
				// % protected region % [Set displayName for Reference Number here] off begin
				displayName: 'Reference Number',
				// % protected region % [Set displayName for Reference Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Reference Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Reference Number here] end
				// % protected region % [Set isSensitive for Reference Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reference Number here] end
				// % protected region % [Set readonly for Reference Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reference Number here] end
				validators: [
					// % protected region % [Add other validators for Reference Number here] off begin
					// % protected region % [Add other validators for Reference Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Reference Number here] off begin
				// % protected region % [Add any additional model attribute properties for Reference Number here] end
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
				id: 'patientGeneralInfo',
				type: ModelRelationType.ONE,
				name: 'patientGeneralInfoId',
				// % protected region % [Customise your label for Patient General Info here] off begin
				label: 'Patient General Info',
				// % protected region % [Customise your label for Patient General Info here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient General Info here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient General Info here] end
				validators: [
					Validators.required
					// % protected region % [Add other validators for Patient General Info here] off begin
					// % protected region % [Add other validators for Patient General Info here] end
				],
				// % protected region % [Add any additional field for relation Patient General Info here] off begin
				// % protected region % [Add any additional field for relation Patient General Info here] end
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
				case 'refundNumber':
					break;
				case 'refundDate':
					break;
				case 'cashierLocation':
					break;
				case 'isvoid':
					break;
				case 'paymentType':
					break;
				case 'refundAmount':
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
	static deepParse(data: string | { [K in keyof CashRefundModel]?: CashRefundModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new CashRefundModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.patientGeneralInfo) {
			currentModel.patientGeneralInfoId = json.patientGeneralInfo.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInfo));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let cashRefundModel = new CashRefundModel(data);`
	 *
	 * @param data The input data to be initialised as the CashRefundModel,
	 *    it is expected as a JSON string or as a nullable CashRefundModel.
	 */
	constructor(data?: string | Partial<CashRefundModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<CashRefundModel>
				: data;

			this.refundNumber = json.refundNumber;
			if (json.refundDate) {
				this.refundDate = new Date(json.refundDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.refundDate = json.refundDate;
			}
			this.description = json.description;
			this.cashierLocation = json.cashierLocation;
			this.isvoid = json.isvoid;
			if (json.voidDateTime) {
				this.voidDateTime = new Date(json.voidDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.voidDateTime = json.voidDateTime;
			}
			this.paymentType = json.paymentType;
			this.refundAmount = json.refundAmount;
			this.hospitalBankAccount = json.hospitalBankAccount;
			this.referenceNumber = json.referenceNumber;
			this.patientGeneralInfoId = json.patientGeneralInfoId;
			this.patientGeneralInfo = json.patientGeneralInfo;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			refundNumber: this.refundNumber,
			refundDate: this.refundDate,
			description: this.description,
			cashierLocation: this.cashierLocation,
			isvoid: this.isvoid,
			voidDateTime: this.voidDateTime,
			paymentType: this.paymentType,
			refundAmount: this.refundAmount,
			hospitalBankAccount: this.hospitalBankAccount,
			referenceNumber: this.referenceNumber,
			patientGeneralInfoId: this.patientGeneralInfoId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		CashRefundModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): CashRefundModel {
		let newModelJson = this.toJSON();

		if (updates.refundNumber) {
			newModelJson.refundNumber = updates.refundNumber;
		}

		if (updates.refundDate) {
			newModelJson.refundDate = updates.refundDate;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.cashierLocation) {
			newModelJson.cashierLocation = updates.cashierLocation;
		}

		if (updates.isvoid) {
			newModelJson.isvoid = updates.isvoid;
		}

		if (updates.voidDateTime) {
			newModelJson.voidDateTime = updates.voidDateTime;
		}

		if (updates.paymentType) {
			newModelJson.paymentType = updates.paymentType;
		}

		if (updates.refundAmount) {
			newModelJson.refundAmount = updates.refundAmount;
		}

		if (updates.hospitalBankAccount) {
			newModelJson.hospitalBankAccount = updates.hospitalBankAccount;
		}

		if (updates.referenceNumber) {
			newModelJson.referenceNumber = updates.referenceNumber;
		}

		if (updates.patientGeneralInfoId) {
			newModelJson.patientGeneralInfoId = updates.patientGeneralInfoId;
		}

		return new CashRefundModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof CashRefundModel)) {
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
			'patientGeneralInfoId',
			'patientGeneralInfo',
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
		if (!this.patientGeneralInfo) {
			this.patientGeneralInfoId = null;
		} else {
			this.patientGeneralInfoId = this.patientGeneralInfo.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
