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
export class BpjsPcareRiwayatKunjunganModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'nokunjungan',
		'tglkunjungan',
		'providerpelayanan',
		'nokartu',
		'nama',
		'hubungankeluarga',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'nokunjungan',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPcareRiwayatKunjunganModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPcareRiwayatKunjunganModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	nokunjungan: string;

	/**
	 * .
	 */
	tglkunjungan: string;

	/**
	 * .
	 */
	providerpelayanan: string;

	/**
	 * .
	 */
	nokartu: string;

	/**
	 * .
	 */
	nama: string;

	/**
	 * .
	 */
	hubungankeluarga: string;

	/**
	 * Gender - Jenis Kelamin.
	 */
	sex: string;

	/**
	 * .
	 */
	tgllahir: string;

	/**
	 * .
	 */
	tglmulaiaktif: string;

	/**
	 * .
	 */
	tglakhirberlaku: string;

	/**
	 * .
	 */
	kodeppkpeserta: string;

	/**
	 * .
	 */
	kodeppkgigi: string;

	/**
	 * .
	 */
	jeniskelas: string;

	/**
	 * .
	 */
	jenispeserta: string;

	/**
	 * .
	 */
	goldarah: string;

	/**
	 * .
	 */
	nohp: string;

	/**
	 * .
	 */
	noktp: string;

	/**
	 * .
	 */
	asuransi: string;

	/**
	 * .
	 */
	poli: string;

	/**
	 * .
	 */
	jeniskunjungan: string;

	/**
	 * .
	 */
	progprolanis: string;

	/**
	 * .
	 */
	keluhan: string;

	/**
	 * .
	 */
	diagnosa: string;

	/**
	 * .
	 */
	diagnosa2: string;

	/**
	 * .
	 */
	diagnosa3: string;

	/**
	 * .
	 */
	kesadaran: string;

	/**
	 * .
	 */
	sistole: string;

	/**
	 * .
	 */
	diastole: string;

	/**
	 * .
	 */
	beratbadan: string;

	/**
	 * .
	 */
	tinggibadan: string;

	/**
	 * .
	 */
	respiratoryrate: string;

	/**
	 * .
	 */
	heartrate: string;

	/**
	 * .
	 */
	catatan: string;

	/**
	 * .
	 */
	pemeriksaanfisiklain: string;

	/**
	 * .
	 */
	tglpulang: string;

	/**
	 * .
	 */
	dokter: string;

	/**
	 * .
	 */
	statuspulang: string;

	/**
	 * .
	 */
	tingkatpelayanan: string;

	/**
	 * .
	 */
	rujukbalik: string;

	/**
	 * .
	 */
	providerasalrujuk: string;

	/**
	 * .
	 */
	providerrujuklanjut: string;

	/**
	 * .
	 */
	polirujukinternal: string;

	/**
	 * .
	 */
	polirujuklanjut: string;



	modelPropGroups: { [s: string]: Group } = BpjsPcareRiwayatKunjunganModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'nokunjungan',
				// % protected region % [Set displayName for noKunjungan here] off begin
				displayName: 'noKunjungan',
				// % protected region % [Set displayName for noKunjungan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noKunjungan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noKunjungan here] end
				// % protected region % [Set isSensitive for noKunjungan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noKunjungan here] end
				// % protected region % [Set readonly for noKunjungan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noKunjungan here] end
				validators: [
					// % protected region % [Add other validators for noKunjungan here] off begin
					// % protected region % [Add other validators for noKunjungan here] end
				],
				// % protected region % [Add any additional model attribute properties for noKunjungan here] off begin
				// % protected region % [Add any additional model attribute properties for noKunjungan here] end
			},
			{
				name: 'tglkunjungan',
				// % protected region % [Set displayName for tglkunjungan here] off begin
				displayName: 'tglkunjungan',
				// % protected region % [Set displayName for tglkunjungan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglkunjungan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglkunjungan here] end
				// % protected region % [Set isSensitive for tglkunjungan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglkunjungan here] end
				// % protected region % [Set readonly for tglkunjungan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglkunjungan here] end
				validators: [
					// % protected region % [Add other validators for tglkunjungan here] off begin
					// % protected region % [Add other validators for tglkunjungan here] end
				],
				// % protected region % [Add any additional model attribute properties for tglkunjungan here] off begin
				// % protected region % [Add any additional model attribute properties for tglkunjungan here] end
			},
			{
				name: 'providerpelayanan',
				// % protected region % [Set displayName for providerPelayanan here] off begin
				displayName: 'providerPelayanan',
				// % protected region % [Set displayName for providerPelayanan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for providerPelayanan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for providerPelayanan here] end
				// % protected region % [Set isSensitive for providerPelayanan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for providerPelayanan here] end
				// % protected region % [Set readonly for providerPelayanan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for providerPelayanan here] end
				validators: [
					// % protected region % [Add other validators for providerPelayanan here] off begin
					// % protected region % [Add other validators for providerPelayanan here] end
				],
				// % protected region % [Add any additional model attribute properties for providerPelayanan here] off begin
				// % protected region % [Add any additional model attribute properties for providerPelayanan here] end
			},
			{
				name: 'nokartu',
				// % protected region % [Set displayName for noKartu here] off begin
				displayName: 'noKartu',
				// % protected region % [Set displayName for noKartu here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noKartu here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noKartu here] end
				// % protected region % [Set isSensitive for noKartu here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noKartu here] end
				// % protected region % [Set readonly for noKartu here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noKartu here] end
				validators: [
					// % protected region % [Add other validators for noKartu here] off begin
					// % protected region % [Add other validators for noKartu here] end
				],
				// % protected region % [Add any additional model attribute properties for noKartu here] off begin
				// % protected region % [Add any additional model attribute properties for noKartu here] end
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
				name: 'hubungankeluarga',
				// % protected region % [Set displayName for hubunganKeluarga here] off begin
				displayName: 'hubunganKeluarga',
				// % protected region % [Set displayName for hubunganKeluarga here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for hubunganKeluarga here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for hubunganKeluarga here] end
				// % protected region % [Set isSensitive for hubunganKeluarga here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for hubunganKeluarga here] end
				// % protected region % [Set readonly for hubunganKeluarga here] off begin
				readOnly: false,
				// % protected region % [Set readonly for hubunganKeluarga here] end
				validators: [
					// % protected region % [Add other validators for hubunganKeluarga here] off begin
					// % protected region % [Add other validators for hubunganKeluarga here] end
				],
				// % protected region % [Add any additional model attribute properties for hubunganKeluarga here] off begin
				// % protected region % [Add any additional model attribute properties for hubunganKeluarga here] end
			},
			{
				name: 'sex',
				// % protected region % [Set displayName for sex here] off begin
				displayName: 'sex',
				// % protected region % [Set displayName for sex here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for sex here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for sex here] end
				// % protected region % [Set isSensitive for sex here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for sex here] end
				// % protected region % [Set readonly for sex here] off begin
				readOnly: false,
				// % protected region % [Set readonly for sex here] end
				validators: [
					// % protected region % [Add other validators for sex here] off begin
					// % protected region % [Add other validators for sex here] end
				],
				// % protected region % [Add any additional model attribute properties for sex here] off begin
				// % protected region % [Add any additional model attribute properties for sex here] end
			},
			{
				name: 'tgllahir',
				// % protected region % [Set displayName for tglLahir here] off begin
				displayName: 'tglLahir',
				// % protected region % [Set displayName for tglLahir here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglLahir here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglLahir here] end
				// % protected region % [Set isSensitive for tglLahir here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglLahir here] end
				// % protected region % [Set readonly for tglLahir here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglLahir here] end
				validators: [
					// % protected region % [Add other validators for tglLahir here] off begin
					// % protected region % [Add other validators for tglLahir here] end
				],
				// % protected region % [Add any additional model attribute properties for tglLahir here] off begin
				// % protected region % [Add any additional model attribute properties for tglLahir here] end
			},
			{
				name: 'tglmulaiaktif',
				// % protected region % [Set displayName for tglMulaiAktif here] off begin
				displayName: 'tglMulaiAktif',
				// % protected region % [Set displayName for tglMulaiAktif here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglMulaiAktif here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglMulaiAktif here] end
				// % protected region % [Set isSensitive for tglMulaiAktif here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglMulaiAktif here] end
				// % protected region % [Set readonly for tglMulaiAktif here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglMulaiAktif here] end
				validators: [
					// % protected region % [Add other validators for tglMulaiAktif here] off begin
					// % protected region % [Add other validators for tglMulaiAktif here] end
				],
				// % protected region % [Add any additional model attribute properties for tglMulaiAktif here] off begin
				// % protected region % [Add any additional model attribute properties for tglMulaiAktif here] end
			},
			{
				name: 'tglakhirberlaku',
				// % protected region % [Set displayName for tglAkhirBerlaku here] off begin
				displayName: 'tglAkhirBerlaku',
				// % protected region % [Set displayName for tglAkhirBerlaku here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglAkhirBerlaku here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglAkhirBerlaku here] end
				// % protected region % [Set isSensitive for tglAkhirBerlaku here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglAkhirBerlaku here] end
				// % protected region % [Set readonly for tglAkhirBerlaku here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglAkhirBerlaku here] end
				validators: [
					// % protected region % [Add other validators for tglAkhirBerlaku here] off begin
					// % protected region % [Add other validators for tglAkhirBerlaku here] end
				],
				// % protected region % [Add any additional model attribute properties for tglAkhirBerlaku here] off begin
				// % protected region % [Add any additional model attribute properties for tglAkhirBerlaku here] end
			},
			{
				name: 'kodeppkpeserta',
				// % protected region % [Set displayName for kodePPKPeserta here] off begin
				displayName: 'kodePPKPeserta',
				// % protected region % [Set displayName for kodePPKPeserta here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodePPKPeserta here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodePPKPeserta here] end
				// % protected region % [Set isSensitive for kodePPKPeserta here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodePPKPeserta here] end
				// % protected region % [Set readonly for kodePPKPeserta here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodePPKPeserta here] end
				validators: [
					// % protected region % [Add other validators for kodePPKPeserta here] off begin
					// % protected region % [Add other validators for kodePPKPeserta here] end
				],
				// % protected region % [Add any additional model attribute properties for kodePPKPeserta here] off begin
				// % protected region % [Add any additional model attribute properties for kodePPKPeserta here] end
			},
			{
				name: 'kodeppkgigi',
				// % protected region % [Set displayName for kodePPKGigi here] off begin
				displayName: 'kodePPKGigi',
				// % protected region % [Set displayName for kodePPKGigi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodePPKGigi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodePPKGigi here] end
				// % protected region % [Set isSensitive for kodePPKGigi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodePPKGigi here] end
				// % protected region % [Set readonly for kodePPKGigi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodePPKGigi here] end
				validators: [
					// % protected region % [Add other validators for kodePPKGigi here] off begin
					// % protected region % [Add other validators for kodePPKGigi here] end
				],
				// % protected region % [Add any additional model attribute properties for kodePPKGigi here] off begin
				// % protected region % [Add any additional model attribute properties for kodePPKGigi here] end
			},
			{
				name: 'jeniskelas',
				// % protected region % [Set displayName for jenisKelas here] off begin
				displayName: 'jenisKelas',
				// % protected region % [Set displayName for jenisKelas here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for jenisKelas here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for jenisKelas here] end
				// % protected region % [Set isSensitive for jenisKelas here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for jenisKelas here] end
				// % protected region % [Set readonly for jenisKelas here] off begin
				readOnly: false,
				// % protected region % [Set readonly for jenisKelas here] end
				validators: [
					// % protected region % [Add other validators for jenisKelas here] off begin
					// % protected region % [Add other validators for jenisKelas here] end
				],
				// % protected region % [Add any additional model attribute properties for jenisKelas here] off begin
				// % protected region % [Add any additional model attribute properties for jenisKelas here] end
			},
			{
				name: 'jenispeserta',
				// % protected region % [Set displayName for jenisPeserta here] off begin
				displayName: 'jenisPeserta',
				// % protected region % [Set displayName for jenisPeserta here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for jenisPeserta here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for jenisPeserta here] end
				// % protected region % [Set isSensitive for jenisPeserta here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for jenisPeserta here] end
				// % protected region % [Set readonly for jenisPeserta here] off begin
				readOnly: false,
				// % protected region % [Set readonly for jenisPeserta here] end
				validators: [
					// % protected region % [Add other validators for jenisPeserta here] off begin
					// % protected region % [Add other validators for jenisPeserta here] end
				],
				// % protected region % [Add any additional model attribute properties for jenisPeserta here] off begin
				// % protected region % [Add any additional model attribute properties for jenisPeserta here] end
			},
			{
				name: 'goldarah',
				// % protected region % [Set displayName for golDarah here] off begin
				displayName: 'golDarah',
				// % protected region % [Set displayName for golDarah here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for golDarah here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for golDarah here] end
				// % protected region % [Set isSensitive for golDarah here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for golDarah here] end
				// % protected region % [Set readonly for golDarah here] off begin
				readOnly: false,
				// % protected region % [Set readonly for golDarah here] end
				validators: [
					// % protected region % [Add other validators for golDarah here] off begin
					// % protected region % [Add other validators for golDarah here] end
				],
				// % protected region % [Add any additional model attribute properties for golDarah here] off begin
				// % protected region % [Add any additional model attribute properties for golDarah here] end
			},
			{
				name: 'nohp',
				// % protected region % [Set displayName for noHP here] off begin
				displayName: 'noHP',
				// % protected region % [Set displayName for noHP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noHP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noHP here] end
				// % protected region % [Set isSensitive for noHP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noHP here] end
				// % protected region % [Set readonly for noHP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noHP here] end
				validators: [
					// % protected region % [Add other validators for noHP here] off begin
					// % protected region % [Add other validators for noHP here] end
				],
				// % protected region % [Add any additional model attribute properties for noHP here] off begin
				// % protected region % [Add any additional model attribute properties for noHP here] end
			},
			{
				name: 'noktp',
				// % protected region % [Set displayName for noKTP here] off begin
				displayName: 'noKTP',
				// % protected region % [Set displayName for noKTP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noKTP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noKTP here] end
				// % protected region % [Set isSensitive for noKTP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noKTP here] end
				// % protected region % [Set readonly for noKTP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noKTP here] end
				validators: [
					// % protected region % [Add other validators for noKTP here] off begin
					// % protected region % [Add other validators for noKTP here] end
				],
				// % protected region % [Add any additional model attribute properties for noKTP here] off begin
				// % protected region % [Add any additional model attribute properties for noKTP here] end
			},
			{
				name: 'asuransi',
				// % protected region % [Set displayName for asuransi here] off begin
				displayName: 'asuransi',
				// % protected region % [Set displayName for asuransi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for asuransi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for asuransi here] end
				// % protected region % [Set isSensitive for asuransi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for asuransi here] end
				// % protected region % [Set readonly for asuransi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for asuransi here] end
				validators: [
					// % protected region % [Add other validators for asuransi here] off begin
					// % protected region % [Add other validators for asuransi here] end
				],
				// % protected region % [Add any additional model attribute properties for asuransi here] off begin
				// % protected region % [Add any additional model attribute properties for asuransi here] end
			},
			{
				name: 'poli',
				// % protected region % [Set displayName for poli here] off begin
				displayName: 'poli',
				// % protected region % [Set displayName for poli here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for poli here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for poli here] end
				// % protected region % [Set isSensitive for poli here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for poli here] end
				// % protected region % [Set readonly for poli here] off begin
				readOnly: false,
				// % protected region % [Set readonly for poli here] end
				validators: [
					// % protected region % [Add other validators for poli here] off begin
					// % protected region % [Add other validators for poli here] end
				],
				// % protected region % [Add any additional model attribute properties for poli here] off begin
				// % protected region % [Add any additional model attribute properties for poli here] end
			},
			{
				name: 'jeniskunjungan',
				// % protected region % [Set displayName for jenisKunjungan here] off begin
				displayName: 'jenisKunjungan',
				// % protected region % [Set displayName for jenisKunjungan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for jenisKunjungan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for jenisKunjungan here] end
				// % protected region % [Set isSensitive for jenisKunjungan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for jenisKunjungan here] end
				// % protected region % [Set readonly for jenisKunjungan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for jenisKunjungan here] end
				validators: [
					// % protected region % [Add other validators for jenisKunjungan here] off begin
					// % protected region % [Add other validators for jenisKunjungan here] end
				],
				// % protected region % [Add any additional model attribute properties for jenisKunjungan here] off begin
				// % protected region % [Add any additional model attribute properties for jenisKunjungan here] end
			},
			{
				name: 'progprolanis',
				// % protected region % [Set displayName for progProlanis here] off begin
				displayName: 'progProlanis',
				// % protected region % [Set displayName for progProlanis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for progProlanis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for progProlanis here] end
				// % protected region % [Set isSensitive for progProlanis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for progProlanis here] end
				// % protected region % [Set readonly for progProlanis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for progProlanis here] end
				validators: [
					// % protected region % [Add other validators for progProlanis here] off begin
					// % protected region % [Add other validators for progProlanis here] end
				],
				// % protected region % [Add any additional model attribute properties for progProlanis here] off begin
				// % protected region % [Add any additional model attribute properties for progProlanis here] end
			},
			{
				name: 'keluhan',
				// % protected region % [Set displayName for keluhan here] off begin
				displayName: 'keluhan',
				// % protected region % [Set displayName for keluhan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for keluhan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for keluhan here] end
				// % protected region % [Set isSensitive for keluhan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for keluhan here] end
				// % protected region % [Set readonly for keluhan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for keluhan here] end
				validators: [
					// % protected region % [Add other validators for keluhan here] off begin
					// % protected region % [Add other validators for keluhan here] end
				],
				// % protected region % [Add any additional model attribute properties for keluhan here] off begin
				// % protected region % [Add any additional model attribute properties for keluhan here] end
			},
			{
				name: 'diagnosa',
				// % protected region % [Set displayName for diagnosa here] off begin
				displayName: 'diagnosa',
				// % protected region % [Set displayName for diagnosa here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for diagnosa here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for diagnosa here] end
				// % protected region % [Set isSensitive for diagnosa here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for diagnosa here] end
				// % protected region % [Set readonly for diagnosa here] off begin
				readOnly: false,
				// % protected region % [Set readonly for diagnosa here] end
				validators: [
					// % protected region % [Add other validators for diagnosa here] off begin
					// % protected region % [Add other validators for diagnosa here] end
				],
				// % protected region % [Add any additional model attribute properties for diagnosa here] off begin
				// % protected region % [Add any additional model attribute properties for diagnosa here] end
			},
			{
				name: 'diagnosa2',
				// % protected region % [Set displayName for diagnosa2 here] off begin
				displayName: 'diagnosa2',
				// % protected region % [Set displayName for diagnosa2 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for diagnosa2 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for diagnosa2 here] end
				// % protected region % [Set isSensitive for diagnosa2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for diagnosa2 here] end
				// % protected region % [Set readonly for diagnosa2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for diagnosa2 here] end
				validators: [
					// % protected region % [Add other validators for diagnosa2 here] off begin
					// % protected region % [Add other validators for diagnosa2 here] end
				],
				// % protected region % [Add any additional model attribute properties for diagnosa2 here] off begin
				// % protected region % [Add any additional model attribute properties for diagnosa2 here] end
			},
			{
				name: 'diagnosa3',
				// % protected region % [Set displayName for diagnosa3 here] off begin
				displayName: 'diagnosa3',
				// % protected region % [Set displayName for diagnosa3 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for diagnosa3 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for diagnosa3 here] end
				// % protected region % [Set isSensitive for diagnosa3 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for diagnosa3 here] end
				// % protected region % [Set readonly for diagnosa3 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for diagnosa3 here] end
				validators: [
					// % protected region % [Add other validators for diagnosa3 here] off begin
					// % protected region % [Add other validators for diagnosa3 here] end
				],
				// % protected region % [Add any additional model attribute properties for diagnosa3 here] off begin
				// % protected region % [Add any additional model attribute properties for diagnosa3 here] end
			},
			{
				name: 'kesadaran',
				// % protected region % [Set displayName for kesadaran here] off begin
				displayName: 'kesadaran',
				// % protected region % [Set displayName for kesadaran here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kesadaran here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kesadaran here] end
				// % protected region % [Set isSensitive for kesadaran here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kesadaran here] end
				// % protected region % [Set readonly for kesadaran here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kesadaran here] end
				validators: [
					// % protected region % [Add other validators for kesadaran here] off begin
					// % protected region % [Add other validators for kesadaran here] end
				],
				// % protected region % [Add any additional model attribute properties for kesadaran here] off begin
				// % protected region % [Add any additional model attribute properties for kesadaran here] end
			},
			{
				name: 'sistole',
				// % protected region % [Set displayName for sistole here] off begin
				displayName: 'sistole',
				// % protected region % [Set displayName for sistole here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for sistole here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for sistole here] end
				// % protected region % [Set isSensitive for sistole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for sistole here] end
				// % protected region % [Set readonly for sistole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for sistole here] end
				validators: [
					// % protected region % [Add other validators for sistole here] off begin
					// % protected region % [Add other validators for sistole here] end
				],
				// % protected region % [Add any additional model attribute properties for sistole here] off begin
				// % protected region % [Add any additional model attribute properties for sistole here] end
			},
			{
				name: 'diastole',
				// % protected region % [Set displayName for diastole here] off begin
				displayName: 'diastole',
				// % protected region % [Set displayName for diastole here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for diastole here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for diastole here] end
				// % protected region % [Set isSensitive for diastole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for diastole here] end
				// % protected region % [Set readonly for diastole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for diastole here] end
				validators: [
					// % protected region % [Add other validators for diastole here] off begin
					// % protected region % [Add other validators for diastole here] end
				],
				// % protected region % [Add any additional model attribute properties for diastole here] off begin
				// % protected region % [Add any additional model attribute properties for diastole here] end
			},
			{
				name: 'beratbadan',
				// % protected region % [Set displayName for beratBadan here] off begin
				displayName: 'beratBadan',
				// % protected region % [Set displayName for beratBadan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for beratBadan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for beratBadan here] end
				// % protected region % [Set isSensitive for beratBadan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for beratBadan here] end
				// % protected region % [Set readonly for beratBadan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for beratBadan here] end
				validators: [
					// % protected region % [Add other validators for beratBadan here] off begin
					// % protected region % [Add other validators for beratBadan here] end
				],
				// % protected region % [Add any additional model attribute properties for beratBadan here] off begin
				// % protected region % [Add any additional model attribute properties for beratBadan here] end
			},
			{
				name: 'tinggibadan',
				// % protected region % [Set displayName for tinggiBadan here] off begin
				displayName: 'tinggiBadan',
				// % protected region % [Set displayName for tinggiBadan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tinggiBadan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tinggiBadan here] end
				// % protected region % [Set isSensitive for tinggiBadan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tinggiBadan here] end
				// % protected region % [Set readonly for tinggiBadan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tinggiBadan here] end
				validators: [
					// % protected region % [Add other validators for tinggiBadan here] off begin
					// % protected region % [Add other validators for tinggiBadan here] end
				],
				// % protected region % [Add any additional model attribute properties for tinggiBadan here] off begin
				// % protected region % [Add any additional model attribute properties for tinggiBadan here] end
			},
			{
				name: 'respiratoryrate',
				// % protected region % [Set displayName for respiratoryRate here] off begin
				displayName: 'respiratoryRate',
				// % protected region % [Set displayName for respiratoryRate here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for respiratoryRate here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for respiratoryRate here] end
				// % protected region % [Set isSensitive for respiratoryRate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for respiratoryRate here] end
				// % protected region % [Set readonly for respiratoryRate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for respiratoryRate here] end
				validators: [
					// % protected region % [Add other validators for respiratoryRate here] off begin
					// % protected region % [Add other validators for respiratoryRate here] end
				],
				// % protected region % [Add any additional model attribute properties for respiratoryRate here] off begin
				// % protected region % [Add any additional model attribute properties for respiratoryRate here] end
			},
			{
				name: 'heartrate',
				// % protected region % [Set displayName for heartRate here] off begin
				displayName: 'heartRate',
				// % protected region % [Set displayName for heartRate here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for heartRate here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for heartRate here] end
				// % protected region % [Set isSensitive for heartRate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for heartRate here] end
				// % protected region % [Set readonly for heartRate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for heartRate here] end
				validators: [
					// % protected region % [Add other validators for heartRate here] off begin
					// % protected region % [Add other validators for heartRate here] end
				],
				// % protected region % [Add any additional model attribute properties for heartRate here] off begin
				// % protected region % [Add any additional model attribute properties for heartRate here] end
			},
			{
				name: 'catatan',
				// % protected region % [Set displayName for catatan here] off begin
				displayName: 'catatan',
				// % protected region % [Set displayName for catatan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for catatan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for catatan here] end
				// % protected region % [Set isSensitive for catatan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for catatan here] end
				// % protected region % [Set readonly for catatan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for catatan here] end
				validators: [
					// % protected region % [Add other validators for catatan here] off begin
					// % protected region % [Add other validators for catatan here] end
				],
				// % protected region % [Add any additional model attribute properties for catatan here] off begin
				// % protected region % [Add any additional model attribute properties for catatan here] end
			},
			{
				name: 'pemeriksaanfisiklain',
				// % protected region % [Set displayName for pemeriksaanFisikLain here] off begin
				displayName: 'pemeriksaanFisikLain',
				// % protected region % [Set displayName for pemeriksaanFisikLain here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for pemeriksaanFisikLain here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for pemeriksaanFisikLain here] end
				// % protected region % [Set isSensitive for pemeriksaanFisikLain here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for pemeriksaanFisikLain here] end
				// % protected region % [Set readonly for pemeriksaanFisikLain here] off begin
				readOnly: false,
				// % protected region % [Set readonly for pemeriksaanFisikLain here] end
				validators: [
					// % protected region % [Add other validators for pemeriksaanFisikLain here] off begin
					// % protected region % [Add other validators for pemeriksaanFisikLain here] end
				],
				// % protected region % [Add any additional model attribute properties for pemeriksaanFisikLain here] off begin
				// % protected region % [Add any additional model attribute properties for pemeriksaanFisikLain here] end
			},
			{
				name: 'tglpulang',
				// % protected region % [Set displayName for tglPulang here] off begin
				displayName: 'tglPulang',
				// % protected region % [Set displayName for tglPulang here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglPulang here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglPulang here] end
				// % protected region % [Set isSensitive for tglPulang here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglPulang here] end
				// % protected region % [Set readonly for tglPulang here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglPulang here] end
				validators: [
					// % protected region % [Add other validators for tglPulang here] off begin
					// % protected region % [Add other validators for tglPulang here] end
				],
				// % protected region % [Add any additional model attribute properties for tglPulang here] off begin
				// % protected region % [Add any additional model attribute properties for tglPulang here] end
			},
			{
				name: 'dokter',
				// % protected region % [Set displayName for dokter here] off begin
				displayName: 'dokter',
				// % protected region % [Set displayName for dokter here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for dokter here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for dokter here] end
				// % protected region % [Set isSensitive for dokter here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for dokter here] end
				// % protected region % [Set readonly for dokter here] off begin
				readOnly: false,
				// % protected region % [Set readonly for dokter here] end
				validators: [
					// % protected region % [Add other validators for dokter here] off begin
					// % protected region % [Add other validators for dokter here] end
				],
				// % protected region % [Add any additional model attribute properties for dokter here] off begin
				// % protected region % [Add any additional model attribute properties for dokter here] end
			},
			{
				name: 'statuspulang',
				// % protected region % [Set displayName for statusPulang here] off begin
				displayName: 'statusPulang',
				// % protected region % [Set displayName for statusPulang here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for statusPulang here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for statusPulang here] end
				// % protected region % [Set isSensitive for statusPulang here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for statusPulang here] end
				// % protected region % [Set readonly for statusPulang here] off begin
				readOnly: false,
				// % protected region % [Set readonly for statusPulang here] end
				validators: [
					// % protected region % [Add other validators for statusPulang here] off begin
					// % protected region % [Add other validators for statusPulang here] end
				],
				// % protected region % [Add any additional model attribute properties for statusPulang here] off begin
				// % protected region % [Add any additional model attribute properties for statusPulang here] end
			},
			{
				name: 'tingkatpelayanan',
				// % protected region % [Set displayName for tingkatPelayanan here] off begin
				displayName: 'tingkatPelayanan',
				// % protected region % [Set displayName for tingkatPelayanan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tingkatPelayanan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tingkatPelayanan here] end
				// % protected region % [Set isSensitive for tingkatPelayanan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tingkatPelayanan here] end
				// % protected region % [Set readonly for tingkatPelayanan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tingkatPelayanan here] end
				validators: [
					// % protected region % [Add other validators for tingkatPelayanan here] off begin
					// % protected region % [Add other validators for tingkatPelayanan here] end
				],
				// % protected region % [Add any additional model attribute properties for tingkatPelayanan here] off begin
				// % protected region % [Add any additional model attribute properties for tingkatPelayanan here] end
			},
			{
				name: 'rujukbalik',
				// % protected region % [Set displayName for rujukBalik here] off begin
				displayName: 'rujukBalik',
				// % protected region % [Set displayName for rujukBalik here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for rujukBalik here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for rujukBalik here] end
				// % protected region % [Set isSensitive for rujukBalik here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for rujukBalik here] end
				// % protected region % [Set readonly for rujukBalik here] off begin
				readOnly: false,
				// % protected region % [Set readonly for rujukBalik here] end
				validators: [
					// % protected region % [Add other validators for rujukBalik here] off begin
					// % protected region % [Add other validators for rujukBalik here] end
				],
				// % protected region % [Add any additional model attribute properties for rujukBalik here] off begin
				// % protected region % [Add any additional model attribute properties for rujukBalik here] end
			},
			{
				name: 'providerasalrujuk',
				// % protected region % [Set displayName for providerAsalRujuk here] off begin
				displayName: 'providerAsalRujuk',
				// % protected region % [Set displayName for providerAsalRujuk here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for providerAsalRujuk here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for providerAsalRujuk here] end
				// % protected region % [Set isSensitive for providerAsalRujuk here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for providerAsalRujuk here] end
				// % protected region % [Set readonly for providerAsalRujuk here] off begin
				readOnly: false,
				// % protected region % [Set readonly for providerAsalRujuk here] end
				validators: [
					// % protected region % [Add other validators for providerAsalRujuk here] off begin
					// % protected region % [Add other validators for providerAsalRujuk here] end
				],
				// % protected region % [Add any additional model attribute properties for providerAsalRujuk here] off begin
				// % protected region % [Add any additional model attribute properties for providerAsalRujuk here] end
			},
			{
				name: 'providerrujuklanjut',
				// % protected region % [Set displayName for providerRujukLanjut here] off begin
				displayName: 'providerRujukLanjut',
				// % protected region % [Set displayName for providerRujukLanjut here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for providerRujukLanjut here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for providerRujukLanjut here] end
				// % protected region % [Set isSensitive for providerRujukLanjut here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for providerRujukLanjut here] end
				// % protected region % [Set readonly for providerRujukLanjut here] off begin
				readOnly: false,
				// % protected region % [Set readonly for providerRujukLanjut here] end
				validators: [
					// % protected region % [Add other validators for providerRujukLanjut here] off begin
					// % protected region % [Add other validators for providerRujukLanjut here] end
				],
				// % protected region % [Add any additional model attribute properties for providerRujukLanjut here] off begin
				// % protected region % [Add any additional model attribute properties for providerRujukLanjut here] end
			},
			{
				name: 'polirujukinternal',
				// % protected region % [Set displayName for poliRujukInternal here] off begin
				displayName: 'poliRujukInternal',
				// % protected region % [Set displayName for poliRujukInternal here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for poliRujukInternal here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for poliRujukInternal here] end
				// % protected region % [Set isSensitive for poliRujukInternal here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for poliRujukInternal here] end
				// % protected region % [Set readonly for poliRujukInternal here] off begin
				readOnly: false,
				// % protected region % [Set readonly for poliRujukInternal here] end
				validators: [
					// % protected region % [Add other validators for poliRujukInternal here] off begin
					// % protected region % [Add other validators for poliRujukInternal here] end
				],
				// % protected region % [Add any additional model attribute properties for poliRujukInternal here] off begin
				// % protected region % [Add any additional model attribute properties for poliRujukInternal here] end
			},
			{
				name: 'polirujuklanjut',
				// % protected region % [Set displayName for poliRujukLanjut here] off begin
				displayName: 'poliRujukLanjut',
				// % protected region % [Set displayName for poliRujukLanjut here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for poliRujukLanjut here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for poliRujukLanjut here] end
				// % protected region % [Set isSensitive for poliRujukLanjut here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for poliRujukLanjut here] end
				// % protected region % [Set readonly for poliRujukLanjut here] off begin
				readOnly: false,
				// % protected region % [Set readonly for poliRujukLanjut here] end
				validators: [
					// % protected region % [Add other validators for poliRujukLanjut here] off begin
					// % protected region % [Add other validators for poliRujukLanjut here] end
				],
				// % protected region % [Add any additional model attribute properties for poliRujukLanjut here] off begin
				// % protected region % [Add any additional model attribute properties for poliRujukLanjut here] end
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
				case 'nokunjungan':
					break;
				case 'tglkunjungan':
					break;
				case 'providerpelayanan':
					break;
				case 'nokartu':
					break;
				case 'nama':
					break;
				case 'hubungankeluarga':
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
	static deepParse(data: string | { [K in keyof BpjsPcareRiwayatKunjunganModel]?: BpjsPcareRiwayatKunjunganModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPcareRiwayatKunjunganModel(data);
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
	 * `let bpjsPcareRiwayatKunjunganModel = new BpjsPcareRiwayatKunjunganModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPcareRiwayatKunjunganModel,
	 *    it is expected as a JSON string or as a nullable BpjsPcareRiwayatKunjunganModel.
	 */
	constructor(data?: string | Partial<BpjsPcareRiwayatKunjunganModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPcareRiwayatKunjunganModel>
				: data;

			this.nokunjungan = json.nokunjungan;
			this.tglkunjungan = json.tglkunjungan;
			this.providerpelayanan = json.providerpelayanan;
			this.nokartu = json.nokartu;
			this.nama = json.nama;
			this.hubungankeluarga = json.hubungankeluarga;
			this.sex = json.sex;
			this.tgllahir = json.tgllahir;
			this.tglmulaiaktif = json.tglmulaiaktif;
			this.tglakhirberlaku = json.tglakhirberlaku;
			this.kodeppkpeserta = json.kodeppkpeserta;
			this.kodeppkgigi = json.kodeppkgigi;
			this.jeniskelas = json.jeniskelas;
			this.jenispeserta = json.jenispeserta;
			this.goldarah = json.goldarah;
			this.nohp = json.nohp;
			this.noktp = json.noktp;
			this.asuransi = json.asuransi;
			this.poli = json.poli;
			this.jeniskunjungan = json.jeniskunjungan;
			this.progprolanis = json.progprolanis;
			this.keluhan = json.keluhan;
			this.diagnosa = json.diagnosa;
			this.diagnosa2 = json.diagnosa2;
			this.diagnosa3 = json.diagnosa3;
			this.kesadaran = json.kesadaran;
			this.sistole = json.sistole;
			this.diastole = json.diastole;
			this.beratbadan = json.beratbadan;
			this.tinggibadan = json.tinggibadan;
			this.respiratoryrate = json.respiratoryrate;
			this.heartrate = json.heartrate;
			this.catatan = json.catatan;
			this.pemeriksaanfisiklain = json.pemeriksaanfisiklain;
			this.tglpulang = json.tglpulang;
			this.dokter = json.dokter;
			this.statuspulang = json.statuspulang;
			this.tingkatpelayanan = json.tingkatpelayanan;
			this.rujukbalik = json.rujukbalik;
			this.providerasalrujuk = json.providerasalrujuk;
			this.providerrujuklanjut = json.providerrujuklanjut;
			this.polirujukinternal = json.polirujukinternal;
			this.polirujuklanjut = json.polirujuklanjut;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			nokunjungan: this.nokunjungan,
			tglkunjungan: this.tglkunjungan,
			providerpelayanan: this.providerpelayanan,
			nokartu: this.nokartu,
			nama: this.nama,
			hubungankeluarga: this.hubungankeluarga,
			sex: this.sex,
			tgllahir: this.tgllahir,
			tglmulaiaktif: this.tglmulaiaktif,
			tglakhirberlaku: this.tglakhirberlaku,
			kodeppkpeserta: this.kodeppkpeserta,
			kodeppkgigi: this.kodeppkgigi,
			jeniskelas: this.jeniskelas,
			jenispeserta: this.jenispeserta,
			goldarah: this.goldarah,
			nohp: this.nohp,
			noktp: this.noktp,
			asuransi: this.asuransi,
			poli: this.poli,
			jeniskunjungan: this.jeniskunjungan,
			progprolanis: this.progprolanis,
			keluhan: this.keluhan,
			diagnosa: this.diagnosa,
			diagnosa2: this.diagnosa2,
			diagnosa3: this.diagnosa3,
			kesadaran: this.kesadaran,
			sistole: this.sistole,
			diastole: this.diastole,
			beratbadan: this.beratbadan,
			tinggibadan: this.tinggibadan,
			respiratoryrate: this.respiratoryrate,
			heartrate: this.heartrate,
			catatan: this.catatan,
			pemeriksaanfisiklain: this.pemeriksaanfisiklain,
			tglpulang: this.tglpulang,
			dokter: this.dokter,
			statuspulang: this.statuspulang,
			tingkatpelayanan: this.tingkatpelayanan,
			rujukbalik: this.rujukbalik,
			providerasalrujuk: this.providerasalrujuk,
			providerrujuklanjut: this.providerrujuklanjut,
			polirujukinternal: this.polirujukinternal,
			polirujuklanjut: this.polirujuklanjut,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPcareRiwayatKunjunganModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPcareRiwayatKunjunganModel {
		let newModelJson = this.toJSON();

		if (updates.nokunjungan) {
			newModelJson.nokunjungan = updates.nokunjungan;
		}

		if (updates.tglkunjungan) {
			newModelJson.tglkunjungan = updates.tglkunjungan;
		}

		if (updates.providerpelayanan) {
			newModelJson.providerpelayanan = updates.providerpelayanan;
		}

		if (updates.nokartu) {
			newModelJson.nokartu = updates.nokartu;
		}

		if (updates.nama) {
			newModelJson.nama = updates.nama;
		}

		if (updates.hubungankeluarga) {
			newModelJson.hubungankeluarga = updates.hubungankeluarga;
		}

		if (updates.sex) {
			newModelJson.sex = updates.sex;
		}

		if (updates.tgllahir) {
			newModelJson.tgllahir = updates.tgllahir;
		}

		if (updates.tglmulaiaktif) {
			newModelJson.tglmulaiaktif = updates.tglmulaiaktif;
		}

		if (updates.tglakhirberlaku) {
			newModelJson.tglakhirberlaku = updates.tglakhirberlaku;
		}

		if (updates.kodeppkpeserta) {
			newModelJson.kodeppkpeserta = updates.kodeppkpeserta;
		}

		if (updates.kodeppkgigi) {
			newModelJson.kodeppkgigi = updates.kodeppkgigi;
		}

		if (updates.jeniskelas) {
			newModelJson.jeniskelas = updates.jeniskelas;
		}

		if (updates.jenispeserta) {
			newModelJson.jenispeserta = updates.jenispeserta;
		}

		if (updates.goldarah) {
			newModelJson.goldarah = updates.goldarah;
		}

		if (updates.nohp) {
			newModelJson.nohp = updates.nohp;
		}

		if (updates.noktp) {
			newModelJson.noktp = updates.noktp;
		}

		if (updates.asuransi) {
			newModelJson.asuransi = updates.asuransi;
		}

		if (updates.poli) {
			newModelJson.poli = updates.poli;
		}

		if (updates.jeniskunjungan) {
			newModelJson.jeniskunjungan = updates.jeniskunjungan;
		}

		if (updates.progprolanis) {
			newModelJson.progprolanis = updates.progprolanis;
		}

		if (updates.keluhan) {
			newModelJson.keluhan = updates.keluhan;
		}

		if (updates.diagnosa) {
			newModelJson.diagnosa = updates.diagnosa;
		}

		if (updates.diagnosa2) {
			newModelJson.diagnosa2 = updates.diagnosa2;
		}

		if (updates.diagnosa3) {
			newModelJson.diagnosa3 = updates.diagnosa3;
		}

		if (updates.kesadaran) {
			newModelJson.kesadaran = updates.kesadaran;
		}

		if (updates.sistole) {
			newModelJson.sistole = updates.sistole;
		}

		if (updates.diastole) {
			newModelJson.diastole = updates.diastole;
		}

		if (updates.beratbadan) {
			newModelJson.beratbadan = updates.beratbadan;
		}

		if (updates.tinggibadan) {
			newModelJson.tinggibadan = updates.tinggibadan;
		}

		if (updates.respiratoryrate) {
			newModelJson.respiratoryrate = updates.respiratoryrate;
		}

		if (updates.heartrate) {
			newModelJson.heartrate = updates.heartrate;
		}

		if (updates.catatan) {
			newModelJson.catatan = updates.catatan;
		}

		if (updates.pemeriksaanfisiklain) {
			newModelJson.pemeriksaanfisiklain = updates.pemeriksaanfisiklain;
		}

		if (updates.tglpulang) {
			newModelJson.tglpulang = updates.tglpulang;
		}

		if (updates.dokter) {
			newModelJson.dokter = updates.dokter;
		}

		if (updates.statuspulang) {
			newModelJson.statuspulang = updates.statuspulang;
		}

		if (updates.tingkatpelayanan) {
			newModelJson.tingkatpelayanan = updates.tingkatpelayanan;
		}

		if (updates.rujukbalik) {
			newModelJson.rujukbalik = updates.rujukbalik;
		}

		if (updates.providerasalrujuk) {
			newModelJson.providerasalrujuk = updates.providerasalrujuk;
		}

		if (updates.providerrujuklanjut) {
			newModelJson.providerrujuklanjut = updates.providerrujuklanjut;
		}

		if (updates.polirujukinternal) {
			newModelJson.polirujukinternal = updates.polirujukinternal;
		}

		if (updates.polirujuklanjut) {
			newModelJson.polirujuklanjut = updates.polirujuklanjut;
		}

		return new BpjsPcareRiwayatKunjunganModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPcareRiwayatKunjunganModel)) {
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
