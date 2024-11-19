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
import {CatalogueUOMModel} from '../catalogueUOM/catalogue_uom.model';
import {CompoundPrescriptionDetailModel} from '../compoundPrescriptionDetail/compound_prescription_detail.model';
import {CompoundPrescriptionItemModel} from '../compoundPrescriptionItem/compound_prescription_item.model';
import {MedicationCompoundModel} from '../medicationCompound/medication_compound.model';
import {MedicationItemModel} from '../medicationItem/medication_item.model';
import {PrescriptionCompoundModel} from '../prescriptionCompound/prescription_compound.model';
import {PrescriptionItemModel} from '../prescriptionItem/prescription_item.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class UnitOfMeasurementModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'unitName',
		'symbol',
		'description',
		'unitCategory',
		'consumptionUnit',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'unitName',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'UnitOfMeasurementModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return UnitOfMeasurementModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Unit Name (Max Length: 50).
	 */
	unitName: string;

	/**
	 * Symbol (Max Length: 50).
	 */
	symbol: string;

	/**
	 * Detail Description of Unit (Max Length: 500).
	 */
	description: string;

	/**
	 * Unit Category, get the Code from Reference Data where Type=UNIT_CATEGORY. (Max Length: 20).
	 */
	unitCategory: string;

	/**
	 * Consumption Unit indicator to display the unit on Consumption Unit of Stock Catalogue.
	 */
	consumptionUnit: boolean = false;

	catalogueUOMId: string;

	catalogueUOM: CatalogueUOMModel;

	compoundPrescriptionDetailsIds: string[] = [];

	compoundPrescriptionDetails: CompoundPrescriptionDetailModel[];

	compoundPrescriptionItemsIds: string[] = [];

	compoundPrescriptionItems: CompoundPrescriptionItemModel[];

	compoundsUnitIds: string[] = [];

	compoundsUnit: PrescriptionCompoundModel[];

	medicationCompoundsIds: string[] = [];

	medicationCompounds: MedicationCompoundModel[];

	medicationItemsIds: string[] = [];

	medicationItems: MedicationItemModel[];

	prescriptionItemsIds: string[] = [];

	prescriptionItems: PrescriptionItemModel[];

	modelPropGroups: { [s: string]: Group } = UnitOfMeasurementModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'unitName',
				// % protected region % [Set displayName for Unit Name here] off begin
				displayName: 'Unit Name',
				// % protected region % [Set displayName for Unit Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Unit Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Unit Name here] end
				// % protected region % [Set isSensitive for Unit Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit Name here] end
				// % protected region % [Set readonly for Unit Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Unit Name here] off begin
					// % protected region % [Add other validators for Unit Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit Name here] off begin
				// % protected region % [Add any additional model attribute properties for Unit Name here] end
			},
			{
				name: 'symbol',
				// % protected region % [Set displayName for Symbol here] off begin
				displayName: 'Symbol',
				// % protected region % [Set displayName for Symbol here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Symbol here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Symbol here] end
				// % protected region % [Set isSensitive for Symbol here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Symbol here] end
				// % protected region % [Set readonly for Symbol here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Symbol here] end
				validators: [
					// % protected region % [Add other validators for Symbol here] off begin
					// % protected region % [Add other validators for Symbol here] end
				],
				// % protected region % [Add any additional model attribute properties for Symbol here] off begin
				// % protected region % [Add any additional model attribute properties for Symbol here] end
			},
			{
				name: 'description',
				// % protected region % [Set displayName for Description here] off begin
				displayName: 'Description',
				// % protected region % [Set displayName for Description here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Description here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Description here] end
				// % protected region % [Set isSensitive for Description here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Description here] end
				// % protected region % [Set readonly for Description here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Description here] end
				validators: [
					// % protected region % [Add other validators for Description here] off begin
					// % protected region % [Add other validators for Description here] end
				],
				// % protected region % [Add any additional model attribute properties for Description here] off begin
				// % protected region % [Add any additional model attribute properties for Description here] end
			},
			{
				name: 'unitCategory',
				// % protected region % [Set displayName for Unit Category here] off begin
				displayName: 'Unit Category',
				// % protected region % [Set displayName for Unit Category here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Unit Category here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Unit Category here] end
				// % protected region % [Set isSensitive for Unit Category here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit Category here] end
				// % protected region % [Set readonly for Unit Category here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit Category here] end
				validators: [
					// % protected region % [Add other validators for Unit Category here] off begin
					// % protected region % [Add other validators for Unit Category here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit Category here] off begin
				// % protected region % [Add any additional model attribute properties for Unit Category here] end
			},
			{
				name: 'consumptionUnit',
				// % protected region % [Set displayName for Consumption Unit here] off begin
				displayName: 'Consumption Unit',
				// % protected region % [Set displayName for Consumption Unit here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Consumption Unit here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Consumption Unit here] end
				// % protected region % [Set isSensitive for Consumption Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consumption Unit here] end
				// % protected region % [Set readonly for Consumption Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consumption Unit here] end
				validators: [
					// % protected region % [Add other validators for Consumption Unit here] off begin
					// % protected region % [Add other validators for Consumption Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Consumption Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Consumption Unit here] end
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
				id: 'compoundPrescriptionDetails',
				type: ModelRelationType.MANY,
				name: 'compoundPrescriptionDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Compound Prescription Details here] off begin
				label: 'Compound Prescription Details',
				// % protected region % [Customise your 1-1 or 1-M label for Compound Prescription Details here] end
				entityName: 'CompoundPrescriptionDetailModel',
				// % protected region % [Customise your display name for Compound Prescription Details here] off begin
				displayName: 'compoundCode',
				// % protected region % [Customise your display name for Compound Prescription Details here] end
				validators: [
					// % protected region % [Add other validators for Compound Prescription Details here] off begin
					// % protected region % [Add other validators for Compound Prescription Details here] end
				],
				// % protected region % [Add any additional field for relation Compound Prescription Details here] off begin
				// % protected region % [Add any additional field for relation Compound Prescription Details here] end
			},
			{
				id: 'compoundPrescriptionItems',
				type: ModelRelationType.MANY,
				name: 'compoundPrescriptionItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Compound Prescription Items here] off begin
				label: 'Compound Prescription Items',
				// % protected region % [Customise your 1-1 or 1-M label for Compound Prescription Items here] end
				entityName: 'CompoundPrescriptionItemModel',
				// % protected region % [Customise your display name for Compound Prescription Items here] off begin
				displayName: 'dose',
				// % protected region % [Customise your display name for Compound Prescription Items here] end
				validators: [
					// % protected region % [Add other validators for Compound Prescription Items here] off begin
					// % protected region % [Add other validators for Compound Prescription Items here] end
				],
				// % protected region % [Add any additional field for relation Compound Prescription Items here] off begin
				// % protected region % [Add any additional field for relation Compound Prescription Items here] end
			},
			{
				id: 'compoundsUnit',
				type: ModelRelationType.MANY,
				name: 'compoundsUnitIds',
				// % protected region % [Customise your 1-1 or 1-M label for Compounds Unit here] off begin
				label: 'Compounds Unit',
				// % protected region % [Customise your 1-1 or 1-M label for Compounds Unit here] end
				entityName: 'PrescriptionCompoundModel',
				// % protected region % [Customise your display name for Compounds Unit here] off begin
				displayName: 'iterationStart',
				// % protected region % [Customise your display name for Compounds Unit here] end
				validators: [
					// % protected region % [Add other validators for Compounds Unit here] off begin
					// % protected region % [Add other validators for Compounds Unit here] end
				],
				// % protected region % [Add any additional field for relation Compounds Unit here] off begin
				// % protected region % [Add any additional field for relation Compounds Unit here] end
			},
			{
				id: 'medicationCompounds',
				type: ModelRelationType.MANY,
				name: 'medicationCompoundsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Compounds here] off begin
				label: 'Medication Compounds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Compounds here] end
				entityName: 'MedicationCompoundModel',
				// % protected region % [Customise your display name for Medication Compounds here] off begin
				displayName: 'compoundCode',
				// % protected region % [Customise your display name for Medication Compounds here] end
				validators: [
					// % protected region % [Add other validators for Medication Compounds here] off begin
					// % protected region % [Add other validators for Medication Compounds here] end
				],
				// % protected region % [Add any additional field for relation Medication Compounds here] off begin
				// % protected region % [Add any additional field for relation Medication Compounds here] end
			},
			{
				id: 'medicationItems',
				type: ModelRelationType.MANY,
				name: 'medicationItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Items here] off begin
				label: 'Medication Items',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Items here] end
				entityName: 'MedicationItemModel',
				// % protected region % [Customise your display name for Medication Items here] off begin
				displayName: 'requestedQty',
				// % protected region % [Customise your display name for Medication Items here] end
				validators: [
					// % protected region % [Add other validators for Medication Items here] off begin
					// % protected region % [Add other validators for Medication Items here] end
				],
				// % protected region % [Add any additional field for relation Medication Items here] off begin
				// % protected region % [Add any additional field for relation Medication Items here] end
			},
			{
				id: 'prescriptionItems',
				type: ModelRelationType.MANY,
				name: 'prescriptionItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Items here] off begin
				label: 'Prescription Items',
				// % protected region % [Customise your 1-1 or 1-M label for Prescription Items here] end
				entityName: 'PrescriptionItemModel',
				// % protected region % [Customise your display name for Prescription Items here] off begin
				displayName: 'iterationStart',
				// % protected region % [Customise your display name for Prescription Items here] end
				validators: [
					// % protected region % [Add other validators for Prescription Items here] off begin
					// % protected region % [Add other validators for Prescription Items here] end
				],
				// % protected region % [Add any additional field for relation Prescription Items here] off begin
				// % protected region % [Add any additional field for relation Prescription Items here] end
			},
			{
				id: 'catalogueUOM',
				type: ModelRelationType.ONE,
				name: 'catalogueUOMId',
				// % protected region % [Customise your label for Catalogue UOM here] off begin
				label: 'Catalogue UOM',
				// % protected region % [Customise your label for Catalogue UOM here] end
				entityName: 'CatalogueUOMModel',
				// % protected region % [Customise your display name for Catalogue UOM here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'unitName',
				// % protected region % [Customise your display name for Catalogue UOM here] end
				validators: [
					// % protected region % [Add other validators for Catalogue UOM here] off begin
					// % protected region % [Add other validators for Catalogue UOM here] end
				],
				// % protected region % [Add any additional field for relation Catalogue UOM here] off begin
				// % protected region % [Add any additional field for relation Catalogue UOM here] end
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
				case 'unitName':
					break;
				case 'symbol':
					break;
				case 'description':
					break;
				case 'unitCategory':
					break;
				case 'consumptionUnit':
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
	static deepParse(data: string | { [K in keyof UnitOfMeasurementModel]?: UnitOfMeasurementModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new UnitOfMeasurementModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.catalogueUOM) {
			currentModel.catalogueUOMId = json.catalogueUOM.id;
			returned = _.union(returned, CatalogueUOMModel.deepParse(json.catalogueUOM));
		}

		// Outgoing one to many
		if (json.compoundPrescriptionDetails) {
			currentModel.compoundPrescriptionDetailsIds = json.compoundPrescriptionDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.compoundPrescriptionDetails.map(model => CompoundPrescriptionDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.compoundPrescriptionItems) {
			currentModel.compoundPrescriptionItemsIds = json.compoundPrescriptionItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.compoundPrescriptionItems.map(model => CompoundPrescriptionItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.compoundsUnit) {
			currentModel.compoundsUnitIds = json.compoundsUnit.map(model => model.id);
			returned = _.union(returned, _.flatten(json.compoundsUnit.map(model => PrescriptionCompoundModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationCompounds) {
			currentModel.medicationCompoundsIds = json.medicationCompounds.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationCompounds.map(model => MedicationCompoundModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationItems) {
			currentModel.medicationItemsIds = json.medicationItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationItems.map(model => MedicationItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.prescriptionItems) {
			currentModel.prescriptionItemsIds = json.prescriptionItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.prescriptionItems.map(model => PrescriptionItemModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let unitOfMeasurementModel = new UnitOfMeasurementModel(data);`
	 *
	 * @param data The input data to be initialised as the UnitOfMeasurementModel,
	 *    it is expected as a JSON string or as a nullable UnitOfMeasurementModel.
	 */
	constructor(data?: string | Partial<UnitOfMeasurementModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<UnitOfMeasurementModel>
				: data;

			this.unitName = json.unitName;
			this.symbol = json.symbol;
			this.description = json.description;
			this.unitCategory = json.unitCategory;
			this.consumptionUnit = json.consumptionUnit;
			this.catalogueUOMId = json.catalogueUOMId;
			this.catalogueUOM = json.catalogueUOM;
			this.compoundPrescriptionDetailsIds = json.compoundPrescriptionDetailsIds;
			this.compoundPrescriptionDetails = json.compoundPrescriptionDetails;
			this.compoundPrescriptionItemsIds = json.compoundPrescriptionItemsIds;
			this.compoundPrescriptionItems = json.compoundPrescriptionItems;
			this.compoundsUnitIds = json.compoundsUnitIds;
			this.compoundsUnit = json.compoundsUnit;
			this.medicationCompoundsIds = json.medicationCompoundsIds;
			this.medicationCompounds = json.medicationCompounds;
			this.medicationItemsIds = json.medicationItemsIds;
			this.medicationItems = json.medicationItems;
			this.prescriptionItemsIds = json.prescriptionItemsIds;
			this.prescriptionItems = json.prescriptionItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			unitName: this.unitName,
			symbol: this.symbol,
			description: this.description,
			unitCategory: this.unitCategory,
			consumptionUnit: this.consumptionUnit,
			catalogueUOMId: this.catalogueUOMId,
			compoundPrescriptionDetailsIds: this.compoundPrescriptionDetailsIds,
			compoundPrescriptionItemsIds: this.compoundPrescriptionItemsIds,
			compoundsUnitIds: this.compoundsUnitIds,
			medicationCompoundsIds: this.medicationCompoundsIds,
			medicationItemsIds: this.medicationItemsIds,
			prescriptionItemsIds: this.prescriptionItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		UnitOfMeasurementModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): UnitOfMeasurementModel {
		let newModelJson = this.toJSON();

		if (updates.unitName) {
			newModelJson.unitName = updates.unitName;
		}

		if (updates.symbol) {
			newModelJson.symbol = updates.symbol;
		}

		if (updates.description) {
			newModelJson.description = updates.description;
		}

		if (updates.unitCategory) {
			newModelJson.unitCategory = updates.unitCategory;
		}

		if (updates.consumptionUnit) {
			newModelJson.consumptionUnit = updates.consumptionUnit;
		}

		if (updates.catalogueUOMId) {
			newModelJson.catalogueUOMId = updates.catalogueUOMId;
		}

		if (updates.compoundPrescriptionDetailsIds) {
			newModelJson.compoundPrescriptionDetailsIds = updates.compoundPrescriptionDetailsIds;
		}

		if (updates.compoundPrescriptionItemsIds) {
			newModelJson.compoundPrescriptionItemsIds = updates.compoundPrescriptionItemsIds;
		}

		if (updates.compoundsUnitIds) {
			newModelJson.compoundsUnitIds = updates.compoundsUnitIds;
		}

		if (updates.medicationCompoundsIds) {
			newModelJson.medicationCompoundsIds = updates.medicationCompoundsIds;
		}

		if (updates.medicationItemsIds) {
			newModelJson.medicationItemsIds = updates.medicationItemsIds;
		}

		if (updates.prescriptionItemsIds) {
			newModelJson.prescriptionItemsIds = updates.prescriptionItemsIds;
		}

		return new UnitOfMeasurementModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof UnitOfMeasurementModel)) {
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
			'catalogueUOMId',
			'catalogueUOM',
			'compoundPrescriptionDetailsIds',
			'compoundPrescriptionDetails',
			'compoundPrescriptionItemsIds',
			'compoundPrescriptionItems',
			'compoundsUnitIds',
			'compoundsUnit',
			'medicationCompoundsIds',
			'medicationCompounds',
			'medicationItemsIds',
			'medicationItems',
			'prescriptionItemsIds',
			'prescriptionItems',
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
		if (!this.catalogueUOM) {
			this.catalogueUOMId = null;
		} else {
			this.catalogueUOMId = this.catalogueUOM.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
