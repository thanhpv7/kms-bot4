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
import {BedReserveModel} from '../bedReserve/bed_reserve.model';
import {InpatientMedicalExaminationRecordModel} from '../inpatientMedicalExaminationRecord/inpatient_medical_examination_record.model';
import {IntraoperativeRecordsModel} from '../intraoperativeRecords/intraoperative_records.model';
import {InvoiceModel} from '../invoice/invoice.model';
import {PostOperativeDetailsModel} from '../postOperativeDetails/post_operative_details.model';
import {PreoperativeRecordsModel} from '../preoperativeRecords/preoperative_records.model';
import {RegistrationModel} from '../registration/registration.model';
import {RoomFacilityModel} from '../roomFacility/room_facility.model';
import {RoomTransferModel} from '../roomTransfer/room_transfer.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class BedFacilityModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'bedNumber',
		'bedName',
		'treatmentClass',
		'availability',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'bedNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'BedFacilityModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return BedFacilityModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Bed Number (Max Length: 50).
	 */
	bedNumber: string;

	/**
	 * Bed Name (Max Length: 250).
	 */
	bedName: string;

	/**
	 * Mapping a bed to treatment class patient billing, get the Code from Reference Data where Type=TREA_CLS. (Max Length: 20).
	 */
	treatmentClass: string;

	/**
	 * Availability status of bed for booking process, get the Code from Reference Data where Type=FAC_AVAILABILITY_STS. (Max Length: 20).
	 */
	availability: string;

	/**
	 * Detail information of Bed (Max Length: 500).
	 */
	notes: string;

	/**
	 * .
	 */
	coaCOGS: string;

	/**
	 * .
	 */
	coaSell: string;

	/**
	 * .
	 */
	coaInventory: string;

	intraoperativeRecordsId: string;

	intraoperativeRecords: IntraoperativeRecordsModel;

	postOperativeDetailsId: string;

	postOperativeDetails: PostOperativeDetailsModel;

	preoperativeRecordsId: string;

	preoperativeRecords: PreoperativeRecordsModel;

	roomFacilityId: string;

	roomFacility: RoomFacilityModel;

	bedReservesIds: string[] = [];

	bedReserves: BedReserveModel[];

	inpatientMedicalExaminationRecordsIds: string[] = [];

	inpatientMedicalExaminationRecords: InpatientMedicalExaminationRecordModel[];

	invoicesIds: string[] = [];

	invoices: InvoiceModel[];

	registrationsIds: string[] = [];

	registrations: RegistrationModel[];

	roomTransfersIds: string[] = [];

	roomTransfers: RoomTransferModel[];

	modelPropGroups: { [s: string]: Group } = BedFacilityModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'bedNumber',
				// % protected region % [Set displayName for Bed Number here] off begin
				displayName: 'Bed Number',
				// % protected region % [Set displayName for Bed Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bed Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bed Number here] end
				// % protected region % [Set isSensitive for Bed Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bed Number here] end
				// % protected region % [Set readonly for Bed Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bed Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Bed Number here] off begin
					// % protected region % [Add other validators for Bed Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Bed Number here] off begin
				// % protected region % [Add any additional model attribute properties for Bed Number here] end
			},
			{
				name: 'bedName',
				// % protected region % [Set displayName for Bed Name here] off begin
				displayName: 'Bed Name',
				// % protected region % [Set displayName for Bed Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bed Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bed Name here] end
				// % protected region % [Set isSensitive for Bed Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bed Name here] end
				// % protected region % [Set readonly for Bed Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bed Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Bed Name here] off begin
					// % protected region % [Add other validators for Bed Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Bed Name here] off begin
				// % protected region % [Add any additional model attribute properties for Bed Name here] end
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
			{
				name: 'availability',
				// % protected region % [Set displayName for Availability here] off begin
				displayName: 'Availability',
				// % protected region % [Set displayName for Availability here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Availability here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Availability here] end
				// % protected region % [Set isSensitive for Availability here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Availability here] end
				// % protected region % [Set readonly for Availability here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Availability here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Availability here] off begin
					// % protected region % [Add other validators for Availability here] end
				],
				// % protected region % [Add any additional model attribute properties for Availability here] off begin
				// % protected region % [Add any additional model attribute properties for Availability here] end
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
				name: 'coaCOGS',
				// % protected region % [Set displayName for COA COGS here] off begin
				displayName: 'COA COGS',
				// % protected region % [Set displayName for COA COGS here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for COA COGS here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for COA COGS here] end
				// % protected region % [Set isSensitive for COA COGS here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for COA COGS here] end
				// % protected region % [Set readonly for COA COGS here] off begin
				readOnly: false,
				// % protected region % [Set readonly for COA COGS here] end
				validators: [
					// % protected region % [Add other validators for COA COGS here] off begin
					// % protected region % [Add other validators for COA COGS here] end
				],
				// % protected region % [Add any additional model attribute properties for COA COGS here] off begin
				// % protected region % [Add any additional model attribute properties for COA COGS here] end
			},
			{
				name: 'coaSell',
				// % protected region % [Set displayName for COA Sell here] off begin
				displayName: 'COA Sell',
				// % protected region % [Set displayName for COA Sell here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for COA Sell here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for COA Sell here] end
				// % protected region % [Set isSensitive for COA Sell here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for COA Sell here] end
				// % protected region % [Set readonly for COA Sell here] off begin
				readOnly: false,
				// % protected region % [Set readonly for COA Sell here] end
				validators: [
					// % protected region % [Add other validators for COA Sell here] off begin
					// % protected region % [Add other validators for COA Sell here] end
				],
				// % protected region % [Add any additional model attribute properties for COA Sell here] off begin
				// % protected region % [Add any additional model attribute properties for COA Sell here] end
			},
			{
				name: 'coaInventory',
				// % protected region % [Set displayName for COA Inventory here] off begin
				displayName: 'COA Inventory',
				// % protected region % [Set displayName for COA Inventory here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for COA Inventory here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for COA Inventory here] end
				// % protected region % [Set isSensitive for COA Inventory here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for COA Inventory here] end
				// % protected region % [Set readonly for COA Inventory here] off begin
				readOnly: false,
				// % protected region % [Set readonly for COA Inventory here] end
				validators: [
					// % protected region % [Add other validators for COA Inventory here] off begin
					// % protected region % [Add other validators for COA Inventory here] end
				],
				// % protected region % [Add any additional model attribute properties for COA Inventory here] off begin
				// % protected region % [Add any additional model attribute properties for COA Inventory here] end
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
				id: 'bedReserves',
				type: ModelRelationType.MANY,
				name: 'bedReservesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Bed Reserves here] off begin
				label: 'Bed Reserves',
				// % protected region % [Customise your 1-1 or 1-M label for Bed Reserves here] end
				entityName: 'BedReserveModel',
				// % protected region % [Customise your display name for Bed Reserves here] off begin
				displayName: 'notes',
				// % protected region % [Customise your display name for Bed Reserves here] end
				validators: [
					// % protected region % [Add other validators for Bed Reserves here] off begin
					// % protected region % [Add other validators for Bed Reserves here] end
				],
				// % protected region % [Add any additional field for relation Bed Reserves here] off begin
				// % protected region % [Add any additional field for relation Bed Reserves here] end
			},
			{
				id: 'inpatientMedicalExaminationRecords',
				type: ModelRelationType.MANY,
				name: 'inpatientMedicalExaminationRecordsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Inpatient Medical Examination Records here] off begin
				label: 'Inpatient Medical Examination Records',
				// % protected region % [Customise your 1-1 or 1-M label for Inpatient Medical Examination Records here] end
				entityName: 'InpatientMedicalExaminationRecordModel',
				// % protected region % [Customise your display name for Inpatient Medical Examination Records here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Inpatient Medical Examination Records here] end
				validators: [
					// % protected region % [Add other validators for Inpatient Medical Examination Records here] off begin
					// % protected region % [Add other validators for Inpatient Medical Examination Records here] end
				],
				// % protected region % [Add any additional field for relation Inpatient Medical Examination Records here] off begin
				// % protected region % [Add any additional field for relation Inpatient Medical Examination Records here] end
			},
			{
				id: 'invoices',
				type: ModelRelationType.MANY,
				name: 'invoicesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices here] off begin
				label: 'Invoices',
				// % protected region % [Customise your 1-1 or 1-M label for Invoices here] end
				entityName: 'InvoiceModel',
				// % protected region % [Customise your display name for Invoices here] off begin
				displayName: 'invoiceNumber',
				// % protected region % [Customise your display name for Invoices here] end
				validators: [
					// % protected region % [Add other validators for Invoices here] off begin
					// % protected region % [Add other validators for Invoices here] end
				],
				// % protected region % [Add any additional field for relation Invoices here] off begin
				// % protected region % [Add any additional field for relation Invoices here] end
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
				id: 'roomTransfers',
				type: ModelRelationType.MANY,
				name: 'roomTransfersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Room Transfers here] off begin
				label: 'Room Transfers',
				// % protected region % [Customise your 1-1 or 1-M label for Room Transfers here] end
				entityName: 'RoomTransferModel',
				// % protected region % [Customise your display name for Room Transfers here] off begin
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Room Transfers here] end
				validators: [
					// % protected region % [Add other validators for Room Transfers here] off begin
					// % protected region % [Add other validators for Room Transfers here] end
				],
				// % protected region % [Add any additional field for relation Room Transfers here] off begin
				// % protected region % [Add any additional field for relation Room Transfers here] end
			},
			{
				id: 'intraoperativeRecords',
				type: ModelRelationType.ONE,
				name: 'intraoperativeRecordsId',
				// % protected region % [Customise your label for Intraoperative Records here] off begin
				label: 'Intraoperative Records',
				// % protected region % [Customise your label for Intraoperative Records here] end
				entityName: 'IntraoperativeRecordsModel',
				// % protected region % [Customise your display name for Intraoperative Records here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Intraoperative Records here] end
				validators: [
					// % protected region % [Add other validators for Intraoperative Records here] off begin
					// % protected region % [Add other validators for Intraoperative Records here] end
				],
				// % protected region % [Add any additional field for relation Intraoperative Records here] off begin
				// % protected region % [Add any additional field for relation Intraoperative Records here] end
			},
			{
				id: 'postOperativeDetails',
				type: ModelRelationType.ONE,
				name: 'postOperativeDetailsId',
				// % protected region % [Customise your label for Post Operative Details here] off begin
				label: 'Post Operative Details',
				// % protected region % [Customise your label for Post Operative Details here] end
				entityName: 'PostOperativeDetailsModel',
				// % protected region % [Customise your display name for Post Operative Details here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'recoveryStartDateTime',
				// % protected region % [Customise your display name for Post Operative Details here] end
				validators: [
					// % protected region % [Add other validators for Post Operative Details here] off begin
					// % protected region % [Add other validators for Post Operative Details here] end
				],
				// % protected region % [Add any additional field for relation Post Operative Details here] off begin
				// % protected region % [Add any additional field for relation Post Operative Details here] end
			},
			{
				id: 'preoperativeRecords',
				type: ModelRelationType.ONE,
				name: 'preoperativeRecordsId',
				// % protected region % [Customise your label for Preoperative Records here] off begin
				label: 'Preoperative Records',
				// % protected region % [Customise your label for Preoperative Records here] end
				entityName: 'PreoperativeRecordsModel',
				// % protected region % [Customise your display name for Preoperative Records here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'startDateTime',
				// % protected region % [Customise your display name for Preoperative Records here] end
				validators: [
					// % protected region % [Add other validators for Preoperative Records here] off begin
					// % protected region % [Add other validators for Preoperative Records here] end
				],
				// % protected region % [Add any additional field for relation Preoperative Records here] off begin
				// % protected region % [Add any additional field for relation Preoperative Records here] end
			},
			{
				id: 'roomFacility',
				type: ModelRelationType.ONE,
				name: 'roomFacilityId',
				// % protected region % [Customise your label for Room Facility here] off begin
				label: 'Room Facility',
				// % protected region % [Customise your label for Room Facility here] end
				entityName: 'RoomFacilityModel',
				// % protected region % [Customise your display name for Room Facility here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'roomNumber',
				// % protected region % [Customise your display name for Room Facility here] end
				validators: [
					// % protected region % [Add other validators for Room Facility here] off begin
					// % protected region % [Add other validators for Room Facility here] end
				],
				// % protected region % [Add any additional field for relation Room Facility here] off begin
				// % protected region % [Add any additional field for relation Room Facility here] end
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
				case 'bedNumber':
					break;
				case 'bedName':
					break;
				case 'treatmentClass':
					break;
				case 'availability':
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
	static deepParse(data: string | { [K in keyof BedFacilityModel]?: BedFacilityModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new BedFacilityModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.intraoperativeRecords) {
			currentModel.intraoperativeRecordsId = json.intraoperativeRecords.id;
			returned = _.union(returned, IntraoperativeRecordsModel.deepParse(json.intraoperativeRecords));
		}

		// Incoming one to many
		if (json.postOperativeDetails) {
			currentModel.postOperativeDetailsId = json.postOperativeDetails.id;
			returned = _.union(returned, PostOperativeDetailsModel.deepParse(json.postOperativeDetails));
		}

		// Incoming one to many
		if (json.preoperativeRecords) {
			currentModel.preoperativeRecordsId = json.preoperativeRecords.id;
			returned = _.union(returned, PreoperativeRecordsModel.deepParse(json.preoperativeRecords));
		}

		// Incoming one to many
		if (json.roomFacility) {
			currentModel.roomFacilityId = json.roomFacility.id;
			returned = _.union(returned, RoomFacilityModel.deepParse(json.roomFacility));
		}

		// Outgoing one to many
		if (json.bedReserves) {
			currentModel.bedReservesIds = json.bedReserves.map(model => model.id);
			returned = _.union(returned, _.flatten(json.bedReserves.map(model => BedReserveModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.inpatientMedicalExaminationRecords) {
			currentModel.inpatientMedicalExaminationRecordsIds = json.inpatientMedicalExaminationRecords.map(model => model.id);
			returned = _.union(returned, _.flatten(json.inpatientMedicalExaminationRecords.map(model => InpatientMedicalExaminationRecordModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.invoices) {
			currentModel.invoicesIds = json.invoices.map(model => model.id);
			returned = _.union(returned, _.flatten(json.invoices.map(model => InvoiceModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.registrations) {
			currentModel.registrationsIds = json.registrations.map(model => model.id);
			returned = _.union(returned, _.flatten(json.registrations.map(model => RegistrationModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.roomTransfers) {
			currentModel.roomTransfersIds = json.roomTransfers.map(model => model.id);
			returned = _.union(returned, _.flatten(json.roomTransfers.map(model => RoomTransferModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let bedFacilityModel = new BedFacilityModel(data);`
	 *
	 * @param data The input data to be initialised as the BedFacilityModel,
	 *    it is expected as a JSON string or as a nullable BedFacilityModel.
	 */
	constructor(data?: string | Partial<BedFacilityModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<BedFacilityModel>
				: data;

			this.bedNumber = json.bedNumber;
			this.bedName = json.bedName;
			this.treatmentClass = json.treatmentClass;
			this.availability = json.availability;
			this.notes = json.notes;
			this.coaCOGS = json.coaCOGS;
			this.coaSell = json.coaSell;
			this.coaInventory = json.coaInventory;
			this.intraoperativeRecordsId = json.intraoperativeRecordsId;
			this.intraoperativeRecords = json.intraoperativeRecords;
			this.postOperativeDetailsId = json.postOperativeDetailsId;
			this.postOperativeDetails = json.postOperativeDetails;
			this.preoperativeRecordsId = json.preoperativeRecordsId;
			this.preoperativeRecords = json.preoperativeRecords;
			this.roomFacilityId = json.roomFacilityId;
			this.roomFacility = json.roomFacility;
			this.bedReservesIds = json.bedReservesIds;
			this.bedReserves = json.bedReserves;
			this.inpatientMedicalExaminationRecordsIds = json.inpatientMedicalExaminationRecordsIds;
			this.inpatientMedicalExaminationRecords = json.inpatientMedicalExaminationRecords;
			this.invoicesIds = json.invoicesIds;
			this.invoices = json.invoices;
			this.registrationsIds = json.registrationsIds;
			this.registrations = json.registrations;
			this.roomTransfersIds = json.roomTransfersIds;
			this.roomTransfers = json.roomTransfers;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			bedNumber: this.bedNumber,
			bedName: this.bedName,
			treatmentClass: this.treatmentClass,
			availability: this.availability,
			notes: this.notes,
			coaCOGS: this.coaCOGS,
			coaSell: this.coaSell,
			coaInventory: this.coaInventory,
			intraoperativeRecordsId: this.intraoperativeRecordsId,
			postOperativeDetailsId: this.postOperativeDetailsId,
			preoperativeRecordsId: this.preoperativeRecordsId,
			roomFacilityId: this.roomFacilityId,
			bedReservesIds: this.bedReservesIds,
			inpatientMedicalExaminationRecordsIds: this.inpatientMedicalExaminationRecordsIds,
			invoicesIds: this.invoicesIds,
			registrationsIds: this.registrationsIds,
			roomTransfersIds: this.roomTransfersIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		BedFacilityModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): BedFacilityModel {
		let newModelJson = this.toJSON();

		if (updates.bedNumber) {
			newModelJson.bedNumber = updates.bedNumber;
		}

		if (updates.bedName) {
			newModelJson.bedName = updates.bedName;
		}

		if (updates.treatmentClass) {
			newModelJson.treatmentClass = updates.treatmentClass;
		}

		if (updates.availability) {
			newModelJson.availability = updates.availability;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.coaCOGS) {
			newModelJson.coaCOGS = updates.coaCOGS;
		}

		if (updates.coaSell) {
			newModelJson.coaSell = updates.coaSell;
		}

		if (updates.coaInventory) {
			newModelJson.coaInventory = updates.coaInventory;
		}

		if (updates.intraoperativeRecordsId) {
			newModelJson.intraoperativeRecordsId = updates.intraoperativeRecordsId;
		}

		if (updates.postOperativeDetailsId) {
			newModelJson.postOperativeDetailsId = updates.postOperativeDetailsId;
		}

		if (updates.preoperativeRecordsId) {
			newModelJson.preoperativeRecordsId = updates.preoperativeRecordsId;
		}

		if (updates.roomFacilityId) {
			newModelJson.roomFacilityId = updates.roomFacilityId;
		}

		if (updates.bedReservesIds) {
			newModelJson.bedReservesIds = updates.bedReservesIds;
		}

		if (updates.inpatientMedicalExaminationRecordsIds) {
			newModelJson.inpatientMedicalExaminationRecordsIds = updates.inpatientMedicalExaminationRecordsIds;
		}

		if (updates.invoicesIds) {
			newModelJson.invoicesIds = updates.invoicesIds;
		}

		if (updates.registrationsIds) {
			newModelJson.registrationsIds = updates.registrationsIds;
		}

		if (updates.roomTransfersIds) {
			newModelJson.roomTransfersIds = updates.roomTransfersIds;
		}

		return new BedFacilityModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof BedFacilityModel)) {
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
			'intraoperativeRecordsId',
			'intraoperativeRecords',
			'postOperativeDetailsId',
			'postOperativeDetails',
			'preoperativeRecordsId',
			'preoperativeRecords',
			'roomFacilityId',
			'roomFacility',
			'bedReservesIds',
			'bedReserves',
			'inpatientMedicalExaminationRecordsIds',
			'inpatientMedicalExaminationRecords',
			'invoicesIds',
			'invoices',
			'registrationsIds',
			'registrations',
			'roomTransfersIds',
			'roomTransfers',
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
		if (!this.intraoperativeRecords) {
			this.intraoperativeRecordsId = null;
		} else {
			this.intraoperativeRecordsId = this.intraoperativeRecords.id;
		}

		if (!this.postOperativeDetails) {
			this.postOperativeDetailsId = null;
		} else {
			this.postOperativeDetailsId = this.postOperativeDetails.id;
		}

		if (!this.preoperativeRecords) {
			this.preoperativeRecordsId = null;
		} else {
			this.preoperativeRecordsId = this.preoperativeRecords.id;
		}

		if (!this.roomFacility) {
			this.roomFacilityId = null;
		} else {
			this.roomFacilityId = this.roomFacility.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
