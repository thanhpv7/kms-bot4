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

import kmsweb.entities.enums.*;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class TariffDefinitionEntity extends AbstractEntity {

	public TariffDefinitionEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var TariffDefinitionOtherComponentsOneMany = new EntityReference();
			TariffDefinitionOtherComponentsOneMany.entityName = "TariffDefinitionOtherComponent";
			TariffDefinitionOtherComponentsOneMany.oppositeName = "PriceDefinition";
			TariffDefinitionOtherComponentsOneMany.name = "TariffDefinitionOtherComponents";
			TariffDefinitionOtherComponentsOneMany.optional = true;
			TariffDefinitionOtherComponentsOneMany.type = "One";
			TariffDefinitionOtherComponentsOneMany.oppositeType = "Many";

		References.add(TariffDefinitionOtherComponentsOneMany);

		var PriceSchemaOneMany = new EntityReference();
			PriceSchemaOneMany.entityName = "TariffSchema";
			PriceSchemaOneMany.oppositeName = "PriceSchema";
			PriceSchemaOneMany.name = "TariffDefinitions";
			PriceSchemaOneMany.optional = true;
			PriceSchemaOneMany.type = "One";
			PriceSchemaOneMany.oppositeType = "Many";

		References.add(PriceSchemaOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Tariff Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Type here] end
	private TariffTypeEnum tariffType;

	// % protected region % [Modify attribute annotation for Tariff Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for Tariff Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Price here] end
	private Double tariffPrice;

	// % protected region % [Modify attribute annotation for Hospital Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Price here] end
	private Double hospitalPrice;

	// % protected region % [Modify attribute annotation for Other Component Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Other Component Price here] end
	private Double otherComponentPrice;

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

	private Set<TariffDefinitionOtherComponentEntity> tariffDefinitionOtherComponents = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private TariffSchemaEntity priceSchema;

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
	 * Similar to {@link this#addTariffDefinitionOtherComponents(TariffDefinitionOtherComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity to be added to this entity
	 */
	public void addTariffDefinitionOtherComponents(@NonNull TariffDefinitionOtherComponentEntity entity) {
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
	public void addTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities) {
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
	public void removeTariffDefinitionOtherComponents(@NonNull TariffDefinitionOtherComponentEntity entity) {
		this.removeTariffDefinitionOtherComponents(entity, true);
	}

	/**
	 * Remove the given TariffDefinitionOtherComponentEntity from this entity.
	 *
	 * @param entity the given TariffDefinitionOtherComponentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffDefinitionOtherComponents(@NonNull TariffDefinitionOtherComponentEntity entity, boolean reverse) {
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
	public void removeTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities) {
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
	public void setTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities) {
		setTariffDefinitionOtherComponents(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Definition Other Components with the given ones.
	 *
	 * @param entities the given collection of TariffDefinitionOtherComponentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffDefinitionOtherComponents(@NonNull Collection<TariffDefinitionOtherComponentEntity> entities, boolean reverseAdd) {

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
	public void setPriceSchema(@NonNull TariffSchemaEntity entity) {
		setPriceSchema(entity, true);
	}

	/**
	 * Set or update the priceSchema in this entity with single TariffSchemaEntity.
	 *
	 * @param entity the given TariffSchemaEntity to be set or updated to priceSchema
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPriceSchema(@NonNull TariffSchemaEntity entity, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
