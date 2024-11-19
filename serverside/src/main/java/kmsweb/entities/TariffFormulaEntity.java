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
import kmsweb.dtos.TariffFormulaEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.TariffFormulaEntityListener;
import kmsweb.serializers.TariffFormulaSerializer;
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
@EntityListeners({TariffFormulaEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TariffFormulaSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TariffFormulaEntity extends AbstractEntity {

	/**
	 * Takes a TariffFormulaEntityDto and converts it into a TariffFormulaEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param tariffFormulaEntityDto
	 */
	public TariffFormulaEntity(TariffFormulaEntityDto tariffFormulaEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (tariffFormulaEntityDto.getId() != null) {
			this.setId(tariffFormulaEntityDto.getId());
		}

		if (tariffFormulaEntityDto.getTariffType() != null) {
			this.setTariffType(tariffFormulaEntityDto.getTariffType());
		}

		if (tariffFormulaEntityDto.getClassification() != null) {
			this.setClassification(tariffFormulaEntityDto.getClassification());
		}

		if (tariffFormulaEntityDto.getMultiplier() != null) {
			this.setMultiplier(tariffFormulaEntityDto.getMultiplier());
		}

		if (tariffFormulaEntityDto.getRounding() != null) {
			this.setRounding(tariffFormulaEntityDto.getRounding());
		}

		if (tariffFormulaEntityDto.getRoundingMethod() != null) {
			this.setRoundingMethod(tariffFormulaEntityDto.getRoundingMethod());
		}

		if (tariffFormulaEntityDto.getBaseSchema() != null) {
			this.setBaseSchema(tariffFormulaEntityDto.getBaseSchema());
		}

		if (tariffFormulaEntityDto.getTariffSchema() != null) {
			this.setTariffSchema(tariffFormulaEntityDto.getTariffSchema());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Tariff Type here] off begin
	@CsvCustomBindByName(column = "TARIFF_TYPE", required = false, converter = TariffTypeEnumConverter.class)
	@Nullable
	@Column(name = "tariff_type")
	@Schema(description = "The Tariff Type of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Tariff Type here] end
	private TariffTypeEnum tariffType;

	// % protected region % [Modify attribute annotation for Classification here] off begin
	@CsvBindByName(column = "CLASSIFICATION", required = false)
	@Nullable
	@Column(name = "classification")
	@Schema(description = "The Classification of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Classification here] end
	private String classification;

	// % protected region % [Modify attribute annotation for Multiplier here] off begin
	@CsvBindByName(column = "MULTIPLIER", required = false)
	@Nullable
	@Column(name = "multiplier")
	@Schema(description = "The Multiplier of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Multiplier here] end
	private Double multiplier;

	// % protected region % [Modify attribute annotation for Rounding here] off begin
	@CsvBindByName(column = "ROUNDING", required = false)
	@Nullable
	@Column(name = "rounding")
	@Schema(description = "The Rounding of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Rounding here] end
	private Integer rounding;

	// % protected region % [Modify attribute annotation for Rounding method here] off begin
	@CsvCustomBindByName(column = "ROUNDING_METHOD", required = false, converter = RoundingMethodEnumConverter.class)
	@Nullable
	@Column(name = "rounding_method")
	@Schema(description = "The Rounding method of this entity.")
	@ToString.Include
	@Enumerated
	// % protected region % [Modify attribute annotation for Rounding method here] end
	private RoundingMethodEnum roundingMethod;

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

	// % protected region % [Update the annotation for Base Schema here] off begin
	@Schema(description = "The Base Schema entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Base Schema here] end
	private TariffSchemaEntity baseSchema;

	// % protected region % [Update the annotation for baseSchemaId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BASE_SCHEMA_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for baseSchemaId here] end
	private UUID baseSchemaId;

	// % protected region % [Update the annotation for Tariff Schema here] off begin
	@Schema(description = "The Tariff Schema entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Schema here] end
	private TariffSchemaEntity tariffSchema;

	// % protected region % [Update the annotation for tariffSchemaId here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_SCHEMA_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for tariffSchemaId here] end
	private UUID tariffSchemaId;

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
	 * Similar to {@link this#setBaseSchema(TariffSchemaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffSchemaEntity to be set to this entity
	 */
	public void setBaseSchema(@NotNull TariffSchemaEntity entity) {
		setBaseSchema(entity, true);
	}

	/**
	 * Set or update the baseSchema in this entity with single TariffSchemaEntity.
	 *
	 * @param entity the given TariffSchemaEntity to be set or updated to baseSchema
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBaseSchema(@NotNull TariffSchemaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBaseSchema here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBaseSchema here] end

		if (sameAsFormer(this.baseSchema, entity)) {
			return;
		}

		if (this.baseSchema != null) {
			this.baseSchema.removeBaseScheme(this, false);
		}
		this.baseSchema = entity;
		if (reverseAdd) {
			this.baseSchema.addBaseScheme(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBaseSchema incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBaseSchema incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBaseSchema(boolean)} but default to true.
	 */
	public void unsetBaseSchema() {
		this.unsetBaseSchema(true);
	}

	/**
	 * Remove Base Schema in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBaseSchema(boolean reverse) {
		if (reverse && this.baseSchema != null) {
			this.baseSchema.removeBaseScheme(this, false);
		}
		this.baseSchema = null;
	}
	/**
	 * Similar to {@link this#setTariffSchema(TariffSchemaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffSchemaEntity to be set to this entity
	 */
	public void setTariffSchema(@NotNull TariffSchemaEntity entity) {
		setTariffSchema(entity, true);
	}

	/**
	 * Set or update the tariffSchema in this entity with single TariffSchemaEntity.
	 *
	 * @param entity the given TariffSchemaEntity to be set or updated to tariffSchema
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTariffSchema(@NotNull TariffSchemaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTariffSchema here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTariffSchema here] end

		if (sameAsFormer(this.tariffSchema, entity)) {
			return;
		}

		if (this.tariffSchema != null) {
			this.tariffSchema.removeTariffScheme(this, false);
		}
		this.tariffSchema = entity;
		if (reverseAdd) {
			this.tariffSchema.addTariffScheme(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTariffSchema incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTariffSchema incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTariffSchema(boolean)} but default to true.
	 */
	public void unsetTariffSchema() {
		this.unsetTariffSchema(true);
	}

	/**
	 * Remove Tariff Schema in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTariffSchema(boolean reverse) {
		if (reverse && this.tariffSchema != null) {
			this.tariffSchema.removeTariffScheme(this, false);
		}
		this.tariffSchema = null;
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
		return "TARIFF_TYPE,CLASSIFICATION,MULTIPLIER,ROUNDING,ROUNDING_METHOD,BASE_SCHEMA_ID,TARIFF_SCHEMA_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<TariffSchemaEntity> baseSchemaRelation = Optional.ofNullable(this.baseSchema);
		baseSchemaRelation.ifPresent(entity -> this.baseSchemaId = entity.getId());

		Optional<TariffSchemaEntity> tariffSchemaRelation = Optional.ofNullable(this.tariffSchema);
		tariffSchemaRelation.ifPresent(entity -> this.tariffSchemaId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object tariffFormula) {
		if (this == tariffFormula) {
			return true;
		}
		if (tariffFormula == null || this.getClass() != tariffFormula.getClass()) {
			return false;
		}
		if (!super.equals(tariffFormula)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TariffFormulaEntity that = (TariffFormulaEntity) tariffFormula;
		return
			Objects.equals(this.tariffType, that.tariffType) &&
			Objects.equals(this.classification, that.classification) &&
			Objects.equals(this.multiplier, that.multiplier) &&
			Objects.equals(this.rounding, that.rounding) &&
			Objects.equals(this.roundingMethod, that.roundingMethod) &&
			Objects.equals(this.baseSchemaId, that.baseSchemaId) &&
			Objects.equals(this.tariffSchemaId, that.tariffSchemaId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
