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
import {DiagnosesAndProceduresModel} from '../diagnosesAndProcedures/diagnoses_and_procedures.model';
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
export class PostOperativeDetailsModel extends AbstractModel {
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
		'recoveryStartDateTime',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PostOperativeDetailsModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PostOperativeDetailsModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Recovery Start Date Time.
	 */
	recoveryStartDateTime: Date;

	/**
	 * Recovery End Date Time.
	 */
	recoveryEndDateTime: Date;

	/**
	 * Postoperative Main Diagnosis.
	 */
	postoperativeMainDiagnosis: string;

	/**
	 * Postoperative Action.
	 */
	postoperativeAction: string;

	/**
	 * New Case.
	 */
	newCase: boolean = false;

	/**
	 * Postoperative Diagnosis Support Order.
	 */
	postoperativeDiagnosisSupportOrder: string;

	/**
	 * Anesthesia Postoperative Monitoring.
	 */
	anesthesiaPostoperativeMonitoring: string;

	/**
	 * Anesthesia Postoperative Action.
	 */
	anesthesiaPostoperativeAction: string;

	operatingTheaterMedicalExaminationRecordId: string;

	operatingTheaterMedicalExaminationRecord: OperatingTheaterMedicalExaminationRecordModel;

	postOperativeICD10Id: string;

	postOperativeICD10: DiagnosesAndProceduresModel;

	postOperativeICD9CMId: string;

	postOperativeICD9CM: DiagnosesAndProceduresModel;

	recoveryRoomsId: string;

	recoveryRooms: RoomFacilityModel;

	bedFacilitiesIds: string[] = [];

	bedFacilities: BedFacilityModel[];

