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
import kmsweb.entities.VitalSignsEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class VitalSignsFactory implements FactoryBean<VitalSignsEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public VitalSignsEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public VitalSignsEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public VitalSignsEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for vitalSignsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsWithNoRef before the main body here] end

		VitalSignsEntity newEntity = new VitalSignsEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Time here] off begin
		String randomStringForTime = mockNeat
				.strings()
				.get();
		newEntity.setTime(randomStringForTime);
		// % protected region % [Add customisation for Time here] end
		// % protected region % [Add customisation for HR here] off begin
		String randomStringForHr = mockNeat
				.strings()
				.get();
		newEntity.setHr(randomStringForHr);
		// % protected region % [Add customisation for HR here] end
		// % protected region % [Add customisation for RR here] off begin
		String randomStringForRr = mockNeat
				.strings()
				.get();
		newEntity.setRr(randomStringForRr);
		// % protected region % [Add customisation for RR here] end
		// % protected region % [Add customisation for Temprature here] off begin
		String randomStringForTemprature = mockNeat
				.strings()
				.get();
		newEntity.setTemprature(randomStringForTemprature);
		// % protected region % [Add customisation for Temprature here] end
		// % protected region % [Add customisation for O2 Saturation here] off begin
		String randomStringForO2Saturation = mockNeat
				.strings()
				.get();
		newEntity.setO2Saturation(randomStringForO2Saturation);
		// % protected region % [Add customisation for O2 Saturation here] end
		// % protected region % [Add customisation for Remarks here] off begin
		String randomStringForRemarks = mockNeat
				.strings()
				.get();
		newEntity.setRemarks(randomStringForRemarks);
		// % protected region % [Add customisation for Remarks here] end

		// % protected region % [Apply any additional logic for vitalSignsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for vitalSignsWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyNewborn Detail here] off begin
			var newbornDetailFactory = new NewbornDetailFactory();
			newEntity.setNewbornDetail(newbornDetailFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyNewborn Detail here] end

		}

		// % protected region % [Apply any additional logic for vitalSigns with ref here] off begin
		// % protected region % [Apply any additional logic for vitalSigns with ref here] end

		return newEntity;
	}

	@Override
	public Class<VitalSignsEntity> getObjectType() {
		return VitalSignsEntity.class;
	}
}