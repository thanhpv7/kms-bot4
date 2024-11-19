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
import {BpjsPatientReferralModel} from '../bpjsPatientReferral/bpjs_patient_referral.model';
import {ServiceModel} from '../service/service.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsServiceMappingModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'refCode',
		'refService',
		'kodeSubspesialis',
		'namaSubspesialis',
		'categorizedAsSurgery',
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

	readonly className = 'BpjsServiceMappingModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsServiceMappingModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * kdpoli.
	 */
	refCode: string;

	/**
	 * nmpoli.
	 */
	refService: string;

	/**
	 * kdsubspesialis.
	 */
	kodeSubspesialis: string;

	/**
	 * nmsubspesialis.
	 */
	namaSubspesialis: string;

	/**
	 * .
	 */
	categorizedAsSurgery: boolean = false;

	serviceId: string;

	service: ServiceModel;

	bpjsClaimSubmissionsIds: string[] = [];

	bpjsClaimSubmissions: BpjsClaimSubmissionModel[];

	bpjsControlPlansIds: string[] = [];

	bpjsControlPlans: BpjsControlPlanModel[];

	bpjsPatientReferralsIds: string[] = [];

	bpjsPatientReferrals: BpjsPatientReferralModel[];

	polikontrolIds: string[] = [];

	polikontrol: BpjsHospitalizationPlanModel[];

	modelPropGroups: { [s: string]: Group } = BpjsServiceMappingModel.modelPropGroups;

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
					Validators.maxLength(25),
					// % protected region % [Add other validators for Ref Code here] off begin
					// % protected region % [Add other validators for Ref Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Code here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Code here] end
			},
			{
				name: 'refService',
				// % protected region % [Set displayName for Ref Service here] off begin
				displayName: 'Ref Service',
				// % protected region % [Set displayName for Ref Service here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ref Service here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ref Service here] end
				// % protected region % [Set isSensitive for Ref Service here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ref Service here] end
				// % protected region % [Set readonly for Ref Service here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ref Service here] end
				validators: [
					Validators.maxLength(200),
					// % protected region % [Add other validators for Ref Service here] off begin
					// % protected region % [Add other validators for Ref Service here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Service here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Service here] end
			},
			{
				name: 'kodeSubspesialis',
				// % protected region % [Set displayName for Kode Subspesialis here] off begin
				displayName: 'Kode Subspesialis',
				// % protected region % [Set displayName for Kode Subspesialis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kode Subspesialis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kode Subspesialis here] end
				// % protected region % [Set isSensitive for Kode Subspesialis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kode Subspesialis here] end
				// % protected region % [Set readonly for Kode Subspesialis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kode Subspesialis here] end
				validators: [
					// % protected region % [Add other validators for Kode Subspesialis here] off begin
					// % protected region % [Add other validators for Kode Subspesialis here] end
				],
				// % protected region % [Add any additional model attribute properties for Kode Subspesialis here] off begin
				// % protected region % [Add any additional model attribute properties for Kode Subspesialis here] end
			},
			{
				name: 'namaSubspesialis',
				// % protected region % [Set displayName for Nama Subspesialis here] off begin
				displayName: 'Nama Subspesialis',
				// % protected region % [Set displayName for Nama Subspesialis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nama Subspesialis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nama Subspesialis here] end
				// % protected region % [Set isSensitive for Nama Subspesialis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nama Subspesialis here] end
				// % protected region % [Set readonly for Nama Subspesialis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nama Subspesialis here] end
				validators: [
					// % protected region % [Add other validators for Nama Subspesialis here] off begin
					// % protected region % [Add other validators for Nama Subspesialis here] end
				],
				// % protected region % [Add any additional model attribute properties for Nama Subspesialis here] off begin
				// % protected region % [Add any additional model attribute properties for Nama Subspesialis here] end
			},
			{
				name: 'categorizedAsSurgery',
				// % protected region % [Set displayName for Categorized as Surgery here] off begin
				displayName: 'Categorized as Surgery',
				// % protected region % [Set displayName for Categorized as Surgery here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Categorized as Surgery here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Categorized as Surgery here] end
				// % protected region % [Set isSensitive for Categorized as Surgery here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Categorized as Surgery here] end
				// % protected region % [Set readonly for Categorized as Surgery here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Categorized as Surgery here] end
				validators: [
					// % protected region % [Add other validators for Categorized as Surgery here] off begin
					// % protected region % [Add other validators for Categorized as Surgery here] end
				],
				// % protected region % [Add any additional model attribute properties for Categorized as Surgery here] off begin
				// % protected region % [Add any additional model attribute properties for Categorized as Surgery here] end
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
				id: 'polikontrol',
				type: ModelRelationType.MANY,
				name: 'polikontrolIds',
				// % protected region % [Customise your 1-1 or 1-M label for poliKontrol here] off begin
				label: 'poliKontrol',
				// % protected region % [Customise your 1-1 or 1-M label for poliKontrol here] end
				entityName: 'BpjsHospitalizationPlanModel',
				// % protected region % [Customise your display name for poliKontrol here] off begin
				displayName: 'nokartu',
				// % protected region % [Customise your display name for poliKontrol here] end
				validators: [
					// % protected region % [Add other validators for poliKontrol here] off begin
					// % protected region % [Add other validators for poliKontrol here] end
				],
				// % protected region % [Add any additional field for relation poliKontrol here] off begin
				// % protected region % [Add any additional field for relation poliKontrol here] end
			},
			{
				id: 'service',
				type: ModelRelationType.ONE,
				name: 'serviceId',
				// % protected region % [Customise your label for Service here] off begin
				label: 'Service',
				// % protected region % [Customise your label for Service here] end
				entityName: 'ServiceModel',
				// % protected region % [Customise your display name for Service here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'serviceNumber',
				// % protected region % [Customise your display name for Service here] end
				validators: [
					// % protected region % [Add other validators for Service here] off begin
					// % protected region % [Add other validators for Service here] end
				],
				// % protected region % [Add any additional field for relation Service here] off begin
				// % protected region % [Add any additional field for relation Service here] end
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
				case 'refService':
					break;
				case 'kodeSubspesialis':
					break;
				case 'namaSubspesialis':
					break;
				case 'categorizedAsSurgery':
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
	static deepParse(data: string | { [K in keyof BpjsServiceMappingModel]?: BpjsServiceMappingModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsServiceMappingModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.service) {
			currentModel.serviceId = json.service.id;
			returned = _.union(returned, ServiceModel.deepParse(json.service));
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
		if (json.bpjsPatientReferrals) {
			currentModel.bpjsPatientReferralsIds = json.bpjsPatientReferrals.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsPatientReferrals.map(model => BpjsPatientReferralModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.polikontrol) {
			currentModel.polikontrolIds = json.polikontrol.map(model => model.id);
			returned = _.union(returned, _.flatten(json.polikontrol.map(model => BpjsHospitalizationPlanModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsServiceMappingModel = new BpjsServiceMappingModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsServiceMappingModel,
	 *    it is expected as a JSON string or as a nullable BpjsServiceMappingModel.
	 */
	constructor(data?: string | Partial<BpjsServiceMappingModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsServiceMappingModel>
				: data;

			this.refCode = json.refCode;
			this.refService = json.refService;
			this.kodeSubspesialis = json.kodeSubspesialis;
			this.namaSubspesialis = json.namaSubspesialis;
			this.categorizedAsSurgery = json.categorizedAsSurgery;
			this.serviceId = json.serviceId;
			this.service = json.service;
			this.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissionsIds;
			this.bpjsClaimSubmissions = json.bpjsClaimSubmissions;
			this.bpjsControlPlansIds = json.bpjsControlPlansIds;
			this.bpjsControlPlans = json.bpjsControlPlans;
			this.bpjsPatientReferralsIds = json.bpjsPatientReferralsIds;
			this.bpjsPatientReferrals = json.bpjsPatientReferrals;
			this.polikontrolIds = json.polikontrolIds;
			this.polikontrol = json.polikontrol;
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
			refService: this.refService,
			kodeSubspesialis: this.kodeSubspesialis,
			namaSubspesialis: this.namaSubspesialis,
			categorizedAsSurgery: this.categorizedAsSurgery,
			serviceId: this.serviceId,
			bpjsClaimSubmissionsIds: this.bpjsClaimSubmissionsIds,
			bpjsControlPlansIds: this.bpjsControlPlansIds,
			bpjsPatientReferralsIds: this.bpjsPatientReferralsIds,
			polikontrolIds: this.polikontrolIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsServiceMappingModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsServiceMappingModel {
		let newModelJson = this.toJSON();

		if (updates.refCode) {
			newModelJson.refCode = updates.refCode;
		}

		if (updates.refService) {
			newModelJson.refService = updates.refService;
		}

		if (updates.kodeSubspesialis) {
			newModelJson.kodeSubspesialis = updates.kodeSubspesialis;
		}

		if (updates.namaSubspesialis) {
			newModelJson.namaSubspesialis = updates.namaSubspesialis;
		}

		if (updates.categorizedAsSurgery) {
			newModelJson.categorizedAsSurgery = updates.categorizedAsSurgery;
		}

		if (updates.serviceId) {
			newModelJson.serviceId = updates.serviceId;
		}

		if (updates.bpjsClaimSubmissionsIds) {
			newModelJson.bpjsClaimSubmissionsIds = updates.bpjsClaimSubmissionsIds;
		}

		if (updates.bpjsControlPlansIds) {
			newModelJson.bpjsControlPlansIds = updates.bpjsControlPlansIds;
		}

		if (updates.bpjsPatientReferralsIds) {
			newModelJson.bpjsPatientReferralsIds = updates.bpjsPatientReferralsIds;
		}

		if (updates.polikontrolIds) {
			newModelJson.polikontrolIds = updates.polikontrolIds;
		}

		return new BpjsServiceMappingModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsServiceMappingModel)) {
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
			'serviceId',
			'service',
			'bpjsClaimSubmissionsIds',
			'bpjsClaimSubmissions',
			'bpjsControlPlansIds',
			'bpjsControlPlans',
			'bpjsPatientReferralsIds',
			'bpjsPatientReferrals',
			'polikontrolIds',
			'polikontrol',
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
		if (!this.service) {
			this.serviceId = null;
		} else {
			this.serviceId = this.service.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
