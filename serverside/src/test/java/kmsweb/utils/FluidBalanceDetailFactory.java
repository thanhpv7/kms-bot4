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
import kmsweb.entities.FluidBalanceDetailEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class FluidBalanceDetailFactory implements FactoryBean<FluidBalanceDetailEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public FluidBalanceDetailEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public FluidBalanceDetailEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public FluidBalanceDetailEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for fluidBalanceDetailWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailWithNoRef before the main body here] end

		FluidBalanceDetailEntity newEntity = new FluidBalanceDetailEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Record Date Time here] off begin
		newEntity.setRecordDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Record Date Time here] end
		// % protected region % [Add customisation for Intake Oral here] off begin
		newEntity.setIntakeOral(mockNeat.doubles().get());
		// % protected region % [Add customisation for Intake Oral here] end
		// % protected region % [Add customisation for Intake NGT here] off begin
		newEntity.setIntakeNGT(mockNeat.doubles().get());
		// % protected region % [Add customisation for Intake NGT here] end
		// % protected region % [Add customisation for Intake IV Line here] off begin
		newEntity.setIntakeIVLine(mockNeat.doubles().get());
		// % protected region % [Add customisation for Intake IV Line here] end
		// % protected region % [Add customisation for Intake Others here] off begin
		newEntity.setIntakeOthers(mockNeat.doubles().get());
		// % protected region % [Add customisation for Intake Others here] end
		// % protected region % [Add customisation for Output Urine here] off begin
		newEntity.setOutputUrine(mockNeat.doubles().get());
		// % protected region % [Add customisation for Output Urine here] end
		// % protected region % [Add customisation for Output NGT here] off begin
		newEntity.setOutputNGT(mockNeat.doubles().get());
		// % protected region % [Add customisation for Output NGT here] end
		// % protected region % [Add customisation for Output Drain here] off begin
		newEntity.setOutputDrain(mockNeat.doubles().get());
		// % protected region % [Add customisation for Output Drain here] end
		// % protected region % [Add customisation for Output Stool here] off begin
		newEntity.setOutputStool(mockNeat.doubles().get());
		// % protected region % [Add customisation for Output Stool here] end
		// % protected region % [Add customisation for Output Blood here] off begin
		newEntity.setOutputBlood(mockNeat.doubles().get());
		// % protected region % [Add customisation for Output Blood here] end
		// % protected region % [Add customisation for Output IWL here] off begin
		newEntity.setOutputIWL(mockNeat.doubles().get());
		// % protected region % [Add customisation for Output IWL here] end
		// % protected region % [Add customisation for Output Others here] off begin
		newEntity.setOutputOthers(mockNeat.doubles().get());
		// % protected region % [Add customisation for Output Others here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for Total Input here] off begin
		newEntity.setTotalInput(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Input here] end
		// % protected region % [Add customisation for Total Output here] off begin
		newEntity.setTotalOutput(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Output here] end
		// % protected region % [Add customisation for Total Balance Fluid here] off begin
		newEntity.setTotalBalanceFluid(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Balance Fluid here] end

		// % protected region % [Apply any additional logic for fluidBalanceDetailWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetailWithNoRef after the main body here] end


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

		}

		// % protected region % [Apply any additional logic for fluidBalanceDetail with ref here] off begin
		// % protected region % [Apply any additional logic for fluidBalanceDetail with ref here] end

		return newEntity;
	}

	@Override
	public Class<FluidBalanceDetailEntity> getObjectType() {
		return FluidBalanceDetailEntity.class;
	}
}