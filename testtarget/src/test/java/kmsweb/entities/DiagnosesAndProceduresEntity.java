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
package kmsweb.entities;

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class DiagnosesAndProceduresEntity extends AbstractEntity {

	public DiagnosesAndProceduresEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AdmissionICD10OneMany = new EntityReference();
			AdmissionICD10OneMany.entityName = "Registration";
			AdmissionICD10OneMany.oppositeName = "AdmissionICD10";
			AdmissionICD10OneMany.name = "AdmissionICD10";
			AdmissionICD10OneMany.optional = true;
			AdmissionICD10OneMany.type = "One";
			AdmissionICD10OneMany.oppositeType = "Many";

		References.add(AdmissionICD10OneMany);

		var AdmissionICD9CMOneMany = new EntityReference();
			AdmissionICD9CMOneMany.entityName = "Registration";
			AdmissionICD9CMOneMany.oppositeName = "AdmissionICD9CM";
			AdmissionICD9CMOneMany.name = "AdmissionICD9CM";
			AdmissionICD9CMOneMany.optional = true;
			AdmissionICD9CMOneMany.type = "One";
			AdmissionICD9CMOneMany.oppositeType = "Many";

		References.add(AdmissionICD9CMOneMany);

		var CpptICD10OneMany = new EntityReference();
			CpptICD10OneMany.entityName = "DailyCareCPPT";
			CpptICD10OneMany.oppositeName = "Icd10";
			CpptICD10OneMany.name = "CpptICD10";
			CpptICD10OneMany.optional = true;
			CpptICD10OneMany.type = "One";
			CpptICD10OneMany.oppositeType = "Many";

		References.add(CpptICD10OneMany);

		var CpptICD9CMOneMany = new EntityReference();
			CpptICD9CMOneMany.entityName = "DailyCareCPPT";
			CpptICD9CMOneMany.oppositeName = "Icd9CM";
			CpptICD9CMOneMany.name = "CpptICD9CM";
			CpptICD9CMOneMany.optional = true;
			CpptICD9CMOneMany.type = "One";
			CpptICD9CMOneMany.oppositeType = "Many";

		References.add(CpptICD9CMOneMany);

		var BpjsDiagnoseOneOne = new EntityReference();
			BpjsDiagnoseOneOne.entityName = "BpjsDiagnose";
			BpjsDiagnoseOneOne.oppositeName = "BpjsDiagnose";
			BpjsDiagnoseOneOne.name = "DiagnosesAndProcedures";
			BpjsDiagnoseOneOne.optional = true;
			BpjsDiagnoseOneOne.type = "One";
			BpjsDiagnoseOneOne.oppositeType = "One";

		References.add(BpjsDiagnoseOneOne);

		var BpjsDiagnosePRBOneOne = new EntityReference();
			BpjsDiagnosePRBOneOne.entityName = "BpjsDiagnosePRB";
			BpjsDiagnosePRBOneOne.oppositeName = "BpjsDiagnosePRB";
			BpjsDiagnosePRBOneOne.name = "DiagnosesAndProcedures";
			BpjsDiagnosePRBOneOne.optional = true;
			BpjsDiagnosePRBOneOne.type = "One";
			BpjsDiagnosePRBOneOne.oppositeType = "One";

		References.add(BpjsDiagnosePRBOneOne);

		var DiagnosisNandasManyMany = new EntityReference();
			DiagnosisNandasManyMany.entityName = "DiagnosisNanda";
			DiagnosisNandasManyMany.oppositeName = "Nursing";
			DiagnosisNandasManyMany.name = "DiagnosisNandas";
			DiagnosisNandasManyMany.optional = true;
			DiagnosisNandasManyMany.type = "Many";
			DiagnosisNandasManyMany.oppositeType = "Many";

		References.add(DiagnosisNandasManyMany);

		var DischargeICD10OneMany = new EntityReference();
			DischargeICD10OneMany.entityName = "MedicalCertificateDischargeResume";
			DischargeICD10OneMany.oppositeName = "DischargeICD10";
			DischargeICD10OneMany.name = "DischargeICD10";
			DischargeICD10OneMany.optional = true;
			DischargeICD10OneMany.type = "One";
			DischargeICD10OneMany.oppositeType = "Many";

		References.add(DischargeICD10OneMany);

		var DischargeICD9CMOneMany = new EntityReference();
			DischargeICD9CMOneMany.entityName = "MedicalCertificateDischargeResume";
			DischargeICD9CMOneMany.oppositeName = "DischargeICD9CM";
			DischargeICD9CMOneMany.name = "DischargeICD9CM";
			DischargeICD9CMOneMany.optional = true;
			DischargeICD9CMOneMany.type = "One";
			DischargeICD9CMOneMany.oppositeType = "Many";

		References.add(DischargeICD9CMOneMany);

		var Icd10OneMany = new EntityReference();
			Icd10OneMany.entityName = "DiagnosisExaminationRecord";
			Icd10OneMany.oppositeName = "Icd10";
			Icd10OneMany.name = "Icd10";
			Icd10OneMany.optional = true;
			Icd10OneMany.type = "One";
			Icd10OneMany.oppositeType = "Many";

		References.add(Icd10OneMany);

		var Icd9CMOneMany = new EntityReference();
			Icd9CMOneMany.entityName = "DiagnosisExaminationRecord";
			Icd9CMOneMany.oppositeName = "Icd9CM";
			Icd9CMOneMany.name = "Icd9CM";
			Icd9CMOneMany.optional = true;
			Icd9CMOneMany.type = "One";
			Icd9CMOneMany.oppositeType = "Many";

		References.add(Icd9CMOneMany);

		var InvoicesICD10OneMany = new EntityReference();
			InvoicesICD10OneMany.entityName = "Invoice";
			InvoicesICD10OneMany.oppositeName = "Icd10";
			InvoicesICD10OneMany.name = "InvoicesICD10";
			InvoicesICD10OneMany.optional = true;
			InvoicesICD10OneMany.type = "One";
			InvoicesICD10OneMany.oppositeType = "Many";

		References.add(InvoicesICD10OneMany);

		var InvoicesICD9CMOneMany = new EntityReference();
			InvoicesICD9CMOneMany.entityName = "Invoice";
			InvoicesICD9CMOneMany.oppositeName = "Icd9CM";
			InvoicesICD9CMOneMany.name = "InvoicesICD9CM";
			InvoicesICD9CMOneMany.optional = true;
			InvoicesICD9CMOneMany.type = "One";
			InvoicesICD9CMOneMany.oppositeType = "Many";

		References.add(InvoicesICD9CMOneMany);

		var MasterICD10OneOne = new EntityReference();
			MasterICD10OneOne.entityName = "Icd10";
			MasterICD10OneOne.oppositeName = "DiagnosesAndProcedures";
			MasterICD10OneOne.name = "MasterICD10";
			MasterICD10OneOne.optional = true;
			MasterICD10OneOne.type = "One";
			MasterICD10OneOne.oppositeType = "One";

		References.add(MasterICD10OneOne);

		var MasterICD9CMOneOne = new EntityReference();
			MasterICD9CMOneOne.entityName = "Icd9CM";
			MasterICD9CMOneOne.oppositeName = "DiagnosesAndProcedures";
			MasterICD9CMOneOne.name = "MasterICD9CM";
			MasterICD9CMOneOne.optional = true;
			MasterICD9CMOneOne.type = "One";
			MasterICD9CMOneOne.oppositeType = "One";

		References.add(MasterICD9CMOneOne);

		var PostOperativeICD10OneMany = new EntityReference();
			PostOperativeICD10OneMany.entityName = "PostOperativeDetails";
			PostOperativeICD10OneMany.oppositeName = "PostOperativeICD10";
			PostOperativeICD10OneMany.name = "PostOperativeICD10";
			PostOperativeICD10OneMany.optional = true;
			PostOperativeICD10OneMany.type = "One";
			PostOperativeICD10OneMany.oppositeType = "Many";

		References.add(PostOperativeICD10OneMany);

		var PostOperativeICD9CMOneMany = new EntityReference();
			PostOperativeICD9CMOneMany.entityName = "PostOperativeDetails";
			PostOperativeICD9CMOneMany.oppositeName = "PostOperativeICD9CM";
			PostOperativeICD9CMOneMany.name = "PostOperativeICD9CM";
			PostOperativeICD9CMOneMany.optional = true;
			PostOperativeICD9CMOneMany.type = "One";
			PostOperativeICD9CMOneMany.oppositeType = "Many";

		References.add(PostOperativeICD9CMOneMany);

		var PreSurgeryICD10OneMany = new EntityReference();
			PreSurgeryICD10OneMany.entityName = "PreoperativeRecords";
			PreSurgeryICD10OneMany.oppositeName = "PreSurgeryICD10";
			PreSurgeryICD10OneMany.name = "PreSurgeryICD10";
			PreSurgeryICD10OneMany.optional = true;
			PreSurgeryICD10OneMany.type = "One";
			PreSurgeryICD10OneMany.oppositeType = "Many";

		References.add(PreSurgeryICD10OneMany);

		var PreSurgeryICD9CMOneMany = new EntityReference();
			PreSurgeryICD9CMOneMany.entityName = "PreoperativeRecords";
			PreSurgeryICD9CMOneMany.oppositeName = "PreSurgeryICD9CM";
			PreSurgeryICD9CMOneMany.name = "PreSurgeryICD9CM";
			PreSurgeryICD9CMOneMany.optional = true;
			PreSurgeryICD9CMOneMany.type = "One";
			PreSurgeryICD9CMOneMany.oppositeType = "Many";

		References.add(PreSurgeryICD9CMOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Item Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Type here] end
	private String itemType;

	// % protected region % [Modify attribute annotation for Item Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Code here] end
	private String itemCode;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Icd10Entity masterICD10;

	private Icd9CMEntity masterICD9CM;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsDiagnoseEntity bpjsDiagnose;

	private BpjsDiagnosePRBEntity bpjsDiagnosePRB;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<RegistrationEntity> admissionICD10 = new HashSet<>();

	private Set<RegistrationEntity> admissionICD9CM = new HashSet<>();

	private Set<DailyCareCPPTEntity> cpptICD10 = new HashSet<>();

	private Set<DailyCareCPPTEntity> cpptICD9CM = new HashSet<>();

	private Set<MedicalCertificateDischargeResumeEntity> dischargeICD10 = new HashSet<>();

	private Set<MedicalCertificateDischargeResumeEntity> dischargeICD9CM = new HashSet<>();

	private Set<DiagnosisExaminationRecordEntity> icd10 = new HashSet<>();

	private Set<DiagnosisExaminationRecordEntity> icd9CM = new HashSet<>();

	private Set<InvoiceEntity> invoicesICD10 = new HashSet<>();

	private Set<InvoiceEntity> invoicesICD9CM = new HashSet<>();

	private Set<PostOperativeDetailsEntity> postOperativeICD10 = new HashSet<>();

	private Set<PostOperativeDetailsEntity> postOperativeICD9CM = new HashSet<>();

	private Set<PreoperativeRecordsEntity> preSurgeryICD10 = new HashSet<>();

	private Set<PreoperativeRecordsEntity> preSurgeryICD9CM = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<DiagnosisNandaEntity> diagnosisNandas = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addAdmissionICD10(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addAdmissionICD10(@NonNull RegistrationEntity entity) {
		addAdmissionICD10(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to admissionICD10 in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdmissionICD10(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.admissionICD10.contains(entity)) {
			admissionICD10.add(entity);
			if (reverseAdd) {
				entity.setAdmissionICD10(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdmissionICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addAdmissionICD10(@NonNull Collection<RegistrationEntity> entities) {
		addAdmissionICD10(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Admission ICD 10 in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdmissionICD10(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdmissionICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdmissionICD10(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeAdmissionICD10(@NonNull RegistrationEntity entity) {
		this.removeAdmissionICD10(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdmissionICD10(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdmissionICD10(false);
		}
		this.admissionICD10.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdmissionICD10(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeAdmissionICD10(@NonNull Collection<RegistrationEntity> entities) {
		this.removeAdmissionICD10(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdmissionICD10(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdmissionICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdmissionICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setAdmissionICD10(@NonNull Collection<RegistrationEntity> entities) {
		setAdmissionICD10(entities, true);
	}

	/**
	 * Replace the current entities in Admission ICD 10 with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdmissionICD10(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetAdmissionICD10();
		this.admissionICD10 = new HashSet<>(entities);
		if (reverseAdd) {
			this.admissionICD10.forEach(admissionICD10Entity -> admissionICD10Entity.setAdmissionICD10(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdmissionICD10(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdmissionICD10() {
		this.unsetAdmissionICD10(true);
	}

	/**
	 * Remove all the entities in Admission ICD 10 from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdmissionICD10(boolean doReverse) {
		if (doReverse) {
			this.admissionICD10.forEach(admissionICD10Entity -> admissionICD10Entity.unsetAdmissionICD10(false));
		}
		this.admissionICD10.clear();
	}

/**
	 * Similar to {@link this#addAdmissionICD9CM(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addAdmissionICD9CM(@NonNull RegistrationEntity entity) {
		addAdmissionICD9CM(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to admissionICD9CM in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdmissionICD9CM(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.admissionICD9CM.contains(entity)) {
			admissionICD9CM.add(entity);
			if (reverseAdd) {
				entity.setAdmissionICD9CM(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdmissionICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addAdmissionICD9CM(@NonNull Collection<RegistrationEntity> entities) {
		addAdmissionICD9CM(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Admission ICD 9 CM in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdmissionICD9CM(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdmissionICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdmissionICD9CM(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeAdmissionICD9CM(@NonNull RegistrationEntity entity) {
		this.removeAdmissionICD9CM(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdmissionICD9CM(@NonNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdmissionICD9CM(false);
		}
		this.admissionICD9CM.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdmissionICD9CM(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeAdmissionICD9CM(@NonNull Collection<RegistrationEntity> entities) {
		this.removeAdmissionICD9CM(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdmissionICD9CM(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdmissionICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdmissionICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setAdmissionICD9CM(@NonNull Collection<RegistrationEntity> entities) {
		setAdmissionICD9CM(entities, true);
	}

	/**
	 * Replace the current entities in Admission ICD 9 CM with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdmissionICD9CM(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetAdmissionICD9CM();
		this.admissionICD9CM = new HashSet<>(entities);
		if (reverseAdd) {
			this.admissionICD9CM.forEach(admissionICD9CMEntity -> admissionICD9CMEntity.setAdmissionICD9CM(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdmissionICD9CM(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdmissionICD9CM() {
		this.unsetAdmissionICD9CM(true);
	}

	/**
	 * Remove all the entities in Admission ICD 9 CM from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdmissionICD9CM(boolean doReverse) {
		if (doReverse) {
			this.admissionICD9CM.forEach(admissionICD9CMEntity -> admissionICD9CMEntity.unsetAdmissionICD9CM(false));
		}
		this.admissionICD9CM.clear();
	}

/**
	 * Similar to {@link this#addCpptICD10(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addCpptICD10(@NonNull DailyCareCPPTEntity entity) {
		addCpptICD10(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to cpptICD10 in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCpptICD10(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.cpptICD10.contains(entity)) {
			cpptICD10.add(entity);
			if (reverseAdd) {
				entity.setIcd10(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCpptICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addCpptICD10(@NonNull Collection<DailyCareCPPTEntity> entities) {
		addCpptICD10(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to CPPT ICD 10 in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCpptICD10(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCpptICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCpptICD10(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeCpptICD10(@NonNull DailyCareCPPTEntity entity) {
		this.removeCpptICD10(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCpptICD10(@NonNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetIcd10(false);
		}
		this.cpptICD10.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCpptICD10(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeCpptICD10(@NonNull Collection<DailyCareCPPTEntity> entities) {
		this.removeCpptICD10(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCpptICD10(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCpptICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCpptICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setCpptICD10(@NonNull Collection<DailyCareCPPTEntity> entities) {
		setCpptICD10(entities, true);
	}

	/**
	 * Replace the current entities in CPPT ICD 10 with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCpptICD10(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetCpptICD10();
		this.cpptICD10 = new HashSet<>(entities);
		if (reverseAdd) {
			this.cpptICD10.forEach(cpptICD10Entity -> cpptICD10Entity.setIcd10(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCpptICD10(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCpptICD10() {
		this.unsetCpptICD10(true);
	}

	/**
	 * Remove all the entities in CPPT ICD 10 from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCpptICD10(boolean doReverse) {
		if (doReverse) {
			this.cpptICD10.forEach(cpptICD10Entity -> cpptICD10Entity.unsetIcd10(false));
		}
		this.cpptICD10.clear();
	}

/**
	 * Similar to {@link this#addCpptICD9CM(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be added to this entity
	 */
	public void addCpptICD9CM(@NonNull DailyCareCPPTEntity entity) {
		addCpptICD9CM(entity, true);
	}

	/**
	 * Add a new DailyCareCPPTEntity to cpptICD9CM in this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCpptICD9CM(@NonNull DailyCareCPPTEntity entity, boolean reverseAdd) {
		if (!this.cpptICD9CM.contains(entity)) {
			cpptICD9CM.add(entity);
			if (reverseAdd) {
				entity.setIcd9CM(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCpptICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 */
	public void addCpptICD9CM(@NonNull Collection<DailyCareCPPTEntity> entities) {
		addCpptICD9CM(entities, true);
	}

	/**
	 * Add a new collection of DailyCareCPPTEntity to CPPT ICD 9 CM in this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCpptICD9CM(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCpptICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCpptICD9CM(DailyCareCPPTEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DailyCareCPPTEntity to be set to this entity
	 */
	public void removeCpptICD9CM(@NonNull DailyCareCPPTEntity entity) {
		this.removeCpptICD9CM(entity, true);
	}

	/**
	 * Remove the given DailyCareCPPTEntity from this entity.
	 *
	 * @param entity the given DailyCareCPPTEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCpptICD9CM(@NonNull DailyCareCPPTEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetIcd9CM(false);
		}
		this.cpptICD9CM.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCpptICD9CM(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 */
	public void removeCpptICD9CM(@NonNull Collection<DailyCareCPPTEntity> entities) {
		this.removeCpptICD9CM(entities, true);
	}

	/**
	 * Remove the given collection of DailyCareCPPTEntity from  to this entity.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCpptICD9CM(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCpptICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCpptICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to be set to this entity
	 */
	public void setCpptICD9CM(@NonNull Collection<DailyCareCPPTEntity> entities) {
		setCpptICD9CM(entities, true);
	}

	/**
	 * Replace the current entities in CPPT ICD 9 CM with the given ones.
	 *
	 * @param entities the given collection of DailyCareCPPTEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCpptICD9CM(@NonNull Collection<DailyCareCPPTEntity> entities, boolean reverseAdd) {

		this.unsetCpptICD9CM();
		this.cpptICD9CM = new HashSet<>(entities);
		if (reverseAdd) {
			this.cpptICD9CM.forEach(cpptICD9CMEntity -> cpptICD9CMEntity.setIcd9CM(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCpptICD9CM(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCpptICD9CM() {
		this.unsetCpptICD9CM(true);
	}

	/**
	 * Remove all the entities in CPPT ICD 9 CM from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCpptICD9CM(boolean doReverse) {
		if (doReverse) {
			this.cpptICD9CM.forEach(cpptICD9CMEntity -> cpptICD9CMEntity.unsetIcd9CM(false));
		}
		this.cpptICD9CM.clear();
	}

	/**
	 * Similar to {@link this#addDiagnosisNandas(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be added to this entity
	 */
	public void addDiagnosisNandas(@NonNull DiagnosisNandaEntity entity) {
		addDiagnosisNandas(entity, true);
	}

	/**
	 * Add a new DiagnosisNandaEntity to Diagnosis Nandas in this entity.
	 *
	 * @param entity the given DiagnosisNandaEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDiagnosisNandas(@NonNull DiagnosisNandaEntity entity, boolean reverseAdd) {
		if (!this.diagnosisNandas.contains(entity)) {
			this.diagnosisNandas.add(entity);
			if (reverseAdd) {
				entity.addNursing(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDiagnosisNandas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be added to this entity
	 */
	public void addDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities) {
		addDiagnosisNandas(entities, true);
	}

	/**
	 * Add new collection of DiagnosisNandaEntity to diagnosisNandas in this entity.
	 *
	 * @param entities the given entities to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDiagnosisNandas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDiagnosisNandas(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set to this entity
	 */
	public void removeDiagnosisNandas(@NonNull DiagnosisNandaEntity entity) {
		this.removeDiagnosisNandas(entity, true);
	}

	/**
	 * Remove the given DiagnosisNandaEntity from this entity.
	 *
	 * @param entity the give DiagnosisNandaEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDiagnosisNandas(@NonNull DiagnosisNandaEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeNursing(this, false);
		}
		this.diagnosisNandas.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDiagnosisNandas(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given entities to be removed to this entity
	 */
	public void removeDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities) {
		this.removeDiagnosisNandas(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosisNandaEntity in diagnosisNandas from  to this entity.
	 *
	 * @param entities the given entities to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDiagnosisNandas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDiagnosisNandas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given entities to be set to this entity
	 */
	public void setDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities) {
		this.setDiagnosisNandas(entities, true);
	}

	/**
	 * Replace the current entities in diagnosisNandas with the given ones.
	 *
	 * @param entities the given entities to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDiagnosisNandas(@NonNull Collection<DiagnosisNandaEntity> entities, boolean reverseAdd) {
		this.unsetDiagnosisNandas();
		this.diagnosisNandas = new HashSet<>(entities);
		if (reverseAdd) {
			this.diagnosisNandas.forEach(entity -> entity.addNursing(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDiagnosisNandas(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDiagnosisNandas() {
		this.unsetDiagnosisNandas(true);
	}

	/**
	 * Remove all entities in diagnosisNandas from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDiagnosisNandas(boolean doReverse) {
		if (doReverse) {
			this.diagnosisNandas.forEach(entity -> entity.removeNursing(this, false));
		}
		this.diagnosisNandas.clear();
	}

/**
	 * Similar to {@link this#addDischargeICD10(MedicalCertificateDischargeResumeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be added to this entity
	 */
	public void addDischargeICD10(@NonNull MedicalCertificateDischargeResumeEntity entity) {
		addDischargeICD10(entity, true);
	}

	/**
	 * Add a new MedicalCertificateDischargeResumeEntity to dischargeICD10 in this entity.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDischargeICD10(@NonNull MedicalCertificateDischargeResumeEntity entity, boolean reverseAdd) {
		if (!this.dischargeICD10.contains(entity)) {
			dischargeICD10.add(entity);
			if (reverseAdd) {
				entity.setDischargeICD10(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDischargeICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be added to this entity
	 */
	public void addDischargeICD10(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		addDischargeICD10(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateDischargeResumeEntity to Discharge ICD 10 in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDischargeICD10(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDischargeICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDischargeICD10(MedicalCertificateDischargeResumeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be set to this entity
	 */
	public void removeDischargeICD10(@NonNull MedicalCertificateDischargeResumeEntity entity) {
		this.removeDischargeICD10(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateDischargeResumeEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDischargeICD10(@NonNull MedicalCertificateDischargeResumeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDischargeICD10(false);
		}
		this.dischargeICD10.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDischargeICD10(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be removed to this entity
	 */
	public void removeDischargeICD10(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		this.removeDischargeICD10(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateDischargeResumeEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDischargeICD10(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDischargeICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDischargeICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be set to this entity
	 */
	public void setDischargeICD10(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		setDischargeICD10(entities, true);
	}

	/**
	 * Replace the current entities in Discharge ICD 10 with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDischargeICD10(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {

		this.unsetDischargeICD10();
		this.dischargeICD10 = new HashSet<>(entities);
		if (reverseAdd) {
			this.dischargeICD10.forEach(dischargeICD10Entity -> dischargeICD10Entity.setDischargeICD10(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDischargeICD10(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDischargeICD10() {
		this.unsetDischargeICD10(true);
	}

	/**
	 * Remove all the entities in Discharge ICD 10 from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDischargeICD10(boolean doReverse) {
		if (doReverse) {
			this.dischargeICD10.forEach(dischargeICD10Entity -> dischargeICD10Entity.unsetDischargeICD10(false));
		}
		this.dischargeICD10.clear();
	}

/**
	 * Similar to {@link this#addDischargeICD9CM(MedicalCertificateDischargeResumeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be added to this entity
	 */
	public void addDischargeICD9CM(@NonNull MedicalCertificateDischargeResumeEntity entity) {
		addDischargeICD9CM(entity, true);
	}

	/**
	 * Add a new MedicalCertificateDischargeResumeEntity to dischargeICD9CM in this entity.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDischargeICD9CM(@NonNull MedicalCertificateDischargeResumeEntity entity, boolean reverseAdd) {
		if (!this.dischargeICD9CM.contains(entity)) {
			dischargeICD9CM.add(entity);
			if (reverseAdd) {
				entity.setDischargeICD9CM(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDischargeICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be added to this entity
	 */
	public void addDischargeICD9CM(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		addDischargeICD9CM(entities, true);
	}

	/**
	 * Add a new collection of MedicalCertificateDischargeResumeEntity to Discharge ICD 9 CM in this entity.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDischargeICD9CM(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDischargeICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDischargeICD9CM(MedicalCertificateDischargeResumeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be set to this entity
	 */
	public void removeDischargeICD9CM(@NonNull MedicalCertificateDischargeResumeEntity entity) {
		this.removeDischargeICD9CM(entity, true);
	}

	/**
	 * Remove the given MedicalCertificateDischargeResumeEntity from this entity.
	 *
	 * @param entity the given MedicalCertificateDischargeResumeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDischargeICD9CM(@NonNull MedicalCertificateDischargeResumeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDischargeICD9CM(false);
		}
		this.dischargeICD9CM.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDischargeICD9CM(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be removed to this entity
	 */
	public void removeDischargeICD9CM(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		this.removeDischargeICD9CM(entities, true);
	}

	/**
	 * Remove the given collection of MedicalCertificateDischargeResumeEntity from  to this entity.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDischargeICD9CM(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDischargeICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDischargeICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to be set to this entity
	 */
	public void setDischargeICD9CM(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities) {
		setDischargeICD9CM(entities, true);
	}

	/**
	 * Replace the current entities in Discharge ICD 9 CM with the given ones.
	 *
	 * @param entities the given collection of MedicalCertificateDischargeResumeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDischargeICD9CM(@NonNull Collection<MedicalCertificateDischargeResumeEntity> entities, boolean reverseAdd) {

		this.unsetDischargeICD9CM();
		this.dischargeICD9CM = new HashSet<>(entities);
		if (reverseAdd) {
			this.dischargeICD9CM.forEach(dischargeICD9CMEntity -> dischargeICD9CMEntity.setDischargeICD9CM(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDischargeICD9CM(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDischargeICD9CM() {
		this.unsetDischargeICD9CM(true);
	}

	/**
	 * Remove all the entities in Discharge ICD 9 CM from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDischargeICD9CM(boolean doReverse) {
		if (doReverse) {
			this.dischargeICD9CM.forEach(dischargeICD9CMEntity -> dischargeICD9CMEntity.unsetDischargeICD9CM(false));
		}
		this.dischargeICD9CM.clear();
	}

/**
	 * Similar to {@link this#addIcd10(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be added to this entity
	 */
	public void addIcd10(@NonNull DiagnosisExaminationRecordEntity entity) {
		addIcd10(entity, true);
	}

	/**
	 * Add a new DiagnosisExaminationRecordEntity to icd10 in this entity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addIcd10(@NonNull DiagnosisExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.icd10.contains(entity)) {
			icd10.add(entity);
			if (reverseAdd) {
				entity.setIcd10(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addIcd10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be added to this entity
	 */
	public void addIcd10(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		addIcd10(entities, true);
	}

	/**
	 * Add a new collection of DiagnosisExaminationRecordEntity to ICD 10 in this entity.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addIcd10(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addIcd10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeIcd10(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void removeIcd10(@NonNull DiagnosisExaminationRecordEntity entity) {
		this.removeIcd10(entity, true);
	}

	/**
	 * Remove the given DiagnosisExaminationRecordEntity from this entity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeIcd10(@NonNull DiagnosisExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetIcd10(false);
		}
		this.icd10.remove(entity);
	}

	/**
	 * Similar to {@link this#removeIcd10(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be removed to this entity
	 */
	public void removeIcd10(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		this.removeIcd10(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosisExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeIcd10(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeIcd10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setIcd10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setIcd10(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		setIcd10(entities, true);
	}

	/**
	 * Replace the current entities in ICD 10 with the given ones.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setIcd10(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetIcd10();
		this.icd10 = new HashSet<>(entities);
		if (reverseAdd) {
			this.icd10.forEach(icd10Entity -> icd10Entity.setIcd10(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetIcd10(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetIcd10() {
		this.unsetIcd10(true);
	}

	/**
	 * Remove all the entities in ICD 10 from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetIcd10(boolean doReverse) {
		if (doReverse) {
			this.icd10.forEach(icd10Entity -> icd10Entity.unsetIcd10(false));
		}
		this.icd10.clear();
	}

/**
	 * Similar to {@link this#addIcd9CM(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be added to this entity
	 */
	public void addIcd9CM(@NonNull DiagnosisExaminationRecordEntity entity) {
		addIcd9CM(entity, true);
	}

	/**
	 * Add a new DiagnosisExaminationRecordEntity to icd9CM in this entity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addIcd9CM(@NonNull DiagnosisExaminationRecordEntity entity, boolean reverseAdd) {
		if (!this.icd9CM.contains(entity)) {
			icd9CM.add(entity);
			if (reverseAdd) {
				entity.setIcd9CM(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addIcd9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be added to this entity
	 */
	public void addIcd9CM(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		addIcd9CM(entities, true);
	}

	/**
	 * Add a new collection of DiagnosisExaminationRecordEntity to ICD 9 CM in this entity.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addIcd9CM(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addIcd9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeIcd9CM(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void removeIcd9CM(@NonNull DiagnosisExaminationRecordEntity entity) {
		this.removeIcd9CM(entity, true);
	}

	/**
	 * Remove the given DiagnosisExaminationRecordEntity from this entity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeIcd9CM(@NonNull DiagnosisExaminationRecordEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetIcd9CM(false);
		}
		this.icd9CM.remove(entity);
	}

	/**
	 * Similar to {@link this#removeIcd9CM(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be removed to this entity
	 */
	public void removeIcd9CM(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		this.removeIcd9CM(entities, true);
	}

	/**
	 * Remove the given collection of DiagnosisExaminationRecordEntity from  to this entity.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeIcd9CM(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeIcd9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setIcd9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setIcd9CM(@NonNull Collection<DiagnosisExaminationRecordEntity> entities) {
		setIcd9CM(entities, true);
	}

	/**
	 * Replace the current entities in ICD 9 CM with the given ones.
	 *
	 * @param entities the given collection of DiagnosisExaminationRecordEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setIcd9CM(@NonNull Collection<DiagnosisExaminationRecordEntity> entities, boolean reverseAdd) {

		this.unsetIcd9CM();
		this.icd9CM = new HashSet<>(entities);
		if (reverseAdd) {
			this.icd9CM.forEach(icd9CMEntity -> icd9CMEntity.setIcd9CM(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetIcd9CM(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetIcd9CM() {
		this.unsetIcd9CM(true);
	}

	/**
	 * Remove all the entities in ICD 9 CM from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetIcd9CM(boolean doReverse) {
		if (doReverse) {
			this.icd9CM.forEach(icd9CMEntity -> icd9CMEntity.unsetIcd9CM(false));
		}
		this.icd9CM.clear();
	}

/**
	 * Similar to {@link this#addInvoicesICD10(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be added to this entity
	 */
	public void addInvoicesICD10(@NonNull InvoiceEntity entity) {
		addInvoicesICD10(entity, true);
	}

	/**
	 * Add a new InvoiceEntity to invoicesICD10 in this entity.
	 *
	 * @param entity the given InvoiceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoicesICD10(@NonNull InvoiceEntity entity, boolean reverseAdd) {
		if (!this.invoicesICD10.contains(entity)) {
			invoicesICD10.add(entity);
			if (reverseAdd) {
				entity.setIcd10(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoicesICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 */
	public void addInvoicesICD10(@NonNull Collection<InvoiceEntity> entities) {
		addInvoicesICD10(entities, true);
	}

	/**
	 * Add a new collection of InvoiceEntity to Invoices ICD 10 in this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoicesICD10(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoicesICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoicesICD10(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void removeInvoicesICD10(@NonNull InvoiceEntity entity) {
		this.removeInvoicesICD10(entity, true);
	}

	/**
	 * Remove the given InvoiceEntity from this entity.
	 *
	 * @param entity the given InvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoicesICD10(@NonNull InvoiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetIcd10(false);
		}
		this.invoicesICD10.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoicesICD10(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 */
	public void removeInvoicesICD10(@NonNull Collection<InvoiceEntity> entities) {
		this.removeInvoicesICD10(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoicesICD10(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoicesICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoicesICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be set to this entity
	 */
	public void setInvoicesICD10(@NonNull Collection<InvoiceEntity> entities) {
		setInvoicesICD10(entities, true);
	}

	/**
	 * Replace the current entities in Invoices ICD 10 with the given ones.
	 *
	 * @param entities the given collection of InvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoicesICD10(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {

		this.unsetInvoicesICD10();
		this.invoicesICD10 = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoicesICD10.forEach(invoicesICD10Entity -> invoicesICD10Entity.setIcd10(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoicesICD10(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoicesICD10() {
		this.unsetInvoicesICD10(true);
	}

	/**
	 * Remove all the entities in Invoices ICD 10 from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoicesICD10(boolean doReverse) {
		if (doReverse) {
			this.invoicesICD10.forEach(invoicesICD10Entity -> invoicesICD10Entity.unsetIcd10(false));
		}
		this.invoicesICD10.clear();
	}

/**
	 * Similar to {@link this#addInvoicesICD9CM(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be added to this entity
	 */
	public void addInvoicesICD9CM(@NonNull InvoiceEntity entity) {
		addInvoicesICD9CM(entity, true);
	}

	/**
	 * Add a new InvoiceEntity to invoicesICD9CM in this entity.
	 *
	 * @param entity the given InvoiceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoicesICD9CM(@NonNull InvoiceEntity entity, boolean reverseAdd) {
		if (!this.invoicesICD9CM.contains(entity)) {
			invoicesICD9CM.add(entity);
			if (reverseAdd) {
				entity.setIcd9CM(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoicesICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 */
	public void addInvoicesICD9CM(@NonNull Collection<InvoiceEntity> entities) {
		addInvoicesICD9CM(entities, true);
	}

	/**
	 * Add a new collection of InvoiceEntity to Invoices ICD 9 CM in this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoicesICD9CM(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoicesICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoicesICD9CM(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void removeInvoicesICD9CM(@NonNull InvoiceEntity entity) {
		this.removeInvoicesICD9CM(entity, true);
	}

	/**
	 * Remove the given InvoiceEntity from this entity.
	 *
	 * @param entity the given InvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoicesICD9CM(@NonNull InvoiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetIcd9CM(false);
		}
		this.invoicesICD9CM.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoicesICD9CM(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 */
	public void removeInvoicesICD9CM(@NonNull Collection<InvoiceEntity> entities) {
		this.removeInvoicesICD9CM(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoicesICD9CM(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoicesICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoicesICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be set to this entity
	 */
	public void setInvoicesICD9CM(@NonNull Collection<InvoiceEntity> entities) {
		setInvoicesICD9CM(entities, true);
	}

	/**
	 * Replace the current entities in Invoices ICD 9 CM with the given ones.
	 *
	 * @param entities the given collection of InvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoicesICD9CM(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {

		this.unsetInvoicesICD9CM();
		this.invoicesICD9CM = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoicesICD9CM.forEach(invoicesICD9CMEntity -> invoicesICD9CMEntity.setIcd9CM(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoicesICD9CM(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoicesICD9CM() {
		this.unsetInvoicesICD9CM(true);
	}

	/**
	 * Remove all the entities in Invoices ICD 9 CM from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoicesICD9CM(boolean doReverse) {
		if (doReverse) {
			this.invoicesICD9CM.forEach(invoicesICD9CMEntity -> invoicesICD9CMEntity.unsetIcd9CM(false));
		}
		this.invoicesICD9CM.clear();
	}

	/**
	 * Similar to {@link this#setMasterICD10(Icd10Entity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setMasterICD10(@NonNull Icd10Entity entity) {
		setMasterICD10(entity, true);
	}

	/**
	 * Set or update masterICD10 with the given Icd10Entity.
	 *
	 * @param entity the DiagnosesAndProceduresEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMasterICD10(@NonNull Icd10Entity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMasterICD10 here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMasterICD10 here] end

		if (sameAsFormer(this.masterICD10, entity)) {
			return;
		}

		if (this.masterICD10 != null) {
			this.masterICD10.unsetDiagnosesAndProcedures();
		}

		this.masterICD10 = entity;

		if (reverseAdd) {
			this.masterICD10.setDiagnosesAndProcedures(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMasterICD10 outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMasterICD10 outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMasterICD10(boolean)} but default to true.
	 */
	public void unsetMasterICD10() {
		this.unsetMasterICD10(true);
	}

	/**
	 * Remove the Icd10Entity in Master ICD 10 from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMasterICD10(boolean reverse) {
		if (reverse && this.masterICD10 != null) {
			this.masterICD10.unsetDiagnosesAndProcedures(false);
		}
		this.masterICD10 = null;
	}

	/**
	 * Similar to {@link this#setMasterICD9CM(Icd9CMEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setMasterICD9CM(@NonNull Icd9CMEntity entity) {
		setMasterICD9CM(entity, true);
	}

	/**
	 * Set or update masterICD9CM with the given Icd9CMEntity.
	 *
	 * @param entity the DiagnosesAndProceduresEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMasterICD9CM(@NonNull Icd9CMEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMasterICD9CM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMasterICD9CM here] end

		if (sameAsFormer(this.masterICD9CM, entity)) {
			return;
		}

		if (this.masterICD9CM != null) {
			this.masterICD9CM.unsetDiagnosesAndProcedures();
		}

		this.masterICD9CM = entity;

		if (reverseAdd) {
			this.masterICD9CM.setDiagnosesAndProcedures(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMasterICD9CM outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMasterICD9CM outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMasterICD9CM(boolean)} but default to true.
	 */
	public void unsetMasterICD9CM() {
		this.unsetMasterICD9CM(true);
	}

	/**
	 * Remove the Icd9CMEntity in Master ICD 9 CM from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMasterICD9CM(boolean reverse) {
		if (reverse && this.masterICD9CM != null) {
			this.masterICD9CM.unsetDiagnosesAndProcedures(false);
		}
		this.masterICD9CM = null;
	}

/**
	 * Similar to {@link this#addPostOperativeICD10(PostOperativeDetailsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be added to this entity
	 */
	public void addPostOperativeICD10(@NonNull PostOperativeDetailsEntity entity) {
		addPostOperativeICD10(entity, true);
	}

	/**
	 * Add a new PostOperativeDetailsEntity to postOperativeICD10 in this entity.
	 *
	 * @param entity the given PostOperativeDetailsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPostOperativeICD10(@NonNull PostOperativeDetailsEntity entity, boolean reverseAdd) {
		if (!this.postOperativeICD10.contains(entity)) {
			postOperativeICD10.add(entity);
			if (reverseAdd) {
				entity.setPostOperativeICD10(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPostOperativeICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be added to this entity
	 */
	public void addPostOperativeICD10(@NonNull Collection<PostOperativeDetailsEntity> entities) {
		addPostOperativeICD10(entities, true);
	}

	/**
	 * Add a new collection of PostOperativeDetailsEntity to Post Operative ICD 10 in this entity.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPostOperativeICD10(@NonNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPostOperativeICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePostOperativeICD10(PostOperativeDetailsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be set to this entity
	 */
	public void removePostOperativeICD10(@NonNull PostOperativeDetailsEntity entity) {
		this.removePostOperativeICD10(entity, true);
	}

	/**
	 * Remove the given PostOperativeDetailsEntity from this entity.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePostOperativeICD10(@NonNull PostOperativeDetailsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPostOperativeICD10(false);
		}
		this.postOperativeICD10.remove(entity);
	}

	/**
	 * Similar to {@link this#removePostOperativeICD10(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be removed to this entity
	 */
	public void removePostOperativeICD10(@NonNull Collection<PostOperativeDetailsEntity> entities) {
		this.removePostOperativeICD10(entities, true);
	}

	/**
	 * Remove the given collection of PostOperativeDetailsEntity from  to this entity.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePostOperativeICD10(@NonNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePostOperativeICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPostOperativeICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be set to this entity
	 */
	public void setPostOperativeICD10(@NonNull Collection<PostOperativeDetailsEntity> entities) {
		setPostOperativeICD10(entities, true);
	}

	/**
	 * Replace the current entities in Post Operative ICD 10 with the given ones.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPostOperativeICD10(@NonNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {

		this.unsetPostOperativeICD10();
		this.postOperativeICD10 = new HashSet<>(entities);
		if (reverseAdd) {
			this.postOperativeICD10.forEach(postOperativeICD10Entity -> postOperativeICD10Entity.setPostOperativeICD10(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPostOperativeICD10(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPostOperativeICD10() {
		this.unsetPostOperativeICD10(true);
	}

	/**
	 * Remove all the entities in Post Operative ICD 10 from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPostOperativeICD10(boolean doReverse) {
		if (doReverse) {
			this.postOperativeICD10.forEach(postOperativeICD10Entity -> postOperativeICD10Entity.unsetPostOperativeICD10(false));
		}
		this.postOperativeICD10.clear();
	}

/**
	 * Similar to {@link this#addPostOperativeICD9CM(PostOperativeDetailsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be added to this entity
	 */
	public void addPostOperativeICD9CM(@NonNull PostOperativeDetailsEntity entity) {
		addPostOperativeICD9CM(entity, true);
	}

	/**
	 * Add a new PostOperativeDetailsEntity to postOperativeICD9CM in this entity.
	 *
	 * @param entity the given PostOperativeDetailsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPostOperativeICD9CM(@NonNull PostOperativeDetailsEntity entity, boolean reverseAdd) {
		if (!this.postOperativeICD9CM.contains(entity)) {
			postOperativeICD9CM.add(entity);
			if (reverseAdd) {
				entity.setPostOperativeICD9CM(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPostOperativeICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be added to this entity
	 */
	public void addPostOperativeICD9CM(@NonNull Collection<PostOperativeDetailsEntity> entities) {
		addPostOperativeICD9CM(entities, true);
	}

	/**
	 * Add a new collection of PostOperativeDetailsEntity to Post Operative ICD 9 CM in this entity.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPostOperativeICD9CM(@NonNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPostOperativeICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePostOperativeICD9CM(PostOperativeDetailsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be set to this entity
	 */
	public void removePostOperativeICD9CM(@NonNull PostOperativeDetailsEntity entity) {
		this.removePostOperativeICD9CM(entity, true);
	}

	/**
	 * Remove the given PostOperativeDetailsEntity from this entity.
	 *
	 * @param entity the given PostOperativeDetailsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePostOperativeICD9CM(@NonNull PostOperativeDetailsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPostOperativeICD9CM(false);
		}
		this.postOperativeICD9CM.remove(entity);
	}

	/**
	 * Similar to {@link this#removePostOperativeICD9CM(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be removed to this entity
	 */
	public void removePostOperativeICD9CM(@NonNull Collection<PostOperativeDetailsEntity> entities) {
		this.removePostOperativeICD9CM(entities, true);
	}

	/**
	 * Remove the given collection of PostOperativeDetailsEntity from  to this entity.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePostOperativeICD9CM(@NonNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePostOperativeICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPostOperativeICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to be set to this entity
	 */
	public void setPostOperativeICD9CM(@NonNull Collection<PostOperativeDetailsEntity> entities) {
		setPostOperativeICD9CM(entities, true);
	}

	/**
	 * Replace the current entities in Post Operative ICD 9 CM with the given ones.
	 *
	 * @param entities the given collection of PostOperativeDetailsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPostOperativeICD9CM(@NonNull Collection<PostOperativeDetailsEntity> entities, boolean reverseAdd) {

		this.unsetPostOperativeICD9CM();
		this.postOperativeICD9CM = new HashSet<>(entities);
		if (reverseAdd) {
			this.postOperativeICD9CM.forEach(postOperativeICD9CMEntity -> postOperativeICD9CMEntity.setPostOperativeICD9CM(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPostOperativeICD9CM(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPostOperativeICD9CM() {
		this.unsetPostOperativeICD9CM(true);
	}

	/**
	 * Remove all the entities in Post Operative ICD 9 CM from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPostOperativeICD9CM(boolean doReverse) {
		if (doReverse) {
			this.postOperativeICD9CM.forEach(postOperativeICD9CMEntity -> postOperativeICD9CMEntity.unsetPostOperativeICD9CM(false));
		}
		this.postOperativeICD9CM.clear();
	}

/**
	 * Similar to {@link this#addPreSurgeryICD10(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addPreSurgeryICD10(@NonNull PreoperativeRecordsEntity entity) {
		addPreSurgeryICD10(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to preSurgeryICD10 in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPreSurgeryICD10(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.preSurgeryICD10.contains(entity)) {
			preSurgeryICD10.add(entity);
			if (reverseAdd) {
				entity.setPreSurgeryICD10(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPreSurgeryICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addPreSurgeryICD10(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		addPreSurgeryICD10(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Pre Surgery ICD 10 in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPreSurgeryICD10(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPreSurgeryICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePreSurgeryICD10(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removePreSurgeryICD10(@NonNull PreoperativeRecordsEntity entity) {
		this.removePreSurgeryICD10(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePreSurgeryICD10(@NonNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPreSurgeryICD10(false);
		}
		this.preSurgeryICD10.remove(entity);
	}

	/**
	 * Similar to {@link this#removePreSurgeryICD10(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removePreSurgeryICD10(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		this.removePreSurgeryICD10(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePreSurgeryICD10(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePreSurgeryICD10(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPreSurgeryICD10(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setPreSurgeryICD10(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		setPreSurgeryICD10(entities, true);
	}

	/**
	 * Replace the current entities in Pre Surgery ICD 10 with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPreSurgeryICD10(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetPreSurgeryICD10();
		this.preSurgeryICD10 = new HashSet<>(entities);
		if (reverseAdd) {
			this.preSurgeryICD10.forEach(preSurgeryICD10Entity -> preSurgeryICD10Entity.setPreSurgeryICD10(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPreSurgeryICD10(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPreSurgeryICD10() {
		this.unsetPreSurgeryICD10(true);
	}

	/**
	 * Remove all the entities in Pre Surgery ICD 10 from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPreSurgeryICD10(boolean doReverse) {
		if (doReverse) {
			this.preSurgeryICD10.forEach(preSurgeryICD10Entity -> preSurgeryICD10Entity.unsetPreSurgeryICD10(false));
		}
		this.preSurgeryICD10.clear();
	}

/**
	 * Similar to {@link this#addPreSurgeryICD9CM(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be added to this entity
	 */
	public void addPreSurgeryICD9CM(@NonNull PreoperativeRecordsEntity entity) {
		addPreSurgeryICD9CM(entity, true);
	}

	/**
	 * Add a new PreoperativeRecordsEntity to preSurgeryICD9CM in this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPreSurgeryICD9CM(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		if (!this.preSurgeryICD9CM.contains(entity)) {
			preSurgeryICD9CM.add(entity);
			if (reverseAdd) {
				entity.setPreSurgeryICD9CM(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPreSurgeryICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 */
	public void addPreSurgeryICD9CM(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		addPreSurgeryICD9CM(entities, true);
	}

	/**
	 * Add a new collection of PreoperativeRecordsEntity to Pre Surgery ICD 9 CM in this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPreSurgeryICD9CM(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPreSurgeryICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePreSurgeryICD9CM(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void removePreSurgeryICD9CM(@NonNull PreoperativeRecordsEntity entity) {
		this.removePreSurgeryICD9CM(entity, true);
	}

	/**
	 * Remove the given PreoperativeRecordsEntity from this entity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePreSurgeryICD9CM(@NonNull PreoperativeRecordsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPreSurgeryICD9CM(false);
		}
		this.preSurgeryICD9CM.remove(entity);
	}

	/**
	 * Similar to {@link this#removePreSurgeryICD9CM(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 */
	public void removePreSurgeryICD9CM(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		this.removePreSurgeryICD9CM(entities, true);
	}

	/**
	 * Remove the given collection of PreoperativeRecordsEntity from  to this entity.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePreSurgeryICD9CM(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePreSurgeryICD9CM(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPreSurgeryICD9CM(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to be set to this entity
	 */
	public void setPreSurgeryICD9CM(@NonNull Collection<PreoperativeRecordsEntity> entities) {
		setPreSurgeryICD9CM(entities, true);
	}

	/**
	 * Replace the current entities in Pre Surgery ICD 9 CM with the given ones.
	 *
	 * @param entities the given collection of PreoperativeRecordsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPreSurgeryICD9CM(@NonNull Collection<PreoperativeRecordsEntity> entities, boolean reverseAdd) {

		this.unsetPreSurgeryICD9CM();
		this.preSurgeryICD9CM = new HashSet<>(entities);
		if (reverseAdd) {
			this.preSurgeryICD9CM.forEach(preSurgeryICD9CMEntity -> preSurgeryICD9CMEntity.setPreSurgeryICD9CM(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPreSurgeryICD9CM(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPreSurgeryICD9CM() {
		this.unsetPreSurgeryICD9CM(true);
	}

	/**
	 * Remove all the entities in Pre Surgery ICD 9 CM from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPreSurgeryICD9CM(boolean doReverse) {
		if (doReverse) {
			this.preSurgeryICD9CM.forEach(preSurgeryICD9CMEntity -> preSurgeryICD9CMEntity.unsetPreSurgeryICD9CM(false));
		}
		this.preSurgeryICD9CM.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBpjsDiagnose(BpjsDiagnoseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set to this entity
	 */
	public void setBpjsDiagnose(BpjsDiagnoseEntity entity) {
		setBpjsDiagnose(entity, true);
	}

	/**
	 * Set or update the bpjsDiagnose in this entity with single BpjsDiagnoseEntity.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set or updated to bpjsDiagnose
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDiagnose(BpjsDiagnoseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnose here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnose here] end

		if (sameAsFormer(this.bpjsDiagnose, entity)) {
			return;
		}

		if (this.bpjsDiagnose != null) {
			this.bpjsDiagnose.unsetDiagnosesAndProcedures(false);
		}

		this.bpjsDiagnose = entity;
		if (reverseAdd) {
			this.bpjsDiagnose.setDiagnosesAndProcedures(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnose incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnose incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDiagnose(boolean)} but default to true.
	 */
	public void unsetBpjsDiagnose() {
		this.unsetBpjsDiagnose(true);
	}

	/**
	 * Remove the BpjsDiagnoseEntity of bpjsDiagnose from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDiagnose(boolean reverse) {
		if (reverse && this.bpjsDiagnose != null) {
			this.bpjsDiagnose.unsetDiagnosesAndProcedures();
		}
		this.bpjsDiagnose = null;
	}
	/**
	 * Similar to {@link this#setBpjsDiagnosePRB(BpjsDiagnosePRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnosePRBEntity to be set to this entity
	 */
	public void setBpjsDiagnosePRB(BpjsDiagnosePRBEntity entity) {
		setBpjsDiagnosePRB(entity, true);
	}

	/**
	 * Set or update the bpjsDiagnosePRB in this entity with single BpjsDiagnosePRBEntity.
	 *
	 * @param entity the given BpjsDiagnosePRBEntity to be set or updated to bpjsDiagnosePRB
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDiagnosePRB(BpjsDiagnosePRBEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnosePRB here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnosePRB here] end

		if (sameAsFormer(this.bpjsDiagnosePRB, entity)) {
			return;
		}

		if (this.bpjsDiagnosePRB != null) {
			this.bpjsDiagnosePRB.unsetDiagnosesAndProcedures(false);
		}

		this.bpjsDiagnosePRB = entity;
		if (reverseAdd) {
			this.bpjsDiagnosePRB.setDiagnosesAndProcedures(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnosePRB incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnosePRB incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDiagnosePRB(boolean)} but default to true.
	 */
	public void unsetBpjsDiagnosePRB() {
		this.unsetBpjsDiagnosePRB(true);
	}

	/**
	 * Remove the BpjsDiagnosePRBEntity of bpjsDiagnosePRB from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDiagnosePRB(boolean reverse) {
		if (reverse && this.bpjsDiagnosePRB != null) {
			this.bpjsDiagnosePRB.unsetDiagnosesAndProcedures();
		}
		this.bpjsDiagnosePRB = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
