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
public class TariffPackageEntity extends AbstractEntity {

	public TariffPackageEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var ServiceItemAssignmentsOneMany = new EntityReference();
			ServiceItemAssignmentsOneMany.entityName = "ServiceItemAssignment";
			ServiceItemAssignmentsOneMany.oppositeName = "TariffPackage";
			ServiceItemAssignmentsOneMany.name = "ServiceItemAssignments";
			ServiceItemAssignmentsOneMany.optional = true;
			ServiceItemAssignmentsOneMany.type = "One";
			ServiceItemAssignmentsOneMany.oppositeType = "Many";

		References.add(ServiceItemAssignmentsOneMany);

		var TariffPackageItemsOneMany = new EntityReference();
			TariffPackageItemsOneMany.entityName = "TariffPackageItem";
			TariffPackageItemsOneMany.oppositeName = "TariffPackage";
			TariffPackageItemsOneMany.name = "TariffPackageItems";
			TariffPackageItemsOneMany.optional = true;
			TariffPackageItemsOneMany.type = "One";
			TariffPackageItemsOneMany.oppositeType = "Many";

		References.add(TariffPackageItemsOneMany);

		var TariffPackageServiceAssignmentsOneMany = new EntityReference();
			TariffPackageServiceAssignmentsOneMany.entityName = "TariffPackageServiceAssignment";
			TariffPackageServiceAssignmentsOneMany.oppositeName = "TariffPackage";
			TariffPackageServiceAssignmentsOneMany.name = "TariffPackageServiceAssignments";
			TariffPackageServiceAssignmentsOneMany.optional = true;
			TariffPackageServiceAssignmentsOneMany.type = "One";
			TariffPackageServiceAssignmentsOneMany.oppositeType = "Many";

		References.add(TariffPackageServiceAssignmentsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Tariff Package Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Package Code here] end
	private String tariffPackageCode;

	// % protected region % [Modify attribute annotation for Tariff Package Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Package Name here] end
	private String tariffPackageName;

	// % protected region % [Modify attribute annotation for Tariff Package Classification here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Package Classification here] end
	private String tariffPackageClassification;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for Tariff Package Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Package Description here] end
	private String tariffPackageDescription;

	// % protected region % [Modify attribute annotation for Apply To here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Apply To here] end
	private ApplyToEnum applyTo;

	// % protected region % [Modify attribute annotation for Apply To All Services here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Apply To All Services here] end
	private Boolean applyToAllServices;

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

	private Set<ServiceItemAssignmentEntity> serviceItemAssignments = new HashSet<>();

	private Set<TariffPackageItemEntity> tariffPackageItems = new HashSet<>();

	private Set<TariffPackageServiceAssignmentEntity> tariffPackageServiceAssignments = new HashSet<>();

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
				entity.setTariffPackage(this, false);
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
			entity.unsetTariffPackage(false);
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
			this.serviceItemAssignments.forEach(serviceItemAssignmentsEntity -> serviceItemAssignmentsEntity.setTariffPackage(this, false));
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
			this.serviceItemAssignments.forEach(serviceItemAssignmentsEntity -> serviceItemAssignmentsEntity.unsetTariffPackage(false));
		}
		this.serviceItemAssignments.clear();
	}

