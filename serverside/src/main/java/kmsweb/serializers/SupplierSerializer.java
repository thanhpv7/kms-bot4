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

import kmsweb.entities.SupplierEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class SupplierSerializer extends AbstractSerializer<SupplierEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public SupplierSerializer() {
		super(SupplierEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(SupplierEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "supplierNumber", value.getSupplierNumber());
		writeStringField(gen, "supplierName", value.getSupplierName());
		writeStringField(gen, "taxID", value.getTaxID());
		writeStringField(gen, "supplyStockGroup", value.getSupplyStockGroup());
		writeStringField(gen, "adress", value.getAdress());
		writeStringField(gen, "country", value.getCountry());
		writeStringField(gen, "stateProvince", value.getStateProvince());
		writeStringField(gen, "city", value.getCity());
		writeStringField(gen, "postalCode", value.getPostalCode());
		writeStringField(gen, "phoneNumber", value.getPhoneNumber());
		writeStringField(gen, "otherPhoneNumber", value.getOtherPhoneNumber());
		writeStringField(gen, "fax", value.getFax());
		writeStringField(gen, "email", value.getEmail());
		writeStringField(gen, "website", value.getWebsite());
		writeStringField(gen, "notes", value.getNotes());
		writeBooleanField(gen, "purchaseOrderHold", value.getPurchaseOrderHold());
		writeStringField(gen, "purchaseOrderHoldReason", value.getPurchaseOrderHoldReason());
		writeBooleanField(gen, "vatIncluded", value.getVatIncluded());
		writeStringField(gen, "shippingMethod", value.getShippingMethod());
		writeDoubleField(gen, "leadTimeMinimum", value.getLeadTimeMinimum());
		writeDoubleField(gen, "leadTimeMaximum", value.getLeadTimeMaximum());
		writeOffsetDateTimeField(gen, "lastPurchaseDate", value.getLastPurchaseDate());
		writeStringField(gen, "lastPurchaseOrderNumber", value.getLastPurchaseOrderNumber());
		writeStringField(gen, "leadTimeMeasurement", value.getLeadTimeMeasurement());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}