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
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class HemodialysisExaminationEntity extends AbstractEntity {

	public HemodialysisExaminationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "HemodialysisExamination";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);

		var HemodialysisMonitoringsOneMany = new EntityReference();
			HemodialysisMonitoringsOneMany.entityName = "HemodialysisMonitoring";
			HemodialysisMonitoringsOneMany.oppositeName = "HemodialysisExamination";
			HemodialysisMonitoringsOneMany.name = "HemodialysisMonitorings";
			HemodialysisMonitoringsOneMany.optional = true;
			HemodialysisMonitoringsOneMany.type = "One";
			HemodialysisMonitoringsOneMany.oppositeType = "Many";

		References.add(HemodialysisMonitoringsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for First Dialysis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for First Dialysis here] end
	private OffsetDateTime firstDialysis;

	// % protected region % [Modify attribute annotation for Dialysis Frequency here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dialysis Frequency here] end
	private String dialysisFrequency;

	// % protected region % [Modify attribute annotation for Dialysis No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dialysis No here] end
	private String dialysisNo;

	// % protected region % [Modify attribute annotation for Hemodialysis Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hemodialysis Type here] end
	private String hemodialysisType;

	// % protected region % [Modify attribute annotation for Condition here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Condition here] end
	private String condition;

	// % protected region % [Modify attribute annotation for Vascular Access here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Vascular Access here] end
	private String vascularAccess;

	// % protected region % [Modify attribute annotation for Heparinization here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Heparinization here] end
	private String heparinization;

	// % protected region % [Modify attribute annotation for Heparinization Initial Dose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Heparinization Initial Dose here] end
	private String heparinizationInitialDose;

	// % protected region % [Modify attribute annotation for Heparinization Follow Up Dose here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Heparinization Follow Up Dose here] end
	private String heparinizationFollowUpDose;

	// % protected region % [Modify attribute annotation for Dialyzer here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dialyzer here] end
	private String dialyzer;

	// % protected region % [Modify attribute annotation for Dialyzer Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dialyzer Type here] end
	private String dialyzerType;

	// % protected region % [Modify attribute annotation for Dialysis Fluid here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dialysis Fluid here] end
	private String dialysisFluid;

	// % protected region % [Modify attribute annotation for Dry Weight here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dry Weight here] end
	private Double dryWeight;

	// % protected region % [Modify attribute annotation for Dry Weight Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dry Weight Unit here] end
	private String dryWeightUnit;

	// % protected region % [Modify attribute annotation for Weight Upon Arrival here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Upon Arrival here] end
	private Double weightUponArrival;

	// % protected region % [Modify attribute annotation for Weight Upon Arrival Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Upon Arrival Unit here] end
	private String weightUponArrivalUnit;

	// % protected region % [Modify attribute annotation for Weight During Previous Hemodialysis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight During Previous Hemodialysis here] end
	private Double weightDuringPreviousHemodialysis;

	// % protected region % [Modify attribute annotation for Weight During Previous Hemodialysis Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight During Previous Hemodialysis Unit here] end
	private String weightDuringPreviousHemodialysisUnit;

	// % protected region % [Modify attribute annotation for Anti HIV here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anti HIV here] end
	private Boolean antiHIV;

	// % protected region % [Modify attribute annotation for HbsAg here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for HbsAg here] end
	private Boolean hbsag;

	// % protected region % [Modify attribute annotation for Anti HCV here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anti HCV here] end
	private Boolean antiHCV;

	// % protected region % [Modify attribute annotation for Hemodialysis Start Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hemodialysis Start Time here] end
	private OffsetDateTime hemodialysisStartTime;

	// % protected region % [Modify attribute annotation for Hemodialysis End Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hemodialysis End Time here] end
	private OffsetDateTime hemodialysisEndTime;

	// % protected region % [Modify attribute annotation for Target here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Target here] end
	private String target;

	// % protected region % [Modify attribute annotation for Priming Volume here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Priming Volume here] end
	private String primingVolume;

	// % protected region % [Modify attribute annotation for Remaining Priming here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Remaining Priming here] end
	private String remainingPriming;

	// % protected region % [Modify attribute annotation for Complication here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Complication here] end
	private String complication;

	// % protected region % [Modify attribute annotation for Hemodialysis Details here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hemodialysis Details here] end
	private String hemodialysisDetails;

	// % protected region % [Modify attribute annotation for Weight Upon Dismissal here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Upon Dismissal here] end
	private Double weightUponDismissal;

	// % protected region % [Modify attribute annotation for Weight Upon Dismissal Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Upon Dismissal Unit here] end
	private String weightUponDismissalUnit;

	// % protected region % [Modify attribute annotation for Priming here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Priming here] end
	private Double priming;

	// % protected region % [Modify attribute annotation for Blood here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Blood here] end
	private Double blood;

	// % protected region % [Modify attribute annotation for IV Line here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for IV Line here] end
	private Double ivLine;

	// % protected region % [Modify attribute annotation for Oral here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Oral here] end
	private Double oral;

	// % protected region % [Modify attribute annotation for Wash Out here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Wash Out here] end
	private Double washOut;

	// % protected region % [Modify attribute annotation for Total Fluid Intake here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Fluid Intake here] end
	private Double totalFluidIntake;

	// % protected region % [Modify attribute annotation for Urine here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Urine here] end
	private Double urine;

	// % protected region % [Modify attribute annotation for Others here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Others here] end
	private Double others;

	// % protected region % [Modify attribute annotation for Total Fluid Output here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Total Fluid Output here] end
	private Double totalFluidOutput;

	// % protected region % [Modify attribute annotation for Fluid Balance here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Fluid Balance here] end
	private Double fluidBalance;

	// % protected region % [Modify attribute annotation for Post Hemodialysis Evaluation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Post Hemodialysis Evaluation here] end
	private String postHemodialysisEvaluation;

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

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<HemodialysisMonitoringEntity> hemodialysisMonitorings = new HashSet<>();

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
	 * Similar to {@link this#addHemodialysisMonitorings(HemodialysisMonitoringEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be added to this entity
	 */
	public void addHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity) {
		addHemodialysisMonitorings(entity, true);
	}

	/**
	 * Add a new HemodialysisMonitoringEntity to hemodialysisMonitorings in this entity.
	 *
	 * @param entity the given HemodialysisMonitoringEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity, boolean reverseAdd) {
		if (!this.hemodialysisMonitorings.contains(entity)) {
			hemodialysisMonitorings.add(entity);
			if (reverseAdd) {
				entity.setHemodialysisExamination(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be added to this entity
	 */
	public void addHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities) {
		addHemodialysisMonitorings(entities, true);
	}

	/**
	 * Add a new collection of HemodialysisMonitoringEntity to Hemodialysis Monitorings in this entity.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addHemodialysisMonitorings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeHemodialysisMonitorings(HemodialysisMonitoringEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be set to this entity
	 */
	public void removeHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity) {
		this.removeHemodialysisMonitorings(entity, true);
	}

	/**
	 * Remove the given HemodialysisMonitoringEntity from this entity.
	 *
	 * @param entity the given HemodialysisMonitoringEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeHemodialysisMonitorings(@NonNull HemodialysisMonitoringEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetHemodialysisExamination(false);
		}
		this.hemodialysisMonitorings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be removed to this entity
	 */
	public void removeHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities) {
		this.removeHemodialysisMonitorings(entities, true);
	}

	/**
	 * Remove the given collection of HemodialysisMonitoringEntity from  to this entity.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeHemodialysisMonitorings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setHemodialysisMonitorings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to be set to this entity
	 */
	public void setHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities) {
		setHemodialysisMonitorings(entities, true);
	}

	/**
	 * Replace the current entities in Hemodialysis Monitorings with the given ones.
	 *
	 * @param entities the given collection of HemodialysisMonitoringEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setHemodialysisMonitorings(@NonNull Collection<HemodialysisMonitoringEntity> entities, boolean reverseAdd) {

		this.unsetHemodialysisMonitorings();
		this.hemodialysisMonitorings = new HashSet<>(entities);
		if (reverseAdd) {
			this.hemodialysisMonitorings.forEach(hemodialysisMonitoringsEntity -> hemodialysisMonitoringsEntity.setHemodialysisExamination(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetHemodialysisMonitorings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetHemodialysisMonitorings() {
		this.unsetHemodialysisMonitorings(true);
	}

	/**
	 * Remove all the entities in Hemodialysis Monitorings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetHemodialysisMonitorings(boolean doReverse) {
		if (doReverse) {
			this.hemodialysisMonitorings.forEach(hemodialysisMonitoringsEntity -> hemodialysisMonitoringsEntity.unsetHemodialysisExamination(false));
		}
		this.hemodialysisMonitorings.clear();
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
			this.medicalExaminationRecord.unsetHemodialysisExamination(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setHemodialysisExamination(this, false);
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
			this.medicalExaminationRecord.unsetHemodialysisExamination();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
