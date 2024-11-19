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
public class OperatingTheaterMedicalExaminationRecordEntity extends AbstractEntity {

	public OperatingTheaterMedicalExaminationRecordEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var IntraoperativeRecordsOneOne = new EntityReference();
			IntraoperativeRecordsOneOne.entityName = "IntraoperativeRecords";
			IntraoperativeRecordsOneOne.oppositeName = "OperatingTheaterMedicalExaminationRecord";
			IntraoperativeRecordsOneOne.name = "IntraoperativeRecords";
			IntraoperativeRecordsOneOne.optional = true;
			IntraoperativeRecordsOneOne.type = "One";
			IntraoperativeRecordsOneOne.oppositeType = "One";

		References.add(IntraoperativeRecordsOneOne);

		var NursingAnesthesiaDetailOneMany = new EntityReference();
			NursingAnesthesiaDetailOneMany.entityName = "DiagnosisNanda";
			NursingAnesthesiaDetailOneMany.oppositeName = "NursingAnesthesiaDetail";
			NursingAnesthesiaDetailOneMany.name = "NursingAnesthesiaDetail";
			NursingAnesthesiaDetailOneMany.optional = true;
			NursingAnesthesiaDetailOneMany.type = "One";
			NursingAnesthesiaDetailOneMany.oppositeType = "Many";

		References.add(NursingAnesthesiaDetailOneMany);

		var NursingDetailSurgicalNursingsOneMany = new EntityReference();
			NursingDetailSurgicalNursingsOneMany.entityName = "Staff";
			NursingDetailSurgicalNursingsOneMany.oppositeName = "NursingDetailSurgicalNursings";
			NursingDetailSurgicalNursingsOneMany.name = "NursingDetailSurgicalNursing";
			NursingDetailSurgicalNursingsOneMany.optional = true;
			NursingDetailSurgicalNursingsOneMany.type = "One";
			NursingDetailSurgicalNursingsOneMany.oppositeType = "Many";

		References.add(NursingDetailSurgicalNursingsOneMany);

		var NursingDetailsAnesthesiaNursingsOneMany = new EntityReference();
			NursingDetailsAnesthesiaNursingsOneMany.entityName = "Staff";
			NursingDetailsAnesthesiaNursingsOneMany.oppositeName = "NursingDetailsAnesthesiaNursings";
			NursingDetailsAnesthesiaNursingsOneMany.name = "NursingDetailsAnesthesiaNursing";
			NursingDetailsAnesthesiaNursingsOneMany.optional = true;
			NursingDetailsAnesthesiaNursingsOneMany.type = "One";
			NursingDetailsAnesthesiaNursingsOneMany.oppositeType = "Many";

		References.add(NursingDetailsAnesthesiaNursingsOneMany);

		var NursingSurgicalDetailOneMany = new EntityReference();
			NursingSurgicalDetailOneMany.entityName = "DiagnosisNanda";
			NursingSurgicalDetailOneMany.oppositeName = "NursingSurgicalDetail";
			NursingSurgicalDetailOneMany.name = "NursingSurgicalDetail";
			NursingSurgicalDetailOneMany.optional = true;
			NursingSurgicalDetailOneMany.type = "One";
			NursingSurgicalDetailOneMany.oppositeType = "Many";

