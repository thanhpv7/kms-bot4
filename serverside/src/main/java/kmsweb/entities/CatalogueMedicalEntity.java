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
import kmsweb.dtos.CatalogueMedicalEntityDto;
import kmsweb.entities.listeners.CatalogueMedicalEntityListener;
import kmsweb.serializers.CatalogueMedicalSerializer;
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
@EntityListeners({CatalogueMedicalEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = CatalogueMedicalSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class CatalogueMedicalEntity extends AbstractEntity {

	/**
	 * Takes a CatalogueMedicalEntityDto and converts it into a CatalogueMedicalEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param catalogueMedicalEntityDto
	 */
	public CatalogueMedicalEntity(CatalogueMedicalEntityDto catalogueMedicalEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (catalogueMedicalEntityDto.getId() != null) {
			this.setId(catalogueMedicalEntityDto.getId());
		}

		if (catalogueMedicalEntityDto.getComposition() != null) {
			this.setComposition(catalogueMedicalEntityDto.getComposition());
		}

		if (catalogueMedicalEntityDto.getCanBePrescribed() != null) {
			this.setCanBePrescribed(catalogueMedicalEntityDto.getCanBePrescribed());
		}

		if (catalogueMedicalEntityDto.getIsHospitalFormulary() != null) {
			this.setIsHospitalFormulary(catalogueMedicalEntityDto.getIsHospitalFormulary());
		}

		if (catalogueMedicalEntityDto.getApprovalNotes() != null) {
			this.setApprovalNotes(catalogueMedicalEntityDto.getApprovalNotes());
		}

		if (catalogueMedicalEntityDto.getIsGeneric() != null) {
			this.setIsGeneric(catalogueMedicalEntityDto.getIsGeneric());
		}

		if (catalogueMedicalEntityDto.getIsRestricted() != null) {
			this.setIsRestricted(catalogueMedicalEntityDto.getIsRestricted());
		}

		if (catalogueMedicalEntityDto.getIsVaccine() != null) {
			this.setIsVaccine(catalogueMedicalEntityDto.getIsVaccine());
		}

		if (catalogueMedicalEntityDto.getVaccineType() != null) {
			this.setVaccineType(catalogueMedicalEntityDto.getVaccineType());
		}

		if (catalogueMedicalEntityDto.getConsumptionMethod() != null) {
			this.setConsumptionMethod(catalogueMedicalEntityDto.getConsumptionMethod());
		}

		if (catalogueMedicalEntityDto.getConsumptionUnit() != null) {
			this.setConsumptionUnit(catalogueMedicalEntityDto.getConsumptionUnit());
		}

		if (catalogueMedicalEntityDto.getCompoundChargingRounding() != null) {
			this.setCompoundChargingRounding(catalogueMedicalEntityDto.getCompoundChargingRounding());
		}

		if (catalogueMedicalEntityDto.getCompoundChargingRoundingAmount() != null) {
			this.setCompoundChargingRoundingAmount(catalogueMedicalEntityDto.getCompoundChargingRoundingAmount());
		}

		if (catalogueMedicalEntityDto.getInventoryRounding() != null) {
			this.setInventoryRounding(catalogueMedicalEntityDto.getInventoryRounding());
		}

		if (catalogueMedicalEntityDto.getInventoryRoundingAmount() != null) {
			this.setInventoryRoundingAmount(catalogueMedicalEntityDto.getInventoryRoundingAmount());
		}

		if (catalogueMedicalEntityDto.getStockCatalogue() != null) {
			this.setStockCatalogue(catalogueMedicalEntityDto.getStockCatalogue());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Composition here] off begin
	@CsvBindByName(column = "COMPOSITION", required = false)
	@Nullable
	@Column(name = "composition")
	@Schema(description = "The Composition of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Composition here] end
	private String composition;

	// % protected region % [Modify attribute annotation for Can be prescribed here] off begin
	@CsvBindByName(column = "CAN_BE_PRESCRIBED", required = false)
	@Nullable
	@Column(name = "can_be_prescribed")
	@Schema(description = "The Can be prescribed of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Can be prescribed here] end
	private Boolean canBePrescribed = false ;

	// % protected region % [Modify attribute annotation for Is Hospital Formulary here] off begin
	@CsvBindByName(column = "IS_HOSPITAL_FORMULARY", required = false)
	@Nullable
	@Column(name = "is_hospital_formulary")
	@Schema(description = "The Is Hospital Formulary of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Hospital Formulary here] end
	private Boolean isHospitalFormulary = false ;

	// % protected region % [Modify attribute annotation for Approval Notes here] off begin
	@CsvBindByName(column = "APPROVAL_NOTES", required = false)
	@Nullable
	@Column(name = "approval_notes")
	@Schema(description = "The Approval Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Approval Notes here] end
	private String approvalNotes;

	// % protected region % [Modify attribute annotation for Is Generic here] off begin
	@CsvBindByName(column = "IS_GENERIC", required = false)
	@Nullable
	@Column(name = "is_generic")
	@Schema(description = "The Is Generic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Generic here] end
	private Boolean isGeneric = false ;

	// % protected region % [Modify attribute annotation for Is Restricted here] off begin
	@CsvBindByName(column = "IS_RESTRICTED", required = false)
	@Nullable
	@Column(name = "is_restricted")
	@Schema(description = "The Is Restricted of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Restricted here] end
	private Boolean isRestricted = false ;

	// % protected region % [Modify attribute annotation for Is Vaccine here] off begin
	@CsvBindByName(column = "IS_VACCINE", required = false)
	@Nullable
	@Column(name = "is_vaccine")
	@Schema(description = "The Is Vaccine of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Vaccine here] end
	private Boolean isVaccine = false ;

	// % protected region % [Modify attribute annotation for Vaccine Type here] off begin
	@CsvBindByName(column = "VACCINE_TYPE", required = false)
	@Nullable
	@Column(name = "vaccine_type")
	@Schema(description = "The Vaccine Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vaccine Type here] end
	private String vaccineType;

	// % protected region % [Modify attribute annotation for Consumption Method here] off begin
	@CsvBindByName(column = "CONSUMPTION_METHOD", required = false)
	@Nullable
	@Column(name = "consumption_method")
	@Schema(description = "The Consumption Method of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consumption Method here] end
	private String consumptionMethod;

	// % protected region % [Modify attribute annotation for Consumption Unit here] off begin
	@CsvBindByName(column = "CONSUMPTION_UNIT", required = false)
	@Nullable
	@Column(name = "consumption_unit")
	@Schema(description = "The Consumption Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Consumption Unit here] end
	private String consumptionUnit;

	// % protected region % [Modify attribute annotation for Compound Charging Rounding here] off begin
	@CsvBindByName(column = "COMPOUND_CHARGING_ROUNDING", required = false)
	@Nullable
	@Column(name = "compound_charging_rounding")
	@Schema(description = "The Compound Charging Rounding of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Compound Charging Rounding here] end
	private Boolean compoundChargingRounding = false ;

	// % protected region % [Modify attribute annotation for Compound Charging Rounding Amount here] off begin
	@CsvBindByName(column = "COMPOUND_CHARGING_ROUNDING_AMOUNT", required = false)
	@Nullable
	@Column(name = "compound_charging_rounding_amount")
	@Schema(description = "The Compound Charging Rounding Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Compound Charging Rounding Amount here] end
	private String compoundChargingRoundingAmount;

	// % protected region % [Modify attribute annotation for Inventory Rounding here] off begin
	@CsvBindByName(column = "INVENTORY_ROUNDING", required = false)
	@Nullable
	@Column(name = "inventory_rounding")
	@Schema(description = "The Inventory Rounding of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inventory Rounding here] end
	private Boolean inventoryRounding = false ;

	// % protected region % [Modify attribute annotation for Inventory Rounding Amount here] off begin
	@CsvBindByName(column = "INVENTORY_ROUNDING_AMOUNT", required = false)
	@Nullable
	@Column(name = "inventory_rounding_amount")
	@Schema(description = "The Inventory Rounding Amount of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Inventory Rounding Amount here] end
	private Double inventoryRoundingAmount;

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
			this.stockCatalogue.unsetStockCatalogueMedical(false);
		}

		this.stockCatalogue = entity;
		if (reverseAdd) {
			this.stockCatalogue.setStockCatalogueMedical(this, false);
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
			this.stockCatalogue.unsetStockCatalogueMedical();
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
		return "COMPOSITION,CAN_BE_PRESCRIBED,IS_HOSPITAL_FORMULARY,APPROVAL_NOTES,IS_GENERIC,IS_RESTRICTED,IS_VACCINE,VACCINE_TYPE,CONSUMPTION_METHOD,CONSUMPTION_UNIT,COMPOUND_CHARGING_ROUNDING,COMPOUND_CHARGING_ROUNDING_AMOUNT,INVENTORY_ROUNDING,INVENTORY_ROUNDING_AMOUNT,STOCK_CATALOGUE_ID,ID";
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
	public boolean equals(Object catalogueMedical) {
		if (this == catalogueMedical) {
			return true;
		}
		if (catalogueMedical == null || this.getClass() != catalogueMedical.getClass()) {
			return false;
		}
		if (!super.equals(catalogueMedical)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		CatalogueMedicalEntity that = (CatalogueMedicalEntity) catalogueMedical;
		return
			Objects.equals(this.composition, that.composition) &&
			Objects.equals(this.canBePrescribed, that.canBePrescribed) &&
			Objects.equals(this.isHospitalFormulary, that.isHospitalFormulary) &&
			Objects.equals(this.approvalNotes, that.approvalNotes) &&
			Objects.equals(this.isGeneric, that.isGeneric) &&
			Objects.equals(this.isRestricted, that.isRestricted) &&
			Objects.equals(this.isVaccine, that.isVaccine) &&
			Objects.equals(this.vaccineType, that.vaccineType) &&
			Objects.equals(this.consumptionMethod, that.consumptionMethod) &&
			Objects.equals(this.consumptionUnit, that.consumptionUnit) &&
			Objects.equals(this.compoundChargingRounding, that.compoundChargingRounding) &&
			Objects.equals(this.compoundChargingRoundingAmount, that.compoundChargingRoundingAmount) &&
			Objects.equals(this.inventoryRounding, that.inventoryRounding) &&
			Objects.equals(this.inventoryRoundingAmount, that.inventoryRoundingAmount) &&
			Objects.equals(this.stockCatalogueId, that.stockCatalogueId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
