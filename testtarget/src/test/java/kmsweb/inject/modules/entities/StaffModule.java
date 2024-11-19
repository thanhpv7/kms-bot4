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
 * Guice module for Staff used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class StaffModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring StaffModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured StaffModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public StaffEntityFactory staffEntityFactory(
			// % protected region % [Apply any additional injected arguments for staffEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for staffEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating StaffEntityFactory");

		// % protected region % [Apply any additional logic for staffEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for staffEntityFactory before the main body here] end

		StaffEntityFactory entityFactory = new StaffEntityFactory(
				// % protected region % [Apply any additional constructor arguments for StaffEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for StaffEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for staffEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for staffEntityFactory after the main body here] end

		log.trace("Created StaffEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Staff entity with no references set.
	 */
	@Provides
	@Named("staffEntityWithNoRef")
	public StaffEntity staffEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for staffEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for staffEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type StaffEntity with no reference");

		// % protected region % [Apply any additional logic for staffWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for staffWithNoRef before the main body here] end

		StaffEntity newEntity = new StaffEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Staff Number here] off begin
		String randomStringforStaffNumber = mock
				.strings()
				.get();
		newEntity.setStaffNumber(randomStringforStaffNumber);
		// % protected region % [Add customisation for Staff Number here] end
		// % protected region % [Add customisation for First Name here] off begin
		String randomStringforFirstName = mock
				.strings()
				.get();
		newEntity.setFirstName(randomStringforFirstName);
		// % protected region % [Add customisation for First Name here] end
		// % protected region % [Add customisation for Last Name here] off begin
		String randomStringforLastName = mock
				.strings()
				.get();
		newEntity.setLastName(randomStringforLastName);
		// % protected region % [Add customisation for Last Name here] end
		// % protected region % [Add customisation for Date of Birth here] off begin
		newEntity.setDateOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date of Birth here] end
		// % protected region % [Add customisation for Staff Type here] off begin
		String randomStringforStaffType = mock
				.strings()
				.get();
		newEntity.setStaffType(randomStringforStaffType);
		// % protected region % [Add customisation for Staff Type here] end
		// % protected region % [Add customisation for Specialization here] off begin
		String randomStringforSpecialization = mock
				.strings()
				.get();
		newEntity.setSpecialization(randomStringforSpecialization);
		// % protected region % [Add customisation for Specialization here] end
		// % protected region % [Add customisation for Staff Picture here] off begin
		// % protected region % [Add customisation for Staff Picture here] end
		// % protected region % [Add customisation for Education here] off begin
		String randomStringforEducation = mock
				.strings()
				.get();
		newEntity.setEducation(randomStringforEducation);
		// % protected region % [Add customisation for Education here] end
		// % protected region % [Add customisation for License No here] off begin
		String randomStringforLicenseNo = mock
				.strings()
				.get();
		newEntity.setLicenseNo(randomStringforLicenseNo);
		// % protected region % [Add customisation for License No here] end
		// % protected region % [Add customisation for Letter of Reg here] off begin
		String randomStringforLetterOfReg = mock
				.strings()
				.get();
		newEntity.setLetterOfReg(randomStringforLetterOfReg);
		// % protected region % [Add customisation for Letter of Reg here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringforGender = mock
				.strings()
				.get();
		newEntity.setGender(randomStringforGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Employee ID here] off begin
		String randomStringforEmployeeID = mock
				.strings()
				.get();
		newEntity.setEmployeeID(randomStringforEmployeeID);
		// % protected region % [Add customisation for Employee ID here] end
		// % protected region % [Add customisation for Title here] off begin
		String randomStringforTitle = mock
				.strings()
				.get();
		newEntity.setTitle(randomStringforTitle);
		// % protected region % [Add customisation for Title here] end
		// % protected region % [Add customisation for Default Service Number here] off begin
		String randomStringforDefaultServiceNumber = mock
				.strings()
				.get();
		newEntity.setDefaultServiceNumber(randomStringforDefaultServiceNumber);
		// % protected region % [Add customisation for Default Service Number here] end
		// % protected region % [Add customisation for Place of birth here] off begin
		String randomStringforPlaceOfBirth = mock
				.strings()
				.get();
		newEntity.setPlaceOfBirth(randomStringforPlaceOfBirth);
		// % protected region % [Add customisation for Place of birth here] end
		// % protected region % [Add customisation for Religion here] off begin
		String randomStringforReligion = mock
				.strings()
				.get();
		newEntity.setReligion(randomStringforReligion);
		// % protected region % [Add customisation for Religion here] end
		// % protected region % [Add customisation for Blood Type here] off begin
		newEntity.setBloodType(BloodTypeEnum.A);
		// % protected region % [Add customisation for Blood Type here] end
		// % protected region % [Add customisation for Rhesus here] off begin
		newEntity.setRhesus(RhesusEnum.POSITIVE);
		// % protected region % [Add customisation for Rhesus here] end
		// % protected region % [Add customisation for address here] off begin
		String randomStringforAddress = mock
				.strings()
				.get();
		newEntity.setAddress(randomStringforAddress);
		// % protected region % [Add customisation for address here] end
		// % protected region % [Add customisation for Country here] off begin
		String randomStringforCountry = mock
				.strings()
				.get();
		newEntity.setCountry(randomStringforCountry);
		// % protected region % [Add customisation for Country here] end
		// % protected region % [Add customisation for State here] off begin
		String randomStringforState = mock
				.strings()
				.get();
		newEntity.setState(randomStringforState);
		// % protected region % [Add customisation for State here] end
		// % protected region % [Add customisation for Regency here] off begin
		String randomStringforRegency = mock
				.strings()
				.get();
		newEntity.setRegency(randomStringforRegency);
		// % protected region % [Add customisation for Regency here] end
		// % protected region % [Add customisation for District here] off begin
		String randomStringforDistrict = mock
				.strings()
				.get();
		newEntity.setDistrict(randomStringforDistrict);
		// % protected region % [Add customisation for District here] end
		// % protected region % [Add customisation for Home phone no here] off begin
		String randomStringforHomePhoneNo = mock
				.strings()
				.get();
		newEntity.setHomePhoneNo(randomStringforHomePhoneNo);
		// % protected region % [Add customisation for Home phone no here] end
		// % protected region % [Add customisation for Village here] off begin
		String randomStringforVillage = mock
				.strings()
				.get();
		newEntity.setVillage(randomStringforVillage);
		// % protected region % [Add customisation for Village here] end
		// % protected region % [Add customisation for Postcode here] off begin
		String randomStringforPostcode = mock
				.strings()
				.get();
		newEntity.setPostcode(randomStringforPostcode);
		// % protected region % [Add customisation for Postcode here] end
		// % protected region % [Add customisation for Office Phone Number here] off begin
		String randomStringforOfficePhoneNumber = mock
				.strings()
				.get();
		newEntity.setOfficePhoneNumber(randomStringforOfficePhoneNumber);
		// % protected region % [Add customisation for Office Phone Number here] end
		// % protected region % [Add customisation for Tax Identification No here] off begin
		String randomStringforTaxIdentificationNo = mock
				.strings()
				.get();
		newEntity.setTaxIdentificationNo(randomStringforTaxIdentificationNo);
		// % protected region % [Add customisation for Tax Identification No here] end
		// % protected region % [Add customisation for Mobile Phone No here] off begin
		String randomStringforMobilePhoneNo = mock
				.strings()
				.get();
		newEntity.setMobilePhoneNo(randomStringforMobilePhoneNo);
		// % protected region % [Add customisation for Mobile Phone No here] end
		// % protected region % [Add customisation for Other Notes here] off begin
		String randomStringforOtherNotes = mock
				.strings()
				.get();
		newEntity.setOtherNotes(randomStringforOtherNotes);
		// % protected region % [Add customisation for Other Notes here] end
		// % protected region % [Add customisation for Training here] off begin
		String randomStringforTraining = mock
				.strings()
				.get();
		newEntity.setTraining(randomStringforTraining);
		// % protected region % [Add customisation for Training here] end
		// % protected region % [Add customisation for Nationality here] off begin
		String randomStringforNationality = mock
				.strings()
				.get();
		newEntity.setNationality(randomStringforNationality);
		// % protected region % [Add customisation for Nationality here] end
		// % protected region % [Add customisation for Certification here] off begin
		String randomStringforCertification = mock
				.strings()
				.get();
		newEntity.setCertification(randomStringforCertification);
		// % protected region % [Add customisation for Certification here] end
		// % protected region % [Add customisation for Ext No here] off begin
		String randomStringforExtNo = mock
				.strings()
				.get();
		newEntity.setExtNo(randomStringforExtNo);
		// % protected region % [Add customisation for Ext No here] end
		// % protected region % [Add customisation for Marital Status here] off begin
		String randomStringforMaritalStatus = mock
				.strings()
				.get();
		newEntity.setMaritalStatus(randomStringforMaritalStatus);
		// % protected region % [Add customisation for Marital Status here] end
		// % protected region % [Add customisation for email here] off begin
		String randomStringforEmail = mock
				.strings()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for email here] end

		// % protected region % [Apply any additional logic for staffWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for staffWithNoRef after the main body here] end

		log.trace("Created entity of type StaffEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Staff entities with no reference at all.
	 */
	@Provides
	@Named("staffEntitiesWithNoRef")
	public Collection<StaffEntity> staffEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for staffEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for staffEntitiesWithNoRef here] end
		StaffEntityFactory staffEntityFactory
	) {
		log.trace("Creating entities of type StaffEntity with no reference");

		// % protected region % [Apply any additional logic for staffEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for staffEntitiesWithNoRef before the main body here] end

		Collection<StaffEntity> newEntities = staffEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for staffEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for staffEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type StaffEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Staff entity with all references set.
	 */
	@Provides
	@Named("staffEntityWithRefs")
	public StaffEntity staffEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for staffEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for staffEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type StaffEntity with references");

		// % protected region % [Apply any additional logic for staffEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for staffEntityWithRefs before the main body here] end

		StaffEntity staffEntity = injector.getInstance(Key.get(StaffEntity.class, Names.named("staffEntityWithNoRef")));

		// % protected region % [Apply any additional logic for staffEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for staffEntityWithRefs after the main body here] end

		log.trace("Created entity of type StaffEntity with references");

		return staffEntity;
	}

	/**
	 * Return a collection of Staff entities with all references set.
	 */
	@Provides
	@Named("staffEntitiesWithRefs")
	public Collection<StaffEntity> staffEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for staffEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for staffEntitiesWithRefs here] end
		StaffEntityFactory staffEntityFactory
	) {
		log.trace("Creating entities of type StaffEntity with references");

		// % protected region % [Apply any additional logic for staffEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for staffEntitiesWithRefs before the main body here] end

		Collection<StaffEntity> newEntities = staffEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for staffEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for staffEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type StaffEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
