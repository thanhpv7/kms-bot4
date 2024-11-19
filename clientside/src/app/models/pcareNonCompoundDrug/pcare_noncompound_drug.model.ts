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
import {PcareExaminationModel} from '../pcareExamination/pcare_examination.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PcareNonCompoundDrugModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'racikan',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'drugCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PcareNonCompoundDrugModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PcareNonCompoundDrugModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Drug Code - Obat Kode.
	 */
	drugCode: string;

	/**
	 * Drug Name - Obat Nama.
	 */
	drugName: string;

	/**
	 * .
	 */
	signaDays: number;

	/**
	 * .
	 */
	signaTimes: number;

	/**
	 * Drug Qty - Jumlah Obat.
	 */
	drugQty: number;

	/**
	 * Day - Hari.
	 */
	day: number;

	/**
	 * jmlPermintaan.
	 */
	requestQty: number;

	/**
	 * ksObatSK.
	 */
	kdObatSK: string;

	/**
	 * .
	 */
	racikan: boolean = false;

	/**
	 * kdRacikan.
	 */
	kdRacikan: string;

	pcareExaminationId: string;

	pcareExamination: PcareExaminationModel;

	modelPropGroups: { [s: string]: Group } = PcareNonCompoundDrugModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'drugCode',
				// % protected region % [Set displayName for Drug Code here] off begin
				displayName: 'Drug Code',
				// % protected region % [Set displayName for Drug Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Drug Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Drug Code here] end
				// % protected region % [Set isSensitive for Drug Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drug Code here] end
				// % protected region % [Set readonly for Drug Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drug Code here] end
				validators: [
					// % protected region % [Add other validators for Drug Code here] off begin
					// % protected region % [Add other validators for Drug Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Drug Code here] off begin
				// % protected region % [Add any additional model attribute properties for Drug Code here] end
			},
			{
				name: 'drugName',
				// % protected region % [Set displayName for Drug Name here] off begin
				displayName: 'Drug Name',
				// % protected region % [Set displayName for Drug Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Drug Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Drug Name here] end
				// % protected region % [Set isSensitive for Drug Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drug Name here] end
				// % protected region % [Set readonly for Drug Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drug Name here] end
				validators: [
					// % protected region % [Add other validators for Drug Name here] off begin
					// % protected region % [Add other validators for Drug Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Drug Name here] off begin
				// % protected region % [Add any additional model attribute properties for Drug Name here] end
			},
			{
				name: 'signaDays',
				// % protected region % [Set displayName for Signa Days here] off begin
				displayName: 'Signa Days',
				// % protected region % [Set displayName for Signa Days here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Signa Days here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Signa Days here] end
				// % protected region % [Set isSensitive for Signa Days here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Signa Days here] end
				// % protected region % [Set readonly for Signa Days here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Signa Days here] end
				validators: [
					// % protected region % [Add other validators for Signa Days here] off begin
					// % protected region % [Add other validators for Signa Days here] end
				],
				// % protected region % [Add any additional model attribute properties for Signa Days here] off begin
				// % protected region % [Add any additional model attribute properties for Signa Days here] end
			},
			{
				name: 'signaTimes',
				// % protected region % [Set displayName for Signa Times here] off begin
				displayName: 'Signa Times',
				// % protected region % [Set displayName for Signa Times here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Signa Times here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Signa Times here] end
				// % protected region % [Set isSensitive for Signa Times here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Signa Times here] end
				// % protected region % [Set readonly for Signa Times here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Signa Times here] end
				validators: [
					// % protected region % [Add other validators for Signa Times here] off begin
					// % protected region % [Add other validators for Signa Times here] end
				],
				// % protected region % [Add any additional model attribute properties for Signa Times here] off begin
				// % protected region % [Add any additional model attribute properties for Signa Times here] end
			},
			{
				name: 'drugQty',
				// % protected region % [Set displayName for Drug Qty here] off begin
				displayName: 'Drug Qty',
				// % protected region % [Set displayName for Drug Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Drug Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Drug Qty here] end
				// % protected region % [Set isSensitive for Drug Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Drug Qty here] end
				// % protected region % [Set readonly for Drug Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Drug Qty here] end
				validators: [
					// % protected region % [Add other validators for Drug Qty here] off begin
					// % protected region % [Add other validators for Drug Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Drug Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Drug Qty here] end
			},
			{
				name: 'day',
				// % protected region % [Set displayName for Day here] off begin
				displayName: 'Day',
				// % protected region % [Set displayName for Day here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Day here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Day here] end
				// % protected region % [Set isSensitive for Day here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Day here] end
				// % protected region % [Set readonly for Day here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Day here] end
				validators: [
					// % protected region % [Add other validators for Day here] off begin
					// % protected region % [Add other validators for Day here] end
				],
				// % protected region % [Add any additional model attribute properties for Day here] off begin
				// % protected region % [Add any additional model attribute properties for Day here] end
			},
			{
				name: 'requestQty',
				// % protected region % [Set displayName for Request Qty here] off begin
				displayName: 'Request Qty',
				// % protected region % [Set displayName for Request Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Request Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Request Qty here] end
				// % protected region % [Set isSensitive for Request Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Request Qty here] end
				// % protected region % [Set readonly for Request Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Request Qty here] end
				validators: [
					// % protected region % [Add other validators for Request Qty here] off begin
					// % protected region % [Add other validators for Request Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Request Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Request Qty here] end
			},
			{
				name: 'kdObatSK',
				// % protected region % [Set displayName for Kd Obat SK here] off begin
				displayName: 'Kd Obat SK',
				// % protected region % [Set displayName for Kd Obat SK here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kd Obat SK here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kd Obat SK here] end
				// % protected region % [Set isSensitive for Kd Obat SK here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kd Obat SK here] end
				// % protected region % [Set readonly for Kd Obat SK here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kd Obat SK here] end
				validators: [
					// % protected region % [Add other validators for Kd Obat SK here] off begin
					// % protected region % [Add other validators for Kd Obat SK here] end
				],
				// % protected region % [Add any additional model attribute properties for Kd Obat SK here] off begin
				// % protected region % [Add any additional model attribute properties for Kd Obat SK here] end
			},
			{
				name: 'racikan',
				// % protected region % [Set displayName for Racikan here] off begin
				displayName: 'Racikan',
				// % protected region % [Set displayName for Racikan here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Racikan here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Racikan here] end
				// % protected region % [Set isSensitive for Racikan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Racikan here] end
				// % protected region % [Set readonly for Racikan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Racikan here] end
				validators: [
					// % protected region % [Add other validators for Racikan here] off begin
					// % protected region % [Add other validators for Racikan here] end
				],
				// % protected region % [Add any additional model attribute properties for Racikan here] off begin
				// % protected region % [Add any additional model attribute properties for Racikan here] end
			},
			{
				name: 'kdRacikan',
				// % protected region % [Set displayName for Kd Racikan here] off begin
				displayName: 'Kd Racikan',
				// % protected region % [Set displayName for Kd Racikan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Kd Racikan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Kd Racikan here] end
				// % protected region % [Set isSensitive for Kd Racikan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kd Racikan here] end
				// % protected region % [Set readonly for Kd Racikan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kd Racikan here] end
				validators: [
					// % protected region % [Add other validators for Kd Racikan here] off begin
					// % protected region % [Add other validators for Kd Racikan here] end
				],
				// % protected region % [Add any additional model attribute properties for Kd Racikan here] off begin
				// % protected region % [Add any additional model attribute properties for Kd Racikan here] end
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
				id: 'pcareExamination',
				type: ModelRelationType.ONE,
				name: 'pcareExaminationId',
				// % protected region % [Customise your label for PCare Examination here] off begin
				label: 'PCare Examination',
				// % protected region % [Customise your label for PCare Examination here] end
				entityName: 'PcareExaminationModel',
				// % protected region % [Customise your display name for PCare Examination here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'visitType',
				// % protected region % [Customise your display name for PCare Examination here] end
				validators: [
					// % protected region % [Add other validators for PCare Examination here] off begin
					// % protected region % [Add other validators for PCare Examination here] end
				],
				// % protected region % [Add any additional field for relation PCare Examination here] off begin
				// % protected region % [Add any additional field for relation PCare Examination here] end
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
				case 'racikan':
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
	static deepParse(data: string | { [K in keyof PcareNonCompoundDrugModel]?: PcareNonCompoundDrugModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PcareNonCompoundDrugModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.pcareExamination) {
			currentModel.pcareExaminationId = json.pcareExamination.id;
			returned = _.union(returned, PcareExaminationModel.deepParse(json.pcareExamination));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let pcareNonCompoundDrugModel = new PcareNonCompoundDrugModel(data);`
	 *
	 * @param data The input data to be initialised as the PcareNonCompoundDrugModel,
	 *    it is expected as a JSON string or as a nullable PcareNonCompoundDrugModel.
	 */
	constructor(data?: string | Partial<PcareNonCompoundDrugModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PcareNonCompoundDrugModel>
				: data;

			this.drugCode = json.drugCode;
			this.drugName = json.drugName;
			this.signaDays = json.signaDays;
			this.signaTimes = json.signaTimes;
			this.drugQty = json.drugQty;
			this.day = json.day;
			this.requestQty = json.requestQty;
			this.kdObatSK = json.kdObatSK;
			this.racikan = json.racikan;
			this.kdRacikan = json.kdRacikan;
			this.pcareExaminationId = json.pcareExaminationId;
			this.pcareExamination = json.pcareExamination;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			drugCode: this.drugCode,
			drugName: this.drugName,
			signaDays: this.signaDays,
			signaTimes: this.signaTimes,
			drugQty: this.drugQty,
			day: this.day,
			requestQty: this.requestQty,
			kdObatSK: this.kdObatSK,
			racikan: this.racikan,
			kdRacikan: this.kdRacikan,
			pcareExaminationId: this.pcareExaminationId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PcareNonCompoundDrugModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PcareNonCompoundDrugModel {
		let newModelJson = this.toJSON();

		if (updates.drugCode) {
			newModelJson.drugCode = updates.drugCode;
		}

		if (updates.drugName) {
			newModelJson.drugName = updates.drugName;
		}

		if (updates.signaDays) {
			newModelJson.signaDays = updates.signaDays;
		}

		if (updates.signaTimes) {
			newModelJson.signaTimes = updates.signaTimes;
		}

		if (updates.drugQty) {
			newModelJson.drugQty = updates.drugQty;
		}

		if (updates.day) {
			newModelJson.day = updates.day;
		}

		if (updates.requestQty) {
			newModelJson.requestQty = updates.requestQty;
		}

		if (updates.kdObatSK) {
			newModelJson.kdObatSK = updates.kdObatSK;
		}

		if (updates.racikan) {
			newModelJson.racikan = updates.racikan;
		}

		if (updates.kdRacikan) {
			newModelJson.kdRacikan = updates.kdRacikan;
		}

		if (updates.pcareExaminationId) {
			newModelJson.pcareExaminationId = updates.pcareExaminationId;
		}

		return new PcareNonCompoundDrugModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PcareNonCompoundDrugModel)) {
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
			'pcareExaminationId',
			'pcareExamination',
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
		if (!this.pcareExamination) {
			this.pcareExaminationId = null;
		} else {
			this.pcareExaminationId = this.pcareExamination.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
