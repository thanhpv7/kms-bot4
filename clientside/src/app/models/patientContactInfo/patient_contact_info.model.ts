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
export class PatientContactInfoModel extends AbstractModel {
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
		'mobilePhoneNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PatientContactInfoModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientContactInfoModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Mobile Phone No (Max Length: 50).
	 */
	mobilePhoneNo: string;

	/**
	 * Office Phone No (Max Length: 50).
	 */
	officePhoneNo: string;

	/**
	 * Extension No (Max Length: 50).
	 */
	extensionNo: string;

	/**
	 * Email address with email format (Max Length: 50).
	 */
	emailAddress: string;

	/**
	 * Home Phone No (Max Length: 50).
	 */
	homePhoneNo: string;

	patientGeneralInformationId: string;

	patientGeneralInformation: PatientGeneralInfoModel;

	modelPropGroups: { [s: string]: Group } = PatientContactInfoModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'mobilePhoneNo',
				// % protected region % [Set displayName for Mobile Phone No here] off begin
				displayName: 'Mobile Phone No',
				// % protected region % [Set displayName for Mobile Phone No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Mobile Phone No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Mobile Phone No here] end
				// % protected region % [Set isSensitive for Mobile Phone No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Mobile Phone No here] end
				// % protected region % [Set readonly for Mobile Phone No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Mobile Phone No here] end
				validators: [
					// % protected region % [Add other validators for Mobile Phone No here] off begin
					// % protected region % [Add other validators for Mobile Phone No here] end
				],
				// % protected region % [Add any additional model attribute properties for Mobile Phone No here] off begin
				// % protected region % [Add any additional model attribute properties for Mobile Phone No here] end
			},
			{
				name: 'officePhoneNo',
				// % protected region % [Set displayName for Office Phone No here] off begin
				displayName: 'Office Phone No',
				// % protected region % [Set displayName for Office Phone No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Office Phone No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Office Phone No here] end
				// % protected region % [Set isSensitive for Office Phone No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Office Phone No here] end
				// % protected region % [Set readonly for Office Phone No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Office Phone No here] end
				validators: [
					// % protected region % [Add other validators for Office Phone No here] off begin
					// % protected region % [Add other validators for Office Phone No here] end
				],
				// % protected region % [Add any additional model attribute properties for Office Phone No here] off begin
				// % protected region % [Add any additional model attribute properties for Office Phone No here] end
			},
			{
				name: 'extensionNo',
				// % protected region % [Set displayName for Extension No here] off begin
				displayName: 'Extension No',
				// % protected region % [Set displayName for Extension No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Extension No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Extension No here] end
				// % protected region % [Set isSensitive for Extension No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Extension No here] end
				// % protected region % [Set readonly for Extension No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Extension No here] end
				validators: [
					// % protected region % [Add other validators for Extension No here] off begin
					// % protected region % [Add other validators for Extension No here] end
				],
				// % protected region % [Add any additional model attribute properties for Extension No here] off begin
				// % protected region % [Add any additional model attribute properties for Extension No here] end
			},
			{
				name: 'emailAddress',
				// % protected region % [Set displayName for Email Address here] off begin
				displayName: 'Email Address',
				// % protected region % [Set displayName for Email Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Email Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Email Address here] end
				// % protected region % [Set isSensitive for Email Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Email Address here] end
				// % protected region % [Set readonly for Email Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Email Address here] end
				validators: [
					// % protected region % [Add other validators for Email Address here] off begin
					// % protected region % [Add other validators for Email Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Email Address here] off begin
				// % protected region % [Add any additional model attribute properties for Email Address here] end
			},
			{
				name: 'homePhoneNo',
				// % protected region % [Set displayName for Home Phone No here] off begin
				displayName: 'Home Phone No',
				// % protected region % [Set displayName for Home Phone No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Home Phone No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Home Phone No here] end
				// % protected region % [Set isSensitive for Home Phone No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Home Phone No here] end
				// % protected region % [Set readonly for Home Phone No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Home Phone No here] end
				validators: [
					// % protected region % [Add other validators for Home Phone No here] off begin
					// % protected region % [Add other validators for Home Phone No here] end
				],
				// % protected region % [Add any additional model attribute properties for Home Phone No here] off begin
				// % protected region % [Add any additional model attribute properties for Home Phone No here] end
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
	static deepParse(data: string | { [K in keyof PatientContactInfoModel]?: PatientContactInfoModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientContactInfoModel(data);
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
	 * `let patientContactInfoModel = new PatientContactInfoModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientContactInfoModel,
	 *    it is expected as a JSON string or as a nullable PatientContactInfoModel.
	 */
	constructor(data?: string | Partial<PatientContactInfoModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientContactInfoModel>
				: data;

			this.mobilePhoneNo = json.mobilePhoneNo;
			this.officePhoneNo = json.officePhoneNo;
			this.extensionNo = json.extensionNo;
			this.emailAddress = json.emailAddress;
			this.homePhoneNo = json.homePhoneNo;
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
			mobilePhoneNo: this.mobilePhoneNo,
			officePhoneNo: this.officePhoneNo,
			extensionNo: this.extensionNo,
			emailAddress: this.emailAddress,
			homePhoneNo: this.homePhoneNo,
			patientGeneralInformationId: this.patientGeneralInformationId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientContactInfoModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientContactInfoModel {
		let newModelJson = this.toJSON();

		if (updates.mobilePhoneNo) {
			newModelJson.mobilePhoneNo = updates.mobilePhoneNo;
		}

		if (updates.officePhoneNo) {
			newModelJson.officePhoneNo = updates.officePhoneNo;
		}

		if (updates.extensionNo) {
			newModelJson.extensionNo = updates.extensionNo;
		}

		if (updates.emailAddress) {
			newModelJson.emailAddress = updates.emailAddress;
		}

		if (updates.homePhoneNo) {
			newModelJson.homePhoneNo = updates.homePhoneNo;
		}

		if (updates.patientGeneralInformationId) {
			newModelJson.patientGeneralInformationId = updates.patientGeneralInformationId;
		}

		return new PatientContactInfoModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientContactInfoModel)) {
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