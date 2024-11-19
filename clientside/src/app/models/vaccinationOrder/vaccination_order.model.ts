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
import {VaccinationOrderDetailModel} from '../vaccinationOrderDetail/vaccination_order_detail.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class VaccinationOrderModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'vaccinationLocation',
		'vaccinationReaction',
		'purpose',
		'vaccinationNotes',
		'reactionNotes',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'vaccinationLocation',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'VaccinationOrderModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return VaccinationOrderModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	vaccinationLocation: string;

	/**
	 * .
	 */
	vaccinationReaction: string;

	/**
	 * .
	 */
	purpose: string;

	/**
	 * .
	 */
	vaccinationNotes: string;

	/**
	 * .
	 */
	reactionNotes: string;

	registrationId: string;

	registration: RegistrationModel;

	staffId: string;

	staff: StaffModel;

	vaccinationOrderDetailsIds: string[] = [];

	vaccinationOrderDetails: VaccinationOrderDetailModel[];

	modelPropGroups: { [s: string]: Group } = VaccinationOrderModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'vaccinationLocation',
				// % protected region % [Set displayName for Vaccination Location here] off begin
				displayName: 'Vaccination Location',
				// % protected region % [Set displayName for Vaccination Location here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Vaccination Location here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Vaccination Location here] end
				// % protected region % [Set isSensitive for Vaccination Location here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Vaccination Location here] end
				// % protected region % [Set readonly for Vaccination Location here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Vaccination Location here] end
				validators: [
					// % protected region % [Add other validators for Vaccination Location here] off begin
					// % protected region % [Add other validators for Vaccination Location here] end
				],
				// % protected region % [Add any additional model attribute properties for Vaccination Location here] off begin
				// % protected region % [Add any additional model attribute properties for Vaccination Location here] end
			},
			{
				name: 'vaccinationReaction',
				// % protected region % [Set displayName for Vaccination Reaction here] off begin
				displayName: 'Vaccination Reaction',
				// % protected region % [Set displayName for Vaccination Reaction here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Vaccination Reaction here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Vaccination Reaction here] end
				// % protected region % [Set isSensitive for Vaccination Reaction here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Vaccination Reaction here] end
				// % protected region % [Set readonly for Vaccination Reaction here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Vaccination Reaction here] end
				validators: [
					// % protected region % [Add other validators for Vaccination Reaction here] off begin
					// % protected region % [Add other validators for Vaccination Reaction here] end
				],
				// % protected region % [Add any additional model attribute properties for Vaccination Reaction here] off begin
				// % protected region % [Add any additional model attribute properties for Vaccination Reaction here] end
			},
			{
				name: 'purpose',
				// % protected region % [Set displayName for Purpose here] off begin
				displayName: 'Purpose',
				// % protected region % [Set displayName for Purpose here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Purpose here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Purpose here] end
				// % protected region % [Set isSensitive for Purpose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Purpose here] end
				// % protected region % [Set readonly for Purpose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Purpose here] end
				validators: [
					// % protected region % [Add other validators for Purpose here] off begin
					// % protected region % [Add other validators for Purpose here] end
				],
				// % protected region % [Add any additional model attribute properties for Purpose here] off begin
				// % protected region % [Add any additional model attribute properties for Purpose here] end
			},
			{
				name: 'vaccinationNotes',
				// % protected region % [Set displayName for Vaccination Notes here] off begin
				displayName: 'Vaccination Notes',
				// % protected region % [Set displayName for Vaccination Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Vaccination Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Vaccination Notes here] end
				// % protected region % [Set isSensitive for Vaccination Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Vaccination Notes here] end
				// % protected region % [Set readonly for Vaccination Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Vaccination Notes here] end
				validators: [
					// % protected region % [Add other validators for Vaccination Notes here] off begin
					// % protected region % [Add other validators for Vaccination Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Vaccination Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Vaccination Notes here] end
			},
			{
				name: 'reactionNotes',
				// % protected region % [Set displayName for Reaction Notes here] off begin
				displayName: 'Reaction Notes',
				// % protected region % [Set displayName for Reaction Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Reaction Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Reaction Notes here] end
				// % protected region % [Set isSensitive for Reaction Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reaction Notes here] end
				// % protected region % [Set readonly for Reaction Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reaction Notes here] end
				validators: [
					// % protected region % [Add other validators for Reaction Notes here] off begin
					// % protected region % [Add other validators for Reaction Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Reaction Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Reaction Notes here] end
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
				id: 'vaccinationOrderDetails',
				type: ModelRelationType.MANY,
				name: 'vaccinationOrderDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Vaccination Order Details here] off begin
				label: 'Vaccination Order Details',
				// % protected region % [Customise your 1-1 or 1-M label for Vaccination Order Details here] end
				entityName: 'VaccinationOrderDetailModel',
				// % protected region % [Customise your display name for Vaccination Order Details here] off begin
				displayName: 'vaccinationDate',
				// % protected region % [Customise your display name for Vaccination Order Details here] end
				validators: [
					// % protected region % [Add other validators for Vaccination Order Details here] off begin
					// % protected region % [Add other validators for Vaccination Order Details here] end
				],
				// % protected region % [Add any additional field for relation Vaccination Order Details here] off begin
				// % protected region % [Add any additional field for relation Vaccination Order Details here] end
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
			{
				id: 'staff',
				type: ModelRelationType.ONE,
				name: 'staffId',
				// % protected region % [Customise your label for Staff here] off begin
				label: 'Staff',
				// % protected region % [Customise your label for Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Staff here] end
				validators: [
					// % protected region % [Add other validators for Staff here] off begin
					// % protected region % [Add other validators for Staff here] end
				],
				// % protected region % [Add any additional field for relation Staff here] off begin
				// % protected region % [Add any additional field for relation Staff here] end
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
				case 'vaccinationLocation':
					break;
				case 'vaccinationReaction':
					break;
				case 'purpose':
					break;
				case 'vaccinationNotes':
					break;
				case 'reactionNotes':
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
	static deepParse(data: string | { [K in keyof VaccinationOrderModel]?: VaccinationOrderModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new VaccinationOrderModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

		// Incoming one to many
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}

		// Outgoing one to many
		if (json.vaccinationOrderDetails) {
			currentModel.vaccinationOrderDetailsIds = json.vaccinationOrderDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.vaccinationOrderDetails.map(model => VaccinationOrderDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let vaccinationOrderModel = new VaccinationOrderModel(data);`
	 *
	 * @param data The input data to be initialised as the VaccinationOrderModel,
	 *    it is expected as a JSON string or as a nullable VaccinationOrderModel.
	 */
	constructor(data?: string | Partial<VaccinationOrderModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<VaccinationOrderModel>
				: data;

			this.vaccinationLocation = json.vaccinationLocation;
			this.vaccinationReaction = json.vaccinationReaction;
			this.purpose = json.purpose;
			this.vaccinationNotes = json.vaccinationNotes;
			this.reactionNotes = json.reactionNotes;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.staffId = json.staffId;
			this.staff = json.staff;
			this.vaccinationOrderDetailsIds = json.vaccinationOrderDetailsIds;
			this.vaccinationOrderDetails = json.vaccinationOrderDetails;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			vaccinationLocation: this.vaccinationLocation,
			vaccinationReaction: this.vaccinationReaction,
			purpose: this.purpose,
			vaccinationNotes: this.vaccinationNotes,
			reactionNotes: this.reactionNotes,
			registrationId: this.registrationId,
			staffId: this.staffId,
			vaccinationOrderDetailsIds: this.vaccinationOrderDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		VaccinationOrderModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): VaccinationOrderModel {
		let newModelJson = this.toJSON();

		if (updates.vaccinationLocation) {
			newModelJson.vaccinationLocation = updates.vaccinationLocation;
		}

		if (updates.vaccinationReaction) {
			newModelJson.vaccinationReaction = updates.vaccinationReaction;
		}

		if (updates.purpose) {
			newModelJson.purpose = updates.purpose;
		}

		if (updates.vaccinationNotes) {
			newModelJson.vaccinationNotes = updates.vaccinationNotes;
		}

		if (updates.reactionNotes) {
			newModelJson.reactionNotes = updates.reactionNotes;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		if (updates.vaccinationOrderDetailsIds) {
			newModelJson.vaccinationOrderDetailsIds = updates.vaccinationOrderDetailsIds;
		}

		return new VaccinationOrderModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof VaccinationOrderModel)) {
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
			'staffId',
			'staff',
			'vaccinationOrderDetailsIds',
			'vaccinationOrderDetails',
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

		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
