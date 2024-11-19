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
import {BpjsDoctorMappingModel} from '../bpjsDoctorMapping/bpjs_doctor_mapping.model';
import {BpjsServiceMappingModel} from '../bpjsServiceMapping/bpjs_service_mapping.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsControlPlanModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'noSEP',
		'controlLetterNo',
		'controlPlanDate',
		'bpjsCardNo',
		'name',
		'gender',
		'dateOfBirth',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'noSEP',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsControlPlanModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsControlPlanModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * nomor SEP.
	 */
	noSEP: string;

	/**
	 * .
	 */
	controlLetterNo: string;

	/**
	 * .
	 */
	controlPlanDate: string;

	/**
	 * .
	 */
	bpjsCardNo: string;

	/**
	 * .
	 */
	name: string;

	/**
	 * .
	 */
	gender: string;

	/**
	 * .
	 */
	dateOfBirth: string;

	/**
	 * .
	 */
	doctorCode: string;

	/**
	 * .
	 */
	polyclinicCode: string;

	bpjsDoctorMappingId: string;

	bpjsDoctorMapping: BpjsDoctorMappingModel;

	bpjsServiceMappingId: string;

	bpjsServiceMapping: BpjsServiceMappingModel;

	modelPropGroups: { [s: string]: Group } = BpjsControlPlanModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'noSEP',
				// % protected region % [Set displayName for No SEP here] off begin
				displayName: 'No SEP',
				// % protected region % [Set displayName for No SEP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for No SEP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for No SEP here] end
				// % protected region % [Set isSensitive for No SEP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for No SEP here] end
				// % protected region % [Set readonly for No SEP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for No SEP here] end
				validators: [
					// % protected region % [Add other validators for No SEP here] off begin
					// % protected region % [Add other validators for No SEP here] end
				],
				// % protected region % [Add any additional model attribute properties for No SEP here] off begin
				// % protected region % [Add any additional model attribute properties for No SEP here] end
			},
			{
				name: 'controlLetterNo',
				// % protected region % [Set displayName for Control Letter No here] off begin
				displayName: 'Control Letter No',
				// % protected region % [Set displayName for Control Letter No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Control Letter No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Control Letter No here] end
				// % protected region % [Set isSensitive for Control Letter No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Control Letter No here] end
				// % protected region % [Set readonly for Control Letter No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Control Letter No here] end
				validators: [
					// % protected region % [Add other validators for Control Letter No here] off begin
					// % protected region % [Add other validators for Control Letter No here] end
				],
				// % protected region % [Add any additional model attribute properties for Control Letter No here] off begin
				// % protected region % [Add any additional model attribute properties for Control Letter No here] end
			},
			{
				name: 'controlPlanDate',
				// % protected region % [Set displayName for Control Plan Date here] off begin
				displayName: 'Control Plan Date',
				// % protected region % [Set displayName for Control Plan Date here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Control Plan Date here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Control Plan Date here] end
				// % protected region % [Set isSensitive for Control Plan Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Control Plan Date here] end
				// % protected region % [Set readonly for Control Plan Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Control Plan Date here] end
				validators: [
					// % protected region % [Add other validators for Control Plan Date here] off begin
					// % protected region % [Add other validators for Control Plan Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Control Plan Date here] off begin
				// % protected region % [Add any additional model attribute properties for Control Plan Date here] end
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
				name: 'name',
				// % protected region % [Set displayName for Name here] off begin
				displayName: 'Name',
				// % protected region % [Set displayName for Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Name here] end
				// % protected region % [Set isSensitive for Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Name here] end
				// % protected region % [Set readonly for Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Name here] end
				validators: [
					// % protected region % [Add other validators for Name here] off begin
					// % protected region % [Add other validators for Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Name here] off begin
				// % protected region % [Add any additional model attribute properties for Name here] end
			},
			{
				name: 'gender',
				// % protected region % [Set displayName for Gender here] off begin
				displayName: 'Gender',
				// % protected region % [Set displayName for Gender here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gender here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gender here] end
				// % protected region % [Set isSensitive for Gender here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gender here] end
				// % protected region % [Set readonly for Gender here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gender here] end
				validators: [
					// % protected region % [Add other validators for Gender here] off begin
					// % protected region % [Add other validators for Gender here] end
				],
				// % protected region % [Add any additional model attribute properties for Gender here] off begin
				// % protected region % [Add any additional model attribute properties for Gender here] end
			},
			{
				name: 'dateOfBirth',
				// % protected region % [Set displayName for Date Of Birth here] off begin
				displayName: 'Date Of Birth',
				// % protected region % [Set displayName for Date Of Birth here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Date Of Birth here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Date Of Birth here] end
				// % protected region % [Set isSensitive for Date Of Birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date Of Birth here] end
				// % protected region % [Set readonly for Date Of Birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date Of Birth here] end
				validators: [
					// % protected region % [Add other validators for Date Of Birth here] off begin
					// % protected region % [Add other validators for Date Of Birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Date Of Birth here] off begin
				// % protected region % [Add any additional model attribute properties for Date Of Birth here] end
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
				name: 'polyclinicCode',
				// % protected region % [Set displayName for Polyclinic Code here] off begin
				displayName: 'Polyclinic Code',
				// % protected region % [Set displayName for Polyclinic Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Polyclinic Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Polyclinic Code here] end
				// % protected region % [Set isSensitive for Polyclinic Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Polyclinic Code here] end
				// % protected region % [Set readonly for Polyclinic Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Polyclinic Code here] end
				validators: [
					// % protected region % [Add other validators for Polyclinic Code here] off begin
					// % protected region % [Add other validators for Polyclinic Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Polyclinic Code here] off begin
				// % protected region % [Add any additional model attribute properties for Polyclinic Code here] end
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
			{
				id: 'bpjsServiceMapping',
				type: ModelRelationType.ONE,
				name: 'bpjsServiceMappingId',
				// % protected region % [Customise your label for BPJS Service Mapping here] off begin
				label: 'BPJS Service Mapping',
				// % protected region % [Customise your label for BPJS Service Mapping here] end
				entityName: 'BpjsServiceMappingModel',
				// % protected region % [Customise your display name for BPJS Service Mapping here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Service Mapping here] end
				validators: [
					// % protected region % [Add other validators for BPJS Service Mapping here] off begin
					// % protected region % [Add other validators for BPJS Service Mapping here] end
				],
				// % protected region % [Add any additional field for relation BPJS Service Mapping here] off begin
				// % protected region % [Add any additional field for relation BPJS Service Mapping here] end
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
				case 'noSEP':
					break;
				case 'controlLetterNo':
					break;
				case 'controlPlanDate':
					break;
				case 'bpjsCardNo':
					break;
				case 'name':
					break;
				case 'gender':
					break;
				case 'dateOfBirth':
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
	static deepParse(data: string | { [K in keyof BpjsControlPlanModel]?: BpjsControlPlanModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsControlPlanModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.bpjsDoctorMapping) {
			currentModel.bpjsDoctorMappingId = json.bpjsDoctorMapping.id;
			returned = _.union(returned, BpjsDoctorMappingModel.deepParse(json.bpjsDoctorMapping));
		}

		// Incoming one to many
		if (json.bpjsServiceMapping) {
			currentModel.bpjsServiceMappingId = json.bpjsServiceMapping.id;
			returned = _.union(returned, BpjsServiceMappingModel.deepParse(json.bpjsServiceMapping));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsControlPlanModel = new BpjsControlPlanModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsControlPlanModel,
	 *    it is expected as a JSON string or as a nullable BpjsControlPlanModel.
	 */
	constructor(data?: string | Partial<BpjsControlPlanModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsControlPlanModel>
				: data;

			this.noSEP = json.noSEP;
			this.controlLetterNo = json.controlLetterNo;
			this.controlPlanDate = json.controlPlanDate;
			this.bpjsCardNo = json.bpjsCardNo;
			this.name = json.name;
			this.gender = json.gender;
			this.dateOfBirth = json.dateOfBirth;
			this.doctorCode = json.doctorCode;
			this.polyclinicCode = json.polyclinicCode;
			this.bpjsDoctorMappingId = json.bpjsDoctorMappingId;
			this.bpjsDoctorMapping = json.bpjsDoctorMapping;
			this.bpjsServiceMappingId = json.bpjsServiceMappingId;
			this.bpjsServiceMapping = json.bpjsServiceMapping;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			noSEP: this.noSEP,
			controlLetterNo: this.controlLetterNo,
			controlPlanDate: this.controlPlanDate,
			bpjsCardNo: this.bpjsCardNo,
			name: this.name,
			gender: this.gender,
			dateOfBirth: this.dateOfBirth,
			doctorCode: this.doctorCode,
			polyclinicCode: this.polyclinicCode,
			bpjsDoctorMappingId: this.bpjsDoctorMappingId,
			bpjsServiceMappingId: this.bpjsServiceMappingId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsControlPlanModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsControlPlanModel {
		let newModelJson = this.toJSON();

		if (updates.noSEP) {
			newModelJson.noSEP = updates.noSEP;
		}

		if (updates.controlLetterNo) {
			newModelJson.controlLetterNo = updates.controlLetterNo;
		}

		if (updates.controlPlanDate) {
			newModelJson.controlPlanDate = updates.controlPlanDate;
		}

		if (updates.bpjsCardNo) {
			newModelJson.bpjsCardNo = updates.bpjsCardNo;
		}

		if (updates.name) {
			newModelJson.name = updates.name;
		}

		if (updates.gender) {
			newModelJson.gender = updates.gender;
		}

		if (updates.dateOfBirth) {
			newModelJson.dateOfBirth = updates.dateOfBirth;
		}

		if (updates.doctorCode) {
			newModelJson.doctorCode = updates.doctorCode;
		}

		if (updates.polyclinicCode) {
			newModelJson.polyclinicCode = updates.polyclinicCode;
		}

		if (updates.bpjsDoctorMappingId) {
			newModelJson.bpjsDoctorMappingId = updates.bpjsDoctorMappingId;
		}

		if (updates.bpjsServiceMappingId) {
			newModelJson.bpjsServiceMappingId = updates.bpjsServiceMappingId;
		}

		return new BpjsControlPlanModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsControlPlanModel)) {
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
			'bpjsDoctorMappingId',
			'bpjsDoctorMapping',
			'bpjsServiceMappingId',
			'bpjsServiceMapping',
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
		if (!this.bpjsDoctorMapping) {
			this.bpjsDoctorMappingId = null;
		} else {
			this.bpjsDoctorMappingId = this.bpjsDoctorMapping.id;
		}

		if (!this.bpjsServiceMapping) {
			this.bpjsServiceMappingId = null;
		} else {
			this.bpjsServiceMappingId = this.bpjsServiceMapping.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
