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
import {PrescriptionHeaderModel} from '../prescriptionHeader/prescription_header.model';
import {PrescriptionItemModel} from '../prescriptionItem/prescription_item.model';
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
export class PrescriptionCompoundModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'iterationStart',
		'iterationEnd',
		'compoundCode',
		'compoundName',
		'frequency',
		'isDtd',
		'requestedQuantity',
		'allocatedQuantity',
		'issuedQuantity',
		'consumptionMethod',
		'instruction',
		'notes',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'iterationStart',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'PrescriptionCompoundModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return PrescriptionCompoundModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Iteration Start.
	 */
	iterationStart: number;

	/**
	 * Iteration End.
	 */
	iterationEnd: number;

	/**
	 * Compound Code (Max Length: 50).
	 */
	compoundCode: string;

	/**
	 * Compound Name (Max Length: 250).
	 */
	compoundName: string;

	/**
	 * Dosage Times.
	 */
	dosageTimes: number;

	/**
	 * Dosage Days.
	 */
	dosageDays: number;

	/**
	 * Frequency, get the Code from Reference Data where Type=DRUG_FREQ. (Max Length: 20).
	 */
	frequency: string;

	/**
	 * Is dtd.
	 */
	isDtd: boolean = false;

	/**
	 * Requested Quantity(2 decimal digits).
	 */
	requestedQuantity: number;

	/**
	 * Allocated Quantity (2 decimal digits).
	 */
	allocatedQuantity: number;

	/**
	 * Issued Quantity (2 decimal digits).
	 */
	issuedQuantity: number;

	/**
	 * Consumption Method, get the Code from Reference Data where Type=CNSM_MTD. (Max Length: 20).
	 */
	consumptionMethod: string;

	/**
	 * Instruction, get the Code from Reference Data where Type=DRUG_INST. (Max Length: 20).
	 */
	instruction: string;

	/**
	 * Notes (Max Length: 500).
	 */
	notes: string;

	/**
	 * Total Price from Item of Compound on Prescription Item, 2 decimal digits.
	 */
	totalPrice: number;

	/**
	 * .
	 */
	externalCompoundName: string;

	/**
	 * Approval Status for restricted drugs in prescription, get the code from Reference Data where Type=DRUG_APPROVAL.
	 */
	approvalStatus: string;

	/**
	 * Inventory Rounding Value.
	 */
	inventoryRoundingValue: number;

	unitId: string;

	unit: UnitOfMeasurementModel;

	prescriptionHeaderId: string;

	prescriptionHeader: PrescriptionHeaderModel;

	compoundItemsIds: string[] = [];

	compoundItems: PrescriptionItemModel[];

	modelPropGroups: { [s: string]: Group } = PrescriptionCompoundModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'iterationStart',
				// % protected region % [Set displayName for Iteration Start here] off begin
				displayName: 'Iteration Start',
				// % protected region % [Set displayName for Iteration Start here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Iteration Start here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Iteration Start here] end
				// % protected region % [Set isSensitive for Iteration Start here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Iteration Start here] end
				// % protected region % [Set readonly for Iteration Start here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Iteration Start here] end
				validators: [
					// % protected region % [Add other validators for Iteration Start here] off begin
					// % protected region % [Add other validators for Iteration Start here] end
				],
				// % protected region % [Add any additional model attribute properties for Iteration Start here] off begin
				// % protected region % [Add any additional model attribute properties for Iteration Start here] end
			},
			{
				name: 'iterationEnd',
				// % protected region % [Set displayName for Iteration End here] off begin
				displayName: 'Iteration End',
				// % protected region % [Set displayName for Iteration End here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Iteration End here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Iteration End here] end
				// % protected region % [Set isSensitive for Iteration End here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Iteration End here] end
				// % protected region % [Set readonly for Iteration End here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Iteration End here] end
				validators: [
					// % protected region % [Add other validators for Iteration End here] off begin
					// % protected region % [Add other validators for Iteration End here] end
				],
				// % protected region % [Add any additional model attribute properties for Iteration End here] off begin
				// % protected region % [Add any additional model attribute properties for Iteration End here] end
			},
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
				name: 'dosageTimes',
				// % protected region % [Set displayName for Dosage Times here] off begin
				displayName: 'Dosage Times',
				// % protected region % [Set displayName for Dosage Times here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dosage Times here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dosage Times here] end
				// % protected region % [Set isSensitive for Dosage Times here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dosage Times here] end
				// % protected region % [Set readonly for Dosage Times here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dosage Times here] end
				validators: [
					// % protected region % [Add other validators for Dosage Times here] off begin
					// % protected region % [Add other validators for Dosage Times here] end
				],
				// % protected region % [Add any additional model attribute properties for Dosage Times here] off begin
				// % protected region % [Add any additional model attribute properties for Dosage Times here] end
			},
			{
				name: 'dosageDays',
				// % protected region % [Set displayName for Dosage Days here] off begin
				displayName: 'Dosage Days',
				// % protected region % [Set displayName for Dosage Days here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Dosage Days here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Dosage Days here] end
				// % protected region % [Set isSensitive for Dosage Days here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dosage Days here] end
				// % protected region % [Set readonly for Dosage Days here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dosage Days here] end
				validators: [
					// % protected region % [Add other validators for Dosage Days here] off begin
					// % protected region % [Add other validators for Dosage Days here] end
				],
				// % protected region % [Add any additional model attribute properties for Dosage Days here] off begin
				// % protected region % [Add any additional model attribute properties for Dosage Days here] end
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
				name: 'requestedQuantity',
				// % protected region % [Set displayName for Requested Quantity here] off begin
				displayName: 'Requested Quantity',
				// % protected region % [Set displayName for Requested Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Requested Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Requested Quantity here] end
				// % protected region % [Set isSensitive for Requested Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Requested Quantity here] end
				// % protected region % [Set readonly for Requested Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Requested Quantity here] end
				validators: [
					// % protected region % [Add other validators for Requested Quantity here] off begin
					// % protected region % [Add other validators for Requested Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Requested Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Requested Quantity here] end
			},
			{
				name: 'allocatedQuantity',
				// % protected region % [Set displayName for Allocated Quantity here] off begin
				displayName: 'Allocated Quantity',
				// % protected region % [Set displayName for Allocated Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Allocated Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Allocated Quantity here] end
				// % protected region % [Set isSensitive for Allocated Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Allocated Quantity here] end
				// % protected region % [Set readonly for Allocated Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Allocated Quantity here] end
				validators: [
					// % protected region % [Add other validators for Allocated Quantity here] off begin
					// % protected region % [Add other validators for Allocated Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Allocated Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Allocated Quantity here] end
			},
			{
				name: 'issuedQuantity',
				// % protected region % [Set displayName for Issued Quantity here] off begin
				displayName: 'Issued Quantity',
				// % protected region % [Set displayName for Issued Quantity here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Issued Quantity here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Issued Quantity here] end
				// % protected region % [Set isSensitive for Issued Quantity here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Issued Quantity here] end
				// % protected region % [Set readonly for Issued Quantity here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Issued Quantity here] end
				validators: [
					// % protected region % [Add other validators for Issued Quantity here] off begin
					// % protected region % [Add other validators for Issued Quantity here] end
				],
				// % protected region % [Add any additional model attribute properties for Issued Quantity here] off begin
				// % protected region % [Add any additional model attribute properties for Issued Quantity here] end
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
				id: 'compoundItems',
				type: ModelRelationType.MANY,
				name: 'compoundItemsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Compound Items here] off begin
				label: 'Compound Items',
				// % protected region % [Customise your 1-1 or 1-M label for Compound Items here] end
				entityName: 'PrescriptionItemModel',
				// % protected region % [Customise your display name for Compound Items here] off begin
				displayName: 'iterationStart',
				// % protected region % [Customise your display name for Compound Items here] end
				validators: [
					// % protected region % [Add other validators for Compound Items here] off begin
					// % protected region % [Add other validators for Compound Items here] end
				],
				// % protected region % [Add any additional field for relation Compound Items here] off begin
				// % protected region % [Add any additional field for relation Compound Items here] end
			},
			{
				id: 'unit',
				type: ModelRelationType.ONE,
				name: 'unitId',
				// % protected region % [Customise your label for Unit here] off begin
				label: 'Unit',
				// % protected region % [Customise your label for Unit here] end
				entityName: 'UnitOfMeasurementModel',
				// % protected region % [Customise your display name for Unit here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'unitName',
				// % protected region % [Customise your display name for Unit here] end
				validators: [
					// % protected region % [Add other validators for Unit here] off begin
					// % protected region % [Add other validators for Unit here] end
				],
				// % protected region % [Add any additional field for relation Unit here] off begin
				// % protected region % [Add any additional field for relation Unit here] end
			},
			{
				id: 'prescriptionHeader',
				type: ModelRelationType.ONE,
				name: 'prescriptionHeaderId',
				// % protected region % [Customise your label for Prescription Header here] off begin
				label: 'Prescription Header',
				// % protected region % [Customise your label for Prescription Header here] end
				entityName: 'PrescriptionHeaderModel',
				// % protected region % [Customise your display name for Prescription Header here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'prescriptionNumber',
				// % protected region % [Customise your display name for Prescription Header here] end
				validators: [
					// % protected region % [Add other validators for Prescription Header here] off begin
					// % protected region % [Add other validators for Prescription Header here] end
				],
				// % protected region % [Add any additional field for relation Prescription Header here] off begin
				// % protected region % [Add any additional field for relation Prescription Header here] end
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
				case 'iterationStart':
					break;
				case 'iterationEnd':
					break;
				case 'compoundCode':
					break;
				case 'compoundName':
					break;
				case 'frequency':
					break;
				case 'isDtd':
					break;
				case 'requestedQuantity':
					break;
				case 'allocatedQuantity':
					break;
				case 'issuedQuantity':
					break;
				case 'consumptionMethod':
					break;
				case 'instruction':
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
	static deepParse(data: string | { [K in keyof PrescriptionCompoundModel]?: PrescriptionCompoundModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new PrescriptionCompoundModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.unit) {
			currentModel.unitId = json.unit.id;
			returned = _.union(returned, UnitOfMeasurementModel.deepParse(json.unit));
		}

		// Incoming one to many
		if (json.prescriptionHeader) {
			currentModel.prescriptionHeaderId = json.prescriptionHeader.id;
			returned = _.union(returned, PrescriptionHeaderModel.deepParse(json.prescriptionHeader));
		}

		// Outgoing one to many
		if (json.compoundItems) {
			currentModel.compoundItemsIds = json.compoundItems.map(model => model.id);
			returned = _.union(returned, _.flatten(json.compoundItems.map(model => PrescriptionItemModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let prescriptionCompoundModel = new PrescriptionCompoundModel(data);`
	 *
	 * @param data The input data to be initialised as the PrescriptionCompoundModel,
	 *    it is expected as a JSON string or as a nullable PrescriptionCompoundModel.
	 */
	constructor(data?: string | Partial<PrescriptionCompoundModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<PrescriptionCompoundModel>
				: data;

			this.iterationStart = json.iterationStart;
			this.iterationEnd = json.iterationEnd;
			this.compoundCode = json.compoundCode;
			this.compoundName = json.compoundName;
			this.dosageTimes = json.dosageTimes;
			this.dosageDays = json.dosageDays;
			this.frequency = json.frequency;
			this.isDtd = json.isDtd;
			this.requestedQuantity = json.requestedQuantity;
			this.allocatedQuantity = json.allocatedQuantity;
			this.issuedQuantity = json.issuedQuantity;
			this.consumptionMethod = json.consumptionMethod;
			this.instruction = json.instruction;
			this.notes = json.notes;
			this.totalPrice = json.totalPrice;
			this.externalCompoundName = json.externalCompoundName;
			this.approvalStatus = json.approvalStatus;
			this.inventoryRoundingValue = json.inventoryRoundingValue;
			this.unitId = json.unitId;
			this.unit = json.unit;
			this.prescriptionHeaderId = json.prescriptionHeaderId;
			this.prescriptionHeader = json.prescriptionHeader;
			this.compoundItemsIds = json.compoundItemsIds;
			this.compoundItems = json.compoundItems;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			iterationStart: this.iterationStart,
			iterationEnd: this.iterationEnd,
			compoundCode: this.compoundCode,
			compoundName: this.compoundName,
			dosageTimes: this.dosageTimes,
			dosageDays: this.dosageDays,
			frequency: this.frequency,
			isDtd: this.isDtd,
			requestedQuantity: this.requestedQuantity,
			allocatedQuantity: this.allocatedQuantity,
			issuedQuantity: this.issuedQuantity,
			consumptionMethod: this.consumptionMethod,
			instruction: this.instruction,
			notes: this.notes,
			totalPrice: this.totalPrice,
			externalCompoundName: this.externalCompoundName,
			approvalStatus: this.approvalStatus,
			inventoryRoundingValue: this.inventoryRoundingValue,
			unitId: this.unitId,
			prescriptionHeaderId: this.prescriptionHeaderId,
			compoundItemsIds: this.compoundItemsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		PrescriptionCompoundModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): PrescriptionCompoundModel {
		let newModelJson = this.toJSON();

		if (updates.iterationStart) {
			newModelJson.iterationStart = updates.iterationStart;
		}

		if (updates.iterationEnd) {
			newModelJson.iterationEnd = updates.iterationEnd;
		}

		if (updates.compoundCode) {
			newModelJson.compoundCode = updates.compoundCode;
		}

		if (updates.compoundName) {
			newModelJson.compoundName = updates.compoundName;
		}

		if (updates.dosageTimes) {
			newModelJson.dosageTimes = updates.dosageTimes;
		}

		if (updates.dosageDays) {
			newModelJson.dosageDays = updates.dosageDays;
		}

		if (updates.frequency) {
			newModelJson.frequency = updates.frequency;
		}

		if (updates.isDtd) {
			newModelJson.isDtd = updates.isDtd;
		}

		if (updates.requestedQuantity) {
			newModelJson.requestedQuantity = updates.requestedQuantity;
		}

		if (updates.allocatedQuantity) {
			newModelJson.allocatedQuantity = updates.allocatedQuantity;
		}

		if (updates.issuedQuantity) {
			newModelJson.issuedQuantity = updates.issuedQuantity;
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

		if (updates.externalCompoundName) {
			newModelJson.externalCompoundName = updates.externalCompoundName;
		}

		if (updates.approvalStatus) {
			newModelJson.approvalStatus = updates.approvalStatus;
		}

		if (updates.inventoryRoundingValue) {
			newModelJson.inventoryRoundingValue = updates.inventoryRoundingValue;
		}

		if (updates.unitId) {
			newModelJson.unitId = updates.unitId;
		}

		if (updates.prescriptionHeaderId) {
			newModelJson.prescriptionHeaderId = updates.prescriptionHeaderId;
		}

		if (updates.compoundItemsIds) {
			newModelJson.compoundItemsIds = updates.compoundItemsIds;
		}

		return new PrescriptionCompoundModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof PrescriptionCompoundModel)) {
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
			'unitId',
			'unit',
			'prescriptionHeaderId',
			'prescriptionHeader',
			'compoundItemsIds',
			'compoundItems',
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
		if (!this.unit) {
			this.unitId = null;
		} else {
			this.unitId = this.unit.id;
		}

		if (!this.prescriptionHeader) {
			this.prescriptionHeaderId = null;
		} else {
			this.prescriptionHeaderId = this.prescriptionHeader.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
