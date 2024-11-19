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

import kmsweb.entities.BodyChartExaminationEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class BodyChartExaminationSerializer extends AbstractSerializer<BodyChartExaminationEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public BodyChartExaminationSerializer() {
		super(BodyChartExaminationEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(BodyChartExaminationEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "bc01Subjective", value.getBc01Subjective());
		writeStringField(gen, "bc01Objective", value.getBc01Objective());
		writeStringField(gen, "bc02Subjective", value.getBc02Subjective());
		writeStringField(gen, "bc02Objective", value.getBc02Objective());
		writeStringField(gen, "bc03Subjective", value.getBc03Subjective());
		writeStringField(gen, "bc03Objective", value.getBc03Objective());
		writeStringField(gen, "bc04Subjective", value.getBc04Subjective());
		writeStringField(gen, "bc04Objective", value.getBc04Objective());
		writeStringField(gen, "bc05Subjective", value.getBc05Subjective());
		writeStringField(gen, "bc05Objective", value.getBc05Objective());
		writeStringField(gen, "bc06Subjective", value.getBc06Subjective());
		writeStringField(gen, "bc06Objective", value.getBc06Objective());
		writeStringField(gen, "bc07Subjective", value.getBc07Subjective());
		writeStringField(gen, "bc07Objective", value.getBc07Objective());
		writeStringField(gen, "bc08Subjective", value.getBc08Subjective());
		writeStringField(gen, "bc08Objective", value.getBc08Objective());
		writeStringField(gen, "bc09Subjective", value.getBc09Subjective());
		writeStringField(gen, "bc09Objective", value.getBc09Objective());
		writeStringField(gen, "bc10Subjective", value.getBc10Subjective());
		writeStringField(gen, "bc10Objective", value.getBc10Objective());
		writeStringField(gen, "bc11Subjective", value.getBc11Subjective());
		writeStringField(gen, "bc11Objective", value.getBc11Objective());
		writeStringField(gen, "bc12Subjective", value.getBc12Subjective());
		writeStringField(gen, "bc12Objective", value.getBc12Objective());
		writeStringField(gen, "bc13Subjective", value.getBc13Subjective());
		writeStringField(gen, "bc13Objective", value.getBc13Objective());
		writeStringField(gen, "bc14Subjective", value.getBc14Subjective());
		writeStringField(gen, "bc14Objective", value.getBc14Objective());
		writeStringField(gen, "bc15Subjective", value.getBc15Subjective());
		writeStringField(gen, "bc15Objective", value.getBc15Objective());
		writeStringField(gen, "bc16Subjective", value.getBc16Subjective());
		writeStringField(gen, "bc16Objective", value.getBc16Objective());
		writeStringField(gen, "bc17Subjective", value.getBc17Subjective());
		writeStringField(gen, "bc17Objective", value.getBc17Objective());
		writeStringField(gen, "bc18Subjective", value.getBc18Subjective());
		writeStringField(gen, "bc18Objective", value.getBc18Objective());
		writeStringField(gen, "bc19Subjective", value.getBc19Subjective());
		writeStringField(gen, "bc19Objective", value.getBc19Objective());
		writeStringField(gen, "bc20Subjective", value.getBc20Subjective());
		writeStringField(gen, "bc20Objective", value.getBc20Objective());
		writeStringField(gen, "bc21Subjective", value.getBc21Subjective());
		writeStringField(gen, "bc21Objective", value.getBc21Objective());
		writeStringField(gen, "bc22Subjective", value.getBc22Subjective());
		writeStringField(gen, "bc22Objective", value.getBc22Objective());
		writeStringField(gen, "bc23Subjective", value.getBc23Subjective());
		writeStringField(gen, "bc23Objective", value.getBc23Objective());
		writeStringField(gen, "bc24Subjective", value.getBc24Subjective());
		writeStringField(gen, "bc24Objective", value.getBc24Objective());
		writeStringField(gen, "bc25Subjective", value.getBc25Subjective());
		writeStringField(gen, "bc25Objective", value.getBc25Objective());
		writeStringField(gen, "bc26Subjective", value.getBc26Subjective());
		writeStringField(gen, "bc26Objective", value.getBc26Objective());
		writeStringField(gen, "bc27Subjective", value.getBc27Subjective());
		writeStringField(gen, "bc27Objective", value.getBc27Objective());
		writeStringField(gen, "bc28Subjective", value.getBc28Subjective());
		writeStringField(gen, "bc28Objective", value.getBc28Objective());
		writeStringField(gen, "bc29Subjective", value.getBc29Subjective());
		writeStringField(gen, "bc29Objective", value.getBc29Objective());
		writeStringField(gen, "bc30Subjective", value.getBc30Subjective());
		writeStringField(gen, "bc30Objective", value.getBc30Objective());
		writeStringField(gen, "bc31Subjective", value.getBc31Subjective());
		writeStringField(gen, "bc31Objective", value.getBc31Objective());
		writeStringField(gen, "bc32Subjective", value.getBc32Subjective());
		writeStringField(gen, "bc32Objective", value.getBc32Objective());
		writeStringField(gen, "bc33Subjective", value.getBc33Subjective());
		writeStringField(gen, "bc33Objective", value.getBc33Objective());
		writeStringField(gen, "bc34Subjective", value.getBc34Subjective());
		writeStringField(gen, "bc34Objective", value.getBc34Objective());
		writeStringField(gen, "bc35Subjective", value.getBc35Subjective());
		writeStringField(gen, "bc35Objective", value.getBc35Objective());
		writeStringField(gen, "bc36Subjective", value.getBc36Subjective());
		writeStringField(gen, "bc36Objective", value.getBc36Objective());
		writeStringField(gen, "bc37Subjective", value.getBc37Subjective());
		writeStringField(gen, "bc37Objective", value.getBc37Objective());
		writeStringField(gen, "bc38Subjective", value.getBc38Subjective());
		writeStringField(gen, "bc38Objective", value.getBc38Objective());
		writeStringField(gen, "bc39Subjective", value.getBc39Subjective());
		writeStringField(gen, "bc39Objective", value.getBc39Objective());
		writeStringField(gen, "bc40Subjective", value.getBc40Subjective());
		writeStringField(gen, "bc40Objective", value.getBc40Objective());
		writeStringField(gen, "bc41Subjective", value.getBc41Subjective());
		writeStringField(gen, "bc41Objective", value.getBc41Objective());
		writeStringField(gen, "bc42Subjective", value.getBc42Subjective());
		writeStringField(gen, "bc42Objective", value.getBc42Objective());
		writeStringField(gen, "bc43Subjective", value.getBc43Subjective());
		writeStringField(gen, "bc43Objective", value.getBc43Objective());
		writeStringField(gen, "bc44Subjective", value.getBc44Subjective());
		writeStringField(gen, "bc44Objective", value.getBc44Objective());
		writeStringField(gen, "bc45Subjective", value.getBc45Subjective());
		writeStringField(gen, "bc45Objective", value.getBc45Objective());
		writeStringField(gen, "bc46Subjective", value.getBc46Subjective());
		writeStringField(gen, "bc46Objective", value.getBc46Objective());
		writeStringField(gen, "bc47Subjective", value.getBc47Subjective());
		writeStringField(gen, "bc47Objective", value.getBc47Objective());
		writeStringField(gen, "bc48Subjective", value.getBc48Subjective());
		writeStringField(gen, "bc48Objective", value.getBc48Objective());
		writeStringField(gen, "bc49Subjective", value.getBc49Subjective());
		writeStringField(gen, "bc49Objective", value.getBc49Objective());
		writeStringField(gen, "bc50Subjective", value.getBc50Subjective());
		writeStringField(gen, "bc50Objective", value.getBc50Objective());
		writeStringField(gen, "bc51Subjective", value.getBc51Subjective());
		writeStringField(gen, "bc51Objective", value.getBc51Objective());
		writeStringField(gen, "bc52Subjective", value.getBc52Subjective());
		writeStringField(gen, "bc52Objective", value.getBc52Objective());
		writeStringField(gen, "bc53Subjective", value.getBc53Subjective());
		writeStringField(gen, "bc53Objective", value.getBc53Objective());
		writeStringField(gen, "bc54Subjective", value.getBc54Subjective());
		writeStringField(gen, "bc54Objective", value.getBc54Objective());
		writeStringField(gen, "bc55Subjective", value.getBc55Subjective());
		writeStringField(gen, "bc55Objective", value.getBc55Objective());
		writeStringField(gen, "bc56Subjective", value.getBc56Subjective());
		writeStringField(gen, "bc56Objective", value.getBc56Objective());
		writeStringField(gen, "bc57Subjective", value.getBc57Subjective());
		writeStringField(gen, "bc57Objective", value.getBc57Objective());
		writeStringField(gen, "bc58Subjective", value.getBc58Subjective());
		writeStringField(gen, "bc58Objective", value.getBc58Objective());
		writeStringField(gen, "bc59Subjective", value.getBc59Subjective());
		writeStringField(gen, "bc59Objective", value.getBc59Objective());
		writeStringField(gen, "bc60Subjective", value.getBc60Subjective());
		writeStringField(gen, "bc60Objective", value.getBc60Objective());
		writeStringField(gen, "bc61Subjective", value.getBc61Subjective());
		writeStringField(gen, "bc61Objective", value.getBc61Objective());
		writeStringField(gen, "bc62Subjective", value.getBc62Subjective());
		writeStringField(gen, "bc62Objective", value.getBc62Objective());
		writeStringField(gen, "bc63Subjective", value.getBc63Subjective());
		writeStringField(gen, "bc63Objective", value.getBc63Objective());
		writeStringField(gen, "bc64Subjective", value.getBc64Subjective());
		writeStringField(gen, "bc64Objective", value.getBc64Objective());
		writeStringField(gen, "bc65Subjective", value.getBc65Subjective());
		writeStringField(gen, "bc65Objective", value.getBc65Objective());
		writeStringField(gen, "bc66Subjective", value.getBc66Subjective());
		writeStringField(gen, "bc66Objective", value.getBc66Objective());
		writeStringField(gen, "bc67Subjective", value.getBc67Subjective());
		writeStringField(gen, "bc67Objective", value.getBc67Objective());
		writeStringField(gen, "bc68Subjective", value.getBc68Subjective());
		writeStringField(gen, "bc68Objective", value.getBc68Objective());
		writeStringField(gen, "bc69Subjective", value.getBc69Subjective());
		writeStringField(gen, "bc69Objective", value.getBc69Objective());
		writeStringField(gen, "bc70Subjective", value.getBc70Subjective());
		writeStringField(gen, "bc70Objective", value.getBc70Objective());
		writeStringField(gen, "bc71Subjective", value.getBc71Subjective());
		writeStringField(gen, "bc71Objective", value.getBc71Objective());
		writeStringField(gen, "bc72Subjective", value.getBc72Subjective());
		writeStringField(gen, "bc72Objective", value.getBc72Objective());
		writeStringField(gen, "bc73Subjective", value.getBc73Subjective());
		writeStringField(gen, "bc73Objective", value.getBc73Objective());
		writeStringField(gen, "bc74Subjective", value.getBc74Subjective());
		writeStringField(gen, "bc74Objective", value.getBc74Objective());
		writeStringField(gen, "bc75Subjective", value.getBc75Subjective());
		writeStringField(gen, "bc75Objective", value.getBc75Objective());
		writeStringField(gen, "bc76Subjective", value.getBc76Subjective());
		writeStringField(gen, "bc76Objective", value.getBc76Objective());
		writeStringField(gen, "bc77Subjective", value.getBc77Subjective());
		writeStringField(gen, "bc77Objective", value.getBc77Objective());
		writeStringField(gen, "bc78Subjective", value.getBc78Subjective());
		writeStringField(gen, "bc78Objective", value.getBc78Objective());
		writeStringField(gen, "bc79Subjective", value.getBc79Subjective());
		writeStringField(gen, "bc79Objective", value.getBc79Objective());
		writeStringField(gen, "bc80Subjective", value.getBc80Subjective());
		writeStringField(gen, "bc80Objective", value.getBc80Objective());
		writeStringField(gen, "bc81Subjective", value.getBc81Subjective());
		writeStringField(gen, "bc81Objective", value.getBc81Objective());
		writeStringField(gen, "bc82Subjective", value.getBc82Subjective());
		writeStringField(gen, "bc82Objective", value.getBc82Objective());
		writeStringField(gen, "bc83Subjective", value.getBc83Subjective());
		writeStringField(gen, "bc83Objective", value.getBc83Objective());
		writeStringField(gen, "bc84Subjective", value.getBc84Subjective());
		writeStringField(gen, "bc84Objective", value.getBc84Objective());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}