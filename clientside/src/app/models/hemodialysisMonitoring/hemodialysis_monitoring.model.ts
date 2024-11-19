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
import {HemodialysisExaminationModel} from '../hemodialysisExamination/hemodialysis_examination.model';
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
export class HemodialysisMonitoringModel extends AbstractModel {
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
		'datetime',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'HemodialysisMonitoringModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return HemodialysisMonitoringModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	datetime: Date;

	/**
	 * .
	 */
	systole: number;

	/**
	 * .
	 */
	diastole: number;

	/**
	 * .
	 */
	heartRate: number;

	/**
	 * .
	 */
	temperature: number;

	/**
	 * .
	 */
	temperatureUnit: string;

	/**
	 * .
	 */
	respiratory: number;

	/**
	 * .
	 */
	qb: number;

	/**
	 * .
	 */
	qd: number;

	/**
	 * .
	 */
	venousPressure: number;

	/**
	 * .
	 */
	tmp: number;

	/**
	 * .
	 */
	ufg: number;

	/**
	 * .
	 */
	ufr: number;

	/**
	 * .
	 */
	uf: number;

	hemodialysisExaminationId: string;

	hemodialysisExamination: HemodialysisExaminationModel;

	medicalStaffId: string;

	medicalStaff: StaffModel;

