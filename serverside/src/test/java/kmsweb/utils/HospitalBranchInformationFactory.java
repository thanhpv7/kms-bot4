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
import kmsweb.entities.HospitalBranchInformationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class HospitalBranchInformationFactory implements FactoryBean<HospitalBranchInformationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public HospitalBranchInformationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public HospitalBranchInformationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public HospitalBranchInformationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for hospitalBranchInformationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationWithNoRef before the main body here] end

		HospitalBranchInformationEntity newEntity = new HospitalBranchInformationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Hospital Code here] off begin
		String randomStringForHospitalCode = mockNeat
				.strings()
				.get();
		newEntity.setHospitalCode(randomStringForHospitalCode);
		// % protected region % [Add customisation for Hospital Code here] end
		// % protected region % [Add customisation for Hospital Name here] off begin
		String randomStringForHospitalName = mockNeat
				.strings()
				.get();
		newEntity.setHospitalName(randomStringForHospitalName);
		// % protected region % [Add customisation for Hospital Name here] end
		// % protected region % [Add customisation for Hospital Type here] off begin
		String randomStringForHospitalType = mockNeat
				.strings()
				.get();
		newEntity.setHospitalType(randomStringForHospitalType);
		// % protected region % [Add customisation for Hospital Type here] end
		// % protected region % [Add customisation for Hospital Class here] off begin
		String randomStringForHospitalClass = mockNeat
				.strings()
				.get();
		newEntity.setHospitalClass(randomStringForHospitalClass);
		// % protected region % [Add customisation for Hospital Class here] end
		// % protected region % [Add customisation for Hospital Director Name here] off begin
		String randomStringForHospitalDirectorName = mockNeat
				.strings()
				.get();
		newEntity.setHospitalDirectorName(randomStringForHospitalDirectorName);
		// % protected region % [Add customisation for Hospital Director Name here] end
		// % protected region % [Add customisation for Date of Registration here] off begin
		newEntity.setDateOfRegistration(OffsetDateTime.now());
		// % protected region % [Add customisation for Date of Registration here] end
		// % protected region % [Add customisation for Hospital Corporation Name here] off begin
		String randomStringForHospitalCorporationName = mockNeat
				.strings()
				.get();
		newEntity.setHospitalCorporationName(randomStringForHospitalCorporationName);
		// % protected region % [Add customisation for Hospital Corporation Name here] end
		// % protected region % [Add customisation for Is BPJS Facility here] off begin
		newEntity.setIsBPJSFacility(mockNeat.bools().get());
		// % protected region % [Add customisation for Is BPJS Facility here] end
		// % protected region % [Add customisation for Address here] off begin
		String randomStringForAddress = mockNeat
				.strings()
				.get();
		newEntity.setAddress(randomStringForAddress);
		// % protected region % [Add customisation for Address here] end
		// % protected region % [Add customisation for City here] off begin
		String randomStringForCity = mockNeat
				.strings()
				.get();
		newEntity.setCity(randomStringForCity);
		// % protected region % [Add customisation for City here] end
		// % protected region % [Add customisation for Postcode here] off begin
		String randomStringForPostcode = mockNeat
				.strings()
				.get();
		newEntity.setPostcode(randomStringForPostcode);
		// % protected region % [Add customisation for Postcode here] end
		// % protected region % [Add customisation for Phone Number here] off begin
		String randomStringForPhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setPhoneNumber(randomStringForPhoneNumber);
		// % protected region % [Add customisation for Phone Number here] end
		// % protected region % [Add customisation for Fax here] off begin
		String randomStringForFax = mockNeat
				.strings()
				.get();
		newEntity.setFax(randomStringForFax);
		// % protected region % [Add customisation for Fax here] end
		// % protected region % [Add customisation for Email here] off begin
		String randomStringForEmail = mockNeat
				.strings()
				.get();
		newEntity.setEmail(randomStringForEmail);
		// % protected region % [Add customisation for Email here] end
		// % protected region % [Add customisation for Website here] off begin
		String randomStringForWebsite = mockNeat
				.strings()
				.get();
		newEntity.setWebsite(randomStringForWebsite);
		// % protected region % [Add customisation for Website here] end
		// % protected region % [Add customisation for Contact Person here] off begin
		String randomStringForContactPerson = mockNeat
				.strings()
				.get();
		newEntity.setContactPerson(randomStringForContactPerson);
		// % protected region % [Add customisation for Contact Person here] end
		// % protected region % [Add customisation for Contact Person Phone Number here] off begin
		String randomStringForContactPersonPhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setContactPersonPhoneNumber(randomStringForContactPersonPhoneNumber);
		// % protected region % [Add customisation for Contact Person Phone Number here] end
		// % protected region % [Add customisation for Contact Person Email here] off begin
		String randomStringForContactPersonEmail = mockNeat
				.strings()
				.get();
		newEntity.setContactPersonEmail(randomStringForContactPersonEmail);
		// % protected region % [Add customisation for Contact Person Email here] end
		// % protected region % [Add customisation for Land Size here] off begin
		String randomStringForLandSize = mockNeat
				.strings()
				.get();
		newEntity.setLandSize(randomStringForLandSize);
		// % protected region % [Add customisation for Land Size here] end
		// % protected region % [Add customisation for Building Size here] off begin
		String randomStringForBuildingSize = mockNeat
				.strings()
				.get();
		newEntity.setBuildingSize(randomStringForBuildingSize);
		// % protected region % [Add customisation for Building Size here] end
		// % protected region % [Add customisation for Permit Number here] off begin
		String randomStringForPermitNumber = mockNeat
				.strings()
				.get();
		newEntity.setPermitNumber(randomStringForPermitNumber);
		// % protected region % [Add customisation for Permit Number here] end
		// % protected region % [Add customisation for Permit Date here] off begin
		newEntity.setPermitDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Permit Date here] end
		// % protected region % [Add customisation for Authorized By here] off begin
		String randomStringForAuthorizedBy = mockNeat
				.strings()
				.get();
		newEntity.setAuthorizedBy(randomStringForAuthorizedBy);
		// % protected region % [Add customisation for Authorized By here] end
		// % protected region % [Add customisation for Permit Type here] off begin
		String randomStringForPermitType = mockNeat
				.strings()
				.get();
		newEntity.setPermitType(randomStringForPermitType);
		// % protected region % [Add customisation for Permit Type here] end
		// % protected region % [Add customisation for Valid Until here] off begin
		newEntity.setValidUntil(OffsetDateTime.now());
		// % protected region % [Add customisation for Valid Until here] end
		// % protected region % [Add customisation for Hospital Branch Corporation Name here] off begin
		String randomStringForHospitalBranchCorporationName = mockNeat
				.strings()
				.get();
		newEntity.setHospitalBranchCorporationName(randomStringForHospitalBranchCorporationName);
		// % protected region % [Add customisation for Hospital Branch Corporation Name here] end
		// % protected region % [Add customisation for Hospital Branch Corporation Status here] off begin
		String randomStringForHospitalBranchCorporationStatus = mockNeat
				.strings()
				.get();
		newEntity.setHospitalBranchCorporationStatus(randomStringForHospitalBranchCorporationStatus);
		// % protected region % [Add customisation for Hospital Branch Corporation Status here] end
		// % protected region % [Add customisation for Accreditation Type here] off begin
		String randomStringForAccreditationType = mockNeat
				.strings()
				.get();
		newEntity.setAccreditationType(randomStringForAccreditationType);
		// % protected region % [Add customisation for Accreditation Type here] end
		// % protected region % [Add customisation for Accreditation Level here] off begin
		String randomStringForAccreditationLevel = mockNeat
				.strings()
				.get();
		newEntity.setAccreditationLevel(randomStringForAccreditationLevel);
		// % protected region % [Add customisation for Accreditation Level here] end
		// % protected region % [Add customisation for Accreditation Date here] off begin
		newEntity.setAccreditationDate(OffsetDateTime.now());
		// % protected region % [Add customisation for Accreditation Date here] end
		// % protected region % [Add customisation for Bed Perinatology here] off begin
		String randomStringForBedPerinatology = mockNeat
				.strings()
				.get();
		newEntity.setBedPerinatology(randomStringForBedPerinatology);
		// % protected region % [Add customisation for Bed Perinatology here] end
		// % protected region % [Add customisation for Suite Class here] off begin
		String randomStringForSuiteClass = mockNeat
				.strings()
				.get();
		newEntity.setSuiteClass(randomStringForSuiteClass);
		// % protected region % [Add customisation for Suite Class here] end
		// % protected region % [Add customisation for VVIP Class here] off begin
		String randomStringForVvipClass = mockNeat
				.strings()
				.get();
		newEntity.setVvipClass(randomStringForVvipClass);
		// % protected region % [Add customisation for VVIP Class here] end
		// % protected region % [Add customisation for VIP A Class here] off begin
		String randomStringForVipAClass = mockNeat
				.strings()
				.get();
		newEntity.setVipAClass(randomStringForVipAClass);
		// % protected region % [Add customisation for VIP A Class here] end
		// % protected region % [Add customisation for VIP B Class here] off begin
		String randomStringForVipBClass = mockNeat
				.strings()
				.get();
		newEntity.setVipBClass(randomStringForVipBClass);
		// % protected region % [Add customisation for VIP B Class here] end
		// % protected region % [Add customisation for VIP C Class here] off begin
		String randomStringForVipCClass = mockNeat
				.strings()
				.get();
		newEntity.setVipCClass(randomStringForVipCClass);
		// % protected region % [Add customisation for VIP C Class here] end
		// % protected region % [Add customisation for Main Class here] off begin
		String randomStringForMainClass = mockNeat
				.strings()
				.get();
		newEntity.setMainClass(randomStringForMainClass);
		// % protected region % [Add customisation for Main Class here] end
		// % protected region % [Add customisation for Class I here] off begin
		String randomStringForClassI = mockNeat
				.strings()
				.get();
		newEntity.setClassI(randomStringForClassI);
		// % protected region % [Add customisation for Class I here] end
		// % protected region % [Add customisation for II Class here] off begin
		String randomStringForIiClass = mockNeat
				.strings()
				.get();
		newEntity.setIiClass(randomStringForIiClass);
		// % protected region % [Add customisation for II Class here] end
		// % protected region % [Add customisation for III A Class here] off begin
		String randomStringForIiiAClass = mockNeat
				.strings()
				.get();
		newEntity.setIiiAClass(randomStringForIiiAClass);
		// % protected region % [Add customisation for III A Class here] end
		// % protected region % [Add customisation for III B Class here] off begin
		String randomStringForIiiBClass = mockNeat
				.strings()
				.get();
		newEntity.setIiiBClass(randomStringForIiiBClass);
		// % protected region % [Add customisation for III B Class here] end
		// % protected region % [Add customisation for Special Class here] off begin
		String randomStringForSpecialClass = mockNeat
				.strings()
				.get();
		newEntity.setSpecialClass(randomStringForSpecialClass);
		// % protected region % [Add customisation for Special Class here] end
		// % protected region % [Add customisation for ICU here] off begin
		String randomStringForIcu = mockNeat
				.strings()
				.get();
		newEntity.setIcu(randomStringForIcu);
		// % protected region % [Add customisation for ICU here] end
		// % protected region % [Add customisation for PICU here] off begin
		String randomStringForPicu = mockNeat
				.strings()
				.get();
		newEntity.setPicu(randomStringForPicu);
		// % protected region % [Add customisation for PICU here] end
		// % protected region % [Add customisation for NICU here] off begin
		String randomStringForNicu = mockNeat
				.strings()
				.get();
		newEntity.setNicu(randomStringForNicu);
		// % protected region % [Add customisation for NICU here] end
		// % protected region % [Add customisation for HCU here] off begin
		String randomStringForHcu = mockNeat
				.strings()
				.get();
		newEntity.setHcu(randomStringForHcu);
		// % protected region % [Add customisation for HCU here] end
		// % protected region % [Add customisation for ICCU here] off begin
		String randomStringForIccu = mockNeat
				.strings()
				.get();
		newEntity.setIccu(randomStringForIccu);
		// % protected region % [Add customisation for ICCU here] end
		// % protected region % [Add customisation for Isolation Room here] off begin
		String randomStringForIsolationRoom = mockNeat
				.strings()
				.get();
		newEntity.setIsolationRoom(randomStringForIsolationRoom);
		// % protected region % [Add customisation for Isolation Room here] end
		// % protected region % [Add customisation for Emergency Room here] off begin
		String randomStringForEmergencyRoom = mockNeat
				.strings()
				.get();
		newEntity.setEmergencyRoom(randomStringForEmergencyRoom);
		// % protected region % [Add customisation for Emergency Room here] end
		// % protected region % [Add customisation for Maternity Room here] off begin
		String randomStringForMaternityRoom = mockNeat
				.strings()
				.get();
		newEntity.setMaternityRoom(randomStringForMaternityRoom);
		// % protected region % [Add customisation for Maternity Room here] end
		// % protected region % [Add customisation for Operating Room here] off begin
		String randomStringForOperatingRoom = mockNeat
				.strings()
				.get();
		newEntity.setOperatingRoom(randomStringForOperatingRoom);
		// % protected region % [Add customisation for Operating Room here] end
		// % protected region % [Add customisation for Doctor SpA here] off begin
		String randomStringForDoctorSpA = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpA(randomStringForDoctorSpA);
		// % protected region % [Add customisation for Doctor SpA here] end
		// % protected region % [Add customisation for Doctor SpOG here] off begin
		String randomStringForDoctorSpOG = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpOG(randomStringForDoctorSpOG);
		// % protected region % [Add customisation for Doctor SpOG here] end
		// % protected region % [Add customisation for Doctor SpPD here] off begin
		String randomStringForDoctorSpPD = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpPD(randomStringForDoctorSpPD);
		// % protected region % [Add customisation for Doctor SpPD here] end
		// % protected region % [Add customisation for Doctor SpB here] off begin
		String randomStringForDoctorSpB = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpB(randomStringForDoctorSpB);
		// % protected region % [Add customisation for Doctor SpB here] end
		// % protected region % [Add customisation for Doctor SpRad here] off begin
		String randomStringForDoctorSpRad = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpRad(randomStringForDoctorSpRad);
		// % protected region % [Add customisation for Doctor SpRad here] end
		// % protected region % [Add customisation for Doctor SpRm here] off begin
		String randomStringForDoctorSpRm = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpRm(randomStringForDoctorSpRm);
		// % protected region % [Add customisation for Doctor SpRm here] end
		// % protected region % [Add customisation for Doctor SpAn here] off begin
		String randomStringForDoctorSpAn = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpAn(randomStringForDoctorSpAn);
		// % protected region % [Add customisation for Doctor SpAn here] end
		// % protected region % [Add customisation for Doctor SpJp here] off begin
		String randomStringForDoctorSpJp = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpJp(randomStringForDoctorSpJp);
		// % protected region % [Add customisation for Doctor SpJp here] end
		// % protected region % [Add customisation for Doctor SpM here] off begin
		String randomStringForDoctorSpM = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpM(randomStringForDoctorSpM);
		// % protected region % [Add customisation for Doctor SpM here] end
		// % protected region % [Add customisation for Doctor SpTHT here] off begin
		String randomStringForDoctorSpTHT = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpTHT(randomStringForDoctorSpTHT);
		// % protected region % [Add customisation for Doctor SpTHT here] end
		// % protected region % [Add customisation for Doctor SpKj here] off begin
		String randomStringForDoctorSpKj = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpKj(randomStringForDoctorSpKj);
		// % protected region % [Add customisation for Doctor SpKj here] end
		// % protected region % [Add customisation for Doctor SpP here] off begin
		String randomStringForDoctorSpP = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpP(randomStringForDoctorSpP);
		// % protected region % [Add customisation for Doctor SpP here] end
		// % protected region % [Add customisation for Doctor SpPK here] off begin
		String randomStringForDoctorSpPK = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpPK(randomStringForDoctorSpPK);
		// % protected region % [Add customisation for Doctor SpPK here] end
		// % protected region % [Add customisation for Doctor SpS here] off begin
		String randomStringForDoctorSpS = mockNeat
				.strings()
				.get();
		newEntity.setDoctorSpS(randomStringForDoctorSpS);
		// % protected region % [Add customisation for Doctor SpS here] end
		// % protected region % [Add customisation for Sub Specialist Doctor here] off begin
		String randomStringForSubSpecialistDoctor = mockNeat
				.strings()
				.get();
		newEntity.setSubSpecialistDoctor(randomStringForSubSpecialistDoctor);
		// % protected region % [Add customisation for Sub Specialist Doctor here] end
		// % protected region % [Add customisation for Other Specialist Doctor here] off begin
		String randomStringForOtherSpecialistDoctor = mockNeat
				.strings()
				.get();
		newEntity.setOtherSpecialistDoctor(randomStringForOtherSpecialistDoctor);
		// % protected region % [Add customisation for Other Specialist Doctor here] end
		// % protected region % [Add customisation for General Practice here] off begin
		String randomStringForGeneralPractice = mockNeat
				.strings()
				.get();
		newEntity.setGeneralPractice(randomStringForGeneralPractice);
		// % protected region % [Add customisation for General Practice here] end
		// % protected region % [Add customisation for Dentist here] off begin
		String randomStringForDentist = mockNeat
				.strings()
				.get();
		newEntity.setDentist(randomStringForDentist);
		// % protected region % [Add customisation for Dentist here] end
		// % protected region % [Add customisation for Specialist Dentist here] off begin
		String randomStringForSpecialistDentist = mockNeat
				.strings()
				.get();
		newEntity.setSpecialistDentist(randomStringForSpecialistDentist);
		// % protected region % [Add customisation for Specialist Dentist here] end
		// % protected region % [Add customisation for Nurse here] off begin
		String randomStringForNurse = mockNeat
				.strings()
				.get();
		newEntity.setNurse(randomStringForNurse);
		// % protected region % [Add customisation for Nurse here] end
		// % protected region % [Add customisation for Midwife here] off begin
		String randomStringForMidwife = mockNeat
				.strings()
				.get();
		newEntity.setMidwife(randomStringForMidwife);
		// % protected region % [Add customisation for Midwife here] end
		// % protected region % [Add customisation for Pharmacist here] off begin
		String randomStringForPharmacist = mockNeat
				.strings()
				.get();
		newEntity.setPharmacist(randomStringForPharmacist);
		// % protected region % [Add customisation for Pharmacist here] end
		// % protected region % [Add customisation for Other Medical Staff here] off begin
		String randomStringForOtherMedicalStaff = mockNeat
				.strings()
				.get();
		newEntity.setOtherMedicalStaff(randomStringForOtherMedicalStaff);
		// % protected region % [Add customisation for Other Medical Staff here] end
		// % protected region % [Add customisation for Non Medical Staff here] off begin
		String randomStringForNonMedicalStaff = mockNeat
				.strings()
				.get();
		newEntity.setNonMedicalStaff(randomStringForNonMedicalStaff);
		// % protected region % [Add customisation for Non Medical Staff here] end
		// % protected region % [Add customisation for Left Logo here] off begin
		// % protected region % [Add customisation for Left Logo here] end
		// % protected region % [Add customisation for Right Logo here] off begin
		// % protected region % [Add customisation for Right Logo here] end
		// % protected region % [Add customisation for Timezone here] off begin
		String randomStringForTimezone = mockNeat
				.strings()
				.get();
		newEntity.setTimezone(randomStringForTimezone);
		// % protected region % [Add customisation for Timezone here] end
		// % protected region % [Add customisation for Health Facility Level here] off begin
		String randomStringForHealthFacilityLevel = mockNeat
				.strings()
				.get();
		newEntity.setHealthFacilityLevel(randomStringForHealthFacilityLevel);
		// % protected region % [Add customisation for Health Facility Level here] end
		// % protected region % [Add customisation for Satu Sehat Integration here] off begin
		newEntity.setSatuSehatIntegration(mockNeat.bools().get());
		// % protected region % [Add customisation for Satu Sehat Integration here] end
		// % protected region % [Add customisation for Tax Identification here] off begin
		String randomStringForTaxIdentification = mockNeat
				.strings()
				.get();
		newEntity.setTaxIdentification(randomStringForTaxIdentification);
		// % protected region % [Add customisation for Tax Identification here] end

		// % protected region % [Apply any additional logic for hospitalBranchInformationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformationWithNoRef after the main body here] end


		if (includeReferences) {
			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyHospital Group here] off begin
			var hospitalGroupFactory = new HospitalGroupInformationFactory();
			newEntity.setHospitalGroup(hospitalGroupFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyHospital Group here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

		}

		// % protected region % [Apply any additional logic for hospitalBranchInformation with ref here] off begin
		// % protected region % [Apply any additional logic for hospitalBranchInformation with ref here] end

		return newEntity;
	}

	@Override
	public Class<HospitalBranchInformationEntity> getObjectType() {
		return HospitalBranchInformationEntity.class;
	}
}