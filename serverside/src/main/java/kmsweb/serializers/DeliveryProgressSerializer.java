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

import kmsweb.entities.DeliveryProgressEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class DeliveryProgressSerializer extends AbstractSerializer<DeliveryProgressEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public DeliveryProgressSerializer() {
		super(DeliveryProgressEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(DeliveryProgressEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeOffsetDateTimeField(gen, "progressDateTime", value.getProgressDateTime());
		writeIntegerField(gen, "fhrPerMinute", value.getFhrPerMinute());
		writeStringField(gen, "amnioticFluid", value.getAmnioticFluid());
		writeStringField(gen, "moulding", value.getMoulding());
		writeIntegerField(gen, "cervicalDilatation", value.getCervicalDilatation());
		writeStringField(gen, "fetalHeadDescent", value.getFetalHeadDescent());
		writeIntegerField(gen, "contractionQty", value.getContractionQty());
		writeStringField(gen, "contractionMins", value.getContractionMins());
		writeIntegerField(gen, "dripStrength", value.getDripStrength());
		writeIntegerField(gen, "dripNumber", value.getDripNumber());
		writeStringField(gen, "drugIV", value.getDrugIV());
		writeIntegerField(gen, "systole", value.getSystole());
		writeIntegerField(gen, "diastole", value.getDiastole());
		writeIntegerField(gen, "pulse", value.getPulse());
		writeDoubleField(gen, "temperature", value.getTemperature());
		writeStringField(gen, "temperatureUnit", value.getTemperatureUnit());
		writeStringField(gen, "urineProtein", value.getUrineProtein());
		writeStringField(gen, "urineAcetone", value.getUrineAcetone());
		writeDoubleField(gen, "urineVolume", value.getUrineVolume());
		writeStringField(gen, "progressNotes", value.getProgressNotes());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}