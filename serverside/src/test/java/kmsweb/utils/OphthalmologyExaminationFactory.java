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
import kmsweb.entities.OphthalmologyExaminationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class OphthalmologyExaminationFactory implements FactoryBean<OphthalmologyExaminationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public OphthalmologyExaminationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public OphthalmologyExaminationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public OphthalmologyExaminationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for ophthalmologyExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationWithNoRef before the main body here] end

		OphthalmologyExaminationEntity newEntity = new OphthalmologyExaminationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Right Eyelid Subjective here] off begin
		String randomStringForRightEyelidSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEyelidSubjective(randomStringForRightEyelidSubjective);
		// % protected region % [Add customisation for Right Eyelid Subjective here] end
		// % protected region % [Add customisation for Right Eyelid Objective here] off begin
		String randomStringForRightEyelidObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightEyelidObjective(randomStringForRightEyelidObjective);
		// % protected region % [Add customisation for Right Eyelid Objective here] end
		// % protected region % [Add customisation for Right Pupil Subjective here] off begin
		String randomStringForRightPupilSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightPupilSubjective(randomStringForRightPupilSubjective);
		// % protected region % [Add customisation for Right Pupil Subjective here] end
		// % protected region % [Add customisation for Right Pupil Objective here] off begin
		String randomStringForRightPupilObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightPupilObjective(randomStringForRightPupilObjective);
		// % protected region % [Add customisation for Right Pupil Objective here] end
		// % protected region % [Add customisation for Right Sclera Subjective here] off begin
		String randomStringForRightScleraSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightScleraSubjective(randomStringForRightScleraSubjective);
		// % protected region % [Add customisation for Right Sclera Subjective here] end
		// % protected region % [Add customisation for Right Sclera Objective here] off begin
		String randomStringForRightScleraObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightScleraObjective(randomStringForRightScleraObjective);
		// % protected region % [Add customisation for Right Sclera Objective here] end
		// % protected region % [Add customisation for Right Iris Subjective here] off begin
		String randomStringForRightIrisSubjective = mockNeat
				.strings()
				.get();
		newEntity.setRightIrisSubjective(randomStringForRightIrisSubjective);
		// % protected region % [Add customisation for Right Iris Subjective here] end
		// % protected region % [Add customisation for Right Iris Objective here] off begin
		String randomStringForRightIrisObjective = mockNeat
				.strings()
				.get();
		newEntity.setRightIrisObjective(randomStringForRightIrisObjective);
		// % protected region % [Add customisation for Right Iris Objective here] end
		// % protected region % [Add customisation for Left Eyelid Subjective here] off begin
		String randomStringForLeftEyelidSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEyelidSubjective(randomStringForLeftEyelidSubjective);
		// % protected region % [Add customisation for Left Eyelid Subjective here] end
		// % protected region % [Add customisation for Left Eyelid Objective here] off begin
		String randomStringForLeftEyelidObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftEyelidObjective(randomStringForLeftEyelidObjective);
		// % protected region % [Add customisation for Left Eyelid Objective here] end
		// % protected region % [Add customisation for Left Pupil Subjective here] off begin
		String randomStringForLeftPupilSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftPupilSubjective(randomStringForLeftPupilSubjective);
		// % protected region % [Add customisation for Left Pupil Subjective here] end
		// % protected region % [Add customisation for Left Pupil Objective here] off begin
		String randomStringForLeftPupilObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftPupilObjective(randomStringForLeftPupilObjective);
		// % protected region % [Add customisation for Left Pupil Objective here] end
		// % protected region % [Add customisation for Left Sclera Subjective here] off begin
		String randomStringForLeftScleraSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftScleraSubjective(randomStringForLeftScleraSubjective);
		// % protected region % [Add customisation for Left Sclera Subjective here] end
		// % protected region % [Add customisation for Left Sclera Objective here] off begin
		String randomStringForLeftScleraObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftScleraObjective(randomStringForLeftScleraObjective);
		// % protected region % [Add customisation for Left Sclera Objective here] end
		// % protected region % [Add customisation for Left Iris Subjective here] off begin
		String randomStringForLeftIrisSubjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftIrisSubjective(randomStringForLeftIrisSubjective);
		// % protected region % [Add customisation for Left Iris Subjective here] end
		// % protected region % [Add customisation for Left Iris Objective here] off begin
		String randomStringForLeftIrisObjective = mockNeat
				.strings()
				.get();
		newEntity.setLeftIrisObjective(randomStringForLeftIrisObjective);
		// % protected region % [Add customisation for Left Iris Objective here] end

		// % protected region % [Apply any additional logic for ophthalmologyExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExaminationWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
		}

		// % protected region % [Apply any additional logic for ophthalmologyExamination with ref here] off begin
		// % protected region % [Apply any additional logic for ophthalmologyExamination with ref here] end

		return newEntity;
	}

	@Override
	public Class<OphthalmologyExaminationEntity> getObjectType() {
		return OphthalmologyExaminationEntity.class;
	}
}