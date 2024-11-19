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
public class NewbornDetailEntity extends AbstractEntity {

	public NewbornDetailEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var DeliveryMedicalExaminationRecordOneMany = new EntityReference();
			DeliveryMedicalExaminationRecordOneMany.entityName = "DeliveryMedicalExaminationRecord";
			DeliveryMedicalExaminationRecordOneMany.oppositeName = "DeliveryMedicalExaminationRecord";
			DeliveryMedicalExaminationRecordOneMany.name = "NewbornDetails";
			DeliveryMedicalExaminationRecordOneMany.optional = true;
			DeliveryMedicalExaminationRecordOneMany.type = "One";
			DeliveryMedicalExaminationRecordOneMany.oppositeType = "Many";

		References.add(DeliveryMedicalExaminationRecordOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "PediatricianInCharge";
			StaffOneMany.optional = true;
			StaffOneMany.type = "One";
			StaffOneMany.oppositeType = "Many";

		References.add(StaffOneMany);

		var VitalSignsOneMany = new EntityReference();
			VitalSignsOneMany.entityName = "VitalSigns";
			VitalSignsOneMany.oppositeName = "NewbornDetail";
			VitalSignsOneMany.name = "VitalSigns";
			VitalSignsOneMany.optional = true;
			VitalSignsOneMany.type = "One";
			VitalSignsOneMany.oppositeType = "Many";

		References.add(VitalSignsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Newborn First Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Newborn First Name here] end
	private String newbornFirstName;

	// % protected region % [Modify attribute annotation for Newborn Last Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Newborn Last Name here] end
	private String newbornLastName;

	// % protected region % [Modify attribute annotation for Date Time Of Birth here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date Time Of Birth here] end
	private OffsetDateTime dateTimeOfBirth;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Delivery Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Delivery Type here] end
	private String deliveryType;

