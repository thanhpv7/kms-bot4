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
import kmsweb.dtos.CatalogueNonMedicalEntityDto;
import kmsweb.entities.listeners.CatalogueNonMedicalEntityListener;
import kmsweb.serializers.CatalogueNonMedicalSerializer;
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
@EntityListeners({CatalogueNonMedicalEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = CatalogueNonMedicalSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class CatalogueNonMedicalEntity extends AbstractEntity {

	/**
	 * Takes a CatalogueNonMedicalEntityDto and converts it into a CatalogueNonMedicalEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param catalogueNonMedicalEntityDto
	 */
	public CatalogueNonMedicalEntity(CatalogueNonMedicalEntityDto catalogueNonMedicalEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (catalogueNonMedicalEntityDto.getId() != null) {
			this.setId(catalogueNonMedicalEntityDto.getId());
		}

		if (catalogueNonMedicalEntityDto.getManufacturer() != null) {
			this.setManufacturer(catalogueNonMedicalEntityDto.getManufacturer());
		}

		if (catalogueNonMedicalEntityDto.getManufacturerItemNumber() != null) {
			this.setManufacturerItemNumber(catalogueNonMedicalEntityDto.getManufacturerItemNumber());
		}

		if (catalogueNonMedicalEntityDto.getIsExpensiveItem() != null) {
			this.setIsExpensiveItem(catalogueNonMedicalEntityDto.getIsExpensiveItem());
		}

		if (catalogueNonMedicalEntityDto.getIsConsignmentItem() != null) {
			this.setIsConsignmentItem(catalogueNonMedicalEntityDto.getIsConsignmentItem());
		}

		if (catalogueNonMedicalEntityDto.getModel() != null) {
			this.setModel(catalogueNonMedicalEntityDto.getModel());
		}

		if (catalogueNonMedicalEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(catalogueNonMedicalEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Manufacturer here] off begin
	@CsvBindByName(column = "MANUFACTURER", required = false)
	@Nullable
	@Column(name = "manufacturer")
	@Schema(description = "The Manufacturer of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Manufacturer here] end
	private String manufacturer;

	// % protected region % [Modify attribute annotation for Manufacturer Item Number here] off begin
	@CsvBindByName(column = "MANUFACTURER_ITEM_NUMBER", required = false)
	@Nullable
	@Column(name = "manufacturer_item_number")
	@Schema(description = "The Manufacturer Item Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Manufacturer Item Number here] end
	private String manufacturerItemNumber;

	// % protected region % [Modify attribute annotation for Is Expensive Item here] off begin
	@CsvBindByName(column = "IS_EXPENSIVE_ITEM", required = false)
	@Nullable
	@Column(name = "is_expensive_item")
	@Schema(description = "The Is Expensive Item of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Expensive Item here] end
	private Boolean isExpensiveItem = false ;

	// % protected region % [Modify attribute annotation for Is Consignment Item here] off begin
	@CsvBindByName(column = "IS_CONSIGNMENT_ITEM", required = false)
	@Nullable
	@Column(name = "is_consignment_item")
	@Schema(description = "The Is Consignment Item of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Consignment Item here] end
	private Boolean isConsignmentItem = false ;

	// % protected region % [Modify attribute annotation for Model here] off begin
	@CsvBindByName(column = "MODEL", required = false)
	@Nullable
	@Column(name = "model")
	@Schema(description = "The Model of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Model here] end
	private String model;

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
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
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
	public void setStockCatalogue(StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update the stockCatalogue in this entity with single StockCatalogueEntity.
	 *
	 * @param entity the given StockCatalogueEntity to be set or updated to stockCatalogue
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.unsetStockCatalogueNonMedical(false);
		}

		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.setStockCatalogueNonMedical(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogue(boolean)} but default to true.
	 */
	public void unsetStockCatalogue() {
		this.unsetStockCatalogue(true);
	}

	/**
	 * Remove the StockCatalogueEntity of stockCatalogue from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogue(boolean reverse) {
		if (reverse && this.stockCatalogue != null) {
			this.stockCatalogue.unsetStockCatalogueNonMedical();
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
		return "MANUFACTURER,MANUFACTURER_ITEM_NUMBER,IS_EXPENSIVE_ITEM,IS_CONSIGNMENT_ITEM,MODEL,STOCK_CATALOGUE_ID,ID";
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

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object catalogueNonMedical) {
		if (this == catalogueNonMedical) {
			return true;
		}
		if (catalogueNonMedical == null || this.getClass() != catalogueNonMedical.getClass()) {
			return false;
		}
		if (!super.equals(catalogueNonMedical)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		CatalogueNonMedicalEntity that = (CatalogueNonMedicalEntity) catalogueNonMedical;
		return
			Objects.equals(this.manufacturer, that.manufacturer) &&
			Objects.equals(this.manufacturerItemNumber, that.manufacturerItemNumber) &&
			Objects.equals(this.isExpensiveItem, that.isExpensiveItem) &&
			Objects.equals(this.isConsignmentItem, that.isConsignmentItem) &&
			Objects.equals(this.model, that.model) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
