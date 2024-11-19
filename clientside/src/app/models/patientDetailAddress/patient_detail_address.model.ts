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
export class PatientDetailAddressModel extends AbstractModel {
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
		'country',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PatientDetailAddressModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientDetailAddressModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Country, get the Code from Reference Data where Type=COUNTRY. (Max Length: 20 chars).
	 */
	country: string;

	/**
	 * State in a country, get the Code from Reference Data where Type=STATE. (Max Length: 20 chars).
	 */
	state: string;

	/**
	 * Regency in a country and under State, get the Code from Reference Data where Type=REGENCY. (Max Length: 20 chars).
	 */
	regency: string;

	/**
	 * District under Regency, get the Code from Reference Data where Type=DISTRICT. (Max Length: 20 chars).
	 */
	district: string;

	/**
	 * Village information, get the Code from Reference Data where Type=VILLAGE. (Max Length: 20 chars).
	 */
	village: string;

	/**
	 * Post Code of patient address (Max Length: 20 chars).
	 */
	postCode: string;

	/**
	 * RT No  (Max Length: 20 chars).
	 */
	rt: string;

	/**
	 * RW No  (Max Length: 20 chars).
	 */
	rw: string;

	patientGeneralInformationId: string;

	patientGeneralInformation: PatientGeneralInfoModel;

