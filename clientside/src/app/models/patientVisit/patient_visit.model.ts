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
import {BpjsPcareRegistrationsModel} from '../bpjsPcareRegistrations/bpjs_pcare_registrations.model';
import {BpjsVisitDataModel} from '../bpjsVisitData/bpjs_visit_data.model';
import {BpjsPcarePendaftaranModel} from '../bpjsPcarePendaftaran/bpjs_pcare_pendaftaran.model';
import {InvoiceModel} from '../invoice/invoice.model';
import {PatientGeneralInfoModel} from '../patientGeneralInfo/patient_general_info.model';
import {PatientVisitPatientPaymentInsuranceModel} from '../patientVisitPatientPaymentInsurance/patient_visit_patient_payment_insurance.model';
import {PatientVisitPatientPaymentOthersModel} from '../patientVisitPatientPaymentOthers/patient_visit_patient_payment_others.model';
import {PatientVisitPaymentSelfPayingModel} from '../patientVisitPaymentSelfPaying/patient_visit_payment_self_paying.model';
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
export class PatientVisitModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'visitNumber',
		'visitDate',
		'registrationLocation',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'visitNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PatientVisitModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientVisitModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Generated number by system. Auto-increament, with format [TBD by Consultant] (Max Length: 50)).
	 */
	visitNumber: string;

	/**
	 * Registration type, get the Code from Reference Data where Type=REG_TYPE. (Max Length: 20).
	 */
	registrationType: string;

	/**
	 * Date of the visit..
	 */
	visitDate: Date;

	/**
	 * Location where the patient registers, get the Code from Reference Data where Type=REG_LOC. (Max Length: 20).
	 */
	registrationLocation: string;

	/**
	 * Patient Payment Type shall be copied from Patient General Info entity, but user shall enable to change it on Registration process, get the Code from Reference Data where Type=PAT_PAY_TYPE. (Max Length: 20).
	 */
	patientPaymentType: string;

	/**
	 * NEED TO CHANGE THIS TO ENUM LATER AS BPJS REQUEST AN INTEGER VALUE 1 2 3 4 ( RUJUKAN FKTP, etc).
	 */
	visitType: string;

	bpjsPcareRegistrationsId: string;

	bpjsPcareRegistrations: BpjsPcareRegistrationsModel;

	patientVisitPatientPaymentInsuranceId: string;

	patientVisitPatientPaymentInsurance: PatientVisitPatientPaymentInsuranceModel;

	patientVisitPatientPaymentOthersId: string;

	patientVisitPatientPaymentOthers: PatientVisitPatientPaymentOthersModel;

	patientVisitPaymentSelfPayingId: string;

	patientVisitPaymentSelfPaying: PatientVisitPaymentSelfPayingModel;

	patientId: string;

	patient: PatientGeneralInfoModel;

	bpjsVisitDatasIds: string[] = [];

	bpjsVisitDatas: BpjsVisitDataModel[];

	bpjsPcarePendaftaransIds: string[] = [];

	bpjsPcarePendaftarans: BpjsPcarePendaftaranModel[];

	invoicesIds: string[] = [];

	invoices: InvoiceModel[];

	registrationsIds: string[] = [];

	registrations: RegistrationModel[];

	modelPropGroups: { [s: string]: Group } = PatientVisitModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'visitNumber',
				// % protected region % [Set displayName for Visit Number here] off begin
				displayName: 'Visit Number',
				// % protected region % [Set displayName for Visit Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visit Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visit Number here] end
				// % protected region % [Set isSensitive for Visit Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visit Number here] end
				// % protected region % [Set readonly for Visit Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visit Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Visit Number here] off begin
					// % protected region % [Add other validators for Visit Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Visit Number here] off begin
				// % protected region % [Add any additional model attribute properties for Visit Number here] end
			},
			{
				name: 'registrationType',
				// % protected region % [Set displayName for Registration Type here] off begin
				displayName: 'Registration Type',
				// % protected region % [Set displayName for Registration Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Registration Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Registration Type here] end
				// % protected region % [Set isSensitive for Registration Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Registration Type here] end
				// % protected region % [Set readonly for Registration Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Registration Type here] end
				validators: [
					// % protected region % [Add other validators for Registration Type here] off begin
					// % protected region % [Add other validators for Registration Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Registration Type here] off begin
				// % protected region % [Add any additional model attribute properties for Registration Type here] end
			},
			{
				name: 'visitDate',
				// % protected region % [Set displayName for Visit Date here] off begin
				displayName: 'Visit Date',
				// % protected region % [Set displayName for Visit Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Visit Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Visit Date here] end
				// % protected region % [Set isSensitive for Visit Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visit Date here] end
				// % protected region % [Set readonly for Visit Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visit Date here] end
				validators: [
					Validators.required,
					// % protected region % [Add other validators for Visit Date here] off begin
					// % protected region % [Add other validators for Visit Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Visit Date here] off begin
				// % protected region % [Add any additional model attribute properties for Visit Date here] end
			},
			{
				name: 'registrationLocation',
				// % protected region % [Set displayName for Registration Location here] off begin
				displayName: 'Registration Location',
				// % protected region % [Set displayName for Registration Location here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Registration Location here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Registration Location here] end
				// % protected region % [Set isSensitive for Registration Location here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Registration Location here] end
				// % protected region % [Set readonly for Registration Location here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Registration Location here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Registration Location here] off begin
					// % protected region % [Add other validators for Registration Location here] end
				],
				// % protected region % [Add any additional model attribute properties for Registration Location here] off begin
				// % protected region % [Add any additional model attribute properties for Registration Location here] end
			},
			{
				name: 'patientPaymentType',
				// % protected region % [Set displayName for Patient Payment Type here] off begin
				displayName: 'Patient Payment Type',
				// % protected region % [Set displayName for Patient Payment Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient Payment Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient Payment Type here] end
				// % protected region % [Set isSensitive for Patient Payment Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Payment Type here] end
				// % protected region % [Set readonly for Patient Payment Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Payment Type here] end
				validators: [
					// % protected region % [Add other validators for Patient Payment Type here] off begin
					// % protected region % [Add other validators for Patient Payment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Payment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Payment Type here] end
			},
			{
				name: 'visitType',
				// % protected region % [Set displayName for Visit Type here] off begin
				displayName: 'Visit Type',
				// % protected region % [Set displayName for Visit Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visit Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visit Type here] end
				// % protected region % [Set isSensitive for Visit Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visit Type here] end
				// % protected region % [Set readonly for Visit Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visit Type here] end
				validators: [
					// % protected region % [Add other validators for Visit Type here] off begin
					// % protected region % [Add other validators for Visit Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Visit Type here] off begin
				// % protected region % [Add any additional model attribute properties for Visit Type here] end
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
				id: 'bpjsPcareRegistrations',
				type: ModelRelationType.ONE,
				name: 'bpjsPcareRegistrationsId',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Pcare Registrations here] off begin
				label: 'BPJS Pcare Registrations',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Pcare Registrations here] end
				entityName: 'BpjsPcareRegistrationsModel',
				// % protected region % [Customise your display name for BPJS Pcare Registrations here] off begin
				displayName: 'kdproviderpeserta',
				// % protected region % [Customise your display name for BPJS Pcare Registrations here] end
				validators: [
					// % protected region % [Add other validators for BPJS Pcare Registrations here] off begin
					// % protected region % [Add other validators for BPJS Pcare Registrations here] end
				],
				// % protected region % [Add any additional field for relation BPJS Pcare Registrations here] off begin
				// % protected region % [Add any additional field for relation BPJS Pcare Registrations here] end
			},
			{
				id: 'bpjsVisitDatas',
				type: ModelRelationType.MANY,
				name: 'bpjsVisitDatasIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Visit Datas here] off begin
				label: 'BPJS Visit Datas',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Visit Datas here] end
				entityName: 'BpjsVisitDataModel',
				// % protected region % [Customise your display name for BPJS Visit Datas here] off begin
				displayName: 'diagnose',
				// % protected region % [Customise your display name for BPJS Visit Datas here] end
				validators: [
					// % protected region % [Add other validators for BPJS Visit Datas here] off begin
					// % protected region % [Add other validators for BPJS Visit Datas here] end
				],
				// % protected region % [Add any additional field for relation BPJS Visit Datas here] off begin
				// % protected region % [Add any additional field for relation BPJS Visit Datas here] end
			},
			{
				id: 'bpjsPcarePendaftarans',
				type: ModelRelationType.MANY,
				name: 'bpjsPcarePendaftaransIds',
				// % protected region % [Customise your 1-1 or 1-M label for Bpjs Pcare Pendaftarans here] off begin
				label: 'Bpjs Pcare Pendaftarans',
				// % protected region % [Customise your 1-1 or 1-M label for Bpjs Pcare Pendaftarans here] end
				entityName: 'BpjsPcarePendaftaranModel',
				// % protected region % [Customise your display name for Bpjs Pcare Pendaftarans here] off begin
				displayName: 'nourut',
				// % protected region % [Customise your display name for Bpjs Pcare Pendaftarans here] end
				validators: [
					// % protected region % [Add other validators for Bpjs Pcare Pendaftarans here] off begin
					// % protected region % [Add other validators for Bpjs Pcare Pendaftarans here] end
				],
				// % protected region % [Add any additional field for relation Bpjs Pcare Pendaftarans here] off begin
				// % protected region % [Add any additional field for relation Bpjs Pcare Pendaftarans here] end
			},
			{
				id: 'invoices',
				type: ModelRelationType.MANY,
				name: 'invoicesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices here] off begin
				label: 'Invoices',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices here] end
				entityName: 'InvoiceModel',
				// % protected region % [Customise your display name for Invoices here] off begin
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Invoices here] end
				validators: [
					// % protected region % [Add other validators for Invoices here] off begin
					// % protected region % [Add other validators for Invoices here] end
				],
				// % protected region % [Add any additional field for relation Invoices here] off begin
				// % protected region % [Add any additional field for relation Invoices here] end
			},
			{
				id: 'patientVisitPatientPaymentInsurance',
				type: ModelRelationType.ONE,
				name: 'patientVisitPatientPaymentInsuranceId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Visit Patient Payment Insurance here] off begin
				label: 'Patient Visit Patient Payment Insurance',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Visit Patient Payment Insurance here] end
				entityName: 'PatientVisitPatientPaymentInsuranceModel',
				// % protected region % [Customise your display name for Patient Visit Patient Payment Insurance here] off begin
				displayName: 'memberNo',
				// % protected region % [Customise your display name for Patient Visit Patient Payment Insurance here] end
				validators: [
					// % protected region % [Add other validators for Patient Visit Patient Payment Insurance here] off begin
					// % protected region % [Add other validators for Patient Visit Patient Payment Insurance here] end
				],
				// % protected region % [Add any additional field for relation Patient Visit Patient Payment Insurance here] off begin
				// % protected region % [Add any additional field for relation Patient Visit Patient Payment Insurance here] end
			},
			{
				id: 'patientVisitPatientPaymentOthers',
				type: ModelRelationType.ONE,
				name: 'patientVisitPatientPaymentOthersId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Visit Patient Payment Others here] off begin
				label: 'Patient Visit Patient Payment Others',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Visit Patient Payment Others here] end
				entityName: 'PatientVisitPatientPaymentOthersModel',
				// % protected region % [Customise your display name for Patient Visit Patient Payment Others here] off begin
				displayName: 'notes',
				// % protected region % [Customise your display name for Patient Visit Patient Payment Others here] end
				validators: [
					// % protected region % [Add other validators for Patient Visit Patient Payment Others here] off begin
					// % protected region % [Add other validators for Patient Visit Patient Payment Others here] end
				],
				// % protected region % [Add any additional field for relation Patient Visit Patient Payment Others here] off begin
				// % protected region % [Add any additional field for relation Patient Visit Patient Payment Others here] end
			},
			{
				id: 'patientVisitPaymentSelfPaying',
				type: ModelRelationType.ONE,
				name: 'patientVisitPaymentSelfPayingId',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Visit Payment Self Paying here] off begin
				label: 'Patient Visit Payment Self Paying',
				// % protected region % [Customise your 1-1 or 1-M label for Patient Visit Payment Self Paying here] end
				entityName: 'PatientVisitPaymentSelfPayingModel',
				// % protected region % [Customise your display name for Patient Visit Payment Self Paying here] off begin
				displayName: 'sponsorName',
				// % protected region % [Customise your display name for Patient Visit Payment Self Paying here] end
				validators: [
					// % protected region % [Add other validators for Patient Visit Payment Self Paying here] off begin
					// % protected region % [Add other validators for Patient Visit Payment Self Paying here] end
				],
				// % protected region % [Add any additional field for relation Patient Visit Payment Self Paying here] off begin
				// % protected region % [Add any additional field for relation Patient Visit Payment Self Paying here] end
			},
			{
				id: 'registrations',
				type: ModelRelationType.MANY,
				name: 'registrationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Registrations here] off begin
				label: 'Registrations',
				// % protected region % [Customise your 1-1 or 1-M label for Registrations here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registrations here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registrations here] end
				validators: [
					// % protected region % [Add other validators for Registrations here] off begin
					// % protected region % [Add other validators for Registrations here] end
				],
				// % protected region % [Add any additional field for relation Registrations here] off begin
				// % protected region % [Add any additional field for relation Registrations here] end
			},
			{
				id: 'patient',
				type: ModelRelationType.ONE,
				name: 'patientId',
				// % protected region % [Customise your label for Patient here] off begin
				label: 'Patient',
				// % protected region % [Customise your label for Patient here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient here] end
				validators: [
					// % protected region % [Add other validators for Patient here] off begin
					// % protected region % [Add other validators for Patient here] end
				],
				// % protected region % [Add any additional field for relation Patient here] off begin
				// % protected region % [Add any additional field for relation Patient here] end
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
				case 'visitNumber':
					break;
				case 'visitDate':
					break;
				case 'registrationLocation':
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
	static deepParse(data: string | { [K in keyof PatientVisitModel]?: PatientVisitModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientVisitModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.bpjsPcareRegistrations) {
			currentModel.bpjsPcareRegistrationsId = json.bpjsPcareRegistrations.id;
			returned = _.union(returned, BpjsPcareRegistrationsModel.deepParse(json.bpjsPcareRegistrations));
		}

		// Outgoing one to one
		if (json.patientVisitPatientPaymentInsurance) {
			currentModel.patientVisitPatientPaymentInsuranceId = json.patientVisitPatientPaymentInsurance.id;
			returned = _.union(returned, PatientVisitPatientPaymentInsuranceModel.deepParse(json.patientVisitPatientPaymentInsurance));
		}

		// Outgoing one to one
		if (json.patientVisitPatientPaymentOthers) {
			currentModel.patientVisitPatientPaymentOthersId = json.patientVisitPatientPaymentOthers.id;
			returned = _.union(returned, PatientVisitPatientPaymentOthersModel.deepParse(json.patientVisitPatientPaymentOthers));
		}

		// Outgoing one to one
		if (json.patientVisitPaymentSelfPaying) {
			currentModel.patientVisitPaymentSelfPayingId = json.patientVisitPaymentSelfPaying.id;
			returned = _.union(returned, PatientVisitPaymentSelfPayingModel.deepParse(json.patientVisitPaymentSelfPaying));
		}

		// Incoming one to many
		if (json.patient) {
			currentModel.patientId = json.patient.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patient));
		}

		// Outgoing one to many
		if (json.bpjsVisitDatas) {
			currentModel.bpjsVisitDatasIds = json.bpjsVisitDatas.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsVisitDatas.map(model => BpjsVisitDataModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsPcarePendaftarans) {
			currentModel.bpjsPcarePendaftaransIds = json.bpjsPcarePendaftarans.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsPcarePendaftarans.map(model => BpjsPcarePendaftaranModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoices) {
			currentModel.invoicesIds = json.invoices.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoices.map(model => InvoiceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.registrations) {
			currentModel.registrationsIds = json.registrations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.registrations.map(model => RegistrationModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let patientVisitModel = new PatientVisitModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientVisitModel,
	 *    it is expected as a JSON string or as a nullable PatientVisitModel.
	 */
	constructor(data?: string | Partial<PatientVisitModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientVisitModel>
				: data;

			this.visitNumber = json.visitNumber;
			this.registrationType = json.registrationType;
			if (json.visitDate) {
				this.visitDate = new Date(json.visitDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.visitDate = json.visitDate;
			}
			this.registrationLocation = json.registrationLocation;
			this.patientPaymentType = json.patientPaymentType;
			this.visitType = json.visitType;
			this.bpjsPcareRegistrationsId = json.bpjsPcareRegistrationsId;
			this.bpjsPcareRegistrations = json.bpjsPcareRegistrations;
			this.patientVisitPatientPaymentInsuranceId = json.patientVisitPatientPaymentInsuranceId;
			this.patientVisitPatientPaymentInsurance = json.patientVisitPatientPaymentInsurance;
			this.patientVisitPatientPaymentOthersId = json.patientVisitPatientPaymentOthersId;
			this.patientVisitPatientPaymentOthers = json.patientVisitPatientPaymentOthers;
			this.patientVisitPaymentSelfPayingId = json.patientVisitPaymentSelfPayingId;
			this.patientVisitPaymentSelfPaying = json.patientVisitPaymentSelfPaying;
			this.patientId = json.patientId;
			this.patient = json.patient;
			this.bpjsVisitDatasIds = json.bpjsVisitDatasIds;
			this.bpjsVisitDatas = json.bpjsVisitDatas;
			this.bpjsPcarePendaftaransIds = json.bpjsPcarePendaftaransIds;
			this.bpjsPcarePendaftarans = json.bpjsPcarePendaftarans;
			this.invoicesIds = json.invoicesIds;
			this.invoices = json.invoices;
			this.registrationsIds = json.registrationsIds;
			this.registrations = json.registrations;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			visitNumber: this.visitNumber,
			registrationType: this.registrationType,
			visitDate: this.visitDate,
			registrationLocation: this.registrationLocation,
			patientPaymentType: this.patientPaymentType,
			visitType: this.visitType,
			bpjsPcareRegistrationsId: this.bpjsPcareRegistrationsId,
			patientVisitPatientPaymentInsuranceId: this.patientVisitPatientPaymentInsuranceId,
			patientVisitPatientPaymentOthersId: this.patientVisitPatientPaymentOthersId,
			patientVisitPaymentSelfPayingId: this.patientVisitPaymentSelfPayingId,
			patientId: this.patientId,
			bpjsVisitDatasIds: this.bpjsVisitDatasIds,
			bpjsPcarePendaftaransIds: this.bpjsPcarePendaftaransIds,
			invoicesIds: this.invoicesIds,
			registrationsIds: this.registrationsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientVisitModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientVisitModel {
		let newModelJson = this.toJSON();

		if (updates.visitNumber) {
			newModelJson.visitNumber = updates.visitNumber;
		}

		if (updates.registrationType) {
			newModelJson.registrationType = updates.registrationType;
		}

		if (updates.visitDate) {
			newModelJson.visitDate = updates.visitDate;
		}

		if (updates.registrationLocation) {
			newModelJson.registrationLocation = updates.registrationLocation;
		}

		if (updates.patientPaymentType) {
			newModelJson.patientPaymentType = updates.patientPaymentType;
		}

		if (updates.visitType) {
			newModelJson.visitType = updates.visitType;
		}

		if (updates.bpjsPcareRegistrationsId) {
			newModelJson.bpjsPcareRegistrationsId = updates.bpjsPcareRegistrationsId;
		}

		if (updates.patientVisitPatientPaymentInsuranceId) {
			newModelJson.patientVisitPatientPaymentInsuranceId = updates.patientVisitPatientPaymentInsuranceId;
		}

		if (updates.patientVisitPatientPaymentOthersId) {
			newModelJson.patientVisitPatientPaymentOthersId = updates.patientVisitPatientPaymentOthersId;
		}

		if (updates.patientVisitPaymentSelfPayingId) {
			newModelJson.patientVisitPaymentSelfPayingId = updates.patientVisitPaymentSelfPayingId;
		}

		if (updates.patientId) {
			newModelJson.patientId = updates.patientId;
		}

		if (updates.bpjsVisitDatasIds) {
			newModelJson.bpjsVisitDatasIds = updates.bpjsVisitDatasIds;
		}

		if (updates.bpjsPcarePendaftaransIds) {
			newModelJson.bpjsPcarePendaftaransIds = updates.bpjsPcarePendaftaransIds;
		}

		if (updates.invoicesIds) {
			newModelJson.invoicesIds = updates.invoicesIds;
		}

		if (updates.registrationsIds) {
			newModelJson.registrationsIds = updates.registrationsIds;
		}

		return new PatientVisitModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientVisitModel)) {
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
			'bpjsPcareRegistrationsId',
			'bpjsPcareRegistrations',
			'patientVisitPatientPaymentInsuranceId',
			'patientVisitPatientPaymentInsurance',
			'patientVisitPatientPaymentOthersId',
			'patientVisitPatientPaymentOthers',
			'patientVisitPaymentSelfPayingId',
			'patientVisitPaymentSelfPaying',
			'patientId',
			'patient',
			'bpjsVisitDatasIds',
			'bpjsVisitDatas',
			'bpjsPcarePendaftaransIds',
			'bpjsPcarePendaftarans',
			'invoicesIds',
			'invoices',
			'registrationsIds',
			'registrations',
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
		if (!this.bpjsPcareRegistrations) {
			this.bpjsPcareRegistrationsId = null;
		} else {
			this.bpjsPcareRegistrationsId = this.bpjsPcareRegistrations.id;
		}

		if (!this.patientVisitPatientPaymentInsurance) {
			this.patientVisitPatientPaymentInsuranceId = null;
		} else {
			this.patientVisitPatientPaymentInsuranceId = this.patientVisitPatientPaymentInsurance.id;
		}

		if (!this.patientVisitPatientPaymentOthers) {
			this.patientVisitPatientPaymentOthersId = null;
		} else {
			this.patientVisitPatientPaymentOthersId = this.patientVisitPatientPaymentOthers.id;
		}

		if (!this.patientVisitPaymentSelfPaying) {
			this.patientVisitPaymentSelfPayingId = null;
		} else {
			this.patientVisitPaymentSelfPayingId = this.patientVisitPaymentSelfPaying.id;
		}

		if (!this.patient) {
			this.patientId = null;
		} else {
			this.patientId = this.patient.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
