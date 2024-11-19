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
import kmsweb.dtos.WarehouseInitialStockEntityDto;
import kmsweb.entities.listeners.WarehouseInitialStockEntityListener;
import kmsweb.serializers.WarehouseInitialStockSerializer;
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
@EntityListeners({WarehouseInitialStockEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = WarehouseInitialStockSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class WarehouseInitialStockEntity extends AbstractEntity {

	/**
	 * Takes a WarehouseInitialStockEntityDto and converts it into a WarehouseInitialStockEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param warehouseInitialStockEntityDto
	 */
	public WarehouseInitialStockEntity(WarehouseInitialStockEntityDto warehouseInitialStockEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (warehouseInitialStockEntityDto.getId() != null) {
			this.setId(warehouseInitialStockEntityDto.getId());
		}

		if (warehouseInitialStockEntityDto.getMinimumLevel() != null) {
			this.setMinimumLevel(warehouseInitialStockEntityDto.getMinimumLevel());
		}

		if (warehouseInitialStockEntityDto.getMaximumLevel() != null) {
			this.setMaximumLevel(warehouseInitialStockEntityDto.getMaximumLevel());
		}

		if (warehouseInitialStockEntityDto.getLocation() != null) {
			this.setLocation(warehouseInitialStockEntityDto.getLocation());
		}

		if (warehouseInitialStockEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(warehouseInitialStockEntityDto.getStockCatalogue());
		}

		if (warehouseInitialStockEntityDto.getWarehouse() != null) {
			this.setWarehouse(warehouseInitialStockEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Minimum Level here] off begin
	@CsvBindByName(column = "MINIMUM_LEVEL", required = false)
	@Nullable
	@Column(name = "minimum_level")
	@Schema(description = "The Minimum Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Minimum Level here] end
	private Double minimumLevel;

	// % protected region % [Modify attribute annotation for Maximum Level here] off begin
	@CsvBindByName(column = "MAXIMUM_LEVEL", required = false)
	@Nullable
	@Column(name = "maximum_level")
	@Schema(description = "The Maximum Level of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Maximum Level here] end
	private Double maximumLevel;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Location here] off begin
	@Schema(description = "The Location entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Location here] end
	private LocationEntity location;

	// % protected region % [Update the annotation for locationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "LOCATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for locationId here] end
	private UUID locationId;

	// % protected region % [Update the annotation for Stock Catalogue here] off begin
	@Schema(description = "The Stock Catalogue entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Catalogue here] end
	private StockCatalogueEntity stockCatalogue;

	// % protected region % [Update the annotation for stockCatalogueId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_CATALOGUE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for stockCatalogueId here] end
	private UUID stockCatalogueId;

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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setLocation(LocationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given LocationEntity to be set to this entity
	 */
	public void setLocation(@NotNull LocationEntity entity) {
		setLocation(entity, true);
	}

	/**
	 * Set or update the location in this entity with single LocationEntity.
	 *
	 * @param entity the given LocationEntity to be set or updated to location
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setLocation(@NotNull LocationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setLocation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setLocation here] end

		if (sameAsFormer(this.location, entity)) {
			return;
		}

		if (this.location != null) {
			this.location.removeWarehouseInitialStockS(this, false);
		}
		this.location = entity;
		if (reverseAdd) {
			this.location.addWarehouseInitialStockS(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setLocation incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setLocation incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetLocation(boolean)} but default to true.
	 */
	public void unsetLocation() {
		this.unsetLocation(true);
	}

	/**
	 * Remove Location in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetLocation(boolean reverse) {
		if (reverse && this.location != null) {
			this.location.removeWarehouseInitialStockS(this, false);
		}
		this.location = null;
	}
	/**
	 * Similar to {@link this#setStockCatalogue(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockCatalogueEntity to be set to this entity
	 */
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update the stockCatalogue in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogue
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.removeWarehouseInitialStockS(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addWarehouseInitialStockS(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogue(boolean)} but default to true.
	 */
	public void unsetStockCatalogue() {
		this.unsetStockCatalogue(true);
	}

	/**
	 * Remove Stock Catalogue in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogue(boolean reverse) {
		if (reverse && this.stockCatalogue != null) {
			this.stockCatalogue.removeWarehouseInitialStockS(this, false);
		}
		this.stockCatalogue = null;
	}
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
			this.warehouse.removeWarehouseInitialStockS(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addWarehouseInitialStockS(this, false);
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
			this.warehouse.removeWarehouseInitialStockS(this, false);
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
		return "MINIMUM_LEVEL,MAXIMUM_LEVEL,LOCATION_ID,STOCK_CATALOGUE_ID,WAREHOUSE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<LocationEntity> locationRelation = Optional.ofNullable(this.location);
		locationRelation.ifPresent(entity -> this.locationId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object warehouseInitialStock) {
		if (this == warehouseInitialStock) {
			return true;
		}
		if (warehouseInitialStock == null || this.getClass() != warehouseInitialStock.getClass()) {
			return false;
		}
		if (!super.equals(warehouseInitialStock)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		WarehouseInitialStockEntity that = (WarehouseInitialStockEntity) warehouseInitialStock;
		return
			Objects.equals(this.minimumLevel, that.minimumLevel) &&
			Objects.equals(this.maximumLevel, that.maximumLevel) &&
			Objects.equals(this.locationId, that.locationId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
