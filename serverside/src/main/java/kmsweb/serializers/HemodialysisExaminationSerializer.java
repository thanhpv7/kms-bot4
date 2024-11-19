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

import kmsweb.entities.HemodialysisExaminationEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class HemodialysisExaminationSerializer extends AbstractSerializer<HemodialysisExaminationEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public HemodialysisExaminationSerializer() {
		super(HemodialysisExaminationEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(HemodialysisExaminationEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeOffsetDateTimeField(gen, "firstDialysis", value.getFirstDialysis());
		writeStringField(gen, "dialysisFrequency", value.getDialysisFrequency());
		writeStringField(gen, "dialysisNo", value.getDialysisNo());
		writeStringField(gen, "hemodialysisType", value.getHemodialysisType());
		writeStringField(gen, "condition", value.getCondition());
		writeStringField(gen, "vascularAccess", value.getVascularAccess());
		writeStringField(gen, "heparinization", value.getHeparinization());
		writeStringField(gen, "heparinizationInitialDose", value.getHeparinizationInitialDose());
		writeStringField(gen, "heparinizationFollowUpDose", value.getHeparinizationFollowUpDose());
		writeStringField(gen, "dialyzer", value.getDialyzer());
		writeStringField(gen, "dialyzerType", value.getDialyzerType());
		writeStringField(gen, "dialysisFluid", value.getDialysisFluid());
		writeDoubleField(gen, "dryWeight", value.getDryWeight());
		writeStringField(gen, "dryWeightUnit", value.getDryWeightUnit());
		writeDoubleField(gen, "weightUponArrival", value.getWeightUponArrival());
		writeStringField(gen, "weightUponArrivalUnit", value.getWeightUponArrivalUnit());
		writeDoubleField(gen, "weightDuringPreviousHemodialysis", value.getWeightDuringPreviousHemodialysis());
		writeStringField(gen, "weightDuringPreviousHemodialysisUnit", value.getWeightDuringPreviousHemodialysisUnit());
		writeBooleanField(gen, "antiHIV", value.getAntiHIV());
		writeBooleanField(gen, "hbsag", value.getHbsag());
		writeBooleanField(gen, "antiHCV", value.getAntiHCV());
		writeOffsetDateTimeField(gen, "hemodialysisStartTime", value.getHemodialysisStartTime());
		writeOffsetDateTimeField(gen, "hemodialysisEndTime", value.getHemodialysisEndTime());
		writeStringField(gen, "target", value.getTarget());
		writeStringField(gen, "primingVolume", value.getPrimingVolume());
		writeStringField(gen, "remainingPriming", value.getRemainingPriming());
		writeStringField(gen, "complication", value.getComplication());
		writeStringField(gen, "hemodialysisDetails", value.getHemodialysisDetails());
		writeDoubleField(gen, "weightUponDismissal", value.getWeightUponDismissal());
		writeStringField(gen, "weightUponDismissalUnit", value.getWeightUponDismissalUnit());
		writeDoubleField(gen, "priming", value.getPriming());
		writeDoubleField(gen, "blood", value.getBlood());
		writeDoubleField(gen, "ivLine", value.getIvLine());
		writeDoubleField(gen, "oral", value.getOral());
		writeDoubleField(gen, "washOut", value.getWashOut());
		writeDoubleField(gen, "totalFluidIntake", value.getTotalFluidIntake());
		writeDoubleField(gen, "urine", value.getUrine());
		writeDoubleField(gen, "others", value.getOthers());
		writeDoubleField(gen, "totalFluidOutput", value.getTotalFluidOutput());
		writeDoubleField(gen, "fluidBalance", value.getFluidBalance());
		writeStringField(gen, "postHemodialysisEvaluation", value.getPostHemodialysisEvaluation());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}