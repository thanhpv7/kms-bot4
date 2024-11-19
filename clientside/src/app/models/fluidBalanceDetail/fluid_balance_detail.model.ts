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
import {RegistrationModel} from '../registration/registration.model';
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
export class FluidBalanceDetailModel extends AbstractModel {
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
		'recordDateTime',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'FluidBalanceDetailModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return FluidBalanceDetailModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Record Date Time.
	 */
	recordDateTime: Date;

	/**
	 * Intake Oral.
	 */
	intakeOral: number;

	/**
	 * Intake NGT.
	 */
	intakeNGT: number;

	/**
	 * Intake IV Line.
	 */
	intakeIVLine: number;

	/**
	 * Intake Others.
	 */
	intakeOthers: number;

	/**
	 * Output Urine.
	 */
	outputUrine: number;

	/**
	 * Output NGT.
	 */
	outputNGT: number;

	/**
	 * Output Drain.
	 */
	outputDrain: number;

	/**
	 * Output Stool.
	 */
	outputStool: number;

	/**
	 * Output Blood.
	 */
	outputBlood: number;

	/**
	 * Output IWL.
	 */
	outputIWL: number;

	/**
	 * Output Others.
	 */
	outputOthers: number;

	/**
	 * Notes.
	 */
	notes: string;

	/**
	 * Total Input.
	 */
	totalInput: number;

	/**
	 * Total Output.
	 */
	totalOutput: number;

	/**
	 * Total Balance Fluid.
	 */
	totalBalanceFluid: number;

	registrationId: string;

	registration: RegistrationModel;

	staffId: string;

	staff: StaffModel;

