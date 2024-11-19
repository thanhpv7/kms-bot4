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
import {RegistrationModel} from '../registration/registration.model';
import {StaffModel} from '../staff/staff.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class MedicalCertificateRestrictedWorkModel extends AbstractModel {
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
		'period',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MedicalCertificateRestrictedWorkModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MedicalCertificateRestrictedWorkModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * How many days of restricted work.
	 */
	period: number;

	/**
	 * Start Date of restricted work.
	 */
	startDate: Date;

	/**
	 * End Date of restricted work.
	 */
	endDate: Date;

	/**
	 * Notes (Max Length: 500).
	 */
	notes: string;

	registrationId: string;

	registration: RegistrationModel;

	medicalStaffId: string;

	medicalStaff: StaffModel;

	modelPropGroups: { [s: string]: Group } = MedicalCertificateRestrictedWorkModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'period',
				// % protected region % [Set displayName for Period here] off begin
				displayName: 'Period',
				// % protected region % [Set displayName for Period here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Period here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Period here] end
				// % protected region % [Set isSensitive for Period here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Period here] end
				// % protected region % [Set readonly for Period here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Period here] end
				validators: [
					// % protected region % [Add other validators for Period here] off begin
					// % protected region % [Add other validators for Period here] end
				],
				// % protected region % [Add any additional model attribute properties for Period here] off begin
				// % protected region % [Add any additional model attribute properties for Period here] end
			},
			{
				name: 'startDate',
				// % protected region % [Set displayName for Start Date here] off begin
				displayName: 'Start Date',
				// % protected region % [Set displayName for Start Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Start Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Start Date here] end
				// % protected region % [Set isSensitive for Start Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Start Date here] end
				// % protected region % [Set readonly for Start Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Start Date here] end
				validators: [
					// % protected region % [Add other validators for Start Date here] off begin
					// % protected region % [Add other validators for Start Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Start Date here] off begin
				// % protected region % [Add any additional model attribute properties for Start Date here] end
			},
			{
				name: 'endDate',
				// % protected region % [Set displayName for End Date here] off begin
				displayName: 'End Date',
				// % protected region % [Set displayName for End Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for End Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for End Date here] end
				// % protected region % [Set isSensitive for End Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for End Date here] end
				// % protected region % [Set readonly for End Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for End Date here] end
				validators: [
					// % protected region % [Add other validators for End Date here] off begin
					// % protected region % [Add other validators for End Date here] end
				],
				// % protected region % [Add any additional model attribute properties for End Date here] off begin
				// % protected region % [Add any additional model attribute properties for End Date here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Notes here] end
				// % protected region % [Set isSensitive for Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Notes here] end
				// % protected region % [Set readonly for Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Notes here] end
				validators: [
					// % protected region % [Add other validators for Notes here] off begin
					// % protected region % [Add other validators for Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Notes here] end
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
			{
				id: 'medicalStaff',
				type: ModelRelationType.ONE,
				name: 'medicalStaffId',
				// % protected region % [Customise your label for Medical Staff here] off begin
				label: 'Medical Staff',
				// % protected region % [Customise your label for Medical Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Medical Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Medical Staff here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff here] off begin
					// % protected region % [Add other validators for Medical Staff here] end
				],
				// % protected region % [Add any additional field for relation Medical Staff here] off begin
				// % protected region % [Add any additional field for relation Medical Staff here] end
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
	static deepParse(data: string | { [K in keyof MedicalCertificateRestrictedWorkModel]?: MedicalCertificateRestrictedWorkModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MedicalCertificateRestrictedWorkModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

		// Incoming one to many
		if (json.medicalStaff) {
			currentModel.medicalStaffId = json.medicalStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.medicalStaff));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let medicalCertificateRestrictedWorkModel = new MedicalCertificateRestrictedWorkModel(data);`
	 *
	 * @param data The input data to be initialised as the MedicalCertificateRestrictedWorkModel,
	 *    it is expected as a JSON string or as a nullable MedicalCertificateRestrictedWorkModel.
	 */
	constructor(data?: string | Partial<MedicalCertificateRestrictedWorkModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MedicalCertificateRestrictedWorkModel>
				: data;

			this.period = json.period;
			if (json.startDate) {
				this.startDate = new Date(json.startDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.startDate = json.startDate;
			}
			if (json.endDate) {
				this.endDate = new Date(json.endDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.endDate = json.endDate;
			}
			this.notes = json.notes;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.medicalStaffId = json.medicalStaffId;
			this.medicalStaff = json.medicalStaff;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			period: this.period,
			startDate: this.startDate,
			endDate: this.endDate,
			notes: this.notes,
			registrationId: this.registrationId,
			medicalStaffId: this.medicalStaffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MedicalCertificateRestrictedWorkModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MedicalCertificateRestrictedWorkModel {
		let newModelJson = this.toJSON();

		if (updates.period) {
			newModelJson.period = updates.period;
		}

		if (updates.startDate) {
			newModelJson.startDate = updates.startDate;
		}

		if (updates.endDate) {
			newModelJson.endDate = updates.endDate;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.medicalStaffId) {
			newModelJson.medicalStaffId = updates.medicalStaffId;
		}

		return new MedicalCertificateRestrictedWorkModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MedicalCertificateRestrictedWorkModel)) {
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
			'registrationId',
			'registration',
			'medicalStaffId',
			'medicalStaff',
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
		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

		if (!this.medicalStaff) {
			this.medicalStaffId = null;
		} else {
			this.medicalStaffId = this.medicalStaff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
