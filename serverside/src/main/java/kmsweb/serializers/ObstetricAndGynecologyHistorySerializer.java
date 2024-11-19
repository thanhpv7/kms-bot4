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

import kmsweb.entities.ObstetricAndGynecologyHistoryEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Serializer used to handle serialisation and de-serialisation against the given entity type.
 */
public class ObstetricAndGynecologyHistorySerializer extends AbstractSerializer<ObstetricAndGynecologyHistoryEntity> {

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	public ObstetricAndGynecologyHistorySerializer() {
		super(ObstetricAndGynecologyHistoryEntity.class);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	@Override
	public void serialize(ObstetricAndGynecologyHistoryEntity value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		super.serialize(value, gen, provider);

		writeStringField(gen, "pregnancyHistoryGravida", value.getPregnancyHistoryGravida());
		writeStringField(gen, "patientHistoryPara", value.getPatientHistoryPara());
		writeStringField(gen, "patientHistoryAbortus", value.getPatientHistoryAbortus());
		writeStringField(gen, "pregnancyHistoryNotes", value.getPregnancyHistoryNotes());
		writeStringField(gen, "ageOfMenarche", value.getAgeOfMenarche());
		writeStringField(gen, "ageOfFirstSexualContact", value.getAgeOfFirstSexualContact());
		writeOffsetDateTimeField(gen, "startDate", value.getStartDate());
		writeOffsetDateTimeField(gen, "endDate", value.getEndDate());
		writeOffsetDateTimeField(gen, "approximateBirthDate", value.getApproximateBirthDate());
		writeStringField(gen, "gestationAgeWeeks", value.getGestationAgeWeeks());
		writeStringField(gen, "gestationAgeDays", value.getGestationAgeDays());
		writeStringField(gen, "maternityHistory", value.getMaternityHistory());
		writeStringField(gen, "gynecologyHistory", value.getGynecologyHistory());
		writeStringField(gen, "familyPlanHistory", value.getFamilyPlanHistory());
		writeStringField(gen, "otherNotes", value.getOtherNotes());
		writeStringField(gen, "educationLevelOfPatient", value.getEducationLevelOfPatient());
		writeStringField(gen, "nameOfHusbandOrWife", value.getNameOfHusbandOrWife());
		writeStringField(gen, "educationLevelOfHusbandOrWife", value.getEducationLevelOfHusbandOrWife());
		writeStringField(gen, "occupationOfHusbandOrWife", value.getOccupationOfHusbandOrWife());
		writeOffsetDateTimeField(gen, "ruptureOfMembrane", value.getRuptureOfMembrane());

		// % protected region % [Modify the json before writing the object here] off begin
		// % protected region % [Modify the json before writing the object here] end

		gen.writeEndObject();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}