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
import {BpjsDrugGenericPRBModel} from '../bpjsDrugGenericPRB/bpjs_drug_generic_prb.model';
import {RegistrationModel} from '../registration/registration.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsPRBDetailModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'drugCode',
		'drugName',
		'signa1',
		'signa2',
		'qty',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'srbNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPRBDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPRBDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * As foreign keys from header data.
	 */
	srbNo: string;

	/**
	 * .
	 */
	drugCode: string;

	/**
	 * .
	 */
	drugName: string;

	/**
	 * .
	 */
	signa1: string;

	/**
	 * .
	 */
	signa2: string;

	/**
	 * .
	 */
	qty: string;

	registrationId: string;

	registration: RegistrationModel;

	bpjsDrugGenericPRBId: string;

	bpjsDrugGenericPRB: BpjsDrugGenericPRBModel;

	modelPropGroups: { [s: string]: Group } = BpjsPRBDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'srbNo',
				// % protected region % [Set displayName for SRB No here] off begin
				displayName: 'SRB No',
				// % protected region % [Set displayName for SRB No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SRB No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SRB No here] end
				// % protected region % [Set isSensitive for SRB No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SRB No here] end
				// % protected region % [Set readonly for SRB No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SRB No here] end
				validators: [
					// % protected region % [Add other validators for SRB No here] off begin
					// % protected region % [Add other validators for SRB No here] end
				],
				// % protected region % [Add any additional model attribute properties for SRB No here] off begin
				// % protected region % [Add any additional model attribute properties for SRB No here] end
			},
			{
				name: 'drugCode',
				// % protected region % [Set displayName for Drug Code here] off begin
				displayName: 'Drug Code',
				// % protected region % [Set displayName for Drug Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Drug Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Drug Code here] end
				// % protected region % [Set isSensitive for Drug Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drug Code here] end
				// % protected region % [Set readonly for Drug Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drug Code here] end
				validators: [
					// % protected region % [Add other validators for Drug Code here] off begin
					// % protected region % [Add other validators for Drug Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Drug Code here] off begin
				// % protected region % [Add any additional model attribute properties for Drug Code here] end
			},
			{
				name: 'drugName',
				// % protected region % [Set displayName for Drug Name here] off begin
				displayName: 'Drug Name',
				// % protected region % [Set displayName for Drug Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Drug Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Drug Name here] end
				// % protected region % [Set isSensitive for Drug Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drug Name here] end
				// % protected region % [Set readonly for Drug Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drug Name here] end
				validators: [
					// % protected region % [Add other validators for Drug Name here] off begin
					// % protected region % [Add other validators for Drug Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Drug Name here] off begin
				// % protected region % [Add any additional model attribute properties for Drug Name here] end
			},
			{
				name: 'signa1',
				// % protected region % [Set displayName for Signa 1 here] off begin
				displayName: 'Signa 1',
				// % protected region % [Set displayName for Signa 1 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Signa 1 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Signa 1 here] end
				// % protected region % [Set isSensitive for Signa 1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Signa 1 here] end
				// % protected region % [Set readonly for Signa 1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Signa 1 here] end
				validators: [
					// % protected region % [Add other validators for Signa 1 here] off begin
					// % protected region % [Add other validators for Signa 1 here] end
				],
				// % protected region % [Add any additional model attribute properties for Signa 1 here] off begin
				// % protected region % [Add any additional model attribute properties for Signa 1 here] end
			},
			{
				name: 'signa2',
				// % protected region % [Set displayName for Signa 2 here] off begin
				displayName: 'Signa 2',
				// % protected region % [Set displayName for Signa 2 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Signa 2 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Signa 2 here] end
				// % protected region % [Set isSensitive for Signa 2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Signa 2 here] end
				// % protected region % [Set readonly for Signa 2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Signa 2 here] end
				validators: [
					// % protected region % [Add other validators for Signa 2 here] off begin
					// % protected region % [Add other validators for Signa 2 here] end
				],
				// % protected region % [Add any additional model attribute properties for Signa 2 here] off begin
				// % protected region % [Add any additional model attribute properties for Signa 2 here] end
			},
			{
				name: 'qty',
				// % protected region % [Set displayName for Qty here] off begin
				displayName: 'Qty',
				// % protected region % [Set displayName for Qty here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Qty here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Qty here] end
				// % protected region % [Set isSensitive for Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Qty here] end
				// % protected region % [Set readonly for Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Qty here] end
				validators: [
					// % protected region % [Add other validators for Qty here] off begin
					// % protected region % [Add other validators for Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Qty here] end
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
				id: 'registration',
				type: ModelRelationType.ONE,
				name: 'registrationId',
				// % protected region % [Customise your label for Registration here] off begin
				label: 'Registration',
				// % protected region % [Customise your label for Registration here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registration here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registration here] end
				validators: [
					// % protected region % [Add other validators for Registration here] off begin
					// % protected region % [Add other validators for Registration here] end
				],
				// % protected region % [Add any additional field for relation Registration here] off begin
				// % protected region % [Add any additional field for relation Registration here] end
			},
			{
				id: 'bpjsDrugGenericPRB',
				type: ModelRelationType.ONE,
				name: 'bpjsDrugGenericPRBId',
				// % protected region % [Customise your label for BPJS Drug Generic PRB here] off begin
				label: 'BPJS Drug Generic PRB',
				// % protected region % [Customise your label for BPJS Drug Generic PRB here] end
				entityName: 'BpjsDrugGenericPRBModel',
				// % protected region % [Customise your display name for BPJS Drug Generic PRB here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refDrugCode',
				// % protected region % [Customise your display name for BPJS Drug Generic PRB here] end
				validators: [
					// % protected region % [Add other validators for BPJS Drug Generic PRB here] off begin
					// % protected region % [Add other validators for BPJS Drug Generic PRB here] end
				],
				// % protected region % [Add any additional field for relation BPJS Drug Generic PRB here] off begin
				// % protected region % [Add any additional field for relation BPJS Drug Generic PRB here] end
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
				case 'drugCode':
					break;
				case 'drugName':
					break;
				case 'signa1':
					break;
				case 'signa2':
					break;
				case 'qty':
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
	static deepParse(data: string | { [K in keyof BpjsPRBDetailModel]?: BpjsPRBDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPRBDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

		// Incoming one to many
		if (json.bpjsDrugGenericPRB) {
			currentModel.bpjsDrugGenericPRBId = json.bpjsDrugGenericPRB.id;
			returned = _.union(returned, BpjsDrugGenericPRBModel.deepParse(json.bpjsDrugGenericPRB));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsPRBDetailModel = new BpjsPRBDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPRBDetailModel,
	 *    it is expected as a JSON string or as a nullable BpjsPRBDetailModel.
	 */
	constructor(data?: string | Partial<BpjsPRBDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPRBDetailModel>
				: data;

			this.srbNo = json.srbNo;
			this.drugCode = json.drugCode;
			this.drugName = json.drugName;
			this.signa1 = json.signa1;
			this.signa2 = json.signa2;
			this.qty = json.qty;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.bpjsDrugGenericPRBId = json.bpjsDrugGenericPRBId;
			this.bpjsDrugGenericPRB = json.bpjsDrugGenericPRB;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			srbNo: this.srbNo,
			drugCode: this.drugCode,
			drugName: this.drugName,
			signa1: this.signa1,
			signa2: this.signa2,
			qty: this.qty,
			registrationId: this.registrationId,
			bpjsDrugGenericPRBId: this.bpjsDrugGenericPRBId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPRBDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPRBDetailModel {
		let newModelJson = this.toJSON();

		if (updates.srbNo) {
			newModelJson.srbNo = updates.srbNo;
		}

		if (updates.drugCode) {
			newModelJson.drugCode = updates.drugCode;
		}

		if (updates.drugName) {
			newModelJson.drugName = updates.drugName;
		}

		if (updates.signa1) {
			newModelJson.signa1 = updates.signa1;
		}

		if (updates.signa2) {
			newModelJson.signa2 = updates.signa2;
		}

		if (updates.qty) {
			newModelJson.qty = updates.qty;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.bpjsDrugGenericPRBId) {
			newModelJson.bpjsDrugGenericPRBId = updates.bpjsDrugGenericPRBId;
		}

		return new BpjsPRBDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPRBDetailModel)) {
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
			'registrationId',
			'registration',
			'bpjsDrugGenericPRBId',
			'bpjsDrugGenericPRB',
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
		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

		if (!this.bpjsDrugGenericPRB) {
			this.bpjsDrugGenericPRBId = null;
		} else {
			this.bpjsDrugGenericPRBId = this.bpjsDrugGenericPRB.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
