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
public class ExaminationGroupEntity extends AbstractEntity {

	public ExaminationGroupEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ServiceOneMany = new EntityReference();
			ServiceOneMany.entityName = "Service";
			ServiceOneMany.oppositeName = "Service";
			ServiceOneMany.name = "ExaminationGroups";
			ServiceOneMany.optional = true;
			ServiceOneMany.type = "One";
			ServiceOneMany.oppositeType = "Many";

		References.add(ServiceOneMany);

		var ExaminationItemsOneMany = new EntityReference();
			ExaminationItemsOneMany.entityName = "ExaminationItem";
			ExaminationItemsOneMany.oppositeName = "ExaminationGroup";
			ExaminationItemsOneMany.name = "ExaminationItems";
			ExaminationItemsOneMany.optional = true;
			ExaminationItemsOneMany.type = "One";
			ExaminationItemsOneMany.oppositeType = "Many";

		References.add(ExaminationItemsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Diagnostic Group Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diagnostic Group Code here] end
	private String diagnosticGroupCode;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

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

	private Set<ExaminationItemEntity> examinationItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private ServiceEntity service;

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
	 * Similar to {@link this#addExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be added to this entity
	 */
	public void addExaminationItems(@NonNull ExaminationItemEntity entity) {
		addExaminationItems(entity, true);
	}

	/**
	 * Add a new ExaminationItemEntity to examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addExaminationItems(@NonNull ExaminationItemEntity entity, boolean reverseAdd) {
		if (!this.examinationItems.contains(entity)) {
			examinationItems.add(entity);
			if (reverseAdd) {
				entity.setExaminationGroup(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added to this entity
	 */
	public void addExaminationItems(@NonNull Collection<ExaminationItemEntity> entities) {
		addExaminationItems(entities, true);
	}

	/**
	 * Add a new collection of ExaminationItemEntity to Examination Items in this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addExaminationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be set to this entity
	 */
	public void removeExaminationItems(@NonNull ExaminationItemEntity entity) {
		this.removeExaminationItems(entity, true);
	}

	/**
	 * Remove the given ExaminationItemEntity from this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItems(@NonNull ExaminationItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetExaminationGroup(false);
		}
		this.examinationItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeExaminationItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed to this entity
	 */
	public void removeExaminationItems(@NonNull Collection<ExaminationItemEntity> entities) {
		this.removeExaminationItems(entities, true);
	}

	/**
	 * Remove the given collection of ExaminationItemEntity from  to this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeExaminationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be set to this entity
	 */
	public void setExaminationItems(@NonNull Collection<ExaminationItemEntity> entities) {
		setExaminationItems(entities, true);
	}

	/**
	 * Replace the current entities in Examination Items with the given ones.
	 *
	 * @param entities the given collection of ExaminationItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {

		this.unsetExaminationItems();
		this.examinationItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.setExaminationGroup(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetExaminationItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetExaminationItems() {
		this.unsetExaminationItems(true);
	}

	/**
	 * Remove all the entities in Examination Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetExaminationItems(boolean doReverse) {
		if (doReverse) {
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.unsetExaminationGroup(false));
		}
		this.examinationItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setService(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to this entity
	 */
	public void setService(@NonNull ServiceEntity entity) {
		setService(entity, true);
	}

	/**
	 * Set or update the service in this entity with single ServiceEntity.
	 *
	 * @param entity the given ServiceEntity to be set or updated to service
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setService(@NonNull ServiceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setService here] off begin
		// % protected region % [Add any additional logic here before the main logic for setService here] end

		if (sameAsFormer(this.service, entity)) {
			return;
		}

		if (this.service != null) {
			this.service.removeExaminationGroups(this, false);
		}
		this.service = entity;
		if (reverseAdd) {
			this.service.addExaminationGroups(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setService incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetService(boolean)} but default to true.
	 */
	public void unsetService() {
		this.unsetService(true);
	}

	/**
	 * Remove Service in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetService(boolean reverse) {
		if (reverse && this.service != null) {
			this.service.removeExaminationGroups(this, false);
		}
		this.service = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
