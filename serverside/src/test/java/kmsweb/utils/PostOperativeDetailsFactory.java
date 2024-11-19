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

package kmsweb.utils;

import org.springframework.beans.factory.FactoryBean;
import kmsweb.entities.PostOperativeDetailsEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PostOperativeDetailsFactory implements FactoryBean<PostOperativeDetailsEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PostOperativeDetailsEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PostOperativeDetailsEntity getObjectWithReferences(boolean includeIds) throws Exception {
		return getObject(true, includeIds);
	}

	/**
	 * Create an example instance of the entity.
	 *
	 * @param includeReferences Populate at least a single instance of each reference as a materialised object.
	 * 	We don't set the ids fields as there is no guarantee that these values exist at this stage.
	 * @param includeId Should IDs be set for the base object and the references
	 * @return A sample object
	 * @throws Exception
	 */
	public PostOperativeDetailsEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for postOperativeDetailsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsWithNoRef before the main body here] end

		PostOperativeDetailsEntity newEntity = new PostOperativeDetailsEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Recovery Start Date Time here] off begin
		newEntity.setRecoveryStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Recovery Start Date Time here] end
		// % protected region % [Add customisation for Recovery End Date Time here] off begin
		newEntity.setRecoveryEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Recovery End Date Time here] end
		// % protected region % [Add customisation for Postoperative Main Diagnosis here] off begin
		String randomStringForPostoperativeMainDiagnosis = mockNeat
				.strings()
				.get();
		newEntity.setPostoperativeMainDiagnosis(randomStringForPostoperativeMainDiagnosis);
		// % protected region % [Add customisation for Postoperative Main Diagnosis here] end
		// % protected region % [Add customisation for Postoperative Action here] off begin
		String randomStringForPostoperativeAction = mockNeat
				.strings()
				.get();
		newEntity.setPostoperativeAction(randomStringForPostoperativeAction);
		// % protected region % [Add customisation for Postoperative Action here] end
		// % protected region % [Add customisation for New Case here] off begin
		newEntity.setNewCase(mockNeat.bools().get());
		// % protected region % [Add customisation for New Case here] end
		// % protected region % [Add customisation for Postoperative Diagnosis Support Order here] off begin
		String randomStringForPostoperativeDiagnosisSupportOrder = mockNeat
				.strings()
				.get();
		newEntity.setPostoperativeDiagnosisSupportOrder(randomStringForPostoperativeDiagnosisSupportOrder);
		// % protected region % [Add customisation for Postoperative Diagnosis Support Order here] end
		// % protected region % [Add customisation for Anesthesia Postoperative Monitoring here] off begin
		String randomStringForAnesthesiaPostoperativeMonitoring = mockNeat
				.strings()
				.get();
		newEntity.setAnesthesiaPostoperativeMonitoring(randomStringForAnesthesiaPostoperativeMonitoring);
		// % protected region % [Add customisation for Anesthesia Postoperative Monitoring here] end
		// % protected region % [Add customisation for Anesthesia Postoperative Action here] off begin
		String randomStringForAnesthesiaPostoperativeAction = mockNeat
				.strings()
				.get();
		newEntity.setAnesthesiaPostoperativeAction(randomStringForAnesthesiaPostoperativeAction);
		// % protected region % [Add customisation for Anesthesia Postoperative Action here] end

		// % protected region % [Apply any additional logic for postOperativeDetailsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetailsWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Operating Theater Medical Examination Record here] off begin
			// Incoming One to One reference
			var operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();
			newEntity.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Operating Theater Medical Examination Record here] end
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPost Operative ICD 10 here] off begin
			var postOperativeICD10Factory = new DiagnosesAndProceduresFactory();
			newEntity.setPostOperativeICD10(postOperativeICD10Factory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPost Operative ICD 10 here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPost Operative ICD 9 CM here] off begin
			var postOperativeICD9CMFactory = new DiagnosesAndProceduresFactory();
			newEntity.setPostOperativeICD9CM(postOperativeICD9CMFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPost Operative ICD 9 CM here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRecovery Rooms here] off begin
			var recoveryRoomsFactory = new RoomFacilityFactory();
			newEntity.setRecoveryRooms(recoveryRoomsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRecovery Rooms here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Facilities here] off begin
			// Outgoing one to many reference
			var bedFacilitiesFactory = new BedFacilityFactory();
			newEntity.setBedFacilities(Collections.singletonList(bedFacilitiesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Facilities here] end

		}

		// % protected region % [Apply any additional logic for postOperativeDetails with ref here] off begin
		// % protected region % [Apply any additional logic for postOperativeDetails with ref here] end

		return newEntity;
	}

	@Override
	public Class<PostOperativeDetailsEntity> getObjectType() {
		return PostOperativeDetailsEntity.class;
	}
}