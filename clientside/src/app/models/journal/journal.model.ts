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
export class JournalModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'journalNumber',
		'transactionDate',
		'referenceNumber',
		'transactionType',
		'transactionDetailType',
		'accountNumber',
		'debit',
		'credit',
		'postingStatus',
		'postingDateTime',
		'supplierNumber',
		'supplierName',
		'customerNumber',
		'customerName',
		'revenueCenter',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'journalNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'JournalModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return JournalModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	journalNumber: string;

	/**
	 * .
	 */
	transactionDate: Date;

	/**
	 * .
	 */
	referenceNumber: string;

	/**
	 * .
	 */
	transactionType: string;

	/**
	 * .
	 */
	transactionDetailType: string;

	/**
	 * .
	 */
	accountNumber: string;

	/**
	 * .
	 */
	debit: number;

	/**
	 * .
	 */
	credit: number;

	/**
	 * .
	 */
	postingStatus: string;

	/**
	 * .
	 */
	postingDateTime: Date;

	/**
	 * .
	 */
	supplierNumber: string;

	/**
	 * .
	 */
	supplierName: string;

	/**
	 * .
	 */
	customerNumber: string;

	/**
	 * .
	 */
	customerName: string;

	/**
	 * .
	 */
	revenueCenter: string;

	/**
	 * .
	 */
	description: string;



	modelPropGroups: { [s: string]: Group } = JournalModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'journalNumber',
				// % protected region % [Set displayName for Journal Number here] off begin
				displayName: 'Journal Number',
				// % protected region % [Set displayName for Journal Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Journal Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Journal Number here] end
				// % protected region % [Set isSensitive for Journal Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Journal Number here] end
				// % protected region % [Set readonly for Journal Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Journal Number here] end
				validators: [
					// % protected region % [Add other validators for Journal Number here] off begin
					// % protected region % [Add other validators for Journal Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Journal Number here] off begin
				// % protected region % [Add any additional model attribute properties for Journal Number here] end
			},
			{
				name: 'transactionDate',
				// % protected region % [Set displayName for Transaction Date here] off begin
				displayName: 'Transaction Date',
				// % protected region % [Set displayName for Transaction Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Transaction Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Transaction Date here] end
				// % protected region % [Set isSensitive for Transaction Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Date here] end
				// % protected region % [Set readonly for Transaction Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Date here] end
				validators: [
					// % protected region % [Add other validators for Transaction Date here] off begin
					// % protected region % [Add other validators for Transaction Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Date here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Date here] end
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
				name: 'transactionType',
				// % protected region % [Set displayName for Transaction Type here] off begin
				displayName: 'Transaction Type',
				// % protected region % [Set displayName for Transaction Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Type here] end
				// % protected region % [Set isSensitive for Transaction Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Type here] end
				// % protected region % [Set readonly for Transaction Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Type here] end
				validators: [
					// % protected region % [Add other validators for Transaction Type here] off begin
					// % protected region % [Add other validators for Transaction Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Type here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Type here] end
			},
			{
				name: 'transactionDetailType',
				// % protected region % [Set displayName for Transaction Detail Type here] off begin
				displayName: 'Transaction Detail Type',
				// % protected region % [Set displayName for Transaction Detail Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transaction Detail Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transaction Detail Type here] end
				// % protected region % [Set isSensitive for Transaction Detail Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transaction Detail Type here] end
				// % protected region % [Set readonly for Transaction Detail Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transaction Detail Type here] end
				validators: [
					// % protected region % [Add other validators for Transaction Detail Type here] off begin
					// % protected region % [Add other validators for Transaction Detail Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Transaction Detail Type here] off begin
				// % protected region % [Add any additional model attribute properties for Transaction Detail Type here] end
			},
			{
				name: 'accountNumber',
				// % protected region % [Set displayName for Account Number here] off begin
				displayName: 'Account Number',
				// % protected region % [Set displayName for Account Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Account Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Account Number here] end
				// % protected region % [Set isSensitive for Account Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Account Number here] end
				// % protected region % [Set readonly for Account Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Account Number here] end
				validators: [
					// % protected region % [Add other validators for Account Number here] off begin
					// % protected region % [Add other validators for Account Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Account Number here] off begin
				// % protected region % [Add any additional model attribute properties for Account Number here] end
			},
			{
				name: 'debit',
				// % protected region % [Set displayName for Debit here] off begin
				displayName: 'Debit',
				// % protected region % [Set displayName for Debit here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Debit here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Debit here] end
				// % protected region % [Set isSensitive for Debit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Debit here] end
				// % protected region % [Set readonly for Debit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Debit here] end
				validators: [
					// % protected region % [Add other validators for Debit here] off begin
					// % protected region % [Add other validators for Debit here] end
				],
				// % protected region % [Add any additional model attribute properties for Debit here] off begin
				// % protected region % [Add any additional model attribute properties for Debit here] end
			},
			{
				name: 'credit',
				// % protected region % [Set displayName for Credit here] off begin
				displayName: 'Credit',
				// % protected region % [Set displayName for Credit here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Credit here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Credit here] end
				// % protected region % [Set isSensitive for Credit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Credit here] end
				// % protected region % [Set readonly for Credit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Credit here] end
				validators: [
					// % protected region % [Add other validators for Credit here] off begin
					// % protected region % [Add other validators for Credit here] end
				],
				// % protected region % [Add any additional model attribute properties for Credit here] off begin
				// % protected region % [Add any additional model attribute properties for Credit here] end
			},
			{
				name: 'postingStatus',
				// % protected region % [Set displayName for Posting Status here] off begin
				displayName: 'Posting Status',
				// % protected region % [Set displayName for Posting Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Posting Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Posting Status here] end
				// % protected region % [Set isSensitive for Posting Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Posting Status here] end
				// % protected region % [Set readonly for Posting Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Posting Status here] end
				validators: [
					// % protected region % [Add other validators for Posting Status here] off begin
					// % protected region % [Add other validators for Posting Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Posting Status here] off begin
				// % protected region % [Add any additional model attribute properties for Posting Status here] end
			},
			{
				name: 'postingDateTime',
				// % protected region % [Set displayName for Posting Date Time here] off begin
				displayName: 'Posting Date Time',
				// % protected region % [Set displayName for Posting Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Posting Date Time here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Posting Date Time here] end
				// % protected region % [Set isSensitive for Posting Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Posting Date Time here] end
				// % protected region % [Set readonly for Posting Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Posting Date Time here] end
				validators: [
					// % protected region % [Add other validators for Posting Date Time here] off begin
					// % protected region % [Add other validators for Posting Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Posting Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Posting Date Time here] end
			},
			{
				name: 'supplierNumber',
				// % protected region % [Set displayName for Supplier Number here] off begin
				displayName: 'Supplier Number',
				// % protected region % [Set displayName for Supplier Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Supplier Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Supplier Number here] end
				// % protected region % [Set isSensitive for Supplier Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Supplier Number here] end
				// % protected region % [Set readonly for Supplier Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Supplier Number here] end
				validators: [
					// % protected region % [Add other validators for Supplier Number here] off begin
					// % protected region % [Add other validators for Supplier Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Supplier Number here] off begin
				// % protected region % [Add any additional model attribute properties for Supplier Number here] end
			},
			{
				name: 'supplierName',
				// % protected region % [Set displayName for Supplier Name here] off begin
				displayName: 'Supplier Name',
				// % protected region % [Set displayName for Supplier Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Supplier Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Supplier Name here] end
				// % protected region % [Set isSensitive for Supplier Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Supplier Name here] end
				// % protected region % [Set readonly for Supplier Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Supplier Name here] end
				validators: [
					// % protected region % [Add other validators for Supplier Name here] off begin
					// % protected region % [Add other validators for Supplier Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Supplier Name here] off begin
				// % protected region % [Add any additional model attribute properties for Supplier Name here] end
			},
			{
				name: 'customerNumber',
				// % protected region % [Set displayName for Customer Number here] off begin
				displayName: 'Customer Number',
				// % protected region % [Set displayName for Customer Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Customer Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Customer Number here] end
				// % protected region % [Set isSensitive for Customer Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Customer Number here] end
				// % protected region % [Set readonly for Customer Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Customer Number here] end
				validators: [
					// % protected region % [Add other validators for Customer Number here] off begin
					// % protected region % [Add other validators for Customer Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Customer Number here] off begin
				// % protected region % [Add any additional model attribute properties for Customer Number here] end
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
			{
				name: 'revenueCenter',
				// % protected region % [Set displayName for Revenue Center here] off begin
				displayName: 'Revenue Center',
				// % protected region % [Set displayName for Revenue Center here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Revenue Center here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Revenue Center here] end
				// % protected region % [Set isSensitive for Revenue Center here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Revenue Center here] end
				// % protected region % [Set readonly for Revenue Center here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Revenue Center here] end
				validators: [
					// % protected region % [Add other validators for Revenue Center here] off begin
					// % protected region % [Add other validators for Revenue Center here] end
				],
				// % protected region % [Add any additional model attribute properties for Revenue Center here] off begin
				// % protected region % [Add any additional model attribute properties for Revenue Center here] end
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
					// % protected region % [Add other validators for Description here] off begin
					// % protected region % [Add other validators for Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Description here] off begin
				// % protected region % [Add any additional model attribute properties for Description here] end
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
				case 'journalNumber':
					break;
				case 'transactionDate':
					break;
				case 'referenceNumber':
					break;
				case 'transactionType':
					break;
				case 'transactionDetailType':
					break;
				case 'accountNumber':
					break;
				case 'debit':
					break;
				case 'credit':
					break;
				case 'postingStatus':
					break;
				case 'postingDateTime':
					break;
				case 'supplierNumber':
					break;
				case 'supplierName':
					break;
				case 'customerNumber':
					break;
				case 'customerName':
					break;
				case 'revenueCenter':
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
	static deepParse(data: string | { [K in keyof JournalModel]?: JournalModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new JournalModel(data);
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
	 * `let journalModel = new JournalModel(data);`
	 *
	 * @param data The input data to be initialised as the JournalModel,
	 *    it is expected as a JSON string or as a nullable JournalModel.
	 */
	constructor(data?: string | Partial<JournalModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<JournalModel>
				: data;

			this.journalNumber = json.journalNumber;
			if (json.transactionDate) {
				this.transactionDate = new Date(json.transactionDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.transactionDate = json.transactionDate;
			}
			this.referenceNumber = json.referenceNumber;
			this.transactionType = json.transactionType;
			this.transactionDetailType = json.transactionDetailType;
			this.accountNumber = json.accountNumber;
			this.debit = json.debit;
			this.credit = json.credit;
			this.postingStatus = json.postingStatus;
			if (json.postingDateTime) {
				this.postingDateTime = new Date(json.postingDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.postingDateTime = json.postingDateTime;
			}
			this.supplierNumber = json.supplierNumber;
			this.supplierName = json.supplierName;
			this.customerNumber = json.customerNumber;
			this.customerName = json.customerName;
			this.revenueCenter = json.revenueCenter;
			this.description = json.description;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			journalNumber: this.journalNumber,
			transactionDate: this.transactionDate,
			referenceNumber: this.referenceNumber,
			transactionType: this.transactionType,
			transactionDetailType: this.transactionDetailType,
			accountNumber: this.accountNumber,
			debit: this.debit,
			credit: this.credit,
			postingStatus: this.postingStatus,
			postingDateTime: this.postingDateTime,
			supplierNumber: this.supplierNumber,
			supplierName: this.supplierName,
			customerNumber: this.customerNumber,
			customerName: this.customerName,
			revenueCenter: this.revenueCenter,
			description: this.description,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		JournalModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): JournalModel {
		let newModelJson = this.toJSON();

		if (updates.journalNumber) {
			newModelJson.journalNumber = updates.journalNumber;
		}

		if (updates.transactionDate) {
			newModelJson.transactionDate = updates.transactionDate;
		}

		if (updates.referenceNumber) {
			newModelJson.referenceNumber = updates.referenceNumber;
		}

		if (updates.transactionType) {
			newModelJson.transactionType = updates.transactionType;
		}

		if (updates.transactionDetailType) {
			newModelJson.transactionDetailType = updates.transactionDetailType;
		}

		if (updates.accountNumber) {
			newModelJson.accountNumber = updates.accountNumber;
		}

		if (updates.debit) {
			newModelJson.debit = updates.debit;
		}

		if (updates.credit) {
			newModelJson.credit = updates.credit;
		}

		if (updates.postingStatus) {
			newModelJson.postingStatus = updates.postingStatus;
		}

		if (updates.postingDateTime) {
			newModelJson.postingDateTime = updates.postingDateTime;
		}

		if (updates.supplierNumber) {
			newModelJson.supplierNumber = updates.supplierNumber;
		}

		if (updates.supplierName) {
			newModelJson.supplierName = updates.supplierName;
		}

		if (updates.customerNumber) {
			newModelJson.customerNumber = updates.customerNumber;
		}

		if (updates.customerName) {
			newModelJson.customerName = updates.customerName;
		}

		if (updates.revenueCenter) {
			newModelJson.revenueCenter = updates.revenueCenter;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		return new JournalModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof JournalModel)) {
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
