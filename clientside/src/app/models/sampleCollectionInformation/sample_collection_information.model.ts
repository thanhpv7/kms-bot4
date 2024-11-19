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
import {DiagnosisExaminationRecordModel} from '../diagnosisExaminationRecord/diagnosis_examination_record.model';
import {RegistrationModel} from '../registration/registration.model';
import {SampleCollectionItemsModel} from '../sampleCollectionItems/sample_collection_items.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class SampleCollectionInformationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'patientInformed',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'patientInformed',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'SampleCollectionInformationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return SampleCollectionInformationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Patient Informed.
	 */
	patientInformed: boolean = false;

	/**
	 * Patient Consented.
	 */
	patientConsented: boolean = false;

	/**
	 * Patient Fasted Enough.
	 */
	patientFastedEnough: boolean = false;

	/**
	 * Medication Taken In 24 Hours.
	 */
	medicationTakenIn24Hours: boolean = false;

	/**
	 * Medication Taken In 72 Hours.
	 */
	medicationTakenIn72Hours: boolean = false;

	diagnosisExaminationRecordId: string;

	diagnosisExaminationRecord: DiagnosisExaminationRecordModel;

	registrationId: string;

	registration: RegistrationModel;

	sampleCollectionItemsIds: string[] = [];

	sampleCollectionItems: SampleCollectionItemsModel[];

	modelPropGroups: { [s: string]: Group } = SampleCollectionInformationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'patientInformed',
				// % protected region % [Set displayName for Patient Informed here] off begin
				displayName: 'Patient Informed',
				// % protected region % [Set displayName for Patient Informed here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Patient Informed here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Patient Informed here] end
				// % protected region % [Set isSensitive for Patient Informed here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Informed here] end
				// % protected region % [Set readonly for Patient Informed here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Informed here] end
				validators: [
					// % protected region % [Add other validators for Patient Informed here] off begin
					// % protected region % [Add other validators for Patient Informed here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Informed here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Informed here] end
			},
			{
				name: 'patientConsented',
				// % protected region % [Set displayName for Patient Consented here] off begin
				displayName: 'Patient Consented',
				// % protected region % [Set displayName for Patient Consented here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Patient Consented here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Patient Consented here] end
				// % protected region % [Set isSensitive for Patient Consented here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Consented here] end
				// % protected region % [Set readonly for Patient Consented here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Consented here] end
				validators: [
					// % protected region % [Add other validators for Patient Consented here] off begin
					// % protected region % [Add other validators for Patient Consented here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Consented here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Consented here] end
			},
			{
				name: 'patientFastedEnough',
				// % protected region % [Set displayName for Patient Fasted Enough here] off begin
				displayName: 'Patient Fasted Enough',
				// % protected region % [Set displayName for Patient Fasted Enough here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Patient Fasted Enough here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Patient Fasted Enough here] end
				// % protected region % [Set isSensitive for Patient Fasted Enough here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Fasted Enough here] end
				// % protected region % [Set readonly for Patient Fasted Enough here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Fasted Enough here] end
				validators: [
					// % protected region % [Add other validators for Patient Fasted Enough here] off begin
					// % protected region % [Add other validators for Patient Fasted Enough here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Fasted Enough here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Fasted Enough here] end
			},
			{
				name: 'medicationTakenIn24Hours',
				// % protected region % [Set displayName for Medication Taken In 24 Hours here] off begin
				displayName: 'Medication Taken In 24 Hours',
				// % protected region % [Set displayName for Medication Taken In 24 Hours here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Medication Taken In 24 Hours here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Medication Taken In 24 Hours here] end
				// % protected region % [Set isSensitive for Medication Taken In 24 Hours here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medication Taken In 24 Hours here] end
				// % protected region % [Set readonly for Medication Taken In 24 Hours here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medication Taken In 24 Hours here] end
				validators: [
					// % protected region % [Add other validators for Medication Taken In 24 Hours here] off begin
					// % protected region % [Add other validators for Medication Taken In 24 Hours here] end
				],
				// % protected region % [Add any additional model attribute properties for Medication Taken In 24 Hours here] off begin
				// % protected region % [Add any additional model attribute properties for Medication Taken In 24 Hours here] end
			},
			{
				name: 'medicationTakenIn72Hours',
				// % protected region % [Set displayName for Medication Taken In 72 Hours here] off begin
				displayName: 'Medication Taken In 72 Hours',
				// % protected region % [Set displayName for Medication Taken In 72 Hours here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Medication Taken In 72 Hours here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Medication Taken In 72 Hours here] end
				// % protected region % [Set isSensitive for Medication Taken In 72 Hours here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Medication Taken In 72 Hours here] end
				// % protected region % [Set readonly for Medication Taken In 72 Hours here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Medication Taken In 72 Hours here] end
				validators: [
					// % protected region % [Add other validators for Medication Taken In 72 Hours here] off begin
					// % protected region % [Add other validators for Medication Taken In 72 Hours here] end
				],
				// % protected region % [Add any additional model attribute properties for Medication Taken In 72 Hours here] off begin
				// % protected region % [Add any additional model attribute properties for Medication Taken In 72 Hours here] end
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
				id: 'sampleCollectionItems',
				type: ModelRelationType.MANY,
				name: 'sampleCollectionItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Collection Items here] off begin
				label: 'Sample Collection Items',
				// % protected region % [Customise your 1-1 or 1-M label for Sample Collection Items here] end
				entityName: 'SampleCollectionItemsModel',
				// % protected region % [Customise your display name for Sample Collection Items here] off begin
				displayName: 'sampleType',
				// % protected region % [Customise your display name for Sample Collection Items here] end
				validators: [
					// % protected region % [Add other validators for Sample Collection Items here] off begin
					// % protected region % [Add other validators for Sample Collection Items here] end
				],
				// % protected region % [Add any additional field for relation Sample Collection Items here] off begin
				// % protected region % [Add any additional field for relation Sample Collection Items here] end
			},
			{
				id: 'diagnosisExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'diagnosisExaminationRecordId',
				// % protected region % [Customise your label for Diagnosis Examination Record here] off begin
				label: 'Diagnosis Examination Record',
				// % protected region % [Customise your label for Diagnosis Examination Record here] end
				entityName: 'DiagnosisExaminationRecordModel',
				// % protected region % [Customise your display name for Diagnosis Examination Record here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'diagnosisSequence',
				// % protected region % [Customise your display name for Diagnosis Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Diagnosis Examination Record here] off begin
					// % protected region % [Add other validators for Diagnosis Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Diagnosis Examination Record here] off begin
				// % protected region % [Add any additional field for relation Diagnosis Examination Record here] end
			},
			{
				id: 'registration',
				type: ModelRelationType.ONE,
				name: 'registrationId',
				// % protected region % [Customise your label for Registration here] off begin
				label: 'Registration',
				// % protected region % [Customise your label for Registration here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registration here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registration here] end
				validators: [
					// % protected region % [Add other validators for Registration here] off begin
					// % protected region % [Add other validators for Registration here] end
				],
				// % protected region % [Add any additional field for relation Registration here] off begin
				// % protected region % [Add any additional field for relation Registration here] end
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
				case 'patientInformed':
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
	static deepParse(data: string | { [K in keyof SampleCollectionInformationModel]?: SampleCollectionInformationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new SampleCollectionInformationModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.diagnosisExaminationRecord) {
			currentModel.diagnosisExaminationRecordId = json.diagnosisExaminationRecord.id;
			returned = _.union(returned, DiagnosisExaminationRecordModel.deepParse(json.diagnosisExaminationRecord));
		}

		// Incoming one to many
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

		// Outgoing one to many
		if (json.sampleCollectionItems) {
			currentModel.sampleCollectionItemsIds = json.sampleCollectionItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.sampleCollectionItems.map(model => SampleCollectionItemsModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let sampleCollectionInformationModel = new SampleCollectionInformationModel(data);`
	 *
	 * @param data The input data to be initialised as the SampleCollectionInformationModel,
	 *    it is expected as a JSON string or as a nullable SampleCollectionInformationModel.
	 */
	constructor(data?: string | Partial<SampleCollectionInformationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<SampleCollectionInformationModel>
				: data;

			this.patientInformed = json.patientInformed;
			this.patientConsented = json.patientConsented;
			this.patientFastedEnough = json.patientFastedEnough;
			this.medicationTakenIn24Hours = json.medicationTakenIn24Hours;
			this.medicationTakenIn72Hours = json.medicationTakenIn72Hours;
			this.diagnosisExaminationRecordId = json.diagnosisExaminationRecordId;
			this.diagnosisExaminationRecord = json.diagnosisExaminationRecord;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
			this.sampleCollectionItemsIds = json.sampleCollectionItemsIds;
			this.sampleCollectionItems = json.sampleCollectionItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			patientInformed: this.patientInformed,
			patientConsented: this.patientConsented,
			patientFastedEnough: this.patientFastedEnough,
			medicationTakenIn24Hours: this.medicationTakenIn24Hours,
			medicationTakenIn72Hours: this.medicationTakenIn72Hours,
			diagnosisExaminationRecordId: this.diagnosisExaminationRecordId,
			registrationId: this.registrationId,
			sampleCollectionItemsIds: this.sampleCollectionItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		SampleCollectionInformationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): SampleCollectionInformationModel {
		let newModelJson = this.toJSON();

		if (updates.patientInformed) {
			newModelJson.patientInformed = updates.patientInformed;
		}

		if (updates.patientConsented) {
			newModelJson.patientConsented = updates.patientConsented;
		}

		if (updates.patientFastedEnough) {
			newModelJson.patientFastedEnough = updates.patientFastedEnough;
		}

		if (updates.medicationTakenIn24Hours) {
			newModelJson.medicationTakenIn24Hours = updates.medicationTakenIn24Hours;
		}

		if (updates.medicationTakenIn72Hours) {
			newModelJson.medicationTakenIn72Hours = updates.medicationTakenIn72Hours;
		}

		if (updates.diagnosisExaminationRecordId) {
			newModelJson.diagnosisExaminationRecordId = updates.diagnosisExaminationRecordId;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.sampleCollectionItemsIds) {
			newModelJson.sampleCollectionItemsIds = updates.sampleCollectionItemsIds;
		}

		return new SampleCollectionInformationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof SampleCollectionInformationModel)) {
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
			'diagnosisExaminationRecordId',
			'diagnosisExaminationRecord',
			'registrationId',
			'registration',
			'sampleCollectionItemsIds',
			'sampleCollectionItems',
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
		if (!this.diagnosisExaminationRecord) {
			this.diagnosisExaminationRecordId = null;
		} else {
			this.diagnosisExaminationRecordId = this.diagnosisExaminationRecord.id;
		}

		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
