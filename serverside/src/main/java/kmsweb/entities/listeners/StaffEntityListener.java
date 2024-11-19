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
package kmsweb.entities.listeners;

import kmsweb.configs.properties.*;
import kmsweb.configs.security.auditing.services.StaffEntityReadAuditService;
import kmsweb.entities.StaffEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Listener class used to tap into life cycle hooks when processing StaffEntity.
 */
@Slf4j
@Component
public class StaffEntityListener {

	private static PermissionEvaluator permissionEvaluator;
	private static StaffEntityReadAuditService auditService;
	private static SecurityProperties securityProperties;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public void init(
		PermissionEvaluator permissionEvaluator,
		StaffEntityReadAuditService auditService,
		SecurityProperties securityProperties
	) {
		StaffEntityListener.permissionEvaluator = permissionEvaluator;
		StaffEntityListener.auditService = auditService;
		StaffEntityListener.securityProperties = securityProperties;
	}

	@PrePersist
	public void beforePersist(StaffEntity entity) {
		checkPermission(entity.getClass().getSimpleName(), "create");

		// % protected region % [Add any custom logic to be executed before the entity is persisted here] off begin
		// % protected region % [Add any custom logic to be executed before the entity is persisted here] end
	}

	@PostPersist
	public void afterPersist(StaffEntity entity) {
		// % protected region % [Add any custom logic to be executed after the entity has been persisted here] off begin
		// % protected region % [Add any custom logic to be executed after the entity has been persisted here] end
	}

	@PreRemove
	public void beforeRemove(StaffEntity entity) {
		checkPermission(entity.getClass().getSimpleName(), "delete");
		removeAllReferences(entity);

		// % protected region % [Add any custom logic to be executed before the entity is removed here] off begin
		// % protected region % [Add any custom logic to be executed before the entity is removed here] end
	}

	@PostRemove
	public void afterRemove(StaffEntity entity) {
		// % protected region % [Add any custom logic to be executed after the entity has been removed here] off begin
		// % protected region % [Add any custom logic to be executed after the entity has been removed here] end
	}

	@PreUpdate
	public void beforeUpdate(StaffEntity entity) {
		checkPermission(entity.getClass().getSimpleName(), "update");

		// % protected region % [Add any custom logic to be executed before the entity is updated here] off begin
		// % protected region % [Add any custom logic to be executed before the entity is updated here] end
	}

	@PostUpdate
	public void afterUpdate(StaffEntity entity) {
		// % protected region % [Add any custom logic to be executed after the entity has been updated here] off begin
		// % protected region % [Add any custom logic to be executed after the entity has been updated here] end
	}

	@PostLoad
	public void afterLoad(StaffEntity entity) throws JsonProcessingException {
		checkPermission(entity.getClass().getSimpleName(), "read");

		// % protected region % [Override the global configuration for read audits for the StaffEntity here] off begin
		if (securityProperties.isReadAuditEnabled()) {
			// Create a new read record against this entity.
			auditService.createWith(entity);
		}
		// % protected region % [Override the global configuration for read audits for the StaffEntity here] end

		// % protected region % [Add any custom logic to be executed before the entity has been loaded here] off begin
		// % protected region % [Add any custom logic to be executed before the entity has been loaded here] end
	}

	/**
	 * Given an entity name and a permission, check if the currently logged-in user has such permission against the
	 * the entity.
	 */
	private void checkPermission(@NonNull String entityName, @NonNull String permission) {
		if (!permissionEvaluator.hasPermission(SecurityContextHolder.getContext().getAuthentication(), entityName, permission)) {
			log.error("Access to {} with permission {} is denied.", entityName, permission);
			throw new AccessDeniedException("Access to Staff is not permitted.");
		}
	}

	/**
	 * Remove all references
	 * This is to avoid inconsistency of the data after delete.
	 *
	 * @param entity The entity to clean
	 */
	protected void removeAllReferences(StaffEntity entity) {
		entity.unsetAdministrationUser();
		entity.unsetCashierUser();
		entity.unsetClaimUser();
		entity.unsetDiagnosticSupportUser();
		entity.unsetDoctorUser();
		entity.unsetFacilityUser();
		entity.unsetManagementUser();
		entity.unsetMedicalRecordUser();
		entity.unsetMedicalTranscriberUser();
		entity.unsetNurseUser();
		entity.unsetPharmacyUser();
		entity.unsetPurchasingUser();
		entity.unsetRegistrationUser();
		entity.unsetSystemAdminUser();
		entity.unsetWarehouseUser();
		entity.unsetAdministrator();
		entity.unsetBpjsDoctorMapping();
		entity.unsetPcareDokter();
		entity.unsetService();
		entity.unsetAccompanyingConsents();
		entity.unsetAmendmentDetails();
		entity.unsetAnesthesiaMedicalTranscriber();
		entity.unsetAnesthesiologist();
		entity.unsetAnesthesiologyNurse();
		entity.unsetCashierStaff();
		entity.unsetCoTreatingDoctors();
		entity.unsetDailyCareCPPTsCreatedByStaff();
		entity.unsetDailyCareCPPTsDoctorInCharge();
		entity.unsetDailyCareCPPTsMedicalTranscriber();
		entity.unsetDeliveryProgresses();
		entity.unsetDiagnosticStaffExaminationSummaries();
		entity.unsetDismissalReferringStaff();
		entity.unsetDoctorSchedules();
		entity.unsetDoctorOnExamination();
		entity.unsetFluidBalanceDetails();
		entity.unsetHemodialysisMonitorings();
		entity.unsetHospitalBranchInformations();
		entity.unsetInformingConsents();
		entity.unsetInvoices();
		entity.unsetMcuPackageItems();
		entity.unsetMedicalCertificateDischargeResumes();
		entity.unsetMedicalCertificateBirths();
		entity.unsetMedicalCertificateHospitalizations();
		entity.unsetMedicalExaminationRecordDischargeSummarys();
		entity.unsetMedicalRecordTranscriber();
		entity.unsetMedicalStaffOfMedicalAttendancesCertificate();
		entity.unsetMedicalStaffOfMentalHealths();
		entity.unsetMedicalStaffOfPhysicalHealths();
		entity.unsetMedicalStaffOfRestrictedWorksCertificate();
		entity.unsetMedicalStaffOfSickLeavesCertificate();
		entity.unsetMedicationAdministeredHisotries();
		entity.unsetMedicationHeaders();
		entity.unsetMidwives();
		entity.unsetNurse();
		entity.unsetNursingDetailSurgicalNursing();
		entity.unsetNursingDetailsAnesthesiaNursing();
		entity.unsetPatientConsents();
		entity.unsetPatientVitalInformations();
		entity.unsetPediatricianInCharge();
		entity.unsetPrescriptionHeaders();
		entity.unsetProcessWorkflowLogs();
		entity.unsetRegistrations();
		entity.unsetRequestedBy();
		entity.unsetRoomTransfers();
		entity.unsetSampleCollectionStaffs();
		entity.unsetSampleDeliveryStaffs();
		entity.unsetSampleProcessingStaffs();
		entity.unsetSurgeon();
		entity.unsetSurgicalMedicalTranscriber();
		entity.unsetSurgicalNurse();
		entity.unsetTransferOrderStockDetails();
		entity.unsetVaccinationOrders();
		entity.unsetServices();
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}