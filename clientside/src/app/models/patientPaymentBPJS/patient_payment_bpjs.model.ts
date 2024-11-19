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
import {BpjsAccidentMasterModel} from '../bpjsAccidentMaster/bpjs_accident_master.model';
import {BpjsClaimSubmissionModel} from '../bpjsClaimSubmission/bpjs_claim_submission.model';
import {BpjsHospitalizationPlanModel} from '../bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import {BpjsJasaRaharjaModel} from '../bpjsJasaRaharja/bpjs_jasa_raharja.model';
import {BpjsPatientReferralModel} from '../bpjsPatientReferral/bpjs_patient_referral.model';
import {BpjsSEPModel} from '../bpjsSEP/bpjs_sep.model';
import {BpjsSEPSubmissionModel} from '../bpjsSEPSubmission/bpjs_sep_submission.model';
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
export class PatientPaymentBPJSModel extends AbstractModel {
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
		'bpjsCardNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PatientPaymentBPJSModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientPaymentBPJSModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * BPJS Card No (Max Length: 50).
	 */
	bpjsCardNo: string;

	/**
	 * BPJS Notes.
	 */
	notes: string;

	patientGeneralInfoId: string;

	patientGeneralInfo: PatientGeneralInfoModel;

	bpjsAccidentMastersIds: string[] = [];

	bpjsAccidentMasters: BpjsAccidentMasterModel[];

	bpjsClaimSubmissionsIds: string[] = [];

	bpjsClaimSubmissions: BpjsClaimSubmissionModel[];

	bpjsHospitalizationPlansIds: string[] = [];

	bpjsHospitalizationPlans: BpjsHospitalizationPlanModel[];

	bpjsJasaRaharjasIds: string[] = [];

	bpjsJasaRaharjas: BpjsJasaRaharjaModel[];

	bpjsPatientReferralsIds: string[] = [];

	bpjsPatientReferrals: BpjsPatientReferralModel[];

	bpjsSEPSubmissionsIds: string[] = [];

	bpjsSEPSubmissions: BpjsSEPSubmissionModel[];

	bpjsSEPsIds: string[] = [];

	bpjsSEPs: BpjsSEPModel[];

