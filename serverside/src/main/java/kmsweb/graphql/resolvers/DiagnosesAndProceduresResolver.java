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
public class DiagnosesAndProceduresResolver implements GraphQLResolver<DiagnosesAndProceduresEntity> {

	// % protected region % [Import any additional class fields here] off begin
	// % protected region % [Import any additional class fields here] end

	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public Set<RegistrationEntity> admissionICD10(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getAdmissionICD10();
	}

	@PreAuthorize("hasPermission('RegistrationEntity', 'read')")
	public Set<RegistrationEntity> admissionICD9CM(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getAdmissionICD9CM();
	}

	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	public Set<DailyCareCPPTEntity> cpptICD10(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getCpptICD10();
	}

	@PreAuthorize("hasPermission('DailyCareCPPTEntity', 'read')")
	public Set<DailyCareCPPTEntity> cpptICD9CM(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getCpptICD9CM();
	}

	@PreAuthorize("hasPermission('DiagnosisNandaEntity', 'read')")
	public Set<DiagnosisNandaEntity> diagnosisNandas(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getDiagnosisNandas();
	}

	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	public Set<MedicalCertificateDischargeResumeEntity> dischargeICD10(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getDischargeICD10();
	}

	@PreAuthorize("hasPermission('MedicalCertificateDischargeResumeEntity', 'read')")
	public Set<MedicalCertificateDischargeResumeEntity> dischargeICD9CM(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getDischargeICD9CM();
	}

	@PreAuthorize("hasPermission('DiagnosisExaminationRecordEntity', 'read')")
	public Set<DiagnosisExaminationRecordEntity> icd10(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getIcd10();
	}

	@PreAuthorize("hasPermission('DiagnosisExaminationRecordEntity', 'read')")
	public Set<DiagnosisExaminationRecordEntity> icd9CM(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getIcd9CM();
	}

	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	public Set<InvoiceEntity> invoicesICD10(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getInvoicesICD10();
	}

	@PreAuthorize("hasPermission('InvoiceEntity', 'read')")
	public Set<InvoiceEntity> invoicesICD9CM(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getInvoicesICD9CM();
	}

	@PreAuthorize("hasPermission('Icd10Entity', 'read')")
	public Icd10Entity masterICD10(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getMasterICD10();
	}

	@PreAuthorize("hasPermission('Icd9CMEntity', 'read')")
	public Icd9CMEntity masterICD9CM(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getMasterICD9CM();
	}

	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	public Set<PostOperativeDetailsEntity> postOperativeICD10(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getPostOperativeICD10();
	}

	@PreAuthorize("hasPermission('PostOperativeDetailsEntity', 'read')")
	public Set<PostOperativeDetailsEntity> postOperativeICD9CM(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getPostOperativeICD9CM();
	}

	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public Set<PreoperativeRecordsEntity> preSurgeryICD10(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getPreSurgeryICD10();
	}

	@PreAuthorize("hasPermission('PreoperativeRecordsEntity', 'read')")
	public Set<PreoperativeRecordsEntity> preSurgeryICD9CM(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getPreSurgeryICD9CM();
	}

	@PreAuthorize("hasPermission('BpjsDiagnoseEntity', 'read')")
	public BpjsDiagnoseEntity bpjsDiagnose(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getBpjsDiagnose();
	}

	@PreAuthorize("hasPermission('BpjsDiagnosePRBEntity', 'read')")
	public BpjsDiagnosePRBEntity bpjsDiagnosePRB(DiagnosesAndProceduresEntity diagnosesAndProcedures) {
		return diagnosesAndProcedures.getBpjsDiagnosePRB();
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
