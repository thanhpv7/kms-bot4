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
public class PatientPaymentBPJSResolver implements GraphQLResolver<PatientPaymentBPJSEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('BpjsAccidentMasterEntity', 'read')")
	public Set<BpjsAccidentMasterEntity> bpjsAccidentMasters(PatientPaymentBPJSEntity patientPaymentBPJS) {
		return patientPaymentBPJS.getBpjsAccidentMasters();
	}

	@PreAuthorize("hasPermission('BpjsClaimSubmissionEntity', 'read')")
	public Set<BpjsClaimSubmissionEntity> bpjsClaimSubmissions(PatientPaymentBPJSEntity patientPaymentBPJS) {
		return patientPaymentBPJS.getBpjsClaimSubmissions();
	}

	@PreAuthorize("hasPermission('BpjsHospitalizationPlanEntity', 'read')")
	public Set<BpjsHospitalizationPlanEntity> bpjsHospitalizationPlans(PatientPaymentBPJSEntity patientPaymentBPJS) {
		return patientPaymentBPJS.getBpjsHospitalizationPlans();
	}

	@PreAuthorize("hasPermission('BpjsJasaRaharjaEntity', 'read')")
	public Set<BpjsJasaRaharjaEntity> bpjsJasaRaharjas(PatientPaymentBPJSEntity patientPaymentBPJS) {
		return patientPaymentBPJS.getBpjsJasaRaharjas();
	}

	@PreAuthorize("hasPermission('BpjsPatientReferralEntity', 'read')")
	public Set<BpjsPatientReferralEntity> bpjsPatientReferrals(PatientPaymentBPJSEntity patientPaymentBPJS) {
		return patientPaymentBPJS.getBpjsPatientReferrals();
	}

	@PreAuthorize("hasPermission('BpjsSEPSubmissionEntity', 'read')")
	public Set<BpjsSEPSubmissionEntity> bpjsSEPSubmissions(PatientPaymentBPJSEntity patientPaymentBPJS) {
		return patientPaymentBPJS.getBpjsSEPSubmissions();
	}

	@PreAuthorize("hasPermission('BpjsSEPEntity', 'read')")
	public Set<BpjsSEPEntity> bpjsSEPs(PatientPaymentBPJSEntity patientPaymentBPJS) {
		return patientPaymentBPJS.getBpjsSEPs();
	}

	@PreAuthorize("hasPermission('PatientGeneralInfoEntity', 'read')")
	public PatientGeneralInfoEntity patientGeneralInfo(PatientPaymentBPJSEntity patientPaymentBPJS) {
		return patientPaymentBPJS.getPatientGeneralInfo();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}