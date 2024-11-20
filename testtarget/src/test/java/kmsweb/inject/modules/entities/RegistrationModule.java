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
 * Guice module for Registration used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class RegistrationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring RegistrationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured RegistrationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public RegistrationEntityFactory registrationEntityFactory(
			// % protected region % [Apply any additional injected arguments for registrationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for registrationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating RegistrationEntityFactory");

		// % protected region % [Apply any additional logic for registrationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for registrationEntityFactory before the main body here] end

		RegistrationEntityFactory entityFactory = new RegistrationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for RegistrationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for RegistrationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for registrationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for registrationEntityFactory after the main body here] end

		log.trace("Created RegistrationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Registration entity with no references set.
	 */
	@Provides
	@Named("registrationEntityWithNoRef")
	public RegistrationEntity registrationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for registrationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for registrationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type RegistrationEntity with no reference");

		// % protected region % [Apply any additional logic for registrationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for registrationWithNoRef before the main body here] end

		RegistrationEntity newEntity = new RegistrationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Registration Number here] off begin
		String randomStringforRegistrationNumber = mock
				.strings()
				.get();
		newEntity.setRegistrationNumber(randomStringforRegistrationNumber);
		// % protected region % [Add customisation for Registration Number here] end
		// % protected region % [Add customisation for Scheduled Date here] off begin
		newEntity.setScheduledDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Scheduled Date here] end
		// % protected region % [Add customisation for Actual In Date here] off begin
		newEntity.setActualInDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Actual In Date here] end
		// % protected region % [Add customisation for Dismissal Date here] off begin
		newEntity.setDismissalDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Dismissal Date here] end
		// % protected region % [Add customisation for Dismissal Type here] off begin
		String randomStringforDismissalType = mock
				.strings()
				.get();
		newEntity.setDismissalType(randomStringforDismissalType);
		// % protected region % [Add customisation for Dismissal Type here] end
		// % protected region % [Add customisation for Queue No here] off begin
		newEntity.setQueueNo(mock.ints().get());
		// % protected region % [Add customisation for Queue No here] end
		// % protected region % [Add customisation for Duration here] off begin
		newEntity.setDuration(mock.ints().get());
		// % protected region % [Add customisation for Duration here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringforTreatmentClass = mock
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringforTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Booked Treatment Class here] off begin
		String randomStringforBookedTreatmentClass = mock
				.strings()
				.get();
		newEntity.setBookedTreatmentClass(randomStringforBookedTreatmentClass);
		// % protected region % [Add customisation for Booked Treatment Class here] end
		// % protected region % [Add customisation for Shift here] off begin
		String randomStringforShift = mock
				.strings()
				.get();
		newEntity.setShift(randomStringforShift);
		// % protected region % [Add customisation for Shift here] end
		// % protected region % [Add customisation for CITO here] off begin
		newEntity.setCito(mock.bools().get());
		// % protected region % [Add customisation for CITO here] end
		// % protected region % [Add customisation for One Day Care here] off begin
		newEntity.setOneDayCare(mock.bools().get());
		// % protected region % [Add customisation for One Day Care here] end
		// % protected region % [Add customisation for Referral here] off begin
		newEntity.setReferral(mock.bools().get());
		// % protected region % [Add customisation for Referral here] end
		// % protected region % [Add customisation for Registration Status here] off begin
		String randomStringforRegistrationStatus = mock
				.strings()
				.get();
		newEntity.setRegistrationStatus(randomStringforRegistrationStatus);
		// % protected region % [Add customisation for Registration Status here] end
		// % protected region % [Add customisation for Referral Type here] off begin
		String randomStringforReferralType = mock
				.strings()
				.get();
		newEntity.setReferralType(randomStringforReferralType);
		// % protected region % [Add customisation for Referral Type here] end
		// % protected region % [Add customisation for Purpose here] off begin
		String randomStringforPurpose = mock
				.strings()
				.get();
		newEntity.setPurpose(randomStringforPurpose);
		// % protected region % [Add customisation for Purpose here] end
		// % protected region % [Add customisation for Referral Notes here] off begin
		String randomStringforReferralNotes = mock
				.strings()
				.get();
		newEntity.setReferralNotes(randomStringforReferralNotes);
		// % protected region % [Add customisation for Referral Notes here] end
		// % protected region % [Add customisation for Supporting Document here] off begin
		// % protected region % [Add customisation for Supporting Document here] end
		// % protected region % [Add customisation for Admission Diagnosis here] off begin
		String randomStringforAdmissionDiagnosis = mock
				.strings()
				.get();
		newEntity.setAdmissionDiagnosis(randomStringforAdmissionDiagnosis);
		// % protected region % [Add customisation for Admission Diagnosis here] end
		// % protected region % [Add customisation for Print Wristband here] off begin
		// % protected region % [Add customisation for Print Wristband here] end
		// % protected region % [Add customisation for Print Label here] off begin
		// % protected region % [Add customisation for Print Label here] end
		// % protected region % [Add customisation for Uploaded Date Time here] off begin
		newEntity.setUploadedDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Uploaded Date Time here] end
		// % protected region % [Add customisation for Visit Status here] off begin
		String randomStringforVisitStatus = mock
				.strings()
				.get();
		newEntity.setVisitStatus(randomStringforVisitStatus);
		// % protected region % [Add customisation for Visit Status here] end
		// % protected region % [Add customisation for Instruction here] off begin
		String randomStringforInstruction = mock
				.strings()
				.get();
		newEntity.setInstruction(randomStringforInstruction);
		// % protected region % [Add customisation for Instruction here] end
		// % protected region % [Add customisation for is An Appointment here] off begin
		newEntity.setIsAnAppointment(mock.bools().get());
		// % protected region % [Add customisation for is An Appointment here] end
		// % protected region % [Add customisation for Referral Number here] off begin
		String randomStringforReferralNumber = mock
				.strings()
				.get();
		newEntity.setReferralNumber(randomStringforReferralNumber);
		// % protected region % [Add customisation for Referral Number here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringforNotes = mock
				.strings()
				.get();
		newEntity.setNotes(randomStringforNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for kodepoli here] off begin
		String randomStringforKodepoli = mock
				.strings()
				.get();
		newEntity.setKodepoli(randomStringforKodepoli);
		// % protected region % [Add customisation for kodepoli here] end
		// % protected region % [Add customisation for Death Certificate No here] off begin
		String randomStringforDeathCertificateNo = mock
				.strings()
				.get();
		newEntity.setDeathCertificateNo(randomStringforDeathCertificateNo);
		// % protected region % [Add customisation for Death Certificate No here] end
		// % protected region % [Add customisation for Time Of Death here] off begin
		newEntity.setTimeOfDeath(OffsetDateTime.now());
		// % protected region % [Add customisation for Time Of Death here] end
		// % protected region % [Add customisation for Dismissal Referral here] off begin
		newEntity.setDismissalReferral(mock.bools().get());
		// % protected region % [Add customisation for Dismissal Referral here] end
		// % protected region % [Add customisation for Dismissal Referral Detail here] off begin
		String randomStringforDismissalReferralDetail = mock
				.strings()
				.get();
		newEntity.setDismissalReferralDetail(randomStringforDismissalReferralDetail);
		// % protected region % [Add customisation for Dismissal Referral Detail here] end
		// % protected region % [Add customisation for Dismissal Referral Type here] off begin
		String randomStringforDismissalReferralType = mock
				.strings()
				.get();
		newEntity.setDismissalReferralType(randomStringforDismissalReferralType);
		// % protected region % [Add customisation for Dismissal Referral Type here] end
		// % protected region % [Add customisation for Dismissal Referring Notes here] off begin
		String randomStringforDismissalReferringNotes = mock
				.strings()
				.get();
		newEntity.setDismissalReferringNotes(randomStringforDismissalReferringNotes);
		// % protected region % [Add customisation for Dismissal Referring Notes here] end
		// % protected region % [Add customisation for Patient Is Referred Back here] off begin
		newEntity.setPatientIsReferredBack(mock.bools().get());
		// % protected region % [Add customisation for Patient Is Referred Back here] end
		// % protected region % [Add customisation for MCU Package here] off begin
		String randomStringforMcuPackage = mock
				.strings()
				.get();
		newEntity.setMcuPackage(randomStringforMcuPackage);
		// % protected region % [Add customisation for MCU Package here] end
		// % protected region % [Add customisation for Parent Registration Number here] off begin
		String randomStringforParentRegistrationNumber = mock
				.strings()
				.get();
		newEntity.setParentRegistrationNumber(randomStringforParentRegistrationNumber);
		// % protected region % [Add customisation for Parent Registration Number here] end
		// % protected region % [Add customisation for Is Unknown Patient here] off begin
		newEntity.setIsUnknownPatient(mock.bools().get());
		// % protected region % [Add customisation for Is Unknown Patient here] end
		// % protected region % [Add customisation for Other Referred Facility here] off begin
		String randomStringforOtherReferredFacility = mock
				.strings()
				.get();
		newEntity.setOtherReferredFacility(randomStringforOtherReferredFacility);
		// % protected region % [Add customisation for Other Referred Facility here] end
		// % protected region % [Add customisation for Other Referred Staff here] off begin
		String randomStringforOtherReferredStaff = mock
				.strings()
				.get();
		newEntity.setOtherReferredStaff(randomStringforOtherReferredStaff);
		// % protected region % [Add customisation for Other Referred Staff here] end
		// % protected region % [Add customisation for Doctor Schedule Detail Id here] off begin
		String randomStringforDoctorScheduleDetailId = mock
				.strings()
				.get();
		newEntity.setDoctorScheduleDetailId(randomStringforDoctorScheduleDetailId);
		// % protected region % [Add customisation for Doctor Schedule Detail Id here] end

		// % protected region % [Apply any additional logic for registrationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for registrationWithNoRef after the main body here] end

		log.trace("Created entity of type RegistrationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Registration entities with no reference at all.
	 */
	@Provides
	@Named("registrationEntitiesWithNoRef")
	public Collection<RegistrationEntity> registrationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for registrationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for registrationEntitiesWithNoRef here] end
		RegistrationEntityFactory registrationEntityFactory
	) {
		log.trace("Creating entities of type RegistrationEntity with no reference");

		// % protected region % [Apply any additional logic for registrationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for registrationEntitiesWithNoRef before the main body here] end

		Collection<RegistrationEntity> newEntities = registrationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for registrationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for registrationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type RegistrationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Registration entity with all references set.
	 */
	@Provides
	@Named("registrationEntityWithRefs")
	public RegistrationEntity registrationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for registrationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for registrationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type RegistrationEntity with references");

		// % protected region % [Apply any additional logic for registrationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for registrationEntityWithRefs before the main body here] end

		RegistrationEntity registrationEntity = injector.getInstance(Key.get(RegistrationEntity.class, Names.named("registrationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for registrationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for registrationEntityWithRefs after the main body here] end

		log.trace("Created entity of type RegistrationEntity with references");

		return registrationEntity;
	}

	/**
	 * Return a collection of Registration entities with all references set.
	 */
	@Provides
	@Named("registrationEntitiesWithRefs")
	public Collection<RegistrationEntity> registrationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for registrationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for registrationEntitiesWithRefs here] end
		RegistrationEntityFactory registrationEntityFactory
	) {
		log.trace("Creating entities of type RegistrationEntity with references");

		// % protected region % [Apply any additional logic for registrationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for registrationEntitiesWithRefs before the main body here] end

		Collection<RegistrationEntity> newEntities = registrationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for registrationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for registrationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type RegistrationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
