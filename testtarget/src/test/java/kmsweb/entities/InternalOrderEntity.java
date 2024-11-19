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
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class InternalOrderEntity extends AbstractEntity {

	public InternalOrderEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InternalOrderStockDetailsOneMany = new EntityReference();
			InternalOrderStockDetailsOneMany.entityName = "InternalOrderStockDetail";
			InternalOrderStockDetailsOneMany.oppositeName = "InternalOrder";
			InternalOrderStockDetailsOneMany.name = "InternalOrderStockDetails";
			InternalOrderStockDetailsOneMany.optional = true;
			InternalOrderStockDetailsOneMany.type = "One";
			InternalOrderStockDetailsOneMany.oppositeType = "Many";

		References.add(InternalOrderStockDetailsOneMany);

		var WarehouseOneMany = new EntityReference();
			WarehouseOneMany.entityName = "Warehouse";
			WarehouseOneMany.oppositeName = "Warehouse";
			WarehouseOneMany.name = "InternalOrders";
			WarehouseOneMany.optional = true;
			WarehouseOneMany.type = "One";
			WarehouseOneMany.oppositeType = "Many";

		References.add(WarehouseOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Internal Order Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Internal Order Number here] end
	private String internalOrderNumber;

	// % protected region % [Modify attribute annotation for Transaction Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Status here] end
	private String transactionStatus;

	// % protected region % [Modify attribute annotation for Approval Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Approval Status here] end
	private String approvalStatus;

	// % protected region % [Modify attribute annotation for Order Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Order Date here] end
	private OffsetDateTime orderDate;

	// % protected region % [Modify attribute annotation for Expected Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Expected Date here] end
	private OffsetDateTime expectedDate;

	// % protected region % [Modify attribute annotation for Request Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Request Unit here] end
	private String requestUnit;

	// % protected region % [Modify attribute annotation for Request Person here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Request Person here] end
	private String requestPerson;

	// % protected region % [Modify attribute annotation for Transaction Detail Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Detail Type here] end
	private String transactionDetailType;

	// % protected region % [Modify attribute annotation for Reference Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Reference Number here] end
	private String referenceNumber;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for Void Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Void Date here] end
	private OffsetDateTime voidDate;

	// % protected region % [Modify attribute annotation for Issued Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Issued Date Time here] end
	private OffsetDateTime issuedDateTime;

	// % protected region % [Modify attribute annotation for Received Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Received Date Time here] end
	private OffsetDateTime receivedDateTime;

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

	private Set<InternalOrderStockDetailEntity> internalOrderStockDetails = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private WarehouseEntity warehouse;

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
	 * Similar to {@link this#addInternalOrderStockDetails(InternalOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be added to this entity
	 */
	public void addInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity) {
		addInternalOrderStockDetails(entity, true);
	}

	/**
	 * Add a new InternalOrderStockDetailEntity to internalOrderStockDetails in this entity.
	 *
	 * @param entity the given InternalOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.internalOrderStockDetails.contains(entity)) {
			internalOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setInternalOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be added to this entity
	 */
	public void addInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities) {
		addInternalOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of InternalOrderStockDetailEntity to Internal Order Stock Details in this entity.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInternalOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInternalOrderStockDetails(InternalOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be set to this entity
	 */
	public void removeInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity) {
		this.removeInternalOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given InternalOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given InternalOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInternalOrderStockDetails(@NonNull InternalOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetInternalOrder(false);
		}
		this.internalOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be removed to this entity
	 */
	public void removeInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities) {
		this.removeInternalOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of InternalOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInternalOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInternalOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to be set to this entity
	 */
	public void setInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities) {
		setInternalOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Internal Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of InternalOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInternalOrderStockDetails(@NonNull Collection<InternalOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetInternalOrderStockDetails();
		this.internalOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.internalOrderStockDetails.forEach(internalOrderStockDetailsEntity -> internalOrderStockDetailsEntity.setInternalOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInternalOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInternalOrderStockDetails() {
		this.unsetInternalOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Internal Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInternalOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.internalOrderStockDetails.forEach(internalOrderStockDetailsEntity -> internalOrderStockDetailsEntity.unsetInternalOrder(false));
		}
		this.internalOrderStockDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setWarehouse(@NonNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NonNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] end

		if (sameAsFormer(this.warehouse, entity)) {
			return;
		}

		if (this.warehouse != null) {
			this.warehouse.removeInternalOrders(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addInternalOrders(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetWarehouse(boolean)} but default to true.
	 */
	public void unsetWarehouse() {
		this.unsetWarehouse(true);
	}

	/**
	 * Remove Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetWarehouse(boolean reverse) {
		if (reverse && this.warehouse != null) {
			this.warehouse.removeInternalOrders(this, false);
		}
		this.warehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
