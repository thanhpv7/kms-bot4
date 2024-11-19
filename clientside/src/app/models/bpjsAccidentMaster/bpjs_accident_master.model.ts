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
export class BpjsAccidentMasterModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'nosep',
		'kdkec',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'nosep',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsAccidentMasterModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsAccidentMasterModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	nosep: string;

	/**
	 * .
	 */
	tglkejadian: string;

	/**
	 * .
	 */
	ppkpelsep: string;

	/**
	 * .
	 */
	kdprop: string;

	/**
	 * .
	 */
	kdkab: string;

	/**
	 * .
	 */
	kdkec: string;

	/**
	 * .
	 */
	ketkejadian: string;

	/**
	 * .
	 */
	nosepsuplesi: string;

	patientPaymentBPJSId: string;

	patientPaymentBPJS: PatientPaymentBPJSModel;

	modelPropGroups: { [s: string]: Group } = BpjsAccidentMasterModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'nosep',
				// % protected region % [Set displayName for noSEP here] off begin
				displayName: 'noSEP',
				// % protected region % [Set displayName for noSEP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noSEP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noSEP here] end
				// % protected region % [Set isSensitive for noSEP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noSEP here] end
				// % protected region % [Set readonly for noSEP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noSEP here] end
				validators: [
					// % protected region % [Add other validators for noSEP here] off begin
					// % protected region % [Add other validators for noSEP here] end
				],
				// % protected region % [Add any additional model attribute properties for noSEP here] off begin
				// % protected region % [Add any additional model attribute properties for noSEP here] end
			},
			{
				name: 'tglkejadian',
				// % protected region % [Set displayName for tglKejadian here] off begin
				displayName: 'tglKejadian',
				// % protected region % [Set displayName for tglKejadian here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglKejadian here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglKejadian here] end
				// % protected region % [Set isSensitive for tglKejadian here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglKejadian here] end
				// % protected region % [Set readonly for tglKejadian here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglKejadian here] end
				validators: [
					// % protected region % [Add other validators for tglKejadian here] off begin
					// % protected region % [Add other validators for tglKejadian here] end
				],
				// % protected region % [Add any additional model attribute properties for tglKejadian here] off begin
				// % protected region % [Add any additional model attribute properties for tglKejadian here] end
			},
			{
				name: 'ppkpelsep',
				// % protected region % [Set displayName for ppkPelSEP here] off begin
				displayName: 'ppkPelSEP',
				// % protected region % [Set displayName for ppkPelSEP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ppkPelSEP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ppkPelSEP here] end
				// % protected region % [Set isSensitive for ppkPelSEP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ppkPelSEP here] end
				// % protected region % [Set readonly for ppkPelSEP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ppkPelSEP here] end
				validators: [
					// % protected region % [Add other validators for ppkPelSEP here] off begin
					// % protected region % [Add other validators for ppkPelSEP here] end
				],
				// % protected region % [Add any additional model attribute properties for ppkPelSEP here] off begin
				// % protected region % [Add any additional model attribute properties for ppkPelSEP here] end
			},
			{
				name: 'kdprop',
				// % protected region % [Set displayName for kdProp here] off begin
				displayName: 'kdProp',
				// % protected region % [Set displayName for kdProp here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdProp here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdProp here] end
				// % protected region % [Set isSensitive for kdProp here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdProp here] end
				// % protected region % [Set readonly for kdProp here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdProp here] end
				validators: [
					// % protected region % [Add other validators for kdProp here] off begin
					// % protected region % [Add other validators for kdProp here] end
				],
				// % protected region % [Add any additional model attribute properties for kdProp here] off begin
				// % protected region % [Add any additional model attribute properties for kdProp here] end
			},
			{
				name: 'kdkab',
				// % protected region % [Set displayName for kdKab here] off begin
				displayName: 'kdKab',
				// % protected region % [Set displayName for kdKab here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdKab here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdKab here] end
				// % protected region % [Set isSensitive for kdKab here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdKab here] end
				// % protected region % [Set readonly for kdKab here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdKab here] end
				validators: [
					// % protected region % [Add other validators for kdKab here] off begin
					// % protected region % [Add other validators for kdKab here] end
				],
				// % protected region % [Add any additional model attribute properties for kdKab here] off begin
				// % protected region % [Add any additional model attribute properties for kdKab here] end
			},
			{
				name: 'kdkec',
				// % protected region % [Set displayName for kdKec here] off begin
				displayName: 'kdKec',
				// % protected region % [Set displayName for kdKec here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdKec here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdKec here] end
				// % protected region % [Set isSensitive for kdKec here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdKec here] end
				// % protected region % [Set readonly for kdKec here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdKec here] end
				validators: [
					// % protected region % [Add other validators for kdKec here] off begin
					// % protected region % [Add other validators for kdKec here] end
				],
				// % protected region % [Add any additional model attribute properties for kdKec here] off begin
				// % protected region % [Add any additional model attribute properties for kdKec here] end
			},
			{
				name: 'ketkejadian',
				// % protected region % [Set displayName for ketKejadian here] off begin
				displayName: 'ketKejadian',
				// % protected region % [Set displayName for ketKejadian here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ketKejadian here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ketKejadian here] end
				// % protected region % [Set isSensitive for ketKejadian here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ketKejadian here] end
				// % protected region % [Set readonly for ketKejadian here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ketKejadian here] end
				validators: [
					// % protected region % [Add other validators for ketKejadian here] off begin
					// % protected region % [Add other validators for ketKejadian here] end
				],
				// % protected region % [Add any additional model attribute properties for ketKejadian here] off begin
				// % protected region % [Add any additional model attribute properties for ketKejadian here] end
			},
			{
				name: 'nosepsuplesi',
				// % protected region % [Set displayName for noSEPSuplesi here] off begin
				displayName: 'noSEPSuplesi',
				// % protected region % [Set displayName for noSEPSuplesi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noSEPSuplesi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noSEPSuplesi here] end
				// % protected region % [Set isSensitive for noSEPSuplesi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noSEPSuplesi here] end
				// % protected region % [Set readonly for noSEPSuplesi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noSEPSuplesi here] end
				validators: [
					// % protected region % [Add other validators for noSEPSuplesi here] off begin
					// % protected region % [Add other validators for noSEPSuplesi here] end
				],
				// % protected region % [Add any additional model attribute properties for noSEPSuplesi here] off begin
				// % protected region % [Add any additional model attribute properties for noSEPSuplesi here] end
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
				case 'nosep':
					break;
				case 'kdkec':
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
	static deepParse(data: string | { [K in keyof BpjsAccidentMasterModel]?: BpjsAccidentMasterModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsAccidentMasterModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

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
	 * `let bpjsAccidentMasterModel = new BpjsAccidentMasterModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsAccidentMasterModel,
	 *    it is expected as a JSON string or as a nullable BpjsAccidentMasterModel.
	 */
	constructor(data?: string | Partial<BpjsAccidentMasterModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsAccidentMasterModel>
				: data;

			this.nosep = json.nosep;
			this.tglkejadian = json.tglkejadian;
			this.ppkpelsep = json.ppkpelsep;
			this.kdprop = json.kdprop;
			this.kdkab = json.kdkab;
			this.kdkec = json.kdkec;
			this.ketkejadian = json.ketkejadian;
			this.nosepsuplesi = json.nosepsuplesi;
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
			nosep: this.nosep,
			tglkejadian: this.tglkejadian,
			ppkpelsep: this.ppkpelsep,
			kdprop: this.kdprop,
			kdkab: this.kdkab,
			kdkec: this.kdkec,
			ketkejadian: this.ketkejadian,
			nosepsuplesi: this.nosepsuplesi,
			patientPaymentBPJSId: this.patientPaymentBPJSId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsAccidentMasterModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsAccidentMasterModel {
		let newModelJson = this.toJSON();

		if (updates.nosep) {
			newModelJson.nosep = updates.nosep;
		}

		if (updates.tglkejadian) {
			newModelJson.tglkejadian = updates.tglkejadian;
		}

		if (updates.ppkpelsep) {
			newModelJson.ppkpelsep = updates.ppkpelsep;
		}

		if (updates.kdprop) {
			newModelJson.kdprop = updates.kdprop;
		}

		if (updates.kdkab) {
			newModelJson.kdkab = updates.kdkab;
		}

		if (updates.kdkec) {
			newModelJson.kdkec = updates.kdkec;
		}

		if (updates.ketkejadian) {
			newModelJson.ketkejadian = updates.ketkejadian;
		}

		if (updates.nosepsuplesi) {
			newModelJson.nosepsuplesi = updates.nosepsuplesi;
		}

		if (updates.patientPaymentBPJSId) {
			newModelJson.patientPaymentBPJSId = updates.patientPaymentBPJSId;
		}

		return new BpjsAccidentMasterModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsAccidentMasterModel)) {
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
		if (!this.patientPaymentBPJS) {
			this.patientPaymentBPJSId = null;
		} else {
			this.patientPaymentBPJSId = this.patientPaymentBPJS.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
