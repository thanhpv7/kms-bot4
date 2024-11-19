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

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class DailyCareCPPTEntity extends AbstractEntity {

	public DailyCareCPPTEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var Icd10OneMany = new EntityReference();
			Icd10OneMany.entityName = "DiagnosesAndProcedures";
			Icd10OneMany.oppositeName = "Icd10";
			Icd10OneMany.name = "CpptICD10";
			Icd10OneMany.optional = true;
			Icd10OneMany.type = "One";
			Icd10OneMany.oppositeType = "Many";

		References.add(Icd10OneMany);

		var Icd9CMOneMany = new EntityReference();
			Icd9CMOneMany.entityName = "DiagnosesAndProcedures";
			Icd9CMOneMany.oppositeName = "Icd9CM";
			Icd9CMOneMany.name = "CpptICD9CM";
			Icd9CMOneMany.optional = true;
			Icd9CMOneMany.type = "One";
			Icd9CMOneMany.oppositeType = "Many";

		References.add(Icd9CMOneMany);

		var CreatedByStaffOneMany = new EntityReference();
			CreatedByStaffOneMany.entityName = "Staff";
			CreatedByStaffOneMany.oppositeName = "CreatedByStaff";
			CreatedByStaffOneMany.name = "DailyCareCPPTsCreatedByStaff";
			CreatedByStaffOneMany.optional = true;
			CreatedByStaffOneMany.type = "One";
			CreatedByStaffOneMany.oppositeType = "Many";

		References.add(CreatedByStaffOneMany);

		var DoctorInChargeOneMany = new EntityReference();
			DoctorInChargeOneMany.entityName = "Staff";
			DoctorInChargeOneMany.oppositeName = "DoctorInCharge";
			DoctorInChargeOneMany.name = "DailyCareCPPTsDoctorInCharge";
			DoctorInChargeOneMany.optional = true;
			DoctorInChargeOneMany.type = "One";
			DoctorInChargeOneMany.oppositeType = "Many";

		References.add(DoctorInChargeOneMany);

		var MedicalTranscriberOneMany = new EntityReference();
			MedicalTranscriberOneMany.entityName = "Staff";
			MedicalTranscriberOneMany.oppositeName = "MedicalTranscriber";
			MedicalTranscriberOneMany.name = "DailyCareCPPTsMedicalTranscriber";
			MedicalTranscriberOneMany.optional = true;
			MedicalTranscriberOneMany.type = "One";
			MedicalTranscriberOneMany.oppositeType = "Many";

		References.add(MedicalTranscriberOneMany);

		var MedicalExaminationRecordOneMany = new EntityReference();
			MedicalExaminationRecordOneMany.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneMany.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneMany.name = "DailyCareCPPTs";
			MedicalExaminationRecordOneMany.optional = true;
			MedicalExaminationRecordOneMany.type = "One";
			MedicalExaminationRecordOneMany.oppositeType = "Many";

		References.add(MedicalExaminationRecordOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Subjective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Subjective here] end
	private String subjective;

	// % protected region % [Modify attribute annotation for Objective here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Objective here] end
	private String objective;

	// % protected region % [Modify attribute annotation for Diagnose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diagnose here] end
	private String diagnose;

	// % protected region % [Modify attribute annotation for Plan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Plan here] end
	private String plan;

	// % protected region % [Modify attribute annotation for Instruction here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Instruction here] end
	private String instruction;

	// % protected region % [Modify attribute annotation for Verified Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Verified Date here] end
	private OffsetDateTime verifiedDate;

	// % protected region % [Modify attribute annotation for Verified By here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Verified By here] end
	private String verifiedBy;

	// % protected region % [Modify attribute annotation for Canceled Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Canceled Date here] end
	private OffsetDateTime canceledDate;

	// % protected region % [Modify attribute annotation for Canceled By here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Canceled By here] end
	private String canceledBy;

	// % protected region % [Modify attribute annotation for Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Status here] end
	private String status;

	// % protected region % [Modify attribute annotation for CPPT Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for CPPT Date Time here] end
	private OffsetDateTime cpptDateTime;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	private DiagnosesAndProceduresEntity icd10;

	private DiagnosesAndProceduresEntity icd9CM;

	private StaffEntity createdByStaff;

	private StaffEntity doctorInCharge;

	private StaffEntity medicalTranscriber;

	private MedicalExaminationRecordEntity medicalExaminationRecord;

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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
			this.icd10.removeCpptICD10(this, false);
		}
		this.icd10 = entity;
		if (reverseAdd) {
			this.icd10.addCpptICD10(this, false);
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
			this.icd10.removeCpptICD10(this, false);
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
			this.icd9CM.removeCpptICD9CM(this, false);
		}
		this.icd9CM = entity;
		if (reverseAdd) {
			this.icd9CM.addCpptICD9CM(this, false);
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
			this.icd9CM.removeCpptICD9CM(this, false);
		}
		this.icd9CM = null;
	}
	/**
	 * Similar to {@link this#setCreatedByStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setCreatedByStaff(@NonNull StaffEntity entity) {
		setCreatedByStaff(entity, true);
	}

	/**
	 * Set or update the createdByStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to createdByStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCreatedByStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCreatedByStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCreatedByStaff here] end

		if (sameAsFormer(this.createdByStaff, entity)) {
			return;
		}

		if (this.createdByStaff != null) {
			this.createdByStaff.removeDailyCareCPPTsCreatedByStaff(this, false);
		}
		this.createdByStaff = entity;
		if (reverseAdd) {
			this.createdByStaff.addDailyCareCPPTsCreatedByStaff(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCreatedByStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCreatedByStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCreatedByStaff(boolean)} but default to true.
	 */
	public void unsetCreatedByStaff() {
		this.unsetCreatedByStaff(true);
	}

	/**
	 * Remove Created By Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCreatedByStaff(boolean reverse) {
		if (reverse && this.createdByStaff != null) {
			this.createdByStaff.removeDailyCareCPPTsCreatedByStaff(this, false);
		}
		this.createdByStaff = null;
	}
	/**
	 * Similar to {@link this#setDoctorInCharge(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setDoctorInCharge(@NonNull StaffEntity entity) {
		setDoctorInCharge(entity, true);
	}

	/**
	 * Set or update the doctorInCharge in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to doctorInCharge
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDoctorInCharge(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDoctorInCharge here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDoctorInCharge here] end

		if (sameAsFormer(this.doctorInCharge, entity)) {
			return;
		}

		if (this.doctorInCharge != null) {
			this.doctorInCharge.removeDailyCareCPPTsDoctorInCharge(this, false);
		}
		this.doctorInCharge = entity;
		if (reverseAdd) {
			this.doctorInCharge.addDailyCareCPPTsDoctorInCharge(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDoctorInCharge incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDoctorInCharge incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDoctorInCharge(boolean)} but default to true.
	 */
	public void unsetDoctorInCharge() {
		this.unsetDoctorInCharge(true);
	}

	/**
	 * Remove Doctor in Charge in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDoctorInCharge(boolean reverse) {
		if (reverse && this.doctorInCharge != null) {
			this.doctorInCharge.removeDailyCareCPPTsDoctorInCharge(this, false);
		}
		this.doctorInCharge = null;
	}
	/**
	 * Similar to {@link this#setMedicalTranscriber(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMedicalTranscriber(@NonNull StaffEntity entity) {
		setMedicalTranscriber(entity, true);
	}

	/**
	 * Set or update the medicalTranscriber in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to medicalTranscriber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalTranscriber(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalTranscriber here] end

		if (sameAsFormer(this.medicalTranscriber, entity)) {
			return;
		}

		if (this.medicalTranscriber != null) {
			this.medicalTranscriber.removeDailyCareCPPTsMedicalTranscriber(this, false);
		}
		this.medicalTranscriber = entity;
		if (reverseAdd) {
			this.medicalTranscriber.addDailyCareCPPTsMedicalTranscriber(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalTranscriber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalTranscriber(boolean)} but default to true.
	 */
	public void unsetMedicalTranscriber() {
		this.unsetMedicalTranscriber(true);
	}

	/**
	 * Remove Medical Transcriber in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalTranscriber(boolean reverse) {
		if (reverse && this.medicalTranscriber != null) {
			this.medicalTranscriber.removeDailyCareCPPTsMedicalTranscriber(this, false);
		}
		this.medicalTranscriber = null;
	}
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
			this.medicalExaminationRecord.removeDailyCareCPPTs(this, false);
		}
		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.addDailyCareCPPTs(this, false);
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
			this.medicalExaminationRecord.removeDailyCareCPPTs(this, false);
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
