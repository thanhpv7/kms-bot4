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
import {BpjsSpecialReferralModel} from '../bpjsSpecialReferral/bpjs_special_referral.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsProcedureModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'procedureCode',
		'procedureName',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'procedureCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsProcedureModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsProcedureModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	procedureCode: string;

	/**
	 * .
	 */
	procedureName: string;

	additionalProcedureIds: string[] = [];

	additionalProcedure: BpjsSpecialReferralModel[];

	bpjsClaimSubmissionsIds: string[] = [];

	bpjsClaimSubmissions: BpjsClaimSubmissionModel[];

	primaryProcedureIds: string[] = [];

	primaryProcedure: BpjsSpecialReferralModel[];

	modelPropGroups: { [s: string]: Group } = BpjsProcedureModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'procedureCode',
				// % protected region % [Set displayName for Procedure Code here] off begin
				displayName: 'Procedure Code',
				// % protected region % [Set displayName for Procedure Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Procedure Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Procedure Code here] end
				// % protected region % [Set isSensitive for Procedure Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Procedure Code here] end
				// % protected region % [Set readonly for Procedure Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Procedure Code here] end
				validators: [
					// % protected region % [Add other validators for Procedure Code here] off begin
					// % protected region % [Add other validators for Procedure Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Procedure Code here] off begin
				// % protected region % [Add any additional model attribute properties for Procedure Code here] end
			},
			{
				name: 'procedureName',
				// % protected region % [Set displayName for Procedure Name here] off begin
				displayName: 'Procedure Name',
				// % protected region % [Set displayName for Procedure Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Procedure Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Procedure Name here] end
				// % protected region % [Set isSensitive for Procedure Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Procedure Name here] end
				// % protected region % [Set readonly for Procedure Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Procedure Name here] end
				validators: [
					// % protected region % [Add other validators for Procedure Name here] off begin
					// % protected region % [Add other validators for Procedure Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Procedure Name here] off begin
				// % protected region % [Add any additional model attribute properties for Procedure Name here] end
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
				id: 'additionalProcedure',
				type: ModelRelationType.MANY,
				name: 'additionalProcedureIds',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Procedure here] off begin
				label: 'Additional Procedure',
				// % protected region % [Customise your 1-1 or 1-M label for Additional Procedure here] end
				entityName: 'BpjsSpecialReferralModel',
				// % protected region % [Customise your display name for Additional Procedure here] off begin
				displayName: 'referralID',
				// % protected region % [Customise your display name for Additional Procedure here] end
				validators: [
					// % protected region % [Add other validators for Additional Procedure here] off begin
					// % protected region % [Add other validators for Additional Procedure here] end
				],
				// % protected region % [Add any additional field for relation Additional Procedure here] off begin
				// % protected region % [Add any additional field for relation Additional Procedure here] end
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
				id: 'primaryProcedure',
				type: ModelRelationType.MANY,
				name: 'primaryProcedureIds',
				// % protected region % [Customise your 1-1 or 1-M label for Primary Procedure here] off begin
				label: 'Primary Procedure',
				// % protected region % [Customise your 1-1 or 1-M label for Primary Procedure here] end
				entityName: 'BpjsSpecialReferralModel',
				// % protected region % [Customise your display name for Primary Procedure here] off begin
				displayName: 'referralID',
				// % protected region % [Customise your display name for Primary Procedure here] end
				validators: [
					// % protected region % [Add other validators for Primary Procedure here] off begin
					// % protected region % [Add other validators for Primary Procedure here] end
				],
				// % protected region % [Add any additional field for relation Primary Procedure here] off begin
				// % protected region % [Add any additional field for relation Primary Procedure here] end
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
				case 'procedureCode':
					break;
				case 'procedureName':
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
	static deepParse(data: string | { [K in keyof BpjsProcedureModel]?: BpjsProcedureModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsProcedureModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.additionalProcedure) {
			currentModel.additionalProcedureIds = json.additionalProcedure.map(model => model.id);
			returned = _.union(returned, _.flatten(json.additionalProcedure.map(model => BpjsSpecialReferralModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsClaimSubmissions) {
			currentModel.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsClaimSubmissions.map(model => BpjsClaimSubmissionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.primaryProcedure) {
			currentModel.primaryProcedureIds = json.primaryProcedure.map(model => model.id);
			returned = _.union(returned, _.flatten(json.primaryProcedure.map(model => BpjsSpecialReferralModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsProcedureModel = new BpjsProcedureModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsProcedureModel,
	 *    it is expected as a JSON string or as a nullable BpjsProcedureModel.
	 */
	constructor(data?: string | Partial<BpjsProcedureModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsProcedureModel>
				: data;

			this.procedureCode = json.procedureCode;
			this.procedureName = json.procedureName;
			this.additionalProcedureIds = json.additionalProcedureIds;
			this.additionalProcedure = json.additionalProcedure;
			this.bpjsClaimSubmissionsIds = json.bpjsClaimSubmissionsIds;
			this.bpjsClaimSubmissions = json.bpjsClaimSubmissions;
			this.primaryProcedureIds = json.primaryProcedureIds;
			this.primaryProcedure = json.primaryProcedure;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			procedureCode: this.procedureCode,
			procedureName: this.procedureName,
			additionalProcedureIds: this.additionalProcedureIds,
			bpjsClaimSubmissionsIds: this.bpjsClaimSubmissionsIds,
			primaryProcedureIds: this.primaryProcedureIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsProcedureModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsProcedureModel {
		let newModelJson = this.toJSON();

		if (updates.procedureCode) {
			newModelJson.procedureCode = updates.procedureCode;
		}

		if (updates.procedureName) {
			newModelJson.procedureName = updates.procedureName;
		}

		if (updates.additionalProcedureIds) {
			newModelJson.additionalProcedureIds = updates.additionalProcedureIds;
		}

		if (updates.bpjsClaimSubmissionsIds) {
			newModelJson.bpjsClaimSubmissionsIds = updates.bpjsClaimSubmissionsIds;
		}

		if (updates.primaryProcedureIds) {
			newModelJson.primaryProcedureIds = updates.primaryProcedureIds;
		}

		return new BpjsProcedureModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsProcedureModel)) {
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
			'additionalProcedureIds',
			'additionalProcedure',
			'bpjsClaimSubmissionsIds',
			'bpjsClaimSubmissions',
			'primaryProcedureIds',
			'primaryProcedure',
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
