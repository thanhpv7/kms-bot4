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
import kmsweb.entities.IntraoperativeRecordsEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class IntraoperativeRecordsFactory implements FactoryBean<IntraoperativeRecordsEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public IntraoperativeRecordsEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public IntraoperativeRecordsEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public IntraoperativeRecordsEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for intraoperativeRecordsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsWithNoRef before the main body here] end

		IntraoperativeRecordsEntity newEntity = new IntraoperativeRecordsEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] off begin
		newEntity.setStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Start Date Time here] end
		// % protected region % [Add customisation for End Date Time here] off begin
		newEntity.setEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for End Date Time here] end
		// % protected region % [Add customisation for Surgery Start Date Time here] off begin
		newEntity.setSurgeryStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Surgery Start Date Time here] end
		// % protected region % [Add customisation for Surgery End Date Time here] off begin
		newEntity.setSurgeryEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Surgery End Date Time here] end
		// % protected region % [Add customisation for Surgery Details here] off begin
		String randomStringForSurgeryDetails = mockNeat
				.strings()
				.get();
		newEntity.setSurgeryDetails(randomStringForSurgeryDetails);
		// % protected region % [Add customisation for Surgery Details here] end
		// % protected region % [Add customisation for Blood Transfusion here] off begin
		String randomStringForBloodTransfusion = mockNeat
				.strings()
				.get();
		newEntity.setBloodTransfusion(randomStringForBloodTransfusion);
		// % protected region % [Add customisation for Blood Transfusion here] end
		// % protected region % [Add customisation for Instruments Used here] off begin
		String randomStringForInstrumentsUsed = mockNeat
				.strings()
				.get();
		newEntity.setInstrumentsUsed(randomStringForInstrumentsUsed);
		// % protected region % [Add customisation for Instruments Used here] end
		// % protected region % [Add customisation for Anesthesia Start Date Time here] off begin
		newEntity.setAnesthesiaStartDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Anesthesia Start Date Time here] end
		// % protected region % [Add customisation for Anesthesia Type here] off begin
		String randomStringForAnesthesiaType = mockNeat
				.strings()
				.get();
		newEntity.setAnesthesiaType(randomStringForAnesthesiaType);
		// % protected region % [Add customisation for Anesthesia Type here] end
		// % protected region % [Add customisation for Anesthesia Method here] off begin
		String randomStringForAnesthesiaMethod = mockNeat
				.strings()
				.get();
		newEntity.setAnesthesiaMethod(randomStringForAnesthesiaMethod);
		// % protected region % [Add customisation for Anesthesia Method here] end
		// % protected region % [Add customisation for Anesthesia Agents here] off begin
		String randomStringForAnesthesiaAgents = mockNeat
				.strings()
				.get();
		newEntity.setAnesthesiaAgents(randomStringForAnesthesiaAgents);
		// % protected region % [Add customisation for Anesthesia Agents here] end
		// % protected region % [Add customisation for Anesthesia Observations here] off begin
		String randomStringForAnesthesiaObservations = mockNeat
				.strings()
				.get();
		newEntity.setAnesthesiaObservations(randomStringForAnesthesiaObservations);
		// % protected region % [Add customisation for Anesthesia Observations here] end
		// % protected region % [Add customisation for Anesthesia Notes here] off begin
		String randomStringForAnesthesiaNotes = mockNeat
				.strings()
				.get();
		newEntity.setAnesthesiaNotes(randomStringForAnesthesiaNotes);
		// % protected region % [Add customisation for Anesthesia Notes here] end
		// % protected region % [Add customisation for Anesthesia End Date Time here] off begin
		newEntity.setAnesthesiaEndDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Anesthesia End Date Time here] end

		// % protected region % [Apply any additional logic for intraoperativeRecordsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecordsWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Operating Theater Medical Examination Record here] off begin
			// Incoming One to One reference
			var operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();
			newEntity.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Operating Theater Medical Examination Record here] end
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyOperating Room here] off begin
			var operatingRoomFactory = new RoomFacilityFactory();
			newEntity.setOperatingRoom(operatingRoomFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyOperating Room here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Facilities here] off begin
			// Outgoing one to many reference
			var bedFacilitiesFactory = new BedFacilityFactory();
			newEntity.setBedFacilities(Collections.singletonList(bedFacilitiesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Facilities here] end

		}

		// % protected region % [Apply any additional logic for intraoperativeRecords with ref here] off begin
		// % protected region % [Apply any additional logic for intraoperativeRecords with ref here] end

		return newEntity;
	}

	@Override
	public Class<IntraoperativeRecordsEntity> getObjectType() {
		return IntraoperativeRecordsEntity.class;
	}
}