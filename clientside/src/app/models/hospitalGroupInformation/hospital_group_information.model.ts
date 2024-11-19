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
import {HospitalBranchInformationModel} from '../hospitalBranchInformation/hospital_branch_information.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class HospitalGroupInformationModel extends AbstractModel {
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
		'hospitalGroupCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'HospitalGroupInformationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return HospitalGroupInformationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Code (Max Length: 50).
	 */
	hospitalGroupCode: string;

	/**
	 * Group Name (Max Length: 250) .
	 */
	hospitalGroupName: string;

	/**
	 * Corporation Name (Max Length: 250).
	 */
	hospitalGroupCorporationName: string;

	/**
	 * director name (Max Length: 250).
	 */
	hospitalGroupDirector: string;

	/**
	 * License No (Max Length 250).
	 */
	operationalLicenseNo: string;

	/**
	 * Type/Status corporation, get from Reference Type: HOSP_GRP_TYPE (Max Length: 20).
	 */
	hospitalGroupCorporationStatus: string;

	/**
	 * Address (Max Length: 500).
	 */
	address: string;

	/**
	 * Region or City (Max Length: 250).
	 */
	city: string;

	/**
	 * Postcode (Max Length: 50).
	 */
	postcode: string;

	/**
	 * Phone Number (Max Length: 50).
	 */
	phoneNumber: string;

	/**
	 * Fax Number (Max Length: 50).
	 */
	fax: string;

	/**
	 * Email (Max Length: 250).
	 */
	email: string;

	/**
	 * Website (Max Length: 250).
	 */
	website: string;

	/**
	 * Person Name (Max Length: 250).
	 */
	contactPerson: string;

	/**
	 * Phone Number (Max Length: 50).
	 */
	contactPersonPhoneNumber: string;

	/**
	 * Email (Max Length: 250).
	 */
	contactPersonEmail: string;

	hospitalBranchInformationsIds: string[] = [];

	hospitalBranchInformations: HospitalBranchInformationModel[];

	modelPropGroups: { [s: string]: Group } = HospitalGroupInformationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'hospitalGroupCode',
				// % protected region % [Set displayName for Hospital Group Code here] off begin
				displayName: 'Hospital Group Code',
				// % protected region % [Set displayName for Hospital Group Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Group Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Group Code here] end
				// % protected region % [Set isSensitive for Hospital Group Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Group Code here] end
				// % protected region % [Set readonly for Hospital Group Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Group Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Hospital Group Code here] off begin
					// % protected region % [Add other validators for Hospital Group Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Group Code here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Group Code here] end
			},
			{
				name: 'hospitalGroupName',
				// % protected region % [Set displayName for Hospital Group Name here] off begin
				displayName: 'Hospital Group Name',
				// % protected region % [Set displayName for Hospital Group Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Group Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Group Name here] end
				// % protected region % [Set isSensitive for Hospital Group Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Group Name here] end
				// % protected region % [Set readonly for Hospital Group Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Group Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Hospital Group Name here] off begin
					// % protected region % [Add other validators for Hospital Group Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Group Name here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Group Name here] end
			},
			{
				name: 'hospitalGroupCorporationName',
				// % protected region % [Set displayName for Hospital Group Corporation Name here] off begin
				displayName: 'Hospital Group Corporation Name',
				// % protected region % [Set displayName for Hospital Group Corporation Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Group Corporation Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Group Corporation Name here] end
				// % protected region % [Set isSensitive for Hospital Group Corporation Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Group Corporation Name here] end
				// % protected region % [Set readonly for Hospital Group Corporation Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Group Corporation Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Hospital Group Corporation Name here] off begin
					// % protected region % [Add other validators for Hospital Group Corporation Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Group Corporation Name here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Group Corporation Name here] end
			},
			{
				name: 'hospitalGroupDirector',
				// % protected region % [Set displayName for Hospital Group Director here] off begin
				displayName: 'Hospital Group Director',
				// % protected region % [Set displayName for Hospital Group Director here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Group Director here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Group Director here] end
				// % protected region % [Set isSensitive for Hospital Group Director here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Group Director here] end
				// % protected region % [Set readonly for Hospital Group Director here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Group Director here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Hospital Group Director here] off begin
					// % protected region % [Add other validators for Hospital Group Director here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Group Director here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Group Director here] end
			},
			{
				name: 'operationalLicenseNo',
				// % protected region % [Set displayName for Operational License No here] off begin
				displayName: 'Operational License No',
				// % protected region % [Set displayName for Operational License No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Operational License No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Operational License No here] end
				// % protected region % [Set isSensitive for Operational License No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Operational License No here] end
				// % protected region % [Set readonly for Operational License No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Operational License No here] end
				validators: [
					// % protected region % [Add other validators for Operational License No here] off begin
					// % protected region % [Add other validators for Operational License No here] end
				],
				// % protected region % [Add any additional model attribute properties for Operational License No here] off begin
				// % protected region % [Add any additional model attribute properties for Operational License No here] end
			},
			{
				name: 'hospitalGroupCorporationStatus',
				// % protected region % [Set displayName for Hospital Group Corporation Status here] off begin
				displayName: 'Hospital Group Corporation Status',
				// % protected region % [Set displayName for Hospital Group Corporation Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Group Corporation Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Group Corporation Status here] end
				// % protected region % [Set isSensitive for Hospital Group Corporation Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Group Corporation Status here] end
				// % protected region % [Set readonly for Hospital Group Corporation Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Group Corporation Status here] end
				validators: [
					// % protected region % [Add other validators for Hospital Group Corporation Status here] off begin
					// % protected region % [Add other validators for Hospital Group Corporation Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Group Corporation Status here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Group Corporation Status here] end
			},
			{
				name: 'address',
				// % protected region % [Set displayName for Address here] off begin
				displayName: 'Address',
				// % protected region % [Set displayName for Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Address here] end
				// % protected region % [Set isSensitive for Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Address here] end
				// % protected region % [Set readonly for Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Address here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Address here] off begin
					// % protected region % [Add other validators for Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Address here] off begin
				// % protected region % [Add any additional model attribute properties for Address here] end
			},
			{
				name: 'city',
				// % protected region % [Set displayName for City here] off begin
				displayName: 'City',
				// % protected region % [Set displayName for City here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for City here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for City here] end
				// % protected region % [Set isSensitive for City here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for City here] end
				// % protected region % [Set readonly for City here] off begin
				readOnly: false,
				// % protected region % [Set readonly for City here] end
				validators: [
					// % protected region % [Add other validators for City here] off begin
					// % protected region % [Add other validators for City here] end
				],
				// % protected region % [Add any additional model attribute properties for City here] off begin
				// % protected region % [Add any additional model attribute properties for City here] end
			},
			{
				name: 'postcode',
				// % protected region % [Set displayName for Postcode here] off begin
				displayName: 'Postcode',
				// % protected region % [Set displayName for Postcode here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Postcode here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Postcode here] end
				// % protected region % [Set isSensitive for Postcode here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Postcode here] end
				// % protected region % [Set readonly for Postcode here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Postcode here] end
				validators: [
					// % protected region % [Add other validators for Postcode here] off begin
					// % protected region % [Add other validators for Postcode here] end
				],
				// % protected region % [Add any additional model attribute properties for Postcode here] off begin
				// % protected region % [Add any additional model attribute properties for Postcode here] end
			},
			{
				name: 'phoneNumber',
				// % protected region % [Set displayName for Phone Number here] off begin
				displayName: 'Phone Number',
				// % protected region % [Set displayName for Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Phone Number here] end
				// % protected region % [Set isSensitive for Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Phone Number here] end
				// % protected region % [Set readonly for Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Phone Number here] end
				validators: [
					// % protected region % [Add other validators for Phone Number here] off begin
					// % protected region % [Add other validators for Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Phone Number here] end
			},
			{
				name: 'fax',
				// % protected region % [Set displayName for Fax here] off begin
				displayName: 'Fax',
				// % protected region % [Set displayName for Fax here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Fax here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Fax here] end
				// % protected region % [Set isSensitive for Fax here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fax here] end
				// % protected region % [Set readonly for Fax here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fax here] end
				validators: [
					// % protected region % [Add other validators for Fax here] off begin
					// % protected region % [Add other validators for Fax here] end
				],
				// % protected region % [Add any additional model attribute properties for Fax here] off begin
				// % protected region % [Add any additional model attribute properties for Fax here] end
			},
			{
				name: 'email',
				// % protected region % [Set displayName for Email here] off begin
				displayName: 'Email',
				// % protected region % [Set displayName for Email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Email here] end
				// % protected region % [Set isSensitive for Email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Email here] end
				// % protected region % [Set readonly for Email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Email here] end
				validators: [
					// % protected region % [Add other validators for Email here] off begin
					// % protected region % [Add other validators for Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Email here] off begin
				// % protected region % [Add any additional model attribute properties for Email here] end
			},
			{
				name: 'website',
				// % protected region % [Set displayName for Website here] off begin
				displayName: 'Website',
				// % protected region % [Set displayName for Website here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Website here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Website here] end
				// % protected region % [Set isSensitive for Website here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Website here] end
				// % protected region % [Set readonly for Website here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Website here] end
				validators: [
					// % protected region % [Add other validators for Website here] off begin
					// % protected region % [Add other validators for Website here] end
				],
				// % protected region % [Add any additional model attribute properties for Website here] off begin
				// % protected region % [Add any additional model attribute properties for Website here] end
			},
			{
				name: 'contactPerson',
				// % protected region % [Set displayName for Contact Person here] off begin
				displayName: 'Contact Person',
				// % protected region % [Set displayName for Contact Person here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Contact Person here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Contact Person here] end
				// % protected region % [Set isSensitive for Contact Person here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contact Person here] end
				// % protected region % [Set readonly for Contact Person here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contact Person here] end
				validators: [
					// % protected region % [Add other validators for Contact Person here] off begin
					// % protected region % [Add other validators for Contact Person here] end
				],
				// % protected region % [Add any additional model attribute properties for Contact Person here] off begin
				// % protected region % [Add any additional model attribute properties for Contact Person here] end
			},
			{
				name: 'contactPersonPhoneNumber',
				// % protected region % [Set displayName for Contact Person Phone Number here] off begin
				displayName: 'Contact Person Phone Number',
				// % protected region % [Set displayName for Contact Person Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Contact Person Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Contact Person Phone Number here] end
				// % protected region % [Set isSensitive for Contact Person Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contact Person Phone Number here] end
				// % protected region % [Set readonly for Contact Person Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contact Person Phone Number here] end
				validators: [
					// % protected region % [Add other validators for Contact Person Phone Number here] off begin
					// % protected region % [Add other validators for Contact Person Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Contact Person Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Contact Person Phone Number here] end
			},
			{
				name: 'contactPersonEmail',
				// % protected region % [Set displayName for Contact Person Email here] off begin
				displayName: 'Contact Person Email',
				// % protected region % [Set displayName for Contact Person Email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Contact Person Email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Contact Person Email here] end
				// % protected region % [Set isSensitive for Contact Person Email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contact Person Email here] end
				// % protected region % [Set readonly for Contact Person Email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contact Person Email here] end
				validators: [
					// % protected region % [Add other validators for Contact Person Email here] off begin
					// % protected region % [Add other validators for Contact Person Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Contact Person Email here] off begin
				// % protected region % [Add any additional model attribute properties for Contact Person Email here] end
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
				id: 'hospitalBranchInformations',
				type: ModelRelationType.MANY,
				name: 'hospitalBranchInformationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Hospital Branch Informations here] off begin
				label: 'Hospital Branch Informations',
				// % protected region % [Customise your 1-1 or 1-M label for Hospital Branch Informations here] end
				entityName: 'HospitalBranchInformationModel',
				// % protected region % [Customise your display name for Hospital Branch Informations here] off begin
				displayName: 'hospitalCode',
				// % protected region % [Customise your display name for Hospital Branch Informations here] end
				validators: [
					// % protected region % [Add other validators for Hospital Branch Informations here] off begin
					// % protected region % [Add other validators for Hospital Branch Informations here] end
				],
				// % protected region % [Add any additional field for relation Hospital Branch Informations here] off begin
				// % protected region % [Add any additional field for relation Hospital Branch Informations here] end
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
	static deepParse(data: string | { [K in keyof HospitalGroupInformationModel]?: HospitalGroupInformationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new HospitalGroupInformationModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.hospitalBranchInformations) {
			currentModel.hospitalBranchInformationsIds = json.hospitalBranchInformations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.hospitalBranchInformations.map(model => HospitalBranchInformationModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let hospitalGroupInformationModel = new HospitalGroupInformationModel(data);`
	 *
	 * @param data The input data to be initialised as the HospitalGroupInformationModel,
	 *    it is expected as a JSON string or as a nullable HospitalGroupInformationModel.
	 */
	constructor(data?: string | Partial<HospitalGroupInformationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<HospitalGroupInformationModel>
				: data;

			this.hospitalGroupCode = json.hospitalGroupCode;
			this.hospitalGroupName = json.hospitalGroupName;
			this.hospitalGroupCorporationName = json.hospitalGroupCorporationName;
			this.hospitalGroupDirector = json.hospitalGroupDirector;
			this.operationalLicenseNo = json.operationalLicenseNo;
			this.hospitalGroupCorporationStatus = json.hospitalGroupCorporationStatus;
			this.address = json.address;
			this.city = json.city;
			this.postcode = json.postcode;
			this.phoneNumber = json.phoneNumber;
			this.fax = json.fax;
			this.email = json.email;
			this.website = json.website;
			this.contactPerson = json.contactPerson;
			this.contactPersonPhoneNumber = json.contactPersonPhoneNumber;
			this.contactPersonEmail = json.contactPersonEmail;
			this.hospitalBranchInformationsIds = json.hospitalBranchInformationsIds;
			this.hospitalBranchInformations = json.hospitalBranchInformations;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			hospitalGroupCode: this.hospitalGroupCode,
			hospitalGroupName: this.hospitalGroupName,
			hospitalGroupCorporationName: this.hospitalGroupCorporationName,
			hospitalGroupDirector: this.hospitalGroupDirector,
			operationalLicenseNo: this.operationalLicenseNo,
			hospitalGroupCorporationStatus: this.hospitalGroupCorporationStatus,
			address: this.address,
			city: this.city,
			postcode: this.postcode,
			phoneNumber: this.phoneNumber,
			fax: this.fax,
			email: this.email,
			website: this.website,
			contactPerson: this.contactPerson,
			contactPersonPhoneNumber: this.contactPersonPhoneNumber,
			contactPersonEmail: this.contactPersonEmail,
			hospitalBranchInformationsIds: this.hospitalBranchInformationsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		HospitalGroupInformationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): HospitalGroupInformationModel {
		let newModelJson = this.toJSON();

		if (updates.hospitalGroupCode) {
			newModelJson.hospitalGroupCode = updates.hospitalGroupCode;
		}

		if (updates.hospitalGroupName) {
			newModelJson.hospitalGroupName = updates.hospitalGroupName;
		}

		if (updates.hospitalGroupCorporationName) {
			newModelJson.hospitalGroupCorporationName = updates.hospitalGroupCorporationName;
		}

		if (updates.hospitalGroupDirector) {
			newModelJson.hospitalGroupDirector = updates.hospitalGroupDirector;
		}

		if (updates.operationalLicenseNo) {
			newModelJson.operationalLicenseNo = updates.operationalLicenseNo;
		}

		if (updates.hospitalGroupCorporationStatus) {
			newModelJson.hospitalGroupCorporationStatus = updates.hospitalGroupCorporationStatus;
		}

		if (updates.address) {
			newModelJson.address = updates.address;
		}

		if (updates.city) {
			newModelJson.city = updates.city;
		}

		if (updates.postcode) {
			newModelJson.postcode = updates.postcode;
		}

		if (updates.phoneNumber) {
			newModelJson.phoneNumber = updates.phoneNumber;
		}

		if (updates.fax) {
			newModelJson.fax = updates.fax;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.website) {
			newModelJson.website = updates.website;
		}

		if (updates.contactPerson) {
			newModelJson.contactPerson = updates.contactPerson;
		}

		if (updates.contactPersonPhoneNumber) {
			newModelJson.contactPersonPhoneNumber = updates.contactPersonPhoneNumber;
		}

		if (updates.contactPersonEmail) {
			newModelJson.contactPersonEmail = updates.contactPersonEmail;
		}

		if (updates.hospitalBranchInformationsIds) {
			newModelJson.hospitalBranchInformationsIds = updates.hospitalBranchInformationsIds;
		}

		return new HospitalGroupInformationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof HospitalGroupInformationModel)) {
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
			'hospitalBranchInformationsIds',
			'hospitalBranchInformations',
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
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
