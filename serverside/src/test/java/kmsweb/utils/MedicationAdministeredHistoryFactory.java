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
import kmsweb.entities.MedicationAdministeredHistoryEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class MedicationAdministeredHistoryFactory implements FactoryBean<MedicationAdministeredHistoryEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public MedicationAdministeredHistoryEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public MedicationAdministeredHistoryEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public MedicationAdministeredHistoryEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryWithNoRef before the main body here] end

		MedicationAdministeredHistoryEntity newEntity = new MedicationAdministeredHistoryEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for DateTime here] off begin
		newEntity.setDatetime(OffsetDateTime.now());
		// % protected region % [Add customisation for DateTime here] end
		// % protected region % [Add customisation for Administration Notes here] off begin
		String randomStringForAdministrationNotes = mockNeat
				.strings()
				.get();
		newEntity.setAdministrationNotes(randomStringForAdministrationNotes);
		// % protected region % [Add customisation for Administration Notes here] end
		// % protected region % [Add customisation for Administered Quantity here] off begin
		newEntity.setAdministeredQuantity(mockNeat.ints().get());
		// % protected region % [Add customisation for Administered Quantity here] end
		// % protected region % [Add customisation for Taken Home Quantity here] off begin
		newEntity.setTakenHomeQuantity(mockNeat.ints().get());
		// % protected region % [Add customisation for Taken Home Quantity here] end
		// % protected region % [Add customisation for Returned Quantity here] off begin
		newEntity.setReturnedQuantity(mockNeat.ints().get());
		// % protected region % [Add customisation for Returned Quantity here] end
		// % protected region % [Add customisation for Total Administered Quantity here] off begin
		newEntity.setTotalAdministeredQuantity(mockNeat.ints().get());
		// % protected region % [Add customisation for Total Administered Quantity here] end

		// % protected region % [Apply any additional logic for medicationAdministeredHistoryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistoryWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Item here] off begin
			var medicationItemFactory = new MedicationItemFactory();
			newEntity.setMedicationItem(medicationItemFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Item here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Compound here] off begin
			var medicationCompoundFactory = new MedicationCompoundFactory();
			newEntity.setMedicationCompound(medicationCompoundFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedication Compound here] end

		}

		// % protected region % [Apply any additional logic for medicationAdministeredHistory with ref here] off begin
		// % protected region % [Apply any additional logic for medicationAdministeredHistory with ref here] end

		return newEntity;
	}

	@Override
	public Class<MedicationAdministeredHistoryEntity> getObjectType() {
		return MedicationAdministeredHistoryEntity.class;
	}
}