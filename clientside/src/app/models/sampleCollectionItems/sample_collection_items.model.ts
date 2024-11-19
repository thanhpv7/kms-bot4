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
import {SampleCollectionInformationModel} from '../sampleCollectionInformation/sample_collection_information.model';
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
export class SampleCollectionItemsModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'sampleDeliveryDateTime',
		'notes',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'sampleType',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'SampleCollectionItemsModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return SampleCollectionItemsModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Sample Type.
	 */
	sampleType: string;

	/**
	 * Sample Number.
	 */
	sampleNumber: string;

	/**
	 * Sample Taking Location.
	 */
	sampleTakingLocation: string;

	/**
	 * Volume.
	 */
	volume: string;

	/**
	 * Container.
	 */
	container: string;

	/**
	 * Transport.
	 */
	transport: string;

	/**
	 * Sample Collection Date Time.
	 */
	sampleCollectionDateTime: Date;

	/**
	 * Sample Processing Date Time.
	 */
	sampleProcessingDateTime: Date;

	/**
	 * Sample Delivery Date Time.
	 */
	sampleDeliveryDateTime: Date;

	/**
	 * Notes.
	 */
	notes: string;

	sampleCollectionInformationId: string;

	sampleCollectionInformation: SampleCollectionInformationModel;

	sampleCollectionStaffId: string;

	sampleCollectionStaff: StaffModel;

	sampleDeliveryStaffId: string;

	sampleDeliveryStaff: StaffModel;

	sampleProcessingStaffId: string;

	sampleProcessingStaff: StaffModel;

	modelPropGroups: { [s: string]: Group } = SampleCollectionItemsModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'sampleType',
				// % protected region % [Set displayName for Sample Type here] off begin
				displayName: 'Sample Type',
				// % protected region % [Set displayName for Sample Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sample Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sample Type here] end
				// % protected region % [Set isSensitive for Sample Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sample Type here] end
				// % protected region % [Set readonly for Sample Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sample Type here] end
				validators: [
					// % protected region % [Add other validators for Sample Type here] off begin
					// % protected region % [Add other validators for Sample Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Sample Type here] off begin
				// % protected region % [Add any additional model attribute properties for Sample Type here] end
			},
			{
				name: 'sampleNumber',
				// % protected region % [Set displayName for Sample Number here] off begin
				displayName: 'Sample Number',
				// % protected region % [Set displayName for Sample Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sample Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sample Number here] end
				// % protected region % [Set isSensitive for Sample Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sample Number here] end
				// % protected region % [Set readonly for Sample Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sample Number here] end
				validators: [
					// % protected region % [Add other validators for Sample Number here] off begin
					// % protected region % [Add other validators for Sample Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Sample Number here] off begin
				// % protected region % [Add any additional model attribute properties for Sample Number here] end
			},
			{
				name: 'sampleTakingLocation',
				// % protected region % [Set displayName for Sample Taking Location here] off begin
				displayName: 'Sample Taking Location',
				// % protected region % [Set displayName for Sample Taking Location here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sample Taking Location here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sample Taking Location here] end
				// % protected region % [Set isSensitive for Sample Taking Location here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sample Taking Location here] end
				// % protected region % [Set readonly for Sample Taking Location here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sample Taking Location here] end
				validators: [
					// % protected region % [Add other validators for Sample Taking Location here] off begin
					// % protected region % [Add other validators for Sample Taking Location here] end
				],
				// % protected region % [Add any additional model attribute properties for Sample Taking Location here] off begin
				// % protected region % [Add any additional model attribute properties for Sample Taking Location here] end
			},
			{
				name: 'volume',
				// % protected region % [Set displayName for Volume here] off begin
				displayName: 'Volume',
				// % protected region % [Set displayName for Volume here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Volume here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Volume here] end
				// % protected region % [Set isSensitive for Volume here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Volume here] end
				// % protected region % [Set readonly for Volume here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Volume here] end
				validators: [
					// % protected region % [Add other validators for Volume here] off begin
					// % protected region % [Add other validators for Volume here] end
				],
				// % protected region % [Add any additional model attribute properties for Volume here] off begin
				// % protected region % [Add any additional model attribute properties for Volume here] end
			},
			{
				name: 'container',
				// % protected region % [Set displayName for Container here] off begin
				displayName: 'Container',
				// % protected region % [Set displayName for Container here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Container here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Container here] end
				// % protected region % [Set isSensitive for Container here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Container here] end
				// % protected region % [Set readonly for Container here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Container here] end
				validators: [
					// % protected region % [Add other validators for Container here] off begin
					// % protected region % [Add other validators for Container here] end
				],
				// % protected region % [Add any additional model attribute properties for Container here] off begin
				// % protected region % [Add any additional model attribute properties for Container here] end
			},
			{
				name: 'transport',
				// % protected region % [Set displayName for Transport here] off begin
				displayName: 'Transport',
				// % protected region % [Set displayName for Transport here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Transport here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Transport here] end
				// % protected region % [Set isSensitive for Transport here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Transport here] end
				// % protected region % [Set readonly for Transport here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Transport here] end
				validators: [
					// % protected region % [Add other validators for Transport here] off begin
					// % protected region % [Add other validators for Transport here] end
				],
				// % protected region % [Add any additional model attribute properties for Transport here] off begin
				// % protected region % [Add any additional model attribute properties for Transport here] end
			},
			{
				name: 'sampleCollectionDateTime',
				// % protected region % [Set displayName for Sample Collection Date Time here] off begin
				displayName: 'Sample Collection Date Time',
				// % protected region % [Set displayName for Sample Collection Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Sample Collection Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Sample Collection Date Time here] end
				// % protected region % [Set isSensitive for Sample Collection Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sample Collection Date Time here] end
				// % protected region % [Set readonly for Sample Collection Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sample Collection Date Time here] end
				validators: [
					// % protected region % [Add other validators for Sample Collection Date Time here] off begin
					// % protected region % [Add other validators for Sample Collection Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Sample Collection Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Sample Collection Date Time here] end
			},
			{
				name: 'sampleProcessingDateTime',
				// % protected region % [Set displayName for Sample Processing Date Time here] off begin
				displayName: 'Sample Processing Date Time',
				// % protected region % [Set displayName for Sample Processing Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Sample Processing Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Sample Processing Date Time here] end
				// % protected region % [Set isSensitive for Sample Processing Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sample Processing Date Time here] end
				// % protected region % [Set readonly for Sample Processing Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sample Processing Date Time here] end
				validators: [
					// % protected region % [Add other validators for Sample Processing Date Time here] off begin
					// % protected region % [Add other validators for Sample Processing Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Sample Processing Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Sample Processing Date Time here] end
			},
			{
				name: 'sampleDeliveryDateTime',
				// % protected region % [Set displayName for Sample Delivery Date Time here] off begin
				displayName: 'Sample Delivery Date Time',
				// % protected region % [Set displayName for Sample Delivery Date Time here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Sample Delivery Date Time here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Sample Delivery Date Time here] end
				// % protected region % [Set isSensitive for Sample Delivery Date Time here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sample Delivery Date Time here] end
				// % protected region % [Set readonly for Sample Delivery Date Time here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sample Delivery Date Time here] end
				validators: [
					// % protected region % [Add other validators for Sample Delivery Date Time here] off begin
					// % protected region % [Add other validators for Sample Delivery Date Time here] end
				],
				// % protected region % [Add any additional model attribute properties for Sample Delivery Date Time here] off begin
				// % protected region % [Add any additional model attribute properties for Sample Delivery Date Time here] end
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
				id: 'sampleCollectionInformation',
				type: ModelRelationType.ONE,
				name: 'sampleCollectionInformationId',
				// % protected region % [Customise your label for Sample Collection Information here] off begin
				label: 'Sample Collection Information',
				// % protected region % [Customise your label for Sample Collection Information here] end
				entityName: 'SampleCollectionInformationModel',
				// % protected region % [Customise your display name for Sample Collection Information here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'patientInformed',
				// % protected region % [Customise your display name for Sample Collection Information here] end
				validators: [
					// % protected region % [Add other validators for Sample Collection Information here] off begin
					// % protected region % [Add other validators for Sample Collection Information here] end
				],
				// % protected region % [Add any additional field for relation Sample Collection Information here] off begin
				// % protected region % [Add any additional field for relation Sample Collection Information here] end
			},
			{
				id: 'sampleCollectionStaff',
				type: ModelRelationType.ONE,
				name: 'sampleCollectionStaffId',
				// % protected region % [Customise your label for Sample Collection Staff here] off begin
				label: 'Sample Collection Staff',
				// % protected region % [Customise your label for Sample Collection Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Sample Collection Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Sample Collection Staff here] end
				validators: [
					// % protected region % [Add other validators for Sample Collection Staff here] off begin
					// % protected region % [Add other validators for Sample Collection Staff here] end
				],
				// % protected region % [Add any additional field for relation Sample Collection Staff here] off begin
				// % protected region % [Add any additional field for relation Sample Collection Staff here] end
			},
			{
				id: 'sampleDeliveryStaff',
				type: ModelRelationType.ONE,
				name: 'sampleDeliveryStaffId',
				// % protected region % [Customise your label for Sample Delivery Staff here] off begin
				label: 'Sample Delivery Staff',
				// % protected region % [Customise your label for Sample Delivery Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Sample Delivery Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Sample Delivery Staff here] end
				validators: [
					// % protected region % [Add other validators for Sample Delivery Staff here] off begin
					// % protected region % [Add other validators for Sample Delivery Staff here] end
				],
				// % protected region % [Add any additional field for relation Sample Delivery Staff here] off begin
				// % protected region % [Add any additional field for relation Sample Delivery Staff here] end
			},
			{
				id: 'sampleProcessingStaff',
				type: ModelRelationType.ONE,
				name: 'sampleProcessingStaffId',
				// % protected region % [Customise your label for Sample Processing Staff here] off begin
				label: 'Sample Processing Staff',
				// % protected region % [Customise your label for Sample Processing Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Sample Processing Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Sample Processing Staff here] end
				validators: [
					// % protected region % [Add other validators for Sample Processing Staff here] off begin
					// % protected region % [Add other validators for Sample Processing Staff here] end
				],
				// % protected region % [Add any additional field for relation Sample Processing Staff here] off begin
				// % protected region % [Add any additional field for relation Sample Processing Staff here] end
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
				case 'sampleDeliveryDateTime':
					break;
				case 'notes':
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
	static deepParse(data: string | { [K in keyof SampleCollectionItemsModel]?: SampleCollectionItemsModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new SampleCollectionItemsModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.sampleCollectionInformation) {
			currentModel.sampleCollectionInformationId = json.sampleCollectionInformation.id;
			returned = _.union(returned, SampleCollectionInformationModel.deepParse(json.sampleCollectionInformation));
		}

		// Incoming one to many
		if (json.sampleCollectionStaff) {
			currentModel.sampleCollectionStaffId = json.sampleCollectionStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.sampleCollectionStaff));
		}

		// Incoming one to many
		if (json.sampleDeliveryStaff) {
			currentModel.sampleDeliveryStaffId = json.sampleDeliveryStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.sampleDeliveryStaff));
		}

		// Incoming one to many
		if (json.sampleProcessingStaff) {
			currentModel.sampleProcessingStaffId = json.sampleProcessingStaff.id;
			returned = _.union(returned, StaffModel.deepParse(json.sampleProcessingStaff));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let sampleCollectionItemsModel = new SampleCollectionItemsModel(data);`
	 *
	 * @param data The input data to be initialised as the SampleCollectionItemsModel,
	 *    it is expected as a JSON string or as a nullable SampleCollectionItemsModel.
	 */
	constructor(data?: string | Partial<SampleCollectionItemsModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<SampleCollectionItemsModel>
				: data;

			this.sampleType = json.sampleType;
			this.sampleNumber = json.sampleNumber;
			this.sampleTakingLocation = json.sampleTakingLocation;
			this.volume = json.volume;
			this.container = json.container;
			this.transport = json.transport;
			if (json.sampleCollectionDateTime) {
				this.sampleCollectionDateTime = new Date(json.sampleCollectionDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.sampleCollectionDateTime = json.sampleCollectionDateTime;
			}
			if (json.sampleProcessingDateTime) {
				this.sampleProcessingDateTime = new Date(json.sampleProcessingDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.sampleProcessingDateTime = json.sampleProcessingDateTime;
			}
			if (json.sampleDeliveryDateTime) {
				this.sampleDeliveryDateTime = new Date(json.sampleDeliveryDateTime);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.sampleDeliveryDateTime = json.sampleDeliveryDateTime;
			}
			this.notes = json.notes;
			this.sampleCollectionInformationId = json.sampleCollectionInformationId;
			this.sampleCollectionInformation = json.sampleCollectionInformation;
			this.sampleCollectionStaffId = json.sampleCollectionStaffId;
			this.sampleCollectionStaff = json.sampleCollectionStaff;
			this.sampleDeliveryStaffId = json.sampleDeliveryStaffId;
			this.sampleDeliveryStaff = json.sampleDeliveryStaff;
			this.sampleProcessingStaffId = json.sampleProcessingStaffId;
			this.sampleProcessingStaff = json.sampleProcessingStaff;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			sampleType: this.sampleType,
			sampleNumber: this.sampleNumber,
			sampleTakingLocation: this.sampleTakingLocation,
			volume: this.volume,
			container: this.container,
			transport: this.transport,
			sampleCollectionDateTime: this.sampleCollectionDateTime,
			sampleProcessingDateTime: this.sampleProcessingDateTime,
			sampleDeliveryDateTime: this.sampleDeliveryDateTime,
			notes: this.notes,
			sampleCollectionInformationId: this.sampleCollectionInformationId,
			sampleCollectionStaffId: this.sampleCollectionStaffId,
			sampleDeliveryStaffId: this.sampleDeliveryStaffId,
			sampleProcessingStaffId: this.sampleProcessingStaffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		SampleCollectionItemsModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): SampleCollectionItemsModel {
		let newModelJson = this.toJSON();

		if (updates.sampleType) {
			newModelJson.sampleType = updates.sampleType;
		}

		if (updates.sampleNumber) {
			newModelJson.sampleNumber = updates.sampleNumber;
		}

		if (updates.sampleTakingLocation) {
			newModelJson.sampleTakingLocation = updates.sampleTakingLocation;
		}

		if (updates.volume) {
			newModelJson.volume = updates.volume;
		}

		if (updates.container) {
			newModelJson.container = updates.container;
		}

		if (updates.transport) {
			newModelJson.transport = updates.transport;
		}

		if (updates.sampleCollectionDateTime) {
			newModelJson.sampleCollectionDateTime = updates.sampleCollectionDateTime;
		}

		if (updates.sampleProcessingDateTime) {
			newModelJson.sampleProcessingDateTime = updates.sampleProcessingDateTime;
		}

		if (updates.sampleDeliveryDateTime) {
			newModelJson.sampleDeliveryDateTime = updates.sampleDeliveryDateTime;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.sampleCollectionInformationId) {
			newModelJson.sampleCollectionInformationId = updates.sampleCollectionInformationId;
		}

		if (updates.sampleCollectionStaffId) {
			newModelJson.sampleCollectionStaffId = updates.sampleCollectionStaffId;
		}

		if (updates.sampleDeliveryStaffId) {
			newModelJson.sampleDeliveryStaffId = updates.sampleDeliveryStaffId;
		}

		if (updates.sampleProcessingStaffId) {
			newModelJson.sampleProcessingStaffId = updates.sampleProcessingStaffId;
		}

		return new SampleCollectionItemsModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof SampleCollectionItemsModel)) {
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
			'sampleCollectionInformationId',
			'sampleCollectionInformation',
			'sampleCollectionStaffId',
			'sampleCollectionStaff',
			'sampleDeliveryStaffId',
			'sampleDeliveryStaff',
			'sampleProcessingStaffId',
			'sampleProcessingStaff',
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
		if (!this.sampleCollectionInformation) {
			this.sampleCollectionInformationId = null;
		} else {
			this.sampleCollectionInformationId = this.sampleCollectionInformation.id;
		}

		if (!this.sampleCollectionStaff) {
			this.sampleCollectionStaffId = null;
		} else {
			this.sampleCollectionStaffId = this.sampleCollectionStaff.id;
		}

		if (!this.sampleDeliveryStaff) {
			this.sampleDeliveryStaffId = null;
		} else {
			this.sampleDeliveryStaffId = this.sampleDeliveryStaff.id;
		}

		if (!this.sampleProcessingStaff) {
			this.sampleProcessingStaffId = null;
		} else {
			this.sampleProcessingStaffId = this.sampleProcessingStaff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
