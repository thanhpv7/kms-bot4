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
import {KelasRawatEnum, kelasRawatEnumArray} from '../../enums/kelas-rawat.enum';
import {BpjsDiagnoseModel} from '../bpjsDiagnose/bpjs_diagnose.model';
import {BpjsDismissalConditionModel} from '../bpjsDismissalCondition/bpjs_dismissal_condition.model';
import {BpjsDismissalMappingModel} from '../bpjsDismissalMapping/bpjs_dismissal_mapping.model';
import {BpjsDoctorMappingModel} from '../bpjsDoctorMapping/bpjs_doctor_mapping.model';
import {BpjsHealthFacilityModel} from '../bpjsHealthFacility/bpjs_health_facility.model';
import {BpjsProcedureModel} from '../bpjsProcedure/bpjs_procedure.model';
import {BpjsServiceMappingModel} from '../bpjsServiceMapping/bpjs_service_mapping.model';
import {BpjsTreatmentRoomModel} from '../bpjsTreatmentRoom/bpjs_treatment_room.model';
import {PatientGeneralInfoModel} from '../patientGeneralInfo/patient_general_info.model';
import {PatientPaymentBPJSModel} from '../patientPaymentBPJS/patient_payment_bpjs.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BpjsClaimSubmissionModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'sepNo',
		'admissionDate',
		'dismissalDate',
		'insuranceProvider',
		'treatmentType',
		'followUpPlan',
		'controlDate',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'sepNo',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BpjsClaimSubmissionModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BpjsClaimSubmissionModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	sepNo: string;

	/**
	 * .
	 */
	admissionDate: Date;

	/**
	 * .
	 */
	dismissalDate: Date;

	/**
	 * .
	 */
	insuranceProvider: string;

	/**
	 * .
	 */
	treatmentType: string;

	/**
	 * .
	 */
	followUpPlan: string;

	/**
	 * .
	 */
	controlDate: Date;

	/**
	 * .
	 */
	additionalDiagnosis: string;

	/**
	 * .
	 */
	additionalProcedure: string;

	/**
	 * EolMap {docoDescription=TODO: Get doco description, springFoxDataTypeProperty=, position=11, example=Sally}.
	 */
	kelasRawat: KelasRawatEnum;

	bpjsDiagnoseId: string;

	bpjsDiagnose: BpjsDiagnoseModel;

	bpjsDoctorMappingId: string;

	bpjsDoctorMapping: BpjsDoctorMappingModel;

	bpjsHealthFacilityId: string;

	bpjsHealthFacility: BpjsHealthFacilityModel;

	bpjsProcedureId: string;

	bpjsProcedure: BpjsProcedureModel;

	bpjsServiceMappingId: string;

	bpjsServiceMapping: BpjsServiceMappingModel;

	patientGeneralInfoId: string;

	patientGeneralInfo: PatientGeneralInfoModel;

	patientPaymentBPJSId: string;

	patientPaymentBPJS: PatientPaymentBPJSModel;

	bpjsDismissalConditionsIds: string[] = [];

	bpjsDismissalConditions: BpjsDismissalConditionModel[];

	bpjsDismissalMappingsIds: string[] = [];

	bpjsDismissalMappings: BpjsDismissalMappingModel[];

	bpjsTreatmentRoomsIds: string[] = [];

	bpjsTreatmentRooms: BpjsTreatmentRoomModel[];

	modelPropGroups: { [s: string]: Group } = BpjsClaimSubmissionModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'sepNo',
				// % protected region % [Set displayName for SEP No here] off begin
				displayName: 'SEP No',
				// % protected region % [Set displayName for SEP No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for SEP No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for SEP No here] end
				// % protected region % [Set isSensitive for SEP No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for SEP No here] end
				// % protected region % [Set readonly for SEP No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for SEP No here] end
				validators: [
					// % protected region % [Add other validators for SEP No here] off begin
					// % protected region % [Add other validators for SEP No here] end
				],
				// % protected region % [Add any additional model attribute properties for SEP No here] off begin
				// % protected region % [Add any additional model attribute properties for SEP No here] end
			},
			{
				name: 'admissionDate',
				// % protected region % [Set displayName for Admission Date here] off begin
				displayName: 'Admission Date',
				// % protected region % [Set displayName for Admission Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Admission Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Admission Date here] end
				// % protected region % [Set isSensitive for Admission Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Admission Date here] end
				// % protected region % [Set readonly for Admission Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Admission Date here] end
				validators: [
					// % protected region % [Add other validators for Admission Date here] off begin
					// % protected region % [Add other validators for Admission Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Admission Date here] off begin
				// % protected region % [Add any additional model attribute properties for Admission Date here] end
			},
			{
				name: 'dismissalDate',
				// % protected region % [Set displayName for Dismissal Date here] off begin
				displayName: 'Dismissal Date',
				// % protected region % [Set displayName for Dismissal Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Dismissal Date here] off begin
				elementType: ElementType.DATE,
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
			{
				name: 'insuranceProvider',
				// % protected region % [Set displayName for Insurance Provider here] off begin
				displayName: 'Insurance Provider',
				// % protected region % [Set displayName for Insurance Provider here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Insurance Provider here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Insurance Provider here] end
				// % protected region % [Set isSensitive for Insurance Provider here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Insurance Provider here] end
				// % protected region % [Set readonly for Insurance Provider here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Insurance Provider here] end
				validators: [
					// % protected region % [Add other validators for Insurance Provider here] off begin
					// % protected region % [Add other validators for Insurance Provider here] end
				],
				// % protected region % [Add any additional model attribute properties for Insurance Provider here] off begin
				// % protected region % [Add any additional model attribute properties for Insurance Provider here] end
			},
			{
				name: 'treatmentType',
				// % protected region % [Set displayName for Treatment Type here] off begin
				displayName: 'Treatment Type',
				// % protected region % [Set displayName for Treatment Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Type here] end
				// % protected region % [Set isSensitive for Treatment Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Type here] end
				// % protected region % [Set readonly for Treatment Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Type here] end
				validators: [
					// % protected region % [Add other validators for Treatment Type here] off begin
					// % protected region % [Add other validators for Treatment Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Type here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Type here] end
			},
			{
				name: 'followUpPlan',
				// % protected region % [Set displayName for Follow Up Plan here] off begin
				displayName: 'Follow Up Plan',
				// % protected region % [Set displayName for Follow Up Plan here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Follow Up Plan here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Follow Up Plan here] end
				// % protected region % [Set isSensitive for Follow Up Plan here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Follow Up Plan here] end
				// % protected region % [Set readonly for Follow Up Plan here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Follow Up Plan here] end
				validators: [
					// % protected region % [Add other validators for Follow Up Plan here] off begin
					// % protected region % [Add other validators for Follow Up Plan here] end
				],
				// % protected region % [Add any additional model attribute properties for Follow Up Plan here] off begin
				// % protected region % [Add any additional model attribute properties for Follow Up Plan here] end
			},
			{
				name: 'controlDate',
				// % protected region % [Set displayName for Control Date here] off begin
				displayName: 'Control Date',
				// % protected region % [Set displayName for Control Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Control Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Control Date here] end
				// % protected region % [Set isSensitive for Control Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Control Date here] end
				// % protected region % [Set readonly for Control Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Control Date here] end
				validators: [
					// % protected region % [Add other validators for Control Date here] off begin
					// % protected region % [Add other validators for Control Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Control Date here] off begin
				// % protected region % [Add any additional model attribute properties for Control Date here] end
			},
			{
				name: 'additionalDiagnosis',
				// % protected region % [Set displayName for Additional Diagnosis here] off begin
				displayName: 'Additional Diagnosis',
				// % protected region % [Set displayName for Additional Diagnosis here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Additional Diagnosis here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Additional Diagnosis here] end
				// % protected region % [Set isSensitive for Additional Diagnosis here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Additional Diagnosis here] end
				// % protected region % [Set readonly for Additional Diagnosis here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Additional Diagnosis here] end
				validators: [
					// % protected region % [Add other validators for Additional Diagnosis here] off begin
					// % protected region % [Add other validators for Additional Diagnosis here] end
				],
				// % protected region % [Add any additional model attribute properties for Additional Diagnosis here] off begin
				// % protected region % [Add any additional model attribute properties for Additional Diagnosis here] end
			},
			{
				name: 'additionalProcedure',
				// % protected region % [Set displayName for Additional Procedure here] off begin
				displayName: 'Additional Procedure',
				// % protected region % [Set displayName for Additional Procedure here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Additional Procedure here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Additional Procedure here] end
				// % protected region % [Set isSensitive for Additional Procedure here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Additional Procedure here] end
				// % protected region % [Set readonly for Additional Procedure here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Additional Procedure here] end
				validators: [
					// % protected region % [Add other validators for Additional Procedure here] off begin
					// % protected region % [Add other validators for Additional Procedure here] end
				],
				// % protected region % [Add any additional model attribute properties for Additional Procedure here] off begin
				// % protected region % [Add any additional model attribute properties for Additional Procedure here] end
			},
			{
				name: 'kelasRawat',
				// % protected region % [Set displayName for Kelas Rawat here] off begin
				displayName: 'Kelas Rawat',
				// % protected region % [Set displayName for Kelas Rawat here] end
				type: ModelPropertyType.ENUM,
				enumLiterals: kelasRawatEnumArray,
				// % protected region % [Set display element type for Kelas Rawat here] off begin
				elementType: ElementType.ENUM,
				// % protected region % [Set display element type for Kelas Rawat here] end
				// % protected region % [Set isSensitive for Kelas Rawat here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Kelas Rawat here] end
				// % protected region % [Set readonly for Kelas Rawat here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Kelas Rawat here] end
				validators: [
					// % protected region % [Add other validators for Kelas Rawat here] off begin
					// % protected region % [Add other validators for Kelas Rawat here] end
				],
				// % protected region % [Add any additional model attribute properties for Kelas Rawat here] off begin
				// % protected region % [Add any additional model attribute properties for Kelas Rawat here] end
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
				id: 'bpjsDismissalConditions',
				type: ModelRelationType.MANY,
				name: 'bpjsDismissalConditionsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Dismissal Conditions here] off begin
				label: 'BPJS Dismissal Conditions',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Dismissal Conditions here] end
				entityName: 'BpjsDismissalConditionModel',
				// % protected region % [Customise your display name for BPJS Dismissal Conditions here] off begin
				displayName: 'conditionName',
				// % protected region % [Customise your display name for BPJS Dismissal Conditions here] end
				validators: [
					// % protected region % [Add other validators for BPJS Dismissal Conditions here] off begin
					// % protected region % [Add other validators for BPJS Dismissal Conditions here] end
				],
				// % protected region % [Add any additional field for relation BPJS Dismissal Conditions here] off begin
				// % protected region % [Add any additional field for relation BPJS Dismissal Conditions here] end
			},
			{
				id: 'bpjsDismissalMappings',
				type: ModelRelationType.MANY,
				name: 'bpjsDismissalMappingsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Dismissal Mappings here] off begin
				label: 'BPJS Dismissal Mappings',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Dismissal Mappings here] end
				entityName: 'BpjsDismissalMappingModel',
				// % protected region % [Customise your display name for BPJS Dismissal Mappings here] off begin
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Dismissal Mappings here] end
				validators: [
					// % protected region % [Add other validators for BPJS Dismissal Mappings here] off begin
					// % protected region % [Add other validators for BPJS Dismissal Mappings here] end
				],
				// % protected region % [Add any additional field for relation BPJS Dismissal Mappings here] off begin
				// % protected region % [Add any additional field for relation BPJS Dismissal Mappings here] end
			},
			{
				id: 'bpjsTreatmentRooms',
				type: ModelRelationType.MANY,
				name: 'bpjsTreatmentRoomsIds',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Treatment Rooms here] off begin
				label: 'BPJS Treatment Rooms',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Treatment Rooms here] end
				entityName: 'BpjsTreatmentRoomModel',
				// % protected region % [Customise your display name for BPJS Treatment Rooms here] off begin
				displayName: 'kode',
				// % protected region % [Customise your display name for BPJS Treatment Rooms here] end
				validators: [
					// % protected region % [Add other validators for BPJS Treatment Rooms here] off begin
					// % protected region % [Add other validators for BPJS Treatment Rooms here] end
				],
				// % protected region % [Add any additional field for relation BPJS Treatment Rooms here] off begin
				// % protected region % [Add any additional field for relation BPJS Treatment Rooms here] end
			},
			{
				id: 'bpjsDiagnose',
				type: ModelRelationType.ONE,
				name: 'bpjsDiagnoseId',
				// % protected region % [Customise your label for BPJS Diagnose here] off begin
				label: 'BPJS Diagnose',
				// % protected region % [Customise your label for BPJS Diagnose here] end
				entityName: 'BpjsDiagnoseModel',
				// % protected region % [Customise your display name for BPJS Diagnose here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Diagnose here] end
				validators: [
					// % protected region % [Add other validators for BPJS Diagnose here] off begin
					// % protected region % [Add other validators for BPJS Diagnose here] end
				],
				// % protected region % [Add any additional field for relation BPJS Diagnose here] off begin
				// % protected region % [Add any additional field for relation BPJS Diagnose here] end
			},
			{
				id: 'bpjsDoctorMapping',
				type: ModelRelationType.ONE,
				name: 'bpjsDoctorMappingId',
				// % protected region % [Customise your label for BPJS Doctor Mapping here] off begin
				label: 'BPJS Doctor Mapping',
				// % protected region % [Customise your label for BPJS Doctor Mapping here] end
				entityName: 'BpjsDoctorMappingModel',
				// % protected region % [Customise your display name for BPJS Doctor Mapping here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Doctor Mapping here] end
				validators: [
					// % protected region % [Add other validators for BPJS Doctor Mapping here] off begin
					// % protected region % [Add other validators for BPJS Doctor Mapping here] end
				],
				// % protected region % [Add any additional field for relation BPJS Doctor Mapping here] off begin
				// % protected region % [Add any additional field for relation BPJS Doctor Mapping here] end
			},
			{
				id: 'bpjsHealthFacility',
				type: ModelRelationType.ONE,
				name: 'bpjsHealthFacilityId',
				// % protected region % [Customise your label for BPJS Health Facility here] off begin
				label: 'BPJS Health Facility',
				// % protected region % [Customise your label for BPJS Health Facility here] end
				entityName: 'BpjsHealthFacilityModel',
				// % protected region % [Customise your display name for BPJS Health Facility here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Health Facility here] end
				validators: [
					// % protected region % [Add other validators for BPJS Health Facility here] off begin
					// % protected region % [Add other validators for BPJS Health Facility here] end
				],
				// % protected region % [Add any additional field for relation BPJS Health Facility here] off begin
				// % protected region % [Add any additional field for relation BPJS Health Facility here] end
			},
			{
				id: 'bpjsProcedure',
				type: ModelRelationType.ONE,
				name: 'bpjsProcedureId',
				// % protected region % [Customise your label for BPJS Procedure here] off begin
				label: 'BPJS Procedure',
				// % protected region % [Customise your label for BPJS Procedure here] end
				entityName: 'BpjsProcedureModel',
				// % protected region % [Customise your display name for BPJS Procedure here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'procedureCode',
				// % protected region % [Customise your display name for BPJS Procedure here] end
				validators: [
					// % protected region % [Add other validators for BPJS Procedure here] off begin
					// % protected region % [Add other validators for BPJS Procedure here] end
				],
				// % protected region % [Add any additional field for relation BPJS Procedure here] off begin
				// % protected region % [Add any additional field for relation BPJS Procedure here] end
			},
			{
				id: 'bpjsServiceMapping',
				type: ModelRelationType.ONE,
				name: 'bpjsServiceMappingId',
				// % protected region % [Customise your label for BPJS Service Mapping here] off begin
				label: 'BPJS Service Mapping',
				// % protected region % [Customise your label for BPJS Service Mapping here] end
				entityName: 'BpjsServiceMappingModel',
				// % protected region % [Customise your display name for BPJS Service Mapping here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'refCode',
				// % protected region % [Customise your display name for BPJS Service Mapping here] end
				validators: [
					// % protected region % [Add other validators for BPJS Service Mapping here] off begin
					// % protected region % [Add other validators for BPJS Service Mapping here] end
				],
				// % protected region % [Add any additional field for relation BPJS Service Mapping here] off begin
				// % protected region % [Add any additional field for relation BPJS Service Mapping here] end
			},
			{
				id: 'patientGeneralInfo',
				type: ModelRelationType.ONE,
				name: 'patientGeneralInfoId',
				// % protected region % [Customise your label for Patient General Info here] off begin
				label: 'Patient General Info',
				// % protected region % [Customise your label for Patient General Info here] end
				entityName: 'PatientGeneralInfoModel',
				// % protected region % [Customise your display name for Patient General Info here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientID',
				// % protected region % [Customise your display name for Patient General Info here] end
				validators: [
					// % protected region % [Add other validators for Patient General Info here] off begin
					// % protected region % [Add other validators for Patient General Info here] end
				],
				// % protected region % [Add any additional field for relation Patient General Info here] off begin
				// % protected region % [Add any additional field for relation Patient General Info here] end
			},
			{
				id: 'patientPaymentBPJS',
				type: ModelRelationType.ONE,
				name: 'patientPaymentBPJSId',
				// % protected region % [Customise your label for Patient Payment BPJS here] off begin
				label: 'Patient Payment BPJS',
				// % protected region % [Customise your label for Patient Payment BPJS here] end
				entityName: 'PatientPaymentBPJSModel',
				// % protected region % [Customise your display name for Patient Payment BPJS here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'bpjsCardNo',
				// % protected region % [Customise your display name for Patient Payment BPJS here] end
				validators: [
					// % protected region % [Add other validators for Patient Payment BPJS here] off begin
					// % protected region % [Add other validators for Patient Payment BPJS here] end
				],
				// % protected region % [Add any additional field for relation Patient Payment BPJS here] off begin
				// % protected region % [Add any additional field for relation Patient Payment BPJS here] end
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
				case 'sepNo':
					break;
				case 'admissionDate':
					break;
				case 'dismissalDate':
					break;
				case 'insuranceProvider':
					break;
				case 'treatmentType':
					break;
				case 'followUpPlan':
					break;
				case 'controlDate':
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
	static deepParse(data: string | { [K in keyof BpjsClaimSubmissionModel]?: BpjsClaimSubmissionModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BpjsClaimSubmissionModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.bpjsDiagnose) {
			currentModel.bpjsDiagnoseId = json.bpjsDiagnose.id;
			returned = _.union(returned, BpjsDiagnoseModel.deepParse(json.bpjsDiagnose));
		}

		// Incoming one to many
		if (json.bpjsDoctorMapping) {
			currentModel.bpjsDoctorMappingId = json.bpjsDoctorMapping.id;
			returned = _.union(returned, BpjsDoctorMappingModel.deepParse(json.bpjsDoctorMapping));
		}

		// Incoming one to many
		if (json.bpjsHealthFacility) {
			currentModel.bpjsHealthFacilityId = json.bpjsHealthFacility.id;
			returned = _.union(returned, BpjsHealthFacilityModel.deepParse(json.bpjsHealthFacility));
		}

		// Incoming one to many
		if (json.bpjsProcedure) {
			currentModel.bpjsProcedureId = json.bpjsProcedure.id;
			returned = _.union(returned, BpjsProcedureModel.deepParse(json.bpjsProcedure));
		}

		// Incoming one to many
		if (json.bpjsServiceMapping) {
			currentModel.bpjsServiceMappingId = json.bpjsServiceMapping.id;
			returned = _.union(returned, BpjsServiceMappingModel.deepParse(json.bpjsServiceMapping));
		}

		// Incoming one to many
		if (json.patientGeneralInfo) {
			currentModel.patientGeneralInfoId = json.patientGeneralInfo.id;
			returned = _.union(returned, PatientGeneralInfoModel.deepParse(json.patientGeneralInfo));
		}

		// Incoming one to many
		if (json.patientPaymentBPJS) {
			currentModel.patientPaymentBPJSId = json.patientPaymentBPJS.id;
			returned = _.union(returned, PatientPaymentBPJSModel.deepParse(json.patientPaymentBPJS));
		}

		// Outgoing one to many
		if (json.bpjsDismissalConditions) {
			currentModel.bpjsDismissalConditionsIds = json.bpjsDismissalConditions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsDismissalConditions.map(model => BpjsDismissalConditionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsDismissalMappings) {
			currentModel.bpjsDismissalMappingsIds = json.bpjsDismissalMappings.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsDismissalMappings.map(model => BpjsDismissalMappingModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.bpjsTreatmentRooms) {
			currentModel.bpjsTreatmentRoomsIds = json.bpjsTreatmentRooms.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bpjsTreatmentRooms.map(model => BpjsTreatmentRoomModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bpjsClaimSubmissionModel = new BpjsClaimSubmissionModel(data);`
	 *
	 * @param data The input data to be initialised as the BpjsClaimSubmissionModel,
	 *    it is expected as a JSON string or as a nullable BpjsClaimSubmissionModel.
	 */
	constructor(data?: string | Partial<BpjsClaimSubmissionModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BpjsClaimSubmissionModel>
				: data;

			this.sepNo = json.sepNo;
			if (json.admissionDate) {
				this.admissionDate = new Date(json.admissionDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.admissionDate = json.admissionDate;
			}
			if (json.dismissalDate) {
				this.dismissalDate = new Date(json.dismissalDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dismissalDate = json.dismissalDate;
			}
			this.insuranceProvider = json.insuranceProvider;
			this.treatmentType = json.treatmentType;
			this.followUpPlan = json.followUpPlan;
			if (json.controlDate) {
				this.controlDate = new Date(json.controlDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.controlDate = json.controlDate;
			}
			this.additionalDiagnosis = json.additionalDiagnosis;
			this.additionalProcedure = json.additionalProcedure;
			this.kelasRawat = json.kelasRawat;
			this.kelasRawat = json.kelasRawat;
			this.bpjsDiagnoseId = json.bpjsDiagnoseId;
			this.bpjsDiagnose = json.bpjsDiagnose;
			this.bpjsDoctorMappingId = json.bpjsDoctorMappingId;
			this.bpjsDoctorMapping = json.bpjsDoctorMapping;
			this.bpjsHealthFacilityId = json.bpjsHealthFacilityId;
			this.bpjsHealthFacility = json.bpjsHealthFacility;
			this.bpjsProcedureId = json.bpjsProcedureId;
			this.bpjsProcedure = json.bpjsProcedure;
			this.bpjsServiceMappingId = json.bpjsServiceMappingId;
			this.bpjsServiceMapping = json.bpjsServiceMapping;
			this.patientGeneralInfoId = json.patientGeneralInfoId;
			this.patientGeneralInfo = json.patientGeneralInfo;
			this.patientPaymentBPJSId = json.patientPaymentBPJSId;
			this.patientPaymentBPJS = json.patientPaymentBPJS;
			this.bpjsDismissalConditionsIds = json.bpjsDismissalConditionsIds;
			this.bpjsDismissalConditions = json.bpjsDismissalConditions;
			this.bpjsDismissalMappingsIds = json.bpjsDismissalMappingsIds;
			this.bpjsDismissalMappings = json.bpjsDismissalMappings;
			this.bpjsTreatmentRoomsIds = json.bpjsTreatmentRoomsIds;
			this.bpjsTreatmentRooms = json.bpjsTreatmentRooms;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			sepNo: this.sepNo,
			admissionDate: this.admissionDate,
			dismissalDate: this.dismissalDate,
			insuranceProvider: this.insuranceProvider,
			treatmentType: this.treatmentType,
			followUpPlan: this.followUpPlan,
			controlDate: this.controlDate,
			additionalDiagnosis: this.additionalDiagnosis,
			additionalProcedure: this.additionalProcedure,
			kelasRawat: this.kelasRawat,
			bpjsDiagnoseId: this.bpjsDiagnoseId,
			bpjsDoctorMappingId: this.bpjsDoctorMappingId,
			bpjsHealthFacilityId: this.bpjsHealthFacilityId,
			bpjsProcedureId: this.bpjsProcedureId,
			bpjsServiceMappingId: this.bpjsServiceMappingId,
			patientGeneralInfoId: this.patientGeneralInfoId,
			patientPaymentBPJSId: this.patientPaymentBPJSId,
			bpjsDismissalConditionsIds: this.bpjsDismissalConditionsIds,
			bpjsDismissalMappingsIds: this.bpjsDismissalMappingsIds,
			bpjsTreatmentRoomsIds: this.bpjsTreatmentRoomsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BpjsClaimSubmissionModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BpjsClaimSubmissionModel {
		let newModelJson = this.toJSON();

		if (updates.sepNo) {
			newModelJson.sepNo = updates.sepNo;
		}

		if (updates.admissionDate) {
			newModelJson.admissionDate = updates.admissionDate;
		}

		if (updates.dismissalDate) {
			newModelJson.dismissalDate = updates.dismissalDate;
		}

		if (updates.insuranceProvider) {
			newModelJson.insuranceProvider = updates.insuranceProvider;
		}

		if (updates.treatmentType) {
			newModelJson.treatmentType = updates.treatmentType;
		}

		if (updates.followUpPlan) {
			newModelJson.followUpPlan = updates.followUpPlan;
		}

		if (updates.controlDate) {
			newModelJson.controlDate = updates.controlDate;
		}

		if (updates.additionalDiagnosis) {
			newModelJson.additionalDiagnosis = updates.additionalDiagnosis;
		}

		if (updates.additionalProcedure) {
			newModelJson.additionalProcedure = updates.additionalProcedure;
		}

		if (updates.kelasRawat) {
			newModelJson.kelasRawat = updates.kelasRawat;
		}

		if (updates.kelasRawat) {
			newModelJson.kelasRawat = updates.kelasRawat;
		}

		if (updates.bpjsDiagnoseId) {
			newModelJson.bpjsDiagnoseId = updates.bpjsDiagnoseId;
		}

		if (updates.bpjsDoctorMappingId) {
			newModelJson.bpjsDoctorMappingId = updates.bpjsDoctorMappingId;
		}

		if (updates.bpjsHealthFacilityId) {
			newModelJson.bpjsHealthFacilityId = updates.bpjsHealthFacilityId;
		}

		if (updates.bpjsProcedureId) {
			newModelJson.bpjsProcedureId = updates.bpjsProcedureId;
		}

		if (updates.bpjsServiceMappingId) {
			newModelJson.bpjsServiceMappingId = updates.bpjsServiceMappingId;
		}

		if (updates.patientGeneralInfoId) {
			newModelJson.patientGeneralInfoId = updates.patientGeneralInfoId;
		}

		if (updates.patientPaymentBPJSId) {
			newModelJson.patientPaymentBPJSId = updates.patientPaymentBPJSId;
		}

		if (updates.bpjsDismissalConditionsIds) {
			newModelJson.bpjsDismissalConditionsIds = updates.bpjsDismissalConditionsIds;
		}

		if (updates.bpjsDismissalMappingsIds) {
			newModelJson.bpjsDismissalMappingsIds = updates.bpjsDismissalMappingsIds;
		}

		if (updates.bpjsTreatmentRoomsIds) {
			newModelJson.bpjsTreatmentRoomsIds = updates.bpjsTreatmentRoomsIds;
		}

		return new BpjsClaimSubmissionModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BpjsClaimSubmissionModel)) {
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
			'bpjsDiagnoseId',
			'bpjsDiagnose',
			'bpjsDoctorMappingId',
			'bpjsDoctorMapping',
			'bpjsHealthFacilityId',
			'bpjsHealthFacility',
			'bpjsProcedureId',
			'bpjsProcedure',
			'bpjsServiceMappingId',
			'bpjsServiceMapping',
			'patientGeneralInfoId',
			'patientGeneralInfo',
			'patientPaymentBPJSId',
			'patientPaymentBPJS',
			'bpjsDismissalConditionsIds',
			'bpjsDismissalConditions',
			'bpjsDismissalMappingsIds',
			'bpjsDismissalMappings',
			'bpjsTreatmentRoomsIds',
			'bpjsTreatmentRooms',
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
		if (!this.bpjsDiagnose) {
			this.bpjsDiagnoseId = null;
		} else {
			this.bpjsDiagnoseId = this.bpjsDiagnose.id;
		}

		if (!this.bpjsDoctorMapping) {
			this.bpjsDoctorMappingId = null;
		} else {
			this.bpjsDoctorMappingId = this.bpjsDoctorMapping.id;
		}

		if (!this.bpjsHealthFacility) {
			this.bpjsHealthFacilityId = null;
		} else {
			this.bpjsHealthFacilityId = this.bpjsHealthFacility.id;
		}

		if (!this.bpjsProcedure) {
			this.bpjsProcedureId = null;
		} else {
			this.bpjsProcedureId = this.bpjsProcedure.id;
		}

		if (!this.bpjsServiceMapping) {
			this.bpjsServiceMappingId = null;
		} else {
			this.bpjsServiceMappingId = this.bpjsServiceMapping.id;
		}

		if (!this.patientGeneralInfo) {
			this.patientGeneralInfoId = null;
		} else {
			this.patientGeneralInfoId = this.patientGeneralInfo.id;
		}

		if (!this.patientPaymentBPJS) {
			this.patientPaymentBPJSId = null;
		} else {
			this.patientPaymentBPJSId = this.patientPaymentBPJS.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
