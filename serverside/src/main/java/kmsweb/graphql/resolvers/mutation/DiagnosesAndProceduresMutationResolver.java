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
import kmsweb.entities.DiagnosesAndProceduresEntity;
import kmsweb.services.DiagnosesAndProceduresService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import kmsweb.services.BpjsDiagnoseService;
import kmsweb.entities.BpjsDiagnoseEntity;
import kmsweb.services.BpjsDiagnosePRBService;
import kmsweb.entities.BpjsDiagnosePRBEntity;
import kmsweb.services.DailyCareCPPTService;
import kmsweb.entities.DailyCareCPPTEntity;
import kmsweb.services.DiagnosisExaminationRecordService;
import kmsweb.entities.DiagnosisExaminationRecordEntity;
import kmsweb.services.DiagnosisNandaService;
import kmsweb.entities.DiagnosisNandaEntity;
import kmsweb.services.Icd10Service;
import kmsweb.entities.Icd10Entity;
import kmsweb.services.Icd9CMService;
import kmsweb.entities.Icd9CMEntity;
import kmsweb.services.InvoiceService;
import kmsweb.entities.InvoiceEntity;
import kmsweb.services.MedicalCertificateDischargeResumeService;
import kmsweb.entities.MedicalCertificateDischargeResumeEntity;
import kmsweb.services.PostOperativeDetailsService;
import kmsweb.entities.PostOperativeDetailsEntity;
import kmsweb.services.PreoperativeRecordsService;
import kmsweb.entities.PreoperativeRecordsEntity;
import kmsweb.services.RegistrationService;
import kmsweb.entities.RegistrationEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Slf4j
@Component
public class DiagnosesAndProceduresMutationResolver implements GraphQLMutationResolver {

	private final DiagnosesAndProceduresService diagnosesAndProceduresService;

	private final BpjsDiagnoseService bpjsDiagnoseService;

	private final BpjsDiagnosePRBService bpjsDiagnosePRBService;

	private final DailyCareCPPTService dailyCareCPPTService;

	private final DiagnosisExaminationRecordService diagnosisExaminationRecordService;

	private final DiagnosisNandaService diagnosisNandaService;

	private final Icd10Service icd10Service;

	private final Icd9CMService icd9CMService;

	private final InvoiceService invoiceService;

	private final MedicalCertificateDischargeResumeService medicalCertificateDischargeResumeService;

	private final PostOperativeDetailsService postOperativeDetailsService;

	private final PreoperativeRecordsService preoperativeRecordsService;

	private final RegistrationService registrationService;


	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Autowired
	public DiagnosesAndProceduresMutationResolver(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			BpjsDiagnoseService bpjsDiagnoseService,
			BpjsDiagnosePRBService bpjsDiagnosePRBService,
			DailyCareCPPTService dailyCareCPPTService,
			DiagnosisExaminationRecordService diagnosisExaminationRecordService,
			DiagnosisNandaService diagnosisNandaService,
			Icd10Service icd10Service,
			Icd9CMService icd9CMService,
			InvoiceService invoiceService,
			MedicalCertificateDischargeResumeService medicalCertificateDischargeResumeService,
			PostOperativeDetailsService postOperativeDetailsService,
			PreoperativeRecordsService preoperativeRecordsService,
			RegistrationService registrationService,
			DiagnosesAndProceduresService diagnosesAndProceduresService
	) {
		// % protected region % [Add any additional constructor logic before the main body here] off begin
		// % protected region % [Add any additional constructor logic before the main body here] end

		this.diagnosesAndProceduresService = diagnosesAndProceduresService;

		this.bpjsDiagnoseService = bpjsDiagnoseService;

		this.bpjsDiagnosePRBService = bpjsDiagnosePRBService;

		this.dailyCareCPPTService = dailyCareCPPTService;

		this.diagnosisExaminationRecordService = diagnosisExaminationRecordService;

		this.diagnosisNandaService = diagnosisNandaService;

		this.icd10Service = icd10Service;

		this.icd9CMService = icd9CMService;

		this.invoiceService = invoiceService;

		this.medicalCertificateDischargeResumeService = medicalCertificateDischargeResumeService;

		this.postOperativeDetailsService = postOperativeDetailsService;

		this.preoperativeRecordsService = preoperativeRecordsService;

		this.registrationService = registrationService;

		// % protected region % [Add any additional constructor logic after the main body here] off begin
		// % protected region % [Add any additional constructor logic after the main body here] end
	}

