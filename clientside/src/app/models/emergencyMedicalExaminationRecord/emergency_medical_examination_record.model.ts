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
import {MedicalExaminationRecordModel} from '../medicalExaminationRecord/medical_examination_record.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class EmergencyMedicalExaminationRecordModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'surgicalOrNonSurgical',
		'caseSpecification',
		'accidentType',
		'emergencyLevel',
		'dateTimeOfInstructions',
		'isDoctorTakingOver',
		'dateTimeOfDrugAdministration',
		'isAutopay',
		'responseTime',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'surgicalOrNonSurgical',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'EmergencyMedicalExaminationRecordModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return EmergencyMedicalExaminationRecordModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	surgicalOrNonSurgical: string;

	/**
	 * .
	 */
	caseSpecification: string;

	/**
	 * .
	 */
	accidentType: string;

	/**
	 * .
	 */
	accidentCause: string;

	/**
	 * .
	 */
	emergencyLevel: string;

	/**
	 * .
	 */
	dateTimeOfInstructions: Date;

	/**
	 * .
	 */
	isDoctorTakingOver: boolean = false;

	/**
	 * .
	 */
	dateTimeOfDrugAdministration: Date;

	/**
	 * .
	 */
	isAutopay: boolean = false;

	/**
	 * .
	 */
	responseTime: number;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	modelPropGroups: { [s: string]: Group } = EmergencyMedicalExaminationRecordModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'surgicalOrNonSurgical',
				// % protected region % [Set displayName for Surgical Or Non Surgical here] off begin
				displayName: 'Surgical Or Non Surgical',
				// % protected region % [Set displayName for Surgical Or Non Surgical here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Surgical Or Non Surgical here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Surgical Or Non Surgical here] end
				// % protected region % [Set isSensitive for Surgical Or Non Surgical here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgical Or Non Surgical here] end
				// % protected region % [Set readonly for Surgical Or Non Surgical here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgical Or Non Surgical here] end
				validators: [
					// % protected region % [Add other validators for Surgical Or Non Surgical here] off begin
					// % protected region % [Add other validators for Surgical Or Non Surgical here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgical Or Non Surgical here] off begin
				// % protected region % [Add any additional model attribute properties for Surgical Or Non Surgical here] end
			},
			{
				name: 'caseSpecification',
				// % protected region % [Set displayName for Case Specification here] off begin
				displayName: 'Case Specification',
				// % protected region % [Set displayName for Case Specification here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Case Specification here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Case Specification here] end
				// % protected region % [Set isSensitive for Case Specification here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Case Specification here] end
				// % protected region % [Set readonly for Case Specification here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Case Specification here] end
				validators: [
					// % protected region % [Add other validators for Case Specification here] off begin
					// % protected region % [Add other validators for Case Specification here] end
				],
				// % protected region % [Add any additional model attribute properties for Case Specification here] off begin
				// % protected region % [Add any additional model attribute properties for Case Specification here] end
			},
			{
				name: 'accidentType',
				// % protected region % [Set displayName for Accident Type here] off begin
				displayName: 'Accident Type',
				// % protected region % [Set displayName for Accident Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Accident Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Accident Type here] end
				// % protected region % [Set isSensitive for Accident Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Accident Type here] end
				// % protected region % [Set readonly for Accident Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Accident Type here] end
				validators: [
					// % protected region % [Add other validators for Accident Type here] off begin
					// % protected region % [Add other validators for Accident Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Accident Type here] off begin
				// % protected region % [Add any additional model attribute properties for Accident Type here] end
			},
			{
				name: 'accidentCause',
				// % protected region % [Set displayName for Accident Cause here] off begin
				displayName: 'Accident Cause',
				// % protected region % [Set displayName for Accident Cause here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Accident Cause here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Accident Cause here] end
				// % protected region % [Set isSensitive for Accident Cause here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Accident Cause here] end
				// % protected region % [Set readonly for Accident Cause here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Accident Cause here] end
				validators: [
					// % protected region % [Add other validators for Accident Cause here] off begin
					// % protected region % [Add other validators for Accident Cause here] end
				],
				// % protected region % [Add any additional model attribute properties for Accident Cause here] off begin
				// % protected region % [Add any additional model attribute properties for Accident Cause here] end
			},
			{
				name: 'emergencyLevel',
				// % protected region % [Set displayName for Emergency Level here] off begin
				displayName: 'Emergency Level',
				// % protected region % [Set displayName for Emergency Level here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Emergency Level here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Emergency Level here] end
				// % protected region % [Set isSensitive for Emergency Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Emergency Level here] end
				// % protected region % [Set readonly for Emergency Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Emergency Level here] end
				validators: [
					// % protected region % [Add other validators for Emergency Level here] off begin
					// % protected region % [Add other validators for Emergency Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Emergency Level here] off begin
				// % protected region % [Add any additional model attribute properties for Emergency Level here] end
			},
			{
				name: 'dateTimeOfInstructions',
				// % protected region % [Set displayName for Date Time of Instructions here] off begin
				displayName: 'Date Time of Instructions',
				// % protected region % [Set displayName for Date Time of Instructions here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Date Time of Instructions here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Date Time of Instructions here] end
				// % protected region % [Set isSensitive for Date Time of Instructions here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date Time of Instructions here] end
				// % protected region % [Set readonly for Date Time of Instructions here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date Time of Instructions here] end
				validators: [
					// % protected region % [Add other validators for Date Time of Instructions here] off begin
					// % protected region % [Add other validators for Date Time of Instructions here] end
				],
				// % protected region % [Add any additional model attribute properties for Date Time of Instructions here] off begin
				// % protected region % [Add any additional model attribute properties for Date Time of Instructions here] end
			},
			{
				name: 'isDoctorTakingOver',
				// % protected region % [Set displayName for Is Doctor Taking Over here] off begin
				displayName: 'Is Doctor Taking Over',
				// % protected region % [Set displayName for Is Doctor Taking Over here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Doctor Taking Over here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Doctor Taking Over here] end
				// % protected region % [Set isSensitive for Is Doctor Taking Over here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Doctor Taking Over here] end
				// % protected region % [Set readonly for Is Doctor Taking Over here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Doctor Taking Over here] end
				validators: [
					// % protected region % [Add other validators for Is Doctor Taking Over here] off begin
					// % protected region % [Add other validators for Is Doctor Taking Over here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Doctor Taking Over here] off begin
				// % protected region % [Add any additional model attribute properties for Is Doctor Taking Over here] end
			},
			{
				name: 'dateTimeOfDrugAdministration',
				// % protected region % [Set displayName for Date Time of Drug Administration here] off begin
				displayName: 'Date Time of Drug Administration',
				// % protected region % [Set displayName for Date Time of Drug Administration here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Date Time of Drug Administration here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Date Time of Drug Administration here] end
				// % protected region % [Set isSensitive for Date Time of Drug Administration here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date Time of Drug Administration here] end
				// % protected region % [Set readonly for Date Time of Drug Administration here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date Time of Drug Administration here] end
				validators: [
					// % protected region % [Add other validators for Date Time of Drug Administration here] off begin
					// % protected region % [Add other validators for Date Time of Drug Administration here] end
				],
				// % protected region % [Add any additional model attribute properties for Date Time of Drug Administration here] off begin
				// % protected region % [Add any additional model attribute properties for Date Time of Drug Administration here] end
			},
			{
				name: 'isAutopay',
				// % protected region % [Set displayName for Is Autopay here] off begin
				displayName: 'Is Autopay',
				// % protected region % [Set displayName for Is Autopay here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is Autopay here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is Autopay here] end
				// % protected region % [Set isSensitive for Is Autopay here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is Autopay here] end
				// % protected region % [Set readonly for Is Autopay here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is Autopay here] end
				validators: [
					// % protected region % [Add other validators for Is Autopay here] off begin
					// % protected region % [Add other validators for Is Autopay here] end
				],
				// % protected region % [Add any additional model attribute properties for Is Autopay here] off begin
				// % protected region % [Add any additional model attribute properties for Is Autopay here] end
			},
			{
				name: 'responseTime',
				// % protected region % [Set displayName for Response Time here] off begin
				displayName: 'Response Time',
				// % protected region % [Set displayName for Response Time here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Response Time here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Response Time here] end
				// % protected region % [Set isSensitive for Response Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Response Time here] end
				// % protected region % [Set readonly for Response Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Response Time here] end
				validators: [
					// % protected region % [Add other validators for Response Time here] off begin
					// % protected region % [Add other validators for Response Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Response Time here] off begin
				// % protected region % [Add any additional model attribute properties for Response Time here] end
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
				id: 'medicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'medicalExaminationRecordId',
				// % protected region % [Customise your label for Medical Examination Record here] off begin
				label: 'Medical Examination Record',
				// % protected region % [Customise your label for Medical Examination Record here] end
				entityName: 'MedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Medical Examination Record here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'diastole',
				// % protected region % [Customise your display name for Medical Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Medical Examination Record here] off begin
					// % protected region % [Add other validators for Medical Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Medical Examination Record here] off begin
				// % protected region % [Add any additional field for relation Medical Examination Record here] end
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
				case 'surgicalOrNonSurgical':
					break;
				case 'caseSpecification':
					break;
				case 'accidentType':
					break;
				case 'emergencyLevel':
					break;
				case 'dateTimeOfInstructions':
					break;
				case 'isDoctorTakingOver':
					break;
				case 'dateTimeOfDrugAdministration':
					break;
				case 'isAutopay':
					break;
				case 'responseTime':
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
	static deepParse(data: string | { [K in keyof EmergencyMedicalExaminationRecordModel]?: EmergencyMedicalExaminationRecordModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new EmergencyMedicalExaminationRecordModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let emergencyMedicalExaminationRecordModel = new EmergencyMedicalExaminationRecordModel(data);`
	 *
	 * @param data The input data to be initialised as the EmergencyMedicalExaminationRecordModel,
	 *    it is expected as a JSON string or as a nullable EmergencyMedicalExaminationRecordModel.
	 */
	constructor(data?: string | Partial<EmergencyMedicalExaminationRecordModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<EmergencyMedicalExaminationRecordModel>
				: data;

			this.surgicalOrNonSurgical = json.surgicalOrNonSurgical;
			this.caseSpecification = json.caseSpecification;
			this.accidentType = json.accidentType;
			this.accidentCause = json.accidentCause;
			this.emergencyLevel = json.emergencyLevel;
			if (json.dateTimeOfInstructions) {
				this.dateTimeOfInstructions = new Date(json.dateTimeOfInstructions);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dateTimeOfInstructions = json.dateTimeOfInstructions;
			}
			this.isDoctorTakingOver = json.isDoctorTakingOver;
			if (json.dateTimeOfDrugAdministration) {
				this.dateTimeOfDrugAdministration = new Date(json.dateTimeOfDrugAdministration);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dateTimeOfDrugAdministration = json.dateTimeOfDrugAdministration;
			}
			this.isAutopay = json.isAutopay;
			this.responseTime = json.responseTime;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			surgicalOrNonSurgical: this.surgicalOrNonSurgical,
			caseSpecification: this.caseSpecification,
			accidentType: this.accidentType,
			accidentCause: this.accidentCause,
			emergencyLevel: this.emergencyLevel,
			dateTimeOfInstructions: this.dateTimeOfInstructions,
			isDoctorTakingOver: this.isDoctorTakingOver,
			dateTimeOfDrugAdministration: this.dateTimeOfDrugAdministration,
			isAutopay: this.isAutopay,
			responseTime: this.responseTime,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		EmergencyMedicalExaminationRecordModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): EmergencyMedicalExaminationRecordModel {
		let newModelJson = this.toJSON();

		if (updates.surgicalOrNonSurgical) {
			newModelJson.surgicalOrNonSurgical = updates.surgicalOrNonSurgical;
		}

		if (updates.caseSpecification) {
			newModelJson.caseSpecification = updates.caseSpecification;
		}

		if (updates.accidentType) {
			newModelJson.accidentType = updates.accidentType;
		}

		if (updates.accidentCause) {
			newModelJson.accidentCause = updates.accidentCause;
		}

		if (updates.emergencyLevel) {
			newModelJson.emergencyLevel = updates.emergencyLevel;
		}

		if (updates.dateTimeOfInstructions) {
			newModelJson.dateTimeOfInstructions = updates.dateTimeOfInstructions;
		}

		if (updates.isDoctorTakingOver) {
			newModelJson.isDoctorTakingOver = updates.isDoctorTakingOver;
		}

		if (updates.dateTimeOfDrugAdministration) {
			newModelJson.dateTimeOfDrugAdministration = updates.dateTimeOfDrugAdministration;
		}

		if (updates.isAutopay) {
			newModelJson.isAutopay = updates.isAutopay;
		}

		if (updates.responseTime) {
			newModelJson.responseTime = updates.responseTime;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		return new EmergencyMedicalExaminationRecordModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof EmergencyMedicalExaminationRecordModel)) {
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
			'medicalExaminationRecordId',
			'medicalExaminationRecord',
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
		if (!this.medicalExaminationRecord) {
			this.medicalExaminationRecordId = null;
		} else {
			this.medicalExaminationRecordId = this.medicalExaminationRecord.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
