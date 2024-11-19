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
import {StockCatalogueModel} from '../stockCatalogue/stock_catalogue.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class CatalogueMedicalModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'inventoryRoundingAmount',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'composition',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'CatalogueMedicalModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return CatalogueMedicalModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Detail Composition of stock, if any (Max Length: 500).
	 */
	composition: string;

	/**
	 * Indicator whether the stock can be prescribed to patient or not.
	 */
	canBePrescribed: boolean = false;

	/**
	 * Is Hospital Formulary.
	 */
	isHospitalFormulary: boolean = false;

	/**
	 * Approval Notes (Max Length: 500).
	 */
	approvalNotes: string;

	/**
	 * Is Generic.
	 */
	isGeneric: boolean = false;

	/**
	 * Is Restirected.
	 */
	isRestricted: boolean = false;

	/**
	 * Is Vaccine.
	 */
	isVaccine: boolean = false;

	/**
	 * Vaccine Type, get the Code from Reference Data where Type=VACC_TYPE. (Max Length: 20).
	 */
	vaccineType: string;

	/**
	 * Consumption Method, get the Code from Reference Data where Type=CNSM_MTD. (Max Length: 20).
	 */
	consumptionMethod: string;

	/**
	 * Consumption Unit, get the Unit Name from Unit Of Measuement entity where Consumption Unit indicator is TRUE.
	 */
	consumptionUnit: string;

	/**
	 * Indicator whether the Charging is rounded or not.
	 */
	compoundChargingRounding: boolean = false;

	/**
	 * Compound Charging Rounding Amount, get the Code from Reference Data where Type=RND_CMP_CHARGING. (Max Length: 20).
	 */
	compoundChargingRoundingAmount: string;

	/**
	 * Inventory Rounding.
	 */
	inventoryRounding: boolean = false;

	/**
	 * Inventory Rounding Amount.
	 */
	inventoryRoundingAmount: number;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	modelPropGroups: { [s: string]: Group } = CatalogueMedicalModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'composition',
				// % protected region % [Set displayName for Composition here] off begin
				displayName: 'Composition',
				// % protected region % [Set displayName for Composition here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Composition here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Composition here] end
				// % protected region % [Set isSensitive for Composition here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Composition here] end
				// % protected region % [Set readonly for Composition here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Composition here] end
				validators: [
					// % protected region % [Add other validators for Composition here] off begin
					// % protected region % [Add other validators for Composition here] end
				],
				// % protected region % [Add any additional model attribute properties for Composition here] off begin
				// % protected region % [Add any additional model attribute properties for Composition here] end
			},
			{
				name: 'canBePrescribed',
				// % protected region % [Set displayName for Can be prescribed here] off begin
				displayName: 'Can be prescribed',
				// % protected region % [Set displayName for Can be prescribed here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Can be prescribed here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Can be prescribed here] end
				// % protected region % [Set isSensitive for Can be prescribed here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Can be prescribed here] end
				// % protected region % [Set readonly for Can be prescribed here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Can be prescribed here] end
				validators: [
					// % protected region % [Add other validators for Can be prescribed here] off begin
					// % protected region % [Add other validators for Can be prescribed here] end
				],
				// % protected region % [Add any additional model attribute properties for Can be prescribed here] off begin
				// % protected region % [Add any additional model attribute properties for Can be prescribed here] end
			},
			{
				name: 'isHospitalFormulary',
				// % protected region % [Set displayName for Is Hospital Formulary here] off begin
				displayName: 'Is Hospital Formulary',
				// % protected region % [Set displayName for Is Hospital Formulary here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Hospital Formulary here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Hospital Formulary here] end
				// % protected region % [Set isSensitive for Is Hospital Formulary here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Hospital Formulary here] end
				// % protected region % [Set readonly for Is Hospital Formulary here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Hospital Formulary here] end
				validators: [
					// % protected region % [Add other validators for Is Hospital Formulary here] off begin
					// % protected region % [Add other validators for Is Hospital Formulary here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Hospital Formulary here] off begin
				// % protected region % [Add any additional model attribute properties for Is Hospital Formulary here] end
			},
			{
				name: 'approvalNotes',
				// % protected region % [Set displayName for Approval Notes here] off begin
				displayName: 'Approval Notes',
				// % protected region % [Set displayName for Approval Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Approval Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Approval Notes here] end
				// % protected region % [Set isSensitive for Approval Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approval Notes here] end
				// % protected region % [Set readonly for Approval Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approval Notes here] end
				validators: [
					// % protected region % [Add other validators for Approval Notes here] off begin
					// % protected region % [Add other validators for Approval Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Approval Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Approval Notes here] end
			},
			{
				name: 'isGeneric',
				// % protected region % [Set displayName for Is Generic here] off begin
				displayName: 'Is Generic',
				// % protected region % [Set displayName for Is Generic here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Generic here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Generic here] end
				// % protected region % [Set isSensitive for Is Generic here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Generic here] end
				// % protected region % [Set readonly for Is Generic here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Generic here] end
				validators: [
					// % protected region % [Add other validators for Is Generic here] off begin
					// % protected region % [Add other validators for Is Generic here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Generic here] off begin
				// % protected region % [Add any additional model attribute properties for Is Generic here] end
			},
			{
				name: 'isRestricted',
				// % protected region % [Set displayName for Is Restricted here] off begin
				displayName: 'Is Restricted',
				// % protected region % [Set displayName for Is Restricted here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Restricted here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Restricted here] end
				// % protected region % [Set isSensitive for Is Restricted here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Restricted here] end
				// % protected region % [Set readonly for Is Restricted here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Restricted here] end
				validators: [
					// % protected region % [Add other validators for Is Restricted here] off begin
					// % protected region % [Add other validators for Is Restricted here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Restricted here] off begin
				// % protected region % [Add any additional model attribute properties for Is Restricted here] end
			},
			{
				name: 'isVaccine',
				// % protected region % [Set displayName for Is Vaccine here] off begin
				displayName: 'Is Vaccine',
				// % protected region % [Set displayName for Is Vaccine here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Vaccine here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Vaccine here] end
				// % protected region % [Set isSensitive for Is Vaccine here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Vaccine here] end
				// % protected region % [Set readonly for Is Vaccine here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Vaccine here] end
				validators: [
					// % protected region % [Add other validators for Is Vaccine here] off begin
					// % protected region % [Add other validators for Is Vaccine here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Vaccine here] off begin
				// % protected region % [Add any additional model attribute properties for Is Vaccine here] end
			},
			{
				name: 'vaccineType',
				// % protected region % [Set displayName for Vaccine Type here] off begin
				displayName: 'Vaccine Type',
				// % protected region % [Set displayName for Vaccine Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Vaccine Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Vaccine Type here] end
				// % protected region % [Set isSensitive for Vaccine Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Vaccine Type here] end
				// % protected region % [Set readonly for Vaccine Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Vaccine Type here] end
				validators: [
					// % protected region % [Add other validators for Vaccine Type here] off begin
					// % protected region % [Add other validators for Vaccine Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Vaccine Type here] off begin
				// % protected region % [Add any additional model attribute properties for Vaccine Type here] end
			},
			{
				name: 'consumptionMethod',
				// % protected region % [Set displayName for Consumption Method here] off begin
				displayName: 'Consumption Method',
				// % protected region % [Set displayName for Consumption Method here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consumption Method here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consumption Method here] end
				// % protected region % [Set isSensitive for Consumption Method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consumption Method here] end
				// % protected region % [Set readonly for Consumption Method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consumption Method here] end
				validators: [
					// % protected region % [Add other validators for Consumption Method here] off begin
					// % protected region % [Add other validators for Consumption Method here] end
				],
				// % protected region % [Add any additional model attribute properties for Consumption Method here] off begin
				// % protected region % [Add any additional model attribute properties for Consumption Method here] end
			},
			{
				name: 'consumptionUnit',
				// % protected region % [Set displayName for Consumption Unit here] off begin
				displayName: 'Consumption Unit',
				// % protected region % [Set displayName for Consumption Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consumption Unit here] off begin
				elementType: ElementType.INPUT,
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
			{
				name: 'compoundChargingRounding',
				// % protected region % [Set displayName for Compound Charging Rounding here] off begin
				displayName: 'Compound Charging Rounding',
				// % protected region % [Set displayName for Compound Charging Rounding here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Compound Charging Rounding here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Compound Charging Rounding here] end
				// % protected region % [Set isSensitive for Compound Charging Rounding here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Compound Charging Rounding here] end
				// % protected region % [Set readonly for Compound Charging Rounding here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Compound Charging Rounding here] end
				validators: [
					// % protected region % [Add other validators for Compound Charging Rounding here] off begin
					// % protected region % [Add other validators for Compound Charging Rounding here] end
				],
				// % protected region % [Add any additional model attribute properties for Compound Charging Rounding here] off begin
				// % protected region % [Add any additional model attribute properties for Compound Charging Rounding here] end
			},
			{
				name: 'compoundChargingRoundingAmount',
				// % protected region % [Set displayName for Compound Charging Rounding Amount here] off begin
				displayName: 'Compound Charging Rounding Amount',
				// % protected region % [Set displayName for Compound Charging Rounding Amount here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Compound Charging Rounding Amount here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Compound Charging Rounding Amount here] end
				// % protected region % [Set isSensitive for Compound Charging Rounding Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Compound Charging Rounding Amount here] end
				// % protected region % [Set readonly for Compound Charging Rounding Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Compound Charging Rounding Amount here] end
				validators: [
					// % protected region % [Add other validators for Compound Charging Rounding Amount here] off begin
					// % protected region % [Add other validators for Compound Charging Rounding Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Compound Charging Rounding Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Compound Charging Rounding Amount here] end
			},
			{
				name: 'inventoryRounding',
				// % protected region % [Set displayName for Inventory Rounding here] off begin
				displayName: 'Inventory Rounding',
				// % protected region % [Set displayName for Inventory Rounding here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Inventory Rounding here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Inventory Rounding here] end
				// % protected region % [Set isSensitive for Inventory Rounding here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inventory Rounding here] end
				// % protected region % [Set readonly for Inventory Rounding here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inventory Rounding here] end
				validators: [
					// % protected region % [Add other validators for Inventory Rounding here] off begin
					// % protected region % [Add other validators for Inventory Rounding here] end
				],
				// % protected region % [Add any additional model attribute properties for Inventory Rounding here] off begin
				// % protected region % [Add any additional model attribute properties for Inventory Rounding here] end
			},
			{
				name: 'inventoryRoundingAmount',
				// % protected region % [Set displayName for Inventory Rounding Amount here] off begin
				displayName: 'Inventory Rounding Amount',
				// % protected region % [Set displayName for Inventory Rounding Amount here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Inventory Rounding Amount here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Inventory Rounding Amount here] end
				// % protected region % [Set isSensitive for Inventory Rounding Amount here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inventory Rounding Amount here] end
				// % protected region % [Set readonly for Inventory Rounding Amount here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inventory Rounding Amount here] end
				validators: [
					// % protected region % [Add other validators for Inventory Rounding Amount here] off begin
					// % protected region % [Add other validators for Inventory Rounding Amount here] end
				],
				// % protected region % [Add any additional model attribute properties for Inventory Rounding Amount here] off begin
				// % protected region % [Add any additional model attribute properties for Inventory Rounding Amount here] end
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
				case 'inventoryRoundingAmount':
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
	static deepParse(data: string | { [K in keyof CatalogueMedicalModel]?: CatalogueMedicalModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new CatalogueMedicalModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let catalogueMedicalModel = new CatalogueMedicalModel(data);`
	 *
	 * @param data The input data to be initialised as the CatalogueMedicalModel,
	 *    it is expected as a JSON string or as a nullable CatalogueMedicalModel.
	 */
	constructor(data?: string | Partial<CatalogueMedicalModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<CatalogueMedicalModel>
				: data;

			this.composition = json.composition;
			this.canBePrescribed = json.canBePrescribed;
			this.isHospitalFormulary = json.isHospitalFormulary;
			this.approvalNotes = json.approvalNotes;
			this.isGeneric = json.isGeneric;
			this.isRestricted = json.isRestricted;
			this.isVaccine = json.isVaccine;
			this.vaccineType = json.vaccineType;
			this.consumptionMethod = json.consumptionMethod;
			this.consumptionUnit = json.consumptionUnit;
			this.compoundChargingRounding = json.compoundChargingRounding;
			this.compoundChargingRoundingAmount = json.compoundChargingRoundingAmount;
			this.inventoryRounding = json.inventoryRounding;
			this.inventoryRoundingAmount = json.inventoryRoundingAmount;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			composition: this.composition,
			canBePrescribed: this.canBePrescribed,
			isHospitalFormulary: this.isHospitalFormulary,
			approvalNotes: this.approvalNotes,
			isGeneric: this.isGeneric,
			isRestricted: this.isRestricted,
			isVaccine: this.isVaccine,
			vaccineType: this.vaccineType,
			consumptionMethod: this.consumptionMethod,
			consumptionUnit: this.consumptionUnit,
			compoundChargingRounding: this.compoundChargingRounding,
			compoundChargingRoundingAmount: this.compoundChargingRoundingAmount,
			inventoryRounding: this.inventoryRounding,
			inventoryRoundingAmount: this.inventoryRoundingAmount,
			stockCatalogueId: this.stockCatalogueId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		CatalogueMedicalModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): CatalogueMedicalModel {
		let newModelJson = this.toJSON();

		if (updates.composition) {
			newModelJson.composition = updates.composition;
		}

		if (updates.canBePrescribed) {
			newModelJson.canBePrescribed = updates.canBePrescribed;
		}

		if (updates.isHospitalFormulary) {
			newModelJson.isHospitalFormulary = updates.isHospitalFormulary;
		}

		if (updates.approvalNotes) {
			newModelJson.approvalNotes = updates.approvalNotes;
		}

		if (updates.isGeneric) {
			newModelJson.isGeneric = updates.isGeneric;
		}

		if (updates.isRestricted) {
			newModelJson.isRestricted = updates.isRestricted;
		}

		if (updates.isVaccine) {
			newModelJson.isVaccine = updates.isVaccine;
		}

		if (updates.vaccineType) {
			newModelJson.vaccineType = updates.vaccineType;
		}

		if (updates.consumptionMethod) {
			newModelJson.consumptionMethod = updates.consumptionMethod;
		}

		if (updates.consumptionUnit) {
			newModelJson.consumptionUnit = updates.consumptionUnit;
		}

		if (updates.compoundChargingRounding) {
			newModelJson.compoundChargingRounding = updates.compoundChargingRounding;
		}

		if (updates.compoundChargingRoundingAmount) {
			newModelJson.compoundChargingRoundingAmount = updates.compoundChargingRoundingAmount;
		}

		if (updates.inventoryRounding) {
			newModelJson.inventoryRounding = updates.inventoryRounding;
		}

		if (updates.inventoryRoundingAmount) {
			newModelJson.inventoryRoundingAmount = updates.inventoryRoundingAmount;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		return new CatalogueMedicalModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof CatalogueMedicalModel)) {
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
			'stockCatalogueId',
			'stockCatalogue',
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
		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
