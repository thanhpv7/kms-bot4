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
import kmsweb.dtos.ExaminationItemDetailEntityDto;
import kmsweb.entities.listeners.ExaminationItemDetailEntityListener;
import kmsweb.serializers.ExaminationItemDetailSerializer;
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
@EntityListeners({ExaminationItemDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ExaminationItemDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class ExaminationItemDetailEntity extends AbstractEntity {

	/**
	 * Takes a ExaminationItemDetailEntityDto and converts it into a ExaminationItemDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param examinationItemDetailEntityDto
	 */
	public ExaminationItemDetailEntity(ExaminationItemDetailEntityDto examinationItemDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (examinationItemDetailEntityDto.getId() != null) {
			this.setId(examinationItemDetailEntityDto.getId());
		}

		if (examinationItemDetailEntityDto.getAgeMinimum() != null) {
			this.setAgeMinimum(examinationItemDetailEntityDto.getAgeMinimum());
		}

		if (examinationItemDetailEntityDto.getAgeMaximum() != null) {
			this.setAgeMaximum(examinationItemDetailEntityDto.getAgeMaximum());
		}

		if (examinationItemDetailEntityDto.getGender() != null) {
			this.setGender(examinationItemDetailEntityDto.getGender());
		}

		if (examinationItemDetailEntityDto.getNormalRangeLow() != null) {
			this.setNormalRangeLow(examinationItemDetailEntityDto.getNormalRangeLow());
		}

		if (examinationItemDetailEntityDto.getNormalRangeHigh() != null) {
			this.setNormalRangeHigh(examinationItemDetailEntityDto.getNormalRangeHigh());
		}

		if (examinationItemDetailEntityDto.getUnit() != null) {
			this.setUnit(examinationItemDetailEntityDto.getUnit());
		}

		if (examinationItemDetailEntityDto.getCriticalValueLow() != null) {
			this.setCriticalValueLow(examinationItemDetailEntityDto.getCriticalValueLow());
		}

		if (examinationItemDetailEntityDto.getCriticalValueHigh() != null) {
			this.setCriticalValueHigh(examinationItemDetailEntityDto.getCriticalValueHigh());
		}

		if (examinationItemDetailEntityDto.getAgeMinUnit() != null) {
			this.setAgeMinUnit(examinationItemDetailEntityDto.getAgeMinUnit());
		}

		if (examinationItemDetailEntityDto.getAgeMaxUnit() != null) {
			this.setAgeMaxUnit(examinationItemDetailEntityDto.getAgeMaxUnit());
		}

		if (examinationItemDetailEntityDto.getExaminationItem() != null) {
			this.setExaminationItem(examinationItemDetailEntityDto.getExaminationItem());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Age Minimum here] off begin
	@CsvBindByName(column = "AGE_MINIMUM", required = true)
	@NotNull(message = "Age Minimum must not be empty")
	@Column(name = "age_minimum")
	@Schema(description = "The Age Minimum of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Age Minimum here] end
	private Integer ageMinimum;

	// % protected region % [Modify attribute annotation for Age Maximum here] off begin
	@CsvBindByName(column = "AGE_MAXIMUM", required = true)
	@NotNull(message = "Age Maximum must not be empty")
	@Column(name = "age_maximum")
	@Schema(description = "The Age Maximum of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Age Maximum here] end
	private Integer ageMaximum;

	// % protected region % [Modify attribute annotation for Gender here] off begin
	@CsvBindByName(column = "GENDER", required = true)
	@NotNull(message = "Gender must not be empty")
	@Column(name = "gender")
	@Schema(description = "The Gender of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Gender here] end
	private String gender;

	// % protected region % [Modify attribute annotation for Normal Range Low here] off begin
	@CsvBindByName(column = "NORMAL_RANGE_LOW", required = true)
	@NotNull(message = "Normal Range Low must not be empty")
	@Column(name = "normal_range_low")
	@Schema(description = "The Normal Range Low of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Normal Range Low here] end
	private Double normalRangeLow;

	// % protected region % [Modify attribute annotation for Normal Range High here] off begin
	@CsvBindByName(column = "NORMAL_RANGE_HIGH", required = true)
	@NotNull(message = "Normal Range High must not be empty")
	@Column(name = "normal_range_high")
	@Schema(description = "The Normal Range High of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Normal Range High here] end
	private Double normalRangeHigh;

	// % protected region % [Modify attribute annotation for Unit here] off begin
	@CsvBindByName(column = "UNIT", required = true)
	@NotNull(message = "Unit must not be empty")
	@Column(name = "unit")
	@Schema(description = "The Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit here] end
	private String unit;

	// % protected region % [Modify attribute annotation for Critical Value Low here] off begin
	@CsvBindByName(column = "CRITICAL_VALUE_LOW", required = false)
	@Nullable
	@Column(name = "critical_value_low")
	@Schema(description = "The Critical Value Low of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Critical Value Low here] end
	private Double criticalValueLow;

	// % protected region % [Modify attribute annotation for Critical Value High here] off begin
	@CsvBindByName(column = "CRITICAL_VALUE_HIGH", required = false)
	@Nullable
	@Column(name = "critical_value_high")
	@Schema(description = "The Critical Value High of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Critical Value High here] end
	private Double criticalValueHigh;

	// % protected region % [Modify attribute annotation for Age Min Unit here] off begin
	@CsvBindByName(column = "AGE_MIN_UNIT", required = false)
	@Nullable
	@Column(name = "age_min_unit")
	@Schema(description = "The Age Min Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Age Min Unit here] end
	private String ageMinUnit;

	// % protected region % [Modify attribute annotation for Age Max Unit here] off begin
	@CsvBindByName(column = "AGE_MAX_UNIT", required = false)
	@Nullable
	@Column(name = "age_max_unit")
	@Schema(description = "The Age Max Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Age Max Unit here] end
	private String ageMaxUnit;

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

	// % protected region % [Update the annotation for Examination Item here] off begin
	@Schema(description = "The Examination Item entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Examination Item here] end
	private ExaminationItemEntity examinationItem;

	// % protected region % [Update the annotation for examinationItemId here] off begin
	@Transient
	@CsvCustomBindByName(column = "EXAMINATION_ITEM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for examinationItemId here] end
	private UUID examinationItemId;

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
	 * Similar to {@link this#setExaminationItem(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be set to this entity
	 */
	public void setExaminationItem(@NotNull ExaminationItemEntity entity) {
		setExaminationItem(entity, true);
	}

	/**
	 * Set or update the examinationItem in this entity with single ExaminationItemEntity.
	 *
	 * @param entity the given ExaminationItemEntity to be set or updated to examinationItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setExaminationItem(@NotNull ExaminationItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setExaminationItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setExaminationItem here] end

		if (sameAsFormer(this.examinationItem, entity)) {
			return;
		}

		if (this.examinationItem != null) {
			this.examinationItem.removeExaminationItemDetails(this, false);
		}
		this.examinationItem = entity;
		if (reverseAdd) {
			this.examinationItem.addExaminationItemDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setExaminationItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setExaminationItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetExaminationItem(boolean)} but default to true.
	 */
	public void unsetExaminationItem() {
		this.unsetExaminationItem(true);
	}

	/**
	 * Remove Examination Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetExaminationItem(boolean reverse) {
		if (reverse && this.examinationItem != null) {
			this.examinationItem.removeExaminationItemDetails(this, false);
		}
		this.examinationItem = null;
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
		return "AGE_MINIMUM,AGE_MAXIMUM,GENDER,NORMAL_RANGE_LOW,NORMAL_RANGE_HIGH,UNIT,CRITICAL_VALUE_LOW,CRITICAL_VALUE_HIGH,AGE_MIN_UNIT,AGE_MAX_UNIT,EXAMINATION_ITEM_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<ExaminationItemEntity> examinationItemRelation = Optional.ofNullable(this.examinationItem);
		examinationItemRelation.ifPresent(entity -> this.examinationItemId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object examinationItemDetail) {
		if (this == examinationItemDetail) {
			return true;
		}
		if (examinationItemDetail == null || this.getClass() != examinationItemDetail.getClass()) {
			return false;
		}
		if (!super.equals(examinationItemDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ExaminationItemDetailEntity that = (ExaminationItemDetailEntity) examinationItemDetail;
		return
			Objects.equals(this.ageMinimum, that.ageMinimum) &&
			Objects.equals(this.ageMaximum, that.ageMaximum) &&
			Objects.equals(this.gender, that.gender) &&
			Objects.equals(this.normalRangeLow, that.normalRangeLow) &&
			Objects.equals(this.normalRangeHigh, that.normalRangeHigh) &&
			Objects.equals(this.unit, that.unit) &&
			Objects.equals(this.criticalValueLow, that.criticalValueLow) &&
			Objects.equals(this.criticalValueHigh, that.criticalValueHigh) &&
			Objects.equals(this.ageMinUnit, that.ageMinUnit) &&
			Objects.equals(this.ageMaxUnit, that.ageMaxUnit) &&
			Objects.equals(this.examinationItemId, that.examinationItemId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
