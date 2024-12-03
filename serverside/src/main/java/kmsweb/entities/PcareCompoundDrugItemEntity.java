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
import kmsweb.dtos.PcareCompoundDrugItemEntityDto;
import kmsweb.entities.listeners.PcareCompoundDrugItemEntityListener;
import kmsweb.serializers.PcareCompoundDrugItemSerializer;
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
@EntityListeners({PcareCompoundDrugItemEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareCompoundDrugItemSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareCompoundDrugItemEntity extends AbstractEntity {

	/**
	 * Takes a PcareCompoundDrugItemEntityDto and converts it into a PcareCompoundDrugItemEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareCompoundDrugItemEntityDto
	 */
	public PcareCompoundDrugItemEntity(PcareCompoundDrugItemEntityDto pcareCompoundDrugItemEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareCompoundDrugItemEntityDto.getId() != null) {
			this.setId(pcareCompoundDrugItemEntityDto.getId());
		}

		if (pcareCompoundDrugItemEntityDto.getDrugCode() != null) {
			this.setDrugCode(pcareCompoundDrugItemEntityDto.getDrugCode());
		}

		if (pcareCompoundDrugItemEntityDto.getDrugQty() != null) {
			this.setDrugQty(pcareCompoundDrugItemEntityDto.getDrugQty());
		}

		if (pcareCompoundDrugItemEntityDto.getRequest() != null) {
			this.setRequest(pcareCompoundDrugItemEntityDto.getRequest());
		}

		if (pcareCompoundDrugItemEntityDto.getDose() != null) {
			this.setDose(pcareCompoundDrugItemEntityDto.getDose());
		}

		if (pcareCompoundDrugItemEntityDto.getPcareCompoundDrug() != null) {
			this.setPcareCompoundDrug(pcareCompoundDrugItemEntityDto.getPcareCompoundDrug());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Drug Code here] off begin
	@CsvBindByName(column = "DRUG_CODE", required = false)
	@Nullable
	@Column(name = "drug_code")
	@Schema(description = "The Drug Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drug Code here] end
	private String drugCode;

	// % protected region % [Modify attribute annotation for Drug Qty here] off begin
	@CsvBindByName(column = "DRUG_QTY", required = false)
	@Nullable
	@Column(name = "drug_qty")
	@Schema(description = "The Drug Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drug Qty here] end
	private Double drugQty;

	// % protected region % [Modify attribute annotation for Request here] off begin
	@CsvBindByName(column = "REQUEST", required = false)
	@Nullable
	@Column(name = "request")
	@Schema(description = "The Request of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Request here] end
	private Double request;

	// % protected region % [Modify attribute annotation for Dose here] off begin
	@CsvBindByName(column = "DOSE", required = false)
	@Nullable
	@Column(name = "dose")
	@Schema(description = "The Dose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dose here] end
	private Double dose;

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

	// % protected region % [Update the annotation for PCare Compound Drug here] off begin
	@Schema(description = "The PCare Compound Drug entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for PCare Compound Drug here] end
	private PcareCompoundDrugEntity pcareCompoundDrug;

	// % protected region % [Update the annotation for pcareCompoundDrugId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PCARE_COMPOUND_DRUG_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for pcareCompoundDrugId here] end
	private UUID pcareCompoundDrugId;

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
	 * Similar to {@link this#setPcareCompoundDrug(PcareCompoundDrugEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be set to this entity
	 */
	public void setPcareCompoundDrug(@NotNull PcareCompoundDrugEntity entity) {
		setPcareCompoundDrug(entity, true);
	}

	/**
	 * Set or update the pcareCompoundDrug in this entity with single PcareCompoundDrugEntity.
	 *
	 * @param entity the given PcareCompoundDrugEntity to be set or updated to pcareCompoundDrug
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPcareCompoundDrug(@NotNull PcareCompoundDrugEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPcareCompoundDrug here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPcareCompoundDrug here] end

		if (sameAsFormer(this.pcareCompoundDrug, entity)) {
			return;
		}

		if (this.pcareCompoundDrug != null) {
			this.pcareCompoundDrug.removePcareCompoundDrugItems(this, false);
		}
		this.pcareCompoundDrug = entity;
		if (reverseAdd) {
			this.pcareCompoundDrug.addPcareCompoundDrugItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPcareCompoundDrug incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPcareCompoundDrug incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPcareCompoundDrug(boolean)} but default to true.
	 */
	public void unsetPcareCompoundDrug() {
		this.unsetPcareCompoundDrug(true);
	}

	/**
	 * Remove PCare Compound Drug in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPcareCompoundDrug(boolean reverse) {
		if (reverse && this.pcareCompoundDrug != null) {
			this.pcareCompoundDrug.removePcareCompoundDrugItems(this, false);
		}
		this.pcareCompoundDrug = null;
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
		return "DRUG_CODE,DRUG_QTY,REQUEST,DOSE,PCARE_COMPOUND_DRUG_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<PcareCompoundDrugEntity> pcareCompoundDrugRelation = Optional.ofNullable(this.pcareCompoundDrug);
		pcareCompoundDrugRelation.ifPresent(entity -> this.pcareCompoundDrugId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object pcareCompoundDrugItem) {
		if (this == pcareCompoundDrugItem) {
			return true;
		}
		if (pcareCompoundDrugItem == null || this.getClass() != pcareCompoundDrugItem.getClass()) {
			return false;
		}
		if (!super.equals(pcareCompoundDrugItem)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareCompoundDrugItemEntity that = (PcareCompoundDrugItemEntity) pcareCompoundDrugItem;
		return
			Objects.equals(this.drugCode, that.drugCode) &&
			Objects.equals(this.drugQty, that.drugQty) &&
			Objects.equals(this.request, that.request) &&
			Objects.equals(this.dose, that.dose) &&
			Objects.equals(this.pcareCompoundDrugId, that.pcareCompoundDrugId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
