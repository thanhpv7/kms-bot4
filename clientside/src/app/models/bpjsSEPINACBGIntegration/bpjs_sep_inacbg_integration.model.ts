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
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsSEPINACBGIntegrationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'sepNo',
		'patientID',
		'patientName',
		'gender',
		'bpjsCardNo',
		'treatmentClass',
		'referralNo',
		'dateOfBirth',
		'visitDate',
		'healthFacilityLevel',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'sepNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsSEPINACBGIntegrationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsSEPINACBGIntegrationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	sepNo: string;

	/**
	 * .
	 */
	patientID: string;

	/**
	 * .
	 */
	patientName: string;

	/**
	 * .
	 */
	gender: string;

	/**
	 * .
	 */
	bpjsCardNo: string;

	/**
	 * .
	 */
	treatmentClass: string;

	/**
	 * .
	 */
	referralNo: string;

	/**
	 * .
	 */
	dateOfBirth: string;

	/**
	 * .
	 */
	visitDate: string;

	/**
	 * .
	 */
	healthFacilityLevel: string;



	modelPropGroups: { [s: string]: Group } = BpjsSEPINACBGIntegrationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'sepNo',
				// % protected region % [Set displayName for SEP No here] off begin
				displayName: 'SEP No',
				// % protected region % [Set displayName for SEP No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SEP No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SEP No here] end
				// % protected region % [Set isSensitive for SEP No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SEP No here] end
				// % protected region % [Set readonly for SEP No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SEP No here] end
				validators: [
					// % protected region % [Add other validators for SEP No here] off begin
					// % protected region % [Add other validators for SEP No here] end
				],
				// % protected region % [Add any additional model attribute properties for SEP No here] off begin
				// % protected region % [Add any additional model attribute properties for SEP No here] end
			},
			{
				name: 'patientID',
				// % protected region % [Set displayName for Patient ID here] off begin
				displayName: 'Patient ID',
				// % protected region % [Set displayName for Patient ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient ID here] end
				// % protected region % [Set isSensitive for Patient ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient ID here] end
				// % protected region % [Set readonly for Patient ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient ID here] end
				validators: [
					// % protected region % [Add other validators for Patient ID here] off begin
					// % protected region % [Add other validators for Patient ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient ID here] off begin
				// % protected region % [Add any additional model attribute properties for Patient ID here] end
			},
			{
				name: 'patientName',
				// % protected region % [Set displayName for Patient Name here] off begin
				displayName: 'Patient Name',
				// % protected region % [Set displayName for Patient Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient Name here] end
				// % protected region % [Set isSensitive for Patient Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Name here] end
				// % protected region % [Set readonly for Patient Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Name here] end
				validators: [
					// % protected region % [Add other validators for Patient Name here] off begin
					// % protected region % [Add other validators for Patient Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Name here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Name here] end
			},
			{
				name: 'gender',
				// % protected region % [Set displayName for Gender here] off begin
				displayName: 'Gender',
				// % protected region % [Set displayName for Gender here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gender here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gender here] end
				// % protected region % [Set isSensitive for Gender here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gender here] end
				// % protected region % [Set readonly for Gender here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gender here] end
				validators: [
					// % protected region % [Add other validators for Gender here] off begin
					// % protected region % [Add other validators for Gender here] end
				],
				// % protected region % [Add any additional model attribute properties for Gender here] off begin
				// % protected region % [Add any additional model attribute properties for Gender here] end
			},
			{
				name: 'bpjsCardNo',
				// % protected region % [Set displayName for BPJS Card No here] off begin
				displayName: 'BPJS Card No',
				// % protected region % [Set displayName for BPJS Card No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BPJS Card No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BPJS Card No here] end
				// % protected region % [Set isSensitive for BPJS Card No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BPJS Card No here] end
				// % protected region % [Set readonly for BPJS Card No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BPJS Card No here] end
				validators: [
					// % protected region % [Add other validators for BPJS Card No here] off begin
					// % protected region % [Add other validators for BPJS Card No here] end
				],
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] off begin
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] end
			},
			{
				name: 'treatmentClass',
				// % protected region % [Set displayName for Treatment Class here] off begin
				displayName: 'Treatment Class',
				// % protected region % [Set displayName for Treatment Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Class here] end
				// % protected region % [Set isSensitive for Treatment Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Class here] end
				// % protected region % [Set readonly for Treatment Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Class here] end
				validators: [
					// % protected region % [Add other validators for Treatment Class here] off begin
					// % protected region % [Add other validators for Treatment Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Class here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Class here] end
			},
			{
				name: 'referralNo',
				// % protected region % [Set displayName for Referral No here] off begin
				displayName: 'Referral No',
				// % protected region % [Set displayName for Referral No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Referral No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Referral No here] end
				// % protected region % [Set isSensitive for Referral No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Referral No here] end
				// % protected region % [Set readonly for Referral No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Referral No here] end
				validators: [
					// % protected region % [Add other validators for Referral No here] off begin
					// % protected region % [Add other validators for Referral No here] end
				],
				// % protected region % [Add any additional model attribute properties for Referral No here] off begin
				// % protected region % [Add any additional model attribute properties for Referral No here] end
			},
			{
				name: 'dateOfBirth',
				// % protected region % [Set displayName for Date of Birth here] off begin
				displayName: 'Date of Birth',
				// % protected region % [Set displayName for Date of Birth here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Date of Birth here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Date of Birth here] end
				// % protected region % [Set isSensitive for Date of Birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date of Birth here] end
				// % protected region % [Set readonly for Date of Birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date of Birth here] end
				validators: [
					// % protected region % [Add other validators for Date of Birth here] off begin
					// % protected region % [Add other validators for Date of Birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Date of Birth here] off begin
				// % protected region % [Add any additional model attribute properties for Date of Birth here] end
			},
			{
				name: 'visitDate',
				// % protected region % [Set displayName for Visit Date here] off begin
				displayName: 'Visit Date',
				// % protected region % [Set displayName for Visit Date here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Visit Date here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Visit Date here] end
				// % protected region % [Set isSensitive for Visit Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Visit Date here] end
				// % protected region % [Set readonly for Visit Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Visit Date here] end
				validators: [
					// % protected region % [Add other validators for Visit Date here] off begin
					// % protected region % [Add other validators for Visit Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Visit Date here] off begin
				// % protected region % [Add any additional model attribute properties for Visit Date here] end
			},
			{
				name: 'healthFacilityLevel',
				// % protected region % [Set displayName for Health Facility Level here] off begin
				displayName: 'Health Facility Level',
				// % protected region % [Set displayName for Health Facility Level here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Health Facility Level here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Health Facility Level here] end
				// % protected region % [Set isSensitive for Health Facility Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Health Facility Level here] end
				// % protected region % [Set readonly for Health Facility Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Health Facility Level here] end
				validators: [
					// % protected region % [Add other validators for Health Facility Level here] off begin
					// % protected region % [Add other validators for Health Facility Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Health Facility Level here] off begin
				// % protected region % [Add any additional model attribute properties for Health Facility Level here] end
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
				case 'sepNo':
					break;
				case 'patientID':
					break;
				case 'patientName':
					break;
				case 'gender':
					break;
				case 'bpjsCardNo':
					break;
				case 'treatmentClass':
					break;
				case 'referralNo':
					break;
				case 'dateOfBirth':
					break;
				case 'visitDate':
					break;
				case 'healthFacilityLevel':
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
	static deepParse(data: string | { [K in keyof BpjsSEPINACBGIntegrationModel]?: BpjsSEPINACBGIntegrationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsSEPINACBGIntegrationModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsSEPINACBGIntegrationModel = new BpjsSEPINACBGIntegrationModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsSEPINACBGIntegrationModel,
	 *    it is expected as a JSON string or as a nullable BpjsSEPINACBGIntegrationModel.
	 */
	constructor(data?: string | Partial<BpjsSEPINACBGIntegrationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsSEPINACBGIntegrationModel>
				: data;

			this.sepNo = json.sepNo;
			this.patientID = json.patientID;
			this.patientName = json.patientName;
			this.gender = json.gender;
			this.bpjsCardNo = json.bpjsCardNo;
			this.treatmentClass = json.treatmentClass;
			this.referralNo = json.referralNo;
			this.dateOfBirth = json.dateOfBirth;
			this.visitDate = json.visitDate;
			this.healthFacilityLevel = json.healthFacilityLevel;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			sepNo: this.sepNo,
			patientID: this.patientID,
			patientName: this.patientName,
			gender: this.gender,
			bpjsCardNo: this.bpjsCardNo,
			treatmentClass: this.treatmentClass,
			referralNo: this.referralNo,
			dateOfBirth: this.dateOfBirth,
			visitDate: this.visitDate,
			healthFacilityLevel: this.healthFacilityLevel,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsSEPINACBGIntegrationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsSEPINACBGIntegrationModel {
		let newModelJson = this.toJSON();

		if (updates.sepNo) {
			newModelJson.sepNo = updates.sepNo;
		}

		if (updates.patientID) {
			newModelJson.patientID = updates.patientID;
		}

		if (updates.patientName) {
			newModelJson.patientName = updates.patientName;
		}

		if (updates.gender) {
			newModelJson.gender = updates.gender;
		}

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.referralNo) {
			newModelJson.referralNo = updates.referralNo;
		}

		if (updates.dateOfBirth) {
			newModelJson.dateOfBirth = updates.dateOfBirth;
		}

		if (updates.visitDate) {
			newModelJson.visitDate = updates.visitDate;
		}

		if (updates.healthFacilityLevel) {
			newModelJson.healthFacilityLevel = updates.healthFacilityLevel;
		}

		return new BpjsSEPINACBGIntegrationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsSEPINACBGIntegrationModel)) {
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
