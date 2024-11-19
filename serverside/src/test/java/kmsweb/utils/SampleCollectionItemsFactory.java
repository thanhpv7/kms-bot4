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
import kmsweb.entities.SampleCollectionItemsEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class SampleCollectionItemsFactory implements FactoryBean<SampleCollectionItemsEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public SampleCollectionItemsEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public SampleCollectionItemsEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public SampleCollectionItemsEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for sampleCollectionItemsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsWithNoRef before the main body here] end

		SampleCollectionItemsEntity newEntity = new SampleCollectionItemsEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Sample Type here] off begin
		String randomStringForSampleType = mockNeat
				.strings()
				.get();
		newEntity.setSampleType(randomStringForSampleType);
		// % protected region % [Add customisation for Sample Type here] end
		// % protected region % [Add customisation for Sample Number here] off begin
		String randomStringForSampleNumber = mockNeat
				.strings()
				.get();
		newEntity.setSampleNumber(randomStringForSampleNumber);
		// % protected region % [Add customisation for Sample Number here] end
		// % protected region % [Add customisation for Sample Taking Location here] off begin
		String randomStringForSampleTakingLocation = mockNeat
				.strings()
				.get();
		newEntity.setSampleTakingLocation(randomStringForSampleTakingLocation);
		// % protected region % [Add customisation for Sample Taking Location here] end
		// % protected region % [Add customisation for Volume here] off begin
		String randomStringForVolume = mockNeat
				.strings()
				.get();
		newEntity.setVolume(randomStringForVolume);
		// % protected region % [Add customisation for Volume here] end
		// % protected region % [Add customisation for Container here] off begin
		String randomStringForContainer = mockNeat
				.strings()
				.get();
		newEntity.setContainer(randomStringForContainer);
		// % protected region % [Add customisation for Container here] end
		// % protected region % [Add customisation for Transport here] off begin
		String randomStringForTransport = mockNeat
				.strings()
				.get();
		newEntity.setTransport(randomStringForTransport);
		// % protected region % [Add customisation for Transport here] end
		// % protected region % [Add customisation for Sample Collection Date Time here] off begin
		newEntity.setSampleCollectionDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Sample Collection Date Time here] end
		// % protected region % [Add customisation for Sample Processing Date Time here] off begin
		newEntity.setSampleProcessingDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Sample Processing Date Time here] end
		// % protected region % [Add customisation for Sample Delivery Date Time here] off begin
		newEntity.setSampleDeliveryDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Sample Delivery Date Time here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for sampleCollectionItemsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItemsWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySample Collection Information here] off begin
			var sampleCollectionInformationFactory = new SampleCollectionInformationFactory();
			newEntity.setSampleCollectionInformation(sampleCollectionInformationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySample Collection Information here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySample Collection Staff here] off begin
			var sampleCollectionStaffFactory = new StaffFactory();
			newEntity.setSampleCollectionStaff(sampleCollectionStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySample Collection Staff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySample Delivery Staff here] off begin
			var sampleDeliveryStaffFactory = new StaffFactory();
			newEntity.setSampleDeliveryStaff(sampleDeliveryStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySample Delivery Staff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySample Processing Staff here] off begin
			var sampleProcessingStaffFactory = new StaffFactory();
			newEntity.setSampleProcessingStaff(sampleProcessingStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySample Processing Staff here] end

		}

		// % protected region % [Apply any additional logic for sampleCollectionItems with ref here] off begin
		// % protected region % [Apply any additional logic for sampleCollectionItems with ref here] end

		return newEntity;
	}

	@Override
	public Class<SampleCollectionItemsEntity> getObjectType() {
		return SampleCollectionItemsEntity.class;
	}
}