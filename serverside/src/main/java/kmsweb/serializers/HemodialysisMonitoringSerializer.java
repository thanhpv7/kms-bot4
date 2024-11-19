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

import kmsweb.entities.HemodialysisMonitoringEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class HemodialysisMonitoringSerializer extends AbstractSerializer<HemodialysisMonitoringEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public HemodialysisMonitoringSerializer() {
		super(HemodialysisMonitoringEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(HemodialysisMonitoringEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeOffsetDateTimeField(gen, "datetime", value.getDatetime());
		writeDoubleField(gen, "systole", value.getSystole());
		writeDoubleField(gen, "diastole", value.getDiastole());
		writeDoubleField(gen, "heartRate", value.getHeartRate());
		writeDoubleField(gen, "temperature", value.getTemperature());
		writeStringField(gen, "temperatureUnit", value.getTemperatureUnit());
		writeDoubleField(gen, "respiratory", value.getRespiratory());
		writeDoubleField(gen, "qb", value.getQb());
		writeDoubleField(gen, "qd", value.getQd());
		writeDoubleField(gen, "venousPressure", value.getVenousPressure());
		writeDoubleField(gen, "tmp", value.getTmp());
		writeDoubleField(gen, "ufg", value.getUfg());
		writeDoubleField(gen, "ufr", value.getUfr());
		writeDoubleField(gen, "uf", value.getUf());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}