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
public class ServiceItemEntity extends AbstractEntity {

	public ServiceItemEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ExaminationItemsOneMany = new EntityReference();
			ExaminationItemsOneMany.entityName = "ExaminationItem";
			ExaminationItemsOneMany.oppositeName = "ServiceItem";
			ExaminationItemsOneMany.name = "ExaminationItems";
			ExaminationItemsOneMany.optional = true;
			ExaminationItemsOneMany.type = "One";
			ExaminationItemsOneMany.oppositeType = "Many";

		References.add(ExaminationItemsOneMany);

		var ServiceItemAssignmentsOneMany = new EntityReference();
			ServiceItemAssignmentsOneMany.entityName = "ServiceItemAssignment";
			ServiceItemAssignmentsOneMany.oppositeName = "ServiceItem";
			ServiceItemAssignmentsOneMany.name = "ServiceItemAssignments";
			ServiceItemAssignmentsOneMany.optional = true;
			ServiceItemAssignmentsOneMany.type = "One";
			ServiceItemAssignmentsOneMany.oppositeType = "Many";

		References.add(ServiceItemAssignmentsOneMany);

		var ServicesManyMany = new EntityReference();
			ServicesManyMany.entityName = "Service";
			ServicesManyMany.oppositeName = "Services";
			ServicesManyMany.name = "ServiceItems";
			ServicesManyMany.optional = true;
			ServicesManyMany.type = "Many";
			ServicesManyMany.oppositeType = "Many";

		References.add(ServicesManyMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Service Item Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Service Item Code here] end
	private String serviceItemCode;

	// % protected region % [Modify attribute annotation for Service Item Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Service Item Name here] end
	private String serviceItemName;

	// % protected region % [Modify attribute annotation for Classification here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Classification here] end
	private String classification;

	// % protected region % [Modify attribute annotation for Apply to all Service here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Apply to all Service here] end
	private Boolean applyToAllService;

	// % protected region % [Modify attribute annotation for Apply To here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Apply To here] end
	private ApplyToEnum applyTo;

	// % protected region % [Modify attribute annotation for COA COGS here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA COGS here] end
	private String coaCOGS;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for COA Inventory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA Inventory here] end
	private String coaInventory;

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

	private Set<ServiceItemAssignmentEntity> serviceItemAssignments = new HashSet<>();

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

	private Set<ServiceEntity> services = new HashSet<>();

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
				entity.setServiceItem(this, false);
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
			entity.unsetServiceItem(false);
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
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.setServiceItem(this, false));
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
			this.examinationItems.forEach(examinationItemsEntity -> examinationItemsEntity.unsetServiceItem(false));
		}
		this.examinationItems.clear();
	}

