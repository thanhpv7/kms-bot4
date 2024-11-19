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
public class TransferOrderEntity extends AbstractEntity {

	public TransferOrderEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var DestinationWarehouseOneMany = new EntityReference();
			DestinationWarehouseOneMany.entityName = "Warehouse";
			DestinationWarehouseOneMany.oppositeName = "DestinationWarehouse";
			DestinationWarehouseOneMany.name = "DestinationWarehouses";
			DestinationWarehouseOneMany.optional = true;
			DestinationWarehouseOneMany.type = "One";
			DestinationWarehouseOneMany.oppositeType = "Many";

		References.add(DestinationWarehouseOneMany);

		var SourceWarehouseOneMany = new EntityReference();
			SourceWarehouseOneMany.entityName = "Warehouse";
			SourceWarehouseOneMany.oppositeName = "SourceWarehouse";
			SourceWarehouseOneMany.name = "SourceWarehouses";
			SourceWarehouseOneMany.optional = true;
			SourceWarehouseOneMany.type = "One";
			SourceWarehouseOneMany.oppositeType = "Many";

		References.add(SourceWarehouseOneMany);

		var TransferOrderStockDetailsOneMany = new EntityReference();
			TransferOrderStockDetailsOneMany.entityName = "TransferOrderStockDetail";
			TransferOrderStockDetailsOneMany.oppositeName = "TransferOrder";
			TransferOrderStockDetailsOneMany.name = "TransferOrderStockDetails";
			TransferOrderStockDetailsOneMany.optional = true;
			TransferOrderStockDetailsOneMany.type = "One";
			TransferOrderStockDetailsOneMany.oppositeType = "Many";

		References.add(TransferOrderStockDetailsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Transfer Order Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transfer Order Number here] end
	private String transferOrderNumber;

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

	// % protected region % [Modify attribute annotation for Reference Document here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Reference Document here] end
	private String referenceDocument;

	// % protected region % [Modify attribute annotation for Required Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Required Date here] end
	private OffsetDateTime requiredDate;

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

	private Set<TransferOrderStockDetailEntity> transferOrderStockDetails = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private WarehouseEntity destinationWarehouse;

	private WarehouseEntity sourceWarehouse;

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
	 * Similar to {@link this#addTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity) {
		addTransferOrderStockDetails(entity, true);
	}

	/**
	 * Add a new TransferOrderStockDetailEntity to transferOrderStockDetails in this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity, boolean reverseAdd) {
		if (!this.transferOrderStockDetails.contains(entity)) {
			transferOrderStockDetails.add(entity);
			if (reverseAdd) {
				entity.setTransferOrder(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 */
	public void addTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities) {
		addTransferOrderStockDetails(entities, true);
	}

	/**
	 * Add a new collection of TransferOrderStockDetailEntity to Transfer Order Stock Details in this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(TransferOrderStockDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be set to this entity
	 */
	public void removeTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity) {
		this.removeTransferOrderStockDetails(entity, true);
	}

	/**
	 * Remove the given TransferOrderStockDetailEntity from this entity.
	 *
	 * @param entity the given TransferOrderStockDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTransferOrderStockDetails(@NonNull TransferOrderStockDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransferOrder(false);
		}
		this.transferOrderStockDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 */
	public void removeTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities) {
		this.removeTransferOrderStockDetails(entities, true);
	}

	/**
	 * Remove the given collection of TransferOrderStockDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTransferOrderStockDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTransferOrderStockDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to be set to this entity
	 */
	public void setTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities) {
		setTransferOrderStockDetails(entities, true);
	}

	/**
	 * Replace the current entities in Transfer Order Stock Details with the given ones.
	 *
	 * @param entities the given collection of TransferOrderStockDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTransferOrderStockDetails(@NonNull Collection<TransferOrderStockDetailEntity> entities, boolean reverseAdd) {

		this.unsetTransferOrderStockDetails();
		this.transferOrderStockDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.setTransferOrder(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTransferOrderStockDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTransferOrderStockDetails() {
		this.unsetTransferOrderStockDetails(true);
	}

	/**
	 * Remove all the entities in Transfer Order Stock Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTransferOrderStockDetails(boolean doReverse) {
		if (doReverse) {
			this.transferOrderStockDetails.forEach(transferOrderStockDetailsEntity -> transferOrderStockDetailsEntity.unsetTransferOrder(false));
		}
		this.transferOrderStockDetails.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setDestinationWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setDestinationWarehouse(@NonNull WarehouseEntity entity) {
		setDestinationWarehouse(entity, true);
	}

	/**
	 * Set or update the destinationWarehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to destinationWarehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDestinationWarehouse(@NonNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDestinationWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDestinationWarehouse here] end

		if (sameAsFormer(this.destinationWarehouse, entity)) {
			return;
		}

		if (this.destinationWarehouse != null) {
			this.destinationWarehouse.removeDestinationWarehouses(this, false);
		}
		this.destinationWarehouse = entity;
		if (reverseAdd) {
			this.destinationWarehouse.addDestinationWarehouses(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDestinationWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDestinationWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDestinationWarehouse(boolean)} but default to true.
	 */
	public void unsetDestinationWarehouse() {
		this.unsetDestinationWarehouse(true);
	}

	/**
	 * Remove Destination Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDestinationWarehouse(boolean reverse) {
		if (reverse && this.destinationWarehouse != null) {
			this.destinationWarehouse.removeDestinationWarehouses(this, false);
		}
		this.destinationWarehouse = null;
	}
	/**
	 * Similar to {@link this#setSourceWarehouse(WarehouseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseEntity to be set to this entity
	 */
	public void setSourceWarehouse(@NonNull WarehouseEntity entity) {
		setSourceWarehouse(entity, true);
	}

	/**
	 * Set or update the sourceWarehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to sourceWarehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSourceWarehouse(@NonNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSourceWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSourceWarehouse here] end

		if (sameAsFormer(this.sourceWarehouse, entity)) {
			return;
		}

		if (this.sourceWarehouse != null) {
			this.sourceWarehouse.removeSourceWarehouses(this, false);
		}
		this.sourceWarehouse = entity;
		if (reverseAdd) {
			this.sourceWarehouse.addSourceWarehouses(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSourceWarehouse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSourceWarehouse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSourceWarehouse(boolean)} but default to true.
	 */
	public void unsetSourceWarehouse() {
		this.unsetSourceWarehouse(true);
	}

	/**
	 * Remove Source Warehouse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSourceWarehouse(boolean reverse) {
		if (reverse && this.sourceWarehouse != null) {
			this.sourceWarehouse.removeSourceWarehouses(this, false);
		}
		this.sourceWarehouse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
