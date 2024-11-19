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
export class BpjsJasaRaharjaModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'initialSEPNo',
		'guaranteeLetterNo',
		'incidentDate',
		'noSEPSuplesi',
		'tanggalSEPSuplesi',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'initialSEPNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsJasaRaharjaModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsJasaRaharjaModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * BPJS Schema Fieldname : noSepAwal.
	 */
	initialSEPNo: string;

	/**
	 * BPJS Schema Fieldname : noSuratJaminan.
	 */
	guaranteeLetterNo: string;

	/**
	 * BPJS Schema Fieldname : tglKejadian.
	 */
	incidentDate: Date;

	/**
	 * BPJS Schema Fieldname : noRegister.
	 */
	registrationNo: string;

	/**
	 * BPJS Schema Fieldname : noSep.
	 */
	noSEPSuplesi: string;

	/**
	 * BPJS Schema Fieldname : tglSep.
	 */
	tanggalSEPSuplesi: Date;

	patientPaymentBPJSId: string;

	patientPaymentBPJS: PatientPaymentBPJSModel;

	modelPropGroups: { [s: string]: Group } = BpjsJasaRaharjaModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'initialSEPNo',
				// % protected region % [Set displayName for Initial SEP No here] off begin
				displayName: 'Initial SEP No',
				// % protected region % [Set displayName for Initial SEP No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Initial SEP No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Initial SEP No here] end
				// % protected region % [Set isSensitive for Initial SEP No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Initial SEP No here] end
				// % protected region % [Set readonly for Initial SEP No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Initial SEP No here] end
				validators: [
					// % protected region % [Add other validators for Initial SEP No here] off begin
					// % protected region % [Add other validators for Initial SEP No here] end
				],
				// % protected region % [Add any additional model attribute properties for Initial SEP No here] off begin
				// % protected region % [Add any additional model attribute properties for Initial SEP No here] end
			},
			{
				name: 'guaranteeLetterNo',
				// % protected region % [Set displayName for Guarantee Letter No here] off begin
				displayName: 'Guarantee Letter No',
				// % protected region % [Set displayName for Guarantee Letter No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Guarantee Letter No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Guarantee Letter No here] end
				// % protected region % [Set isSensitive for Guarantee Letter No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Guarantee Letter No here] end
				// % protected region % [Set readonly for Guarantee Letter No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Guarantee Letter No here] end
				validators: [
					// % protected region % [Add other validators for Guarantee Letter No here] off begin
					// % protected region % [Add other validators for Guarantee Letter No here] end
				],
				// % protected region % [Add any additional model attribute properties for Guarantee Letter No here] off begin
				// % protected region % [Add any additional model attribute properties for Guarantee Letter No here] end
			},
			{
				name: 'incidentDate',
				// % protected region % [Set displayName for Incident Date here] off begin
				displayName: 'Incident Date',
				// % protected region % [Set displayName for Incident Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Incident Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Incident Date here] end
				// % protected region % [Set isSensitive for Incident Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Incident Date here] end
				// % protected region % [Set readonly for Incident Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Incident Date here] end
				validators: [
					// % protected region % [Add other validators for Incident Date here] off begin
					// % protected region % [Add other validators for Incident Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Incident Date here] off begin
				// % protected region % [Add any additional model attribute properties for Incident Date here] end
			},
			{
				name: 'registrationNo',
				// % protected region % [Set displayName for Registration No here] off begin
				displayName: 'Registration No',
				// % protected region % [Set displayName for Registration No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Registration No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Registration No here] end
				// % protected region % [Set isSensitive for Registration No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Registration No here] end
				// % protected region % [Set readonly for Registration No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Registration No here] end
				validators: [
					// % protected region % [Add other validators for Registration No here] off begin
					// % protected region % [Add other validators for Registration No here] end
				],
				// % protected region % [Add any additional model attribute properties for Registration No here] off begin
				// % protected region % [Add any additional model attribute properties for Registration No here] end
			},
			{
				name: 'noSEPSuplesi',
				// % protected region % [Set displayName for No SEP Suplesi here] off begin
				displayName: 'No SEP Suplesi',
				// % protected region % [Set displayName for No SEP Suplesi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for No SEP Suplesi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for No SEP Suplesi here] end
				// % protected region % [Set isSensitive for No SEP Suplesi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for No SEP Suplesi here] end
				// % protected region % [Set readonly for No SEP Suplesi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for No SEP Suplesi here] end
				validators: [
					// % protected region % [Add other validators for No SEP Suplesi here] off begin
					// % protected region % [Add other validators for No SEP Suplesi here] end
				],
				// % protected region % [Add any additional model attribute properties for No SEP Suplesi here] off begin
				// % protected region % [Add any additional model attribute properties for No SEP Suplesi here] end
			},
			{
				name: 'tanggalSEPSuplesi',
				// % protected region % [Set displayName for Tanggal SEP Suplesi here] off begin
				displayName: 'Tanggal SEP Suplesi',
				// % protected region % [Set displayName for Tanggal SEP Suplesi here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Tanggal SEP Suplesi here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Tanggal SEP Suplesi here] end
				// % protected region % [Set isSensitive for Tanggal SEP Suplesi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tanggal SEP Suplesi here] end
				// % protected region % [Set readonly for Tanggal SEP Suplesi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tanggal SEP Suplesi here] end
				validators: [
					// % protected region % [Add other validators for Tanggal SEP Suplesi here] off begin
					// % protected region % [Add other validators for Tanggal SEP Suplesi here] end
				],
				// % protected region % [Add any additional model attribute properties for Tanggal SEP Suplesi here] off begin
				// % protected region % [Add any additional model attribute properties for Tanggal SEP Suplesi here] end
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
				case 'initialSEPNo':
					break;
				case 'guaranteeLetterNo':
					break;
				case 'incidentDate':
					break;
				case 'noSEPSuplesi':
					break;
				case 'tanggalSEPSuplesi':
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
	static deepParse(data: string | { [K in keyof BpjsJasaRaharjaModel]?: BpjsJasaRaharjaModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsJasaRaharjaModel(data);
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
	 * `let bpjsJasaRaharjaModel = new BpjsJasaRaharjaModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsJasaRaharjaModel,
	 *    it is expected as a JSON string or as a nullable BpjsJasaRaharjaModel.
	 */
	constructor(data?: string | Partial<BpjsJasaRaharjaModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsJasaRaharjaModel>
				: data;

			this.initialSEPNo = json.initialSEPNo;
			this.guaranteeLetterNo = json.guaranteeLetterNo;
			if (json.incidentDate) {
				this.incidentDate = new Date(json.incidentDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.incidentDate = json.incidentDate;
			}
			this.registrationNo = json.registrationNo;
			this.noSEPSuplesi = json.noSEPSuplesi;
			if (json.tanggalSEPSuplesi) {
				this.tanggalSEPSuplesi = new Date(json.tanggalSEPSuplesi);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.tanggalSEPSuplesi = json.tanggalSEPSuplesi;
			}
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
			initialSEPNo: this.initialSEPNo,
			guaranteeLetterNo: this.guaranteeLetterNo,
			incidentDate: this.incidentDate,
			registrationNo: this.registrationNo,
			noSEPSuplesi: this.noSEPSuplesi,
			tanggalSEPSuplesi: this.tanggalSEPSuplesi,
			patientPaymentBPJSId: this.patientPaymentBPJSId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsJasaRaharjaModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsJasaRaharjaModel {
		let newModelJson = this.toJSON();

		if (updates.initialSEPNo) {
			newModelJson.initialSEPNo = updates.initialSEPNo;
		}

		if (updates.guaranteeLetterNo) {
			newModelJson.guaranteeLetterNo = updates.guaranteeLetterNo;
		}

		if (updates.incidentDate) {
			newModelJson.incidentDate = updates.incidentDate;
		}

		if (updates.registrationNo) {
			newModelJson.registrationNo = updates.registrationNo;
		}

		if (updates.noSEPSuplesi) {
			newModelJson.noSEPSuplesi = updates.noSEPSuplesi;
		}

		if (updates.tanggalSEPSuplesi) {
			newModelJson.tanggalSEPSuplesi = updates.tanggalSEPSuplesi;
		}

		if (updates.patientPaymentBPJSId) {
			newModelJson.patientPaymentBPJSId = updates.patientPaymentBPJSId;
		}

		return new BpjsJasaRaharjaModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsJasaRaharjaModel)) {
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
