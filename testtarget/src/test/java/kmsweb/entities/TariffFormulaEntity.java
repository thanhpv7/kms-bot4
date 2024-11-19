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


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class TariffFormulaEntity extends AbstractEntity {

	public TariffFormulaEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BaseSchemaOneMany = new EntityReference();
			BaseSchemaOneMany.entityName = "TariffSchema";
			BaseSchemaOneMany.oppositeName = "BaseSchema";
			BaseSchemaOneMany.name = "BaseScheme";
			BaseSchemaOneMany.optional = true;
			BaseSchemaOneMany.type = "One";
			BaseSchemaOneMany.oppositeType = "Many";

		References.add(BaseSchemaOneMany);

		var TariffSchemaOneMany = new EntityReference();
			TariffSchemaOneMany.entityName = "TariffSchema";
			TariffSchemaOneMany.oppositeName = "TariffSchema";
			TariffSchemaOneMany.name = "TariffScheme";
			TariffSchemaOneMany.optional = true;
			TariffSchemaOneMany.type = "One";
			TariffSchemaOneMany.oppositeType = "Many";

		References.add(TariffSchemaOneMany);
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

	// % protected region % [Modify attribute annotation for Classification here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Classification here] end
	private String classification;

	// % protected region % [Modify attribute annotation for Multiplier here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Multiplier here] end
	private Double multiplier;

	// % protected region % [Modify attribute annotation for Rounding here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Rounding here] end
	private Integer rounding;

	// % protected region % [Modify attribute annotation for Rounding method here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Rounding method here] end
	private RoundingMethodEnum roundingMethod;

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

	private TariffSchemaEntity baseSchema;

	private TariffSchemaEntity tariffSchema;

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
	 * Similar to {@link this#setBaseSchema(TariffSchemaEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffSchemaEntity to be set to this entity
	 */
	public void setBaseSchema(@NonNull TariffSchemaEntity entity) {
		setBaseSchema(entity, true);
	}

	/**
	 * Set or update the baseSchema in this entity with single TariffSchemaEntity.
	 *
	 * @param entity the given TariffSchemaEntity to be set or updated to baseSchema
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBaseSchema(@NonNull TariffSchemaEntity entity, boolean reverseAdd) {
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
	public void setTariffSchema(@NonNull TariffSchemaEntity entity) {
		setTariffSchema(entity, true);
	}

	/**
	 * Set or update the tariffSchema in this entity with single TariffSchemaEntity.
	 *
	 * @param entity the given TariffSchemaEntity to be set or updated to tariffSchema
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTariffSchema(@NonNull TariffSchemaEntity entity, boolean reverseAdd) {
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

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
