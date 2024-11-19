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
package kmsweb.entities.enums;

import lombok.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@AllArgsConstructor
@ToString
public enum NumberingTypeEnum {
	// % protected region % [Add any additional enum literals here] off begin
	// % protected region % [Add any additional enum literals here] end
	PRESCRIPTION_NON_COMPOUND("Prescription Non Compound"),
	PRESCRIPTION_COMPOUND("Prescription Compound"),
	REVISED_PRESCRIPTION_NON_COMPOUND("Revised Prescription Non Compound"),
	REVISED_PRESCRIPTION_COMPOUND("Revised Prescription Compound"),
	PRESCRIPTION_QUEUE("Prescription Queue"),
	PATIENT_ID_GENERAL("Patient ID General"),
	PATIENT_ID_EXTERNAL("Patient ID External"),
	PATIENT_ID_UNKNOWN("Patient ID Unknown"),
	INVOICE_OUTPATIENT("Invoice Outpatient"),
	INVOICE_INPATIENT("Invoice Inpatient"),
	PAYMENT("Payment"),
	DOWN_PAYMENT("Down Payment"),
	REFUND("Refund"),
	REGISTRATION_ID("Registration ID"),
	GENERAL_NUMBER("General Number"),
	INVENTORY_ADJUSTMENT("Inventory Adjustment"),
	INVENTORY_TRANSFER_ORDER("Inventory Transfer Order"),
	INVENTORY_INTERNAL_ORDER("Inventory Internal Order"),
	INVENTORY_STOCK_ISSUANCE("Inventory Stock Issuance"),
	INVENTORY_STOCK_RECEIVING("Inventory Stock Receiving"),
	INVENTORY_BATCH_CORRECTION("Inventory Batch Correction"),
	PURCHASE_REQUISITION("Purchase Requisition"),
	PURCHASE_ORDER("Purchase Order"),
	PURCHASE_GOOD_RECEIVE_NOTES("Purchase Good Receive Notes"),
	PURCHASE_RETURN_SUPPLIER("Purchase Return Supplier"),
	JOURNAL_NUMBER("Journal Number"),
	BPJS_INACBG_CLAIM("BPJS INACBG Claim");

	@Getter
	private String literalValue;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
