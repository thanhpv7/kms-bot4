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
import kmsweb.dtos.TariffDefinitionEntityDto;
import kmsweb.entities.enums.*;
import kmsweb.services.utils.converters.enums.*;
import kmsweb.entities.listeners.TariffDefinitionEntityListener;
import kmsweb.serializers.TariffDefinitionSerializer;
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

import java.util.*;
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
@EntityListeners({TariffDefinitionEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TariffDefinitionSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TariffDefinitionEntity extends AbstractEntity {

	/**
	 * Takes a TariffDefinitionEntityDto and converts it into a TariffDefinitionEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param tariffDefinitionEntityDto
	 */
	public TariffDefinitionEntity(TariffDefinitionEntityDto tariffDefinitionEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (tariffDefinitionEntityDto.getId() != null) {
			this.setId(tariffDefinitionEntityDto.getId());
		}

		if (tariffDefinitionEntityDto.getTariffType() != null) {
			this.setTariffType(tariffDefinitionEntityDto.getTariffType());
		}

		if (tariffDefinitionEntityDto.getTariffCode() != null) {
			this.setTariffCode(tariffDefinitionEntityDto.getTariffCode());
		}

		if (tariffDefinitionEntityDto.getTariffPrice() != null) {
			this.setTariffPrice(tariffDefinitionEntityDto.getTariffPrice());
		}

		if (tariffDefinitionEntityDto.getHospitalPrice() != null) {
			this.setHospitalPrice(tariffDefinitionEntityDto.getHospitalPrice());
		}

		if (tariffDefinitionEntityDto.getOtherComponentPrice() != null) {
			this.setOtherComponentPrice(tariffDefinitionEntityDto.getOtherComponentPrice());
		}

		if (tariffDefinitionEntityDto.getTariffDefinitionOtherComponents() != null) {
			this.setTariffDefinitionOtherComponents(tariffDefinitionEntityDto.getTariffDefinitionOtherComponents());
		}

		if (tariffDefinitionEntityDto.getPriceSchema() != null) {
			this.setPriceSchema(tariffDefinitionEntityDto.getPriceSchema());
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

	// % protected region % [Modify attribute annotation for Tariff Code here] off begin
	@CsvBindByName(column = "TARIFF_CODE", required = false)
	@Nullable
	@Column(name = "tariff_code")
	@Schema(description = "The Tariff Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for Tariff Price here] off begin
	@CsvBindByName(column = "TARIFF_PRICE", required = false)
	@Nullable
	@Column(name = "tariff_price")
	@Schema(description = "The Tariff Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Price here] end
	private Double tariffPrice;

	// % protected region % [Modify attribute annotation for Hospital Price here] off begin
	@CsvBindByName(column = "HOSPITAL_PRICE", required = false)
	@Nullable
	@Column(name = "hospital_price")
	@Schema(description = "The Hospital Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Price here] end
	private Double hospitalPrice;

	// % protected region % [Modify attribute annotation for Other Component Price here] off begin
	@CsvBindByName(column = "OTHER_COMPONENT_PRICE", required = false)
	@Nullable
	@Column(name = "other_component_price")
	@Schema(description = "The Other Component Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Other Component Price here] end
	private Double otherComponentPrice;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Tariff Definition Other Components here] off begin
	@Schema(description = "The Tariff Definition Other Component entities that are related to this entity.")
	@OneToMany(mappedBy = "priceDefinition", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Tariff Definition Other Components here] end
	private Set<TariffDefinitionOtherComponentEntity> tariffDefinitionOtherComponents = new HashSet<>();

	// % protected region % [Update the annotation for tariffDefinitionOtherComponentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TARIFF_DEFINITION_OTHER_COMPONENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for tariffDefinitionOtherComponentsIds here] end
	private Set<UUID> tariffDefinitionOtherComponentsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Price Schema here] off begin
	@Schema(description = "The Price Schema entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Price Schema here] end
	private TariffSchemaEntity priceSchema;

	// % protected region % [Update the annotation for priceSchemaId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRICE_SCHEMA_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for priceSchemaId here] end
	private UUID priceSchemaId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addTariffDefinitionOtherComponents(TariffDefinitionOtherComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity to be added to this entity
	 */
	public void addTariffDefinitionOtherComponents(@NotNull TariffDefinitionOtherComponentEntity entity) {
		addTariffDefinitionOtherComponents(entity, true);
	}

	/**
	 * Add a new TariffDefinitionOtherComponentEntity to tariffDefinitionOtherComponents in this entity.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTariffDefinitionOtherComponents(@NonNull TariffDefinitionOtherComponentEntity entity, boolean reverseAdd) {
		if (!this.tariffDefinitionOtherComponents.contains(entity)) {
			tariffDefinitionOtherComponents.add(entity);
			if (reverseAdd) {
				entity.setPriceDefinition(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTariffDefinitionOtherComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be added to this entity
	 */
	public void addTariffDefinitionOtherComponents(@NotNull Collection<TariffDefinitionOtherComponentEntity> entities) {
		addTariffDefinitionOtherComponents(entities, true);
	}

	/**
	 * Add a new collection of TariffDefinitionOtherComponentEntity to Tariff Definition Other Components in this entity.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTariffDefinitionOtherComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTariffDefinitionOtherComponents(TariffDefinitionOtherComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity to be set to this entity
	 */
	public void removeTariffDefinitionOtherComponents(@NotNull TariffDefinitionOtherComponentEntity entity) {
		this.removeTariffDefinitionOtherComponents(entity, true);
	}

	/**
	 * Remove the given TariffDefinitionOtherComponentEntity from this entity.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffDefinitionOtherComponents(@NotNull TariffDefinitionOtherComponentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPriceDefinition(false);
		}
		this.tariffDefinitionOtherComponents.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTariffDefinitionOtherComponents(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be removed to this entity
	 */
	public void removeTariffDefinitionOtherComponents(@NotNull Collection<TariffDefinitionOtherComponentEntity> entities) {
		this.removeTariffDefinitionOtherComponents(entities, true);
	}

	/**
	 * Remove the given collection of TariffDefinitionOtherComponentEntity from  to this entity.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTariffDefinitionOtherComponents(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTariffDefinitionOtherComponents(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to be set to this entity
	 */
	public void setTariffDefinitionOtherComponents(@NotNull Collection<TariffDefinitionOtherComponentEntity> entities) {
		setTariffDefinitionOtherComponents(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Definition Other Components with the given ones.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffDefinitionOtherComponents(@NotNull Collection<TariffDefinitionOtherComponentEntity> entities, boolean reverseAdd) {

		this.unsetTariffDefinitionOtherComponents();
		this.tariffDefinitionOtherComponents = new HashSet<>(entities);
		if (reverseAdd) {
			this.tariffDefinitionOtherComponents.forEach(tariffDefinitionOtherComponentsEntity -> tariffDefinitionOtherComponentsEntity.setPriceDefinition(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTariffDefinitionOtherComponents(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTariffDefinitionOtherComponents() {
		this.unsetTariffDefinitionOtherComponents(true);
	}

	/**
	 * Remove all the entities in Tariff Definition Other Components from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTariffDefinitionOtherComponents(boolean doReverse) {
		if (doReverse) {
			this.tariffDefinitionOtherComponents.forEach(tariffDefinitionOtherComponentsEntity -> tariffDefinitionOtherComponentsEntity.unsetPriceDefinition(false));
		}
		this.tariffDefinitionOtherComponents.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPriceSchema(TariffSchemaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffSchemaEntity to be set to this entity
	 */
	public void setPriceSchema(@NotNull TariffSchemaEntity entity) {
		setPriceSchema(entity, true);
	}

	/**
	 * Set or update the priceSchema in this entity with single TariffSchemaEntity.
	 *
	 * @param entity the given TariffSchemaEntity to be set or updated to priceSchema
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPriceSchema(@NotNull TariffSchemaEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPriceSchema here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPriceSchema here] end

		if (sameAsFormer(this.priceSchema, entity)) {
			return;
		}

		if (this.priceSchema != null) {
			this.priceSchema.removeTariffDefinitions(this, false);
		}
		this.priceSchema = entity;
		if (reverseAdd) {
			this.priceSchema.addTariffDefinitions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPriceSchema incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPriceSchema incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPriceSchema(boolean)} but default to true.
	 */
	public void unsetPriceSchema() {
		this.unsetPriceSchema(true);
	}

	/**
	 * Remove Price Schema in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPriceSchema(boolean reverse) {
		if (reverse && this.priceSchema != null) {
			this.priceSchema.removeTariffDefinitions(this, false);
		}
		this.priceSchema = null;
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
		return "TARIFF_TYPE,TARIFF_CODE,TARIFF_PRICE,HOSPITAL_PRICE,OTHER_COMPONENT_PRICE,PRICE_SCHEMA_ID,TARIFF_DEFINITION_OTHER_COMPONENTS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<TariffSchemaEntity> priceSchemaRelation = Optional.ofNullable(this.priceSchema);
		priceSchemaRelation.ifPresent(entity -> this.priceSchemaId = entity.getId());

		this.tariffDefinitionOtherComponentsIds = new HashSet<>();
		for (TariffDefinitionOtherComponentEntity tariffDefinitionOtherComponents: this.tariffDefinitionOtherComponents) {
			this.tariffDefinitionOtherComponentsIds.add(tariffDefinitionOtherComponents.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object tariffDefinition) {
		if (this == tariffDefinition) {
			return true;
		}
		if (tariffDefinition == null || this.getClass() != tariffDefinition.getClass()) {
			return false;
		}
		if (!super.equals(tariffDefinition)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TariffDefinitionEntity that = (TariffDefinitionEntity) tariffDefinition;
		return
			Objects.equals(this.tariffType, that.tariffType) &&
			Objects.equals(this.tariffCode, that.tariffCode) &&
			Objects.equals(this.tariffPrice, that.tariffPrice) &&
			Objects.equals(this.hospitalPrice, that.hospitalPrice) &&
			Objects.equals(this.otherComponentPrice, that.otherComponentPrice) &&
			Objects.equals(this.tariffDefinitionOtherComponentsIds, that.tariffDefinitionOtherComponentsIds) &&
			Objects.equals(this.priceSchemaId, that.priceSchemaId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
