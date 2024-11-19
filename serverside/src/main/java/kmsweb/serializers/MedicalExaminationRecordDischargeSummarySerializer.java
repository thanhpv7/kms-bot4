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

import kmsweb.entities.MedicalExaminationRecordDischargeSummaryEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class MedicalExaminationRecordDischargeSummarySerializer extends AbstractSerializer<MedicalExaminationRecordDischargeSummaryEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public MedicalExaminationRecordDischargeSummarySerializer() {
		super(MedicalExaminationRecordDischargeSummaryEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(MedicalExaminationRecordDischargeSummaryEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeIntegerField(gen, "diastole", value.getDiastole());
		writeIntegerField(gen, "systole", value.getSystole());
		writeIntegerField(gen, "pulse", value.getPulse());
		writeIntegerField(gen, "bpStandingSystole", value.getBpStandingSystole());
		writeIntegerField(gen, "bpStandingDiastole", value.getBpStandingDiastole());
		writeStringField(gen, "pulseRegularity", value.getPulseRegularity());
		writeStringField(gen, "pulseStrength", value.getPulseStrength());
		writeDoubleField(gen, "temperature", value.getTemperature());
		writeStringField(gen, "temperatureScale", value.getTemperatureScale());
		writeStringField(gen, "gcsEyes", value.getGcsEyes());
		writeStringField(gen, "gcsVerbal", value.getGcsVerbal());
		writeStringField(gen, "gcsMotor", value.getGcsMotor());
		writeDoubleField(gen, "totalGCSScore", value.getTotalGCSScore());
		writeStringField(gen, "consciousness", value.getConsciousness());
		writeDoubleField(gen, "height", value.getHeight());
		writeStringField(gen, "heightScale", value.getHeightScale());
		writeDoubleField(gen, "weight", value.getWeight());
		writeStringField(gen, "weightScale", value.getWeightScale());
		writeDoubleField(gen, "bmi", value.getBmi());
		writeDoubleField(gen, "respiratory", value.getRespiratory());
		writeDoubleField(gen, "oxygenSaturation", value.getOxygenSaturation());
		writeDoubleField(gen, "waistCircumference", value.getWaistCircumference());
		writeStringField(gen, "waistCircumferenceUnit", value.getWaistCircumferenceUnit());
		writeStringField(gen, "nutritionStatus", value.getNutritionStatus());
		writeIntegerField(gen, "painScale", value.getPainScale());
		writeStringField(gen, "painScaleUsed", value.getPainScaleUsed());
		writeIntegerField(gen, "riskFallScale", value.getRiskFallScale());
		writeStringField(gen, "objective", value.getObjective());
		writeStringField(gen, "riskFallScaleUsed", value.getRiskFallScaleUsed());
		writeStringField(gen, "subjective", value.getSubjective());
		writeStringField(gen, "plan", value.getPlan());
		writeStringField(gen, "purpose", value.getPurpose());
		writeStringField(gen, "examinationSubCase", value.getExaminationSubCase());
		writeStringField(gen, "accidentalType", value.getAccidentalType());
		writeStringField(gen, "serviceCase", value.getServiceCase());
		writeStringField(gen, "accidentalSubType", value.getAccidentalSubType());
		writeStringField(gen, "additionalNotes", value.getAdditionalNotes());
		writeStringField(gen, "dischargeSummary", value.getDischargeSummary());
		writeStringField(gen, "conditionUponDischarge", value.getConditionUponDischarge());
		writeStringField(gen, "escortedBy", value.getEscortedBy());
		writeStringField(gen, "dischargeReason", value.getDischargeReason());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}