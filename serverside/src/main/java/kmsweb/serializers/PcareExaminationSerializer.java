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

import kmsweb.entities.PcareExaminationEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class PcareExaminationSerializer extends AbstractSerializer<PcareExaminationEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public PcareExaminationSerializer() {
		super(PcareExaminationEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(PcareExaminationEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "visitType", value.getVisitType());
		writeStringField(gen, "treatment", value.getTreatment());
		writeStringField(gen, "destinationPolyclinic", value.getDestinationPolyclinic());
		writeStringField(gen, "disease", value.getDisease());
		writeStringField(gen, "diagnosis", value.getDiagnosis());
		writeStringField(gen, "diagnosis2", value.getDiagnosis2());
		writeStringField(gen, "diagnosis3", value.getDiagnosis3());
		writeStringField(gen, "therapy", value.getTherapy());
		writeStringField(gen, "consciousness", value.getConsciousness());
		writeStringField(gen, "dischargeStatus", value.getDischargeStatus());
		writeStringField(gen, "internalReferralPolyclinic", value.getInternalReferralPolyclinic());
		writeOffsetDateTimeField(gen, "referringDate", value.getReferringDate());
		writeStringField(gen, "pkk", value.getPkk());
		writeStringField(gen, "subSpecialist", value.getSubSpecialist());
		writeStringField(gen, "facility", value.getFacility());
		writeStringField(gen, "tacc", value.getTacc());
		writeStringField(gen, "taccReason", value.getTaccReason());
		writeStringField(gen, "special", value.getSpecial());
		writeDoubleField(gen, "height", value.getHeight());
		writeDoubleField(gen, "weight", value.getWeight());
		writeDoubleField(gen, "waistCircumference", value.getWaistCircumference());
		writeDoubleField(gen, "bmi", value.getBmi());
		writeIntegerField(gen, "systole", value.getSystole());
		writeIntegerField(gen, "diastole", value.getDiastole());
		writeDoubleField(gen, "respiratoryRate", value.getRespiratoryRate());
		writeDoubleField(gen, "heartRate", value.getHeartRate());
		writeStringField(gen, "medicalStaff", value.getMedicalStaff());
		writeStringField(gen, "tglpulang", value.getTglpulang());
		writeStringField(gen, "kdsubspesialis1", value.getKdsubspesialis1());
		writeStringField(gen, "rujuklanjut", value.getRujuklanjut());
		writeStringField(gen, "catatan", value.getCatatan());
		writeStringField(gen, "nokunjungan", value.getNokunjungan());
		writeStringField(gen, "jsoninsert", value.getJsoninsert());
		writeStringField(gen, "jsonupdate", value.getJsonupdate());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}