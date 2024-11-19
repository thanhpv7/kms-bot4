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
import {BpjsFacilityListModel} from '../bpjsFacilityList/bpjs_facility_list.model';
import {BpjsPatientReferralModel} from '../bpjsPatientReferral/bpjs_patient_referral.model';
import {BpjsReferralSpecialistModel} from '../bpjsReferralSpecialist/bpjs_referral_specialist.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsHealthFacilityModel extends AbstractModel {
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

	readonly className = 'BpjsHealthFacilityModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsHealthFacilityModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Kode PPK.
	 */
	refCode: string;

	/**
	 * Nama PPK.
	 */
	refName: string;

	bpjsClaimSubmissionsIds: string[] = [];

	bpjsClaimSubmissions: BpjsClaimSubmissionModel[];

	bpjsFacilityListsIds: string[] = [];

	bpjsFacilityLists: BpjsFacilityListModel[];

	bpjsPatientReferralsIds: string[] = [];

	bpjsPatientReferrals: BpjsPatientReferralModel[];

	bpjsReferralSpecialistsIds: string[] = [];

	bpjsReferralSpecialists: BpjsReferralSpecialistModel[];

	modelPropGroups: { [s: string]: Group } = BpjsHealthFacilityModel.modelPropGroups;

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
				id: 'bpjsFacilityLists',
				type: ModelRelationType.MANY,
				name: 'bpjsFacilityListsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Facility Lists here] off begin
				label: 'BPJS Facility Lists',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Facility Lists here] end
				entityName: 'BpjsFacilityListModel',
				// % protected region % [Customise your display name for BPJS Facility Lists here] off begin
				displayName: 'facilityCode',
				// % protected region % [Customise your display name for BPJS Facility Lists here] end
				validators: [
					// % protected region % [Add other validators for BPJS Facility Lists here] off begin
					// % protected region % [Add other validators for BPJS Facility Lists here] end
				],
				// % protected region % [Add any additional field for relation BPJS Facility Lists here] off begin
				// % protected region % [Add any additional field for relation BPJS Facility Lists here] end
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
				id: 'bpjsReferralSpecialists',
				type: ModelRelationType.MANY,
				name: 'bpjsReferralSpecialistsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Referral Specialists here] off begin
				label: 'BPJS Referral Specialists',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Referral Specialists here] end
				entityName: 'BpjsReferralSpecialistModel',
				// % protected region % [Customise your display name for BPJS Referral Specialists here] off begin
				displayName: 'specialistCode',
				// % protected region % [Customise your display name for BPJS Referral Specialists here] end
				validators: [
					// % protected region % [Add other validators for BPJS Referral Specialists here] off begin
					// % protected region % [Add other validators for BPJS Referral Specialists here] end
				],
				// % protected region % [Add any additional field for relation BPJS Referral Specialists here] off begin
				// % protected region % [Add any additional field for relation BPJS Referral Specialists here] end
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
	static deepParse(data: string | { [K in keyof BpjsHealthFacilityModel]?: BpjsHealthFacilityModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsHealthFacilityModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.bpjsClaimSubmissions) {
			currentModel.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsClaimSubmissions.map(model => BpjsClaimSubmissionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsFacilityLists) {
			currentModel.bpjsFacilityListsIds = json.bpjsFacilityLists.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsFacilityLists.map(model => BpjsFacilityListModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsPatientReferrals) {
			currentModel.bpjsPatientReferralsIds = json.bpjsPatientReferrals.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsPatientReferrals.map(model => BpjsPatientReferralModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsReferralSpecialists) {
			currentModel.bpjsReferralSpecialistsIds = json.bpjsReferralSpecialists.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsReferralSpecialists.map(model => BpjsReferralSpecialistModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsHealthFacilityModel = new BpjsHealthFacilityModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsHealthFacilityModel,
	 *    it is expected as a JSON string or as a nullable BpjsHealthFacilityModel.
	 */
	constructor(data?: string | Partial<BpjsHealthFacilityModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsHealthFacilityModel>
				: data;

			this.refCode = json.refCode;
			this.refName = json.refName;
			this.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissionsIds;
			this.bpjsClaimSubmissions = json.bpjsClaimSubmissions;
			this.bpjsFacilityListsIds = json.bpjsFacilityListsIds;
			this.bpjsFacilityLists = json.bpjsFacilityLists;
			this.bpjsPatientReferralsIds = json.bpjsPatientReferralsIds;
			this.bpjsPatientReferrals = json.bpjsPatientReferrals;
			this.bpjsReferralSpecialistsIds = json.bpjsReferralSpecialistsIds;
			this.bpjsReferralSpecialists = json.bpjsReferralSpecialists;
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
			bpjsClaimSubmissionsIds: this.bpjsClaimSubmissionsIds,
			bpjsFacilityListsIds: this.bpjsFacilityListsIds,
			bpjsPatientReferralsIds: this.bpjsPatientReferralsIds,
			bpjsReferralSpecialistsIds: this.bpjsReferralSpecialistsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsHealthFacilityModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsHealthFacilityModel {
		let newModelJson = this.toJSON();

		if (updates.refCode) {
			newModelJson.refCode = updates.refCode;
		}

		if (updates.refName) {
			newModelJson.refName = updates.refName;
		}

		if (updates.bpjsClaimSubmissionsIds) {
			newModelJson.bpjsClaimSubmissionsIds = updates.bpjsClaimSubmissionsIds;
		}

		if (updates.bpjsFacilityListsIds) {
			newModelJson.bpjsFacilityListsIds = updates.bpjsFacilityListsIds;
		}

		if (updates.bpjsPatientReferralsIds) {
			newModelJson.bpjsPatientReferralsIds = updates.bpjsPatientReferralsIds;
		}

		if (updates.bpjsReferralSpecialistsIds) {
			newModelJson.bpjsReferralSpecialistsIds = updates.bpjsReferralSpecialistsIds;
		}

		return new BpjsHealthFacilityModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsHealthFacilityModel)) {
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
			'bpjsClaimSubmissionsIds',
			'bpjsClaimSubmissions',
			'bpjsFacilityListsIds',
			'bpjsFacilityLists',
			'bpjsPatientReferralsIds',
			'bpjsPatientReferrals',
			'bpjsReferralSpecialistsIds',
			'bpjsReferralSpecialists',
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
