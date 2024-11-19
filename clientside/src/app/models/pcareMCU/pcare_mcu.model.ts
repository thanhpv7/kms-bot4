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
export class PcareMCUModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'kodeMCU',
		'noKunjungan',
		'kodeProvider',
		'namaProvider',
		'tanggalPelayanan',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'kodeMCU',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PcareMCUModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PcareMCUModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	kodeMCU: string;

	/**
	 * .
	 */
	noKunjungan: string;

	/**
	 * .
	 */
	kodeProvider: string;

	/**
	 * .
	 */
	namaProvider: string;

	/**
	 * .
	 */
	tanggalPelayanan: string;

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
	radiologiFoto: string;

	/**
	 * .
	 */
	hemoglobin: string;

	/**
	 * .
	 */
	leukosit: string;

	/**
	 * .
	 */
	eritrosit: string;

	/**
	 * .
	 */
	lajuEndapDarah: string;

	/**
	 * .
	 */
	hematokrit: string;

	/**
	 * .
	 */
	trombosit: string;

	/**
	 * .
	 */
	hdl: string;

	/**
	 * .
	 */
	ldl: string;

	/**
	 * .
	 */
	cholesterol: string;

	/**
	 * .
	 */
	trigliserida: string;

	/**
	 * .
	 */
	sewaktu: string;

	/**
	 * .
	 */
	puasa: string;

	/**
	 * .
	 */
	postPrandial: string;

	/**
	 * .
	 */
	hba1c: string;

	/**
	 * .
	 */
	sgot: string;

	/**
	 * .
	 */
	sgpt: string;

	/**
	 * .
	 */
	gamma: string;

	/**
	 * .
	 */
	proteinKualitatif: string;

	/**
	 * .
	 */
	albumin: string;

	/**
	 * .
	 */
	creatinine: string;

	/**
	 * .
	 */
	ureum: string;

	/**
	 * .
	 */
	asam: string;

	/**
	 * .
	 */
	abi: string;

	/**
	 * .
	 */
	ekg: string;

	/**
	 * .
	 */
	echo: string;

	/**
	 * .
	 */
	funduskopi: string;

	/**
	 * .
	 */
	pemeriksaanLain: string;

	/**
	 * .
	 */
	keterangan: string;



	modelPropGroups: { [s: string]: Group } = PcareMCUModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'kodeMCU',
				// % protected region % [Set displayName for Kode MCU here] off begin
				displayName: 'Kode MCU',
				// % protected region % [Set displayName for Kode MCU here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kode MCU here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kode MCU here] end
				// % protected region % [Set isSensitive for Kode MCU here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kode MCU here] end
				// % protected region % [Set readonly for Kode MCU here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kode MCU here] end
				validators: [
					// % protected region % [Add other validators for Kode MCU here] off begin
					// % protected region % [Add other validators for Kode MCU here] end
				],
				// % protected region % [Add any additional model attribute properties for Kode MCU here] off begin
				// % protected region % [Add any additional model attribute properties for Kode MCU here] end
			},
			{
				name: 'noKunjungan',
				// % protected region % [Set displayName for No Kunjungan here] off begin
				displayName: 'No Kunjungan',
				// % protected region % [Set displayName for No Kunjungan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for No Kunjungan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for No Kunjungan here] end
				// % protected region % [Set isSensitive for No Kunjungan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for No Kunjungan here] end
				// % protected region % [Set readonly for No Kunjungan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for No Kunjungan here] end
				validators: [
					// % protected region % [Add other validators for No Kunjungan here] off begin
					// % protected region % [Add other validators for No Kunjungan here] end
				],
				// % protected region % [Add any additional model attribute properties for No Kunjungan here] off begin
				// % protected region % [Add any additional model attribute properties for No Kunjungan here] end
			},
			{
				name: 'kodeProvider',
				// % protected region % [Set displayName for Kode Provider here] off begin
				displayName: 'Kode Provider',
				// % protected region % [Set displayName for Kode Provider here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kode Provider here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kode Provider here] end
				// % protected region % [Set isSensitive for Kode Provider here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kode Provider here] end
				// % protected region % [Set readonly for Kode Provider here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kode Provider here] end
				validators: [
					// % protected region % [Add other validators for Kode Provider here] off begin
					// % protected region % [Add other validators for Kode Provider here] end
				],
				// % protected region % [Add any additional model attribute properties for Kode Provider here] off begin
				// % protected region % [Add any additional model attribute properties for Kode Provider here] end
			},
			{
				name: 'namaProvider',
				// % protected region % [Set displayName for Nama Provider here] off begin
				displayName: 'Nama Provider',
				// % protected region % [Set displayName for Nama Provider here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nama Provider here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nama Provider here] end
				// % protected region % [Set isSensitive for Nama Provider here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nama Provider here] end
				// % protected region % [Set readonly for Nama Provider here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nama Provider here] end
				validators: [
					// % protected region % [Add other validators for Nama Provider here] off begin
					// % protected region % [Add other validators for Nama Provider here] end
				],
				// % protected region % [Add any additional model attribute properties for Nama Provider here] off begin
				// % protected region % [Add any additional model attribute properties for Nama Provider here] end
			},
			{
				name: 'tanggalPelayanan',
				// % protected region % [Set displayName for Tanggal Pelayanan here] off begin
				displayName: 'Tanggal Pelayanan',
				// % protected region % [Set displayName for Tanggal Pelayanan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tanggal Pelayanan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tanggal Pelayanan here] end
				// % protected region % [Set isSensitive for Tanggal Pelayanan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tanggal Pelayanan here] end
				// % protected region % [Set readonly for Tanggal Pelayanan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tanggal Pelayanan here] end
				validators: [
					// % protected region % [Add other validators for Tanggal Pelayanan here] off begin
					// % protected region % [Add other validators for Tanggal Pelayanan here] end
				],
				// % protected region % [Add any additional model attribute properties for Tanggal Pelayanan here] off begin
				// % protected region % [Add any additional model attribute properties for Tanggal Pelayanan here] end
			},
			{
				name: 'sistole',
				// % protected region % [Set displayName for Sistole here] off begin
				displayName: 'Sistole',
				// % protected region % [Set displayName for Sistole here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sistole here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sistole here] end
				// % protected region % [Set isSensitive for Sistole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sistole here] end
				// % protected region % [Set readonly for Sistole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sistole here] end
				validators: [
					// % protected region % [Add other validators for Sistole here] off begin
					// % protected region % [Add other validators for Sistole here] end
				],
				// % protected region % [Add any additional model attribute properties for Sistole here] off begin
				// % protected region % [Add any additional model attribute properties for Sistole here] end
			},
			{
				name: 'diastole',
				// % protected region % [Set displayName for Diastole here] off begin
				displayName: 'Diastole',
				// % protected region % [Set displayName for Diastole here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Diastole here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Diastole here] end
				// % protected region % [Set isSensitive for Diastole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diastole here] end
				// % protected region % [Set readonly for Diastole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diastole here] end
				validators: [
					// % protected region % [Add other validators for Diastole here] off begin
					// % protected region % [Add other validators for Diastole here] end
				],
				// % protected region % [Add any additional model attribute properties for Diastole here] off begin
				// % protected region % [Add any additional model attribute properties for Diastole here] end
			},
			{
				name: 'radiologiFoto',
				// % protected region % [Set displayName for Radiologi Foto here] off begin
				displayName: 'Radiologi Foto',
				// % protected region % [Set displayName for Radiologi Foto here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Radiologi Foto here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Radiologi Foto here] end
				// % protected region % [Set isSensitive for Radiologi Foto here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Radiologi Foto here] end
				// % protected region % [Set readonly for Radiologi Foto here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Radiologi Foto here] end
				validators: [
					// % protected region % [Add other validators for Radiologi Foto here] off begin
					// % protected region % [Add other validators for Radiologi Foto here] end
				],
				// % protected region % [Add any additional model attribute properties for Radiologi Foto here] off begin
				// % protected region % [Add any additional model attribute properties for Radiologi Foto here] end
			},
			{
				name: 'hemoglobin',
				// % protected region % [Set displayName for Hemoglobin here] off begin
				displayName: 'Hemoglobin',
				// % protected region % [Set displayName for Hemoglobin here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hemoglobin here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hemoglobin here] end
				// % protected region % [Set isSensitive for Hemoglobin here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hemoglobin here] end
				// % protected region % [Set readonly for Hemoglobin here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hemoglobin here] end
				validators: [
					// % protected region % [Add other validators for Hemoglobin here] off begin
					// % protected region % [Add other validators for Hemoglobin here] end
				],
				// % protected region % [Add any additional model attribute properties for Hemoglobin here] off begin
				// % protected region % [Add any additional model attribute properties for Hemoglobin here] end
			},
			{
				name: 'leukosit',
				// % protected region % [Set displayName for Leukosit here] off begin
				displayName: 'Leukosit',
				// % protected region % [Set displayName for Leukosit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Leukosit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Leukosit here] end
				// % protected region % [Set isSensitive for Leukosit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Leukosit here] end
				// % protected region % [Set readonly for Leukosit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Leukosit here] end
				validators: [
					// % protected region % [Add other validators for Leukosit here] off begin
					// % protected region % [Add other validators for Leukosit here] end
				],
				// % protected region % [Add any additional model attribute properties for Leukosit here] off begin
				// % protected region % [Add any additional model attribute properties for Leukosit here] end
			},
			{
				name: 'eritrosit',
				// % protected region % [Set displayName for Eritrosit here] off begin
				displayName: 'Eritrosit',
				// % protected region % [Set displayName for Eritrosit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Eritrosit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Eritrosit here] end
				// % protected region % [Set isSensitive for Eritrosit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Eritrosit here] end
				// % protected region % [Set readonly for Eritrosit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Eritrosit here] end
				validators: [
					// % protected region % [Add other validators for Eritrosit here] off begin
					// % protected region % [Add other validators for Eritrosit here] end
				],
				// % protected region % [Add any additional model attribute properties for Eritrosit here] off begin
				// % protected region % [Add any additional model attribute properties for Eritrosit here] end
			},
			{
				name: 'lajuEndapDarah',
				// % protected region % [Set displayName for Laju Endap Darah here] off begin
				displayName: 'Laju Endap Darah',
				// % protected region % [Set displayName for Laju Endap Darah here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Laju Endap Darah here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Laju Endap Darah here] end
				// % protected region % [Set isSensitive for Laju Endap Darah here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Laju Endap Darah here] end
				// % protected region % [Set readonly for Laju Endap Darah here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Laju Endap Darah here] end
				validators: [
					// % protected region % [Add other validators for Laju Endap Darah here] off begin
					// % protected region % [Add other validators for Laju Endap Darah here] end
				],
				// % protected region % [Add any additional model attribute properties for Laju Endap Darah here] off begin
				// % protected region % [Add any additional model attribute properties for Laju Endap Darah here] end
			},
			{
				name: 'hematokrit',
				// % protected region % [Set displayName for Hematokrit here] off begin
				displayName: 'Hematokrit',
				// % protected region % [Set displayName for Hematokrit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hematokrit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hematokrit here] end
				// % protected region % [Set isSensitive for Hematokrit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hematokrit here] end
				// % protected region % [Set readonly for Hematokrit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hematokrit here] end
				validators: [
					// % protected region % [Add other validators for Hematokrit here] off begin
					// % protected region % [Add other validators for Hematokrit here] end
				],
				// % protected region % [Add any additional model attribute properties for Hematokrit here] off begin
				// % protected region % [Add any additional model attribute properties for Hematokrit here] end
			},
			{
				name: 'trombosit',
				// % protected region % [Set displayName for Trombosit here] off begin
				displayName: 'Trombosit',
				// % protected region % [Set displayName for Trombosit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Trombosit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Trombosit here] end
				// % protected region % [Set isSensitive for Trombosit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Trombosit here] end
				// % protected region % [Set readonly for Trombosit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Trombosit here] end
				validators: [
					// % protected region % [Add other validators for Trombosit here] off begin
					// % protected region % [Add other validators for Trombosit here] end
				],
				// % protected region % [Add any additional model attribute properties for Trombosit here] off begin
				// % protected region % [Add any additional model attribute properties for Trombosit here] end
			},
			{
				name: 'hdl',
				// % protected region % [Set displayName for HDL here] off begin
				displayName: 'HDL',
				// % protected region % [Set displayName for HDL here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for HDL here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for HDL here] end
				// % protected region % [Set isSensitive for HDL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for HDL here] end
				// % protected region % [Set readonly for HDL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for HDL here] end
				validators: [
					// % protected region % [Add other validators for HDL here] off begin
					// % protected region % [Add other validators for HDL here] end
				],
				// % protected region % [Add any additional model attribute properties for HDL here] off begin
				// % protected region % [Add any additional model attribute properties for HDL here] end
			},
			{
				name: 'ldl',
				// % protected region % [Set displayName for LDL here] off begin
				displayName: 'LDL',
				// % protected region % [Set displayName for LDL here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for LDL here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for LDL here] end
				// % protected region % [Set isSensitive for LDL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for LDL here] end
				// % protected region % [Set readonly for LDL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for LDL here] end
				validators: [
					// % protected region % [Add other validators for LDL here] off begin
					// % protected region % [Add other validators for LDL here] end
				],
				// % protected region % [Add any additional model attribute properties for LDL here] off begin
				// % protected region % [Add any additional model attribute properties for LDL here] end
			},
			{
				name: 'cholesterol',
				// % protected region % [Set displayName for Cholesterol here] off begin
				displayName: 'Cholesterol',
				// % protected region % [Set displayName for Cholesterol here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Cholesterol here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Cholesterol here] end
				// % protected region % [Set isSensitive for Cholesterol here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Cholesterol here] end
				// % protected region % [Set readonly for Cholesterol here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Cholesterol here] end
				validators: [
					// % protected region % [Add other validators for Cholesterol here] off begin
					// % protected region % [Add other validators for Cholesterol here] end
				],
				// % protected region % [Add any additional model attribute properties for Cholesterol here] off begin
				// % protected region % [Add any additional model attribute properties for Cholesterol here] end
			},
			{
				name: 'trigliserida',
				// % protected region % [Set displayName for Trigliserida here] off begin
				displayName: 'Trigliserida',
				// % protected region % [Set displayName for Trigliserida here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Trigliserida here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Trigliserida here] end
				// % protected region % [Set isSensitive for Trigliserida here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Trigliserida here] end
				// % protected region % [Set readonly for Trigliserida here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Trigliserida here] end
				validators: [
					// % protected region % [Add other validators for Trigliserida here] off begin
					// % protected region % [Add other validators for Trigliserida here] end
				],
				// % protected region % [Add any additional model attribute properties for Trigliserida here] off begin
				// % protected region % [Add any additional model attribute properties for Trigliserida here] end
			},
			{
				name: 'sewaktu',
				// % protected region % [Set displayName for Sewaktu here] off begin
				displayName: 'Sewaktu',
				// % protected region % [Set displayName for Sewaktu here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sewaktu here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sewaktu here] end
				// % protected region % [Set isSensitive for Sewaktu here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sewaktu here] end
				// % protected region % [Set readonly for Sewaktu here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sewaktu here] end
				validators: [
					// % protected region % [Add other validators for Sewaktu here] off begin
					// % protected region % [Add other validators for Sewaktu here] end
				],
				// % protected region % [Add any additional model attribute properties for Sewaktu here] off begin
				// % protected region % [Add any additional model attribute properties for Sewaktu here] end
			},
			{
				name: 'puasa',
				// % protected region % [Set displayName for Puasa here] off begin
				displayName: 'Puasa',
				// % protected region % [Set displayName for Puasa here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Puasa here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Puasa here] end
				// % protected region % [Set isSensitive for Puasa here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Puasa here] end
				// % protected region % [Set readonly for Puasa here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Puasa here] end
				validators: [
					// % protected region % [Add other validators for Puasa here] off begin
					// % protected region % [Add other validators for Puasa here] end
				],
				// % protected region % [Add any additional model attribute properties for Puasa here] off begin
				// % protected region % [Add any additional model attribute properties for Puasa here] end
			},
			{
				name: 'postPrandial',
				// % protected region % [Set displayName for Post Prandial here] off begin
				displayName: 'Post Prandial',
				// % protected region % [Set displayName for Post Prandial here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Post Prandial here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Post Prandial here] end
				// % protected region % [Set isSensitive for Post Prandial here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Post Prandial here] end
				// % protected region % [Set readonly for Post Prandial here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Post Prandial here] end
				validators: [
					// % protected region % [Add other validators for Post Prandial here] off begin
					// % protected region % [Add other validators for Post Prandial here] end
				],
				// % protected region % [Add any additional model attribute properties for Post Prandial here] off begin
				// % protected region % [Add any additional model attribute properties for Post Prandial here] end
			},
			{
				name: 'hba1c',
				// % protected region % [Set displayName for HbA1c here] off begin
				displayName: 'HbA1c',
				// % protected region % [Set displayName for HbA1c here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for HbA1c here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for HbA1c here] end
				// % protected region % [Set isSensitive for HbA1c here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for HbA1c here] end
				// % protected region % [Set readonly for HbA1c here] off begin
				readOnly: false,
				// % protected region % [Set readonly for HbA1c here] end
				validators: [
					// % protected region % [Add other validators for HbA1c here] off begin
					// % protected region % [Add other validators for HbA1c here] end
				],
				// % protected region % [Add any additional model attribute properties for HbA1c here] off begin
				// % protected region % [Add any additional model attribute properties for HbA1c here] end
			},
			{
				name: 'sgot',
				// % protected region % [Set displayName for SGOT here] off begin
				displayName: 'SGOT',
				// % protected region % [Set displayName for SGOT here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SGOT here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SGOT here] end
				// % protected region % [Set isSensitive for SGOT here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SGOT here] end
				// % protected region % [Set readonly for SGOT here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SGOT here] end
				validators: [
					// % protected region % [Add other validators for SGOT here] off begin
					// % protected region % [Add other validators for SGOT here] end
				],
				// % protected region % [Add any additional model attribute properties for SGOT here] off begin
				// % protected region % [Add any additional model attribute properties for SGOT here] end
			},
			{
				name: 'sgpt',
				// % protected region % [Set displayName for SGPT here] off begin
				displayName: 'SGPT',
				// % protected region % [Set displayName for SGPT here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SGPT here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SGPT here] end
				// % protected region % [Set isSensitive for SGPT here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SGPT here] end
				// % protected region % [Set readonly for SGPT here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SGPT here] end
				validators: [
					// % protected region % [Add other validators for SGPT here] off begin
					// % protected region % [Add other validators for SGPT here] end
				],
				// % protected region % [Add any additional model attribute properties for SGPT here] off begin
				// % protected region % [Add any additional model attribute properties for SGPT here] end
			},
			{
				name: 'gamma',
				// % protected region % [Set displayName for Gamma here] off begin
				displayName: 'Gamma',
				// % protected region % [Set displayName for Gamma here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gamma here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gamma here] end
				// % protected region % [Set isSensitive for Gamma here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gamma here] end
				// % protected region % [Set readonly for Gamma here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gamma here] end
				validators: [
					// % protected region % [Add other validators for Gamma here] off begin
					// % protected region % [Add other validators for Gamma here] end
				],
				// % protected region % [Add any additional model attribute properties for Gamma here] off begin
				// % protected region % [Add any additional model attribute properties for Gamma here] end
			},
			{
				name: 'proteinKualitatif',
				// % protected region % [Set displayName for Protein Kualitatif here] off begin
				displayName: 'Protein Kualitatif',
				// % protected region % [Set displayName for Protein Kualitatif here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Protein Kualitatif here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Protein Kualitatif here] end
				// % protected region % [Set isSensitive for Protein Kualitatif here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Protein Kualitatif here] end
				// % protected region % [Set readonly for Protein Kualitatif here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Protein Kualitatif here] end
				validators: [
					// % protected region % [Add other validators for Protein Kualitatif here] off begin
					// % protected region % [Add other validators for Protein Kualitatif here] end
				],
				// % protected region % [Add any additional model attribute properties for Protein Kualitatif here] off begin
				// % protected region % [Add any additional model attribute properties for Protein Kualitatif here] end
			},
			{
				name: 'albumin',
				// % protected region % [Set displayName for Albumin here] off begin
				displayName: 'Albumin',
				// % protected region % [Set displayName for Albumin here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Albumin here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Albumin here] end
				// % protected region % [Set isSensitive for Albumin here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Albumin here] end
				// % protected region % [Set readonly for Albumin here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Albumin here] end
				validators: [
					// % protected region % [Add other validators for Albumin here] off begin
					// % protected region % [Add other validators for Albumin here] end
				],
				// % protected region % [Add any additional model attribute properties for Albumin here] off begin
				// % protected region % [Add any additional model attribute properties for Albumin here] end
			},
			{
				name: 'creatinine',
				// % protected region % [Set displayName for Creatinine here] off begin
				displayName: 'Creatinine',
				// % protected region % [Set displayName for Creatinine here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Creatinine here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Creatinine here] end
				// % protected region % [Set isSensitive for Creatinine here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Creatinine here] end
				// % protected region % [Set readonly for Creatinine here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Creatinine here] end
				validators: [
					// % protected region % [Add other validators for Creatinine here] off begin
					// % protected region % [Add other validators for Creatinine here] end
				],
				// % protected region % [Add any additional model attribute properties for Creatinine here] off begin
				// % protected region % [Add any additional model attribute properties for Creatinine here] end
			},
			{
				name: 'ureum',
				// % protected region % [Set displayName for Ureum here] off begin
				displayName: 'Ureum',
				// % protected region % [Set displayName for Ureum here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ureum here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ureum here] end
				// % protected region % [Set isSensitive for Ureum here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ureum here] end
				// % protected region % [Set readonly for Ureum here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ureum here] end
				validators: [
					// % protected region % [Add other validators for Ureum here] off begin
					// % protected region % [Add other validators for Ureum here] end
				],
				// % protected region % [Add any additional model attribute properties for Ureum here] off begin
				// % protected region % [Add any additional model attribute properties for Ureum here] end
			},
			{
				name: 'asam',
				// % protected region % [Set displayName for Asam here] off begin
				displayName: 'Asam',
				// % protected region % [Set displayName for Asam here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Asam here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Asam here] end
				// % protected region % [Set isSensitive for Asam here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Asam here] end
				// % protected region % [Set readonly for Asam here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Asam here] end
				validators: [
					// % protected region % [Add other validators for Asam here] off begin
					// % protected region % [Add other validators for Asam here] end
				],
				// % protected region % [Add any additional model attribute properties for Asam here] off begin
				// % protected region % [Add any additional model attribute properties for Asam here] end
			},
			{
				name: 'abi',
				// % protected region % [Set displayName for ABI here] off begin
				displayName: 'ABI',
				// % protected region % [Set displayName for ABI here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ABI here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ABI here] end
				// % protected region % [Set isSensitive for ABI here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ABI here] end
				// % protected region % [Set readonly for ABI here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ABI here] end
				validators: [
					// % protected region % [Add other validators for ABI here] off begin
					// % protected region % [Add other validators for ABI here] end
				],
				// % protected region % [Add any additional model attribute properties for ABI here] off begin
				// % protected region % [Add any additional model attribute properties for ABI here] end
			},
			{
				name: 'ekg',
				// % protected region % [Set displayName for EKG here] off begin
				displayName: 'EKG',
				// % protected region % [Set displayName for EKG here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for EKG here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for EKG here] end
				// % protected region % [Set isSensitive for EKG here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for EKG here] end
				// % protected region % [Set readonly for EKG here] off begin
				readOnly: false,
				// % protected region % [Set readonly for EKG here] end
				validators: [
					// % protected region % [Add other validators for EKG here] off begin
					// % protected region % [Add other validators for EKG here] end
				],
				// % protected region % [Add any additional model attribute properties for EKG here] off begin
				// % protected region % [Add any additional model attribute properties for EKG here] end
			},
			{
				name: 'echo',
				// % protected region % [Set displayName for Echo here] off begin
				displayName: 'Echo',
				// % protected region % [Set displayName for Echo here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Echo here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Echo here] end
				// % protected region % [Set isSensitive for Echo here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Echo here] end
				// % protected region % [Set readonly for Echo here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Echo here] end
				validators: [
					// % protected region % [Add other validators for Echo here] off begin
					// % protected region % [Add other validators for Echo here] end
				],
				// % protected region % [Add any additional model attribute properties for Echo here] off begin
				// % protected region % [Add any additional model attribute properties for Echo here] end
			},
			{
				name: 'funduskopi',
				// % protected region % [Set displayName for Funduskopi here] off begin
				displayName: 'Funduskopi',
				// % protected region % [Set displayName for Funduskopi here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Funduskopi here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Funduskopi here] end
				// % protected region % [Set isSensitive for Funduskopi here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Funduskopi here] end
				// % protected region % [Set readonly for Funduskopi here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Funduskopi here] end
				validators: [
					// % protected region % [Add other validators for Funduskopi here] off begin
					// % protected region % [Add other validators for Funduskopi here] end
				],
				// % protected region % [Add any additional model attribute properties for Funduskopi here] off begin
				// % protected region % [Add any additional model attribute properties for Funduskopi here] end
			},
			{
				name: 'pemeriksaanLain',
				// % protected region % [Set displayName for Pemeriksaan Lain here] off begin
				displayName: 'Pemeriksaan Lain',
				// % protected region % [Set displayName for Pemeriksaan Lain here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pemeriksaan Lain here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pemeriksaan Lain here] end
				// % protected region % [Set isSensitive for Pemeriksaan Lain here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pemeriksaan Lain here] end
				// % protected region % [Set readonly for Pemeriksaan Lain here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pemeriksaan Lain here] end
				validators: [
					// % protected region % [Add other validators for Pemeriksaan Lain here] off begin
					// % protected region % [Add other validators for Pemeriksaan Lain here] end
				],
				// % protected region % [Add any additional model attribute properties for Pemeriksaan Lain here] off begin
				// % protected region % [Add any additional model attribute properties for Pemeriksaan Lain here] end
			},
			{
				name: 'keterangan',
				// % protected region % [Set displayName for Keterangan here] off begin
				displayName: 'Keterangan',
				// % protected region % [Set displayName for Keterangan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Keterangan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Keterangan here] end
				// % protected region % [Set isSensitive for Keterangan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Keterangan here] end
				// % protected region % [Set readonly for Keterangan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Keterangan here] end
				validators: [
					// % protected region % [Add other validators for Keterangan here] off begin
					// % protected region % [Add other validators for Keterangan here] end
				],
				// % protected region % [Add any additional model attribute properties for Keterangan here] off begin
				// % protected region % [Add any additional model attribute properties for Keterangan here] end
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
				case 'kodeMCU':
					break;
				case 'noKunjungan':
					break;
				case 'kodeProvider':
					break;
				case 'namaProvider':
					break;
				case 'tanggalPelayanan':
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
	static deepParse(data: string | { [K in keyof PcareMCUModel]?: PcareMCUModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PcareMCUModel(data);
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
	 * `let pcareMCUModel = new PcareMCUModel(data);`
	 *
	 * @param data The input data to be initialised as the PcareMCUModel,
	 *    it is expected as a JSON string or as a nullable PcareMCUModel.
	 */
	constructor(data?: string | Partial<PcareMCUModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PcareMCUModel>
				: data;

			this.kodeMCU = json.kodeMCU;
			this.noKunjungan = json.noKunjungan;
			this.kodeProvider = json.kodeProvider;
			this.namaProvider = json.namaProvider;
			this.tanggalPelayanan = json.tanggalPelayanan;
			this.sistole = json.sistole;
			this.diastole = json.diastole;
			this.radiologiFoto = json.radiologiFoto;
			this.hemoglobin = json.hemoglobin;
			this.leukosit = json.leukosit;
			this.eritrosit = json.eritrosit;
			this.lajuEndapDarah = json.lajuEndapDarah;
			this.hematokrit = json.hematokrit;
			this.trombosit = json.trombosit;
			this.hdl = json.hdl;
			this.ldl = json.ldl;
			this.cholesterol = json.cholesterol;
			this.trigliserida = json.trigliserida;
			this.sewaktu = json.sewaktu;
			this.puasa = json.puasa;
			this.postPrandial = json.postPrandial;
			this.hba1c = json.hba1c;
			this.sgot = json.sgot;
			this.sgpt = json.sgpt;
			this.gamma = json.gamma;
			this.proteinKualitatif = json.proteinKualitatif;
			this.albumin = json.albumin;
			this.creatinine = json.creatinine;
			this.ureum = json.ureum;
			this.asam = json.asam;
			this.abi = json.abi;
			this.ekg = json.ekg;
			this.echo = json.echo;
			this.funduskopi = json.funduskopi;
			this.pemeriksaanLain = json.pemeriksaanLain;
			this.keterangan = json.keterangan;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			kodeMCU: this.kodeMCU,
			noKunjungan: this.noKunjungan,
			kodeProvider: this.kodeProvider,
			namaProvider: this.namaProvider,
			tanggalPelayanan: this.tanggalPelayanan,
			sistole: this.sistole,
			diastole: this.diastole,
			radiologiFoto: this.radiologiFoto,
			hemoglobin: this.hemoglobin,
			leukosit: this.leukosit,
			eritrosit: this.eritrosit,
			lajuEndapDarah: this.lajuEndapDarah,
			hematokrit: this.hematokrit,
			trombosit: this.trombosit,
			hdl: this.hdl,
			ldl: this.ldl,
			cholesterol: this.cholesterol,
			trigliserida: this.trigliserida,
			sewaktu: this.sewaktu,
			puasa: this.puasa,
			postPrandial: this.postPrandial,
			hba1c: this.hba1c,
			sgot: this.sgot,
			sgpt: this.sgpt,
			gamma: this.gamma,
			proteinKualitatif: this.proteinKualitatif,
			albumin: this.albumin,
			creatinine: this.creatinine,
			ureum: this.ureum,
			asam: this.asam,
			abi: this.abi,
			ekg: this.ekg,
			echo: this.echo,
			funduskopi: this.funduskopi,
			pemeriksaanLain: this.pemeriksaanLain,
			keterangan: this.keterangan,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PcareMCUModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PcareMCUModel {
		let newModelJson = this.toJSON();

		if (updates.kodeMCU) {
			newModelJson.kodeMCU = updates.kodeMCU;
		}

		if (updates.noKunjungan) {
			newModelJson.noKunjungan = updates.noKunjungan;
		}

		if (updates.kodeProvider) {
			newModelJson.kodeProvider = updates.kodeProvider;
		}

		if (updates.namaProvider) {
			newModelJson.namaProvider = updates.namaProvider;
		}

		if (updates.tanggalPelayanan) {
			newModelJson.tanggalPelayanan = updates.tanggalPelayanan;
		}

		if (updates.sistole) {
			newModelJson.sistole = updates.sistole;
		}

		if (updates.diastole) {
			newModelJson.diastole = updates.diastole;
		}

		if (updates.radiologiFoto) {
			newModelJson.radiologiFoto = updates.radiologiFoto;
		}

		if (updates.hemoglobin) {
			newModelJson.hemoglobin = updates.hemoglobin;
		}

		if (updates.leukosit) {
			newModelJson.leukosit = updates.leukosit;
		}

		if (updates.eritrosit) {
			newModelJson.eritrosit = updates.eritrosit;
		}

		if (updates.lajuEndapDarah) {
			newModelJson.lajuEndapDarah = updates.lajuEndapDarah;
		}

		if (updates.hematokrit) {
			newModelJson.hematokrit = updates.hematokrit;
		}

		if (updates.trombosit) {
			newModelJson.trombosit = updates.trombosit;
		}

		if (updates.hdl) {
			newModelJson.hdl = updates.hdl;
		}

		if (updates.ldl) {
			newModelJson.ldl = updates.ldl;
		}

		if (updates.cholesterol) {
			newModelJson.cholesterol = updates.cholesterol;
		}

		if (updates.trigliserida) {
			newModelJson.trigliserida = updates.trigliserida;
		}

		if (updates.sewaktu) {
			newModelJson.sewaktu = updates.sewaktu;
		}

		if (updates.puasa) {
			newModelJson.puasa = updates.puasa;
		}

		if (updates.postPrandial) {
			newModelJson.postPrandial = updates.postPrandial;
		}

		if (updates.hba1c) {
			newModelJson.hba1c = updates.hba1c;
		}

		if (updates.sgot) {
			newModelJson.sgot = updates.sgot;
		}

		if (updates.sgpt) {
			newModelJson.sgpt = updates.sgpt;
		}

		if (updates.gamma) {
			newModelJson.gamma = updates.gamma;
		}

		if (updates.proteinKualitatif) {
			newModelJson.proteinKualitatif = updates.proteinKualitatif;
		}

		if (updates.albumin) {
			newModelJson.albumin = updates.albumin;
		}

		if (updates.creatinine) {
			newModelJson.creatinine = updates.creatinine;
		}

		if (updates.ureum) {
			newModelJson.ureum = updates.ureum;
		}

		if (updates.asam) {
			newModelJson.asam = updates.asam;
		}

		if (updates.abi) {
			newModelJson.abi = updates.abi;
		}

		if (updates.ekg) {
			newModelJson.ekg = updates.ekg;
		}

		if (updates.echo) {
			newModelJson.echo = updates.echo;
		}

		if (updates.funduskopi) {
			newModelJson.funduskopi = updates.funduskopi;
		}

		if (updates.pemeriksaanLain) {
			newModelJson.pemeriksaanLain = updates.pemeriksaanLain;
		}

		if (updates.keterangan) {
			newModelJson.keterangan = updates.keterangan;
		}

		return new PcareMCUModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PcareMCUModel)) {
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
