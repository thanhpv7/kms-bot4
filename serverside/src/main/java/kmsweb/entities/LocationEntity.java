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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.LocationEntityDto;
import kmsweb.entities.listeners.LocationEntityListener;
import kmsweb.serializers.LocationSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({LocationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = LocationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class LocationEntity extends AbstractEntity {

	/**
	 * Takes a LocationEntityDto and converts it into a LocationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param locationEntityDto
	 */
	public LocationEntity(LocationEntityDto locationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (locationEntityDto.getId() != null) {
			this.setId(locationEntityDto.getId());
		}

		if (locationEntityDto.getLocationName() != null) {
			this.setLocationName(locationEntityDto.getLocationName());
		}

		if (locationEntityDto.getAisle() != null) {
			this.setAisle(locationEntityDto.getAisle());
		}

		if (locationEntityDto.getShelf() != null) {
			this.setShelf(locationEntityDto.getShelf());
		}

		if (locationEntityDto.getBin() != null) {
			this.setBin(locationEntityDto.getBin());
		}

		if (locationEntityDto.getStockControls() != null) {
			this.setStockControls(locationEntityDto.getStockControls());
		}

		if (locationEntityDto.getWarehouseInitialStockS() != null) {
			this.setWarehouseInitialStockS(locationEntityDto.getWarehouseInitialStockS());
		}

		if (locationEntityDto.getWarehouseInventories() != null) {
			this.setWarehouseInventories(locationEntityDto.getWarehouseInventories());
		}

		if (locationEntityDto.getWarehouse() != null) {
			this.setWarehouse(locationEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Location Name here] off begin
	@CsvBindByName(column = "LOCATION_NAME", required = true)
	@NotNull(message = "Location Name must not be empty")
	@Column(name = "location_name")
	@Schema(description = "The Location Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Location Name here] end
	private String locationName;

	// % protected region % [Modify attribute annotation for Aisle here] off begin
	@CsvBindByName(column = "AISLE", required = false)
	@Nullable
	@Column(name = "aisle")
	@Schema(description = "The Aisle of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Aisle here] end
	private String aisle;

	// % protected region % [Modify attribute annotation for Shelf here] off begin
	@CsvBindByName(column = "SHELF", required = false)
	@Nullable
	@Column(name = "shelf")
	@Schema(description = "The Shelf of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Shelf here] end
	private String shelf;

	// % protected region % [Modify attribute annotation for Bin here] off begin
	@CsvBindByName(column = "BIN", required = false)
	@Nullable
	@Column(name = "bin")
	@Schema(description = "The Bin of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bin here] end
	private String bin;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Stock Controls here] off begin
	@Schema(description = "The Stock Control entities that are related to this entity.")
	@OneToMany(mappedBy = "location", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Controls here] end
	private Set<StockControlEntity> stockControls = new HashSet<>();

	// % protected region % [Update the annotation for stockControlsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_CONTROLS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for stockControlsIds here] end
	private Set<UUID> stockControlsIds = new HashSet<>();

	// % protected region % [Update the annotation for Warehouse Initial Stock s here] off begin
	@Schema(description = "The Warehouse Initial Stock  entities that are related to this entity.")
	@OneToMany(mappedBy = "location", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse Initial Stock s here] end
	private Set<WarehouseInitialStockEntity> warehouseInitialStockS = new HashSet<>();

	// % protected region % [Update the annotation for warehouseInitialStockSIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_INITIAL_STOCK_S_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for warehouseInitialStockSIds here] end
	private Set<UUID> warehouseInitialStockSIds = new HashSet<>();

	// % protected region % [Update the annotation for Warehouse Inventories here] off begin
	@Schema(description = "The Warehouse Inventory entities that are related to this entity.")
	@OneToMany(mappedBy = "location", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse Inventories here] end
	private Set<WarehouseInventoryEntity> warehouseInventories = new HashSet<>();

	// % protected region % [Update the annotation for warehouseInventoriesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_INVENTORIES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for warehouseInventoriesIds here] end
	private Set<UUID> warehouseInventoriesIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Warehouse here] off begin
	@Schema(description = "The Warehouse entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Warehouse here] end
	private WarehouseEntity warehouse;

	// % protected region % [Update the annotation for warehouseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "WAREHOUSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for warehouseId here] end
	private UUID warehouseId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addStockControls(StockControlEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockControlEntity to be added to this entity
	 */
	public void addStockControls(@NotNull StockControlEntity entity) {
		addStockControls(entity, true);
	}

	/**
	 * Add a new StockControlEntity to stockControls in this entity.
	 *
	 * @param entity the given StockControlEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockControls(@NonNull StockControlEntity entity, boolean reverseAdd) {
		if (!this.stockControls.contains(entity)) {
			stockControls.add(entity);
			if (reverseAdd) {
				entity.setLocation(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockControls(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockControlEntity to be added to this entity
	 */
	public void addStockControls(@NotNull Collection<StockControlEntity> entities) {
		addStockControls(entities, true);
	}

	/**
	 * Add a new collection of StockControlEntity to Stock Controls in this entity.
	 *
	 * @param entities the given collection of StockControlEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockControls(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockControls(StockControlEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockControlEntity to be set to this entity
	 */
	public void removeStockControls(@NotNull StockControlEntity entity) {
		this.removeStockControls(entity, true);
	}

	/**
	 * Remove the given StockControlEntity from this entity.
	 *
	 * @param entity the given StockControlEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockControls(@NotNull StockControlEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetLocation(false);
		}
		this.stockControls.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockControls(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockControlEntity to be removed to this entity
	 */
	public void removeStockControls(@NotNull Collection<StockControlEntity> entities) {
		this.removeStockControls(entities, true);
	}

	/**
	 * Remove the given collection of StockControlEntity from  to this entity.
	 *
	 * @param entities the given collection of StockControlEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockControls(@NonNull Collection<StockControlEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockControls(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockControls(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockControlEntity to be set to this entity
	 */
	public void setStockControls(@NotNull Collection<StockControlEntity> entities) {
		setStockControls(entities, true);
	}

	/**
	 * Replace the current entities in Stock Controls with the given ones.
	 *
	 * @param entities the given collection of StockControlEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockControls(@NotNull Collection<StockControlEntity> entities, boolean reverseAdd) {

		this.unsetStockControls();
		this.stockControls = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockControls.forEach(stockControlsEntity -> stockControlsEntity.setLocation(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockControls(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockControls() {
		this.unsetStockControls(true);
	}

	/**
	 * Remove all the entities in Stock Controls from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockControls(boolean doReverse) {
		if (doReverse) {
			this.stockControls.forEach(stockControlsEntity -> stockControlsEntity.unsetLocation(false));
		}
		this.stockControls.clear();
	}

/**
	 * Similar to {@link this#addWarehouseInitialStockS(WarehouseInitialStockEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be added to this entity
	 */
	public void addWarehouseInitialStockS(@NotNull WarehouseInitialStockEntity entity) {
		addWarehouseInitialStockS(entity, true);
	}

	/**
	 * Add a new WarehouseInitialStockEntity to warehouseInitialStockS in this entity.
	 *
	 * @param entity the given WarehouseInitialStockEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addWarehouseInitialStockS(@NonNull WarehouseInitialStockEntity entity, boolean reverseAdd) {
		if (!this.warehouseInitialStockS.contains(entity)) {
			warehouseInitialStockS.add(entity);
			if (reverseAdd) {
				entity.setLocation(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be added to this entity
	 */
	public void addWarehouseInitialStockS(@NotNull Collection<WarehouseInitialStockEntity> entities) {
		addWarehouseInitialStockS(entities, true);
	}

	/**
	 * Add a new collection of WarehouseInitialStockEntity to Warehouse Initial Stock s in this entity.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addWarehouseInitialStockS(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeWarehouseInitialStockS(WarehouseInitialStockEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be set to this entity
	 */
	public void removeWarehouseInitialStockS(@NotNull WarehouseInitialStockEntity entity) {
		this.removeWarehouseInitialStockS(entity, true);
	}

	/**
	 * Remove the given WarehouseInitialStockEntity from this entity.
	 *
	 * @param entity the given WarehouseInitialStockEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeWarehouseInitialStockS(@NotNull WarehouseInitialStockEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetLocation(false);
		}
		this.warehouseInitialStockS.remove(entity);
	}

	/**
	 * Similar to {@link this#removeWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be removed to this entity
	 */
	public void removeWarehouseInitialStockS(@NotNull Collection<WarehouseInitialStockEntity> entities) {
		this.removeWarehouseInitialStockS(entities, true);
	}

	/**
	 * Remove the given collection of WarehouseInitialStockEntity from  to this entity.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeWarehouseInitialStockS(@NonNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeWarehouseInitialStockS(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setWarehouseInitialStockS(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to be set to this entity
	 */
	public void setWarehouseInitialStockS(@NotNull Collection<WarehouseInitialStockEntity> entities) {
		setWarehouseInitialStockS(entities, true);
	}

	/**
	 * Replace the current entities in Warehouse Initial Stock s with the given ones.
	 *
	 * @param entities the given collection of WarehouseInitialStockEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setWarehouseInitialStockS(@NotNull Collection<WarehouseInitialStockEntity> entities, boolean reverseAdd) {

		this.unsetWarehouseInitialStockS();
		this.warehouseInitialStockS = new HashSet<>(entities);
		if (reverseAdd) {
			this.warehouseInitialStockS.forEach(warehouseInitialStockSEntity -> warehouseInitialStockSEntity.setLocation(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetWarehouseInitialStockS(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetWarehouseInitialStockS() {
		this.unsetWarehouseInitialStockS(true);
	}

	/**
	 * Remove all the entities in Warehouse Initial Stock s from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetWarehouseInitialStockS(boolean doReverse) {
		if (doReverse) {
			this.warehouseInitialStockS.forEach(warehouseInitialStockSEntity -> warehouseInitialStockSEntity.unsetLocation(false));
		}
		this.warehouseInitialStockS.clear();
	}

/**
	 * Similar to {@link this#addWarehouseInventories(WarehouseInventoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInventoryEntity to be added to this entity
	 */
	public void addWarehouseInventories(@NotNull WarehouseInventoryEntity entity) {
		addWarehouseInventories(entity, true);
	}

	/**
	 * Add a new WarehouseInventoryEntity to warehouseInventories in this entity.
	 *
	 * @param entity the given WarehouseInventoryEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addWarehouseInventories(@NonNull WarehouseInventoryEntity entity, boolean reverseAdd) {
		if (!this.warehouseInventories.contains(entity)) {
			warehouseInventories.add(entity);
			if (reverseAdd) {
				entity.setLocation(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be added to this entity
	 */
	public void addWarehouseInventories(@NotNull Collection<WarehouseInventoryEntity> entities) {
		addWarehouseInventories(entities, true);
	}

	/**
	 * Add a new collection of WarehouseInventoryEntity to Warehouse Inventories in this entity.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addWarehouseInventories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeWarehouseInventories(WarehouseInventoryEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given WarehouseInventoryEntity to be set to this entity
	 */
	public void removeWarehouseInventories(@NotNull WarehouseInventoryEntity entity) {
		this.removeWarehouseInventories(entity, true);
	}

	/**
	 * Remove the given WarehouseInventoryEntity from this entity.
	 *
	 * @param entity the given WarehouseInventoryEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeWarehouseInventories(@NotNull WarehouseInventoryEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetLocation(false);
		}
		this.warehouseInventories.remove(entity);
	}

	/**
	 * Similar to {@link this#removeWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be removed to this entity
	 */
	public void removeWarehouseInventories(@NotNull Collection<WarehouseInventoryEntity> entities) {
		this.removeWarehouseInventories(entities, true);
	}

	/**
	 * Remove the given collection of WarehouseInventoryEntity from  to this entity.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeWarehouseInventories(@NonNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeWarehouseInventories(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setWarehouseInventories(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to be set to this entity
	 */
	public void setWarehouseInventories(@NotNull Collection<WarehouseInventoryEntity> entities) {
		setWarehouseInventories(entities, true);
	}

	/**
	 * Replace the current entities in Warehouse Inventories with the given ones.
	 *
	 * @param entities the given collection of WarehouseInventoryEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setWarehouseInventories(@NotNull Collection<WarehouseInventoryEntity> entities, boolean reverseAdd) {

		this.unsetWarehouseInventories();
		this.warehouseInventories = new HashSet<>(entities);
		if (reverseAdd) {
			this.warehouseInventories.forEach(warehouseInventoriesEntity -> warehouseInventoriesEntity.setLocation(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetWarehouseInventories(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetWarehouseInventories() {
		this.unsetWarehouseInventories(true);
	}

	/**
	 * Remove all the entities in Warehouse Inventories from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetWarehouseInventories(boolean doReverse) {
		if (doReverse) {
			this.warehouseInventories.forEach(warehouseInventoriesEntity -> warehouseInventoriesEntity.unsetLocation(false));
		}
		this.warehouseInventories.clear();
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
	public void setWarehouse(@NotNull WarehouseEntity entity) {
		setWarehouse(entity, true);
	}

	/**
	 * Set or update the warehouse in this entity with single WarehouseEntity.
	 *
	 * @param entity the given WarehouseEntity to be set or updated to warehouse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setWarehouse(@NotNull WarehouseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setWarehouse here] end

		if (sameAsFormer(this.warehouse, entity)) {
			return;
		}

		if (this.warehouse != null) {
			this.warehouse.removeLocations(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addLocations(this, false);
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
			this.warehouse.removeLocations(this, false);
		}
		this.warehouse = null;
	}

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "LOCATION_NAME,AISLE,SHELF,BIN,WAREHOUSE_ID,STOCK_CONTROLS_IDS,WAREHOUSE_INITIAL_STOCK_S_IDS,WAREHOUSE_INVENTORIES_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		this.stockControlsIds = new HashSet<>();
		for (StockControlEntity stockControls: this.stockControls) {
			this.stockControlsIds.add(stockControls.getId());
		}

		this.warehouseInitialStockSIds = new HashSet<>();
		for (WarehouseInitialStockEntity warehouseInitialStockS: this.warehouseInitialStockS) {
			this.warehouseInitialStockSIds.add(warehouseInitialStockS.getId());
		}

		this.warehouseInventoriesIds = new HashSet<>();
		for (WarehouseInventoryEntity warehouseInventories: this.warehouseInventories) {
			this.warehouseInventoriesIds.add(warehouseInventories.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object location) {
		if (this == location) {
			return true;
		}
		if (location == null || this.getClass() != location.getClass()) {
			return false;
		}
		if (!super.equals(location)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		LocationEntity that = (LocationEntity) location;
		return
			Objects.equals(this.locationName, that.locationName) &&
			Objects.equals(this.aisle, that.aisle) &&
			Objects.equals(this.shelf, that.shelf) &&
			Objects.equals(this.bin, that.bin) &&
			Objects.equals(this.stockControlsIds, that.stockControlsIds) &&
			Objects.equals(this.warehouseInitialStockSIds, that.warehouseInitialStockSIds) &&
			Objects.equals(this.warehouseInventoriesIds, that.warehouseInventoriesIds) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