	// % protected region % [Modify attribute annotation for Delivery Type Indication here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Delivery Type Indication here] end
	private String deliveryTypeIndication;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight here] end
	private Integer weight;

	// % protected region % [Modify attribute annotation for Length here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Length here] end
	private Integer length;

	// % protected region % [Modify attribute annotation for Weight Of Gestational Age here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Of Gestational Age here] end
	private String weightOfGestationalAge;

	// % protected region % [Modify attribute annotation for Head Circumference here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Head Circumference here] end
	private Integer headCircumference;

	// % protected region % [Modify attribute annotation for Chest Circumference here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Chest Circumference here] end
	private Integer chestCircumference;

	// % protected region % [Modify attribute annotation for Birth Condition here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Birth Condition here] end
	private String birthCondition;

	// % protected region % [Modify attribute annotation for Neonatal Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Neonatal Case here] end
	private String neonatalCase;

	// % protected region % [Modify attribute annotation for Congenital Condition here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Congenital Condition here] end
	private String congenitalCondition;

	// % protected region % [Modify attribute annotation for Physical Examination here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Physical Examination here] end
	private String physicalExamination;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Appearance here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Appearance here] end
	private String apgar1MinuteAppearance;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Appearance here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Appearance here] end
	private String apgar5MinuteAppearance;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Appearance here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Appearance here] end
	private String apgar10MinuteAppearance;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Pulse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Pulse here] end
	private String apgar1MinutePulse;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Pulse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Pulse here] end
	private String apgar5MinutePulse;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Pulse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Pulse here] end
	private String apgar10MinutePulse;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Grimace here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Grimace here] end
	private String apgar1MinuteGrimace;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Grimace here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Grimace here] end
	private String apgar5MinuteGrimace;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Grimace here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Grimace here] end
	private String apgar10MinuteGrimace;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Activity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Activity here] end
	private String apgar1MinuteActivity;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Activity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Activity here] end
	private String apgar5MinuteActivity;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Activity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Activity here] end
	private String apgar10MinuteActivity;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Respiration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Respiration here] end
	private String apgar1MinuteRespiration;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Respiration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Respiration here] end
	private String apgar5MinuteRespiration;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Respiration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Respiration here] end
	private String apgar10MinuteRespiration;

	// % protected region % [Modify attribute annotation for APGAR 1 Minute Score here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 1 Minute Score here] end
	private String apgar1MinuteScore;

	// % protected region % [Modify attribute annotation for APGAR 5 Minute Score here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 5 Minute Score here] end
	private String apgar5MinuteScore;

	// % protected region % [Modify attribute annotation for APGAR 10 Minute Score here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for APGAR 10 Minute Score here] end
	private String apgar10MinuteScore;

	// % protected region % [Modify attribute annotation for Pediatric Nurse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pediatric Nurse here] end
	private String pediatricNurse;

	// % protected region % [Modify attribute annotation for Patient Id here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Id here] end
	private String patientId;

	// % protected region % [Modify attribute annotation for Registration Id here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Registration Id here] end
	private String registrationId;

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

	private Set<VitalSignsEntity> vitalSigns = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecord;

	private StaffEntity staff;

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
	 * Similar to {@link this#addVitalSigns(VitalSignsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VitalSignsEntity to be added to this entity
	 */
	public void addVitalSigns(@NonNull VitalSignsEntity entity) {
		addVitalSigns(entity, true);
	}

	/**
	 * Add a new VitalSignsEntity to vitalSigns in this entity.
	 *
	 * @param entity the given VitalSignsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addVitalSigns(@NonNull VitalSignsEntity entity, boolean reverseAdd) {
		if (!this.vitalSigns.contains(entity)) {
			vitalSigns.add(entity);
			if (reverseAdd) {
				entity.setNewbornDetail(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addVitalSigns(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VitalSignsEntity to be added to this entity
	 */
	public void addVitalSigns(@NonNull Collection<VitalSignsEntity> entities) {
		addVitalSigns(entities, true);
	}

	/**
	 * Add a new collection of VitalSignsEntity to Vital Signs in this entity.
	 *
	 * @param entities the given collection of VitalSignsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addVitalSigns(@NonNull Collection<VitalSignsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addVitalSigns(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeVitalSigns(VitalSignsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VitalSignsEntity to be set to this entity
	 */
	public void removeVitalSigns(@NonNull VitalSignsEntity entity) {
		this.removeVitalSigns(entity, true);
	}

	/**
	 * Remove the given VitalSignsEntity from this entity.
	 *
	 * @param entity the given VitalSignsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeVitalSigns(@NonNull VitalSignsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetNewbornDetail(false);
		}
		this.vitalSigns.remove(entity);
	}

	/**
	 * Similar to {@link this#removeVitalSigns(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of VitalSignsEntity to be removed to this entity
	 */
	public void removeVitalSigns(@NonNull Collection<VitalSignsEntity> entities) {
		this.removeVitalSigns(entities, true);
	}

	/**
	 * Remove the given collection of VitalSignsEntity from  to this entity.
	 *
	 * @param entities the given collection of VitalSignsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeVitalSigns(@NonNull Collection<VitalSignsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeVitalSigns(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setVitalSigns(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of VitalSignsEntity to be set to this entity
	 */
	public void setVitalSigns(@NonNull Collection<VitalSignsEntity> entities) {
		setVitalSigns(entities, true);
	}

	/**
	 * Replace the current entities in Vital Signs with the given ones.
	 *
	 * @param entities the given collection of VitalSignsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setVitalSigns(@NonNull Collection<VitalSignsEntity> entities, boolean reverseAdd) {

		this.unsetVitalSigns();
		this.vitalSigns = new HashSet<>(entities);
		if (reverseAdd) {
			this.vitalSigns.forEach(vitalSignsEntity -> vitalSignsEntity.setNewbornDetail(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetVitalSigns(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetVitalSigns() {
		this.unsetVitalSigns(true);
	}

	/**
	 * Remove all the entities in Vital Signs from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetVitalSigns(boolean doReverse) {
		if (doReverse) {
			this.vitalSigns.forEach(vitalSignsEntity -> vitalSignsEntity.unsetNewbornDetail(false));
		}
		this.vitalSigns.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setDeliveryMedicalExaminationRecord(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NonNull DeliveryMedicalExaminationRecordEntity entity) {
		setDeliveryMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the deliveryMedicalExaminationRecord in this entity with single DeliveryMedicalExaminationRecordEntity.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set or updated to deliveryMedicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NonNull DeliveryMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] end

		if (sameAsFormer(this.deliveryMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.removeNewbornDetails(this, false);
		}
		this.deliveryMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.deliveryMedicalExaminationRecord.addNewbornDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDeliveryMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetDeliveryMedicalExaminationRecord() {
		this.unsetDeliveryMedicalExaminationRecord(true);
	}

	/**
	 * Remove Delivery Medical Examination Record in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDeliveryMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.removeNewbornDetails(this, false);
		}
		this.deliveryMedicalExaminationRecord = null;
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
			this.staff.removePediatricianInCharge(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addPediatricianInCharge(this, false);
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
			this.staff.removePediatricianInCharge(this, false);
		}
		this.staff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
