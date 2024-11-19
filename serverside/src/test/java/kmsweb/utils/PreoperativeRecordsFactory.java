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
import kmsweb.entities.PreoperativeRecordsEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PreoperativeRecordsFactory implements FactoryBean<PreoperativeRecordsEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PreoperativeRecordsEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PreoperativeRecordsEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PreoperativeRecordsEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for preoperativeRecordsWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsWithNoRef before the main body here] end

		PreoperativeRecordsEntity newEntity = new PreoperativeRecordsEntity();
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
		// % protected region % [Add customisation for Physical Status Evaluation here] off begin
		String randomStringForPhysicalStatusEvaluation = mockNeat
				.strings()
				.get();
		newEntity.setPhysicalStatusEvaluation(randomStringForPhysicalStatusEvaluation);
		// % protected region % [Add customisation for Physical Status Evaluation here] end
		// % protected region % [Add customisation for Surgery Risk here] off begin
		String randomStringForSurgeryRisk = mockNeat
				.strings()
				.get();
		newEntity.setSurgeryRisk(randomStringForSurgeryRisk);
		// % protected region % [Add customisation for Surgery Risk here] end
		// % protected region % [Add customisation for Psychological State here] off begin
		String randomStringForPsychologicalState = mockNeat
				.strings()
				.get();
		newEntity.setPsychologicalState(randomStringForPsychologicalState);
		// % protected region % [Add customisation for Psychological State here] end
		// % protected region % [Add customisation for Anesthesia Surgery Risk here] off begin
		String randomStringForAnesthesiaSurgeryRisk = mockNeat
				.strings()
				.get();
		newEntity.setAnesthesiaSurgeryRisk(randomStringForAnesthesiaSurgeryRisk);
		// % protected region % [Add customisation for Anesthesia Surgery Risk here] end
		// % protected region % [Add customisation for Preoperative Evaluation here] off begin
		String randomStringForPreoperativeEvaluation = mockNeat
				.strings()
				.get();
		newEntity.setPreoperativeEvaluation(randomStringForPreoperativeEvaluation);
		// % protected region % [Add customisation for Preoperative Evaluation here] end
		// % protected region % [Add customisation for Anesthesia Notes here] off begin
		String randomStringForAnesthesiaNotes = mockNeat
				.strings()
				.get();
		newEntity.setAnesthesiaNotes(randomStringForAnesthesiaNotes);
		// % protected region % [Add customisation for Anesthesia Notes here] end
		// % protected region % [Add customisation for Surgical Specialty here] off begin
		String randomStringForSurgicalSpecialty = mockNeat
				.strings()
				.get();
		newEntity.setSurgicalSpecialty(randomStringForSurgicalSpecialty);
		// % protected region % [Add customisation for Surgical Specialty here] end
		// % protected region % [Add customisation for Antibiotic Prophylaxis Given here] off begin
		String randomStringForAntibioticProphylaxisGiven = mockNeat
				.strings()
				.get();
		newEntity.setAntibioticProphylaxisGiven(randomStringForAntibioticProphylaxisGiven);
		// % protected region % [Add customisation for Antibiotic Prophylaxis Given here] end
		// % protected region % [Add customisation for Surgery Type here] off begin
		String randomStringForSurgeryType = mockNeat
				.strings()
				.get();
		newEntity.setSurgeryType(randomStringForSurgeryType);
		// % protected region % [Add customisation for Surgery Type here] end
		// % protected region % [Add customisation for Surgery Class here] off begin
		String randomStringForSurgeryClass = mockNeat
				.strings()
				.get();
		newEntity.setSurgeryClass(randomStringForSurgeryClass);
		// % protected region % [Add customisation for Surgery Class here] end
		// % protected region % [Add customisation for Surgical Surgery Risk here] off begin
		String randomStringForSurgicalSurgeryRisk = mockNeat
				.strings()
				.get();
		newEntity.setSurgicalSurgeryRisk(randomStringForSurgicalSurgeryRisk);
		// % protected region % [Add customisation for Surgical Surgery Risk here] end
		// % protected region % [Add customisation for Physical Status Classification here] off begin
		String randomStringForPhysicalStatusClassification = mockNeat
				.strings()
				.get();
		newEntity.setPhysicalStatusClassification(randomStringForPhysicalStatusClassification);
		// % protected region % [Add customisation for Physical Status Classification here] end
		// % protected region % [Add customisation for Pre Surgery Diagnosis here] off begin
		String randomStringForPreSurgeryDiagnosis = mockNeat
				.strings()
				.get();
		newEntity.setPreSurgeryDiagnosis(randomStringForPreSurgeryDiagnosis);
		// % protected region % [Add customisation for Pre Surgery Diagnosis here] end
		// % protected region % [Add customisation for Preoperative Instructions here] off begin
		String randomStringForPreoperativeInstructions = mockNeat
				.strings()
				.get();
		newEntity.setPreoperativeInstructions(randomStringForPreoperativeInstructions);
		// % protected region % [Add customisation for Preoperative Instructions here] end
		// % protected region % [Add customisation for Preoperative Surgical Notes here] off begin
		String randomStringForPreoperativeSurgicalNotes = mockNeat
				.strings()
				.get();
		newEntity.setPreoperativeSurgicalNotes(randomStringForPreoperativeSurgicalNotes);
		// % protected region % [Add customisation for Preoperative Surgical Notes here] end

		// % protected region % [Apply any additional logic for preoperativeRecordsWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecordsWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Operating Theater Medical Examination Record here] off begin
			// Incoming One to One reference
			var operatingTheaterMedicalExaminationRecordFactory = new OperatingTheaterMedicalExaminationRecordFactory();
			newEntity.setOperatingTheaterMedicalExaminationRecord(operatingTheaterMedicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Operating Theater Medical Examination Record here] end
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAnesthesia Medical Transcriber here] off begin
			var anesthesiaMedicalTranscriberFactory = new StaffFactory();
			newEntity.setAnesthesiaMedicalTranscriber(anesthesiaMedicalTranscriberFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAnesthesia Medical Transcriber here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAnesthesiologist here] off begin
			var anesthesiologistFactory = new StaffFactory();
			newEntity.setAnesthesiologist(anesthesiologistFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAnesthesiologist here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAnesthesiology Nurse here] off begin
			var anesthesiologyNurseFactory = new StaffFactory();
			newEntity.setAnesthesiologyNurse(anesthesiologyNurseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAnesthesiology Nurse here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPre Surgery ICD 10 here] off begin
			var preSurgeryICD10Factory = new DiagnosesAndProceduresFactory();
			newEntity.setPreSurgeryICD10(preSurgeryICD10Factory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPre Surgery ICD 10 here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPre Surgery ICD 9 CM here] off begin
			var preSurgeryICD9CMFactory = new DiagnosesAndProceduresFactory();
			newEntity.setPreSurgeryICD9CM(preSurgeryICD9CMFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPre Surgery ICD 9 CM here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPreoperative Rooms here] off begin
			var preoperativeRoomsFactory = new RoomFacilityFactory();
			newEntity.setPreoperativeRooms(preoperativeRoomsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPreoperative Rooms here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySurgeon here] off begin
			var surgeonFactory = new StaffFactory();
			newEntity.setSurgeon(surgeonFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySurgeon here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySurgical Medical Transcriber here] off begin
			var surgicalMedicalTranscriberFactory = new StaffFactory();
			newEntity.setSurgicalMedicalTranscriber(surgicalMedicalTranscriberFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySurgical Medical Transcriber here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManySurgical Nurse here] off begin
			var surgicalNurseFactory = new StaffFactory();
			newEntity.setSurgicalNurse(surgicalNurseFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManySurgical Nurse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Additional Anesthesiologists here] off begin
			// Outgoing one to many reference
			var additionalAnesthesiologistsFactory = new CoTreatingDoctorFactory();
			newEntity.setAdditionalAnesthesiologists(Collections.singletonList(additionalAnesthesiologistsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Additional Anesthesiologists here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Additional Surgery Nurses here] off begin
			// Outgoing one to many reference
			var additionalSurgeryNursesFactory = new CoTreatingDoctorFactory();
			newEntity.setAdditionalSurgeryNurses(Collections.singletonList(additionalSurgeryNursesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Additional Surgery Nurses here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Facilities here] off begin
			// Outgoing one to many reference
			var bedFacilitiesFactory = new BedFacilityFactory();
			newEntity.setBedFacilities(Collections.singletonList(bedFacilitiesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Facilities here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Co Treating Anesthesiologists here] off begin
			// Outgoing one to many reference
			var coTreatingAnesthesiologistsFactory = new CoTreatingDoctorFactory();
			newEntity.setCoTreatingAnesthesiologists(Collections.singletonList(coTreatingAnesthesiologistsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Co Treating Anesthesiologists here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Co Treating Surgeons here] off begin
			// Outgoing one to many reference
			var coTreatingSurgeonsFactory = new CoTreatingDoctorFactory();
			newEntity.setCoTreatingSurgeons(Collections.singletonList(coTreatingSurgeonsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Co Treating Surgeons here] end

		}

		// % protected region % [Apply any additional logic for preoperativeRecords with ref here] off begin
		// % protected region % [Apply any additional logic for preoperativeRecords with ref here] end

		return newEntity;
	}

	@Override
	public Class<PreoperativeRecordsEntity> getObjectType() {
		return PreoperativeRecordsEntity.class;
	}
}