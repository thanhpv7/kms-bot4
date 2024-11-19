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
import {BpjsProcedureModel} from '../bpjsProcedure/bpjs_procedure.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsSpecialReferralModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'bpjsCardNo',
		'name',
		'ppkDiagnose',
		'referralStartDate',
		'referralEndDate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'referralID',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsSpecialReferralModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsSpecialReferralModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	referralID: string;

	/**
	 * .
	 */
	referralNo: string;

	/**
	 * .
	 */
	bpjsCardNo: string;

	/**
	 * .
	 */
	name: string;

	/**
	 * .
	 */
	ppkDiagnose: string;

	/**
	 * .
	 */
	referralStartDate: string;

	/**
	 * .
	 */
	referralEndDate: string;

	additionalDiagnoseId: string;

	additionalDiagnose: BpjsDiagnoseModel;

	additionalProcedureId: string;

	additionalProcedure: BpjsProcedureModel;

	primaryDiagnoseId: string;

	primaryDiagnose: BpjsDiagnoseModel;

	primaryProcedureId: string;

	primaryProcedure: BpjsProcedureModel;

	modelPropGroups: { [s: string]: Group } = BpjsSpecialReferralModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'referralID',
				// % protected region % [Set displayName for Referral ID here] off begin
				displayName: 'Referral ID',
				// % protected region % [Set displayName for Referral ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral ID here] end
				// % protected region % [Set isSensitive for Referral ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral ID here] end
				// % protected region % [Set readonly for Referral ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral ID here] end
				validators: [
					// % protected region % [Add other validators for Referral ID here] off begin
					// % protected region % [Add other validators for Referral ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral ID here] off begin
				// % protected region % [Add any additional model attribute properties for Referral ID here] end
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
				name: 'name',
				// % protected region % [Set displayName for Name here] off begin
				displayName: 'Name',
				// % protected region % [Set displayName for Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Name here] end
				// % protected region % [Set isSensitive for Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Name here] end
				// % protected region % [Set readonly for Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Name here] end
				validators: [
					// % protected region % [Add other validators for Name here] off begin
					// % protected region % [Add other validators for Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Name here] off begin
				// % protected region % [Add any additional model attribute properties for Name here] end
			},
			{
				name: 'ppkDiagnose',
				// % protected region % [Set displayName for PPK Diagnose here] off begin
				displayName: 'PPK Diagnose',
				// % protected region % [Set displayName for PPK Diagnose here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for PPK Diagnose here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for PPK Diagnose here] end
				// % protected region % [Set isSensitive for PPK Diagnose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for PPK Diagnose here] end
				// % protected region % [Set readonly for PPK Diagnose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for PPK Diagnose here] end
				validators: [
					// % protected region % [Add other validators for PPK Diagnose here] off begin
					// % protected region % [Add other validators for PPK Diagnose here] end
				],
				// % protected region % [Add any additional model attribute properties for PPK Diagnose here] off begin
				// % protected region % [Add any additional model attribute properties for PPK Diagnose here] end
			},
			{
				name: 'referralStartDate',
				// % protected region % [Set displayName for Referral Start Date here] off begin
				displayName: 'Referral Start Date',
				// % protected region % [Set displayName for Referral Start Date here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral Start Date here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral Start Date here] end
				// % protected region % [Set isSensitive for Referral Start Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral Start Date here] end
				// % protected region % [Set readonly for Referral Start Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral Start Date here] end
				validators: [
					// % protected region % [Add other validators for Referral Start Date here] off begin
					// % protected region % [Add other validators for Referral Start Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral Start Date here] off begin
				// % protected region % [Add any additional model attribute properties for Referral Start Date here] end
			},
			{
				name: 'referralEndDate',
				// % protected region % [Set displayName for Referral End Date here] off begin
				displayName: 'Referral End Date',
				// % protected region % [Set displayName for Referral End Date here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral End Date here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral End Date here] end
				// % protected region % [Set isSensitive for Referral End Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral End Date here] end
				// % protected region % [Set readonly for Referral End Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral End Date here] end
				validators: [
					// % protected region % [Add other validators for Referral End Date here] off begin
					// % protected region % [Add other validators for Referral End Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral End Date here] off begin
				// % protected region % [Add any additional model attribute properties for Referral End Date here] end
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
				type: ModelRelationType.ONE,
				name: 'additionalDiagnoseId',
				// % protected region % [Customise your label for Additional Diagnose here] off begin
				label: 'Additional Diagnose',
				// % protected region % [Customise your label for Additional Diagnose here] end
				entityName: 'BpjsDiagnoseModel',
				// % protected region % [Customise your display name for Additional Diagnose here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for Additional Diagnose here] end
				validators: [
					// % protected region % [Add other validators for Additional Diagnose here] off begin
					// % protected region % [Add other validators for Additional Diagnose here] end
				],
				// % protected region % [Add any additional field for relation Additional Diagnose here] off begin
				// % protected region % [Add any additional field for relation Additional Diagnose here] end
			},
			{
				id: 'additionalProcedure',
				type: ModelRelationType.ONE,
				name: 'additionalProcedureId',
				// % protected region % [Customise your label for Additional Procedure here] off begin
				label: 'Additional Procedure',
				// % protected region % [Customise your label for Additional Procedure here] end
				entityName: 'BpjsProcedureModel',
				// % protected region % [Customise your display name for Additional Procedure here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'procedureCode',
				// % protected region % [Customise your display name for Additional Procedure here] end
				validators: [
					// % protected region % [Add other validators for Additional Procedure here] off begin
					// % protected region % [Add other validators for Additional Procedure here] end
				],
				// % protected region % [Add any additional field for relation Additional Procedure here] off begin
				// % protected region % [Add any additional field for relation Additional Procedure here] end
			},
			{
				id: 'primaryDiagnose',
				type: ModelRelationType.ONE,
				name: 'primaryDiagnoseId',
				// % protected region % [Customise your label for Primary Diagnose here] off begin
				label: 'Primary Diagnose',
				// % protected region % [Customise your label for Primary Diagnose here] end
				entityName: 'BpjsDiagnoseModel',
				// % protected region % [Customise your display name for Primary Diagnose here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for Primary Diagnose here] end
				validators: [
					// % protected region % [Add other validators for Primary Diagnose here] off begin
					// % protected region % [Add other validators for Primary Diagnose here] end
				],
				// % protected region % [Add any additional field for relation Primary Diagnose here] off begin
				// % protected region % [Add any additional field for relation Primary Diagnose here] end
			},
			{
				id: 'primaryProcedure',
				type: ModelRelationType.ONE,
				name: 'primaryProcedureId',
				// % protected region % [Customise your label for Primary Procedure here] off begin
				label: 'Primary Procedure',
				// % protected region % [Customise your label for Primary Procedure here] end
				entityName: 'BpjsProcedureModel',
				// % protected region % [Customise your display name for Primary Procedure here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'procedureCode',
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
				case 'bpjsCardNo':
					break;
				case 'name':
					break;
				case 'ppkDiagnose':
					break;
				case 'referralStartDate':
					break;
				case 'referralEndDate':
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
	static deepParse(data: string | { [K in keyof BpjsSpecialReferralModel]?: BpjsSpecialReferralModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsSpecialReferralModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.additionalDiagnose) {
			currentModel.additionalDiagnoseId = json.additionalDiagnose.id;
			returned = _.union(returned, BpjsDiagnoseModel.deepParse(json.additionalDiagnose));
		}

		// Incoming one to many
		if (json.additionalProcedure) {
			currentModel.additionalProcedureId = json.additionalProcedure.id;
			returned = _.union(returned, BpjsProcedureModel.deepParse(json.additionalProcedure));
		}

		// Incoming one to many
		if (json.primaryDiagnose) {
			currentModel.primaryDiagnoseId = json.primaryDiagnose.id;
			returned = _.union(returned, BpjsDiagnoseModel.deepParse(json.primaryDiagnose));
		}

		// Incoming one to many
		if (json.primaryProcedure) {
			currentModel.primaryProcedureId = json.primaryProcedure.id;
			returned = _.union(returned, BpjsProcedureModel.deepParse(json.primaryProcedure));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsSpecialReferralModel = new BpjsSpecialReferralModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsSpecialReferralModel,
	 *    it is expected as a JSON string or as a nullable BpjsSpecialReferralModel.
	 */
	constructor(data?: string | Partial<BpjsSpecialReferralModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsSpecialReferralModel>
				: data;

			this.referralID = json.referralID;
			this.referralNo = json.referralNo;
			this.bpjsCardNo = json.bpjsCardNo;
			this.name = json.name;
			this.ppkDiagnose = json.ppkDiagnose;
			this.referralStartDate = json.referralStartDate;
			this.referralEndDate = json.referralEndDate;
			this.additionalDiagnoseId = json.additionalDiagnoseId;
			this.additionalDiagnose = json.additionalDiagnose;
			this.additionalProcedureId = json.additionalProcedureId;
			this.additionalProcedure = json.additionalProcedure;
			this.primaryDiagnoseId = json.primaryDiagnoseId;
			this.primaryDiagnose = json.primaryDiagnose;
			this.primaryProcedureId = json.primaryProcedureId;
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
			referralID: this.referralID,
			referralNo: this.referralNo,
			bpjsCardNo: this.bpjsCardNo,
			name: this.name,
			ppkDiagnose: this.ppkDiagnose,
			referralStartDate: this.referralStartDate,
			referralEndDate: this.referralEndDate,
			additionalDiagnoseId: this.additionalDiagnoseId,
			additionalProcedureId: this.additionalProcedureId,
			primaryDiagnoseId: this.primaryDiagnoseId,
			primaryProcedureId: this.primaryProcedureId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsSpecialReferralModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsSpecialReferralModel {
		let newModelJson = this.toJSON();

		if (updates.referralID) {
			newModelJson.referralID = updates.referralID;
		}

		if (updates.referralNo) {
			newModelJson.referralNo = updates.referralNo;
		}

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.ppkDiagnose) {
			newModelJson.ppkDiagnose = updates.ppkDiagnose;
		}

		if (updates.referralStartDate) {
			newModelJson.referralStartDate = updates.referralStartDate;
		}

		if (updates.referralEndDate) {
			newModelJson.referralEndDate = updates.referralEndDate;
		}

		if (updates.additionalDiagnoseId) {
			newModelJson.additionalDiagnoseId = updates.additionalDiagnoseId;
		}

		if (updates.additionalProcedureId) {
			newModelJson.additionalProcedureId = updates.additionalProcedureId;
		}

		if (updates.primaryDiagnoseId) {
			newModelJson.primaryDiagnoseId = updates.primaryDiagnoseId;
		}

		if (updates.primaryProcedureId) {
			newModelJson.primaryProcedureId = updates.primaryProcedureId;
		}

		return new BpjsSpecialReferralModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsSpecialReferralModel)) {
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
			'additionalDiagnoseId',
			'additionalDiagnose',
			'additionalProcedureId',
			'additionalProcedure',
			'primaryDiagnoseId',
			'primaryDiagnose',
			'primaryProcedureId',
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
		if (!this.additionalDiagnose) {
			this.additionalDiagnoseId = null;
		} else {
			this.additionalDiagnoseId = this.additionalDiagnose.id;
		}

		if (!this.additionalProcedure) {
			this.additionalProcedureId = null;
		} else {
			this.additionalProcedureId = this.additionalProcedure.id;
		}

		if (!this.primaryDiagnose) {
			this.primaryDiagnoseId = null;
		} else {
			this.primaryDiagnoseId = this.primaryDiagnose.id;
		}

		if (!this.primaryProcedure) {
			this.primaryProcedureId = null;
		} else {
			this.primaryProcedureId = this.primaryProcedure.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
