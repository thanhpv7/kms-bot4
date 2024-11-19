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
import {MedicationCompoundModel} from '../medicationCompound/medication_compound.model';
import {MedicationHeaderModel} from '../medicationHeader/medication_header.model';
import {StockCatalogueModel} from '../stockCatalogue/stock_catalogue.model';
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
export class MedicationItemModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'instruction',
		'totalIssuedQuantity',
		'totalAdministeredQuantity',
		'totalTakenHomeQuantity',
		'totalReturnedQuantity',
		'inventoryRoundingValue',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'requestedQty',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'MedicationItemModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return MedicationItemModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

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
	unitPrice: number;

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
	totalIssuedQuantity: number;

	/**
	 * .
	 */
	totalAdministeredQuantity: number;

	/**
	 * .
	 */
	totalTakenHomeQuantity: number;

	/**
	 * .
	 */
	totalReturnedQuantity: number;

	/**
	 * External Medication Name.
	 */
	externalMedicationName: string;

	/**
	 * Approval Status for restricted drugs in medication, get the code from Reference Data where Type=DRUG_APPROVAL.
	 */
	approvalStatus: string;

	/**
	 * Inventory Rounding Value.
	 */
	inventoryRoundingValue: number;

	/**
	 * DTD Quantity.
	 */
	dtdQuantity: number;

	medicationCompoundId: string;

	medicationCompound: MedicationCompoundModel;

	medicationHeaderId: string;

	medicationHeader: MedicationHeaderModel;

	stockCatalogueId: string;

	stockCatalogue: StockCatalogueModel;

	unitOfMeasurementId: string;

	unitOfMeasurement: UnitOfMeasurementModel;

	medicationAdministeredHisotriesIds: string[] = [];

	medicationAdministeredHisotries: MedicationAdministeredHistoryModel[];

	modelPropGroups: { [s: string]: Group } = MedicationItemModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
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
				name: 'unitPrice',
				// % protected region % [Set displayName for Unit Price here] off begin
				displayName: 'Unit Price',
				// % protected region % [Set displayName for Unit Price here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Unit Price here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Unit Price here] end
				// % protected region % [Set isSensitive for Unit Price here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unit Price here] end
				// % protected region % [Set readonly for Unit Price here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unit Price here] end
				validators: [
					// % protected region % [Add other validators for Unit Price here] off begin
					// % protected region % [Add other validators for Unit Price here] end
				],
				// % protected region % [Add any additional model attribute properties for Unit Price here] off begin
				// % protected region % [Add any additional model attribute properties for Unit Price here] end
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
				name: 'externalMedicationName',
				// % protected region % [Set displayName for External Medication Name here] off begin
				displayName: 'External Medication Name',
				// % protected region % [Set displayName for External Medication Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for External Medication Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for External Medication Name here] end
				// % protected region % [Set isSensitive for External Medication Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for External Medication Name here] end
				// % protected region % [Set readonly for External Medication Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for External Medication Name here] end
				validators: [
					// % protected region % [Add other validators for External Medication Name here] off begin
					// % protected region % [Add other validators for External Medication Name here] end
				],
				// % protected region % [Add any additional model attribute properties for External Medication Name here] off begin
				// % protected region % [Add any additional model attribute properties for External Medication Name here] end
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
			{
				name: 'dtdQuantity',
				// % protected region % [Set displayName for DTD Quantity here] off begin
				displayName: 'DTD Quantity',
				// % protected region % [Set displayName for DTD Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for DTD Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for DTD Quantity here] end
				// % protected region % [Set isSensitive for DTD Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for DTD Quantity here] end
				// % protected region % [Set readonly for DTD Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for DTD Quantity here] end
				validators: [
					// % protected region % [Add other validators for DTD Quantity here] off begin
					// % protected region % [Add other validators for DTD Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for DTD Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for DTD Quantity here] end
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
				id: 'medicationAdministeredHisotries',
				type: ModelRelationType.MANY,
				name: 'medicationAdministeredHisotriesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Administered Hisotries here] off begin
				label: 'Medication Administered Hisotries',
				// % protected region % [Customise your 1-1 or 1-M label for Medication Administered Hisotries here] end
				entityName: 'MedicationAdministeredHistoryModel',
				// % protected region % [Customise your display name for Medication Administered Hisotries here] off begin
				displayName: 'datetime',
				// % protected region % [Customise your display name for Medication Administered Hisotries here] end
				validators: [
					// % protected region % [Add other validators for Medication Administered Hisotries here] off begin
					// % protected region % [Add other validators for Medication Administered Hisotries here] end
				],
				// % protected region % [Add any additional field for relation Medication Administered Hisotries here] off begin
				// % protected region % [Add any additional field for relation Medication Administered Hisotries here] end
			},
			{
				id: 'medicationCompound',
				type: ModelRelationType.ONE,
				name: 'medicationCompoundId',
				// % protected region % [Customise your label for Medication Compound here] off begin
				label: 'Medication Compound',
				// % protected region % [Customise your label for Medication Compound here] end
				entityName: 'MedicationCompoundModel',
				// % protected region % [Customise your display name for Medication Compound here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'compoundCode',
				// % protected region % [Customise your display name for Medication Compound here] end
				validators: [
					// % protected region % [Add other validators for Medication Compound here] off begin
					// % protected region % [Add other validators for Medication Compound here] end
				],
				// % protected region % [Add any additional field for relation Medication Compound here] off begin
				// % protected region % [Add any additional field for relation Medication Compound here] end
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
				id: 'stockCatalogue',
				type: ModelRelationType.ONE,
				name: 'stockCatalogueId',
				// % protected region % [Customise your label for Stock Catalogue here] off begin
				label: 'Stock Catalogue',
				// % protected region % [Customise your label for Stock Catalogue here] end
				entityName: 'StockCatalogueModel',
				// % protected region % [Customise your display name for Stock Catalogue here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'trackable',
				// % protected region % [Customise your display name for Stock Catalogue here] end
				validators: [
					// % protected region % [Add other validators for Stock Catalogue here] off begin
					// % protected region % [Add other validators for Stock Catalogue here] end
				],
				// % protected region % [Add any additional field for relation Stock Catalogue here] off begin
				// % protected region % [Add any additional field for relation Stock Catalogue here] end
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
				case 'instruction':
					break;
				case 'totalIssuedQuantity':
					break;
				case 'totalAdministeredQuantity':
					break;
				case 'totalTakenHomeQuantity':
					break;
				case 'totalReturnedQuantity':
					break;
				case 'inventoryRoundingValue':
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
	static deepParse(data: string | { [K in keyof MedicationItemModel]?: MedicationItemModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new MedicationItemModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.medicationCompound) {
			currentModel.medicationCompoundId = json.medicationCompound.id;
			returned = _.union(returned, MedicationCompoundModel.deepParse(json.medicationCompound));
		}

		// Incoming one to many
		if (json.medicationHeader) {
			currentModel.medicationHeaderId = json.medicationHeader.id;
			returned = _.union(returned, MedicationHeaderModel.deepParse(json.medicationHeader));
		}

		// Incoming one to many
		if (json.stockCatalogue) {
			currentModel.stockCatalogueId = json.stockCatalogue.id;
			returned = _.union(returned, StockCatalogueModel.deepParse(json.stockCatalogue));
		}

		// Incoming one to many
		if (json.unitOfMeasurement) {
			currentModel.unitOfMeasurementId = json.unitOfMeasurement.id;
			returned = _.union(returned, UnitOfMeasurementModel.deepParse(json.unitOfMeasurement));
		}

		// Outgoing one to many
		if (json.medicationAdministeredHisotries) {
			currentModel.medicationAdministeredHisotriesIds = json.medicationAdministeredHisotries.map(model => model.id);
			returned = _.union(returned, _.flatten(json.medicationAdministeredHisotries.map(model => MedicationAdministeredHistoryModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let medicationItemModel = new MedicationItemModel(data);`
	 *
	 * @param data The input data to be initialised as the MedicationItemModel,
	 *    it is expected as a JSON string or as a nullable MedicationItemModel.
	 */
	constructor(data?: string | Partial<MedicationItemModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<MedicationItemModel>
				: data;

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
			this.unitPrice = json.unitPrice;
			this.totalPrice = json.totalPrice;
			this.isDtd = json.isDtd;
			this.totalIssuedQuantity = json.totalIssuedQuantity;
			this.totalAdministeredQuantity = json.totalAdministeredQuantity;
			this.totalTakenHomeQuantity = json.totalTakenHomeQuantity;
			this.totalReturnedQuantity = json.totalReturnedQuantity;
			this.externalMedicationName = json.externalMedicationName;
			this.approvalStatus = json.approvalStatus;
			this.inventoryRoundingValue = json.inventoryRoundingValue;
			this.dtdQuantity = json.dtdQuantity;
			this.medicationCompoundId = json.medicationCompoundId;
			this.medicationCompound = json.medicationCompound;
			this.medicationHeaderId = json.medicationHeaderId;
			this.medicationHeader = json.medicationHeader;
			this.stockCatalogueId = json.stockCatalogueId;
			this.stockCatalogue = json.stockCatalogue;
			this.unitOfMeasurementId = json.unitOfMeasurementId;
			this.unitOfMeasurement = json.unitOfMeasurement;
			this.medicationAdministeredHisotriesIds = json.medicationAdministeredHisotriesIds;
			this.medicationAdministeredHisotries = json.medicationAdministeredHisotries;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
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
			unitPrice: this.unitPrice,
			totalPrice: this.totalPrice,
			isDtd: this.isDtd,
			totalIssuedQuantity: this.totalIssuedQuantity,
			totalAdministeredQuantity: this.totalAdministeredQuantity,
			totalTakenHomeQuantity: this.totalTakenHomeQuantity,
			totalReturnedQuantity: this.totalReturnedQuantity,
			externalMedicationName: this.externalMedicationName,
			approvalStatus: this.approvalStatus,
			inventoryRoundingValue: this.inventoryRoundingValue,
			dtdQuantity: this.dtdQuantity,
			medicationCompoundId: this.medicationCompoundId,
			medicationHeaderId: this.medicationHeaderId,
			stockCatalogueId: this.stockCatalogueId,
			unitOfMeasurementId: this.unitOfMeasurementId,
			medicationAdministeredHisotriesIds: this.medicationAdministeredHisotriesIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		MedicationItemModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): MedicationItemModel {
		let newModelJson = this.toJSON();

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

		if (updates.unitPrice) {
			newModelJson.unitPrice = updates.unitPrice;
		}

		if (updates.totalPrice) {
			newModelJson.totalPrice = updates.totalPrice;
		}

		if (updates.isDtd) {
			newModelJson.isDtd = updates.isDtd;
		}

		if (updates.totalIssuedQuantity) {
			newModelJson.totalIssuedQuantity = updates.totalIssuedQuantity;
		}

		if (updates.totalAdministeredQuantity) {
			newModelJson.totalAdministeredQuantity = updates.totalAdministeredQuantity;
		}

		if (updates.totalTakenHomeQuantity) {
			newModelJson.totalTakenHomeQuantity = updates.totalTakenHomeQuantity;
		}

		if (updates.totalReturnedQuantity) {
			newModelJson.totalReturnedQuantity = updates.totalReturnedQuantity;
		}

		if (updates.externalMedicationName) {
			newModelJson.externalMedicationName = updates.externalMedicationName;
		}

		if (updates.approvalStatus) {
			newModelJson.approvalStatus = updates.approvalStatus;
		}

		if (updates.inventoryRoundingValue) {
			newModelJson.inventoryRoundingValue = updates.inventoryRoundingValue;
		}

		if (updates.dtdQuantity) {
			newModelJson.dtdQuantity = updates.dtdQuantity;
		}

		if (updates.medicationCompoundId) {
			newModelJson.medicationCompoundId = updates.medicationCompoundId;
		}

		if (updates.medicationHeaderId) {
			newModelJson.medicationHeaderId = updates.medicationHeaderId;
		}

		if (updates.stockCatalogueId) {
			newModelJson.stockCatalogueId = updates.stockCatalogueId;
		}

		if (updates.unitOfMeasurementId) {
			newModelJson.unitOfMeasurementId = updates.unitOfMeasurementId;
		}

		if (updates.medicationAdministeredHisotriesIds) {
			newModelJson.medicationAdministeredHisotriesIds = updates.medicationAdministeredHisotriesIds;
		}

		return new MedicationItemModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof MedicationItemModel)) {
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
			'medicationCompoundId',
			'medicationCompound',
			'medicationHeaderId',
			'medicationHeader',
			'stockCatalogueId',
			'stockCatalogue',
			'unitOfMeasurementId',
			'unitOfMeasurement',
			'medicationAdministeredHisotriesIds',
			'medicationAdministeredHisotries',
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
		if (!this.medicationCompound) {
			this.medicationCompoundId = null;
		} else {
			this.medicationCompoundId = this.medicationCompound.id;
		}

		if (!this.medicationHeader) {
			this.medicationHeaderId = null;
		} else {
			this.medicationHeaderId = this.medicationHeader.id;
		}

		if (!this.stockCatalogue) {
			this.stockCatalogueId = null;
		} else {
			this.stockCatalogueId = this.stockCatalogue.id;
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
