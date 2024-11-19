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
import kmsweb.dtos.PcareActionExaminationEntityDto;
import kmsweb.entities.listeners.PcareActionExaminationEntityListener;
import kmsweb.serializers.PcareActionExaminationSerializer;
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
@EntityListeners({PcareActionExaminationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareActionExaminationSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"kdtindakansk"}, name = "kdtindakansk"),
	}
)
public class PcareActionExaminationEntity extends AbstractEntity {

	/**
	 * Takes a PcareActionExaminationEntityDto and converts it into a PcareActionExaminationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareActionExaminationEntityDto
	 */
	public PcareActionExaminationEntity(PcareActionExaminationEntityDto pcareActionExaminationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareActionExaminationEntityDto.getId() != null) {
			this.setId(pcareActionExaminationEntityDto.getId());
		}

		if (pcareActionExaminationEntityDto.getActionCode() != null) {
			this.setActionCode(pcareActionExaminationEntityDto.getActionCode());
		}

		if (pcareActionExaminationEntityDto.getFee() != null) {
			this.setFee(pcareActionExaminationEntityDto.getFee());
		}

		if (pcareActionExaminationEntityDto.getNotes() != null) {
			this.setNotes(pcareActionExaminationEntityDto.getNotes());
		}

		if (pcareActionExaminationEntityDto.getKdtindakansk() != null) {
			this.setKdtindakansk(pcareActionExaminationEntityDto.getKdtindakansk());
		}

		if (pcareActionExaminationEntityDto.getHasil() != null) {
			this.setHasil(pcareActionExaminationEntityDto.getHasil());
		}

		if (pcareActionExaminationEntityDto.getPcareExamination() != null) {
			this.setPcareExamination(pcareActionExaminationEntityDto.getPcareExamination());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Action Code here] off begin
	@CsvBindByName(column = "ACTION_CODE", required = false)
	@Nullable
	@Column(name = "action_code")
	@Schema(description = "The Action Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Action Code here] end
	private String actionCode;

	// % protected region % [Modify attribute annotation for Fee here] off begin
	@CsvBindByName(column = "FEE", required = false)
	@Nullable
	@Column(name = "fee")
	@Schema(description = "The Fee of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fee here] end
	private Double fee;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Lob
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	// % protected region % [Modify attribute annotation for kdTindakanSK here] off begin
	@CsvBindByName(column = "KDTINDAKANSK", required = false)
	@Nullable
	@Column(name = "kdtindakansk")
	@Schema(description = "The kdTindakanSK of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdTindakanSK here] end
	private String kdtindakansk;

	// % protected region % [Modify attribute annotation for hasil here] off begin
	@CsvBindByName(column = "HASIL", required = false)
	@Nullable
	@Column(name = "hasil")
	@Schema(description = "The hasil of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for hasil here] end
	private Integer hasil;

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
			this.pcareExamination.removePcareActionExaminations(this, false);
		}
		this.pcareExamination = entity;
		if (reverseAdd) {
			this.pcareExamination.addPcareActionExaminations(this, false);
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
			this.pcareExamination.removePcareActionExaminations(this, false);
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
		return "ACTION_CODE,FEE,NOTES,KDTINDAKANSK,HASIL,PCARE_EXAMINATION_ID,ID";
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
	public boolean equals(Object pcareActionExamination) {
		if (this == pcareActionExamination) {
			return true;
		}
		if (pcareActionExamination == null || this.getClass() != pcareActionExamination.getClass()) {
			return false;
		}
		if (!super.equals(pcareActionExamination)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareActionExaminationEntity that = (PcareActionExaminationEntity) pcareActionExamination;
		return
			Objects.equals(this.actionCode, that.actionCode) &&
			Objects.equals(this.fee, that.fee) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.kdtindakansk, that.kdtindakansk) &&
			Objects.equals(this.hasil, that.hasil) &&
			Objects.equals(this.pcareExaminationId, that.pcareExaminationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