	/**
	 * Persist the given entity into the database.
	 *
	 * @param rawEntity the entity before persistence
	 * @return the entity after persistence
	 */
	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'create')")
	public DiagnosesAndProceduresEntity createDiagnosesAndProcedures(@NonNull DiagnosesAndProceduresEntity rawEntity, Boolean persistRelations) {
		// % protected region % [Add any additional logic for create before creating the new entity here] off begin
		// % protected region % [Add any additional logic for create before creating the new entity here] end
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsDiagnose() != null) {
			rawEntity.setBpjsDiagnose(bpjsDiagnoseService.updateOldData(rawEntity.getBpjsDiagnose()));
		}

		if (rawEntity.getBpjsDiagnosePRB() != null) {
			rawEntity.setBpjsDiagnosePRB(bpjsDiagnosePRBService.updateOldData(rawEntity.getBpjsDiagnosePRB()));
		}

		if (rawEntity.getMasterICD10() != null) {
			rawEntity.setMasterICD10(icd10Service.updateOldData(rawEntity.getMasterICD10()));
		}

		if (rawEntity.getMasterICD9CM() != null) {
			rawEntity.setMasterICD9CM(icd9CMService.updateOldData(rawEntity.getMasterICD9CM()));
		}

		Set<RegistrationEntity> admissionICD10 = new HashSet<>();
		rawEntity.getAdmissionICD10().forEach(entity -> {
			admissionICD10.add(registrationService.updateOldData(entity));
		});
		rawEntity.setAdmissionICD10(admissionICD10);

		Set<RegistrationEntity> admissionICD9CM = new HashSet<>();
		rawEntity.getAdmissionICD9CM().forEach(entity -> {
			admissionICD9CM.add(registrationService.updateOldData(entity));
		});
		rawEntity.setAdmissionICD9CM(admissionICD9CM);

		Set<DailyCareCPPTEntity> cpptICD10 = new HashSet<>();
		rawEntity.getCpptICD10().forEach(entity -> {
			cpptICD10.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setCpptICD10(cpptICD10);

		Set<DailyCareCPPTEntity> cpptICD9CM = new HashSet<>();
		rawEntity.getCpptICD9CM().forEach(entity -> {
			cpptICD9CM.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setCpptICD9CM(cpptICD9CM);

		Set<MedicalCertificateDischargeResumeEntity> dischargeICD10 = new HashSet<>();
		rawEntity.getDischargeICD10().forEach(entity -> {
			dischargeICD10.add(medicalCertificateDischargeResumeService.updateOldData(entity));
		});
		rawEntity.setDischargeICD10(dischargeICD10);

		Set<MedicalCertificateDischargeResumeEntity> dischargeICD9CM = new HashSet<>();
		rawEntity.getDischargeICD9CM().forEach(entity -> {
			dischargeICD9CM.add(medicalCertificateDischargeResumeService.updateOldData(entity));
		});
		rawEntity.setDischargeICD9CM(dischargeICD9CM);

		Set<DiagnosisExaminationRecordEntity> icd10 = new HashSet<>();
		rawEntity.getIcd10().forEach(entity -> {
			icd10.add(diagnosisExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setIcd10(icd10);

		Set<DiagnosisExaminationRecordEntity> icd9CM = new HashSet<>();
		rawEntity.getIcd9CM().forEach(entity -> {
			icd9CM.add(diagnosisExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setIcd9CM(icd9CM);

		Set<InvoiceEntity> invoicesICD10 = new HashSet<>();
		rawEntity.getInvoicesICD10().forEach(entity -> {
			invoicesICD10.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoicesICD10(invoicesICD10);

		Set<InvoiceEntity> invoicesICD9CM = new HashSet<>();
		rawEntity.getInvoicesICD9CM().forEach(entity -> {
			invoicesICD9CM.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoicesICD9CM(invoicesICD9CM);

		Set<PostOperativeDetailsEntity> postOperativeICD10 = new HashSet<>();
		rawEntity.getPostOperativeICD10().forEach(entity -> {
			postOperativeICD10.add(postOperativeDetailsService.updateOldData(entity));
		});
		rawEntity.setPostOperativeICD10(postOperativeICD10);

		Set<PostOperativeDetailsEntity> postOperativeICD9CM = new HashSet<>();
		rawEntity.getPostOperativeICD9CM().forEach(entity -> {
			postOperativeICD9CM.add(postOperativeDetailsService.updateOldData(entity));
		});
		rawEntity.setPostOperativeICD9CM(postOperativeICD9CM);

		Set<PreoperativeRecordsEntity> preSurgeryICD10 = new HashSet<>();
		rawEntity.getPreSurgeryICD10().forEach(entity -> {
			preSurgeryICD10.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setPreSurgeryICD10(preSurgeryICD10);

		Set<PreoperativeRecordsEntity> preSurgeryICD9CM = new HashSet<>();
		rawEntity.getPreSurgeryICD9CM().forEach(entity -> {
			preSurgeryICD9CM.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setPreSurgeryICD9CM(preSurgeryICD9CM);

		Set<DiagnosisNandaEntity> diagnosisNandas = new HashSet<>();
		rawEntity.getDiagnosisNandas().forEach(entity -> {
			diagnosisNandas.add(diagnosisNandaService.updateOldData(entity));
		});
		rawEntity.setDiagnosisNandas(diagnosisNandas);

		DiagnosesAndProceduresEntity newEntity = diagnosesAndProceduresService.create(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly created entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly created entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link DiagnosesAndProceduresMutationResolver#createDiagnosesAndProcedures(DiagnosesAndProceduresEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'create')")
	public List<DiagnosesAndProceduresEntity> createAllDiagnosesAndProcedures(@NonNull List<DiagnosesAndProceduresEntity> rawEntities) {
		List<DiagnosesAndProceduresEntity> newEntities = Lists.newArrayList(diagnosesAndProceduresService.createAll(rawEntities));

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
	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'update')")
	public DiagnosesAndProceduresEntity updateDiagnosesAndProcedures(@NonNull DiagnosesAndProceduresEntity rawEntity, Boolean persistRelations) {
		if (persistRelations == null) {
			persistRelations = false;
		}

		if (rawEntity.getBpjsDiagnose() != null) {
			rawEntity.setBpjsDiagnose(bpjsDiagnoseService.updateOldData(rawEntity.getBpjsDiagnose()));
		}

		if (rawEntity.getBpjsDiagnosePRB() != null) {
			rawEntity.setBpjsDiagnosePRB(bpjsDiagnosePRBService.updateOldData(rawEntity.getBpjsDiagnosePRB()));
		}

		if (rawEntity.getMasterICD10() != null) {
			rawEntity.setMasterICD10(icd10Service.updateOldData(rawEntity.getMasterICD10()));
		}

		if (rawEntity.getMasterICD9CM() != null) {
			rawEntity.setMasterICD9CM(icd9CMService.updateOldData(rawEntity.getMasterICD9CM()));
		}

		Set<RegistrationEntity> admissionICD10 = new HashSet<>();
		rawEntity.getAdmissionICD10().forEach(entity -> {
			admissionICD10.add(registrationService.updateOldData(entity));
		});
		rawEntity.setAdmissionICD10(admissionICD10);

		Set<RegistrationEntity> admissionICD9CM = new HashSet<>();
		rawEntity.getAdmissionICD9CM().forEach(entity -> {
			admissionICD9CM.add(registrationService.updateOldData(entity));
		});
		rawEntity.setAdmissionICD9CM(admissionICD9CM);

		Set<DailyCareCPPTEntity> cpptICD10 = new HashSet<>();
		rawEntity.getCpptICD10().forEach(entity -> {
			cpptICD10.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setCpptICD10(cpptICD10);

		Set<DailyCareCPPTEntity> cpptICD9CM = new HashSet<>();
		rawEntity.getCpptICD9CM().forEach(entity -> {
			cpptICD9CM.add(dailyCareCPPTService.updateOldData(entity));
		});
		rawEntity.setCpptICD9CM(cpptICD9CM);

		Set<MedicalCertificateDischargeResumeEntity> dischargeICD10 = new HashSet<>();
		rawEntity.getDischargeICD10().forEach(entity -> {
			dischargeICD10.add(medicalCertificateDischargeResumeService.updateOldData(entity));
		});
		rawEntity.setDischargeICD10(dischargeICD10);

		Set<MedicalCertificateDischargeResumeEntity> dischargeICD9CM = new HashSet<>();
		rawEntity.getDischargeICD9CM().forEach(entity -> {
			dischargeICD9CM.add(medicalCertificateDischargeResumeService.updateOldData(entity));
		});
		rawEntity.setDischargeICD9CM(dischargeICD9CM);

		Set<DiagnosisExaminationRecordEntity> icd10 = new HashSet<>();
		rawEntity.getIcd10().forEach(entity -> {
			icd10.add(diagnosisExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setIcd10(icd10);

		Set<DiagnosisExaminationRecordEntity> icd9CM = new HashSet<>();
		rawEntity.getIcd9CM().forEach(entity -> {
			icd9CM.add(diagnosisExaminationRecordService.updateOldData(entity));
		});
		rawEntity.setIcd9CM(icd9CM);

		Set<InvoiceEntity> invoicesICD10 = new HashSet<>();
		rawEntity.getInvoicesICD10().forEach(entity -> {
			invoicesICD10.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoicesICD10(invoicesICD10);

		Set<InvoiceEntity> invoicesICD9CM = new HashSet<>();
		rawEntity.getInvoicesICD9CM().forEach(entity -> {
			invoicesICD9CM.add(invoiceService.updateOldData(entity));
		});
		rawEntity.setInvoicesICD9CM(invoicesICD9CM);

		Set<PostOperativeDetailsEntity> postOperativeICD10 = new HashSet<>();
		rawEntity.getPostOperativeICD10().forEach(entity -> {
			postOperativeICD10.add(postOperativeDetailsService.updateOldData(entity));
		});
		rawEntity.setPostOperativeICD10(postOperativeICD10);

		Set<PostOperativeDetailsEntity> postOperativeICD9CM = new HashSet<>();
		rawEntity.getPostOperativeICD9CM().forEach(entity -> {
			postOperativeICD9CM.add(postOperativeDetailsService.updateOldData(entity));
		});
		rawEntity.setPostOperativeICD9CM(postOperativeICD9CM);

		Set<PreoperativeRecordsEntity> preSurgeryICD10 = new HashSet<>();
		rawEntity.getPreSurgeryICD10().forEach(entity -> {
			preSurgeryICD10.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setPreSurgeryICD10(preSurgeryICD10);

		Set<PreoperativeRecordsEntity> preSurgeryICD9CM = new HashSet<>();
		rawEntity.getPreSurgeryICD9CM().forEach(entity -> {
			preSurgeryICD9CM.add(preoperativeRecordsService.updateOldData(entity));
		});
		rawEntity.setPreSurgeryICD9CM(preSurgeryICD9CM);

		Set<DiagnosisNandaEntity> diagnosisNandas = new HashSet<>();
		rawEntity.getDiagnosisNandas().forEach(entity -> {
			diagnosisNandas.add(diagnosisNandaService.updateOldData(entity));
		});
		rawEntity.setDiagnosisNandas(diagnosisNandas);

		DiagnosesAndProceduresEntity entityFromDb = diagnosesAndProceduresService.findById(rawEntity.getId()).orElseThrow();
		rawEntity.setCreatedBy(entityFromDb.getCreatedBy());
		DiagnosesAndProceduresEntity newEntity = diagnosesAndProceduresService.update(rawEntity, persistRelations);

		// % protected region % [Add any additional logic for create before returning the newly updated entity here] off begin
		// % protected region % [Add any additional logic for create before returning the newly updated entity here] end

		return newEntity;
	}

	/**
	 * Similar to {@link DiagnosesAndProceduresMutationResolver#updateDiagnosesAndProcedures(DiagnosesAndProceduresEntity, Boolean)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'update')")
	public List<DiagnosesAndProceduresEntity> updateAllDiagnosesAndProcedures(@NonNull List<DiagnosesAndProceduresEntity> rawEntities) {
		List<DiagnosesAndProceduresEntity> newEntities = Lists.newArrayList(diagnosesAndProceduresService.updateAll(rawEntities));

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
	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'delete')")
	public String deleteDiagnosesAndProceduresById(@NonNull String id) {
		diagnosesAndProceduresService.deleteById(UUID.fromString(id));

		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity ID here] end

		return id;
	}

	/**
	 * Similar to {@link DiagnosesAndProceduresMutationResolver#deleteDiagnosesAndProceduresById(String)}
	 * but with multiple entities at once.
	 */
	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'delete')")
	public List<String> deleteAllDiagnosesAndProceduresByIds(@NonNull List<String> ids) {
		diagnosesAndProceduresService.deleteAllByIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] off begin
		// % protected region % [Add any additional logic for update before returning the deleted entity IDs here] end

		return ids;
	}

	@PreAuthorize("hasPermission('DiagnosesAndProceduresEntity', 'delete')")
	public List<String> deleteDiagnosesAndProceduresExcludingIds(@NonNull List<String> ids) {
		diagnosesAndProceduresService.deleteAllExcludingIds(ids.stream().map(UUID::fromString).collect(Collectors.toList()));

		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] off begin
		// % protected region % [Add any additional logic for update before returning the deleted IDs after deletion excluding IDs ] end

		return ids;
	}


	// % protected region % [Import any additional class methods here] off begin
	// % protected region % [Import any additional class methods here] end
}
