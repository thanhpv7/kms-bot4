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

import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class DeliveryMedicalExaminationRecordSerializer extends AbstractSerializer<DeliveryMedicalExaminationRecordEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public DeliveryMedicalExaminationRecordSerializer() {
		super(DeliveryMedicalExaminationRecordEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(DeliveryMedicalExaminationRecordEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "pregnancyHistoryGravida", value.getPregnancyHistoryGravida());
		writeStringField(gen, "pregnancyHistoryPartum", value.getPregnancyHistoryPartum());
		writeStringField(gen, "pregnancyHistoryAbortum", value.getPregnancyHistoryAbortum());
		writeStringField(gen, "pregnancyHistoryNotes", value.getPregnancyHistoryNotes());
		writeOffsetDateTimeField(gen, "lnmpStartDate", value.getLnmpStartDate());
		writeOffsetDateTimeField(gen, "lnmpEndDate", value.getLnmpEndDate());
		writeOffsetDateTimeField(gen, "approximateBirthDate", value.getApproximateBirthDate());
		writeIntegerField(gen, "gestationAgeWeeks", value.getGestationAgeWeeks());
		writeIntegerField(gen, "gestationAgeDays", value.getGestationAgeDays());
		writeBooleanField(gen, "tetanusVaccine1", value.getTetanusVaccine1());
		writeBooleanField(gen, "tetanusVaccine2", value.getTetanusVaccine2());
		writeStringField(gen, "deliveryType", value.getDeliveryType());
		writeStringField(gen, "complicationsInPregnancy", value.getComplicationsInPregnancy());
		writeStringField(gen, "riskFactor", value.getRiskFactor());
		writeStringField(gen, "fetalPresentation", value.getFetalPresentation());
		writeStringField(gen, "abdomenExamination", value.getAbdomenExamination());
		writeStringField(gen, "fundalHeight", value.getFundalHeight());
		writeStringField(gen, "fhrPerMinute", value.getFhrPerMinute());
		writeStringField(gen, "estimatedFetalWeight", value.getEstimatedFetalWeight());
		writeStringField(gen, "leopold1", value.getLeopold1());
		writeStringField(gen, "leopold2", value.getLeopold2());
		writeStringField(gen, "leopold3", value.getLeopold3());
		writeStringField(gen, "leopold4", value.getLeopold4());
		writeStringField(gen, "geniteliaExterna", value.getGeniteliaExterna());
		writeStringField(gen, "geniteliaInterna", value.getGeniteliaInterna());
		writeStringField(gen, "vaginalExamination", value.getVaginalExamination());
		writeStringField(gen, "deliveryComplication", value.getDeliveryComplication());
		writeStringField(gen, "deliveryNote", value.getDeliveryNote());
		writeBooleanField(gen, "normalDeliveryCase", value.getNormalDeliveryCase());
		writeIntegerField(gen, "stage1Hour", value.getStage1Hour());
		writeIntegerField(gen, "unnamedInteger1", value.getUnnamedInteger1());
		writeIntegerField(gen, "stage3Hour", value.getStage3Hour());
		writeIntegerField(gen, "stage4Hour", value.getStage4Hour());
		writeIntegerField(gen, "stage1Minute", value.getStage1Minute());
		writeIntegerField(gen, "stage2Minute", value.getStage2Minute());
		writeIntegerField(gen, "stage3Minute", value.getStage3Minute());
		writeIntegerField(gen, "stage4Minute", value.getStage4Minute());
		writeStringField(gen, "placenta", value.getPlacenta());
		writeStringField(gen, "perineum", value.getPerineum());
		writeStringField(gen, "bleeding", value.getBleeding());
		writeStringField(gen, "postpartumComplication", value.getPostpartumComplication());
		writeIntegerField(gen, "newbornDelivered", value.getNewbornDelivered());
		writeBooleanField(gen, "perineumInfection", value.getPerineumInfection());
		writeBooleanField(gen, "earlyBreastfeedingIntiation", value.getEarlyBreastfeedingIntiation());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}