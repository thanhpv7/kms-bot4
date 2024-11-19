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
public class CoTreatingDoctorEntity extends AbstractEntity {

	public CoTreatingDoctorEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AdditionalAnesthesiologistOneMany = new EntityReference();
			AdditionalAnesthesiologistOneMany.entityName = "PreoperativeRecords";
			AdditionalAnesthesiologistOneMany.oppositeName = "AdditionalAnesthesiologist";
			AdditionalAnesthesiologistOneMany.name = "AdditionalAnesthesiologists";
			AdditionalAnesthesiologistOneMany.optional = true;
			AdditionalAnesthesiologistOneMany.type = "One";
			AdditionalAnesthesiologistOneMany.oppositeType = "Many";

		References.add(AdditionalAnesthesiologistOneMany);

		var AdditionalMidwifeOneMany = new EntityReference();
			AdditionalMidwifeOneMany.entityName = "DeliveryMedicalExaminationRecord";
			AdditionalMidwifeOneMany.oppositeName = "AdditionalMidwife";
			AdditionalMidwifeOneMany.name = "AdditionalMidwives";
			AdditionalMidwifeOneMany.optional = true;
			AdditionalMidwifeOneMany.type = "One";
			AdditionalMidwifeOneMany.oppositeType = "Many";

		References.add(AdditionalMidwifeOneMany);

		var AdditionalSurgeryNurseOneMany = new EntityReference();
			AdditionalSurgeryNurseOneMany.entityName = "PreoperativeRecords";
			AdditionalSurgeryNurseOneMany.oppositeName = "AdditionalSurgeryNurse";
			AdditionalSurgeryNurseOneMany.name = "AdditionalSurgeryNurses";
			AdditionalSurgeryNurseOneMany.optional = true;
			AdditionalSurgeryNurseOneMany.type = "One";
			AdditionalSurgeryNurseOneMany.oppositeType = "Many";

		References.add(AdditionalSurgeryNurseOneMany);

		var CoTreatingAnesthesiologistOneMany = new EntityReference();
			CoTreatingAnesthesiologistOneMany.entityName = "PreoperativeRecords";
			CoTreatingAnesthesiologistOneMany.oppositeName = "CoTreatingAnesthesiologist";
			CoTreatingAnesthesiologistOneMany.name = "CoTreatingAnesthesiologists";
			CoTreatingAnesthesiologistOneMany.optional = true;
			CoTreatingAnesthesiologistOneMany.type = "One";
			CoTreatingAnesthesiologistOneMany.oppositeType = "Many";

		References.add(CoTreatingAnesthesiologistOneMany);

		var MedicalExaminationRecordOneMany = new EntityReference();
			MedicalExaminationRecordOneMany.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneMany.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneMany.name = "CoTreatingDoctors";
			MedicalExaminationRecordOneMany.optional = true;
			MedicalExaminationRecordOneMany.type = "One";
			MedicalExaminationRecordOneMany.oppositeType = "Many";

