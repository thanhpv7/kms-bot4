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
import {GoodsReceiveNoteModel} from '../goodsReceiveNote/goods_receive_note.model';
import {PurchaseOrderModel} from '../purchaseOrder/purchase_order.model';
import {PurchaseRequisitionModel} from '../purchaseRequisition/purchase_requisition.model';
import {ReturnSupplierModel} from '../returnSupplier/return_supplier.model';
import {SupplierBankAccountModel} from '../supplierBankAccount/supplier_bank_account.model';
import {SupplierContactDetailModel} from '../supplierContactDetail/supplier_contact_detail.model';
import {SupplierProductDetailModel} from '../supplierProductDetail/supplier_product_detail.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class SupplierModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'supplierNumber',
		'supplierName',
		'purchaseOrderHold',
		'leadTimeMaximum',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'supplierNumber',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'SupplierModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return SupplierModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Supplier No..
	 */
	supplierNumber: string;

	/**
	 * Supplier Name.
	 */
	supplierName: string;

	/**
	 * .
	 */
	taxID: string;

	/**
	 * Multiselect from REF DATA.
	 */
	supplyStockGroup: string;

	/**
	 * .
	 */
	adress: string;

	/**
	 * .
	 */
	country: string;

	/**
	 * .
	 */
	stateProvince: string;

	/**
	 * .
	 */
	city: string;

	/**
	 * .
	 */
	postalCode: string;

	/**
	 * Phone No..
	 */
	phoneNumber: string;

	/**
	 * Other Phone No..
	 */
	otherPhoneNumber: string;

	/**
	 * .
	 */
	fax: string;

	/**
	 * .
	 */
	email: string;

	/**
	 * .
	 */
	website: string;

	/**
	 * .
	 */
	notes: string;

	/**
	 * .
	 */
	purchaseOrderHold: boolean = false;

	/**
	 * The reason notes if Purchase Order Hold is 'true'.
	 */
	purchaseOrderHoldReason: string;

	/**
	 * .
	 */
	vatIncluded: boolean = false;

	/**
	 * Shipping Method.
	 */
	shippingMethod: string;

	/**
	 * Lead Time Minimum.
	 */
	leadTimeMinimum: number;

	/**
	 * Lead Time Maximum.
	 */
	leadTimeMaximum: number;

	/**
	 * Last Purchase Date.
	 */
	lastPurchaseDate: Date;

	/**
	 * Last Purchase Order Number.
	 */
	lastPurchaseOrderNumber: string;

	/**
	 * Lead Time Measurement.
	 */
	leadTimeMeasurement: string;

	goodsReceiveNotesIds: string[] = [];

	goodsReceiveNotes: GoodsReceiveNoteModel[];

	purchaseOrdersIds: string[] = [];

	purchaseOrders: PurchaseOrderModel[];

	purchaseRequisitionsIds: string[] = [];

	purchaseRequisitions: PurchaseRequisitionModel[];

	returnSuppliersIds: string[] = [];

	returnSuppliers: ReturnSupplierModel[];

	suplierContactDetailsIds: string[] = [];

	suplierContactDetails: SupplierContactDetailModel[];

	supplierBankAccountsIds: string[] = [];

	supplierBankAccounts: SupplierBankAccountModel[];

	supplierProductDetailsIds: string[] = [];

	supplierProductDetails: SupplierProductDetailModel[];

	modelPropGroups: { [s: string]: Group } = SupplierModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'supplierNumber',
				// % protected region % [Set displayName for Supplier Number here] off begin
				displayName: 'Supplier Number',
				// % protected region % [Set displayName for Supplier Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Supplier Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Supplier Number here] end
				// % protected region % [Set isSensitive for Supplier Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Supplier Number here] end
				// % protected region % [Set readonly for Supplier Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Supplier Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Supplier Number here] off begin
					// % protected region % [Add other validators for Supplier Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Supplier Number here] off begin
				// % protected region % [Add any additional model attribute properties for Supplier Number here] end
			},
			{
				name: 'supplierName',
				// % protected region % [Set displayName for Supplier Name here] off begin
				displayName: 'Supplier Name',
				// % protected region % [Set displayName for Supplier Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Supplier Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Supplier Name here] end
				// % protected region % [Set isSensitive for Supplier Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Supplier Name here] end
				// % protected region % [Set readonly for Supplier Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Supplier Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Supplier Name here] off begin
					// % protected region % [Add other validators for Supplier Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Supplier Name here] off begin
				// % protected region % [Add any additional model attribute properties for Supplier Name here] end
			},
			{
				name: 'taxID',
				// % protected region % [Set displayName for Tax ID here] off begin
				displayName: 'Tax ID',
				// % protected region % [Set displayName for Tax ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tax ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tax ID here] end
				// % protected region % [Set isSensitive for Tax ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax ID here] end
				// % protected region % [Set readonly for Tax ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax ID here] end
				validators: [
					// % protected region % [Add other validators for Tax ID here] off begin
					// % protected region % [Add other validators for Tax ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax ID here] off begin
				// % protected region % [Add any additional model attribute properties for Tax ID here] end
			},
			{
				name: 'supplyStockGroup',
				// % protected region % [Set displayName for Supply Stock Group here] off begin
				displayName: 'Supply Stock Group',
				// % protected region % [Set displayName for Supply Stock Group here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Supply Stock Group here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Supply Stock Group here] end
				// % protected region % [Set isSensitive for Supply Stock Group here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Supply Stock Group here] end
				// % protected region % [Set readonly for Supply Stock Group here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Supply Stock Group here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Supply Stock Group here] off begin
					// % protected region % [Add other validators for Supply Stock Group here] end
				],
				// % protected region % [Add any additional model attribute properties for Supply Stock Group here] off begin
				// % protected region % [Add any additional model attribute properties for Supply Stock Group here] end
			},
			{
				name: 'adress',
				// % protected region % [Set displayName for Adress here] off begin
				displayName: 'Adress',
				// % protected region % [Set displayName for Adress here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Adress here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Adress here] end
				// % protected region % [Set isSensitive for Adress here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Adress here] end
				// % protected region % [Set readonly for Adress here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Adress here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Adress here] off begin
					// % protected region % [Add other validators for Adress here] end
				],
				// % protected region % [Add any additional model attribute properties for Adress here] off begin
				// % protected region % [Add any additional model attribute properties for Adress here] end
			},
			{
				name: 'country',
				// % protected region % [Set displayName for Country here] off begin
				displayName: 'Country',
				// % protected region % [Set displayName for Country here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Country here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Country here] end
				// % protected region % [Set isSensitive for Country here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Country here] end
				// % protected region % [Set readonly for Country here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Country here] end
				validators: [
					// % protected region % [Add other validators for Country here] off begin
					// % protected region % [Add other validators for Country here] end
				],
				// % protected region % [Add any additional model attribute properties for Country here] off begin
				// % protected region % [Add any additional model attribute properties for Country here] end
			},
			{
				name: 'stateProvince',
				// % protected region % [Set displayName for State Province here] off begin
				displayName: 'State Province',
				// % protected region % [Set displayName for State Province here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for State Province here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for State Province here] end
				// % protected region % [Set isSensitive for State Province here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for State Province here] end
				// % protected region % [Set readonly for State Province here] off begin
				readOnly: false,
				// % protected region % [Set readonly for State Province here] end
				validators: [
					// % protected region % [Add other validators for State Province here] off begin
					// % protected region % [Add other validators for State Province here] end
				],
				// % protected region % [Add any additional model attribute properties for State Province here] off begin
				// % protected region % [Add any additional model attribute properties for State Province here] end
			},
			{
				name: 'city',
				// % protected region % [Set displayName for City here] off begin
				displayName: 'City',
				// % protected region % [Set displayName for City here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for City here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for City here] end
				// % protected region % [Set isSensitive for City here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for City here] end
				// % protected region % [Set readonly for City here] off begin
				readOnly: false,
				// % protected region % [Set readonly for City here] end
				validators: [
					// % protected region % [Add other validators for City here] off begin
					// % protected region % [Add other validators for City here] end
				],
				// % protected region % [Add any additional model attribute properties for City here] off begin
				// % protected region % [Add any additional model attribute properties for City here] end
			},
			{
				name: 'postalCode',
				// % protected region % [Set displayName for Postal Code here] off begin
				displayName: 'Postal Code',
				// % protected region % [Set displayName for Postal Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Postal Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Postal Code here] end
				// % protected region % [Set isSensitive for Postal Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Postal Code here] end
				// % protected region % [Set readonly for Postal Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Postal Code here] end
				validators: [
					// % protected region % [Add other validators for Postal Code here] off begin
					// % protected region % [Add other validators for Postal Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Postal Code here] off begin
				// % protected region % [Add any additional model attribute properties for Postal Code here] end
			},
			{
				name: 'phoneNumber',
				// % protected region % [Set displayName for Phone Number here] off begin
				displayName: 'Phone Number',
				// % protected region % [Set displayName for Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Phone Number here] end
				// % protected region % [Set isSensitive for Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Phone Number here] end
				// % protected region % [Set readonly for Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Phone Number here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Phone Number here] off begin
					// % protected region % [Add other validators for Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Phone Number here] end
			},
			{
				name: 'otherPhoneNumber',
				// % protected region % [Set displayName for Other Phone Number here] off begin
				displayName: 'Other Phone Number',
				// % protected region % [Set displayName for Other Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Other Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Other Phone Number here] end
				// % protected region % [Set isSensitive for Other Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Phone Number here] end
				// % protected region % [Set readonly for Other Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Phone Number here] end
				validators: [
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Other Phone Number here] off begin
					// % protected region % [Add other validators for Other Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Other Phone Number here] end
			},
			{
				name: 'fax',
				// % protected region % [Set displayName for Fax here] off begin
				displayName: 'Fax',
				// % protected region % [Set displayName for Fax here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Fax here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Fax here] end
				// % protected region % [Set isSensitive for Fax here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fax here] end
				// % protected region % [Set readonly for Fax here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fax here] end
				validators: [
					CustomValidators.numeric(),
					// % protected region % [Add other validators for Fax here] off begin
					// % protected region % [Add other validators for Fax here] end
				],
				// % protected region % [Add any additional model attribute properties for Fax here] off begin
				// % protected region % [Add any additional model attribute properties for Fax here] end
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
					Validators.email,
					// % protected region % [Add other validators for Email here] off begin
					// % protected region % [Add other validators for Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Email here] off begin
				// % protected region % [Add any additional model attribute properties for Email here] end
			},
			{
				name: 'website',
				// % protected region % [Set displayName for Website here] off begin
				displayName: 'Website',
				// % protected region % [Set displayName for Website here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Website here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Website here] end
				// % protected region % [Set isSensitive for Website here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Website here] end
				// % protected region % [Set readonly for Website here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Website here] end
				validators: [
					// % protected region % [Add other validators for Website here] off begin
					// % protected region % [Add other validators for Website here] end
				],
				// % protected region % [Add any additional model attribute properties for Website here] off begin
				// % protected region % [Add any additional model attribute properties for Website here] end
			},
			{
				name: 'notes',
				// % protected region % [Set displayName for Notes here] off begin
				displayName: 'Notes',
				// % protected region % [Set displayName for Notes here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Notes here] off begin
				elementType: ElementType.TEXTAREA,
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
				name: 'purchaseOrderHold',
				// % protected region % [Set displayName for Purchase Order Hold here] off begin
				displayName: 'Purchase Order Hold',
				// % protected region % [Set displayName for Purchase Order Hold here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Purchase Order Hold here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Purchase Order Hold here] end
				// % protected region % [Set isSensitive for Purchase Order Hold here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Purchase Order Hold here] end
				// % protected region % [Set readonly for Purchase Order Hold here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Purchase Order Hold here] end
				validators: [
					// % protected region % [Add other validators for Purchase Order Hold here] off begin
					// % protected region % [Add other validators for Purchase Order Hold here] end
				],
				// % protected region % [Add any additional model attribute properties for Purchase Order Hold here] off begin
				// % protected region % [Add any additional model attribute properties for Purchase Order Hold here] end
			},
			{
				name: 'purchaseOrderHoldReason',
				// % protected region % [Set displayName for Purchase Order Hold Reason here] off begin
				displayName: 'Purchase Order Hold Reason',
				// % protected region % [Set displayName for Purchase Order Hold Reason here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Purchase Order Hold Reason here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Purchase Order Hold Reason here] end
				// % protected region % [Set isSensitive for Purchase Order Hold Reason here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Purchase Order Hold Reason here] end
				// % protected region % [Set readonly for Purchase Order Hold Reason here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Purchase Order Hold Reason here] end
				validators: [
					// % protected region % [Add other validators for Purchase Order Hold Reason here] off begin
					// % protected region % [Add other validators for Purchase Order Hold Reason here] end
				],
				// % protected region % [Add any additional model attribute properties for Purchase Order Hold Reason here] off begin
				// % protected region % [Add any additional model attribute properties for Purchase Order Hold Reason here] end
			},
			{
				name: 'vatIncluded',
				// % protected region % [Set displayName for VAT Included here] off begin
				displayName: 'VAT Included',
				// % protected region % [Set displayName for VAT Included here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for VAT Included here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for VAT Included here] end
				// % protected region % [Set isSensitive for VAT Included here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for VAT Included here] end
				// % protected region % [Set readonly for VAT Included here] off begin
				readOnly: false,
				// % protected region % [Set readonly for VAT Included here] end
				validators: [
					// % protected region % [Add other validators for VAT Included here] off begin
					// % protected region % [Add other validators for VAT Included here] end
				],
				// % protected region % [Add any additional model attribute properties for VAT Included here] off begin
				// % protected region % [Add any additional model attribute properties for VAT Included here] end
			},
			{
				name: 'shippingMethod',
				// % protected region % [Set displayName for Shipping Method here] off begin
				displayName: 'Shipping Method',
				// % protected region % [Set displayName for Shipping Method here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Shipping Method here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Shipping Method here] end
				// % protected region % [Set isSensitive for Shipping Method here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Shipping Method here] end
				// % protected region % [Set readonly for Shipping Method here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Shipping Method here] end
				validators: [
					// % protected region % [Add other validators for Shipping Method here] off begin
					// % protected region % [Add other validators for Shipping Method here] end
				],
				// % protected region % [Add any additional model attribute properties for Shipping Method here] off begin
				// % protected region % [Add any additional model attribute properties for Shipping Method here] end
			},
			{
				name: 'leadTimeMinimum',
				// % protected region % [Set displayName for Lead Time Minimum here] off begin
				displayName: 'Lead Time Minimum',
				// % protected region % [Set displayName for Lead Time Minimum here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Lead Time Minimum here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Lead Time Minimum here] end
				// % protected region % [Set isSensitive for Lead Time Minimum here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lead Time Minimum here] end
				// % protected region % [Set readonly for Lead Time Minimum here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lead Time Minimum here] end
				validators: [
					// % protected region % [Add other validators for Lead Time Minimum here] off begin
					// % protected region % [Add other validators for Lead Time Minimum here] end
				],
				// % protected region % [Add any additional model attribute properties for Lead Time Minimum here] off begin
				// % protected region % [Add any additional model attribute properties for Lead Time Minimum here] end
			},
			{
				name: 'leadTimeMaximum',
				// % protected region % [Set displayName for Lead Time Maximum here] off begin
				displayName: 'Lead Time Maximum',
				// % protected region % [Set displayName for Lead Time Maximum here] end
				type: ModelPropertyType.NUMBER,
				// % protected region % [Set display element type for Lead Time Maximum here] off begin
				elementType: ElementType.NUMBER,
				// % protected region % [Set display element type for Lead Time Maximum here] end
				// % protected region % [Set isSensitive for Lead Time Maximum here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lead Time Maximum here] end
				// % protected region % [Set readonly for Lead Time Maximum here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lead Time Maximum here] end
				validators: [
					// % protected region % [Add other validators for Lead Time Maximum here] off begin
					// % protected region % [Add other validators for Lead Time Maximum here] end
				],
				// % protected region % [Add any additional model attribute properties for Lead Time Maximum here] off begin
				// % protected region % [Add any additional model attribute properties for Lead Time Maximum here] end
			},
			{
				name: 'lastPurchaseDate',
				// % protected region % [Set displayName for Last Purchase Date here] off begin
				displayName: 'Last Purchase Date',
				// % protected region % [Set displayName for Last Purchase Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Last Purchase Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Last Purchase Date here] end
				// % protected region % [Set isSensitive for Last Purchase Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Purchase Date here] end
				// % protected region % [Set readonly for Last Purchase Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Purchase Date here] end
				validators: [
					// % protected region % [Add other validators for Last Purchase Date here] off begin
					// % protected region % [Add other validators for Last Purchase Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Purchase Date here] off begin
				// % protected region % [Add any additional model attribute properties for Last Purchase Date here] end
			},
			{
				name: 'lastPurchaseOrderNumber',
				// % protected region % [Set displayName for Last Purchase Order Number here] off begin
				displayName: 'Last Purchase Order Number',
				// % protected region % [Set displayName for Last Purchase Order Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Last Purchase Order Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Last Purchase Order Number here] end
				// % protected region % [Set isSensitive for Last Purchase Order Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Last Purchase Order Number here] end
				// % protected region % [Set readonly for Last Purchase Order Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Last Purchase Order Number here] end
				validators: [
					// % protected region % [Add other validators for Last Purchase Order Number here] off begin
					// % protected region % [Add other validators for Last Purchase Order Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Last Purchase Order Number here] off begin
				// % protected region % [Add any additional model attribute properties for Last Purchase Order Number here] end
			},
			{
				name: 'leadTimeMeasurement',
				// % protected region % [Set displayName for Lead Time Measurement here] off begin
				displayName: 'Lead Time Measurement',
				// % protected region % [Set displayName for Lead Time Measurement here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Lead Time Measurement here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Lead Time Measurement here] end
				// % protected region % [Set isSensitive for Lead Time Measurement here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Lead Time Measurement here] end
				// % protected region % [Set readonly for Lead Time Measurement here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Lead Time Measurement here] end
				validators: [
					// % protected region % [Add other validators for Lead Time Measurement here] off begin
					// % protected region % [Add other validators for Lead Time Measurement here] end
				],
				// % protected region % [Add any additional model attribute properties for Lead Time Measurement here] off begin
				// % protected region % [Add any additional model attribute properties for Lead Time Measurement here] end
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
				id: 'goodsReceiveNotes',
				type: ModelRelationType.MANY,
				name: 'goodsReceiveNotesIds',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Notes here] off begin
				label: 'Goods Receive Notes',
				// % protected region % [Customise your 1-1 or 1-M label for Goods Receive Notes here] end
				entityName: 'GoodsReceiveNoteModel',
				// % protected region % [Customise your display name for Goods Receive Notes here] off begin
				displayName: 'receiveNumber',
				// % protected region % [Customise your display name for Goods Receive Notes here] end
				validators: [
					// % protected region % [Add other validators for Goods Receive Notes here] off begin
					// % protected region % [Add other validators for Goods Receive Notes here] end
				],
				// % protected region % [Add any additional field for relation Goods Receive Notes here] off begin
				// % protected region % [Add any additional field for relation Goods Receive Notes here] end
			},
			{
				id: 'purchaseOrders',
				type: ModelRelationType.MANY,
				name: 'purchaseOrdersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Orders here] off begin
				label: 'Purchase Orders',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Orders here] end
				entityName: 'PurchaseOrderModel',
				// % protected region % [Customise your display name for Purchase Orders here] off begin
				displayName: 'purchaseOrderType',
				// % protected region % [Customise your display name for Purchase Orders here] end
				validators: [
					// % protected region % [Add other validators for Purchase Orders here] off begin
					// % protected region % [Add other validators for Purchase Orders here] end
				],
				// % protected region % [Add any additional field for relation Purchase Orders here] off begin
				// % protected region % [Add any additional field for relation Purchase Orders here] end
			},
			{
				id: 'purchaseRequisitions',
				type: ModelRelationType.MANY,
				name: 'purchaseRequisitionsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisitions here] off begin
				label: 'Purchase Requisitions',
				// % protected region % [Customise your 1-1 or 1-M label for Purchase Requisitions here] end
				entityName: 'PurchaseRequisitionModel',
				// % protected region % [Customise your display name for Purchase Requisitions here] off begin
				displayName: 'purchaseRequisitionNumber',
				// % protected region % [Customise your display name for Purchase Requisitions here] end
				validators: [
					// % protected region % [Add other validators for Purchase Requisitions here] off begin
					// % protected region % [Add other validators for Purchase Requisitions here] end
				],
				// % protected region % [Add any additional field for relation Purchase Requisitions here] off begin
				// % protected region % [Add any additional field for relation Purchase Requisitions here] end
			},
			{
				id: 'returnSuppliers',
				type: ModelRelationType.MANY,
				name: 'returnSuppliersIds',
				// % protected region % [Customise your 1-1 or 1-M label for Return Suppliers here] off begin
				label: 'Return Suppliers',
				// % protected region % [Customise your 1-1 or 1-M label for Return Suppliers here] end
				entityName: 'ReturnSupplierModel',
				// % protected region % [Customise your display name for Return Suppliers here] off begin
				displayName: 'returnNumber',
				// % protected region % [Customise your display name for Return Suppliers here] end
				validators: [
					// % protected region % [Add other validators for Return Suppliers here] off begin
					// % protected region % [Add other validators for Return Suppliers here] end
				],
				// % protected region % [Add any additional field for relation Return Suppliers here] off begin
				// % protected region % [Add any additional field for relation Return Suppliers here] end
			},
			{
				id: 'suplierContactDetails',
				type: ModelRelationType.MANY,
				name: 'suplierContactDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Suplier Contact Details here] off begin
				label: 'Suplier Contact Details',
				// % protected region % [Customise your 1-1 or 1-M label for Suplier Contact Details here] end
				entityName: 'SupplierContactDetailModel',
				// % protected region % [Customise your display name for Suplier Contact Details here] off begin
				displayName: 'name',
				// % protected region % [Customise your display name for Suplier Contact Details here] end
				validators: [
					// % protected region % [Add other validators for Suplier Contact Details here] off begin
					// % protected region % [Add other validators for Suplier Contact Details here] end
				],
				// % protected region % [Add any additional field for relation Suplier Contact Details here] off begin
				// % protected region % [Add any additional field for relation Suplier Contact Details here] end
			},
			{
				id: 'supplierBankAccounts',
				type: ModelRelationType.MANY,
				name: 'supplierBankAccountsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Supplier Bank Accounts here] off begin
				label: 'Supplier Bank Accounts',
				// % protected region % [Customise your 1-1 or 1-M label for Supplier Bank Accounts here] end
				entityName: 'SupplierBankAccountModel',
				// % protected region % [Customise your display name for Supplier Bank Accounts here] off begin
				displayName: 'bankName',
				// % protected region % [Customise your display name for Supplier Bank Accounts here] end
				validators: [
					// % protected region % [Add other validators for Supplier Bank Accounts here] off begin
					// % protected region % [Add other validators for Supplier Bank Accounts here] end
				],
				// % protected region % [Add any additional field for relation Supplier Bank Accounts here] off begin
				// % protected region % [Add any additional field for relation Supplier Bank Accounts here] end
			},
			{
				id: 'supplierProductDetails',
				type: ModelRelationType.MANY,
				name: 'supplierProductDetailsIds',
				// % protected region % [Customise your 1-1 or 1-M label for Supplier Product Details here] off begin
				label: 'Supplier Product Details',
				// % protected region % [Customise your 1-1 or 1-M label for Supplier Product Details here] end
				entityName: 'SupplierProductDetailModel',
				// % protected region % [Customise your display name for Supplier Product Details here] off begin
				displayName: 'unitCode',
				// % protected region % [Customise your display name for Supplier Product Details here] end
				validators: [
					// % protected region % [Add other validators for Supplier Product Details here] off begin
					// % protected region % [Add other validators for Supplier Product Details here] end
				],
				// % protected region % [Add any additional field for relation Supplier Product Details here] off begin
				// % protected region % [Add any additional field for relation Supplier Product Details here] end
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
				case 'supplierNumber':
					break;
				case 'supplierName':
					break;
				case 'purchaseOrderHold':
					break;
				case 'leadTimeMaximum':
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
	static deepParse(data: string | { [K in keyof SupplierModel]?: SupplierModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new SupplierModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Outgoing one to many
		if (json.goodsReceiveNotes) {
			currentModel.goodsReceiveNotesIds = json.goodsReceiveNotes.map(model => model.id);
			returned = _.union(returned, _.flatten(json.goodsReceiveNotes.map(model => GoodsReceiveNoteModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.purchaseOrders) {
			currentModel.purchaseOrdersIds = json.purchaseOrders.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseOrders.map(model => PurchaseOrderModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.purchaseRequisitions) {
			currentModel.purchaseRequisitionsIds = json.purchaseRequisitions.map(model => model.id);
			returned = _.union(returned, _.flatten(json.purchaseRequisitions.map(model => PurchaseRequisitionModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.returnSuppliers) {
			currentModel.returnSuppliersIds = json.returnSuppliers.map(model => model.id);
			returned = _.union(returned, _.flatten(json.returnSuppliers.map(model => ReturnSupplierModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.suplierContactDetails) {
			currentModel.suplierContactDetailsIds = json.suplierContactDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.suplierContactDetails.map(model => SupplierContactDetailModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.supplierBankAccounts) {
			currentModel.supplierBankAccountsIds = json.supplierBankAccounts.map(model => model.id);
			returned = _.union(returned, _.flatten(json.supplierBankAccounts.map(model => SupplierBankAccountModel.deepParse(model))));
		}
		// Outgoing one to many
		if (json.supplierProductDetails) {
			currentModel.supplierProductDetailsIds = json.supplierProductDetails.map(model => model.id);
			returned = _.union(returned, _.flatten(json.supplierProductDetails.map(model => SupplierProductDetailModel.deepParse(model))));
		}

		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let supplierModel = new SupplierModel(data);`
	 *
	 * @param data The input data to be initialised as the SupplierModel,
	 *    it is expected as a JSON string or as a nullable SupplierModel.
	 */
	constructor(data?: string | Partial<SupplierModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<SupplierModel>
				: data;

			this.supplierNumber = json.supplierNumber;
			this.supplierName = json.supplierName;
			this.taxID = json.taxID;
			this.supplyStockGroup = json.supplyStockGroup;
			this.adress = json.adress;
			this.country = json.country;
			this.stateProvince = json.stateProvince;
			this.city = json.city;
			this.postalCode = json.postalCode;
			this.phoneNumber = json.phoneNumber;
			this.otherPhoneNumber = json.otherPhoneNumber;
			this.fax = json.fax;
			this.email = json.email;
			this.website = json.website;
			this.notes = json.notes;
			this.purchaseOrderHold = json.purchaseOrderHold;
			this.purchaseOrderHoldReason = json.purchaseOrderHoldReason;
			this.vatIncluded = json.vatIncluded;
			this.shippingMethod = json.shippingMethod;
			this.leadTimeMinimum = json.leadTimeMinimum;
			this.leadTimeMaximum = json.leadTimeMaximum;
			if (json.lastPurchaseDate) {
				this.lastPurchaseDate = new Date(json.lastPurchaseDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.lastPurchaseDate = json.lastPurchaseDate;
			}
			this.lastPurchaseOrderNumber = json.lastPurchaseOrderNumber;
			this.leadTimeMeasurement = json.leadTimeMeasurement;
			this.goodsReceiveNotesIds = json.goodsReceiveNotesIds;
			this.goodsReceiveNotes = json.goodsReceiveNotes;
			this.purchaseOrdersIds = json.purchaseOrdersIds;
			this.purchaseOrders = json.purchaseOrders;
			this.purchaseRequisitionsIds = json.purchaseRequisitionsIds;
			this.purchaseRequisitions = json.purchaseRequisitions;
			this.returnSuppliersIds = json.returnSuppliersIds;
			this.returnSuppliers = json.returnSuppliers;
			this.suplierContactDetailsIds = json.suplierContactDetailsIds;
			this.suplierContactDetails = json.suplierContactDetails;
			this.supplierBankAccountsIds = json.supplierBankAccountsIds;
			this.supplierBankAccounts = json.supplierBankAccounts;
			this.supplierProductDetailsIds = json.supplierProductDetailsIds;
			this.supplierProductDetails = json.supplierProductDetails;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			supplierNumber: this.supplierNumber,
			supplierName: this.supplierName,
			taxID: this.taxID,
			supplyStockGroup: this.supplyStockGroup,
			adress: this.adress,
			country: this.country,
			stateProvince: this.stateProvince,
			city: this.city,
			postalCode: this.postalCode,
			phoneNumber: this.phoneNumber,
			otherPhoneNumber: this.otherPhoneNumber,
			fax: this.fax,
			email: this.email,
			website: this.website,
			notes: this.notes,
			purchaseOrderHold: this.purchaseOrderHold,
			purchaseOrderHoldReason: this.purchaseOrderHoldReason,
			vatIncluded: this.vatIncluded,
			shippingMethod: this.shippingMethod,
			leadTimeMinimum: this.leadTimeMinimum,
			leadTimeMaximum: this.leadTimeMaximum,
			lastPurchaseDate: this.lastPurchaseDate,
			lastPurchaseOrderNumber: this.lastPurchaseOrderNumber,
			leadTimeMeasurement: this.leadTimeMeasurement,
			goodsReceiveNotesIds: this.goodsReceiveNotesIds,
			purchaseOrdersIds: this.purchaseOrdersIds,
			purchaseRequisitionsIds: this.purchaseRequisitionsIds,
			returnSuppliersIds: this.returnSuppliersIds,
			suplierContactDetailsIds: this.suplierContactDetailsIds,
			supplierBankAccountsIds: this.supplierBankAccountsIds,
			supplierProductDetailsIds: this.supplierProductDetailsIds,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		SupplierModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): SupplierModel {
		let newModelJson = this.toJSON();

		if (updates.supplierNumber) {
			newModelJson.supplierNumber = updates.supplierNumber;
		}

		if (updates.supplierName) {
			newModelJson.supplierName = updates.supplierName;
		}

		if (updates.taxID) {
			newModelJson.taxID = updates.taxID;
		}

		if (updates.supplyStockGroup) {
			newModelJson.supplyStockGroup = updates.supplyStockGroup;
		}

		if (updates.adress) {
			newModelJson.adress = updates.adress;
		}

		if (updates.country) {
			newModelJson.country = updates.country;
		}

		if (updates.stateProvince) {
			newModelJson.stateProvince = updates.stateProvince;
		}

		if (updates.city) {
			newModelJson.city = updates.city;
		}

		if (updates.postalCode) {
			newModelJson.postalCode = updates.postalCode;
		}

		if (updates.phoneNumber) {
			newModelJson.phoneNumber = updates.phoneNumber;
		}

		if (updates.otherPhoneNumber) {
			newModelJson.otherPhoneNumber = updates.otherPhoneNumber;
		}

		if (updates.fax) {
			newModelJson.fax = updates.fax;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.website) {
			newModelJson.website = updates.website;
		}

		if (updates.notes) {
			newModelJson.notes = updates.notes;
		}

		if (updates.purchaseOrderHold) {
			newModelJson.purchaseOrderHold = updates.purchaseOrderHold;
		}

		if (updates.purchaseOrderHoldReason) {
			newModelJson.purchaseOrderHoldReason = updates.purchaseOrderHoldReason;
		}

		if (updates.vatIncluded) {
			newModelJson.vatIncluded = updates.vatIncluded;
		}

		if (updates.shippingMethod) {
			newModelJson.shippingMethod = updates.shippingMethod;
		}

		if (updates.leadTimeMinimum) {
			newModelJson.leadTimeMinimum = updates.leadTimeMinimum;
		}

		if (updates.leadTimeMaximum) {
			newModelJson.leadTimeMaximum = updates.leadTimeMaximum;
		}

		if (updates.lastPurchaseDate) {
			newModelJson.lastPurchaseDate = updates.lastPurchaseDate;
		}

		if (updates.lastPurchaseOrderNumber) {
			newModelJson.lastPurchaseOrderNumber = updates.lastPurchaseOrderNumber;
		}

		if (updates.leadTimeMeasurement) {
			newModelJson.leadTimeMeasurement = updates.leadTimeMeasurement;
		}

		if (updates.goodsReceiveNotesIds) {
			newModelJson.goodsReceiveNotesIds = updates.goodsReceiveNotesIds;
		}

		if (updates.purchaseOrdersIds) {
			newModelJson.purchaseOrdersIds = updates.purchaseOrdersIds;
		}

		if (updates.purchaseRequisitionsIds) {
			newModelJson.purchaseRequisitionsIds = updates.purchaseRequisitionsIds;
		}

		if (updates.returnSuppliersIds) {
			newModelJson.returnSuppliersIds = updates.returnSuppliersIds;
		}

		if (updates.suplierContactDetailsIds) {
			newModelJson.suplierContactDetailsIds = updates.suplierContactDetailsIds;
		}

		if (updates.supplierBankAccountsIds) {
			newModelJson.supplierBankAccountsIds = updates.supplierBankAccountsIds;
		}

		if (updates.supplierProductDetailsIds) {
			newModelJson.supplierProductDetailsIds = updates.supplierProductDetailsIds;
		}

		return new SupplierModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof SupplierModel)) {
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
			'goodsReceiveNotesIds',
			'goodsReceiveNotes',
			'purchaseOrdersIds',
			'purchaseOrders',
			'purchaseRequisitionsIds',
			'purchaseRequisitions',
			'returnSuppliersIds',
			'returnSuppliers',
			'suplierContactDetailsIds',
			'suplierContactDetails',
			'supplierBankAccountsIds',
			'supplierBankAccounts',
			'supplierProductDetailsIds',
			'supplierProductDetails',
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
