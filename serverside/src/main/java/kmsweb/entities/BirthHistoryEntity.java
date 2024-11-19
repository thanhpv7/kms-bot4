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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.BirthHistoryEntityDto;
import kmsweb.entities.listeners.BirthHistoryEntityListener;
import kmsweb.serializers.BirthHistorySerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({BirthHistoryEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BirthHistorySerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BirthHistoryEntity extends AbstractEntity {

	/**
	 * Takes a BirthHistoryEntityDto and converts it into a BirthHistoryEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param birthHistoryEntityDto
	 */
	public BirthHistoryEntity(BirthHistoryEntityDto birthHistoryEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (birthHistoryEntityDto.getId() != null) {
			this.setId(birthHistoryEntityDto.getId());
		}

		if (birthHistoryEntityDto.getGestationalAgeWeeks() != null) {
			this.setGestationalAgeWeeks(birthHistoryEntityDto.getGestationalAgeWeeks());
		}

		if (birthHistoryEntityDto.getGestationalAgeDays() != null) {
			this.setGestationalAgeDays(birthHistoryEntityDto.getGestationalAgeDays());
		}

		if (birthHistoryEntityDto.getDeliveryType() != null) {
			this.setDeliveryType(birthHistoryEntityDto.getDeliveryType());
		}

		if (birthHistoryEntityDto.getLength() != null) {
			this.setLength(birthHistoryEntityDto.getLength());
		}

		if (birthHistoryEntityDto.getLengthUnit() != null) {
			this.setLengthUnit(birthHistoryEntityDto.getLengthUnit());
		}

		if (birthHistoryEntityDto.getWeight() != null) {
			this.setWeight(birthHistoryEntityDto.getWeight());
		}

		if (birthHistoryEntityDto.getWeightUnit() != null) {
			this.setWeightUnit(birthHistoryEntityDto.getWeightUnit());
		}

		if (birthHistoryEntityDto.getHeadCircumferenceBirth() != null) {
			this.setHeadCircumferenceBirth(birthHistoryEntityDto.getHeadCircumferenceBirth());
		}

		if (birthHistoryEntityDto.getHeadCircumferenceBirthUnit() != null) {
			this.setHeadCircumferenceBirthUnit(birthHistoryEntityDto.getHeadCircumferenceBirthUnit());
		}

		if (birthHistoryEntityDto.getChestCircumference() != null) {
			this.setChestCircumference(birthHistoryEntityDto.getChestCircumference());
		}

		if (birthHistoryEntityDto.getChestCircumferenceUnit() != null) {
			this.setChestCircumferenceUnit(birthHistoryEntityDto.getChestCircumferenceUnit());
		}

		if (birthHistoryEntityDto.getBirthCondition() != null) {
			this.setBirthCondition(birthHistoryEntityDto.getBirthCondition());
		}

		if (birthHistoryEntityDto.getNeonatalCase() != null) {
			this.setNeonatalCase(birthHistoryEntityDto.getNeonatalCase());
		}

		if (birthHistoryEntityDto.getPediatricCase() != null) {
			this.setPediatricCase(birthHistoryEntityDto.getPediatricCase());
		}

		if (birthHistoryEntityDto.getFoodType() != null) {
			this.setFoodType(birthHistoryEntityDto.getFoodType());
		}

		if (birthHistoryEntityDto.getHeadCircumference() != null) {
			this.setHeadCircumference(birthHistoryEntityDto.getHeadCircumference());
		}

		if (birthHistoryEntityDto.getHeadCircumferenceUnit() != null) {
			this.setHeadCircumferenceUnit(birthHistoryEntityDto.getHeadCircumferenceUnit());
		}

		if (birthHistoryEntityDto.getUpperArmCircumference() != null) {
			this.setUpperArmCircumference(birthHistoryEntityDto.getUpperArmCircumference());
		}

		if (birthHistoryEntityDto.getUpperArmCircumferenceUnit() != null) {
			this.setUpperArmCircumferenceUnit(birthHistoryEntityDto.getUpperArmCircumferenceUnit());
		}

		if (birthHistoryEntityDto.getActionTaken() != null) {
			this.setActionTaken(birthHistoryEntityDto.getActionTaken());
		}

		if (birthHistoryEntityDto.getWeightGestationalAge() != null) {
			this.setWeightGestationalAge(birthHistoryEntityDto.getWeightGestationalAge());
		}

		if (birthHistoryEntityDto.getMedicalExaminationRecord() != null) {
			this.setMedicalExaminationRecord(birthHistoryEntityDto.getMedicalExaminationRecord());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Gestational Age Weeks here] off begin
	@CsvBindByName(column = "GESTATIONAL_AGE_WEEKS", required = false)
	@Nullable
	@Column(name = "gestational_age_weeks")
	@Schema(description = "The Gestational Age Weeks of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gestational Age Weeks here] end
	private Integer gestationalAgeWeeks;

	// % protected region % [Modify attribute annotation for Gestational Age Days here] off begin
	@CsvBindByName(column = "GESTATIONAL_AGE_DAYS", required = false)
	@Nullable
	@Column(name = "gestational_age_days")
	@Schema(description = "The Gestational Age Days of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gestational Age Days here] end
	private Integer gestationalAgeDays;

	// % protected region % [Modify attribute annotation for Delivery Type here] off begin
	@CsvBindByName(column = "DELIVERY_TYPE", required = false)
	@Nullable
	@Column(name = "delivery_type")
	@Schema(description = "The Delivery Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Delivery Type here] end
	private String deliveryType;

	// % protected region % [Modify attribute annotation for Length here] off begin
	@CsvBindByName(column = "LENGTH", required = false)
	@Nullable
	@Column(name = "length")
	@Schema(description = "The Length of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Length here] end
	private Double length;

	// % protected region % [Modify attribute annotation for Length Unit here] off begin
	@CsvBindByName(column = "LENGTH_UNIT", required = false)
	@Nullable
	@Column(name = "length_unit")
	@Schema(description = "The Length Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Length Unit here] end
	private String lengthUnit;

	// % protected region % [Modify attribute annotation for Weight here] off begin
	@CsvBindByName(column = "WEIGHT", required = false)
	@Nullable
	@Column(name = "weight")
	@Schema(description = "The Weight of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight here] end
	private Double weight;

	// % protected region % [Modify attribute annotation for Weight Unit here] off begin
	@CsvBindByName(column = "WEIGHT_UNIT", required = false)
	@Nullable
	@Column(name = "weight_unit")
	@Schema(description = "The Weight Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Unit here] end
	private String weightUnit;

	// % protected region % [Modify attribute annotation for Head Circumference Birth here] off begin
	@CsvBindByName(column = "HEAD_CIRCUMFERENCE_BIRTH", required = false)
	@Nullable
	@Column(name = "head_circumference_birth")
	@Schema(description = "The Head Circumference Birth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Head Circumference Birth here] end
	private Double headCircumferenceBirth;

	// % protected region % [Modify attribute annotation for Head Circumference Birth Unit here] off begin
	@CsvBindByName(column = "HEAD_CIRCUMFERENCE_BIRTH_UNIT", required = false)
	@Nullable
	@Column(name = "head_circumference_birth_unit")
	@Schema(description = "The Head Circumference Birth Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Head Circumference Birth Unit here] end
	private String headCircumferenceBirthUnit;

	// % protected region % [Modify attribute annotation for Chest Circumference here] off begin
	@CsvBindByName(column = "CHEST_CIRCUMFERENCE", required = false)
	@Nullable
	@Column(name = "chest_circumference")
	@Schema(description = "The Chest Circumference of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Chest Circumference here] end
	private Double chestCircumference;

	// % protected region % [Modify attribute annotation for Chest Circumference Unit here] off begin
	@CsvBindByName(column = "CHEST_CIRCUMFERENCE_UNIT", required = false)
	@Nullable
	@Column(name = "chest_circumference_unit")
	@Schema(description = "The Chest Circumference Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Chest Circumference Unit here] end
	private String chestCircumferenceUnit;

	// % protected region % [Modify attribute annotation for Birth Condition here] off begin
	@CsvBindByName(column = "BIRTH_CONDITION", required = false)
	@Nullable
	@Column(name = "birth_condition")
	@Schema(description = "The Birth Condition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Birth Condition here] end
	private String birthCondition;

	// % protected region % [Modify attribute annotation for Neonatal Case here] off begin
	@CsvBindByName(column = "NEONATAL_CASE", required = false)
	@Nullable
	@Column(name = "neonatal_case")
	@Schema(description = "The Neonatal Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Neonatal Case here] end
	private String neonatalCase;

	// % protected region % [Modify attribute annotation for Pediatric Case here] off begin
	@CsvBindByName(column = "PEDIATRIC_CASE", required = false)
	@Nullable
	@Column(name = "pediatric_case")
	@Schema(description = "The Pediatric Case of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pediatric Case here] end
	private String pediatricCase;

	// % protected region % [Modify attribute annotation for Food Type here] off begin
	@CsvBindByName(column = "FOOD_TYPE", required = false)
	@Nullable
	@Column(name = "food_type")
	@Schema(description = "The Food Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Food Type here] end
	private String foodType;

	// % protected region % [Modify attribute annotation for Head Circumference here] off begin
	@CsvBindByName(column = "HEAD_CIRCUMFERENCE", required = false)
	@Nullable
	@Column(name = "head_circumference")
	@Schema(description = "The Head Circumference of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Head Circumference here] end
	private Double headCircumference;

	// % protected region % [Modify attribute annotation for Head Circumference Unit here] off begin
	@CsvBindByName(column = "HEAD_CIRCUMFERENCE_UNIT", required = false)
	@Nullable
	@Column(name = "head_circumference_unit")
	@Schema(description = "The Head Circumference Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Head Circumference Unit here] end
	private String headCircumferenceUnit;

	// % protected region % [Modify attribute annotation for Upper Arm Circumference here] off begin
	@CsvBindByName(column = "UPPER_ARM_CIRCUMFERENCE", required = false)
	@Nullable
	@Column(name = "upper_arm_circumference")
	@Schema(description = "The Upper Arm Circumference of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Upper Arm Circumference here] end
	private Double upperArmCircumference;

	// % protected region % [Modify attribute annotation for Upper Arm Circumference Unit here] off begin
	@CsvBindByName(column = "UPPER_ARM_CIRCUMFERENCE_UNIT", required = false)
	@Nullable
	@Column(name = "upper_arm_circumference_unit")
	@Schema(description = "The Upper Arm Circumference Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Upper Arm Circumference Unit here] end
	private String upperArmCircumferenceUnit;

	// % protected region % [Modify attribute annotation for Action Taken here] off begin
	@CsvBindByName(column = "ACTION_TAKEN", required = false)
	@Nullable
	@Column(name = "action_taken")
	@Schema(description = "The Action Taken of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Action Taken here] end
	private String actionTaken;

	// % protected region % [Modify attribute annotation for Weight Gestational Age here] off begin
	@CsvBindByName(column = "WEIGHT_GESTATIONAL_AGE", required = false)
	@Nullable
	@Column(name = "weight_gestational_age")
	@Schema(description = "The Weight Gestational Age of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Weight Gestational Age here] end
	private String weightGestationalAge;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Medical Examination Record here] off begin
	@Schema(description = "The Medical Examination Record entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medical Examination Record here] end
	private MedicalExaminationRecordEntity medicalExaminationRecord;

	// % protected region % [Update the annotation for medicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicalExaminationRecordId here] end
	private UUID medicalExaminationRecordId;

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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "GESTATIONAL_AGE_WEEKS,GESTATIONAL_AGE_DAYS,DELIVERY_TYPE,LENGTH,LENGTH_UNIT,WEIGHT,WEIGHT_UNIT,HEAD_CIRCUMFERENCE_BIRTH,HEAD_CIRCUMFERENCE_BIRTH_UNIT,CHEST_CIRCUMFERENCE,CHEST_CIRCUMFERENCE_UNIT,BIRTH_CONDITION,NEONATAL_CASE,PEDIATRIC_CASE,FOOD_TYPE,HEAD_CIRCUMFERENCE,HEAD_CIRCUMFERENCE_UNIT,UPPER_ARM_CIRCUMFERENCE,UPPER_ARM_CIRCUMFERENCE_UNIT,ACTION_TAKEN,WEIGHT_GESTATIONAL_AGE,MEDICAL_EXAMINATION_RECORD_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<MedicalExaminationRecordEntity> medicalExaminationRecordRelation = Optional.ofNullable(this.medicalExaminationRecord);
		medicalExaminationRecordRelation.ifPresent(entity -> this.medicalExaminationRecordId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object birthHistory) {
		if (this == birthHistory) {
			return true;
		}
		if (birthHistory == null || this.getClass() != birthHistory.getClass()) {
			return false;
		}
		if (!super.equals(birthHistory)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BirthHistoryEntity that = (BirthHistoryEntity) birthHistory;
		return
			Objects.equals(this.gestationalAgeWeeks, that.gestationalAgeWeeks) &&
			Objects.equals(this.gestationalAgeDays, that.gestationalAgeDays) &&
			Objects.equals(this.deliveryType, that.deliveryType) &&
			Objects.equals(this.length, that.length) &&
			Objects.equals(this.lengthUnit, that.lengthUnit) &&
			Objects.equals(this.weight, that.weight) &&
			Objects.equals(this.weightUnit, that.weightUnit) &&
			Objects.equals(this.headCircumferenceBirth, that.headCircumferenceBirth) &&
			Objects.equals(this.headCircumferenceBirthUnit, that.headCircumferenceBirthUnit) &&
			Objects.equals(this.chestCircumference, that.chestCircumference) &&
			Objects.equals(this.chestCircumferenceUnit, that.chestCircumferenceUnit) &&
			Objects.equals(this.birthCondition, that.birthCondition) &&
			Objects.equals(this.neonatalCase, that.neonatalCase) &&
			Objects.equals(this.pediatricCase, that.pediatricCase) &&
			Objects.equals(this.foodType, that.foodType) &&
			Objects.equals(this.headCircumference, that.headCircumference) &&
			Objects.equals(this.headCircumferenceUnit, that.headCircumferenceUnit) &&
			Objects.equals(this.upperArmCircumference, that.upperArmCircumference) &&
			Objects.equals(this.upperArmCircumferenceUnit, that.upperArmCircumferenceUnit) &&
			Objects.equals(this.actionTaken, that.actionTaken) &&
			Objects.equals(this.weightGestationalAge, that.weightGestationalAge) &&
			Objects.equals(this.medicalExaminationRecordId, that.medicalExaminationRecordId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
