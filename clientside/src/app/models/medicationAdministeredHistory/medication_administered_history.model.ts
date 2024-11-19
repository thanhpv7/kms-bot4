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
import {MedicationCompoundModel} from '../medicationCompound/medication_compound.model';
import {MedicationItemModel} from '../medicationItem/medication_item.model';
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
export class MedicationAdministeredHistoryModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'administrationNotes',
		'administeredQuantity',
		'takenHomeQuantity',
		'returnedQuantity',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'datetime',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MedicationAdministeredHistoryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MedicationAdministeredHistoryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	datetime: Date;

	/**
	 * .
	 */
	administrationNotes: string;

	/**
	 * .
	 */
	administeredQuantity: number;

	/**
	 * .
	 */
	takenHomeQuantity: number;

	/**
	 * .
	 */
	returnedQuantity: number;

	/**
	 * Total Administered Quantity.
	 */
	totalAdministeredQuantity: number;

	medicationItemId: string;

	medicationItem: MedicationItemModel;

	staffId: string;

	staff: StaffModel;

	medicationCompoundId: string;

	medicationCompound: MedicationCompoundModel;

	modelPropGroups: { [s: string]: Group } = MedicationAdministeredHistoryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'datetime',
				// % protected region % [Set displayName for DateTime here] off begin
				displayName: 'DateTime',
				// % protected region % [Set displayName for DateTime here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for DateTime here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for DateTime here] end
				// % protected region % [Set isSensitive for DateTime here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DateTime here] end
				// % protected region % [Set readonly for DateTime here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DateTime here] end
				validators: [
					// % protected region % [Add other validators for DateTime here] off begin
					// % protected region % [Add other validators for DateTime here] end
				],
				// % protected region % [Add any additional model attribute properties for DateTime here] off begin
				// % protected region % [Add any additional model attribute properties for DateTime here] end
			},
			{
				name: 'administrationNotes',
				// % protected region % [Set displayName for Administration Notes here] off begin
				displayName: 'Administration Notes',
				// % protected region % [Set displayName for Administration Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Administration Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Administration Notes here] end
				// % protected region % [Set isSensitive for Administration Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Administration Notes here] end
				// % protected region % [Set readonly for Administration Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Administration Notes here] end
				validators: [
					// % protected region % [Add other validators for Administration Notes here] off begin
					// % protected region % [Add other validators for Administration Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Administration Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Administration Notes here] end
			},
			{
				name: 'administeredQuantity',
				// % protected region % [Set displayName for Administered Quantity here] off begin
				displayName: 'Administered Quantity',
				// % protected region % [Set displayName for Administered Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Administered Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Administered Quantity here] end
				// % protected region % [Set isSensitive for Administered Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Administered Quantity here] end
				// % protected region % [Set readonly for Administered Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Administered Quantity here] end
				validators: [
					// % protected region % [Add other validators for Administered Quantity here] off begin
					// % protected region % [Add other validators for Administered Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Administered Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Administered Quantity here] end
			},
			{
				name: 'takenHomeQuantity',
				// % protected region % [Set displayName for Taken Home Quantity here] off begin
				displayName: 'Taken Home Quantity',
				// % protected region % [Set displayName for Taken Home Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Taken Home Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Taken Home Quantity here] end
				// % protected region % [Set isSensitive for Taken Home Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Taken Home Quantity here] end
				// % protected region % [Set readonly for Taken Home Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Taken Home Quantity here] end
				validators: [
					// % protected region % [Add other validators for Taken Home Quantity here] off begin
					// % protected region % [Add other validators for Taken Home Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Taken Home Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Taken Home Quantity here] end
			},
			{
				name: 'returnedQuantity',
				// % protected region % [Set displayName for Returned Quantity here] off begin
				displayName: 'Returned Quantity',
				// % protected region % [Set displayName for Returned Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Returned Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Returned Quantity here] end
				// % protected region % [Set isSensitive for Returned Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Returned Quantity here] end
				// % protected region % [Set readonly for Returned Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Returned Quantity here] end
				validators: [
					// % protected region % [Add other validators for Returned Quantity here] off begin
					// % protected region % [Add other validators for Returned Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Returned Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Returned Quantity here] end
			},
			{
				name: 'totalAdministeredQuantity',
				// % protected region % [Set displayName for Total Administered Quantity here] off begin
				displayName: 'Total Administered Quantity',
				// % protected region % [Set displayName for Total Administered Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Administered Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Administered Quantity here] end
				// % protected region % [Set isSensitive for Total Administered Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Administered Quantity here] end
				// % protected region % [Set readonly for Total Administered Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Administered Quantity here] end
				validators: [
					// % protected region % [Add other validators for Total Administered Quantity here] off begin
					// % protected region % [Add other validators for Total Administered Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Administered Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Total Administered Quantity here] end
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
				id: 'medicationItem',
				type: ModelRelationType.ONE,
				name: 'medicationItemId',
				// % protected region % [Customise your label for Medication Item here] off begin
				label: 'Medication Item',
				// % protected region % [Customise your label for Medication Item here] end
				entityName: 'MedicationItemModel',
				// % protected region % [Customise your display name for Medication Item here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'requestedQty',
				// % protected region % [Customise your display name for Medication Item here] end
				validators: [
					// % protected region % [Add other validators for Medication Item here] off begin
					// % protected region % [Add other validators for Medication Item here] end
				],
				// % protected region % [Add any additional field for relation Medication Item here] off begin
				// % protected region % [Add any additional field for relation Medication Item here] end
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
			{
				id: 'medicationCompound',
				type: ModelRelationType.ONE,
				name: 'medicationCompoundId',
				// % protected region % [Customise your label for Medication Compound here] off begin
				label: 'Medication Compound',
				// % protected region % [Customise your label for Medication Compound here] end
				entityName: 'MedicationCompoundModel',
				// % protected region % [Customise your display name for Medication Compound here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'compoundCode',
				// % protected region % [Customise your display name for Medication Compound here] end
				validators: [
					// % protected region % [Add other validators for Medication Compound here] off begin
					// % protected region % [Add other validators for Medication Compound here] end
				],
				// % protected region % [Add any additional field for relation Medication Compound here] off begin
				// % protected region % [Add any additional field for relation Medication Compound here] end
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
				case 'administrationNotes':
					break;
				case 'administeredQuantity':
					break;
				case 'takenHomeQuantity':
					break;
				case 'returnedQuantity':
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
	static deepParse(data: string | { [K in keyof MedicationAdministeredHistoryModel]?: MedicationAdministeredHistoryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MedicationAdministeredHistoryModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.medicationItem) {
			currentModel.medicationItemId = json.medicationItem.id;
			returned = _.union(returned, MedicationItemModel.deepParse(json.medicationItem));
		}

		// Incoming one to many
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}

		// Incoming one to many
		if (json.medicationCompound) {
			currentModel.medicationCompoundId = json.medicationCompound.id;
			returned = _.union(returned, MedicationCompoundModel.deepParse(json.medicationCompound));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let medicationAdministeredHistoryModel = new MedicationAdministeredHistoryModel(data);`
	 *
	 * @param data The input data to be initialised as the MedicationAdministeredHistoryModel,
	 *    it is expected as a JSON string or as a nullable MedicationAdministeredHistoryModel.
	 */
	constructor(data?: string | Partial<MedicationAdministeredHistoryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MedicationAdministeredHistoryModel>
				: data;

			if (json.datetime) {
				this.datetime = new Date(json.datetime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.datetime = json.datetime;
			}
			this.administrationNotes = json.administrationNotes;
			this.administeredQuantity = json.administeredQuantity;
			this.takenHomeQuantity = json.takenHomeQuantity;
			this.returnedQuantity = json.returnedQuantity;
			this.totalAdministeredQuantity = json.totalAdministeredQuantity;
			this.medicationItemId = json.medicationItemId;
			this.medicationItem = json.medicationItem;
			this.staffId = json.staffId;
			this.staff = json.staff;
			this.medicationCompoundId = json.medicationCompoundId;
			this.medicationCompound = json.medicationCompound;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			datetime: this.datetime,
			administrationNotes: this.administrationNotes,
			administeredQuantity: this.administeredQuantity,
			takenHomeQuantity: this.takenHomeQuantity,
			returnedQuantity: this.returnedQuantity,
			totalAdministeredQuantity: this.totalAdministeredQuantity,
			medicationItemId: this.medicationItemId,
			staffId: this.staffId,
			medicationCompoundId: this.medicationCompoundId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MedicationAdministeredHistoryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MedicationAdministeredHistoryModel {
		let newModelJson = this.toJSON();

		if (updates.datetime) {
			newModelJson.datetime = updates.datetime;
		}

		if (updates.administrationNotes) {
			newModelJson.administrationNotes = updates.administrationNotes;
		}

		if (updates.administeredQuantity) {
			newModelJson.administeredQuantity = updates.administeredQuantity;
		}

		if (updates.takenHomeQuantity) {
			newModelJson.takenHomeQuantity = updates.takenHomeQuantity;
		}

		if (updates.returnedQuantity) {
			newModelJson.returnedQuantity = updates.returnedQuantity;
		}

		if (updates.totalAdministeredQuantity) {
			newModelJson.totalAdministeredQuantity = updates.totalAdministeredQuantity;
		}

		if (updates.medicationItemId) {
			newModelJson.medicationItemId = updates.medicationItemId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		if (updates.medicationCompoundId) {
			newModelJson.medicationCompoundId = updates.medicationCompoundId;
		}

		return new MedicationAdministeredHistoryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MedicationAdministeredHistoryModel)) {
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
			'medicationItemId',
			'medicationItem',
			'staffId',
			'staff',
			'medicationCompoundId',
			'medicationCompound',
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
		if (!this.medicationItem) {
			this.medicationItemId = null;
		} else {
			this.medicationItemId = this.medicationItem.id;
		}

		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

		if (!this.medicationCompound) {
			this.medicationCompoundId = null;
		} else {
			this.medicationCompoundId = this.medicationCompound.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
