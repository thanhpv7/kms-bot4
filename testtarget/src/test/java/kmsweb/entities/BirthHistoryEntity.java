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
public class BirthHistoryEntity extends AbstractEntity {

	public BirthHistoryEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "BirthHistory";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Gestational Age Weeks here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gestational Age Weeks here] end
	private Integer gestationalAgeWeeks;

	// % protected region % [Modify attribute annotation for Gestational Age Days here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Gestational Age Days here] end
	private Integer gestationalAgeDays;

	// % protected region % [Modify attribute annotation for Delivery Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Delivery Type here] end
	private String deliveryType;

	// % protected region % [Modify attribute annotation for Length here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Length here] end
	private Double length;

	// % protected region % [Modify attribute annotation for Length Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Length Unit here] end
	private String lengthUnit;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Weight Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Unit here] end
	private String weightUnit;

	// % protected region % [Modify attribute annotation for Head Circumference Birth here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Head Circumference Birth here] end
	private Double headCircumferenceBirth;

	// % protected region % [Modify attribute annotation for Head Circumference Birth Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Head Circumference Birth Unit here] end
	private String headCircumferenceBirthUnit;

	// % protected region % [Modify attribute annotation for Chest Circumference here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Chest Circumference here] end
	private Double chestCircumference;

	// % protected region % [Modify attribute annotation for Chest Circumference Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Chest Circumference Unit here] end
	private String chestCircumferenceUnit;

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

	// % protected region % [Modify attribute annotation for Pediatric Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pediatric Case here] end
	private String pediatricCase;

	// % protected region % [Modify attribute annotation for Food Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Food Type here] end
	private String foodType;

	// % protected region % [Modify attribute annotation for Head Circumference here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Head Circumference here] end
	private Double headCircumference;

	// % protected region % [Modify attribute annotation for Head Circumference Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Head Circumference Unit here] end
	private String headCircumferenceUnit;

	// % protected region % [Modify attribute annotation for Upper Arm Circumference here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Upper Arm Circumference here] end
	private Double upperArmCircumference;

	// % protected region % [Modify attribute annotation for Upper Arm Circumference Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Upper Arm Circumference Unit here] end
	private String upperArmCircumferenceUnit;

	// % protected region % [Modify attribute annotation for Action Taken here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Action Taken here] end
	private String actionTaken;

	// % protected region % [Modify attribute annotation for Weight Gestational Age here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Weight Gestational Age here] end
	private String weightGestationalAge;

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
			this.medicalExaminationRecord.unsetBirthHistory(false);
		}

		this.medicalExaminationRecord = entity;
		if (reverseAdd) {
			this.medicalExaminationRecord.setBirthHistory(this, false);
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
			this.medicalExaminationRecord.unsetBirthHistory();
		}
		this.medicalExaminationRecord = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
