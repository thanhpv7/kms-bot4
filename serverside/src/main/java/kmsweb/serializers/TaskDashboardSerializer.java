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

import kmsweb.entities.TaskDashboardEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class TaskDashboardSerializer extends AbstractSerializer<TaskDashboardEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public TaskDashboardSerializer() {
		super(TaskDashboardEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(TaskDashboardEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "kdppk", value.getKdppk());
		writeIntegerField(gen, "jumlahAntrean", value.getJumlahAntrean());
		writeStringField(gen, "namapoli", value.getNamapoli());
		writeStringField(gen, "nmppk", value.getNmppk());
		writeStringField(gen, "kodepoli", value.getKodepoli());
		writeOffsetDateTimeField(gen, "insertDate", value.getInsertDate());
		writeOffsetDateTimeField(gen, "tanggal", value.getTanggal());
		writeIntegerField(gen, "waktuTask1", value.getWaktuTask1());
		writeIntegerField(gen, "waktuTask2", value.getWaktuTask2());
		writeIntegerField(gen, "waktuTask3", value.getWaktuTask3());
		writeIntegerField(gen, "waktuTask4", value.getWaktuTask4());
		writeIntegerField(gen, "waktuTask5", value.getWaktuTask5());
		writeIntegerField(gen, "waktuTask6", value.getWaktuTask6());
		writeIntegerField(gen, "avgWaktuTask1", value.getAvgWaktuTask1());
		writeIntegerField(gen, "avgWaktuTask2", value.getAvgWaktuTask2());
		writeIntegerField(gen, "avgWaktuTask3", value.getAvgWaktuTask3());
		writeIntegerField(gen, "avgWaktuTask4", value.getAvgWaktuTask4());
		writeIntegerField(gen, "avgWaktuTask5", value.getAvgWaktuTask5());
		writeIntegerField(gen, "avgWaktuTask6", value.getAvgWaktuTask6());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}