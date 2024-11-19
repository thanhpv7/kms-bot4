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

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class McuPackageEntity extends AbstractEntity {

	public McuPackageEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var McuPackageItemsOneMany = new EntityReference();
			McuPackageItemsOneMany.entityName = "McuPackageItem";
			McuPackageItemsOneMany.oppositeName = "McuPackage";
			McuPackageItemsOneMany.name = "McuPackageItems";
			McuPackageItemsOneMany.optional = true;
			McuPackageItemsOneMany.type = "One";
			McuPackageItemsOneMany.oppositeType = "Many";

		References.add(McuPackageItemsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for MCU Package Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for MCU Package Code here] end
	private String mcuPackageCode;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	// % protected region % [Modify attribute annotation for Package Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Package Type here] end
	private String packageType;

	// % protected region % [Modify attribute annotation for Sequence here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sequence here] end
	private Integer sequence;

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

	private Set<McuPackageItemEntity> mcuPackageItems = new HashSet<>();

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

/**
	 * Similar to {@link this#addMcuPackageItems(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be added to this entity
	 */
	public void addMcuPackageItems(@NonNull McuPackageItemEntity entity) {
		addMcuPackageItems(entity, true);
	}

	/**
	 * Add a new McuPackageItemEntity to mcuPackageItems in this entity.
	 *
	 * @param entity the given McuPackageItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addMcuPackageItems(@NonNull McuPackageItemEntity entity, boolean reverseAdd) {
		if (!this.mcuPackageItems.contains(entity)) {
			mcuPackageItems.add(entity);
			if (reverseAdd) {
				entity.setMcuPackage(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be added to this entity
	 */
	public void addMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities) {
		addMcuPackageItems(entities, true);
	}

	/**
	 * Add a new collection of McuPackageItemEntity to MCU Package Items in this entity.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addMcuPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeMcuPackageItems(McuPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageItemEntity to be set to this entity
	 */
	public void removeMcuPackageItems(@NonNull McuPackageItemEntity entity) {
		this.removeMcuPackageItems(entity, true);
	}

	/**
	 * Remove the given McuPackageItemEntity from this entity.
	 *
	 * @param entity the given McuPackageItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeMcuPackageItems(@NonNull McuPackageItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetMcuPackage(false);
		}
		this.mcuPackageItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be removed to this entity
	 */
	public void removeMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities) {
		this.removeMcuPackageItems(entities, true);
	}

	/**
	 * Remove the given collection of McuPackageItemEntity from  to this entity.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeMcuPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setMcuPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of McuPackageItemEntity to be set to this entity
	 */
	public void setMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities) {
		setMcuPackageItems(entities, true);
	}

	/**
	 * Replace the current entities in MCU Package Items with the given ones.
	 *
	 * @param entities the given collection of McuPackageItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setMcuPackageItems(@NonNull Collection<McuPackageItemEntity> entities, boolean reverseAdd) {

		this.unsetMcuPackageItems();
		this.mcuPackageItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.setMcuPackage(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetMcuPackageItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetMcuPackageItems() {
		this.unsetMcuPackageItems(true);
	}

	/**
	 * Remove all the entities in MCU Package Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetMcuPackageItems(boolean doReverse) {
		if (doReverse) {
			this.mcuPackageItems.forEach(mcuPackageItemsEntity -> mcuPackageItemsEntity.unsetMcuPackage(false));
		}
		this.mcuPackageItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
