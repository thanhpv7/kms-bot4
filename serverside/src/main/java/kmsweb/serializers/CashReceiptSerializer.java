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
package kmsweb.serializers;

import kmsweb.entities.CashReceiptEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class CashReceiptSerializer extends AbstractSerializer<CashReceiptEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public CashReceiptSerializer() {
		super(CashReceiptEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(CashReceiptEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		if (value.getReceiptType() != null) {
			writeStringField(gen, "receiptType", value.getReceiptType().toString());
		}
		writeStringField(gen, "receiptNumber", value.getReceiptNumber());
		writeOffsetDateTimeField(gen, "paymentDate", value.getPaymentDate());
		writeStringField(gen, "description", value.getDescription());
		writeStringField(gen, "paymentType", value.getPaymentType());
		writeDoubleField(gen, "receiveAmount", value.getReceiveAmount());
		writeBooleanField(gen, "isvoid", value.getIsvoid());
		writeStringField(gen, "cashierLocation", value.getCashierLocation());
		writeOffsetDateTimeField(gen, "voidDateTime", value.getVoidDateTime());
		if (value.getCashChangeType() != null) {
			writeStringField(gen, "cashChangeType", value.getCashChangeType().toString());
		}
		writeDoubleField(gen, "changeAmount", value.getChangeAmount());
		writeDoubleField(gen, "allocatedAmount", value.getAllocatedAmount());
		writeDoubleField(gen, "roundingAmount", value.getRoundingAmount());
		writeDoubleField(gen, "availableAmount", value.getAvailableAmount());
		writeStringField(gen, "bankName", value.getBankName());
		writeStringField(gen, "cardType", value.getCardType());
		writeStringField(gen, "cardNo", value.getCardNo());
		writeStringField(gen, "cardHolder", value.getCardHolder());
		writeStringField(gen, "referenceNumber", value.getReferenceNumber());
		writeStringField(gen, "hospitalBankAccount", value.getHospitalBankAccount());
		writeDoubleField(gen, "surchargeAmount", value.getSurchargeAmount());
		writeDoubleField(gen, "outstandingAmount", value.getOutstandingAmount());
		writeStringField(gen, "receivedFrom", value.getReceivedFrom());
		writeStringField(gen, "patientOrCustomerName", value.getPatientOrCustomerName());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}