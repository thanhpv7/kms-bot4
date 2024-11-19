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
import kmsweb.dtos.BpjsDrugGenericPRBEntityDto;
import kmsweb.entities.listeners.BpjsDrugGenericPRBEntityListener;
import kmsweb.serializers.BpjsDrugGenericPRBSerializer;
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
@EntityListeners({BpjsDrugGenericPRBEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsDrugGenericPRBSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsDrugGenericPRBEntity extends AbstractEntity {

	/**
	 * Takes a BpjsDrugGenericPRBEntityDto and converts it into a BpjsDrugGenericPRBEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsDrugGenericPRBEntityDto
	 */
	public BpjsDrugGenericPRBEntity(BpjsDrugGenericPRBEntityDto bpjsDrugGenericPRBEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsDrugGenericPRBEntityDto.getId() != null) {
			this.setId(bpjsDrugGenericPRBEntityDto.getId());
		}

		if (bpjsDrugGenericPRBEntityDto.getRefDrugCode() != null) {
			this.setRefDrugCode(bpjsDrugGenericPRBEntityDto.getRefDrugCode());
		}

		if (bpjsDrugGenericPRBEntityDto.getRefDrugName() != null) {
			this.setRefDrugName(bpjsDrugGenericPRBEntityDto.getRefDrugName());
		}

		if (bpjsDrugGenericPRBEntityDto.getBpjsPRBDetails() != null) {
			this.setBpjsPRBDetails(bpjsDrugGenericPRBEntityDto.getBpjsPRBDetails());
		}

		if (bpjsDrugGenericPRBEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(bpjsDrugGenericPRBEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Ref Drug Code here] off begin
	@CsvBindByName(column = "REF_DRUG_CODE", required = false)
	@Nullable
	@Column(name = "ref_drug_code")
	@Schema(description = "The Ref Drug Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Drug Code here] end
	private String refDrugCode;

	// % protected region % [Modify attribute annotation for Ref Drug Name here] off begin
	@CsvBindByName(column = "REF_DRUG_NAME", required = false)
	@Nullable
	@Column(name = "ref_drug_name")
	@Schema(description = "The Ref Drug Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ref Drug Name here] end
	private String refDrugName;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS PRB Details here] off begin
	@Schema(description = "The BPJS PRB Detail entities that are related to this entity.")
	@OneToMany(mappedBy = "bpjsDrugGenericPRB", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS PRB Details here] end
	private Set<BpjsPRBDetailEntity> bpjsPRBDetails = new HashSet<>();

	// % protected region % [Update the annotation for bpjsPRBDetailsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PRB_DETAILS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsPRBDetailsIds here] end
	private Set<UUID> bpjsPRBDetailsIds = new HashSet<>();

	// % protected region % [Update the annotation for Stock Catalogue here] off begin
	@Schema(description = "The Stock Catalogue entities that are related to this entity.")
	@OneToOne(mappedBy = "bpjsDrugGenericPRB", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
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
	 * Similar to {@link this#addBpjsPRBDetails(BpjsPRBDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBDetailEntity to be added to this entity
	 */
	public void addBpjsPRBDetails(@NotNull BpjsPRBDetailEntity entity) {
		addBpjsPRBDetails(entity, true);
	}

	/**
	 * Add a new BpjsPRBDetailEntity to bpjsPRBDetails in this entity.
	 *
	 * @param entity the given BpjsPRBDetailEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsPRBDetails(@NonNull BpjsPRBDetailEntity entity, boolean reverseAdd) {
		if (!this.bpjsPRBDetails.contains(entity)) {
			bpjsPRBDetails.add(entity);
			if (reverseAdd) {
				entity.setBpjsDrugGenericPRB(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsPRBDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be added to this entity
	 */
	public void addBpjsPRBDetails(@NotNull Collection<BpjsPRBDetailEntity> entities) {
		addBpjsPRBDetails(entities, true);
	}

	/**
	 * Add a new collection of BpjsPRBDetailEntity to BPJS PRB Details in this entity.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsPRBDetails(@NonNull Collection<BpjsPRBDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsPRBDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsPRBDetails(BpjsPRBDetailEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPRBDetailEntity to be set to this entity
	 */
	public void removeBpjsPRBDetails(@NotNull BpjsPRBDetailEntity entity) {
		this.removeBpjsPRBDetails(entity, true);
	}

	/**
	 * Remove the given BpjsPRBDetailEntity from this entity.
	 *
	 * @param entity the given BpjsPRBDetailEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsPRBDetails(@NotNull BpjsPRBDetailEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsDrugGenericPRB(false);
		}
		this.bpjsPRBDetails.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsPRBDetails(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be removed to this entity
	 */
	public void removeBpjsPRBDetails(@NotNull Collection<BpjsPRBDetailEntity> entities) {
		this.removeBpjsPRBDetails(entities, true);
	}

	/**
	 * Remove the given collection of BpjsPRBDetailEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsPRBDetails(@NonNull Collection<BpjsPRBDetailEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsPRBDetails(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsPRBDetails(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to be set to this entity
	 */
	public void setBpjsPRBDetails(@NotNull Collection<BpjsPRBDetailEntity> entities) {
		setBpjsPRBDetails(entities, true);
	}

	/**
	 * Replace the current entities in BPJS PRB Details with the given ones.
	 *
	 * @param entities the given collection of BpjsPRBDetailEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsPRBDetails(@NotNull Collection<BpjsPRBDetailEntity> entities, boolean reverseAdd) {

		this.unsetBpjsPRBDetails();
		this.bpjsPRBDetails = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsPRBDetails.forEach(bpjsPRBDetailsEntity -> bpjsPRBDetailsEntity.setBpjsDrugGenericPRB(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsPRBDetails(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsPRBDetails() {
		this.unsetBpjsPRBDetails(true);
	}

	/**
	 * Remove all the entities in BPJS PRB Details from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsPRBDetails(boolean doReverse) {
		if (doReverse) {
			this.bpjsPRBDetails.forEach(bpjsPRBDetailsEntity -> bpjsPRBDetailsEntity.unsetBpjsDrugGenericPRB(false));
		}
		this.bpjsPRBDetails.clear();
	}

	/**
	 * Similar to {@link this#setStockCatalogue(StockCatalogueEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set to this entity
	 */
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity) {
		setStockCatalogue(entity, true);
	}

	/**
	 * Set or update stockCatalogue with the given StockCatalogueEntity.
	 *
	 * @param entity the BpjsDrugGenericPRBEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStockCatalogue(@NotNull StockCatalogueEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStockCatalogue here] end

		if (sameAsFormer(this.stockCatalogue, entity)) {
			return;
		}

		if (this.stockCatalogue != null) {
			this.stockCatalogue.unsetBpjsDrugGenericPRB();
		}

		this.stockCatalogue = entity;

		if (reverseAdd) {
			this.stockCatalogue.setBpjsDrugGenericPRB(this, false);
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
			this.stockCatalogue.unsetBpjsDrugGenericPRB(false);
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
		return "REF_DRUG_CODE,REF_DRUG_NAME,BPJS_PRB_DETAILS_IDS,STOCK_CATALOGUE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.bpjsPRBDetailsIds = new HashSet<>();
		for (BpjsPRBDetailEntity bpjsPRBDetails: this.bpjsPRBDetails) {
			this.bpjsPRBDetailsIds.add(bpjsPRBDetails.getId());
		}

		Optional<StockCatalogueEntity> stockCatalogueRelation = Optional.ofNullable(this.stockCatalogue);
		stockCatalogueRelation.ifPresent(entity -> this.stockCatalogueId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsDrugGenericPRB) {
		if (this == bpjsDrugGenericPRB) {
			return true;
		}
		if (bpjsDrugGenericPRB == null || this.getClass() != bpjsDrugGenericPRB.getClass()) {
			return false;
		}
		if (!super.equals(bpjsDrugGenericPRB)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsDrugGenericPRBEntity that = (BpjsDrugGenericPRBEntity) bpjsDrugGenericPRB;
		return
			Objects.equals(this.refDrugCode, that.refDrugCode) &&
			Objects.equals(this.refDrugName, that.refDrugName) &&
			Objects.equals(this.bpjsPRBDetailsIds, that.bpjsPRBDetailsIds) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
