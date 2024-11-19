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
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsDismissalMappingModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'refCode',
		'refName',
		'internalDismissal',
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

	readonly className = 'BpjsDismissalMappingModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsDismissalMappingModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	refCode: string;

	/**
	 * .
	 */
	refName: string;

	/**
	 * Dismissal.
	 */
	internalDismissal: string;

	bpjsClaimSubmissionId: string;

	bpjsClaimSubmission: BpjsClaimSubmissionModel;

	modelPropGroups: { [s: string]: Group } = BpjsDismissalMappingModel.modelPropGroups;

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
					Validators.required,
					CustomValidators.nonEmptyString(),
					Validators.maxLength(50),
					// % protected region % [Add other validators for Ref Name here] off begin
					// % protected region % [Add other validators for Ref Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Name here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Name here] end
			},
			{
				name: 'internalDismissal',
				// % protected region % [Set displayName for Internal Dismissal here] off begin
				displayName: 'Internal Dismissal',
				// % protected region % [Set displayName for Internal Dismissal here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Internal Dismissal here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Internal Dismissal here] end
				// % protected region % [Set isSensitive for Internal Dismissal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Internal Dismissal here] end
				// % protected region % [Set readonly for Internal Dismissal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Internal Dismissal here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Internal Dismissal here] off begin
					// % protected region % [Add other validators for Internal Dismissal here] end
				],
				// % protected region % [Add any additional model attribute properties for Internal Dismissal here] off begin
				// % protected region % [Add any additional model attribute properties for Internal Dismissal here] end
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
				id: 'bpjsClaimSubmission',
				type: ModelRelationType.ONE,
				name: 'bpjsClaimSubmissionId',
				// % protected region % [Customise your label for BPJS Claim Submission here] off begin
				label: 'BPJS Claim Submission',
				// % protected region % [Customise your label for BPJS Claim Submission here] end
				entityName: 'BpjsClaimSubmissionModel',
				// % protected region % [Customise your display name for BPJS Claim Submission here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'sepNo',
				// % protected region % [Customise your display name for BPJS Claim Submission here] end
				validators: [
					// % protected region % [Add other validators for BPJS Claim Submission here] off begin
					// % protected region % [Add other validators for BPJS Claim Submission here] end
				],
				// % protected region % [Add any additional field for relation BPJS Claim Submission here] off begin
				// % protected region % [Add any additional field for relation BPJS Claim Submission here] end
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
				case 'internalDismissal':
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
	static deepParse(data: string | { [K in keyof BpjsDismissalMappingModel]?: BpjsDismissalMappingModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsDismissalMappingModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.bpjsClaimSubmission) {
			currentModel.bpjsClaimSubmissionId = json.bpjsClaimSubmission.id;
			returned = _.union(returned, BpjsClaimSubmissionModel.deepParse(json.bpjsClaimSubmission));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsDismissalMappingModel = new BpjsDismissalMappingModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsDismissalMappingModel,
	 *    it is expected as a JSON string or as a nullable BpjsDismissalMappingModel.
	 */
	constructor(data?: string | Partial<BpjsDismissalMappingModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsDismissalMappingModel>
				: data;

			this.refCode = json.refCode;
			this.refName = json.refName;
			this.internalDismissal = json.internalDismissal;
			this.bpjsClaimSubmissionId = json.bpjsClaimSubmissionId;
			this.bpjsClaimSubmission = json.bpjsClaimSubmission;
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
			internalDismissal: this.internalDismissal,
			bpjsClaimSubmissionId: this.bpjsClaimSubmissionId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsDismissalMappingModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsDismissalMappingModel {
		let newModelJson = this.toJSON();

		if (updates.refCode) {
			newModelJson.refCode = updates.refCode;
		}

		if (updates.refName) {
			newModelJson.refName = updates.refName;
		}

		if (updates.internalDismissal) {
			newModelJson.internalDismissal = updates.internalDismissal;
		}

		if (updates.bpjsClaimSubmissionId) {
			newModelJson.bpjsClaimSubmissionId = updates.bpjsClaimSubmissionId;
		}

		return new BpjsDismissalMappingModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsDismissalMappingModel)) {
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
			'bpjsClaimSubmissionId',
			'bpjsClaimSubmission',
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
		if (!this.bpjsClaimSubmission) {
			this.bpjsClaimSubmissionId = null;
		} else {
			this.bpjsClaimSubmissionId = this.bpjsClaimSubmission.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