	modelPropGroups: { [s: string]: Group } = PatientDetailAddressModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'country',
				// % protected region % [Set displayName for Country here] off begin
				displayName: 'Country',
				// % protected region % [Set displayName for Country here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Country here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Country here] end
				// % protected region % [Set isSensitive for Country here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Country here] end
				// % protected region % [Set readonly for Country here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Country here] end
				validators: [
					// % protected region % [Add other validators for Country here] off begin
					// % protected region % [Add other validators for Country here] end
				],
				// % protected region % [Add any additional model attribute properties for Country here] off begin
				// % protected region % [Add any additional model attribute properties for Country here] end
			},
			{
				name: 'state',
				// % protected region % [Set displayName for State here] off begin
				displayName: 'State',
				// % protected region % [Set displayName for State here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for State here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for State here] end
				// % protected region % [Set isSensitive for State here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for State here] end
				// % protected region % [Set readonly for State here] off begin
				readOnly: false,
				// % protected region % [Set readonly for State here] end
				validators: [
					// % protected region % [Add other validators for State here] off begin
					// % protected region % [Add other validators for State here] end
				],
				// % protected region % [Add any additional model attribute properties for State here] off begin
				// % protected region % [Add any additional model attribute properties for State here] end
			},
			{
				name: 'regency',
				// % protected region % [Set displayName for Regency here] off begin
				displayName: 'Regency',
				// % protected region % [Set displayName for Regency here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Regency here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Regency here] end
				// % protected region % [Set isSensitive for Regency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Regency here] end
				// % protected region % [Set readonly for Regency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Regency here] end
				validators: [
					// % protected region % [Add other validators for Regency here] off begin
					// % protected region % [Add other validators for Regency here] end
				],
				// % protected region % [Add any additional model attribute properties for Regency here] off begin
				// % protected region % [Add any additional model attribute properties for Regency here] end
			},
			{
				name: 'district',
				// % protected region % [Set displayName for District here] off begin
				displayName: 'District',
				// % protected region % [Set displayName for District here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for District here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for District here] end
				// % protected region % [Set isSensitive for District here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for District here] end
				// % protected region % [Set readonly for District here] off begin
				readOnly: false,
				// % protected region % [Set readonly for District here] end
				validators: [
					// % protected region % [Add other validators for District here] off begin
					// % protected region % [Add other validators for District here] end
				],
				// % protected region % [Add any additional model attribute properties for District here] off begin
				// % protected region % [Add any additional model attribute properties for District here] end
			},
			{
				name: 'village',
				// % protected region % [Set displayName for Village here] off begin
				displayName: 'Village',
				// % protected region % [Set displayName for Village here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Village here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Village here] end
				// % protected region % [Set isSensitive for Village here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Village here] end
				// % protected region % [Set readonly for Village here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Village here] end
				validators: [
					// % protected region % [Add other validators for Village here] off begin
					// % protected region % [Add other validators for Village here] end
				],
				// % protected region % [Add any additional model attribute properties for Village here] off begin
				// % protected region % [Add any additional model attribute properties for Village here] end
			},
			{
				name: 'postCode',
				// % protected region % [Set displayName for Post Code here] off begin
				displayName: 'Post Code',
				// % protected region % [Set displayName for Post Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Post Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Post Code here] end
				// % protected region % [Set isSensitive for Post Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Post Code here] end
				// % protected region % [Set readonly for Post Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Post Code here] end
				validators: [
					// % protected region % [Add other validators for Post Code here] off begin
					// % protected region % [Add other validators for Post Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Post Code here] off begin
				// % protected region % [Add any additional model attribute properties for Post Code here] end
			},
			{
				name: 'rt',
				// % protected region % [Set displayName for RT here] off begin
				displayName: 'RT',
				// % protected region % [Set displayName for RT here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for RT here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for RT here] end
				// % protected region % [Set isSensitive for RT here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for RT here] end
				// % protected region % [Set readonly for RT here] off begin
				readOnly: false,
				// % protected region % [Set readonly for RT here] end
				validators: [
					// % protected region % [Add other validators for RT here] off begin
					// % protected region % [Add other validators for RT here] end
				],
				// % protected region % [Add any additional model attribute properties for RT here] off begin
				// % protected region % [Add any additional model attribute properties for RT here] end
			},
			{
				name: 'rw',
				// % protected region % [Set displayName for RW here] off begin
				displayName: 'RW',
				// % protected region % [Set displayName for RW here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for RW here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for RW here] end
				// % protected region % [Set isSensitive for RW here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for RW here] end
				// % protected region % [Set readonly for RW here] off begin
				readOnly: false,
				// % protected region % [Set readonly for RW here] end
				validators: [
					// % protected region % [Add other validators for RW here] off begin
					// % protected region % [Add other validators for RW here] end
				],
				// % protected region % [Add any additional model attribute properties for RW here] off begin
				// % protected region % [Add any additional model attribute properties for RW here] end
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
	static deepParse(data: string | { [K in keyof PatientDetailAddressModel]?: PatientDetailAddressModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientDetailAddressModel(data);
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
	 * `let patientDetailAddressModel = new PatientDetailAddressModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientDetailAddressModel,
	 *    it is expected as a JSON string or as a nullable PatientDetailAddressModel.
	 */
	constructor(data?: string | Partial<PatientDetailAddressModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientDetailAddressModel>
				: data;

			this.country = json.country;
			this.state = json.state;
			this.regency = json.regency;
			this.district = json.district;
			this.village = json.village;
			this.postCode = json.postCode;
			this.rt = json.rt;
			this.rw = json.rw;
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
			country: this.country,
			state: this.state,
			regency: this.regency,
			district: this.district,
			village: this.village,
			postCode: this.postCode,
			rt: this.rt,
			rw: this.rw,
			patientGeneralInformationId: this.patientGeneralInformationId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientDetailAddressModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientDetailAddressModel {
		let newModelJson = this.toJSON();

		if (updates.country) {
			newModelJson.country = updates.country;
		}

		if (updates.state) {
			newModelJson.state = updates.state;
		}

		if (updates.regency) {
			newModelJson.regency = updates.regency;
		}

		if (updates.district) {
			newModelJson.district = updates.district;
		}

		if (updates.village) {
			newModelJson.village = updates.village;
		}

		if (updates.postCode) {
			newModelJson.postCode = updates.postCode;
		}

		if (updates.rt) {
			newModelJson.rt = updates.rt;
		}

		if (updates.rw) {
			newModelJson.rw = updates.rw;
		}

		if (updates.patientGeneralInformationId) {
			newModelJson.patientGeneralInformationId = updates.patientGeneralInformationId;
		}

		return new PatientDetailAddressModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientDetailAddressModel)) {
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
