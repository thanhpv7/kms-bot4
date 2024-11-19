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
public class DeliveryMedicalExaminationRecordEntity extends AbstractEntity {

	public DeliveryMedicalExaminationRecordEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AdditionalMidwivesOneMany = new EntityReference();
			AdditionalMidwivesOneMany.entityName = "CoTreatingDoctor";
			AdditionalMidwivesOneMany.oppositeName = "AdditionalMidwife";
			AdditionalMidwivesOneMany.name = "AdditionalMidwives";
			AdditionalMidwivesOneMany.optional = true;
			AdditionalMidwivesOneMany.type = "One";
			AdditionalMidwivesOneMany.oppositeType = "Many";

		References.add(AdditionalMidwivesOneMany);

		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "DeliveryMedicalExaminationRecord";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);

		var DeliveryProgressesOneMany = new EntityReference();
			DeliveryProgressesOneMany.entityName = "DeliveryProgress";
			DeliveryProgressesOneMany.oppositeName = "DeliveryMedicalExaminationRecord";
			DeliveryProgressesOneMany.name = "DeliveryProgresses";
			DeliveryProgressesOneMany.optional = true;
			DeliveryProgressesOneMany.type = "One";
			DeliveryProgressesOneMany.oppositeType = "Many";

		References.add(DeliveryProgressesOneMany);

		var MidwifeOneMany = new EntityReference();
			MidwifeOneMany.entityName = "Staff";
			MidwifeOneMany.oppositeName = "Midwife";
			MidwifeOneMany.name = "Midwives";
			MidwifeOneMany.optional = true;
			MidwifeOneMany.type = "One";
			MidwifeOneMany.oppositeType = "Many";

		References.add(MidwifeOneMany);

		var NewbornDetailsOneMany = new EntityReference();
			NewbornDetailsOneMany.entityName = "NewbornDetail";
			NewbornDetailsOneMany.oppositeName = "DeliveryMedicalExaminationRecord";
			NewbornDetailsOneMany.name = "NewbornDetails";
			NewbornDetailsOneMany.optional = true;
			NewbornDetailsOneMany.type = "One";
			NewbornDetailsOneMany.oppositeType = "Many";

		References.add(NewbornDetailsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Pregnancy History Gravida here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pregnancy History Gravida here] end
	private String pregnancyHistoryGravida;

	// % protected region % [Modify attribute annotation for Pregnancy History Partum  here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pregnancy History Partum  here] end
	private String pregnancyHistoryPartum;

	// % protected region % [Modify attribute annotation for Pregnancy History Abortum  here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pregnancy History Abortum  here] end
	private String pregnancyHistoryAbortum;

	// % protected region % [Modify attribute annotation for Pregnancy History Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pregnancy History Notes here] end
	private String pregnancyHistoryNotes;

	// % protected region % [Modify attribute annotation for LNMP Start Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for LNMP Start Date here] end
	private OffsetDateTime lnmpStartDate;

	// % protected region % [Modify attribute annotation for LNMP End Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for LNMP End Date here] end
	private OffsetDateTime lnmpEndDate;

	// % protected region % [Modify attribute annotation for Approximate Birth Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approximate Birth Date here] end
	private OffsetDateTime approximateBirthDate;

	// % protected region % [Modify attribute annotation for Gestation Age Weeks here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gestation Age Weeks here] end
	private Integer gestationAgeWeeks;

	// % protected region % [Modify attribute annotation for Gestation Age Days here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gestation Age Days here] end
	private Integer gestationAgeDays;

	// % protected region % [Modify attribute annotation for Tetanus Vaccine 1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tetanus Vaccine 1 here] end
	private Boolean tetanusVaccine1;

	// % protected region % [Modify attribute annotation for Tetanus Vaccine 2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tetanus Vaccine 2 here] end
	private Boolean tetanusVaccine2;

	// % protected region % [Modify attribute annotation for Delivery Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Delivery Type here] end
	private String deliveryType;

	// % protected region % [Modify attribute annotation for Complications In Pregnancy here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Complications In Pregnancy here] end
	private String complicationsInPregnancy;

	// % protected region % [Modify attribute annotation for Risk Factor here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Risk Factor here] end
	private String riskFactor;

	// % protected region % [Modify attribute annotation for Fetal Presentation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Fetal Presentation here] end
	private String fetalPresentation;

	// % protected region % [Modify attribute annotation for Abdomen Examination here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Abdomen Examination here] end
	private String abdomenExamination;

	// % protected region % [Modify attribute annotation for Fundal Height here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Fundal Height here] end
	private String fundalHeight;

	// % protected region % [Modify attribute annotation for FHR Per Minute here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for FHR Per Minute here] end
	private String fhrPerMinute;

	// % protected region % [Modify attribute annotation for Estimated Fetal Weight here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Estimated Fetal Weight here] end
	private String estimatedFetalWeight;

	// % protected region % [Modify attribute annotation for Leopold 1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Leopold 1 here] end
	private String leopold1;

	// % protected region % [Modify attribute annotation for Leopold 2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Leopold 2 here] end
	private String leopold2;

	// % protected region % [Modify attribute annotation for Leopold 3 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Leopold 3 here] end
	private String leopold3;

	// % protected region % [Modify attribute annotation for Leopold 4 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Leopold 4 here] end
	private String leopold4;

	// % protected region % [Modify attribute annotation for Genitelia Externa here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Genitelia Externa here] end
	private String geniteliaExterna;

	// % protected region % [Modify attribute annotation for Genitelia Interna here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Genitelia Interna here] end
	private String geniteliaInterna;

	// % protected region % [Modify attribute annotation for Vaginal Examination here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Vaginal Examination here] end
	private String vaginalExamination;

	// % protected region % [Modify attribute annotation for Delivery Complication here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Delivery Complication here] end
	private String deliveryComplication;

	// % protected region % [Modify attribute annotation for Delivery Note here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Delivery Note here] end
	private String deliveryNote;

	// % protected region % [Modify attribute annotation for Normal Delivery Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Normal Delivery Case here] end
	private Boolean normalDeliveryCase;

	// % protected region % [Modify attribute annotation for Stage 1 Hour here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stage 1 Hour here] end
	private Integer stage1Hour;

	// % protected region % [Modify attribute annotation for Unnamed Integer 1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unnamed Integer 1 here] end
	private Integer unnamedInteger1;

	// % protected region % [Modify attribute annotation for Stage 3 Hour here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stage 3 Hour here] end
	private Integer stage3Hour;

	// % protected region % [Modify attribute annotation for Stage 4 Hour here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stage 4 Hour here] end
	private Integer stage4Hour;

	// % protected region % [Modify attribute annotation for Stage 1 Minute here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stage 1 Minute here] end
	private Integer stage1Minute;

	// % protected region % [Modify attribute annotation for Stage 2 Minute here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stage 2 Minute here] end
	private Integer stage2Minute;

	// % protected region % [Modify attribute annotation for Stage 3 Minute here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stage 3 Minute here] end
	private Integer stage3Minute;

	// % protected region % [Modify attribute annotation for Stage 4 Minute here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Stage 4 Minute here] end
	private Integer stage4Minute;

	// % protected region % [Modify attribute annotation for Placenta here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Placenta here] end
	private String placenta;

	// % protected region % [Modify attribute annotation for Perineum here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Perineum here] end
	private String perineum;

	// % protected region % [Modify attribute annotation for Bleeding here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bleeding here] end
	private String bleeding;

	// % protected region % [Modify attribute annotation for Postpartum Complication here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Postpartum Complication here] end
	private String postpartumComplication;

	// % protected region % [Modify attribute annotation for Newborn Delivered here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Newborn Delivered here] end
	private Integer newbornDelivered;

	// % protected region % [Modify attribute annotation for Perineum Infection here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Perineum Infection here] end
	private Boolean perineumInfection;

	// % protected region % [Modify attribute annotation for Early Breastfeeding Intiation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Early Breastfeeding Intiation here] end
	private Boolean earlyBreastfeedingIntiation;

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

	private Set<CoTreatingDoctorEntity> additionalMidwives = new HashSet<>();

	private Set<DeliveryProgressEntity> deliveryProgresses = new HashSet<>();

	private Set<NewbornDetailEntity> newbornDetails = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private StaffEntity midwife;

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
	 * Similar to {@link this#addAdditionalMidwives(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalMidwives(@NonNull CoTreatingDoctorEntity entity) {
		addAdditionalMidwives(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to additionalMidwives in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalMidwives(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.additionalMidwives.contains(entity)) {
			additionalMidwives.add(entity);
			if (reverseAdd) {
				entity.setAdditionalMidwife(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalMidwives(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalMidwives(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		addAdditionalMidwives(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Additional Midwives in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalMidwives(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalMidwives(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalMidwives(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeAdditionalMidwives(@NonNull CoTreatingDoctorEntity entity) {
		this.removeAdditionalMidwives(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalMidwives(@NonNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalMidwife(false);
		}
		this.additionalMidwives.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalMidwives(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeAdditionalMidwives(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeAdditionalMidwives(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalMidwives(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalMidwives(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalMidwives(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setAdditionalMidwives(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		setAdditionalMidwives(entities, true);
	}

	/**
	 * Replace the current entities in Additional Midwives with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalMidwives(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalMidwives();
		this.additionalMidwives = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalMidwives.forEach(additionalMidwivesEntity -> additionalMidwivesEntity.setAdditionalMidwife(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalMidwives(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalMidwives() {
		this.unsetAdditionalMidwives(true);
	}

	/**
	 * Remove all the entities in Additional Midwives from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalMidwives(boolean doReverse) {
		if (doReverse) {
			this.additionalMidwives.forEach(additionalMidwivesEntity -> additionalMidwivesEntity.unsetAdditionalMidwife(false));
		}
		this.additionalMidwives.clear();
	}

/**
	 * Similar to {@link this#addDeliveryProgresses(DeliveryProgressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryProgressEntity to be added to this entity
	 */
	public void addDeliveryProgresses(@NonNull DeliveryProgressEntity entity) {
		addDeliveryProgresses(entity, true);
	}

	/**
	 * Add a new DeliveryProgressEntity to deliveryProgresses in this entity.
	 *
	 * @param entity the given DeliveryProgressEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addDeliveryProgresses(@NonNull DeliveryProgressEntity entity, boolean reverseAdd) {
		if (!this.deliveryProgresses.contains(entity)) {
			deliveryProgresses.add(entity);
			if (reverseAdd) {
				entity.setDeliveryMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be added to this entity
	 */
	public void addDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities) {
		addDeliveryProgresses(entities, true);
	}

	/**
	 * Add a new collection of DeliveryProgressEntity to Delivery Progresses in this entity.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addDeliveryProgresses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeDeliveryProgresses(DeliveryProgressEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryProgressEntity to be set to this entity
	 */
	public void removeDeliveryProgresses(@NonNull DeliveryProgressEntity entity) {
		this.removeDeliveryProgresses(entity, true);
	}

	/**
	 * Remove the given DeliveryProgressEntity from this entity.
	 *
	 * @param entity the given DeliveryProgressEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeDeliveryProgresses(@NonNull DeliveryProgressEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDeliveryMedicalExaminationRecord(false);
		}
		this.deliveryProgresses.remove(entity);
	}

	/**
	 * Similar to {@link this#removeDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be removed to this entity
	 */
	public void removeDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities) {
		this.removeDeliveryProgresses(entities, true);
	}

	/**
	 * Remove the given collection of DeliveryProgressEntity from  to this entity.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeDeliveryProgresses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setDeliveryProgresses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to be set to this entity
	 */
	public void setDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities) {
		setDeliveryProgresses(entities, true);
	}

	/**
	 * Replace the current entities in Delivery Progresses with the given ones.
	 *
	 * @param entities the given collection of DeliveryProgressEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setDeliveryProgresses(@NonNull Collection<DeliveryProgressEntity> entities, boolean reverseAdd) {

		this.unsetDeliveryProgresses();
		this.deliveryProgresses = new HashSet<>(entities);
		if (reverseAdd) {
			this.deliveryProgresses.forEach(deliveryProgressesEntity -> deliveryProgressesEntity.setDeliveryMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetDeliveryProgresses(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetDeliveryProgresses() {
		this.unsetDeliveryProgresses(true);
	}

	/**
	 * Remove all the entities in Delivery Progresses from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetDeliveryProgresses(boolean doReverse) {
		if (doReverse) {
			this.deliveryProgresses.forEach(deliveryProgressesEntity -> deliveryProgressesEntity.unsetDeliveryMedicalExaminationRecord(false));
		}
		this.deliveryProgresses.clear();
	}

/**
	 * Similar to {@link this#addNewbornDetails(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be added to this entity
	 */
	public void addNewbornDetails(@NonNull NewbornDetailEntity entity) {
		addNewbornDetails(entity, true);
	}

	/**
	 * Add a new NewbornDetailEntity to newbornDetails in this entity.
	 *
	 * @param entity the given NewbornDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addNewbornDetails(@NonNull NewbornDetailEntity entity, boolean reverseAdd) {
		if (!this.newbornDetails.contains(entity)) {
			newbornDetails.add(entity);
			if (reverseAdd) {
				entity.setDeliveryMedicalExaminationRecord(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addNewbornDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be added to this entity
	 */
	public void addNewbornDetails(@NonNull Collection<NewbornDetailEntity> entities) {
		addNewbornDetails(entities, true);
	}

	/**
	 * Add a new collection of NewbornDetailEntity to Newborn Details in this entity.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addNewbornDetails(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addNewbornDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeNewbornDetails(NewbornDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given NewbornDetailEntity to be set to this entity
	 */
	public void removeNewbornDetails(@NonNull NewbornDetailEntity entity) {
		this.removeNewbornDetails(entity, true);
	}

	/**
	 * Remove the given NewbornDetailEntity from this entity.
	 *
	 * @param entity the given NewbornDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeNewbornDetails(@NonNull NewbornDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetDeliveryMedicalExaminationRecord(false);
		}
		this.newbornDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeNewbornDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be removed to this entity
	 */
	public void removeNewbornDetails(@NonNull Collection<NewbornDetailEntity> entities) {
		this.removeNewbornDetails(entities, true);
	}

	/**
	 * Remove the given collection of NewbornDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeNewbornDetails(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeNewbornDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setNewbornDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of NewbornDetailEntity to be set to this entity
	 */
	public void setNewbornDetails(@NonNull Collection<NewbornDetailEntity> entities) {
		setNewbornDetails(entities, true);
	}

	/**
	 * Replace the current entities in Newborn Details with the given ones.
	 *
	 * @param entities the given collection of NewbornDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setNewbornDetails(@NonNull Collection<NewbornDetailEntity> entities, boolean reverseAdd) {

		this.unsetNewbornDetails();
		this.newbornDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.newbornDetails.forEach(newbornDetailsEntity -> newbornDetailsEntity.setDeliveryMedicalExaminationRecord(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetNewbornDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetNewbornDetails() {
		this.unsetNewbornDetails(true);
	}

	/**
	 * Remove all the entities in Newborn Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetNewbornDetails(boolean doReverse) {
		if (doReverse) {
			this.newbornDetails.forEach(newbornDetailsEntity -> newbornDetailsEntity.unsetDeliveryMedicalExaminationRecord(false));
		}
		this.newbornDetails.clear();
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
			this.medicalExaminationRecord.unsetDeliveryMedicalExaminationRecord(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setDeliveryMedicalExaminationRecord(this, false);
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
			this.medicalExaminationRecord.unsetDeliveryMedicalExaminationRecord();
		}
		this.medicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setMidwife(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMidwife(@NonNull StaffEntity entity) {
		setMidwife(entity, true);
	}

	/**
	 * Set or update the midwife in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to midwife
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMidwife(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMidwife here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMidwife here] end

		if (sameAsFormer(this.midwife, entity)) {
			return;
		}

		if (this.midwife != null) {
			this.midwife.removeMidwives(this, false);
		}
		this.midwife = entity;
		if (reverseAdd) {
			this.midwife.addMidwives(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMidwife incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMidwife incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMidwife(boolean)} but default to true.
	 */
	public void unsetMidwife() {
		this.unsetMidwife(true);
	}

	/**
	 * Remove Midwife in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMidwife(boolean reverse) {
		if (reverse && this.midwife != null) {
			this.midwife.removeMidwives(this, false);
		}
		this.midwife = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
