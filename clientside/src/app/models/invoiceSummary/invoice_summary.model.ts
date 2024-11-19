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
import {InvoiceModel} from '../invoice/invoice.model';
import {RetailPharmacyInvoiceModel} from '../retailPharmacyInvoice/retail_pharmacy_invoice.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class InvoiceSummaryModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'totalInvoice',
		'outstandingAmount',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'subTotal',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InvoiceSummaryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InvoiceSummaryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Total of Item Total from all Invoice Item (Price x Qty - Discount), with 2 decimal digits.
	 */
	subTotal: number;

	/**
	 * indicator whether the other discount is calculated in tax.
	 */
	taxOnOtherDiscount: boolean = false;

	/**
	 * Other Discount with 2 decimal digits.
	 */
	otherDiscount: number;

	/**
	 * indicator whether the other fee is calculated in tax.
	 */
	taxOnOtherFee: boolean = false;

	/**
	 * Other Fee with 2 decimal digits.
	 */
	otherFee: number;

	/**
	 * Tax amount, calculation from invoice item, Other Discount and Other Fee, with 2 decimal digits.
	 */
	tax: number;

	/**
	 * Total Invoice, sub total - other discount + other fee + Tax, with 2 decimal digits.
	 */
	totalInvoice: number;

	/**
	 * Available Down Payment being used to settle the Invoice.
	 */
	availableDownPayment: number;

	/**
	 * Total Coverage Amount/balance from Invoice Payment Insurance records (2 decimal digits).
	 */
	totalCoverage: number;

	/**
	 * Outstanding invoice amount to be paid (Total Invoice - Available Down Payment - Total Coverage), with 2 decimal digits.
	 */
	outstandingAmount: number;

	/**
	 * BPJS Coverage, take from INACBG server.
	 */
	bpjsCoverage: number;

	invoiceId: string;

	invoice: InvoiceModel;

	retailPharmacyInvoiceId: string;

	retailPharmacyInvoice: RetailPharmacyInvoiceModel;

	modelPropGroups: { [s: string]: Group } = InvoiceSummaryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'subTotal',
				// % protected region % [Set displayName for Sub Total here] off begin
				displayName: 'Sub Total',
				// % protected region % [Set displayName for Sub Total here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Sub Total here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Sub Total here] end
				// % protected region % [Set isSensitive for Sub Total here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sub Total here] end
				// % protected region % [Set readonly for Sub Total here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sub Total here] end
				validators: [
					// % protected region % [Add other validators for Sub Total here] off begin
					// % protected region % [Add other validators for Sub Total here] end
				],
				// % protected region % [Add any additional model attribute properties for Sub Total here] off begin
				// % protected region % [Add any additional model attribute properties for Sub Total here] end
			},
			{
				name: 'taxOnOtherDiscount',
				// % protected region % [Set displayName for Tax On Other Discount here] off begin
				displayName: 'Tax On Other Discount',
				// % protected region % [Set displayName for Tax On Other Discount here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Tax On Other Discount here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Tax On Other Discount here] end
				// % protected region % [Set isSensitive for Tax On Other Discount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax On Other Discount here] end
				// % protected region % [Set readonly for Tax On Other Discount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax On Other Discount here] end
				validators: [
					// % protected region % [Add other validators for Tax On Other Discount here] off begin
					// % protected region % [Add other validators for Tax On Other Discount here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax On Other Discount here] off begin
				// % protected region % [Add any additional model attribute properties for Tax On Other Discount here] end
			},
			{
				name: 'otherDiscount',
				// % protected region % [Set displayName for Other Discount here] off begin
				displayName: 'Other Discount',
				// % protected region % [Set displayName for Other Discount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Other Discount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Other Discount here] end
				// % protected region % [Set isSensitive for Other Discount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Discount here] end
				// % protected region % [Set readonly for Other Discount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Discount here] end
				validators: [
					// % protected region % [Add other validators for Other Discount here] off begin
					// % protected region % [Add other validators for Other Discount here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Discount here] off begin
				// % protected region % [Add any additional model attribute properties for Other Discount here] end
			},
			{
				name: 'taxOnOtherFee',
				// % protected region % [Set displayName for Tax On Other Fee here] off begin
				displayName: 'Tax On Other Fee',
				// % protected region % [Set displayName for Tax On Other Fee here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Tax On Other Fee here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Tax On Other Fee here] end
				// % protected region % [Set isSensitive for Tax On Other Fee here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax On Other Fee here] end
				// % protected region % [Set readonly for Tax On Other Fee here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax On Other Fee here] end
				validators: [
					// % protected region % [Add other validators for Tax On Other Fee here] off begin
					// % protected region % [Add other validators for Tax On Other Fee here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax On Other Fee here] off begin
				// % protected region % [Add any additional model attribute properties for Tax On Other Fee here] end
			},
			{
				name: 'otherFee',
				// % protected region % [Set displayName for Other Fee here] off begin
				displayName: 'Other Fee',
				// % protected region % [Set displayName for Other Fee here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Other Fee here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Other Fee here] end
				// % protected region % [Set isSensitive for Other Fee here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Fee here] end
				// % protected region % [Set readonly for Other Fee here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Fee here] end
				validators: [
					// % protected region % [Add other validators for Other Fee here] off begin
					// % protected region % [Add other validators for Other Fee here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Fee here] off begin
				// % protected region % [Add any additional model attribute properties for Other Fee here] end
			},
			{
				name: 'tax',
				// % protected region % [Set displayName for Tax here] off begin
				displayName: 'Tax',
				// % protected region % [Set displayName for Tax here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Tax here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Tax here] end
				// % protected region % [Set isSensitive for Tax here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax here] end
				// % protected region % [Set readonly for Tax here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax here] end
				validators: [
					// % protected region % [Add other validators for Tax here] off begin
					// % protected region % [Add other validators for Tax here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax here] off begin
				// % protected region % [Add any additional model attribute properties for Tax here] end
			},
			{
				name: 'totalInvoice',
				// % protected region % [Set displayName for Total Invoice here] off begin
				displayName: 'Total Invoice',
				// % protected region % [Set displayName for Total Invoice here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Invoice here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Invoice here] end
				// % protected region % [Set isSensitive for Total Invoice here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Invoice here] end
				// % protected region % [Set readonly for Total Invoice here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Invoice here] end
				validators: [
					// % protected region % [Add other validators for Total Invoice here] off begin
					// % protected region % [Add other validators for Total Invoice here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Invoice here] off begin
				// % protected region % [Add any additional model attribute properties for Total Invoice here] end
			},
			{
				name: 'availableDownPayment',
				// % protected region % [Set displayName for Available Down Payment here] off begin
				displayName: 'Available Down Payment',
				// % protected region % [Set displayName for Available Down Payment here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Available Down Payment here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Available Down Payment here] end
				// % protected region % [Set isSensitive for Available Down Payment here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Available Down Payment here] end
				// % protected region % [Set readonly for Available Down Payment here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Available Down Payment here] end
				validators: [
					// % protected region % [Add other validators for Available Down Payment here] off begin
					// % protected region % [Add other validators for Available Down Payment here] end
				],
				// % protected region % [Add any additional model attribute properties for Available Down Payment here] off begin
				// % protected region % [Add any additional model attribute properties for Available Down Payment here] end
			},
			{
				name: 'totalCoverage',
				// % protected region % [Set displayName for Total Coverage here] off begin
				displayName: 'Total Coverage',
				// % protected region % [Set displayName for Total Coverage here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Coverage here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Coverage here] end
				// % protected region % [Set isSensitive for Total Coverage here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Coverage here] end
				// % protected region % [Set readonly for Total Coverage here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Coverage here] end
				validators: [
					// % protected region % [Add other validators for Total Coverage here] off begin
					// % protected region % [Add other validators for Total Coverage here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Coverage here] off begin
				// % protected region % [Add any additional model attribute properties for Total Coverage here] end
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
				name: 'bpjsCoverage',
				// % protected region % [Set displayName for BPJS Coverage here] off begin
				displayName: 'BPJS Coverage',
				// % protected region % [Set displayName for BPJS Coverage here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for BPJS Coverage here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for BPJS Coverage here] end
				// % protected region % [Set isSensitive for BPJS Coverage here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BPJS Coverage here] end
				// % protected region % [Set readonly for BPJS Coverage here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BPJS Coverage here] end
				validators: [
					// % protected region % [Add other validators for BPJS Coverage here] off begin
					// % protected region % [Add other validators for BPJS Coverage here] end
				],
				// % protected region % [Add any additional model attribute properties for BPJS Coverage here] off begin
				// % protected region % [Add any additional model attribute properties for BPJS Coverage here] end
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
				id: 'invoice',
				type: ModelRelationType.ONE,
				name: 'invoiceId',
				// % protected region % [Customise your label for Invoice here] off begin
				label: 'Invoice',
				// % protected region % [Customise your label for Invoice here] end
				entityName: 'InvoiceModel',
				// % protected region % [Customise your display name for Invoice here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Invoice here] end
				validators: [
					// % protected region % [Add other validators for Invoice here] off begin
					// % protected region % [Add other validators for Invoice here] end
				],
				// % protected region % [Add any additional field for relation Invoice here] off begin
				// % protected region % [Add any additional field for relation Invoice here] end
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
				case 'totalInvoice':
					break;
				case 'outstandingAmount':
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
	static deepParse(data: string | { [K in keyof InvoiceSummaryModel]?: InvoiceSummaryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InvoiceSummaryModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.invoice) {
			currentModel.invoiceId = json.invoice.id;
			returned = _.union(returned, InvoiceModel.deepParse(json.invoice));
		}

		// Incoming one to one
		if (json.retailPharmacyInvoice) {
			currentModel.retailPharmacyInvoiceId = json.retailPharmacyInvoice.id;
			returned = _.union(returned, RetailPharmacyInvoiceModel.deepParse(json.retailPharmacyInvoice));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let invoiceSummaryModel = new InvoiceSummaryModel(data);`
	 *
	 * @param data The input data to be initialised as the InvoiceSummaryModel,
	 *    it is expected as a JSON string or as a nullable InvoiceSummaryModel.
	 */
	constructor(data?: string | Partial<InvoiceSummaryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InvoiceSummaryModel>
				: data;

			this.subTotal = json.subTotal;
			this.taxOnOtherDiscount = json.taxOnOtherDiscount;
			this.otherDiscount = json.otherDiscount;
			this.taxOnOtherFee = json.taxOnOtherFee;
			this.otherFee = json.otherFee;
			this.tax = json.tax;
			this.totalInvoice = json.totalInvoice;
			this.availableDownPayment = json.availableDownPayment;
			this.totalCoverage = json.totalCoverage;
			this.outstandingAmount = json.outstandingAmount;
			this.bpjsCoverage = json.bpjsCoverage;
			this.invoiceId = json.invoiceId;
			this.invoice = json.invoice;
			this.retailPharmacyInvoiceId = json.retailPharmacyInvoiceId;
			this.retailPharmacyInvoice = json.retailPharmacyInvoice;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			subTotal: this.subTotal,
			taxOnOtherDiscount: this.taxOnOtherDiscount,
			otherDiscount: this.otherDiscount,
			taxOnOtherFee: this.taxOnOtherFee,
			otherFee: this.otherFee,
			tax: this.tax,
			totalInvoice: this.totalInvoice,
			availableDownPayment: this.availableDownPayment,
			totalCoverage: this.totalCoverage,
			outstandingAmount: this.outstandingAmount,
			bpjsCoverage: this.bpjsCoverage,
			invoiceId: this.invoiceId,
			retailPharmacyInvoiceId: this.retailPharmacyInvoiceId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InvoiceSummaryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InvoiceSummaryModel {
		let newModelJson = this.toJSON();

		if (updates.subTotal) {
			newModelJson.subTotal = updates.subTotal;
		}

		if (updates.taxOnOtherDiscount) {
			newModelJson.taxOnOtherDiscount = updates.taxOnOtherDiscount;
		}

		if (updates.otherDiscount) {
			newModelJson.otherDiscount = updates.otherDiscount;
		}

		if (updates.taxOnOtherFee) {
			newModelJson.taxOnOtherFee = updates.taxOnOtherFee;
		}

		if (updates.otherFee) {
			newModelJson.otherFee = updates.otherFee;
		}

		if (updates.tax) {
			newModelJson.tax = updates.tax;
		}

		if (updates.totalInvoice) {
			newModelJson.totalInvoice = updates.totalInvoice;
		}

		if (updates.availableDownPayment) {
			newModelJson.availableDownPayment = updates.availableDownPayment;
		}

		if (updates.totalCoverage) {
			newModelJson.totalCoverage = updates.totalCoverage;
		}

		if (updates.outstandingAmount) {
			newModelJson.outstandingAmount = updates.outstandingAmount;
		}

		if (updates.bpjsCoverage) {
			newModelJson.bpjsCoverage = updates.bpjsCoverage;
		}

		if (updates.invoiceId) {
			newModelJson.invoiceId = updates.invoiceId;
		}

		if (updates.retailPharmacyInvoiceId) {
			newModelJson.retailPharmacyInvoiceId = updates.retailPharmacyInvoiceId;
		}

		return new InvoiceSummaryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InvoiceSummaryModel)) {
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
			'invoiceId',
			'invoice',
			'retailPharmacyInvoiceId',
			'retailPharmacyInvoice',
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
		if (!this.invoice) {
			this.invoiceId = null;
		} else {
			this.invoiceId = this.invoice.id;
		}

		if (!this.retailPharmacyInvoice) {
			this.retailPharmacyInvoiceId = null;
		} else {
			this.retailPharmacyInvoiceId = this.retailPharmacyInvoice.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
