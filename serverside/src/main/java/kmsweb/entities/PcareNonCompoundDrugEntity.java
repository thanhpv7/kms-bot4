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
import kmsweb.dtos.PcareNonCompoundDrugEntityDto;
import kmsweb.entities.listeners.PcareNonCompoundDrugEntityListener;
import kmsweb.serializers.PcareNonCompoundDrugSerializer;
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
@EntityListeners({PcareNonCompoundDrugEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareNonCompoundDrugSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareNonCompoundDrugEntity extends AbstractEntity {

	/**
	 * Takes a PcareNonCompoundDrugEntityDto and converts it into a PcareNonCompoundDrugEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareNonCompoundDrugEntityDto
	 */
	public PcareNonCompoundDrugEntity(PcareNonCompoundDrugEntityDto pcareNonCompoundDrugEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareNonCompoundDrugEntityDto.getId() != null) {
			this.setId(pcareNonCompoundDrugEntityDto.getId());
		}

		if (pcareNonCompoundDrugEntityDto.getDrugCode() != null) {
			this.setDrugCode(pcareNonCompoundDrugEntityDto.getDrugCode());
		}

		if (pcareNonCompoundDrugEntityDto.getDrugName() != null) {
			this.setDrugName(pcareNonCompoundDrugEntityDto.getDrugName());
		}

		if (pcareNonCompoundDrugEntityDto.getSignaDays() != null) {
			this.setSignaDays(pcareNonCompoundDrugEntityDto.getSignaDays());
		}

		if (pcareNonCompoundDrugEntityDto.getSignaTimes() != null) {
			this.setSignaTimes(pcareNonCompoundDrugEntityDto.getSignaTimes());
		}

		if (pcareNonCompoundDrugEntityDto.getDrugQty() != null) {
			this.setDrugQty(pcareNonCompoundDrugEntityDto.getDrugQty());
		}

		if (pcareNonCompoundDrugEntityDto.getDay() != null) {
			this.setDay(pcareNonCompoundDrugEntityDto.getDay());
		}

		if (pcareNonCompoundDrugEntityDto.getRequestQty() != null) {
			this.setRequestQty(pcareNonCompoundDrugEntityDto.getRequestQty());
		}

		if (pcareNonCompoundDrugEntityDto.getKdObatSK() != null) {
			this.setKdObatSK(pcareNonCompoundDrugEntityDto.getKdObatSK());
		}

		if (pcareNonCompoundDrugEntityDto.getRacikan() != null) {
			this.setRacikan(pcareNonCompoundDrugEntityDto.getRacikan());
		}

		if (pcareNonCompoundDrugEntityDto.getKdRacikan() != null) {
			this.setKdRacikan(pcareNonCompoundDrugEntityDto.getKdRacikan());
		}

		if (pcareNonCompoundDrugEntityDto.getPcareExamination() != null) {
			this.setPcareExamination(pcareNonCompoundDrugEntityDto.getPcareExamination());
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

	// % protected region % [Modify attribute annotation for Drug Name here] off begin
	@CsvBindByName(column = "DRUG_NAME", required = false)
	@Nullable
	@Column(name = "drug_name")
	@Schema(description = "The Drug Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drug Name here] end
	private String drugName;

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

	// % protected region % [Modify attribute annotation for Drug Qty here] off begin
	@CsvBindByName(column = "DRUG_QTY", required = false)
	@Nullable
	@Column(name = "drug_qty")
	@Schema(description = "The Drug Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drug Qty here] end
	private Double drugQty;

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
			this.pcareExamination.removePcareNonCompoundDrugs(this, false);
		}
		this.pcareExamination = entity;
		if (reverseAdd) {
			this.pcareExamination.addPcareNonCompoundDrugs(this, false);
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
			this.pcareExamination.removePcareNonCompoundDrugs(this, false);
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
		return "DRUG_CODE,DRUG_NAME,SIGNA_DAYS,SIGNA_TIMES,DRUG_QTY,DAY,REQUEST_QTY,KD_OBAT_SK,RACIKAN,KD_RACIKAN,PCARE_EXAMINATION_ID,ID";
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

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object pcareNonCompoundDrug) {
		if (this == pcareNonCompoundDrug) {
			return true;
		}
		if (pcareNonCompoundDrug == null || this.getClass() != pcareNonCompoundDrug.getClass()) {
			return false;
		}
		if (!super.equals(pcareNonCompoundDrug)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareNonCompoundDrugEntity that = (PcareNonCompoundDrugEntity) pcareNonCompoundDrug;
		return
			Objects.equals(this.drugCode, that.drugCode) &&
			Objects.equals(this.drugName, that.drugName) &&
			Objects.equals(this.signaDays, that.signaDays) &&
			Objects.equals(this.signaTimes, that.signaTimes) &&
			Objects.equals(this.drugQty, that.drugQty) &&
			Objects.equals(this.day, that.day) &&
			Objects.equals(this.requestQty, that.requestQty) &&
			Objects.equals(this.kdObatSK, that.kdObatSK) &&
			Objects.equals(this.racikan, that.racikan) &&
			Objects.equals(this.kdRacikan, that.kdRacikan) &&
			Objects.equals(this.pcareExaminationId, that.pcareExaminationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
