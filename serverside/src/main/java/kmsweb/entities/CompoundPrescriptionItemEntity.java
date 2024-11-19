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
import kmsweb.dtos.CompoundPrescriptionItemEntityDto;
import kmsweb.entities.listeners.CompoundPrescriptionItemEntityListener;
import kmsweb.serializers.CompoundPrescriptionItemSerializer;
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
@EntityListeners({CompoundPrescriptionItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = CompoundPrescriptionItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class CompoundPrescriptionItemEntity extends AbstractEntity {

	/**
	 * Takes a CompoundPrescriptionItemEntityDto and converts it into a CompoundPrescriptionItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param compoundPrescriptionItemEntityDto
	 */
	public CompoundPrescriptionItemEntity(CompoundPrescriptionItemEntityDto compoundPrescriptionItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (compoundPrescriptionItemEntityDto.getId() != null) {
			this.setId(compoundPrescriptionItemEntityDto.getId());
		}

		if (compoundPrescriptionItemEntityDto.getDose() != null) {
			this.setDose(compoundPrescriptionItemEntityDto.getDose());
		}

		if (compoundPrescriptionItemEntityDto.getRequestedQuantity() != null) {
			this.setRequestedQuantity(compoundPrescriptionItemEntityDto.getRequestedQuantity());
		}

		if (compoundPrescriptionItemEntityDto.getNotes() != null) {
			this.setNotes(compoundPrescriptionItemEntityDto.getNotes());
		}

		if (compoundPrescriptionItemEntityDto.getCompoundPrescriptionDetail() != null) {
			this.setCompoundPrescriptionDetail(compoundPrescriptionItemEntityDto.getCompoundPrescriptionDetail());
		}

		if (compoundPrescriptionItemEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(compoundPrescriptionItemEntityDto.getStockCatalogue());
		}

		if (compoundPrescriptionItemEntityDto.getUnit() != null) {
			this.setUnit(compoundPrescriptionItemEntityDto.getUnit());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Dose here] off begin
	@CsvBindByName(column = "DOSE", required = false)
	@Nullable
	@Column(name = "dose")
	@Schema(description = "The Dose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dose here] end
	private Integer dose;

	// % protected region % [Modify attribute annotation for Requested Quantity here] off begin
	@CsvBindByName(column = "REQUESTED_QUANTITY", required = false)
	@Nullable
	@Column(name = "requested_quantity")
	@Schema(description = "The Requested Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Requested Quantity here] end
	private Double requestedQuantity;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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

	// % protected region % [Update the annotation for Compound Prescription Detail here] off begin
	@Schema(description = "The Compound Prescription Detail entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Compound Prescription Detail here] end
	private CompoundPrescriptionDetailEntity compoundPrescriptionDetail;

	// % protected region % [Update the annotation for compoundPrescriptionDetailId here] off begin
	@Transient
	@CsvCustomBindByName(column = "COMPOUND_PRESCRIPTION_DETAIL_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for compoundPrescriptionDetailId here] end
	private UUID compoundPrescriptionDetailId;

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

	// % protected region % [Update the annotation for Unit here] off begin
	@Schema(description = "The Unit entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Unit here] end
	private UnitOfMeasurementEntity unit;

	// % protected region % [Update the annotation for unitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "UNIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for unitId here] end
	private UUID unitId;

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
	 * Similar to {@link this#setCompoundPrescriptionDetail(CompoundPrescriptionDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CompoundPrescriptionDetailEntity to be set to this entity
	 */
	public void setCompoundPrescriptionDetail(@NotNull CompoundPrescriptionDetailEntity entity) {
		setCompoundPrescriptionDetail(entity, true);
	}

	/**
	 * Set or update the compoundPrescriptionDetail in this entity with single CompoundPrescriptionDetailEntity.
	 *
	 * @param entity the given CompoundPrescriptionDetailEntity to be set or updated to compoundPrescriptionDetail
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setCompoundPrescriptionDetail(@NotNull CompoundPrescriptionDetailEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setCompoundPrescriptionDetail here] off begin
		// % protected region % [Add any additional logic here before the main logic for setCompoundPrescriptionDetail here] end

		if (sameAsFormer(this.compoundPrescriptionDetail, entity)) {
			return;
		}

		if (this.compoundPrescriptionDetail != null) {
			this.compoundPrescriptionDetail.removeCompoundPrescriptionItems(this, false);
		}
		this.compoundPrescriptionDetail = entity;
		if (reverseAdd) {
			this.compoundPrescriptionDetail.addCompoundPrescriptionItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setCompoundPrescriptionDetail incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setCompoundPrescriptionDetail incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetCompoundPrescriptionDetail(boolean)} but default to true.
	 */
	public void unsetCompoundPrescriptionDetail() {
		this.unsetCompoundPrescriptionDetail(true);
	}

	/**
	 * Remove Compound Prescription Detail in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetCompoundPrescriptionDetail(boolean reverse) {
		if (reverse && this.compoundPrescriptionDetail != null) {
			this.compoundPrescriptionDetail.removeCompoundPrescriptionItems(this, false);
		}
		this.compoundPrescriptionDetail = null;
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
			this.stockCatalogue.removeCompoundPrescriptionItems(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addCompoundPrescriptionItems(this, false);
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
			this.stockCatalogue.removeCompoundPrescriptionItems(this, false);
		}
		this.stockCatalogue = null;
	}
	/**
	 * Similar to {@link this#setUnit(UnitOfMeasurementEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set to this entity
	 */
	public void setUnit(@NotNull UnitOfMeasurementEntity entity) {
		setUnit(entity, true);
	}

	/**
	 * Set or update the unit in this entity with single UnitOfMeasurementEntity.
	 *
	 * @param entity the given UnitOfMeasurementEntity to be set or updated to unit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setUnit(@NotNull UnitOfMeasurementEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setUnit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setUnit here] end

		if (sameAsFormer(this.unit, entity)) {
			return;
		}

		if (this.unit != null) {
			this.unit.removeCompoundPrescriptionItems(this, false);
		}
		this.unit = entity;
		if (reverseAdd) {
			this.unit.addCompoundPrescriptionItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setUnit incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setUnit incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetUnit(boolean)} but default to true.
	 */
	public void unsetUnit() {
		this.unsetUnit(true);
	}

	/**
	 * Remove Unit in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetUnit(boolean reverse) {
		if (reverse && this.unit != null) {
			this.unit.removeCompoundPrescriptionItems(this, false);
		}
		this.unit = null;
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
		return "DOSE,REQUESTED_QUANTITY,NOTES,COMPOUND_PRESCRIPTION_DETAIL_ID,STOCK_CATALOGUE_ID,UNIT_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<CompoundPrescriptionDetailEntity> compoundPrescriptionDetailRelation = Optional.ofNullable(this.compoundPrescriptionDetail);
		compoundPrescriptionDetailRelation.ifPresent(entity -> this.compoundPrescriptionDetailId = entity.getId());

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		Optional<UnitOfMeasurementEntity> unitRelation = Optional.ofNullable(this.unit);
		unitRelation.ifPresent(entity -> this.unitId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object compoundPrescriptionItem) {
		if (this == compoundPrescriptionItem) {
			return true;
		}
		if (compoundPrescriptionItem == null || this.getClass() != compoundPrescriptionItem.getClass()) {
			return false;
		}
		if (!super.equals(compoundPrescriptionItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		CompoundPrescriptionItemEntity that = (CompoundPrescriptionItemEntity) compoundPrescriptionItem;
		return
			Objects.equals(this.dose, that.dose) &&
			Objects.equals(this.requestedQuantity, that.requestedQuantity) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.compoundPrescriptionDetailId, that.compoundPrescriptionDetailId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId) &&
			Objects.equals(this.unitId, that.unitId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
