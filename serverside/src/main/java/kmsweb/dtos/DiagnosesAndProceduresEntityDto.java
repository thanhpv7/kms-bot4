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

package kmsweb.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.entities.*;
import lombok.*;
import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@Schema(description = "The Dto for DiagnosesAndProceduresEntity")
@EqualsAndHashCode(callSuper = false)
public class DiagnosesAndProceduresEntityDto extends AbstractEntityDto {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private String itemType;

	private String itemCode;

	private String description;

	private String notes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<RegistrationEntity> admissionICD10 = new HashSet<>();

	private Set<RegistrationEntity> admissionICD9CM = new HashSet<>();

	private Set<DailyCareCPPTEntity> cpptICD10 = new HashSet<>();

	private Set<DailyCareCPPTEntity> cpptICD9CM = new HashSet<>();

	private Set<DiagnosisNandaEntity> diagnosisNandas = new HashSet<>();

	private Set<MedicalCertificateDischargeResumeEntity> dischargeICD10 = new HashSet<>();

	private Set<MedicalCertificateDischargeResumeEntity> dischargeICD9CM = new HashSet<>();

	private Set<DiagnosisExaminationRecordEntity> icd10 = new HashSet<>();

	private Set<DiagnosisExaminationRecordEntity> icd9CM = new HashSet<>();

	private Set<InvoiceEntity> invoicesICD10 = new HashSet<>();

	private Set<InvoiceEntity> invoicesICD9CM = new HashSet<>();

	private Icd10Entity masterICD10;

	private Icd9CMEntity masterICD9CM;

	private Set<PostOperativeDetailsEntity> postOperativeICD10 = new HashSet<>();

	private Set<PostOperativeDetailsEntity> postOperativeICD9CM = new HashSet<>();

	private Set<PreoperativeRecordsEntity> preSurgeryICD10 = new HashSet<>();

	private Set<PreoperativeRecordsEntity> preSurgeryICD9CM = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsDiagnoseEntity bpjsDiagnose;

	private BpjsDiagnosePRBEntity bpjsDiagnosePRB;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end
}
