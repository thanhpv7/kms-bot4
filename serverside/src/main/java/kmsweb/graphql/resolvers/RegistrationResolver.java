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

package kmsweb.graphql.resolvers;

import kmsweb.entities.*;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Component
public class RegistrationResolver implements GraphQLResolver<RegistrationEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('BpjsPRBDetailEntity', 'read')")
	public BpjsPRBDetailEntity bpjsPRBDetail(RegistrationEntity registration) {
		return registration.getBpjsPRBDetail();
	}

	@PreAuthorize("hasPermission('BpjsPcareRegistrationsEntity', 'read')")
	public BpjsPcareRegistrationsEntity bpjsPcareRegistrations(RegistrationEntity registration) {
		return registration.getBpjsPcareRegistrations();
	}

	@PreAuthorize("hasPermission('BpjsSEPEntity', 'read')")
	public BpjsSEPEntity bpjsSEP(RegistrationEntity registration) {
		return registration.getBpjsSEP();
	}

	@PreAuthorize("hasPermission('BedReserveEntity', 'read')")
	public Set<BedReserveEntity> bedReserves(RegistrationEntity registration) {
		return registration.getBedReserves();
	}

	@PreAuthorize("hasPermission('DiagnosticExaminationResultsEntity', 'read')")
	public Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults(RegistrationEntity registration) {
		return registration.getDiagnosticExaminationResults();
	}

	@PreAuthorize("hasPermission('FluidBalanceDetailEntity', 'read')")
	public Set<FluidBalanceDetailEntity> fluidBalanceDetails(RegistrationEntity registration) {
		return registration.getFluidBalanceDetails();
	}

	@PreAuthorize("hasPermission('InformedConsentEntity', 'read')")
	public Set<InformedConsentEntity> informedConsents(RegistrationEntity registration) {
		return registration.getInformedConsents();
	}

	@PreAuthorize("hasPermission('InvoiceItemEntity', 'read')")
	public Set<InvoiceItemEntity> invoiceItems(RegistrationEntity registration) {
		return registration.getInvoiceItems();
	}

	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	public MedicalCertificateDischargeResumeEntity medicalCertificateDischargeResume(RegistrationEntity registration) {
		return registration.getMedicalCertificateDischargeResume();
	}

	@PreAuthorize("hasPermission('MedicalCertificateBirthEntity', 'read')")
	public MedicalCertificateBirthEntity medicalCertificateBirth(RegistrationEntity registration) {
		return registration.getMedicalCertificateBirth();
	}

	@PreAuthorize("hasPermission('MedicalCertificateHospitalizationEntity', 'read')")
	public MedicalCertificateHospitalizationEntity medicalCertificateHospitalization(RegistrationEntity registration) {
		return registration.getMedicalCertificateHospitalization();
	}

	@PreAuthorize("hasPermission('MedicalCertificateMedicalAttendanceEntity', 'read')")
	public MedicalCertificateMedicalAttendanceEntity medicalCertificateMedicalAttendance(RegistrationEntity registration) {
		return registration.getMedicalCertificateMedicalAttendance();
	}

	@PreAuthorize("hasPermission('MedicalCertificateMentalHealthEntity', 'read')")
	public MedicalCertificateMentalHealthEntity medicalCertificateMentalHealth(RegistrationEntity registration) {
		return registration.getMedicalCertificateMentalHealth();
	}

	@PreAuthorize("hasPermission('MedicalCertificatePhysicalHealthEntity', 'read')")
	public MedicalCertificatePhysicalHealthEntity medicalCertificatePhysicalHealth(RegistrationEntity registration) {
		return registration.getMedicalCertificatePhysicalHealth();
	}

	@PreAuthorize("hasPermission('MedicalCertificateRestrictedWorkEntity', 'read')")
	public MedicalCertificateRestrictedWorkEntity medicalCertificateRestrictedWork(RegistrationEntity registration) {
		return registration.getMedicalCertificateRestrictedWork();
	}

	@PreAuthorize("hasPermission('MedicalCertificateSickLeaveEntity', 'read')")
	public MedicalCertificateSickLeaveEntity medicalCertificateSickLeave(RegistrationEntity registration) {
		return registration.getMedicalCertificateSickLeave();
	}

	@PreAuthorize("hasPermission('MedicalExaminationRecordEntity', 'read')")
	public MedicalExaminationRecordEntity medicalExaminationRecord(RegistrationEntity registration) {
		return registration.getMedicalExaminationRecord();
	}

	@PreAuthorize("hasPermission('MedicalFeeEntity', 'read')")
	public Set<MedicalFeeEntity> medicalFees(RegistrationEntity registration) {
		return registration.getMedicalFees();
	}

	@PreAuthorize("hasPermission('MedicationHeaderEntity', 'read')")
	public Set<MedicationHeaderEntity> medicationHeaders(RegistrationEntity registration) {
		return registration.getMedicationHeaders();
	}

	@PreAuthorize("hasPermission('PcareExaminationEntity', 'read')")
	public PcareExaminationEntity pcareExamination(RegistrationEntity registration) {
		return registration.getPcareExamination();
	}

	@PreAuthorize("hasPermission('PatientVitalInformationEntity', 'read')")
	public Set<PatientVitalInformationEntity> patientVitalInformations(RegistrationEntity registration) {
		return registration.getPatientVitalInformations();
	}

	@PreAuthorize("hasPermission('PrescriptionHeaderEntity', 'read')")
	public Set<PrescriptionHeaderEntity> prescriptionHeaders(RegistrationEntity registration) {
		return registration.getPrescriptionHeaders();
	}

	@PreAuthorize("hasPermission('SepEntity', 'read')")
	public SepEntity sep(RegistrationEntity registration) {
		return registration.getSep();
	}

	@PreAuthorize("hasPermission('SampleCollectionInformationEntity', 'read')")
	public Set<SampleCollectionInformationEntity> sampleCollectionInformations(RegistrationEntity registration) {
		return registration.getSampleCollectionInformations();
	}

	@PreAuthorize("hasPermission('VaccinationOrderEntity', 'read')")
	public Set<VaccinationOrderEntity> vaccinationOrders(RegistrationEntity registration) {
		return registration.getVaccinationOrders();
	}

	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'read')")
	public DiagnosesAndProceduresEntity admissionICD10(RegistrationEntity registration) {
		return registration.getAdmissionICD10();
	}

	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'read')")
	public DiagnosesAndProceduresEntity admissionICD9CM(RegistrationEntity registration) {
		return registration.getAdmissionICD9CM();
	}

	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	public HealthFacilityEntity dismissalReferringFacility(RegistrationEntity registration) {
		return registration.getDismissalReferringFacility();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity dismissalReferringStaff(RegistrationEntity registration) {
		return registration.getDismissalReferringStaff();
	}

	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	public ServiceEntity referringUnit(RegistrationEntity registration) {
		return registration.getReferringUnit();
	}

	@PreAuthorize("hasPermission('HealthFacilityEntity', 'read')")
	public HealthFacilityEntity referringFacility(RegistrationEntity registration) {
		return registration.getReferringFacility();
	}

	@PreAuthorize("hasPermission('DiagnosticStaffExaminationSummaryEntity', 'read')")
	public DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummary(RegistrationEntity registration) {
		return registration.getDiagnosticStaffExaminationSummary();
	}

	@PreAuthorize("hasPermission('BedFacilityEntity', 'read')")
	public BedFacilityEntity bedFacility(RegistrationEntity registration) {
		return registration.getBedFacility();
	}

	@PreAuthorize("hasPermission('ExaminationItemEntity', 'read')")
	public Set<ExaminationItemEntity> examinationItems(RegistrationEntity registration) {
		return registration.getExaminationItems();
	}

	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	public PatientVisitEntity patientVisit(RegistrationEntity registration) {
		return registration.getPatientVisit();
	}

	@PreAuthorize("hasPermission('ServiceEntity', 'read')")
	public ServiceEntity service(RegistrationEntity registration) {
		return registration.getService();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity staff(RegistrationEntity registration) {
		return registration.getStaff();
	}

	@PreAuthorize("hasPermission('StaffEntity', 'read')")
	public StaffEntity requestedBy(RegistrationEntity registration) {
		return registration.getRequestedBy();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
