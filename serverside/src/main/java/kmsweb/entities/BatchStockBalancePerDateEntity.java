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
import kmsweb.dtos.BatchStockBalancePerDateEntityDto;
import kmsweb.entities.listeners.BatchStockBalancePerDateEntityListener;
import kmsweb.serializers.BatchStockBalancePerDateSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.time.*;
import java.time.temporal.ChronoUnit;
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
@EntityListeners({BatchStockBalancePerDateEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BatchStockBalancePerDateSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BatchStockBalancePerDateEntity extends AbstractEntity {

	/**
	 * Takes a BatchStockBalancePerDateEntityDto and converts it into a BatchStockBalancePerDateEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param batchStockBalancePerDateEntityDto
	 */
	public BatchStockBalancePerDateEntity(BatchStockBalancePerDateEntityDto batchStockBalancePerDateEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (batchStockBalancePerDateEntityDto.getId() != null) {
			this.setId(batchStockBalancePerDateEntityDto.getId());
		}

		if (batchStockBalancePerDateEntityDto.getBatchNo() != null) {
			this.setBatchNo(batchStockBalancePerDateEntityDto.getBatchNo());
		}

		if (batchStockBalancePerDateEntityDto.getExpirationDate() != null) {
			this.setExpirationDate(batchStockBalancePerDateEntityDto.getExpirationDate());
		}

		if (batchStockBalancePerDateEntityDto.getAsOfDate() != null) {
			this.setAsOfDate(batchStockBalancePerDateEntityDto.getAsOfDate());
		}

		if (batchStockBalancePerDateEntityDto.getBatchQtyUoi() != null) {
			this.setBatchQtyUoi(batchStockBalancePerDateEntityDto.getBatchQtyUoi());
		}

		if (batchStockBalancePerDateEntityDto.getUoi() != null) {
			this.setUoi(batchStockBalancePerDateEntityDto.getUoi());
		}

		if (batchStockBalancePerDateEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(batchStockBalancePerDateEntityDto.getStockCatalogue());
		}

		if (batchStockBalancePerDateEntityDto.getWarehouse() != null) {
			this.setWarehouse(batchStockBalancePerDateEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Batch No here] off begin
	@CsvBindByName(column = "BATCH_NO", required = false)
	@Nullable
	@Column(name = "batch_no")
	@Schema(description = "The Batch No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch No here] end
	private String batchNo;

	// % protected region % [Modify attribute annotation for Expiration Date here] off begin

	@CsvCustomBindByName(column = "EXPIRATION_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "expiration_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Expiration Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Expiration Date here] end
	private OffsetDateTime expirationDate;

	// % protected region % [Modify attribute annotation for As Of Date here] off begin

	@CsvCustomBindByName(column = "AS_OF_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "as_of_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The As Of Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for As Of Date here] end
	private OffsetDateTime asOfDate;

	// % protected region % [Modify attribute annotation for Batch Qty Uoi here] off begin
	@CsvBindByName(column = "BATCH_QTY_UOI", required = false)
	@Nullable
	@Column(name = "batch_qty_uoi")
	@Schema(description = "The Batch Qty Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Batch Qty Uoi here] end
	private Double batchQtyUoi;

	// % protected region % [Modify attribute annotation for Uoi here] off begin
	@CsvBindByName(column = "UOI", required = false)
	@Nullable
	@Column(name = "uoi")
	@Schema(description = "The Uoi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Uoi here] end
	private String uoi;

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
			this.stockCatalogue.removeBatchStockBalances(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addBatchStockBalances(this, false);
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
			this.stockCatalogue.removeBatchStockBalances(this, false);
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
			this.warehouse.removeBatchStockBalances(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addBatchStockBalances(this, false);
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
			this.warehouse.removeBatchStockBalances(this, false);
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
		return "BATCH_NO,EXPIRATION_DATE,AS_OF_DATE,BATCH_QTY_UOI,UOI,STOCK_CATALOGUE_ID,WAREHOUSE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object batchStockBalancePerDate) {
		if (this == batchStockBalancePerDate) {
			return true;
		}
		if (batchStockBalancePerDate == null || this.getClass() != batchStockBalancePerDate.getClass()) {
			return false;
		}
		if (!super.equals(batchStockBalancePerDate)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BatchStockBalancePerDateEntity that = (BatchStockBalancePerDateEntity) batchStockBalancePerDate;
		return
			Objects.equals(this.batchNo, that.batchNo) &&
			Objects.equals(
			     this.expirationDate != null ? this.expirationDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.expirationDate != null ? that.expirationDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.asOfDate != null ? this.asOfDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.asOfDate != null ? that.asOfDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.batchQtyUoi, that.batchQtyUoi) &&
			Objects.equals(this.uoi, that.uoi) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
