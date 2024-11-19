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

import kmsweb.entities.HospitalBranchInformationEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class HospitalBranchInformationSerializer extends AbstractSerializer<HospitalBranchInformationEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public HospitalBranchInformationSerializer() {
		super(HospitalBranchInformationEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(HospitalBranchInformationEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "hospitalCode", value.getHospitalCode());
		writeStringField(gen, "hospitalName", value.getHospitalName());
		writeStringField(gen, "hospitalType", value.getHospitalType());
		writeStringField(gen, "hospitalClass", value.getHospitalClass());
		writeStringField(gen, "hospitalDirectorName", value.getHospitalDirectorName());
		writeOffsetDateTimeField(gen, "dateOfRegistration", value.getDateOfRegistration());
		writeStringField(gen, "hospitalCorporationName", value.getHospitalCorporationName());
		writeBooleanField(gen, "isBPJSFacility", value.getIsBPJSFacility());
		writeStringField(gen, "address", value.getAddress());
		writeStringField(gen, "city", value.getCity());
		writeStringField(gen, "postcode", value.getPostcode());
		writeStringField(gen, "phoneNumber", value.getPhoneNumber());
		writeStringField(gen, "fax", value.getFax());
		writeStringField(gen, "email", value.getEmail());
		writeStringField(gen, "website", value.getWebsite());
		writeStringField(gen, "contactPerson", value.getContactPerson());
		writeStringField(gen, "contactPersonPhoneNumber", value.getContactPersonPhoneNumber());
		writeStringField(gen, "contactPersonEmail", value.getContactPersonEmail());
		writeStringField(gen, "landSize", value.getLandSize());
		writeStringField(gen, "buildingSize", value.getBuildingSize());
		writeStringField(gen, "permitNumber", value.getPermitNumber());
		writeOffsetDateTimeField(gen, "permitDate", value.getPermitDate());
		writeStringField(gen, "authorizedBy", value.getAuthorizedBy());
		writeStringField(gen, "permitType", value.getPermitType());
		writeOffsetDateTimeField(gen, "validUntil", value.getValidUntil());
		writeStringField(gen, "hospitalBranchCorporationName", value.getHospitalBranchCorporationName());
		writeStringField(gen, "hospitalBranchCorporationStatus", value.getHospitalBranchCorporationStatus());
		writeStringField(gen, "accreditationType", value.getAccreditationType());
		writeStringField(gen, "accreditationLevel", value.getAccreditationLevel());
		writeOffsetDateTimeField(gen, "accreditationDate", value.getAccreditationDate());
		writeStringField(gen, "bedPerinatology", value.getBedPerinatology());
		writeStringField(gen, "suiteClass", value.getSuiteClass());
		writeStringField(gen, "vvipClass", value.getVvipClass());
		writeStringField(gen, "vipAClass", value.getVipAClass());
		writeStringField(gen, "vipBClass", value.getVipBClass());
		writeStringField(gen, "vipCClass", value.getVipCClass());
		writeStringField(gen, "mainClass", value.getMainClass());
		writeStringField(gen, "classI", value.getClassI());
		writeStringField(gen, "iiClass", value.getIiClass());
		writeStringField(gen, "iiiAClass", value.getIiiAClass());
		writeStringField(gen, "iiiBClass", value.getIiiBClass());
		writeStringField(gen, "specialClass", value.getSpecialClass());
		writeStringField(gen, "icu", value.getIcu());
		writeStringField(gen, "picu", value.getPicu());
		writeStringField(gen, "nicu", value.getNicu());
		writeStringField(gen, "hcu", value.getHcu());
		writeStringField(gen, "iccu", value.getIccu());
		writeStringField(gen, "isolationRoom", value.getIsolationRoom());
		writeStringField(gen, "emergencyRoom", value.getEmergencyRoom());
		writeStringField(gen, "maternityRoom", value.getMaternityRoom());
		writeStringField(gen, "operatingRoom", value.getOperatingRoom());
		writeStringField(gen, "doctorSpA", value.getDoctorSpA());
		writeStringField(gen, "doctorSpOG", value.getDoctorSpOG());
		writeStringField(gen, "doctorSpPD", value.getDoctorSpPD());
		writeStringField(gen, "doctorSpB", value.getDoctorSpB());
		writeStringField(gen, "doctorSpRad", value.getDoctorSpRad());
		writeStringField(gen, "doctorSpRm", value.getDoctorSpRm());
		writeStringField(gen, "doctorSpAn", value.getDoctorSpAn());
		writeStringField(gen, "doctorSpJp", value.getDoctorSpJp());
		writeStringField(gen, "doctorSpM", value.getDoctorSpM());
		writeStringField(gen, "doctorSpTHT", value.getDoctorSpTHT());
		writeStringField(gen, "doctorSpKj", value.getDoctorSpKj());
		writeStringField(gen, "doctorSpP", value.getDoctorSpP());
		writeStringField(gen, "doctorSpPK", value.getDoctorSpPK());
		writeStringField(gen, "doctorSpS", value.getDoctorSpS());
		writeStringField(gen, "subSpecialistDoctor", value.getSubSpecialistDoctor());
		writeStringField(gen, "otherSpecialistDoctor", value.getOtherSpecialistDoctor());
		writeStringField(gen, "generalPractice", value.getGeneralPractice());
		writeStringField(gen, "dentist", value.getDentist());
		writeStringField(gen, "specialistDentist", value.getSpecialistDentist());
		writeStringField(gen, "nurse", value.getNurse());
		writeStringField(gen, "midwife", value.getMidwife());
		writeStringField(gen, "pharmacist", value.getPharmacist());
		writeStringField(gen, "otherMedicalStaff", value.getOtherMedicalStaff());
		writeStringField(gen, "nonMedicalStaff", value.getNonMedicalStaff());
		writeStringField(gen, "timezone", value.getTimezone());
		writeStringField(gen, "healthFacilityLevel", value.getHealthFacilityLevel());
		writeBooleanField(gen, "satuSehatIntegration", value.getSatuSehatIntegration());
		writeStringField(gen, "taxIdentification", value.getTaxIdentification());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}