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


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class DiagnosisExaminationRecordEntity extends AbstractEntity {

	public DiagnosisExaminationRecordEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneMany = new EntityReference();
			MedicalExaminationRecordOneMany.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneMany.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneMany.name = "DiagnosisExaminationRecords";
			MedicalExaminationRecordOneMany.optional = true;
			MedicalExaminationRecordOneMany.type = "One";
			MedicalExaminationRecordOneMany.oppositeType = "Many";

		References.add(MedicalExaminationRecordOneMany);

		var MedicalExaminationRecordDischargeSummaryOneMany = new EntityReference();
			MedicalExaminationRecordDischargeSummaryOneMany.entityName = "MedicalExaminationRecordDischargeSummary";
			MedicalExaminationRecordDischargeSummaryOneMany.oppositeName = "MedicalExaminationRecordDischargeSummary";
			MedicalExaminationRecordDischargeSummaryOneMany.name = "DiagnosisExaminationRecords";
			MedicalExaminationRecordDischargeSummaryOneMany.optional = true;
			MedicalExaminationRecordDischargeSummaryOneMany.type = "One";
			MedicalExaminationRecordDischargeSummaryOneMany.oppositeType = "Many";

		References.add(MedicalExaminationRecordDischargeSummaryOneMany);

		var DiagnosticStaffExaminationSummaryOneOne = new EntityReference();
			DiagnosticStaffExaminationSummaryOneOne.entityName = "DiagnosticStaffExaminationSummary";
			DiagnosticStaffExaminationSummaryOneOne.oppositeName = "DiagnosisExaminationRecord";
			DiagnosticStaffExaminationSummaryOneOne.name = "DiagnosticStaffExaminationSummary";
			DiagnosticStaffExaminationSummaryOneOne.optional = true;
			DiagnosticStaffExaminationSummaryOneOne.type = "One";
			DiagnosticStaffExaminationSummaryOneOne.oppositeType = "One";

		References.add(DiagnosticStaffExaminationSummaryOneOne);

		var Icd10OneMany = new EntityReference();
			Icd10OneMany.entityName = "DiagnosesAndProcedures";
			Icd10OneMany.oppositeName = "Icd10";
			Icd10OneMany.name = "Icd10";
			Icd10OneMany.optional = true;
			Icd10OneMany.type = "One";
			Icd10OneMany.oppositeType = "Many";

		References.add(Icd10OneMany);

		var Icd9CMOneMany = new EntityReference();
			Icd9CMOneMany.entityName = "DiagnosesAndProcedures";
			Icd9CMOneMany.oppositeName = "Icd9CM";
			Icd9CMOneMany.name = "Icd9CM";
			Icd9CMOneMany.optional = true;
			Icd9CMOneMany.type = "One";
			Icd9CMOneMany.oppositeType = "Many";

		References.add(Icd9CMOneMany);

		var SampleCollectionInformationOneOne = new EntityReference();
			SampleCollectionInformationOneOne.entityName = "SampleCollectionInformation";
			SampleCollectionInformationOneOne.oppositeName = "DiagnosisExaminationRecord";
			SampleCollectionInformationOneOne.name = "SampleCollectionInformation";
			SampleCollectionInformationOneOne.optional = true;
			SampleCollectionInformationOneOne.type = "One";
			SampleCollectionInformationOneOne.oppositeType = "One";

		References.add(SampleCollectionInformationOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Diagnosis Sequence here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diagnosis Sequence here] end
	private Integer diagnosisSequence;

	// % protected region % [Modify attribute annotation for Diagnosis Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diagnosis Notes here] end
	private String diagnosisNotes;

	// % protected region % [Modify attribute annotation for Action Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Action Notes here] end
	private String actionNotes;

	// % protected region % [Modify attribute annotation for New Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for New Case here] end
	private Boolean newCase;

	// % protected region % [Modify attribute annotation for Printing Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Printing Number here] end
	private Integer printingNumber;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosticStaffExaminationSummaryEntity diagnosticStaffExaminationSummary;

	private SampleCollectionInformationEntity sampleCollectionInformation;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	private MedicalExaminationRecordDischargeSummaryEntity medicalExaminationRecordDischargeSummary;

	private DiagnosesAndProceduresEntity icd10;

	private DiagnosesAndProceduresEntity icd9CM;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	 * Similar to {@link this#setDiagnosticStaffExaminationSummary(DiagnosticStaffExaminationSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setDiagnosticStaffExaminationSummary(@NonNull DiagnosticStaffExaminationSummaryEntity entity) {
		setDiagnosticStaffExaminationSummary(entity, true);
	}

	/**
	 * Set or update diagnosticStaffExaminationSummary with the given DiagnosticStaffExaminationSummaryEntity.
	 *
	 * @param entity the DiagnosisExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosticStaffExaminationSummary(@NonNull DiagnosticStaffExaminationSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticStaffExaminationSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosticStaffExaminationSummary here] end

		if (sameAsFormer(this.diagnosticStaffExaminationSummary, entity)) {
			return;
		}

		if (this.diagnosticStaffExaminationSummary != null) {
			this.diagnosticStaffExaminationSummary.unsetDiagnosisExaminationRecord();
		}

		this.diagnosticStaffExaminationSummary = entity;

		if (reverseAdd) {
			this.diagnosticStaffExaminationSummary.setDiagnosisExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosticStaffExaminationSummary outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosticStaffExaminationSummary outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosticStaffExaminationSummary(boolean)} but default to true.
	 */
	public void unsetDiagnosticStaffExaminationSummary() {
		this.unsetDiagnosticStaffExaminationSummary(true);
	}

	/**
	 * Remove the DiagnosticStaffExaminationSummaryEntity in Diagnostic Staff Examination Summary from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosticStaffExaminationSummary(boolean reverse) {
		if (reverse && this.diagnosticStaffExaminationSummary != null) {
			this.diagnosticStaffExaminationSummary.unsetDiagnosisExaminationRecord(false);
		}
		this.diagnosticStaffExaminationSummary = null;
	}

	/**
	 * Similar to {@link this#setSampleCollectionInformation(SampleCollectionInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setSampleCollectionInformation(@NonNull SampleCollectionInformationEntity entity) {
		setSampleCollectionInformation(entity, true);
	}

	/**
	 * Set or update sampleCollectionInformation with the given SampleCollectionInformationEntity.
	 *
	 * @param entity the DiagnosisExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleCollectionInformation(@NonNull SampleCollectionInformationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSampleCollectionInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSampleCollectionInformation here] end

		if (sameAsFormer(this.sampleCollectionInformation, entity)) {
			return;
		}

		if (this.sampleCollectionInformation != null) {
			this.sampleCollectionInformation.unsetDiagnosisExaminationRecord();
		}

		this.sampleCollectionInformation = entity;

		if (reverseAdd) {
			this.sampleCollectionInformation.setDiagnosisExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSampleCollectionInformation outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSampleCollectionInformation outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetSampleCollectionInformation(boolean)} but default to true.
	 */
	public void unsetSampleCollectionInformation() {
		this.unsetSampleCollectionInformation(true);
	}

	/**
	 * Remove the SampleCollectionInformationEntity in Sample Collection Information from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSampleCollectionInformation(boolean reverse) {
		if (reverse && this.sampleCollectionInformation != null) {
			this.sampleCollectionInformation.unsetDiagnosisExaminationRecord(false);
		}
		this.sampleCollectionInformation = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.removeDiagnosisExaminationRecords(this, false);
		}
		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.addDiagnosisExaminationRecords(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove Medical Examination Record in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.removeDiagnosisExaminationRecords(this, false);
		}
		this.medicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setMedicalExaminationRecordDischargeSummary(MedicalExaminationRecordDischargeSummaryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be set to this entity
	 */
	public void setMedicalExaminationRecordDischargeSummary(@NonNull MedicalExaminationRecordDischargeSummaryEntity entity) {
		setMedicalExaminationRecordDischargeSummary(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecordDischargeSummary in this entity with single MedicalExaminationRecordDischargeSummaryEntity.
	 *
	 * @param entity the given MedicalExaminationRecordDischargeSummaryEntity to be set or updated to medicalExaminationRecordDischargeSummary
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecordDischargeSummary(@NonNull MedicalExaminationRecordDischargeSummaryEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecordDischargeSummary here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecordDischargeSummary here] end

		if (sameAsFormer(this.medicalExaminationRecordDischargeSummary, entity)) {
			return;
		}

		if (this.medicalExaminationRecordDischargeSummary != null) {
			this.medicalExaminationRecordDischargeSummary.removeDiagnosisExaminationRecords(this, false);
		}
		this.medicalExaminationRecordDischargeSummary = entity;
		if (reverseAdd) {
			this.medicalExaminationRecordDischargeSummary.addDiagnosisExaminationRecords(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecordDischargeSummary incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecordDischargeSummary incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecordDischargeSummary(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecordDischargeSummary() {
		this.unsetMedicalExaminationRecordDischargeSummary(true);
	}

	/**
	 * Remove Medical Examination Record Discharge Summary in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecordDischargeSummary(boolean reverse) {
		if (reverse && this.medicalExaminationRecordDischargeSummary != null) {
			this.medicalExaminationRecordDischargeSummary.removeDiagnosisExaminationRecords(this, false);
		}
		this.medicalExaminationRecordDischargeSummary = null;
	}
	/**
	 * Similar to {@link this#setIcd10(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setIcd10(@NonNull DiagnosesAndProceduresEntity entity) {
		setIcd10(entity, true);
	}

	/**
	 * Set or update the icd10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to icd10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIcd10(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setIcd10 here] off begin
		// % protected region % [Add any additional logic here before the main logic for setIcd10 here] end

		if (sameAsFormer(this.icd10, entity)) {
			return;
		}

		if (this.icd10 != null) {
			this.icd10.removeIcd10(this, false);
		}
		this.icd10 = entity;
		if (reverseAdd) {
			this.icd10.addIcd10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setIcd10 incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setIcd10 incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetIcd10(boolean)} but default to true.
	 */
	public void unsetIcd10() {
		this.unsetIcd10(true);
	}

	/**
	 * Remove ICD 10 in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetIcd10(boolean reverse) {
		if (reverse && this.icd10 != null) {
			this.icd10.removeIcd10(this, false);
		}
		this.icd10 = null;
	}
	/**
	 * Similar to {@link this#setIcd9CM(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setIcd9CM(@NonNull DiagnosesAndProceduresEntity entity) {
		setIcd9CM(entity, true);
	}

	/**
	 * Set or update the icd9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to icd9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIcd9CM(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setIcd9CM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setIcd9CM here] end

		if (sameAsFormer(this.icd9CM, entity)) {
			return;
		}

		if (this.icd9CM != null) {
			this.icd9CM.removeIcd9CM(this, false);
		}
		this.icd9CM = entity;
		if (reverseAdd) {
			this.icd9CM.addIcd9CM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setIcd9CM incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setIcd9CM incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetIcd9CM(boolean)} but default to true.
	 */
	public void unsetIcd9CM() {
		this.unsetIcd9CM(true);
	}

	/**
	 * Remove ICD 9 CM in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetIcd9CM(boolean reverse) {
		if (reverse && this.icd9CM != null) {
			this.icd9CM.removeIcd9CM(this, false);
		}
		this.icd9CM = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