	modelPropGroups: { [s: string]: Group } = PatientPaymentBPJSModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'bpjsCardNo',
				// % protected region % [Set displayName for BPJS Card No here] off begin
				displayName: 'BPJS Card No',
				// % protected region % [Set displayName for BPJS Card No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BPJS Card No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BPJS Card No here] end
				// % protected region % [Set isSensitive for BPJS Card No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BPJS Card No here] end
				// % protected region % [Set readonly for BPJS Card No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BPJS Card No here] end
				validators: [
					// % protected region % [Add other validators for BPJS Card No here] off begin
					// % protected region % [Add other validators for BPJS Card No here] end
				],
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] off begin
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] end
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
				id: 'bpjsAccidentMasters',
				type: ModelRelationType.MANY,
				name: 'bpjsAccidentMastersIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Accident Masters here] off begin
				label: 'BPJS Accident Masters',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Accident Masters here] end
				entityName: 'BpjsAccidentMasterModel',
				// % protected region % [Customise your display name for BPJS Accident Masters here] off begin
				displayName: 'nosep',
				// % protected region % [Customise your display name for BPJS Accident Masters here] end
				validators: [
					// % protected region % [Add other validators for BPJS Accident Masters here] off begin
					// % protected region % [Add other validators for BPJS Accident Masters here] end
				],
				// % protected region % [Add any additional field for relation BPJS Accident Masters here] off begin
				// % protected region % [Add any additional field for relation BPJS Accident Masters here] end
			},
			{
				id: 'bpjsClaimSubmissions',
				type: ModelRelationType.MANY,
				name: 'bpjsClaimSubmissionsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Claim Submissions here] off begin
				label: 'BPJS Claim Submissions',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Claim Submissions here] end
				entityName: 'BpjsClaimSubmissionModel',
				// % protected region % [Customise your display name for BPJS Claim Submissions here] off begin
				displayName: 'sepNo',
				// % protected region % [Customise your display name for BPJS Claim Submissions here] end
				validators: [
					// % protected region % [Add other validators for BPJS Claim Submissions here] off begin
					// % protected region % [Add other validators for BPJS Claim Submissions here] end
				],
				// % protected region % [Add any additional field for relation BPJS Claim Submissions here] off begin
				// % protected region % [Add any additional field for relation BPJS Claim Submissions here] end
			},
			{
				id: 'bpjsHospitalizationPlans',
				type: ModelRelationType.MANY,
				name: 'bpjsHospitalizationPlansIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Hospitalization Plans here] off begin
				label: 'BPJS Hospitalization Plans',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Hospitalization Plans here] end
				entityName: 'BpjsHospitalizationPlanModel',
				// % protected region % [Customise your display name for BPJS Hospitalization Plans here] off begin
				displayName: 'nokartu',
				// % protected region % [Customise your display name for BPJS Hospitalization Plans here] end
				validators: [
					// % protected region % [Add other validators for BPJS Hospitalization Plans here] off begin
					// % protected region % [Add other validators for BPJS Hospitalization Plans here] end
				],
				// % protected region % [Add any additional field for relation BPJS Hospitalization Plans here] off begin
				// % protected region % [Add any additional field for relation BPJS Hospitalization Plans here] end
			},
			{
				id: 'bpjsJasaRaharjas',
				type: ModelRelationType.MANY,
				name: 'bpjsJasaRaharjasIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Jasa Raharjas here] off begin
				label: 'BPJS Jasa Raharjas',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Jasa Raharjas here] end
				entityName: 'BpjsJasaRaharjaModel',
				// % protected region % [Customise your display name for BPJS Jasa Raharjas here] off begin
				displayName: 'initialSEPNo',
				// % protected region % [Customise your display name for BPJS Jasa Raharjas here] end
				validators: [
					// % protected region % [Add other validators for BPJS Jasa Raharjas here] off begin
					// % protected region % [Add other validators for BPJS Jasa Raharjas here] end
				],
				// % protected region % [Add any additional field for relation BPJS Jasa Raharjas here] off begin
				// % protected region % [Add any additional field for relation BPJS Jasa Raharjas here] end
			},
			{
				id: 'bpjsPatientReferrals',
				type: ModelRelationType.MANY,
				name: 'bpjsPatientReferralsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Patient Referrals here] off begin
				label: 'BPJS Patient Referrals',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Patient Referrals here] end
				entityName: 'BpjsPatientReferralModel',
				// % protected region % [Customise your display name for BPJS Patient Referrals here] off begin
				displayName: 'noSEP',
				// % protected region % [Customise your display name for BPJS Patient Referrals here] end
				validators: [
					// % protected region % [Add other validators for BPJS Patient Referrals here] off begin
					// % protected region % [Add other validators for BPJS Patient Referrals here] end
				],
				// % protected region % [Add any additional field for relation BPJS Patient Referrals here] off begin
				// % protected region % [Add any additional field for relation BPJS Patient Referrals here] end
			},
			{
				id: 'bpjsSEPSubmissions',
				type: ModelRelationType.MANY,
				name: 'bpjsSEPSubmissionsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS SEP Submissions here] off begin
				label: 'BPJS SEP Submissions',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS SEP Submissions here] end
				entityName: 'BpjsSEPSubmissionModel',
				// % protected region % [Customise your display name for BPJS SEP Submissions here] off begin
				displayName: 'status',
				// % protected region % [Customise your display name for BPJS SEP Submissions here] end
				validators: [
					// % protected region % [Add other validators for BPJS SEP Submissions here] off begin
					// % protected region % [Add other validators for BPJS SEP Submissions here] end
				],
				// % protected region % [Add any additional field for relation BPJS SEP Submissions here] off begin
				// % protected region % [Add any additional field for relation BPJS SEP Submissions here] end
			},
			{
				id: 'bpjsSEPs',
				type: ModelRelationType.MANY,
				name: 'bpjsSEPsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS SEPs here] off begin
				label: 'BPJS SEPs',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS SEPs here] end
				entityName: 'BpjsSEPModel',
				// % protected region % [Customise your display name for BPJS SEPs here] off begin
				displayName: 'noSEP',
				// % protected region % [Customise your display name for BPJS SEPs here] end
				validators: [
					// % protected region % [Add other validators for BPJS SEPs here] off begin
					// % protected region % [Add other validators for BPJS SEPs here] end
				],
				// % protected region % [Add any additional field for relation BPJS SEPs here] off begin
				// % protected region % [Add any additional field for relation BPJS SEPs here] end
			},
			{
				id: 'patientGeneralInfo',
				type: ModelRelationType.ONE,
				name: 'patientGeneralInfoId',
				// % protected region % [Customise your label for Patient General Info here] off begin
				label: 'Patient General Info',
				// % protected region % [Customise your label for Patient General Info here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient General Info here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient General Info here] end
				validators: [
					// % protected region % [Add other validators for Patient General Info here] off begin
					// % protected region % [Add other validators for Patient General Info here] end
				],
				// % protected region % [Add any additional field for relation Patient General Info here] off begin
				// % protected region % [Add any additional field for relation Patient General Info here] end
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
	static deepParse(data: string | { [K in keyof PatientPaymentBPJSModel]?: PatientPaymentBPJSModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientPaymentBPJSModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.patientGeneralInfo) {
			currentModel.patientGeneralInfoId = json.patientGeneralInfo.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInfo));
		}

		// Outgoing one to many
		if (json.bpjsAccidentMasters) {
			currentModel.bpjsAccidentMastersIds = json.bpjsAccidentMasters.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsAccidentMasters.map(model => BpjsAccidentMasterModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsClaimSubmissions) {
			currentModel.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsClaimSubmissions.map(model => BpjsClaimSubmissionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsHospitalizationPlans) {
			currentModel.bpjsHospitalizationPlansIds = json.bpjsHospitalizationPlans.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsHospitalizationPlans.map(model => BpjsHospitalizationPlanModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsJasaRaharjas) {
			currentModel.bpjsJasaRaharjasIds = json.bpjsJasaRaharjas.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsJasaRaharjas.map(model => BpjsJasaRaharjaModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsPatientReferrals) {
			currentModel.bpjsPatientReferralsIds = json.bpjsPatientReferrals.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsPatientReferrals.map(model => BpjsPatientReferralModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsSEPSubmissions) {
			currentModel.bpjsSEPSubmissionsIds = json.bpjsSEPSubmissions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsSEPSubmissions.map(model => BpjsSEPSubmissionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsSEPs) {
			currentModel.bpjsSEPsIds = json.bpjsSEPs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsSEPs.map(model => BpjsSEPModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let patientPaymentBPJSModel = new PatientPaymentBPJSModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientPaymentBPJSModel,
	 *    it is expected as a JSON string or as a nullable PatientPaymentBPJSModel.
	 */
	constructor(data?: string | Partial<PatientPaymentBPJSModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientPaymentBPJSModel>
				: data;

			this.bpjsCardNo = json.bpjsCardNo;
			this.notes = json.notes;
			this.patientGeneralInfoId = json.patientGeneralInfoId;
			this.patientGeneralInfo = json.patientGeneralInfo;
			this.bpjsAccidentMastersIds = json.bpjsAccidentMastersIds;
			this.bpjsAccidentMasters = json.bpjsAccidentMasters;
			this.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissionsIds;
			this.bpjsClaimSubmissions = json.bpjsClaimSubmissions;
			this.bpjsHospitalizationPlansIds = json.bpjsHospitalizationPlansIds;
			this.bpjsHospitalizationPlans = json.bpjsHospitalizationPlans;
			this.bpjsJasaRaharjasIds = json.bpjsJasaRaharjasIds;
			this.bpjsJasaRaharjas = json.bpjsJasaRaharjas;
			this.bpjsPatientReferralsIds = json.bpjsPatientReferralsIds;
			this.bpjsPatientReferrals = json.bpjsPatientReferrals;
			this.bpjsSEPSubmissionsIds = json.bpjsSEPSubmissionsIds;
			this.bpjsSEPSubmissions = json.bpjsSEPSubmissions;
			this.bpjsSEPsIds = json.bpjsSEPsIds;
			this.bpjsSEPs = json.bpjsSEPs;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			bpjsCardNo: this.bpjsCardNo,
			notes: this.notes,
			patientGeneralInfoId: this.patientGeneralInfoId,
			bpjsAccidentMastersIds: this.bpjsAccidentMastersIds,
			bpjsClaimSubmissionsIds: this.bpjsClaimSubmissionsIds,
			bpjsHospitalizationPlansIds: this.bpjsHospitalizationPlansIds,
			bpjsJasaRaharjasIds: this.bpjsJasaRaharjasIds,
			bpjsPatientReferralsIds: this.bpjsPatientReferralsIds,
			bpjsSEPSubmissionsIds: this.bpjsSEPSubmissionsIds,
			bpjsSEPsIds: this.bpjsSEPsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientPaymentBPJSModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientPaymentBPJSModel {
		let newModelJson = this.toJSON();

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.patientGeneralInfoId) {
			newModelJson.patientGeneralInfoId = updates.patientGeneralInfoId;
		}

		if (updates.bpjsAccidentMastersIds) {
			newModelJson.bpjsAccidentMastersIds = updates.bpjsAccidentMastersIds;
		}

		if (updates.bpjsClaimSubmissionsIds) {
			newModelJson.bpjsClaimSubmissionsIds = updates.bpjsClaimSubmissionsIds;
		}

		if (updates.bpjsHospitalizationPlansIds) {
			newModelJson.bpjsHospitalizationPlansIds = updates.bpjsHospitalizationPlansIds;
		}

		if (updates.bpjsJasaRaharjasIds) {
			newModelJson.bpjsJasaRaharjasIds = updates.bpjsJasaRaharjasIds;
		}

		if (updates.bpjsPatientReferralsIds) {
			newModelJson.bpjsPatientReferralsIds = updates.bpjsPatientReferralsIds;
		}

		if (updates.bpjsSEPSubmissionsIds) {
			newModelJson.bpjsSEPSubmissionsIds = updates.bpjsSEPSubmissionsIds;
		}

		if (updates.bpjsSEPsIds) {
			newModelJson.bpjsSEPsIds = updates.bpjsSEPsIds;
		}

		return new PatientPaymentBPJSModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientPaymentBPJSModel)) {
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
			'patientGeneralInfoId',
			'patientGeneralInfo',
			'bpjsAccidentMastersIds',
			'bpjsAccidentMasters',
			'bpjsClaimSubmissionsIds',
			'bpjsClaimSubmissions',
			'bpjsHospitalizationPlansIds',
			'bpjsHospitalizationPlans',
			'bpjsJasaRaharjasIds',
			'bpjsJasaRaharjas',
			'bpjsPatientReferralsIds',
			'bpjsPatientReferrals',
			'bpjsSEPSubmissionsIds',
			'bpjsSEPSubmissions',
			'bpjsSEPsIds',
			'bpjsSEPs',
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
		if (!this.patientGeneralInfo) {
			this.patientGeneralInfoId = null;
		} else {
			this.patientGeneralInfoId = this.patientGeneralInfo.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
