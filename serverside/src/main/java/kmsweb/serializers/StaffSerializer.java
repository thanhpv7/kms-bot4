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

import kmsweb.entities.StaffEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class StaffSerializer extends AbstractSerializer<StaffEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public StaffSerializer() {
		super(StaffEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(StaffEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "staffNumber", value.getStaffNumber());
		writeStringField(gen, "firstName", value.getFirstName());
		writeStringField(gen, "lastName", value.getLastName());
		writeOffsetDateTimeField(gen, "dateOfBirth", value.getDateOfBirth());
		writeStringField(gen, "staffType", value.getStaffType());
		writeStringField(gen, "specialization", value.getSpecialization());
		writeStringField(gen, "education", value.getEducation());
		writeStringField(gen, "licenseNo", value.getLicenseNo());
		writeStringField(gen, "letterOfReg", value.getLetterOfReg());
		writeStringField(gen, "gender", value.getGender());
		writeStringField(gen, "employeeID", value.getEmployeeID());
		writeStringField(gen, "title", value.getTitle());
		writeStringField(gen, "defaultServiceNumber", value.getDefaultServiceNumber());
		writeStringField(gen, "placeOfBirth", value.getPlaceOfBirth());
		writeStringField(gen, "religion", value.getReligion());
		if (value.getBloodType() != null) {
			writeStringField(gen, "bloodType", value.getBloodType().toString());
		}
		if (value.getRhesus() != null) {
			writeStringField(gen, "rhesus", value.getRhesus().toString());
		}
		writeStringField(gen, "address", value.getAddress());
		writeStringField(gen, "country", value.getCountry());
		writeStringField(gen, "state", value.getState());
		writeStringField(gen, "regency", value.getRegency());
		writeStringField(gen, "district", value.getDistrict());
		writeStringField(gen, "homePhoneNo", value.getHomePhoneNo());
		writeStringField(gen, "village", value.getVillage());
		writeStringField(gen, "postcode", value.getPostcode());
		writeStringField(gen, "officePhoneNumber", value.getOfficePhoneNumber());
		writeStringField(gen, "taxIdentificationNo", value.getTaxIdentificationNo());
		writeStringField(gen, "mobilePhoneNo", value.getMobilePhoneNo());
		writeStringField(gen, "otherNotes", value.getOtherNotes());
		writeStringField(gen, "training", value.getTraining());
		writeStringField(gen, "nationality", value.getNationality());
		writeStringField(gen, "certification", value.getCertification());
		writeStringField(gen, "extNo", value.getExtNo());
		writeStringField(gen, "maritalStatus", value.getMaritalStatus());
		writeStringField(gen, "email", value.getEmail());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}