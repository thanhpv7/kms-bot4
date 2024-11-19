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
package kmsweb.inject.modules.entities;

import kmsweb.entities.*;
import kmsweb.entities.enums.*;
import kmsweb.inject.factories.*;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

// % protected region % [Apply any additional imports here] off begin
// % protected region % [Apply any additional imports here] end

/**
 * Guice module for PCare Examination used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class PcareExaminationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring PcareExaminationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured PcareExaminationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public PcareExaminationEntityFactory pcareExaminationEntityFactory(
			// % protected region % [Apply any additional injected arguments for pcareExaminationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for pcareExaminationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating PcareExaminationEntityFactory");

		// % protected region % [Apply any additional logic for pcareExaminationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationEntityFactory before the main body here] end

		PcareExaminationEntityFactory entityFactory = new PcareExaminationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for PcareExaminationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for PcareExaminationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for pcareExaminationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationEntityFactory after the main body here] end

		log.trace("Created PcareExaminationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty PCare Examination entity with no references set.
	 */
	@Provides
	@Named("pcareExaminationEntityWithNoRef")
	public PcareExaminationEntity pcareExaminationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for pcareExaminationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareExaminationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type PcareExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for pcareExaminationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationWithNoRef before the main body here] end

		PcareExaminationEntity newEntity = new PcareExaminationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Visit Type here] off begin
		String randomStringforVisitType = mock
				.strings()
				.get();
		newEntity.setVisitType(randomStringforVisitType);
		// % protected region % [Add customisation for Visit Type here] end
		// % protected region % [Add customisation for Treatment here] off begin
		String randomStringforTreatment = mock
				.strings()
				.get();
		newEntity.setTreatment(randomStringforTreatment);
		// % protected region % [Add customisation for Treatment here] end
		// % protected region % [Add customisation for Destination Polyclinic here] off begin
		String randomStringforDestinationPolyclinic = mock
				.strings()
				.get();
		newEntity.setDestinationPolyclinic(randomStringforDestinationPolyclinic);
		// % protected region % [Add customisation for Destination Polyclinic here] end
		// % protected region % [Add customisation for Disease here] off begin
		String randomStringforDisease = mock
				.strings()
				.get();
		newEntity.setDisease(randomStringforDisease);
		// % protected region % [Add customisation for Disease here] end
		// % protected region % [Add customisation for Diagnosis here] off begin
		String randomStringforDiagnosis = mock
				.strings()
				.get();
		newEntity.setDiagnosis(randomStringforDiagnosis);
		// % protected region % [Add customisation for Diagnosis here] end
		// % protected region % [Add customisation for Diagnosis 2 here] off begin
		String randomStringforDiagnosis2 = mock
				.strings()
				.get();
		newEntity.setDiagnosis2(randomStringforDiagnosis2);
		// % protected region % [Add customisation for Diagnosis 2 here] end
		// % protected region % [Add customisation for Diagnosis 3 here] off begin
		String randomStringforDiagnosis3 = mock
				.strings()
				.get();
		newEntity.setDiagnosis3(randomStringforDiagnosis3);
		// % protected region % [Add customisation for Diagnosis 3 here] end
		// % protected region % [Add customisation for Therapy here] off begin
		String randomStringforTherapy = mock
				.strings()
				.get();
		newEntity.setTherapy(randomStringforTherapy);
		// % protected region % [Add customisation for Therapy here] end
		// % protected region % [Add customisation for Consciousness here] off begin
		String randomStringforConsciousness = mock
				.strings()
				.get();
		newEntity.setConsciousness(randomStringforConsciousness);
		// % protected region % [Add customisation for Consciousness here] end
		// % protected region % [Add customisation for Discharge Status here] off begin
		String randomStringforDischargeStatus = mock
				.strings()
				.get();
		newEntity.setDischargeStatus(randomStringforDischargeStatus);
		// % protected region % [Add customisation for Discharge Status here] end
		// % protected region % [Add customisation for Internal Referral Polyclinic here] off begin
		String randomStringforInternalReferralPolyclinic = mock
				.strings()
				.get();
		newEntity.setInternalReferralPolyclinic(randomStringforInternalReferralPolyclinic);
		// % protected region % [Add customisation for Internal Referral Polyclinic here] end
		// % protected region % [Add customisation for Referring Date here] off begin
		newEntity.setReferringDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Referring Date here] end
		// % protected region % [Add customisation for PKK here] off begin
		String randomStringforPkk = mock
				.strings()
				.get();
		newEntity.setPkk(randomStringforPkk);
		// % protected region % [Add customisation for PKK here] end
		// % protected region % [Add customisation for Sub Specialist here] off begin
		String randomStringforSubSpecialist = mock
				.strings()
				.get();
		newEntity.setSubSpecialist(randomStringforSubSpecialist);
		// % protected region % [Add customisation for Sub Specialist here] end
		// % protected region % [Add customisation for Facility here] off begin
		String randomStringforFacility = mock
				.strings()
				.get();
		newEntity.setFacility(randomStringforFacility);
		// % protected region % [Add customisation for Facility here] end
		// % protected region % [Add customisation for TACC here] off begin
		String randomStringforTacc = mock
				.strings()
				.get();
		newEntity.setTacc(randomStringforTacc);
		// % protected region % [Add customisation for TACC here] end
		// % protected region % [Add customisation for TACC Reason here] off begin
		String randomStringforTaccReason = mock
				.strings()
				.get();
		newEntity.setTaccReason(randomStringforTaccReason);
		// % protected region % [Add customisation for TACC Reason here] end
		// % protected region % [Add customisation for Special here] off begin
		String randomStringforSpecial = mock
				.strings()
				.get();
		newEntity.setSpecial(randomStringforSpecial);
		// % protected region % [Add customisation for Special here] end
		// % protected region % [Add customisation for Height here] off begin
		newEntity.setHeight(mock.doubles().get());
		// % protected region % [Add customisation for Height here] end
		// % protected region % [Add customisation for Weight here] off begin
		newEntity.setWeight(mock.doubles().get());
		// % protected region % [Add customisation for Weight here] end
		// % protected region % [Add customisation for Waist Circumference here] off begin
		newEntity.setWaistCircumference(mock.doubles().get());
		// % protected region % [Add customisation for Waist Circumference here] end
		// % protected region % [Add customisation for BMI here] off begin
		newEntity.setBmi(mock.doubles().get());
		// % protected region % [Add customisation for BMI here] end
		// % protected region % [Add customisation for Systole here] off begin
		newEntity.setSystole(mock.ints().get());
		// % protected region % [Add customisation for Systole here] end
		// % protected region % [Add customisation for Diastole here] off begin
		newEntity.setDiastole(mock.ints().get());
		// % protected region % [Add customisation for Diastole here] end
		// % protected region % [Add customisation for Respiratory Rate here] off begin
		newEntity.setRespiratoryRate(mock.doubles().get());
		// % protected region % [Add customisation for Respiratory Rate here] end
		// % protected region % [Add customisation for Heart Rate here] off begin
		newEntity.setHeartRate(mock.doubles().get());
		// % protected region % [Add customisation for Heart Rate here] end
		// % protected region % [Add customisation for Medical Staff here] off begin
		String randomStringforMedicalStaff = mock
				.strings()
				.get();
		newEntity.setMedicalStaff(randomStringforMedicalStaff);
		// % protected region % [Add customisation for Medical Staff here] end
		// % protected region % [Add customisation for tglPulang here] off begin
		String randomStringforTglpulang = mock
				.strings()
				.get();
		newEntity.setTglpulang(randomStringforTglpulang);
		// % protected region % [Add customisation for tglPulang here] end
		// % protected region % [Add customisation for kdSubSpesialis1 here] off begin
		String randomStringforKdsubspesialis1 = mock
				.strings()
				.get();
		newEntity.setKdsubspesialis1(randomStringforKdsubspesialis1);
		// % protected region % [Add customisation for kdSubSpesialis1 here] end
		// % protected region % [Add customisation for rujukLanjut here] off begin
		String randomStringforRujuklanjut = mock
				.strings()
				.get();
		newEntity.setRujuklanjut(randomStringforRujuklanjut);
		// % protected region % [Add customisation for rujukLanjut here] end
		// % protected region % [Add customisation for catatan here] off begin
		String randomStringforCatatan = mock
				.strings()
				.size(1000)
				.get();
		newEntity.setCatatan(randomStringforCatatan);
		// % protected region % [Add customisation for catatan here] end
		// % protected region % [Add customisation for noKunjungan here] off begin
		String randomStringforNokunjungan = mock
				.strings()
				.get();
		newEntity.setNokunjungan(randomStringforNokunjungan);
		// % protected region % [Add customisation for noKunjungan here] end
		// % protected region % [Add customisation for JsonInsert here] off begin
		String randomStringforJsoninsert = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setJsoninsert(randomStringforJsoninsert);
		// % protected region % [Add customisation for JsonInsert here] end
		// % protected region % [Add customisation for JsonUpdate here] off begin
		String randomStringforJsonupdate = mock
				.strings()
				.size(5000)
				.get();
		newEntity.setJsonupdate(randomStringforJsonupdate);
		// % protected region % [Add customisation for JsonUpdate here] end

		// % protected region % [Apply any additional logic for pcareExaminationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationWithNoRef after the main body here] end

		log.trace("Created entity of type PcareExaminationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of PCare Examination entities with no reference at all.
	 */
	@Provides
	@Named("pcareExaminationEntitiesWithNoRef")
	public Collection<PcareExaminationEntity> pcareExaminationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for pcareExaminationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareExaminationEntitiesWithNoRef here] end
		PcareExaminationEntityFactory pcareExaminationEntityFactory
	) {
		log.trace("Creating entities of type PcareExaminationEntity with no reference");

		// % protected region % [Apply any additional logic for pcareExaminationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationEntitiesWithNoRef before the main body here] end

		Collection<PcareExaminationEntity> newEntities = pcareExaminationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for pcareExaminationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type PcareExaminationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a PCare Examination entity with all references set.
	 */
	@Provides
	@Named("pcareExaminationEntityWithRefs")
	public PcareExaminationEntity pcareExaminationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for pcareExaminationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for pcareExaminationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type PcareExaminationEntity with references");

		// % protected region % [Apply any additional logic for pcareExaminationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationEntityWithRefs before the main body here] end

		PcareExaminationEntity pcareExaminationEntity = injector.getInstance(Key.get(PcareExaminationEntity.class, Names.named("pcareExaminationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for pcareExaminationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationEntityWithRefs after the main body here] end

		log.trace("Created entity of type PcareExaminationEntity with references");

		return pcareExaminationEntity;
	}

	/**
	 * Return a collection of PCare Examination entities with all references set.
	 */
	@Provides
	@Named("pcareExaminationEntitiesWithRefs")
	public Collection<PcareExaminationEntity> pcareExaminationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for pcareExaminationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for pcareExaminationEntitiesWithRefs here] end
		PcareExaminationEntityFactory pcareExaminationEntityFactory
	) {
		log.trace("Creating entities of type PcareExaminationEntity with references");

		// % protected region % [Apply any additional logic for pcareExaminationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationEntitiesWithRefs before the main body here] end

		Collection<PcareExaminationEntity> newEntities = pcareExaminationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for pcareExaminationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for pcareExaminationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type PcareExaminationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
