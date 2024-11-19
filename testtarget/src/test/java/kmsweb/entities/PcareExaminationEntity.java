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
public class PcareExaminationEntity extends AbstractEntity {

	public PcareExaminationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PcareActionExaminationsOneMany = new EntityReference();
			PcareActionExaminationsOneMany.entityName = "PcareActionExamination";
			PcareActionExaminationsOneMany.oppositeName = "PcareExamination";
			PcareActionExaminationsOneMany.name = "PcareActionExaminations";
			PcareActionExaminationsOneMany.optional = true;
			PcareActionExaminationsOneMany.type = "One";
			PcareActionExaminationsOneMany.oppositeType = "Many";

		References.add(PcareActionExaminationsOneMany);

		var PcareCompoundDrugsOneMany = new EntityReference();
			PcareCompoundDrugsOneMany.entityName = "PcareCompoundDrug";
			PcareCompoundDrugsOneMany.oppositeName = "PcareExamination";
			PcareCompoundDrugsOneMany.name = "PcareCompoundDrugs";
			PcareCompoundDrugsOneMany.optional = true;
			PcareCompoundDrugsOneMany.type = "One";
			PcareCompoundDrugsOneMany.oppositeType = "Many";

		References.add(PcareCompoundDrugsOneMany);

		var RegistrationOneOne = new EntityReference();
			RegistrationOneOne.entityName = "Registration";
			RegistrationOneOne.oppositeName = "Registration";
			RegistrationOneOne.name = "PcareExamination";
			RegistrationOneOne.optional = true;
			RegistrationOneOne.type = "One";
			RegistrationOneOne.oppositeType = "One";

		References.add(RegistrationOneOne);

		var PcareNonCompoundDrugsOneMany = new EntityReference();
			PcareNonCompoundDrugsOneMany.entityName = "PcareNonCompoundDrug";
			PcareNonCompoundDrugsOneMany.oppositeName = "PcareExamination";
			PcareNonCompoundDrugsOneMany.name = "PcareNonCompoundDrugs";
			PcareNonCompoundDrugsOneMany.optional = true;
			PcareNonCompoundDrugsOneMany.type = "One";
			PcareNonCompoundDrugsOneMany.oppositeType = "Many";

		References.add(PcareNonCompoundDrugsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Visit Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Visit Type here] end
	private String visitType;

	// % protected region % [Modify attribute annotation for Treatment here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment here] end
	private String treatment;

	// % protected region % [Modify attribute annotation for Destination Polyclinic here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Destination Polyclinic here] end
	private String destinationPolyclinic;

	// % protected region % [Modify attribute annotation for Disease here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Disease here] end
	private String disease;

	// % protected region % [Modify attribute annotation for Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diagnosis here] end
	private String diagnosis;

	// % protected region % [Modify attribute annotation for Diagnosis 2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diagnosis 2 here] end
	private String diagnosis2;

	// % protected region % [Modify attribute annotation for Diagnosis 3 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diagnosis 3 here] end
	private String diagnosis3;

	// % protected region % [Modify attribute annotation for Therapy here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Therapy here] end
	private String therapy;

	// % protected region % [Modify attribute annotation for Consciousness here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Consciousness here] end
	private String consciousness;

	// % protected region % [Modify attribute annotation for Discharge Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Discharge Status here] end
	private String dischargeStatus;

	// % protected region % [Modify attribute annotation for Internal Referral Polyclinic here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Internal Referral Polyclinic here] end
	private String internalReferralPolyclinic;

	// % protected region % [Modify attribute annotation for Referring Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Referring Date here] end
	private OffsetDateTime referringDate;

	// % protected region % [Modify attribute annotation for PKK here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for PKK here] end
	private String pkk;

	// % protected region % [Modify attribute annotation for Sub Specialist here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sub Specialist here] end
	private String subSpecialist;

	// % protected region % [Modify attribute annotation for Facility here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Facility here] end
	private String facility;

	// % protected region % [Modify attribute annotation for TACC here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for TACC here] end
	private String tacc;

	// % protected region % [Modify attribute annotation for TACC Reason here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for TACC Reason here] end
	private String taccReason;

	// % protected region % [Modify attribute annotation for Special here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Special here] end
	private String special;

