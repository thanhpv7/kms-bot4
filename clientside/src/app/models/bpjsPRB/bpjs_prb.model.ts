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
import {BpjsDiagnosePRBModel} from '../bpjsDiagnosePRB/bpjs_diagnose_prb.model';
import {BpjsDoctorMappingModel} from '../bpjsDoctorMapping/bpjs_doctor_mapping.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsPRBModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'srbNo',
		'sepNo',
		'bpjsCardNo',
		'address',
		'email',
		'prbProgramCode',
		'prbProgramName',
		'doctorCode',
		'doctorName',
		'notes',
		'recommendation',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'srbNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsPRBModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsPRBModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	srbNo: string;

	/**
	 * .
	 */
	sepNo: string;

	/**
	 * .
	 */
	bpjsCardNo: string;

	/**
	 * .
	 */
	address: string;

	/**
	 * .
	 */
	email: string;

	/**
	 * .
	 */
	prbProgramCode: string;

	/**
	 * .
	 */
	prbProgramName: string;

	/**
	 * .
	 */
	doctorCode: string;

	/**
	 * .
	 */
	doctorName: string;

	/**
	 * .
	 */
	notes: string;

	/**
	 * .
	 */
	recommendation: string;

	bpjsDiagnosePRBId: string;

	bpjsDiagnosePRB: BpjsDiagnosePRBModel;

	bpjsDoctorMappingId: string;

	bpjsDoctorMapping: BpjsDoctorMappingModel;

	modelPropGroups: { [s: string]: Group } = BpjsPRBModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'srbNo',
				// % protected region % [Set displayName for SRB No here] off begin
				displayName: 'SRB No',
				// % protected region % [Set displayName for SRB No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SRB No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SRB No here] end
				// % protected region % [Set isSensitive for SRB No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SRB No here] end
				// % protected region % [Set readonly for SRB No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SRB No here] end
				validators: [
					// % protected region % [Add other validators for SRB No here] off begin
					// % protected region % [Add other validators for SRB No here] end
				],
				// % protected region % [Add any additional model attribute properties for SRB No here] off begin
				// % protected region % [Add any additional model attribute properties for SRB No here] end
			},
			{
				name: 'sepNo',
				// % protected region % [Set displayName for SEP No here] off begin
				displayName: 'SEP No',
				// % protected region % [Set displayName for SEP No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SEP No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SEP No here] end
				// % protected region % [Set isSensitive for SEP No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SEP No here] end
				// % protected region % [Set readonly for SEP No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SEP No here] end
				validators: [
					// % protected region % [Add other validators for SEP No here] off begin
					// % protected region % [Add other validators for SEP No here] end
				],
				// % protected region % [Add any additional model attribute properties for SEP No here] off begin
				// % protected region % [Add any additional model attribute properties for SEP No here] end
			},
			{
				name: 'bpjsCardNo',
				// % protected region % [Set displayName for BPJS Card No here] off begin
				displayName: 'BPJS Card No',
				// % protected region % [Set displayName for BPJS Card No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for BPJS Card No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for BPJS Card No here] end
				// % protected region % [Set isSensitive for BPJS Card No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for BPJS Card No here] end
				// % protected region % [Set readonly for BPJS Card No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for BPJS Card No here] end
				validators: [
					// % protected region % [Add other validators for BPJS Card No here] off begin
					// % protected region % [Add other validators for BPJS Card No here] end
				],
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] off begin
				// % protected region % [Add any additional model attribute properties for BPJS Card No here] end
			},
			{
				name: 'address',
				// % protected region % [Set displayName for Address here] off begin
				displayName: 'Address',
				// % protected region % [Set displayName for Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Address here] end
				// % protected region % [Set isSensitive for Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Address here] end
				// % protected region % [Set readonly for Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Address here] end
				validators: [
					// % protected region % [Add other validators for Address here] off begin
					// % protected region % [Add other validators for Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Address here] off begin
				// % protected region % [Add any additional model attribute properties for Address here] end
			},
			{
				name: 'email',
				// % protected region % [Set displayName for Email here] off begin
				displayName: 'Email',
				// % protected region % [Set displayName for Email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Email here] end
				// % protected region % [Set isSensitive for Email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Email here] end
				// % protected region % [Set readonly for Email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Email here] end
				validators: [
					// % protected region % [Add other validators for Email here] off begin
					// % protected region % [Add other validators for Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Email here] off begin
				// % protected region % [Add any additional model attribute properties for Email here] end
			},
			{
				name: 'prbProgramCode',
				// % protected region % [Set displayName for PRB Program Code here] off begin
				displayName: 'PRB Program Code',
				// % protected region % [Set displayName for PRB Program Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for PRB Program Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for PRB Program Code here] end
				// % protected region % [Set isSensitive for PRB Program Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for PRB Program Code here] end
				// % protected region % [Set readonly for PRB Program Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for PRB Program Code here] end
				validators: [
					// % protected region % [Add other validators for PRB Program Code here] off begin
					// % protected region % [Add other validators for PRB Program Code here] end
				],
				// % protected region % [Add any additional model attribute properties for PRB Program Code here] off begin
				// % protected region % [Add any additional model attribute properties for PRB Program Code here] end
			},
			{
				name: 'prbProgramName',
				// % protected region % [Set displayName for PRB Program Name here] off begin
				displayName: 'PRB Program Name',
				// % protected region % [Set displayName for PRB Program Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for PRB Program Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for PRB Program Name here] end
				// % protected region % [Set isSensitive for PRB Program Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for PRB Program Name here] end
				// % protected region % [Set readonly for PRB Program Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for PRB Program Name here] end
				validators: [
					// % protected region % [Add other validators for PRB Program Name here] off begin
					// % protected region % [Add other validators for PRB Program Name here] end
				],
				// % protected region % [Add any additional model attribute properties for PRB Program Name here] off begin
				// % protected region % [Add any additional model attribute properties for PRB Program Name here] end
			},
			{
				name: 'doctorCode',
				// % protected region % [Set displayName for Doctor Code here] off begin
				displayName: 'Doctor Code',
				// % protected region % [Set displayName for Doctor Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor Code here] end
				// % protected region % [Set isSensitive for Doctor Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor Code here] end
				// % protected region % [Set readonly for Doctor Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor Code here] end
				validators: [
					// % protected region % [Add other validators for Doctor Code here] off begin
					// % protected region % [Add other validators for Doctor Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor Code here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor Code here] end
			},
			{
				name: 'doctorName',
				// % protected region % [Set displayName for Doctor Name here] off begin
				displayName: 'Doctor Name',
				// % protected region % [Set displayName for Doctor Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor Name here] end
				// % protected region % [Set isSensitive for Doctor Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor Name here] end
				// % protected region % [Set readonly for Doctor Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor Name here] end
				validators: [
					// % protected region % [Add other validators for Doctor Name here] off begin
					// % protected region % [Add other validators for Doctor Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor Name here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor Name here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.INPUT,
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
				name: 'recommendation',
				// % protected region % [Set displayName for Recommendation here] off begin
				displayName: 'Recommendation',
				// % protected region % [Set displayName for Recommendation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Recommendation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Recommendation here] end
				// % protected region % [Set isSensitive for Recommendation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Recommendation here] end
				// % protected region % [Set readonly for Recommendation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Recommendation here] end
				validators: [
					// % protected region % [Add other validators for Recommendation here] off begin
					// % protected region % [Add other validators for Recommendation here] end
				],
				// % protected region % [Add any additional model attribute properties for Recommendation here] off begin
				// % protected region % [Add any additional model attribute properties for Recommendation here] end
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
				id: 'bpjsDiagnosePRB',
				type: ModelRelationType.ONE,
				name: 'bpjsDiagnosePRBId',
				// % protected region % [Customise your label for BPJS Diagnose PRB here] off begin
				label: 'BPJS Diagnose PRB',
				// % protected region % [Customise your label for BPJS Diagnose PRB here] end
				entityName: 'BpjsDiagnosePRBModel',
				// % protected region % [Customise your display name for BPJS Diagnose PRB here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Diagnose PRB here] end
				validators: [
					// % protected region % [Add other validators for BPJS Diagnose PRB here] off begin
					// % protected region % [Add other validators for BPJS Diagnose PRB here] end
				],
				// % protected region % [Add any additional field for relation BPJS Diagnose PRB here] off begin
				// % protected region % [Add any additional field for relation BPJS Diagnose PRB here] end
			},
			{
				id: 'bpjsDoctorMapping',
				type: ModelRelationType.ONE,
				name: 'bpjsDoctorMappingId',
				// % protected region % [Customise your label for BPJS Doctor Mapping here] off begin
				label: 'BPJS Doctor Mapping',
				// % protected region % [Customise your label for BPJS Doctor Mapping here] end
				entityName: 'BpjsDoctorMappingModel',
				// % protected region % [Customise your display name for BPJS Doctor Mapping here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Doctor Mapping here] end
				validators: [
					// % protected region % [Add other validators for BPJS Doctor Mapping here] off begin
					// % protected region % [Add other validators for BPJS Doctor Mapping here] end
				],
				// % protected region % [Add any additional field for relation BPJS Doctor Mapping here] off begin
				// % protected region % [Add any additional field for relation BPJS Doctor Mapping here] end
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
				case 'srbNo':
					break;
				case 'sepNo':
					break;
				case 'bpjsCardNo':
					break;
				case 'address':
					break;
				case 'email':
					break;
				case 'prbProgramCode':
					break;
				case 'prbProgramName':
					break;
				case 'doctorCode':
					break;
				case 'doctorName':
					break;
				case 'notes':
					break;
				case 'recommendation':
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
	static deepParse(data: string | { [K in keyof BpjsPRBModel]?: BpjsPRBModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsPRBModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.bpjsDiagnosePRB) {
			currentModel.bpjsDiagnosePRBId = json.bpjsDiagnosePRB.id;
			returned = _.union(returned, BpjsDiagnosePRBModel.deepParse(json.bpjsDiagnosePRB));
		}

		// Incoming one to many
		if (json.bpjsDoctorMapping) {
			currentModel.bpjsDoctorMappingId = json.bpjsDoctorMapping.id;
			returned = _.union(returned, BpjsDoctorMappingModel.deepParse(json.bpjsDoctorMapping));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsPRBModel = new BpjsPRBModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsPRBModel,
	 *    it is expected as a JSON string or as a nullable BpjsPRBModel.
	 */
	constructor(data?: string | Partial<BpjsPRBModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsPRBModel>
				: data;

			this.srbNo = json.srbNo;
			this.sepNo = json.sepNo;
			this.bpjsCardNo = json.bpjsCardNo;
			this.address = json.address;
			this.email = json.email;
			this.prbProgramCode = json.prbProgramCode;
			this.prbProgramName = json.prbProgramName;
			this.doctorCode = json.doctorCode;
			this.doctorName = json.doctorName;
			this.notes = json.notes;
			this.recommendation = json.recommendation;
			this.bpjsDiagnosePRBId = json.bpjsDiagnosePRBId;
			this.bpjsDiagnosePRB = json.bpjsDiagnosePRB;
			this.bpjsDoctorMappingId = json.bpjsDoctorMappingId;
			this.bpjsDoctorMapping = json.bpjsDoctorMapping;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			srbNo: this.srbNo,
			sepNo: this.sepNo,
			bpjsCardNo: this.bpjsCardNo,
			address: this.address,
			email: this.email,
			prbProgramCode: this.prbProgramCode,
			prbProgramName: this.prbProgramName,
			doctorCode: this.doctorCode,
			doctorName: this.doctorName,
			notes: this.notes,
			recommendation: this.recommendation,
			bpjsDiagnosePRBId: this.bpjsDiagnosePRBId,
			bpjsDoctorMappingId: this.bpjsDoctorMappingId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsPRBModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsPRBModel {
		let newModelJson = this.toJSON();

		if (updates.srbNo) {
			newModelJson.srbNo = updates.srbNo;
		}

		if (updates.sepNo) {
			newModelJson.sepNo = updates.sepNo;
		}

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.address) {
			newModelJson.address = updates.address;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.prbProgramCode) {
			newModelJson.prbProgramCode = updates.prbProgramCode;
		}

		if (updates.prbProgramName) {
			newModelJson.prbProgramName = updates.prbProgramName;
		}

		if (updates.doctorCode) {
			newModelJson.doctorCode = updates.doctorCode;
		}

		if (updates.doctorName) {
			newModelJson.doctorName = updates.doctorName;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.recommendation) {
			newModelJson.recommendation = updates.recommendation;
		}

		if (updates.bpjsDiagnosePRBId) {
			newModelJson.bpjsDiagnosePRBId = updates.bpjsDiagnosePRBId;
		}

		if (updates.bpjsDoctorMappingId) {
			newModelJson.bpjsDoctorMappingId = updates.bpjsDoctorMappingId;
		}

		return new BpjsPRBModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsPRBModel)) {
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
			'bpjsDiagnosePRBId',
			'bpjsDiagnosePRB',
			'bpjsDoctorMappingId',
			'bpjsDoctorMapping',
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
		if (!this.bpjsDiagnosePRB) {
			this.bpjsDiagnosePRBId = null;
		} else {
			this.bpjsDiagnosePRBId = this.bpjsDiagnosePRB.id;
		}

		if (!this.bpjsDoctorMapping) {
			this.bpjsDoctorMappingId = null;
		} else {
			this.bpjsDoctorMappingId = this.bpjsDoctorMapping.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
