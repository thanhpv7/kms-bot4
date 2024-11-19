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
import {InsuranceProviderModel} from '../insuranceProvider/insurance_provider.model';
import {InvoicePaymentInsuranceModel} from '../invoicePaymentInsurance/invoice_payment_insurance.model';
import {PatientPaymentInsuranceModel} from '../patientPaymentInsurance/patient_payment_insurance.model';
import {PatientVisitPatientPaymentInsuranceModel} from '../patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class InsuranceBenefitPlanModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'benefitPlanNo',
		'maximumCoveragePerTreatment',
		'maximumCoveragePerYear',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'benefitPlanNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InsuranceBenefitPlanModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InsuranceBenefitPlanModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Benefit Plan (Max Length: 50).
	 */
	benefitPlanNo: string;

	/**
	 * Benefit Plan Name (Max Length: 250).
	 */
	benefitPlanName: string;

	/**
	 * Maximum Coverage per Treatment.
	 */
	maximumCoveragePerTreatment: number;

	/**
	 * Maximum Coverage per Year.
	 */
	maximumCoveragePerYear: number;

	/**
	 * Created Date.
	 */
	createdDate: Date;

	/**
	 * Updated Date.
	 */
	updatedDate: Date;

	/**
	 * Notes (Max Length: 500).
	 */
	notes: string;

	insuranceProviderId: string;

	insuranceProvider: InsuranceProviderModel;

	invoicePaymentInsurancesIds: string[] = [];

	invoicePaymentInsurances: InvoicePaymentInsuranceModel[];

	patientPaymentInsurancesIds: string[] = [];

	patientPaymentInsurances: PatientPaymentInsuranceModel[];

	patientVisitPatientPaymentInsurancesIds: string[] = [];

	patientVisitPatientPaymentInsurances: PatientVisitPatientPaymentInsuranceModel[];

	modelPropGroups: { [s: string]: Group } = InsuranceBenefitPlanModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'benefitPlanNo',
				// % protected region % [Set displayName for Benefit Plan No here] off begin
				displayName: 'Benefit Plan No',
				// % protected region % [Set displayName for Benefit Plan No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Benefit Plan No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Benefit Plan No here] end
				// % protected region % [Set isSensitive for Benefit Plan No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Benefit Plan No here] end
				// % protected region % [Set readonly for Benefit Plan No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Benefit Plan No here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Benefit Plan No here] off begin
					// % protected region % [Add other validators for Benefit Plan No here] end
				],
				// % protected region % [Add any additional model attribute properties for Benefit Plan No here] off begin
				// % protected region % [Add any additional model attribute properties for Benefit Plan No here] end
			},
			{
				name: 'benefitPlanName',
				// % protected region % [Set displayName for Benefit Plan Name here] off begin
				displayName: 'Benefit Plan Name',
				// % protected region % [Set displayName for Benefit Plan Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Benefit Plan Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Benefit Plan Name here] end
				// % protected region % [Set isSensitive for Benefit Plan Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Benefit Plan Name here] end
				// % protected region % [Set readonly for Benefit Plan Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Benefit Plan Name here] end
				validators: [
					// % protected region % [Add other validators for Benefit Plan Name here] off begin
					// % protected region % [Add other validators for Benefit Plan Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Benefit Plan Name here] off begin
				// % protected region % [Add any additional model attribute properties for Benefit Plan Name here] end
			},
			{
				name: 'maximumCoveragePerTreatment',
				// % protected region % [Set displayName for Maximum Coverage per Treatment here] off begin
				displayName: 'Maximum Coverage per Treatment',
				// % protected region % [Set displayName for Maximum Coverage per Treatment here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Maximum Coverage per Treatment here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Maximum Coverage per Treatment here] end
				// % protected region % [Set isSensitive for Maximum Coverage per Treatment here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Maximum Coverage per Treatment here] end
				// % protected region % [Set readonly for Maximum Coverage per Treatment here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Maximum Coverage per Treatment here] end
				validators: [
					// % protected region % [Add other validators for Maximum Coverage per Treatment here] off begin
					// % protected region % [Add other validators for Maximum Coverage per Treatment here] end
				],
				// % protected region % [Add any additional model attribute properties for Maximum Coverage per Treatment here] off begin
				// % protected region % [Add any additional model attribute properties for Maximum Coverage per Treatment here] end
			},
			{
				name: 'maximumCoveragePerYear',
				// % protected region % [Set displayName for Maximum Coverage per Year here] off begin
				displayName: 'Maximum Coverage per Year',
				// % protected region % [Set displayName for Maximum Coverage per Year here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Maximum Coverage per Year here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Maximum Coverage per Year here] end
				// % protected region % [Set isSensitive for Maximum Coverage per Year here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Maximum Coverage per Year here] end
				// % protected region % [Set readonly for Maximum Coverage per Year here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Maximum Coverage per Year here] end
				validators: [
					// % protected region % [Add other validators for Maximum Coverage per Year here] off begin
					// % protected region % [Add other validators for Maximum Coverage per Year here] end
				],
				// % protected region % [Add any additional model attribute properties for Maximum Coverage per Year here] off begin
				// % protected region % [Add any additional model attribute properties for Maximum Coverage per Year here] end
			},
			{
				name: 'createdDate',
				// % protected region % [Set displayName for Created Date here] off begin
				displayName: 'Created Date',
				// % protected region % [Set displayName for Created Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Created Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Created Date here] end
				// % protected region % [Set isSensitive for Created Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Created Date here] end
				// % protected region % [Set readonly for Created Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Created Date here] end
				validators: [
					// % protected region % [Add other validators for Created Date here] off begin
					// % protected region % [Add other validators for Created Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Created Date here] off begin
				// % protected region % [Add any additional model attribute properties for Created Date here] end
			},
			{
				name: 'updatedDate',
				// % protected region % [Set displayName for Updated Date here] off begin
				displayName: 'Updated Date',
				// % protected region % [Set displayName for Updated Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Updated Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Updated Date here] end
				// % protected region % [Set isSensitive for Updated Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Updated Date here] end
				// % protected region % [Set readonly for Updated Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Updated Date here] end
				validators: [
					// % protected region % [Add other validators for Updated Date here] off begin
					// % protected region % [Add other validators for Updated Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Updated Date here] off begin
				// % protected region % [Add any additional model attribute properties for Updated Date here] end
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
				id: 'invoicePaymentInsurances',
				type: ModelRelationType.MANY,
				name: 'invoicePaymentInsurancesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Payment Insurances here] off begin
				label: 'Invoice Payment Insurances',
				// % protected region % [Customise your 1-1 or 1-M label for Invoice Payment Insurances here] end
				entityName: 'InvoicePaymentInsuranceModel',
				// % protected region % [Customise your display name for Invoice Payment Insurances here] off begin
				displayName: 'memberNo',
				// % protected region % [Customise your display name for Invoice Payment Insurances here] end
				validators: [
					// % protected region % [Add other validators for Invoice Payment Insurances here] off begin
					// % protected region % [Add other validators for Invoice Payment Insurances here] end
				],
				// % protected region % [Add any additional field for relation Invoice Payment Insurances here] off begin
				// % protected region % [Add any additional field for relation Invoice Payment Insurances here] end
			},
			{
				id: 'patientPaymentInsurances',
				type: ModelRelationType.MANY,
				name: 'patientPaymentInsurancesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Payment Insurances here] off begin
				label: 'Patient Payment Insurances',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Payment Insurances here] end
				entityName: 'PatientPaymentInsuranceModel',
				// % protected region % [Customise your display name for Patient Payment Insurances here] off begin
				displayName: 'memberNo',
				// % protected region % [Customise your display name for Patient Payment Insurances here] end
				validators: [
					// % protected region % [Add other validators for Patient Payment Insurances here] off begin
					// % protected region % [Add other validators for Patient Payment Insurances here] end
				],
				// % protected region % [Add any additional field for relation Patient Payment Insurances here] off begin
				// % protected region % [Add any additional field for relation Patient Payment Insurances here] end
			},
			{
				id: 'patientVisitPatientPaymentInsurances',
				type: ModelRelationType.MANY,
				name: 'patientVisitPatientPaymentInsurancesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Visit Patient Payment Insurances here] off begin
				label: 'Patient Visit Patient Payment Insurances',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Visit Patient Payment Insurances here] end
				entityName: 'PatientVisitPatientPaymentInsuranceModel',
				// % protected region % [Customise your display name for Patient Visit Patient Payment Insurances here] off begin
				displayName: 'memberNo',
				// % protected region % [Customise your display name for Patient Visit Patient Payment Insurances here] end
				validators: [
					// % protected region % [Add other validators for Patient Visit Patient Payment Insurances here] off begin
					// % protected region % [Add other validators for Patient Visit Patient Payment Insurances here] end
				],
				// % protected region % [Add any additional field for relation Patient Visit Patient Payment Insurances here] off begin
				// % protected region % [Add any additional field for relation Patient Visit Patient Payment Insurances here] end
			},
			{
				id: 'insuranceProvider',
				type: ModelRelationType.ONE,
				name: 'insuranceProviderId',
				// % protected region % [Customise your label for Insurance Provider here] off begin
				label: 'Insurance Provider',
				// % protected region % [Customise your label for Insurance Provider here] end
				entityName: 'InsuranceProviderModel',
				// % protected region % [Customise your display name for Insurance Provider here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'providerCode',
				// % protected region % [Customise your display name for Insurance Provider here] end
				validators: [
					// % protected region % [Add other validators for Insurance Provider here] off begin
					// % protected region % [Add other validators for Insurance Provider here] end
				],
				// % protected region % [Add any additional field for relation Insurance Provider here] off begin
				// % protected region % [Add any additional field for relation Insurance Provider here] end
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
				case 'benefitPlanNo':
					break;
				case 'maximumCoveragePerTreatment':
					break;
				case 'maximumCoveragePerYear':
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
	static deepParse(data: string | { [K in keyof InsuranceBenefitPlanModel]?: InsuranceBenefitPlanModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InsuranceBenefitPlanModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.insuranceProvider) {
			currentModel.insuranceProviderId = json.insuranceProvider.id;
			returned = _.union(returned, InsuranceProviderModel.deepParse(json.insuranceProvider));
		}

		// Outgoing one to many
		if (json.invoicePaymentInsurances) {
			currentModel.invoicePaymentInsurancesIds = json.invoicePaymentInsurances.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoicePaymentInsurances.map(model => InvoicePaymentInsuranceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.patientPaymentInsurances) {
			currentModel.patientPaymentInsurancesIds = json.patientPaymentInsurances.map(model => model.id);
			returned = _.union(returned, _.flatten(json.patientPaymentInsurances.map(model => PatientPaymentInsuranceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.patientVisitPatientPaymentInsurances) {
			currentModel.patientVisitPatientPaymentInsurancesIds = json.patientVisitPatientPaymentInsurances.map(model => model.id);
			returned = _.union(returned, _.flatten(json.patientVisitPatientPaymentInsurances.map(model => PatientVisitPatientPaymentInsuranceModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let insuranceBenefitPlanModel = new InsuranceBenefitPlanModel(data);`
	 *
	 * @param data The input data to be initialised as the InsuranceBenefitPlanModel,
	 *    it is expected as a JSON string or as a nullable InsuranceBenefitPlanModel.
	 */
	constructor(data?: string | Partial<InsuranceBenefitPlanModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InsuranceBenefitPlanModel>
				: data;

			this.benefitPlanNo = json.benefitPlanNo;
			this.benefitPlanName = json.benefitPlanName;
			this.maximumCoveragePerTreatment = json.maximumCoveragePerTreatment;
			this.maximumCoveragePerYear = json.maximumCoveragePerYear;
			if (json.createdDate) {
				this.createdDate = new Date(json.createdDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.createdDate = json.createdDate;
			}
			if (json.updatedDate) {
				this.updatedDate = new Date(json.updatedDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.updatedDate = json.updatedDate;
			}
			this.notes = json.notes;
			this.insuranceProviderId = json.insuranceProviderId;
			this.insuranceProvider = json.insuranceProvider;
			this.invoicePaymentInsurancesIds = json.invoicePaymentInsurancesIds;
			this.invoicePaymentInsurances = json.invoicePaymentInsurances;
			this.patientPaymentInsurancesIds = json.patientPaymentInsurancesIds;
			this.patientPaymentInsurances = json.patientPaymentInsurances;
			this.patientVisitPatientPaymentInsurancesIds = json.patientVisitPatientPaymentInsurancesIds;
			this.patientVisitPatientPaymentInsurances = json.patientVisitPatientPaymentInsurances;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			benefitPlanNo: this.benefitPlanNo,
			benefitPlanName: this.benefitPlanName,
			maximumCoveragePerTreatment: this.maximumCoveragePerTreatment,
			maximumCoveragePerYear: this.maximumCoveragePerYear,
			createdDate: this.createdDate,
			updatedDate: this.updatedDate,
			notes: this.notes,
			insuranceProviderId: this.insuranceProviderId,
			invoicePaymentInsurancesIds: this.invoicePaymentInsurancesIds,
			patientPaymentInsurancesIds: this.patientPaymentInsurancesIds,
			patientVisitPatientPaymentInsurancesIds: this.patientVisitPatientPaymentInsurancesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InsuranceBenefitPlanModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InsuranceBenefitPlanModel {
		let newModelJson = this.toJSON();

		if (updates.benefitPlanNo) {
			newModelJson.benefitPlanNo = updates.benefitPlanNo;
		}

		if (updates.benefitPlanName) {
			newModelJson.benefitPlanName = updates.benefitPlanName;
		}

		if (updates.maximumCoveragePerTreatment) {
			newModelJson.maximumCoveragePerTreatment = updates.maximumCoveragePerTreatment;
		}

		if (updates.maximumCoveragePerYear) {
			newModelJson.maximumCoveragePerYear = updates.maximumCoveragePerYear;
		}

		if (updates.createdDate) {
			newModelJson.createdDate = updates.createdDate;
		}

		if (updates.updatedDate) {
			newModelJson.updatedDate = updates.updatedDate;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.insuranceProviderId) {
			newModelJson.insuranceProviderId = updates.insuranceProviderId;
		}

		if (updates.invoicePaymentInsurancesIds) {
			newModelJson.invoicePaymentInsurancesIds = updates.invoicePaymentInsurancesIds;
		}

		if (updates.patientPaymentInsurancesIds) {
			newModelJson.patientPaymentInsurancesIds = updates.patientPaymentInsurancesIds;
		}

		if (updates.patientVisitPatientPaymentInsurancesIds) {
			newModelJson.patientVisitPatientPaymentInsurancesIds = updates.patientVisitPatientPaymentInsurancesIds;
		}

		return new InsuranceBenefitPlanModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InsuranceBenefitPlanModel)) {
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
			'insuranceProviderId',
			'insuranceProvider',
			'invoicePaymentInsurancesIds',
			'invoicePaymentInsurances',
			'patientPaymentInsurancesIds',
			'patientPaymentInsurances',
			'patientVisitPatientPaymentInsurancesIds',
			'patientVisitPatientPaymentInsurances',
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
		if (!this.insuranceProvider) {
			this.insuranceProviderId = null;
		} else {
			this.insuranceProviderId = this.insuranceProvider.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
