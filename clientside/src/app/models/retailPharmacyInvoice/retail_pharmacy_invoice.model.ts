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
import {CashReceiptModel} from '../cashReceipt/cash_receipt.model';
import {InvoiceItemModel} from '../invoiceItem/invoice_item.model';
import {InvoiceSummaryModel} from '../invoiceSummary/invoice_summary.model';
import {RetailPharmacyModel} from '../retailPharmacy/retail_pharmacy.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class RetailPharmacyInvoiceModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'revisionNumber',
		'invoiceStatus',
		'invoiceDate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'invoiceNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'RetailPharmacyInvoiceModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return RetailPharmacyInvoiceModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Invoice Number.
	 */
	invoiceNumber: string;

	/**
	 * Revision Number.
	 */
	revisionNumber: number;

	/**
	 * Invoice Status.
	 */
	invoiceStatus: string;

	/**
	 * Invoice Date.
	 */
	invoiceDate: Date;

	/**
	 * Cancel Date.
	 */
	cancelDate: Date;

	/**
	 * Billing Location.
	 */
	billingLocation: string;

	/**
	 * Notes.
	 */
	notes: string;

	/**
	 * Patient Payment Type.
	 */
	patientPaymentType: string;

	/**
	 * Verification Date.
	 */
	verificationDate: Date;

	/**
	 * Display Doctor on Print.
	 */
	displayDoctorOnPrint: boolean = false;

	/**
	 * Claim No.
	 */
	claimNo: string;

	/**
	 * Payment Status.
	 */
	paymentStatus: string;

	/**
	 * Invoice Amount.
	 */
	invoiceAmount: number;

	/**
	 * Outstanding Amount.
	 */
	outstandingAmount: number;

	/**
	 * Customer Name.
	 */
	customerName: string;

	invoiceSummaryId: string;

	invoiceSummary: InvoiceSummaryModel;

	retailPharmacyId: string;

	retailPharmacy: RetailPharmacyModel;

	cashReceiptsIds: string[] = [];

	cashReceipts: CashReceiptModel[];

	invoiceItemsIds: string[] = [];

	invoiceItems: InvoiceItemModel[];

	modelPropGroups: { [s: string]: Group } = RetailPharmacyInvoiceModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'invoiceNumber',
				// % protected region % [Set displayName for Invoice Number here] off begin
				displayName: 'Invoice Number',
				// % protected region % [Set displayName for Invoice Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Invoice Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Invoice Number here] end
				// % protected region % [Set isSensitive for Invoice Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Invoice Number here] end
				// % protected region % [Set readonly for Invoice Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Invoice Number here] end
				validators: [
					// % protected region % [Add other validators for Invoice Number here] off begin
					// % protected region % [Add other validators for Invoice Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Invoice Number here] off begin
				// % protected region % [Add any additional model attribute properties for Invoice Number here] end
			},
			{
				name: 'revisionNumber',
				// % protected region % [Set displayName for Revision Number here] off begin
				displayName: 'Revision Number',
				// % protected region % [Set displayName for Revision Number here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Revision Number here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Revision Number here] end
				// % protected region % [Set isSensitive for Revision Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Revision Number here] end
				// % protected region % [Set readonly for Revision Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Revision Number here] end
				validators: [
					// % protected region % [Add other validators for Revision Number here] off begin
					// % protected region % [Add other validators for Revision Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Revision Number here] off begin
				// % protected region % [Add any additional model attribute properties for Revision Number here] end
			},
			{
				name: 'invoiceStatus',
				// % protected region % [Set displayName for Invoice Status here] off begin
				displayName: 'Invoice Status',
				// % protected region % [Set displayName for Invoice Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Invoice Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Invoice Status here] end
				// % protected region % [Set isSensitive for Invoice Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Invoice Status here] end
				// % protected region % [Set readonly for Invoice Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Invoice Status here] end
				validators: [
					// % protected region % [Add other validators for Invoice Status here] off begin
					// % protected region % [Add other validators for Invoice Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Invoice Status here] off begin
				// % protected region % [Add any additional model attribute properties for Invoice Status here] end
			},
			{
				name: 'invoiceDate',
				// % protected region % [Set displayName for Invoice Date here] off begin
				displayName: 'Invoice Date',
				// % protected region % [Set displayName for Invoice Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Invoice Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Invoice Date here] end
				// % protected region % [Set isSensitive for Invoice Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Invoice Date here] end
				// % protected region % [Set readonly for Invoice Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Invoice Date here] end
				validators: [
					// % protected region % [Add other validators for Invoice Date here] off begin
					// % protected region % [Add other validators for Invoice Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Invoice Date here] off begin
				// % protected region % [Add any additional model attribute properties for Invoice Date here] end
			},
			{
				name: 'cancelDate',
				// % protected region % [Set displayName for Cancel Date here] off begin
				displayName: 'Cancel Date',
				// % protected region % [Set displayName for Cancel Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Cancel Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Cancel Date here] end
				// % protected region % [Set isSensitive for Cancel Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cancel Date here] end
				// % protected region % [Set readonly for Cancel Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cancel Date here] end
				validators: [
					// % protected region % [Add other validators for Cancel Date here] off begin
					// % protected region % [Add other validators for Cancel Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Cancel Date here] off begin
				// % protected region % [Add any additional model attribute properties for Cancel Date here] end
			},
			{
				name: 'billingLocation',
				// % protected region % [Set displayName for Billing Location here] off begin
				displayName: 'Billing Location',
				// % protected region % [Set displayName for Billing Location here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Billing Location here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Billing Location here] end
				// % protected region % [Set isSensitive for Billing Location here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Billing Location here] end
				// % protected region % [Set readonly for Billing Location here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Billing Location here] end
				validators: [
					// % protected region % [Add other validators for Billing Location here] off begin
					// % protected region % [Add other validators for Billing Location here] end
				],
				// % protected region % [Add any additional model attribute properties for Billing Location here] off begin
				// % protected region % [Add any additional model attribute properties for Billing Location here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Notes here] end
				// % protected region % [Set isSensitive for Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Notes here] end
				// % protected region % [Set readonly for Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Notes here] end
				validators: [
					// % protected region % [Add other validators for Notes here] off begin
					// % protected region % [Add other validators for Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Notes here] end
			},
			{
				name: 'patientPaymentType',
				// % protected region % [Set displayName for Patient Payment Type here] off begin
				displayName: 'Patient Payment Type',
				// % protected region % [Set displayName for Patient Payment Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient Payment Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient Payment Type here] end
				// % protected region % [Set isSensitive for Patient Payment Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Payment Type here] end
				// % protected region % [Set readonly for Patient Payment Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Payment Type here] end
				validators: [
					// % protected region % [Add other validators for Patient Payment Type here] off begin
					// % protected region % [Add other validators for Patient Payment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Payment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Payment Type here] end
			},
			{
				name: 'verificationDate',
				// % protected region % [Set displayName for Verification Date here] off begin
				displayName: 'Verification Date',
				// % protected region % [Set displayName for Verification Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Verification Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Verification Date here] end
				// % protected region % [Set isSensitive for Verification Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Verification Date here] end
				// % protected region % [Set readonly for Verification Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Verification Date here] end
				validators: [
					// % protected region % [Add other validators for Verification Date here] off begin
					// % protected region % [Add other validators for Verification Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Verification Date here] off begin
				// % protected region % [Add any additional model attribute properties for Verification Date here] end
			},
			{
				name: 'displayDoctorOnPrint',
				// % protected region % [Set displayName for Display Doctor on Print here] off begin
				displayName: 'Display Doctor on Print',
				// % protected region % [Set displayName for Display Doctor on Print here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Display Doctor on Print here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Display Doctor on Print here] end
				// % protected region % [Set isSensitive for Display Doctor on Print here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Display Doctor on Print here] end
				// % protected region % [Set readonly for Display Doctor on Print here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Display Doctor on Print here] end
				validators: [
					// % protected region % [Add other validators for Display Doctor on Print here] off begin
					// % protected region % [Add other validators for Display Doctor on Print here] end
				],
				// % protected region % [Add any additional model attribute properties for Display Doctor on Print here] off begin
				// % protected region % [Add any additional model attribute properties for Display Doctor on Print here] end
			},
			{
				name: 'claimNo',
				// % protected region % [Set displayName for Claim No here] off begin
				displayName: 'Claim No',
				// % protected region % [Set displayName for Claim No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Claim No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Claim No here] end
				// % protected region % [Set isSensitive for Claim No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Claim No here] end
				// % protected region % [Set readonly for Claim No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Claim No here] end
				validators: [
					// % protected region % [Add other validators for Claim No here] off begin
					// % protected region % [Add other validators for Claim No here] end
				],
				// % protected region % [Add any additional model attribute properties for Claim No here] off begin
				// % protected region % [Add any additional model attribute properties for Claim No here] end
			},
			{
				name: 'paymentStatus',
				// % protected region % [Set displayName for Payment Status here] off begin
				displayName: 'Payment Status',
				// % protected region % [Set displayName for Payment Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Payment Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Payment Status here] end
				// % protected region % [Set isSensitive for Payment Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Payment Status here] end
				// % protected region % [Set readonly for Payment Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Payment Status here] end
				validators: [
					// % protected region % [Add other validators for Payment Status here] off begin
					// % protected region % [Add other validators for Payment Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Payment Status here] off begin
				// % protected region % [Add any additional model attribute properties for Payment Status here] end
			},
			{
				name: 'invoiceAmount',
				// % protected region % [Set displayName for Invoice Amount here] off begin
				displayName: 'Invoice Amount',
				// % protected region % [Set displayName for Invoice Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Invoice Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Invoice Amount here] end
				// % protected region % [Set isSensitive for Invoice Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Invoice Amount here] end
				// % protected region % [Set readonly for Invoice Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Invoice Amount here] end
				validators: [
					// % protected region % [Add other validators for Invoice Amount here] off begin
					// % protected region % [Add other validators for Invoice Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Invoice Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Invoice Amount here] end
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
				name: 'customerName',
				// % protected region % [Set displayName for Customer Name here] off begin
				displayName: 'Customer Name',
				// % protected region % [Set displayName for Customer Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Customer Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Customer Name here] end
				// % protected region % [Set isSensitive for Customer Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Customer Name here] end
				// % protected region % [Set readonly for Customer Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Customer Name here] end
				validators: [
					// % protected region % [Add other validators for Customer Name here] off begin
					// % protected region % [Add other validators for Customer Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Customer Name here] off begin
				// % protected region % [Add any additional model attribute properties for Customer Name here] end
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
				id: 'cashReceipts',
				type: ModelRelationType.MANY,
				name: 'cashReceiptsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Cash Receipts here] off begin
				label: 'Cash Receipts',
				// % protected region % [Customise your 1-1 or 1-M label for Cash Receipts here] end
				entityName: 'CashReceiptModel',
				// % protected region % [Customise your display name for Cash Receipts here] off begin
				displayName: 'receiptType',
				// % protected region % [Customise your display name for Cash Receipts here] end
				validators: [
					// % protected region % [Add other validators for Cash Receipts here] off begin
					// % protected region % [Add other validators for Cash Receipts here] end
				],
				// % protected region % [Add any additional field for relation Cash Receipts here] off begin
				// % protected region % [Add any additional field for relation Cash Receipts here] end
			},
			{
				id: 'invoiceItems',
				type: ModelRelationType.MANY,
				name: 'invoiceItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Items here] off begin
				label: 'Invoice Items',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Items here] end
				entityName: 'InvoiceItemModel',
				// % protected region % [Customise your display name for Invoice Items here] off begin
				displayName: 'transactionDate',
				// % protected region % [Customise your display name for Invoice Items here] end
				validators: [
					// % protected region % [Add other validators for Invoice Items here] off begin
					// % protected region % [Add other validators for Invoice Items here] end
				],
				// % protected region % [Add any additional field for relation Invoice Items here] off begin
				// % protected region % [Add any additional field for relation Invoice Items here] end
			},
			{
				id: 'invoiceSummary',
				type: ModelRelationType.ONE,
				name: 'invoiceSummaryId',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Summary here] off begin
				label: 'Invoice Summary',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Summary here] end
				entityName: 'InvoiceSummaryModel',
				// % protected region % [Customise your display name for Invoice Summary here] off begin
				displayName: 'subTotal',
				// % protected region % [Customise your display name for Invoice Summary here] end
				validators: [
					// % protected region % [Add other validators for Invoice Summary here] off begin
					// % protected region % [Add other validators for Invoice Summary here] end
				],
				// % protected region % [Add any additional field for relation Invoice Summary here] off begin
				// % protected region % [Add any additional field for relation Invoice Summary here] end
			},
			{
				id: 'retailPharmacy',
				type: ModelRelationType.ONE,
				name: 'retailPharmacyId',
				// % protected region % [Customise your label for Retail Pharmacy here] off begin
				label: 'Retail Pharmacy',
				// % protected region % [Customise your label for Retail Pharmacy here] end
				entityName: 'RetailPharmacyModel',
				// % protected region % [Customise your display name for Retail Pharmacy here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'customerType',
				// % protected region % [Customise your display name for Retail Pharmacy here] end
				validators: [
					// % protected region % [Add other validators for Retail Pharmacy here] off begin
					// % protected region % [Add other validators for Retail Pharmacy here] end
				],
				// % protected region % [Add any additional field for relation Retail Pharmacy here] off begin
				// % protected region % [Add any additional field for relation Retail Pharmacy here] end
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
				case 'revisionNumber':
					break;
				case 'invoiceStatus':
					break;
				case 'invoiceDate':
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
	static deepParse(data: string | { [K in keyof RetailPharmacyInvoiceModel]?: RetailPharmacyInvoiceModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new RetailPharmacyInvoiceModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.invoiceSummary) {
			currentModel.invoiceSummaryId = json.invoiceSummary.id;
			returned = _.union(returned, InvoiceSummaryModel.deepParse(json.invoiceSummary));
		}

		// Incoming one to many
		if (json.retailPharmacy) {
			currentModel.retailPharmacyId = json.retailPharmacy.id;
			returned = _.union(returned, RetailPharmacyModel.deepParse(json.retailPharmacy));
		}

		// Outgoing one to many
		if (json.cashReceipts) {
			currentModel.cashReceiptsIds = json.cashReceipts.map(model => model.id);
			returned = _.union(returned, _.flatten(json.cashReceipts.map(model => CashReceiptModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoiceItems) {
			currentModel.invoiceItemsIds = json.invoiceItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoiceItems.map(model => InvoiceItemModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let retailPharmacyInvoiceModel = new RetailPharmacyInvoiceModel(data);`
	 *
	 * @param data The input data to be initialised as the RetailPharmacyInvoiceModel,
	 *    it is expected as a JSON string or as a nullable RetailPharmacyInvoiceModel.
	 */
	constructor(data?: string | Partial<RetailPharmacyInvoiceModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<RetailPharmacyInvoiceModel>
				: data;

			this.invoiceNumber = json.invoiceNumber;
			this.revisionNumber = json.revisionNumber;
			this.invoiceStatus = json.invoiceStatus;
			if (json.invoiceDate) {
				this.invoiceDate = new Date(json.invoiceDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.invoiceDate = json.invoiceDate;
			}
			if (json.cancelDate) {
				this.cancelDate = new Date(json.cancelDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.cancelDate = json.cancelDate;
			}
			this.billingLocation = json.billingLocation;
			this.notes = json.notes;
			this.patientPaymentType = json.patientPaymentType;
			if (json.verificationDate) {
				this.verificationDate = new Date(json.verificationDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.verificationDate = json.verificationDate;
			}
			this.displayDoctorOnPrint = json.displayDoctorOnPrint;
			this.claimNo = json.claimNo;
			this.paymentStatus = json.paymentStatus;
			this.invoiceAmount = json.invoiceAmount;
			this.outstandingAmount = json.outstandingAmount;
			this.customerName = json.customerName;
			this.invoiceSummaryId = json.invoiceSummaryId;
			this.invoiceSummary = json.invoiceSummary;
			this.retailPharmacyId = json.retailPharmacyId;
			this.retailPharmacy = json.retailPharmacy;
			this.cashReceiptsIds = json.cashReceiptsIds;
			this.cashReceipts = json.cashReceipts;
			this.invoiceItemsIds = json.invoiceItemsIds;
			this.invoiceItems = json.invoiceItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			invoiceNumber: this.invoiceNumber,
			revisionNumber: this.revisionNumber,
			invoiceStatus: this.invoiceStatus,
			invoiceDate: this.invoiceDate,
			cancelDate: this.cancelDate,
			billingLocation: this.billingLocation,
			notes: this.notes,
			patientPaymentType: this.patientPaymentType,
			verificationDate: this.verificationDate,
			displayDoctorOnPrint: this.displayDoctorOnPrint,
			claimNo: this.claimNo,
			paymentStatus: this.paymentStatus,
			invoiceAmount: this.invoiceAmount,
			outstandingAmount: this.outstandingAmount,
			customerName: this.customerName,
			invoiceSummaryId: this.invoiceSummaryId,
			retailPharmacyId: this.retailPharmacyId,
			cashReceiptsIds: this.cashReceiptsIds,
			invoiceItemsIds: this.invoiceItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		RetailPharmacyInvoiceModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): RetailPharmacyInvoiceModel {
		let newModelJson = this.toJSON();

		if (updates.invoiceNumber) {
			newModelJson.invoiceNumber = updates.invoiceNumber;
		}

		if (updates.revisionNumber) {
			newModelJson.revisionNumber = updates.revisionNumber;
		}

		if (updates.invoiceStatus) {
			newModelJson.invoiceStatus = updates.invoiceStatus;
		}

		if (updates.invoiceDate) {
			newModelJson.invoiceDate = updates.invoiceDate;
		}

		if (updates.cancelDate) {
			newModelJson.cancelDate = updates.cancelDate;
		}

		if (updates.billingLocation) {
			newModelJson.billingLocation = updates.billingLocation;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.patientPaymentType) {
			newModelJson.patientPaymentType = updates.patientPaymentType;
		}

		if (updates.verificationDate) {
			newModelJson.verificationDate = updates.verificationDate;
		}

		if (updates.displayDoctorOnPrint) {
			newModelJson.displayDoctorOnPrint = updates.displayDoctorOnPrint;
		}

		if (updates.claimNo) {
			newModelJson.claimNo = updates.claimNo;
		}

		if (updates.paymentStatus) {
			newModelJson.paymentStatus = updates.paymentStatus;
		}

		if (updates.invoiceAmount) {
			newModelJson.invoiceAmount = updates.invoiceAmount;
		}

		if (updates.outstandingAmount) {
			newModelJson.outstandingAmount = updates.outstandingAmount;
		}

		if (updates.customerName) {
			newModelJson.customerName = updates.customerName;
		}

		if (updates.invoiceSummaryId) {
			newModelJson.invoiceSummaryId = updates.invoiceSummaryId;
		}

		if (updates.retailPharmacyId) {
			newModelJson.retailPharmacyId = updates.retailPharmacyId;
		}

		if (updates.cashReceiptsIds) {
			newModelJson.cashReceiptsIds = updates.cashReceiptsIds;
		}

		if (updates.invoiceItemsIds) {
			newModelJson.invoiceItemsIds = updates.invoiceItemsIds;
		}

		return new RetailPharmacyInvoiceModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof RetailPharmacyInvoiceModel)) {
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
			'invoiceSummaryId',
			'invoiceSummary',
			'retailPharmacyId',
			'retailPharmacy',
			'cashReceiptsIds',
			'cashReceipts',
			'invoiceItemsIds',
			'invoiceItems',
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
		if (!this.invoiceSummary) {
			this.invoiceSummaryId = null;
		} else {
			this.invoiceSummaryId = this.invoiceSummary.id;
		}

		if (!this.retailPharmacy) {
			this.retailPharmacyId = null;
		} else {
			this.retailPharmacyId = this.retailPharmacy.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
