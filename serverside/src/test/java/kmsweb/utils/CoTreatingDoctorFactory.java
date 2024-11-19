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
import kmsweb.entities.CoTreatingDoctorEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class CoTreatingDoctorFactory implements FactoryBean<CoTreatingDoctorEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public CoTreatingDoctorEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public CoTreatingDoctorEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public CoTreatingDoctorEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for coTreatingDoctorWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorWithNoRef before the main body here] end

		CoTreatingDoctorEntity newEntity = new CoTreatingDoctorEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Doctor Notes here] off begin
		String randomStringForDoctorNotes = mockNeat
				.strings()
				.get();
		newEntity.setDoctorNotes(randomStringForDoctorNotes);
		// % protected region % [Add customisation for Doctor Notes here] end

		// % protected region % [Apply any additional logic for coTreatingDoctorWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctorWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Anesthesiologist here] off begin
			var additionalAnesthesiologistFactory = new PreoperativeRecordsFactory();
			newEntity.setAdditionalAnesthesiologist(additionalAnesthesiologistFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Anesthesiologist here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Midwife here] off begin
			var additionalMidwifeFactory = new DeliveryMedicalExaminationRecordFactory();
			newEntity.setAdditionalMidwife(additionalMidwifeFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Midwife here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Surgery Nurse here] off begin
			var additionalSurgeryNurseFactory = new PreoperativeRecordsFactory();
			newEntity.setAdditionalSurgeryNurse(additionalSurgeryNurseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAdditional Surgery Nurse here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyCo Treating Anesthesiologist here] off begin
			var coTreatingAnesthesiologistFactory = new PreoperativeRecordsFactory();
			newEntity.setCoTreatingAnesthesiologist(coTreatingAnesthesiologistFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyCo Treating Anesthesiologist here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Examination Record here] off begin
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Examination Record here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyCo Treating Surgeon here] off begin
			var coTreatingSurgeonFactory = new PreoperativeRecordsFactory();
			newEntity.setCoTreatingSurgeon(coTreatingSurgeonFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyCo Treating Surgeon here] end

		}

		// % protected region % [Apply any additional logic for coTreatingDoctor with ref here] off begin
		// % protected region % [Apply any additional logic for coTreatingDoctor with ref here] end

		return newEntity;
	}

	@Override
	public Class<CoTreatingDoctorEntity> getObjectType() {
		return CoTreatingDoctorEntity.class;
	}
}