	modelPropGroups: { [s: string]: Group } = FluidBalanceDetailModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'recordDateTime',
				// % protected region % [Set displayName for Record Date Time here] off begin
				displayName: 'Record Date Time',
				// % protected region % [Set displayName for Record Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Record Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Record Date Time here] end
				// % protected region % [Set isSensitive for Record Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Record Date Time here] end
				// % protected region % [Set readonly for Record Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Record Date Time here] end
				validators: [
					// % protected region % [Add other validators for Record Date Time here] off begin
					// % protected region % [Add other validators for Record Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Record Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Record Date Time here] end
			},
			{
				name: 'intakeOral',
				// % protected region % [Set displayName for Intake Oral here] off begin
				displayName: 'Intake Oral',
				// % protected region % [Set displayName for Intake Oral here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Intake Oral here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Intake Oral here] end
				// % protected region % [Set isSensitive for Intake Oral here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Intake Oral here] end
				// % protected region % [Set readonly for Intake Oral here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Intake Oral here] end
				validators: [
					// % protected region % [Add other validators for Intake Oral here] off begin
					// % protected region % [Add other validators for Intake Oral here] end
				],
				// % protected region % [Add any additional model attribute properties for Intake Oral here] off begin
				// % protected region % [Add any additional model attribute properties for Intake Oral here] end
			},
			{
				name: 'intakeNGT',
				// % protected region % [Set displayName for Intake NGT here] off begin
				displayName: 'Intake NGT',
				// % protected region % [Set displayName for Intake NGT here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Intake NGT here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Intake NGT here] end
				// % protected region % [Set isSensitive for Intake NGT here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Intake NGT here] end
				// % protected region % [Set readonly for Intake NGT here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Intake NGT here] end
				validators: [
					// % protected region % [Add other validators for Intake NGT here] off begin
					// % protected region % [Add other validators for Intake NGT here] end
				],
				// % protected region % [Add any additional model attribute properties for Intake NGT here] off begin
				// % protected region % [Add any additional model attribute properties for Intake NGT here] end
			},
			{
				name: 'intakeIVLine',
				// % protected region % [Set displayName for Intake IV Line here] off begin
				displayName: 'Intake IV Line',
				// % protected region % [Set displayName for Intake IV Line here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Intake IV Line here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Intake IV Line here] end
				// % protected region % [Set isSensitive for Intake IV Line here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Intake IV Line here] end
				// % protected region % [Set readonly for Intake IV Line here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Intake IV Line here] end
				validators: [
					// % protected region % [Add other validators for Intake IV Line here] off begin
					// % protected region % [Add other validators for Intake IV Line here] end
				],
				// % protected region % [Add any additional model attribute properties for Intake IV Line here] off begin
				// % protected region % [Add any additional model attribute properties for Intake IV Line here] end
			},
			{
				name: 'intakeOthers',
				// % protected region % [Set displayName for Intake Others here] off begin
				displayName: 'Intake Others',
				// % protected region % [Set displayName for Intake Others here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Intake Others here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Intake Others here] end
				// % protected region % [Set isSensitive for Intake Others here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Intake Others here] end
				// % protected region % [Set readonly for Intake Others here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Intake Others here] end
				validators: [
					// % protected region % [Add other validators for Intake Others here] off begin
					// % protected region % [Add other validators for Intake Others here] end
				],
				// % protected region % [Add any additional model attribute properties for Intake Others here] off begin
				// % protected region % [Add any additional model attribute properties for Intake Others here] end
			},
			{
				name: 'outputUrine',
				// % protected region % [Set displayName for Output Urine here] off begin
				displayName: 'Output Urine',
				// % protected region % [Set displayName for Output Urine here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Output Urine here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Output Urine here] end
				// % protected region % [Set isSensitive for Output Urine here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Output Urine here] end
				// % protected region % [Set readonly for Output Urine here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Output Urine here] end
				validators: [
					// % protected region % [Add other validators for Output Urine here] off begin
					// % protected region % [Add other validators for Output Urine here] end
				],
				// % protected region % [Add any additional model attribute properties for Output Urine here] off begin
				// % protected region % [Add any additional model attribute properties for Output Urine here] end
			},
			{
				name: 'outputNGT',
				// % protected region % [Set displayName for Output NGT here] off begin
				displayName: 'Output NGT',
				// % protected region % [Set displayName for Output NGT here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Output NGT here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Output NGT here] end
				// % protected region % [Set isSensitive for Output NGT here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Output NGT here] end
				// % protected region % [Set readonly for Output NGT here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Output NGT here] end
				validators: [
					// % protected region % [Add other validators for Output NGT here] off begin
					// % protected region % [Add other validators for Output NGT here] end
				],
				// % protected region % [Add any additional model attribute properties for Output NGT here] off begin
				// % protected region % [Add any additional model attribute properties for Output NGT here] end
			},
			{
				name: 'outputDrain',
				// % protected region % [Set displayName for Output Drain here] off begin
				displayName: 'Output Drain',
				// % protected region % [Set displayName for Output Drain here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Output Drain here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Output Drain here] end
				// % protected region % [Set isSensitive for Output Drain here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Output Drain here] end
				// % protected region % [Set readonly for Output Drain here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Output Drain here] end
				validators: [
					// % protected region % [Add other validators for Output Drain here] off begin
					// % protected region % [Add other validators for Output Drain here] end
				],
				// % protected region % [Add any additional model attribute properties for Output Drain here] off begin
				// % protected region % [Add any additional model attribute properties for Output Drain here] end
			},
			{
				name: 'outputStool',
				// % protected region % [Set displayName for Output Stool here] off begin
				displayName: 'Output Stool',
				// % protected region % [Set displayName for Output Stool here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Output Stool here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Output Stool here] end
				// % protected region % [Set isSensitive for Output Stool here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Output Stool here] end
				// % protected region % [Set readonly for Output Stool here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Output Stool here] end
				validators: [
					// % protected region % [Add other validators for Output Stool here] off begin
					// % protected region % [Add other validators for Output Stool here] end
				],
				// % protected region % [Add any additional model attribute properties for Output Stool here] off begin
				// % protected region % [Add any additional model attribute properties for Output Stool here] end
			},
			{
				name: 'outputBlood',
				// % protected region % [Set displayName for Output Blood here] off begin
				displayName: 'Output Blood',
				// % protected region % [Set displayName for Output Blood here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Output Blood here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Output Blood here] end
				// % protected region % [Set isSensitive for Output Blood here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Output Blood here] end
				// % protected region % [Set readonly for Output Blood here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Output Blood here] end
				validators: [
					// % protected region % [Add other validators for Output Blood here] off begin
					// % protected region % [Add other validators for Output Blood here] end
				],
				// % protected region % [Add any additional model attribute properties for Output Blood here] off begin
				// % protected region % [Add any additional model attribute properties for Output Blood here] end
			},
			{
				name: 'outputIWL',
				// % protected region % [Set displayName for Output IWL here] off begin
				displayName: 'Output IWL',
				// % protected region % [Set displayName for Output IWL here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Output IWL here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Output IWL here] end
				// % protected region % [Set isSensitive for Output IWL here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Output IWL here] end
				// % protected region % [Set readonly for Output IWL here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Output IWL here] end
				validators: [
					// % protected region % [Add other validators for Output IWL here] off begin
					// % protected region % [Add other validators for Output IWL here] end
				],
				// % protected region % [Add any additional model attribute properties for Output IWL here] off begin
				// % protected region % [Add any additional model attribute properties for Output IWL here] end
			},
			{
				name: 'outputOthers',
				// % protected region % [Set displayName for Output Others here] off begin
				displayName: 'Output Others',
				// % protected region % [Set displayName for Output Others here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Output Others here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Output Others here] end
				// % protected region % [Set isSensitive for Output Others here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Output Others here] end
				// % protected region % [Set readonly for Output Others here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Output Others here] end
				validators: [
					// % protected region % [Add other validators for Output Others here] off begin
					// % protected region % [Add other validators for Output Others here] end
				],
				// % protected region % [Add any additional model attribute properties for Output Others here] off begin
				// % protected region % [Add any additional model attribute properties for Output Others here] end
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
				name: 'totalInput',
				// % protected region % [Set displayName for Total Input here] off begin
				displayName: 'Total Input',
				// % protected region % [Set displayName for Total Input here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Input here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Input here] end
				// % protected region % [Set isSensitive for Total Input here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Input here] end
				// % protected region % [Set readonly for Total Input here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Input here] end
				validators: [
					// % protected region % [Add other validators for Total Input here] off begin
					// % protected region % [Add other validators for Total Input here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Input here] off begin
				// % protected region % [Add any additional model attribute properties for Total Input here] end
			},
			{
				name: 'totalOutput',
				// % protected region % [Set displayName for Total Output here] off begin
				displayName: 'Total Output',
				// % protected region % [Set displayName for Total Output here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Output here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Output here] end
				// % protected region % [Set isSensitive for Total Output here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Output here] end
				// % protected region % [Set readonly for Total Output here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Output here] end
				validators: [
					// % protected region % [Add other validators for Total Output here] off begin
					// % protected region % [Add other validators for Total Output here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Output here] off begin
				// % protected region % [Add any additional model attribute properties for Total Output here] end
			},
			{
				name: 'totalBalanceFluid',
				// % protected region % [Set displayName for Total Balance Fluid here] off begin
				displayName: 'Total Balance Fluid',
				// % protected region % [Set displayName for Total Balance Fluid here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Balance Fluid here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Balance Fluid here] end
				// % protected region % [Set isSensitive for Total Balance Fluid here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Balance Fluid here] end
				// % protected region % [Set readonly for Total Balance Fluid here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Balance Fluid here] end
				validators: [
					// % protected region % [Add other validators for Total Balance Fluid here] off begin
					// % protected region % [Add other validators for Total Balance Fluid here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Balance Fluid here] off begin
				// % protected region % [Add any additional model attribute properties for Total Balance Fluid here] end
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
	static deepParse(data: string | { [K in keyof FluidBalanceDetailModel]?: FluidBalanceDetailModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new FluidBalanceDetailModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.registration) {
			currentModel.registrationId = json.registration.id;
			returned = _.union(returned, RegistrationModel.deepParse(json.registration));
		}

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
	 * `let fluidBalanceDetailModel = new FluidBalanceDetailModel(data);`
	 *
	 * @param data The input data to be initialised as the FluidBalanceDetailModel,
	 *    it is expected as a JSON string or as a nullable FluidBalanceDetailModel.
	 */
	constructor(data?: string | Partial<FluidBalanceDetailModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<FluidBalanceDetailModel>
				: data;

			if (json.recordDateTime) {
				this.recordDateTime = new Date(json.recordDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.recordDateTime = json.recordDateTime;
			}
			this.intakeOral = json.intakeOral;
			this.intakeNGT = json.intakeNGT;
			this.intakeIVLine = json.intakeIVLine;
			this.intakeOthers = json.intakeOthers;
			this.outputUrine = json.outputUrine;
			this.outputNGT = json.outputNGT;
			this.outputDrain = json.outputDrain;
			this.outputStool = json.outputStool;
			this.outputBlood = json.outputBlood;
			this.outputIWL = json.outputIWL;
			this.outputOthers = json.outputOthers;
			this.notes = json.notes;
			this.totalInput = json.totalInput;
			this.totalOutput = json.totalOutput;
			this.totalBalanceFluid = json.totalBalanceFluid;
			this.registrationId = json.registrationId;
			this.registration = json.registration;
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
			recordDateTime: this.recordDateTime,
			intakeOral: this.intakeOral,
			intakeNGT: this.intakeNGT,
			intakeIVLine: this.intakeIVLine,
			intakeOthers: this.intakeOthers,
			outputUrine: this.outputUrine,
			outputNGT: this.outputNGT,
			outputDrain: this.outputDrain,
			outputStool: this.outputStool,
			outputBlood: this.outputBlood,
			outputIWL: this.outputIWL,
			outputOthers: this.outputOthers,
			notes: this.notes,
			totalInput: this.totalInput,
			totalOutput: this.totalOutput,
			totalBalanceFluid: this.totalBalanceFluid,
			registrationId: this.registrationId,
			staffId: this.staffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		FluidBalanceDetailModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): FluidBalanceDetailModel {
		let newModelJson = this.toJSON();

		if (updates.recordDateTime) {
			newModelJson.recordDateTime = updates.recordDateTime;
		}

		if (updates.intakeOral) {
			newModelJson.intakeOral = updates.intakeOral;
		}

		if (updates.intakeNGT) {
			newModelJson.intakeNGT = updates.intakeNGT;
		}

		if (updates.intakeIVLine) {
			newModelJson.intakeIVLine = updates.intakeIVLine;
		}

		if (updates.intakeOthers) {
			newModelJson.intakeOthers = updates.intakeOthers;
		}

		if (updates.outputUrine) {
			newModelJson.outputUrine = updates.outputUrine;
		}

		if (updates.outputNGT) {
			newModelJson.outputNGT = updates.outputNGT;
		}

		if (updates.outputDrain) {
			newModelJson.outputDrain = updates.outputDrain;
		}

		if (updates.outputStool) {
			newModelJson.outputStool = updates.outputStool;
		}

		if (updates.outputBlood) {
			newModelJson.outputBlood = updates.outputBlood;
		}

		if (updates.outputIWL) {
			newModelJson.outputIWL = updates.outputIWL;
		}

		if (updates.outputOthers) {
			newModelJson.outputOthers = updates.outputOthers;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.totalInput) {
			newModelJson.totalInput = updates.totalInput;
		}

		if (updates.totalOutput) {
			newModelJson.totalOutput = updates.totalOutput;
		}

		if (updates.totalBalanceFluid) {
			newModelJson.totalBalanceFluid = updates.totalBalanceFluid;
		}

		if (updates.registrationId) {
			newModelJson.registrationId = updates.registrationId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		return new FluidBalanceDetailModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof FluidBalanceDetailModel)) {
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
			'registrationId',
			'registration',
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
		if (!this.registration) {
			this.registrationId = null;
		} else {
			this.registrationId = this.registration.id;
		}

		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