	modelPropGroups: { [s: string]: Group } = HemodialysisMonitoringModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'datetime',
				// % protected region % [Set displayName for DateTime here] off begin
				displayName: 'DateTime',
				// % protected region % [Set displayName for DateTime here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for DateTime here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for DateTime here] end
				// % protected region % [Set isSensitive for DateTime here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DateTime here] end
				// % protected region % [Set readonly for DateTime here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DateTime here] end
				validators: [
					// % protected region % [Add other validators for DateTime here] off begin
					// % protected region % [Add other validators for DateTime here] end
				],
				// % protected region % [Add any additional model attribute properties for DateTime here] off begin
				// % protected region % [Add any additional model attribute properties for DateTime here] end
			},
			{
				name: 'systole',
				// % protected region % [Set displayName for Systole here] off begin
				displayName: 'Systole',
				// % protected region % [Set displayName for Systole here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Systole here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Systole here] end
				// % protected region % [Set isSensitive for Systole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Systole here] end
				// % protected region % [Set readonly for Systole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Systole here] end
				validators: [
					// % protected region % [Add other validators for Systole here] off begin
					// % protected region % [Add other validators for Systole here] end
				],
				// % protected region % [Add any additional model attribute properties for Systole here] off begin
				// % protected region % [Add any additional model attribute properties for Systole here] end
			},
			{
				name: 'diastole',
				// % protected region % [Set displayName for Diastole here] off begin
				displayName: 'Diastole',
				// % protected region % [Set displayName for Diastole here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Diastole here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Diastole here] end
				// % protected region % [Set isSensitive for Diastole here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Diastole here] end
				// % protected region % [Set readonly for Diastole here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Diastole here] end
				validators: [
					// % protected region % [Add other validators for Diastole here] off begin
					// % protected region % [Add other validators for Diastole here] end
				],
				// % protected region % [Add any additional model attribute properties for Diastole here] off begin
				// % protected region % [Add any additional model attribute properties for Diastole here] end
			},
			{
				name: 'heartRate',
				// % protected region % [Set displayName for Heart Rate here] off begin
				displayName: 'Heart Rate',
				// % protected region % [Set displayName for Heart Rate here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Heart Rate here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Heart Rate here] end
				// % protected region % [Set isSensitive for Heart Rate here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Heart Rate here] end
				// % protected region % [Set readonly for Heart Rate here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Heart Rate here] end
				validators: [
					// % protected region % [Add other validators for Heart Rate here] off begin
					// % protected region % [Add other validators for Heart Rate here] end
				],
				// % protected region % [Add any additional model attribute properties for Heart Rate here] off begin
				// % protected region % [Add any additional model attribute properties for Heart Rate here] end
			},
			{
				name: 'temperature',
				// % protected region % [Set displayName for Temperature here] off begin
				displayName: 'Temperature',
				// % protected region % [Set displayName for Temperature here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Temperature here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Temperature here] end
				// % protected region % [Set isSensitive for Temperature here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Temperature here] end
				// % protected region % [Set readonly for Temperature here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Temperature here] end
				validators: [
					// % protected region % [Add other validators for Temperature here] off begin
					// % protected region % [Add other validators for Temperature here] end
				],
				// % protected region % [Add any additional model attribute properties for Temperature here] off begin
				// % protected region % [Add any additional model attribute properties for Temperature here] end
			},
			{
				name: 'temperatureUnit',
				// % protected region % [Set displayName for Temperature Unit here] off begin
				displayName: 'Temperature Unit',
				// % protected region % [Set displayName for Temperature Unit here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Temperature Unit here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Temperature Unit here] end
				// % protected region % [Set isSensitive for Temperature Unit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Temperature Unit here] end
				// % protected region % [Set readonly for Temperature Unit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Temperature Unit here] end
				validators: [
					// % protected region % [Add other validators for Temperature Unit here] off begin
					// % protected region % [Add other validators for Temperature Unit here] end
				],
				// % protected region % [Add any additional model attribute properties for Temperature Unit here] off begin
				// % protected region % [Add any additional model attribute properties for Temperature Unit here] end
			},
			{
				name: 'respiratory',
				// % protected region % [Set displayName for Respiratory here] off begin
				displayName: 'Respiratory',
				// % protected region % [Set displayName for Respiratory here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Respiratory here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Respiratory here] end
				// % protected region % [Set isSensitive for Respiratory here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Respiratory here] end
				// % protected region % [Set readonly for Respiratory here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Respiratory here] end
				validators: [
					// % protected region % [Add other validators for Respiratory here] off begin
					// % protected region % [Add other validators for Respiratory here] end
				],
				// % protected region % [Add any additional model attribute properties for Respiratory here] off begin
				// % protected region % [Add any additional model attribute properties for Respiratory here] end
			},
			{
				name: 'qb',
				// % protected region % [Set displayName for QB here] off begin
				displayName: 'QB',
				// % protected region % [Set displayName for QB here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for QB here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for QB here] end
				// % protected region % [Set isSensitive for QB here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for QB here] end
				// % protected region % [Set readonly for QB here] off begin
				readOnly: false,
				// % protected region % [Set readonly for QB here] end
				validators: [
					// % protected region % [Add other validators for QB here] off begin
					// % protected region % [Add other validators for QB here] end
				],
				// % protected region % [Add any additional model attribute properties for QB here] off begin
				// % protected region % [Add any additional model attribute properties for QB here] end
			},
			{
				name: 'qd',
				// % protected region % [Set displayName for QD here] off begin
				displayName: 'QD',
				// % protected region % [Set displayName for QD here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for QD here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for QD here] end
				// % protected region % [Set isSensitive for QD here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for QD here] end
				// % protected region % [Set readonly for QD here] off begin
				readOnly: false,
				// % protected region % [Set readonly for QD here] end
				validators: [
					// % protected region % [Add other validators for QD here] off begin
					// % protected region % [Add other validators for QD here] end
				],
				// % protected region % [Add any additional model attribute properties for QD here] off begin
				// % protected region % [Add any additional model attribute properties for QD here] end
			},
			{
				name: 'venousPressure',
				// % protected region % [Set displayName for Venous Pressure here] off begin
				displayName: 'Venous Pressure',
				// % protected region % [Set displayName for Venous Pressure here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Venous Pressure here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Venous Pressure here] end
				// % protected region % [Set isSensitive for Venous Pressure here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Venous Pressure here] end
				// % protected region % [Set readonly for Venous Pressure here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Venous Pressure here] end
				validators: [
					// % protected region % [Add other validators for Venous Pressure here] off begin
					// % protected region % [Add other validators for Venous Pressure here] end
				],
				// % protected region % [Add any additional model attribute properties for Venous Pressure here] off begin
				// % protected region % [Add any additional model attribute properties for Venous Pressure here] end
			},
			{
				name: 'tmp',
				// % protected region % [Set displayName for TMP here] off begin
				displayName: 'TMP',
				// % protected region % [Set displayName for TMP here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for TMP here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for TMP here] end
				// % protected region % [Set isSensitive for TMP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for TMP here] end
				// % protected region % [Set readonly for TMP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for TMP here] end
				validators: [
					// % protected region % [Add other validators for TMP here] off begin
					// % protected region % [Add other validators for TMP here] end
				],
				// % protected region % [Add any additional model attribute properties for TMP here] off begin
				// % protected region % [Add any additional model attribute properties for TMP here] end
			},
			{
				name: 'ufg',
				// % protected region % [Set displayName for UFG here] off begin
				displayName: 'UFG',
				// % protected region % [Set displayName for UFG here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for UFG here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for UFG here] end
				// % protected region % [Set isSensitive for UFG here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for UFG here] end
				// % protected region % [Set readonly for UFG here] off begin
				readOnly: false,
				// % protected region % [Set readonly for UFG here] end
				validators: [
					// % protected region % [Add other validators for UFG here] off begin
					// % protected region % [Add other validators for UFG here] end
				],
				// % protected region % [Add any additional model attribute properties for UFG here] off begin
				// % protected region % [Add any additional model attribute properties for UFG here] end
			},
			{
				name: 'ufr',
				// % protected region % [Set displayName for UFR here] off begin
				displayName: 'UFR',
				// % protected region % [Set displayName for UFR here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for UFR here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for UFR here] end
				// % protected region % [Set isSensitive for UFR here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for UFR here] end
				// % protected region % [Set readonly for UFR here] off begin
				readOnly: false,
				// % protected region % [Set readonly for UFR here] end
				validators: [
					// % protected region % [Add other validators for UFR here] off begin
					// % protected region % [Add other validators for UFR here] end
				],
				// % protected region % [Add any additional model attribute properties for UFR here] off begin
				// % protected region % [Add any additional model attribute properties for UFR here] end
			},
			{
				name: 'uf',
				// % protected region % [Set displayName for UF here] off begin
				displayName: 'UF',
				// % protected region % [Set displayName for UF here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for UF here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for UF here] end
				// % protected region % [Set isSensitive for UF here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for UF here] end
				// % protected region % [Set readonly for UF here] off begin
				readOnly: false,
				// % protected region % [Set readonly for UF here] end
				validators: [
					// % protected region % [Add other validators for UF here] off begin
					// % protected region % [Add other validators for UF here] end
				],
				// % protected region % [Add any additional model attribute properties for UF here] off begin
				// % protected region % [Add any additional model attribute properties for UF here] end
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
				id: 'hemodialysisExamination',
				type: ModelRelationType.ONE,
				name: 'hemodialysisExaminationId',
				// % protected region % [Customise your label for Hemodialysis Examination here] off begin
				label: 'Hemodialysis Examination',
				// % protected region % [Customise your label for Hemodialysis Examination here] end
				entityName: 'HemodialysisExaminationModel',
				// % protected region % [Customise your display name for Hemodialysis Examination here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'firstDialysis',
				// % protected region % [Customise your display name for Hemodialysis Examination here] end
				validators: [
					// % protected region % [Add other validators for Hemodialysis Examination here] off begin
					// % protected region % [Add other validators for Hemodialysis Examination here] end
				],
				// % protected region % [Add any additional field for relation Hemodialysis Examination here] off begin
				// % protected region % [Add any additional field for relation Hemodialysis Examination here] end
			},
			{
				id: 'medicalStaff',
				type: ModelRelationType.ONE,
				name: 'medicalStaffId',
				// % protected region % [Customise your label for Medical Staff here] off begin
				label: 'Medical Staff',
				// % protected region % [Customise your label for Medical Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Medical Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Medical Staff here] end
				validators: [
					// % protected region % [Add other validators for Medical Staff here] off begin
					// % protected region % [Add other validators for Medical Staff here] end
				],
				// % protected region % [Add any additional field for relation Medical Staff here] off begin
				// % protected region % [Add any additional field for relation Medical Staff here] end
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
	static deepParse(data: string | { [K in keyof HemodialysisMonitoringModel]?: HemodialysisMonitoringModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new HemodialysisMonitoringModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.hemodialysisExamination) {
			currentModel.hemodialysisExaminationId = json.hemodialysisExamination.id;
			returned = _.union(returned, HemodialysisExaminationModel.deepParse(json.hemodialysisExamination));
		}

		// Incoming one to many
		if (json.medicalStaff) {
			currentModel.medicalStaffId = json.medicalStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.medicalStaff));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let hemodialysisMonitoringModel = new HemodialysisMonitoringModel(data);`
	 *
	 * @param data The input data to be initialised as the HemodialysisMonitoringModel,
	 *    it is expected as a JSON string or as a nullable HemodialysisMonitoringModel.
	 */
	constructor(data?: string | Partial<HemodialysisMonitoringModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<HemodialysisMonitoringModel>
				: data;

			if (json.datetime) {
				this.datetime = new Date(json.datetime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.datetime = json.datetime;
			}
			this.systole = json.systole;
			this.diastole = json.diastole;
			this.heartRate = json.heartRate;
			this.temperature = json.temperature;
			this.temperatureUnit = json.temperatureUnit;
			this.respiratory = json.respiratory;
			this.qb = json.qb;
			this.qd = json.qd;
			this.venousPressure = json.venousPressure;
			this.tmp = json.tmp;
			this.ufg = json.ufg;
			this.ufr = json.ufr;
			this.uf = json.uf;
			this.hemodialysisExaminationId = json.hemodialysisExaminationId;
			this.hemodialysisExamination = json.hemodialysisExamination;
			this.medicalStaffId = json.medicalStaffId;
			this.medicalStaff = json.medicalStaff;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			datetime: this.datetime,
			systole: this.systole,
			diastole: this.diastole,
			heartRate: this.heartRate,
			temperature: this.temperature,
			temperatureUnit: this.temperatureUnit,
			respiratory: this.respiratory,
			qb: this.qb,
			qd: this.qd,
			venousPressure: this.venousPressure,
			tmp: this.tmp,
			ufg: this.ufg,
			ufr: this.ufr,
			uf: this.uf,
			hemodialysisExaminationId: this.hemodialysisExaminationId,
			medicalStaffId: this.medicalStaffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		HemodialysisMonitoringModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): HemodialysisMonitoringModel {
		let newModelJson = this.toJSON();

		if (updates.datetime) {
			newModelJson.datetime = updates.datetime;
		}

		if (updates.systole) {
			newModelJson.systole = updates.systole;
		}

		if (updates.diastole) {
			newModelJson.diastole = updates.diastole;
		}

		if (updates.heartRate) {
			newModelJson.heartRate = updates.heartRate;
		}

		if (updates.temperature) {
			newModelJson.temperature = updates.temperature;
		}

		if (updates.temperatureUnit) {
			newModelJson.temperatureUnit = updates.temperatureUnit;
		}

		if (updates.respiratory) {
			newModelJson.respiratory = updates.respiratory;
		}

		if (updates.qb) {
			newModelJson.qb = updates.qb;
		}

		if (updates.qd) {
			newModelJson.qd = updates.qd;
		}

		if (updates.venousPressure) {
			newModelJson.venousPressure = updates.venousPressure;
		}

		if (updates.tmp) {
			newModelJson.tmp = updates.tmp;
		}

		if (updates.ufg) {
			newModelJson.ufg = updates.ufg;
		}

		if (updates.ufr) {
			newModelJson.ufr = updates.ufr;
		}

		if (updates.uf) {
			newModelJson.uf = updates.uf;
		}

		if (updates.hemodialysisExaminationId) {
			newModelJson.hemodialysisExaminationId = updates.hemodialysisExaminationId;
		}

		if (updates.medicalStaffId) {
			newModelJson.medicalStaffId = updates.medicalStaffId;
		}

		return new HemodialysisMonitoringModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof HemodialysisMonitoringModel)) {
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
			'hemodialysisExaminationId',
			'hemodialysisExamination',
			'medicalStaffId',
			'medicalStaff',
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
		if (!this.hemodialysisExamination) {
			this.hemodialysisExaminationId = null;
		} else {
			this.hemodialysisExaminationId = this.hemodialysisExamination.id;
		}

		if (!this.medicalStaff) {
			this.medicalStaffId = null;
		} else {
			this.medicalStaffId = this.medicalStaff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
