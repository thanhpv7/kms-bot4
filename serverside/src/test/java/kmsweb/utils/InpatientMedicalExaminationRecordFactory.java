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
import kmsweb.entities.InpatientMedicalExaminationRecordEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class InpatientMedicalExaminationRecordFactory implements FactoryBean<InpatientMedicalExaminationRecordEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public InpatientMedicalExaminationRecordEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public InpatientMedicalExaminationRecordEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public InpatientMedicalExaminationRecordEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordWithNoRef before the main body here] end

		InpatientMedicalExaminationRecordEntity newEntity = new InpatientMedicalExaminationRecordEntity();
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
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Inpatient Case here] off begin
		String randomStringForInpatientCase = mockNeat
				.strings()
				.get();
		newEntity.setInpatientCase(randomStringForInpatientCase);
		// % protected region % [Add customisation for Inpatient Case here] end
		// % protected region % [Add customisation for Service Case here] off begin
		String randomStringForServiceCase = mockNeat
				.strings()
				.get();
		newEntity.setServiceCase(randomStringForServiceCase);
		// % protected region % [Add customisation for Service Case here] end
		// % protected region % [Add customisation for Dependency Level here] off begin
		String randomStringForDependencyLevel = mockNeat
				.strings()
				.get();
		newEntity.setDependencyLevel(randomStringForDependencyLevel);
		// % protected region % [Add customisation for Dependency Level here] end
		// % protected region % [Add customisation for Current Dependency here] off begin
		String randomStringForCurrentDependency = mockNeat
				.strings()
				.get();
		newEntity.setCurrentDependency(randomStringForCurrentDependency);
		// % protected region % [Add customisation for Current Dependency here] end
		// % protected region % [Add customisation for Infant Condition here] off begin
		String randomStringForInfantCondition = mockNeat
				.strings()
				.get();
		newEntity.setInfantCondition(randomStringForInfantCondition);
		// % protected region % [Add customisation for Infant Condition here] end
		// % protected region % [Add customisation for Neonatal Case here] off begin
		String randomStringForNeonatalCase = mockNeat
				.strings()
				.get();
		newEntity.setNeonatalCase(randomStringForNeonatalCase);
		// % protected region % [Add customisation for Neonatal Case here] end

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecordWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Examination Record] off begin
			// Outgoing one to one reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Examination Record] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBed Facility here] off begin
			var bedFacilityFactory = new BedFacilityFactory();
			newEntity.setBedFacility(bedFacilityFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBed Facility here] end

		}

		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecord with ref here] off begin
		// % protected region % [Apply any additional logic for inpatientMedicalExaminationRecord with ref here] end

		return newEntity;
	}

	@Override
	public Class<InpatientMedicalExaminationRecordEntity> getObjectType() {
		return InpatientMedicalExaminationRecordEntity.class;
	}
}