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
import {IntraoperativeRecordsModel} from '../intraoperativeRecords/intraoperative_records.model';
import {PostOperativeDetailsModel} from '../postOperativeDetails/post_operative_details.model';
import {PreoperativeRecordsModel} from '../preoperativeRecords/preoperative_records.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import {FileModel} from '../../lib/models/file.model';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class RoomFacilityModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'roomNumber',
		'roomName',
		'department',
		'genderAllocation',
		'location',
		'treatmentClass',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'roomNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'RoomFacilityModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return RoomFacilityModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Room Number (Max Length: 50).
	 */
	roomNumber: string;

	/**
	 * Room Name (Max Length: 250).
	 */
	roomName: string;

	/**
	 * Department of patient as classification for room, get the Code from Reference Data where Type=FAC_CASE. (Max Length: 20).
	 */
	department: string;

	/**
	 * Gender Allocation as information of gender of a room to classify on bed booking, get the Code from Reference Data where Type=FAC_GNDR_ALLOC. (Max Length: 20).
	 */
	genderAllocation: string;

	/**
	 * Location of room (building, ground, space, etc), get the Code from Reference Data where Type=FAC_LOC. (Max Length: 20).
	 */
	location: string;

	/**
	 * Detail information of room (Max Length: 500).
	 */
	notes: string;

	/**
	 * Photo or picture of a room.
	 */
	roomFacilityPicture: FileModel[];

	/**
	 * This field is shown if BPJS Facility Flag is On/True.
	 */
	category: string;

	/**
	 * Room class type.
	 */
	treatmentClass: string;

	bedFacilitiesIds: string[] = [];

	bedFacilities: BedFacilityModel[];

	operatingRoomIds: string[] = [];

	operatingRoom: IntraoperativeRecordsModel[];

	preoperativeRoomsIds: string[] = [];

	preoperativeRooms: PreoperativeRecordsModel[];

	recoveryRoomsIds: string[] = [];

	recoveryRooms: PostOperativeDetailsModel[];

	modelPropGroups: { [s: string]: Group } = RoomFacilityModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'roomNumber',
				// % protected region % [Set displayName for Room Number here] off begin
				displayName: 'Room Number',
				// % protected region % [Set displayName for Room Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Room Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Room Number here] end
				// % protected region % [Set isSensitive for Room Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Room Number here] end
				// % protected region % [Set readonly for Room Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Room Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Room Number here] off begin
					// % protected region % [Add other validators for Room Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Room Number here] off begin
				// % protected region % [Add any additional model attribute properties for Room Number here] end
			},
			{
				name: 'roomName',
				// % protected region % [Set displayName for Room Name here] off begin
				displayName: 'Room Name',
				// % protected region % [Set displayName for Room Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Room Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Room Name here] end
				// % protected region % [Set isSensitive for Room Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Room Name here] end
				// % protected region % [Set readonly for Room Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Room Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Room Name here] off begin
					// % protected region % [Add other validators for Room Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Room Name here] off begin
				// % protected region % [Add any additional model attribute properties for Room Name here] end
			},
			{
				name: 'department',
				// % protected region % [Set displayName for Department here] off begin
				displayName: 'Department',
				// % protected region % [Set displayName for Department here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Department here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Department here] end
				// % protected region % [Set isSensitive for Department here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Department here] end
				// % protected region % [Set readonly for Department here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Department here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Department here] off begin
					// % protected region % [Add other validators for Department here] end
				],
				// % protected region % [Add any additional model attribute properties for Department here] off begin
				// % protected region % [Add any additional model attribute properties for Department here] end
			},
			{
				name: 'genderAllocation',
				// % protected region % [Set displayName for Gender Allocation here] off begin
				displayName: 'Gender Allocation',
				// % protected region % [Set displayName for Gender Allocation here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gender Allocation here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gender Allocation here] end
				// % protected region % [Set isSensitive for Gender Allocation here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gender Allocation here] end
				// % protected region % [Set readonly for Gender Allocation here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gender Allocation here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Gender Allocation here] off begin
					// % protected region % [Add other validators for Gender Allocation here] end
				],
				// % protected region % [Add any additional model attribute properties for Gender Allocation here] off begin
				// % protected region % [Add any additional model attribute properties for Gender Allocation here] end
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
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Location here] off begin
					// % protected region % [Add other validators for Location here] end
				],
				// % protected region % [Add any additional model attribute properties for Location here] off begin
				// % protected region % [Add any additional model attribute properties for Location here] end
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
				name: 'roomFacilityPicture',
				// % protected region % [Set displayName for Room Facility Picture here] off begin
				displayName: 'Room Facility Picture',
				// % protected region % [Set displayName for Room Facility Picture here] end
				type: ModelPropertyType.FILE,
				// % protected region % [Set display element type for Room Facility Picture here] off begin
				elementType: ElementType.FILE,
				// % protected region % [Set display element type for Room Facility Picture here] end
				// % protected region % [Set isSensitive for Room Facility Picture here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Room Facility Picture here] end
				// % protected region % [Set readonly for Room Facility Picture here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Room Facility Picture here] end
				validators: [
					// % protected region % [Add other validators for Room Facility Picture here] off begin
					// % protected region % [Add other validators for Room Facility Picture here] end
				],
				// % protected region % [Add any additional model attribute properties for Room Facility Picture here] off begin
				// % protected region % [Add any additional model attribute properties for Room Facility Picture here] end
			},
			{
				name: 'category',
				// % protected region % [Set displayName for Category here] off begin
				displayName: 'Category',
				// % protected region % [Set displayName for Category here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Category here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Category here] end
				// % protected region % [Set isSensitive for Category here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Category here] end
				// % protected region % [Set readonly for Category here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Category here] end
				validators: [
					// % protected region % [Add other validators for Category here] off begin
					// % protected region % [Add other validators for Category here] end
				],
				// % protected region % [Add any additional model attribute properties for Category here] off begin
				// % protected region % [Add any additional model attribute properties for Category here] end
			},
			{
				name: 'treatmentClass',
				// % protected region % [Set displayName for Treatment Class here] off begin
				displayName: 'Treatment Class',
				// % protected region % [Set displayName for Treatment Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Treatment Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Treatment Class here] end
				// % protected region % [Set isSensitive for Treatment Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Treatment Class here] end
				// % protected region % [Set readonly for Treatment Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Treatment Class here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Treatment Class here] off begin
					// % protected region % [Add other validators for Treatment Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Treatment Class here] off begin
				// % protected region % [Add any additional model attribute properties for Treatment Class here] end
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
				id: 'operatingRoom',
				type: ModelRelationType.MANY,
				name: 'operatingRoomIds',
				// % protected region % [Customise your 1-1 or 1-M label for Operating Room here] off begin
				label: 'Operating Room',
				// % protected region % [Customise your 1-1 or 1-M label for Operating Room here] end
				entityName: 'IntraoperativeRecordsModel',
				// % protected region % [Customise your display name for Operating Room here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Operating Room here] end
				validators: [
					// % protected region % [Add other validators for Operating Room here] off begin
					// % protected region % [Add other validators for Operating Room here] end
				],
				// % protected region % [Add any additional field for relation Operating Room here] off begin
				// % protected region % [Add any additional field for relation Operating Room here] end
			},
			{
				id: 'preoperativeRooms',
				type: ModelRelationType.MANY,
				name: 'preoperativeRoomsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Preoperative Rooms here] off begin
				label: 'Preoperative Rooms',
				// % protected region % [Customise your 1-1 or 1-M label for Preoperative Rooms here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Preoperative Rooms here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Preoperative Rooms here] end
				validators: [
					// % protected region % [Add other validators for Preoperative Rooms here] off begin
					// % protected region % [Add other validators for Preoperative Rooms here] end
				],
				// % protected region % [Add any additional field for relation Preoperative Rooms here] off begin
				// % protected region % [Add any additional field for relation Preoperative Rooms here] end
			},
			{
				id: 'recoveryRooms',
				type: ModelRelationType.MANY,
				name: 'recoveryRoomsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Recovery Rooms here] off begin
				label: 'Recovery Rooms',
				// % protected region % [Customise your 1-1 or 1-M label for Recovery Rooms here] end
				entityName: 'PostOperativeDetailsModel',
				// % protected region % [Customise your display name for Recovery Rooms here] off begin
				displayName: 'recoveryStartDateTime',
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
				case 'roomNumber':
					break;
				case 'roomName':
					break;
				case 'department':
					break;
				case 'genderAllocation':
					break;
				case 'location':
					break;
				case 'treatmentClass':
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
	static deepParse(data: string | { [K in keyof RoomFacilityModel]?: RoomFacilityModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new RoomFacilityModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.bedFacilities) {
			currentModel.bedFacilitiesIds = json.bedFacilities.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bedFacilities.map(model => BedFacilityModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.operatingRoom) {
			currentModel.operatingRoomIds = json.operatingRoom.map(model => model.id);
			returned = _.union(returned, _.flatten(json.operatingRoom.map(model => IntraoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.preoperativeRooms) {
			currentModel.preoperativeRoomsIds = json.preoperativeRooms.map(model => model.id);
			returned = _.union(returned, _.flatten(json.preoperativeRooms.map(model => PreoperativeRecordsModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.recoveryRooms) {
			currentModel.recoveryRoomsIds = json.recoveryRooms.map(model => model.id);
			returned = _.union(returned, _.flatten(json.recoveryRooms.map(model => PostOperativeDetailsModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let roomFacilityModel = new RoomFacilityModel(data);`
	 *
	 * @param data The input data to be initialised as the RoomFacilityModel,
	 *    it is expected as a JSON string or as a nullable RoomFacilityModel.
	 */
	constructor(data?: string | Partial<RoomFacilityModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<RoomFacilityModel>
				: data;

			this.roomNumber = json.roomNumber;
			this.roomName = json.roomName;
			this.department = json.department;
			this.genderAllocation = json.genderAllocation;
			this.location = json.location;
			this.notes = json.notes;
			this.roomFacilityPicture = json.roomFacilityPicture?.map(item => new FileModel(item));
			this.category = json.category;
			this.treatmentClass = json.treatmentClass;
			this.bedFacilitiesIds = json.bedFacilitiesIds;
			this.bedFacilities = json.bedFacilities;
			this.operatingRoomIds = json.operatingRoomIds;
			this.operatingRoom = json.operatingRoom;
			this.preoperativeRoomsIds = json.preoperativeRoomsIds;
			this.preoperativeRooms = json.preoperativeRooms;
			this.recoveryRoomsIds = json.recoveryRoomsIds;
			this.recoveryRooms = json.recoveryRooms;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			roomNumber: this.roomNumber,
			roomName: this.roomName,
			department: this.department,
			genderAllocation: this.genderAllocation,
			location: this.location,
			notes: this.notes,
			roomFacilityPicture: this.roomFacilityPicture,
			category: this.category,
			treatmentClass: this.treatmentClass,
			bedFacilitiesIds: this.bedFacilitiesIds,
			operatingRoomIds: this.operatingRoomIds,
			preoperativeRoomsIds: this.preoperativeRoomsIds,
			recoveryRoomsIds: this.recoveryRoomsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		RoomFacilityModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): RoomFacilityModel {
		let newModelJson = this.toJSON();

		if (updates.roomNumber) {
			newModelJson.roomNumber = updates.roomNumber;
		}

		if (updates.roomName) {
			newModelJson.roomName = updates.roomName;
		}

		if (updates.department) {
			newModelJson.department = updates.department;
		}

		if (updates.genderAllocation) {
			newModelJson.genderAllocation = updates.genderAllocation;
		}

		if (updates.location) {
			newModelJson.location = updates.location;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.roomFacilityPicture) {
			newModelJson.roomFacilityPicture = updates.roomFacilityPicture;
		}

		if (updates.category) {
			newModelJson.category = updates.category;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.bedFacilitiesIds) {
			newModelJson.bedFacilitiesIds = updates.bedFacilitiesIds;
		}

		if (updates.operatingRoomIds) {
			newModelJson.operatingRoomIds = updates.operatingRoomIds;
		}

		if (updates.preoperativeRoomsIds) {
			newModelJson.preoperativeRoomsIds = updates.preoperativeRoomsIds;
		}

		if (updates.recoveryRoomsIds) {
			newModelJson.recoveryRoomsIds = updates.recoveryRoomsIds;
		}

		return new RoomFacilityModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof RoomFacilityModel)) {
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
			} else if (['roomFacilityPicture'].includes(key)) {;
				const thisFiles = JSON.stringify(thisValue);
				const otherFiles = JSON.stringify(otherValue);

				if (thisFiles !== otherFiles) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			'bedFacilitiesIds',
			'bedFacilities',
			'operatingRoomIds',
			'operatingRoom',
			'preoperativeRoomsIds',
			'preoperativeRooms',
			'recoveryRoomsIds',
			'recoveryRooms',
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
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
