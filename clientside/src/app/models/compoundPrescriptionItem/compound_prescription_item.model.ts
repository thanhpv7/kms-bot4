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
import {CompoundPrescriptionDetailModel} from '../compoundPrescriptionDetail/compound_prescription_detail.model';
import {StockCatalogueModel} from '../stockCatalogue/stock_catalogue.model';
import {UnitOfMeasurementModel} from '../unitOfMeasurement/unit_of_measurement.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class CompoundPrescriptionItemModel extends AbstractModel {
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
		'dose',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'CompoundPrescriptionItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return CompoundPrescriptionItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Dose.
	 */
	dose: number;

	/**
	 * Requested Quantity with 2 decimal digits.
	 */
	requestedQuantity: number;

	/**
	 * Notes (Max Length: 500).
	 */
	notes: string;

	compoundPrescriptionDetailId: string;

	compoundPrescriptionDetail: CompoundPrescriptionDetailModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	unitId: string;

	unit: UnitOfMeasurementModel;

	modelPropGroups: { [s: string]: Group } = CompoundPrescriptionItemModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'dose',
				// % protected region % [Set displayName for Dose here] off begin
				displayName: 'Dose',
				// % protected region % [Set displayName for Dose here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dose here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dose here] end
				// % protected region % [Set isSensitive for Dose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dose here] end
				// % protected region % [Set readonly for Dose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dose here] end
				validators: [
					// % protected region % [Add other validators for Dose here] off begin
					// % protected region % [Add other validators for Dose here] end
				],
				// % protected region % [Add any additional model attribute properties for Dose here] off begin
				// % protected region % [Add any additional model attribute properties for Dose here] end
			},
			{
				name: 'requestedQuantity',
				// % protected region % [Set displayName for Requested Quantity here] off begin
				displayName: 'Requested Quantity',
				// % protected region % [Set displayName for Requested Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Requested Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Requested Quantity here] end
				// % protected region % [Set isSensitive for Requested Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Requested Quantity here] end
				// % protected region % [Set readonly for Requested Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Requested Quantity here] end
				validators: [
					// % protected region % [Add other validators for Requested Quantity here] off begin
					// % protected region % [Add other validators for Requested Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Requested Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Requested Quantity here] end
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
				id: 'compoundPrescriptionDetail',
				type: ModelRelationType.ONE,
				name: 'compoundPrescriptionDetailId',
				// % protected region % [Customise your label for Compound Prescription Detail here] off begin
				label: 'Compound Prescription Detail',
				// % protected region % [Customise your label for Compound Prescription Detail here] end
				entityName: 'CompoundPrescriptionDetailModel',
				// % protected region % [Customise your display name for Compound Prescription Detail here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'compoundCode',
				// % protected region % [Customise your display name for Compound Prescription Detail here] end
				validators: [
					// % protected region % [Add other validators for Compound Prescription Detail here] off begin
					// % protected region % [Add other validators for Compound Prescription Detail here] end
				],
				// % protected region % [Add any additional field for relation Compound Prescription Detail here] off begin
				// % protected region % [Add any additional field for relation Compound Prescription Detail here] end
			},
			{
				id: 'stockCatalogue',
				type: ModelRelationType.ONE,
				name: 'stockCatalogueId',
				// % protected region % [Customise your label for Stock Catalogue here] off begin
				label: 'Stock Catalogue',
				// % protected region % [Customise your label for Stock Catalogue here] end
				entityName: 'StockCatalogueModel',
				// % protected region % [Customise your display name for Stock Catalogue here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'trackable',
				// % protected region % [Customise your display name for Stock Catalogue here] end
				validators: [
					// % protected region % [Add other validators for Stock Catalogue here] off begin
					// % protected region % [Add other validators for Stock Catalogue here] end
				],
				// % protected region % [Add any additional field for relation Stock Catalogue here] off begin
				// % protected region % [Add any additional field for relation Stock Catalogue here] end
			},
			{
				id: 'unit',
				type: ModelRelationType.ONE,
				name: 'unitId',
				// % protected region % [Customise your label for Unit here] off begin
				label: 'Unit',
				// % protected region % [Customise your label for Unit here] end
				entityName: 'UnitOfMeasurementModel',
				// % protected region % [Customise your display name for Unit here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'unitName',
				// % protected region % [Customise your display name for Unit here] end
				validators: [
					// % protected region % [Add other validators for Unit here] off begin
					// % protected region % [Add other validators for Unit here] end
				],
				// % protected region % [Add any additional field for relation Unit here] off begin
				// % protected region % [Add any additional field for relation Unit here] end
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
	static deepParse(data: string | { [K in keyof CompoundPrescriptionItemModel]?: CompoundPrescriptionItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new CompoundPrescriptionItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.compoundPrescriptionDetail) {
			currentModel.compoundPrescriptionDetailId = json.compoundPrescriptionDetail.id;
			returned = _.union(returned, CompoundPrescriptionDetailModel.deepParse(json.compoundPrescriptionDetail));
		}

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Incoming one to many
		if (json.unit) {
			currentModel.unitId = json.unit.id;
			returned = _.union(returned, UnitOfMeasurementModel.deepParse(json.unit));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let compoundPrescriptionItemModel = new CompoundPrescriptionItemModel(data);`
	 *
	 * @param data The input data to be initialised as the CompoundPrescriptionItemModel,
	 *    it is expected as a JSON string or as a nullable CompoundPrescriptionItemModel.
	 */
	constructor(data?: string | Partial<CompoundPrescriptionItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<CompoundPrescriptionItemModel>
				: data;

			this.dose = json.dose;
			this.requestedQuantity = json.requestedQuantity;
			this.notes = json.notes;
			this.compoundPrescriptionDetailId = json.compoundPrescriptionDetailId;
			this.compoundPrescriptionDetail = json.compoundPrescriptionDetail;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.unitId = json.unitId;
			this.unit = json.unit;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			dose: this.dose,
			requestedQuantity: this.requestedQuantity,
			notes: this.notes,
			compoundPrescriptionDetailId: this.compoundPrescriptionDetailId,
			stockCatalogueId: this.stockCatalogueId,
			unitId: this.unitId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		CompoundPrescriptionItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): CompoundPrescriptionItemModel {
		let newModelJson = this.toJSON();

		if (updates.dose) {
			newModelJson.dose = updates.dose;
		}

		if (updates.requestedQuantity) {
			newModelJson.requestedQuantity = updates.requestedQuantity;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.compoundPrescriptionDetailId) {
			newModelJson.compoundPrescriptionDetailId = updates.compoundPrescriptionDetailId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.unitId) {
			newModelJson.unitId = updates.unitId;
		}

		return new CompoundPrescriptionItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof CompoundPrescriptionItemModel)) {
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
			'compoundPrescriptionDetailId',
			'compoundPrescriptionDetail',
			'stockCatalogueId',
			'stockCatalogue',
			'unitId',
			'unit',
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
		if (!this.compoundPrescriptionDetail) {
			this.compoundPrescriptionDetailId = null;
		} else {
			this.compoundPrescriptionDetailId = this.compoundPrescriptionDetail.id;
		}

		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
		}

		if (!this.unit) {
			this.unitId = null;
		} else {
			this.unitId = this.unit.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