	modelPropGroups: { [s: string]: Group } = PostOperativeDetailsModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'recoveryStartDateTime',
				// % protected region % [Set displayName for Recovery Start Date Time here] off begin
				displayName: 'Recovery Start Date Time',
				// % protected region % [Set displayName for Recovery Start Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Recovery Start Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Recovery Start Date Time here] end
				// % protected region % [Set isSensitive for Recovery Start Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Recovery Start Date Time here] end
				// % protected region % [Set readonly for Recovery Start Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Recovery Start Date Time here] end
				validators: [
					// % protected region % [Add other validators for Recovery Start Date Time here] off begin
					// % protected region % [Add other validators for Recovery Start Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Recovery Start Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Recovery Start Date Time here] end
			},
			{
				name: 'recoveryEndDateTime',
				// % protected region % [Set displayName for Recovery End Date Time here] off begin
				displayName: 'Recovery End Date Time',
				// % protected region % [Set displayName for Recovery End Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Recovery End Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Recovery End Date Time here] end
				// % protected region % [Set isSensitive for Recovery End Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Recovery End Date Time here] end
				// % protected region % [Set readonly for Recovery End Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Recovery End Date Time here] end
				validators: [
					// % protected region % [Add other validators for Recovery End Date Time here] off begin
					// % protected region % [Add other validators for Recovery End Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Recovery End Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Recovery End Date Time here] end
			},
			{
				name: 'postoperativeMainDiagnosis',
				// % protected region % [Set displayName for Postoperative Main Diagnosis here] off begin
				displayName: 'Postoperative Main Diagnosis',
				// % protected region % [Set displayName for Postoperative Main Diagnosis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Postoperative Main Diagnosis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Postoperative Main Diagnosis here] end
				// % protected region % [Set isSensitive for Postoperative Main Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Postoperative Main Diagnosis here] end
				// % protected region % [Set readonly for Postoperative Main Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Postoperative Main Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for Postoperative Main Diagnosis here] off begin
					// % protected region % [Add other validators for Postoperative Main Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for Postoperative Main Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for Postoperative Main Diagnosis here] end
			},
			{
				name: 'postoperativeAction',
				// % protected region % [Set displayName for Postoperative Action here] off begin
				displayName: 'Postoperative Action',
				// % protected region % [Set displayName for Postoperative Action here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Postoperative Action here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Postoperative Action here] end
				// % protected region % [Set isSensitive for Postoperative Action here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Postoperative Action here] end
				// % protected region % [Set readonly for Postoperative Action here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Postoperative Action here] end
				validators: [
					// % protected region % [Add other validators for Postoperative Action here] off begin
					// % protected region % [Add other validators for Postoperative Action here] end
				],
				// % protected region % [Add any additional model attribute properties for Postoperative Action here] off begin
				// % protected region % [Add any additional model attribute properties for Postoperative Action here] end
			},
			{
				name: 'newCase',
				// % protected region % [Set displayName for New Case here] off begin
				displayName: 'New Case',
				// % protected region % [Set displayName for New Case here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for New Case here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for New Case here] end
				// % protected region % [Set isSensitive for New Case here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for New Case here] end
				// % protected region % [Set readonly for New Case here] off begin
				readOnly: false,
				// % protected region % [Set readonly for New Case here] end
				validators: [
					// % protected region % [Add other validators for New Case here] off begin
					// % protected region % [Add other validators for New Case here] end
				],
				// % protected region % [Add any additional model attribute properties for New Case here] off begin
				// % protected region % [Add any additional model attribute properties for New Case here] end
			},
			{
				name: 'postoperativeDiagnosisSupportOrder',
				// % protected region % [Set displayName for Postoperative Diagnosis Support Order here] off begin
				displayName: 'Postoperative Diagnosis Support Order',
				// % protected region % [Set displayName for Postoperative Diagnosis Support Order here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Postoperative Diagnosis Support Order here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Postoperative Diagnosis Support Order here] end
				// % protected region % [Set isSensitive for Postoperative Diagnosis Support Order here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Postoperative Diagnosis Support Order here] end
				// % protected region % [Set readonly for Postoperative Diagnosis Support Order here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Postoperative Diagnosis Support Order here] end
				validators: [
					// % protected region % [Add other validators for Postoperative Diagnosis Support Order here] off begin
					// % protected region % [Add other validators for Postoperative Diagnosis Support Order here] end
				],
				// % protected region % [Add any additional model attribute properties for Postoperative Diagnosis Support Order here] off begin
				// % protected region % [Add any additional model attribute properties for Postoperative Diagnosis Support Order here] end
			},
			{
				name: 'anesthesiaPostoperativeMonitoring',
				// % protected region % [Set displayName for Anesthesia Postoperative Monitoring here] off begin
				displayName: 'Anesthesia Postoperative Monitoring',
				// % protected region % [Set displayName for Anesthesia Postoperative Monitoring here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Anesthesia Postoperative Monitoring here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Anesthesia Postoperative Monitoring here] end
				// % protected region % [Set isSensitive for Anesthesia Postoperative Monitoring here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Postoperative Monitoring here] end
				// % protected region % [Set readonly for Anesthesia Postoperative Monitoring here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Postoperative Monitoring here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Postoperative Monitoring here] off begin
					// % protected region % [Add other validators for Anesthesia Postoperative Monitoring here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Postoperative Monitoring here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Postoperative Monitoring here] end
			},
			{
				name: 'anesthesiaPostoperativeAction',
				// % protected region % [Set displayName for Anesthesia Postoperative Action here] off begin
				displayName: 'Anesthesia Postoperative Action',
				// % protected region % [Set displayName for Anesthesia Postoperative Action here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Anesthesia Postoperative Action here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Anesthesia Postoperative Action here] end
				// % protected region % [Set isSensitive for Anesthesia Postoperative Action here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Anesthesia Postoperative Action here] end
				// % protected region % [Set readonly for Anesthesia Postoperative Action here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Anesthesia Postoperative Action here] end
				validators: [
					// % protected region % [Add other validators for Anesthesia Postoperative Action here] off begin
					// % protected region % [Add other validators for Anesthesia Postoperative Action here] end
				],
				// % protected region % [Add any additional model attribute properties for Anesthesia Postoperative Action here] off begin
				// % protected region % [Add any additional model attribute properties for Anesthesia Postoperative Action here] end
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
				id: 'postOperativeICD10',
				type: ModelRelationType.ONE,
				name: 'postOperativeICD10Id',
				// % protected region % [Customise your label for Post Operative ICD 10 here] off begin
				label: 'Post Operative ICD 10',
				// % protected region % [Customise your label for Post Operative ICD 10 here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for Post Operative ICD 10 here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for Post Operative ICD 10 here] end
				validators: [
					// % protected region % [Add other validators for Post Operative ICD 10 here] off begin
					// % protected region % [Add other validators for Post Operative ICD 10 here] end
				],
				// % protected region % [Add any additional field for relation Post Operative ICD 10 here] off begin
				// % protected region % [Add any additional field for relation Post Operative ICD 10 here] end
			},
			{
				id: 'postOperativeICD9CM',
				type: ModelRelationType.ONE,
				name: 'postOperativeICD9CMId',
				// % protected region % [Customise your label for Post Operative ICD 9 CM here] off begin
				label: 'Post Operative ICD 9 CM',
				// % protected region % [Customise your label for Post Operative ICD 9 CM here] end
				entityName: 'DiagnosesAndProceduresModel',
				// % protected region % [Customise your display name for Post Operative ICD 9 CM here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'itemType',
				// % protected region % [Customise your display name for Post Operative ICD 9 CM here] end
				validators: [
					// % protected region % [Add other validators for Post Operative ICD 9 CM here] off begin
					// % protected region % [Add other validators for Post Operative ICD 9 CM here] end
				],
				// % protected region % [Add any additional field for relation Post Operative ICD 9 CM here] off begin
				// % protected region % [Add any additional field for relation Post Operative ICD 9 CM here] end
			},
			{
				id: 'recoveryRooms',
				type: ModelRelationType.ONE,
				name: 'recoveryRoomsId',
				// % protected region % [Customise your label for Recovery Rooms here] off begin
				label: 'Recovery Rooms',
				// % protected region % [Customise your label for Recovery Rooms here] end
				entityName: 'RoomFacilityModel',
				// % protected region % [Customise your display name for Recovery Rooms here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'roomNumber',
				// % protected region % [Customise your display name for Recovery Rooms here] end
				validators: [
					// % protected region % [Add other validators for Recovery Rooms here] off begin
					// % protected region % [Add other validators for Recovery Rooms here] end
				],
				// % protected region % [Add any additional field for relation Recovery Rooms here] off begin
				// % protected region % [Add any additional field for relation Recovery Rooms here] end
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
	static deepParse(data: string | { [K in keyof PostOperativeDetailsModel]?: PostOperativeDetailsModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PostOperativeDetailsModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to one
		if (json.operatingTheaterMedicalExaminationRecord) {
			currentModel.operatingTheaterMedicalExaminationRecordId = json.operatingTheaterMedicalExaminationRecord.id;
			returned = _.union(returned, OperatingTheaterMedicalExaminationRecordModel.deepParse(json.operatingTheaterMedicalExaminationRecord));
		}

		// Incoming one to many
		if (json.postOperativeICD10) {
			currentModel.postOperativeICD10Id = json.postOperativeICD10.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.postOperativeICD10));
		}

		// Incoming one to many
		if (json.postOperativeICD9CM) {
			currentModel.postOperativeICD9CMId = json.postOperativeICD9CM.id;
			returned = _.union(returned, DiagnosesAndProceduresModel.deepParse(json.postOperativeICD9CM));
		}

		// Incoming one to many
		if (json.recoveryRooms) {
			currentModel.recoveryRoomsId = json.recoveryRooms.id;
			returned = _.union(returned, RoomFacilityModel.deepParse(json.recoveryRooms));
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
	 * `let postOperativeDetailsModel = new PostOperativeDetailsModel(data);`
	 *
	 * @param data The input data to be initialised as the PostOperativeDetailsModel,
	 *    it is expected as a JSON string or as a nullable PostOperativeDetailsModel.
	 */
	constructor(data?: string | Partial<PostOperativeDetailsModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PostOperativeDetailsModel>
				: data;

			if (json.recoveryStartDateTime) {
				this.recoveryStartDateTime = new Date(json.recoveryStartDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.recoveryStartDateTime = json.recoveryStartDateTime;
			}
			if (json.recoveryEndDateTime) {
				this.recoveryEndDateTime = new Date(json.recoveryEndDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.recoveryEndDateTime = json.recoveryEndDateTime;
			}
			this.postoperativeMainDiagnosis = json.postoperativeMainDiagnosis;
			this.postoperativeAction = json.postoperativeAction;
			this.newCase = json.newCase;
			this.postoperativeDiagnosisSupportOrder = json.postoperativeDiagnosisSupportOrder;
			this.anesthesiaPostoperativeMonitoring = json.anesthesiaPostoperativeMonitoring;
			this.anesthesiaPostoperativeAction = json.anesthesiaPostoperativeAction;
			this.operatingTheaterMedicalExaminationRecordId = json.operatingTheaterMedicalExaminationRecordId;
			this.operatingTheaterMedicalExaminationRecord = json.operatingTheaterMedicalExaminationRecord;
			this.postOperativeICD10Id = json.postOperativeICD10Id;
			this.postOperativeICD10 = json.postOperativeICD10;
			this.postOperativeICD9CMId = json.postOperativeICD9CMId;
			this.postOperativeICD9CM = json.postOperativeICD9CM;
			this.recoveryRoomsId = json.recoveryRoomsId;
			this.recoveryRooms = json.recoveryRooms;
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
			recoveryStartDateTime: this.recoveryStartDateTime,
			recoveryEndDateTime: this.recoveryEndDateTime,
			postoperativeMainDiagnosis: this.postoperativeMainDiagnosis,
			postoperativeAction: this.postoperativeAction,
			newCase: this.newCase,
			postoperativeDiagnosisSupportOrder: this.postoperativeDiagnosisSupportOrder,
			anesthesiaPostoperativeMonitoring: this.anesthesiaPostoperativeMonitoring,
			anesthesiaPostoperativeAction: this.anesthesiaPostoperativeAction,
			operatingTheaterMedicalExaminationRecordId: this.operatingTheaterMedicalExaminationRecordId,
			postOperativeICD10Id: this.postOperativeICD10Id,
			postOperativeICD9CMId: this.postOperativeICD9CMId,
			recoveryRoomsId: this.recoveryRoomsId,
			bedFacilitiesIds: this.bedFacilitiesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PostOperativeDetailsModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PostOperativeDetailsModel {
		let newModelJson = this.toJSON();

		if (updates.recoveryStartDateTime) {
			newModelJson.recoveryStartDateTime = updates.recoveryStartDateTime;
		}

		if (updates.recoveryEndDateTime) {
			newModelJson.recoveryEndDateTime = updates.recoveryEndDateTime;
		}

		if (updates.postoperativeMainDiagnosis) {
			newModelJson.postoperativeMainDiagnosis = updates.postoperativeMainDiagnosis;
		}

		if (updates.postoperativeAction) {
			newModelJson.postoperativeAction = updates.postoperativeAction;
		}

		if (updates.newCase) {
			newModelJson.newCase = updates.newCase;
		}

		if (updates.postoperativeDiagnosisSupportOrder) {
			newModelJson.postoperativeDiagnosisSupportOrder = updates.postoperativeDiagnosisSupportOrder;
		}

		if (updates.anesthesiaPostoperativeMonitoring) {
			newModelJson.anesthesiaPostoperativeMonitoring = updates.anesthesiaPostoperativeMonitoring;
		}

		if (updates.anesthesiaPostoperativeAction) {
			newModelJson.anesthesiaPostoperativeAction = updates.anesthesiaPostoperativeAction;
		}

		if (updates.operatingTheaterMedicalExaminationRecordId) {
			newModelJson.operatingTheaterMedicalExaminationRecordId = updates.operatingTheaterMedicalExaminationRecordId;
		}

		if (updates.postOperativeICD10Id) {
			newModelJson.postOperativeICD10Id = updates.postOperativeICD10Id;
		}

		if (updates.postOperativeICD9CMId) {
			newModelJson.postOperativeICD9CMId = updates.postOperativeICD9CMId;
		}

		if (updates.recoveryRoomsId) {
			newModelJson.recoveryRoomsId = updates.recoveryRoomsId;
		}

		if (updates.bedFacilitiesIds) {
			newModelJson.bedFacilitiesIds = updates.bedFacilitiesIds;
		}

		return new PostOperativeDetailsModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PostOperativeDetailsModel)) {
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
			'postOperativeICD10Id',
			'postOperativeICD10',
			'postOperativeICD9CMId',
			'postOperativeICD9CM',
			'recoveryRoomsId',
			'recoveryRooms',
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

		if (!this.postOperativeICD10) {
			this.postOperativeICD10Id = null;
		} else {
			this.postOperativeICD10Id = this.postOperativeICD10.id;
		}

		if (!this.postOperativeICD9CM) {
			this.postOperativeICD9CMId = null;
		} else {
			this.postOperativeICD9CMId = this.postOperativeICD9CM.id;
		}

		if (!this.recoveryRooms) {
			this.recoveryRoomsId = null;
		} else {
			this.recoveryRoomsId = this.recoveryRooms.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
