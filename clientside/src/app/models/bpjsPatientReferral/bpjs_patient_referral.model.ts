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
import {BpjsDiagnoseModel} from '../bpjsDiagnose/bpjs_diagnose.model';
import {BpjsHealthFacilityModel} from '../bpjsHealthFacility/bpjs_health_facility.model';
import {BpjsServiceMappingModel} from '../bpjsServiceMapping/bpjs_service_mapping.model';
import {PatientPaymentBPJSModel} from '../patientPaymentBPJS/patient_payment_bpjs.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsPatientReferralModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'referralNo',
		'referredType',
		'referralDate',
		'referalDatePlan',
		'treatmentType',
		'notes',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'noSEP',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPatientReferralModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPatientReferralModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	noSEP: string;

	/**
	 * .
	 */
	referralNo: string;

	/**
	 * .
	 */
	referredType: string;

	/**
	 * .
	 */
	referralDate: Date;

	/**
	 * .
	 */
	referalDatePlan: Date;

	/**
	 * .
	 */
	treatmentType: string;

	/**
	 * .
	 */
	notes: string;

	bpjsDiagnoseId: string;

	bpjsDiagnose: BpjsDiagnoseModel;

	bpjsHealthFacilityId: string;

	bpjsHealthFacility: BpjsHealthFacilityModel;

	bpjsServiceMappingId: string;

	bpjsServiceMapping: BpjsServiceMappingModel;

	patientPaymentBPJSId: string;

	patientPaymentBPJS: PatientPaymentBPJSModel;

	modelPropGroups: { [s: string]: Group } = BpjsPatientReferralModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'noSEP',
				// % protected region % [Set displayName for No SEP here] off begin
				displayName: 'No SEP',
				// % protected region % [Set displayName for No SEP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for No SEP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for No SEP here] end
				// % protected region % [Set isSensitive for No SEP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for No SEP here] end
				// % protected region % [Set readonly for No SEP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for No SEP here] end
				validators: [
					// % protected region % [Add other validators for No SEP here] off begin
					// % protected region % [Add other validators for No SEP here] end
				],
				// % protected region % [Add any additional model attribute properties for No SEP here] off begin
				// % protected region % [Add any additional model attribute properties for No SEP here] end
			},
			{
				name: 'referralNo',
				// % protected region % [Set displayName for Referral No here] off begin
				displayName: 'Referral No',
				// % protected region % [Set displayName for Referral No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral No here] end
				// % protected region % [Set isSensitive for Referral No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral No here] end
				// % protected region % [Set readonly for Referral No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral No here] end
				validators: [
					// % protected region % [Add other validators for Referral No here] off begin
					// % protected region % [Add other validators for Referral No here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral No here] off begin
				// % protected region % [Add any additional model attribute properties for Referral No here] end
			},
			{
				name: 'referredType',
				// % protected region % [Set displayName for Referred Type here] off begin
				displayName: 'Referred Type',
				// % protected region % [Set displayName for Referred Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referred Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referred Type here] end
				// % protected region % [Set isSensitive for Referred Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referred Type here] end
				// % protected region % [Set readonly for Referred Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referred Type here] end
				validators: [
					// % protected region % [Add other validators for Referred Type here] off begin
					// % protected region % [Add other validators for Referred Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Referred Type here] off begin
				// % protected region % [Add any additional model attribute properties for Referred Type here] end
			},
			{
				name: 'referralDate',
				// % protected region % [Set displayName for Referral Date here] off begin
				displayName: 'Referral Date',
				// % protected region % [Set displayName for Referral Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Referral Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Referral Date here] end
				// % protected region % [Set isSensitive for Referral Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral Date here] end
				// % protected region % [Set readonly for Referral Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral Date here] end
				validators: [
					// % protected region % [Add other validators for Referral Date here] off begin
					// % protected region % [Add other validators for Referral Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral Date here] off begin
				// % protected region % [Add any additional model attribute properties for Referral Date here] end
			},
			{
				name: 'referalDatePlan',
				// % protected region % [Set displayName for Referal Date Plan here] off begin
				displayName: 'Referal Date Plan',
				// % protected region % [Set displayName for Referal Date Plan here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Referal Date Plan here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Referal Date Plan here] end
				// % protected region % [Set isSensitive for Referal Date Plan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referal Date Plan here] end
				// % protected region % [Set readonly for Referal Date Plan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referal Date Plan here] end
				validators: [
					// % protected region % [Add other validators for Referal Date Plan here] off begin
					// % protected region % [Add other validators for Referal Date Plan here] end
				],
				// % protected region % [Add any additional model attribute properties for Referal Date Plan here] off begin
				// % protected region % [Add any additional model attribute properties for Referal Date Plan here] end
			},
			{
				name: 'treatmentType',
				// % protected region % [Set displayName for Treatment Type here] off begin
				displayName: 'Treatment Type',
				// % protected region % [Set displayName for Treatment Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Type here] end
				// % protected region % [Set isSensitive for Treatment Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Type here] end
				// % protected region % [Set readonly for Treatment Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Type here] end
				validators: [
					// % protected region % [Add other validators for Treatment Type here] off begin
					// % protected region % [Add other validators for Treatment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Type here] end
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
				id: 'bpjsDiagnose',
				type: ModelRelationType.ONE,
				name: 'bpjsDiagnoseId',
				// % protected region % [Customise your label for BPJS Diagnose here] off begin
				label: 'BPJS Diagnose',
				// % protected region % [Customise your label for BPJS Diagnose here] end
				entityName: 'BpjsDiagnoseModel',
				// % protected region % [Customise your display name for BPJS Diagnose here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Diagnose here] end
				validators: [
					// % protected region % [Add other validators for BPJS Diagnose here] off begin
					// % protected region % [Add other validators for BPJS Diagnose here] end
				],
				// % protected region % [Add any additional field for relation BPJS Diagnose here] off begin
				// % protected region % [Add any additional field for relation BPJS Diagnose here] end
			},
			{
				id: 'bpjsHealthFacility',
				type: ModelRelationType.ONE,
				name: 'bpjsHealthFacilityId',
				// % protected region % [Customise your label for BPJS Health Facility here] off begin
				label: 'BPJS Health Facility',
				// % protected region % [Customise your label for BPJS Health Facility here] end
				entityName: 'BpjsHealthFacilityModel',
				// % protected region % [Customise your display name for BPJS Health Facility here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Health Facility here] end
				validators: [
					// % protected region % [Add other validators for BPJS Health Facility here] off begin
					// % protected region % [Add other validators for BPJS Health Facility here] end
				],
				// % protected region % [Add any additional field for relation BPJS Health Facility here] off begin
				// % protected region % [Add any additional field for relation BPJS Health Facility here] end
			},
			{
				id: 'bpjsServiceMapping',
				type: ModelRelationType.ONE,
				name: 'bpjsServiceMappingId',
				// % protected region % [Customise your label for BPJS Service Mapping here] off begin
				label: 'BPJS Service Mapping',
				// % protected region % [Customise your label for BPJS Service Mapping here] end
				entityName: 'BpjsServiceMappingModel',
				// % protected region % [Customise your display name for BPJS Service Mapping here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Service Mapping here] end
				validators: [
					// % protected region % [Add other validators for BPJS Service Mapping here] off begin
					// % protected region % [Add other validators for BPJS Service Mapping here] end
				],
				// % protected region % [Add any additional field for relation BPJS Service Mapping here] off begin
				// % protected region % [Add any additional field for relation BPJS Service Mapping here] end
			},
			{
				id: 'patientPaymentBPJS',
				type: ModelRelationType.ONE,
				name: 'patientPaymentBPJSId',
				// % protected region % [Customise your label for Patient Payment BPJS here] off begin
				label: 'Patient Payment BPJS',
				// % protected region % [Customise your label for Patient Payment BPJS here] end
				entityName: 'PatientPaymentBPJSModel',
				// % protected region % [Customise your display name for Patient Payment BPJS here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'bpjsCardNo',
				// % protected region % [Customise your display name for Patient Payment BPJS here] end
				validators: [
					// % protected region % [Add other validators for Patient Payment BPJS here] off begin
					// % protected region % [Add other validators for Patient Payment BPJS here] end
				],
				// % protected region % [Add any additional field for relation Patient Payment BPJS here] off begin
				// % protected region % [Add any additional field for relation Patient Payment BPJS here] end
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
				case 'referralNo':
					break;
				case 'referredType':
					break;
				case 'referralDate':
					break;
				case 'referalDatePlan':
					break;
				case 'treatmentType':
					break;
				case 'notes':
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
	static deepParse(data: string | { [K in keyof BpjsPatientReferralModel]?: BpjsPatientReferralModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPatientReferralModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.bpjsDiagnose) {
			currentModel.bpjsDiagnoseId = json.bpjsDiagnose.id;
			returned = _.union(returned, BpjsDiagnoseModel.deepParse(json.bpjsDiagnose));
		}

		// Incoming one to many
		if (json.bpjsHealthFacility) {
			currentModel.bpjsHealthFacilityId = json.bpjsHealthFacility.id;
			returned = _.union(returned, BpjsHealthFacilityModel.deepParse(json.bpjsHealthFacility));
		}

		// Incoming one to many
		if (json.bpjsServiceMapping) {
			currentModel.bpjsServiceMappingId = json.bpjsServiceMapping.id;
			returned = _.union(returned, BpjsServiceMappingModel.deepParse(json.bpjsServiceMapping));
		}

		// Incoming one to many
		if (json.patientPaymentBPJS) {
			currentModel.patientPaymentBPJSId = json.patientPaymentBPJS.id;
			returned = _.union(returned, PatientPaymentBPJSModel.deepParse(json.patientPaymentBPJS));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsPatientReferralModel = new BpjsPatientReferralModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPatientReferralModel,
	 *    it is expected as a JSON string or as a nullable BpjsPatientReferralModel.
	 */
	constructor(data?: string | Partial<BpjsPatientReferralModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPatientReferralModel>
				: data;

			this.noSEP = json.noSEP;
			this.referralNo = json.referralNo;
			this.referredType = json.referredType;
			if (json.referralDate) {
				this.referralDate = new Date(json.referralDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.referralDate = json.referralDate;
			}
			if (json.referalDatePlan) {
				this.referalDatePlan = new Date(json.referalDatePlan);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.referalDatePlan = json.referalDatePlan;
			}
			this.treatmentType = json.treatmentType;
			this.notes = json.notes;
			this.bpjsDiagnoseId = json.bpjsDiagnoseId;
			this.bpjsDiagnose = json.bpjsDiagnose;
			this.bpjsHealthFacilityId = json.bpjsHealthFacilityId;
			this.bpjsHealthFacility = json.bpjsHealthFacility;
			this.bpjsServiceMappingId = json.bpjsServiceMappingId;
			this.bpjsServiceMapping = json.bpjsServiceMapping;
			this.patientPaymentBPJSId = json.patientPaymentBPJSId;
			this.patientPaymentBPJS = json.patientPaymentBPJS;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			noSEP: this.noSEP,
			referralNo: this.referralNo,
			referredType: this.referredType,
			referralDate: this.referralDate,
			referalDatePlan: this.referalDatePlan,
			treatmentType: this.treatmentType,
			notes: this.notes,
			bpjsDiagnoseId: this.bpjsDiagnoseId,
			bpjsHealthFacilityId: this.bpjsHealthFacilityId,
			bpjsServiceMappingId: this.bpjsServiceMappingId,
			patientPaymentBPJSId: this.patientPaymentBPJSId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPatientReferralModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPatientReferralModel {
		let newModelJson = this.toJSON();

		if (updates.noSEP) {
			newModelJson.noSEP = updates.noSEP;
		}

		if (updates.referralNo) {
			newModelJson.referralNo = updates.referralNo;
		}

		if (updates.referredType) {
			newModelJson.referredType = updates.referredType;
		}

		if (updates.referralDate) {
			newModelJson.referralDate = updates.referralDate;
		}

		if (updates.referalDatePlan) {
			newModelJson.referalDatePlan = updates.referalDatePlan;
		}

		if (updates.treatmentType) {
			newModelJson.treatmentType = updates.treatmentType;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.bpjsDiagnoseId) {
			newModelJson.bpjsDiagnoseId = updates.bpjsDiagnoseId;
		}

		if (updates.bpjsHealthFacilityId) {
			newModelJson.bpjsHealthFacilityId = updates.bpjsHealthFacilityId;
		}

		if (updates.bpjsServiceMappingId) {
			newModelJson.bpjsServiceMappingId = updates.bpjsServiceMappingId;
		}

		if (updates.patientPaymentBPJSId) {
			newModelJson.patientPaymentBPJSId = updates.patientPaymentBPJSId;
		}

		return new BpjsPatientReferralModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPatientReferralModel)) {
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
			'bpjsDiagnoseId',
			'bpjsDiagnose',
			'bpjsHealthFacilityId',
			'bpjsHealthFacility',
			'bpjsServiceMappingId',
			'bpjsServiceMapping',
			'patientPaymentBPJSId',
			'patientPaymentBPJS',
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
		if (!this.bpjsDiagnose) {
			this.bpjsDiagnoseId = null;
		} else {
			this.bpjsDiagnoseId = this.bpjsDiagnose.id;
		}

		if (!this.bpjsHealthFacility) {
			this.bpjsHealthFacilityId = null;
		} else {
			this.bpjsHealthFacilityId = this.bpjsHealthFacility.id;
		}

		if (!this.bpjsServiceMapping) {
			this.bpjsServiceMappingId = null;
		} else {
			this.bpjsServiceMappingId = this.bpjsServiceMapping.id;
		}

		if (!this.patientPaymentBPJS) {
			this.patientPaymentBPJSId = null;
		} else {
			this.patientPaymentBPJSId = this.patientPaymentBPJS.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
