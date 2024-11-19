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
import {ModuleNameEnum, moduleNameEnumArray} from '../../enums/module-name.enum';
import {StaffModel} from '../staff/staff.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class ProcessWorkflowModel extends AbstractModel {
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
		'stepNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ProcessWorkflowModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ProcessWorkflowModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Step Number.
	 */
	stepNumber: number;

	/**
	 * Process Name.
	 */
	processName: string;

	/**
	 * Reference ID.
	 */
	referenceID: string;

	/**
	 * Process Date Time.
	 */
	processDateTime: Date;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=3, example=Sally}.
	 */
	moduleName: ModuleNameEnum;

	staffId: string;

	staff: StaffModel;

	modelPropGroups: { [s: string]: Group } = ProcessWorkflowModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'stepNumber',
				// % protected region % [Set displayName for Step Number here] off begin
				displayName: 'Step Number',
				// % protected region % [Set displayName for Step Number here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Step Number here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Step Number here] end
				// % protected region % [Set isSensitive for Step Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Step Number here] end
				// % protected region % [Set readonly for Step Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Step Number here] end
				validators: [
					// % protected region % [Add other validators for Step Number here] off begin
					// % protected region % [Add other validators for Step Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Step Number here] off begin
				// % protected region % [Add any additional model attribute properties for Step Number here] end
			},
			{
				name: 'moduleName',
				// % protected region % [Set displayName for Module Name here] off begin
				displayName: 'Module Name',
				// % protected region % [Set displayName for Module Name here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: moduleNameEnumArray,
				// % protected region % [Set display element type for Module Name here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Module Name here] end
				// % protected region % [Set isSensitive for Module Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Module Name here] end
				// % protected region % [Set readonly for Module Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Module Name here] end
				validators: [
					// % protected region % [Add other validators for Module Name here] off begin
					// % protected region % [Add other validators for Module Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Module Name here] off begin
				// % protected region % [Add any additional model attribute properties for Module Name here] end
			},
			{
				name: 'processName',
				// % protected region % [Set displayName for Process Name here] off begin
				displayName: 'Process Name',
				// % protected region % [Set displayName for Process Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Process Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Process Name here] end
				// % protected region % [Set isSensitive for Process Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Process Name here] end
				// % protected region % [Set readonly for Process Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Process Name here] end
				validators: [
					// % protected region % [Add other validators for Process Name here] off begin
					// % protected region % [Add other validators for Process Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Process Name here] off begin
				// % protected region % [Add any additional model attribute properties for Process Name here] end
			},
			{
				name: 'referenceID',
				// % protected region % [Set displayName for Reference ID here] off begin
				displayName: 'Reference ID',
				// % protected region % [Set displayName for Reference ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Reference ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Reference ID here] end
				// % protected region % [Set isSensitive for Reference ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Reference ID here] end
				// % protected region % [Set readonly for Reference ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Reference ID here] end
				validators: [
					// % protected region % [Add other validators for Reference ID here] off begin
					// % protected region % [Add other validators for Reference ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Reference ID here] off begin
				// % protected region % [Add any additional model attribute properties for Reference ID here] end
			},
			{
				name: 'processDateTime',
				// % protected region % [Set displayName for Process Date Time here] off begin
				displayName: 'Process Date Time',
				// % protected region % [Set displayName for Process Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Process Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Process Date Time here] end
				// % protected region % [Set isSensitive for Process Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Process Date Time here] end
				// % protected region % [Set readonly for Process Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Process Date Time here] end
				validators: [
					// % protected region % [Add other validators for Process Date Time here] off begin
					// % protected region % [Add other validators for Process Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Process Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Process Date Time here] end
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
				id: 'staff',
				type: ModelRelationType.ONE,
				name: 'staffId',
				// % protected region % [Customise your label for Staff here] off begin
				label: 'Staff',
				// % protected region % [Customise your label for Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Staff here] end
				validators: [
					// % protected region % [Add other validators for Staff here] off begin
					// % protected region % [Add other validators for Staff here] end
				],
				// % protected region % [Add any additional field for relation Staff here] off begin
				// % protected region % [Add any additional field for relation Staff here] end
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
	static deepParse(data: string | { [K in keyof ProcessWorkflowModel]?: ProcessWorkflowModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ProcessWorkflowModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let processWorkflowModel = new ProcessWorkflowModel(data);`
	 *
	 * @param data The input data to be initialised as the ProcessWorkflowModel,
	 *    it is expected as a JSON string or as a nullable ProcessWorkflowModel.
	 */
	constructor(data?: string | Partial<ProcessWorkflowModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ProcessWorkflowModel>
				: data;

			this.stepNumber = json.stepNumber;
			this.moduleName = json.moduleName;
			this.processName = json.processName;
			this.referenceID = json.referenceID;
			if (json.processDateTime) {
				this.processDateTime = new Date(json.processDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.processDateTime = json.processDateTime;
			}
			this.moduleName = json.moduleName;
			this.staffId = json.staffId;
			this.staff = json.staff;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			stepNumber: this.stepNumber,
			moduleName: this.moduleName,
			processName: this.processName,
			referenceID: this.referenceID,
			processDateTime: this.processDateTime,
			staffId: this.staffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ProcessWorkflowModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ProcessWorkflowModel {
		let newModelJson = this.toJSON();

		if (updates.stepNumber) {
			newModelJson.stepNumber = updates.stepNumber;
		}

		if (updates.moduleName) {
			newModelJson.moduleName = updates.moduleName;
		}

		if (updates.processName) {
			newModelJson.processName = updates.processName;
		}

		if (updates.referenceID) {
			newModelJson.referenceID = updates.referenceID;
		}

		if (updates.processDateTime) {
			newModelJson.processDateTime = updates.processDateTime;
		}

		if (updates.moduleName) {
			newModelJson.moduleName = updates.moduleName;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		return new ProcessWorkflowModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ProcessWorkflowModel)) {
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
			'staffId',
			'staff',
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
		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
