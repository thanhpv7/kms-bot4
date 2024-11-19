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
 * Guice module for Hospital Branch Information used to register providers for dependency injection.
 */
@Slf4j
@AllArgsConstructor
public class HospitalBranchInformationModule extends AbstractModule {
	// % protected region % [Apply any additional class fields here] off begin
	// % protected region % [Apply any additional class fields here] end

	@Override
	protected void configure() {
		log.trace("Configuring HospitalBranchInformationModule");

		super.configure();

		// % protected region % [Apply any additional configure steps here] off begin
		// % protected region % [Apply any additional configure steps here] end

		log.trace("Configured HospitalBranchInformationModule");
	}

	/**
	 * Return a factory for mass data generation.
	 */
	@Provides
	public HospitalBranchInformationEntityFactory hospitalBranchInformationEntityFactory(
			// % protected region % [Apply any additional injected arguments for hospitalBranchInformationEntityFactory here] off begin
			// % protected region % [Apply any additional injected arguments for hospitalBranchInformationEntityFactory here] end
			Injector injector
	) {
		log.trace("Creating HospitalBranchInformationEntityFactory");

		// % protected region % [Apply any additional logic for hospitalBranchInformationEntityFactory before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationEntityFactory before the main body here] end

		HospitalBranchInformationEntityFactory entityFactory = new HospitalBranchInformationEntityFactory(
				// % protected region % [Apply any additional constructor arguments for HospitalBranchInformationEntityFactory here] off begin
				// % protected region % [Apply any additional constructor arguments for HospitalBranchInformationEntityFactory here] end
				injector
		);

		// % protected region % [Apply any additional logic for hospitalBranchInformationEntityFactory after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationEntityFactory after the main body here] end

		log.trace("Created HospitalBranchInformationEntityFactory");

		return entityFactory;
	}

