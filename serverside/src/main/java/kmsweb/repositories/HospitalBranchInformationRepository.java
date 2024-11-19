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
package kmsweb.repositories;

import kmsweb.entities.HospitalBranchInformationEntity;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import java.time.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

/**
 * Repository used to handle any data access operations against an entity.
 */
@Repository
public interface HospitalBranchInformationRepository extends AbstractRepository<HospitalBranchInformationEntity> {
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Code.
	 *
	 * @param hospitalCode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Code
	 */
	Optional<HospitalBranchInformationEntity> findByHospitalCode(@NotNull String hospitalCode);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Name.
	 *
	 * @param hospitalName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Name
	 */
	List<HospitalBranchInformationEntity> findByHospitalName(@NotNull String hospitalName);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Type.
	 *
	 * @param hospitalType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Type
	 */
	List<HospitalBranchInformationEntity> findByHospitalType(@NotNull String hospitalType);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Class.
	 *
	 * @param hospitalClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Class
	 */
	List<HospitalBranchInformationEntity> findByHospitalClass(@NotNull String hospitalClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Director Name.
	 *
	 * @param hospitalDirectorName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Director Name
	 */
	List<HospitalBranchInformationEntity> findByHospitalDirectorName(@NotNull String hospitalDirectorName);
	/**
	 * Return an entity or a list of entities that have the given attribute Date of Registration.
	 *
	 * @param dateOfRegistration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Date of Registration
	 */
	List<HospitalBranchInformationEntity> findByDateOfRegistration(@NotNull OffsetDateTime dateOfRegistration);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Corporation Name.
	 *
	 * @param hospitalCorporationName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Corporation Name
	 */
	List<HospitalBranchInformationEntity> findByHospitalCorporationName(@NotNull String hospitalCorporationName);
	/**
	 * Return an entity or a list of entities that have the given attribute Is BPJS Facility.
	 *
	 * @param isBPJSFacility the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Is BPJS Facility
	 */
	List<HospitalBranchInformationEntity> findByIsBPJSFacility(@NotNull Boolean isBPJSFacility);
	/**
	 * Return an entity or a list of entities that have the given attribute Address.
	 *
	 * @param address the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Address
	 */
	List<HospitalBranchInformationEntity> findByAddress(@NotNull String address);
	/**
	 * Return an entity or a list of entities that have the given attribute City.
	 *
	 * @param city the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute City
	 */
	List<HospitalBranchInformationEntity> findByCity(@NotNull String city);
	/**
	 * Return an entity or a list of entities that have the given attribute Postcode.
	 *
	 * @param postcode the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Postcode
	 */
	List<HospitalBranchInformationEntity> findByPostcode(@NotNull String postcode);
	/**
	 * Return an entity or a list of entities that have the given attribute Phone Number.
	 *
	 * @param phoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Phone Number
	 */
	List<HospitalBranchInformationEntity> findByPhoneNumber(@NotNull String phoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Fax.
	 *
	 * @param fax the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Fax
	 */
	List<HospitalBranchInformationEntity> findByFax(@NotNull String fax);
	/**
	 * Return an entity or a list of entities that have the given attribute Email.
	 *
	 * @param email the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Email
	 */
	List<HospitalBranchInformationEntity> findByEmail(@NotNull String email);
	/**
	 * Return an entity or a list of entities that have the given attribute Website.
	 *
	 * @param website the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Website
	 */
	List<HospitalBranchInformationEntity> findByWebsite(@NotNull String website);
	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person.
	 *
	 * @param contactPerson the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person
	 */
	List<HospitalBranchInformationEntity> findByContactPerson(@NotNull String contactPerson);
	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person Phone Number.
	 *
	 * @param contactPersonPhoneNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person Phone Number
	 */
	List<HospitalBranchInformationEntity> findByContactPersonPhoneNumber(@NotNull String contactPersonPhoneNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Contact Person Email.
	 *
	 * @param contactPersonEmail the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Contact Person Email
	 */
	List<HospitalBranchInformationEntity> findByContactPersonEmail(@NotNull String contactPersonEmail);
	/**
	 * Return an entity or a list of entities that have the given attribute Land Size.
	 *
	 * @param landSize the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Land Size
	 */
	List<HospitalBranchInformationEntity> findByLandSize(@NotNull String landSize);
	/**
	 * Return an entity or a list of entities that have the given attribute Building Size.
	 *
	 * @param buildingSize the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Building Size
	 */
	List<HospitalBranchInformationEntity> findByBuildingSize(@NotNull String buildingSize);
	/**
	 * Return an entity or a list of entities that have the given attribute Permit Number.
	 *
	 * @param permitNumber the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Permit Number
	 */
	List<HospitalBranchInformationEntity> findByPermitNumber(@NotNull String permitNumber);
	/**
	 * Return an entity or a list of entities that have the given attribute Permit Date.
	 *
	 * @param permitDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Permit Date
	 */
	List<HospitalBranchInformationEntity> findByPermitDate(@NotNull OffsetDateTime permitDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Authorized By.
	 *
	 * @param authorizedBy the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Authorized By
	 */
	List<HospitalBranchInformationEntity> findByAuthorizedBy(@NotNull String authorizedBy);
	/**
	 * Return an entity or a list of entities that have the given attribute Permit Type.
	 *
	 * @param permitType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Permit Type
	 */
	List<HospitalBranchInformationEntity> findByPermitType(@NotNull String permitType);
	/**
	 * Return an entity or a list of entities that have the given attribute Valid Until.
	 *
	 * @param validUntil the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Valid Until
	 */
	List<HospitalBranchInformationEntity> findByValidUntil(@NotNull OffsetDateTime validUntil);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Branch Corporation Name.
	 *
	 * @param hospitalBranchCorporationName the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Branch Corporation Name
	 */
	List<HospitalBranchInformationEntity> findByHospitalBranchCorporationName(@NotNull String hospitalBranchCorporationName);
	/**
	 * Return an entity or a list of entities that have the given attribute Hospital Branch Corporation Status.
	 *
	 * @param hospitalBranchCorporationStatus the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Hospital Branch Corporation Status
	 */
	List<HospitalBranchInformationEntity> findByHospitalBranchCorporationStatus(@NotNull String hospitalBranchCorporationStatus);
	/**
	 * Return an entity or a list of entities that have the given attribute Accreditation Type.
	 *
	 * @param accreditationType the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accreditation Type
	 */
	List<HospitalBranchInformationEntity> findByAccreditationType(@NotNull String accreditationType);
	/**
	 * Return an entity or a list of entities that have the given attribute Accreditation Level.
	 *
	 * @param accreditationLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accreditation Level
	 */
	List<HospitalBranchInformationEntity> findByAccreditationLevel(@NotNull String accreditationLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Accreditation Date.
	 *
	 * @param accreditationDate the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Accreditation Date
	 */
	List<HospitalBranchInformationEntity> findByAccreditationDate(@NotNull OffsetDateTime accreditationDate);
	/**
	 * Return an entity or a list of entities that have the given attribute Bed Perinatology.
	 *
	 * @param bedPerinatology the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Bed Perinatology
	 */
	List<HospitalBranchInformationEntity> findByBedPerinatology(@NotNull String bedPerinatology);
	/**
	 * Return an entity or a list of entities that have the given attribute Suite Class.
	 *
	 * @param suiteClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Suite Class
	 */
	List<HospitalBranchInformationEntity> findBySuiteClass(@NotNull String suiteClass);
	/**
	 * Return an entity or a list of entities that have the given attribute VVIP Class.
	 *
	 * @param vvipClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VVIP Class
	 */
	List<HospitalBranchInformationEntity> findByVvipClass(@NotNull String vvipClass);
	/**
	 * Return an entity or a list of entities that have the given attribute VIP A Class.
	 *
	 * @param vipAClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VIP A Class
	 */
	List<HospitalBranchInformationEntity> findByVipAClass(@NotNull String vipAClass);
	/**
	 * Return an entity or a list of entities that have the given attribute VIP B Class.
	 *
	 * @param vipBClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VIP B Class
	 */
	List<HospitalBranchInformationEntity> findByVipBClass(@NotNull String vipBClass);
	/**
	 * Return an entity or a list of entities that have the given attribute VIP C Class.
	 *
	 * @param vipCClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute VIP C Class
	 */
	List<HospitalBranchInformationEntity> findByVipCClass(@NotNull String vipCClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Main Class.
	 *
	 * @param mainClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Main Class
	 */
	List<HospitalBranchInformationEntity> findByMainClass(@NotNull String mainClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Class I.
	 *
	 * @param classI the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Class I
	 */
	List<HospitalBranchInformationEntity> findByClassI(@NotNull String classI);
	/**
	 * Return an entity or a list of entities that have the given attribute II Class.
	 *
	 * @param iiClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute II Class
	 */
	List<HospitalBranchInformationEntity> findByIiClass(@NotNull String iiClass);
	/**
	 * Return an entity or a list of entities that have the given attribute III A Class.
	 *
	 * @param iiiAClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute III A Class
	 */
	List<HospitalBranchInformationEntity> findByIiiAClass(@NotNull String iiiAClass);
	/**
	 * Return an entity or a list of entities that have the given attribute III B Class.
	 *
	 * @param iiiBClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute III B Class
	 */
	List<HospitalBranchInformationEntity> findByIiiBClass(@NotNull String iiiBClass);
	/**
	 * Return an entity or a list of entities that have the given attribute Special Class.
	 *
	 * @param specialClass the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Special Class
	 */
	List<HospitalBranchInformationEntity> findBySpecialClass(@NotNull String specialClass);
	/**
	 * Return an entity or a list of entities that have the given attribute ICU.
	 *
	 * @param icu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICU
	 */
	List<HospitalBranchInformationEntity> findByIcu(@NotNull String icu);
	/**
	 * Return an entity or a list of entities that have the given attribute PICU.
	 *
	 * @param picu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute PICU
	 */
	List<HospitalBranchInformationEntity> findByPicu(@NotNull String picu);
	/**
	 * Return an entity or a list of entities that have the given attribute NICU.
	 *
	 * @param nicu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute NICU
	 */
	List<HospitalBranchInformationEntity> findByNicu(@NotNull String nicu);
	/**
	 * Return an entity or a list of entities that have the given attribute HCU.
	 *
	 * @param hcu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute HCU
	 */
	List<HospitalBranchInformationEntity> findByHcu(@NotNull String hcu);
	/**
	 * Return an entity or a list of entities that have the given attribute ICCU.
	 *
	 * @param iccu the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute ICCU
	 */
	List<HospitalBranchInformationEntity> findByIccu(@NotNull String iccu);
	/**
	 * Return an entity or a list of entities that have the given attribute Isolation Room.
	 *
	 * @param isolationRoom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Isolation Room
	 */
	List<HospitalBranchInformationEntity> findByIsolationRoom(@NotNull String isolationRoom);
	/**
	 * Return an entity or a list of entities that have the given attribute Emergency Room.
	 *
	 * @param emergencyRoom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Emergency Room
	 */
	List<HospitalBranchInformationEntity> findByEmergencyRoom(@NotNull String emergencyRoom);
	/**
	 * Return an entity or a list of entities that have the given attribute Maternity Room.
	 *
	 * @param maternityRoom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Maternity Room
	 */
	List<HospitalBranchInformationEntity> findByMaternityRoom(@NotNull String maternityRoom);
	/**
	 * Return an entity or a list of entities that have the given attribute Operating Room.
	 *
	 * @param operatingRoom the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Operating Room
	 */
	List<HospitalBranchInformationEntity> findByOperatingRoom(@NotNull String operatingRoom);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpA.
	 *
	 * @param doctorSpA the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpA
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpA(@NotNull String doctorSpA);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpOG.
	 *
	 * @param doctorSpOG the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpOG
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpOG(@NotNull String doctorSpOG);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpPD.
	 *
	 * @param doctorSpPD the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpPD
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpPD(@NotNull String doctorSpPD);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpB.
	 *
	 * @param doctorSpB the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpB
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpB(@NotNull String doctorSpB);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpRad.
	 *
	 * @param doctorSpRad the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpRad
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpRad(@NotNull String doctorSpRad);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpRm.
	 *
	 * @param doctorSpRm the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpRm
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpRm(@NotNull String doctorSpRm);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpAn.
	 *
	 * @param doctorSpAn the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpAn
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpAn(@NotNull String doctorSpAn);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpJp.
	 *
	 * @param doctorSpJp the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpJp
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpJp(@NotNull String doctorSpJp);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpM.
	 *
	 * @param doctorSpM the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpM
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpM(@NotNull String doctorSpM);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpTHT.
	 *
	 * @param doctorSpTHT the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpTHT
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpTHT(@NotNull String doctorSpTHT);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpKj.
	 *
	 * @param doctorSpKj the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpKj
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpKj(@NotNull String doctorSpKj);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpP.
	 *
	 * @param doctorSpP the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpP
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpP(@NotNull String doctorSpP);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpPK.
	 *
	 * @param doctorSpPK the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpPK
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpPK(@NotNull String doctorSpPK);
	/**
	 * Return an entity or a list of entities that have the given attribute Doctor SpS.
	 *
	 * @param doctorSpS the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Doctor SpS
	 */
	List<HospitalBranchInformationEntity> findByDoctorSpS(@NotNull String doctorSpS);
	/**
	 * Return an entity or a list of entities that have the given attribute Sub Specialist Doctor.
	 *
	 * @param subSpecialistDoctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Sub Specialist Doctor
	 */
	List<HospitalBranchInformationEntity> findBySubSpecialistDoctor(@NotNull String subSpecialistDoctor);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Specialist Doctor.
	 *
	 * @param otherSpecialistDoctor the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Specialist Doctor
	 */
	List<HospitalBranchInformationEntity> findByOtherSpecialistDoctor(@NotNull String otherSpecialistDoctor);
	/**
	 * Return an entity or a list of entities that have the given attribute General Practice.
	 *
	 * @param generalPractice the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute General Practice
	 */
	List<HospitalBranchInformationEntity> findByGeneralPractice(@NotNull String generalPractice);
	/**
	 * Return an entity or a list of entities that have the given attribute Dentist.
	 *
	 * @param dentist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Dentist
	 */
	List<HospitalBranchInformationEntity> findByDentist(@NotNull String dentist);
	/**
	 * Return an entity or a list of entities that have the given attribute Specialist Dentist.
	 *
	 * @param specialistDentist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Specialist Dentist
	 */
	List<HospitalBranchInformationEntity> findBySpecialistDentist(@NotNull String specialistDentist);
	/**
	 * Return an entity or a list of entities that have the given attribute Nurse.
	 *
	 * @param nurse the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Nurse
	 */
	List<HospitalBranchInformationEntity> findByNurse(@NotNull String nurse);
	/**
	 * Return an entity or a list of entities that have the given attribute Midwife.
	 *
	 * @param midwife the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Midwife
	 */
	List<HospitalBranchInformationEntity> findByMidwife(@NotNull String midwife);
	/**
	 * Return an entity or a list of entities that have the given attribute Pharmacist.
	 *
	 * @param pharmacist the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Pharmacist
	 */
	List<HospitalBranchInformationEntity> findByPharmacist(@NotNull String pharmacist);
	/**
	 * Return an entity or a list of entities that have the given attribute Other Medical Staff.
	 *
	 * @param otherMedicalStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Other Medical Staff
	 */
	List<HospitalBranchInformationEntity> findByOtherMedicalStaff(@NotNull String otherMedicalStaff);
	/**
	 * Return an entity or a list of entities that have the given attribute Non Medical Staff.
	 *
	 * @param nonMedicalStaff the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Non Medical Staff
	 */
	List<HospitalBranchInformationEntity> findByNonMedicalStaff(@NotNull String nonMedicalStaff);
	/**
	 * Return an entity or a list of entities that have the given attribute Timezone.
	 *
	 * @param timezone the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Timezone
	 */
	List<HospitalBranchInformationEntity> findByTimezone(@NotNull String timezone);
	/**
	 * Return an entity or a list of entities that have the given attribute Health Facility Level.
	 *
	 * @param healthFacilityLevel the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Health Facility Level
	 */
	List<HospitalBranchInformationEntity> findByHealthFacilityLevel(@NotNull String healthFacilityLevel);
	/**
	 * Return an entity or a list of entities that have the given attribute Satu Sehat Integration.
	 *
	 * @param satuSehatIntegration the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Satu Sehat Integration
	 */
	List<HospitalBranchInformationEntity> findBySatuSehatIntegration(@NotNull Boolean satuSehatIntegration);
	/**
	 * Return an entity or a list of entities that have the given attribute Tax Identification.
	 *
	 * @param taxIdentification the attribute against which the entities will be retrieved
	 * @return a list of entities that have the given attribute Tax Identification
	 */
	Optional<HospitalBranchInformationEntity> findByTaxIdentification(@NotNull String taxIdentification);

	@Transactional
	void deleteAllByIdIn(@NotNull Iterable<UUID> ids);

	@Transactional
	void deleteAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HospitalBranchInformationEntity> findAllByIdNotIn(@NotNull Iterable<UUID> ids);

	@Transactional
	List<HospitalBranchInformationEntity> findAllByIdIn(@NotNull Iterable<UUID> ids);

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}