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
import kmsweb.entities.DiagnosticStaffExaminationSummaryEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class DiagnosticStaffExaminationSummaryFactory implements FactoryBean<DiagnosticStaffExaminationSummaryEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public DiagnosticStaffExaminationSummaryEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public DiagnosticStaffExaminationSummaryEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public DiagnosticStaffExaminationSummaryEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryWithNoRef before the main body here] end

		DiagnosticStaffExaminationSummaryEntity newEntity = new DiagnosticStaffExaminationSummaryEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Responsible Doctor here] off begin
		String randomStringForResponsibleDoctor = mockNeat
				.strings()
				.get();
		newEntity.setResponsibleDoctor(randomStringForResponsibleDoctor);
		// % protected region % [Add customisation for Responsible Doctor here] end
		// % protected region % [Add customisation for Medical Transcriber here] off begin
		String randomStringForMedicalTranscriber = mockNeat
				.strings()
				.get();
		newEntity.setMedicalTranscriber(randomStringForMedicalTranscriber);
		// % protected region % [Add customisation for Medical Transcriber here] end
		// % protected region % [Add customisation for Referring Room here] off begin
		String randomStringForReferringRoom = mockNeat
				.strings()
				.get();
		newEntity.setReferringRoom(randomStringForReferringRoom);
		// % protected region % [Add customisation for Referring Room here] end
		// % protected region % [Add customisation for Refering Unit here] off begin
		String randomStringForReferingUnit = mockNeat
				.strings()
				.get();
		newEntity.setReferingUnit(randomStringForReferingUnit);
		// % protected region % [Add customisation for Refering Unit here] end
		// % protected region % [Add customisation for Examination Location here] off begin
		String randomStringForExaminationLocation = mockNeat
				.strings()
				.get();
		newEntity.setExaminationLocation(randomStringForExaminationLocation);
		// % protected region % [Add customisation for Examination Location here] end
		// % protected region % [Add customisation for Additional Notes here] off begin
		String randomStringForAdditionalNotes = mockNeat
				.strings()
				.get();
		newEntity.setAdditionalNotes(randomStringForAdditionalNotes);
		// % protected region % [Add customisation for Additional Notes here] end
		// % protected region % [Add customisation for Conclusion here] off begin
		String randomStringForConclusion = mockNeat
				.strings()
				.get();
		newEntity.setConclusion(randomStringForConclusion);
		// % protected region % [Add customisation for Conclusion here] end

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummaryWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnosis Examination Record here] off begin
			// Incoming One to One reference
			var diagnosisExaminationRecordFactory = new DiagnosisExaminationRecordFactory();
			newEntity.setDiagnosisExaminationRecord(diagnosisExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnosis Examination Record here] end
			// % protected region % [Override the reference inclusions for outgoingOneToOne Registration] off begin
			// Outgoing one to one reference
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Registration] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

		}

		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummary with ref here] off begin
		// % protected region % [Apply any additional logic for diagnosticStaffExaminationSummary with ref here] end

		return newEntity;
	}

	@Override
	public Class<DiagnosticStaffExaminationSummaryEntity> getObjectType() {
		return DiagnosticStaffExaminationSummaryEntity.class;
	}
}