		References.add(NursingSurgicalDetailOneMany);

		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "OperatingTheaterMedicalExaminationRecord";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);

		var PostOperativeDetailsOneOne = new EntityReference();
			PostOperativeDetailsOneOne.entityName = "PostOperativeDetails";
			PostOperativeDetailsOneOne.oppositeName = "OperatingTheaterMedicalExaminationRecord";
			PostOperativeDetailsOneOne.name = "PostOperativeDetails";
			PostOperativeDetailsOneOne.optional = true;
			PostOperativeDetailsOneOne.type = "One";
			PostOperativeDetailsOneOne.oppositeType = "One";

		References.add(PostOperativeDetailsOneOne);

		var PreoperativeRecordsOneOne = new EntityReference();
			PreoperativeRecordsOneOne.entityName = "PreoperativeRecords";
			PreoperativeRecordsOneOne.oppositeName = "OperatingTheaterMedicalExaminationRecord";
			PreoperativeRecordsOneOne.name = "PreoperativeRecords";
			PreoperativeRecordsOneOne.optional = true;
			PreoperativeRecordsOneOne.type = "One";
			PreoperativeRecordsOneOne.oppositeType = "One";

		References.add(PreoperativeRecordsOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Has Confirmed Identity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Has Confirmed Identity here] end
	private Boolean hasConfirmedIdentity;

	// % protected region % [Modify attribute annotation for Anesthesia Safety Check Completed here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Safety Check Completed here] end
	private Boolean anesthesiaSafetyCheckCompleted;

	// % protected region % [Modify attribute annotation for Pulse Oxymeter Functioning here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse Oxymeter Functioning here] end
	private Boolean pulseOxymeterFunctioning;

	// % protected region % [Modify attribute annotation for Site Marked here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Site Marked here] end
	private String siteMarked;

	// % protected region % [Modify attribute annotation for Has Known Allergy here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Has Known Allergy here] end
	private String hasKnownAllergy;

	// % protected region % [Modify attribute annotation for Has Difficult Airway Risk here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Has Difficult Airway Risk here] end
	private String hasDifficultAirwayRisk;

	// % protected region % [Modify attribute annotation for Has Risk Of Blood Loss here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Has Risk Of Blood Loss here] end
	private String hasRiskOfBloodLoss;

	// % protected region % [Modify attribute annotation for Team Member Introduced here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Team Member Introduced here] end
	private Boolean teamMemberIntroduced;

	// % protected region % [Modify attribute annotation for Professional Confirmed Patient here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Professional Confirmed Patient here] end
	private Boolean professionalConfirmedPatient;

	// % protected region % [Modify attribute annotation for Antibiotic Prophylaxis Given here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Antibiotic Prophylaxis Given here] end
	private String antibioticProphylaxisGiven;

	// % protected region % [Modify attribute annotation for Essential Imaging Displayed here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Essential Imaging Displayed here] end
	private String essentialImagingDisplayed;

	// % protected region % [Modify attribute annotation for Whare Are Critical Steps here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Whare Are Critical Steps here] end
	private Boolean whareAreCriticalSteps;

	// % protected region % [Modify attribute annotation for How Long Case Take here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for How Long Case Take here] end
	private Boolean howLongCaseTake;

	// % protected region % [Modify attribute annotation for What Is Anticipated Blood Loss here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for What Is Anticipated Blood Loss here] end
	private Boolean whatIsAnticipatedBloodLoss;

	// % protected region % [Modify attribute annotation for Any Patient Specific Concerns here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Any Patient Specific Concerns here] end
	private Boolean anyPatientSpecificConcerns;

	// % protected region % [Modify attribute annotation for Sterlity Been Confirmed here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sterlity Been Confirmed here] end
	private Boolean sterlityBeenConfirmed;

	// % protected region % [Modify attribute annotation for Equipment Issues Any Concern here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Equipment Issues Any Concern here] end
	private Boolean equipmentIssuesAnyConcern;

	// % protected region % [Modify attribute annotation for Name Of Procedure here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Name Of Procedure here] end
	private Boolean nameOfProcedure;

	// % protected region % [Modify attribute annotation for Instruments Need Count Correct here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Instruments Need Count Correct here] end
	private Boolean instrumentsNeedCountCorrect;

	// % protected region % [Modify attribute annotation for Specimen Is Labeled here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Specimen Is Labeled here] end
	private Boolean specimenIsLabeled;

	// % protected region % [Modify attribute annotation for Equipment Problems Addressed here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Equipment Problems Addressed here] end
	private Boolean equipmentProblemsAddressed;

	// % protected region % [Modify attribute annotation for Key Concerns For Recovery here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Key Concerns For Recovery here] end
	private Boolean keyConcernsForRecovery;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private IntraoperativeRecordsEntity intraoperativeRecords;

	private PostOperativeDetailsEntity postOperativeDetails;

	private PreoperativeRecordsEntity preoperativeRecords;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicalExaminationRecordEntity medicalExaminationRecord;

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

	private DiagnosisNandaEntity nursingAnesthesiaDetail;

	private StaffEntity nursingDetailSurgicalNursings;

	private StaffEntity nursingDetailsAnesthesiaNursings;

	private DiagnosisNandaEntity nursingSurgicalDetail;

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
	 * Similar to {@link this#setIntraoperativeRecords(IntraoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setIntraoperativeRecords(@NonNull IntraoperativeRecordsEntity entity) {
		setIntraoperativeRecords(entity, true);
	}

	/**
	 * Set or update intraoperativeRecords with the given IntraoperativeRecordsEntity.
	 *
	 * @param entity the OperatingTheaterMedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setIntraoperativeRecords(@NonNull IntraoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setIntraoperativeRecords here] off begin
		// % protected region % [Add any additional logic here before the main logic for setIntraoperativeRecords here] end

		if (sameAsFormer(this.intraoperativeRecords, entity)) {
			return;
		}

		if (this.intraoperativeRecords != null) {
			this.intraoperativeRecords.unsetOperatingTheaterMedicalExaminationRecord();
		}

		this.intraoperativeRecords = entity;

		if (reverseAdd) {
			this.intraoperativeRecords.setOperatingTheaterMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setIntraoperativeRecords outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setIntraoperativeRecords outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetIntraoperativeRecords(boolean)} but default to true.
	 */
	public void unsetIntraoperativeRecords() {
		this.unsetIntraoperativeRecords(true);
	}

	/**
	 * Remove the IntraoperativeRecordsEntity in Intraoperative Records from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetIntraoperativeRecords(boolean reverse) {
		if (reverse && this.intraoperativeRecords != null) {
			this.intraoperativeRecords.unsetOperatingTheaterMedicalExaminationRecord(false);
		}
		this.intraoperativeRecords = null;
	}

	/**
	 * Similar to {@link this#setPostOperativeDetails(PostOperativeDetailsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setPostOperativeDetails(@NonNull PostOperativeDetailsEntity entity) {
		setPostOperativeDetails(entity, true);
	}

	/**
	 * Set or update postOperativeDetails with the given PostOperativeDetailsEntity.
	 *
	 * @param entity the OperatingTheaterMedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPostOperativeDetails(@NonNull PostOperativeDetailsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeDetails here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPostOperativeDetails here] end

		if (sameAsFormer(this.postOperativeDetails, entity)) {
			return;
		}

		if (this.postOperativeDetails != null) {
			this.postOperativeDetails.unsetOperatingTheaterMedicalExaminationRecord();
		}

		this.postOperativeDetails = entity;

		if (reverseAdd) {
			this.postOperativeDetails.setOperatingTheaterMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPostOperativeDetails outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPostOperativeDetails outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPostOperativeDetails(boolean)} but default to true.
	 */
	public void unsetPostOperativeDetails() {
		this.unsetPostOperativeDetails(true);
	}

	/**
	 * Remove the PostOperativeDetailsEntity in Post Operative Details from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPostOperativeDetails(boolean reverse) {
		if (reverse && this.postOperativeDetails != null) {
			this.postOperativeDetails.unsetOperatingTheaterMedicalExaminationRecord(false);
		}
		this.postOperativeDetails = null;
	}

	/**
	 * Similar to {@link this#setPreoperativeRecords(PreoperativeRecordsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setPreoperativeRecords(@NonNull PreoperativeRecordsEntity entity) {
		setPreoperativeRecords(entity, true);
	}

	/**
	 * Set or update preoperativeRecords with the given PreoperativeRecordsEntity.
	 *
	 * @param entity the OperatingTheaterMedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreoperativeRecords(@NonNull PreoperativeRecordsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRecords here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRecords here] end

		if (sameAsFormer(this.preoperativeRecords, entity)) {
			return;
		}

		if (this.preoperativeRecords != null) {
			this.preoperativeRecords.unsetOperatingTheaterMedicalExaminationRecord();
		}

		this.preoperativeRecords = entity;

		if (reverseAdd) {
			this.preoperativeRecords.setOperatingTheaterMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRecords outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRecords outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPreoperativeRecords(boolean)} but default to true.
	 */
	public void unsetPreoperativeRecords() {
		this.unsetPreoperativeRecords(true);
	}

	/**
	 * Remove the PreoperativeRecordsEntity in Preoperative Records from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPreoperativeRecords(boolean reverse) {
		if (reverse && this.preoperativeRecords != null) {
			this.preoperativeRecords.unsetOperatingTheaterMedicalExaminationRecord(false);
		}
		this.preoperativeRecords = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setNursingAnesthesiaDetail(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set to this entity
	 */
	public void setNursingAnesthesiaDetail(@NonNull DiagnosisNandaEntity entity) {
		setNursingAnesthesiaDetail(entity, true);
	}

	/**
	 * Set or update the nursingAnesthesiaDetail in this entity with single DiagnosisNandaEntity.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set or updated to nursingAnesthesiaDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNursingAnesthesiaDetail(@NonNull DiagnosisNandaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNursingAnesthesiaDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNursingAnesthesiaDetail here] end

		if (sameAsFormer(this.nursingAnesthesiaDetail, entity)) {
			return;
		}

		if (this.nursingAnesthesiaDetail != null) {
			this.nursingAnesthesiaDetail.removeNursingAnesthesiaDetail(this, false);
		}
		this.nursingAnesthesiaDetail = entity;
		if (reverseAdd) {
			this.nursingAnesthesiaDetail.addNursingAnesthesiaDetail(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNursingAnesthesiaDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNursingAnesthesiaDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNursingAnesthesiaDetail(boolean)} but default to true.
	 */
	public void unsetNursingAnesthesiaDetail() {
		this.unsetNursingAnesthesiaDetail(true);
	}

	/**
	 * Remove Nursing Anesthesia Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNursingAnesthesiaDetail(boolean reverse) {
		if (reverse && this.nursingAnesthesiaDetail != null) {
			this.nursingAnesthesiaDetail.removeNursingAnesthesiaDetail(this, false);
		}
		this.nursingAnesthesiaDetail = null;
	}
	/**
	 * Similar to {@link this#setNursingDetailSurgicalNursings(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setNursingDetailSurgicalNursings(@NonNull StaffEntity entity) {
		setNursingDetailSurgicalNursings(entity, true);
	}

	/**
	 * Set or update the nursingDetailSurgicalNursings in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to nursingDetailSurgicalNursings
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNursingDetailSurgicalNursings(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNursingDetailSurgicalNursings here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNursingDetailSurgicalNursings here] end

		if (sameAsFormer(this.nursingDetailSurgicalNursings, entity)) {
			return;
		}

		if (this.nursingDetailSurgicalNursings != null) {
			this.nursingDetailSurgicalNursings.removeNursingDetailSurgicalNursing(this, false);
		}
		this.nursingDetailSurgicalNursings = entity;
		if (reverseAdd) {
			this.nursingDetailSurgicalNursings.addNursingDetailSurgicalNursing(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNursingDetailSurgicalNursings incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNursingDetailSurgicalNursings incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNursingDetailSurgicalNursings(boolean)} but default to true.
	 */
	public void unsetNursingDetailSurgicalNursings() {
		this.unsetNursingDetailSurgicalNursings(true);
	}

	/**
	 * Remove Nursing Detail Surgical Nursings in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNursingDetailSurgicalNursings(boolean reverse) {
		if (reverse && this.nursingDetailSurgicalNursings != null) {
			this.nursingDetailSurgicalNursings.removeNursingDetailSurgicalNursing(this, false);
		}
		this.nursingDetailSurgicalNursings = null;
	}
	/**
	 * Similar to {@link this#setNursingDetailsAnesthesiaNursings(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setNursingDetailsAnesthesiaNursings(@NonNull StaffEntity entity) {
		setNursingDetailsAnesthesiaNursings(entity, true);
	}

	/**
	 * Set or update the nursingDetailsAnesthesiaNursings in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to nursingDetailsAnesthesiaNursings
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNursingDetailsAnesthesiaNursings(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNursingDetailsAnesthesiaNursings here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNursingDetailsAnesthesiaNursings here] end

		if (sameAsFormer(this.nursingDetailsAnesthesiaNursings, entity)) {
			return;
		}

		if (this.nursingDetailsAnesthesiaNursings != null) {
			this.nursingDetailsAnesthesiaNursings.removeNursingDetailsAnesthesiaNursing(this, false);
		}
		this.nursingDetailsAnesthesiaNursings = entity;
		if (reverseAdd) {
			this.nursingDetailsAnesthesiaNursings.addNursingDetailsAnesthesiaNursing(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNursingDetailsAnesthesiaNursings incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNursingDetailsAnesthesiaNursings incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNursingDetailsAnesthesiaNursings(boolean)} but default to true.
	 */
	public void unsetNursingDetailsAnesthesiaNursings() {
		this.unsetNursingDetailsAnesthesiaNursings(true);
	}

	/**
	 * Remove Nursing Details Anesthesia Nursings in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNursingDetailsAnesthesiaNursings(boolean reverse) {
		if (reverse && this.nursingDetailsAnesthesiaNursings != null) {
			this.nursingDetailsAnesthesiaNursings.removeNursingDetailsAnesthesiaNursing(this, false);
		}
		this.nursingDetailsAnesthesiaNursings = null;
	}
	/**
	 * Similar to {@link this#setNursingSurgicalDetail(DiagnosisNandaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set to this entity
	 */
	public void setNursingSurgicalDetail(@NonNull DiagnosisNandaEntity entity) {
		setNursingSurgicalDetail(entity, true);
	}

	/**
	 * Set or update the nursingSurgicalDetail in this entity with single DiagnosisNandaEntity.
	 *
	 * @param entity the given DiagnosisNandaEntity to be set or updated to nursingSurgicalDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setNursingSurgicalDetail(@NonNull DiagnosisNandaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setNursingSurgicalDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setNursingSurgicalDetail here] end

		if (sameAsFormer(this.nursingSurgicalDetail, entity)) {
			return;
		}

		if (this.nursingSurgicalDetail != null) {
			this.nursingSurgicalDetail.removeNursingSurgicalDetail(this, false);
		}
		this.nursingSurgicalDetail = entity;
		if (reverseAdd) {
			this.nursingSurgicalDetail.addNursingSurgicalDetail(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setNursingSurgicalDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setNursingSurgicalDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetNursingSurgicalDetail(boolean)} but default to true.
	 */
	public void unsetNursingSurgicalDetail() {
		this.unsetNursingSurgicalDetail(true);
	}

	/**
	 * Remove Nursing Surgical Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetNursingSurgicalDetail(boolean reverse) {
		if (reverse && this.nursingSurgicalDetail != null) {
			this.nursingSurgicalDetail.removeNursingSurgicalDetail(this, false);
		}
		this.nursingSurgicalDetail = null;
	}
	/**
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the medicalExaminationRecord in this entity with single MedicalExaminationRecordEntity.
	 *
	 * @param entity the given MedicalExaminationRecordEntity to be set or updated to medicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetOperatingTheaterMedicalExaminationRecord(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setOperatingTheaterMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity of medicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetOperatingTheaterMedicalExaminationRecord();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
