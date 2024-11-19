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
import kmsweb.entities.HemodialysisMonitoringEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class HemodialysisMonitoringFactory implements FactoryBean<HemodialysisMonitoringEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public HemodialysisMonitoringEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public HemodialysisMonitoringEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public HemodialysisMonitoringEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for hemodialysisMonitoringWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringWithNoRef before the main body here] end

		HemodialysisMonitoringEntity newEntity = new HemodialysisMonitoringEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for DateTime here] off begin
		newEntity.setDatetime(OffsetDateTime.now());
		// % protected region % [Add customisation for DateTime here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mockNeat.doubles().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mockNeat.doubles().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Heart Rate here] off begin
		newEntity.setHeartRate(mockNeat.doubles().get());
		// % protected region % [Add customisation for Heart Rate here] end
		// % protected region % [Add customisation for Temperature here] off begin
		newEntity.setTemperature(mockNeat.doubles().get());
		// % protected region % [Add customisation for Temperature here] end
		// % protected region % [Add customisation for Temperature Unit here] off begin
		String randomStringForTemperatureUnit = mockNeat
				.strings()
				.get();
		newEntity.setTemperatureUnit(randomStringForTemperatureUnit);
		// % protected region % [Add customisation for Temperature Unit here] end
		// % protected region % [Add customisation for Respiratory here] off begin
		newEntity.setRespiratory(mockNeat.doubles().get());
		// % protected region % [Add customisation for Respiratory here] end
		// % protected region % [Add customisation for QB here] off begin
		newEntity.setQb(mockNeat.doubles().get());
		// % protected region % [Add customisation for QB here] end
		// % protected region % [Add customisation for QD here] off begin
		newEntity.setQd(mockNeat.doubles().get());
		// % protected region % [Add customisation for QD here] end
		// % protected region % [Add customisation for Venous Pressure here] off begin
		newEntity.setVenousPressure(mockNeat.doubles().get());
		// % protected region % [Add customisation for Venous Pressure here] end
		// % protected region % [Add customisation for TMP here] off begin
		newEntity.setTmp(mockNeat.doubles().get());
		// % protected region % [Add customisation for TMP here] end
		// % protected region % [Add customisation for UFG here] off begin
		newEntity.setUfg(mockNeat.doubles().get());
		// % protected region % [Add customisation for UFG here] end
		// % protected region % [Add customisation for UFR here] off begin
		newEntity.setUfr(mockNeat.doubles().get());
		// % protected region % [Add customisation for UFR here] end
		// % protected region % [Add customisation for UF here] off begin
		newEntity.setUf(mockNeat.doubles().get());
		// % protected region % [Add customisation for UF here] end

		// % protected region % [Apply any additional logic for hemodialysisMonitoringWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoringWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyHemodialysis Examination here] off begin
			var hemodialysisExaminationFactory = new HemodialysisExaminationFactory();
			newEntity.setHemodialysisExamination(hemodialysisExaminationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyHemodialysis Examination here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Staff here] off begin
			var medicalStaffFactory = new StaffFactory();
			newEntity.setMedicalStaff(medicalStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Staff here] end

		}

		// % protected region % [Apply any additional logic for hemodialysisMonitoring with ref here] off begin
		// % protected region % [Apply any additional logic for hemodialysisMonitoring with ref here] end

		return newEntity;
	}

	@Override
	public Class<HemodialysisMonitoringEntity> getObjectType() {
		return HemodialysisMonitoringEntity.class;
	}
}