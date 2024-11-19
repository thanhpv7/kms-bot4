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
public class TariffDefinitionOtherComponentEntity extends AbstractEntity {

	public TariffDefinitionOtherComponentEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PriceComponentOneMany = new EntityReference();
			PriceComponentOneMany.entityName = "PriceComponent";
			PriceComponentOneMany.oppositeName = "PriceComponent";
			PriceComponentOneMany.name = "TariffDefinitionOtherComponents";
			PriceComponentOneMany.optional = true;
			PriceComponentOneMany.type = "One";
			PriceComponentOneMany.oppositeType = "Many";

		References.add(PriceComponentOneMany);

		var PriceDefinitionOneMany = new EntityReference();
			PriceDefinitionOneMany.entityName = "TariffDefinition";
			PriceDefinitionOneMany.oppositeName = "PriceDefinition";
			PriceDefinitionOneMany.name = "TariffDefinitionOtherComponents";
			PriceDefinitionOneMany.optional = true;
			PriceDefinitionOneMany.type = "One";
			PriceDefinitionOneMany.oppositeType = "Many";

		References.add(PriceDefinitionOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

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

	private PriceComponentEntity priceComponent;

	private TariffDefinitionEntity priceDefinition;

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
	 * Similar to {@link this#setPriceComponent(PriceComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PriceComponentEntity to be set to this entity
	 */
	public void setPriceComponent(@NonNull PriceComponentEntity entity) {
		setPriceComponent(entity, true);
	}

	/**
	 * Set or update the priceComponent in this entity with single PriceComponentEntity.
	 *
	 * @param entity the given PriceComponentEntity to be set or updated to priceComponent
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPriceComponent(@NonNull PriceComponentEntity entity, boolean reverseAdd) {
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
	public void setPriceDefinition(@NonNull TariffDefinitionEntity entity) {
		setPriceDefinition(entity, true);
	}

	/**
	 * Set or update the priceDefinition in this entity with single TariffDefinitionEntity.
	 *
	 * @param entity the given TariffDefinitionEntity to be set or updated to priceDefinition
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPriceDefinition(@NonNull TariffDefinitionEntity entity, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
