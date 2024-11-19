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
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class InvoicePaymentSelfPayingModel extends AbstractModel {
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
		'sponsorName',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InvoicePaymentSelfPayingModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InvoicePaymentSelfPayingModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Name of person who responsible for patient's charging.(Max Length: 250).
	 */
	sponsorName: string;

	/**
	 * The address of person who is the sponsor of patient (Max Length: 250).
	 */
	sponsorAddress: string;

	/**
	 * Phone No of person who is the sponsor of patient. (Max Length: 50).
	 */
	sponsorPhoneNo: string;

	/**
	 * Relationship between emergency contact and patient, get the Code from Reference Data where Type=PATIENT_RELATION. (Max Length: 20).
	 */
	sponsorship: string;

	invoiceId: string;

	invoice: InvoiceModel;

	modelPropGroups: { [s: string]: Group } = InvoicePaymentSelfPayingModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'sponsorName',
				// % protected region % [Set displayName for Sponsor Name here] off begin
				displayName: 'Sponsor Name',
				// % protected region % [Set displayName for Sponsor Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sponsor Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sponsor Name here] end
				// % protected region % [Set isSensitive for Sponsor Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sponsor Name here] end
				// % protected region % [Set readonly for Sponsor Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sponsor Name here] end
				validators: [
					// % protected region % [Add other validators for Sponsor Name here] off begin
					// % protected region % [Add other validators for Sponsor Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Sponsor Name here] off begin
				// % protected region % [Add any additional model attribute properties for Sponsor Name here] end
			},
			{
				name: 'sponsorAddress',
				// % protected region % [Set displayName for Sponsor Address here] off begin
				displayName: 'Sponsor Address',
				// % protected region % [Set displayName for Sponsor Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sponsor Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sponsor Address here] end
				// % protected region % [Set isSensitive for Sponsor Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sponsor Address here] end
				// % protected region % [Set readonly for Sponsor Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sponsor Address here] end
				validators: [
					// % protected region % [Add other validators for Sponsor Address here] off begin
					// % protected region % [Add other validators for Sponsor Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Sponsor Address here] off begin
				// % protected region % [Add any additional model attribute properties for Sponsor Address here] end
			},
			{
				name: 'sponsorPhoneNo',
				// % protected region % [Set displayName for Sponsor Phone No here] off begin
				displayName: 'Sponsor Phone No',
				// % protected region % [Set displayName for Sponsor Phone No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sponsor Phone No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sponsor Phone No here] end
				// % protected region % [Set isSensitive for Sponsor Phone No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sponsor Phone No here] end
				// % protected region % [Set readonly for Sponsor Phone No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sponsor Phone No here] end
				validators: [
					// % protected region % [Add other validators for Sponsor Phone No here] off begin
					// % protected region % [Add other validators for Sponsor Phone No here] end
				],
				// % protected region % [Add any additional model attribute properties for Sponsor Phone No here] off begin
				// % protected region % [Add any additional model attribute properties for Sponsor Phone No here] end
			},
			{
				name: 'sponsorship',
				// % protected region % [Set displayName for Sponsorship here] off begin
				displayName: 'Sponsorship',
				// % protected region % [Set displayName for Sponsorship here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sponsorship here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sponsorship here] end
				// % protected region % [Set isSensitive for Sponsorship here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sponsorship here] end
				// % protected region % [Set readonly for Sponsorship here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sponsorship here] end
				validators: [
					// % protected region % [Add other validators for Sponsorship here] off begin
					// % protected region % [Add other validators for Sponsorship here] end
				],
				// % protected region % [Add any additional model attribute properties for Sponsorship here] off begin
				// % protected region % [Add any additional model attribute properties for Sponsorship here] end
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
	static deepParse(data: string | { [K in keyof InvoicePaymentSelfPayingModel]?: InvoicePaymentSelfPayingModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InvoicePaymentSelfPayingModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.invoice) {
			currentModel.invoiceId = json.invoice.id;
			returned = _.union(returned, InvoiceModel.deepParse(json.invoice));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let invoicePaymentSelfPayingModel = new InvoicePaymentSelfPayingModel(data);`
	 *
	 * @param data The input data to be initialised as the InvoicePaymentSelfPayingModel,
	 *    it is expected as a JSON string or as a nullable InvoicePaymentSelfPayingModel.
	 */
	constructor(data?: string | Partial<InvoicePaymentSelfPayingModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InvoicePaymentSelfPayingModel>
				: data;

			this.sponsorName = json.sponsorName;
			this.sponsorAddress = json.sponsorAddress;
			this.sponsorPhoneNo = json.sponsorPhoneNo;
			this.sponsorship = json.sponsorship;
			this.invoiceId = json.invoiceId;
			this.invoice = json.invoice;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			sponsorName: this.sponsorName,
			sponsorAddress: this.sponsorAddress,
			sponsorPhoneNo: this.sponsorPhoneNo,
			sponsorship: this.sponsorship,
			invoiceId: this.invoiceId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InvoicePaymentSelfPayingModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InvoicePaymentSelfPayingModel {
		let newModelJson = this.toJSON();

		if (updates.sponsorName) {
			newModelJson.sponsorName = updates.sponsorName;
		}

		if (updates.sponsorAddress) {
			newModelJson.sponsorAddress = updates.sponsorAddress;
		}

		if (updates.sponsorPhoneNo) {
			newModelJson.sponsorPhoneNo = updates.sponsorPhoneNo;
		}

		if (updates.sponsorship) {
			newModelJson.sponsorship = updates.sponsorship;
		}

		if (updates.invoiceId) {
			newModelJson.invoiceId = updates.invoiceId;
		}

		return new InvoicePaymentSelfPayingModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InvoicePaymentSelfPayingModel)) {
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

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
