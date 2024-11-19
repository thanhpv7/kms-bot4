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
import {BpjsPcarePoliModel} from '../bpjsPcarePoli/bpjs_pcare_poli.model';
import {BpjsServiceMappingModel} from '../bpjsServiceMapping/bpjs_service_mapping.model';
import {DoctorScheduleModel} from '../doctorSchedule/doctor_schedule.model';
import {ExaminationGroupModel} from '../examinationGroup/examination_group.model';
import {McuPackageItemModel} from '../mcuPackageItem/mcu_package_item.model';
import {RegistrationModel} from '../registration/registration.model';
import {ServiceFacilityCategoryModel} from '../serviceFacilityCategory/service_facility_category.model';
import {ServiceItemModel} from '../serviceItem/service_item.model';
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
export class ServiceModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'serviceName',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'serviceNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'ServiceModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return ServiceModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Service Number (Max Length: 50).
	 */
	serviceNumber: string;

	/**
	 * Service description/Name (Max Length: 250).
	 */
	serviceName: string;

	/**
	 * The code of section, as reference of group from several similar services, get the Code from Reference Data where Type=SEC_CODE. (Max Length: 20).
	 */
	sectionCode: string;

	/**
	 * Flag to indicate that the service can be registered to patient without doctor assignment (Default value: FALSE).
	 */
	byPassDoctorAssignment: boolean = false;

	/**
	 * an indicator whether the Service has detail Examination item to be registered or examined.
	 */
	hasExaminationItem: boolean = false;

	/**
	 * .
	 */
	revenueCenter: string;

	/**
	 * Mapping the existing service with new service.
	 */
	serviceCode: string;

	bpjsPcarePoliId: string;

	bpjsPcarePoli: BpjsPcarePoliModel;

	bpjsServiceMappingId: string;

	bpjsServiceMapping: BpjsServiceMappingModel;

	defaultMedicalStaffId: string;

	defaultMedicalStaff: StaffModel;

	doctorSchedulesIds: string[] = [];

	doctorSchedules: DoctorScheduleModel[];

	examinationGroupsIds: string[] = [];

	examinationGroups: ExaminationGroupModel[];

	mcuPackageItemsIds: string[] = [];

	mcuPackageItems: McuPackageItemModel[];

	referringUnitIds: string[] = [];

	referringUnit: RegistrationModel[];

	registrationsIds: string[] = [];

	registrations: RegistrationModel[];

	serviceFacilityCategoriesIds: string[] = [];

	serviceFacilityCategories: ServiceFacilityCategoryModel[];

	serviceItemsIds: string[] = [];

	serviceItems: ServiceItemModel[];

	assignedMedicalStaffIds: string[] = [];

	assignedMedicalStaff: StaffModel[];

	modelPropGroups: { [s: string]: Group } = ServiceModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'serviceNumber',
				// % protected region % [Set displayName for Service Number here] off begin
				displayName: 'Service Number',
				// % protected region % [Set displayName for Service Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Service Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Service Number here] end
				// % protected region % [Set isSensitive for Service Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Service Number here] end
				// % protected region % [Set readonly for Service Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Service Number here] end
				validators: [
					// % protected region % [Add other validators for Service Number here] off begin
					// % protected region % [Add other validators for Service Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Service Number here] off begin
				// % protected region % [Add any additional model attribute properties for Service Number here] end
			},
			{
				name: 'serviceName',
				// % protected region % [Set displayName for Service Name here] off begin
				displayName: 'Service Name',
				// % protected region % [Set displayName for Service Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Service Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Service Name here] end
				// % protected region % [Set isSensitive for Service Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Service Name here] end
				// % protected region % [Set readonly for Service Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Service Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Service Name here] off begin
					// % protected region % [Add other validators for Service Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Service Name here] off begin
				// % protected region % [Add any additional model attribute properties for Service Name here] end
			},
			{
				name: 'sectionCode',
				// % protected region % [Set displayName for Section Code here] off begin
				displayName: 'Section Code',
				// % protected region % [Set displayName for Section Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Section Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Section Code here] end
				// % protected region % [Set isSensitive for Section Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Section Code here] end
				// % protected region % [Set readonly for Section Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Section Code here] end
				validators: [
					// % protected region % [Add other validators for Section Code here] off begin
					// % protected region % [Add other validators for Section Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Section Code here] off begin
				// % protected region % [Add any additional model attribute properties for Section Code here] end
			},
			{
				name: 'byPassDoctorAssignment',
				// % protected region % [Set displayName for By pass Doctor Assignment here] off begin
				displayName: 'By pass Doctor Assignment',
				// % protected region % [Set displayName for By pass Doctor Assignment here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for By pass Doctor Assignment here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for By pass Doctor Assignment here] end
				// % protected region % [Set isSensitive for By pass Doctor Assignment here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for By pass Doctor Assignment here] end
				// % protected region % [Set readonly for By pass Doctor Assignment here] off begin
				readOnly: false,
				// % protected region % [Set readonly for By pass Doctor Assignment here] end
				validators: [
					// % protected region % [Add other validators for By pass Doctor Assignment here] off begin
					// % protected region % [Add other validators for By pass Doctor Assignment here] end
				],
				// % protected region % [Add any additional model attribute properties for By pass Doctor Assignment here] off begin
				// % protected region % [Add any additional model attribute properties for By pass Doctor Assignment here] end
			},
			{
				name: 'hasExaminationItem',
				// % protected region % [Set displayName for Has Examination Item here] off begin
				displayName: 'Has Examination Item',
				// % protected region % [Set displayName for Has Examination Item here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Has Examination Item here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Has Examination Item here] end
				// % protected region % [Set isSensitive for Has Examination Item here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Has Examination Item here] end
				// % protected region % [Set readonly for Has Examination Item here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Has Examination Item here] end
				validators: [
					// % protected region % [Add other validators for Has Examination Item here] off begin
					// % protected region % [Add other validators for Has Examination Item here] end
				],
				// % protected region % [Add any additional model attribute properties for Has Examination Item here] off begin
				// % protected region % [Add any additional model attribute properties for Has Examination Item here] end
			},
			{
				name: 'revenueCenter',
				// % protected region % [Set displayName for Revenue Center here] off begin
				displayName: 'Revenue Center',
				// % protected region % [Set displayName for Revenue Center here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Revenue Center here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Revenue Center here] end
				// % protected region % [Set isSensitive for Revenue Center here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Revenue Center here] end
				// % protected region % [Set readonly for Revenue Center here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Revenue Center here] end
				validators: [
					// % protected region % [Add other validators for Revenue Center here] off begin
					// % protected region % [Add other validators for Revenue Center here] end
				],
				// % protected region % [Add any additional model attribute properties for Revenue Center here] off begin
				// % protected region % [Add any additional model attribute properties for Revenue Center here] end
			},
			{
				name: 'serviceCode',
				// % protected region % [Set displayName for Service Code here] off begin
				displayName: 'Service Code',
				// % protected region % [Set displayName for Service Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Service Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Service Code here] end
				// % protected region % [Set isSensitive for Service Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Service Code here] end
				// % protected region % [Set readonly for Service Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Service Code here] end
				validators: [
					// % protected region % [Add other validators for Service Code here] off begin
					// % protected region % [Add other validators for Service Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Service Code here] off begin
				// % protected region % [Add any additional model attribute properties for Service Code here] end
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
				id: 'bpjsPcarePoli',
				type: ModelRelationType.ONE,
				name: 'bpjsPcarePoliId',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Pcare Poli here] off begin
				label: 'BPJS Pcare Poli',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Pcare Poli here] end
				entityName: 'BpjsPcarePoliModel',
				// % protected region % [Customise your display name for BPJS Pcare Poli here] off begin
				displayName: 'kdpoli',
				// % protected region % [Customise your display name for BPJS Pcare Poli here] end
				validators: [
					// % protected region % [Add other validators for BPJS Pcare Poli here] off begin
					// % protected region % [Add other validators for BPJS Pcare Poli here] end
				],
				// % protected region % [Add any additional field for relation BPJS Pcare Poli here] off begin
				// % protected region % [Add any additional field for relation BPJS Pcare Poli here] end
			},
			{
				id: 'bpjsServiceMapping',
				type: ModelRelationType.ONE,
				name: 'bpjsServiceMappingId',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Service Mapping here] off begin
				label: 'BPJS Service Mapping',
				// % protected region % [Customise your 1-1 or 1-M label for BPJS Service Mapping here] end
				entityName: 'BpjsServiceMappingModel',
				// % protected region % [Customise your display name for BPJS Service Mapping here] off begin
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
				id: 'doctorSchedules',
				type: ModelRelationType.MANY,
				name: 'doctorSchedulesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Doctor Schedules here] off begin
				label: 'Doctor Schedules',
				// % protected region % [Customise your 1-1 or 1-M label for Doctor Schedules here] end
				entityName: 'DoctorScheduleModel',
				// % protected region % [Customise your display name for Doctor Schedules here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Doctor Schedules here] end
				validators: [
					// % protected region % [Add other validators for Doctor Schedules here] off begin
					// % protected region % [Add other validators for Doctor Schedules here] end
				],
				// % protected region % [Add any additional field for relation Doctor Schedules here] off begin
				// % protected region % [Add any additional field for relation Doctor Schedules here] end
			},
			{
				id: 'examinationGroups',
				type: ModelRelationType.MANY,
				name: 'examinationGroupsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Examination Groups here] off begin
				label: 'Examination Groups',
				// % protected region % [Customise your 1-1 or 1-M label for Examination Groups here] end
				entityName: 'ExaminationGroupModel',
				// % protected region % [Customise your display name for Examination Groups here] off begin
				displayName: 'diagnosticGroupCode',
				// % protected region % [Customise your display name for Examination Groups here] end
				validators: [
					// % protected region % [Add other validators for Examination Groups here] off begin
					// % protected region % [Add other validators for Examination Groups here] end
				],
				// % protected region % [Add any additional field for relation Examination Groups here] off begin
				// % protected region % [Add any additional field for relation Examination Groups here] end
			},
			{
				id: 'mcuPackageItems',
				type: ModelRelationType.MANY,
				name: 'mcuPackageItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for MCU Package Items here] off begin
				label: 'MCU Package Items',
				// % protected region % [Customise your 1-1 or 1-M label for MCU Package Items here] end
				entityName: 'McuPackageItemModel',
				// % protected region % [Customise your display name for MCU Package Items here] off begin
				displayName: 'itemCode',
				// % protected region % [Customise your display name for MCU Package Items here] end
				validators: [
					// % protected region % [Add other validators for MCU Package Items here] off begin
					// % protected region % [Add other validators for MCU Package Items here] end
				],
				// % protected region % [Add any additional field for relation MCU Package Items here] off begin
				// % protected region % [Add any additional field for relation MCU Package Items here] end
			},
			{
				id: 'referringUnit',
				type: ModelRelationType.MANY,
				name: 'referringUnitIds',
				// % protected region % [Customise your 1-1 or 1-M label for Referring Unit here] off begin
				label: 'Referring Unit',
				// % protected region % [Customise your 1-1 or 1-M label for Referring Unit here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Referring Unit here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Referring Unit here] end
				validators: [
					// % protected region % [Add other validators for Referring Unit here] off begin
					// % protected region % [Add other validators for Referring Unit here] end
				],
				// % protected region % [Add any additional field for relation Referring Unit here] off begin
				// % protected region % [Add any additional field for relation Referring Unit here] end
			},
			{
				id: 'registrations',
				type: ModelRelationType.MANY,
				name: 'registrationsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Registrations here] off begin
				label: 'Registrations',
				// % protected region % [Customise your 1-1 or 1-M label for Registrations here] end
				entityName: 'RegistrationModel',
				// % protected region % [Customise your display name for Registrations here] off begin
				displayName: 'registrationNumber',
				// % protected region % [Customise your display name for Registrations here] end
				validators: [
					// % protected region % [Add other validators for Registrations here] off begin
					// % protected region % [Add other validators for Registrations here] end
				],
				// % protected region % [Add any additional field for relation Registrations here] off begin
				// % protected region % [Add any additional field for relation Registrations here] end
			},
			{
				id: 'serviceFacilityCategories',
				type: ModelRelationType.MANY,
				name: 'serviceFacilityCategoriesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Service Facility Categories here] off begin
				label: 'Service Facility Categories',
				// % protected region % [Customise your 1-1 or 1-M label for Service Facility Categories here] end
				entityName: 'ServiceFacilityCategoryModel',
				// % protected region % [Customise your display name for Service Facility Categories here] off begin
				displayName: 'facilityCode',
				// % protected region % [Customise your display name for Service Facility Categories here] end
				validators: [
					// % protected region % [Add other validators for Service Facility Categories here] off begin
					// % protected region % [Add other validators for Service Facility Categories here] end
				],
				// % protected region % [Add any additional field for relation Service Facility Categories here] off begin
				// % protected region % [Add any additional field for relation Service Facility Categories here] end
			},
			{
				id: 'serviceItems',
				type: ModelRelationType.MANY,
				name: 'serviceItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Service Items here] off begin
				label: 'Service Items',
				// % protected region % [Customise your 1-1 or 1-M label for Service Items here] end
				entityName: 'ServiceItemModel',
				// % protected region % [Customise your display name for Service Items here] off begin
				displayName: 'serviceItemCode',
				// % protected region % [Customise your display name for Service Items here] end
				validators: [
					// % protected region % [Add other validators for Service Items here] off begin
					// % protected region % [Add other validators for Service Items here] end
				],
				// % protected region % [Add any additional field for relation Service Items here] off begin
				// % protected region % [Add any additional field for relation Service Items here] end
			},
			{
				id: 'defaultMedicalStaff',
				type: ModelRelationType.ONE,
				name: 'defaultMedicalStaffId',
				// % protected region % [Customise your label for Default Medical Staff here] off begin
				label: 'Default Medical Staff',
				// % protected region % [Customise your label for Default Medical Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Default Medical Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Default Medical Staff here] end
				validators: [
					// % protected region % [Add other validators for Default Medical Staff here] off begin
					// % protected region % [Add other validators for Default Medical Staff here] end
				],
				// % protected region % [Add any additional field for relation Default Medical Staff here] off begin
				// % protected region % [Add any additional field for relation Default Medical Staff here] end
			},
			{
				id: 'assignedMedicalStaff',
				type: ModelRelationType.MANY,
				name: 'assignedMedicalStaffIds',
				// % protected region % [Customise your label for Assigned Medical Staff here] off begin
				label: 'Assigned Medical Staff',
				// % protected region % [Customise your label for Assigned Medical Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Assigned Medical Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Assigned Medical Staff here] end
				validators: [
					// % protected region % [Add other validators for Assigned Medical Staff here] off begin
					// % protected region % [Add other validators for Assigned Medical Staff here] end
				],
				// % protected region % [Add any additional field for relation Assigned Medical Staff here] off begin
				// % protected region % [Add any additional field for relation Assigned Medical Staff here] end
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
				case 'serviceName':
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
	static deepParse(data: string | { [K in keyof ServiceModel]?: ServiceModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new ServiceModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to one
		if (json.bpjsPcarePoli) {
			currentModel.bpjsPcarePoliId = json.bpjsPcarePoli.id;
			returned = _.union(returned, BpjsPcarePoliModel.deepParse(json.bpjsPcarePoli));
		}

		// Outgoing one to one
		if (json.bpjsServiceMapping) {
			currentModel.bpjsServiceMappingId = json.bpjsServiceMapping.id;
			returned = _.union(returned, BpjsServiceMappingModel.deepParse(json.bpjsServiceMapping));
		}

		// Incoming one to one
		if (json.defaultMedicalStaff) {
			currentModel.defaultMedicalStaffId = json.defaultMedicalStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.defaultMedicalStaff));
		}

		// Outgoing one to many
		if (json.doctorSchedules) {
			currentModel.doctorSchedulesIds = json.doctorSchedules.map(model => model.id);
			returned = _.union(returned, _.flatten(json.doctorSchedules.map(model => DoctorScheduleModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.examinationGroups) {
			currentModel.examinationGroupsIds = json.examinationGroups.map(model => model.id);
			returned = _.union(returned, _.flatten(json.examinationGroups.map(model => ExaminationGroupModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.mcuPackageItems) {
			currentModel.mcuPackageItemsIds = json.mcuPackageItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.mcuPackageItems.map(model => McuPackageItemModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.referringUnit) {
			currentModel.referringUnitIds = json.referringUnit.map(model => model.id);
			returned = _.union(returned, _.flatten(json.referringUnit.map(model => RegistrationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.registrations) {
			currentModel.registrationsIds = json.registrations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.registrations.map(model => RegistrationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.serviceFacilityCategories) {
			currentModel.serviceFacilityCategoriesIds = json.serviceFacilityCategories.map(model => model.id);
			returned = _.union(returned, _.flatten(json.serviceFacilityCategories.map(model => ServiceFacilityCategoryModel.deepParse(model))));
		}
		// Outgoing many to many
		if (json.serviceItems) {
			currentModel.serviceItemsIds = json.serviceItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.serviceItems.map(model => ServiceItemModel.deepParse(model))));
		}
		// Incoming many to many
		if (json.assignedMedicalStaff) {
			currentModel.assignedMedicalStaffIds = json.assignedMedicalStaff.map(model => model.id);
			returned = _.union(returned, _.flatten(json.assignedMedicalStaff.map(model => StaffModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let serviceModel = new ServiceModel(data);`
	 *
	 * @param data The input data to be initialised as the ServiceModel,
	 *    it is expected as a JSON string or as a nullable ServiceModel.
	 */
	constructor(data?: string | Partial<ServiceModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<ServiceModel>
				: data;

			this.serviceNumber = json.serviceNumber;
			this.serviceName = json.serviceName;
			this.sectionCode = json.sectionCode;
			this.byPassDoctorAssignment = json.byPassDoctorAssignment;
			this.hasExaminationItem = json.hasExaminationItem;
			this.revenueCenter = json.revenueCenter;
			this.serviceCode = json.serviceCode;
			this.bpjsPcarePoliId = json.bpjsPcarePoliId;
			this.bpjsPcarePoli = json.bpjsPcarePoli;
			this.bpjsServiceMappingId = json.bpjsServiceMappingId;
			this.bpjsServiceMapping = json.bpjsServiceMapping;
			this.defaultMedicalStaffId = json.defaultMedicalStaffId;
			this.defaultMedicalStaff = json.defaultMedicalStaff;
			this.doctorSchedulesIds = json.doctorSchedulesIds;
			this.doctorSchedules = json.doctorSchedules;
			this.examinationGroupsIds = json.examinationGroupsIds;
			this.examinationGroups = json.examinationGroups;
			this.mcuPackageItemsIds = json.mcuPackageItemsIds;
			this.mcuPackageItems = json.mcuPackageItems;
			this.referringUnitIds = json.referringUnitIds;
			this.referringUnit = json.referringUnit;
			this.registrationsIds = json.registrationsIds;
			this.registrations = json.registrations;
			this.serviceFacilityCategoriesIds = json.serviceFacilityCategoriesIds;
			this.serviceFacilityCategories = json.serviceFacilityCategories;
			this.serviceItemsIds = json.serviceItemsIds;
			this.serviceItems = json.serviceItems;
			this.assignedMedicalStaffIds = json.assignedMedicalStaffIds;
			this.assignedMedicalStaff = json.assignedMedicalStaff;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			serviceNumber: this.serviceNumber,
			serviceName: this.serviceName,
			sectionCode: this.sectionCode,
			byPassDoctorAssignment: this.byPassDoctorAssignment,
			hasExaminationItem: this.hasExaminationItem,
			revenueCenter: this.revenueCenter,
			serviceCode: this.serviceCode,
			bpjsPcarePoliId: this.bpjsPcarePoliId,
			bpjsServiceMappingId: this.bpjsServiceMappingId,
			defaultMedicalStaffId: this.defaultMedicalStaffId,
			doctorSchedulesIds: this.doctorSchedulesIds,
			examinationGroupsIds: this.examinationGroupsIds,
			mcuPackageItemsIds: this.mcuPackageItemsIds,
			referringUnitIds: this.referringUnitIds,
			registrationsIds: this.registrationsIds,
			serviceFacilityCategoriesIds: this.serviceFacilityCategoriesIds,
			serviceItemsIds: this.serviceItemsIds,
			assignedMedicalStaffIds: this.assignedMedicalStaffIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		ServiceModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): ServiceModel {
		let newModelJson = this.toJSON();

		if (updates.serviceNumber) {
			newModelJson.serviceNumber = updates.serviceNumber;
		}

		if (updates.serviceName) {
			newModelJson.serviceName = updates.serviceName;
		}

		if (updates.sectionCode) {
			newModelJson.sectionCode = updates.sectionCode;
		}

		if (updates.byPassDoctorAssignment) {
			newModelJson.byPassDoctorAssignment = updates.byPassDoctorAssignment;
		}

		if (updates.hasExaminationItem) {
			newModelJson.hasExaminationItem = updates.hasExaminationItem;
		}

		if (updates.revenueCenter) {
			newModelJson.revenueCenter = updates.revenueCenter;
		}

		if (updates.serviceCode) {
			newModelJson.serviceCode = updates.serviceCode;
		}

		if (updates.bpjsPcarePoliId) {
			newModelJson.bpjsPcarePoliId = updates.bpjsPcarePoliId;
		}

		if (updates.bpjsServiceMappingId) {
			newModelJson.bpjsServiceMappingId = updates.bpjsServiceMappingId;
		}

		if (updates.defaultMedicalStaffId) {
			newModelJson.defaultMedicalStaffId = updates.defaultMedicalStaffId;
		}

		if (updates.doctorSchedulesIds) {
			newModelJson.doctorSchedulesIds = updates.doctorSchedulesIds;
		}

		if (updates.examinationGroupsIds) {
			newModelJson.examinationGroupsIds = updates.examinationGroupsIds;
		}

		if (updates.mcuPackageItemsIds) {
			newModelJson.mcuPackageItemsIds = updates.mcuPackageItemsIds;
		}

		if (updates.referringUnitIds) {
			newModelJson.referringUnitIds = updates.referringUnitIds;
		}

		if (updates.registrationsIds) {
			newModelJson.registrationsIds = updates.registrationsIds;
		}

		if (updates.serviceFacilityCategoriesIds) {
			newModelJson.serviceFacilityCategoriesIds = updates.serviceFacilityCategoriesIds;
		}

		if (updates.serviceItemsIds) {
			newModelJson.serviceItemsIds = updates.serviceItemsIds;
		}

		if (updates.assignedMedicalStaffIds) {
			newModelJson.assignedMedicalStaffIds = updates.assignedMedicalStaffIds;
		}

		return new ServiceModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof ServiceModel)) {
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
			'bpjsPcarePoliId',
			'bpjsPcarePoli',
			'bpjsServiceMappingId',
			'bpjsServiceMapping',
			'defaultMedicalStaffId',
			'defaultMedicalStaff',
			'doctorSchedulesIds',
			'doctorSchedules',
			'examinationGroupsIds',
			'examinationGroups',
			'mcuPackageItemsIds',
			'mcuPackageItems',
			'referringUnitIds',
			'referringUnit',
			'registrationsIds',
			'registrations',
			'serviceFacilityCategoriesIds',
			'serviceFacilityCategories',
			'assignedMedicalStaffIds',
			'assignedMedicalStaff',
			'serviceItemsIds',
			'serviceItems',
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
		if (!this.bpjsPcarePoli) {
			this.bpjsPcarePoliId = null;
		} else {
			this.bpjsPcarePoliId = this.bpjsPcarePoli.id;
		}

		if (!this.bpjsServiceMapping) {
			this.bpjsServiceMappingId = null;
		} else {
			this.bpjsServiceMappingId = this.bpjsServiceMapping.id;
		}

		if (!this.defaultMedicalStaff) {
			this.defaultMedicalStaffId = null;
		} else {
			this.defaultMedicalStaffId = this.defaultMedicalStaff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
