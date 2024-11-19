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
import {PatientGeneralInfoModel} from '../patientGeneralInfo/patient_general_info.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class PatientCaseHistoryModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'allergy',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PatientCaseHistoryModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PatientCaseHistoryModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Allergy history (Max Length: 500).
	 */
	allergy: string;

	/**
	 * History of Disability Notes (Max Length: 500).
	 */
	disabilityNotes: string;

	/**
	 * History of Disease (Max Length: 500).
	 */
	historyOfDisease: string;

	/**
	 * Date when the patient case is recorded.
	 */
	caseHistoryDateTime: Date;

	/**
	 * History of Patient habits (Max Length: 500).
	 */
	patientHabits: string;

	/**
	 * History of patient Nutrition (Max Length: 500).
	 */
	nutritionHIstory: string;

	/**
	 * History of patient family (Max Length: 500).
	 */
	familyHistory: string;

	patientGeneralInformationId: string;

	patientGeneralInformation: PatientGeneralInfoModel;

	modelPropGroups: { [s: string]: Group } = PatientCaseHistoryModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'allergy',
				// % protected region % [Set displayName for Allergy here] off begin
				displayName: 'Allergy',
				// % protected region % [Set displayName for Allergy here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Allergy here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Allergy here] end
				// % protected region % [Set isSensitive for Allergy here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Allergy here] end
				// % protected region % [Set readonly for Allergy here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Allergy here] end
				validators: [
					// % protected region % [Add other validators for Allergy here] off begin
					// % protected region % [Add other validators for Allergy here] end
				],
				// % protected region % [Add any additional model attribute properties for Allergy here] off begin
				// % protected region % [Add any additional model attribute properties for Allergy here] end
			},
			{
				name: 'disabilityNotes',
				// % protected region % [Set displayName for Disability Notes here] off begin
				displayName: 'Disability Notes',
				// % protected region % [Set displayName for Disability Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Disability Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Disability Notes here] end
				// % protected region % [Set isSensitive for Disability Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Disability Notes here] end
				// % protected region % [Set readonly for Disability Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Disability Notes here] end
				validators: [
					// % protected region % [Add other validators for Disability Notes here] off begin
					// % protected region % [Add other validators for Disability Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Disability Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Disability Notes here] end
			},
			{
				name: 'historyOfDisease',
				// % protected region % [Set displayName for History of Disease here] off begin
				displayName: 'History of Disease',
				// % protected region % [Set displayName for History of Disease here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for History of Disease here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for History of Disease here] end
				// % protected region % [Set isSensitive for History of Disease here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for History of Disease here] end
				// % protected region % [Set readonly for History of Disease here] off begin
				readOnly: false,
				// % protected region % [Set readonly for History of Disease here] end
				validators: [
					// % protected region % [Add other validators for History of Disease here] off begin
					// % protected region % [Add other validators for History of Disease here] end
				],
				// % protected region % [Add any additional model attribute properties for History of Disease here] off begin
				// % protected region % [Add any additional model attribute properties for History of Disease here] end
			},
			{
				name: 'caseHistoryDateTime',
				// % protected region % [Set displayName for Case History Date Time here] off begin
				displayName: 'Case History Date Time',
				// % protected region % [Set displayName for Case History Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Case History Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Case History Date Time here] end
				// % protected region % [Set isSensitive for Case History Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Case History Date Time here] end
				// % protected region % [Set readonly for Case History Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Case History Date Time here] end
				validators: [
					// % protected region % [Add other validators for Case History Date Time here] off begin
					// % protected region % [Add other validators for Case History Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Case History Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Case History Date Time here] end
			},
			{
				name: 'patientHabits',
				// % protected region % [Set displayName for Patient Habits here] off begin
				displayName: 'Patient Habits',
				// % protected region % [Set displayName for Patient Habits here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Patient Habits here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Patient Habits here] end
				// % protected region % [Set isSensitive for Patient Habits here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Patient Habits here] end
				// % protected region % [Set readonly for Patient Habits here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Patient Habits here] end
				validators: [
					// % protected region % [Add other validators for Patient Habits here] off begin
					// % protected region % [Add other validators for Patient Habits here] end
				],
				// % protected region % [Add any additional model attribute properties for Patient Habits here] off begin
				// % protected region % [Add any additional model attribute properties for Patient Habits here] end
			},
			{
				name: 'nutritionHIstory',
				// % protected region % [Set displayName for Nutrition HIstory here] off begin
				displayName: 'Nutrition HIstory',
				// % protected region % [Set displayName for Nutrition HIstory here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nutrition HIstory here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nutrition HIstory here] end
				// % protected region % [Set isSensitive for Nutrition HIstory here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nutrition HIstory here] end
				// % protected region % [Set readonly for Nutrition HIstory here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nutrition HIstory here] end
				validators: [
					// % protected region % [Add other validators for Nutrition HIstory here] off begin
					// % protected region % [Add other validators for Nutrition HIstory here] end
				],
				// % protected region % [Add any additional model attribute properties for Nutrition HIstory here] off begin
				// % protected region % [Add any additional model attribute properties for Nutrition HIstory here] end
			},
			{
				name: 'familyHistory',
				// % protected region % [Set displayName for Family History here] off begin
				displayName: 'Family History',
				// % protected region % [Set displayName for Family History here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Family History here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Family History here] end
				// % protected region % [Set isSensitive for Family History here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Family History here] end
				// % protected region % [Set readonly for Family History here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Family History here] end
				validators: [
					// % protected region % [Add other validators for Family History here] off begin
					// % protected region % [Add other validators for Family History here] end
				],
				// % protected region % [Add any additional model attribute properties for Family History here] off begin
				// % protected region % [Add any additional model attribute properties for Family History here] end
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
				id: 'patientGeneralInformation',
				type: ModelRelationType.ONE,
				name: 'patientGeneralInformationId',
				// % protected region % [Customise your label for Patient General Information here] off begin
				label: 'Patient General Information',
				// % protected region % [Customise your label for Patient General Information here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient General Information here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient General Information here] end
				validators: [
					// % protected region % [Add other validators for Patient General Information here] off begin
					// % protected region % [Add other validators for Patient General Information here] end
				],
				// % protected region % [Add any additional field for relation Patient General Information here] off begin
				// % protected region % [Add any additional field for relation Patient General Information here] end
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
	static deepParse(data: string | { [K in keyof PatientCaseHistoryModel]?: PatientCaseHistoryModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PatientCaseHistoryModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.patientGeneralInformation) {
			currentModel.patientGeneralInformationId = json.patientGeneralInformation.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInformation));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let patientCaseHistoryModel = new PatientCaseHistoryModel(data);`
	 *
	 * @param data The input data to be initialised as the PatientCaseHistoryModel,
	 *    it is expected as a JSON string or as a nullable PatientCaseHistoryModel.
	 */
	constructor(data?: string | Partial<PatientCaseHistoryModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PatientCaseHistoryModel>
				: data;

			this.allergy = json.allergy;
			this.disabilityNotes = json.disabilityNotes;
			this.historyOfDisease = json.historyOfDisease;
			if (json.caseHistoryDateTime) {
				this.caseHistoryDateTime = new Date(json.caseHistoryDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.caseHistoryDateTime = json.caseHistoryDateTime;
			}
			this.patientHabits = json.patientHabits;
			this.nutritionHIstory = json.nutritionHIstory;
			this.familyHistory = json.familyHistory;
			this.patientGeneralInformationId = json.patientGeneralInformationId;
			this.patientGeneralInformation = json.patientGeneralInformation;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			allergy: this.allergy,
			disabilityNotes: this.disabilityNotes,
			historyOfDisease: this.historyOfDisease,
			caseHistoryDateTime: this.caseHistoryDateTime,
			patientHabits: this.patientHabits,
			nutritionHIstory: this.nutritionHIstory,
			familyHistory: this.familyHistory,
			patientGeneralInformationId: this.patientGeneralInformationId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PatientCaseHistoryModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PatientCaseHistoryModel {
		let newModelJson = this.toJSON();

		if (updates.allergy) {
			newModelJson.allergy = updates.allergy;
		}

		if (updates.disabilityNotes) {
			newModelJson.disabilityNotes = updates.disabilityNotes;
		}

		if (updates.historyOfDisease) {
			newModelJson.historyOfDisease = updates.historyOfDisease;
		}

		if (updates.caseHistoryDateTime) {
			newModelJson.caseHistoryDateTime = updates.caseHistoryDateTime;
		}

		if (updates.patientHabits) {
			newModelJson.patientHabits = updates.patientHabits;
		}

		if (updates.nutritionHIstory) {
			newModelJson.nutritionHIstory = updates.nutritionHIstory;
		}

		if (updates.familyHistory) {
			newModelJson.familyHistory = updates.familyHistory;
		}

		if (updates.patientGeneralInformationId) {
			newModelJson.patientGeneralInformationId = updates.patientGeneralInformationId;
		}

		return new PatientCaseHistoryModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PatientCaseHistoryModel)) {
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
			'patientGeneralInformationId',
			'patientGeneralInformation',
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
		if (!this.patientGeneralInformation) {
			this.patientGeneralInformationId = null;
		} else {
			this.patientGeneralInformationId = this.patientGeneralInformation.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
