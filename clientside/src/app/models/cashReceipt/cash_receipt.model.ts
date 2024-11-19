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
import {CashChangeTypeEnum, cashChangeTypeEnumArray} from '../../enums/cash-change-type.enum';
import {ReceiptTypeEnum, receiptTypeEnumArray} from '../../enums/receipt-type.enum';
import {MerchantModel} from '../merchant/merchant.model';
import {PatientGeneralInfoModel} from '../patientGeneralInfo/patient_general_info.model';
import {RetailPharmacyInvoiceModel} from '../retailPharmacyInvoice/retail_pharmacy_invoice.model';
import {StaffModel} from '../staff/staff.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class CashReceiptModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'receiptType',
		'receiptNumber',
		'description',
		'paymentType',
		'receiveAmount',
		'isvoid',
		'cashierLocation',
		'voidDateTime',
		'cashChangeType',
		'changeAmount',
		'allocatedAmount',
		'availableAmount',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'receiptType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'CashReceiptModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return CashReceiptModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Receipt Number (Max Length: 50).
	 */
	receiptNumber: string;

	/**
	 * Payment Date and Time.
	 */
	paymentDate: Date;

	/**
	 * Description (Max Length 5000).
	 */
	description: string;

	/**
	 * Payment type, get the Code from Reference Data where Type=PAY_TYPE. (Max Length: 20).
	 */
	paymentType: string;

	/**
	 * Cash Receive Amount from patient, with 2 decimal digits.
	 */
	receiveAmount: number;

	/**
	 * Indicator of receipt.
	 */
	isvoid: boolean = false;

	/**
	 * Cashier Location, get the Code from Reference Data where Type=CASH_LOC. (Max Length: 20).
	 */
	cashierLocation: string;

	/**
	 * Date and Time when the receipt was voided.
	 */
	voidDateTime: Date;

	/**
	 * Change Amount, 2 decimal digits. Formula is, Receive Amount - (Total selected Invoice - Deposit amount used).
	 */
	changeAmount: number;

	/**
	 * Allocated Amount is updated as reference of paid/refund to patient.
	 */
	allocatedAmount: number;

	/**
	 * Rounding Amount, 2 decimal digits .
	 */
	roundingAmount: number;

	/**
	 * Available amount is calculated from: Receive Amount + IF(Cash Change Type is Down Payment  THEN 0 ELSE (-1) * Change Amount) - Allocated Amount.
	 */
	availableAmount: number;

	/**
	 * Bank Name that issued the card, get the Code from Reference Data where Type=BANK. (Max Length: 20).
	 */
	bankName: string;

	/**
	 * Debit/Credit Card Type, get the Code from Reference Data where Type=BANKCARD_TYPE. (Max Length: 20).
	 */
	cardType: string;

	/**
	 * Card No (Max Length: 20).
	 */
	cardNo: string;

	/**
	 * Card Holder (Max Length: 50).
	 */
	cardHolder: string;

	/**
	 * Reference or Batch Number (Max Length: 20).
	 */
	referenceNumber: string;

	/**
	 * Hospital Bank Account where patient transferred to, get the Code from Reference Data where Type=BANK_ACCT. (Max Length: 20).
	 */
	hospitalBankAccount: string;

	/**
	 * Fee of using Merchant (Debit/Credit Card transaction), with 2 decimal digits.
	 */
	surchargeAmount: number;

	/**
	 * .
	 */
	outstandingAmount: number;

	/**
	 * Modifiable Patient Name.
	 */
	receivedFrom: string;

	/**
	 * Patient Or Customer Name.
	 */
	patientOrCustomerName: string;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=11, example=Sally}.
	 */
	cashChangeType: CashChangeTypeEnum;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=2, example=Sally}.
	 */
	receiptType: ReceiptTypeEnum;

	merchantId: string;

	merchant: MerchantModel;

	retailPharmacyInvoiceId: string;

	retailPharmacyInvoice: RetailPharmacyInvoiceModel;

	cashierStaffId: string;

	cashierStaff: StaffModel;

	patientId: string;

	patient: PatientGeneralInfoModel;

	modelPropGroups: { [s: string]: Group } = CashReceiptModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'receiptType',
				// % protected region % [Set displayName for Receipt Type here] off begin
				displayName: 'Receipt Type',
				// % protected region % [Set displayName for Receipt Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: receiptTypeEnumArray,
				// % protected region % [Set display element type for Receipt Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Receipt Type here] end
				// % protected region % [Set isSensitive for Receipt Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Receipt Type here] end
				// % protected region % [Set readonly for Receipt Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Receipt Type here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Receipt Type here] off begin
					// % protected region % [Add other validators for Receipt Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Receipt Type here] off begin
				// % protected region % [Add any additional model attribute properties for Receipt Type here] end
			},
			{
				name: 'receiptNumber',
				// % protected region % [Set displayName for Receipt Number here] off begin
				displayName: 'Receipt Number',
				// % protected region % [Set displayName for Receipt Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Receipt Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Receipt Number here] end
				// % protected region % [Set isSensitive for Receipt Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Receipt Number here] end
				// % protected region % [Set readonly for Receipt Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Receipt Number here] end
				validators: [
					// % protected region % [Add other validators for Receipt Number here] off begin
					// % protected region % [Add other validators for Receipt Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Receipt Number here] off begin
				// % protected region % [Add any additional model attribute properties for Receipt Number here] end
			},
			{
				name: 'paymentDate',
				// % protected region % [Set displayName for Payment Date here] off begin
				displayName: 'Payment Date',
				// % protected region % [Set displayName for Payment Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Payment Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Payment Date here] end
				// % protected region % [Set isSensitive for Payment Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Payment Date here] end
				// % protected region % [Set readonly for Payment Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Payment Date here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Payment Date here] off begin
					// % protected region % [Add other validators for Payment Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Payment Date here] off begin
				// % protected region % [Add any additional model attribute properties for Payment Date here] end
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
				name: 'receiveAmount',
				// % protected region % [Set displayName for Receive Amount here] off begin
				displayName: 'Receive Amount',
				// % protected region % [Set displayName for Receive Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Receive Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Receive Amount here] end
				// % protected region % [Set isSensitive for Receive Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Receive Amount here] end
				// % protected region % [Set readonly for Receive Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Receive Amount here] end
				validators: [
					// % protected region % [Add other validators for Receive Amount here] off begin
					// % protected region % [Add other validators for Receive Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Receive Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Receive Amount here] end
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
				name: 'cashChangeType',
				// % protected region % [Set displayName for Cash Change Type here] off begin
				displayName: 'Cash Change Type',
				// % protected region % [Set displayName for Cash Change Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: cashChangeTypeEnumArray,
				// % protected region % [Set display element type for Cash Change Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Cash Change Type here] end
				// % protected region % [Set isSensitive for Cash Change Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cash Change Type here] end
				// % protected region % [Set readonly for Cash Change Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cash Change Type here] end
				validators: [
					// % protected region % [Add other validators for Cash Change Type here] off begin
					// % protected region % [Add other validators for Cash Change Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Cash Change Type here] off begin
				// % protected region % [Add any additional model attribute properties for Cash Change Type here] end
			},
			{
				name: 'changeAmount',
				// % protected region % [Set displayName for Change Amount here] off begin
				displayName: 'Change Amount',
				// % protected region % [Set displayName for Change Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Change Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Change Amount here] end
				// % protected region % [Set isSensitive for Change Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Change Amount here] end
				// % protected region % [Set readonly for Change Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Change Amount here] end
				validators: [
					// % protected region % [Add other validators for Change Amount here] off begin
					// % protected region % [Add other validators for Change Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Change Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Change Amount here] end
			},
			{
				name: 'allocatedAmount',
				// % protected region % [Set displayName for Allocated Amount here] off begin
				displayName: 'Allocated Amount',
				// % protected region % [Set displayName for Allocated Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Allocated Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Allocated Amount here] end
				// % protected region % [Set isSensitive for Allocated Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Allocated Amount here] end
				// % protected region % [Set readonly for Allocated Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Allocated Amount here] end
				validators: [
					// % protected region % [Add other validators for Allocated Amount here] off begin
					// % protected region % [Add other validators for Allocated Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Allocated Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Allocated Amount here] end
			},
			{
				name: 'roundingAmount',
				// % protected region % [Set displayName for Rounding Amount here] off begin
				displayName: 'Rounding Amount',
				// % protected region % [Set displayName for Rounding Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Rounding Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Rounding Amount here] end
				// % protected region % [Set isSensitive for Rounding Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Rounding Amount here] end
				// % protected region % [Set readonly for Rounding Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Rounding Amount here] end
				validators: [
					// % protected region % [Add other validators for Rounding Amount here] off begin
					// % protected region % [Add other validators for Rounding Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Rounding Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Rounding Amount here] end
			},
			{
				name: 'availableAmount',
				// % protected region % [Set displayName for Available Amount here] off begin
				displayName: 'Available Amount',
				// % protected region % [Set displayName for Available Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Available Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Available Amount here] end
				// % protected region % [Set isSensitive for Available Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Available Amount here] end
				// % protected region % [Set readonly for Available Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Available Amount here] end
				validators: [
					// % protected region % [Add other validators for Available Amount here] off begin
					// % protected region % [Add other validators for Available Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Available Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Available Amount here] end
			},
			{
				name: 'bankName',
				// % protected region % [Set displayName for Bank Name here] off begin
				displayName: 'Bank Name',
				// % protected region % [Set displayName for Bank Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bank Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bank Name here] end
				// % protected region % [Set isSensitive for Bank Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bank Name here] end
				// % protected region % [Set readonly for Bank Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bank Name here] end
				validators: [
					// % protected region % [Add other validators for Bank Name here] off begin
					// % protected region % [Add other validators for Bank Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Bank Name here] off begin
				// % protected region % [Add any additional model attribute properties for Bank Name here] end
			},
			{
				name: 'cardType',
				// % protected region % [Set displayName for Card Type here] off begin
				displayName: 'Card Type',
				// % protected region % [Set displayName for Card Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Card Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Card Type here] end
				// % protected region % [Set isSensitive for Card Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Card Type here] end
				// % protected region % [Set readonly for Card Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Card Type here] end
				validators: [
					// % protected region % [Add other validators for Card Type here] off begin
					// % protected region % [Add other validators for Card Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Card Type here] off begin
				// % protected region % [Add any additional model attribute properties for Card Type here] end
			},
			{
				name: 'cardNo',
				// % protected region % [Set displayName for Card No here] off begin
				displayName: 'Card No',
				// % protected region % [Set displayName for Card No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Card No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Card No here] end
				// % protected region % [Set isSensitive for Card No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Card No here] end
				// % protected region % [Set readonly for Card No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Card No here] end
				validators: [
					// % protected region % [Add other validators for Card No here] off begin
					// % protected region % [Add other validators for Card No here] end
				],
				// % protected region % [Add any additional model attribute properties for Card No here] off begin
				// % protected region % [Add any additional model attribute properties for Card No here] end
			},
			{
				name: 'cardHolder',
				// % protected region % [Set displayName for Card Holder here] off begin
				displayName: 'Card Holder',
				// % protected region % [Set displayName for Card Holder here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Card Holder here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Card Holder here] end
				// % protected region % [Set isSensitive for Card Holder here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Card Holder here] end
				// % protected region % [Set readonly for Card Holder here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Card Holder here] end
				validators: [
					// % protected region % [Add other validators for Card Holder here] off begin
					// % protected region % [Add other validators for Card Holder here] end
				],
				// % protected region % [Add any additional model attribute properties for Card Holder here] off begin
				// % protected region % [Add any additional model attribute properties for Card Holder here] end
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
				name: 'surchargeAmount',
				// % protected region % [Set displayName for Surcharge Amount here] off begin
				displayName: 'Surcharge Amount',
				// % protected region % [Set displayName for Surcharge Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Surcharge Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Surcharge Amount here] end
				// % protected region % [Set isSensitive for Surcharge Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surcharge Amount here] end
				// % protected region % [Set readonly for Surcharge Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surcharge Amount here] end
				validators: [
					// % protected region % [Add other validators for Surcharge Amount here] off begin
					// % protected region % [Add other validators for Surcharge Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Surcharge Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Surcharge Amount here] end
			},
			{
				name: 'outstandingAmount',
				// % protected region % [Set displayName for Outstanding Amount here] off begin
				displayName: 'Outstanding Amount',
				// % protected region % [Set displayName for Outstanding Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Outstanding Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Outstanding Amount here] end
				// % protected region % [Set isSensitive for Outstanding Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Outstanding Amount here] end
				// % protected region % [Set readonly for Outstanding Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Outstanding Amount here] end
				validators: [
					// % protected region % [Add other validators for Outstanding Amount here] off begin
					// % protected region % [Add other validators for Outstanding Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Outstanding Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Outstanding Amount here] end
			},
			{
				name: 'receivedFrom',
				// % protected region % [Set displayName for Received From here] off begin
				displayName: 'Received From',
				// % protected region % [Set displayName for Received From here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Received From here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Received From here] end
				// % protected region % [Set isSensitive for Received From here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Received From here] end
				// % protected region % [Set readonly for Received From here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Received From here] end
				validators: [
					// % protected region % [Add other validators for Received From here] off begin
					// % protected region % [Add other validators for Received From here] end
				],
				// % protected region % [Add any additional model attribute properties for Received From here] off begin
				// % protected region % [Add any additional model attribute properties for Received From here] end
			},
			{
				name: 'patientOrCustomerName',
				// % protected region % [Set displayName for Patient Or Customer Name here] off begin
				displayName: 'Patient Or Customer Name',
				// % protected region % [Set displayName for Patient Or Customer Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient Or Customer Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient Or Customer Name here] end
				// % protected region % [Set isSensitive for Patient Or Customer Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Or Customer Name here] end
				// % protected region % [Set readonly for Patient Or Customer Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Or Customer Name here] end
				validators: [
					// % protected region % [Add other validators for Patient Or Customer Name here] off begin
					// % protected region % [Add other validators for Patient Or Customer Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Or Customer Name here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Or Customer Name here] end
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
				id: 'merchant',
				type: ModelRelationType.ONE,
				name: 'merchantId',
				// % protected region % [Customise your label for Merchant here] off begin
				label: 'Merchant',
				// % protected region % [Customise your label for Merchant here] end
				entityName: 'MerchantModel',
				// % protected region % [Customise your display name for Merchant here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'merchantName',
				// % protected region % [Customise your display name for Merchant here] end
				validators: [
					// % protected region % [Add other validators for Merchant here] off begin
					// % protected region % [Add other validators for Merchant here] end
				],
				// % protected region % [Add any additional field for relation Merchant here] off begin
				// % protected region % [Add any additional field for relation Merchant here] end
			},
			{
				id: 'retailPharmacyInvoice',
				type: ModelRelationType.ONE,
				name: 'retailPharmacyInvoiceId',
				// % protected region % [Customise your label for Retail Pharmacy Invoice here] off begin
				label: 'Retail Pharmacy Invoice',
				// % protected region % [Customise your label for Retail Pharmacy Invoice here] end
				entityName: 'RetailPharmacyInvoiceModel',
				// % protected region % [Customise your display name for Retail Pharmacy Invoice here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Retail Pharmacy Invoice here] end
				validators: [
					// % protected region % [Add other validators for Retail Pharmacy Invoice here] off begin
					// % protected region % [Add other validators for Retail Pharmacy Invoice here] end
				],
				// % protected region % [Add any additional field for relation Retail Pharmacy Invoice here] off begin
				// % protected region % [Add any additional field for relation Retail Pharmacy Invoice here] end
			},
			{
				id: 'cashierStaff',
				type: ModelRelationType.ONE,
				name: 'cashierStaffId',
				// % protected region % [Customise your label for Cashier Staff here] off begin
				label: 'Cashier Staff',
				// % protected region % [Customise your label for Cashier Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Cashier Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Cashier Staff here] end
				validators: [
					// % protected region % [Add other validators for Cashier Staff here] off begin
					// % protected region % [Add other validators for Cashier Staff here] end
				],
				// % protected region % [Add any additional field for relation Cashier Staff here] off begin
				// % protected region % [Add any additional field for relation Cashier Staff here] end
			},
			{
				id: 'patient',
				type: ModelRelationType.ONE,
				name: 'patientId',
				// % protected region % [Customise your label for Patient here] off begin
				label: 'Patient',
				// % protected region % [Customise your label for Patient here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient here] end
				validators: [
					// % protected region % [Add other validators for Patient here] off begin
					// % protected region % [Add other validators for Patient here] end
				],
				// % protected region % [Add any additional field for relation Patient here] off begin
				// % protected region % [Add any additional field for relation Patient here] end
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
				case 'receiptType':
					conditions.push([
						{
							path: key,
							operation: QueryOperation.EQUAL,
							value: formGroup.value[key],
						}
					]);
					break;
				case 'receiptNumber':
					break;
				case 'description':
					break;
				case 'paymentType':
					break;
				case 'receiveAmount':
					break;
				case 'isvoid':
					break;
				case 'cashierLocation':
					break;
				case 'voidDateTime':
					break;
				case 'cashChangeType':
					conditions.push([
						{
							path: key,
							operation: QueryOperation.EQUAL,
							value: formGroup.value[key],
						}
					]);
					break;
				case 'changeAmount':
					break;
				case 'allocatedAmount':
					break;
				case 'availableAmount':
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
	static deepParse(data: string | { [K in keyof CashReceiptModel]?: CashReceiptModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new CashReceiptModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.merchant) {
			currentModel.merchantId = json.merchant.id;
			returned = _.union(returned, MerchantModel.deepParse(json.merchant));
		}

		// Incoming one to many
		if (json.retailPharmacyInvoice) {
			currentModel.retailPharmacyInvoiceId = json.retailPharmacyInvoice.id;
			returned = _.union(returned, RetailPharmacyInvoiceModel.deepParse(json.retailPharmacyInvoice));
		}

		// Incoming one to many
		if (json.cashierStaff) {
			currentModel.cashierStaffId = json.cashierStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.cashierStaff));
		}

		// Incoming one to many
		if (json.patient) {
			currentModel.patientId = json.patient.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patient));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let cashReceiptModel = new CashReceiptModel(data);`
	 *
	 * @param data The input data to be initialised as the CashReceiptModel,
	 *    it is expected as a JSON string or as a nullable CashReceiptModel.
	 */
	constructor(data?: string | Partial<CashReceiptModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<CashReceiptModel>
				: data;

			this.receiptType = json.receiptType;
			this.receiptNumber = json.receiptNumber;
			if (json.paymentDate) {
				this.paymentDate = new Date(json.paymentDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.paymentDate = json.paymentDate;
			}
			this.description = json.description;
			this.paymentType = json.paymentType;
			this.receiveAmount = json.receiveAmount;
			this.isvoid = json.isvoid;
			this.cashierLocation = json.cashierLocation;
			if (json.voidDateTime) {
				this.voidDateTime = new Date(json.voidDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.voidDateTime = json.voidDateTime;
			}
			this.cashChangeType = json.cashChangeType;
			this.changeAmount = json.changeAmount;
			this.allocatedAmount = json.allocatedAmount;
			this.roundingAmount = json.roundingAmount;
			this.availableAmount = json.availableAmount;
			this.bankName = json.bankName;
			this.cardType = json.cardType;
			this.cardNo = json.cardNo;
			this.cardHolder = json.cardHolder;
			this.referenceNumber = json.referenceNumber;
			this.hospitalBankAccount = json.hospitalBankAccount;
			this.surchargeAmount = json.surchargeAmount;
			this.outstandingAmount = json.outstandingAmount;
			this.receivedFrom = json.receivedFrom;
			this.patientOrCustomerName = json.patientOrCustomerName;
			this.cashChangeType = json.cashChangeType;
			this.receiptType = json.receiptType;
			this.merchantId = json.merchantId;
			this.merchant = json.merchant;
			this.retailPharmacyInvoiceId = json.retailPharmacyInvoiceId;
			this.retailPharmacyInvoice = json.retailPharmacyInvoice;
			this.cashierStaffId = json.cashierStaffId;
			this.cashierStaff = json.cashierStaff;
			this.patientId = json.patientId;
			this.patient = json.patient;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			receiptType: this.receiptType,
			receiptNumber: this.receiptNumber,
			paymentDate: this.paymentDate,
			description: this.description,
			paymentType: this.paymentType,
			receiveAmount: this.receiveAmount,
			isvoid: this.isvoid,
			cashierLocation: this.cashierLocation,
			voidDateTime: this.voidDateTime,
			cashChangeType: this.cashChangeType,
			changeAmount: this.changeAmount,
			allocatedAmount: this.allocatedAmount,
			roundingAmount: this.roundingAmount,
			availableAmount: this.availableAmount,
			bankName: this.bankName,
			cardType: this.cardType,
			cardNo: this.cardNo,
			cardHolder: this.cardHolder,
			referenceNumber: this.referenceNumber,
			hospitalBankAccount: this.hospitalBankAccount,
			surchargeAmount: this.surchargeAmount,
			outstandingAmount: this.outstandingAmount,
			receivedFrom: this.receivedFrom,
			patientOrCustomerName: this.patientOrCustomerName,
			merchantId: this.merchantId,
			retailPharmacyInvoiceId: this.retailPharmacyInvoiceId,
			cashierStaffId: this.cashierStaffId,
			patientId: this.patientId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		CashReceiptModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): CashReceiptModel {
		let newModelJson = this.toJSON();

		if (updates.receiptType) {
			newModelJson.receiptType = updates.receiptType;
		}

		if (updates.receiptNumber) {
			newModelJson.receiptNumber = updates.receiptNumber;
		}

		if (updates.paymentDate) {
			newModelJson.paymentDate = updates.paymentDate;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.paymentType) {
			newModelJson.paymentType = updates.paymentType;
		}

		if (updates.receiveAmount) {
			newModelJson.receiveAmount = updates.receiveAmount;
		}

		if (updates.isvoid) {
			newModelJson.isvoid = updates.isvoid;
		}

		if (updates.cashierLocation) {
			newModelJson.cashierLocation = updates.cashierLocation;
		}

		if (updates.voidDateTime) {
			newModelJson.voidDateTime = updates.voidDateTime;
		}

		if (updates.cashChangeType) {
			newModelJson.cashChangeType = updates.cashChangeType;
		}

		if (updates.changeAmount) {
			newModelJson.changeAmount = updates.changeAmount;
		}

		if (updates.allocatedAmount) {
			newModelJson.allocatedAmount = updates.allocatedAmount;
		}

		if (updates.roundingAmount) {
			newModelJson.roundingAmount = updates.roundingAmount;
		}

		if (updates.availableAmount) {
			newModelJson.availableAmount = updates.availableAmount;
		}

		if (updates.bankName) {
			newModelJson.bankName = updates.bankName;
		}

		if (updates.cardType) {
			newModelJson.cardType = updates.cardType;
		}

		if (updates.cardNo) {
			newModelJson.cardNo = updates.cardNo;
		}

		if (updates.cardHolder) {
			newModelJson.cardHolder = updates.cardHolder;
		}

		if (updates.referenceNumber) {
			newModelJson.referenceNumber = updates.referenceNumber;
		}

		if (updates.hospitalBankAccount) {
			newModelJson.hospitalBankAccount = updates.hospitalBankAccount;
		}

		if (updates.surchargeAmount) {
			newModelJson.surchargeAmount = updates.surchargeAmount;
		}

		if (updates.outstandingAmount) {
			newModelJson.outstandingAmount = updates.outstandingAmount;
		}

		if (updates.receivedFrom) {
			newModelJson.receivedFrom = updates.receivedFrom;
		}

		if (updates.patientOrCustomerName) {
			newModelJson.patientOrCustomerName = updates.patientOrCustomerName;
		}

		if (updates.cashChangeType) {
			newModelJson.cashChangeType = updates.cashChangeType;
		}

		if (updates.receiptType) {
			newModelJson.receiptType = updates.receiptType;
		}

		if (updates.merchantId) {
			newModelJson.merchantId = updates.merchantId;
		}

		if (updates.retailPharmacyInvoiceId) {
			newModelJson.retailPharmacyInvoiceId = updates.retailPharmacyInvoiceId;
		}

		if (updates.cashierStaffId) {
			newModelJson.cashierStaffId = updates.cashierStaffId;
		}

		if (updates.patientId) {
			newModelJson.patientId = updates.patientId;
		}

		return new CashReceiptModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof CashReceiptModel)) {
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
			'merchantId',
			'merchant',
			'retailPharmacyInvoiceId',
			'retailPharmacyInvoice',
			'cashierStaffId',
			'cashierStaff',
			'patientId',
			'patient',
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
		if (!this.merchant) {
			this.merchantId = null;
		} else {
			this.merchantId = this.merchant.id;
		}

		if (!this.retailPharmacyInvoice) {
			this.retailPharmacyInvoiceId = null;
		} else {
			this.retailPharmacyInvoiceId = this.retailPharmacyInvoice.id;
		}

		if (!this.cashierStaff) {
			this.cashierStaffId = null;
		} else {
			this.cashierStaffId = this.cashierStaff.id;
		}

		if (!this.patient) {
			this.patientId = null;
		} else {
			this.patientId = this.patient.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