/**
	 * Similar to {@link this#addServiceItemAssignments(ServiceItemAssignmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceItemAssignmentEntity to be added to this entity
	 */
	public void addServiceItemAssignments(@NonNull ServiceItemAssignmentEntity entity) {
		addServiceItemAssignments(entity, true);
	}

	/**
	 * Add a new ServiceItemAssignmentEntity to serviceItemAssignments in this entity.
	 *
	 * @param entity the given ServiceItemAssignmentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addServiceItemAssignments(@NonNull ServiceItemAssignmentEntity entity, boolean reverseAdd) {
		if (!this.serviceItemAssignments.contains(entity)) {
			serviceItemAssignments.add(entity);
			if (reverseAdd) {
				entity.setServiceItem(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addServiceItemAssignments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be added to this entity
	 */
	public void addServiceItemAssignments(@NonNull Collection<ServiceItemAssignmentEntity> entities) {
		addServiceItemAssignments(entities, true);
	}

	/**
	 * Add a new collection of ServiceItemAssignmentEntity to Service Item Assignments in this entity.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addServiceItemAssignments(@NonNull Collection<ServiceItemAssignmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addServiceItemAssignments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeServiceItemAssignments(ServiceItemAssignmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceItemAssignmentEntity to be set to this entity
	 */
	public void removeServiceItemAssignments(@NonNull ServiceItemAssignmentEntity entity) {
		this.removeServiceItemAssignments(entity, true);
	}

	/**
	 * Remove the given ServiceItemAssignmentEntity from this entity.
	 *
	 * @param entity the given ServiceItemAssignmentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServiceItemAssignments(@NonNull ServiceItemAssignmentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetServiceItem(false);
		}
		this.serviceItemAssignments.remove(entity);
	}

	/**
	 * Similar to {@link this#removeServiceItemAssignments(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be removed to this entity
	 */
	public void removeServiceItemAssignments(@NonNull Collection<ServiceItemAssignmentEntity> entities) {
		this.removeServiceItemAssignments(entities, true);
	}

	/**
	 * Remove the given collection of ServiceItemAssignmentEntity from  to this entity.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeServiceItemAssignments(@NonNull Collection<ServiceItemAssignmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeServiceItemAssignments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setServiceItemAssignments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to be set to this entity
	 */
	public void setServiceItemAssignments(@NonNull Collection<ServiceItemAssignmentEntity> entities) {
		setServiceItemAssignments(entities, true);
	}

	/**
	 * Replace the current entities in Service Item Assignments with the given ones.
	 *
	 * @param entities the given collection of ServiceItemAssignmentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServiceItemAssignments(@NonNull Collection<ServiceItemAssignmentEntity> entities, boolean reverseAdd) {

		this.unsetServiceItemAssignments();
		this.serviceItemAssignments = new HashSet<>(entities);
		if (reverseAdd) {
			this.serviceItemAssignments.forEach(serviceItemAssignmentsEntity -> serviceItemAssignmentsEntity.setServiceItem(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetServiceItemAssignments(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetServiceItemAssignments() {
		this.unsetServiceItemAssignments(true);
	}

	/**
	 * Remove all the entities in Service Item Assignments from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetServiceItemAssignments(boolean doReverse) {
		if (doReverse) {
			this.serviceItemAssignments.forEach(serviceItemAssignmentsEntity -> serviceItemAssignmentsEntity.unsetServiceItem(false));
		}
		this.serviceItemAssignments.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#addServices(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be added to services
	 */
	public void addServices(@NonNull ServiceEntity entity) {
		this.addServices(entity, true);
	}

	/**
	 * Add a new ServiceEntity to services in this entity.
	 *
	 * @param entity the given ServiceEntity to be added to services
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addServices(@NonNull ServiceEntity entity, boolean reverseAdd) {
		if (!this.services.contains(entity)) {
			this.services.add(entity);
			if (reverseAdd) {
				entity.addServiceItems(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceEntity to be added into services
	 */
	public void addServices(@NonNull Collection<ServiceEntity> entities) {
		this.addServices(entities, true);
	}

	/**
	 * Add new collection of ServiceEntity to services in this entity.
	 *
	 * @param entities the given collection of ServiceEntity to be added into services in this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addServices(@NonNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.addServices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeServices(ServiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ServiceEntity to be set to services in this entity
	 */
	public void removeServices(@NonNull ServiceEntity entity) {
		this.removeServices(entity, true);
	}

	/**
	 * Remove the given ServiceEntity from services in this entity.
	 *
	 * @param entity the given ServiceEntity to be removed from services
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeServices(@NonNull ServiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.removeServiceItems(this, false);
		}
		this.services.remove(entity);
	}

	/**
	 * Similar to {@link this#removeServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceEntity to be removed from services in this entity
	 */
	public void removeServices(@NonNull Collection<ServiceEntity> entities) {
		this.removeServices(entities, true);
	}

	/**
	 * Remove the given collection of ServiceEntity from services in this entity.
	 *
	 * @param entities the given collection of ServiceEntity to be removed from services
	 * @param reverseRemove whether this entity should be removed to the given entities
	 */
	public void removeServices(@NonNull Collection<ServiceEntity> entities, boolean reverseRemove) {
		entities.forEach(entity -> this.removeServices(entity, reverseRemove));
	}

	/**
	 * Similar to {@link this#setServices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ServiceEntity to replace the old ones in services
	 */
	public void setServices(@NonNull Collection<ServiceEntity> entities) {
		this.setServices(entities, true);
	}

	/**
	 * Replace the current collection of ServiceEntity in services with the given ones.
	 *
	 * @param entities the given collection of ServiceEntity to replace the old ones in services
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setServices(@NonNull Collection<ServiceEntity> entities, boolean reverseAdd) {
		unsetServices();
		this.services = new HashSet<>(entities);
		if (reverseAdd) {
			this.services.forEach(servicesEntity -> servicesEntity.addServiceItems(this, false));
		}
	}

	/**
	 * Remove all entities in Services from this entity.
	 */
	public void unsetServices() {
		this.services.forEach(entity -> entity.removeServiceItems(this, false));
		this.services.clear();
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
