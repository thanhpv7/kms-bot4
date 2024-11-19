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
export class PcareActionExaminationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'kdtindakansk',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'actionCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PcareActionExaminationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PcareActionExaminationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Action Code - Kode Tindakan.
	 */
	actionCode: string;

	/**
	 * Fee - Biaya.
	 */
	fee: number;

	/**
	 * Notes - Keterangan.
	 */
	notes: string;

	/**
	 * Kode Tindakan SK.
	 */
	kdtindakansk: string;

	/**
	 * Hasil.
	 */
	hasil: number;

	pcareExaminationId: string;

	pcareExamination: PcareExaminationModel;

	modelPropGroups: { [s: string]: Group } = PcareActionExaminationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'actionCode',
				// % protected region % [Set displayName for Action Code here] off begin
				displayName: 'Action Code',
				// % protected region % [Set displayName for Action Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Action Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Action Code here] end
				// % protected region % [Set isSensitive for Action Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Action Code here] end
				// % protected region % [Set readonly for Action Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Action Code here] end
				validators: [
					// % protected region % [Add other validators for Action Code here] off begin
					// % protected region % [Add other validators for Action Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Action Code here] off begin
				// % protected region % [Add any additional model attribute properties for Action Code here] end
			},
			{
				name: 'fee',
				// % protected region % [Set displayName for Fee here] off begin
				displayName: 'Fee',
				// % protected region % [Set displayName for Fee here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Fee here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Fee here] end
				// % protected region % [Set isSensitive for Fee here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fee here] end
				// % protected region % [Set readonly for Fee here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fee here] end
				validators: [
					// % protected region % [Add other validators for Fee here] off begin
					// % protected region % [Add other validators for Fee here] end
				],
				// % protected region % [Add any additional model attribute properties for Fee here] off begin
				// % protected region % [Add any additional model attribute properties for Fee here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.TEXTAREA,
				// % protected region % [Set display element type for Notes here] end
				// % protected region % [Set isSensitive for Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Notes here] end
				// % protected region % [Set readonly for Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Notes here] end
				validators: [
					// % protected region % [Add other validators for Notes here] off begin
					// % protected region % [Add other validators for Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Notes here] end
			},
			{
				name: 'kdtindakansk',
				// % protected region % [Set displayName for kdTindakanSK here] off begin
				displayName: 'kdTindakanSK',
				// % protected region % [Set displayName for kdTindakanSK here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for kdTindakanSK here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for kdTindakanSK here] end
				// % protected region % [Set isSensitive for kdTindakanSK here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for kdTindakanSK here] end
				// % protected region % [Set readonly for kdTindakanSK here] off begin
				readOnly: false,
				// % protected region % [Set readonly for kdTindakanSK here] end
				validators: [
					// % protected region % [Add other validators for kdTindakanSK here] off begin
					// % protected region % [Add other validators for kdTindakanSK here] end
				],
				// % protected region % [Add any additional model attribute properties for kdTindakanSK here] off begin
				// % protected region % [Add any additional model attribute properties for kdTindakanSK here] end
			},
			{
				name: 'hasil',
				// % protected region % [Set displayName for hasil here] off begin
				displayName: 'hasil',
				// % protected region % [Set displayName for hasil here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for hasil here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for hasil here] end
				// % protected region % [Set isSensitive for hasil here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for hasil here] end
				// % protected region % [Set readonly for hasil here] off begin
				readOnly: false,
				// % protected region % [Set readonly for hasil here] end
				validators: [
					// % protected region % [Add other validators for hasil here] off begin
					// % protected region % [Add other validators for hasil here] end
				],
				// % protected region % [Add any additional model attribute properties for hasil here] off begin
				// % protected region % [Add any additional model attribute properties for hasil here] end
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
				case 'kdtindakansk':
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
	static deepParse(data: string | { [K in keyof PcareActionExaminationModel]?: PcareActionExaminationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PcareActionExaminationModel(data);
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
	 * `let pcareActionExaminationModel = new PcareActionExaminationModel(data);`
	 *
	 * @param data The input data to be initialised as the PcareActionExaminationModel,
	 *    it is expected as a JSON string or as a nullable PcareActionExaminationModel.
	 */
	constructor(data?: string | Partial<PcareActionExaminationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PcareActionExaminationModel>
				: data;

			this.actionCode = json.actionCode;
			this.fee = json.fee;
			this.notes = json.notes;
			this.kdtindakansk = json.kdtindakansk;
			this.hasil = json.hasil;
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
			actionCode: this.actionCode,
			fee: this.fee,
			notes: this.notes,
			kdtindakansk: this.kdtindakansk,
			hasil: this.hasil,
			pcareExaminationId: this.pcareExaminationId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PcareActionExaminationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PcareActionExaminationModel {
		let newModelJson = this.toJSON();

		if (updates.actionCode) {
			newModelJson.actionCode = updates.actionCode;
		}

		if (updates.fee) {
			newModelJson.fee = updates.fee;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.kdtindakansk) {
			newModelJson.kdtindakansk = updates.kdtindakansk;
		}

		if (updates.hasil) {
			newModelJson.hasil = updates.hasil;
		}

		if (updates.pcareExaminationId) {
			newModelJson.pcareExaminationId = updates.pcareExaminationId;
		}

		return new PcareActionExaminationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PcareActionExaminationModel)) {
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
