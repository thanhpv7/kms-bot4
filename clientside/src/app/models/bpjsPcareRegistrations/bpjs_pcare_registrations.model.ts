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
import {PatientVisitModel} from '../patientVisit/patient_visit.model';
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
export class BpjsPcareRegistrationsModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'kdproviderpeserta',
		'tgldaftar',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'kdproviderpeserta',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPcareRegistrationsModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPcareRegistrationsModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	kdproviderpeserta: string;

	/**
	 * .
	 */
	tgldaftar: string;

	/**
	 * .
	 */
	nokartu: string;

	/**
	 * .
	 */
	kdpoli: string;

	/**
	 * .
	 */
	keluhan: string;

	/**
	 * .
	 */
	kunjsakit: string;

	/**
	 * .
	 */
	sistole: string;

	/**
	 * .
	 */
	diastole: string;

	/**
	 * .
	 */
	beratbadan: string;

	/**
	 * .
	 */
	tinggibadan: string;

	/**
	 * .
	 */
	resprate: string;

	/**
	 * .
	 */
	lingkarperut: string;

	/**
	 * .
	 */
	rujukinternal: string;

	/**
	 * .
	 */
	heartrate: string;

	/**
	 * .
	 */
	rujukbalik: string;

	/**
	 * .
	 */
	kdtkp: string;

	patientVisitId: string;

	patientVisit: PatientVisitModel;

	registrationId: string;

	registration: RegistrationModel;

	modelPropGroups: { [s: string]: Group } = BpjsPcareRegistrationsModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'kdproviderpeserta',
				// % protected region % [Set displayName for kdProviderPeserta here] off begin
				displayName: 'kdProviderPeserta',
				// % protected region % [Set displayName for kdProviderPeserta here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdProviderPeserta here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdProviderPeserta here] end
				// % protected region % [Set isSensitive for kdProviderPeserta here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdProviderPeserta here] end
				// % protected region % [Set readonly for kdProviderPeserta here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdProviderPeserta here] end
				validators: [
					// % protected region % [Add other validators for kdProviderPeserta here] off begin
					// % protected region % [Add other validators for kdProviderPeserta here] end
				],
				// % protected region % [Add any additional model attribute properties for kdProviderPeserta here] off begin
				// % protected region % [Add any additional model attribute properties for kdProviderPeserta here] end
			},
			{
				name: 'tgldaftar',
				// % protected region % [Set displayName for tglDaftar here] off begin
				displayName: 'tglDaftar',
				// % protected region % [Set displayName for tglDaftar here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglDaftar here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglDaftar here] end
				// % protected region % [Set isSensitive for tglDaftar here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglDaftar here] end
				// % protected region % [Set readonly for tglDaftar here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglDaftar here] end
				validators: [
					// % protected region % [Add other validators for tglDaftar here] off begin
					// % protected region % [Add other validators for tglDaftar here] end
				],
				// % protected region % [Add any additional model attribute properties for tglDaftar here] off begin
				// % protected region % [Add any additional model attribute properties for tglDaftar here] end
			},
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
				name: 'kdpoli',
				// % protected region % [Set displayName for kdPoli here] off begin
				displayName: 'kdPoli',
				// % protected region % [Set displayName for kdPoli here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdPoli here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdPoli here] end
				// % protected region % [Set isSensitive for kdPoli here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdPoli here] end
				// % protected region % [Set readonly for kdPoli here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdPoli here] end
				validators: [
					// % protected region % [Add other validators for kdPoli here] off begin
					// % protected region % [Add other validators for kdPoli here] end
				],
				// % protected region % [Add any additional model attribute properties for kdPoli here] off begin
				// % protected region % [Add any additional model attribute properties for kdPoli here] end
			},
			{
				name: 'keluhan',
				// % protected region % [Set displayName for keluhan here] off begin
				displayName: 'keluhan',
				// % protected region % [Set displayName for keluhan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for keluhan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for keluhan here] end
				// % protected region % [Set isSensitive for keluhan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for keluhan here] end
				// % protected region % [Set readonly for keluhan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for keluhan here] end
				validators: [
					// % protected region % [Add other validators for keluhan here] off begin
					// % protected region % [Add other validators for keluhan here] end
				],
				// % protected region % [Add any additional model attribute properties for keluhan here] off begin
				// % protected region % [Add any additional model attribute properties for keluhan here] end
			},
			{
				name: 'kunjsakit',
				// % protected region % [Set displayName for kunjSakit here] off begin
				displayName: 'kunjSakit',
				// % protected region % [Set displayName for kunjSakit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kunjSakit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kunjSakit here] end
				// % protected region % [Set isSensitive for kunjSakit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kunjSakit here] end
				// % protected region % [Set readonly for kunjSakit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kunjSakit here] end
				validators: [
					// % protected region % [Add other validators for kunjSakit here] off begin
					// % protected region % [Add other validators for kunjSakit here] end
				],
				// % protected region % [Add any additional model attribute properties for kunjSakit here] off begin
				// % protected region % [Add any additional model attribute properties for kunjSakit here] end
			},
			{
				name: 'sistole',
				// % protected region % [Set displayName for sistole here] off begin
				displayName: 'sistole',
				// % protected region % [Set displayName for sistole here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for sistole here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for sistole here] end
				// % protected region % [Set isSensitive for sistole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for sistole here] end
				// % protected region % [Set readonly for sistole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for sistole here] end
				validators: [
					// % protected region % [Add other validators for sistole here] off begin
					// % protected region % [Add other validators for sistole here] end
				],
				// % protected region % [Add any additional model attribute properties for sistole here] off begin
				// % protected region % [Add any additional model attribute properties for sistole here] end
			},
			{
				name: 'diastole',
				// % protected region % [Set displayName for diastole here] off begin
				displayName: 'diastole',
				// % protected region % [Set displayName for diastole here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for diastole here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for diastole here] end
				// % protected region % [Set isSensitive for diastole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for diastole here] end
				// % protected region % [Set readonly for diastole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for diastole here] end
				validators: [
					// % protected region % [Add other validators for diastole here] off begin
					// % protected region % [Add other validators for diastole here] end
				],
				// % protected region % [Add any additional model attribute properties for diastole here] off begin
				// % protected region % [Add any additional model attribute properties for diastole here] end
			},
			{
				name: 'beratbadan',
				// % protected region % [Set displayName for beratBadan here] off begin
				displayName: 'beratBadan',
				// % protected region % [Set displayName for beratBadan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for beratBadan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for beratBadan here] end
				// % protected region % [Set isSensitive for beratBadan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for beratBadan here] end
				// % protected region % [Set readonly for beratBadan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for beratBadan here] end
				validators: [
					// % protected region % [Add other validators for beratBadan here] off begin
					// % protected region % [Add other validators for beratBadan here] end
				],
				// % protected region % [Add any additional model attribute properties for beratBadan here] off begin
				// % protected region % [Add any additional model attribute properties for beratBadan here] end
			},
			{
				name: 'tinggibadan',
				// % protected region % [Set displayName for tinggiBadan here] off begin
				displayName: 'tinggiBadan',
				// % protected region % [Set displayName for tinggiBadan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tinggiBadan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tinggiBadan here] end
				// % protected region % [Set isSensitive for tinggiBadan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tinggiBadan here] end
				// % protected region % [Set readonly for tinggiBadan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tinggiBadan here] end
				validators: [
					// % protected region % [Add other validators for tinggiBadan here] off begin
					// % protected region % [Add other validators for tinggiBadan here] end
				],
				// % protected region % [Add any additional model attribute properties for tinggiBadan here] off begin
				// % protected region % [Add any additional model attribute properties for tinggiBadan here] end
			},
			{
				name: 'resprate',
				// % protected region % [Set displayName for respRate here] off begin
				displayName: 'respRate',
				// % protected region % [Set displayName for respRate here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for respRate here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for respRate here] end
				// % protected region % [Set isSensitive for respRate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for respRate here] end
				// % protected region % [Set readonly for respRate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for respRate here] end
				validators: [
					// % protected region % [Add other validators for respRate here] off begin
					// % protected region % [Add other validators for respRate here] end
				],
				// % protected region % [Add any additional model attribute properties for respRate here] off begin
				// % protected region % [Add any additional model attribute properties for respRate here] end
			},
			{
				name: 'lingkarperut',
				// % protected region % [Set displayName for lingkarPerut here] off begin
				displayName: 'lingkarPerut',
				// % protected region % [Set displayName for lingkarPerut here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for lingkarPerut here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for lingkarPerut here] end
				// % protected region % [Set isSensitive for lingkarPerut here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for lingkarPerut here] end
				// % protected region % [Set readonly for lingkarPerut here] off begin
				readOnly: false,
				// % protected region % [Set readonly for lingkarPerut here] end
				validators: [
					// % protected region % [Add other validators for lingkarPerut here] off begin
					// % protected region % [Add other validators for lingkarPerut here] end
				],
				// % protected region % [Add any additional model attribute properties for lingkarPerut here] off begin
				// % protected region % [Add any additional model attribute properties for lingkarPerut here] end
			},
			{
				name: 'rujukinternal',
				// % protected region % [Set displayName for rujukInternal here] off begin
				displayName: 'rujukInternal',
				// % protected region % [Set displayName for rujukInternal here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for rujukInternal here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for rujukInternal here] end
				// % protected region % [Set isSensitive for rujukInternal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for rujukInternal here] end
				// % protected region % [Set readonly for rujukInternal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for rujukInternal here] end
				validators: [
					// % protected region % [Add other validators for rujukInternal here] off begin
					// % protected region % [Add other validators for rujukInternal here] end
				],
				// % protected region % [Add any additional model attribute properties for rujukInternal here] off begin
				// % protected region % [Add any additional model attribute properties for rujukInternal here] end
			},
			{
				name: 'heartrate',
				// % protected region % [Set displayName for heartRate here] off begin
				displayName: 'heartRate',
				// % protected region % [Set displayName for heartRate here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for heartRate here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for heartRate here] end
				// % protected region % [Set isSensitive for heartRate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for heartRate here] end
				// % protected region % [Set readonly for heartRate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for heartRate here] end
				validators: [
					// % protected region % [Add other validators for heartRate here] off begin
					// % protected region % [Add other validators for heartRate here] end
				],
				// % protected region % [Add any additional model attribute properties for heartRate here] off begin
				// % protected region % [Add any additional model attribute properties for heartRate here] end
			},
			{
				name: 'rujukbalik',
				// % protected region % [Set displayName for rujukBalik here] off begin
				displayName: 'rujukBalik',
				// % protected region % [Set displayName for rujukBalik here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for rujukBalik here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for rujukBalik here] end
				// % protected region % [Set isSensitive for rujukBalik here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for rujukBalik here] end
				// % protected region % [Set readonly for rujukBalik here] off begin
				readOnly: false,
				// % protected region % [Set readonly for rujukBalik here] end
				validators: [
					// % protected region % [Add other validators for rujukBalik here] off begin
					// % protected region % [Add other validators for rujukBalik here] end
				],
				// % protected region % [Add any additional model attribute properties for rujukBalik here] off begin
				// % protected region % [Add any additional model attribute properties for rujukBalik here] end
			},
			{
				name: 'kdtkp',
				// % protected region % [Set displayName for kdTkp here] off begin
				displayName: 'kdTkp',
				// % protected region % [Set displayName for kdTkp here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdTkp here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdTkp here] end
				// % protected region % [Set isSensitive for kdTkp here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdTkp here] end
				// % protected region % [Set readonly for kdTkp here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdTkp here] end
				validators: [
					// % protected region % [Add other validators for kdTkp here] off begin
					// % protected region % [Add other validators for kdTkp here] end
				],
				// % protected region % [Add any additional model attribute properties for kdTkp here] off begin
				// % protected region % [Add any additional model attribute properties for kdTkp here] end
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
				id: 'patientVisit',
				type: ModelRelationType.ONE,
				name: 'patientVisitId',
				// % protected region % [Customise your label for Patient Visit here] off begin
				label: 'Patient Visit',
				// % protected region % [Customise your label for Patient Visit here] end
				entityName: 'PatientVisitModel',
				// % protected region % [Customise your display name for Patient Visit here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'visitNumber',
				// % protected region % [Customise your display name for Patient Visit here] end
				validators: [
					// % protected region % [Add other validators for Patient Visit here] off begin
					// % protected region % [Add other validators for Patient Visit here] end
				],
				// % protected region % [Add any additional field for relation Patient Visit here] off begin
				// % protected region % [Add any additional field for relation Patient Visit here] end
			},
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
				case 'kdproviderpeserta':
					break;
				case 'tgldaftar':
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
	static deepParse(data: string | { [K in keyof BpjsPcareRegistrationsModel]?: BpjsPcareRegistrationsModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPcareRegistrationsModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.patientVisit) {
			currentModel.patientVisitId = json.patientVisit.id;
			returned = _.union(returned, PatientVisitModel.deepParse(json.patientVisit));
		}

		// Incoming one to one
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsPcareRegistrationsModel = new BpjsPcareRegistrationsModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPcareRegistrationsModel,
	 *    it is expected as a JSON string or as a nullable BpjsPcareRegistrationsModel.
	 */
	constructor(data?: string | Partial<BpjsPcareRegistrationsModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPcareRegistrationsModel>
				: data;

			this.kdproviderpeserta = json.kdproviderpeserta;
			this.tgldaftar = json.tgldaftar;
			this.nokartu = json.nokartu;
			this.kdpoli = json.kdpoli;
			this.keluhan = json.keluhan;
			this.kunjsakit = json.kunjsakit;
			this.sistole = json.sistole;
			this.diastole = json.diastole;
			this.beratbadan = json.beratbadan;
			this.tinggibadan = json.tinggibadan;
			this.resprate = json.resprate;
			this.lingkarperut = json.lingkarperut;
			this.rujukinternal = json.rujukinternal;
			this.heartrate = json.heartrate;
			this.rujukbalik = json.rujukbalik;
			this.kdtkp = json.kdtkp;
			this.patientVisitId = json.patientVisitId;
			this.patientVisit = json.patientVisit;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			kdproviderpeserta: this.kdproviderpeserta,
			tgldaftar: this.tgldaftar,
			nokartu: this.nokartu,
			kdpoli: this.kdpoli,
			keluhan: this.keluhan,
			kunjsakit: this.kunjsakit,
			sistole: this.sistole,
			diastole: this.diastole,
			beratbadan: this.beratbadan,
			tinggibadan: this.tinggibadan,
			resprate: this.resprate,
			lingkarperut: this.lingkarperut,
			rujukinternal: this.rujukinternal,
			heartrate: this.heartrate,
			rujukbalik: this.rujukbalik,
			kdtkp: this.kdtkp,
			patientVisitId: this.patientVisitId,
			registrationId: this.registrationId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPcareRegistrationsModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPcareRegistrationsModel {
		let newModelJson = this.toJSON();

		if (updates.kdproviderpeserta) {
			newModelJson.kdproviderpeserta = updates.kdproviderpeserta;
		}

		if (updates.tgldaftar) {
			newModelJson.tgldaftar = updates.tgldaftar;
		}

		if (updates.nokartu) {
			newModelJson.nokartu = updates.nokartu;
		}

		if (updates.kdpoli) {
			newModelJson.kdpoli = updates.kdpoli;
		}

		if (updates.keluhan) {
			newModelJson.keluhan = updates.keluhan;
		}

		if (updates.kunjsakit) {
			newModelJson.kunjsakit = updates.kunjsakit;
		}

		if (updates.sistole) {
			newModelJson.sistole = updates.sistole;
		}

		if (updates.diastole) {
			newModelJson.diastole = updates.diastole;
		}

		if (updates.beratbadan) {
			newModelJson.beratbadan = updates.beratbadan;
		}

		if (updates.tinggibadan) {
			newModelJson.tinggibadan = updates.tinggibadan;
		}

		if (updates.resprate) {
			newModelJson.resprate = updates.resprate;
		}

		if (updates.lingkarperut) {
			newModelJson.lingkarperut = updates.lingkarperut;
		}

		if (updates.rujukinternal) {
			newModelJson.rujukinternal = updates.rujukinternal;
		}

		if (updates.heartrate) {
			newModelJson.heartrate = updates.heartrate;
		}

		if (updates.rujukbalik) {
			newModelJson.rujukbalik = updates.rujukbalik;
		}

		if (updates.kdtkp) {
			newModelJson.kdtkp = updates.kdtkp;
		}

		if (updates.patientVisitId) {
			newModelJson.patientVisitId = updates.patientVisitId;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		return new BpjsPcareRegistrationsModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPcareRegistrationsModel)) {
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
			'patientVisitId',
			'patientVisit',
			'registrationId',
			'registration',
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
		if (!this.patientVisit) {
			this.patientVisitId = null;
		} else {
			this.patientVisitId = this.patientVisit.id;
		}

		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
