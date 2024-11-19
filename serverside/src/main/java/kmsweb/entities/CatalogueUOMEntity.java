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
import kmsweb.dtos.CatalogueUOMEntityDto;
import kmsweb.entities.listeners.CatalogueUOMEntityListener;
import kmsweb.serializers.CatalogueUOMSerializer;
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
@EntityListeners({CatalogueUOMEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = CatalogueUOMSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class CatalogueUOMEntity extends AbstractEntity {

	/**
	 * Takes a CatalogueUOMEntityDto and converts it into a CatalogueUOMEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param catalogueUOMEntityDto
	 */
	public CatalogueUOMEntity(CatalogueUOMEntityDto catalogueUOMEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (catalogueUOMEntityDto.getId() != null) {
			this.setId(catalogueUOMEntityDto.getId());
		}

		if (catalogueUOMEntityDto.getUnitName() != null) {
			this.setUnitName(catalogueUOMEntityDto.getUnitName());
		}

		if (catalogueUOMEntityDto.getConversion() != null) {
			this.setConversion(catalogueUOMEntityDto.getConversion());
		}

		if (catalogueUOMEntityDto.getDefaultTransaction() != null) {
			this.setDefaultTransaction(catalogueUOMEntityDto.getDefaultTransaction());
		}

		if (catalogueUOMEntityDto.getDefaultStockCard() != null) {
			this.setDefaultStockCard(catalogueUOMEntityDto.getDefaultStockCard());
		}

		if (catalogueUOMEntityDto.getDefaultPurchasing() != null) {
			this.setDefaultPurchasing(catalogueUOMEntityDto.getDefaultPurchasing());
		}

		if (catalogueUOMEntityDto.getUnitOfMeasurement() != null) {
			this.setUnitOfMeasurement(catalogueUOMEntityDto.getUnitOfMeasurement());
		}

		if (catalogueUOMEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(catalogueUOMEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Unit Name here] off begin
	@CsvBindByName(column = "UNIT_NAME", required = false)
	@Nullable
	@Column(name = "unit_name")
	@Schema(description = "The Unit Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Unit Name here] end
	private String unitName;

	// % protected region % [Modify attribute annotation for Conversion here] off begin
	@CsvBindByName(column = "CONVERSION", required = false)
	@Nullable
	@Pattern(message = "Must match a valid numeric string",
			regexp = ValidatorPatterns.numeric)
	@Column(name = "conversion")
	@Schema(description = "The Conversion of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Conversion here] end
	private String conversion;

	// % protected region % [Modify attribute annotation for Default Transaction here] off begin
	@CsvBindByName(column = "DEFAULT_TRANSACTION", required = false)
	@Nullable
	@Column(name = "default_transaction")
	@Schema(description = "The Default Transaction of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Default Transaction here] end
	private Boolean defaultTransaction = false ;

	// % protected region % [Modify attribute annotation for Default Stock Card here] off begin
	@CsvBindByName(column = "DEFAULT_STOCK_CARD", required = false)
	@Nullable
	@Column(name = "default_stock_card")
	@Schema(description = "The Default Stock Card of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Default Stock Card here] end
	private Boolean defaultStockCard = false ;

	// % protected region % [Modify attribute annotation for Default Purchasing here] off begin
	@CsvBindByName(column = "DEFAULT_PURCHASING", required = false)
	@Nullable
	@Column(name = "default_purchasing")
	@Schema(description = "The Default Purchasing of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Default Purchasing here] end
	private Boolean defaultPurchasing = false ;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Unit Of Measurement here] off begin
	@Schema(description = "The Unit Of Measurement entities that are related to this entity.")
	@OneToOne(mappedBy = "catalogueUOM", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Unit Of Measurement here] end
	private UnitOfMeasurementEntity unitOfMeasurement;

	// % protected region % [Update the annotation for unitOfMeasurementId here] off begin
	@Transient
	@CsvCustomBindByName(column = "UNIT_OF_MEASUREMENT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for unitOfMeasurementId here] end
	private UUID unitOfMeasurementId;

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

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setUnitOfMeasurement(UnitOfMeasurementEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CatalogueUOMEntity to be set to this entity
	 */
	public void setUnitOfMeasurement(@NotNull UnitOfMeasurementEntity entity) {
		setUnitOfMeasurement(entity, true);
	}

	/**
	 * Set or update unitOfMeasurement with the given UnitOfMeasurementEntity.
	 *
	 * @param entity the CatalogueUOMEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setUnitOfMeasurement(@NotNull UnitOfMeasurementEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setUnitOfMeasurement here] off begin
		// % protected region % [Add any additional logic here before the main logic for setUnitOfMeasurement here] end

		if (sameAsFormer(this.unitOfMeasurement, entity)) {
			return;
		}

		if (this.unitOfMeasurement != null) {
			this.unitOfMeasurement.unsetCatalogueUOM();
		}

		this.unitOfMeasurement = entity;

		if (reverseAdd) {
			this.unitOfMeasurement.setCatalogueUOM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setUnitOfMeasurement outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setUnitOfMeasurement outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetUnitOfMeasurement(boolean)} but default to true.
	 */
	public void unsetUnitOfMeasurement() {
		this.unsetUnitOfMeasurement(true);
	}

	/**
	 * Remove the UnitOfMeasurementEntity in Unit Of Measurement from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetUnitOfMeasurement(boolean reverse) {
		if (reverse && this.unitOfMeasurement != null) {
			this.unitOfMeasurement.unsetCatalogueUOM(false);
		}
		this.unitOfMeasurement = null;
	}
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
			this.stockCatalogue.removeCatalogueUOMs(this, false);
		}
		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.addCatalogueUOMs(this, false);
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
			this.stockCatalogue.removeCatalogueUOMs(this, false);
		}
		this.stockCatalogue = null;
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
		return "UNIT_NAME,CONVERSION,DEFAULT_TRANSACTION,DEFAULT_STOCK_CARD,DEFAULT_PURCHASING,STOCK_CATALOGUE_ID,UNIT_OF_MEASUREMENT_ID,ID";
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

		Optional<UnitOfMeasurementEntity> unitOfMeasurementRelation = Optional.ofNullable(this.unitOfMeasurement);
		unitOfMeasurementRelation.ifPresent(entity -> this.unitOfMeasurementId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object catalogueUOM) {
		if (this == catalogueUOM) {
			return true;
		}
		if (catalogueUOM == null || this.getClass() != catalogueUOM.getClass()) {
			return false;
		}
		if (!super.equals(catalogueUOM)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		CatalogueUOMEntity that = (CatalogueUOMEntity) catalogueUOM;
		return
			Objects.equals(this.unitName, that.unitName) &&
			Objects.equals(this.conversion, that.conversion) &&
			Objects.equals(this.defaultTransaction, that.defaultTransaction) &&
			Objects.equals(this.defaultStockCard, that.defaultStockCard) &&
			Objects.equals(this.defaultPurchasing, that.defaultPurchasing) &&
			Objects.equals(this.unitOfMeasurementId, that.unitOfMeasurementId) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
