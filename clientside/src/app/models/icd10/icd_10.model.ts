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
import {DiagnosesAndProceduresModel} from '../diagnosesAndProcedures/diagnoses_and_procedures.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class Icd10Model extends AbstractModel {
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
		'classificationDisease',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'Icd10Model';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return Icd10Model.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Classification Disease.
	 */
	classificationDisease: boolean = false;

	/**
	 * Classification Infectious.
	 */
	classificationInfectious: boolean = false;

	/**
	 * Classification Chronic.
	 */
	classificationChronic: boolean = false;

	/**
	 * Classification Top Disease.
	 */
	classificationTopDisease: boolean = false;

	/**
	 * Classification Restricted Case.
	 */
	classificationRestrictedCase: boolean = false;

	/**
	 * Classification Reportable Case.
	 */
	classificationReportableCase: boolean = false;

	/**
	 * .
	 */
	classificationAcute: boolean = false;

	/**
	 * Dismissal Date or Actual Date Out.
	 */
	dismissalDate: Date;

	diagnosesAndProceduresId: string;

	diagnosesAndProcedures: DiagnosesAndProceduresModel;

	modelPropGroups: { [s: string]: Group } = Icd10Model.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'classificationDisease',
				// % protected region % [Set displayName for Classification Disease here] off begin
				displayName: 'Classification Disease',
				// % protected region % [Set displayName for Classification Disease here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Classification Disease here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Classification Disease here] end
				// % protected region % [Set isSensitive for Classification Disease here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Classification Disease here] end
				// % protected region % [Set readonly for Classification Disease here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Classification Disease here] end
				validators: [
					// % protected region % [Add other validators for Classification Disease here] off begin
					// % protected region % [Add other validators for Classification Disease here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification Disease here] off begin
				// % protected region % [Add any additional model attribute properties for Classification Disease here] end
			},
			{
				name: 'classificationInfectious',
				// % protected region % [Set displayName for Classification Infectious here] off begin
				displayName: 'Classification Infectious',
				// % protected region % [Set displayName for Classification Infectious here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Classification Infectious here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Classification Infectious here] end
				// % protected region % [Set isSensitive for Classification Infectious here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Classification Infectious here] end
				// % protected region % [Set readonly for Classification Infectious here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Classification Infectious here] end
				validators: [
					// % protected region % [Add other validators for Classification Infectious here] off begin
					// % protected region % [Add other validators for Classification Infectious here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification Infectious here] off begin
				// % protected region % [Add any additional model attribute properties for Classification Infectious here] end
			},
			{
				name: 'classificationChronic',
				// % protected region % [Set displayName for Classification Chronic here] off begin
				displayName: 'Classification Chronic',
				// % protected region % [Set displayName for Classification Chronic here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Classification Chronic here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Classification Chronic here] end
				// % protected region % [Set isSensitive for Classification Chronic here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Classification Chronic here] end
				// % protected region % [Set readonly for Classification Chronic here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Classification Chronic here] end
				validators: [
					// % protected region % [Add other validators for Classification Chronic here] off begin
					// % protected region % [Add other validators for Classification Chronic here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification Chronic here] off begin
				// % protected region % [Add any additional model attribute properties for Classification Chronic here] end
			},
			{
				name: 'classificationTopDisease',
				// % protected region % [Set displayName for Classification Top Disease here] off begin
				displayName: 'Classification Top Disease',
				// % protected region % [Set displayName for Classification Top Disease here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Classification Top Disease here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Classification Top Disease here] end
				// % protected region % [Set isSensitive for Classification Top Disease here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Classification Top Disease here] end
				// % protected region % [Set readonly for Classification Top Disease here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Classification Top Disease here] end
				validators: [
					// % protected region % [Add other validators for Classification Top Disease here] off begin
					// % protected region % [Add other validators for Classification Top Disease here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification Top Disease here] off begin
				// % protected region % [Add any additional model attribute properties for Classification Top Disease here] end
			},
			{
				name: 'classificationRestrictedCase',
				// % protected region % [Set displayName for Classification Restricted Case here] off begin
				displayName: 'Classification Restricted Case',
				// % protected region % [Set displayName for Classification Restricted Case here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Classification Restricted Case here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Classification Restricted Case here] end
				// % protected region % [Set isSensitive for Classification Restricted Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Classification Restricted Case here] end
				// % protected region % [Set readonly for Classification Restricted Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Classification Restricted Case here] end
				validators: [
					// % protected region % [Add other validators for Classification Restricted Case here] off begin
					// % protected region % [Add other validators for Classification Restricted Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification Restricted Case here] off begin
				// % protected region % [Add any additional model attribute properties for Classification Restricted Case here] end
			},
			{
				name: 'classificationReportableCase',
				// % protected region % [Set displayName for Classification Reportable Case here] off begin
				displayName: 'Classification Reportable Case',
				// % protected region % [Set displayName for Classification Reportable Case here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Classification Reportable Case here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Classification Reportable Case here] end
				// % protected region % [Set isSensitive for Classification Reportable Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Classification Reportable Case here] end
				// % protected region % [Set readonly for Classification Reportable Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Classification Reportable Case here] end
				validators: [
					// % protected region % [Add other validators for Classification Reportable Case here] off begin
					// % protected region % [Add other validators for Classification Reportable Case here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification Reportable Case here] off begin
				// % protected region % [Add any additional model attribute properties for Classification Reportable Case here] end
			},
			{
				name: 'classificationAcute',
				// % protected region % [Set displayName for Classification Acute here] off begin
				displayName: 'Classification Acute',
				// % protected region % [Set displayName for Classification Acute here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Classification Acute here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Classification Acute here] end
				// % protected region % [Set isSensitive for Classification Acute here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Classification Acute here] end
				// % protected region % [Set readonly for Classification Acute here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Classification Acute here] end
				validators: [
					// % protected region % [Add other validators for Classification Acute here] off begin
					// % protected region % [Add other validators for Classification Acute here] end
				],
				// % protected region % [Add any additional model attribute properties for Classification Acute here] off begin
				// % protected region % [Add any additional model attribute properties for Classification Acute here] end
			},
			{
				name: 'dismissalDate',
				// % protected region % [Set displayName for Dismissal Date here] off begin
				displayName: 'Dismissal Date',
				// % protected region % [Set displayName for Dismissal Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Dismissal Date here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Dismissal Date here] end
				// % protected region % [Set isSensitive for Dismissal Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dismissal Date here] end
				// % protected region % [Set readonly for Dismissal Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dismissal Date here] end
				validators: [
					// % protected region % [Add other validators for Dismissal Date here] off begin
					// % protected region % [Add other validators for Dismissal Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Dismissal Date here] off begin
				// % protected region % [Add any additional model attribute properties for Dismissal Date here] end
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
				id: 'diagnosesAndProcedures',
				type: ModelRelationType.ONE,
				name: 'diagnosesAndProceduresId',
				// % protected region % [Customise your label for Diagnoses and Procedures here] off begin
				label: 'Diagnoses and Procedures',
				// % protected region % [Customise your label for Diagnoses and Procedures here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for Diagnoses and Procedures here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for Diagnoses and Procedures here] end
				validators: [
					// % protected region % [Add other validators for Diagnoses and Procedures here] off begin
					// % protected region % [Add other validators for Diagnoses and Procedures here] end
				],
				// % protected region % [Add any additional field for relation Diagnoses and Procedures here] off begin
				// % protected region % [Add any additional field for relation Diagnoses and Procedures here] end
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
	static deepParse(data: string | { [K in keyof Icd10Model]?: Icd10Model[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new Icd10Model(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.diagnosesAndProcedures) {
			currentModel.diagnosesAndProceduresId = json.diagnosesAndProcedures.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.diagnosesAndProcedures));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let icd10Model = new Icd10Model(data);`
	 *
	 * @param data The input data to be initialised as the Icd10Model,
	 *    it is expected as a JSON string or as a nullable Icd10Model.
	 */
	constructor(data?: string | Partial<Icd10Model>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<Icd10Model>
				: data;

			this.classificationDisease = json.classificationDisease;
			this.classificationInfectious = json.classificationInfectious;
			this.classificationChronic = json.classificationChronic;
			this.classificationTopDisease = json.classificationTopDisease;
			this.classificationRestrictedCase = json.classificationRestrictedCase;
			this.classificationReportableCase = json.classificationReportableCase;
			this.classificationAcute = json.classificationAcute;
			if (json.dismissalDate) {
				this.dismissalDate = new Date(json.dismissalDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dismissalDate = json.dismissalDate;
			}
			this.diagnosesAndProceduresId = json.diagnosesAndProceduresId;
			this.diagnosesAndProcedures = json.diagnosesAndProcedures;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			classificationDisease: this.classificationDisease,
			classificationInfectious: this.classificationInfectious,
			classificationChronic: this.classificationChronic,
			classificationTopDisease: this.classificationTopDisease,
			classificationRestrictedCase: this.classificationRestrictedCase,
			classificationReportableCase: this.classificationReportableCase,
			classificationAcute: this.classificationAcute,
			dismissalDate: this.dismissalDate,
			diagnosesAndProceduresId: this.diagnosesAndProceduresId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		Icd10Model.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): Icd10Model {
		let newModelJson = this.toJSON();

		if (updates.classificationDisease) {
			newModelJson.classificationDisease = updates.classificationDisease;
		}

		if (updates.classificationInfectious) {
			newModelJson.classificationInfectious = updates.classificationInfectious;
		}

		if (updates.classificationChronic) {
			newModelJson.classificationChronic = updates.classificationChronic;
		}

		if (updates.classificationTopDisease) {
			newModelJson.classificationTopDisease = updates.classificationTopDisease;
		}

		if (updates.classificationRestrictedCase) {
			newModelJson.classificationRestrictedCase = updates.classificationRestrictedCase;
		}

		if (updates.classificationReportableCase) {
			newModelJson.classificationReportableCase = updates.classificationReportableCase;
		}

		if (updates.classificationAcute) {
			newModelJson.classificationAcute = updates.classificationAcute;
		}

		if (updates.dismissalDate) {
			newModelJson.dismissalDate = updates.dismissalDate;
		}

		if (updates.diagnosesAndProceduresId) {
			newModelJson.diagnosesAndProceduresId = updates.diagnosesAndProceduresId;
		}

		return new Icd10Model(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof Icd10Model)) {
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
			'diagnosesAndProceduresId',
			'diagnosesAndProcedures',
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
		if (!this.diagnosesAndProcedures) {
			this.diagnosesAndProceduresId = null;
		} else {
			this.diagnosesAndProceduresId = this.diagnosesAndProcedures.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
