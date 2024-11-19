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
import {BloodTypeEnum, bloodTypeEnumArray} from '../../enums/blood-type.enum';
import {RhesusEnum, rhesusEnumArray} from '../../enums/rhesus.enum';
import {PatientGeneralInfoModel} from '../patientGeneralInfo/patient_general_info.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PatientPersonalInfoModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'otherIDNumber',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'religion',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PatientPersonalInfoModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientPersonalInfoModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Patient Religion, get the Code from Reference Data where Type=RELIGION. (Max Length: 20).
	 */
	religion: string;

	/**
	 * Data nationality, get the Code from Reference Data where Type=NATIONALITY. (Max Length: 20).
	 */
	nationality: string;

	/**
	 * Ethnicity of patient, get the Code from Reference Data where Type=ETHNICITY. (Max Length: 20).
	 */
	ethnicity: string;

	/**
	 * Legal ID Number (KTP in Indonesia). (Max Length: 50).
	 */
	idNumber: string;

	/**
	 * Occupation of patient,  get the Code from Reference Data where Type=PATIENT_OCCUP. (Max Length: 20).
	 */
	occupation: string;

	/**
	 * An indicator if this is an external patient or not..
	 */
	externalPatient: boolean = false;

	/**
	 * Indicator whether patient is already dead.
	 */
	isDead: boolean = false;

	/**
	 * This is to put notes on the patient behavior like mad etc. Refer to Assessment entity. (Max Length: 500).
	 */
	externalNotes: string;

	/**
	 * Usually to put ' Nomor KK ' for BPJS purpose.
	 */
	otherIDNumber: string;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=5, example=Sally}.
	 */
	bloodType: BloodTypeEnum;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=6, example=Sally}.
	 */
	rhesus: RhesusEnum;

	patientGeneralInformationId: string;

	patientGeneralInformation: PatientGeneralInfoModel;

	modelPropGroups: { [s: string]: Group } = PatientPersonalInfoModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'religion',
				// % protected region % [Set displayName for Religion here] off begin
				displayName: 'Religion',
				// % protected region % [Set displayName for Religion here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Religion here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Religion here] end
				// % protected region % [Set isSensitive for Religion here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Religion here] end
				// % protected region % [Set readonly for Religion here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Religion here] end
				validators: [
					// % protected region % [Add other validators for Religion here] off begin
					// % protected region % [Add other validators for Religion here] end
				],
				// % protected region % [Add any additional model attribute properties for Religion here] off begin
				// % protected region % [Add any additional model attribute properties for Religion here] end
			},
			{
				name: 'nationality',
				// % protected region % [Set displayName for Nationality here] off begin
				displayName: 'Nationality',
				// % protected region % [Set displayName for Nationality here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nationality here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nationality here] end
				// % protected region % [Set isSensitive for Nationality here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nationality here] end
				// % protected region % [Set readonly for Nationality here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nationality here] end
				validators: [
					// % protected region % [Add other validators for Nationality here] off begin
					// % protected region % [Add other validators for Nationality here] end
				],
				// % protected region % [Add any additional model attribute properties for Nationality here] off begin
				// % protected region % [Add any additional model attribute properties for Nationality here] end
			},
			{
				name: 'ethnicity',
				// % protected region % [Set displayName for Ethnicity here] off begin
				displayName: 'Ethnicity',
				// % protected region % [Set displayName for Ethnicity here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ethnicity here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ethnicity here] end
				// % protected region % [Set isSensitive for Ethnicity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ethnicity here] end
				// % protected region % [Set readonly for Ethnicity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ethnicity here] end
				validators: [
					// % protected region % [Add other validators for Ethnicity here] off begin
					// % protected region % [Add other validators for Ethnicity here] end
				],
				// % protected region % [Add any additional model attribute properties for Ethnicity here] off begin
				// % protected region % [Add any additional model attribute properties for Ethnicity here] end
			},
			{
				name: 'bloodType',
				// % protected region % [Set displayName for Blood Type here] off begin
				displayName: 'Blood Type',
				// % protected region % [Set displayName for Blood Type here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: bloodTypeEnumArray,
				// % protected region % [Set display element type for Blood Type here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Blood Type here] end
				// % protected region % [Set isSensitive for Blood Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Blood Type here] end
				// % protected region % [Set readonly for Blood Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Blood Type here] end
				validators: [
					// % protected region % [Add other validators for Blood Type here] off begin
					// % protected region % [Add other validators for Blood Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Blood Type here] off begin
				// % protected region % [Add any additional model attribute properties for Blood Type here] end
			},
			{
				name: 'rhesus',
				// % protected region % [Set displayName for Rhesus here] off begin
				displayName: 'Rhesus',
				// % protected region % [Set displayName for Rhesus here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: rhesusEnumArray,
				// % protected region % [Set display element type for Rhesus here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Rhesus here] end
				// % protected region % [Set isSensitive for Rhesus here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Rhesus here] end
				// % protected region % [Set readonly for Rhesus here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Rhesus here] end
				validators: [
					// % protected region % [Add other validators for Rhesus here] off begin
					// % protected region % [Add other validators for Rhesus here] end
				],
				// % protected region % [Add any additional model attribute properties for Rhesus here] off begin
				// % protected region % [Add any additional model attribute properties for Rhesus here] end
			},
			{
				name: 'idNumber',
				// % protected region % [Set displayName for ID Number here] off begin
				displayName: 'ID Number',
				// % protected region % [Set displayName for ID Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ID Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ID Number here] end
				// % protected region % [Set isSensitive for ID Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ID Number here] end
				// % protected region % [Set readonly for ID Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ID Number here] end
				validators: [
					// % protected region % [Add other validators for ID Number here] off begin
					// % protected region % [Add other validators for ID Number here] end
				],
				// % protected region % [Add any additional model attribute properties for ID Number here] off begin
				// % protected region % [Add any additional model attribute properties for ID Number here] end
			},
			{
				name: 'occupation',
				// % protected region % [Set displayName for Occupation here] off begin
				displayName: 'Occupation',
				// % protected region % [Set displayName for Occupation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Occupation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Occupation here] end
				// % protected region % [Set isSensitive for Occupation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Occupation here] end
				// % protected region % [Set readonly for Occupation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Occupation here] end
				validators: [
					// % protected region % [Add other validators for Occupation here] off begin
					// % protected region % [Add other validators for Occupation here] end
				],
				// % protected region % [Add any additional model attribute properties for Occupation here] off begin
				// % protected region % [Add any additional model attribute properties for Occupation here] end
			},
			{
				name: 'externalPatient',
				// % protected region % [Set displayName for External Patient here] off begin
				displayName: 'External Patient',
				// % protected region % [Set displayName for External Patient here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for External Patient here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for External Patient here] end
				// % protected region % [Set isSensitive for External Patient here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for External Patient here] end
				// % protected region % [Set readonly for External Patient here] off begin
				readOnly: false,
				// % protected region % [Set readonly for External Patient here] end
				validators: [
					// % protected region % [Add other validators for External Patient here] off begin
					// % protected region % [Add other validators for External Patient here] end
				],
				// % protected region % [Add any additional model attribute properties for External Patient here] off begin
				// % protected region % [Add any additional model attribute properties for External Patient here] end
			},
			{
				name: 'isDead',
				// % protected region % [Set displayName for Is Dead here] off begin
				displayName: 'Is Dead',
				// % protected region % [Set displayName for Is Dead here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Dead here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Dead here] end
				// % protected region % [Set isSensitive for Is Dead here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Dead here] end
				// % protected region % [Set readonly for Is Dead here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Dead here] end
				validators: [
					// % protected region % [Add other validators for Is Dead here] off begin
					// % protected region % [Add other validators for Is Dead here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Dead here] off begin
				// % protected region % [Add any additional model attribute properties for Is Dead here] end
			},
			{
				name: 'externalNotes',
				// % protected region % [Set displayName for External Notes here] off begin
				displayName: 'External Notes',
				// % protected region % [Set displayName for External Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for External Notes here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for External Notes here] end
				// % protected region % [Set isSensitive for External Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for External Notes here] end
				// % protected region % [Set readonly for External Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for External Notes here] end
				validators: [
					// % protected region % [Add other validators for External Notes here] off begin
					// % protected region % [Add other validators for External Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for External Notes here] off begin
				// % protected region % [Add any additional model attribute properties for External Notes here] end
			},
			{
				name: 'otherIDNumber',
				// % protected region % [Set displayName for Other ID Number here] off begin
				displayName: 'Other ID Number',
				// % protected region % [Set displayName for Other ID Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Other ID Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Other ID Number here] end
				// % protected region % [Set isSensitive for Other ID Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other ID Number here] end
				// % protected region % [Set readonly for Other ID Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other ID Number here] end
				validators: [
					// % protected region % [Add other validators for Other ID Number here] off begin
					// % protected region % [Add other validators for Other ID Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Other ID Number here] off begin
				// % protected region % [Add any additional model attribute properties for Other ID Number here] end
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
				id: 'patientGeneralInformation',
				type: ModelRelationType.ONE,
				name: 'patientGeneralInformationId',
				// % protected region % [Customise your label for Patient General Information here] off begin
				label: 'Patient General Information',
				// % protected region % [Customise your label for Patient General Information here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient General Information here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient General Information here] end
				validators: [
					// % protected region % [Add other validators for Patient General Information here] off begin
					// % protected region % [Add other validators for Patient General Information here] end
				],
				// % protected region % [Add any additional field for relation Patient General Information here] off begin
				// % protected region % [Add any additional field for relation Patient General Information here] end
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
				case 'otherIDNumber':
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
	static deepParse(data: string | { [K in keyof PatientPersonalInfoModel]?: PatientPersonalInfoModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientPersonalInfoModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.patientGeneralInformation) {
			currentModel.patientGeneralInformationId = json.patientGeneralInformation.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInformation));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let patientPersonalInfoModel = new PatientPersonalInfoModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientPersonalInfoModel,
	 *    it is expected as a JSON string or as a nullable PatientPersonalInfoModel.
	 */
	constructor(data?: string | Partial<PatientPersonalInfoModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientPersonalInfoModel>
				: data;

			this.religion = json.religion;
			this.nationality = json.nationality;
			this.ethnicity = json.ethnicity;
			this.bloodType = json.bloodType;
			this.rhesus = json.rhesus;
			this.idNumber = json.idNumber;
			this.occupation = json.occupation;
			this.externalPatient = json.externalPatient;
			this.isDead = json.isDead;
			this.externalNotes = json.externalNotes;
			this.otherIDNumber = json.otherIDNumber;
			this.bloodType = json.bloodType;
			this.rhesus = json.rhesus;
			this.patientGeneralInformationId = json.patientGeneralInformationId;
			this.patientGeneralInformation = json.patientGeneralInformation;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			religion: this.religion,
			nationality: this.nationality,
			ethnicity: this.ethnicity,
			bloodType: this.bloodType,
			rhesus: this.rhesus,
			idNumber: this.idNumber,
			occupation: this.occupation,
			externalPatient: this.externalPatient,
			isDead: this.isDead,
			externalNotes: this.externalNotes,
			otherIDNumber: this.otherIDNumber,
			patientGeneralInformationId: this.patientGeneralInformationId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientPersonalInfoModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientPersonalInfoModel {
		let newModelJson = this.toJSON();

		if (updates.religion) {
			newModelJson.religion = updates.religion;
		}

		if (updates.nationality) {
			newModelJson.nationality = updates.nationality;
		}

		if (updates.ethnicity) {
			newModelJson.ethnicity = updates.ethnicity;
		}

		if (updates.bloodType) {
			newModelJson.bloodType = updates.bloodType;
		}

		if (updates.rhesus) {
			newModelJson.rhesus = updates.rhesus;
		}

		if (updates.idNumber) {
			newModelJson.idNumber = updates.idNumber;
		}

		if (updates.occupation) {
			newModelJson.occupation = updates.occupation;
		}

		if (updates.externalPatient) {
			newModelJson.externalPatient = updates.externalPatient;
		}

		if (updates.isDead) {
			newModelJson.isDead = updates.isDead;
		}

		if (updates.externalNotes) {
			newModelJson.externalNotes = updates.externalNotes;
		}

		if (updates.otherIDNumber) {
			newModelJson.otherIDNumber = updates.otherIDNumber;
		}

		if (updates.bloodType) {
			newModelJson.bloodType = updates.bloodType;
		}

		if (updates.rhesus) {
			newModelJson.rhesus = updates.rhesus;
		}

		if (updates.patientGeneralInformationId) {
			newModelJson.patientGeneralInformationId = updates.patientGeneralInformationId;
		}

		return new PatientPersonalInfoModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientPersonalInfoModel)) {
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
			'patientGeneralInformationId',
			'patientGeneralInformation',
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
		if (!this.patientGeneralInformation) {
			this.patientGeneralInformationId = null;
		} else {
			this.patientGeneralInformationId = this.patientGeneralInformation.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
