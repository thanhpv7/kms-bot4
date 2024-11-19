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
export class PharmacySetupModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'hospitalPharmacy',
		'headOfPharmacy',
		'pharmacistLicenseNo',
		'labelSetup',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'hospitalPharmacy',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PharmacySetupModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PharmacySetupModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Hospital Pharmacy (Max Length: 500).
	 */
	hospitalPharmacy: string;

	/**
	 * Head of Pharmacy (Max Length: 500).
	 */
	headOfPharmacy: string;

	/**
	 * Pharmacist License No (Max length: 500).
	 */
	pharmacistLicenseNo: string;

	/**
	 * setup to maintain sequence on print label.
	 */
	labelSetup: string;



	modelPropGroups: { [s: string]: Group } = PharmacySetupModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'hospitalPharmacy',
				// % protected region % [Set displayName for Hospital Pharmacy here] off begin
				displayName: 'Hospital Pharmacy',
				// % protected region % [Set displayName for Hospital Pharmacy here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Pharmacy here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Pharmacy here] end
				// % protected region % [Set isSensitive for Hospital Pharmacy here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Pharmacy here] end
				// % protected region % [Set readonly for Hospital Pharmacy here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Pharmacy here] end
				validators: [
					// % protected region % [Add other validators for Hospital Pharmacy here] off begin
					// % protected region % [Add other validators for Hospital Pharmacy here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Pharmacy here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Pharmacy here] end
			},
			{
				name: 'headOfPharmacy',
				// % protected region % [Set displayName for Head of Pharmacy here] off begin
				displayName: 'Head of Pharmacy',
				// % protected region % [Set displayName for Head of Pharmacy here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Head of Pharmacy here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Head of Pharmacy here] end
				// % protected region % [Set isSensitive for Head of Pharmacy here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Head of Pharmacy here] end
				// % protected region % [Set readonly for Head of Pharmacy here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Head of Pharmacy here] end
				validators: [
					// % protected region % [Add other validators for Head of Pharmacy here] off begin
					// % protected region % [Add other validators for Head of Pharmacy here] end
				],
				// % protected region % [Add any additional model attribute properties for Head of Pharmacy here] off begin
				// % protected region % [Add any additional model attribute properties for Head of Pharmacy here] end
			},
			{
				name: 'pharmacistLicenseNo',
				// % protected region % [Set displayName for Pharmacist License No here] off begin
				displayName: 'Pharmacist License No',
				// % protected region % [Set displayName for Pharmacist License No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pharmacist License No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pharmacist License No here] end
				// % protected region % [Set isSensitive for Pharmacist License No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pharmacist License No here] end
				// % protected region % [Set readonly for Pharmacist License No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pharmacist License No here] end
				validators: [
					// % protected region % [Add other validators for Pharmacist License No here] off begin
					// % protected region % [Add other validators for Pharmacist License No here] end
				],
				// % protected region % [Add any additional model attribute properties for Pharmacist License No here] off begin
				// % protected region % [Add any additional model attribute properties for Pharmacist License No here] end
			},
			{
				name: 'labelSetup',
				// % protected region % [Set displayName for Label setup here] off begin
				displayName: 'Label setup',
				// % protected region % [Set displayName for Label setup here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Label setup here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Label setup here] end
				// % protected region % [Set isSensitive for Label setup here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Label setup here] end
				// % protected region % [Set readonly for Label setup here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Label setup here] end
				validators: [
					// % protected region % [Add other validators for Label setup here] off begin
					// % protected region % [Add other validators for Label setup here] end
				],
				// % protected region % [Add any additional model attribute properties for Label setup here] off begin
				// % protected region % [Add any additional model attribute properties for Label setup here] end
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
				case 'hospitalPharmacy':
					break;
				case 'headOfPharmacy':
					break;
				case 'pharmacistLicenseNo':
					break;
				case 'labelSetup':
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
	static deepParse(data: string | { [K in keyof PharmacySetupModel]?: PharmacySetupModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PharmacySetupModel(data);
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
	 * `let pharmacySetupModel = new PharmacySetupModel(data);`
	 *
	 * @param data The input data to be initialised as the PharmacySetupModel,
	 *    it is expected as a JSON string or as a nullable PharmacySetupModel.
	 */
	constructor(data?: string | Partial<PharmacySetupModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PharmacySetupModel>
				: data;

			this.hospitalPharmacy = json.hospitalPharmacy;
			this.headOfPharmacy = json.headOfPharmacy;
			this.pharmacistLicenseNo = json.pharmacistLicenseNo;
			this.labelSetup = json.labelSetup;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			hospitalPharmacy: this.hospitalPharmacy,
			headOfPharmacy: this.headOfPharmacy,
			pharmacistLicenseNo: this.pharmacistLicenseNo,
			labelSetup: this.labelSetup,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PharmacySetupModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PharmacySetupModel {
		let newModelJson = this.toJSON();

		if (updates.hospitalPharmacy) {
			newModelJson.hospitalPharmacy = updates.hospitalPharmacy;
		}

		if (updates.headOfPharmacy) {
			newModelJson.headOfPharmacy = updates.headOfPharmacy;
		}

		if (updates.pharmacistLicenseNo) {
			newModelJson.pharmacistLicenseNo = updates.pharmacistLicenseNo;
		}

		if (updates.labelSetup) {
			newModelJson.labelSetup = updates.labelSetup;
		}

		return new PharmacySetupModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PharmacySetupModel)) {
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
