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
import kmsweb.dtos.VaccinationOrderDetailEntityDto;
import kmsweb.entities.listeners.VaccinationOrderDetailEntityListener;
import kmsweb.serializers.VaccinationOrderDetailSerializer;
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
@EntityListeners({VaccinationOrderDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = VaccinationOrderDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class VaccinationOrderDetailEntity extends AbstractEntity {

	/**
	 * Takes a VaccinationOrderDetailEntityDto and converts it into a VaccinationOrderDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param vaccinationOrderDetailEntityDto
	 */
	public VaccinationOrderDetailEntity(VaccinationOrderDetailEntityDto vaccinationOrderDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (vaccinationOrderDetailEntityDto.getId() != null) {
			this.setId(vaccinationOrderDetailEntityDto.getId());
		}

		if (vaccinationOrderDetailEntityDto.getVaccinationDate() != null) {
			this.setVaccinationDate(vaccinationOrderDetailEntityDto.getVaccinationDate());
		}

		if (vaccinationOrderDetailEntityDto.getVaccinationType() != null) {
			this.setVaccinationType(vaccinationOrderDetailEntityDto.getVaccinationType());
		}

		if (vaccinationOrderDetailEntityDto.getVaccinationDetail() != null) {
			this.setVaccinationDetail(vaccinationOrderDetailEntityDto.getVaccinationDetail());
		}

		if (vaccinationOrderDetailEntityDto.getQuantity() != null) {
			this.setQuantity(vaccinationOrderDetailEntityDto.getQuantity());
		}

		if (vaccinationOrderDetailEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(vaccinationOrderDetailEntityDto.getStockCatalogue());
		}

		if (vaccinationOrderDetailEntityDto.getVaccinationOrder() != null) {
			this.setVaccinationOrder(vaccinationOrderDetailEntityDto.getVaccinationOrder());
		}

		if (vaccinationOrderDetailEntityDto.getWarehouse() != null) {
			this.setWarehouse(vaccinationOrderDetailEntityDto.getWarehouse());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Vaccination Date here] off begin
	@CsvCustomBindByName(column = "VACCINATION_DATE", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Vaccination Date must not be empty")
	@Column(name = "vaccination_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Vaccination Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vaccination Date here] end
	private OffsetDateTime vaccinationDate;

	// % protected region % [Modify attribute annotation for Vaccination Type here] off begin
	@CsvBindByName(column = "VACCINATION_TYPE", required = true)
	@NotNull(message = "Vaccination Type must not be empty")
	@Column(name = "vaccination_type")
	@Schema(description = "The Vaccination Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vaccination Type here] end
	private String vaccinationType;

	// % protected region % [Modify attribute annotation for Vaccination Detail here] off begin
	@CsvBindByName(column = "VACCINATION_DETAIL", required = true)
	@NotNull(message = "Vaccination Detail must not be empty")
	@Column(name = "vaccination_detail")
	@Schema(description = "The Vaccination Detail of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vaccination Detail here] end
	private String vaccinationDetail;

	// % protected region % [Modify attribute annotation for Quantity here] off begin
	@CsvBindByName(column = "QUANTITY", required = true)
	@NotNull(message = "Quantity must not be empty")
	@Column(name = "quantity")
	@Schema(description = "The Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Quantity here] end
	private Integer quantity;

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

	// % protected region % [Update the annotation for Vaccination Order here] off begin
	@Schema(description = "The Vaccination Order entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Vaccination Order here] end
	private VaccinationOrderEntity vaccinationOrder;

	// % protected region % [Update the annotation for vaccinationOrderId here] off begin
	@Transient
	@CsvCustomBindByName(column = "VACCINATION_ORDER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for vaccinationOrderId here] end
	private UUID vaccinationOrderId;

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
			this.stockCatalogue.removeVaccinationOrderDetails(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addVaccinationOrderDetails(this, false);
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
			this.stockCatalogue.removeVaccinationOrderDetails(this, false);
		}
		this.stockCatalogue = null;
	}
	/**
	 * Similar to {@link this#setVaccinationOrder(VaccinationOrderEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given VaccinationOrderEntity to be set to this entity
	 */
	public void setVaccinationOrder(@NotNull VaccinationOrderEntity entity) {
		setVaccinationOrder(entity, true);
	}

	/**
	 * Set or update the vaccinationOrder in this entity with single VaccinationOrderEntity.
	 *
	 * @param entity the given VaccinationOrderEntity to be set or updated to vaccinationOrder
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setVaccinationOrder(@NotNull VaccinationOrderEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setVaccinationOrder here] off begin
		// % protected region % [Add any additional logic here before the main logic for setVaccinationOrder here] end

		if (sameAsFormer(this.vaccinationOrder, entity)) {
			return;
		}

		if (this.vaccinationOrder != null) {
			this.vaccinationOrder.removeVaccinationOrderDetails(this, false);
		}
		this.vaccinationOrder = entity;
		if (reverseAdd) {
			this.vaccinationOrder.addVaccinationOrderDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setVaccinationOrder incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setVaccinationOrder incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetVaccinationOrder(boolean)} but default to true.
	 */
	public void unsetVaccinationOrder() {
		this.unsetVaccinationOrder(true);
	}

	/**
	 * Remove Vaccination Order in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetVaccinationOrder(boolean reverse) {
		if (reverse && this.vaccinationOrder != null) {
			this.vaccinationOrder.removeVaccinationOrderDetails(this, false);
		}
		this.vaccinationOrder = null;
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
			this.warehouse.removeVaccinationOrderDetails(this, false);
		}
		this.warehouse = entity;
		if (reverseAdd) {
			this.warehouse.addVaccinationOrderDetails(this, false);
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
			this.warehouse.removeVaccinationOrderDetails(this, false);
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
		return "VACCINATION_DATE,VACCINATION_TYPE,VACCINATION_DETAIL,QUANTITY,STOCK_CATALOGUE_ID,VACCINATION_ORDER_ID,WAREHOUSE_ID,ID";
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

		Optional<VaccinationOrderEntity> vaccinationOrderRelation = Optional.ofNullable(this.vaccinationOrder);
		vaccinationOrderRelation.ifPresent(entity -> this.vaccinationOrderId = entity.getId());

		Optional<WarehouseEntity> warehouseRelation = Optional.ofNullable(this.warehouse);
		warehouseRelation.ifPresent(entity -> this.warehouseId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object vaccinationOrderDetail) {
		if (this == vaccinationOrderDetail) {
			return true;
		}
		if (vaccinationOrderDetail == null || this.getClass() != vaccinationOrderDetail.getClass()) {
			return false;
		}
		if (!super.equals(vaccinationOrderDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		VaccinationOrderDetailEntity that = (VaccinationOrderDetailEntity) vaccinationOrderDetail;
		return
			Objects.equals(
			     this.vaccinationDate != null ? this.vaccinationDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.vaccinationDate != null ? that.vaccinationDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.vaccinationType, that.vaccinationType) &&
			Objects.equals(this.vaccinationDetail, that.vaccinationDetail) &&
			Objects.equals(this.quantity, that.quantity) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId) &&
			Objects.equals(this.vaccinationOrderId, that.vaccinationOrderId) &&
			Objects.equals(this.warehouseId, that.warehouseId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
