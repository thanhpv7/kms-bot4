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
import kmsweb.dtos.TariffDefinitionOtherComponentEntityDto;
import kmsweb.entities.listeners.TariffDefinitionOtherComponentEntityListener;
import kmsweb.serializers.TariffDefinitionOtherComponentSerializer;
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
@EntityListeners({TariffDefinitionOtherComponentEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TariffDefinitionOtherComponentSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TariffDefinitionOtherComponentEntity extends AbstractEntity {

	/**
	 * Takes a TariffDefinitionOtherComponentEntityDto and converts it into a TariffDefinitionOtherComponentEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param tariffDefinitionOtherComponentEntityDto
	 */
	public TariffDefinitionOtherComponentEntity(TariffDefinitionOtherComponentEntityDto tariffDefinitionOtherComponentEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (tariffDefinitionOtherComponentEntityDto.getId() != null) {
			this.setId(tariffDefinitionOtherComponentEntityDto.getId());
		}

		if (tariffDefinitionOtherComponentEntityDto.getPrice() != null) {
			this.setPrice(tariffDefinitionOtherComponentEntityDto.getPrice());
		}

		if (tariffDefinitionOtherComponentEntityDto.getPriceComponent() != null) {
			this.setPriceComponent(tariffDefinitionOtherComponentEntityDto.getPriceComponent());
		}

		if (tariffDefinitionOtherComponentEntityDto.getPriceDefinition() != null) {
			this.setPriceDefinition(tariffDefinitionOtherComponentEntityDto.getPriceDefinition());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Price here] off begin
	@CsvBindByName(column = "PRICE", required = false)
	@Nullable
	@Column(name = "price")
	@Schema(description = "The Price of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

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

	// % protected region % [Update the annotation for Price Component here] off begin
	@Schema(description = "The Price Component entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Price Component here] end
	private PriceComponentEntity priceComponent;

	// % protected region % [Update the annotation for priceComponentId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRICE_COMPONENT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for priceComponentId here] end
	private UUID priceComponentId;

	// % protected region % [Update the annotation for Price Definition here] off begin
	@Schema(description = "The Price Definition entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Price Definition here] end
	private TariffDefinitionEntity priceDefinition;

	// % protected region % [Update the annotation for priceDefinitionId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRICE_DEFINITION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for priceDefinitionId here] end
	private UUID priceDefinitionId;

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
	 * Similar to {@link this#setPriceComponent(PriceComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PriceComponentEntity to be set to this entity
	 */
	public void setPriceComponent(@NotNull PriceComponentEntity entity) {
		setPriceComponent(entity, true);
	}

	/**
	 * Set or update the priceComponent in this entity with single PriceComponentEntity.
	 *
	 * @param entity the given PriceComponentEntity to be set or updated to priceComponent
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPriceComponent(@NotNull PriceComponentEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPriceComponent here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPriceComponent here] end

		if (sameAsFormer(this.priceComponent, entity)) {
			return;
		}

		if (this.priceComponent != null) {
			this.priceComponent.removeTariffDefinitionOtherComponents(this, false);
		}
		this.priceComponent = entity;
		if (reverseAdd) {
			this.priceComponent.addTariffDefinitionOtherComponents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPriceComponent incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPriceComponent incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPriceComponent(boolean)} but default to true.
	 */
	public void unsetPriceComponent() {
		this.unsetPriceComponent(true);
	}

	/**
	 * Remove Price Component in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPriceComponent(boolean reverse) {
		if (reverse && this.priceComponent != null) {
			this.priceComponent.removeTariffDefinitionOtherComponents(this, false);
		}
		this.priceComponent = null;
	}
	/**
	 * Similar to {@link this#setPriceDefinition(TariffDefinitionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffDefinitionEntity to be set to this entity
	 */
	public void setPriceDefinition(@NotNull TariffDefinitionEntity entity) {
		setPriceDefinition(entity, true);
	}

	/**
	 * Set or update the priceDefinition in this entity with single TariffDefinitionEntity.
	 *
	 * @param entity the given TariffDefinitionEntity to be set or updated to priceDefinition
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPriceDefinition(@NotNull TariffDefinitionEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPriceDefinition here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPriceDefinition here] end

		if (sameAsFormer(this.priceDefinition, entity)) {
			return;
		}

		if (this.priceDefinition != null) {
			this.priceDefinition.removeTariffDefinitionOtherComponents(this, false);
		}
		this.priceDefinition = entity;
		if (reverseAdd) {
			this.priceDefinition.addTariffDefinitionOtherComponents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPriceDefinition incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPriceDefinition incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPriceDefinition(boolean)} but default to true.
	 */
	public void unsetPriceDefinition() {
		this.unsetPriceDefinition(true);
	}

	/**
	 * Remove Price Definition in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPriceDefinition(boolean reverse) {
		if (reverse && this.priceDefinition != null) {
			this.priceDefinition.removeTariffDefinitionOtherComponents(this, false);
		}
		this.priceDefinition = null;
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
		return "PRICE,PRICE_COMPONENT_ID,PRICE_DEFINITION_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PriceComponentEntity> priceComponentRelation = Optional.ofNullable(this.priceComponent);
		priceComponentRelation.ifPresent(entity -> this.priceComponentId = entity.getId());

		Optional<TariffDefinitionEntity> priceDefinitionRelation = Optional.ofNullable(this.priceDefinition);
		priceDefinitionRelation.ifPresent(entity -> this.priceDefinitionId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object tariffDefinitionOtherComponent) {
		if (this == tariffDefinitionOtherComponent) {
			return true;
		}
		if (tariffDefinitionOtherComponent == null || this.getClass() != tariffDefinitionOtherComponent.getClass()) {
			return false;
		}
		if (!super.equals(tariffDefinitionOtherComponent)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TariffDefinitionOtherComponentEntity that = (TariffDefinitionOtherComponentEntity) tariffDefinitionOtherComponent;
		return
			Objects.equals(this.price, that.price) &&
			Objects.equals(this.priceComponentId, that.priceComponentId) &&
			Objects.equals(this.priceDefinitionId, that.priceDefinitionId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
