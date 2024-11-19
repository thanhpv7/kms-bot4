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
export class BpjsPcarePesertaKegiatanKelompokModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'eduid',
		'nokartu',
		'nama',
		'hubungankeluarga',
		'sex',
		'tgllahir',
		'tglmulaiaktif',
		'tglakhirberlaku',
		'kdprovider',
		'nmprovider',
		'kdprovidergigi',
		'nmprovidergigi',
		'namakelas',
		'namapeserta',
		'kodepeserta',
		'goldarah',
		'nohp',
		'noktp',
		'pstprol',
		'pstprb',
		'ketaktif',
		'kdasuransi',
		'nmasuransi',
		'noasuransi',
		'cob',
		'tunggakan',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'eduid',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPcarePesertaKegiatanKelompokModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPcarePesertaKegiatanKelompokModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	eduid: string;

	/**
	 * noKartu.
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
	 * kdProviderPst.
	 */
	kdprovider: string;

	/**
	 * nmProviderPst.
	 */
	nmprovider: string;

	/**
	 * .
	 */
	kdprovidergigi: string;

	/**
	 * .
	 */
	nmprovidergigi: string;

	/**
	 * nama.
	 */
	namakelas: string;

	/**
	 * .
	 */
	kodekelas: string;

	/**
	 * .
	 */
	namapeserta: string;

	/**
	 * .
	 */
	kodepeserta: string;

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
	pstprol: string;

	/**
	 * .
	 */
	pstprb: string;

	/**
	 * .
	 */
	ketaktif: string;

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
	cob: string;

	/**
	 * .
	 */
	tunggakan: string;



	modelPropGroups: { [s: string]: Group } = BpjsPcarePesertaKegiatanKelompokModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
				name: 'kdprovider',
				// % protected region % [Set displayName for kdProvider here] off begin
				displayName: 'kdProvider',
				// % protected region % [Set displayName for kdProvider here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdProvider here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdProvider here] end
				// % protected region % [Set isSensitive for kdProvider here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdProvider here] end
				// % protected region % [Set readonly for kdProvider here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdProvider here] end
				validators: [
					// % protected region % [Add other validators for kdProvider here] off begin
					// % protected region % [Add other validators for kdProvider here] end
				],
				// % protected region % [Add any additional model attribute properties for kdProvider here] off begin
				// % protected region % [Add any additional model attribute properties for kdProvider here] end
			},
			{
				name: 'nmprovider',
				// % protected region % [Set displayName for nmProvider here] off begin
				displayName: 'nmProvider',
				// % protected region % [Set displayName for nmProvider here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmProvider here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmProvider here] end
				// % protected region % [Set isSensitive for nmProvider here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmProvider here] end
				// % protected region % [Set readonly for nmProvider here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmProvider here] end
				validators: [
					// % protected region % [Add other validators for nmProvider here] off begin
					// % protected region % [Add other validators for nmProvider here] end
				],
				// % protected region % [Add any additional model attribute properties for nmProvider here] off begin
				// % protected region % [Add any additional model attribute properties for nmProvider here] end
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
				name: 'namakelas',
				// % protected region % [Set displayName for namaKelas here] off begin
				displayName: 'namaKelas',
				// % protected region % [Set displayName for namaKelas here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for namaKelas here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for namaKelas here] end
				// % protected region % [Set isSensitive for namaKelas here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for namaKelas here] end
				// % protected region % [Set readonly for namaKelas here] off begin
				readOnly: false,
				// % protected region % [Set readonly for namaKelas here] end
				validators: [
					// % protected region % [Add other validators for namaKelas here] off begin
					// % protected region % [Add other validators for namaKelas here] end
				],
				// % protected region % [Add any additional model attribute properties for namaKelas here] off begin
				// % protected region % [Add any additional model attribute properties for namaKelas here] end
			},
			{
				name: 'kodekelas',
				// % protected region % [Set displayName for kodeKelas here] off begin
				displayName: 'kodeKelas',
				// % protected region % [Set displayName for kodeKelas here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kodeKelas here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kodeKelas here] end
				// % protected region % [Set isSensitive for kodeKelas here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kodeKelas here] end
				// % protected region % [Set readonly for kodeKelas here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kodeKelas here] end
				validators: [
					// % protected region % [Add other validators for kodeKelas here] off begin
					// % protected region % [Add other validators for kodeKelas here] end
				],
				// % protected region % [Add any additional model attribute properties for kodeKelas here] off begin
				// % protected region % [Add any additional model attribute properties for kodeKelas here] end
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
				name: 'pstprol',
				// % protected region % [Set displayName for pstProl here] off begin
				displayName: 'pstProl',
				// % protected region % [Set displayName for pstProl here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for pstProl here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for pstProl here] end
				// % protected region % [Set isSensitive for pstProl here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for pstProl here] end
				// % protected region % [Set readonly for pstProl here] off begin
				readOnly: false,
				// % protected region % [Set readonly for pstProl here] end
				validators: [
					// % protected region % [Add other validators for pstProl here] off begin
					// % protected region % [Add other validators for pstProl here] end
				],
				// % protected region % [Add any additional model attribute properties for pstProl here] off begin
				// % protected region % [Add any additional model attribute properties for pstProl here] end
			},
			{
				name: 'pstprb',
				// % protected region % [Set displayName for pstPrb here] off begin
				displayName: 'pstPrb',
				// % protected region % [Set displayName for pstPrb here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for pstPrb here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for pstPrb here] end
				// % protected region % [Set isSensitive for pstPrb here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for pstPrb here] end
				// % protected region % [Set readonly for pstPrb here] off begin
				readOnly: false,
				// % protected region % [Set readonly for pstPrb here] end
				validators: [
					// % protected region % [Add other validators for pstPrb here] off begin
					// % protected region % [Add other validators for pstPrb here] end
				],
				// % protected region % [Add any additional model attribute properties for pstPrb here] off begin
				// % protected region % [Add any additional model attribute properties for pstPrb here] end
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
				name: 'cob',
				// % protected region % [Set displayName for cob here] off begin
				displayName: 'cob',
				// % protected region % [Set displayName for cob here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for cob here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for cob here] end
				// % protected region % [Set isSensitive for cob here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for cob here] end
				// % protected region % [Set readonly for cob here] off begin
				readOnly: false,
				// % protected region % [Set readonly for cob here] end
				validators: [
					// % protected region % [Add other validators for cob here] off begin
					// % protected region % [Add other validators for cob here] end
				],
				// % protected region % [Add any additional model attribute properties for cob here] off begin
				// % protected region % [Add any additional model attribute properties for cob here] end
			},
			{
				name: 'tunggakan',
				// % protected region % [Set displayName for tunggakan here] off begin
				displayName: 'tunggakan',
				// % protected region % [Set displayName for tunggakan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tunggakan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tunggakan here] end
				// % protected region % [Set isSensitive for tunggakan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tunggakan here] end
				// % protected region % [Set readonly for tunggakan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tunggakan here] end
				validators: [
					// % protected region % [Add other validators for tunggakan here] off begin
					// % protected region % [Add other validators for tunggakan here] end
				],
				// % protected region % [Add any additional model attribute properties for tunggakan here] off begin
				// % protected region % [Add any additional model attribute properties for tunggakan here] end
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
				case 'eduid':
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
				case 'tglmulaiaktif':
					break;
				case 'tglakhirberlaku':
					break;
				case 'kdprovider':
					break;
				case 'nmprovider':
					break;
				case 'kdprovidergigi':
					break;
				case 'nmprovidergigi':
					break;
				case 'namakelas':
					break;
				case 'namapeserta':
					break;
				case 'kodepeserta':
					break;
				case 'goldarah':
					break;
				case 'nohp':
					break;
				case 'noktp':
					break;
				case 'pstprol':
					break;
				case 'pstprb':
					break;
				case 'ketaktif':
					break;
				case 'kdasuransi':
					break;
				case 'nmasuransi':
					break;
				case 'noasuransi':
					break;
				case 'cob':
					break;
				case 'tunggakan':
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
	static deepParse(data: string | { [K in keyof BpjsPcarePesertaKegiatanKelompokModel]?: BpjsPcarePesertaKegiatanKelompokModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPcarePesertaKegiatanKelompokModel(data);
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
	 * `let bpjsPcarePesertaKegiatanKelompokModel = new BpjsPcarePesertaKegiatanKelompokModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPcarePesertaKegiatanKelompokModel,
	 *    it is expected as a JSON string or as a nullable BpjsPcarePesertaKegiatanKelompokModel.
	 */
	constructor(data?: string | Partial<BpjsPcarePesertaKegiatanKelompokModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPcarePesertaKegiatanKelompokModel>
				: data;

			this.eduid = json.eduid;
			this.nokartu = json.nokartu;
			this.nama = json.nama;
			this.hubungankeluarga = json.hubungankeluarga;
			this.sex = json.sex;
			this.tgllahir = json.tgllahir;
			this.tglmulaiaktif = json.tglmulaiaktif;
			this.tglakhirberlaku = json.tglakhirberlaku;
			this.kdprovider = json.kdprovider;
			this.nmprovider = json.nmprovider;
			this.kdprovidergigi = json.kdprovidergigi;
			this.nmprovidergigi = json.nmprovidergigi;
			this.namakelas = json.namakelas;
			this.kodekelas = json.kodekelas;
			this.namapeserta = json.namapeserta;
			this.kodepeserta = json.kodepeserta;
			this.goldarah = json.goldarah;
			this.nohp = json.nohp;
			this.noktp = json.noktp;
			this.pstprol = json.pstprol;
			this.pstprb = json.pstprb;
			this.ketaktif = json.ketaktif;
			this.kdasuransi = json.kdasuransi;
			this.nmasuransi = json.nmasuransi;
			this.noasuransi = json.noasuransi;
			this.cob = json.cob;
			this.tunggakan = json.tunggakan;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			eduid: this.eduid,
			nokartu: this.nokartu,
			nama: this.nama,
			hubungankeluarga: this.hubungankeluarga,
			sex: this.sex,
			tgllahir: this.tgllahir,
			tglmulaiaktif: this.tglmulaiaktif,
			tglakhirberlaku: this.tglakhirberlaku,
			kdprovider: this.kdprovider,
			nmprovider: this.nmprovider,
			kdprovidergigi: this.kdprovidergigi,
			nmprovidergigi: this.nmprovidergigi,
			namakelas: this.namakelas,
			kodekelas: this.kodekelas,
			namapeserta: this.namapeserta,
			kodepeserta: this.kodepeserta,
			goldarah: this.goldarah,
			nohp: this.nohp,
			noktp: this.noktp,
			pstprol: this.pstprol,
			pstprb: this.pstprb,
			ketaktif: this.ketaktif,
			kdasuransi: this.kdasuransi,
			nmasuransi: this.nmasuransi,
			noasuransi: this.noasuransi,
			cob: this.cob,
			tunggakan: this.tunggakan,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPcarePesertaKegiatanKelompokModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPcarePesertaKegiatanKelompokModel {
		let newModelJson = this.toJSON();

		if (updates.eduid) {
			newModelJson.eduid = updates.eduid;
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

		if (updates.kdprovider) {
			newModelJson.kdprovider = updates.kdprovider;
		}

		if (updates.nmprovider) {
			newModelJson.nmprovider = updates.nmprovider;
		}

		if (updates.kdprovidergigi) {
			newModelJson.kdprovidergigi = updates.kdprovidergigi;
		}

		if (updates.nmprovidergigi) {
			newModelJson.nmprovidergigi = updates.nmprovidergigi;
		}

		if (updates.namakelas) {
			newModelJson.namakelas = updates.namakelas;
		}

		if (updates.kodekelas) {
			newModelJson.kodekelas = updates.kodekelas;
		}

		if (updates.namapeserta) {
			newModelJson.namapeserta = updates.namapeserta;
		}

		if (updates.kodepeserta) {
			newModelJson.kodepeserta = updates.kodepeserta;
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

		if (updates.pstprol) {
			newModelJson.pstprol = updates.pstprol;
		}

		if (updates.pstprb) {
			newModelJson.pstprb = updates.pstprb;
		}

		if (updates.ketaktif) {
			newModelJson.ketaktif = updates.ketaktif;
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

		if (updates.cob) {
			newModelJson.cob = updates.cob;
		}

		if (updates.tunggakan) {
			newModelJson.tunggakan = updates.tunggakan;
		}

		return new BpjsPcarePesertaKegiatanKelompokModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPcarePesertaKegiatanKelompokModel)) {
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
