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
 * Guice module for NHIS Claim used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class NhisClaimModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring NhisClaimModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured NhisClaimModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public NhisClaimEntityFactory nhisClaimEntityFactory(
			// % protected region % [Apply any additional injected arguments for nhisClaimEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for nhisClaimEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating NhisClaimEntityFactory");

		// % protected region % [Apply any additional logic for nhisClaimEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimEntityFactory before the main body here] end

		NhisClaimEntityFactory entityFactory = new NhisClaimEntityFactory(
				// % protected region % [Apply any additional constructor arguments for NhisClaimEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for NhisClaimEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for nhisClaimEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimEntityFactory after the main body here] end

		log.trace("Created NhisClaimEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty NHIS Claim entity with no references set.
	 */
	@Provides
	@Named("nhisClaimEntityWithNoRef")
	public NhisClaimEntity nhisClaimEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for nhisClaimEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisClaimEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type NhisClaimEntity with no reference");

		// % protected region % [Apply any additional logic for nhisClaimWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimWithNoRef before the main body here] end

		NhisClaimEntity newEntity = new NhisClaimEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for System Claim ID here] off begin
		String randomStringforSystemClaimID = mock
				.strings()
				.get();
		newEntity.setSystemClaimID(randomStringforSystemClaimID);
		// % protected region % [Add customisation for System Claim ID here] end
		// % protected region % [Add customisation for Ref Invoice No here] off begin
		String randomStringforRefInvoiceNo = mock
				.strings()
				.get();
		newEntity.setRefInvoiceNo(randomStringforRefInvoiceNo);
		// % protected region % [Add customisation for Ref Invoice No here] end
		// % protected region % [Add customisation for Form No here] off begin
		String randomStringforFormNo = mock
				.strings()
				.get();
		newEntity.setFormNo(randomStringforFormNo);
		// % protected region % [Add customisation for Form No here] end
		// % protected region % [Add customisation for Claim ID here] off begin
		String randomStringforClaimID = mock
				.strings()
				.get();
		newEntity.setClaimID(randomStringforClaimID);
		// % protected region % [Add customisation for Claim ID here] end
		// % protected region % [Add customisation for Claim Check Code here] off begin
		String randomStringforClaimCheckCode = mock
				.strings()
				.get();
		newEntity.setClaimCheckCode(randomStringforClaimCheckCode);
		// % protected region % [Add customisation for Claim Check Code here] end
		// % protected region % [Add customisation for Batch Number here] off begin
		String randomStringforBatchNumber = mock
				.strings()
				.get();
		newEntity.setBatchNumber(randomStringforBatchNumber);
		// % protected region % [Add customisation for Batch Number here] end
		// % protected region % [Add customisation for Surname here] off begin
		String randomStringforSurname = mock
				.strings()
				.get();
		newEntity.setSurname(randomStringforSurname);
		// % protected region % [Add customisation for Surname here] end
		// % protected region % [Add customisation for Other Names here] off begin
		String randomStringforOtherNames = mock
				.strings()
				.get();
		newEntity.setOtherNames(randomStringforOtherNames);
		// % protected region % [Add customisation for Other Names here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringforGender = mock
				.strings()
				.get();
		newEntity.setGender(randomStringforGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Date Of Birth here] off begin
		newEntity.setDateOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date Of Birth here] end
		// % protected region % [Add customisation for Member No here] off begin
		String randomStringforMemberNo = mock
				.strings()
				.get();
		newEntity.setMemberNo(randomStringforMemberNo);
		// % protected region % [Add customisation for Member No here] end
		// % protected region % [Add customisation for Hospital Record No here] off begin
		String randomStringforHospitalRecordNo = mock
				.strings()
				.get();
		newEntity.setHospitalRecordNo(randomStringforHospitalRecordNo);
		// % protected region % [Add customisation for Hospital Record No here] end
		// % protected region % [Add customisation for Card Serial Number here] off begin
		String randomStringforCardSerialNumber = mock
				.strings()
				.get();
		newEntity.setCardSerialNumber(randomStringforCardSerialNumber);
		// % protected region % [Add customisation for Card Serial Number here] end
		// % protected region % [Add customisation for Dependant here] off begin
		newEntity.setDependant(mock.bools().get());
		// % protected region % [Add customisation for Dependant here] end
		// % protected region % [Add customisation for Unbundled here] off begin
		newEntity.setUnbundled(mock.bools().get());
		// % protected region % [Add customisation for Unbundled here] end
		// % protected region % [Add customisation for Includes Pharmacy here] off begin
		newEntity.setIncludesPharmacy(mock.bools().get());
		// % protected region % [Add customisation for Includes Pharmacy here] end
		// % protected region % [Add customisation for Type Of Attendance here] off begin
		String randomStringforTypeOfAttendance = mock
				.strings()
				.get();
		newEntity.setTypeOfAttendance(randomStringforTypeOfAttendance);
		// % protected region % [Add customisation for Type Of Attendance here] end
		// % protected region % [Add customisation for First Visit Admission here] off begin
		newEntity.setFirstVisitAdmission(OffsetDateTime.now());
		// % protected region % [Add customisation for First Visit Admission here] end
		// % protected region % [Add customisation for Second Visit Discharge here] off begin
		newEntity.setSecondVisitDischarge(OffsetDateTime.now());
		// % protected region % [Add customisation for Second Visit Discharge here] end
		// % protected region % [Add customisation for Third Visit here] off begin
		newEntity.setThirdVisit(OffsetDateTime.now());
		// % protected region % [Add customisation for Third Visit here] end
		// % protected region % [Add customisation for Fourth Visit here] off begin
		newEntity.setFourthVisit(OffsetDateTime.now());
		// % protected region % [Add customisation for Fourth Visit here] end
		// % protected region % [Add customisation for Physician Name here] off begin
		String randomStringforPhysicianName = mock
				.strings()
				.get();
		newEntity.setPhysicianName(randomStringforPhysicianName);
		// % protected region % [Add customisation for Physician Name here] end
		// % protected region % [Add customisation for Physician Code here] off begin
		String randomStringforPhysicianCode = mock
				.strings()
				.get();
		newEntity.setPhysicianCode(randomStringforPhysicianCode);
		// % protected region % [Add customisation for Physician Code here] end

		// % protected region % [Apply any additional logic for nhisClaimWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimWithNoRef after the main body here] end

		log.trace("Created entity of type NhisClaimEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of NHIS Claim entities with no reference at all.
	 */
	@Provides
	@Named("nhisClaimEntitiesWithNoRef")
	public Collection<NhisClaimEntity> nhisClaimEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for nhisClaimEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisClaimEntitiesWithNoRef here] end
		NhisClaimEntityFactory nhisClaimEntityFactory
	) {
		log.trace("Creating entities of type NhisClaimEntity with no reference");

		// % protected region % [Apply any additional logic for nhisClaimEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimEntitiesWithNoRef before the main body here] end

		Collection<NhisClaimEntity> newEntities = nhisClaimEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for nhisClaimEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type NhisClaimEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a NHIS Claim entity with all references set.
	 */
	@Provides
	@Named("nhisClaimEntityWithRefs")
	public NhisClaimEntity nhisClaimEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for nhisClaimEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for nhisClaimEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type NhisClaimEntity with references");

		// % protected region % [Apply any additional logic for nhisClaimEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimEntityWithRefs before the main body here] end

		NhisClaimEntity nhisClaimEntity = injector.getInstance(Key.get(NhisClaimEntity.class, Names.named("nhisClaimEntityWithNoRef")));

		// % protected region % [Apply any additional logic for nhisClaimEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimEntityWithRefs after the main body here] end

		log.trace("Created entity of type NhisClaimEntity with references");

		return nhisClaimEntity;
	}

	/**
	 * Return a collection of NHIS Claim entities with all references set.
	 */
	@Provides
	@Named("nhisClaimEntitiesWithRefs")
	public Collection<NhisClaimEntity> nhisClaimEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for nhisClaimEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for nhisClaimEntitiesWithRefs here] end
		NhisClaimEntityFactory nhisClaimEntityFactory
	) {
		log.trace("Creating entities of type NhisClaimEntity with references");

		// % protected region % [Apply any additional logic for nhisClaimEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimEntitiesWithRefs before the main body here] end

		Collection<NhisClaimEntity> newEntities = nhisClaimEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for nhisClaimEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for nhisClaimEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type NhisClaimEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
