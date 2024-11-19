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
import {BpjsClaimSubmissionModel} from '../bpjsClaimSubmission/bpjs_claim_submission.model';
import {BpjsPatientReferralModel} from '../bpjsPatientReferral/bpjs_patient_referral.model';
import {BpjsSpecialReferralModel} from '../bpjsSpecialReferral/bpjs_special_referral.model';
import {DiagnosesAndProceduresModel} from '../diagnosesAndProcedures/diagnoses_and_procedures.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsDiagnoseModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'refCode',
		'refName',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'refCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsDiagnoseModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsDiagnoseModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	refCode: string;

	/**
	 * Nama Diagnosa.
	 */
	refName: string;

	diagnosesAndProceduresId: string;

	diagnosesAndProcedures: DiagnosesAndProceduresModel;

	additionalDiagnoseIds: string[] = [];

	additionalDiagnose: BpjsSpecialReferralModel[];

	bpjsClaimSubmissionsIds: string[] = [];

	bpjsClaimSubmissions: BpjsClaimSubmissionModel[];

	bpjsPatientReferralsIds: string[] = [];

	bpjsPatientReferrals: BpjsPatientReferralModel[];

	primaryDiagnoseIds: string[] = [];

	primaryDiagnose: BpjsSpecialReferralModel[];

	modelPropGroups: { [s: string]: Group } = BpjsDiagnoseModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'refCode',
				// % protected region % [Set displayName for Ref Code here] off begin
				displayName: 'Ref Code',
				// % protected region % [Set displayName for Ref Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ref Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ref Code here] end
				// % protected region % [Set isSensitive for Ref Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ref Code here] end
				// % protected region % [Set readonly for Ref Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ref Code here] end
				validators: [
					// % protected region % [Add other validators for Ref Code here] off begin
					// % protected region % [Add other validators for Ref Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Code here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Code here] end
			},
			{
				name: 'refName',
				// % protected region % [Set displayName for Ref Name here] off begin
				displayName: 'Ref Name',
				// % protected region % [Set displayName for Ref Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ref Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ref Name here] end
				// % protected region % [Set isSensitive for Ref Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ref Name here] end
				// % protected region % [Set readonly for Ref Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ref Name here] end
				validators: [
					// % protected region % [Add other validators for Ref Name here] off begin
					// % protected region % [Add other validators for Ref Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Name here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Name here] end
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
				id: 'additionalDiagnose',
				type: ModelRelationType.MANY,
				name: 'additionalDiagnoseIds',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Diagnose here] off begin
				label: 'Additional Diagnose',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Diagnose here] end
				entityName: 'BpjsSpecialReferralModel',
				// % protected region % [Customise your display name for Additional Diagnose here] off begin
				displayName: 'referralID',
				// % protected region % [Customise your display name for Additional Diagnose here] end
				validators: [
					// % protected region % [Add other validators for Additional Diagnose here] off begin
					// % protected region % [Add other validators for Additional Diagnose here] end
				],
				// % protected region % [Add any additional field for relation Additional Diagnose here] off begin
				// % protected region % [Add any additional field for relation Additional Diagnose here] end
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
				id: 'diagnosesAndProcedures',
				type: ModelRelationType.ONE,
				name: 'diagnosesAndProceduresId',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnoses and Procedures here] off begin
				label: 'Diagnoses and Procedures',
				// % protected region % [Customise your 1-1 or 1-M label for Diagnoses and Procedures here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for Diagnoses and Procedures here] off begin
				displayName: 'itemType',
				// % protected region % [Customise your display name for Diagnoses and Procedures here] end
				validators: [
					// % protected region % [Add other validators for Diagnoses and Procedures here] off begin
					// % protected region % [Add other validators for Diagnoses and Procedures here] end
				],
				// % protected region % [Add any additional field for relation Diagnoses and Procedures here] off begin
				// % protected region % [Add any additional field for relation Diagnoses and Procedures here] end
			},
			{
				id: 'primaryDiagnose',
				type: ModelRelationType.MANY,
				name: 'primaryDiagnoseIds',
				// % protected region % [Customise your 1-1 or 1-M label for Primary Diagnose here] off begin
				label: 'Primary Diagnose',
				// % protected region % [Customise your 1-1 or 1-M label for Primary Diagnose here] end
				entityName: 'BpjsSpecialReferralModel',
				// % protected region % [Customise your display name for Primary Diagnose here] off begin
				displayName: 'referralID',
				// % protected region % [Customise your display name for Primary Diagnose here] end
				validators: [
					// % protected region % [Add other validators for Primary Diagnose here] off begin
					// % protected region % [Add other validators for Primary Diagnose here] end
				],
				// % protected region % [Add any additional field for relation Primary Diagnose here] off begin
				// % protected region % [Add any additional field for relation Primary Diagnose here] end
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
				case 'refCode':
					break;
				case 'refName':
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
	static deepParse(data: string | { [K in keyof BpjsDiagnoseModel]?: BpjsDiagnoseModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsDiagnoseModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.diagnosesAndProcedures) {
			currentModel.diagnosesAndProceduresId = json.diagnosesAndProcedures.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.diagnosesAndProcedures));
		}

		// Outgoing one to many
		if (json.additionalDiagnose) {
			currentModel.additionalDiagnoseIds = json.additionalDiagnose.map(model => model.id);
			returned = _.union(returned, _.flatten(json.additionalDiagnose.map(model => BpjsSpecialReferralModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsClaimSubmissions) {
			currentModel.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsClaimSubmissions.map(model => BpjsClaimSubmissionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsPatientReferrals) {
			currentModel.bpjsPatientReferralsIds = json.bpjsPatientReferrals.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsPatientReferrals.map(model => BpjsPatientReferralModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.primaryDiagnose) {
			currentModel.primaryDiagnoseIds = json.primaryDiagnose.map(model => model.id);
			returned = _.union(returned, _.flatten(json.primaryDiagnose.map(model => BpjsSpecialReferralModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsDiagnoseModel = new BpjsDiagnoseModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsDiagnoseModel,
	 *    it is expected as a JSON string or as a nullable BpjsDiagnoseModel.
	 */
	constructor(data?: string | Partial<BpjsDiagnoseModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsDiagnoseModel>
				: data;

			this.refCode = json.refCode;
			this.refName = json.refName;
			this.diagnosesAndProceduresId = json.diagnosesAndProceduresId;
			this.diagnosesAndProcedures = json.diagnosesAndProcedures;
			this.additionalDiagnoseIds = json.additionalDiagnoseIds;
			this.additionalDiagnose = json.additionalDiagnose;
			this.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissionsIds;
			this.bpjsClaimSubmissions = json.bpjsClaimSubmissions;
			this.bpjsPatientReferralsIds = json.bpjsPatientReferralsIds;
			this.bpjsPatientReferrals = json.bpjsPatientReferrals;
			this.primaryDiagnoseIds = json.primaryDiagnoseIds;
			this.primaryDiagnose = json.primaryDiagnose;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			refCode: this.refCode,
			refName: this.refName,
			diagnosesAndProceduresId: this.diagnosesAndProceduresId,
			additionalDiagnoseIds: this.additionalDiagnoseIds,
			bpjsClaimSubmissionsIds: this.bpjsClaimSubmissionsIds,
			bpjsPatientReferralsIds: this.bpjsPatientReferralsIds,
			primaryDiagnoseIds: this.primaryDiagnoseIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsDiagnoseModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsDiagnoseModel {
		let newModelJson = this.toJSON();

		if (updates.refCode) {
			newModelJson.refCode = updates.refCode;
		}

		if (updates.refName) {
			newModelJson.refName = updates.refName;
		}

		if (updates.diagnosesAndProceduresId) {
			newModelJson.diagnosesAndProceduresId = updates.diagnosesAndProceduresId;
		}

		if (updates.additionalDiagnoseIds) {
			newModelJson.additionalDiagnoseIds = updates.additionalDiagnoseIds;
		}

		if (updates.bpjsClaimSubmissionsIds) {
			newModelJson.bpjsClaimSubmissionsIds = updates.bpjsClaimSubmissionsIds;
		}

		if (updates.bpjsPatientReferralsIds) {
			newModelJson.bpjsPatientReferralsIds = updates.bpjsPatientReferralsIds;
		}

		if (updates.primaryDiagnoseIds) {
			newModelJson.primaryDiagnoseIds = updates.primaryDiagnoseIds;
		}

		return new BpjsDiagnoseModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsDiagnoseModel)) {
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
			'diagnosesAndProceduresId',
			'diagnosesAndProcedures',
			'additionalDiagnoseIds',
			'additionalDiagnose',
			'bpjsClaimSubmissionsIds',
			'bpjsClaimSubmissions',
			'bpjsPatientReferralsIds',
			'bpjsPatientReferrals',
			'primaryDiagnoseIds',
			'primaryDiagnose',
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
		if (!this.diagnosesAndProcedures) {
			this.diagnosesAndProceduresId = null;
		} else {
			this.diagnosesAndProceduresId = this.diagnosesAndProcedures.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