/**
	 * Similar to {@link this#addTariffPackageItems(TariffPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageItemEntity to be added to this entity
	 */
	public void addTariffPackageItems(@NonNull TariffPackageItemEntity entity) {
		addTariffPackageItems(entity, true);
	}

	/**
	 * Add a new TariffPackageItemEntity to tariffPackageItems in this entity.
	 *
	 * @param entity the given TariffPackageItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTariffPackageItems(@NonNull TariffPackageItemEntity entity, boolean reverseAdd) {
		if (!this.tariffPackageItems.contains(entity)) {
			tariffPackageItems.add(entity);
			if (reverseAdd) {
				entity.setTariffPackage(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTariffPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be added to this entity
	 */
	public void addTariffPackageItems(@NonNull Collection<TariffPackageItemEntity> entities) {
		addTariffPackageItems(entities, true);
	}

	/**
	 * Add a new collection of TariffPackageItemEntity to Tariff Package Items in this entity.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTariffPackageItems(@NonNull Collection<TariffPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTariffPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTariffPackageItems(TariffPackageItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageItemEntity to be set to this entity
	 */
	public void removeTariffPackageItems(@NonNull TariffPackageItemEntity entity) {
		this.removeTariffPackageItems(entity, true);
	}

	/**
	 * Remove the given TariffPackageItemEntity from this entity.
	 *
	 * @param entity the given TariffPackageItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffPackageItems(@NonNull TariffPackageItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTariffPackage(false);
		}
		this.tariffPackageItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTariffPackageItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be removed to this entity
	 */
	public void removeTariffPackageItems(@NonNull Collection<TariffPackageItemEntity> entities) {
		this.removeTariffPackageItems(entities, true);
	}

	/**
	 * Remove the given collection of TariffPackageItemEntity from  to this entity.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTariffPackageItems(@NonNull Collection<TariffPackageItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTariffPackageItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTariffPackageItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to be set to this entity
	 */
	public void setTariffPackageItems(@NonNull Collection<TariffPackageItemEntity> entities) {
		setTariffPackageItems(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Package Items with the given ones.
	 *
	 * @param entities the given collection of TariffPackageItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffPackageItems(@NonNull Collection<TariffPackageItemEntity> entities, boolean reverseAdd) {

		this.unsetTariffPackageItems();
		this.tariffPackageItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.tariffPackageItems.forEach(tariffPackageItemsEntity -> tariffPackageItemsEntity.setTariffPackage(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTariffPackageItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTariffPackageItems() {
		this.unsetTariffPackageItems(true);
	}

	/**
	 * Remove all the entities in Tariff Package Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTariffPackageItems(boolean doReverse) {
		if (doReverse) {
			this.tariffPackageItems.forEach(tariffPackageItemsEntity -> tariffPackageItemsEntity.unsetTariffPackage(false));
		}
		this.tariffPackageItems.clear();
	}

/**
	 * Similar to {@link this#addTariffPackageServiceAssignments(TariffPackageServiceAssignmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageServiceAssignmentEntity to be added to this entity
	 */
	public void addTariffPackageServiceAssignments(@NonNull TariffPackageServiceAssignmentEntity entity) {
		addTariffPackageServiceAssignments(entity, true);
	}

	/**
	 * Add a new TariffPackageServiceAssignmentEntity to tariffPackageServiceAssignments in this entity.
	 *
	 * @param entity the given TariffPackageServiceAssignmentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTariffPackageServiceAssignments(@NonNull TariffPackageServiceAssignmentEntity entity, boolean reverseAdd) {
		if (!this.tariffPackageServiceAssignments.contains(entity)) {
			tariffPackageServiceAssignments.add(entity);
			if (reverseAdd) {
				entity.setTariffPackage(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTariffPackageServiceAssignments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be added to this entity
	 */
	public void addTariffPackageServiceAssignments(@NonNull Collection<TariffPackageServiceAssignmentEntity> entities) {
		addTariffPackageServiceAssignments(entities, true);
	}

	/**
	 * Add a new collection of TariffPackageServiceAssignmentEntity to Tariff Package Service Assignments in this entity.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTariffPackageServiceAssignments(@NonNull Collection<TariffPackageServiceAssignmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTariffPackageServiceAssignments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTariffPackageServiceAssignments(TariffPackageServiceAssignmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TariffPackageServiceAssignmentEntity to be set to this entity
	 */
	public void removeTariffPackageServiceAssignments(@NonNull TariffPackageServiceAssignmentEntity entity) {
		this.removeTariffPackageServiceAssignments(entity, true);
	}

	/**
	 * Remove the given TariffPackageServiceAssignmentEntity from this entity.
	 *
	 * @param entity the given TariffPackageServiceAssignmentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTariffPackageServiceAssignments(@NonNull TariffPackageServiceAssignmentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTariffPackage(false);
		}
		this.tariffPackageServiceAssignments.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTariffPackageServiceAssignments(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be removed to this entity
	 */
	public void removeTariffPackageServiceAssignments(@NonNull Collection<TariffPackageServiceAssignmentEntity> entities) {
		this.removeTariffPackageServiceAssignments(entities, true);
	}

	/**
	 * Remove the given collection of TariffPackageServiceAssignmentEntity from  to this entity.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTariffPackageServiceAssignments(@NonNull Collection<TariffPackageServiceAssignmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTariffPackageServiceAssignments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTariffPackageServiceAssignments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to be set to this entity
	 */
	public void setTariffPackageServiceAssignments(@NonNull Collection<TariffPackageServiceAssignmentEntity> entities) {
		setTariffPackageServiceAssignments(entities, true);
	}

	/**
	 * Replace the current entities in Tariff Package Service Assignments with the given ones.
	 *
	 * @param entities the given collection of TariffPackageServiceAssignmentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTariffPackageServiceAssignments(@NonNull Collection<TariffPackageServiceAssignmentEntity> entities, boolean reverseAdd) {

		this.unsetTariffPackageServiceAssignments();
		this.tariffPackageServiceAssignments = new HashSet<>(entities);
		if (reverseAdd) {
			this.tariffPackageServiceAssignments.forEach(tariffPackageServiceAssignmentsEntity -> tariffPackageServiceAssignmentsEntity.setTariffPackage(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTariffPackageServiceAssignments(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTariffPackageServiceAssignments() {
		this.unsetTariffPackageServiceAssignments(true);
	}

	/**
	 * Remove all the entities in Tariff Package Service Assignments from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTariffPackageServiceAssignments(boolean doReverse) {
		if (doReverse) {
			this.tariffPackageServiceAssignments.forEach(tariffPackageServiceAssignmentsEntity -> tariffPackageServiceAssignmentsEntity.unsetTariffPackage(false));
		}
		this.tariffPackageServiceAssignments.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
