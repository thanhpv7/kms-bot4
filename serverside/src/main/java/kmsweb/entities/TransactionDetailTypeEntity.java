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
import kmsweb.dtos.TransactionDetailTypeEntityDto;
import kmsweb.entities.listeners.TransactionDetailTypeEntityListener;
import kmsweb.serializers.TransactionDetailTypeSerializer;
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
@EntityListeners({TransactionDetailTypeEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = TransactionDetailTypeSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class TransactionDetailTypeEntity extends AbstractEntity {

	/**
	 * Takes a TransactionDetailTypeEntityDto and converts it into a TransactionDetailTypeEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param transactionDetailTypeEntityDto
	 */
	public TransactionDetailTypeEntity(TransactionDetailTypeEntityDto transactionDetailTypeEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (transactionDetailTypeEntityDto.getId() != null) {
			this.setId(transactionDetailTypeEntityDto.getId());
		}

		if (transactionDetailTypeEntityDto.getTransactionDetail() != null) {
			this.setTransactionDetail(transactionDetailTypeEntityDto.getTransactionDetail());
		}

		if (transactionDetailTypeEntityDto.getNotes() != null) {
			this.setNotes(transactionDetailTypeEntityDto.getNotes());
		}

		if (transactionDetailTypeEntityDto.getCoaCOGS() != null) {
			this.setCoaCOGS(transactionDetailTypeEntityDto.getCoaCOGS());
		}

		if (transactionDetailTypeEntityDto.getCoaSell() != null) {
			this.setCoaSell(transactionDetailTypeEntityDto.getCoaSell());
		}

		if (transactionDetailTypeEntityDto.getCoaInventory() != null) {
			this.setCoaInventory(transactionDetailTypeEntityDto.getCoaInventory());
		}

		if (transactionDetailTypeEntityDto.getInventoryAdjustments() != null) {
			this.setInventoryAdjustments(transactionDetailTypeEntityDto.getInventoryAdjustments());
		}

		if (transactionDetailTypeEntityDto.getStockTransactionDetails() != null) {
			this.setStockTransactionDetails(transactionDetailTypeEntityDto.getStockTransactionDetails());
		}

		if (transactionDetailTypeEntityDto.getStockTransactionPerDateTypes() != null) {
			this.setStockTransactionPerDateTypes(transactionDetailTypeEntityDto.getStockTransactionPerDateTypes());
		}

		if (transactionDetailTypeEntityDto.getTransactionDetailTypeMappings() != null) {
			this.setTransactionDetailTypeMappings(transactionDetailTypeEntityDto.getTransactionDetailTypeMappings());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Transaction Detail here] off begin
	@CsvBindByName(column = "TRANSACTION_DETAIL", required = true)
	@NotNull(message = "Transaction Detail must not be empty")
	@Column(name = "transaction_detail")
	@Schema(description = "The Transaction Detail of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transaction Detail here] end
	private String transactionDetail;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for COA COGS here] off begin
	@CsvBindByName(column = "COA_COGS", required = false)
	@Nullable
	@Column(name = "coa_cogs")
	@Schema(description = "The COA COGS of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA COGS here] end
	private String coaCOGS;

	// % protected region % [Modify attribute annotation for COA Sell here] off begin
	@CsvBindByName(column = "COA_SELL", required = false)
	@Nullable
	@Column(name = "coa_sell")
	@Schema(description = "The COA Sell of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA Sell here] end
	private String coaSell;

	// % protected region % [Modify attribute annotation for COA Inventory here] off begin
	@CsvBindByName(column = "COA_INVENTORY", required = false)
	@Nullable
	@Column(name = "coa_inventory")
	@Schema(description = "The COA Inventory of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for COA Inventory here] end
	private String coaInventory;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Inventory Adjustments here] off begin
	@Schema(description = "The Inventory Adjustment entities that are related to this entity.")
	@OneToMany(mappedBy = "transactionDetailType", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Inventory Adjustments here] end
	private Set<InventoryAdjustmentEntity> inventoryAdjustments = new HashSet<>();

	// % protected region % [Update the annotation for inventoryAdjustmentsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVENTORY_ADJUSTMENTS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for inventoryAdjustmentsIds here] end
	private Set<UUID> inventoryAdjustmentsIds = new HashSet<>();

	// % protected region % [Update the annotation for Stock Transaction Details here] off begin
	@Schema(description = "The Stock Transaction Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "transactionDetailType", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Transaction Details here] end
	private Set<StockTransactionDetailEntity> stockTransactionDetails = new HashSet<>();

	// % protected region % [Update the annotation for stockTransactionDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_TRANSACTION_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for stockTransactionDetailsIds here] end
	private Set<UUID> stockTransactionDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Stock Transaction Per Date Types here] off begin
	@Schema(description = "The Stock Transaction Per Date Type entities that are related to this entity.")
	@OneToMany(mappedBy = "transactionDetailType", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Transaction Per Date Types here] end
	private Set<StockTransactionPerDateTypeEntity> stockTransactionPerDateTypes = new HashSet<>();

	// % protected region % [Update the annotation for stockTransactionPerDateTypesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_TRANSACTION_PER_DATE_TYPES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for stockTransactionPerDateTypesIds here] end
	private Set<UUID> stockTransactionPerDateTypesIds = new HashSet<>();

	// % protected region % [Update the annotation for Transaction Detail Type Mappings here] off begin
	@Schema(description = "The Transaction Detail Type Mapping entities that are related to this entity.")
	@OneToMany(mappedBy = "transactionDetailType", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Transaction Detail Type Mappings here] end
	private Set<TransactionDetailTypeMappingEntity> transactionDetailTypeMappings = new HashSet<>();

	// % protected region % [Update the annotation for transactionDetailTypeMappingsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "TRANSACTION_DETAIL_TYPE_MAPPINGS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for transactionDetailTypeMappingsIds here] end
	private Set<UUID> transactionDetailTypeMappingsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
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
	 * Similar to {@link this#addInventoryAdjustments(InventoryAdjustmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be added to this entity
	 */
	public void addInventoryAdjustments(@NotNull InventoryAdjustmentEntity entity) {
		addInventoryAdjustments(entity, true);
	}

	/**
	 * Add a new InventoryAdjustmentEntity to inventoryAdjustments in this entity.
	 *
	 * @param entity the given InventoryAdjustmentEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInventoryAdjustments(@NonNull InventoryAdjustmentEntity entity, boolean reverseAdd) {
		if (!this.inventoryAdjustments.contains(entity)) {
			inventoryAdjustments.add(entity);
			if (reverseAdd) {
				entity.setTransactionDetailType(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInventoryAdjustments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be added to this entity
	 */
	public void addInventoryAdjustments(@NotNull Collection<InventoryAdjustmentEntity> entities) {
		addInventoryAdjustments(entities, true);
	}

	/**
	 * Add a new collection of InventoryAdjustmentEntity to Inventory Adjustments in this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInventoryAdjustments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustments(InventoryAdjustmentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be set to this entity
	 */
	public void removeInventoryAdjustments(@NotNull InventoryAdjustmentEntity entity) {
		this.removeInventoryAdjustments(entity, true);
	}

	/**
	 * Remove the given InventoryAdjustmentEntity from this entity.
	 *
	 * @param entity the given InventoryAdjustmentEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInventoryAdjustments(@NotNull InventoryAdjustmentEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransactionDetailType(false);
		}
		this.inventoryAdjustments.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInventoryAdjustments(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be removed to this entity
	 */
	public void removeInventoryAdjustments(@NotNull Collection<InventoryAdjustmentEntity> entities) {
		this.removeInventoryAdjustments(entities, true);
	}

	/**
	 * Remove the given collection of InventoryAdjustmentEntity from  to this entity.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInventoryAdjustments(@NonNull Collection<InventoryAdjustmentEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInventoryAdjustments(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInventoryAdjustments(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to be set to this entity
	 */
	public void setInventoryAdjustments(@NotNull Collection<InventoryAdjustmentEntity> entities) {
		setInventoryAdjustments(entities, true);
	}

	/**
	 * Replace the current entities in Inventory Adjustments with the given ones.
	 *
	 * @param entities the given collection of InventoryAdjustmentEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInventoryAdjustments(@NotNull Collection<InventoryAdjustmentEntity> entities, boolean reverseAdd) {

		this.unsetInventoryAdjustments();
		this.inventoryAdjustments = new HashSet<>(entities);
		if (reverseAdd) {
			this.inventoryAdjustments.forEach(inventoryAdjustmentsEntity -> inventoryAdjustmentsEntity.setTransactionDetailType(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInventoryAdjustments(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInventoryAdjustments() {
		this.unsetInventoryAdjustments(true);
	}

	/**
	 * Remove all the entities in Inventory Adjustments from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInventoryAdjustments(boolean doReverse) {
		if (doReverse) {
			this.inventoryAdjustments.forEach(inventoryAdjustmentsEntity -> inventoryAdjustmentsEntity.unsetTransactionDetailType(false));
		}
		this.inventoryAdjustments.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NotNull StockTransactionDetailEntity entity) {
		addStockTransactionDetails(entity, true);
	}

	/**
	 * Add a new StockTransactionDetailEntity to stockTransactionDetails in this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionDetails(@NonNull StockTransactionDetailEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionDetails.contains(entity)) {
			stockTransactionDetails.add(entity);
			if (reverseAdd) {
				entity.setTransactionDetailType(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 */
	public void addStockTransactionDetails(@NotNull Collection<StockTransactionDetailEntity> entities) {
		addStockTransactionDetails(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionDetailEntity to Stock Transaction Details in this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(StockTransactionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionDetailEntity to be set to this entity
	 */
	public void removeStockTransactionDetails(@NotNull StockTransactionDetailEntity entity) {
		this.removeStockTransactionDetails(entity, true);
	}

	/**
	 * Remove the given StockTransactionDetailEntity from this entity.
	 *
	 * @param entity the given StockTransactionDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionDetails(@NotNull StockTransactionDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransactionDetailType(false);
		}
		this.stockTransactionDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 */
	public void removeStockTransactionDetails(@NotNull Collection<StockTransactionDetailEntity> entities) {
		this.removeStockTransactionDetails(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionDetails(@NonNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to be set to this entity
	 */
	public void setStockTransactionDetails(@NotNull Collection<StockTransactionDetailEntity> entities) {
		setStockTransactionDetails(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Details with the given ones.
	 *
	 * @param entities the given collection of StockTransactionDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionDetails(@NotNull Collection<StockTransactionDetailEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionDetails();
		this.stockTransactionDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.setTransactionDetailType(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionDetails() {
		this.unsetStockTransactionDetails(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionDetails(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionDetails.forEach(stockTransactionDetailsEntity -> stockTransactionDetailsEntity.unsetTransactionDetailType(false));
		}
		this.stockTransactionDetails.clear();
	}

/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NotNull StockTransactionPerDateTypeEntity entity) {
		addStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Add a new StockTransactionPerDateTypeEntity to stockTransactionPerDateTypes in this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addStockTransactionPerDateTypes(@NonNull StockTransactionPerDateTypeEntity entity, boolean reverseAdd) {
		if (!this.stockTransactionPerDateTypes.contains(entity)) {
			stockTransactionPerDateTypes.add(entity);
			if (reverseAdd) {
				entity.setTransactionDetailType(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 */
	public void addStockTransactionPerDateTypes(@NotNull Collection<StockTransactionPerDateTypeEntity> entities) {
		addStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Add a new collection of StockTransactionPerDateTypeEntity to Stock Transaction Per Date Types in this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(StockTransactionPerDateTypeEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NotNull StockTransactionPerDateTypeEntity entity) {
		this.removeStockTransactionPerDateTypes(entity, true);
	}

	/**
	 * Remove the given StockTransactionPerDateTypeEntity from this entity.
	 *
	 * @param entity the given StockTransactionPerDateTypeEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeStockTransactionPerDateTypes(@NotNull StockTransactionPerDateTypeEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransactionDetailType(false);
		}
		this.stockTransactionPerDateTypes.remove(entity);
	}

	/**
	 * Similar to {@link this#removeStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 */
	public void removeStockTransactionPerDateTypes(@NotNull Collection<StockTransactionPerDateTypeEntity> entities) {
		this.removeStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Remove the given collection of StockTransactionPerDateTypeEntity from  to this entity.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeStockTransactionPerDateTypes(@NonNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeStockTransactionPerDateTypes(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setStockTransactionPerDateTypes(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to be set to this entity
	 */
	public void setStockTransactionPerDateTypes(@NotNull Collection<StockTransactionPerDateTypeEntity> entities) {
		setStockTransactionPerDateTypes(entities, true);
	}

	/**
	 * Replace the current entities in Stock Transaction Per Date Types with the given ones.
	 *
	 * @param entities the given collection of StockTransactionPerDateTypeEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setStockTransactionPerDateTypes(@NotNull Collection<StockTransactionPerDateTypeEntity> entities, boolean reverseAdd) {

		this.unsetStockTransactionPerDateTypes();
		this.stockTransactionPerDateTypes = new HashSet<>(entities);
		if (reverseAdd) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.setTransactionDetailType(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetStockTransactionPerDateTypes(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetStockTransactionPerDateTypes() {
		this.unsetStockTransactionPerDateTypes(true);
	}

	/**
	 * Remove all the entities in Stock Transaction Per Date Types from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetStockTransactionPerDateTypes(boolean doReverse) {
		if (doReverse) {
			this.stockTransactionPerDateTypes.forEach(stockTransactionPerDateTypesEntity -> stockTransactionPerDateTypesEntity.unsetTransactionDetailType(false));
		}
		this.stockTransactionPerDateTypes.clear();
	}

/**
	 * Similar to {@link this#addTransactionDetailTypeMappings(TransactionDetailTypeMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransactionDetailTypeMappingEntity to be added to this entity
	 */
	public void addTransactionDetailTypeMappings(@NotNull TransactionDetailTypeMappingEntity entity) {
		addTransactionDetailTypeMappings(entity, true);
	}

	/**
	 * Add a new TransactionDetailTypeMappingEntity to transactionDetailTypeMappings in this entity.
	 *
	 * @param entity the given TransactionDetailTypeMappingEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addTransactionDetailTypeMappings(@NonNull TransactionDetailTypeMappingEntity entity, boolean reverseAdd) {
		if (!this.transactionDetailTypeMappings.contains(entity)) {
			transactionDetailTypeMappings.add(entity);
			if (reverseAdd) {
				entity.setTransactionDetailType(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addTransactionDetailTypeMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be added to this entity
	 */
	public void addTransactionDetailTypeMappings(@NotNull Collection<TransactionDetailTypeMappingEntity> entities) {
		addTransactionDetailTypeMappings(entities, true);
	}

	/**
	 * Add a new collection of TransactionDetailTypeMappingEntity to Transaction Detail Type Mappings in this entity.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addTransactionDetailTypeMappings(@NonNull Collection<TransactionDetailTypeMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addTransactionDetailTypeMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeTransactionDetailTypeMappings(TransactionDetailTypeMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given TransactionDetailTypeMappingEntity to be set to this entity
	 */
	public void removeTransactionDetailTypeMappings(@NotNull TransactionDetailTypeMappingEntity entity) {
		this.removeTransactionDetailTypeMappings(entity, true);
	}

	/**
	 * Remove the given TransactionDetailTypeMappingEntity from this entity.
	 *
	 * @param entity the given TransactionDetailTypeMappingEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeTransactionDetailTypeMappings(@NotNull TransactionDetailTypeMappingEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetTransactionDetailType(false);
		}
		this.transactionDetailTypeMappings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeTransactionDetailTypeMappings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be removed to this entity
	 */
	public void removeTransactionDetailTypeMappings(@NotNull Collection<TransactionDetailTypeMappingEntity> entities) {
		this.removeTransactionDetailTypeMappings(entities, true);
	}

	/**
	 * Remove the given collection of TransactionDetailTypeMappingEntity from  to this entity.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeTransactionDetailTypeMappings(@NonNull Collection<TransactionDetailTypeMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeTransactionDetailTypeMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setTransactionDetailTypeMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to be set to this entity
	 */
	public void setTransactionDetailTypeMappings(@NotNull Collection<TransactionDetailTypeMappingEntity> entities) {
		setTransactionDetailTypeMappings(entities, true);
	}

	/**
	 * Replace the current entities in Transaction Detail Type Mappings with the given ones.
	 *
	 * @param entities the given collection of TransactionDetailTypeMappingEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setTransactionDetailTypeMappings(@NotNull Collection<TransactionDetailTypeMappingEntity> entities, boolean reverseAdd) {

		this.unsetTransactionDetailTypeMappings();
		this.transactionDetailTypeMappings = new HashSet<>(entities);
		if (reverseAdd) {
			this.transactionDetailTypeMappings.forEach(transactionDetailTypeMappingsEntity -> transactionDetailTypeMappingsEntity.setTransactionDetailType(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetTransactionDetailTypeMappings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetTransactionDetailTypeMappings() {
		this.unsetTransactionDetailTypeMappings(true);
	}

	/**
	 * Remove all the entities in Transaction Detail Type Mappings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetTransactionDetailTypeMappings(boolean doReverse) {
		if (doReverse) {
			this.transactionDetailTypeMappings.forEach(transactionDetailTypeMappingsEntity -> transactionDetailTypeMappingsEntity.unsetTransactionDetailType(false));
		}
		this.transactionDetailTypeMappings.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "TRANSACTION_DETAIL,NOTES,COA_COGS,COA_SELL,COA_INVENTORY,INVENTORY_ADJUSTMENTS_IDS,STOCK_TRANSACTION_DETAILS_IDS,STOCK_TRANSACTION_PER_DATE_TYPES_IDS,TRANSACTION_DETAIL_TYPE_MAPPINGS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		this.inventoryAdjustmentsIds = new HashSet<>();
		for (InventoryAdjustmentEntity inventoryAdjustments: this.inventoryAdjustments) {
			this.inventoryAdjustmentsIds.add(inventoryAdjustments.getId());
		}

		this.stockTransactionDetailsIds = new HashSet<>();
		for (StockTransactionDetailEntity stockTransactionDetails: this.stockTransactionDetails) {
			this.stockTransactionDetailsIds.add(stockTransactionDetails.getId());
		}

		this.stockTransactionPerDateTypesIds = new HashSet<>();
		for (StockTransactionPerDateTypeEntity stockTransactionPerDateTypes: this.stockTransactionPerDateTypes) {
			this.stockTransactionPerDateTypesIds.add(stockTransactionPerDateTypes.getId());
		}

		this.transactionDetailTypeMappingsIds = new HashSet<>();
		for (TransactionDetailTypeMappingEntity transactionDetailTypeMappings: this.transactionDetailTypeMappings) {
			this.transactionDetailTypeMappingsIds.add(transactionDetailTypeMappings.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object transactionDetailType) {
		if (this == transactionDetailType) {
			return true;
		}
		if (transactionDetailType == null || this.getClass() != transactionDetailType.getClass()) {
			return false;
		}
		if (!super.equals(transactionDetailType)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		TransactionDetailTypeEntity that = (TransactionDetailTypeEntity) transactionDetailType;
		return
			Objects.equals(this.transactionDetail, that.transactionDetail) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.coaCOGS, that.coaCOGS) &&
			Objects.equals(this.coaSell, that.coaSell) &&
			Objects.equals(this.coaInventory, that.coaInventory) &&
			Objects.equals(this.inventoryAdjustmentsIds, that.inventoryAdjustmentsIds) &&
			Objects.equals(this.stockTransactionDetailsIds, that.stockTransactionDetailsIds) &&
			Objects.equals(this.stockTransactionPerDateTypesIds, that.stockTransactionPerDateTypesIds) &&
			Objects.equals(this.transactionDetailTypeMappingsIds, that.transactionDetailTypeMappingsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
