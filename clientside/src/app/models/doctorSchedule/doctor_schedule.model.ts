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
import {ServiceModel} from '../service/service.model';
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
export class DoctorScheduleModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'shift',
		'repetition',
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

	readonly className = 'DoctorScheduleModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return DoctorScheduleModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Date and Time when the doctor starts practice in a day. Only keep the TIME value (without date).
	 */
	startDateTime: Date;

	/**
	 * Date and Time when the doctor ends practice in a day. Only keep the TIME value (without date).
	 */
	endDateTime: Date;

	/**
	 * How long doctor examines a patient in minutes.
	 */
	intervalInMinutes: number;

	/**
	 * .
	 */
	location: string;

	/**
	 * Type of scheduler, by default it's set to ON Duty, , get the Code from Reference Data where Type=SCH_TYPE. (Max Length: 20).
	 */
	schedulerType: string;

	/**
	 * Schedule on Monday, default is TRUE.
	 */
	monday: boolean = false;

	/**
	 * Schedule on Tuesday, default is TRUE.
	 */
	tuesday: boolean = false;

	/**
	 * Schedule on Wednesday, default is TRUE.
	 */
	wednesday: boolean = false;

	/**
	 * Schedule on Thursday, default is TRUE.
	 */
	thursday: boolean = false;

	/**
	 * Schedule on Friday, default is TRUE.
	 */
	friday: boolean = false;

	/**
	 * Schedule on Saturday, default is FALSE.
	 */
	saturday: boolean = false;

	/**
	 * Schedule on Sunday, default is FALSE.
	 */
	sunday: boolean = false;

	/**
	 * .
	 */
	email: string;

	/**
	 * Training/course, get the Code from Reference Data where Type=STAFF_COURSE. (Max Length: 20).
	 */
	training: string;

	/**
	 * Dismissal Date or Actual Date out, when pasient is dismissed from doctor examination. It's including time.
	 */
	dismissalDate: Date;

	/**
	 * Shift for doctor schedule.
	 */
	shift: string;

	/**
	 * .
	 */
	intervals: number;

	/**
	 * Define whether the schedule should be repeated or not.
	 */
	repetition: boolean = false;

	/**
	 * .
	 */
	numberOfRepetition: number;

	/**
	 * Date and time of the last repetition.
	 */
	finalSchedule: Date;

	serviceId: string;

	service: ServiceModel;

	staffId: string;

	staff: StaffModel;

	modelPropGroups: { [s: string]: Group } = DoctorScheduleModel.modelPropGroups;

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
					Validators.required,
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
					Validators.required,
					// % protected region % [Add other validators for End Date Time here] off begin
					// % protected region % [Add other validators for End Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for End Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for End Date Time here] end
			},
			{
				name: 'intervalInMinutes',
				// % protected region % [Set displayName for Interval in minutes here] off begin
				displayName: 'Interval in minutes',
				// % protected region % [Set displayName for Interval in minutes here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Interval in minutes here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Interval in minutes here] end
				// % protected region % [Set isSensitive for Interval in minutes here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Interval in minutes here] end
				// % protected region % [Set readonly for Interval in minutes here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Interval in minutes here] end
				validators: [
					// % protected region % [Add other validators for Interval in minutes here] off begin
					// % protected region % [Add other validators for Interval in minutes here] end
				],
				// % protected region % [Add any additional model attribute properties for Interval in minutes here] off begin
				// % protected region % [Add any additional model attribute properties for Interval in minutes here] end
			},
			{
				name: 'location',
				// % protected region % [Set displayName for Location here] off begin
				displayName: 'Location',
				// % protected region % [Set displayName for Location here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Location here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Location here] end
				// % protected region % [Set isSensitive for Location here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Location here] end
				// % protected region % [Set readonly for Location here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Location here] end
				validators: [
					// % protected region % [Add other validators for Location here] off begin
					// % protected region % [Add other validators for Location here] end
				],
				// % protected region % [Add any additional model attribute properties for Location here] off begin
				// % protected region % [Add any additional model attribute properties for Location here] end
			},
			{
				name: 'schedulerType',
				// % protected region % [Set displayName for Scheduler Type here] off begin
				displayName: 'Scheduler Type',
				// % protected region % [Set displayName for Scheduler Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Scheduler Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Scheduler Type here] end
				// % protected region % [Set isSensitive for Scheduler Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Scheduler Type here] end
				// % protected region % [Set readonly for Scheduler Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Scheduler Type here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Scheduler Type here] off begin
					// % protected region % [Add other validators for Scheduler Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Scheduler Type here] off begin
				// % protected region % [Add any additional model attribute properties for Scheduler Type here] end
			},
			{
				name: 'monday',
				// % protected region % [Set displayName for Monday here] off begin
				displayName: 'Monday',
				// % protected region % [Set displayName for Monday here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Monday here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Monday here] end
				// % protected region % [Set isSensitive for Monday here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Monday here] end
				// % protected region % [Set readonly for Monday here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Monday here] end
				validators: [
					// % protected region % [Add other validators for Monday here] off begin
					// % protected region % [Add other validators for Monday here] end
				],
				// % protected region % [Add any additional model attribute properties for Monday here] off begin
				// % protected region % [Add any additional model attribute properties for Monday here] end
			},
			{
				name: 'tuesday',
				// % protected region % [Set displayName for Tuesday here] off begin
				displayName: 'Tuesday',
				// % protected region % [Set displayName for Tuesday here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Tuesday here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Tuesday here] end
				// % protected region % [Set isSensitive for Tuesday here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tuesday here] end
				// % protected region % [Set readonly for Tuesday here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tuesday here] end
				validators: [
					// % protected region % [Add other validators for Tuesday here] off begin
					// % protected region % [Add other validators for Tuesday here] end
				],
				// % protected region % [Add any additional model attribute properties for Tuesday here] off begin
				// % protected region % [Add any additional model attribute properties for Tuesday here] end
			},
			{
				name: 'wednesday',
				// % protected region % [Set displayName for Wednesday here] off begin
				displayName: 'Wednesday',
				// % protected region % [Set displayName for Wednesday here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Wednesday here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Wednesday here] end
				// % protected region % [Set isSensitive for Wednesday here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Wednesday here] end
				// % protected region % [Set readonly for Wednesday here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Wednesday here] end
				validators: [
					// % protected region % [Add other validators for Wednesday here] off begin
					// % protected region % [Add other validators for Wednesday here] end
				],
				// % protected region % [Add any additional model attribute properties for Wednesday here] off begin
				// % protected region % [Add any additional model attribute properties for Wednesday here] end
			},
			{
				name: 'thursday',
				// % protected region % [Set displayName for Thursday here] off begin
				displayName: 'Thursday',
				// % protected region % [Set displayName for Thursday here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Thursday here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Thursday here] end
				// % protected region % [Set isSensitive for Thursday here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Thursday here] end
				// % protected region % [Set readonly for Thursday here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Thursday here] end
				validators: [
					// % protected region % [Add other validators for Thursday here] off begin
					// % protected region % [Add other validators for Thursday here] end
				],
				// % protected region % [Add any additional model attribute properties for Thursday here] off begin
				// % protected region % [Add any additional model attribute properties for Thursday here] end
			},
			{
				name: 'friday',
				// % protected region % [Set displayName for Friday here] off begin
				displayName: 'Friday',
				// % protected region % [Set displayName for Friday here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Friday here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Friday here] end
				// % protected region % [Set isSensitive for Friday here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Friday here] end
				// % protected region % [Set readonly for Friday here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Friday here] end
				validators: [
					// % protected region % [Add other validators for Friday here] off begin
					// % protected region % [Add other validators for Friday here] end
				],
				// % protected region % [Add any additional model attribute properties for Friday here] off begin
				// % protected region % [Add any additional model attribute properties for Friday here] end
			},
			{
				name: 'saturday',
				// % protected region % [Set displayName for Saturday here] off begin
				displayName: 'Saturday',
				// % protected region % [Set displayName for Saturday here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Saturday here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Saturday here] end
				// % protected region % [Set isSensitive for Saturday here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Saturday here] end
				// % protected region % [Set readonly for Saturday here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Saturday here] end
				validators: [
					// % protected region % [Add other validators for Saturday here] off begin
					// % protected region % [Add other validators for Saturday here] end
				],
				// % protected region % [Add any additional model attribute properties for Saturday here] off begin
				// % protected region % [Add any additional model attribute properties for Saturday here] end
			},
			{
				name: 'sunday',
				// % protected region % [Set displayName for Sunday here] off begin
				displayName: 'Sunday',
				// % protected region % [Set displayName for Sunday here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Sunday here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Sunday here] end
				// % protected region % [Set isSensitive for Sunday here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sunday here] end
				// % protected region % [Set readonly for Sunday here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sunday here] end
				validators: [
					// % protected region % [Add other validators for Sunday here] off begin
					// % protected region % [Add other validators for Sunday here] end
				],
				// % protected region % [Add any additional model attribute properties for Sunday here] off begin
				// % protected region % [Add any additional model attribute properties for Sunday here] end
			},
			{
				name: 'email',
				// % protected region % [Set displayName for Email here] off begin
				displayName: 'Email',
				// % protected region % [Set displayName for Email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Email here] end
				// % protected region % [Set isSensitive for Email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Email here] end
				// % protected region % [Set readonly for Email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Email here] end
				validators: [
					// % protected region % [Add other validators for Email here] off begin
					// % protected region % [Add other validators for Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Email here] off begin
				// % protected region % [Add any additional model attribute properties for Email here] end
			},
			{
				name: 'training',
				// % protected region % [Set displayName for Training here] off begin
				displayName: 'Training',
				// % protected region % [Set displayName for Training here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Training here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Training here] end
				// % protected region % [Set isSensitive for Training here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Training here] end
				// % protected region % [Set readonly for Training here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Training here] end
				validators: [
					// % protected region % [Add other validators for Training here] off begin
					// % protected region % [Add other validators for Training here] end
				],
				// % protected region % [Add any additional model attribute properties for Training here] off begin
				// % protected region % [Add any additional model attribute properties for Training here] end
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
			{
				name: 'shift',
				// % protected region % [Set displayName for Shift here] off begin
				displayName: 'Shift',
				// % protected region % [Set displayName for Shift here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Shift here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Shift here] end
				// % protected region % [Set isSensitive for Shift here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Shift here] end
				// % protected region % [Set readonly for Shift here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Shift here] end
				validators: [
					// % protected region % [Add other validators for Shift here] off begin
					// % protected region % [Add other validators for Shift here] end
				],
				// % protected region % [Add any additional model attribute properties for Shift here] off begin
				// % protected region % [Add any additional model attribute properties for Shift here] end
			},
			{
				name: 'intervals',
				// % protected region % [Set displayName for Intervals here] off begin
				displayName: 'Intervals',
				// % protected region % [Set displayName for Intervals here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Intervals here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Intervals here] end
				// % protected region % [Set isSensitive for Intervals here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Intervals here] end
				// % protected region % [Set readonly for Intervals here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Intervals here] end
				validators: [
					// % protected region % [Add other validators for Intervals here] off begin
					// % protected region % [Add other validators for Intervals here] end
				],
				// % protected region % [Add any additional model attribute properties for Intervals here] off begin
				// % protected region % [Add any additional model attribute properties for Intervals here] end
			},
			{
				name: 'repetition',
				// % protected region % [Set displayName for Repetition here] off begin
				displayName: 'Repetition',
				// % protected region % [Set displayName for Repetition here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Repetition here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Repetition here] end
				// % protected region % [Set isSensitive for Repetition here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Repetition here] end
				// % protected region % [Set readonly for Repetition here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Repetition here] end
				validators: [
					// % protected region % [Add other validators for Repetition here] off begin
					// % protected region % [Add other validators for Repetition here] end
				],
				// % protected region % [Add any additional model attribute properties for Repetition here] off begin
				// % protected region % [Add any additional model attribute properties for Repetition here] end
			},
			{
				name: 'numberOfRepetition',
				// % protected region % [Set displayName for Number Of Repetition here] off begin
				displayName: 'Number Of Repetition',
				// % protected region % [Set displayName for Number Of Repetition here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Number Of Repetition here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Number Of Repetition here] end
				// % protected region % [Set isSensitive for Number Of Repetition here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Number Of Repetition here] end
				// % protected region % [Set readonly for Number Of Repetition here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Number Of Repetition here] end
				validators: [
					// % protected region % [Add other validators for Number Of Repetition here] off begin
					// % protected region % [Add other validators for Number Of Repetition here] end
				],
				// % protected region % [Add any additional model attribute properties for Number Of Repetition here] off begin
				// % protected region % [Add any additional model attribute properties for Number Of Repetition here] end
			},
			{
				name: 'finalSchedule',
				// % protected region % [Set displayName for Final Schedule here] off begin
				displayName: 'Final Schedule',
				// % protected region % [Set displayName for Final Schedule here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Final Schedule here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Final Schedule here] end
				// % protected region % [Set isSensitive for Final Schedule here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Final Schedule here] end
				// % protected region % [Set readonly for Final Schedule here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Final Schedule here] end
				validators: [
					// % protected region % [Add other validators for Final Schedule here] off begin
					// % protected region % [Add other validators for Final Schedule here] end
				],
				// % protected region % [Add any additional model attribute properties for Final Schedule here] off begin
				// % protected region % [Add any additional model attribute properties for Final Schedule here] end
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
				id: 'service',
				type: ModelRelationType.ONE,
				name: 'serviceId',
				// % protected region % [Customise your label for Service here] off begin
				label: 'Service',
				// % protected region % [Customise your label for Service here] end
				entityName: 'ServiceModel',
				// % protected region % [Customise your display name for Service here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'serviceNumber',
				// % protected region % [Customise your display name for Service here] end
				validators: [
					// % protected region % [Add other validators for Service here] off begin
					// % protected region % [Add other validators for Service here] end
				],
				// % protected region % [Add any additional field for relation Service here] off begin
				// % protected region % [Add any additional field for relation Service here] end
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
				case 'shift':
					break;
				case 'repetition':
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
	static deepParse(data: string | { [K in keyof DoctorScheduleModel]?: DoctorScheduleModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new DoctorScheduleModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.service) {
			currentModel.serviceId = json.service.id;
			returned = _.union(returned, ServiceModel.deepParse(json.service));
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
	 * `let doctorScheduleModel = new DoctorScheduleModel(data);`
	 *
	 * @param data The input data to be initialised as the DoctorScheduleModel,
	 *    it is expected as a JSON string or as a nullable DoctorScheduleModel.
	 */
	constructor(data?: string | Partial<DoctorScheduleModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<DoctorScheduleModel>
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
			this.intervalInMinutes = json.intervalInMinutes;
			this.location = json.location;
			this.schedulerType = json.schedulerType;
			this.monday = json.monday;
			this.tuesday = json.tuesday;
			this.wednesday = json.wednesday;
			this.thursday = json.thursday;
			this.friday = json.friday;
			this.saturday = json.saturday;
			this.sunday = json.sunday;
			this.email = json.email;
			this.training = json.training;
			if (json.dismissalDate) {
				this.dismissalDate = new Date(json.dismissalDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dismissalDate = json.dismissalDate;
			}
			this.shift = json.shift;
			this.intervals = json.intervals;
			this.repetition = json.repetition;
			this.numberOfRepetition = json.numberOfRepetition;
			if (json.finalSchedule) {
				this.finalSchedule = new Date(json.finalSchedule);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.finalSchedule = json.finalSchedule;
			}
			this.serviceId = json.serviceId;
			this.service = json.service;
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
			startDateTime: this.startDateTime,
			endDateTime: this.endDateTime,
			intervalInMinutes: this.intervalInMinutes,
			location: this.location,
			schedulerType: this.schedulerType,
			monday: this.monday,
			tuesday: this.tuesday,
			wednesday: this.wednesday,
			thursday: this.thursday,
			friday: this.friday,
			saturday: this.saturday,
			sunday: this.sunday,
			email: this.email,
			training: this.training,
			dismissalDate: this.dismissalDate,
			shift: this.shift,
			intervals: this.intervals,
			repetition: this.repetition,
			numberOfRepetition: this.numberOfRepetition,
			finalSchedule: this.finalSchedule,
			serviceId: this.serviceId,
			staffId: this.staffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		DoctorScheduleModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): DoctorScheduleModel {
		let newModelJson = this.toJSON();

		if (updates.startDateTime) {
			newModelJson.startDateTime = updates.startDateTime;
		}

		if (updates.endDateTime) {
			newModelJson.endDateTime = updates.endDateTime;
		}

		if (updates.intervalInMinutes) {
			newModelJson.intervalInMinutes = updates.intervalInMinutes;
		}

		if (updates.location) {
			newModelJson.location = updates.location;
		}

		if (updates.schedulerType) {
			newModelJson.schedulerType = updates.schedulerType;
		}

		if (updates.monday) {
			newModelJson.monday = updates.monday;
		}

		if (updates.tuesday) {
			newModelJson.tuesday = updates.tuesday;
		}

		if (updates.wednesday) {
			newModelJson.wednesday = updates.wednesday;
		}

		if (updates.thursday) {
			newModelJson.thursday = updates.thursday;
		}

		if (updates.friday) {
			newModelJson.friday = updates.friday;
		}

		if (updates.saturday) {
			newModelJson.saturday = updates.saturday;
		}

		if (updates.sunday) {
			newModelJson.sunday = updates.sunday;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.training) {
			newModelJson.training = updates.training;
		}

		if (updates.dismissalDate) {
			newModelJson.dismissalDate = updates.dismissalDate;
		}

		if (updates.shift) {
			newModelJson.shift = updates.shift;
		}

		if (updates.intervals) {
			newModelJson.intervals = updates.intervals;
		}

		if (updates.repetition) {
			newModelJson.repetition = updates.repetition;
		}

		if (updates.numberOfRepetition) {
			newModelJson.numberOfRepetition = updates.numberOfRepetition;
		}

		if (updates.finalSchedule) {
			newModelJson.finalSchedule = updates.finalSchedule;
		}

		if (updates.serviceId) {
			newModelJson.serviceId = updates.serviceId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		return new DoctorScheduleModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof DoctorScheduleModel)) {
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
			'serviceId',
			'service',
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
		if (!this.service) {
			this.serviceId = null;
		} else {
			this.serviceId = this.service.id;
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
