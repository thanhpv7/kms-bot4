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

package kmsweb.graphql.resolvers.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kmsweb.entities.RegistrationEntity;
import kmsweb.services.RegistrationService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsPRBDetailService;
import kmsweb.entities.BpjsPRBDetailEntity;
import kmsweb.services.BpjsPcareRegistrationsService;
import kmsweb.entities.BpjsPcareRegistrationsEntity;
import kmsweb.services.BpjsSEPService;
import kmsweb.entities.BpjsSEPEntity;
import kmsweb.services.BedFacilityService;
import kmsweb.entities.BedFacilityEntity;
import kmsweb.services.BedReserveService;
import kmsweb.entities.BedReserveEntity;
import kmsweb.services.DiagnosesAndProceduresService;
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.services.DiagnosticExaminationResultsService;
import kmsweb.entities.DiagnosticExaminationResultsEntity;
import kmsweb.services.DiagnosticStaffExaminationSummaryService;
import kmsweb.entities.DiagnosticStaffExaminationSummaryEntity;
import kmsweb.services.ExaminationItemService;
import kmsweb.entities.ExaminationItemEntity;
import kmsweb.services.FluidBalanceDetailService;
import kmsweb.entities.FluidBalanceDetailEntity;
import kmsweb.services.HealthFacilityService;
import kmsweb.entities.HealthFacilityEntity;
import kmsweb.services.InformedConsentService;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.services.InvoiceItemService;
import kmsweb.entities.InvoiceItemEntity;
import kmsweb.services.MedicalCertificateDischargeResumeService;
import kmsweb.entities.MedicalCertificateDischargeResumeEntity;
import kmsweb.services.MedicalCertificateBirthService;
import kmsweb.entities.MedicalCertificateBirthEntity;
import kmsweb.services.MedicalCertificateHospitalizationService;
import kmsweb.entities.MedicalCertificateHospitalizationEntity;
import kmsweb.services.MedicalCertificateMedicalAttendanceService;
import kmsweb.entities.MedicalCertificateMedicalAttendanceEntity;
import kmsweb.services.MedicalCertificateMentalHealthService;
import kmsweb.entities.MedicalCertificateMentalHealthEntity;
import kmsweb.services.MedicalCertificatePhysicalHealthService;
import kmsweb.entities.MedicalCertificatePhysicalHealthEntity;
import kmsweb.services.MedicalCertificateRestrictedWorkService;
import kmsweb.entities.MedicalCertificateRestrictedWorkEntity;
import kmsweb.services.MedicalCertificateSickLeaveService;
import kmsweb.entities.MedicalCertificateSickLeaveEntity;
import kmsweb.services.MedicalExaminationRecordService;
import kmsweb.entities.MedicalExaminationRecordEntity;
import kmsweb.services.MedicalFeeService;
import kmsweb.entities.MedicalFeeEntity;
import kmsweb.services.MedicationHeaderService;
import kmsweb.entities.MedicationHeaderEntity;
import kmsweb.services.PcareExaminationService;
import kmsweb.entities.PcareExaminationEntity;
import kmsweb.services.PatientVisitService;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.services.PatientVitalInformationService;
import kmsweb.entities.PatientVitalInformationEntity;
import kmsweb.services.PrescriptionHeaderService;
import kmsweb.entities.PrescriptionHeaderEntity;
import kmsweb.services.SepService;
import kmsweb.entities.SepEntity;
import kmsweb.services.SampleCollectionInformationService;
import kmsweb.entities.SampleCollectionInformationEntity;
import kmsweb.services.ServiceService;
import kmsweb.entities.ServiceEntity;
import kmsweb.services.StaffService;
import kmsweb.entities.StaffEntity;
import kmsweb.services.VaccinationOrderService;
import kmsweb.entities.VaccinationOrderEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class RegistrationMutationResolver implements GraphQLMutationResolver {

	private final RegistrationService registrationService;

	private final BpjsPRBDetailService bpjsPRBDetailService;

	private final BpjsPcareRegistrationsService bpjsPcareRegistrationsService;

	private final BpjsSEPService bpjsSEPService;

	private final BedFacilityService bedFacilityService;

	private final BedReserveService bedReserveService;

	private final DiagnosesAndProceduresService diagnosesAndProceduresService;

	private final DiagnosticExaminationResultsService diagnosticExaminationResultsService;

	private final DiagnosticStaffExaminationSummaryService diagnosticStaffExaminationSummaryService;

	private final ExaminationItemService examinationItemService;

	private final FluidBalanceDetailService fluidBalanceDetailService;

	private final HealthFacilityService healthFacilityService;

	private final InformedConsentService informedConsentService;

	private final InvoiceItemService invoiceItemService;

	private final MedicalCertificateDischargeResumeService medicalCertificateDischargeResumeService;

	private final MedicalCertificateBirthService medicalCertificateBirthService;

	private final MedicalCertificateHospitalizationService medicalCertificateHospitalizationService;

	private final MedicalCertificateMedicalAttendanceService medicalCertificateMedicalAttendanceService;

	private final MedicalCertificateMentalHealthService medicalCertificateMentalHealthService;

	private final MedicalCertificatePhysicalHealthService medicalCertificatePhysicalHealthService;

	private final MedicalCertificateRestrictedWorkService medicalCertificateRestrictedWorkService;

	private final MedicalCertificateSickLeaveService medicalCertificateSickLeaveService;

	private final MedicalExaminationRecordService medicalExaminationRecordService;

	private final MedicalFeeService medicalFeeService;

	private final MedicationHeaderService medicationHeaderService;

	private final PcareExaminationService pcareExaminationService;

	private final PatientVisitService patientVisitService;

	private final PatientVitalInformationService patientVitalInformationService;

	private final PrescriptionHeaderService prescriptionHeaderService;

	private final SepService sepService;

	private final SampleCollectionInformationService sampleCollectionInformationService;

	private final ServiceService serviceService;

	private final StaffService staffService;

	private final VaccinationOrderService vaccinationOrderService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public RegistrationMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsPRBDetailService bpjsPRBDetailService,
			BpjsPcareRegistrationsService bpjsPcareRegistrationsService,
			BpjsSEPService bpjsSEPService,
			BedFacilityService bedFacilityService,
			BedReserveService bedReserveService,
			DiagnosesAndProceduresService diagnosesAndProceduresService,
			DiagnosticExaminationResultsService diagnosticExaminationResultsService,
			DiagnosticStaffExaminationSummaryService diagnosticStaffExaminationSummaryService,
			ExaminationItemService examinationItemService,
			FluidBalanceDetailService fluidBalanceDetailService,
			HealthFacilityService healthFacilityService,
			InformedConsentService informedConsentService,
			InvoiceItemService invoiceItemService,
			MedicalCertificateDischargeResumeService medicalCertificateDischargeResumeService,
			MedicalCertificateBirthService medicalCertificateBirthService,
			MedicalCertificateHospitalizationService medicalCertificateHospitalizationService,
			MedicalCertificateMedicalAttendanceService medicalCertificateMedicalAttendanceService,
			MedicalCertificateMentalHealthService medicalCertificateMentalHealthService,
			MedicalCertificatePhysicalHealthService medicalCertificatePhysicalHealthService,
			MedicalCertificateRestrictedWorkService medicalCertificateRestrictedWorkService,
			MedicalCertificateSickLeaveService medicalCertificateSickLeaveService,
			MedicalExaminationRecordService medicalExaminationRecordService,
			MedicalFeeService medicalFeeService,
			MedicationHeaderService medicationHeaderService,
			PcareExaminationService pcareExaminationService,
			PatientVisitService patientVisitService,
			PatientVitalInformationService patientVitalInformationService,
			PrescriptionHeaderService prescriptionHeaderService,
			SepService sepService,
			SampleCollectionInformationService sampleCollectionInformationService,
			ServiceService serviceService,
			StaffService staffService,
			VaccinationOrderService vaccinationOrderService,
			RegistrationService registrationService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.registrationService = registrationService;

		this.bpjsPRBDetailService = bpjsPRBDetailService;

		this.bpjsPcareRegistrationsService = bpjsPcareRegistrationsService;

		this.bpjsSEPService = bpjsSEPService;

		this.bedFacilityService = bedFacilityService;

		this.bedReserveService = bedReserveService;

		this.diagnosesAndProceduresService = diagnosesAndProceduresService;

		this.diagnosticExaminationResultsService = diagnosticExaminationResultsService;

		this.diagnosticStaffExaminationSummaryService = diagnosticStaffExaminationSummaryService;

		this.examinationItemService = examinationItemService;

		this.fluidBalanceDetailService = fluidBalanceDetailService;

		this.healthFacilityService = healthFacilityService;

		this.informedConsentService = informedConsentService;

		this.invoiceItemService = invoiceItemService;

		this.medicalCertificateDischargeResumeService = medicalCertificateDischargeResumeService;

		this.medicalCertificateBirthService = medicalCertificateBirthService;

		this.medicalCertificateHospitalizationService = medicalCertificateHospitalizationService;

		this.medicalCertificateMedicalAttendanceService = medicalCertificateMedicalAttendanceService;

		this.medicalCertificateMentalHealthService = medicalCertificateMentalHealthService;

		this.medicalCertificatePhysicalHealthService = medicalCertificatePhysicalHealthService;

		this.medicalCertificateRestrictedWorkService = medicalCertificateRestrictedWorkService;

		this.medicalCertificateSickLeaveService = medicalCertificateSickLeaveService;

		this.medicalExaminationRecordService = medicalExaminationRecordService;

		this.medicalFeeService = medicalFeeService;

		this.medicationHeaderService = medicationHeaderService;

		this.pcareExaminationService = pcareExaminationService;

		this.patientVisitService = patientVisitService;

		this.patientVitalInformationService = patientVitalInformationService;

		this.prescriptionHeaderService = prescriptionHeaderService;

		this.sepService = sepService;

		this.sampleCollectionInformationService = sampleCollectionInformationService;

		this.serviceService = serviceService;

		this.staffService = staffService;

		this.vaccinationOrderService = vaccinationOrderService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'create')")
	public RegistrationEntity createRegistration(@NonNull RegistrationEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosticStaffExaminationSummary() != null) {
			rawEntity.setDiagnosticStaffExaminationSummary(diagnosticStaffExaminationSummaryService.updateOldData(rawEntity.getDiagnosticStaffExaminationSummary()));
		}

		if (rawEntity.getBpjsPRBDetail() != null) {
			rawEntity.setBpjsPRBDetail(bpjsPRBDetailService.updateOldData(rawEntity.getBpjsPRBDetail()));
		}

		if (rawEntity.getBpjsPcareRegistrations() != null) {
			rawEntity.setBpjsPcareRegistrations(bpjsPcareRegistrationsService.updateOldData(rawEntity.getBpjsPcareRegistrations()));
		}

		if (rawEntity.getBpjsSEP() != null) {
			rawEntity.setBpjsSEP(bpjsSEPService.updateOldData(rawEntity.getBpjsSEP()));
		}

		if (rawEntity.getMedicalCertificateDischargeResume() != null) {
			rawEntity.setMedicalCertificateDischargeResume(medicalCertificateDischargeResumeService.updateOldData(rawEntity.getMedicalCertificateDischargeResume()));
		}

		if (rawEntity.getMedicalCertificateBirth() != null) {
			rawEntity.setMedicalCertificateBirth(medicalCertificateBirthService.updateOldData(rawEntity.getMedicalCertificateBirth()));
		}

		if (rawEntity.getMedicalCertificateHospitalization() != null) {
			rawEntity.setMedicalCertificateHospitalization(medicalCertificateHospitalizationService.updateOldData(rawEntity.getMedicalCertificateHospitalization()));
		}

		if (rawEntity.getMedicalCertificateMedicalAttendance() != null) {
			rawEntity.setMedicalCertificateMedicalAttendance(medicalCertificateMedicalAttendanceService.updateOldData(rawEntity.getMedicalCertificateMedicalAttendance()));
		}

		if (rawEntity.getMedicalCertificateMentalHealth() != null) {
			rawEntity.setMedicalCertificateMentalHealth(medicalCertificateMentalHealthService.updateOldData(rawEntity.getMedicalCertificateMentalHealth()));
		}

		if (rawEntity.getMedicalCertificatePhysicalHealth() != null) {
			rawEntity.setMedicalCertificatePhysicalHealth(medicalCertificatePhysicalHealthService.updateOldData(rawEntity.getMedicalCertificatePhysicalHealth()));
		}

		if (rawEntity.getMedicalCertificateRestrictedWork() != null) {
			rawEntity.setMedicalCertificateRestrictedWork(medicalCertificateRestrictedWorkService.updateOldData(rawEntity.getMedicalCertificateRestrictedWork()));
		}

		if (rawEntity.getMedicalCertificateSickLeave() != null) {
			rawEntity.setMedicalCertificateSickLeave(medicalCertificateSickLeaveService.updateOldData(rawEntity.getMedicalCertificateSickLeave()));
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		if (rawEntity.getPcareExamination() != null) {
			rawEntity.setPcareExamination(pcareExaminationService.updateOldData(rawEntity.getPcareExamination()));
		}

		if (rawEntity.getSep() != null) {
			rawEntity.setSep(sepService.updateOldData(rawEntity.getSep()));
		}

		if (rawEntity.getAdmissionICD10() != null) {
			rawEntity.setAdmissionICD10(diagnosesAndProceduresService.updateOldData(rawEntity.getAdmissionICD10()));
		}

		if (rawEntity.getAdmissionICD9CM() != null) {
			rawEntity.setAdmissionICD9CM(diagnosesAndProceduresService.updateOldData(rawEntity.getAdmissionICD9CM()));
		}

		if (rawEntity.getDismissalReferringFacility() != null) {
			rawEntity.setDismissalReferringFacility(healthFacilityService.updateOldData(rawEntity.getDismissalReferringFacility()));
		}

		if (rawEntity.getDismissalReferringStaff() != null) {
			rawEntity.setDismissalReferringStaff(staffService.updateOldData(rawEntity.getDismissalReferringStaff()));
		}

		if (rawEntity.getReferringUnit() != null) {
			rawEntity.setReferringUnit(serviceService.updateOldData(rawEntity.getReferringUnit()));
		}

		if (rawEntity.getReferringFacility() != null) {
			rawEntity.setReferringFacility(healthFacilityService.updateOldData(rawEntity.getReferringFacility()));
		}

		if (rawEntity.getBedFacility() != null) {
			rawEntity.setBedFacility(bedFacilityService.updateOldData(rawEntity.getBedFacility()));
		}

		if (rawEntity.getPatientVisit() != null) {
			rawEntity.setPatientVisit(patientVisitService.updateOldData(rawEntity.getPatientVisit()));
		}

		if (rawEntity.getService() != null) {
			rawEntity.setService(serviceService.updateOldData(rawEntity.getService()));
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		if (rawEntity.getRequestedBy() != null) {
			rawEntity.setRequestedBy(staffService.updateOldData(rawEntity.getRequestedBy()));
		}

		Set<BedReserveEntity> bedReserves = new HashSet<>();
		rawEntity.getBedReserves().forEach(entity -> {
			bedReserves.add(bedReserveService.updateOldData(entity));
		});
		rawEntity.setBedReserves(bedReserves);

		Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults = new HashSet<>();
		rawEntity.getDiagnosticExaminationResults().forEach(entity -> {
			diagnosticExaminationResults.add(diagnosticExaminationResultsService.updateOldData(entity));
		});
		rawEntity.setDiagnosticExaminationResults(diagnosticExaminationResults);

		Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();
		rawEntity.getFluidBalanceDetails().forEach(entity -> {
			fluidBalanceDetails.add(fluidBalanceDetailService.updateOldData(entity));
		});
		rawEntity.setFluidBalanceDetails(fluidBalanceDetails);

		Set<InformedConsentEntity> informedConsents = new HashSet<>();
		rawEntity.getInformedConsents().forEach(entity -> {
			informedConsents.add(informedConsentService.updateOldData(entity));
		});
		rawEntity.setInformedConsents(informedConsents);

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		Set<MedicalFeeEntity> medicalFees = new HashSet<>();
		rawEntity.getMedicalFees().forEach(entity -> {
			medicalFees.add(medicalFeeService.updateOldData(entity));
		});
		rawEntity.setMedicalFees(medicalFees);

		Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();
		rawEntity.getMedicationHeaders().forEach(entity -> {
			medicationHeaders.add(medicationHeaderService.updateOldData(entity));
		});
		rawEntity.setMedicationHeaders(medicationHeaders);

		Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();
		rawEntity.getPatientVitalInformations().forEach(entity -> {
			patientVitalInformations.add(patientVitalInformationService.updateOldData(entity));
		});
		rawEntity.setPatientVitalInformations(patientVitalInformations);

		Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();
		rawEntity.getPrescriptionHeaders().forEach(entity -> {
			prescriptionHeaders.add(prescriptionHeaderService.updateOldData(entity));
		});
		rawEntity.setPrescriptionHeaders(prescriptionHeaders);

		Set<SampleCollectionInformationEntity> sampleCollectionInformations = new HashSet<>();
		rawEntity.getSampleCollectionInformations().forEach(entity -> {
			sampleCollectionInformations.add(sampleCollectionInformationService.updateOldData(entity));
		});
		rawEntity.setSampleCollectionInformations(sampleCollectionInformations);

		Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();
		rawEntity.getVaccinationOrders().forEach(entity -> {
			vaccinationOrders.add(vaccinationOrderService.updateOldData(entity));
		});
		rawEntity.setVaccinationOrders(vaccinationOrders);

		Set<ExaminationItemEntity> examinationItems = new HashSet<>();
		rawEntity.getExaminationItems().forEach(entity -> {
			examinationItems.add(examinationItemService.updateOldData(entity));
		});
		rawEntity.setExaminationItems(examinationItems);

		RegistrationEntity newEntity = registrationService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link RegistrationMutationResolver#createRegistration(RegistrationEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'create')")
	public List<RegistrationEntity> createAllRegistration(@NonNull List<RegistrationEntity> rawEntities) {
		List<RegistrationEntity> newEntities = Lists.newArrayList(registrationService.createAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the created entities here] off begin
		// % protected region % [Add any additional logic for update before returning the created entities here] end

		return newEntities;
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'update')")
	public RegistrationEntity updateRegistration(@NonNull RegistrationEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getDiagnosticStaffExaminationSummary() != null) {
			rawEntity.setDiagnosticStaffExaminationSummary(diagnosticStaffExaminationSummaryService.updateOldData(rawEntity.getDiagnosticStaffExaminationSummary()));
		}

		if (rawEntity.getBpjsPRBDetail() != null) {
			rawEntity.setBpjsPRBDetail(bpjsPRBDetailService.updateOldData(rawEntity.getBpjsPRBDetail()));
		}

		if (rawEntity.getBpjsPcareRegistrations() != null) {
			rawEntity.setBpjsPcareRegistrations(bpjsPcareRegistrationsService.updateOldData(rawEntity.getBpjsPcareRegistrations()));
		}

		if (rawEntity.getBpjsSEP() != null) {
			rawEntity.setBpjsSEP(bpjsSEPService.updateOldData(rawEntity.getBpjsSEP()));
		}

		if (rawEntity.getMedicalCertificateDischargeResume() != null) {
			rawEntity.setMedicalCertificateDischargeResume(medicalCertificateDischargeResumeService.updateOldData(rawEntity.getMedicalCertificateDischargeResume()));
		}

		if (rawEntity.getMedicalCertificateBirth() != null) {
			rawEntity.setMedicalCertificateBirth(medicalCertificateBirthService.updateOldData(rawEntity.getMedicalCertificateBirth()));
		}

		if (rawEntity.getMedicalCertificateHospitalization() != null) {
			rawEntity.setMedicalCertificateHospitalization(medicalCertificateHospitalizationService.updateOldData(rawEntity.getMedicalCertificateHospitalization()));
		}

		if (rawEntity.getMedicalCertificateMedicalAttendance() != null) {
			rawEntity.setMedicalCertificateMedicalAttendance(medicalCertificateMedicalAttendanceService.updateOldData(rawEntity.getMedicalCertificateMedicalAttendance()));
		}

		if (rawEntity.getMedicalCertificateMentalHealth() != null) {
			rawEntity.setMedicalCertificateMentalHealth(medicalCertificateMentalHealthService.updateOldData(rawEntity.getMedicalCertificateMentalHealth()));
		}

		if (rawEntity.getMedicalCertificatePhysicalHealth() != null) {
			rawEntity.setMedicalCertificatePhysicalHealth(medicalCertificatePhysicalHealthService.updateOldData(rawEntity.getMedicalCertificatePhysicalHealth()));
		}

		if (rawEntity.getMedicalCertificateRestrictedWork() != null) {
			rawEntity.setMedicalCertificateRestrictedWork(medicalCertificateRestrictedWorkService.updateOldData(rawEntity.getMedicalCertificateRestrictedWork()));
		}

		if (rawEntity.getMedicalCertificateSickLeave() != null) {
			rawEntity.setMedicalCertificateSickLeave(medicalCertificateSickLeaveService.updateOldData(rawEntity.getMedicalCertificateSickLeave()));
		}

		if (rawEntity.getMedicalExaminationRecord() != null) {
			rawEntity.setMedicalExaminationRecord(medicalExaminationRecordService.updateOldData(rawEntity.getMedicalExaminationRecord()));
		}

		if (rawEntity.getPcareExamination() != null) {
			rawEntity.setPcareExamination(pcareExaminationService.updateOldData(rawEntity.getPcareExamination()));
		}

		if (rawEntity.getSep() != null) {
			rawEntity.setSep(sepService.updateOldData(rawEntity.getSep()));
		}

		if (rawEntity.getAdmissionICD10() != null) {
			rawEntity.setAdmissionICD10(diagnosesAndProceduresService.updateOldData(rawEntity.getAdmissionICD10()));
		}

		if (rawEntity.getAdmissionICD9CM() != null) {
			rawEntity.setAdmissionICD9CM(diagnosesAndProceduresService.updateOldData(rawEntity.getAdmissionICD9CM()));
		}

		if (rawEntity.getDismissalReferringFacility() != null) {
			rawEntity.setDismissalReferringFacility(healthFacilityService.updateOldData(rawEntity.getDismissalReferringFacility()));
		}

		if (rawEntity.getDismissalReferringStaff() != null) {
			rawEntity.setDismissalReferringStaff(staffService.updateOldData(rawEntity.getDismissalReferringStaff()));
		}

		if (rawEntity.getReferringUnit() != null) {
			rawEntity.setReferringUnit(serviceService.updateOldData(rawEntity.getReferringUnit()));
		}

		if (rawEntity.getReferringFacility() != null) {
			rawEntity.setReferringFacility(healthFacilityService.updateOldData(rawEntity.getReferringFacility()));
		}

		if (rawEntity.getBedFacility() != null) {
			rawEntity.setBedFacility(bedFacilityService.updateOldData(rawEntity.getBedFacility()));
		}

		if (rawEntity.getPatientVisit() != null) {
			rawEntity.setPatientVisit(patientVisitService.updateOldData(rawEntity.getPatientVisit()));
		}

		if (rawEntity.getService() != null) {
			rawEntity.setService(serviceService.updateOldData(rawEntity.getService()));
		}

		if (rawEntity.getStaff() != null) {
			rawEntity.setStaff(staffService.updateOldData(rawEntity.getStaff()));
		}

		if (rawEntity.getRequestedBy() != null) {
			rawEntity.setRequestedBy(staffService.updateOldData(rawEntity.getRequestedBy()));
		}

		Set<BedReserveEntity> bedReserves = new HashSet<>();
		rawEntity.getBedReserves().forEach(entity -> {
			bedReserves.add(bedReserveService.updateOldData(entity));
		});
		rawEntity.setBedReserves(bedReserves);

		Set<DiagnosticExaminationResultsEntity> diagnosticExaminationResults = new HashSet<>();
		rawEntity.getDiagnosticExaminationResults().forEach(entity -> {
			diagnosticExaminationResults.add(diagnosticExaminationResultsService.updateOldData(entity));
		});
		rawEntity.setDiagnosticExaminationResults(diagnosticExaminationResults);

		Set<FluidBalanceDetailEntity> fluidBalanceDetails = new HashSet<>();
		rawEntity.getFluidBalanceDetails().forEach(entity -> {
			fluidBalanceDetails.add(fluidBalanceDetailService.updateOldData(entity));
		});
		rawEntity.setFluidBalanceDetails(fluidBalanceDetails);

		Set<InformedConsentEntity> informedConsents = new HashSet<>();
		rawEntity.getInformedConsents().forEach(entity -> {
			informedConsents.add(informedConsentService.updateOldData(entity));
		});
		rawEntity.setInformedConsents(informedConsents);

		Set<InvoiceItemEntity> invoiceItems = new HashSet<>();
		rawEntity.getInvoiceItems().forEach(entity -> {
			invoiceItems.add(invoiceItemService.updateOldData(entity));
		});
		rawEntity.setInvoiceItems(invoiceItems);

		Set<MedicalFeeEntity> medicalFees = new HashSet<>();
		rawEntity.getMedicalFees().forEach(entity -> {
			medicalFees.add(medicalFeeService.updateOldData(entity));
		});
		rawEntity.setMedicalFees(medicalFees);

		Set<MedicationHeaderEntity> medicationHeaders = new HashSet<>();
		rawEntity.getMedicationHeaders().forEach(entity -> {
			medicationHeaders.add(medicationHeaderService.updateOldData(entity));
		});
		rawEntity.setMedicationHeaders(medicationHeaders);

		Set<PatientVitalInformationEntity> patientVitalInformations = new HashSet<>();
		rawEntity.getPatientVitalInformations().forEach(entity -> {
			patientVitalInformations.add(patientVitalInformationService.updateOldData(entity));
		});
		rawEntity.setPatientVitalInformations(patientVitalInformations);

		Set<PrescriptionHeaderEntity> prescriptionHeaders = new HashSet<>();
		rawEntity.getPrescriptionHeaders().forEach(entity -> {
			prescriptionHeaders.add(prescriptionHeaderService.updateOldData(entity));
		});
		rawEntity.setPrescriptionHeaders(prescriptionHeaders);

		Set<SampleCollectionInformationEntity> sampleCollectionInformations = new HashSet<>();
		rawEntity.getSampleCollectionInformations().forEach(entity -> {
			sampleCollectionInformations.add(sampleCollectionInformationService.updateOldData(entity));
		});
		rawEntity.setSampleCollectionInformations(sampleCollectionInformations);

		Set<VaccinationOrderEntity> vaccinationOrders = new HashSet<>();
		rawEntity.getVaccinationOrders().forEach(entity -> {
			vaccinationOrders.add(vaccinationOrderService.updateOldData(entity));
		});
		rawEntity.setVaccinationOrders(vaccinationOrders);

		Set<ExaminationItemEntity> examinationItems = new HashSet<>();
		rawEntity.getExaminationItems().forEach(entity -> {
			examinationItems.add(examinationItemService.updateOldData(entity));
		});
		rawEntity.setExaminationItems(examinationItems);

		RegistrationEntity entityFromDb = registrationService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		RegistrationEntity newEntity = registrationService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link RegistrationMutationResolver#updateRegistration(RegistrationEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'update')")
	public List<RegistrationEntity> updateAllRegistration(@NonNull List<RegistrationEntity> rawEntities) {
		List<RegistrationEntity> newEntities = Lists.newArrayList(registrationService.updateAll(rawEntities));

		// % protected region % [Add any additional logic for update before returning the updated entities here] off begin
		// % protected region % [Add any additional logic for update before returning the updated entities here] end

		return newEntities;
	}

	/**
	 * Delete the entity with the ID from the database.
	 *
	 * @param id the ID of the entity to be deleted
	 * @return the ID of the deleted entity
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'delete')")
	public String deleteRegistrationById(@NonNull String id) {
		registrationService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link RegistrationMutationResolver#deleteRegistrationById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('RegistrationEntity', 'delete')")
	public List<String> deleteAllRegistrationByIds(@NonNull List<String> ids) {
		registrationService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('RegistrationEntity', 'delete')")
	public List<String> deleteRegistrationExcludingIds(@NonNull List<String> ids) {
		registrationService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
