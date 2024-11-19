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
export class PcareClubProlanisModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'clubID',
		'kodeProgram',
		'namaProgram',
		'tanggalMulai',
		'tanggalAkhir',
		'alamatClub',
		'namaClub',
		'noHPKetua',
		'namaKetua',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'clubID',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PcareClubProlanisModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PcareClubProlanisModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	clubID: string;

	/**
	 * .
	 */
	kodeProgram: string;

	/**
	 * .
	 */
	namaProgram: string;

	/**
	 * .
	 */
	tanggalMulai: string;

	/**
	 * .
	 */
	tanggalAkhir: string;

	/**
	 * .
	 */
	alamatClub: string;

	/**
	 * .
	 */
	namaClub: string;

	/**
	 * .
	 */
	noHPKetua: string;

	/**
	 * .
	 */
	namaKetua: string;



	modelPropGroups: { [s: string]: Group } = PcareClubProlanisModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'clubID',
				// % protected region % [Set displayName for Club ID here] off begin
				displayName: 'Club ID',
				// % protected region % [Set displayName for Club ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Club ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Club ID here] end
				// % protected region % [Set isSensitive for Club ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Club ID here] end
				// % protected region % [Set readonly for Club ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Club ID here] end
				validators: [
					// % protected region % [Add other validators for Club ID here] off begin
					// % protected region % [Add other validators for Club ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Club ID here] off begin
				// % protected region % [Add any additional model attribute properties for Club ID here] end
			},
			{
				name: 'kodeProgram',
				// % protected region % [Set displayName for Kode Program here] off begin
				displayName: 'Kode Program',
				// % protected region % [Set displayName for Kode Program here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kode Program here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kode Program here] end
				// % protected region % [Set isSensitive for Kode Program here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kode Program here] end
				// % protected region % [Set readonly for Kode Program here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kode Program here] end
				validators: [
					// % protected region % [Add other validators for Kode Program here] off begin
					// % protected region % [Add other validators for Kode Program here] end
				],
				// % protected region % [Add any additional model attribute properties for Kode Program here] off begin
				// % protected region % [Add any additional model attribute properties for Kode Program here] end
			},
			{
				name: 'namaProgram',
				// % protected region % [Set displayName for Nama Program here] off begin
				displayName: 'Nama Program',
				// % protected region % [Set displayName for Nama Program here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nama Program here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nama Program here] end
				// % protected region % [Set isSensitive for Nama Program here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nama Program here] end
				// % protected region % [Set readonly for Nama Program here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nama Program here] end
				validators: [
					// % protected region % [Add other validators for Nama Program here] off begin
					// % protected region % [Add other validators for Nama Program here] end
				],
				// % protected region % [Add any additional model attribute properties for Nama Program here] off begin
				// % protected region % [Add any additional model attribute properties for Nama Program here] end
			},
			{
				name: 'tanggalMulai',
				// % protected region % [Set displayName for Tanggal Mulai here] off begin
				displayName: 'Tanggal Mulai',
				// % protected region % [Set displayName for Tanggal Mulai here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tanggal Mulai here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tanggal Mulai here] end
				// % protected region % [Set isSensitive for Tanggal Mulai here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tanggal Mulai here] end
				// % protected region % [Set readonly for Tanggal Mulai here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tanggal Mulai here] end
				validators: [
					// % protected region % [Add other validators for Tanggal Mulai here] off begin
					// % protected region % [Add other validators for Tanggal Mulai here] end
				],
				// % protected region % [Add any additional model attribute properties for Tanggal Mulai here] off begin
				// % protected region % [Add any additional model attribute properties for Tanggal Mulai here] end
			},
			{
				name: 'tanggalAkhir',
				// % protected region % [Set displayName for Tanggal Akhir here] off begin
				displayName: 'Tanggal Akhir',
				// % protected region % [Set displayName for Tanggal Akhir here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tanggal Akhir here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tanggal Akhir here] end
				// % protected region % [Set isSensitive for Tanggal Akhir here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tanggal Akhir here] end
				// % protected region % [Set readonly for Tanggal Akhir here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tanggal Akhir here] end
				validators: [
					// % protected region % [Add other validators for Tanggal Akhir here] off begin
					// % protected region % [Add other validators for Tanggal Akhir here] end
				],
				// % protected region % [Add any additional model attribute properties for Tanggal Akhir here] off begin
				// % protected region % [Add any additional model attribute properties for Tanggal Akhir here] end
			},
			{
				name: 'alamatClub',
				// % protected region % [Set displayName for Alamat Club here] off begin
				displayName: 'Alamat Club',
				// % protected region % [Set displayName for Alamat Club here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Alamat Club here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Alamat Club here] end
				// % protected region % [Set isSensitive for Alamat Club here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Alamat Club here] end
				// % protected region % [Set readonly for Alamat Club here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Alamat Club here] end
				validators: [
					// % protected region % [Add other validators for Alamat Club here] off begin
					// % protected region % [Add other validators for Alamat Club here] end
				],
				// % protected region % [Add any additional model attribute properties for Alamat Club here] off begin
				// % protected region % [Add any additional model attribute properties for Alamat Club here] end
			},
			{
				name: 'namaClub',
				// % protected region % [Set displayName for Nama Club here] off begin
				displayName: 'Nama Club',
				// % protected region % [Set displayName for Nama Club here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nama Club here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nama Club here] end
				// % protected region % [Set isSensitive for Nama Club here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nama Club here] end
				// % protected region % [Set readonly for Nama Club here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nama Club here] end
				validators: [
					// % protected region % [Add other validators for Nama Club here] off begin
					// % protected region % [Add other validators for Nama Club here] end
				],
				// % protected region % [Add any additional model attribute properties for Nama Club here] off begin
				// % protected region % [Add any additional model attribute properties for Nama Club here] end
			},
			{
				name: 'noHPKetua',
				// % protected region % [Set displayName for No HP Ketua here] off begin
				displayName: 'No HP Ketua',
				// % protected region % [Set displayName for No HP Ketua here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for No HP Ketua here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for No HP Ketua here] end
				// % protected region % [Set isSensitive for No HP Ketua here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for No HP Ketua here] end
				// % protected region % [Set readonly for No HP Ketua here] off begin
				readOnly: false,
				// % protected region % [Set readonly for No HP Ketua here] end
				validators: [
					// % protected region % [Add other validators for No HP Ketua here] off begin
					// % protected region % [Add other validators for No HP Ketua here] end
				],
				// % protected region % [Add any additional model attribute properties for No HP Ketua here] off begin
				// % protected region % [Add any additional model attribute properties for No HP Ketua here] end
			},
			{
				name: 'namaKetua',
				// % protected region % [Set displayName for Nama Ketua here] off begin
				displayName: 'Nama Ketua',
				// % protected region % [Set displayName for Nama Ketua here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nama Ketua here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nama Ketua here] end
				// % protected region % [Set isSensitive for Nama Ketua here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nama Ketua here] end
				// % protected region % [Set readonly for Nama Ketua here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nama Ketua here] end
				validators: [
					// % protected region % [Add other validators for Nama Ketua here] off begin
					// % protected region % [Add other validators for Nama Ketua here] end
				],
				// % protected region % [Add any additional model attribute properties for Nama Ketua here] off begin
				// % protected region % [Add any additional model attribute properties for Nama Ketua here] end
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
				case 'clubID':
					break;
				case 'kodeProgram':
					break;
				case 'namaProgram':
					break;
				case 'tanggalMulai':
					break;
				case 'tanggalAkhir':
					break;
				case 'alamatClub':
					break;
				case 'namaClub':
					break;
				case 'noHPKetua':
					break;
				case 'namaKetua':
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
	static deepParse(data: string | { [K in keyof PcareClubProlanisModel]?: PcareClubProlanisModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PcareClubProlanisModel(data);
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
	 * `let pcareClubProlanisModel = new PcareClubProlanisModel(data);`
	 *
	 * @param data The input data to be initialised as the PcareClubProlanisModel,
	 *    it is expected as a JSON string or as a nullable PcareClubProlanisModel.
	 */
	constructor(data?: string | Partial<PcareClubProlanisModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PcareClubProlanisModel>
				: data;

			this.clubID = json.clubID;
			this.kodeProgram = json.kodeProgram;
			this.namaProgram = json.namaProgram;
			this.tanggalMulai = json.tanggalMulai;
			this.tanggalAkhir = json.tanggalAkhir;
			this.alamatClub = json.alamatClub;
			this.namaClub = json.namaClub;
			this.noHPKetua = json.noHPKetua;
			this.namaKetua = json.namaKetua;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			clubID: this.clubID,
			kodeProgram: this.kodeProgram,
			namaProgram: this.namaProgram,
			tanggalMulai: this.tanggalMulai,
			tanggalAkhir: this.tanggalAkhir,
			alamatClub: this.alamatClub,
			namaClub: this.namaClub,
			noHPKetua: this.noHPKetua,
			namaKetua: this.namaKetua,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PcareClubProlanisModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PcareClubProlanisModel {
		let newModelJson = this.toJSON();

		if (updates.clubID) {
			newModelJson.clubID = updates.clubID;
		}

		if (updates.kodeProgram) {
			newModelJson.kodeProgram = updates.kodeProgram;
		}

		if (updates.namaProgram) {
			newModelJson.namaProgram = updates.namaProgram;
		}

		if (updates.tanggalMulai) {
			newModelJson.tanggalMulai = updates.tanggalMulai;
		}

		if (updates.tanggalAkhir) {
			newModelJson.tanggalAkhir = updates.tanggalAkhir;
		}

		if (updates.alamatClub) {
			newModelJson.alamatClub = updates.alamatClub;
		}

		if (updates.namaClub) {
			newModelJson.namaClub = updates.namaClub;
		}

		if (updates.noHPKetua) {
			newModelJson.noHPKetua = updates.noHPKetua;
		}

		if (updates.namaKetua) {
			newModelJson.namaKetua = updates.namaKetua;
		}

		return new PcareClubProlanisModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PcareClubProlanisModel)) {
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
