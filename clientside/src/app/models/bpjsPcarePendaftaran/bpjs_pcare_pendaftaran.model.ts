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
import {PatientVisitModel} from '../patientVisit/patient_visit.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsPcarePendaftaranModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'nourut',
		'tgldaftar',
		'providerpelayanan',
		'nokartu',
		'nama',
		'hubungankeluarga',
		'sex',
		'tgllahir',
		'tglakhirberlaku',
		'kdproviderpst',
		'kdprovidergigi',
		'jnspeserta',
		'goldarah',
		'nohp',
		'noktp',
		'aktif',
		'ketaktif',
		'asuransi',
		'kdpoli',
		'nmpoli',
		'polisakit',
		'keluhan',
		'status',
		'sistole',
		'diastole',
		'beratbadan',
		'tinggibadan',
		'resprate',
		'heartrate',
		'kdtkp',
		'nmtkp',
		'kdproviderpelayanan',
		'nmproviderpelayanan',
		'nmproviderpst',
		'nmprovidergigi',
		'kodekls',
		'namakls',
		'kodepeserta',
		'namapeserta',
		'kdasuransi',
		'noasuransi',
		'lingkarperut',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'nourut',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPcarePendaftaranModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPcarePendaftaranModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	nourut: string;

	/**
	 * .
	 */
	tgldaftar: string;

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
	 * .
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
	kdproviderpst: string;

	/**
	 * .
	 */
	kdprovidergigi: string;

	/**
	 * .
	 */
	jnskelas: string;

	/**
	 * .
	 */
	jnspeserta: string;

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
	aktif: string;

	/**
	 * .
	 */
	ketaktif: string;

	/**
	 * .
	 */
	asuransi: string;

	/**
	 * .
	 */
	kdpoli: string;

	/**
	 * .
	 */
	nmpoli: string;

	/**
	 * .
	 */
	polisakit: string;

	/**
	 * .
	 */
	keluhan: string;

	/**
	 * .
	 */
	kunjsakit: string;

	/**
	 * .
	 */
	status: string;

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
	resprate: string;

	/**
	 * .
	 */
	heartrate: string;

	/**
	 * .
	 */
	kdtkp: string;

	/**
	 * .
	 */
	nmtkp: string;

	/**
	 * .
	 */
	kdproviderpelayanan: string;

	/**
	 * .
	 */
	nmproviderpelayanan: string;

	/**
	 * .
	 */
	nmproviderpst: string;

	/**
	 * .
	 */
	nmprovidergigi: string;

	/**
	 * UNDER JENIS KELAS.
	 */
	kodekls: string;

	/**
	 * UNDER JENIS KELAS.
	 */
	namakls: string;

	/**
	 * UNDER JENIS PESERTA.
	 */
	kodepeserta: string;

	/**
	 * UNDER JENIS PESERTA.
	 */
	namapeserta: string;

	/**
	 * .
	 */
	kdasuransi: string;

	/**
	 * .
	 */
	nmasuransi: string;

	/**
	 * .
	 */
	noasuransi: string;

	/**
	 * .
	 */
	lingkarperut: string;

	patientVisitId: string;

	patientVisit: PatientVisitModel;

	modelPropGroups: { [s: string]: Group } = BpjsPcarePendaftaranModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'nourut',
				// % protected region % [Set displayName for noUrut here] off begin
				displayName: 'noUrut',
				// % protected region % [Set displayName for noUrut here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noUrut here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noUrut here] end
				// % protected region % [Set isSensitive for noUrut here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noUrut here] end
				// % protected region % [Set readonly for noUrut here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noUrut here] end
				validators: [
					// % protected region % [Add other validators for noUrut here] off begin
					// % protected region % [Add other validators for noUrut here] end
				],
				// % protected region % [Add any additional model attribute properties for noUrut here] off begin
				// % protected region % [Add any additional model attribute properties for noUrut here] end
			},
			{
				name: 'tgldaftar',
				// % protected region % [Set displayName for tgldaftar here] off begin
				displayName: 'tgldaftar',
				// % protected region % [Set displayName for tgldaftar here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tgldaftar here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tgldaftar here] end
				// % protected region % [Set isSensitive for tgldaftar here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tgldaftar here] end
				// % protected region % [Set readonly for tgldaftar here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tgldaftar here] end
				validators: [
					// % protected region % [Add other validators for tgldaftar here] off begin
					// % protected region % [Add other validators for tgldaftar here] end
				],
				// % protected region % [Add any additional model attribute properties for tgldaftar here] off begin
				// % protected region % [Add any additional model attribute properties for tgldaftar here] end
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
				name: 'kdproviderpst',
				// % protected region % [Set displayName for kdProviderPst here] off begin
				displayName: 'kdProviderPst',
				// % protected region % [Set displayName for kdProviderPst here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdProviderPst here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdProviderPst here] end
				// % protected region % [Set isSensitive for kdProviderPst here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdProviderPst here] end
				// % protected region % [Set readonly for kdProviderPst here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdProviderPst here] end
				validators: [
					// % protected region % [Add other validators for kdProviderPst here] off begin
					// % protected region % [Add other validators for kdProviderPst here] end
				],
				// % protected region % [Add any additional model attribute properties for kdProviderPst here] off begin
				// % protected region % [Add any additional model attribute properties for kdProviderPst here] end
			},
			{
				name: 'kdprovidergigi',
				// % protected region % [Set displayName for kdProviderGigi here] off begin
				displayName: 'kdProviderGigi',
				// % protected region % [Set displayName for kdProviderGigi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdProviderGigi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdProviderGigi here] end
				// % protected region % [Set isSensitive for kdProviderGigi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdProviderGigi here] end
				// % protected region % [Set readonly for kdProviderGigi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdProviderGigi here] end
				validators: [
					// % protected region % [Add other validators for kdProviderGigi here] off begin
					// % protected region % [Add other validators for kdProviderGigi here] end
				],
				// % protected region % [Add any additional model attribute properties for kdProviderGigi here] off begin
				// % protected region % [Add any additional model attribute properties for kdProviderGigi here] end
			},
			{
				name: 'jnskelas',
				// % protected region % [Set displayName for jnsKelas here] off begin
				displayName: 'jnsKelas',
				// % protected region % [Set displayName for jnsKelas here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for jnsKelas here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for jnsKelas here] end
				// % protected region % [Set isSensitive for jnsKelas here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for jnsKelas here] end
				// % protected region % [Set readonly for jnsKelas here] off begin
				readOnly: false,
				// % protected region % [Set readonly for jnsKelas here] end
				validators: [
					// % protected region % [Add other validators for jnsKelas here] off begin
					// % protected region % [Add other validators for jnsKelas here] end
				],
				// % protected region % [Add any additional model attribute properties for jnsKelas here] off begin
				// % protected region % [Add any additional model attribute properties for jnsKelas here] end
			},
			{
				name: 'jnspeserta',
				// % protected region % [Set displayName for jnsPeserta here] off begin
				displayName: 'jnsPeserta',
				// % protected region % [Set displayName for jnsPeserta here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for jnsPeserta here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for jnsPeserta here] end
				// % protected region % [Set isSensitive for jnsPeserta here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for jnsPeserta here] end
				// % protected region % [Set readonly for jnsPeserta here] off begin
				readOnly: false,
				// % protected region % [Set readonly for jnsPeserta here] end
				validators: [
					// % protected region % [Add other validators for jnsPeserta here] off begin
					// % protected region % [Add other validators for jnsPeserta here] end
				],
				// % protected region % [Add any additional model attribute properties for jnsPeserta here] off begin
				// % protected region % [Add any additional model attribute properties for jnsPeserta here] end
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
				name: 'aktif',
				// % protected region % [Set displayName for aktif here] off begin
				displayName: 'aktif',
				// % protected region % [Set displayName for aktif here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for aktif here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for aktif here] end
				// % protected region % [Set isSensitive for aktif here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for aktif here] end
				// % protected region % [Set readonly for aktif here] off begin
				readOnly: false,
				// % protected region % [Set readonly for aktif here] end
				validators: [
					// % protected region % [Add other validators for aktif here] off begin
					// % protected region % [Add other validators for aktif here] end
				],
				// % protected region % [Add any additional model attribute properties for aktif here] off begin
				// % protected region % [Add any additional model attribute properties for aktif here] end
			},
			{
				name: 'ketaktif',
				// % protected region % [Set displayName for ketAktif here] off begin
				displayName: 'ketAktif',
				// % protected region % [Set displayName for ketAktif here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ketAktif here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ketAktif here] end
				// % protected region % [Set isSensitive for ketAktif here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ketAktif here] end
				// % protected region % [Set readonly for ketAktif here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ketAktif here] end
				validators: [
					// % protected region % [Add other validators for ketAktif here] off begin
					// % protected region % [Add other validators for ketAktif here] end
				],
				// % protected region % [Add any additional model attribute properties for ketAktif here] off begin
				// % protected region % [Add any additional model attribute properties for ketAktif here] end
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
				name: 'kdpoli',
				// % protected region % [Set displayName for kdPoli here] off begin
				displayName: 'kdPoli',
				// % protected region % [Set displayName for kdPoli here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdPoli here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdPoli here] end
				// % protected region % [Set isSensitive for kdPoli here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdPoli here] end
				// % protected region % [Set readonly for kdPoli here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdPoli here] end
				validators: [
					// % protected region % [Add other validators for kdPoli here] off begin
					// % protected region % [Add other validators for kdPoli here] end
				],
				// % protected region % [Add any additional model attribute properties for kdPoli here] off begin
				// % protected region % [Add any additional model attribute properties for kdPoli here] end
			},
			{
				name: 'nmpoli',
				// % protected region % [Set displayName for nmPoli here] off begin
				displayName: 'nmPoli',
				// % protected region % [Set displayName for nmPoli here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmPoli here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmPoli here] end
				// % protected region % [Set isSensitive for nmPoli here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmPoli here] end
				// % protected region % [Set readonly for nmPoli here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmPoli here] end
				validators: [
					// % protected region % [Add other validators for nmPoli here] off begin
					// % protected region % [Add other validators for nmPoli here] end
				],
				// % protected region % [Add any additional model attribute properties for nmPoli here] off begin
				// % protected region % [Add any additional model attribute properties for nmPoli here] end
			},
			{
				name: 'polisakit',
				// % protected region % [Set displayName for poliSakit here] off begin
				displayName: 'poliSakit',
				// % protected region % [Set displayName for poliSakit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for poliSakit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for poliSakit here] end
				// % protected region % [Set isSensitive for poliSakit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for poliSakit here] end
				// % protected region % [Set readonly for poliSakit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for poliSakit here] end
				validators: [
					// % protected region % [Add other validators for poliSakit here] off begin
					// % protected region % [Add other validators for poliSakit here] end
				],
				// % protected region % [Add any additional model attribute properties for poliSakit here] off begin
				// % protected region % [Add any additional model attribute properties for poliSakit here] end
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
				name: 'kunjsakit',
				// % protected region % [Set displayName for kunjSakit here] off begin
				displayName: 'kunjSakit',
				// % protected region % [Set displayName for kunjSakit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kunjSakit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kunjSakit here] end
				// % protected region % [Set isSensitive for kunjSakit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kunjSakit here] end
				// % protected region % [Set readonly for kunjSakit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kunjSakit here] end
				validators: [
					// % protected region % [Add other validators for kunjSakit here] off begin
					// % protected region % [Add other validators for kunjSakit here] end
				],
				// % protected region % [Add any additional model attribute properties for kunjSakit here] off begin
				// % protected region % [Add any additional model attribute properties for kunjSakit here] end
			},
			{
				name: 'status',
				// % protected region % [Set displayName for status here] off begin
				displayName: 'status',
				// % protected region % [Set displayName for status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for status here] end
				// % protected region % [Set isSensitive for status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for status here] end
				// % protected region % [Set readonly for status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for status here] end
				validators: [
					// % protected region % [Add other validators for status here] off begin
					// % protected region % [Add other validators for status here] end
				],
				// % protected region % [Add any additional model attribute properties for status here] off begin
				// % protected region % [Add any additional model attribute properties for status here] end
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
				name: 'resprate',
				// % protected region % [Set displayName for respRate here] off begin
				displayName: 'respRate',
				// % protected region % [Set displayName for respRate here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for respRate here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for respRate here] end
				// % protected region % [Set isSensitive for respRate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for respRate here] end
				// % protected region % [Set readonly for respRate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for respRate here] end
				validators: [
					// % protected region % [Add other validators for respRate here] off begin
					// % protected region % [Add other validators for respRate here] end
				],
				// % protected region % [Add any additional model attribute properties for respRate here] off begin
				// % protected region % [Add any additional model attribute properties for respRate here] end
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
				name: 'kdtkp',
				// % protected region % [Set displayName for kdTkp here] off begin
				displayName: 'kdTkp',
				// % protected region % [Set displayName for kdTkp here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdTkp here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdTkp here] end
				// % protected region % [Set isSensitive for kdTkp here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdTkp here] end
				// % protected region % [Set readonly for kdTkp here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdTkp here] end
				validators: [
					// % protected region % [Add other validators for kdTkp here] off begin
					// % protected region % [Add other validators for kdTkp here] end
				],
				// % protected region % [Add any additional model attribute properties for kdTkp here] off begin
				// % protected region % [Add any additional model attribute properties for kdTkp here] end
			},
			{
				name: 'nmtkp',
				// % protected region % [Set displayName for nmTkp here] off begin
				displayName: 'nmTkp',
				// % protected region % [Set displayName for nmTkp here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmTkp here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmTkp here] end
				// % protected region % [Set isSensitive for nmTkp here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmTkp here] end
				// % protected region % [Set readonly for nmTkp here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmTkp here] end
				validators: [
					// % protected region % [Add other validators for nmTkp here] off begin
					// % protected region % [Add other validators for nmTkp here] end
				],
				// % protected region % [Add any additional model attribute properties for nmTkp here] off begin
				// % protected region % [Add any additional model attribute properties for nmTkp here] end
			},
			{
				name: 'kdproviderpelayanan',
				// % protected region % [Set displayName for kdProviderPelayanan here] off begin
				displayName: 'kdProviderPelayanan',
				// % protected region % [Set displayName for kdProviderPelayanan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdProviderPelayanan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdProviderPelayanan here] end
				// % protected region % [Set isSensitive for kdProviderPelayanan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdProviderPelayanan here] end
				// % protected region % [Set readonly for kdProviderPelayanan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdProviderPelayanan here] end
				validators: [
					// % protected region % [Add other validators for kdProviderPelayanan here] off begin
					// % protected region % [Add other validators for kdProviderPelayanan here] end
				],
				// % protected region % [Add any additional model attribute properties for kdProviderPelayanan here] off begin
				// % protected region % [Add any additional model attribute properties for kdProviderPelayanan here] end
			},
			{
				name: 'nmproviderpelayanan',
				// % protected region % [Set displayName for nmProviderPelayanan here] off begin
				displayName: 'nmProviderPelayanan',
				// % protected region % [Set displayName for nmProviderPelayanan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmProviderPelayanan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmProviderPelayanan here] end
				// % protected region % [Set isSensitive for nmProviderPelayanan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmProviderPelayanan here] end
				// % protected region % [Set readonly for nmProviderPelayanan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmProviderPelayanan here] end
				validators: [
					// % protected region % [Add other validators for nmProviderPelayanan here] off begin
					// % protected region % [Add other validators for nmProviderPelayanan here] end
				],
				// % protected region % [Add any additional model attribute properties for nmProviderPelayanan here] off begin
				// % protected region % [Add any additional model attribute properties for nmProviderPelayanan here] end
			},
			{
				name: 'nmproviderpst',
				// % protected region % [Set displayName for nmProviderPst here] off begin
				displayName: 'nmProviderPst',
				// % protected region % [Set displayName for nmProviderPst here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmProviderPst here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmProviderPst here] end
				// % protected region % [Set isSensitive for nmProviderPst here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmProviderPst here] end
				// % protected region % [Set readonly for nmProviderPst here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmProviderPst here] end
				validators: [
					// % protected region % [Add other validators for nmProviderPst here] off begin
					// % protected region % [Add other validators for nmProviderPst here] end
				],
				// % protected region % [Add any additional model attribute properties for nmProviderPst here] off begin
				// % protected region % [Add any additional model attribute properties for nmProviderPst here] end
			},
			{
				name: 'nmprovidergigi',
				// % protected region % [Set displayName for nmProviderGigi here] off begin
				displayName: 'nmProviderGigi',
				// % protected region % [Set displayName for nmProviderGigi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmProviderGigi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmProviderGigi here] end
				// % protected region % [Set isSensitive for nmProviderGigi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmProviderGigi here] end
				// % protected region % [Set readonly for nmProviderGigi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmProviderGigi here] end
				validators: [
					// % protected region % [Add other validators for nmProviderGigi here] off begin
					// % protected region % [Add other validators for nmProviderGigi here] end
				],
				// % protected region % [Add any additional model attribute properties for nmProviderGigi here] off begin
				// % protected region % [Add any additional model attribute properties for nmProviderGigi here] end
			},
			{
				name: 'kodekls',
				// % protected region % [Set displayName for kodeKls here] off begin
				displayName: 'kodeKls',
				// % protected region % [Set displayName for kodeKls here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodeKls here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodeKls here] end
				// % protected region % [Set isSensitive for kodeKls here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodeKls here] end
				// % protected region % [Set readonly for kodeKls here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodeKls here] end
				validators: [
					// % protected region % [Add other validators for kodeKls here] off begin
					// % protected region % [Add other validators for kodeKls here] end
				],
				// % protected region % [Add any additional model attribute properties for kodeKls here] off begin
				// % protected region % [Add any additional model attribute properties for kodeKls here] end
			},
			{
				name: 'namakls',
				// % protected region % [Set displayName for namaKls here] off begin
				displayName: 'namaKls',
				// % protected region % [Set displayName for namaKls here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for namaKls here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for namaKls here] end
				// % protected region % [Set isSensitive for namaKls here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for namaKls here] end
				// % protected region % [Set readonly for namaKls here] off begin
				readOnly: false,
				// % protected region % [Set readonly for namaKls here] end
				validators: [
					// % protected region % [Add other validators for namaKls here] off begin
					// % protected region % [Add other validators for namaKls here] end
				],
				// % protected region % [Add any additional model attribute properties for namaKls here] off begin
				// % protected region % [Add any additional model attribute properties for namaKls here] end
			},
			{
				name: 'kodepeserta',
				// % protected region % [Set displayName for kodePeserta here] off begin
				displayName: 'kodePeserta',
				// % protected region % [Set displayName for kodePeserta here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodePeserta here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodePeserta here] end
				// % protected region % [Set isSensitive for kodePeserta here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodePeserta here] end
				// % protected region % [Set readonly for kodePeserta here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodePeserta here] end
				validators: [
					// % protected region % [Add other validators for kodePeserta here] off begin
					// % protected region % [Add other validators for kodePeserta here] end
				],
				// % protected region % [Add any additional model attribute properties for kodePeserta here] off begin
				// % protected region % [Add any additional model attribute properties for kodePeserta here] end
			},
			{
				name: 'namapeserta',
				// % protected region % [Set displayName for namaPeserta here] off begin
				displayName: 'namaPeserta',
				// % protected region % [Set displayName for namaPeserta here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for namaPeserta here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for namaPeserta here] end
				// % protected region % [Set isSensitive for namaPeserta here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for namaPeserta here] end
				// % protected region % [Set readonly for namaPeserta here] off begin
				readOnly: false,
				// % protected region % [Set readonly for namaPeserta here] end
				validators: [
					// % protected region % [Add other validators for namaPeserta here] off begin
					// % protected region % [Add other validators for namaPeserta here] end
				],
				// % protected region % [Add any additional model attribute properties for namaPeserta here] off begin
				// % protected region % [Add any additional model attribute properties for namaPeserta here] end
			},
			{
				name: 'kdasuransi',
				// % protected region % [Set displayName for kdAsuransi here] off begin
				displayName: 'kdAsuransi',
				// % protected region % [Set displayName for kdAsuransi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdAsuransi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdAsuransi here] end
				// % protected region % [Set isSensitive for kdAsuransi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdAsuransi here] end
				// % protected region % [Set readonly for kdAsuransi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdAsuransi here] end
				validators: [
					// % protected region % [Add other validators for kdAsuransi here] off begin
					// % protected region % [Add other validators for kdAsuransi here] end
				],
				// % protected region % [Add any additional model attribute properties for kdAsuransi here] off begin
				// % protected region % [Add any additional model attribute properties for kdAsuransi here] end
			},
			{
				name: 'nmasuransi',
				// % protected region % [Set displayName for nmAsuransi here] off begin
				displayName: 'nmAsuransi',
				// % protected region % [Set displayName for nmAsuransi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmAsuransi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmAsuransi here] end
				// % protected region % [Set isSensitive for nmAsuransi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmAsuransi here] end
				// % protected region % [Set readonly for nmAsuransi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmAsuransi here] end
				validators: [
					// % protected region % [Add other validators for nmAsuransi here] off begin
					// % protected region % [Add other validators for nmAsuransi here] end
				],
				// % protected region % [Add any additional model attribute properties for nmAsuransi here] off begin
				// % protected region % [Add any additional model attribute properties for nmAsuransi here] end
			},
			{
				name: 'noasuransi',
				// % protected region % [Set displayName for noAsuransi here] off begin
				displayName: 'noAsuransi',
				// % protected region % [Set displayName for noAsuransi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noAsuransi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noAsuransi here] end
				// % protected region % [Set isSensitive for noAsuransi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noAsuransi here] end
				// % protected region % [Set readonly for noAsuransi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noAsuransi here] end
				validators: [
					// % protected region % [Add other validators for noAsuransi here] off begin
					// % protected region % [Add other validators for noAsuransi here] end
				],
				// % protected region % [Add any additional model attribute properties for noAsuransi here] off begin
				// % protected region % [Add any additional model attribute properties for noAsuransi here] end
			},
			{
				name: 'lingkarperut',
				// % protected region % [Set displayName for lingkarPerut here] off begin
				displayName: 'lingkarPerut',
				// % protected region % [Set displayName for lingkarPerut here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for lingkarPerut here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for lingkarPerut here] end
				// % protected region % [Set isSensitive for lingkarPerut here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for lingkarPerut here] end
				// % protected region % [Set readonly for lingkarPerut here] off begin
				readOnly: false,
				// % protected region % [Set readonly for lingkarPerut here] end
				validators: [
					// % protected region % [Add other validators for lingkarPerut here] off begin
					// % protected region % [Add other validators for lingkarPerut here] end
				],
				// % protected region % [Add any additional model attribute properties for lingkarPerut here] off begin
				// % protected region % [Add any additional model attribute properties for lingkarPerut here] end
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
				id: 'patientVisit',
				type: ModelRelationType.ONE,
				name: 'patientVisitId',
				// % protected region % [Customise your label for Patient Visit here] off begin
				label: 'Patient Visit',
				// % protected region % [Customise your label for Patient Visit here] end
				entityName: 'PatientVisitModel',
				// % protected region % [Customise your display name for Patient Visit here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'visitNumber',
				// % protected region % [Customise your display name for Patient Visit here] end
				validators: [
					// % protected region % [Add other validators for Patient Visit here] off begin
					// % protected region % [Add other validators for Patient Visit here] end
				],
				// % protected region % [Add any additional field for relation Patient Visit here] off begin
				// % protected region % [Add any additional field for relation Patient Visit here] end
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
				case 'nourut':
					break;
				case 'tgldaftar':
					break;
				case 'providerpelayanan':
					break;
				case 'nokartu':
					break;
				case 'nama':
					break;
				case 'hubungankeluarga':
					break;
				case 'sex':
					break;
				case 'tgllahir':
					break;
				case 'tglakhirberlaku':
					break;
				case 'kdproviderpst':
					break;
				case 'kdprovidergigi':
					break;
				case 'jnspeserta':
					break;
				case 'goldarah':
					break;
				case 'nohp':
					break;
				case 'noktp':
					break;
				case 'aktif':
					break;
				case 'ketaktif':
					break;
				case 'asuransi':
					break;
				case 'kdpoli':
					break;
				case 'nmpoli':
					break;
				case 'polisakit':
					break;
				case 'keluhan':
					break;
				case 'status':
					break;
				case 'sistole':
					break;
				case 'diastole':
					break;
				case 'beratbadan':
					break;
				case 'tinggibadan':
					break;
				case 'resprate':
					break;
				case 'heartrate':
					break;
				case 'kdtkp':
					break;
				case 'nmtkp':
					break;
				case 'kdproviderpelayanan':
					break;
				case 'nmproviderpelayanan':
					break;
				case 'nmproviderpst':
					break;
				case 'nmprovidergigi':
					break;
				case 'kodekls':
					break;
				case 'namakls':
					break;
				case 'kodepeserta':
					break;
				case 'namapeserta':
					break;
				case 'kdasuransi':
					break;
				case 'noasuransi':
					break;
				case 'lingkarperut':
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
	static deepParse(data: string | { [K in keyof BpjsPcarePendaftaranModel]?: BpjsPcarePendaftaranModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPcarePendaftaranModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.patientVisit) {
			currentModel.patientVisitId = json.patientVisit.id;
			returned = _.union(returned, PatientVisitModel.deepParse(json.patientVisit));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsPcarePendaftaranModel = new BpjsPcarePendaftaranModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPcarePendaftaranModel,
	 *    it is expected as a JSON string or as a nullable BpjsPcarePendaftaranModel.
	 */
	constructor(data?: string | Partial<BpjsPcarePendaftaranModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPcarePendaftaranModel>
				: data;

			this.nourut = json.nourut;
			this.tgldaftar = json.tgldaftar;
			this.providerpelayanan = json.providerpelayanan;
			this.nokartu = json.nokartu;
			this.nama = json.nama;
			this.hubungankeluarga = json.hubungankeluarga;
			this.sex = json.sex;
			this.tgllahir = json.tgllahir;
			this.tglmulaiaktif = json.tglmulaiaktif;
			this.tglakhirberlaku = json.tglakhirberlaku;
			this.kdproviderpst = json.kdproviderpst;
			this.kdprovidergigi = json.kdprovidergigi;
			this.jnskelas = json.jnskelas;
			this.jnspeserta = json.jnspeserta;
			this.goldarah = json.goldarah;
			this.nohp = json.nohp;
			this.noktp = json.noktp;
			this.aktif = json.aktif;
			this.ketaktif = json.ketaktif;
			this.asuransi = json.asuransi;
			this.kdpoli = json.kdpoli;
			this.nmpoli = json.nmpoli;
			this.polisakit = json.polisakit;
			this.keluhan = json.keluhan;
			this.kunjsakit = json.kunjsakit;
			this.status = json.status;
			this.sistole = json.sistole;
			this.diastole = json.diastole;
			this.beratbadan = json.beratbadan;
			this.tinggibadan = json.tinggibadan;
			this.resprate = json.resprate;
			this.heartrate = json.heartrate;
			this.kdtkp = json.kdtkp;
			this.nmtkp = json.nmtkp;
			this.kdproviderpelayanan = json.kdproviderpelayanan;
			this.nmproviderpelayanan = json.nmproviderpelayanan;
			this.nmproviderpst = json.nmproviderpst;
			this.nmprovidergigi = json.nmprovidergigi;
			this.kodekls = json.kodekls;
			this.namakls = json.namakls;
			this.kodepeserta = json.kodepeserta;
			this.namapeserta = json.namapeserta;
			this.kdasuransi = json.kdasuransi;
			this.nmasuransi = json.nmasuransi;
			this.noasuransi = json.noasuransi;
			this.lingkarperut = json.lingkarperut;
			this.patientVisitId = json.patientVisitId;
			this.patientVisit = json.patientVisit;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			nourut: this.nourut,
			tgldaftar: this.tgldaftar,
			providerpelayanan: this.providerpelayanan,
			nokartu: this.nokartu,
			nama: this.nama,
			hubungankeluarga: this.hubungankeluarga,
			sex: this.sex,
			tgllahir: this.tgllahir,
			tglmulaiaktif: this.tglmulaiaktif,
			tglakhirberlaku: this.tglakhirberlaku,
			kdproviderpst: this.kdproviderpst,
			kdprovidergigi: this.kdprovidergigi,
			jnskelas: this.jnskelas,
			jnspeserta: this.jnspeserta,
			goldarah: this.goldarah,
			nohp: this.nohp,
			noktp: this.noktp,
			aktif: this.aktif,
			ketaktif: this.ketaktif,
			asuransi: this.asuransi,
			kdpoli: this.kdpoli,
			nmpoli: this.nmpoli,
			polisakit: this.polisakit,
			keluhan: this.keluhan,
			kunjsakit: this.kunjsakit,
			status: this.status,
			sistole: this.sistole,
			diastole: this.diastole,
			beratbadan: this.beratbadan,
			tinggibadan: this.tinggibadan,
			resprate: this.resprate,
			heartrate: this.heartrate,
			kdtkp: this.kdtkp,
			nmtkp: this.nmtkp,
			kdproviderpelayanan: this.kdproviderpelayanan,
			nmproviderpelayanan: this.nmproviderpelayanan,
			nmproviderpst: this.nmproviderpst,
			nmprovidergigi: this.nmprovidergigi,
			kodekls: this.kodekls,
			namakls: this.namakls,
			kodepeserta: this.kodepeserta,
			namapeserta: this.namapeserta,
			kdasuransi: this.kdasuransi,
			nmasuransi: this.nmasuransi,
			noasuransi: this.noasuransi,
			lingkarperut: this.lingkarperut,
			patientVisitId: this.patientVisitId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPcarePendaftaranModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPcarePendaftaranModel {
		let newModelJson = this.toJSON();

		if (updates.nourut) {
			newModelJson.nourut = updates.nourut;
		}

		if (updates.tgldaftar) {
			newModelJson.tgldaftar = updates.tgldaftar;
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

		if (updates.kdproviderpst) {
			newModelJson.kdproviderpst = updates.kdproviderpst;
		}

		if (updates.kdprovidergigi) {
			newModelJson.kdprovidergigi = updates.kdprovidergigi;
		}

		if (updates.jnskelas) {
			newModelJson.jnskelas = updates.jnskelas;
		}

		if (updates.jnspeserta) {
			newModelJson.jnspeserta = updates.jnspeserta;
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

		if (updates.aktif) {
			newModelJson.aktif = updates.aktif;
		}

		if (updates.ketaktif) {
			newModelJson.ketaktif = updates.ketaktif;
		}

		if (updates.asuransi) {
			newModelJson.asuransi = updates.asuransi;
		}

		if (updates.kdpoli) {
			newModelJson.kdpoli = updates.kdpoli;
		}

		if (updates.nmpoli) {
			newModelJson.nmpoli = updates.nmpoli;
		}

		if (updates.polisakit) {
			newModelJson.polisakit = updates.polisakit;
		}

		if (updates.keluhan) {
			newModelJson.keluhan = updates.keluhan;
		}

		if (updates.kunjsakit) {
			newModelJson.kunjsakit = updates.kunjsakit;
		}

		if (updates.status) {
			newModelJson.status = updates.status;
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

		if (updates.resprate) {
			newModelJson.resprate = updates.resprate;
		}

		if (updates.heartrate) {
			newModelJson.heartrate = updates.heartrate;
		}

		if (updates.kdtkp) {
			newModelJson.kdtkp = updates.kdtkp;
		}

		if (updates.nmtkp) {
			newModelJson.nmtkp = updates.nmtkp;
		}

		if (updates.kdproviderpelayanan) {
			newModelJson.kdproviderpelayanan = updates.kdproviderpelayanan;
		}

		if (updates.nmproviderpelayanan) {
			newModelJson.nmproviderpelayanan = updates.nmproviderpelayanan;
		}

		if (updates.nmproviderpst) {
			newModelJson.nmproviderpst = updates.nmproviderpst;
		}

		if (updates.nmprovidergigi) {
			newModelJson.nmprovidergigi = updates.nmprovidergigi;
		}

		if (updates.kodekls) {
			newModelJson.kodekls = updates.kodekls;
		}

		if (updates.namakls) {
			newModelJson.namakls = updates.namakls;
		}

		if (updates.kodepeserta) {
			newModelJson.kodepeserta = updates.kodepeserta;
		}

		if (updates.namapeserta) {
			newModelJson.namapeserta = updates.namapeserta;
		}

		if (updates.kdasuransi) {
			newModelJson.kdasuransi = updates.kdasuransi;
		}

		if (updates.nmasuransi) {
			newModelJson.nmasuransi = updates.nmasuransi;
		}

		if (updates.noasuransi) {
			newModelJson.noasuransi = updates.noasuransi;
		}

		if (updates.lingkarperut) {
			newModelJson.lingkarperut = updates.lingkarperut;
		}

		if (updates.patientVisitId) {
			newModelJson.patientVisitId = updates.patientVisitId;
		}

		return new BpjsPcarePendaftaranModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPcarePendaftaranModel)) {
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
			'patientVisitId',
			'patientVisit',
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
		if (!this.patientVisit) {
			this.patientVisitId = null;
		} else {
			this.patientVisitId = this.patientVisit.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
