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
import {OperatingTheaterMedicalExaminationRecordModel} from '../operatingTheaterMedicalExaminationRecord/operating_theater_medical_examination_record.model';
import {RoomFacilityModel} from '../roomFacility/room_facility.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class IntraoperativeRecordsModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'surgeryDetails',
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

	readonly className = 'IntraoperativeRecordsModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return IntraoperativeRecordsModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Start Date Time.
	 */
	startDateTime: Date;

	/**
	 * End Date Time.
	 */
	endDateTime: Date;

	/**
	 * Surgery Start Date Time.
	 */
	surgeryStartDateTime: Date;

	/**
	 * Surgery End Date Time.
	 */
	surgeryEndDateTime: Date;

	/**
	 * Surgery Details.
	 */
	surgeryDetails: string;

	/**
	 * Blood Transfusion.
	 */
	bloodTransfusion: string;

	/**
	 * Instruments Used.
	 */
	instrumentsUsed: string;

	/**
	 * Anesthesia Start Date Time.
	 */
	anesthesiaStartDateTime: Date;

	/**
	 * Anesthesia Type.
	 */
	anesthesiaType: string;

	/**
	 * Anesthesia Method.
	 */
	anesthesiaMethod: string;

	/**
	 * Anesthesia Agents.
	 */
	anesthesiaAgents: string;

	/**
	 * Anesthesia Observations.
	 */
	anesthesiaObservations: string;

	/**
	 * Anesthesia Notes.
	 */
	anesthesiaNotes: string;

	/**
	 * Anesthesia End Date Time.
	 */
	anesthesiaEndDateTime: Date;

	operatingTheaterMedicalExaminationRecordId: string;

	operatingTheaterMedicalExaminationRecord: OperatingTheaterMedicalExaminationRecordModel;

	operatingRoomId: string;

	operatingRoom: RoomFacilityModel;

	bedFacilitiesIds: string[] = [];

	bedFacilities: BedFacilityModel[];

	modelPropGroups: { [s: string]: Group } = IntraoperativeRecordsModel.modelPropGroups;

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
				elementType: ElementType.DATETIME,
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
				elementType: ElementType.DATETIME,
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
				name: 'surgeryStartDateTime',
				// % protected region % [Set displayName for Surgery Start Date Time here] off begin
				displayName: 'Surgery Start Date Time',
				// % protected region % [Set displayName for Surgery Start Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Surgery Start Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Surgery Start Date Time here] end
				// % protected region % [Set isSensitive for Surgery Start Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgery Start Date Time here] end
				// % protected region % [Set readonly for Surgery Start Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgery Start Date Time here] end
				validators: [
					// % protected region % [Add other validators for Surgery Start Date Time here] off begin
					// % protected region % [Add other validators for Surgery Start Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgery Start Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Surgery Start Date Time here] end
			},
			{
				name: 'surgeryEndDateTime',
				// % protected region % [Set displayName for Surgery End Date Time here] off begin
				displayName: 'Surgery End Date Time',
				// % protected region % [Set displayName for Surgery End Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Surgery End Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Surgery End Date Time here] end
				// % protected region % [Set isSensitive for Surgery End Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgery End Date Time here] end
				// % protected region % [Set readonly for Surgery End Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgery End Date Time here] end
				validators: [
					// % protected region % [Add other validators for Surgery End Date Time here] off begin
					// % protected region % [Add other validators for Surgery End Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgery End Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Surgery End Date Time here] end
			},
			{
				name: 'surgeryDetails',
				// % protected region % [Set displayName for Surgery Details here] off begin
				displayName: 'Surgery Details',
				// % protected region % [Set displayName for Surgery Details here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Surgery Details here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Surgery Details here] end
				// % protected region % [Set isSensitive for Surgery Details here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surgery Details here] end
				// % protected region % [Set readonly for Surgery Details here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surgery Details here] end
				validators: [
					// % protected region % [Add other validators for Surgery Details here] off begin
					// % protected region % [Add other validators for Surgery Details here] end
				],
				// % protected region % [Add any additional model attribute properties for Surgery Details here] off begin
				// % protected region % [Add any additional model attribute properties for Surgery Details here] end
			},
			{
				name: 'bloodTransfusion',
				// % protected region % [Set displayName for Blood Transfusion here] off begin
				displayName: 'Blood Transfusion',
				// % protected region % [Set displayName for Blood Transfusion here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Blood Transfusion here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Blood Transfusion here] end
				// % protected region % [Set isSensitive for Blood Transfusion here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Blood Transfusion here] end
				// % protected region % [Set readonly for Blood Transfusion here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Blood Transfusion here] end
				validators: [
					// % protected region % [Add other validators for Blood Transfusion here] off begin
					// % protected region % [Add other validators for Blood Transfusion here] end
				],
				// % protected region % [Add any additional model attribute properties for Blood Transfusion here] off begin
				// % protected region % [Add any additional model attribute properties for Blood Transfusion here] end
			},
			{
				name: 'instrumentsUsed',
				// % protected region % [Set displayName for Instruments Used here] off begin
				displayName: 'Instruments Used',
				// % protected region % [Set displayName for Instruments Used here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Instruments Used here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Instruments Used here] end
				// % protected region % [Set isSensitive for Instruments Used here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Instruments Used here] end
				// % protected region % [Set readonly for Instruments Used here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Instruments Used here] end
				validators: [
					// % protected region % [Add other validators for Instruments Used here] off begin
					// % protected region % [Add other validators for Instruments Used here] end
				],
				// % protected region % [Add any additional model attribute properties for Instruments Used here] off begin
				// % protected region % [Add any additional model attribute properties for Instruments Used here] end
			},
			{
				name: 'anesthesiaStartDateTime',
				// % protected region % [Set displayName for Anesthesia Start Date Time here] off begin
				displayName: 'Anesthesia Start Date Time',
				// % protected region % [Set displayName for Anesthesia Start Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Anesthesia Start Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Anesthesia Start Date Time here] end
				// % protected region % [Set isSensitive for Anesthesia Start Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Start Date Time here] end
				// % protected region % [Set readonly for Anesthesia Start Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Start Date Time here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Start Date Time here] off begin
					// % protected region % [Add other validators for Anesthesia Start Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Start Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Start Date Time here] end
			},
			{
				name: 'anesthesiaType',
				// % protected region % [Set displayName for Anesthesia Type here] off begin
				displayName: 'Anesthesia Type',
				// % protected region % [Set displayName for Anesthesia Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Anesthesia Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Anesthesia Type here] end
				// % protected region % [Set isSensitive for Anesthesia Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Type here] end
				// % protected region % [Set readonly for Anesthesia Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Type here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Type here] off begin
					// % protected region % [Add other validators for Anesthesia Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Type here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Type here] end
			},
			{
				name: 'anesthesiaMethod',
				// % protected region % [Set displayName for Anesthesia Method here] off begin
				displayName: 'Anesthesia Method',
				// % protected region % [Set displayName for Anesthesia Method here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Anesthesia Method here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Anesthesia Method here] end
				// % protected region % [Set isSensitive for Anesthesia Method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Method here] end
				// % protected region % [Set readonly for Anesthesia Method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Method here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Method here] off begin
					// % protected region % [Add other validators for Anesthesia Method here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Method here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Method here] end
			},
			{
				name: 'anesthesiaAgents',
				// % protected region % [Set displayName for Anesthesia Agents here] off begin
				displayName: 'Anesthesia Agents',
				// % protected region % [Set displayName for Anesthesia Agents here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Anesthesia Agents here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Anesthesia Agents here] end
				// % protected region % [Set isSensitive for Anesthesia Agents here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Agents here] end
				// % protected region % [Set readonly for Anesthesia Agents here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Agents here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Agents here] off begin
					// % protected region % [Add other validators for Anesthesia Agents here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Agents here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Agents here] end
			},
			{
				name: 'anesthesiaObservations',
				// % protected region % [Set displayName for Anesthesia Observations here] off begin
				displayName: 'Anesthesia Observations',
				// % protected region % [Set displayName for Anesthesia Observations here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Anesthesia Observations here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Anesthesia Observations here] end
				// % protected region % [Set isSensitive for Anesthesia Observations here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Observations here] end
				// % protected region % [Set readonly for Anesthesia Observations here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Observations here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Observations here] off begin
					// % protected region % [Add other validators for Anesthesia Observations here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Observations here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Observations here] end
			},
			{
				name: 'anesthesiaNotes',
				// % protected region % [Set displayName for Anesthesia Notes here] off begin
				displayName: 'Anesthesia Notes',
				// % protected region % [Set displayName for Anesthesia Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Anesthesia Notes here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Anesthesia Notes here] end
				// % protected region % [Set isSensitive for Anesthesia Notes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Notes here] end
				// % protected region % [Set readonly for Anesthesia Notes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Notes here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Notes here] off begin
					// % protected region % [Add other validators for Anesthesia Notes here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Notes here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Notes here] end
			},
			{
				name: 'anesthesiaEndDateTime',
				// % protected region % [Set displayName for Anesthesia End Date Time here] off begin
				displayName: 'Anesthesia End Date Time',
				// % protected region % [Set displayName for Anesthesia End Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Anesthesia End Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Anesthesia End Date Time here] end
				// % protected region % [Set isSensitive for Anesthesia End Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia End Date Time here] end
				// % protected region % [Set readonly for Anesthesia End Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia End Date Time here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia End Date Time here] off begin
					// % protected region % [Add other validators for Anesthesia End Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia End Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia End Date Time here] end
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
				id: 'bedFacilities',
				type: ModelRelationType.MANY,
				name: 'bedFacilitiesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Bed Facilities here] off begin
				label: 'Bed Facilities',
				// % protected region % [Customise your 1-1 or 1-M label for Bed Facilities here] end
				entityName: 'BedFacilityModel',
				// % protected region % [Customise your display name for Bed Facilities here] off begin
				displayName: 'bedNumber',
				// % protected region % [Customise your display name for Bed Facilities here] end
				validators: [
					// % protected region % [Add other validators for Bed Facilities here] off begin
					// % protected region % [Add other validators for Bed Facilities here] end
				],
				// % protected region % [Add any additional field for relation Bed Facilities here] off begin
				// % protected region % [Add any additional field for relation Bed Facilities here] end
			},
			{
				id: 'operatingTheaterMedicalExaminationRecord',
				type: ModelRelationType.ONE,
				name: 'operatingTheaterMedicalExaminationRecordId',
				// % protected region % [Customise your label for Operating Theater Medical Examination Record here] off begin
				label: 'Operating Theater Medical Examination Record',
				// % protected region % [Customise your label for Operating Theater Medical Examination Record here] end
				entityName: 'OperatingTheaterMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Operating Theater Medical Examination Record here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'hasConfirmedIdentity',
				// % protected region % [Customise your display name for Operating Theater Medical Examination Record here] end
				validators: [
					// % protected region % [Add other validators for Operating Theater Medical Examination Record here] off begin
					// % protected region % [Add other validators for Operating Theater Medical Examination Record here] end
				],
				// % protected region % [Add any additional field for relation Operating Theater Medical Examination Record here] off begin
				// % protected region % [Add any additional field for relation Operating Theater Medical Examination Record here] end
			},
			{
				id: 'operatingRoom',
				type: ModelRelationType.ONE,
				name: 'operatingRoomId',
				// % protected region % [Customise your label for Operating Room here] off begin
				label: 'Operating Room',
				// % protected region % [Customise your label for Operating Room here] end
				entityName: 'RoomFacilityModel',
				// % protected region % [Customise your display name for Operating Room here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'roomNumber',
				// % protected region % [Customise your display name for Operating Room here] end
				validators: [
					// % protected region % [Add other validators for Operating Room here] off begin
					// % protected region % [Add other validators for Operating Room here] end
				],
				// % protected region % [Add any additional field for relation Operating Room here] off begin
				// % protected region % [Add any additional field for relation Operating Room here] end
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
				case 'surgeryDetails':
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
	static deepParse(data: string | { [K in keyof IntraoperativeRecordsModel]?: IntraoperativeRecordsModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new IntraoperativeRecordsModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.operatingTheaterMedicalExaminationRecord) {
			currentModel.operatingTheaterMedicalExaminationRecordId = json.operatingTheaterMedicalExaminationRecord.id;
			returned = _.union(returned, OperatingTheaterMedicalExaminationRecordModel.deepParse(json.operatingTheaterMedicalExaminationRecord));
		}

		// Incoming one to many
		if (json.operatingRoom) {
			currentModel.operatingRoomId = json.operatingRoom.id;
			returned = _.union(returned, RoomFacilityModel.deepParse(json.operatingRoom));
		}

		// Outgoing one to many
		if (json.bedFacilities) {
			currentModel.bedFacilitiesIds = json.bedFacilities.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bedFacilities.map(model => BedFacilityModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let intraoperativeRecordsModel = new IntraoperativeRecordsModel(data);`
	 *
	 * @param data The input data to be initialised as the IntraoperativeRecordsModel,
	 *    it is expected as a JSON string or as a nullable IntraoperativeRecordsModel.
	 */
	constructor(data?: string | Partial<IntraoperativeRecordsModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<IntraoperativeRecordsModel>
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
			if (json.surgeryStartDateTime) {
				this.surgeryStartDateTime = new Date(json.surgeryStartDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.surgeryStartDateTime = json.surgeryStartDateTime;
			}
			if (json.surgeryEndDateTime) {
				this.surgeryEndDateTime = new Date(json.surgeryEndDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.surgeryEndDateTime = json.surgeryEndDateTime;
			}
			this.surgeryDetails = json.surgeryDetails;
			this.bloodTransfusion = json.bloodTransfusion;
			this.instrumentsUsed = json.instrumentsUsed;
			if (json.anesthesiaStartDateTime) {
				this.anesthesiaStartDateTime = new Date(json.anesthesiaStartDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.anesthesiaStartDateTime = json.anesthesiaStartDateTime;
			}
			this.anesthesiaType = json.anesthesiaType;
			this.anesthesiaMethod = json.anesthesiaMethod;
			this.anesthesiaAgents = json.anesthesiaAgents;
			this.anesthesiaObservations = json.anesthesiaObservations;
			this.anesthesiaNotes = json.anesthesiaNotes;
			if (json.anesthesiaEndDateTime) {
				this.anesthesiaEndDateTime = new Date(json.anesthesiaEndDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.anesthesiaEndDateTime = json.anesthesiaEndDateTime;
			}
			this.operatingTheaterMedicalExaminationRecordId = json.operatingTheaterMedicalExaminationRecordId;
			this.operatingTheaterMedicalExaminationRecord = json.operatingTheaterMedicalExaminationRecord;
			this.operatingRoomId = json.operatingRoomId;
			this.operatingRoom = json.operatingRoom;
			this.bedFacilitiesIds = json.bedFacilitiesIds;
			this.bedFacilities = json.bedFacilities;
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
			surgeryStartDateTime: this.surgeryStartDateTime,
			surgeryEndDateTime: this.surgeryEndDateTime,
			surgeryDetails: this.surgeryDetails,
			bloodTransfusion: this.bloodTransfusion,
			instrumentsUsed: this.instrumentsUsed,
			anesthesiaStartDateTime: this.anesthesiaStartDateTime,
			anesthesiaType: this.anesthesiaType,
			anesthesiaMethod: this.anesthesiaMethod,
			anesthesiaAgents: this.anesthesiaAgents,
			anesthesiaObservations: this.anesthesiaObservations,
			anesthesiaNotes: this.anesthesiaNotes,
			anesthesiaEndDateTime: this.anesthesiaEndDateTime,
			operatingTheaterMedicalExaminationRecordId: this.operatingTheaterMedicalExaminationRecordId,
			operatingRoomId: this.operatingRoomId,
			bedFacilitiesIds: this.bedFacilitiesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		IntraoperativeRecordsModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): IntraoperativeRecordsModel {
		let newModelJson = this.toJSON();

		if (updates.startDateTime) {
			newModelJson.startDateTime = updates.startDateTime;
		}

		if (updates.endDateTime) {
			newModelJson.endDateTime = updates.endDateTime;
		}

		if (updates.surgeryStartDateTime) {
			newModelJson.surgeryStartDateTime = updates.surgeryStartDateTime;
		}

		if (updates.surgeryEndDateTime) {
			newModelJson.surgeryEndDateTime = updates.surgeryEndDateTime;
		}

		if (updates.surgeryDetails) {
			newModelJson.surgeryDetails = updates.surgeryDetails;
		}

		if (updates.bloodTransfusion) {
			newModelJson.bloodTransfusion = updates.bloodTransfusion;
		}

		if (updates.instrumentsUsed) {
			newModelJson.instrumentsUsed = updates.instrumentsUsed;
		}

		if (updates.anesthesiaStartDateTime) {
			newModelJson.anesthesiaStartDateTime = updates.anesthesiaStartDateTime;
		}

		if (updates.anesthesiaType) {
			newModelJson.anesthesiaType = updates.anesthesiaType;
		}

		if (updates.anesthesiaMethod) {
			newModelJson.anesthesiaMethod = updates.anesthesiaMethod;
		}

		if (updates.anesthesiaAgents) {
			newModelJson.anesthesiaAgents = updates.anesthesiaAgents;
		}

		if (updates.anesthesiaObservations) {
			newModelJson.anesthesiaObservations = updates.anesthesiaObservations;
		}

		if (updates.anesthesiaNotes) {
			newModelJson.anesthesiaNotes = updates.anesthesiaNotes;
		}

		if (updates.anesthesiaEndDateTime) {
			newModelJson.anesthesiaEndDateTime = updates.anesthesiaEndDateTime;
		}

		if (updates.operatingTheaterMedicalExaminationRecordId) {
			newModelJson.operatingTheaterMedicalExaminationRecordId = updates.operatingTheaterMedicalExaminationRecordId;
		}

		if (updates.operatingRoomId) {
			newModelJson.operatingRoomId = updates.operatingRoomId;
		}

		if (updates.bedFacilitiesIds) {
			newModelJson.bedFacilitiesIds = updates.bedFacilitiesIds;
		}

		return new IntraoperativeRecordsModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof IntraoperativeRecordsModel)) {
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
			'operatingTheaterMedicalExaminationRecordId',
			'operatingTheaterMedicalExaminationRecord',
			'operatingRoomId',
			'operatingRoom',
			'bedFacilitiesIds',
			'bedFacilities',
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
		if (!this.operatingTheaterMedicalExaminationRecord) {
			this.operatingTheaterMedicalExaminationRecordId = null;
		} else {
			this.operatingTheaterMedicalExaminationRecordId = this.operatingTheaterMedicalExaminationRecord.id;
		}

		if (!this.operatingRoom) {
			this.operatingRoomId = null;
		} else {
			this.operatingRoomId = this.operatingRoom.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
