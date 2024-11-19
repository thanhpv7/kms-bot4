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
import kmsweb.entities.FacilityHistoryEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class FacilityHistoryFactory implements FactoryBean<FacilityHistoryEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public FacilityHistoryEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public FacilityHistoryEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public FacilityHistoryEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for facilityHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryWithNoRef before the main body here] end

		FacilityHistoryEntity newEntity = new FacilityHistoryEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Change Date here] off begin
		newEntity.setChangeDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Change Date here] end
		// % protected region % [Add customisation for Facility No here] off begin
		String randomStringForFacilityNo = mockNeat
				.strings()
				.get();
		newEntity.setFacilityNo(randomStringForFacilityNo);
		// % protected region % [Add customisation for Facility No here] end
		// % protected region % [Add customisation for Current Qty here] off begin
		newEntity.setCurrentQty(mockNeat.ints().get());
		// % protected region % [Add customisation for Current Qty here] end
		// % protected region % [Add customisation for Changed Qty here] off begin
		newEntity.setChangedQty(mockNeat.ints().get());
		// % protected region % [Add customisation for Changed Qty here] end
		// % protected region % [Add customisation for Facility Status here] off begin
		String randomStringForFacilityStatus = mockNeat
				.strings()
				.get();
		newEntity.setFacilityStatus(randomStringForFacilityStatus);
		// % protected region % [Add customisation for Facility Status here] end
		// % protected region % [Add customisation for Facility Class here] off begin
		String randomStringForFacilityClass = mockNeat
				.strings()
				.get();
		newEntity.setFacilityClass(randomStringForFacilityClass);
		// % protected region % [Add customisation for Facility Class here] end
		// % protected region % [Add customisation for Facility Type here] off begin
		String randomStringForFacilityType = mockNeat
				.strings()
				.get();
		newEntity.setFacilityType(randomStringForFacilityType);
		// % protected region % [Add customisation for Facility Type here] end
		// % protected region % [Add customisation for Facility Service here] off begin
		String randomStringForFacilityService = mockNeat
				.strings()
				.get();
		newEntity.setFacilityService(randomStringForFacilityService);
		// % protected region % [Add customisation for Facility Service here] end
		// % protected region % [Add customisation for Bed Facility Id here] off begin
		String randomStringForBedFacilityId = mockNeat
				.strings()
				.get();
		newEntity.setBedFacilityId(randomStringForBedFacilityId);
		// % protected region % [Add customisation for Bed Facility Id here] end
		// % protected region % [Add customisation for Registration Id here] off begin
		String randomStringForRegistrationId = mockNeat
				.strings()
				.get();
		newEntity.setRegistrationId(randomStringForRegistrationId);
		// % protected region % [Add customisation for Registration Id here] end

		// % protected region % [Apply any additional logic for facilityHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for facilityHistoryWithNoRef after the main body here] end


		return newEntity;
	}

	@Override
	public Class<FacilityHistoryEntity> getObjectType() {
		return FacilityHistoryEntity.class;
	}
}