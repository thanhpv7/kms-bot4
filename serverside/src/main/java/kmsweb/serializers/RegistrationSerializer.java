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

import kmsweb.entities.RegistrationEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class RegistrationSerializer extends AbstractSerializer<RegistrationEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public RegistrationSerializer() {
		super(RegistrationEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(RegistrationEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "registrationNumber", value.getRegistrationNumber());
		writeOffsetDateTimeField(gen, "scheduledDate", value.getScheduledDate());
		writeOffsetDateTimeField(gen, "actualInDate", value.getActualInDate());
		writeOffsetDateTimeField(gen, "dismissalDate", value.getDismissalDate());
		writeStringField(gen, "dismissalType", value.getDismissalType());
		writeIntegerField(gen, "queueNo", value.getQueueNo());
		writeIntegerField(gen, "duration", value.getDuration());
		writeStringField(gen, "treatmentClass", value.getTreatmentClass());
		writeStringField(gen, "bookedTreatmentClass", value.getBookedTreatmentClass());
		writeStringField(gen, "shift", value.getShift());
		writeBooleanField(gen, "cito", value.getCito());
		writeBooleanField(gen, "oneDayCare", value.getOneDayCare());
		writeBooleanField(gen, "referral", value.getReferral());
		writeStringField(gen, "registrationStatus", value.getRegistrationStatus());
		writeStringField(gen, "referralType", value.getReferralType());
		writeStringField(gen, "purpose", value.getPurpose());
		writeStringField(gen, "referralNotes", value.getReferralNotes());
		writeStringField(gen, "admissionDiagnosis", value.getAdmissionDiagnosis());
		writeOffsetDateTimeField(gen, "uploadedDateTime", value.getUploadedDateTime());
		writeStringField(gen, "visitStatus", value.getVisitStatus());
		writeStringField(gen, "instruction", value.getInstruction());
		writeBooleanField(gen, "isAnAppointment", value.getIsAnAppointment());
		writeStringField(gen, "referralNumber", value.getReferralNumber());
		writeStringField(gen, "notes", value.getNotes());
		writeStringField(gen, "kodepoli", value.getKodepoli());
		writeStringField(gen, "deathCertificateNo", value.getDeathCertificateNo());
		writeOffsetDateTimeField(gen, "timeOfDeath", value.getTimeOfDeath());
		writeBooleanField(gen, "dismissalReferral", value.getDismissalReferral());
		writeStringField(gen, "dismissalReferralDetail", value.getDismissalReferralDetail());
		writeStringField(gen, "dismissalReferralType", value.getDismissalReferralType());
		writeStringField(gen, "dismissalReferringNotes", value.getDismissalReferringNotes());
		writeBooleanField(gen, "patientIsReferredBack", value.getPatientIsReferredBack());
		writeStringField(gen, "mcuPackage", value.getMcuPackage());
		writeStringField(gen, "parentRegistrationNumber", value.getParentRegistrationNumber());
		writeBooleanField(gen, "isUnknownPatient", value.getIsUnknownPatient());
		writeStringField(gen, "otherReferredFacility", value.getOtherReferredFacility());
		writeStringField(gen, "otherReferredStaff", value.getOtherReferredStaff());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}