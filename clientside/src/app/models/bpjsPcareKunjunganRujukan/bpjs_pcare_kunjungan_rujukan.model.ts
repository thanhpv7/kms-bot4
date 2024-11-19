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
export class BpjsPcareKunjunganRujukanModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'nmppk',
		'alamat',
		'kdkc',
		'alamatkc',
		'telpkc',
		'faxkc',
		'kdprop',
		'kddati',
		'nmdati',
		'alamatkr',
		'telpkr',
		'faxkr',
		'tglkunjungan',
		'kdpoli',
		'nokapst',
		'nmpst',
		'tgllahir',
		'pisa',
		'ketpisa',
		'sex',
		'kddiag1',
		'nmdiag1',
		'kddiag2',
		'nmdiag2',
		'kddiag3',
		'nmdiag3',
		'catatan',
		'kddokter',
		'nmdokter',
		'nmtacc',
		'alasantacc',
		'infodenda',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'norujukan',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPcareKunjunganRujukanModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPcareKunjunganRujukanModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	norujukan: string;

	/**
	 * .
	 */
	kdppk: string;

	/**
	 * .
	 */
	nmppk: string;

	/**
	 * .
	 */
	alamat: string;

	/**
	 * .
	 */
	kdkc: string;

	/**
	 * .
	 */
	nmkc: string;

	/**
	 * .
	 */
	alamatkc: string;

	/**
	 * .
	 */
	telpkc: string;

	/**
	 * .
	 */
	faxkc: string;

	/**
	 * .
	 */
	kdprop: string;

	/**
	 * .
	 */
	kddati: string;

	/**
	 * .
	 */
	nmdati: string;

	/**
	 * .
	 */
	kdkr: string;

	/**
	 * .
	 */
	nmkr: string;

	/**
	 * .
	 */
	alamatkr: string;

	/**
	 * .
	 */
	telpkr: string;

	/**
	 * .
	 */
	faxkr: string;

	/**
	 * .
	 */
	tglkunjungan: string;

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
	nokapst: string;

	/**
	 * .
	 */
	nmpst: string;

	/**
	 * .
	 */
	tgllahir: string;

	/**
	 * .
	 */
	pisa: string;

	/**
	 * .
	 */
	ketpisa: string;

	/**
	 * .
	 */
	sex: string;

	/**
	 * .
	 */
	kddiag1: string;

	/**
	 * .
	 */
	nmdiag1: string;

	/**
	 * .
	 */
	kddiag2: string;

	/**
	 * .
	 */
	nmdiag2: string;

	/**
	 * .
	 */
	kddiag3: string;

	/**
	 * .
	 */
	nmdiag3: string;

	/**
	 * .
	 */
	catatan: string;

	/**
	 * .
	 */
	kddokter: string;

	/**
	 * .
	 */
	nmdokter: string;

	/**
	 * .
	 */
	nmtacc: string;

	/**
	 * .
	 */
	alasantacc: string;

	/**
	 * .
	 */
	infodenda: string;



	modelPropGroups: { [s: string]: Group } = BpjsPcareKunjunganRujukanModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'norujukan',
				// % protected region % [Set displayName for noRujukan here] off begin
				displayName: 'noRujukan',
				// % protected region % [Set displayName for noRujukan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for noRujukan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for noRujukan here] end
				// % protected region % [Set isSensitive for noRujukan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for noRujukan here] end
				// % protected region % [Set readonly for noRujukan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for noRujukan here] end
				validators: [
					// % protected region % [Add other validators for noRujukan here] off begin
					// % protected region % [Add other validators for noRujukan here] end
				],
				// % protected region % [Add any additional model attribute properties for noRujukan here] off begin
				// % protected region % [Add any additional model attribute properties for noRujukan here] end
			},
			{
				name: 'kdppk',
				// % protected region % [Set displayName for kdPPK here] off begin
				displayName: 'kdPPK',
				// % protected region % [Set displayName for kdPPK here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdPPK here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdPPK here] end
				// % protected region % [Set isSensitive for kdPPK here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdPPK here] end
				// % protected region % [Set readonly for kdPPK here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdPPK here] end
				validators: [
					// % protected region % [Add other validators for kdPPK here] off begin
					// % protected region % [Add other validators for kdPPK here] end
				],
				// % protected region % [Add any additional model attribute properties for kdPPK here] off begin
				// % protected region % [Add any additional model attribute properties for kdPPK here] end
			},
			{
				name: 'nmppk',
				// % protected region % [Set displayName for nmPPK here] off begin
				displayName: 'nmPPK',
				// % protected region % [Set displayName for nmPPK here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmPPK here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmPPK here] end
				// % protected region % [Set isSensitive for nmPPK here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmPPK here] end
				// % protected region % [Set readonly for nmPPK here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmPPK here] end
				validators: [
					// % protected region % [Add other validators for nmPPK here] off begin
					// % protected region % [Add other validators for nmPPK here] end
				],
				// % protected region % [Add any additional model attribute properties for nmPPK here] off begin
				// % protected region % [Add any additional model attribute properties for nmPPK here] end
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
				name: 'kdkc',
				// % protected region % [Set displayName for kdKC here] off begin
				displayName: 'kdKC',
				// % protected region % [Set displayName for kdKC here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdKC here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdKC here] end
				// % protected region % [Set isSensitive for kdKC here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdKC here] end
				// % protected region % [Set readonly for kdKC here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdKC here] end
				validators: [
					// % protected region % [Add other validators for kdKC here] off begin
					// % protected region % [Add other validators for kdKC here] end
				],
				// % protected region % [Add any additional model attribute properties for kdKC here] off begin
				// % protected region % [Add any additional model attribute properties for kdKC here] end
			},
			{
				name: 'nmkc',
				// % protected region % [Set displayName for nmKC here] off begin
				displayName: 'nmKC',
				// % protected region % [Set displayName for nmKC here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmKC here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmKC here] end
				// % protected region % [Set isSensitive for nmKC here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmKC here] end
				// % protected region % [Set readonly for nmKC here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmKC here] end
				validators: [
					// % protected region % [Add other validators for nmKC here] off begin
					// % protected region % [Add other validators for nmKC here] end
				],
				// % protected region % [Add any additional model attribute properties for nmKC here] off begin
				// % protected region % [Add any additional model attribute properties for nmKC here] end
			},
			{
				name: 'alamatkc',
				// % protected region % [Set displayName for alamatKC here] off begin
				displayName: 'alamatKC',
				// % protected region % [Set displayName for alamatKC here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for alamatKC here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for alamatKC here] end
				// % protected region % [Set isSensitive for alamatKC here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for alamatKC here] end
				// % protected region % [Set readonly for alamatKC here] off begin
				readOnly: false,
				// % protected region % [Set readonly for alamatKC here] end
				validators: [
					// % protected region % [Add other validators for alamatKC here] off begin
					// % protected region % [Add other validators for alamatKC here] end
				],
				// % protected region % [Add any additional model attribute properties for alamatKC here] off begin
				// % protected region % [Add any additional model attribute properties for alamatKC here] end
			},
			{
				name: 'telpkc',
				// % protected region % [Set displayName for telpKC here] off begin
				displayName: 'telpKC',
				// % protected region % [Set displayName for telpKC here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for telpKC here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for telpKC here] end
				// % protected region % [Set isSensitive for telpKC here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for telpKC here] end
				// % protected region % [Set readonly for telpKC here] off begin
				readOnly: false,
				// % protected region % [Set readonly for telpKC here] end
				validators: [
					// % protected region % [Add other validators for telpKC here] off begin
					// % protected region % [Add other validators for telpKC here] end
				],
				// % protected region % [Add any additional model attribute properties for telpKC here] off begin
				// % protected region % [Add any additional model attribute properties for telpKC here] end
			},
			{
				name: 'faxkc',
				// % protected region % [Set displayName for faxKC here] off begin
				displayName: 'faxKC',
				// % protected region % [Set displayName for faxKC here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for faxKC here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for faxKC here] end
				// % protected region % [Set isSensitive for faxKC here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for faxKC here] end
				// % protected region % [Set readonly for faxKC here] off begin
				readOnly: false,
				// % protected region % [Set readonly for faxKC here] end
				validators: [
					// % protected region % [Add other validators for faxKC here] off begin
					// % protected region % [Add other validators for faxKC here] end
				],
				// % protected region % [Add any additional model attribute properties for faxKC here] off begin
				// % protected region % [Add any additional model attribute properties for faxKC here] end
			},
			{
				name: 'kdprop',
				// % protected region % [Set displayName for kdProp here] off begin
				displayName: 'kdProp',
				// % protected region % [Set displayName for kdProp here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdProp here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdProp here] end
				// % protected region % [Set isSensitive for kdProp here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdProp here] end
				// % protected region % [Set readonly for kdProp here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdProp here] end
				validators: [
					// % protected region % [Add other validators for kdProp here] off begin
					// % protected region % [Add other validators for kdProp here] end
				],
				// % protected region % [Add any additional model attribute properties for kdProp here] off begin
				// % protected region % [Add any additional model attribute properties for kdProp here] end
			},
			{
				name: 'kddati',
				// % protected region % [Set displayName for kdDati here] off begin
				displayName: 'kdDati',
				// % protected region % [Set displayName for kdDati here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdDati here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdDati here] end
				// % protected region % [Set isSensitive for kdDati here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdDati here] end
				// % protected region % [Set readonly for kdDati here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdDati here] end
				validators: [
					// % protected region % [Add other validators for kdDati here] off begin
					// % protected region % [Add other validators for kdDati here] end
				],
				// % protected region % [Add any additional model attribute properties for kdDati here] off begin
				// % protected region % [Add any additional model attribute properties for kdDati here] end
			},
			{
				name: 'nmdati',
				// % protected region % [Set displayName for nmDati here] off begin
				displayName: 'nmDati',
				// % protected region % [Set displayName for nmDati here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmDati here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmDati here] end
				// % protected region % [Set isSensitive for nmDati here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmDati here] end
				// % protected region % [Set readonly for nmDati here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmDati here] end
				validators: [
					// % protected region % [Add other validators for nmDati here] off begin
					// % protected region % [Add other validators for nmDati here] end
				],
				// % protected region % [Add any additional model attribute properties for nmDati here] off begin
				// % protected region % [Add any additional model attribute properties for nmDati here] end
			},
			{
				name: 'kdkr',
				// % protected region % [Set displayName for kdKR here] off begin
				displayName: 'kdKR',
				// % protected region % [Set displayName for kdKR here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdKR here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdKR here] end
				// % protected region % [Set isSensitive for kdKR here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdKR here] end
				// % protected region % [Set readonly for kdKR here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdKR here] end
				validators: [
					// % protected region % [Add other validators for kdKR here] off begin
					// % protected region % [Add other validators for kdKR here] end
				],
				// % protected region % [Add any additional model attribute properties for kdKR here] off begin
				// % protected region % [Add any additional model attribute properties for kdKR here] end
			},
			{
				name: 'nmkr',
				// % protected region % [Set displayName for nmKR here] off begin
				displayName: 'nmKR',
				// % protected region % [Set displayName for nmKR here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmKR here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmKR here] end
				// % protected region % [Set isSensitive for nmKR here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmKR here] end
				// % protected region % [Set readonly for nmKR here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmKR here] end
				validators: [
					// % protected region % [Add other validators for nmKR here] off begin
					// % protected region % [Add other validators for nmKR here] end
				],
				// % protected region % [Add any additional model attribute properties for nmKR here] off begin
				// % protected region % [Add any additional model attribute properties for nmKR here] end
			},
			{
				name: 'alamatkr',
				// % protected region % [Set displayName for alamatKR here] off begin
				displayName: 'alamatKR',
				// % protected region % [Set displayName for alamatKR here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for alamatKR here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for alamatKR here] end
				// % protected region % [Set isSensitive for alamatKR here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for alamatKR here] end
				// % protected region % [Set readonly for alamatKR here] off begin
				readOnly: false,
				// % protected region % [Set readonly for alamatKR here] end
				validators: [
					// % protected region % [Add other validators for alamatKR here] off begin
					// % protected region % [Add other validators for alamatKR here] end
				],
				// % protected region % [Add any additional model attribute properties for alamatKR here] off begin
				// % protected region % [Add any additional model attribute properties for alamatKR here] end
			},
			{
				name: 'telpkr',
				// % protected region % [Set displayName for telpKR here] off begin
				displayName: 'telpKR',
				// % protected region % [Set displayName for telpKR here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for telpKR here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for telpKR here] end
				// % protected region % [Set isSensitive for telpKR here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for telpKR here] end
				// % protected region % [Set readonly for telpKR here] off begin
				readOnly: false,
				// % protected region % [Set readonly for telpKR here] end
				validators: [
					// % protected region % [Add other validators for telpKR here] off begin
					// % protected region % [Add other validators for telpKR here] end
				],
				// % protected region % [Add any additional model attribute properties for telpKR here] off begin
				// % protected region % [Add any additional model attribute properties for telpKR here] end
			},
			{
				name: 'faxkr',
				// % protected region % [Set displayName for faxKR here] off begin
				displayName: 'faxKR',
				// % protected region % [Set displayName for faxKR here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for faxKR here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for faxKR here] end
				// % protected region % [Set isSensitive for faxKR here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for faxKR here] end
				// % protected region % [Set readonly for faxKR here] off begin
				readOnly: false,
				// % protected region % [Set readonly for faxKR here] end
				validators: [
					// % protected region % [Add other validators for faxKR here] off begin
					// % protected region % [Add other validators for faxKR here] end
				],
				// % protected region % [Add any additional model attribute properties for faxKR here] off begin
				// % protected region % [Add any additional model attribute properties for faxKR here] end
			},
			{
				name: 'tglkunjungan',
				// % protected region % [Set displayName for tglKunjungan here] off begin
				displayName: 'tglKunjungan',
				// % protected region % [Set displayName for tglKunjungan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for tglKunjungan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for tglKunjungan here] end
				// % protected region % [Set isSensitive for tglKunjungan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for tglKunjungan here] end
				// % protected region % [Set readonly for tglKunjungan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for tglKunjungan here] end
				validators: [
					// % protected region % [Add other validators for tglKunjungan here] off begin
					// % protected region % [Add other validators for tglKunjungan here] end
				],
				// % protected region % [Add any additional model attribute properties for tglKunjungan here] off begin
				// % protected region % [Add any additional model attribute properties for tglKunjungan here] end
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
				name: 'nokapst',
				// % protected region % [Set displayName for nokaPst here] off begin
				displayName: 'nokaPst',
				// % protected region % [Set displayName for nokaPst here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nokaPst here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nokaPst here] end
				// % protected region % [Set isSensitive for nokaPst here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nokaPst here] end
				// % protected region % [Set readonly for nokaPst here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nokaPst here] end
				validators: [
					// % protected region % [Add other validators for nokaPst here] off begin
					// % protected region % [Add other validators for nokaPst here] end
				],
				// % protected region % [Add any additional model attribute properties for nokaPst here] off begin
				// % protected region % [Add any additional model attribute properties for nokaPst here] end
			},
			{
				name: 'nmpst',
				// % protected region % [Set displayName for nmPst here] off begin
				displayName: 'nmPst',
				// % protected region % [Set displayName for nmPst here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmPst here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmPst here] end
				// % protected region % [Set isSensitive for nmPst here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmPst here] end
				// % protected region % [Set readonly for nmPst here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmPst here] end
				validators: [
					// % protected region % [Add other validators for nmPst here] off begin
					// % protected region % [Add other validators for nmPst here] end
				],
				// % protected region % [Add any additional model attribute properties for nmPst here] off begin
				// % protected region % [Add any additional model attribute properties for nmPst here] end
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
				name: 'pisa',
				// % protected region % [Set displayName for pisa here] off begin
				displayName: 'pisa',
				// % protected region % [Set displayName for pisa here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for pisa here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for pisa here] end
				// % protected region % [Set isSensitive for pisa here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for pisa here] end
				// % protected region % [Set readonly for pisa here] off begin
				readOnly: false,
				// % protected region % [Set readonly for pisa here] end
				validators: [
					// % protected region % [Add other validators for pisa here] off begin
					// % protected region % [Add other validators for pisa here] end
				],
				// % protected region % [Add any additional model attribute properties for pisa here] off begin
				// % protected region % [Add any additional model attribute properties for pisa here] end
			},
			{
				name: 'ketpisa',
				// % protected region % [Set displayName for ketPisa here] off begin
				displayName: 'ketPisa',
				// % protected region % [Set displayName for ketPisa here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ketPisa here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ketPisa here] end
				// % protected region % [Set isSensitive for ketPisa here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ketPisa here] end
				// % protected region % [Set readonly for ketPisa here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ketPisa here] end
				validators: [
					// % protected region % [Add other validators for ketPisa here] off begin
					// % protected region % [Add other validators for ketPisa here] end
				],
				// % protected region % [Add any additional model attribute properties for ketPisa here] off begin
				// % protected region % [Add any additional model attribute properties for ketPisa here] end
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
				name: 'kddiag1',
				// % protected region % [Set displayName for kdDiag1 here] off begin
				displayName: 'kdDiag1',
				// % protected region % [Set displayName for kdDiag1 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdDiag1 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdDiag1 here] end
				// % protected region % [Set isSensitive for kdDiag1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdDiag1 here] end
				// % protected region % [Set readonly for kdDiag1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdDiag1 here] end
				validators: [
					// % protected region % [Add other validators for kdDiag1 here] off begin
					// % protected region % [Add other validators for kdDiag1 here] end
				],
				// % protected region % [Add any additional model attribute properties for kdDiag1 here] off begin
				// % protected region % [Add any additional model attribute properties for kdDiag1 here] end
			},
			{
				name: 'nmdiag1',
				// % protected region % [Set displayName for nmDiag1 here] off begin
				displayName: 'nmDiag1',
				// % protected region % [Set displayName for nmDiag1 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmDiag1 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmDiag1 here] end
				// % protected region % [Set isSensitive for nmDiag1 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmDiag1 here] end
				// % protected region % [Set readonly for nmDiag1 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmDiag1 here] end
				validators: [
					// % protected region % [Add other validators for nmDiag1 here] off begin
					// % protected region % [Add other validators for nmDiag1 here] end
				],
				// % protected region % [Add any additional model attribute properties for nmDiag1 here] off begin
				// % protected region % [Add any additional model attribute properties for nmDiag1 here] end
			},
			{
				name: 'kddiag2',
				// % protected region % [Set displayName for kdDiag2 here] off begin
				displayName: 'kdDiag2',
				// % protected region % [Set displayName for kdDiag2 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdDiag2 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdDiag2 here] end
				// % protected region % [Set isSensitive for kdDiag2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdDiag2 here] end
				// % protected region % [Set readonly for kdDiag2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdDiag2 here] end
				validators: [
					// % protected region % [Add other validators for kdDiag2 here] off begin
					// % protected region % [Add other validators for kdDiag2 here] end
				],
				// % protected region % [Add any additional model attribute properties for kdDiag2 here] off begin
				// % protected region % [Add any additional model attribute properties for kdDiag2 here] end
			},
			{
				name: 'nmdiag2',
				// % protected region % [Set displayName for nmDiag2 here] off begin
				displayName: 'nmDiag2',
				// % protected region % [Set displayName for nmDiag2 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmDiag2 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmDiag2 here] end
				// % protected region % [Set isSensitive for nmDiag2 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmDiag2 here] end
				// % protected region % [Set readonly for nmDiag2 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmDiag2 here] end
				validators: [
					// % protected region % [Add other validators for nmDiag2 here] off begin
					// % protected region % [Add other validators for nmDiag2 here] end
				],
				// % protected region % [Add any additional model attribute properties for nmDiag2 here] off begin
				// % protected region % [Add any additional model attribute properties for nmDiag2 here] end
			},
			{
				name: 'kddiag3',
				// % protected region % [Set displayName for kdDiag3 here] off begin
				displayName: 'kdDiag3',
				// % protected region % [Set displayName for kdDiag3 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdDiag3 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdDiag3 here] end
				// % protected region % [Set isSensitive for kdDiag3 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdDiag3 here] end
				// % protected region % [Set readonly for kdDiag3 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdDiag3 here] end
				validators: [
					// % protected region % [Add other validators for kdDiag3 here] off begin
					// % protected region % [Add other validators for kdDiag3 here] end
				],
				// % protected region % [Add any additional model attribute properties for kdDiag3 here] off begin
				// % protected region % [Add any additional model attribute properties for kdDiag3 here] end
			},
			{
				name: 'nmdiag3',
				// % protected region % [Set displayName for nmDiag3 here] off begin
				displayName: 'nmDiag3',
				// % protected region % [Set displayName for nmDiag3 here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmDiag3 here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmDiag3 here] end
				// % protected region % [Set isSensitive for nmDiag3 here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmDiag3 here] end
				// % protected region % [Set readonly for nmDiag3 here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmDiag3 here] end
				validators: [
					// % protected region % [Add other validators for nmDiag3 here] off begin
					// % protected region % [Add other validators for nmDiag3 here] end
				],
				// % protected region % [Add any additional model attribute properties for nmDiag3 here] off begin
				// % protected region % [Add any additional model attribute properties for nmDiag3 here] end
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
				name: 'kddokter',
				// % protected region % [Set displayName for kdDokter here] off begin
				displayName: 'kdDokter',
				// % protected region % [Set displayName for kdDokter here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdDokter here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdDokter here] end
				// % protected region % [Set isSensitive for kdDokter here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdDokter here] end
				// % protected region % [Set readonly for kdDokter here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdDokter here] end
				validators: [
					// % protected region % [Add other validators for kdDokter here] off begin
					// % protected region % [Add other validators for kdDokter here] end
				],
				// % protected region % [Add any additional model attribute properties for kdDokter here] off begin
				// % protected region % [Add any additional model attribute properties for kdDokter here] end
			},
			{
				name: 'nmdokter',
				// % protected region % [Set displayName for nmDokter here] off begin
				displayName: 'nmDokter',
				// % protected region % [Set displayName for nmDokter here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmDokter here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmDokter here] end
				// % protected region % [Set isSensitive for nmDokter here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmDokter here] end
				// % protected region % [Set readonly for nmDokter here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmDokter here] end
				validators: [
					// % protected region % [Add other validators for nmDokter here] off begin
					// % protected region % [Add other validators for nmDokter here] end
				],
				// % protected region % [Add any additional model attribute properties for nmDokter here] off begin
				// % protected region % [Add any additional model attribute properties for nmDokter here] end
			},
			{
				name: 'nmtacc',
				// % protected region % [Set displayName for nmTacc here] off begin
				displayName: 'nmTacc',
				// % protected region % [Set displayName for nmTacc here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for nmTacc here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for nmTacc here] end
				// % protected region % [Set isSensitive for nmTacc here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for nmTacc here] end
				// % protected region % [Set readonly for nmTacc here] off begin
				readOnly: false,
				// % protected region % [Set readonly for nmTacc here] end
				validators: [
					// % protected region % [Add other validators for nmTacc here] off begin
					// % protected region % [Add other validators for nmTacc here] end
				],
				// % protected region % [Add any additional model attribute properties for nmTacc here] off begin
				// % protected region % [Add any additional model attribute properties for nmTacc here] end
			},
			{
				name: 'alasantacc',
				// % protected region % [Set displayName for alasanTacc here] off begin
				displayName: 'alasanTacc',
				// % protected region % [Set displayName for alasanTacc here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for alasanTacc here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for alasanTacc here] end
				// % protected region % [Set isSensitive for alasanTacc here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for alasanTacc here] end
				// % protected region % [Set readonly for alasanTacc here] off begin
				readOnly: false,
				// % protected region % [Set readonly for alasanTacc here] end
				validators: [
					// % protected region % [Add other validators for alasanTacc here] off begin
					// % protected region % [Add other validators for alasanTacc here] end
				],
				// % protected region % [Add any additional model attribute properties for alasanTacc here] off begin
				// % protected region % [Add any additional model attribute properties for alasanTacc here] end
			},
			{
				name: 'infodenda',
				// % protected region % [Set displayName for infoDenda here] off begin
				displayName: 'infoDenda',
				// % protected region % [Set displayName for infoDenda here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for infoDenda here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for infoDenda here] end
				// % protected region % [Set isSensitive for infoDenda here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for infoDenda here] end
				// % protected region % [Set readonly for infoDenda here] off begin
				readOnly: false,
				// % protected region % [Set readonly for infoDenda here] end
				validators: [
					// % protected region % [Add other validators for infoDenda here] off begin
					// % protected region % [Add other validators for infoDenda here] end
				],
				// % protected region % [Add any additional model attribute properties for infoDenda here] off begin
				// % protected region % [Add any additional model attribute properties for infoDenda here] end
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
				case 'nmppk':
					break;
				case 'alamat':
					break;
				case 'kdkc':
					break;
				case 'alamatkc':
					break;
				case 'telpkc':
					break;
				case 'faxkc':
					break;
				case 'kdprop':
					break;
				case 'kddati':
					break;
				case 'nmdati':
					break;
				case 'alamatkr':
					break;
				case 'telpkr':
					break;
				case 'faxkr':
					break;
				case 'tglkunjungan':
					break;
				case 'kdpoli':
					break;
				case 'nokapst':
					break;
				case 'nmpst':
					break;
				case 'tgllahir':
					break;
				case 'pisa':
					break;
				case 'ketpisa':
					break;
				case 'sex':
					break;
				case 'kddiag1':
					break;
				case 'nmdiag1':
					break;
				case 'kddiag2':
					break;
				case 'nmdiag2':
					break;
				case 'kddiag3':
					break;
				case 'nmdiag3':
					break;
				case 'catatan':
					break;
				case 'kddokter':
					break;
				case 'nmdokter':
					break;
				case 'nmtacc':
					break;
				case 'alasantacc':
					break;
				case 'infodenda':
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
	static deepParse(data: string | { [K in keyof BpjsPcareKunjunganRujukanModel]?: BpjsPcareKunjunganRujukanModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPcareKunjunganRujukanModel(data);
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
	 * `let bpjsPcareKunjunganRujukanModel = new BpjsPcareKunjunganRujukanModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPcareKunjunganRujukanModel,
	 *    it is expected as a JSON string or as a nullable BpjsPcareKunjunganRujukanModel.
	 */
	constructor(data?: string | Partial<BpjsPcareKunjunganRujukanModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPcareKunjunganRujukanModel>
				: data;

			this.norujukan = json.norujukan;
			this.kdppk = json.kdppk;
			this.nmppk = json.nmppk;
			this.alamat = json.alamat;
			this.kdkc = json.kdkc;
			this.nmkc = json.nmkc;
			this.alamatkc = json.alamatkc;
			this.telpkc = json.telpkc;
			this.faxkc = json.faxkc;
			this.kdprop = json.kdprop;
			this.kddati = json.kddati;
			this.nmdati = json.nmdati;
			this.kdkr = json.kdkr;
			this.nmkr = json.nmkr;
			this.alamatkr = json.alamatkr;
			this.telpkr = json.telpkr;
			this.faxkr = json.faxkr;
			this.tglkunjungan = json.tglkunjungan;
			this.kdpoli = json.kdpoli;
			this.nmpoli = json.nmpoli;
			this.nokapst = json.nokapst;
			this.nmpst = json.nmpst;
			this.tgllahir = json.tgllahir;
			this.pisa = json.pisa;
			this.ketpisa = json.ketpisa;
			this.sex = json.sex;
			this.kddiag1 = json.kddiag1;
			this.nmdiag1 = json.nmdiag1;
			this.kddiag2 = json.kddiag2;
			this.nmdiag2 = json.nmdiag2;
			this.kddiag3 = json.kddiag3;
			this.nmdiag3 = json.nmdiag3;
			this.catatan = json.catatan;
			this.kddokter = json.kddokter;
			this.nmdokter = json.nmdokter;
			this.nmtacc = json.nmtacc;
			this.alasantacc = json.alasantacc;
			this.infodenda = json.infodenda;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			norujukan: this.norujukan,
			kdppk: this.kdppk,
			nmppk: this.nmppk,
			alamat: this.alamat,
			kdkc: this.kdkc,
			nmkc: this.nmkc,
			alamatkc: this.alamatkc,
			telpkc: this.telpkc,
			faxkc: this.faxkc,
			kdprop: this.kdprop,
			kddati: this.kddati,
			nmdati: this.nmdati,
			kdkr: this.kdkr,
			nmkr: this.nmkr,
			alamatkr: this.alamatkr,
			telpkr: this.telpkr,
			faxkr: this.faxkr,
			tglkunjungan: this.tglkunjungan,
			kdpoli: this.kdpoli,
			nmpoli: this.nmpoli,
			nokapst: this.nokapst,
			nmpst: this.nmpst,
			tgllahir: this.tgllahir,
			pisa: this.pisa,
			ketpisa: this.ketpisa,
			sex: this.sex,
			kddiag1: this.kddiag1,
			nmdiag1: this.nmdiag1,
			kddiag2: this.kddiag2,
			nmdiag2: this.nmdiag2,
			kddiag3: this.kddiag3,
			nmdiag3: this.nmdiag3,
			catatan: this.catatan,
			kddokter: this.kddokter,
			nmdokter: this.nmdokter,
			nmtacc: this.nmtacc,
			alasantacc: this.alasantacc,
			infodenda: this.infodenda,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPcareKunjunganRujukanModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPcareKunjunganRujukanModel {
		let newModelJson = this.toJSON();

		if (updates.norujukan) {
			newModelJson.norujukan = updates.norujukan;
		}

		if (updates.kdppk) {
			newModelJson.kdppk = updates.kdppk;
		}

		if (updates.nmppk) {
			newModelJson.nmppk = updates.nmppk;
		}

		if (updates.alamat) {
			newModelJson.alamat = updates.alamat;
		}

		if (updates.kdkc) {
			newModelJson.kdkc = updates.kdkc;
		}

		if (updates.nmkc) {
			newModelJson.nmkc = updates.nmkc;
		}

		if (updates.alamatkc) {
			newModelJson.alamatkc = updates.alamatkc;
		}

		if (updates.telpkc) {
			newModelJson.telpkc = updates.telpkc;
		}

		if (updates.faxkc) {
			newModelJson.faxkc = updates.faxkc;
		}

		if (updates.kdprop) {
			newModelJson.kdprop = updates.kdprop;
		}

		if (updates.kddati) {
			newModelJson.kddati = updates.kddati;
		}

		if (updates.nmdati) {
			newModelJson.nmdati = updates.nmdati;
		}

		if (updates.kdkr) {
			newModelJson.kdkr = updates.kdkr;
		}

		if (updates.nmkr) {
			newModelJson.nmkr = updates.nmkr;
		}

		if (updates.alamatkr) {
			newModelJson.alamatkr = updates.alamatkr;
		}

		if (updates.telpkr) {
			newModelJson.telpkr = updates.telpkr;
		}

		if (updates.faxkr) {
			newModelJson.faxkr = updates.faxkr;
		}

		if (updates.tglkunjungan) {
			newModelJson.tglkunjungan = updates.tglkunjungan;
		}

		if (updates.kdpoli) {
			newModelJson.kdpoli = updates.kdpoli;
		}

		if (updates.nmpoli) {
			newModelJson.nmpoli = updates.nmpoli;
		}

		if (updates.nokapst) {
			newModelJson.nokapst = updates.nokapst;
		}

		if (updates.nmpst) {
			newModelJson.nmpst = updates.nmpst;
		}

		if (updates.tgllahir) {
			newModelJson.tgllahir = updates.tgllahir;
		}

		if (updates.pisa) {
			newModelJson.pisa = updates.pisa;
		}

		if (updates.ketpisa) {
			newModelJson.ketpisa = updates.ketpisa;
		}

		if (updates.sex) {
			newModelJson.sex = updates.sex;
		}

		if (updates.kddiag1) {
			newModelJson.kddiag1 = updates.kddiag1;
		}

		if (updates.nmdiag1) {
			newModelJson.nmdiag1 = updates.nmdiag1;
		}

		if (updates.kddiag2) {
			newModelJson.kddiag2 = updates.kddiag2;
		}

		if (updates.nmdiag2) {
			newModelJson.nmdiag2 = updates.nmdiag2;
		}

		if (updates.kddiag3) {
			newModelJson.kddiag3 = updates.kddiag3;
		}

		if (updates.nmdiag3) {
			newModelJson.nmdiag3 = updates.nmdiag3;
		}

		if (updates.catatan) {
			newModelJson.catatan = updates.catatan;
		}

		if (updates.kddokter) {
			newModelJson.kddokter = updates.kddokter;
		}

		if (updates.nmdokter) {
			newModelJson.nmdokter = updates.nmdokter;
		}

		if (updates.nmtacc) {
			newModelJson.nmtacc = updates.nmtacc;
		}

		if (updates.alasantacc) {
			newModelJson.alasantacc = updates.alasantacc;
		}

		if (updates.infodenda) {
			newModelJson.infodenda = updates.infodenda;
		}

		return new BpjsPcareKunjunganRujukanModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPcareKunjunganRujukanModel)) {
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
