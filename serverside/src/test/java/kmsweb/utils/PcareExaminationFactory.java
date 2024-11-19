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
import kmsweb.entities.PcareExaminationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class PcareExaminationFactory implements FactoryBean<PcareExaminationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public PcareExaminationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public PcareExaminationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public PcareExaminationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for pcareExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationWithNoRef before the main body here] end

		PcareExaminationEntity newEntity = new PcareExaminationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Visit Type here] off begin
		String randomStringForVisitType = mockNeat
				.strings()
				.get();
		newEntity.setVisitType(randomStringForVisitType);
		// % protected region % [Add customisation for Visit Type here] end
		// % protected region % [Add customisation for Treatment here] off begin
		String randomStringForTreatment = mockNeat
				.strings()
				.get();
		newEntity.setTreatment(randomStringForTreatment);
		// % protected region % [Add customisation for Treatment here] end
		// % protected region % [Add customisation for Destination Polyclinic here] off begin
		String randomStringForDestinationPolyclinic = mockNeat
				.strings()
				.get();
		newEntity.setDestinationPolyclinic(randomStringForDestinationPolyclinic);
		// % protected region % [Add customisation for Destination Polyclinic here] end
		// % protected region % [Add customisation for Disease here] off begin
		String randomStringForDisease = mockNeat
				.strings()
				.get();
		newEntity.setDisease(randomStringForDisease);
		// % protected region % [Add customisation for Disease here] end
		// % protected region % [Add customisation for Diagnosis here] off begin
		String randomStringForDiagnosis = mockNeat
				.strings()
				.get();
		newEntity.setDiagnosis(randomStringForDiagnosis);
		// % protected region % [Add customisation for Diagnosis here] end
		// % protected region % [Add customisation for Diagnosis 2 here] off begin
		String randomStringForDiagnosis2 = mockNeat
				.strings()
				.get();
		newEntity.setDiagnosis2(randomStringForDiagnosis2);
		// % protected region % [Add customisation for Diagnosis 2 here] end
		// % protected region % [Add customisation for Diagnosis 3 here] off begin
		String randomStringForDiagnosis3 = mockNeat
				.strings()
				.get();
		newEntity.setDiagnosis3(randomStringForDiagnosis3);
		// % protected region % [Add customisation for Diagnosis 3 here] end
		// % protected region % [Add customisation for Therapy here] off begin
		String randomStringForTherapy = mockNeat
				.strings()
				.get();
		newEntity.setTherapy(randomStringForTherapy);
		// % protected region % [Add customisation for Therapy here] end
		// % protected region % [Add customisation for Consciousness here] off begin
		String randomStringForConsciousness = mockNeat
				.strings()
				.get();
		newEntity.setConsciousness(randomStringForConsciousness);
		// % protected region % [Add customisation for Consciousness here] end
		// % protected region % [Add customisation for Discharge Status here] off begin
		String randomStringForDischargeStatus = mockNeat
				.strings()
				.get();
		newEntity.setDischargeStatus(randomStringForDischargeStatus);
		// % protected region % [Add customisation for Discharge Status here] end
		// % protected region % [Add customisation for Internal Referral Polyclinic here] off begin
		String randomStringForInternalReferralPolyclinic = mockNeat
				.strings()
				.get();
		newEntity.setInternalReferralPolyclinic(randomStringForInternalReferralPolyclinic);
		// % protected region % [Add customisation for Internal Referral Polyclinic here] end
		// % protected region % [Add customisation for Referring Date here] off begin
		newEntity.setReferringDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Referring Date here] end
		// % protected region % [Add customisation for PKK here] off begin
		String randomStringForPkk = mockNeat
				.strings()
				.get();
		newEntity.setPkk(randomStringForPkk);
		// % protected region % [Add customisation for PKK here] end
		// % protected region % [Add customisation for Sub Specialist here] off begin
		String randomStringForSubSpecialist = mockNeat
				.strings()
				.get();
		newEntity.setSubSpecialist(randomStringForSubSpecialist);
		// % protected region % [Add customisation for Sub Specialist here] end
		// % protected region % [Add customisation for Facility here] off begin
		String randomStringForFacility = mockNeat
				.strings()
				.get();
		newEntity.setFacility(randomStringForFacility);
		// % protected region % [Add customisation for Facility here] end
		// % protected region % [Add customisation for TACC here] off begin
		String randomStringForTacc = mockNeat
				.strings()
				.get();
		newEntity.setTacc(randomStringForTacc);
		// % protected region % [Add customisation for TACC here] end
		// % protected region % [Add customisation for TACC Reason here] off begin
		String randomStringForTaccReason = mockNeat
				.strings()
				.get();
		newEntity.setTaccReason(randomStringForTaccReason);
		// % protected region % [Add customisation for TACC Reason here] end
		// % protected region % [Add customisation for Special here] off begin
		String randomStringForSpecial = mockNeat
				.strings()
				.get();
		newEntity.setSpecial(randomStringForSpecial);
		// % protected region % [Add customisation for Special here] end
		// % protected region % [Add customisation for Height here] off begin
		newEntity.setHeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Height here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mockNeat.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Waist Circumference here] off begin
		newEntity.setWaistCircumference(mockNeat.doubles().get());
		// % protected region % [Add customisation for Waist Circumference here] end
		// % protected region % [Add customisation for BMI here] off begin
		newEntity.setBmi(mockNeat.doubles().get());
		// % protected region % [Add customisation for BMI here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mockNeat.ints().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mockNeat.ints().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Respiratory Rate here] off begin
		newEntity.setRespiratoryRate(mockNeat.doubles().get());
		// % protected region % [Add customisation for Respiratory Rate here] end
		// % protected region % [Add customisation for Heart Rate here] off begin
		newEntity.setHeartRate(mockNeat.doubles().get());
		// % protected region % [Add customisation for Heart Rate here] end
		// % protected region % [Add customisation for Medical Staff here] off begin
		String randomStringForMedicalStaff = mockNeat
				.strings()
				.get();
		newEntity.setMedicalStaff(randomStringForMedicalStaff);
		// % protected region % [Add customisation for Medical Staff here] end
		// % protected region % [Add customisation for tglPulang here] off begin
		String randomStringForTglpulang = mockNeat
				.strings()
				.get();
		newEntity.setTglpulang(randomStringForTglpulang);
		// % protected region % [Add customisation for tglPulang here] end
		// % protected region % [Add customisation for kdSubSpesialis1 here] off begin
		String randomStringForKdsubspesialis1 = mockNeat
				.strings()
				.get();
		newEntity.setKdsubspesialis1(randomStringForKdsubspesialis1);
		// % protected region % [Add customisation for kdSubSpesialis1 here] end
		// % protected region % [Add customisation for rujukLanjut here] off begin
		String randomStringForRujuklanjut = mockNeat
				.strings()
				.get();
		newEntity.setRujuklanjut(randomStringForRujuklanjut);
		// % protected region % [Add customisation for rujukLanjut here] end
		// % protected region % [Add customisation for catatan here] off begin
		String randomStringForCatatan = mockNeat
				.strings()
				.size(1000)
				.get();
		newEntity.setCatatan(randomStringForCatatan);
		// % protected region % [Add customisation for catatan here] end
		// % protected region % [Add customisation for noKunjungan here] off begin
		String randomStringForNokunjungan = mockNeat
				.strings()
				.get();
		newEntity.setNokunjungan(randomStringForNokunjungan);
		// % protected region % [Add customisation for noKunjungan here] end
		// % protected region % [Add customisation for JsonInsert here] off begin
		String randomStringForJsoninsert = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setJsoninsert(randomStringForJsoninsert);
		// % protected region % [Add customisation for JsonInsert here] end
		// % protected region % [Add customisation for JsonUpdate here] off begin
		String randomStringForJsonupdate = mockNeat
				.strings()
				.size(5000)
				.get();
		newEntity.setJsonupdate(randomStringForJsonupdate);
		// % protected region % [Add customisation for JsonUpdate here] end

		// % protected region % [Apply any additional logic for pcareExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] off begin
			// Incoming One to One reference
			var registrationFactory = new RegistrationFactory();
			newEntity.setRegistration(registrationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration here] end
			// % protected region % [Override the reference inclusion for outgoingOneToMany PCare Action Examinations here] off begin
			// Outgoing one to many reference
			var pcareActionExaminationsFactory = new PcareActionExaminationFactory();
			newEntity.setPcareActionExaminations(Collections.singletonList(pcareActionExaminationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany PCare Action Examinations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany PCare Compound Drugs here] off begin
			// Outgoing one to many reference
			var pcareCompoundDrugsFactory = new PcareCompoundDrugFactory();
			newEntity.setPcareCompoundDrugs(Collections.singletonList(pcareCompoundDrugsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany PCare Compound Drugs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany PCare NonCompound Drugs here] off begin
			// Outgoing one to many reference
			var pcareNonCompoundDrugsFactory = new PcareNonCompoundDrugFactory();
			newEntity.setPcareNonCompoundDrugs(Collections.singletonList(pcareNonCompoundDrugsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany PCare NonCompound Drugs here] end

		}

		// % protected region % [Apply any additional logic for pcareExamination with ref here] off begin
		// % protected region % [Apply any additional logic for pcareExamination with ref here] end

		return newEntity;
	}

	@Override
	public Class<PcareExaminationEntity> getObjectType() {
		return PcareExaminationEntity.class;
	}
}