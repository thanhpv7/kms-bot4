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
import {MedicationAdministeredHistoryModel} from '../medicationAdministeredHistory/medication_administered_history.model';
import {MedicationHeaderModel} from '../medicationHeader/medication_header.model';
import {MedicationItemModel} from '../medicationItem/medication_item.model';
import {UnitOfMeasurementModel} from '../unitOfMeasurement/unit_of_measurement.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class MedicationCompoundModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'compoundCode',
		'compoundName',
		'instruction',
		'totalAdministeredQuantity',
		'totalIssuedQuantity',
		'totalTakenHomeQuantity',
		'totalReturnedQuantity',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'compoundCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MedicationCompoundModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MedicationCompoundModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	compoundCode: string;

	/**
	 * .
	 */
	compoundName: string;

	/**
	 * .
	 */
	requestedQty: number;

	/**
	 * .
	 */
	outstandingQty: number;

	/**
	 * .
	 */
	returnedQty: number;

	/**
	 * .
	 */
	issuedQty: number;

	/**
	 * .
	 */
	administeredQty: number;

	/**
	 * .
	 */
	takenHomeQty: number;

	/**
	 * .
	 */
	dosageFrequency: number;

	/**
	 * .
	 */
	dosageQty: number;

	/**
	 * .
	 */
	dose: number;

	/**
	 * .
	 */
	frequency: string;

	/**
	 * .
	 */
	consumptionMethod: string;

	/**
	 * .
	 */
	instruction: string;

	/**
	 * .
	 */
	notes: string;

	/**
	 * .
	 */
	totalPrice: number;

	/**
	 * .
	 */
	isDtd: boolean = false;

	/**
	 * .
	 */
	totalAdministeredQuantity: number;

	/**
	 * .
	 */
	totalIssuedQuantity: number;

	/**
	 * .
	 */
	totalTakenHomeQuantity: number;

	/**
	 * .
	 */
	totalReturnedQuantity: number;

	/**
	 * External Compound Name.
	 */
	externalCompoundName: string;

	/**
	 * Approval Status for restricted drugs in medication, get the code from Reference Data where Type=DRUG_APPROVAL.
	 */
	approvalStatus: string;

	/**
	 * Inventory Rounding Value.
	 */
	inventoryRoundingValue: number;

	medicationHeaderId: string;

	medicationHeader: MedicationHeaderModel;

	unitOfMeasurementId: string;

	unitOfMeasurement: UnitOfMeasurementModel;

	medicationAdministeredHistoriesIds: string[] = [];

	medicationAdministeredHistories: MedicationAdministeredHistoryModel[];

	medicationItemsIds: string[] = [];

	medicationItems: MedicationItemModel[];

	modelPropGroups: { [s: string]: Group } = MedicationCompoundModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'compoundCode',
				// % protected region % [Set displayName for Compound Code here] off begin
				displayName: 'Compound Code',
				// % protected region % [Set displayName for Compound Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Compound Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Compound Code here] end
				// % protected region % [Set isSensitive for Compound Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Compound Code here] end
				// % protected region % [Set readonly for Compound Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Compound Code here] end
				validators: [
					// % protected region % [Add other validators for Compound Code here] off begin
					// % protected region % [Add other validators for Compound Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Compound Code here] off begin
				// % protected region % [Add any additional model attribute properties for Compound Code here] end
			},
			{
				name: 'compoundName',
				// % protected region % [Set displayName for Compound Name here] off begin
				displayName: 'Compound Name',
				// % protected region % [Set displayName for Compound Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Compound Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Compound Name here] end
				// % protected region % [Set isSensitive for Compound Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Compound Name here] end
				// % protected region % [Set readonly for Compound Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Compound Name here] end
				validators: [
					// % protected region % [Add other validators for Compound Name here] off begin
					// % protected region % [Add other validators for Compound Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Compound Name here] off begin
				// % protected region % [Add any additional model attribute properties for Compound Name here] end
			},
			{
				name: 'requestedQty',
				// % protected region % [Set displayName for Requested Qty here] off begin
				displayName: 'Requested Qty',
				// % protected region % [Set displayName for Requested Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Requested Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Requested Qty here] end
				// % protected region % [Set isSensitive for Requested Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Requested Qty here] end
				// % protected region % [Set readonly for Requested Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Requested Qty here] end
				validators: [
					// % protected region % [Add other validators for Requested Qty here] off begin
					// % protected region % [Add other validators for Requested Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Requested Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Requested Qty here] end
			},
			{
				name: 'outstandingQty',
				// % protected region % [Set displayName for Outstanding Qty here] off begin
				displayName: 'Outstanding Qty',
				// % protected region % [Set displayName for Outstanding Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Outstanding Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Outstanding Qty here] end
				// % protected region % [Set isSensitive for Outstanding Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Outstanding Qty here] end
				// % protected region % [Set readonly for Outstanding Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Outstanding Qty here] end
				validators: [
					// % protected region % [Add other validators for Outstanding Qty here] off begin
					// % protected region % [Add other validators for Outstanding Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Outstanding Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Outstanding Qty here] end
			},
			{
				name: 'returnedQty',
				// % protected region % [Set displayName for Returned Qty here] off begin
				displayName: 'Returned Qty',
				// % protected region % [Set displayName for Returned Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Returned Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Returned Qty here] end
				// % protected region % [Set isSensitive for Returned Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Returned Qty here] end
				// % protected region % [Set readonly for Returned Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Returned Qty here] end
				validators: [
					// % protected region % [Add other validators for Returned Qty here] off begin
					// % protected region % [Add other validators for Returned Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Returned Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Returned Qty here] end
			},
			{
				name: 'issuedQty',
				// % protected region % [Set displayName for Issued Qty here] off begin
				displayName: 'Issued Qty',
				// % protected region % [Set displayName for Issued Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Issued Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Issued Qty here] end
				// % protected region % [Set isSensitive for Issued Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Issued Qty here] end
				// % protected region % [Set readonly for Issued Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Issued Qty here] end
				validators: [
					// % protected region % [Add other validators for Issued Qty here] off begin
					// % protected region % [Add other validators for Issued Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Issued Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Issued Qty here] end
			},
			{
				name: 'administeredQty',
				// % protected region % [Set displayName for Administered Qty here] off begin
				displayName: 'Administered Qty',
				// % protected region % [Set displayName for Administered Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Administered Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Administered Qty here] end
				// % protected region % [Set isSensitive for Administered Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Administered Qty here] end
				// % protected region % [Set readonly for Administered Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Administered Qty here] end
				validators: [
					// % protected region % [Add other validators for Administered Qty here] off begin
					// % protected region % [Add other validators for Administered Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Administered Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Administered Qty here] end
			},
			{
				name: 'takenHomeQty',
				// % protected region % [Set displayName for Taken Home Qty here] off begin
				displayName: 'Taken Home Qty',
				// % protected region % [Set displayName for Taken Home Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Taken Home Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Taken Home Qty here] end
				// % protected region % [Set isSensitive for Taken Home Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Taken Home Qty here] end
				// % protected region % [Set readonly for Taken Home Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Taken Home Qty here] end
				validators: [
					// % protected region % [Add other validators for Taken Home Qty here] off begin
					// % protected region % [Add other validators for Taken Home Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Taken Home Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Taken Home Qty here] end
			},
			{
				name: 'dosageFrequency',
				// % protected region % [Set displayName for Dosage Frequency here] off begin
				displayName: 'Dosage Frequency',
				// % protected region % [Set displayName for Dosage Frequency here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dosage Frequency here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dosage Frequency here] end
				// % protected region % [Set isSensitive for Dosage Frequency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dosage Frequency here] end
				// % protected region % [Set readonly for Dosage Frequency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dosage Frequency here] end
				validators: [
					// % protected region % [Add other validators for Dosage Frequency here] off begin
					// % protected region % [Add other validators for Dosage Frequency here] end
				],
				// % protected region % [Add any additional model attribute properties for Dosage Frequency here] off begin
				// % protected region % [Add any additional model attribute properties for Dosage Frequency here] end
			},
			{
				name: 'dosageQty',
				// % protected region % [Set displayName for Dosage Qty here] off begin
				displayName: 'Dosage Qty',
				// % protected region % [Set displayName for Dosage Qty here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dosage Qty here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dosage Qty here] end
				// % protected region % [Set isSensitive for Dosage Qty here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dosage Qty here] end
				// % protected region % [Set readonly for Dosage Qty here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dosage Qty here] end
				validators: [
					// % protected region % [Add other validators for Dosage Qty here] off begin
					// % protected region % [Add other validators for Dosage Qty here] end
				],
				// % protected region % [Add any additional model attribute properties for Dosage Qty here] off begin
				// % protected region % [Add any additional model attribute properties for Dosage Qty here] end
			},
			{
				name: 'dose',
				// % protected region % [Set displayName for Dose here] off begin
				displayName: 'Dose',
				// % protected region % [Set displayName for Dose here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dose here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dose here] end
				// % protected region % [Set isSensitive for Dose here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dose here] end
				// % protected region % [Set readonly for Dose here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dose here] end
				validators: [
					// % protected region % [Add other validators for Dose here] off begin
					// % protected region % [Add other validators for Dose here] end
				],
				// % protected region % [Add any additional model attribute properties for Dose here] off begin
				// % protected region % [Add any additional model attribute properties for Dose here] end
			},
			{
				name: 'frequency',
				// % protected region % [Set displayName for Frequency here] off begin
				displayName: 'Frequency',
				// % protected region % [Set displayName for Frequency here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Frequency here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Frequency here] end
				// % protected region % [Set isSensitive for Frequency here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Frequency here] end
				// % protected region % [Set readonly for Frequency here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Frequency here] end
				validators: [
					// % protected region % [Add other validators for Frequency here] off begin
					// % protected region % [Add other validators for Frequency here] end
				],
				// % protected region % [Add any additional model attribute properties for Frequency here] off begin
				// % protected region % [Add any additional model attribute properties for Frequency here] end
			},
			{
				name: 'consumptionMethod',
				// % protected region % [Set displayName for Consumption Method here] off begin
				displayName: 'Consumption Method',
				// % protected region % [Set displayName for Consumption Method here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Consumption Method here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Consumption Method here] end
				// % protected region % [Set isSensitive for Consumption Method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Consumption Method here] end
				// % protected region % [Set readonly for Consumption Method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Consumption Method here] end
				validators: [
					// % protected region % [Add other validators for Consumption Method here] off begin
					// % protected region % [Add other validators for Consumption Method here] end
				],
				// % protected region % [Add any additional model attribute properties for Consumption Method here] off begin
				// % protected region % [Add any additional model attribute properties for Consumption Method here] end
			},
			{
				name: 'instruction',
				// % protected region % [Set displayName for Instruction here] off begin
				displayName: 'Instruction',
				// % protected region % [Set displayName for Instruction here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Instruction here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Instruction here] end
				// % protected region % [Set isSensitive for Instruction here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Instruction here] end
				// % protected region % [Set readonly for Instruction here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Instruction here] end
				validators: [
					// % protected region % [Add other validators for Instruction here] off begin
					// % protected region % [Add other validators for Instruction here] end
				],
				// % protected region % [Add any additional model attribute properties for Instruction here] off begin
				// % protected region % [Add any additional model attribute properties for Instruction here] end
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
				name: 'totalPrice',
				// % protected region % [Set displayName for Total Price here] off begin
				displayName: 'Total Price',
				// % protected region % [Set displayName for Total Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Price here] end
				// % protected region % [Set isSensitive for Total Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Price here] end
				// % protected region % [Set readonly for Total Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Price here] end
				validators: [
					// % protected region % [Add other validators for Total Price here] off begin
					// % protected region % [Add other validators for Total Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Price here] off begin
				// % protected region % [Add any additional model attribute properties for Total Price here] end
			},
			{
				name: 'isDtd',
				// % protected region % [Set displayName for Is dtd here] off begin
				displayName: 'Is dtd',
				// % protected region % [Set displayName for Is dtd here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is dtd here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is dtd here] end
				// % protected region % [Set isSensitive for Is dtd here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is dtd here] end
				// % protected region % [Set readonly for Is dtd here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is dtd here] end
				validators: [
					// % protected region % [Add other validators for Is dtd here] off begin
					// % protected region % [Add other validators for Is dtd here] end
				],
				// % protected region % [Add any additional model attribute properties for Is dtd here] off begin
				// % protected region % [Add any additional model attribute properties for Is dtd here] end
			},
			{
				name: 'totalAdministeredQuantity',
				// % protected region % [Set displayName for Total Administered Quantity here] off begin
				displayName: 'Total Administered Quantity',
				// % protected region % [Set displayName for Total Administered Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Administered Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Administered Quantity here] end
				// % protected region % [Set isSensitive for Total Administered Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Administered Quantity here] end
				// % protected region % [Set readonly for Total Administered Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Administered Quantity here] end
				validators: [
					// % protected region % [Add other validators for Total Administered Quantity here] off begin
					// % protected region % [Add other validators for Total Administered Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Administered Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Total Administered Quantity here] end
			},
			{
				name: 'totalIssuedQuantity',
				// % protected region % [Set displayName for Total Issued Quantity here] off begin
				displayName: 'Total Issued Quantity',
				// % protected region % [Set displayName for Total Issued Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Issued Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Issued Quantity here] end
				// % protected region % [Set isSensitive for Total Issued Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Issued Quantity here] end
				// % protected region % [Set readonly for Total Issued Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Issued Quantity here] end
				validators: [
					// % protected region % [Add other validators for Total Issued Quantity here] off begin
					// % protected region % [Add other validators for Total Issued Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Issued Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Total Issued Quantity here] end
			},
			{
				name: 'totalTakenHomeQuantity',
				// % protected region % [Set displayName for Total Taken Home Quantity here] off begin
				displayName: 'Total Taken Home Quantity',
				// % protected region % [Set displayName for Total Taken Home Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Taken Home Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Taken Home Quantity here] end
				// % protected region % [Set isSensitive for Total Taken Home Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Taken Home Quantity here] end
				// % protected region % [Set readonly for Total Taken Home Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Taken Home Quantity here] end
				validators: [
					// % protected region % [Add other validators for Total Taken Home Quantity here] off begin
					// % protected region % [Add other validators for Total Taken Home Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Taken Home Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Total Taken Home Quantity here] end
			},
			{
				name: 'totalReturnedQuantity',
				// % protected region % [Set displayName for Total Returned Quantity here] off begin
				displayName: 'Total Returned Quantity',
				// % protected region % [Set displayName for Total Returned Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Total Returned Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Total Returned Quantity here] end
				// % protected region % [Set isSensitive for Total Returned Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Total Returned Quantity here] end
				// % protected region % [Set readonly for Total Returned Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Total Returned Quantity here] end
				validators: [
					// % protected region % [Add other validators for Total Returned Quantity here] off begin
					// % protected region % [Add other validators for Total Returned Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Total Returned Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Total Returned Quantity here] end
			},
			{
				name: 'externalCompoundName',
				// % protected region % [Set displayName for External Compound Name here] off begin
				displayName: 'External Compound Name',
				// % protected region % [Set displayName for External Compound Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for External Compound Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for External Compound Name here] end
				// % protected region % [Set isSensitive for External Compound Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for External Compound Name here] end
				// % protected region % [Set readonly for External Compound Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for External Compound Name here] end
				validators: [
					// % protected region % [Add other validators for External Compound Name here] off begin
					// % protected region % [Add other validators for External Compound Name here] end
				],
				// % protected region % [Add any additional model attribute properties for External Compound Name here] off begin
				// % protected region % [Add any additional model attribute properties for External Compound Name here] end
			},
			{
				name: 'approvalStatus',
				// % protected region % [Set displayName for Approval Status here] off begin
				displayName: 'Approval Status',
				// % protected region % [Set displayName for Approval Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Approval Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Approval Status here] end
				// % protected region % [Set isSensitive for Approval Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Approval Status here] end
				// % protected region % [Set readonly for Approval Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Approval Status here] end
				validators: [
					// % protected region % [Add other validators for Approval Status here] off begin
					// % protected region % [Add other validators for Approval Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Approval Status here] off begin
				// % protected region % [Add any additional model attribute properties for Approval Status here] end
			},
			{
				name: 'inventoryRoundingValue',
				// % protected region % [Set displayName for Inventory Rounding Value here] off begin
				displayName: 'Inventory Rounding Value',
				// % protected region % [Set displayName for Inventory Rounding Value here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Inventory Rounding Value here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Inventory Rounding Value here] end
				// % protected region % [Set isSensitive for Inventory Rounding Value here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Inventory Rounding Value here] end
				// % protected region % [Set readonly for Inventory Rounding Value here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Inventory Rounding Value here] end
				validators: [
					// % protected region % [Add other validators for Inventory Rounding Value here] off begin
					// % protected region % [Add other validators for Inventory Rounding Value here] end
				],
				// % protected region % [Add any additional model attribute properties for Inventory Rounding Value here] off begin
				// % protected region % [Add any additional model attribute properties for Inventory Rounding Value here] end
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
				id: 'medicationAdministeredHistories',
				type: ModelRelationType.MANY,
				name: 'medicationAdministeredHistoriesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Administered Histories here] off begin
				label: 'Medication Administered Histories',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Administered Histories here] end
				entityName: 'MedicationAdministeredHistoryModel',
				// % protected region % [Customise your display name for Medication Administered Histories here] off begin
				displayName: 'datetime',
				// % protected region % [Customise your display name for Medication Administered Histories here] end
				validators: [
					// % protected region % [Add other validators for Medication Administered Histories here] off begin
					// % protected region % [Add other validators for Medication Administered Histories here] end
				],
				// % protected region % [Add any additional field for relation Medication Administered Histories here] off begin
				// % protected region % [Add any additional field for relation Medication Administered Histories here] end
			},
			{
				id: 'medicationItems',
				type: ModelRelationType.MANY,
				name: 'medicationItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Items here] off begin
				label: 'Medication Items',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Items here] end
				entityName: 'MedicationItemModel',
				// % protected region % [Customise your display name for Medication Items here] off begin
				displayName: 'requestedQty',
				// % protected region % [Customise your display name for Medication Items here] end
				validators: [
					// % protected region % [Add other validators for Medication Items here] off begin
					// % protected region % [Add other validators for Medication Items here] end
				],
				// % protected region % [Add any additional field for relation Medication Items here] off begin
				// % protected region % [Add any additional field for relation Medication Items here] end
			},
			{
				id: 'medicationHeader',
				type: ModelRelationType.ONE,
				name: 'medicationHeaderId',
				// % protected region % [Customise your label for Medication Header here] off begin
				label: 'Medication Header',
				// % protected region % [Customise your label for Medication Header here] end
				entityName: 'MedicationHeaderModel',
				// % protected region % [Customise your display name for Medication Header here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'medicationNumber',
				// % protected region % [Customise your display name for Medication Header here] end
				validators: [
					// % protected region % [Add other validators for Medication Header here] off begin
					// % protected region % [Add other validators for Medication Header here] end
				],
				// % protected region % [Add any additional field for relation Medication Header here] off begin
				// % protected region % [Add any additional field for relation Medication Header here] end
			},
			{
				id: 'unitOfMeasurement',
				type: ModelRelationType.ONE,
				name: 'unitOfMeasurementId',
				// % protected region % [Customise your label for Unit Of Measurement here] off begin
				label: 'Unit Of Measurement',
				// % protected region % [Customise your label for Unit Of Measurement here] end
				entityName: 'UnitOfMeasurementModel',
				// % protected region % [Customise your display name for Unit Of Measurement here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'unitName',
				// % protected region % [Customise your display name for Unit Of Measurement here] end
				validators: [
					// % protected region % [Add other validators for Unit Of Measurement here] off begin
					// % protected region % [Add other validators for Unit Of Measurement here] end
				],
				// % protected region % [Add any additional field for relation Unit Of Measurement here] off begin
				// % protected region % [Add any additional field for relation Unit Of Measurement here] end
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
				case 'compoundCode':
					break;
				case 'compoundName':
					break;
				case 'instruction':
					break;
				case 'totalAdministeredQuantity':
					break;
				case 'totalIssuedQuantity':
					break;
				case 'totalTakenHomeQuantity':
					break;
				case 'totalReturnedQuantity':
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
	static deepParse(data: string | { [K in keyof MedicationCompoundModel]?: MedicationCompoundModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MedicationCompoundModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.medicationHeader) {
			currentModel.medicationHeaderId = json.medicationHeader.id;
			returned = _.union(returned, MedicationHeaderModel.deepParse(json.medicationHeader));
		}

		// Incoming one to many
		if (json.unitOfMeasurement) {
			currentModel.unitOfMeasurementId = json.unitOfMeasurement.id;
			returned = _.union(returned, UnitOfMeasurementModel.deepParse(json.unitOfMeasurement));
		}

		// Outgoing one to many
		if (json.medicationAdministeredHistories) {
			currentModel.medicationAdministeredHistoriesIds = json.medicationAdministeredHistories.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationAdministeredHistories.map(model => MedicationAdministeredHistoryModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.medicationItems) {
			currentModel.medicationItemsIds = json.medicationItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationItems.map(model => MedicationItemModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let medicationCompoundModel = new MedicationCompoundModel(data);`
	 *
	 * @param data The input data to be initialised as the MedicationCompoundModel,
	 *    it is expected as a JSON string or as a nullable MedicationCompoundModel.
	 */
	constructor(data?: string | Partial<MedicationCompoundModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MedicationCompoundModel>
				: data;

			this.compoundCode = json.compoundCode;
			this.compoundName = json.compoundName;
			this.requestedQty = json.requestedQty;
			this.outstandingQty = json.outstandingQty;
			this.returnedQty = json.returnedQty;
			this.issuedQty = json.issuedQty;
			this.administeredQty = json.administeredQty;
			this.takenHomeQty = json.takenHomeQty;
			this.dosageFrequency = json.dosageFrequency;
			this.dosageQty = json.dosageQty;
			this.dose = json.dose;
			this.frequency = json.frequency;
			this.consumptionMethod = json.consumptionMethod;
			this.instruction = json.instruction;
			this.notes = json.notes;
			this.totalPrice = json.totalPrice;
			this.isDtd = json.isDtd;
			this.totalAdministeredQuantity = json.totalAdministeredQuantity;
			this.totalIssuedQuantity = json.totalIssuedQuantity;
			this.totalTakenHomeQuantity = json.totalTakenHomeQuantity;
			this.totalReturnedQuantity = json.totalReturnedQuantity;
			this.externalCompoundName = json.externalCompoundName;
			this.approvalStatus = json.approvalStatus;
			this.inventoryRoundingValue = json.inventoryRoundingValue;
			this.medicationHeaderId = json.medicationHeaderId;
			this.medicationHeader = json.medicationHeader;
			this.unitOfMeasurementId = json.unitOfMeasurementId;
			this.unitOfMeasurement = json.unitOfMeasurement;
			this.medicationAdministeredHistoriesIds = json.medicationAdministeredHistoriesIds;
			this.medicationAdministeredHistories = json.medicationAdministeredHistories;
			this.medicationItemsIds = json.medicationItemsIds;
			this.medicationItems = json.medicationItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			compoundCode: this.compoundCode,
			compoundName: this.compoundName,
			requestedQty: this.requestedQty,
			outstandingQty: this.outstandingQty,
			returnedQty: this.returnedQty,
			issuedQty: this.issuedQty,
			administeredQty: this.administeredQty,
			takenHomeQty: this.takenHomeQty,
			dosageFrequency: this.dosageFrequency,
			dosageQty: this.dosageQty,
			dose: this.dose,
			frequency: this.frequency,
			consumptionMethod: this.consumptionMethod,
			instruction: this.instruction,
			notes: this.notes,
			totalPrice: this.totalPrice,
			isDtd: this.isDtd,
			totalAdministeredQuantity: this.totalAdministeredQuantity,
			totalIssuedQuantity: this.totalIssuedQuantity,
			totalTakenHomeQuantity: this.totalTakenHomeQuantity,
			totalReturnedQuantity: this.totalReturnedQuantity,
			externalCompoundName: this.externalCompoundName,
			approvalStatus: this.approvalStatus,
			inventoryRoundingValue: this.inventoryRoundingValue,
			medicationHeaderId: this.medicationHeaderId,
			unitOfMeasurementId: this.unitOfMeasurementId,
			medicationAdministeredHistoriesIds: this.medicationAdministeredHistoriesIds,
			medicationItemsIds: this.medicationItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MedicationCompoundModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MedicationCompoundModel {
		let newModelJson = this.toJSON();

		if (updates.compoundCode) {
			newModelJson.compoundCode = updates.compoundCode;
		}

		if (updates.compoundName) {
			newModelJson.compoundName = updates.compoundName;
		}

		if (updates.requestedQty) {
			newModelJson.requestedQty = updates.requestedQty;
		}

		if (updates.outstandingQty) {
			newModelJson.outstandingQty = updates.outstandingQty;
		}

		if (updates.returnedQty) {
			newModelJson.returnedQty = updates.returnedQty;
		}

		if (updates.issuedQty) {
			newModelJson.issuedQty = updates.issuedQty;
		}

		if (updates.administeredQty) {
			newModelJson.administeredQty = updates.administeredQty;
		}

		if (updates.takenHomeQty) {
			newModelJson.takenHomeQty = updates.takenHomeQty;
		}

		if (updates.dosageFrequency) {
			newModelJson.dosageFrequency = updates.dosageFrequency;
		}

		if (updates.dosageQty) {
			newModelJson.dosageQty = updates.dosageQty;
		}

		if (updates.dose) {
			newModelJson.dose = updates.dose;
		}

		if (updates.frequency) {
			newModelJson.frequency = updates.frequency;
		}

		if (updates.consumptionMethod) {
			newModelJson.consumptionMethod = updates.consumptionMethod;
		}

		if (updates.instruction) {
			newModelJson.instruction = updates.instruction;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.totalPrice) {
			newModelJson.totalPrice = updates.totalPrice;
		}

		if (updates.isDtd) {
			newModelJson.isDtd = updates.isDtd;
		}

		if (updates.totalAdministeredQuantity) {
			newModelJson.totalAdministeredQuantity = updates.totalAdministeredQuantity;
		}

		if (updates.totalIssuedQuantity) {
			newModelJson.totalIssuedQuantity = updates.totalIssuedQuantity;
		}

		if (updates.totalTakenHomeQuantity) {
			newModelJson.totalTakenHomeQuantity = updates.totalTakenHomeQuantity;
		}

		if (updates.totalReturnedQuantity) {
			newModelJson.totalReturnedQuantity = updates.totalReturnedQuantity;
		}

		if (updates.externalCompoundName) {
			newModelJson.externalCompoundName = updates.externalCompoundName;
		}

		if (updates.approvalStatus) {
			newModelJson.approvalStatus = updates.approvalStatus;
		}

		if (updates.inventoryRoundingValue) {
			newModelJson.inventoryRoundingValue = updates.inventoryRoundingValue;
		}

		if (updates.medicationHeaderId) {
			newModelJson.medicationHeaderId = updates.medicationHeaderId;
		}

		if (updates.unitOfMeasurementId) {
			newModelJson.unitOfMeasurementId = updates.unitOfMeasurementId;
		}

		if (updates.medicationAdministeredHistoriesIds) {
			newModelJson.medicationAdministeredHistoriesIds = updates.medicationAdministeredHistoriesIds;
		}

		if (updates.medicationItemsIds) {
			newModelJson.medicationItemsIds = updates.medicationItemsIds;
		}

		return new MedicationCompoundModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MedicationCompoundModel)) {
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
			'medicationHeaderId',
			'medicationHeader',
			'unitOfMeasurementId',
			'unitOfMeasurement',
			'medicationAdministeredHistoriesIds',
			'medicationAdministeredHistories',
			'medicationItemsIds',
			'medicationItems',
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
		if (!this.medicationHeader) {
			this.medicationHeaderId = null;
		} else {
			this.medicationHeaderId = this.medicationHeader.id;
		}

		if (!this.unitOfMeasurement) {
			this.unitOfMeasurementId = null;
		} else {
			this.unitOfMeasurementId = this.unitOfMeasurement.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
