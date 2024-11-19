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
import kmsweb.dtos.PcareCompoundDrugEntityDto;
import kmsweb.entities.listeners.PcareCompoundDrugEntityListener;
import kmsweb.serializers.PcareCompoundDrugSerializer;
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
@EntityListeners({PcareCompoundDrugEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareCompoundDrugSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareCompoundDrugEntity extends AbstractEntity {

	/**
	 * Takes a PcareCompoundDrugEntityDto and converts it into a PcareCompoundDrugEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareCompoundDrugEntityDto
	 */
	public PcareCompoundDrugEntity(PcareCompoundDrugEntityDto pcareCompoundDrugEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareCompoundDrugEntityDto.getId() != null) {
			this.setId(pcareCompoundDrugEntityDto.getId());
		}

		if (pcareCompoundDrugEntityDto.getCompoundName() != null) {
			this.setCompoundName(pcareCompoundDrugEntityDto.getCompoundName());
		}

		if (pcareCompoundDrugEntityDto.getSignaDays() != null) {
			this.setSignaDays(pcareCompoundDrugEntityDto.getSignaDays());
		}

		if (pcareCompoundDrugEntityDto.getSignaTimes() != null) {
			this.setSignaTimes(pcareCompoundDrugEntityDto.getSignaTimes());
		}

		if (pcareCompoundDrugEntityDto.getPackageQty() != null) {
			this.setPackageQty(pcareCompoundDrugEntityDto.getPackageQty());
		}

		if (pcareCompoundDrugEntityDto.getDay() != null) {
			this.setDay(pcareCompoundDrugEntityDto.getDay());
		}

		if (pcareCompoundDrugEntityDto.getRequestQty() != null) {
			this.setRequestQty(pcareCompoundDrugEntityDto.getRequestQty());
		}

		if (pcareCompoundDrugEntityDto.getKdObatSK() != null) {
			this.setKdObatSK(pcareCompoundDrugEntityDto.getKdObatSK());
		}

		if (pcareCompoundDrugEntityDto.getRacikan() != null) {
			this.setRacikan(pcareCompoundDrugEntityDto.getRacikan());
		}

		if (pcareCompoundDrugEntityDto.getKdRacikan() != null) {
			this.setKdRacikan(pcareCompoundDrugEntityDto.getKdRacikan());
		}

		if (pcareCompoundDrugEntityDto.getNamaObatNonDPHO() != null) {
			this.setNamaObatNonDPHO(pcareCompoundDrugEntityDto.getNamaObatNonDPHO());
		}

		if (pcareCompoundDrugEntityDto.getDrugQty() != null) {
			this.setDrugQty(pcareCompoundDrugEntityDto.getDrugQty());
		}

		if (pcareCompoundDrugEntityDto.getPcareCompoundDrugItems() != null) {
			this.setPcareCompoundDrugItems(pcareCompoundDrugEntityDto.getPcareCompoundDrugItems());
		}

		if (pcareCompoundDrugEntityDto.getPcareExamination() != null) {
			this.setPcareExamination(pcareCompoundDrugEntityDto.getPcareExamination());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Compound Name here] off begin
	@CsvBindByName(column = "COMPOUND_NAME", required = false)
	@Nullable
	@Column(name = "compound_name")
	@Schema(description = "The Compound Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Compound Name here] end
	private String compoundName;

	// % protected region % [Modify attribute annotation for Signa Days here] off begin
	@CsvBindByName(column = "SIGNA_DAYS", required = false)
	@Nullable
	@Column(name = "signa_days")
	@Schema(description = "The Signa Days of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Signa Days here] end
	private Double signaDays;

	// % protected region % [Modify attribute annotation for Signa Times here] off begin
	@CsvBindByName(column = "SIGNA_TIMES", required = false)
	@Nullable
	@Column(name = "signa_times")
	@Schema(description = "The Signa Times of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Signa Times here] end
	private Integer signaTimes;

	// % protected region % [Modify attribute annotation for Package Qty here] off begin
	@CsvBindByName(column = "PACKAGE_QTY", required = false)
	@Nullable
	@Column(name = "package_qty")
	@Schema(description = "The Package Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Package Qty here] end
	private Double packageQty;

	// % protected region % [Modify attribute annotation for Day here] off begin
	@CsvBindByName(column = "DAY", required = false)
	@Nullable
	@Column(name = "day")
	@Schema(description = "The Day of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Day here] end
	private Double day;

	// % protected region % [Modify attribute annotation for Request Qty here] off begin
	@CsvBindByName(column = "REQUEST_QTY", required = false)
	@Nullable
	@Column(name = "request_qty")
	@Schema(description = "The Request Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Request Qty here] end
	private Integer requestQty;

	// % protected region % [Modify attribute annotation for Kd Obat SK here] off begin
	@CsvBindByName(column = "KD_OBAT_SK", required = false)
	@Nullable
	@Column(name = "kd_obat_sk")
	@Schema(description = "The Kd Obat SK of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kd Obat SK here] end
	private String kdObatSK;

	// % protected region % [Modify attribute annotation for Racikan here] off begin
	@CsvBindByName(column = "RACIKAN", required = false)
	@Nullable
	@Column(name = "racikan")
	@Schema(description = "The Racikan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Racikan here] end
	private Boolean racikan = false ;

	// % protected region % [Modify attribute annotation for Kd Racikan here] off begin
	@CsvBindByName(column = "KD_RACIKAN", required = false)
	@Nullable
	@Column(name = "kd_racikan")
	@Schema(description = "The Kd Racikan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kd Racikan here] end
	private String kdRacikan;

	// % protected region % [Modify attribute annotation for Nama Obat Non DPHO here] off begin
	@CsvBindByName(column = "NAMA_OBAT_NON_DPHO", required = false)
	@Nullable
	@Column(name = "nama_obat_non_dpho")
	@Schema(description = "The Nama Obat Non DPHO of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Nama Obat Non DPHO here] end
	private String namaObatNonDPHO;

	// % protected region % [Modify attribute annotation for Drug Qty here] off begin
	@CsvBindByName(column = "DRUG_QTY", required = false)
	@Nullable
	@Column(name = "drug_qty")
	@Schema(description = "The Drug Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drug Qty here] end
	private Double drugQty;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for PCare Compound Drug Items here] off begin
	@Schema(description = "The PCare Compound Drug Item entities that are related to this entity.")
	@OneToMany(mappedBy = "pcareCompoundDrug", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for PCare Compound Drug Items here] end
	private Set<PcareCompoundDrugItemEntity> pcareCompoundDrugItems = new HashSet<>();

	// % protected region % [Update the annotation for pcareCompoundDrugItemsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "PCARE_COMPOUND_DRUG_ITEMS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for pcareCompoundDrugItemsIds here] end
	private Set<UUID> pcareCompoundDrugItemsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for PCare Examination here] off begin
	@Schema(description = "The PCare Examination entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for PCare Examination here] end
	private PcareExaminationEntity pcareExamination;

	// % protected region % [Update the annotation for pcareExaminationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PCARE_EXAMINATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for pcareExaminationId here] end
	private UUID pcareExaminationId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addPcareCompoundDrugItems(PcareCompoundDrugItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugItemEntity to be added to this entity
	 */
	public void addPcareCompoundDrugItems(@NotNull PcareCompoundDrugItemEntity entity) {
		addPcareCompoundDrugItems(entity, true);
	}

	/**
	 * Add a new PcareCompoundDrugItemEntity to pcareCompoundDrugItems in this entity.
	 *
	 * @param entity the given PcareCompoundDrugItemEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addPcareCompoundDrugItems(@NonNull PcareCompoundDrugItemEntity entity, boolean reverseAdd) {
		if (!this.pcareCompoundDrugItems.contains(entity)) {
			pcareCompoundDrugItems.add(entity);
			if (reverseAdd) {
				entity.setPcareCompoundDrug(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addPcareCompoundDrugItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be added to this entity
	 */
	public void addPcareCompoundDrugItems(@NotNull Collection<PcareCompoundDrugItemEntity> entities) {
		addPcareCompoundDrugItems(entities, true);
	}

	/**
	 * Add a new collection of PcareCompoundDrugItemEntity to PCare Compound Drug Items in this entity.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addPcareCompoundDrugItems(@NonNull Collection<PcareCompoundDrugItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addPcareCompoundDrugItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removePcareCompoundDrugItems(PcareCompoundDrugItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareCompoundDrugItemEntity to be set to this entity
	 */
	public void removePcareCompoundDrugItems(@NotNull PcareCompoundDrugItemEntity entity) {
		this.removePcareCompoundDrugItems(entity, true);
	}

	/**
	 * Remove the given PcareCompoundDrugItemEntity from this entity.
	 *
	 * @param entity the given PcareCompoundDrugItemEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removePcareCompoundDrugItems(@NotNull PcareCompoundDrugItemEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPcareCompoundDrug(false);
		}
		this.pcareCompoundDrugItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removePcareCompoundDrugItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be removed to this entity
	 */
	public void removePcareCompoundDrugItems(@NotNull Collection<PcareCompoundDrugItemEntity> entities) {
		this.removePcareCompoundDrugItems(entities, true);
	}

	/**
	 * Remove the given collection of PcareCompoundDrugItemEntity from  to this entity.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removePcareCompoundDrugItems(@NonNull Collection<PcareCompoundDrugItemEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removePcareCompoundDrugItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setPcareCompoundDrugItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to be set to this entity
	 */
	public void setPcareCompoundDrugItems(@NotNull Collection<PcareCompoundDrugItemEntity> entities) {
		setPcareCompoundDrugItems(entities, true);
	}

	/**
	 * Replace the current entities in PCare Compound Drug Items with the given ones.
	 *
	 * @param entities the given collection of PcareCompoundDrugItemEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setPcareCompoundDrugItems(@NotNull Collection<PcareCompoundDrugItemEntity> entities, boolean reverseAdd) {

		this.unsetPcareCompoundDrugItems();
		this.pcareCompoundDrugItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.pcareCompoundDrugItems.forEach(pcareCompoundDrugItemsEntity -> pcareCompoundDrugItemsEntity.setPcareCompoundDrug(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetPcareCompoundDrugItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetPcareCompoundDrugItems() {
		this.unsetPcareCompoundDrugItems(true);
	}

	/**
	 * Remove all the entities in PCare Compound Drug Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetPcareCompoundDrugItems(boolean doReverse) {
		if (doReverse) {
			this.pcareCompoundDrugItems.forEach(pcareCompoundDrugItemsEntity -> pcareCompoundDrugItemsEntity.unsetPcareCompoundDrug(false));
		}
		this.pcareCompoundDrugItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPcareExamination(PcareExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareExaminationEntity to be set to this entity
	 */
	public void setPcareExamination(@NotNull PcareExaminationEntity entity) {
		setPcareExamination(entity, true);
	}

	/**
	 * Set or update the pcareExamination in this entity with single PcareExaminationEntity.
	 *
	 * @param entity the given PcareExaminationEntity to be set or updated to pcareExamination
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPcareExamination(@NotNull PcareExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPcareExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPcareExamination here] end

		if (sameAsFormer(this.pcareExamination, entity)) {
			return;
		}

		if (this.pcareExamination != null) {
			this.pcareExamination.removePcareCompoundDrugs(this, false);
		}
		this.pcareExamination = entity;
		if (reverseAdd) {
			this.pcareExamination.addPcareCompoundDrugs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPcareExamination incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPcareExamination incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPcareExamination(boolean)} but default to true.
	 */
	public void unsetPcareExamination() {
		this.unsetPcareExamination(true);
	}

	/**
	 * Remove PCare Examination in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPcareExamination(boolean reverse) {
		if (reverse && this.pcareExamination != null) {
			this.pcareExamination.removePcareCompoundDrugs(this, false);
		}
		this.pcareExamination = null;
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
		return "COMPOUND_NAME,SIGNA_DAYS,SIGNA_TIMES,PACKAGE_QTY,DAY,REQUEST_QTY,KD_OBAT_SK,RACIKAN,KD_RACIKAN,NAMA_OBAT_NON_DPHO,DRUG_QTY,PCARE_EXAMINATION_ID,PCARE_COMPOUND_DRUG_ITEMS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PcareExaminationEntity> pcareExaminationRelation = Optional.ofNullable(this.pcareExamination);
		pcareExaminationRelation.ifPresent(entity -> this.pcareExaminationId = entity.getId());

		this.pcareCompoundDrugItemsIds = new HashSet<>();
		for (PcareCompoundDrugItemEntity pcareCompoundDrugItems: this.pcareCompoundDrugItems) {
			this.pcareCompoundDrugItemsIds.add(pcareCompoundDrugItems.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object pcareCompoundDrug) {
		if (this == pcareCompoundDrug) {
			return true;
		}
		if (pcareCompoundDrug == null || this.getClass() != pcareCompoundDrug.getClass()) {
			return false;
		}
		if (!super.equals(pcareCompoundDrug)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareCompoundDrugEntity that = (PcareCompoundDrugEntity) pcareCompoundDrug;
		return
			Objects.equals(this.compoundName, that.compoundName) &&
			Objects.equals(this.signaDays, that.signaDays) &&
			Objects.equals(this.signaTimes, that.signaTimes) &&
			Objects.equals(this.packageQty, that.packageQty) &&
			Objects.equals(this.day, that.day) &&
			Objects.equals(this.requestQty, that.requestQty) &&
			Objects.equals(this.kdObatSK, that.kdObatSK) &&
			Objects.equals(this.racikan, that.racikan) &&
			Objects.equals(this.kdRacikan, that.kdRacikan) &&
			Objects.equals(this.namaObatNonDPHO, that.namaObatNonDPHO) &&
			Objects.equals(this.drugQty, that.drugQty) &&
			Objects.equals(this.pcareCompoundDrugItemsIds, that.pcareCompoundDrugItemsIds) &&
			Objects.equals(this.pcareExaminationId, that.pcareExaminationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
