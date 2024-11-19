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
import {PcareCompoundDrugModel} from '../pcareCompoundDrug/pcare_compound_drug.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PcareCompoundDrugItemModel extends AbstractModel {
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
		'drugCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PcareCompoundDrugItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PcareCompoundDrugItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	drugCode: string;

	/**
	 * Drug Qty - Jumlah Obat.
	 */
	drugQty: number;

	/**
	 * Request - Permintaan.
	 */
	request: number;

	/**
	 * Dose - Kekuatan.
	 */
	dose: number;

	pcareCompoundDrugId: string;

	pcareCompoundDrug: PcareCompoundDrugModel;

	modelPropGroups: { [s: string]: Group } = PcareCompoundDrugItemModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'drugCode',
				// % protected region % [Set displayName for Drug Code here] off begin
				displayName: 'Drug Code',
				// % protected region % [Set displayName for Drug Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Drug Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Drug Code here] end
				// % protected region % [Set isSensitive for Drug Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drug Code here] end
				// % protected region % [Set readonly for Drug Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drug Code here] end
				validators: [
					// % protected region % [Add other validators for Drug Code here] off begin
					// % protected region % [Add other validators for Drug Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Drug Code here] off begin
				// % protected region % [Add any additional model attribute properties for Drug Code here] end
			},
			{
				name: 'drugQty',
				// % protected region % [Set displayName for Drug Qty here] off begin
				displayName: 'Drug Qty',
				// % protected region % [Set displayName for Drug Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Drug Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Drug Qty here] end
				// % protected region % [Set isSensitive for Drug Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drug Qty here] end
				// % protected region % [Set readonly for Drug Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drug Qty here] end
				validators: [
					// % protected region % [Add other validators for Drug Qty here] off begin
					// % protected region % [Add other validators for Drug Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Drug Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Drug Qty here] end
			},
			{
				name: 'request',
				// % protected region % [Set displayName for Request here] off begin
				displayName: 'Request',
				// % protected region % [Set displayName for Request here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Request here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Request here] end
				// % protected region % [Set isSensitive for Request here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Request here] end
				// % protected region % [Set readonly for Request here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Request here] end
				validators: [
					// % protected region % [Add other validators for Request here] off begin
					// % protected region % [Add other validators for Request here] end
				],
				// % protected region % [Add any additional model attribute properties for Request here] off begin
				// % protected region % [Add any additional model attribute properties for Request here] end
			},
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
				id: 'pcareCompoundDrug',
				type: ModelRelationType.ONE,
				name: 'pcareCompoundDrugId',
				// % protected region % [Customise your label for PCare Compound Drug here] off begin
				label: 'PCare Compound Drug',
				// % protected region % [Customise your label for PCare Compound Drug here] end
				entityName: 'PcareCompoundDrugModel',
				// % protected region % [Customise your display name for PCare Compound Drug here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'compoundName',
				// % protected region % [Customise your display name for PCare Compound Drug here] end
				validators: [
					// % protected region % [Add other validators for PCare Compound Drug here] off begin
					// % protected region % [Add other validators for PCare Compound Drug here] end
				],
				// % protected region % [Add any additional field for relation PCare Compound Drug here] off begin
				// % protected region % [Add any additional field for relation PCare Compound Drug here] end
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
	static deepParse(data: string | { [K in keyof PcareCompoundDrugItemModel]?: PcareCompoundDrugItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PcareCompoundDrugItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.pcareCompoundDrug) {
			currentModel.pcareCompoundDrugId = json.pcareCompoundDrug.id;
			returned = _.union(returned, PcareCompoundDrugModel.deepParse(json.pcareCompoundDrug));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let pcareCompoundDrugItemModel = new PcareCompoundDrugItemModel(data);`
	 *
	 * @param data The input data to be initialised as the PcareCompoundDrugItemModel,
	 *    it is expected as a JSON string or as a nullable PcareCompoundDrugItemModel.
	 */
	constructor(data?: string | Partial<PcareCompoundDrugItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PcareCompoundDrugItemModel>
				: data;

			this.drugCode = json.drugCode;
			this.drugQty = json.drugQty;
			this.request = json.request;
			this.dose = json.dose;
			this.pcareCompoundDrugId = json.pcareCompoundDrugId;
			this.pcareCompoundDrug = json.pcareCompoundDrug;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			drugCode: this.drugCode,
			drugQty: this.drugQty,
			request: this.request,
			dose: this.dose,
			pcareCompoundDrugId: this.pcareCompoundDrugId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PcareCompoundDrugItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PcareCompoundDrugItemModel {
		let newModelJson = this.toJSON();

		if (updates.drugCode) {
			newModelJson.drugCode = updates.drugCode;
		}

		if (updates.drugQty) {
			newModelJson.drugQty = updates.drugQty;
		}

		if (updates.request) {
			newModelJson.request = updates.request;
		}

		if (updates.dose) {
			newModelJson.dose = updates.dose;
		}

		if (updates.pcareCompoundDrugId) {
			newModelJson.pcareCompoundDrugId = updates.pcareCompoundDrugId;
		}

		return new PcareCompoundDrugItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PcareCompoundDrugItemModel)) {
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
			'pcareCompoundDrugId',
			'pcareCompoundDrug',
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
		if (!this.pcareCompoundDrug) {
			this.pcareCompoundDrugId = null;
		} else {
			this.pcareCompoundDrugId = this.pcareCompoundDrug.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
