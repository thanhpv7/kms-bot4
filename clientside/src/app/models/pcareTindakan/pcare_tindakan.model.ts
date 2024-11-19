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
export class PcareTindakanModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'kodeTindakan',
		'namaTindakan',
		'maksimalTarif',
		'withvalue',
		'tindakanInternal',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'kodeTindakan',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PcareTindakanModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PcareTindakanModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	kodeTindakan: string;

	/**
	 * .
	 */
	namaTindakan: string;

	/**
	 * .
	 */
	maksimalTarif: string;

	/**
	 * .
	 */
	withvalue: boolean = false;

	/**
	 * .
	 */
	tindakanInternal: string;



	modelPropGroups: { [s: string]: Group } = PcareTindakanModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'kodeTindakan',
				// % protected region % [Set displayName for Kode Tindakan here] off begin
				displayName: 'Kode Tindakan',
				// % protected region % [Set displayName for Kode Tindakan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kode Tindakan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kode Tindakan here] end
				// % protected region % [Set isSensitive for Kode Tindakan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kode Tindakan here] end
				// % protected region % [Set readonly for Kode Tindakan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kode Tindakan here] end
				validators: [
					// % protected region % [Add other validators for Kode Tindakan here] off begin
					// % protected region % [Add other validators for Kode Tindakan here] end
				],
				// % protected region % [Add any additional model attribute properties for Kode Tindakan here] off begin
				// % protected region % [Add any additional model attribute properties for Kode Tindakan here] end
			},
			{
				name: 'namaTindakan',
				// % protected region % [Set displayName for Nama Tindakan here] off begin
				displayName: 'Nama Tindakan',
				// % protected region % [Set displayName for Nama Tindakan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nama Tindakan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nama Tindakan here] end
				// % protected region % [Set isSensitive for Nama Tindakan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nama Tindakan here] end
				// % protected region % [Set readonly for Nama Tindakan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nama Tindakan here] end
				validators: [
					// % protected region % [Add other validators for Nama Tindakan here] off begin
					// % protected region % [Add other validators for Nama Tindakan here] end
				],
				// % protected region % [Add any additional model attribute properties for Nama Tindakan here] off begin
				// % protected region % [Add any additional model attribute properties for Nama Tindakan here] end
			},
			{
				name: 'maksimalTarif',
				// % protected region % [Set displayName for Maksimal Tarif here] off begin
				displayName: 'Maksimal Tarif',
				// % protected region % [Set displayName for Maksimal Tarif here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Maksimal Tarif here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Maksimal Tarif here] end
				// % protected region % [Set isSensitive for Maksimal Tarif here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Maksimal Tarif here] end
				// % protected region % [Set readonly for Maksimal Tarif here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Maksimal Tarif here] end
				validators: [
					// % protected region % [Add other validators for Maksimal Tarif here] off begin
					// % protected region % [Add other validators for Maksimal Tarif here] end
				],
				// % protected region % [Add any additional model attribute properties for Maksimal Tarif here] off begin
				// % protected region % [Add any additional model attribute properties for Maksimal Tarif here] end
			},
			{
				name: 'withvalue',
				// % protected region % [Set displayName for withValue here] off begin
				displayName: 'withValue',
				// % protected region % [Set displayName for withValue here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for withValue here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for withValue here] end
				// % protected region % [Set isSensitive for withValue here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for withValue here] end
				// % protected region % [Set readonly for withValue here] off begin
				readOnly: false,
				// % protected region % [Set readonly for withValue here] end
				validators: [
					// % protected region % [Add other validators for withValue here] off begin
					// % protected region % [Add other validators for withValue here] end
				],
				// % protected region % [Add any additional model attribute properties for withValue here] off begin
				// % protected region % [Add any additional model attribute properties for withValue here] end
			},
			{
				name: 'tindakanInternal',
				// % protected region % [Set displayName for Tindakan Internal here] off begin
				displayName: 'Tindakan Internal',
				// % protected region % [Set displayName for Tindakan Internal here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tindakan Internal here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tindakan Internal here] end
				// % protected region % [Set isSensitive for Tindakan Internal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tindakan Internal here] end
				// % protected region % [Set readonly for Tindakan Internal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tindakan Internal here] end
				validators: [
					// % protected region % [Add other validators for Tindakan Internal here] off begin
					// % protected region % [Add other validators for Tindakan Internal here] end
				],
				// % protected region % [Add any additional model attribute properties for Tindakan Internal here] off begin
				// % protected region % [Add any additional model attribute properties for Tindakan Internal here] end
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
				case 'kodeTindakan':
					break;
				case 'namaTindakan':
					break;
				case 'maksimalTarif':
					break;
				case 'withvalue':
					break;
				case 'tindakanInternal':
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
	static deepParse(data: string | { [K in keyof PcareTindakanModel]?: PcareTindakanModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PcareTindakanModel(data);
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
	 * `let pcareTindakanModel = new PcareTindakanModel(data);`
	 *
	 * @param data The input data to be initialised as the PcareTindakanModel,
	 *    it is expected as a JSON string or as a nullable PcareTindakanModel.
	 */
	constructor(data?: string | Partial<PcareTindakanModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PcareTindakanModel>
				: data;

			this.kodeTindakan = json.kodeTindakan;
			this.namaTindakan = json.namaTindakan;
			this.maksimalTarif = json.maksimalTarif;
			this.withvalue = json.withvalue;
			this.tindakanInternal = json.tindakanInternal;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			kodeTindakan: this.kodeTindakan,
			namaTindakan: this.namaTindakan,
			maksimalTarif: this.maksimalTarif,
			withvalue: this.withvalue,
			tindakanInternal: this.tindakanInternal,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PcareTindakanModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PcareTindakanModel {
		let newModelJson = this.toJSON();

		if (updates.kodeTindakan) {
			newModelJson.kodeTindakan = updates.kodeTindakan;
		}

		if (updates.namaTindakan) {
			newModelJson.namaTindakan = updates.namaTindakan;
		}

		if (updates.maksimalTarif) {
			newModelJson.maksimalTarif = updates.maksimalTarif;
		}

		if (updates.withvalue) {
			newModelJson.withvalue = updates.withvalue;
		}

		if (updates.tindakanInternal) {
			newModelJson.tindakanInternal = updates.tindakanInternal;
		}

		return new PcareTindakanModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PcareTindakanModel)) {
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
