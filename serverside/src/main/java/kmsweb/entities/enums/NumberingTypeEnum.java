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

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
// % protected region % [add any additional imports here] off begin
// % protected region % [add any additional imports here] end

@Schema(enumAsRef = true)
public enum NumberingTypeEnum {
	@JsonProperty("Prescription Non Compound")
	PRESCRIPTION_NON_COMPOUND("Prescription Non Compound"),
	@JsonProperty("Prescription Compound")
	PRESCRIPTION_COMPOUND("Prescription Compound"),
	@JsonProperty("Revised Prescription Non Compound")
	REVISED_PRESCRIPTION_NON_COMPOUND("Revised Prescription Non Compound"),
	@JsonProperty("Revised Prescription Compound")
	REVISED_PRESCRIPTION_COMPOUND("Revised Prescription Compound"),
	@JsonProperty("Prescription Queue")
	PRESCRIPTION_QUEUE("Prescription Queue"),
	@JsonProperty("Patient ID General")
	PATIENT_ID_GENERAL("Patient ID General"),
	@JsonProperty("Patient ID External")
	PATIENT_ID_EXTERNAL("Patient ID External"),
	@JsonProperty("Patient ID Unknown")
	PATIENT_ID_UNKNOWN("Patient ID Unknown"),
	@JsonProperty("Invoice Outpatient")
	INVOICE_OUTPATIENT("Invoice Outpatient"),
	@JsonProperty("Invoice Inpatient")
	INVOICE_INPATIENT("Invoice Inpatient"),
	@JsonProperty("Payment")
	PAYMENT("Payment"),
	@JsonProperty("Down Payment")
	DOWN_PAYMENT("Down Payment"),
	@JsonProperty("Refund")
	REFUND("Refund"),
	@JsonProperty("Registration ID")
	REGISTRATION_ID("Registration ID"),
	@JsonProperty("General Number")
	GENERAL_NUMBER("General Number"),
	@JsonProperty("Inventory Adjustment")
	INVENTORY_ADJUSTMENT("Inventory Adjustment"),
	@JsonProperty("Inventory Transfer Order")
	INVENTORY_TRANSFER_ORDER("Inventory Transfer Order"),
	@JsonProperty("Inventory Internal Order")
	INVENTORY_INTERNAL_ORDER("Inventory Internal Order"),
	@JsonProperty("Inventory Stock Issuance")
	INVENTORY_STOCK_ISSUANCE("Inventory Stock Issuance"),
	@JsonProperty("Inventory Stock Receiving")
	INVENTORY_STOCK_RECEIVING("Inventory Stock Receiving"),
	@JsonProperty("Inventory Batch Correction")
	INVENTORY_BATCH_CORRECTION("Inventory Batch Correction"),
	@JsonProperty("Purchase Requisition")
	PURCHASE_REQUISITION("Purchase Requisition"),
	@JsonProperty("Purchase Order")
	PURCHASE_ORDER("Purchase Order"),
	@JsonProperty("Purchase Good Receive Notes")
	PURCHASE_GOOD_RECEIVE_NOTES("Purchase Good Receive Notes"),
	@JsonProperty("Purchase Return Supplier")
	PURCHASE_RETURN_SUPPLIER("Purchase Return Supplier"),
	@JsonProperty("Journal Number")
	JOURNAL_NUMBER("Journal Number"),
	@JsonProperty("BPJS INACBG Claim")
	BPJS_INACBG_CLAIM("BPJS INACBG Claim"),
	// % protected region % [Add any additional ENUM literals here] off begin
	// % protected region % [Add any additional ENUM literals here] end
	;

	private final String literalValue;

	NumberingTypeEnum(String literalValue) {
		this.literalValue = literalValue;
	}

	public boolean equalsName(String name) {
		return this.literalValue.equals(name);
	}

	@Override
	public String toString() {
		return this.literalValue;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
