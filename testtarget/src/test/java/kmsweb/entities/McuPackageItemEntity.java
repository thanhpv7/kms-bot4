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
public class McuPackageItemEntity extends AbstractEntity {

	public McuPackageItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ExaminationItemsManyMany = new EntityReference();
			ExaminationItemsManyMany.entityName = "ExaminationItem";
			ExaminationItemsManyMany.oppositeName = "ExaminationItems";
			ExaminationItemsManyMany.name = "ExaminationItemOfMCUItem";
			ExaminationItemsManyMany.optional = true;
			ExaminationItemsManyMany.type = "Many";
			ExaminationItemsManyMany.oppositeType = "Many";

		References.add(ExaminationItemsManyMany);

		var McuPackageOneMany = new EntityReference();
			McuPackageOneMany.entityName = "McuPackage";
			McuPackageOneMany.oppositeName = "McuPackage";
			McuPackageOneMany.name = "McuPackageItems";
			McuPackageOneMany.optional = true;
			McuPackageOneMany.type = "One";
			McuPackageOneMany.oppositeType = "Many";

		References.add(McuPackageOneMany);

		var ServiceOneMany = new EntityReference();
			ServiceOneMany.entityName = "Service";
			ServiceOneMany.oppositeName = "Service";
			ServiceOneMany.name = "McuPackageItems";
			ServiceOneMany.optional = true;
			ServiceOneMany.type = "One";
			ServiceOneMany.oppositeType = "Many";

		References.add(ServiceOneMany);

		var StaffOneMany = new EntityReference();
			StaffOneMany.entityName = "Staff";
			StaffOneMany.oppositeName = "Staff";
			StaffOneMany.name = "McuPackageItems";
			StaffOneMany.optional = true;
			StaffOneMany.type = "One";
			StaffOneMany.oppositeType = "Many";

		References.add(StaffOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Item Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Item Code here] end
	private String itemCode;

	// % protected region % [Modify attribute annotation for Duration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Duration here] end
	private Integer duration;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private McuPackageEntity mcuPackage;

	private ServiceEntity service;

	private StaffEntity staff;

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

	private Set<ExaminationItemEntity> examinationItems = new HashSet<>();

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
	 * Similar to {@link this#addExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be added to examinationItems
	 */
	public void addExaminationItems(@NonNull ExaminationItemEntity entity) {
		this.addExaminationItems(entity, true);
	}

	/**
	 * Add a new ExaminationItemEntity to examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be added to examinationItems
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addExaminationItems(@NonNull ExaminationItemEntity entity, boolean reverseAdd) {
		if (!this.examinationItems.contains(entity)) {
			this.examinationItems.add(entity);
			if (reverseAdd) {
				entity.addExaminationItemOfMCUItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added into examinationItems
	 */
	public void addExaminationItems(@NonNull Collection<ExaminationItemEntity> entities) {
		this.addExaminationItems(entities, true);
	}

	/**
	 * Add new collection of ExaminationItemEntity to examinationItems in this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be added into examinationItems in this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.addExaminationItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeExaminationItems(ExaminationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ExaminationItemEntity to be set to examinationItems in this entity
	 */
	public void removeExaminationItems(@NonNull ExaminationItemEntity entity) {
		this.removeExaminationItems(entity, true);
	}

	/**
	 * Remove the given ExaminationItemEntity from examinationItems in this entity.
	 *
	 * @param entity the given ExaminationItemEntity to be removed from examinationItems
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeExaminationItems(@NonNull ExaminationItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeExaminationItemOfMCUItem(this, false);
		}
		this.examinationItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed from examinationItems in this entity
	 */
	public void removeExaminationItems(@NonNull Collection<ExaminationItemEntity> entities) {
		this.removeExaminationItems(entities, true);
	}

	/**
	 * Remove the given collection of ExaminationItemEntity from examinationItems in this entity.
	 *
	 * @param entities the given collection of ExaminationItemEntity to be removed from examinationItems
	 * @param reverseRemove whether this entity should be removed to the given entities
	 */
	public void removeExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseRemove) {
		entities.forEach(entity -> this.removeExaminationItems(entity, reverseRemove));
	}

	/**
	 * Similar to {@link this#setExaminationItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ExaminationItemEntity to replace the old ones in examinationItems
	 */
	public void setExaminationItems(@NonNull Collection<ExaminationItemEntity> entities) {
		this.setExaminationItems(entities, true);
	}

	/**
	 * Replace the current collection of ExaminationItemEntity in examinationItems with the given ones.
	 *
	 * @param entities the given collection of ExaminationItemEntity to replace the old ones in examinationItems
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setExaminationItems(@NonNull Collection<ExaminationItemEntity> entities, boolean reverseAdd) {
		unsetExaminationItems();
		this.examinationItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.addExaminationItemOfMCUItem(this, false));
		}
	}

	/**
	 * Remove all entities in Examination Items from this entity.
	 */
	public void unsetExaminationItems() {
		this.examinationItems.forEach(entity -> entity.removeExaminationItemOfMCUItem(this, false));
		this.examinationItems.clear();
	}
	/**
	 * Similar to {@link this#setMcuPackage(McuPackageEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given McuPackageEntity to be set to this entity
	 */
	public void setMcuPackage(@NonNull McuPackageEntity entity) {
		setMcuPackage(entity, true);
	}

	/**
	 * Set or update the mcuPackage in this entity with single McuPackageEntity.
	 *
	 * @param entity the given McuPackageEntity to be set or updated to mcuPackage
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMcuPackage(@NonNull McuPackageEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMcuPackage here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMcuPackage here] end

		if (sameAsFormer(this.mcuPackage, entity)) {
			return;
		}

		if (this.mcuPackage != null) {
			this.mcuPackage.removeMcuPackageItems(this, false);
		}
		this.mcuPackage = entity;
		if (reverseAdd) {
			this.mcuPackage.addMcuPackageItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMcuPackage incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMcuPackage incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMcuPackage(boolean)} but default to true.
	 */
	public void unsetMcuPackage() {
		this.unsetMcuPackage(true);
	}

	/**
	 * Remove MCU Package in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMcuPackage(boolean reverse) {
		if (reverse && this.mcuPackage != null) {
			this.mcuPackage.removeMcuPackageItems(this, false);
		}
		this.mcuPackage = null;
	}
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
			this.service.removeMcuPackageItems(this, false);
		}
		this.service = entity;
		if (reverseAdd) {
			this.service.addMcuPackageItems(this, false);
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
			this.service.removeMcuPackageItems(this, false);
		}
		this.service = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NonNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeMcuPackageItems(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addMcuPackageItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeMcuPackageItems(this, false);
		}
		this.staff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
