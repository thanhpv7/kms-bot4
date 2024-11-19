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
public class PatientGeneralInfoResolver implements GraphQLResolver<PatientGeneralInfoEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	public Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getBpjsClaimSubmissions();
	}

	@PreAuthorize("hasPermission('CashRefundEntity', 'read')")
	public Set<CashRefundEntity> cashRefunds(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getCashRefunds();
	}

	@PreAuthorize("hasPermission('InformedConsentEntity', 'read')")
	public Set<InformedConsentEntity> informedConsents(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getInformedConsents();
	}

	@PreAuthorize("hasPermission('CashReceiptEntity', 'read')")
	public Set<CashReceiptEntity> invoiceReceipts(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getInvoiceReceipts();
	}

	@PreAuthorize("hasPermission('PatientCaseHistoryEntity', 'read')")
	public Set<PatientCaseHistoryEntity> patientCaseHistories(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientCaseHistories();
	}

	@PreAuthorize("hasPermission('PatientConsentEntity', 'read')")
	public Set<PatientConsentEntity> patientConsents(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientConsents();
	}

	@PreAuthorize("hasPermission('PatientContactInfoEntity', 'read')")
	public PatientContactInfoEntity patientContactInformation(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientContactInformation();
	}

	@PreAuthorize("hasPermission('PatientDetailAddressEntity', 'read')")
	public PatientDetailAddressEntity patientDetailAddress(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientDetailAddress();
	}

	@PreAuthorize("hasPermission('PatientDetailEntity', 'read')")
	public PatientDetailEntity patientDetail(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientDetail();
	}

	@PreAuthorize("hasPermission('PatientEmergencyContactDetailEntity', 'read')")
	public PatientEmergencyContactDetailEntity patientEmergencyContactDetail(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientEmergencyContactDetail();
	}

	@PreAuthorize("hasPermission('PatientEmploymentDetailEntity', 'read')")
	public PatientEmploymentDetailEntity patientEmploymentDetail(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientEmploymentDetail();
	}

	@PreAuthorize("hasPermission('PatientSupportingDocumentEntity', 'read')")
	public Set<PatientSupportingDocumentEntity> patientFinalizeProfiles(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientFinalizeProfiles();
	}

	@PreAuthorize("hasPermission('PatientPaymentBPJSEntity', 'read')")
	public PatientPaymentBPJSEntity patientPaymentBPJS(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientPaymentBPJS();
	}

	@PreAuthorize("hasPermission('PatientPaymentInsuranceEntity', 'read')")
	public PatientPaymentInsuranceEntity patientPaymentTypeInsurance(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientPaymentTypeInsurance();
	}

	@PreAuthorize("hasPermission('PatientPaymentOthersEntity', 'read')")
	public PatientPaymentOthersEntity patientPaymentTypeOthers(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientPaymentTypeOthers();
	}

	@PreAuthorize("hasPermission('PatientPersonalInfoEntity', 'read')")
	public PatientPersonalInfoEntity patientPersonalInformation(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientPersonalInformation();
	}

	@PreAuthorize("hasPermission('PatientPaymentSelfPayingEntity', 'read')")
	public PatientPaymentSelfPayingEntity patientSelfPaying(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getPatientSelfPaying();
	}

	@PreAuthorize("hasPermission('RetailPharmacyEntity', 'read')")
	public Set<RetailPharmacyEntity> retailPharmacies(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getRetailPharmacies();
	}

	@PreAuthorize("hasPermission('PatientVisitEntity', 'read')")
	public Set<PatientVisitEntity> visits(PatientGeneralInfoEntity patientGeneralInfo) {
		return patientGeneralInfo.getVisits();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
