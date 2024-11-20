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
import kmsweb.entities.RegistrationEntity;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.StringType;
import kmsweb.entities.enums.*;

import java.time.OffsetDateTime;
import java.util.*;

public class RegistrationFactory implements FactoryBean<RegistrationEntity> {

	MockNeat mockNeat = MockNeat.threadLocal();

	/**
	 * Defaults {@code includeReferences} to false and  {@code includeIds} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	@Override
	public RegistrationEntity getObject() throws Exception {
		return getObject(false, true);
	}

	/**
	 * Defaults {@code includeReferences} to true {@link #getObject(boolean, boolean)}.
	 *
	 * @see #getObject(boolean, boolean)
	 */
	public RegistrationEntity getObjectWithReferences(boolean includeIds) throws Exception {
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
	public RegistrationEntity getObject(boolean includeReferences, boolean includeId) throws Exception {
		// % protected region % [Apply any additional logic for registrationWithNoRef before the main body here] off begin
		// % protected region % [Apply any additional logic for registrationWithNoRef before the main body here] end

		RegistrationEntity newEntity = new RegistrationEntity();
		if (includeId) {
			newEntity.setId(UUID.randomUUID());
		}
		newEntity.setCreated(OffsetDateTime.now());
		newEntity.setModified(OffsetDateTime.now());
		// % protected region % [Add customisation for Registration Number here] off begin
		String randomStringForRegistrationNumber = mockNeat
				.strings()
				.get();
		newEntity.setRegistrationNumber(randomStringForRegistrationNumber);
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
		String randomStringForDismissalType = mockNeat
				.strings()
				.get();
		newEntity.setDismissalType(randomStringForDismissalType);
		// % protected region % [Add customisation for Dismissal Type here] end
		// % protected region % [Add customisation for Queue No here] off begin
		newEntity.setQueueNo(mockNeat.ints().get());
		// % protected region % [Add customisation for Queue No here] end
		// % protected region % [Add customisation for Duration here] off begin
		newEntity.setDuration(mockNeat.ints().get());
		// % protected region % [Add customisation for Duration here] end
		// % protected region % [Add customisation for Treatment Class here] off begin
		String randomStringForTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setTreatmentClass(randomStringForTreatmentClass);
		// % protected region % [Add customisation for Treatment Class here] end
		// % protected region % [Add customisation for Booked Treatment Class here] off begin
		String randomStringForBookedTreatmentClass = mockNeat
				.strings()
				.get();
		newEntity.setBookedTreatmentClass(randomStringForBookedTreatmentClass);
		// % protected region % [Add customisation for Booked Treatment Class here] end
		// % protected region % [Add customisation for Shift here] off begin
		String randomStringForShift = mockNeat
				.strings()
				.get();
		newEntity.setShift(randomStringForShift);
		// % protected region % [Add customisation for Shift here] end
		// % protected region % [Add customisation for CITO here] off begin
		newEntity.setCito(mockNeat.bools().get());
		// % protected region % [Add customisation for CITO here] end
		// % protected region % [Add customisation for One Day Care here] off begin
		newEntity.setOneDayCare(mockNeat.bools().get());
		// % protected region % [Add customisation for One Day Care here] end
		// % protected region % [Add customisation for Referral here] off begin
		newEntity.setReferral(mockNeat.bools().get());
		// % protected region % [Add customisation for Referral here] end
		// % protected region % [Add customisation for Registration Status here] off begin
		String randomStringForRegistrationStatus = mockNeat
				.strings()
				.get();
		newEntity.setRegistrationStatus(randomStringForRegistrationStatus);
		// % protected region % [Add customisation for Registration Status here] end
		// % protected region % [Add customisation for Referral Type here] off begin
		String randomStringForReferralType = mockNeat
				.strings()
				.get();
		newEntity.setReferralType(randomStringForReferralType);
		// % protected region % [Add customisation for Referral Type here] end
		// % protected region % [Add customisation for Purpose here] off begin
		String randomStringForPurpose = mockNeat
				.strings()
				.get();
		newEntity.setPurpose(randomStringForPurpose);
		// % protected region % [Add customisation for Purpose here] end
		// % protected region % [Add customisation for Referral Notes here] off begin
		String randomStringForReferralNotes = mockNeat
				.strings()
				.get();
		newEntity.setReferralNotes(randomStringForReferralNotes);
		// % protected region % [Add customisation for Referral Notes here] end
		// % protected region % [Add customisation for Supporting Document here] off begin
		// % protected region % [Add customisation for Supporting Document here] end
		// % protected region % [Add customisation for Admission Diagnosis here] off begin
		String randomStringForAdmissionDiagnosis = mockNeat
				.strings()
				.get();
		newEntity.setAdmissionDiagnosis(randomStringForAdmissionDiagnosis);
		// % protected region % [Add customisation for Admission Diagnosis here] end
		// % protected region % [Add customisation for Print Wristband here] off begin
		// % protected region % [Add customisation for Print Wristband here] end
		// % protected region % [Add customisation for Print Label here] off begin
		// % protected region % [Add customisation for Print Label here] end
		// % protected region % [Add customisation for Uploaded Date Time here] off begin
		newEntity.setUploadedDateTime(OffsetDateTime.now());
		// % protected region % [Add customisation for Uploaded Date Time here] end
		// % protected region % [Add customisation for Visit Status here] off begin
		String randomStringForVisitStatus = mockNeat
				.strings()
				.get();
		newEntity.setVisitStatus(randomStringForVisitStatus);
		// % protected region % [Add customisation for Visit Status here] end
		// % protected region % [Add customisation for Instruction here] off begin
		String randomStringForInstruction = mockNeat
				.strings()
				.get();
		newEntity.setInstruction(randomStringForInstruction);
		// % protected region % [Add customisation for Instruction here] end
		// % protected region % [Add customisation for is An Appointment here] off begin
		newEntity.setIsAnAppointment(mockNeat.bools().get());
		// % protected region % [Add customisation for is An Appointment here] end
		// % protected region % [Add customisation for Referral Number here] off begin
		String randomStringForReferralNumber = mockNeat
				.strings()
				.get();
		newEntity.setReferralNumber(randomStringForReferralNumber);
		// % protected region % [Add customisation for Referral Number here] end
		// % protected region % [Add customisation for Notes here] off begin
		String randomStringForNotes = mockNeat
				.strings()
				.get();
		newEntity.setNotes(randomStringForNotes);
		// % protected region % [Add customisation for Notes here] end
		// % protected region % [Add customisation for kodepoli here] off begin
		String randomStringForKodepoli = mockNeat
				.strings()
				.get();
		newEntity.setKodepoli(randomStringForKodepoli);
		// % protected region % [Add customisation for kodepoli here] end
		// % protected region % [Add customisation for Death Certificate No here] off begin
		String randomStringForDeathCertificateNo = mockNeat
				.strings()
				.get();
		newEntity.setDeathCertificateNo(randomStringForDeathCertificateNo);
		// % protected region % [Add customisation for Death Certificate No here] end
		// % protected region % [Add customisation for Time Of Death here] off begin
		newEntity.setTimeOfDeath(OffsetDateTime.now());
		// % protected region % [Add customisation for Time Of Death here] end
		// % protected region % [Add customisation for Dismissal Referral here] off begin
		newEntity.setDismissalReferral(mockNeat.bools().get());
		// % protected region % [Add customisation for Dismissal Referral here] end
		// % protected region % [Add customisation for Dismissal Referral Detail here] off begin
		String randomStringForDismissalReferralDetail = mockNeat
				.strings()
				.get();
		newEntity.setDismissalReferralDetail(randomStringForDismissalReferralDetail);
		// % protected region % [Add customisation for Dismissal Referral Detail here] end
		// % protected region % [Add customisation for Dismissal Referral Type here] off begin
		String randomStringForDismissalReferralType = mockNeat
				.strings()
				.get();
		newEntity.setDismissalReferralType(randomStringForDismissalReferralType);
		// % protected region % [Add customisation for Dismissal Referral Type here] end
		// % protected region % [Add customisation for Dismissal Referring Notes here] off begin
		String randomStringForDismissalReferringNotes = mockNeat
				.strings()
				.get();
		newEntity.setDismissalReferringNotes(randomStringForDismissalReferringNotes);
		// % protected region % [Add customisation for Dismissal Referring Notes here] end
		// % protected region % [Add customisation for Patient Is Referred Back here] off begin
		newEntity.setPatientIsReferredBack(mockNeat.bools().get());
		// % protected region % [Add customisation for Patient Is Referred Back here] end
		// % protected region % [Add customisation for MCU Package here] off begin
		String randomStringForMcuPackage = mockNeat
				.strings()
				.get();
		newEntity.setMcuPackage(randomStringForMcuPackage);
		// % protected region % [Add customisation for MCU Package here] end
		// % protected region % [Add customisation for Parent Registration Number here] off begin
		String randomStringForParentRegistrationNumber = mockNeat
				.strings()
				.get();
		newEntity.setParentRegistrationNumber(randomStringForParentRegistrationNumber);
		// % protected region % [Add customisation for Parent Registration Number here] end
		// % protected region % [Add customisation for Is Unknown Patient here] off begin
		newEntity.setIsUnknownPatient(mockNeat.bools().get());
		// % protected region % [Add customisation for Is Unknown Patient here] end
		// % protected region % [Add customisation for Other Referred Facility here] off begin
		String randomStringForOtherReferredFacility = mockNeat
				.strings()
				.get();
		newEntity.setOtherReferredFacility(randomStringForOtherReferredFacility);
		// % protected region % [Add customisation for Other Referred Facility here] end
		// % protected region % [Add customisation for Other Referred Staff here] off begin
		String randomStringForOtherReferredStaff = mockNeat
				.strings()
				.get();
		newEntity.setOtherReferredStaff(randomStringForOtherReferredStaff);
		// % protected region % [Add customisation for Other Referred Staff here] end
		// % protected region % [Add customisation for Doctor Schedule Detail Id here] off begin
		String randomStringForDoctorScheduleDetailId = mockNeat
				.strings()
				.get();
		newEntity.setDoctorScheduleDetailId(randomStringForDoctorScheduleDetailId);
		// % protected region % [Add customisation for Doctor Schedule Detail Id here] end

		// % protected region % [Apply any additional logic for registrationWithNoRef after the main body here] off begin
		// % protected region % [Apply any additional logic for registrationWithNoRef after the main body here] end


		if (includeReferences) {
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnostic Staff Examination Summary here] off begin
			// Incoming One to One reference
			var diagnosticStaffExaminationSummaryFactory = new DiagnosticStaffExaminationSummaryFactory();
			newEntity.setDiagnosticStaffExaminationSummary(diagnosticStaffExaminationSummaryFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToOne Diagnostic Staff Examination Summary here] end
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS PRB Detail] off begin
			// Outgoing one to one reference
			var bpjsPRBDetailFactory = new BpjsPRBDetailFactory();
			newEntity.setBpjsPRBDetail(bpjsPRBDetailFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS PRB Detail] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Pcare Registrations] off begin
			// Outgoing one to one reference
			var bpjsPcareRegistrationsFactory = new BpjsPcareRegistrationsFactory();
			newEntity.setBpjsPcareRegistrations(bpjsPcareRegistrationsFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS Pcare Registrations] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS SEP] off begin
			// Outgoing one to one reference
			var bpjsSEPFactory = new BpjsSEPFactory();
			newEntity.setBpjsSEP(bpjsSEPFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne BPJS SEP] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate  Discharge Resume] off begin
			// Outgoing one to one reference
			var medicalCertificateDischargeResumeFactory = new MedicalCertificateDischargeResumeFactory();
			newEntity.setMedicalCertificateDischargeResume(medicalCertificateDischargeResumeFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate  Discharge Resume] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Birth] off begin
			// Outgoing one to one reference
			var medicalCertificateBirthFactory = new MedicalCertificateBirthFactory();
			newEntity.setMedicalCertificateBirth(medicalCertificateBirthFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Birth] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Hospitalization] off begin
			// Outgoing one to one reference
			var medicalCertificateHospitalizationFactory = new MedicalCertificateHospitalizationFactory();
			newEntity.setMedicalCertificateHospitalization(medicalCertificateHospitalizationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Hospitalization] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Medical Attendance] off begin
			// Outgoing one to one reference
			var medicalCertificateMedicalAttendanceFactory = new MedicalCertificateMedicalAttendanceFactory();
			newEntity.setMedicalCertificateMedicalAttendance(medicalCertificateMedicalAttendanceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Medical Attendance] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Mental Health] off begin
			// Outgoing one to one reference
			var medicalCertificateMentalHealthFactory = new MedicalCertificateMentalHealthFactory();
			newEntity.setMedicalCertificateMentalHealth(medicalCertificateMentalHealthFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Mental Health] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Physical Health] off begin
			// Outgoing one to one reference
			var medicalCertificatePhysicalHealthFactory = new MedicalCertificatePhysicalHealthFactory();
			newEntity.setMedicalCertificatePhysicalHealth(medicalCertificatePhysicalHealthFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Physical Health] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Restricted Work] off begin
			// Outgoing one to one reference
			var medicalCertificateRestrictedWorkFactory = new MedicalCertificateRestrictedWorkFactory();
			newEntity.setMedicalCertificateRestrictedWork(medicalCertificateRestrictedWorkFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Restricted Work] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Sick Leave] off begin
			// Outgoing one to one reference
			var medicalCertificateSickLeaveFactory = new MedicalCertificateSickLeaveFactory();
			newEntity.setMedicalCertificateSickLeave(medicalCertificateSickLeaveFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Certificate Sick Leave] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Examination Record] off begin
			// Outgoing one to one reference
			var medicalExaminationRecordFactory = new MedicalExaminationRecordFactory();
			newEntity.setMedicalExaminationRecord(medicalExaminationRecordFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne Medical Examination Record] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne PCare Examination] off begin
			// Outgoing one to one reference
			var pcareExaminationFactory = new PcareExaminationFactory();
			newEntity.setPcareExamination(pcareExaminationFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne PCare Examination] end

			// % protected region % [Override the reference inclusions for outgoingOneToOne SEP] off begin
			// Outgoing one to one reference
			var sepFactory = new SepFactory();
			newEntity.setSep(sepFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for outgoingOneToOne SEP] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAdmission ICD 10 here] off begin
			var admissionICD10Factory = new DiagnosesAndProceduresFactory();
			newEntity.setAdmissionICD10(admissionICD10Factory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAdmission ICD 10 here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyAdmission ICD 9 CM here] off begin
			var admissionICD9CMFactory = new DiagnosesAndProceduresFactory();
			newEntity.setAdmissionICD9CM(admissionICD9CMFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyAdmission ICD 9 CM here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDismissal Referring Facility here] off begin
			var dismissalReferringFacilityFactory = new HealthFacilityFactory();
			newEntity.setDismissalReferringFacility(dismissalReferringFacilityFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDismissal Referring Facility here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyDismissal Referring Staff here] off begin
			var dismissalReferringStaffFactory = new StaffFactory();
			newEntity.setDismissalReferringStaff(dismissalReferringStaffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyDismissal Referring Staff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyReferring Unit here] off begin
			var referringUnitFactory = new ServiceFactory();
			newEntity.setReferringUnit(referringUnitFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyReferring Unit here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyReferring facility here] off begin
			var referringFacilityFactory = new HealthFacilityFactory();
			newEntity.setReferringFacility(referringFacilityFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyReferring facility here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyBed Facility here] off begin
			var bedFacilityFactory = new BedFacilityFactory();
			newEntity.setBedFacility(bedFacilityFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyBed Facility here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Visit here] off begin
			var patientVisitFactory = new PatientVisitFactory();
			newEntity.setPatientVisit(patientVisitFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyPatient Visit here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyService here] off begin
			var serviceFactory = new ServiceFactory();
			newEntity.setService(serviceFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyService here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] off begin
			var staffFactory = new StaffFactory();
			newEntity.setStaff(staffFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyStaff here] end

			// Incoming One to Many reference
			// % protected region % [Override the reference inclusions for incomingOneToManyRequested By here] off begin
			var requestedByFactory = new StaffFactory();
			newEntity.setRequestedBy(requestedByFactory.getObject(false, includeId), false);
			// % protected region % [Override the reference inclusions for incomingOneToManyRequested By here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Reserves here] off begin
			// Outgoing one to many reference
			var bedReservesFactory = new BedReserveFactory();
			newEntity.setBedReserves(Collections.singletonList(bedReservesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Bed Reserves here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnostic Examination Results here] off begin
			// Outgoing one to many reference
			var diagnosticExaminationResultsFactory = new DiagnosticExaminationResultsFactory();
			newEntity.setDiagnosticExaminationResults(Collections.singletonList(diagnosticExaminationResultsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Diagnostic Examination Results here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Fluid Balance Details here] off begin
			// Outgoing one to many reference
			var fluidBalanceDetailsFactory = new FluidBalanceDetailFactory();
			newEntity.setFluidBalanceDetails(Collections.singletonList(fluidBalanceDetailsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Fluid Balance Details here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Informed Consents here] off begin
			// Outgoing one to many reference
			var informedConsentsFactory = new InformedConsentFactory();
			newEntity.setInformedConsents(Collections.singletonList(informedConsentsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Informed Consents here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] off begin
			// Outgoing one to many reference
			var invoiceItemsFactory = new InvoiceItemFactory();
			newEntity.setInvoiceItems(Collections.singletonList(invoiceItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Invoice Items here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Fees here] off begin
			// Outgoing one to many reference
			var medicalFeesFactory = new MedicalFeeFactory();
			newEntity.setMedicalFees(Collections.singletonList(medicalFeesFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medical Fees here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Headers here] off begin
			// Outgoing one to many reference
			var medicationHeadersFactory = new MedicationHeaderFactory();
			newEntity.setMedicationHeaders(Collections.singletonList(medicationHeadersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Medication Headers here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Vital Informations here] off begin
			// Outgoing one to many reference
			var patientVitalInformationsFactory = new PatientVitalInformationFactory();
			newEntity.setPatientVitalInformations(Collections.singletonList(patientVitalInformationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Patient Vital Informations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Headers here] off begin
			// Outgoing one to many reference
			var prescriptionHeadersFactory = new PrescriptionHeaderFactory();
			newEntity.setPrescriptionHeaders(Collections.singletonList(prescriptionHeadersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Prescription Headers here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Collection Informations here] off begin
			// Outgoing one to many reference
			var sampleCollectionInformationsFactory = new SampleCollectionInformationFactory();
			newEntity.setSampleCollectionInformations(Collections.singletonList(sampleCollectionInformationsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Sample Collection Informations here] end

			// % protected region % [Override the reference inclusion for outgoingOneToMany Vaccination Orders here] off begin
			// Outgoing one to many reference
			var vaccinationOrdersFactory = new VaccinationOrderFactory();
			newEntity.setVaccinationOrders(Collections.singletonList(vaccinationOrdersFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusion for outgoingOneToMany Vaccination Orders here] end

			// % protected region % [Override the reference inclusions for incomingManyToMany Examination Items] off begin
			// Incoming many to many reference
			var examinationItemsFactory = new ExaminationItemFactory();
			newEntity.setExaminationItems(Collections.singletonList(examinationItemsFactory.getObject(false, includeId)), false);
			// % protected region % [Override the reference inclusions for incomingManyToMany Examination Items] end

		}

		// % protected region % [Apply any additional logic for registration with ref here] off begin
		// % protected region % [Apply any additional logic for registration with ref here] end

		return newEntity;
	}

	@Override
	public Class<RegistrationEntity> getObjectType() {
		return RegistrationEntity.class;
	}
}