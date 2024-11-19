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
import {CashTypeEnum, cashTypeEnumArray} from '../../enums/cash-type.enum';
import {SourceDocumentTypeEnum, sourceDocumentTypeEnumArray} from '../../enums/source-document-type.enum';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class CashAllocationModel extends AbstractModel {
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
		'cashType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'CashAllocationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return CashAllocationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	allocatedDate: Date;

	/**
	 * .
	 */
	sourceDate: Date;

	/**
	 * Receipt Number or Refund Number (Max Length: 50).
	 */
	cashNumber: string;

	/**
	 * Number of source from cast allocation. It is Patient Invoice Number, or Receipt Number/Deposit (Max Length: 50) .
	 */
	sourceNumber: string;

	/**
	 * Transaction amount, copy from Invoice Amount (if Source Doc type is Patient Invoice), or Available Amount (if the Source Doc Type is Patient Receipt/Deposit).
	 */
	sourceAmount: number;

	/**
	 * Outstanding Amount of invoice summary, if Source Doc Type is Patient Invoice. Available amount of cash receipt, if source doc type is Patient Receipt.
	 */
	outstandingAmount: number;

	/**
	 * .
	 */
	allocatedAmount: number;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=2, example=Sally}.
	 */
	cashType: CashTypeEnum;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=6, example=Sally}.
	 */
	sourceDocumentType: SourceDocumentTypeEnum;



	modelPropGroups: { [s: string]: Group } = CashAllocationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'cashType',
				// % protected region % [Set displayName for Cash Type here] off begin
				displayName: 'Cash Type',
				// % protected region % [Set displayName for Cash Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: cashTypeEnumArray,
				// % protected region % [Set display element type for Cash Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Cash Type here] end
				// % protected region % [Set isSensitive for Cash Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cash Type here] end
				// % protected region % [Set readonly for Cash Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cash Type here] end
				validators: [
					// % protected region % [Add other validators for Cash Type here] off begin
					// % protected region % [Add other validators for Cash Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Cash Type here] off begin
				// % protected region % [Add any additional model attribute properties for Cash Type here] end
			},
			{
				name: 'allocatedDate',
				// % protected region % [Set displayName for Allocated Date here] off begin
				displayName: 'Allocated Date',
				// % protected region % [Set displayName for Allocated Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Allocated Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Allocated Date here] end
				// % protected region % [Set isSensitive for Allocated Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Allocated Date here] end
				// % protected region % [Set readonly for Allocated Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Allocated Date here] end
				validators: [
					// % protected region % [Add other validators for Allocated Date here] off begin
					// % protected region % [Add other validators for Allocated Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Allocated Date here] off begin
				// % protected region % [Add any additional model attribute properties for Allocated Date here] end
			},
			{
				name: 'sourceDate',
				// % protected region % [Set displayName for Source Date here] off begin
				displayName: 'Source Date',
				// % protected region % [Set displayName for Source Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Source Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Source Date here] end
				// % protected region % [Set isSensitive for Source Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Date here] end
				// % protected region % [Set readonly for Source Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Date here] end
				validators: [
					// % protected region % [Add other validators for Source Date here] off begin
					// % protected region % [Add other validators for Source Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Date here] off begin
				// % protected region % [Add any additional model attribute properties for Source Date here] end
			},
			{
				name: 'cashNumber',
				// % protected region % [Set displayName for Cash Number here] off begin
				displayName: 'Cash Number',
				// % protected region % [Set displayName for Cash Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Cash Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Cash Number here] end
				// % protected region % [Set isSensitive for Cash Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cash Number here] end
				// % protected region % [Set readonly for Cash Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cash Number here] end
				validators: [
					// % protected region % [Add other validators for Cash Number here] off begin
					// % protected region % [Add other validators for Cash Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Cash Number here] off begin
				// % protected region % [Add any additional model attribute properties for Cash Number here] end
			},
			{
				name: 'sourceDocumentType',
				// % protected region % [Set displayName for Source Document Type here] off begin
				displayName: 'Source Document Type',
				// % protected region % [Set displayName for Source Document Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: sourceDocumentTypeEnumArray,
				// % protected region % [Set display element type for Source Document Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Source Document Type here] end
				// % protected region % [Set isSensitive for Source Document Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Document Type here] end
				// % protected region % [Set readonly for Source Document Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Document Type here] end
				validators: [
					// % protected region % [Add other validators for Source Document Type here] off begin
					// % protected region % [Add other validators for Source Document Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Document Type here] off begin
				// % protected region % [Add any additional model attribute properties for Source Document Type here] end
			},
			{
				name: 'sourceNumber',
				// % protected region % [Set displayName for Source Number here] off begin
				displayName: 'Source Number',
				// % protected region % [Set displayName for Source Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Source Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Source Number here] end
				// % protected region % [Set isSensitive for Source Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Number here] end
				// % protected region % [Set readonly for Source Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Number here] end
				validators: [
					// % protected region % [Add other validators for Source Number here] off begin
					// % protected region % [Add other validators for Source Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Number here] off begin
				// % protected region % [Add any additional model attribute properties for Source Number here] end
			},
			{
				name: 'sourceAmount',
				// % protected region % [Set displayName for Source Amount here] off begin
				displayName: 'Source Amount',
				// % protected region % [Set displayName for Source Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Source Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Source Amount here] end
				// % protected region % [Set isSensitive for Source Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Source Amount here] end
				// % protected region % [Set readonly for Source Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Source Amount here] end
				validators: [
					// % protected region % [Add other validators for Source Amount here] off begin
					// % protected region % [Add other validators for Source Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Source Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Source Amount here] end
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
	static deepParse(data: string | { [K in keyof CashAllocationModel]?: CashAllocationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new CashAllocationModel(data);
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
	 * `let cashAllocationModel = new CashAllocationModel(data);`
	 *
	 * @param data The input data to be initialised as the CashAllocationModel,
	 *    it is expected as a JSON string or as a nullable CashAllocationModel.
	 */
	constructor(data?: string | Partial<CashAllocationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<CashAllocationModel>
				: data;

			this.cashType = json.cashType;
			if (json.allocatedDate) {
				this.allocatedDate = new Date(json.allocatedDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.allocatedDate = json.allocatedDate;
			}
			if (json.sourceDate) {
				this.sourceDate = new Date(json.sourceDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.sourceDate = json.sourceDate;
			}
			this.cashNumber = json.cashNumber;
			this.sourceDocumentType = json.sourceDocumentType;
			this.sourceNumber = json.sourceNumber;
			this.sourceAmount = json.sourceAmount;
			this.outstandingAmount = json.outstandingAmount;
			this.allocatedAmount = json.allocatedAmount;
			this.cashType = json.cashType;
			this.sourceDocumentType = json.sourceDocumentType;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			cashType: this.cashType,
			allocatedDate: this.allocatedDate,
			sourceDate: this.sourceDate,
			cashNumber: this.cashNumber,
			sourceDocumentType: this.sourceDocumentType,
			sourceNumber: this.sourceNumber,
			sourceAmount: this.sourceAmount,
			outstandingAmount: this.outstandingAmount,
			allocatedAmount: this.allocatedAmount,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		CashAllocationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): CashAllocationModel {
		let newModelJson = this.toJSON();

		if (updates.cashType) {
			newModelJson.cashType = updates.cashType;
		}

		if (updates.allocatedDate) {
			newModelJson.allocatedDate = updates.allocatedDate;
		}

		if (updates.sourceDate) {
			newModelJson.sourceDate = updates.sourceDate;
		}

		if (updates.cashNumber) {
			newModelJson.cashNumber = updates.cashNumber;
		}

		if (updates.sourceDocumentType) {
			newModelJson.sourceDocumentType = updates.sourceDocumentType;
		}

		if (updates.sourceNumber) {
			newModelJson.sourceNumber = updates.sourceNumber;
		}

		if (updates.sourceAmount) {
			newModelJson.sourceAmount = updates.sourceAmount;
		}

		if (updates.outstandingAmount) {
			newModelJson.outstandingAmount = updates.outstandingAmount;
		}

		if (updates.allocatedAmount) {
			newModelJson.allocatedAmount = updates.allocatedAmount;
		}

		if (updates.cashType) {
			newModelJson.cashType = updates.cashType;
		}

		if (updates.sourceDocumentType) {
			newModelJson.sourceDocumentType = updates.sourceDocumentType;
		}

		return new CashAllocationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof CashAllocationModel)) {
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