		References.add(MedicalExaminationRecordOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "CoTreatingDoctors";
			StaffOneMany.optional = true;
			StaffOneMany.type = "One";
			StaffOneMany.oppositeType = "Many";

		References.add(StaffOneMany);

		var CoTreatingSurgeonOneMany = new EntityReference();
			CoTreatingSurgeonOneMany.entityName = "PreoperativeRecords";
			CoTreatingSurgeonOneMany.oppositeName = "CoTreatingSurgeon";
			CoTreatingSurgeonOneMany.name = "CoTreatingSurgeons";
			CoTreatingSurgeonOneMany.optional = true;
			CoTreatingSurgeonOneMany.type = "One";
			CoTreatingSurgeonOneMany.oppositeType = "Many";

		References.add(CoTreatingSurgeonOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Doctor Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Doctor Notes here] end
	private String doctorNotes;

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

	private PreoperativeRecordsEntity additionalAnesthesiologist;

	private DeliveryMedicalExaminationRecordEntity additionalMidwife;

	private PreoperativeRecordsEntity additionalSurgeryNurse;

	private PreoperativeRecordsEntity coTreatingAnesthesiologist;

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	private StaffEntity staff;

	private PreoperativeRecordsEntity coTreatingSurgeon;

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
	 * Similar to {@link this#setAdditionalAnesthesiologist(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAdditionalAnesthesiologist(@NonNull PreoperativeRecordsEntity entity) {
		setAdditionalAnesthesiologist(entity, true);
	}

	/**
	 * Set or update the additionalAnesthesiologist in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to additionalAnesthesiologist
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalAnesthesiologist(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalAnesthesiologist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalAnesthesiologist here] end

		if (sameAsFormer(this.additionalAnesthesiologist, entity)) {
			return;
		}

		if (this.additionalAnesthesiologist != null) {
			this.additionalAnesthesiologist.removeAdditionalAnesthesiologists(this, false);
		}
		this.additionalAnesthesiologist = entity;
		if (reverseAdd) {
			this.additionalAnesthesiologist.addAdditionalAnesthesiologists(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalAnesthesiologist incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalAnesthesiologist incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalAnesthesiologist(boolean)} but default to true.
	 */
	public void unsetAdditionalAnesthesiologist() {
		this.unsetAdditionalAnesthesiologist(true);
	}

	/**
	 * Remove Additional Anesthesiologist in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalAnesthesiologist(boolean reverse) {
		if (reverse && this.additionalAnesthesiologist != null) {
			this.additionalAnesthesiologist.removeAdditionalAnesthesiologists(this, false);
		}
		this.additionalAnesthesiologist = null;
	}
	/**
	 * Similar to {@link this#setAdditionalMidwife(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setAdditionalMidwife(@NonNull DeliveryMedicalExaminationRecordEntity entity) {
		setAdditionalMidwife(entity, true);
	}

	/**
	 * Set or update the additionalMidwife in this entity with single DeliveryMedicalExaminationRecordEntity.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set or updated to additionalMidwife
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalMidwife(@NonNull DeliveryMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalMidwife here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalMidwife here] end

		if (sameAsFormer(this.additionalMidwife, entity)) {
			return;
		}

		if (this.additionalMidwife != null) {
			this.additionalMidwife.removeAdditionalMidwives(this, false);
		}
		this.additionalMidwife = entity;
		if (reverseAdd) {
			this.additionalMidwife.addAdditionalMidwives(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalMidwife incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalMidwife incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalMidwife(boolean)} but default to true.
	 */
	public void unsetAdditionalMidwife() {
		this.unsetAdditionalMidwife(true);
	}

	/**
	 * Remove Additional Midwife in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalMidwife(boolean reverse) {
		if (reverse && this.additionalMidwife != null) {
			this.additionalMidwife.removeAdditionalMidwives(this, false);
		}
		this.additionalMidwife = null;
	}
	/**
	 * Similar to {@link this#setAdditionalSurgeryNurse(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void setAdditionalSurgeryNurse(@NonNull PreoperativeRecordsEntity entity) {
		setAdditionalSurgeryNurse(entity, true);
	}

	/**
	 * Set or update the additionalSurgeryNurse in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to additionalSurgeryNurse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalSurgeryNurse(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalSurgeryNurse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalSurgeryNurse here] end

		if (sameAsFormer(this.additionalSurgeryNurse, entity)) {
			return;
		}

		if (this.additionalSurgeryNurse != null) {
			this.additionalSurgeryNurse.removeAdditionalSurgeryNurses(this, false);
		}
		this.additionalSurgeryNurse = entity;
		if (reverseAdd) {
			this.additionalSurgeryNurse.addAdditionalSurgeryNurses(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalSurgeryNurse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalSurgeryNurse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalSurgeryNurse(boolean)} but default to true.
	 */
	public void unsetAdditionalSurgeryNurse() {
		this.unsetAdditionalSurgeryNurse(true);
	}

	/**
	 * Remove Additional Surgery Nurse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalSurgeryNurse(boolean reverse) {
		if (reverse && this.additionalSurgeryNurse != null) {
			this.additionalSurgeryNurse.removeAdditionalSurgeryNurses(this, false);
		}
		this.additionalSurgeryNurse = null;
	}
	/**
	 * Similar to {@link this#setCoTreatingAnesthesiologist(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void setCoTreatingAnesthesiologist(@NonNull PreoperativeRecordsEntity entity) {
		setCoTreatingAnesthesiologist(entity, true);
	}

	/**
	 * Set or update the coTreatingAnesthesiologist in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to coTreatingAnesthesiologist
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCoTreatingAnesthesiologist(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCoTreatingAnesthesiologist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCoTreatingAnesthesiologist here] end

		if (sameAsFormer(this.coTreatingAnesthesiologist, entity)) {
			return;
		}

		if (this.coTreatingAnesthesiologist != null) {
			this.coTreatingAnesthesiologist.removeCoTreatingAnesthesiologists(this, false);
		}
		this.coTreatingAnesthesiologist = entity;
		if (reverseAdd) {
			this.coTreatingAnesthesiologist.addCoTreatingAnesthesiologists(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCoTreatingAnesthesiologist incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCoTreatingAnesthesiologist incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCoTreatingAnesthesiologist(boolean)} but default to true.
	 */
	public void unsetCoTreatingAnesthesiologist() {
		this.unsetCoTreatingAnesthesiologist(true);
	}

	/**
	 * Remove Co Treating Anesthesiologist in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCoTreatingAnesthesiologist(boolean reverse) {
		if (reverse && this.coTreatingAnesthesiologist != null) {
			this.coTreatingAnesthesiologist.removeCoTreatingAnesthesiologists(this, false);
		}
		this.coTreatingAnesthesiologist = null;
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
			this.medicalExaminationRecord.removeCoTreatingDoctors(this, false);
		}
		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.addCoTreatingDoctors(this, false);
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
			this.medicalExaminationRecord.removeCoTreatingDoctors(this, false);
		}
		this.medicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NonNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeCoTreatingDoctors(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addCoTreatingDoctors(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeCoTreatingDoctors(this, false);
		}
		this.staff = null;
	}
	/**
	 * Similar to {@link this#setCoTreatingSurgeon(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set to this entity
	 */
	public void setCoTreatingSurgeon(@NonNull PreoperativeRecordsEntity entity) {
		setCoTreatingSurgeon(entity, true);
	}

	/**
	 * Set or update the coTreatingSurgeon in this entity with single PreoperativeRecordsEntity.
	 *
	 * @param entity the given PreoperativeRecordsEntity to be set or updated to coTreatingSurgeon
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCoTreatingSurgeon(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCoTreatingSurgeon here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCoTreatingSurgeon here] end

		if (sameAsFormer(this.coTreatingSurgeon, entity)) {
			return;
		}

		if (this.coTreatingSurgeon != null) {
			this.coTreatingSurgeon.removeCoTreatingSurgeons(this, false);
		}
		this.coTreatingSurgeon = entity;
		if (reverseAdd) {
			this.coTreatingSurgeon.addCoTreatingSurgeons(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCoTreatingSurgeon incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCoTreatingSurgeon incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCoTreatingSurgeon(boolean)} but default to true.
	 */
	public void unsetCoTreatingSurgeon() {
		this.unsetCoTreatingSurgeon(true);
	}

	/**
	 * Remove Co Treating Surgeon in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCoTreatingSurgeon(boolean reverse) {
		if (reverse && this.coTreatingSurgeon != null) {
			this.coTreatingSurgeon.removeCoTreatingSurgeons(this, false);
		}
		this.coTreatingSurgeon = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
