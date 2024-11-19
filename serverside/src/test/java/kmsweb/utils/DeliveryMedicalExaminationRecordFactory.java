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
import kmsweb.entities.DeliveryMedicalExaminationRecordEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class DeliveryMedicalExaminationRecordFactory implements FactoryBean<DeliveryMedicalExaminationRecordEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public DeliveryMedicalExaminationRecordEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public DeliveryMedicalExaminationRecordEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public DeliveryMedicalExaminationRecordEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordWithNoRef before the main body here] end

		DeliveryMedicalExaminationRecordEntity newEntity = new DeliveryMedicalExaminationRecordEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Pregnancy History Gravida here] off begin
		String randomStringForPregnancyHistoryGravida = mockNeat
				.strings()
				.get();
		newEntity.setPregnancyHistoryGravida(randomStringForPregnancyHistoryGravida);
		// % protected region % [Add customisation for Pregnancy History Gravida here] end
		// % protected region % [Add customisation for Pregnancy History Partum  here] off begin
		String randomStringForPregnancyHistoryPartum = mockNeat
				.strings()
				.get();
		newEntity.setPregnancyHistoryPartum(randomStringForPregnancyHistoryPartum);
		// % protected region % [Add customisation for Pregnancy History Partum  here] end
		// % protected region % [Add customisation for Pregnancy History Abortum  here] off begin
		String randomStringForPregnancyHistoryAbortum = mockNeat
				.strings()
				.get();
		newEntity.setPregnancyHistoryAbortum(randomStringForPregnancyHistoryAbortum);
		// % protected region % [Add customisation for Pregnancy History Abortum  here] end
		// % protected region % [Add customisation for Pregnancy History Notes here] off begin
		String randomStringForPregnancyHistoryNotes = mockNeat
				.strings()
				.get();
		newEntity.setPregnancyHistoryNotes(randomStringForPregnancyHistoryNotes);
		// % protected region % [Add customisation for Pregnancy History Notes here] end
		// % protected region % [Add customisation for LNMP Start Date here] off begin
		newEntity.setLnmpStartDate(OffsetDateTime.now());
		// % protected region % [Add customisation for LNMP Start Date here] end
		// % protected region % [Add customisation for LNMP End Date here] off begin
		newEntity.setLnmpEndDate(OffsetDateTime.now());
		// % protected region % [Add customisation for LNMP End Date here] end
		// % protected region % [Add customisation for Approximate Birth Date here] off begin
		newEntity.setApproximateBirthDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Approximate Birth Date here] end
		// % protected region % [Add customisation for Gestation Age Weeks here] off begin
		newEntity.setGestationAgeWeeks(mockNeat.ints().get());
		// % protected region % [Add customisation for Gestation Age Weeks here] end
		// % protected region % [Add customisation for Gestation Age Days here] off begin
		newEntity.setGestationAgeDays(mockNeat.ints().get());
		// % protected region % [Add customisation for Gestation Age Days here] end
		// % protected region % [Add customisation for Tetanus Vaccine 1 here] off begin
		newEntity.setTetanusVaccine1(mockNeat.bools().get());
		// % protected region % [Add customisation for Tetanus Vaccine 1 here] end
		// % protected region % [Add customisation for Tetanus Vaccine 2 here] off begin
		newEntity.setTetanusVaccine2(mockNeat.bools().get());
		// % protected region % [Add customisation for Tetanus Vaccine 2 here] end
		// % protected region % [Add customisation for Delivery Type here] off begin
		String randomStringForDeliveryType = mockNeat
				.strings()
				.get();
		newEntity.setDeliveryType(randomStringForDeliveryType);
		// % protected region % [Add customisation for Delivery Type here] end
		// % protected region % [Add customisation for Complications In Pregnancy here] off begin
		String randomStringForComplicationsInPregnancy = mockNeat
				.strings()
				.get();
		newEntity.setComplicationsInPregnancy(randomStringForComplicationsInPregnancy);
		// % protected region % [Add customisation for Complications In Pregnancy here] end
		// % protected region % [Add customisation for Risk Factor here] off begin
		String randomStringForRiskFactor = mockNeat
				.strings()
				.get();
		newEntity.setRiskFactor(randomStringForRiskFactor);
		// % protected region % [Add customisation for Risk Factor here] end
		// % protected region % [Add customisation for Fetal Presentation here] off begin
		String randomStringForFetalPresentation = mockNeat
				.strings()
				.get();
		newEntity.setFetalPresentation(randomStringForFetalPresentation);
		// % protected region % [Add customisation for Fetal Presentation here] end
		// % protected region % [Add customisation for Abdomen Examination here] off begin
		String randomStringForAbdomenExamination = mockNeat
				.strings()
				.get();
		newEntity.setAbdomenExamination(randomStringForAbdomenExamination);
		// % protected region % [Add customisation for Abdomen Examination here] end
		// % protected region % [Add customisation for Fundal Height here] off begin
		String randomStringForFundalHeight = mockNeat
				.strings()
				.get();
		newEntity.setFundalHeight(randomStringForFundalHeight);
		// % protected region % [Add customisation for Fundal Height here] end
		// % protected region % [Add customisation for FHR Per Minute here] off begin
		String randomStringForFhrPerMinute = mockNeat
				.strings()
				.get();
		newEntity.setFhrPerMinute(randomStringForFhrPerMinute);
		// % protected region % [Add customisation for FHR Per Minute here] end
		// % protected region % [Add customisation for Estimated Fetal Weight here] off begin
		String randomStringForEstimatedFetalWeight = mockNeat
				.strings()
				.get();
		newEntity.setEstimatedFetalWeight(randomStringForEstimatedFetalWeight);
		// % protected region % [Add customisation for Estimated Fetal Weight here] end
		// % protected region % [Add customisation for Leopold 1 here] off begin
		String randomStringForLeopold1 = mockNeat
				.strings()
				.get();
		newEntity.setLeopold1(randomStringForLeopold1);
		// % protected region % [Add customisation for Leopold 1 here] end
		// % protected region % [Add customisation for Leopold 2 here] off begin
		String randomStringForLeopold2 = mockNeat
				.strings()
				.get();
		newEntity.setLeopold2(randomStringForLeopold2);
		// % protected region % [Add customisation for Leopold 2 here] end
		// % protected region % [Add customisation for Leopold 3 here] off begin
		String randomStringForLeopold3 = mockNeat
				.strings()
				.get();
		newEntity.setLeopold3(randomStringForLeopold3);
		// % protected region % [Add customisation for Leopold 3 here] end
		// % protected region % [Add customisation for Leopold 4 here] off begin
		String randomStringForLeopold4 = mockNeat
				.strings()
				.get();
		newEntity.setLeopold4(randomStringForLeopold4);
		// % protected region % [Add customisation for Leopold 4 here] end
		// % protected region % [Add customisation for Genitelia Externa here] off begin
		String randomStringForGeniteliaExterna = mockNeat
				.strings()
				.get();
		newEntity.setGeniteliaExterna(randomStringForGeniteliaExterna);
		// % protected region % [Add customisation for Genitelia Externa here] end
		// % protected region % [Add customisation for Genitelia Interna here] off begin
		String randomStringForGeniteliaInterna = mockNeat
				.strings()
				.get();
		newEntity.setGeniteliaInterna(randomStringForGeniteliaInterna);
		// % protected region % [Add customisation for Genitelia Interna here] end
		// % protected region % [Add customisation for Vaginal Examination here] off begin
		String randomStringForVaginalExamination = mockNeat
				.strings()
				.get();
		newEntity.setVaginalExamination(randomStringForVaginalExamination);
		// % protected region % [Add customisation for Vaginal Examination here] end
		// % protected region % [Add customisation for Delivery Complication here] off begin
		String randomStringForDeliveryComplication = mockNeat
				.strings()
				.get();
		newEntity.setDeliveryComplication(randomStringForDeliveryComplication);
		// % protected region % [Add customisation for Delivery Complication here] end
		// % protected region % [Add customisation for Delivery Note here] off begin
		String randomStringForDeliveryNote = mockNeat
				.strings()
				.get();
		newEntity.setDeliveryNote(randomStringForDeliveryNote);
		// % protected region % [Add customisation for Delivery Note here] end
		// % protected region % [Add customisation for Normal Delivery Case here] off begin
		newEntity.setNormalDeliveryCase(mockNeat.bools().get());
		// % protected region % [Add customisation for Normal Delivery Case here] end
		// % protected region % [Add customisation for Stage 1 Hour here] off begin
		newEntity.setStage1Hour(mockNeat.ints().get());
		// % protected region % [Add customisation for Stage 1 Hour here] end
		// % protected region % [Add customisation for Unnamed Integer 1 here] off begin
		newEntity.setUnnamedInteger1(mockNeat.ints().get());
		// % protected region % [Add customisation for Unnamed Integer 1 here] end
		// % protected region % [Add customisation for Stage 3 Hour here] off begin
		newEntity.setStage3Hour(mockNeat.ints().get());
		// % protected region % [Add customisation for Stage 3 Hour here] end
		// % protected region % [Add customisation for Stage 4 Hour here] off begin
		newEntity.setStage4Hour(mockNeat.ints().get());
		// % protected region % [Add customisation for Stage 4 Hour here] end
		// % protected region % [Add customisation for Stage 1 Minute here] off begin
		newEntity.setStage1Minute(mockNeat.ints().get());
		// % protected region % [Add customisation for Stage 1 Minute here] end
		// % protected region % [Add customisation for Stage 2 Minute here] off begin
		newEntity.setStage2Minute(mockNeat.ints().get());
		// % protected region % [Add customisation for Stage 2 Minute here] end
		// % protected region % [Add customisation for Stage 3 Minute here] off begin
		newEntity.setStage3Minute(mockNeat.ints().get());
		// % protected region % [Add customisation for Stage 3 Minute here] end
		// % protected region % [Add customisation for Stage 4 Minute here] off begin
		newEntity.setStage4Minute(mockNeat.ints().get());
		// % protected region % [Add customisation for Stage 4 Minute here] end
		// % protected region % [Add customisation for Placenta here] off begin
		String randomStringForPlacenta = mockNeat
				.strings()
				.get();
		newEntity.setPlacenta(randomStringForPlacenta);
		// % protected region % [Add customisation for Placenta here] end
		// % protected region % [Add customisation for Perineum here] off begin
		String randomStringForPerineum = mockNeat
				.strings()
				.get();
		newEntity.setPerineum(randomStringForPerineum);
		// % protected region % [Add customisation for Perineum here] end
		// % protected region % [Add customisation for Bleeding here] off begin
		String randomStringForBleeding = mockNeat
				.strings()
				.get();
		newEntity.setBleeding(randomStringForBleeding);
		// % protected region % [Add customisation for Bleeding here] end
		// % protected region % [Add customisation for Postpartum Complication here] off begin
		String randomStringForPostpartumComplication = mockNeat
				.strings()
				.get();
		newEntity.setPostpartumComplication(randomStringForPostpartumComplication);
		// % protected region % [Add customisation for Postpartum Complication here] end
		// % protected region % [Add customisation for Newborn Delivered here] off begin
		newEntity.setNewbornDelivered(mockNeat.ints().get());
		// % protected region % [Add customisation for Newborn Delivered here] end
		// % protected region % [Add customisation for Perineum Infection here] off begin
		newEntity.setPerineumInfection(mockNeat.bools().get());
		// % protected region % [Add customisation for Perineum Infection here] end
		// % protected region % [Add customisation for Early Breastfeeding Intiation here] off begin
		newEntity.setEarlyBreastfeedingIntiation(mockNeat.bools().get());
		// % protected region % [Add customisation for Early Breastfeeding Intiation here] end

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecordWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] off begin
			// Incoming One to One reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Examination Record here] end
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyMidwife here] off begin
			var midwifeFactory = new StaffFactory();
			newEntity.setMidwife(midwifeFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyMidwife here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Additional Midwives here] off begin
			// Outgoing one to many reference
			var additionalMidwivesFactory = new CoTreatingDoctorFactory();
			newEntity.setAdditionalMidwives(Collections.singletonList(additionalMidwivesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Additional Midwives here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Delivery Progresses here] off begin
			// Outgoing one to many reference
			var deliveryProgressesFactory = new DeliveryProgressFactory();
			newEntity.setDeliveryProgresses(Collections.singletonList(deliveryProgressesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Delivery Progresses here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Newborn Details here] off begin
			// Outgoing one to many reference
			var newbornDetailsFactory = new NewbornDetailFactory();
			newEntity.setNewbornDetails(Collections.singletonList(newbornDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Newborn Details here] end

		}

		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecord with ref here] off begin
		// % protected region % [Apply any additional logic for deliveryMedicalExaminationRecord with ref here] end

		return newEntity;
	}

	@Override
	public Class<DeliveryMedicalExaminationRecordEntity> getObjectType() {
		return DeliveryMedicalExaminationRecordEntity.class;
	}
}