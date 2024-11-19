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
public class DeliveryProgressEntity extends AbstractEntity {

	public DeliveryProgressEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var DeliveryMedicalExaminationRecordOneMany = new EntityReference();
			DeliveryMedicalExaminationRecordOneMany.entityName = "DeliveryMedicalExaminationRecord";
			DeliveryMedicalExaminationRecordOneMany.oppositeName = "DeliveryMedicalExaminationRecord";
			DeliveryMedicalExaminationRecordOneMany.name = "DeliveryProgresses";
			DeliveryMedicalExaminationRecordOneMany.optional = true;
			DeliveryMedicalExaminationRecordOneMany.type = "One";
			DeliveryMedicalExaminationRecordOneMany.oppositeType = "Many";

		References.add(DeliveryMedicalExaminationRecordOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "DeliveryProgresses";
			StaffOneMany.optional = true;
			StaffOneMany.type = "One";
			StaffOneMany.oppositeType = "Many";

		References.add(StaffOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Progress Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Progress Date Time here] end
	private OffsetDateTime progressDateTime;

	// % protected region % [Modify attribute annotation for FHR Per Minute here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for FHR Per Minute here] end
	private Integer fhrPerMinute;

	// % protected region % [Modify attribute annotation for Amniotic Fluid here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Amniotic Fluid here] end
	private String amnioticFluid;

	// % protected region % [Modify attribute annotation for Moulding here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Moulding here] end
	private String moulding;

	// % protected region % [Modify attribute annotation for Cervical Dilatation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cervical Dilatation here] end
	private Integer cervicalDilatation;

	// % protected region % [Modify attribute annotation for Fetal Head Descent here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Fetal Head Descent here] end
	private String fetalHeadDescent;

	// % protected region % [Modify attribute annotation for Contraction Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contraction Qty here] end
	private Integer contractionQty;

	// % protected region % [Modify attribute annotation for Contraction Mins here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Contraction Mins here] end
	private String contractionMins;

	// % protected region % [Modify attribute annotation for Drip Strength here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drip Strength here] end
	private Integer dripStrength;

	// % protected region % [Modify attribute annotation for Drip Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drip Number here] end
	private Integer dripNumber;

	// % protected region % [Modify attribute annotation for Drug IV here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drug IV here] end
	private String drugIV;

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

	// % protected region % [Modify attribute annotation for Pulse here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pulse here] end
	private Integer pulse;

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature Unit here] end
	private String temperatureUnit;

	// % protected region % [Modify attribute annotation for Urine Protein here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Urine Protein here] end
	private String urineProtein;

	// % protected region % [Modify attribute annotation for Urine Acetone here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Urine Acetone here] end
	private String urineAcetone;

	// % protected region % [Modify attribute annotation for Urine Volume here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Urine Volume here] end
	private Double urineVolume;

	// % protected region % [Modify attribute annotation for Progress Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Progress Notes here] end
	private String progressNotes;

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
			this.deliveryMedicalExaminationRecord.removeDeliveryProgresses(this, false);
		}
		this.deliveryMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.deliveryMedicalExaminationRecord.addDeliveryProgresses(this, false);
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
			this.deliveryMedicalExaminationRecord.removeDeliveryProgresses(this, false);
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
			this.staff.removeDeliveryProgresses(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addDeliveryProgresses(this, false);
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
			this.staff.removeDeliveryProgresses(this, false);
		}
		this.staff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
