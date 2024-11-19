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
import kmsweb.entities.PatientGeneralInfoEntity;
import kmsweb.services.PatientGeneralInfoService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsClaimSubmissionService;
import kmsweb.entities.BpjsClaimSubmissionEntity;
import kmsweb.services.CashReceiptService;
import kmsweb.entities.CashReceiptEntity;
import kmsweb.services.CashRefundService;
import kmsweb.entities.CashRefundEntity;
import kmsweb.services.InformedConsentService;
import kmsweb.entities.InformedConsentEntity;
import kmsweb.services.PatientCaseHistoryService;
import kmsweb.entities.PatientCaseHistoryEntity;
import kmsweb.services.PatientConsentService;
import kmsweb.entities.PatientConsentEntity;
import kmsweb.services.PatientContactInfoService;
import kmsweb.entities.PatientContactInfoEntity;
import kmsweb.services.PatientDetailService;
import kmsweb.entities.PatientDetailEntity;
import kmsweb.services.PatientDetailAddressService;
import kmsweb.entities.PatientDetailAddressEntity;
import kmsweb.services.PatientEmergencyContactDetailService;
import kmsweb.entities.PatientEmergencyContactDetailEntity;
import kmsweb.services.PatientEmploymentDetailService;
import kmsweb.entities.PatientEmploymentDetailEntity;
import kmsweb.services.PatientPaymentSelfPayingService;
import kmsweb.entities.PatientPaymentSelfPayingEntity;
import kmsweb.services.PatientPaymentBPJSService;
import kmsweb.entities.PatientPaymentBPJSEntity;
import kmsweb.services.PatientPaymentInsuranceService;
import kmsweb.entities.PatientPaymentInsuranceEntity;
import kmsweb.services.PatientPaymentOthersService;
import kmsweb.entities.PatientPaymentOthersEntity;
import kmsweb.services.PatientPersonalInfoService;
import kmsweb.entities.PatientPersonalInfoEntity;
import kmsweb.services.PatientSupportingDocumentService;
import kmsweb.entities.PatientSupportingDocumentEntity;
import kmsweb.services.PatientVisitService;
import kmsweb.entities.PatientVisitEntity;
import kmsweb.services.RetailPharmacyService;
import kmsweb.entities.RetailPharmacyEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class PatientGeneralInfoMutationResolver implements GraphQLMutationResolver {

	private final PatientGeneralInfoService patientGeneralInfoService;

	private final BpjsClaimSubmissionService bpjsClaimSubmissionService;

	private final CashReceiptService cashReceiptService;

	private final CashRefundService cashRefundService;

	private final InformedConsentService informedConsentService;

	private final PatientCaseHistoryService patientCaseHistoryService;

	private final PatientConsentService patientConsentService;

	private final PatientContactInfoService patientContactInfoService;

	private final PatientDetailService patientDetailService;

	private final PatientDetailAddressService patientDetailAddressService;

	private final PatientEmergencyContactDetailService patientEmergencyContactDetailService;

	private final PatientEmploymentDetailService patientEmploymentDetailService;

	private final PatientPaymentSelfPayingService patientPaymentSelfPayingService;

	private final PatientPaymentBPJSService patientPaymentBPJSService;

	private final PatientPaymentInsuranceService patientPaymentInsuranceService;

	private final PatientPaymentOthersService patientPaymentOthersService;

	private final PatientPersonalInfoService patientPersonalInfoService;

	private final PatientSupportingDocumentService patientSupportingDocumentService;

	private final PatientVisitService patientVisitService;

	private final RetailPharmacyService retailPharmacyService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public PatientGeneralInfoMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsClaimSubmissionService bpjsClaimSubmissionService,
			CashReceiptService cashReceiptService,
			CashRefundService cashRefundService,
			InformedConsentService informedConsentService,
			PatientCaseHistoryService patientCaseHistoryService,
			PatientConsentService patientConsentService,
			PatientContactInfoService patientContactInfoService,
			PatientDetailService patientDetailService,
			PatientDetailAddressService patientDetailAddressService,
			PatientEmergencyContactDetailService patientEmergencyContactDetailService,
			PatientEmploymentDetailService patientEmploymentDetailService,
			PatientPaymentSelfPayingService patientPaymentSelfPayingService,
			PatientPaymentBPJSService patientPaymentBPJSService,
			PatientPaymentInsuranceService patientPaymentInsuranceService,
			PatientPaymentOthersService patientPaymentOthersService,
			PatientPersonalInfoService patientPersonalInfoService,
			PatientSupportingDocumentService patientSupportingDocumentService,
			PatientVisitService patientVisitService,
			RetailPharmacyService retailPharmacyService,
			PatientGeneralInfoService patientGeneralInfoService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.patientGeneralInfoService = patientGeneralInfoService;

		this.bpjsClaimSubmissionService = bpjsClaimSubmissionService;

		this.cashReceiptService = cashReceiptService;

		this.cashRefundService = cashRefundService;

		this.informedConsentService = informedConsentService;

		this.patientCaseHistoryService = patientCaseHistoryService;

		this.patientConsentService = patientConsentService;

		this.patientContactInfoService = patientContactInfoService;

		this.patientDetailService = patientDetailService;

		this.patientDetailAddressService = patientDetailAddressService;

		this.patientEmergencyContactDetailService = patientEmergencyContactDetailService;

		this.patientEmploymentDetailService = patientEmploymentDetailService;

		this.patientPaymentSelfPayingService = patientPaymentSelfPayingService;

		this.patientPaymentBPJSService = patientPaymentBPJSService;

		this.patientPaymentInsuranceService = patientPaymentInsuranceService;

		this.patientPaymentOthersService = patientPaymentOthersService;

		this.patientPersonalInfoService = patientPersonalInfoService;

		this.patientSupportingDocumentService = patientSupportingDocumentService;

		this.patientVisitService = patientVisitService;

		this.retailPharmacyService = retailPharmacyService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'create')")
	public PatientGeneralInfoEntity createPatientGeneralInfo(@NonNull PatientGeneralInfoEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientContactInformation() != null) {
			rawEntity.setPatientContactInformation(patientContactInfoService.updateOldData(rawEntity.getPatientContactInformation()));
		}

		if (rawEntity.getPatientDetailAddress() != null) {
			rawEntity.setPatientDetailAddress(patientDetailAddressService.updateOldData(rawEntity.getPatientDetailAddress()));
		}

		if (rawEntity.getPatientDetail() != null) {
			rawEntity.setPatientDetail(patientDetailService.updateOldData(rawEntity.getPatientDetail()));
		}

		if (rawEntity.getPatientEmergencyContactDetail() != null) {
			rawEntity.setPatientEmergencyContactDetail(patientEmergencyContactDetailService.updateOldData(rawEntity.getPatientEmergencyContactDetail()));
		}

		if (rawEntity.getPatientEmploymentDetail() != null) {
			rawEntity.setPatientEmploymentDetail(patientEmploymentDetailService.updateOldData(rawEntity.getPatientEmploymentDetail()));
		}

		if (rawEntity.getPatientPaymentBPJS() != null) {
			rawEntity.setPatientPaymentBPJS(patientPaymentBPJSService.updateOldData(rawEntity.getPatientPaymentBPJS()));
		}

		if (rawEntity.getPatientPaymentTypeInsurance() != null) {
			rawEntity.setPatientPaymentTypeInsurance(patientPaymentInsuranceService.updateOldData(rawEntity.getPatientPaymentTypeInsurance()));
		}

		if (rawEntity.getPatientPaymentTypeOthers() != null) {
			rawEntity.setPatientPaymentTypeOthers(patientPaymentOthersService.updateOldData(rawEntity.getPatientPaymentTypeOthers()));
		}

		if (rawEntity.getPatientPersonalInformation() != null) {
			rawEntity.setPatientPersonalInformation(patientPersonalInfoService.updateOldData(rawEntity.getPatientPersonalInformation()));
		}

		if (rawEntity.getPatientSelfPaying() != null) {
			rawEntity.setPatientSelfPaying(patientPaymentSelfPayingService.updateOldData(rawEntity.getPatientSelfPaying()));
		}

		Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();
		rawEntity.getBpjsClaimSubmissions().forEach(entity -> {
			bpjsClaimSubmissions.add(bpjsClaimSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsClaimSubmissions(bpjsClaimSubmissions);

		Set<CashRefundEntity> cashRefunds = new HashSet<>();
		rawEntity.getCashRefunds().forEach(entity -> {
			cashRefunds.add(cashRefundService.updateOldData(entity));
		});
		rawEntity.setCashRefunds(cashRefunds);

		Set<InformedConsentEntity> informedConsents = new HashSet<>();
		rawEntity.getInformedConsents().forEach(entity -> {
			informedConsents.add(informedConsentService.updateOldData(entity));
		});
		rawEntity.setInformedConsents(informedConsents);

		Set<CashReceiptEntity> invoiceReceipts = new HashSet<>();
		rawEntity.getInvoiceReceipts().forEach(entity -> {
			invoiceReceipts.add(cashReceiptService.updateOldData(entity));
		});
		rawEntity.setInvoiceReceipts(invoiceReceipts);

		Set<PatientCaseHistoryEntity> patientCaseHistories = new HashSet<>();
		rawEntity.getPatientCaseHistories().forEach(entity -> {
			patientCaseHistories.add(patientCaseHistoryService.updateOldData(entity));
		});
		rawEntity.setPatientCaseHistories(patientCaseHistories);

		Set<PatientConsentEntity> patientConsents = new HashSet<>();
		rawEntity.getPatientConsents().forEach(entity -> {
			patientConsents.add(patientConsentService.updateOldData(entity));
		});
		rawEntity.setPatientConsents(patientConsents);

		Set<PatientSupportingDocumentEntity> patientFinalizeProfiles = new HashSet<>();
		rawEntity.getPatientFinalizeProfiles().forEach(entity -> {
			patientFinalizeProfiles.add(patientSupportingDocumentService.updateOldData(entity));
		});
		rawEntity.setPatientFinalizeProfiles(patientFinalizeProfiles);

		Set<RetailPharmacyEntity> retailPharmacies = new HashSet<>();
		rawEntity.getRetailPharmacies().forEach(entity -> {
			retailPharmacies.add(retailPharmacyService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacies(retailPharmacies);

		Set<PatientVisitEntity> visits = new HashSet<>();
		rawEntity.getVisits().forEach(entity -> {
			visits.add(patientVisitService.updateOldData(entity));
		});
		rawEntity.setVisits(visits);

		PatientGeneralInfoEntity newEntity = patientGeneralInfoService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientGeneralInfoMutationResolver#createPatientGeneralInfo(PatientGeneralInfoEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'create')")
	public List<PatientGeneralInfoEntity> createAllPatientGeneralInfo(@NonNull List<PatientGeneralInfoEntity> rawEntities) {
		List<PatientGeneralInfoEntity> newEntities = Lists.newArrayList(patientGeneralInfoService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'update')")
	public PatientGeneralInfoEntity updatePatientGeneralInfo(@NonNull PatientGeneralInfoEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getPatientContactInformation() != null) {
			rawEntity.setPatientContactInformation(patientContactInfoService.updateOldData(rawEntity.getPatientContactInformation()));
		}

		if (rawEntity.getPatientDetailAddress() != null) {
			rawEntity.setPatientDetailAddress(patientDetailAddressService.updateOldData(rawEntity.getPatientDetailAddress()));
		}

		if (rawEntity.getPatientDetail() != null) {
			rawEntity.setPatientDetail(patientDetailService.updateOldData(rawEntity.getPatientDetail()));
		}

		if (rawEntity.getPatientEmergencyContactDetail() != null) {
			rawEntity.setPatientEmergencyContactDetail(patientEmergencyContactDetailService.updateOldData(rawEntity.getPatientEmergencyContactDetail()));
		}

		if (rawEntity.getPatientEmploymentDetail() != null) {
			rawEntity.setPatientEmploymentDetail(patientEmploymentDetailService.updateOldData(rawEntity.getPatientEmploymentDetail()));
		}

		if (rawEntity.getPatientPaymentBPJS() != null) {
			rawEntity.setPatientPaymentBPJS(patientPaymentBPJSService.updateOldData(rawEntity.getPatientPaymentBPJS()));
		}

		if (rawEntity.getPatientPaymentTypeInsurance() != null) {
			rawEntity.setPatientPaymentTypeInsurance(patientPaymentInsuranceService.updateOldData(rawEntity.getPatientPaymentTypeInsurance()));
		}

		if (rawEntity.getPatientPaymentTypeOthers() != null) {
			rawEntity.setPatientPaymentTypeOthers(patientPaymentOthersService.updateOldData(rawEntity.getPatientPaymentTypeOthers()));
		}

		if (rawEntity.getPatientPersonalInformation() != null) {
			rawEntity.setPatientPersonalInformation(patientPersonalInfoService.updateOldData(rawEntity.getPatientPersonalInformation()));
		}

		if (rawEntity.getPatientSelfPaying() != null) {
			rawEntity.setPatientSelfPaying(patientPaymentSelfPayingService.updateOldData(rawEntity.getPatientSelfPaying()));
		}

		Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions = new HashSet<>();
		rawEntity.getBpjsClaimSubmissions().forEach(entity -> {
			bpjsClaimSubmissions.add(bpjsClaimSubmissionService.updateOldData(entity));
		});
		rawEntity.setBpjsClaimSubmissions(bpjsClaimSubmissions);

		Set<CashRefundEntity> cashRefunds = new HashSet<>();
		rawEntity.getCashRefunds().forEach(entity -> {
			cashRefunds.add(cashRefundService.updateOldData(entity));
		});
		rawEntity.setCashRefunds(cashRefunds);

		Set<InformedConsentEntity> informedConsents = new HashSet<>();
		rawEntity.getInformedConsents().forEach(entity -> {
			informedConsents.add(informedConsentService.updateOldData(entity));
		});
		rawEntity.setInformedConsents(informedConsents);

		Set<CashReceiptEntity> invoiceReceipts = new HashSet<>();
		rawEntity.getInvoiceReceipts().forEach(entity -> {
			invoiceReceipts.add(cashReceiptService.updateOldData(entity));
		});
		rawEntity.setInvoiceReceipts(invoiceReceipts);

		Set<PatientCaseHistoryEntity> patientCaseHistories = new HashSet<>();
		rawEntity.getPatientCaseHistories().forEach(entity -> {
			patientCaseHistories.add(patientCaseHistoryService.updateOldData(entity));
		});
		rawEntity.setPatientCaseHistories(patientCaseHistories);

		Set<PatientConsentEntity> patientConsents = new HashSet<>();
		rawEntity.getPatientConsents().forEach(entity -> {
			patientConsents.add(patientConsentService.updateOldData(entity));
		});
		rawEntity.setPatientConsents(patientConsents);

		Set<PatientSupportingDocumentEntity> patientFinalizeProfiles = new HashSet<>();
		rawEntity.getPatientFinalizeProfiles().forEach(entity -> {
			patientFinalizeProfiles.add(patientSupportingDocumentService.updateOldData(entity));
		});
		rawEntity.setPatientFinalizeProfiles(patientFinalizeProfiles);

		Set<RetailPharmacyEntity> retailPharmacies = new HashSet<>();
		rawEntity.getRetailPharmacies().forEach(entity -> {
			retailPharmacies.add(retailPharmacyService.updateOldData(entity));
		});
		rawEntity.setRetailPharmacies(retailPharmacies);

		Set<PatientVisitEntity> visits = new HashSet<>();
		rawEntity.getVisits().forEach(entity -> {
			visits.add(patientVisitService.updateOldData(entity));
		});
		rawEntity.setVisits(visits);

		PatientGeneralInfoEntity entityFromDb = patientGeneralInfoService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		PatientGeneralInfoEntity newEntity = patientGeneralInfoService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link PatientGeneralInfoMutationResolver#updatePatientGeneralInfo(PatientGeneralInfoEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'update')")
	public List<PatientGeneralInfoEntity> updateAllPatientGeneralInfo(@NonNull List<PatientGeneralInfoEntity> rawEntities) {
		List<PatientGeneralInfoEntity> newEntities = Lists.newArrayList(patientGeneralInfoService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'delete')")
	public String deletePatientGeneralInfoById(@NonNull String id) {
		patientGeneralInfoService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link PatientGeneralInfoMutationResolver#deletePatientGeneralInfoById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'delete')")
	public List<String> deleteAllPatientGeneralInfoByIds(@NonNull List<String> ids) {
		patientGeneralInfoService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'delete')")
	public List<String> deletePatientGeneralInfoExcludingIds(@NonNull List<String> ids) {
		patientGeneralInfoService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
