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
import kmsweb.entities.VaccinationOrderEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class VaccinationOrderFactory implements FactoryBean<VaccinationOrderEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public VaccinationOrderEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public VaccinationOrderEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public VaccinationOrderEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for vaccinationOrderWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderWithNoRef before the main body here] end

		VaccinationOrderEntity newEntity = new VaccinationOrderEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Vaccination Location here] off begin
		String randomStringForVaccinationLocation = mockNeat
				.strings()
				.get();
		newEntity.setVaccinationLocation(randomStringForVaccinationLocation);
		// % protected region % [Add customisation for Vaccination Location here] end
		// % protected region % [Add customisation for Vaccination Reaction here] off begin
		String randomStringForVaccinationReaction = mockNeat
				.strings()
				.get();
		newEntity.setVaccinationReaction(randomStringForVaccinationReaction);
		// % protected region % [Add customisation for Vaccination Reaction here] end
		// % protected region % [Add customisation for Purpose here] off begin
		String randomStringForPurpose = mockNeat
				.strings()
				.get();
		newEntity.setPurpose(randomStringForPurpose);
		// % protected region % [Add customisation for Purpose here] end
		// % protected region % [Add customisation for Vaccination Notes here] off begin
		String randomStringForVaccinationNotes = mockNeat
				.strings()
				.get();
		newEntity.setVaccinationNotes(randomStringForVaccinationNotes);
		// % protected region % [Add customisation for Vaccination Notes here] end
		// % protected region % [Add customisation for Reaction Notes here] off begin
		String randomStringForReactionNotes = mockNeat
				.strings()
				.get();
		newEntity.setReactionNotes(randomStringForReactionNotes);
		// % protected region % [Add customisation for Reaction Notes here] end

		// % protected region % [Apply any additional logic for vaccinationOrderWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrderWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] off begin
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Vaccination Order Details here] off begin
			// Outgoing one to many reference
			var vaccinationOrderDetailsFactory = new VaccinationOrderDetailFactory();
			newEntity.setVaccinationOrderDetails(Collections.singletonList(vaccinationOrderDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Vaccination Order Details here] end

		}

		// % protected region % [Apply any additional logic for vaccinationOrder with ref here] off begin
		// % protected region % [Apply any additional logic for vaccinationOrder with ref here] end

		return newEntity;
	}

	@Override
	public Class<VaccinationOrderEntity> getObjectType() {
		return VaccinationOrderEntity.class;
	}
}