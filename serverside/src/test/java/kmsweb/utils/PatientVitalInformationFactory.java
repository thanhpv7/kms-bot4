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
import kmsweb.entities.PatientVitalInformationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PatientVitalInformationFactory implements FactoryBean<PatientVitalInformationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PatientVitalInformationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PatientVitalInformationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PatientVitalInformationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for patientVitalInformationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationWithNoRef before the main body here] end

		PatientVitalInformationEntity newEntity = new PatientVitalInformationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Record Date Time here] off begin
		newEntity.setRecordDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Record Date Time here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mockNeat.doubles().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mockNeat.doubles().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Temperature here] off begin
		newEntity.setTemperature(mockNeat.doubles().get());
		// % protected region % [Add customisation for Temperature here] end
		// % protected region % [Add customisation for Temperature Scale here] off begin
		String randomStringForTemperatureScale = mockNeat
				.strings()
				.get();
		newEntity.setTemperatureScale(randomStringForTemperatureScale);
		// % protected region % [Add customisation for Temperature Scale here] end
		// % protected region % [Add customisation for Consciousness here] off begin
		String randomStringForConsciousness = mockNeat
				.strings()
				.get();
		newEntity.setConsciousness(randomStringForConsciousness);
		// % protected region % [Add customisation for Consciousness here] end
		// % protected region % [Add customisation for Pulse here] off begin
		newEntity.setPulse(mockNeat.doubles().get());
		// % protected region % [Add customisation for Pulse here] end
		// % protected region % [Add customisation for Pulse Rhythm here] off begin
		String randomStringForPulseRhythm = mockNeat
				.strings()
				.get();
		newEntity.setPulseRhythm(randomStringForPulseRhythm);
		// % protected region % [Add customisation for Pulse Rhythm here] end
		// % protected region % [Add customisation for Strength here] off begin
		String randomStringForStrength = mockNeat
				.strings()
				.get();
		newEntity.setStrength(randomStringForStrength);
		// % protected region % [Add customisation for Strength here] end
		// % protected region % [Add customisation for Gcs Eyes here] off begin
		String randomStringForGcsEyes = mockNeat
				.strings()
				.get();
		newEntity.setGcsEyes(randomStringForGcsEyes);
		// % protected region % [Add customisation for Gcs Eyes here] end
		// % protected region % [Add customisation for Gcs Verbal here] off begin
		String randomStringForGcsVerbal = mockNeat
				.strings()
				.get();
		newEntity.setGcsVerbal(randomStringForGcsVerbal);
		// % protected region % [Add customisation for Gcs Verbal here] end
		// % protected region % [Add customisation for Gcs Motor here] off begin
		String randomStringForGcsMotor = mockNeat
				.strings()
				.get();
		newEntity.setGcsMotor(randomStringForGcsMotor);
		// % protected region % [Add customisation for Gcs Motor here] end
		// % protected region % [Add customisation for Total Gcs Score here] off begin
		newEntity.setTotalGcsScore(mockNeat.doubles().get());
		// % protected region % [Add customisation for Total Gcs Score here] end
		// % protected region % [Add customisation for Respiratory here] off begin
		String randomStringForRespiratory = mockNeat
				.strings()
				.get();
		newEntity.setRespiratory(randomStringForRespiratory);
		// % protected region % [Add customisation for Respiratory here] end
		// % protected region % [Add customisation for Height here] off begin
		newEntity.setHeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Height here] end
		// % protected region % [Add customisation for Height Scale here] off begin
		String randomStringForHeightScale = mockNeat
				.strings()
				.get();
		newEntity.setHeightScale(randomStringForHeightScale);
		// % protected region % [Add customisation for Height Scale here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Weight Scale here] off begin
		String randomStringForWeightScale = mockNeat
				.strings()
				.get();
		newEntity.setWeightScale(randomStringForWeightScale);
		// % protected region % [Add customisation for Weight Scale here] end
		// % protected region % [Add customisation for Bmi here] off begin
		newEntity.setBmi(mockNeat.doubles().get());
		// % protected region % [Add customisation for Bmi here] end
		// % protected region % [Add customisation for Oxygen Saturation here] off begin
		newEntity.setOxygenSaturation(mockNeat.doubles().get());
		// % protected region % [Add customisation for Oxygen Saturation here] end
		// % protected region % [Add customisation for Nutrition Status here] off begin
		String randomStringForNutritionStatus = mockNeat
				.strings()
				.get();
		newEntity.setNutritionStatus(randomStringForNutritionStatus);
		// % protected region % [Add customisation for Nutrition Status here] end
		// % protected region % [Add customisation for Waist Circumference here] off begin
		newEntity.setWaistCircumference(mockNeat.doubles().get());
		// % protected region % [Add customisation for Waist Circumference here] end
		// % protected region % [Add customisation for Waist Circumference Unit here] off begin
		String randomStringForWaistCircumferenceUnit = mockNeat
				.strings()
				.get();
		newEntity.setWaistCircumferenceUnit(randomStringForWaistCircumferenceUnit);
		// % protected region % [Add customisation for Waist Circumference Unit here] end
		// % protected region % [Add customisation for Pain Scale here] off begin
		newEntity.setPainScale(mockNeat.doubles().get());
		// % protected region % [Add customisation for Pain Scale here] end
		// % protected region % [Add customisation for Pain Scale Used here] off begin
		String randomStringForPainScaleUsed = mockNeat
				.strings()
				.get();
		newEntity.setPainScaleUsed(randomStringForPainScaleUsed);
		// % protected region % [Add customisation for Pain Scale Used here] end
		// % protected region % [Add customisation for Risk Fall Scale here] off begin
		newEntity.setRiskFallScale(mockNeat.doubles().get());
		// % protected region % [Add customisation for Risk Fall Scale here] end
		// % protected region % [Add customisation for Risk Fall Scale Used here] off begin
		String randomStringForRiskFallScaleUsed = mockNeat
				.strings()
				.get();
		newEntity.setRiskFallScaleUsed(randomStringForRiskFallScaleUsed);
		// % protected region % [Add customisation for Risk Fall Scale Used here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end

		// % protected region % [Apply any additional logic for patientVitalInformationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformationWithNoRef after the main body here] end


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

		// % protected region % [Apply any additional logic for patientVitalInformation with ref here] off begin
		// % protected region % [Apply any additional logic for patientVitalInformation with ref here] end

		return newEntity;
	}

	@Override
	public Class<PatientVitalInformationEntity> getObjectType() {
		return PatientVitalInformationEntity.class;
	}
}