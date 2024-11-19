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
export class PatientPaymentInsuranceModel extends AbstractModel {
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

	readonly className = 'PatientPaymentInsuranceModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientPaymentInsuranceModel.displayAttributes.map((attr) => this[attr]).join(' ');
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

	patientGeneralInformationId: string;

	patientGeneralInformation: PatientGeneralInfoModel;

	insuranceBenefitPlanId: string;

	insuranceBenefitPlan: InsuranceBenefitPlanModel;

	modelPropGroups: { [s: string]: Group } = PatientPaymentInsuranceModel.modelPropGroups;

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
				id: 'patientGeneralInformation',
				type: ModelRelationType.ONE,
				name: 'patientGeneralInformationId',
				// % protected region % [Customise your label for Patient General Information here] off begin
				label: 'Patient General Information',
				// % protected region % [Customise your label for Patient General Information here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient General Information here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient General Information here] end
				validators: [
					// % protected region % [Add other validators for Patient General Information here] off begin
					// % protected region % [Add other validators for Patient General Information here] end
				],
				// % protected region % [Add any additional field for relation Patient General Information here] off begin
				// % protected region % [Add any additional field for relation Patient General Information here] end
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
	static deepParse(data: string | { [K in keyof PatientPaymentInsuranceModel]?: PatientPaymentInsuranceModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientPaymentInsuranceModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.patientGeneralInformation) {
			currentModel.patientGeneralInformationId = json.patientGeneralInformation.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInformation));
		}

		// Incoming one to many
		if (json.insuranceBenefitPlan) {
			currentModel.insuranceBenefitPlanId = json.insuranceBenefitPlan.id;
			returned = _.union(returned, InsuranceBenefitPlanModel.deepParse(json.insuranceBenefitPlan));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let patientPaymentInsuranceModel = new PatientPaymentInsuranceModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientPaymentInsuranceModel,
	 *    it is expected as a JSON string or as a nullable PatientPaymentInsuranceModel.
	 */
	constructor(data?: string | Partial<PatientPaymentInsuranceModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientPaymentInsuranceModel>
				: data;

			this.memberNo = json.memberNo;
			this.policyHolderNo = json.policyHolderNo;
			this.eligilityVerification = json.eligilityVerification;
			this.guaranteeLetterNo = json.guaranteeLetterNo;
			this.coverageBalance = json.coverageBalance;
			this.notes = json.notes;
			this.patientGeneralInformationId = json.patientGeneralInformationId;
			this.patientGeneralInformation = json.patientGeneralInformation;
			this.insuranceBenefitPlanId = json.insuranceBenefitPlanId;
			this.insuranceBenefitPlan = json.insuranceBenefitPlan;
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
			guaranteeLetterNo: this.guaranteeLetterNo,
			coverageBalance: this.coverageBalance,
			notes: this.notes,
			patientGeneralInformationId: this.patientGeneralInformationId,
			insuranceBenefitPlanId: this.insuranceBenefitPlanId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientPaymentInsuranceModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientPaymentInsuranceModel {
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

		if (updates.guaranteeLetterNo) {
			newModelJson.guaranteeLetterNo = updates.guaranteeLetterNo;
		}

		if (updates.coverageBalance) {
			newModelJson.coverageBalance = updates.coverageBalance;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.patientGeneralInformationId) {
			newModelJson.patientGeneralInformationId = updates.patientGeneralInformationId;
		}

		if (updates.insuranceBenefitPlanId) {
			newModelJson.insuranceBenefitPlanId = updates.insuranceBenefitPlanId;
		}

		return new PatientPaymentInsuranceModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientPaymentInsuranceModel)) {
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
			'patientGeneralInformationId',
			'patientGeneralInformation',
			'insuranceBenefitPlanId',
			'insuranceBenefitPlan',
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
		if (!this.patientGeneralInformation) {
			this.patientGeneralInformationId = null;
		} else {
			this.patientGeneralInformationId = this.patientGeneralInformation.id;
		}

		if (!this.insuranceBenefitPlan) {
			this.insuranceBenefitPlanId = null;
		} else {
			this.insuranceBenefitPlanId = this.insuranceBenefitPlan.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
