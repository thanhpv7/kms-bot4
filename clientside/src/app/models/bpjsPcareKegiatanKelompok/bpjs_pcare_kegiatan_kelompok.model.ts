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
export class BpjsPcareKegiatanKelompokModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'ketuanama',
		'nama',
		'eduid',
		'clubid',
		'kdprogram',
		'nmprogram',
		'tglmulai',
		'tglakhir',
		'alamat',
		'ketuanohp',
		'tglpelayanan',
		'kegiatankode',
		'pembicara',
		'lokasi',
		'keterangan',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'ketuanama',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPcareKegiatanKelompokModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPcareKegiatanKelompokModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	ketuanama: string;

	/**
	 * .
	 */
	nama: string;

	/**
	 * .
	 */
	eduid: string;

	/**
	 * .
	 */
	clubid: string;

	/**
	 * .
	 */
	kdprogram: string;

	/**
	 * .
	 */
	nmprogram: string;

	/**
	 * .
	 */
	tglmulai: string;

	/**
	 * .
	 */
	tglakhir: string;

	/**
	 * .
	 */
	alamat: string;

	/**
	 * .
	 */
	ketuanohp: string;

	/**
	 * .
	 */
	tglpelayanan: string;

	/**
	 * .
	 */
	kegiatannama: string;

	/**
	 * .
	 */
	kegiatankode: string;

	/**
	 * .
	 */
	kelompoknama: string;

	/**
	 * .
	 */
	kelompokkode: string;

	/**
	 * .
	 */
	materi: string;

	/**
	 * .
	 */
	pembicara: string;

	/**
	 * .
	 */
	lokasi: string;

	/**
	 * .
	 */
	keterangan: string;

	/**
	 * .
	 */
	biaya: string;



	modelPropGroups: { [s: string]: Group } = BpjsPcareKegiatanKelompokModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'ketuanama',
				// % protected region % [Set displayName for ketuaNama here] off begin
				displayName: 'ketuaNama',
				// % protected region % [Set displayName for ketuaNama here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ketuaNama here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ketuaNama here] end
				// % protected region % [Set isSensitive for ketuaNama here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ketuaNama here] end
				// % protected region % [Set readonly for ketuaNama here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ketuaNama here] end
				validators: [
					// % protected region % [Add other validators for ketuaNama here] off begin
					// % protected region % [Add other validators for ketuaNama here] end
				],
				// % protected region % [Add any additional model attribute properties for ketuaNama here] off begin
				// % protected region % [Add any additional model attribute properties for ketuaNama here] end
			},
			{
				name: 'nama',
				// % protected region % [Set displayName for nama here] off begin
				displayName: 'nama',
				// % protected region % [Set displayName for nama here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nama here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nama here] end
				// % protected region % [Set isSensitive for nama here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nama here] end
				// % protected region % [Set readonly for nama here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nama here] end
				validators: [
					// % protected region % [Add other validators for nama here] off begin
					// % protected region % [Add other validators for nama here] end
				],
				// % protected region % [Add any additional model attribute properties for nama here] off begin
				// % protected region % [Add any additional model attribute properties for nama here] end
			},
			{
				name: 'eduid',
				// % protected region % [Set displayName for eduId here] off begin
				displayName: 'eduId',
				// % protected region % [Set displayName for eduId here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for eduId here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for eduId here] end
				// % protected region % [Set isSensitive for eduId here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for eduId here] end
				// % protected region % [Set readonly for eduId here] off begin
				readOnly: false,
				// % protected region % [Set readonly for eduId here] end
				validators: [
					// % protected region % [Add other validators for eduId here] off begin
					// % protected region % [Add other validators for eduId here] end
				],
				// % protected region % [Add any additional model attribute properties for eduId here] off begin
				// % protected region % [Add any additional model attribute properties for eduId here] end
			},
			{
				name: 'clubid',
				// % protected region % [Set displayName for clubId here] off begin
				displayName: 'clubId',
				// % protected region % [Set displayName for clubId here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for clubId here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for clubId here] end
				// % protected region % [Set isSensitive for clubId here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for clubId here] end
				// % protected region % [Set readonly for clubId here] off begin
				readOnly: false,
				// % protected region % [Set readonly for clubId here] end
				validators: [
					// % protected region % [Add other validators for clubId here] off begin
					// % protected region % [Add other validators for clubId here] end
				],
				// % protected region % [Add any additional model attribute properties for clubId here] off begin
				// % protected region % [Add any additional model attribute properties for clubId here] end
			},
			{
				name: 'kdprogram',
				// % protected region % [Set displayName for kdProgram here] off begin
				displayName: 'kdProgram',
				// % protected region % [Set displayName for kdProgram here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdProgram here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdProgram here] end
				// % protected region % [Set isSensitive for kdProgram here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdProgram here] end
				// % protected region % [Set readonly for kdProgram here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdProgram here] end
				validators: [
					// % protected region % [Add other validators for kdProgram here] off begin
					// % protected region % [Add other validators for kdProgram here] end
				],
				// % protected region % [Add any additional model attribute properties for kdProgram here] off begin
				// % protected region % [Add any additional model attribute properties for kdProgram here] end
			},
			{
				name: 'nmprogram',
				// % protected region % [Set displayName for nmProgram here] off begin
				displayName: 'nmProgram',
				// % protected region % [Set displayName for nmProgram here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmProgram here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmProgram here] end
				// % protected region % [Set isSensitive for nmProgram here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmProgram here] end
				// % protected region % [Set readonly for nmProgram here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmProgram here] end
				validators: [
					// % protected region % [Add other validators for nmProgram here] off begin
					// % protected region % [Add other validators for nmProgram here] end
				],
				// % protected region % [Add any additional model attribute properties for nmProgram here] off begin
				// % protected region % [Add any additional model attribute properties for nmProgram here] end
			},
			{
				name: 'tglmulai',
				// % protected region % [Set displayName for tglMulai here] off begin
				displayName: 'tglMulai',
				// % protected region % [Set displayName for tglMulai here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglMulai here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglMulai here] end
				// % protected region % [Set isSensitive for tglMulai here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglMulai here] end
				// % protected region % [Set readonly for tglMulai here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglMulai here] end
				validators: [
					// % protected region % [Add other validators for tglMulai here] off begin
					// % protected region % [Add other validators for tglMulai here] end
				],
				// % protected region % [Add any additional model attribute properties for tglMulai here] off begin
				// % protected region % [Add any additional model attribute properties for tglMulai here] end
			},
			{
				name: 'tglakhir',
				// % protected region % [Set displayName for tglAkhir here] off begin
				displayName: 'tglAkhir',
				// % protected region % [Set displayName for tglAkhir here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglAkhir here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglAkhir here] end
				// % protected region % [Set isSensitive for tglAkhir here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglAkhir here] end
				// % protected region % [Set readonly for tglAkhir here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglAkhir here] end
				validators: [
					// % protected region % [Add other validators for tglAkhir here] off begin
					// % protected region % [Add other validators for tglAkhir here] end
				],
				// % protected region % [Add any additional model attribute properties for tglAkhir here] off begin
				// % protected region % [Add any additional model attribute properties for tglAkhir here] end
			},
			{
				name: 'alamat',
				// % protected region % [Set displayName for alamat here] off begin
				displayName: 'alamat',
				// % protected region % [Set displayName for alamat here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for alamat here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for alamat here] end
				// % protected region % [Set isSensitive for alamat here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for alamat here] end
				// % protected region % [Set readonly for alamat here] off begin
				readOnly: false,
				// % protected region % [Set readonly for alamat here] end
				validators: [
					// % protected region % [Add other validators for alamat here] off begin
					// % protected region % [Add other validators for alamat here] end
				],
				// % protected region % [Add any additional model attribute properties for alamat here] off begin
				// % protected region % [Add any additional model attribute properties for alamat here] end
			},
			{
				name: 'ketuanohp',
				// % protected region % [Set displayName for ketuaNoHp here] off begin
				displayName: 'ketuaNoHp',
				// % protected region % [Set displayName for ketuaNoHp here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ketuaNoHp here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ketuaNoHp here] end
				// % protected region % [Set isSensitive for ketuaNoHp here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ketuaNoHp here] end
				// % protected region % [Set readonly for ketuaNoHp here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ketuaNoHp here] end
				validators: [
					// % protected region % [Add other validators for ketuaNoHp here] off begin
					// % protected region % [Add other validators for ketuaNoHp here] end
				],
				// % protected region % [Add any additional model attribute properties for ketuaNoHp here] off begin
				// % protected region % [Add any additional model attribute properties for ketuaNoHp here] end
			},
			{
				name: 'tglpelayanan',
				// % protected region % [Set displayName for tglPelayanan here] off begin
				displayName: 'tglPelayanan',
				// % protected region % [Set displayName for tglPelayanan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglPelayanan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglPelayanan here] end
				// % protected region % [Set isSensitive for tglPelayanan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglPelayanan here] end
				// % protected region % [Set readonly for tglPelayanan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglPelayanan here] end
				validators: [
					// % protected region % [Add other validators for tglPelayanan here] off begin
					// % protected region % [Add other validators for tglPelayanan here] end
				],
				// % protected region % [Add any additional model attribute properties for tglPelayanan here] off begin
				// % protected region % [Add any additional model attribute properties for tglPelayanan here] end
			},
			{
				name: 'kegiatannama',
				// % protected region % [Set displayName for kegiatanNama here] off begin
				displayName: 'kegiatanNama',
				// % protected region % [Set displayName for kegiatanNama here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kegiatanNama here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kegiatanNama here] end
				// % protected region % [Set isSensitive for kegiatanNama here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kegiatanNama here] end
				// % protected region % [Set readonly for kegiatanNama here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kegiatanNama here] end
				validators: [
					// % protected region % [Add other validators for kegiatanNama here] off begin
					// % protected region % [Add other validators for kegiatanNama here] end
				],
				// % protected region % [Add any additional model attribute properties for kegiatanNama here] off begin
				// % protected region % [Add any additional model attribute properties for kegiatanNama here] end
			},
			{
				name: 'kegiatankode',
				// % protected region % [Set displayName for kegiatanKode here] off begin
				displayName: 'kegiatanKode',
				// % protected region % [Set displayName for kegiatanKode here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kegiatanKode here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kegiatanKode here] end
				// % protected region % [Set isSensitive for kegiatanKode here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kegiatanKode here] end
				// % protected region % [Set readonly for kegiatanKode here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kegiatanKode here] end
				validators: [
					// % protected region % [Add other validators for kegiatanKode here] off begin
					// % protected region % [Add other validators for kegiatanKode here] end
				],
				// % protected region % [Add any additional model attribute properties for kegiatanKode here] off begin
				// % protected region % [Add any additional model attribute properties for kegiatanKode here] end
			},
			{
				name: 'kelompoknama',
				// % protected region % [Set displayName for kelompokNama here] off begin
				displayName: 'kelompokNama',
				// % protected region % [Set displayName for kelompokNama here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kelompokNama here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kelompokNama here] end
				// % protected region % [Set isSensitive for kelompokNama here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kelompokNama here] end
				// % protected region % [Set readonly for kelompokNama here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kelompokNama here] end
				validators: [
					// % protected region % [Add other validators for kelompokNama here] off begin
					// % protected region % [Add other validators for kelompokNama here] end
				],
				// % protected region % [Add any additional model attribute properties for kelompokNama here] off begin
				// % protected region % [Add any additional model attribute properties for kelompokNama here] end
			},
			{
				name: 'kelompokkode',
				// % protected region % [Set displayName for kelompokKode here] off begin
				displayName: 'kelompokKode',
				// % protected region % [Set displayName for kelompokKode here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kelompokKode here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kelompokKode here] end
				// % protected region % [Set isSensitive for kelompokKode here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kelompokKode here] end
				// % protected region % [Set readonly for kelompokKode here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kelompokKode here] end
				validators: [
					// % protected region % [Add other validators for kelompokKode here] off begin
					// % protected region % [Add other validators for kelompokKode here] end
				],
				// % protected region % [Add any additional model attribute properties for kelompokKode here] off begin
				// % protected region % [Add any additional model attribute properties for kelompokKode here] end
			},
			{
				name: 'materi',
				// % protected region % [Set displayName for materi here] off begin
				displayName: 'materi',
				// % protected region % [Set displayName for materi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for materi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for materi here] end
				// % protected region % [Set isSensitive for materi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for materi here] end
				// % protected region % [Set readonly for materi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for materi here] end
				validators: [
					// % protected region % [Add other validators for materi here] off begin
					// % protected region % [Add other validators for materi here] end
				],
				// % protected region % [Add any additional model attribute properties for materi here] off begin
				// % protected region % [Add any additional model attribute properties for materi here] end
			},
			{
				name: 'pembicara',
				// % protected region % [Set displayName for pembicara here] off begin
				displayName: 'pembicara',
				// % protected region % [Set displayName for pembicara here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for pembicara here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for pembicara here] end
				// % protected region % [Set isSensitive for pembicara here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for pembicara here] end
				// % protected region % [Set readonly for pembicara here] off begin
				readOnly: false,
				// % protected region % [Set readonly for pembicara here] end
				validators: [
					// % protected region % [Add other validators for pembicara here] off begin
					// % protected region % [Add other validators for pembicara here] end
				],
				// % protected region % [Add any additional model attribute properties for pembicara here] off begin
				// % protected region % [Add any additional model attribute properties for pembicara here] end
			},
			{
				name: 'lokasi',
				// % protected region % [Set displayName for lokasi here] off begin
				displayName: 'lokasi',
				// % protected region % [Set displayName for lokasi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for lokasi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for lokasi here] end
				// % protected region % [Set isSensitive for lokasi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for lokasi here] end
				// % protected region % [Set readonly for lokasi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for lokasi here] end
				validators: [
					// % protected region % [Add other validators for lokasi here] off begin
					// % protected region % [Add other validators for lokasi here] end
				],
				// % protected region % [Add any additional model attribute properties for lokasi here] off begin
				// % protected region % [Add any additional model attribute properties for lokasi here] end
			},
			{
				name: 'keterangan',
				// % protected region % [Set displayName for keterangan here] off begin
				displayName: 'keterangan',
				// % protected region % [Set displayName for keterangan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for keterangan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for keterangan here] end
				// % protected region % [Set isSensitive for keterangan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for keterangan here] end
				// % protected region % [Set readonly for keterangan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for keterangan here] end
				validators: [
					// % protected region % [Add other validators for keterangan here] off begin
					// % protected region % [Add other validators for keterangan here] end
				],
				// % protected region % [Add any additional model attribute properties for keterangan here] off begin
				// % protected region % [Add any additional model attribute properties for keterangan here] end
			},
			{
				name: 'biaya',
				// % protected region % [Set displayName for biaya here] off begin
				displayName: 'biaya',
				// % protected region % [Set displayName for biaya here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for biaya here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for biaya here] end
				// % protected region % [Set isSensitive for biaya here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for biaya here] end
				// % protected region % [Set readonly for biaya here] off begin
				readOnly: false,
				// % protected region % [Set readonly for biaya here] end
				validators: [
					// % protected region % [Add other validators for biaya here] off begin
					// % protected region % [Add other validators for biaya here] end
				],
				// % protected region % [Add any additional model attribute properties for biaya here] off begin
				// % protected region % [Add any additional model attribute properties for biaya here] end
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
				case 'ketuanama':
					break;
				case 'nama':
					break;
				case 'eduid':
					break;
				case 'clubid':
					break;
				case 'kdprogram':
					break;
				case 'nmprogram':
					break;
				case 'tglmulai':
					break;
				case 'tglakhir':
					break;
				case 'alamat':
					break;
				case 'ketuanohp':
					break;
				case 'tglpelayanan':
					break;
				case 'kegiatankode':
					break;
				case 'pembicara':
					break;
				case 'lokasi':
					break;
				case 'keterangan':
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
	static deepParse(data: string | { [K in keyof BpjsPcareKegiatanKelompokModel]?: BpjsPcareKegiatanKelompokModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPcareKegiatanKelompokModel(data);
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
	 * `let bpjsPcareKegiatanKelompokModel = new BpjsPcareKegiatanKelompokModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPcareKegiatanKelompokModel,
	 *    it is expected as a JSON string or as a nullable BpjsPcareKegiatanKelompokModel.
	 */
	constructor(data?: string | Partial<BpjsPcareKegiatanKelompokModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPcareKegiatanKelompokModel>
				: data;

			this.ketuanama = json.ketuanama;
			this.nama = json.nama;
			this.eduid = json.eduid;
			this.clubid = json.clubid;
			this.kdprogram = json.kdprogram;
			this.nmprogram = json.nmprogram;
			this.tglmulai = json.tglmulai;
			this.tglakhir = json.tglakhir;
			this.alamat = json.alamat;
			this.ketuanohp = json.ketuanohp;
			this.tglpelayanan = json.tglpelayanan;
			this.kegiatannama = json.kegiatannama;
			this.kegiatankode = json.kegiatankode;
			this.kelompoknama = json.kelompoknama;
			this.kelompokkode = json.kelompokkode;
			this.materi = json.materi;
			this.pembicara = json.pembicara;
			this.lokasi = json.lokasi;
			this.keterangan = json.keterangan;
			this.biaya = json.biaya;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			ketuanama: this.ketuanama,
			nama: this.nama,
			eduid: this.eduid,
			clubid: this.clubid,
			kdprogram: this.kdprogram,
			nmprogram: this.nmprogram,
			tglmulai: this.tglmulai,
			tglakhir: this.tglakhir,
			alamat: this.alamat,
			ketuanohp: this.ketuanohp,
			tglpelayanan: this.tglpelayanan,
			kegiatannama: this.kegiatannama,
			kegiatankode: this.kegiatankode,
			kelompoknama: this.kelompoknama,
			kelompokkode: this.kelompokkode,
			materi: this.materi,
			pembicara: this.pembicara,
			lokasi: this.lokasi,
			keterangan: this.keterangan,
			biaya: this.biaya,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPcareKegiatanKelompokModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPcareKegiatanKelompokModel {
		let newModelJson = this.toJSON();

		if (updates.ketuanama) {
			newModelJson.ketuanama = updates.ketuanama;
		}

		if (updates.nama) {
			newModelJson.nama = updates.nama;
		}

		if (updates.eduid) {
			newModelJson.eduid = updates.eduid;
		}

		if (updates.clubid) {
			newModelJson.clubid = updates.clubid;
		}

		if (updates.kdprogram) {
			newModelJson.kdprogram = updates.kdprogram;
		}

		if (updates.nmprogram) {
			newModelJson.nmprogram = updates.nmprogram;
		}

		if (updates.tglmulai) {
			newModelJson.tglmulai = updates.tglmulai;
		}

		if (updates.tglakhir) {
			newModelJson.tglakhir = updates.tglakhir;
		}

		if (updates.alamat) {
			newModelJson.alamat = updates.alamat;
		}

		if (updates.ketuanohp) {
			newModelJson.ketuanohp = updates.ketuanohp;
		}

		if (updates.tglpelayanan) {
			newModelJson.tglpelayanan = updates.tglpelayanan;
		}

		if (updates.kegiatannama) {
			newModelJson.kegiatannama = updates.kegiatannama;
		}

		if (updates.kegiatankode) {
			newModelJson.kegiatankode = updates.kegiatankode;
		}

		if (updates.kelompoknama) {
			newModelJson.kelompoknama = updates.kelompoknama;
		}

		if (updates.kelompokkode) {
			newModelJson.kelompokkode = updates.kelompokkode;
		}

		if (updates.materi) {
			newModelJson.materi = updates.materi;
		}

		if (updates.pembicara) {
			newModelJson.pembicara = updates.pembicara;
		}

		if (updates.lokasi) {
			newModelJson.lokasi = updates.lokasi;
		}

		if (updates.keterangan) {
			newModelJson.keterangan = updates.keterangan;
		}

		if (updates.biaya) {
			newModelJson.biaya = updates.biaya;
		}

		return new BpjsPcareKegiatanKelompokModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPcareKegiatanKelompokModel)) {
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
