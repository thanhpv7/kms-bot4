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
import {InsuranceBenefitPlanModel} from '../insuranceBenefitPlan/insurance_benefit_plan.model';
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
export class InvoicePaymentInsuranceModel extends AbstractModel {
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
		'memberNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InvoicePaymentInsuranceModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InvoicePaymentInsuranceModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Insurance Member No of patient (Max Length: 50).
	 */
	memberNo: string;

	/**
	 * Policy Holder No of insurance member (Max Length: 50).
	 */
	policyHolderNo: string;

	/**
	 * Eligility Verification,  get the Code from Reference Data where Type=ELIGILITY_VER. (Max Length: 20).
	 */
	eligilityVerification: string;

	/**
	 * .
	 */
	verificationDate: Date;

	/**
	 * Guarantee Letter No of insurance member (Max Length: 50).
	 */
	guaranteeLetterNo: string;

	/**
	 * Coverage Balance (with limitation on 2 decimal digits).
	 */
	coverageBalance: number;

	/**
	 * Notes (Max Length: 5000).
	 */
	notes: string;

	/**
	 * Main Insurance, only 1 record is TRUE and others must be FALSE.
	 */
	mainInsurance: boolean = false;

	insuranceBenefitPlanId: string;

	insuranceBenefitPlan: InsuranceBenefitPlanModel;

	invoiceId: string;

	invoice: InvoiceModel;

