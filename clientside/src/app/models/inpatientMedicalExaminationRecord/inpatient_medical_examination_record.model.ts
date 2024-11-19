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
import {BedFacilityModel} from '../bedFacility/bed_facility.model';
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
export class InpatientMedicalExaminationRecordModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'startDateTime',
		'endDateTime',
		'treatmentClass',
		'inpatientCase',
		'serviceCase',
		'dependencyLevel',
		'currentDependency',
		'infantCondition',
		'neonatalCase',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'startDateTime',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'InpatientMedicalExaminationRecordModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return InpatientMedicalExaminationRecordModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	startDateTime: Date;

	/**
	 * .
	 */
	endDateTime: Date;

	/**
	 * .
	 */
	treatmentClass: string;

	/**
	 * .
	 */
	inpatientCase: string;

	/**
	 * .
	 */
	serviceCase: string;

	/**
	 * Dependency Level Upon Admission.
	 */
	dependencyLevel: string;

	/**
	 * Current Dependency Level.
	 */
	currentDependency: string;

	/**
	 * .
	 */
	infantCondition: string;

	/**
	 * .
	 */
	neonatalCase: string;

	medicalExaminationRecordId: string;

	medicalExaminationRecord: MedicalExaminationRecordModel;

	bedFacilityId: string;

	bedFacility: BedFacilityModel;

	modelPropGroups: { [s: string]: Group } = InpatientMedicalExaminationRecordModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'startDateTime',
				// % protected region % [Set displayName for Start Date Time here] off begin
				displayName: 'Start Date Time',
				// % protected region % [Set displayName for Start Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Start Date Time here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Start Date Time here] end
				// % protected region % [Set isSensitive for Start Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Start Date Time here] end
				// % protected region % [Set readonly for Start Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Start Date Time here] end
				validators: [
					// % protected region % [Add other validators for Start Date Time here] off begin
					// % protected region % [Add other validators for Start Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Start Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Start Date Time here] end
			},
			{
				name: 'endDateTime',
				// % protected region % [Set displayName for End Date Time here] off begin
				displayName: 'End Date Time',
				// % protected region % [Set displayName for End Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for End Date Time here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for End Date Time here] end
				// % protected region % [Set isSensitive for End Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for End Date Time here] end
				// % protected region % [Set readonly for End Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for End Date Time here] end
				validators: [
					// % protected region % [Add other validators for End Date Time here] off begin
					// % protected region % [Add other validators for End Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for End Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for End Date Time here] end
			},
			{
				name: 'treatmentClass',
				// % protected region % [Set displayName for Treatment Class here] off begin
				displayName: 'Treatment Class',
				// % protected region % [Set displayName for Treatment Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Class here] end
				// % protected region % [Set isSensitive for Treatment Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Class here] end
				// % protected region % [Set readonly for Treatment Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Class here] end
				validators: [
					// % protected region % [Add other validators for Treatment Class here] off begin
					// % protected region % [Add other validators for Treatment Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Class here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Class here] end
			},
			{
				name: 'inpatientCase',
				// % protected region % [Set displayName for Inpatient Case here] off begin
				displayName: 'Inpatient Case',
				// % protected region % [Set displayName for Inpatient Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Inpatient Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Inpatient Case here] end
				// % protected region % [Set isSensitive for Inpatient Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inpatient Case here] end
				// % protected region % [Set readonly for Inpatient Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inpatient Case here] end
				validators: [
					// % protected region % [Add other validators for Inpatient Case here] off begin
					// % protected region % [Add other validators for Inpatient Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Inpatient Case here] off begin
				// % protected region % [Add any additional model attribute properties for Inpatient Case here] end
			},
			{
				name: 'serviceCase',
				// % protected region % [Set displayName for Service Case here] off begin
				displayName: 'Service Case',
				// % protected region % [Set displayName for Service Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Service Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Service Case here] end
				// % protected region % [Set isSensitive for Service Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Service Case here] end
				// % protected region % [Set readonly for Service Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Service Case here] end
				validators: [
					// % protected region % [Add other validators for Service Case here] off begin
					// % protected region % [Add other validators for Service Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Service Case here] off begin
				// % protected region % [Add any additional model attribute properties for Service Case here] end
			},
			{
				name: 'dependencyLevel',
				// % protected region % [Set displayName for Dependency Level here] off begin
				displayName: 'Dependency Level',
				// % protected region % [Set displayName for Dependency Level here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dependency Level here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dependency Level here] end
				// % protected region % [Set isSensitive for Dependency Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dependency Level here] end
				// % protected region % [Set readonly for Dependency Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dependency Level here] end
				validators: [
					// % protected region % [Add other validators for Dependency Level here] off begin
					// % protected region % [Add other validators for Dependency Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Dependency Level here] off begin
				// % protected region % [Add any additional model attribute properties for Dependency Level here] end
			},
			{
				name: 'currentDependency',
				// % protected region % [Set displayName for Current Dependency here] off begin
				displayName: 'Current Dependency',
				// % protected region % [Set displayName for Current Dependency here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Current Dependency here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Current Dependency here] end
				// % protected region % [Set isSensitive for Current Dependency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Current Dependency here] end
				// % protected region % [Set readonly for Current Dependency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Current Dependency here] end
				validators: [
					// % protected region % [Add other validators for Current Dependency here] off begin
					// % protected region % [Add other validators for Current Dependency here] end
				],
				// % protected region % [Add any additional model attribute properties for Current Dependency here] off begin
				// % protected region % [Add any additional model attribute properties for Current Dependency here] end
			},
			{
				name: 'infantCondition',
				// % protected region % [Set displayName for Infant Condition here] off begin
				displayName: 'Infant Condition',
				// % protected region % [Set displayName for Infant Condition here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Infant Condition here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Infant Condition here] end
				// % protected region % [Set isSensitive for Infant Condition here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Infant Condition here] end
				// % protected region % [Set readonly for Infant Condition here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Infant Condition here] end
				validators: [
					// % protected region % [Add other validators for Infant Condition here] off begin
					// % protected region % [Add other validators for Infant Condition here] end
				],
				// % protected region % [Add any additional model attribute properties for Infant Condition here] off begin
				// % protected region % [Add any additional model attribute properties for Infant Condition here] end
			},
			{
				name: 'neonatalCase',
				// % protected region % [Set displayName for Neonatal Case here] off begin
				displayName: 'Neonatal Case',
				// % protected region % [Set displayName for Neonatal Case here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Neonatal Case here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Neonatal Case here] end
				// % protected region % [Set isSensitive for Neonatal Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Neonatal Case here] end
				// % protected region % [Set readonly for Neonatal Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Neonatal Case here] end
				validators: [
					// % protected region % [Add other validators for Neonatal Case here] off begin
					// % protected region % [Add other validators for Neonatal Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Neonatal Case here] off begin
				// % protected region % [Add any additional model attribute properties for Neonatal Case here] end
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
				// % protected region % [Customise your 1-1 or 1-M label for Medical Examination Record here] off begin
				label: 'Medical Examination Record',
				// % protected region % [Customise your 1-1 or 1-M label for Medical Examination Record here] end
				entityName: 'MedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Medical Examination Record here] off begin
				displayName: 'diastole',
				// % protected region % [Customise your display name for Medical Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Medical Examination Record here] off begin
					// % protected region % [Add other validators for Medical Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Medical Examination Record here] off begin
				// % protected region % [Add any additional field for relation Medical Examination Record here] end
			},
			{
				id: 'bedFacility',
				type: ModelRelationType.ONE,
				name: 'bedFacilityId',
				// % protected region % [Customise your label for Bed Facility here] off begin
				label: 'Bed Facility',
				// % protected region % [Customise your label for Bed Facility here] end
				entityName: 'BedFacilityModel',
				// % protected region % [Customise your display name for Bed Facility here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'bedNumber',
				// % protected region % [Customise your display name for Bed Facility here] end
				validators: [
					// % protected region % [Add other validators for Bed Facility here] off begin
					// % protected region % [Add other validators for Bed Facility here] end
				],
				// % protected region % [Add any additional field for relation Bed Facility here] off begin
				// % protected region % [Add any additional field for relation Bed Facility here] end
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
				case 'startDateTime':
					break;
				case 'endDateTime':
					break;
				case 'treatmentClass':
					break;
				case 'inpatientCase':
					break;
				case 'serviceCase':
					break;
				case 'dependencyLevel':
					break;
				case 'currentDependency':
					break;
				case 'infantCondition':
					break;
				case 'neonatalCase':
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
	static deepParse(data: string | { [K in keyof InpatientMedicalExaminationRecordModel]?: InpatientMedicalExaminationRecordModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new InpatientMedicalExaminationRecordModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.medicalExaminationRecord) {
			currentModel.medicalExaminationRecordId = json.medicalExaminationRecord.id;
			returned = _.union(returned, MedicalExaminationRecordModel.deepParse(json.medicalExaminationRecord));
		}

		// Incoming one to many
		if (json.bedFacility) {
			currentModel.bedFacilityId = json.bedFacility.id;
			returned = _.union(returned, BedFacilityModel.deepParse(json.bedFacility));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let inpatientMedicalExaminationRecordModel = new InpatientMedicalExaminationRecordModel(data);`
	 *
	 * @param data The input data to be initialised as the InpatientMedicalExaminationRecordModel,
	 *    it is expected as a JSON string or as a nullable InpatientMedicalExaminationRecordModel.
	 */
	constructor(data?: string | Partial<InpatientMedicalExaminationRecordModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<InpatientMedicalExaminationRecordModel>
				: data;

			if (json.startDateTime) {
				this.startDateTime = new Date(json.startDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.startDateTime = json.startDateTime;
			}
			if (json.endDateTime) {
				this.endDateTime = new Date(json.endDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.endDateTime = json.endDateTime;
			}
			this.treatmentClass = json.treatmentClass;
			this.inpatientCase = json.inpatientCase;
			this.serviceCase = json.serviceCase;
			this.dependencyLevel = json.dependencyLevel;
			this.currentDependency = json.currentDependency;
			this.infantCondition = json.infantCondition;
			this.neonatalCase = json.neonatalCase;
			this.medicalExaminationRecordId = json.medicalExaminationRecordId;
			this.medicalExaminationRecord = json.medicalExaminationRecord;
			this.bedFacilityId = json.bedFacilityId;
			this.bedFacility = json.bedFacility;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			startDateTime: this.startDateTime,
			endDateTime: this.endDateTime,
			treatmentClass: this.treatmentClass,
			inpatientCase: this.inpatientCase,
			serviceCase: this.serviceCase,
			dependencyLevel: this.dependencyLevel,
			currentDependency: this.currentDependency,
			infantCondition: this.infantCondition,
			neonatalCase: this.neonatalCase,
			medicalExaminationRecordId: this.medicalExaminationRecordId,
			bedFacilityId: this.bedFacilityId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		InpatientMedicalExaminationRecordModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): InpatientMedicalExaminationRecordModel {
		let newModelJson = this.toJSON();

		if (updates.startDateTime) {
			newModelJson.startDateTime = updates.startDateTime;
		}

		if (updates.endDateTime) {
			newModelJson.endDateTime = updates.endDateTime;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.inpatientCase) {
			newModelJson.inpatientCase = updates.inpatientCase;
		}

		if (updates.serviceCase) {
			newModelJson.serviceCase = updates.serviceCase;
		}

		if (updates.dependencyLevel) {
			newModelJson.dependencyLevel = updates.dependencyLevel;
		}

		if (updates.currentDependency) {
			newModelJson.currentDependency = updates.currentDependency;
		}

		if (updates.infantCondition) {
			newModelJson.infantCondition = updates.infantCondition;
		}

		if (updates.neonatalCase) {
			newModelJson.neonatalCase = updates.neonatalCase;
		}

		if (updates.medicalExaminationRecordId) {
			newModelJson.medicalExaminationRecordId = updates.medicalExaminationRecordId;
		}

		if (updates.bedFacilityId) {
			newModelJson.bedFacilityId = updates.bedFacilityId;
		}

		return new InpatientMedicalExaminationRecordModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof InpatientMedicalExaminationRecordModel)) {
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
			'bedFacilityId',
			'bedFacility',
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

		if (!this.bedFacility) {
			this.bedFacilityId = null;
		} else {
			this.bedFacilityId = this.bedFacility.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
