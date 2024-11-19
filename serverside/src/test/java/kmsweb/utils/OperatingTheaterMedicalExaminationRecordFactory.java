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
import kmsweb.entities.OperatingTheaterMedicalExaminationRecordEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class OperatingTheaterMedicalExaminationRecordFactory implements FactoryBean<OperatingTheaterMedicalExaminationRecordEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public OperatingTheaterMedicalExaminationRecordEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public OperatingTheaterMedicalExaminationRecordEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public OperatingTheaterMedicalExaminationRecordEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordWithNoRef before the main body here] end

		OperatingTheaterMedicalExaminationRecordEntity newEntity = new OperatingTheaterMedicalExaminationRecordEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Has Confirmed Identity here] off begin
		newEntity.setHasConfirmedIdentity(mockNeat.bools().get());
		// % protected region % [Add customisation for Has Confirmed Identity here] end
		// % protected region % [Add customisation for Anesthesia Safety Check Completed here] off begin
		newEntity.setAnesthesiaSafetyCheckCompleted(mockNeat.bools().get());
		// % protected region % [Add customisation for Anesthesia Safety Check Completed here] end
		// % protected region % [Add customisation for Pulse Oxymeter Functioning here] off begin
		newEntity.setPulseOxymeterFunctioning(mockNeat.bools().get());
		// % protected region % [Add customisation for Pulse Oxymeter Functioning here] end
		// % protected region % [Add customisation for Site Marked here] off begin
		String randomStringForSiteMarked = mockNeat
				.strings()
				.get();
		newEntity.setSiteMarked(randomStringForSiteMarked);
		// % protected region % [Add customisation for Site Marked here] end
		// % protected region % [Add customisation for Has Known Allergy here] off begin
		String randomStringForHasKnownAllergy = mockNeat
				.strings()
				.get();
		newEntity.setHasKnownAllergy(randomStringForHasKnownAllergy);
		// % protected region % [Add customisation for Has Known Allergy here] end
		// % protected region % [Add customisation for Has Difficult Airway Risk here] off begin
		String randomStringForHasDifficultAirwayRisk = mockNeat
				.strings()
				.get();
		newEntity.setHasDifficultAirwayRisk(randomStringForHasDifficultAirwayRisk);
		// % protected region % [Add customisation for Has Difficult Airway Risk here] end
		// % protected region % [Add customisation for Has Risk Of Blood Loss here] off begin
		String randomStringForHasRiskOfBloodLoss = mockNeat
				.strings()
				.get();
		newEntity.setHasRiskOfBloodLoss(randomStringForHasRiskOfBloodLoss);
		// % protected region % [Add customisation for Has Risk Of Blood Loss here] end
		// % protected region % [Add customisation for Team Member Introduced here] off begin
		newEntity.setTeamMemberIntroduced(mockNeat.bools().get());
		// % protected region % [Add customisation for Team Member Introduced here] end
		// % protected region % [Add customisation for Professional Confirmed Patient here] off begin
		newEntity.setProfessionalConfirmedPatient(mockNeat.bools().get());
		// % protected region % [Add customisation for Professional Confirmed Patient here] end
		// % protected region % [Add customisation for Antibiotic Prophylaxis Given here] off begin
		String randomStringForAntibioticProphylaxisGiven = mockNeat
				.strings()
				.get();
		newEntity.setAntibioticProphylaxisGiven(randomStringForAntibioticProphylaxisGiven);
		// % protected region % [Add customisation for Antibiotic Prophylaxis Given here] end
		// % protected region % [Add customisation for Essential Imaging Displayed here] off begin
		String randomStringForEssentialImagingDisplayed = mockNeat
				.strings()
				.get();
		newEntity.setEssentialImagingDisplayed(randomStringForEssentialImagingDisplayed);
		// % protected region % [Add customisation for Essential Imaging Displayed here] end
		// % protected region % [Add customisation for Whare Are Critical Steps here] off begin
		newEntity.setWhareAreCriticalSteps(mockNeat.bools().get());
		// % protected region % [Add customisation for Whare Are Critical Steps here] end
		// % protected region % [Add customisation for How Long Case Take here] off begin
		newEntity.setHowLongCaseTake(mockNeat.bools().get());
		// % protected region % [Add customisation for How Long Case Take here] end
		// % protected region % [Add customisation for What Is Anticipated Blood Loss here] off begin
		newEntity.setWhatIsAnticipatedBloodLoss(mockNeat.bools().get());
		// % protected region % [Add customisation for What Is Anticipated Blood Loss here] end
		// % protected region % [Add customisation for Any Patient Specific Concerns here] off begin
		newEntity.setAnyPatientSpecificConcerns(mockNeat.bools().get());
		// % protected region % [Add customisation for Any Patient Specific Concerns here] end
		// % protected region % [Add customisation for Sterlity Been Confirmed here] off begin
		newEntity.setSterlityBeenConfirmed(mockNeat.bools().get());
		// % protected region % [Add customisation for Sterlity Been Confirmed here] end
		// % protected region % [Add customisation for Equipment Issues Any Concern here] off begin
		newEntity.setEquipmentIssuesAnyConcern(mockNeat.bools().get());
		// % protected region % [Add customisation for Equipment Issues Any Concern here] end
		// % protected region % [Add customisation for Name Of Procedure here] off begin
		newEntity.setNameOfProcedure(mockNeat.bools().get());
		// % protected region % [Add customisation for Name Of Procedure here] end
		// % protected region % [Add customisation for Instruments Need Count Correct here] off begin
		newEntity.setInstrumentsNeedCountCorrect(mockNeat.bools().get());
		// % protected region % [Add customisation for Instruments Need Count Correct here] end
		// % protected region % [Add customisation for Specimen Is Labeled here] off begin
		newEntity.setSpecimenIsLabeled(mockNeat.bools().get());
		// % protected region % [Add customisation for Specimen Is Labeled here] end
		// % protected region % [Add customisation for Equipment Problems Addressed here] off begin
		newEntity.setEquipmentProblemsAddressed(mockNeat.bools().get());
		// % protected region % [Add customisation for Equipment Problems Addressed here] end
		// % protected region % [Add customisation for Key Concerns For Recovery here] off begin
		newEntity.setKeyConcernsForRecovery(mockNeat.bools().get());
		// % protected region % [Add customisation for Key Concerns For Recovery here] end

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecordWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
			// % protected region % [Override the reference inclusions for outgoingOneToOne Intraoperative Records] off begin
			// Outgoing one to one reference
			var intraoperativeRecordsFactory = new IntraoperativeRecordsFactory();
			newEntity.setIntraoperativeRecords(intraoperativeRecordsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Intraoperative Records] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Post Operative Details] off begin
			// Outgoing one to one reference
			var postOperativeDetailsFactory = new PostOperativeDetailsFactory();
			newEntity.setPostOperativeDetails(postOperativeDetailsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Post Operative Details] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Preoperative Records] off begin
			// Outgoing one to one reference
			var preoperativeRecordsFactory = new PreoperativeRecordsFactory();
			newEntity.setPreoperativeRecords(preoperativeRecordsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Preoperative Records] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyNursing Anesthesia Detail here] off begin
			var nursingAnesthesiaDetailFactory = new DiagnosisNandaFactory();
			newEntity.setNursingAnesthesiaDetail(nursingAnesthesiaDetailFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyNursing Anesthesia Detail here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyNursing Detail Surgical Nursings here] off begin
			var nursingDetailSurgicalNursingsFactory = new StaffFactory();
			newEntity.setNursingDetailSurgicalNursings(nursingDetailSurgicalNursingsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyNursing Detail Surgical Nursings here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyNursing Details Anesthesia Nursings here] off begin
			var nursingDetailsAnesthesiaNursingsFactory = new StaffFactory();
			newEntity.setNursingDetailsAnesthesiaNursings(nursingDetailsAnesthesiaNursingsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyNursing Details Anesthesia Nursings here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyNursing Surgical Detail here] off begin
			var nursingSurgicalDetailFactory = new DiagnosisNandaFactory();
			newEntity.setNursingSurgicalDetail(nursingSurgicalDetailFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyNursing Surgical Detail here] end

		}

		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecord with ref here] off begin
		// % protected region % [Apply any additional logic for operatingTheaterMedicalExaminationRecord with ref here] end

		return newEntity;
	}

	@Override
	public Class<OperatingTheaterMedicalExaminationRecordEntity> getObjectType() {
		return OperatingTheaterMedicalExaminationRecordEntity.class;
	}
}