	// % protected region % [Modify attribute annotation for Height here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Height here] end
	private Double height;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Waist Circumference here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Waist Circumference here] end
	private Double waistCircumference;

	// % protected region % [Modify attribute annotation for BMI here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BMI here] end
	private Double bmi;

	// % protected region % [Modify attribute annotation for Systole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Systole here] end
	private Integer systole;

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diastole here] end
	private Integer diastole;

	// % protected region % [Modify attribute annotation for Respiratory Rate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Respiratory Rate here] end
	private Double respiratoryRate;

	// % protected region % [Modify attribute annotation for Heart Rate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Heart Rate here] end
	private Double heartRate;

	// % protected region % [Modify attribute annotation for Medical Staff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medical Staff here] end
	private String medicalStaff;

	// % protected region % [Modify attribute annotation for tglPulang here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for tglPulang here] end
	private String tglpulang;

	// % protected region % [Modify attribute annotation for kdSubSpesialis1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for kdSubSpesialis1 here] end
	private String kdsubspesialis1;

	// % protected region % [Modify attribute annotation for rujukLanjut here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for rujukLanjut here] end
	private String rujuklanjut;

	// % protected region % [Modify attribute annotation for catatan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for catatan here] end
	private String catatan;

	// % protected region % [Modify attribute annotation for noKunjungan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for noKunjungan here] end
	private String nokunjungan;

	// % protected region % [Modify attribute annotation for JsonInsert here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for JsonInsert here] end
	private String jsoninsert;

	// % protected region % [Modify attribute annotation for JsonUpdate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for JsonUpdate here] end
	private String jsonupdate;

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

	private RegistrationEntity registration;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<PcareActionExaminationEntity> pcareActionExaminations = new HashSet<>();

	private Set<PcareCompoundDrugEntity> pcareCompoundDrugs = new HashSet<>();

	private Set<PcareNonCompoundDrugEntity> pcareNonCompoundDrugs = new HashSet<>();

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
	 * Similar to {@link this#addPcareActionExaminations(PcareActionExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareActionExaminationEntity to be added to this entity
	 */
	public void addPcareActionExaminations(@NonNull PcareActionExaminationEntity entity) {
		addPcareActionExaminations(entity, true);
	}

	/**
	 * Add a new PcareActionExaminationEntity to pcareActionExaminations in this entity.
	 *
	 * @param entity the given PcareActionExaminationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPcareActionExaminations(@NonNull PcareActionExaminationEntity entity, boolean reverseAdd) {
		if (!this.pcareActionExaminations.contains(entity)) {
			pcareActionExaminations.add(entity);
			if (reverseAdd) {
				entity.setPcareExamination(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPcareActionExaminations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be added to this entity
	 */
	public void addPcareActionExaminations(@NonNull Collection<PcareActionExaminationEntity> entities) {
		addPcareActionExaminations(entities, true);
	}

	/**
	 * Add a new collection of PcareActionExaminationEntity to PCare Action Examinations in this entity.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPcareActionExaminations(@NonNull Collection<PcareActionExaminationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPcareActionExaminations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePcareActionExaminations(PcareActionExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareActionExaminationEntity to be set to this entity
	 */
	public void removePcareActionExaminations(@NonNull PcareActionExaminationEntity entity) {
		this.removePcareActionExaminations(entity, true);
	}

	/**
	 * Remove the given PcareActionExaminationEntity from this entity.
	 *
	 * @param entity the given PcareActionExaminationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePcareActionExaminations(@NonNull PcareActionExaminationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPcareExamination(false);
		}
		this.pcareActionExaminations.remove(entity);
	}

	/**
	 * Similar to {@link this#removePcareActionExaminations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be removed to this entity
	 */
	public void removePcareActionExaminations(@NonNull Collection<PcareActionExaminationEntity> entities) {
		this.removePcareActionExaminations(entities, true);
	}

	/**
	 * Remove the given collection of PcareActionExaminationEntity from  to this entity.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePcareActionExaminations(@NonNull Collection<PcareActionExaminationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePcareActionExaminations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPcareActionExaminations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to be set to this entity
	 */
	public void setPcareActionExaminations(@NonNull Collection<PcareActionExaminationEntity> entities) {
		setPcareActionExaminations(entities, true);
	}

	/**
	 * Replace the current entities in PCare Action Examinations with the given ones.
	 *
	 * @param entities the given collection of PcareActionExaminationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPcareActionExaminations(@NonNull Collection<PcareActionExaminationEntity> entities, boolean reverseAdd) {

		this.unsetPcareActionExaminations();
		this.pcareActionExaminations = new HashSet<>(entities);
		if (reverseAdd) {
			this.pcareActionExaminations.forEach(pcareActionExaminationsEntity -> pcareActionExaminationsEntity.setPcareExamination(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPcareActionExaminations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPcareActionExaminations() {
		this.unsetPcareActionExaminations(true);
	}

	/**
	 * Remove all the entities in PCare Action Examinations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPcareActionExaminations(boolean doReverse) {
		if (doReverse) {
			this.pcareActionExaminations.forEach(pcareActionExaminationsEntity -> pcareActionExaminationsEntity.unsetPcareExamination(false));
		}
		this.pcareActionExaminations.clear();
	}

/**
	 * Similar to {@link this#addPcareCompoundDrugs(PcareCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be added to this entity
	 */
	public void addPcareCompoundDrugs(@NonNull PcareCompoundDrugEntity entity) {
		addPcareCompoundDrugs(entity, true);
	}

	/**
	 * Add a new PcareCompoundDrugEntity to pcareCompoundDrugs in this entity.
	 *
	 * @param entity the given PcareCompoundDrugEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPcareCompoundDrugs(@NonNull PcareCompoundDrugEntity entity, boolean reverseAdd) {
		if (!this.pcareCompoundDrugs.contains(entity)) {
			pcareCompoundDrugs.add(entity);
			if (reverseAdd) {
				entity.setPcareExamination(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPcareCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be added to this entity
	 */
	public void addPcareCompoundDrugs(@NonNull Collection<PcareCompoundDrugEntity> entities) {
		addPcareCompoundDrugs(entities, true);
	}

	/**
	 * Add a new collection of PcareCompoundDrugEntity to PCare Compound Drugs in this entity.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPcareCompoundDrugs(@NonNull Collection<PcareCompoundDrugEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPcareCompoundDrugs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePcareCompoundDrugs(PcareCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be set to this entity
	 */
	public void removePcareCompoundDrugs(@NonNull PcareCompoundDrugEntity entity) {
		this.removePcareCompoundDrugs(entity, true);
	}

	/**
	 * Remove the given PcareCompoundDrugEntity from this entity.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePcareCompoundDrugs(@NonNull PcareCompoundDrugEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPcareExamination(false);
		}
		this.pcareCompoundDrugs.remove(entity);
	}

	/**
	 * Similar to {@link this#removePcareCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be removed to this entity
	 */
	public void removePcareCompoundDrugs(@NonNull Collection<PcareCompoundDrugEntity> entities) {
		this.removePcareCompoundDrugs(entities, true);
	}

	/**
	 * Remove the given collection of PcareCompoundDrugEntity from  to this entity.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePcareCompoundDrugs(@NonNull Collection<PcareCompoundDrugEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePcareCompoundDrugs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPcareCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to be set to this entity
	 */
	public void setPcareCompoundDrugs(@NonNull Collection<PcareCompoundDrugEntity> entities) {
		setPcareCompoundDrugs(entities, true);
	}

	/**
	 * Replace the current entities in PCare Compound Drugs with the given ones.
	 *
	 * @param entities the given collection of PcareCompoundDrugEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPcareCompoundDrugs(@NonNull Collection<PcareCompoundDrugEntity> entities, boolean reverseAdd) {

		this.unsetPcareCompoundDrugs();
		this.pcareCompoundDrugs = new HashSet<>(entities);
		if (reverseAdd) {
			this.pcareCompoundDrugs.forEach(pcareCompoundDrugsEntity -> pcareCompoundDrugsEntity.setPcareExamination(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPcareCompoundDrugs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPcareCompoundDrugs() {
		this.unsetPcareCompoundDrugs(true);
	}

	/**
	 * Remove all the entities in PCare Compound Drugs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPcareCompoundDrugs(boolean doReverse) {
		if (doReverse) {
			this.pcareCompoundDrugs.forEach(pcareCompoundDrugsEntity -> pcareCompoundDrugsEntity.unsetPcareExamination(false));
		}
		this.pcareCompoundDrugs.clear();
	}

/**
	 * Similar to {@link this#addPcareNonCompoundDrugs(PcareNonCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareNonCompoundDrugEntity to be added to this entity
	 */
	public void addPcareNonCompoundDrugs(@NonNull PcareNonCompoundDrugEntity entity) {
		addPcareNonCompoundDrugs(entity, true);
	}

	/**
	 * Add a new PcareNonCompoundDrugEntity to pcareNonCompoundDrugs in this entity.
	 *
	 * @param entity the given PcareNonCompoundDrugEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPcareNonCompoundDrugs(@NonNull PcareNonCompoundDrugEntity entity, boolean reverseAdd) {
		if (!this.pcareNonCompoundDrugs.contains(entity)) {
			pcareNonCompoundDrugs.add(entity);
			if (reverseAdd) {
				entity.setPcareExamination(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPcareNonCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be added to this entity
	 */
	public void addPcareNonCompoundDrugs(@NonNull Collection<PcareNonCompoundDrugEntity> entities) {
		addPcareNonCompoundDrugs(entities, true);
	}

	/**
	 * Add a new collection of PcareNonCompoundDrugEntity to PCare NonCompound Drugs in this entity.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPcareNonCompoundDrugs(@NonNull Collection<PcareNonCompoundDrugEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPcareNonCompoundDrugs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePcareNonCompoundDrugs(PcareNonCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareNonCompoundDrugEntity to be set to this entity
	 */
	public void removePcareNonCompoundDrugs(@NonNull PcareNonCompoundDrugEntity entity) {
		this.removePcareNonCompoundDrugs(entity, true);
	}

	/**
	 * Remove the given PcareNonCompoundDrugEntity from this entity.
	 *
	 * @param entity the given PcareNonCompoundDrugEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePcareNonCompoundDrugs(@NonNull PcareNonCompoundDrugEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPcareExamination(false);
		}
		this.pcareNonCompoundDrugs.remove(entity);
	}

	/**
	 * Similar to {@link this#removePcareNonCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be removed to this entity
	 */
	public void removePcareNonCompoundDrugs(@NonNull Collection<PcareNonCompoundDrugEntity> entities) {
		this.removePcareNonCompoundDrugs(entities, true);
	}

	/**
	 * Remove the given collection of PcareNonCompoundDrugEntity from  to this entity.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePcareNonCompoundDrugs(@NonNull Collection<PcareNonCompoundDrugEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePcareNonCompoundDrugs(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPcareNonCompoundDrugs(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to be set to this entity
	 */
	public void setPcareNonCompoundDrugs(@NonNull Collection<PcareNonCompoundDrugEntity> entities) {
		setPcareNonCompoundDrugs(entities, true);
	}

	/**
	 * Replace the current entities in PCare NonCompound Drugs with the given ones.
	 *
	 * @param entities the given collection of PcareNonCompoundDrugEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPcareNonCompoundDrugs(@NonNull Collection<PcareNonCompoundDrugEntity> entities, boolean reverseAdd) {

		this.unsetPcareNonCompoundDrugs();
		this.pcareNonCompoundDrugs = new HashSet<>(entities);
		if (reverseAdd) {
			this.pcareNonCompoundDrugs.forEach(pcareNonCompoundDrugsEntity -> pcareNonCompoundDrugsEntity.setPcareExamination(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPcareNonCompoundDrugs(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPcareNonCompoundDrugs() {
		this.unsetPcareNonCompoundDrugs(true);
	}

	/**
	 * Remove all the entities in PCare NonCompound Drugs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPcareNonCompoundDrugs(boolean doReverse) {
		if (doReverse) {
			this.pcareNonCompoundDrugs.forEach(pcareNonCompoundDrugsEntity -> pcareNonCompoundDrugsEntity.unsetPcareExamination(false));
		}
		this.pcareNonCompoundDrugs.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.unsetPcareExamination(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setPcareExamination(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove the RegistrationEntity of registration from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.unsetPcareExamination();
		}
		this.registration = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
