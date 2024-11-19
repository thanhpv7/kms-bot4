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
public class TariffPackageItemEntity extends AbstractEntity {

	public TariffPackageItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var TariffPackageOneMany = new EntityReference();
			TariffPackageOneMany.entityName = "TariffPackage";
			TariffPackageOneMany.oppositeName = "TariffPackage";
			TariffPackageOneMany.name = "TariffPackageItems";
			TariffPackageOneMany.optional = true;
			TariffPackageOneMany.type = "One";
			TariffPackageOneMany.oppositeType = "Many";

		References.add(TariffPackageOneMany);
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

	// % protected region % [Modify attribute annotation for Tariff  Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff  Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for Tariff  Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff  Name here] end
	private String tariffName;

	// % protected region % [Modify attribute annotation for Quantity here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Quantity here] end
	private Double quantity;

	// % protected region % [Modify attribute annotation for Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Unit here] end
	private String unit;

	// % protected region % [Modify attribute annotation for Modifiable here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Modifiable here] end
	private Boolean modifiable;

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

	private TariffPackageEntity tariffPackage;

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
	 * Similar to {@link this#setTariffPackage(TariffPackageEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageEntity to be set to this entity
	 */
	public void setTariffPackage(@NonNull TariffPackageEntity entity) {
		setTariffPackage(entity, true);
	}

	/**
	 * Set or update the tariffPackage in this entity with single TariffPackageEntity.
	 *
	 * @param entity the given TariffPackageEntity to be set or updated to tariffPackage
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setTariffPackage(@NonNull TariffPackageEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setTariffPackage here] off begin
		// % protected region % [Add any additional logic here before the main logic for setTariffPackage here] end

		if (sameAsFormer(this.tariffPackage, entity)) {
			return;
		}

		if (this.tariffPackage != null) {
			this.tariffPackage.removeTariffPackageItems(this, false);
		}
		this.tariffPackage = entity;
		if (reverseAdd) {
			this.tariffPackage.addTariffPackageItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setTariffPackage incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setTariffPackage incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetTariffPackage(boolean)} but default to true.
	 */
	public void unsetTariffPackage() {
		this.unsetTariffPackage(true);
	}

	/**
	 * Remove Tariff Package in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetTariffPackage(boolean reverse) {
		if (reverse && this.tariffPackage != null) {
			this.tariffPackage.removeTariffPackageItems(this, false);
		}
		this.tariffPackage = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
