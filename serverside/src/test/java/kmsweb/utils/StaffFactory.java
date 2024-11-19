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
import kmsweb.entities.StaffEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class StaffFactory implements FactoryBean<StaffEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public StaffEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public StaffEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public StaffEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for staffWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for staffWithNoRef before the main body here] end

		StaffEntity newEntity = new StaffEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Staff Number here] off begin
		String randomStringForStaffNumber = mockNeat
				.strings()
				.get();
		newEntity.setStaffNumber(randomStringForStaffNumber);
		// % protected region % [Add customisation for Staff Number here] end
		// % protected region % [Add customisation for First Name here] off begin
		String randomStringForFirstName = mockNeat
				.strings()
				.get();
		newEntity.setFirstName(randomStringForFirstName);
		// % protected region % [Add customisation for First Name here] end
		// % protected region % [Add customisation for Last Name here] off begin
		String randomStringForLastName = mockNeat
				.strings()
				.get();
		newEntity.setLastName(randomStringForLastName);
		// % protected region % [Add customisation for Last Name here] end
		// % protected region % [Add customisation for Date of Birth here] off begin
		newEntity.setDateOfBirth(OffsetDateTime.now());
		// % protected region % [Add customisation for Date of Birth here] end
		// % protected region % [Add customisation for Staff Type here] off begin
		String randomStringForStaffType = mockNeat
				.strings()
				.get();
		newEntity.setStaffType(randomStringForStaffType);
		// % protected region % [Add customisation for Staff Type here] end
		// % protected region % [Add customisation for Specialization here] off begin
		String randomStringForSpecialization = mockNeat
				.strings()
				.get();
		newEntity.setSpecialization(randomStringForSpecialization);
		// % protected region % [Add customisation for Specialization here] end
		// % protected region % [Add customisation for Staff Picture here] off begin
		// % protected region % [Add customisation for Staff Picture here] end
		// % protected region % [Add customisation for Education here] off begin
		String randomStringForEducation = mockNeat
				.strings()
				.get();
		newEntity.setEducation(randomStringForEducation);
		// % protected region % [Add customisation for Education here] end
		// % protected region % [Add customisation for License No here] off begin
		String randomStringForLicenseNo = mockNeat
				.strings()
				.get();
		newEntity.setLicenseNo(randomStringForLicenseNo);
		// % protected region % [Add customisation for License No here] end
		// % protected region % [Add customisation for Letter of Reg here] off begin
		String randomStringForLetterOfReg = mockNeat
				.strings()
				.get();
		newEntity.setLetterOfReg(randomStringForLetterOfReg);
		// % protected region % [Add customisation for Letter of Reg here] end
		// % protected region % [Add customisation for Gender here] off begin
		String randomStringForGender = mockNeat
				.strings()
				.get();
		newEntity.setGender(randomStringForGender);
		// % protected region % [Add customisation for Gender here] end
		// % protected region % [Add customisation for Employee ID here] off begin
		String randomStringForEmployeeID = mockNeat
				.strings()
				.get();
		newEntity.setEmployeeID(randomStringForEmployeeID);
		// % protected region % [Add customisation for Employee ID here] end
		// % protected region % [Add customisation for Title here] off begin
		String randomStringForTitle = mockNeat
				.strings()
				.get();
		newEntity.setTitle(randomStringForTitle);
		// % protected region % [Add customisation for Title here] end
		// % protected region % [Add customisation for Default Service Number here] off begin
		String randomStringForDefaultServiceNumber = mockNeat
				.strings()
				.get();
		newEntity.setDefaultServiceNumber(randomStringForDefaultServiceNumber);
		// % protected region % [Add customisation for Default Service Number here] end
		// % protected region % [Add customisation for Place of birth here] off begin
		String randomStringForPlaceOfBirth = mockNeat
				.strings()
				.get();
		newEntity.setPlaceOfBirth(randomStringForPlaceOfBirth);
		// % protected region % [Add customisation for Place of birth here] end
		// % protected region % [Add customisation for Religion here] off begin
		String randomStringForReligion = mockNeat
				.strings()
				.get();
		newEntity.setReligion(randomStringForReligion);
		// % protected region % [Add customisation for Religion here] end
		// % protected region % [Add customisation for Blood Type here] off begin
		newEntity.setBloodType(BloodTypeEnum.A);
		// % protected region % [Add customisation for Blood Type here] end
		// % protected region % [Add customisation for Rhesus here] off begin
		newEntity.setRhesus(RhesusEnum.POSITIVE);
		// % protected region % [Add customisation for Rhesus here] end
		// % protected region % [Add customisation for address here] off begin
		String randomStringForAddress = mockNeat
				.strings()
				.get();
		newEntity.setAddress(randomStringForAddress);
		// % protected region % [Add customisation for address here] end
		// % protected region % [Add customisation for Country here] off begin
		String randomStringForCountry = mockNeat
				.strings()
				.get();
		newEntity.setCountry(randomStringForCountry);
		// % protected region % [Add customisation for Country here] end
		// % protected region % [Add customisation for State here] off begin
		String randomStringForState = mockNeat
				.strings()
				.get();
		newEntity.setState(randomStringForState);
		// % protected region % [Add customisation for State here] end
		// % protected region % [Add customisation for Regency here] off begin
		String randomStringForRegency = mockNeat
				.strings()
				.get();
		newEntity.setRegency(randomStringForRegency);
		// % protected region % [Add customisation for Regency here] end
		// % protected region % [Add customisation for District here] off begin
		String randomStringForDistrict = mockNeat
				.strings()
				.get();
		newEntity.setDistrict(randomStringForDistrict);
		// % protected region % [Add customisation for District here] end
		// % protected region % [Add customisation for Home phone no here] off begin
		String randomStringForHomePhoneNo = mockNeat
				.strings()
				.get();
		newEntity.setHomePhoneNo(randomStringForHomePhoneNo);
		// % protected region % [Add customisation for Home phone no here] end
		// % protected region % [Add customisation for Village here] off begin
		String randomStringForVillage = mockNeat
				.strings()
				.get();
		newEntity.setVillage(randomStringForVillage);
		// % protected region % [Add customisation for Village here] end
		// % protected region % [Add customisation for Postcode here] off begin
		String randomStringForPostcode = mockNeat
				.strings()
				.get();
		newEntity.setPostcode(randomStringForPostcode);
		// % protected region % [Add customisation for Postcode here] end
		// % protected region % [Add customisation for Office Phone Number here] off begin
		String randomStringForOfficePhoneNumber = mockNeat
				.strings()
				.get();
		newEntity.setOfficePhoneNumber(randomStringForOfficePhoneNumber);
		// % protected region % [Add customisation for Office Phone Number here] end
		// % protected region % [Add customisation for Tax Identification No here] off begin
		String randomStringForTaxIdentificationNo = mockNeat
				.strings()
				.get();
		newEntity.setTaxIdentificationNo(randomStringForTaxIdentificationNo);
		// % protected region % [Add customisation for Tax Identification No here] end
		// % protected region % [Add customisation for Mobile Phone No here] off begin
		String randomStringForMobilePhoneNo = mockNeat
				.strings()
				.get();
		newEntity.setMobilePhoneNo(randomStringForMobilePhoneNo);
		// % protected region % [Add customisation for Mobile Phone No here] end
		// % protected region % [Add customisation for Other Notes here] off begin
		String randomStringForOtherNotes = mockNeat
				.strings()
				.get();
		newEntity.setOtherNotes(randomStringForOtherNotes);
		// % protected region % [Add customisation for Other Notes here] end
		// % protected region % [Add customisation for Training here] off begin
		String randomStringForTraining = mockNeat
				.strings()
				.get();
		newEntity.setTraining(randomStringForTraining);
		// % protected region % [Add customisation for Training here] end
		// % protected region % [Add customisation for Nationality here] off begin
		String randomStringForNationality = mockNeat
				.strings()
				.get();
		newEntity.setNationality(randomStringForNationality);
		// % protected region % [Add customisation for Nationality here] end
		// % protected region % [Add customisation for Certification here] off begin
		String randomStringForCertification = mockNeat
				.strings()
				.get();
		newEntity.setCertification(randomStringForCertification);
		// % protected region % [Add customisation for Certification here] end
		// % protected region % [Add customisation for Ext No here] off begin
		String randomStringForExtNo = mockNeat
				.strings()
				.get();
		newEntity.setExtNo(randomStringForExtNo);
		// % protected region % [Add customisation for Ext No here] end
		// % protected region % [Add customisation for Marital Status here] off begin
		String randomStringForMaritalStatus = mockNeat
				.strings()
				.get();
		newEntity.setMaritalStatus(randomStringForMaritalStatus);
		// % protected region % [Add customisation for Marital Status here] end
		// % protected region % [Add customisation for email here] off begin
		String randomStringForEmail = mockNeat
				.strings()
				.get();
		newEntity.setEmail(randomStringForEmail);
		// % protected region % [Add customisation for email here] end

		// % protected region % [Apply any additional logic for staffWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for staffWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Administration User here] off begin
			// Incoming One to One reference
			var administrationUserFactory = new AdministrationUserFactory();
			newEntity.setAdministrationUser(administrationUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Administration User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Cashier User here] off begin
			// Incoming One to One reference
			var cashierUserFactory = new CashierUserFactory();
			newEntity.setCashierUser(cashierUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Cashier User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Claim User here] off begin
			// Incoming One to One reference
			var claimUserFactory = new ClaimUserFactory();
			newEntity.setClaimUser(claimUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Claim User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnostic Support User here] off begin
			// Incoming One to One reference
			var diagnosticSupportUserFactory = new DiagnosticSupportUserFactory();
			newEntity.setDiagnosticSupportUser(diagnosticSupportUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnostic Support User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Doctor User here] off begin
			// Incoming One to One reference
			var doctorUserFactory = new DoctorUserFactory();
			newEntity.setDoctorUser(doctorUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Doctor User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Facility User here] off begin
			// Incoming One to One reference
			var facilityUserFactory = new FacilityUserFactory();
			newEntity.setFacilityUser(facilityUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Facility User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Management User here] off begin
			// Incoming One to One reference
			var managementUserFactory = new ManagementUserFactory();
			newEntity.setManagementUser(managementUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Management User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Record user here] off begin
			// Incoming One to One reference
			var medicalRecordUserFactory = new MedicalRecordUserFactory();
			newEntity.setMedicalRecordUser(medicalRecordUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Record user here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Transcriber User here] off begin
			// Incoming One to One reference
			var medicalTranscriberUserFactory = new MedicalTranscriberUserFactory();
			newEntity.setMedicalTranscriberUser(medicalTranscriberUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Medical Transcriber User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Nurse User here] off begin
			// Incoming One to One reference
			var nurseUserFactory = new NurseUserFactory();
			newEntity.setNurseUser(nurseUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Nurse User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Pharmacy User here] off begin
			// Incoming One to One reference
			var pharmacyUserFactory = new PharmacyUserFactory();
			newEntity.setPharmacyUser(pharmacyUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Pharmacy User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Purchasing User here] off begin
			// Incoming One to One reference
			var purchasingUserFactory = new PurchasingUserFactory();
			newEntity.setPurchasingUser(purchasingUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Purchasing User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration User here] off begin
			// Incoming One to One reference
			var registrationUserFactory = new RegistrationUserFactory();
			newEntity.setRegistrationUser(registrationUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Registration User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne System Admin User here] off begin
			// Incoming One to One reference
			var systemAdminUserFactory = new SystemAdminUserFactory();
			newEntity.setSystemAdminUser(systemAdminUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne System Admin User here] end
			// % protected region % [Override the reference inclusions for incomingOneToOne Warehouse User here] off begin
			// Incoming One to One reference
			var warehouseUserFactory = new WarehouseUserFactory();
			newEntity.setWarehouseUser(warehouseUserFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Warehouse User here] end
			// % protected region % [Override the reference inclusions for outgoingOneToOne Administrator] off begin
			// Outgoing one to one reference
			var administratorFactory = new AdministratorFactory();
			newEntity.setAdministrator(administratorFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Administrator] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Doctor Mapping] off begin
			// Outgoing one to one reference
			var bpjsDoctorMappingFactory = new BpjsDoctorMappingFactory();
			newEntity.setBpjsDoctorMapping(bpjsDoctorMappingFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Doctor Mapping] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne PCare Dokter] off begin
			// Outgoing one to one reference
			var pcareDokterFactory = new PcareDokterFactory();
			newEntity.setPcareDokter(pcareDokterFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne PCare Dokter] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Service] off begin
			// Outgoing one to one reference
			var serviceFactory = new ServiceFactory();
			newEntity.setService(serviceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Service] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Accompanying Consents here] off begin
			// Outgoing one to many reference
			var accompanyingConsentsFactory = new InformedConsentFactory();
			newEntity.setAccompanyingConsents(Collections.singletonList(accompanyingConsentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Accompanying Consents here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Amendment Details here] off begin
			// Outgoing one to many reference
			var amendmentDetailsFactory = new AmendmentDetailFactory();
			newEntity.setAmendmentDetails(Collections.singletonList(amendmentDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Amendment Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Anesthesia Medical Transcriber here] off begin
			// Outgoing one to many reference
			var anesthesiaMedicalTranscriberFactory = new PreoperativeRecordsFactory();
			newEntity.setAnesthesiaMedicalTranscriber(Collections.singletonList(anesthesiaMedicalTranscriberFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Anesthesia Medical Transcriber here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Anesthesiologist here] off begin
			// Outgoing one to many reference
			var anesthesiologistFactory = new PreoperativeRecordsFactory();
			newEntity.setAnesthesiologist(Collections.singletonList(anesthesiologistFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Anesthesiologist here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Anesthesiology Nurse here] off begin
			// Outgoing one to many reference
			var anesthesiologyNurseFactory = new PreoperativeRecordsFactory();
			newEntity.setAnesthesiologyNurse(Collections.singletonList(anesthesiologyNurseFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Anesthesiology Nurse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Cashier Staff here] off begin
			// Outgoing one to many reference
			var cashierStaffFactory = new CashReceiptFactory();
			newEntity.setCashierStaff(Collections.singletonList(cashierStaffFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Cashier Staff here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Co Treating Doctors here] off begin
			// Outgoing one to many reference
			var coTreatingDoctorsFactory = new CoTreatingDoctorFactory();
			newEntity.setCoTreatingDoctors(Collections.singletonList(coTreatingDoctorsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Co Treating Doctors here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Daily Care CPPTs Created By Staff here] off begin
			// Outgoing one to many reference
			var dailyCareCPPTsCreatedByStaffFactory = new DailyCareCPPTFactory();
			newEntity.setDailyCareCPPTsCreatedByStaff(Collections.singletonList(dailyCareCPPTsCreatedByStaffFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Daily Care CPPTs Created By Staff here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Daily Care CPPTs Doctor in Charge here] off begin
			// Outgoing one to many reference
			var dailyCareCPPTsDoctorInChargeFactory = new DailyCareCPPTFactory();
			newEntity.setDailyCareCPPTsDoctorInCharge(Collections.singletonList(dailyCareCPPTsDoctorInChargeFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Daily Care CPPTs Doctor in Charge here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Daily Care CPPTs Medical Transcriber here] off begin
			// Outgoing one to many reference
			var dailyCareCPPTsMedicalTranscriberFactory = new DailyCareCPPTFactory();
			newEntity.setDailyCareCPPTsMedicalTranscriber(Collections.singletonList(dailyCareCPPTsMedicalTranscriberFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Daily Care CPPTs Medical Transcriber here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Delivery Progresses here] off begin
			// Outgoing one to many reference
			var deliveryProgressesFactory = new DeliveryProgressFactory();
			newEntity.setDeliveryProgresses(Collections.singletonList(deliveryProgressesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Delivery Progresses here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnostic Staff Examination Summaries here] off begin
			// Outgoing one to many reference
			var diagnosticStaffExaminationSummariesFactory = new DiagnosticStaffExaminationSummaryFactory();
			newEntity.setDiagnosticStaffExaminationSummaries(Collections.singletonList(diagnosticStaffExaminationSummariesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnostic Staff Examination Summaries here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Dismissal Referring Staff here] off begin
			// Outgoing one to many reference
			var dismissalReferringStaffFactory = new RegistrationFactory();
			newEntity.setDismissalReferringStaff(Collections.singletonList(dismissalReferringStaffFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Dismissal Referring Staff here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Doctor Schedules here] off begin
			// Outgoing one to many reference
			var doctorSchedulesFactory = new DoctorScheduleFactory();
			newEntity.setDoctorSchedules(Collections.singletonList(doctorSchedulesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Doctor Schedules here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Doctor on examination here] off begin
			// Outgoing one to many reference
			var doctorOnExaminationFactory = new MedicalExaminationRecordFactory();
			newEntity.setDoctorOnExamination(Collections.singletonList(doctorOnExaminationFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Doctor on examination here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Fluid Balance Details here] off begin
			// Outgoing one to many reference
			var fluidBalanceDetailsFactory = new FluidBalanceDetailFactory();
			newEntity.setFluidBalanceDetails(Collections.singletonList(fluidBalanceDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Fluid Balance Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Hemodialysis Monitorings here] off begin
			// Outgoing one to many reference
			var hemodialysisMonitoringsFactory = new HemodialysisMonitoringFactory();
			newEntity.setHemodialysisMonitorings(Collections.singletonList(hemodialysisMonitoringsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Hemodialysis Monitorings here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Hospital Branch Informations here] off begin
			// Outgoing one to many reference
			var hospitalBranchInformationsFactory = new HospitalBranchInformationFactory();
			newEntity.setHospitalBranchInformations(Collections.singletonList(hospitalBranchInformationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Hospital Branch Informations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Informing Consents here] off begin
			// Outgoing one to many reference
			var informingConsentsFactory = new InformedConsentFactory();
			newEntity.setInformingConsents(Collections.singletonList(informingConsentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Informing Consents here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices here] off begin
			// Outgoing one to many reference
			var invoicesFactory = new InvoiceFactory();
			newEntity.setInvoices(Collections.singletonList(invoicesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoices here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany MCU Package Items here] off begin
			// Outgoing one to many reference
			var mcuPackageItemsFactory = new McuPackageItemFactory();
			newEntity.setMcuPackageItems(Collections.singletonList(mcuPackageItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany MCU Package Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Certificate  Discharge Resumes here] off begin
			// Outgoing one to many reference
			var medicalCertificateDischargeResumesFactory = new MedicalCertificateDischargeResumeFactory();
			newEntity.setMedicalCertificateDischargeResumes(Collections.singletonList(medicalCertificateDischargeResumesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Certificate  Discharge Resumes here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Certificate Births here] off begin
			// Outgoing one to many reference
			var medicalCertificateBirthsFactory = new MedicalCertificateBirthFactory();
			newEntity.setMedicalCertificateBirths(Collections.singletonList(medicalCertificateBirthsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Certificate Births here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Certificate Hospitalizations here] off begin
			// Outgoing one to many reference
			var medicalCertificateHospitalizationsFactory = new MedicalCertificateHospitalizationFactory();
			newEntity.setMedicalCertificateHospitalizations(Collections.singletonList(medicalCertificateHospitalizationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Certificate Hospitalizations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Examination Record Discharge Summarys here] off begin
			// Outgoing one to many reference
			var medicalExaminationRecordDischargeSummarysFactory = new MedicalExaminationRecordDischargeSummaryFactory();
			newEntity.setMedicalExaminationRecordDischargeSummarys(Collections.singletonList(medicalExaminationRecordDischargeSummarysFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Examination Record Discharge Summarys here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Record Transcriber here] off begin
			// Outgoing one to many reference
			var medicalRecordTranscriberFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalRecordTranscriber(Collections.singletonList(medicalRecordTranscriberFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Record Transcriber here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Medical Attendances certificate here] off begin
			// Outgoing one to many reference
			var medicalStaffOfMedicalAttendancesCertificateFactory = new MedicalCertificateMedicalAttendanceFactory();
			newEntity.setMedicalStaffOfMedicalAttendancesCertificate(Collections.singletonList(medicalStaffOfMedicalAttendancesCertificateFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Medical Attendances certificate here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Mental Healths here] off begin
			// Outgoing one to many reference
			var medicalStaffOfMentalHealthsFactory = new MedicalCertificateMentalHealthFactory();
			newEntity.setMedicalStaffOfMentalHealths(Collections.singletonList(medicalStaffOfMentalHealthsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Mental Healths here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Physical Healths here] off begin
			// Outgoing one to many reference
			var medicalStaffOfPhysicalHealthsFactory = new MedicalCertificatePhysicalHealthFactory();
			newEntity.setMedicalStaffOfPhysicalHealths(Collections.singletonList(medicalStaffOfPhysicalHealthsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Physical Healths here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Restricted Works certificate here] off begin
			// Outgoing one to many reference
			var medicalStaffOfRestrictedWorksCertificateFactory = new MedicalCertificateRestrictedWorkFactory();
			newEntity.setMedicalStaffOfRestrictedWorksCertificate(Collections.singletonList(medicalStaffOfRestrictedWorksCertificateFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Restricted Works certificate here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Sick Leaves certificate here] off begin
			// Outgoing one to many reference
			var medicalStaffOfSickLeavesCertificateFactory = new MedicalCertificateSickLeaveFactory();
			newEntity.setMedicalStaffOfSickLeavesCertificate(Collections.singletonList(medicalStaffOfSickLeavesCertificateFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Staff of Sick Leaves certificate here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Administered Hisotries here] off begin
			// Outgoing one to many reference
			var medicationAdministeredHisotriesFactory = new MedicationAdministeredHistoryFactory();
			newEntity.setMedicationAdministeredHisotries(Collections.singletonList(medicationAdministeredHisotriesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Administered Hisotries here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Headers here] off begin
			// Outgoing one to many reference
			var medicationHeadersFactory = new MedicationHeaderFactory();
			newEntity.setMedicationHeaders(Collections.singletonList(medicationHeadersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Headers here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Midwives here] off begin
			// Outgoing one to many reference
			var midwivesFactory = new DeliveryMedicalExaminationRecordFactory();
			newEntity.setMidwives(Collections.singletonList(midwivesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Midwives here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Nurse here] off begin
			// Outgoing one to many reference
			var nurseFactory = new MedicalExaminationRecordFactory();
			newEntity.setNurse(Collections.singletonList(nurseFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Nurse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Nursing Detail Surgical Nursing here] off begin
			// Outgoing one to many reference
			var nursingDetailSurgicalNursingFactory = new OperatingTheaterMedicalExaminationRecordFactory();
			newEntity.setNursingDetailSurgicalNursing(Collections.singletonList(nursingDetailSurgicalNursingFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Nursing Detail Surgical Nursing here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Nursing Details Anesthesia Nursing here] off begin
			// Outgoing one to many reference
			var nursingDetailsAnesthesiaNursingFactory = new OperatingTheaterMedicalExaminationRecordFactory();
			newEntity.setNursingDetailsAnesthesiaNursing(Collections.singletonList(nursingDetailsAnesthesiaNursingFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Nursing Details Anesthesia Nursing here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Consents here] off begin
			// Outgoing one to many reference
			var patientConsentsFactory = new PatientConsentFactory();
			newEntity.setPatientConsents(Collections.singletonList(patientConsentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Consents here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Vital Informations here] off begin
			// Outgoing one to many reference
			var patientVitalInformationsFactory = new PatientVitalInformationFactory();
			newEntity.setPatientVitalInformations(Collections.singletonList(patientVitalInformationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Vital Informations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Pediatrician In Charge here] off begin
			// Outgoing one to many reference
			var pediatricianInChargeFactory = new NewbornDetailFactory();
			newEntity.setPediatricianInCharge(Collections.singletonList(pediatricianInChargeFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Pediatrician In Charge here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Headers here] off begin
			// Outgoing one to many reference
			var prescriptionHeadersFactory = new PrescriptionHeaderFactory();
			newEntity.setPrescriptionHeaders(Collections.singletonList(prescriptionHeadersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Headers here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Process Workflow Logs here] off begin
			// Outgoing one to many reference
			var processWorkflowLogsFactory = new ProcessWorkflowFactory();
			newEntity.setProcessWorkflowLogs(Collections.singletonList(processWorkflowLogsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Process Workflow Logs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Registrations here] off begin
			// Outgoing one to many reference
			var registrationsFactory = new RegistrationFactory();
			newEntity.setRegistrations(Collections.singletonList(registrationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Registrations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Requested By here] off begin
			// Outgoing one to many reference
			var requestedByFactory = new RegistrationFactory();
			newEntity.setRequestedBy(Collections.singletonList(requestedByFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Requested By here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Room Transfers here] off begin
			// Outgoing one to many reference
			var roomTransfersFactory = new RoomTransferFactory();
			newEntity.setRoomTransfers(Collections.singletonList(roomTransfersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Room Transfers here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Collection Staffs here] off begin
			// Outgoing one to many reference
			var sampleCollectionStaffsFactory = new SampleCollectionItemsFactory();
			newEntity.setSampleCollectionStaffs(Collections.singletonList(sampleCollectionStaffsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Collection Staffs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Delivery Staffs here] off begin
			// Outgoing one to many reference
			var sampleDeliveryStaffsFactory = new SampleCollectionItemsFactory();
			newEntity.setSampleDeliveryStaffs(Collections.singletonList(sampleDeliveryStaffsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Delivery Staffs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Processing Staffs here] off begin
			// Outgoing one to many reference
			var sampleProcessingStaffsFactory = new SampleCollectionItemsFactory();
			newEntity.setSampleProcessingStaffs(Collections.singletonList(sampleProcessingStaffsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Processing Staffs here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Surgeon here] off begin
			// Outgoing one to many reference
			var surgeonFactory = new PreoperativeRecordsFactory();
			newEntity.setSurgeon(Collections.singletonList(surgeonFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Surgeon here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Surgical Medical Transcriber here] off begin
			// Outgoing one to many reference
			var surgicalMedicalTranscriberFactory = new PreoperativeRecordsFactory();
			newEntity.setSurgicalMedicalTranscriber(Collections.singletonList(surgicalMedicalTranscriberFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Surgical Medical Transcriber here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Surgical Nurse here] off begin
			// Outgoing one to many reference
			var surgicalNurseFactory = new PreoperativeRecordsFactory();
			newEntity.setSurgicalNurse(Collections.singletonList(surgicalNurseFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Surgical Nurse here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Transfer Order Stock Details here] off begin
			// Outgoing one to many reference
			var transferOrderStockDetailsFactory = new TransferOrderStockDetailFactory();
			newEntity.setTransferOrderStockDetails(Collections.singletonList(transferOrderStockDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Transfer Order Stock Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Vaccination Orders here] off begin
			// Outgoing one to many reference
			var vaccinationOrdersFactory = new VaccinationOrderFactory();
			newEntity.setVaccinationOrders(Collections.singletonList(vaccinationOrdersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Vaccination Orders here] end

			// % protected region % [Override the reference inclusion for outgoingManyToMany Services here] off begin
			// Outgoing many to many reference
			var servicesFactory = new ServiceFactory();
			newEntity.setServices(Collections.singletonList(servicesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingManyToMany Services here] end

		}

		// % protected region % [Apply any additional logic for staff with ref here] off begin
		// % protected region % [Apply any additional logic for staff with ref here] end

		return newEntity;
	}

	@Override
	public Class<StaffEntity> getObjectType() {
		return StaffEntity.class;
	}
}