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
import kmsweb.entities.DiagnosticExaminationResultsEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class DiagnosticExaminationResultsFactory implements FactoryBean<DiagnosticExaminationResultsEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public DiagnosticExaminationResultsEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public DiagnosticExaminationResultsEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public DiagnosticExaminationResultsEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsWithNoRef before the main body here] end

		DiagnosticExaminationResultsEntity newEntity = new DiagnosticExaminationResultsEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Result here] off begin
		String randomStringForResult = mockNeat
				.strings()
				.size(1000)
				.get();
		newEntity.setResult(randomStringForResult);
		// % protected region % [Add customisation for Result here] end
		// % protected region % [Add customisation for Outside Range here] off begin
		newEntity.setOutsideRange(mockNeat.bools().get());
		// % protected region % [Add customisation for Outside Range here] end
		// % protected region % [Add customisation for Low here] off begin
		newEntity.setLow(mockNeat.doubles().get());
		// % protected region % [Add customisation for Low here] end
		// % protected region % [Add customisation for High here] off begin
		newEntity.setHigh(mockNeat.doubles().get());
		// % protected region % [Add customisation for High here] end
		// % protected region % [Add customisation for Unit here] off begin
		String randomStringForUnit = mockNeat
				.strings()
				.get();
		newEntity.setUnit(randomStringForUnit);
		// % protected region % [Add customisation for Unit here] end
		// % protected region % [Add customisation for Sample No here] off begin
		String randomStringForSampleNo = mockNeat
				.strings()
				.get();
		newEntity.setSampleNo(randomStringForSampleNo);
		// % protected region % [Add customisation for Sample No here] end
		// % protected region % [Add customisation for Sample Type here] off begin
		String randomStringForSampleType = mockNeat
				.strings()
				.get();
		newEntity.setSampleType(randomStringForSampleType);
		// % protected region % [Add customisation for Sample Type here] end
		// % protected region % [Add customisation for repeated here] off begin
		newEntity.setRepeated(mockNeat.bools().get());
		// % protected region % [Add customisation for repeated here] end
		// % protected region % [Add customisation for status here] off begin
		String randomStringForStatus = mockNeat
				.strings()
				.get();
		newEntity.setStatus(randomStringForStatus);
		// % protected region % [Add customisation for status here] end

		// % protected region % [Apply any additional logic for diagnosticExaminationResultsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResultsWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyExamination Item here] off begin
			var examinationItemFactory = new ExaminationItemFactory();
			newEntity.setExaminationItem(examinationItemFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyExamination Item here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] off begin
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRegistration here] end

		}

		// % protected region % [Apply any additional logic for diagnosticExaminationResults with ref here] off begin
		// % protected region % [Apply any additional logic for diagnosticExaminationResults with ref here] end

		return newEntity;
	}

	@Override
	public Class<DiagnosticExaminationResultsEntity> getObjectType() {
		return DiagnosticExaminationResultsEntity.class;
	}
}