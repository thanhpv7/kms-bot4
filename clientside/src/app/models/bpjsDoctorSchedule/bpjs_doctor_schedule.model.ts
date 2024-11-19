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
export class BpjsDoctorScheduleModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'hari',
		'namaHari',
		'kapasitas',
		'jknQuota',
		'jknNonQuota',
		'interval',
		'libur',
		'jamBuka',
		'jamTutup',
		'kodepoli',
		'namapoli',
		'kodesubspesialis',
		'namasubspesialis',
		'kodedokter',
		'namadokter',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'hari',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsDoctorScheduleModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsDoctorScheduleModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	hari: number;

	/**
	 * .
	 */
	namaHari: string;

	/**
	 * .
	 */
	kapasitas: number;

	/**
	 * Default value = 0.
	 */
	jknQuota: number;

	/**
	 * Default value = 0.
	 */
	jknNonQuota: number;

	/**
	 * Default = 0.
	 */
	interval: number;

	/**
	 * 0 = Tidak Libur, 1 = Libur.
	 */
	libur: boolean = false;

	/**
	 * .
	 */
	jamBuka: string;

	/**
	 * .
	 */
	jamTutup: string;

	/**
	 * Kode Poli.
	 */
	kodepoli: string;

	/**
	 * Nama Poli.
	 */
	namapoli: string;

	/**
	 * Kode Subspesialis.
	 */
	kodesubspesialis: string;

	/**
	 * Nama Subspesialis.
	 */
	namasubspesialis: string;

	/**
	 * Kode Dokter.
	 */
	kodedokter: string;

	/**
	 * Nama Dokter.
	 */
	namadokter: string;



	modelPropGroups: { [s: string]: Group } = BpjsDoctorScheduleModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'hari',
				// % protected region % [Set displayName for Hari here] off begin
				displayName: 'Hari',
				// % protected region % [Set displayName for Hari here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Hari here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Hari here] end
				// % protected region % [Set isSensitive for Hari here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hari here] end
				// % protected region % [Set readonly for Hari here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hari here] end
				validators: [
					// % protected region % [Add other validators for Hari here] off begin
					// % protected region % [Add other validators for Hari here] end
				],
				// % protected region % [Add any additional model attribute properties for Hari here] off begin
				// % protected region % [Add any additional model attribute properties for Hari here] end
			},
			{
				name: 'namaHari',
				// % protected region % [Set displayName for Nama Hari here] off begin
				displayName: 'Nama Hari',
				// % protected region % [Set displayName for Nama Hari here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nama Hari here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nama Hari here] end
				// % protected region % [Set isSensitive for Nama Hari here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nama Hari here] end
				// % protected region % [Set readonly for Nama Hari here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nama Hari here] end
				validators: [
					// % protected region % [Add other validators for Nama Hari here] off begin
					// % protected region % [Add other validators for Nama Hari here] end
				],
				// % protected region % [Add any additional model attribute properties for Nama Hari here] off begin
				// % protected region % [Add any additional model attribute properties for Nama Hari here] end
			},
			{
				name: 'kapasitas',
				// % protected region % [Set displayName for Kapasitas here] off begin
				displayName: 'Kapasitas',
				// % protected region % [Set displayName for Kapasitas here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Kapasitas here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Kapasitas here] end
				// % protected region % [Set isSensitive for Kapasitas here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kapasitas here] end
				// % protected region % [Set readonly for Kapasitas here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kapasitas here] end
				validators: [
					// % protected region % [Add other validators for Kapasitas here] off begin
					// % protected region % [Add other validators for Kapasitas here] end
				],
				// % protected region % [Add any additional model attribute properties for Kapasitas here] off begin
				// % protected region % [Add any additional model attribute properties for Kapasitas here] end
			},
			{
				name: 'jknQuota',
				// % protected region % [Set displayName for JKN Quota here] off begin
				displayName: 'JKN Quota',
				// % protected region % [Set displayName for JKN Quota here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for JKN Quota here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for JKN Quota here] end
				// % protected region % [Set isSensitive for JKN Quota here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for JKN Quota here] end
				// % protected region % [Set readonly for JKN Quota here] off begin
				readOnly: false,
				// % protected region % [Set readonly for JKN Quota here] end
				validators: [
					// % protected region % [Add other validators for JKN Quota here] off begin
					// % protected region % [Add other validators for JKN Quota here] end
				],
				// % protected region % [Add any additional model attribute properties for JKN Quota here] off begin
				// % protected region % [Add any additional model attribute properties for JKN Quota here] end
			},
			{
				name: 'jknNonQuota',
				// % protected region % [Set displayName for JKN Non Quota here] off begin
				displayName: 'JKN Non Quota',
				// % protected region % [Set displayName for JKN Non Quota here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for JKN Non Quota here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for JKN Non Quota here] end
				// % protected region % [Set isSensitive for JKN Non Quota here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for JKN Non Quota here] end
				// % protected region % [Set readonly for JKN Non Quota here] off begin
				readOnly: false,
				// % protected region % [Set readonly for JKN Non Quota here] end
				validators: [
					// % protected region % [Add other validators for JKN Non Quota here] off begin
					// % protected region % [Add other validators for JKN Non Quota here] end
				],
				// % protected region % [Add any additional model attribute properties for JKN Non Quota here] off begin
				// % protected region % [Add any additional model attribute properties for JKN Non Quota here] end
			},
			{
				name: 'interval',
				// % protected region % [Set displayName for Interval here] off begin
				displayName: 'Interval',
				// % protected region % [Set displayName for Interval here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Interval here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Interval here] end
				// % protected region % [Set isSensitive for Interval here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Interval here] end
				// % protected region % [Set readonly for Interval here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Interval here] end
				validators: [
					// % protected region % [Add other validators for Interval here] off begin
					// % protected region % [Add other validators for Interval here] end
				],
				// % protected region % [Add any additional model attribute properties for Interval here] off begin
				// % protected region % [Add any additional model attribute properties for Interval here] end
			},
			{
				name: 'libur',
				// % protected region % [Set displayName for Libur here] off begin
				displayName: 'Libur',
				// % protected region % [Set displayName for Libur here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Libur here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Libur here] end
				// % protected region % [Set isSensitive for Libur here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Libur here] end
				// % protected region % [Set readonly for Libur here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Libur here] end
				validators: [
					// % protected region % [Add other validators for Libur here] off begin
					// % protected region % [Add other validators for Libur here] end
				],
				// % protected region % [Add any additional model attribute properties for Libur here] off begin
				// % protected region % [Add any additional model attribute properties for Libur here] end
			},
			{
				name: 'jamBuka',
				// % protected region % [Set displayName for Jam Buka here] off begin
				displayName: 'Jam Buka',
				// % protected region % [Set displayName for Jam Buka here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Jam Buka here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Jam Buka here] end
				// % protected region % [Set isSensitive for Jam Buka here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Jam Buka here] end
				// % protected region % [Set readonly for Jam Buka here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Jam Buka here] end
				validators: [
					// % protected region % [Add other validators for Jam Buka here] off begin
					// % protected region % [Add other validators for Jam Buka here] end
				],
				// % protected region % [Add any additional model attribute properties for Jam Buka here] off begin
				// % protected region % [Add any additional model attribute properties for Jam Buka here] end
			},
			{
				name: 'jamTutup',
				// % protected region % [Set displayName for Jam Tutup here] off begin
				displayName: 'Jam Tutup',
				// % protected region % [Set displayName for Jam Tutup here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Jam Tutup here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Jam Tutup here] end
				// % protected region % [Set isSensitive for Jam Tutup here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Jam Tutup here] end
				// % protected region % [Set readonly for Jam Tutup here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Jam Tutup here] end
				validators: [
					// % protected region % [Add other validators for Jam Tutup here] off begin
					// % protected region % [Add other validators for Jam Tutup here] end
				],
				// % protected region % [Add any additional model attribute properties for Jam Tutup here] off begin
				// % protected region % [Add any additional model attribute properties for Jam Tutup here] end
			},
			{
				name: 'kodepoli',
				// % protected region % [Set displayName for kodepoli here] off begin
				displayName: 'kodepoli',
				// % protected region % [Set displayName for kodepoli here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodepoli here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodepoli here] end
				// % protected region % [Set isSensitive for kodepoli here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodepoli here] end
				// % protected region % [Set readonly for kodepoli here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodepoli here] end
				validators: [
					// % protected region % [Add other validators for kodepoli here] off begin
					// % protected region % [Add other validators for kodepoli here] end
				],
				// % protected region % [Add any additional model attribute properties for kodepoli here] off begin
				// % protected region % [Add any additional model attribute properties for kodepoli here] end
			},
			{
				name: 'namapoli',
				// % protected region % [Set displayName for namapoli here] off begin
				displayName: 'namapoli',
				// % protected region % [Set displayName for namapoli here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for namapoli here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for namapoli here] end
				// % protected region % [Set isSensitive for namapoli here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for namapoli here] end
				// % protected region % [Set readonly for namapoli here] off begin
				readOnly: false,
				// % protected region % [Set readonly for namapoli here] end
				validators: [
					// % protected region % [Add other validators for namapoli here] off begin
					// % protected region % [Add other validators for namapoli here] end
				],
				// % protected region % [Add any additional model attribute properties for namapoli here] off begin
				// % protected region % [Add any additional model attribute properties for namapoli here] end
			},
			{
				name: 'kodesubspesialis',
				// % protected region % [Set displayName for kodesubspesialis here] off begin
				displayName: 'kodesubspesialis',
				// % protected region % [Set displayName for kodesubspesialis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodesubspesialis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodesubspesialis here] end
				// % protected region % [Set isSensitive for kodesubspesialis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodesubspesialis here] end
				// % protected region % [Set readonly for kodesubspesialis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodesubspesialis here] end
				validators: [
					// % protected region % [Add other validators for kodesubspesialis here] off begin
					// % protected region % [Add other validators for kodesubspesialis here] end
				],
				// % protected region % [Add any additional model attribute properties for kodesubspesialis here] off begin
				// % protected region % [Add any additional model attribute properties for kodesubspesialis here] end
			},
			{
				name: 'namasubspesialis',
				// % protected region % [Set displayName for namasubspesialis here] off begin
				displayName: 'namasubspesialis',
				// % protected region % [Set displayName for namasubspesialis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for namasubspesialis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for namasubspesialis here] end
				// % protected region % [Set isSensitive for namasubspesialis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for namasubspesialis here] end
				// % protected region % [Set readonly for namasubspesialis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for namasubspesialis here] end
				validators: [
					// % protected region % [Add other validators for namasubspesialis here] off begin
					// % protected region % [Add other validators for namasubspesialis here] end
				],
				// % protected region % [Add any additional model attribute properties for namasubspesialis here] off begin
				// % protected region % [Add any additional model attribute properties for namasubspesialis here] end
			},
			{
				name: 'kodedokter',
				// % protected region % [Set displayName for kodedokter here] off begin
				displayName: 'kodedokter',
				// % protected region % [Set displayName for kodedokter here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodedokter here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodedokter here] end
				// % protected region % [Set isSensitive for kodedokter here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodedokter here] end
				// % protected region % [Set readonly for kodedokter here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodedokter here] end
				validators: [
					// % protected region % [Add other validators for kodedokter here] off begin
					// % protected region % [Add other validators for kodedokter here] end
				],
				// % protected region % [Add any additional model attribute properties for kodedokter here] off begin
				// % protected region % [Add any additional model attribute properties for kodedokter here] end
			},
			{
				name: 'namadokter',
				// % protected region % [Set displayName for namadokter here] off begin
				displayName: 'namadokter',
				// % protected region % [Set displayName for namadokter here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for namadokter here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for namadokter here] end
				// % protected region % [Set isSensitive for namadokter here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for namadokter here] end
				// % protected region % [Set readonly for namadokter here] off begin
				readOnly: false,
				// % protected region % [Set readonly for namadokter here] end
				validators: [
					// % protected region % [Add other validators for namadokter here] off begin
					// % protected region % [Add other validators for namadokter here] end
				],
				// % protected region % [Add any additional model attribute properties for namadokter here] off begin
				// % protected region % [Add any additional model attribute properties for namadokter here] end
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
				case 'hari':
					break;
				case 'namaHari':
					break;
				case 'kapasitas':
					break;
				case 'jknQuota':
					break;
				case 'jknNonQuota':
					break;
				case 'interval':
					break;
				case 'libur':
					break;
				case 'jamBuka':
					break;
				case 'jamTutup':
					break;
				case 'kodepoli':
					break;
				case 'namapoli':
					break;
				case 'kodesubspesialis':
					break;
				case 'namasubspesialis':
					break;
				case 'kodedokter':
					break;
				case 'namadokter':
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
	static deepParse(data: string | { [K in keyof BpjsDoctorScheduleModel]?: BpjsDoctorScheduleModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsDoctorScheduleModel(data);
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
	 * `let bpjsDoctorScheduleModel = new BpjsDoctorScheduleModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsDoctorScheduleModel,
	 *    it is expected as a JSON string or as a nullable BpjsDoctorScheduleModel.
	 */
	constructor(data?: string | Partial<BpjsDoctorScheduleModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsDoctorScheduleModel>
				: data;

			this.hari = json.hari;
			this.namaHari = json.namaHari;
			this.kapasitas = json.kapasitas;
			this.jknQuota = json.jknQuota;
			this.jknNonQuota = json.jknNonQuota;
			this.interval = json.interval;
			this.libur = json.libur;
			this.jamBuka = json.jamBuka;
			this.jamTutup = json.jamTutup;
			this.kodepoli = json.kodepoli;
			this.namapoli = json.namapoli;
			this.kodesubspesialis = json.kodesubspesialis;
			this.namasubspesialis = json.namasubspesialis;
			this.kodedokter = json.kodedokter;
			this.namadokter = json.namadokter;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			hari: this.hari,
			namaHari: this.namaHari,
			kapasitas: this.kapasitas,
			jknQuota: this.jknQuota,
			jknNonQuota: this.jknNonQuota,
			interval: this.interval,
			libur: this.libur,
			jamBuka: this.jamBuka,
			jamTutup: this.jamTutup,
			kodepoli: this.kodepoli,
			namapoli: this.namapoli,
			kodesubspesialis: this.kodesubspesialis,
			namasubspesialis: this.namasubspesialis,
			kodedokter: this.kodedokter,
			namadokter: this.namadokter,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsDoctorScheduleModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsDoctorScheduleModel {
		let newModelJson = this.toJSON();

		if (updates.hari) {
			newModelJson.hari = updates.hari;
		}

		if (updates.namaHari) {
			newModelJson.namaHari = updates.namaHari;
		}

		if (updates.kapasitas) {
			newModelJson.kapasitas = updates.kapasitas;
		}

		if (updates.jknQuota) {
			newModelJson.jknQuota = updates.jknQuota;
		}

		if (updates.jknNonQuota) {
			newModelJson.jknNonQuota = updates.jknNonQuota;
		}

		if (updates.interval) {
			newModelJson.interval = updates.interval;
		}

		if (updates.libur) {
			newModelJson.libur = updates.libur;
		}

		if (updates.jamBuka) {
			newModelJson.jamBuka = updates.jamBuka;
		}

		if (updates.jamTutup) {
			newModelJson.jamTutup = updates.jamTutup;
		}

		if (updates.kodepoli) {
			newModelJson.kodepoli = updates.kodepoli;
		}

		if (updates.namapoli) {
			newModelJson.namapoli = updates.namapoli;
		}

		if (updates.kodesubspesialis) {
			newModelJson.kodesubspesialis = updates.kodesubspesialis;
		}

		if (updates.namasubspesialis) {
			newModelJson.namasubspesialis = updates.namasubspesialis;
		}

		if (updates.kodedokter) {
			newModelJson.kodedokter = updates.kodedokter;
		}

		if (updates.namadokter) {
			newModelJson.namadokter = updates.namadokter;
		}

		return new BpjsDoctorScheduleModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsDoctorScheduleModel)) {
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