	/**
	 * Return an empty Hospital Branch Information entity with no references set.
	 */
	@Provides
	@Named("hospitalBranchInformationEntityWithNoRef")
	public HospitalBranchInformationEntity hospitalBranchInformationEntityWithNoRef(
			// % protected region % [Apply any additional constructor parameters for hospitalBranchInformationEntityWithNoRef here] off begin
			// % protected region % [Apply any additional constructor parameters for hospitalBranchInformationEntityWithNoRef here] end
			MockNeat mock
	) {
		log.trace("Creating entity of type HospitalBranchInformationEntity with no reference");

		// % protected region % [Apply any additional logic for hospitalBranchInformationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationWithNoRef before the main body here] end

		HospitalBranchInformationEntity newEntity = new HospitalBranchInformationEntity();
		newEntity.setId(UUID.randomUUID());
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Hospital Code here] off begin
		String randomStringforHospitalCode = mock
				.strings()
				.get();
		newEntity.setHospitalCode(randomStringforHospitalCode);
		// % protected region % [Add customisation for Hospital Code here] end
		// % protected region % [Add customisation for Hospital Name here] off begin
		String randomStringforHospitalName = mock
				.strings()
				.get();
		newEntity.setHospitalName(randomStringforHospitalName);
		// % protected region % [Add customisation for Hospital Name here] end
		// % protected region % [Add customisation for Hospital Type here] off begin
		String randomStringforHospitalType = mock
				.strings()
				.get();
		newEntity.setHospitalType(randomStringforHospitalType);
		// % protected region % [Add customisation for Hospital Type here] end
		// % protected region % [Add customisation for Hospital Class here] off begin
		String randomStringforHospitalClass = mock
				.strings()
				.get();
		newEntity.setHospitalClass(randomStringforHospitalClass);
		// % protected region % [Add customisation for Hospital Class here] end
		// % protected region % [Add customisation for Hospital Director Name here] off begin
		String randomStringforHospitalDirectorName = mock
				.strings()
				.get();
		newEntity.setHospitalDirectorName(randomStringforHospitalDirectorName);
		// % protected region % [Add customisation for Hospital Director Name here] end
		// % protected region % [Add customisation for Date of Registration here] off begin
		newEntity.setDateOfRegistration(OffsetDateTime.now());
		// % protected region % [Add customisation for Date of Registration here] end
		// % protected region % [Add customisation for Hospital Corporation Name here] off begin
		String randomStringforHospitalCorporationName = mock
				.strings()
				.get();
		newEntity.setHospitalCorporationName(randomStringforHospitalCorporationName);
		// % protected region % [Add customisation for Hospital Corporation Name here] end
		// % protected region % [Add customisation for Is BPJS Facility here] off begin
		newEntity.setIsBPJSFacility(mock.bools().get());
		// % protected region % [Add customisation for Is BPJS Facility here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringforAddress = mock
				.strings()
				.get();
		newEntity.setAddress(randomStringforAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for City here] off begin
		String randomStringforCity = mock
				.strings()
				.get();
		newEntity.setCity(randomStringforCity);
		// % protected region % [Add customisation for City here] end
		// % protected region % [Add customisation for Postcode here] off begin
		String randomStringforPostcode = mock
				.strings()
				.get();
		newEntity.setPostcode(randomStringforPostcode);
		// % protected region % [Add customisation for Postcode here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringforPhoneNumber = mock
				.strings()
				.get();
		newEntity.setPhoneNumber(randomStringforPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Fax here] off begin
		String randomStringforFax = mock
				.strings()
				.get();
		newEntity.setFax(randomStringforFax);
		// % protected region % [Add customisation for Fax here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringforEmail = mock
				.strings()
				.get();
		newEntity.setEmail(randomStringforEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Website here] off begin
		String randomStringforWebsite = mock
				.strings()
				.get();
		newEntity.setWebsite(randomStringforWebsite);
		// % protected region % [Add customisation for Website here] end
		// % protected region % [Add customisation for Contact Person here] off begin
		String randomStringforContactPerson = mock
				.strings()
				.get();
		newEntity.setContactPerson(randomStringforContactPerson);
		// % protected region % [Add customisation for Contact Person here] end
		// % protected region % [Add customisation for Contact Person Phone Number here] off begin
		String randomStringforContactPersonPhoneNumber = mock
				.strings()
				.get();
		newEntity.setContactPersonPhoneNumber(randomStringforContactPersonPhoneNumber);
		// % protected region % [Add customisation for Contact Person Phone Number here] end
		// % protected region % [Add customisation for Contact Person Email here] off begin
		String randomStringforContactPersonEmail = mock
				.strings()
				.get();
		newEntity.setContactPersonEmail(randomStringforContactPersonEmail);
		// % protected region % [Add customisation for Contact Person Email here] end
		// % protected region % [Add customisation for Land Size here] off begin
		String randomStringforLandSize = mock
				.strings()
				.get();
		newEntity.setLandSize(randomStringforLandSize);
		// % protected region % [Add customisation for Land Size here] end
		// % protected region % [Add customisation for Building Size here] off begin
		String randomStringforBuildingSize = mock
				.strings()
				.get();
		newEntity.setBuildingSize(randomStringforBuildingSize);
		// % protected region % [Add customisation for Building Size here] end
		// % protected region % [Add customisation for Permit Number here] off begin
		String randomStringforPermitNumber = mock
				.strings()
				.get();
		newEntity.setPermitNumber(randomStringforPermitNumber);
		// % protected region % [Add customisation for Permit Number here] end
		// % protected region % [Add customisation for Permit Date here] off begin
		newEntity.setPermitDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Permit Date here] end
		// % protected region % [Add customisation for Authorized By here] off begin
		String randomStringforAuthorizedBy = mock
				.strings()
				.get();
		newEntity.setAuthorizedBy(randomStringforAuthorizedBy);
		// % protected region % [Add customisation for Authorized By here] end
		// % protected region % [Add customisation for Permit Type here] off begin
		String randomStringforPermitType = mock
				.strings()
				.get();
		newEntity.setPermitType(randomStringforPermitType);
		// % protected region % [Add customisation for Permit Type here] end
		// % protected region % [Add customisation for Valid Until here] off begin
		newEntity.setValidUntil(OffsetDateTime.now());
		// % protected region % [Add customisation for Valid Until here] end
		// % protected region % [Add customisation for Hospital Branch Corporation Name here] off begin
		String randomStringforHospitalBranchCorporationName = mock
				.strings()
				.get();
		newEntity.setHospitalBranchCorporationName(randomStringforHospitalBranchCorporationName);
		// % protected region % [Add customisation for Hospital Branch Corporation Name here] end
		// % protected region % [Add customisation for Hospital Branch Corporation Status here] off begin
		String randomStringforHospitalBranchCorporationStatus = mock
				.strings()
				.get();
		newEntity.setHospitalBranchCorporationStatus(randomStringforHospitalBranchCorporationStatus);
		// % protected region % [Add customisation for Hospital Branch Corporation Status here] end
		// % protected region % [Add customisation for Accreditation Type here] off begin
		String randomStringforAccreditationType = mock
				.strings()
				.get();
		newEntity.setAccreditationType(randomStringforAccreditationType);
		// % protected region % [Add customisation for Accreditation Type here] end
		// % protected region % [Add customisation for Accreditation Level here] off begin
		String randomStringforAccreditationLevel = mock
				.strings()
				.get();
		newEntity.setAccreditationLevel(randomStringforAccreditationLevel);
		// % protected region % [Add customisation for Accreditation Level here] end
		// % protected region % [Add customisation for Accreditation Date here] off begin
		newEntity.setAccreditationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Accreditation Date here] end
		// % protected region % [Add customisation for Bed Perinatology here] off begin
		String randomStringforBedPerinatology = mock
				.strings()
				.get();
		newEntity.setBedPerinatology(randomStringforBedPerinatology);
		// % protected region % [Add customisation for Bed Perinatology here] end
		// % protected region % [Add customisation for Suite Class here] off begin
		String randomStringforSuiteClass = mock
				.strings()
				.get();
		newEntity.setSuiteClass(randomStringforSuiteClass);
		// % protected region % [Add customisation for Suite Class here] end
		// % protected region % [Add customisation for VVIP Class here] off begin
		String randomStringforVvipClass = mock
				.strings()
				.get();
		newEntity.setVvipClass(randomStringforVvipClass);
		// % protected region % [Add customisation for VVIP Class here] end
		// % protected region % [Add customisation for VIP A Class here] off begin
		String randomStringforVipAClass = mock
				.strings()
				.get();
		newEntity.setVipAClass(randomStringforVipAClass);
		// % protected region % [Add customisation for VIP A Class here] end
		// % protected region % [Add customisation for VIP B Class here] off begin
		String randomStringforVipBClass = mock
				.strings()
				.get();
		newEntity.setVipBClass(randomStringforVipBClass);
		// % protected region % [Add customisation for VIP B Class here] end
		// % protected region % [Add customisation for VIP C Class here] off begin
		String randomStringforVipCClass = mock
				.strings()
				.get();
		newEntity.setVipCClass(randomStringforVipCClass);
		// % protected region % [Add customisation for VIP C Class here] end
		// % protected region % [Add customisation for Main Class here] off begin
		String randomStringforMainClass = mock
				.strings()
				.get();
		newEntity.setMainClass(randomStringforMainClass);
		// % protected region % [Add customisation for Main Class here] end
		// % protected region % [Add customisation for Class I here] off begin
		String randomStringforClassI = mock
				.strings()
				.get();
		newEntity.setClassI(randomStringforClassI);
		// % protected region % [Add customisation for Class I here] end
		// % protected region % [Add customisation for II Class here] off begin
		String randomStringforIiClass = mock
				.strings()
				.get();
		newEntity.setIiClass(randomStringforIiClass);
		// % protected region % [Add customisation for II Class here] end
		// % protected region % [Add customisation for III A Class here] off begin
		String randomStringforIiiAClass = mock
				.strings()
				.get();
		newEntity.setIiiAClass(randomStringforIiiAClass);
		// % protected region % [Add customisation for III A Class here] end
		// % protected region % [Add customisation for III B Class here] off begin
		String randomStringforIiiBClass = mock
				.strings()
				.get();
		newEntity.setIiiBClass(randomStringforIiiBClass);
		// % protected region % [Add customisation for III B Class here] end
		// % protected region % [Add customisation for Special Class here] off begin
		String randomStringforSpecialClass = mock
				.strings()
				.get();
		newEntity.setSpecialClass(randomStringforSpecialClass);
		// % protected region % [Add customisation for Special Class here] end
		// % protected region % [Add customisation for ICU here] off begin
		String randomStringforIcu = mock
				.strings()
				.get();
		newEntity.setIcu(randomStringforIcu);
		// % protected region % [Add customisation for ICU here] end
		// % protected region % [Add customisation for PICU here] off begin
		String randomStringforPicu = mock
				.strings()
				.get();
		newEntity.setPicu(randomStringforPicu);
		// % protected region % [Add customisation for PICU here] end
		// % protected region % [Add customisation for NICU here] off begin
		String randomStringforNicu = mock
				.strings()
				.get();
		newEntity.setNicu(randomStringforNicu);
		// % protected region % [Add customisation for NICU here] end
		// % protected region % [Add customisation for HCU here] off begin
		String randomStringforHcu = mock
				.strings()
				.get();
		newEntity.setHcu(randomStringforHcu);
		// % protected region % [Add customisation for HCU here] end
		// % protected region % [Add customisation for ICCU here] off begin
		String randomStringforIccu = mock
				.strings()
				.get();
		newEntity.setIccu(randomStringforIccu);
		// % protected region % [Add customisation for ICCU here] end
		// % protected region % [Add customisation for Isolation Room here] off begin
		String randomStringforIsolationRoom = mock
				.strings()
				.get();
		newEntity.setIsolationRoom(randomStringforIsolationRoom);
		// % protected region % [Add customisation for Isolation Room here] end
		// % protected region % [Add customisation for Emergency Room here] off begin
		String randomStringforEmergencyRoom = mock
				.strings()
				.get();
		newEntity.setEmergencyRoom(randomStringforEmergencyRoom);
		// % protected region % [Add customisation for Emergency Room here] end
		// % protected region % [Add customisation for Maternity Room here] off begin
		String randomStringforMaternityRoom = mock
				.strings()
				.get();
		newEntity.setMaternityRoom(randomStringforMaternityRoom);
		// % protected region % [Add customisation for Maternity Room here] end
		// % protected region % [Add customisation for Operating Room here] off begin
		String randomStringforOperatingRoom = mock
				.strings()
				.get();
		newEntity.setOperatingRoom(randomStringforOperatingRoom);
		// % protected region % [Add customisation for Operating Room here] end
		// % protected region % [Add customisation for Doctor SpA here] off begin
		String randomStringforDoctorSpA = mock
				.strings()
				.get();
		newEntity.setDoctorSpA(randomStringforDoctorSpA);
		// % protected region % [Add customisation for Doctor SpA here] end
		// % protected region % [Add customisation for Doctor SpOG here] off begin
		String randomStringforDoctorSpOG = mock
				.strings()
				.get();
		newEntity.setDoctorSpOG(randomStringforDoctorSpOG);
		// % protected region % [Add customisation for Doctor SpOG here] end
		// % protected region % [Add customisation for Doctor SpPD here] off begin
		String randomStringforDoctorSpPD = mock
				.strings()
				.get();
		newEntity.setDoctorSpPD(randomStringforDoctorSpPD);
		// % protected region % [Add customisation for Doctor SpPD here] end
		// % protected region % [Add customisation for Doctor SpB here] off begin
		String randomStringforDoctorSpB = mock
				.strings()
				.get();
		newEntity.setDoctorSpB(randomStringforDoctorSpB);
		// % protected region % [Add customisation for Doctor SpB here] end
		// % protected region % [Add customisation for Doctor SpRad here] off begin
		String randomStringforDoctorSpRad = mock
				.strings()
				.get();
		newEntity.setDoctorSpRad(randomStringforDoctorSpRad);
		// % protected region % [Add customisation for Doctor SpRad here] end
		// % protected region % [Add customisation for Doctor SpRm here] off begin
		String randomStringforDoctorSpRm = mock
				.strings()
				.get();
		newEntity.setDoctorSpRm(randomStringforDoctorSpRm);
		// % protected region % [Add customisation for Doctor SpRm here] end
		// % protected region % [Add customisation for Doctor SpAn here] off begin
		String randomStringforDoctorSpAn = mock
				.strings()
				.get();
		newEntity.setDoctorSpAn(randomStringforDoctorSpAn);
		// % protected region % [Add customisation for Doctor SpAn here] end
		// % protected region % [Add customisation for Doctor SpJp here] off begin
		String randomStringforDoctorSpJp = mock
				.strings()
				.get();
		newEntity.setDoctorSpJp(randomStringforDoctorSpJp);
		// % protected region % [Add customisation for Doctor SpJp here] end
		// % protected region % [Add customisation for Doctor SpM here] off begin
		String randomStringforDoctorSpM = mock
				.strings()
				.get();
		newEntity.setDoctorSpM(randomStringforDoctorSpM);
		// % protected region % [Add customisation for Doctor SpM here] end
		// % protected region % [Add customisation for Doctor SpTHT here] off begin
		String randomStringforDoctorSpTHT = mock
				.strings()
				.get();
		newEntity.setDoctorSpTHT(randomStringforDoctorSpTHT);
		// % protected region % [Add customisation for Doctor SpTHT here] end
		// % protected region % [Add customisation for Doctor SpKj here] off begin
		String randomStringforDoctorSpKj = mock
				.strings()
				.get();
		newEntity.setDoctorSpKj(randomStringforDoctorSpKj);
		// % protected region % [Add customisation for Doctor SpKj here] end
		// % protected region % [Add customisation for Doctor SpP here] off begin
		String randomStringforDoctorSpP = mock
				.strings()
				.get();
		newEntity.setDoctorSpP(randomStringforDoctorSpP);
		// % protected region % [Add customisation for Doctor SpP here] end
		// % protected region % [Add customisation for Doctor SpPK here] off begin
		String randomStringforDoctorSpPK = mock
				.strings()
				.get();
		newEntity.setDoctorSpPK(randomStringforDoctorSpPK);
		// % protected region % [Add customisation for Doctor SpPK here] end
		// % protected region % [Add customisation for Doctor SpS here] off begin
		String randomStringforDoctorSpS = mock
				.strings()
				.get();
		newEntity.setDoctorSpS(randomStringforDoctorSpS);
		// % protected region % [Add customisation for Doctor SpS here] end
		// % protected region % [Add customisation for Sub Specialist Doctor here] off begin
		String randomStringforSubSpecialistDoctor = mock
				.strings()
				.get();
		newEntity.setSubSpecialistDoctor(randomStringforSubSpecialistDoctor);
		// % protected region % [Add customisation for Sub Specialist Doctor here] end
		// % protected region % [Add customisation for Other Specialist Doctor here] off begin
		String randomStringforOtherSpecialistDoctor = mock
				.strings()
				.get();
		newEntity.setOtherSpecialistDoctor(randomStringforOtherSpecialistDoctor);
		// % protected region % [Add customisation for Other Specialist Doctor here] end
		// % protected region % [Add customisation for General Practice here] off begin
		String randomStringforGeneralPractice = mock
				.strings()
				.get();
		newEntity.setGeneralPractice(randomStringforGeneralPractice);
		// % protected region % [Add customisation for General Practice here] end
		// % protected region % [Add customisation for Dentist here] off begin
		String randomStringforDentist = mock
				.strings()
				.get();
		newEntity.setDentist(randomStringforDentist);
		// % protected region % [Add customisation for Dentist here] end
		// % protected region % [Add customisation for Specialist Dentist here] off begin
		String randomStringforSpecialistDentist = mock
				.strings()
				.get();
		newEntity.setSpecialistDentist(randomStringforSpecialistDentist);
		// % protected region % [Add customisation for Specialist Dentist here] end
		// % protected region % [Add customisation for Nurse here] off begin
		String randomStringforNurse = mock
				.strings()
				.get();
		newEntity.setNurse(randomStringforNurse);
		// % protected region % [Add customisation for Nurse here] end
		// % protected region % [Add customisation for Midwife here] off begin
		String randomStringforMidwife = mock
				.strings()
				.get();
		newEntity.setMidwife(randomStringforMidwife);
		// % protected region % [Add customisation for Midwife here] end
		// % protected region % [Add customisation for Pharmacist here] off begin
		String randomStringforPharmacist = mock
				.strings()
				.get();
		newEntity.setPharmacist(randomStringforPharmacist);
		// % protected region % [Add customisation for Pharmacist here] end
		// % protected region % [Add customisation for Other Medical Staff here] off begin
		String randomStringforOtherMedicalStaff = mock
				.strings()
				.get();
		newEntity.setOtherMedicalStaff(randomStringforOtherMedicalStaff);
		// % protected region % [Add customisation for Other Medical Staff here] end
		// % protected region % [Add customisation for Non Medical Staff here] off begin
		String randomStringforNonMedicalStaff = mock
				.strings()
				.get();
		newEntity.setNonMedicalStaff(randomStringforNonMedicalStaff);
		// % protected region % [Add customisation for Non Medical Staff here] end
		// % protected region % [Add customisation for Left Logo here] off begin
		// % protected region % [Add customisation for Left Logo here] end
		// % protected region % [Add customisation for Right Logo here] off begin
		// % protected region % [Add customisation for Right Logo here] end
		// % protected region % [Add customisation for Timezone here] off begin
		String randomStringforTimezone = mock
				.strings()
				.get();
		newEntity.setTimezone(randomStringforTimezone);
		// % protected region % [Add customisation for Timezone here] end
		// % protected region % [Add customisation for Health Facility Level here] off begin
		String randomStringforHealthFacilityLevel = mock
				.strings()
				.get();
		newEntity.setHealthFacilityLevel(randomStringforHealthFacilityLevel);
		// % protected region % [Add customisation for Health Facility Level here] end
		// % protected region % [Add customisation for Satu Sehat Integration here] off begin
		newEntity.setSatuSehatIntegration(mock.bools().get());
		// % protected region % [Add customisation for Satu Sehat Integration here] end
		// % protected region % [Add customisation for Tax Identification here] off begin
		String randomStringforTaxIdentification = mock
				.strings()
				.get();
		newEntity.setTaxIdentification(randomStringforTaxIdentification);
		// % protected region % [Add customisation for Tax Identification here] end

		// % protected region % [Apply any additional logic for hospitalBranchInformationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationWithNoRef after the main body here] end

		log.trace("Created entity of type HospitalBranchInformationEntity with no reference");

		return newEntity;
	}

	/**
	 * Return a collection of Hospital Branch Information entities with no reference at all.
	 */
	@Provides
	@Named("hospitalBranchInformationEntitiesWithNoRef")
	public Collection<HospitalBranchInformationEntity> hospitalBranchInformationEntitiesWithNoRef(
		// % protected region % [Apply any additional constructor parameters for hospitalBranchInformationEntitiesWithNoRef here] off begin
		// % protected region % [Apply any additional constructor parameters for hospitalBranchInformationEntitiesWithNoRef here] end
		HospitalBranchInformationEntityFactory hospitalBranchInformationEntityFactory
	) {
		log.trace("Creating entities of type HospitalBranchInformationEntity with no reference");

		// % protected region % [Apply any additional logic for hospitalBranchInformationEntitiesWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationEntitiesWithNoRef before the main body here] end

		Collection<HospitalBranchInformationEntity> newEntities = hospitalBranchInformationEntityFactory.createMultipleWithNoRef(10);

		// % protected region % [Apply any additional logic for hospitalBranchInformationEntitiesWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationEntitiesWithNoRef after the main body here] end

		log.trace("Created entities of type HospitalBranchInformationEntity with no reference");

		return newEntities;
	}

	/**
	 * Return a Hospital Branch Information entity with all references set.
	 */
	@Provides
	@Named("hospitalBranchInformationEntityWithRefs")
	public HospitalBranchInformationEntity hospitalBranchInformationEntityWithRefs(
			// % protected region % [Apply any additional constructor parameters for hospitalBranchInformationEntityWithRefs here] off begin
			// % protected region % [Apply any additional constructor parameters for hospitalBranchInformationEntityWithRefs here] end
			Injector injector
	) {
		log.trace("Creating entity of type HospitalBranchInformationEntity with references");

		// % protected region % [Apply any additional logic for hospitalBranchInformationEntityWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationEntityWithRefs before the main body here] end

		HospitalBranchInformationEntity hospitalBranchInformationEntity = injector.getInstance(Key.get(HospitalBranchInformationEntity.class, Names.named("hospitalBranchInformationEntityWithNoRef")));

		// % protected region % [Apply any additional logic for hospitalBranchInformationEntityWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationEntityWithRefs after the main body here] end

		log.trace("Created entity of type HospitalBranchInformationEntity with references");

		return hospitalBranchInformationEntity;
	}

	/**
	 * Return a collection of Hospital Branch Information entities with all references set.
	 */
	@Provides
	@Named("hospitalBranchInformationEntitiesWithRefs")
	public Collection<HospitalBranchInformationEntity> hospitalBranchInformationEntitiesWithRefs(
		// % protected region % [Apply any additional constructor parameters for hospitalBranchInformationEntitiesWithRefs here] off begin
		// % protected region % [Apply any additional constructor parameters for hospitalBranchInformationEntitiesWithRefs here] end
		HospitalBranchInformationEntityFactory hospitalBranchInformationEntityFactory
	) {
		log.trace("Creating entities of type HospitalBranchInformationEntity with references");

		// % protected region % [Apply any additional logic for hospitalBranchInformationEntitiesWithRefs before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationEntitiesWithRefs before the main body here] end

		Collection<HospitalBranchInformationEntity> newEntities = hospitalBranchInformationEntityFactory.createMultipleWithRefs(10);

		// % protected region % [Apply any additional logic for hospitalBranchInformationEntitiesWithRefs after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationEntitiesWithRefs after the main body here] end

		log.trace("Created entities of type HospitalBranchInformationEntity with references");

		return newEntities;
	}

	// % protected region % [Apply any additional class methods here] off begin
	// % protected region % [Apply any additional class methods here] end
}
