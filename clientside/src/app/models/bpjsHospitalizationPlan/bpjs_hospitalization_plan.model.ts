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
import {BpjsDoctorMappingModel} from '../bpjsDoctorMapping/bpjs_doctor_mapping.model';
import {BpjsServiceMappingModel} from '../bpjsServiceMapping/bpjs_service_mapping.model';
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
export class BpjsHospitalizationPlanModel extends AbstractModel {
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
		'nokartu',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsHospitalizationPlanModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsHospitalizationPlanModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	nokartu: string;

	/**
	 * .
	 */
	tglrencanakontrol: Date;

	/**
	 * .
	 */
	nospri: string;

	/**
	 * .
	 */
	diagnosa: string;

	patientPaymentBPJSId: string;

	patientPaymentBPJS: PatientPaymentBPJSModel;

	bpjsDoctorMappingId: string;

	bpjsDoctorMapping: BpjsDoctorMappingModel;

	bpjsServiceMappingId: string;

	bpjsServiceMapping: BpjsServiceMappingModel;

	modelPropGroups: { [s: string]: Group } = BpjsHospitalizationPlanModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'nokartu',
				// % protected region % [Set displayName for noKartu here] off begin
				displayName: 'noKartu',
				// % protected region % [Set displayName for noKartu here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noKartu here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noKartu here] end
				// % protected region % [Set isSensitive for noKartu here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noKartu here] end
				// % protected region % [Set readonly for noKartu here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noKartu here] end
				validators: [
					// % protected region % [Add other validators for noKartu here] off begin
					// % protected region % [Add other validators for noKartu here] end
				],
				// % protected region % [Add any additional model attribute properties for noKartu here] off begin
				// % protected region % [Add any additional model attribute properties for noKartu here] end
			},
			{
				name: 'tglrencanakontrol',
				// % protected region % [Set displayName for tglRencanaKontrol here] off begin
				displayName: 'tglRencanaKontrol',
				// % protected region % [Set displayName for tglRencanaKontrol here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for tglRencanaKontrol here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for tglRencanaKontrol here] end
				// % protected region % [Set isSensitive for tglRencanaKontrol here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglRencanaKontrol here] end
				// % protected region % [Set readonly for tglRencanaKontrol here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglRencanaKontrol here] end
				validators: [
					// % protected region % [Add other validators for tglRencanaKontrol here] off begin
					// % protected region % [Add other validators for tglRencanaKontrol here] end
				],
				// % protected region % [Add any additional model attribute properties for tglRencanaKontrol here] off begin
				// % protected region % [Add any additional model attribute properties for tglRencanaKontrol here] end
			},
			{
				name: 'nospri',
				// % protected region % [Set displayName for noSPRI here] off begin
				displayName: 'noSPRI',
				// % protected region % [Set displayName for noSPRI here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noSPRI here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noSPRI here] end
				// % protected region % [Set isSensitive for noSPRI here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noSPRI here] end
				// % protected region % [Set readonly for noSPRI here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noSPRI here] end
				validators: [
					// % protected region % [Add other validators for noSPRI here] off begin
					// % protected region % [Add other validators for noSPRI here] end
				],
				// % protected region % [Add any additional model attribute properties for noSPRI here] off begin
				// % protected region % [Add any additional model attribute properties for noSPRI here] end
			},
			{
				name: 'diagnosa',
				// % protected region % [Set displayName for diagnosa here] off begin
				displayName: 'diagnosa',
				// % protected region % [Set displayName for diagnosa here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for diagnosa here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for diagnosa here] end
				// % protected region % [Set isSensitive for diagnosa here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for diagnosa here] end
				// % protected region % [Set readonly for diagnosa here] off begin
				readOnly: false,
				// % protected region % [Set readonly for diagnosa here] end
				validators: [
					// % protected region % [Add other validators for diagnosa here] off begin
					// % protected region % [Add other validators for diagnosa here] end
				],
				// % protected region % [Add any additional model attribute properties for diagnosa here] off begin
				// % protected region % [Add any additional model attribute properties for diagnosa here] end
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
			{
				id: 'bpjsDoctorMapping',
				type: ModelRelationType.ONE,
				name: 'bpjsDoctorMappingId',
				// % protected region % [Customise your label for BPJS Doctor Mapping here] off begin
				label: 'BPJS Doctor Mapping',
				// % protected region % [Customise your label for BPJS Doctor Mapping here] end
				entityName: 'BpjsDoctorMappingModel',
				// % protected region % [Customise your display name for BPJS Doctor Mapping here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Doctor Mapping here] end
				validators: [
					// % protected region % [Add other validators for BPJS Doctor Mapping here] off begin
					// % protected region % [Add other validators for BPJS Doctor Mapping here] end
				],
				// % protected region % [Add any additional field for relation BPJS Doctor Mapping here] off begin
				// % protected region % [Add any additional field for relation BPJS Doctor Mapping here] end
			},
			{
				id: 'bpjsServiceMapping',
				type: ModelRelationType.ONE,
				name: 'bpjsServiceMappingId',
				// % protected region % [Customise your label for BPJS Service Mapping here] off begin
				label: 'BPJS Service Mapping',
				// % protected region % [Customise your label for BPJS Service Mapping here] end
				entityName: 'BpjsServiceMappingModel',
				// % protected region % [Customise your display name for BPJS Service Mapping here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Service Mapping here] end
				validators: [
					// % protected region % [Add other validators for BPJS Service Mapping here] off begin
					// % protected region % [Add other validators for BPJS Service Mapping here] end
				],
				// % protected region % [Add any additional field for relation BPJS Service Mapping here] off begin
				// % protected region % [Add any additional field for relation BPJS Service Mapping here] end
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
	static deepParse(data: string | { [K in keyof BpjsHospitalizationPlanModel]?: BpjsHospitalizationPlanModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsHospitalizationPlanModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.patientPaymentBPJS) {
			currentModel.patientPaymentBPJSId = json.patientPaymentBPJS.id;
			returned = _.union(returned, PatientPaymentBPJSModel.deepParse(json.patientPaymentBPJS));
		}

		// Incoming one to many
		if (json.bpjsDoctorMapping) {
			currentModel.bpjsDoctorMappingId = json.bpjsDoctorMapping.id;
			returned = _.union(returned, BpjsDoctorMappingModel.deepParse(json.bpjsDoctorMapping));
		}

		// Incoming one to many
		if (json.bpjsServiceMapping) {
			currentModel.bpjsServiceMappingId = json.bpjsServiceMapping.id;
			returned = _.union(returned, BpjsServiceMappingModel.deepParse(json.bpjsServiceMapping));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsHospitalizationPlanModel = new BpjsHospitalizationPlanModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsHospitalizationPlanModel,
	 *    it is expected as a JSON string or as a nullable BpjsHospitalizationPlanModel.
	 */
	constructor(data?: string | Partial<BpjsHospitalizationPlanModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsHospitalizationPlanModel>
				: data;

			this.nokartu = json.nokartu;
			if (json.tglrencanakontrol) {
				this.tglrencanakontrol = new Date(json.tglrencanakontrol);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.tglrencanakontrol = json.tglrencanakontrol;
			}
			this.nospri = json.nospri;
			this.diagnosa = json.diagnosa;
			this.patientPaymentBPJSId = json.patientPaymentBPJSId;
			this.patientPaymentBPJS = json.patientPaymentBPJS;
			this.bpjsDoctorMappingId = json.bpjsDoctorMappingId;
			this.bpjsDoctorMapping = json.bpjsDoctorMapping;
			this.bpjsServiceMappingId = json.bpjsServiceMappingId;
			this.bpjsServiceMapping = json.bpjsServiceMapping;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			nokartu: this.nokartu,
			tglrencanakontrol: this.tglrencanakontrol,
			nospri: this.nospri,
			diagnosa: this.diagnosa,
			patientPaymentBPJSId: this.patientPaymentBPJSId,
			bpjsDoctorMappingId: this.bpjsDoctorMappingId,
			bpjsServiceMappingId: this.bpjsServiceMappingId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsHospitalizationPlanModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsHospitalizationPlanModel {
		let newModelJson = this.toJSON();

		if (updates.nokartu) {
			newModelJson.nokartu = updates.nokartu;
		}

		if (updates.tglrencanakontrol) {
			newModelJson.tglrencanakontrol = updates.tglrencanakontrol;
		}

		if (updates.nospri) {
			newModelJson.nospri = updates.nospri;
		}

		if (updates.diagnosa) {
			newModelJson.diagnosa = updates.diagnosa;
		}

		if (updates.patientPaymentBPJSId) {
			newModelJson.patientPaymentBPJSId = updates.patientPaymentBPJSId;
		}

		if (updates.bpjsDoctorMappingId) {
			newModelJson.bpjsDoctorMappingId = updates.bpjsDoctorMappingId;
		}

		if (updates.bpjsServiceMappingId) {
			newModelJson.bpjsServiceMappingId = updates.bpjsServiceMappingId;
		}

		return new BpjsHospitalizationPlanModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsHospitalizationPlanModel)) {
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
			'bpjsDoctorMappingId',
			'bpjsDoctorMapping',
			'bpjsServiceMappingId',
			'bpjsServiceMapping',
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

		if (!this.bpjsDoctorMapping) {
			this.bpjsDoctorMappingId = null;
		} else {
			this.bpjsDoctorMappingId = this.bpjsDoctorMapping.id;
		}

		if (!this.bpjsServiceMapping) {
			this.bpjsServiceMappingId = null;
		} else {
			this.bpjsServiceMappingId = this.bpjsServiceMapping.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}