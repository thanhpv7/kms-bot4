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
import kmsweb.dtos.BpjsPcareDPHOEntityDto;
import kmsweb.entities.listeners.BpjsPcareDPHOEntityListener;
import kmsweb.serializers.BpjsPcareDPHOSerializer;
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
@EntityListeners({BpjsPcareDPHOEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPcareDPHOSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPcareDPHOEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPcareDPHOEntityDto and converts it into a BpjsPcareDPHOEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPcareDPHOEntityDto
	 */
	public BpjsPcareDPHOEntity(BpjsPcareDPHOEntityDto bpjsPcareDPHOEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPcareDPHOEntityDto.getId() != null) {
			this.setId(bpjsPcareDPHOEntityDto.getId());
		}

		if (bpjsPcareDPHOEntityDto.getKdobat() != null) {
			this.setKdobat(bpjsPcareDPHOEntityDto.getKdobat());
		}

		if (bpjsPcareDPHOEntityDto.getNmobat() != null) {
			this.setNmobat(bpjsPcareDPHOEntityDto.getNmobat());
		}

		if (bpjsPcareDPHOEntityDto.getSedia() != null) {
			this.setSedia(bpjsPcareDPHOEntityDto.getSedia());
		}

		if (bpjsPcareDPHOEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(bpjsPcareDPHOEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for kdObat here] off begin
	@CsvBindByName(column = "KDOBAT", required = false)
	@Nullable
	@Column(name = "kdobat")
	@Schema(description = "The kdObat of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdObat here] end
	private String kdobat;

	// % protected region % [Modify attribute annotation for nmObat here] off begin
	@CsvBindByName(column = "NMOBAT", required = false)
	@Nullable
	@Column(name = "nmobat")
	@Schema(description = "The nmObat of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for nmObat here] end
	private String nmobat;

	// % protected region % [Modify attribute annotation for Sedia here] off begin
	@CsvBindByName(column = "SEDIA", required = false)
	@Nullable
	@Column(name = "sedia")
	@Schema(description = "The Sedia of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sedia here] end
	private String sedia;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Stock Catalogue here] off begin
	@Schema(description = "The Stock Catalogue entities that are related to this entity.")
	@OneToOne(mappedBy = "bpjsPcareDPHO", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Stock Catalogue here] end
	private StockCatalogueEntity stockCatalogue;

	// % protected region % [Update the annotation for stockCatalogueId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STOCK_CATALOGUE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for stockCatalogueId here] end
	private UUID stockCatalogueId;

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
	 * Similar to {@link this#setStockCatalogue(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPcareDPHOEntity to be set to this entity
	 */
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update stockCatalogue with the given StockCatalogueEntity.
	 *
	 * @param entity the BpjsPcareDPHOEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.unsetBpjsPcareDPHO();
		}

		this.stockCatalogue = entity;

		if (reverseAdd) {
			this.stockCatalogue.setBpjsPcareDPHO(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStockCatalogue outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetStockCatalogue(boolean)} but default to true.
	 */
	public void unsetStockCatalogue() {
		this.unsetStockCatalogue(true);
	}

	/**
	 * Remove the StockCatalogueEntity in Stock Catalogue from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStockCatalogue(boolean reverse) {
		if (reverse && this.stockCatalogue != null) {
			this.stockCatalogue.unsetBpjsPcareDPHO(false);
		}
		this.stockCatalogue = null;
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
		return "KDOBAT,NMOBAT,SEDIA,STOCK_CATALOGUE_ID,ID";
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
	public boolean equals(Object bpjsPcareDPHO) {
		if (this == bpjsPcareDPHO) {
			return true;
		}
		if (bpjsPcareDPHO == null || this.getClass() != bpjsPcareDPHO.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPcareDPHO)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPcareDPHOEntity that = (BpjsPcareDPHOEntity) bpjsPcareDPHO;
		return
			Objects.equals(this.kdobat, that.kdobat) &&
			Objects.equals(this.nmobat, that.nmobat) &&
			Objects.equals(this.sedia, that.sedia) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
