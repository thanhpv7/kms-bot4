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
import kmsweb.entities.DeliveryProgressEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class DeliveryProgressFactory implements FactoryBean<DeliveryProgressEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public DeliveryProgressEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public DeliveryProgressEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public DeliveryProgressEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for deliveryProgressWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressWithNoRef before the main body here] end

		DeliveryProgressEntity newEntity = new DeliveryProgressEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Progress Date Time here] off begin
		newEntity.setProgressDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Progress Date Time here] end
		// % protected region % [Add customisation for FHR Per Minute here] off begin
		newEntity.setFhrPerMinute(mockNeat.ints().get());
		// % protected region % [Add customisation for FHR Per Minute here] end
		// % protected region % [Add customisation for Amniotic Fluid here] off begin
		String randomStringForAmnioticFluid = mockNeat
				.strings()
				.get();
		newEntity.setAmnioticFluid(randomStringForAmnioticFluid);
		// % protected region % [Add customisation for Amniotic Fluid here] end
		// % protected region % [Add customisation for Moulding here] off begin
		String randomStringForMoulding = mockNeat
				.strings()
				.get();
		newEntity.setMoulding(randomStringForMoulding);
		// % protected region % [Add customisation for Moulding here] end
		// % protected region % [Add customisation for Cervical Dilatation here] off begin
		newEntity.setCervicalDilatation(mockNeat.ints().get());
		// % protected region % [Add customisation for Cervical Dilatation here] end
		// % protected region % [Add customisation for Fetal Head Descent here] off begin
		String randomStringForFetalHeadDescent = mockNeat
				.strings()
				.get();
		newEntity.setFetalHeadDescent(randomStringForFetalHeadDescent);
		// % protected region % [Add customisation for Fetal Head Descent here] end
		// % protected region % [Add customisation for Contraction Qty here] off begin
		newEntity.setContractionQty(mockNeat.ints().get());
		// % protected region % [Add customisation for Contraction Qty here] end
		// % protected region % [Add customisation for Contraction Mins here] off begin
		String randomStringForContractionMins = mockNeat
				.strings()
				.get();
		newEntity.setContractionMins(randomStringForContractionMins);
		// % protected region % [Add customisation for Contraction Mins here] end
		// % protected region % [Add customisation for Drip Strength here] off begin
		newEntity.setDripStrength(mockNeat.ints().get());
		// % protected region % [Add customisation for Drip Strength here] end
		// % protected region % [Add customisation for Drip Number here] off begin
		newEntity.setDripNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Drip Number here] end
		// % protected region % [Add customisation for Drug IV here] off begin
		String randomStringForDrugIV = mockNeat
				.strings()
				.get();
		newEntity.setDrugIV(randomStringForDrugIV);
		// % protected region % [Add customisation for Drug IV here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mockNeat.ints().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mockNeat.ints().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Pulse here] off begin
		newEntity.setPulse(mockNeat.ints().get());
		// % protected region % [Add customisation for Pulse here] end
		// % protected region % [Add customisation for Temperature here] off begin
		newEntity.setTemperature(mockNeat.doubles().get());
		// % protected region % [Add customisation for Temperature here] end
		// % protected region % [Add customisation for Temperature Unit here] off begin
		String randomStringForTemperatureUnit = mockNeat
				.strings()
				.get();
		newEntity.setTemperatureUnit(randomStringForTemperatureUnit);
		// % protected region % [Add customisation for Temperature Unit here] end
		// % protected region % [Add customisation for Urine Protein here] off begin
		String randomStringForUrineProtein = mockNeat
				.strings()
				.get();
		newEntity.setUrineProtein(randomStringForUrineProtein);
		// % protected region % [Add customisation for Urine Protein here] end
		// % protected region % [Add customisation for Urine Acetone here] off begin
		String randomStringForUrineAcetone = mockNeat
				.strings()
				.get();
		newEntity.setUrineAcetone(randomStringForUrineAcetone);
		// % protected region % [Add customisation for Urine Acetone here] end
		// % protected region % [Add customisation for Urine Volume here] off begin
		newEntity.setUrineVolume(mockNeat.doubles().get());
		// % protected region % [Add customisation for Urine Volume here] end
		// % protected region % [Add customisation for Progress Notes here] off begin
		String randomStringForProgressNotes = mockNeat
				.strings()
				.get();
		newEntity.setProgressNotes(randomStringForProgressNotes);
		// % protected region % [Add customisation for Progress Notes here] end

		// % protected region % [Apply any additional logic for deliveryProgressWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryProgressWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDelivery Medical Examination Record here] off begin
			var deliveryMedicalExaminationRecordFactory = new DeliveryMedicalExaminationRecordFactory();
			newEntity.setDeliveryMedicalExaminationRecord(deliveryMedicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDelivery Medical Examination Record here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

		}

		// % protected region % [Apply any additional logic for deliveryProgress with ref here] off begin
		// % protected region % [Apply any additional logic for deliveryProgress with ref here] end

		return newEntity;
	}

	@Override
	public Class<DeliveryProgressEntity> getObjectType() {
		return DeliveryProgressEntity.class;
	}
}