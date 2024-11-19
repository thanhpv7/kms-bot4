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
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class DiagnosisExaminationRecordFactory implements FactoryBean<DiagnosisExaminationRecordEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public DiagnosisExaminationRecordEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public DiagnosisExaminationRecordEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public DiagnosisExaminationRecordEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordWithNoRef before the main body here] end

		DiagnosisExaminationRecordEntity newEntity = new DiagnosisExaminationRecordEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Diagnosis Sequence here] off begin
		newEntity.setDiagnosisSequence(mockNeat.ints().get());
		// % protected region % [Add customisation for Diagnosis Sequence here] end
		// % protected region % [Add customisation for Diagnosis Notes here] off begin
		String randomStringForDiagnosisNotes = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setDiagnosisNotes(randomStringForDiagnosisNotes);
		// % protected region % [Add customisation for Diagnosis Notes here] end
		// % protected region % [Add customisation for Action Notes here] off begin
		String randomStringForActionNotes = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setActionNotes(randomStringForActionNotes);
		// % protected region % [Add customisation for Action Notes here] end
		// % protected region % [Add customisation for New Case here] off begin
		newEntity.setNewCase(mockNeat.bools().get());
		// % protected region % [Add customisation for New Case here] end
		// % protected region % [Add customisation for Printing Number here] off begin
		newEntity.setPrintingNumber(mockNeat.ints().get());
		// % protected region % [Add customisation for Printing Number here] end

		// % protected region % [Apply any additional logic for diagnosisExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecordWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for outgoingOneToOne Diagnostic Staff Examination Summary] off begin
			// Outgoing one to one reference
			var diagnosticStaffExaminationSummaryFactory = new DiagnosticStaffExaminationSummaryFactory();
			newEntity.setDiagnosticStaffExaminationSummary(diagnosticStaffExaminationSummaryFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Diagnostic Staff Examination Summary] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Sample Collection Information] off begin
			// Outgoing one to one reference
			var sampleCollectionInformationFactory = new SampleCollectionInformationFactory();
			newEntity.setSampleCollectionInformation(sampleCollectionInformationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Sample Collection Information] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Examination Record here] off begin
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Examination Record here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Examination Record Discharge Summary here] off begin
			var medicalExaminationRecordDischargeSummaryFactory = new MedicalExaminationRecordDischargeSummaryFactory();
			newEntity.setMedicalExaminationRecordDischargeSummary(medicalExaminationRecordDischargeSummaryFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMedical Examination Record Discharge Summary here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 10 here] off begin
			var icd10Factory = new DiagnosesAndProceduresFactory();
			newEntity.setIcd10(icd10Factory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 10 here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 9 CM here] off begin
			var icd9CMFactory = new DiagnosesAndProceduresFactory();
			newEntity.setIcd9CM(icd9CMFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyICD 9 CM here] end

		}

		// % protected region % [Apply any additional logic for diagnosisExaminationRecord with ref here] off begin
		// % protected region % [Apply any additional logic for diagnosisExaminationRecord with ref here] end

		return newEntity;
	}

	@Override
	public Class<DiagnosisExaminationRecordEntity> getObjectType() {
		return DiagnosisExaminationRecordEntity.class;
	}
}