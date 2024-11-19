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

import kmsweb.entities.GoodsReceiveNoteItemEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class GoodsReceiveNoteItemSerializer extends AbstractSerializer<GoodsReceiveNoteItemEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public GoodsReceiveNoteItemSerializer() {
		super(GoodsReceiveNoteItemEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(GoodsReceiveNoteItemEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeIntegerField(gen, "itemLineNumber", value.getItemLineNumber());
		writeStringField(gen, "uop", value.getUop());
		writeDoubleField(gen, "qtyReceived", value.getQtyReceived());
		writeDoubleField(gen, "qtyOrdered", value.getQtyOrdered());
		writeDoubleField(gen, "price", value.getPrice());
		writeDoubleField(gen, "totalItemPrice", value.getTotalItemPrice());
		writeStringField(gen, "itemNotes", value.getItemNotes());
		writeDoubleField(gen, "prevQtyReceived", value.getPrevQtyReceived());
		writeStringField(gen, "uoi", value.getUoi());
		writeDoubleField(gen, "qtyReceivedUOI", value.getQtyReceivedUOI());
		writeDoubleField(gen, "priceUOI", value.getPriceUOI());
		writeDoubleField(gen, "onHandQtyUOP", value.getOnHandQtyUOP());
		writeDoubleField(gen, "maxLevelUOP", value.getMaxLevelUOP());
		writeDoubleField(gen, "discountValue", value.getDiscountValue());
		writeDoubleField(gen, "taxValue", value.getTaxValue());
		writeDoubleField(gen, "inventoryRoundingValue", value.getInventoryRoundingValue());
		writeBooleanField(gen, "discountInPercent", value.getDiscountInPercent());
		writeBooleanField(gen, "taxInPercent", value.getTaxInPercent());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}