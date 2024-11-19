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
export class BpjsBedAvailabilityModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'koderuang',
		'namaruang',
		'kodekelas',
		'namakelas',
		'lastupdate',
		'kapasitas',
		'tersedia',
		'tersediapria',
		'tersediawanita',
		'tersediapriawanita',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'koderuang',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsBedAvailabilityModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsBedAvailabilityModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	koderuang: string;

	/**
	 * .
	 */
	namaruang: string;

	/**
	 * .
	 */
	kodekelas: string;

	/**
	 * .
	 */
	namakelas: string;

	/**
	 * .
	 */
	lastupdate: string;

	/**
	 * .
	 */
	kapasitas: number;

	/**
	 * .
	 */
	tersedia: number;

	/**
	 * .
	 */
	tersediapria: number;

	/**
	 * .
	 */
	tersediawanita: number;

	/**
	 * .
	 */
	tersediapriawanita: number;



	modelPropGroups: { [s: string]: Group } = BpjsBedAvailabilityModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'koderuang',
				// % protected region % [Set displayName for koderuang here] off begin
				displayName: 'koderuang',
				// % protected region % [Set displayName for koderuang here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for koderuang here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for koderuang here] end
				// % protected region % [Set isSensitive for koderuang here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for koderuang here] end
				// % protected region % [Set readonly for koderuang here] off begin
				readOnly: false,
				// % protected region % [Set readonly for koderuang here] end
				validators: [
					// % protected region % [Add other validators for koderuang here] off begin
					// % protected region % [Add other validators for koderuang here] end
				],
				// % protected region % [Add any additional model attribute properties for koderuang here] off begin
				// % protected region % [Add any additional model attribute properties for koderuang here] end
			},
			{
				name: 'namaruang',
				// % protected region % [Set displayName for namaruang here] off begin
				displayName: 'namaruang',
				// % protected region % [Set displayName for namaruang here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for namaruang here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for namaruang here] end
				// % protected region % [Set isSensitive for namaruang here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for namaruang here] end
				// % protected region % [Set readonly for namaruang here] off begin
				readOnly: false,
				// % protected region % [Set readonly for namaruang here] end
				validators: [
					// % protected region % [Add other validators for namaruang here] off begin
					// % protected region % [Add other validators for namaruang here] end
				],
				// % protected region % [Add any additional model attribute properties for namaruang here] off begin
				// % protected region % [Add any additional model attribute properties for namaruang here] end
			},
			{
				name: 'kodekelas',
				// % protected region % [Set displayName for kodekelas here] off begin
				displayName: 'kodekelas',
				// % protected region % [Set displayName for kodekelas here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodekelas here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodekelas here] end
				// % protected region % [Set isSensitive for kodekelas here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodekelas here] end
				// % protected region % [Set readonly for kodekelas here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodekelas here] end
				validators: [
					// % protected region % [Add other validators for kodekelas here] off begin
					// % protected region % [Add other validators for kodekelas here] end
				],
				// % protected region % [Add any additional model attribute properties for kodekelas here] off begin
				// % protected region % [Add any additional model attribute properties for kodekelas here] end
			},
			{
				name: 'namakelas',
				// % protected region % [Set displayName for namakelas here] off begin
				displayName: 'namakelas',
				// % protected region % [Set displayName for namakelas here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for namakelas here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for namakelas here] end
				// % protected region % [Set isSensitive for namakelas here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for namakelas here] end
				// % protected region % [Set readonly for namakelas here] off begin
				readOnly: false,
				// % protected region % [Set readonly for namakelas here] end
				validators: [
					// % protected region % [Add other validators for namakelas here] off begin
					// % protected region % [Add other validators for namakelas here] end
				],
				// % protected region % [Add any additional model attribute properties for namakelas here] off begin
				// % protected region % [Add any additional model attribute properties for namakelas here] end
			},
			{
				name: 'lastupdate',
				// % protected region % [Set displayName for lastupdate here] off begin
				displayName: 'lastupdate',
				// % protected region % [Set displayName for lastupdate here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for lastupdate here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for lastupdate here] end
				// % protected region % [Set isSensitive for lastupdate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for lastupdate here] end
				// % protected region % [Set readonly for lastupdate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for lastupdate here] end
				validators: [
					// % protected region % [Add other validators for lastupdate here] off begin
					// % protected region % [Add other validators for lastupdate here] end
				],
				// % protected region % [Add any additional model attribute properties for lastupdate here] off begin
				// % protected region % [Add any additional model attribute properties for lastupdate here] end
			},
			{
				name: 'kapasitas',
				// % protected region % [Set displayName for kapasitas here] off begin
				displayName: 'kapasitas',
				// % protected region % [Set displayName for kapasitas here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for kapasitas here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for kapasitas here] end
				// % protected region % [Set isSensitive for kapasitas here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kapasitas here] end
				// % protected region % [Set readonly for kapasitas here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kapasitas here] end
				validators: [
					// % protected region % [Add other validators for kapasitas here] off begin
					// % protected region % [Add other validators for kapasitas here] end
				],
				// % protected region % [Add any additional model attribute properties for kapasitas here] off begin
				// % protected region % [Add any additional model attribute properties for kapasitas here] end
			},
			{
				name: 'tersedia',
				// % protected region % [Set displayName for tersedia here] off begin
				displayName: 'tersedia',
				// % protected region % [Set displayName for tersedia here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for tersedia here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for tersedia here] end
				// % protected region % [Set isSensitive for tersedia here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tersedia here] end
				// % protected region % [Set readonly for tersedia here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tersedia here] end
				validators: [
					// % protected region % [Add other validators for tersedia here] off begin
					// % protected region % [Add other validators for tersedia here] end
				],
				// % protected region % [Add any additional model attribute properties for tersedia here] off begin
				// % protected region % [Add any additional model attribute properties for tersedia here] end
			},
			{
				name: 'tersediapria',
				// % protected region % [Set displayName for tersediapria here] off begin
				displayName: 'tersediapria',
				// % protected region % [Set displayName for tersediapria here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for tersediapria here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for tersediapria here] end
				// % protected region % [Set isSensitive for tersediapria here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tersediapria here] end
				// % protected region % [Set readonly for tersediapria here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tersediapria here] end
				validators: [
					// % protected region % [Add other validators for tersediapria here] off begin
					// % protected region % [Add other validators for tersediapria here] end
				],
				// % protected region % [Add any additional model attribute properties for tersediapria here] off begin
				// % protected region % [Add any additional model attribute properties for tersediapria here] end
			},
			{
				name: 'tersediawanita',
				// % protected region % [Set displayName for tersediawanita here] off begin
				displayName: 'tersediawanita',
				// % protected region % [Set displayName for tersediawanita here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for tersediawanita here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for tersediawanita here] end
				// % protected region % [Set isSensitive for tersediawanita here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tersediawanita here] end
				// % protected region % [Set readonly for tersediawanita here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tersediawanita here] end
				validators: [
					// % protected region % [Add other validators for tersediawanita here] off begin
					// % protected region % [Add other validators for tersediawanita here] end
				],
				// % protected region % [Add any additional model attribute properties for tersediawanita here] off begin
				// % protected region % [Add any additional model attribute properties for tersediawanita here] end
			},
			{
				name: 'tersediapriawanita',
				// % protected region % [Set displayName for tersediapriawanita here] off begin
				displayName: 'tersediapriawanita',
				// % protected region % [Set displayName for tersediapriawanita here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for tersediapriawanita here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for tersediapriawanita here] end
				// % protected region % [Set isSensitive for tersediapriawanita here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tersediapriawanita here] end
				// % protected region % [Set readonly for tersediapriawanita here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tersediapriawanita here] end
				validators: [
					// % protected region % [Add other validators for tersediapriawanita here] off begin
					// % protected region % [Add other validators for tersediapriawanita here] end
				],
				// % protected region % [Add any additional model attribute properties for tersediapriawanita here] off begin
				// % protected region % [Add any additional model attribute properties for tersediapriawanita here] end
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
				case 'koderuang':
					break;
				case 'namaruang':
					break;
				case 'kodekelas':
					break;
				case 'namakelas':
					break;
				case 'lastupdate':
					break;
				case 'kapasitas':
					break;
				case 'tersedia':
					break;
				case 'tersediapria':
					break;
				case 'tersediawanita':
					break;
				case 'tersediapriawanita':
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
	static deepParse(data: string | { [K in keyof BpjsBedAvailabilityModel]?: BpjsBedAvailabilityModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsBedAvailabilityModel(data);
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
	 * `let bpjsBedAvailabilityModel = new BpjsBedAvailabilityModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsBedAvailabilityModel,
	 *    it is expected as a JSON string or as a nullable BpjsBedAvailabilityModel.
	 */
	constructor(data?: string | Partial<BpjsBedAvailabilityModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsBedAvailabilityModel>
				: data;

			this.koderuang = json.koderuang;
			this.namaruang = json.namaruang;
			this.kodekelas = json.kodekelas;
			this.namakelas = json.namakelas;
			this.lastupdate = json.lastupdate;
			this.kapasitas = json.kapasitas;
			this.tersedia = json.tersedia;
			this.tersediapria = json.tersediapria;
			this.tersediawanita = json.tersediawanita;
			this.tersediapriawanita = json.tersediapriawanita;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			koderuang: this.koderuang,
			namaruang: this.namaruang,
			kodekelas: this.kodekelas,
			namakelas: this.namakelas,
			lastupdate: this.lastupdate,
			kapasitas: this.kapasitas,
			tersedia: this.tersedia,
			tersediapria: this.tersediapria,
			tersediawanita: this.tersediawanita,
			tersediapriawanita: this.tersediapriawanita,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsBedAvailabilityModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsBedAvailabilityModel {
		let newModelJson = this.toJSON();

		if (updates.koderuang) {
			newModelJson.koderuang = updates.koderuang;
		}

		if (updates.namaruang) {
			newModelJson.namaruang = updates.namaruang;
		}

		if (updates.kodekelas) {
			newModelJson.kodekelas = updates.kodekelas;
		}

		if (updates.namakelas) {
			newModelJson.namakelas = updates.namakelas;
		}

		if (updates.lastupdate) {
			newModelJson.lastupdate = updates.lastupdate;
		}

		if (updates.kapasitas) {
			newModelJson.kapasitas = updates.kapasitas;
		}

		if (updates.tersedia) {
			newModelJson.tersedia = updates.tersedia;
		}

		if (updates.tersediapria) {
			newModelJson.tersediapria = updates.tersediapria;
		}

		if (updates.tersediawanita) {
			newModelJson.tersediawanita = updates.tersediawanita;
		}

		if (updates.tersediapriawanita) {
			newModelJson.tersediapriawanita = updates.tersediapriawanita;
		}

		return new BpjsBedAvailabilityModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsBedAvailabilityModel)) {
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
