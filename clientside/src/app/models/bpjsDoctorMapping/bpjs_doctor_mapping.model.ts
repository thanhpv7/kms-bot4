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
import {BpjsControlPlanModel} from '../bpjsControlPlan/bpjs_control_plan.model';
import {BpjsHospitalizationPlanModel} from '../bpjsHospitalizationPlan/bpjs_hospitalization_plan.model';
import {BpjsPRBModel} from '../bpjsPRB/bpjs_prb.model';
import {StaffModel} from '../staff/staff.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsDoctorMappingModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'refCode',
		'bpjsMedicalStaff',
		'notes',
		'refCodeService',
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

	readonly className = 'BpjsDoctorMappingModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsDoctorMappingModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * kodedokter.
	 */
	refCode: string;

	/**
	 * namadokter.
	 */
	bpjsMedicalStaff: string;

	/**
	 * Notes.
	 */
	notes: string;

	/**
	 * Kode Poli Untuk Dokter BPJS.
	 */
	refCodeService: string;

	staffId: string;

	staff: StaffModel;

	bpjsClaimSubmissionsIds: string[] = [];

	bpjsClaimSubmissions: BpjsClaimSubmissionModel[];

	bpjsControlPlansIds: string[] = [];

	bpjsControlPlans: BpjsControlPlanModel[];

	bpjsPRBsIds: string[] = [];

	bpjsPRBs: BpjsPRBModel[];

	kodedokterIds: string[] = [];

	kodedokter: BpjsHospitalizationPlanModel[];

	modelPropGroups: { [s: string]: Group } = BpjsDoctorMappingModel.modelPropGroups;

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
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(25),
					// % protected region % [Add other validators for Ref Code here] off begin
					// % protected region % [Add other validators for Ref Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Code here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Code here] end
			},
			{
				name: 'bpjsMedicalStaff',
				// % protected region % [Set displayName for BPJS Medical Staff here] off begin
				displayName: 'BPJS Medical Staff',
				// % protected region % [Set displayName for BPJS Medical Staff here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BPJS Medical Staff here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BPJS Medical Staff here] end
				// % protected region % [Set isSensitive for BPJS Medical Staff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BPJS Medical Staff here] end
				// % protected region % [Set readonly for BPJS Medical Staff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BPJS Medical Staff here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for BPJS Medical Staff here] off begin
					// % protected region % [Add other validators for BPJS Medical Staff here] end
				],
				// % protected region % [Add any additional model attribute properties for BPJS Medical Staff here] off begin
				// % protected region % [Add any additional model attribute properties for BPJS Medical Staff here] end
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
					Validators.maxLength(1000),
					// % protected region % [Add other validators for Notes here] off begin
					// % protected region % [Add other validators for Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Notes here] end
			},
			{
				name: 'refCodeService',
				// % protected region % [Set displayName for Ref Code Service here] off begin
				displayName: 'Ref Code Service',
				// % protected region % [Set displayName for Ref Code Service here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ref Code Service here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ref Code Service here] end
				// % protected region % [Set isSensitive for Ref Code Service here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ref Code Service here] end
				// % protected region % [Set readonly for Ref Code Service here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ref Code Service here] end
				validators: [
					// % protected region % [Add other validators for Ref Code Service here] off begin
					// % protected region % [Add other validators for Ref Code Service here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Code Service here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Code Service here] end
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
				id: 'bpjsControlPlans',
				type: ModelRelationType.MANY,
				name: 'bpjsControlPlansIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Control Plans here] off begin
				label: 'BPJS Control Plans',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Control Plans here] end
				entityName: 'BpjsControlPlanModel',
				// % protected region % [Customise your display name for BPJS Control Plans here] off begin
				displayName: 'noSEP',
				// % protected region % [Customise your display name for BPJS Control Plans here] end
				validators: [
					// % protected region % [Add other validators for BPJS Control Plans here] off begin
					// % protected region % [Add other validators for BPJS Control Plans here] end
				],
				// % protected region % [Add any additional field for relation BPJS Control Plans here] off begin
				// % protected region % [Add any additional field for relation BPJS Control Plans here] end
			},
			{
				id: 'bpjsPRBs',
				type: ModelRelationType.MANY,
				name: 'bpjsPRBsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS PRBs here] off begin
				label: 'BPJS PRBs',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS PRBs here] end
				entityName: 'BpjsPRBModel',
				// % protected region % [Customise your display name for BPJS PRBs here] off begin
				displayName: 'srbNo',
				// % protected region % [Customise your display name for BPJS PRBs here] end
				validators: [
					// % protected region % [Add other validators for BPJS PRBs here] off begin
					// % protected region % [Add other validators for BPJS PRBs here] end
				],
				// % protected region % [Add any additional field for relation BPJS PRBs here] off begin
				// % protected region % [Add any additional field for relation BPJS PRBs here] end
			},
			{
				id: 'kodedokter',
				type: ModelRelationType.MANY,
				name: 'kodedokterIds',
				// % protected region % [Customise your 1-1 or 1-M label for kodeDokter here] off begin
				label: 'kodeDokter',
				// % protected region % [Customise your 1-1 or 1-M label for kodeDokter here] end
				entityName: 'BpjsHospitalizationPlanModel',
				// % protected region % [Customise your display name for kodeDokter here] off begin
				displayName: 'nokartu',
				// % protected region % [Customise your display name for kodeDokter here] end
				validators: [
					// % protected region % [Add other validators for kodeDokter here] off begin
					// % protected region % [Add other validators for kodeDokter here] end
				],
				// % protected region % [Add any additional field for relation kodeDokter here] off begin
				// % protected region % [Add any additional field for relation kodeDokter here] end
			},
			{
				id: 'staff',
				type: ModelRelationType.ONE,
				name: 'staffId',
				// % protected region % [Customise your label for Staff here] off begin
				label: 'Staff',
				// % protected region % [Customise your label for Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Staff here] end
				validators: [
					// % protected region % [Add other validators for Staff here] off begin
					// % protected region % [Add other validators for Staff here] end
				],
				// % protected region % [Add any additional field for relation Staff here] off begin
				// % protected region % [Add any additional field for relation Staff here] end
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
				case 'bpjsMedicalStaff':
					break;
				case 'notes':
					break;
				case 'refCodeService':
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
	static deepParse(data: string | { [K in keyof BpjsDoctorMappingModel]?: BpjsDoctorMappingModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsDoctorMappingModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}

		// Outgoing one to many
		if (json.bpjsClaimSubmissions) {
			currentModel.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsClaimSubmissions.map(model => BpjsClaimSubmissionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsControlPlans) {
			currentModel.bpjsControlPlansIds = json.bpjsControlPlans.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsControlPlans.map(model => BpjsControlPlanModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsPRBs) {
			currentModel.bpjsPRBsIds = json.bpjsPRBs.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsPRBs.map(model => BpjsPRBModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.kodedokter) {
			currentModel.kodedokterIds = json.kodedokter.map(model => model.id);
			returned = _.union(returned, _.flatten(json.kodedokter.map(model => BpjsHospitalizationPlanModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsDoctorMappingModel = new BpjsDoctorMappingModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsDoctorMappingModel,
	 *    it is expected as a JSON string or as a nullable BpjsDoctorMappingModel.
	 */
	constructor(data?: string | Partial<BpjsDoctorMappingModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsDoctorMappingModel>
				: data;

			this.refCode = json.refCode;
			this.bpjsMedicalStaff = json.bpjsMedicalStaff;
			this.notes = json.notes;
			this.refCodeService = json.refCodeService;
			this.staffId = json.staffId;
			this.staff = json.staff;
			this.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissionsIds;
			this.bpjsClaimSubmissions = json.bpjsClaimSubmissions;
			this.bpjsControlPlansIds = json.bpjsControlPlansIds;
			this.bpjsControlPlans = json.bpjsControlPlans;
			this.bpjsPRBsIds = json.bpjsPRBsIds;
			this.bpjsPRBs = json.bpjsPRBs;
			this.kodedokterIds = json.kodedokterIds;
			this.kodedokter = json.kodedokter;
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
			bpjsMedicalStaff: this.bpjsMedicalStaff,
			notes: this.notes,
			refCodeService: this.refCodeService,
			staffId: this.staffId,
			bpjsClaimSubmissionsIds: this.bpjsClaimSubmissionsIds,
			bpjsControlPlansIds: this.bpjsControlPlansIds,
			bpjsPRBsIds: this.bpjsPRBsIds,
			kodedokterIds: this.kodedokterIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsDoctorMappingModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsDoctorMappingModel {
		let newModelJson = this.toJSON();

		if (updates.refCode) {
			newModelJson.refCode = updates.refCode;
		}

		if (updates.bpjsMedicalStaff) {
			newModelJson.bpjsMedicalStaff = updates.bpjsMedicalStaff;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.refCodeService) {
			newModelJson.refCodeService = updates.refCodeService;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		if (updates.bpjsClaimSubmissionsIds) {
			newModelJson.bpjsClaimSubmissionsIds = updates.bpjsClaimSubmissionsIds;
		}

		if (updates.bpjsControlPlansIds) {
			newModelJson.bpjsControlPlansIds = updates.bpjsControlPlansIds;
		}

		if (updates.bpjsPRBsIds) {
			newModelJson.bpjsPRBsIds = updates.bpjsPRBsIds;
		}

		if (updates.kodedokterIds) {
			newModelJson.kodedokterIds = updates.kodedokterIds;
		}

		return new BpjsDoctorMappingModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsDoctorMappingModel)) {
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
			'staffId',
			'staff',
			'bpjsClaimSubmissionsIds',
			'bpjsClaimSubmissions',
			'bpjsControlPlansIds',
			'bpjsControlPlans',
			'bpjsPRBsIds',
			'bpjsPRBs',
			'kodedokterIds',
			'kodedokter',
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
		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