	modelPropGroups: { [s: string]: Group } = InvoicePaymentInsuranceModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'memberNo',
				// % protected region % [Set displayName for Member No here] off begin
				displayName: 'Member No',
				// % protected region % [Set displayName for Member No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Member No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Member No here] end
				// % protected region % [Set isSensitive for Member No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Member No here] end
				// % protected region % [Set readonly for Member No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Member No here] end
				validators: [
					// % protected region % [Add other validators for Member No here] off begin
					// % protected region % [Add other validators for Member No here] end
				],
				// % protected region % [Add any additional model attribute properties for Member No here] off begin
				// % protected region % [Add any additional model attribute properties for Member No here] end
			},
			{
				name: 'policyHolderNo',
				// % protected region % [Set displayName for Policy Holder No here] off begin
				displayName: 'Policy Holder No',
				// % protected region % [Set displayName for Policy Holder No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Policy Holder No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Policy Holder No here] end
				// % protected region % [Set isSensitive for Policy Holder No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Policy Holder No here] end
				// % protected region % [Set readonly for Policy Holder No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Policy Holder No here] end
				validators: [
					// % protected region % [Add other validators for Policy Holder No here] off begin
					// % protected region % [Add other validators for Policy Holder No here] end
				],
				// % protected region % [Add any additional model attribute properties for Policy Holder No here] off begin
				// % protected region % [Add any additional model attribute properties for Policy Holder No here] end
			},
			{
				name: 'eligilityVerification',
				// % protected region % [Set displayName for Eligility Verification here] off begin
				displayName: 'Eligility Verification',
				// % protected region % [Set displayName for Eligility Verification here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Eligility Verification here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Eligility Verification here] end
				// % protected region % [Set isSensitive for Eligility Verification here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Eligility Verification here] end
				// % protected region % [Set readonly for Eligility Verification here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Eligility Verification here] end
				validators: [
					// % protected region % [Add other validators for Eligility Verification here] off begin
					// % protected region % [Add other validators for Eligility Verification here] end
				],
				// % protected region % [Add any additional model attribute properties for Eligility Verification here] off begin
				// % protected region % [Add any additional model attribute properties for Eligility Verification here] end
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
				name: 'guaranteeLetterNo',
				// % protected region % [Set displayName for Guarantee Letter No here] off begin
				displayName: 'Guarantee Letter No',
				// % protected region % [Set displayName for Guarantee Letter No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Guarantee Letter No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Guarantee Letter No here] end
				// % protected region % [Set isSensitive for Guarantee Letter No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Guarantee Letter No here] end
				// % protected region % [Set readonly for Guarantee Letter No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Guarantee Letter No here] end
				validators: [
					// % protected region % [Add other validators for Guarantee Letter No here] off begin
					// % protected region % [Add other validators for Guarantee Letter No here] end
				],
				// % protected region % [Add any additional model attribute properties for Guarantee Letter No here] off begin
				// % protected region % [Add any additional model attribute properties for Guarantee Letter No here] end
			},
			{
				name: 'coverageBalance',
				// % protected region % [Set displayName for Coverage Balance here] off begin
				displayName: 'Coverage Balance',
				// % protected region % [Set displayName for Coverage Balance here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Coverage Balance here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Coverage Balance here] end
				// % protected region % [Set isSensitive for Coverage Balance here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Coverage Balance here] end
				// % protected region % [Set readonly for Coverage Balance here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Coverage Balance here] end
				validators: [
					// % protected region % [Add other validators for Coverage Balance here] off begin
					// % protected region % [Add other validators for Coverage Balance here] end
				],
				// % protected region % [Add any additional model attribute properties for Coverage Balance here] off begin
				// % protected region % [Add any additional model attribute properties for Coverage Balance here] end
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
				name: 'mainInsurance',
				// % protected region % [Set displayName for Main Insurance here] off begin
				displayName: 'Main Insurance',
				// % protected region % [Set displayName for Main Insurance here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Main Insurance here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Main Insurance here] end
				// % protected region % [Set isSensitive for Main Insurance here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Main Insurance here] end
				// % protected region % [Set readonly for Main Insurance here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Main Insurance here] end
				validators: [
					// % protected region % [Add other validators for Main Insurance here] off begin
					// % protected region % [Add other validators for Main Insurance here] end
				],
				// % protected region % [Add any additional model attribute properties for Main Insurance here] off begin
				// % protected region % [Add any additional model attribute properties for Main Insurance here] end
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
				id: 'insuranceBenefitPlan',
				type: ModelRelationType.ONE,
				name: 'insuranceBenefitPlanId',
				// % protected region % [Customise your label for Insurance Benefit Plan here] off begin
				label: 'Insurance Benefit Plan',
				// % protected region % [Customise your label for Insurance Benefit Plan here] end
				entityName: 'InsuranceBenefitPlanModel',
				// % protected region % [Customise your display name for Insurance Benefit Plan here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'benefitPlanNo',
				// % protected region % [Customise your display name for Insurance Benefit Plan here] end
				validators: [
					// % protected region % [Add other validators for Insurance Benefit Plan here] off begin
					// % protected region % [Add other validators for Insurance Benefit Plan here] end
				],
				// % protected region % [Add any additional field for relation Insurance Benefit Plan here] off begin
				// % protected region % [Add any additional field for relation Insurance Benefit Plan here] end
			},
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
	static deepParse(data: string | { [K in keyof InvoicePaymentInsuranceModel]?: InvoicePaymentInsuranceModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InvoicePaymentInsuranceModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.insuranceBenefitPlan) {
			currentModel.insuranceBenefitPlanId = json.insuranceBenefitPlan.id;
			returned = _.union(returned, InsuranceBenefitPlanModel.deepParse(json.insuranceBenefitPlan));
		}

		// Incoming one to many
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
	 * `let invoicePaymentInsuranceModel = new InvoicePaymentInsuranceModel(data);`
	 *
	 * @param data The input data to be initialised as the InvoicePaymentInsuranceModel,
	 *    it is expected as a JSON string or as a nullable InvoicePaymentInsuranceModel.
	 */
	constructor(data?: string | Partial<InvoicePaymentInsuranceModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InvoicePaymentInsuranceModel>
				: data;

			this.memberNo = json.memberNo;
			this.policyHolderNo = json.policyHolderNo;
			this.eligilityVerification = json.eligilityVerification;
			if (json.verificationDate) {
				this.verificationDate = new Date(json.verificationDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.verificationDate = json.verificationDate;
			}
			this.guaranteeLetterNo = json.guaranteeLetterNo;
			this.coverageBalance = json.coverageBalance;
			this.notes = json.notes;
			this.mainInsurance = json.mainInsurance;
			this.insuranceBenefitPlanId = json.insuranceBenefitPlanId;
			this.insuranceBenefitPlan = json.insuranceBenefitPlan;
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
			memberNo: this.memberNo,
			policyHolderNo: this.policyHolderNo,
			eligilityVerification: this.eligilityVerification,
			verificationDate: this.verificationDate,
			guaranteeLetterNo: this.guaranteeLetterNo,
			coverageBalance: this.coverageBalance,
			notes: this.notes,
			mainInsurance: this.mainInsurance,
			insuranceBenefitPlanId: this.insuranceBenefitPlanId,
			invoiceId: this.invoiceId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InvoicePaymentInsuranceModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InvoicePaymentInsuranceModel {
		let newModelJson = this.toJSON();

		if (updates.memberNo) {
			newModelJson.memberNo = updates.memberNo;
		}

		if (updates.policyHolderNo) {
			newModelJson.policyHolderNo = updates.policyHolderNo;
		}

		if (updates.eligilityVerification) {
			newModelJson.eligilityVerification = updates.eligilityVerification;
		}

		if (updates.verificationDate) {
			newModelJson.verificationDate = updates.verificationDate;
		}

		if (updates.guaranteeLetterNo) {
			newModelJson.guaranteeLetterNo = updates.guaranteeLetterNo;
		}

		if (updates.coverageBalance) {
			newModelJson.coverageBalance = updates.coverageBalance;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.mainInsurance) {
			newModelJson.mainInsurance = updates.mainInsurance;
		}

		if (updates.insuranceBenefitPlanId) {
			newModelJson.insuranceBenefitPlanId = updates.insuranceBenefitPlanId;
		}

		if (updates.invoiceId) {
			newModelJson.invoiceId = updates.invoiceId;
		}

		return new InvoicePaymentInsuranceModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InvoicePaymentInsuranceModel)) {
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
			'insuranceBenefitPlanId',
			'insuranceBenefitPlan',
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
		if (!this.insuranceBenefitPlan) {
			this.insuranceBenefitPlanId = null;
		} else {
			this.insuranceBenefitPlanId = this.insuranceBenefitPlan.id;
		}

		if (!this.invoice) {
			this.invoiceId = null;
		} else {
			this.invoiceId = this.invoice.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
